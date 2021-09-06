alter table sales
    add constraint fk_sales_sale_order_id
        foreign key (sale_order_id)
            references sale_orders (id);