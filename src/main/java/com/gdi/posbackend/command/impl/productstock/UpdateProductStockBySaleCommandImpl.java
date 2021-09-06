package com.gdi.posbackend.command.impl.productstock;

import com.gdi.posbackend.command.productstock.UpdateProductStockBySaleCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.CogsMethod;
import com.gdi.posbackend.entity.enums.ProductStockMutationEvent;
import com.gdi.posbackend.exception.ProductNotFoundException;
import com.gdi.posbackend.exception.ProductStockDetailNotFoundException;
import com.gdi.posbackend.exception.ProductStockInsufficientException;
import com.gdi.posbackend.model.commandparam.UpdateProductStockBySaleCommandParam;
import com.gdi.posbackend.repository.ProductStockDetailRepository;
import com.gdi.posbackend.repository.ProductStockMutationRepository;
import com.gdi.posbackend.repository.ProductStockRepository;
import com.gdi.posbackend.service.CogsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;

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
        ).orElseThrow(() -> new ProductNotFoundException("product "));
    }

    private ProductStockDetail findProductStockDetailByProductStock(ProductStock productStock) {
        CogsMethod cogsMethod = cogsService.getCogsMethod();

        Optional<ProductStockDetail> optional = Optional.empty();

        if (cogsMethod == CogsMethod.FIFO) {
            optional = productStockDetailRepository.findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateAsc(productStock, BigDecimal.ZERO);
        } else if (cogsMethod == CogsMethod.LIFO) {
            optional = productStockDetailRepository.findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateDesc(productStock, BigDecimal.ZERO);
        } else if (cogsMethod == CogsMethod.WEIGHTED_AVERAGE) {
            optional = productStockDetailRepository.findProductStockDetailByProductStockAndQuantityGreaterThanOrderByCreatedDateDesc(productStock, BigDecimal.ZERO);
        }

        return optional.orElseThrow(() -> new ProductStockDetailNotFoundException("product stock detail of product stock with id "
                + productStock.getId()
                + " and name "
                + productStock.getProduct().getName()
        ));
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
            throw new ProductStockInsufficientException("product stock insufficient for product with id "
                    + saleDetail.getProduct().getId()
                    + " and with name "
                    + saleDetail.getProduct().getName()
            );
        }
    }

    private void updateProductStockDetail(Sale sale, SaleDetail saleDetail, ProductStock productStock) {
        BigDecimal quantity = saleDetail.getQuantity();

        ProductStockDetail productStockDetail = findProductStockDetailByProductStock(productStock);

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

                productStockDetail = findProductStockDetailByProductStock(productStock);
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
