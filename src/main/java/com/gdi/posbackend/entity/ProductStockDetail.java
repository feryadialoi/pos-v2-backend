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
 * @date 8/4/2021 11:16 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_stock_details")
@SQLDelete(sql = "UPDATE product_stock_details SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class ProductStockDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_stock_id", referencedColumnName = "id")
    private ProductStock productStock;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "batch")
    private String batch;

    @OneToMany(mappedBy = "productStockDetail")
    @ToString.Exclude
    private List<ProductStockMutation> productStockMutations;

}
