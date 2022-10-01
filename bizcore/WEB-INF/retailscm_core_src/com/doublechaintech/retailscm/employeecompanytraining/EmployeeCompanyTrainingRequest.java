package com.doublechaintech.retailscm.employeecompanytraining;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.scoring.ScoringRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining.*;

public class EmployeeCompanyTrainingRequest extends BaseRequest<EmployeeCompanyTraining> {
  public static EmployeeCompanyTrainingRequest newInstance() {
    return new EmployeeCompanyTrainingRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeCompanyTrainingRequest resultByClass(
      Class<? extends EmployeeCompanyTraining> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeCompanyTrainingRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeCompanyTrainingRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeCompanyTraining";
  }

  public EmployeeCompanyTrainingRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeCompanyTrainingRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeCompanyTrainingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeCompanyTrainingRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeCompanyTrainingRequest selectAll() {
    return this.selectId().selectEmployee().selectTraining().selectScoring().selectVersion();
  }

  public EmployeeCompanyTrainingRequest selectAny() {
    return selectAll();
  }

  public EmployeeCompanyTrainingRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(TRAINING_PROPERTY);
    select(SCORING_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeCompanyTrainingRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeCompanyTrainingRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, EMPLOYEE_PROPERTY, TRAINING_PROPERTY, SCORING_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public EmployeeCompanyTrainingRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeCompanyTrainingRequest comment(String comment) {
    return this;
  }

  public EmployeeCompanyTrainingRequest enhance() {
    return this;
  }

  public EmployeeCompanyTrainingRequest overrideClass(
      Class<? extends EmployeeCompanyTraining> clazz) {
    return this;
  }

  public EmployeeCompanyTrainingRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeCompanyTrainingRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeCompanyTrainingRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeCompanyTrainingRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeCompanyTrainingRequest count() {
    return countId("count");
  }

  public static EmployeeCompanyTrainingRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeCompanyTrainingRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeCompanyTrainingRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeCompanyTrainingRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeCompanyTrainingRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeCompanyTrainingRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeCompanyTrainingRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeCompanyTrainingRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeCompanyTrainingRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeCompanyTrainingRequest countId() {
    return countId("countId");
  }

  public EmployeeCompanyTrainingRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeCompanyTrainingRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest minId() {
    return minId("minId");
  }

  public EmployeeCompanyTrainingRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeCompanyTrainingRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeCompanyTrainingRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeCompanyTrainingRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeCompanyTrainingRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeCompanyTrainingRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeCompanyTrainingRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeCompanyTrainingRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeCompanyTrainingRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeCompanyTrainingRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeCompanyTrainingRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeCompanyTrainingRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeCompanyTrainingRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeCompanyTrainingRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeCompanyTrainingRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeCompanyTrainingRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeCompanyTrainingRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeCompanyTrainingRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeCompanyTrainingRequest selectEmployeeId() {
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

  public EmployeeCompanyTrainingRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeCompanyTrainingRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeCompanyTrainingRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeCompanyTrainingRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeCompanyTrainingRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeCompanyTrainingRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeCompanyTrainingRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeCompanyTrainingRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeCompanyTrainingRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeCompanyTrainingRequest filterByTraining(CompanyTrainingRequest training) {
    return filterByTraining(training, CompanyTraining::getId);
  }

  public EmployeeCompanyTrainingRequest filterByTraining(CompanyTraining... training) {
    if (isEmptyParam(training)) {
      throw new IllegalArgumentException("filterByTraining(CompanyTraining... training)参数不能为空!");
    }
    return where(TRAINING_PROPERTY, QueryOperator.IN, (Object[]) training);
  }

  public EmployeeCompanyTrainingRequest selectTrainingId() {
    select(TRAINING_PROPERTY);
    return this;
  }

  public CompanyTrainingRequest upToTraining() {
    return upToTraining(CompanyTrainingRequest.newInstance());
  }

  public CompanyTrainingRequest upToTraining(CompanyTrainingRequest training) {
    training.aggregateChild(TRAINING_PROPERTY, this);
    this.groupByTraining(training);
    return training;
  }

  public CompanyTrainingRequest endAtTraining(String retName) {
    return endAtTraining(retName, CompanyTrainingRequest.newInstance());
  }

  public CompanyTrainingRequest endAtTraining(String retName, CompanyTrainingRequest training) {
    training.addDynamicProperty(retName, this, TRAINING_PROPERTY);
    return training;
  }

  public EmployeeCompanyTrainingRequest filterByTraining(String... training) {
    if (isEmptyParam(training)) {
      throw new IllegalArgumentException("filterByTraining(String... training)参数不能为空!");
    }
    return where(TRAINING_PROPERTY, QueryOperator.IN, (Object[]) training);
  }

  public EmployeeCompanyTrainingRequest filterByTraining(
      CompanyTrainingRequest training, IDRefine<CompanyTraining> idRefine) {
    training.unlimited();
    return addSearchCriteria(createTrainingCriteria(training, idRefine));
  }

  public SearchCriteria createTrainingCriteria(
      CompanyTrainingRequest training, IDRefine<CompanyTraining> idRefine) {
    return new RefinedIdInCriteria(
        training, TRAINING_PROPERTY, idRefine, CompanyTraining.ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest selectTraining() {
    return selectTraining(CompanyTrainingRequest.newInstance().selectSelf());
  }

  public EmployeeCompanyTrainingRequest selectTraining(CompanyTrainingRequest training) {
    selectParent(TRAINING_PROPERTY, training);
    return this;
  }

  public EmployeeCompanyTrainingRequest unselectTraining() {
    unselectParent(TRAINING_PROPERTY);
    return this;
  }

  public EmployeeCompanyTrainingRequest groupByTraining(CompanyTrainingRequest training) {
    groupBy(TRAINING_PROPERTY, training);
    return this;
  }

  public EmployeeCompanyTrainingRequest aggregateTraining(CompanyTrainingRequest training) {
    aggregateParent(TRAINING_PROPERTY, training);
    return this;
  }

  public EmployeeCompanyTrainingRequest countTraining() {
    return countTraining("countTraining");
  }

  public EmployeeCompanyTrainingRequest countTraining(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TRAINING_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByTraining() {
    return groupByTraining(TRAINING_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByTraining(String ret) {
    return groupBy(ret, TRAINING_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest whereTrainingIsNull() {
    return where(TRAINING_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeCompanyTrainingRequest whereTrainingIsNotNull() {
    return where(TRAINING_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeCompanyTrainingRequest filterByScoring(ScoringRequest scoring) {
    return filterByScoring(scoring, Scoring::getId);
  }

  public EmployeeCompanyTrainingRequest filterByScoring(Scoring... scoring) {
    if (isEmptyParam(scoring)) {
      throw new IllegalArgumentException("filterByScoring(Scoring... scoring)参数不能为空!");
    }
    return where(SCORING_PROPERTY, QueryOperator.IN, (Object[]) scoring);
  }

  public EmployeeCompanyTrainingRequest selectScoringId() {
    select(SCORING_PROPERTY);
    return this;
  }

  public ScoringRequest upToScoring() {
    return upToScoring(ScoringRequest.newInstance());
  }

  public ScoringRequest upToScoring(ScoringRequest scoring) {
    scoring.aggregateChild(SCORING_PROPERTY, this);
    this.groupByScoring(scoring);
    return scoring;
  }

  public ScoringRequest endAtScoring(String retName) {
    return endAtScoring(retName, ScoringRequest.newInstance());
  }

  public ScoringRequest endAtScoring(String retName, ScoringRequest scoring) {
    scoring.addDynamicProperty(retName, this, SCORING_PROPERTY);
    return scoring;
  }

  public EmployeeCompanyTrainingRequest filterByScoring(String... scoring) {
    if (isEmptyParam(scoring)) {
      throw new IllegalArgumentException("filterByScoring(String... scoring)参数不能为空!");
    }
    return where(SCORING_PROPERTY, QueryOperator.IN, (Object[]) scoring);
  }

  public EmployeeCompanyTrainingRequest filterByScoring(
      ScoringRequest scoring, IDRefine<Scoring> idRefine) {
    scoring.unlimited();
    return addSearchCriteria(createScoringCriteria(scoring, idRefine));
  }

  public SearchCriteria createScoringCriteria(ScoringRequest scoring, IDRefine<Scoring> idRefine) {
    return new RefinedIdInCriteria(scoring, SCORING_PROPERTY, idRefine, Scoring.ID_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest selectScoring() {
    return selectScoring(ScoringRequest.newInstance().selectSelf());
  }

  public EmployeeCompanyTrainingRequest selectScoring(ScoringRequest scoring) {
    selectParent(SCORING_PROPERTY, scoring);
    return this;
  }

  public EmployeeCompanyTrainingRequest unselectScoring() {
    unselectParent(SCORING_PROPERTY);
    return this;
  }

  public EmployeeCompanyTrainingRequest groupByScoring(ScoringRequest scoring) {
    groupBy(SCORING_PROPERTY, scoring);
    return this;
  }

  public EmployeeCompanyTrainingRequest aggregateScoring(ScoringRequest scoring) {
    aggregateParent(SCORING_PROPERTY, scoring);
    return this;
  }

  public EmployeeCompanyTrainingRequest countScoring() {
    return countScoring("countScoring");
  }

  public EmployeeCompanyTrainingRequest countScoring(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SCORING_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByScoring() {
    return groupByScoring(SCORING_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest groupByScoring(String ret) {
    return groupBy(ret, SCORING_PROPERTY);
  }

  public EmployeeCompanyTrainingRequest whereScoringIsNull() {
    return where(SCORING_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeCompanyTrainingRequest whereScoringIsNotNull() {
    return where(SCORING_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeCompanyTrainingRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeCompanyTrainingRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeCompanyTrainingRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeCompanyTrainingRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
