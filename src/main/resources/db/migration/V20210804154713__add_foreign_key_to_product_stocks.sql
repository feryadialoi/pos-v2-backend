alter table product_stocks
    add constraint fk_product_stocks_product_id
        foreign key (product_id)
            references products (id);

alter table product_stocks
    add constraint fk_product_stocks_warehouse_id
        foreign key (warehouse_id)
            references warehouses (id);