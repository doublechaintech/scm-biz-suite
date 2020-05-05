
package com.doublechaintech.retailscm.transporttruck;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class TransportTruckGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for TransportTruck", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(TransportTruck.TRANSPORT_TASK_LIST.equals(listName)){
			return new String[]{"id","name","start","begin_time","end","driver","truck","belongs_to","latitude","longitude","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(TransportTruck.TRANSPORT_TASK_LIST.equals(listName)){
			return "transport_task";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





