create table product_stock_details
(
    id                 bigint unsigned auto_increment,
    product_stock_id   bigint unsigned,
    quantity           decimal(19, 2),
    batch              varchar(255),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned,
    primary key (id)
) engine = InnoDB;