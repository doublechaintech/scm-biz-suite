package com.doublechaintech.retailscm.employeeskill;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.skilltype.SkillTypeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeskill.EmployeeSkill.*;

public class EmployeeSkillRequest extends BaseRequest<EmployeeSkill> {
  public static EmployeeSkillRequest newInstance() {
    return new EmployeeSkillRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeSkillRequest resultByClass(Class<? extends EmployeeSkill> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeSkillRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeSkillRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeSkill";
  }

  public EmployeeSkillRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeSkillRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeSkillRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeSkillRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeSkillRequest selectAll() {
    return this.selectId().selectEmployee().selectSkillType().selectDescription().selectVersion();
  }

  public EmployeeSkillRequest selectAny() {
    return selectAll();
  }

  public EmployeeSkillRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(SKILL_TYPE_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeSkillRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeSkillRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, EMPLOYEE_PROPERTY, SKILL_TYPE_PROPERTY, DESCRIPTION_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public EmployeeSkillRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeSkillRequest comment(String comment) {
    return this;
  }

  public EmployeeSkillRequest enhance() {
    return this;
  }

  public EmployeeSkillRequest overrideClass(Class<? extends EmployeeSkill> clazz) {
    return this;
  }

  public EmployeeSkillRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeSkillRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeSkillRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeSkillRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeSkillRequest count() {
    return countId("count");
  }

  public static EmployeeSkillRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeSkillRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeSkillRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSkillRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeSkillRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSkillRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeSkillRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeSkillRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeSkillRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeSkillRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeSkillRequest countId() {
    return countId("countId");
  }

  public EmployeeSkillRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeSkillRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeSkillRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeSkillRequest minId() {
    return minId("minId");
  }

  public EmployeeSkillRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeSkillRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeSkillRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeSkillRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeSkillRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeSkillRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public EmployeeSkillRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSkillRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSkillRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSkillRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public EmployeeSkillRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSkillRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public EmployeeSkillRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public EmployeeSkillRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public EmployeeSkillRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public EmployeeSkillRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public EmployeeSkillRequest countDescription() {
    return countDescription("countDescription");
  }

  public EmployeeSkillRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public EmployeeSkillRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public EmployeeSkillRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public EmployeeSkillRequest minDescription() {
    return minDescription("minDescription");
  }

  public EmployeeSkillRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public EmployeeSkillRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public EmployeeSkillRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public EmployeeSkillRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public EmployeeSkillRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public EmployeeSkillRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeSkillRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSkillRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSkillRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSkillRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeSkillRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSkillRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeSkillRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeSkillRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeSkillRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeSkillRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeSkillRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeSkillRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeSkillRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeSkillRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeSkillRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeSkillRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeSkillRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeSkillRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeSkillRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeSkillRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeSkillRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeSkillRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeSkillRequest selectEmployeeId() {
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

  public EmployeeSkillRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeSkillRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeSkillRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeSkillRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeSkillRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeSkillRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeSkillRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeSkillRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeSkillRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeSkillRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeSkillRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeSkillRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSkillRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSkillRequest filterBySkillType(SkillTypeRequest skillType) {
    return filterBySkillType(skillType, SkillType::getId);
  }

  public EmployeeSkillRequest filterBySkillType(SkillType... skillType) {
    if (isEmptyParam(skillType)) {
      throw new IllegalArgumentException("filterBySkillType(SkillType... skillType)参数不能为空!");
    }
    return where(SKILL_TYPE_PROPERTY, QueryOperator.IN, (Object[]) skillType);
  }

  public EmployeeSkillRequest selectSkillTypeId() {
    select(SKILL_TYPE_PROPERTY);
    return this;
  }

  public SkillTypeRequest upToSkillType() {
    return upToSkillType(SkillTypeRequest.newInstance());
  }

  public SkillTypeRequest upToSkillType(SkillTypeRequest skillType) {
    skillType.aggregateChild(SKILL_TYPE_PROPERTY, this);
    this.groupBySkillType(skillType);
    return skillType;
  }

  public SkillTypeRequest endAtSkillType(String retName) {
    return endAtSkillType(retName, SkillTypeRequest.newInstance());
  }

  public SkillTypeRequest endAtSkillType(String retName, SkillTypeRequest skillType) {
    skillType.addDynamicProperty(retName, this, SKILL_TYPE_PROPERTY);
    return skillType;
  }

  public EmployeeSkillRequest filterBySkillType(String... skillType) {
    if (isEmptyParam(skillType)) {
      throw new IllegalArgumentException("filterBySkillType(String... skillType)参数不能为空!");
    }
    return where(SKILL_TYPE_PROPERTY, QueryOperator.IN, (Object[]) skillType);
  }

  public EmployeeSkillRequest filterBySkillType(
      SkillTypeRequest skillType, IDRefine<SkillType> idRefine) {
    skillType.unlimited();
    return addSearchCriteria(createSkillTypeCriteria(skillType, idRefine));
  }

  public SearchCriteria createSkillTypeCriteria(
      SkillTypeRequest skillType, IDRefine<SkillType> idRefine) {
    return new RefinedIdInCriteria(skillType, SKILL_TYPE_PROPERTY, idRefine, SkillType.ID_PROPERTY);
  }

  public EmployeeSkillRequest selectSkillType() {
    return selectSkillType(SkillTypeRequest.newInstance().selectSelf());
  }

  public EmployeeSkillRequest selectSkillType(SkillTypeRequest skillType) {
    selectParent(SKILL_TYPE_PROPERTY, skillType);
    return this;
  }

  public EmployeeSkillRequest unselectSkillType() {
    unselectParent(SKILL_TYPE_PROPERTY);
    return this;
  }

  public EmployeeSkillRequest groupBySkillType(SkillTypeRequest skillType) {
    groupBy(SKILL_TYPE_PROPERTY, skillType);
    return this;
  }

  public EmployeeSkillRequest aggregateSkillType(SkillTypeRequest skillType) {
    aggregateParent(SKILL_TYPE_PROPERTY, skillType);
    return this;
  }

  public EmployeeSkillRequest countSkillType() {
    return countSkillType("countSkillType");
  }

  public EmployeeSkillRequest countSkillType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SKILL_TYPE_PROPERTY);
  }

  public EmployeeSkillRequest groupBySkillType() {
    return groupBySkillType(SKILL_TYPE_PROPERTY);
  }

  public EmployeeSkillRequest groupBySkillType(String ret) {
    return groupBy(ret, SKILL_TYPE_PROPERTY);
  }

  public EmployeeSkillRequest whereSkillTypeIsNull() {
    return where(SKILL_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSkillRequest whereSkillTypeIsNotNull() {
    return where(SKILL_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSkillRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeSkillRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeSkillRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeSkillRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
