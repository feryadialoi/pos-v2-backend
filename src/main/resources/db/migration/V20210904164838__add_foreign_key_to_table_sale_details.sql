alter table sale_details
    add constraint fk_sale_details_sale_order_id
        foreign key (sale_id)
            references sales (id);

alter table sale_details
    add constraint fk_sale_details_product_id
        foreign key (product_id)
            references products (id);



alter table sale_details
    add constraint fk_sale_details_unit_id
        foreign key (unit_id)
            references units (id);

alter table sale_details
    add constraint fk_sale_details_warehouse_id
        foreign key (warehouse_id)
            references warehouses (id);

