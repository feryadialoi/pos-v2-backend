package com.gdi.posbackend.mapper.impl;

import com.gdi.posbackend.entity.SaleOrder;
import com.gdi.posbackend.mapper.CustomerMapper;
import com.gdi.posbackend.mapper.SaleOrderDetailMapper;
import com.gdi.posbackend.mapper.SaleOrderMapper;
import com.gdi.posbackend.mapper.SalesmanMapper;
import com.gdi.posbackend.model.response.DetailedSaleOrderResponse;
import com.gdi.posbackend.model.response.SaleOrderResponse;
import com.gdi.posbackend.model.response.UpdateSaleOrderStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:11 AM
 */
@Component
public class SaleOrderMapperImpl implements SaleOrderMapper {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private SaleOrderDetailMapper saleOrderDetailMapper;

    @Autowired
    private SalesmanMapper salesmanMapper;


    @Override
    public DetailedSaleOrderResponse mapSaleOrderToDetailedSaleOrderResponse(SaleOrder saleOrder) {
        return DetailedSaleOrderResponse.builder()
                .id(saleOrder.getId())
                .code(saleOrder.getCode())
                .reference(saleOrder.getReference())
                .entryDate(saleOrder.getEntryDate())
                .dueDate(saleOrder.getDueDate())
                .term(saleOrder.getTerm())
                .salesman(salesmanMapper.mapSalesmanToSalesmanResponse(saleOrder.getSalesman()))
                .customer(customerMapper.mapCustomerToCustomerResponse(saleOrder.getCustomer()))
                .paymentType(saleOrder.getPaymentType())
                .saleOrderDetails(saleOrder
                                          .getSaleOrderDetails()
                                          .stream().map(saleOrderDetailMapper::mapSaleOrderDetailToSaleOrderDetailResponse)
                                          .collect(Collectors.toList()))

                .note(saleOrder.getNote())
                .attachment(saleOrder.getAttachment())

                .shippingFee(saleOrder.getShippingFee())
                .shippingFeeDescription(saleOrder.getShippingFeeDescription())
                .otherFee(saleOrder.getOtherFee())
                .otherFeeDescription(saleOrder.getOtherFeeDescription())

                .discount(saleOrder.getDiscount())
                .tax(saleOrder.getTax())
                .total(saleOrder.getTotal())
                .grandTotal(saleOrder.getGrandTotal())
                .status(saleOrder.getStatus())

                .build();
    }

    @Override
    public SaleOrderResponse mapSaleOrderToSaleOrderResponse(SaleOrder saleOrder) {
        return SaleOrderResponse.builder()
                .id(saleOrder.getId())
                .code(saleOrder.getCode())
                .entryDate(saleOrder.getEntryDate())
                .dueDate(saleOrder.getDueDate())
                .term(saleOrder.getTerm())

                .customer(customerMapper.mapCustomerToCustomerResponse(saleOrder.getCustomer()))
                .salesman(salesmanMapper.mapSalesmanToSimplifiedSalesmanResponse(saleOrder.getSalesman()))

                .reference(saleOrder.getReference())
                .note(saleOrder.getNote())
                .attachment(saleOrder.getAttachment())
                .shippingFee(saleOrder.getShippingFee())
                .shippingFeeDescription(saleOrder.getShippingFeeDescription())
                .otherFee(saleOrder.getOtherFee())
                .otherFeeDescription(saleOrder.getOtherFeeDescription())
                .paymentType(saleOrder.getPaymentType())

                .discount(saleOrder.getDiscount())
                .tax(saleOrder.getTax())
                .total(saleOrder.getTotal())
                .grandTotal(saleOrder.getGrandTotal())
                .status(saleOrder.getStatus())

                .build();
    }

    @Override
    public UpdateSaleOrderStatusResponse mapSaleOrderToUpdateSaleOrderStatusResponse(SaleOrder saleOrder) {
        return UpdateSaleOrderStatusResponse.builder()
                .id(saleOrder.getId())
                .status(saleOrder.getStatus())
                .build();
    }

}
