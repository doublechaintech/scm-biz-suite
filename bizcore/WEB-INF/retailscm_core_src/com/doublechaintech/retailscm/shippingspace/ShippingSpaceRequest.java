package com.doublechaintech.retailscm.shippingspace;

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
import static com.doublechaintech.retailscm.shippingspace.ShippingSpace.*;

public class ShippingSpaceRequest extends BaseRequest<ShippingSpace> {
  public static ShippingSpaceRequest newInstance() {
    return new ShippingSpaceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ShippingSpaceRequest resultByClass(Class<? extends ShippingSpace> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ShippingSpaceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ShippingSpaceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ShippingSpace";
  }

  public ShippingSpaceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ShippingSpaceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ShippingSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ShippingSpaceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ShippingSpaceRequest selectAll() {
    return this.selectId()
        .selectLocation()
        .selectContactNumber()
        .selectTotalArea()
        .selectWarehouse()
        .selectLatitude()
        .selectLongitude()
        .selectDescription()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public ShippingSpaceRequest selectAny() {
    return selectAll().selectGoodsList(Q.goods().selectSelf());
  }

  public ShippingSpaceRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(TOTAL_AREA_PROPERTY);
    select(WAREHOUSE_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ShippingSpaceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ShippingSpaceRequest where(
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
    DESCRIPTION_PROPERTY,
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

  public ShippingSpaceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ShippingSpaceRequest comment(String comment) {
    return this;
  }

  public ShippingSpaceRequest enhance() {
    return this;
  }

  public ShippingSpaceRequest overrideClass(Class<? extends ShippingSpace> clazz) {
    return this;
  }

  public ShippingSpaceRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ShippingSpaceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ShippingSpaceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ShippingSpaceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ShippingSpaceRequest count() {
    return countId("count");
  }

  public static ShippingSpaceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ShippingSpaceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ShippingSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ShippingSpaceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ShippingSpaceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ShippingSpaceRequest countId() {
    return countId("countId");
  }

  public ShippingSpaceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ShippingSpaceRequest maxId() {
    return maxId("maxId");
  }

  public ShippingSpaceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ShippingSpaceRequest minId() {
    return minId("minId");
  }

  public ShippingSpaceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ShippingSpaceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ShippingSpaceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ShippingSpaceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ShippingSpaceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public ShippingSpaceRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public ShippingSpaceRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public ShippingSpaceRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public ShippingSpaceRequest countLocation() {
    return countLocation("countLocation");
  }

  public ShippingSpaceRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public ShippingSpaceRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public ShippingSpaceRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public ShippingSpaceRequest minLocation() {
    return minLocation("minLocation");
  }

  public ShippingSpaceRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public ShippingSpaceRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public ShippingSpaceRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public ShippingSpaceRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public ShippingSpaceRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public ShippingSpaceRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public ShippingSpaceRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public ShippingSpaceRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public ShippingSpaceRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public ShippingSpaceRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public ShippingSpaceRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public ShippingSpaceRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public ShippingSpaceRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public ShippingSpaceRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public ShippingSpaceRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public ShippingSpaceRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByTotalArea(String totalArea) {

    if (totalArea == null) {
      return this;
    }

    return filterByTotalArea(QueryOperator.EQUAL, totalArea);
  }

  public ShippingSpaceRequest whereTotalAreaIsNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereTotalAreaIsNotNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest filterByTotalArea(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectTotalArea() {
    return select(TOTAL_AREA_PROPERTY);
  }

  public ShippingSpaceRequest unselectTotalArea() {
    return unselect(TOTAL_AREA_PROPERTY);
  }

  public SearchCriteria getTotalAreaSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByTotalArea(boolean asc) {
    addOrderBy(TOTAL_AREA_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByTotalAreaAscending() {
    addOrderBy(TOTAL_AREA_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByTotalAreaDescending() {
    addOrderBy(TOTAL_AREA_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest orderByTotalAreaAscendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", true);
    return this;
  }

  public ShippingSpaceRequest orderByTotalAreaDescendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", false);
    return this;
  }

  public ShippingSpaceRequest countTotalArea() {
    return countTotalArea("countTotalArea");
  }

  public ShippingSpaceRequest countTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AREA_PROPERTY);
  }

  public ShippingSpaceRequest maxTotalArea() {
    return maxTotalArea("maxTotalArea");
  }

  public ShippingSpaceRequest maxTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AREA_PROPERTY);
  }

  public ShippingSpaceRequest minTotalArea() {
    return minTotalArea("minTotalArea");
  }

  public ShippingSpaceRequest minTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AREA_PROPERTY);
  }

  public ShippingSpaceRequest groupByTotalArea() {
    return groupByTotalArea(TOTAL_AREA_PROPERTY);
  }

  public ShippingSpaceRequest groupByTotalArea(String ret) {
    return groupBy(ret, TOTAL_AREA_PROPERTY);
  }

  public ShippingSpaceRequest groupByTotalArea(SqlFunction func) {
    return groupByTotalArea(TOTAL_AREA_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByTotalArea(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AREA_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public ShippingSpaceRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest whereLatitudeBetween(
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

  public ShippingSpaceRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public ShippingSpaceRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public ShippingSpaceRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public ShippingSpaceRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public ShippingSpaceRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public ShippingSpaceRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public ShippingSpaceRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public ShippingSpaceRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public ShippingSpaceRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public ShippingSpaceRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public ShippingSpaceRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public ShippingSpaceRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public ShippingSpaceRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest whereLongitudeBetween(
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

  public ShippingSpaceRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest filterByLongitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public ShippingSpaceRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public ShippingSpaceRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public ShippingSpaceRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public ShippingSpaceRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public ShippingSpaceRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public ShippingSpaceRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public ShippingSpaceRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public ShippingSpaceRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public ShippingSpaceRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public ShippingSpaceRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public ShippingSpaceRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public ShippingSpaceRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public ShippingSpaceRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public ShippingSpaceRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public ShippingSpaceRequest countDescription() {
    return countDescription("countDescription");
  }

  public ShippingSpaceRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public ShippingSpaceRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public ShippingSpaceRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public ShippingSpaceRequest minDescription() {
    return minDescription("minDescription");
  }

  public ShippingSpaceRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public ShippingSpaceRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public ShippingSpaceRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public ShippingSpaceRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public ShippingSpaceRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest whereLastUpdateTimeBetween(
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

  public ShippingSpaceRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public ShippingSpaceRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public ShippingSpaceRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public ShippingSpaceRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public ShippingSpaceRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public ShippingSpaceRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public ShippingSpaceRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public ShippingSpaceRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public ShippingSpaceRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public ShippingSpaceRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ShippingSpaceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ShippingSpaceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ShippingSpaceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ShippingSpaceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ShippingSpaceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ShippingSpaceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ShippingSpaceRequest countVersion() {
    return countVersion("countVersion");
  }

  public ShippingSpaceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ShippingSpaceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ShippingSpaceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ShippingSpaceRequest minVersion() {
    return minVersion("minVersion");
  }

  public ShippingSpaceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ShippingSpaceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ShippingSpaceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ShippingSpaceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ShippingSpaceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ShippingSpaceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ShippingSpaceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest filterByWarehouse(WarehouseRequest warehouse) {
    return filterByWarehouse(warehouse, Warehouse::getId);
  }

  public ShippingSpaceRequest filterByWarehouse(Warehouse... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(Warehouse... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public ShippingSpaceRequest selectWarehouseId() {
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

  public ShippingSpaceRequest filterByWarehouse(String... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(String... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public ShippingSpaceRequest filterByWarehouse(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    warehouse.unlimited();
    return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
  }

  public SearchCriteria createWarehouseCriteria(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine, Warehouse.ID_PROPERTY);
  }

  public ShippingSpaceRequest selectWarehouse() {
    return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
  }

  public ShippingSpaceRequest selectWarehouse(WarehouseRequest warehouse) {
    selectParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public ShippingSpaceRequest unselectWarehouse() {
    unselectParent(WAREHOUSE_PROPERTY);
    return this;
  }

  public ShippingSpaceRequest groupByWarehouse(WarehouseRequest warehouse) {
    groupBy(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public ShippingSpaceRequest aggregateWarehouse(WarehouseRequest warehouse) {
    aggregateParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public ShippingSpaceRequest countWarehouse() {
    return countWarehouse("countWarehouse");
  }

  public ShippingSpaceRequest countWarehouse(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WAREHOUSE_PROPERTY);
  }

  public ShippingSpaceRequest groupByWarehouse() {
    return groupByWarehouse(WAREHOUSE_PROPERTY);
  }

  public ShippingSpaceRequest groupByWarehouse(String ret) {
    return groupBy(ret, WAREHOUSE_PROPERTY);
  }

  public ShippingSpaceRequest whereWarehouseIsNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ShippingSpaceRequest whereWarehouseIsNotNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ShippingSpaceRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public ShippingSpaceRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods()
            .select(Goods.SHIPPING_SPACE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goods));
  }

  public ShippingSpaceRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.SHIPPING_SPACE_PROPERTY).filterById(goods));
  }

  public ShippingSpaceRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getShippingSpace)
                .map(ShippingSpace::getId)
                .orElse(null));
  }

  public ShippingSpaceRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.SHIPPING_SPACE_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public ShippingSpaceRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.SHIPPING_SPACE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.SHIPPING_SPACE_PROPERTY);
  }

  public ShippingSpaceRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.SHIPPING_SPACE_PROPERTY, goods);
    return this;
  }

  public ShippingSpaceRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public ShippingSpaceRequest unselectGoodsList() {
    unselectChild(Goods.SHIPPING_SPACE_PROPERTY, Goods.class);
    return this;
  }

  public ShippingSpaceRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.SHIPPING_SPACE_PROPERTY, goods);
    return this;
  }

  public ShippingSpaceRequest countGoods() {
    return countGoods("goodsCount");
  }

  public ShippingSpaceRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public ShippingSpaceRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public ShippingSpaceRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public ShippingSpaceRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.SHIPPING_SPACE_PROPERTY);
  }

  public ShippingSpaceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ShippingSpaceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ShippingSpaceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ShippingSpaceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
