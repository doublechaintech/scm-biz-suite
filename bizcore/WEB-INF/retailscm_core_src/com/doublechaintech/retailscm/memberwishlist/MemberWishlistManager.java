
package com.doublechaintech.retailscm.memberwishlist;
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




public interface MemberWishlistManager extends BaseManager{

		

  List<MemberWishlist> searchMemberWishlistList(RetailscmUserContext ctx, MemberWishlistRequest pRequest);
  MemberWishlist searchMemberWishlist(RetailscmUserContext ctx, MemberWishlistRequest pRequest);
	public MemberWishlist createMemberWishlist(RetailscmUserContext userContext, String name,String ownerId) throws Exception;
	public MemberWishlist updateMemberWishlist(RetailscmUserContext userContext,String memberWishlistId, int memberWishlistVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public MemberWishlist loadMemberWishlist(RetailscmUserContext userContext, String memberWishlistId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public MemberWishlist internalSaveMemberWishlist(RetailscmUserContext userContext, MemberWishlist memberWishlist) throws Exception;
	public MemberWishlist internalSaveMemberWishlist(RetailscmUserContext userContext, MemberWishlist memberWishlist,Map<String,Object>option) throws Exception;

	public MemberWishlist transferToAnotherOwner(RetailscmUserContext userContext, String memberWishlistId, String anotherOwnerId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String memberWishlistId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, MemberWishlist newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, MemberWishlist updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  MemberWishlistProductManager getMemberWishlistProductManager(RetailscmUserContext userContext, String memberWishlistId, String name ,String [] tokensExpr)  throws Exception;

	public  MemberWishlist addMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, String name , String [] tokensExpr)  throws Exception;
	public  MemberWishlist removeMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion,String [] tokensExpr)  throws Exception;
	public  MemberWishlist updateMemberWishlistProduct(RetailscmUserContext userContext, String memberWishlistId, String memberWishlistProductId, int memberWishlistProductVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByOwner(RetailscmUserContext userContext,String ownerId) throws Exception;
	public Object listPageByOwner(RetailscmUserContext userContext,String ownerId, int start, int count) throws Exception;
  




}


