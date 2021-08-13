package com.gdi.posbackend.command.impl;

import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.exception.WarehouseNotFoundException;
import com.gdi.posbackend.model.commandrequest.warehouse.DeleteWarehouseCommandRequest;
import com.gdi.posbackend.repository.WarehouseRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:24 AM
 */
@SpringBootTest
class DeleteWarehouseCommandImplTest {

    @Autowired
    private DeleteWarehouseCommandImpl deleteWarehouseCommand;

    @MockBean
    private WarehouseRepository warehouseRepository;

    @BeforeEach
    void setUp() {
        Warehouse warehouse = new Warehouse();
        warehouse.setId(1L);
        warehouse.setName("warehouse");
//        Mockito.when(warehouseRepository.findById(1L)).thenReturn(Optional.of(warehouse));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void execute() {
        Assertions.assertThrows(WarehouseNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                DeleteWarehouseCommandRequest deleteWarehouseCommandRequest = new DeleteWarehouseCommandRequest(1L);
                Long warehouseId = deleteWarehouseCommand.execute(deleteWarehouseCommandRequest);
            }
        });
    }
}