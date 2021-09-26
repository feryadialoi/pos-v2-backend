alter table sale_orders
    modify column status enum ('DRAFT', 'SENT', 'DECLINED', 'ACCEPTED', 'VOID');