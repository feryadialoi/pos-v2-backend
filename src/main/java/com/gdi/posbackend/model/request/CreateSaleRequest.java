package com.gdi.posbackend.model.request;

import com.gdi.posbackend.configuration.DateTimeFormatConfiguration;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.SaleStatus;
import com.gdi.posbackend.validation.constraint.CustomerExists;
import com.gdi.posbackend.validation.constraint.SaleOrderExistsIfPresent;
import com.gdi.posbackend.validation.constraint.SaleOrderPresentUnused;
import com.gdi.posbackend.validation.constraint.SalesmanExists;
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
 * @date 8/18/2021 11:47 PM
 */
@Data
@GroupSequence({FirstOrder.class, SecondOrder.class})
public class CreateSaleRequest {

    @SaleOrderExistsIfPresent(groups = {FirstOrder.class})
    @SaleOrderPresentUnused(groups = {SecondOrder.class})
    private String saleOrderId;

    @NotBlank
    @CustomerExists
    private String customerId;

    @NotBlank
    @SalesmanExists
    private String salesmanId;

    @NotNull
    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateTimeFormat)
    private LocalDate entryDate;

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
    private List<ProductOfCreateSaleRequest> products;

    private SaleStatus status;
}
