package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Feryadialoi
 * @date 8/13/2021 1:52 PM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "brands")
@SQLDelete(sql = "UPDATE brands SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Brand extends BaseEntity {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;
}
