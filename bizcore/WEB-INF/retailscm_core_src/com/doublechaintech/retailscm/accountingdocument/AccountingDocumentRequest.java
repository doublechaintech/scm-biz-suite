package com.doublechaintech.retailscm.accountingdocument;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingdocument.AccountingDocument.*;

public class AccountingDocumentRequest extends BaseRequest<AccountingDocument> {
  public static AccountingDocumentRequest newInstance() {
    return new AccountingDocumentRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public AccountingDocumentRequest resultByClass(Class<? extends AccountingDocument> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public AccountingDocumentRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public AccountingDocumentRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "AccountingDocument";
  }

  public AccountingDocumentRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public AccountingDocumentRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public AccountingDocumentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public AccountingDocumentRequest select(String... names) {
    super.select(names);
    return this;
  }

  public AccountingDocumentRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectAccountingDocumentDate()
        .selectAccountingPeriod()
        .selectDocumentType()
        .selectVersion();
  }

  public AccountingDocumentRequest selectAny() {
    return selectAll()
        .selectOriginalVoucherList(Q.originalVoucher().selectSelf())
        .selectAccountingDocumentLineList(Q.accountingDocumentLine().selectSelf());
  }

  public AccountingDocumentRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(ACCOUNTING_DOCUMENT_DATE_PROPERTY);
    select(ACCOUNTING_PERIOD_PROPERTY);
    select(DOCUMENT_TYPE_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public AccountingDocumentRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public AccountingDocumentRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {ACCOUNTING_DOCUMENT_DATE_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    ACCOUNTING_DOCUMENT_DATE_PROPERTY,
    ACCOUNTING_PERIOD_PROPERTY,
    DOCUMENT_TYPE_PROPERTY,
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

  public AccountingDocumentRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public AccountingDocumentRequest comment(String comment) {
    return this;
  }

  public AccountingDocumentRequest enhance() {
    return this;
  }

  public AccountingDocumentRequest overrideClass(Class<? extends AccountingDocument> clazz) {
    return this;
  }

  public AccountingDocumentRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public AccountingDocumentRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public AccountingDocumentRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public AccountingDocumentRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public AccountingDocumentRequest count() {
    return countId("count");
  }

  public static AccountingDocumentRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public AccountingDocumentRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public AccountingDocumentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentRequest selectId() {
    return select(ID_PROPERTY);
  }

  public AccountingDocumentRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public AccountingDocumentRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public AccountingDocumentRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public AccountingDocumentRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public AccountingDocumentRequest countId() {
    return countId("countId");
  }

  public AccountingDocumentRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public AccountingDocumentRequest maxId() {
    return maxId("maxId");
  }

  public AccountingDocumentRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public AccountingDocumentRequest minId() {
    return minId("minId");
  }

  public AccountingDocumentRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public AccountingDocumentRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public AccountingDocumentRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public AccountingDocumentRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public AccountingDocumentRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public AccountingDocumentRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public AccountingDocumentRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public AccountingDocumentRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public AccountingDocumentRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public AccountingDocumentRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public AccountingDocumentRequest countName() {
    return countName("countName");
  }

  public AccountingDocumentRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public AccountingDocumentRequest maxName() {
    return maxName("maxName");
  }

  public AccountingDocumentRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public AccountingDocumentRequest minName() {
    return minName("minName");
  }

  public AccountingDocumentRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public AccountingDocumentRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public AccountingDocumentRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public AccountingDocumentRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public AccountingDocumentRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest filterByAccountingDocumentDate(Date accountingDocumentDate) {

    if (accountingDocumentDate == null) {
      return this;
    }

    return filterByAccountingDocumentDate(QueryOperator.EQUAL, accountingDocumentDate);
  }

  public AccountingDocumentRequest whereAccountingDocumentDateIsNull() {
    return where(ACCOUNTING_DOCUMENT_DATE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentRequest whereAccountingDocumentDateIsNotNull() {
    return where(ACCOUNTING_DOCUMENT_DATE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentRequest whereAccountingDocumentDateBetween(
      Date accountingDocumentDateStart, Date accountingDocumentDateEnd) {
    if (ObjectUtil.isEmpty(accountingDocumentDateStart)) {
      throw new IllegalArgumentException(
          "Method whereAccountingDocumentDateBetween, the parameter accountingDocumentDateStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(accountingDocumentDateEnd)) {
      throw new IllegalArgumentException(
          "Method whereAccountingDocumentDateBetween, the parameter accountingDocumentDateEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAccountingDocumentDateSearchCriteria(
            QueryOperator.BETWEEN,
            new Object[] {accountingDocumentDateStart, accountingDocumentDateEnd});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentRequest whereAccountingDocumentDateBefore(Date accountingDocumentDate) {

    if (ObjectUtil.isEmpty(accountingDocumentDate)) {
      throw new IllegalArgumentException(
          "Method whereAccountingDocumentDateBefore, the parameter accountingDocumentDate is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getAccountingDocumentDateSearchCriteria(
            QueryOperator.LESS_THAN, new Object[] {accountingDocumentDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentRequest whereAccountingDocumentDateAfter(Date accountingDocumentDate) {
    if (ObjectUtil.isEmpty(accountingDocumentDate)) {
      throw new IllegalArgumentException(
          "Method whereAccountingDocumentDateAfter, the parameter accountingDocumentDate is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAccountingDocumentDateSearchCriteria(
            QueryOperator.GREATER_THAN, new Object[] {accountingDocumentDate});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentRequest filterByAccountingDocumentDate(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getAccountingDocumentDateSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentRequest selectAccountingDocumentDate() {
    return select(ACCOUNTING_DOCUMENT_DATE_PROPERTY);
  }

  public AccountingDocumentRequest unselectAccountingDocumentDate() {
    return unselect(ACCOUNTING_DOCUMENT_DATE_PROPERTY);
  }

  public SearchCriteria getAccountingDocumentDateSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(
        ACCOUNTING_DOCUMENT_DATE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentRequest orderByAccountingDocumentDate(boolean asc) {
    addOrderBy(ACCOUNTING_DOCUMENT_DATE_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentRequest orderByAccountingDocumentDateAscending() {
    addOrderBy(ACCOUNTING_DOCUMENT_DATE_PROPERTY, true);
    return this;
  }

  public AccountingDocumentRequest orderByAccountingDocumentDateDescending() {
    addOrderBy(ACCOUNTING_DOCUMENT_DATE_PROPERTY, false);
    return this;
  }

  public AccountingDocumentRequest countAccountingDocumentDate() {
    return countAccountingDocumentDate("countAccountingDocumentDate");
  }

  public AccountingDocumentRequest countAccountingDocumentDate(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_DOCUMENT_DATE_PROPERTY);
  }

  public AccountingDocumentRequest maxAccountingDocumentDate() {
    return maxAccountingDocumentDate("maxAccountingDocumentDate");
  }

  public AccountingDocumentRequest maxAccountingDocumentDate(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCOUNTING_DOCUMENT_DATE_PROPERTY);
  }

  public AccountingDocumentRequest minAccountingDocumentDate() {
    return minAccountingDocumentDate("minAccountingDocumentDate");
  }

  public AccountingDocumentRequest minAccountingDocumentDate(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCOUNTING_DOCUMENT_DATE_PROPERTY);
  }

  public AccountingDocumentRequest groupByAccountingDocumentDate() {
    return groupByAccountingDocumentDate(ACCOUNTING_DOCUMENT_DATE_PROPERTY);
  }

  public AccountingDocumentRequest groupByAccountingDocumentDate(String ret) {
    return groupBy(ret, ACCOUNTING_DOCUMENT_DATE_PROPERTY);
  }

  public AccountingDocumentRequest groupByAccountingDocumentDate(SqlFunction func) {
    return groupByAccountingDocumentDate(ACCOUNTING_DOCUMENT_DATE_PROPERTY, func);
  }

  public AccountingDocumentRequest groupByAccountingDocumentDate(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCOUNTING_DOCUMENT_DATE_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public AccountingDocumentRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public AccountingDocumentRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public AccountingDocumentRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public AccountingDocumentRequest countVersion() {
    return countVersion("countVersion");
  }

  public AccountingDocumentRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public AccountingDocumentRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public AccountingDocumentRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public AccountingDocumentRequest minVersion() {
    return minVersion("minVersion");
  }

  public AccountingDocumentRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public AccountingDocumentRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public AccountingDocumentRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public AccountingDocumentRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public AccountingDocumentRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public AccountingDocumentRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public AccountingDocumentRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest filterByAccountingPeriod(
      AccountingPeriodRequest accountingPeriod) {
    return filterByAccountingPeriod(accountingPeriod, AccountingPeriod::getId);
  }

  public AccountingDocumentRequest filterByAccountingPeriod(AccountingPeriod... accountingPeriod) {
    if (isEmptyParam(accountingPeriod)) {
      throw new IllegalArgumentException(
          "filterByAccountingPeriod(AccountingPeriod... accountingPeriod)参数不能为空!");
    }
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IN, (Object[]) accountingPeriod);
  }

  public AccountingDocumentRequest selectAccountingPeriodId() {
    select(ACCOUNTING_PERIOD_PROPERTY);
    return this;
  }

  public AccountingPeriodRequest upToAccountingPeriod() {
    return upToAccountingPeriod(AccountingPeriodRequest.newInstance());
  }

  public AccountingPeriodRequest upToAccountingPeriod(AccountingPeriodRequest accountingPeriod) {
    accountingPeriod.aggregateChild(ACCOUNTING_PERIOD_PROPERTY, this);
    this.groupByAccountingPeriod(accountingPeriod);
    return accountingPeriod;
  }

  public AccountingPeriodRequest endAtAccountingPeriod(String retName) {
    return endAtAccountingPeriod(retName, AccountingPeriodRequest.newInstance());
  }

  public AccountingPeriodRequest endAtAccountingPeriod(
      String retName, AccountingPeriodRequest accountingPeriod) {
    accountingPeriod.addDynamicProperty(retName, this, ACCOUNTING_PERIOD_PROPERTY);
    return accountingPeriod;
  }

  public AccountingDocumentRequest filterByAccountingPeriod(String... accountingPeriod) {
    if (isEmptyParam(accountingPeriod)) {
      throw new IllegalArgumentException(
          "filterByAccountingPeriod(String... accountingPeriod)参数不能为空!");
    }
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IN, (Object[]) accountingPeriod);
  }

  public AccountingDocumentRequest filterByAccountingPeriod(
      AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine) {
    accountingPeriod.unlimited();
    return addSearchCriteria(createAccountingPeriodCriteria(accountingPeriod, idRefine));
  }

  public SearchCriteria createAccountingPeriodCriteria(
      AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine) {
    return new RefinedIdInCriteria(
        accountingPeriod, ACCOUNTING_PERIOD_PROPERTY, idRefine, AccountingPeriod.ID_PROPERTY);
  }

  public AccountingDocumentRequest selectAccountingPeriod() {
    return selectAccountingPeriod(AccountingPeriodRequest.newInstance().selectSelf());
  }

  public AccountingDocumentRequest selectAccountingPeriod(
      AccountingPeriodRequest accountingPeriod) {
    selectParent(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountingDocumentRequest unselectAccountingPeriod() {
    unselectParent(ACCOUNTING_PERIOD_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest groupByAccountingPeriod(
      AccountingPeriodRequest accountingPeriod) {
    groupBy(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountingDocumentRequest aggregateAccountingPeriod(
      AccountingPeriodRequest accountingPeriod) {
    aggregateParent(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountingDocumentRequest countAccountingPeriod() {
    return countAccountingPeriod("countAccountingPeriod");
  }

  public AccountingDocumentRequest countAccountingPeriod(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingDocumentRequest groupByAccountingPeriod() {
    return groupByAccountingPeriod(ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingDocumentRequest groupByAccountingPeriod(String ret) {
    return groupBy(ret, ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingDocumentRequest whereAccountingPeriodIsNull() {
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentRequest whereAccountingPeriodIsNotNull() {
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentRequest filterByDocumentType(
      AccountingDocumentTypeRequest documentType) {
    return filterByDocumentType(documentType, AccountingDocumentType::getId);
  }

  public AccountingDocumentRequest filterByDocumentType(AccountingDocumentType... documentType) {
    if (isEmptyParam(documentType)) {
      throw new IllegalArgumentException(
          "filterByDocumentType(AccountingDocumentType... documentType)参数不能为空!");
    }
    return where(DOCUMENT_TYPE_PROPERTY, QueryOperator.IN, (Object[]) documentType);
  }

  public AccountingDocumentRequest selectDocumentTypeId() {
    select(DOCUMENT_TYPE_PROPERTY);
    return this;
  }

  public AccountingDocumentTypeRequest upToDocumentType() {
    return upToDocumentType(AccountingDocumentTypeRequest.newInstance());
  }

  public AccountingDocumentTypeRequest upToDocumentType(
      AccountingDocumentTypeRequest documentType) {
    documentType.aggregateChild(DOCUMENT_TYPE_PROPERTY, this);
    this.groupByDocumentType(documentType);
    return documentType;
  }

  public AccountingDocumentTypeRequest endAtDocumentType(String retName) {
    return endAtDocumentType(retName, AccountingDocumentTypeRequest.newInstance());
  }

  public AccountingDocumentTypeRequest endAtDocumentType(
      String retName, AccountingDocumentTypeRequest documentType) {
    documentType.addDynamicProperty(retName, this, DOCUMENT_TYPE_PROPERTY);
    return documentType;
  }

  public AccountingDocumentRequest filterByDocumentType(String... documentType) {
    if (isEmptyParam(documentType)) {
      throw new IllegalArgumentException("filterByDocumentType(String... documentType)参数不能为空!");
    }
    return where(DOCUMENT_TYPE_PROPERTY, QueryOperator.IN, (Object[]) documentType);
  }

  public AccountingDocumentRequest filterByDocumentType(
      AccountingDocumentTypeRequest documentType, IDRefine<AccountingDocumentType> idRefine) {
    documentType.unlimited();
    return addSearchCriteria(createDocumentTypeCriteria(documentType, idRefine));
  }

  public SearchCriteria createDocumentTypeCriteria(
      AccountingDocumentTypeRequest documentType, IDRefine<AccountingDocumentType> idRefine) {
    return new RefinedIdInCriteria(
        documentType, DOCUMENT_TYPE_PROPERTY, idRefine, AccountingDocumentType.ID_PROPERTY);
  }

  public AccountingDocumentRequest selectDocumentType() {
    return selectDocumentType(AccountingDocumentTypeRequest.newInstance().selectSelf());
  }

  public AccountingDocumentRequest selectDocumentType(AccountingDocumentTypeRequest documentType) {
    selectParent(DOCUMENT_TYPE_PROPERTY, documentType);
    return this;
  }

  public AccountingDocumentRequest unselectDocumentType() {
    unselectParent(DOCUMENT_TYPE_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest groupByDocumentType(AccountingDocumentTypeRequest documentType) {
    groupBy(DOCUMENT_TYPE_PROPERTY, documentType);
    return this;
  }

  public AccountingDocumentRequest aggregateDocumentType(
      AccountingDocumentTypeRequest documentType) {
    aggregateParent(DOCUMENT_TYPE_PROPERTY, documentType);
    return this;
  }

  public AccountingDocumentRequest countDocumentType() {
    return countDocumentType("countDocumentType");
  }

  public AccountingDocumentRequest countDocumentType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DOCUMENT_TYPE_PROPERTY);
  }

  public AccountingDocumentRequest groupByDocumentType() {
    return groupByDocumentType(DOCUMENT_TYPE_PROPERTY);
  }

  public AccountingDocumentRequest groupByDocumentType(String ret) {
    return groupBy(ret, DOCUMENT_TYPE_PROPERTY);
  }

  public AccountingDocumentRequest whereDocumentTypeIsNull() {
    return where(DOCUMENT_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentRequest whereDocumentTypeIsNotNull() {
    return where(DOCUMENT_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentRequest hasOriginalVoucher() {
    return hasOriginalVoucher(OriginalVoucherRequest.newInstance());
  }

  public AccountingDocumentRequest hasOriginalVoucher(OriginalVoucher... originalVoucher) {
    if (isEmptyParam(originalVoucher)) {
      throw new IllegalArgumentException(
          "hasOriginalVoucher(OriginalVoucher... originalVoucher)参数不能为空!");
    }
    return hasOriginalVoucher(
        Q.originalVoucher()
            .select(OriginalVoucher.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) originalVoucher));
  }

  public AccountingDocumentRequest hasOriginalVoucher(String... originalVoucher) {
    return hasOriginalVoucher(
        Q.originalVoucher()
            .select(OriginalVoucher.BELONGS_TO_PROPERTY)
            .filterById(originalVoucher));
  }

  public AccountingDocumentRequest hasOriginalVoucher(OriginalVoucherRequest originalVoucher) {
    return hasOriginalVoucher(
        originalVoucher,
        $originalVoucher ->
            java.util.Optional.of($originalVoucher)
                .map(OriginalVoucher::getBelongsTo)
                .map(AccountingDocument::getId)
                .orElse(null));
  }

  public AccountingDocumentRequest hasOriginalVoucher(
      OriginalVoucherRequest originalVoucher, IDRefine<OriginalVoucher> idRefine) {
    originalVoucher.select(OriginalVoucher.BELONGS_TO_PROPERTY);
    originalVoucher.unlimited();
    return addSearchCriteria(createOriginalVoucherCriteria(originalVoucher, idRefine));
  }

  public AccountingDocumentRequest hasOriginalVoucher(
      OriginalVoucherRequest originalVoucher, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            originalVoucher, OriginalVoucher.BELONGS_TO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createOriginalVoucherCriteria(
      OriginalVoucherRequest originalVoucher, IDRefine<OriginalVoucher> idRefine) {
    return new RefinedIdInCriteria(
        originalVoucher, ID_PROPERTY, idRefine, OriginalVoucher.BELONGS_TO_PROPERTY);
  }

  public AccountingDocumentRequest selectOriginalVoucherList(
      OriginalVoucherRequest originalVoucher) {
    selectChild(OriginalVoucher.BELONGS_TO_PROPERTY, originalVoucher);
    return this;
  }

  public AccountingDocumentRequest selectOriginalVoucherList() {
    return selectOriginalVoucherList(OriginalVoucherRequest.newInstance().selectAll());
  }

  public AccountingDocumentRequest unselectOriginalVoucherList() {
    unselectChild(OriginalVoucher.BELONGS_TO_PROPERTY, OriginalVoucher.class);
    return this;
  }

  public AccountingDocumentRequest hasAccountingDocumentLine() {
    return hasAccountingDocumentLine(AccountingDocumentLineRequest.newInstance());
  }

  public AccountingDocumentRequest hasAccountingDocumentLine(
      AccountingDocumentLine... accountingDocumentLine) {
    if (isEmptyParam(accountingDocumentLine)) {
      throw new IllegalArgumentException(
          "hasAccountingDocumentLine(AccountingDocumentLine... accountingDocumentLine)参数不能为空!");
    }
    return hasAccountingDocumentLine(
        Q.accountingDocumentLine()
            .select(AccountingDocumentLine.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountingDocumentLine));
  }

  public AccountingDocumentRequest hasAccountingDocumentLine(String... accountingDocumentLine) {
    return hasAccountingDocumentLine(
        Q.accountingDocumentLine()
            .select(AccountingDocumentLine.BELONGS_TO_PROPERTY)
            .filterById(accountingDocumentLine));
  }

  public AccountingDocumentRequest hasAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine) {
    return hasAccountingDocumentLine(
        accountingDocumentLine,
        $accountingDocumentLine ->
            java.util.Optional.of($accountingDocumentLine)
                .map(AccountingDocumentLine::getBelongsTo)
                .map(AccountingDocument::getId)
                .orElse(null));
  }

  public AccountingDocumentRequest hasAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine,
      IDRefine<AccountingDocumentLine> idRefine) {
    accountingDocumentLine.select(AccountingDocumentLine.BELONGS_TO_PROPERTY);
    accountingDocumentLine.unlimited();
    return addSearchCriteria(
        createAccountingDocumentLineCriteria(accountingDocumentLine, idRefine));
  }

  public AccountingDocumentRequest hasAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountingDocumentLine,
            AccountingDocumentLine.BELONGS_TO_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createAccountingDocumentLineCriteria(
      AccountingDocumentLineRequest accountingDocumentLine,
      IDRefine<AccountingDocumentLine> idRefine) {
    return new RefinedIdInCriteria(
        accountingDocumentLine, ID_PROPERTY, idRefine, AccountingDocumentLine.BELONGS_TO_PROPERTY);
  }

  public AccountingDocumentRequest selectAccountingDocumentLineList(
      AccountingDocumentLineRequest accountingDocumentLine) {
    selectChild(AccountingDocumentLine.BELONGS_TO_PROPERTY, accountingDocumentLine);
    return this;
  }

  public AccountingDocumentRequest selectAccountingDocumentLineList() {
    return selectAccountingDocumentLineList(
        AccountingDocumentLineRequest.newInstance().selectAll());
  }

  public AccountingDocumentRequest unselectAccountingDocumentLineList() {
    unselectChild(AccountingDocumentLine.BELONGS_TO_PROPERTY, AccountingDocumentLine.class);
    return this;
  }

  public AccountingDocumentRequest aggregateOriginalVoucherList(
      OriginalVoucherRequest originalVoucher) {
    aggregateChild(OriginalVoucher.BELONGS_TO_PROPERTY, originalVoucher);
    return this;
  }

  public AccountingDocumentRequest countOriginalVoucher() {
    return countOriginalVoucher("originalVoucherCount");
  }

  public AccountingDocumentRequest countOriginalVoucher(String retName) {
    return countOriginalVoucher(retName, OriginalVoucherRequest.newInstance());
  }

  public AccountingDocumentRequest countOriginalVoucher(OriginalVoucherRequest originalVoucher) {
    return countOriginalVoucher("originalVoucherCount", originalVoucher);
  }

  public AccountingDocumentRequest countOriginalVoucher(
      String retName, OriginalVoucherRequest originalVoucher) {
    originalVoucher.count();
    return statsFromOriginalVoucher(retName, originalVoucher);
  }

  public AccountingDocumentRequest statsFromOriginalVoucher(
      String retName, OriginalVoucherRequest originalVoucher) {
    return addDynamicProperty(retName, originalVoucher, OriginalVoucher.BELONGS_TO_PROPERTY);
  }

  public AccountingDocumentRequest aggregateAccountingDocumentLineList(
      AccountingDocumentLineRequest accountingDocumentLine) {
    aggregateChild(AccountingDocumentLine.BELONGS_TO_PROPERTY, accountingDocumentLine);
    return this;
  }

  public AccountingDocumentRequest countAccountingDocumentLine() {
    return countAccountingDocumentLine("accountingDocumentLineCount");
  }

  public AccountingDocumentRequest countAccountingDocumentLine(String retName) {
    return countAccountingDocumentLine(retName, AccountingDocumentLineRequest.newInstance());
  }

  public AccountingDocumentRequest countAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine) {
    return countAccountingDocumentLine("accountingDocumentLineCount", accountingDocumentLine);
  }

  public AccountingDocumentRequest countAccountingDocumentLine(
      String retName, AccountingDocumentLineRequest accountingDocumentLine) {
    accountingDocumentLine.count();
    return statsFromAccountingDocumentLine(retName, accountingDocumentLine);
  }

  public AccountingDocumentRequest statsFromAccountingDocumentLine(
      String retName, AccountingDocumentLineRequest accountingDocumentLine) {
    return addDynamicProperty(
        retName, accountingDocumentLine, AccountingDocumentLine.BELONGS_TO_PROPERTY);
  }

  public AccountingDocumentRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public AccountingDocumentRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public AccountingDocumentRequest unlimited() {
    super.unlimited();
    return this;
  }

  public AccountingDocumentRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
