package com.gdi.posbackend.model.criteria;

import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.validation.RegexValidationRule;
import lombok.Data;

import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:16 PM
 */
@Data
public class PurchaseOrderCriteria {

    @Pattern(regexp = RegexValidationRule.dateStringFormat, message = RegexValidationRule.dateStringFormatMessage)
    private String startDate;

    @Pattern(regexp = RegexValidationRule.dateStringFormat, message = RegexValidationRule.dateStringFormatMessage)
    private String endDate;

    private String supplierName;
    private String code;
    private PurchaseOrderStatus status;
    private List<PurchaseOrderStatus> statuses;
}
