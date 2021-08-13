alter table product_stock_mutations
    add constraint fk_product_stock_mutations_product_stock_id
        foreign key (product_stock_id)
            references product_stocks (id);

alter table product_stock_mutations
    add constraint fk_product_stock_mutations_product_stock_detail_id
        foreign key (product_stock_detail_id)
            references product_stock_details (id);