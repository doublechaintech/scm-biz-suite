package com.doublechaintech.retailscm.pagetype;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.page.Page;
import com.doublechaintech.retailscm.mobileapp.MobileAppRequest;
import com.doublechaintech.retailscm.page.PageRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.pagetype.PageType.*;

public class PageTypeRequest extends BaseRequest<PageType> {
  public static PageTypeRequest newInstance() {
    return new PageTypeRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PageTypeRequest resultByClass(Class<? extends PageType> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PageTypeRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PageTypeRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "PageType";
  }

  public PageTypeRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PageTypeRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PageTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PageTypeRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PageTypeRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectCode()
        .selectMobileApp()
        .selectFooterTab()
        .selectVersion();
  }

  public PageTypeRequest selectAny() {
    return selectAll();
  }

  public PageTypeRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(CODE_PROPERTY);
    select(MOBILE_APP_PROPERTY);
    select(FOOTER_TAB_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PageTypeRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PageTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    CODE_PROPERTY,
    MOBILE_APP_PROPERTY,
    FOOTER_TAB_PROPERTY,
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

  public PageTypeRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PageTypeRequest comment(String comment) {
    return this;
  }

  public PageTypeRequest enhance() {
    return this;
  }

  public PageTypeRequest overrideClass(Class<? extends PageType> clazz) {
    return this;
  }

  public PageTypeRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PageTypeRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PageTypeRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PageTypeRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PageTypeRequest count() {
    return countId("count");
  }

  public static PageTypeRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public static PageTypeRequest withCode(String... code) {
    return newInstance().filterByCode(code).selectAll();
  }

  public PageTypeRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PageTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageTypeRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PageTypeRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageTypeRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PageTypeRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PageTypeRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PageTypeRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PageTypeRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PageTypeRequest countId() {
    return countId("countId");
  }

  public PageTypeRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PageTypeRequest maxId() {
    return maxId("maxId");
  }

  public PageTypeRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PageTypeRequest minId() {
    return minId("minId");
  }

  public PageTypeRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PageTypeRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PageTypeRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PageTypeRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PageTypeRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PageTypeRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public PageTypeRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageTypeRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageTypeRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageTypeRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public PageTypeRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageTypeRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public PageTypeRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public PageTypeRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public PageTypeRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public PageTypeRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public PageTypeRequest countName() {
    return countName("countName");
  }

  public PageTypeRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public PageTypeRequest maxName() {
    return maxName("maxName");
  }

  public PageTypeRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public PageTypeRequest minName() {
    return minName("minName");
  }

  public PageTypeRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public PageTypeRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public PageTypeRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public PageTypeRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public PageTypeRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public PageTypeRequest filterByCode(String... code) {
    if (isEmptyParam(code)) {
      throw new IllegalArgumentException("filterByCode(String... code)参数不能为空!");
    }
    return filterByCode(QueryOperator.IN, (Object[]) code);
  }

  public PageTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageTypeRequest selectCode() {
    return select(CODE_PROPERTY);
  }

  public PageTypeRequest unselectCode() {
    return unselect(CODE_PROPERTY);
  }

  public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageTypeRequest orderByCode(boolean asc) {
    addOrderBy(CODE_PROPERTY, asc);
    return this;
  }

  public PageTypeRequest orderByCodeAscending() {
    addOrderBy(CODE_PROPERTY, true);
    return this;
  }

  public PageTypeRequest orderByCodeDescending() {
    addOrderBy(CODE_PROPERTY, false);
    return this;
  }

  public PageTypeRequest orderByCodeAscendingUsingGBK() {
    addOrderBy("convert(code using gbk)", true);
    return this;
  }

  public PageTypeRequest orderByCodeDescendingUsingGBK() {
    addOrderBy("convert(code using gbk)", false);
    return this;
  }

  public PageTypeRequest countCode() {
    return countCode("countCode");
  }

  public PageTypeRequest countCode(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CODE_PROPERTY);
  }

  public PageTypeRequest maxCode() {
    return maxCode("maxCode");
  }

  public PageTypeRequest maxCode(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CODE_PROPERTY);
  }

  public PageTypeRequest minCode() {
    return minCode("minCode");
  }

  public PageTypeRequest minCode(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CODE_PROPERTY);
  }

  public PageTypeRequest groupByCode() {
    return groupByCode(CODE_PROPERTY);
  }

  public PageTypeRequest groupByCode(String ret) {
    return groupBy(ret, CODE_PROPERTY);
  }

  public PageTypeRequest groupByCode(SqlFunction func) {
    return groupByCode(CODE_PROPERTY, func);
  }

  public PageTypeRequest groupByCode(String ret, SqlFunction func) {
    super.groupBy(ret, func, CODE_PROPERTY);
    return this;
  }

  public PageTypeRequest filterByFooterTab(boolean footerTab) {

    return filterByFooterTab(QueryOperator.EQUAL, footerTab);
  }

  public PageTypeRequest whereFooterTabIsNull() {
    return where(FOOTER_TAB_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageTypeRequest whereFooterTabIsNotNull() {
    return where(FOOTER_TAB_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageTypeRequest filterByFooterTab(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFooterTabSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageTypeRequest selectFooterTab() {
    return select(FOOTER_TAB_PROPERTY);
  }

  public PageTypeRequest unselectFooterTab() {
    return unselect(FOOTER_TAB_PROPERTY);
  }

  public SearchCriteria getFooterTabSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOOTER_TAB_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageTypeRequest orderByFooterTab(boolean asc) {
    addOrderBy(FOOTER_TAB_PROPERTY, asc);
    return this;
  }

  public PageTypeRequest orderByFooterTabAscending() {
    addOrderBy(FOOTER_TAB_PROPERTY, true);
    return this;
  }

  public PageTypeRequest orderByFooterTabDescending() {
    addOrderBy(FOOTER_TAB_PROPERTY, false);
    return this;
  }

  public PageTypeRequest countFooterTab() {
    return countFooterTab("countFooterTab");
  }

  public PageTypeRequest countFooterTab(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOOTER_TAB_PROPERTY);
  }

  public PageTypeRequest maxFooterTab() {
    return maxFooterTab("maxFooterTab");
  }

  public PageTypeRequest maxFooterTab(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOOTER_TAB_PROPERTY);
  }

  public PageTypeRequest minFooterTab() {
    return minFooterTab("minFooterTab");
  }

  public PageTypeRequest minFooterTab(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOOTER_TAB_PROPERTY);
  }

  public PageTypeRequest groupByFooterTab() {
    return groupByFooterTab(FOOTER_TAB_PROPERTY);
  }

  public PageTypeRequest groupByFooterTab(String ret) {
    return groupBy(ret, FOOTER_TAB_PROPERTY);
  }

  public PageTypeRequest groupByFooterTab(SqlFunction func) {
    return groupByFooterTab(FOOTER_TAB_PROPERTY, func);
  }

  public PageTypeRequest groupByFooterTab(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOOTER_TAB_PROPERTY);
    return this;
  }

  public PageTypeRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PageTypeRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageTypeRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PageTypeRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PageTypeRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PageTypeRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PageTypeRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PageTypeRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PageTypeRequest countVersion() {
    return countVersion("countVersion");
  }

  public PageTypeRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PageTypeRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PageTypeRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PageTypeRequest minVersion() {
    return minVersion("minVersion");
  }

  public PageTypeRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PageTypeRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PageTypeRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PageTypeRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PageTypeRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PageTypeRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PageTypeRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PageTypeRequest filterByMobileApp(MobileAppRequest mobileApp) {
    return filterByMobileApp(mobileApp, MobileApp::getId);
  }

  public PageTypeRequest filterByMobileApp(MobileApp... mobileApp) {
    if (isEmptyParam(mobileApp)) {
      throw new IllegalArgumentException("filterByMobileApp(MobileApp... mobileApp)参数不能为空!");
    }
    return where(MOBILE_APP_PROPERTY, QueryOperator.IN, (Object[]) mobileApp);
  }

  public PageTypeRequest selectMobileAppId() {
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

  public PageTypeRequest filterByMobileApp(String... mobileApp) {
    if (isEmptyParam(mobileApp)) {
      throw new IllegalArgumentException("filterByMobileApp(String... mobileApp)参数不能为空!");
    }
    return where(MOBILE_APP_PROPERTY, QueryOperator.IN, (Object[]) mobileApp);
  }

  public PageTypeRequest filterByMobileApp(
      MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
    mobileApp.unlimited();
    return addSearchCriteria(createMobileAppCriteria(mobileApp, idRefine));
  }

  public SearchCriteria createMobileAppCriteria(
      MobileAppRequest mobileApp, IDRefine<MobileApp> idRefine) {
    return new RefinedIdInCriteria(mobileApp, MOBILE_APP_PROPERTY, idRefine, MobileApp.ID_PROPERTY);
  }

  public PageTypeRequest selectMobileApp() {
    return selectMobileApp(MobileAppRequest.newInstance().selectSelf());
  }

  public PageTypeRequest selectMobileApp(MobileAppRequest mobileApp) {
    selectParent(MOBILE_APP_PROPERTY, mobileApp);
    return this;
  }

  public PageTypeRequest unselectMobileApp() {
    unselectParent(MOBILE_APP_PROPERTY);
    return this;
  }

  public PageTypeRequest groupByMobileApp(MobileAppRequest mobileApp) {
    groupBy(MOBILE_APP_PROPERTY, mobileApp);
    return this;
  }

  public PageTypeRequest aggregateMobileApp(MobileAppRequest mobileApp) {
    aggregateParent(MOBILE_APP_PROPERTY, mobileApp);
    return this;
  }

  public PageTypeRequest countMobileApp() {
    return countMobileApp("countMobileApp");
  }

  public PageTypeRequest countMobileApp(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_APP_PROPERTY);
  }

  public PageTypeRequest groupByMobileApp() {
    return groupByMobileApp(MOBILE_APP_PROPERTY);
  }

  public PageTypeRequest groupByMobileApp(String ret) {
    return groupBy(ret, MOBILE_APP_PROPERTY);
  }

  public PageTypeRequest whereMobileAppIsNull() {
    return where(MOBILE_APP_PROPERTY, QueryOperator.IS_NULL);
  }

  public PageTypeRequest whereMobileAppIsNotNull() {
    return where(MOBILE_APP_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PageTypeRequest aggregatePageList(PageRequest page) {
    aggregateChild(Page.PAGE_TYPE_PROPERTY, page);
    return this;
  }

  public PageTypeRequest countPage() {
    return countPage("pageCount");
  }

  public PageTypeRequest countPage(String retName) {
    return countPage(retName, PageRequest.newInstance());
  }

  public PageTypeRequest countPage(PageRequest page) {
    return countPage("pageCount", page);
  }

  public PageTypeRequest countPage(String retName, PageRequest page) {
    page.count();
    return statsFromPage(retName, page);
  }

  public PageTypeRequest statsFromPage(String retName, PageRequest page) {
    return addDynamicProperty(retName, page, Page.PAGE_TYPE_PROPERTY);
  }

  public PageTypeRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PageTypeRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PageTypeRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PageTypeRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
