package com.doublechaintech.retailscm.transporttask;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrackRequest;
import com.doublechaintech.retailscm.transporttruck.TransportTruckRequest;
import com.doublechaintech.retailscm.truckdriver.TruckDriverRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transporttask.TransportTask.*;

public class TransportTaskRequest extends BaseRequest<TransportTask> {
  public static TransportTaskRequest newInstance() {
    return new TransportTaskRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TransportTaskRequest resultByClass(Class<? extends TransportTask> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TransportTaskRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TransportTaskRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TransportTask";
  }

  public TransportTaskRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TransportTaskRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TransportTaskRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TransportTaskRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TransportTaskRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectStart()
        .selectBeginTime()
        .selectEnd()
        .selectDriver()
        .selectTruck()
        .selectBelongsTo()
        .selectLatitude()
        .selectLongitude()
        .selectVersion();
  }

  public TransportTaskRequest selectAny() {
    return selectAll()
        .selectGoodsList(Q.goods().selectSelf())
        .selectTransportTaskTrackList(Q.transportTaskTrack().selectSelf());
  }

  public TransportTaskRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(START_PROPERTY);
    select(BEGIN_TIME_PROPERTY);
    select(END_PROPERTY);
    select(DRIVER_PROPERTY);
    select(TRUCK_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TransportTaskRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TransportTaskRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {BEGIN_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    START_PROPERTY,
    BEGIN_TIME_PROPERTY,
    END_PROPERTY,
    DRIVER_PROPERTY,
    TRUCK_PROPERTY,
    BELONGS_TO_PROPERTY,
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
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

  public TransportTaskRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TransportTaskRequest comment(String comment) {
    return this;
  }

  public TransportTaskRequest enhance() {
    return this;
  }

  public TransportTaskRequest overrideClass(Class<? extends TransportTask> clazz) {
    return this;
  }

  public TransportTaskRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TransportTaskRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TransportTaskRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TransportTaskRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TransportTaskRequest count() {
    return countId("count");
  }

  public static TransportTaskRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TransportTaskRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TransportTaskRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TransportTaskRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TransportTaskRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TransportTaskRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TransportTaskRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TransportTaskRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TransportTaskRequest countId() {
    return countId("countId");
  }

  public TransportTaskRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TransportTaskRequest maxId() {
    return maxId("maxId");
  }

  public TransportTaskRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TransportTaskRequest minId() {
    return minId("minId");
  }

  public TransportTaskRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TransportTaskRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TransportTaskRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TransportTaskRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TransportTaskRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TransportTaskRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public TransportTaskRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public TransportTaskRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public TransportTaskRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public TransportTaskRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public TransportTaskRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public TransportTaskRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public TransportTaskRequest countName() {
    return countName("countName");
  }

  public TransportTaskRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public TransportTaskRequest maxName() {
    return maxName("maxName");
  }

  public TransportTaskRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public TransportTaskRequest minName() {
    return minName("minName");
  }

  public TransportTaskRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public TransportTaskRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public TransportTaskRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public TransportTaskRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public TransportTaskRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public TransportTaskRequest filterByStart(String start) {

    if (start == null) {
      return this;
    }

    return filterByStart(QueryOperator.EQUAL, start);
  }

  public TransportTaskRequest whereStartIsNull() {
    return where(START_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereStartIsNotNull() {
    return where(START_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest filterByStart(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getStartSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest selectStart() {
    return select(START_PROPERTY);
  }

  public TransportTaskRequest unselectStart() {
    return unselect(START_PROPERTY);
  }

  public SearchCriteria getStartSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(START_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskRequest orderByStart(boolean asc) {
    addOrderBy(START_PROPERTY, asc);
    return this;
  }

  public TransportTaskRequest orderByStartAscending() {
    addOrderBy(START_PROPERTY, true);
    return this;
  }

  public TransportTaskRequest orderByStartDescending() {
    addOrderBy(START_PROPERTY, false);
    return this;
  }

  public TransportTaskRequest orderByStartAscendingUsingGBK() {
    addOrderBy("convert(start using gbk)", true);
    return this;
  }

  public TransportTaskRequest orderByStartDescendingUsingGBK() {
    addOrderBy("convert(start using gbk)", false);
    return this;
  }

  public TransportTaskRequest countStart() {
    return countStart("countStart");
  }

  public TransportTaskRequest countStart(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, START_PROPERTY);
  }

  public TransportTaskRequest maxStart() {
    return maxStart("maxStart");
  }

  public TransportTaskRequest maxStart(String aggName) {
    return aggregate(aggName, AggFunc.MAX, START_PROPERTY);
  }

  public TransportTaskRequest minStart() {
    return minStart("minStart");
  }

  public TransportTaskRequest minStart(String aggName) {
    return aggregate(aggName, AggFunc.MIN, START_PROPERTY);
  }

  public TransportTaskRequest groupByStart() {
    return groupByStart(START_PROPERTY);
  }

  public TransportTaskRequest groupByStart(String ret) {
    return groupBy(ret, START_PROPERTY);
  }

  public TransportTaskRequest groupByStart(SqlFunction func) {
    return groupByStart(START_PROPERTY, func);
  }

  public TransportTaskRequest groupByStart(String ret, SqlFunction func) {
    super.groupBy(ret, func, START_PROPERTY);
    return this;
  }

  public TransportTaskRequest filterByBeginTime(Date beginTime) {

    if (beginTime == null) {
      return this;
    }

    return filterByBeginTime(QueryOperator.EQUAL, beginTime);
  }

  public TransportTaskRequest whereBeginTimeIsNull() {
    return where(BEGIN_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereBeginTimeIsNotNull() {
    return where(BEGIN_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest whereBeginTimeBetween(Date beginTimeStart, Date beginTimeEnd) {
    if (ObjectUtil.isEmpty(beginTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereBeginTimeBetween, the parameter beginTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(beginTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereBeginTimeBetween, the parameter beginTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBeginTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {beginTimeStart, beginTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest whereBeginTimeBefore(Date beginTime) {

    if (ObjectUtil.isEmpty(beginTime)) {
      throw new IllegalArgumentException(
          "Method whereBeginTimeBefore, the parameter beginTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getBeginTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {beginTime});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest whereBeginTimeAfter(Date beginTime) {
    if (ObjectUtil.isEmpty(beginTime)) {
      throw new IllegalArgumentException(
          "Method whereBeginTimeAfter, the parameter beginTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBeginTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {beginTime});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest filterByBeginTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBeginTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest selectBeginTime() {
    return select(BEGIN_TIME_PROPERTY);
  }

  public TransportTaskRequest unselectBeginTime() {
    return unselect(BEGIN_TIME_PROPERTY);
  }

  public SearchCriteria getBeginTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BEGIN_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskRequest orderByBeginTime(boolean asc) {
    addOrderBy(BEGIN_TIME_PROPERTY, asc);
    return this;
  }

  public TransportTaskRequest orderByBeginTimeAscending() {
    addOrderBy(BEGIN_TIME_PROPERTY, true);
    return this;
  }

  public TransportTaskRequest orderByBeginTimeDescending() {
    addOrderBy(BEGIN_TIME_PROPERTY, false);
    return this;
  }

  public TransportTaskRequest countBeginTime() {
    return countBeginTime("countBeginTime");
  }

  public TransportTaskRequest countBeginTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BEGIN_TIME_PROPERTY);
  }

  public TransportTaskRequest maxBeginTime() {
    return maxBeginTime("maxBeginTime");
  }

  public TransportTaskRequest maxBeginTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BEGIN_TIME_PROPERTY);
  }

  public TransportTaskRequest minBeginTime() {
    return minBeginTime("minBeginTime");
  }

  public TransportTaskRequest minBeginTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BEGIN_TIME_PROPERTY);
  }

  public TransportTaskRequest groupByBeginTime() {
    return groupByBeginTime(BEGIN_TIME_PROPERTY);
  }

  public TransportTaskRequest groupByBeginTime(String ret) {
    return groupBy(ret, BEGIN_TIME_PROPERTY);
  }

  public TransportTaskRequest groupByBeginTime(SqlFunction func) {
    return groupByBeginTime(BEGIN_TIME_PROPERTY, func);
  }

  public TransportTaskRequest groupByBeginTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, BEGIN_TIME_PROPERTY);
    return this;
  }

  public TransportTaskRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public TransportTaskRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest whereLatitudeBetween(
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

  public TransportTaskRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public TransportTaskRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public TransportTaskRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public TransportTaskRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public TransportTaskRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public TransportTaskRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public TransportTaskRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public TransportTaskRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public TransportTaskRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public TransportTaskRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public TransportTaskRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public TransportTaskRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public TransportTaskRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public TransportTaskRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public TransportTaskRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public TransportTaskRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public TransportTaskRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public TransportTaskRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest whereLongitudeBetween(
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

  public TransportTaskRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest filterByLongitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public TransportTaskRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public TransportTaskRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public TransportTaskRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public TransportTaskRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public TransportTaskRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public TransportTaskRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public TransportTaskRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public TransportTaskRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public TransportTaskRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public TransportTaskRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public TransportTaskRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public TransportTaskRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public TransportTaskRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public TransportTaskRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public TransportTaskRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public TransportTaskRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TransportTaskRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TransportTaskRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TransportTaskRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TransportTaskRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TransportTaskRequest countVersion() {
    return countVersion("countVersion");
  }

  public TransportTaskRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TransportTaskRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TransportTaskRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TransportTaskRequest minVersion() {
    return minVersion("minVersion");
  }

  public TransportTaskRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TransportTaskRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TransportTaskRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TransportTaskRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TransportTaskRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TransportTaskRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TransportTaskRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TransportTaskRequest filterByEnd(RetailStoreRequest end) {
    return filterByEnd(end, RetailStore::getId);
  }

  public TransportTaskRequest filterByEnd(RetailStore... end) {
    if (isEmptyParam(end)) {
      throw new IllegalArgumentException("filterByEnd(RetailStore... end)参数不能为空!");
    }
    return where(END_PROPERTY, QueryOperator.IN, (Object[]) end);
  }

  public TransportTaskRequest selectEndId() {
    select(END_PROPERTY);
    return this;
  }

  public RetailStoreRequest upToEnd() {
    return upToEnd(RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest upToEnd(RetailStoreRequest end) {
    end.aggregateChild(END_PROPERTY, this);
    this.groupByEnd(end);
    return end;
  }

  public RetailStoreRequest endAtEnd(String retName) {
    return endAtEnd(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest endAtEnd(String retName, RetailStoreRequest end) {
    end.addDynamicProperty(retName, this, END_PROPERTY);
    return end;
  }

  public TransportTaskRequest filterByEnd(String... end) {
    if (isEmptyParam(end)) {
      throw new IllegalArgumentException("filterByEnd(String... end)参数不能为空!");
    }
    return where(END_PROPERTY, QueryOperator.IN, (Object[]) end);
  }

  public TransportTaskRequest filterByEnd(RetailStoreRequest end, IDRefine<RetailStore> idRefine) {
    end.unlimited();
    return addSearchCriteria(createEndCriteria(end, idRefine));
  }

  public SearchCriteria createEndCriteria(RetailStoreRequest end, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(end, END_PROPERTY, idRefine, RetailStore.ID_PROPERTY);
  }

  public TransportTaskRequest selectEnd() {
    return selectEnd(RetailStoreRequest.newInstance().selectSelf());
  }

  public TransportTaskRequest selectEnd(RetailStoreRequest end) {
    selectParent(END_PROPERTY, end);
    return this;
  }

  public TransportTaskRequest unselectEnd() {
    unselectParent(END_PROPERTY);
    return this;
  }

  public TransportTaskRequest groupByEnd(RetailStoreRequest end) {
    groupBy(END_PROPERTY, end);
    return this;
  }

  public TransportTaskRequest aggregateEnd(RetailStoreRequest end) {
    aggregateParent(END_PROPERTY, end);
    return this;
  }

  public TransportTaskRequest countEnd() {
    return countEnd("countEnd");
  }

  public TransportTaskRequest countEnd(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, END_PROPERTY);
  }

  public TransportTaskRequest groupByEnd() {
    return groupByEnd(END_PROPERTY);
  }

  public TransportTaskRequest groupByEnd(String ret) {
    return groupBy(ret, END_PROPERTY);
  }

  public TransportTaskRequest whereEndIsNull() {
    return where(END_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereEndIsNotNull() {
    return where(END_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest filterByDriver(TruckDriverRequest driver) {
    return filterByDriver(driver, TruckDriver::getId);
  }

  public TransportTaskRequest filterByDriver(TruckDriver... driver) {
    if (isEmptyParam(driver)) {
      throw new IllegalArgumentException("filterByDriver(TruckDriver... driver)参数不能为空!");
    }
    return where(DRIVER_PROPERTY, QueryOperator.IN, (Object[]) driver);
  }

  public TransportTaskRequest selectDriverId() {
    select(DRIVER_PROPERTY);
    return this;
  }

  public TruckDriverRequest upToDriver() {
    return upToDriver(TruckDriverRequest.newInstance());
  }

  public TruckDriverRequest upToDriver(TruckDriverRequest driver) {
    driver.aggregateChild(DRIVER_PROPERTY, this);
    this.groupByDriver(driver);
    return driver;
  }

  public TruckDriverRequest endAtDriver(String retName) {
    return endAtDriver(retName, TruckDriverRequest.newInstance());
  }

  public TruckDriverRequest endAtDriver(String retName, TruckDriverRequest driver) {
    driver.addDynamicProperty(retName, this, DRIVER_PROPERTY);
    return driver;
  }

  public TransportTaskRequest filterByDriver(String... driver) {
    if (isEmptyParam(driver)) {
      throw new IllegalArgumentException("filterByDriver(String... driver)参数不能为空!");
    }
    return where(DRIVER_PROPERTY, QueryOperator.IN, (Object[]) driver);
  }

  public TransportTaskRequest filterByDriver(
      TruckDriverRequest driver, IDRefine<TruckDriver> idRefine) {
    driver.unlimited();
    return addSearchCriteria(createDriverCriteria(driver, idRefine));
  }

  public SearchCriteria createDriverCriteria(
      TruckDriverRequest driver, IDRefine<TruckDriver> idRefine) {
    return new RefinedIdInCriteria(driver, DRIVER_PROPERTY, idRefine, TruckDriver.ID_PROPERTY);
  }

  public TransportTaskRequest selectDriver() {
    return selectDriver(TruckDriverRequest.newInstance().selectSelf());
  }

  public TransportTaskRequest selectDriver(TruckDriverRequest driver) {
    selectParent(DRIVER_PROPERTY, driver);
    return this;
  }

  public TransportTaskRequest unselectDriver() {
    unselectParent(DRIVER_PROPERTY);
    return this;
  }

  public TransportTaskRequest groupByDriver(TruckDriverRequest driver) {
    groupBy(DRIVER_PROPERTY, driver);
    return this;
  }

  public TransportTaskRequest aggregateDriver(TruckDriverRequest driver) {
    aggregateParent(DRIVER_PROPERTY, driver);
    return this;
  }

  public TransportTaskRequest countDriver() {
    return countDriver("countDriver");
  }

  public TransportTaskRequest countDriver(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DRIVER_PROPERTY);
  }

  public TransportTaskRequest groupByDriver() {
    return groupByDriver(DRIVER_PROPERTY);
  }

  public TransportTaskRequest groupByDriver(String ret) {
    return groupBy(ret, DRIVER_PROPERTY);
  }

  public TransportTaskRequest whereDriverIsNull() {
    return where(DRIVER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereDriverIsNotNull() {
    return where(DRIVER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest filterByTruck(TransportTruckRequest truck) {
    return filterByTruck(truck, TransportTruck::getId);
  }

  public TransportTaskRequest filterByTruck(TransportTruck... truck) {
    if (isEmptyParam(truck)) {
      throw new IllegalArgumentException("filterByTruck(TransportTruck... truck)参数不能为空!");
    }
    return where(TRUCK_PROPERTY, QueryOperator.IN, (Object[]) truck);
  }

  public TransportTaskRequest selectTruckId() {
    select(TRUCK_PROPERTY);
    return this;
  }

  public TransportTruckRequest upToTruck() {
    return upToTruck(TransportTruckRequest.newInstance());
  }

  public TransportTruckRequest upToTruck(TransportTruckRequest truck) {
    truck.aggregateChild(TRUCK_PROPERTY, this);
    this.groupByTruck(truck);
    return truck;
  }

  public TransportTruckRequest endAtTruck(String retName) {
    return endAtTruck(retName, TransportTruckRequest.newInstance());
  }

  public TransportTruckRequest endAtTruck(String retName, TransportTruckRequest truck) {
    truck.addDynamicProperty(retName, this, TRUCK_PROPERTY);
    return truck;
  }

  public TransportTaskRequest filterByTruck(String... truck) {
    if (isEmptyParam(truck)) {
      throw new IllegalArgumentException("filterByTruck(String... truck)参数不能为空!");
    }
    return where(TRUCK_PROPERTY, QueryOperator.IN, (Object[]) truck);
  }

  public TransportTaskRequest filterByTruck(
      TransportTruckRequest truck, IDRefine<TransportTruck> idRefine) {
    truck.unlimited();
    return addSearchCriteria(createTruckCriteria(truck, idRefine));
  }

  public SearchCriteria createTruckCriteria(
      TransportTruckRequest truck, IDRefine<TransportTruck> idRefine) {
    return new RefinedIdInCriteria(truck, TRUCK_PROPERTY, idRefine, TransportTruck.ID_PROPERTY);
  }

  public TransportTaskRequest selectTruck() {
    return selectTruck(TransportTruckRequest.newInstance().selectSelf());
  }

  public TransportTaskRequest selectTruck(TransportTruckRequest truck) {
    selectParent(TRUCK_PROPERTY, truck);
    return this;
  }

  public TransportTaskRequest unselectTruck() {
    unselectParent(TRUCK_PROPERTY);
    return this;
  }

  public TransportTaskRequest groupByTruck(TransportTruckRequest truck) {
    groupBy(TRUCK_PROPERTY, truck);
    return this;
  }

  public TransportTaskRequest aggregateTruck(TransportTruckRequest truck) {
    aggregateParent(TRUCK_PROPERTY, truck);
    return this;
  }

  public TransportTaskRequest countTruck() {
    return countTruck("countTruck");
  }

  public TransportTaskRequest countTruck(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TRUCK_PROPERTY);
  }

  public TransportTaskRequest groupByTruck() {
    return groupByTruck(TRUCK_PROPERTY);
  }

  public TransportTaskRequest groupByTruck(String ret) {
    return groupBy(ret, TRUCK_PROPERTY);
  }

  public TransportTaskRequest whereTruckIsNull() {
    return where(TRUCK_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereTruckIsNotNull() {
    return where(TRUCK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest filterByBelongsTo(TransportFleetRequest belongsTo) {
    return filterByBelongsTo(belongsTo, TransportFleet::getId);
  }

  public TransportTaskRequest filterByBelongsTo(TransportFleet... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(TransportFleet... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public TransportTaskRequest selectBelongsToId() {
    select(BELONGS_TO_PROPERTY);
    return this;
  }

  public TransportFleetRequest upToBelongsTo() {
    return upToBelongsTo(TransportFleetRequest.newInstance());
  }

  public TransportFleetRequest upToBelongsTo(TransportFleetRequest belongsTo) {
    belongsTo.aggregateChild(BELONGS_TO_PROPERTY, this);
    this.groupByBelongsTo(belongsTo);
    return belongsTo;
  }

  public TransportFleetRequest endAtBelongsTo(String retName) {
    return endAtBelongsTo(retName, TransportFleetRequest.newInstance());
  }

  public TransportFleetRequest endAtBelongsTo(String retName, TransportFleetRequest belongsTo) {
    belongsTo.addDynamicProperty(retName, this, BELONGS_TO_PROPERTY);
    return belongsTo;
  }

  public TransportTaskRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public TransportTaskRequest filterByBelongsTo(
      TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, TransportFleet.ID_PROPERTY);
  }

  public TransportTaskRequest selectBelongsTo() {
    return selectBelongsTo(TransportFleetRequest.newInstance().selectSelf());
  }

  public TransportTaskRequest selectBelongsTo(TransportFleetRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public TransportTaskRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public TransportTaskRequest groupByBelongsTo(TransportFleetRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public TransportTaskRequest aggregateBelongsTo(TransportFleetRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public TransportTaskRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public TransportTaskRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public TransportTaskRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public TransportTaskRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public TransportTaskRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public TransportTaskRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods()
            .select(Goods.TRANSPORT_TASK_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goods));
  }

  public TransportTaskRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.TRANSPORT_TASK_PROPERTY).filterById(goods));
  }

  public TransportTaskRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getTransportTask)
                .map(TransportTask::getId)
                .orElse(null));
  }

  public TransportTaskRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.TRANSPORT_TASK_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public TransportTaskRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.TRANSPORT_TASK_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.TRANSPORT_TASK_PROPERTY);
  }

  public TransportTaskRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.TRANSPORT_TASK_PROPERTY, goods);
    return this;
  }

  public TransportTaskRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public TransportTaskRequest unselectGoodsList() {
    unselectChild(Goods.TRANSPORT_TASK_PROPERTY, Goods.class);
    return this;
  }

  public TransportTaskRequest hasTransportTaskTrack() {
    return hasTransportTaskTrack(TransportTaskTrackRequest.newInstance());
  }

  public TransportTaskRequest hasTransportTaskTrack(TransportTaskTrack... transportTaskTrack) {
    if (isEmptyParam(transportTaskTrack)) {
      throw new IllegalArgumentException(
          "hasTransportTaskTrack(TransportTaskTrack... transportTaskTrack)参数不能为空!");
    }
    return hasTransportTaskTrack(
        Q.transportTaskTrack()
            .select(TransportTaskTrack.MOVEMENT_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) transportTaskTrack));
  }

  public TransportTaskRequest hasTransportTaskTrack(String... transportTaskTrack) {
    return hasTransportTaskTrack(
        Q.transportTaskTrack()
            .select(TransportTaskTrack.MOVEMENT_PROPERTY)
            .filterById(transportTaskTrack));
  }

  public TransportTaskRequest hasTransportTaskTrack(TransportTaskTrackRequest transportTaskTrack) {
    return hasTransportTaskTrack(
        transportTaskTrack,
        $transportTaskTrack ->
            java.util.Optional.of($transportTaskTrack)
                .map(TransportTaskTrack::getMovement)
                .map(TransportTask::getId)
                .orElse(null));
  }

  public TransportTaskRequest hasTransportTaskTrack(
      TransportTaskTrackRequest transportTaskTrack, IDRefine<TransportTaskTrack> idRefine) {
    transportTaskTrack.select(TransportTaskTrack.MOVEMENT_PROPERTY);
    transportTaskTrack.unlimited();
    return addSearchCriteria(createTransportTaskTrackCriteria(transportTaskTrack, idRefine));
  }

  public TransportTaskRequest hasTransportTaskTrack(
      TransportTaskTrackRequest transportTaskTrack, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            transportTaskTrack, TransportTaskTrack.MOVEMENT_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTransportTaskTrackCriteria(
      TransportTaskTrackRequest transportTaskTrack, IDRefine<TransportTaskTrack> idRefine) {
    return new RefinedIdInCriteria(
        transportTaskTrack, ID_PROPERTY, idRefine, TransportTaskTrack.MOVEMENT_PROPERTY);
  }

  public TransportTaskRequest selectTransportTaskTrackList(
      TransportTaskTrackRequest transportTaskTrack) {
    selectChild(TransportTaskTrack.MOVEMENT_PROPERTY, transportTaskTrack);
    return this;
  }

  public TransportTaskRequest selectTransportTaskTrackList() {
    return selectTransportTaskTrackList(TransportTaskTrackRequest.newInstance().selectAll());
  }

  public TransportTaskRequest unselectTransportTaskTrackList() {
    unselectChild(TransportTaskTrack.MOVEMENT_PROPERTY, TransportTaskTrack.class);
    return this;
  }

  public TransportTaskRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.TRANSPORT_TASK_PROPERTY, goods);
    return this;
  }

  public TransportTaskRequest countGoods() {
    return countGoods("goodsCount");
  }

  public TransportTaskRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public TransportTaskRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public TransportTaskRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public TransportTaskRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.TRANSPORT_TASK_PROPERTY);
  }

  public TransportTaskRequest aggregateTransportTaskTrackList(
      TransportTaskTrackRequest transportTaskTrack) {
    aggregateChild(TransportTaskTrack.MOVEMENT_PROPERTY, transportTaskTrack);
    return this;
  }

  public TransportTaskRequest countTransportTaskTrack() {
    return countTransportTaskTrack("transportTaskTrackCount");
  }

  public TransportTaskRequest countTransportTaskTrack(String retName) {
    return countTransportTaskTrack(retName, TransportTaskTrackRequest.newInstance());
  }

  public TransportTaskRequest countTransportTaskTrack(
      TransportTaskTrackRequest transportTaskTrack) {
    return countTransportTaskTrack("transportTaskTrackCount", transportTaskTrack);
  }

  public TransportTaskRequest countTransportTaskTrack(
      String retName, TransportTaskTrackRequest transportTaskTrack) {
    transportTaskTrack.count();
    return statsFromTransportTaskTrack(retName, transportTaskTrack);
  }

  public TransportTaskRequest statsFromTransportTaskTrack(
      String retName, TransportTaskTrackRequest transportTaskTrack) {
    return addDynamicProperty(retName, transportTaskTrack, TransportTaskTrack.MOVEMENT_PROPERTY);
  }

  public TransportTaskRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TransportTaskRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TransportTaskRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TransportTaskRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
