package com.doublechaintech.retailscm.transporttruck;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transporttruck.TransportTruck.*;

public class TransportTruckRequest extends BaseRequest<TransportTruck> {
  public static TransportTruckRequest newInstance() {
    return new TransportTruckRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TransportTruckRequest resultByClass(Class<? extends TransportTruck> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TransportTruckRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TransportTruckRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TransportTruck";
  }

  public TransportTruckRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TransportTruckRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TransportTruckRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TransportTruckRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TransportTruckRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectPlateNumber()
        .selectContactNumber()
        .selectVehicleLicenseNumber()
        .selectEngineNumber()
        .selectMakeDate()
        .selectMileage()
        .selectBodyColor()
        .selectOwner()
        .selectVersion();
  }

  public TransportTruckRequest selectAny() {
    return selectAll().selectTransportTaskList(Q.transportTask().selectSelf());
  }

  public TransportTruckRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(PLATE_NUMBER_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(VEHICLE_LICENSE_NUMBER_PROPERTY);
    select(ENGINE_NUMBER_PROPERTY);
    select(MAKE_DATE_PROPERTY);
    select(MILEAGE_PROPERTY);
    select(BODY_COLOR_PROPERTY);
    select(OWNER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TransportTruckRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TransportTruckRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {MAKE_DATE_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    PLATE_NUMBER_PROPERTY,
    CONTACT_NUMBER_PROPERTY,
    VEHICLE_LICENSE_NUMBER_PROPERTY,
    ENGINE_NUMBER_PROPERTY,
    MAKE_DATE_PROPERTY,
    MILEAGE_PROPERTY,
    BODY_COLOR_PROPERTY,
    OWNER_PROPERTY,
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

  public TransportTruckRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TransportTruckRequest comment(String comment) {
    return this;
  }

  public TransportTruckRequest enhance() {
    return this;
  }

  public TransportTruckRequest overrideClass(Class<? extends TransportTruck> clazz) {
    return this;
  }

  public TransportTruckRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TransportTruckRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TransportTruckRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TransportTruckRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TransportTruckRequest count() {
    return countId("count");
  }

  public static TransportTruckRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TransportTruckRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TransportTruckRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TransportTruckRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TransportTruckRequest countId() {
    return countId("countId");
  }

  public TransportTruckRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TransportTruckRequest maxId() {
    return maxId("maxId");
  }

  public TransportTruckRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TransportTruckRequest minId() {
    return minId("minId");
  }

  public TransportTruckRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TransportTruckRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TransportTruckRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TransportTruckRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TransportTruckRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public TransportTruckRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public TransportTruckRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public TransportTruckRequest countName() {
    return countName("countName");
  }

  public TransportTruckRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public TransportTruckRequest maxName() {
    return maxName("maxName");
  }

  public TransportTruckRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public TransportTruckRequest minName() {
    return minName("minName");
  }

  public TransportTruckRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public TransportTruckRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public TransportTruckRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public TransportTruckRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public TransportTruckRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByPlateNumber(String plateNumber) {

    if (plateNumber == null) {
      return this;
    }

    return filterByPlateNumber(QueryOperator.EQUAL, plateNumber);
  }

  public TransportTruckRequest wherePlateNumberIsNull() {
    return where(PLATE_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest wherePlateNumberIsNotNull() {
    return where(PLATE_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByPlateNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPlateNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectPlateNumber() {
    return select(PLATE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest unselectPlateNumber() {
    return unselect(PLATE_NUMBER_PROPERTY);
  }

  public SearchCriteria getPlateNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PLATE_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByPlateNumber(boolean asc) {
    addOrderBy(PLATE_NUMBER_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByPlateNumberAscending() {
    addOrderBy(PLATE_NUMBER_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByPlateNumberDescending() {
    addOrderBy(PLATE_NUMBER_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByPlateNumberAscendingUsingGBK() {
    addOrderBy("convert(plateNumber using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByPlateNumberDescendingUsingGBK() {
    addOrderBy("convert(plateNumber using gbk)", false);
    return this;
  }

  public TransportTruckRequest countPlateNumber() {
    return countPlateNumber("countPlateNumber");
  }

  public TransportTruckRequest countPlateNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PLATE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest maxPlateNumber() {
    return maxPlateNumber("maxPlateNumber");
  }

  public TransportTruckRequest maxPlateNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PLATE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest minPlateNumber() {
    return minPlateNumber("minPlateNumber");
  }

  public TransportTruckRequest minPlateNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PLATE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByPlateNumber() {
    return groupByPlateNumber(PLATE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByPlateNumber(String ret) {
    return groupBy(ret, PLATE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByPlateNumber(SqlFunction func) {
    return groupByPlateNumber(PLATE_NUMBER_PROPERTY, func);
  }

  public TransportTruckRequest groupByPlateNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, PLATE_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public TransportTruckRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public TransportTruckRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public TransportTruckRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public TransportTruckRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public TransportTruckRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public TransportTruckRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public TransportTruckRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public TransportTruckRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public TransportTruckRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByVehicleLicenseNumber(String vehicleLicenseNumber) {

    if (vehicleLicenseNumber == null) {
      return this;
    }

    return filterByVehicleLicenseNumber(QueryOperator.EQUAL, vehicleLicenseNumber);
  }

  public TransportTruckRequest whereVehicleLicenseNumberIsNull() {
    return where(VEHICLE_LICENSE_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereVehicleLicenseNumberIsNotNull() {
    return where(VEHICLE_LICENSE_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByVehicleLicenseNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getVehicleLicenseNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectVehicleLicenseNumber() {
    return select(VEHICLE_LICENSE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest unselectVehicleLicenseNumber() {
    return unselect(VEHICLE_LICENSE_NUMBER_PROPERTY);
  }

  public SearchCriteria getVehicleLicenseNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VEHICLE_LICENSE_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByVehicleLicenseNumber(boolean asc) {
    addOrderBy(VEHICLE_LICENSE_NUMBER_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByVehicleLicenseNumberAscending() {
    addOrderBy(VEHICLE_LICENSE_NUMBER_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByVehicleLicenseNumberDescending() {
    addOrderBy(VEHICLE_LICENSE_NUMBER_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByVehicleLicenseNumberAscendingUsingGBK() {
    addOrderBy("convert(vehicleLicenseNumber using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByVehicleLicenseNumberDescendingUsingGBK() {
    addOrderBy("convert(vehicleLicenseNumber using gbk)", false);
    return this;
  }

  public TransportTruckRequest countVehicleLicenseNumber() {
    return countVehicleLicenseNumber("countVehicleLicenseNumber");
  }

  public TransportTruckRequest countVehicleLicenseNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VEHICLE_LICENSE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest maxVehicleLicenseNumber() {
    return maxVehicleLicenseNumber("maxVehicleLicenseNumber");
  }

  public TransportTruckRequest maxVehicleLicenseNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VEHICLE_LICENSE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest minVehicleLicenseNumber() {
    return minVehicleLicenseNumber("minVehicleLicenseNumber");
  }

  public TransportTruckRequest minVehicleLicenseNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VEHICLE_LICENSE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByVehicleLicenseNumber() {
    return groupByVehicleLicenseNumber(VEHICLE_LICENSE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByVehicleLicenseNumber(String ret) {
    return groupBy(ret, VEHICLE_LICENSE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByVehicleLicenseNumber(SqlFunction func) {
    return groupByVehicleLicenseNumber(VEHICLE_LICENSE_NUMBER_PROPERTY, func);
  }

  public TransportTruckRequest groupByVehicleLicenseNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, VEHICLE_LICENSE_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByEngineNumber(String engineNumber) {

    if (engineNumber == null) {
      return this;
    }

    return filterByEngineNumber(QueryOperator.EQUAL, engineNumber);
  }

  public TransportTruckRequest whereEngineNumberIsNull() {
    return where(ENGINE_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereEngineNumberIsNotNull() {
    return where(ENGINE_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByEngineNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEngineNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectEngineNumber() {
    return select(ENGINE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest unselectEngineNumber() {
    return unselect(ENGINE_NUMBER_PROPERTY);
  }

  public SearchCriteria getEngineNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ENGINE_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByEngineNumber(boolean asc) {
    addOrderBy(ENGINE_NUMBER_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByEngineNumberAscending() {
    addOrderBy(ENGINE_NUMBER_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByEngineNumberDescending() {
    addOrderBy(ENGINE_NUMBER_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByEngineNumberAscendingUsingGBK() {
    addOrderBy("convert(engineNumber using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByEngineNumberDescendingUsingGBK() {
    addOrderBy("convert(engineNumber using gbk)", false);
    return this;
  }

  public TransportTruckRequest countEngineNumber() {
    return countEngineNumber("countEngineNumber");
  }

  public TransportTruckRequest countEngineNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ENGINE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest maxEngineNumber() {
    return maxEngineNumber("maxEngineNumber");
  }

  public TransportTruckRequest maxEngineNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ENGINE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest minEngineNumber() {
    return minEngineNumber("minEngineNumber");
  }

  public TransportTruckRequest minEngineNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ENGINE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByEngineNumber() {
    return groupByEngineNumber(ENGINE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByEngineNumber(String ret) {
    return groupBy(ret, ENGINE_NUMBER_PROPERTY);
  }

  public TransportTruckRequest groupByEngineNumber(SqlFunction func) {
    return groupByEngineNumber(ENGINE_NUMBER_PROPERTY, func);
  }

  public TransportTruckRequest groupByEngineNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, ENGINE_NUMBER_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByMakeDate(Date makeDate) {

    if (makeDate == null) {
      return this;
    }

    return filterByMakeDate(QueryOperator.EQUAL, makeDate);
  }

  public TransportTruckRequest whereMakeDateIsNull() {
    return where(MAKE_DATE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereMakeDateIsNotNull() {
    return where(MAKE_DATE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest whereMakeDateBetween(Date makeDateStart, Date makeDateEnd) {
    if (ObjectUtil.isEmpty(makeDateStart)) {
      throw new IllegalArgumentException(
          "Method whereMakeDateBetween, the parameter makeDateStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(makeDateEnd)) {
      throw new IllegalArgumentException(
          "Method whereMakeDateBetween, the parameter makeDateEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getMakeDateSearchCriteria(QueryOperator.BETWEEN, new Object[] {makeDateStart, makeDateEnd});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest whereMakeDateBefore(Date makeDate) {

    if (ObjectUtil.isEmpty(makeDate)) {
      throw new IllegalArgumentException(
          "Method whereMakeDateBefore, the parameter makeDate is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getMakeDateSearchCriteria(QueryOperator.LESS_THAN, new Object[] {makeDate});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest whereMakeDateAfter(Date makeDate) {
    if (ObjectUtil.isEmpty(makeDate)) {
      throw new IllegalArgumentException(
          "Method whereMakeDateAfter, the parameter makeDate is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getMakeDateSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {makeDate});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest filterByMakeDate(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMakeDateSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectMakeDate() {
    return select(MAKE_DATE_PROPERTY);
  }

  public TransportTruckRequest unselectMakeDate() {
    return unselect(MAKE_DATE_PROPERTY);
  }

  public SearchCriteria getMakeDateSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MAKE_DATE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByMakeDate(boolean asc) {
    addOrderBy(MAKE_DATE_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByMakeDateAscending() {
    addOrderBy(MAKE_DATE_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByMakeDateDescending() {
    addOrderBy(MAKE_DATE_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest countMakeDate() {
    return countMakeDate("countMakeDate");
  }

  public TransportTruckRequest countMakeDate(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MAKE_DATE_PROPERTY);
  }

  public TransportTruckRequest maxMakeDate() {
    return maxMakeDate("maxMakeDate");
  }

  public TransportTruckRequest maxMakeDate(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MAKE_DATE_PROPERTY);
  }

  public TransportTruckRequest minMakeDate() {
    return minMakeDate("minMakeDate");
  }

  public TransportTruckRequest minMakeDate(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MAKE_DATE_PROPERTY);
  }

  public TransportTruckRequest groupByMakeDate() {
    return groupByMakeDate(MAKE_DATE_PROPERTY);
  }

  public TransportTruckRequest groupByMakeDate(String ret) {
    return groupBy(ret, MAKE_DATE_PROPERTY);
  }

  public TransportTruckRequest groupByMakeDate(SqlFunction func) {
    return groupByMakeDate(MAKE_DATE_PROPERTY, func);
  }

  public TransportTruckRequest groupByMakeDate(String ret, SqlFunction func) {
    super.groupBy(ret, func, MAKE_DATE_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByMileage(String mileage) {

    if (mileage == null) {
      return this;
    }

    return filterByMileage(QueryOperator.EQUAL, mileage);
  }

  public TransportTruckRequest whereMileageIsNull() {
    return where(MILEAGE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereMileageIsNotNull() {
    return where(MILEAGE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByMileage(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMileageSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectMileage() {
    return select(MILEAGE_PROPERTY);
  }

  public TransportTruckRequest unselectMileage() {
    return unselect(MILEAGE_PROPERTY);
  }

  public SearchCriteria getMileageSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MILEAGE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByMileage(boolean asc) {
    addOrderBy(MILEAGE_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByMileageAscending() {
    addOrderBy(MILEAGE_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByMileageDescending() {
    addOrderBy(MILEAGE_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByMileageAscendingUsingGBK() {
    addOrderBy("convert(mileage using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByMileageDescendingUsingGBK() {
    addOrderBy("convert(mileage using gbk)", false);
    return this;
  }

  public TransportTruckRequest countMileage() {
    return countMileage("countMileage");
  }

  public TransportTruckRequest countMileage(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MILEAGE_PROPERTY);
  }

  public TransportTruckRequest maxMileage() {
    return maxMileage("maxMileage");
  }

  public TransportTruckRequest maxMileage(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MILEAGE_PROPERTY);
  }

  public TransportTruckRequest minMileage() {
    return minMileage("minMileage");
  }

  public TransportTruckRequest minMileage(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MILEAGE_PROPERTY);
  }

  public TransportTruckRequest groupByMileage() {
    return groupByMileage(MILEAGE_PROPERTY);
  }

  public TransportTruckRequest groupByMileage(String ret) {
    return groupBy(ret, MILEAGE_PROPERTY);
  }

  public TransportTruckRequest groupByMileage(SqlFunction func) {
    return groupByMileage(MILEAGE_PROPERTY, func);
  }

  public TransportTruckRequest groupByMileage(String ret, SqlFunction func) {
    super.groupBy(ret, func, MILEAGE_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByBodyColor(String bodyColor) {

    if (bodyColor == null) {
      return this;
    }

    return filterByBodyColor(QueryOperator.EQUAL, bodyColor);
  }

  public TransportTruckRequest whereBodyColorIsNull() {
    return where(BODY_COLOR_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereBodyColorIsNotNull() {
    return where(BODY_COLOR_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByBodyColor(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBodyColorSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectBodyColor() {
    return select(BODY_COLOR_PROPERTY);
  }

  public TransportTruckRequest unselectBodyColor() {
    return unselect(BODY_COLOR_PROPERTY);
  }

  public SearchCriteria getBodyColorSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BODY_COLOR_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByBodyColor(boolean asc) {
    addOrderBy(BODY_COLOR_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByBodyColorAscending() {
    addOrderBy(BODY_COLOR_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByBodyColorDescending() {
    addOrderBy(BODY_COLOR_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest orderByBodyColorAscendingUsingGBK() {
    addOrderBy("convert(bodyColor using gbk)", true);
    return this;
  }

  public TransportTruckRequest orderByBodyColorDescendingUsingGBK() {
    addOrderBy("convert(bodyColor using gbk)", false);
    return this;
  }

  public TransportTruckRequest countBodyColor() {
    return countBodyColor("countBodyColor");
  }

  public TransportTruckRequest countBodyColor(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BODY_COLOR_PROPERTY);
  }

  public TransportTruckRequest maxBodyColor() {
    return maxBodyColor("maxBodyColor");
  }

  public TransportTruckRequest maxBodyColor(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BODY_COLOR_PROPERTY);
  }

  public TransportTruckRequest minBodyColor() {
    return minBodyColor("minBodyColor");
  }

  public TransportTruckRequest minBodyColor(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BODY_COLOR_PROPERTY);
  }

  public TransportTruckRequest groupByBodyColor() {
    return groupByBodyColor(BODY_COLOR_PROPERTY);
  }

  public TransportTruckRequest groupByBodyColor(String ret) {
    return groupBy(ret, BODY_COLOR_PROPERTY);
  }

  public TransportTruckRequest groupByBodyColor(SqlFunction func) {
    return groupByBodyColor(BODY_COLOR_PROPERTY, func);
  }

  public TransportTruckRequest groupByBodyColor(String ret, SqlFunction func) {
    super.groupBy(ret, func, BODY_COLOR_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TransportTruckRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTruckRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TransportTruckRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTruckRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TransportTruckRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TransportTruckRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TransportTruckRequest countVersion() {
    return countVersion("countVersion");
  }

  public TransportTruckRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TransportTruckRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TransportTruckRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TransportTruckRequest minVersion() {
    return minVersion("minVersion");
  }

  public TransportTruckRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TransportTruckRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TransportTruckRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TransportTruckRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TransportTruckRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TransportTruckRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TransportTruckRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TransportTruckRequest filterByOwner(TransportFleetRequest owner) {
    return filterByOwner(owner, TransportFleet::getId);
  }

  public TransportTruckRequest filterByOwner(TransportFleet... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(TransportFleet... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public TransportTruckRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public TransportFleetRequest upToOwner() {
    return upToOwner(TransportFleetRequest.newInstance());
  }

  public TransportFleetRequest upToOwner(TransportFleetRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public TransportFleetRequest endAtOwner(String retName) {
    return endAtOwner(retName, TransportFleetRequest.newInstance());
  }

  public TransportFleetRequest endAtOwner(String retName, TransportFleetRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public TransportTruckRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public TransportTruckRequest filterByOwner(
      TransportFleetRequest owner, IDRefine<TransportFleet> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      TransportFleetRequest owner, IDRefine<TransportFleet> idRefine) {
    return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine, TransportFleet.ID_PROPERTY);
  }

  public TransportTruckRequest selectOwner() {
    return selectOwner(TransportFleetRequest.newInstance().selectSelf());
  }

  public TransportTruckRequest selectOwner(TransportFleetRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public TransportTruckRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public TransportTruckRequest groupByOwner(TransportFleetRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public TransportTruckRequest aggregateOwner(TransportFleetRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public TransportTruckRequest countOwner() {
    return countOwner("countOwner");
  }

  public TransportTruckRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public TransportTruckRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public TransportTruckRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public TransportTruckRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTruckRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTruckRequest hasTransportTask() {
    return hasTransportTask(TransportTaskRequest.newInstance());
  }

  public TransportTruckRequest hasTransportTask(TransportTask... transportTask) {
    if (isEmptyParam(transportTask)) {
      throw new IllegalArgumentException("hasTransportTask(TransportTask... transportTask)参数不能为空!");
    }
    return hasTransportTask(
        Q.transportTask()
            .select(TransportTask.TRUCK_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) transportTask));
  }

  public TransportTruckRequest hasTransportTask(String... transportTask) {
    return hasTransportTask(
        Q.transportTask().select(TransportTask.TRUCK_PROPERTY).filterById(transportTask));
  }

  public TransportTruckRequest hasTransportTask(TransportTaskRequest transportTask) {
    return hasTransportTask(
        transportTask,
        $transportTask ->
            java.util.Optional.of($transportTask)
                .map(TransportTask::getTruck)
                .map(TransportTruck::getId)
                .orElse(null));
  }

  public TransportTruckRequest hasTransportTask(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    transportTask.select(TransportTask.TRUCK_PROPERTY);
    transportTask.unlimited();
    return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
  }

  public TransportTruckRequest hasTransportTask(
      TransportTaskRequest transportTask, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(transportTask, TransportTask.TRUCK_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTransportTaskCriteria(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    return new RefinedIdInCriteria(
        transportTask, ID_PROPERTY, idRefine, TransportTask.TRUCK_PROPERTY);
  }

  public TransportTruckRequest selectTransportTaskList(TransportTaskRequest transportTask) {
    selectChild(TransportTask.TRUCK_PROPERTY, transportTask);
    return this;
  }

  public TransportTruckRequest selectTransportTaskList() {
    return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
  }

  public TransportTruckRequest unselectTransportTaskList() {
    unselectChild(TransportTask.TRUCK_PROPERTY, TransportTask.class);
    return this;
  }

  public TransportTruckRequest aggregateTransportTaskList(TransportTaskRequest transportTask) {
    aggregateChild(TransportTask.TRUCK_PROPERTY, transportTask);
    return this;
  }

  public TransportTruckRequest countTransportTask() {
    return countTransportTask("transportTaskCount");
  }

  public TransportTruckRequest countTransportTask(String retName) {
    return countTransportTask(retName, TransportTaskRequest.newInstance());
  }

  public TransportTruckRequest countTransportTask(TransportTaskRequest transportTask) {
    return countTransportTask("transportTaskCount", transportTask);
  }

  public TransportTruckRequest countTransportTask(
      String retName, TransportTaskRequest transportTask) {
    transportTask.count();
    return statsFromTransportTask(retName, transportTask);
  }

  public TransportTruckRequest statsFromTransportTask(
      String retName, TransportTaskRequest transportTask) {
    return addDynamicProperty(retName, transportTask, TransportTask.TRUCK_PROPERTY);
  }

  public TransportTruckRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TransportTruckRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TransportTruckRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TransportTruckRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
