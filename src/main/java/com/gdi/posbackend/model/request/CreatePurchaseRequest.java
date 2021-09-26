package com.gdi.posbackend.model.request;

import com.gdi.posbackend.config.DateConfig;
import com.gdi.posbackend.entity.enums.PurchaseStatus;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.validation.constraint.PurchaseOrderExistsIfPresent;
import com.gdi.posbackend.validation.constraint.PurchaseOrderPresentUnused;
import com.gdi.posbackend.validation.constraint.SupplierExists;
import com.gdi.posbackend.validation.groups.FirstOrder;
import com.gdi.posbackend.validation.groups.SecondOrder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.GroupSequence;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/20/2021 1:43 AM
 */
@Data
@GroupSequence({FirstOrder.class, SecondOrder.class})
public class CreatePurchaseRequest {

    @PurchaseOrderExistsIfPresent(groups = {FirstOrder.class})
    @PurchaseOrderPresentUnused(groups = {SecondOrder.class})
    private String purchaseOrderId;

    @NotBlank
    @SupplierExists
    private String supplierId;

    @NotNull
    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate entryDate;

    @NotNull
    @DateTimeFormat(pattern = DateConfig.dateFormat)
    private LocalDate dueDate;

    private Integer term;

    private String reference;

    private String note;

    @NotNull
    private PaymentType paymentType;

    private BigDecimal shippingFee;

    private String shippingFeeDescription;

    private BigDecimal otherFee;

    private String otherFeeDescription;

    @Valid
    @NotNull
    @Size(min = 1)
    private List<ProductOfCreatePurchaseRequest> products;

    private PurchaseStatus status;

}
