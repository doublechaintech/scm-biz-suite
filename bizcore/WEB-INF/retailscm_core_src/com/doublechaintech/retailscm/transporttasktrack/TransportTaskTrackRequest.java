package com.doublechaintech.retailscm.transporttasktrack;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;

import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transporttasktrack.TransportTaskTrack.*;

public class TransportTaskTrackRequest extends BaseRequest<TransportTaskTrack> {
  public static TransportTaskTrackRequest newInstance() {
    return new TransportTaskTrackRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TransportTaskTrackRequest resultByClass(Class<? extends TransportTaskTrack> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TransportTaskTrackRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TransportTaskTrackRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TransportTaskTrack";
  }

  public TransportTaskTrackRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TransportTaskTrackRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TransportTaskTrackRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TransportTaskTrackRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TransportTaskTrackRequest selectAll() {
    return this.selectId()
        .selectTrackTime()
        .selectLatitude()
        .selectLongitude()
        .selectMovement()
        .selectVersion();
  }

  public TransportTaskTrackRequest selectAny() {
    return selectAll();
  }

  public TransportTaskTrackRequest selectSelf() {
    select(ID_PROPERTY);
    select(TRACK_TIME_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(MOVEMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TransportTaskTrackRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TransportTaskTrackRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {TRACK_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    TRACK_TIME_PROPERTY,
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
    MOVEMENT_PROPERTY,
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

  public TransportTaskTrackRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TransportTaskTrackRequest comment(String comment) {
    return this;
  }

  public TransportTaskTrackRequest enhance() {
    return this;
  }

  public TransportTaskTrackRequest overrideClass(Class<? extends TransportTaskTrack> clazz) {
    return this;
  }

  public TransportTaskTrackRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TransportTaskTrackRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TransportTaskTrackRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TransportTaskTrackRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TransportTaskTrackRequest count() {
    return countId("count");
  }

  public static TransportTaskTrackRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TransportTaskTrackRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TransportTaskTrackRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TransportTaskTrackRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskTrackRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TransportTaskTrackRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TransportTaskTrackRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TransportTaskTrackRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TransportTaskTrackRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TransportTaskTrackRequest countId() {
    return countId("countId");
  }

  public TransportTaskTrackRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TransportTaskTrackRequest maxId() {
    return maxId("maxId");
  }

  public TransportTaskTrackRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TransportTaskTrackRequest minId() {
    return minId("minId");
  }

  public TransportTaskTrackRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TransportTaskTrackRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TransportTaskTrackRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TransportTaskTrackRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TransportTaskTrackRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TransportTaskTrackRequest filterByTrackTime(Date trackTime) {

    if (trackTime == null) {
      return this;
    }

    return filterByTrackTime(QueryOperator.EQUAL, trackTime);
  }

  public TransportTaskTrackRequest whereTrackTimeIsNull() {
    return where(TRACK_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskTrackRequest whereTrackTimeIsNotNull() {
    return where(TRACK_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskTrackRequest whereTrackTimeBetween(Date trackTimeStart, Date trackTimeEnd) {
    if (ObjectUtil.isEmpty(trackTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereTrackTimeBetween, the parameter trackTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(trackTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereTrackTimeBetween, the parameter trackTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTrackTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {trackTimeStart, trackTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest whereTrackTimeBefore(Date trackTime) {

    if (ObjectUtil.isEmpty(trackTime)) {
      throw new IllegalArgumentException(
          "Method whereTrackTimeBefore, the parameter trackTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getTrackTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {trackTime});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest whereTrackTimeAfter(Date trackTime) {
    if (ObjectUtil.isEmpty(trackTime)) {
      throw new IllegalArgumentException(
          "Method whereTrackTimeAfter, the parameter trackTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTrackTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {trackTime});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest filterByTrackTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTrackTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest selectTrackTime() {
    return select(TRACK_TIME_PROPERTY);
  }

  public TransportTaskTrackRequest unselectTrackTime() {
    return unselect(TRACK_TIME_PROPERTY);
  }

  public SearchCriteria getTrackTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TRACK_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskTrackRequest orderByTrackTime(boolean asc) {
    addOrderBy(TRACK_TIME_PROPERTY, asc);
    return this;
  }

  public TransportTaskTrackRequest orderByTrackTimeAscending() {
    addOrderBy(TRACK_TIME_PROPERTY, true);
    return this;
  }

  public TransportTaskTrackRequest orderByTrackTimeDescending() {
    addOrderBy(TRACK_TIME_PROPERTY, false);
    return this;
  }

  public TransportTaskTrackRequest countTrackTime() {
    return countTrackTime("countTrackTime");
  }

  public TransportTaskTrackRequest countTrackTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TRACK_TIME_PROPERTY);
  }

  public TransportTaskTrackRequest maxTrackTime() {
    return maxTrackTime("maxTrackTime");
  }

  public TransportTaskTrackRequest maxTrackTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TRACK_TIME_PROPERTY);
  }

  public TransportTaskTrackRequest minTrackTime() {
    return minTrackTime("minTrackTime");
  }

  public TransportTaskTrackRequest minTrackTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TRACK_TIME_PROPERTY);
  }

  public TransportTaskTrackRequest groupByTrackTime() {
    return groupByTrackTime(TRACK_TIME_PROPERTY);
  }

  public TransportTaskTrackRequest groupByTrackTime(String ret) {
    return groupBy(ret, TRACK_TIME_PROPERTY);
  }

  public TransportTaskTrackRequest groupByTrackTime(SqlFunction func) {
    return groupByTrackTime(TRACK_TIME_PROPERTY, func);
  }

  public TransportTaskTrackRequest groupByTrackTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, TRACK_TIME_PROPERTY);
    return this;
  }

  public TransportTaskTrackRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public TransportTaskTrackRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskTrackRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskTrackRequest whereLatitudeBetween(
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

  public TransportTaskTrackRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest filterByLatitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskTrackRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public TransportTaskTrackRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public TransportTaskTrackRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public TransportTaskTrackRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public TransportTaskTrackRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public TransportTaskTrackRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public TransportTaskTrackRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public TransportTaskTrackRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public TransportTaskTrackRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public TransportTaskTrackRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public TransportTaskTrackRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskTrackRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskTrackRequest whereLongitudeBetween(
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

  public TransportTaskTrackRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest filterByLongitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskTrackRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public TransportTaskTrackRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public TransportTaskTrackRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public TransportTaskTrackRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public TransportTaskTrackRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public TransportTaskTrackRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public TransportTaskTrackRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public TransportTaskTrackRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public TransportTaskTrackRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public TransportTaskTrackRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public TransportTaskTrackRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TransportTaskTrackRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskTrackRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskTrackRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportTaskTrackRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TransportTaskTrackRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportTaskTrackRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TransportTaskTrackRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TransportTaskTrackRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TransportTaskTrackRequest countVersion() {
    return countVersion("countVersion");
  }

  public TransportTaskTrackRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TransportTaskTrackRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TransportTaskTrackRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TransportTaskTrackRequest minVersion() {
    return minVersion("minVersion");
  }

  public TransportTaskTrackRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TransportTaskTrackRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TransportTaskTrackRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TransportTaskTrackRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TransportTaskTrackRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TransportTaskTrackRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TransportTaskTrackRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TransportTaskTrackRequest filterByMovement(TransportTaskRequest movement) {
    return filterByMovement(movement, TransportTask::getId);
  }

  public TransportTaskTrackRequest filterByMovement(TransportTask... movement) {
    if (isEmptyParam(movement)) {
      throw new IllegalArgumentException("filterByMovement(TransportTask... movement)参数不能为空!");
    }
    return where(MOVEMENT_PROPERTY, QueryOperator.IN, (Object[]) movement);
  }

  public TransportTaskTrackRequest selectMovementId() {
    select(MOVEMENT_PROPERTY);
    return this;
  }

  public TransportTaskRequest upToMovement() {
    return upToMovement(TransportTaskRequest.newInstance());
  }

  public TransportTaskRequest upToMovement(TransportTaskRequest movement) {
    movement.aggregateChild(MOVEMENT_PROPERTY, this);
    this.groupByMovement(movement);
    return movement;
  }

  public TransportTaskRequest endAtMovement(String retName) {
    return endAtMovement(retName, TransportTaskRequest.newInstance());
  }

  public TransportTaskRequest endAtMovement(String retName, TransportTaskRequest movement) {
    movement.addDynamicProperty(retName, this, MOVEMENT_PROPERTY);
    return movement;
  }

  public TransportTaskTrackRequest filterByMovement(String... movement) {
    if (isEmptyParam(movement)) {
      throw new IllegalArgumentException("filterByMovement(String... movement)参数不能为空!");
    }
    return where(MOVEMENT_PROPERTY, QueryOperator.IN, (Object[]) movement);
  }

  public TransportTaskTrackRequest filterByMovement(
      TransportTaskRequest movement, IDRefine<TransportTask> idRefine) {
    movement.unlimited();
    return addSearchCriteria(createMovementCriteria(movement, idRefine));
  }

  public SearchCriteria createMovementCriteria(
      TransportTaskRequest movement, IDRefine<TransportTask> idRefine) {
    return new RefinedIdInCriteria(
        movement, MOVEMENT_PROPERTY, idRefine, TransportTask.ID_PROPERTY);
  }

  public TransportTaskTrackRequest selectMovement() {
    return selectMovement(TransportTaskRequest.newInstance().selectSelf());
  }

  public TransportTaskTrackRequest selectMovement(TransportTaskRequest movement) {
    selectParent(MOVEMENT_PROPERTY, movement);
    return this;
  }

  public TransportTaskTrackRequest unselectMovement() {
    unselectParent(MOVEMENT_PROPERTY);
    return this;
  }

  public TransportTaskTrackRequest groupByMovement(TransportTaskRequest movement) {
    groupBy(MOVEMENT_PROPERTY, movement);
    return this;
  }

  public TransportTaskTrackRequest aggregateMovement(TransportTaskRequest movement) {
    aggregateParent(MOVEMENT_PROPERTY, movement);
    return this;
  }

  public TransportTaskTrackRequest countMovement() {
    return countMovement("countMovement");
  }

  public TransportTaskTrackRequest countMovement(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOVEMENT_PROPERTY);
  }

  public TransportTaskTrackRequest groupByMovement() {
    return groupByMovement(MOVEMENT_PROPERTY);
  }

  public TransportTaskTrackRequest groupByMovement(String ret) {
    return groupBy(ret, MOVEMENT_PROPERTY);
  }

  public TransportTaskTrackRequest whereMovementIsNull() {
    return where(MOVEMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportTaskTrackRequest whereMovementIsNotNull() {
    return where(MOVEMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportTaskTrackRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TransportTaskTrackRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TransportTaskTrackRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TransportTaskTrackRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
