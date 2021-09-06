package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.constant.SettingNameOfCompanySetting;
import com.gdi.posbackend.entity.ChartOfAccount;
import com.gdi.posbackend.exception.ChartOfAccountNotFoundException;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/19/2021 10:14 AM
 */
@Service
@Transactional
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
        return chartOfAccountMapper.mapCoaToCoaResponse(findChartOfAccountByIdOrThrowNotFound(chartOfAccountId));
    }

    @Override
    public ChartOfAccountResponse createChartOfAccount(CreateChartOfAccountRequest createChartOfAccountRequest) {
        ChartOfAccount chartOfAccount = new ChartOfAccount();
        chartOfAccount.setName(createChartOfAccountRequest.getName());
        chartOfAccount.setAccountCode(createChartOfAccountRequest.getAccountCode());
        chartOfAccount.setLevel(createChartOfAccountRequest.getLevel());
        chartOfAccount.setNormalBalance(createChartOfAccountRequest.getNormalBalance());
        chartOfAccount.setParent(determineChartOfAccountParent(createChartOfAccountRequest.getParentId()));
        chartOfAccount.setPath(generateChartOfAccountPath(createChartOfAccountRequest));

        chartOfAccount = chartOfAccountRepository.save(chartOfAccount);

        return chartOfAccountMapper.mapCoaToCoaResponse(chartOfAccount);
    }

    @Override
    public ChartOfAccount getChartOfAccountOfCompanySetting(SettingNameOfCompanySetting settingNameOfCompanySetting) {
        return chartOfAccountRepository.findByCompanySetting(settingNameOfCompanySetting.name())
                .orElseThrow(() -> new ChartOfAccountNotFoundException("chart of account by company setting of "
                        + settingNameOfCompanySetting.name()
                        + " not found"));
    }

    private ChartOfAccount findChartOfAccountByIdOrThrowNotFound(String chartOfAccountId) {
        return chartOfAccountRepository.findById(chartOfAccountId)
                .orElseThrow(() -> new ChartOfAccountNotFoundException("chart of account with id "
                        + chartOfAccountId
                        + " not found"));
    }

    private ChartOfAccount determineChartOfAccountParent(String parentId) {
        if (parentId == null) return null;
        return findChartOfAccountByIdOrThrowNotFound(parentId);
    }

    private String generateChartOfAccountPath(CreateChartOfAccountRequest createChartOfAccountRequest) {
        Integer accountCode = createChartOfAccountRequest.getAccountCode();
        String parentId = createChartOfAccountRequest.getParentId();

        if (createChartOfAccountRequest.getParentId() == null) return accountCode + "/";
        return findChartOfAccountByIdOrThrowNotFound(parentId).getPath() + "/" + accountCode;
    }


}
