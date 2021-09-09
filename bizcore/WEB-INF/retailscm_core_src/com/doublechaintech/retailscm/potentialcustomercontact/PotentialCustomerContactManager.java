
package com.doublechaintech.retailscm.potentialcustomercontact;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface PotentialCustomerContactManager extends BaseManager{

		

  List<PotentialCustomerContact> searchPotentialCustomerContactList(RetailscmUserContext ctx, PotentialCustomerContactRequest pRequest);
  PotentialCustomerContact searchPotentialCustomerContact(RetailscmUserContext ctx, PotentialCustomerContactRequest pRequest);
	public PotentialCustomerContact createPotentialCustomerContact(RetailscmUserContext userContext, String name,Date contactDate,String contactMethod,String potentialCustomerId,String cityPartnerId,String contactToId,String description) throws Exception;
	public PotentialCustomerContact updatePotentialCustomerContact(RetailscmUserContext userContext,String potentialCustomerContactId, int potentialCustomerContactVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PotentialCustomerContact loadPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerContactId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public PotentialCustomerContact internalSavePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact) throws Exception;
	public PotentialCustomerContact internalSavePotentialCustomerContact(RetailscmUserContext userContext, PotentialCustomerContact potentialCustomerContact,Map<String,Object>option) throws Exception;

	public PotentialCustomerContact transferToAnotherPotentialCustomer(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherPotentialCustomerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherCityPartner(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherCityPartnerId)  throws Exception;
 	public PotentialCustomerContact transferToAnotherContactTo(RetailscmUserContext userContext, String potentialCustomerContactId, String anotherContactToId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String potentialCustomerContactId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, PotentialCustomerContact newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, PotentialCustomerContact updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId) throws Exception;
	public Object listPageByPotentialCustomer(RetailscmUserContext userContext,String potentialCustomerId, int start, int count) throws Exception;
  
	public Object listByCityPartner(RetailscmUserContext userContext,String cityPartnerId) throws Exception;
	public Object listPageByCityPartner(RetailscmUserContext userContext,String cityPartnerId, int start, int count) throws Exception;
  
	public Object listByContactTo(RetailscmUserContext userContext,String contactToId) throws Exception;
	public Object listPageByContactTo(RetailscmUserContext userContext,String contactToId, int start, int count) throws Exception;
  




}


