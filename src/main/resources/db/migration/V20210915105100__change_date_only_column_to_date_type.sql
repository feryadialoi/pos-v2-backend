alter table purchase_orders
    modify entry_date date,
    modify due_date date;

alter table purchases
    modify entry_date date,
    modify due_date date;

alter table sale_orders
    modify entry_date date,
    modify due_date date;

alter table sales
    modify entry_date date,
    modify due_date date;

alter table journals
    modify entry_date date;

alter table journal_details
    modify entry_date date;

alter table product_goods_receipts
    modify entry_date date;