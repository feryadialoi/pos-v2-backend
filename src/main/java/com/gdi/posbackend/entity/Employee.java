package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.auth.User;
import com.gdi.posbackend.entity.enums.EmployeeStatus;
import com.gdi.posbackend.entity.enums.Gender;
import com.gdi.posbackend.entity.enums.Religion;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 9/12/2021 10:46 PM
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
@SQLDelete(sql = "UPDATE employees SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Employee extends BaseEntity {
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @Column(name = "name")
    private String name;

    @Column(name = "national_identification_number")
    private String nationalIdentificationNumber;

    @Column(name = "place_of_birth")
    private String placeOfBirth;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "address")
    private String address;

    @Column(name = "address_in_identity_card")
    private String addressInIdentityCard;

    @Enumerated(EnumType.STRING)
    @Column(name = "religion", columnDefinition = "enum('ISLAM', 'CHRISTIAN', 'CATHOLIC', 'HINDU', 'BUDDHA', 'KONG_HU_CU')")
    private Religion religion;

    @Column(name = "education")
    private String education;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "email")
    private String email;

    @Column(name = "office_email")
    private String officeEmail;

    @Column(name = "marriage")
    private Boolean marriage;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", columnDefinition = "enum('MALE','FEMALE')")
    private Gender gender;

    @Column(name = "tax_identification_number")
    private String taxIdentificationNumber;

    @Column(name = "insurance_and_social_security")
    private String insuranceAndSocialSecurity;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_branch")
    private String bankBranch;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('PERMANENT','CONTRACT', 'INTERN')")
    private EmployeeStatus status;

    @Column(name = "active")
    private Boolean active;

}
