package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:08 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "unit_conversions")
@SQLDelete(sql = "UPDATE unit_conversions SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class UnitConversion extends BaseEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "from_unit_id", referencedColumnName = "id")
    private Unit fromUnit;

    @Column(name = "multiplier")
    private BigDecimal multiplier;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "to_unit_id", referencedColumnName = "id")
    private Unit toUnit;

    public UnitConversion(Product product, Unit fromUnit, BigDecimal multiplier, Unit toUnit) {
        this.product = product;
        this.fromUnit = fromUnit;
        this.multiplier = multiplier;
        this.toUnit = toUnit;
    }
}
