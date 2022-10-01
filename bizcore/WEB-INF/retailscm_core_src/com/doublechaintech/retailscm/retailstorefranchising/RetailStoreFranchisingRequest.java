package com.doublechaintech.retailscm.retailstorefranchising;

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
import static com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising.*;

public class RetailStoreFranchisingRequest extends BaseRequest<RetailStoreFranchising> {
  public static RetailStoreFranchisingRequest newInstance() {
    return new RetailStoreFranchisingRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreFranchisingRequest resultByClass(
      Class<? extends RetailStoreFranchising> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreFranchisingRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreFranchisingRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreFranchising";
  }

  public RetailStoreFranchisingRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreFranchisingRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreFranchisingRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreFranchisingRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreFranchisingRequest selectAll() {
    return this.selectId().selectComment().selectVersion();
  }

  public RetailStoreFranchisingRequest selectAny() {
    return selectAll().selectRetailStoreList(Q.retailStore().selectSelf());
  }

  public RetailStoreFranchisingRequest selectSelf() {
    select(ID_PROPERTY);
    select(COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreFranchisingRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreFranchisingRequest where(
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

  public RetailStoreFranchisingRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreFranchisingRequest comment(String comment) {
    return this;
  }

  public RetailStoreFranchisingRequest enhance() {
    return this;
  }

  public RetailStoreFranchisingRequest overrideClass(
      Class<? extends RetailStoreFranchising> clazz) {
    return this;
  }

  public RetailStoreFranchisingRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreFranchisingRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreFranchisingRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreFranchisingRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreFranchisingRequest count() {
    return countId("count");
  }

  public static RetailStoreFranchisingRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreFranchisingRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreFranchisingRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreFranchisingRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreFranchisingRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreFranchisingRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreFranchisingRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreFranchisingRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreFranchisingRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreFranchisingRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreFranchisingRequest countId() {
    return countId("countId");
  }

  public RetailStoreFranchisingRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreFranchisingRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreFranchisingRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreFranchisingRequest minId() {
    return minId("minId");
  }

  public RetailStoreFranchisingRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreFranchisingRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreFranchisingRequest filterByComment(String comment) {

    if (comment == null) {
      return this;
    }

    return filterByComment(QueryOperator.EQUAL, comment);
  }

  public RetailStoreFranchisingRequest whereCommentIsNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreFranchisingRequest whereCommentIsNotNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreFranchisingRequest filterByComment(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreFranchisingRequest selectComment() {
    return select(COMMENT_PROPERTY);
  }

  public RetailStoreFranchisingRequest unselectComment() {
    return unselect(COMMENT_PROPERTY);
  }

  public SearchCriteria getCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreFranchisingRequest orderByComment(boolean asc) {
    addOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public RetailStoreFranchisingRequest orderByCommentAscending() {
    addOrderBy(COMMENT_PROPERTY, true);
    return this;
  }

  public RetailStoreFranchisingRequest orderByCommentDescending() {
    addOrderBy(COMMENT_PROPERTY, false);
    return this;
  }

  public RetailStoreFranchisingRequest orderByCommentAscendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", true);
    return this;
  }

  public RetailStoreFranchisingRequest orderByCommentDescendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", false);
    return this;
  }

  public RetailStoreFranchisingRequest countComment() {
    return countComment("countComment");
  }

  public RetailStoreFranchisingRequest countComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMMENT_PROPERTY);
  }

  public RetailStoreFranchisingRequest maxComment() {
    return maxComment("maxComment");
  }

  public RetailStoreFranchisingRequest maxComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMMENT_PROPERTY);
  }

  public RetailStoreFranchisingRequest minComment() {
    return minComment("minComment");
  }

  public RetailStoreFranchisingRequest minComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMMENT_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupByComment() {
    return groupByComment(COMMENT_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupByComment(String ret) {
    return groupBy(ret, COMMENT_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupByComment(SqlFunction func) {
    return groupByComment(COMMENT_PROPERTY, func);
  }

  public RetailStoreFranchisingRequest groupByComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMMENT_PROPERTY);
    return this;
  }

  public RetailStoreFranchisingRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreFranchisingRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreFranchisingRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreFranchisingRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreFranchisingRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreFranchisingRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreFranchisingRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreFranchisingRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreFranchisingRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreFranchisingRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreFranchisingRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreFranchisingRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreFranchisingRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreFranchisingRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreFranchisingRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreFranchisingRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreFranchisingRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreFranchisingRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreFranchisingRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreFranchisingRequest hasRetailStore() {
    return hasRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreFranchisingRequest hasRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("hasRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.FRANCHISING_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStore));
  }

  public RetailStoreFranchisingRequest hasRetailStore(String... retailStore) {
    return hasRetailStore(
        Q.retailStore().select(RetailStore.FRANCHISING_PROPERTY).filterById(retailStore));
  }

  public RetailStoreFranchisingRequest hasRetailStore(RetailStoreRequest retailStore) {
    return hasRetailStore(
        retailStore,
        $retailStore ->
            java.util.Optional.of($retailStore)
                .map(RetailStore::getFranchising)
                .map(RetailStoreFranchising::getId)
                .orElse(null));
  }

  public RetailStoreFranchisingRequest hasRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.select(RetailStore.FRANCHISING_PROPERTY);
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public RetailStoreFranchisingRequest hasRetailStore(
      RetailStoreRequest retailStore, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStore, RetailStore.FRANCHISING_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, ID_PROPERTY, idRefine, RetailStore.FRANCHISING_PROPERTY);
  }

  public RetailStoreFranchisingRequest selectRetailStoreList(RetailStoreRequest retailStore) {
    selectChild(RetailStore.FRANCHISING_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreFranchisingRequest selectRetailStoreList() {
    return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
  }

  public RetailStoreFranchisingRequest unselectRetailStoreList() {
    unselectChild(RetailStore.FRANCHISING_PROPERTY, RetailStore.class);
    return this;
  }

  public RetailStoreFranchisingRequest aggregateRetailStoreList(RetailStoreRequest retailStore) {
    aggregateChild(RetailStore.FRANCHISING_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreFranchisingRequest countRetailStore() {
    return countRetailStore("retailStoreCount");
  }

  public RetailStoreFranchisingRequest countRetailStore(String retName) {
    return countRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreFranchisingRequest countRetailStore(RetailStoreRequest retailStore) {
    return countRetailStore("retailStoreCount", retailStore);
  }

  public RetailStoreFranchisingRequest countRetailStore(
      String retName, RetailStoreRequest retailStore) {
    retailStore.count();
    return statsFromRetailStore(retName, retailStore);
  }

  public RetailStoreFranchisingRequest statsFromRetailStore(
      String retName, RetailStoreRequest retailStore) {
    return addDynamicProperty(retName, retailStore, RetailStore.FRANCHISING_PROPERTY);
  }

  public RetailStoreFranchisingRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreFranchisingRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreFranchisingRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreFranchisingRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
