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

import java.util.UUID;

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


    private String warehouseId;

    @BeforeEach
    void setUp() {
        warehouseId = UUID.randomUUID().toString();

        DeleteWarehouseCommandRequest deleteWarehouseCommandRequest = new DeleteWarehouseCommandRequest(warehouseId);
        Mockito.when(deleteWarehouseCommand.execute(deleteWarehouseCommandRequest)).thenReturn(warehouseId);
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
        Object result = warehouseService.deleteWarehouse(warehouseId);
        Assertions.assertNotNull(result);
    }
}