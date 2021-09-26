alter table sale_returns
    add constraint fk_sale_returns_sale_id
        foreign key (sale_id)
            references sales (id);

alter table sale_returns
    add constraint fk_sale_returns_customer_id
        foreign key (customer_id)
            references customers (id);

alter table sale_returns
    add constraint fk_sale_returns_salesman_id
        foreign key (salesman_id)
            references salesmen (id);