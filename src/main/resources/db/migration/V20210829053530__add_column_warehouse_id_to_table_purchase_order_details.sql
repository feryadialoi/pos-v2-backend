alter table purchase_order_details
    add column warehouse_id varchar(36) after unit_id;