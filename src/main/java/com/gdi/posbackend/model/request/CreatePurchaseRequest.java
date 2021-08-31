package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.validation.constraint.ProductOfCreatePurchaseOrderRequestConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/20/2021 1:43 AM
 */
@Data
public class CreatePurchaseRequest {

    @NotNull
    @NotBlank
    private String supplierId;

    @NotNull
    @NotBlank
    private String purchaseOrderId;

    @NotNull
    @NotBlank
    private String entryDate;

    @NotNull
    @NotBlank
    private String dueDate;

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
    private List<ProductOfCreatePurchaseRequest> products;

    @NotNull
    private PurchaseStatus status;
}
