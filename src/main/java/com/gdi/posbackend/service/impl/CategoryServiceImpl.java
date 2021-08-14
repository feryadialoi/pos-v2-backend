package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.exception.CategoryNotFoundException;
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

        if (categoryCriteria.getName() != null)
            specification = specification.and(CategorySpecification.nameIsLike(categoryCriteria.getName()));

        Page<Category> page = categoryRepository.findAll(specification, pageable);

        return page.map(categoryMapper::mapCategoryToCategoryResponse);
    }

    @Override
    public CategoryResponse getCategory(String categoryId) {
        Optional<Category> optional = categoryRepository.findById(categoryId);
        if (optional.isEmpty()) throw new CategoryNotFoundException("category with id " + categoryId + " not found");

        Category category = optional.get();

        return categoryMapper.mapCategoryToCategoryResponse(category);
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
        Optional<Category> optional = categoryRepository.findById(categoryId);
        if (optional.isEmpty()) throw new CategoryNotFoundException("category with id " + categoryId + " not found");

        Category category = optional.get();
        if (updateCategoryRequest.getName() != null) category.setName(updateCategoryRequest.getName());

        category = categoryRepository.save(category);

        return categoryMapper.mapCategoryToCategoryResponse(category);
    }

    @Override
    public Object deleteCategory(String categoryId) {
        Optional<Category> optional = categoryRepository.findById(categoryId);
        if (optional.isEmpty()) throw new CategoryNotFoundException("category with id " + categoryId + " not found");

        categoryRepository.deleteById(categoryId);

        return categoryId;
    }
}
