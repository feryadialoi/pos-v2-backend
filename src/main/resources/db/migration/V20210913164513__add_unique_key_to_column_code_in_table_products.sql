alter table products
    add constraint uk_products_code
        unique key (code);