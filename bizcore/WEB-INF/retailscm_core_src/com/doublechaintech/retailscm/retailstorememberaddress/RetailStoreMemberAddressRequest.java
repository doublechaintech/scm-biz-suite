package com.doublechaintech.retailscm.retailstorememberaddress;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress.*;

public class RetailStoreMemberAddressRequest extends BaseRequest<RetailStoreMemberAddress> {
  public static RetailStoreMemberAddressRequest newInstance() {
    return new RetailStoreMemberAddressRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreMemberAddressRequest resultByClass(
      Class<? extends RetailStoreMemberAddress> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreMemberAddressRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreMemberAddressRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreMemberAddress";
  }

  public RetailStoreMemberAddressRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreMemberAddressRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreMemberAddressRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreMemberAddressRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreMemberAddressRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectOwner()
        .selectMobilePhone()
        .selectAddress()
        .selectVersion();
  }

  public RetailStoreMemberAddressRequest selectAny() {
    return selectAll();
  }

  public RetailStoreMemberAddressRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(OWNER_PROPERTY);
    select(MOBILE_PHONE_PROPERTY);
    select(ADDRESS_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreMemberAddressRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreMemberAddressRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    OWNER_PROPERTY,
    MOBILE_PHONE_PROPERTY,
    ADDRESS_PROPERTY,
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

  public RetailStoreMemberAddressRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreMemberAddressRequest comment(String comment) {
    return this;
  }

  public RetailStoreMemberAddressRequest enhance() {
    return this;
  }

  public RetailStoreMemberAddressRequest overrideClass(
      Class<? extends RetailStoreMemberAddress> clazz) {
    return this;
  }

  public RetailStoreMemberAddressRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreMemberAddressRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreMemberAddressRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreMemberAddressRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreMemberAddressRequest count() {
    return countId("count");
  }

  public static RetailStoreMemberAddressRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreMemberAddressRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreMemberAddressRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberAddressRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreMemberAddressRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberAddressRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreMemberAddressRequest countId() {
    return countId("countId");
  }

  public RetailStoreMemberAddressRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreMemberAddressRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreMemberAddressRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreMemberAddressRequest minId() {
    return minId("minId");
  }

  public RetailStoreMemberAddressRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreMemberAddressRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddressRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreMemberAddressRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberAddressRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberAddressRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberAddressRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreMemberAddressRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberAddressRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreMemberAddressRequest countName() {
    return countName("countName");
  }

  public RetailStoreMemberAddressRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreMemberAddressRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreMemberAddressRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreMemberAddressRequest minName() {
    return minName("minName");
  }

  public RetailStoreMemberAddressRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreMemberAddressRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddressRequest filterByMobilePhone(String mobilePhone) {

    if (mobilePhone == null) {
      return this;
    }

    return filterByMobilePhone(QueryOperator.EQUAL, mobilePhone);
  }

  public RetailStoreMemberAddressRequest whereMobilePhoneIsNull() {
    return where(MOBILE_PHONE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberAddressRequest whereMobilePhoneIsNotNull() {
    return where(MOBILE_PHONE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberAddressRequest filterByMobilePhone(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobilePhoneSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberAddressRequest selectMobilePhone() {
    return select(MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberAddressRequest unselectMobilePhone() {
    return unselect(MOBILE_PHONE_PROPERTY);
  }

  public SearchCriteria getMobilePhoneSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PHONE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberAddressRequest orderByMobilePhone(boolean asc) {
    addOrderBy(MOBILE_PHONE_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByMobilePhoneAscending() {
    addOrderBy(MOBILE_PHONE_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByMobilePhoneDescending() {
    addOrderBy(MOBILE_PHONE_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByMobilePhoneAscendingUsingGBK() {
    addOrderBy("convert(mobilePhone using gbk)", true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByMobilePhoneDescendingUsingGBK() {
    addOrderBy("convert(mobilePhone using gbk)", false);
    return this;
  }

  public RetailStoreMemberAddressRequest countMobilePhone() {
    return countMobilePhone("countMobilePhone");
  }

  public RetailStoreMemberAddressRequest countMobilePhone(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberAddressRequest maxMobilePhone() {
    return maxMobilePhone("maxMobilePhone");
  }

  public RetailStoreMemberAddressRequest maxMobilePhone(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberAddressRequest minMobilePhone() {
    return minMobilePhone("minMobilePhone");
  }

  public RetailStoreMemberAddressRequest minMobilePhone(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByMobilePhone() {
    return groupByMobilePhone(MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByMobilePhone(String ret) {
    return groupBy(ret, MOBILE_PHONE_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByMobilePhone(SqlFunction func) {
    return groupByMobilePhone(MOBILE_PHONE_PROPERTY, func);
  }

  public RetailStoreMemberAddressRequest groupByMobilePhone(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PHONE_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddressRequest filterByAddress(String address) {

    if (address == null) {
      return this;
    }

    return filterByAddress(QueryOperator.EQUAL, address);
  }

  public RetailStoreMemberAddressRequest whereAddressIsNull() {
    return where(ADDRESS_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberAddressRequest whereAddressIsNotNull() {
    return where(ADDRESS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberAddressRequest filterByAddress(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAddressSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberAddressRequest selectAddress() {
    return select(ADDRESS_PROPERTY);
  }

  public RetailStoreMemberAddressRequest unselectAddress() {
    return unselect(ADDRESS_PROPERTY);
  }

  public SearchCriteria getAddressSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ADDRESS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberAddressRequest orderByAddress(boolean asc) {
    addOrderBy(ADDRESS_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByAddressAscending() {
    addOrderBy(ADDRESS_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByAddressDescending() {
    addOrderBy(ADDRESS_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByAddressAscendingUsingGBK() {
    addOrderBy("convert(address using gbk)", true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByAddressDescendingUsingGBK() {
    addOrderBy("convert(address using gbk)", false);
    return this;
  }

  public RetailStoreMemberAddressRequest countAddress() {
    return countAddress("countAddress");
  }

  public RetailStoreMemberAddressRequest countAddress(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ADDRESS_PROPERTY);
  }

  public RetailStoreMemberAddressRequest maxAddress() {
    return maxAddress("maxAddress");
  }

  public RetailStoreMemberAddressRequest maxAddress(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ADDRESS_PROPERTY);
  }

  public RetailStoreMemberAddressRequest minAddress() {
    return minAddress("minAddress");
  }

  public RetailStoreMemberAddressRequest minAddress(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ADDRESS_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByAddress() {
    return groupByAddress(ADDRESS_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByAddress(String ret) {
    return groupBy(ret, ADDRESS_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByAddress(SqlFunction func) {
    return groupByAddress(ADDRESS_PROPERTY, func);
  }

  public RetailStoreMemberAddressRequest groupByAddress(String ret, SqlFunction func) {
    super.groupBy(ret, func, ADDRESS_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddressRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreMemberAddressRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberAddressRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberAddressRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberAddressRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreMemberAddressRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberAddressRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberAddressRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberAddressRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreMemberAddressRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreMemberAddressRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreMemberAddressRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreMemberAddressRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreMemberAddressRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreMemberAddressRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreMemberAddressRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreMemberAddressRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddressRequest filterByOwner(RetailStoreMemberRequest owner) {
    return filterByOwner(owner, RetailStoreMember::getId);
  }

  public RetailStoreMemberAddressRequest filterByOwner(RetailStoreMember... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreMember... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberAddressRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest upToOwner() {
    return upToOwner(RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreMemberRequest upToOwner(RetailStoreMemberRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public RetailStoreMemberRequest endAtOwner(String retName) {
    return endAtOwner(retName, RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreMemberRequest endAtOwner(String retName, RetailStoreMemberRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public RetailStoreMemberAddressRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberAddressRequest filterByOwner(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, RetailStoreMember.ID_PROPERTY);
  }

  public RetailStoreMemberAddressRequest selectOwner() {
    return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
  }

  public RetailStoreMemberAddressRequest selectOwner(RetailStoreMemberRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberAddressRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberAddressRequest groupByOwner(RetailStoreMemberRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberAddressRequest aggregateOwner(RetailStoreMemberRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberAddressRequest countOwner() {
    return countOwner("countOwner");
  }

  public RetailStoreMemberAddressRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public RetailStoreMemberAddressRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public RetailStoreMemberAddressRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberAddressRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberAddressRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreMemberAddressRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreMemberAddressRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreMemberAddressRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
