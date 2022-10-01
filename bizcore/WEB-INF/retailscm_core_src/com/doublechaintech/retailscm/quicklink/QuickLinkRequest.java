package com.doublechaintech.retailscm.quicklink;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.userapp.UserAppRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.quicklink.QuickLink.*;

public class QuickLinkRequest extends BaseRequest<QuickLink> {
  public static QuickLinkRequest newInstance() {
    return new QuickLinkRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public QuickLinkRequest resultByClass(Class<? extends QuickLink> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public QuickLinkRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public QuickLinkRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "QuickLink";
  }

  public QuickLinkRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public QuickLinkRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public QuickLinkRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public QuickLinkRequest select(String... names) {
    super.select(names);
    return this;
  }

  public QuickLinkRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectIcon()
        .selectImagePath()
        .selectLinkTarget()
        .selectCreateTime()
        .selectApp()
        .selectVersion();
  }

  public QuickLinkRequest selectAny() {
    return selectAll();
  }

  public QuickLinkRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(ICON_PROPERTY);
    select(IMAGE_PATH_PROPERTY);
    select(LINK_TARGET_PROPERTY);
    select(CREATE_TIME_PROPERTY);
    select(APP_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public QuickLinkRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public QuickLinkRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {CREATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    ICON_PROPERTY,
    IMAGE_PATH_PROPERTY,
    LINK_TARGET_PROPERTY,
    CREATE_TIME_PROPERTY,
    APP_PROPERTY,
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

  public QuickLinkRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public QuickLinkRequest comment(String comment) {
    return this;
  }

  public QuickLinkRequest enhance() {
    return this;
  }

  public QuickLinkRequest overrideClass(Class<? extends QuickLink> clazz) {
    return this;
  }

  public QuickLinkRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public QuickLinkRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public QuickLinkRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public QuickLinkRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public QuickLinkRequest count() {
    return countId("count");
  }

  public static QuickLinkRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public QuickLinkRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public QuickLinkRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest selectId() {
    return select(ID_PROPERTY);
  }

  public QuickLinkRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public QuickLinkRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public QuickLinkRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public QuickLinkRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public QuickLinkRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public QuickLinkRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public QuickLinkRequest countId() {
    return countId("countId");
  }

  public QuickLinkRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public QuickLinkRequest maxId() {
    return maxId("maxId");
  }

  public QuickLinkRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public QuickLinkRequest minId() {
    return minId("minId");
  }

  public QuickLinkRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public QuickLinkRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public QuickLinkRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public QuickLinkRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public QuickLinkRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public QuickLinkRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public QuickLinkRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public QuickLinkRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public QuickLinkRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public QuickLinkRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public QuickLinkRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public QuickLinkRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public QuickLinkRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public QuickLinkRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public QuickLinkRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public QuickLinkRequest countName() {
    return countName("countName");
  }

  public QuickLinkRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public QuickLinkRequest maxName() {
    return maxName("maxName");
  }

  public QuickLinkRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public QuickLinkRequest minName() {
    return minName("minName");
  }

  public QuickLinkRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public QuickLinkRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public QuickLinkRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public QuickLinkRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public QuickLinkRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public QuickLinkRequest filterByIcon(String icon) {

    if (icon == null) {
      return this;
    }

    return filterByIcon(QueryOperator.EQUAL, icon);
  }

  public QuickLinkRequest whereIconIsNull() {
    return where(ICON_PROPERTY, QueryOperator.IS_NULL);
  }

  public QuickLinkRequest whereIconIsNotNull() {
    return where(ICON_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public QuickLinkRequest filterByIcon(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIconSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest selectIcon() {
    return select(ICON_PROPERTY);
  }

  public QuickLinkRequest unselectIcon() {
    return unselect(ICON_PROPERTY);
  }

  public SearchCriteria getIconSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ICON_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public QuickLinkRequest orderByIcon(boolean asc) {
    addOrderBy(ICON_PROPERTY, asc);
    return this;
  }

  public QuickLinkRequest orderByIconAscending() {
    addOrderBy(ICON_PROPERTY, true);
    return this;
  }

  public QuickLinkRequest orderByIconDescending() {
    addOrderBy(ICON_PROPERTY, false);
    return this;
  }

  public QuickLinkRequest orderByIconAscendingUsingGBK() {
    addOrderBy("convert(icon using gbk)", true);
    return this;
  }

  public QuickLinkRequest orderByIconDescendingUsingGBK() {
    addOrderBy("convert(icon using gbk)", false);
    return this;
  }

  public QuickLinkRequest countIcon() {
    return countIcon("countIcon");
  }

  public QuickLinkRequest countIcon(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ICON_PROPERTY);
  }

  public QuickLinkRequest maxIcon() {
    return maxIcon("maxIcon");
  }

  public QuickLinkRequest maxIcon(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ICON_PROPERTY);
  }

  public QuickLinkRequest minIcon() {
    return minIcon("minIcon");
  }

  public QuickLinkRequest minIcon(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ICON_PROPERTY);
  }

  public QuickLinkRequest groupByIcon() {
    return groupByIcon(ICON_PROPERTY);
  }

  public QuickLinkRequest groupByIcon(String ret) {
    return groupBy(ret, ICON_PROPERTY);
  }

  public QuickLinkRequest groupByIcon(SqlFunction func) {
    return groupByIcon(ICON_PROPERTY, func);
  }

  public QuickLinkRequest groupByIcon(String ret, SqlFunction func) {
    super.groupBy(ret, func, ICON_PROPERTY);
    return this;
  }

  public QuickLinkRequest filterByImagePath(String imagePath) {

    if (imagePath == null) {
      return this;
    }

    return filterByImagePath(QueryOperator.EQUAL, imagePath);
  }

  public QuickLinkRequest whereImagePathIsNull() {
    return where(IMAGE_PATH_PROPERTY, QueryOperator.IS_NULL);
  }

  public QuickLinkRequest whereImagePathIsNotNull() {
    return where(IMAGE_PATH_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public QuickLinkRequest filterByImagePath(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getImagePathSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest selectImagePath() {
    return select(IMAGE_PATH_PROPERTY);
  }

  public QuickLinkRequest unselectImagePath() {
    return unselect(IMAGE_PATH_PROPERTY);
  }

  public SearchCriteria getImagePathSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(IMAGE_PATH_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public QuickLinkRequest orderByImagePath(boolean asc) {
    addOrderBy(IMAGE_PATH_PROPERTY, asc);
    return this;
  }

  public QuickLinkRequest orderByImagePathAscending() {
    addOrderBy(IMAGE_PATH_PROPERTY, true);
    return this;
  }

  public QuickLinkRequest orderByImagePathDescending() {
    addOrderBy(IMAGE_PATH_PROPERTY, false);
    return this;
  }

  public QuickLinkRequest orderByImagePathAscendingUsingGBK() {
    addOrderBy("convert(imagePath using gbk)", true);
    return this;
  }

  public QuickLinkRequest orderByImagePathDescendingUsingGBK() {
    addOrderBy("convert(imagePath using gbk)", false);
    return this;
  }

  public QuickLinkRequest countImagePath() {
    return countImagePath("countImagePath");
  }

  public QuickLinkRequest countImagePath(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, IMAGE_PATH_PROPERTY);
  }

  public QuickLinkRequest maxImagePath() {
    return maxImagePath("maxImagePath");
  }

  public QuickLinkRequest maxImagePath(String aggName) {
    return aggregate(aggName, AggFunc.MAX, IMAGE_PATH_PROPERTY);
  }

  public QuickLinkRequest minImagePath() {
    return minImagePath("minImagePath");
  }

  public QuickLinkRequest minImagePath(String aggName) {
    return aggregate(aggName, AggFunc.MIN, IMAGE_PATH_PROPERTY);
  }

  public QuickLinkRequest groupByImagePath() {
    return groupByImagePath(IMAGE_PATH_PROPERTY);
  }

  public QuickLinkRequest groupByImagePath(String ret) {
    return groupBy(ret, IMAGE_PATH_PROPERTY);
  }

  public QuickLinkRequest groupByImagePath(SqlFunction func) {
    return groupByImagePath(IMAGE_PATH_PROPERTY, func);
  }

  public QuickLinkRequest groupByImagePath(String ret, SqlFunction func) {
    super.groupBy(ret, func, IMAGE_PATH_PROPERTY);
    return this;
  }

  public QuickLinkRequest filterByLinkTarget(String linkTarget) {

    if (linkTarget == null) {
      return this;
    }

    return filterByLinkTarget(QueryOperator.EQUAL, linkTarget);
  }

  public QuickLinkRequest whereLinkTargetIsNull() {
    return where(LINK_TARGET_PROPERTY, QueryOperator.IS_NULL);
  }

  public QuickLinkRequest whereLinkTargetIsNotNull() {
    return where(LINK_TARGET_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public QuickLinkRequest filterByLinkTarget(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLinkTargetSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest selectLinkTarget() {
    return select(LINK_TARGET_PROPERTY);
  }

  public QuickLinkRequest unselectLinkTarget() {
    return unselect(LINK_TARGET_PROPERTY);
  }

  public SearchCriteria getLinkTargetSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LINK_TARGET_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public QuickLinkRequest orderByLinkTarget(boolean asc) {
    addOrderBy(LINK_TARGET_PROPERTY, asc);
    return this;
  }

  public QuickLinkRequest orderByLinkTargetAscending() {
    addOrderBy(LINK_TARGET_PROPERTY, true);
    return this;
  }

  public QuickLinkRequest orderByLinkTargetDescending() {
    addOrderBy(LINK_TARGET_PROPERTY, false);
    return this;
  }

  public QuickLinkRequest orderByLinkTargetAscendingUsingGBK() {
    addOrderBy("convert(linkTarget using gbk)", true);
    return this;
  }

  public QuickLinkRequest orderByLinkTargetDescendingUsingGBK() {
    addOrderBy("convert(linkTarget using gbk)", false);
    return this;
  }

  public QuickLinkRequest countLinkTarget() {
    return countLinkTarget("countLinkTarget");
  }

  public QuickLinkRequest countLinkTarget(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LINK_TARGET_PROPERTY);
  }

  public QuickLinkRequest maxLinkTarget() {
    return maxLinkTarget("maxLinkTarget");
  }

  public QuickLinkRequest maxLinkTarget(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LINK_TARGET_PROPERTY);
  }

  public QuickLinkRequest minLinkTarget() {
    return minLinkTarget("minLinkTarget");
  }

  public QuickLinkRequest minLinkTarget(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LINK_TARGET_PROPERTY);
  }

  public QuickLinkRequest groupByLinkTarget() {
    return groupByLinkTarget(LINK_TARGET_PROPERTY);
  }

  public QuickLinkRequest groupByLinkTarget(String ret) {
    return groupBy(ret, LINK_TARGET_PROPERTY);
  }

  public QuickLinkRequest groupByLinkTarget(SqlFunction func) {
    return groupByLinkTarget(LINK_TARGET_PROPERTY, func);
  }

  public QuickLinkRequest groupByLinkTarget(String ret, SqlFunction func) {
    super.groupBy(ret, func, LINK_TARGET_PROPERTY);
    return this;
  }

  public QuickLinkRequest filterByCreateTime(DateTime createTime) {

    if (createTime == null) {
      return this;
    }

    return filterByCreateTime(QueryOperator.EQUAL, createTime);
  }

  public QuickLinkRequest whereCreateTimeIsNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public QuickLinkRequest whereCreateTimeIsNotNull() {
    return where(CREATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public QuickLinkRequest whereCreateTimeBetween(Date createTimeStart, Date createTimeEnd) {
    if (ObjectUtil.isEmpty(createTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBetween, the parameter createTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(createTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBetween, the parameter createTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {createTimeStart, createTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest whereCreateTimeBefore(Date createTime) {

    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeBefore, the parameter createTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest whereCreateTimeAfter(DateTime createTime) {
    if (ObjectUtil.isEmpty(createTime)) {
      throw new IllegalArgumentException(
          "Method whereCreateTimeAfter, the parameter createTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getCreateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {createTime});
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest filterByCreateTime(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCreateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest selectCreateTime() {
    return select(CREATE_TIME_PROPERTY);
  }

  public QuickLinkRequest unselectCreateTime() {
    return unselect(CREATE_TIME_PROPERTY);
  }

  public SearchCriteria getCreateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CREATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public QuickLinkRequest orderByCreateTime(boolean asc) {
    addOrderBy(CREATE_TIME_PROPERTY, asc);
    return this;
  }

  public QuickLinkRequest orderByCreateTimeAscending() {
    addOrderBy(CREATE_TIME_PROPERTY, true);
    return this;
  }

  public QuickLinkRequest orderByCreateTimeDescending() {
    addOrderBy(CREATE_TIME_PROPERTY, false);
    return this;
  }

  public QuickLinkRequest countCreateTime() {
    return countCreateTime("countCreateTime");
  }

  public QuickLinkRequest countCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CREATE_TIME_PROPERTY);
  }

  public QuickLinkRequest maxCreateTime() {
    return maxCreateTime("maxCreateTime");
  }

  public QuickLinkRequest maxCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CREATE_TIME_PROPERTY);
  }

  public QuickLinkRequest minCreateTime() {
    return minCreateTime("minCreateTime");
  }

  public QuickLinkRequest minCreateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CREATE_TIME_PROPERTY);
  }

  public QuickLinkRequest groupByCreateTime() {
    return groupByCreateTime(CREATE_TIME_PROPERTY);
  }

  public QuickLinkRequest groupByCreateTime(String ret) {
    return groupBy(ret, CREATE_TIME_PROPERTY);
  }

  public QuickLinkRequest groupByCreateTime(SqlFunction func) {
    return groupByCreateTime(CREATE_TIME_PROPERTY, func);
  }

  public QuickLinkRequest groupByCreateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, CREATE_TIME_PROPERTY);
    return this;
  }

  public QuickLinkRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public QuickLinkRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public QuickLinkRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public QuickLinkRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public QuickLinkRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public QuickLinkRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public QuickLinkRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public QuickLinkRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public QuickLinkRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public QuickLinkRequest countVersion() {
    return countVersion("countVersion");
  }

  public QuickLinkRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public QuickLinkRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public QuickLinkRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public QuickLinkRequest minVersion() {
    return minVersion("minVersion");
  }

  public QuickLinkRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public QuickLinkRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public QuickLinkRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public QuickLinkRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public QuickLinkRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public QuickLinkRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public QuickLinkRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public QuickLinkRequest filterByApp(UserAppRequest app) {
    return filterByApp(app, UserApp::getId);
  }

  public QuickLinkRequest filterByApp(UserApp... app) {
    if (isEmptyParam(app)) {
      throw new IllegalArgumentException("filterByApp(UserApp... app)参数不能为空!");
    }
    return where(APP_PROPERTY, QueryOperator.IN, (Object[]) app);
  }

  public QuickLinkRequest selectAppId() {
    select(APP_PROPERTY);
    return this;
  }

  public UserAppRequest upToApp() {
    return upToApp(UserAppRequest.newInstance());
  }

  public UserAppRequest upToApp(UserAppRequest app) {
    app.aggregateChild(APP_PROPERTY, this);
    this.groupByApp(app);
    return app;
  }

  public UserAppRequest endAtApp(String retName) {
    return endAtApp(retName, UserAppRequest.newInstance());
  }

  public UserAppRequest endAtApp(String retName, UserAppRequest app) {
    app.addDynamicProperty(retName, this, APP_PROPERTY);
    return app;
  }

  public QuickLinkRequest filterByApp(String... app) {
    if (isEmptyParam(app)) {
      throw new IllegalArgumentException("filterByApp(String... app)参数不能为空!");
    }
    return where(APP_PROPERTY, QueryOperator.IN, (Object[]) app);
  }

  public QuickLinkRequest filterByApp(UserAppRequest app, IDRefine<UserApp> idRefine) {
    app.unlimited();
    return addSearchCriteria(createAppCriteria(app, idRefine));
  }

  public SearchCriteria createAppCriteria(UserAppRequest app, IDRefine<UserApp> idRefine) {
    return new RefinedIdInCriteria(app, APP_PROPERTY, idRefine, UserApp.ID_PROPERTY);
  }

  public QuickLinkRequest selectApp() {
    return selectApp(UserAppRequest.newInstance().selectSelf());
  }

  public QuickLinkRequest selectApp(UserAppRequest app) {
    selectParent(APP_PROPERTY, app);
    return this;
  }

  public QuickLinkRequest unselectApp() {
    unselectParent(APP_PROPERTY);
    return this;
  }

  public QuickLinkRequest groupByApp(UserAppRequest app) {
    groupBy(APP_PROPERTY, app);
    return this;
  }

  public QuickLinkRequest aggregateApp(UserAppRequest app) {
    aggregateParent(APP_PROPERTY, app);
    return this;
  }

  public QuickLinkRequest countApp() {
    return countApp("countApp");
  }

  public QuickLinkRequest countApp(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, APP_PROPERTY);
  }

  public QuickLinkRequest groupByApp() {
    return groupByApp(APP_PROPERTY);
  }

  public QuickLinkRequest groupByApp(String ret) {
    return groupBy(ret, APP_PROPERTY);
  }

  public QuickLinkRequest whereAppIsNull() {
    return where(APP_PROPERTY, QueryOperator.IS_NULL);
  }

  public QuickLinkRequest whereAppIsNotNull() {
    return where(APP_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public QuickLinkRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public QuickLinkRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public QuickLinkRequest unlimited() {
    super.unlimited();
    return this;
  }

  public QuickLinkRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
