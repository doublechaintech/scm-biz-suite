package com.doublechaintech.retailscm.accountingdocumenttype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType.*;

public class AccountingDocumentTypeRequest extends BaseRequest<AccountingDocumentType> {
  public static AccountingDocumentTypeRequest newInstance() {
    return new AccountingDocumentTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public AccountingDocumentTypeRequest resultByClass(
      Class<? extends AccountingDocumentType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public AccountingDocumentTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public AccountingDocumentTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "AccountingDocumentType";
  }

  public AccountingDocumentTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public AccountingDocumentTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public AccountingDocumentTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public AccountingDocumentTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public AccountingDocumentTypeRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectDescription()
        .selectAccountingPeriod()
        .selectVersion();
  }

  public AccountingDocumentTypeRequest selectAny() {
    return selectAll().selectAccountingDocumentList(Q.accountingDocument().selectSelf());
  }

  public AccountingDocumentTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(ACCOUNTING_PERIOD_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public AccountingDocumentTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public AccountingDocumentTypeRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, DESCRIPTION_PROPERTY, ACCOUNTING_PERIOD_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public AccountingDocumentTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public AccountingDocumentTypeRequest comment(String comment) {
    return this;
  }

  public AccountingDocumentTypeRequest enhance() {
    return this;
  }

  public AccountingDocumentTypeRequest overrideClass(
      Class<? extends AccountingDocumentType> clazz) {
    return this;
  }

  public AccountingDocumentTypeRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public AccountingDocumentTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public AccountingDocumentTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public AccountingDocumentTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public AccountingDocumentTypeRequest count() {
    return countId("count");
  }

  public static AccountingDocumentTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public AccountingDocumentTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public AccountingDocumentTypeRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public AccountingDocumentTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public AccountingDocumentTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public AccountingDocumentTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public AccountingDocumentTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public AccountingDocumentTypeRequest countId() {
    return countId("countId");
  }

  public AccountingDocumentTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public AccountingDocumentTypeRequest maxId() {
    return maxId("maxId");
  }

  public AccountingDocumentTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public AccountingDocumentTypeRequest minId() {
    return minId("minId");
  }

  public AccountingDocumentTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public AccountingDocumentTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public AccountingDocumentTypeRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public AccountingDocumentTypeRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentTypeRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentTypeRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentTypeRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public AccountingDocumentTypeRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentTypeRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentTypeRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public AccountingDocumentTypeRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public AccountingDocumentTypeRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public AccountingDocumentTypeRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public AccountingDocumentTypeRequest countName() {
    return countName("countName");
  }

  public AccountingDocumentTypeRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public AccountingDocumentTypeRequest maxName() {
    return maxName("maxName");
  }

  public AccountingDocumentTypeRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public AccountingDocumentTypeRequest minName() {
    return minName("minName");
  }

  public AccountingDocumentTypeRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public AccountingDocumentTypeRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public AccountingDocumentTypeRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public AccountingDocumentTypeRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentTypeRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentTypeRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentTypeRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public AccountingDocumentTypeRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentTypeRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentTypeRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public AccountingDocumentTypeRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public AccountingDocumentTypeRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public AccountingDocumentTypeRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public AccountingDocumentTypeRequest countDescription() {
    return countDescription("countDescription");
  }

  public AccountingDocumentTypeRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public AccountingDocumentTypeRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public AccountingDocumentTypeRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public AccountingDocumentTypeRequest minDescription() {
    return minDescription("minDescription");
  }

  public AccountingDocumentTypeRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public AccountingDocumentTypeRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public AccountingDocumentTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public AccountingDocumentTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentTypeRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public AccountingDocumentTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public AccountingDocumentTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public AccountingDocumentTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public AccountingDocumentTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public AccountingDocumentTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public AccountingDocumentTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public AccountingDocumentTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public AccountingDocumentTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public AccountingDocumentTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public AccountingDocumentTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public AccountingDocumentTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public AccountingDocumentTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public AccountingDocumentTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public AccountingDocumentTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public AccountingDocumentTypeRequest filterByAccountingPeriod(
      AccountSetRequest accountingPeriod) {
    return filterByAccountingPeriod(accountingPeriod, AccountSet::getId);
  }

  public AccountingDocumentTypeRequest filterByAccountingPeriod(AccountSet... accountingPeriod) {
    if (isEmptyParam(accountingPeriod)) {
      throw new IllegalArgumentException(
          "filterByAccountingPeriod(AccountSet... accountingPeriod)参数不能为空!");
    }
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IN, (Object[]) accountingPeriod);
  }

  public AccountingDocumentTypeRequest selectAccountingPeriodId() {
    select(ACCOUNTING_PERIOD_PROPERTY);
    return this;
  }

  public AccountSetRequest upToAccountingPeriod() {
    return upToAccountingPeriod(AccountSetRequest.newInstance());
  }

  public AccountSetRequest upToAccountingPeriod(AccountSetRequest accountingPeriod) {
    accountingPeriod.aggregateChild(ACCOUNTING_PERIOD_PROPERTY, this);
    this.groupByAccountingPeriod(accountingPeriod);
    return accountingPeriod;
  }

  public AccountSetRequest endAtAccountingPeriod(String retName) {
    return endAtAccountingPeriod(retName, AccountSetRequest.newInstance());
  }

  public AccountSetRequest endAtAccountingPeriod(
      String retName, AccountSetRequest accountingPeriod) {
    accountingPeriod.addDynamicProperty(retName, this, ACCOUNTING_PERIOD_PROPERTY);
    return accountingPeriod;
  }

  public AccountingDocumentTypeRequest filterByAccountingPeriod(String... accountingPeriod) {
    if (isEmptyParam(accountingPeriod)) {
      throw new IllegalArgumentException(
          "filterByAccountingPeriod(String... accountingPeriod)参数不能为空!");
    }
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IN, (Object[]) accountingPeriod);
  }

  public AccountingDocumentTypeRequest filterByAccountingPeriod(
      AccountSetRequest accountingPeriod, IDRefine<AccountSet> idRefine) {
    accountingPeriod.unlimited();
    return addSearchCriteria(createAccountingPeriodCriteria(accountingPeriod, idRefine));
  }

  public SearchCriteria createAccountingPeriodCriteria(
      AccountSetRequest accountingPeriod, IDRefine<AccountSet> idRefine) {
    return new RefinedIdInCriteria(
        accountingPeriod, ACCOUNTING_PERIOD_PROPERTY, idRefine, AccountSet.ID_PROPERTY);
  }

  public AccountingDocumentTypeRequest selectAccountingPeriod() {
    return selectAccountingPeriod(AccountSetRequest.newInstance().selectSelf());
  }

  public AccountingDocumentTypeRequest selectAccountingPeriod(AccountSetRequest accountingPeriod) {
    selectParent(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountingDocumentTypeRequest unselectAccountingPeriod() {
    unselectParent(ACCOUNTING_PERIOD_PROPERTY);
    return this;
  }

  public AccountingDocumentTypeRequest groupByAccountingPeriod(AccountSetRequest accountingPeriod) {
    groupBy(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountingDocumentTypeRequest aggregateAccountingPeriod(
      AccountSetRequest accountingPeriod) {
    aggregateParent(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
    return this;
  }

  public AccountingDocumentTypeRequest countAccountingPeriod() {
    return countAccountingPeriod("countAccountingPeriod");
  }

  public AccountingDocumentTypeRequest countAccountingPeriod(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByAccountingPeriod() {
    return groupByAccountingPeriod(ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingDocumentTypeRequest groupByAccountingPeriod(String ret) {
    return groupBy(ret, ACCOUNTING_PERIOD_PROPERTY);
  }

  public AccountingDocumentTypeRequest whereAccountingPeriodIsNull() {
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IS_NULL);
  }

  public AccountingDocumentTypeRequest whereAccountingPeriodIsNotNull() {
    return where(ACCOUNTING_PERIOD_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public AccountingDocumentTypeRequest hasAccountingDocument() {
    return hasAccountingDocument(AccountingDocumentRequest.newInstance());
  }

  public AccountingDocumentTypeRequest hasAccountingDocument(
      AccountingDocument... accountingDocument) {
    if (isEmptyParam(accountingDocument)) {
      throw new IllegalArgumentException(
          "hasAccountingDocument(AccountingDocument... accountingDocument)参数不能为空!");
    }
    return hasAccountingDocument(
        Q.accountingDocument()
            .select(AccountingDocument.DOCUMENT_TYPE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountingDocument));
  }

  public AccountingDocumentTypeRequest hasAccountingDocument(String... accountingDocument) {
    return hasAccountingDocument(
        Q.accountingDocument()
            .select(AccountingDocument.DOCUMENT_TYPE_PROPERTY)
            .filterById(accountingDocument));
  }

  public AccountingDocumentTypeRequest hasAccountingDocument(
      AccountingDocumentRequest accountingDocument) {
    return hasAccountingDocument(
        accountingDocument,
        $accountingDocument ->
            java.util.Optional.of($accountingDocument)
                .map(AccountingDocument::getDocumentType)
                .map(AccountingDocumentType::getId)
                .orElse(null));
  }

  public AccountingDocumentTypeRequest hasAccountingDocument(
      AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine) {
    accountingDocument.select(AccountingDocument.DOCUMENT_TYPE_PROPERTY);
    accountingDocument.unlimited();
    return addSearchCriteria(createAccountingDocumentCriteria(accountingDocument, idRefine));
  }

  public AccountingDocumentTypeRequest hasAccountingDocument(
      AccountingDocumentRequest accountingDocument, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountingDocument, AccountingDocument.DOCUMENT_TYPE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createAccountingDocumentCriteria(
      AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine) {
    return new RefinedIdInCriteria(
        accountingDocument, ID_PROPERTY, idRefine, AccountingDocument.DOCUMENT_TYPE_PROPERTY);
  }

  public AccountingDocumentTypeRequest selectAccountingDocumentList(
      AccountingDocumentRequest accountingDocument) {
    selectChild(AccountingDocument.DOCUMENT_TYPE_PROPERTY, accountingDocument);
    return this;
  }

  public AccountingDocumentTypeRequest selectAccountingDocumentList() {
    return selectAccountingDocumentList(AccountingDocumentRequest.newInstance().selectAll());
  }

  public AccountingDocumentTypeRequest unselectAccountingDocumentList() {
    unselectChild(AccountingDocument.DOCUMENT_TYPE_PROPERTY, AccountingDocument.class);
    return this;
  }

  public AccountingDocumentTypeRequest aggregateAccountingDocumentList(
      AccountingDocumentRequest accountingDocument) {
    aggregateChild(AccountingDocument.DOCUMENT_TYPE_PROPERTY, accountingDocument);
    return this;
  }

  public AccountingDocumentTypeRequest countAccountingDocument() {
    return countAccountingDocument("accountingDocumentCount");
  }

  public AccountingDocumentTypeRequest countAccountingDocument(String retName) {
    return countAccountingDocument(retName, AccountingDocumentRequest.newInstance());
  }

  public AccountingDocumentTypeRequest countAccountingDocument(
      AccountingDocumentRequest accountingDocument) {
    return countAccountingDocument("accountingDocumentCount", accountingDocument);
  }

  public AccountingDocumentTypeRequest countAccountingDocument(
      String retName, AccountingDocumentRequest accountingDocument) {
    accountingDocument.count();
    return statsFromAccountingDocument(retName, accountingDocument);
  }

  public AccountingDocumentTypeRequest statsFromAccountingDocument(
      String retName, AccountingDocumentRequest accountingDocument) {
    return addDynamicProperty(
        retName, accountingDocument, AccountingDocument.DOCUMENT_TYPE_PROPERTY);
  }

  public AccountingDocumentTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public AccountingDocumentTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public AccountingDocumentTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public AccountingDocumentTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
