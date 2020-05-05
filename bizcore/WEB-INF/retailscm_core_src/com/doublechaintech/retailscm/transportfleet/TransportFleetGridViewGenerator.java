
package com.doublechaintech.retailscm.transportfleet;
import com.doublechaintech.retailscm.AccessKey;

import com.doublechaintech.retailscm.BaseGridViewGenerator;

public class TransportFleetGridViewGenerator extends BaseGridViewGenerator{
	
	

	private static final long serialVersionUID = 1L;
	
	
	
	protected void throwExceptionIfListNotFount(String listName) {
		String message=String.format("List '%s' is not found for TransportFleet", listName);
		throw new IllegalArgumentException(message);
	}
	
	protected String [] getHeaderKeys(String listName) {
		
		if(TransportFleet.TRANSPORT_TRUCK_LIST.equals(listName)){
			return new String[]{"id","name","plate_number","contact_number","vehicle_license_number","engine_number","make_date","mileage","body_color","owner","version"};
		}
		if(TransportFleet.TRUCK_DRIVER_LIST.equals(listName)){
			return new String[]{"id","name","driver_license_number","contact_number","belongs_to","version"};
		}
		if(TransportFleet.TRANSPORT_TASK_LIST.equals(listName)){
			return new String[]{"id","name","start","begin_time","end","driver","truck","belongs_to","latitude","longitude","version"};
		}
		
		throwExceptionIfListNotFount(listName);
		return new String[]{}; // place holder, code will never go here!!!
		
		
	}
	protected String  getObjectKey(String listName) {
		if(TransportFleet.TRANSPORT_TRUCK_LIST.equals(listName)){
			return "transport_truck";
		}
		if(TransportFleet.TRUCK_DRIVER_LIST.equals(listName)){
			return "truck_driver";
		}
		if(TransportFleet.TRANSPORT_TASK_LIST.equals(listName)){
			return "transport_task";
		}
		

		throwExceptionIfListNotFount(listName);
		return ""; // place holder, code will never go here!!!
	}

}





