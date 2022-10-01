package com.doublechaintech.retailscm.userapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.listaccess.ListAccess;
import com.doublechaintech.retailscm.quicklink.QuickLink;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.listaccess.ListAccessRequest;
import com.doublechaintech.retailscm.quicklink.QuickLinkRequest;
import com.doublechaintech.retailscm.secuser.SecUserRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.userapp.UserApp.*;

public class UserAppRequest extends BaseRequest<UserApp> {
  public static UserAppRequest newInstance() {
    return new UserAppRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public UserAppRequest resultByClass(Class<? extends UserApp> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public UserAppRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public UserAppRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "UserApp";
  }

  public UserAppRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public UserAppRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public UserAppRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public UserAppRequest select(String... names) {
    super.select(names);
    return this;
  }

  public UserAppRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectSecUser()
        .selectAppIcon()
        .selectFullAccess()
        .selectPermission()
        .selectAppType()
        .selectAppId()
        .selectCtxType()
        .selectCtxId()
        .selectLocation()
        .selectVersion();
  }

  public UserAppRequest selectAny() {
    return selectAll()
        .selectQuickLinkList(Q.quickLink().selectSelf())
        .selectListAccessList(Q.listAccess().selectSelf());
  }

  public UserAppRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(SEC_USER_PROPERTY);
    select(APP_ICON_PROPERTY);
    select(FULL_ACCESS_PROPERTY);
    select(PERMISSION_PROPERTY);
    select(APP_TYPE_PROPERTY);
    select(APP_ID_PROPERTY);
    select(CTX_TYPE_PROPERTY);
    select(CTX_ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public UserAppRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public UserAppRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    TITLE_PROPERTY,
    SEC_USER_PROPERTY,
    APP_ICON_PROPERTY,
    FULL_ACCESS_PROPERTY,
    PERMISSION_PROPERTY,
    APP_TYPE_PROPERTY,
    APP_ID_PROPERTY,
    CTX_TYPE_PROPERTY,
    CTX_ID_PROPERTY,
    LOCATION_PROPERTY,
    VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public UserAppRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public UserAppRequest comment(String comment) {
    return this;
  }

  public UserAppRequest enhance() {
    return this;
  }

  public UserAppRequest overrideClass(Class<? extends UserApp> clazz) {
    return this;
  }

  public UserAppRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public UserAppRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public UserAppRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public UserAppRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public UserAppRequest count() {
    return countId("count");
  }

  public static UserAppRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public UserAppRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public UserAppRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectId() {
    return select(ID_PROPERTY);
  }

  public UserAppRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public UserAppRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public UserAppRequest countId() {
    return countId("countId");
  }

  public UserAppRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public UserAppRequest maxId() {
    return maxId("maxId");
  }

  public UserAppRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public UserAppRequest minId() {
    return minId("minId");
  }

  public UserAppRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public UserAppRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public UserAppRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public UserAppRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public UserAppRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public UserAppRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public UserAppRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public UserAppRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public UserAppRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public UserAppRequest countTitle() {
    return countTitle("countTitle");
  }

  public UserAppRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public UserAppRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public UserAppRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public UserAppRequest minTitle() {
    return minTitle("minTitle");
  }

  public UserAppRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public UserAppRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public UserAppRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public UserAppRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public UserAppRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public UserAppRequest filterByAppIcon(String appIcon) {

    if (appIcon == null) {
      return this;
    }

    return filterByAppIcon(QueryOperator.EQUAL, appIcon);
  }

  public UserAppRequest whereAppIconIsNull() {
    return where(APP_ICON_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereAppIconIsNotNull() {
    return where(APP_ICON_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByAppIcon(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAppIconSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectAppIcon() {
    return select(APP_ICON_PROPERTY);
  }

  public UserAppRequest unselectAppIcon() {
    return unselect(APP_ICON_PROPERTY);
  }

  public SearchCriteria getAppIconSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(APP_ICON_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByAppIcon(boolean asc) {
    addOrderBy(APP_ICON_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByAppIconAscending() {
    addOrderBy(APP_ICON_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByAppIconDescending() {
    addOrderBy(APP_ICON_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByAppIconAscendingUsingGBK() {
    addOrderBy("convert(appIcon using gbk)", true);
    return this;
  }

  public UserAppRequest orderByAppIconDescendingUsingGBK() {
    addOrderBy("convert(appIcon using gbk)", false);
    return this;
  }

  public UserAppRequest countAppIcon() {
    return countAppIcon("countAppIcon");
  }

  public UserAppRequest countAppIcon(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, APP_ICON_PROPERTY);
  }

  public UserAppRequest maxAppIcon() {
    return maxAppIcon("maxAppIcon");
  }

  public UserAppRequest maxAppIcon(String aggName) {
    return aggregate(aggName, AggFunc.MAX, APP_ICON_PROPERTY);
  }

  public UserAppRequest minAppIcon() {
    return minAppIcon("minAppIcon");
  }

  public UserAppRequest minAppIcon(String aggName) {
    return aggregate(aggName, AggFunc.MIN, APP_ICON_PROPERTY);
  }

  public UserAppRequest groupByAppIcon() {
    return groupByAppIcon(APP_ICON_PROPERTY);
  }

  public UserAppRequest groupByAppIcon(String ret) {
    return groupBy(ret, APP_ICON_PROPERTY);
  }

  public UserAppRequest groupByAppIcon(SqlFunction func) {
    return groupByAppIcon(APP_ICON_PROPERTY, func);
  }

  public UserAppRequest groupByAppIcon(String ret, SqlFunction func) {
    super.groupBy(ret, func, APP_ICON_PROPERTY);
    return this;
  }

  public UserAppRequest filterByFullAccess(boolean fullAccess) {

    return filterByFullAccess(QueryOperator.EQUAL, fullAccess);
  }

  public UserAppRequest whereFullAccessIsNull() {
    return where(FULL_ACCESS_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereFullAccessIsNotNull() {
    return where(FULL_ACCESS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByFullAccess(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFullAccessSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectFullAccess() {
    return select(FULL_ACCESS_PROPERTY);
  }

  public UserAppRequest unselectFullAccess() {
    return unselect(FULL_ACCESS_PROPERTY);
  }

  public SearchCriteria getFullAccessSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FULL_ACCESS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByFullAccess(boolean asc) {
    addOrderBy(FULL_ACCESS_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByFullAccessAscending() {
    addOrderBy(FULL_ACCESS_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByFullAccessDescending() {
    addOrderBy(FULL_ACCESS_PROPERTY, false);
    return this;
  }

  public UserAppRequest countFullAccess() {
    return countFullAccess("countFullAccess");
  }

  public UserAppRequest countFullAccess(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FULL_ACCESS_PROPERTY);
  }

  public UserAppRequest maxFullAccess() {
    return maxFullAccess("maxFullAccess");
  }

  public UserAppRequest maxFullAccess(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FULL_ACCESS_PROPERTY);
  }

  public UserAppRequest minFullAccess() {
    return minFullAccess("minFullAccess");
  }

  public UserAppRequest minFullAccess(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FULL_ACCESS_PROPERTY);
  }

  public UserAppRequest groupByFullAccess() {
    return groupByFullAccess(FULL_ACCESS_PROPERTY);
  }

  public UserAppRequest groupByFullAccess(String ret) {
    return groupBy(ret, FULL_ACCESS_PROPERTY);
  }

  public UserAppRequest groupByFullAccess(SqlFunction func) {
    return groupByFullAccess(FULL_ACCESS_PROPERTY, func);
  }

  public UserAppRequest groupByFullAccess(String ret, SqlFunction func) {
    super.groupBy(ret, func, FULL_ACCESS_PROPERTY);
    return this;
  }

  public UserAppRequest filterByPermission(String permission) {

    if (permission == null) {
      return this;
    }

    return filterByPermission(QueryOperator.EQUAL, permission);
  }

  public UserAppRequest wherePermissionIsNull() {
    return where(PERMISSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest wherePermissionIsNotNull() {
    return where(PERMISSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByPermission(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPermissionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectPermission() {
    return select(PERMISSION_PROPERTY);
  }

  public UserAppRequest unselectPermission() {
    return unselect(PERMISSION_PROPERTY);
  }

  public SearchCriteria getPermissionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PERMISSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByPermission(boolean asc) {
    addOrderBy(PERMISSION_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByPermissionAscending() {
    addOrderBy(PERMISSION_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByPermissionDescending() {
    addOrderBy(PERMISSION_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByPermissionAscendingUsingGBK() {
    addOrderBy("convert(permission using gbk)", true);
    return this;
  }

  public UserAppRequest orderByPermissionDescendingUsingGBK() {
    addOrderBy("convert(permission using gbk)", false);
    return this;
  }

  public UserAppRequest countPermission() {
    return countPermission("countPermission");
  }

  public UserAppRequest countPermission(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PERMISSION_PROPERTY);
  }

  public UserAppRequest maxPermission() {
    return maxPermission("maxPermission");
  }

  public UserAppRequest maxPermission(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PERMISSION_PROPERTY);
  }

  public UserAppRequest minPermission() {
    return minPermission("minPermission");
  }

  public UserAppRequest minPermission(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PERMISSION_PROPERTY);
  }

  public UserAppRequest groupByPermission() {
    return groupByPermission(PERMISSION_PROPERTY);
  }

  public UserAppRequest groupByPermission(String ret) {
    return groupBy(ret, PERMISSION_PROPERTY);
  }

  public UserAppRequest groupByPermission(SqlFunction func) {
    return groupByPermission(PERMISSION_PROPERTY, func);
  }

  public UserAppRequest groupByPermission(String ret, SqlFunction func) {
    super.groupBy(ret, func, PERMISSION_PROPERTY);
    return this;
  }

  public UserAppRequest filterByAppType(String appType) {

    if (appType == null) {
      return this;
    }

    return filterByAppType(QueryOperator.EQUAL, appType);
  }

  public UserAppRequest whereAppTypeIsNull() {
    return where(APP_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereAppTypeIsNotNull() {
    return where(APP_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByAppType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAppTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectAppType() {
    return select(APP_TYPE_PROPERTY);
  }

  public UserAppRequest unselectAppType() {
    return unselect(APP_TYPE_PROPERTY);
  }

  public SearchCriteria getAppTypeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(APP_TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByAppType(boolean asc) {
    addOrderBy(APP_TYPE_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByAppTypeAscending() {
    addOrderBy(APP_TYPE_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByAppTypeDescending() {
    addOrderBy(APP_TYPE_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByAppTypeAscendingUsingGBK() {
    addOrderBy("convert(appType using gbk)", true);
    return this;
  }

  public UserAppRequest orderByAppTypeDescendingUsingGBK() {
    addOrderBy("convert(appType using gbk)", false);
    return this;
  }

  public UserAppRequest countAppType() {
    return countAppType("countAppType");
  }

  public UserAppRequest countAppType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, APP_TYPE_PROPERTY);
  }

  public UserAppRequest maxAppType() {
    return maxAppType("maxAppType");
  }

  public UserAppRequest maxAppType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, APP_TYPE_PROPERTY);
  }

  public UserAppRequest minAppType() {
    return minAppType("minAppType");
  }

  public UserAppRequest minAppType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, APP_TYPE_PROPERTY);
  }

  public UserAppRequest groupByAppType() {
    return groupByAppType(APP_TYPE_PROPERTY);
  }

  public UserAppRequest groupByAppType(String ret) {
    return groupBy(ret, APP_TYPE_PROPERTY);
  }

  public UserAppRequest groupByAppType(SqlFunction func) {
    return groupByAppType(APP_TYPE_PROPERTY, func);
  }

  public UserAppRequest groupByAppType(String ret, SqlFunction func) {
    super.groupBy(ret, func, APP_TYPE_PROPERTY);
    return this;
  }

  public UserAppRequest filterByAppId(String appId) {

    if (appId == null) {
      return this;
    }

    return filterByAppId(QueryOperator.EQUAL, appId);
  }

  public UserAppRequest whereAppIdIsNull() {
    return where(APP_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereAppIdIsNotNull() {
    return where(APP_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByAppId(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAppIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectAppId() {
    return select(APP_ID_PROPERTY);
  }

  public UserAppRequest unselectAppId() {
    return unselect(APP_ID_PROPERTY);
  }

  public SearchCriteria getAppIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(APP_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByAppId(boolean asc) {
    addOrderBy(APP_ID_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByAppIdAscending() {
    addOrderBy(APP_ID_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByAppIdDescending() {
    addOrderBy(APP_ID_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByAppIdAscendingUsingGBK() {
    addOrderBy("convert(appId using gbk)", true);
    return this;
  }

  public UserAppRequest orderByAppIdDescendingUsingGBK() {
    addOrderBy("convert(appId using gbk)", false);
    return this;
  }

  public UserAppRequest countAppId() {
    return countAppId("countAppId");
  }

  public UserAppRequest countAppId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, APP_ID_PROPERTY);
  }

  public UserAppRequest maxAppId() {
    return maxAppId("maxAppId");
  }

  public UserAppRequest maxAppId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, APP_ID_PROPERTY);
  }

  public UserAppRequest minAppId() {
    return minAppId("minAppId");
  }

  public UserAppRequest minAppId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, APP_ID_PROPERTY);
  }

  public UserAppRequest groupByAppId() {
    return groupByAppId(APP_ID_PROPERTY);
  }

  public UserAppRequest groupByAppId(String ret) {
    return groupBy(ret, APP_ID_PROPERTY);
  }

  public UserAppRequest groupByAppId(SqlFunction func) {
    return groupByAppId(APP_ID_PROPERTY, func);
  }

  public UserAppRequest groupByAppId(String ret, SqlFunction func) {
    super.groupBy(ret, func, APP_ID_PROPERTY);
    return this;
  }

  public UserAppRequest filterByCtxType(String ctxType) {

    if (ctxType == null) {
      return this;
    }

    return filterByCtxType(QueryOperator.EQUAL, ctxType);
  }

  public UserAppRequest whereCtxTypeIsNull() {
    return where(CTX_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereCtxTypeIsNotNull() {
    return where(CTX_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByCtxType(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCtxTypeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectCtxType() {
    return select(CTX_TYPE_PROPERTY);
  }

  public UserAppRequest unselectCtxType() {
    return unselect(CTX_TYPE_PROPERTY);
  }

  public SearchCriteria getCtxTypeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CTX_TYPE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByCtxType(boolean asc) {
    addOrderBy(CTX_TYPE_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByCtxTypeAscending() {
    addOrderBy(CTX_TYPE_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByCtxTypeDescending() {
    addOrderBy(CTX_TYPE_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByCtxTypeAscendingUsingGBK() {
    addOrderBy("convert(ctxType using gbk)", true);
    return this;
  }

  public UserAppRequest orderByCtxTypeDescendingUsingGBK() {
    addOrderBy("convert(ctxType using gbk)", false);
    return this;
  }

  public UserAppRequest countCtxType() {
    return countCtxType("countCtxType");
  }

  public UserAppRequest countCtxType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CTX_TYPE_PROPERTY);
  }

  public UserAppRequest maxCtxType() {
    return maxCtxType("maxCtxType");
  }

  public UserAppRequest maxCtxType(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CTX_TYPE_PROPERTY);
  }

  public UserAppRequest minCtxType() {
    return minCtxType("minCtxType");
  }

  public UserAppRequest minCtxType(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CTX_TYPE_PROPERTY);
  }

  public UserAppRequest groupByCtxType() {
    return groupByCtxType(CTX_TYPE_PROPERTY);
  }

  public UserAppRequest groupByCtxType(String ret) {
    return groupBy(ret, CTX_TYPE_PROPERTY);
  }

  public UserAppRequest groupByCtxType(SqlFunction func) {
    return groupByCtxType(CTX_TYPE_PROPERTY, func);
  }

  public UserAppRequest groupByCtxType(String ret, SqlFunction func) {
    super.groupBy(ret, func, CTX_TYPE_PROPERTY);
    return this;
  }

  public UserAppRequest filterByCtxId(String ctxId) {

    if (ctxId == null) {
      return this;
    }

    return filterByCtxId(QueryOperator.EQUAL, ctxId);
  }

  public UserAppRequest whereCtxIdIsNull() {
    return where(CTX_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereCtxIdIsNotNull() {
    return where(CTX_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByCtxId(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCtxIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectCtxId() {
    return select(CTX_ID_PROPERTY);
  }

  public UserAppRequest unselectCtxId() {
    return unselect(CTX_ID_PROPERTY);
  }

  public SearchCriteria getCtxIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CTX_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByCtxId(boolean asc) {
    addOrderBy(CTX_ID_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByCtxIdAscending() {
    addOrderBy(CTX_ID_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByCtxIdDescending() {
    addOrderBy(CTX_ID_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByCtxIdAscendingUsingGBK() {
    addOrderBy("convert(ctxId using gbk)", true);
    return this;
  }

  public UserAppRequest orderByCtxIdDescendingUsingGBK() {
    addOrderBy("convert(ctxId using gbk)", false);
    return this;
  }

  public UserAppRequest countCtxId() {
    return countCtxId("countCtxId");
  }

  public UserAppRequest countCtxId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CTX_ID_PROPERTY);
  }

  public UserAppRequest maxCtxId() {
    return maxCtxId("maxCtxId");
  }

  public UserAppRequest maxCtxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CTX_ID_PROPERTY);
  }

  public UserAppRequest minCtxId() {
    return minCtxId("minCtxId");
  }

  public UserAppRequest minCtxId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CTX_ID_PROPERTY);
  }

  public UserAppRequest groupByCtxId() {
    return groupByCtxId(CTX_ID_PROPERTY);
  }

  public UserAppRequest groupByCtxId(String ret) {
    return groupBy(ret, CTX_ID_PROPERTY);
  }

  public UserAppRequest groupByCtxId(SqlFunction func) {
    return groupByCtxId(CTX_ID_PROPERTY, func);
  }

  public UserAppRequest groupByCtxId(String ret, SqlFunction func) {
    super.groupBy(ret, func, CTX_ID_PROPERTY);
    return this;
  }

  public UserAppRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public UserAppRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public UserAppRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public UserAppRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public UserAppRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public UserAppRequest countLocation() {
    return countLocation("countLocation");
  }

  public UserAppRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public UserAppRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public UserAppRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public UserAppRequest minLocation() {
    return minLocation("minLocation");
  }

  public UserAppRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public UserAppRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public UserAppRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public UserAppRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public UserAppRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public UserAppRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public UserAppRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAppRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public UserAppRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAppRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public UserAppRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public UserAppRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public UserAppRequest countVersion() {
    return countVersion("countVersion");
  }

  public UserAppRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public UserAppRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public UserAppRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public UserAppRequest minVersion() {
    return minVersion("minVersion");
  }

  public UserAppRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public UserAppRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public UserAppRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public UserAppRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public UserAppRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public UserAppRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public UserAppRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public UserAppRequest filterBySecUser(SecUserRequest secUser) {
    return filterBySecUser(secUser, SecUser::getId);
  }

  public UserAppRequest filterBySecUser(SecUser... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(SecUser... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public UserAppRequest selectSecUserId() {
    select(SEC_USER_PROPERTY);
    return this;
  }

  public SecUserRequest upToSecUser() {
    return upToSecUser(SecUserRequest.newInstance());
  }

  public SecUserRequest upToSecUser(SecUserRequest secUser) {
    secUser.aggregateChild(SEC_USER_PROPERTY, this);
    this.groupBySecUser(secUser);
    return secUser;
  }

  public SecUserRequest endAtSecUser(String retName) {
    return endAtSecUser(retName, SecUserRequest.newInstance());
  }

  public SecUserRequest endAtSecUser(String retName, SecUserRequest secUser) {
    secUser.addDynamicProperty(retName, this, SEC_USER_PROPERTY);
    return secUser;
  }

  public UserAppRequest filterBySecUser(String... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(String... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public UserAppRequest filterBySecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    secUser.unlimited();
    return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
  }

  public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine, SecUser.ID_PROPERTY);
  }

  public UserAppRequest selectSecUser() {
    return selectSecUser(SecUserRequest.newInstance().selectSelf());
  }

  public UserAppRequest selectSecUser(SecUserRequest secUser) {
    selectParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public UserAppRequest unselectSecUser() {
    unselectParent(SEC_USER_PROPERTY);
    return this;
  }

  public UserAppRequest groupBySecUser(SecUserRequest secUser) {
    groupBy(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public UserAppRequest aggregateSecUser(SecUserRequest secUser) {
    aggregateParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public UserAppRequest countSecUser() {
    return countSecUser("countSecUser");
  }

  public UserAppRequest countSecUser(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SEC_USER_PROPERTY);
  }

  public UserAppRequest groupBySecUser() {
    return groupBySecUser(SEC_USER_PROPERTY);
  }

  public UserAppRequest groupBySecUser(String ret) {
    return groupBy(ret, SEC_USER_PROPERTY);
  }

  public UserAppRequest whereSecUserIsNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAppRequest whereSecUserIsNotNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAppRequest hasQuickLink() {
    return hasQuickLink(QuickLinkRequest.newInstance());
  }

  public UserAppRequest hasQuickLink(QuickLink... quickLink) {
    if (isEmptyParam(quickLink)) {
      throw new IllegalArgumentException("hasQuickLink(QuickLink... quickLink)参数不能为空!");
    }
    return hasQuickLink(
        Q.quickLink()
            .select(QuickLink.APP_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) quickLink));
  }

  public UserAppRequest hasQuickLink(String... quickLink) {
    return hasQuickLink(Q.quickLink().select(QuickLink.APP_PROPERTY).filterById(quickLink));
  }

  public UserAppRequest hasQuickLink(QuickLinkRequest quickLink) {
    return hasQuickLink(
        quickLink,
        $quickLink ->
            java.util.Optional.of($quickLink)
                .map(QuickLink::getApp)
                .map(UserApp::getId)
                .orElse(null));
  }

  public UserAppRequest hasQuickLink(QuickLinkRequest quickLink, IDRefine<QuickLink> idRefine) {
    quickLink.select(QuickLink.APP_PROPERTY);
    quickLink.unlimited();
    return addSearchCriteria(createQuickLinkCriteria(quickLink, idRefine));
  }

  public UserAppRequest hasQuickLink(
      QuickLinkRequest quickLink, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(quickLink, QuickLink.APP_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createQuickLinkCriteria(
      QuickLinkRequest quickLink, IDRefine<QuickLink> idRefine) {
    return new RefinedIdInCriteria(quickLink, ID_PROPERTY, idRefine, QuickLink.APP_PROPERTY);
  }

  public UserAppRequest selectQuickLinkList(QuickLinkRequest quickLink) {
    selectChild(QuickLink.APP_PROPERTY, quickLink);
    return this;
  }

  public UserAppRequest selectQuickLinkList() {
    return selectQuickLinkList(QuickLinkRequest.newInstance().selectAll());
  }

  public UserAppRequest unselectQuickLinkList() {
    unselectChild(QuickLink.APP_PROPERTY, QuickLink.class);
    return this;
  }

  public UserAppRequest hasListAccess() {
    return hasListAccess(ListAccessRequest.newInstance());
  }

  public UserAppRequest hasListAccess(ListAccess... listAccess) {
    if (isEmptyParam(listAccess)) {
      throw new IllegalArgumentException("hasListAccess(ListAccess... listAccess)参数不能为空!");
    }
    return hasListAccess(
        Q.listAccess()
            .select(ListAccess.APP_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) listAccess));
  }

  public UserAppRequest hasListAccess(String... listAccess) {
    return hasListAccess(Q.listAccess().select(ListAccess.APP_PROPERTY).filterById(listAccess));
  }

  public UserAppRequest hasListAccess(ListAccessRequest listAccess) {
    return hasListAccess(
        listAccess,
        $listAccess ->
            java.util.Optional.of($listAccess)
                .map(ListAccess::getApp)
                .map(UserApp::getId)
                .orElse(null));
  }

  public UserAppRequest hasListAccess(ListAccessRequest listAccess, IDRefine<ListAccess> idRefine) {
    listAccess.select(ListAccess.APP_PROPERTY);
    listAccess.unlimited();
    return addSearchCriteria(createListAccessCriteria(listAccess, idRefine));
  }

  public UserAppRequest hasListAccess(
      ListAccessRequest listAccess, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(listAccess, ListAccess.APP_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createListAccessCriteria(
      ListAccessRequest listAccess, IDRefine<ListAccess> idRefine) {
    return new RefinedIdInCriteria(listAccess, ID_PROPERTY, idRefine, ListAccess.APP_PROPERTY);
  }

  public UserAppRequest selectListAccessList(ListAccessRequest listAccess) {
    selectChild(ListAccess.APP_PROPERTY, listAccess);
    return this;
  }

  public UserAppRequest selectListAccessList() {
    return selectListAccessList(ListAccessRequest.newInstance().selectAll());
  }

  public UserAppRequest unselectListAccessList() {
    unselectChild(ListAccess.APP_PROPERTY, ListAccess.class);
    return this;
  }

  public UserAppRequest aggregateQuickLinkList(QuickLinkRequest quickLink) {
    aggregateChild(QuickLink.APP_PROPERTY, quickLink);
    return this;
  }

  public UserAppRequest countQuickLink() {
    return countQuickLink("quickLinkCount");
  }

  public UserAppRequest countQuickLink(String retName) {
    return countQuickLink(retName, QuickLinkRequest.newInstance());
  }

  public UserAppRequest countQuickLink(QuickLinkRequest quickLink) {
    return countQuickLink("quickLinkCount", quickLink);
  }

  public UserAppRequest countQuickLink(String retName, QuickLinkRequest quickLink) {
    quickLink.count();
    return statsFromQuickLink(retName, quickLink);
  }

  public UserAppRequest statsFromQuickLink(String retName, QuickLinkRequest quickLink) {
    return addDynamicProperty(retName, quickLink, QuickLink.APP_PROPERTY);
  }

  public UserAppRequest aggregateListAccessList(ListAccessRequest listAccess) {
    aggregateChild(ListAccess.APP_PROPERTY, listAccess);
    return this;
  }

  public UserAppRequest countListAccess() {
    return countListAccess("listAccessCount");
  }

  public UserAppRequest countListAccess(String retName) {
    return countListAccess(retName, ListAccessRequest.newInstance());
  }

  public UserAppRequest countListAccess(ListAccessRequest listAccess) {
    return countListAccess("listAccessCount", listAccess);
  }

  public UserAppRequest countListAccess(String retName, ListAccessRequest listAccess) {
    listAccess.count();
    return statsFromListAccess(retName, listAccess);
  }

  public UserAppRequest statsFromListAccess(String retName, ListAccessRequest listAccess) {
    return addDynamicProperty(retName, listAccess, ListAccess.APP_PROPERTY);
  }

  public UserAppRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public UserAppRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public UserAppRequest unlimited() {
    super.unlimited();
    return this;
  }

  public UserAppRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
