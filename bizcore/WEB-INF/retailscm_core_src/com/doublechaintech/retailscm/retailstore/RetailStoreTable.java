
package com.doublechaintech.retailscm.retailstore;
import com.doublechaintech.retailscm.AccessKey;


public class RetailStoreTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="retail_store_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_TELEPHONE = "telephone";
	static final String COLUMN_OWNER = "owner";
	static final String COLUMN_RETAIL_STORE_COUNTRY_CENTER = "retail_store_country_center";
	static final String COLUMN_CITY_SERVICE_CENTER = "city_service_center";
	static final String COLUMN_CREATION = "creation";
	static final String COLUMN_INVESTMENT_INVITATION = "investment_invitation";
	static final String COLUMN_FRANCHISING = "franchising";
	static final String COLUMN_DECORATION = "decoration";
	static final String COLUMN_OPENING = "opening";
	static final String COLUMN_CLOSING = "closing";
	static final String COLUMN_FOUNDED = "founded";
	static final String COLUMN_LATITUDE = "latitude";
	static final String COLUMN_LONGITUDE = "longitude";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_TELEPHONE,COLUMN_OWNER,COLUMN_RETAIL_STORE_COUNTRY_CENTER,COLUMN_CITY_SERVICE_CENTER,COLUMN_CREATION,COLUMN_INVESTMENT_INVITATION,COLUMN_FRANCHISING,COLUMN_DECORATION,COLUMN_OPENING,COLUMN_CLOSING,COLUMN_FOUNDED,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_TELEPHONE,COLUMN_OWNER,COLUMN_RETAIL_STORE_COUNTRY_CENTER,COLUMN_CITY_SERVICE_CENTER,COLUMN_CREATION,COLUMN_INVESTMENT_INVITATION,COLUMN_FRANCHISING,COLUMN_DECORATION,COLUMN_OPENING,COLUMN_CLOSING,COLUMN_FOUNDED,COLUMN_LATITUDE,COLUMN_LONGITUDE,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME};
	
	
}


