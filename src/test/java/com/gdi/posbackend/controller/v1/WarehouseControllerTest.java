package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.security.ApplicationUserDetails;
import com.gdi.posbackend.security.JwtUtil;
import com.gdi.posbackend.service.WarehouseService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * @author Feryadialoi
 * @date 8/5/2021 2:39 AM
 */
//@SpringBootTest
//@AutoConfigureMockMvc
@WebMvcTest(WarehouseController.class)
class WarehouseControllerTest {

    @Autowired
    private MockMvc mvc;

    // mock
    @MockBean
    private WarehouseService warehouseService;
    @MockBean
    private UserDetailsService userDetailsService;
    @MockBean
    private JwtUtil jwtUtil;

    @BeforeEach
    void setUp() {
        String id = UUID.randomUUID().toString();
        ApplicationUserDetails userDetails = ApplicationUserDetails.builder()
                .id(id)
                .username("superadmin")
                .password("password")
                .authorities(List.of(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN")))
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .build();
        Mockito.when(warehouseService.deleteWarehouse("")).thenThrow(new WarehouseNotFoundException("warehouse with id 1 not found"));
        Mockito.when(userDetailsService.loadUserByUsername("")).thenReturn(userDetails);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getWarehouses() {
    }

    @Test
    void getWarehouse() {
    }

    @Test
    void createWarehouse() {
    }

    @Test
    void updateWarehouse() {
    }

    @Test
    @WithMockUser(username = "user", roles = {"VIEWER"})
    void deleteWarehouse() throws Exception {
        String accessToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzdXBlcmFkbWluIiwidG9rZW5JZCI6IjlkNTU0Y2E0LTlkOGItNDljMy1iMTVhLWE4NGU3MmVkODI2NyIsImV4cCI6MTYyODEwOTg0NCwiaWF0IjoxNjI4MTA2MjQ0LCJ1c2VySWQiOjF9.-RcS1l7eObL26J_yWez0r2pEBEQ702JCjjw_wLHHUCrqgLrq4PfEE93iI3R8kti5MkA9ms7jwI8bW7aex5PKpw";
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/v1/warehouses/1")
//                .header(HttpHeaders.AUTHORIZATION, accessToken)
                .contentType(MediaType.APPLICATION_JSON);
        mvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("warehouse delete not allowed")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data", CoreMatchers.nullValue()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", CoreMatchers.is("warehouse with id 1 not found")));

    }
}