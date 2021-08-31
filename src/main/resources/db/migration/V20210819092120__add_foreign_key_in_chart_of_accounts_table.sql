alter table chart_of_accounts
    add constraint fk_coas_parent_id
        foreign key (parent_id)
            references chart_of_accounts (id);