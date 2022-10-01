package com.doublechaintech.retailscm.warehouseasset;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.warehouseasset.WarehouseAsset.*;

public class WarehouseAssetRequest extends BaseRequest<WarehouseAsset> {
  public static WarehouseAssetRequest newInstance() {
    return new WarehouseAssetRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public WarehouseAssetRequest resultByClass(Class<? extends WarehouseAsset> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public WarehouseAssetRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public WarehouseAssetRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "WarehouseAsset";
  }

  public WarehouseAssetRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public WarehouseAssetRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public WarehouseAssetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public WarehouseAssetRequest select(String... names) {
    super.select(names);
    return this;
  }

  public WarehouseAssetRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectPosition()
        .selectOwner()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public WarehouseAssetRequest selectAny() {
    return selectAll();
  }

  public WarehouseAssetRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(POSITION_PROPERTY);
    select(OWNER_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public WarehouseAssetRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public WarehouseAssetRequest where(
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
    POSITION_PROPERTY,
    OWNER_PROPERTY,
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

  public WarehouseAssetRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public WarehouseAssetRequest comment(String comment) {
    return this;
  }

  public WarehouseAssetRequest enhance() {
    return this;
  }

  public WarehouseAssetRequest overrideClass(Class<? extends WarehouseAsset> clazz) {
    return this;
  }

  public WarehouseAssetRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public WarehouseAssetRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public WarehouseAssetRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public WarehouseAssetRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public WarehouseAssetRequest count() {
    return countId("count");
  }

  public static WarehouseAssetRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public WarehouseAssetRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public WarehouseAssetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseAssetRequest selectId() {
    return select(ID_PROPERTY);
  }

  public WarehouseAssetRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseAssetRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public WarehouseAssetRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public WarehouseAssetRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public WarehouseAssetRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public WarehouseAssetRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public WarehouseAssetRequest countId() {
    return countId("countId");
  }

  public WarehouseAssetRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public WarehouseAssetRequest maxId() {
    return maxId("maxId");
  }

  public WarehouseAssetRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public WarehouseAssetRequest minId() {
    return minId("minId");
  }

  public WarehouseAssetRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public WarehouseAssetRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public WarehouseAssetRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public WarehouseAssetRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public WarehouseAssetRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public WarehouseAssetRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public WarehouseAssetRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseAssetRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseAssetRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseAssetRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public WarehouseAssetRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseAssetRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public WarehouseAssetRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public WarehouseAssetRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public WarehouseAssetRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public WarehouseAssetRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public WarehouseAssetRequest countName() {
    return countName("countName");
  }

  public WarehouseAssetRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public WarehouseAssetRequest maxName() {
    return maxName("maxName");
  }

  public WarehouseAssetRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public WarehouseAssetRequest minName() {
    return minName("minName");
  }

  public WarehouseAssetRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public WarehouseAssetRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public WarehouseAssetRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public WarehouseAssetRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public WarehouseAssetRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public WarehouseAssetRequest filterByPosition(String position) {

    if (position == null) {
      return this;
    }

    return filterByPosition(QueryOperator.EQUAL, position);
  }

  public WarehouseAssetRequest wherePositionIsNull() {
    return where(POSITION_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseAssetRequest wherePositionIsNotNull() {
    return where(POSITION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseAssetRequest filterByPosition(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPositionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseAssetRequest selectPosition() {
    return select(POSITION_PROPERTY);
  }

  public WarehouseAssetRequest unselectPosition() {
    return unselect(POSITION_PROPERTY);
  }

  public SearchCriteria getPositionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(POSITION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseAssetRequest orderByPosition(boolean asc) {
    addOrderBy(POSITION_PROPERTY, asc);
    return this;
  }

  public WarehouseAssetRequest orderByPositionAscending() {
    addOrderBy(POSITION_PROPERTY, true);
    return this;
  }

  public WarehouseAssetRequest orderByPositionDescending() {
    addOrderBy(POSITION_PROPERTY, false);
    return this;
  }

  public WarehouseAssetRequest orderByPositionAscendingUsingGBK() {
    addOrderBy("convert(position using gbk)", true);
    return this;
  }

  public WarehouseAssetRequest orderByPositionDescendingUsingGBK() {
    addOrderBy("convert(position using gbk)", false);
    return this;
  }

  public WarehouseAssetRequest countPosition() {
    return countPosition("countPosition");
  }

  public WarehouseAssetRequest countPosition(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, POSITION_PROPERTY);
  }

  public WarehouseAssetRequest maxPosition() {
    return maxPosition("maxPosition");
  }

  public WarehouseAssetRequest maxPosition(String aggName) {
    return aggregate(aggName, AggFunc.MAX, POSITION_PROPERTY);
  }

  public WarehouseAssetRequest minPosition() {
    return minPosition("minPosition");
  }

  public WarehouseAssetRequest minPosition(String aggName) {
    return aggregate(aggName, AggFunc.MIN, POSITION_PROPERTY);
  }

  public WarehouseAssetRequest groupByPosition() {
    return groupByPosition(POSITION_PROPERTY);
  }

  public WarehouseAssetRequest groupByPosition(String ret) {
    return groupBy(ret, POSITION_PROPERTY);
  }

  public WarehouseAssetRequest groupByPosition(SqlFunction func) {
    return groupByPosition(POSITION_PROPERTY, func);
  }

  public WarehouseAssetRequest groupByPosition(String ret, SqlFunction func) {
    super.groupBy(ret, func, POSITION_PROPERTY);
    return this;
  }

  public WarehouseAssetRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public WarehouseAssetRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseAssetRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseAssetRequest whereLastUpdateTimeBetween(
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

  public WarehouseAssetRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseAssetRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseAssetRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseAssetRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseAssetRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseAssetRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public WarehouseAssetRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public WarehouseAssetRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public WarehouseAssetRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public WarehouseAssetRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseAssetRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public WarehouseAssetRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseAssetRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public WarehouseAssetRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseAssetRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseAssetRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseAssetRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public WarehouseAssetRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public WarehouseAssetRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public WarehouseAssetRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseAssetRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseAssetRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseAssetRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public WarehouseAssetRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseAssetRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public WarehouseAssetRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public WarehouseAssetRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public WarehouseAssetRequest countVersion() {
    return countVersion("countVersion");
  }

  public WarehouseAssetRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public WarehouseAssetRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public WarehouseAssetRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public WarehouseAssetRequest minVersion() {
    return minVersion("minVersion");
  }

  public WarehouseAssetRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public WarehouseAssetRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public WarehouseAssetRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public WarehouseAssetRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public WarehouseAssetRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public WarehouseAssetRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public WarehouseAssetRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public WarehouseAssetRequest filterByOwner(WarehouseRequest owner) {
    return filterByOwner(owner, Warehouse::getId);
  }

  public WarehouseAssetRequest filterByOwner(Warehouse... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(Warehouse... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public WarehouseAssetRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public WarehouseRequest upToOwner() {
    return upToOwner(WarehouseRequest.newInstance());
  }

  public WarehouseRequest upToOwner(WarehouseRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public WarehouseRequest endAtOwner(String retName) {
    return endAtOwner(retName, WarehouseRequest.newInstance());
  }

  public WarehouseRequest endAtOwner(String retName, WarehouseRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public WarehouseAssetRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public WarehouseAssetRequest filterByOwner(WarehouseRequest owner, IDRefine<Warehouse> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(WarehouseRequest owner, IDRefine<Warehouse> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, Warehouse.ID_PROPERTY);
  }

  public WarehouseAssetRequest selectOwner() {
    return selectOwner(WarehouseRequest.newInstance().selectSelf());
  }

  public WarehouseAssetRequest selectOwner(WarehouseRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public WarehouseAssetRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public WarehouseAssetRequest groupByOwner(WarehouseRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public WarehouseAssetRequest aggregateOwner(WarehouseRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public WarehouseAssetRequest countOwner() {
    return countOwner("countOwner");
  }

  public WarehouseAssetRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public WarehouseAssetRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public WarehouseAssetRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public WarehouseAssetRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseAssetRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseAssetRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public WarehouseAssetRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public WarehouseAssetRequest unlimited() {
    super.unlimited();
    return this;
  }

  public WarehouseAssetRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
