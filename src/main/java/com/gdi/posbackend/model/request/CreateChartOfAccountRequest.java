package com.gdi.posbackend.model.request;

import com.gdi.posbackend.entity.enums.NormalBalance;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:33 PM
 */
@Data
public class CreateChartOfAccountRequest {

    @NotBlank
    private String name;

    @NotNull
    private Integer accountCode;

    @NotNull
    @Range(min = 1, max = 3)
    private Integer level;

    private String parentId;

    @NotNull
    private NormalBalance normalBalance;
}
