package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:09 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_goods_receipt_details")
@SQLDelete(sql = "UPDATE product_goods_receipt_details SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class ProductGoodsReceiptDetail extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "product_goods_receipt_id", referencedColumnName = "id")
    private ProductGoodsReceipt productGoodsReceipt;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "quantity")
    private BigDecimal quantity;

}
