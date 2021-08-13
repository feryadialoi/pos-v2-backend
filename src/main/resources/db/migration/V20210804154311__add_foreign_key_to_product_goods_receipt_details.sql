alter table product_goods_receipt_details
    add constraint fk_product_goods_receipt_details_product_goods_receipt_id
        foreign key (product_goods_receipt_id)
            references product_goods_receipts (id);

alter table product_goods_receipt_details
    add constraint fk_product_goods_receipt_details_product_id
        foreign key (product_id)
            references products (id);