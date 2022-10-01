package com.doublechaintech.retailscm.goodsshelf;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpaceRequest;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocationRequest;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest;
import com.doublechaintech.retailscm.storagespace.StorageSpaceRequest;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsshelf.GoodsShelf.*;

public class GoodsShelfRequest extends BaseRequest<GoodsShelf> {
  public static GoodsShelfRequest newInstance() {
    return new GoodsShelfRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public GoodsShelfRequest resultByClass(Class<? extends GoodsShelf> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public GoodsShelfRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public GoodsShelfRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "GoodsShelf";
  }

  public GoodsShelfRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public GoodsShelfRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public GoodsShelfRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public GoodsShelfRequest select(String... names) {
    super.select(names);
    return this;
  }

  public GoodsShelfRequest selectAll() {
    return this.selectId()
        .selectLocation()
        .selectStorageSpace()
        .selectSupplierSpace()
        .selectDamageSpace()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public GoodsShelfRequest selectAny() {
    return selectAll()
        .selectGoodsShelfStockCountList(Q.goodsShelfStockCount().selectSelf())
        .selectGoodsAllocationList(Q.goodsAllocation().selectSelf());
  }

  public GoodsShelfRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(STORAGE_SPACE_PROPERTY);
    select(SUPPLIER_SPACE_PROPERTY);
    select(DAMAGE_SPACE_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public GoodsShelfRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public GoodsShelfRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    LOCATION_PROPERTY,
    STORAGE_SPACE_PROPERTY,
    SUPPLIER_SPACE_PROPERTY,
    DAMAGE_SPACE_PROPERTY,
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

  public GoodsShelfRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public GoodsShelfRequest comment(String comment) {
    return this;
  }

  public GoodsShelfRequest enhance() {
    return this;
  }

  public GoodsShelfRequest overrideClass(Class<? extends GoodsShelf> clazz) {
    return this;
  }

  public GoodsShelfRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public GoodsShelfRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public GoodsShelfRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public GoodsShelfRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public GoodsShelfRequest count() {
    return countId("count");
  }

  public static GoodsShelfRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public GoodsShelfRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public GoodsShelfRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfRequest selectId() {
    return select(ID_PROPERTY);
  }

  public GoodsShelfRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public GoodsShelfRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public GoodsShelfRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public GoodsShelfRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public GoodsShelfRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public GoodsShelfRequest countId() {
    return countId("countId");
  }

  public GoodsShelfRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public GoodsShelfRequest maxId() {
    return maxId("maxId");
  }

  public GoodsShelfRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public GoodsShelfRequest minId() {
    return minId("minId");
  }

  public GoodsShelfRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public GoodsShelfRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public GoodsShelfRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public GoodsShelfRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public GoodsShelfRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public GoodsShelfRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public GoodsShelfRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public GoodsShelfRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public GoodsShelfRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public GoodsShelfRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public GoodsShelfRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public GoodsShelfRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public GoodsShelfRequest countLocation() {
    return countLocation("countLocation");
  }

  public GoodsShelfRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public GoodsShelfRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public GoodsShelfRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public GoodsShelfRequest minLocation() {
    return minLocation("minLocation");
  }

  public GoodsShelfRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public GoodsShelfRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public GoodsShelfRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public GoodsShelfRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public GoodsShelfRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public GoodsShelfRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public GoodsShelfRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfRequest whereLastUpdateTimeBetween(
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

  public GoodsShelfRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsShelfRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public GoodsShelfRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public GoodsShelfRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public GoodsShelfRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public GoodsShelfRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsShelfRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public GoodsShelfRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsShelfRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public GoodsShelfRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsShelfRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsShelfRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public GoodsShelfRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public GoodsShelfRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public GoodsShelfRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public GoodsShelfRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public GoodsShelfRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public GoodsShelfRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public GoodsShelfRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public GoodsShelfRequest countVersion() {
    return countVersion("countVersion");
  }

  public GoodsShelfRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public GoodsShelfRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public GoodsShelfRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public GoodsShelfRequest minVersion() {
    return minVersion("minVersion");
  }

  public GoodsShelfRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public GoodsShelfRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public GoodsShelfRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public GoodsShelfRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public GoodsShelfRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public GoodsShelfRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public GoodsShelfRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public GoodsShelfRequest filterByStorageSpace(StorageSpaceRequest storageSpace) {
    return filterByStorageSpace(storageSpace, StorageSpace::getId);
  }

  public GoodsShelfRequest filterByStorageSpace(StorageSpace... storageSpace) {
    if (isEmptyParam(storageSpace)) {
      throw new IllegalArgumentException(
          "filterByStorageSpace(StorageSpace... storageSpace)参数不能为空!");
    }
    return where(STORAGE_SPACE_PROPERTY, QueryOperator.IN, (Object[]) storageSpace);
  }

  public GoodsShelfRequest selectStorageSpaceId() {
    select(STORAGE_SPACE_PROPERTY);
    return this;
  }

  public StorageSpaceRequest upToStorageSpace() {
    return upToStorageSpace(StorageSpaceRequest.newInstance());
  }

  public StorageSpaceRequest upToStorageSpace(StorageSpaceRequest storageSpace) {
    storageSpace.aggregateChild(STORAGE_SPACE_PROPERTY, this);
    this.groupByStorageSpace(storageSpace);
    return storageSpace;
  }

  public StorageSpaceRequest endAtStorageSpace(String retName) {
    return endAtStorageSpace(retName, StorageSpaceRequest.newInstance());
  }

  public StorageSpaceRequest endAtStorageSpace(String retName, StorageSpaceRequest storageSpace) {
    storageSpace.addDynamicProperty(retName, this, STORAGE_SPACE_PROPERTY);
    return storageSpace;
  }

  public GoodsShelfRequest filterByStorageSpace(String... storageSpace) {
    if (isEmptyParam(storageSpace)) {
      throw new IllegalArgumentException("filterByStorageSpace(String... storageSpace)参数不能为空!");
    }
    return where(STORAGE_SPACE_PROPERTY, QueryOperator.IN, (Object[]) storageSpace);
  }

  public GoodsShelfRequest filterByStorageSpace(
      StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine) {
    storageSpace.unlimited();
    return addSearchCriteria(createStorageSpaceCriteria(storageSpace, idRefine));
  }

  public SearchCriteria createStorageSpaceCriteria(
      StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine) {
    return new RefinedIdInCriteria(
        storageSpace, STORAGE_SPACE_PROPERTY, idRefine, StorageSpace.ID_PROPERTY);
  }

  public GoodsShelfRequest selectStorageSpace() {
    return selectStorageSpace(StorageSpaceRequest.newInstance().selectSelf());
  }

  public GoodsShelfRequest selectStorageSpace(StorageSpaceRequest storageSpace) {
    selectParent(STORAGE_SPACE_PROPERTY, storageSpace);
    return this;
  }

  public GoodsShelfRequest unselectStorageSpace() {
    unselectParent(STORAGE_SPACE_PROPERTY);
    return this;
  }

  public GoodsShelfRequest groupByStorageSpace(StorageSpaceRequest storageSpace) {
    groupBy(STORAGE_SPACE_PROPERTY, storageSpace);
    return this;
  }

  public GoodsShelfRequest aggregateStorageSpace(StorageSpaceRequest storageSpace) {
    aggregateParent(STORAGE_SPACE_PROPERTY, storageSpace);
    return this;
  }

  public GoodsShelfRequest countStorageSpace() {
    return countStorageSpace("countStorageSpace");
  }

  public GoodsShelfRequest countStorageSpace(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, STORAGE_SPACE_PROPERTY);
  }

  public GoodsShelfRequest groupByStorageSpace() {
    return groupByStorageSpace(STORAGE_SPACE_PROPERTY);
  }

  public GoodsShelfRequest groupByStorageSpace(String ret) {
    return groupBy(ret, STORAGE_SPACE_PROPERTY);
  }

  public GoodsShelfRequest whereStorageSpaceIsNull() {
    return where(STORAGE_SPACE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfRequest whereStorageSpaceIsNotNull() {
    return where(STORAGE_SPACE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfRequest filterBySupplierSpace(SupplierSpaceRequest supplierSpace) {
    return filterBySupplierSpace(supplierSpace, SupplierSpace::getId);
  }

  public GoodsShelfRequest filterBySupplierSpace(SupplierSpace... supplierSpace) {
    if (isEmptyParam(supplierSpace)) {
      throw new IllegalArgumentException(
          "filterBySupplierSpace(SupplierSpace... supplierSpace)参数不能为空!");
    }
    return where(SUPPLIER_SPACE_PROPERTY, QueryOperator.IN, (Object[]) supplierSpace);
  }

  public GoodsShelfRequest selectSupplierSpaceId() {
    select(SUPPLIER_SPACE_PROPERTY);
    return this;
  }

  public SupplierSpaceRequest upToSupplierSpace() {
    return upToSupplierSpace(SupplierSpaceRequest.newInstance());
  }

  public SupplierSpaceRequest upToSupplierSpace(SupplierSpaceRequest supplierSpace) {
    supplierSpace.aggregateChild(SUPPLIER_SPACE_PROPERTY, this);
    this.groupBySupplierSpace(supplierSpace);
    return supplierSpace;
  }

  public SupplierSpaceRequest endAtSupplierSpace(String retName) {
    return endAtSupplierSpace(retName, SupplierSpaceRequest.newInstance());
  }

  public SupplierSpaceRequest endAtSupplierSpace(
      String retName, SupplierSpaceRequest supplierSpace) {
    supplierSpace.addDynamicProperty(retName, this, SUPPLIER_SPACE_PROPERTY);
    return supplierSpace;
  }

  public GoodsShelfRequest filterBySupplierSpace(String... supplierSpace) {
    if (isEmptyParam(supplierSpace)) {
      throw new IllegalArgumentException("filterBySupplierSpace(String... supplierSpace)参数不能为空!");
    }
    return where(SUPPLIER_SPACE_PROPERTY, QueryOperator.IN, (Object[]) supplierSpace);
  }

  public GoodsShelfRequest filterBySupplierSpace(
      SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine) {
    supplierSpace.unlimited();
    return addSearchCriteria(createSupplierSpaceCriteria(supplierSpace, idRefine));
  }

  public SearchCriteria createSupplierSpaceCriteria(
      SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine) {
    return new RefinedIdInCriteria(
        supplierSpace, SUPPLIER_SPACE_PROPERTY, idRefine, SupplierSpace.ID_PROPERTY);
  }

  public GoodsShelfRequest selectSupplierSpace() {
    return selectSupplierSpace(SupplierSpaceRequest.newInstance().selectSelf());
  }

  public GoodsShelfRequest selectSupplierSpace(SupplierSpaceRequest supplierSpace) {
    selectParent(SUPPLIER_SPACE_PROPERTY, supplierSpace);
    return this;
  }

  public GoodsShelfRequest unselectSupplierSpace() {
    unselectParent(SUPPLIER_SPACE_PROPERTY);
    return this;
  }

  public GoodsShelfRequest groupBySupplierSpace(SupplierSpaceRequest supplierSpace) {
    groupBy(SUPPLIER_SPACE_PROPERTY, supplierSpace);
    return this;
  }

  public GoodsShelfRequest aggregateSupplierSpace(SupplierSpaceRequest supplierSpace) {
    aggregateParent(SUPPLIER_SPACE_PROPERTY, supplierSpace);
    return this;
  }

  public GoodsShelfRequest countSupplierSpace() {
    return countSupplierSpace("countSupplierSpace");
  }

  public GoodsShelfRequest countSupplierSpace(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SUPPLIER_SPACE_PROPERTY);
  }

  public GoodsShelfRequest groupBySupplierSpace() {
    return groupBySupplierSpace(SUPPLIER_SPACE_PROPERTY);
  }

  public GoodsShelfRequest groupBySupplierSpace(String ret) {
    return groupBy(ret, SUPPLIER_SPACE_PROPERTY);
  }

  public GoodsShelfRequest whereSupplierSpaceIsNull() {
    return where(SUPPLIER_SPACE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfRequest whereSupplierSpaceIsNotNull() {
    return where(SUPPLIER_SPACE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfRequest filterByDamageSpace(DamageSpaceRequest damageSpace) {
    return filterByDamageSpace(damageSpace, DamageSpace::getId);
  }

  public GoodsShelfRequest filterByDamageSpace(DamageSpace... damageSpace) {
    if (isEmptyParam(damageSpace)) {
      throw new IllegalArgumentException("filterByDamageSpace(DamageSpace... damageSpace)参数不能为空!");
    }
    return where(DAMAGE_SPACE_PROPERTY, QueryOperator.IN, (Object[]) damageSpace);
  }

  public GoodsShelfRequest selectDamageSpaceId() {
    select(DAMAGE_SPACE_PROPERTY);
    return this;
  }

  public DamageSpaceRequest upToDamageSpace() {
    return upToDamageSpace(DamageSpaceRequest.newInstance());
  }

  public DamageSpaceRequest upToDamageSpace(DamageSpaceRequest damageSpace) {
    damageSpace.aggregateChild(DAMAGE_SPACE_PROPERTY, this);
    this.groupByDamageSpace(damageSpace);
    return damageSpace;
  }

  public DamageSpaceRequest endAtDamageSpace(String retName) {
    return endAtDamageSpace(retName, DamageSpaceRequest.newInstance());
  }

  public DamageSpaceRequest endAtDamageSpace(String retName, DamageSpaceRequest damageSpace) {
    damageSpace.addDynamicProperty(retName, this, DAMAGE_SPACE_PROPERTY);
    return damageSpace;
  }

  public GoodsShelfRequest filterByDamageSpace(String... damageSpace) {
    if (isEmptyParam(damageSpace)) {
      throw new IllegalArgumentException("filterByDamageSpace(String... damageSpace)参数不能为空!");
    }
    return where(DAMAGE_SPACE_PROPERTY, QueryOperator.IN, (Object[]) damageSpace);
  }

  public GoodsShelfRequest filterByDamageSpace(
      DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine) {
    damageSpace.unlimited();
    return addSearchCriteria(createDamageSpaceCriteria(damageSpace, idRefine));
  }

  public SearchCriteria createDamageSpaceCriteria(
      DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine) {
    return new RefinedIdInCriteria(
        damageSpace, DAMAGE_SPACE_PROPERTY, idRefine, DamageSpace.ID_PROPERTY);
  }

  public GoodsShelfRequest selectDamageSpace() {
    return selectDamageSpace(DamageSpaceRequest.newInstance().selectSelf());
  }

  public GoodsShelfRequest selectDamageSpace(DamageSpaceRequest damageSpace) {
    selectParent(DAMAGE_SPACE_PROPERTY, damageSpace);
    return this;
  }

  public GoodsShelfRequest unselectDamageSpace() {
    unselectParent(DAMAGE_SPACE_PROPERTY);
    return this;
  }

  public GoodsShelfRequest groupByDamageSpace(DamageSpaceRequest damageSpace) {
    groupBy(DAMAGE_SPACE_PROPERTY, damageSpace);
    return this;
  }

  public GoodsShelfRequest aggregateDamageSpace(DamageSpaceRequest damageSpace) {
    aggregateParent(DAMAGE_SPACE_PROPERTY, damageSpace);
    return this;
  }

  public GoodsShelfRequest countDamageSpace() {
    return countDamageSpace("countDamageSpace");
  }

  public GoodsShelfRequest countDamageSpace(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DAMAGE_SPACE_PROPERTY);
  }

  public GoodsShelfRequest groupByDamageSpace() {
    return groupByDamageSpace(DAMAGE_SPACE_PROPERTY);
  }

  public GoodsShelfRequest groupByDamageSpace(String ret) {
    return groupBy(ret, DAMAGE_SPACE_PROPERTY);
  }

  public GoodsShelfRequest whereDamageSpaceIsNull() {
    return where(DAMAGE_SPACE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfRequest whereDamageSpaceIsNotNull() {
    return where(DAMAGE_SPACE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfRequest hasGoodsShelfStockCount() {
    return hasGoodsShelfStockCount(GoodsShelfStockCountRequest.newInstance());
  }

  public GoodsShelfRequest hasGoodsShelfStockCount(GoodsShelfStockCount... goodsShelfStockCount) {
    if (isEmptyParam(goodsShelfStockCount)) {
      throw new IllegalArgumentException(
          "hasGoodsShelfStockCount(GoodsShelfStockCount... goodsShelfStockCount)参数不能为空!");
    }
    return hasGoodsShelfStockCount(
        Q.goodsShelfStockCount()
            .select(GoodsShelfStockCount.SHELF_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goodsShelfStockCount));
  }

  public GoodsShelfRequest hasGoodsShelfStockCount(String... goodsShelfStockCount) {
    return hasGoodsShelfStockCount(
        Q.goodsShelfStockCount()
            .select(GoodsShelfStockCount.SHELF_PROPERTY)
            .filterById(goodsShelfStockCount));
  }

  public GoodsShelfRequest hasGoodsShelfStockCount(
      GoodsShelfStockCountRequest goodsShelfStockCount) {
    return hasGoodsShelfStockCount(
        goodsShelfStockCount,
        $goodsShelfStockCount ->
            java.util.Optional.of($goodsShelfStockCount)
                .map(GoodsShelfStockCount::getShelf)
                .map(GoodsShelf::getId)
                .orElse(null));
  }

  public GoodsShelfRequest hasGoodsShelfStockCount(
      GoodsShelfStockCountRequest goodsShelfStockCount, IDRefine<GoodsShelfStockCount> idRefine) {
    goodsShelfStockCount.select(GoodsShelfStockCount.SHELF_PROPERTY);
    goodsShelfStockCount.unlimited();
    return addSearchCriteria(createGoodsShelfStockCountCriteria(goodsShelfStockCount, idRefine));
  }

  public GoodsShelfRequest hasGoodsShelfStockCount(
      GoodsShelfStockCountRequest goodsShelfStockCount, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            goodsShelfStockCount, GoodsShelfStockCount.SHELF_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsShelfStockCountCriteria(
      GoodsShelfStockCountRequest goodsShelfStockCount, IDRefine<GoodsShelfStockCount> idRefine) {
    return new RefinedIdInCriteria(
        goodsShelfStockCount, ID_PROPERTY, idRefine, GoodsShelfStockCount.SHELF_PROPERTY);
  }

  public GoodsShelfRequest selectGoodsShelfStockCountList(
      GoodsShelfStockCountRequest goodsShelfStockCount) {
    selectChild(GoodsShelfStockCount.SHELF_PROPERTY, goodsShelfStockCount);
    return this;
  }

  public GoodsShelfRequest selectGoodsShelfStockCountList() {
    return selectGoodsShelfStockCountList(GoodsShelfStockCountRequest.newInstance().selectAll());
  }

  public GoodsShelfRequest unselectGoodsShelfStockCountList() {
    unselectChild(GoodsShelfStockCount.SHELF_PROPERTY, GoodsShelfStockCount.class);
    return this;
  }

  public GoodsShelfRequest hasGoodsAllocation() {
    return hasGoodsAllocation(GoodsAllocationRequest.newInstance());
  }

  public GoodsShelfRequest hasGoodsAllocation(GoodsAllocation... goodsAllocation) {
    if (isEmptyParam(goodsAllocation)) {
      throw new IllegalArgumentException(
          "hasGoodsAllocation(GoodsAllocation... goodsAllocation)参数不能为空!");
    }
    return hasGoodsAllocation(
        Q.goodsAllocation()
            .select(GoodsAllocation.GOODS_SHELF_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goodsAllocation));
  }

  public GoodsShelfRequest hasGoodsAllocation(String... goodsAllocation) {
    return hasGoodsAllocation(
        Q.goodsAllocation()
            .select(GoodsAllocation.GOODS_SHELF_PROPERTY)
            .filterById(goodsAllocation));
  }

  public GoodsShelfRequest hasGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
    return hasGoodsAllocation(
        goodsAllocation,
        $goodsAllocation ->
            java.util.Optional.of($goodsAllocation)
                .map(GoodsAllocation::getGoodsShelf)
                .map(GoodsShelf::getId)
                .orElse(null));
  }

  public GoodsShelfRequest hasGoodsAllocation(
      GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine) {
    goodsAllocation.select(GoodsAllocation.GOODS_SHELF_PROPERTY);
    goodsAllocation.unlimited();
    return addSearchCriteria(createGoodsAllocationCriteria(goodsAllocation, idRefine));
  }

  public GoodsShelfRequest hasGoodsAllocation(
      GoodsAllocationRequest goodsAllocation, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            goodsAllocation, GoodsAllocation.GOODS_SHELF_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsAllocationCriteria(
      GoodsAllocationRequest goodsAllocation, IDRefine<GoodsAllocation> idRefine) {
    return new RefinedIdInCriteria(
        goodsAllocation, ID_PROPERTY, idRefine, GoodsAllocation.GOODS_SHELF_PROPERTY);
  }

  public GoodsShelfRequest selectGoodsAllocationList(GoodsAllocationRequest goodsAllocation) {
    selectChild(GoodsAllocation.GOODS_SHELF_PROPERTY, goodsAllocation);
    return this;
  }

  public GoodsShelfRequest selectGoodsAllocationList() {
    return selectGoodsAllocationList(GoodsAllocationRequest.newInstance().selectAll());
  }

  public GoodsShelfRequest unselectGoodsAllocationList() {
    unselectChild(GoodsAllocation.GOODS_SHELF_PROPERTY, GoodsAllocation.class);
    return this;
  }

  public GoodsShelfRequest aggregateGoodsShelfStockCountList(
      GoodsShelfStockCountRequest goodsShelfStockCount) {
    aggregateChild(GoodsShelfStockCount.SHELF_PROPERTY, goodsShelfStockCount);
    return this;
  }

  public GoodsShelfRequest countGoodsShelfStockCount() {
    return countGoodsShelfStockCount("goodsShelfStockCountCount");
  }

  public GoodsShelfRequest countGoodsShelfStockCount(String retName) {
    return countGoodsShelfStockCount(retName, GoodsShelfStockCountRequest.newInstance());
  }

  public GoodsShelfRequest countGoodsShelfStockCount(
      GoodsShelfStockCountRequest goodsShelfStockCount) {
    return countGoodsShelfStockCount("goodsShelfStockCountCount", goodsShelfStockCount);
  }

  public GoodsShelfRequest countGoodsShelfStockCount(
      String retName, GoodsShelfStockCountRequest goodsShelfStockCount) {
    goodsShelfStockCount.count();
    return statsFromGoodsShelfStockCount(retName, goodsShelfStockCount);
  }

  public GoodsShelfRequest statsFromGoodsShelfStockCount(
      String retName, GoodsShelfStockCountRequest goodsShelfStockCount) {
    return addDynamicProperty(retName, goodsShelfStockCount, GoodsShelfStockCount.SHELF_PROPERTY);
  }

  public GoodsShelfRequest aggregateGoodsAllocationList(GoodsAllocationRequest goodsAllocation) {
    aggregateChild(GoodsAllocation.GOODS_SHELF_PROPERTY, goodsAllocation);
    return this;
  }

  public GoodsShelfRequest countGoodsAllocation() {
    return countGoodsAllocation("goodsAllocationCount");
  }

  public GoodsShelfRequest countGoodsAllocation(String retName) {
    return countGoodsAllocation(retName, GoodsAllocationRequest.newInstance());
  }

  public GoodsShelfRequest countGoodsAllocation(GoodsAllocationRequest goodsAllocation) {
    return countGoodsAllocation("goodsAllocationCount", goodsAllocation);
  }

  public GoodsShelfRequest countGoodsAllocation(
      String retName, GoodsAllocationRequest goodsAllocation) {
    goodsAllocation.count();
    return statsFromGoodsAllocation(retName, goodsAllocation);
  }

  public GoodsShelfRequest statsFromGoodsAllocation(
      String retName, GoodsAllocationRequest goodsAllocation) {
    return addDynamicProperty(retName, goodsAllocation, GoodsAllocation.GOODS_SHELF_PROPERTY);
  }

  public GoodsShelfRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public GoodsShelfRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public GoodsShelfRequest unlimited() {
    super.unlimited();
    return this;
  }

  public GoodsShelfRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
