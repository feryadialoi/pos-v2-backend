package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import com.gdi.posbackend.validation.RegexValidationRule;
import com.gdi.posbackend.validation.constraint.ProductOfCreatePurchaseOrderRequestConstraint;
import com.gdi.posbackend.validation.constraint.ProductOfCreateSaleOrderRequestConstraint;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:53 PM
 */
@Data
public class CreateSaleOrderRequest {
    @NotNull
    @NotBlank
    private String customerId;

    @NotNull
    @NotBlank
    private String salesmanId;

    @Pattern(regexp = RegexValidationRule.dateStringFormat, message = RegexValidationRule.dateStringFormatMessage)
    @NotNull
    @NotBlank
    private String entryDate;

    @Pattern(regexp = RegexValidationRule.dateStringFormat, message = RegexValidationRule.dateStringFormatMessage)
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
    @ProductOfCreateSaleOrderRequestConstraint
    private List<ProductOfCreateSaleOrderRequest> products;

    private SaleOrderStatus status;

}
