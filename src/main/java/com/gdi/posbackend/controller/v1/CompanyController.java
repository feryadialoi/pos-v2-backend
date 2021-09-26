package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.CompanyCriteria;
import com.gdi.posbackend.model.request.CreateCompanyRequest;
import com.gdi.posbackend.model.request.UpdateCompanyRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.CompanyResponse;
import com.gdi.posbackend.model.response.CompanyWithEmployeesResponse;
import com.gdi.posbackend.model.response.CompanyWithUsersResponse;
import com.gdi.posbackend.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/29/2021 4:05 PM
 */
@RestController
@RequestMapping("/api/v1/companies")
@AllArgsConstructor
public class CompanyController extends BaseController {

    // ** service
    private final CompanyService companyService;

    // TODO get company restrict to super admin only
    @GetMapping
    public ResponseEntity<ApiResponse<Page<CompanyResponse>>> getCompanies(CompanyCriteria companyCriteria, Pageable pageable) {
        return response("get companies success", companyService.getCompanies(companyCriteria, pageable));
    }

    // TODO get company restrict to related company only
    @GetMapping("/{companyId}")
    public ResponseEntity<ApiResponse<CompanyResponse>> getCompany(@PathVariable(name = "companyId") String companyId) {
        return response("get company success", companyService.getCompany(companyId));
    }

    // TODO create company restrict to super admin only
    @PostMapping
    public ResponseEntity<ApiResponse<CompanyResponse>> createCompany(@Valid @RequestBody CreateCompanyRequest createCompanyRequest) {
        return response("create company success", companyService.createCompany(createCompanyRequest));
    }

    // TODO update company restrict to related company only
    @PutMapping("/{companyId}")
    public ResponseEntity<ApiResponse<Object>> updateCompany(@PathVariable(name = "companyId") String companyId, @Valid @RequestBody UpdateCompanyRequest updateCompanyRequest) {
        return response("update company success", null);
    }

    // TODO update company restrict to related company only
    @GetMapping("/{companyId}/users")
    public ResponseEntity<ApiResponse<CompanyWithUsersResponse>> getCompanyWithUsers(@PathVariable(name = "companyId") String companyId) {
        return response("get company with users success", companyService.getCompanyWithUsers(companyId));
    }

    // TODO update company restrict to related company only
    @GetMapping("/{companyId}/employees")
    public ResponseEntity<ApiResponse<CompanyWithEmployeesResponse>> getCompanyWithEmployees(@PathVariable(name = "companyId") String companyId) {
        return response("get company with employees success", companyService.getCompanyWithEmployees(companyId));
    }

}
