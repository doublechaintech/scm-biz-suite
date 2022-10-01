package com.doublechaintech.retailscm.userdomain;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.userallowlist.UserAllowList;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest;
import com.doublechaintech.retailscm.secuser.SecUserRequest;
import com.doublechaintech.retailscm.userallowlist.UserAllowListRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.userdomain.UserDomain.*;

public class UserDomainRequest extends BaseRequest<UserDomain> {
  public static UserDomainRequest newInstance() {
    return new UserDomainRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public UserDomainRequest resultByClass(Class<? extends UserDomain> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public UserDomainRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public UserDomainRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "UserDomain";
  }

  public UserDomainRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public UserDomainRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public UserDomainRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public UserDomainRequest select(String... names) {
    super.select(names);
    return this;
  }

  public UserDomainRequest selectAll() {
    return this.selectId().selectName().selectVersion();
  }

  public UserDomainRequest selectAny() {
    return selectAll()
        .selectUserAllowListList(Q.userAllowList().selectSelf())
        .selectSecUserList(Q.secUser().selectSelf())
        .selectPublicKeyTypeList(Q.publicKeyType().selectSelf());
  }

  public UserDomainRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public UserDomainRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public UserDomainRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {ID_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY};

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public UserDomainRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public UserDomainRequest comment(String comment) {
    return this;
  }

  public UserDomainRequest enhance() {
    return this;
  }

  public UserDomainRequest overrideClass(Class<? extends UserDomain> clazz) {
    return this;
  }

  public UserDomainRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public UserDomainRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public UserDomainRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public UserDomainRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public UserDomainRequest count() {
    return countId("count");
  }

  public static UserDomainRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public UserDomainRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public UserDomainRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserDomainRequest selectId() {
    return select(ID_PROPERTY);
  }

  public UserDomainRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserDomainRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public UserDomainRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public UserDomainRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public UserDomainRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public UserDomainRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public UserDomainRequest countId() {
    return countId("countId");
  }

  public UserDomainRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public UserDomainRequest maxId() {
    return maxId("maxId");
  }

  public UserDomainRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public UserDomainRequest minId() {
    return minId("minId");
  }

  public UserDomainRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public UserDomainRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public UserDomainRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public UserDomainRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public UserDomainRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public UserDomainRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public UserDomainRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserDomainRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserDomainRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserDomainRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public UserDomainRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserDomainRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public UserDomainRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public UserDomainRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public UserDomainRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public UserDomainRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public UserDomainRequest countName() {
    return countName("countName");
  }

  public UserDomainRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public UserDomainRequest maxName() {
    return maxName("maxName");
  }

  public UserDomainRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public UserDomainRequest minName() {
    return minName("minName");
  }

  public UserDomainRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public UserDomainRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public UserDomainRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public UserDomainRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public UserDomainRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public UserDomainRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public UserDomainRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public UserDomainRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UserDomainRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UserDomainRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public UserDomainRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UserDomainRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public UserDomainRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public UserDomainRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public UserDomainRequest countVersion() {
    return countVersion("countVersion");
  }

  public UserDomainRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public UserDomainRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public UserDomainRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public UserDomainRequest minVersion() {
    return minVersion("minVersion");
  }

  public UserDomainRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public UserDomainRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public UserDomainRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public UserDomainRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public UserDomainRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public UserDomainRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public UserDomainRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public UserDomainRequest hasUserAllowList() {
    return hasUserAllowList(UserAllowListRequest.newInstance());
  }

  public UserDomainRequest hasUserAllowList(UserAllowList... userAllowList) {
    if (isEmptyParam(userAllowList)) {
      throw new IllegalArgumentException("hasUserAllowList(UserAllowList... userAllowList)参数不能为空!");
    }
    return hasUserAllowList(
        Q.userAllowList()
            .select(UserAllowList.DOMAIN_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) userAllowList));
  }

  public UserDomainRequest hasUserAllowList(String... userAllowList) {
    return hasUserAllowList(
        Q.userAllowList().select(UserAllowList.DOMAIN_PROPERTY).filterById(userAllowList));
  }

  public UserDomainRequest hasUserAllowList(UserAllowListRequest userAllowList) {
    return hasUserAllowList(
        userAllowList,
        $userAllowList ->
            java.util.Optional.of($userAllowList)
                .map(UserAllowList::getDomain)
                .map(UserDomain::getId)
                .orElse(null));
  }

  public UserDomainRequest hasUserAllowList(
      UserAllowListRequest userAllowList, IDRefine<UserAllowList> idRefine) {
    userAllowList.select(UserAllowList.DOMAIN_PROPERTY);
    userAllowList.unlimited();
    return addSearchCriteria(createUserAllowListCriteria(userAllowList, idRefine));
  }

  public UserDomainRequest hasUserAllowList(
      UserAllowListRequest userAllowList, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            userAllowList, UserAllowList.DOMAIN_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createUserAllowListCriteria(
      UserAllowListRequest userAllowList, IDRefine<UserAllowList> idRefine) {
    return new RefinedIdInCriteria(
        userAllowList, ID_PROPERTY, idRefine, UserAllowList.DOMAIN_PROPERTY);
  }

  public UserDomainRequest selectUserAllowListList(UserAllowListRequest userAllowList) {
    selectChild(UserAllowList.DOMAIN_PROPERTY, userAllowList);
    return this;
  }

  public UserDomainRequest selectUserAllowListList() {
    return selectUserAllowListList(UserAllowListRequest.newInstance().selectAll());
  }

  public UserDomainRequest unselectUserAllowListList() {
    unselectChild(UserAllowList.DOMAIN_PROPERTY, UserAllowList.class);
    return this;
  }

  public UserDomainRequest hasSecUser() {
    return hasSecUser(SecUserRequest.newInstance());
  }

  public UserDomainRequest hasSecUser(SecUser... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("hasSecUser(SecUser... secUser)参数不能为空!");
    }
    return hasSecUser(
        Q.secUser()
            .select(SecUser.DOMAIN_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) secUser));
  }

  public UserDomainRequest hasSecUser(String... secUser) {
    return hasSecUser(Q.secUser().select(SecUser.DOMAIN_PROPERTY).filterById(secUser));
  }

  public UserDomainRequest hasSecUser(SecUserRequest secUser) {
    return hasSecUser(
        secUser,
        $secUser ->
            java.util.Optional.of($secUser)
                .map(SecUser::getDomain)
                .map(UserDomain::getId)
                .orElse(null));
  }

  public UserDomainRequest hasSecUser(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    secUser.select(SecUser.DOMAIN_PROPERTY);
    secUser.unlimited();
    return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
  }

  public UserDomainRequest hasSecUser(
      SecUserRequest secUser, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(secUser, SecUser.DOMAIN_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    return new RefinedIdInCriteria(secUser, ID_PROPERTY, idRefine, SecUser.DOMAIN_PROPERTY);
  }

  public UserDomainRequest selectSecUserList(SecUserRequest secUser) {
    selectChild(SecUser.DOMAIN_PROPERTY, secUser);
    return this;
  }

  public UserDomainRequest selectSecUserList() {
    return selectSecUserList(SecUserRequest.newInstance().selectAll());
  }

  public UserDomainRequest unselectSecUserList() {
    unselectChild(SecUser.DOMAIN_PROPERTY, SecUser.class);
    return this;
  }

  public UserDomainRequest hasPublicKeyType() {
    return hasPublicKeyType(PublicKeyTypeRequest.newInstance());
  }

  public UserDomainRequest hasPublicKeyType(PublicKeyType... publicKeyType) {
    if (isEmptyParam(publicKeyType)) {
      throw new IllegalArgumentException("hasPublicKeyType(PublicKeyType... publicKeyType)参数不能为空!");
    }
    return hasPublicKeyType(
        Q.publicKeyType()
            .select(PublicKeyType.DOMAIN_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) publicKeyType));
  }

  public UserDomainRequest hasPublicKeyType(String... publicKeyType) {
    return hasPublicKeyType(
        Q.publicKeyType().select(PublicKeyType.DOMAIN_PROPERTY).filterById(publicKeyType));
  }

  public UserDomainRequest hasPublicKeyType(PublicKeyTypeRequest publicKeyType) {
    return hasPublicKeyType(
        publicKeyType,
        $publicKeyType ->
            java.util.Optional.of($publicKeyType)
                .map(PublicKeyType::getDomain)
                .map(UserDomain::getId)
                .orElse(null));
  }

  public UserDomainRequest hasPublicKeyType(
      PublicKeyTypeRequest publicKeyType, IDRefine<PublicKeyType> idRefine) {
    publicKeyType.select(PublicKeyType.DOMAIN_PROPERTY);
    publicKeyType.unlimited();
    return addSearchCriteria(createPublicKeyTypeCriteria(publicKeyType, idRefine));
  }

  public UserDomainRequest hasPublicKeyType(
      PublicKeyTypeRequest publicKeyType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            publicKeyType, PublicKeyType.DOMAIN_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createPublicKeyTypeCriteria(
      PublicKeyTypeRequest publicKeyType, IDRefine<PublicKeyType> idRefine) {
    return new RefinedIdInCriteria(
        publicKeyType, ID_PROPERTY, idRefine, PublicKeyType.DOMAIN_PROPERTY);
  }

  public UserDomainRequest selectPublicKeyTypeList(PublicKeyTypeRequest publicKeyType) {
    selectChild(PublicKeyType.DOMAIN_PROPERTY, publicKeyType);
    return this;
  }

  public UserDomainRequest selectPublicKeyTypeList() {
    return selectPublicKeyTypeList(PublicKeyTypeRequest.newInstance().selectAll());
  }

  public UserDomainRequest unselectPublicKeyTypeList() {
    unselectChild(PublicKeyType.DOMAIN_PROPERTY, PublicKeyType.class);
    return this;
  }

  public UserDomainRequest aggregateUserAllowListList(UserAllowListRequest userAllowList) {
    aggregateChild(UserAllowList.DOMAIN_PROPERTY, userAllowList);
    return this;
  }

  public UserDomainRequest countUserAllowList() {
    return countUserAllowList("userAllowListCount");
  }

  public UserDomainRequest countUserAllowList(String retName) {
    return countUserAllowList(retName, UserAllowListRequest.newInstance());
  }

  public UserDomainRequest countUserAllowList(UserAllowListRequest userAllowList) {
    return countUserAllowList("userAllowListCount", userAllowList);
  }

  public UserDomainRequest countUserAllowList(String retName, UserAllowListRequest userAllowList) {
    userAllowList.count();
    return statsFromUserAllowList(retName, userAllowList);
  }

  public UserDomainRequest statsFromUserAllowList(
      String retName, UserAllowListRequest userAllowList) {
    return addDynamicProperty(retName, userAllowList, UserAllowList.DOMAIN_PROPERTY);
  }

  public UserDomainRequest aggregateSecUserList(SecUserRequest secUser) {
    aggregateChild(SecUser.DOMAIN_PROPERTY, secUser);
    return this;
  }

  public UserDomainRequest countSecUser() {
    return countSecUser("secUserCount");
  }

  public UserDomainRequest countSecUser(String retName) {
    return countSecUser(retName, SecUserRequest.newInstance());
  }

  public UserDomainRequest countSecUser(SecUserRequest secUser) {
    return countSecUser("secUserCount", secUser);
  }

  public UserDomainRequest countSecUser(String retName, SecUserRequest secUser) {
    secUser.count();
    return statsFromSecUser(retName, secUser);
  }

  public UserDomainRequest statsFromSecUser(String retName, SecUserRequest secUser) {
    return addDynamicProperty(retName, secUser, SecUser.DOMAIN_PROPERTY);
  }

  public UserDomainRequest aggregatePublicKeyTypeList(PublicKeyTypeRequest publicKeyType) {
    aggregateChild(PublicKeyType.DOMAIN_PROPERTY, publicKeyType);
    return this;
  }

  public UserDomainRequest countPublicKeyType() {
    return countPublicKeyType("publicKeyTypeCount");
  }

  public UserDomainRequest countPublicKeyType(String retName) {
    return countPublicKeyType(retName, PublicKeyTypeRequest.newInstance());
  }

  public UserDomainRequest countPublicKeyType(PublicKeyTypeRequest publicKeyType) {
    return countPublicKeyType("publicKeyTypeCount", publicKeyType);
  }

  public UserDomainRequest countPublicKeyType(String retName, PublicKeyTypeRequest publicKeyType) {
    publicKeyType.count();
    return statsFromPublicKeyType(retName, publicKeyType);
  }

  public UserDomainRequest statsFromPublicKeyType(
      String retName, PublicKeyTypeRequest publicKeyType) {
    return addDynamicProperty(retName, publicKeyType, PublicKeyType.DOMAIN_PROPERTY);
  }

  public UserDomainRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public UserDomainRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public UserDomainRequest unlimited() {
    super.unlimited();
    return this;
  }

  public UserDomainRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
