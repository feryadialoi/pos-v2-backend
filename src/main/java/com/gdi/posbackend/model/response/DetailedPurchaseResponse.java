package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.entity.enums.PaymentType;
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
 * @date 8/20/2021 1:44 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedPurchaseResponse {
    private String id;
    private PurchaseOrderResponse purchaseOrder;
    private String code;
    private LocalDate entryDate;
    private LocalDate dueDate;
    private Integer term;
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
    private List<PurchaseDetailResponse> purchaseDetails;

}
