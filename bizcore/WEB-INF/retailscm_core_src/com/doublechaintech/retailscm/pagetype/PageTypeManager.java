package com.doublechaintech.retailscm.pagetype;

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

public interface PageTypeManager extends BaseManager {

  public PageType loadPageTypeWithCode(
      RetailscmUserContext userContext, String code, Map<String, Object> tokens) throws Exception;

  List<PageType> searchPageTypeList(RetailscmUserContext ctx, PageTypeRequest pRequest);

  PageType searchPageType(RetailscmUserContext ctx, PageTypeRequest pRequest);

  public PageType createPageType(
      RetailscmUserContext userContext,
      String name,
      String code,
      String mobileAppId,
      boolean footerTab)
      throws Exception;

  public PageType updatePageType(
      RetailscmUserContext userContext,
      String pageTypeId,
      int pageTypeVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public PageType loadPageType(
      RetailscmUserContext userContext, String pageTypeId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public PageType internalSavePageType(RetailscmUserContext userContext, PageType pageType)
      throws Exception;

  public PageType internalSavePageType(
      RetailscmUserContext userContext, PageType pageType, Map<String, Object> option)
      throws Exception;

  public PageType transferToAnotherMobileApp(
      RetailscmUserContext userContext, String pageTypeId, String anotherMobileAppId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, PageType newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, PageType updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByMobileApp(RetailscmUserContext userContext, String mobileAppId)
      throws Exception;

  public Object listPageByMobileApp(
      RetailscmUserContext userContext, String mobileAppId, int start, int count) throws Exception;
}
