
package com.doublechaintech.retailscm.memberwishlistproduct;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface MemberWishlistProductManager extends BaseManager{

		

	public MemberWishlistProduct createMemberWishlistProduct(RetailscmUserContext userContext, String name,String ownerId) throws Exception;
	public MemberWishlistProduct updateMemberWishlistProduct(RetailscmUserContext userContext,String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberWishlistProduct loadMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistProductId, String [] tokensExpr) throws Exception;
	public MemberWishlistProduct internalSaveMemberWishlistProduct(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct) throws Exception;
	public MemberWishlistProduct internalSaveMemberWishlistProduct(RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct,Map<String,Object>option) throws Exception;

	public MemberWishlistProduct transferToAnotherOwner(RetailscmUserContext userContext, String memberWishlistProductId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String memberWishlistProductId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberWishlistProduct newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  

}


