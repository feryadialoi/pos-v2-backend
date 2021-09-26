package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:53 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedSaleOrderResponse {
    private String id;
    private String code;
    private LocalDate entryDate;
    private LocalDate dueDate;
    private Integer term;
    private SalesmanResponse salesman;
    private CustomerResponse customer;
    private String reference;
    private String note;
    private String attachment;
    private BigDecimal shippingFee;
    private String shippingFeeDescription;
    private BigDecimal otherFee;
    private String otherFeeDescription;
    private PaymentType paymentType;
    private List<SaleOrderDetailResponse> saleOrderDetails;
    private BigDecimal discount;
    private BigDecimal tax;
    private BigDecimal total;
    private BigDecimal grandTotal;
    private SaleOrderStatus status;
}
