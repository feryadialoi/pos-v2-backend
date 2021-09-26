alter table delivery_orders
    add constraint fk_delivery_orders_sale_id
        foreign key (sale_id)
            references sales (id);

alter table delivery_orders
    add constraint fk_delivery_orders_company_id
        foreign key (company_id)
            references companies (id);