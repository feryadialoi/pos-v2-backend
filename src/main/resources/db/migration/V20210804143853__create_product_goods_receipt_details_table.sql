create table product_goods_receipt_details
(
    id                       varchar(36),
    product_goods_receipt_id varchar(36),
    product_id               varchar(36),
    quantity                 decimal(19, 2),

    created_date             timestamp(3),
    last_modified_date       timestamp(3),
    deleted_date             timestamp(3),
    created_by               varchar(36),
    last_modified_by         varchar(36),
    primary key (id)
) engine = InnoDB;