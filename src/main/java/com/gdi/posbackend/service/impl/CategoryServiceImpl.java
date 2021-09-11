package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.exception.CategoryNotFoundException;
import com.gdi.posbackend.exception.CategoryUsedDeleteNotAllowedException;
import com.gdi.posbackend.mapper.CategoryMapper;
import com.gdi.posbackend.model.criteria.CategoryCriteria;
import com.gdi.posbackend.model.request.CreateCategoryRequest;
import com.gdi.posbackend.model.request.UpdateCategoryRequest;
import com.gdi.posbackend.model.response.CategoryResponse;
import com.gdi.posbackend.repository.CategoryRepository;
import com.gdi.posbackend.service.CategoryService;
import com.gdi.posbackend.specification.CategorySpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.gdi.posbackend.specification.CategorySpecification.nameIsLike;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:41 AM
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryResponse> getCategories(CategoryCriteria categoryCriteria, Pageable pageable) {

        Specification<Category> specification = Specification.where(null);

        String name = categoryCriteria.getName();

        if (name != null) specification = specification.and(nameIsLike(name));

        return categoryRepository.findAll(specification, pageable).map(categoryMapper::mapCategoryToCategoryResponse);
    }

    @Override
    public CategoryResponse getCategory(String categoryId) {
        return categoryMapper.mapCategoryToCategoryResponse(findCategoryByIdOrThrowNotFound(categoryId));
    }

    @Override
    public CategoryResponse createCategory(CreateCategoryRequest createCategoryRequest) {
        Category category = new Category();

        category.setName(createCategoryRequest.getName());

        category = categoryRepository.save(category);

        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

    @Override
    public CategoryResponse updateCategory(String categoryId, UpdateCategoryRequest updateCategoryRequest) {
        Category category = findCategoryByIdOrThrowNotFound(categoryId);

        if (updateCategoryRequest.getName() != null) category.setName(updateCategoryRequest.getName());

        category = categoryRepository.save(category);

        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

    @Override
    public String deleteCategory(String categoryId) {
        Category category = findCategoryByIdOrThrowNotFound(categoryId);

        if (categoryRepository.productCountByCategoryId(categoryId) > 0) {
            throw new CategoryUsedDeleteNotAllowedException("category with id " + categoryId + " has relationship and already used in another table");
        }

        categoryRepository.delete(category);

        return categoryId;
    }

    @Override
    public Category findCategoryByIdOrThrowNotFound(String categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryNotFoundException("category with id " + categoryId + " not found"));
    }
}
