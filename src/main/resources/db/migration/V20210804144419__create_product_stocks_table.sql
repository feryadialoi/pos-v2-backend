create table product_stocks
(
    id                 varchar(36),
    product_id         varchar(36),
    warehouse_id       varchar(36),
    stock              decimal(19, 2),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;