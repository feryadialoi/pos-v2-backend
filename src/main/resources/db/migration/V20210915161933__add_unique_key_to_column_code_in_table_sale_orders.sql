alter table sale_orders
    add constraint uk_sale_orders_code
        unique key (code);