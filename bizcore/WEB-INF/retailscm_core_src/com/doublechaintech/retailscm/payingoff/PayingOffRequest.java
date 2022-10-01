package com.doublechaintech.retailscm.payingoff;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.payingoff.PayingOff.*;

public class PayingOffRequest extends BaseRequest<PayingOff> {
  public static PayingOffRequest newInstance() {
    return new PayingOffRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PayingOffRequest resultByClass(Class<? extends PayingOff> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PayingOffRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PayingOffRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "PayingOff";
  }

  public PayingOffRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PayingOffRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PayingOffRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PayingOffRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PayingOffRequest selectAll() {
    return this.selectId()
        .selectWho()
        .selectPaidFor()
        .selectPaidTime()
        .selectAmount()
        .selectVersion();
  }

  public PayingOffRequest selectAny() {
    return selectAll().selectEmployeeSalarySheetList(Q.employeeSalarySheet().selectSelf());
  }

  public PayingOffRequest selectSelf() {
    select(ID_PROPERTY);
    select(WHO_PROPERTY);
    select(PAID_FOR_PROPERTY);
    select(PAID_TIME_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PayingOffRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PayingOffRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {PAID_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    WHO_PROPERTY,
    PAID_FOR_PROPERTY,
    PAID_TIME_PROPERTY,
    AMOUNT_PROPERTY,
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

  public PayingOffRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PayingOffRequest comment(String comment) {
    return this;
  }

  public PayingOffRequest enhance() {
    return this;
  }

  public PayingOffRequest overrideClass(Class<? extends PayingOff> clazz) {
    return this;
  }

  public PayingOffRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PayingOffRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PayingOffRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PayingOffRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PayingOffRequest count() {
    return countId("count");
  }

  public static PayingOffRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public PayingOffRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PayingOffRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PayingOffRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PayingOffRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PayingOffRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PayingOffRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PayingOffRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PayingOffRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PayingOffRequest countId() {
    return countId("countId");
  }

  public PayingOffRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PayingOffRequest maxId() {
    return maxId("maxId");
  }

  public PayingOffRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PayingOffRequest minId() {
    return minId("minId");
  }

  public PayingOffRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PayingOffRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PayingOffRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PayingOffRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PayingOffRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PayingOffRequest filterByWho(String who) {

    if (who == null) {
      return this;
    }

    return filterByWho(QueryOperator.EQUAL, who);
  }

  public PayingOffRequest whereWhoIsNull() {
    return where(WHO_PROPERTY, QueryOperator.IS_NULL);
  }

  public PayingOffRequest whereWhoIsNotNull() {
    return where(WHO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PayingOffRequest filterByWho(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getWhoSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest selectWho() {
    return select(WHO_PROPERTY);
  }

  public PayingOffRequest unselectWho() {
    return unselect(WHO_PROPERTY);
  }

  public SearchCriteria getWhoSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(WHO_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PayingOffRequest orderByWho(boolean asc) {
    addOrderBy(WHO_PROPERTY, asc);
    return this;
  }

  public PayingOffRequest orderByWhoAscending() {
    addOrderBy(WHO_PROPERTY, true);
    return this;
  }

  public PayingOffRequest orderByWhoDescending() {
    addOrderBy(WHO_PROPERTY, false);
    return this;
  }

  public PayingOffRequest orderByWhoAscendingUsingGBK() {
    addOrderBy("convert(who using gbk)", true);
    return this;
  }

  public PayingOffRequest orderByWhoDescendingUsingGBK() {
    addOrderBy("convert(who using gbk)", false);
    return this;
  }

  public PayingOffRequest countWho() {
    return countWho("countWho");
  }

  public PayingOffRequest countWho(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WHO_PROPERTY);
  }

  public PayingOffRequest maxWho() {
    return maxWho("maxWho");
  }

  public PayingOffRequest maxWho(String aggName) {
    return aggregate(aggName, AggFunc.MAX, WHO_PROPERTY);
  }

  public PayingOffRequest minWho() {
    return minWho("minWho");
  }

  public PayingOffRequest minWho(String aggName) {
    return aggregate(aggName, AggFunc.MIN, WHO_PROPERTY);
  }

  public PayingOffRequest groupByWho() {
    return groupByWho(WHO_PROPERTY);
  }

  public PayingOffRequest groupByWho(String ret) {
    return groupBy(ret, WHO_PROPERTY);
  }

  public PayingOffRequest groupByWho(SqlFunction func) {
    return groupByWho(WHO_PROPERTY, func);
  }

  public PayingOffRequest groupByWho(String ret, SqlFunction func) {
    super.groupBy(ret, func, WHO_PROPERTY);
    return this;
  }

  public PayingOffRequest filterByPaidTime(Date paidTime) {

    if (paidTime == null) {
      return this;
    }

    return filterByPaidTime(QueryOperator.EQUAL, paidTime);
  }

  public PayingOffRequest wherePaidTimeIsNull() {
    return where(PAID_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PayingOffRequest wherePaidTimeIsNotNull() {
    return where(PAID_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PayingOffRequest wherePaidTimeBetween(Date paidTimeStart, Date paidTimeEnd) {
    if (ObjectUtil.isEmpty(paidTimeStart)) {
      throw new IllegalArgumentException(
          "Method wherePaidTimeBetween, the parameter paidTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(paidTimeEnd)) {
      throw new IllegalArgumentException(
          "Method wherePaidTimeBetween, the parameter paidTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPaidTimeSearchCriteria(QueryOperator.BETWEEN, new Object[] {paidTimeStart, paidTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest wherePaidTimeBefore(Date paidTime) {

    if (ObjectUtil.isEmpty(paidTime)) {
      throw new IllegalArgumentException(
          "Method wherePaidTimeBefore, the parameter paidTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getPaidTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {paidTime});
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest wherePaidTimeAfter(Date paidTime) {
    if (ObjectUtil.isEmpty(paidTime)) {
      throw new IllegalArgumentException(
          "Method wherePaidTimeAfter, the parameter paidTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPaidTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {paidTime});
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest filterByPaidTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPaidTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest selectPaidTime() {
    return select(PAID_TIME_PROPERTY);
  }

  public PayingOffRequest unselectPaidTime() {
    return unselect(PAID_TIME_PROPERTY);
  }

  public SearchCriteria getPaidTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PAID_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PayingOffRequest orderByPaidTime(boolean asc) {
    addOrderBy(PAID_TIME_PROPERTY, asc);
    return this;
  }

  public PayingOffRequest orderByPaidTimeAscending() {
    addOrderBy(PAID_TIME_PROPERTY, true);
    return this;
  }

  public PayingOffRequest orderByPaidTimeDescending() {
    addOrderBy(PAID_TIME_PROPERTY, false);
    return this;
  }

  public PayingOffRequest countPaidTime() {
    return countPaidTime("countPaidTime");
  }

  public PayingOffRequest countPaidTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAID_TIME_PROPERTY);
  }

  public PayingOffRequest maxPaidTime() {
    return maxPaidTime("maxPaidTime");
  }

  public PayingOffRequest maxPaidTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PAID_TIME_PROPERTY);
  }

  public PayingOffRequest minPaidTime() {
    return minPaidTime("minPaidTime");
  }

  public PayingOffRequest minPaidTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PAID_TIME_PROPERTY);
  }

  public PayingOffRequest groupByPaidTime() {
    return groupByPaidTime(PAID_TIME_PROPERTY);
  }

  public PayingOffRequest groupByPaidTime(String ret) {
    return groupBy(ret, PAID_TIME_PROPERTY);
  }

  public PayingOffRequest groupByPaidTime(SqlFunction func) {
    return groupByPaidTime(PAID_TIME_PROPERTY, func);
  }

  public PayingOffRequest groupByPaidTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, PAID_TIME_PROPERTY);
    return this;
  }

  public PayingOffRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public PayingOffRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public PayingOffRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PayingOffRequest whereAmountBetween(BigDecimal amountStart, BigDecimal amountEnd) {
    if (ObjectUtil.isEmpty(amountStart)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(amountEnd)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.BETWEEN, new Object[] {amountStart, amountEnd});
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public PayingOffRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PayingOffRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public PayingOffRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public PayingOffRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public PayingOffRequest countAmount() {
    return countAmount("countAmount");
  }

  public PayingOffRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public PayingOffRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public PayingOffRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public PayingOffRequest minAmount() {
    return minAmount("minAmount");
  }

  public PayingOffRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public PayingOffRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public PayingOffRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public PayingOffRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public PayingOffRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public PayingOffRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public PayingOffRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public PayingOffRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PayingOffRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PayingOffRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PayingOffRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PayingOffRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PayingOffRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PayingOffRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PayingOffRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PayingOffRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PayingOffRequest countVersion() {
    return countVersion("countVersion");
  }

  public PayingOffRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PayingOffRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PayingOffRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PayingOffRequest minVersion() {
    return minVersion("minVersion");
  }

  public PayingOffRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PayingOffRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PayingOffRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PayingOffRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PayingOffRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PayingOffRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PayingOffRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PayingOffRequest filterByPaidFor(EmployeeRequest paidFor) {
    return filterByPaidFor(paidFor, Employee::getId);
  }

  public PayingOffRequest filterByPaidFor(Employee... paidFor) {
    if (isEmptyParam(paidFor)) {
      throw new IllegalArgumentException("filterByPaidFor(Employee... paidFor)参数不能为空!");
    }
    return where(PAID_FOR_PROPERTY, QueryOperator.IN, (Object[]) paidFor);
  }

  public PayingOffRequest selectPaidForId() {
    select(PAID_FOR_PROPERTY);
    return this;
  }

  public EmployeeRequest upToPaidFor() {
    return upToPaidFor(EmployeeRequest.newInstance());
  }

  public EmployeeRequest upToPaidFor(EmployeeRequest paidFor) {
    paidFor.aggregateChild(PAID_FOR_PROPERTY, this);
    this.groupByPaidFor(paidFor);
    return paidFor;
  }

  public EmployeeRequest endAtPaidFor(String retName) {
    return endAtPaidFor(retName, EmployeeRequest.newInstance());
  }

  public EmployeeRequest endAtPaidFor(String retName, EmployeeRequest paidFor) {
    paidFor.addDynamicProperty(retName, this, PAID_FOR_PROPERTY);
    return paidFor;
  }

  public PayingOffRequest filterByPaidFor(String... paidFor) {
    if (isEmptyParam(paidFor)) {
      throw new IllegalArgumentException("filterByPaidFor(String... paidFor)参数不能为空!");
    }
    return where(PAID_FOR_PROPERTY, QueryOperator.IN, (Object[]) paidFor);
  }

  public PayingOffRequest filterByPaidFor(EmployeeRequest paidFor, IDRefine<Employee> idRefine) {
    paidFor.unlimited();
    return addSearchCriteria(createPaidForCriteria(paidFor, idRefine));
  }

  public SearchCriteria createPaidForCriteria(
      EmployeeRequest paidFor, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(paidFor, PAID_FOR_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public PayingOffRequest selectPaidFor() {
    return selectPaidFor(EmployeeRequest.newInstance().selectSelf());
  }

  public PayingOffRequest selectPaidFor(EmployeeRequest paidFor) {
    selectParent(PAID_FOR_PROPERTY, paidFor);
    return this;
  }

  public PayingOffRequest unselectPaidFor() {
    unselectParent(PAID_FOR_PROPERTY);
    return this;
  }

  public PayingOffRequest groupByPaidFor(EmployeeRequest paidFor) {
    groupBy(PAID_FOR_PROPERTY, paidFor);
    return this;
  }

  public PayingOffRequest aggregatePaidFor(EmployeeRequest paidFor) {
    aggregateParent(PAID_FOR_PROPERTY, paidFor);
    return this;
  }

  public PayingOffRequest countPaidFor() {
    return countPaidFor("countPaidFor");
  }

  public PayingOffRequest countPaidFor(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAID_FOR_PROPERTY);
  }

  public PayingOffRequest groupByPaidFor() {
    return groupByPaidFor(PAID_FOR_PROPERTY);
  }

  public PayingOffRequest groupByPaidFor(String ret) {
    return groupBy(ret, PAID_FOR_PROPERTY);
  }

  public PayingOffRequest wherePaidForIsNull() {
    return where(PAID_FOR_PROPERTY, QueryOperator.IS_NULL);
  }

  public PayingOffRequest wherePaidForIsNotNull() {
    return where(PAID_FOR_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PayingOffRequest hasEmployeeSalarySheet() {
    return hasEmployeeSalarySheet(EmployeeSalarySheetRequest.newInstance());
  }

  public PayingOffRequest hasEmployeeSalarySheet(EmployeeSalarySheet... employeeSalarySheet) {
    if (isEmptyParam(employeeSalarySheet)) {
      throw new IllegalArgumentException(
          "hasEmployeeSalarySheet(EmployeeSalarySheet... employeeSalarySheet)参数不能为空!");
    }
    return hasEmployeeSalarySheet(
        Q.employeeSalarySheet()
            .select(EmployeeSalarySheet.PAYING_OFF_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeSalarySheet));
  }

  public PayingOffRequest hasEmployeeSalarySheet(String... employeeSalarySheet) {
    return hasEmployeeSalarySheet(
        Q.employeeSalarySheet()
            .select(EmployeeSalarySheet.PAYING_OFF_PROPERTY)
            .filterById(employeeSalarySheet));
  }

  public PayingOffRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
    return hasEmployeeSalarySheet(
        employeeSalarySheet,
        $employeeSalarySheet ->
            java.util.Optional.of($employeeSalarySheet)
                .map(EmployeeSalarySheet::getPayingOff)
                .map(PayingOff::getId)
                .orElse(null));
  }

  public PayingOffRequest hasEmployeeSalarySheet(
      EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
    employeeSalarySheet.select(EmployeeSalarySheet.PAYING_OFF_PROPERTY);
    employeeSalarySheet.unlimited();
    return addSearchCriteria(createEmployeeSalarySheetCriteria(employeeSalarySheet, idRefine));
  }

  public PayingOffRequest hasEmployeeSalarySheet(
      EmployeeSalarySheetRequest employeeSalarySheet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeSalarySheet, EmployeeSalarySheet.PAYING_OFF_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeSalarySheetCriteria(
      EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
    return new RefinedIdInCriteria(
        employeeSalarySheet, ID_PROPERTY, idRefine, EmployeeSalarySheet.PAYING_OFF_PROPERTY);
  }

  public PayingOffRequest selectEmployeeSalarySheetList(
      EmployeeSalarySheetRequest employeeSalarySheet) {
    selectChild(EmployeeSalarySheet.PAYING_OFF_PROPERTY, employeeSalarySheet);
    return this;
  }

  public PayingOffRequest selectEmployeeSalarySheetList() {
    return selectEmployeeSalarySheetList(EmployeeSalarySheetRequest.newInstance().selectAll());
  }

  public PayingOffRequest unselectEmployeeSalarySheetList() {
    unselectChild(EmployeeSalarySheet.PAYING_OFF_PROPERTY, EmployeeSalarySheet.class);
    return this;
  }

  public PayingOffRequest aggregateEmployeeSalarySheetList(
      EmployeeSalarySheetRequest employeeSalarySheet) {
    aggregateChild(EmployeeSalarySheet.PAYING_OFF_PROPERTY, employeeSalarySheet);
    return this;
  }

  public PayingOffRequest countEmployeeSalarySheet() {
    return countEmployeeSalarySheet("employeeSalarySheetCount");
  }

  public PayingOffRequest countEmployeeSalarySheet(String retName) {
    return countEmployeeSalarySheet(retName, EmployeeSalarySheetRequest.newInstance());
  }

  public PayingOffRequest countEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
    return countEmployeeSalarySheet("employeeSalarySheetCount", employeeSalarySheet);
  }

  public PayingOffRequest countEmployeeSalarySheet(
      String retName, EmployeeSalarySheetRequest employeeSalarySheet) {
    employeeSalarySheet.count();
    return statsFromEmployeeSalarySheet(retName, employeeSalarySheet);
  }

  public PayingOffRequest statsFromEmployeeSalarySheet(
      String retName, EmployeeSalarySheetRequest employeeSalarySheet) {
    return addDynamicProperty(
        retName, employeeSalarySheet, EmployeeSalarySheet.PAYING_OFF_PROPERTY);
  }

  public PayingOffRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PayingOffRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PayingOffRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PayingOffRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
