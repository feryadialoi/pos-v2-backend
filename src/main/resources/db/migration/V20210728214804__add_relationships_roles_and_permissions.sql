alter table roles_permissions
    add constraint fk_roles_permissions_role_id
        foreign key (role_id)
            references roles (id);

alter table roles_permissions
    add constraint fk_roles_permissions_permission_id
        foreign key (permission_id)
            references permissions (id);
