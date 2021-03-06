package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/4/2021 11:07 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product_goods_receipts")
@SQLDelete(sql = "UPDATE product_goods_receipts SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class ProductGoodsReceipt extends BaseEntity {

    @Column(name = "batch")
    private String batch;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @OneToMany(mappedBy = "productGoodsReceipt")
    @ToString.Exclude
    private List<ProductGoodsReceiptDetail> productGoodsReceiptDetails;
}
