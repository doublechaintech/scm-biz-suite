
package com.doublechaintech.retailscm.productsupplyduration;
import com.doublechaintech.retailscm.AccessKey;


public class ProductSupplyDurationTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="product_supply_duration_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_QUANTITY = "quantity";
	static final String COLUMN_DURATION = "duration";
	static final String COLUMN_PRICE = "price";
	static final String COLUMN_PRODUCT = "product";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_QUANTITY,COLUMN_DURATION,COLUMN_PRICE,COLUMN_PRODUCT,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_QUANTITY,COLUMN_DURATION,COLUMN_PRICE,COLUMN_PRODUCT};
	
	
}


