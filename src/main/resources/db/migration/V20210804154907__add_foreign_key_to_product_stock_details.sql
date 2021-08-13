alter table product_stock_details
    add constraint fk_product_stock_details_product_stock_id
        foreign key (product_stock_id)
            references product_stocks (id);