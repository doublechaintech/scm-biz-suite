package com.doublechaintech.retailscm.warehouse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.damagespace.DamageSpaceRequest;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest;
import com.doublechaintech.retailscm.smartpallet.SmartPalletRequest;
import com.doublechaintech.retailscm.storagespace.StorageSpaceRequest;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.warehouse.Warehouse.*;

public class WarehouseRequest extends BaseRequest<Warehouse> {
  public static WarehouseRequest newInstance() {
    return new WarehouseRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public WarehouseRequest resultByClass(Class<? extends Warehouse> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public WarehouseRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public WarehouseRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Warehouse";
  }

  public WarehouseRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public WarehouseRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public WarehouseRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public WarehouseRequest select(String... names) {
    super.select(names);
    return this;
  }

  public WarehouseRequest selectAll() {
    return this.selectId()
        .selectLocation()
        .selectContactNumber()
        .selectTotalArea()
        .selectOwner()
        .selectLatitude()
        .selectLongitude()
        .selectContract()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public WarehouseRequest selectAny() {
    return selectAll()
        .selectStorageSpaceList(Q.storageSpace().selectSelf())
        .selectSmartPalletList(Q.smartPallet().selectSelf())
        .selectSupplierSpaceList(Q.supplierSpace().selectSelf())
        .selectReceivingSpaceList(Q.receivingSpace().selectSelf())
        .selectShippingSpaceList(Q.shippingSpace().selectSelf())
        .selectDamageSpaceList(Q.damageSpace().selectSelf())
        .selectWarehouseAssetList(Q.warehouseAsset().selectSelf());
  }

  public WarehouseRequest selectSelf() {
    select(ID_PROPERTY);
    select(LOCATION_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(TOTAL_AREA_PROPERTY);
    select(OWNER_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(CONTRACT_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public WarehouseRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public WarehouseRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
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
    OWNER_PROPERTY,
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
    CONTRACT_PROPERTY,
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

  public WarehouseRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public WarehouseRequest comment(String comment) {
    return this;
  }

  public WarehouseRequest enhance() {
    return this;
  }

  public WarehouseRequest overrideClass(Class<? extends Warehouse> clazz) {
    return this;
  }

  public WarehouseRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public WarehouseRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public WarehouseRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public WarehouseRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public WarehouseRequest count() {
    return countId("count");
  }

  public static WarehouseRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public WarehouseRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public WarehouseRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectId() {
    return select(ID_PROPERTY);
  }

  public WarehouseRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public WarehouseRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public WarehouseRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public WarehouseRequest countId() {
    return countId("countId");
  }

  public WarehouseRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public WarehouseRequest maxId() {
    return maxId("maxId");
  }

  public WarehouseRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public WarehouseRequest minId() {
    return minId("minId");
  }

  public WarehouseRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public WarehouseRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public WarehouseRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public WarehouseRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public WarehouseRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByLocation(String location) {

    if (location == null) {
      return this;
    }

    return filterByLocation(QueryOperator.EQUAL, location);
  }

  public WarehouseRequest whereLocationIsNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereLocationIsNotNull() {
    return where(LOCATION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectLocation() {
    return select(LOCATION_PROPERTY);
  }

  public WarehouseRequest unselectLocation() {
    return unselect(LOCATION_PROPERTY);
  }

  public SearchCriteria getLocationSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByLocation(boolean asc) {
    addOrderBy(LOCATION_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByLocationAscending() {
    addOrderBy(LOCATION_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByLocationDescending() {
    addOrderBy(LOCATION_PROPERTY, false);
    return this;
  }

  public WarehouseRequest orderByLocationAscendingUsingGBK() {
    addOrderBy("convert(location using gbk)", true);
    return this;
  }

  public WarehouseRequest orderByLocationDescendingUsingGBK() {
    addOrderBy("convert(location using gbk)", false);
    return this;
  }

  public WarehouseRequest countLocation() {
    return countLocation("countLocation");
  }

  public WarehouseRequest countLocation(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LOCATION_PROPERTY);
  }

  public WarehouseRequest maxLocation() {
    return maxLocation("maxLocation");
  }

  public WarehouseRequest maxLocation(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LOCATION_PROPERTY);
  }

  public WarehouseRequest minLocation() {
    return minLocation("minLocation");
  }

  public WarehouseRequest minLocation(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LOCATION_PROPERTY);
  }

  public WarehouseRequest groupByLocation() {
    return groupByLocation(LOCATION_PROPERTY);
  }

  public WarehouseRequest groupByLocation(String ret) {
    return groupBy(ret, LOCATION_PROPERTY);
  }

  public WarehouseRequest groupByLocation(SqlFunction func) {
    return groupByLocation(LOCATION_PROPERTY, func);
  }

  public WarehouseRequest groupByLocation(String ret, SqlFunction func) {
    super.groupBy(ret, func, LOCATION_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public WarehouseRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public WarehouseRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public WarehouseRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public WarehouseRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public WarehouseRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public WarehouseRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public WarehouseRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public WarehouseRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public WarehouseRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public WarehouseRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public WarehouseRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public WarehouseRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public WarehouseRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public WarehouseRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByTotalArea(String totalArea) {

    if (totalArea == null) {
      return this;
    }

    return filterByTotalArea(QueryOperator.EQUAL, totalArea);
  }

  public WarehouseRequest whereTotalAreaIsNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereTotalAreaIsNotNull() {
    return where(TOTAL_AREA_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectTotalArea() {
    return select(TOTAL_AREA_PROPERTY);
  }

  public WarehouseRequest unselectTotalArea() {
    return unselect(TOTAL_AREA_PROPERTY);
  }

  public SearchCriteria getTotalAreaSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByTotalArea(boolean asc) {
    addOrderBy(TOTAL_AREA_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByTotalAreaAscending() {
    addOrderBy(TOTAL_AREA_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByTotalAreaDescending() {
    addOrderBy(TOTAL_AREA_PROPERTY, false);
    return this;
  }

  public WarehouseRequest orderByTotalAreaAscendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", true);
    return this;
  }

  public WarehouseRequest orderByTotalAreaDescendingUsingGBK() {
    addOrderBy("convert(totalArea using gbk)", false);
    return this;
  }

  public WarehouseRequest countTotalArea() {
    return countTotalArea("countTotalArea");
  }

  public WarehouseRequest countTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AREA_PROPERTY);
  }

  public WarehouseRequest maxTotalArea() {
    return maxTotalArea("maxTotalArea");
  }

  public WarehouseRequest maxTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AREA_PROPERTY);
  }

  public WarehouseRequest minTotalArea() {
    return minTotalArea("minTotalArea");
  }

  public WarehouseRequest minTotalArea(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AREA_PROPERTY);
  }

  public WarehouseRequest groupByTotalArea() {
    return groupByTotalArea(TOTAL_AREA_PROPERTY);
  }

  public WarehouseRequest groupByTotalArea(String ret) {
    return groupBy(ret, TOTAL_AREA_PROPERTY);
  }

  public WarehouseRequest groupByTotalArea(SqlFunction func) {
    return groupByTotalArea(TOTAL_AREA_PROPERTY, func);
  }

  public WarehouseRequest groupByTotalArea(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AREA_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public WarehouseRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest whereLatitudeBetween(BigDecimal latitudeStart, BigDecimal latitudeEnd) {
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

  public WarehouseRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public WarehouseRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public WarehouseRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public WarehouseRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public WarehouseRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public WarehouseRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public WarehouseRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public WarehouseRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public WarehouseRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public WarehouseRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public WarehouseRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public WarehouseRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public WarehouseRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public WarehouseRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public WarehouseRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest whereLongitudeBetween(
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

  public WarehouseRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public WarehouseRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public WarehouseRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public WarehouseRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public WarehouseRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public WarehouseRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public WarehouseRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public WarehouseRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public WarehouseRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public WarehouseRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public WarehouseRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public WarehouseRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public WarehouseRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public WarehouseRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByContract(String contract) {

    if (contract == null) {
      return this;
    }

    return filterByContract(QueryOperator.EQUAL, contract);
  }

  public WarehouseRequest whereContractIsNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereContractIsNotNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest filterByContract(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectContract() {
    return select(CONTRACT_PROPERTY);
  }

  public WarehouseRequest unselectContract() {
    return unselect(CONTRACT_PROPERTY);
  }

  public SearchCriteria getContractSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByContract(boolean asc) {
    addOrderBy(CONTRACT_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByContractAscending() {
    addOrderBy(CONTRACT_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByContractDescending() {
    addOrderBy(CONTRACT_PROPERTY, false);
    return this;
  }

  public WarehouseRequest orderByContractAscendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", true);
    return this;
  }

  public WarehouseRequest orderByContractDescendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", false);
    return this;
  }

  public WarehouseRequest countContract() {
    return countContract("countContract");
  }

  public WarehouseRequest countContract(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTRACT_PROPERTY);
  }

  public WarehouseRequest maxContract() {
    return maxContract("maxContract");
  }

  public WarehouseRequest maxContract(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTRACT_PROPERTY);
  }

  public WarehouseRequest minContract() {
    return minContract("minContract");
  }

  public WarehouseRequest minContract(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTRACT_PROPERTY);
  }

  public WarehouseRequest groupByContract() {
    return groupByContract(CONTRACT_PROPERTY);
  }

  public WarehouseRequest groupByContract(String ret) {
    return groupBy(ret, CONTRACT_PROPERTY);
  }

  public WarehouseRequest groupByContract(SqlFunction func) {
    return groupByContract(CONTRACT_PROPERTY, func);
  }

  public WarehouseRequest groupByContract(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTRACT_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public WarehouseRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest whereLastUpdateTimeBetween(
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

  public WarehouseRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public WarehouseRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public WarehouseRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public WarehouseRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public WarehouseRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public WarehouseRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public WarehouseRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public WarehouseRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public WarehouseRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public WarehouseRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public WarehouseRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public WarehouseRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public WarehouseRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public WarehouseRequest countVersion() {
    return countVersion("countVersion");
  }

  public WarehouseRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public WarehouseRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public WarehouseRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public WarehouseRequest minVersion() {
    return minVersion("minVersion");
  }

  public WarehouseRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public WarehouseRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public WarehouseRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public WarehouseRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public WarehouseRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public WarehouseRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public WarehouseRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public WarehouseRequest filterByOwner(RetailStoreCountryCenterRequest owner) {
    return filterByOwner(owner, RetailStoreCountryCenter::getId);
  }

  public WarehouseRequest filterByOwner(RetailStoreCountryCenter... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreCountryCenter... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public WarehouseRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToOwner() {
    return upToOwner(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToOwner(RetailStoreCountryCenterRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public RetailStoreCountryCenterRequest endAtOwner(String retName) {
    return endAtOwner(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtOwner(
      String retName, RetailStoreCountryCenterRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public WarehouseRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public WarehouseRequest filterByOwner(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        owner, OWNER_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public WarehouseRequest selectOwner() {
    return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public WarehouseRequest selectOwner(RetailStoreCountryCenterRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public WarehouseRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public WarehouseRequest groupByOwner(RetailStoreCountryCenterRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public WarehouseRequest aggregateOwner(RetailStoreCountryCenterRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public WarehouseRequest countOwner() {
    return countOwner("countOwner");
  }

  public WarehouseRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public WarehouseRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public WarehouseRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public WarehouseRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public WarehouseRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public WarehouseRequest hasStorageSpace() {
    return hasStorageSpace(StorageSpaceRequest.newInstance());
  }

  public WarehouseRequest hasStorageSpace(StorageSpace... storageSpace) {
    if (isEmptyParam(storageSpace)) {
      throw new IllegalArgumentException("hasStorageSpace(StorageSpace... storageSpace)参数不能为空!");
    }
    return hasStorageSpace(
        Q.storageSpace()
            .select(StorageSpace.WAREHOUSE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) storageSpace));
  }

  public WarehouseRequest hasStorageSpace(String... storageSpace) {
    return hasStorageSpace(
        Q.storageSpace().select(StorageSpace.WAREHOUSE_PROPERTY).filterById(storageSpace));
  }

  public WarehouseRequest hasStorageSpace(StorageSpaceRequest storageSpace) {
    return hasStorageSpace(
        storageSpace,
        $storageSpace ->
            java.util.Optional.of($storageSpace)
                .map(StorageSpace::getWarehouse)
                .map(Warehouse::getId)
                .orElse(null));
  }

  public WarehouseRequest hasStorageSpace(
      StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine) {
    storageSpace.select(StorageSpace.WAREHOUSE_PROPERTY);
    storageSpace.unlimited();
    return addSearchCriteria(createStorageSpaceCriteria(storageSpace, idRefine));
  }

  public WarehouseRequest hasStorageSpace(
      StorageSpaceRequest storageSpace, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            storageSpace, StorageSpace.WAREHOUSE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createStorageSpaceCriteria(
      StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine) {
    return new RefinedIdInCriteria(
        storageSpace, ID_PROPERTY, idRefine, StorageSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest selectStorageSpaceList(StorageSpaceRequest storageSpace) {
    selectChild(StorageSpace.WAREHOUSE_PROPERTY, storageSpace);
    return this;
  }

  public WarehouseRequest selectStorageSpaceList() {
    return selectStorageSpaceList(StorageSpaceRequest.newInstance().selectAll());
  }

  public WarehouseRequest unselectStorageSpaceList() {
    unselectChild(StorageSpace.WAREHOUSE_PROPERTY, StorageSpace.class);
    return this;
  }

  public WarehouseRequest hasSmartPallet() {
    return hasSmartPallet(SmartPalletRequest.newInstance());
  }

  public WarehouseRequest hasSmartPallet(SmartPallet... smartPallet) {
    if (isEmptyParam(smartPallet)) {
      throw new IllegalArgumentException("hasSmartPallet(SmartPallet... smartPallet)参数不能为空!");
    }
    return hasSmartPallet(
        Q.smartPallet()
            .select(SmartPallet.WAREHOUSE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) smartPallet));
  }

  public WarehouseRequest hasSmartPallet(String... smartPallet) {
    return hasSmartPallet(
        Q.smartPallet().select(SmartPallet.WAREHOUSE_PROPERTY).filterById(smartPallet));
  }

  public WarehouseRequest hasSmartPallet(SmartPalletRequest smartPallet) {
    return hasSmartPallet(
        smartPallet,
        $smartPallet ->
            java.util.Optional.of($smartPallet)
                .map(SmartPallet::getWarehouse)
                .map(Warehouse::getId)
                .orElse(null));
  }

  public WarehouseRequest hasSmartPallet(
      SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine) {
    smartPallet.select(SmartPallet.WAREHOUSE_PROPERTY);
    smartPallet.unlimited();
    return addSearchCriteria(createSmartPalletCriteria(smartPallet, idRefine));
  }

  public WarehouseRequest hasSmartPallet(
      SmartPalletRequest smartPallet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(smartPallet, SmartPallet.WAREHOUSE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSmartPalletCriteria(
      SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine) {
    return new RefinedIdInCriteria(
        smartPallet, ID_PROPERTY, idRefine, SmartPallet.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest selectSmartPalletList(SmartPalletRequest smartPallet) {
    selectChild(SmartPallet.WAREHOUSE_PROPERTY, smartPallet);
    return this;
  }

  public WarehouseRequest selectSmartPalletList() {
    return selectSmartPalletList(SmartPalletRequest.newInstance().selectAll());
  }

  public WarehouseRequest unselectSmartPalletList() {
    unselectChild(SmartPallet.WAREHOUSE_PROPERTY, SmartPallet.class);
    return this;
  }

  public WarehouseRequest hasSupplierSpace() {
    return hasSupplierSpace(SupplierSpaceRequest.newInstance());
  }

  public WarehouseRequest hasSupplierSpace(SupplierSpace... supplierSpace) {
    if (isEmptyParam(supplierSpace)) {
      throw new IllegalArgumentException("hasSupplierSpace(SupplierSpace... supplierSpace)参数不能为空!");
    }
    return hasSupplierSpace(
        Q.supplierSpace()
            .select(SupplierSpace.WAREHOUSE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) supplierSpace));
  }

  public WarehouseRequest hasSupplierSpace(String... supplierSpace) {
    return hasSupplierSpace(
        Q.supplierSpace().select(SupplierSpace.WAREHOUSE_PROPERTY).filterById(supplierSpace));
  }

  public WarehouseRequest hasSupplierSpace(SupplierSpaceRequest supplierSpace) {
    return hasSupplierSpace(
        supplierSpace,
        $supplierSpace ->
            java.util.Optional.of($supplierSpace)
                .map(SupplierSpace::getWarehouse)
                .map(Warehouse::getId)
                .orElse(null));
  }

  public WarehouseRequest hasSupplierSpace(
      SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine) {
    supplierSpace.select(SupplierSpace.WAREHOUSE_PROPERTY);
    supplierSpace.unlimited();
    return addSearchCriteria(createSupplierSpaceCriteria(supplierSpace, idRefine));
  }

  public WarehouseRequest hasSupplierSpace(
      SupplierSpaceRequest supplierSpace, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            supplierSpace, SupplierSpace.WAREHOUSE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSupplierSpaceCriteria(
      SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine) {
    return new RefinedIdInCriteria(
        supplierSpace, ID_PROPERTY, idRefine, SupplierSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest selectSupplierSpaceList(SupplierSpaceRequest supplierSpace) {
    selectChild(SupplierSpace.WAREHOUSE_PROPERTY, supplierSpace);
    return this;
  }

  public WarehouseRequest selectSupplierSpaceList() {
    return selectSupplierSpaceList(SupplierSpaceRequest.newInstance().selectAll());
  }

  public WarehouseRequest unselectSupplierSpaceList() {
    unselectChild(SupplierSpace.WAREHOUSE_PROPERTY, SupplierSpace.class);
    return this;
  }

  public WarehouseRequest hasReceivingSpace() {
    return hasReceivingSpace(ReceivingSpaceRequest.newInstance());
  }

  public WarehouseRequest hasReceivingSpace(ReceivingSpace... receivingSpace) {
    if (isEmptyParam(receivingSpace)) {
      throw new IllegalArgumentException(
          "hasReceivingSpace(ReceivingSpace... receivingSpace)参数不能为空!");
    }
    return hasReceivingSpace(
        Q.receivingSpace()
            .select(ReceivingSpace.WAREHOUSE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) receivingSpace));
  }

  public WarehouseRequest hasReceivingSpace(String... receivingSpace) {
    return hasReceivingSpace(
        Q.receivingSpace().select(ReceivingSpace.WAREHOUSE_PROPERTY).filterById(receivingSpace));
  }

  public WarehouseRequest hasReceivingSpace(ReceivingSpaceRequest receivingSpace) {
    return hasReceivingSpace(
        receivingSpace,
        $receivingSpace ->
            java.util.Optional.of($receivingSpace)
                .map(ReceivingSpace::getWarehouse)
                .map(Warehouse::getId)
                .orElse(null));
  }

  public WarehouseRequest hasReceivingSpace(
      ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine) {
    receivingSpace.select(ReceivingSpace.WAREHOUSE_PROPERTY);
    receivingSpace.unlimited();
    return addSearchCriteria(createReceivingSpaceCriteria(receivingSpace, idRefine));
  }

  public WarehouseRequest hasReceivingSpace(
      ReceivingSpaceRequest receivingSpace, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            receivingSpace, ReceivingSpace.WAREHOUSE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createReceivingSpaceCriteria(
      ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine) {
    return new RefinedIdInCriteria(
        receivingSpace, ID_PROPERTY, idRefine, ReceivingSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest selectReceivingSpaceList(ReceivingSpaceRequest receivingSpace) {
    selectChild(ReceivingSpace.WAREHOUSE_PROPERTY, receivingSpace);
    return this;
  }

  public WarehouseRequest selectReceivingSpaceList() {
    return selectReceivingSpaceList(ReceivingSpaceRequest.newInstance().selectAll());
  }

  public WarehouseRequest unselectReceivingSpaceList() {
    unselectChild(ReceivingSpace.WAREHOUSE_PROPERTY, ReceivingSpace.class);
    return this;
  }

  public WarehouseRequest hasShippingSpace() {
    return hasShippingSpace(ShippingSpaceRequest.newInstance());
  }

  public WarehouseRequest hasShippingSpace(ShippingSpace... shippingSpace) {
    if (isEmptyParam(shippingSpace)) {
      throw new IllegalArgumentException("hasShippingSpace(ShippingSpace... shippingSpace)参数不能为空!");
    }
    return hasShippingSpace(
        Q.shippingSpace()
            .select(ShippingSpace.WAREHOUSE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) shippingSpace));
  }

  public WarehouseRequest hasShippingSpace(String... shippingSpace) {
    return hasShippingSpace(
        Q.shippingSpace().select(ShippingSpace.WAREHOUSE_PROPERTY).filterById(shippingSpace));
  }

  public WarehouseRequest hasShippingSpace(ShippingSpaceRequest shippingSpace) {
    return hasShippingSpace(
        shippingSpace,
        $shippingSpace ->
            java.util.Optional.of($shippingSpace)
                .map(ShippingSpace::getWarehouse)
                .map(Warehouse::getId)
                .orElse(null));
  }

  public WarehouseRequest hasShippingSpace(
      ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine) {
    shippingSpace.select(ShippingSpace.WAREHOUSE_PROPERTY);
    shippingSpace.unlimited();
    return addSearchCriteria(createShippingSpaceCriteria(shippingSpace, idRefine));
  }

  public WarehouseRequest hasShippingSpace(
      ShippingSpaceRequest shippingSpace, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            shippingSpace, ShippingSpace.WAREHOUSE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createShippingSpaceCriteria(
      ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine) {
    return new RefinedIdInCriteria(
        shippingSpace, ID_PROPERTY, idRefine, ShippingSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest selectShippingSpaceList(ShippingSpaceRequest shippingSpace) {
    selectChild(ShippingSpace.WAREHOUSE_PROPERTY, shippingSpace);
    return this;
  }

  public WarehouseRequest selectShippingSpaceList() {
    return selectShippingSpaceList(ShippingSpaceRequest.newInstance().selectAll());
  }

  public WarehouseRequest unselectShippingSpaceList() {
    unselectChild(ShippingSpace.WAREHOUSE_PROPERTY, ShippingSpace.class);
    return this;
  }

  public WarehouseRequest hasDamageSpace() {
    return hasDamageSpace(DamageSpaceRequest.newInstance());
  }

  public WarehouseRequest hasDamageSpace(DamageSpace... damageSpace) {
    if (isEmptyParam(damageSpace)) {
      throw new IllegalArgumentException("hasDamageSpace(DamageSpace... damageSpace)参数不能为空!");
    }
    return hasDamageSpace(
        Q.damageSpace()
            .select(DamageSpace.WAREHOUSE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) damageSpace));
  }

  public WarehouseRequest hasDamageSpace(String... damageSpace) {
    return hasDamageSpace(
        Q.damageSpace().select(DamageSpace.WAREHOUSE_PROPERTY).filterById(damageSpace));
  }

  public WarehouseRequest hasDamageSpace(DamageSpaceRequest damageSpace) {
    return hasDamageSpace(
        damageSpace,
        $damageSpace ->
            java.util.Optional.of($damageSpace)
                .map(DamageSpace::getWarehouse)
                .map(Warehouse::getId)
                .orElse(null));
  }

  public WarehouseRequest hasDamageSpace(
      DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine) {
    damageSpace.select(DamageSpace.WAREHOUSE_PROPERTY);
    damageSpace.unlimited();
    return addSearchCriteria(createDamageSpaceCriteria(damageSpace, idRefine));
  }

  public WarehouseRequest hasDamageSpace(
      DamageSpaceRequest damageSpace, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(damageSpace, DamageSpace.WAREHOUSE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createDamageSpaceCriteria(
      DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine) {
    return new RefinedIdInCriteria(
        damageSpace, ID_PROPERTY, idRefine, DamageSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest selectDamageSpaceList(DamageSpaceRequest damageSpace) {
    selectChild(DamageSpace.WAREHOUSE_PROPERTY, damageSpace);
    return this;
  }

  public WarehouseRequest selectDamageSpaceList() {
    return selectDamageSpaceList(DamageSpaceRequest.newInstance().selectAll());
  }

  public WarehouseRequest unselectDamageSpaceList() {
    unselectChild(DamageSpace.WAREHOUSE_PROPERTY, DamageSpace.class);
    return this;
  }

  public WarehouseRequest hasWarehouseAsset() {
    return hasWarehouseAsset(WarehouseAssetRequest.newInstance());
  }

  public WarehouseRequest hasWarehouseAsset(WarehouseAsset... warehouseAsset) {
    if (isEmptyParam(warehouseAsset)) {
      throw new IllegalArgumentException(
          "hasWarehouseAsset(WarehouseAsset... warehouseAsset)参数不能为空!");
    }
    return hasWarehouseAsset(
        Q.warehouseAsset()
            .select(WarehouseAsset.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) warehouseAsset));
  }

  public WarehouseRequest hasWarehouseAsset(String... warehouseAsset) {
    return hasWarehouseAsset(
        Q.warehouseAsset().select(WarehouseAsset.OWNER_PROPERTY).filterById(warehouseAsset));
  }

  public WarehouseRequest hasWarehouseAsset(WarehouseAssetRequest warehouseAsset) {
    return hasWarehouseAsset(
        warehouseAsset,
        $warehouseAsset ->
            java.util.Optional.of($warehouseAsset)
                .map(WarehouseAsset::getOwner)
                .map(Warehouse::getId)
                .orElse(null));
  }

  public WarehouseRequest hasWarehouseAsset(
      WarehouseAssetRequest warehouseAsset, IDRefine<WarehouseAsset> idRefine) {
    warehouseAsset.select(WarehouseAsset.OWNER_PROPERTY);
    warehouseAsset.unlimited();
    return addSearchCriteria(createWarehouseAssetCriteria(warehouseAsset, idRefine));
  }

  public WarehouseRequest hasWarehouseAsset(
      WarehouseAssetRequest warehouseAsset, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            warehouseAsset, WarehouseAsset.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createWarehouseAssetCriteria(
      WarehouseAssetRequest warehouseAsset, IDRefine<WarehouseAsset> idRefine) {
    return new RefinedIdInCriteria(
        warehouseAsset, ID_PROPERTY, idRefine, WarehouseAsset.OWNER_PROPERTY);
  }

  public WarehouseRequest selectWarehouseAssetList(WarehouseAssetRequest warehouseAsset) {
    selectChild(WarehouseAsset.OWNER_PROPERTY, warehouseAsset);
    return this;
  }

  public WarehouseRequest selectWarehouseAssetList() {
    return selectWarehouseAssetList(WarehouseAssetRequest.newInstance().selectAll());
  }

  public WarehouseRequest unselectWarehouseAssetList() {
    unselectChild(WarehouseAsset.OWNER_PROPERTY, WarehouseAsset.class);
    return this;
  }

  public WarehouseRequest aggregateStorageSpaceList(StorageSpaceRequest storageSpace) {
    aggregateChild(StorageSpace.WAREHOUSE_PROPERTY, storageSpace);
    return this;
  }

  public WarehouseRequest countStorageSpace() {
    return countStorageSpace("storageSpaceCount");
  }

  public WarehouseRequest countStorageSpace(String retName) {
    return countStorageSpace(retName, StorageSpaceRequest.newInstance());
  }

  public WarehouseRequest countStorageSpace(StorageSpaceRequest storageSpace) {
    return countStorageSpace("storageSpaceCount", storageSpace);
  }

  public WarehouseRequest countStorageSpace(String retName, StorageSpaceRequest storageSpace) {
    storageSpace.count();
    return statsFromStorageSpace(retName, storageSpace);
  }

  public WarehouseRequest statsFromStorageSpace(String retName, StorageSpaceRequest storageSpace) {
    return addDynamicProperty(retName, storageSpace, StorageSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest aggregateSmartPalletList(SmartPalletRequest smartPallet) {
    aggregateChild(SmartPallet.WAREHOUSE_PROPERTY, smartPallet);
    return this;
  }

  public WarehouseRequest countSmartPallet() {
    return countSmartPallet("smartPalletCount");
  }

  public WarehouseRequest countSmartPallet(String retName) {
    return countSmartPallet(retName, SmartPalletRequest.newInstance());
  }

  public WarehouseRequest countSmartPallet(SmartPalletRequest smartPallet) {
    return countSmartPallet("smartPalletCount", smartPallet);
  }

  public WarehouseRequest countSmartPallet(String retName, SmartPalletRequest smartPallet) {
    smartPallet.count();
    return statsFromSmartPallet(retName, smartPallet);
  }

  public WarehouseRequest statsFromSmartPallet(String retName, SmartPalletRequest smartPallet) {
    return addDynamicProperty(retName, smartPallet, SmartPallet.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest aggregateSupplierSpaceList(SupplierSpaceRequest supplierSpace) {
    aggregateChild(SupplierSpace.WAREHOUSE_PROPERTY, supplierSpace);
    return this;
  }

  public WarehouseRequest countSupplierSpace() {
    return countSupplierSpace("supplierSpaceCount");
  }

  public WarehouseRequest countSupplierSpace(String retName) {
    return countSupplierSpace(retName, SupplierSpaceRequest.newInstance());
  }

  public WarehouseRequest countSupplierSpace(SupplierSpaceRequest supplierSpace) {
    return countSupplierSpace("supplierSpaceCount", supplierSpace);
  }

  public WarehouseRequest countSupplierSpace(String retName, SupplierSpaceRequest supplierSpace) {
    supplierSpace.count();
    return statsFromSupplierSpace(retName, supplierSpace);
  }

  public WarehouseRequest statsFromSupplierSpace(
      String retName, SupplierSpaceRequest supplierSpace) {
    return addDynamicProperty(retName, supplierSpace, SupplierSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest aggregateReceivingSpaceList(ReceivingSpaceRequest receivingSpace) {
    aggregateChild(ReceivingSpace.WAREHOUSE_PROPERTY, receivingSpace);
    return this;
  }

  public WarehouseRequest countReceivingSpace() {
    return countReceivingSpace("receivingSpaceCount");
  }

  public WarehouseRequest countReceivingSpace(String retName) {
    return countReceivingSpace(retName, ReceivingSpaceRequest.newInstance());
  }

  public WarehouseRequest countReceivingSpace(ReceivingSpaceRequest receivingSpace) {
    return countReceivingSpace("receivingSpaceCount", receivingSpace);
  }

  public WarehouseRequest countReceivingSpace(
      String retName, ReceivingSpaceRequest receivingSpace) {
    receivingSpace.count();
    return statsFromReceivingSpace(retName, receivingSpace);
  }

  public WarehouseRequest statsFromReceivingSpace(
      String retName, ReceivingSpaceRequest receivingSpace) {
    return addDynamicProperty(retName, receivingSpace, ReceivingSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest aggregateShippingSpaceList(ShippingSpaceRequest shippingSpace) {
    aggregateChild(ShippingSpace.WAREHOUSE_PROPERTY, shippingSpace);
    return this;
  }

  public WarehouseRequest countShippingSpace() {
    return countShippingSpace("shippingSpaceCount");
  }

  public WarehouseRequest countShippingSpace(String retName) {
    return countShippingSpace(retName, ShippingSpaceRequest.newInstance());
  }

  public WarehouseRequest countShippingSpace(ShippingSpaceRequest shippingSpace) {
    return countShippingSpace("shippingSpaceCount", shippingSpace);
  }

  public WarehouseRequest countShippingSpace(String retName, ShippingSpaceRequest shippingSpace) {
    shippingSpace.count();
    return statsFromShippingSpace(retName, shippingSpace);
  }

  public WarehouseRequest statsFromShippingSpace(
      String retName, ShippingSpaceRequest shippingSpace) {
    return addDynamicProperty(retName, shippingSpace, ShippingSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest aggregateDamageSpaceList(DamageSpaceRequest damageSpace) {
    aggregateChild(DamageSpace.WAREHOUSE_PROPERTY, damageSpace);
    return this;
  }

  public WarehouseRequest countDamageSpace() {
    return countDamageSpace("damageSpaceCount");
  }

  public WarehouseRequest countDamageSpace(String retName) {
    return countDamageSpace(retName, DamageSpaceRequest.newInstance());
  }

  public WarehouseRequest countDamageSpace(DamageSpaceRequest damageSpace) {
    return countDamageSpace("damageSpaceCount", damageSpace);
  }

  public WarehouseRequest countDamageSpace(String retName, DamageSpaceRequest damageSpace) {
    damageSpace.count();
    return statsFromDamageSpace(retName, damageSpace);
  }

  public WarehouseRequest statsFromDamageSpace(String retName, DamageSpaceRequest damageSpace) {
    return addDynamicProperty(retName, damageSpace, DamageSpace.WAREHOUSE_PROPERTY);
  }

  public WarehouseRequest aggregateWarehouseAssetList(WarehouseAssetRequest warehouseAsset) {
    aggregateChild(WarehouseAsset.OWNER_PROPERTY, warehouseAsset);
    return this;
  }

  public WarehouseRequest countWarehouseAsset() {
    return countWarehouseAsset("warehouseAssetCount");
  }

  public WarehouseRequest countWarehouseAsset(String retName) {
    return countWarehouseAsset(retName, WarehouseAssetRequest.newInstance());
  }

  public WarehouseRequest countWarehouseAsset(WarehouseAssetRequest warehouseAsset) {
    return countWarehouseAsset("warehouseAssetCount", warehouseAsset);
  }

  public WarehouseRequest countWarehouseAsset(
      String retName, WarehouseAssetRequest warehouseAsset) {
    warehouseAsset.count();
    return statsFromWarehouseAsset(retName, warehouseAsset);
  }

  public WarehouseRequest statsFromWarehouseAsset(
      String retName, WarehouseAssetRequest warehouseAsset) {
    return addDynamicProperty(retName, warehouseAsset, WarehouseAsset.OWNER_PROPERTY);
  }

  public WarehouseRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public WarehouseRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public WarehouseRequest unlimited() {
    super.unlimited();
    return this;
  }

  public WarehouseRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
