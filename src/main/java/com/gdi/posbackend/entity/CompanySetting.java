package com.gdi.posbackend.entity;

import com.gdi.posbackend.entity.enums.CompanySettingCategory;
import com.gdi.posbackend.entity.enums.CompanySettingValueType;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * @author Feryadialoi
 * @date 8/20/2021 10:29 AM
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "company_settings")
@SQLDelete(sql = "UPDATE company_settings SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class CompanySetting extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "setting_name")
    private String settingName;

    @Column(name = "setting_value")
    private String settingValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "setting_value_type", columnDefinition = "enum ('STRING', 'BOOLEAN', 'BIG_DECIMAL', 'INTEGER', 'LONG', 'FLOAT', 'DOUBLE')")
    private CompanySettingValueType settingValueType;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", columnDefinition = "enum('CHART_OF_ACCOUNT', 'GENERAL', 'OTHER')")
    private CompanySettingCategory category;

    @Column(name = "setting_description")
    private String settingDescription;

}
