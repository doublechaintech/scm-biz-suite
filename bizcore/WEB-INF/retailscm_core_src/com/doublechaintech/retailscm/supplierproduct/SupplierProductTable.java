
package com.doublechaintech.retailscm.supplierproduct;
import com.doublechaintech.retailscm.AccessKey;


public class SupplierProductTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="supplier_product_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_PRODUCT_NAME = "product_name";
	static final String COLUMN_PRODUCT_DESCRIPTION = "product_description";
	static final String COLUMN_PRODUCT_UNIT = "product_unit";
	static final String COLUMN_SUPPLIER = "supplier";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_PRODUCT_NAME,COLUMN_PRODUCT_DESCRIPTION,COLUMN_PRODUCT_UNIT,COLUMN_SUPPLIER,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_PRODUCT_NAME,COLUMN_PRODUCT_DESCRIPTION,COLUMN_PRODUCT_UNIT,COLUMN_SUPPLIER};
	
	
}


