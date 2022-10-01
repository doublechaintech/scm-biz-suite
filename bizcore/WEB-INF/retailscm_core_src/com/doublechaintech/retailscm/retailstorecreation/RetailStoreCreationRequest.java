package com.doublechaintech.retailscm.retailstorecreation;

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
import static com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation.*;

public class RetailStoreCreationRequest extends BaseRequest<RetailStoreCreation> {
  public static RetailStoreCreationRequest newInstance() {
    return new RetailStoreCreationRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreCreationRequest resultByClass(Class<? extends RetailStoreCreation> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreCreationRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreCreationRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreCreation";
  }

  public RetailStoreCreationRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreCreationRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreCreationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreCreationRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreCreationRequest selectAll() {
    return this.selectId().selectComment().selectVersion();
  }

  public RetailStoreCreationRequest selectAny() {
    return selectAll().selectRetailStoreList(Q.retailStore().selectSelf());
  }

  public RetailStoreCreationRequest selectSelf() {
    select(ID_PROPERTY);
    select(COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreCreationRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreCreationRequest where(
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

  public RetailStoreCreationRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreCreationRequest comment(String comment) {
    return this;
  }

  public RetailStoreCreationRequest enhance() {
    return this;
  }

  public RetailStoreCreationRequest overrideClass(Class<? extends RetailStoreCreation> clazz) {
    return this;
  }

  public RetailStoreCreationRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreCreationRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreCreationRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreCreationRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreCreationRequest count() {
    return countId("count");
  }

  public static RetailStoreCreationRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreCreationRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreCreationRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCreationRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreCreationRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCreationRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreCreationRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreCreationRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreCreationRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreCreationRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreCreationRequest countId() {
    return countId("countId");
  }

  public RetailStoreCreationRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreCreationRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreCreationRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreCreationRequest minId() {
    return minId("minId");
  }

  public RetailStoreCreationRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreCreationRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreCreationRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreCreationRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreCreationRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreCreationRequest filterByComment(String comment) {

    if (comment == null) {
      return this;
    }

    return filterByComment(QueryOperator.EQUAL, comment);
  }

  public RetailStoreCreationRequest whereCommentIsNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCreationRequest whereCommentIsNotNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCreationRequest filterByComment(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCreationRequest selectComment() {
    return select(COMMENT_PROPERTY);
  }

  public RetailStoreCreationRequest unselectComment() {
    return unselect(COMMENT_PROPERTY);
  }

  public SearchCriteria getCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCreationRequest orderByComment(boolean asc) {
    addOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public RetailStoreCreationRequest orderByCommentAscending() {
    addOrderBy(COMMENT_PROPERTY, true);
    return this;
  }

  public RetailStoreCreationRequest orderByCommentDescending() {
    addOrderBy(COMMENT_PROPERTY, false);
    return this;
  }

  public RetailStoreCreationRequest orderByCommentAscendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", true);
    return this;
  }

  public RetailStoreCreationRequest orderByCommentDescendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", false);
    return this;
  }

  public RetailStoreCreationRequest countComment() {
    return countComment("countComment");
  }

  public RetailStoreCreationRequest countComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMMENT_PROPERTY);
  }

  public RetailStoreCreationRequest maxComment() {
    return maxComment("maxComment");
  }

  public RetailStoreCreationRequest maxComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMMENT_PROPERTY);
  }

  public RetailStoreCreationRequest minComment() {
    return minComment("minComment");
  }

  public RetailStoreCreationRequest minComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMMENT_PROPERTY);
  }

  public RetailStoreCreationRequest groupByComment() {
    return groupByComment(COMMENT_PROPERTY);
  }

  public RetailStoreCreationRequest groupByComment(String ret) {
    return groupBy(ret, COMMENT_PROPERTY);
  }

  public RetailStoreCreationRequest groupByComment(SqlFunction func) {
    return groupByComment(COMMENT_PROPERTY, func);
  }

  public RetailStoreCreationRequest groupByComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMMENT_PROPERTY);
    return this;
  }

  public RetailStoreCreationRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreCreationRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCreationRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCreationRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCreationRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreCreationRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCreationRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreCreationRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreCreationRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreCreationRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreCreationRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreCreationRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreCreationRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreCreationRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreCreationRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreCreationRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreCreationRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreCreationRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreCreationRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreCreationRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreCreationRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreCreationRequest hasRetailStore() {
    return hasRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreCreationRequest hasRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("hasRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.CREATION_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStore));
  }

  public RetailStoreCreationRequest hasRetailStore(String... retailStore) {
    return hasRetailStore(
        Q.retailStore().select(RetailStore.CREATION_PROPERTY).filterById(retailStore));
  }

  public RetailStoreCreationRequest hasRetailStore(RetailStoreRequest retailStore) {
    return hasRetailStore(
        retailStore,
        $retailStore ->
            java.util.Optional.of($retailStore)
                .map(RetailStore::getCreation)
                .map(RetailStoreCreation::getId)
                .orElse(null));
  }

  public RetailStoreCreationRequest hasRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.select(RetailStore.CREATION_PROPERTY);
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public RetailStoreCreationRequest hasRetailStore(
      RetailStoreRequest retailStore, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(retailStore, RetailStore.CREATION_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, ID_PROPERTY, idRefine, RetailStore.CREATION_PROPERTY);
  }

  public RetailStoreCreationRequest selectRetailStoreList(RetailStoreRequest retailStore) {
    selectChild(RetailStore.CREATION_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreCreationRequest selectRetailStoreList() {
    return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
  }

  public RetailStoreCreationRequest unselectRetailStoreList() {
    unselectChild(RetailStore.CREATION_PROPERTY, RetailStore.class);
    return this;
  }

  public RetailStoreCreationRequest aggregateRetailStoreList(RetailStoreRequest retailStore) {
    aggregateChild(RetailStore.CREATION_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreCreationRequest countRetailStore() {
    return countRetailStore("retailStoreCount");
  }

  public RetailStoreCreationRequest countRetailStore(String retName) {
    return countRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreCreationRequest countRetailStore(RetailStoreRequest retailStore) {
    return countRetailStore("retailStoreCount", retailStore);
  }

  public RetailStoreCreationRequest countRetailStore(
      String retName, RetailStoreRequest retailStore) {
    retailStore.count();
    return statsFromRetailStore(retName, retailStore);
  }

  public RetailStoreCreationRequest statsFromRetailStore(
      String retName, RetailStoreRequest retailStore) {
    return addDynamicProperty(retName, retailStore, RetailStore.CREATION_PROPERTY);
  }

  public RetailStoreCreationRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreCreationRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreCreationRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreCreationRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
