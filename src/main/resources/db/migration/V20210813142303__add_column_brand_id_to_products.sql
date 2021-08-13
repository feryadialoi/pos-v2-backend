alter table products
    add column brand_id bigint unsigned
        after category_id;


alter table products
    add constraint fk_products_brand_id
        foreign key (brand_id)
            references brands (id);