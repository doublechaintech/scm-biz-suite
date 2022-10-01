package com.doublechaintech.retailscm.receivingspace;

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
import static com.doublechaintech.retailscm.receivingspace.ReceivingSpace.*;

public class ReceivingSpaceRequest extends BaseRequest<ReceivingSpace> {
  public static ReceivingSpaceRequest newInstance() {
    return new ReceivingSpaceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ReceivingSpaceRequest resultByClass(Class<? extends ReceivingSpace> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ReceivingSpaceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ReceivingSpaceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ReceivingSpace";
  }

  public ReceivingSpaceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ReceivingSpaceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ReceivingSpaceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ReceivingSpaceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ReceivingSpaceRequest selectAll() {
    return this.selectId()
        .selectLocation()
        .selectContactNumber()
        .selectDescription()
        .selectTotalArea()
        .selectWarehouse()
        .selectLatitude()
        .selectLongitude()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public ReceivingSpaceRequest selectAny() {
    return selectAll().selectGoodsList(Q.goods().selectSelf());
  }

  public ReceivingSpaceRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(TOTAL_AREA_PROPERTY);
    select(WAREHOUSE_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ReceivingSpaceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ReceivingSpaceRequest where(
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
    DESCRIPTION_PROPERTY,
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

  public ReceivingSpaceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ReceivingSpaceRequest comment(String comment) {
    return this;
  }

  public ReceivingSpaceRequest enhance() {
    return this;
  }

  public ReceivingSpaceRequest overrideClass(Class<? extends ReceivingSpace> clazz) {
    return this;
  }

  public ReceivingSpaceRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ReceivingSpaceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ReceivingSpaceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ReceivingSpaceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ReceivingSpaceRequest count() {
    return countId("count");
  }

  public static ReceivingSpaceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ReceivingSpaceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ReceivingSpaceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ReceivingSpaceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ReceivingSpaceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ReceivingSpaceRequest countId() {
    return countId("countId");
  }

  public ReceivingSpaceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ReceivingSpaceRequest maxId() {
    return maxId("maxId");
  }

  public ReceivingSpaceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ReceivingSpaceRequest minId() {
    return minId("minId");
  }

  public ReceivingSpaceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ReceivingSpaceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ReceivingSpaceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ReceivingSpaceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public ReceivingSpaceRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest filterByLocation(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public ReceivingSpaceRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public ReceivingSpaceRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public ReceivingSpaceRequest countLocation() {
    return countLocation("countLocation");
  }

  public ReceivingSpaceRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public ReceivingSpaceRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public ReceivingSpaceRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public ReceivingSpaceRequest minLocation() {
    return minLocation("minLocation");
  }

  public ReceivingSpaceRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public ReceivingSpaceRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public ReceivingSpaceRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public ReceivingSpaceRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public ReceivingSpaceRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public ReceivingSpaceRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public ReceivingSpaceRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public ReceivingSpaceRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public ReceivingSpaceRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public ReceivingSpaceRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public ReceivingSpaceRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public ReceivingSpaceRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public ReceivingSpaceRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public ReceivingSpaceRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public ReceivingSpaceRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public ReceivingSpaceRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public ReceivingSpaceRequest countDescription() {
    return countDescription("countDescription");
  }

  public ReceivingSpaceRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public ReceivingSpaceRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public ReceivingSpaceRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public ReceivingSpaceRequest minDescription() {
    return minDescription("minDescription");
  }

  public ReceivingSpaceRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByTotalArea(String totalArea) {

    if (totalArea == null) {
      return this;
    }

    return filterByTotalArea(QueryOperator.EQUAL, totalArea);
  }

  public ReceivingSpaceRequest whereTotalAreaIsNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereTotalAreaIsNotNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest filterByTotalArea(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectTotalArea() {
    return select(TOTAL_AREA_PROPERTY);
  }

  public ReceivingSpaceRequest unselectTotalArea() {
    return unselect(TOTAL_AREA_PROPERTY);
  }

  public SearchCriteria getTotalAreaSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByTotalArea(boolean asc) {
    addOrderBy(TOTAL_AREA_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByTotalAreaAscending() {
    addOrderBy(TOTAL_AREA_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByTotalAreaDescending() {
    addOrderBy(TOTAL_AREA_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest orderByTotalAreaAscendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", true);
    return this;
  }

  public ReceivingSpaceRequest orderByTotalAreaDescendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", false);
    return this;
  }

  public ReceivingSpaceRequest countTotalArea() {
    return countTotalArea("countTotalArea");
  }

  public ReceivingSpaceRequest countTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AREA_PROPERTY);
  }

  public ReceivingSpaceRequest maxTotalArea() {
    return maxTotalArea("maxTotalArea");
  }

  public ReceivingSpaceRequest maxTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AREA_PROPERTY);
  }

  public ReceivingSpaceRequest minTotalArea() {
    return minTotalArea("minTotalArea");
  }

  public ReceivingSpaceRequest minTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AREA_PROPERTY);
  }

  public ReceivingSpaceRequest groupByTotalArea() {
    return groupByTotalArea(TOTAL_AREA_PROPERTY);
  }

  public ReceivingSpaceRequest groupByTotalArea(String ret) {
    return groupBy(ret, TOTAL_AREA_PROPERTY);
  }

  public ReceivingSpaceRequest groupByTotalArea(SqlFunction func) {
    return groupByTotalArea(TOTAL_AREA_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByTotalArea(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AREA_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public ReceivingSpaceRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest whereLatitudeBetween(
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

  public ReceivingSpaceRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest filterByLatitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public ReceivingSpaceRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public ReceivingSpaceRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public ReceivingSpaceRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public ReceivingSpaceRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public ReceivingSpaceRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest whereLongitudeBetween(
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

  public ReceivingSpaceRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest filterByLongitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public ReceivingSpaceRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public ReceivingSpaceRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public ReceivingSpaceRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public ReceivingSpaceRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public ReceivingSpaceRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest whereLastUpdateTimeBetween(
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

  public ReceivingSpaceRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public ReceivingSpaceRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public ReceivingSpaceRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public ReceivingSpaceRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public ReceivingSpaceRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public ReceivingSpaceRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public ReceivingSpaceRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public ReceivingSpaceRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ReceivingSpaceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ReceivingSpaceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ReceivingSpaceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ReceivingSpaceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ReceivingSpaceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ReceivingSpaceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ReceivingSpaceRequest countVersion() {
    return countVersion("countVersion");
  }

  public ReceivingSpaceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ReceivingSpaceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ReceivingSpaceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ReceivingSpaceRequest minVersion() {
    return minVersion("minVersion");
  }

  public ReceivingSpaceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ReceivingSpaceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ReceivingSpaceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ReceivingSpaceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ReceivingSpaceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest filterByWarehouse(WarehouseRequest warehouse) {
    return filterByWarehouse(warehouse, Warehouse::getId);
  }

  public ReceivingSpaceRequest filterByWarehouse(Warehouse... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(Warehouse... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public ReceivingSpaceRequest selectWarehouseId() {
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

  public ReceivingSpaceRequest filterByWarehouse(String... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("filterByWarehouse(String... warehouse)参数不能为空!");
    }
    return where(WAREHOUSE_PROPERTY, QueryOperator.IN, (Object[]) warehouse);
  }

  public ReceivingSpaceRequest filterByWarehouse(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    warehouse.unlimited();
    return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
  }

  public SearchCriteria createWarehouseCriteria(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    return new RefinedIdInCriteria(warehouse, WAREHOUSE_PROPERTY, idRefine, Warehouse.ID_PROPERTY);
  }

  public ReceivingSpaceRequest selectWarehouse() {
    return selectWarehouse(WarehouseRequest.newInstance().selectSelf());
  }

  public ReceivingSpaceRequest selectWarehouse(WarehouseRequest warehouse) {
    selectParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public ReceivingSpaceRequest unselectWarehouse() {
    unselectParent(WAREHOUSE_PROPERTY);
    return this;
  }

  public ReceivingSpaceRequest groupByWarehouse(WarehouseRequest warehouse) {
    groupBy(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public ReceivingSpaceRequest aggregateWarehouse(WarehouseRequest warehouse) {
    aggregateParent(WAREHOUSE_PROPERTY, warehouse);
    return this;
  }

  public ReceivingSpaceRequest countWarehouse() {
    return countWarehouse("countWarehouse");
  }

  public ReceivingSpaceRequest countWarehouse(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WAREHOUSE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByWarehouse() {
    return groupByWarehouse(WAREHOUSE_PROPERTY);
  }

  public ReceivingSpaceRequest groupByWarehouse(String ret) {
    return groupBy(ret, WAREHOUSE_PROPERTY);
  }

  public ReceivingSpaceRequest whereWarehouseIsNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ReceivingSpaceRequest whereWarehouseIsNotNull() {
    return where(WAREHOUSE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ReceivingSpaceRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public ReceivingSpaceRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods()
            .select(Goods.RECEIVING_SPACE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goods));
  }

  public ReceivingSpaceRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.RECEIVING_SPACE_PROPERTY).filterById(goods));
  }

  public ReceivingSpaceRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getReceivingSpace)
                .map(ReceivingSpace::getId)
                .orElse(null));
  }

  public ReceivingSpaceRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.RECEIVING_SPACE_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public ReceivingSpaceRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.RECEIVING_SPACE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.RECEIVING_SPACE_PROPERTY);
  }

  public ReceivingSpaceRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.RECEIVING_SPACE_PROPERTY, goods);
    return this;
  }

  public ReceivingSpaceRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public ReceivingSpaceRequest unselectGoodsList() {
    unselectChild(Goods.RECEIVING_SPACE_PROPERTY, Goods.class);
    return this;
  }

  public ReceivingSpaceRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.RECEIVING_SPACE_PROPERTY, goods);
    return this;
  }

  public ReceivingSpaceRequest countGoods() {
    return countGoods("goodsCount");
  }

  public ReceivingSpaceRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public ReceivingSpaceRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public ReceivingSpaceRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public ReceivingSpaceRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.RECEIVING_SPACE_PROPERTY);
  }

  public ReceivingSpaceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ReceivingSpaceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ReceivingSpaceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ReceivingSpaceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
