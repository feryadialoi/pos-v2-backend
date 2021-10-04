package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.model.criteria.CategoryCriteria;
import com.gdi.posbackend.model.request.CreateCategoryRequest;
import com.gdi.posbackend.model.request.UpdateCategoryRequest;
import com.gdi.posbackend.model.response.CategoryResponse;
import com.gdi.posbackend.security.ApplicationUserDetails;
import com.gdi.posbackend.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.UUID;

/**
 * @author Feryadialoi
 * @date 10/3/2021 12:12 AM
 */
@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
public class CategoryRepositoryTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @MockBean
    private UserDetailsService userDetailsService;

    @BeforeEach
    void setUp() {
        var userDetails = ApplicationUserDetails.builder()
                .id(UUID.randomUUID().toString())
                .username("superadmin")
                .password("password")
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN")))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();

        Mockito.when(userDetailsService.loadUserByUsername("superadmin")).thenReturn(userDetails);
    }

    @Test
    @WithMockUser(username = "superadmin", roles = "SUPER_ADMIN")
    void testGetCategories() throws Exception {

        var categoryCriteria = new CategoryCriteria();
        var page = new PageImpl(List.of(
                new CategoryResponse(UUID.randomUUID().toString(), "Makanan"),
                new CategoryResponse(UUID.randomUUID().toString(), "Minuman")
        ));
        Mockito.when(categoryService.getCategories(categoryCriteria, Pageable.unpaged())).thenReturn(page);

        var requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/categories")
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("get categories success")))
                .andReturn();

        var content = result.getResponse().getContentAsString();
        log.info("response content : {}", content);

    }

    @Test
    @WithMockUser(username = "superadmin", roles = {"SUPER_ADMIN"})
    void testGetCategory() throws Exception {
        var categoryId = UUID.randomUUID().toString();
        var categoryResponse = new CategoryResponse(categoryId, "Makanan");
        Mockito.when(categoryService.getCategory(categoryId)).thenReturn(categoryResponse);

        var requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/categories/" + categoryId)
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("get category success")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id", CoreMatchers.is(categoryId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is("Makanan")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", CoreMatchers.nullValue()))
                .andReturn();

        var content = result.getResponse().getContentAsString();
        log.info("response content : {}", content);

    }

    @Test
    @WithMockUser(username = "superadmin")
    void testCreateCategory() throws Exception {

        var categoryId = UUID.randomUUID().toString();

        var createCategoryRequest = new CreateCategoryRequest("Minuman");
        var categoryResponse = new CategoryResponse(categoryId, "Minuman");
        Mockito.when(categoryService.createCategory(createCategoryRequest)).thenReturn(categoryResponse);

        var json = """
                {
                    "name": "Minuman"
                }
                """;
        var requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/categories")
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("create category success")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id", CoreMatchers.is(categoryId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is("Minuman")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", CoreMatchers.nullValue()))
                .andReturn();

        var content = result.getResponse().getContentAsString();
        log.info("response content : {}", content);
    }

    @Test
    @WithMockUser(username = "superadmin")
    void testUpdateCategory() throws Exception {

        var categoryId = UUID.randomUUID().toString();
        var updateCategoryRequest = new UpdateCategoryRequest("Food");
        var categoryResponse = new CategoryResponse(categoryId, "Food");
        Mockito.when(categoryService.updateCategory(categoryId, updateCategoryRequest)).thenReturn(categoryResponse);

        var json = """
                {
                    "name": "Food"
                }
                """;

        var requestBuilder = MockMvcRequestBuilders
                .put("/api/v1/categories/" + categoryId)
                .content(json)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("update category success")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.id", CoreMatchers.is(categoryId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.name", CoreMatchers.is("Food")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", CoreMatchers.nullValue()))
                .andReturn();

        var content = result.getResponse().getContentAsString();
        log.info("response content : {}", content);
    }

    @Test
    @WithMockUser(username = "superadmin")
    void testDeleteCategory() throws Exception {

        var categoryId = UUID.randomUUID().toString();

        Mockito.when(categoryService.deleteCategory(categoryId)).thenReturn(categoryId);

        var requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/categories/" + categoryId)
                .contentType(MediaType.APPLICATION_JSON);

        var result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("delete category success")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", CoreMatchers.is(categoryId)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", CoreMatchers.nullValue()))
                .andReturn();

        var content = result.getResponse().getContentAsString();
        log.info("response content : {}", content);
    }
}
