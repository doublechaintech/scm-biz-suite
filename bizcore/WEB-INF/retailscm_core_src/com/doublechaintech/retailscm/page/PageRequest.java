package com.doublechaintech.retailscm.page;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.section.Section;
import com.doublechaintech.retailscm.slide.Slide;
import com.doublechaintech.retailscm.uiaction.UiAction;
import com.doublechaintech.retailscm.mobileapp.MobileAppRequest;
import com.doublechaintech.retailscm.pagetype.PageTypeRequest;
import com.doublechaintech.retailscm.section.SectionRequest;
import com.doublechaintech.retailscm.slide.SlideRequest;
import com.doublechaintech.retailscm.uiaction.UiActionRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.page.Page.*;

public class PageRequest extends BaseRequest<Page> {
  public static PageRequest newInstance() {
    return new PageRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PageRequest resultByClass(Class<? extends Page> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PageRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PageRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Page";
  }

  public PageRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PageRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PageRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PageRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PageRequest selectAll() {
    return this.selectId()
        .selectPageTitle()
        .selectLinkToUrl()
        .selectPageType()
        .selectDisplayOrder()
        .selectMobileApp()
        .selectVersion();
  }

  public PageRequest selectAny() {
    return selectAll()
        .selectSlideList(Q.slide().selectSelf())
        .selectUiActionList(Q.uiAction().selectSelf())
        .selectSectionList(Q.section().selectSelf());
  }

  public PageRequest selectSelf() {
    select(ID_PROPERTY);
    select(PAGE_TITLE_PROPERTY);
    select(LINK_TO_URL_PROPERTY);
    select(PAGE_TYPE_PROPERTY);
    select(DISPLAY_ORDER_PROPERTY);
    select(MOBILE_APP_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PageRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PageRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    PAGE_TITLE_PROPERTY,
    LINK_TO_URL_PROPERTY,
    PAGE_TYPE_PROPERTY,
    DISPLAY_ORDER_PROPERTY,
    MOBILE_APP_PROPERTY,
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

  public PageRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PageRequest comment(String comment) {
    return this;
  }

  public PageRequest enhance() {
    return this;
  }

  public PageRequest overrideClass(Class<? extends Page> clazz) {
    return this;
  }

  public PageRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PageRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PageRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PageRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PageRequest count() {
    return countId("count");
  }

  public static PageRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public PageRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PageRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PageRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PageRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PageRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PageRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PageRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PageRequest countId() {
    return countId("countId");
  }

  public PageRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PageRequest maxId() {
    return maxId("maxId");
  }

  public PageRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PageRequest minId() {
    return minId("minId");
  }

  public PageRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PageRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PageRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PageRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PageRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PageRequest filterByPageTitle(String pageTitle) {

    if (pageTitle == null) {
      return this;
    }

    return filterByPageTitle(QueryOperator.EQUAL, pageTitle);
  }

  public PageRequest wherePageTitleIsNull() {
    return where(PAGE_TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageRequest wherePageTitleIsNotNull() {
    return where(PAGE_TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageRequest filterByPageTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPageTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageRequest selectPageTitle() {
    return select(PAGE_TITLE_PROPERTY);
  }

  public PageRequest unselectPageTitle() {
    return unselect(PAGE_TITLE_PROPERTY);
  }

  public SearchCriteria getPageTitleSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PAGE_TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageRequest orderByPageTitle(boolean asc) {
    addOrderBy(PAGE_TITLE_PROPERTY, asc);
    return this;
  }

  public PageRequest orderByPageTitleAscending() {
    addOrderBy(PAGE_TITLE_PROPERTY, true);
    return this;
  }

  public PageRequest orderByPageTitleDescending() {
    addOrderBy(PAGE_TITLE_PROPERTY, false);
    return this;
  }

  public PageRequest orderByPageTitleAscendingUsingGBK() {
    addOrderBy("convert(pageTitle using gbk)", true);
    return this;
  }

  public PageRequest orderByPageTitleDescendingUsingGBK() {
    addOrderBy("convert(pageTitle using gbk)", false);
    return this;
  }

  public PageRequest countPageTitle() {
    return countPageTitle("countPageTitle");
  }

  public PageRequest countPageTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAGE_TITLE_PROPERTY);
  }

  public PageRequest maxPageTitle() {
    return maxPageTitle("maxPageTitle");
  }

  public PageRequest maxPageTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PAGE_TITLE_PROPERTY);
  }

  public PageRequest minPageTitle() {
    return minPageTitle("minPageTitle");
  }

  public PageRequest minPageTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PAGE_TITLE_PROPERTY);
  }

  public PageRequest groupByPageTitle() {
    return groupByPageTitle(PAGE_TITLE_PROPERTY);
  }

  public PageRequest groupByPageTitle(String ret) {
    return groupBy(ret, PAGE_TITLE_PROPERTY);
  }

  public PageRequest groupByPageTitle(SqlFunction func) {
    return groupByPageTitle(PAGE_TITLE_PROPERTY, func);
  }

  public PageRequest groupByPageTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, PAGE_TITLE_PROPERTY);
    return this;
  }

  public PageRequest filterByLinkToUrl(String linkToUrl) {

    if (linkToUrl == null) {
      return this;
    }

    return filterByLinkToUrl(QueryOperator.EQUAL, linkToUrl);
  }

  public PageRequest whereLinkToUrlIsNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageRequest whereLinkToUrlIsNotNull() {
    return where(LINK_TO_URL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageRequest filterByLinkToUrl(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLinkToUrlSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageRequest selectLinkToUrl() {
    return select(LINK_TO_URL_PROPERTY);
  }

  public PageRequest unselectLinkToUrl() {
    return unselect(LINK_TO_URL_PROPERTY);
  }

  public SearchCriteria getLinkToUrlSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LINK_TO_URL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageRequest orderByLinkToUrl(boolean asc) {
    addOrderBy(LINK_TO_URL_PROPERTY, asc);
    return this;
  }

  public PageRequest orderByLinkToUrlAscending() {
    addOrderBy(LINK_TO_URL_PROPERTY, true);
    return this;
  }

  public PageRequest orderByLinkToUrlDescending() {
    addOrderBy(LINK_TO_URL_PROPERTY, false);
    return this;
  }

  public PageRequest orderByLinkToUrlAscendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", true);
    return this;
  }

  public PageRequest orderByLinkToUrlDescendingUsingGBK() {
    addOrderBy("convert(linkToUrl using gbk)", false);
    return this;
  }

  public PageRequest countLinkToUrl() {
    return countLinkToUrl("countLinkToUrl");
  }

  public PageRequest countLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LINK_TO_URL_PROPERTY);
  }

  public PageRequest maxLinkToUrl() {
    return maxLinkToUrl("maxLinkToUrl");
  }

  public PageRequest maxLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LINK_TO_URL_PROPERTY);
  }

  public PageRequest minLinkToUrl() {
    return minLinkToUrl("minLinkToUrl");
  }

  public PageRequest minLinkToUrl(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LINK_TO_URL_PROPERTY);
  }

  public PageRequest groupByLinkToUrl() {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY);
  }

  public PageRequest groupByLinkToUrl(String ret) {
    return groupBy(ret, LINK_TO_URL_PROPERTY);
  }

  public PageRequest groupByLinkToUrl(SqlFunction func) {
    return groupByLinkToUrl(LINK_TO_URL_PROPERTY, func);
  }

  public PageRequest groupByLinkToUrl(String ret, SqlFunction func) {
    super.groupBy(ret, func, LINK_TO_URL_PROPERTY);
    return this;
  }

  public PageRequest filterByDisplayOrder(int displayOrder) {

    return filterByDisplayOrder(QueryOperator.EQUAL, displayOrder);
  }

  public PageRequest whereDisplayOrderIsNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageRequest whereDisplayOrderIsNotNull() {
    return where(DISPLAY_ORDER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageRequest whereDisplayOrderBetween(Integer displayOrderStart, Integer displayOrderEnd) {
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

  public PageRequest whereDisplayOrderLessThan(Integer displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderLessThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.LESS_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public PageRequest whereDisplayOrderGreaterThan(int displayOrder) {
    if (ObjectUtil.isEmpty(displayOrder)) {
      throw new IllegalArgumentException(
          "Method whereDisplayOrderGreaterThan, the parameter displayOrder is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getDisplayOrderSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {displayOrder});
    return addSearchCriteria(searchCriteria);
  }

  public PageRequest filterByDisplayOrder(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDisplayOrderSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageRequest selectDisplayOrder() {
    return select(DISPLAY_ORDER_PROPERTY);
  }

  public PageRequest unselectDisplayOrder() {
    return unselect(DISPLAY_ORDER_PROPERTY);
  }

  public SearchCriteria getDisplayOrderSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DISPLAY_ORDER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageRequest orderByDisplayOrder(boolean asc) {
    addOrderBy(DISPLAY_ORDER_PROPERTY, asc);
    return this;
  }

  public PageRequest orderByDisplayOrderAscending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, true);
    return this;
  }

  public PageRequest orderByDisplayOrderDescending() {
    addOrderBy(DISPLAY_ORDER_PROPERTY, false);
    return this;
  }

  public PageRequest countDisplayOrder() {
    return countDisplayOrder("countDisplayOrder");
  }

  public PageRequest countDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DISPLAY_ORDER_PROPERTY);
  }

  public PageRequest maxDisplayOrder() {
    return maxDisplayOrder("maxDisplayOrder");
  }

  public PageRequest maxDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DISPLAY_ORDER_PROPERTY);
  }

  public PageRequest minDisplayOrder() {
    return minDisplayOrder("minDisplayOrder");
  }

  public PageRequest minDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DISPLAY_ORDER_PROPERTY);
  }

  public PageRequest sumDisplayOrder() {
    return sumDisplayOrder("sumDisplayOrder");
  }

  public PageRequest sumDisplayOrder(String aggName) {
    return aggregate(aggName, AggFunc.SUM, DISPLAY_ORDER_PROPERTY);
  }

  public PageRequest groupByDisplayOrder() {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY);
  }

  public PageRequest groupByDisplayOrder(String ret) {
    return groupBy(ret, DISPLAY_ORDER_PROPERTY);
  }

  public PageRequest groupByDisplayOrder(SqlFunction func) {
    return groupByDisplayOrder(DISPLAY_ORDER_PROPERTY, func);
  }

  public PageRequest groupByDisplayOrder(String ret, SqlFunction func) {
    super.groupBy(ret, func, DISPLAY_ORDER_PROPERTY);
    return this;
  }

  public PageRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PageRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PageRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PageRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PageRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PageRequest countVersion() {
    return countVersion("countVersion");
  }

  public PageRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PageRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PageRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PageRequest minVersion() {
    return minVersion("minVersion");
  }

  public PageRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PageRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PageRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PageRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PageRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PageRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PageRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PageRequest filterByPageType(PageTypeRequest pageType) {
    return filterByPageType(pageType, PageType::getId);
  }

  public PageRequest filterByPageType(PageType... pageType) {
    if (isEmptyParam(pageType)) {
      throw new IllegalArgumentException("filterByPageType(PageType... pageType)参数不能为空!");
    }
    return where(PAGE_TYPE_PROPERTY, QueryOperator.IN, (Object[]) pageType);
  }

  public PageRequest selectPageTypeId() {
    select(PAGE_TYPE_PROPERTY);
    return this;
  }

  public PageTypeRequest upToPageType() {
    return upToPageType(PageTypeRequest.newInstance());
  }

  public PageTypeRequest upToPageType(PageTypeRequest pageType) {
    pageType.aggregateChild(PAGE_TYPE_PROPERTY, this);
    this.groupByPageType(pageType);
    return pageType;
  }

  public PageTypeRequest endAtPageType(String retName) {
    return endAtPageType(retName, PageTypeRequest.newInstance());
  }

  public PageTypeRequest endAtPageType(String retName, PageTypeRequest pageType) {
    pageType.addDynamicProperty(retName, this, PAGE_TYPE_PROPERTY);
    return pageType;
  }

  public PageRequest filterByPageType(String... pageType) {
    if (isEmptyParam(pageType)) {
      throw new IllegalArgumentException("filterByPageType(String... pageType)参数不能为空!");
    }
    return where(PAGE_TYPE_PROPERTY, QueryOperator.IN, (Object[]) pageType);
  }

  public PageRequest filterByPageType(PageTypeRequest pageType, IDRefine<PageType> idRefine) {
    pageType.unlimited();
    return addSearchCriteria(createPageTypeCriteria(pageType, idRefine));
  }

  public SearchCriteria createPageTypeCriteria(
      PageTypeRequest pageType, IDRefine<PageType> idRefine) {
    return new RefinedIdInCriteria(pageType, PAGE_TYPE_PROPERTY, idRefine, PageType.ID_PROPERTY);
  }

  public PageRequest selectPageType() {
    return selectPageType(PageTypeRequest.newInstance().selectSelf());
  }

  public PageRequest selectPageType(PageTypeRequest pageType) {
    selectParent(PAGE_TYPE_PROPERTY, pageType);
    return this;
  }

  public PageRequest unselectPageType() {
    unselectParent(PAGE_TYPE_PROPERTY);
    return this;
  }

  public PageRequest groupByPageType(PageTypeRequest pageType) {
    groupBy(PAGE_TYPE_PROPERTY, pageType);
    return this;
  }

  public PageRequest aggregatePageType(PageTypeRequest pageType) {
    aggregateParent(PAGE_TYPE_PROPERTY, pageType);
    return this;
  }

  public PageRequest countPageType() {
    return countPageType("countPageType");
  }

  public PageRequest countPageType(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAGE_TYPE_PROPERTY);
  }

  public PageRequest groupByPageType() {
    return groupByPageType(PAGE_TYPE_PROPERTY);
  }

  public PageRequest groupByPageType(String ret) {
    return groupBy(ret, PAGE_TYPE_PROPERTY);
  }

  public PageRequest wherePageTypeIsNull() {
    return where(PAGE_TYPE_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageRequest wherePageTypeIsNotNull() {
    return where(PAGE_TYPE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageRequest filterByMobileApp(MobileAppRequest mobileApp) {
    return filterByMobileApp(mobileApp, MobileApp::getId);
  }

  public PageRequest filterByMobileApp(MobileApp... mobileApp) {
    if (isEmptyParam(mobileApp)) {
      throw new IllegalArgumentException("filterByMobileApp(MobileApp... mobileApp)参数不能为空!");
    }
    return where(MOBILE_APP_PROPERTY, QueryOperator.IN, (Object[]) mobileApp);
  }

  public PageRequest selectMobileAppId() {
    select(MOBILE_APP_PROPERTY);
    return this;
  }

  public MobileAppRequest upToMobileApp() {
    return upToMobileApp(MobileAppRequest.newInstance());
  }

  public MobileAppRequest upToMobileApp(MobileAppRequest mobileApp) {
    mobileApp.aggregateChild(MOBILE_APP_PROPERTY, this);
    this.groupByMobileApp(mobileApp);
    return mobileApp;
  }

  public MobileAppRequest endAtMobileApp(String retName) {
    return endAtMobileApp(retName, MobileAppRequest.newInstance());
  }

  public MobileAppRequest endAtMobileApp(String retName, MobileAppRequest mobileApp) {
    mobileApp.addDynamicProperty(retName, this, MOBILE_APP_PROPERTY);
    return mobileApp;
  }

  public PageRequest filterByMobileApp(String... mobileApp) {
    if (isEmptyParam(mobileApp)) {
      throw new IllegalArgumentException("filterByMobileApp(String... mobileApp)参数不能为空!");
    }
    return where(MOBILE_APP_PROPERTY, QueryOperator.IN, (Object[]) mobileApp);
  }

  public PageRequest filterByMobileApp(MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
    mobileApp.unlimited();
    return addSearchCriteria(createMobileAppCriteria(mobileApp, idRefine));
  }

  public SearchCriteria createMobileAppCriteria(
      MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
    return new RefinedIdInCriteria(mobileApp, MOBILE_APP_PROPERTY, idRefine, MobileApp.ID_PROPERTY);
  }

  public PageRequest selectMobileApp() {
    return selectMobileApp(MobileAppRequest.newInstance().selectSelf());
  }

  public PageRequest selectMobileApp(MobileAppRequest mobileApp) {
    selectParent(MOBILE_APP_PROPERTY, mobileApp);
    return this;
  }

  public PageRequest unselectMobileApp() {
    unselectParent(MOBILE_APP_PROPERTY);
    return this;
  }

  public PageRequest groupByMobileApp(MobileAppRequest mobileApp) {
    groupBy(MOBILE_APP_PROPERTY, mobileApp);
    return this;
  }

  public PageRequest aggregateMobileApp(MobileAppRequest mobileApp) {
    aggregateParent(MOBILE_APP_PROPERTY, mobileApp);
    return this;
  }

  public PageRequest countMobileApp() {
    return countMobileApp("countMobileApp");
  }

  public PageRequest countMobileApp(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_APP_PROPERTY);
  }

  public PageRequest groupByMobileApp() {
    return groupByMobileApp(MOBILE_APP_PROPERTY);
  }

  public PageRequest groupByMobileApp(String ret) {
    return groupBy(ret, MOBILE_APP_PROPERTY);
  }

  public PageRequest whereMobileAppIsNull() {
    return where(MOBILE_APP_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageRequest whereMobileAppIsNotNull() {
    return where(MOBILE_APP_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageRequest hasSlide() {
    return hasSlide(SlideRequest.newInstance());
  }

  public PageRequest hasSlide(Slide... slide) {
    if (isEmptyParam(slide)) {
      throw new IllegalArgumentException("hasSlide(Slide... slide)参数不能为空!");
    }
    return hasSlide(
        Q.slide().select(Slide.PAGE_PROPERTY).filterById(QueryOperator.IN, (Object[]) slide));
  }

  public PageRequest hasSlide(String... slide) {
    return hasSlide(Q.slide().select(Slide.PAGE_PROPERTY).filterById(slide));
  }

  public PageRequest hasSlide(SlideRequest slide) {
    return hasSlide(
        slide,
        $slide -> java.util.Optional.of($slide).map(Slide::getPage).map(Page::getId).orElse(null));
  }

  public PageRequest hasSlide(SlideRequest slide, IDRefine<Slide> idRefine) {
    slide.select(Slide.PAGE_PROPERTY);
    slide.unlimited();
    return addSearchCriteria(createSlideCriteria(slide, idRefine));
  }

  public PageRequest hasSlide(SlideRequest slide, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(slide, Slide.PAGE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSlideCriteria(SlideRequest slide, IDRefine<Slide> idRefine) {
    return new RefinedIdInCriteria(slide, ID_PROPERTY, idRefine, Slide.PAGE_PROPERTY);
  }

  public PageRequest selectSlideList(SlideRequest slide) {
    selectChild(Slide.PAGE_PROPERTY, slide);
    return this;
  }

  public PageRequest selectSlideList() {
    return selectSlideList(SlideRequest.newInstance().selectAll());
  }

  public PageRequest unselectSlideList() {
    unselectChild(Slide.PAGE_PROPERTY, Slide.class);
    return this;
  }

  public PageRequest hasUiAction() {
    return hasUiAction(UiActionRequest.newInstance());
  }

  public PageRequest hasUiAction(UiAction... uiAction) {
    if (isEmptyParam(uiAction)) {
      throw new IllegalArgumentException("hasUiAction(UiAction... uiAction)参数不能为空!");
    }
    return hasUiAction(
        Q.uiAction()
            .select(UiAction.PAGE_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) uiAction));
  }

  public PageRequest hasUiAction(String... uiAction) {
    return hasUiAction(Q.uiAction().select(UiAction.PAGE_PROPERTY).filterById(uiAction));
  }

  public PageRequest hasUiAction(UiActionRequest uiAction) {
    return hasUiAction(
        uiAction,
        $uiAction ->
            java.util.Optional.of($uiAction).map(UiAction::getPage).map(Page::getId).orElse(null));
  }

  public PageRequest hasUiAction(UiActionRequest uiAction, IDRefine<UiAction> idRefine) {
    uiAction.select(UiAction.PAGE_PROPERTY);
    uiAction.unlimited();
    return addSearchCriteria(createUiActionCriteria(uiAction, idRefine));
  }

  public PageRequest hasUiAction(
      UiActionRequest uiAction, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(uiAction, UiAction.PAGE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createUiActionCriteria(
      UiActionRequest uiAction, IDRefine<UiAction> idRefine) {
    return new RefinedIdInCriteria(uiAction, ID_PROPERTY, idRefine, UiAction.PAGE_PROPERTY);
  }

  public PageRequest selectUiActionList(UiActionRequest uiAction) {
    selectChild(UiAction.PAGE_PROPERTY, uiAction);
    return this;
  }

  public PageRequest selectUiActionList() {
    return selectUiActionList(UiActionRequest.newInstance().selectAll());
  }

  public PageRequest unselectUiActionList() {
    unselectChild(UiAction.PAGE_PROPERTY, UiAction.class);
    return this;
  }

  public PageRequest hasSection() {
    return hasSection(SectionRequest.newInstance());
  }

  public PageRequest hasSection(Section... section) {
    if (isEmptyParam(section)) {
      throw new IllegalArgumentException("hasSection(Section... section)参数不能为空!");
    }
    return hasSection(
        Q.section().select(Section.PAGE_PROPERTY).filterById(QueryOperator.IN, (Object[]) section));
  }

  public PageRequest hasSection(String... section) {
    return hasSection(Q.section().select(Section.PAGE_PROPERTY).filterById(section));
  }

  public PageRequest hasSection(SectionRequest section) {
    return hasSection(
        section,
        $section ->
            java.util.Optional.of($section).map(Section::getPage).map(Page::getId).orElse(null));
  }

  public PageRequest hasSection(SectionRequest section, IDRefine<Section> idRefine) {
    section.select(Section.PAGE_PROPERTY);
    section.unlimited();
    return addSearchCriteria(createSectionCriteria(section, idRefine));
  }

  public PageRequest hasSection(SectionRequest section, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(section, Section.PAGE_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSectionCriteria(SectionRequest section, IDRefine<Section> idRefine) {
    return new RefinedIdInCriteria(section, ID_PROPERTY, idRefine, Section.PAGE_PROPERTY);
  }

  public PageRequest selectSectionList(SectionRequest section) {
    selectChild(Section.PAGE_PROPERTY, section);
    return this;
  }

  public PageRequest selectSectionList() {
    return selectSectionList(SectionRequest.newInstance().selectAll());
  }

  public PageRequest unselectSectionList() {
    unselectChild(Section.PAGE_PROPERTY, Section.class);
    return this;
  }

  public PageRequest aggregateSlideList(SlideRequest slide) {
    aggregateChild(Slide.PAGE_PROPERTY, slide);
    return this;
  }

  public PageRequest countSlide() {
    return countSlide("slideCount");
  }

  public PageRequest countSlide(String retName) {
    return countSlide(retName, SlideRequest.newInstance());
  }

  public PageRequest countSlide(SlideRequest slide) {
    return countSlide("slideCount", slide);
  }

  public PageRequest countSlide(String retName, SlideRequest slide) {
    slide.count();
    return statsFromSlide(retName, slide);
  }

  public PageRequest statsFromSlide(String retName, SlideRequest slide) {
    return addDynamicProperty(retName, slide, Slide.PAGE_PROPERTY);
  }

  public PageRequest aggregateUiActionList(UiActionRequest uiAction) {
    aggregateChild(UiAction.PAGE_PROPERTY, uiAction);
    return this;
  }

  public PageRequest countUiAction() {
    return countUiAction("uiActionCount");
  }

  public PageRequest countUiAction(String retName) {
    return countUiAction(retName, UiActionRequest.newInstance());
  }

  public PageRequest countUiAction(UiActionRequest uiAction) {
    return countUiAction("uiActionCount", uiAction);
  }

  public PageRequest countUiAction(String retName, UiActionRequest uiAction) {
    uiAction.count();
    return statsFromUiAction(retName, uiAction);
  }

  public PageRequest statsFromUiAction(String retName, UiActionRequest uiAction) {
    return addDynamicProperty(retName, uiAction, UiAction.PAGE_PROPERTY);
  }

  public PageRequest aggregateSectionList(SectionRequest section) {
    aggregateChild(Section.PAGE_PROPERTY, section);
    return this;
  }

  public PageRequest countSection() {
    return countSection("sectionCount");
  }

  public PageRequest countSection(String retName) {
    return countSection(retName, SectionRequest.newInstance());
  }

  public PageRequest countSection(SectionRequest section) {
    return countSection("sectionCount", section);
  }

  public PageRequest countSection(String retName, SectionRequest section) {
    section.count();
    return statsFromSection(retName, section);
  }

  public PageRequest statsFromSection(String retName, SectionRequest section) {
    return addDynamicProperty(retName, section, Section.PAGE_PROPERTY);
  }

  public PageRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PageRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PageRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PageRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
