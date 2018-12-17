
package com.doublechaintech.retailscm.consumerorderconfirmation;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderConfirmationManager{

		

	public ConsumerOrderConfirmation createConsumerOrderConfirmation(RetailscmUserContext userContext, String who, Date confirmTime) throws Exception;	
	public ConsumerOrderConfirmation updateConsumerOrderConfirmation(RetailscmUserContext userContext,String consumerOrderConfirmationId, int consumerOrderConfirmationVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderConfirmation loadConsumerOrderConfirmation(RetailscmUserContext userContext, String consumerOrderConfirmationId, String [] tokensExpr) throws Exception;
	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation) throws Exception;
	public ConsumerOrderConfirmation internalSaveConsumerOrderConfirmation(RetailscmUserContext userContext, ConsumerOrderConfirmation consumerOrderConfirmation,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String consumerOrderConfirmationId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderConfirmation newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


