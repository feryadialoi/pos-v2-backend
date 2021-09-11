package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.model.criteria.UnitCriteria;
import com.gdi.posbackend.model.request.CreateUnitRequest;
import com.gdi.posbackend.model.request.UpdateUnitRequest;
import com.gdi.posbackend.model.response.UnitResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:07 AM
 */
public interface UnitService {
    Page<UnitResponse> getUnits(UnitCriteria unitCriteria, Pageable pageable);

    UnitResponse getUnit(String unitId);

    UnitResponse createUnit(CreateUnitRequest createUnitRequest);

    UnitResponse updateUnit(String unitId, UpdateUnitRequest updateUnitRequest);

    String deleteUnit(String unitId);

    Unit findUnitByIdOrThrowNotFound(String unitId);

    List<Unit> findUnitsByIdsOrThrowNotFound(List<String> unitIds);
}
