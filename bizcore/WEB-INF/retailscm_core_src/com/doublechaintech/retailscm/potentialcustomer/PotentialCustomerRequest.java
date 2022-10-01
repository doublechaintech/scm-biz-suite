package com.doublechaintech.retailscm.potentialcustomer;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.citypartner.CityPartnerRequest;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceRequest;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer.*;

public class PotentialCustomerRequest extends BaseRequest<PotentialCustomer> {
  public static PotentialCustomerRequest newInstance() {
    return new PotentialCustomerRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PotentialCustomerRequest resultByClass(Class<? extends PotentialCustomer> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PotentialCustomerRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PotentialCustomerRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "PotentialCustomer";
  }

  public PotentialCustomerRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PotentialCustomerRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PotentialCustomerRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PotentialCustomerRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PotentialCustomerRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectMobile()
        .selectCityServiceCenter()
        .selectCityPartner()
        .selectDescription()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public PotentialCustomerRequest selectAny() {
    return selectAll()
        .selectPotentialCustomerContactPersonList(Q.potentialCustomerContactPerson().selectSelf())
        .selectPotentialCustomerContactList(Q.potentialCustomerContact().selectSelf())
        .selectEventAttendanceList(Q.eventAttendance().selectSelf());
  }

  public PotentialCustomerRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(MOBILE_PROPERTY);
    select(CITY_SERVICE_CENTER_PROPERTY);
    select(CITY_PARTNER_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PotentialCustomerRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PotentialCustomerRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
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
    CITY_PARTNER_PROPERTY,
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

  public PotentialCustomerRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PotentialCustomerRequest comment(String comment) {
    return this;
  }

  public PotentialCustomerRequest enhance() {
    return this;
  }

  public PotentialCustomerRequest overrideClass(Class<? extends PotentialCustomer> clazz) {
    return this;
  }

  public PotentialCustomerRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PotentialCustomerRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PotentialCustomerRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PotentialCustomerRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PotentialCustomerRequest count() {
    return countId("count");
  }

  public static PotentialCustomerRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public PotentialCustomerRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PotentialCustomerRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PotentialCustomerRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PotentialCustomerRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PotentialCustomerRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PotentialCustomerRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PotentialCustomerRequest countId() {
    return countId("countId");
  }

  public PotentialCustomerRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PotentialCustomerRequest maxId() {
    return maxId("maxId");
  }

  public PotentialCustomerRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PotentialCustomerRequest minId() {
    return minId("minId");
  }

  public PotentialCustomerRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PotentialCustomerRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PotentialCustomerRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PotentialCustomerRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PotentialCustomerRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public PotentialCustomerRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public PotentialCustomerRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public PotentialCustomerRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public PotentialCustomerRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public PotentialCustomerRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public PotentialCustomerRequest countName() {
    return countName("countName");
  }

  public PotentialCustomerRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public PotentialCustomerRequest maxName() {
    return maxName("maxName");
  }

  public PotentialCustomerRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public PotentialCustomerRequest minName() {
    return minName("minName");
  }

  public PotentialCustomerRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public PotentialCustomerRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public PotentialCustomerRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public PotentialCustomerRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public PotentialCustomerRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest filterByMobile(String mobile) {

    if (mobile == null) {
      return this;
    }

    return filterByMobile(QueryOperator.EQUAL, mobile);
  }

  public PotentialCustomerRequest whereMobileIsNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerRequest whereMobileIsNotNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerRequest filterByMobile(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest selectMobile() {
    return select(MOBILE_PROPERTY);
  }

  public PotentialCustomerRequest unselectMobile() {
    return unselect(MOBILE_PROPERTY);
  }

  public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerRequest orderByMobile(boolean asc) {
    addOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerRequest orderByMobileAscending() {
    addOrderBy(MOBILE_PROPERTY, true);
    return this;
  }

  public PotentialCustomerRequest orderByMobileDescending() {
    addOrderBy(MOBILE_PROPERTY, false);
    return this;
  }

  public PotentialCustomerRequest orderByMobileAscendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", true);
    return this;
  }

  public PotentialCustomerRequest orderByMobileDescendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", false);
    return this;
  }

  public PotentialCustomerRequest countMobile() {
    return countMobile("countMobile");
  }

  public PotentialCustomerRequest countMobile(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PROPERTY);
  }

  public PotentialCustomerRequest maxMobile() {
    return maxMobile("maxMobile");
  }

  public PotentialCustomerRequest maxMobile(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PROPERTY);
  }

  public PotentialCustomerRequest minMobile() {
    return minMobile("minMobile");
  }

  public PotentialCustomerRequest minMobile(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PROPERTY);
  }

  public PotentialCustomerRequest groupByMobile() {
    return groupByMobile(MOBILE_PROPERTY);
  }

  public PotentialCustomerRequest groupByMobile(String ret) {
    return groupBy(ret, MOBILE_PROPERTY);
  }

  public PotentialCustomerRequest groupByMobile(SqlFunction func) {
    return groupByMobile(MOBILE_PROPERTY, func);
  }

  public PotentialCustomerRequest groupByMobile(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public PotentialCustomerRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public PotentialCustomerRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public PotentialCustomerRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public PotentialCustomerRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public PotentialCustomerRequest countDescription() {
    return countDescription("countDescription");
  }

  public PotentialCustomerRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public PotentialCustomerRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerRequest minDescription() {
    return minDescription("minDescription");
  }

  public PotentialCustomerRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public PotentialCustomerRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public PotentialCustomerRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerRequest whereLastUpdateTimeBetween(
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

  public PotentialCustomerRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public PotentialCustomerRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public PotentialCustomerRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public PotentialCustomerRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public PotentialCustomerRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public PotentialCustomerRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public PotentialCustomerRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PotentialCustomerRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PotentialCustomerRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PotentialCustomerRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PotentialCustomerRequest countVersion() {
    return countVersion("countVersion");
  }

  public PotentialCustomerRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PotentialCustomerRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PotentialCustomerRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PotentialCustomerRequest minVersion() {
    return minVersion("minVersion");
  }

  public PotentialCustomerRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PotentialCustomerRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PotentialCustomerRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PotentialCustomerRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PotentialCustomerRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PotentialCustomerRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PotentialCustomerRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    return filterByCityServiceCenter(cityServiceCenter, RetailStoreCityServiceCenter::getId);
  }

  public PotentialCustomerRequest filterByCityServiceCenter(
      RetailStoreCityServiceCenter... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(RetailStoreCityServiceCenter... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public PotentialCustomerRequest selectCityServiceCenterId() {
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

  public PotentialCustomerRequest filterByCityServiceCenter(String... cityServiceCenter) {
    if (isEmptyParam(cityServiceCenter)) {
      throw new IllegalArgumentException(
          "filterByCityServiceCenter(String... cityServiceCenter)参数不能为空!");
    }
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IN, (Object[]) cityServiceCenter);
  }

  public PotentialCustomerRequest filterByCityServiceCenter(
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

  public PotentialCustomerRequest selectCityServiceCenter() {
    return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
  }

  public PotentialCustomerRequest selectCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public PotentialCustomerRequest unselectCityServiceCenter() {
    unselectParent(CITY_SERVICE_CENTER_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest groupByCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    groupBy(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public PotentialCustomerRequest aggregateCityServiceCenter(
      RetailStoreCityServiceCenterRequest cityServiceCenter) {
    aggregateParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
    return this;
  }

  public PotentialCustomerRequest countCityServiceCenter() {
    return countCityServiceCenter("countCityServiceCenter");
  }

  public PotentialCustomerRequest countCityServiceCenter(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_SERVICE_CENTER_PROPERTY);
  }

  public PotentialCustomerRequest groupByCityServiceCenter() {
    return groupByCityServiceCenter(CITY_SERVICE_CENTER_PROPERTY);
  }

  public PotentialCustomerRequest groupByCityServiceCenter(String ret) {
    return groupBy(ret, CITY_SERVICE_CENTER_PROPERTY);
  }

  public PotentialCustomerRequest whereCityServiceCenterIsNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerRequest whereCityServiceCenterIsNotNull() {
    return where(CITY_SERVICE_CENTER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerRequest filterByCityPartner(CityPartnerRequest cityPartner) {
    return filterByCityPartner(cityPartner, CityPartner::getId);
  }

  public PotentialCustomerRequest filterByCityPartner(CityPartner... cityPartner) {
    if (isEmptyParam(cityPartner)) {
      throw new IllegalArgumentException("filterByCityPartner(CityPartner... cityPartner)参数不能为空!");
    }
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IN, (Object[]) cityPartner);
  }

  public PotentialCustomerRequest selectCityPartnerId() {
    select(CITY_PARTNER_PROPERTY);
    return this;
  }

  public CityPartnerRequest upToCityPartner() {
    return upToCityPartner(CityPartnerRequest.newInstance());
  }

  public CityPartnerRequest upToCityPartner(CityPartnerRequest cityPartner) {
    cityPartner.aggregateChild(CITY_PARTNER_PROPERTY, this);
    this.groupByCityPartner(cityPartner);
    return cityPartner;
  }

  public CityPartnerRequest endAtCityPartner(String retName) {
    return endAtCityPartner(retName, CityPartnerRequest.newInstance());
  }

  public CityPartnerRequest endAtCityPartner(String retName, CityPartnerRequest cityPartner) {
    cityPartner.addDynamicProperty(retName, this, CITY_PARTNER_PROPERTY);
    return cityPartner;
  }

  public PotentialCustomerRequest filterByCityPartner(String... cityPartner) {
    if (isEmptyParam(cityPartner)) {
      throw new IllegalArgumentException("filterByCityPartner(String... cityPartner)参数不能为空!");
    }
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IN, (Object[]) cityPartner);
  }

  public PotentialCustomerRequest filterByCityPartner(
      CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
    cityPartner.unlimited();
    return addSearchCriteria(createCityPartnerCriteria(cityPartner, idRefine));
  }

  public SearchCriteria createCityPartnerCriteria(
      CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
    return new RefinedIdInCriteria(
        cityPartner, CITY_PARTNER_PROPERTY, idRefine, CityPartner.ID_PROPERTY);
  }

  public PotentialCustomerRequest selectCityPartner() {
    return selectCityPartner(CityPartnerRequest.newInstance().selectSelf());
  }

  public PotentialCustomerRequest selectCityPartner(CityPartnerRequest cityPartner) {
    selectParent(CITY_PARTNER_PROPERTY, cityPartner);
    return this;
  }

  public PotentialCustomerRequest unselectCityPartner() {
    unselectParent(CITY_PARTNER_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest groupByCityPartner(CityPartnerRequest cityPartner) {
    groupBy(CITY_PARTNER_PROPERTY, cityPartner);
    return this;
  }

  public PotentialCustomerRequest aggregateCityPartner(CityPartnerRequest cityPartner) {
    aggregateParent(CITY_PARTNER_PROPERTY, cityPartner);
    return this;
  }

  public PotentialCustomerRequest countCityPartner() {
    return countCityPartner("countCityPartner");
  }

  public PotentialCustomerRequest countCityPartner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_PARTNER_PROPERTY);
  }

  public PotentialCustomerRequest groupByCityPartner() {
    return groupByCityPartner(CITY_PARTNER_PROPERTY);
  }

  public PotentialCustomerRequest groupByCityPartner(String ret) {
    return groupBy(ret, CITY_PARTNER_PROPERTY);
  }

  public PotentialCustomerRequest whereCityPartnerIsNull() {
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerRequest whereCityPartnerIsNotNull() {
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerRequest hasPotentialCustomerContactPerson() {
    return hasPotentialCustomerContactPerson(PotentialCustomerContactPersonRequest.newInstance());
  }

  public PotentialCustomerRequest hasPotentialCustomerContactPerson(
      PotentialCustomerContactPerson... potentialCustomerContactPerson) {
    if (isEmptyParam(potentialCustomerContactPerson)) {
      throw new IllegalArgumentException(
          "hasPotentialCustomerContactPerson(PotentialCustomerContactPerson... potentialCustomerContactPerson)参数不能为空!");
    }
    return hasPotentialCustomerContactPerson(
        Q.potentialCustomerContactPerson()
            .select(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) potentialCustomerContactPerson));
  }

  public PotentialCustomerRequest hasPotentialCustomerContactPerson(
      String... potentialCustomerContactPerson) {
    return hasPotentialCustomerContactPerson(
        Q.potentialCustomerContactPerson()
            .select(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY)
            .filterById(potentialCustomerContactPerson));
  }

  public PotentialCustomerRequest hasPotentialCustomerContactPerson(
      PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
    return hasPotentialCustomerContactPerson(
        potentialCustomerContactPerson,
        $potentialCustomerContactPerson ->
            java.util.Optional.of($potentialCustomerContactPerson)
                .map(PotentialCustomerContactPerson::getPotentialCustomer)
                .map(PotentialCustomer::getId)
                .orElse(null));
  }

  public PotentialCustomerRequest hasPotentialCustomerContactPerson(
      PotentialCustomerContactPersonRequest potentialCustomerContactPerson,
      IDRefine<PotentialCustomerContactPerson> idRefine) {
    potentialCustomerContactPerson.select(
        PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY);
    potentialCustomerContactPerson.unlimited();
    return addSearchCriteria(
        createPotentialCustomerContactPersonCriteria(potentialCustomerContactPerson, idRefine));
  }

  public PotentialCustomerRequest hasPotentialCustomerContactPerson(
      PotentialCustomerContactPersonRequest potentialCustomerContactPerson,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            potentialCustomerContactPerson,
            PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createPotentialCustomerContactPersonCriteria(
      PotentialCustomerContactPersonRequest potentialCustomerContactPerson,
      IDRefine<PotentialCustomerContactPerson> idRefine) {
    return new RefinedIdInCriteria(
        potentialCustomerContactPerson,
        ID_PROPERTY,
        idRefine,
        PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerRequest selectPotentialCustomerContactPersonList(
      PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
    selectChild(
        PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerContactPerson);
    return this;
  }

  public PotentialCustomerRequest selectPotentialCustomerContactPersonList() {
    return selectPotentialCustomerContactPersonList(
        PotentialCustomerContactPersonRequest.newInstance().selectAll());
  }

  public PotentialCustomerRequest unselectPotentialCustomerContactPersonList() {
    unselectChild(
        PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY,
        PotentialCustomerContactPerson.class);
    return this;
  }

  public PotentialCustomerRequest hasPotentialCustomerContact() {
    return hasPotentialCustomerContact(PotentialCustomerContactRequest.newInstance());
  }

  public PotentialCustomerRequest hasPotentialCustomerContact(
      PotentialCustomerContact... potentialCustomerContact) {
    if (isEmptyParam(potentialCustomerContact)) {
      throw new IllegalArgumentException(
          "hasPotentialCustomerContact(PotentialCustomerContact... potentialCustomerContact)参数不能为空!");
    }
    return hasPotentialCustomerContact(
        Q.potentialCustomerContact()
            .select(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) potentialCustomerContact));
  }

  public PotentialCustomerRequest hasPotentialCustomerContact(String... potentialCustomerContact) {
    return hasPotentialCustomerContact(
        Q.potentialCustomerContact()
            .select(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY)
            .filterById(potentialCustomerContact));
  }

  public PotentialCustomerRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact) {
    return hasPotentialCustomerContact(
        potentialCustomerContact,
        $potentialCustomerContact ->
            java.util.Optional.of($potentialCustomerContact)
                .map(PotentialCustomerContact::getPotentialCustomer)
                .map(PotentialCustomer::getId)
                .orElse(null));
  }

  public PotentialCustomerRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact,
      IDRefine<PotentialCustomerContact> idRefine) {
    potentialCustomerContact.select(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY);
    potentialCustomerContact.unlimited();
    return addSearchCriteria(
        createPotentialCustomerContactCriteria(potentialCustomerContact, idRefine));
  }

  public PotentialCustomerRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            potentialCustomerContact,
            PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY,
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
        PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerRequest selectPotentialCustomerContactList(
      PotentialCustomerContactRequest potentialCustomerContact) {
    selectChild(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerContact);
    return this;
  }

  public PotentialCustomerRequest selectPotentialCustomerContactList() {
    return selectPotentialCustomerContactList(
        PotentialCustomerContactRequest.newInstance().selectAll());
  }

  public PotentialCustomerRequest unselectPotentialCustomerContactList() {
    unselectChild(
        PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomerContact.class);
    return this;
  }

  public PotentialCustomerRequest hasEventAttendance() {
    return hasEventAttendance(EventAttendanceRequest.newInstance());
  }

  public PotentialCustomerRequest hasEventAttendance(EventAttendance... eventAttendance) {
    if (isEmptyParam(eventAttendance)) {
      throw new IllegalArgumentException(
          "hasEventAttendance(EventAttendance... eventAttendance)参数不能为空!");
    }
    return hasEventAttendance(
        Q.eventAttendance()
            .select(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) eventAttendance));
  }

  public PotentialCustomerRequest hasEventAttendance(String... eventAttendance) {
    return hasEventAttendance(
        Q.eventAttendance()
            .select(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY)
            .filterById(eventAttendance));
  }

  public PotentialCustomerRequest hasEventAttendance(EventAttendanceRequest eventAttendance) {
    return hasEventAttendance(
        eventAttendance,
        $eventAttendance ->
            java.util.Optional.of($eventAttendance)
                .map(EventAttendance::getPotentialCustomer)
                .map(PotentialCustomer::getId)
                .orElse(null));
  }

  public PotentialCustomerRequest hasEventAttendance(
      EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine) {
    eventAttendance.select(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY);
    eventAttendance.unlimited();
    return addSearchCriteria(createEventAttendanceCriteria(eventAttendance, idRefine));
  }

  public PotentialCustomerRequest hasEventAttendance(
      EventAttendanceRequest eventAttendance, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            eventAttendance, EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEventAttendanceCriteria(
      EventAttendanceRequest eventAttendance, IDRefine<EventAttendance> idRefine) {
    return new RefinedIdInCriteria(
        eventAttendance, ID_PROPERTY, idRefine, EventAttendance.POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerRequest selectEventAttendanceList(
      EventAttendanceRequest eventAttendance) {
    selectChild(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, eventAttendance);
    return this;
  }

  public PotentialCustomerRequest selectEventAttendanceList() {
    return selectEventAttendanceList(EventAttendanceRequest.newInstance().selectAll());
  }

  public PotentialCustomerRequest unselectEventAttendanceList() {
    unselectChild(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, EventAttendance.class);
    return this;
  }

  public PotentialCustomerRequest aggregatePotentialCustomerContactPersonList(
      PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
    aggregateChild(
        PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerContactPerson);
    return this;
  }

  public PotentialCustomerRequest countPotentialCustomerContactPerson() {
    return countPotentialCustomerContactPerson("potentialCustomerContactPersonCount");
  }

  public PotentialCustomerRequest countPotentialCustomerContactPerson(String retName) {
    return countPotentialCustomerContactPerson(
        retName, PotentialCustomerContactPersonRequest.newInstance());
  }

  public PotentialCustomerRequest countPotentialCustomerContactPerson(
      PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
    return countPotentialCustomerContactPerson(
        "potentialCustomerContactPersonCount", potentialCustomerContactPerson);
  }

  public PotentialCustomerRequest countPotentialCustomerContactPerson(
      String retName, PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
    potentialCustomerContactPerson.count();
    return statsFromPotentialCustomerContactPerson(retName, potentialCustomerContactPerson);
  }

  public PotentialCustomerRequest statsFromPotentialCustomerContactPerson(
      String retName, PotentialCustomerContactPersonRequest potentialCustomerContactPerson) {
    return addDynamicProperty(
        retName,
        potentialCustomerContactPerson,
        PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerRequest aggregatePotentialCustomerContactList(
      PotentialCustomerContactRequest potentialCustomerContact) {
    aggregateChild(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerContact);
    return this;
  }

  public PotentialCustomerRequest countPotentialCustomerContact() {
    return countPotentialCustomerContact("potentialCustomerContactCount");
  }

  public PotentialCustomerRequest countPotentialCustomerContact(String retName) {
    return countPotentialCustomerContact(retName, PotentialCustomerContactRequest.newInstance());
  }

  public PotentialCustomerRequest countPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact) {
    return countPotentialCustomerContact("potentialCustomerContactCount", potentialCustomerContact);
  }

  public PotentialCustomerRequest countPotentialCustomerContact(
      String retName, PotentialCustomerContactRequest potentialCustomerContact) {
    potentialCustomerContact.count();
    return statsFromPotentialCustomerContact(retName, potentialCustomerContact);
  }

  public PotentialCustomerRequest statsFromPotentialCustomerContact(
      String retName, PotentialCustomerContactRequest potentialCustomerContact) {
    return addDynamicProperty(
        retName, potentialCustomerContact, PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerRequest aggregateEventAttendanceList(
      EventAttendanceRequest eventAttendance) {
    aggregateChild(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, eventAttendance);
    return this;
  }

  public PotentialCustomerRequest countEventAttendance() {
    return countEventAttendance("eventAttendanceCount");
  }

  public PotentialCustomerRequest countEventAttendance(String retName) {
    return countEventAttendance(retName, EventAttendanceRequest.newInstance());
  }

  public PotentialCustomerRequest countEventAttendance(EventAttendanceRequest eventAttendance) {
    return countEventAttendance("eventAttendanceCount", eventAttendance);
  }

  public PotentialCustomerRequest countEventAttendance(
      String retName, EventAttendanceRequest eventAttendance) {
    eventAttendance.count();
    return statsFromEventAttendance(retName, eventAttendance);
  }

  public PotentialCustomerRequest statsFromEventAttendance(
      String retName, EventAttendanceRequest eventAttendance) {
    return addDynamicProperty(
        retName, eventAttendance, EventAttendance.POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PotentialCustomerRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PotentialCustomerRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PotentialCustomerRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
