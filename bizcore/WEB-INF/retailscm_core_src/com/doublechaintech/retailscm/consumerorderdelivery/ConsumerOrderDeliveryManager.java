
package com.doublechaintech.retailscm.consumerorderdelivery;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderDeliveryManager{

		

	public ConsumerOrderDelivery createConsumerOrderDelivery(RetailscmUserContext userContext, String who, Date deliveryTime) throws Exception;	
	public ConsumerOrderDelivery updateConsumerOrderDelivery(RetailscmUserContext userContext,String consumerOrderDeliveryId, int consumerOrderDeliveryVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderDelivery loadConsumerOrderDelivery(RetailscmUserContext userContext, String consumerOrderDeliveryId, String [] tokensExpr) throws Exception;
	public ConsumerOrderDelivery internalSaveConsumerOrderDelivery(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery) throws Exception;
	public ConsumerOrderDelivery internalSaveConsumerOrderDelivery(RetailscmUserContext userContext, ConsumerOrderDelivery consumerOrderDelivery,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String consumerOrderDeliveryId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderDelivery newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


