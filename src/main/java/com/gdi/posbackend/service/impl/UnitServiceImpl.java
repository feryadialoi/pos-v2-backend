package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.BaseEntity;
import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.exception.UnitNotFoundException;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.criteria.UnitCriteria;
import com.gdi.posbackend.model.request.CreateUnitRequest;
import com.gdi.posbackend.model.request.UpdateUnitRequest;
import com.gdi.posbackend.model.response.UnitResponse;
import com.gdi.posbackend.repository.UnitRepository;
import com.gdi.posbackend.service.UnitService;
import com.gdi.posbackend.specification.UnitSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/5/2021 10:14 AM
 */
@Service
@AllArgsConstructor
public class UnitServiceImpl implements UnitService {

    private final UnitRepository unitRepository;
    private final UnitMapper unitMapper;

    @Override
    public Page<UnitResponse> getUnits(UnitCriteria unitCriteria, Pageable pageable) {
        Specification<Unit> specification = Specification.where(null);
        if (unitCriteria.getName() != null)
            specification = specification.and(UnitSpecification.nameIsLike(unitCriteria.getName()));

        Page<Unit> page = unitRepository.findAll(specification, pageable);

        return page.map(unitMapper::mapUnitToUnitResponse);
    }

    @Override
    public UnitResponse getUnit(String unitId) {
        Optional<Unit> optional = unitRepository.findById(unitId);
        if (optional.isEmpty()) throw new UnitNotFoundException("unit with id " + unitId + " not found");
        Unit unit = optional.get();
        return unitMapper.mapUnitToUnitResponse(unit);
    }

    @Override
    public UnitResponse createUnit(CreateUnitRequest createUnitRequest) {
        Unit unit = new Unit();
        unit.setName(createUnitRequest.getName());
        unit = unitRepository.save(unit);

        return unitMapper.mapUnitToUnitResponse(unit);
    }

    @Override
    public UnitResponse updateUnit(String unitId, UpdateUnitRequest updateUnitRequest) {
        Optional<Unit> optional = unitRepository.findById(unitId);
        if (optional.isEmpty()) throw new UnitNotFoundException("unit with id " + unitId + " not found");
        Unit unit = optional.get();

        if (updateUnitRequest.getName() != null) unit.setName(updateUnitRequest.getName());

        unit = unitRepository.save(unit);

        return unitMapper.mapUnitToUnitResponse(unit);
    }

    @Override
    public Object deleteUnit(String unitId) {
        Optional<Unit> optional = unitRepository.findById(unitId);
        if (optional.isEmpty()) throw new UnitNotFoundException("unit with id " + unitId + " not found");

        unitRepository.deleteById(unitId);

        return unitId;
    }

    @Override
    public Unit findUnitByIdOrThrowNotFound(String unitId) {
        return unitRepository.findById(unitId)
                .orElseThrow(() -> new UnitNotFoundException("unit with id " + unitId + " not found"));
    }

    @Override
    public List<Unit> findUnitsByIdsOrThrowNotFound(List<String> unitIds) {
        List<Unit> units = unitRepository.findAllById(unitIds);
        if (units.size() != unitIds.size()) {
            List<String> existingIds = units.stream().map(BaseEntity::getId).collect(Collectors.toList());
            List<String> notExistingIds = unitIds.stream().filter(id -> !existingIds.contains(id)).collect(Collectors.toList());
            throw new UnitNotFoundException("units with id (" + notExistingIds + ") not found");
        }
        return units;
    }
}
