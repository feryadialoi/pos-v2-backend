package com.gdi.posbackend.util;

import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 8/25/2021 11:21 AM
 */
@Slf4j
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanySettingValueUtilTest {

//    @Autowired
    private final CompanySettingValueUtil companySettingValueUtil = new CompanySettingValueUtil();

    @Test
    void testParse() {
        String settingValueString = (String) companySettingValueUtil.parseCompanySettingValue("string", CompanySettingValueType.STRING);
        Integer settingValueInteger = (Integer) companySettingValueUtil.parseCompanySettingValue("1", CompanySettingValueType.INTEGER);
        Boolean settingValueBoolean = (Boolean) companySettingValueUtil.parseCompanySettingValue("true", CompanySettingValueType.BOOLEAN);

        System.out.println(settingValueString);
        System.out.println(settingValueInteger);
        System.out.println(settingValueBoolean);

    }

}