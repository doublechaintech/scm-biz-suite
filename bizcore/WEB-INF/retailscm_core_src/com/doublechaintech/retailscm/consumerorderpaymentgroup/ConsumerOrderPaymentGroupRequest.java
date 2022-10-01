package com.doublechaintech.retailscm.consumerorderpaymentgroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup.*;

public class ConsumerOrderPaymentGroupRequest extends BaseRequest<ConsumerOrderPaymentGroup> {
  public static ConsumerOrderPaymentGroupRequest newInstance() {
    return new ConsumerOrderPaymentGroupRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public ConsumerOrderPaymentGroupRequest resultByClass(
      Class<? extends ConsumerOrderPaymentGroup> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public ConsumerOrderPaymentGroupRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "ConsumerOrderPaymentGroup";
  }

  public ConsumerOrderPaymentGroupRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public ConsumerOrderPaymentGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest select(String... names) {
    super.select(names);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest selectAll() {
    return this.selectId().selectName().selectBizOrder().selectCardNumber().selectVersion();
  }

  public ConsumerOrderPaymentGroupRequest selectAny() {
    return selectAll();
  }

  public ConsumerOrderPaymentGroupRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(CARD_NUMBER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public ConsumerOrderPaymentGroupRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest where(
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

  public ConsumerOrderPaymentGroupRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest comment(String comment) {
    return this;
  }

  public ConsumerOrderPaymentGroupRequest enhance() {
    return this;
  }

  public ConsumerOrderPaymentGroupRequest overrideClass(
      Class<? extends ConsumerOrderPaymentGroup> clazz) {
    return this;
  }

  public ConsumerOrderPaymentGroupRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest count() {
    return countId("count");
  }

  public static ConsumerOrderPaymentGroupRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public ConsumerOrderPaymentGroupRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public ConsumerOrderPaymentGroupRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPaymentGroupRequest selectId() {
    return select(ID_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPaymentGroupRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest countId() {
    return countId("countId");
  }

  public ConsumerOrderPaymentGroupRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest maxId() {
    return maxId("maxId");
  }

  public ConsumerOrderPaymentGroupRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest minId() {
    return minId("minId");
  }

  public ConsumerOrderPaymentGroupRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public ConsumerOrderPaymentGroupRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public ConsumerOrderPaymentGroupRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPaymentGroupRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPaymentGroupRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPaymentGroupRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPaymentGroupRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest countName() {
    return countName("countName");
  }

  public ConsumerOrderPaymentGroupRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest maxName() {
    return maxName("maxName");
  }

  public ConsumerOrderPaymentGroupRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest minName() {
    return minName("minName");
  }

  public ConsumerOrderPaymentGroupRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public ConsumerOrderPaymentGroupRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest filterByCardNumber(String cardNumber) {

    if (cardNumber == null) {
      return this;
    }

    return filterByCardNumber(QueryOperator.EQUAL, cardNumber);
  }

  public ConsumerOrderPaymentGroupRequest whereCardNumberIsNull() {
    return where(CARD_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPaymentGroupRequest whereCardNumberIsNotNull() {
    return where(CARD_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPaymentGroupRequest filterByCardNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCardNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPaymentGroupRequest selectCardNumber() {
    return select(CARD_NUMBER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest unselectCardNumber() {
    return unselect(CARD_NUMBER_PROPERTY);
  }

  public SearchCriteria getCardNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CARD_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPaymentGroupRequest orderByCardNumber(boolean asc) {
    addOrderBy(CARD_NUMBER_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByCardNumberAscending() {
    addOrderBy(CARD_NUMBER_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByCardNumberDescending() {
    addOrderBy(CARD_NUMBER_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByCardNumberAscendingUsingGBK() {
    addOrderBy("convert(cardNumber using gbk)", true);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByCardNumberDescendingUsingGBK() {
    addOrderBy("convert(cardNumber using gbk)", false);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest countCardNumber() {
    return countCardNumber("countCardNumber");
  }

  public ConsumerOrderPaymentGroupRequest countCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CARD_NUMBER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest maxCardNumber() {
    return maxCardNumber("maxCardNumber");
  }

  public ConsumerOrderPaymentGroupRequest maxCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CARD_NUMBER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest minCardNumber() {
    return minCardNumber("minCardNumber");
  }

  public ConsumerOrderPaymentGroupRequest minCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CARD_NUMBER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByCardNumber() {
    return groupByCardNumber(CARD_NUMBER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByCardNumber(String ret) {
    return groupBy(ret, CARD_NUMBER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByCardNumber(SqlFunction func) {
    return groupByCardNumber(CARD_NUMBER_PROPERTY, func);
  }

  public ConsumerOrderPaymentGroupRequest groupByCardNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CARD_NUMBER_PROPERTY);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public ConsumerOrderPaymentGroupRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPaymentGroupRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPaymentGroupRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public ConsumerOrderPaymentGroupRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public ConsumerOrderPaymentGroupRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest countVersion() {
    return countVersion("countVersion");
  }

  public ConsumerOrderPaymentGroupRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public ConsumerOrderPaymentGroupRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest minVersion() {
    return minVersion("minVersion");
  }

  public ConsumerOrderPaymentGroupRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public ConsumerOrderPaymentGroupRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public ConsumerOrderPaymentGroupRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest filterByBizOrder(ConsumerOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, ConsumerOrder::getId);
  }

  public ConsumerOrderPaymentGroupRequest filterByBizOrder(ConsumerOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(ConsumerOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderPaymentGroupRequest selectBizOrderId() {
    select(BIZ_ORDER_PROPERTY);
    return this;
  }

  public ConsumerOrderRequest upToBizOrder() {
    return upToBizOrder(ConsumerOrderRequest.newInstance());
  }

  public ConsumerOrderRequest upToBizOrder(ConsumerOrderRequest bizOrder) {
    bizOrder.aggregateChild(BIZ_ORDER_PROPERTY, this);
    this.groupByBizOrder(bizOrder);
    return bizOrder;
  }

  public ConsumerOrderRequest endAtBizOrder(String retName) {
    return endAtBizOrder(retName, ConsumerOrderRequest.newInstance());
  }

  public ConsumerOrderRequest endAtBizOrder(String retName, ConsumerOrderRequest bizOrder) {
    bizOrder.addDynamicProperty(retName, this, BIZ_ORDER_PROPERTY);
    return bizOrder;
  }

  public ConsumerOrderPaymentGroupRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public ConsumerOrderPaymentGroupRequest filterByBizOrder(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, ConsumerOrder.ID_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest selectBizOrder() {
    return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
  }

  public ConsumerOrderPaymentGroupRequest selectBizOrder(ConsumerOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest groupByBizOrder(ConsumerOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest aggregateBizOrder(ConsumerOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public ConsumerOrderPaymentGroupRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public ConsumerOrderPaymentGroupRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public ConsumerOrderPaymentGroupRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public ConsumerOrderPaymentGroupRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public ConsumerOrderPaymentGroupRequest unlimited() {
    super.unlimited();
    return this;
  }

  public ConsumerOrderPaymentGroupRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
