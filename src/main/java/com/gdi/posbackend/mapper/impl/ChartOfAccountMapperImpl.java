package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.mapper.ChartOfAccountMapper;
import com.gdi.posbackend.model.response.ChartOfAccountResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/19/2021 10:16 AM
 */
@Component
public class ChartOfAccountMapperImpl implements ChartOfAccountMapper {
    @Override
    public ChartOfAccountResponse mapCoaToCoaResponse(ChartOfAccount coa) {
        return ChartOfAccountResponse.builder()
                .id(coa.getId())
                .name(coa.getName())
                .accountCode(coa.getAccountCode())
                .level(coa.getLevel())
                .path(coa.getPath())
                .build();
    }
}
