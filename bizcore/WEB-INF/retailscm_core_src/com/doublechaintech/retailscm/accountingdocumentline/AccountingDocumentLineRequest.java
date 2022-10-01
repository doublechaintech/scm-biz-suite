package com.doublechaintech.retailscm.accountingdocumentline;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine.*;

public class AccountingDocumentLineRequest extends BaseRequest<AccountingDocumentLine> {
  public static AccountingDocumentLineRequest newInstance() {
    return new AccountingDocumentLineRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public AccountingDocumentLineRequest resultByClass(
      Class<? extends AccountingDocumentLine> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public AccountingDocumentLineRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public AccountingDocumentLineRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "AccountingDocumentLine";
  }

  public AccountingDocumentLineRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public AccountingDocumentLineRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public AccountingDocumentLineRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public AccountingDocumentLineRequest select(String... names) {
    super.select(names);
    return this;
  }

  public AccountingDocumentLineRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectCode()
        .selectDirect()
        .selectAmount()
        .selectBelongsTo()
        .selectAccountingSubject()
        .selectVersion();
  }

  public AccountingDocumentLineRequest selectAny() {
    return selectAll();
  }

  public AccountingDocumentLineRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(CODE_PROPERTY);
    select(DIRECT_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(ACCOUNTING_SUBJECT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public AccountingDocumentLineRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public AccountingDocumentLineRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    CODE_PROPERTY,
    DIRECT_PROPERTY,
    AMOUNT_PROPERTY,
    BELONGS_TO_PROPERTY,
    ACCOUNTING_SUBJECT_PROPERTY,
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

  public AccountingDocumentLineRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public AccountingDocumentLineRequest comment(String comment) {
    return this;
  }

  public AccountingDocumentLineRequest enhance() {
    return this;
  }

  public AccountingDocumentLineRequest overrideClass(
      Class<? extends AccountingDocumentLine> clazz) {
    return this;
  }

  public AccountingDocumentLineRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public AccountingDocumentLineRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public AccountingDocumentLineRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public AccountingDocumentLineRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public AccountingDocumentLineRequest count() {
    return countId("count");
  }

  public static AccountingDocumentLineRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public AccountingDocumentLineRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public AccountingDocumentLineRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest selectId() {
    return select(ID_PROPERTY);
  }

  public AccountingDocumentLineRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentLineRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentLineRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public AccountingDocumentLineRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public AccountingDocumentLineRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public AccountingDocumentLineRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public AccountingDocumentLineRequest countId() {
    return countId("countId");
  }

  public AccountingDocumentLineRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public AccountingDocumentLineRequest maxId() {
    return maxId("maxId");
  }

  public AccountingDocumentLineRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public AccountingDocumentLineRequest minId() {
    return minId("minId");
  }

  public AccountingDocumentLineRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public AccountingDocumentLineRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public AccountingDocumentLineRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public AccountingDocumentLineRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public AccountingDocumentLineRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public AccountingDocumentLineRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentLineRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentLineRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public AccountingDocumentLineRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentLineRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentLineRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public AccountingDocumentLineRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public AccountingDocumentLineRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public AccountingDocumentLineRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public AccountingDocumentLineRequest countName() {
    return countName("countName");
  }

  public AccountingDocumentLineRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public AccountingDocumentLineRequest maxName() {
    return maxName("maxName");
  }

  public AccountingDocumentLineRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public AccountingDocumentLineRequest minName() {
    return minName("minName");
  }

  public AccountingDocumentLineRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public AccountingDocumentLineRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public AccountingDocumentLineRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentLineRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentLineRequest filterByCode(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public AccountingDocumentLineRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentLineRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentLineRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public AccountingDocumentLineRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public AccountingDocumentLineRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public AccountingDocumentLineRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public AccountingDocumentLineRequest countCode() {
    return countCode("countCode");
  }

  public AccountingDocumentLineRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public AccountingDocumentLineRequest maxCode() {
    return maxCode("maxCode");
  }

  public AccountingDocumentLineRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public AccountingDocumentLineRequest minCode() {
    return minCode("minCode");
  }

  public AccountingDocumentLineRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public AccountingDocumentLineRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest filterByDirect(String direct) {

    if (direct == null) {
      return this;
    }

    return filterByDirect(QueryOperator.EQUAL, direct);
  }

  public AccountingDocumentLineRequest whereDirectIsNull() {
    return where(DIRECT_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentLineRequest whereDirectIsNotNull() {
    return where(DIRECT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentLineRequest filterByDirect(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDirectSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest selectDirect() {
    return select(DIRECT_PROPERTY);
  }

  public AccountingDocumentLineRequest unselectDirect() {
    return unselect(DIRECT_PROPERTY);
  }

  public SearchCriteria getDirectSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DIRECT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentLineRequest orderByDirect(boolean asc) {
    addOrderBy(DIRECT_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentLineRequest orderByDirectAscending() {
    addOrderBy(DIRECT_PROPERTY, true);
    return this;
  }

  public AccountingDocumentLineRequest orderByDirectDescending() {
    addOrderBy(DIRECT_PROPERTY, false);
    return this;
  }

  public AccountingDocumentLineRequest orderByDirectAscendingUsingGBK() {
    addOrderBy("convert(direct using gbk)", true);
    return this;
  }

  public AccountingDocumentLineRequest orderByDirectDescendingUsingGBK() {
    addOrderBy("convert(direct using gbk)", false);
    return this;
  }

  public AccountingDocumentLineRequest countDirect() {
    return countDirect("countDirect");
  }

  public AccountingDocumentLineRequest countDirect(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DIRECT_PROPERTY);
  }

  public AccountingDocumentLineRequest maxDirect() {
    return maxDirect("maxDirect");
  }

  public AccountingDocumentLineRequest maxDirect(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DIRECT_PROPERTY);
  }

  public AccountingDocumentLineRequest minDirect() {
    return minDirect("minDirect");
  }

  public AccountingDocumentLineRequest minDirect(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DIRECT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByDirect() {
    return groupByDirect(DIRECT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByDirect(String ret) {
    return groupBy(ret, DIRECT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByDirect(SqlFunction func) {
    return groupByDirect(DIRECT_PROPERTY, func);
  }

  public AccountingDocumentLineRequest groupByDirect(String ret, SqlFunction func) {
    super.groupBy(ret, func, DIRECT_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public AccountingDocumentLineRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentLineRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentLineRequest whereAmountBetween(
      BigDecimal amountStart, BigDecimal amountEnd) {
    if (ObjectUtil.isEmpty(amountStart)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(amountEnd)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.BETWEEN, new Object[] {amountStart, amountEnd});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public AccountingDocumentLineRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentLineRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentLineRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public AccountingDocumentLineRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public AccountingDocumentLineRequest countAmount() {
    return countAmount("countAmount");
  }

  public AccountingDocumentLineRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public AccountingDocumentLineRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public AccountingDocumentLineRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public AccountingDocumentLineRequest minAmount() {
    return minAmount("minAmount");
  }

  public AccountingDocumentLineRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public AccountingDocumentLineRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public AccountingDocumentLineRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public AccountingDocumentLineRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public AccountingDocumentLineRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentLineRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentLineRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentLineRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public AccountingDocumentLineRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentLineRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentLineRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public AccountingDocumentLineRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public AccountingDocumentLineRequest countVersion() {
    return countVersion("countVersion");
  }

  public AccountingDocumentLineRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public AccountingDocumentLineRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public AccountingDocumentLineRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public AccountingDocumentLineRequest minVersion() {
    return minVersion("minVersion");
  }

  public AccountingDocumentLineRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public AccountingDocumentLineRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public AccountingDocumentLineRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public AccountingDocumentLineRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest filterByBelongsTo(AccountingDocumentRequest belongsTo) {
    return filterByBelongsTo(belongsTo, AccountingDocument::getId);
  }

  public AccountingDocumentLineRequest filterByBelongsTo(AccountingDocument... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException(
          "filterByBelongsTo(AccountingDocument... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public AccountingDocumentLineRequest selectBelongsToId() {
    select(BELONGS_TO_PROPERTY);
    return this;
  }

  public AccountingDocumentRequest upToBelongsTo() {
    return upToBelongsTo(AccountingDocumentRequest.newInstance());
  }

  public AccountingDocumentRequest upToBelongsTo(AccountingDocumentRequest belongsTo) {
    belongsTo.aggregateChild(BELONGS_TO_PROPERTY, this);
    this.groupByBelongsTo(belongsTo);
    return belongsTo;
  }

  public AccountingDocumentRequest endAtBelongsTo(String retName) {
    return endAtBelongsTo(retName, AccountingDocumentRequest.newInstance());
  }

  public AccountingDocumentRequest endAtBelongsTo(
      String retName, AccountingDocumentRequest belongsTo) {
    belongsTo.addDynamicProperty(retName, this, BELONGS_TO_PROPERTY);
    return belongsTo;
  }

  public AccountingDocumentLineRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public AccountingDocumentLineRequest filterByBelongsTo(
      AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, AccountingDocument.ID_PROPERTY);
  }

  public AccountingDocumentLineRequest selectBelongsTo() {
    return selectBelongsTo(AccountingDocumentRequest.newInstance().selectSelf());
  }

  public AccountingDocumentLineRequest selectBelongsTo(AccountingDocumentRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public AccountingDocumentLineRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest groupByBelongsTo(AccountingDocumentRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public AccountingDocumentLineRequest aggregateBelongsTo(AccountingDocumentRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public AccountingDocumentLineRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public AccountingDocumentLineRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public AccountingDocumentLineRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentLineRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentLineRequest filterByAccountingSubject(
      AccountingSubjectRequest accountingSubject) {
    return filterByAccountingSubject(accountingSubject, AccountingSubject::getId);
  }

  public AccountingDocumentLineRequest filterByAccountingSubject(
      AccountingSubject... accountingSubject) {
    if (isEmptyParam(accountingSubject)) {
      throw new IllegalArgumentException(
          "filterByAccountingSubject(AccountingSubject... accountingSubject)参数不能为空!");
    }
    return where(ACCOUNTING_SUBJECT_PROPERTY, QueryOperator.IN, (Object[]) accountingSubject);
  }

  public AccountingDocumentLineRequest selectAccountingSubjectId() {
    select(ACCOUNTING_SUBJECT_PROPERTY);
    return this;
  }

  public AccountingSubjectRequest upToAccountingSubject() {
    return upToAccountingSubject(AccountingSubjectRequest.newInstance());
  }

  public AccountingSubjectRequest upToAccountingSubject(
      AccountingSubjectRequest accountingSubject) {
    accountingSubject.aggregateChild(ACCOUNTING_SUBJECT_PROPERTY, this);
    this.groupByAccountingSubject(accountingSubject);
    return accountingSubject;
  }

  public AccountingSubjectRequest endAtAccountingSubject(String retName) {
    return endAtAccountingSubject(retName, AccountingSubjectRequest.newInstance());
  }

  public AccountingSubjectRequest endAtAccountingSubject(
      String retName, AccountingSubjectRequest accountingSubject) {
    accountingSubject.addDynamicProperty(retName, this, ACCOUNTING_SUBJECT_PROPERTY);
    return accountingSubject;
  }

  public AccountingDocumentLineRequest filterByAccountingSubject(String... accountingSubject) {
    if (isEmptyParam(accountingSubject)) {
      throw new IllegalArgumentException(
          "filterByAccountingSubject(String... accountingSubject)参数不能为空!");
    }
    return where(ACCOUNTING_SUBJECT_PROPERTY, QueryOperator.IN, (Object[]) accountingSubject);
  }

  public AccountingDocumentLineRequest filterByAccountingSubject(
      AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine) {
    accountingSubject.unlimited();
    return addSearchCriteria(createAccountingSubjectCriteria(accountingSubject, idRefine));
  }

  public SearchCriteria createAccountingSubjectCriteria(
      AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine) {
    return new RefinedIdInCriteria(
        accountingSubject, ACCOUNTING_SUBJECT_PROPERTY, idRefine, AccountingSubject.ID_PROPERTY);
  }

  public AccountingDocumentLineRequest selectAccountingSubject() {
    return selectAccountingSubject(AccountingSubjectRequest.newInstance().selectSelf());
  }

  public AccountingDocumentLineRequest selectAccountingSubject(
      AccountingSubjectRequest accountingSubject) {
    selectParent(ACCOUNTING_SUBJECT_PROPERTY, accountingSubject);
    return this;
  }

  public AccountingDocumentLineRequest unselectAccountingSubject() {
    unselectParent(ACCOUNTING_SUBJECT_PROPERTY);
    return this;
  }

  public AccountingDocumentLineRequest groupByAccountingSubject(
      AccountingSubjectRequest accountingSubject) {
    groupBy(ACCOUNTING_SUBJECT_PROPERTY, accountingSubject);
    return this;
  }

  public AccountingDocumentLineRequest aggregateAccountingSubject(
      AccountingSubjectRequest accountingSubject) {
    aggregateParent(ACCOUNTING_SUBJECT_PROPERTY, accountingSubject);
    return this;
  }

  public AccountingDocumentLineRequest countAccountingSubject() {
    return countAccountingSubject("countAccountingSubject");
  }

  public AccountingDocumentLineRequest countAccountingSubject(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_SUBJECT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByAccountingSubject() {
    return groupByAccountingSubject(ACCOUNTING_SUBJECT_PROPERTY);
  }

  public AccountingDocumentLineRequest groupByAccountingSubject(String ret) {
    return groupBy(ret, ACCOUNTING_SUBJECT_PROPERTY);
  }

  public AccountingDocumentLineRequest whereAccountingSubjectIsNull() {
    return where(ACCOUNTING_SUBJECT_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentLineRequest whereAccountingSubjectIsNotNull() {
    return where(ACCOUNTING_SUBJECT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentLineRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public AccountingDocumentLineRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public AccountingDocumentLineRequest unlimited() {
    super.unlimited();
    return this;
  }

  public AccountingDocumentLineRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
