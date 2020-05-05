
package com.doublechaintech.retailscm.citypartner;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class CityPartnerGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for CityPartner", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(CityPartner.POTENTIAL_CUSTOMER_LIST.equals(listName)){
			return new String[]{"id","name","mobile","city_service_center","city_partner","description","last_update_time","version"};
		}
		if(CityPartner.POTENTIAL_CUSTOMER_CONTACT_LIST.equals(listName)){
			return new String[]{"id","name","contact_date","contact_method","potential_customer","city_partner","contact_to","description","last_update_time","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(CityPartner.POTENTIAL_CUSTOMER_LIST.equals(listName)){
			return "potential_customer";
		}
		if(CityPartner.POTENTIAL_CUSTOMER_CONTACT_LIST.equals(listName)){
			return "potential_customer_contact";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





