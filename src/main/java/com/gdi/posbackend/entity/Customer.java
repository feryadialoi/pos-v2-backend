package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Feryadialoi
 * @date 9/2/2021 2:04 PM
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
@SQLDelete(sql = "UPDATE customers SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Customer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "national_identification_number")
    private String nationalIdentificationNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "description")
    private String description;

}
