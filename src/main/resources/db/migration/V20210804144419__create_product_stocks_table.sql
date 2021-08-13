create table product_stocks
(
    id                 bigint unsigned auto_increment,
    product_id         bigint unsigned,
    warehouse_id       bigint unsigned,
    stock              decimal(19, 2),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned,
    primary key (id)
) engine = InnoDB;