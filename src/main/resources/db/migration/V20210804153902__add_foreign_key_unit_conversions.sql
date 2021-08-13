alter table unit_conversions
    add constraint fk_unit_conversions_from_unit_id
        foreign key (from_unit_id)
            references units (id);

alter table unit_conversions
    add constraint fk_unit_conversions_to_unit_id
        foreign key (to_unit_id)
            references units (id);

alter table unit_conversions
    add constraint fk_unit_conversions_product_id
        foreign key (product_id)
            references products (id);