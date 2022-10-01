package com.doublechaintech.retailscm.wechatworkappidentity;

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
import static com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity.*;

public class WechatWorkappIdentityRequest extends BaseRequest<WechatWorkappIdentity> {
  public static WechatWorkappIdentityRequest newInstance() {
    return new WechatWorkappIdentityRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public WechatWorkappIdentityRequest resultByClass(Class<? extends WechatWorkappIdentity> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public WechatWorkappIdentityRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public WechatWorkappIdentityRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "WechatWorkappIdentity";
  }

  public WechatWorkappIdentityRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public WechatWorkappIdentityRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public WechatWorkappIdentityRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public WechatWorkappIdentityRequest select(String... names) {
    super.select(names);
    return this;
  }

  public WechatWorkappIdentityRequest selectAll() {
    return this.selectId()
        .selectCorpId()
        .selectUserId()
        .selectSecUser()
        .selectCreateTime()
        .selectLastLoginTime()
        .selectVersion();
  }

  public WechatWorkappIdentityRequest selectAny() {
    return selectAll();
  }

  public WechatWorkappIdentityRequest selectSelf() {
    select(ID_PROPERTY);
    select(CORP_ID_PROPERTY);
    select(USER_ID_PROPERTY);
    select(SEC_USER_PROPERTY);
    select(CREATE_TIME_PROPERTY);
    select(LAST_LOGIN_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public WechatWorkappIdentityRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public WechatWorkappIdentityRequest where(
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
    CORP_ID_PROPERTY,
    USER_ID_PROPERTY,
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

  public WechatWorkappIdentityRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public WechatWorkappIdentityRequest comment(String comment) {
    return this;
  }

  public WechatWorkappIdentityRequest enhance() {
    return this;
  }

  public WechatWorkappIdentityRequest overrideClass(Class<? extends WechatWorkappIdentity> clazz) {
    return this;
  }

  public WechatWorkappIdentityRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public WechatWorkappIdentityRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public WechatWorkappIdentityRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public WechatWorkappIdentityRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public WechatWorkappIdentityRequest count() {
    return countId("count");
  }

  public static WechatWorkappIdentityRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public WechatWorkappIdentityRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public WechatWorkappIdentityRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest selectId() {
    return select(ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatWorkappIdentityRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public WechatWorkappIdentityRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public WechatWorkappIdentityRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public WechatWorkappIdentityRequest countId() {
    return countId("countId");
  }

  public WechatWorkappIdentityRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest maxId() {
    return maxId("maxId");
  }

  public WechatWorkappIdentityRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest minId() {
    return minId("minId");
  }

  public WechatWorkappIdentityRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public WechatWorkappIdentityRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public WechatWorkappIdentityRequest filterByCorpId(String corpId) {

    if (corpId == null) {
      return this;
    }

    return filterByCorpId(QueryOperator.EQUAL, corpId);
  }

  public WechatWorkappIdentityRequest whereCorpIdIsNull() {
    return where(CORP_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatWorkappIdentityRequest whereCorpIdIsNotNull() {
    return where(CORP_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatWorkappIdentityRequest filterByCorpId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCorpIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest selectCorpId() {
    return select(CORP_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest unselectCorpId() {
    return unselect(CORP_ID_PROPERTY);
  }

  public SearchCriteria getCorpIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CORP_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatWorkappIdentityRequest orderByCorpId(boolean asc) {
    addOrderBy(CORP_ID_PROPERTY, asc);
    return this;
  }

  public WechatWorkappIdentityRequest orderByCorpIdAscending() {
    addOrderBy(CORP_ID_PROPERTY, true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByCorpIdDescending() {
    addOrderBy(CORP_ID_PROPERTY, false);
    return this;
  }

  public WechatWorkappIdentityRequest orderByCorpIdAscendingUsingGBK() {
    addOrderBy("convert(corpId using gbk)", true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByCorpIdDescendingUsingGBK() {
    addOrderBy("convert(corpId using gbk)", false);
    return this;
  }

  public WechatWorkappIdentityRequest countCorpId() {
    return countCorpId("countCorpId");
  }

  public WechatWorkappIdentityRequest countCorpId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CORP_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest maxCorpId() {
    return maxCorpId("maxCorpId");
  }

  public WechatWorkappIdentityRequest maxCorpId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CORP_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest minCorpId() {
    return minCorpId("minCorpId");
  }

  public WechatWorkappIdentityRequest minCorpId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CORP_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByCorpId() {
    return groupByCorpId(CORP_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByCorpId(String ret) {
    return groupBy(ret, CORP_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByCorpId(SqlFunction func) {
    return groupByCorpId(CORP_ID_PROPERTY, func);
  }

  public WechatWorkappIdentityRequest groupByCorpId(String ret, SqlFunction func) {
    super.groupBy(ret, func, CORP_ID_PROPERTY);
    return this;
  }

  public WechatWorkappIdentityRequest filterByUserId(String userId) {

    if (userId == null) {
      return this;
    }

    return filterByUserId(QueryOperator.EQUAL, userId);
  }

  public WechatWorkappIdentityRequest whereUserIdIsNull() {
    return where(USER_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatWorkappIdentityRequest whereUserIdIsNotNull() {
    return where(USER_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatWorkappIdentityRequest filterByUserId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUserIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest selectUserId() {
    return select(USER_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest unselectUserId() {
    return unselect(USER_ID_PROPERTY);
  }

  public SearchCriteria getUserIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(USER_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatWorkappIdentityRequest orderByUserId(boolean asc) {
    addOrderBy(USER_ID_PROPERTY, asc);
    return this;
  }

  public WechatWorkappIdentityRequest orderByUserIdAscending() {
    addOrderBy(USER_ID_PROPERTY, true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByUserIdDescending() {
    addOrderBy(USER_ID_PROPERTY, false);
    return this;
  }

  public WechatWorkappIdentityRequest orderByUserIdAscendingUsingGBK() {
    addOrderBy("convert(userId using gbk)", true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByUserIdDescendingUsingGBK() {
    addOrderBy("convert(userId using gbk)", false);
    return this;
  }

  public WechatWorkappIdentityRequest countUserId() {
    return countUserId("countUserId");
  }

  public WechatWorkappIdentityRequest countUserId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, USER_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest maxUserId() {
    return maxUserId("maxUserId");
  }

  public WechatWorkappIdentityRequest maxUserId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, USER_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest minUserId() {
    return minUserId("minUserId");
  }

  public WechatWorkappIdentityRequest minUserId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, USER_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByUserId() {
    return groupByUserId(USER_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByUserId(String ret) {
    return groupBy(ret, USER_ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByUserId(SqlFunction func) {
    return groupByUserId(USER_ID_PROPERTY, func);
  }

  public WechatWorkappIdentityRequest groupByUserId(String ret, SqlFunction func) {
    super.groupBy(ret, func, USER_ID_PROPERTY);
    return this;
  }

  public WechatWorkappIdentityRequest filterByCreateTime(DateTime createTime) {

    if (createTime == null) {
      return this;
    }

    return filterByCreateTime(QueryOperator.EQUAL, createTime);
  }

  public WechatWorkappIdentityRequest whereCreateTimeIsNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatWorkappIdentityRequest whereCreateTimeIsNotNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatWorkappIdentityRequest whereCreateTimeBetween(
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

  public WechatWorkappIdentityRequest whereCreateTimeBefore(Date createTime) {

    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBefore, the parameter createTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest whereCreateTimeAfter(DateTime createTime) {
    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeAfter, the parameter createTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest filterByCreateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest selectCreateTime() {
    return select(CREATE_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest unselectCreateTime() {
    return unselect(CREATE_TIME_PROPERTY);
  }

  public SearchCriteria getCreateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatWorkappIdentityRequest orderByCreateTime(boolean asc) {
    addOrderBy(CREATE_TIME_PROPERTY, asc);
    return this;
  }

  public WechatWorkappIdentityRequest orderByCreateTimeAscending() {
    addOrderBy(CREATE_TIME_PROPERTY, true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByCreateTimeDescending() {
    addOrderBy(CREATE_TIME_PROPERTY, false);
    return this;
  }

  public WechatWorkappIdentityRequest countCreateTime() {
    return countCreateTime("countCreateTime");
  }

  public WechatWorkappIdentityRequest countCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CREATE_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest maxCreateTime() {
    return maxCreateTime("maxCreateTime");
  }

  public WechatWorkappIdentityRequest maxCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CREATE_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest minCreateTime() {
    return minCreateTime("minCreateTime");
  }

  public WechatWorkappIdentityRequest minCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CREATE_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByCreateTime() {
    return groupByCreateTime(CREATE_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByCreateTime(String ret) {
    return groupBy(ret, CREATE_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByCreateTime(SqlFunction func) {
    return groupByCreateTime(CREATE_TIME_PROPERTY, func);
  }

  public WechatWorkappIdentityRequest groupByCreateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, CREATE_TIME_PROPERTY);
    return this;
  }

  public WechatWorkappIdentityRequest filterByLastLoginTime(DateTime lastLoginTime) {

    if (lastLoginTime == null) {
      return this;
    }

    return filterByLastLoginTime(QueryOperator.EQUAL, lastLoginTime);
  }

  public WechatWorkappIdentityRequest whereLastLoginTimeIsNull() {
    return where(LAST_LOGIN_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatWorkappIdentityRequest whereLastLoginTimeIsNotNull() {
    return where(LAST_LOGIN_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatWorkappIdentityRequest whereLastLoginTimeBetween(
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

  public WechatWorkappIdentityRequest whereLastLoginTimeBefore(Date lastLoginTime) {

    if (ObjectUtil.isEmpty(lastLoginTime)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeBefore, the parameter lastLoginTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastLoginTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest whereLastLoginTimeAfter(DateTime lastLoginTime) {
    if (ObjectUtil.isEmpty(lastLoginTime)) {
      throw new IllegalArgumentException(
          "Method whereLastLoginTimeAfter, the parameter lastLoginTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastLoginTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastLoginTime});
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest filterByLastLoginTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastLoginTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest selectLastLoginTime() {
    return select(LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest unselectLastLoginTime() {
    return unselect(LAST_LOGIN_TIME_PROPERTY);
  }

  public SearchCriteria getLastLoginTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatWorkappIdentityRequest orderByLastLoginTime(boolean asc) {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
    return this;
  }

  public WechatWorkappIdentityRequest orderByLastLoginTimeAscending() {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByLastLoginTimeDescending() {
    addOrderBy(LAST_LOGIN_TIME_PROPERTY, false);
    return this;
  }

  public WechatWorkappIdentityRequest countLastLoginTime() {
    return countLastLoginTime("countLastLoginTime");
  }

  public WechatWorkappIdentityRequest countLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest maxLastLoginTime() {
    return maxLastLoginTime("maxLastLoginTime");
  }

  public WechatWorkappIdentityRequest maxLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest minLastLoginTime() {
    return minLastLoginTime("minLastLoginTime");
  }

  public WechatWorkappIdentityRequest minLastLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByLastLoginTime() {
    return groupByLastLoginTime(LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByLastLoginTime(String ret) {
    return groupBy(ret, LAST_LOGIN_TIME_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByLastLoginTime(SqlFunction func) {
    return groupByLastLoginTime(LAST_LOGIN_TIME_PROPERTY, func);
  }

  public WechatWorkappIdentityRequest groupByLastLoginTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_LOGIN_TIME_PROPERTY);
    return this;
  }

  public WechatWorkappIdentityRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public WechatWorkappIdentityRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatWorkappIdentityRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatWorkappIdentityRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WechatWorkappIdentityRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public WechatWorkappIdentityRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WechatWorkappIdentityRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public WechatWorkappIdentityRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public WechatWorkappIdentityRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public WechatWorkappIdentityRequest countVersion() {
    return countVersion("countVersion");
  }

  public WechatWorkappIdentityRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public WechatWorkappIdentityRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public WechatWorkappIdentityRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public WechatWorkappIdentityRequest minVersion() {
    return minVersion("minVersion");
  }

  public WechatWorkappIdentityRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public WechatWorkappIdentityRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public WechatWorkappIdentityRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public WechatWorkappIdentityRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public WechatWorkappIdentityRequest filterBySecUser(SecUserRequest secUser) {
    return filterBySecUser(secUser, SecUser::getId);
  }

  public WechatWorkappIdentityRequest filterBySecUser(SecUser... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(SecUser... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public WechatWorkappIdentityRequest selectSecUserId() {
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

  public WechatWorkappIdentityRequest filterBySecUser(String... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(String... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public WechatWorkappIdentityRequest filterBySecUser(
      SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    secUser.unlimited();
    return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
  }

  public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine, SecUser.ID_PROPERTY);
  }

  public WechatWorkappIdentityRequest selectSecUser() {
    return selectSecUser(SecUserRequest.newInstance().selectSelf());
  }

  public WechatWorkappIdentityRequest selectSecUser(SecUserRequest secUser) {
    selectParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public WechatWorkappIdentityRequest unselectSecUser() {
    unselectParent(SEC_USER_PROPERTY);
    return this;
  }

  public WechatWorkappIdentityRequest groupBySecUser(SecUserRequest secUser) {
    groupBy(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public WechatWorkappIdentityRequest aggregateSecUser(SecUserRequest secUser) {
    aggregateParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public WechatWorkappIdentityRequest countSecUser() {
    return countSecUser("countSecUser");
  }

  public WechatWorkappIdentityRequest countSecUser(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SEC_USER_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupBySecUser() {
    return groupBySecUser(SEC_USER_PROPERTY);
  }

  public WechatWorkappIdentityRequest groupBySecUser(String ret) {
    return groupBy(ret, SEC_USER_PROPERTY);
  }

  public WechatWorkappIdentityRequest whereSecUserIsNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NULL);
  }

  public WechatWorkappIdentityRequest whereSecUserIsNotNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WechatWorkappIdentityRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public WechatWorkappIdentityRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public WechatWorkappIdentityRequest unlimited() {
    super.unlimited();
    return this;
  }

  public WechatWorkappIdentityRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
