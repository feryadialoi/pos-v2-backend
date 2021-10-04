package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Category;
import com.gdi.posbackend.model.criteria.CategoryCriteria;
import com.gdi.posbackend.model.response.CategoryResponse;
import com.gdi.posbackend.repository.CategoryRepository;
import com.gdi.posbackend.security.ApplicationUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import org.junit.jupiter.api.Assertions;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;

import java.util.List;
import java.util.UUID;

/**
 * @author Feryadialoi
 * @date 10/3/2021 3:53 AM
 */
@Slf4j
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    void testGetCategories() {
        var categoryCriteria = new CategoryCriteria();
        var pageable = Pageable.unpaged();

        Mockito.when(categoryRepository.findAll(Specification.where(null), pageable)).thenReturn(new PageImpl(List.of(
                new Category("Makanan")
        )));

        Page<CategoryResponse> categories = categoryService.getCategories(categoryCriteria, pageable);

        Assertions.assertNotNull(categories);
        Assertions.assertNotNull(categories.getContent());

        log.info("categories : {}", categories);
    }
}
