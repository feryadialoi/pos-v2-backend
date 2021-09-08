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

        String productCode = productStockCriteria.getProductCode();
        String productName = productStockCriteria.getProductName();
        String productCategoryName = productStockCriteria.getProductCategoryName();
        String warehouseId = productStockCriteria.getWarehouseId();

        if (productCode != null) specification = specification.and(productCodeIsLike(productCode));

        if (productName != null) specification = specification.and(productNameIsLike(productName));

        if (productCategoryName != null)
            specification = specification.and(productCategoryNameIsLike(productCategoryName));

        if (warehouseId != null) specification = specification.and(warehouse(warehouseId));

        Page<ProductStock> page = productStockRepository.findAll(specification, pageable);

        return page.map(productStockMapper::mapProductStockToProductStockResponse);
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
        return productStockRepository.findAll(warehouse(warehouseId), pageable);
    }

    @Override
    public ProductStock getProductStockByWarehouseIdAndId(String warehouseId, String productStockId) {
        return productStockRepository.findOne(warehouse(warehouseId).and(idIs(productStockId)))
                .orElseThrow(() -> new ProductStockNotFoundException("product stock not found with warehouse id "
                        + warehouseId + " and product stock id " + productStockId));
    }

    private ProductStock findProductStockByIdOrThrowNotFound(String productStockId) {
        return productStockRepository.findById(productStockId)
                .orElseThrow(() -> new ProductStockNotFoundException("product stock with id "
                        + productStockId + " not found"));
    }

}
