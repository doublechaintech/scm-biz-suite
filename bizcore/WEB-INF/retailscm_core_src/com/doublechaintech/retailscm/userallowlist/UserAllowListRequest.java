package com.doublechaintech.retailscm.userallowlist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.userdomain.UserDomainRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.userallowlist.UserAllowList.*;

public class UserAllowListRequest extends BaseRequest<UserAllowList> {
  public static UserAllowListRequest newInstance() {
    return new UserAllowListRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public UserAllowListRequest resultByClass(Class<? extends UserAllowList> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public UserAllowListRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public UserAllowListRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "UserAllowList";
  }

  public UserAllowListRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public UserAllowListRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public UserAllowListRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public UserAllowListRequest select(String... names) {
    super.select(names);
    return this;
  }

  public UserAllowListRequest selectAll() {
    return this.selectId()
        .selectUserIdentity()
        .selectUserSpecialFunctions()
        .selectDomain()
        .selectVersion();
  }

  public UserAllowListRequest selectAny() {
    return selectAll();
  }

  public UserAllowListRequest selectSelf() {
    select(ID_PROPERTY);
    select(USER_IDENTITY_PROPERTY);
    select(USER_SPECIAL_FUNCTIONS_PROPERTY);
    select(DOMAIN_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public UserAllowListRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public UserAllowListRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    USER_IDENTITY_PROPERTY,
    USER_SPECIAL_FUNCTIONS_PROPERTY,
    DOMAIN_PROPERTY,
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

  public UserAllowListRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public UserAllowListRequest comment(String comment) {
    return this;
  }

  public UserAllowListRequest enhance() {
    return this;
  }

  public UserAllowListRequest overrideClass(Class<? extends UserAllowList> clazz) {
    return this;
  }

  public UserAllowListRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public UserAllowListRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public UserAllowListRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public UserAllowListRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public UserAllowListRequest count() {
    return countId("count");
  }

  public static UserAllowListRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public UserAllowListRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public UserAllowListRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAllowListRequest selectId() {
    return select(ID_PROPERTY);
  }

  public UserAllowListRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAllowListRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public UserAllowListRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public UserAllowListRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public UserAllowListRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public UserAllowListRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public UserAllowListRequest countId() {
    return countId("countId");
  }

  public UserAllowListRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public UserAllowListRequest maxId() {
    return maxId("maxId");
  }

  public UserAllowListRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public UserAllowListRequest minId() {
    return minId("minId");
  }

  public UserAllowListRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public UserAllowListRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public UserAllowListRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public UserAllowListRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public UserAllowListRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public UserAllowListRequest filterByUserIdentity(String userIdentity) {

    if (userIdentity == null) {
      return this;
    }

    return filterByUserIdentity(QueryOperator.EQUAL, userIdentity);
  }

  public UserAllowListRequest whereUserIdentityIsNull() {
    return where(USER_IDENTITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAllowListRequest whereUserIdentityIsNotNull() {
    return where(USER_IDENTITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAllowListRequest filterByUserIdentity(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUserIdentitySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAllowListRequest selectUserIdentity() {
    return select(USER_IDENTITY_PROPERTY);
  }

  public UserAllowListRequest unselectUserIdentity() {
    return unselect(USER_IDENTITY_PROPERTY);
  }

  public SearchCriteria getUserIdentitySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(USER_IDENTITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAllowListRequest orderByUserIdentity(boolean asc) {
    addOrderBy(USER_IDENTITY_PROPERTY, asc);
    return this;
  }

  public UserAllowListRequest orderByUserIdentityAscending() {
    addOrderBy(USER_IDENTITY_PROPERTY, true);
    return this;
  }

  public UserAllowListRequest orderByUserIdentityDescending() {
    addOrderBy(USER_IDENTITY_PROPERTY, false);
    return this;
  }

  public UserAllowListRequest orderByUserIdentityAscendingUsingGBK() {
    addOrderBy("convert(userIdentity using gbk)", true);
    return this;
  }

  public UserAllowListRequest orderByUserIdentityDescendingUsingGBK() {
    addOrderBy("convert(userIdentity using gbk)", false);
    return this;
  }

  public UserAllowListRequest countUserIdentity() {
    return countUserIdentity("countUserIdentity");
  }

  public UserAllowListRequest countUserIdentity(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, USER_IDENTITY_PROPERTY);
  }

  public UserAllowListRequest maxUserIdentity() {
    return maxUserIdentity("maxUserIdentity");
  }

  public UserAllowListRequest maxUserIdentity(String aggName) {
    return aggregate(aggName, AggFunc.MAX, USER_IDENTITY_PROPERTY);
  }

  public UserAllowListRequest minUserIdentity() {
    return minUserIdentity("minUserIdentity");
  }

  public UserAllowListRequest minUserIdentity(String aggName) {
    return aggregate(aggName, AggFunc.MIN, USER_IDENTITY_PROPERTY);
  }

  public UserAllowListRequest groupByUserIdentity() {
    return groupByUserIdentity(USER_IDENTITY_PROPERTY);
  }

  public UserAllowListRequest groupByUserIdentity(String ret) {
    return groupBy(ret, USER_IDENTITY_PROPERTY);
  }

  public UserAllowListRequest groupByUserIdentity(SqlFunction func) {
    return groupByUserIdentity(USER_IDENTITY_PROPERTY, func);
  }

  public UserAllowListRequest groupByUserIdentity(String ret, SqlFunction func) {
    super.groupBy(ret, func, USER_IDENTITY_PROPERTY);
    return this;
  }

  public UserAllowListRequest filterByUserSpecialFunctions(String userSpecialFunctions) {

    if (userSpecialFunctions == null) {
      return this;
    }

    return filterByUserSpecialFunctions(QueryOperator.EQUAL, userSpecialFunctions);
  }

  public UserAllowListRequest whereUserSpecialFunctionsIsNull() {
    return where(USER_SPECIAL_FUNCTIONS_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAllowListRequest whereUserSpecialFunctionsIsNotNull() {
    return where(USER_SPECIAL_FUNCTIONS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAllowListRequest filterByUserSpecialFunctions(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getUserSpecialFunctionsSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAllowListRequest selectUserSpecialFunctions() {
    return select(USER_SPECIAL_FUNCTIONS_PROPERTY);
  }

  public UserAllowListRequest unselectUserSpecialFunctions() {
    return unselect(USER_SPECIAL_FUNCTIONS_PROPERTY);
  }

  public SearchCriteria getUserSpecialFunctionsSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(USER_SPECIAL_FUNCTIONS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAllowListRequest orderByUserSpecialFunctions(boolean asc) {
    addOrderBy(USER_SPECIAL_FUNCTIONS_PROPERTY, asc);
    return this;
  }

  public UserAllowListRequest orderByUserSpecialFunctionsAscending() {
    addOrderBy(USER_SPECIAL_FUNCTIONS_PROPERTY, true);
    return this;
  }

  public UserAllowListRequest orderByUserSpecialFunctionsDescending() {
    addOrderBy(USER_SPECIAL_FUNCTIONS_PROPERTY, false);
    return this;
  }

  public UserAllowListRequest orderByUserSpecialFunctionsAscendingUsingGBK() {
    addOrderBy("convert(userSpecialFunctions using gbk)", true);
    return this;
  }

  public UserAllowListRequest orderByUserSpecialFunctionsDescendingUsingGBK() {
    addOrderBy("convert(userSpecialFunctions using gbk)", false);
    return this;
  }

  public UserAllowListRequest countUserSpecialFunctions() {
    return countUserSpecialFunctions("countUserSpecialFunctions");
  }

  public UserAllowListRequest countUserSpecialFunctions(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, USER_SPECIAL_FUNCTIONS_PROPERTY);
  }

  public UserAllowListRequest maxUserSpecialFunctions() {
    return maxUserSpecialFunctions("maxUserSpecialFunctions");
  }

  public UserAllowListRequest maxUserSpecialFunctions(String aggName) {
    return aggregate(aggName, AggFunc.MAX, USER_SPECIAL_FUNCTIONS_PROPERTY);
  }

  public UserAllowListRequest minUserSpecialFunctions() {
    return minUserSpecialFunctions("minUserSpecialFunctions");
  }

  public UserAllowListRequest minUserSpecialFunctions(String aggName) {
    return aggregate(aggName, AggFunc.MIN, USER_SPECIAL_FUNCTIONS_PROPERTY);
  }

  public UserAllowListRequest groupByUserSpecialFunctions() {
    return groupByUserSpecialFunctions(USER_SPECIAL_FUNCTIONS_PROPERTY);
  }

  public UserAllowListRequest groupByUserSpecialFunctions(String ret) {
    return groupBy(ret, USER_SPECIAL_FUNCTIONS_PROPERTY);
  }

  public UserAllowListRequest groupByUserSpecialFunctions(SqlFunction func) {
    return groupByUserSpecialFunctions(USER_SPECIAL_FUNCTIONS_PROPERTY, func);
  }

  public UserAllowListRequest groupByUserSpecialFunctions(String ret, SqlFunction func) {
    super.groupBy(ret, func, USER_SPECIAL_FUNCTIONS_PROPERTY);
    return this;
  }

  public UserAllowListRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public UserAllowListRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAllowListRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAllowListRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserAllowListRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public UserAllowListRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserAllowListRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public UserAllowListRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public UserAllowListRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public UserAllowListRequest countVersion() {
    return countVersion("countVersion");
  }

  public UserAllowListRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public UserAllowListRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public UserAllowListRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public UserAllowListRequest minVersion() {
    return minVersion("minVersion");
  }

  public UserAllowListRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public UserAllowListRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public UserAllowListRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public UserAllowListRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public UserAllowListRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public UserAllowListRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public UserAllowListRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public UserAllowListRequest filterByDomain(UserDomainRequest domain) {
    return filterByDomain(domain, UserDomain::getId);
  }

  public UserAllowListRequest filterByDomain(UserDomain... domain) {
    if (isEmptyParam(domain)) {
      throw new IllegalArgumentException("filterByDomain(UserDomain... domain)参数不能为空!");
    }
    return where(DOMAIN_PROPERTY, QueryOperator.IN, (Object[]) domain);
  }

  public UserAllowListRequest selectDomainId() {
    select(DOMAIN_PROPERTY);
    return this;
  }

  public UserDomainRequest upToDomain() {
    return upToDomain(UserDomainRequest.newInstance());
  }

  public UserDomainRequest upToDomain(UserDomainRequest domain) {
    domain.aggregateChild(DOMAIN_PROPERTY, this);
    this.groupByDomain(domain);
    return domain;
  }

  public UserDomainRequest endAtDomain(String retName) {
    return endAtDomain(retName, UserDomainRequest.newInstance());
  }

  public UserDomainRequest endAtDomain(String retName, UserDomainRequest domain) {
    domain.addDynamicProperty(retName, this, DOMAIN_PROPERTY);
    return domain;
  }

  public UserAllowListRequest filterByDomain(String... domain) {
    if (isEmptyParam(domain)) {
      throw new IllegalArgumentException("filterByDomain(String... domain)参数不能为空!");
    }
    return where(DOMAIN_PROPERTY, QueryOperator.IN, (Object[]) domain);
  }

  public UserAllowListRequest filterByDomain(
      UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
    domain.unlimited();
    return addSearchCriteria(createDomainCriteria(domain, idRefine));
  }

  public SearchCriteria createDomainCriteria(
      UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
    return new RefinedIdInCriteria(domain, DOMAIN_PROPERTY, idRefine, UserDomain.ID_PROPERTY);
  }

  public UserAllowListRequest selectDomain() {
    return selectDomain(UserDomainRequest.newInstance().selectSelf());
  }

  public UserAllowListRequest selectDomain(UserDomainRequest domain) {
    selectParent(DOMAIN_PROPERTY, domain);
    return this;
  }

  public UserAllowListRequest unselectDomain() {
    unselectParent(DOMAIN_PROPERTY);
    return this;
  }

  public UserAllowListRequest groupByDomain(UserDomainRequest domain) {
    groupBy(DOMAIN_PROPERTY, domain);
    return this;
  }

  public UserAllowListRequest aggregateDomain(UserDomainRequest domain) {
    aggregateParent(DOMAIN_PROPERTY, domain);
    return this;
  }

  public UserAllowListRequest countDomain() {
    return countDomain("countDomain");
  }

  public UserAllowListRequest countDomain(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DOMAIN_PROPERTY);
  }

  public UserAllowListRequest groupByDomain() {
    return groupByDomain(DOMAIN_PROPERTY);
  }

  public UserAllowListRequest groupByDomain(String ret) {
    return groupBy(ret, DOMAIN_PROPERTY);
  }

  public UserAllowListRequest whereDomainIsNull() {
    return where(DOMAIN_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserAllowListRequest whereDomainIsNotNull() {
    return where(DOMAIN_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserAllowListRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public UserAllowListRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public UserAllowListRequest unlimited() {
    super.unlimited();
    return this;
  }

  public UserAllowListRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
