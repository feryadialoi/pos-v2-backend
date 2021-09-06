package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:04 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_stocks")
@SQLDelete(sql = "UPDATE product_stocks SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class ProductStock extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    @Column(name = "stock")
    private BigDecimal stock;

    @OneToMany(mappedBy = "productStock", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<ProductStockDetail> productStockDetails;

}
