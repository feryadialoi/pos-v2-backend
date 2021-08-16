package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.SupplierStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Feryadialoi
 * @date 8/16/2021 9:44 AM
 */

@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "suppliers")
@SQLDelete(sql = "UPDATE units SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Supplier extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "address")
    private String address;

    @Column(name = "pic")
    private String pic;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "taxable_firm_name")
    private String taxableFirmName;

    @Column(name = "taxable_firm_address")
    private String taxableFirmAddress;

    @Column(name = "tax_identification_number")
    private String taxIdentificationNumber;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_branch")
    private String bankBranch;

    @Column(name = "bank_account_number")
    private String bankAccountNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('ACTIVE','INACTIVE')")
    private SupplierStatus status;

}
