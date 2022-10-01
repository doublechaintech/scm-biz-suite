package com.doublechaintech.retailscm.cityevent;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.cityevent.CityEvent.*;

public class CityEventRequest extends BaseRequest<CityEvent> {
  public static CityEventRequest newInstance() {
    return new CityEventRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public CityEventRequest resultByClass(Class<? extends CityEvent> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public CityEventRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public CityEventRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "CityEvent";
  }

  public CityEventRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public CityEventRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public CityEventRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public CityEventRequest select(String... names) {
    super.select(names);
    return this;
  }

  public CityEventRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectMobile()
        .selectCityServiceCenter()
        .selectDescription()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public CityEventRequest selectAny() {
    return selectAll().selectEventAttendanceList(Q.eventAttendance().selectSelf());
  }

  public CityEventRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(MOBILE_PROPERTY);
    select(CITY_SERVICE_CENTER_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public CityEventRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public CityEventRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    MOBILE_PROPERTY,
    CITY_SERVICE_CENTER_PROPERTY,
    DESCRIPTION_PROPERTY,
    LAST_UPDATE_TIME_PROPERTY,
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

  public CityEventRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public CityEventRequest comment(String comment) {
    return this;
  }

  public CityEventRequest enhance() {
    return this;
  }

  public CityEventRequest overrideClass(Class<? extends CityEvent> clazz) {
    return this;
  }

  public CityEventRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public CityEventRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public CityEventRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public CityEventRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public CityEventRequest count() {
    return countId("count");
  }

  public static CityEventRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public CityEventRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public CityEventRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest selectId() {
    return select(ID_PROPERTY);
  }

  public CityEventRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityEventRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public CityEventRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public CityEventRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public CityEventRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public CityEventRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public CityEventRequest countId() {
    return countId("countId");
  }

  public CityEventRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public CityEventRequest maxId() {
    return maxId("maxId");
  }

  public CityEventRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public CityEventRequest minId() {
    return minId("minId");
  }

  public CityEventRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public CityEventRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public CityEventRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public CityEventRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public CityEventRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public CityEventRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public CityEventRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityEventRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityEventRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public CityEventRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityEventRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public CityEventRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public CityEventRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public CityEventRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public CityEventRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public CityEventRequest countName() {
    return countName("countName");
  }

  public CityEventRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public CityEventRequest maxName() {
    return maxName("maxName");
  }

  public CityEventRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public CityEventRequest minName() {
    return minName("minName");
  }

  public CityEventRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public CityEventRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public CityEventRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public CityEventRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public CityEventRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public CityEventRequest filterByMobile(String mobile) {

    if (mobile == null) {
      return this;
    }

    return filterByMobile(QueryOperator.EQUAL, mobile);
  }

  public CityEventRequest whereMobileIsNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityEventRequest whereMobileIsNotNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityEventRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest selectMobile() {
    return select(MOBILE_PROPERTY);
  }

  public CityEventRequest unselectMobile() {
    return unselect(MOBILE_PROPERTY);
  }

  public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityEventRequest orderByMobile(boolean asc) {
    addOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public CityEventRequest orderByMobileAscending() {
    addOrderBy(MOBILE_PROPERTY, true);
    return this;
  }

  public CityEventRequest orderByMobileDescending() {
    addOrderBy(MOBILE_PROPERTY, false);
    return this;
  }

  public CityEventRequest orderByMobileAscendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", true);
    return this;
  }

  public CityEventRequest orderByMobileDescendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", false);
    return this;
  }

  public CityEventRequest countMobile() {
    return countMobile("countMobile");
  }

  public CityEventRequest countMobile(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PROPERTY);
  }

  public CityEventRequest maxMobile() {
    return maxMobile("maxMobile");
  }

  public CityEventRequest maxMobile(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PROPERTY);
  }

  public CityEventRequest minMobile() {
    return minMobile("minMobile");
  }

  public CityEventRequest minMobile(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PROPERTY);
  }

  public CityEventRequest groupByMobile() {
    return groupByMobile(MOBILE_PROPERTY);
  }

  public CityEventRequest groupByMobile(String ret) {
    return groupBy(ret, MOBILE_PROPERTY);
  }

  public CityEventRequest groupByMobile(SqlFunction func) {
    return groupByMobile(MOBILE_PROPERTY, func);
  }

  public CityEventRequest groupByMobile(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PROPERTY);
    return this;
  }

  public CityEventRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public CityEventRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityEventRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityEventRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public CityEventRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityEventRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public CityEventRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public CityEventRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public CityEventRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public CityEventRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public CityEventRequest countDescription() {
    return countDescription("countDescription");
  }

  public CityEventRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public CityEventRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public CityEventRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public CityEventRequest minDescription() {
    return minDescription("minDescription");
  }

  public CityEventRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public CityEventRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public CityEventRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public CityEventRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public CityEventRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public CityEventRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public CityEventRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityEventRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityEventRequest whereLastUpdateTimeBetween(
      Date lastUpdateTimeStart, Date lastUpdateTimeEnd) {
    if (ObjectUtil.isEmpty(lastUpdateTimeStart)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(lastUpdateTimeEnd)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBetween, the parameter lastUpdateTimeEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {lastUpdateTimeStart, lastUpdateTimeEnd});
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public CityEventRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityEventRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public CityEventRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public CityEventRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public CityEventRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public CityEventRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityEventRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public CityEventRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityEventRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public CityEventRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityEventRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public CityEventRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityEventRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public CityEventRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public CityEventRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public CityEventRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityEventRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityEventRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityEventRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public CityEventRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityEventRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public CityEventRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public CityEventRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public CityEventRequest countVersion() {
    return countVersion("countVersion");
  }

  public CityEventRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public CityEventRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public CityEventRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public CityEventRequest minVersion() {
    return minVersion("minVersion");
  }

  public CityEventRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public CityEventRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public CityEventRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public CityEventRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public CityEventRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public CityEventRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public CityEventRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public CityEventRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    return filterByCityServiceCenter(cityServiceCenter, RetailStoreCityServiceCenter::getId);
  }

  public CityEventRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenter... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(RetailStoreCityServiceCenter... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public CityEventRequest selectCityServiceCenterId() {
    select(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest upToCityServiceCenter() {
    return upToCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest upToCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    cityServiceCenter.aggregateChild(CITY_SERVICE_CENTER_PROPERTY, this);
    this.groupByCityServiceCenter(cityServiceCenter);
    return cityServiceCenter;
  }

  public RetailStoreCityServiceCenterRequest endAtCityServiceCenter(String retName) {
    return endAtCityServiceCenter(retName, RetailStoreCityServiceCenterRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest endAtCityServiceCenter(
      String retName, RetailStoreCityServiceCenterRequest cityServiceCenter) {
    cityServiceCenter.addDynamicProperty(retName, this, CITY_SERVICE_CENTER_PROPERTY);
    return cityServiceCenter;
  }

  public CityEventRequest filterByCityServiceCenter(String... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(String... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public CityEventRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter,
      IDRefine<RetailStoreCityServiceCenter> idRefine) {
    cityServiceCenter.unlimited();
    return addSearchCriteria(createCityServiceCenterCriteria(cityServiceCenter, idRefine));
  }

  public SearchCriteria createCityServiceCenterCriteria(
      RetailStoreCityServiceCenterRequest cityServiceCenter,
      IDRefine<RetailStoreCityServiceCenter> idRefine) {
    return new RefinedIdInCriteria(
        cityServiceCenter,
        CITY_SERVICE_CENTER_PROPERTY,
        idRefine,
        RetailStoreCityServiceCenter.ID_PROPERTY);
  }

  public CityEventRequest selectCityServiceCenter() {
    return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
  }

  public CityEventRequest selectCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public CityEventRequest unselectCityServiceCenter() {
    unselectParent(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public CityEventRequest groupByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    groupBy(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public CityEventRequest aggregateCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    aggregateParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public CityEventRequest countCityServiceCenter() {
    return countCityServiceCenter("countCityServiceCenter");
  }

  public CityEventRequest countCityServiceCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_SERVICE_CENTER_PROPERTY);
  }

  public CityEventRequest groupByCityServiceCenter() {
    return groupByCityServiceCenter(CITY_SERVICE_CENTER_PROPERTY);
  }

  public CityEventRequest groupByCityServiceCenter(String ret) {
    return groupBy(ret, CITY_SERVICE_CENTER_PROPERTY);
  }

  public CityEventRequest whereCityServiceCenterIsNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityEventRequest whereCityServiceCenterIsNotNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityEventRequest hasEventAttendance() {
    return hasEventAttendance(EventAttendanceRequest.newInstance());
  }

  public CityEventRequest hasEventAttendance(EventAttendance... eventAttendance) {
    if (isEmptyParam(eventAttendance)) {
      throw new IllegalArgumentException(
          "hasEventAttendance(EventAttendance... eventAttendance)参数不能为空!");
    }
    return hasEventAttendance(
        Q.eventAttendance()
            .select(EventAttendance.CITY_EVENT_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) eventAttendance));
  }

  public CityEventRequest hasEventAttendance(String... eventAttendance) {
    return hasEventAttendance(
        Q.eventAttendance()
            .select(EventAttendance.CITY_EVENT_PROPERTY)
            .filterById(eventAttendance));
  }

  public CityEventRequest hasEventAttendance(EventAttendanceRequest eventAttendance) {
    return hasEventAttendance(
        eventAttendance,
        $eventAttendance ->
            java.util.Optional.of($eventAttendance)
                .map(EventAttendance::getCityEvent)
                .map(CityEvent::getId)
                .orElse(null));
  }

  public CityEventRequest hasEventAttendance(
      EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine) {
    eventAttendance.select(EventAttendance.CITY_EVENT_PROPERTY);
    eventAttendance.unlimited();
    return addSearchCriteria(createEventAttendanceCriteria(eventAttendance, idRefine));
  }

  public CityEventRequest hasEventAttendance(
      EventAttendanceRequest eventAttendance, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            eventAttendance, EventAttendance.CITY_EVENT_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEventAttendanceCriteria(
      EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine) {
    return new RefinedIdInCriteria(
        eventAttendance, ID_PROPERTY, idRefine, EventAttendance.CITY_EVENT_PROPERTY);
  }

  public CityEventRequest selectEventAttendanceList(EventAttendanceRequest eventAttendance) {
    selectChild(EventAttendance.CITY_EVENT_PROPERTY, eventAttendance);
    return this;
  }

  public CityEventRequest selectEventAttendanceList() {
    return selectEventAttendanceList(EventAttendanceRequest.newInstance().selectAll());
  }

  public CityEventRequest unselectEventAttendanceList() {
    unselectChild(EventAttendance.CITY_EVENT_PROPERTY, EventAttendance.class);
    return this;
  }

  public CityEventRequest aggregateEventAttendanceList(EventAttendanceRequest eventAttendance) {
    aggregateChild(EventAttendance.CITY_EVENT_PROPERTY, eventAttendance);
    return this;
  }

  public CityEventRequest countEventAttendance() {
    return countEventAttendance("eventAttendanceCount");
  }

  public CityEventRequest countEventAttendance(String retName) {
    return countEventAttendance(retName, EventAttendanceRequest.newInstance());
  }

  public CityEventRequest countEventAttendance(EventAttendanceRequest eventAttendance) {
    return countEventAttendance("eventAttendanceCount", eventAttendance);
  }

  public CityEventRequest countEventAttendance(
      String retName, EventAttendanceRequest eventAttendance) {
    eventAttendance.count();
    return statsFromEventAttendance(retName, eventAttendance);
  }

  public CityEventRequest statsFromEventAttendance(
      String retName, EventAttendanceRequest eventAttendance) {
    return addDynamicProperty(retName, eventAttendance, EventAttendance.CITY_EVENT_PROPERTY);
  }

  public CityEventRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public CityEventRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public CityEventRequest unlimited() {
    super.unlimited();
    return this;
  }

  public CityEventRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
