package com.gdi.posbackend.model.response;

import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.entity.enums.Gender;
import com.gdi.posbackend.entity.enums.Religion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author Feryadialoi
 * @date 9/23/2021 11:06 AM
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimplifiedEmployeeResponse {
    private String id;
    private String name;
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
