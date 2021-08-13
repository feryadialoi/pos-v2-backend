package com.gdi.posbackend.command.impl;

import com.gdi.posbackend.command.GetWarehousesCommand;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.commandrequest.warehouse.GetWarehousesCommandRequest;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.repository.WarehouseRepository;
import com.gdi.posbackend.specification.WarehouseSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 3:35 AM
 */
@Component
@AllArgsConstructor
public class GetWarehousesCommandImpl implements GetWarehousesCommand {

    private final WarehouseRepository warehouseRepository;
    private final WarehouseMapper warehouseMapper;

    @Override
    public Page<WarehouseResponse> execute(GetWarehousesCommandRequest request) {
        WarehouseCriteria warehouseCriteria = request.getWarehouseCriteria();
        Pageable pageable = request.getPageable();

        Specification<Warehouse> specification = Specification.where(null);
        if (warehouseCriteria.getName() != null)
            specification = specification.and(WarehouseSpecification.nameIsLike(warehouseCriteria.getName()));

        if (warehouseCriteria.getAddress() != null)
            specification = specification.and(WarehouseSpecification.addressIsLike(warehouseCriteria.getAddress()));

        Page<Warehouse> page = warehouseRepository.findAll(specification, pageable);


        return page.map(warehouseMapper::mapWarehouseToWarehouseResponse);
    }
}
