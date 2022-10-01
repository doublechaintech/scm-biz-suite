package com.doublechaintech.retailscm.view;

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

public interface ViewManager extends BaseManager {

  List<View> searchViewList(RetailscmUserContext ctx, ViewRequest pRequest);

  View searchView(RetailscmUserContext ctx, ViewRequest pRequest);

  public View createView(
      RetailscmUserContext userContext, String who, String assessment, Date interviewTime)
      throws Exception;

  public View updateView(
      RetailscmUserContext userContext,
      String viewId,
      int viewVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public View loadView(RetailscmUserContext userContext, String viewId, String[] tokensExpr)
      throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public View internalSaveView(RetailscmUserContext userContext, View view) throws Exception;

  public View internalSaveView(
      RetailscmUserContext userContext, View view, Map<String, Object> option) throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, View newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, View updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

}
