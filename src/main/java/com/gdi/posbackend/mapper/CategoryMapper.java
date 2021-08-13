package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.model.response.CategoryResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 9:47 AM
 */
public interface CategoryMapper {
    CategoryResponse mapCategoryToCategoryResponse(Category category);
}
