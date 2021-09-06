alter table sale_order_details
    add constraint fk_sale_order_details_sale_order_id
        foreign key (sale_order_id)
            references sale_orders (id);

alter table sale_order_details
    add constraint fk_sale_order_details_product_id
        foreign key (product_id)
            references products (id);



alter table sale_order_details
    add constraint fk_sale_order_details_unit_id
        foreign key (unit_id)
            references units (id);

alter table sale_order_details
    add constraint fk_sale_order_details_warehouse_id
        foreign key (warehouse_id)
            references warehouses (id);

