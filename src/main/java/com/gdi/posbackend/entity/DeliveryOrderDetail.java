package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/20/2021 1:27 PM
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "delivery_order_details")
@SQLDelete(sql = "UPDATE delivery_order_details SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class DeliveryOrderDetail extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "delivery_order_id", referencedColumnName = "id")
    private DeliveryOrder deliveryOrder;

    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    private Unit unit;

    @Column(name = "delivered_quantity")
    private BigDecimal deliveredQuantity;

    @Column(name = "received_quantity")
    private BigDecimal receivedQuantity;

    @Column(name = "note")
    private String note;

}
