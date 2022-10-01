package com.doublechaintech.retailscm.trainingcoursetype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType.*;

public class TrainingCourseTypeRequest extends BaseRequest<TrainingCourseType> {
  public static TrainingCourseTypeRequest newInstance() {
    return new TrainingCourseTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TrainingCourseTypeRequest resultByClass(Class<? extends TrainingCourseType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TrainingCourseTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TrainingCourseTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TrainingCourseType";
  }

  public TrainingCourseTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TrainingCourseTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TrainingCourseTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TrainingCourseTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TrainingCourseTypeRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectName()
        .selectDescription()
        .selectVersion();
  }

  public TrainingCourseTypeRequest selectAny() {
    return selectAll().selectCompanyTrainingList(Q.companyTraining().selectSelf());
  }

  public TrainingCourseTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(NAME_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TrainingCourseTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TrainingCourseTypeRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    CODE_PROPERTY,
    COMPANY_PROPERTY,
    NAME_PROPERTY,
    DESCRIPTION_PROPERTY,
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

  public TrainingCourseTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TrainingCourseTypeRequest comment(String comment) {
    return this;
  }

  public TrainingCourseTypeRequest enhance() {
    return this;
  }

  public TrainingCourseTypeRequest overrideClass(Class<? extends TrainingCourseType> clazz) {
    return this;
  }

  public TrainingCourseTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TrainingCourseTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TrainingCourseTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TrainingCourseTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TrainingCourseTypeRequest count() {
    return countId("count");
  }

  public static TrainingCourseTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TrainingCourseTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TrainingCourseTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TrainingCourseTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TrainingCourseTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TrainingCourseTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TrainingCourseTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TrainingCourseTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TrainingCourseTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TrainingCourseTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TrainingCourseTypeRequest countId() {
    return countId("countId");
  }

  public TrainingCourseTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TrainingCourseTypeRequest maxId() {
    return maxId("maxId");
  }

  public TrainingCourseTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TrainingCourseTypeRequest minId() {
    return minId("minId");
  }

  public TrainingCourseTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TrainingCourseTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TrainingCourseTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TrainingCourseTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TrainingCourseTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TrainingCourseTypeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public TrainingCourseTypeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TrainingCourseTypeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TrainingCourseTypeRequest filterByCode(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TrainingCourseTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public TrainingCourseTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TrainingCourseTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public TrainingCourseTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public TrainingCourseTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public TrainingCourseTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public TrainingCourseTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public TrainingCourseTypeRequest countCode() {
    return countCode("countCode");
  }

  public TrainingCourseTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public TrainingCourseTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public TrainingCourseTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public TrainingCourseTypeRequest minCode() {
    return minCode("minCode");
  }

  public TrainingCourseTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public TrainingCourseTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public TrainingCourseTypeRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public TrainingCourseTypeRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TrainingCourseTypeRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TrainingCourseTypeRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TrainingCourseTypeRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public TrainingCourseTypeRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TrainingCourseTypeRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public TrainingCourseTypeRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public TrainingCourseTypeRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public TrainingCourseTypeRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public TrainingCourseTypeRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public TrainingCourseTypeRequest countName() {
    return countName("countName");
  }

  public TrainingCourseTypeRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public TrainingCourseTypeRequest maxName() {
    return maxName("maxName");
  }

  public TrainingCourseTypeRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public TrainingCourseTypeRequest minName() {
    return minName("minName");
  }

  public TrainingCourseTypeRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public TrainingCourseTypeRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public TrainingCourseTypeRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public TrainingCourseTypeRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TrainingCourseTypeRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TrainingCourseTypeRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TrainingCourseTypeRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public TrainingCourseTypeRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TrainingCourseTypeRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public TrainingCourseTypeRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public TrainingCourseTypeRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public TrainingCourseTypeRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public TrainingCourseTypeRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public TrainingCourseTypeRequest countDescription() {
    return countDescription("countDescription");
  }

  public TrainingCourseTypeRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public TrainingCourseTypeRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public TrainingCourseTypeRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public TrainingCourseTypeRequest minDescription() {
    return minDescription("minDescription");
  }

  public TrainingCourseTypeRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public TrainingCourseTypeRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public TrainingCourseTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TrainingCourseTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TrainingCourseTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TrainingCourseTypeRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TrainingCourseTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TrainingCourseTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TrainingCourseTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TrainingCourseTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TrainingCourseTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TrainingCourseTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public TrainingCourseTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TrainingCourseTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TrainingCourseTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TrainingCourseTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public TrainingCourseTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TrainingCourseTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TrainingCourseTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TrainingCourseTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TrainingCourseTypeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public TrainingCourseTypeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public TrainingCourseTypeRequest selectCompanyId() {
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

  public TrainingCourseTypeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public TrainingCourseTypeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public TrainingCourseTypeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public TrainingCourseTypeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public TrainingCourseTypeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public TrainingCourseTypeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public TrainingCourseTypeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public TrainingCourseTypeRequest countCompany() {
    return countCompany("countCompany");
  }

  public TrainingCourseTypeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public TrainingCourseTypeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public TrainingCourseTypeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public TrainingCourseTypeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TrainingCourseTypeRequest hasCompanyTraining() {
    return hasCompanyTraining(CompanyTrainingRequest.newInstance());
  }

  public TrainingCourseTypeRequest hasCompanyTraining(CompanyTraining... companyTraining) {
    if (isEmptyParam(companyTraining)) {
      throw new IllegalArgumentException(
          "hasCompanyTraining(CompanyTraining... companyTraining)参数不能为空!");
    }
    return hasCompanyTraining(
        Q.companyTraining()
            .select(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) companyTraining));
  }

  public TrainingCourseTypeRequest hasCompanyTraining(String... companyTraining) {
    return hasCompanyTraining(
        Q.companyTraining()
            .select(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY)
            .filterById(companyTraining));
  }

  public TrainingCourseTypeRequest hasCompanyTraining(CompanyTrainingRequest companyTraining) {
    return hasCompanyTraining(
        companyTraining,
        $companyTraining ->
            java.util.Optional.of($companyTraining)
                .map(CompanyTraining::getTrainingCourseType)
                .map(TrainingCourseType::getId)
                .orElse(null));
  }

  public TrainingCourseTypeRequest hasCompanyTraining(
      CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
    companyTraining.select(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY);
    companyTraining.unlimited();
    return addSearchCriteria(createCompanyTrainingCriteria(companyTraining, idRefine));
  }

  public TrainingCourseTypeRequest hasCompanyTraining(
      CompanyTrainingRequest companyTraining, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            companyTraining, CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createCompanyTrainingCriteria(
      CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
    return new RefinedIdInCriteria(
        companyTraining, ID_PROPERTY, idRefine, CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY);
  }

  public TrainingCourseTypeRequest selectCompanyTrainingList(
      CompanyTrainingRequest companyTraining) {
    selectChild(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, companyTraining);
    return this;
  }

  public TrainingCourseTypeRequest selectCompanyTrainingList() {
    return selectCompanyTrainingList(CompanyTrainingRequest.newInstance().selectAll());
  }

  public TrainingCourseTypeRequest unselectCompanyTrainingList() {
    unselectChild(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, CompanyTraining.class);
    return this;
  }

  public TrainingCourseTypeRequest aggregateCompanyTrainingList(
      CompanyTrainingRequest companyTraining) {
    aggregateChild(CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY, companyTraining);
    return this;
  }

  public TrainingCourseTypeRequest countCompanyTraining() {
    return countCompanyTraining("companyTrainingCount");
  }

  public TrainingCourseTypeRequest countCompanyTraining(String retName) {
    return countCompanyTraining(retName, CompanyTrainingRequest.newInstance());
  }

  public TrainingCourseTypeRequest countCompanyTraining(CompanyTrainingRequest companyTraining) {
    return countCompanyTraining("companyTrainingCount", companyTraining);
  }

  public TrainingCourseTypeRequest countCompanyTraining(
      String retName, CompanyTrainingRequest companyTraining) {
    companyTraining.count();
    return statsFromCompanyTraining(retName, companyTraining);
  }

  public TrainingCourseTypeRequest statsFromCompanyTraining(
      String retName, CompanyTrainingRequest companyTraining) {
    return addDynamicProperty(
        retName, companyTraining, CompanyTraining.TRAINING_COURSE_TYPE_PROPERTY);
  }

  public TrainingCourseTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TrainingCourseTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TrainingCourseTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TrainingCourseTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
