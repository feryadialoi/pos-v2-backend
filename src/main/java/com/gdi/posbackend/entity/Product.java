package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.ProductDefaultUnit;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/4/2021 10:05 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
@SQLDelete(sql = "UPDATE products SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brand brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "default_unit", columnDefinition = "ENUM('LARGE', 'MEDIUM', 'SMALL')")
    private ProductDefaultUnit defaultUnit;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "unit_large_id", referencedColumnName = "id")
    private Unit unitLarge;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "unit_medium_id", referencedColumnName = "id")
    private Unit unitMedium;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "unit_small_id", referencedColumnName = "id")
    private Unit unitSmall;

    @Column(name = "unit_large_price")
    private BigDecimal unitLargePrice;

    @Column(name = "unit_medium_price")
    private BigDecimal unitMediumPrice;

    @Column(name = "unit_small_price")
    private BigDecimal unitSmallPrice;

    @Column(name = "stock")
    private BigDecimal stock;

    @Column(name = "minimum_stock")
    private BigDecimal minimumStock;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<UnitConversion> unitConversions;

}
