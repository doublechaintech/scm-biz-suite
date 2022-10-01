package com.doublechaintech.retailscm.terminationreason;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.termination.Termination;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.termination.TerminationRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.terminationreason.TerminationReason.*;

public class TerminationReasonRequest extends BaseRequest<TerminationReason> {
  public static TerminationReasonRequest newInstance() {
    return new TerminationReasonRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TerminationReasonRequest resultByClass(Class<? extends TerminationReason> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TerminationReasonRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TerminationReasonRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TerminationReason";
  }

  public TerminationReasonRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TerminationReasonRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TerminationReasonRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TerminationReasonRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TerminationReasonRequest selectAll() {
    return this.selectId().selectCode().selectCompany().selectDescription().selectVersion();
  }

  public TerminationReasonRequest selectAny() {
    return selectAll().selectTerminationList(Q.termination().selectSelf());
  }

  public TerminationReasonRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TerminationReasonRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TerminationReasonRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
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

  public TerminationReasonRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TerminationReasonRequest comment(String comment) {
    return this;
  }

  public TerminationReasonRequest enhance() {
    return this;
  }

  public TerminationReasonRequest overrideClass(Class<? extends TerminationReason> clazz) {
    return this;
  }

  public TerminationReasonRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TerminationReasonRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TerminationReasonRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TerminationReasonRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TerminationReasonRequest count() {
    return countId("count");
  }

  public static TerminationReasonRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TerminationReasonRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TerminationReasonRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationReasonRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TerminationReasonRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationReasonRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TerminationReasonRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TerminationReasonRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TerminationReasonRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TerminationReasonRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TerminationReasonRequest countId() {
    return countId("countId");
  }

  public TerminationReasonRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TerminationReasonRequest maxId() {
    return maxId("maxId");
  }

  public TerminationReasonRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TerminationReasonRequest minId() {
    return minId("minId");
  }

  public TerminationReasonRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TerminationReasonRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TerminationReasonRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TerminationReasonRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TerminationReasonRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TerminationReasonRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public TerminationReasonRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationReasonRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationReasonRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationReasonRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public TerminationReasonRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationReasonRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public TerminationReasonRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public TerminationReasonRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public TerminationReasonRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public TerminationReasonRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public TerminationReasonRequest countCode() {
    return countCode("countCode");
  }

  public TerminationReasonRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public TerminationReasonRequest maxCode() {
    return maxCode("maxCode");
  }

  public TerminationReasonRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public TerminationReasonRequest minCode() {
    return minCode("minCode");
  }

  public TerminationReasonRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public TerminationReasonRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public TerminationReasonRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public TerminationReasonRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public TerminationReasonRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public TerminationReasonRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public TerminationReasonRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationReasonRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationReasonRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationReasonRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public TerminationReasonRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationReasonRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public TerminationReasonRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public TerminationReasonRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public TerminationReasonRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public TerminationReasonRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public TerminationReasonRequest countDescription() {
    return countDescription("countDescription");
  }

  public TerminationReasonRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public TerminationReasonRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public TerminationReasonRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public TerminationReasonRequest minDescription() {
    return minDescription("minDescription");
  }

  public TerminationReasonRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public TerminationReasonRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public TerminationReasonRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public TerminationReasonRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public TerminationReasonRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public TerminationReasonRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TerminationReasonRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationReasonRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationReasonRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationReasonRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TerminationReasonRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationReasonRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TerminationReasonRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TerminationReasonRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TerminationReasonRequest countVersion() {
    return countVersion("countVersion");
  }

  public TerminationReasonRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TerminationReasonRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TerminationReasonRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TerminationReasonRequest minVersion() {
    return minVersion("minVersion");
  }

  public TerminationReasonRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TerminationReasonRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TerminationReasonRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TerminationReasonRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TerminationReasonRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TerminationReasonRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TerminationReasonRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TerminationReasonRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public TerminationReasonRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public TerminationReasonRequest selectCompanyId() {
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

  public TerminationReasonRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public TerminationReasonRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public TerminationReasonRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public TerminationReasonRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public TerminationReasonRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public TerminationReasonRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public TerminationReasonRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public TerminationReasonRequest countCompany() {
    return countCompany("countCompany");
  }

  public TerminationReasonRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public TerminationReasonRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public TerminationReasonRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public TerminationReasonRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationReasonRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationReasonRequest hasTermination() {
    return hasTermination(TerminationRequest.newInstance());
  }

  public TerminationReasonRequest hasTermination(Termination... termination) {
    if (isEmptyParam(termination)) {
      throw new IllegalArgumentException("hasTermination(Termination... termination)参数不能为空!");
    }
    return hasTermination(
        Q.termination()
            .select(Termination.REASON_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) termination));
  }

  public TerminationReasonRequest hasTermination(String... termination) {
    return hasTermination(
        Q.termination().select(Termination.REASON_PROPERTY).filterById(termination));
  }

  public TerminationReasonRequest hasTermination(TerminationRequest termination) {
    return hasTermination(
        termination,
        $termination ->
            java.util.Optional.of($termination)
                .map(Termination::getReason)
                .map(TerminationReason::getId)
                .orElse(null));
  }

  public TerminationReasonRequest hasTermination(
      TerminationRequest termination, IDRefine<Termination> idRefine) {
    termination.select(Termination.REASON_PROPERTY);
    termination.unlimited();
    return addSearchCriteria(createTerminationCriteria(termination, idRefine));
  }

  public TerminationReasonRequest hasTermination(
      TerminationRequest termination, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(termination, Termination.REASON_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTerminationCriteria(
      TerminationRequest termination, IDRefine<Termination> idRefine) {
    return new RefinedIdInCriteria(termination, ID_PROPERTY, idRefine, Termination.REASON_PROPERTY);
  }

  public TerminationReasonRequest selectTerminationList(TerminationRequest termination) {
    selectChild(Termination.REASON_PROPERTY, termination);
    return this;
  }

  public TerminationReasonRequest selectTerminationList() {
    return selectTerminationList(TerminationRequest.newInstance().selectAll());
  }

  public TerminationReasonRequest unselectTerminationList() {
    unselectChild(Termination.REASON_PROPERTY, Termination.class);
    return this;
  }

  public TerminationReasonRequest aggregateTerminationList(TerminationRequest termination) {
    aggregateChild(Termination.REASON_PROPERTY, termination);
    return this;
  }

  public TerminationReasonRequest countTermination() {
    return countTermination("terminationCount");
  }

  public TerminationReasonRequest countTermination(String retName) {
    return countTermination(retName, TerminationRequest.newInstance());
  }

  public TerminationReasonRequest countTermination(TerminationRequest termination) {
    return countTermination("terminationCount", termination);
  }

  public TerminationReasonRequest countTermination(String retName, TerminationRequest termination) {
    termination.count();
    return statsFromTermination(retName, termination);
  }

  public TerminationReasonRequest statsFromTermination(
      String retName, TerminationRequest termination) {
    return addDynamicProperty(retName, termination, Termination.REASON_PROPERTY);
  }

  public TerminationReasonRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TerminationReasonRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TerminationReasonRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TerminationReasonRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
