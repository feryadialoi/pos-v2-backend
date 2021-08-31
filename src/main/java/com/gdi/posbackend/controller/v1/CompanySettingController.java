package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.CompanySettingCriteria;
import com.gdi.posbackend.model.request.CreateCompanySettingRequest;
import com.gdi.posbackend.model.request.UpdateCompanyRequestWithChartOfAccountRequest;
import com.gdi.posbackend.model.request.UpdateCompanySettingRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.CompanySettingResponse;
import com.gdi.posbackend.model.response.CompanySettingWithChartOfAccountResponse;
import com.gdi.posbackend.service.CompanySettingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


/**
 * @author Feryadialoi
 * @date 8/25/2021 9:58 AM
 */
@RestController
@RequestMapping("/api/v1/company-settings")
@AllArgsConstructor
public class CompanySettingController extends BaseController {

    private final CompanySettingService companySettingService;

    // =========================== standard action ============================

    @PostMapping
    public ResponseEntity<ApiResponse<CompanySettingResponse>> createCompanySetting(@Valid @RequestBody CreateCompanySettingRequest createCompanySettingRequest) {
        return response("create company setting success", companySettingService.createCompanySetting(createCompanySettingRequest));
    }

    @GetMapping("/{companySettingId}")
    public ResponseEntity<ApiResponse<CompanySettingResponse>> getCompanySetting(@PathVariable(name = "companySettingId") String companySettingId) {
        return response("get company setting success", companySettingService.getCompanySetting(companySettingId));
    }

    @PutMapping("/{companySettingId}")
    public ResponseEntity<ApiResponse<CompanySettingResponse>> updateCompanySetting(@PathVariable(name = "companySettingId") String companySettingId, @Valid @RequestBody UpdateCompanySettingRequest updateCompanySettingRequest) {
        return response("update company setting success", companySettingService.updateCompanySetting(companySettingId, updateCompanySettingRequest));
    }

    // =========================== custom action ==============================

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<CompanySettingResponse>>> getListCompanySetting(CompanySettingCriteria companySettingCriteria) {
        return response("get list company setting success", companySettingService.getListCompanySetting(companySettingCriteria));
    }

    @GetMapping("/chart-of-account")
    public ResponseEntity<ApiResponse<List<CompanySettingWithChartOfAccountResponse>>> getListCompanySettingChartOfAccount() {
        return response("get list company setting success", companySettingService.getListCompanySettingChartOfAccount());
    }

    @PutMapping("/batch")
    public ResponseEntity<ApiResponse<Long>> updateBatchCompanySettingWithChartOfAccount(@Valid @RequestBody UpdateCompanyRequestWithChartOfAccountRequest updateCompanyRequestWithChartOfAccountRequest) {
        return response("update company setting with chart of company success", companySettingService.updateCompanySettingWithChartOfAccount(updateCompanyRequestWithChartOfAccountRequest));
    }

}
