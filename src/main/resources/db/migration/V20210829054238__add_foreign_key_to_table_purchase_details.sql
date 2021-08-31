alter table purchase_details
    add constraint fk_purchase_details_purchase_id
        foreign key (purchase_id)
            references purchase_orders (id);

alter table purchase_details
    add constraint fk_purchase_details_warehouse_id
        foreign key (warehouse_id)
            references warehouses (id);

alter table purchase_details
    add constraint fk_purchase_details_product_id
        foreign key (product_id)
            references products (id);

alter table purchase_details
    add constraint fk_purchase_details_unit_id
        foreign key (unit_id)
            references units (id);