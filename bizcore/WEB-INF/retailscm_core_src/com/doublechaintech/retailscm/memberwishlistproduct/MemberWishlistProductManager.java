package com.doublechaintech.retailscm.memberwishlistproduct;

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

public interface MemberWishlistProductManager extends BaseManager {

  List<MemberWishlistProduct> searchMemberWishlistProductList(
      RetailscmUserContext ctx, MemberWishlistProductRequest pRequest);

  MemberWishlistProduct searchMemberWishlistProduct(
      RetailscmUserContext ctx, MemberWishlistProductRequest pRequest);

  public MemberWishlistProduct createMemberWishlistProduct(
      RetailscmUserContext userContext, String name, String ownerId) throws Exception;

  public MemberWishlistProduct updateMemberWishlistProduct(
      RetailscmUserContext userContext,
      String memberWishlistProductId,
      int memberWishlistProductVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public MemberWishlistProduct loadMemberWishlistProduct(
      RetailscmUserContext userContext, String memberWishlistProductId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public MemberWishlistProduct internalSaveMemberWishlistProduct(
      RetailscmUserContext userContext, MemberWishlistProduct memberWishlistProduct)
      throws Exception;

  public MemberWishlistProduct internalSaveMemberWishlistProduct(
      RetailscmUserContext userContext,
      MemberWishlistProduct memberWishlistProduct,
      Map<String, Object> option)
      throws Exception;

  public MemberWishlistProduct transferToAnotherOwner(
      RetailscmUserContext userContext, String memberWishlistProductId, String anotherOwnerId)
      throws Exception;

  public void onNewInstanceCreated(
      RetailscmUserContext userContext, MemberWishlistProduct newCreated) throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext,
      MemberWishlistProduct updated,
      Object actor,
      String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByOwner(RetailscmUserContext userContext, String ownerId) throws Exception;

  public Object listPageByOwner(
      RetailscmUserContext userContext, String ownerId, int start, int count) throws Exception;
}
