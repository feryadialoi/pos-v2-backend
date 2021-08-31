package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.constant.SettingNameOfCompanySetting;
import com.gdi.posbackend.entity.CompanySetting;
import com.gdi.posbackend.entity.enums.CogsMethod;
import com.gdi.posbackend.service.CogsService;
import com.gdi.posbackend.service.CompanySettingService;
import com.gdi.posbackend.util.CompanySettingValueUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/30/2021 1:10 AM
 */
@Service
@AllArgsConstructor
public class CogsServiceImpl implements CogsService {

    // ** util
    private final CompanySettingValueUtil companySettingValueUtil;

    // ** service
    private final CompanySettingService companySettingService;


    @Override
    public CogsMethod getCogsMethod() {
        CompanySetting companySettingOfCogsMethod = companySettingService.findCompanySettingBySettingNameOrThrowNotFound(
                SettingNameOfCompanySetting.COGS_METHOD.name()
        );

        String CogsMethodSettingValue = (String) companySettingValueUtil.parseCompanySettingValue(
                companySettingOfCogsMethod.getSettingValue(),
                companySettingOfCogsMethod.getSettingValueType()
        );

        return CogsMethod.valueOf(CogsMethodSettingValue);
    }
}
