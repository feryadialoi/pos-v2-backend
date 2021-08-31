alter table chart_of_accounts
    add column normal_balance enum ('DEBIT', 'CREDIT')
        after account_code;