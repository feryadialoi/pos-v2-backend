alter table company_settings
    add column category enum ('CHART_OF_ACCOUNT', 'GENERAL', 'OTHER')
        after setting_value_type;