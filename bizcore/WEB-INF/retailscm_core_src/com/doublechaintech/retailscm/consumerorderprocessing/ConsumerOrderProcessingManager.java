
package com.doublechaintech.retailscm.consumerorderprocessing;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderProcessingManager{

		

	public ConsumerOrderProcessing createConsumerOrderProcessing(RetailscmUserContext userContext, String who, Date processTime) throws Exception;	
	public ConsumerOrderProcessing updateConsumerOrderProcessing(RetailscmUserContext userContext,String consumerOrderProcessingId, int consumerOrderProcessingVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderProcessing loadConsumerOrderProcessing(RetailscmUserContext userContext, String consumerOrderProcessingId, String [] tokensExpr) throws Exception;
	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing) throws Exception;
	public ConsumerOrderProcessing internalSaveConsumerOrderProcessing(RetailscmUserContext userContext, ConsumerOrderProcessing consumerOrderProcessing,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String consumerOrderProcessingId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderProcessing newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


