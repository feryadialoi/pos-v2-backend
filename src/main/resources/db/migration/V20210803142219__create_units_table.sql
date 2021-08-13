create table units
(
    id                 bigint unsigned auto_increment primary key,
    name               varchar(255),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned
) engine = InnoDB;