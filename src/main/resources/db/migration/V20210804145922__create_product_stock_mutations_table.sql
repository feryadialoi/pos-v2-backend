create table product_stock_mutations
(
    id                      bigint unsigned auto_increment,
    product_stock_id        bigint unsigned,
    product_stock_detail_id bigint unsigned,
    quantity_in             decimal(19, 2),
    quantity_out            decimal(19, 2),
    event                   ENUM ('SALE','PURCHASE','SALE_RETURN','PURCHASE_RETURN'),
    reference               varchar(255),

    created_date            timestamp,
    last_modified_date      timestamp,
    deleted_date            timestamp,
    created_by              bigint unsigned,
    last_modified_by        bigint unsigned,
    primary key (id)
) engine = InnoDB;