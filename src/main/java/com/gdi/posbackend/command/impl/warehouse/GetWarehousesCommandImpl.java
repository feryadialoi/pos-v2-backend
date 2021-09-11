package com.gdi.posbackend.command.impl.warehouse;

import com.gdi.posbackend.command.warehouse.GetWarehousesCommand;
import com.gdi.posbackend.entity.Warehouse;
import com.gdi.posbackend.mapper.WarehouseMapper;
import com.gdi.posbackend.model.commandparam.warehouse.GetWarehousesCommandParam;
import com.gdi.posbackend.model.criteria.WarehouseCriteria;
import com.gdi.posbackend.model.response.WarehouseResponse;
import com.gdi.posbackend.repository.WarehouseRepository;
import com.gdi.posbackend.specification.WarehouseSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static com.gdi.posbackend.specification.WarehouseSpecification.addressIsLike;
import static com.gdi.posbackend.specification.WarehouseSpecification.nameIsLike;
import static org.springframework.data.jpa.domain.Specification.where;

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
    public Page<WarehouseResponse> execute(GetWarehousesCommandParam request) {
        WarehouseCriteria warehouseCriteria = request.getWarehouseCriteria();
        Pageable          pageable          = request.getPageable();

        String name    = warehouseCriteria.getName();
        String address = warehouseCriteria.getAddress();

        Specification<Warehouse> specification = where(null);
        if (name != null) specification = specification.or(nameIsLike(name));
        if (address != null) specification = specification.or(addressIsLike(address));

        return warehouseRepository.findAll(specification, pageable).map(warehouseMapper::mapWarehouseToWarehouseResponse);

    }
}
