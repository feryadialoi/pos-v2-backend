alter table product_stocks
    add column unit_id varchar(36) after warehouse_id;

alter table product_stocks
    add constraint fk_product_stocks_unit_id
        foreign key (unit_id)
            references units (id);