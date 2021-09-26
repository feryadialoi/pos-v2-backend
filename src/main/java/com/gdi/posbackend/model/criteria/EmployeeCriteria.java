package com.gdi.posbackend.model.criteria;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gdi.posbackend.config.DateConfig;
import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.entity.enums.Gender;
import com.gdi.posbackend.entity.enums.Religion;
import lombok.Data;
import lombok.Value;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:35 AM
 */
@Data
public class EmployeeCriteria {
    private String userName;
    private String companyName;
    private String name;
    private String nationalIdentificationNumber;
    private String placeOfBirth;

    @DateTimeFormat(pattern = DateConfig.dateTimeFormat)
    private LocalDateTime dateOfBirth;

    private String address;
    private String addressInIdentityCard;
    private Religion religion;
    private String education;

    @DateTimeFormat(pattern = DateConfig.dateTimeFormat)
    private LocalDateTime joinDate;
    private String phone;
    private String phone2;
    private String email;
    private Boolean marriage;
    private Gender gender;
    private String taxIdentificationNumber;
    private String insuranceAndSocialSecurity;
    private String bankName;
    private String bankAccountNumber;
    private EmployeeStatus status;
}
