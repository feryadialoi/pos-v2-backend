create table product_goods_receipt_details
(
    id                       bigint unsigned auto_increment,
    product_goods_receipt_id bigint unsigned,
    product_id               bigint unsigned,
    quantity                 decimal(19, 2),

    created_date             timestamp,
    last_modified_date       timestamp,
    deleted_date             timestamp,
    created_by               bigint unsigned,
    last_modified_by         bigint unsigned,
    primary key (id)
) engine = InnoDB;