package com.gdi.posbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Feryadialoi
 * @date 9/2/2021 2:00 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "salesmen")
@SQLDelete(sql = "UPDATE salesmen SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Salesman extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private String phone;

    @Column(name = "national_identification_number")
    private String nationalIdentificationNumber;
}
