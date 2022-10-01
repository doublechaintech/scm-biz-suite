package com.doublechaintech.retailscm.accountingsubject;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingsubject.AccountingSubject.*;

public class AccountingSubjectRequest extends BaseRequest<AccountingSubject> {
  public static AccountingSubjectRequest newInstance() {
    return new AccountingSubjectRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public AccountingSubjectRequest resultByClass(Class<? extends AccountingSubject> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public AccountingSubjectRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public AccountingSubjectRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "AccountingSubject";
  }

  public AccountingSubjectRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public AccountingSubjectRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public AccountingSubjectRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public AccountingSubjectRequest select(String... names) {
    super.select(names);
    return this;
  }

  public AccountingSubjectRequest selectAll() {
    return this.selectId()
        .selectAccountingSubjectCode()
        .selectAccountingSubjectName()
        .selectAccountingSubjectClassCode()
        .selectAccountingSubjectClassName()
        .selectAccountSet()
        .selectVersion();
  }

  public AccountingSubjectRequest selectAny() {
    return selectAll().selectAccountingDocumentLineList(Q.accountingDocumentLine().selectSelf());
  }

  public AccountingSubjectRequest selectSelf() {
    select(ID_PROPERTY);
    select(ACCOUNTING_SUBJECT_CODE_PROPERTY);
    select(ACCOUNTING_SUBJECT_NAME_PROPERTY);
    select(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
    select(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
    select(ACCOUNT_SET_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public AccountingSubjectRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public AccountingSubjectRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    ACCOUNTING_SUBJECT_CODE_PROPERTY,
    ACCOUNTING_SUBJECT_NAME_PROPERTY,
    ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY,
    ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY,
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

  public AccountingSubjectRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public AccountingSubjectRequest comment(String comment) {
    return this;
  }

  public AccountingSubjectRequest enhance() {
    return this;
  }

  public AccountingSubjectRequest overrideClass(Class<? extends AccountingSubject> clazz) {
    return this;
  }

  public AccountingSubjectRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public AccountingSubjectRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public AccountingSubjectRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public AccountingSubjectRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public AccountingSubjectRequest count() {
    return countId("count");
  }

  public static AccountingSubjectRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public AccountingSubjectRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public AccountingSubjectRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest selectId() {
    return select(ID_PROPERTY);
  }

  public AccountingSubjectRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingSubjectRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public AccountingSubjectRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public AccountingSubjectRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public AccountingSubjectRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public AccountingSubjectRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public AccountingSubjectRequest countId() {
    return countId("countId");
  }

  public AccountingSubjectRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public AccountingSubjectRequest maxId() {
    return maxId("maxId");
  }

  public AccountingSubjectRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public AccountingSubjectRequest minId() {
    return minId("minId");
  }

  public AccountingSubjectRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public AccountingSubjectRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public AccountingSubjectRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public AccountingSubjectRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public AccountingSubjectRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest filterByAccountingSubjectCode(String accountingSubjectCode) {

    if (accountingSubjectCode == null) {
      return this;
    }

    return filterByAccountingSubjectCode(QueryOperator.EQUAL, accountingSubjectCode);
  }

  public AccountingSubjectRequest whereAccountingSubjectCodeIsNull() {
    return where(ACCOUNTING_SUBJECT_CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingSubjectRequest whereAccountingSubjectCodeIsNotNull() {
    return where(ACCOUNTING_SUBJECT_CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingSubjectRequest filterByAccountingSubjectCode(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getAccountingSubjectCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest selectAccountingSubjectCode() {
    return select(ACCOUNTING_SUBJECT_CODE_PROPERTY);
  }

  public AccountingSubjectRequest unselectAccountingSubjectCode() {
    return unselect(ACCOUNTING_SUBJECT_CODE_PROPERTY);
  }

  public SearchCriteria getAccountingSubjectCodeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ACCOUNTING_SUBJECT_CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingSubjectRequest orderByAccountingSubjectCode(boolean asc) {
    addOrderBy(ACCOUNTING_SUBJECT_CODE_PROPERTY, asc);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectCodeAscending() {
    addOrderBy(ACCOUNTING_SUBJECT_CODE_PROPERTY, true);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectCodeDescending() {
    addOrderBy(ACCOUNTING_SUBJECT_CODE_PROPERTY, false);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectCodeAscendingUsingGBK() {
    addOrderBy("convert(accountingSubjectCode using gbk)", true);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectCodeDescendingUsingGBK() {
    addOrderBy("convert(accountingSubjectCode using gbk)", false);
    return this;
  }

  public AccountingSubjectRequest countAccountingSubjectCode() {
    return countAccountingSubjectCode("countAccountingSubjectCode");
  }

  public AccountingSubjectRequest countAccountingSubjectCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_SUBJECT_CODE_PROPERTY);
  }

  public AccountingSubjectRequest maxAccountingSubjectCode() {
    return maxAccountingSubjectCode("maxAccountingSubjectCode");
  }

  public AccountingSubjectRequest maxAccountingSubjectCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCOUNTING_SUBJECT_CODE_PROPERTY);
  }

  public AccountingSubjectRequest minAccountingSubjectCode() {
    return minAccountingSubjectCode("minAccountingSubjectCode");
  }

  public AccountingSubjectRequest minAccountingSubjectCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCOUNTING_SUBJECT_CODE_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectCode() {
    return groupByAccountingSubjectCode(ACCOUNTING_SUBJECT_CODE_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectCode(String ret) {
    return groupBy(ret, ACCOUNTING_SUBJECT_CODE_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectCode(SqlFunction func) {
    return groupByAccountingSubjectCode(ACCOUNTING_SUBJECT_CODE_PROPERTY, func);
  }

  public AccountingSubjectRequest groupByAccountingSubjectCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCOUNTING_SUBJECT_CODE_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest filterByAccountingSubjectName(String accountingSubjectName) {

    if (accountingSubjectName == null) {
      return this;
    }

    return filterByAccountingSubjectName(QueryOperator.EQUAL, accountingSubjectName);
  }

  public AccountingSubjectRequest whereAccountingSubjectNameIsNull() {
    return where(ACCOUNTING_SUBJECT_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingSubjectRequest whereAccountingSubjectNameIsNotNull() {
    return where(ACCOUNTING_SUBJECT_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingSubjectRequest filterByAccountingSubjectName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getAccountingSubjectNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest selectAccountingSubjectName() {
    return select(ACCOUNTING_SUBJECT_NAME_PROPERTY);
  }

  public AccountingSubjectRequest unselectAccountingSubjectName() {
    return unselect(ACCOUNTING_SUBJECT_NAME_PROPERTY);
  }

  public SearchCriteria getAccountingSubjectNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ACCOUNTING_SUBJECT_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingSubjectRequest orderByAccountingSubjectName(boolean asc) {
    addOrderBy(ACCOUNTING_SUBJECT_NAME_PROPERTY, asc);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectNameAscending() {
    addOrderBy(ACCOUNTING_SUBJECT_NAME_PROPERTY, true);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectNameDescending() {
    addOrderBy(ACCOUNTING_SUBJECT_NAME_PROPERTY, false);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectNameAscendingUsingGBK() {
    addOrderBy("convert(accountingSubjectName using gbk)", true);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectNameDescendingUsingGBK() {
    addOrderBy("convert(accountingSubjectName using gbk)", false);
    return this;
  }

  public AccountingSubjectRequest countAccountingSubjectName() {
    return countAccountingSubjectName("countAccountingSubjectName");
  }

  public AccountingSubjectRequest countAccountingSubjectName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_SUBJECT_NAME_PROPERTY);
  }

  public AccountingSubjectRequest maxAccountingSubjectName() {
    return maxAccountingSubjectName("maxAccountingSubjectName");
  }

  public AccountingSubjectRequest maxAccountingSubjectName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCOUNTING_SUBJECT_NAME_PROPERTY);
  }

  public AccountingSubjectRequest minAccountingSubjectName() {
    return minAccountingSubjectName("minAccountingSubjectName");
  }

  public AccountingSubjectRequest minAccountingSubjectName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCOUNTING_SUBJECT_NAME_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectName() {
    return groupByAccountingSubjectName(ACCOUNTING_SUBJECT_NAME_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectName(String ret) {
    return groupBy(ret, ACCOUNTING_SUBJECT_NAME_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectName(SqlFunction func) {
    return groupByAccountingSubjectName(ACCOUNTING_SUBJECT_NAME_PROPERTY, func);
  }

  public AccountingSubjectRequest groupByAccountingSubjectName(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCOUNTING_SUBJECT_NAME_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest filterByAccountingSubjectClassCode(
      int accountingSubjectClassCode) {

    return filterByAccountingSubjectClassCode(QueryOperator.EQUAL, accountingSubjectClassCode);
  }

  public AccountingSubjectRequest whereAccountingSubjectClassCodeIsNull() {
    return where(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingSubjectRequest whereAccountingSubjectClassCodeIsNotNull() {
    return where(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingSubjectRequest whereAccountingSubjectClassCodeBetween(
      Integer accountingSubjectClassCodeStart, Integer accountingSubjectClassCodeEnd) {
    if (ObjectUtil.isEmpty(accountingSubjectClassCodeStart)) {
      throw new IllegalArgumentException(
          "Method whereAccountingSubjectClassCodeBetween, the parameter accountingSubjectClassCodeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(accountingSubjectClassCodeEnd)) {
      throw new IllegalArgumentException(
          "Method whereAccountingSubjectClassCodeBetween, the parameter accountingSubjectClassCodeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAccountingSubjectClassCodeSearchCriteria(
            QueryOperator.BETWEEN,
            new Object[] {accountingSubjectClassCodeStart, accountingSubjectClassCodeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest whereAccountingSubjectClassCodeLessThan(
      Integer accountingSubjectClassCode) {
    if (ObjectUtil.isEmpty(accountingSubjectClassCode)) {
      throw new IllegalArgumentException(
          "Method whereAccountingSubjectClassCodeLessThan, the parameter accountingSubjectClassCode is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAccountingSubjectClassCodeSearchCriteria(
            QueryOperator.LESS_THAN, new Object[] {accountingSubjectClassCode});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest whereAccountingSubjectClassCodeGreaterThan(
      int accountingSubjectClassCode) {
    if (ObjectUtil.isEmpty(accountingSubjectClassCode)) {
      throw new IllegalArgumentException(
          "Method whereAccountingSubjectClassCodeGreaterThan, the parameter accountingSubjectClassCode is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAccountingSubjectClassCodeSearchCriteria(
            QueryOperator.GREATER_THAN, new Object[] {accountingSubjectClassCode});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest filterByAccountingSubjectClassCode(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getAccountingSubjectClassCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest selectAccountingSubjectClassCode() {
    return select(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public AccountingSubjectRequest unselectAccountingSubjectClassCode() {
    return unselect(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public SearchCriteria getAccountingSubjectClassCodeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(
        ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingSubjectRequest orderByAccountingSubjectClassCode(boolean asc) {
    addOrderBy(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, asc);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectClassCodeAscending() {
    addOrderBy(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, true);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectClassCodeDescending() {
    addOrderBy(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, false);
    return this;
  }

  public AccountingSubjectRequest countAccountingSubjectClassCode() {
    return countAccountingSubjectClassCode("countAccountingSubjectClassCode");
  }

  public AccountingSubjectRequest countAccountingSubjectClassCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public AccountingSubjectRequest maxAccountingSubjectClassCode() {
    return maxAccountingSubjectClassCode("maxAccountingSubjectClassCode");
  }

  public AccountingSubjectRequest maxAccountingSubjectClassCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public AccountingSubjectRequest minAccountingSubjectClassCode() {
    return minAccountingSubjectClassCode("minAccountingSubjectClassCode");
  }

  public AccountingSubjectRequest minAccountingSubjectClassCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public AccountingSubjectRequest sumAccountingSubjectClassCode() {
    return sumAccountingSubjectClassCode("sumAccountingSubjectClassCode");
  }

  public AccountingSubjectRequest sumAccountingSubjectClassCode(String aggName) {
    return aggregate(aggName, AggFunc.SUM, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassCode() {
    return groupByAccountingSubjectClassCode(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassCode(String ret) {
    return groupBy(ret, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassCode(SqlFunction func) {
    return groupByAccountingSubjectClassCode(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, func);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest filterByAccountingSubjectClassName(
      String accountingSubjectClassName) {

    if (accountingSubjectClassName == null) {
      return this;
    }

    return filterByAccountingSubjectClassName(QueryOperator.EQUAL, accountingSubjectClassName);
  }

  public AccountingSubjectRequest whereAccountingSubjectClassNameIsNull() {
    return where(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingSubjectRequest whereAccountingSubjectClassNameIsNotNull() {
    return where(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingSubjectRequest filterByAccountingSubjectClassName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getAccountingSubjectClassNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest selectAccountingSubjectClassName() {
    return select(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
  }

  public AccountingSubjectRequest unselectAccountingSubjectClassName() {
    return unselect(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
  }

  public SearchCriteria getAccountingSubjectClassNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(
        ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingSubjectRequest orderByAccountingSubjectClassName(boolean asc) {
    addOrderBy(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, asc);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectClassNameAscending() {
    addOrderBy(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, true);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectClassNameDescending() {
    addOrderBy(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, false);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectClassNameAscendingUsingGBK() {
    addOrderBy("convert(accountingSubjectClassName using gbk)", true);
    return this;
  }

  public AccountingSubjectRequest orderByAccountingSubjectClassNameDescendingUsingGBK() {
    addOrderBy("convert(accountingSubjectClassName using gbk)", false);
    return this;
  }

  public AccountingSubjectRequest countAccountingSubjectClassName() {
    return countAccountingSubjectClassName("countAccountingSubjectClassName");
  }

  public AccountingSubjectRequest countAccountingSubjectClassName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
  }

  public AccountingSubjectRequest maxAccountingSubjectClassName() {
    return maxAccountingSubjectClassName("maxAccountingSubjectClassName");
  }

  public AccountingSubjectRequest maxAccountingSubjectClassName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
  }

  public AccountingSubjectRequest minAccountingSubjectClassName() {
    return minAccountingSubjectClassName("minAccountingSubjectClassName");
  }

  public AccountingSubjectRequest minAccountingSubjectClassName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassName() {
    return groupByAccountingSubjectClassName(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassName(String ret) {
    return groupBy(ret, ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassName(SqlFunction func) {
    return groupByAccountingSubjectClassName(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, func);
  }

  public AccountingSubjectRequest groupByAccountingSubjectClassName(String ret, SqlFunction func) {
    super.groupBy(ret, func, ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public AccountingSubjectRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingSubjectRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingSubjectRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingSubjectRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public AccountingSubjectRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingSubjectRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public AccountingSubjectRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public AccountingSubjectRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public AccountingSubjectRequest countVersion() {
    return countVersion("countVersion");
  }

  public AccountingSubjectRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public AccountingSubjectRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public AccountingSubjectRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public AccountingSubjectRequest minVersion() {
    return minVersion("minVersion");
  }

  public AccountingSubjectRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public AccountingSubjectRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public AccountingSubjectRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public AccountingSubjectRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public AccountingSubjectRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public AccountingSubjectRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public AccountingSubjectRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest filterByAccountSet(AccountSetRequest accountSet) {
    return filterByAccountSet(accountSet, AccountSet::getId);
  }

  public AccountingSubjectRequest filterByAccountSet(AccountSet... accountSet) {
    if (isEmptyParam(accountSet)) {
      throw new IllegalArgumentException("filterByAccountSet(AccountSet... accountSet)参数不能为空!");
    }
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IN, (Object[]) accountSet);
  }

  public AccountingSubjectRequest selectAccountSetId() {
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

  public AccountingSubjectRequest filterByAccountSet(String... accountSet) {
    if (isEmptyParam(accountSet)) {
      throw new IllegalArgumentException("filterByAccountSet(String... accountSet)参数不能为空!");
    }
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IN, (Object[]) accountSet);
  }

  public AccountingSubjectRequest filterByAccountSet(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    accountSet.unlimited();
    return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
  }

  public SearchCriteria createAccountSetCriteria(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    return new RefinedIdInCriteria(
        accountSet, ACCOUNT_SET_PROPERTY, idRefine, AccountSet.ID_PROPERTY);
  }

  public AccountingSubjectRequest selectAccountSet() {
    return selectAccountSet(AccountSetRequest.newInstance().selectSelf());
  }

  public AccountingSubjectRequest selectAccountSet(AccountSetRequest accountSet) {
    selectParent(ACCOUNT_SET_PROPERTY, accountSet);
    return this;
  }

  public AccountingSubjectRequest unselectAccountSet() {
    unselectParent(ACCOUNT_SET_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest groupByAccountSet(AccountSetRequest accountSet) {
    groupBy(ACCOUNT_SET_PROPERTY, accountSet);
    return this;
  }

  public AccountingSubjectRequest aggregateAccountSet(AccountSetRequest accountSet) {
    aggregateParent(ACCOUNT_SET_PROPERTY, accountSet);
    return this;
  }

  public AccountingSubjectRequest countAccountSet() {
    return countAccountSet("countAccountSet");
  }

  public AccountingSubjectRequest countAccountSet(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNT_SET_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountSet() {
    return groupByAccountSet(ACCOUNT_SET_PROPERTY);
  }

  public AccountingSubjectRequest groupByAccountSet(String ret) {
    return groupBy(ret, ACCOUNT_SET_PROPERTY);
  }

  public AccountingSubjectRequest whereAccountSetIsNull() {
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingSubjectRequest whereAccountSetIsNotNull() {
    return where(ACCOUNT_SET_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingSubjectRequest hasAccountingDocumentLine() {
    return hasAccountingDocumentLine(AccountingDocumentLineRequest.newInstance());
  }

  public AccountingSubjectRequest hasAccountingDocumentLine(
      AccountingDocumentLine... accountingDocumentLine) {
    if (isEmptyParam(accountingDocumentLine)) {
      throw new IllegalArgumentException(
          "hasAccountingDocumentLine(AccountingDocumentLine... accountingDocumentLine)参数不能为空!");
    }
    return hasAccountingDocumentLine(
        Q.accountingDocumentLine()
            .select(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountingDocumentLine));
  }

  public AccountingSubjectRequest hasAccountingDocumentLine(String... accountingDocumentLine) {
    return hasAccountingDocumentLine(
        Q.accountingDocumentLine()
            .select(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY)
            .filterById(accountingDocumentLine));
  }

  public AccountingSubjectRequest hasAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine) {
    return hasAccountingDocumentLine(
        accountingDocumentLine,
        $accountingDocumentLine ->
            java.util.Optional.of($accountingDocumentLine)
                .map(AccountingDocumentLine::getAccountingSubject)
                .map(AccountingSubject::getId)
                .orElse(null));
  }

  public AccountingSubjectRequest hasAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine,
      IDRefine<AccountingDocumentLine> idRefine) {
    accountingDocumentLine.select(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY);
    accountingDocumentLine.unlimited();
    return addSearchCriteria(
        createAccountingDocumentLineCriteria(accountingDocumentLine, idRefine));
  }

  public AccountingSubjectRequest hasAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountingDocumentLine,
            AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createAccountingDocumentLineCriteria(
      AccountingDocumentLineRequest accountingDocumentLine,
      IDRefine<AccountingDocumentLine> idRefine) {
    return new RefinedIdInCriteria(
        accountingDocumentLine,
        ID_PROPERTY,
        idRefine,
        AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY);
  }

  public AccountingSubjectRequest selectAccountingDocumentLineList(
      AccountingDocumentLineRequest accountingDocumentLine) {
    selectChild(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingDocumentLine);
    return this;
  }

  public AccountingSubjectRequest selectAccountingDocumentLineList() {
    return selectAccountingDocumentLineList(
        AccountingDocumentLineRequest.newInstance().selectAll());
  }

  public AccountingSubjectRequest unselectAccountingDocumentLineList() {
    unselectChild(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, AccountingDocumentLine.class);
    return this;
  }

  public AccountingSubjectRequest aggregateAccountingDocumentLineList(
      AccountingDocumentLineRequest accountingDocumentLine) {
    aggregateChild(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingDocumentLine);
    return this;
  }

  public AccountingSubjectRequest countAccountingDocumentLine() {
    return countAccountingDocumentLine("accountingDocumentLineCount");
  }

  public AccountingSubjectRequest countAccountingDocumentLine(String retName) {
    return countAccountingDocumentLine(retName, AccountingDocumentLineRequest.newInstance());
  }

  public AccountingSubjectRequest countAccountingDocumentLine(
      AccountingDocumentLineRequest accountingDocumentLine) {
    return countAccountingDocumentLine("accountingDocumentLineCount", accountingDocumentLine);
  }

  public AccountingSubjectRequest countAccountingDocumentLine(
      String retName, AccountingDocumentLineRequest accountingDocumentLine) {
    accountingDocumentLine.count();
    return statsFromAccountingDocumentLine(retName, accountingDocumentLine);
  }

  public AccountingSubjectRequest statsFromAccountingDocumentLine(
      String retName, AccountingDocumentLineRequest accountingDocumentLine) {
    return addDynamicProperty(
        retName, accountingDocumentLine, AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY);
  }

  public AccountingSubjectRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public AccountingSubjectRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public AccountingSubjectRequest unlimited() {
    super.unlimited();
    return this;
  }

  public AccountingSubjectRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
