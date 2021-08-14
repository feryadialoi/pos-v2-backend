create table roles_permissions
(
    role_id       varchar(36),
    permission_id varchar(36),
    primary key (role_id, permission_id)
) engine = InnoDB;