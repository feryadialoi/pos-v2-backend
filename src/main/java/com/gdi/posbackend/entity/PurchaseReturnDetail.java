package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.TaxFormat;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_return_details")
@SQLDelete(sql = "UPDATE purchase_return_details SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class PurchaseReturnDetail extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinColumn(name = "purchase_return_id", referencedColumnName = "id")
    private PurchaseReturn purchaseReturn;

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

    @Column(name = "tax")
    private BigDecimal tax;

    @Enumerated(EnumType.STRING)
    @Column(name = "tax_format", columnDefinition = "enum('PERCENT','AMOUNT')")
    private TaxFormat taxFormat;

    @Column(name = "discount")
    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_format", columnDefinition = "enum('PERCENT','AMOUNT')")
    private DiscountFormat discountFormat;

    @Column(name = "total")
    private BigDecimal total;

}