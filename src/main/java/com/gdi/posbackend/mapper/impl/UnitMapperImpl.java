package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.response.UnitResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:17 AM
 */
@Component
public class UnitMapperImpl implements UnitMapper {

    @Override
    public UnitResponse mapUnitToUnitResponse(Unit unit) {
        if (unit == null) return null;
        return UnitResponse.builder()
                .id(unit.getId())
                .name(unit.getName())
                .build();
    }

}
