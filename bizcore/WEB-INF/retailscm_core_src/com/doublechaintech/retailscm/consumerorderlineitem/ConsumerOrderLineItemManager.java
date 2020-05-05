
package com.doublechaintech.retailscm.consumerorderlineitem;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderLineItemManager extends BaseManager{

		

	public ConsumerOrderLineItem createConsumerOrderLineItem(RetailscmUserContext userContext, String bizOrderId,String skuId,String skuName,BigDecimal price,BigDecimal quantity,BigDecimal amount) throws Exception;
	public ConsumerOrderLineItem updateConsumerOrderLineItem(RetailscmUserContext userContext,String consumerOrderLineItemId, int consumerOrderLineItemVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderLineItem loadConsumerOrderLineItem(RetailscmUserContext userContext, String consumerOrderLineItemId, String [] tokensExpr) throws Exception;
	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem) throws Exception;
	public ConsumerOrderLineItem internalSaveConsumerOrderLineItem(RetailscmUserContext userContext, ConsumerOrderLineItem consumerOrderLineItem,Map<String,Object>option) throws Exception;

	public ConsumerOrderLineItem transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderLineItemId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String consumerOrderLineItemId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderLineItem newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


