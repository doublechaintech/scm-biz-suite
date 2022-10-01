package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord.*;

public class RetailStoreMemberGiftCardConsumeRecordRequest
    extends BaseRequest<RetailStoreMemberGiftCardConsumeRecord> {
  public static RetailStoreMemberGiftCardConsumeRecordRequest newInstance() {
    return new RetailStoreMemberGiftCardConsumeRecordRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest resultByClass(
      Class<? extends RetailStoreMemberGiftCardConsumeRecord> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreMemberGiftCardConsumeRecord";
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest addSearchCriteria(
      SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectAll() {
    return this.selectId()
        .selectOccureTime()
        .selectOwner()
        .selectBizOrder()
        .selectNumber()
        .selectAmount()
        .selectVersion();
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectAny() {
    return selectAll();
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectSelf() {
    select(ID_PROPERTY);
    select(OCCURE_TIME_PROPERTY);
    select(OWNER_PROPERTY);
    select(BIZ_ORDER_PROPERTY);
    select(NUMBER_PROPERTY);
    select(AMOUNT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {OCCURE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    OCCURE_TIME_PROPERTY,
    OWNER_PROPERTY,
    BIZ_ORDER_PROPERTY,
    NUMBER_PROPERTY,
    AMOUNT_PROPERTY,
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

  public RetailStoreMemberGiftCardConsumeRecordRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest comment(String comment) {
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest enhance() {
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest overrideClass(
      Class<? extends RetailStoreMemberGiftCardConsumeRecord> clazz) {
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupBy(
      String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest count() {
    return countId("count");
  }

  public static RetailStoreMemberGiftCardConsumeRecordRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardConsumeRecordRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countId() {
    return countId("countId");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minId() {
    return minId("minId");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByOccureTime(Date occureTime) {

    if (occureTime == null) {
      return this;
    }

    return filterByOccureTime(QueryOperator.EQUAL, occureTime);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereOccureTimeIsNull() {
    return where(OCCURE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereOccureTimeIsNotNull() {
    return where(OCCURE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereOccureTimeBetween(
      Date occureTimeStart, Date occureTimeEnd) {
    if (ObjectUtil.isEmpty(occureTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereOccureTimeBetween, the parameter occureTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(occureTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereOccureTimeBetween, the parameter occureTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getOccureTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {occureTimeStart, occureTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereOccureTimeBefore(Date occureTime) {

    if (ObjectUtil.isEmpty(occureTime)) {
      throw new IllegalArgumentException(
          "Method whereOccureTimeBefore, the parameter occureTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getOccureTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {occureTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereOccureTimeAfter(Date occureTime) {
    if (ObjectUtil.isEmpty(occureTime)) {
      throw new IllegalArgumentException(
          "Method whereOccureTimeAfter, the parameter occureTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getOccureTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {occureTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByOccureTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getOccureTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectOccureTime() {
    return select(OCCURE_TIME_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselectOccureTime() {
    return unselect(OCCURE_TIME_PROPERTY);
  }

  public SearchCriteria getOccureTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(OCCURE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardConsumeRecordRequest orderByOccureTime(boolean asc) {
    addOrderBy(OCCURE_TIME_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByOccureTimeAscending() {
    addOrderBy(OCCURE_TIME_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByOccureTimeDescending() {
    addOrderBy(OCCURE_TIME_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countOccureTime() {
    return countOccureTime("countOccureTime");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countOccureTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OCCURE_TIME_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxOccureTime() {
    return maxOccureTime("maxOccureTime");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxOccureTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, OCCURE_TIME_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minOccureTime() {
    return minOccureTime("minOccureTime");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minOccureTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, OCCURE_TIME_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByOccureTime() {
    return groupByOccureTime(OCCURE_TIME_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByOccureTime(String ret) {
    return groupBy(ret, OCCURE_TIME_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByOccureTime(SqlFunction func) {
    return groupByOccureTime(OCCURE_TIME_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByOccureTime(
      String ret, SqlFunction func) {
    super.groupBy(ret, func, OCCURE_TIME_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByNumber(String number) {

    if (number == null) {
      return this;
    }

    return filterByNumber(QueryOperator.EQUAL, number);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereNumberIsNull() {
    return where(NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereNumberIsNotNull() {
    return where(NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectNumber() {
    return select(NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselectNumber() {
    return unselect(NUMBER_PROPERTY);
  }

  public SearchCriteria getNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardConsumeRecordRequest orderByNumber(boolean asc) {
    addOrderBy(NUMBER_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByNumberAscending() {
    addOrderBy(NUMBER_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByNumberDescending() {
    addOrderBy(NUMBER_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByNumberAscendingUsingGBK() {
    addOrderBy("convert(number using gbk)", true);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByNumberDescendingUsingGBK() {
    addOrderBy("convert(number using gbk)", false);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countNumber() {
    return countNumber("countNumber");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxNumber() {
    return maxNumber("maxNumber");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minNumber() {
    return minNumber("minNumber");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByNumber() {
    return groupByNumber(NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByNumber(String ret) {
    return groupBy(ret, NUMBER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByNumber(SqlFunction func) {
    return groupByNumber(NUMBER_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, NUMBER_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByAmount(BigDecimal amount) {

    if (amount == null) {
      return this;
    }

    return filterByAmount(QueryOperator.EQUAL, amount);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereAmountIsNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereAmountIsNotNull() {
    return where(AMOUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereAmountBetween(
      BigDecimal amountStart, BigDecimal amountEnd) {
    if (ObjectUtil.isEmpty(amountStart)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(amountEnd)) {
      throw new IllegalArgumentException(
          "Method whereAmountBetween, the parameter amountEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.BETWEEN, new Object[] {amountStart, amountEnd});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereAmountLessThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountLessThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.LESS_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereAmountGreaterThan(BigDecimal amount) {
    if (ObjectUtil.isEmpty(amount)) {
      throw new IllegalArgumentException(
          "Method whereAmountGreaterThan, the parameter amount is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getAmountSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {amount});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByAmount(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectAmount() {
    return select(AMOUNT_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselectAmount() {
    return unselect(AMOUNT_PROPERTY);
  }

  public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardConsumeRecordRequest orderByAmount(boolean asc) {
    addOrderBy(AMOUNT_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByAmountAscending() {
    addOrderBy(AMOUNT_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByAmountDescending() {
    addOrderBy(AMOUNT_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countAmount() {
    return countAmount("countAmount");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countAmount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, AMOUNT_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxAmount() {
    return maxAmount("maxAmount");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxAmount(String aggName) {
    return aggregate(aggName, AggFunc.MAX, AMOUNT_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minAmount() {
    return minAmount("minAmount");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minAmount(String aggName) {
    return aggregate(aggName, AggFunc.MIN, AMOUNT_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest sumAmount() {
    return sumAmount("sumAmount");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest sumAmount(String aggName) {
    return aggregate(aggName, AggFunc.SUM, AMOUNT_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByAmount() {
    return groupByAmount(AMOUNT_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByAmount(String ret) {
    return groupBy(ret, AMOUNT_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByAmount(SqlFunction func) {
    return groupByAmount(AMOUNT_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByAmount(String ret, SqlFunction func) {
    super.groupBy(ret, func, AMOUNT_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreMemberGiftCardConsumeRecordRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByVersion(
      String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByOwner(
      RetailStoreMemberGiftCardRequest owner) {
    return filterByOwner(owner, RetailStoreMemberGiftCard::getId);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByOwner(
      RetailStoreMemberGiftCard... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException(
          "filterByOwner(RetailStoreMemberGiftCard... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardRequest upToOwner() {
    return upToOwner(RetailStoreMemberGiftCardRequest.newInstance());
  }

  public RetailStoreMemberGiftCardRequest upToOwner(RetailStoreMemberGiftCardRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public RetailStoreMemberGiftCardRequest endAtOwner(String retName) {
    return endAtOwner(retName, RetailStoreMemberGiftCardRequest.newInstance());
  }

  public RetailStoreMemberGiftCardRequest endAtOwner(
      String retName, RetailStoreMemberGiftCardRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByOwner(
      RetailStoreMemberGiftCardRequest owner, IDRefine<RetailStoreMemberGiftCard> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreMemberGiftCardRequest owner, IDRefine<RetailStoreMemberGiftCard> idRefine) {
    return new RefinedIdInCriteria(
        owner, OWNER_PROPERTY, idRefine, RetailStoreMemberGiftCard.ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectOwner() {
    return selectOwner(RetailStoreMemberGiftCardRequest.newInstance().selectSelf());
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectOwner(
      RetailStoreMemberGiftCardRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByOwner(
      RetailStoreMemberGiftCardRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest aggregateOwner(
      RetailStoreMemberGiftCardRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countOwner() {
    return countOwner("countOwner");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByBizOrder(
      ConsumerOrderRequest bizOrder) {
    return filterByBizOrder(bizOrder, ConsumerOrder::getId);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByBizOrder(ConsumerOrder... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(ConsumerOrder... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectBizOrderId() {
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

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByBizOrder(String... bizOrder) {
    if (isEmptyParam(bizOrder)) {
      throw new IllegalArgumentException("filterByBizOrder(String... bizOrder)参数不能为空!");
    }
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IN, (Object[]) bizOrder);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest filterByBizOrder(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    bizOrder.unlimited();
    return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
  }

  public SearchCriteria createBizOrderCriteria(
      ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
    return new RefinedIdInCriteria(
        bizOrder, BIZ_ORDER_PROPERTY, idRefine, ConsumerOrder.ID_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectBizOrder() {
    return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest selectBizOrder(
      ConsumerOrderRequest bizOrder) {
    selectParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unselectBizOrder() {
    unselectParent(BIZ_ORDER_PROPERTY);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByBizOrder(
      ConsumerOrderRequest bizOrder) {
    groupBy(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest aggregateBizOrder(
      ConsumerOrderRequest bizOrder) {
    aggregateParent(BIZ_ORDER_PROPERTY, bizOrder);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countBizOrder() {
    return countBizOrder("countBizOrder");
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest countBizOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByBizOrder() {
    return groupByBizOrder(BIZ_ORDER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest groupByBizOrder(String ret) {
    return groupBy(ret, BIZ_ORDER_PROPERTY);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereBizOrderIsNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest whereBizOrderIsNotNull() {
    return where(BIZ_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreMemberGiftCardConsumeRecordRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
