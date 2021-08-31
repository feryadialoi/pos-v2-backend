package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.model.response.ChartOfAccountResponse;

/**
 * @author Feryadialoi
 * @date 8/19/2021 10:16 AM
 */
public interface ChartOfAccountMapper {
    ChartOfAccountResponse mapCoaToCoaResponse(ChartOfAccount coa);
}
