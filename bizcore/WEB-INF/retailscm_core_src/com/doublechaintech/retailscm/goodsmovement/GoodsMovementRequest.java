package com.doublechaintech.retailscm.goodsmovement;

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
import com.doublechaintech.retailscm.goods.GoodsRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsmovement.GoodsMovement.*;

public class GoodsMovementRequest extends BaseRequest<GoodsMovement> {
  public static GoodsMovementRequest newInstance() {
    return new GoodsMovementRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public GoodsMovementRequest resultByClass(Class<? extends GoodsMovement> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public GoodsMovementRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public GoodsMovementRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "GoodsMovement";
  }

  public GoodsMovementRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public GoodsMovementRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public GoodsMovementRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public GoodsMovementRequest select(String... names) {
    super.select(names);
    return this;
  }

  public GoodsMovementRequest selectAll() {
    return this.selectId()
        .selectMoveTime()
        .selectFacility()
        .selectFacilityId()
        .selectFromIp()
        .selectUserAgent()
        .selectSessionId()
        .selectLatitude()
        .selectLongitude()
        .selectGoods()
        .selectVersion();
  }

  public GoodsMovementRequest selectAny() {
    return selectAll();
  }

  public GoodsMovementRequest selectSelf() {
    select(ID_PROPERTY);
    select(MOVE_TIME_PROPERTY);
    select(FACILITY_PROPERTY);
    select(FACILITY_ID_PROPERTY);
    select(FROM_IP_PROPERTY);
    select(USER_AGENT_PROPERTY);
    select(SESSION_ID_PROPERTY);
    select(LATITUDE_PROPERTY);
    select(LONGITUDE_PROPERTY);
    select(GOODS_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public GoodsMovementRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public GoodsMovementRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {MOVE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    MOVE_TIME_PROPERTY,
    FACILITY_PROPERTY,
    FACILITY_ID_PROPERTY,
    FROM_IP_PROPERTY,
    USER_AGENT_PROPERTY,
    SESSION_ID_PROPERTY,
    LATITUDE_PROPERTY,
    LONGITUDE_PROPERTY,
    GOODS_PROPERTY,
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

  public GoodsMovementRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public GoodsMovementRequest comment(String comment) {
    return this;
  }

  public GoodsMovementRequest enhance() {
    return this;
  }

  public GoodsMovementRequest overrideClass(Class<? extends GoodsMovement> clazz) {
    return this;
  }

  public GoodsMovementRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public GoodsMovementRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public GoodsMovementRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public GoodsMovementRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public GoodsMovementRequest count() {
    return countId("count");
  }

  public static GoodsMovementRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public GoodsMovementRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public GoodsMovementRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectId() {
    return select(ID_PROPERTY);
  }

  public GoodsMovementRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public GoodsMovementRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public GoodsMovementRequest countId() {
    return countId("countId");
  }

  public GoodsMovementRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public GoodsMovementRequest maxId() {
    return maxId("maxId");
  }

  public GoodsMovementRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public GoodsMovementRequest minId() {
    return minId("minId");
  }

  public GoodsMovementRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public GoodsMovementRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public GoodsMovementRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public GoodsMovementRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public GoodsMovementRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByMoveTime(DateTime moveTime) {

    if (moveTime == null) {
      return this;
    }

    return filterByMoveTime(QueryOperator.EQUAL, moveTime);
  }

  public GoodsMovementRequest whereMoveTimeIsNull() {
    return where(MOVE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereMoveTimeIsNotNull() {
    return where(MOVE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest whereMoveTimeBetween(Date moveTimeStart, Date moveTimeEnd) {
    if (ObjectUtil.isEmpty(moveTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereMoveTimeBetween, the parameter moveTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(moveTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereMoveTimeBetween, the parameter moveTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getMoveTimeSearchCriteria(QueryOperator.BETWEEN, new Object[] {moveTimeStart, moveTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest whereMoveTimeBefore(Date moveTime) {

    if (ObjectUtil.isEmpty(moveTime)) {
      throw new IllegalArgumentException(
          "Method whereMoveTimeBefore, the parameter moveTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getMoveTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {moveTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest whereMoveTimeAfter(DateTime moveTime) {
    if (ObjectUtil.isEmpty(moveTime)) {
      throw new IllegalArgumentException(
          "Method whereMoveTimeAfter, the parameter moveTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getMoveTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {moveTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest filterByMoveTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMoveTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectMoveTime() {
    return select(MOVE_TIME_PROPERTY);
  }

  public GoodsMovementRequest unselectMoveTime() {
    return unselect(MOVE_TIME_PROPERTY);
  }

  public SearchCriteria getMoveTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOVE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByMoveTime(boolean asc) {
    addOrderBy(MOVE_TIME_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByMoveTimeAscending() {
    addOrderBy(MOVE_TIME_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByMoveTimeDescending() {
    addOrderBy(MOVE_TIME_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest countMoveTime() {
    return countMoveTime("countMoveTime");
  }

  public GoodsMovementRequest countMoveTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOVE_TIME_PROPERTY);
  }

  public GoodsMovementRequest maxMoveTime() {
    return maxMoveTime("maxMoveTime");
  }

  public GoodsMovementRequest maxMoveTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOVE_TIME_PROPERTY);
  }

  public GoodsMovementRequest minMoveTime() {
    return minMoveTime("minMoveTime");
  }

  public GoodsMovementRequest minMoveTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOVE_TIME_PROPERTY);
  }

  public GoodsMovementRequest groupByMoveTime() {
    return groupByMoveTime(MOVE_TIME_PROPERTY);
  }

  public GoodsMovementRequest groupByMoveTime(String ret) {
    return groupBy(ret, MOVE_TIME_PROPERTY);
  }

  public GoodsMovementRequest groupByMoveTime(SqlFunction func) {
    return groupByMoveTime(MOVE_TIME_PROPERTY, func);
  }

  public GoodsMovementRequest groupByMoveTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOVE_TIME_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByFacility(String facility) {

    if (facility == null) {
      return this;
    }

    return filterByFacility(QueryOperator.EQUAL, facility);
  }

  public GoodsMovementRequest whereFacilityIsNull() {
    return where(FACILITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereFacilityIsNotNull() {
    return where(FACILITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest filterByFacility(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFacilitySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectFacility() {
    return select(FACILITY_PROPERTY);
  }

  public GoodsMovementRequest unselectFacility() {
    return unselect(FACILITY_PROPERTY);
  }

  public SearchCriteria getFacilitySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FACILITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByFacility(boolean asc) {
    addOrderBy(FACILITY_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByFacilityAscending() {
    addOrderBy(FACILITY_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByFacilityDescending() {
    addOrderBy(FACILITY_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest orderByFacilityAscendingUsingGBK() {
    addOrderBy("convert(facility using gbk)", true);
    return this;
  }

  public GoodsMovementRequest orderByFacilityDescendingUsingGBK() {
    addOrderBy("convert(facility using gbk)", false);
    return this;
  }

  public GoodsMovementRequest countFacility() {
    return countFacility("countFacility");
  }

  public GoodsMovementRequest countFacility(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FACILITY_PROPERTY);
  }

  public GoodsMovementRequest maxFacility() {
    return maxFacility("maxFacility");
  }

  public GoodsMovementRequest maxFacility(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FACILITY_PROPERTY);
  }

  public GoodsMovementRequest minFacility() {
    return minFacility("minFacility");
  }

  public GoodsMovementRequest minFacility(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FACILITY_PROPERTY);
  }

  public GoodsMovementRequest groupByFacility() {
    return groupByFacility(FACILITY_PROPERTY);
  }

  public GoodsMovementRequest groupByFacility(String ret) {
    return groupBy(ret, FACILITY_PROPERTY);
  }

  public GoodsMovementRequest groupByFacility(SqlFunction func) {
    return groupByFacility(FACILITY_PROPERTY, func);
  }

  public GoodsMovementRequest groupByFacility(String ret, SqlFunction func) {
    super.groupBy(ret, func, FACILITY_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByFacilityId(String facilityId) {

    if (facilityId == null) {
      return this;
    }

    return filterByFacilityId(QueryOperator.EQUAL, facilityId);
  }

  public GoodsMovementRequest whereFacilityIdIsNull() {
    return where(FACILITY_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereFacilityIdIsNotNull() {
    return where(FACILITY_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest filterByFacilityId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFacilityIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectFacilityId() {
    return select(FACILITY_ID_PROPERTY);
  }

  public GoodsMovementRequest unselectFacilityId() {
    return unselect(FACILITY_ID_PROPERTY);
  }

  public SearchCriteria getFacilityIdSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FACILITY_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByFacilityId(boolean asc) {
    addOrderBy(FACILITY_ID_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByFacilityIdAscending() {
    addOrderBy(FACILITY_ID_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByFacilityIdDescending() {
    addOrderBy(FACILITY_ID_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest orderByFacilityIdAscendingUsingGBK() {
    addOrderBy("convert(facilityId using gbk)", true);
    return this;
  }

  public GoodsMovementRequest orderByFacilityIdDescendingUsingGBK() {
    addOrderBy("convert(facilityId using gbk)", false);
    return this;
  }

  public GoodsMovementRequest countFacilityId() {
    return countFacilityId("countFacilityId");
  }

  public GoodsMovementRequest countFacilityId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FACILITY_ID_PROPERTY);
  }

  public GoodsMovementRequest maxFacilityId() {
    return maxFacilityId("maxFacilityId");
  }

  public GoodsMovementRequest maxFacilityId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FACILITY_ID_PROPERTY);
  }

  public GoodsMovementRequest minFacilityId() {
    return minFacilityId("minFacilityId");
  }

  public GoodsMovementRequest minFacilityId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FACILITY_ID_PROPERTY);
  }

  public GoodsMovementRequest groupByFacilityId() {
    return groupByFacilityId(FACILITY_ID_PROPERTY);
  }

  public GoodsMovementRequest groupByFacilityId(String ret) {
    return groupBy(ret, FACILITY_ID_PROPERTY);
  }

  public GoodsMovementRequest groupByFacilityId(SqlFunction func) {
    return groupByFacilityId(FACILITY_ID_PROPERTY, func);
  }

  public GoodsMovementRequest groupByFacilityId(String ret, SqlFunction func) {
    super.groupBy(ret, func, FACILITY_ID_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByFromIp(String fromIp) {

    if (fromIp == null) {
      return this;
    }

    return filterByFromIp(QueryOperator.EQUAL, fromIp);
  }

  public GoodsMovementRequest whereFromIpIsNull() {
    return where(FROM_IP_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereFromIpIsNotNull() {
    return where(FROM_IP_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest filterByFromIp(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFromIpSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectFromIp() {
    return select(FROM_IP_PROPERTY);
  }

  public GoodsMovementRequest unselectFromIp() {
    return unselect(FROM_IP_PROPERTY);
  }

  public SearchCriteria getFromIpSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FROM_IP_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByFromIp(boolean asc) {
    addOrderBy(FROM_IP_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByFromIpAscending() {
    addOrderBy(FROM_IP_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByFromIpDescending() {
    addOrderBy(FROM_IP_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest orderByFromIpAscendingUsingGBK() {
    addOrderBy("convert(fromIp using gbk)", true);
    return this;
  }

  public GoodsMovementRequest orderByFromIpDescendingUsingGBK() {
    addOrderBy("convert(fromIp using gbk)", false);
    return this;
  }

  public GoodsMovementRequest countFromIp() {
    return countFromIp("countFromIp");
  }

  public GoodsMovementRequest countFromIp(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FROM_IP_PROPERTY);
  }

  public GoodsMovementRequest maxFromIp() {
    return maxFromIp("maxFromIp");
  }

  public GoodsMovementRequest maxFromIp(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FROM_IP_PROPERTY);
  }

  public GoodsMovementRequest minFromIp() {
    return minFromIp("minFromIp");
  }

  public GoodsMovementRequest minFromIp(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FROM_IP_PROPERTY);
  }

  public GoodsMovementRequest groupByFromIp() {
    return groupByFromIp(FROM_IP_PROPERTY);
  }

  public GoodsMovementRequest groupByFromIp(String ret) {
    return groupBy(ret, FROM_IP_PROPERTY);
  }

  public GoodsMovementRequest groupByFromIp(SqlFunction func) {
    return groupByFromIp(FROM_IP_PROPERTY, func);
  }

  public GoodsMovementRequest groupByFromIp(String ret, SqlFunction func) {
    super.groupBy(ret, func, FROM_IP_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByUserAgent(String userAgent) {

    if (userAgent == null) {
      return this;
    }

    return filterByUserAgent(QueryOperator.EQUAL, userAgent);
  }

  public GoodsMovementRequest whereUserAgentIsNull() {
    return where(USER_AGENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereUserAgentIsNotNull() {
    return where(USER_AGENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest filterByUserAgent(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getUserAgentSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectUserAgent() {
    return select(USER_AGENT_PROPERTY);
  }

  public GoodsMovementRequest unselectUserAgent() {
    return unselect(USER_AGENT_PROPERTY);
  }

  public SearchCriteria getUserAgentSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(USER_AGENT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByUserAgent(boolean asc) {
    addOrderBy(USER_AGENT_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByUserAgentAscending() {
    addOrderBy(USER_AGENT_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByUserAgentDescending() {
    addOrderBy(USER_AGENT_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest orderByUserAgentAscendingUsingGBK() {
    addOrderBy("convert(userAgent using gbk)", true);
    return this;
  }

  public GoodsMovementRequest orderByUserAgentDescendingUsingGBK() {
    addOrderBy("convert(userAgent using gbk)", false);
    return this;
  }

  public GoodsMovementRequest countUserAgent() {
    return countUserAgent("countUserAgent");
  }

  public GoodsMovementRequest countUserAgent(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, USER_AGENT_PROPERTY);
  }

  public GoodsMovementRequest maxUserAgent() {
    return maxUserAgent("maxUserAgent");
  }

  public GoodsMovementRequest maxUserAgent(String aggName) {
    return aggregate(aggName, AggFunc.MAX, USER_AGENT_PROPERTY);
  }

  public GoodsMovementRequest minUserAgent() {
    return minUserAgent("minUserAgent");
  }

  public GoodsMovementRequest minUserAgent(String aggName) {
    return aggregate(aggName, AggFunc.MIN, USER_AGENT_PROPERTY);
  }

  public GoodsMovementRequest groupByUserAgent() {
    return groupByUserAgent(USER_AGENT_PROPERTY);
  }

  public GoodsMovementRequest groupByUserAgent(String ret) {
    return groupBy(ret, USER_AGENT_PROPERTY);
  }

  public GoodsMovementRequest groupByUserAgent(SqlFunction func) {
    return groupByUserAgent(USER_AGENT_PROPERTY, func);
  }

  public GoodsMovementRequest groupByUserAgent(String ret, SqlFunction func) {
    super.groupBy(ret, func, USER_AGENT_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterBySessionId(String sessionId) {

    if (sessionId == null) {
      return this;
    }

    return filterBySessionId(QueryOperator.EQUAL, sessionId);
  }

  public GoodsMovementRequest whereSessionIdIsNull() {
    return where(SESSION_ID_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereSessionIdIsNotNull() {
    return where(SESSION_ID_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest filterBySessionId(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSessionIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectSessionId() {
    return select(SESSION_ID_PROPERTY);
  }

  public GoodsMovementRequest unselectSessionId() {
    return unselect(SESSION_ID_PROPERTY);
  }

  public SearchCriteria getSessionIdSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SESSION_ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderBySessionId(boolean asc) {
    addOrderBy(SESSION_ID_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderBySessionIdAscending() {
    addOrderBy(SESSION_ID_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderBySessionIdDescending() {
    addOrderBy(SESSION_ID_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest orderBySessionIdAscendingUsingGBK() {
    addOrderBy("convert(sessionId using gbk)", true);
    return this;
  }

  public GoodsMovementRequest orderBySessionIdDescendingUsingGBK() {
    addOrderBy("convert(sessionId using gbk)", false);
    return this;
  }

  public GoodsMovementRequest countSessionId() {
    return countSessionId("countSessionId");
  }

  public GoodsMovementRequest countSessionId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SESSION_ID_PROPERTY);
  }

  public GoodsMovementRequest maxSessionId() {
    return maxSessionId("maxSessionId");
  }

  public GoodsMovementRequest maxSessionId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SESSION_ID_PROPERTY);
  }

  public GoodsMovementRequest minSessionId() {
    return minSessionId("minSessionId");
  }

  public GoodsMovementRequest minSessionId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SESSION_ID_PROPERTY);
  }

  public GoodsMovementRequest groupBySessionId() {
    return groupBySessionId(SESSION_ID_PROPERTY);
  }

  public GoodsMovementRequest groupBySessionId(String ret) {
    return groupBy(ret, SESSION_ID_PROPERTY);
  }

  public GoodsMovementRequest groupBySessionId(SqlFunction func) {
    return groupBySessionId(SESSION_ID_PROPERTY, func);
  }

  public GoodsMovementRequest groupBySessionId(String ret, SqlFunction func) {
    super.groupBy(ret, func, SESSION_ID_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByLatitude(BigDecimal latitude) {

    if (latitude == null) {
      return this;
    }

    return filterByLatitude(QueryOperator.EQUAL, latitude);
  }

  public GoodsMovementRequest whereLatitudeIsNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereLatitudeIsNotNull() {
    return where(LATITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest whereLatitudeBetween(
      BigDecimal latitudeStart, BigDecimal latitudeEnd) {
    if (ObjectUtil.isEmpty(latitudeStart)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeBetween, the parameter latitudeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(latitudeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeBetween, the parameter latitudeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.BETWEEN, new Object[] {latitudeStart, latitudeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest whereLatitudeLessThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeLessThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest whereLatitudeGreaterThan(BigDecimal latitude) {
    if (ObjectUtil.isEmpty(latitude)) {
      throw new IllegalArgumentException(
          "Method whereLatitudeGreaterThan, the parameter latitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLatitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {latitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectLatitude() {
    return select(LATITUDE_PROPERTY);
  }

  public GoodsMovementRequest unselectLatitude() {
    return unselect(LATITUDE_PROPERTY);
  }

  public SearchCriteria getLatitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByLatitude(boolean asc) {
    addOrderBy(LATITUDE_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByLatitudeAscending() {
    addOrderBy(LATITUDE_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByLatitudeDescending() {
    addOrderBy(LATITUDE_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest countLatitude() {
    return countLatitude("countLatitude");
  }

  public GoodsMovementRequest countLatitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LATITUDE_PROPERTY);
  }

  public GoodsMovementRequest maxLatitude() {
    return maxLatitude("maxLatitude");
  }

  public GoodsMovementRequest maxLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LATITUDE_PROPERTY);
  }

  public GoodsMovementRequest minLatitude() {
    return minLatitude("minLatitude");
  }

  public GoodsMovementRequest minLatitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LATITUDE_PROPERTY);
  }

  public GoodsMovementRequest sumLatitude() {
    return sumLatitude("sumLatitude");
  }

  public GoodsMovementRequest sumLatitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LATITUDE_PROPERTY);
  }

  public GoodsMovementRequest groupByLatitude() {
    return groupByLatitude(LATITUDE_PROPERTY);
  }

  public GoodsMovementRequest groupByLatitude(String ret) {
    return groupBy(ret, LATITUDE_PROPERTY);
  }

  public GoodsMovementRequest groupByLatitude(SqlFunction func) {
    return groupByLatitude(LATITUDE_PROPERTY, func);
  }

  public GoodsMovementRequest groupByLatitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LATITUDE_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByLongitude(BigDecimal longitude) {

    if (longitude == null) {
      return this;
    }

    return filterByLongitude(QueryOperator.EQUAL, longitude);
  }

  public GoodsMovementRequest whereLongitudeIsNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereLongitudeIsNotNull() {
    return where(LONGITUDE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest whereLongitudeBetween(
      BigDecimal longitudeStart, BigDecimal longitudeEnd) {
    if (ObjectUtil.isEmpty(longitudeStart)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeBetween, the parameter longitudeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(longitudeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeBetween, the parameter longitudeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {longitudeStart, longitudeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest whereLongitudeLessThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeLessThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest whereLongitudeGreaterThan(BigDecimal longitude) {
    if (ObjectUtil.isEmpty(longitude)) {
      throw new IllegalArgumentException(
          "Method whereLongitudeGreaterThan, the parameter longitude is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLongitudeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {longitude});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest filterByLongitude(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectLongitude() {
    return select(LONGITUDE_PROPERTY);
  }

  public GoodsMovementRequest unselectLongitude() {
    return unselect(LONGITUDE_PROPERTY);
  }

  public SearchCriteria getLongitudeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByLongitude(boolean asc) {
    addOrderBy(LONGITUDE_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByLongitudeAscending() {
    addOrderBy(LONGITUDE_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByLongitudeDescending() {
    addOrderBy(LONGITUDE_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest countLongitude() {
    return countLongitude("countLongitude");
  }

  public GoodsMovementRequest countLongitude(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LONGITUDE_PROPERTY);
  }

  public GoodsMovementRequest maxLongitude() {
    return maxLongitude("maxLongitude");
  }

  public GoodsMovementRequest maxLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LONGITUDE_PROPERTY);
  }

  public GoodsMovementRequest minLongitude() {
    return minLongitude("minLongitude");
  }

  public GoodsMovementRequest minLongitude(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LONGITUDE_PROPERTY);
  }

  public GoodsMovementRequest sumLongitude() {
    return sumLongitude("sumLongitude");
  }

  public GoodsMovementRequest sumLongitude(String aggName) {
    return aggregate(aggName, AggFunc.SUM, LONGITUDE_PROPERTY);
  }

  public GoodsMovementRequest groupByLongitude() {
    return groupByLongitude(LONGITUDE_PROPERTY);
  }

  public GoodsMovementRequest groupByLongitude(String ret) {
    return groupBy(ret, LONGITUDE_PROPERTY);
  }

  public GoodsMovementRequest groupByLongitude(SqlFunction func) {
    return groupByLongitude(LONGITUDE_PROPERTY, func);
  }

  public GoodsMovementRequest groupByLongitude(String ret, SqlFunction func) {
    super.groupBy(ret, func, LONGITUDE_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public GoodsMovementRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsMovementRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public GoodsMovementRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsMovementRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public GoodsMovementRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public GoodsMovementRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public GoodsMovementRequest countVersion() {
    return countVersion("countVersion");
  }

  public GoodsMovementRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public GoodsMovementRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public GoodsMovementRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public GoodsMovementRequest minVersion() {
    return minVersion("minVersion");
  }

  public GoodsMovementRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public GoodsMovementRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public GoodsMovementRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public GoodsMovementRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public GoodsMovementRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public GoodsMovementRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public GoodsMovementRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public GoodsMovementRequest filterByGoods(GoodsRequest goods) {
    return filterByGoods(goods, Goods::getId);
  }

  public GoodsMovementRequest filterByGoods(Goods... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("filterByGoods(Goods... goods)参数不能为空!");
    }
    return where(GOODS_PROPERTY, QueryOperator.IN, (Object[]) goods);
  }

  public GoodsMovementRequest selectGoodsId() {
    select(GOODS_PROPERTY);
    return this;
  }

  public GoodsRequest upToGoods() {
    return upToGoods(GoodsRequest.newInstance());
  }

  public GoodsRequest upToGoods(GoodsRequest goods) {
    goods.aggregateChild(GOODS_PROPERTY, this);
    this.groupByGoods(goods);
    return goods;
  }

  public GoodsRequest endAtGoods(String retName) {
    return endAtGoods(retName, GoodsRequest.newInstance());
  }

  public GoodsRequest endAtGoods(String retName, GoodsRequest goods) {
    goods.addDynamicProperty(retName, this, GOODS_PROPERTY);
    return goods;
  }

  public GoodsMovementRequest filterByGoods(String... goods) {
    if (isEmptyParam(goods)) {
      throw new IllegalArgumentException("filterByGoods(String... goods)参数不能为空!");
    }
    return where(GOODS_PROPERTY, QueryOperator.IN, (Object[]) goods);
  }

  public GoodsMovementRequest filterByGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
    goods.unlimited();
    return addSearchCriteria(createGoodsCriteria(goods, idRefine));
  }

  public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine) {
    return new RefinedIdInCriteria(goods, GOODS_PROPERTY, idRefine, Goods.ID_PROPERTY);
  }

  public GoodsMovementRequest selectGoods() {
    return selectGoods(GoodsRequest.newInstance().selectSelf());
  }

  public GoodsMovementRequest selectGoods(GoodsRequest goods) {
    selectParent(GOODS_PROPERTY, goods);
    return this;
  }

  public GoodsMovementRequest unselectGoods() {
    unselectParent(GOODS_PROPERTY);
    return this;
  }

  public GoodsMovementRequest groupByGoods(GoodsRequest goods) {
    groupBy(GOODS_PROPERTY, goods);
    return this;
  }

  public GoodsMovementRequest aggregateGoods(GoodsRequest goods) {
    aggregateParent(GOODS_PROPERTY, goods);
    return this;
  }

  public GoodsMovementRequest countGoods() {
    return countGoods("countGoods");
  }

  public GoodsMovementRequest countGoods(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, GOODS_PROPERTY);
  }

  public GoodsMovementRequest groupByGoods() {
    return groupByGoods(GOODS_PROPERTY);
  }

  public GoodsMovementRequest groupByGoods(String ret) {
    return groupBy(ret, GOODS_PROPERTY);
  }

  public GoodsMovementRequest whereGoodsIsNull() {
    return where(GOODS_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsMovementRequest whereGoodsIsNotNull() {
    return where(GOODS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsMovementRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public GoodsMovementRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public GoodsMovementRequest unlimited() {
    super.unlimited();
    return this;
  }

  public GoodsMovementRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
