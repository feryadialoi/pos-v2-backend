alter table purchases
    modify column status enum ('UNPAID', 'PARTIAL_PAID', 'PAID', 'VOID');