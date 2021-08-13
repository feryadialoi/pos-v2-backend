create table product_goods_receipts
(
    id                 bigint unsigned auto_increment,
    batch              varchar(255),
    entry_date         timestamp,

    created_date       timestamp,
    last_modified_date timestamp,
    deleted_date       timestamp,
    created_by         bigint unsigned,
    last_modified_by   bigint unsigned,
    primary key (id)
) engine = InnoDB;