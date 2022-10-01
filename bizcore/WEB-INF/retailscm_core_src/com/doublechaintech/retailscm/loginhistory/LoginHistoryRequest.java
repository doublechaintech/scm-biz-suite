package com.doublechaintech.retailscm.loginhistory;

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
import static com.doublechaintech.retailscm.loginhistory.LoginHistory.*;

public class LoginHistoryRequest extends BaseRequest<LoginHistory> {
  public static LoginHistoryRequest newInstance() {
    return new LoginHistoryRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public LoginHistoryRequest resultByClass(Class<? extends LoginHistory> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public LoginHistoryRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public LoginHistoryRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "LoginHistory";
  }

  public LoginHistoryRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public LoginHistoryRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public LoginHistoryRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public LoginHistoryRequest select(String... names) {
    super.select(names);
    return this;
  }

  public LoginHistoryRequest selectAll() {
    return this.selectId()
        .selectLoginTime()
        .selectFromIp()
        .selectDescription()
        .selectSecUser()
        .selectVersion();
  }

  public LoginHistoryRequest selectAny() {
    return selectAll();
  }

  public LoginHistoryRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOGIN_TIME_PROPERTY);
    select(FROM_IP_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(SEC_USER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public LoginHistoryRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public LoginHistoryRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LOGIN_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    LOGIN_TIME_PROPERTY,
    FROM_IP_PROPERTY,
    DESCRIPTION_PROPERTY,
    SEC_USER_PROPERTY,
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

  public LoginHistoryRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public LoginHistoryRequest comment(String comment) {
    return this;
  }

  public LoginHistoryRequest enhance() {
    return this;
  }

  public LoginHistoryRequest overrideClass(Class<? extends LoginHistory> clazz) {
    return this;
  }

  public LoginHistoryRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public LoginHistoryRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public LoginHistoryRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public LoginHistoryRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public LoginHistoryRequest count() {
    return countId("count");
  }

  public static LoginHistoryRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public LoginHistoryRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public LoginHistoryRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest selectId() {
    return select(ID_PROPERTY);
  }

  public LoginHistoryRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LoginHistoryRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public LoginHistoryRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public LoginHistoryRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public LoginHistoryRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public LoginHistoryRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public LoginHistoryRequest countId() {
    return countId("countId");
  }

  public LoginHistoryRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public LoginHistoryRequest maxId() {
    return maxId("maxId");
  }

  public LoginHistoryRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public LoginHistoryRequest minId() {
    return minId("minId");
  }

  public LoginHistoryRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public LoginHistoryRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public LoginHistoryRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public LoginHistoryRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public LoginHistoryRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public LoginHistoryRequest filterByLoginTime(DateTime loginTime) {

    if (loginTime == null) {
      return this;
    }

    return filterByLoginTime(QueryOperator.EQUAL, loginTime);
  }

  public LoginHistoryRequest whereLoginTimeIsNull() {
    return where(LOGIN_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public LoginHistoryRequest whereLoginTimeIsNotNull() {
    return where(LOGIN_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LoginHistoryRequest whereLoginTimeBetween(Date loginTimeStart, Date loginTimeEnd) {
    if (ObjectUtil.isEmpty(loginTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLoginTimeBetween, the parameter loginTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(loginTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLoginTimeBetween, the parameter loginTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLoginTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {loginTimeStart, loginTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest whereLoginTimeBefore(Date loginTime) {

    if (ObjectUtil.isEmpty(loginTime)) {
      throw new IllegalArgumentException(
          "Method whereLoginTimeBefore, the parameter loginTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLoginTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {loginTime});
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest whereLoginTimeAfter(DateTime loginTime) {
    if (ObjectUtil.isEmpty(loginTime)) {
      throw new IllegalArgumentException(
          "Method whereLoginTimeAfter, the parameter loginTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLoginTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {loginTime});
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest filterByLoginTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLoginTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest selectLoginTime() {
    return select(LOGIN_TIME_PROPERTY);
  }

  public LoginHistoryRequest unselectLoginTime() {
    return unselect(LOGIN_TIME_PROPERTY);
  }

  public SearchCriteria getLoginTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOGIN_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LoginHistoryRequest orderByLoginTime(boolean asc) {
    addOrderBy(LOGIN_TIME_PROPERTY, asc);
    return this;
  }

  public LoginHistoryRequest orderByLoginTimeAscending() {
    addOrderBy(LOGIN_TIME_PROPERTY, true);
    return this;
  }

  public LoginHistoryRequest orderByLoginTimeDescending() {
    addOrderBy(LOGIN_TIME_PROPERTY, false);
    return this;
  }

  public LoginHistoryRequest countLoginTime() {
    return countLoginTime("countLoginTime");
  }

  public LoginHistoryRequest countLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOGIN_TIME_PROPERTY);
  }

  public LoginHistoryRequest maxLoginTime() {
    return maxLoginTime("maxLoginTime");
  }

  public LoginHistoryRequest maxLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOGIN_TIME_PROPERTY);
  }

  public LoginHistoryRequest minLoginTime() {
    return minLoginTime("minLoginTime");
  }

  public LoginHistoryRequest minLoginTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOGIN_TIME_PROPERTY);
  }

  public LoginHistoryRequest groupByLoginTime() {
    return groupByLoginTime(LOGIN_TIME_PROPERTY);
  }

  public LoginHistoryRequest groupByLoginTime(String ret) {
    return groupBy(ret, LOGIN_TIME_PROPERTY);
  }

  public LoginHistoryRequest groupByLoginTime(SqlFunction func) {
    return groupByLoginTime(LOGIN_TIME_PROPERTY, func);
  }

  public LoginHistoryRequest groupByLoginTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOGIN_TIME_PROPERTY);
    return this;
  }

  public LoginHistoryRequest filterByFromIp(String fromIp) {

    if (fromIp == null) {
      return this;
    }

    return filterByFromIp(QueryOperator.EQUAL, fromIp);
  }

  public LoginHistoryRequest whereFromIpIsNull() {
    return where(FROM_IP_PROPERTY, QueryOperator.IS_NULL);
  }

  public LoginHistoryRequest whereFromIpIsNotNull() {
    return where(FROM_IP_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LoginHistoryRequest filterByFromIp(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFromIpSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest selectFromIp() {
    return select(FROM_IP_PROPERTY);
  }

  public LoginHistoryRequest unselectFromIp() {
    return unselect(FROM_IP_PROPERTY);
  }

  public SearchCriteria getFromIpSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FROM_IP_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LoginHistoryRequest orderByFromIp(boolean asc) {
    addOrderBy(FROM_IP_PROPERTY, asc);
    return this;
  }

  public LoginHistoryRequest orderByFromIpAscending() {
    addOrderBy(FROM_IP_PROPERTY, true);
    return this;
  }

  public LoginHistoryRequest orderByFromIpDescending() {
    addOrderBy(FROM_IP_PROPERTY, false);
    return this;
  }

  public LoginHistoryRequest orderByFromIpAscendingUsingGBK() {
    addOrderBy("convert(fromIp using gbk)", true);
    return this;
  }

  public LoginHistoryRequest orderByFromIpDescendingUsingGBK() {
    addOrderBy("convert(fromIp using gbk)", false);
    return this;
  }

  public LoginHistoryRequest countFromIp() {
    return countFromIp("countFromIp");
  }

  public LoginHistoryRequest countFromIp(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FROM_IP_PROPERTY);
  }

  public LoginHistoryRequest maxFromIp() {
    return maxFromIp("maxFromIp");
  }

  public LoginHistoryRequest maxFromIp(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FROM_IP_PROPERTY);
  }

  public LoginHistoryRequest minFromIp() {
    return minFromIp("minFromIp");
  }

  public LoginHistoryRequest minFromIp(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FROM_IP_PROPERTY);
  }

  public LoginHistoryRequest groupByFromIp() {
    return groupByFromIp(FROM_IP_PROPERTY);
  }

  public LoginHistoryRequest groupByFromIp(String ret) {
    return groupBy(ret, FROM_IP_PROPERTY);
  }

  public LoginHistoryRequest groupByFromIp(SqlFunction func) {
    return groupByFromIp(FROM_IP_PROPERTY, func);
  }

  public LoginHistoryRequest groupByFromIp(String ret, SqlFunction func) {
    super.groupBy(ret, func, FROM_IP_PROPERTY);
    return this;
  }

  public LoginHistoryRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public LoginHistoryRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LoginHistoryRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LoginHistoryRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public LoginHistoryRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LoginHistoryRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public LoginHistoryRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public LoginHistoryRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public LoginHistoryRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public LoginHistoryRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public LoginHistoryRequest countDescription() {
    return countDescription("countDescription");
  }

  public LoginHistoryRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public LoginHistoryRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public LoginHistoryRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public LoginHistoryRequest minDescription() {
    return minDescription("minDescription");
  }

  public LoginHistoryRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public LoginHistoryRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public LoginHistoryRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public LoginHistoryRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public LoginHistoryRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public LoginHistoryRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public LoginHistoryRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public LoginHistoryRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LoginHistoryRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public LoginHistoryRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public LoginHistoryRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public LoginHistoryRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public LoginHistoryRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public LoginHistoryRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public LoginHistoryRequest countVersion() {
    return countVersion("countVersion");
  }

  public LoginHistoryRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public LoginHistoryRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public LoginHistoryRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public LoginHistoryRequest minVersion() {
    return minVersion("minVersion");
  }

  public LoginHistoryRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public LoginHistoryRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public LoginHistoryRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public LoginHistoryRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public LoginHistoryRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public LoginHistoryRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public LoginHistoryRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public LoginHistoryRequest filterBySecUser(SecUserRequest secUser) {
    return filterBySecUser(secUser, SecUser::getId);
  }

  public LoginHistoryRequest filterBySecUser(SecUser... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(SecUser... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public LoginHistoryRequest selectSecUserId() {
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

  public LoginHistoryRequest filterBySecUser(String... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(String... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public LoginHistoryRequest filterBySecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    secUser.unlimited();
    return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
  }

  public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine, SecUser.ID_PROPERTY);
  }

  public LoginHistoryRequest selectSecUser() {
    return selectSecUser(SecUserRequest.newInstance().selectSelf());
  }

  public LoginHistoryRequest selectSecUser(SecUserRequest secUser) {
    selectParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public LoginHistoryRequest unselectSecUser() {
    unselectParent(SEC_USER_PROPERTY);
    return this;
  }

  public LoginHistoryRequest groupBySecUser(SecUserRequest secUser) {
    groupBy(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public LoginHistoryRequest aggregateSecUser(SecUserRequest secUser) {
    aggregateParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public LoginHistoryRequest countSecUser() {
    return countSecUser("countSecUser");
  }

  public LoginHistoryRequest countSecUser(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SEC_USER_PROPERTY);
  }

  public LoginHistoryRequest groupBySecUser() {
    return groupBySecUser(SEC_USER_PROPERTY);
  }

  public LoginHistoryRequest groupBySecUser(String ret) {
    return groupBy(ret, SEC_USER_PROPERTY);
  }

  public LoginHistoryRequest whereSecUserIsNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NULL);
  }

  public LoginHistoryRequest whereSecUserIsNotNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public LoginHistoryRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public LoginHistoryRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public LoginHistoryRequest unlimited() {
    super.unlimited();
    return this;
  }

  public LoginHistoryRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
