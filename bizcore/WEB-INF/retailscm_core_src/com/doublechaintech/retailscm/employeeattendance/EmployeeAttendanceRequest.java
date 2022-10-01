package com.doublechaintech.retailscm.employeeattendance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance.*;

public class EmployeeAttendanceRequest extends BaseRequest<EmployeeAttendance> {
  public static EmployeeAttendanceRequest newInstance() {
    return new EmployeeAttendanceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeAttendanceRequest resultByClass(Class<? extends EmployeeAttendance> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeAttendanceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeAttendanceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeAttendance";
  }

  public EmployeeAttendanceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeAttendanceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeAttendanceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeAttendanceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeAttendanceRequest selectAll() {
    return this.selectId()
        .selectEmployee()
        .selectEnterTime()
        .selectLeaveTime()
        .selectDurationHours()
        .selectRemark()
        .selectVersion();
  }

  public EmployeeAttendanceRequest selectAny() {
    return selectAll();
  }

  public EmployeeAttendanceRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(ENTER_TIME_PROPERTY);
    select(LEAVE_TIME_PROPERTY);
    select(DURATION_HOURS_PROPERTY);
    select(REMARK_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeAttendanceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeAttendanceRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {ENTER_TIME_PROPERTY, LEAVE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    EMPLOYEE_PROPERTY,
    ENTER_TIME_PROPERTY,
    LEAVE_TIME_PROPERTY,
    DURATION_HOURS_PROPERTY,
    REMARK_PROPERTY,
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

  public EmployeeAttendanceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeAttendanceRequest comment(String comment) {
    return this;
  }

  public EmployeeAttendanceRequest enhance() {
    return this;
  }

  public EmployeeAttendanceRequest overrideClass(Class<? extends EmployeeAttendance> clazz) {
    return this;
  }

  public EmployeeAttendanceRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeAttendanceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeAttendanceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeAttendanceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeAttendanceRequest count() {
    return countId("count");
  }

  public static EmployeeAttendanceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeAttendanceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeAttendanceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeAttendanceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAttendanceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeAttendanceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeAttendanceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeAttendanceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeAttendanceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeAttendanceRequest countId() {
    return countId("countId");
  }

  public EmployeeAttendanceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeAttendanceRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeAttendanceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeAttendanceRequest minId() {
    return minId("minId");
  }

  public EmployeeAttendanceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeAttendanceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeAttendanceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeAttendanceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeAttendanceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeAttendanceRequest filterByEnterTime(Date enterTime) {

    if (enterTime == null) {
      return this;
    }

    return filterByEnterTime(QueryOperator.EQUAL, enterTime);
  }

  public EmployeeAttendanceRequest whereEnterTimeIsNull() {
    return where(ENTER_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAttendanceRequest whereEnterTimeIsNotNull() {
    return where(ENTER_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAttendanceRequest whereEnterTimeBetween(Date enterTimeStart, Date enterTimeEnd) {
    if (ObjectUtil.isEmpty(enterTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereEnterTimeBetween, the parameter enterTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(enterTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereEnterTimeBetween, the parameter enterTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEnterTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {enterTimeStart, enterTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest whereEnterTimeBefore(Date enterTime) {

    if (ObjectUtil.isEmpty(enterTime)) {
      throw new IllegalArgumentException(
          "Method whereEnterTimeBefore, the parameter enterTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getEnterTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {enterTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest whereEnterTimeAfter(Date enterTime) {
    if (ObjectUtil.isEmpty(enterTime)) {
      throw new IllegalArgumentException(
          "Method whereEnterTimeAfter, the parameter enterTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEnterTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {enterTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest filterByEnterTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEnterTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest selectEnterTime() {
    return select(ENTER_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest unselectEnterTime() {
    return unselect(ENTER_TIME_PROPERTY);
  }

  public SearchCriteria getEnterTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ENTER_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAttendanceRequest orderByEnterTime(boolean asc) {
    addOrderBy(ENTER_TIME_PROPERTY, asc);
    return this;
  }

  public EmployeeAttendanceRequest orderByEnterTimeAscending() {
    addOrderBy(ENTER_TIME_PROPERTY, true);
    return this;
  }

  public EmployeeAttendanceRequest orderByEnterTimeDescending() {
    addOrderBy(ENTER_TIME_PROPERTY, false);
    return this;
  }

  public EmployeeAttendanceRequest countEnterTime() {
    return countEnterTime("countEnterTime");
  }

  public EmployeeAttendanceRequest countEnterTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ENTER_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest maxEnterTime() {
    return maxEnterTime("maxEnterTime");
  }

  public EmployeeAttendanceRequest maxEnterTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ENTER_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest minEnterTime() {
    return minEnterTime("minEnterTime");
  }

  public EmployeeAttendanceRequest minEnterTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ENTER_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByEnterTime() {
    return groupByEnterTime(ENTER_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByEnterTime(String ret) {
    return groupBy(ret, ENTER_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByEnterTime(SqlFunction func) {
    return groupByEnterTime(ENTER_TIME_PROPERTY, func);
  }

  public EmployeeAttendanceRequest groupByEnterTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, ENTER_TIME_PROPERTY);
    return this;
  }

  public EmployeeAttendanceRequest filterByLeaveTime(Date leaveTime) {

    if (leaveTime == null) {
      return this;
    }

    return filterByLeaveTime(QueryOperator.EQUAL, leaveTime);
  }

  public EmployeeAttendanceRequest whereLeaveTimeIsNull() {
    return where(LEAVE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAttendanceRequest whereLeaveTimeIsNotNull() {
    return where(LEAVE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAttendanceRequest whereLeaveTimeBetween(Date leaveTimeStart, Date leaveTimeEnd) {
    if (ObjectUtil.isEmpty(leaveTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLeaveTimeBetween, the parameter leaveTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(leaveTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLeaveTimeBetween, the parameter leaveTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeaveTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {leaveTimeStart, leaveTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest whereLeaveTimeBefore(Date leaveTime) {

    if (ObjectUtil.isEmpty(leaveTime)) {
      throw new IllegalArgumentException(
          "Method whereLeaveTimeBefore, the parameter leaveTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLeaveTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {leaveTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest whereLeaveTimeAfter(Date leaveTime) {
    if (ObjectUtil.isEmpty(leaveTime)) {
      throw new IllegalArgumentException(
          "Method whereLeaveTimeAfter, the parameter leaveTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeaveTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {leaveTime});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest filterByLeaveTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLeaveTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest selectLeaveTime() {
    return select(LEAVE_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest unselectLeaveTime() {
    return unselect(LEAVE_TIME_PROPERTY);
  }

  public SearchCriteria getLeaveTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LEAVE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAttendanceRequest orderByLeaveTime(boolean asc) {
    addOrderBy(LEAVE_TIME_PROPERTY, asc);
    return this;
  }

  public EmployeeAttendanceRequest orderByLeaveTimeAscending() {
    addOrderBy(LEAVE_TIME_PROPERTY, true);
    return this;
  }

  public EmployeeAttendanceRequest orderByLeaveTimeDescending() {
    addOrderBy(LEAVE_TIME_PROPERTY, false);
    return this;
  }

  public EmployeeAttendanceRequest countLeaveTime() {
    return countLeaveTime("countLeaveTime");
  }

  public EmployeeAttendanceRequest countLeaveTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LEAVE_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest maxLeaveTime() {
    return maxLeaveTime("maxLeaveTime");
  }

  public EmployeeAttendanceRequest maxLeaveTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LEAVE_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest minLeaveTime() {
    return minLeaveTime("minLeaveTime");
  }

  public EmployeeAttendanceRequest minLeaveTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LEAVE_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByLeaveTime() {
    return groupByLeaveTime(LEAVE_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByLeaveTime(String ret) {
    return groupBy(ret, LEAVE_TIME_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByLeaveTime(SqlFunction func) {
    return groupByLeaveTime(LEAVE_TIME_PROPERTY, func);
  }

  public EmployeeAttendanceRequest groupByLeaveTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LEAVE_TIME_PROPERTY);
    return this;
  }

  public EmployeeAttendanceRequest filterByDurationHours(int durationHours) {

    return filterByDurationHours(QueryOperator.EQUAL, durationHours);
  }

  public EmployeeAttendanceRequest whereDurationHoursIsNull() {
    return where(DURATION_HOURS_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAttendanceRequest whereDurationHoursIsNotNull() {
    return where(DURATION_HOURS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAttendanceRequest whereDurationHoursBetween(
      Integer durationHoursStart, Integer durationHoursEnd) {
    if (ObjectUtil.isEmpty(durationHoursStart)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursBetween, the parameter durationHoursStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(durationHoursEnd)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursBetween, the parameter durationHoursEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDurationHoursSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {durationHoursStart, durationHoursEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest whereDurationHoursLessThan(Integer durationHours) {
    if (ObjectUtil.isEmpty(durationHours)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursLessThan, the parameter durationHours is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDurationHoursSearchCriteria(QueryOperator.LESS_THAN, new Object[] {durationHours});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest whereDurationHoursGreaterThan(int durationHours) {
    if (ObjectUtil.isEmpty(durationHours)) {
      throw new IllegalArgumentException(
          "Method whereDurationHoursGreaterThan, the parameter durationHours is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDurationHoursSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {durationHours});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest filterByDurationHours(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDurationHoursSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest selectDurationHours() {
    return select(DURATION_HOURS_PROPERTY);
  }

  public EmployeeAttendanceRequest unselectDurationHours() {
    return unselect(DURATION_HOURS_PROPERTY);
  }

  public SearchCriteria getDurationHoursSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DURATION_HOURS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAttendanceRequest orderByDurationHours(boolean asc) {
    addOrderBy(DURATION_HOURS_PROPERTY, asc);
    return this;
  }

  public EmployeeAttendanceRequest orderByDurationHoursAscending() {
    addOrderBy(DURATION_HOURS_PROPERTY, true);
    return this;
  }

  public EmployeeAttendanceRequest orderByDurationHoursDescending() {
    addOrderBy(DURATION_HOURS_PROPERTY, false);
    return this;
  }

  public EmployeeAttendanceRequest countDurationHours() {
    return countDurationHours("countDurationHours");
  }

  public EmployeeAttendanceRequest countDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DURATION_HOURS_PROPERTY);
  }

  public EmployeeAttendanceRequest maxDurationHours() {
    return maxDurationHours("maxDurationHours");
  }

  public EmployeeAttendanceRequest maxDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DURATION_HOURS_PROPERTY);
  }

  public EmployeeAttendanceRequest minDurationHours() {
    return minDurationHours("minDurationHours");
  }

  public EmployeeAttendanceRequest minDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DURATION_HOURS_PROPERTY);
  }

  public EmployeeAttendanceRequest sumDurationHours() {
    return sumDurationHours("sumDurationHours");
  }

  public EmployeeAttendanceRequest sumDurationHours(String aggName) {
    return aggregate(aggName, AggFunc.SUM, DURATION_HOURS_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByDurationHours() {
    return groupByDurationHours(DURATION_HOURS_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByDurationHours(String ret) {
    return groupBy(ret, DURATION_HOURS_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByDurationHours(SqlFunction func) {
    return groupByDurationHours(DURATION_HOURS_PROPERTY, func);
  }

  public EmployeeAttendanceRequest groupByDurationHours(String ret, SqlFunction func) {
    super.groupBy(ret, func, DURATION_HOURS_PROPERTY);
    return this;
  }

  public EmployeeAttendanceRequest filterByRemark(String remark) {

    if (remark == null) {
      return this;
    }

    return filterByRemark(QueryOperator.EQUAL, remark);
  }

  public EmployeeAttendanceRequest whereRemarkIsNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAttendanceRequest whereRemarkIsNotNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAttendanceRequest filterByRemark(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest selectRemark() {
    return select(REMARK_PROPERTY);
  }

  public EmployeeAttendanceRequest unselectRemark() {
    return unselect(REMARK_PROPERTY);
  }

  public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAttendanceRequest orderByRemark(boolean asc) {
    addOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public EmployeeAttendanceRequest orderByRemarkAscending() {
    addOrderBy(REMARK_PROPERTY, true);
    return this;
  }

  public EmployeeAttendanceRequest orderByRemarkDescending() {
    addOrderBy(REMARK_PROPERTY, false);
    return this;
  }

  public EmployeeAttendanceRequest orderByRemarkAscendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", true);
    return this;
  }

  public EmployeeAttendanceRequest orderByRemarkDescendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", false);
    return this;
  }

  public EmployeeAttendanceRequest countRemark() {
    return countRemark("countRemark");
  }

  public EmployeeAttendanceRequest countRemark(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMARK_PROPERTY);
  }

  public EmployeeAttendanceRequest maxRemark() {
    return maxRemark("maxRemark");
  }

  public EmployeeAttendanceRequest maxRemark(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMARK_PROPERTY);
  }

  public EmployeeAttendanceRequest minRemark() {
    return minRemark("minRemark");
  }

  public EmployeeAttendanceRequest minRemark(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMARK_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByRemark() {
    return groupByRemark(REMARK_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByRemark(String ret) {
    return groupBy(ret, REMARK_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByRemark(SqlFunction func) {
    return groupByRemark(REMARK_PROPERTY, func);
  }

  public EmployeeAttendanceRequest groupByRemark(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMARK_PROPERTY);
    return this;
  }

  public EmployeeAttendanceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeAttendanceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAttendanceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAttendanceRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeAttendanceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeAttendanceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeAttendanceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeAttendanceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeAttendanceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeAttendanceRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeAttendanceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeAttendanceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeAttendanceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeAttendanceRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeAttendanceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeAttendanceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeAttendanceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeAttendanceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeAttendanceRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeAttendanceRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeAttendanceRequest selectEmployeeId() {
    select(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeRequest upToEmployee() {
    return upToEmployee(EmployeeRequest.newInstance());
  }

  public EmployeeRequest upToEmployee(EmployeeRequest employee) {
    employee.aggregateChild(EMPLOYEE_PROPERTY, this);
    this.groupByEmployee(employee);
    return employee;
  }

  public EmployeeRequest endAtEmployee(String retName) {
    return endAtEmployee(retName, EmployeeRequest.newInstance());
  }

  public EmployeeRequest endAtEmployee(String retName, EmployeeRequest employee) {
    employee.addDynamicProperty(retName, this, EMPLOYEE_PROPERTY);
    return employee;
  }

  public EmployeeAttendanceRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeAttendanceRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeAttendanceRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeAttendanceRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeAttendanceRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeAttendanceRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeAttendanceRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeAttendanceRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeAttendanceRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeAttendanceRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeAttendanceRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeAttendanceRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeAttendanceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeAttendanceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeAttendanceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeAttendanceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
