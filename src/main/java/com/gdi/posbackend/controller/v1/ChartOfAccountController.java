package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.ChartOfAccountCriteria;
import com.gdi.posbackend.model.request.CreateChartOfAccountRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.ChartOfAccountResponse;
import com.gdi.posbackend.service.ChartOfAccountService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/18/2021 3:29 PM
 */
@RestController
@RequestMapping("/api/v1/chart-of-accounts")
@AllArgsConstructor
public class ChartOfAccountController extends BaseController {

    private final ChartOfAccountService chartOfAccountService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<ChartOfAccountResponse>>> getChartOfAccounts(ChartOfAccountCriteria chartOfAccountCriteria, Pageable pageable) {
        return response("get chart of accounts success", chartOfAccountService.getChartOfAccounts(chartOfAccountCriteria, pageable));
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<ChartOfAccountResponse>>> getListChartOfAccount() {
        return response("get list chart of account success", chartOfAccountService.getListChartOfAccount());
    }

    @GetMapping("/{chartOfAccountId}")
    public ResponseEntity<ApiResponse<ChartOfAccountResponse>> getChartOfAccount(@PathVariable(name = "chartOfAccountId") String chartOfAccountId) {
        return response("get chart of account success", chartOfAccountService.getChartOfAccount(chartOfAccountId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ChartOfAccountResponse>> createChartOfAccount(@Valid @RequestBody CreateChartOfAccountRequest createChartOfAccountRequest) {
        return response("create chart of account success", chartOfAccountService.createChartOfAccount(createChartOfAccountRequest));
    }

}
