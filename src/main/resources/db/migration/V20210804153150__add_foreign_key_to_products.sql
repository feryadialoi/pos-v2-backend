alter table products
    add constraint fk_products_unit_large_id
        foreign key (unit_large_id)
            references units (id);

alter table products
    add constraint fk_products_unit_medium_id
        foreign key (unit_medium_id)
            references units (id);

alter table products
    add constraint fk_products_unit_small_id
        foreign key (unit_small_id)
            references units (id);

alter table products
    add constraint fk_products_category_id
        foreign key (category_id)
            references categories (id);