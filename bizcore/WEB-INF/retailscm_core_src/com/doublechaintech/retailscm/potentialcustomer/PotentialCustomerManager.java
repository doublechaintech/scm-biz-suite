
package com.doublechaintech.retailscm.potentialcustomer;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface PotentialCustomerManager extends BaseManager{

		

	public PotentialCustomer createPotentialCustomer(RetailscmUserContext userContext, String name,String mobile,String cityServiceCenterId,String cityPartnerId,String description) throws Exception;
	public PotentialCustomer updatePotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId, int potentialCustomerVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomer loadPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public PotentialCustomer internalSavePotentialCustomer(RetailscmUserContext userContext, PotentialCustomer potentialCustomer) throws Exception;
	public PotentialCustomer internalSavePotentialCustomer(RetailscmUserContext userContext, PotentialCustomer potentialCustomer,Map<String,Object>option) throws Exception;

	public PotentialCustomer transferToAnotherCityServiceCenter(RetailscmUserContext userContext, String potentialCustomerId, String anotherCityServiceCenterId)  throws Exception;
 	public PotentialCustomer transferToAnotherCityPartner(RetailscmUserContext userContext, String potentialCustomerId, String anotherCityPartnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String potentialCustomerId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, PotentialCustomer newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerContactPersonManager getPotentialCustomerContactPersonManager(RetailscmUserContext userContext, String potentialCustomerId, String name, String mobile, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerId, String name, String mobile, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerId, String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(RetailscmUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerId, String name, Date contactDate, String contactMethod, String cityPartnerId, String contactToId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removePotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updatePotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/

	//public  EventAttendanceManager getEventAttendanceManager(RetailscmUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomer addEventAttendance(RetailscmUserContext userContext, String potentialCustomerId, String name, String cityEventId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomer removeEventAttendance(RetailscmUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomer updateEventAttendance(RetailscmUserContext userContext, String potentialCustomerId, String eventAttendanceId, int eventAttendanceVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCityServiceCenter(RetailscmUserContext userContext,String cityServiceCenterId) throws Exception;
	public Object listPageByCityServiceCenter(RetailscmUserContext userContext,String cityServiceCenterId, int start, int count) throws Exception;
  
	public Object listByCityPartner(RetailscmUserContext userContext,String cityPartnerId) throws Exception;
	public Object listPageByCityPartner(RetailscmUserContext userContext,String cityPartnerId, int start, int count) throws Exception;
  

}


