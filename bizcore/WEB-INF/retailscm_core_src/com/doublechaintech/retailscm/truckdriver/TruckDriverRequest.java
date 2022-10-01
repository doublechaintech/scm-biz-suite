package com.doublechaintech.retailscm.truckdriver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.truckdriver.TruckDriver.*;

public class TruckDriverRequest extends BaseRequest<TruckDriver> {
  public static TruckDriverRequest newInstance() {
    return new TruckDriverRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TruckDriverRequest resultByClass(Class<? extends TruckDriver> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TruckDriverRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TruckDriverRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TruckDriver";
  }

  public TruckDriverRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TruckDriverRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TruckDriverRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TruckDriverRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TruckDriverRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectDriverLicenseNumber()
        .selectContactNumber()
        .selectBelongsTo()
        .selectVersion();
  }

  public TruckDriverRequest selectAny() {
    return selectAll().selectTransportTaskList(Q.transportTask().selectSelf());
  }

  public TruckDriverRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(DRIVER_LICENSE_NUMBER_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TruckDriverRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TruckDriverRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    DRIVER_LICENSE_NUMBER_PROPERTY,
    CONTACT_NUMBER_PROPERTY,
    BELONGS_TO_PROPERTY,
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

  public TruckDriverRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TruckDriverRequest comment(String comment) {
    return this;
  }

  public TruckDriverRequest enhance() {
    return this;
  }

  public TruckDriverRequest overrideClass(Class<? extends TruckDriver> clazz) {
    return this;
  }

  public TruckDriverRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TruckDriverRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TruckDriverRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TruckDriverRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TruckDriverRequest count() {
    return countId("count");
  }

  public static TruckDriverRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TruckDriverRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TruckDriverRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TruckDriverRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TruckDriverRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TruckDriverRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TruckDriverRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TruckDriverRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TruckDriverRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TruckDriverRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TruckDriverRequest countId() {
    return countId("countId");
  }

  public TruckDriverRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TruckDriverRequest maxId() {
    return maxId("maxId");
  }

  public TruckDriverRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TruckDriverRequest minId() {
    return minId("minId");
  }

  public TruckDriverRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TruckDriverRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TruckDriverRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TruckDriverRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TruckDriverRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TruckDriverRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public TruckDriverRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TruckDriverRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TruckDriverRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TruckDriverRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public TruckDriverRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TruckDriverRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public TruckDriverRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public TruckDriverRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public TruckDriverRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public TruckDriverRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public TruckDriverRequest countName() {
    return countName("countName");
  }

  public TruckDriverRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public TruckDriverRequest maxName() {
    return maxName("maxName");
  }

  public TruckDriverRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public TruckDriverRequest minName() {
    return minName("minName");
  }

  public TruckDriverRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public TruckDriverRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public TruckDriverRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public TruckDriverRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public TruckDriverRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public TruckDriverRequest filterByDriverLicenseNumber(String driverLicenseNumber) {

    if (driverLicenseNumber == null) {
      return this;
    }

    return filterByDriverLicenseNumber(QueryOperator.EQUAL, driverLicenseNumber);
  }

  public TruckDriverRequest whereDriverLicenseNumberIsNull() {
    return where(DRIVER_LICENSE_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TruckDriverRequest whereDriverLicenseNumberIsNotNull() {
    return where(DRIVER_LICENSE_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TruckDriverRequest filterByDriverLicenseNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getDriverLicenseNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TruckDriverRequest selectDriverLicenseNumber() {
    return select(DRIVER_LICENSE_NUMBER_PROPERTY);
  }

  public TruckDriverRequest unselectDriverLicenseNumber() {
    return unselect(DRIVER_LICENSE_NUMBER_PROPERTY);
  }

  public SearchCriteria getDriverLicenseNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DRIVER_LICENSE_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TruckDriverRequest orderByDriverLicenseNumber(boolean asc) {
    addOrderBy(DRIVER_LICENSE_NUMBER_PROPERTY, asc);
    return this;
  }

  public TruckDriverRequest orderByDriverLicenseNumberAscending() {
    addOrderBy(DRIVER_LICENSE_NUMBER_PROPERTY, true);
    return this;
  }

  public TruckDriverRequest orderByDriverLicenseNumberDescending() {
    addOrderBy(DRIVER_LICENSE_NUMBER_PROPERTY, false);
    return this;
  }

  public TruckDriverRequest orderByDriverLicenseNumberAscendingUsingGBK() {
    addOrderBy("convert(driverLicenseNumber using gbk)", true);
    return this;
  }

  public TruckDriverRequest orderByDriverLicenseNumberDescendingUsingGBK() {
    addOrderBy("convert(driverLicenseNumber using gbk)", false);
    return this;
  }

  public TruckDriverRequest countDriverLicenseNumber() {
    return countDriverLicenseNumber("countDriverLicenseNumber");
  }

  public TruckDriverRequest countDriverLicenseNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DRIVER_LICENSE_NUMBER_PROPERTY);
  }

  public TruckDriverRequest maxDriverLicenseNumber() {
    return maxDriverLicenseNumber("maxDriverLicenseNumber");
  }

  public TruckDriverRequest maxDriverLicenseNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DRIVER_LICENSE_NUMBER_PROPERTY);
  }

  public TruckDriverRequest minDriverLicenseNumber() {
    return minDriverLicenseNumber("minDriverLicenseNumber");
  }

  public TruckDriverRequest minDriverLicenseNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DRIVER_LICENSE_NUMBER_PROPERTY);
  }

  public TruckDriverRequest groupByDriverLicenseNumber() {
    return groupByDriverLicenseNumber(DRIVER_LICENSE_NUMBER_PROPERTY);
  }

  public TruckDriverRequest groupByDriverLicenseNumber(String ret) {
    return groupBy(ret, DRIVER_LICENSE_NUMBER_PROPERTY);
  }

  public TruckDriverRequest groupByDriverLicenseNumber(SqlFunction func) {
    return groupByDriverLicenseNumber(DRIVER_LICENSE_NUMBER_PROPERTY, func);
  }

  public TruckDriverRequest groupByDriverLicenseNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, DRIVER_LICENSE_NUMBER_PROPERTY);
    return this;
  }

  public TruckDriverRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public TruckDriverRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TruckDriverRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TruckDriverRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TruckDriverRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public TruckDriverRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TruckDriverRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public TruckDriverRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public TruckDriverRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public TruckDriverRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public TruckDriverRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public TruckDriverRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public TruckDriverRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public TruckDriverRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public TruckDriverRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public TruckDriverRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public TruckDriverRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public TruckDriverRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public TruckDriverRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public TruckDriverRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public TruckDriverRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public TruckDriverRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TruckDriverRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TruckDriverRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TruckDriverRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TruckDriverRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TruckDriverRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TruckDriverRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TruckDriverRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TruckDriverRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TruckDriverRequest countVersion() {
    return countVersion("countVersion");
  }

  public TruckDriverRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TruckDriverRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TruckDriverRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TruckDriverRequest minVersion() {
    return minVersion("minVersion");
  }

  public TruckDriverRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TruckDriverRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TruckDriverRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TruckDriverRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TruckDriverRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TruckDriverRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TruckDriverRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TruckDriverRequest filterByBelongsTo(TransportFleetRequest belongsTo) {
    return filterByBelongsTo(belongsTo, TransportFleet::getId);
  }

  public TruckDriverRequest filterByBelongsTo(TransportFleet... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(TransportFleet... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public TruckDriverRequest selectBelongsToId() {
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

  public TruckDriverRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public TruckDriverRequest filterByBelongsTo(
      TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      TransportFleetRequest belongsTo, IDRefine<TransportFleet> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, TransportFleet.ID_PROPERTY);
  }

  public TruckDriverRequest selectBelongsTo() {
    return selectBelongsTo(TransportFleetRequest.newInstance().selectSelf());
  }

  public TruckDriverRequest selectBelongsTo(TransportFleetRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public TruckDriverRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public TruckDriverRequest groupByBelongsTo(TransportFleetRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public TruckDriverRequest aggregateBelongsTo(TransportFleetRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public TruckDriverRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public TruckDriverRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public TruckDriverRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public TruckDriverRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public TruckDriverRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public TruckDriverRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TruckDriverRequest hasTransportTask() {
    return hasTransportTask(TransportTaskRequest.newInstance());
  }

  public TruckDriverRequest hasTransportTask(TransportTask... transportTask) {
    if (isEmptyParam(transportTask)) {
      throw new IllegalArgumentException("hasTransportTask(TransportTask... transportTask)参数不能为空!");
    }
    return hasTransportTask(
        Q.transportTask()
            .select(TransportTask.DRIVER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) transportTask));
  }

  public TruckDriverRequest hasTransportTask(String... transportTask) {
    return hasTransportTask(
        Q.transportTask().select(TransportTask.DRIVER_PROPERTY).filterById(transportTask));
  }

  public TruckDriverRequest hasTransportTask(TransportTaskRequest transportTask) {
    return hasTransportTask(
        transportTask,
        $transportTask ->
            java.util.Optional.of($transportTask)
                .map(TransportTask::getDriver)
                .map(TruckDriver::getId)
                .orElse(null));
  }

  public TruckDriverRequest hasTransportTask(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    transportTask.select(TransportTask.DRIVER_PROPERTY);
    transportTask.unlimited();
    return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
  }

  public TruckDriverRequest hasTransportTask(
      TransportTaskRequest transportTask, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            transportTask, TransportTask.DRIVER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTransportTaskCriteria(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    return new RefinedIdInCriteria(
        transportTask, ID_PROPERTY, idRefine, TransportTask.DRIVER_PROPERTY);
  }

  public TruckDriverRequest selectTransportTaskList(TransportTaskRequest transportTask) {
    selectChild(TransportTask.DRIVER_PROPERTY, transportTask);
    return this;
  }

  public TruckDriverRequest selectTransportTaskList() {
    return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
  }

  public TruckDriverRequest unselectTransportTaskList() {
    unselectChild(TransportTask.DRIVER_PROPERTY, TransportTask.class);
    return this;
  }

  public TruckDriverRequest aggregateTransportTaskList(TransportTaskRequest transportTask) {
    aggregateChild(TransportTask.DRIVER_PROPERTY, transportTask);
    return this;
  }

  public TruckDriverRequest countTransportTask() {
    return countTransportTask("transportTaskCount");
  }

  public TruckDriverRequest countTransportTask(String retName) {
    return countTransportTask(retName, TransportTaskRequest.newInstance());
  }

  public TruckDriverRequest countTransportTask(TransportTaskRequest transportTask) {
    return countTransportTask("transportTaskCount", transportTask);
  }

  public TruckDriverRequest countTransportTask(String retName, TransportTaskRequest transportTask) {
    transportTask.count();
    return statsFromTransportTask(retName, transportTask);
  }

  public TruckDriverRequest statsFromTransportTask(
      String retName, TransportTaskRequest transportTask) {
    return addDynamicProperty(retName, transportTask, TransportTask.DRIVER_PROPERTY);
  }

  public TruckDriverRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TruckDriverRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TruckDriverRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TruckDriverRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
