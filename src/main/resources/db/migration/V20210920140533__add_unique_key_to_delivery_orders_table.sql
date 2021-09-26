alter table delivery_orders
    add constraint uk_delivery_orders_code
        unique key (code);