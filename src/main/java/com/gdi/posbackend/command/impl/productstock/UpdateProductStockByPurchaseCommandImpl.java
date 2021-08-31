package com.gdi.posbackend.command.impl.productstock;

import com.gdi.posbackend.command.productstock.UpdateProductStockByPurchaseCommand;
import com.gdi.posbackend.entity.*;
import com.gdi.posbackend.entity.enums.ProductStockMutationEvent;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.model.commandparam.UpdateProductStockByPurchaseCommandParam;
import com.gdi.posbackend.repository.ProductRepository;
import com.gdi.posbackend.repository.ProductStockDetailRepository;
import com.gdi.posbackend.repository.ProductStockMutationRepository;
import com.gdi.posbackend.repository.ProductStockRepository;
import com.gdi.posbackend.service.CogsService;
import com.gdi.posbackend.service.RunningNumberService;
import com.gdi.posbackend.service.ServiceExecutor;
import com.gdi.posbackend.util.CompanySettingValueUtil;
import com.gdi.posbackend.util.RunningNumberCodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collections;

/**
 * @author Feryadialoi
 * @date 8/30/2021 2:28 PM
 */
@Component
@Transactional
@AllArgsConstructor
public class UpdateProductStockByPurchaseCommandImpl implements UpdateProductStockByPurchaseCommand {

    // ** repository
    private final ProductStockRepository productStockRepository;
    private final ProductStockMutationRepository productStockMutationRepository;

    // ** util
    private final RunningNumberCodeUtil runningNumberCodeUtil;

    // ** service
    private final RunningNumberService runningNumberService;


    @Override
    public Void execute(UpdateProductStockByPurchaseCommandParam updateProductStockByPurchaseCommandParam) {

        Purchase purchase = updateProductStockByPurchaseCommandParam.getPurchase();

        for (PurchaseDetail purchaseDetail : purchase.getPurchaseDetails()) {

            ProductStock productStock = findOrCreateProductStockOfProductInRelatedWarehouseAndUnit(purchaseDetail.getProduct(), purchaseDetail.getWarehouse(), purchaseDetail.getUnit());

            productStock.setStock(productStock.getStock().add(purchaseDetail.getQuantity()));

            ProductStockDetail productStockDetail = new ProductStockDetail(
                    productStock,
                    purchaseDetail.getQuantity(),
                    runningNumberCodeUtil.getFormattedCode(runningNumberService.getRunningNumber(RunningNumberPrefix.BP))
            );

            productStock.getProductStockDetails().add(productStockDetail);

            productStockRepository.save(productStock);

            ProductStockMutation productStockMutation = new ProductStockMutation(
                    productStock,
                    productStockDetail,
                    purchaseDetail.getUnit(),
                    purchaseDetail.getQuantity(),
                    BigDecimal.ZERO,
                    ProductStockMutationEvent.PURCHASE,
                    purchase.getReference()
            );

            productStockMutationRepository.save(productStockMutation);

        }

        return null;
    }

    private ProductStock findOrCreateProductStockOfProductInRelatedWarehouseAndUnit(Product product, Warehouse warehouse, Unit unit) {
        return productStockRepository.findProductStockByProductAndWarehouseAndUnit(product, warehouse, unit)
                .orElseGet(() -> {
                    ProductStock productStock = new ProductStock();
                    productStock.setProduct(product);
                    productStock.setWarehouse(warehouse);
                    productStock.setUnit(unit);
                    productStock.setStock(BigDecimal.ZERO);
                    productStock.setProductStockDetails(Collections.emptyList());

                    return productStock;
                });
    }

}
