package com.gdi.posbackend.repository;

import com.gdi.posbackend.entity.Company;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Feryadialoi
 * @date 8/20/2021 10:39 AM
 */
@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CompanyRepositoryTest {

    @Autowired
    private CompanyRepository companyRepository;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testCreateCompany() {
        Company company = new Company(
                "PD Sumber Pangan Makmur",
                "Jl. Sari Lumbung No 50",
                "081234567890",
                "Mandiri",
                "KCP Sari Lumbung",
                "8779846484165646",
                "Suyanto",
                "Jl. Sari Lumbung No 50",
                "79794894891"
        );

        company = companyRepository.save(company);

        log.info("getId                         : {}", company.getId());
        log.info("getName                       : {}", company.getName());
        log.info("getAddress                    : {}", company.getAddress());
        log.info("getPhone                      : {}", company.getPhone());
        log.info("getBankName                   : {}", company.getBankName());
        log.info("getBankBranch                 : {}", company.getBankBranch());
        log.info("getBankAccountNumber          : {}", company.getBankAccountNumber());
        log.info("getTaxableFirmName            : {}", company.getTaxableFirmName());
        log.info("getTaxableFirmAddress         : {}", company.getTaxableFirmAddress());
        log.info("getTaxIdentificationNumber    : {}", company.getTaxIdentificationNumber());

        Assertions.assertNotNull(company.getId());
    }
}