package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.auth.User;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/20/2021 10:18 AM
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "companies")
@SQLDelete(sql = "UPDATE companies SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Company extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_branch")
    private String bankBranch;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Column(name = "taxable_firm_name")
    private String taxableFirmName;

    @Column(name = "taxable_firm_address")
    private String taxableFirmAddress;

    @Column(name = "tax_identification_number")
    private String taxIdentificationNumber;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<User> users;

    @OneToMany(mappedBy = "company")
    @ToString.Exclude
    private List<Employee> employees;

}
