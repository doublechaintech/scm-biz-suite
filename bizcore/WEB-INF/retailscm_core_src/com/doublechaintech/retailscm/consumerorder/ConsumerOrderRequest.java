package com.doublechaintech.retailscm.consumerorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemRequest;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupRequest;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentRequest;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerorder.ConsumerOrder.*;

public class ConsumerOrderRequest extends BaseRequest<ConsumerOrder> {
  public static ConsumerOrderRequest newInstance() {
    return new ConsumerOrderRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ConsumerOrderRequest resultByClass(Class<? extends ConsumerOrder> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ConsumerOrderRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ConsumerOrderRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ConsumerOrder";
  }

  public ConsumerOrderRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ConsumerOrderRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ConsumerOrderRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ConsumerOrderRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ConsumerOrderRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectConsumer()
        .selectStore()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public ConsumerOrderRequest selectAny() {
    return selectAll()
        .selectConsumerOrderLineItemList(Q.consumerOrderLineItem().selectSelf())
        .selectConsumerOrderShippingGroupList(Q.consumerOrderShippingGroup().selectSelf())
        .selectConsumerOrderPaymentGroupList(Q.consumerOrderPaymentGroup().selectSelf())
        .selectConsumerOrderPriceAdjustmentList(Q.consumerOrderPriceAdjustment().selectSelf())
        .selectRetailStoreMemberGiftCardConsumeRecordList(
            Q.retailStoreMemberGiftCardConsumeRecord().selectSelf());
  }

  public ConsumerOrderRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(CONSUMER_PROPERTY);
    select(STORE_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ConsumerOrderRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ConsumerOrderRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    TITLE_PROPERTY,
    CONSUMER_PROPERTY,
    STORE_PROPERTY,
    LAST_UPDATE_TIME_PROPERTY,
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

  public ConsumerOrderRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ConsumerOrderRequest comment(String comment) {
    return this;
  }

  public ConsumerOrderRequest enhance() {
    return this;
  }

  public ConsumerOrderRequest overrideClass(Class<? extends ConsumerOrder> clazz) {
    return this;
  }

  public ConsumerOrderRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ConsumerOrderRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ConsumerOrderRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ConsumerOrderRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ConsumerOrderRequest count() {
    return countId("count");
  }

  public static ConsumerOrderRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ConsumerOrderRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ConsumerOrderRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ConsumerOrderRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ConsumerOrderRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ConsumerOrderRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ConsumerOrderRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ConsumerOrderRequest countId() {
    return countId("countId");
  }

  public ConsumerOrderRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ConsumerOrderRequest maxId() {
    return maxId("maxId");
  }

  public ConsumerOrderRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ConsumerOrderRequest minId() {
    return minId("minId");
  }

  public ConsumerOrderRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ConsumerOrderRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ConsumerOrderRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ConsumerOrderRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ConsumerOrderRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public ConsumerOrderRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public ConsumerOrderRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public ConsumerOrderRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public ConsumerOrderRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public ConsumerOrderRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public ConsumerOrderRequest countTitle() {
    return countTitle("countTitle");
  }

  public ConsumerOrderRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public ConsumerOrderRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public ConsumerOrderRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public ConsumerOrderRequest minTitle() {
    return minTitle("minTitle");
  }

  public ConsumerOrderRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public ConsumerOrderRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public ConsumerOrderRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public ConsumerOrderRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public ConsumerOrderRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public ConsumerOrderRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderRequest whereLastUpdateTimeBetween(
      Date lastUpdateTimeStart, Date lastUpdateTimeEnd) {
    if (ObjectUtil.isEmpty(lastUpdateTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastUpdateTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastUpdateTimeStart, lastUpdateTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public ConsumerOrderRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public ConsumerOrderRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public ConsumerOrderRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public ConsumerOrderRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public ConsumerOrderRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public ConsumerOrderRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public ConsumerOrderRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ConsumerOrderRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ConsumerOrderRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ConsumerOrderRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ConsumerOrderRequest countVersion() {
    return countVersion("countVersion");
  }

  public ConsumerOrderRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ConsumerOrderRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ConsumerOrderRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ConsumerOrderRequest minVersion() {
    return minVersion("minVersion");
  }

  public ConsumerOrderRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ConsumerOrderRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ConsumerOrderRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ConsumerOrderRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ConsumerOrderRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ConsumerOrderRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ConsumerOrderRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest filterByConsumer(RetailStoreMemberRequest consumer) {
    return filterByConsumer(consumer, RetailStoreMember::getId);
  }

  public ConsumerOrderRequest filterByConsumer(RetailStoreMember... consumer) {
    if (isEmptyParam(consumer)) {
      throw new IllegalArgumentException("filterByConsumer(RetailStoreMember... consumer)参数不能为空!");
    }
    return where(CONSUMER_PROPERTY, QueryOperator.IN, (Object[]) consumer);
  }

  public ConsumerOrderRequest selectConsumerId() {
    select(CONSUMER_PROPERTY);
    return this;
  }

  public RetailStoreMemberRequest upToConsumer() {
    return upToConsumer(RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreMemberRequest upToConsumer(RetailStoreMemberRequest consumer) {
    consumer.aggregateChild(CONSUMER_PROPERTY, this);
    this.groupByConsumer(consumer);
    return consumer;
  }

  public RetailStoreMemberRequest endAtConsumer(String retName) {
    return endAtConsumer(retName, RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreMemberRequest endAtConsumer(String retName, RetailStoreMemberRequest consumer) {
    consumer.addDynamicProperty(retName, this, CONSUMER_PROPERTY);
    return consumer;
  }

  public ConsumerOrderRequest filterByConsumer(String... consumer) {
    if (isEmptyParam(consumer)) {
      throw new IllegalArgumentException("filterByConsumer(String... consumer)参数不能为空!");
    }
    return where(CONSUMER_PROPERTY, QueryOperator.IN, (Object[]) consumer);
  }

  public ConsumerOrderRequest filterByConsumer(
      RetailStoreMemberRequest consumer, IDRefine<RetailStoreMember> idRefine) {
    consumer.unlimited();
    return addSearchCriteria(createConsumerCriteria(consumer, idRefine));
  }

  public SearchCriteria createConsumerCriteria(
      RetailStoreMemberRequest consumer, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(
        consumer, CONSUMER_PROPERTY, idRefine, RetailStoreMember.ID_PROPERTY);
  }

  public ConsumerOrderRequest selectConsumer() {
    return selectConsumer(RetailStoreMemberRequest.newInstance().selectSelf());
  }

  public ConsumerOrderRequest selectConsumer(RetailStoreMemberRequest consumer) {
    selectParent(CONSUMER_PROPERTY, consumer);
    return this;
  }

  public ConsumerOrderRequest unselectConsumer() {
    unselectParent(CONSUMER_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest groupByConsumer(RetailStoreMemberRequest consumer) {
    groupBy(CONSUMER_PROPERTY, consumer);
    return this;
  }

  public ConsumerOrderRequest aggregateConsumer(RetailStoreMemberRequest consumer) {
    aggregateParent(CONSUMER_PROPERTY, consumer);
    return this;
  }

  public ConsumerOrderRequest countConsumer() {
    return countConsumer("countConsumer");
  }

  public ConsumerOrderRequest countConsumer(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONSUMER_PROPERTY);
  }

  public ConsumerOrderRequest groupByConsumer() {
    return groupByConsumer(CONSUMER_PROPERTY);
  }

  public ConsumerOrderRequest groupByConsumer(String ret) {
    return groupBy(ret, CONSUMER_PROPERTY);
  }

  public ConsumerOrderRequest whereConsumerIsNull() {
    return where(CONSUMER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderRequest whereConsumerIsNotNull() {
    return where(CONSUMER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderRequest filterByStore(RetailStoreRequest store) {
    return filterByStore(store, RetailStore::getId);
  }

  public ConsumerOrderRequest filterByStore(RetailStore... store) {
    if (isEmptyParam(store)) {
      throw new IllegalArgumentException("filterByStore(RetailStore... store)参数不能为空!");
    }
    return where(STORE_PROPERTY, QueryOperator.IN, (Object[]) store);
  }

  public ConsumerOrderRequest selectStoreId() {
    select(STORE_PROPERTY);
    return this;
  }

  public RetailStoreRequest upToStore() {
    return upToStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest upToStore(RetailStoreRequest store) {
    store.aggregateChild(STORE_PROPERTY, this);
    this.groupByStore(store);
    return store;
  }

  public RetailStoreRequest endAtStore(String retName) {
    return endAtStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest endAtStore(String retName, RetailStoreRequest store) {
    store.addDynamicProperty(retName, this, STORE_PROPERTY);
    return store;
  }

  public ConsumerOrderRequest filterByStore(String... store) {
    if (isEmptyParam(store)) {
      throw new IllegalArgumentException("filterByStore(String... store)参数不能为空!");
    }
    return where(STORE_PROPERTY, QueryOperator.IN, (Object[]) store);
  }

  public ConsumerOrderRequest filterByStore(
      RetailStoreRequest store, IDRefine<RetailStore> idRefine) {
    store.unlimited();
    return addSearchCriteria(createStoreCriteria(store, idRefine));
  }

  public SearchCriteria createStoreCriteria(
      RetailStoreRequest store, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(store, STORE_PROPERTY, idRefine, RetailStore.ID_PROPERTY);
  }

  public ConsumerOrderRequest selectStore() {
    return selectStore(RetailStoreRequest.newInstance().selectSelf());
  }

  public ConsumerOrderRequest selectStore(RetailStoreRequest store) {
    selectParent(STORE_PROPERTY, store);
    return this;
  }

  public ConsumerOrderRequest unselectStore() {
    unselectParent(STORE_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest groupByStore(RetailStoreRequest store) {
    groupBy(STORE_PROPERTY, store);
    return this;
  }

  public ConsumerOrderRequest aggregateStore(RetailStoreRequest store) {
    aggregateParent(STORE_PROPERTY, store);
    return this;
  }

  public ConsumerOrderRequest countStore() {
    return countStore("countStore");
  }

  public ConsumerOrderRequest countStore(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, STORE_PROPERTY);
  }

  public ConsumerOrderRequest groupByStore() {
    return groupByStore(STORE_PROPERTY);
  }

  public ConsumerOrderRequest groupByStore(String ret) {
    return groupBy(ret, STORE_PROPERTY);
  }

  public ConsumerOrderRequest whereStoreIsNull() {
    return where(STORE_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderRequest whereStoreIsNotNull() {
    return where(STORE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderRequest hasConsumerOrderLineItem() {
    return hasConsumerOrderLineItem(ConsumerOrderLineItemRequest.newInstance());
  }

  public ConsumerOrderRequest hasConsumerOrderLineItem(
      ConsumerOrderLineItem... consumerOrderLineItem) {
    if (isEmptyParam(consumerOrderLineItem)) {
      throw new IllegalArgumentException(
          "hasConsumerOrderLineItem(ConsumerOrderLineItem... consumerOrderLineItem)参数不能为空!");
    }
    return hasConsumerOrderLineItem(
        Q.consumerOrderLineItem()
            .select(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) consumerOrderLineItem));
  }

  public ConsumerOrderRequest hasConsumerOrderLineItem(String... consumerOrderLineItem) {
    return hasConsumerOrderLineItem(
        Q.consumerOrderLineItem()
            .select(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY)
            .filterById(consumerOrderLineItem));
  }

  public ConsumerOrderRequest hasConsumerOrderLineItem(
      ConsumerOrderLineItemRequest consumerOrderLineItem) {
    return hasConsumerOrderLineItem(
        consumerOrderLineItem,
        $consumerOrderLineItem ->
            java.util.Optional.of($consumerOrderLineItem)
                .map(ConsumerOrderLineItem::getBizOrder)
                .map(ConsumerOrder::getId)
                .orElse(null));
  }

  public ConsumerOrderRequest hasConsumerOrderLineItem(
      ConsumerOrderLineItemRequest consumerOrderLineItem,
      IDRefine<ConsumerOrderLineItem> idRefine) {
    consumerOrderLineItem.select(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY);
    consumerOrderLineItem.unlimited();
    return addSearchCriteria(createConsumerOrderLineItemCriteria(consumerOrderLineItem, idRefine));
  }

  public ConsumerOrderRequest hasConsumerOrderLineItem(
      ConsumerOrderLineItemRequest consumerOrderLineItem,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            consumerOrderLineItem, ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createConsumerOrderLineItemCriteria(
      ConsumerOrderLineItemRequest consumerOrderLineItem,
      IDRefine<ConsumerOrderLineItem> idRefine) {
    return new RefinedIdInCriteria(
        consumerOrderLineItem, ID_PROPERTY, idRefine, ConsumerOrderLineItem.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest selectConsumerOrderLineItemList(
      ConsumerOrderLineItemRequest consumerOrderLineItem) {
    selectChild(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, consumerOrderLineItem);
    return this;
  }

  public ConsumerOrderRequest selectConsumerOrderLineItemList() {
    return selectConsumerOrderLineItemList(ConsumerOrderLineItemRequest.newInstance().selectAll());
  }

  public ConsumerOrderRequest unselectConsumerOrderLineItemList() {
    unselectChild(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, ConsumerOrderLineItem.class);
    return this;
  }

  public ConsumerOrderRequest hasConsumerOrderShippingGroup() {
    return hasConsumerOrderShippingGroup(ConsumerOrderShippingGroupRequest.newInstance());
  }

  public ConsumerOrderRequest hasConsumerOrderShippingGroup(
      ConsumerOrderShippingGroup... consumerOrderShippingGroup) {
    if (isEmptyParam(consumerOrderShippingGroup)) {
      throw new IllegalArgumentException(
          "hasConsumerOrderShippingGroup(ConsumerOrderShippingGroup... consumerOrderShippingGroup)参数不能为空!");
    }
    return hasConsumerOrderShippingGroup(
        Q.consumerOrderShippingGroup()
            .select(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) consumerOrderShippingGroup));
  }

  public ConsumerOrderRequest hasConsumerOrderShippingGroup(String... consumerOrderShippingGroup) {
    return hasConsumerOrderShippingGroup(
        Q.consumerOrderShippingGroup()
            .select(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY)
            .filterById(consumerOrderShippingGroup));
  }

  public ConsumerOrderRequest hasConsumerOrderShippingGroup(
      ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
    return hasConsumerOrderShippingGroup(
        consumerOrderShippingGroup,
        $consumerOrderShippingGroup ->
            java.util.Optional.of($consumerOrderShippingGroup)
                .map(ConsumerOrderShippingGroup::getBizOrder)
                .map(ConsumerOrder::getId)
                .orElse(null));
  }

  public ConsumerOrderRequest hasConsumerOrderShippingGroup(
      ConsumerOrderShippingGroupRequest consumerOrderShippingGroup,
      IDRefine<ConsumerOrderShippingGroup> idRefine) {
    consumerOrderShippingGroup.select(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY);
    consumerOrderShippingGroup.unlimited();
    return addSearchCriteria(
        createConsumerOrderShippingGroupCriteria(consumerOrderShippingGroup, idRefine));
  }

  public ConsumerOrderRequest hasConsumerOrderShippingGroup(
      ConsumerOrderShippingGroupRequest consumerOrderShippingGroup,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            consumerOrderShippingGroup,
            ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createConsumerOrderShippingGroupCriteria(
      ConsumerOrderShippingGroupRequest consumerOrderShippingGroup,
      IDRefine<ConsumerOrderShippingGroup> idRefine) {
    return new RefinedIdInCriteria(
        consumerOrderShippingGroup,
        ID_PROPERTY,
        idRefine,
        ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest selectConsumerOrderShippingGroupList(
      ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
    selectChild(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, consumerOrderShippingGroup);
    return this;
  }

  public ConsumerOrderRequest selectConsumerOrderShippingGroupList() {
    return selectConsumerOrderShippingGroupList(
        ConsumerOrderShippingGroupRequest.newInstance().selectAll());
  }

  public ConsumerOrderRequest unselectConsumerOrderShippingGroupList() {
    unselectChild(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, ConsumerOrderShippingGroup.class);
    return this;
  }

  public ConsumerOrderRequest hasConsumerOrderPaymentGroup() {
    return hasConsumerOrderPaymentGroup(ConsumerOrderPaymentGroupRequest.newInstance());
  }

  public ConsumerOrderRequest hasConsumerOrderPaymentGroup(
      ConsumerOrderPaymentGroup... consumerOrderPaymentGroup) {
    if (isEmptyParam(consumerOrderPaymentGroup)) {
      throw new IllegalArgumentException(
          "hasConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup... consumerOrderPaymentGroup)参数不能为空!");
    }
    return hasConsumerOrderPaymentGroup(
        Q.consumerOrderPaymentGroup()
            .select(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) consumerOrderPaymentGroup));
  }

  public ConsumerOrderRequest hasConsumerOrderPaymentGroup(String... consumerOrderPaymentGroup) {
    return hasConsumerOrderPaymentGroup(
        Q.consumerOrderPaymentGroup()
            .select(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY)
            .filterById(consumerOrderPaymentGroup));
  }

  public ConsumerOrderRequest hasConsumerOrderPaymentGroup(
      ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
    return hasConsumerOrderPaymentGroup(
        consumerOrderPaymentGroup,
        $consumerOrderPaymentGroup ->
            java.util.Optional.of($consumerOrderPaymentGroup)
                .map(ConsumerOrderPaymentGroup::getBizOrder)
                .map(ConsumerOrder::getId)
                .orElse(null));
  }

  public ConsumerOrderRequest hasConsumerOrderPaymentGroup(
      ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup,
      IDRefine<ConsumerOrderPaymentGroup> idRefine) {
    consumerOrderPaymentGroup.select(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY);
    consumerOrderPaymentGroup.unlimited();
    return addSearchCriteria(
        createConsumerOrderPaymentGroupCriteria(consumerOrderPaymentGroup, idRefine));
  }

  public ConsumerOrderRequest hasConsumerOrderPaymentGroup(
      ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            consumerOrderPaymentGroup,
            ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createConsumerOrderPaymentGroupCriteria(
      ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup,
      IDRefine<ConsumerOrderPaymentGroup> idRefine) {
    return new RefinedIdInCriteria(
        consumerOrderPaymentGroup,
        ID_PROPERTY,
        idRefine,
        ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest selectConsumerOrderPaymentGroupList(
      ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
    selectChild(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, consumerOrderPaymentGroup);
    return this;
  }

  public ConsumerOrderRequest selectConsumerOrderPaymentGroupList() {
    return selectConsumerOrderPaymentGroupList(
        ConsumerOrderPaymentGroupRequest.newInstance().selectAll());
  }

  public ConsumerOrderRequest unselectConsumerOrderPaymentGroupList() {
    unselectChild(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, ConsumerOrderPaymentGroup.class);
    return this;
  }

  public ConsumerOrderRequest hasConsumerOrderPriceAdjustment() {
    return hasConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustmentRequest.newInstance());
  }

  public ConsumerOrderRequest hasConsumerOrderPriceAdjustment(
      ConsumerOrderPriceAdjustment... consumerOrderPriceAdjustment) {
    if (isEmptyParam(consumerOrderPriceAdjustment)) {
      throw new IllegalArgumentException(
          "hasConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment... consumerOrderPriceAdjustment)参数不能为空!");
    }
    return hasConsumerOrderPriceAdjustment(
        Q.consumerOrderPriceAdjustment()
            .select(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) consumerOrderPriceAdjustment));
  }

  public ConsumerOrderRequest hasConsumerOrderPriceAdjustment(
      String... consumerOrderPriceAdjustment) {
    return hasConsumerOrderPriceAdjustment(
        Q.consumerOrderPriceAdjustment()
            .select(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY)
            .filterById(consumerOrderPriceAdjustment));
  }

  public ConsumerOrderRequest hasConsumerOrderPriceAdjustment(
      ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
    return hasConsumerOrderPriceAdjustment(
        consumerOrderPriceAdjustment,
        $consumerOrderPriceAdjustment ->
            java.util.Optional.of($consumerOrderPriceAdjustment)
                .map(ConsumerOrderPriceAdjustment::getBizOrder)
                .map(ConsumerOrder::getId)
                .orElse(null));
  }

  public ConsumerOrderRequest hasConsumerOrderPriceAdjustment(
      ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment,
      IDRefine<ConsumerOrderPriceAdjustment> idRefine) {
    consumerOrderPriceAdjustment.select(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY);
    consumerOrderPriceAdjustment.unlimited();
    return addSearchCriteria(
        createConsumerOrderPriceAdjustmentCriteria(consumerOrderPriceAdjustment, idRefine));
  }

  public ConsumerOrderRequest hasConsumerOrderPriceAdjustment(
      ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            consumerOrderPriceAdjustment,
            ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createConsumerOrderPriceAdjustmentCriteria(
      ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment,
      IDRefine<ConsumerOrderPriceAdjustment> idRefine) {
    return new RefinedIdInCriteria(
        consumerOrderPriceAdjustment,
        ID_PROPERTY,
        idRefine,
        ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest selectConsumerOrderPriceAdjustmentList(
      ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
    selectChild(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, consumerOrderPriceAdjustment);
    return this;
  }

  public ConsumerOrderRequest selectConsumerOrderPriceAdjustmentList() {
    return selectConsumerOrderPriceAdjustmentList(
        ConsumerOrderPriceAdjustmentRequest.newInstance().selectAll());
  }

  public ConsumerOrderRequest unselectConsumerOrderPriceAdjustmentList() {
    unselectChild(
        ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, ConsumerOrderPriceAdjustment.class);
    return this;
  }

  public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord() {
    return hasRetailStoreMemberGiftCardConsumeRecord(
        RetailStoreMemberGiftCardConsumeRecordRequest.newInstance());
  }

  public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecord... retailStoreMemberGiftCardConsumeRecord) {
    if (isEmptyParam(retailStoreMemberGiftCardConsumeRecord)) {
      throw new IllegalArgumentException(
          "hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord... retailStoreMemberGiftCardConsumeRecord)参数不能为空!");
    }
    return hasRetailStoreMemberGiftCardConsumeRecord(
        Q.retailStoreMemberGiftCardConsumeRecord()
            .select(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreMemberGiftCardConsumeRecord));
  }

  public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord(
      String... retailStoreMemberGiftCardConsumeRecord) {
    return hasRetailStoreMemberGiftCardConsumeRecord(
        Q.retailStoreMemberGiftCardConsumeRecord()
            .select(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY)
            .filterById(retailStoreMemberGiftCardConsumeRecord));
  }

  public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    return hasRetailStoreMemberGiftCardConsumeRecord(
        retailStoreMemberGiftCardConsumeRecord,
        $retailStoreMemberGiftCardConsumeRecord ->
            java.util.Optional.of($retailStoreMemberGiftCardConsumeRecord)
                .map(RetailStoreMemberGiftCardConsumeRecord::getBizOrder)
                .map(ConsumerOrder::getId)
                .orElse(null));
  }

  public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord,
      IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine) {
    retailStoreMemberGiftCardConsumeRecord.select(
        RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY);
    retailStoreMemberGiftCardConsumeRecord.unlimited();
    return addSearchCriteria(
        createRetailStoreMemberGiftCardConsumeRecordCriteria(
            retailStoreMemberGiftCardConsumeRecord, idRefine));
  }

  public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreMemberGiftCardConsumeRecord,
            RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreMemberGiftCardConsumeRecordCriteria(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord,
      IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreMemberGiftCardConsumeRecord,
        ID_PROPERTY,
        idRefine,
        RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest selectRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    selectChild(
        RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY,
        retailStoreMemberGiftCardConsumeRecord);
    return this;
  }

  public ConsumerOrderRequest selectRetailStoreMemberGiftCardConsumeRecordList() {
    return selectRetailStoreMemberGiftCardConsumeRecordList(
        RetailStoreMemberGiftCardConsumeRecordRequest.newInstance().selectAll());
  }

  public ConsumerOrderRequest unselectRetailStoreMemberGiftCardConsumeRecordList() {
    unselectChild(
        RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY,
        RetailStoreMemberGiftCardConsumeRecord.class);
    return this;
  }

  public ConsumerOrderRequest aggregateConsumerOrderLineItemList(
      ConsumerOrderLineItemRequest consumerOrderLineItem) {
    aggregateChild(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, consumerOrderLineItem);
    return this;
  }

  public ConsumerOrderRequest countConsumerOrderLineItem() {
    return countConsumerOrderLineItem("consumerOrderLineItemCount");
  }

  public ConsumerOrderRequest countConsumerOrderLineItem(String retName) {
    return countConsumerOrderLineItem(retName, ConsumerOrderLineItemRequest.newInstance());
  }

  public ConsumerOrderRequest countConsumerOrderLineItem(
      ConsumerOrderLineItemRequest consumerOrderLineItem) {
    return countConsumerOrderLineItem("consumerOrderLineItemCount", consumerOrderLineItem);
  }

  public ConsumerOrderRequest countConsumerOrderLineItem(
      String retName, ConsumerOrderLineItemRequest consumerOrderLineItem) {
    consumerOrderLineItem.count();
    return statsFromConsumerOrderLineItem(retName, consumerOrderLineItem);
  }

  public ConsumerOrderRequest statsFromConsumerOrderLineItem(
      String retName, ConsumerOrderLineItemRequest consumerOrderLineItem) {
    return addDynamicProperty(
        retName, consumerOrderLineItem, ConsumerOrderLineItem.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest aggregateConsumerOrderShippingGroupList(
      ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
    aggregateChild(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, consumerOrderShippingGroup);
    return this;
  }

  public ConsumerOrderRequest countConsumerOrderShippingGroup() {
    return countConsumerOrderShippingGroup("consumerOrderShippingGroupCount");
  }

  public ConsumerOrderRequest countConsumerOrderShippingGroup(String retName) {
    return countConsumerOrderShippingGroup(
        retName, ConsumerOrderShippingGroupRequest.newInstance());
  }

  public ConsumerOrderRequest countConsumerOrderShippingGroup(
      ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
    return countConsumerOrderShippingGroup(
        "consumerOrderShippingGroupCount", consumerOrderShippingGroup);
  }

  public ConsumerOrderRequest countConsumerOrderShippingGroup(
      String retName, ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
    consumerOrderShippingGroup.count();
    return statsFromConsumerOrderShippingGroup(retName, consumerOrderShippingGroup);
  }

  public ConsumerOrderRequest statsFromConsumerOrderShippingGroup(
      String retName, ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
    return addDynamicProperty(
        retName, consumerOrderShippingGroup, ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest aggregateConsumerOrderPaymentGroupList(
      ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
    aggregateChild(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, consumerOrderPaymentGroup);
    return this;
  }

  public ConsumerOrderRequest countConsumerOrderPaymentGroup() {
    return countConsumerOrderPaymentGroup("consumerOrderPaymentGroupCount");
  }

  public ConsumerOrderRequest countConsumerOrderPaymentGroup(String retName) {
    return countConsumerOrderPaymentGroup(retName, ConsumerOrderPaymentGroupRequest.newInstance());
  }

  public ConsumerOrderRequest countConsumerOrderPaymentGroup(
      ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
    return countConsumerOrderPaymentGroup(
        "consumerOrderPaymentGroupCount", consumerOrderPaymentGroup);
  }

  public ConsumerOrderRequest countConsumerOrderPaymentGroup(
      String retName, ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
    consumerOrderPaymentGroup.count();
    return statsFromConsumerOrderPaymentGroup(retName, consumerOrderPaymentGroup);
  }

  public ConsumerOrderRequest statsFromConsumerOrderPaymentGroup(
      String retName, ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
    return addDynamicProperty(
        retName, consumerOrderPaymentGroup, ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest aggregateConsumerOrderPriceAdjustmentList(
      ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
    aggregateChild(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, consumerOrderPriceAdjustment);
    return this;
  }

  public ConsumerOrderRequest countConsumerOrderPriceAdjustment() {
    return countConsumerOrderPriceAdjustment("consumerOrderPriceAdjustmentCount");
  }

  public ConsumerOrderRequest countConsumerOrderPriceAdjustment(String retName) {
    return countConsumerOrderPriceAdjustment(
        retName, ConsumerOrderPriceAdjustmentRequest.newInstance());
  }

  public ConsumerOrderRequest countConsumerOrderPriceAdjustment(
      ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
    return countConsumerOrderPriceAdjustment(
        "consumerOrderPriceAdjustmentCount", consumerOrderPriceAdjustment);
  }

  public ConsumerOrderRequest countConsumerOrderPriceAdjustment(
      String retName, ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
    consumerOrderPriceAdjustment.count();
    return statsFromConsumerOrderPriceAdjustment(retName, consumerOrderPriceAdjustment);
  }

  public ConsumerOrderRequest statsFromConsumerOrderPriceAdjustment(
      String retName, ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
    return addDynamicProperty(
        retName, consumerOrderPriceAdjustment, ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest aggregateRetailStoreMemberGiftCardConsumeRecordList(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    aggregateChild(
        RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY,
        retailStoreMemberGiftCardConsumeRecord);
    return this;
  }

  public ConsumerOrderRequest countRetailStoreMemberGiftCardConsumeRecord() {
    return countRetailStoreMemberGiftCardConsumeRecord(
        "retailStoreMemberGiftCardConsumeRecordCount");
  }

  public ConsumerOrderRequest countRetailStoreMemberGiftCardConsumeRecord(String retName) {
    return countRetailStoreMemberGiftCardConsumeRecord(
        retName, RetailStoreMemberGiftCardConsumeRecordRequest.newInstance());
  }

  public ConsumerOrderRequest countRetailStoreMemberGiftCardConsumeRecord(
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    return countRetailStoreMemberGiftCardConsumeRecord(
        "retailStoreMemberGiftCardConsumeRecordCount", retailStoreMemberGiftCardConsumeRecord);
  }

  public ConsumerOrderRequest countRetailStoreMemberGiftCardConsumeRecord(
      String retName,
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    retailStoreMemberGiftCardConsumeRecord.count();
    return statsFromRetailStoreMemberGiftCardConsumeRecord(
        retName, retailStoreMemberGiftCardConsumeRecord);
  }

  public ConsumerOrderRequest statsFromRetailStoreMemberGiftCardConsumeRecord(
      String retName,
      RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
    return addDynamicProperty(
        retName,
        retailStoreMemberGiftCardConsumeRecord,
        RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ConsumerOrderRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ConsumerOrderRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ConsumerOrderRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
