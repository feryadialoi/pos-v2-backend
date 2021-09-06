alter table purchase_details
    drop key fk_purchase_details_purchase_id;


alter table purchase_details
    add constraint fk_purchase_details_purchase_id
        foreign key (purchase_id) references purchases (id);