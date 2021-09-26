package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.PurchaseReturnStatus;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/29/2021 3:50 AM
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_returns")
@SQLDelete(sql = "UPDATE purchase_returns SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class PurchaseReturn extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    private Purchase purchase;

    @OneToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @Column(name = "code")
    private String code;

    @Column(name = "reference")
    private String reference;

    @Column(name = "is_taxed")
    private Boolean isTaxed;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "is_discounted")
    private Boolean isDiscounted;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", columnDefinition = "enum('CASH', 'CREDIT')")
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('DRAFT', 'APPROVE', 'REJECT', 'COMPLETE', 'VOID')")
    private PurchaseReturnStatus status;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "grand_total")
    private BigDecimal grandTotal;

    @Column(name = "note")
    private String note;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "shipping_fee")
    private BigDecimal shippingFee;

    @Column(name = "shipping_fee_description")
    private String shippingFeeDescription;

    @Column(name = "other_fee")
    private BigDecimal otherFee;

    @Column(name = "other_fee_description")
    private String otherFeeDescription;


    @OneToMany(mappedBy = "purchaseReturn", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<PurchaseReturnDetail> purchaseReturnDetails;

}
