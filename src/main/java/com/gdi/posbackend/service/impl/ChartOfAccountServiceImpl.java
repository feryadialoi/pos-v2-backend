package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.mapper.ChartOfAccountMapper;
import com.gdi.posbackend.model.criteria.ChartOfAccountCriteria;
import com.gdi.posbackend.model.request.CreateChartOfAccountRequest;
import com.gdi.posbackend.model.response.ChartOfAccountResponse;
import com.gdi.posbackend.repository.ChartOfAccountRepository;
import com.gdi.posbackend.service.ChartOfAccountService;
import com.gdi.posbackend.specification.ChartOfAccountSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/19/2021 10:14 AM
 */
@Service
@AllArgsConstructor
public class ChartOfAccountServiceImpl implements ChartOfAccountService {

    private final ChartOfAccountRepository chartOfAccountRepository;
    private final ChartOfAccountMapper chartOfAccountMapper;

    @Override
    public Page<ChartOfAccountResponse> getChartOfAccounts(ChartOfAccountCriteria chartOfAccountCriteria, Pageable pageable) {
        Specification<ChartOfAccount> specification = Specification.where(null);
        if (chartOfAccountCriteria.getName() != null) {
            specification = specification.and(ChartOfAccountSpecification.nameIsLike(chartOfAccountCriteria.getName()));
        }

        return chartOfAccountRepository.findAll(specification, pageable).map(chartOfAccountMapper::mapCoaToCoaResponse);
    }

    @Override
    public List<ChartOfAccountResponse> getListChartOfAccount() {
        return chartOfAccountRepository.findAll(Sort.by("path")).stream().map(chartOfAccountMapper::mapCoaToCoaResponse).collect(Collectors.toList());
    }

    @Override
    public ChartOfAccountResponse getChartOfAccount(String chartOfAccountId) {
        return null;
    }

    @Override
    public ChartOfAccountResponse createChartOfAccount(CreateChartOfAccountRequest createChartOfAccountRequest) {
        return null;
    }


}
