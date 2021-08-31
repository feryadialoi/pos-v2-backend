alter table product_stock_mutations
    add column unit_id varchar(36) after product_stock_detail_id;

alter table product_stock_mutations
    add constraint fk_product_stock_mutations_unit_id
        foreign key (unit_id)
            references units (id);