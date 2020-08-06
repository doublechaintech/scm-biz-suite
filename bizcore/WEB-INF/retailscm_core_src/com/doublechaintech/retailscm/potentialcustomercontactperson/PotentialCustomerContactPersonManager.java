
package com.doublechaintech.retailscm.potentialcustomercontactperson;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface PotentialCustomerContactPersonManager extends BaseManager{

		

	public PotentialCustomerContactPerson createPotentialCustomerContactPerson(RetailscmUserContext userContext, String name,String mobile,String potentialCustomerId,String description) throws Exception;
	public PotentialCustomerContactPerson updatePotentialCustomerContactPerson(RetailscmUserContext userContext,String potentialCustomerContactPersonId, int potentialCustomerContactPersonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomerContactPerson loadPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson) throws Exception;
	public PotentialCustomerContactPerson internalSavePotentialCustomerContactPerson(RetailscmUserContext userContext, PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object>option) throws Exception;

	public PotentialCustomerContactPerson transferToAnotherPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String anotherPotentialCustomerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String potentialCustomerContactPersonId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, PotentialCustomerContactPerson newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  PotentialCustomerContactManager getPotentialCustomerContactManager(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description ,String [] tokensExpr)  throws Exception;

	public  PotentialCustomerContactPerson addPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String name, Date contactDate, String contactMethod, String potentialCustomerId, String cityPartnerId, String description , String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson removePotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion,String [] tokensExpr)  throws Exception;
	public  PotentialCustomerContactPerson updatePotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactPersonId, String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  

}


