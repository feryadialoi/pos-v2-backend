create table delivery_order_details
(

    id                 varchar(34),
    delivery_order_id  varchar(34),
    product_id         varchar(34),
    unit_id            varchar(34),
    delivered_quantity decimal(19, 2),
    received_quantity  decimal(19, 2),
    note               varchar(255),

    created_date       timestamp(3),
    last_modified_date timestamp(3),
    deleted_date       timestamp(3),
    created_by         varchar(36),
    last_modified_by   varchar(36),
    primary key (id)
) engine = InnoDB;