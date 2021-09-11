package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.BaseController;
import com.gdi.posbackend.model.criteria.CategoryCriteria;
import com.gdi.posbackend.model.request.CreateCategoryRequest;
import com.gdi.posbackend.model.request.UpdateCategoryRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.CategoryResponse;
import com.gdi.posbackend.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:17 AM
 */
@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<ApiResponse<Page<CategoryResponse>>> getCategories(CategoryCriteria categoryCriteria, Pageable pageable) {
        return response("get categories success", categoryService.getCategories(categoryCriteria, pageable));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategory(@PathVariable("categoryId") String categoryId) {
        return response("get category success", categoryService.getCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        return response("create category success", categoryService.createCategory(createCategoryRequest));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> updateCategory(@PathVariable("categoryId") String categoryId, @Valid @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        return response("update category success", categoryService.updateCategory(categoryId, updateCategoryRequest));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<String>> deleteCategory(@PathVariable("categoryId") String categoryId) {
        return response("delete category success", categoryService.deleteCategory(categoryId));
    }

}
