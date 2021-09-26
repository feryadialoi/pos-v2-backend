alter table sale_return_details
    add constraint fk_sale_return_details_sale_return_id
        foreign key (sale_return_id)
            references sale_returns (id);

alter table sale_return_details
    add constraint fk_sale_return_details_product_id
        foreign key (product_id)
            references products (id);

alter table sale_return_details
    add constraint fk_sale_return_details_unit_id
        foreign key (unit_id)
            references units (id);