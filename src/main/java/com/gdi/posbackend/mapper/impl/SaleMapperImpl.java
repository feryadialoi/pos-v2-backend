package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.Sale;
import com.gdi.posbackend.mapper.*;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.model.response.SaleResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:39 AM
 */
@Component
@AllArgsConstructor
public class SaleMapperImpl implements SaleMapper {

    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private SalesmanMapper salesmanMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private SaleDetailMapper saleDetailMapper;


    @Override
    public DetailedSaleResponse mapSaleToDetailedSaleResponse(Sale sale) {
        return DetailedSaleResponse.builder()
                .id(sale.getId())
                .saleOrder(saleOrderMapper.mapSaleOrderToSaleOrderResponse(sale.getSaleOrder()))
                .code(sale.getCode())
                .entryDate(sale.getEntryDate())
                .dueDate(sale.getDueDate())
                .term(sale.getTerm())
                .salesman(salesmanMapper.mapSalesmanToSalesmanResponse(sale.getSalesman()))
                .customer(customerMapper.mapCustomerToCustomerResponse(sale.getCustomer()))
                .reference(sale.getReference())
                .note(sale.getNote())
                .attachment(sale.getAttachment())
                .shippingFee(sale.getShippingFee())
                .shippingFeeDescription(sale.getShippingFeeDescription())
                .otherFee(sale.getOtherFee())
                .otherFeeDescription(sale.getOtherFeeDescription())
                .paymentType(sale.getPaymentType())
                .discount(sale.getDiscount())
                .tax(sale.getTax())
                .total(sale.getTotal())
                .grandTotal(sale.getGrandTotal())
                .status(sale.getStatus())
                .saleDetails(sale.getSaleDetails()
                                     .stream()
                                     .map(saleDetailMapper::mapSaleDetailToSaleDetailResponse)
                                     .collect(Collectors.toList()))
                .build();
    }

    @Override
    public SaleResponse mapSaleToSaleResponse(Sale sale) {
        return SaleResponse.builder()
                .id(sale.getId())
                .saleOrder(saleOrderMapper.mapSaleOrderToSaleOrderResponse(sale.getSaleOrder()))
                .code(sale.getCode())
                .entryDate(sale.getEntryDate())
                .dueDate(sale.getDueDate())
                .term(sale.getTerm())
                .salesman(salesmanMapper.mapSalesmanToSalesmanResponse(sale.getSalesman()))
                .customer(customerMapper.mapCustomerToCustomerResponse(sale.getCustomer()))
                .reference(sale.getReference())
                .note(sale.getNote())
                .attachment(sale.getAttachment())
                .shippingFee(sale.getShippingFee())
                .shippingFeeDescription(sale.getShippingFeeDescription())
                .otherFee(sale.getOtherFee())
                .otherFeeDescription(sale.getOtherFeeDescription())
                .paymentType(sale.getPaymentType())
                .discount(sale.getDiscount())
                .tax(sale.getTax())
                .total(sale.getTotal())
                .grandTotal(sale.getGrandTotal())
                .status(sale.getStatus())
                .build();
    }
}
