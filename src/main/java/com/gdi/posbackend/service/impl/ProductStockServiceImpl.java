package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.productstock.UpdateProductStockByPurchaseCommand;
import com.gdi.posbackend.command.productstock.UpdateProductStockBySaleCommand;
import com.gdi.posbackend.entity.ProductStock;
import com.gdi.posbackend.entity.Purchase;
import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.exception.ProductStockNotFoundException;
import com.gdi.posbackend.mapper.ProductStockMapper;
import com.gdi.posbackend.model.commandparam.UpdateProductStockByPurchaseCommandParam;
import com.gdi.posbackend.model.commandparam.UpdateProductStockBySaleCommandParam;
import com.gdi.posbackend.model.criteria.ProductStockCriteria;
import com.gdi.posbackend.model.request.UpdateProductStockRequest;
import com.gdi.posbackend.model.response.DetailedProductStockResponse;
import com.gdi.posbackend.model.response.ProductStockResponse;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.repository.ProductStockDetailRepository;
import com.gdi.posbackend.repository.ProductStockRepository;
import com.gdi.posbackend.service.CogsService;
import com.gdi.posbackend.service.ProductStockService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.gdi.posbackend.specification.ProductStockSpecification.*;

/**
 * @author Feryadialoi
 * @date 8/6/2021 2:03 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class ProductStockServiceImpl implements ProductStockService {

    // ** repository
    private final ProductRepository productRepository;
    private final ProductStockRepository productStockRepository;
    private final ProductStockDetailRepository productStockDetailRepository;

    // ** service
    private final CogsService cogsService;
    private final ServiceExecutor serviceExecutor;

    // ** mapper
    private final ProductStockMapper productStockMapper;


    @Override
    public Page<ProductStockResponse> getProductStocks(ProductStockCriteria productStockCriteria, Pageable pageable) {
        Specification<ProductStock> specification = Specification.where(null);

        if (productStockCriteria.getProductCode() != null)
            specification = specification.and(productCodeIsLike(productStockCriteria.getProductCode()));
        if (productStockCriteria.getProductName() != null)
            specification = specification.and(productNameIsLike(productStockCriteria.getProductName()));
        if (productStockCriteria.getProductCategoryName() != null)
            specification = specification.and(productCategoryNameIsLike(productStockCriteria.getProductCategoryName()));
        if (productStockCriteria.getWarehouseId() != null)
            specification = specification.and(warehouseIdIs(productStockCriteria.getWarehouseId()));
        if (productStockCriteria.getStock() != null)
            specification = specification.and(stockIs(productStockCriteria.getStock()));
        if (productStockCriteria.getStockGe() != null)
            specification = specification.and(stockGe(productStockCriteria.getStockGe()));
        if (productStockCriteria.getStockGt() != null)
            specification = specification.and(stockGt(productStockCriteria.getStockGt()));
        if (productStockCriteria.getStockLe() != null)
            specification = specification.and(stockLe(productStockCriteria.getStockLe()));
        if (productStockCriteria.getStockLt() != null)
            specification = specification.and(stockLt(productStockCriteria.getStockLt()));

        return productStockRepository.findAll(specification, pageable).map(productStockMapper::mapProductStockToProductStockResponse);

    }

    @Override
    public DetailedProductStockResponse getProductStock(String productStockId) {
        return productStockMapper.mapProductStockToDetailedProductStockResponse(findProductStockByIdOrThrowNotFound(productStockId));
    }

    @Override
    public Object updateProductStock(String productStockId, UpdateProductStockRequest updateProductStockRequest) {
        return null;
    }

    @Override
    public void updateProductStockByPurchase(Purchase purchase) {
        serviceExecutor.execute(UpdateProductStockByPurchaseCommand.class, new UpdateProductStockByPurchaseCommandParam(purchase));
    }

    @Override
    public void updateProductStockBySale(Sale sale) {
        serviceExecutor.execute(UpdateProductStockBySaleCommand.class, new UpdateProductStockBySaleCommandParam(sale));
    }

    @Override
    public Page<ProductStock> getProductStocksByWarehouseId(String warehouseId, Pageable pageable) {
        return productStockRepository.findAll(warehouseIdIs(warehouseId), pageable);
    }

    @Override
    public ProductStock getProductStockByIdAndWarehouseId(String productStockId, String warehouseId) {
        return productStockRepository
                .findOne(warehouseIdIs(warehouseId).and(idIs(productStockId)))
                .orElseThrow(() -> new ProductStockNotFoundException(String.format("product stock not found with warehouse id %s and product stock id %s", warehouseId, productStockId)));
    }

    @Override
    public ProductStock getProductStockByProductIdAndWarehouseId(String productId, String warehouseId) {
        return productStockRepository
                .findOne(productIdIs(productId).and(warehouseIdIs(warehouseId)))
                .orElseThrow(() -> new ProductStockNotFoundException(String.format("product stock with product id %s and warehouse id %s not found", productId, warehouseId)));
    }

    private ProductStock findProductStockByIdOrThrowNotFound(String productStockId) {
        return productStockRepository
                .findById(productStockId)
                .orElseThrow(() -> new ProductStockNotFoundException(String.format("product stock with id %s not found", productStockId)));
    }

}
