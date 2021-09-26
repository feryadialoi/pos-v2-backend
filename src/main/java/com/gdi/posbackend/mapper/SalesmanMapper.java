package com.gdi.posbackend.mapper;

import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.model.response.SalesmanResponse;
import com.gdi.posbackend.model.response.SimplifiedSalesmanResponse;

/**
 * @author Feryadialoi
 * @date 9/14/2021 4:09 PM
 */
public interface SalesmanMapper {
    SalesmanResponse mapSalesmanToSalesmanResponse(Salesman salesman);

    SimplifiedSalesmanResponse mapSalesmanToSimplifiedSalesmanResponse(Salesman salesman);
}
