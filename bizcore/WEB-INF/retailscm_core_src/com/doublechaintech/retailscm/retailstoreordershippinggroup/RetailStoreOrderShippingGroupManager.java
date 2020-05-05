
package com.doublechaintech.retailscm.retailstoreordershippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreOrderShippingGroupManager extends BaseManager{

		

	public RetailStoreOrderShippingGroup createRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception;
	public RetailStoreOrderShippingGroup updateRetailStoreOrderShippingGroup(RetailscmUserContext userContext,String retailStoreOrderShippingGroupId, int retailStoreOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderShippingGroup loadRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String [] tokensExpr) throws Exception;
	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) throws Exception;
	public RetailStoreOrderShippingGroup internalSaveRetailStoreOrderShippingGroup(RetailscmUserContext userContext, RetailStoreOrderShippingGroup retailStoreOrderShippingGroup,Map<String,Object>option) throws Exception;

	public RetailStoreOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String retailStoreOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


