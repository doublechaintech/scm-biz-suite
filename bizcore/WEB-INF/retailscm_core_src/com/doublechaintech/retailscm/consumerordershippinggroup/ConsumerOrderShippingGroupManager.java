
package com.doublechaintech.retailscm.consumerordershippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderShippingGroupManager{

		

	public ConsumerOrderShippingGroup createConsumerOrderShippingGroup(RetailscmUserContext userContext, String name, String bizOrderId, BigDecimal amount) throws Exception;	
	public ConsumerOrderShippingGroup updateConsumerOrderShippingGroup(RetailscmUserContext userContext,String consumerOrderShippingGroupId, int consumerOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderShippingGroup loadConsumerOrderShippingGroup(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String [] tokensExpr) throws Exception;
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup) throws Exception;
	public ConsumerOrderShippingGroup internalSaveConsumerOrderShippingGroup(RetailscmUserContext userContext, ConsumerOrderShippingGroup consumerOrderShippingGroup,Map<String,Object>option) throws Exception;
	
	public ConsumerOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String consumerOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String consumerOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


