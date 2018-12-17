
package com.doublechaintech.retailscm.eventattendance;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface EventAttendanceManager{

		

	public EventAttendance createEventAttendance(RetailscmUserContext userContext, String name, String potentialCustomerId, String cityEventId, String description) throws Exception;	
	public EventAttendance updateEventAttendance(RetailscmUserContext userContext,String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public EventAttendance loadEventAttendance(RetailscmUserContext userContext, String eventAttendanceId, String [] tokensExpr) throws Exception;
	public EventAttendance internalSaveEventAttendance(RetailscmUserContext userContext, EventAttendance eventAttendance) throws Exception;
	public EventAttendance internalSaveEventAttendance(RetailscmUserContext userContext, EventAttendance eventAttendance,Map<String,Object>option) throws Exception;
	
	public EventAttendance transferToAnotherPotentialCustomer(RetailscmUserContext userContext, String eventAttendanceId, String anotherPotentialCustomerId)  throws Exception;
 	public EventAttendance transferToAnotherCityEvent(RetailscmUserContext userContext, String eventAttendanceId, String anotherCityEventId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String eventAttendanceId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, EventAttendance newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


