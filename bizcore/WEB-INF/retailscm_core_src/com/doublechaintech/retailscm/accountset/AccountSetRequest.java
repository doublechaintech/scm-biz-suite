package com.doublechaintech.retailscm.accountset;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;

import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountset.AccountSet.*;

public class AccountSetRequest extends BaseRequest<AccountSet> {
  public static AccountSetRequest newInstance() {
    return new AccountSetRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public AccountSetRequest resultByClass(Class<? extends AccountSet> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public AccountSetRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public AccountSetRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "AccountSet";
  }

  public AccountSetRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public AccountSetRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public AccountSetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public AccountSetRequest select(String... names) {
    super.select(names);
    return this;
  }

  public AccountSetRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectYearSet()
        .selectEffectiveDate()
        .selectAccountingSystem()
        .selectDomesticCurrencyCode()
        .selectDomesticCurrencyName()
        .selectOpeningBank()
        .selectAccountNumber()
        .selectCountryCenter()
        .selectRetailStore()
        .selectGoodsSupplier()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public AccountSetRequest selectAny() {
    return selectAll()
        .selectAccountingSubjectList(Q.accountingSubject().selectSelf())
        .selectAccountingPeriodList(Q.accountingPeriod().selectSelf())
        .selectAccountingDocumentTypeList(Q.accountingDocumentType().selectSelf());
  }

  public AccountSetRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(YEAR_SET_PROPERTY);
    select(EFFECTIVE_DATE_PROPERTY);
    select(ACCOUNTING_SYSTEM_PROPERTY);
    select(DOMESTIC_CURRENCY_CODE_PROPERTY);
    select(DOMESTIC_CURRENCY_NAME_PROPERTY);
    select(OPENING_BANK_PROPERTY);
    select(ACCOUNT_NUMBER_PROPERTY);
    select(COUNTRY_CENTER_PROPERTY);
    select(RETAIL_STORE_PROPERTY);
    select(GOODS_SUPPLIER_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public AccountSetRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public AccountSetRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {
    EFFECTIVE_DATE_PROPERTY, LAST_UPDATE_TIME_PROPERTY
  };
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    YEAR_SET_PROPERTY,
    EFFECTIVE_DATE_PROPERTY,
    ACCOUNTING_SYSTEM_PROPERTY,
    DOMESTIC_CURRENCY_CODE_PROPERTY,
    DOMESTIC_CURRENCY_NAME_PROPERTY,
    OPENING_BANK_PROPERTY,
    ACCOUNT_NUMBER_PROPERTY,
    COUNTRY_CENTER_PROPERTY,
    RETAIL_STORE_PROPERTY,
    GOODS_SUPPLIER_PROPERTY,
    LAST_UPDATE_TIME_PROPERTY,
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

  public AccountSetRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public AccountSetRequest comment(String comment) {
    return this;
  }

  public AccountSetRequest enhance() {
    return this;
  }

  public AccountSetRequest overrideClass(Class<? extends AccountSet> clazz) {
    return this;
  }

  public AccountSetRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public AccountSetRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public AccountSetRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public AccountSetRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public AccountSetRequest count() {
    return countId("count");
  }

  public static AccountSetRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public AccountSetRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public AccountSetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectId() {
    return select(ID_PROPERTY);
  }

  public AccountSetRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public AccountSetRequest countId() {
    return countId("countId");
  }

  public AccountSetRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public AccountSetRequest maxId() {
    return maxId("maxId");
  }

  public AccountSetRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public AccountSetRequest minId() {
    return minId("minId");
  }

  public AccountSetRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public AccountSetRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public AccountSetRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public AccountSetRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public AccountSetRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public AccountSetRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public AccountSetRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public AccountSetRequest countName() {
    return countName("countName");
  }

  public AccountSetRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public AccountSetRequest maxName() {
    return maxName("maxName");
  }

  public AccountSetRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public AccountSetRequest minName() {
    return minName("minName");
  }

  public AccountSetRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public AccountSetRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public AccountSetRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public AccountSetRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public AccountSetRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByYearSet(String yearSet) {

    if (yearSet == null) {
      return this;
    }

    return filterByYearSet(QueryOperator.EQUAL, yearSet);
  }

  public AccountSetRequest whereYearSetIsNull() {
    return where(YEAR_SET_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereYearSetIsNotNull() {
    return where(YEAR_SET_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByYearSet(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getYearSetSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectYearSet() {
    return select(YEAR_SET_PROPERTY);
  }

  public AccountSetRequest unselectYearSet() {
    return unselect(YEAR_SET_PROPERTY);
  }

  public SearchCriteria getYearSetSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(YEAR_SET_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByYearSet(boolean asc) {
    addOrderBy(YEAR_SET_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByYearSetAscending() {
    addOrderBy(YEAR_SET_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByYearSetDescending() {
    addOrderBy(YEAR_SET_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByYearSetAscendingUsingGBK() {
    addOrderBy("convert(yearSet using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByYearSetDescendingUsingGBK() {
    addOrderBy("convert(yearSet using gbk)", false);
    return this;
  }

  public AccountSetRequest countYearSet() {
    return countYearSet("countYearSet");
  }

  public AccountSetRequest countYearSet(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, YEAR_SET_PROPERTY);
  }

  public AccountSetRequest maxYearSet() {
    return maxYearSet("maxYearSet");
  }

  public AccountSetRequest maxYearSet(String aggName) {
    return aggregate(aggName, AggFunc.MAX, YEAR_SET_PROPERTY);
  }

  public AccountSetRequest minYearSet() {
    return minYearSet("minYearSet");
  }

  public AccountSetRequest minYearSet(String aggName) {
    return aggregate(aggName, AggFunc.MIN, YEAR_SET_PROPERTY);
  }

  public AccountSetRequest groupByYearSet() {
    return groupByYearSet(YEAR_SET_PROPERTY);
  }

  public AccountSetRequest groupByYearSet(String ret) {
    return groupBy(ret, YEAR_SET_PROPERTY);
  }

  public AccountSetRequest groupByYearSet(SqlFunction func) {
    return groupByYearSet(YEAR_SET_PROPERTY, func);
  }

  public AccountSetRequest groupByYearSet(String ret, SqlFunction func) {
    super.groupBy(ret, func, YEAR_SET_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByEffectiveDate(Date effectiveDate) {

    if (effectiveDate == null) {
      return this;
    }

    return filterByEffectiveDate(QueryOperator.EQUAL, effectiveDate);
  }

  public AccountSetRequest whereEffectiveDateIsNull() {
    return where(EFFECTIVE_DATE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereEffectiveDateIsNotNull() {
    return where(EFFECTIVE_DATE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest whereEffectiveDateBetween(
      Date effectiveDateStart, Date effectiveDateEnd) {
    if (ObjectUtil.isEmpty(effectiveDateStart)) {
      throw new IllegalArgumentException(
          "Method whereEffectiveDateBetween, the parameter effectiveDateStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(effectiveDateEnd)) {
      throw new IllegalArgumentException(
          "Method whereEffectiveDateBetween, the parameter effectiveDateEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEffectiveDateSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {effectiveDateStart, effectiveDateEnd});
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest whereEffectiveDateBefore(Date effectiveDate) {

    if (ObjectUtil.isEmpty(effectiveDate)) {
      throw new IllegalArgumentException(
          "Method whereEffectiveDateBefore, the parameter effectiveDate is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getEffectiveDateSearchCriteria(QueryOperator.LESS_THAN, new Object[] {effectiveDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest whereEffectiveDateAfter(Date effectiveDate) {
    if (ObjectUtil.isEmpty(effectiveDate)) {
      throw new IllegalArgumentException(
          "Method whereEffectiveDateAfter, the parameter effectiveDate is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEffectiveDateSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {effectiveDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest filterByEffectiveDate(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEffectiveDateSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectEffectiveDate() {
    return select(EFFECTIVE_DATE_PROPERTY);
  }

  public AccountSetRequest unselectEffectiveDate() {
    return unselect(EFFECTIVE_DATE_PROPERTY);
  }

  public SearchCriteria getEffectiveDateSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EFFECTIVE_DATE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByEffectiveDate(boolean asc) {
    addOrderBy(EFFECTIVE_DATE_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByEffectiveDateAscending() {
    addOrderBy(EFFECTIVE_DATE_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByEffectiveDateDescending() {
    addOrderBy(EFFECTIVE_DATE_PROPERTY, false);
    return this;
  }

  public AccountSetRequest countEffectiveDate() {
    return countEffectiveDate("countEffectiveDate");
  }

  public AccountSetRequest countEffectiveDate(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EFFECTIVE_DATE_PROPERTY);
  }

  public AccountSetRequest maxEffectiveDate() {
    return maxEffectiveDate("maxEffectiveDate");
  }

  public AccountSetRequest maxEffectiveDate(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EFFECTIVE_DATE_PROPERTY);
  }

  public AccountSetRequest minEffectiveDate() {
    return minEffectiveDate("minEffectiveDate");
  }

  public AccountSetRequest minEffectiveDate(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EFFECTIVE_DATE_PROPERTY);
  }

  public AccountSetRequest groupByEffectiveDate() {
    return groupByEffectiveDate(EFFECTIVE_DATE_PROPERTY);
  }

  public AccountSetRequest groupByEffectiveDate(String ret) {
    return groupBy(ret, EFFECTIVE_DATE_PROPERTY);
  }

  public AccountSetRequest groupByEffectiveDate(SqlFunction func) {
    return groupByEffectiveDate(EFFECTIVE_DATE_PROPERTY, func);
  }

  public AccountSetRequest groupByEffectiveDate(String ret, SqlFunction func) {
    super.groupBy(ret, func, EFFECTIVE_DATE_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByAccountingSystem(String accountingSystem) {

    if (accountingSystem == null) {
      return this;
    }

    return filterByAccountingSystem(QueryOperator.EQUAL, accountingSystem);
  }

  public AccountSetRequest whereAccountingSystemIsNull() {
    return where(ACCOUNTING_SYSTEM_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereAccountingSystemIsNotNull() {
    return where(ACCOUNTING_SYSTEM_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByAccountingSystem(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAccountingSystemSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectAccountingSystem() {
    return select(ACCOUNTING_SYSTEM_PROPERTY);
  }

  public AccountSetRequest unselectAccountingSystem() {
    return unselect(ACCOUNTING_SYSTEM_PROPERTY);
  }

  public SearchCriteria getAccountingSystemSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ACCOUNTING_SYSTEM_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByAccountingSystem(boolean asc) {
    addOrderBy(ACCOUNTING_SYSTEM_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByAccountingSystemAscending() {
    addOrderBy(ACCOUNTING_SYSTEM_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByAccountingSystemDescending() {
    addOrderBy(ACCOUNTING_SYSTEM_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByAccountingSystemAscendingUsingGBK() {
    addOrderBy("convert(accountingSystem using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByAccountingSystemDescendingUsingGBK() {
    addOrderBy("convert(accountingSystem using gbk)", false);
    return this;
  }

  public AccountSetRequest countAccountingSystem() {
    return countAccountingSystem("countAccountingSystem");
  }

  public AccountSetRequest countAccountingSystem(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_SYSTEM_PROPERTY);
  }

  public AccountSetRequest maxAccountingSystem() {
    return maxAccountingSystem("maxAccountingSystem");
  }

  public AccountSetRequest maxAccountingSystem(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCOUNTING_SYSTEM_PROPERTY);
  }

  public AccountSetRequest minAccountingSystem() {
    return minAccountingSystem("minAccountingSystem");
  }

  public AccountSetRequest minAccountingSystem(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCOUNTING_SYSTEM_PROPERTY);
  }

  public AccountSetRequest groupByAccountingSystem() {
    return groupByAccountingSystem(ACCOUNTING_SYSTEM_PROPERTY);
  }

  public AccountSetRequest groupByAccountingSystem(String ret) {
    return groupBy(ret, ACCOUNTING_SYSTEM_PROPERTY);
  }

  public AccountSetRequest groupByAccountingSystem(SqlFunction func) {
    return groupByAccountingSystem(ACCOUNTING_SYSTEM_PROPERTY, func);
  }

  public AccountSetRequest groupByAccountingSystem(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCOUNTING_SYSTEM_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByDomesticCurrencyCode(String domesticCurrencyCode) {

    if (domesticCurrencyCode == null) {
      return this;
    }

    return filterByDomesticCurrencyCode(QueryOperator.EQUAL, domesticCurrencyCode);
  }

  public AccountSetRequest whereDomesticCurrencyCodeIsNull() {
    return where(DOMESTIC_CURRENCY_CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereDomesticCurrencyCodeIsNotNull() {
    return where(DOMESTIC_CURRENCY_CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByDomesticCurrencyCode(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getDomesticCurrencyCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectDomesticCurrencyCode() {
    return select(DOMESTIC_CURRENCY_CODE_PROPERTY);
  }

  public AccountSetRequest unselectDomesticCurrencyCode() {
    return unselect(DOMESTIC_CURRENCY_CODE_PROPERTY);
  }

  public SearchCriteria getDomesticCurrencyCodeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DOMESTIC_CURRENCY_CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByDomesticCurrencyCode(boolean asc) {
    addOrderBy(DOMESTIC_CURRENCY_CODE_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyCodeAscending() {
    addOrderBy(DOMESTIC_CURRENCY_CODE_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyCodeDescending() {
    addOrderBy(DOMESTIC_CURRENCY_CODE_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyCodeAscendingUsingGBK() {
    addOrderBy("convert(domesticCurrencyCode using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyCodeDescendingUsingGBK() {
    addOrderBy("convert(domesticCurrencyCode using gbk)", false);
    return this;
  }

  public AccountSetRequest countDomesticCurrencyCode() {
    return countDomesticCurrencyCode("countDomesticCurrencyCode");
  }

  public AccountSetRequest countDomesticCurrencyCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DOMESTIC_CURRENCY_CODE_PROPERTY);
  }

  public AccountSetRequest maxDomesticCurrencyCode() {
    return maxDomesticCurrencyCode("maxDomesticCurrencyCode");
  }

  public AccountSetRequest maxDomesticCurrencyCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DOMESTIC_CURRENCY_CODE_PROPERTY);
  }

  public AccountSetRequest minDomesticCurrencyCode() {
    return minDomesticCurrencyCode("minDomesticCurrencyCode");
  }

  public AccountSetRequest minDomesticCurrencyCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DOMESTIC_CURRENCY_CODE_PROPERTY);
  }

  public AccountSetRequest groupByDomesticCurrencyCode() {
    return groupByDomesticCurrencyCode(DOMESTIC_CURRENCY_CODE_PROPERTY);
  }

  public AccountSetRequest groupByDomesticCurrencyCode(String ret) {
    return groupBy(ret, DOMESTIC_CURRENCY_CODE_PROPERTY);
  }

  public AccountSetRequest groupByDomesticCurrencyCode(SqlFunction func) {
    return groupByDomesticCurrencyCode(DOMESTIC_CURRENCY_CODE_PROPERTY, func);
  }

  public AccountSetRequest groupByDomesticCurrencyCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, DOMESTIC_CURRENCY_CODE_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByDomesticCurrencyName(String domesticCurrencyName) {

    if (domesticCurrencyName == null) {
      return this;
    }

    return filterByDomesticCurrencyName(QueryOperator.EQUAL, domesticCurrencyName);
  }

  public AccountSetRequest whereDomesticCurrencyNameIsNull() {
    return where(DOMESTIC_CURRENCY_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereDomesticCurrencyNameIsNotNull() {
    return where(DOMESTIC_CURRENCY_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByDomesticCurrencyName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getDomesticCurrencyNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectDomesticCurrencyName() {
    return select(DOMESTIC_CURRENCY_NAME_PROPERTY);
  }

  public AccountSetRequest unselectDomesticCurrencyName() {
    return unselect(DOMESTIC_CURRENCY_NAME_PROPERTY);
  }

  public SearchCriteria getDomesticCurrencyNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DOMESTIC_CURRENCY_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByDomesticCurrencyName(boolean asc) {
    addOrderBy(DOMESTIC_CURRENCY_NAME_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyNameAscending() {
    addOrderBy(DOMESTIC_CURRENCY_NAME_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyNameDescending() {
    addOrderBy(DOMESTIC_CURRENCY_NAME_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyNameAscendingUsingGBK() {
    addOrderBy("convert(domesticCurrencyName using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByDomesticCurrencyNameDescendingUsingGBK() {
    addOrderBy("convert(domesticCurrencyName using gbk)", false);
    return this;
  }

  public AccountSetRequest countDomesticCurrencyName() {
    return countDomesticCurrencyName("countDomesticCurrencyName");
  }

  public AccountSetRequest countDomesticCurrencyName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DOMESTIC_CURRENCY_NAME_PROPERTY);
  }

  public AccountSetRequest maxDomesticCurrencyName() {
    return maxDomesticCurrencyName("maxDomesticCurrencyName");
  }

  public AccountSetRequest maxDomesticCurrencyName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DOMESTIC_CURRENCY_NAME_PROPERTY);
  }

  public AccountSetRequest minDomesticCurrencyName() {
    return minDomesticCurrencyName("minDomesticCurrencyName");
  }

  public AccountSetRequest minDomesticCurrencyName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DOMESTIC_CURRENCY_NAME_PROPERTY);
  }

  public AccountSetRequest groupByDomesticCurrencyName() {
    return groupByDomesticCurrencyName(DOMESTIC_CURRENCY_NAME_PROPERTY);
  }

  public AccountSetRequest groupByDomesticCurrencyName(String ret) {
    return groupBy(ret, DOMESTIC_CURRENCY_NAME_PROPERTY);
  }

  public AccountSetRequest groupByDomesticCurrencyName(SqlFunction func) {
    return groupByDomesticCurrencyName(DOMESTIC_CURRENCY_NAME_PROPERTY, func);
  }

  public AccountSetRequest groupByDomesticCurrencyName(String ret, SqlFunction func) {
    super.groupBy(ret, func, DOMESTIC_CURRENCY_NAME_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByOpeningBank(String openingBank) {

    if (openingBank == null) {
      return this;
    }

    return filterByOpeningBank(QueryOperator.EQUAL, openingBank);
  }

  public AccountSetRequest whereOpeningBankIsNull() {
    return where(OPENING_BANK_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereOpeningBankIsNotNull() {
    return where(OPENING_BANK_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByOpeningBank(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getOpeningBankSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectOpeningBank() {
    return select(OPENING_BANK_PROPERTY);
  }

  public AccountSetRequest unselectOpeningBank() {
    return unselect(OPENING_BANK_PROPERTY);
  }

  public SearchCriteria getOpeningBankSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(OPENING_BANK_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByOpeningBank(boolean asc) {
    addOrderBy(OPENING_BANK_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByOpeningBankAscending() {
    addOrderBy(OPENING_BANK_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByOpeningBankDescending() {
    addOrderBy(OPENING_BANK_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByOpeningBankAscendingUsingGBK() {
    addOrderBy("convert(openingBank using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByOpeningBankDescendingUsingGBK() {
    addOrderBy("convert(openingBank using gbk)", false);
    return this;
  }

  public AccountSetRequest countOpeningBank() {
    return countOpeningBank("countOpeningBank");
  }

  public AccountSetRequest countOpeningBank(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OPENING_BANK_PROPERTY);
  }

  public AccountSetRequest maxOpeningBank() {
    return maxOpeningBank("maxOpeningBank");
  }

  public AccountSetRequest maxOpeningBank(String aggName) {
    return aggregate(aggName, AggFunc.MAX, OPENING_BANK_PROPERTY);
  }

  public AccountSetRequest minOpeningBank() {
    return minOpeningBank("minOpeningBank");
  }

  public AccountSetRequest minOpeningBank(String aggName) {
    return aggregate(aggName, AggFunc.MIN, OPENING_BANK_PROPERTY);
  }

  public AccountSetRequest groupByOpeningBank() {
    return groupByOpeningBank(OPENING_BANK_PROPERTY);
  }

  public AccountSetRequest groupByOpeningBank(String ret) {
    return groupBy(ret, OPENING_BANK_PROPERTY);
  }

  public AccountSetRequest groupByOpeningBank(SqlFunction func) {
    return groupByOpeningBank(OPENING_BANK_PROPERTY, func);
  }

  public AccountSetRequest groupByOpeningBank(String ret, SqlFunction func) {
    super.groupBy(ret, func, OPENING_BANK_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByAccountNumber(String accountNumber) {

    if (accountNumber == null) {
      return this;
    }

    return filterByAccountNumber(QueryOperator.EQUAL, accountNumber);
  }

  public AccountSetRequest whereAccountNumberIsNull() {
    return where(ACCOUNT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereAccountNumberIsNotNull() {
    return where(ACCOUNT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByAccountNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAccountNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectAccountNumber() {
    return select(ACCOUNT_NUMBER_PROPERTY);
  }

  public AccountSetRequest unselectAccountNumber() {
    return unselect(ACCOUNT_NUMBER_PROPERTY);
  }

  public SearchCriteria getAccountNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ACCOUNT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByAccountNumber(boolean asc) {
    addOrderBy(ACCOUNT_NUMBER_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByAccountNumberAscending() {
    addOrderBy(ACCOUNT_NUMBER_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByAccountNumberDescending() {
    addOrderBy(ACCOUNT_NUMBER_PROPERTY, false);
    return this;
  }

  public AccountSetRequest orderByAccountNumberAscendingUsingGBK() {
    addOrderBy("convert(accountNumber using gbk)", true);
    return this;
  }

  public AccountSetRequest orderByAccountNumberDescendingUsingGBK() {
    addOrderBy("convert(accountNumber using gbk)", false);
    return this;
  }

  public AccountSetRequest countAccountNumber() {
    return countAccountNumber("countAccountNumber");
  }

  public AccountSetRequest countAccountNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNT_NUMBER_PROPERTY);
  }

  public AccountSetRequest maxAccountNumber() {
    return maxAccountNumber("maxAccountNumber");
  }

  public AccountSetRequest maxAccountNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCOUNT_NUMBER_PROPERTY);
  }

  public AccountSetRequest minAccountNumber() {
    return minAccountNumber("minAccountNumber");
  }

  public AccountSetRequest minAccountNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCOUNT_NUMBER_PROPERTY);
  }

  public AccountSetRequest groupByAccountNumber() {
    return groupByAccountNumber(ACCOUNT_NUMBER_PROPERTY);
  }

  public AccountSetRequest groupByAccountNumber(String ret) {
    return groupBy(ret, ACCOUNT_NUMBER_PROPERTY);
  }

  public AccountSetRequest groupByAccountNumber(SqlFunction func) {
    return groupByAccountNumber(ACCOUNT_NUMBER_PROPERTY, func);
  }

  public AccountSetRequest groupByAccountNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCOUNT_NUMBER_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public AccountSetRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest whereLastUpdateTimeBetween(
      Date lastUpdateTimeStart, Date lastUpdateTimeEnd) {
    if (ObjectUtil.isEmpty(lastUpdateTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastUpdateTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastUpdateTimeStart, lastUpdateTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public AccountSetRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public AccountSetRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public AccountSetRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public AccountSetRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public AccountSetRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public AccountSetRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public AccountSetRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public AccountSetRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public AccountSetRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public AccountSetRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public AccountSetRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public AccountSetRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountSetRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public AccountSetRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountSetRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public AccountSetRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public AccountSetRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public AccountSetRequest countVersion() {
    return countVersion("countVersion");
  }

  public AccountSetRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public AccountSetRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public AccountSetRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public AccountSetRequest minVersion() {
    return minVersion("minVersion");
  }

  public AccountSetRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public AccountSetRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public AccountSetRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public AccountSetRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public AccountSetRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public AccountSetRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public AccountSetRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public AccountSetRequest filterByCountryCenter(RetailStoreCountryCenterRequest countryCenter) {
    return filterByCountryCenter(countryCenter, RetailStoreCountryCenter::getId);
  }

  public AccountSetRequest filterByCountryCenter(RetailStoreCountryCenter... countryCenter) {
    if (isEmptyParam(countryCenter)) {
      throw new IllegalArgumentException(
          "filterByCountryCenter(RetailStoreCountryCenter... countryCenter)参数不能为空!");
    }
    return where(COUNTRY_CENTER_PROPERTY, QueryOperator.IN, (Object[]) countryCenter);
  }

  public AccountSetRequest selectCountryCenterId() {
    select(COUNTRY_CENTER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToCountryCenter() {
    return upToCountryCenter(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToCountryCenter(
      RetailStoreCountryCenterRequest countryCenter) {
    countryCenter.aggregateChild(COUNTRY_CENTER_PROPERTY, this);
    this.groupByCountryCenter(countryCenter);
    return countryCenter;
  }

  public RetailStoreCountryCenterRequest endAtCountryCenter(String retName) {
    return endAtCountryCenter(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtCountryCenter(
      String retName, RetailStoreCountryCenterRequest countryCenter) {
    countryCenter.addDynamicProperty(retName, this, COUNTRY_CENTER_PROPERTY);
    return countryCenter;
  }

  public AccountSetRequest filterByCountryCenter(String... countryCenter) {
    if (isEmptyParam(countryCenter)) {
      throw new IllegalArgumentException("filterByCountryCenter(String... countryCenter)参数不能为空!");
    }
    return where(COUNTRY_CENTER_PROPERTY, QueryOperator.IN, (Object[]) countryCenter);
  }

  public AccountSetRequest filterByCountryCenter(
      RetailStoreCountryCenterRequest countryCenter, IDRefine<RetailStoreCountryCenter> idRefine) {
    countryCenter.unlimited();
    return addSearchCriteria(createCountryCenterCriteria(countryCenter, idRefine));
  }

  public SearchCriteria createCountryCenterCriteria(
      RetailStoreCountryCenterRequest countryCenter, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        countryCenter, COUNTRY_CENTER_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public AccountSetRequest selectCountryCenter() {
    return selectCountryCenter(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public AccountSetRequest selectCountryCenter(RetailStoreCountryCenterRequest countryCenter) {
    selectParent(COUNTRY_CENTER_PROPERTY, countryCenter);
    return this;
  }

  public AccountSetRequest unselectCountryCenter() {
    unselectParent(COUNTRY_CENTER_PROPERTY);
    return this;
  }

  public AccountSetRequest groupByCountryCenter(RetailStoreCountryCenterRequest countryCenter) {
    groupBy(COUNTRY_CENTER_PROPERTY, countryCenter);
    return this;
  }

  public AccountSetRequest aggregateCountryCenter(RetailStoreCountryCenterRequest countryCenter) {
    aggregateParent(COUNTRY_CENTER_PROPERTY, countryCenter);
    return this;
  }

  public AccountSetRequest countCountryCenter() {
    return countCountryCenter("countCountryCenter");
  }

  public AccountSetRequest countCountryCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COUNTRY_CENTER_PROPERTY);
  }

  public AccountSetRequest groupByCountryCenter() {
    return groupByCountryCenter(COUNTRY_CENTER_PROPERTY);
  }

  public AccountSetRequest groupByCountryCenter(String ret) {
    return groupBy(ret, COUNTRY_CENTER_PROPERTY);
  }

  public AccountSetRequest whereCountryCenterIsNull() {
    return where(COUNTRY_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereCountryCenterIsNotNull() {
    return where(COUNTRY_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByRetailStore(RetailStoreRequest retailStore) {
    return filterByRetailStore(retailStore, RetailStore::getId);
  }

  public AccountSetRequest filterByRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("filterByRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IN, (Object[]) retailStore);
  }

  public AccountSetRequest selectRetailStoreId() {
    select(RETAIL_STORE_PROPERTY);
    return this;
  }

  public RetailStoreRequest upToRetailStore() {
    return upToRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest upToRetailStore(RetailStoreRequest retailStore) {
    retailStore.aggregateChild(RETAIL_STORE_PROPERTY, this);
    this.groupByRetailStore(retailStore);
    return retailStore;
  }

  public RetailStoreRequest endAtRetailStore(String retName) {
    return endAtRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest endAtRetailStore(String retName, RetailStoreRequest retailStore) {
    retailStore.addDynamicProperty(retName, this, RETAIL_STORE_PROPERTY);
    return retailStore;
  }

  public AccountSetRequest filterByRetailStore(String... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("filterByRetailStore(String... retailStore)参数不能为空!");
    }
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IN, (Object[]) retailStore);
  }

  public AccountSetRequest filterByRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, RETAIL_STORE_PROPERTY, idRefine, RetailStore.ID_PROPERTY);
  }

  public AccountSetRequest selectRetailStore() {
    return selectRetailStore(RetailStoreRequest.newInstance().selectSelf());
  }

  public AccountSetRequest selectRetailStore(RetailStoreRequest retailStore) {
    selectParent(RETAIL_STORE_PROPERTY, retailStore);
    return this;
  }

  public AccountSetRequest unselectRetailStore() {
    unselectParent(RETAIL_STORE_PROPERTY);
    return this;
  }

  public AccountSetRequest groupByRetailStore(RetailStoreRequest retailStore) {
    groupBy(RETAIL_STORE_PROPERTY, retailStore);
    return this;
  }

  public AccountSetRequest aggregateRetailStore(RetailStoreRequest retailStore) {
    aggregateParent(RETAIL_STORE_PROPERTY, retailStore);
    return this;
  }

  public AccountSetRequest countRetailStore() {
    return countRetailStore("countRetailStore");
  }

  public AccountSetRequest countRetailStore(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, RETAIL_STORE_PROPERTY);
  }

  public AccountSetRequest groupByRetailStore() {
    return groupByRetailStore(RETAIL_STORE_PROPERTY);
  }

  public AccountSetRequest groupByRetailStore(String ret) {
    return groupBy(ret, RETAIL_STORE_PROPERTY);
  }

  public AccountSetRequest whereRetailStoreIsNull() {
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereRetailStoreIsNotNull() {
    return where(RETAIL_STORE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest filterByGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
    return filterByGoodsSupplier(goodsSupplier, GoodsSupplier::getId);
  }

  public AccountSetRequest filterByGoodsSupplier(GoodsSupplier... goodsSupplier) {
    if (isEmptyParam(goodsSupplier)) {
      throw new IllegalArgumentException(
          "filterByGoodsSupplier(GoodsSupplier... goodsSupplier)参数不能为空!");
    }
    return where(GOODS_SUPPLIER_PROPERTY, QueryOperator.IN, (Object[]) goodsSupplier);
  }

  public AccountSetRequest selectGoodsSupplierId() {
    select(GOODS_SUPPLIER_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest upToGoodsSupplier() {
    return upToGoodsSupplier(GoodsSupplierRequest.newInstance());
  }

  public GoodsSupplierRequest upToGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
    goodsSupplier.aggregateChild(GOODS_SUPPLIER_PROPERTY, this);
    this.groupByGoodsSupplier(goodsSupplier);
    return goodsSupplier;
  }

  public GoodsSupplierRequest endAtGoodsSupplier(String retName) {
    return endAtGoodsSupplier(retName, GoodsSupplierRequest.newInstance());
  }

  public GoodsSupplierRequest endAtGoodsSupplier(
      String retName, GoodsSupplierRequest goodsSupplier) {
    goodsSupplier.addDynamicProperty(retName, this, GOODS_SUPPLIER_PROPERTY);
    return goodsSupplier;
  }

  public AccountSetRequest filterByGoodsSupplier(String... goodsSupplier) {
    if (isEmptyParam(goodsSupplier)) {
      throw new IllegalArgumentException("filterByGoodsSupplier(String... goodsSupplier)参数不能为空!");
    }
    return where(GOODS_SUPPLIER_PROPERTY, QueryOperator.IN, (Object[]) goodsSupplier);
  }

  public AccountSetRequest filterByGoodsSupplier(
      GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine) {
    goodsSupplier.unlimited();
    return addSearchCriteria(createGoodsSupplierCriteria(goodsSupplier, idRefine));
  }

  public SearchCriteria createGoodsSupplierCriteria(
      GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine) {
    return new RefinedIdInCriteria(
        goodsSupplier, GOODS_SUPPLIER_PROPERTY, idRefine, GoodsSupplier.ID_PROPERTY);
  }

  public AccountSetRequest selectGoodsSupplier() {
    return selectGoodsSupplier(GoodsSupplierRequest.newInstance().selectSelf());
  }

  public AccountSetRequest selectGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
    selectParent(GOODS_SUPPLIER_PROPERTY, goodsSupplier);
    return this;
  }

  public AccountSetRequest unselectGoodsSupplier() {
    unselectParent(GOODS_SUPPLIER_PROPERTY);
    return this;
  }

  public AccountSetRequest groupByGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
    groupBy(GOODS_SUPPLIER_PROPERTY, goodsSupplier);
    return this;
  }

  public AccountSetRequest aggregateGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
    aggregateParent(GOODS_SUPPLIER_PROPERTY, goodsSupplier);
    return this;
  }

  public AccountSetRequest countGoodsSupplier() {
    return countGoodsSupplier("countGoodsSupplier");
  }

  public AccountSetRequest countGoodsSupplier(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, GOODS_SUPPLIER_PROPERTY);
  }

  public AccountSetRequest groupByGoodsSupplier() {
    return groupByGoodsSupplier(GOODS_SUPPLIER_PROPERTY);
  }

  public AccountSetRequest groupByGoodsSupplier(String ret) {
    return groupBy(ret, GOODS_SUPPLIER_PROPERTY);
  }

  public AccountSetRequest whereGoodsSupplierIsNull() {
    return where(GOODS_SUPPLIER_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountSetRequest whereGoodsSupplierIsNotNull() {
    return where(GOODS_SUPPLIER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountSetRequest hasAccountingSubject() {
    return hasAccountingSubject(AccountingSubjectRequest.newInstance());
  }

  public AccountSetRequest hasAccountingSubject(AccountingSubject... accountingSubject) {
    if (isEmptyParam(accountingSubject)) {
      throw new IllegalArgumentException(
          "hasAccountingSubject(AccountingSubject... accountingSubject)参数不能为空!");
    }
    return hasAccountingSubject(
        Q.accountingSubject()
            .select(AccountingSubject.ACCOUNT_SET_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountingSubject));
  }

  public AccountSetRequest hasAccountingSubject(String... accountingSubject) {
    return hasAccountingSubject(
        Q.accountingSubject()
            .select(AccountingSubject.ACCOUNT_SET_PROPERTY)
            .filterById(accountingSubject));
  }

  public AccountSetRequest hasAccountingSubject(AccountingSubjectRequest accountingSubject) {
    return hasAccountingSubject(
        accountingSubject,
        $accountingSubject ->
            java.util.Optional.of($accountingSubject)
                .map(AccountingSubject::getAccountSet)
                .map(AccountSet::getId)
                .orElse(null));
  }

  public AccountSetRequest hasAccountingSubject(
      AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine) {
    accountingSubject.select(AccountingSubject.ACCOUNT_SET_PROPERTY);
    accountingSubject.unlimited();
    return addSearchCriteria(createAccountingSubjectCriteria(accountingSubject, idRefine));
  }

  public AccountSetRequest hasAccountingSubject(
      AccountingSubjectRequest accountingSubject, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountingSubject, AccountingSubject.ACCOUNT_SET_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createAccountingSubjectCriteria(
      AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine) {
    return new RefinedIdInCriteria(
        accountingSubject, ID_PROPERTY, idRefine, AccountingSubject.ACCOUNT_SET_PROPERTY);
  }

  public AccountSetRequest selectAccountingSubjectList(AccountingSubjectRequest accountingSubject) {
    selectChild(AccountingSubject.ACCOUNT_SET_PROPERTY, accountingSubject);
    return this;
  }

  public AccountSetRequest selectAccountingSubjectList() {
    return selectAccountingSubjectList(AccountingSubjectRequest.newInstance().selectAll());
  }

  public AccountSetRequest unselectAccountingSubjectList() {
    unselectChild(AccountingSubject.ACCOUNT_SET_PROPERTY, AccountingSubject.class);
    return this;
  }

  public AccountSetRequest hasAccountingPeriod() {
    return hasAccountingPeriod(AccountingPeriodRequest.newInstance());
  }

  public AccountSetRequest hasAccountingPeriod(AccountingPeriod... accountingPeriod) {
    if (isEmptyParam(accountingPeriod)) {
      throw new IllegalArgumentException(
          "hasAccountingPeriod(AccountingPeriod... accountingPeriod)参数不能为空!");
    }
    return hasAccountingPeriod(
        Q.accountingPeriod()
            .select(AccountingPeriod.ACCOUNT_SET_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountingPeriod));
  }

  public AccountSetRequest hasAccountingPeriod(String... accountingPeriod) {
    return hasAccountingPeriod(
        Q.accountingPeriod()
            .select(AccountingPeriod.ACCOUNT_SET_PROPERTY)
            .filterById(accountingPeriod));
  }

  public AccountSetRequest hasAccountingPeriod(AccountingPeriodRequest accountingPeriod) {
    return hasAccountingPeriod(
        accountingPeriod,
        $accountingPeriod ->
            java.util.Optional.of($accountingPeriod)
                .map(AccountingPeriod::getAccountSet)
                .map(AccountSet::getId)
                .orElse(null));
  }

  public AccountSetRequest hasAccountingPeriod(
      AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine) {
    accountingPeriod.select(AccountingPeriod.ACCOUNT_SET_PROPERTY);
    accountingPeriod.unlimited();
    return addSearchCriteria(createAccountingPeriodCriteria(accountingPeriod, idRefine));
  }

  public AccountSetRequest hasAccountingPeriod(
      AccountingPeriodRequest accountingPeriod, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountingPeriod, AccountingPeriod.ACCOUNT_SET_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createAccountingPeriodCriteria(
      AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine) {
    return new RefinedIdInCriteria(
        accountingPeriod, ID_PROPERTY, idRefine, AccountingPeriod.ACCOUNT_SET_PROPERTY);
  }

  public AccountSetRequest selectAccountingPeriodList(AccountingPeriodRequest accountingPeriod) {
    selectChild(AccountingPeriod.ACCOUNT_SET_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountSetRequest selectAccountingPeriodList() {
    return selectAccountingPeriodList(AccountingPeriodRequest.newInstance().selectAll());
  }

  public AccountSetRequest unselectAccountingPeriodList() {
    unselectChild(AccountingPeriod.ACCOUNT_SET_PROPERTY, AccountingPeriod.class);
    return this;
  }

  public AccountSetRequest hasAccountingDocumentType() {
    return hasAccountingDocumentType(AccountingDocumentTypeRequest.newInstance());
  }

  public AccountSetRequest hasAccountingDocumentType(
      AccountingDocumentType... accountingDocumentType) {
    if (isEmptyParam(accountingDocumentType)) {
      throw new IllegalArgumentException(
          "hasAccountingDocumentType(AccountingDocumentType... accountingDocumentType)参数不能为空!");
    }
    return hasAccountingDocumentType(
        Q.accountingDocumentType()
            .select(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountingDocumentType));
  }

  public AccountSetRequest hasAccountingDocumentType(String... accountingDocumentType) {
    return hasAccountingDocumentType(
        Q.accountingDocumentType()
            .select(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY)
            .filterById(accountingDocumentType));
  }

  public AccountSetRequest hasAccountingDocumentType(
      AccountingDocumentTypeRequest accountingDocumentType) {
    return hasAccountingDocumentType(
        accountingDocumentType,
        $accountingDocumentType ->
            java.util.Optional.of($accountingDocumentType)
                .map(AccountingDocumentType::getAccountingPeriod)
                .map(AccountSet::getId)
                .orElse(null));
  }

  public AccountSetRequest hasAccountingDocumentType(
      AccountingDocumentTypeRequest accountingDocumentType,
      IDRefine<AccountingDocumentType> idRefine) {
    accountingDocumentType.select(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY);
    accountingDocumentType.unlimited();
    return addSearchCriteria(
        createAccountingDocumentTypeCriteria(accountingDocumentType, idRefine));
  }

  public AccountSetRequest hasAccountingDocumentType(
      AccountingDocumentTypeRequest accountingDocumentType,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountingDocumentType,
            AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createAccountingDocumentTypeCriteria(
      AccountingDocumentTypeRequest accountingDocumentType,
      IDRefine<AccountingDocumentType> idRefine) {
    return new RefinedIdInCriteria(
        accountingDocumentType,
        ID_PROPERTY,
        idRefine,
        AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountSetRequest selectAccountingDocumentTypeList(
      AccountingDocumentTypeRequest accountingDocumentType) {
    selectChild(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, accountingDocumentType);
    return this;
  }

  public AccountSetRequest selectAccountingDocumentTypeList() {
    return selectAccountingDocumentTypeList(
        AccountingDocumentTypeRequest.newInstance().selectAll());
  }

  public AccountSetRequest unselectAccountingDocumentTypeList() {
    unselectChild(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, AccountingDocumentType.class);
    return this;
  }

  public AccountSetRequest aggregateAccountingSubjectList(
      AccountingSubjectRequest accountingSubject) {
    aggregateChild(AccountingSubject.ACCOUNT_SET_PROPERTY, accountingSubject);
    return this;
  }

  public AccountSetRequest countAccountingSubject() {
    return countAccountingSubject("accountingSubjectCount");
  }

  public AccountSetRequest countAccountingSubject(String retName) {
    return countAccountingSubject(retName, AccountingSubjectRequest.newInstance());
  }

  public AccountSetRequest countAccountingSubject(AccountingSubjectRequest accountingSubject) {
    return countAccountingSubject("accountingSubjectCount", accountingSubject);
  }

  public AccountSetRequest countAccountingSubject(
      String retName, AccountingSubjectRequest accountingSubject) {
    accountingSubject.count();
    return statsFromAccountingSubject(retName, accountingSubject);
  }

  public AccountSetRequest statsFromAccountingSubject(
      String retName, AccountingSubjectRequest accountingSubject) {
    return addDynamicProperty(retName, accountingSubject, AccountingSubject.ACCOUNT_SET_PROPERTY);
  }

  public AccountSetRequest aggregateAccountingPeriodList(AccountingPeriodRequest accountingPeriod) {
    aggregateChild(AccountingPeriod.ACCOUNT_SET_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountSetRequest countAccountingPeriod() {
    return countAccountingPeriod("accountingPeriodCount");
  }

  public AccountSetRequest countAccountingPeriod(String retName) {
    return countAccountingPeriod(retName, AccountingPeriodRequest.newInstance());
  }

  public AccountSetRequest countAccountingPeriod(AccountingPeriodRequest accountingPeriod) {
    return countAccountingPeriod("accountingPeriodCount", accountingPeriod);
  }

  public AccountSetRequest countAccountingPeriod(
      String retName, AccountingPeriodRequest accountingPeriod) {
    accountingPeriod.count();
    return statsFromAccountingPeriod(retName, accountingPeriod);
  }

  public AccountSetRequest statsFromAccountingPeriod(
      String retName, AccountingPeriodRequest accountingPeriod) {
    return addDynamicProperty(retName, accountingPeriod, AccountingPeriod.ACCOUNT_SET_PROPERTY);
  }

  public AccountSetRequest aggregateAccountingDocumentTypeList(
      AccountingDocumentTypeRequest accountingDocumentType) {
    aggregateChild(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, accountingDocumentType);
    return this;
  }

  public AccountSetRequest countAccountingDocumentType() {
    return countAccountingDocumentType("accountingDocumentTypeCount");
  }

  public AccountSetRequest countAccountingDocumentType(String retName) {
    return countAccountingDocumentType(retName, AccountingDocumentTypeRequest.newInstance());
  }

  public AccountSetRequest countAccountingDocumentType(
      AccountingDocumentTypeRequest accountingDocumentType) {
    return countAccountingDocumentType("accountingDocumentTypeCount", accountingDocumentType);
  }

  public AccountSetRequest countAccountingDocumentType(
      String retName, AccountingDocumentTypeRequest accountingDocumentType) {
    accountingDocumentType.count();
    return statsFromAccountingDocumentType(retName, accountingDocumentType);
  }

  public AccountSetRequest statsFromAccountingDocumentType(
      String retName, AccountingDocumentTypeRequest accountingDocumentType) {
    return addDynamicProperty(
        retName, accountingDocumentType, AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountSetRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public AccountSetRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public AccountSetRequest unlimited() {
    super.unlimited();
    return this;
  }

  public AccountSetRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
