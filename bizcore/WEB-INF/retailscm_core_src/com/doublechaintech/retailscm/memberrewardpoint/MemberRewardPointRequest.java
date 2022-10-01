package com.doublechaintech.retailscm.memberrewardpoint;

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
import static com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint.*;

public class MemberRewardPointRequest extends BaseRequest<MemberRewardPoint> {
  public static MemberRewardPointRequest newInstance() {
    return new MemberRewardPointRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public MemberRewardPointRequest resultByClass(Class<? extends MemberRewardPoint> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public MemberRewardPointRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public MemberRewardPointRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "MemberRewardPoint";
  }

  public MemberRewardPointRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public MemberRewardPointRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public MemberRewardPointRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public MemberRewardPointRequest select(String... names) {
    super.select(names);
    return this;
  }

  public MemberRewardPointRequest selectAll() {
    return this.selectId().selectName().selectPoint().selectOwner().selectVersion();
  }

  public MemberRewardPointRequest selectAny() {
    return selectAll();
  }

  public MemberRewardPointRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(POINT_PROPERTY);
    select(OWNER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public MemberRewardPointRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public MemberRewardPointRequest where(
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

  public MemberRewardPointRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public MemberRewardPointRequest comment(String comment) {
    return this;
  }

  public MemberRewardPointRequest enhance() {
    return this;
  }

  public MemberRewardPointRequest overrideClass(Class<? extends MemberRewardPoint> clazz) {
    return this;
  }

  public MemberRewardPointRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public MemberRewardPointRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public MemberRewardPointRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public MemberRewardPointRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public MemberRewardPointRequest count() {
    return countId("count");
  }

  public static MemberRewardPointRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public MemberRewardPointRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public MemberRewardPointRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRequest selectId() {
    return select(ID_PROPERTY);
  }

  public MemberRewardPointRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public MemberRewardPointRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public MemberRewardPointRequest countId() {
    return countId("countId");
  }

  public MemberRewardPointRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public MemberRewardPointRequest maxId() {
    return maxId("maxId");
  }

  public MemberRewardPointRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public MemberRewardPointRequest minId() {
    return minId("minId");
  }

  public MemberRewardPointRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public MemberRewardPointRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public MemberRewardPointRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public MemberRewardPointRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public MemberRewardPointRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public MemberRewardPointRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public MemberRewardPointRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public MemberRewardPointRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public MemberRewardPointRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public MemberRewardPointRequest countName() {
    return countName("countName");
  }

  public MemberRewardPointRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public MemberRewardPointRequest maxName() {
    return maxName("maxName");
  }

  public MemberRewardPointRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public MemberRewardPointRequest minName() {
    return minName("minName");
  }

  public MemberRewardPointRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public MemberRewardPointRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public MemberRewardPointRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public MemberRewardPointRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public MemberRewardPointRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public MemberRewardPointRequest filterByPoint(int point) {

    return filterByPoint(QueryOperator.EQUAL, point);
  }

  public MemberRewardPointRequest wherePointIsNull() {
    return where(POINT_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRequest wherePointIsNotNull() {
    return where(POINT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRequest wherePointBetween(Integer pointStart, Integer pointEnd) {
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

  public MemberRewardPointRequest wherePointLessThan(Integer point) {
    if (ObjectUtil.isEmpty(point)) {
      throw new IllegalArgumentException(
          "Method wherePointLessThan, the parameter point is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPointSearchCriteria(QueryOperator.LESS_THAN, new Object[] {point});
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRequest wherePointGreaterThan(int point) {
    if (ObjectUtil.isEmpty(point)) {
      throw new IllegalArgumentException(
          "Method wherePointGreaterThan, the parameter point is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPointSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {point});
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRequest filterByPoint(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPointSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRequest selectPoint() {
    return select(POINT_PROPERTY);
  }

  public MemberRewardPointRequest unselectPoint() {
    return unselect(POINT_PROPERTY);
  }

  public SearchCriteria getPointSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(POINT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRequest orderByPoint(boolean asc) {
    addOrderBy(POINT_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRequest orderByPointAscending() {
    addOrderBy(POINT_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRequest orderByPointDescending() {
    addOrderBy(POINT_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRequest countPoint() {
    return countPoint("countPoint");
  }

  public MemberRewardPointRequest countPoint(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, POINT_PROPERTY);
  }

  public MemberRewardPointRequest maxPoint() {
    return maxPoint("maxPoint");
  }

  public MemberRewardPointRequest maxPoint(String aggName) {
    return aggregate(aggName, AggFunc.MAX, POINT_PROPERTY);
  }

  public MemberRewardPointRequest minPoint() {
    return minPoint("minPoint");
  }

  public MemberRewardPointRequest minPoint(String aggName) {
    return aggregate(aggName, AggFunc.MIN, POINT_PROPERTY);
  }

  public MemberRewardPointRequest sumPoint() {
    return sumPoint("sumPoint");
  }

  public MemberRewardPointRequest sumPoint(String aggName) {
    return aggregate(aggName, AggFunc.SUM, POINT_PROPERTY);
  }

  public MemberRewardPointRequest groupByPoint() {
    return groupByPoint(POINT_PROPERTY);
  }

  public MemberRewardPointRequest groupByPoint(String ret) {
    return groupBy(ret, POINT_PROPERTY);
  }

  public MemberRewardPointRequest groupByPoint(SqlFunction func) {
    return groupByPoint(POINT_PROPERTY, func);
  }

  public MemberRewardPointRequest groupByPoint(String ret, SqlFunction func) {
    super.groupBy(ret, func, POINT_PROPERTY);
    return this;
  }

  public MemberRewardPointRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public MemberRewardPointRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MemberRewardPointRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public MemberRewardPointRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MemberRewardPointRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public MemberRewardPointRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public MemberRewardPointRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public MemberRewardPointRequest countVersion() {
    return countVersion("countVersion");
  }

  public MemberRewardPointRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public MemberRewardPointRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public MemberRewardPointRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public MemberRewardPointRequest minVersion() {
    return minVersion("minVersion");
  }

  public MemberRewardPointRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public MemberRewardPointRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public MemberRewardPointRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public MemberRewardPointRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public MemberRewardPointRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public MemberRewardPointRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public MemberRewardPointRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public MemberRewardPointRequest filterByOwner(RetailStoreMemberRequest owner) {
    return filterByOwner(owner, RetailStoreMember::getId);
  }

  public MemberRewardPointRequest filterByOwner(RetailStoreMember... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreMember... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberRewardPointRequest selectOwnerId() {
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

  public MemberRewardPointRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public MemberRewardPointRequest filterByOwner(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, RetailStoreMember.ID_PROPERTY);
  }

  public MemberRewardPointRequest selectOwner() {
    return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
  }

  public MemberRewardPointRequest selectOwner(RetailStoreMemberRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberRewardPointRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public MemberRewardPointRequest groupByOwner(RetailStoreMemberRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberRewardPointRequest aggregateOwner(RetailStoreMemberRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public MemberRewardPointRequest countOwner() {
    return countOwner("countOwner");
  }

  public MemberRewardPointRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public MemberRewardPointRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public MemberRewardPointRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public MemberRewardPointRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public MemberRewardPointRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MemberRewardPointRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public MemberRewardPointRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public MemberRewardPointRequest unlimited() {
    super.unlimited();
    return this;
  }

  public MemberRewardPointRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
