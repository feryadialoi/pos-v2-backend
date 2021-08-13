create table permissions
(
    id                 bigint unsigned auto_increment,
    name               varchar(255),
    display_name       varchar(255),
    description        varchar(255),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned,
    primary key (id)
) engine = InnoDB;