package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.ChartOfAccountCriteria;
import com.gdi.posbackend.model.request.CreateChartOfAccountRequest;
import com.gdi.posbackend.model.response.ChartOfAccountResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/19/2021 10:12 AM
 */
public interface ChartOfAccountService {
    Page<ChartOfAccountResponse> getChartOfAccounts(ChartOfAccountCriteria chartOfAccountCriteria, Pageable pageable);

    List<ChartOfAccountResponse> getListChartOfAccount();

    ChartOfAccountResponse getChartOfAccount(String chartOfAccountId);

    ChartOfAccountResponse createChartOfAccount(CreateChartOfAccountRequest createChartOfAccountRequest);
}
