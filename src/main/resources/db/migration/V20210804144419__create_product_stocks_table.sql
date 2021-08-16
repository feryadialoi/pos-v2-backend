create table product_stocks
(
    id                 varchar(36),
    product_id         varchar(36),
    warehouse_id       varchar(36),
    stock              decimal(19, 2),

    created_date       timestamp(3),
    last_modified_date timestamp(3),
    deleted_date       timestamp(3),
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;