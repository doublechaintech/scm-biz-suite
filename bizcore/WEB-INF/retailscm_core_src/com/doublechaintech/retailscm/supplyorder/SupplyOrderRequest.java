package com.doublechaintech.retailscm.supplyorder;

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
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItemRequest;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroupRequest;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroupRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplyorder.SupplyOrder.*;

public class SupplyOrderRequest extends BaseRequest<SupplyOrder> {
  public static SupplyOrderRequest newInstance() {
    return new SupplyOrderRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SupplyOrderRequest resultByClass(Class<? extends SupplyOrder> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SupplyOrderRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SupplyOrderRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "SupplyOrder";
  }

  public SupplyOrderRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SupplyOrderRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SupplyOrderRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SupplyOrderRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SupplyOrderRequest selectAll() {
    return this.selectId()
        .selectBuyer()
        .selectSeller()
        .selectTitle()
        .selectContract()
        .selectTotalAmount()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public SupplyOrderRequest selectAny() {
    return selectAll()
        .selectSupplyOrderLineItemList(Q.supplyOrderLineItem().selectSelf())
        .selectSupplyOrderShippingGroupList(Q.supplyOrderShippingGroup().selectSelf())
        .selectSupplyOrderPaymentGroupList(Q.supplyOrderPaymentGroup().selectSelf())
        .selectGoodsList(Q.goods().selectSelf());
  }

  public SupplyOrderRequest selectSelf() {
    select(ID_PROPERTY);
    select(BUYER_PROPERTY);
    select(SELLER_PROPERTY);
    select(TITLE_PROPERTY);
    select(CONTRACT_PROPERTY);
    select(TOTAL_AMOUNT_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SupplyOrderRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SupplyOrderRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
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
    CONTRACT_PROPERTY,
    TOTAL_AMOUNT_PROPERTY,
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

  public SupplyOrderRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SupplyOrderRequest comment(String comment) {
    return this;
  }

  public SupplyOrderRequest enhance() {
    return this;
  }

  public SupplyOrderRequest overrideClass(Class<? extends SupplyOrder> clazz) {
    return this;
  }

  public SupplyOrderRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SupplyOrderRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SupplyOrderRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SupplyOrderRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SupplyOrderRequest count() {
    return countId("count");
  }

  public static SupplyOrderRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SupplyOrderRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SupplyOrderRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SupplyOrderRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SupplyOrderRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SupplyOrderRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SupplyOrderRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SupplyOrderRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SupplyOrderRequest countId() {
    return countId("countId");
  }

  public SupplyOrderRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SupplyOrderRequest maxId() {
    return maxId("maxId");
  }

  public SupplyOrderRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SupplyOrderRequest minId() {
    return minId("minId");
  }

  public SupplyOrderRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SupplyOrderRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SupplyOrderRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SupplyOrderRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SupplyOrderRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SupplyOrderRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public SupplyOrderRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public SupplyOrderRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public SupplyOrderRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public SupplyOrderRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public SupplyOrderRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public SupplyOrderRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public SupplyOrderRequest countTitle() {
    return countTitle("countTitle");
  }

  public SupplyOrderRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public SupplyOrderRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public SupplyOrderRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public SupplyOrderRequest minTitle() {
    return minTitle("minTitle");
  }

  public SupplyOrderRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public SupplyOrderRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public SupplyOrderRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public SupplyOrderRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public SupplyOrderRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public SupplyOrderRequest filterByContract(String contract) {

    if (contract == null) {
      return this;
    }

    return filterByContract(QueryOperator.EQUAL, contract);
  }

  public SupplyOrderRequest whereContractIsNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderRequest whereContractIsNotNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderRequest filterByContract(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest selectContract() {
    return select(CONTRACT_PROPERTY);
  }

  public SupplyOrderRequest unselectContract() {
    return unselect(CONTRACT_PROPERTY);
  }

  public SearchCriteria getContractSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderRequest orderByContract(boolean asc) {
    addOrderBy(CONTRACT_PROPERTY, asc);
    return this;
  }

  public SupplyOrderRequest orderByContractAscending() {
    addOrderBy(CONTRACT_PROPERTY, true);
    return this;
  }

  public SupplyOrderRequest orderByContractDescending() {
    addOrderBy(CONTRACT_PROPERTY, false);
    return this;
  }

  public SupplyOrderRequest orderByContractAscendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", true);
    return this;
  }

  public SupplyOrderRequest orderByContractDescendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", false);
    return this;
  }

  public SupplyOrderRequest countContract() {
    return countContract("countContract");
  }

  public SupplyOrderRequest countContract(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTRACT_PROPERTY);
  }

  public SupplyOrderRequest maxContract() {
    return maxContract("maxContract");
  }

  public SupplyOrderRequest maxContract(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTRACT_PROPERTY);
  }

  public SupplyOrderRequest minContract() {
    return minContract("minContract");
  }

  public SupplyOrderRequest minContract(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTRACT_PROPERTY);
  }

  public SupplyOrderRequest groupByContract() {
    return groupByContract(CONTRACT_PROPERTY);
  }

  public SupplyOrderRequest groupByContract(String ret) {
    return groupBy(ret, CONTRACT_PROPERTY);
  }

  public SupplyOrderRequest groupByContract(SqlFunction func) {
    return groupByContract(CONTRACT_PROPERTY, func);
  }

  public SupplyOrderRequest groupByContract(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTRACT_PROPERTY);
    return this;
  }

  public SupplyOrderRequest filterByTotalAmount(BigDecimal totalAmount) {

    if (totalAmount == null) {
      return this;
    }

    return filterByTotalAmount(QueryOperator.EQUAL, totalAmount);
  }

  public SupplyOrderRequest whereTotalAmountIsNull() {
    return where(TOTAL_AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderRequest whereTotalAmountIsNotNull() {
    return where(TOTAL_AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderRequest whereTotalAmountBetween(
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

  public SupplyOrderRequest whereTotalAmountLessThan(BigDecimal totalAmount) {
    if (ObjectUtil.isEmpty(totalAmount)) {
      throw new IllegalArgumentException(
          "Method whereTotalAmountLessThan, the parameter totalAmount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTotalAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {totalAmount});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest whereTotalAmountGreaterThan(BigDecimal totalAmount) {
    if (ObjectUtil.isEmpty(totalAmount)) {
      throw new IllegalArgumentException(
          "Method whereTotalAmountGreaterThan, the parameter totalAmount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getTotalAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {totalAmount});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest filterByTotalAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTotalAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest selectTotalAmount() {
    return select(TOTAL_AMOUNT_PROPERTY);
  }

  public SupplyOrderRequest unselectTotalAmount() {
    return unselect(TOTAL_AMOUNT_PROPERTY);
  }

  public SearchCriteria getTotalAmountSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TOTAL_AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderRequest orderByTotalAmount(boolean asc) {
    addOrderBy(TOTAL_AMOUNT_PROPERTY, asc);
    return this;
  }

  public SupplyOrderRequest orderByTotalAmountAscending() {
    addOrderBy(TOTAL_AMOUNT_PROPERTY, true);
    return this;
  }

  public SupplyOrderRequest orderByTotalAmountDescending() {
    addOrderBy(TOTAL_AMOUNT_PROPERTY, false);
    return this;
  }

  public SupplyOrderRequest countTotalAmount() {
    return countTotalAmount("countTotalAmount");
  }

  public SupplyOrderRequest countTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TOTAL_AMOUNT_PROPERTY);
  }

  public SupplyOrderRequest maxTotalAmount() {
    return maxTotalAmount("maxTotalAmount");
  }

  public SupplyOrderRequest maxTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TOTAL_AMOUNT_PROPERTY);
  }

  public SupplyOrderRequest minTotalAmount() {
    return minTotalAmount("minTotalAmount");
  }

  public SupplyOrderRequest minTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TOTAL_AMOUNT_PROPERTY);
  }

  public SupplyOrderRequest sumTotalAmount() {
    return sumTotalAmount("sumTotalAmount");
  }

  public SupplyOrderRequest sumTotalAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, TOTAL_AMOUNT_PROPERTY);
  }

  public SupplyOrderRequest groupByTotalAmount() {
    return groupByTotalAmount(TOTAL_AMOUNT_PROPERTY);
  }

  public SupplyOrderRequest groupByTotalAmount(String ret) {
    return groupBy(ret, TOTAL_AMOUNT_PROPERTY);
  }

  public SupplyOrderRequest groupByTotalAmount(SqlFunction func) {
    return groupByTotalAmount(TOTAL_AMOUNT_PROPERTY, func);
  }

  public SupplyOrderRequest groupByTotalAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, TOTAL_AMOUNT_PROPERTY);
    return this;
  }

  public SupplyOrderRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public SupplyOrderRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderRequest whereLastUpdateTimeBetween(
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

  public SupplyOrderRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public SupplyOrderRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public SupplyOrderRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public SupplyOrderRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public SupplyOrderRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public SupplyOrderRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public SupplyOrderRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public SupplyOrderRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public SupplyOrderRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public SupplyOrderRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public SupplyOrderRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public SupplyOrderRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public SupplyOrderRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public SupplyOrderRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public SupplyOrderRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SupplyOrderRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SupplyOrderRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SupplyOrderRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SupplyOrderRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SupplyOrderRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SupplyOrderRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SupplyOrderRequest countVersion() {
    return countVersion("countVersion");
  }

  public SupplyOrderRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SupplyOrderRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SupplyOrderRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SupplyOrderRequest minVersion() {
    return minVersion("minVersion");
  }

  public SupplyOrderRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SupplyOrderRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SupplyOrderRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SupplyOrderRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SupplyOrderRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SupplyOrderRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SupplyOrderRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SupplyOrderRequest filterByBuyer(RetailStoreCountryCenterRequest buyer) {
    return filterByBuyer(buyer, RetailStoreCountryCenter::getId);
  }

  public SupplyOrderRequest filterByBuyer(RetailStoreCountryCenter... buyer) {
    if (isEmptyParam(buyer)) {
      throw new IllegalArgumentException("filterByBuyer(RetailStoreCountryCenter... buyer)参数不能为空!");
    }
    return where(BUYER_PROPERTY, QueryOperator.IN, (Object[]) buyer);
  }

  public SupplyOrderRequest selectBuyerId() {
    select(BUYER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToBuyer() {
    return upToBuyer(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToBuyer(RetailStoreCountryCenterRequest buyer) {
    buyer.aggregateChild(BUYER_PROPERTY, this);
    this.groupByBuyer(buyer);
    return buyer;
  }

  public RetailStoreCountryCenterRequest endAtBuyer(String retName) {
    return endAtBuyer(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtBuyer(
      String retName, RetailStoreCountryCenterRequest buyer) {
    buyer.addDynamicProperty(retName, this, BUYER_PROPERTY);
    return buyer;
  }

  public SupplyOrderRequest filterByBuyer(String... buyer) {
    if (isEmptyParam(buyer)) {
      throw new IllegalArgumentException("filterByBuyer(String... buyer)参数不能为空!");
    }
    return where(BUYER_PROPERTY, QueryOperator.IN, (Object[]) buyer);
  }

  public SupplyOrderRequest filterByBuyer(
      RetailStoreCountryCenterRequest buyer, IDRefine<RetailStoreCountryCenter> idRefine) {
    buyer.unlimited();
    return addSearchCriteria(createBuyerCriteria(buyer, idRefine));
  }

  public SearchCriteria createBuyerCriteria(
      RetailStoreCountryCenterRequest buyer, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        buyer, BUYER_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public SupplyOrderRequest selectBuyer() {
    return selectBuyer(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public SupplyOrderRequest selectBuyer(RetailStoreCountryCenterRequest buyer) {
    selectParent(BUYER_PROPERTY, buyer);
    return this;
  }

  public SupplyOrderRequest unselectBuyer() {
    unselectParent(BUYER_PROPERTY);
    return this;
  }

  public SupplyOrderRequest groupByBuyer(RetailStoreCountryCenterRequest buyer) {
    groupBy(BUYER_PROPERTY, buyer);
    return this;
  }

  public SupplyOrderRequest aggregateBuyer(RetailStoreCountryCenterRequest buyer) {
    aggregateParent(BUYER_PROPERTY, buyer);
    return this;
  }

  public SupplyOrderRequest countBuyer() {
    return countBuyer("countBuyer");
  }

  public SupplyOrderRequest countBuyer(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BUYER_PROPERTY);
  }

  public SupplyOrderRequest groupByBuyer() {
    return groupByBuyer(BUYER_PROPERTY);
  }

  public SupplyOrderRequest groupByBuyer(String ret) {
    return groupBy(ret, BUYER_PROPERTY);
  }

  public SupplyOrderRequest whereBuyerIsNull() {
    return where(BUYER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderRequest whereBuyerIsNotNull() {
    return where(BUYER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderRequest filterBySeller(GoodsSupplierRequest seller) {
    return filterBySeller(seller, GoodsSupplier::getId);
  }

  public SupplyOrderRequest filterBySeller(GoodsSupplier... seller) {
    if (isEmptyParam(seller)) {
      throw new IllegalArgumentException("filterBySeller(GoodsSupplier... seller)参数不能为空!");
    }
    return where(SELLER_PROPERTY, QueryOperator.IN, (Object[]) seller);
  }

  public SupplyOrderRequest selectSellerId() {
    select(SELLER_PROPERTY);
    return this;
  }

  public GoodsSupplierRequest upToSeller() {
    return upToSeller(GoodsSupplierRequest.newInstance());
  }

  public GoodsSupplierRequest upToSeller(GoodsSupplierRequest seller) {
    seller.aggregateChild(SELLER_PROPERTY, this);
    this.groupBySeller(seller);
    return seller;
  }

  public GoodsSupplierRequest endAtSeller(String retName) {
    return endAtSeller(retName, GoodsSupplierRequest.newInstance());
  }

  public GoodsSupplierRequest endAtSeller(String retName, GoodsSupplierRequest seller) {
    seller.addDynamicProperty(retName, this, SELLER_PROPERTY);
    return seller;
  }

  public SupplyOrderRequest filterBySeller(String... seller) {
    if (isEmptyParam(seller)) {
      throw new IllegalArgumentException("filterBySeller(String... seller)参数不能为空!");
    }
    return where(SELLER_PROPERTY, QueryOperator.IN, (Object[]) seller);
  }

  public SupplyOrderRequest filterBySeller(
      GoodsSupplierRequest seller, IDRefine<GoodsSupplier> idRefine) {
    seller.unlimited();
    return addSearchCriteria(createSellerCriteria(seller, idRefine));
  }

  public SearchCriteria createSellerCriteria(
      GoodsSupplierRequest seller, IDRefine<GoodsSupplier> idRefine) {
    return new RefinedIdInCriteria(seller, SELLER_PROPERTY, idRefine, GoodsSupplier.ID_PROPERTY);
  }

  public SupplyOrderRequest selectSeller() {
    return selectSeller(GoodsSupplierRequest.newInstance().selectSelf());
  }

  public SupplyOrderRequest selectSeller(GoodsSupplierRequest seller) {
    selectParent(SELLER_PROPERTY, seller);
    return this;
  }

  public SupplyOrderRequest unselectSeller() {
    unselectParent(SELLER_PROPERTY);
    return this;
  }

  public SupplyOrderRequest groupBySeller(GoodsSupplierRequest seller) {
    groupBy(SELLER_PROPERTY, seller);
    return this;
  }

  public SupplyOrderRequest aggregateSeller(GoodsSupplierRequest seller) {
    aggregateParent(SELLER_PROPERTY, seller);
    return this;
  }

  public SupplyOrderRequest countSeller() {
    return countSeller("countSeller");
  }

  public SupplyOrderRequest countSeller(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SELLER_PROPERTY);
  }

  public SupplyOrderRequest groupBySeller() {
    return groupBySeller(SELLER_PROPERTY);
  }

  public SupplyOrderRequest groupBySeller(String ret) {
    return groupBy(ret, SELLER_PROPERTY);
  }

  public SupplyOrderRequest whereSellerIsNull() {
    return where(SELLER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SupplyOrderRequest whereSellerIsNotNull() {
    return where(SELLER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SupplyOrderRequest hasSupplyOrderLineItem() {
    return hasSupplyOrderLineItem(SupplyOrderLineItemRequest.newInstance());
  }

  public SupplyOrderRequest hasSupplyOrderLineItem(SupplyOrderLineItem... supplyOrderLineItem) {
    if (isEmptyParam(supplyOrderLineItem)) {
      throw new IllegalArgumentException(
          "hasSupplyOrderLineItem(SupplyOrderLineItem... supplyOrderLineItem)参数不能为空!");
    }
    return hasSupplyOrderLineItem(
        Q.supplyOrderLineItem()
            .select(SupplyOrderLineItem.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) supplyOrderLineItem));
  }

  public SupplyOrderRequest hasSupplyOrderLineItem(String... supplyOrderLineItem) {
    return hasSupplyOrderLineItem(
        Q.supplyOrderLineItem()
            .select(SupplyOrderLineItem.BIZ_ORDER_PROPERTY)
            .filterById(supplyOrderLineItem));
  }

  public SupplyOrderRequest hasSupplyOrderLineItem(SupplyOrderLineItemRequest supplyOrderLineItem) {
    return hasSupplyOrderLineItem(
        supplyOrderLineItem,
        $supplyOrderLineItem ->
            java.util.Optional.of($supplyOrderLineItem)
                .map(SupplyOrderLineItem::getBizOrder)
                .map(SupplyOrder::getId)
                .orElse(null));
  }

  public SupplyOrderRequest hasSupplyOrderLineItem(
      SupplyOrderLineItemRequest supplyOrderLineItem, IDRefine<SupplyOrderLineItem> idRefine) {
    supplyOrderLineItem.select(SupplyOrderLineItem.BIZ_ORDER_PROPERTY);
    supplyOrderLineItem.unlimited();
    return addSearchCriteria(createSupplyOrderLineItemCriteria(supplyOrderLineItem, idRefine));
  }

  public SupplyOrderRequest hasSupplyOrderLineItem(
      SupplyOrderLineItemRequest supplyOrderLineItem, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            supplyOrderLineItem, SupplyOrderLineItem.BIZ_ORDER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSupplyOrderLineItemCriteria(
      SupplyOrderLineItemRequest supplyOrderLineItem, IDRefine<SupplyOrderLineItem> idRefine) {
    return new RefinedIdInCriteria(
        supplyOrderLineItem, ID_PROPERTY, idRefine, SupplyOrderLineItem.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest selectSupplyOrderLineItemList(
      SupplyOrderLineItemRequest supplyOrderLineItem) {
    selectChild(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, supplyOrderLineItem);
    return this;
  }

  public SupplyOrderRequest selectSupplyOrderLineItemList() {
    return selectSupplyOrderLineItemList(SupplyOrderLineItemRequest.newInstance().selectAll());
  }

  public SupplyOrderRequest unselectSupplyOrderLineItemList() {
    unselectChild(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, SupplyOrderLineItem.class);
    return this;
  }

  public SupplyOrderRequest hasSupplyOrderShippingGroup() {
    return hasSupplyOrderShippingGroup(SupplyOrderShippingGroupRequest.newInstance());
  }

  public SupplyOrderRequest hasSupplyOrderShippingGroup(
      SupplyOrderShippingGroup... supplyOrderShippingGroup) {
    if (isEmptyParam(supplyOrderShippingGroup)) {
      throw new IllegalArgumentException(
          "hasSupplyOrderShippingGroup(SupplyOrderShippingGroup... supplyOrderShippingGroup)参数不能为空!");
    }
    return hasSupplyOrderShippingGroup(
        Q.supplyOrderShippingGroup()
            .select(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) supplyOrderShippingGroup));
  }

  public SupplyOrderRequest hasSupplyOrderShippingGroup(String... supplyOrderShippingGroup) {
    return hasSupplyOrderShippingGroup(
        Q.supplyOrderShippingGroup()
            .select(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY)
            .filterById(supplyOrderShippingGroup));
  }

  public SupplyOrderRequest hasSupplyOrderShippingGroup(
      SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
    return hasSupplyOrderShippingGroup(
        supplyOrderShippingGroup,
        $supplyOrderShippingGroup ->
            java.util.Optional.of($supplyOrderShippingGroup)
                .map(SupplyOrderShippingGroup::getBizOrder)
                .map(SupplyOrder::getId)
                .orElse(null));
  }

  public SupplyOrderRequest hasSupplyOrderShippingGroup(
      SupplyOrderShippingGroupRequest supplyOrderShippingGroup,
      IDRefine<SupplyOrderShippingGroup> idRefine) {
    supplyOrderShippingGroup.select(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY);
    supplyOrderShippingGroup.unlimited();
    return addSearchCriteria(
        createSupplyOrderShippingGroupCriteria(supplyOrderShippingGroup, idRefine));
  }

  public SupplyOrderRequest hasSupplyOrderShippingGroup(
      SupplyOrderShippingGroupRequest supplyOrderShippingGroup,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            supplyOrderShippingGroup,
            SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createSupplyOrderShippingGroupCriteria(
      SupplyOrderShippingGroupRequest supplyOrderShippingGroup,
      IDRefine<SupplyOrderShippingGroup> idRefine) {
    return new RefinedIdInCriteria(
        supplyOrderShippingGroup,
        ID_PROPERTY,
        idRefine,
        SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest selectSupplyOrderShippingGroupList(
      SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
    selectChild(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, supplyOrderShippingGroup);
    return this;
  }

  public SupplyOrderRequest selectSupplyOrderShippingGroupList() {
    return selectSupplyOrderShippingGroupList(
        SupplyOrderShippingGroupRequest.newInstance().selectAll());
  }

  public SupplyOrderRequest unselectSupplyOrderShippingGroupList() {
    unselectChild(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, SupplyOrderShippingGroup.class);
    return this;
  }

  public SupplyOrderRequest hasSupplyOrderPaymentGroup() {
    return hasSupplyOrderPaymentGroup(SupplyOrderPaymentGroupRequest.newInstance());
  }

  public SupplyOrderRequest hasSupplyOrderPaymentGroup(
      SupplyOrderPaymentGroup... supplyOrderPaymentGroup) {
    if (isEmptyParam(supplyOrderPaymentGroup)) {
      throw new IllegalArgumentException(
          "hasSupplyOrderPaymentGroup(SupplyOrderPaymentGroup... supplyOrderPaymentGroup)参数不能为空!");
    }
    return hasSupplyOrderPaymentGroup(
        Q.supplyOrderPaymentGroup()
            .select(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) supplyOrderPaymentGroup));
  }

  public SupplyOrderRequest hasSupplyOrderPaymentGroup(String... supplyOrderPaymentGroup) {
    return hasSupplyOrderPaymentGroup(
        Q.supplyOrderPaymentGroup()
            .select(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY)
            .filterById(supplyOrderPaymentGroup));
  }

  public SupplyOrderRequest hasSupplyOrderPaymentGroup(
      SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
    return hasSupplyOrderPaymentGroup(
        supplyOrderPaymentGroup,
        $supplyOrderPaymentGroup ->
            java.util.Optional.of($supplyOrderPaymentGroup)
                .map(SupplyOrderPaymentGroup::getBizOrder)
                .map(SupplyOrder::getId)
                .orElse(null));
  }

  public SupplyOrderRequest hasSupplyOrderPaymentGroup(
      SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup,
      IDRefine<SupplyOrderPaymentGroup> idRefine) {
    supplyOrderPaymentGroup.select(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY);
    supplyOrderPaymentGroup.unlimited();
    return addSearchCriteria(
        createSupplyOrderPaymentGroupCriteria(supplyOrderPaymentGroup, idRefine));
  }

  public SupplyOrderRequest hasSupplyOrderPaymentGroup(
      SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            supplyOrderPaymentGroup,
            SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createSupplyOrderPaymentGroupCriteria(
      SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup,
      IDRefine<SupplyOrderPaymentGroup> idRefine) {
    return new RefinedIdInCriteria(
        supplyOrderPaymentGroup, ID_PROPERTY, idRefine, SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest selectSupplyOrderPaymentGroupList(
      SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
    selectChild(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, supplyOrderPaymentGroup);
    return this;
  }

  public SupplyOrderRequest selectSupplyOrderPaymentGroupList() {
    return selectSupplyOrderPaymentGroupList(
        SupplyOrderPaymentGroupRequest.newInstance().selectAll());
  }

  public SupplyOrderRequest unselectSupplyOrderPaymentGroupList() {
    unselectChild(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, SupplyOrderPaymentGroup.class);
    return this;
  }

  public SupplyOrderRequest hasGoods() {
    return hasGoods(GoodsRequest.newInstance());
  }

  public SupplyOrderRequest hasGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("hasGoods(Goods... goods)参数不能为空!");
    }
    return hasGoods(
        Q.goods().select(Goods.BIZ_ORDER_PROPERTY).filterById(QueryOperator.IN, (Object[]) goods));
  }

  public SupplyOrderRequest hasGoods(String... goods) {
    return hasGoods(Q.goods().select(Goods.BIZ_ORDER_PROPERTY).filterById(goods));
  }

  public SupplyOrderRequest hasGoods(GoodsRequest goods) {
    return hasGoods(
        goods,
        $goods ->
            java.util.Optional.of($goods)
                .map(Goods::getBizOrder)
                .map(SupplyOrder::getId)
                .orElse(null));
  }

  public SupplyOrderRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.select(Goods.BIZ_ORDER_PROPERTY);
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public SupplyOrderRequest hasGoods(
      GoodsRequest goods, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(goods, Goods.BIZ_ORDER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine, Goods.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest selectGoodsList(GoodsRequest goods) {
    selectChild(Goods.BIZ_ORDER_PROPERTY, goods);
    return this;
  }

  public SupplyOrderRequest selectGoodsList() {
    return selectGoodsList(GoodsRequest.newInstance().selectAll());
  }

  public SupplyOrderRequest unselectGoodsList() {
    unselectChild(Goods.BIZ_ORDER_PROPERTY, Goods.class);
    return this;
  }

  public SupplyOrderRequest aggregateSupplyOrderLineItemList(
      SupplyOrderLineItemRequest supplyOrderLineItem) {
    aggregateChild(SupplyOrderLineItem.BIZ_ORDER_PROPERTY, supplyOrderLineItem);
    return this;
  }

  public SupplyOrderRequest countSupplyOrderLineItem() {
    return countSupplyOrderLineItem("supplyOrderLineItemCount");
  }

  public SupplyOrderRequest countSupplyOrderLineItem(String retName) {
    return countSupplyOrderLineItem(retName, SupplyOrderLineItemRequest.newInstance());
  }

  public SupplyOrderRequest countSupplyOrderLineItem(
      SupplyOrderLineItemRequest supplyOrderLineItem) {
    return countSupplyOrderLineItem("supplyOrderLineItemCount", supplyOrderLineItem);
  }

  public SupplyOrderRequest countSupplyOrderLineItem(
      String retName, SupplyOrderLineItemRequest supplyOrderLineItem) {
    supplyOrderLineItem.count();
    return statsFromSupplyOrderLineItem(retName, supplyOrderLineItem);
  }

  public SupplyOrderRequest statsFromSupplyOrderLineItem(
      String retName, SupplyOrderLineItemRequest supplyOrderLineItem) {
    return addDynamicProperty(retName, supplyOrderLineItem, SupplyOrderLineItem.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest aggregateSupplyOrderShippingGroupList(
      SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
    aggregateChild(SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY, supplyOrderShippingGroup);
    return this;
  }

  public SupplyOrderRequest countSupplyOrderShippingGroup() {
    return countSupplyOrderShippingGroup("supplyOrderShippingGroupCount");
  }

  public SupplyOrderRequest countSupplyOrderShippingGroup(String retName) {
    return countSupplyOrderShippingGroup(retName, SupplyOrderShippingGroupRequest.newInstance());
  }

  public SupplyOrderRequest countSupplyOrderShippingGroup(
      SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
    return countSupplyOrderShippingGroup("supplyOrderShippingGroupCount", supplyOrderShippingGroup);
  }

  public SupplyOrderRequest countSupplyOrderShippingGroup(
      String retName, SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
    supplyOrderShippingGroup.count();
    return statsFromSupplyOrderShippingGroup(retName, supplyOrderShippingGroup);
  }

  public SupplyOrderRequest statsFromSupplyOrderShippingGroup(
      String retName, SupplyOrderShippingGroupRequest supplyOrderShippingGroup) {
    return addDynamicProperty(
        retName, supplyOrderShippingGroup, SupplyOrderShippingGroup.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest aggregateSupplyOrderPaymentGroupList(
      SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
    aggregateChild(SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY, supplyOrderPaymentGroup);
    return this;
  }

  public SupplyOrderRequest countSupplyOrderPaymentGroup() {
    return countSupplyOrderPaymentGroup("supplyOrderPaymentGroupCount");
  }

  public SupplyOrderRequest countSupplyOrderPaymentGroup(String retName) {
    return countSupplyOrderPaymentGroup(retName, SupplyOrderPaymentGroupRequest.newInstance());
  }

  public SupplyOrderRequest countSupplyOrderPaymentGroup(
      SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
    return countSupplyOrderPaymentGroup("supplyOrderPaymentGroupCount", supplyOrderPaymentGroup);
  }

  public SupplyOrderRequest countSupplyOrderPaymentGroup(
      String retName, SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
    supplyOrderPaymentGroup.count();
    return statsFromSupplyOrderPaymentGroup(retName, supplyOrderPaymentGroup);
  }

  public SupplyOrderRequest statsFromSupplyOrderPaymentGroup(
      String retName, SupplyOrderPaymentGroupRequest supplyOrderPaymentGroup) {
    return addDynamicProperty(
        retName, supplyOrderPaymentGroup, SupplyOrderPaymentGroup.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest aggregateGoodsList(GoodsRequest goods) {
    aggregateChild(Goods.BIZ_ORDER_PROPERTY, goods);
    return this;
  }

  public SupplyOrderRequest countGoods() {
    return countGoods("goodsCount");
  }

  public SupplyOrderRequest countGoods(String retName) {
    return countGoods(retName, GoodsRequest.newInstance());
  }

  public SupplyOrderRequest countGoods(GoodsRequest goods) {
    return countGoods("goodsCount", goods);
  }

  public SupplyOrderRequest countGoods(String retName, GoodsRequest goods) {
    goods.count();
    return statsFromGoods(retName, goods);
  }

  public SupplyOrderRequest statsFromGoods(String retName, GoodsRequest goods) {
    return addDynamicProperty(retName, goods, Goods.BIZ_ORDER_PROPERTY);
  }

  public SupplyOrderRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SupplyOrderRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SupplyOrderRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SupplyOrderRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
