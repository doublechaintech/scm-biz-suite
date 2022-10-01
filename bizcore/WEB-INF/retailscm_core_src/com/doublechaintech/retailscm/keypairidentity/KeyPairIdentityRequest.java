package com.doublechaintech.retailscm.keypairidentity;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.publickeytype.PublicKeyType;
import com.doublechaintech.retailscm.secuser.SecUser;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeRequest;
import com.doublechaintech.retailscm.secuser.SecUserRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity.*;

public class KeyPairIdentityRequest extends BaseRequest<KeyPairIdentity> {
  public static KeyPairIdentityRequest newInstance() {
    return new KeyPairIdentityRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public KeyPairIdentityRequest resultByClass(Class<? extends KeyPairIdentity> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public KeyPairIdentityRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public KeyPairIdentityRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "KeyPairIdentity";
  }

  public KeyPairIdentityRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public KeyPairIdentityRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public KeyPairIdentityRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public KeyPairIdentityRequest select(String... names) {
    super.select(names);
    return this;
  }

  public KeyPairIdentityRequest selectAll() {
    return this.selectId()
        .selectPublicKey()
        .selectKeyType()
        .selectSecUser()
        .selectCreateTime()
        .selectVersion();
  }

  public KeyPairIdentityRequest selectAny() {
    return selectAll();
  }

  public KeyPairIdentityRequest selectSelf() {
    select(ID_PROPERTY);
    select(PUBLIC_KEY_PROPERTY);
    select(KEY_TYPE_PROPERTY);
    select(SEC_USER_PROPERTY);
    select(CREATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public KeyPairIdentityRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public KeyPairIdentityRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {CREATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    PUBLIC_KEY_PROPERTY,
    KEY_TYPE_PROPERTY,
    SEC_USER_PROPERTY,
    CREATE_TIME_PROPERTY,
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

  public KeyPairIdentityRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public KeyPairIdentityRequest comment(String comment) {
    return this;
  }

  public KeyPairIdentityRequest enhance() {
    return this;
  }

  public KeyPairIdentityRequest overrideClass(Class<? extends KeyPairIdentity> clazz) {
    return this;
  }

  public KeyPairIdentityRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public KeyPairIdentityRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public KeyPairIdentityRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public KeyPairIdentityRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public KeyPairIdentityRequest count() {
    return countId("count");
  }

  public static KeyPairIdentityRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public KeyPairIdentityRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public KeyPairIdentityRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public KeyPairIdentityRequest selectId() {
    return select(ID_PROPERTY);
  }

  public KeyPairIdentityRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public KeyPairIdentityRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public KeyPairIdentityRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public KeyPairIdentityRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public KeyPairIdentityRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public KeyPairIdentityRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public KeyPairIdentityRequest countId() {
    return countId("countId");
  }

  public KeyPairIdentityRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public KeyPairIdentityRequest maxId() {
    return maxId("maxId");
  }

  public KeyPairIdentityRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public KeyPairIdentityRequest minId() {
    return minId("minId");
  }

  public KeyPairIdentityRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public KeyPairIdentityRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public KeyPairIdentityRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public KeyPairIdentityRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public KeyPairIdentityRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public KeyPairIdentityRequest filterByPublicKey(String publicKey) {

    if (publicKey == null) {
      return this;
    }

    return filterByPublicKey(QueryOperator.EQUAL, publicKey);
  }

  public KeyPairIdentityRequest wherePublicKeyIsNull() {
    return where(PUBLIC_KEY_PROPERTY, QueryOperator.IS_NULL);
  }

  public KeyPairIdentityRequest wherePublicKeyIsNotNull() {
    return where(PUBLIC_KEY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public KeyPairIdentityRequest filterByPublicKey(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPublicKeySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public KeyPairIdentityRequest selectPublicKey() {
    return select(PUBLIC_KEY_PROPERTY);
  }

  public KeyPairIdentityRequest unselectPublicKey() {
    return unselect(PUBLIC_KEY_PROPERTY);
  }

  public SearchCriteria getPublicKeySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PUBLIC_KEY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public KeyPairIdentityRequest orderByPublicKey(boolean asc) {
    addOrderBy(PUBLIC_KEY_PROPERTY, asc);
    return this;
  }

  public KeyPairIdentityRequest orderByPublicKeyAscending() {
    addOrderBy(PUBLIC_KEY_PROPERTY, true);
    return this;
  }

  public KeyPairIdentityRequest orderByPublicKeyDescending() {
    addOrderBy(PUBLIC_KEY_PROPERTY, false);
    return this;
  }

  public KeyPairIdentityRequest orderByPublicKeyAscendingUsingGBK() {
    addOrderBy("convert(publicKey using gbk)", true);
    return this;
  }

  public KeyPairIdentityRequest orderByPublicKeyDescendingUsingGBK() {
    addOrderBy("convert(publicKey using gbk)", false);
    return this;
  }

  public KeyPairIdentityRequest countPublicKey() {
    return countPublicKey("countPublicKey");
  }

  public KeyPairIdentityRequest countPublicKey(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PUBLIC_KEY_PROPERTY);
  }

  public KeyPairIdentityRequest maxPublicKey() {
    return maxPublicKey("maxPublicKey");
  }

  public KeyPairIdentityRequest maxPublicKey(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PUBLIC_KEY_PROPERTY);
  }

  public KeyPairIdentityRequest minPublicKey() {
    return minPublicKey("minPublicKey");
  }

  public KeyPairIdentityRequest minPublicKey(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PUBLIC_KEY_PROPERTY);
  }

  public KeyPairIdentityRequest groupByPublicKey() {
    return groupByPublicKey(PUBLIC_KEY_PROPERTY);
  }

  public KeyPairIdentityRequest groupByPublicKey(String ret) {
    return groupBy(ret, PUBLIC_KEY_PROPERTY);
  }

  public KeyPairIdentityRequest groupByPublicKey(SqlFunction func) {
    return groupByPublicKey(PUBLIC_KEY_PROPERTY, func);
  }

  public KeyPairIdentityRequest groupByPublicKey(String ret, SqlFunction func) {
    super.groupBy(ret, func, PUBLIC_KEY_PROPERTY);
    return this;
  }

  public KeyPairIdentityRequest filterByCreateTime(DateTime createTime) {

    if (createTime == null) {
      return this;
    }

    return filterByCreateTime(QueryOperator.EQUAL, createTime);
  }

  public KeyPairIdentityRequest whereCreateTimeIsNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public KeyPairIdentityRequest whereCreateTimeIsNotNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public KeyPairIdentityRequest whereCreateTimeBetween(Date createTimeStart, Date createTimeEnd) {
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

  public KeyPairIdentityRequest whereCreateTimeBefore(Date createTime) {

    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBefore, the parameter createTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public KeyPairIdentityRequest whereCreateTimeAfter(DateTime createTime) {
    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeAfter, the parameter createTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public KeyPairIdentityRequest filterByCreateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public KeyPairIdentityRequest selectCreateTime() {
    return select(CREATE_TIME_PROPERTY);
  }

  public KeyPairIdentityRequest unselectCreateTime() {
    return unselect(CREATE_TIME_PROPERTY);
  }

  public SearchCriteria getCreateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public KeyPairIdentityRequest orderByCreateTime(boolean asc) {
    addOrderBy(CREATE_TIME_PROPERTY, asc);
    return this;
  }

  public KeyPairIdentityRequest orderByCreateTimeAscending() {
    addOrderBy(CREATE_TIME_PROPERTY, true);
    return this;
  }

  public KeyPairIdentityRequest orderByCreateTimeDescending() {
    addOrderBy(CREATE_TIME_PROPERTY, false);
    return this;
  }

  public KeyPairIdentityRequest countCreateTime() {
    return countCreateTime("countCreateTime");
  }

  public KeyPairIdentityRequest countCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CREATE_TIME_PROPERTY);
  }

  public KeyPairIdentityRequest maxCreateTime() {
    return maxCreateTime("maxCreateTime");
  }

  public KeyPairIdentityRequest maxCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CREATE_TIME_PROPERTY);
  }

  public KeyPairIdentityRequest minCreateTime() {
    return minCreateTime("minCreateTime");
  }

  public KeyPairIdentityRequest minCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CREATE_TIME_PROPERTY);
  }

  public KeyPairIdentityRequest groupByCreateTime() {
    return groupByCreateTime(CREATE_TIME_PROPERTY);
  }

  public KeyPairIdentityRequest groupByCreateTime(String ret) {
    return groupBy(ret, CREATE_TIME_PROPERTY);
  }

  public KeyPairIdentityRequest groupByCreateTime(SqlFunction func) {
    return groupByCreateTime(CREATE_TIME_PROPERTY, func);
  }

  public KeyPairIdentityRequest groupByCreateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, CREATE_TIME_PROPERTY);
    return this;
  }

  public KeyPairIdentityRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public KeyPairIdentityRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public KeyPairIdentityRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public KeyPairIdentityRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public KeyPairIdentityRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public KeyPairIdentityRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public KeyPairIdentityRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public KeyPairIdentityRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public KeyPairIdentityRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public KeyPairIdentityRequest countVersion() {
    return countVersion("countVersion");
  }

  public KeyPairIdentityRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public KeyPairIdentityRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public KeyPairIdentityRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public KeyPairIdentityRequest minVersion() {
    return minVersion("minVersion");
  }

  public KeyPairIdentityRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public KeyPairIdentityRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public KeyPairIdentityRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public KeyPairIdentityRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public KeyPairIdentityRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public KeyPairIdentityRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public KeyPairIdentityRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public KeyPairIdentityRequest filterByKeyType(PublicKeyTypeRequest keyType) {
    return filterByKeyType(keyType, PublicKeyType::getId);
  }

  public KeyPairIdentityRequest filterByKeyType(PublicKeyType... keyType) {
    if (isEmptyParam(keyType)) {
      throw new IllegalArgumentException("filterByKeyType(PublicKeyType... keyType)参数不能为空!");
    }
    return where(KEY_TYPE_PROPERTY, QueryOperator.IN, (Object[]) keyType);
  }

  public KeyPairIdentityRequest selectKeyTypeId() {
    select(KEY_TYPE_PROPERTY);
    return this;
  }

  public PublicKeyTypeRequest upToKeyType() {
    return upToKeyType(PublicKeyTypeRequest.newInstance());
  }

  public PublicKeyTypeRequest upToKeyType(PublicKeyTypeRequest keyType) {
    keyType.aggregateChild(KEY_TYPE_PROPERTY, this);
    this.groupByKeyType(keyType);
    return keyType;
  }

  public PublicKeyTypeRequest endAtKeyType(String retName) {
    return endAtKeyType(retName, PublicKeyTypeRequest.newInstance());
  }

  public PublicKeyTypeRequest endAtKeyType(String retName, PublicKeyTypeRequest keyType) {
    keyType.addDynamicProperty(retName, this, KEY_TYPE_PROPERTY);
    return keyType;
  }

  public KeyPairIdentityRequest filterByKeyType(String... keyType) {
    if (isEmptyParam(keyType)) {
      throw new IllegalArgumentException("filterByKeyType(String... keyType)参数不能为空!");
    }
    return where(KEY_TYPE_PROPERTY, QueryOperator.IN, (Object[]) keyType);
  }

  public KeyPairIdentityRequest filterByKeyType(
      PublicKeyTypeRequest keyType, IDRefine<PublicKeyType> idRefine) {
    keyType.unlimited();
    return addSearchCriteria(createKeyTypeCriteria(keyType, idRefine));
  }

  public SearchCriteria createKeyTypeCriteria(
      PublicKeyTypeRequest keyType, IDRefine<PublicKeyType> idRefine) {
    return new RefinedIdInCriteria(keyType, KEY_TYPE_PROPERTY, idRefine, PublicKeyType.ID_PROPERTY);
  }

  public KeyPairIdentityRequest selectKeyType() {
    return selectKeyType(PublicKeyTypeRequest.newInstance().selectSelf());
  }

  public KeyPairIdentityRequest selectKeyType(PublicKeyTypeRequest keyType) {
    selectParent(KEY_TYPE_PROPERTY, keyType);
    return this;
  }

  public KeyPairIdentityRequest unselectKeyType() {
    unselectParent(KEY_TYPE_PROPERTY);
    return this;
  }

  public KeyPairIdentityRequest groupByKeyType(PublicKeyTypeRequest keyType) {
    groupBy(KEY_TYPE_PROPERTY, keyType);
    return this;
  }

  public KeyPairIdentityRequest aggregateKeyType(PublicKeyTypeRequest keyType) {
    aggregateParent(KEY_TYPE_PROPERTY, keyType);
    return this;
  }

  public KeyPairIdentityRequest countKeyType() {
    return countKeyType("countKeyType");
  }

  public KeyPairIdentityRequest countKeyType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, KEY_TYPE_PROPERTY);
  }

  public KeyPairIdentityRequest groupByKeyType() {
    return groupByKeyType(KEY_TYPE_PROPERTY);
  }

  public KeyPairIdentityRequest groupByKeyType(String ret) {
    return groupBy(ret, KEY_TYPE_PROPERTY);
  }

  public KeyPairIdentityRequest whereKeyTypeIsNull() {
    return where(KEY_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public KeyPairIdentityRequest whereKeyTypeIsNotNull() {
    return where(KEY_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public KeyPairIdentityRequest filterBySecUser(SecUserRequest secUser) {
    return filterBySecUser(secUser, SecUser::getId);
  }

  public KeyPairIdentityRequest filterBySecUser(SecUser... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(SecUser... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public KeyPairIdentityRequest selectSecUserId() {
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

  public KeyPairIdentityRequest filterBySecUser(String... secUser) {
    if (isEmptyParam(secUser)) {
      throw new IllegalArgumentException("filterBySecUser(String... secUser)参数不能为空!");
    }
    return where(SEC_USER_PROPERTY, QueryOperator.IN, (Object[]) secUser);
  }

  public KeyPairIdentityRequest filterBySecUser(
      SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    secUser.unlimited();
    return addSearchCriteria(createSecUserCriteria(secUser, idRefine));
  }

  public SearchCriteria createSecUserCriteria(SecUserRequest secUser, IDRefine<SecUser> idRefine) {
    return new RefinedIdInCriteria(secUser, SEC_USER_PROPERTY, idRefine, SecUser.ID_PROPERTY);
  }

  public KeyPairIdentityRequest selectSecUser() {
    return selectSecUser(SecUserRequest.newInstance().selectSelf());
  }

  public KeyPairIdentityRequest selectSecUser(SecUserRequest secUser) {
    selectParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public KeyPairIdentityRequest unselectSecUser() {
    unselectParent(SEC_USER_PROPERTY);
    return this;
  }

  public KeyPairIdentityRequest groupBySecUser(SecUserRequest secUser) {
    groupBy(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public KeyPairIdentityRequest aggregateSecUser(SecUserRequest secUser) {
    aggregateParent(SEC_USER_PROPERTY, secUser);
    return this;
  }

  public KeyPairIdentityRequest countSecUser() {
    return countSecUser("countSecUser");
  }

  public KeyPairIdentityRequest countSecUser(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SEC_USER_PROPERTY);
  }

  public KeyPairIdentityRequest groupBySecUser() {
    return groupBySecUser(SEC_USER_PROPERTY);
  }

  public KeyPairIdentityRequest groupBySecUser(String ret) {
    return groupBy(ret, SEC_USER_PROPERTY);
  }

  public KeyPairIdentityRequest whereSecUserIsNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NULL);
  }

  public KeyPairIdentityRequest whereSecUserIsNotNull() {
    return where(SEC_USER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public KeyPairIdentityRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public KeyPairIdentityRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public KeyPairIdentityRequest unlimited() {
    super.unlimited();
    return this;
  }

  public KeyPairIdentityRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
