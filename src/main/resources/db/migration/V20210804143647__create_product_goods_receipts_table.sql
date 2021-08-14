create table product_goods_receipts
(
    id                 varchar(36),
    batch              varchar(255),
    entry_date         timestamp,

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;