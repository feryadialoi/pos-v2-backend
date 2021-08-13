create table roles_permissions
(
    role_id       bigint unsigned,
    permission_id bigint unsigned,
    primary key (role_id, permission_id)
) engine = InnoDB;