
package com.doublechaintech.retailscm.goodssupplier;
import com.doublechaintech.retailscm.AccessKey;


public class GoodsSupplierTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="goods_supplier_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_SUPPLY_PRODUCT = "supply_product";
	static final String COLUMN_BELONG_TO = "belong_to";
	static final String COLUMN_CONTACT_NUMBER = "contact_number";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_SUPPLY_PRODUCT,COLUMN_BELONG_TO,COLUMN_CONTACT_NUMBER,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_SUPPLY_PRODUCT,COLUMN_BELONG_TO,COLUMN_CONTACT_NUMBER,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME};
	
	
}


