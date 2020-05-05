
package com.doublechaintech.retailscm.truckdriver;
import com.doublechaintech.retailscm.AccessKey;


public class TruckDriverTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="truck_driver_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_DRIVER_LICENSE_NUMBER = "driver_license_number";
	static final String COLUMN_CONTACT_NUMBER = "contact_number";
	static final String COLUMN_BELONGS_TO = "belongs_to";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_DRIVER_LICENSE_NUMBER,COLUMN_CONTACT_NUMBER,COLUMN_BELONGS_TO,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_DRIVER_LICENSE_NUMBER,COLUMN_CONTACT_NUMBER,COLUMN_BELONGS_TO};
	
	
}


