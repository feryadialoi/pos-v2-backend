package com.gdi.posbackend.validation;

/**
 * @author Feryadialoi
 * @date 9/9/2021 12:53 PM
 */
public class RegexValidationRule {
    public static final String dateStringFormat = "|\\d{2}-\\d{2}-\\d{4}";
    public static final String dateStringFormatMessage = "Date format not valid, must in format DD-MM-YYYY";
}
