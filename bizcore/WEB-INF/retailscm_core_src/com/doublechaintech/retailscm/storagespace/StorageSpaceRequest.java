package com.doublechaintech.retailscm.storagespace;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.storagespace.StorageSpace.*;

public class StorageSpaceRequest extends BaseRequest<StorageSpace> {
  public static StorageSpaceRequest newInstance() {
    return new StorageSpaceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public StorageSpaceRequest resultByClass(Class<? extends StorageSpace> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public StorageSpaceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public StorageSpaceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "StorageSpace";
  }

  public StorageSpaceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public StorageSpaceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public StorageSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public StorageSpaceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public StorageSpaceRequest selectAll() {
    return this.selectId()
        .selectLocation()
        .selectContactNumber()
        .selectTotalArea()
        .selectWarehouse()
        .selectLatitude()
        .selectLongitude()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public StorageSpaceRequest selectAny() {
    return selectAll().selectGoodsShelfList(Q.goodsShelf().selectSelf());
  }

  public StorageSpaceRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(TOTAL_AREA_PROPERTY);
    select(WAREHOUSE_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public StorageSpaceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public StorageSpaceRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    LOCATION_PROPERTY,
    CONTACT_NUMBER_PROPERTY,
    TOTAL_AREA_PROPERTY,
    WAREHOUSE_PROPERTY,
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
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

  public StorageSpaceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public StorageSpaceRequest comment(String comment) {
    return this;
  }

  public StorageSpaceRequest enhance() {
    return this;
  }

  public StorageSpaceRequest overrideClass(Class<? extends StorageSpace> clazz) {
    return this;
  }

  public StorageSpaceRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public StorageSpaceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public StorageSpaceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public StorageSpaceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public StorageSpaceRequest count() {
    return countId("count");
  }

  public static StorageSpaceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public StorageSpaceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public StorageSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public StorageSpaceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public StorageSpaceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public StorageSpaceRequest countId() {
    return countId("countId");
  }

  public StorageSpaceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public StorageSpaceRequest maxId() {
    return maxId("maxId");
  }

  public StorageSpaceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public StorageSpaceRequest minId() {
    return minId("minId");
  }

  public StorageSpaceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public StorageSpaceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public StorageSpaceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public StorageSpaceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public StorageSpaceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public StorageSpaceRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public StorageSpaceRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public StorageSpaceRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public StorageSpaceRequest countLocation() {
    return countLocation("countLocation");
  }

  public StorageSpaceRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public StorageSpaceRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public StorageSpaceRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public StorageSpaceRequest minLocation() {
    return minLocation("minLocation");
  }

  public StorageSpaceRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public StorageSpaceRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public StorageSpaceRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public StorageSpaceRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public StorageSpaceRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public StorageSpaceRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public StorageSpaceRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public StorageSpaceRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public StorageSpaceRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public StorageSpaceRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public StorageSpaceRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public StorageSpaceRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public StorageSpaceRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public StorageSpaceRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public StorageSpaceRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public StorageSpaceRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public StorageSpaceRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public StorageSpaceRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByTotalArea(String totalArea) {

    if (totalArea == null) {
      return this;
    }

    return filterByTotalArea(QueryOperator.EQUAL, totalArea);
  }

  public StorageSpaceRequest whereTotalAreaIsNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereTotalAreaIsNotNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectTotalArea() {
    return select(TOTAL_AREA_PROPERTY);
  }

  public StorageSpaceRequest unselectTotalArea() {
    return unselect(TOTAL_AREA_PROPERTY);
  }

  public SearchCriteria getTotalAreaSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderByTotalArea(boolean asc) {
    addOrderBy(TOTAL_AREA_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByTotalAreaAscending() {
    addOrderBy(TOTAL_AREA_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByTotalAreaDescending() {
    addOrderBy(TOTAL_AREA_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest orderByTotalAreaAscendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", true);
    return this;
  }

  public StorageSpaceRequest orderByTotalAreaDescendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", false);
    return this;
  }

  public StorageSpaceRequest countTotalArea() {
    return countTotalArea("countTotalArea");
  }

  public StorageSpaceRequest countTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AREA_PROPERTY);
  }

  public StorageSpaceRequest maxTotalArea() {
    return maxTotalArea("maxTotalArea");
  }

  public StorageSpaceRequest maxTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AREA_PROPERTY);
  }

  public StorageSpaceRequest minTotalArea() {
    return minTotalArea("minTotalArea");
  }

  public StorageSpaceRequest minTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AREA_PROPERTY);
  }

  public StorageSpaceRequest groupByTotalArea() {
    return groupByTotalArea(TOTAL_AREA_PROPERTY);
  }

  public StorageSpaceRequest groupByTotalArea(String ret) {
    return groupBy(ret, TOTAL_AREA_PROPERTY);
  }

  public StorageSpaceRequest groupByTotalArea(SqlFunction func) {
    return groupByTotalArea(TOTAL_AREA_PROPERTY, func);
  }

  public StorageSpaceRequest groupByTotalArea(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AREA_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public StorageSpaceRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest whereLatitudeBetween(
      BigDecimal latitudeStart, BigDecimal latitudeEnd) {
    if (ObjectUtil.isEmpty(latitudeStart)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeBetween, the parameter latitudeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(latitudeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeBetween, the parameter latitudeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.BETWEEN, new Object[] {latitudeStart, latitudeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public StorageSpaceRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public StorageSpaceRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public StorageSpaceRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public StorageSpaceRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public StorageSpaceRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public StorageSpaceRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public StorageSpaceRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public StorageSpaceRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public StorageSpaceRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public StorageSpaceRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public StorageSpaceRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public StorageSpaceRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public StorageSpaceRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest whereLongitudeBetween(
      BigDecimal longitudeStart, BigDecimal longitudeEnd) {
    if (ObjectUtil.isEmpty(longitudeStart)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeBetween, the parameter longitudeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(longitudeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeBetween, the parameter longitudeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {longitudeStart, longitudeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public StorageSpaceRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public StorageSpaceRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public StorageSpaceRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public StorageSpaceRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public StorageSpaceRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public StorageSpaceRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public StorageSpaceRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public StorageSpaceRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public StorageSpaceRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public StorageSpaceRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public StorageSpaceRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public StorageSpaceRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public StorageSpaceRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest whereLastUpdateTimeBetween(
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

  public StorageSpaceRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public StorageSpaceRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public StorageSpaceRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public StorageSpaceRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public StorageSpaceRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public StorageSpaceRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public StorageSpaceRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public StorageSpaceRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public StorageSpaceRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public StorageSpaceRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public StorageSpaceRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public StorageSpaceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StorageSpaceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public StorageSpaceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StorageSpaceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public StorageSpaceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public StorageSpaceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public StorageSpaceRequest countVersion() {
    return countVersion("countVersion");
  }

  public StorageSpaceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public StorageSpaceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public StorageSpaceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public StorageSpaceRequest minVersion() {
    return minVersion("minVersion");
  }

  public StorageSpaceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public StorageSpaceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public StorageSpaceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public StorageSpaceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public StorageSpaceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public StorageSpaceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public StorageSpaceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public StorageSpaceRequest filterByWarehouse(WarehouseRequest warehouse) {
    return filterByWarehouse(warehouse, Warehouse::getId);
  }

  public StorageSpaceRequest filterByWarehouse(Warehouse... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(Warehouse... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public StorageSpaceRequest selectWarehouseId() {
    select(WAREHOUSE_PROPERTY);
    return this;
  }

  public WarehouseRequest upToWarehouse() {
    return upToWarehouse(WarehouseRequest.newInstance());
  }

  public WarehouseRequest upToWarehouse(WarehouseRequest warehouse) {
    warehouse.aggregateChild(WAREHOUSE_PROPERTY, this);
    this.groupByWarehouse(warehouse);
    return warehouse;
  }

  public WarehouseRequest endAtWarehouse(String retName) {
    return endAtWarehouse(retName, WarehouseRequest.newInstance());
  }

  public WarehouseRequest endAtWarehouse(String retName, WarehouseRequest warehouse) {
    warehouse.addDynamicProperty(retName, this, WAREHOUSE_PROPERTY);
    return warehouse;
  }

  public StorageSpaceRequest filterByWarehouse(String... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(String... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public StorageSpaceRequest filterByWarehouse(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    warehouse.unlimited();
    return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
  }

  public SearchCriteria createWarehouseCriteria(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine, Warehouse.ID_PROPERTY);
  }

  public StorageSpaceRequest selectWarehouse() {
    return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
  }

  public StorageSpaceRequest selectWarehouse(WarehouseRequest warehouse) {
    selectParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public StorageSpaceRequest unselectWarehouse() {
    unselectParent(WAREHOUSE_PROPERTY);
    return this;
  }

  public StorageSpaceRequest groupByWarehouse(WarehouseRequest warehouse) {
    groupBy(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public StorageSpaceRequest aggregateWarehouse(WarehouseRequest warehouse) {
    aggregateParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public StorageSpaceRequest countWarehouse() {
    return countWarehouse("countWarehouse");
  }

  public StorageSpaceRequest countWarehouse(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WAREHOUSE_PROPERTY);
  }

  public StorageSpaceRequest groupByWarehouse() {
    return groupByWarehouse(WAREHOUSE_PROPERTY);
  }

  public StorageSpaceRequest groupByWarehouse(String ret) {
    return groupBy(ret, WAREHOUSE_PROPERTY);
  }

  public StorageSpaceRequest whereWarehouseIsNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NULL);
  }

  public StorageSpaceRequest whereWarehouseIsNotNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StorageSpaceRequest hasGoodsShelf() {
    return hasGoodsShelf(GoodsShelfRequest.newInstance());
  }

  public StorageSpaceRequest hasGoodsShelf(GoodsShelf... goodsShelf) {
    if (isEmptyParam(goodsShelf)) {
      throw new IllegalArgumentException("hasGoodsShelf(GoodsShelf... goodsShelf)参数不能为空!");
    }
    return hasGoodsShelf(
        Q.goodsShelf()
            .select(GoodsShelf.STORAGE_SPACE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goodsShelf));
  }

  public StorageSpaceRequest hasGoodsShelf(String... goodsShelf) {
    return hasGoodsShelf(
        Q.goodsShelf().select(GoodsShelf.STORAGE_SPACE_PROPERTY).filterById(goodsShelf));
  }

  public StorageSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf) {
    return hasGoodsShelf(
        goodsShelf,
        $goodsShelf ->
            java.util.Optional.of($goodsShelf)
                .map(GoodsShelf::getStorageSpace)
                .map(StorageSpace::getId)
                .orElse(null));
  }

  public StorageSpaceRequest hasGoodsShelf(
      GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
    goodsShelf.select(GoodsShelf.STORAGE_SPACE_PROPERTY);
    goodsShelf.unlimited();
    return addSearchCriteria(createGoodsShelfCriteria(goodsShelf, idRefine));
  }

  public StorageSpaceRequest hasGoodsShelf(
      GoodsShelfRequest goodsShelf, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            goodsShelf, GoodsShelf.STORAGE_SPACE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsShelfCriteria(
      GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
    return new RefinedIdInCriteria(
        goodsShelf, ID_PROPERTY, idRefine, GoodsShelf.STORAGE_SPACE_PROPERTY);
  }

  public StorageSpaceRequest selectGoodsShelfList(GoodsShelfRequest goodsShelf) {
    selectChild(GoodsShelf.STORAGE_SPACE_PROPERTY, goodsShelf);
    return this;
  }

  public StorageSpaceRequest selectGoodsShelfList() {
    return selectGoodsShelfList(GoodsShelfRequest.newInstance().selectAll());
  }

  public StorageSpaceRequest unselectGoodsShelfList() {
    unselectChild(GoodsShelf.STORAGE_SPACE_PROPERTY, GoodsShelf.class);
    return this;
  }

  public StorageSpaceRequest aggregateGoodsShelfList(GoodsShelfRequest goodsShelf) {
    aggregateChild(GoodsShelf.STORAGE_SPACE_PROPERTY, goodsShelf);
    return this;
  }

  public StorageSpaceRequest countGoodsShelf() {
    return countGoodsShelf("goodsShelfCount");
  }

  public StorageSpaceRequest countGoodsShelf(String retName) {
    return countGoodsShelf(retName, GoodsShelfRequest.newInstance());
  }

  public StorageSpaceRequest countGoodsShelf(GoodsShelfRequest goodsShelf) {
    return countGoodsShelf("goodsShelfCount", goodsShelf);
  }

  public StorageSpaceRequest countGoodsShelf(String retName, GoodsShelfRequest goodsShelf) {
    goodsShelf.count();
    return statsFromGoodsShelf(retName, goodsShelf);
  }

  public StorageSpaceRequest statsFromGoodsShelf(String retName, GoodsShelfRequest goodsShelf) {
    return addDynamicProperty(retName, goodsShelf, GoodsShelf.STORAGE_SPACE_PROPERTY);
  }

  public StorageSpaceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public StorageSpaceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public StorageSpaceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public StorageSpaceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
