package com.gdi.posbackend.controller.v1;

import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.security.ApplicationUserDetails;
import com.gdi.posbackend.security.JwtUtil;
import com.gdi.posbackend.service.PurchaseService;
import com.gdi.posbackend.service.WarehouseService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;
import java.util.UUID;

/**
 * @author Feryadialoi
 * @date 9/6/2021 2:24 PM
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PurchaseControllerTest {

    String json = "{\"status\":\"UNPAID\"," +
            "\"supplierId\":\"8eae911f-80f9-496b-945a-0326b9e02c92\"," +
            "\"purchaseOrderId\":\"399dab36-7b57-473c-9af5-7e7d1512f871\"," +
            "\"entryDate\":\"27-08-2021\"," +
            "\"dueDate\":\"27-08-2021\"," +
            "\"reference\":\"\"," +
            "\"note\":\"\"," +
            "\"paymentType\":\"CREDIT\"," +
            "\"shippingFee\":35000," +
            "\"shippingFeeDescription\":\"Kargo\"," +
            "\"otherFee\":20000," +
            "\"otherFeeDescription\":\"packing\"," +
            "\"products\":[" +
            "{" +
            "\"productId\":\"f4372f64-a0a4-4d67-a90d-4104c4c42df7\"," +
            "\"warehouseId\":\"f6fc136f-75a1-4b84-b7df-ddedcdcd0b8b\"," +
            "\"price\":65000," +
            "\"quantity\":10," +
            "\"unitId\":\"2b594512-1ff1-4a39-8ab4-05583b1051b1\"," +
            "\"discount\":5000," +
            "\"discountFormat\":\"AMOUNT\"," +
            "\"tax\":6000," +
            "\"taxFormat\":\"AMOUNT\"" +
            "}," +
            "{" +
            "\"productId\":\"5f95c13d-03c9-486a-b4a1-3b7a6e79aaba\"," +
            "\"warehouseId\":\"f6fc136f-75a1-4b84-b7df-ddedcdcd0b8b\"," +
            "\"price\":65000," +
            "\"quantity\":10," +
            "\"unitId\":\"2b594512-1ff1-4a39-8ab4-05583b1051b1\"," +
            "\"discount\":5000," +
            "\"discountFormat\":\"AMOUNT\"," +
            "\"tax\":6000," +
            "\"taxFormat\":\"AMOUNT\"" +
            "}," +
            "{" +
            "\"productId\":\"c4f88678-bdc9-4c5a-80bd-72ac5c69577b\"," +
            "\"warehouseId\":\"f6fc136f-75a1-4b84-b7df-ddedcdcd0b8b\"," +
            "\"price\":65000," +
            "\"quantity\":10," +
            "\"unitId\":\"2b594512-1ff1-4a39-8ab4-05583b1051b1\"," +
            "\"discount\":5000," +
            "\"discountFormat\":\"AMOUNT\"," +
            "\"tax\":6000," +
            "\"taxFormat\":\"AMOUNT\"" +
            "}," +
            "{" +
            "\"productId\":\"44ecf692-5db3-4058-9779-562d05c3404d\"," +
            "\"warehouseId\":\"f6fc136f-75a1-4b84-b7df-ddedcdcd0b8b\"," +
            "\"price\":65000," +
            "\"quantity\":10," +
            "\"unitId\":\"2b594512-1ff1-4a39-8ab4-05583b1051b1\"," +
            "\"discount\":5000," +
            "\"discountFormat\":\"AMOUNT\"," +
            "\"tax\":6000," +
            "\"taxFormat\":\"AMOUNT\"" +
            "}," +
            "{" +
            "\"productId\":\"21be2e38-810e-404b-a160-38dd2237778d\"," +
            "\"warehouseId\":\"f6fc136f-75a1-4b84-b7df-ddedcdcd0b8b\"," +
            "\"price\":65000," +
            "\"quantity\":10," +
            "\"unitId\":\"2b594512-1ff1-4a39-8ab4-05583b1051b1\"," +
            "\"discount\":5000," +
            "\"discountFormat\":\"AMOUNT\"," +
            "\"tax\":6000," +
            "\"taxFormat\":\"AMOUNT\"" +
            "}" +
            "]" +
            "}";

    @Autowired
    private PurchaseService purchaseService;

    @Test
    void testCreatePurchase() {

    }


}
