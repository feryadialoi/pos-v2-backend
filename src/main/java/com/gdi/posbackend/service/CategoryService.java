package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.CategoryCriteria;
import com.gdi.posbackend.model.request.CreateCategoryRequest;
import com.gdi.posbackend.model.request.UpdateCategoryRequest;
import com.gdi.posbackend.model.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/5/2021 5:23 AM
 */
public interface CategoryService {
    Page<CategoryResponse> getCategories(CategoryCriteria categoryCriteria, Pageable pageable);

    CategoryResponse getCategory(Long categoryId);

    CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

    CategoryResponse updateCategory(Long categoryId, UpdateCategoryRequest updateCategoryRequest);

    Object deleteCategory(Long categoryId);

}
