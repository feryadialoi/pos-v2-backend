package com.gdi.posbackend.util;

/**
 * @author Feryadialoi
 * @date 9/15/2021 2:51 PM
 */
public class SpecificationUtil {
    public enum CaseType {
        LOWER, UPPER, DEFAULT
    }

    /**
     * %value%
     * default case LOWER
     * @param value
     * @return
     */
    public static String like(String value) {
        return like(value, CaseType.LOWER);
    }

    public static String like(String value, CaseType caseType) {
        String val = "";
        if (caseType == CaseType.DEFAULT) val = value;
        if (caseType == CaseType.LOWER) val = value.toLowerCase();
        if (caseType == CaseType.UPPER) val = value.toUpperCase();
        return "%" + val + "%";
    }

    /**
     * value%
     *
     * @param value
     * @return
     */
    public static String likeStart(String value) {
        return value + "%";
    }

    /**
     * %value
     *
     * @param value
     * @return
     */
    public static String likeEnd(String value) {
        return "%" + value;
    }
}
