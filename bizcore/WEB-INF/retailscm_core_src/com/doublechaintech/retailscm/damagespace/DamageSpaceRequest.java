package com.doublechaintech.retailscm.damagespace;

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
import static com.doublechaintech.retailscm.damagespace.DamageSpace.*;

public class DamageSpaceRequest extends BaseRequest<DamageSpace> {
  public static DamageSpaceRequest newInstance() {
    return new DamageSpaceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public DamageSpaceRequest resultByClass(Class<? extends DamageSpace> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public DamageSpaceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public DamageSpaceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "DamageSpace";
  }

  public DamageSpaceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public DamageSpaceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public DamageSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public DamageSpaceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public DamageSpaceRequest selectAll() {
    return this.selectId()
        .selectLocation()
        .selectContactNumber()
        .selectTotalArea()
        .selectLatitude()
        .selectLongitude()
        .selectWarehouse()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public DamageSpaceRequest selectAny() {
    return selectAll().selectGoodsShelfList(Q.goodsShelf().selectSelf());
  }

  public DamageSpaceRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(TOTAL_AREA_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(WAREHOUSE_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public DamageSpaceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public DamageSpaceRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
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
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
    WAREHOUSE_PROPERTY,
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

  public DamageSpaceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public DamageSpaceRequest comment(String comment) {
    return this;
  }

  public DamageSpaceRequest enhance() {
    return this;
  }

  public DamageSpaceRequest overrideClass(Class<? extends DamageSpace> clazz) {
    return this;
  }

  public DamageSpaceRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public DamageSpaceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public DamageSpaceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public DamageSpaceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public DamageSpaceRequest count() {
    return countId("count");
  }

  public static DamageSpaceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public DamageSpaceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public DamageSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public DamageSpaceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public DamageSpaceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public DamageSpaceRequest countId() {
    return countId("countId");
  }

  public DamageSpaceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public DamageSpaceRequest maxId() {
    return maxId("maxId");
  }

  public DamageSpaceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public DamageSpaceRequest minId() {
    return minId("minId");
  }

  public DamageSpaceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public DamageSpaceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public DamageSpaceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public DamageSpaceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public DamageSpaceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public DamageSpaceRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public DamageSpaceRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public DamageSpaceRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public DamageSpaceRequest countLocation() {
    return countLocation("countLocation");
  }

  public DamageSpaceRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public DamageSpaceRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public DamageSpaceRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public DamageSpaceRequest minLocation() {
    return minLocation("minLocation");
  }

  public DamageSpaceRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public DamageSpaceRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public DamageSpaceRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public DamageSpaceRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public DamageSpaceRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public DamageSpaceRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public DamageSpaceRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public DamageSpaceRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public DamageSpaceRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public DamageSpaceRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public DamageSpaceRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public DamageSpaceRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public DamageSpaceRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public DamageSpaceRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public DamageSpaceRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public DamageSpaceRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public DamageSpaceRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public DamageSpaceRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByTotalArea(String totalArea) {

    if (totalArea == null) {
      return this;
    }

    return filterByTotalArea(QueryOperator.EQUAL, totalArea);
  }

  public DamageSpaceRequest whereTotalAreaIsNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereTotalAreaIsNotNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectTotalArea() {
    return select(TOTAL_AREA_PROPERTY);
  }

  public DamageSpaceRequest unselectTotalArea() {
    return unselect(TOTAL_AREA_PROPERTY);
  }

  public SearchCriteria getTotalAreaSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderByTotalArea(boolean asc) {
    addOrderBy(TOTAL_AREA_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByTotalAreaAscending() {
    addOrderBy(TOTAL_AREA_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByTotalAreaDescending() {
    addOrderBy(TOTAL_AREA_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest orderByTotalAreaAscendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", true);
    return this;
  }

  public DamageSpaceRequest orderByTotalAreaDescendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", false);
    return this;
  }

  public DamageSpaceRequest countTotalArea() {
    return countTotalArea("countTotalArea");
  }

  public DamageSpaceRequest countTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AREA_PROPERTY);
  }

  public DamageSpaceRequest maxTotalArea() {
    return maxTotalArea("maxTotalArea");
  }

  public DamageSpaceRequest maxTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AREA_PROPERTY);
  }

  public DamageSpaceRequest minTotalArea() {
    return minTotalArea("minTotalArea");
  }

  public DamageSpaceRequest minTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AREA_PROPERTY);
  }

  public DamageSpaceRequest groupByTotalArea() {
    return groupByTotalArea(TOTAL_AREA_PROPERTY);
  }

  public DamageSpaceRequest groupByTotalArea(String ret) {
    return groupBy(ret, TOTAL_AREA_PROPERTY);
  }

  public DamageSpaceRequest groupByTotalArea(SqlFunction func) {
    return groupByTotalArea(TOTAL_AREA_PROPERTY, func);
  }

  public DamageSpaceRequest groupByTotalArea(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AREA_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public DamageSpaceRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest whereLatitudeBetween(BigDecimal latitudeStart, BigDecimal latitudeEnd) {
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

  public DamageSpaceRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public DamageSpaceRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public DamageSpaceRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public DamageSpaceRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public DamageSpaceRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public DamageSpaceRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public DamageSpaceRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public DamageSpaceRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public DamageSpaceRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public DamageSpaceRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public DamageSpaceRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public DamageSpaceRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public DamageSpaceRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public DamageSpaceRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest whereLongitudeBetween(
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

  public DamageSpaceRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public DamageSpaceRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public DamageSpaceRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public DamageSpaceRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public DamageSpaceRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public DamageSpaceRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public DamageSpaceRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public DamageSpaceRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public DamageSpaceRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public DamageSpaceRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public DamageSpaceRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public DamageSpaceRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public DamageSpaceRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public DamageSpaceRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest whereLastUpdateTimeBetween(
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

  public DamageSpaceRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public DamageSpaceRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public DamageSpaceRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public DamageSpaceRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public DamageSpaceRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public DamageSpaceRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public DamageSpaceRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public DamageSpaceRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public DamageSpaceRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public DamageSpaceRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public DamageSpaceRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public DamageSpaceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public DamageSpaceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public DamageSpaceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public DamageSpaceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public DamageSpaceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public DamageSpaceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public DamageSpaceRequest countVersion() {
    return countVersion("countVersion");
  }

  public DamageSpaceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public DamageSpaceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public DamageSpaceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public DamageSpaceRequest minVersion() {
    return minVersion("minVersion");
  }

  public DamageSpaceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public DamageSpaceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public DamageSpaceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public DamageSpaceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public DamageSpaceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public DamageSpaceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public DamageSpaceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public DamageSpaceRequest filterByWarehouse(WarehouseRequest warehouse) {
    return filterByWarehouse(warehouse, Warehouse::getId);
  }

  public DamageSpaceRequest filterByWarehouse(Warehouse... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(Warehouse... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public DamageSpaceRequest selectWarehouseId() {
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

  public DamageSpaceRequest filterByWarehouse(String... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(String... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public DamageSpaceRequest filterByWarehouse(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    warehouse.unlimited();
    return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
  }

  public SearchCriteria createWarehouseCriteria(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine, Warehouse.ID_PROPERTY);
  }

  public DamageSpaceRequest selectWarehouse() {
    return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
  }

  public DamageSpaceRequest selectWarehouse(WarehouseRequest warehouse) {
    selectParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public DamageSpaceRequest unselectWarehouse() {
    unselectParent(WAREHOUSE_PROPERTY);
    return this;
  }

  public DamageSpaceRequest groupByWarehouse(WarehouseRequest warehouse) {
    groupBy(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public DamageSpaceRequest aggregateWarehouse(WarehouseRequest warehouse) {
    aggregateParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public DamageSpaceRequest countWarehouse() {
    return countWarehouse("countWarehouse");
  }

  public DamageSpaceRequest countWarehouse(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WAREHOUSE_PROPERTY);
  }

  public DamageSpaceRequest groupByWarehouse() {
    return groupByWarehouse(WAREHOUSE_PROPERTY);
  }

  public DamageSpaceRequest groupByWarehouse(String ret) {
    return groupBy(ret, WAREHOUSE_PROPERTY);
  }

  public DamageSpaceRequest whereWarehouseIsNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NULL);
  }

  public DamageSpaceRequest whereWarehouseIsNotNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public DamageSpaceRequest hasGoodsShelf() {
    return hasGoodsShelf(GoodsShelfRequest.newInstance());
  }

  public DamageSpaceRequest hasGoodsShelf(GoodsShelf... goodsShelf) {
    if (isEmptyParam(goodsShelf)) {
      throw new IllegalArgumentException("hasGoodsShelf(GoodsShelf... goodsShelf)参数不能为空!");
    }
    return hasGoodsShelf(
        Q.goodsShelf()
            .select(GoodsShelf.DAMAGE_SPACE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goodsShelf));
  }

  public DamageSpaceRequest hasGoodsShelf(String... goodsShelf) {
    return hasGoodsShelf(
        Q.goodsShelf().select(GoodsShelf.DAMAGE_SPACE_PROPERTY).filterById(goodsShelf));
  }

  public DamageSpaceRequest hasGoodsShelf(GoodsShelfRequest goodsShelf) {
    return hasGoodsShelf(
        goodsShelf,
        $goodsShelf ->
            java.util.Optional.of($goodsShelf)
                .map(GoodsShelf::getDamageSpace)
                .map(DamageSpace::getId)
                .orElse(null));
  }

  public DamageSpaceRequest hasGoodsShelf(
      GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
    goodsShelf.select(GoodsShelf.DAMAGE_SPACE_PROPERTY);
    goodsShelf.unlimited();
    return addSearchCriteria(createGoodsShelfCriteria(goodsShelf, idRefine));
  }

  public DamageSpaceRequest hasGoodsShelf(
      GoodsShelfRequest goodsShelf, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            goodsShelf, GoodsShelf.DAMAGE_SPACE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsShelfCriteria(
      GoodsShelfRequest goodsShelf, IDRefine<GoodsShelf> idRefine) {
    return new RefinedIdInCriteria(
        goodsShelf, ID_PROPERTY, idRefine, GoodsShelf.DAMAGE_SPACE_PROPERTY);
  }

  public DamageSpaceRequest selectGoodsShelfList(GoodsShelfRequest goodsShelf) {
    selectChild(GoodsShelf.DAMAGE_SPACE_PROPERTY, goodsShelf);
    return this;
  }

  public DamageSpaceRequest selectGoodsShelfList() {
    return selectGoodsShelfList(GoodsShelfRequest.newInstance().selectAll());
  }

  public DamageSpaceRequest unselectGoodsShelfList() {
    unselectChild(GoodsShelf.DAMAGE_SPACE_PROPERTY, GoodsShelf.class);
    return this;
  }

  public DamageSpaceRequest aggregateGoodsShelfList(GoodsShelfRequest goodsShelf) {
    aggregateChild(GoodsShelf.DAMAGE_SPACE_PROPERTY, goodsShelf);
    return this;
  }

  public DamageSpaceRequest countGoodsShelf() {
    return countGoodsShelf("goodsShelfCount");
  }

  public DamageSpaceRequest countGoodsShelf(String retName) {
    return countGoodsShelf(retName, GoodsShelfRequest.newInstance());
  }

  public DamageSpaceRequest countGoodsShelf(GoodsShelfRequest goodsShelf) {
    return countGoodsShelf("goodsShelfCount", goodsShelf);
  }

  public DamageSpaceRequest countGoodsShelf(String retName, GoodsShelfRequest goodsShelf) {
    goodsShelf.count();
    return statsFromGoodsShelf(retName, goodsShelf);
  }

  public DamageSpaceRequest statsFromGoodsShelf(String retName, GoodsShelfRequest goodsShelf) {
    return addDynamicProperty(retName, goodsShelf, GoodsShelf.DAMAGE_SPACE_PROPERTY);
  }

  public DamageSpaceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public DamageSpaceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public DamageSpaceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public DamageSpaceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
