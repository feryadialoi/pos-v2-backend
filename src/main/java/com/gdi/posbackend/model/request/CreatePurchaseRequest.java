package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.validation.constraint.ProductOfCreatePurchaseRequestConstraint;
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

    private String purchaseOrderId;

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
    @ProductOfCreatePurchaseRequestConstraint
    private List<ProductOfCreatePurchaseRequest> products;

    private PurchaseStatus status;

}
