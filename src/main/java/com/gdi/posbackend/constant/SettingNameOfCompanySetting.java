package com.gdi.posbackend.constant;

/**
 * @author Feryadialoi
 * @date 8/28/2021 3:20 AM
 */
public enum SettingNameOfCompanySetting {

    UNIT,
    ACCOUNTING,
    COGS,
    IS_TAXED,
    TAX_RATED,

    COA_PURCHASE,
    COA_PURCHASE_RETURN,
    COA_PURCHASE_DISCOUNT,
    COA_PURCHASE_TAX,

    COA_SALE,
    COA_SALE_RETURN,
    COA_SALE_DISCOUNT,
    COA_SALE_TAX,

    COA_INCOME_SUMMARY,
    COA_RETAINED_EARNING,

    COA_PAYABLE,
    COA_RECEIVABLE,

    COA_TAX_IN, // ** for purchase
    COA_TAX_OUT, // ** for sale

    COA_DISCOUNT_IN,
    COA_DISCOUNT_OUT,

    COA_OTHER_FEE,

    COGS_METHOD,

}
