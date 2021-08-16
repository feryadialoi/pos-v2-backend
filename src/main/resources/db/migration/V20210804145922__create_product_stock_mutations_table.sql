create table product_stock_mutations
(
    id                      varchar(36),
    product_stock_id        varchar(36),
    product_stock_detail_id varchar(36),
    quantity_in             decimal(19, 2),
    quantity_out            decimal(19, 2),
    event                   ENUM ('SALE','PURCHASE','SALE_RETURN','PURCHASE_RETURN'),
    reference               varchar(255),

    created_date            timestamp(3),
    last_modified_date      timestamp(3),
    deleted_date            timestamp(3),
    created_by              varchar(36),
    last_modified_by        varchar(36),
    primary key (id)
) engine = InnoDB;