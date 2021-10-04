package com.gdi.posbackend.model.request;

import com.gdi.posbackend.configuration.DateTimeFormatConfiguration;
import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.entity.enums.Gender;
import com.gdi.posbackend.entity.enums.Religion;
import com.gdi.posbackend.validation.constraint.CompanyExists;
import com.gdi.posbackend.validation.constraint.UnitExists;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:41 AM
 */
@Data
public class UpdateEmployeeRequest {

    @UnitExists
    private String userId;

    @CompanyExists
    private String companyId;

    private String name;

    private String nationalIdentificationNumber;

    private String placeOfBirth;

    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateFormat)
    private LocalDate dateOfBirth;

    private String address;

    private String addressInIdentityCard;

    private Religion religion;

    private String education;

    @DateTimeFormat(pattern = DateTimeFormatConfiguration.dateFormat)
    private LocalDate joinDate;

    private String phone;

    private String phone2;

    @Email
    private String email;

    @Email
    private String officeEmail;

    private Boolean marriage;

    private Gender gender;

    private String taxIdentificationNumber;

    private String insuranceAndSocialSecurity;

    private String bankName;

    private String bankAccountNumber;

    private EmployeeStatus status;

}
