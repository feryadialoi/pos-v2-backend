alter table sales
    add constraint fk_sales_customer_id
        foreign key (customer_id)
            references customers (id);

alter table sales
    add constraint fk_sales_salesman_id
        foreign key (salesman_id)
            references salesmen (id);