
package com.doublechaintech.retailscm.retailstorecountrycenter;
import com.doublechaintech.retailscm.AccessKey;


public class RetailStoreCountryCenterTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_country_center_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_SERVICE_NUMBER = "service_number";
	static final String COLUMN_FOUNDED = "founded";
	static final String COLUMN_WEB_SITE = "web_site";
	static final String COLUMN_ADDRESS = "address";
	static final String COLUMN_OPERATED_BY = "operated_by";
	static final String COLUMN_LEGAL_REPRESENTATIVE = "legal_representative";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_SERVICE_NUMBER,COLUMN_FOUNDED,COLUMN_WEB_SITE,COLUMN_ADDRESS,COLUMN_OPERATED_BY,COLUMN_LEGAL_REPRESENTATIVE,COLUMN_DESCRIPTION,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_SERVICE_NUMBER,COLUMN_FOUNDED,COLUMN_WEB_SITE,COLUMN_ADDRESS,COLUMN_OPERATED_BY,COLUMN_LEGAL_REPRESENTATIVE,COLUMN_DESCRIPTION};
	
	
}


