
package com.doublechaintech.retailscm.supplyordershippinggroup;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SupplyOrderShippingGroupManager extends BaseManager{

		

	public SupplyOrderShippingGroup createSupplyOrderShippingGroup(RetailscmUserContext userContext, String name,String bizOrderId,BigDecimal amount) throws Exception;
	public SupplyOrderShippingGroup updateSupplyOrderShippingGroup(RetailscmUserContext userContext,String supplyOrderShippingGroupId, int supplyOrderShippingGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public SupplyOrderShippingGroup loadSupplyOrderShippingGroup(RetailscmUserContext userContext, String supplyOrderShippingGroupId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup) throws Exception;
	public SupplyOrderShippingGroup internalSaveSupplyOrderShippingGroup(RetailscmUserContext userContext, SupplyOrderShippingGroup supplyOrderShippingGroup,Map<String,Object>option) throws Exception;

	public SupplyOrderShippingGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String supplyOrderShippingGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String supplyOrderShippingGroupId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, SupplyOrderShippingGroup newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  

}


