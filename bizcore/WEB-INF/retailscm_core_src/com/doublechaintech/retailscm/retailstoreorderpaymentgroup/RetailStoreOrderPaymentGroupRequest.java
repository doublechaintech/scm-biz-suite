package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup.*;

public class RetailStoreOrderPaymentGroupRequest extends BaseRequest<RetailStoreOrderPaymentGroup> {
  public static RetailStoreOrderPaymentGroupRequest newInstance() {
    return new RetailStoreOrderPaymentGroupRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreOrderPaymentGroupRequest resultByClass(
      Class<? extends RetailStoreOrderPaymentGroup> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreOrderPaymentGroup";
  }

  public RetailStoreOrderPaymentGroupRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest selectAll() {
    return this.selectId().selectName().selectBizOrder().selectCardNumber().selectVersion();
  }

  public RetailStoreOrderPaymentGroupRequest selectAny() {
    return selectAll();
  }

  public RetailStoreOrderPaymentGroupRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(CARD_NUMBER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreOrderPaymentGroupRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY, NAME_PROPERTY, BIZ_ORDER_PROPERTY, CARD_NUMBER_PROPERTY, VERSION_PROPERTY
  };

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public RetailStoreOrderPaymentGroupRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest comment(String comment) {
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest enhance() {
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest overrideClass(
      Class<? extends RetailStoreOrderPaymentGroup> clazz) {
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest count() {
    return countId("count");
  }

  public static RetailStoreOrderPaymentGroupRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreOrderPaymentGroupRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreOrderPaymentGroupRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderPaymentGroupRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderPaymentGroupRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest countId() {
    return countId("countId");
  }

  public RetailStoreOrderPaymentGroupRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreOrderPaymentGroupRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest minId() {
    return minId("minId");
  }

  public RetailStoreOrderPaymentGroupRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreOrderPaymentGroupRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreOrderPaymentGroupRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderPaymentGroupRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderPaymentGroupRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest countName() {
    return countName("countName");
  }

  public RetailStoreOrderPaymentGroupRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreOrderPaymentGroupRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest minName() {
    return minName("minName");
  }

  public RetailStoreOrderPaymentGroupRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreOrderPaymentGroupRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest filterByCardNumber(String cardNumber) {

    if (cardNumber == null) {
      return this;
    }

    return filterByCardNumber(QueryOperator.EQUAL, cardNumber);
  }

  public RetailStoreOrderPaymentGroupRequest whereCardNumberIsNull() {
    return where(CARD_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest whereCardNumberIsNotNull() {
    return where(CARD_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest filterByCardNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCardNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderPaymentGroupRequest selectCardNumber() {
    return select(CARD_NUMBER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest unselectCardNumber() {
    return unselect(CARD_NUMBER_PROPERTY);
  }

  public SearchCriteria getCardNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CARD_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderPaymentGroupRequest orderByCardNumber(boolean asc) {
    addOrderBy(CARD_NUMBER_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByCardNumberAscending() {
    addOrderBy(CARD_NUMBER_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByCardNumberDescending() {
    addOrderBy(CARD_NUMBER_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByCardNumberAscendingUsingGBK() {
    addOrderBy("convert(cardNumber using gbk)", true);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByCardNumberDescendingUsingGBK() {
    addOrderBy("convert(cardNumber using gbk)", false);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest countCardNumber() {
    return countCardNumber("countCardNumber");
  }

  public RetailStoreOrderPaymentGroupRequest countCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CARD_NUMBER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest maxCardNumber() {
    return maxCardNumber("maxCardNumber");
  }

  public RetailStoreOrderPaymentGroupRequest maxCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CARD_NUMBER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest minCardNumber() {
    return minCardNumber("minCardNumber");
  }

  public RetailStoreOrderPaymentGroupRequest minCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CARD_NUMBER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByCardNumber() {
    return groupByCardNumber(CARD_NUMBER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByCardNumber(String ret) {
    return groupBy(ret, CARD_NUMBER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByCardNumber(SqlFunction func) {
    return groupByCardNumber(CARD_NUMBER_PROPERTY, func);
  }

  public RetailStoreOrderPaymentGroupRequest groupByCardNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CARD_NUMBER_PROPERTY);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreOrderPaymentGroupRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderPaymentGroupRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderPaymentGroupRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreOrderPaymentGroupRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreOrderPaymentGroupRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreOrderPaymentGroupRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreOrderPaymentGroupRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreOrderPaymentGroupRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest filterByBizOrder(RetailStoreOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, RetailStoreOrder::getId);
  }

  public RetailStoreOrderPaymentGroupRequest filterByBizOrder(RetailStoreOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(RetailStoreOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreOrderPaymentGroupRequest selectBizOrderId() {
    select(BIZ_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest upToBizOrder() {
    return upToBizOrder(RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreOrderRequest upToBizOrder(RetailStoreOrderRequest bizOrder) {
    bizOrder.aggregateChild(BIZ_ORDER_PROPERTY, this);
    this.groupByBizOrder(bizOrder);
    return bizOrder;
  }

  public RetailStoreOrderRequest endAtBizOrder(String retName) {
    return endAtBizOrder(retName, RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreOrderRequest endAtBizOrder(String retName, RetailStoreOrderRequest bizOrder) {
    bizOrder.addDynamicProperty(retName, this, BIZ_ORDER_PROPERTY);
    return bizOrder;
  }

  public RetailStoreOrderPaymentGroupRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreOrderPaymentGroupRequest filterByBizOrder(
      RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, RetailStoreOrder.ID_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest selectBizOrder() {
    return selectBizOrder(RetailStoreOrderRequest.newInstance().selectSelf());
  }

  public RetailStoreOrderPaymentGroupRequest selectBizOrder(RetailStoreOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest groupByBizOrder(RetailStoreOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest aggregateBizOrder(RetailStoreOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public RetailStoreOrderPaymentGroupRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderPaymentGroupRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderPaymentGroupRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreOrderPaymentGroupRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
