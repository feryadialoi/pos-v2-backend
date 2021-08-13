alter table users_roles
    add constraint fk_users_roles_role_id
        foreign key (role_id)
            references roles (id);

alter table users_roles
    add constraint fk_users_roles_user_id
        foreign key (user_id)
            references users (id);
