package com.doublechaintech.retailscm.retailstoreopening;

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
import static com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening.*;

public class RetailStoreOpeningRequest extends BaseRequest<RetailStoreOpening> {
  public static RetailStoreOpeningRequest newInstance() {
    return new RetailStoreOpeningRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreOpeningRequest resultByClass(Class<? extends RetailStoreOpening> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreOpeningRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreOpeningRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreOpening";
  }

  public RetailStoreOpeningRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreOpeningRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreOpeningRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreOpeningRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreOpeningRequest selectAll() {
    return this.selectId().selectComment().selectVersion();
  }

  public RetailStoreOpeningRequest selectAny() {
    return selectAll().selectRetailStoreList(Q.retailStore().selectSelf());
  }

  public RetailStoreOpeningRequest selectSelf() {
    select(ID_PROPERTY);
    select(COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreOpeningRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreOpeningRequest where(
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

  public RetailStoreOpeningRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreOpeningRequest comment(String comment) {
    return this;
  }

  public RetailStoreOpeningRequest enhance() {
    return this;
  }

  public RetailStoreOpeningRequest overrideClass(Class<? extends RetailStoreOpening> clazz) {
    return this;
  }

  public RetailStoreOpeningRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreOpeningRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreOpeningRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreOpeningRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreOpeningRequest count() {
    return countId("count");
  }

  public static RetailStoreOpeningRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreOpeningRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreOpeningRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOpeningRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreOpeningRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOpeningRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreOpeningRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreOpeningRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreOpeningRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreOpeningRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreOpeningRequest countId() {
    return countId("countId");
  }

  public RetailStoreOpeningRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreOpeningRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreOpeningRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreOpeningRequest minId() {
    return minId("minId");
  }

  public RetailStoreOpeningRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreOpeningRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreOpeningRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreOpeningRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreOpeningRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreOpeningRequest filterByComment(String comment) {

    if (comment == null) {
      return this;
    }

    return filterByComment(QueryOperator.EQUAL, comment);
  }

  public RetailStoreOpeningRequest whereCommentIsNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOpeningRequest whereCommentIsNotNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOpeningRequest filterByComment(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOpeningRequest selectComment() {
    return select(COMMENT_PROPERTY);
  }

  public RetailStoreOpeningRequest unselectComment() {
    return unselect(COMMENT_PROPERTY);
  }

  public SearchCriteria getCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOpeningRequest orderByComment(boolean asc) {
    addOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public RetailStoreOpeningRequest orderByCommentAscending() {
    addOrderBy(COMMENT_PROPERTY, true);
    return this;
  }

  public RetailStoreOpeningRequest orderByCommentDescending() {
    addOrderBy(COMMENT_PROPERTY, false);
    return this;
  }

  public RetailStoreOpeningRequest orderByCommentAscendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", true);
    return this;
  }

  public RetailStoreOpeningRequest orderByCommentDescendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", false);
    return this;
  }

  public RetailStoreOpeningRequest countComment() {
    return countComment("countComment");
  }

  public RetailStoreOpeningRequest countComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMMENT_PROPERTY);
  }

  public RetailStoreOpeningRequest maxComment() {
    return maxComment("maxComment");
  }

  public RetailStoreOpeningRequest maxComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMMENT_PROPERTY);
  }

  public RetailStoreOpeningRequest minComment() {
    return minComment("minComment");
  }

  public RetailStoreOpeningRequest minComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMMENT_PROPERTY);
  }

  public RetailStoreOpeningRequest groupByComment() {
    return groupByComment(COMMENT_PROPERTY);
  }

  public RetailStoreOpeningRequest groupByComment(String ret) {
    return groupBy(ret, COMMENT_PROPERTY);
  }

  public RetailStoreOpeningRequest groupByComment(SqlFunction func) {
    return groupByComment(COMMENT_PROPERTY, func);
  }

  public RetailStoreOpeningRequest groupByComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMMENT_PROPERTY);
    return this;
  }

  public RetailStoreOpeningRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreOpeningRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOpeningRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOpeningRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOpeningRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreOpeningRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOpeningRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreOpeningRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreOpeningRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreOpeningRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreOpeningRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreOpeningRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreOpeningRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreOpeningRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreOpeningRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreOpeningRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreOpeningRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreOpeningRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreOpeningRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreOpeningRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreOpeningRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreOpeningRequest hasRetailStore() {
    return hasRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreOpeningRequest hasRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("hasRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.OPENING_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStore));
  }

  public RetailStoreOpeningRequest hasRetailStore(String... retailStore) {
    return hasRetailStore(
        Q.retailStore().select(RetailStore.OPENING_PROPERTY).filterById(retailStore));
  }

  public RetailStoreOpeningRequest hasRetailStore(RetailStoreRequest retailStore) {
    return hasRetailStore(
        retailStore,
        $retailStore ->
            java.util.Optional.of($retailStore)
                .map(RetailStore::getOpening)
                .map(RetailStoreOpening::getId)
                .orElse(null));
  }

  public RetailStoreOpeningRequest hasRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.select(RetailStore.OPENING_PROPERTY);
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public RetailStoreOpeningRequest hasRetailStore(
      RetailStoreRequest retailStore, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(retailStore, RetailStore.OPENING_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, ID_PROPERTY, idRefine, RetailStore.OPENING_PROPERTY);
  }

  public RetailStoreOpeningRequest selectRetailStoreList(RetailStoreRequest retailStore) {
    selectChild(RetailStore.OPENING_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreOpeningRequest selectRetailStoreList() {
    return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
  }

  public RetailStoreOpeningRequest unselectRetailStoreList() {
    unselectChild(RetailStore.OPENING_PROPERTY, RetailStore.class);
    return this;
  }

  public RetailStoreOpeningRequest aggregateRetailStoreList(RetailStoreRequest retailStore) {
    aggregateChild(RetailStore.OPENING_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreOpeningRequest countRetailStore() {
    return countRetailStore("retailStoreCount");
  }

  public RetailStoreOpeningRequest countRetailStore(String retName) {
    return countRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreOpeningRequest countRetailStore(RetailStoreRequest retailStore) {
    return countRetailStore("retailStoreCount", retailStore);
  }

  public RetailStoreOpeningRequest countRetailStore(
      String retName, RetailStoreRequest retailStore) {
    retailStore.count();
    return statsFromRetailStore(retName, retailStore);
  }

  public RetailStoreOpeningRequest statsFromRetailStore(
      String retName, RetailStoreRequest retailStore) {
    return addDynamicProperty(retName, retailStore, RetailStore.OPENING_PROPERTY);
  }

  public RetailStoreOpeningRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreOpeningRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreOpeningRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreOpeningRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
