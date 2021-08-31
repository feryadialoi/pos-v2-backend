alter table company_settings
    add column setting_value_type enum ('STRING', 'BOOLEAN', 'BIG_DECIMAL', 'INTEGER', 'LONG', 'FLOAT', 'DOUBLE')
        after setting_value;