package com.gdi.posbackend.util;

import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/25/2021 11:14 AM
 */
@Component
public class CompanySettingValueUtil {
    public Object parseCompanySettingValue(String value, CompanySettingValueType type) {
        switch (type) {
            case STRING:
                return value;
            case BOOLEAN:
                return Boolean.parseBoolean(value);
            case INTEGER:
                return Integer.parseInt(value);
            case LONG:
                return Long.parseLong(value);
            case FLOAT:
                return Float.parseFloat(value);
            case DOUBLE:
                return Double.parseDouble(value);
            case BIG_DECIMAL:
                return new BigDecimal(value);
            default:
                throw new RuntimeException("not supported type");
        }
    }
}
