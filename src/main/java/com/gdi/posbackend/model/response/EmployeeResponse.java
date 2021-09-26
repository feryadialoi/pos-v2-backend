package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.entity.enums.Gender;
import com.gdi.posbackend.entity.enums.Religion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:28 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    private String id;
    private String name;
    private SimplifiedUserResponse user;
    private CompanyResponse company;
    private String nationalIdentificationNumber;
    private String placeOfBirth;
    private LocalDate dateOfBirth;
    private String address;
    private String addressInIdentityCard;
    private Religion religion;
    private String education;
    private LocalDate joinDate;
    private String phone;
    private String phone2;
    private String email;
    private String officeEmail;
    private Boolean marriage;
    private Gender gender;
    private String taxIdentificationNumber;
    private String insuranceAndSocialSecurity;
    private String bankName;
    private String bankBranch;
    private String bankAccountNumber;
    private EmployeeStatus status;
    private Boolean active;
}
