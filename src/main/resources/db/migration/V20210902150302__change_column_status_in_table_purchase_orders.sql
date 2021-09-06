alter table purchase_orders
    modify column status enum ('DRAFT', 'AWAITING_APPROVAL','APPROVED', 'REFUSED');