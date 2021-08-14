package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.UnitCriteria;
import com.gdi.posbackend.model.request.CreateUnitRequest;
import com.gdi.posbackend.model.request.UpdateUnitRequest;
import com.gdi.posbackend.model.response.UnitResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:07 AM
 */
public interface UnitService {
    Page<UnitResponse> getUnits(UnitCriteria unitCriteria, Pageable pageable);

    UnitResponse getUnit(String unitId);

    UnitResponse createUnit(CreateUnitRequest createUnitRequest);

    UnitResponse updateUnit(String unitId, UpdateUnitRequest updateUnitRequest);

    Object deleteUnit(String unitId);
}
