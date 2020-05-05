
package com.doublechaintech.retailscm.accountset;
import com.doublechaintech.retailscm.AccessKey;


public class AccountSetTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="account_set_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_YEAR_SET = "year_set";
	static final String COLUMN_EFFECTIVE_DATE = "effective_date";
	static final String COLUMN_ACCOUNTING_SYSTEM = "accounting_system";
	static final String COLUMN_DOMESTIC_CURRENCY_CODE = "domestic_currency_code";
	static final String COLUMN_DOMESTIC_CURRENCY_NAME = "domestic_currency_name";
	static final String COLUMN_OPENING_BANK = "opening_bank";
	static final String COLUMN_ACCOUNT_NUMBER = "account_number";
	static final String COLUMN_COUNTRY_CENTER = "country_center";
	static final String COLUMN_RETAIL_STORE = "retail_store";
	static final String COLUMN_GOODS_SUPPLIER = "goods_supplier";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_YEAR_SET,COLUMN_EFFECTIVE_DATE,COLUMN_ACCOUNTING_SYSTEM,COLUMN_DOMESTIC_CURRENCY_CODE,COLUMN_DOMESTIC_CURRENCY_NAME,COLUMN_OPENING_BANK,COLUMN_ACCOUNT_NUMBER,COLUMN_COUNTRY_CENTER,COLUMN_RETAIL_STORE,COLUMN_GOODS_SUPPLIER,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_YEAR_SET,COLUMN_EFFECTIVE_DATE,COLUMN_ACCOUNTING_SYSTEM,COLUMN_DOMESTIC_CURRENCY_CODE,COLUMN_DOMESTIC_CURRENCY_NAME,COLUMN_OPENING_BANK,COLUMN_ACCOUNT_NUMBER,COLUMN_COUNTRY_CENTER,COLUMN_RETAIL_STORE,COLUMN_GOODS_SUPPLIER,COLUMN_LAST_UPDATE_TIME};
	
	
}


