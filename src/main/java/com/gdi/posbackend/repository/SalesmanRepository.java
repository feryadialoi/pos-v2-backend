package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Feryadialoi
 * @date 9/2/2021 2:04 PM
 */
public interface SalesmanRepository extends JpaRepository<Salesman, String>, JpaSpecificationExecutor<Salesman> {
}
