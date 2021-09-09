
package com.doublechaintech.retailscm.potentialcustomercontactperson;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class PotentialCustomerContactPersonGridViewGenerator extends BaseGridViewGenerator{



	private static final long serialVersionUID = 1L;



	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for PotentialCustomerContactPerson", listName);
		throw new IllegalArgumentException(message);
	}

	protected String [] getHeaderKeys(String listName) {

		if(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_CONTACT_LIST.equals(listName)){
			return new String[]{"id","name","contact_date","contact_method","potential_customer","city_partner","contact_to","description","last_update_time","version"};
		}

		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!


	}
	protected String  getObjectKey(String listName) {
		if(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_CONTACT_LIST.equals(listName)){
			return "potential_customer_contact";
		}


		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





