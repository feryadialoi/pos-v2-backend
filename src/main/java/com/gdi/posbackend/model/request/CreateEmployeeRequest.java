package com.gdi.posbackend.model.request;

import com.gdi.posbackend.config.DateConfig;
import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.entity.enums.Gender;
import com.gdi.posbackend.entity.enums.Religion;
import com.gdi.posbackend.validation.constraint.CompanyExists;
import com.gdi.posbackend.validation.constraint.UserExists;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 9/13/2021 1:38 AM
 */
@Data
public class CreateEmployeeRequest {

    @NotBlank
    @UserExists
    @ApiModelProperty(required = true)
    private String userId;

    @NotBlank
    @CompanyExists
    @ApiModelProperty(required = true)
    private String companyId;

    @NotBlank
    @ApiModelProperty(required = true)
    private String name;

    @NotBlank
    @ApiModelProperty(required = true)
    private String nationalIdentificationNumber;

    @NotBlank
    @ApiModelProperty(required = true)
    private String placeOfBirth;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    @NotNull
    @ApiModelProperty(required = true)
    private LocalDate dateOfBirth;

    @NotBlank
    @ApiModelProperty(required = true)
    private String address;

    @NotBlank
    @ApiModelProperty(required = true)
    private String addressInIdentityCard;

    @ApiModelProperty(required = true)
    private Religion religion;

    @NotBlank
    @ApiModelProperty(required = true)
    private String education;

    @DateTimeFormat(pattern = DateConfig.dateFormat)
    @NotNull
    @ApiModelProperty(required = true)
    private LocalDate joinDate;

    @NotBlank
    @ApiModelProperty(required = true)
    private String phone;

    private String phone2;

    @Email
    private String email;

    @Email
    private String officeEmail;

    @NotNull
    @ApiModelProperty(required = true)
    private Boolean marriage;

    @NotNull
    @ApiModelProperty(required = true)
    private Gender gender;

    private String taxIdentificationNumber;

    private String insuranceAndSocialSecurity;

    private String bankName;

    private String bankBranch;

    private String bankAccountNumber;

    private EmployeeStatus status;

    private Boolean active;

}
