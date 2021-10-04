package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.controller.core.BaseController;
import com.gdi.posbackend.model.criteria.CategoryCriteria;
import com.gdi.posbackend.model.request.CreateCategoryRequest;
import com.gdi.posbackend.model.request.UpdateCategoryRequest;
import com.gdi.posbackend.model.response.ApiResponse;
import com.gdi.posbackend.model.response.CategoryResponse;
import com.gdi.posbackend.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:17 AM
 */
@Slf4j
@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController extends BaseController {

    private final CategoryService categoryService;

    @PreAuthorize("hasAnyAuthority('ROLE_SUPER_ADMIN', 'GET_CATEGORIES')")
    @GetMapping
    public ResponseEntity<ApiResponse<Page<CategoryResponse>>> getCategories(CategoryCriteria categoryCriteria, Pageable pageable) {
        log.info("getCategories with categoryCriteria : {}, and pageable : {}", categoryCriteria, pageable);

        return response("get categories success", categoryService.getCategories(categoryCriteria, pageable));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> getCategory(@PathVariable(name = "categoryId") String categoryId) {
        log.info("getCategory with categoryId : {}", categoryId);

        return response("get category success", categoryService.getCategory(categoryId));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CategoryResponse>> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest) {
        log.info("createCategory with createCategoryRequest : {}", createCategoryRequest);

        return response("create category success", categoryService.createCategory(createCategoryRequest));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<CategoryResponse>> updateCategory(@PathVariable(name = "categoryId") String categoryId, @Valid @RequestBody UpdateCategoryRequest updateCategoryRequest) {
        log.info("updateCategory with categoryId : {}, and updateCategoryRequest : {}", categoryId, updateCategoryRequest);

        return response("update category success", categoryService.updateCategory(categoryId, updateCategoryRequest));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse<String>> deleteCategory(@PathVariable(name = "categoryId") String categoryId) {
        log.info("deleteCategory with categoryId : {}", categoryId);

        return response("delete category success", categoryService.deleteCategory(categoryId));
    }

}
