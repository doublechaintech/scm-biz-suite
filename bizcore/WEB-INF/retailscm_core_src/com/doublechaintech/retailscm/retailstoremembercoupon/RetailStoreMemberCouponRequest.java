package com.doublechaintech.retailscm.retailstoremembercoupon;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon.*;

public class RetailStoreMemberCouponRequest extends BaseRequest<RetailStoreMemberCoupon> {
  public static RetailStoreMemberCouponRequest newInstance() {
    return new RetailStoreMemberCouponRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreMemberCouponRequest resultByClass(
      Class<? extends RetailStoreMemberCoupon> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreMemberCouponRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreMemberCouponRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreMemberCoupon";
  }

  public RetailStoreMemberCouponRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreMemberCouponRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreMemberCouponRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreMemberCouponRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreMemberCouponRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectOwner()
        .selectNumber()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public RetailStoreMemberCouponRequest selectAny() {
    return selectAll();
  }

  public RetailStoreMemberCouponRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(OWNER_PROPERTY);
    select(NUMBER_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreMemberCouponRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreMemberCouponRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    OWNER_PROPERTY,
    NUMBER_PROPERTY,
    LAST_UPDATE_TIME_PROPERTY,
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

  public RetailStoreMemberCouponRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreMemberCouponRequest comment(String comment) {
    return this;
  }

  public RetailStoreMemberCouponRequest enhance() {
    return this;
  }

  public RetailStoreMemberCouponRequest overrideClass(
      Class<? extends RetailStoreMemberCoupon> clazz) {
    return this;
  }

  public RetailStoreMemberCouponRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreMemberCouponRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreMemberCouponRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreMemberCouponRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreMemberCouponRequest count() {
    return countId("count");
  }

  public static RetailStoreMemberCouponRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreMemberCouponRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreMemberCouponRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreMemberCouponRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberCouponRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreMemberCouponRequest countId() {
    return countId("countId");
  }

  public RetailStoreMemberCouponRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreMemberCouponRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreMemberCouponRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreMemberCouponRequest minId() {
    return minId("minId");
  }

  public RetailStoreMemberCouponRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreMemberCouponRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreMemberCouponRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreMemberCouponRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberCouponRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberCouponRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberCouponRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreMemberCouponRequest countName() {
    return countName("countName");
  }

  public RetailStoreMemberCouponRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreMemberCouponRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest minName() {
    return minName("minName");
  }

  public RetailStoreMemberCouponRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreMemberCouponRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreMemberCouponRequest filterByNumber(String number) {

    if (number == null) {
      return this;
    }

    return filterByNumber(QueryOperator.EQUAL, number);
  }

  public RetailStoreMemberCouponRequest whereNumberIsNull() {
    return where(NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberCouponRequest whereNumberIsNotNull() {
    return where(NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberCouponRequest filterByNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest selectNumber() {
    return select(NUMBER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest unselectNumber() {
    return unselect(NUMBER_PROPERTY);
  }

  public SearchCriteria getNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberCouponRequest orderByNumber(boolean asc) {
    addOrderBy(NUMBER_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNumberAscending() {
    addOrderBy(NUMBER_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNumberDescending() {
    addOrderBy(NUMBER_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNumberAscendingUsingGBK() {
    addOrderBy("convert(number using gbk)", true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByNumberDescendingUsingGBK() {
    addOrderBy("convert(number using gbk)", false);
    return this;
  }

  public RetailStoreMemberCouponRequest countNumber() {
    return countNumber("countNumber");
  }

  public RetailStoreMemberCouponRequest countNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NUMBER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest maxNumber() {
    return maxNumber("maxNumber");
  }

  public RetailStoreMemberCouponRequest maxNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NUMBER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest minNumber() {
    return minNumber("minNumber");
  }

  public RetailStoreMemberCouponRequest minNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NUMBER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByNumber() {
    return groupByNumber(NUMBER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByNumber(String ret) {
    return groupBy(ret, NUMBER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByNumber(SqlFunction func) {
    return groupByNumber(NUMBER_PROPERTY, func);
  }

  public RetailStoreMemberCouponRequest groupByNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, NUMBER_PROPERTY);
    return this;
  }

  public RetailStoreMemberCouponRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public RetailStoreMemberCouponRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberCouponRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberCouponRequest whereLastUpdateTimeBetween(
      Date lastUpdateTimeStart, Date lastUpdateTimeEnd) {
    if (ObjectUtil.isEmpty(lastUpdateTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastUpdateTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastUpdateTimeStart, lastUpdateTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberCouponRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberCouponRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public RetailStoreMemberCouponRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public RetailStoreMemberCouponRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public RetailStoreMemberCouponRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public RetailStoreMemberCouponRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public RetailStoreMemberCouponRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreMemberCouponRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberCouponRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberCouponRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberCouponRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreMemberCouponRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberCouponRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberCouponRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberCouponRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreMemberCouponRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreMemberCouponRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreMemberCouponRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreMemberCouponRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreMemberCouponRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreMemberCouponRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreMemberCouponRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreMemberCouponRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreMemberCouponRequest filterByOwner(RetailStoreMemberRequest owner) {
    return filterByOwner(owner, RetailStoreMember::getId);
  }

  public RetailStoreMemberCouponRequest filterByOwner(RetailStoreMember... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreMember... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberCouponRequest selectOwnerId() {
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

  public RetailStoreMemberCouponRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberCouponRequest filterByOwner(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, RetailStoreMember.ID_PROPERTY);
  }

  public RetailStoreMemberCouponRequest selectOwner() {
    return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
  }

  public RetailStoreMemberCouponRequest selectOwner(RetailStoreMemberRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberCouponRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberCouponRequest groupByOwner(RetailStoreMemberRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberCouponRequest aggregateOwner(RetailStoreMemberRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberCouponRequest countOwner() {
    return countOwner("countOwner");
  }

  public RetailStoreMemberCouponRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public RetailStoreMemberCouponRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberCouponRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberCouponRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreMemberCouponRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreMemberCouponRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreMemberCouponRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
