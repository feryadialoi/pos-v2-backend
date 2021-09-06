alter table purchase_orders
    modify column status enum ('DRAFT', 'APPROVED', 'AWAITING_APPROVAL', 'REFUSED', 'COMPLETE', 'VOID');