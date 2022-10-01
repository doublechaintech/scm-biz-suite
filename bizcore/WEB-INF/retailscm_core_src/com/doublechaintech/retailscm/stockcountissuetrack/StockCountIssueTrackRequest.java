package com.doublechaintech.retailscm.stockcountissuetrack;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack.*;

public class StockCountIssueTrackRequest extends BaseRequest<StockCountIssueTrack> {
  public static StockCountIssueTrackRequest newInstance() {
    return new StockCountIssueTrackRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public StockCountIssueTrackRequest resultByClass(Class<? extends StockCountIssueTrack> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public StockCountIssueTrackRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public StockCountIssueTrackRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "StockCountIssueTrack";
  }

  public StockCountIssueTrackRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public StockCountIssueTrackRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public StockCountIssueTrackRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public StockCountIssueTrackRequest select(String... names) {
    super.select(names);
    return this;
  }

  public StockCountIssueTrackRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectCountTime()
        .selectSummary()
        .selectStockCount()
        .selectVersion();
  }

  public StockCountIssueTrackRequest selectAny() {
    return selectAll();
  }

  public StockCountIssueTrackRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(COUNT_TIME_PROPERTY);
    select(SUMMARY_PROPERTY);
    select(STOCK_COUNT_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public StockCountIssueTrackRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public StockCountIssueTrackRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {COUNT_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    TITLE_PROPERTY,
    COUNT_TIME_PROPERTY,
    SUMMARY_PROPERTY,
    STOCK_COUNT_PROPERTY,
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

  public StockCountIssueTrackRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public StockCountIssueTrackRequest comment(String comment) {
    return this;
  }

  public StockCountIssueTrackRequest enhance() {
    return this;
  }

  public StockCountIssueTrackRequest overrideClass(Class<? extends StockCountIssueTrack> clazz) {
    return this;
  }

  public StockCountIssueTrackRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public StockCountIssueTrackRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public StockCountIssueTrackRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public StockCountIssueTrackRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public StockCountIssueTrackRequest count() {
    return countId("count");
  }

  public static StockCountIssueTrackRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public StockCountIssueTrackRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public StockCountIssueTrackRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest selectId() {
    return select(ID_PROPERTY);
  }

  public StockCountIssueTrackRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StockCountIssueTrackRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public StockCountIssueTrackRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public StockCountIssueTrackRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public StockCountIssueTrackRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public StockCountIssueTrackRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public StockCountIssueTrackRequest countId() {
    return countId("countId");
  }

  public StockCountIssueTrackRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public StockCountIssueTrackRequest maxId() {
    return maxId("maxId");
  }

  public StockCountIssueTrackRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public StockCountIssueTrackRequest minId() {
    return minId("minId");
  }

  public StockCountIssueTrackRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public StockCountIssueTrackRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public StockCountIssueTrackRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public StockCountIssueTrackRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public StockCountIssueTrackRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public StockCountIssueTrackRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public StockCountIssueTrackRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public StockCountIssueTrackRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StockCountIssueTrackRequest filterByTitle(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public StockCountIssueTrackRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StockCountIssueTrackRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public StockCountIssueTrackRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public StockCountIssueTrackRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public StockCountIssueTrackRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public StockCountIssueTrackRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public StockCountIssueTrackRequest countTitle() {
    return countTitle("countTitle");
  }

  public StockCountIssueTrackRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public StockCountIssueTrackRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public StockCountIssueTrackRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public StockCountIssueTrackRequest minTitle() {
    return minTitle("minTitle");
  }

  public StockCountIssueTrackRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public StockCountIssueTrackRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public StockCountIssueTrackRequest filterByCountTime(Date countTime) {

    if (countTime == null) {
      return this;
    }

    return filterByCountTime(QueryOperator.EQUAL, countTime);
  }

  public StockCountIssueTrackRequest whereCountTimeIsNull() {
    return where(COUNT_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public StockCountIssueTrackRequest whereCountTimeIsNotNull() {
    return where(COUNT_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StockCountIssueTrackRequest whereCountTimeBetween(Date countTimeStart, Date countTimeEnd) {
    if (ObjectUtil.isEmpty(countTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereCountTimeBetween, the parameter countTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(countTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereCountTimeBetween, the parameter countTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCountTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {countTimeStart, countTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest whereCountTimeBefore(Date countTime) {

    if (ObjectUtil.isEmpty(countTime)) {
      throw new IllegalArgumentException(
          "Method whereCountTimeBefore, the parameter countTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCountTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {countTime});
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest whereCountTimeAfter(Date countTime) {
    if (ObjectUtil.isEmpty(countTime)) {
      throw new IllegalArgumentException(
          "Method whereCountTimeAfter, the parameter countTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCountTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {countTime});
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest filterByCountTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCountTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest selectCountTime() {
    return select(COUNT_TIME_PROPERTY);
  }

  public StockCountIssueTrackRequest unselectCountTime() {
    return unselect(COUNT_TIME_PROPERTY);
  }

  public SearchCriteria getCountTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COUNT_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StockCountIssueTrackRequest orderByCountTime(boolean asc) {
    addOrderBy(COUNT_TIME_PROPERTY, asc);
    return this;
  }

  public StockCountIssueTrackRequest orderByCountTimeAscending() {
    addOrderBy(COUNT_TIME_PROPERTY, true);
    return this;
  }

  public StockCountIssueTrackRequest orderByCountTimeDescending() {
    addOrderBy(COUNT_TIME_PROPERTY, false);
    return this;
  }

  public StockCountIssueTrackRequest countCountTime() {
    return countCountTime("countCountTime");
  }

  public StockCountIssueTrackRequest countCountTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COUNT_TIME_PROPERTY);
  }

  public StockCountIssueTrackRequest maxCountTime() {
    return maxCountTime("maxCountTime");
  }

  public StockCountIssueTrackRequest maxCountTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COUNT_TIME_PROPERTY);
  }

  public StockCountIssueTrackRequest minCountTime() {
    return minCountTime("minCountTime");
  }

  public StockCountIssueTrackRequest minCountTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COUNT_TIME_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByCountTime() {
    return groupByCountTime(COUNT_TIME_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByCountTime(String ret) {
    return groupBy(ret, COUNT_TIME_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByCountTime(SqlFunction func) {
    return groupByCountTime(COUNT_TIME_PROPERTY, func);
  }

  public StockCountIssueTrackRequest groupByCountTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, COUNT_TIME_PROPERTY);
    return this;
  }

  public StockCountIssueTrackRequest filterBySummary(String summary) {

    if (summary == null) {
      return this;
    }

    return filterBySummary(QueryOperator.EQUAL, summary);
  }

  public StockCountIssueTrackRequest whereSummaryIsNull() {
    return where(SUMMARY_PROPERTY, QueryOperator.IS_NULL);
  }

  public StockCountIssueTrackRequest whereSummaryIsNotNull() {
    return where(SUMMARY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StockCountIssueTrackRequest filterBySummary(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSummarySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest selectSummary() {
    return select(SUMMARY_PROPERTY);
  }

  public StockCountIssueTrackRequest unselectSummary() {
    return unselect(SUMMARY_PROPERTY);
  }

  public SearchCriteria getSummarySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SUMMARY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StockCountIssueTrackRequest orderBySummary(boolean asc) {
    addOrderBy(SUMMARY_PROPERTY, asc);
    return this;
  }

  public StockCountIssueTrackRequest orderBySummaryAscending() {
    addOrderBy(SUMMARY_PROPERTY, true);
    return this;
  }

  public StockCountIssueTrackRequest orderBySummaryDescending() {
    addOrderBy(SUMMARY_PROPERTY, false);
    return this;
  }

  public StockCountIssueTrackRequest orderBySummaryAscendingUsingGBK() {
    addOrderBy("convert(summary using gbk)", true);
    return this;
  }

  public StockCountIssueTrackRequest orderBySummaryDescendingUsingGBK() {
    addOrderBy("convert(summary using gbk)", false);
    return this;
  }

  public StockCountIssueTrackRequest countSummary() {
    return countSummary("countSummary");
  }

  public StockCountIssueTrackRequest countSummary(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SUMMARY_PROPERTY);
  }

  public StockCountIssueTrackRequest maxSummary() {
    return maxSummary("maxSummary");
  }

  public StockCountIssueTrackRequest maxSummary(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SUMMARY_PROPERTY);
  }

  public StockCountIssueTrackRequest minSummary() {
    return minSummary("minSummary");
  }

  public StockCountIssueTrackRequest minSummary(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SUMMARY_PROPERTY);
  }

  public StockCountIssueTrackRequest groupBySummary() {
    return groupBySummary(SUMMARY_PROPERTY);
  }

  public StockCountIssueTrackRequest groupBySummary(String ret) {
    return groupBy(ret, SUMMARY_PROPERTY);
  }

  public StockCountIssueTrackRequest groupBySummary(SqlFunction func) {
    return groupBySummary(SUMMARY_PROPERTY, func);
  }

  public StockCountIssueTrackRequest groupBySummary(String ret, SqlFunction func) {
    super.groupBy(ret, func, SUMMARY_PROPERTY);
    return this;
  }

  public StockCountIssueTrackRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public StockCountIssueTrackRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public StockCountIssueTrackRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StockCountIssueTrackRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public StockCountIssueTrackRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public StockCountIssueTrackRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public StockCountIssueTrackRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public StockCountIssueTrackRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public StockCountIssueTrackRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public StockCountIssueTrackRequest countVersion() {
    return countVersion("countVersion");
  }

  public StockCountIssueTrackRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public StockCountIssueTrackRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public StockCountIssueTrackRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public StockCountIssueTrackRequest minVersion() {
    return minVersion("minVersion");
  }

  public StockCountIssueTrackRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public StockCountIssueTrackRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public StockCountIssueTrackRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public StockCountIssueTrackRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public StockCountIssueTrackRequest filterByStockCount(GoodsShelfStockCountRequest stockCount) {
    return filterByStockCount(stockCount, GoodsShelfStockCount::getId);
  }

  public StockCountIssueTrackRequest filterByStockCount(GoodsShelfStockCount... stockCount) {
    if (isEmptyParam(stockCount)) {
      throw new IllegalArgumentException(
          "filterByStockCount(GoodsShelfStockCount... stockCount)参数不能为空!");
    }
    return where(STOCK_COUNT_PROPERTY, QueryOperator.IN, (Object[]) stockCount);
  }

  public StockCountIssueTrackRequest selectStockCountId() {
    select(STOCK_COUNT_PROPERTY);
    return this;
  }

  public GoodsShelfStockCountRequest upToStockCount() {
    return upToStockCount(GoodsShelfStockCountRequest.newInstance());
  }

  public GoodsShelfStockCountRequest upToStockCount(GoodsShelfStockCountRequest stockCount) {
    stockCount.aggregateChild(STOCK_COUNT_PROPERTY, this);
    this.groupByStockCount(stockCount);
    return stockCount;
  }

  public GoodsShelfStockCountRequest endAtStockCount(String retName) {
    return endAtStockCount(retName, GoodsShelfStockCountRequest.newInstance());
  }

  public GoodsShelfStockCountRequest endAtStockCount(
      String retName, GoodsShelfStockCountRequest stockCount) {
    stockCount.addDynamicProperty(retName, this, STOCK_COUNT_PROPERTY);
    return stockCount;
  }

  public StockCountIssueTrackRequest filterByStockCount(String... stockCount) {
    if (isEmptyParam(stockCount)) {
      throw new IllegalArgumentException("filterByStockCount(String... stockCount)参数不能为空!");
    }
    return where(STOCK_COUNT_PROPERTY, QueryOperator.IN, (Object[]) stockCount);
  }

  public StockCountIssueTrackRequest filterByStockCount(
      GoodsShelfStockCountRequest stockCount, IDRefine<GoodsShelfStockCount> idRefine) {
    stockCount.unlimited();
    return addSearchCriteria(createStockCountCriteria(stockCount, idRefine));
  }

  public SearchCriteria createStockCountCriteria(
      GoodsShelfStockCountRequest stockCount, IDRefine<GoodsShelfStockCount> idRefine) {
    return new RefinedIdInCriteria(
        stockCount, STOCK_COUNT_PROPERTY, idRefine, GoodsShelfStockCount.ID_PROPERTY);
  }

  public StockCountIssueTrackRequest selectStockCount() {
    return selectStockCount(GoodsShelfStockCountRequest.newInstance().selectSelf());
  }

  public StockCountIssueTrackRequest selectStockCount(GoodsShelfStockCountRequest stockCount) {
    selectParent(STOCK_COUNT_PROPERTY, stockCount);
    return this;
  }

  public StockCountIssueTrackRequest unselectStockCount() {
    unselectParent(STOCK_COUNT_PROPERTY);
    return this;
  }

  public StockCountIssueTrackRequest groupByStockCount(GoodsShelfStockCountRequest stockCount) {
    groupBy(STOCK_COUNT_PROPERTY, stockCount);
    return this;
  }

  public StockCountIssueTrackRequest aggregateStockCount(GoodsShelfStockCountRequest stockCount) {
    aggregateParent(STOCK_COUNT_PROPERTY, stockCount);
    return this;
  }

  public StockCountIssueTrackRequest countStockCount() {
    return countStockCount("countStockCount");
  }

  public StockCountIssueTrackRequest countStockCount(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, STOCK_COUNT_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByStockCount() {
    return groupByStockCount(STOCK_COUNT_PROPERTY);
  }

  public StockCountIssueTrackRequest groupByStockCount(String ret) {
    return groupBy(ret, STOCK_COUNT_PROPERTY);
  }

  public StockCountIssueTrackRequest whereStockCountIsNull() {
    return where(STOCK_COUNT_PROPERTY, QueryOperator.IS_NULL);
  }

  public StockCountIssueTrackRequest whereStockCountIsNotNull() {
    return where(STOCK_COUNT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public StockCountIssueTrackRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public StockCountIssueTrackRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public StockCountIssueTrackRequest unlimited() {
    super.unlimited();
    return this;
  }

  public StockCountIssueTrackRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
