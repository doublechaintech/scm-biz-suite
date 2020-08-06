
package com.doublechaintech.retailscm.terminationtype;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface TerminationTypeManager extends BaseManager{

		

	public TerminationType createTerminationType(RetailscmUserContext userContext, String code,String companyId,String baseDescription,String detailDescription) throws Exception;
	public TerminationType updateTerminationType(RetailscmUserContext userContext,String terminationTypeId, int terminationTypeVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TerminationType loadTerminationType(RetailscmUserContext userContext, String terminationTypeId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public TerminationType internalSaveTerminationType(RetailscmUserContext userContext, TerminationType terminationType) throws Exception;
	public TerminationType internalSaveTerminationType(RetailscmUserContext userContext, TerminationType terminationType,Map<String,Object>option) throws Exception;

	public TerminationType transferToAnotherCompany(RetailscmUserContext userContext, String terminationTypeId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String terminationTypeId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, TerminationType newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TerminationManager getTerminationManager(RetailscmUserContext userContext, String terminationTypeId, String reasonId, String comment ,String [] tokensExpr)  throws Exception;

	public  TerminationType addTermination(RetailscmUserContext userContext, String terminationTypeId, String reasonId, String comment , String [] tokensExpr)  throws Exception;
	public  TerminationType removeTermination(RetailscmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion,String [] tokensExpr)  throws Exception;
	public  TerminationType updateTermination(RetailscmUserContext userContext, String terminationTypeId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


