create table product_stock_details
(
    id                 varchar(36),
    product_stock_id   varchar(36),
    quantity           decimal(19, 2),
    batch              varchar(255),

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;