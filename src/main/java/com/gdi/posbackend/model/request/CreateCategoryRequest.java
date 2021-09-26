package com.gdi.posbackend.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:24 AM
 */
@Data
public class CreateCategoryRequest {
    @NotBlank
    private String name;
}
