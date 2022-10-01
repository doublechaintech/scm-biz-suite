package com.doublechaintech.retailscm.uiaction;

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
import static com.doublechaintech.retailscm.uiaction.UiAction.*;

public class UiActionRequest extends BaseRequest<UiAction> {
  public static UiActionRequest newInstance() {
    return new UiActionRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public UiActionRequest resultByClass(Class<? extends UiAction> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public UiActionRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public UiActionRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "UiAction";
  }

  public UiActionRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public UiActionRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public UiActionRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public UiActionRequest select(String... names) {
    super.select(names);
    return this;
  }

  public UiActionRequest selectAll() {
    return this.selectId()
        .selectCode()
        .selectIcon()
        .selectTitle()
        .selectDisplayOrder()
        .selectBrief()
        .selectImageUrl()
        .selectLinkToUrl()
        .selectExtraData()
        .selectPage()
        .selectVersion();
  }

  public UiActionRequest selectAny() {
    return selectAll();
  }

  public UiActionRequest selectSelf() {
    select(ID_PROPERTY);
    select(CODE_PROPERTY);
    select(ICON_PROPERTY);
    select(TITLE_PROPERTY);
    select(DISPLAY_ORDER_PROPERTY);
    select(BRIEF_PROPERTY);
    select(IMAGE_URL_PROPERTY);
    select(LINK_TO_URL_PROPERTY);
    select(EXTRA_DATA_PROPERTY);
    select(PAGE_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public UiActionRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public UiActionRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    CODE_PROPERTY,
    ICON_PROPERTY,
    TITLE_PROPERTY,
    DISPLAY_ORDER_PROPERTY,
    BRIEF_PROPERTY,
    IMAGE_URL_PROPERTY,
    LINK_TO_URL_PROPERTY,
    EXTRA_DATA_PROPERTY,
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

  public UiActionRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public UiActionRequest comment(String comment) {
    return this;
  }

  public UiActionRequest enhance() {
    return this;
  }

  public UiActionRequest overrideClass(Class<? extends UiAction> clazz) {
    return this;
  }

  public UiActionRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public UiActionRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public UiActionRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public UiActionRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public UiActionRequest count() {
    return countId("count");
  }

  public static UiActionRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public UiActionRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public UiActionRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectId() {
    return select(ID_PROPERTY);
  }

  public UiActionRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public UiActionRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public UiActionRequest countId() {
    return countId("countId");
  }

  public UiActionRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public UiActionRequest maxId() {
    return maxId("maxId");
  }

  public UiActionRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public UiActionRequest minId() {
    return minId("minId");
  }

  public UiActionRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public UiActionRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public UiActionRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public UiActionRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public UiActionRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public UiActionRequest filterByCode(String code) {

    if (code == null) {
      return this;
    }

    return filterByCode(QueryOperator.EQUAL, code);
  }

  public UiActionRequest whereCodeIsNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereCodeIsNotNull() {
    return where(CODE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public UiActionRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public UiActionRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public UiActionRequest countCode() {
    return countCode("countCode");
  }

  public UiActionRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public UiActionRequest maxCode() {
    return maxCode("maxCode");
  }

  public UiActionRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public UiActionRequest minCode() {
    return minCode("minCode");
  }

  public UiActionRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public UiActionRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public UiActionRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public UiActionRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public UiActionRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public UiActionRequest filterByIcon(String icon) {

    if (icon == null) {
      return this;
    }

    return filterByIcon(QueryOperator.EQUAL, icon);
  }

  public UiActionRequest whereIconIsNull() {
    return where(ICON_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereIconIsNotNull() {
    return where(ICON_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByIcon(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIconSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectIcon() {
    return select(ICON_PROPERTY);
  }

  public UiActionRequest unselectIcon() {
    return unselect(ICON_PROPERTY);
  }

  public SearchCriteria getIconSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ICON_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByIcon(boolean asc) {
    addOrderBy(ICON_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByIconAscending() {
    addOrderBy(ICON_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByIconDescending() {
    addOrderBy(ICON_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByIconAscendingUsingGBK() {
    addOrderBy("convert(icon using gbk)", true);
    return this;
  }

  public UiActionRequest orderByIconDescendingUsingGBK() {
    addOrderBy("convert(icon using gbk)", false);
    return this;
  }

  public UiActionRequest countIcon() {
    return countIcon("countIcon");
  }

  public UiActionRequest countIcon(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ICON_PROPERTY);
  }

  public UiActionRequest maxIcon() {
    return maxIcon("maxIcon");
  }

  public UiActionRequest maxIcon(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ICON_PROPERTY);
  }

  public UiActionRequest minIcon() {
    return minIcon("minIcon");
  }

  public UiActionRequest minIcon(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ICON_PROPERTY);
  }

  public UiActionRequest groupByIcon() {
    return groupByIcon(ICON_PROPERTY);
  }

  public UiActionRequest groupByIcon(String ret) {
    return groupBy(ret, ICON_PROPERTY);
  }

  public UiActionRequest groupByIcon(SqlFunction func) {
    return groupByIcon(ICON_PROPERTY, func);
  }

  public UiActionRequest groupByIcon(String ret, SqlFunction func) {
    super.groupBy(ret, func, ICON_PROPERTY);
    return this;
  }

  public UiActionRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public UiActionRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public UiActionRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public UiActionRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public UiActionRequest countTitle() {
    return countTitle("countTitle");
  }

  public UiActionRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public UiActionRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public UiActionRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public UiActionRequest minTitle() {
    return minTitle("minTitle");
  }

  public UiActionRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public UiActionRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public UiActionRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public UiActionRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public UiActionRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public UiActionRequest filterByDisplayOrder(int displayOrder) {

    return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
  }

  public UiActionRequest whereDisplayOrderIsNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereDisplayOrderIsNotNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest whereDisplayOrderBetween(
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

  public UiActionRequest whereDisplayOrderLessThan(Integer displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderLessThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.LESS_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest whereDisplayOrderGreaterThan(int displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderGreaterThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectDisplayOrder() {
    return select(DISPLAY_ORDER_PROPERTY);
  }

  public UiActionRequest unselectDisplayOrder() {
    return unselect(DISPLAY_ORDER_PROPERTY);
  }

  public SearchCriteria getDisplayOrderSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByDisplayOrder(boolean asc) {
    addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByDisplayOrderAscending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByDisplayOrderDescending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, false);
    return this;
  }

  public UiActionRequest countDisplayOrder() {
    return countDisplayOrder("countDisplayOrder");
  }

  public UiActionRequest countDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DISPLAY_ORDER_PROPERTY);
  }

  public UiActionRequest maxDisplayOrder() {
    return maxDisplayOrder("maxDisplayOrder");
  }

  public UiActionRequest maxDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DISPLAY_ORDER_PROPERTY);
  }

  public UiActionRequest minDisplayOrder() {
    return minDisplayOrder("minDisplayOrder");
  }

  public UiActionRequest minDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DISPLAY_ORDER_PROPERTY);
  }

  public UiActionRequest sumDisplayOrder() {
    return sumDisplayOrder("sumDisplayOrder");
  }

  public UiActionRequest sumDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.SUM, DISPLAY_ORDER_PROPERTY);
  }

  public UiActionRequest groupByDisplayOrder() {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY);
  }

  public UiActionRequest groupByDisplayOrder(String ret) {
    return groupBy(ret, DISPLAY_ORDER_PROPERTY);
  }

  public UiActionRequest groupByDisplayOrder(SqlFunction func) {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY, func);
  }

  public UiActionRequest groupByDisplayOrder(String ret, SqlFunction func) {
    super.groupBy(ret, func, DISPLAY_ORDER_PROPERTY);
    return this;
  }

  public UiActionRequest filterByBrief(String brief) {

    if (brief == null) {
      return this;
    }

    return filterByBrief(QueryOperator.EQUAL, brief);
  }

  public UiActionRequest whereBriefIsNull() {
    return where(BRIEF_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereBriefIsNotNull() {
    return where(BRIEF_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByBrief(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBriefSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectBrief() {
    return select(BRIEF_PROPERTY);
  }

  public UiActionRequest unselectBrief() {
    return unselect(BRIEF_PROPERTY);
  }

  public SearchCriteria getBriefSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BRIEF_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByBrief(boolean asc) {
    addOrderBy(BRIEF_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByBriefAscending() {
    addOrderBy(BRIEF_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByBriefDescending() {
    addOrderBy(BRIEF_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByBriefAscendingUsingGBK() {
    addOrderBy("convert(brief using gbk)", true);
    return this;
  }

  public UiActionRequest orderByBriefDescendingUsingGBK() {
    addOrderBy("convert(brief using gbk)", false);
    return this;
  }

  public UiActionRequest countBrief() {
    return countBrief("countBrief");
  }

  public UiActionRequest countBrief(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BRIEF_PROPERTY);
  }

  public UiActionRequest maxBrief() {
    return maxBrief("maxBrief");
  }

  public UiActionRequest maxBrief(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BRIEF_PROPERTY);
  }

  public UiActionRequest minBrief() {
    return minBrief("minBrief");
  }

  public UiActionRequest minBrief(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BRIEF_PROPERTY);
  }

  public UiActionRequest groupByBrief() {
    return groupByBrief(BRIEF_PROPERTY);
  }

  public UiActionRequest groupByBrief(String ret) {
    return groupBy(ret, BRIEF_PROPERTY);
  }

  public UiActionRequest groupByBrief(SqlFunction func) {
    return groupByBrief(BRIEF_PROPERTY, func);
  }

  public UiActionRequest groupByBrief(String ret, SqlFunction func) {
    super.groupBy(ret, func, BRIEF_PROPERTY);
    return this;
  }

  public UiActionRequest filterByImageUrl(String imageUrl) {

    if (imageUrl == null) {
      return this;
    }

    return filterByImageUrl(QueryOperator.EQUAL, imageUrl);
  }

  public UiActionRequest whereImageUrlIsNull() {
    return where(IMAGE_URL_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereImageUrlIsNotNull() {
    return where(IMAGE_URL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByImageUrl(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getImageUrlSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectImageUrl() {
    return select(IMAGE_URL_PROPERTY);
  }

  public UiActionRequest unselectImageUrl() {
    return unselect(IMAGE_URL_PROPERTY);
  }

  public SearchCriteria getImageUrlSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(IMAGE_URL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByImageUrl(boolean asc) {
    addOrderBy(IMAGE_URL_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByImageUrlAscending() {
    addOrderBy(IMAGE_URL_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByImageUrlDescending() {
    addOrderBy(IMAGE_URL_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByImageUrlAscendingUsingGBK() {
    addOrderBy("convert(imageUrl using gbk)", true);
    return this;
  }

  public UiActionRequest orderByImageUrlDescendingUsingGBK() {
    addOrderBy("convert(imageUrl using gbk)", false);
    return this;
  }

  public UiActionRequest countImageUrl() {
    return countImageUrl("countImageUrl");
  }

  public UiActionRequest countImageUrl(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, IMAGE_URL_PROPERTY);
  }

  public UiActionRequest maxImageUrl() {
    return maxImageUrl("maxImageUrl");
  }

  public UiActionRequest maxImageUrl(String aggName) {
    return aggregate(aggName, AggFunc.MAX, IMAGE_URL_PROPERTY);
  }

  public UiActionRequest minImageUrl() {
    return minImageUrl("minImageUrl");
  }

  public UiActionRequest minImageUrl(String aggName) {
    return aggregate(aggName, AggFunc.MIN, IMAGE_URL_PROPERTY);
  }

  public UiActionRequest groupByImageUrl() {
    return groupByImageUrl(IMAGE_URL_PROPERTY);
  }

  public UiActionRequest groupByImageUrl(String ret) {
    return groupBy(ret, IMAGE_URL_PROPERTY);
  }

  public UiActionRequest groupByImageUrl(SqlFunction func) {
    return groupByImageUrl(IMAGE_URL_PROPERTY, func);
  }

  public UiActionRequest groupByImageUrl(String ret, SqlFunction func) {
    super.groupBy(ret, func, IMAGE_URL_PROPERTY);
    return this;
  }

  public UiActionRequest filterByLinkToUrl(String linkToUrl) {

    if (linkToUrl == null) {
      return this;
    }

    return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
  }

  public UiActionRequest whereLinkToUrlIsNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereLinkToUrlIsNotNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectLinkToUrl() {
    return select(LINK_TO_URL_PROPERTY);
  }

  public UiActionRequest unselectLinkToUrl() {
    return unselect(LINK_TO_URL_PROPERTY);
  }

  public SearchCriteria getLinkToUrlSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByLinkToUrl(boolean asc) {
    addOrderBy(LINK_TO_URL_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByLinkToUrlAscending() {
    addOrderBy(LINK_TO_URL_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByLinkToUrlDescending() {
    addOrderBy(LINK_TO_URL_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByLinkToUrlAscendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", true);
    return this;
  }

  public UiActionRequest orderByLinkToUrlDescendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", false);
    return this;
  }

  public UiActionRequest countLinkToUrl() {
    return countLinkToUrl("countLinkToUrl");
  }

  public UiActionRequest countLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LINK_TO_URL_PROPERTY);
  }

  public UiActionRequest maxLinkToUrl() {
    return maxLinkToUrl("maxLinkToUrl");
  }

  public UiActionRequest maxLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LINK_TO_URL_PROPERTY);
  }

  public UiActionRequest minLinkToUrl() {
    return minLinkToUrl("minLinkToUrl");
  }

  public UiActionRequest minLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LINK_TO_URL_PROPERTY);
  }

  public UiActionRequest groupByLinkToUrl() {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY);
  }

  public UiActionRequest groupByLinkToUrl(String ret) {
    return groupBy(ret, LINK_TO_URL_PROPERTY);
  }

  public UiActionRequest groupByLinkToUrl(SqlFunction func) {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY, func);
  }

  public UiActionRequest groupByLinkToUrl(String ret, SqlFunction func) {
    super.groupBy(ret, func, LINK_TO_URL_PROPERTY);
    return this;
  }

  public UiActionRequest filterByExtraData(String extraData) {

    if (extraData == null) {
      return this;
    }

    return filterByExtraData(QueryOperator.EQUAL, extraData);
  }

  public UiActionRequest whereExtraDataIsNull() {
    return where(EXTRA_DATA_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereExtraDataIsNotNull() {
    return where(EXTRA_DATA_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByExtraData(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getExtraDataSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectExtraData() {
    return select(EXTRA_DATA_PROPERTY);
  }

  public UiActionRequest unselectExtraData() {
    return unselect(EXTRA_DATA_PROPERTY);
  }

  public SearchCriteria getExtraDataSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EXTRA_DATA_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByExtraData(boolean asc) {
    addOrderBy(EXTRA_DATA_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByExtraDataAscending() {
    addOrderBy(EXTRA_DATA_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByExtraDataDescending() {
    addOrderBy(EXTRA_DATA_PROPERTY, false);
    return this;
  }

  public UiActionRequest orderByExtraDataAscendingUsingGBK() {
    addOrderBy("convert(extraData using gbk)", true);
    return this;
  }

  public UiActionRequest orderByExtraDataDescendingUsingGBK() {
    addOrderBy("convert(extraData using gbk)", false);
    return this;
  }

  public UiActionRequest countExtraData() {
    return countExtraData("countExtraData");
  }

  public UiActionRequest countExtraData(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EXTRA_DATA_PROPERTY);
  }

  public UiActionRequest maxExtraData() {
    return maxExtraData("maxExtraData");
  }

  public UiActionRequest maxExtraData(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EXTRA_DATA_PROPERTY);
  }

  public UiActionRequest minExtraData() {
    return minExtraData("minExtraData");
  }

  public UiActionRequest minExtraData(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EXTRA_DATA_PROPERTY);
  }

  public UiActionRequest groupByExtraData() {
    return groupByExtraData(EXTRA_DATA_PROPERTY);
  }

  public UiActionRequest groupByExtraData(String ret) {
    return groupBy(ret, EXTRA_DATA_PROPERTY);
  }

  public UiActionRequest groupByExtraData(SqlFunction func) {
    return groupByExtraData(EXTRA_DATA_PROPERTY, func);
  }

  public UiActionRequest groupByExtraData(String ret, SqlFunction func) {
    super.groupBy(ret, func, EXTRA_DATA_PROPERTY);
    return this;
  }

  public UiActionRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public UiActionRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public UiActionRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public UiActionRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public UiActionRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public UiActionRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public UiActionRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public UiActionRequest countVersion() {
    return countVersion("countVersion");
  }

  public UiActionRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public UiActionRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public UiActionRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public UiActionRequest minVersion() {
    return minVersion("minVersion");
  }

  public UiActionRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public UiActionRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public UiActionRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public UiActionRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public UiActionRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public UiActionRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public UiActionRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public UiActionRequest filterByPage(PageRequest page) {
    return filterByPage(page, Page::getId);
  }

  public UiActionRequest filterByPage(Page... page) {
    if (isEmptyParam(page)) {
      throw new IllegalArgumentException("filterByPage(Page... page)参数不能为空!");
    }
    return where(PAGE_PROPERTY, QueryOperator.IN, (Object[]) page);
  }

  public UiActionRequest selectPageId() {
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

  public UiActionRequest filterByPage(String... page) {
    if (isEmptyParam(page)) {
      throw new IllegalArgumentException("filterByPage(String... page)参数不能为空!");
    }
    return where(PAGE_PROPERTY, QueryOperator.IN, (Object[]) page);
  }

  public UiActionRequest filterByPage(PageRequest page, IDRefine<Page> idRefine) {
    page.unlimited();
    return addSearchCriteria(createPageCriteria(page, idRefine));
  }

  public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine) {
    return new RefinedIdInCriteria(page, PAGE_PROPERTY, idRefine, Page.ID_PROPERTY);
  }

  public UiActionRequest selectPage() {
    return selectPage(PageRequest.newInstance().selectSelf());
  }

  public UiActionRequest selectPage(PageRequest page) {
    selectParent(PAGE_PROPERTY, page);
    return this;
  }

  public UiActionRequest unselectPage() {
    unselectParent(PAGE_PROPERTY);
    return this;
  }

  public UiActionRequest groupByPage(PageRequest page) {
    groupBy(PAGE_PROPERTY, page);
    return this;
  }

  public UiActionRequest aggregatePage(PageRequest page) {
    aggregateParent(PAGE_PROPERTY, page);
    return this;
  }

  public UiActionRequest countPage() {
    return countPage("countPage");
  }

  public UiActionRequest countPage(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAGE_PROPERTY);
  }

  public UiActionRequest groupByPage() {
    return groupByPage(PAGE_PROPERTY);
  }

  public UiActionRequest groupByPage(String ret) {
    return groupBy(ret, PAGE_PROPERTY);
  }

  public UiActionRequest wherePageIsNull() {
    return where(PAGE_PROPERTY, QueryOperator.IS_NULL);
  }

  public UiActionRequest wherePageIsNotNull() {
    return where(PAGE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public UiActionRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public UiActionRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public UiActionRequest unlimited() {
    super.unlimited();
    return this;
  }

  public UiActionRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
