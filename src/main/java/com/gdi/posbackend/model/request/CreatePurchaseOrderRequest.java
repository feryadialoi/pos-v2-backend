package com.gdi.posbackend.model.request;

import com.gdi.posbackend.configuration.DateTimeFormatConfiguration;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.validation.constraint.SupplierExists;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 4:29 PM
 */
@Data
public class CreatePurchaseOrderRequest {

    @NotBlank
    @SupplierExists
    private String supplierId;

    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateTimeFormat)
    @NotNull
    private LocalDate entryDate;

    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateTimeFormat)
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
    private List<ProductOfCreatePurchaseOrderRequest> products;

    private PurchaseOrderStatus status;

}
