create table users
(
    id                 bigint unsigned auto_increment,
    name               varchar(255),
    username           varchar(255),
    email              varchar(255),
    phone              varchar(255),
    password           varchar(255),
    login_count        int,

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned,
    primary key (id)
) engine = InnoDB;