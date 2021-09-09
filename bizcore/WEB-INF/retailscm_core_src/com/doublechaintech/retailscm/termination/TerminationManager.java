
package com.doublechaintech.retailscm.termination;
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




public interface TerminationManager extends BaseManager{

		

  List<Termination> searchTerminationList(RetailscmUserContext ctx, TerminationRequest pRequest);
  Termination searchTermination(RetailscmUserContext ctx, TerminationRequest pRequest);
	public Termination createTermination(RetailscmUserContext userContext, String reasonId,String typeId,String comment) throws Exception;
	public Termination updateTermination(RetailscmUserContext userContext,String terminationId, int terminationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Termination loadTermination(RetailscmUserContext userContext, String terminationId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination) throws Exception;
	public Termination internalSaveTermination(RetailscmUserContext userContext, Termination termination,Map<String,Object>option) throws Exception;

	public Termination transferToAnotherReason(RetailscmUserContext userContext, String terminationId, String anotherReasonId)  throws Exception;
 	public Termination transferToAnotherType(RetailscmUserContext userContext, String terminationId, String anotherTypeId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String terminationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Termination newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, Termination updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByReason(RetailscmUserContext userContext,String reasonId) throws Exception;
	public Object listPageByReason(RetailscmUserContext userContext,String reasonId, int start, int count) throws Exception;
  
	public Object listByType(RetailscmUserContext userContext,String typeId) throws Exception;
	public Object listPageByType(RetailscmUserContext userContext,String typeId, int start, int count) throws Exception;
  




}


