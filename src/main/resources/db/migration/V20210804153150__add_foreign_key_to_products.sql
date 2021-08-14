alter table products
    add constraint fk_products_category_id
        foreign key (category_id)
            references categories (id);

alter table products
    add constraint fk_products_brand_id
        foreign key (brand_id)
            references brands (id);