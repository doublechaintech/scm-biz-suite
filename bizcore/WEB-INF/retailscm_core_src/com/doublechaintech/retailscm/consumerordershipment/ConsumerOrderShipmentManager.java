
package com.doublechaintech.retailscm.consumerordershipment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface ConsumerOrderShipmentManager{

		

	public ConsumerOrderShipment createConsumerOrderShipment(RetailscmUserContext userContext, String who, Date shipTime) throws Exception;	
	public ConsumerOrderShipment updateConsumerOrderShipment(RetailscmUserContext userContext,String consumerOrderShipmentId, int consumerOrderShipmentVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public ConsumerOrderShipment loadConsumerOrderShipment(RetailscmUserContext userContext, String consumerOrderShipmentId, String [] tokensExpr) throws Exception;
	public ConsumerOrderShipment internalSaveConsumerOrderShipment(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment) throws Exception;
	public ConsumerOrderShipment internalSaveConsumerOrderShipment(RetailscmUserContext userContext, ConsumerOrderShipment consumerOrderShipment,Map<String,Object>option) throws Exception;
	


	public void delete(RetailscmUserContext userContext, String consumerOrderShipmentId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, ConsumerOrderShipment newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


