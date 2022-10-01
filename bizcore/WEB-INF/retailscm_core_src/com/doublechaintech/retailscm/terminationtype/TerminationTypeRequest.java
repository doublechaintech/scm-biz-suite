package com.doublechaintech.retailscm.terminationtype;

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
import static com.doublechaintech.retailscm.terminationtype.TerminationType.*;

public class TerminationTypeRequest extends BaseRequest<TerminationType> {
  public static TerminationTypeRequest newInstance() {
    return new TerminationTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TerminationTypeRequest resultByClass(Class<? extends TerminationType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TerminationTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TerminationTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TerminationType";
  }

  public TerminationTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TerminationTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TerminationTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TerminationTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TerminationTypeRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectBaseDescription()
        .selectDetailDescription()
        .selectVersion();
  }

  public TerminationTypeRequest selectAny() {
    return selectAll().selectTerminationList(Q.termination().selectSelf());
  }

  public TerminationTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(BASE_DESCRIPTION_PROPERTY);
    select(DETAIL_DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TerminationTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TerminationTypeRequest where(
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
    BASE_DESCRIPTION_PROPERTY,
    DETAIL_DESCRIPTION_PROPERTY,
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

  public TerminationTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TerminationTypeRequest comment(String comment) {
    return this;
  }

  public TerminationTypeRequest enhance() {
    return this;
  }

  public TerminationTypeRequest overrideClass(Class<? extends TerminationType> clazz) {
    return this;
  }

  public TerminationTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TerminationTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TerminationTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TerminationTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TerminationTypeRequest count() {
    return countId("count");
  }

  public static TerminationTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TerminationTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TerminationTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TerminationTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TerminationTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TerminationTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TerminationTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TerminationTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TerminationTypeRequest countId() {
    return countId("countId");
  }

  public TerminationTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TerminationTypeRequest maxId() {
    return maxId("maxId");
  }

  public TerminationTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TerminationTypeRequest minId() {
    return minId("minId");
  }

  public TerminationTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TerminationTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TerminationTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TerminationTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TerminationTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TerminationTypeRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public TerminationTypeRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationTypeRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public TerminationTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public TerminationTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public TerminationTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public TerminationTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public TerminationTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public TerminationTypeRequest countCode() {
    return countCode("countCode");
  }

  public TerminationTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public TerminationTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public TerminationTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public TerminationTypeRequest minCode() {
    return minCode("minCode");
  }

  public TerminationTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public TerminationTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public TerminationTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public TerminationTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public TerminationTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public TerminationTypeRequest filterByBaseDescription(String baseDescription) {

    if (baseDescription == null) {
      return this;
    }

    return filterByBaseDescription(QueryOperator.EQUAL, baseDescription);
  }

  public TerminationTypeRequest whereBaseDescriptionIsNull() {
    return where(BASE_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationTypeRequest whereBaseDescriptionIsNotNull() {
    return where(BASE_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationTypeRequest filterByBaseDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBaseDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationTypeRequest selectBaseDescription() {
    return select(BASE_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest unselectBaseDescription() {
    return unselect(BASE_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getBaseDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BASE_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationTypeRequest orderByBaseDescription(boolean asc) {
    addOrderBy(BASE_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public TerminationTypeRequest orderByBaseDescriptionAscending() {
    addOrderBy(BASE_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public TerminationTypeRequest orderByBaseDescriptionDescending() {
    addOrderBy(BASE_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public TerminationTypeRequest orderByBaseDescriptionAscendingUsingGBK() {
    addOrderBy("convert(baseDescription using gbk)", true);
    return this;
  }

  public TerminationTypeRequest orderByBaseDescriptionDescendingUsingGBK() {
    addOrderBy("convert(baseDescription using gbk)", false);
    return this;
  }

  public TerminationTypeRequest countBaseDescription() {
    return countBaseDescription("countBaseDescription");
  }

  public TerminationTypeRequest countBaseDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BASE_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest maxBaseDescription() {
    return maxBaseDescription("maxBaseDescription");
  }

  public TerminationTypeRequest maxBaseDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BASE_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest minBaseDescription() {
    return minBaseDescription("minBaseDescription");
  }

  public TerminationTypeRequest minBaseDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BASE_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest groupByBaseDescription() {
    return groupByBaseDescription(BASE_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest groupByBaseDescription(String ret) {
    return groupBy(ret, BASE_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest groupByBaseDescription(SqlFunction func) {
    return groupByBaseDescription(BASE_DESCRIPTION_PROPERTY, func);
  }

  public TerminationTypeRequest groupByBaseDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, BASE_DESCRIPTION_PROPERTY);
    return this;
  }

  public TerminationTypeRequest filterByDetailDescription(String detailDescription) {

    if (detailDescription == null) {
      return this;
    }

    return filterByDetailDescription(QueryOperator.EQUAL, detailDescription);
  }

  public TerminationTypeRequest whereDetailDescriptionIsNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationTypeRequest whereDetailDescriptionIsNotNull() {
    return where(DETAIL_DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationTypeRequest filterByDetailDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDetailDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationTypeRequest selectDetailDescription() {
    return select(DETAIL_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest unselectDetailDescription() {
    return unselect(DETAIL_DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDetailDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DETAIL_DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationTypeRequest orderByDetailDescription(boolean asc) {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public TerminationTypeRequest orderByDetailDescriptionAscending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, true);
    return this;
  }

  public TerminationTypeRequest orderByDetailDescriptionDescending() {
    addOrderBy(DETAIL_DESCRIPTION_PROPERTY, false);
    return this;
  }

  public TerminationTypeRequest orderByDetailDescriptionAscendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", true);
    return this;
  }

  public TerminationTypeRequest orderByDetailDescriptionDescendingUsingGBK() {
    addOrderBy("convert(detailDescription using gbk)", false);
    return this;
  }

  public TerminationTypeRequest countDetailDescription() {
    return countDetailDescription("countDetailDescription");
  }

  public TerminationTypeRequest countDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DETAIL_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest maxDetailDescription() {
    return maxDetailDescription("maxDetailDescription");
  }

  public TerminationTypeRequest maxDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DETAIL_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest minDetailDescription() {
    return minDetailDescription("minDetailDescription");
  }

  public TerminationTypeRequest minDetailDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DETAIL_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest groupByDetailDescription() {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest groupByDetailDescription(String ret) {
    return groupBy(ret, DETAIL_DESCRIPTION_PROPERTY);
  }

  public TerminationTypeRequest groupByDetailDescription(SqlFunction func) {
    return groupByDetailDescription(DETAIL_DESCRIPTION_PROPERTY, func);
  }

  public TerminationTypeRequest groupByDetailDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DETAIL_DESCRIPTION_PROPERTY);
    return this;
  }

  public TerminationTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TerminationTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationTypeRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TerminationTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TerminationTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TerminationTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TerminationTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TerminationTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TerminationTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public TerminationTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TerminationTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TerminationTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TerminationTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public TerminationTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TerminationTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TerminationTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TerminationTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TerminationTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TerminationTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TerminationTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TerminationTypeRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public TerminationTypeRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public TerminationTypeRequest selectCompanyId() {
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

  public TerminationTypeRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public TerminationTypeRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public TerminationTypeRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public TerminationTypeRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public TerminationTypeRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public TerminationTypeRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public TerminationTypeRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public TerminationTypeRequest countCompany() {
    return countCompany("countCompany");
  }

  public TerminationTypeRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public TerminationTypeRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public TerminationTypeRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public TerminationTypeRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public TerminationTypeRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TerminationTypeRequest hasTermination() {
    return hasTermination(TerminationRequest.newInstance());
  }

  public TerminationTypeRequest hasTermination(Termination... termination) {
    if (isEmptyParam(termination)) {
      throw new IllegalArgumentException("hasTermination(Termination... termination)参数不能为空!");
    }
    return hasTermination(
        Q.termination()
            .select(Termination.TYPE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) termination));
  }

  public TerminationTypeRequest hasTermination(String... termination) {
    return hasTermination(
        Q.termination().select(Termination.TYPE_PROPERTY).filterById(termination));
  }

  public TerminationTypeRequest hasTermination(TerminationRequest termination) {
    return hasTermination(
        termination,
        $termination ->
            java.util.Optional.of($termination)
                .map(Termination::getType)
                .map(TerminationType::getId)
                .orElse(null));
  }

  public TerminationTypeRequest hasTermination(
      TerminationRequest termination, IDRefine<Termination> idRefine) {
    termination.select(Termination.TYPE_PROPERTY);
    termination.unlimited();
    return addSearchCriteria(createTerminationCriteria(termination, idRefine));
  }

  public TerminationTypeRequest hasTermination(
      TerminationRequest termination, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(termination, Termination.TYPE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTerminationCriteria(
      TerminationRequest termination, IDRefine<Termination> idRefine) {
    return new RefinedIdInCriteria(termination, ID_PROPERTY, idRefine, Termination.TYPE_PROPERTY);
  }

  public TerminationTypeRequest selectTerminationList(TerminationRequest termination) {
    selectChild(Termination.TYPE_PROPERTY, termination);
    return this;
  }

  public TerminationTypeRequest selectTerminationList() {
    return selectTerminationList(TerminationRequest.newInstance().selectAll());
  }

  public TerminationTypeRequest unselectTerminationList() {
    unselectChild(Termination.TYPE_PROPERTY, Termination.class);
    return this;
  }

  public TerminationTypeRequest aggregateTerminationList(TerminationRequest termination) {
    aggregateChild(Termination.TYPE_PROPERTY, termination);
    return this;
  }

  public TerminationTypeRequest countTermination() {
    return countTermination("terminationCount");
  }

  public TerminationTypeRequest countTermination(String retName) {
    return countTermination(retName, TerminationRequest.newInstance());
  }

  public TerminationTypeRequest countTermination(TerminationRequest termination) {
    return countTermination("terminationCount", termination);
  }

  public TerminationTypeRequest countTermination(String retName, TerminationRequest termination) {
    termination.count();
    return statsFromTermination(retName, termination);
  }

  public TerminationTypeRequest statsFromTermination(
      String retName, TerminationRequest termination) {
    return addDynamicProperty(retName, termination, Termination.TYPE_PROPERTY);
  }

  public TerminationTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TerminationTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TerminationTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TerminationTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
