create table users_roles
(
    user_id bigint unsigned,
    role_id bigint unsigned,
    primary key (user_id, role_id)
) engine = InnoDB;