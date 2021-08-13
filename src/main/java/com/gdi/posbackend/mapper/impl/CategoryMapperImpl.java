package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.mapper.CategoryMapper;
import com.gdi.posbackend.model.response.CategoryResponse;
import org.hibernate.validator.constraints.CodePointLength;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:48 AM
 */
@Component
public class CategoryMapperImpl implements CategoryMapper {
    @Override
    public CategoryResponse mapCategoryToCategoryResponse(Category category) {
        if (category == null) return null;
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
