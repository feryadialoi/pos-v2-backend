package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.entity.enums.TaxFormat;
import com.gdi.posbackend.validation.constraint.ProductOfCreatePurchaseOrderRequestConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 4:29 PM
 */
@Data
public class CreatePurchaseOrderRequest {

    @NotNull
    @NotBlank
    private String supplierId;

    @NotNull
    @NotBlank
    private String entryDate;

    @NotNull
    @NotBlank
    private String dueDate;

    private Integer term;

    private String reference;

    private String note;

    @NotNull
    private PaymentType paymentType;

    private BigDecimal shippingFee;

    private String shippingFeeDescription;

    private BigDecimal otherFee;

    private String otherFeeDescription;

    @NotNull
    @ProductOfCreatePurchaseOrderRequestConstraint
    private List<ProductOfCreatePurchaseOrderRequest> products;

    private PurchaseOrderStatus status;

}
