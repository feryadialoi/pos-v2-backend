alter table delivery_order_details
    add constraint fk_delivery_order_details_delivery_order_id
        foreign key (delivery_order_id)
            references delivery_orders (id);

alter table delivery_order_details
    add constraint fk_delivery_order_details_product_id
        foreign key (product_id)
            references products (id);

alter table delivery_order_details
    add constraint fk_delivery_order_details_unit_id
        foreign key (unit_id)
            references units (id);

