package com.doublechaintech.retailscm.retailstoreinvestmentinvitation;

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
import static com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation.*;

public class RetailStoreInvestmentInvitationRequest
    extends BaseRequest<RetailStoreInvestmentInvitation> {
  public static RetailStoreInvestmentInvitationRequest newInstance() {
    return new RetailStoreInvestmentInvitationRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreInvestmentInvitationRequest resultByClass(
      Class<? extends RetailStoreInvestmentInvitation> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreInvestmentInvitationRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreInvestmentInvitation";
  }

  public RetailStoreInvestmentInvitationRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreInvestmentInvitationRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest selectAll() {
    return this.selectId().selectComment().selectVersion();
  }

  public RetailStoreInvestmentInvitationRequest selectAny() {
    return selectAll().selectRetailStoreList(Q.retailStore().selectSelf());
  }

  public RetailStoreInvestmentInvitationRequest selectSelf() {
    select(ID_PROPERTY);
    select(COMMENT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreInvestmentInvitationRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest where(
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

  public RetailStoreInvestmentInvitationRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest comment(String comment) {
    return this;
  }

  public RetailStoreInvestmentInvitationRequest enhance() {
    return this;
  }

  public RetailStoreInvestmentInvitationRequest overrideClass(
      Class<? extends RetailStoreInvestmentInvitation> clazz) {
    return this;
  }

  public RetailStoreInvestmentInvitationRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest count() {
    return countId("count");
  }

  public static RetailStoreInvestmentInvitationRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreInvestmentInvitationRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreInvestmentInvitationRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreInvestmentInvitationRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreInvestmentInvitationRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest countId() {
    return countId("countId");
  }

  public RetailStoreInvestmentInvitationRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreInvestmentInvitationRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest minId() {
    return minId("minId");
  }

  public RetailStoreInvestmentInvitationRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreInvestmentInvitationRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest filterByComment(String comment) {

    if (comment == null) {
      return this;
    }

    return filterByComment(QueryOperator.EQUAL, comment);
  }

  public RetailStoreInvestmentInvitationRequest whereCommentIsNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreInvestmentInvitationRequest whereCommentIsNotNull() {
    return where(COMMENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreInvestmentInvitationRequest filterByComment(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCommentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreInvestmentInvitationRequest selectComment() {
    return select(COMMENT_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest unselectComment() {
    return unselect(COMMENT_PROPERTY);
  }

  public SearchCriteria getCommentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COMMENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreInvestmentInvitationRequest orderByComment(boolean asc) {
    addOrderBy(COMMENT_PROPERTY, asc);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByCommentAscending() {
    addOrderBy(COMMENT_PROPERTY, true);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByCommentDescending() {
    addOrderBy(COMMENT_PROPERTY, false);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByCommentAscendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", true);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByCommentDescendingUsingGBK() {
    addOrderBy("convert(comment using gbk)", false);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest countComment() {
    return countComment("countComment");
  }

  public RetailStoreInvestmentInvitationRequest countComment(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMMENT_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest maxComment() {
    return maxComment("maxComment");
  }

  public RetailStoreInvestmentInvitationRequest maxComment(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COMMENT_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest minComment() {
    return minComment("minComment");
  }

  public RetailStoreInvestmentInvitationRequest minComment(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COMMENT_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupByComment() {
    return groupByComment(COMMENT_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupByComment(String ret) {
    return groupBy(ret, COMMENT_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupByComment(SqlFunction func) {
    return groupByComment(COMMENT_PROPERTY, func);
  }

  public RetailStoreInvestmentInvitationRequest groupByComment(String ret, SqlFunction func) {
    super.groupBy(ret, func, COMMENT_PROPERTY);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreInvestmentInvitationRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreInvestmentInvitationRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreInvestmentInvitationRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreInvestmentInvitationRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreInvestmentInvitationRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreInvestmentInvitationRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreInvestmentInvitationRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreInvestmentInvitationRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreInvestmentInvitationRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreInvestmentInvitationRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest hasRetailStore() {
    return hasRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreInvestmentInvitationRequest hasRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("hasRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.INVESTMENT_INVITATION_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStore));
  }

  public RetailStoreInvestmentInvitationRequest hasRetailStore(String... retailStore) {
    return hasRetailStore(
        Q.retailStore().select(RetailStore.INVESTMENT_INVITATION_PROPERTY).filterById(retailStore));
  }

  public RetailStoreInvestmentInvitationRequest hasRetailStore(RetailStoreRequest retailStore) {
    return hasRetailStore(
        retailStore,
        $retailStore ->
            java.util.Optional.of($retailStore)
                .map(RetailStore::getInvestmentInvitation)
                .map(RetailStoreInvestmentInvitation::getId)
                .orElse(null));
  }

  public RetailStoreInvestmentInvitationRequest hasRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.select(RetailStore.INVESTMENT_INVITATION_PROPERTY);
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public RetailStoreInvestmentInvitationRequest hasRetailStore(
      RetailStoreRequest retailStore, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStore, RetailStore.INVESTMENT_INVITATION_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, ID_PROPERTY, idRefine, RetailStore.INVESTMENT_INVITATION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest selectRetailStoreList(
      RetailStoreRequest retailStore) {
    selectChild(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest selectRetailStoreList() {
    return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
  }

  public RetailStoreInvestmentInvitationRequest unselectRetailStoreList() {
    unselectChild(RetailStore.INVESTMENT_INVITATION_PROPERTY, RetailStore.class);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest aggregateRetailStoreList(
      RetailStoreRequest retailStore) {
    aggregateChild(RetailStore.INVESTMENT_INVITATION_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest countRetailStore() {
    return countRetailStore("retailStoreCount");
  }

  public RetailStoreInvestmentInvitationRequest countRetailStore(String retName) {
    return countRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreInvestmentInvitationRequest countRetailStore(RetailStoreRequest retailStore) {
    return countRetailStore("retailStoreCount", retailStore);
  }

  public RetailStoreInvestmentInvitationRequest countRetailStore(
      String retName, RetailStoreRequest retailStore) {
    retailStore.count();
    return statsFromRetailStore(retName, retailStore);
  }

  public RetailStoreInvestmentInvitationRequest statsFromRetailStore(
      String retName, RetailStoreRequest retailStore) {
    return addDynamicProperty(retName, retailStore, RetailStore.INVESTMENT_INVITATION_PROPERTY);
  }

  public RetailStoreInvestmentInvitationRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreInvestmentInvitationRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreInvestmentInvitationRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
