package com.gdi.posbackend.controller.controlleradvice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Feryadialoi
 * @date 7/16/2021 12:40 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotValidDetail {
    private String property;
    private String errorMessage;
}

