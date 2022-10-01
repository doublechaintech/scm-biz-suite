package com.doublechaintech.retailscm.slide;

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
import static com.doublechaintech.retailscm.slide.Slide.*;

public class SlideRequest extends BaseRequest<Slide> {
  public static SlideRequest newInstance() {
    return new SlideRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public SlideRequest resultByClass(Class<? extends Slide> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public SlideRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public SlideRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Slide";
  }

  public SlideRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public SlideRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public SlideRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public SlideRequest select(String... names) {
    super.select(names);
    return this;
  }

  public SlideRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectDisplayOrder()
        .selectImageUrl()
        .selectVideoUrl()
        .selectLinkToUrl()
        .selectPage()
        .selectVersion();
  }

  public SlideRequest selectAny() {
    return selectAll();
  }

  public SlideRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(DISPLAY_ORDER_PROPERTY);
    select(IMAGE_URL_PROPERTY);
    select(VIDEO_URL_PROPERTY);
    select(LINK_TO_URL_PROPERTY);
    select(PAGE_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public SlideRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public SlideRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    DISPLAY_ORDER_PROPERTY,
    IMAGE_URL_PROPERTY,
    VIDEO_URL_PROPERTY,
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

  public SlideRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public SlideRequest comment(String comment) {
    return this;
  }

  public SlideRequest enhance() {
    return this;
  }

  public SlideRequest overrideClass(Class<? extends Slide> clazz) {
    return this;
  }

  public SlideRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public SlideRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public SlideRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public SlideRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public SlideRequest count() {
    return countId("count");
  }

  public static SlideRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public SlideRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public SlideRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest selectId() {
    return select(ID_PROPERTY);
  }

  public SlideRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SlideRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SlideRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public SlideRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public SlideRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public SlideRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public SlideRequest countId() {
    return countId("countId");
  }

  public SlideRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public SlideRequest maxId() {
    return maxId("maxId");
  }

  public SlideRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public SlideRequest minId() {
    return minId("minId");
  }

  public SlideRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public SlideRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public SlideRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public SlideRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public SlideRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public SlideRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public SlideRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public SlideRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SlideRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public SlideRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SlideRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public SlideRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public SlideRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public SlideRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public SlideRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public SlideRequest countName() {
    return countName("countName");
  }

  public SlideRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public SlideRequest maxName() {
    return maxName("maxName");
  }

  public SlideRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public SlideRequest minName() {
    return minName("minName");
  }

  public SlideRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public SlideRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public SlideRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public SlideRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public SlideRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public SlideRequest filterByDisplayOrder(int displayOrder) {

    return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
  }

  public SlideRequest whereDisplayOrderIsNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public SlideRequest whereDisplayOrderIsNotNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SlideRequest whereDisplayOrderBetween(Integer displayOrderStart, Integer displayOrderEnd) {
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

  public SlideRequest whereDisplayOrderLessThan(Integer displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderLessThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.LESS_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest whereDisplayOrderGreaterThan(int displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderGreaterThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest selectDisplayOrder() {
    return select(DISPLAY_ORDER_PROPERTY);
  }

  public SlideRequest unselectDisplayOrder() {
    return unselect(DISPLAY_ORDER_PROPERTY);
  }

  public SearchCriteria getDisplayOrderSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SlideRequest orderByDisplayOrder(boolean asc) {
    addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
    return this;
  }

  public SlideRequest orderByDisplayOrderAscending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, true);
    return this;
  }

  public SlideRequest orderByDisplayOrderDescending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, false);
    return this;
  }

  public SlideRequest countDisplayOrder() {
    return countDisplayOrder("countDisplayOrder");
  }

  public SlideRequest countDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DISPLAY_ORDER_PROPERTY);
  }

  public SlideRequest maxDisplayOrder() {
    return maxDisplayOrder("maxDisplayOrder");
  }

  public SlideRequest maxDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DISPLAY_ORDER_PROPERTY);
  }

  public SlideRequest minDisplayOrder() {
    return minDisplayOrder("minDisplayOrder");
  }

  public SlideRequest minDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DISPLAY_ORDER_PROPERTY);
  }

  public SlideRequest sumDisplayOrder() {
    return sumDisplayOrder("sumDisplayOrder");
  }

  public SlideRequest sumDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.SUM, DISPLAY_ORDER_PROPERTY);
  }

  public SlideRequest groupByDisplayOrder() {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY);
  }

  public SlideRequest groupByDisplayOrder(String ret) {
    return groupBy(ret, DISPLAY_ORDER_PROPERTY);
  }

  public SlideRequest groupByDisplayOrder(SqlFunction func) {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY, func);
  }

  public SlideRequest groupByDisplayOrder(String ret, SqlFunction func) {
    super.groupBy(ret, func, DISPLAY_ORDER_PROPERTY);
    return this;
  }

  public SlideRequest filterByImageUrl(String imageUrl) {

    if (imageUrl == null) {
      return this;
    }

    return filterByImageUrl(QueryOperator.EQUAL, imageUrl);
  }

  public SlideRequest whereImageUrlIsNull() {
    return where(IMAGE_URL_PROPERTY, QueryOperator.IS_NULL);
  }

  public SlideRequest whereImageUrlIsNotNull() {
    return where(IMAGE_URL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SlideRequest filterByImageUrl(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getImageUrlSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest selectImageUrl() {
    return select(IMAGE_URL_PROPERTY);
  }

  public SlideRequest unselectImageUrl() {
    return unselect(IMAGE_URL_PROPERTY);
  }

  public SearchCriteria getImageUrlSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(IMAGE_URL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SlideRequest orderByImageUrl(boolean asc) {
    addOrderBy(IMAGE_URL_PROPERTY, asc);
    return this;
  }

  public SlideRequest orderByImageUrlAscending() {
    addOrderBy(IMAGE_URL_PROPERTY, true);
    return this;
  }

  public SlideRequest orderByImageUrlDescending() {
    addOrderBy(IMAGE_URL_PROPERTY, false);
    return this;
  }

  public SlideRequest orderByImageUrlAscendingUsingGBK() {
    addOrderBy("convert(imageUrl using gbk)", true);
    return this;
  }

  public SlideRequest orderByImageUrlDescendingUsingGBK() {
    addOrderBy("convert(imageUrl using gbk)", false);
    return this;
  }

  public SlideRequest countImageUrl() {
    return countImageUrl("countImageUrl");
  }

  public SlideRequest countImageUrl(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, IMAGE_URL_PROPERTY);
  }

  public SlideRequest maxImageUrl() {
    return maxImageUrl("maxImageUrl");
  }

  public SlideRequest maxImageUrl(String aggName) {
    return aggregate(aggName, AggFunc.MAX, IMAGE_URL_PROPERTY);
  }

  public SlideRequest minImageUrl() {
    return minImageUrl("minImageUrl");
  }

  public SlideRequest minImageUrl(String aggName) {
    return aggregate(aggName, AggFunc.MIN, IMAGE_URL_PROPERTY);
  }

  public SlideRequest groupByImageUrl() {
    return groupByImageUrl(IMAGE_URL_PROPERTY);
  }

  public SlideRequest groupByImageUrl(String ret) {
    return groupBy(ret, IMAGE_URL_PROPERTY);
  }

  public SlideRequest groupByImageUrl(SqlFunction func) {
    return groupByImageUrl(IMAGE_URL_PROPERTY, func);
  }

  public SlideRequest groupByImageUrl(String ret, SqlFunction func) {
    super.groupBy(ret, func, IMAGE_URL_PROPERTY);
    return this;
  }

  public SlideRequest filterByVideoUrl(String videoUrl) {

    if (videoUrl == null) {
      return this;
    }

    return filterByVideoUrl(QueryOperator.EQUAL, videoUrl);
  }

  public SlideRequest whereVideoUrlIsNull() {
    return where(VIDEO_URL_PROPERTY, QueryOperator.IS_NULL);
  }

  public SlideRequest whereVideoUrlIsNotNull() {
    return where(VIDEO_URL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SlideRequest filterByVideoUrl(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVideoUrlSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest selectVideoUrl() {
    return select(VIDEO_URL_PROPERTY);
  }

  public SlideRequest unselectVideoUrl() {
    return unselect(VIDEO_URL_PROPERTY);
  }

  public SearchCriteria getVideoUrlSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VIDEO_URL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SlideRequest orderByVideoUrl(boolean asc) {
    addOrderBy(VIDEO_URL_PROPERTY, asc);
    return this;
  }

  public SlideRequest orderByVideoUrlAscending() {
    addOrderBy(VIDEO_URL_PROPERTY, true);
    return this;
  }

  public SlideRequest orderByVideoUrlDescending() {
    addOrderBy(VIDEO_URL_PROPERTY, false);
    return this;
  }

  public SlideRequest orderByVideoUrlAscendingUsingGBK() {
    addOrderBy("convert(videoUrl using gbk)", true);
    return this;
  }

  public SlideRequest orderByVideoUrlDescendingUsingGBK() {
    addOrderBy("convert(videoUrl using gbk)", false);
    return this;
  }

  public SlideRequest countVideoUrl() {
    return countVideoUrl("countVideoUrl");
  }

  public SlideRequest countVideoUrl(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VIDEO_URL_PROPERTY);
  }

  public SlideRequest maxVideoUrl() {
    return maxVideoUrl("maxVideoUrl");
  }

  public SlideRequest maxVideoUrl(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VIDEO_URL_PROPERTY);
  }

  public SlideRequest minVideoUrl() {
    return minVideoUrl("minVideoUrl");
  }

  public SlideRequest minVideoUrl(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VIDEO_URL_PROPERTY);
  }

  public SlideRequest groupByVideoUrl() {
    return groupByVideoUrl(VIDEO_URL_PROPERTY);
  }

  public SlideRequest groupByVideoUrl(String ret) {
    return groupBy(ret, VIDEO_URL_PROPERTY);
  }

  public SlideRequest groupByVideoUrl(SqlFunction func) {
    return groupByVideoUrl(VIDEO_URL_PROPERTY, func);
  }

  public SlideRequest groupByVideoUrl(String ret, SqlFunction func) {
    super.groupBy(ret, func, VIDEO_URL_PROPERTY);
    return this;
  }

  public SlideRequest filterByLinkToUrl(String linkToUrl) {

    if (linkToUrl == null) {
      return this;
    }

    return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
  }

  public SlideRequest whereLinkToUrlIsNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NULL);
  }

  public SlideRequest whereLinkToUrlIsNotNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SlideRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest selectLinkToUrl() {
    return select(LINK_TO_URL_PROPERTY);
  }

  public SlideRequest unselectLinkToUrl() {
    return unselect(LINK_TO_URL_PROPERTY);
  }

  public SearchCriteria getLinkToUrlSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SlideRequest orderByLinkToUrl(boolean asc) {
    addOrderBy(LINK_TO_URL_PROPERTY, asc);
    return this;
  }

  public SlideRequest orderByLinkToUrlAscending() {
    addOrderBy(LINK_TO_URL_PROPERTY, true);
    return this;
  }

  public SlideRequest orderByLinkToUrlDescending() {
    addOrderBy(LINK_TO_URL_PROPERTY, false);
    return this;
  }

  public SlideRequest orderByLinkToUrlAscendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", true);
    return this;
  }

  public SlideRequest orderByLinkToUrlDescendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", false);
    return this;
  }

  public SlideRequest countLinkToUrl() {
    return countLinkToUrl("countLinkToUrl");
  }

  public SlideRequest countLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LINK_TO_URL_PROPERTY);
  }

  public SlideRequest maxLinkToUrl() {
    return maxLinkToUrl("maxLinkToUrl");
  }

  public SlideRequest maxLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LINK_TO_URL_PROPERTY);
  }

  public SlideRequest minLinkToUrl() {
    return minLinkToUrl("minLinkToUrl");
  }

  public SlideRequest minLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LINK_TO_URL_PROPERTY);
  }

  public SlideRequest groupByLinkToUrl() {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY);
  }

  public SlideRequest groupByLinkToUrl(String ret) {
    return groupBy(ret, LINK_TO_URL_PROPERTY);
  }

  public SlideRequest groupByLinkToUrl(SqlFunction func) {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY, func);
  }

  public SlideRequest groupByLinkToUrl(String ret, SqlFunction func) {
    super.groupBy(ret, func, LINK_TO_URL_PROPERTY);
    return this;
  }

  public SlideRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public SlideRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public SlideRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SlideRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public SlideRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public SlideRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public SlideRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SlideRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public SlideRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public SlideRequest countVersion() {
    return countVersion("countVersion");
  }

  public SlideRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public SlideRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public SlideRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public SlideRequest minVersion() {
    return minVersion("minVersion");
  }

  public SlideRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public SlideRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public SlideRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public SlideRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public SlideRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public SlideRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public SlideRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public SlideRequest filterByPage(PageRequest page) {
    return filterByPage(page, Page::getId);
  }

  public SlideRequest filterByPage(Page... page) {
    if (isEmptyParam(page)) {
      throw new IllegalArgumentException("filterByPage(Page... page)参数不能为空!");
    }
    return where(PAGE_PROPERTY, QueryOperator.IN, (Object[]) page);
  }

  public SlideRequest selectPageId() {
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

  public SlideRequest filterByPage(String... page) {
    if (isEmptyParam(page)) {
      throw new IllegalArgumentException("filterByPage(String... page)参数不能为空!");
    }
    return where(PAGE_PROPERTY, QueryOperator.IN, (Object[]) page);
  }

  public SlideRequest filterByPage(PageRequest page, IDRefine<Page> idRefine) {
    page.unlimited();
    return addSearchCriteria(createPageCriteria(page, idRefine));
  }

  public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine) {
    return new RefinedIdInCriteria(page, PAGE_PROPERTY, idRefine, Page.ID_PROPERTY);
  }

  public SlideRequest selectPage() {
    return selectPage(PageRequest.newInstance().selectSelf());
  }

  public SlideRequest selectPage(PageRequest page) {
    selectParent(PAGE_PROPERTY, page);
    return this;
  }

  public SlideRequest unselectPage() {
    unselectParent(PAGE_PROPERTY);
    return this;
  }

  public SlideRequest groupByPage(PageRequest page) {
    groupBy(PAGE_PROPERTY, page);
    return this;
  }

  public SlideRequest aggregatePage(PageRequest page) {
    aggregateParent(PAGE_PROPERTY, page);
    return this;
  }

  public SlideRequest countPage() {
    return countPage("countPage");
  }

  public SlideRequest countPage(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAGE_PROPERTY);
  }

  public SlideRequest groupByPage() {
    return groupByPage(PAGE_PROPERTY);
  }

  public SlideRequest groupByPage(String ret) {
    return groupBy(ret, PAGE_PROPERTY);
  }

  public SlideRequest wherePageIsNull() {
    return where(PAGE_PROPERTY, QueryOperator.IS_NULL);
  }

  public SlideRequest wherePageIsNotNull() {
    return where(PAGE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public SlideRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public SlideRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public SlideRequest unlimited() {
    super.unlimited();
    return this;
  }

  public SlideRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
