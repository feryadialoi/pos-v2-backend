package com.gdi.posbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author Feryadialoi
 * @date 8/4/2021 2:00 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "running_numbers")
public class RunningNumber {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "description")
    private String description;

    @Column(name = "number")
    private Integer number;


}
