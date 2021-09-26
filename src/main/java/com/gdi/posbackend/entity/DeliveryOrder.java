package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.DeliveryOrderStatus;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 9/20/2021 1:26 PM
 */
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "delivery_orders")
@SQLDelete(sql = "UPDATE delivery_orders SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class DeliveryOrder extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "sale_id", referencedColumnName = "id")
    private Sale sale;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @Column(name = "code")
    private String code;

    @Column(name = "note")
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "enum('DRAFT', 'PROCESSING','SHIPPED', 'DELIVERED', 'VOID')")
    private DeliveryOrderStatus status;

    @OneToMany(mappedBy = "deliveryOrder", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<DeliveryOrderDetail> deliveryOrderDetails;

}
