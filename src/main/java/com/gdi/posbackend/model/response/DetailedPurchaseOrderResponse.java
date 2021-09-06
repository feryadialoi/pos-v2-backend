package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 4:28 PM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DetailedPurchaseOrderResponse {
    private String id;
    private String code;
    private LocalDateTime entryDate;
    private LocalDateTime dueDate;
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
    private List<PurchaseOrderDetailResponse> purchaseOrderDetails;
    private BigDecimal discount;
    private BigDecimal tax;
    private BigDecimal total;
    private BigDecimal grandTotal;
    private PurchaseOrderStatus status;
}
