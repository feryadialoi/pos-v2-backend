package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/23/2021 10:18 AM
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_order_details")
@SQLDelete(sql = "UPDATE purchase_order_details SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class PurchaseOrderDetail extends BaseEntity {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "purchase_order_id", referencedColumnName = "id")
    private PurchaseOrder purchaseOrder;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @OneToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    @OneToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

    @Enumerated(EnumType.STRING)
    @Column(name = "tax_format", columnDefinition = "enum('PERCENT','AMOUNT')")
    private TaxFormat taxFormat;

    @Column(name = "tax")
    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_format", columnDefinition = "enum('PERCENT','AMOUNT')")
    private DiscountFormat discountFormat;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "total")
    private BigDecimal total;

}
