package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.SalesmanCriteria;
import com.gdi.posbackend.model.request.CreateSalesmanRequest;
import com.gdi.posbackend.model.request.UpdateSalesmanRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.SalesmanResponse;
import com.gdi.posbackend.service.SalesmanService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:04 PM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/salesmen")
@AllArgsConstructor
public class SalesmanController extends BaseController {

    private final SalesmanService salesmanService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<SalesmanResponse>>> getSalesmen(SalesmanCriteria salesmanCriteria, Pageable pageable) {
        log.info("getSalesman with salesmanCriteria : {}, and pageable : {}", salesmanCriteria, pageable);

        return response("get salesmen success", salesmanService.getSalesmen(salesmanCriteria, pageable));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SalesmanResponse>> createSalesman(@Valid @RequestBody CreateSalesmanRequest createSalesmanRequest) {
        log.info("createSalesman with createSalesmanRequest : {}", createSalesmanRequest);

        return response("create salesman success", salesmanService.createSalesman(createSalesmanRequest));
    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse<List<SalesmanResponse>>> getListSalesman() {
        log.info("getListSalesman");

        return response("get list salesman success", salesmanService.getListSalesman());
    }

    @GetMapping("/{salesmanId}")
    public ResponseEntity<ApiResponse<SalesmanResponse>> getSalesman(@PathVariable(name = "salesmanId") String salesmanId) {
        log.info("getSalesman with salesmanId : {}", salesmanId);

        return response("get salesman success", salesmanService.getSalesman(salesmanId));
    }

    @PutMapping("/{salesmanId}")
    public ResponseEntity<ApiResponse<SalesmanResponse>> updateSalesman(@PathVariable(name = "salesmanId") String salesmanId, @Valid @RequestBody UpdateSalesmanRequest updateSalesmanRequest) {
        log.info("updateSalesman with salesmanId : {}, and updateSalesmanRequest : {}", salesmanId, updateSalesmanRequest);

        return response("update salesman success", salesmanService.updateSalesman(salesmanId, updateSalesmanRequest));
    }

    @DeleteMapping("/{salesmanId}")
    public ResponseEntity<ApiResponse<String>> deleteSalesman(@PathVariable(name = "salesmanId") String salesmanId) {
        log.info("deleteSalesman with salemanId : {}", salesmanId);
        return response("delete salesman success", salesmanService.deleteSalesman(salesmanId));
    }

}
