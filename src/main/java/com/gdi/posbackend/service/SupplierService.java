package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Supplier;
import com.gdi.posbackend.model.criteria.SupplierCriteria;
import com.gdi.posbackend.model.request.CreateSupplierRequest;
import com.gdi.posbackend.model.request.UpdateSupplierRequest;
import com.gdi.posbackend.model.response.SupplierResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:56 AM
 */
public interface SupplierService {
    List<SupplierResponse> getListSupplier();

    Page<SupplierResponse> getSuppliers(SupplierCriteria supplierCriteria, Pageable pageable);

    SupplierResponse createSupplier(CreateSupplierRequest createSupplierRequest);

    SupplierResponse updateSupplier(String supplierId, UpdateSupplierRequest updateSupplierRequest);

    Supplier findSupplierByIdOrThrowNotFound(String supplierId);
}
