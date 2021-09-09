
package com.doublechaintech.retailscm.accountset;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.RetailscmBaseUtils;
import com.doublechaintech.retailscm.RetailscmUserContext;

import java.util.Map;

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

	  public static void ensureTable(RetailscmUserContext userContext, Map<String, Object> result) throws Exception {
        RetailscmBaseUtils.ensureTable(userContext, result, "account_set_data", new String[][]{
                new String[]{"id","varchar(48)"," not null","ID","",""},
                new String[]{"name","varchar(24)","","名称","",""},
                new String[]{"year_set","varchar(20)","","年组","",""},
                new String[]{"effective_date","date","","生效日期","",""},
                new String[]{"accounting_system","varchar(28)","","会计制度","",""},
                new String[]{"domestic_currency_code","varchar(12)","","本币代码","",""},
                new String[]{"domestic_currency_name","varchar(12)","","本币名称","",""},
                new String[]{"opening_bank","varchar(16)","","开户银行","",""},
                new String[]{"account_number","varchar(68)","","帐户号码","",""},
                new String[]{"country_center","varchar(48)","","全国运营中心","retail_store_country_center_data","id"},
                new String[]{"retail_store","varchar(48)","","双链小超","retail_store_data","id"},
                new String[]{"goods_supplier","varchar(48)","","产品供应商","goods_supplier_data","id"},
                new String[]{"last_update_time","datetime","","更新于","",""},
                new String[]{"version","int","","版本","",""}
            }, "账套", new String[]{
                "create unique index idx4id_ver_of_account_set on account_set_data (id, version);",
                "create  index idx4effective_date_of_account_set on account_set_data (effective_date);",
                "create  index idx4last_update_time_of_account_set on account_set_data (last_update_time);"
         }, new String[]{
                "alter table account_set_data add constraint pk4id_of_account_set_data primary key (id);",
                "alter table account_set_data add constraint fk4country_center_of_account_set_data foreign key (country_center) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table account_set_data add constraint fk4retail_store_of_account_set_data foreign key (retail_store) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                "alter table account_set_data add constraint fk4goods_supplier_of_account_set_data foreign key (goods_supplier) references goods_supplier_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
                ""
         });
  }


}


