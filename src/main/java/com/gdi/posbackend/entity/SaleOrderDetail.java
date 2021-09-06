package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 9/2/2021 1:40 PM
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale_order_details")
@SQLDelete(sql = "UPDATE sale_orders SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class SaleOrderDetail extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "sale_order_id", referencedColumnName = "id")
    private SaleOrder saleOrder;

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

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "tax_format", columnDefinition = "enum('PERCENT','AMOUNT')")
    private TaxFormat taxFormat;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "discount_format", columnDefinition = "enum('PERCENT','AMOUNT')")
    private DiscountFormat discountFormat;

    @Column(name = "total")
    private BigDecimal total;

}
