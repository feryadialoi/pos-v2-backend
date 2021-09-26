package com.gdi.posbackend.service;

import com.gdi.posbackend.model.criteria.SaleReturnCriteria;
import com.gdi.posbackend.model.request.CreateSaleReturnRequest;
import com.gdi.posbackend.model.response.DetailedSaleReturnResponse;
import com.gdi.posbackend.model.response.SaleReturnResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Feryadialoi
 * @date 9/19/2021 11:09 PM
 */
public interface SaleReturnService {

    Page<SaleReturnResponse> getSaleReturns(SaleReturnCriteria saleReturnCriteria, Pageable pageable);

    DetailedSaleReturnResponse getSaleReturn(String saleReturnId);

    DetailedSaleReturnResponse createSaleReturn(CreateSaleReturnRequest createSaleReturnRequest);

}
