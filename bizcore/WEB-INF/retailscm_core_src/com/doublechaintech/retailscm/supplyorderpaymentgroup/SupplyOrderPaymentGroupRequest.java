package com.doublechaintech.retailscm.supplyorderpaymentgroup;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup.*;

public class SupplyOrderPaymentGroupRequest extends BaseRequest<SupplyOrderPaymentGroup> {
  public static SupplyOrderPaymentGroupRequest newInstance() {
    return new SupplyOrderPaymentGroupRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SupplyOrderPaymentGroupRequest resultByClass(
      Class<? extends SupplyOrderPaymentGroup> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SupplyOrderPaymentGroupRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SupplyOrderPaymentGroupRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SupplyOrderPaymentGroup";
  }

  public SupplyOrderPaymentGroupRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SupplyOrderPaymentGroupRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SupplyOrderPaymentGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SupplyOrderPaymentGroupRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SupplyOrderPaymentGroupRequest selectAll() {
    return this.selectId().selectName().selectBizOrder().selectCardNumber().selectVersion();
  }

  public SupplyOrderPaymentGroupRequest selectAny() {
    return selectAll();
  }

  public SupplyOrderPaymentGroupRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(CARD_NUMBER_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SupplyOrderPaymentGroupRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SupplyOrderPaymentGroupRequest where(
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

  public SupplyOrderPaymentGroupRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SupplyOrderPaymentGroupRequest comment(String comment) {
    return this;
  }

  public SupplyOrderPaymentGroupRequest enhance() {
    return this;
  }

  public SupplyOrderPaymentGroupRequest overrideClass(
      Class<? extends SupplyOrderPaymentGroup> clazz) {
    return this;
  }

  public SupplyOrderPaymentGroupRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SupplyOrderPaymentGroupRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SupplyOrderPaymentGroupRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SupplyOrderPaymentGroupRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SupplyOrderPaymentGroupRequest count() {
    return countId("count");
  }

  public static SupplyOrderPaymentGroupRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SupplyOrderPaymentGroupRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SupplyOrderPaymentGroupRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderPaymentGroupRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderPaymentGroupRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SupplyOrderPaymentGroupRequest countId() {
    return countId("countId");
  }

  public SupplyOrderPaymentGroupRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest maxId() {
    return maxId("maxId");
  }

  public SupplyOrderPaymentGroupRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest minId() {
    return minId("minId");
  }

  public SupplyOrderPaymentGroupRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SupplyOrderPaymentGroupRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SupplyOrderPaymentGroupRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public SupplyOrderPaymentGroupRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderPaymentGroupRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderPaymentGroupRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderPaymentGroupRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderPaymentGroupRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public SupplyOrderPaymentGroupRequest countName() {
    return countName("countName");
  }

  public SupplyOrderPaymentGroupRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest maxName() {
    return maxName("maxName");
  }

  public SupplyOrderPaymentGroupRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest minName() {
    return minName("minName");
  }

  public SupplyOrderPaymentGroupRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public SupplyOrderPaymentGroupRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public SupplyOrderPaymentGroupRequest filterByCardNumber(String cardNumber) {

    if (cardNumber == null) {
      return this;
    }

    return filterByCardNumber(QueryOperator.EQUAL, cardNumber);
  }

  public SupplyOrderPaymentGroupRequest whereCardNumberIsNull() {
    return where(CARD_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderPaymentGroupRequest whereCardNumberIsNotNull() {
    return where(CARD_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderPaymentGroupRequest filterByCardNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCardNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderPaymentGroupRequest selectCardNumber() {
    return select(CARD_NUMBER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest unselectCardNumber() {
    return unselect(CARD_NUMBER_PROPERTY);
  }

  public SearchCriteria getCardNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CARD_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderPaymentGroupRequest orderByCardNumber(boolean asc) {
    addOrderBy(CARD_NUMBER_PROPERTY, asc);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByCardNumberAscending() {
    addOrderBy(CARD_NUMBER_PROPERTY, true);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByCardNumberDescending() {
    addOrderBy(CARD_NUMBER_PROPERTY, false);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByCardNumberAscendingUsingGBK() {
    addOrderBy("convert(cardNumber using gbk)", true);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByCardNumberDescendingUsingGBK() {
    addOrderBy("convert(cardNumber using gbk)", false);
    return this;
  }

  public SupplyOrderPaymentGroupRequest countCardNumber() {
    return countCardNumber("countCardNumber");
  }

  public SupplyOrderPaymentGroupRequest countCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CARD_NUMBER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest maxCardNumber() {
    return maxCardNumber("maxCardNumber");
  }

  public SupplyOrderPaymentGroupRequest maxCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CARD_NUMBER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest minCardNumber() {
    return minCardNumber("minCardNumber");
  }

  public SupplyOrderPaymentGroupRequest minCardNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CARD_NUMBER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByCardNumber() {
    return groupByCardNumber(CARD_NUMBER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByCardNumber(String ret) {
    return groupBy(ret, CARD_NUMBER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByCardNumber(SqlFunction func) {
    return groupByCardNumber(CARD_NUMBER_PROPERTY, func);
  }

  public SupplyOrderPaymentGroupRequest groupByCardNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CARD_NUMBER_PROPERTY);
    return this;
  }

  public SupplyOrderPaymentGroupRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SupplyOrderPaymentGroupRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderPaymentGroupRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderPaymentGroupRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderPaymentGroupRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderPaymentGroupRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SupplyOrderPaymentGroupRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SupplyOrderPaymentGroupRequest countVersion() {
    return countVersion("countVersion");
  }

  public SupplyOrderPaymentGroupRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SupplyOrderPaymentGroupRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest minVersion() {
    return minVersion("minVersion");
  }

  public SupplyOrderPaymentGroupRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SupplyOrderPaymentGroupRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SupplyOrderPaymentGroupRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SupplyOrderPaymentGroupRequest filterByBizOrder(SupplyOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, SupplyOrder::getId);
  }

  public SupplyOrderPaymentGroupRequest filterByBizOrder(SupplyOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(SupplyOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public SupplyOrderPaymentGroupRequest selectBizOrderId() {
    select(BIZ_ORDER_PROPERTY);
    return this;
  }

  public SupplyOrderRequest upToBizOrder() {
    return upToBizOrder(SupplyOrderRequest.newInstance());
  }

  public SupplyOrderRequest upToBizOrder(SupplyOrderRequest bizOrder) {
    bizOrder.aggregateChild(BIZ_ORDER_PROPERTY, this);
    this.groupByBizOrder(bizOrder);
    return bizOrder;
  }

  public SupplyOrderRequest endAtBizOrder(String retName) {
    return endAtBizOrder(retName, SupplyOrderRequest.newInstance());
  }

  public SupplyOrderRequest endAtBizOrder(String retName, SupplyOrderRequest bizOrder) {
    bizOrder.addDynamicProperty(retName, this, BIZ_ORDER_PROPERTY);
    return bizOrder;
  }

  public SupplyOrderPaymentGroupRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public SupplyOrderPaymentGroupRequest filterByBizOrder(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
    return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine, SupplyOrder.ID_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest selectBizOrder() {
    return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
  }

  public SupplyOrderPaymentGroupRequest selectBizOrder(SupplyOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderPaymentGroupRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public SupplyOrderPaymentGroupRequest groupByBizOrder(SupplyOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderPaymentGroupRequest aggregateBizOrder(SupplyOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public SupplyOrderPaymentGroupRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public SupplyOrderPaymentGroupRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderPaymentGroupRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderPaymentGroupRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderPaymentGroupRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SupplyOrderPaymentGroupRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SupplyOrderPaymentGroupRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SupplyOrderPaymentGroupRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
