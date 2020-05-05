
package com.doublechaintech.retailscm.potentialcustomer;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class PotentialCustomerGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for PotentialCustomer", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST.equals(listName)){
			return new String[]{"id","name","mobile","potential_customer","description","version"};
		}
		if(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_LIST.equals(listName)){
			return new String[]{"id","name","contact_date","contact_method","potential_customer","city_partner","contact_to","description","last_update_time","version"};
		}
		if(PotentialCustomer.EVENT_ATTENDANCE_LIST.equals(listName)){
			return new String[]{"id","name","potential_customer","city_event","description","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST.equals(listName)){
			return "potential_customer_contact_person";
		}
		if(PotentialCustomer.POTENTIAL_CUSTOMER_CONTACT_LIST.equals(listName)){
			return "potential_customer_contact";
		}
		if(PotentialCustomer.EVENT_ATTENDANCE_LIST.equals(listName)){
			return "event_attendance";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





