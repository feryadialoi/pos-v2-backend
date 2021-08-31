package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.UnitCriteria;
import com.gdi.posbackend.model.request.CreateUnitRequest;
import com.gdi.posbackend.model.request.UpdateUnitRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.UnitResponse;
import com.gdi.posbackend.service.UnitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:04 AM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/units")
@AllArgsConstructor
public class UnitController extends BaseController {
    private final UnitService unitService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<UnitResponse>>> getUnits(UnitCriteria unitCriteria, Pageable pageable) {
        return response("get units success", unitService.getUnits(unitCriteria, pageable));
    }

    @GetMapping("/{unitId}")
    public ResponseEntity<ApiResponse<UnitResponse>> getUnit(@PathVariable("unitId") String unitId) {
        return response("get unit success", unitService.getUnit(unitId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<UnitResponse>> createUnit(@Valid @RequestBody CreateUnitRequest createUnitRequest) {
        return response("create unit success", unitService.createUnit(createUnitRequest));
    }

    @PutMapping("/{unitId}")
    public ResponseEntity<ApiResponse<UnitResponse>> updateUnit(@PathVariable("unitId") String unitId, @Valid @RequestBody UpdateUnitRequest updateUnitRequest) {
        return response("update unit success", unitService.updateUnit(unitId, updateUnitRequest));
    }

    @DeleteMapping("/{unitId}")
    public ResponseEntity<ApiResponse<Object>> deleteUnit(@PathVariable("unitId") String unitId) {
        return response("delete unit success", unitService.deleteUnit(unitId));
    }

}
