package com.doublechaintech.retailscm.skilltype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.skilltype.SkillType.*;

public class SkillTypeRequest extends BaseRequest<SkillType> {
  public static SkillTypeRequest newInstance() {
    return new SkillTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SkillTypeRequest resultByClass(Class<? extends SkillType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SkillTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SkillTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SkillType";
  }

  public SkillTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SkillTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SkillTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SkillTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SkillTypeRequest selectAll() {
    return this.selectId().selectCode().selectCompany().selectDescription().selectVersion();
  }

  public SkillTypeRequest selectAny() {
    return selectAll().selectEmployeeSkillList(Q.employeeSkill().selectSelf());
  }

  public SkillTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SkillTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SkillTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, CODE_PROPERTY, COMPANY_PROPERTY, DESCRIPTION_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public SkillTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SkillTypeRequest comment(String comment) {
    return this;
  }

  public SkillTypeRequest enhance() {
    return this;
  }

  public SkillTypeRequest overrideClass(Class<? extends SkillType> clazz) {
    return this;
  }

  public SkillTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SkillTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SkillTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SkillTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SkillTypeRequest count() {
    return countId("count");
  }

  public static SkillTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SkillTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SkillTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkillTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SkillTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkillTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SkillTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SkillTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SkillTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SkillTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SkillTypeRequest countId() {
    return countId("countId");
  }

  public SkillTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SkillTypeRequest maxId() {
    return maxId("maxId");
  }

  public SkillTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SkillTypeRequest minId() {
    return minId("minId");
  }

  public SkillTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SkillTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SkillTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SkillTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SkillTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SkillTypeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public SkillTypeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkillTypeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkillTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkillTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public SkillTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkillTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public SkillTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public SkillTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public SkillTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public SkillTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public SkillTypeRequest countCode() {
    return countCode("countCode");
  }

  public SkillTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public SkillTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public SkillTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public SkillTypeRequest minCode() {
    return minCode("minCode");
  }

  public SkillTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public SkillTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public SkillTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public SkillTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public SkillTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public SkillTypeRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public SkillTypeRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkillTypeRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkillTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkillTypeRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public SkillTypeRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkillTypeRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public SkillTypeRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public SkillTypeRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public SkillTypeRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public SkillTypeRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public SkillTypeRequest countDescription() {
    return countDescription("countDescription");
  }

  public SkillTypeRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public SkillTypeRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public SkillTypeRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public SkillTypeRequest minDescription() {
    return minDescription("minDescription");
  }

  public SkillTypeRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public SkillTypeRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public SkillTypeRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public SkillTypeRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public SkillTypeRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public SkillTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SkillTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkillTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkillTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SkillTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SkillTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SkillTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SkillTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SkillTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SkillTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public SkillTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SkillTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SkillTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SkillTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public SkillTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SkillTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SkillTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SkillTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SkillTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SkillTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SkillTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SkillTypeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public SkillTypeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public SkillTypeRequest selectCompanyId() {
    select(COMPANY_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToCompany() {
    return upToCompany(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToCompany(RetailStoreCountryCenterRequest company) {
    company.aggregateChild(COMPANY_PROPERTY, this);
    this.groupByCompany(company);
    return company;
  }

  public RetailStoreCountryCenterRequest endAtCompany(String retName) {
    return endAtCompany(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtCompany(
      String retName, RetailStoreCountryCenterRequest company) {
    company.addDynamicProperty(retName, this, COMPANY_PROPERTY);
    return company;
  }

  public SkillTypeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public SkillTypeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public SkillTypeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public SkillTypeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public SkillTypeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public SkillTypeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public SkillTypeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public SkillTypeRequest countCompany() {
    return countCompany("countCompany");
  }

  public SkillTypeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public SkillTypeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public SkillTypeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public SkillTypeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public SkillTypeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SkillTypeRequest hasEmployeeSkill() {
    return hasEmployeeSkill(EmployeeSkillRequest.newInstance());
  }

  public SkillTypeRequest hasEmployeeSkill(EmployeeSkill... employeeSkill) {
    if (isEmptyParam(employeeSkill)) {
      throw new IllegalArgumentException("hasEmployeeSkill(EmployeeSkill... employeeSkill)参数不能为空!");
    }
    return hasEmployeeSkill(
        Q.employeeSkill()
            .select(EmployeeSkill.SKILL_TYPE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employeeSkill));
  }

  public SkillTypeRequest hasEmployeeSkill(String... employeeSkill) {
    return hasEmployeeSkill(
        Q.employeeSkill().select(EmployeeSkill.SKILL_TYPE_PROPERTY).filterById(employeeSkill));
  }

  public SkillTypeRequest hasEmployeeSkill(EmployeeSkillRequest employeeSkill) {
    return hasEmployeeSkill(
        employeeSkill,
        $employeeSkill ->
            java.util.Optional.of($employeeSkill)
                .map(EmployeeSkill::getSkillType)
                .map(SkillType::getId)
                .orElse(null));
  }

  public SkillTypeRequest hasEmployeeSkill(
      EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine) {
    employeeSkill.select(EmployeeSkill.SKILL_TYPE_PROPERTY);
    employeeSkill.unlimited();
    return addSearchCriteria(createEmployeeSkillCriteria(employeeSkill, idRefine));
  }

  public SkillTypeRequest hasEmployeeSkill(
      EmployeeSkillRequest employeeSkill, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            employeeSkill, EmployeeSkill.SKILL_TYPE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeSkillCriteria(
      EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine) {
    return new RefinedIdInCriteria(
        employeeSkill, ID_PROPERTY, idRefine, EmployeeSkill.SKILL_TYPE_PROPERTY);
  }

  public SkillTypeRequest selectEmployeeSkillList(EmployeeSkillRequest employeeSkill) {
    selectChild(EmployeeSkill.SKILL_TYPE_PROPERTY, employeeSkill);
    return this;
  }

  public SkillTypeRequest selectEmployeeSkillList() {
    return selectEmployeeSkillList(EmployeeSkillRequest.newInstance().selectAll());
  }

  public SkillTypeRequest unselectEmployeeSkillList() {
    unselectChild(EmployeeSkill.SKILL_TYPE_PROPERTY, EmployeeSkill.class);
    return this;
  }

  public SkillTypeRequest aggregateEmployeeSkillList(EmployeeSkillRequest employeeSkill) {
    aggregateChild(EmployeeSkill.SKILL_TYPE_PROPERTY, employeeSkill);
    return this;
  }

  public SkillTypeRequest countEmployeeSkill() {
    return countEmployeeSkill("employeeSkillCount");
  }

  public SkillTypeRequest countEmployeeSkill(String retName) {
    return countEmployeeSkill(retName, EmployeeSkillRequest.newInstance());
  }

  public SkillTypeRequest countEmployeeSkill(EmployeeSkillRequest employeeSkill) {
    return countEmployeeSkill("employeeSkillCount", employeeSkill);
  }

  public SkillTypeRequest countEmployeeSkill(String retName, EmployeeSkillRequest employeeSkill) {
    employeeSkill.count();
    return statsFromEmployeeSkill(retName, employeeSkill);
  }

  public SkillTypeRequest statsFromEmployeeSkill(
      String retName, EmployeeSkillRequest employeeSkill) {
    return addDynamicProperty(retName, employeeSkill, EmployeeSkill.SKILL_TYPE_PROPERTY);
  }

  public SkillTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SkillTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SkillTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SkillTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
