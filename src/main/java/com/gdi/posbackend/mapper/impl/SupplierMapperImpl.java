package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Supplier;
import com.gdi.posbackend.mapper.SupplierMapper;
import com.gdi.posbackend.model.response.SupplierResponse;
import org.springframework.stereotype.Component;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:59 AM
 */
@Component
public class SupplierMapperImpl implements SupplierMapper {
    @Override
    public SupplierResponse mapSupplierToSupplierResponse(Supplier supplier) {
        return SupplierResponse.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .code(supplier.getCode())
                .address(supplier.getAddress())

                .pic(supplier.getPic())
                .phone(supplier.getPhone())
                .email(supplier.getEmail())

                .bankName(supplier.getBankName())
                .bankBranch(supplier.getBankBranch())
                .bankAccountNumber(supplier.getBankAccountNumber())

                .taxableFirmName(supplier.getTaxableFirmName())
                .taxableFirmAddress(supplier.getTaxableFirmAddress())
                .taxIdentificationNumber(supplier.getTaxIdentificationNumber())

                .build();
    }
}
