package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.exception.SalesmanNotFoundException;
import com.gdi.posbackend.repository.SalesmanRepository;
import com.gdi.posbackend.service.SalesmanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 9/3/2021 11:25 AM
 */
@Service
@AllArgsConstructor
public class SalesmanServiceImpl implements SalesmanService {

    private final SalesmanRepository salesmanRepository;

    @Override
    public Salesman findSalesmanByIdOrThrowNotFound(String salesmanId) {
        return salesmanRepository.findById(salesmanId)
                .orElseThrow(() -> new SalesmanNotFoundException("salesman with id " + salesmanId + " not found"));
    }
}
