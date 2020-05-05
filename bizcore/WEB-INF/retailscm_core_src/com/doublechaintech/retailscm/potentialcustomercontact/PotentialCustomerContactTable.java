
package com.doublechaintech.retailscm.potentialcustomercontact;
import com.doublechaintech.retailscm.AccessKey;


public class PotentialCustomerContactTable{


	public static AccessKey withId(Object value){
		AccessKey accessKey = new AccessKey();
		accessKey.setColumnName(COLUMN_ID);
		accessKey.setValue(value);
		return accessKey;
	}
	//Add extra identifiers
	

	//only this package can use this, so the scope is default, not public, not private either nor protected
	public static final String TABLE_NAME="potential_customer_contact_data";
	static final String COLUMN_ID = "id";
	static final String COLUMN_NAME = "name";
	static final String COLUMN_CONTACT_DATE = "contact_date";
	static final String COLUMN_CONTACT_METHOD = "contact_method";
	static final String COLUMN_POTENTIAL_CUSTOMER = "potential_customer";
	static final String COLUMN_CITY_PARTNER = "city_partner";
	static final String COLUMN_CONTACT_TO = "contact_to";
	static final String COLUMN_DESCRIPTION = "description";
	static final String COLUMN_LAST_UPDATE_TIME = "last_update_time";
	static final String COLUMN_VERSION = "version";
 
	public static final String []ALL_CLOUMNS = {COLUMN_ID,COLUMN_NAME,COLUMN_CONTACT_DATE,COLUMN_CONTACT_METHOD,COLUMN_POTENTIAL_CUSTOMER,COLUMN_CITY_PARTNER,COLUMN_CONTACT_TO,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME,COLUMN_VERSION};
	public static final String []NORMAL_CLOUMNS = {COLUMN_NAME,COLUMN_CONTACT_DATE,COLUMN_CONTACT_METHOD,COLUMN_POTENTIAL_CUSTOMER,COLUMN_CITY_PARTNER,COLUMN_CONTACT_TO,COLUMN_DESCRIPTION,COLUMN_LAST_UPDATE_TIME};
	
	
}


