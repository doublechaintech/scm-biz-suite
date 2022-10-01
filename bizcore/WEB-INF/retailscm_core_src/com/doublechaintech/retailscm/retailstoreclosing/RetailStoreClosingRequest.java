package com.doublechaintech.retailscm.retailstoreclosing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing.*;

public class RetailStoreClosingRequest extends BaseRequest<RetailStoreClosing> {
  public static RetailStoreClosingRequest newInstance() {
    return new RetailStoreClosingRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreClosingRequest resultByClass(Class<? extends RetailStoreClosing> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreClosingRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreClosingRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreClosing";
  }

  public RetailStoreClosingRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreClosingRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreClosingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreClosingRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreClosingRequest selectAll() {
    return this.selectId().selectComment().selectVersion();
  }

  public RetailStoreClosingRequest selectAny() {
    return selectAll().selectRetailStoreList(Q.retailStore().selectSelf());
  }

  public RetailStoreClosingRequest selectSelf() {
    select(ID_PROPERTY);
    select(COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreClosingRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreClosingRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, COMMENT_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public RetailStoreClosingRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreClosingRequest comment(String comment) {
    return this;
  }

  public RetailStoreClosingRequest enhance() {
    return this;
  }

  public RetailStoreClosingRequest overrideClass(Class<? extends RetailStoreClosing> clazz) {
    return this;
  }

  public RetailStoreClosingRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreClosingRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreClosingRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreClosingRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreClosingRequest count() {
    return countId("count");
  }

  public static RetailStoreClosingRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreClosingRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreClosingRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreClosingRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreClosingRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreClosingRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreClosingRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreClosingRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreClosingRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreClosingRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreClosingRequest countId() {
    return countId("countId");
  }

  public RetailStoreClosingRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreClosingRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreClosingRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreClosingRequest minId() {
    return minId("minId");
  }

  public RetailStoreClosingRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreClosingRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreClosingRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreClosingRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreClosingRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreClosingRequest filterByComment(String comment) {

    if (comment == null) {
      return this;
    }

    return filterByComment(QueryOperator.EQUAL, comment);
  }

  public RetailStoreClosingRequest whereCommentIsNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreClosingRequest whereCommentIsNotNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreClosingRequest filterByComment(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreClosingRequest selectComment() {
    return select(COMMENT_PROPERTY);
  }

  public RetailStoreClosingRequest unselectComment() {
    return unselect(COMMENT_PROPERTY);
  }

  public SearchCriteria getCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreClosingRequest orderByComment(boolean asc) {
    addOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public RetailStoreClosingRequest orderByCommentAscending() {
    addOrderBy(COMMENT_PROPERTY, true);
    return this;
  }

  public RetailStoreClosingRequest orderByCommentDescending() {
    addOrderBy(COMMENT_PROPERTY, false);
    return this;
  }

  public RetailStoreClosingRequest orderByCommentAscendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", true);
    return this;
  }

  public RetailStoreClosingRequest orderByCommentDescendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", false);
    return this;
  }

  public RetailStoreClosingRequest countComment() {
    return countComment("countComment");
  }

  public RetailStoreClosingRequest countComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMMENT_PROPERTY);
  }

  public RetailStoreClosingRequest maxComment() {
    return maxComment("maxComment");
  }

  public RetailStoreClosingRequest maxComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMMENT_PROPERTY);
  }

  public RetailStoreClosingRequest minComment() {
    return minComment("minComment");
  }

  public RetailStoreClosingRequest minComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMMENT_PROPERTY);
  }

  public RetailStoreClosingRequest groupByComment() {
    return groupByComment(COMMENT_PROPERTY);
  }

  public RetailStoreClosingRequest groupByComment(String ret) {
    return groupBy(ret, COMMENT_PROPERTY);
  }

  public RetailStoreClosingRequest groupByComment(SqlFunction func) {
    return groupByComment(COMMENT_PROPERTY, func);
  }

  public RetailStoreClosingRequest groupByComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMMENT_PROPERTY);
    return this;
  }

  public RetailStoreClosingRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreClosingRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreClosingRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreClosingRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreClosingRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreClosingRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreClosingRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreClosingRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreClosingRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreClosingRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreClosingRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreClosingRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreClosingRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreClosingRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreClosingRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreClosingRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreClosingRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreClosingRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreClosingRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreClosingRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreClosingRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreClosingRequest hasRetailStore() {
    return hasRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreClosingRequest hasRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("hasRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.CLOSING_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStore));
  }

  public RetailStoreClosingRequest hasRetailStore(String... retailStore) {
    return hasRetailStore(
        Q.retailStore().select(RetailStore.CLOSING_PROPERTY).filterById(retailStore));
  }

  public RetailStoreClosingRequest hasRetailStore(RetailStoreRequest retailStore) {
    return hasRetailStore(
        retailStore,
        $retailStore ->
            java.util.Optional.of($retailStore)
                .map(RetailStore::getClosing)
                .map(RetailStoreClosing::getId)
                .orElse(null));
  }

  public RetailStoreClosingRequest hasRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.select(RetailStore.CLOSING_PROPERTY);
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public RetailStoreClosingRequest hasRetailStore(
      RetailStoreRequest retailStore, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(retailStore, RetailStore.CLOSING_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, ID_PROPERTY, idRefine, RetailStore.CLOSING_PROPERTY);
  }

  public RetailStoreClosingRequest selectRetailStoreList(RetailStoreRequest retailStore) {
    selectChild(RetailStore.CLOSING_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreClosingRequest selectRetailStoreList() {
    return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
  }

  public RetailStoreClosingRequest unselectRetailStoreList() {
    unselectChild(RetailStore.CLOSING_PROPERTY, RetailStore.class);
    return this;
  }

  public RetailStoreClosingRequest aggregateRetailStoreList(RetailStoreRequest retailStore) {
    aggregateChild(RetailStore.CLOSING_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreClosingRequest countRetailStore() {
    return countRetailStore("retailStoreCount");
  }

  public RetailStoreClosingRequest countRetailStore(String retName) {
    return countRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreClosingRequest countRetailStore(RetailStoreRequest retailStore) {
    return countRetailStore("retailStoreCount", retailStore);
  }

  public RetailStoreClosingRequest countRetailStore(
      String retName, RetailStoreRequest retailStore) {
    retailStore.count();
    return statsFromRetailStore(retName, retailStore);
  }

  public RetailStoreClosingRequest statsFromRetailStore(
      String retName, RetailStoreRequest retailStore) {
    return addDynamicProperty(retName, retailStore, RetailStore.CLOSING_PROPERTY);
  }

  public RetailStoreClosingRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreClosingRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreClosingRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreClosingRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
