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
import java.util.UUID;

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

    private String warehouseId;

    @BeforeEach
    void setUp() {
        warehouseId = UUID.randomUUID().toString();

        Warehouse warehouse = new Warehouse();
        warehouse.setId(UUID.randomUUID().toString());
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
                DeleteWarehouseCommandRequest deleteWarehouseCommandRequest = new DeleteWarehouseCommandRequest("");
                String warehouseId = deleteWarehouseCommand.execute(deleteWarehouseCommandRequest);
            }
        });
    }
}