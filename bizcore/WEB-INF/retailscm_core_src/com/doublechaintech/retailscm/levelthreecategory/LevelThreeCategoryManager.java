package com.doublechaintech.retailscm.levelthreecategory;

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

public interface LevelThreeCategoryManager extends BaseManager {

  List<LevelThreeCategory> searchLevelThreeCategoryList(
      RetailscmUserContext ctx, LevelThreeCategoryRequest pRequest);

  LevelThreeCategory searchLevelThreeCategory(
      RetailscmUserContext ctx, LevelThreeCategoryRequest pRequest);

  public LevelThreeCategory createLevelThreeCategory(
      RetailscmUserContext userContext, String parentCategoryId, String name) throws Exception;

  public LevelThreeCategory updateLevelThreeCategory(
      RetailscmUserContext userContext,
      String levelThreeCategoryId,
      int levelThreeCategoryVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public LevelThreeCategory loadLevelThreeCategory(
      RetailscmUserContext userContext, String levelThreeCategoryId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public LevelThreeCategory internalSaveLevelThreeCategory(
      RetailscmUserContext userContext, LevelThreeCategory levelThreeCategory) throws Exception;

  public LevelThreeCategory internalSaveLevelThreeCategory(
      RetailscmUserContext userContext,
      LevelThreeCategory levelThreeCategory,
      Map<String, Object> option)
      throws Exception;

  public LevelThreeCategory transferToAnotherParentCategory(
      RetailscmUserContext userContext, String levelThreeCategoryId, String anotherParentCategoryId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, LevelThreeCategory newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, LevelThreeCategory updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  ProductManager getProductManager(RetailscmUserContext userContext, String
  // levelThreeCategoryId, String name, String origin, String remark, String brand, String picture
  // ,String [] tokensExpr)  throws Exception;

  public LevelThreeCategory addProduct(
      RetailscmUserContext userContext,
      String levelThreeCategoryId,
      String name,
      String origin,
      String remark,
      String brand,
      String picture,
      String[] tokensExpr)
      throws Exception;

  public LevelThreeCategory removeProduct(
      RetailscmUserContext userContext,
      String levelThreeCategoryId,
      String productId,
      int productVersion,
      String[] tokensExpr)
      throws Exception;

  public LevelThreeCategory updateProduct(
      RetailscmUserContext userContext,
      String levelThreeCategoryId,
      String productId,
      int productVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByParentCategory(RetailscmUserContext userContext, String parentCategoryId)
      throws Exception;

  public Object listPageByParentCategory(
      RetailscmUserContext userContext, String parentCategoryId, int start, int count)
      throws Exception;
}
