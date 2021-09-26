alter table purchase_return_details
    add constraint fk_purchase_return_details_purchase_return_id
        foreign key (purchase_return_id)
            references purchase_returns (id);

alter table purchase_return_details
    add constraint fk_purchase_return_details_product_id
        foreign key (product_id)
            references products (id);

alter table purchase_return_details
    add constraint fk_purchase_return_details_unit_id
        foreign key (unit_id)
            references units (id);