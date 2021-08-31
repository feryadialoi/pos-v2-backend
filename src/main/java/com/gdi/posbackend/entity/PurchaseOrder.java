package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.DiscountFormat;
import com.gdi.posbackend.entity.enums.PaymentType;
import com.gdi.posbackend.entity.enums.PurchaseOrderStatus;
import com.gdi.posbackend.entity.enums.TaxFormat;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/23/2021 10:07 AM
 */
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "purchase_orders")
@SQLDelete(sql = "UPDATE purchase_orders SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class PurchaseOrder extends BaseEntity {

    @Column(name = "code")
    private String code;

    @Column(name = "reference")
    private String reference;

    @OneToOne
    @JoinColumn(name = "supplier_id", referencedColumnName = "id")
    private Supplier supplier;

    @Column(name = "is_taxed")
    private Boolean isTaxed;

    @Column(name = "tax")
    private BigDecimal tax;

    @Column(name = "is_discounted")
    private Boolean isDiscounted;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "entry_date")
    private LocalDateTime entryDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "payment_type", columnDefinition = "enum('CASH','CREDIT')")
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('DRAFT','APPROVED', 'AWAITING_APPROVAL')")
    private PurchaseOrderStatus status;

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

    @OneToMany(mappedBy = "purchaseOrder", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<PurchaseOrderDetail> purchaseOrderDetails;

}
