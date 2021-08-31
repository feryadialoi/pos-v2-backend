package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.NormalBalance;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 8/19/2021 1:58 AM
 */
@ToString
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "chart_of_accounts")
@SQLDelete(sql = "UPDATE chart_of_accounts SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class ChartOfAccount extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "account_code")
    private Integer accountCode;

    @Column(name = "level")
    private Integer level;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ToString.Exclude
    private ChartOfAccount parent;

    @Column(name = "path")
    private String path;

    @Enumerated(EnumType.STRING)
    @Column(name = "normal_balance", columnDefinition = "enum('DEBIT','CREDIT')")
    private NormalBalance normalBalance;

    @OneToMany(mappedBy = "parent", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @ToString.Exclude
    private List<ChartOfAccount> children;

}
