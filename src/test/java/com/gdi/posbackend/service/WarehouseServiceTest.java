package com.gdi.posbackend.service;

import com.gdi.posbackend.command.DeleteWarehouseCommand;
import com.gdi.posbackend.model.commandrequest.warehouse.DeleteWarehouseCommandRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:20 AM
 */
@SpringBootTest
class WarehouseServiceTest {

    @Autowired
    private WarehouseService warehouseService;
    @MockBean
    private DeleteWarehouseCommand deleteWarehouseCommand;

    @BeforeEach
    void setUp() {
        DeleteWarehouseCommandRequest deleteWarehouseCommandRequest = new DeleteWarehouseCommandRequest(1L);
        Mockito.when(deleteWarehouseCommand.execute(deleteWarehouseCommandRequest)).thenReturn(1L);
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
    void deleteWarehouse() {
        Long warehouseId = warehouseService.deleteWarehouse(1L);
        Assertions.assertEquals(1L, warehouseId);
    }
}