create table users_roles
(
    user_id varchar(36),
    role_id varchar(36),
    primary key (user_id, role_id)
) engine = InnoDB;