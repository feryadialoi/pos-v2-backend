package com.gdi.posbackend.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Feryadialoi
 * @date 8/20/2021 3:42 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "journal_details")
@SQLDelete(sql = "UPDATE journal_details SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class JournalDetail extends BaseEntity {
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "journal_id", referencedColumnName = "id")
    private Journal journal;

    @OneToOne
    @JoinColumn(name = "chart_of_account_id", referencedColumnName = "id")
    private ChartOfAccount chartOfAccount;

    @Column(name = "entry_date")
    private LocalDate entryDate;

    @Column(name = "debit")
    private BigDecimal debit;

    @Column(name = "credit")
    private BigDecimal credit;

    @Column(name = "description")
    private String description;
}
