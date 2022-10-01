package com.doublechaintech.retailscm.employeeleave;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.leavetype.LeaveTypeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeleave.EmployeeLeave.*;

public class EmployeeLeaveRequest extends BaseRequest<EmployeeLeave> {
  public static EmployeeLeaveRequest newInstance() {
    return new EmployeeLeaveRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeLeaveRequest resultByClass(Class<? extends EmployeeLeave> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeLeaveRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeLeaveRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeLeave";
  }

  public EmployeeLeaveRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeLeaveRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeLeaveRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeLeaveRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeLeaveRequest selectAll() {
    return this.selectId()
        .selectWho()
        .selectType()
        .selectLeaveDurationHour()
        .selectRemark()
        .selectVersion();
  }

  public EmployeeLeaveRequest selectAny() {
    return selectAll();
  }

  public EmployeeLeaveRequest selectSelf() {
    select(ID_PROPERTY);
    select(WHO_PROPERTY);
    select(TYPE_PROPERTY);
    select(LEAVE_DURATION_HOUR_PROPERTY);
    select(REMARK_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeLeaveRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeLeaveRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    WHO_PROPERTY,
    TYPE_PROPERTY,
    LEAVE_DURATION_HOUR_PROPERTY,
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

  public EmployeeLeaveRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeLeaveRequest comment(String comment) {
    return this;
  }

  public EmployeeLeaveRequest enhance() {
    return this;
  }

  public EmployeeLeaveRequest overrideClass(Class<? extends EmployeeLeave> clazz) {
    return this;
  }

  public EmployeeLeaveRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeLeaveRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeLeaveRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeLeaveRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeLeaveRequest count() {
    return countId("count");
  }

  public static EmployeeLeaveRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeLeaveRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeLeaveRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeLeaveRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeLeaveRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeLeaveRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeLeaveRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeLeaveRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeLeaveRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeLeaveRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeLeaveRequest countId() {
    return countId("countId");
  }

  public EmployeeLeaveRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeLeaveRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeLeaveRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeLeaveRequest minId() {
    return minId("minId");
  }

  public EmployeeLeaveRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeLeaveRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeLeaveRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeLeaveRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeLeaveRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeLeaveRequest filterByLeaveDurationHour(int leaveDurationHour) {

    return filterByLeaveDurationHour(QueryOperator.EQUAL, leaveDurationHour);
  }

  public EmployeeLeaveRequest whereLeaveDurationHourIsNull() {
    return where(LEAVE_DURATION_HOUR_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeLeaveRequest whereLeaveDurationHourIsNotNull() {
    return where(LEAVE_DURATION_HOUR_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeLeaveRequest whereLeaveDurationHourBetween(
      Integer leaveDurationHourStart, Integer leaveDurationHourEnd) {
    if (ObjectUtil.isEmpty(leaveDurationHourStart)) {
      throw new IllegalArgumentException(
          "Method whereLeaveDurationHourBetween, the parameter leaveDurationHourStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(leaveDurationHourEnd)) {
      throw new IllegalArgumentException(
          "Method whereLeaveDurationHourBetween, the parameter leaveDurationHourEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeaveDurationHourSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {leaveDurationHourStart, leaveDurationHourEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeLeaveRequest whereLeaveDurationHourLessThan(Integer leaveDurationHour) {
    if (ObjectUtil.isEmpty(leaveDurationHour)) {
      throw new IllegalArgumentException(
          "Method whereLeaveDurationHourLessThan, the parameter leaveDurationHour is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeaveDurationHourSearchCriteria(
            QueryOperator.LESS_THAN, new Object[] {leaveDurationHour});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeLeaveRequest whereLeaveDurationHourGreaterThan(int leaveDurationHour) {
    if (ObjectUtil.isEmpty(leaveDurationHour)) {
      throw new IllegalArgumentException(
          "Method whereLeaveDurationHourGreaterThan, the parameter leaveDurationHour is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLeaveDurationHourSearchCriteria(
            QueryOperator.GREATER_THAN, new Object[] {leaveDurationHour});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeLeaveRequest filterByLeaveDurationHour(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLeaveDurationHourSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeLeaveRequest selectLeaveDurationHour() {
    return select(LEAVE_DURATION_HOUR_PROPERTY);
  }

  public EmployeeLeaveRequest unselectLeaveDurationHour() {
    return unselect(LEAVE_DURATION_HOUR_PROPERTY);
  }

  public SearchCriteria getLeaveDurationHourSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LEAVE_DURATION_HOUR_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeLeaveRequest orderByLeaveDurationHour(boolean asc) {
    addOrderBy(LEAVE_DURATION_HOUR_PROPERTY, asc);
    return this;
  }

  public EmployeeLeaveRequest orderByLeaveDurationHourAscending() {
    addOrderBy(LEAVE_DURATION_HOUR_PROPERTY, true);
    return this;
  }

  public EmployeeLeaveRequest orderByLeaveDurationHourDescending() {
    addOrderBy(LEAVE_DURATION_HOUR_PROPERTY, false);
    return this;
  }

  public EmployeeLeaveRequest countLeaveDurationHour() {
    return countLeaveDurationHour("countLeaveDurationHour");
  }

  public EmployeeLeaveRequest countLeaveDurationHour(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LEAVE_DURATION_HOUR_PROPERTY);
  }

  public EmployeeLeaveRequest maxLeaveDurationHour() {
    return maxLeaveDurationHour("maxLeaveDurationHour");
  }

  public EmployeeLeaveRequest maxLeaveDurationHour(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LEAVE_DURATION_HOUR_PROPERTY);
  }

  public EmployeeLeaveRequest minLeaveDurationHour() {
    return minLeaveDurationHour("minLeaveDurationHour");
  }

  public EmployeeLeaveRequest minLeaveDurationHour(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LEAVE_DURATION_HOUR_PROPERTY);
  }

  public EmployeeLeaveRequest sumLeaveDurationHour() {
    return sumLeaveDurationHour("sumLeaveDurationHour");
  }

  public EmployeeLeaveRequest sumLeaveDurationHour(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LEAVE_DURATION_HOUR_PROPERTY);
  }

  public EmployeeLeaveRequest groupByLeaveDurationHour() {
    return groupByLeaveDurationHour(LEAVE_DURATION_HOUR_PROPERTY);
  }

  public EmployeeLeaveRequest groupByLeaveDurationHour(String ret) {
    return groupBy(ret, LEAVE_DURATION_HOUR_PROPERTY);
  }

  public EmployeeLeaveRequest groupByLeaveDurationHour(SqlFunction func) {
    return groupByLeaveDurationHour(LEAVE_DURATION_HOUR_PROPERTY, func);
  }

  public EmployeeLeaveRequest groupByLeaveDurationHour(String ret, SqlFunction func) {
    super.groupBy(ret, func, LEAVE_DURATION_HOUR_PROPERTY);
    return this;
  }

  public EmployeeLeaveRequest filterByRemark(String remark) {

    if (remark == null) {
      return this;
    }

    return filterByRemark(QueryOperator.EQUAL, remark);
  }

  public EmployeeLeaveRequest whereRemarkIsNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeLeaveRequest whereRemarkIsNotNull() {
    return where(REMARK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeLeaveRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeLeaveRequest selectRemark() {
    return select(REMARK_PROPERTY);
  }

  public EmployeeLeaveRequest unselectRemark() {
    return unselect(REMARK_PROPERTY);
  }

  public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeLeaveRequest orderByRemark(boolean asc) {
    addOrderBy(REMARK_PROPERTY, asc);
    return this;
  }

  public EmployeeLeaveRequest orderByRemarkAscending() {
    addOrderBy(REMARK_PROPERTY, true);
    return this;
  }

  public EmployeeLeaveRequest orderByRemarkDescending() {
    addOrderBy(REMARK_PROPERTY, false);
    return this;
  }

  public EmployeeLeaveRequest orderByRemarkAscendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", true);
    return this;
  }

  public EmployeeLeaveRequest orderByRemarkDescendingUsingGBK() {
    addOrderBy("convert(remark using gbk)", false);
    return this;
  }

  public EmployeeLeaveRequest countRemark() {
    return countRemark("countRemark");
  }

  public EmployeeLeaveRequest countRemark(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REMARK_PROPERTY);
  }

  public EmployeeLeaveRequest maxRemark() {
    return maxRemark("maxRemark");
  }

  public EmployeeLeaveRequest maxRemark(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REMARK_PROPERTY);
  }

  public EmployeeLeaveRequest minRemark() {
    return minRemark("minRemark");
  }

  public EmployeeLeaveRequest minRemark(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REMARK_PROPERTY);
  }

  public EmployeeLeaveRequest groupByRemark() {
    return groupByRemark(REMARK_PROPERTY);
  }

  public EmployeeLeaveRequest groupByRemark(String ret) {
    return groupBy(ret, REMARK_PROPERTY);
  }

  public EmployeeLeaveRequest groupByRemark(SqlFunction func) {
    return groupByRemark(REMARK_PROPERTY, func);
  }

  public EmployeeLeaveRequest groupByRemark(String ret, SqlFunction func) {
    super.groupBy(ret, func, REMARK_PROPERTY);
    return this;
  }

  public EmployeeLeaveRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeLeaveRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeLeaveRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeLeaveRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeLeaveRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeLeaveRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeLeaveRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeLeaveRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeLeaveRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeLeaveRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeLeaveRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeLeaveRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeLeaveRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeLeaveRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeLeaveRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeLeaveRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeLeaveRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeLeaveRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeLeaveRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeLeaveRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeLeaveRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeLeaveRequest filterByWho(EmployeeRequest who) {
    return filterByWho(who, Employee::getId);
  }

  public EmployeeLeaveRequest filterByWho(Employee... who) {
    if (isEmptyParam(who)) {
      throw new IllegalArgumentException("filterByWho(Employee... who)参数不能为空!");
    }
    return where(WHO_PROPERTY, QueryOperator.IN, (Object[]) who);
  }

  public EmployeeLeaveRequest selectWhoId() {
    select(WHO_PROPERTY);
    return this;
  }

  public EmployeeRequest upToWho() {
    return upToWho(EmployeeRequest.newInstance());
  }

  public EmployeeRequest upToWho(EmployeeRequest who) {
    who.aggregateChild(WHO_PROPERTY, this);
    this.groupByWho(who);
    return who;
  }

  public EmployeeRequest endAtWho(String retName) {
    return endAtWho(retName, EmployeeRequest.newInstance());
  }

  public EmployeeRequest endAtWho(String retName, EmployeeRequest who) {
    who.addDynamicProperty(retName, this, WHO_PROPERTY);
    return who;
  }

  public EmployeeLeaveRequest filterByWho(String... who) {
    if (isEmptyParam(who)) {
      throw new IllegalArgumentException("filterByWho(String... who)参数不能为空!");
    }
    return where(WHO_PROPERTY, QueryOperator.IN, (Object[]) who);
  }

  public EmployeeLeaveRequest filterByWho(EmployeeRequest who, IDRefine<Employee> idRefine) {
    who.unlimited();
    return addSearchCriteria(createWhoCriteria(who, idRefine));
  }

  public SearchCriteria createWhoCriteria(EmployeeRequest who, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(who, WHO_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeLeaveRequest selectWho() {
    return selectWho(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeLeaveRequest selectWho(EmployeeRequest who) {
    selectParent(WHO_PROPERTY, who);
    return this;
  }

  public EmployeeLeaveRequest unselectWho() {
    unselectParent(WHO_PROPERTY);
    return this;
  }

  public EmployeeLeaveRequest groupByWho(EmployeeRequest who) {
    groupBy(WHO_PROPERTY, who);
    return this;
  }

  public EmployeeLeaveRequest aggregateWho(EmployeeRequest who) {
    aggregateParent(WHO_PROPERTY, who);
    return this;
  }

  public EmployeeLeaveRequest countWho() {
    return countWho("countWho");
  }

  public EmployeeLeaveRequest countWho(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WHO_PROPERTY);
  }

  public EmployeeLeaveRequest groupByWho() {
    return groupByWho(WHO_PROPERTY);
  }

  public EmployeeLeaveRequest groupByWho(String ret) {
    return groupBy(ret, WHO_PROPERTY);
  }

  public EmployeeLeaveRequest whereWhoIsNull() {
    return where(WHO_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeLeaveRequest whereWhoIsNotNull() {
    return where(WHO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeLeaveRequest filterByType(LeaveTypeRequest type) {
    return filterByType(type, LeaveType::getId);
  }

  public EmployeeLeaveRequest filterByType(LeaveType... type) {
    if (isEmptyParam(type)) {
      throw new IllegalArgumentException("filterByType(LeaveType... type)参数不能为空!");
    }
    return where(TYPE_PROPERTY, QueryOperator.IN, (Object[]) type);
  }

  public EmployeeLeaveRequest selectTypeId() {
    select(TYPE_PROPERTY);
    return this;
  }

  public LeaveTypeRequest upToType() {
    return upToType(LeaveTypeRequest.newInstance());
  }

  public LeaveTypeRequest upToType(LeaveTypeRequest type) {
    type.aggregateChild(TYPE_PROPERTY, this);
    this.groupByType(type);
    return type;
  }

  public LeaveTypeRequest endAtType(String retName) {
    return endAtType(retName, LeaveTypeRequest.newInstance());
  }

  public LeaveTypeRequest endAtType(String retName, LeaveTypeRequest type) {
    type.addDynamicProperty(retName, this, TYPE_PROPERTY);
    return type;
  }

  public EmployeeLeaveRequest filterByType(String... type) {
    if (isEmptyParam(type)) {
      throw new IllegalArgumentException("filterByType(String... type)参数不能为空!");
    }
    return where(TYPE_PROPERTY, QueryOperator.IN, (Object[]) type);
  }

  public EmployeeLeaveRequest filterByType(LeaveTypeRequest type, IDRefine<LeaveType> idRefine) {
    type.unlimited();
    return addSearchCriteria(createTypeCriteria(type, idRefine));
  }

  public SearchCriteria createTypeCriteria(LeaveTypeRequest type, IDRefine<LeaveType> idRefine) {
    return new RefinedIdInCriteria(type, TYPE_PROPERTY, idRefine, LeaveType.ID_PROPERTY);
  }

  public EmployeeLeaveRequest selectType() {
    return selectType(LeaveTypeRequest.newInstance().selectSelf());
  }

  public EmployeeLeaveRequest selectType(LeaveTypeRequest type) {
    selectParent(TYPE_PROPERTY, type);
    return this;
  }

  public EmployeeLeaveRequest unselectType() {
    unselectParent(TYPE_PROPERTY);
    return this;
  }

  public EmployeeLeaveRequest groupByType(LeaveTypeRequest type) {
    groupBy(TYPE_PROPERTY, type);
    return this;
  }

  public EmployeeLeaveRequest aggregateType(LeaveTypeRequest type) {
    aggregateParent(TYPE_PROPERTY, type);
    return this;
  }

  public EmployeeLeaveRequest countType() {
    return countType("countType");
  }

  public EmployeeLeaveRequest countType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TYPE_PROPERTY);
  }

  public EmployeeLeaveRequest groupByType() {
    return groupByType(TYPE_PROPERTY);
  }

  public EmployeeLeaveRequest groupByType(String ret) {
    return groupBy(ret, TYPE_PROPERTY);
  }

  public EmployeeLeaveRequest whereTypeIsNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeLeaveRequest whereTypeIsNotNull() {
    return where(TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeLeaveRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeLeaveRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeLeaveRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeLeaveRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
