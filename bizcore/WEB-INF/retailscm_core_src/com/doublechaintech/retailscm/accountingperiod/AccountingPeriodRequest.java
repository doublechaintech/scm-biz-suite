package com.doublechaintech.retailscm.accountingperiod;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingperiod.AccountingPeriod.*;

public class AccountingPeriodRequest extends BaseRequest<AccountingPeriod> {
  public static AccountingPeriodRequest newInstance() {
    return new AccountingPeriodRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public AccountingPeriodRequest resultByClass(Class<? extends AccountingPeriod> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public AccountingPeriodRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public AccountingPeriodRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "AccountingPeriod";
  }

  public AccountingPeriodRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public AccountingPeriodRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public AccountingPeriodRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public AccountingPeriodRequest select(String... names) {
    super.select(names);
    return this;
  }

  public AccountingPeriodRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectStartDate()
        .selectEndDate()
        .selectAccountSet()
        .selectVersion();
  }

  public AccountingPeriodRequest selectAny() {
    return selectAll().selectAccountingDocumentList(Q.accountingDocument().selectSelf());
  }

  public AccountingPeriodRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(START_DATE_PROPERTY);
    select(END_DATE_PROPERTY);
    select(ACCOUNT_SET_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public AccountingPeriodRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public AccountingPeriodRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {START_DATE_PROPERTY, END_DATE_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    START_DATE_PROPERTY,
    END_DATE_PROPERTY,
    ACCOUNT_SET_PROPERTY,
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

  public AccountingPeriodRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public AccountingPeriodRequest comment(String comment) {
    return this;
  }

  public AccountingPeriodRequest enhance() {
    return this;
  }

  public AccountingPeriodRequest overrideClass(Class<? extends AccountingPeriod> clazz) {
    return this;
  }

  public AccountingPeriodRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public AccountingPeriodRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public AccountingPeriodRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public AccountingPeriodRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public AccountingPeriodRequest count() {
    return countId("count");
  }

  public static AccountingPeriodRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public AccountingPeriodRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public AccountingPeriodRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest selectId() {
    return select(ID_PROPERTY);
  }

  public AccountingPeriodRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingPeriodRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public AccountingPeriodRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public AccountingPeriodRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public AccountingPeriodRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public AccountingPeriodRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public AccountingPeriodRequest countId() {
    return countId("countId");
  }

  public AccountingPeriodRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public AccountingPeriodRequest maxId() {
    return maxId("maxId");
  }

  public AccountingPeriodRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public AccountingPeriodRequest minId() {
    return minId("minId");
  }

  public AccountingPeriodRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public AccountingPeriodRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public AccountingPeriodRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public AccountingPeriodRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public AccountingPeriodRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public AccountingPeriodRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public AccountingPeriodRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingPeriodRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingPeriodRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public AccountingPeriodRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingPeriodRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public AccountingPeriodRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public AccountingPeriodRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public AccountingPeriodRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public AccountingPeriodRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public AccountingPeriodRequest countName() {
    return countName("countName");
  }

  public AccountingPeriodRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public AccountingPeriodRequest maxName() {
    return maxName("maxName");
  }

  public AccountingPeriodRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public AccountingPeriodRequest minName() {
    return minName("minName");
  }

  public AccountingPeriodRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public AccountingPeriodRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public AccountingPeriodRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public AccountingPeriodRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public AccountingPeriodRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public AccountingPeriodRequest filterByStartDate(Date startDate) {

    if (startDate == null) {
      return this;
    }

    return filterByStartDate(QueryOperator.EQUAL, startDate);
  }

  public AccountingPeriodRequest whereStartDateIsNull() {
    return where(START_DATE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingPeriodRequest whereStartDateIsNotNull() {
    return where(START_DATE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingPeriodRequest whereStartDateBetween(Date startDateStart, Date startDateEnd) {
    if (ObjectUtil.isEmpty(startDateStart)) {
      throw new IllegalArgumentException(
          "Method whereStartDateBetween, the parameter startDateStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(startDateEnd)) {
      throw new IllegalArgumentException(
          "Method whereStartDateBetween, the parameter startDateEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getStartDateSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {startDateStart, startDateEnd});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest whereStartDateBefore(Date startDate) {

    if (ObjectUtil.isEmpty(startDate)) {
      throw new IllegalArgumentException(
          "Method whereStartDateBefore, the parameter startDate is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getStartDateSearchCriteria(QueryOperator.LESS_THAN, new Object[] {startDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest whereStartDateAfter(Date startDate) {
    if (ObjectUtil.isEmpty(startDate)) {
      throw new IllegalArgumentException(
          "Method whereStartDateAfter, the parameter startDate is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getStartDateSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {startDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest filterByStartDate(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getStartDateSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest selectStartDate() {
    return select(START_DATE_PROPERTY);
  }

  public AccountingPeriodRequest unselectStartDate() {
    return unselect(START_DATE_PROPERTY);
  }

  public SearchCriteria getStartDateSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(START_DATE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingPeriodRequest orderByStartDate(boolean asc) {
    addOrderBy(START_DATE_PROPERTY, asc);
    return this;
  }

  public AccountingPeriodRequest orderByStartDateAscending() {
    addOrderBy(START_DATE_PROPERTY, true);
    return this;
  }

  public AccountingPeriodRequest orderByStartDateDescending() {
    addOrderBy(START_DATE_PROPERTY, false);
    return this;
  }

  public AccountingPeriodRequest countStartDate() {
    return countStartDate("countStartDate");
  }

  public AccountingPeriodRequest countStartDate(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, START_DATE_PROPERTY);
  }

  public AccountingPeriodRequest maxStartDate() {
    return maxStartDate("maxStartDate");
  }

  public AccountingPeriodRequest maxStartDate(String aggName) {
    return aggregate(aggName, AggFunc.MAX, START_DATE_PROPERTY);
  }

  public AccountingPeriodRequest minStartDate() {
    return minStartDate("minStartDate");
  }

  public AccountingPeriodRequest minStartDate(String aggName) {
    return aggregate(aggName, AggFunc.MIN, START_DATE_PROPERTY);
  }

  public AccountingPeriodRequest groupByStartDate() {
    return groupByStartDate(START_DATE_PROPERTY);
  }

  public AccountingPeriodRequest groupByStartDate(String ret) {
    return groupBy(ret, START_DATE_PROPERTY);
  }

  public AccountingPeriodRequest groupByStartDate(SqlFunction func) {
    return groupByStartDate(START_DATE_PROPERTY, func);
  }

  public AccountingPeriodRequest groupByStartDate(String ret, SqlFunction func) {
    super.groupBy(ret, func, START_DATE_PROPERTY);
    return this;
  }

  public AccountingPeriodRequest filterByEndDate(Date endDate) {

    if (endDate == null) {
      return this;
    }

    return filterByEndDate(QueryOperator.EQUAL, endDate);
  }

  public AccountingPeriodRequest whereEndDateIsNull() {
    return where(END_DATE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingPeriodRequest whereEndDateIsNotNull() {
    return where(END_DATE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingPeriodRequest whereEndDateBetween(Date endDateStart, Date endDateEnd) {
    if (ObjectUtil.isEmpty(endDateStart)) {
      throw new IllegalArgumentException(
          "Method whereEndDateBetween, the parameter endDateStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(endDateEnd)) {
      throw new IllegalArgumentException(
          "Method whereEndDateBetween, the parameter endDateEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEndDateSearchCriteria(QueryOperator.BETWEEN, new Object[] {endDateStart, endDateEnd});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest whereEndDateBefore(Date endDate) {

    if (ObjectUtil.isEmpty(endDate)) {
      throw new IllegalArgumentException(
          "Method whereEndDateBefore, the parameter endDate is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getEndDateSearchCriteria(QueryOperator.LESS_THAN, new Object[] {endDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest whereEndDateAfter(Date endDate) {
    if (ObjectUtil.isEmpty(endDate)) {
      throw new IllegalArgumentException(
          "Method whereEndDateAfter, the parameter endDate is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getEndDateSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {endDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest filterByEndDate(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEndDateSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest selectEndDate() {
    return select(END_DATE_PROPERTY);
  }

  public AccountingPeriodRequest unselectEndDate() {
    return unselect(END_DATE_PROPERTY);
  }

  public SearchCriteria getEndDateSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(END_DATE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingPeriodRequest orderByEndDate(boolean asc) {
    addOrderBy(END_DATE_PROPERTY, asc);
    return this;
  }

  public AccountingPeriodRequest orderByEndDateAscending() {
    addOrderBy(END_DATE_PROPERTY, true);
    return this;
  }

  public AccountingPeriodRequest orderByEndDateDescending() {
    addOrderBy(END_DATE_PROPERTY, false);
    return this;
  }

  public AccountingPeriodRequest countEndDate() {
    return countEndDate("countEndDate");
  }

  public AccountingPeriodRequest countEndDate(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, END_DATE_PROPERTY);
  }

  public AccountingPeriodRequest maxEndDate() {
    return maxEndDate("maxEndDate");
  }

  public AccountingPeriodRequest maxEndDate(String aggName) {
    return aggregate(aggName, AggFunc.MAX, END_DATE_PROPERTY);
  }

  public AccountingPeriodRequest minEndDate() {
    return minEndDate("minEndDate");
  }

  public AccountingPeriodRequest minEndDate(String aggName) {
    return aggregate(aggName, AggFunc.MIN, END_DATE_PROPERTY);
  }

  public AccountingPeriodRequest groupByEndDate() {
    return groupByEndDate(END_DATE_PROPERTY);
  }

  public AccountingPeriodRequest groupByEndDate(String ret) {
    return groupBy(ret, END_DATE_PROPERTY);
  }

  public AccountingPeriodRequest groupByEndDate(SqlFunction func) {
    return groupByEndDate(END_DATE_PROPERTY, func);
  }

  public AccountingPeriodRequest groupByEndDate(String ret, SqlFunction func) {
    super.groupBy(ret, func, END_DATE_PROPERTY);
    return this;
  }

  public AccountingPeriodRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public AccountingPeriodRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingPeriodRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingPeriodRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingPeriodRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public AccountingPeriodRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingPeriodRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public AccountingPeriodRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public AccountingPeriodRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public AccountingPeriodRequest countVersion() {
    return countVersion("countVersion");
  }

  public AccountingPeriodRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public AccountingPeriodRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public AccountingPeriodRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public AccountingPeriodRequest minVersion() {
    return minVersion("minVersion");
  }

  public AccountingPeriodRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public AccountingPeriodRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public AccountingPeriodRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public AccountingPeriodRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public AccountingPeriodRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public AccountingPeriodRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public AccountingPeriodRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public AccountingPeriodRequest filterByAccountSet(AccountSetRequest accountSet) {
    return filterByAccountSet(accountSet, AccountSet::getId);
  }

  public AccountingPeriodRequest filterByAccountSet(AccountSet... accountSet) {
    if (isEmptyParam(accountSet)) {
      throw new IllegalArgumentException("filterByAccountSet(AccountSet... accountSet)参数不能为空!");
    }
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IN, (Object[]) accountSet);
  }

  public AccountingPeriodRequest selectAccountSetId() {
    select(ACCOUNT_SET_PROPERTY);
    return this;
  }

  public AccountSetRequest upToAccountSet() {
    return upToAccountSet(AccountSetRequest.newInstance());
  }

  public AccountSetRequest upToAccountSet(AccountSetRequest accountSet) {
    accountSet.aggregateChild(ACCOUNT_SET_PROPERTY, this);
    this.groupByAccountSet(accountSet);
    return accountSet;
  }

  public AccountSetRequest endAtAccountSet(String retName) {
    return endAtAccountSet(retName, AccountSetRequest.newInstance());
  }

  public AccountSetRequest endAtAccountSet(String retName, AccountSetRequest accountSet) {
    accountSet.addDynamicProperty(retName, this, ACCOUNT_SET_PROPERTY);
    return accountSet;
  }

  public AccountingPeriodRequest filterByAccountSet(String... accountSet) {
    if (isEmptyParam(accountSet)) {
      throw new IllegalArgumentException("filterByAccountSet(String... accountSet)参数不能为空!");
    }
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IN, (Object[]) accountSet);
  }

  public AccountingPeriodRequest filterByAccountSet(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    accountSet.unlimited();
    return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
  }

  public SearchCriteria createAccountSetCriteria(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    return new RefinedIdInCriteria(
        accountSet, ACCOUNT_SET_PROPERTY, idRefine, AccountSet.ID_PROPERTY);
  }

  public AccountingPeriodRequest selectAccountSet() {
    return selectAccountSet(AccountSetRequest.newInstance().selectSelf());
  }

  public AccountingPeriodRequest selectAccountSet(AccountSetRequest accountSet) {
    selectParent(ACCOUNT_SET_PROPERTY, accountSet);
    return this;
  }

  public AccountingPeriodRequest unselectAccountSet() {
    unselectParent(ACCOUNT_SET_PROPERTY);
    return this;
  }

  public AccountingPeriodRequest groupByAccountSet(AccountSetRequest accountSet) {
    groupBy(ACCOUNT_SET_PROPERTY, accountSet);
    return this;
  }

  public AccountingPeriodRequest aggregateAccountSet(AccountSetRequest accountSet) {
    aggregateParent(ACCOUNT_SET_PROPERTY, accountSet);
    return this;
  }

  public AccountingPeriodRequest countAccountSet() {
    return countAccountSet("countAccountSet");
  }

  public AccountingPeriodRequest countAccountSet(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNT_SET_PROPERTY);
  }

  public AccountingPeriodRequest groupByAccountSet() {
    return groupByAccountSet(ACCOUNT_SET_PROPERTY);
  }

  public AccountingPeriodRequest groupByAccountSet(String ret) {
    return groupBy(ret, ACCOUNT_SET_PROPERTY);
  }

  public AccountingPeriodRequest whereAccountSetIsNull() {
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingPeriodRequest whereAccountSetIsNotNull() {
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingPeriodRequest hasAccountingDocument() {
    return hasAccountingDocument(AccountingDocumentRequest.newInstance());
  }

  public AccountingPeriodRequest hasAccountingDocument(AccountingDocument... accountingDocument) {
    if (isEmptyParam(accountingDocument)) {
      throw new IllegalArgumentException(
          "hasAccountingDocument(AccountingDocument... accountingDocument)参数不能为空!");
    }
    return hasAccountingDocument(
        Q.accountingDocument()
            .select(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountingDocument));
  }

  public AccountingPeriodRequest hasAccountingDocument(String... accountingDocument) {
    return hasAccountingDocument(
        Q.accountingDocument()
            .select(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY)
            .filterById(accountingDocument));
  }

  public AccountingPeriodRequest hasAccountingDocument(
      AccountingDocumentRequest accountingDocument) {
    return hasAccountingDocument(
        accountingDocument,
        $accountingDocument ->
            java.util.Optional.of($accountingDocument)
                .map(AccountingDocument::getAccountingPeriod)
                .map(AccountingPeriod::getId)
                .orElse(null));
  }

  public AccountingPeriodRequest hasAccountingDocument(
      AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine) {
    accountingDocument.select(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY);
    accountingDocument.unlimited();
    return addSearchCriteria(createAccountingDocumentCriteria(accountingDocument, idRefine));
  }

  public AccountingPeriodRequest hasAccountingDocument(
      AccountingDocumentRequest accountingDocument, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountingDocument,
            AccountingDocument.ACCOUNTING_PERIOD_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createAccountingDocumentCriteria(
      AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine) {
    return new RefinedIdInCriteria(
        accountingDocument, ID_PROPERTY, idRefine, AccountingDocument.ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingPeriodRequest selectAccountingDocumentList(
      AccountingDocumentRequest accountingDocument) {
    selectChild(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingDocument);
    return this;
  }

  public AccountingPeriodRequest selectAccountingDocumentList() {
    return selectAccountingDocumentList(AccountingDocumentRequest.newInstance().selectAll());
  }

  public AccountingPeriodRequest unselectAccountingDocumentList() {
    unselectChild(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, AccountingDocument.class);
    return this;
  }

  public AccountingPeriodRequest aggregateAccountingDocumentList(
      AccountingDocumentRequest accountingDocument) {
    aggregateChild(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingDocument);
    return this;
  }

  public AccountingPeriodRequest countAccountingDocument() {
    return countAccountingDocument("accountingDocumentCount");
  }

  public AccountingPeriodRequest countAccountingDocument(String retName) {
    return countAccountingDocument(retName, AccountingDocumentRequest.newInstance());
  }

  public AccountingPeriodRequest countAccountingDocument(
      AccountingDocumentRequest accountingDocument) {
    return countAccountingDocument("accountingDocumentCount", accountingDocument);
  }

  public AccountingPeriodRequest countAccountingDocument(
      String retName, AccountingDocumentRequest accountingDocument) {
    accountingDocument.count();
    return statsFromAccountingDocument(retName, accountingDocument);
  }

  public AccountingPeriodRequest statsFromAccountingDocument(
      String retName, AccountingDocumentRequest accountingDocument) {
    return addDynamicProperty(
        retName, accountingDocument, AccountingDocument.ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingPeriodRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public AccountingPeriodRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public AccountingPeriodRequest unlimited() {
    super.unlimited();
    return this;
  }

  public AccountingPeriodRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
