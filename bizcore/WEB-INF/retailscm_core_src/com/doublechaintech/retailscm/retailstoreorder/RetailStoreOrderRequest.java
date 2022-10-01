package com.doublechaintech.retailscm.retailstoreorder;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItemRequest;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroupRequest;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroupRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder.*;

public class RetailStoreOrderRequest extends BaseRequest<RetailStoreOrder> {
  public static RetailStoreOrderRequest newInstance() {
    return new RetailStoreOrderRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreOrderRequest resultByClass(Class<? extends RetailStoreOrder> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreOrderRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreOrderRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreOrder";
  }

  public RetailStoreOrderRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreOrderRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreOrderRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreOrderRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreOrderRequest selectAll() {
    return this.selectId()
        .selectBuyer()
        .selectSeller()
        .selectTitle()
        .selectTotalAmount()
        .selectContract()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public RetailStoreOrderRequest selectAny() {
    return selectAll()
        .selectRetailStoreOrderLineItemList(Q.retailStoreOrderLineItem().selectSelf())
        .selectRetailStoreOrderShippingGroupList(Q.retailStoreOrderShippingGroup().selectSelf())
        .selectRetailStoreOrderPaymentGroupList(Q.retailStoreOrderPaymentGroup().selectSelf())
        .selectGoodsList(Q.goods().selectSelf());
  }

  public RetailStoreOrderRequest selectSelf() {
    select(ID_PROPERTY);
    select(BUYER_PROPERTY);
    select(SELLER_PROPERTY);
    select(TITLE_PROPERTY);
    select(TOTAL_AMOUNT_PROPERTY);
    select(CONTRACT_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreOrderRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreOrderRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    BUYER_PROPERTY,
    SELLER_PROPERTY,
    TITLE_PROPERTY,
    TOTAL_AMOUNT_PROPERTY,
    CONTRACT_PROPERTY,
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

  public RetailStoreOrderRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreOrderRequest comment(String comment) {
    return this;
  }

  public RetailStoreOrderRequest enhance() {
    return this;
  }

  public RetailStoreOrderRequest overrideClass(Class<? extends RetailStoreOrder> clazz) {
    return this;
  }

  public RetailStoreOrderRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreOrderRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreOrderRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreOrderRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreOrderRequest count() {
    return countId("count");
  }

  public static RetailStoreOrderRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreOrderRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreOrderRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreOrderRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreOrderRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreOrderRequest countId() {
    return countId("countId");
  }

  public RetailStoreOrderRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreOrderRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreOrderRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreOrderRequest minId() {
    return minId("minId");
  }

  public RetailStoreOrderRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreOrderRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreOrderRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreOrderRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreOrderRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public RetailStoreOrderRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public RetailStoreOrderRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public RetailStoreOrderRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public RetailStoreOrderRequest countTitle() {
    return countTitle("countTitle");
  }

  public RetailStoreOrderRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public RetailStoreOrderRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public RetailStoreOrderRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public RetailStoreOrderRequest minTitle() {
    return minTitle("minTitle");
  }

  public RetailStoreOrderRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public RetailStoreOrderRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public RetailStoreOrderRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public RetailStoreOrderRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public RetailStoreOrderRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest filterByTotalAmount(BigDecimal totalAmount) {

    if (totalAmount == null) {
      return this;
    }

    return filterByTotalAmount(QueryOperator.EQUAL, totalAmount);
  }

  public RetailStoreOrderRequest whereTotalAmountIsNull() {
    return where(TOTAL_AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderRequest whereTotalAmountIsNotNull() {
    return where(TOTAL_AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderRequest whereTotalAmountBetween(
      BigDecimal totalAmountStart, BigDecimal totalAmountEnd) {
    if (ObjectUtil.isEmpty(totalAmountStart)) {
      throw new IllegalArgumentException(
          "Method whereTotalAmountBetween, the parameter totalAmountStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(totalAmountEnd)) {
      throw new IllegalArgumentException(
          "Method whereTotalAmountBetween, the parameter totalAmountEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTotalAmountSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {totalAmountStart, totalAmountEnd});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest whereTotalAmountLessThan(BigDecimal totalAmount) {
    if (ObjectUtil.isEmpty(totalAmount)) {
      throw new IllegalArgumentException(
          "Method whereTotalAmountLessThan, the parameter totalAmount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTotalAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {totalAmount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest whereTotalAmountGreaterThan(BigDecimal totalAmount) {
    if (ObjectUtil.isEmpty(totalAmount)) {
      throw new IllegalArgumentException(
          "Method whereTotalAmountGreaterThan, the parameter totalAmount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTotalAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {totalAmount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest filterByTotalAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest selectTotalAmount() {
    return select(TOTAL_AMOUNT_PROPERTY);
  }

  public RetailStoreOrderRequest unselectTotalAmount() {
    return unselect(TOTAL_AMOUNT_PROPERTY);
  }

  public SearchCriteria getTotalAmountSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderRequest orderByTotalAmount(boolean asc) {
    addOrderBy(TOTAL_AMOUNT_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderRequest orderByTotalAmountAscending() {
    addOrderBy(TOTAL_AMOUNT_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderRequest orderByTotalAmountDescending() {
    addOrderBy(TOTAL_AMOUNT_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderRequest countTotalAmount() {
    return countTotalAmount("countTotalAmount");
  }

  public RetailStoreOrderRequest countTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AMOUNT_PROPERTY);
  }

  public RetailStoreOrderRequest maxTotalAmount() {
    return maxTotalAmount("maxTotalAmount");
  }

  public RetailStoreOrderRequest maxTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AMOUNT_PROPERTY);
  }

  public RetailStoreOrderRequest minTotalAmount() {
    return minTotalAmount("minTotalAmount");
  }

  public RetailStoreOrderRequest minTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AMOUNT_PROPERTY);
  }

  public RetailStoreOrderRequest sumTotalAmount() {
    return sumTotalAmount("sumTotalAmount");
  }

  public RetailStoreOrderRequest sumTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, TOTAL_AMOUNT_PROPERTY);
  }

  public RetailStoreOrderRequest groupByTotalAmount() {
    return groupByTotalAmount(TOTAL_AMOUNT_PROPERTY);
  }

  public RetailStoreOrderRequest groupByTotalAmount(String ret) {
    return groupBy(ret, TOTAL_AMOUNT_PROPERTY);
  }

  public RetailStoreOrderRequest groupByTotalAmount(SqlFunction func) {
    return groupByTotalAmount(TOTAL_AMOUNT_PROPERTY, func);
  }

  public RetailStoreOrderRequest groupByTotalAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AMOUNT_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest filterByContract(String contract) {

    if (contract == null) {
      return this;
    }

    return filterByContract(QueryOperator.EQUAL, contract);
  }

  public RetailStoreOrderRequest whereContractIsNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderRequest whereContractIsNotNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderRequest filterByContract(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest selectContract() {
    return select(CONTRACT_PROPERTY);
  }

  public RetailStoreOrderRequest unselectContract() {
    return unselect(CONTRACT_PROPERTY);
  }

  public SearchCriteria getContractSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderRequest orderByContract(boolean asc) {
    addOrderBy(CONTRACT_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderRequest orderByContractAscending() {
    addOrderBy(CONTRACT_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderRequest orderByContractDescending() {
    addOrderBy(CONTRACT_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderRequest orderByContractAscendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", true);
    return this;
  }

  public RetailStoreOrderRequest orderByContractDescendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", false);
    return this;
  }

  public RetailStoreOrderRequest countContract() {
    return countContract("countContract");
  }

  public RetailStoreOrderRequest countContract(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTRACT_PROPERTY);
  }

  public RetailStoreOrderRequest maxContract() {
    return maxContract("maxContract");
  }

  public RetailStoreOrderRequest maxContract(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTRACT_PROPERTY);
  }

  public RetailStoreOrderRequest minContract() {
    return minContract("minContract");
  }

  public RetailStoreOrderRequest minContract(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTRACT_PROPERTY);
  }

  public RetailStoreOrderRequest groupByContract() {
    return groupByContract(CONTRACT_PROPERTY);
  }

  public RetailStoreOrderRequest groupByContract(String ret) {
    return groupBy(ret, CONTRACT_PROPERTY);
  }

  public RetailStoreOrderRequest groupByContract(SqlFunction func) {
    return groupByContract(CONTRACT_PROPERTY, func);
  }

  public RetailStoreOrderRequest groupByContract(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTRACT_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public RetailStoreOrderRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderRequest whereLastUpdateTimeBetween(
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

  public RetailStoreOrderRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreOrderRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public RetailStoreOrderRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreOrderRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public RetailStoreOrderRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreOrderRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public RetailStoreOrderRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreOrderRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreOrderRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreOrderRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public RetailStoreOrderRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreOrderRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreOrderRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreOrderRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreOrderRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreOrderRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreOrderRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreOrderRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreOrderRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreOrderRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreOrderRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreOrderRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreOrderRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreOrderRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreOrderRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreOrderRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreOrderRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreOrderRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreOrderRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest filterByBuyer(RetailStoreRequest buyer) {
    return filterByBuyer(buyer, RetailStore::getId);
  }

  public RetailStoreOrderRequest filterByBuyer(RetailStore... buyer) {
    if (isEmptyParam(buyer)) {
      throw new IllegalArgumentException("filterByBuyer(RetailStore... buyer)参数不能为空!");
    }
    return where(BUYER_PROPERTY, QueryOperator.IN, (Object[]) buyer);
  }

  public RetailStoreOrderRequest selectBuyerId() {
    select(BUYER_PROPERTY);
    return this;
  }

  public RetailStoreRequest upToBuyer() {
    return upToBuyer(RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest upToBuyer(RetailStoreRequest buyer) {
    buyer.aggregateChild(BUYER_PROPERTY, this);
    this.groupByBuyer(buyer);
    return buyer;
  }

  public RetailStoreRequest endAtBuyer(String retName) {
    return endAtBuyer(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreRequest endAtBuyer(String retName, RetailStoreRequest buyer) {
    buyer.addDynamicProperty(retName, this, BUYER_PROPERTY);
    return buyer;
  }

  public RetailStoreOrderRequest filterByBuyer(String... buyer) {
    if (isEmptyParam(buyer)) {
      throw new IllegalArgumentException("filterByBuyer(String... buyer)参数不能为空!");
    }
    return where(BUYER_PROPERTY, QueryOperator.IN, (Object[]) buyer);
  }

  public RetailStoreOrderRequest filterByBuyer(
      RetailStoreRequest buyer, IDRefine<RetailStore> idRefine) {
    buyer.unlimited();
    return addSearchCriteria(createBuyerCriteria(buyer, idRefine));
  }

  public SearchCriteria createBuyerCriteria(
      RetailStoreRequest buyer, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(buyer, BUYER_PROPERTY, idRefine, RetailStore.ID_PROPERTY);
  }

  public RetailStoreOrderRequest selectBuyer() {
    return selectBuyer(RetailStoreRequest.newInstance().selectSelf());
  }

  public RetailStoreOrderRequest selectBuyer(RetailStoreRequest buyer) {
    selectParent(BUYER_PROPERTY, buyer);
    return this;
  }

  public RetailStoreOrderRequest unselectBuyer() {
    unselectParent(BUYER_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest groupByBuyer(RetailStoreRequest buyer) {
    groupBy(BUYER_PROPERTY, buyer);
    return this;
  }

  public RetailStoreOrderRequest aggregateBuyer(RetailStoreRequest buyer) {
    aggregateParent(BUYER_PROPERTY, buyer);
    return this;
  }

  public RetailStoreOrderRequest countBuyer() {
    return countBuyer("countBuyer");
  }

  public RetailStoreOrderRequest countBuyer(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BUYER_PROPERTY);
  }

  public RetailStoreOrderRequest groupByBuyer() {
    return groupByBuyer(BUYER_PROPERTY);
  }

  public RetailStoreOrderRequest groupByBuyer(String ret) {
    return groupBy(ret, BUYER_PROPERTY);
  }

  public RetailStoreOrderRequest whereBuyerIsNull() {
    return where(BUYER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderRequest whereBuyerIsNotNull() {
    return where(BUYER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderRequest filterBySeller(RetailStoreCountryCenterRequest seller) {
    return filterBySeller(seller, RetailStoreCountryCenter::getId);
  }

  public RetailStoreOrderRequest filterBySeller(RetailStoreCountryCenter... seller) {
    if (isEmptyParam(seller)) {
      throw new IllegalArgumentException(
          "filterBySeller(RetailStoreCountryCenter... seller)参数不能为空!");
    }
    return where(SELLER_PROPERTY, QueryOperator.IN, (Object[]) seller);
  }

  public RetailStoreOrderRequest selectSellerId() {
    select(SELLER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToSeller() {
    return upToSeller(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToSeller(RetailStoreCountryCenterRequest seller) {
    seller.aggregateChild(SELLER_PROPERTY, this);
    this.groupBySeller(seller);
    return seller;
  }

  public RetailStoreCountryCenterRequest endAtSeller(String retName) {
    return endAtSeller(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtSeller(
      String retName, RetailStoreCountryCenterRequest seller) {
    seller.addDynamicProperty(retName, this, SELLER_PROPERTY);
    return seller;
  }

  public RetailStoreOrderRequest filterBySeller(String... seller) {
    if (isEmptyParam(seller)) {
      throw new IllegalArgumentException("filterBySeller(String... seller)参数不能为空!");
    }
    return where(SELLER_PROPERTY, QueryOperator.IN, (Object[]) seller);
  }

  public RetailStoreOrderRequest filterBySeller(
      RetailStoreCountryCenterRequest seller, IDRefine<RetailStoreCountryCenter> idRefine) {
    seller.unlimited();
    return addSearchCriteria(createSellerCriteria(seller, idRefine));
  }

  public SearchCriteria createSellerCriteria(
      RetailStoreCountryCenterRequest seller, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        seller, SELLER_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public RetailStoreOrderRequest selectSeller() {
    return selectSeller(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public RetailStoreOrderRequest selectSeller(RetailStoreCountryCenterRequest seller) {
    selectParent(SELLER_PROPERTY, seller);
    return this;
  }

  public RetailStoreOrderRequest unselectSeller() {
    unselectParent(SELLER_PROPERTY);
    return this;
  }

  public RetailStoreOrderRequest groupBySeller(RetailStoreCountryCenterRequest seller) {
    groupBy(SELLER_PROPERTY, seller);
    return this;
  }

  public RetailStoreOrderRequest aggregateSeller(RetailStoreCountryCenterRequest seller) {
    aggregateParent(SELLER_PROPERTY, seller);
    return this;
  }

  public RetailStoreOrderRequest countSeller() {
    return countSeller("countSeller");
  }

  public RetailStoreOrderRequest countSeller(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SELLER_PROPERTY);
  }

  public RetailStoreOrderRequest groupBySeller() {
    return groupBySeller(SELLER_PROPERTY);
  }

  public RetailStoreOrderRequest groupBySeller(String ret) {
    return groupBy(ret, SELLER_PROPERTY);
  }

  public RetailStoreOrderRequest whereSellerIsNull() {
    return where(SELLER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreOrderRequest whereSellerIsNotNull() {
    return where(SELLER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreOrderRequest hasRetailStoreOrderLineItem() {
    return hasRetailStoreOrderLineItem(RetailStoreOrderLineItemRequest.newInstance());
  }

  public RetailStoreOrderRequest hasRetailStoreOrderLineItem(
      RetailStoreOrderLineItem... retailStoreOrderLineItem) {
    if (isEmptyParam(retailStoreOrderLineItem)) {
      throw new IllegalArgumentException(
          "hasRetailStoreOrderLineItem(RetailStoreOrderLineItem... retailStoreOrderLineItem)参数不能为空!");
    }
    return hasRetailStoreOrderLineItem(
        Q.retailStoreOrderLineItem()
            .select(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreOrderLineItem));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderLineItem(String... retailStoreOrderLineItem) {
    return hasRetailStoreOrderLineItem(
        Q.retailStoreOrderLineItem()
            .select(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY)
            .filterById(retailStoreOrderLineItem));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderLineItem(
      RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
    return hasRetailStoreOrderLineItem(
        retailStoreOrderLineItem,
        $retailStoreOrderLineItem ->
            java.util.Optional.of($retailStoreOrderLineItem)
                .map(RetailStoreOrderLineItem::getBizOrder)
                .map(RetailStoreOrder::getId)
                .orElse(null));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderLineItem(
      RetailStoreOrderLineItemRequest retailStoreOrderLineItem,
      IDRefine<RetailStoreOrderLineItem> idRefine) {
    retailStoreOrderLineItem.select(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY);
    retailStoreOrderLineItem.unlimited();
    return addSearchCriteria(
        createRetailStoreOrderLineItemCriteria(retailStoreOrderLineItem, idRefine));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderLineItem(
      RetailStoreOrderLineItemRequest retailStoreOrderLineItem,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreOrderLineItem,
            RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreOrderLineItemCriteria(
      RetailStoreOrderLineItemRequest retailStoreOrderLineItem,
      IDRefine<RetailStoreOrderLineItem> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreOrderLineItem,
        ID_PROPERTY,
        idRefine,
        RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest selectRetailStoreOrderLineItemList(
      RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
    selectChild(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, retailStoreOrderLineItem);
    return this;
  }

  public RetailStoreOrderRequest selectRetailStoreOrderLineItemList() {
    return selectRetailStoreOrderLineItemList(
        RetailStoreOrderLineItemRequest.newInstance().selectAll());
  }

  public RetailStoreOrderRequest unselectRetailStoreOrderLineItemList() {
    unselectChild(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, RetailStoreOrderLineItem.class);
    return this;
  }

  public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup() {
    return hasRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroupRequest.newInstance());
  }

  public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup(
      RetailStoreOrderShippingGroup... retailStoreOrderShippingGroup) {
    if (isEmptyParam(retailStoreOrderShippingGroup)) {
      throw new IllegalArgumentException(
          "hasRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup... retailStoreOrderShippingGroup)参数不能为空!");
    }
    return hasRetailStoreOrderShippingGroup(
        Q.retailStoreOrderShippingGroup()
            .select(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreOrderShippingGroup));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup(
      String... retailStoreOrderShippingGroup) {
    return hasRetailStoreOrderShippingGroup(
        Q.retailStoreOrderShippingGroup()
            .select(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY)
            .filterById(retailStoreOrderShippingGroup));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup(
      RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
    return hasRetailStoreOrderShippingGroup(
        retailStoreOrderShippingGroup,
        $retailStoreOrderShippingGroup ->
            java.util.Optional.of($retailStoreOrderShippingGroup)
                .map(RetailStoreOrderShippingGroup::getBizOrder)
                .map(RetailStoreOrder::getId)
                .orElse(null));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup(
      RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup,
      IDRefine<RetailStoreOrderShippingGroup> idRefine) {
    retailStoreOrderShippingGroup.select(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY);
    retailStoreOrderShippingGroup.unlimited();
    return addSearchCriteria(
        createRetailStoreOrderShippingGroupCriteria(retailStoreOrderShippingGroup, idRefine));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderShippingGroup(
      RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreOrderShippingGroup,
            RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreOrderShippingGroupCriteria(
      RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup,
      IDRefine<RetailStoreOrderShippingGroup> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreOrderShippingGroup,
        ID_PROPERTY,
        idRefine,
        RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest selectRetailStoreOrderShippingGroupList(
      RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
    selectChild(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, retailStoreOrderShippingGroup);
    return this;
  }

  public RetailStoreOrderRequest selectRetailStoreOrderShippingGroupList() {
    return selectRetailStoreOrderShippingGroupList(
        RetailStoreOrderShippingGroupRequest.newInstance().selectAll());
  }

  public RetailStoreOrderRequest unselectRetailStoreOrderShippingGroupList() {
    unselectChild(
        RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, RetailStoreOrderShippingGroup.class);
    return this;
  }

  public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup() {
    return hasRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroupRequest.newInstance());
  }

  public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup(
      RetailStoreOrderPaymentGroup... retailStoreOrderPaymentGroup) {
    if (isEmptyParam(retailStoreOrderPaymentGroup)) {
      throw new IllegalArgumentException(
          "hasRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup... retailStoreOrderPaymentGroup)参数不能为空!");
    }
    return hasRetailStoreOrderPaymentGroup(
        Q.retailStoreOrderPaymentGroup()
            .select(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreOrderPaymentGroup));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup(
      String... retailStoreOrderPaymentGroup) {
    return hasRetailStoreOrderPaymentGroup(
        Q.retailStoreOrderPaymentGroup()
            .select(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY)
            .filterById(retailStoreOrderPaymentGroup));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup(
      RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
    return hasRetailStoreOrderPaymentGroup(
        retailStoreOrderPaymentGroup,
        $retailStoreOrderPaymentGroup ->
            java.util.Optional.of($retailStoreOrderPaymentGroup)
                .map(RetailStoreOrderPaymentGroup::getBizOrder)
                .map(RetailStoreOrder::getId)
                .orElse(null));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup(
      RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup,
      IDRefine<RetailStoreOrderPaymentGroup> idRefine) {
    retailStoreOrderPaymentGroup.select(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY);
    retailStoreOrderPaymentGroup.unlimited();
    return addSearchCriteria(
        createRetailStoreOrderPaymentGroupCriteria(retailStoreOrderPaymentGroup, idRefine));
  }

  public RetailStoreOrderRequest hasRetailStoreOrderPaymentGroup(
      RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreOrderPaymentGroup,
            RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreOrderPaymentGroupCriteria(
      RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup,
      IDRefine<RetailStoreOrderPaymentGroup> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreOrderPaymentGroup,
        ID_PROPERTY,
        idRefine,
        RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest selectRetailStoreOrderPaymentGroupList(
      RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
    selectChild(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, retailStoreOrderPaymentGroup);
    return this;
  }

  public RetailStoreOrderRequest selectRetailStoreOrderPaymentGroupList() {
    return selectRetailStoreOrderPaymentGroupList(
        RetailStoreOrderPaymentGroupRequest.newInstance().selectAll());
  }

  public RetailStoreOrderRequest unselectRetailStoreOrderPaymentGroupList() {
    unselectChild(
        RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, RetailStoreOrderPaymentGroup.class);
    return this;
  }

  public RetailStoreOrderRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public RetailStoreOrderRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods()
            .select(Goods.RETAIL_STORE_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goods));
  }

  public RetailStoreOrderRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.RETAIL_STORE_ORDER_PROPERTY).filterById(goods));
  }

  public RetailStoreOrderRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getRetailStoreOrder)
                .map(RetailStoreOrder::getId)
                .orElse(null));
  }

  public RetailStoreOrderRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.RETAIL_STORE_ORDER_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public RetailStoreOrderRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.RETAIL_STORE_ORDER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.RETAIL_STORE_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.RETAIL_STORE_ORDER_PROPERTY, goods);
    return this;
  }

  public RetailStoreOrderRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public RetailStoreOrderRequest unselectGoodsList() {
    unselectChild(Goods.RETAIL_STORE_ORDER_PROPERTY, Goods.class);
    return this;
  }

  public RetailStoreOrderRequest aggregateRetailStoreOrderLineItemList(
      RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
    aggregateChild(RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY, retailStoreOrderLineItem);
    return this;
  }

  public RetailStoreOrderRequest countRetailStoreOrderLineItem() {
    return countRetailStoreOrderLineItem("retailStoreOrderLineItemCount");
  }

  public RetailStoreOrderRequest countRetailStoreOrderLineItem(String retName) {
    return countRetailStoreOrderLineItem(retName, RetailStoreOrderLineItemRequest.newInstance());
  }

  public RetailStoreOrderRequest countRetailStoreOrderLineItem(
      RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
    return countRetailStoreOrderLineItem("retailStoreOrderLineItemCount", retailStoreOrderLineItem);
  }

  public RetailStoreOrderRequest countRetailStoreOrderLineItem(
      String retName, RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
    retailStoreOrderLineItem.count();
    return statsFromRetailStoreOrderLineItem(retName, retailStoreOrderLineItem);
  }

  public RetailStoreOrderRequest statsFromRetailStoreOrderLineItem(
      String retName, RetailStoreOrderLineItemRequest retailStoreOrderLineItem) {
    return addDynamicProperty(
        retName, retailStoreOrderLineItem, RetailStoreOrderLineItem.BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest aggregateRetailStoreOrderShippingGroupList(
      RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
    aggregateChild(RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY, retailStoreOrderShippingGroup);
    return this;
  }

  public RetailStoreOrderRequest countRetailStoreOrderShippingGroup() {
    return countRetailStoreOrderShippingGroup("retailStoreOrderShippingGroupCount");
  }

  public RetailStoreOrderRequest countRetailStoreOrderShippingGroup(String retName) {
    return countRetailStoreOrderShippingGroup(
        retName, RetailStoreOrderShippingGroupRequest.newInstance());
  }

  public RetailStoreOrderRequest countRetailStoreOrderShippingGroup(
      RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
    return countRetailStoreOrderShippingGroup(
        "retailStoreOrderShippingGroupCount", retailStoreOrderShippingGroup);
  }

  public RetailStoreOrderRequest countRetailStoreOrderShippingGroup(
      String retName, RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
    retailStoreOrderShippingGroup.count();
    return statsFromRetailStoreOrderShippingGroup(retName, retailStoreOrderShippingGroup);
  }

  public RetailStoreOrderRequest statsFromRetailStoreOrderShippingGroup(
      String retName, RetailStoreOrderShippingGroupRequest retailStoreOrderShippingGroup) {
    return addDynamicProperty(
        retName, retailStoreOrderShippingGroup, RetailStoreOrderShippingGroup.BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest aggregateRetailStoreOrderPaymentGroupList(
      RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
    aggregateChild(RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY, retailStoreOrderPaymentGroup);
    return this;
  }

  public RetailStoreOrderRequest countRetailStoreOrderPaymentGroup() {
    return countRetailStoreOrderPaymentGroup("retailStoreOrderPaymentGroupCount");
  }

  public RetailStoreOrderRequest countRetailStoreOrderPaymentGroup(String retName) {
    return countRetailStoreOrderPaymentGroup(
        retName, RetailStoreOrderPaymentGroupRequest.newInstance());
  }

  public RetailStoreOrderRequest countRetailStoreOrderPaymentGroup(
      RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
    return countRetailStoreOrderPaymentGroup(
        "retailStoreOrderPaymentGroupCount", retailStoreOrderPaymentGroup);
  }

  public RetailStoreOrderRequest countRetailStoreOrderPaymentGroup(
      String retName, RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
    retailStoreOrderPaymentGroup.count();
    return statsFromRetailStoreOrderPaymentGroup(retName, retailStoreOrderPaymentGroup);
  }

  public RetailStoreOrderRequest statsFromRetailStoreOrderPaymentGroup(
      String retName, RetailStoreOrderPaymentGroupRequest retailStoreOrderPaymentGroup) {
    return addDynamicProperty(
        retName, retailStoreOrderPaymentGroup, RetailStoreOrderPaymentGroup.BIZ_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.RETAIL_STORE_ORDER_PROPERTY, goods);
    return this;
  }

  public RetailStoreOrderRequest countGoods() {
    return countGoods("goodsCount");
  }

  public RetailStoreOrderRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public RetailStoreOrderRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public RetailStoreOrderRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public RetailStoreOrderRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.RETAIL_STORE_ORDER_PROPERTY);
  }

  public RetailStoreOrderRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreOrderRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreOrderRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreOrderRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
