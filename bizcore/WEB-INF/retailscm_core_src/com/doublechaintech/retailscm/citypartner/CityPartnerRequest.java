package com.doublechaintech.retailscm.citypartner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.citypartner.CityPartner.*;

public class CityPartnerRequest extends BaseRequest<CityPartner> {
  public static CityPartnerRequest newInstance() {
    return new CityPartnerRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public CityPartnerRequest resultByClass(Class<? extends CityPartner> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public CityPartnerRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public CityPartnerRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "CityPartner";
  }

  public CityPartnerRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public CityPartnerRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public CityPartnerRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public CityPartnerRequest select(String... names) {
    super.select(names);
    return this;
  }

  public CityPartnerRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectMobile()
        .selectCityServiceCenter()
        .selectDescription()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public CityPartnerRequest selectAny() {
    return selectAll()
        .selectPotentialCustomerList(Q.potentialCustomer().selectSelf())
        .selectPotentialCustomerContactList(Q.potentialCustomerContact().selectSelf());
  }

  public CityPartnerRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(MOBILE_PROPERTY);
    select(CITY_SERVICE_CENTER_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public CityPartnerRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public CityPartnerRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
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

  public CityPartnerRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public CityPartnerRequest comment(String comment) {
    return this;
  }

  public CityPartnerRequest enhance() {
    return this;
  }

  public CityPartnerRequest overrideClass(Class<? extends CityPartner> clazz) {
    return this;
  }

  public CityPartnerRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public CityPartnerRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public CityPartnerRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public CityPartnerRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public CityPartnerRequest count() {
    return countId("count");
  }

  public static CityPartnerRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public CityPartnerRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public CityPartnerRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest selectId() {
    return select(ID_PROPERTY);
  }

  public CityPartnerRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityPartnerRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public CityPartnerRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public CityPartnerRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public CityPartnerRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public CityPartnerRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public CityPartnerRequest countId() {
    return countId("countId");
  }

  public CityPartnerRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public CityPartnerRequest maxId() {
    return maxId("maxId");
  }

  public CityPartnerRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public CityPartnerRequest minId() {
    return minId("minId");
  }

  public CityPartnerRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public CityPartnerRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public CityPartnerRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public CityPartnerRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public CityPartnerRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public CityPartnerRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public CityPartnerRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityPartnerRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityPartnerRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public CityPartnerRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityPartnerRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public CityPartnerRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public CityPartnerRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public CityPartnerRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public CityPartnerRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public CityPartnerRequest countName() {
    return countName("countName");
  }

  public CityPartnerRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public CityPartnerRequest maxName() {
    return maxName("maxName");
  }

  public CityPartnerRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public CityPartnerRequest minName() {
    return minName("minName");
  }

  public CityPartnerRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public CityPartnerRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public CityPartnerRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public CityPartnerRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public CityPartnerRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public CityPartnerRequest filterByMobile(String mobile) {

    if (mobile == null) {
      return this;
    }

    return filterByMobile(QueryOperator.EQUAL, mobile);
  }

  public CityPartnerRequest whereMobileIsNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityPartnerRequest whereMobileIsNotNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityPartnerRequest filterByMobile(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest selectMobile() {
    return select(MOBILE_PROPERTY);
  }

  public CityPartnerRequest unselectMobile() {
    return unselect(MOBILE_PROPERTY);
  }

  public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityPartnerRequest orderByMobile(boolean asc) {
    addOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public CityPartnerRequest orderByMobileAscending() {
    addOrderBy(MOBILE_PROPERTY, true);
    return this;
  }

  public CityPartnerRequest orderByMobileDescending() {
    addOrderBy(MOBILE_PROPERTY, false);
    return this;
  }

  public CityPartnerRequest orderByMobileAscendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", true);
    return this;
  }

  public CityPartnerRequest orderByMobileDescendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", false);
    return this;
  }

  public CityPartnerRequest countMobile() {
    return countMobile("countMobile");
  }

  public CityPartnerRequest countMobile(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PROPERTY);
  }

  public CityPartnerRequest maxMobile() {
    return maxMobile("maxMobile");
  }

  public CityPartnerRequest maxMobile(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PROPERTY);
  }

  public CityPartnerRequest minMobile() {
    return minMobile("minMobile");
  }

  public CityPartnerRequest minMobile(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PROPERTY);
  }

  public CityPartnerRequest groupByMobile() {
    return groupByMobile(MOBILE_PROPERTY);
  }

  public CityPartnerRequest groupByMobile(String ret) {
    return groupBy(ret, MOBILE_PROPERTY);
  }

  public CityPartnerRequest groupByMobile(SqlFunction func) {
    return groupByMobile(MOBILE_PROPERTY, func);
  }

  public CityPartnerRequest groupByMobile(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PROPERTY);
    return this;
  }

  public CityPartnerRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public CityPartnerRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityPartnerRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityPartnerRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public CityPartnerRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityPartnerRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public CityPartnerRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public CityPartnerRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public CityPartnerRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public CityPartnerRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public CityPartnerRequest countDescription() {
    return countDescription("countDescription");
  }

  public CityPartnerRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public CityPartnerRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public CityPartnerRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public CityPartnerRequest minDescription() {
    return minDescription("minDescription");
  }

  public CityPartnerRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public CityPartnerRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public CityPartnerRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public CityPartnerRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public CityPartnerRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public CityPartnerRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public CityPartnerRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityPartnerRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityPartnerRequest whereLastUpdateTimeBetween(
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

  public CityPartnerRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public CityPartnerRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityPartnerRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public CityPartnerRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public CityPartnerRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public CityPartnerRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public CityPartnerRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityPartnerRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public CityPartnerRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityPartnerRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public CityPartnerRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityPartnerRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public CityPartnerRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public CityPartnerRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public CityPartnerRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public CityPartnerRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public CityPartnerRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityPartnerRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityPartnerRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public CityPartnerRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public CityPartnerRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public CityPartnerRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public CityPartnerRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public CityPartnerRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public CityPartnerRequest countVersion() {
    return countVersion("countVersion");
  }

  public CityPartnerRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public CityPartnerRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public CityPartnerRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public CityPartnerRequest minVersion() {
    return minVersion("minVersion");
  }

  public CityPartnerRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public CityPartnerRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public CityPartnerRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public CityPartnerRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public CityPartnerRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public CityPartnerRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public CityPartnerRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public CityPartnerRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    return filterByCityServiceCenter(cityServiceCenter, RetailStoreCityServiceCenter::getId);
  }

  public CityPartnerRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenter... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(RetailStoreCityServiceCenter... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public CityPartnerRequest selectCityServiceCenterId() {
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

  public CityPartnerRequest filterByCityServiceCenter(String... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(String... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public CityPartnerRequest filterByCityServiceCenter(
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

  public CityPartnerRequest selectCityServiceCenter() {
    return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
  }

  public CityPartnerRequest selectCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public CityPartnerRequest unselectCityServiceCenter() {
    unselectParent(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public CityPartnerRequest groupByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    groupBy(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public CityPartnerRequest aggregateCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    aggregateParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public CityPartnerRequest countCityServiceCenter() {
    return countCityServiceCenter("countCityServiceCenter");
  }

  public CityPartnerRequest countCityServiceCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_SERVICE_CENTER_PROPERTY);
  }

  public CityPartnerRequest groupByCityServiceCenter() {
    return groupByCityServiceCenter(CITY_SERVICE_CENTER_PROPERTY);
  }

  public CityPartnerRequest groupByCityServiceCenter(String ret) {
    return groupBy(ret, CITY_SERVICE_CENTER_PROPERTY);
  }

  public CityPartnerRequest whereCityServiceCenterIsNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public CityPartnerRequest whereCityServiceCenterIsNotNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public CityPartnerRequest hasPotentialCustomer() {
    return hasPotentialCustomer(PotentialCustomerRequest.newInstance());
  }

  public CityPartnerRequest hasPotentialCustomer(PotentialCustomer... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "hasPotentialCustomer(PotentialCustomer... potentialCustomer)参数不能为空!");
    }
    return hasPotentialCustomer(
        Q.potentialCustomer()
            .select(PotentialCustomer.CITY_PARTNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) potentialCustomer));
  }

  public CityPartnerRequest hasPotentialCustomer(String... potentialCustomer) {
    return hasPotentialCustomer(
        Q.potentialCustomer()
            .select(PotentialCustomer.CITY_PARTNER_PROPERTY)
            .filterById(potentialCustomer));
  }

  public CityPartnerRequest hasPotentialCustomer(PotentialCustomerRequest potentialCustomer) {
    return hasPotentialCustomer(
        potentialCustomer,
        $potentialCustomer ->
            java.util.Optional.of($potentialCustomer)
                .map(PotentialCustomer::getCityPartner)
                .map(CityPartner::getId)
                .orElse(null));
  }

  public CityPartnerRequest hasPotentialCustomer(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    potentialCustomer.select(PotentialCustomer.CITY_PARTNER_PROPERTY);
    potentialCustomer.unlimited();
    return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
  }

  public CityPartnerRequest hasPotentialCustomer(
      PotentialCustomerRequest potentialCustomer, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            potentialCustomer, PotentialCustomer.CITY_PARTNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createPotentialCustomerCriteria(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    return new RefinedIdInCriteria(
        potentialCustomer, ID_PROPERTY, idRefine, PotentialCustomer.CITY_PARTNER_PROPERTY);
  }

  public CityPartnerRequest selectPotentialCustomerList(
      PotentialCustomerRequest potentialCustomer) {
    selectChild(PotentialCustomer.CITY_PARTNER_PROPERTY, potentialCustomer);
    return this;
  }

  public CityPartnerRequest selectPotentialCustomerList() {
    return selectPotentialCustomerList(PotentialCustomerRequest.newInstance().selectAll());
  }

  public CityPartnerRequest unselectPotentialCustomerList() {
    unselectChild(PotentialCustomer.CITY_PARTNER_PROPERTY, PotentialCustomer.class);
    return this;
  }

  public CityPartnerRequest hasPotentialCustomerContact() {
    return hasPotentialCustomerContact(PotentialCustomerContactRequest.newInstance());
  }

  public CityPartnerRequest hasPotentialCustomerContact(
      PotentialCustomerContact... potentialCustomerContact) {
    if (isEmptyParam(potentialCustomerContact)) {
      throw new IllegalArgumentException(
          "hasPotentialCustomerContact(PotentialCustomerContact... potentialCustomerContact)参数不能为空!");
    }
    return hasPotentialCustomerContact(
        Q.potentialCustomerContact()
            .select(PotentialCustomerContact.CITY_PARTNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) potentialCustomerContact));
  }

  public CityPartnerRequest hasPotentialCustomerContact(String... potentialCustomerContact) {
    return hasPotentialCustomerContact(
        Q.potentialCustomerContact()
            .select(PotentialCustomerContact.CITY_PARTNER_PROPERTY)
            .filterById(potentialCustomerContact));
  }

  public CityPartnerRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact) {
    return hasPotentialCustomerContact(
        potentialCustomerContact,
        $potentialCustomerContact ->
            java.util.Optional.of($potentialCustomerContact)
                .map(PotentialCustomerContact::getCityPartner)
                .map(CityPartner::getId)
                .orElse(null));
  }

  public CityPartnerRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact,
      IDRefine<PotentialCustomerContact> idRefine) {
    potentialCustomerContact.select(PotentialCustomerContact.CITY_PARTNER_PROPERTY);
    potentialCustomerContact.unlimited();
    return addSearchCriteria(
        createPotentialCustomerContactCriteria(potentialCustomerContact, idRefine));
  }

  public CityPartnerRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            potentialCustomerContact,
            PotentialCustomerContact.CITY_PARTNER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createPotentialCustomerContactCriteria(
      PotentialCustomerContactRequest potentialCustomerContact,
      IDRefine<PotentialCustomerContact> idRefine) {
    return new RefinedIdInCriteria(
        potentialCustomerContact,
        ID_PROPERTY,
        idRefine,
        PotentialCustomerContact.CITY_PARTNER_PROPERTY);
  }

  public CityPartnerRequest selectPotentialCustomerContactList(
      PotentialCustomerContactRequest potentialCustomerContact) {
    selectChild(PotentialCustomerContact.CITY_PARTNER_PROPERTY, potentialCustomerContact);
    return this;
  }

  public CityPartnerRequest selectPotentialCustomerContactList() {
    return selectPotentialCustomerContactList(
        PotentialCustomerContactRequest.newInstance().selectAll());
  }

  public CityPartnerRequest unselectPotentialCustomerContactList() {
    unselectChild(PotentialCustomerContact.CITY_PARTNER_PROPERTY, PotentialCustomerContact.class);
    return this;
  }

  public CityPartnerRequest aggregatePotentialCustomerList(
      PotentialCustomerRequest potentialCustomer) {
    aggregateChild(PotentialCustomer.CITY_PARTNER_PROPERTY, potentialCustomer);
    return this;
  }

  public CityPartnerRequest countPotentialCustomer() {
    return countPotentialCustomer("potentialCustomerCount");
  }

  public CityPartnerRequest countPotentialCustomer(String retName) {
    return countPotentialCustomer(retName, PotentialCustomerRequest.newInstance());
  }

  public CityPartnerRequest countPotentialCustomer(PotentialCustomerRequest potentialCustomer) {
    return countPotentialCustomer("potentialCustomerCount", potentialCustomer);
  }

  public CityPartnerRequest countPotentialCustomer(
      String retName, PotentialCustomerRequest potentialCustomer) {
    potentialCustomer.count();
    return statsFromPotentialCustomer(retName, potentialCustomer);
  }

  public CityPartnerRequest statsFromPotentialCustomer(
      String retName, PotentialCustomerRequest potentialCustomer) {
    return addDynamicProperty(retName, potentialCustomer, PotentialCustomer.CITY_PARTNER_PROPERTY);
  }

  public CityPartnerRequest aggregatePotentialCustomerContactList(
      PotentialCustomerContactRequest potentialCustomerContact) {
    aggregateChild(PotentialCustomerContact.CITY_PARTNER_PROPERTY, potentialCustomerContact);
    return this;
  }

  public CityPartnerRequest countPotentialCustomerContact() {
    return countPotentialCustomerContact("potentialCustomerContactCount");
  }

  public CityPartnerRequest countPotentialCustomerContact(String retName) {
    return countPotentialCustomerContact(retName, PotentialCustomerContactRequest.newInstance());
  }

  public CityPartnerRequest countPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact) {
    return countPotentialCustomerContact("potentialCustomerContactCount", potentialCustomerContact);
  }

  public CityPartnerRequest countPotentialCustomerContact(
      String retName, PotentialCustomerContactRequest potentialCustomerContact) {
    potentialCustomerContact.count();
    return statsFromPotentialCustomerContact(retName, potentialCustomerContact);
  }

  public CityPartnerRequest statsFromPotentialCustomerContact(
      String retName, PotentialCustomerContactRequest potentialCustomerContact) {
    return addDynamicProperty(
        retName, potentialCustomerContact, PotentialCustomerContact.CITY_PARTNER_PROPERTY);
  }

  public CityPartnerRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public CityPartnerRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public CityPartnerRequest unlimited() {
    super.unlimited();
    return this;
  }

  public CityPartnerRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
