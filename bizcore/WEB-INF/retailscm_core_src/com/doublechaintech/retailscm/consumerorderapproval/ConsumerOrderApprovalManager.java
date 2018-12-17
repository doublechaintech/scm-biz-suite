
package com.doublechaintech.retailscm.consumerorderapproval;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderApprovalManager{

		

	public ConsumerOrderApproval createConsumerOrderApproval(RetailscmUserContext userContext, String who, Date approveTime) throws Exception;	
	public ConsumerOrderApproval updateConsumerOrderApproval(RetailscmUserContext userContext,String consumerOrderApprovalId, int consumerOrderApprovalVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderApproval loadConsumerOrderApproval(RetailscmUserContext userContext, String consumerOrderApprovalId, String [] tokensExpr) throws Exception;
	public ConsumerOrderApproval internalSaveConsumerOrderApproval(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval) throws Exception;
	public ConsumerOrderApproval internalSaveConsumerOrderApproval(RetailscmUserContext userContext, ConsumerOrderApproval consumerOrderApproval,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String consumerOrderApprovalId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderApproval newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


