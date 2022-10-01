package com.doublechaintech.retailscm.memberrewardpointredemption;

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
import static com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption.*;

public class MemberRewardPointRedemptionRequest extends BaseRequest<MemberRewardPointRedemption> {
  public static MemberRewardPointRedemptionRequest newInstance() {
    return new MemberRewardPointRedemptionRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public MemberRewardPointRedemptionRequest resultByClass(
      Class<? extends MemberRewardPointRedemption> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public MemberRewardPointRedemptionRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public MemberRewardPointRedemptionRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "MemberRewardPointRedemption";
  }

  public MemberRewardPointRedemptionRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public MemberRewardPointRedemptionRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public MemberRewardPointRedemptionRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public MemberRewardPointRedemptionRequest select(String... names) {
    super.select(names);
    return this;
  }

  public MemberRewardPointRedemptionRequest selectAll() {
    return this.selectId().selectName().selectPoint().selectOwner().selectVersion();
  }

  public MemberRewardPointRedemptionRequest selectAny() {
    return selectAll();
  }

  public MemberRewardPointRedemptionRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(POINT_PROPERTY);
    select(OWNER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public MemberRewardPointRedemptionRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public MemberRewardPointRedemptionRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, POINT_PROPERTY, OWNER_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public MemberRewardPointRedemptionRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public MemberRewardPointRedemptionRequest comment(String comment) {
    return this;
  }

  public MemberRewardPointRedemptionRequest enhance() {
    return this;
  }

  public MemberRewardPointRedemptionRequest overrideClass(
      Class<? extends MemberRewardPointRedemption> clazz) {
    return this;
  }

  public MemberRewardPointRedemptionRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public MemberRewardPointRedemptionRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public MemberRewardPointRedemptionRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public MemberRewardPointRedemptionRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public MemberRewardPointRedemptionRequest count() {
    return countId("count");
  }

  public static MemberRewardPointRedemptionRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public MemberRewardPointRedemptionRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public MemberRewardPointRedemptionRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRedemptionRequest selectId() {
    return select(ID_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRedemptionRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public MemberRewardPointRedemptionRequest countId() {
    return countId("countId");
  }

  public MemberRewardPointRedemptionRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest maxId() {
    return maxId("maxId");
  }

  public MemberRewardPointRedemptionRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest minId() {
    return minId("minId");
  }

  public MemberRewardPointRedemptionRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public MemberRewardPointRedemptionRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemptionRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public MemberRewardPointRedemptionRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRedemptionRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRedemptionRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRedemptionRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRedemptionRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public MemberRewardPointRedemptionRequest countName() {
    return countName("countName");
  }

  public MemberRewardPointRedemptionRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest maxName() {
    return maxName("maxName");
  }

  public MemberRewardPointRedemptionRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest minName() {
    return minName("minName");
  }

  public MemberRewardPointRedemptionRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public MemberRewardPointRedemptionRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemptionRequest filterByPoint(int point) {

    return filterByPoint(QueryOperator.EQUAL, point);
  }

  public MemberRewardPointRedemptionRequest wherePointIsNull() {
    return where(POINT_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRedemptionRequest wherePointIsNotNull() {
    return where(POINT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRedemptionRequest wherePointBetween(
      Integer pointStart, Integer pointEnd) {
    if (ObjectUtil.isEmpty(pointStart)) {
      throw new IllegalArgumentException(
          "Method wherePointBetween, the parameter pointStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(pointEnd)) {
      throw new IllegalArgumentException(
          "Method wherePointBetween, the parameter pointEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPointSearchCriteria(QueryOperator.BETWEEN, new Object[] {pointStart, pointEnd});
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRedemptionRequest wherePointLessThan(Integer point) {
    if (ObjectUtil.isEmpty(point)) {
      throw new IllegalArgumentException(
          "Method wherePointLessThan, the parameter point is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPointSearchCriteria(QueryOperator.LESS_THAN, new Object[] {point});
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRedemptionRequest wherePointGreaterThan(int point) {
    if (ObjectUtil.isEmpty(point)) {
      throw new IllegalArgumentException(
          "Method wherePointGreaterThan, the parameter point is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPointSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {point});
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRedemptionRequest filterByPoint(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPointSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRedemptionRequest selectPoint() {
    return select(POINT_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest unselectPoint() {
    return unselect(POINT_PROPERTY);
  }

  public SearchCriteria getPointSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(POINT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRedemptionRequest orderByPoint(boolean asc) {
    addOrderBy(POINT_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByPointAscending() {
    addOrderBy(POINT_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByPointDescending() {
    addOrderBy(POINT_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRedemptionRequest countPoint() {
    return countPoint("countPoint");
  }

  public MemberRewardPointRedemptionRequest countPoint(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, POINT_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest maxPoint() {
    return maxPoint("maxPoint");
  }

  public MemberRewardPointRedemptionRequest maxPoint(String aggName) {
    return aggregate(aggName, AggFunc.MAX, POINT_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest minPoint() {
    return minPoint("minPoint");
  }

  public MemberRewardPointRedemptionRequest minPoint(String aggName) {
    return aggregate(aggName, AggFunc.MIN, POINT_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest sumPoint() {
    return sumPoint("sumPoint");
  }

  public MemberRewardPointRedemptionRequest sumPoint(String aggName) {
    return aggregate(aggName, AggFunc.SUM, POINT_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByPoint() {
    return groupByPoint(POINT_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByPoint(String ret) {
    return groupBy(ret, POINT_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByPoint(SqlFunction func) {
    return groupByPoint(POINT_PROPERTY, func);
  }

  public MemberRewardPointRedemptionRequest groupByPoint(String ret, SqlFunction func) {
    super.groupBy(ret, func, POINT_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemptionRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public MemberRewardPointRedemptionRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRedemptionRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRedemptionRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRedemptionRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRedemptionRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRedemptionRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRedemptionRequest countVersion() {
    return countVersion("countVersion");
  }

  public MemberRewardPointRedemptionRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public MemberRewardPointRedemptionRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest minVersion() {
    return minVersion("minVersion");
  }

  public MemberRewardPointRedemptionRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public MemberRewardPointRedemptionRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public MemberRewardPointRedemptionRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemptionRequest filterByOwner(RetailStoreMemberRequest owner) {
    return filterByOwner(owner, RetailStoreMember::getId);
  }

  public MemberRewardPointRedemptionRequest filterByOwner(RetailStoreMember... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreMember... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberRewardPointRedemptionRequest selectOwnerId() {
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

  public MemberRewardPointRedemptionRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberRewardPointRedemptionRequest filterByOwner(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, RetailStoreMember.ID_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest selectOwner() {
    return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
  }

  public MemberRewardPointRedemptionRequest selectOwner(RetailStoreMemberRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberRewardPointRedemptionRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public MemberRewardPointRedemptionRequest groupByOwner(RetailStoreMemberRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberRewardPointRedemptionRequest aggregateOwner(RetailStoreMemberRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberRewardPointRedemptionRequest countOwner() {
    return countOwner("countOwner");
  }

  public MemberRewardPointRedemptionRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public MemberRewardPointRedemptionRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRedemptionRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRedemptionRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public MemberRewardPointRedemptionRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public MemberRewardPointRedemptionRequest unlimited() {
    super.unlimited();
    return this;
  }

  public MemberRewardPointRedemptionRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
