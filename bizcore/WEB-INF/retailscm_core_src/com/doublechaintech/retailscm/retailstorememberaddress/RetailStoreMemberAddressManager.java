
package com.doublechaintech.retailscm.retailstorememberaddress;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface RetailStoreMemberAddressManager extends BaseManager{

		

	public RetailStoreMemberAddress createRetailStoreMemberAddress(RetailscmUserContext userContext, String name,String ownerId,String mobilePhone,String address) throws Exception;
	public RetailStoreMemberAddress updateRetailStoreMemberAddress(RetailscmUserContext userContext,String retailStoreMemberAddressId, int retailStoreMemberAddressVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public RetailStoreMemberAddress loadRetailStoreMemberAddress(RetailscmUserContext userContext, String retailStoreMemberAddressId, String [] tokensExpr) throws Exception;
	public RetailStoreMemberAddress internalSaveRetailStoreMemberAddress(RetailscmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress) throws Exception;
	public RetailStoreMemberAddress internalSaveRetailStoreMemberAddress(RetailscmUserContext userContext, RetailStoreMemberAddress retailStoreMemberAddress,Map<String,Object>option) throws Exception;

	public RetailStoreMemberAddress transferToAnotherOwner(RetailscmUserContext userContext, String retailStoreMemberAddressId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String retailStoreMemberAddressId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, RetailStoreMemberAddress newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


