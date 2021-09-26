package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:52 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SaleOrderResponse {
    private String id;
    private String code;
    private LocalDate entryDate;
    private LocalDate dueDate;
    private Integer term;
    private SimplifiedSalesmanResponse salesman;
    private CustomerResponse customer;
    private String reference;
    private String note;
    private String attachment;
    private BigDecimal shippingFee;
    private String shippingFeeDescription;
    private BigDecimal otherFee;
    private String otherFeeDescription;
    private PaymentType paymentType;
    private BigDecimal discount;
    private BigDecimal tax;
    private BigDecimal total;
    private BigDecimal grandTotal;
    private SaleOrderStatus status;
}
