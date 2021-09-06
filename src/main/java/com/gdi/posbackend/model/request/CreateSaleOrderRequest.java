package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:53 PM
 */
@Data
public class CreateSaleOrderRequest {
    private String customerId;
    private String salesmanId;
    private String entryDate;
    private String dueDate;
    private Integer term;
    private String reference;
    private String note;
    private PaymentType paymentType;
    private BigDecimal shippingFee;
    private String shippingFeeDescription;
    private BigDecimal otherFee;
    private String otherFeeDescription;
    private List<ProductOfCreateSaleOrderRequest> products;
    private SaleOrderStatus status;
}
