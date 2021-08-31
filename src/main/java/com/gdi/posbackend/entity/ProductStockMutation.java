package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.ProductStockMutationEvent;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:24 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_stock_mutations")
@SQLDelete(sql = "UPDATE product_stock_mutations SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class ProductStockMutation extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_stock_id", referencedColumnName = "id")
    private ProductStock productStock;

    @ManyToOne
    @JoinColumn(name = "product_stock_detail_id", referencedColumnName = "id")
    private ProductStockDetail productStockDetail;

    @ManyToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    @Column(name = "quantity_in")
    private BigDecimal quantityIn;

    @Column(name = "quantity_out")
    private BigDecimal quantityOut;

    @Enumerated(EnumType.STRING)
    @Column(name = "event", columnDefinition = "ENUM('SALE','PURCHASE','SALE_RETURN','PURCHASE_RETURN')")
    private ProductStockMutationEvent event;

    @Column(name = "reference")
    private String reference;


}
