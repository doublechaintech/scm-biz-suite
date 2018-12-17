
package com.doublechaintech.retailscm.retailstoremembercoupon;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreMemberCouponManager{

		

	public RetailStoreMemberCoupon createRetailStoreMemberCoupon(RetailscmUserContext userContext, String name, String ownerId, String number) throws Exception;	
	public RetailStoreMemberCoupon updateRetailStoreMemberCoupon(RetailscmUserContext userContext,String retailStoreMemberCouponId, int retailStoreMemberCouponVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMemberCoupon loadRetailStoreMemberCoupon(RetailscmUserContext userContext, String retailStoreMemberCouponId, String [] tokensExpr) throws Exception;
	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon) throws Exception;
	public RetailStoreMemberCoupon internalSaveRetailStoreMemberCoupon(RetailscmUserContext userContext, RetailStoreMemberCoupon retailStoreMemberCoupon,Map<String,Object>option) throws Exception;
	
	public RetailStoreMemberCoupon transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberCouponId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String retailStoreMemberCouponId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberCoupon newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/
	



}


