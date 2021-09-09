
package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;
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




public interface RetailStoreOrderPaymentGroupManager extends BaseManager{

		

  List<RetailStoreOrderPaymentGroup> searchRetailStoreOrderPaymentGroupList(RetailscmUserContext ctx, RetailStoreOrderPaymentGroupRequest pRequest);
  RetailStoreOrderPaymentGroup searchRetailStoreOrderPaymentGroup(RetailscmUserContext ctx, RetailStoreOrderPaymentGroupRequest pRequest);
	public RetailStoreOrderPaymentGroup createRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String name,String bizOrderId,String cardNumber) throws Exception;
	public RetailStoreOrderPaymentGroup updateRetailStoreOrderPaymentGroup(RetailscmUserContext userContext,String retailStoreOrderPaymentGroupId, int retailStoreOrderPaymentGroupVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreOrderPaymentGroup loadRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) throws Exception;
	public RetailStoreOrderPaymentGroup internalSaveRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup,Map<String,Object>option) throws Exception;

	public RetailStoreOrderPaymentGroup transferToAnotherBizOrder(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, String anotherBizOrderId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String retailStoreOrderPaymentGroupId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, RetailStoreOrderPaymentGroup updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByBizOrder(RetailscmUserContext userContext,String bizOrderId) throws Exception;
	public Object listPageByBizOrder(RetailscmUserContext userContext,String bizOrderId, int start, int count) throws Exception;
  




}


