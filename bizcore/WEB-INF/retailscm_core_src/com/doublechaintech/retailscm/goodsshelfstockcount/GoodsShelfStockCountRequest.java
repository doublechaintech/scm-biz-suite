package com.doublechaintech.retailscm.goodsshelfstockcount;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrack;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfRequest;
import com.doublechaintech.retailscm.stockcountissuetrack.StockCountIssueTrackRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount.*;

public class GoodsShelfStockCountRequest extends BaseRequest<GoodsShelfStockCount> {
  public static GoodsShelfStockCountRequest newInstance() {
    return new GoodsShelfStockCountRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public GoodsShelfStockCountRequest resultByClass(Class<? extends GoodsShelfStockCount> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public GoodsShelfStockCountRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public GoodsShelfStockCountRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "GoodsShelfStockCount";
  }

  public GoodsShelfStockCountRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public GoodsShelfStockCountRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public GoodsShelfStockCountRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public GoodsShelfStockCountRequest select(String... names) {
    super.select(names);
    return this;
  }

  public GoodsShelfStockCountRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectCountTime()
        .selectSummary()
        .selectShelf()
        .selectVersion();
  }

  public GoodsShelfStockCountRequest selectAny() {
    return selectAll().selectStockCountIssueTrackList(Q.stockCountIssueTrack().selectSelf());
  }

  public GoodsShelfStockCountRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(COUNT_TIME_PROPERTY);
    select(SUMMARY_PROPERTY);
    select(SHELF_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public GoodsShelfStockCountRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public GoodsShelfStockCountRequest where(
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
    SHELF_PROPERTY,
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

  public GoodsShelfStockCountRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public GoodsShelfStockCountRequest comment(String comment) {
    return this;
  }

  public GoodsShelfStockCountRequest enhance() {
    return this;
  }

  public GoodsShelfStockCountRequest overrideClass(Class<? extends GoodsShelfStockCount> clazz) {
    return this;
  }

  public GoodsShelfStockCountRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public GoodsShelfStockCountRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public GoodsShelfStockCountRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public GoodsShelfStockCountRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public GoodsShelfStockCountRequest count() {
    return countId("count");
  }

  public static GoodsShelfStockCountRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public GoodsShelfStockCountRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public GoodsShelfStockCountRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfStockCountRequest selectId() {
    return select(ID_PROPERTY);
  }

  public GoodsShelfStockCountRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfStockCountRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public GoodsShelfStockCountRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public GoodsShelfStockCountRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public GoodsShelfStockCountRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public GoodsShelfStockCountRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public GoodsShelfStockCountRequest countId() {
    return countId("countId");
  }

  public GoodsShelfStockCountRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public GoodsShelfStockCountRequest maxId() {
    return maxId("maxId");
  }

  public GoodsShelfStockCountRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public GoodsShelfStockCountRequest minId() {
    return minId("minId");
  }

  public GoodsShelfStockCountRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public GoodsShelfStockCountRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public GoodsShelfStockCountRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public GoodsShelfStockCountRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfStockCountRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfStockCountRequest filterByTitle(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfStockCountRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public GoodsShelfStockCountRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfStockCountRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public GoodsShelfStockCountRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public GoodsShelfStockCountRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public GoodsShelfStockCountRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public GoodsShelfStockCountRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public GoodsShelfStockCountRequest countTitle() {
    return countTitle("countTitle");
  }

  public GoodsShelfStockCountRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public GoodsShelfStockCountRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public GoodsShelfStockCountRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public GoodsShelfStockCountRequest minTitle() {
    return minTitle("minTitle");
  }

  public GoodsShelfStockCountRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public GoodsShelfStockCountRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public GoodsShelfStockCountRequest filterByCountTime(Date countTime) {

    if (countTime == null) {
      return this;
    }

    return filterByCountTime(QueryOperator.EQUAL, countTime);
  }

  public GoodsShelfStockCountRequest whereCountTimeIsNull() {
    return where(COUNT_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfStockCountRequest whereCountTimeIsNotNull() {
    return where(COUNT_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfStockCountRequest whereCountTimeBetween(Date countTimeStart, Date countTimeEnd) {
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

  public GoodsShelfStockCountRequest whereCountTimeBefore(Date countTime) {

    if (ObjectUtil.isEmpty(countTime)) {
      throw new IllegalArgumentException(
          "Method whereCountTimeBefore, the parameter countTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCountTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {countTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfStockCountRequest whereCountTimeAfter(Date countTime) {
    if (ObjectUtil.isEmpty(countTime)) {
      throw new IllegalArgumentException(
          "Method whereCountTimeAfter, the parameter countTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCountTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {countTime});
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfStockCountRequest filterByCountTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCountTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfStockCountRequest selectCountTime() {
    return select(COUNT_TIME_PROPERTY);
  }

  public GoodsShelfStockCountRequest unselectCountTime() {
    return unselect(COUNT_TIME_PROPERTY);
  }

  public SearchCriteria getCountTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(COUNT_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfStockCountRequest orderByCountTime(boolean asc) {
    addOrderBy(COUNT_TIME_PROPERTY, asc);
    return this;
  }

  public GoodsShelfStockCountRequest orderByCountTimeAscending() {
    addOrderBy(COUNT_TIME_PROPERTY, true);
    return this;
  }

  public GoodsShelfStockCountRequest orderByCountTimeDescending() {
    addOrderBy(COUNT_TIME_PROPERTY, false);
    return this;
  }

  public GoodsShelfStockCountRequest countCountTime() {
    return countCountTime("countCountTime");
  }

  public GoodsShelfStockCountRequest countCountTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COUNT_TIME_PROPERTY);
  }

  public GoodsShelfStockCountRequest maxCountTime() {
    return maxCountTime("maxCountTime");
  }

  public GoodsShelfStockCountRequest maxCountTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, COUNT_TIME_PROPERTY);
  }

  public GoodsShelfStockCountRequest minCountTime() {
    return minCountTime("minCountTime");
  }

  public GoodsShelfStockCountRequest minCountTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, COUNT_TIME_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByCountTime() {
    return groupByCountTime(COUNT_TIME_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByCountTime(String ret) {
    return groupBy(ret, COUNT_TIME_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByCountTime(SqlFunction func) {
    return groupByCountTime(COUNT_TIME_PROPERTY, func);
  }

  public GoodsShelfStockCountRequest groupByCountTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, COUNT_TIME_PROPERTY);
    return this;
  }

  public GoodsShelfStockCountRequest filterBySummary(String summary) {

    if (summary == null) {
      return this;
    }

    return filterBySummary(QueryOperator.EQUAL, summary);
  }

  public GoodsShelfStockCountRequest whereSummaryIsNull() {
    return where(SUMMARY_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfStockCountRequest whereSummaryIsNotNull() {
    return where(SUMMARY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfStockCountRequest filterBySummary(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSummarySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfStockCountRequest selectSummary() {
    return select(SUMMARY_PROPERTY);
  }

  public GoodsShelfStockCountRequest unselectSummary() {
    return unselect(SUMMARY_PROPERTY);
  }

  public SearchCriteria getSummarySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SUMMARY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfStockCountRequest orderBySummary(boolean asc) {
    addOrderBy(SUMMARY_PROPERTY, asc);
    return this;
  }

  public GoodsShelfStockCountRequest orderBySummaryAscending() {
    addOrderBy(SUMMARY_PROPERTY, true);
    return this;
  }

  public GoodsShelfStockCountRequest orderBySummaryDescending() {
    addOrderBy(SUMMARY_PROPERTY, false);
    return this;
  }

  public GoodsShelfStockCountRequest orderBySummaryAscendingUsingGBK() {
    addOrderBy("convert(summary using gbk)", true);
    return this;
  }

  public GoodsShelfStockCountRequest orderBySummaryDescendingUsingGBK() {
    addOrderBy("convert(summary using gbk)", false);
    return this;
  }

  public GoodsShelfStockCountRequest countSummary() {
    return countSummary("countSummary");
  }

  public GoodsShelfStockCountRequest countSummary(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SUMMARY_PROPERTY);
  }

  public GoodsShelfStockCountRequest maxSummary() {
    return maxSummary("maxSummary");
  }

  public GoodsShelfStockCountRequest maxSummary(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SUMMARY_PROPERTY);
  }

  public GoodsShelfStockCountRequest minSummary() {
    return minSummary("minSummary");
  }

  public GoodsShelfStockCountRequest minSummary(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SUMMARY_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupBySummary() {
    return groupBySummary(SUMMARY_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupBySummary(String ret) {
    return groupBy(ret, SUMMARY_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupBySummary(SqlFunction func) {
    return groupBySummary(SUMMARY_PROPERTY, func);
  }

  public GoodsShelfStockCountRequest groupBySummary(String ret, SqlFunction func) {
    super.groupBy(ret, func, SUMMARY_PROPERTY);
    return this;
  }

  public GoodsShelfStockCountRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public GoodsShelfStockCountRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfStockCountRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfStockCountRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public GoodsShelfStockCountRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public GoodsShelfStockCountRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public GoodsShelfStockCountRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public GoodsShelfStockCountRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public GoodsShelfStockCountRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public GoodsShelfStockCountRequest countVersion() {
    return countVersion("countVersion");
  }

  public GoodsShelfStockCountRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public GoodsShelfStockCountRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public GoodsShelfStockCountRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public GoodsShelfStockCountRequest minVersion() {
    return minVersion("minVersion");
  }

  public GoodsShelfStockCountRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public GoodsShelfStockCountRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public GoodsShelfStockCountRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public GoodsShelfStockCountRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public GoodsShelfStockCountRequest filterByShelf(GoodsShelfRequest shelf) {
    return filterByShelf(shelf, GoodsShelf::getId);
  }

  public GoodsShelfStockCountRequest filterByShelf(GoodsShelf... shelf) {
    if (isEmptyParam(shelf)) {
      throw new IllegalArgumentException("filterByShelf(GoodsShelf... shelf)参数不能为空!");
    }
    return where(SHELF_PROPERTY, QueryOperator.IN, (Object[]) shelf);
  }

  public GoodsShelfStockCountRequest selectShelfId() {
    select(SHELF_PROPERTY);
    return this;
  }

  public GoodsShelfRequest upToShelf() {
    return upToShelf(GoodsShelfRequest.newInstance());
  }

  public GoodsShelfRequest upToShelf(GoodsShelfRequest shelf) {
    shelf.aggregateChild(SHELF_PROPERTY, this);
    this.groupByShelf(shelf);
    return shelf;
  }

  public GoodsShelfRequest endAtShelf(String retName) {
    return endAtShelf(retName, GoodsShelfRequest.newInstance());
  }

  public GoodsShelfRequest endAtShelf(String retName, GoodsShelfRequest shelf) {
    shelf.addDynamicProperty(retName, this, SHELF_PROPERTY);
    return shelf;
  }

  public GoodsShelfStockCountRequest filterByShelf(String... shelf) {
    if (isEmptyParam(shelf)) {
      throw new IllegalArgumentException("filterByShelf(String... shelf)参数不能为空!");
    }
    return where(SHELF_PROPERTY, QueryOperator.IN, (Object[]) shelf);
  }

  public GoodsShelfStockCountRequest filterByShelf(
      GoodsShelfRequest shelf, IDRefine<GoodsShelf> idRefine) {
    shelf.unlimited();
    return addSearchCriteria(createShelfCriteria(shelf, idRefine));
  }

  public SearchCriteria createShelfCriteria(
      GoodsShelfRequest shelf, IDRefine<GoodsShelf> idRefine) {
    return new RefinedIdInCriteria(shelf, SHELF_PROPERTY, idRefine, GoodsShelf.ID_PROPERTY);
  }

  public GoodsShelfStockCountRequest selectShelf() {
    return selectShelf(GoodsShelfRequest.newInstance().selectSelf());
  }

  public GoodsShelfStockCountRequest selectShelf(GoodsShelfRequest shelf) {
    selectParent(SHELF_PROPERTY, shelf);
    return this;
  }

  public GoodsShelfStockCountRequest unselectShelf() {
    unselectParent(SHELF_PROPERTY);
    return this;
  }

  public GoodsShelfStockCountRequest groupByShelf(GoodsShelfRequest shelf) {
    groupBy(SHELF_PROPERTY, shelf);
    return this;
  }

  public GoodsShelfStockCountRequest aggregateShelf(GoodsShelfRequest shelf) {
    aggregateParent(SHELF_PROPERTY, shelf);
    return this;
  }

  public GoodsShelfStockCountRequest countShelf() {
    return countShelf("countShelf");
  }

  public GoodsShelfStockCountRequest countShelf(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SHELF_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByShelf() {
    return groupByShelf(SHELF_PROPERTY);
  }

  public GoodsShelfStockCountRequest groupByShelf(String ret) {
    return groupBy(ret, SHELF_PROPERTY);
  }

  public GoodsShelfStockCountRequest whereShelfIsNull() {
    return where(SHELF_PROPERTY, QueryOperator.IS_NULL);
  }

  public GoodsShelfStockCountRequest whereShelfIsNotNull() {
    return where(SHELF_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public GoodsShelfStockCountRequest hasStockCountIssueTrack() {
    return hasStockCountIssueTrack(StockCountIssueTrackRequest.newInstance());
  }

  public GoodsShelfStockCountRequest hasStockCountIssueTrack(
      StockCountIssueTrack... stockCountIssueTrack) {
    if (isEmptyParam(stockCountIssueTrack)) {
      throw new IllegalArgumentException(
          "hasStockCountIssueTrack(StockCountIssueTrack... stockCountIssueTrack)参数不能为空!");
    }
    return hasStockCountIssueTrack(
        Q.stockCountIssueTrack()
            .select(StockCountIssueTrack.STOCK_COUNT_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) stockCountIssueTrack));
  }

  public GoodsShelfStockCountRequest hasStockCountIssueTrack(String... stockCountIssueTrack) {
    return hasStockCountIssueTrack(
        Q.stockCountIssueTrack()
            .select(StockCountIssueTrack.STOCK_COUNT_PROPERTY)
            .filterById(stockCountIssueTrack));
  }

  public GoodsShelfStockCountRequest hasStockCountIssueTrack(
      StockCountIssueTrackRequest stockCountIssueTrack) {
    return hasStockCountIssueTrack(
        stockCountIssueTrack,
        $stockCountIssueTrack ->
            java.util.Optional.of($stockCountIssueTrack)
                .map(StockCountIssueTrack::getStockCount)
                .map(GoodsShelfStockCount::getId)
                .orElse(null));
  }

  public GoodsShelfStockCountRequest hasStockCountIssueTrack(
      StockCountIssueTrackRequest stockCountIssueTrack, IDRefine<StockCountIssueTrack> idRefine) {
    stockCountIssueTrack.select(StockCountIssueTrack.STOCK_COUNT_PROPERTY);
    stockCountIssueTrack.unlimited();
    return addSearchCriteria(createStockCountIssueTrackCriteria(stockCountIssueTrack, idRefine));
  }

  public GoodsShelfStockCountRequest hasStockCountIssueTrack(
      StockCountIssueTrackRequest stockCountIssueTrack, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            stockCountIssueTrack, StockCountIssueTrack.STOCK_COUNT_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createStockCountIssueTrackCriteria(
      StockCountIssueTrackRequest stockCountIssueTrack, IDRefine<StockCountIssueTrack> idRefine) {
    return new RefinedIdInCriteria(
        stockCountIssueTrack, ID_PROPERTY, idRefine, StockCountIssueTrack.STOCK_COUNT_PROPERTY);
  }

  public GoodsShelfStockCountRequest selectStockCountIssueTrackList(
      StockCountIssueTrackRequest stockCountIssueTrack) {
    selectChild(StockCountIssueTrack.STOCK_COUNT_PROPERTY, stockCountIssueTrack);
    return this;
  }

  public GoodsShelfStockCountRequest selectStockCountIssueTrackList() {
    return selectStockCountIssueTrackList(StockCountIssueTrackRequest.newInstance().selectAll());
  }

  public GoodsShelfStockCountRequest unselectStockCountIssueTrackList() {
    unselectChild(StockCountIssueTrack.STOCK_COUNT_PROPERTY, StockCountIssueTrack.class);
    return this;
  }

  public GoodsShelfStockCountRequest aggregateStockCountIssueTrackList(
      StockCountIssueTrackRequest stockCountIssueTrack) {
    aggregateChild(StockCountIssueTrack.STOCK_COUNT_PROPERTY, stockCountIssueTrack);
    return this;
  }

  public GoodsShelfStockCountRequest countStockCountIssueTrack() {
    return countStockCountIssueTrack("stockCountIssueTrackCount");
  }

  public GoodsShelfStockCountRequest countStockCountIssueTrack(String retName) {
    return countStockCountIssueTrack(retName, StockCountIssueTrackRequest.newInstance());
  }

  public GoodsShelfStockCountRequest countStockCountIssueTrack(
      StockCountIssueTrackRequest stockCountIssueTrack) {
    return countStockCountIssueTrack("stockCountIssueTrackCount", stockCountIssueTrack);
  }

  public GoodsShelfStockCountRequest countStockCountIssueTrack(
      String retName, StockCountIssueTrackRequest stockCountIssueTrack) {
    stockCountIssueTrack.count();
    return statsFromStockCountIssueTrack(retName, stockCountIssueTrack);
  }

  public GoodsShelfStockCountRequest statsFromStockCountIssueTrack(
      String retName, StockCountIssueTrackRequest stockCountIssueTrack) {
    return addDynamicProperty(
        retName, stockCountIssueTrack, StockCountIssueTrack.STOCK_COUNT_PROPERTY);
  }

  public GoodsShelfStockCountRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public GoodsShelfStockCountRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public GoodsShelfStockCountRequest unlimited() {
    super.unlimited();
    return this;
  }

  public GoodsShelfStockCountRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
