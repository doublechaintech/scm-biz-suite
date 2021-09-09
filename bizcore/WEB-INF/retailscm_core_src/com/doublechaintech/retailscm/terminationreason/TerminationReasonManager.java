
package com.doublechaintech.retailscm.terminationreason;
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




public interface TerminationReasonManager extends BaseManager{

		

  List<TerminationReason> searchTerminationReasonList(RetailscmUserContext ctx, TerminationReasonRequest pRequest);
  TerminationReason searchTerminationReason(RetailscmUserContext ctx, TerminationReasonRequest pRequest);
	public TerminationReason createTerminationReason(RetailscmUserContext userContext, String code,String companyId,String description) throws Exception;
	public TerminationReason updateTerminationReason(RetailscmUserContext userContext,String terminationReasonId, int terminationReasonVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public TerminationReason loadTerminationReason(RetailscmUserContext userContext, String terminationReasonId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public TerminationReason internalSaveTerminationReason(RetailscmUserContext userContext, TerminationReason terminationReason) throws Exception;
	public TerminationReason internalSaveTerminationReason(RetailscmUserContext userContext, TerminationReason terminationReason,Map<String,Object>option) throws Exception;

	public TerminationReason transferToAnotherCompany(RetailscmUserContext userContext, String terminationReasonId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String terminationReasonId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, TerminationReason newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, TerminationReason updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  TerminationManager getTerminationManager(RetailscmUserContext userContext, String terminationReasonId, String typeId, String comment ,String [] tokensExpr)  throws Exception;

	public  TerminationReason addTermination(RetailscmUserContext userContext, String terminationReasonId, String typeId, String comment , String [] tokensExpr)  throws Exception;
	public  TerminationReason removeTermination(RetailscmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion,String [] tokensExpr)  throws Exception;
	public  TerminationReason updateTermination(RetailscmUserContext userContext, String terminationReasonId, String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  




}


