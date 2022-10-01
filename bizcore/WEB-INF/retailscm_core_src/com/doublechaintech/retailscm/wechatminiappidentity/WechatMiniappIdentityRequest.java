package com.doublechaintech.retailscm.wechatminiappidentity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.secuser.SecUserRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity.*;

public class WechatMiniappIdentityRequest extends BaseRequest<WechatMiniappIdentity> {
  public static WechatMiniappIdentityRequest newInstance() {
    return new WechatMiniappIdentityRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public WechatMiniappIdentityRequest resultByClass(Class<? extends WechatMiniappIdentity> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public WechatMiniappIdentityRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public WechatMiniappIdentityRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "WechatMiniappIdentity";
  }

  public WechatMiniappIdentityRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public WechatMiniappIdentityRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public WechatMiniappIdentityRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public WechatMiniappIdentityRequest select(String... names) {
    super.select(names);
    return this;
  }

  public WechatMiniappIdentityRequest selectAll() {
    return this.selectId()
        .selectOpenId()
        .selectAppId()
        .selectUnionId()
        .selectSecUser()
        .selectCreateTime()
        .selectLastLoginTime()
        .selectVersion();
  }

  public WechatMiniappIdentityRequest selectAny() {
    return selectAll();
  }

  public WechatMiniappIdentityRequest selectSelf() {
    select(ID_PROPERTY);
    select(OPEN_ID_PROPERTY);
    select(APP_ID_PROPERTY);
    select(UNION_ID_PROPERTY);
    select(SEC_USER_PROPERTY);
    select(CREATE_TIME_PROPERTY);
    select(LAST_LOGIN_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public WechatMiniappIdentityRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public WechatMiniappIdentityRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {
    CREATE_TIME_PROPERTY, LAST_LOGIN_TIME_PROPERTY
  };
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    OPEN_ID_PROPERTY,
    APP_ID_PROPERTY,
    UNION_ID_PROPERTY,
    SEC_USER_PROPERTY,
    CREATE_TIME_PROPERTY,
    LAST_LOGIN_TIME_PROPERTY,
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

  public WechatMiniappIdentityRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public WechatMiniappIdentityRequest comment(String comment) {
    return this;
  }

  public WechatMiniappIdentityRequest enhance() {
    return this;
  }

  public WechatMiniappIdentityRequest overrideClass(Class<? extends WechatMiniappIdentity> clazz) {
    return this;
  }

  public WechatMiniappIdentityRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public WechatMiniappIdentityRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public WechatMiniappIdentityRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public WechatMiniappIdentityRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public WechatMiniappIdentityRequest count() {
    return countId("count");
  }

  public static WechatMiniappIdentityRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public WechatMiniappIdentityRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public WechatMiniappIdentityRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest selectId() {
    return select(ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatMiniappIdentityRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public WechatMiniappIdentityRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public WechatMiniappIdentityRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public WechatMiniappIdentityRequest countId() {
    return countId("countId");
  }

  public WechatMiniappIdentityRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest maxId() {
    return maxId("maxId");
  }

  public WechatMiniappIdentityRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest minId() {
    return minId("minId");
  }

  public WechatMiniappIdentityRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public WechatMiniappIdentityRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest filterByOpenId(String openId) {

    if (openId == null) {
      return this;
    }

    return filterByOpenId(QueryOperator.EQUAL, openId);
  }

  public WechatMiniappIdentityRequest whereOpenIdIsNull() {
    return where(OPEN_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatMiniappIdentityRequest whereOpenIdIsNotNull() {
    return where(OPEN_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatMiniappIdentityRequest filterByOpenId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getOpenIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest selectOpenId() {
    return select(OPEN_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest unselectOpenId() {
    return unselect(OPEN_ID_PROPERTY);
  }

  public SearchCriteria getOpenIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(OPEN_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatMiniappIdentityRequest orderByOpenId(boolean asc) {
    addOrderBy(OPEN_ID_PROPERTY, asc);
    return this;
  }

  public WechatMiniappIdentityRequest orderByOpenIdAscending() {
    addOrderBy(OPEN_ID_PROPERTY, true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByOpenIdDescending() {
    addOrderBy(OPEN_ID_PROPERTY, false);
    return this;
  }

  public WechatMiniappIdentityRequest orderByOpenIdAscendingUsingGBK() {
    addOrderBy("convert(openId using gbk)", true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByOpenIdDescendingUsingGBK() {
    addOrderBy("convert(openId using gbk)", false);
    return this;
  }

  public WechatMiniappIdentityRequest countOpenId() {
    return countOpenId("countOpenId");
  }

  public WechatMiniappIdentityRequest countOpenId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OPEN_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest maxOpenId() {
    return maxOpenId("maxOpenId");
  }

  public WechatMiniappIdentityRequest maxOpenId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, OPEN_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest minOpenId() {
    return minOpenId("minOpenId");
  }

  public WechatMiniappIdentityRequest minOpenId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, OPEN_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByOpenId() {
    return groupByOpenId(OPEN_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByOpenId(String ret) {
    return groupBy(ret, OPEN_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByOpenId(SqlFunction func) {
    return groupByOpenId(OPEN_ID_PROPERTY, func);
  }

  public WechatMiniappIdentityRequest groupByOpenId(String ret, SqlFunction func) {
    super.groupBy(ret, func, OPEN_ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest filterByAppId(String appId) {

    if (appId == null) {
      return this;
    }

    return filterByAppId(QueryOperator.EQUAL, appId);
  }

  public WechatMiniappIdentityRequest whereAppIdIsNull() {
    return where(APP_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatMiniappIdentityRequest whereAppIdIsNotNull() {
    return where(APP_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatMiniappIdentityRequest filterByAppId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAppIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest selectAppId() {
    return select(APP_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest unselectAppId() {
    return unselect(APP_ID_PROPERTY);
  }

  public SearchCriteria getAppIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(APP_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatMiniappIdentityRequest orderByAppId(boolean asc) {
    addOrderBy(APP_ID_PROPERTY, asc);
    return this;
  }

  public WechatMiniappIdentityRequest orderByAppIdAscending() {
    addOrderBy(APP_ID_PROPERTY, true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByAppIdDescending() {
    addOrderBy(APP_ID_PROPERTY, false);
    return this;
  }

  public WechatMiniappIdentityRequest orderByAppIdAscendingUsingGBK() {
    addOrderBy("convert(appId using gbk)", true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByAppIdDescendingUsingGBK() {
    addOrderBy("convert(appId using gbk)", false);
    return this;
  }

  public WechatMiniappIdentityRequest countAppId() {
    return countAppId("countAppId");
  }

  public WechatMiniappIdentityRequest countAppId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, APP_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest maxAppId() {
    return maxAppId("maxAppId");
  }

  public WechatMiniappIdentityRequest maxAppId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, APP_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest minAppId() {
    return minAppId("minAppId");
  }

  public WechatMiniappIdentityRequest minAppId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, APP_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByAppId() {
    return groupByAppId(APP_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByAppId(String ret) {
    return groupBy(ret, APP_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByAppId(SqlFunction func) {
    return groupByAppId(APP_ID_PROPERTY, func);
  }

  public WechatMiniappIdentityRequest groupByAppId(String ret, SqlFunction func) {
    super.groupBy(ret, func, APP_ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest filterByUnionId(String unionId) {

    if (unionId == null) {
      return this;
    }

    return filterByUnionId(QueryOperator.EQUAL, unionId);
  }

  public WechatMiniappIdentityRequest whereUnionIdIsNull() {
    return where(UNION_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatMiniappIdentityRequest whereUnionIdIsNotNull() {
    return where(UNION_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatMiniappIdentityRequest filterByUnionId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUnionIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest selectUnionId() {
    return select(UNION_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest unselectUnionId() {
    return unselect(UNION_ID_PROPERTY);
  }

  public SearchCriteria getUnionIdSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(UNION_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatMiniappIdentityRequest orderByUnionId(boolean asc) {
    addOrderBy(UNION_ID_PROPERTY, asc);
    return this;
  }

  public WechatMiniappIdentityRequest orderByUnionIdAscending() {
    addOrderBy(UNION_ID_PROPERTY, true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByUnionIdDescending() {
    addOrderBy(UNION_ID_PROPERTY, false);
    return this;
  }

  public WechatMiniappIdentityRequest orderByUnionIdAscendingUsingGBK() {
    addOrderBy("convert(unionId using gbk)", true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByUnionIdDescendingUsingGBK() {
    addOrderBy("convert(unionId using gbk)", false);
    return this;
  }

  public WechatMiniappIdentityRequest countUnionId() {
    return countUnionId("countUnionId");
  }

  public WechatMiniappIdentityRequest countUnionId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, UNION_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest maxUnionId() {
    return maxUnionId("maxUnionId");
  }

  public WechatMiniappIdentityRequest maxUnionId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, UNION_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest minUnionId() {
    return minUnionId("minUnionId");
  }

  public WechatMiniappIdentityRequest minUnionId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, UNION_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByUnionId() {
    return groupByUnionId(UNION_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByUnionId(String ret) {
    return groupBy(ret, UNION_ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByUnionId(SqlFunction func) {
    return groupByUnionId(UNION_ID_PROPERTY, func);
  }

  public WechatMiniappIdentityRequest groupByUnionId(String ret, SqlFunction func) {
    super.groupBy(ret, func, UNION_ID_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest filterByCreateTime(DateTime createTime) {

    if (createTime == null) {
      return this;
    }

    return filterByCreateTime(QueryOperator.EQUAL, createTime);
  }

  public WechatMiniappIdentityRequest whereCreateTimeIsNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatMiniappIdentityRequest whereCreateTimeIsNotNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatMiniappIdentityRequest whereCreateTimeBetween(
      Date createTimeStart, Date createTimeEnd) {
    if (ObjectUtil.isEmpty(createTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBetween, the parameter createTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(createTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBetween, the parameter createTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {createTimeStart, createTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest whereCreateTimeBefore(Date createTime) {

    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBefore, the parameter createTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest whereCreateTimeAfter(DateTime createTime) {
    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeAfter, the parameter createTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest filterByCreateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest selectCreateTime() {
    return select(CREATE_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest unselectCreateTime() {
    return unselect(CREATE_TIME_PROPERTY);
  }

  public SearchCriteria getCreateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatMiniappIdentityRequest orderByCreateTime(boolean asc) {
    addOrderBy(CREATE_TIME_PROPERTY, asc);
    return this;
  }

  public WechatMiniappIdentityRequest orderByCreateTimeAscending() {
    addOrderBy(CREATE_TIME_PROPERTY, true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByCreateTimeDescending() {
    addOrderBy(CREATE_TIME_PROPERTY, false);
    return this;
  }

  public WechatMiniappIdentityRequest countCreateTime() {
    return countCreateTime("countCreateTime");
  }

  public WechatMiniappIdentityRequest countCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CREATE_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest maxCreateTime() {
    return maxCreateTime("maxCreateTime");
  }

  public WechatMiniappIdentityRequest maxCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CREATE_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest minCreateTime() {
    return minCreateTime("minCreateTime");
  }

  public WechatMiniappIdentityRequest minCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CREATE_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByCreateTime() {
    return groupByCreateTime(CREATE_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByCreateTime(String ret) {
    return groupBy(ret, CREATE_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByCreateTime(SqlFunction func) {
    return groupByCreateTime(CREATE_TIME_PROPERTY, func);
  }

  public WechatMiniappIdentityRequest groupByCreateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, CREATE_TIME_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest filterByLastLoginTime(DateTime lastLoginTime) {

    if (lastLoginTime == null) {
      return this;
    }

    return filterByLastLoginTime(QueryOperator.EQUAL, lastLoginTime);
  }

  public WechatMiniappIdentityRequest whereLastLoginTimeIsNull() {
    return where(LAST_LOGIN_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatMiniappIdentityRequest whereLastLoginTimeIsNotNull() {
    return where(LAST_LOGIN_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatMiniappIdentityRequest whereLastLoginTimeBetween(
      Date lastLoginTimeStart, Date lastLoginTimeEnd) {
    if (ObjectUtil.isEmpty(lastLoginTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeBetween, the parameter lastLoginTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastLoginTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeBetween, the parameter lastLoginTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastLoginTimeStart, lastLoginTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest whereLastLoginTimeBefore(Date lastLoginTime) {

    if (ObjectUtil.isEmpty(lastLoginTime)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeBefore, the parameter lastLoginTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastLoginTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest whereLastLoginTimeAfter(DateTime lastLoginTime) {
    if (ObjectUtil.isEmpty(lastLoginTime)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeAfter, the parameter lastLoginTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastLoginTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest filterByLastLoginTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastLoginTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest selectLastLoginTime() {
    return select(LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest unselectLastLoginTime() {
    return unselect(LAST_LOGIN_TIME_PROPERTY);
  }

  public SearchCriteria getLastLoginTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatMiniappIdentityRequest orderByLastLoginTime(boolean asc) {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
    return this;
  }

  public WechatMiniappIdentityRequest orderByLastLoginTimeAscending() {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByLastLoginTimeDescending() {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, false);
    return this;
  }

  public WechatMiniappIdentityRequest countLastLoginTime() {
    return countLastLoginTime("countLastLoginTime");
  }

  public WechatMiniappIdentityRequest countLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest maxLastLoginTime() {
    return maxLastLoginTime("maxLastLoginTime");
  }

  public WechatMiniappIdentityRequest maxLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest minLastLoginTime() {
    return minLastLoginTime("minLastLoginTime");
  }

  public WechatMiniappIdentityRequest minLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByLastLoginTime() {
    return groupByLastLoginTime(LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByLastLoginTime(String ret) {
    return groupBy(ret, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByLastLoginTime(SqlFunction func) {
    return groupByLastLoginTime(LAST_LOGIN_TIME_PROPERTY, func);
  }

  public WechatMiniappIdentityRequest groupByLastLoginTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_LOGIN_TIME_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public WechatMiniappIdentityRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatMiniappIdentityRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatMiniappIdentityRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatMiniappIdentityRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public WechatMiniappIdentityRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatMiniappIdentityRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public WechatMiniappIdentityRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public WechatMiniappIdentityRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public WechatMiniappIdentityRequest countVersion() {
    return countVersion("countVersion");
  }

  public WechatMiniappIdentityRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public WechatMiniappIdentityRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public WechatMiniappIdentityRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public WechatMiniappIdentityRequest minVersion() {
    return minVersion("minVersion");
  }

  public WechatMiniappIdentityRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public WechatMiniappIdentityRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public WechatMiniappIdentityRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public WechatMiniappIdentityRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest filterBySecUser(SecUserRequest secUser) {
    return filterBySecUser(secUser, SecUser::getId);
  }

  public WechatMiniappIdentityRequest filterBySecUser(SecUser... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(SecUser... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public WechatMiniappIdentityRequest selectSecUserId() {
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

  public WechatMiniappIdentityRequest filterBySecUser(String... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(String... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public WechatMiniappIdentityRequest filterBySecUser(
      SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    secUser.unlimited();
    return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
  }

  public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine, SecUser.ID_PROPERTY);
  }

  public WechatMiniappIdentityRequest selectSecUser() {
    return selectSecUser(SecUserRequest.newInstance().selectSelf());
  }

  public WechatMiniappIdentityRequest selectSecUser(SecUserRequest secUser) {
    selectParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public WechatMiniappIdentityRequest unselectSecUser() {
    unselectParent(SEC_USER_PROPERTY);
    return this;
  }

  public WechatMiniappIdentityRequest groupBySecUser(SecUserRequest secUser) {
    groupBy(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public WechatMiniappIdentityRequest aggregateSecUser(SecUserRequest secUser) {
    aggregateParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public WechatMiniappIdentityRequest countSecUser() {
    return countSecUser("countSecUser");
  }

  public WechatMiniappIdentityRequest countSecUser(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SEC_USER_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupBySecUser() {
    return groupBySecUser(SEC_USER_PROPERTY);
  }

  public WechatMiniappIdentityRequest groupBySecUser(String ret) {
    return groupBy(ret, SEC_USER_PROPERTY);
  }

  public WechatMiniappIdentityRequest whereSecUserIsNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatMiniappIdentityRequest whereSecUserIsNotNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatMiniappIdentityRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public WechatMiniappIdentityRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public WechatMiniappIdentityRequest unlimited() {
    super.unlimited();
    return this;
  }

  public WechatMiniappIdentityRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
