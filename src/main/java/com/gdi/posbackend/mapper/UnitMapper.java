package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.model.response.UnitResponse;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:16 AM
 */
public interface UnitMapper {
    UnitResponse mapUnitToUnitResponse(Unit unit);
}
