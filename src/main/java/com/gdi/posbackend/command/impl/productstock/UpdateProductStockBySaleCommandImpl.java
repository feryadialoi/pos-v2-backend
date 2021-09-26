package com.gdi.posbackend.command.impl.productstock;

import com.gdi.posbackend.command.productstock.UpdateProductStockBySaleCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.CogsMethod;
import com.gdi.posbackend.entity.enums.ProductStockMutationEvent;
import com.gdi.posbackend.exception.NoCogsMethodProvidedException;
import com.gdi.posbackend.exception.ProductNotFoundException;
import com.gdi.posbackend.exception.ProductStockDetailNotFoundException;
import com.gdi.posbackend.exception.ProductStockInsufficientException;
import com.gdi.posbackend.model.commandparam.UpdateProductStockBySaleCommandParam;
import com.gdi.posbackend.repository.ProductStockDetailRepository;
import com.gdi.posbackend.repository.ProductStockMutationRepository;
import com.gdi.posbackend.repository.ProductStockRepository;
import com.gdi.posbackend.service.CogsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static com.gdi.posbackend.specification.ProductStockDetailSpecification.productStockIdIs;
import static com.gdi.posbackend.specification.ProductStockDetailSpecification.quantityGreaterThan;

/**
 * @author Feryadialoi
 * @date 9/3/2021 3:49 PM
 */
@Component
@Transactional
@AllArgsConstructor
public class UpdateProductStockBySaleCommandImpl implements UpdateProductStockBySaleCommand {

    // ** repository
    private final ProductStockRepository productStockRepository;
    private final ProductStockDetailRepository productStockDetailRepository;
    private final ProductStockMutationRepository productStockMutationRepository;

    // ** service
    private final CogsService cogsService;


    @Override
    public Void execute(UpdateProductStockBySaleCommandParam updateProductStockBySaleCommandParam) {
        Sale sale = updateProductStockBySaleCommandParam.getSale();

        for (SaleDetail saleDetail : sale.getSaleDetails()) {
            updateProductStock(sale, saleDetail);
        }

        return null;
    }

    private ProductStock findProductStockOfProductInRelatedWarehouseAndUnitOrThrowNotFound(SaleDetail saleDetail) {
        return productStockRepository.findProductStockByProductAndWarehouseAndUnit(
                saleDetail.getProduct(),
                saleDetail.getWarehouse(),
                saleDetail.getUnit()
        ).orElseThrow(() -> new ProductNotFoundException("product stock not found"));
    }

    private ProductStockDetail findProductStockDetailByCogsMethod(ProductStock productStock) {
        CogsMethod cogsMethod = cogsService.getCogsMethod();

        if (cogsMethod == CogsMethod.FIFO) return findProductStockDetail(productStock, Sort.Direction.ASC);
        if (cogsMethod == CogsMethod.LIFO) return findProductStockDetail(productStock, Sort.Direction.DESC);
        if (cogsMethod == CogsMethod.WEIGHTED_AVERAGE) return findProductStockDetail(productStock, Sort.Direction.ASC);
        else throw new NoCogsMethodProvidedException("no cogs method provided");
    }

    private ProductStockDetail findProductStockDetail(ProductStock productStock, Sort.Direction sortDirection) {
        Specification<ProductStockDetail> specification = Specification
                .where(productStockIdIs(productStock.getId()))
                .and(quantityGreaterThan(BigDecimal.ZERO));

        Pageable pageable = PageRequest.of(0, 1, Sort.by(sortDirection, ProductStockDetail_.CREATED_DATE));

        return productStockDetailRepository
                .findAll(specification, pageable)
                .stream()
                .findFirst()
                .orElseThrow(() -> new ProductStockDetailNotFoundException(
                        String.format("product stock detail of product stock with id %s and name %s",
                                      productStock.getId(),
                                      productStock.getProduct().getName()))
                );

    }

    private void updateProductStock(Sale sale, SaleDetail saleDetail) {
        ProductStock productStock = findProductStockOfProductInRelatedWarehouseAndUnitOrThrowNotFound(saleDetail);

        checkProductStockIsSufficientOrNot(saleDetail, productStock);

        productStock.setStock(productStock.getStock().subtract(saleDetail.getQuantity()));

        productStockRepository.save(productStock);

        updateProductStockDetail(sale, saleDetail, productStock);
    }

    private void checkProductStockIsSufficientOrNot(SaleDetail saleDetail, ProductStock productStock) throws ProductStockInsufficientException {
        if (productStock.getStock().compareTo(saleDetail.getQuantity()) < 0) {
            throw new ProductStockInsufficientException(String.format("product stock insufficient for product with id %s and with name %s", saleDetail.getProduct().getId(), saleDetail.getProduct().getName()));
        }
    }

    private void updateProductStockDetail(Sale sale, SaleDetail saleDetail, ProductStock productStock) {
        BigDecimal quantity = saleDetail.getQuantity();

        ProductStockDetail productStockDetail = findProductStockDetailByCogsMethod(productStock);

        while (quantity.compareTo(BigDecimal.ZERO) > 0) {

            if (productStockDetail.getQuantity().compareTo(quantity) >= 0) {
                createProductStockMutationOfSale(sale, saleDetail, productStock, quantity, productStockDetail);

                productStockDetail.setQuantity(productStockDetail.getQuantity().subtract(quantity));
                quantity = BigDecimal.ZERO;
                productStockDetailRepository.save(productStockDetail);

            } else {
                createProductStockMutationOfSale(sale, saleDetail, productStock, productStockDetail.getQuantity(), productStockDetail);

                quantity = quantity.subtract(productStockDetail.getQuantity());
                productStockDetail.setQuantity(BigDecimal.ZERO);
                productStockDetailRepository.save(productStockDetail);

                productStockDetail = findProductStockDetailByCogsMethod(productStock);
            }
        }
    }

    private void createProductStockMutationOfSale(Sale sale, SaleDetail saleDetail, ProductStock productStock, BigDecimal quantity, ProductStockDetail productStockDetail) {
        ProductStockMutation productStockMutation = new ProductStockMutation(
                productStock,
                productStockDetail,
                saleDetail.getUnit(),
                BigDecimal.ZERO,
                quantity,
                ProductStockMutationEvent.SALE,
                sale.getReference()
        );

        productStockMutationRepository.save(productStockMutation);
    }


}
