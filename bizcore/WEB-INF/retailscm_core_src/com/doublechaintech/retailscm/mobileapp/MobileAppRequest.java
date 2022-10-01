package com.doublechaintech.retailscm.mobileapp;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.page.PageRequest;
import com.doublechaintech.retailscm.pagetype.PageTypeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.mobileapp.MobileApp.*;

public class MobileAppRequest extends BaseRequest<MobileApp> {
  public static MobileAppRequest newInstance() {
    return new MobileAppRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public MobileAppRequest resultByClass(Class<? extends MobileApp> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public MobileAppRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public MobileAppRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "MobileApp";
  }

  public MobileAppRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public MobileAppRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public MobileAppRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public MobileAppRequest select(String... names) {
    super.select(names);
    return this;
  }

  public MobileAppRequest selectAll() {
    return this.selectId().selectName().selectVersion();
  }

  public MobileAppRequest selectAny() {
    return selectAll()
        .selectPageList(Q.page().selectSelf())
        .selectPageTypeList(Q.pageType().selectSelf());
  }

  public MobileAppRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public MobileAppRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public MobileAppRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {ID_PROPERTY, NAME_PROPERTY, VERSION_PROPERTY};

  @Override
  protected boolean isDateOrTimeField(String fieldName) {
    return super.isDateOrTimeField(fieldName, DATE_OR_TIME_FIELDS);
  }

  @Override
  protected boolean isOneOfSelfField(String fieldName) {
    return super.isOneOf(fieldName, ALL_SELF_FIELDS);
  }

  public MobileAppRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public MobileAppRequest comment(String comment) {
    return this;
  }

  public MobileAppRequest enhance() {
    return this;
  }

  public MobileAppRequest overrideClass(Class<? extends MobileApp> clazz) {
    return this;
  }

  public MobileAppRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public MobileAppRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public MobileAppRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public MobileAppRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public MobileAppRequest count() {
    return countId("count");
  }

  public static MobileAppRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public MobileAppRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public MobileAppRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MobileAppRequest selectId() {
    return select(ID_PROPERTY);
  }

  public MobileAppRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MobileAppRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public MobileAppRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public MobileAppRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public MobileAppRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public MobileAppRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public MobileAppRequest countId() {
    return countId("countId");
  }

  public MobileAppRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public MobileAppRequest maxId() {
    return maxId("maxId");
  }

  public MobileAppRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public MobileAppRequest minId() {
    return minId("minId");
  }

  public MobileAppRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public MobileAppRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public MobileAppRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public MobileAppRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public MobileAppRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public MobileAppRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public MobileAppRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public MobileAppRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MobileAppRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MobileAppRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public MobileAppRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MobileAppRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public MobileAppRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public MobileAppRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public MobileAppRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public MobileAppRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public MobileAppRequest countName() {
    return countName("countName");
  }

  public MobileAppRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public MobileAppRequest maxName() {
    return maxName("maxName");
  }

  public MobileAppRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public MobileAppRequest minName() {
    return minName("minName");
  }

  public MobileAppRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public MobileAppRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public MobileAppRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public MobileAppRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public MobileAppRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public MobileAppRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public MobileAppRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public MobileAppRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public MobileAppRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public MobileAppRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public MobileAppRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public MobileAppRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public MobileAppRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public MobileAppRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public MobileAppRequest countVersion() {
    return countVersion("countVersion");
  }

  public MobileAppRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public MobileAppRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public MobileAppRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public MobileAppRequest minVersion() {
    return minVersion("minVersion");
  }

  public MobileAppRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public MobileAppRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public MobileAppRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public MobileAppRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public MobileAppRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public MobileAppRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public MobileAppRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public MobileAppRequest hasPage() {
    return hasPage(PageRequest.newInstance());
  }

  public MobileAppRequest hasPage(Page... page) {
    if (isEmptyParam(page)) {
      throw new IllegalArgumentException("hasPage(Page... page)参数不能为空!");
    }
    return hasPage(
        Q.page().select(Page.MOBILE_APP_PROPERTY).filterById(QueryOperator.IN, (Object[]) page));
  }

  public MobileAppRequest hasPage(String... page) {
    return hasPage(Q.page().select(Page.MOBILE_APP_PROPERTY).filterById(page));
  }

  public MobileAppRequest hasPage(PageRequest page) {
    return hasPage(
        page,
        $page ->
            java.util.Optional.of($page)
                .map(Page::getMobileApp)
                .map(MobileApp::getId)
                .orElse(null));
  }

  public MobileAppRequest hasPage(PageRequest page, IDRefine<Page> idRefine) {
    page.select(Page.MOBILE_APP_PROPERTY);
    page.unlimited();
    return addSearchCriteria(createPageCriteria(page, idRefine));
  }

  public MobileAppRequest hasPage(PageRequest page, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(page, Page.MOBILE_APP_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createPageCriteria(PageRequest page, IDRefine<Page> idRefine) {
    return new RefinedIdInCriteria(page, ID_PROPERTY, idRefine, Page.MOBILE_APP_PROPERTY);
  }

  public MobileAppRequest selectPageList(PageRequest page) {
    selectChild(Page.MOBILE_APP_PROPERTY, page);
    return this;
  }

  public MobileAppRequest selectPageList() {
    return selectPageList(PageRequest.newInstance().selectAll());
  }

  public MobileAppRequest unselectPageList() {
    unselectChild(Page.MOBILE_APP_PROPERTY, Page.class);
    return this;
  }

  public MobileAppRequest hasPageType() {
    return hasPageType(PageTypeRequest.newInstance());
  }

  public MobileAppRequest hasPageType(PageType... pageType) {
    if (isEmptyParam(pageType)) {
      throw new IllegalArgumentException("hasPageType(PageType... pageType)参数不能为空!");
    }
    return hasPageType(
        Q.pageType()
            .select(PageType.MOBILE_APP_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) pageType));
  }

  public MobileAppRequest hasPageType(String... pageType) {
    return hasPageType(Q.pageType().select(PageType.MOBILE_APP_PROPERTY).filterById(pageType));
  }

  public MobileAppRequest hasPageType(PageTypeRequest pageType) {
    return hasPageType(
        pageType,
        $pageType ->
            java.util.Optional.of($pageType)
                .map(PageType::getMobileApp)
                .map(MobileApp::getId)
                .orElse(null));
  }

  public MobileAppRequest hasPageType(PageTypeRequest pageType, IDRefine<PageType> idRefine) {
    pageType.select(PageType.MOBILE_APP_PROPERTY);
    pageType.unlimited();
    return addSearchCriteria(createPageTypeCriteria(pageType, idRefine));
  }

  public MobileAppRequest hasPageType(
      PageTypeRequest pageType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(pageType, PageType.MOBILE_APP_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createPageTypeCriteria(
      PageTypeRequest pageType, IDRefine<PageType> idRefine) {
    return new RefinedIdInCriteria(pageType, ID_PROPERTY, idRefine, PageType.MOBILE_APP_PROPERTY);
  }

  public MobileAppRequest selectPageTypeList(PageTypeRequest pageType) {
    selectChild(PageType.MOBILE_APP_PROPERTY, pageType);
    return this;
  }

  public MobileAppRequest selectPageTypeList() {
    return selectPageTypeList(PageTypeRequest.newInstance().selectAll());
  }

  public MobileAppRequest unselectPageTypeList() {
    unselectChild(PageType.MOBILE_APP_PROPERTY, PageType.class);
    return this;
  }

  public MobileAppRequest aggregatePageList(PageRequest page) {
    aggregateChild(Page.MOBILE_APP_PROPERTY, page);
    return this;
  }

  public MobileAppRequest countPage() {
    return countPage("pageCount");
  }

  public MobileAppRequest countPage(String retName) {
    return countPage(retName, PageRequest.newInstance());
  }

  public MobileAppRequest countPage(PageRequest page) {
    return countPage("pageCount", page);
  }

  public MobileAppRequest countPage(String retName, PageRequest page) {
    page.count();
    return statsFromPage(retName, page);
  }

  public MobileAppRequest statsFromPage(String retName, PageRequest page) {
    return addDynamicProperty(retName, page, Page.MOBILE_APP_PROPERTY);
  }

  public MobileAppRequest aggregatePageTypeList(PageTypeRequest pageType) {
    aggregateChild(PageType.MOBILE_APP_PROPERTY, pageType);
    return this;
  }

  public MobileAppRequest countPageType() {
    return countPageType("pageTypeCount");
  }

  public MobileAppRequest countPageType(String retName) {
    return countPageType(retName, PageTypeRequest.newInstance());
  }

  public MobileAppRequest countPageType(PageTypeRequest pageType) {
    return countPageType("pageTypeCount", pageType);
  }

  public MobileAppRequest countPageType(String retName, PageTypeRequest pageType) {
    pageType.count();
    return statsFromPageType(retName, pageType);
  }

  public MobileAppRequest statsFromPageType(String retName, PageTypeRequest pageType) {
    return addDynamicProperty(retName, pageType, PageType.MOBILE_APP_PROPERTY);
  }

  public MobileAppRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public MobileAppRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public MobileAppRequest unlimited() {
    super.unlimited();
    return this;
  }

  public MobileAppRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
