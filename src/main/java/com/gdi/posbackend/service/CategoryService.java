package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Category;
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

    CategoryResponse getCategory(String categoryId);

    CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest);

    CategoryResponse updateCategory(String categoryId, UpdateCategoryRequest updateCategoryRequest);

    String deleteCategory(String categoryId);

    Category findCategoryByIdOrThrowNotFound(String categoryId);
}
