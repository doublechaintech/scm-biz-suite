package com.doublechaintech.retailscm.publickeytype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityRequest;
import com.doublechaintech.retailscm.userdomain.UserDomainRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.publickeytype.PublicKeyType.*;

public class PublicKeyTypeRequest extends BaseRequest<PublicKeyType> {
  public static PublicKeyTypeRequest newInstance() {
    return new PublicKeyTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PublicKeyTypeRequest resultByClass(Class<? extends PublicKeyType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PublicKeyTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PublicKeyTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "PublicKeyType";
  }

  public PublicKeyTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PublicKeyTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PublicKeyTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PublicKeyTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PublicKeyTypeRequest selectAll() {
    return this.selectId().selectKeyAlg().selectSignAlg().selectDomain().selectVersion();
  }

  public PublicKeyTypeRequest selectAny() {
    return selectAll().selectKeyPairIdentityList(Q.keyPairIdentity().selectSelf());
  }

  public PublicKeyTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(KEY_ALG_PROPERTY);
    select(SIGN_ALG_PROPERTY);
    select(DOMAIN_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PublicKeyTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PublicKeyTypeRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, KEY_ALG_PROPERTY, SIGN_ALG_PROPERTY, DOMAIN_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public PublicKeyTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PublicKeyTypeRequest comment(String comment) {
    return this;
  }

  public PublicKeyTypeRequest enhance() {
    return this;
  }

  public PublicKeyTypeRequest overrideClass(Class<? extends PublicKeyType> clazz) {
    return this;
  }

  public PublicKeyTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PublicKeyTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PublicKeyTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PublicKeyTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PublicKeyTypeRequest count() {
    return countId("count");
  }

  public static PublicKeyTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public PublicKeyTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PublicKeyTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicKeyTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PublicKeyTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicKeyTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PublicKeyTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PublicKeyTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PublicKeyTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PublicKeyTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PublicKeyTypeRequest countId() {
    return countId("countId");
  }

  public PublicKeyTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PublicKeyTypeRequest maxId() {
    return maxId("maxId");
  }

  public PublicKeyTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PublicKeyTypeRequest minId() {
    return minId("minId");
  }

  public PublicKeyTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PublicKeyTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PublicKeyTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PublicKeyTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PublicKeyTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PublicKeyTypeRequest filterByKeyAlg(String keyAlg) {

    if (keyAlg == null) {
      return this;
    }

    return filterByKeyAlg(QueryOperator.EQUAL, keyAlg);
  }

  public PublicKeyTypeRequest whereKeyAlgIsNull() {
    return where(KEY_ALG_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicKeyTypeRequest whereKeyAlgIsNotNull() {
    return where(KEY_ALG_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicKeyTypeRequest filterByKeyAlg(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getKeyAlgSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicKeyTypeRequest selectKeyAlg() {
    return select(KEY_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest unselectKeyAlg() {
    return unselect(KEY_ALG_PROPERTY);
  }

  public SearchCriteria getKeyAlgSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(KEY_ALG_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicKeyTypeRequest orderByKeyAlg(boolean asc) {
    addOrderBy(KEY_ALG_PROPERTY, asc);
    return this;
  }

  public PublicKeyTypeRequest orderByKeyAlgAscending() {
    addOrderBy(KEY_ALG_PROPERTY, true);
    return this;
  }

  public PublicKeyTypeRequest orderByKeyAlgDescending() {
    addOrderBy(KEY_ALG_PROPERTY, false);
    return this;
  }

  public PublicKeyTypeRequest orderByKeyAlgAscendingUsingGBK() {
    addOrderBy("convert(keyAlg using gbk)", true);
    return this;
  }

  public PublicKeyTypeRequest orderByKeyAlgDescendingUsingGBK() {
    addOrderBy("convert(keyAlg using gbk)", false);
    return this;
  }

  public PublicKeyTypeRequest countKeyAlg() {
    return countKeyAlg("countKeyAlg");
  }

  public PublicKeyTypeRequest countKeyAlg(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, KEY_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest maxKeyAlg() {
    return maxKeyAlg("maxKeyAlg");
  }

  public PublicKeyTypeRequest maxKeyAlg(String aggName) {
    return aggregate(aggName, AggFunc.MAX, KEY_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest minKeyAlg() {
    return minKeyAlg("minKeyAlg");
  }

  public PublicKeyTypeRequest minKeyAlg(String aggName) {
    return aggregate(aggName, AggFunc.MIN, KEY_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest groupByKeyAlg() {
    return groupByKeyAlg(KEY_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest groupByKeyAlg(String ret) {
    return groupBy(ret, KEY_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest groupByKeyAlg(SqlFunction func) {
    return groupByKeyAlg(KEY_ALG_PROPERTY, func);
  }

  public PublicKeyTypeRequest groupByKeyAlg(String ret, SqlFunction func) {
    super.groupBy(ret, func, KEY_ALG_PROPERTY);
    return this;
  }

  public PublicKeyTypeRequest filterBySignAlg(String signAlg) {

    if (signAlg == null) {
      return this;
    }

    return filterBySignAlg(QueryOperator.EQUAL, signAlg);
  }

  public PublicKeyTypeRequest whereSignAlgIsNull() {
    return where(SIGN_ALG_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicKeyTypeRequest whereSignAlgIsNotNull() {
    return where(SIGN_ALG_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicKeyTypeRequest filterBySignAlg(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSignAlgSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicKeyTypeRequest selectSignAlg() {
    return select(SIGN_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest unselectSignAlg() {
    return unselect(SIGN_ALG_PROPERTY);
  }

  public SearchCriteria getSignAlgSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SIGN_ALG_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicKeyTypeRequest orderBySignAlg(boolean asc) {
    addOrderBy(SIGN_ALG_PROPERTY, asc);
    return this;
  }

  public PublicKeyTypeRequest orderBySignAlgAscending() {
    addOrderBy(SIGN_ALG_PROPERTY, true);
    return this;
  }

  public PublicKeyTypeRequest orderBySignAlgDescending() {
    addOrderBy(SIGN_ALG_PROPERTY, false);
    return this;
  }

  public PublicKeyTypeRequest orderBySignAlgAscendingUsingGBK() {
    addOrderBy("convert(signAlg using gbk)", true);
    return this;
  }

  public PublicKeyTypeRequest orderBySignAlgDescendingUsingGBK() {
    addOrderBy("convert(signAlg using gbk)", false);
    return this;
  }

  public PublicKeyTypeRequest countSignAlg() {
    return countSignAlg("countSignAlg");
  }

  public PublicKeyTypeRequest countSignAlg(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SIGN_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest maxSignAlg() {
    return maxSignAlg("maxSignAlg");
  }

  public PublicKeyTypeRequest maxSignAlg(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SIGN_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest minSignAlg() {
    return minSignAlg("minSignAlg");
  }

  public PublicKeyTypeRequest minSignAlg(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SIGN_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest groupBySignAlg() {
    return groupBySignAlg(SIGN_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest groupBySignAlg(String ret) {
    return groupBy(ret, SIGN_ALG_PROPERTY);
  }

  public PublicKeyTypeRequest groupBySignAlg(SqlFunction func) {
    return groupBySignAlg(SIGN_ALG_PROPERTY, func);
  }

  public PublicKeyTypeRequest groupBySignAlg(String ret, SqlFunction func) {
    super.groupBy(ret, func, SIGN_ALG_PROPERTY);
    return this;
  }

  public PublicKeyTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PublicKeyTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicKeyTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicKeyTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicKeyTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PublicKeyTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicKeyTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PublicKeyTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PublicKeyTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PublicKeyTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public PublicKeyTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PublicKeyTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PublicKeyTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PublicKeyTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public PublicKeyTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PublicKeyTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PublicKeyTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PublicKeyTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PublicKeyTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PublicKeyTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PublicKeyTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PublicKeyTypeRequest filterByDomain(UserDomainRequest domain) {
    return filterByDomain(domain, UserDomain::getId);
  }

  public PublicKeyTypeRequest filterByDomain(UserDomain... domain) {
    if (isEmptyParam(domain)) {
      throw new IllegalArgumentException("filterByDomain(UserDomain... domain)参数不能为空!");
    }
    return where(DOMAIN_PROPERTY, QueryOperator.IN, (Object[]) domain);
  }

  public PublicKeyTypeRequest selectDomainId() {
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

  public PublicKeyTypeRequest filterByDomain(String... domain) {
    if (isEmptyParam(domain)) {
      throw new IllegalArgumentException("filterByDomain(String... domain)参数不能为空!");
    }
    return where(DOMAIN_PROPERTY, QueryOperator.IN, (Object[]) domain);
  }

  public PublicKeyTypeRequest filterByDomain(
      UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
    domain.unlimited();
    return addSearchCriteria(createDomainCriteria(domain, idRefine));
  }

  public SearchCriteria createDomainCriteria(
      UserDomainRequest domain, IDRefine<UserDomain> idRefine) {
    return new RefinedIdInCriteria(domain, DOMAIN_PROPERTY, idRefine, UserDomain.ID_PROPERTY);
  }

  public PublicKeyTypeRequest selectDomain() {
    return selectDomain(UserDomainRequest.newInstance().selectSelf());
  }

  public PublicKeyTypeRequest selectDomain(UserDomainRequest domain) {
    selectParent(DOMAIN_PROPERTY, domain);
    return this;
  }

  public PublicKeyTypeRequest unselectDomain() {
    unselectParent(DOMAIN_PROPERTY);
    return this;
  }

  public PublicKeyTypeRequest groupByDomain(UserDomainRequest domain) {
    groupBy(DOMAIN_PROPERTY, domain);
    return this;
  }

  public PublicKeyTypeRequest aggregateDomain(UserDomainRequest domain) {
    aggregateParent(DOMAIN_PROPERTY, domain);
    return this;
  }

  public PublicKeyTypeRequest countDomain() {
    return countDomain("countDomain");
  }

  public PublicKeyTypeRequest countDomain(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DOMAIN_PROPERTY);
  }

  public PublicKeyTypeRequest groupByDomain() {
    return groupByDomain(DOMAIN_PROPERTY);
  }

  public PublicKeyTypeRequest groupByDomain(String ret) {
    return groupBy(ret, DOMAIN_PROPERTY);
  }

  public PublicKeyTypeRequest whereDomainIsNull() {
    return where(DOMAIN_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicKeyTypeRequest whereDomainIsNotNull() {
    return where(DOMAIN_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicKeyTypeRequest hasKeyPairIdentity() {
    return hasKeyPairIdentity(KeyPairIdentityRequest.newInstance());
  }

  public PublicKeyTypeRequest hasKeyPairIdentity(KeyPairIdentity... keyPairIdentity) {
    if (isEmptyParam(keyPairIdentity)) {
      throw new IllegalArgumentException(
          "hasKeyPairIdentity(KeyPairIdentity... keyPairIdentity)参数不能为空!");
    }
    return hasKeyPairIdentity(
        Q.keyPairIdentity()
            .select(KeyPairIdentity.KEY_TYPE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) keyPairIdentity));
  }

  public PublicKeyTypeRequest hasKeyPairIdentity(String... keyPairIdentity) {
    return hasKeyPairIdentity(
        Q.keyPairIdentity().select(KeyPairIdentity.KEY_TYPE_PROPERTY).filterById(keyPairIdentity));
  }

  public PublicKeyTypeRequest hasKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity) {
    return hasKeyPairIdentity(
        keyPairIdentity,
        $keyPairIdentity ->
            java.util.Optional.of($keyPairIdentity)
                .map(KeyPairIdentity::getKeyType)
                .map(PublicKeyType::getId)
                .orElse(null));
  }

  public PublicKeyTypeRequest hasKeyPairIdentity(
      KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine) {
    keyPairIdentity.select(KeyPairIdentity.KEY_TYPE_PROPERTY);
    keyPairIdentity.unlimited();
    return addSearchCriteria(createKeyPairIdentityCriteria(keyPairIdentity, idRefine));
  }

  public PublicKeyTypeRequest hasKeyPairIdentity(
      KeyPairIdentityRequest keyPairIdentity, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            keyPairIdentity, KeyPairIdentity.KEY_TYPE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createKeyPairIdentityCriteria(
      KeyPairIdentityRequest keyPairIdentity, IDRefine<KeyPairIdentity> idRefine) {
    return new RefinedIdInCriteria(
        keyPairIdentity, ID_PROPERTY, idRefine, KeyPairIdentity.KEY_TYPE_PROPERTY);
  }

  public PublicKeyTypeRequest selectKeyPairIdentityList(KeyPairIdentityRequest keyPairIdentity) {
    selectChild(KeyPairIdentity.KEY_TYPE_PROPERTY, keyPairIdentity);
    return this;
  }

  public PublicKeyTypeRequest selectKeyPairIdentityList() {
    return selectKeyPairIdentityList(KeyPairIdentityRequest.newInstance().selectAll());
  }

  public PublicKeyTypeRequest unselectKeyPairIdentityList() {
    unselectChild(KeyPairIdentity.KEY_TYPE_PROPERTY, KeyPairIdentity.class);
    return this;
  }

  public PublicKeyTypeRequest aggregateKeyPairIdentityList(KeyPairIdentityRequest keyPairIdentity) {
    aggregateChild(KeyPairIdentity.KEY_TYPE_PROPERTY, keyPairIdentity);
    return this;
  }

  public PublicKeyTypeRequest countKeyPairIdentity() {
    return countKeyPairIdentity("keyPairIdentityCount");
  }

  public PublicKeyTypeRequest countKeyPairIdentity(String retName) {
    return countKeyPairIdentity(retName, KeyPairIdentityRequest.newInstance());
  }

  public PublicKeyTypeRequest countKeyPairIdentity(KeyPairIdentityRequest keyPairIdentity) {
    return countKeyPairIdentity("keyPairIdentityCount", keyPairIdentity);
  }

  public PublicKeyTypeRequest countKeyPairIdentity(
      String retName, KeyPairIdentityRequest keyPairIdentity) {
    keyPairIdentity.count();
    return statsFromKeyPairIdentity(retName, keyPairIdentity);
  }

  public PublicKeyTypeRequest statsFromKeyPairIdentity(
      String retName, KeyPairIdentityRequest keyPairIdentity) {
    return addDynamicProperty(retName, keyPairIdentity, KeyPairIdentity.KEY_TYPE_PROPERTY);
  }

  public PublicKeyTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PublicKeyTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PublicKeyTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PublicKeyTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
