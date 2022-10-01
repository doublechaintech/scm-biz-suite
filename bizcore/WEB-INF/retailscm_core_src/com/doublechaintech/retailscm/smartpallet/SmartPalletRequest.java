package com.doublechaintech.retailscm.smartpallet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.smartpallet.SmartPallet.*;

public class SmartPalletRequest extends BaseRequest<SmartPallet> {
  public static SmartPalletRequest newInstance() {
    return new SmartPalletRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SmartPalletRequest resultByClass(Class<? extends SmartPallet> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SmartPalletRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SmartPalletRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SmartPallet";
  }

  public SmartPalletRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SmartPalletRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SmartPalletRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SmartPalletRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SmartPalletRequest selectAll() {
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

  public SmartPalletRequest selectAny() {
    return selectAll().selectGoodsList(Q.goods().selectSelf());
  }

  public SmartPalletRequest selectSelf() {
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

  public SmartPalletRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SmartPalletRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
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

  public SmartPalletRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SmartPalletRequest comment(String comment) {
    return this;
  }

  public SmartPalletRequest enhance() {
    return this;
  }

  public SmartPalletRequest overrideClass(Class<? extends SmartPallet> clazz) {
    return this;
  }

  public SmartPalletRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SmartPalletRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SmartPalletRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SmartPalletRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SmartPalletRequest count() {
    return countId("count");
  }

  public static SmartPalletRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SmartPalletRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SmartPalletRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SmartPalletRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SmartPalletRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SmartPalletRequest countId() {
    return countId("countId");
  }

  public SmartPalletRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SmartPalletRequest maxId() {
    return maxId("maxId");
  }

  public SmartPalletRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SmartPalletRequest minId() {
    return minId("minId");
  }

  public SmartPalletRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SmartPalletRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SmartPalletRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SmartPalletRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SmartPalletRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public SmartPalletRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public SmartPalletRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public SmartPalletRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public SmartPalletRequest countLocation() {
    return countLocation("countLocation");
  }

  public SmartPalletRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public SmartPalletRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public SmartPalletRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public SmartPalletRequest minLocation() {
    return minLocation("minLocation");
  }

  public SmartPalletRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public SmartPalletRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public SmartPalletRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public SmartPalletRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public SmartPalletRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public SmartPalletRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public SmartPalletRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public SmartPalletRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public SmartPalletRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public SmartPalletRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public SmartPalletRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public SmartPalletRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public SmartPalletRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public SmartPalletRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public SmartPalletRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public SmartPalletRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public SmartPalletRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public SmartPalletRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByTotalArea(String totalArea) {

    if (totalArea == null) {
      return this;
    }

    return filterByTotalArea(QueryOperator.EQUAL, totalArea);
  }

  public SmartPalletRequest whereTotalAreaIsNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereTotalAreaIsNotNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectTotalArea() {
    return select(TOTAL_AREA_PROPERTY);
  }

  public SmartPalletRequest unselectTotalArea() {
    return unselect(TOTAL_AREA_PROPERTY);
  }

  public SearchCriteria getTotalAreaSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderByTotalArea(boolean asc) {
    addOrderBy(TOTAL_AREA_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByTotalAreaAscending() {
    addOrderBy(TOTAL_AREA_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByTotalAreaDescending() {
    addOrderBy(TOTAL_AREA_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest orderByTotalAreaAscendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", true);
    return this;
  }

  public SmartPalletRequest orderByTotalAreaDescendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", false);
    return this;
  }

  public SmartPalletRequest countTotalArea() {
    return countTotalArea("countTotalArea");
  }

  public SmartPalletRequest countTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AREA_PROPERTY);
  }

  public SmartPalletRequest maxTotalArea() {
    return maxTotalArea("maxTotalArea");
  }

  public SmartPalletRequest maxTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AREA_PROPERTY);
  }

  public SmartPalletRequest minTotalArea() {
    return minTotalArea("minTotalArea");
  }

  public SmartPalletRequest minTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AREA_PROPERTY);
  }

  public SmartPalletRequest groupByTotalArea() {
    return groupByTotalArea(TOTAL_AREA_PROPERTY);
  }

  public SmartPalletRequest groupByTotalArea(String ret) {
    return groupBy(ret, TOTAL_AREA_PROPERTY);
  }

  public SmartPalletRequest groupByTotalArea(SqlFunction func) {
    return groupByTotalArea(TOTAL_AREA_PROPERTY, func);
  }

  public SmartPalletRequest groupByTotalArea(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AREA_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public SmartPalletRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest whereLatitudeBetween(BigDecimal latitudeStart, BigDecimal latitudeEnd) {
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

  public SmartPalletRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public SmartPalletRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public SmartPalletRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public SmartPalletRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public SmartPalletRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public SmartPalletRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public SmartPalletRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public SmartPalletRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public SmartPalletRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public SmartPalletRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public SmartPalletRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public SmartPalletRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public SmartPalletRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public SmartPalletRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest whereLongitudeBetween(
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

  public SmartPalletRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public SmartPalletRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public SmartPalletRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public SmartPalletRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public SmartPalletRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public SmartPalletRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public SmartPalletRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public SmartPalletRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public SmartPalletRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public SmartPalletRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public SmartPalletRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public SmartPalletRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public SmartPalletRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public SmartPalletRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest whereLastUpdateTimeBetween(
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

  public SmartPalletRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public SmartPalletRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public SmartPalletRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public SmartPalletRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public SmartPalletRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public SmartPalletRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public SmartPalletRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public SmartPalletRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public SmartPalletRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public SmartPalletRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public SmartPalletRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SmartPalletRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SmartPalletRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SmartPalletRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SmartPalletRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SmartPalletRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SmartPalletRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SmartPalletRequest countVersion() {
    return countVersion("countVersion");
  }

  public SmartPalletRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SmartPalletRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SmartPalletRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SmartPalletRequest minVersion() {
    return minVersion("minVersion");
  }

  public SmartPalletRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SmartPalletRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SmartPalletRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SmartPalletRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SmartPalletRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SmartPalletRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SmartPalletRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SmartPalletRequest filterByWarehouse(WarehouseRequest warehouse) {
    return filterByWarehouse(warehouse, Warehouse::getId);
  }

  public SmartPalletRequest filterByWarehouse(Warehouse... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(Warehouse... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public SmartPalletRequest selectWarehouseId() {
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

  public SmartPalletRequest filterByWarehouse(String... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(String... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public SmartPalletRequest filterByWarehouse(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    warehouse.unlimited();
    return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
  }

  public SearchCriteria createWarehouseCriteria(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine, Warehouse.ID_PROPERTY);
  }

  public SmartPalletRequest selectWarehouse() {
    return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
  }

  public SmartPalletRequest selectWarehouse(WarehouseRequest warehouse) {
    selectParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public SmartPalletRequest unselectWarehouse() {
    unselectParent(WAREHOUSE_PROPERTY);
    return this;
  }

  public SmartPalletRequest groupByWarehouse(WarehouseRequest warehouse) {
    groupBy(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public SmartPalletRequest aggregateWarehouse(WarehouseRequest warehouse) {
    aggregateParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public SmartPalletRequest countWarehouse() {
    return countWarehouse("countWarehouse");
  }

  public SmartPalletRequest countWarehouse(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WAREHOUSE_PROPERTY);
  }

  public SmartPalletRequest groupByWarehouse() {
    return groupByWarehouse(WAREHOUSE_PROPERTY);
  }

  public SmartPalletRequest groupByWarehouse(String ret) {
    return groupBy(ret, WAREHOUSE_PROPERTY);
  }

  public SmartPalletRequest whereWarehouseIsNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SmartPalletRequest whereWarehouseIsNotNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SmartPalletRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public SmartPalletRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods()
            .select(Goods.SMART_PALLET_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goods));
  }

  public SmartPalletRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.SMART_PALLET_PROPERTY).filterById(goods));
  }

  public SmartPalletRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getSmartPallet)
                .map(SmartPallet::getId)
                .orElse(null));
  }

  public SmartPalletRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.SMART_PALLET_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public SmartPalletRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.SMART_PALLET_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.SMART_PALLET_PROPERTY);
  }

  public SmartPalletRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.SMART_PALLET_PROPERTY, goods);
    return this;
  }

  public SmartPalletRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public SmartPalletRequest unselectGoodsList() {
    unselectChild(Goods.SMART_PALLET_PROPERTY, Goods.class);
    return this;
  }

  public SmartPalletRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.SMART_PALLET_PROPERTY, goods);
    return this;
  }

  public SmartPalletRequest countGoods() {
    return countGoods("goodsCount");
  }

  public SmartPalletRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public SmartPalletRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public SmartPalletRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public SmartPalletRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.SMART_PALLET_PROPERTY);
  }

  public SmartPalletRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SmartPalletRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SmartPalletRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SmartPalletRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
