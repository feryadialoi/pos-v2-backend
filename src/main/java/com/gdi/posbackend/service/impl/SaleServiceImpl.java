package com.gdi.posbackend.service.impl;

import com.gdi.posbackend.command.sale.GetSaleCommand;
import com.gdi.posbackend.command.sale.GetSalesCommand;
import com.gdi.posbackend.command.sale.CreateSaleCommand;
import com.gdi.posbackend.entity.Customer;
import com.gdi.posbackend.entity.Salesman;
import com.gdi.posbackend.model.commandparam.CreateSaleCommandParam;
import com.gdi.posbackend.model.commandparam.GetSaleCommandParam;
import com.gdi.posbackend.model.commandparam.GetSalesCommandParam;
import com.gdi.posbackend.model.criteria.SaleCriteria;
import com.gdi.posbackend.model.request.CreateSaleRequest;
import com.gdi.posbackend.model.response.DetailedSaleResponse;
import com.gdi.posbackend.model.response.SaleResponse;
import com.gdi.posbackend.repository.SaleRepository;
import com.gdi.posbackend.service.SaleService;
import com.gdi.posbackend.service.ServiceExecutor;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Feryadialoi
 * @date 8/18/2021 11:47 PM
 */
@Service
@AllArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;
    private final ServiceExecutor serviceExecutor;

    @Override
    public Page<SaleResponse> getSales(SaleCriteria saleCriteria, Pageable pageable) {
        return serviceExecutor.execute(GetSalesCommand.class, new GetSalesCommandParam(saleCriteria, pageable));
    }

    @Override
    public DetailedSaleResponse getSale(String saleId) {
        return serviceExecutor.execute(GetSaleCommand.class, new GetSaleCommandParam(saleId));
    }

    @Override
    public DetailedSaleResponse createSale(CreateSaleRequest createSaleRequest) {
        return serviceExecutor.execute(CreateSaleCommand.class, new CreateSaleCommandParam(createSaleRequest));
    }

    @Override
    public Long saleCountByCustomer(Customer customer) {
        return saleRepository.countByCustomer(customer);
    }

    @Override
    public Long saleCountBySalesman(Salesman salesman) {
        return saleRepository.countBySalesman(salesman);
    }
}
