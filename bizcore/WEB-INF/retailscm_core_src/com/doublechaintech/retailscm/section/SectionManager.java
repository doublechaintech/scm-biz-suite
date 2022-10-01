package com.doublechaintech.retailscm.section;

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

public interface SectionManager extends BaseManager {

  List<Section> searchSectionList(RetailscmUserContext ctx, SectionRequest pRequest);

  Section searchSection(RetailscmUserContext ctx, SectionRequest pRequest);

  public Section createSection(
      RetailscmUserContext userContext,
      String title,
      String brief,
      String icon,
      int displayOrder,
      String viewGroup,
      String linkToUrl,
      String pageId)
      throws Exception;

  public Section updateSection(
      RetailscmUserContext userContext,
      String sectionId,
      int sectionVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public Section loadSection(
      RetailscmUserContext userContext, String sectionId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public Section internalSaveSection(RetailscmUserContext userContext, Section section)
      throws Exception;

  public Section internalSaveSection(
      RetailscmUserContext userContext, Section section, Map<String, Object> option)
      throws Exception;

  public Section transferToAnotherPage(
      RetailscmUserContext userContext, String sectionId, String anotherPageId) throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, Section newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, Section updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  public Object listByPage(RetailscmUserContext userContext, String pageId) throws Exception;

  public Object listPageByPage(
      RetailscmUserContext userContext, String pageId, int start, int count) throws Exception;
}
