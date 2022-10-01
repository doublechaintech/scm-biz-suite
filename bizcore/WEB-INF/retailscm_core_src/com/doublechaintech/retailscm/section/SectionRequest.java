package com.doublechaintech.retailscm.section;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.page.PageRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.section.Section.*;

public class SectionRequest extends BaseRequest<Section> {
  public static SectionRequest newInstance() {
    return new SectionRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SectionRequest resultByClass(Class<? extends Section> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SectionRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SectionRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Section";
  }

  public SectionRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SectionRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SectionRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SectionRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SectionRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectBrief()
        .selectIcon()
        .selectDisplayOrder()
        .selectViewGroup()
        .selectLinkToUrl()
        .selectPage()
        .selectVersion();
  }

  public SectionRequest selectAny() {
    return selectAll();
  }

  public SectionRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(BRIEF_PROPERTY);
    select(ICON_PROPERTY);
    select(DISPLAY_ORDER_PROPERTY);
    select(VIEW_GROUP_PROPERTY);
    select(LINK_TO_URL_PROPERTY);
    select(PAGE_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SectionRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SectionRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    TITLE_PROPERTY,
    BRIEF_PROPERTY,
    ICON_PROPERTY,
    DISPLAY_ORDER_PROPERTY,
    VIEW_GROUP_PROPERTY,
    LINK_TO_URL_PROPERTY,
    PAGE_PROPERTY,
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

  public SectionRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SectionRequest comment(String comment) {
    return this;
  }

  public SectionRequest enhance() {
    return this;
  }

  public SectionRequest overrideClass(Class<? extends Section> clazz) {
    return this;
  }

  public SectionRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SectionRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SectionRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SectionRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SectionRequest count() {
    return countId("count");
  }

  public static SectionRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SectionRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SectionRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SectionRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SectionRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SectionRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SectionRequest countId() {
    return countId("countId");
  }

  public SectionRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SectionRequest maxId() {
    return maxId("maxId");
  }

  public SectionRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SectionRequest minId() {
    return minId("minId");
  }

  public SectionRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SectionRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SectionRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SectionRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SectionRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SectionRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public SectionRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public SectionRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public SectionRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public SectionRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public SectionRequest countTitle() {
    return countTitle("countTitle");
  }

  public SectionRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public SectionRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public SectionRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public SectionRequest minTitle() {
    return minTitle("minTitle");
  }

  public SectionRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public SectionRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public SectionRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public SectionRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public SectionRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public SectionRequest filterByBrief(String brief) {

    if (brief == null) {
      return this;
    }

    return filterByBrief(QueryOperator.EQUAL, brief);
  }

  public SectionRequest whereBriefIsNull() {
    return where(BRIEF_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest whereBriefIsNotNull() {
    return where(BRIEF_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest filterByBrief(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBriefSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectBrief() {
    return select(BRIEF_PROPERTY);
  }

  public SectionRequest unselectBrief() {
    return unselect(BRIEF_PROPERTY);
  }

  public SearchCriteria getBriefSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BRIEF_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderByBrief(boolean asc) {
    addOrderBy(BRIEF_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByBriefAscending() {
    addOrderBy(BRIEF_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByBriefDescending() {
    addOrderBy(BRIEF_PROPERTY, false);
    return this;
  }

  public SectionRequest orderByBriefAscendingUsingGBK() {
    addOrderBy("convert(brief using gbk)", true);
    return this;
  }

  public SectionRequest orderByBriefDescendingUsingGBK() {
    addOrderBy("convert(brief using gbk)", false);
    return this;
  }

  public SectionRequest countBrief() {
    return countBrief("countBrief");
  }

  public SectionRequest countBrief(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BRIEF_PROPERTY);
  }

  public SectionRequest maxBrief() {
    return maxBrief("maxBrief");
  }

  public SectionRequest maxBrief(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BRIEF_PROPERTY);
  }

  public SectionRequest minBrief() {
    return minBrief("minBrief");
  }

  public SectionRequest minBrief(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BRIEF_PROPERTY);
  }

  public SectionRequest groupByBrief() {
    return groupByBrief(BRIEF_PROPERTY);
  }

  public SectionRequest groupByBrief(String ret) {
    return groupBy(ret, BRIEF_PROPERTY);
  }

  public SectionRequest groupByBrief(SqlFunction func) {
    return groupByBrief(BRIEF_PROPERTY, func);
  }

  public SectionRequest groupByBrief(String ret, SqlFunction func) {
    super.groupBy(ret, func, BRIEF_PROPERTY);
    return this;
  }

  public SectionRequest filterByIcon(String icon) {

    if (icon == null) {
      return this;
    }

    return filterByIcon(QueryOperator.EQUAL, icon);
  }

  public SectionRequest whereIconIsNull() {
    return where(ICON_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest whereIconIsNotNull() {
    return where(ICON_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest filterByIcon(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIconSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectIcon() {
    return select(ICON_PROPERTY);
  }

  public SectionRequest unselectIcon() {
    return unselect(ICON_PROPERTY);
  }

  public SearchCriteria getIconSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ICON_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderByIcon(boolean asc) {
    addOrderBy(ICON_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByIconAscending() {
    addOrderBy(ICON_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByIconDescending() {
    addOrderBy(ICON_PROPERTY, false);
    return this;
  }

  public SectionRequest orderByIconAscendingUsingGBK() {
    addOrderBy("convert(icon using gbk)", true);
    return this;
  }

  public SectionRequest orderByIconDescendingUsingGBK() {
    addOrderBy("convert(icon using gbk)", false);
    return this;
  }

  public SectionRequest countIcon() {
    return countIcon("countIcon");
  }

  public SectionRequest countIcon(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ICON_PROPERTY);
  }

  public SectionRequest maxIcon() {
    return maxIcon("maxIcon");
  }

  public SectionRequest maxIcon(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ICON_PROPERTY);
  }

  public SectionRequest minIcon() {
    return minIcon("minIcon");
  }

  public SectionRequest minIcon(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ICON_PROPERTY);
  }

  public SectionRequest groupByIcon() {
    return groupByIcon(ICON_PROPERTY);
  }

  public SectionRequest groupByIcon(String ret) {
    return groupBy(ret, ICON_PROPERTY);
  }

  public SectionRequest groupByIcon(SqlFunction func) {
    return groupByIcon(ICON_PROPERTY, func);
  }

  public SectionRequest groupByIcon(String ret, SqlFunction func) {
    super.groupBy(ret, func, ICON_PROPERTY);
    return this;
  }

  public SectionRequest filterByDisplayOrder(int displayOrder) {

    return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
  }

  public SectionRequest whereDisplayOrderIsNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest whereDisplayOrderIsNotNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest whereDisplayOrderBetween(
      Integer displayOrderStart, Integer displayOrderEnd) {
    if (ObjectUtil.isEmpty(displayOrderStart)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderBetween, the parameter displayOrderStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(displayOrderEnd)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderBetween, the parameter displayOrderEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {displayOrderStart, displayOrderEnd});
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest whereDisplayOrderLessThan(Integer displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderLessThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.LESS_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest whereDisplayOrderGreaterThan(int displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderGreaterThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectDisplayOrder() {
    return select(DISPLAY_ORDER_PROPERTY);
  }

  public SectionRequest unselectDisplayOrder() {
    return unselect(DISPLAY_ORDER_PROPERTY);
  }

  public SearchCriteria getDisplayOrderSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderByDisplayOrder(boolean asc) {
    addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByDisplayOrderAscending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByDisplayOrderDescending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, false);
    return this;
  }

  public SectionRequest countDisplayOrder() {
    return countDisplayOrder("countDisplayOrder");
  }

  public SectionRequest countDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DISPLAY_ORDER_PROPERTY);
  }

  public SectionRequest maxDisplayOrder() {
    return maxDisplayOrder("maxDisplayOrder");
  }

  public SectionRequest maxDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DISPLAY_ORDER_PROPERTY);
  }

  public SectionRequest minDisplayOrder() {
    return minDisplayOrder("minDisplayOrder");
  }

  public SectionRequest minDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DISPLAY_ORDER_PROPERTY);
  }

  public SectionRequest sumDisplayOrder() {
    return sumDisplayOrder("sumDisplayOrder");
  }

  public SectionRequest sumDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.SUM, DISPLAY_ORDER_PROPERTY);
  }

  public SectionRequest groupByDisplayOrder() {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY);
  }

  public SectionRequest groupByDisplayOrder(String ret) {
    return groupBy(ret, DISPLAY_ORDER_PROPERTY);
  }

  public SectionRequest groupByDisplayOrder(SqlFunction func) {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY, func);
  }

  public SectionRequest groupByDisplayOrder(String ret, SqlFunction func) {
    super.groupBy(ret, func, DISPLAY_ORDER_PROPERTY);
    return this;
  }

  public SectionRequest filterByViewGroup(String viewGroup) {

    if (viewGroup == null) {
      return this;
    }

    return filterByViewGroup(QueryOperator.EQUAL, viewGroup);
  }

  public SectionRequest whereViewGroupIsNull() {
    return where(VIEW_GROUP_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest whereViewGroupIsNotNull() {
    return where(VIEW_GROUP_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest filterByViewGroup(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getViewGroupSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectViewGroup() {
    return select(VIEW_GROUP_PROPERTY);
  }

  public SectionRequest unselectViewGroup() {
    return unselect(VIEW_GROUP_PROPERTY);
  }

  public SearchCriteria getViewGroupSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VIEW_GROUP_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderByViewGroup(boolean asc) {
    addOrderBy(VIEW_GROUP_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByViewGroupAscending() {
    addOrderBy(VIEW_GROUP_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByViewGroupDescending() {
    addOrderBy(VIEW_GROUP_PROPERTY, false);
    return this;
  }

  public SectionRequest orderByViewGroupAscendingUsingGBK() {
    addOrderBy("convert(viewGroup using gbk)", true);
    return this;
  }

  public SectionRequest orderByViewGroupDescendingUsingGBK() {
    addOrderBy("convert(viewGroup using gbk)", false);
    return this;
  }

  public SectionRequest countViewGroup() {
    return countViewGroup("countViewGroup");
  }

  public SectionRequest countViewGroup(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VIEW_GROUP_PROPERTY);
  }

  public SectionRequest maxViewGroup() {
    return maxViewGroup("maxViewGroup");
  }

  public SectionRequest maxViewGroup(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VIEW_GROUP_PROPERTY);
  }

  public SectionRequest minViewGroup() {
    return minViewGroup("minViewGroup");
  }

  public SectionRequest minViewGroup(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VIEW_GROUP_PROPERTY);
  }

  public SectionRequest groupByViewGroup() {
    return groupByViewGroup(VIEW_GROUP_PROPERTY);
  }

  public SectionRequest groupByViewGroup(String ret) {
    return groupBy(ret, VIEW_GROUP_PROPERTY);
  }

  public SectionRequest groupByViewGroup(SqlFunction func) {
    return groupByViewGroup(VIEW_GROUP_PROPERTY, func);
  }

  public SectionRequest groupByViewGroup(String ret, SqlFunction func) {
    super.groupBy(ret, func, VIEW_GROUP_PROPERTY);
    return this;
  }

  public SectionRequest filterByLinkToUrl(String linkToUrl) {

    if (linkToUrl == null) {
      return this;
    }

    return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
  }

  public SectionRequest whereLinkToUrlIsNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest whereLinkToUrlIsNotNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectLinkToUrl() {
    return select(LINK_TO_URL_PROPERTY);
  }

  public SectionRequest unselectLinkToUrl() {
    return unselect(LINK_TO_URL_PROPERTY);
  }

  public SearchCriteria getLinkToUrlSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderByLinkToUrl(boolean asc) {
    addOrderBy(LINK_TO_URL_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByLinkToUrlAscending() {
    addOrderBy(LINK_TO_URL_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByLinkToUrlDescending() {
    addOrderBy(LINK_TO_URL_PROPERTY, false);
    return this;
  }

  public SectionRequest orderByLinkToUrlAscendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", true);
    return this;
  }

  public SectionRequest orderByLinkToUrlDescendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", false);
    return this;
  }

  public SectionRequest countLinkToUrl() {
    return countLinkToUrl("countLinkToUrl");
  }

  public SectionRequest countLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LINK_TO_URL_PROPERTY);
  }

  public SectionRequest maxLinkToUrl() {
    return maxLinkToUrl("maxLinkToUrl");
  }

  public SectionRequest maxLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LINK_TO_URL_PROPERTY);
  }

  public SectionRequest minLinkToUrl() {
    return minLinkToUrl("minLinkToUrl");
  }

  public SectionRequest minLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LINK_TO_URL_PROPERTY);
  }

  public SectionRequest groupByLinkToUrl() {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY);
  }

  public SectionRequest groupByLinkToUrl(String ret) {
    return groupBy(ret, LINK_TO_URL_PROPERTY);
  }

  public SectionRequest groupByLinkToUrl(SqlFunction func) {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY, func);
  }

  public SectionRequest groupByLinkToUrl(String ret, SqlFunction func) {
    super.groupBy(ret, func, LINK_TO_URL_PROPERTY);
    return this;
  }

  public SectionRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SectionRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SectionRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SectionRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SectionRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SectionRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SectionRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SectionRequest countVersion() {
    return countVersion("countVersion");
  }

  public SectionRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SectionRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SectionRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SectionRequest minVersion() {
    return minVersion("minVersion");
  }

  public SectionRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SectionRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SectionRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SectionRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SectionRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SectionRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SectionRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SectionRequest filterByPage(PageRequest page) {
    return filterByPage(page, Page::getId);
  }

  public SectionRequest filterByPage(Page... page) {
    if (isEmptyParam(page)) {
      throw new IllegalArgumentException("filterByPage(Page... page)参数不能为空!");
    }
    return where(PAGE_PROPERTY, QueryOperator.IN, (Object[]) page);
  }

  public SectionRequest selectPageId() {
    select(PAGE_PROPERTY);
    return this;
  }

  public PageRequest upToPage() {
    return upToPage(PageRequest.newInstance());
  }

  public PageRequest upToPage(PageRequest page) {
    page.aggregateChild(PAGE_PROPERTY, this);
    this.groupByPage(page);
    return page;
  }

  public PageRequest endAtPage(String retName) {
    return endAtPage(retName, PageRequest.newInstance());
  }

  public PageRequest endAtPage(String retName, PageRequest page) {
    page.addDynamicProperty(retName, this, PAGE_PROPERTY);
    return page;
  }

  public SectionRequest filterByPage(String... page) {
    if (isEmptyParam(page)) {
      throw new IllegalArgumentException("filterByPage(String... page)参数不能为空!");
    }
    return where(PAGE_PROPERTY, QueryOperator.IN, (Object[]) page);
  }

  public SectionRequest filterByPage(PageRequest page, IDRefine<Page> idRefine) {
    page.unlimited();
    return addSearchCriteria(createPageCriteria(page, idRefine));
  }

  public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine) {
    return new RefinedIdInCriteria(page, PAGE_PROPERTY, idRefine, Page.ID_PROPERTY);
  }

  public SectionRequest selectPage() {
    return selectPage(PageRequest.newInstance().selectSelf());
  }

  public SectionRequest selectPage(PageRequest page) {
    selectParent(PAGE_PROPERTY, page);
    return this;
  }

  public SectionRequest unselectPage() {
    unselectParent(PAGE_PROPERTY);
    return this;
  }

  public SectionRequest groupByPage(PageRequest page) {
    groupBy(PAGE_PROPERTY, page);
    return this;
  }

  public SectionRequest aggregatePage(PageRequest page) {
    aggregateParent(PAGE_PROPERTY, page);
    return this;
  }

  public SectionRequest countPage() {
    return countPage("countPage");
  }

  public SectionRequest countPage(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAGE_PROPERTY);
  }

  public SectionRequest groupByPage() {
    return groupByPage(PAGE_PROPERTY);
  }

  public SectionRequest groupByPage(String ret) {
    return groupBy(ret, PAGE_PROPERTY);
  }

  public SectionRequest wherePageIsNull() {
    return where(PAGE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SectionRequest wherePageIsNotNull() {
    return where(PAGE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SectionRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SectionRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SectionRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SectionRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
