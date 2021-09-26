package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Supplier;
import com.gdi.posbackend.entity.enums.RunningNumberPrefix;
import com.gdi.posbackend.exception.SupplierDeleteNotAllowed;
import com.gdi.posbackend.exception.SupplierNotFoundException;
import com.gdi.posbackend.mapper.SupplierMapper;
import com.gdi.posbackend.model.criteria.SupplierCriteria;
import com.gdi.posbackend.model.request.CreateSupplierRequest;
import com.gdi.posbackend.model.request.UpdateSupplierRequest;
import com.gdi.posbackend.model.response.SupplierResponse;
import com.gdi.posbackend.repository.SupplierRepository;
import com.gdi.posbackend.service.PurchaseOrderService;
import com.gdi.posbackend.service.PurchaseService;
import com.gdi.posbackend.service.RunningNumberService;
import com.gdi.posbackend.service.SupplierService;
import com.gdi.posbackend.specification.SupplierSpecification;
import com.gdi.posbackend.util.RunningNumberCodeUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:55 AM
 */
@Service
@Transactional
@AllArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;
    private final RunningNumberCodeUtil runningNumberCodeUtil;
    private final RunningNumberService runningNumberService;
    private final PurchaseOrderService purchaseOrderService;
    private final PurchaseService purchaseService;


    @Override
    public List<SupplierResponse> getListSupplier() {
        return supplierRepository.findAll().stream()
                .map(supplierMapper::mapSupplierToSupplierResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Page<SupplierResponse> getSuppliers(SupplierCriteria supplierCriteria, Pageable pageable) {

        Specification<Supplier> specification = getSupplierSpecification(supplierCriteria);

        return supplierRepository.findAll(specification, pageable).map(supplierMapper::mapSupplierToSupplierResponse);

    }

    private Specification<Supplier> getSupplierSpecification(SupplierCriteria supplierCriteria) {
        Specification<Supplier> specification = Specification.where(null);

        if (supplierCriteria.getName() != null)
            specification = specification.and(SupplierSpecification.nameIsLike(supplierCriteria.getName()));

        if (supplierCriteria.getCode() != null)
            specification = specification.and(SupplierSpecification.codeIsLike(supplierCriteria.getCode()));

        if (supplierCriteria.getAddress() != null)
            specification = specification.and(SupplierSpecification.addressIsLike(supplierCriteria.getAddress()));

        if (supplierCriteria.getPic() != null)
            specification = specification.and(SupplierSpecification.picIsLike(supplierCriteria.getPic()));

        if (supplierCriteria.getPhone() != null)
            specification = specification.and(SupplierSpecification.phoneIsLike(supplierCriteria.getPhone()));

        if (supplierCriteria.getEmail() != null)
            specification = specification.and(SupplierSpecification.emailIsLike(supplierCriteria.getEmail()));

        if (supplierCriteria.getBankName() != null)
            specification = specification.and(SupplierSpecification.bankNameIsLike(supplierCriteria.getBankName()));

        if (supplierCriteria.getBankBranch() != null)
            specification = specification.and(SupplierSpecification.bankBranchIsLike(supplierCriteria.getBankBranch()));

        if (supplierCriteria.getBankAccountNumber() != null)
            specification = specification.and(SupplierSpecification.bankAccountNumberIsLike(supplierCriteria.getBankAccountNumber()));

        if (supplierCriteria.getTaxableFirmName() != null)
            specification = specification.and(SupplierSpecification.taxableFirmNameIsLike(supplierCriteria.getTaxableFirmName()));

        if (supplierCriteria.getTaxableFirmAddress() != null)
            specification = specification.and(SupplierSpecification.taxableFirmAddressIsLike(supplierCriteria.getTaxableFirmAddress()));

        if (supplierCriteria.getTaxIdentificationNumber() != null)
            specification = specification.and(SupplierSpecification.taxIdentificationNumberIsLike(supplierCriteria.getTaxIdentificationNumber()));
        return specification;
    }

    @Override
    public SupplierResponse createSupplier(CreateSupplierRequest createSupplierRequest) {
        Supplier supplier = new Supplier();
        supplier.setName(createSupplierRequest.getName());
        supplier.setAddress(createSupplierRequest.getAddress());
        supplier.setCode(runningNumberCodeUtil.getFormattedCode(runningNumberService.getRunningNumber(RunningNumberPrefix.SP)));

        supplier.setPic(createSupplierRequest.getPic());
        supplier.setPhone(createSupplierRequest.getPhone());
        supplier.setEmail(createSupplierRequest.getEmail());

        supplier.setBankName(createSupplierRequest.getBankName());
        supplier.setBankBranch(createSupplierRequest.getBankBranch());
        supplier.setBankAccountNumber(createSupplierRequest.getBankAccountNumber());

        supplier.setTaxableFirmName(createSupplierRequest.getTaxableFirmName());
        supplier.setTaxableFirmAddress(createSupplierRequest.getTaxableFirmAddress());
        supplier.setTaxIdentificationNumber(createSupplierRequest.getTaxIdentificationNumber());

        return supplierMapper.mapSupplierToSupplierResponse(supplierRepository.save(supplier));
    }

    @Override
    public SupplierResponse updateSupplier(String supplierId, UpdateSupplierRequest updateSupplierRequest) {
        return supplierRepository
                .findById(supplierId)
                .map(supplier -> {
                    if (updateSupplierRequest.getName() != null)
                        supplier.setName(updateSupplierRequest.getName());

                    if (updateSupplierRequest.getAddress() != null)
                        supplier.setAddress(updateSupplierRequest.getAddress());

                    if (updateSupplierRequest.getPic() != null)
                        supplier.setPic(updateSupplierRequest.getPic());

                    if (updateSupplierRequest.getPhone() != null)
                        supplier.setPhone(updateSupplierRequest.getPhone());

                    if (updateSupplierRequest.getEmail() != null)
                        supplier.setEmail(updateSupplierRequest.getEmail());

                    if (updateSupplierRequest.getBankName() != null)
                        supplier.setBankName(updateSupplierRequest.getBankName());

                    if (updateSupplierRequest.getBankBranch() != null)
                        supplier.setBankBranch(updateSupplierRequest.getBankBranch());

                    if (updateSupplierRequest.getBankAccountNumber() != null)
                        supplier.setBankAccountNumber(updateSupplierRequest.getBankAccountNumber());

                    if (updateSupplierRequest.getTaxableFirmName() != null)
                        supplier.setTaxableFirmName(updateSupplierRequest.getTaxableFirmName());

                    if (updateSupplierRequest.getTaxableFirmAddress() != null)
                        supplier.setTaxableFirmAddress(updateSupplierRequest.getTaxableFirmAddress());

                    if (updateSupplierRequest.getTaxIdentificationNumber() != null)
                        supplier.setTaxIdentificationNumber(updateSupplierRequest.getTaxIdentificationNumber());

                    supplier = supplierRepository.save(supplier);

                    return supplierMapper.mapSupplierToSupplierResponse(supplier);
                })
                .orElseThrow(() -> new SupplierNotFoundException("supplier with id " + supplierId + " not found"));
    }

    @Override
    public Supplier findSupplierByIdOrThrowNotFound(String supplierId) {
        return supplierRepository.findById(supplierId)
                .orElseThrow(() -> new SupplierNotFoundException("supplier with id " + supplierId + " not found"));
    }

    @Override
    public String deleteSupplier(String supplierId) {
        Supplier supplier = findSupplierByIdOrThrowNotFound(supplierId);

        if (purchaseOrderService.purchaseOrderCountBySupplier(supplier) +
                purchaseService.puchaseCountBySupplier(supplier) > 0) {
            throw new SupplierDeleteNotAllowed("supplier delete not allowed");
        }

        supplierRepository.delete(supplier);

        return supplierId;
    }

    @Override
    public SupplierResponse getSupplier(String supplierId) {
        return supplierMapper.mapSupplierToSupplierResponse(findSupplierByIdOrThrowNotFound(supplierId));
    }

}
