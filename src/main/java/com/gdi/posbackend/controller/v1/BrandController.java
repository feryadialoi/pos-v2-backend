package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.BrandCriteria;
import com.gdi.posbackend.model.request.CreateBrandRequest;
import com.gdi.posbackend.model.request.UpdateBrandRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.BrandResponse;
import com.gdi.posbackend.service.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/13/2021 2:07 PM
 */
@RestController
@RequestMapping("/api/v1/brands")
@AllArgsConstructor
public class BrandController extends BaseController {
    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<BrandResponse>, Object>> getBrands(BrandCriteria brandCriteria, Pageable pageable) {
        return response("get brands success", brandService.getBrands(brandCriteria, pageable));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BrandResponse, Object>> createBrand(@Valid @RequestBody CreateBrandRequest createBrandRequest) {
        return response("create brand success", brandService.createBrand(createBrandRequest));
    }

    @GetMapping("/{brandId}")
    public ResponseEntity<ApiResponse<BrandResponse, Object>> getBrand(@PathVariable(name = "brandId") String brandId) {
        return response("get brand success", brandService.getBrand(brandId));
    }

    @PutMapping("/{brandId}")
    public ResponseEntity<ApiResponse<BrandResponse, Object>> updateBrand(@PathVariable(name = "brandId") String brandId,
                                                                          @Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
        return response("update brand success", brandService.updateBrand(brandId, updateBrandRequest));
    }

    @DeleteMapping("/{brandId}")
    public Object deleteBrand(@PathVariable(name = "brandId") String branId) {
        return response("delete brand success", brandService.deleteBrand(branId));
    }
}
