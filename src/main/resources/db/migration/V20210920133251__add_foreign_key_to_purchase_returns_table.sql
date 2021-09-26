alter table purchase_returns
    add constraint fk_purchase_returns_purchase_id
        foreign key (purchase_id)
            references purchases (id);

alter table purchase_returns
    add constraint fk_purchase_returns_supplier_id
        foreign key (supplier_id)
            references suppliers (id);