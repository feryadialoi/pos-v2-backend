alter table products_units
    add constraint fk_products_units_product_id
        foreign key (product_id)
            references products (id);

alter table products_units
    add constraint fk_products_units_unit_id
        foreign key (unit_id)
            references units (id);