alter table purchases
    add constraint fk_purchases_supplier_id
        foreign key (supplier_id)
            references suppliers (id);