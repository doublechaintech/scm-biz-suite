package com.doublechaintech.retailscm.publicholiday;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.publicholiday.PublicHoliday.*;

public class PublicHolidayRequest extends BaseRequest<PublicHoliday> {
  public static PublicHolidayRequest newInstance() {
    return new PublicHolidayRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PublicHolidayRequest resultByClass(Class<? extends PublicHoliday> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PublicHolidayRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PublicHolidayRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "PublicHoliday";
  }

  public PublicHolidayRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PublicHolidayRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PublicHolidayRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PublicHolidayRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PublicHolidayRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectCompany()
        .selectName()
        .selectDescription()
        .selectVersion();
  }

  public PublicHolidayRequest selectAny() {
    return selectAll();
  }

  public PublicHolidayRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(COMPANY_PROPERTY);
    select(NAME_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PublicHolidayRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PublicHolidayRequest where(
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

  public PublicHolidayRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PublicHolidayRequest comment(String comment) {
    return this;
  }

  public PublicHolidayRequest enhance() {
    return this;
  }

  public PublicHolidayRequest overrideClass(Class<? extends PublicHoliday> clazz) {
    return this;
  }

  public PublicHolidayRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PublicHolidayRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PublicHolidayRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PublicHolidayRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PublicHolidayRequest count() {
    return countId("count");
  }

  public static PublicHolidayRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public PublicHolidayRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PublicHolidayRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicHolidayRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PublicHolidayRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicHolidayRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PublicHolidayRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PublicHolidayRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PublicHolidayRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PublicHolidayRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PublicHolidayRequest countId() {
    return countId("countId");
  }

  public PublicHolidayRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PublicHolidayRequest maxId() {
    return maxId("maxId");
  }

  public PublicHolidayRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PublicHolidayRequest minId() {
    return minId("minId");
  }

  public PublicHolidayRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PublicHolidayRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PublicHolidayRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PublicHolidayRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PublicHolidayRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PublicHolidayRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public PublicHolidayRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicHolidayRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicHolidayRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicHolidayRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public PublicHolidayRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicHolidayRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public PublicHolidayRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public PublicHolidayRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public PublicHolidayRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public PublicHolidayRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public PublicHolidayRequest countCode() {
    return countCode("countCode");
  }

  public PublicHolidayRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public PublicHolidayRequest maxCode() {
    return maxCode("maxCode");
  }

  public PublicHolidayRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public PublicHolidayRequest minCode() {
    return minCode("minCode");
  }

  public PublicHolidayRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public PublicHolidayRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public PublicHolidayRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public PublicHolidayRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public PublicHolidayRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public PublicHolidayRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public PublicHolidayRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicHolidayRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicHolidayRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicHolidayRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public PublicHolidayRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicHolidayRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public PublicHolidayRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public PublicHolidayRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public PublicHolidayRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public PublicHolidayRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public PublicHolidayRequest countName() {
    return countName("countName");
  }

  public PublicHolidayRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public PublicHolidayRequest maxName() {
    return maxName("maxName");
  }

  public PublicHolidayRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public PublicHolidayRequest minName() {
    return minName("minName");
  }

  public PublicHolidayRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public PublicHolidayRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public PublicHolidayRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public PublicHolidayRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public PublicHolidayRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public PublicHolidayRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public PublicHolidayRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicHolidayRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicHolidayRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicHolidayRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public PublicHolidayRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicHolidayRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public PublicHolidayRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public PublicHolidayRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public PublicHolidayRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public PublicHolidayRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public PublicHolidayRequest countDescription() {
    return countDescription("countDescription");
  }

  public PublicHolidayRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public PublicHolidayRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public PublicHolidayRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public PublicHolidayRequest minDescription() {
    return minDescription("minDescription");
  }

  public PublicHolidayRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public PublicHolidayRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public PublicHolidayRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public PublicHolidayRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public PublicHolidayRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public PublicHolidayRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PublicHolidayRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicHolidayRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicHolidayRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PublicHolidayRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PublicHolidayRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PublicHolidayRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PublicHolidayRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PublicHolidayRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PublicHolidayRequest countVersion() {
    return countVersion("countVersion");
  }

  public PublicHolidayRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PublicHolidayRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PublicHolidayRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PublicHolidayRequest minVersion() {
    return minVersion("minVersion");
  }

  public PublicHolidayRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PublicHolidayRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PublicHolidayRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PublicHolidayRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PublicHolidayRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PublicHolidayRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PublicHolidayRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PublicHolidayRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public PublicHolidayRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public PublicHolidayRequest selectCompanyId() {
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

  public PublicHolidayRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public PublicHolidayRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public PublicHolidayRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public PublicHolidayRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public PublicHolidayRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public PublicHolidayRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public PublicHolidayRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public PublicHolidayRequest countCompany() {
    return countCompany("countCompany");
  }

  public PublicHolidayRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public PublicHolidayRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public PublicHolidayRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public PublicHolidayRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public PublicHolidayRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PublicHolidayRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PublicHolidayRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PublicHolidayRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PublicHolidayRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
