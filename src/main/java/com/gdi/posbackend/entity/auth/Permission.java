package com.gdi.posbackend.entity.auth;

import com.gdi.posbackend.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

/**
 * @author Feryadialoi
 * @date 7/24/2021 11:43 AM
 */
@Getter
@Setter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "permissions")
@SQLDelete(sql = "UPDATE permissions SET deleted_date = NOW() WHERE id = ?")
@Where(clause = "deleted_date is null")
public class Permission extends BaseEntity {

    public Permission(String name, String displayName, String description) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
    }

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "description")
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH
    })
    @JoinTable(
            name = "roles_permissions",
            joinColumns = {
                    @JoinColumn(name = "permission_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")
            }
    )
    @ToString.Exclude
    private List<Role> roles;
}
