create table purchase_details
(
    id                 varchar(36),
    purchase_id        varchar(36),
    product_id         varchar(36),
    price              decimal(19, 2),
    quantity           decimal(19, 2),
    unit_id            varchar(36),
    tax                decimal(19, 2),
    tax_format         enum ('PERCENT', 'AMOUNT'),
    discount           decimal(19, 2),
    discount_format    enum ('PERCENT', 'AMOUNT'),
    amount             decimal(19, 2),

    created_date       timestamp(3),
    last_modified_date timestamp(3),
    deleted_date       timestamp(3),
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;