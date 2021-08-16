package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Supplier;
import com.gdi.posbackend.model.response.SupplierResponse;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:59 AM
 */
public interface SupplierMapper {
    SupplierResponse mapSupplierToSupplierResponse(Supplier supplier);
}
