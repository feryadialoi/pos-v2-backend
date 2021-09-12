package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.BaseEntity;
import com.gdi.posbackend.entity.Unit;
import com.gdi.posbackend.exception.UnitNotFoundException;
import com.gdi.posbackend.exception.UnitDeleteNotAllowedException;
import com.gdi.posbackend.mapper.UnitMapper;
import com.gdi.posbackend.model.criteria.UnitCriteria;
import com.gdi.posbackend.model.request.CreateUnitRequest;
import com.gdi.posbackend.model.request.UpdateUnitRequest;
import com.gdi.posbackend.model.response.UnitResponse;
import com.gdi.posbackend.repository.UnitRepository;
import com.gdi.posbackend.service.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.gdi.posbackend.specification.UnitSpecification.nameIsLike;

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

        String name = unitCriteria.getName();

        if (name != null) specification = specification.and(nameIsLike(name));

        return unitRepository.findAll(specification, pageable).map(unitMapper::mapUnitToUnitResponse);

    }

    @Override
    public UnitResponse getUnit(String unitId) {
        return unitMapper.mapUnitToUnitResponse(findUnitByIdOrThrowNotFound(unitId));
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

        Unit unit = findUnitByIdOrThrowNotFound(unitId);

        if (updateUnitRequest.getName() != null) unit.setName(updateUnitRequest.getName());

        unit = unitRepository.save(unit);

        return unitMapper.mapUnitToUnitResponse(unit);
    }

    @Override
    public String deleteUnit(String unitId) {

        Unit unit = findUnitByIdOrThrowNotFound(unitId);

        if (unitRepository.productCountByBrandId(unitId) > 0) {
            throw new UnitDeleteNotAllowedException("unit with id " + unitId + " has relationship and already used in another table");
        }

        unitRepository.delete(unit);

        return unitId;
    }

    @Override
    public Unit findUnitByIdOrThrowNotFound(String unitId) {
        return unitRepository.findByIdOrThrowNotFound(unitId);
    }

    @Override
    public List<Unit> findUnitsByIdsOrThrowNotFound(List<String> unitIds) {
        List<Unit> units = unitRepository.findAllById(unitIds);
        if (units.size() != unitIds.size()) {
            List<String> existingIds    = units.stream().map(BaseEntity::getId).collect(Collectors.toList());
            List<String> notExistingIds = unitIds.stream().filter(id -> !existingIds.contains(id)).collect(Collectors.toList());
            throw new UnitNotFoundException("units with id (" + notExistingIds + ") not found");
        }
        return units;
    }
}
