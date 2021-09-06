package com.gdi.posbackend.service;

import com.gdi.posbackend.entity.Salesman;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:25 AM
 */
public interface SalesmanService {
    Salesman findSalesmanByIdOrThrowNotFound(String salesmanId);
}
