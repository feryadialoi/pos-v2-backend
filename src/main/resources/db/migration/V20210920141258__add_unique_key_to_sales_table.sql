alter table sales
    add constraint uk_sales_code
        unique key (code);