alter table journal_details
    add constraint fk_journal_details_journal_id
        foreign key (journal_id)
            references journals (id);

alter table journal_details
    add constraint fk_journal_details_chart_of_account_id
        foreign key (chart_of_account_id)
            references chart_of_accounts (id);

