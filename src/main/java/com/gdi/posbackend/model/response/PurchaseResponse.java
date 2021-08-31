package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.entity.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 8/20/2021 1:45 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseResponse {
    private String id;
    private PurchaseOrderResponse purchaseOrder;
    private String code;
    private LocalDateTime entryDate;
    private LocalDateTime dueDate;
    private SupplierResponse supplier;
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
    private PurchaseStatus status;

}
