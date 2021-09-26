package com.gdi.posbackend.model.request;

import com.gdi.posbackend.config.DateConfig;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.SaleOrderStatus;
import com.gdi.posbackend.validation.constraint.CustomerExists;
import com.gdi.posbackend.validation.constraint.SalesmanExists;
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
 * @date 8/18/2021 11:53 PM
 */
@Data
public class CreateSaleOrderRequest {

    @NotBlank
    @CustomerExists
    private String customerId;

    @NotBlank
    @SalesmanExists
    private String salesmanId;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    @NotNull
    private LocalDate entryDate;

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
    private List<ProductOfCreateSaleOrderRequest> products;

    private SaleOrderStatus status;

}
