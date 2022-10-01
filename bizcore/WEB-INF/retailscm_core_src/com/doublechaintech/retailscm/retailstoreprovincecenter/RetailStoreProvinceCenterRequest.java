package com.doublechaintech.retailscm.retailstoreprovincecenter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;

import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentRequest;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter.*;

public class RetailStoreProvinceCenterRequest extends BaseRequest<RetailStoreProvinceCenter> {
  public static RetailStoreProvinceCenterRequest newInstance() {
    return new RetailStoreProvinceCenterRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreProvinceCenterRequest resultByClass(
      Class<? extends RetailStoreProvinceCenter> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreProvinceCenterRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreProvinceCenterRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreProvinceCenter";
  }

  public RetailStoreProvinceCenterRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreProvinceCenterRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreProvinceCenterRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreProvinceCenterRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreProvinceCenterRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectFounded()
        .selectCountry()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public RetailStoreProvinceCenterRequest selectAny() {
    return selectAll()
        .selectProvinceCenterDepartmentList(Q.provinceCenterDepartment().selectSelf())
        .selectProvinceCenterEmployeeList(Q.provinceCenterEmployee().selectSelf())
        .selectRetailStoreCityServiceCenterList(Q.retailStoreCityServiceCenter().selectSelf());
  }

  public RetailStoreProvinceCenterRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(COUNTRY_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreProvinceCenterRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreProvinceCenterRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {
    FOUNDED_PROPERTY, LAST_UPDATE_TIME_PROPERTY
  };
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    FOUNDED_PROPERTY,
    COUNTRY_PROPERTY,
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

  public RetailStoreProvinceCenterRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreProvinceCenterRequest comment(String comment) {
    return this;
  }

  public RetailStoreProvinceCenterRequest enhance() {
    return this;
  }

  public RetailStoreProvinceCenterRequest overrideClass(
      Class<? extends RetailStoreProvinceCenter> clazz) {
    return this;
  }

  public RetailStoreProvinceCenterRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreProvinceCenterRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreProvinceCenterRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreProvinceCenterRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreProvinceCenterRequest count() {
    return countId("count");
  }

  public static RetailStoreProvinceCenterRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreProvinceCenterRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreProvinceCenterRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreProvinceCenterRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreProvinceCenterRequest countId() {
    return countId("countId");
  }

  public RetailStoreProvinceCenterRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreProvinceCenterRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest minId() {
    return minId("minId");
  }

  public RetailStoreProvinceCenterRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreProvinceCenterRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreProvinceCenterRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreProvinceCenterRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreProvinceCenterRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreProvinceCenterRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreProvinceCenterRequest countName() {
    return countName("countName");
  }

  public RetailStoreProvinceCenterRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreProvinceCenterRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest minName() {
    return minName("minName");
  }

  public RetailStoreProvinceCenterRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreProvinceCenterRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public RetailStoreProvinceCenterRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreProvinceCenterRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreProvinceCenterRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
    if (ObjectUtil.isEmpty(foundedStart)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBetween, the parameter foundedStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(foundedEnd)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBetween, the parameter foundedEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.BETWEEN, new Object[] {foundedStart, foundedEnd});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreProvinceCenterRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public RetailStoreProvinceCenterRequest countFounded() {
    return countFounded("countFounded");
  }

  public RetailStoreProvinceCenterRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public RetailStoreProvinceCenterRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest minFounded() {
    return minFounded("minFounded");
  }

  public RetailStoreProvinceCenterRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public RetailStoreProvinceCenterRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public RetailStoreProvinceCenterRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreProvinceCenterRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreProvinceCenterRequest whereLastUpdateTimeBetween(
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

  public RetailStoreProvinceCenterRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreProvinceCenterRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public RetailStoreProvinceCenterRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public RetailStoreProvinceCenterRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public RetailStoreProvinceCenterRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public RetailStoreProvinceCenterRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public RetailStoreProvinceCenterRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreProvinceCenterRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreProvinceCenterRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreProvinceCenterRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreProvinceCenterRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreProvinceCenterRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreProvinceCenterRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreProvinceCenterRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreProvinceCenterRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreProvinceCenterRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreProvinceCenterRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreProvinceCenterRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreProvinceCenterRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest filterByCountry(RetailStoreCountryCenterRequest country) {
    return filterByCountry(country, RetailStoreCountryCenter::getId);
  }

  public RetailStoreProvinceCenterRequest filterByCountry(RetailStoreCountryCenter... country) {
    if (isEmptyParam(country)) {
      throw new IllegalArgumentException(
          "filterByCountry(RetailStoreCountryCenter... country)参数不能为空!");
    }
    return where(COUNTRY_PROPERTY, QueryOperator.IN, (Object[]) country);
  }

  public RetailStoreProvinceCenterRequest selectCountryId() {
    select(COUNTRY_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToCountry() {
    return upToCountry(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToCountry(RetailStoreCountryCenterRequest country) {
    country.aggregateChild(COUNTRY_PROPERTY, this);
    this.groupByCountry(country);
    return country;
  }

  public RetailStoreCountryCenterRequest endAtCountry(String retName) {
    return endAtCountry(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtCountry(
      String retName, RetailStoreCountryCenterRequest country) {
    country.addDynamicProperty(retName, this, COUNTRY_PROPERTY);
    return country;
  }

  public RetailStoreProvinceCenterRequest filterByCountry(String... country) {
    if (isEmptyParam(country)) {
      throw new IllegalArgumentException("filterByCountry(String... country)参数不能为空!");
    }
    return where(COUNTRY_PROPERTY, QueryOperator.IN, (Object[]) country);
  }

  public RetailStoreProvinceCenterRequest filterByCountry(
      RetailStoreCountryCenterRequest country, IDRefine<RetailStoreCountryCenter> idRefine) {
    country.unlimited();
    return addSearchCriteria(createCountryCriteria(country, idRefine));
  }

  public SearchCriteria createCountryCriteria(
      RetailStoreCountryCenterRequest country, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        country, COUNTRY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest selectCountry() {
    return selectCountry(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public RetailStoreProvinceCenterRequest selectCountry(RetailStoreCountryCenterRequest country) {
    selectParent(COUNTRY_PROPERTY, country);
    return this;
  }

  public RetailStoreProvinceCenterRequest unselectCountry() {
    unselectParent(COUNTRY_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest groupByCountry(RetailStoreCountryCenterRequest country) {
    groupBy(COUNTRY_PROPERTY, country);
    return this;
  }

  public RetailStoreProvinceCenterRequest aggregateCountry(
      RetailStoreCountryCenterRequest country) {
    aggregateParent(COUNTRY_PROPERTY, country);
    return this;
  }

  public RetailStoreProvinceCenterRequest countCountry() {
    return countCountry("countCountry");
  }

  public RetailStoreProvinceCenterRequest countCountry(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COUNTRY_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByCountry() {
    return groupByCountry(COUNTRY_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest groupByCountry(String ret) {
    return groupBy(ret, COUNTRY_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest whereCountryIsNull() {
    return where(COUNTRY_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreProvinceCenterRequest whereCountryIsNotNull() {
    return where(COUNTRY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment() {
    return hasProvinceCenterDepartment(ProvinceCenterDepartmentRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment(
      ProvinceCenterDepartment... provinceCenterDepartment) {
    if (isEmptyParam(provinceCenterDepartment)) {
      throw new IllegalArgumentException(
          "hasProvinceCenterDepartment(ProvinceCenterDepartment... provinceCenterDepartment)参数不能为空!");
    }
    return hasProvinceCenterDepartment(
        Q.provinceCenterDepartment()
            .select(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) provinceCenterDepartment));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment(
      String... provinceCenterDepartment) {
    return hasProvinceCenterDepartment(
        Q.provinceCenterDepartment()
            .select(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY)
            .filterById(provinceCenterDepartment));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment(
      ProvinceCenterDepartmentRequest provinceCenterDepartment) {
    return hasProvinceCenterDepartment(
        provinceCenterDepartment,
        $provinceCenterDepartment ->
            java.util.Optional.of($provinceCenterDepartment)
                .map(ProvinceCenterDepartment::getProvinceCenter)
                .map(RetailStoreProvinceCenter::getId)
                .orElse(null));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment(
      ProvinceCenterDepartmentRequest provinceCenterDepartment,
      IDRefine<ProvinceCenterDepartment> idRefine) {
    provinceCenterDepartment.select(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY);
    provinceCenterDepartment.unlimited();
    return addSearchCriteria(
        createProvinceCenterDepartmentCriteria(provinceCenterDepartment, idRefine));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterDepartment(
      ProvinceCenterDepartmentRequest provinceCenterDepartment,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            provinceCenterDepartment,
            ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createProvinceCenterDepartmentCriteria(
      ProvinceCenterDepartmentRequest provinceCenterDepartment,
      IDRefine<ProvinceCenterDepartment> idRefine) {
    return new RefinedIdInCriteria(
        provinceCenterDepartment,
        ID_PROPERTY,
        idRefine,
        ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest selectProvinceCenterDepartmentList(
      ProvinceCenterDepartmentRequest provinceCenterDepartment) {
    selectChild(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, provinceCenterDepartment);
    return this;
  }

  public RetailStoreProvinceCenterRequest selectProvinceCenterDepartmentList() {
    return selectProvinceCenterDepartmentList(
        ProvinceCenterDepartmentRequest.newInstance().selectAll());
  }

  public RetailStoreProvinceCenterRequest unselectProvinceCenterDepartmentList() {
    unselectChild(
        ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, ProvinceCenterDepartment.class);
    return this;
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee() {
    return hasProvinceCenterEmployee(ProvinceCenterEmployeeRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployee... provinceCenterEmployee) {
    if (isEmptyParam(provinceCenterEmployee)) {
      throw new IllegalArgumentException(
          "hasProvinceCenterEmployee(ProvinceCenterEmployee... provinceCenterEmployee)参数不能为空!");
    }
    return hasProvinceCenterEmployee(
        Q.provinceCenterEmployee()
            .select(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) provinceCenterEmployee));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee(
      String... provinceCenterEmployee) {
    return hasProvinceCenterEmployee(
        Q.provinceCenterEmployee()
            .select(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY)
            .filterById(provinceCenterEmployee));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    return hasProvinceCenterEmployee(
        provinceCenterEmployee,
        $provinceCenterEmployee ->
            java.util.Optional.of($provinceCenterEmployee)
                .map(ProvinceCenterEmployee::getProvinceCenter)
                .map(RetailStoreProvinceCenter::getId)
                .orElse(null));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee,
      IDRefine<ProvinceCenterEmployee> idRefine) {
    provinceCenterEmployee.select(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY);
    provinceCenterEmployee.unlimited();
    return addSearchCriteria(
        createProvinceCenterEmployeeCriteria(provinceCenterEmployee, idRefine));
  }

  public RetailStoreProvinceCenterRequest hasProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            provinceCenterEmployee,
            ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createProvinceCenterEmployeeCriteria(
      ProvinceCenterEmployeeRequest provinceCenterEmployee,
      IDRefine<ProvinceCenterEmployee> idRefine) {
    return new RefinedIdInCriteria(
        provinceCenterEmployee,
        ID_PROPERTY,
        idRefine,
        ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest selectProvinceCenterEmployeeList(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    selectChild(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, provinceCenterEmployee);
    return this;
  }

  public RetailStoreProvinceCenterRequest selectProvinceCenterEmployeeList() {
    return selectProvinceCenterEmployeeList(
        ProvinceCenterEmployeeRequest.newInstance().selectAll());
  }

  public RetailStoreProvinceCenterRequest unselectProvinceCenterEmployeeList() {
    unselectChild(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, ProvinceCenterEmployee.class);
    return this;
  }

  public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter() {
    return hasRetailStoreCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter(
      RetailStoreCityServiceCenter... retailStoreCityServiceCenter) {
    if (isEmptyParam(retailStoreCityServiceCenter)) {
      throw new IllegalArgumentException(
          "hasRetailStoreCityServiceCenter(RetailStoreCityServiceCenter... retailStoreCityServiceCenter)参数不能为空!");
    }
    return hasRetailStoreCityServiceCenter(
        Q.retailStoreCityServiceCenter()
            .select(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreCityServiceCenter));
  }

  public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter(
      String... retailStoreCityServiceCenter) {
    return hasRetailStoreCityServiceCenter(
        Q.retailStoreCityServiceCenter()
            .select(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY)
            .filterById(retailStoreCityServiceCenter));
  }

  public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter(
      RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
    return hasRetailStoreCityServiceCenter(
        retailStoreCityServiceCenter,
        $retailStoreCityServiceCenter ->
            java.util.Optional.of($retailStoreCityServiceCenter)
                .map(RetailStoreCityServiceCenter::getBelongsTo)
                .map(RetailStoreProvinceCenter::getId)
                .orElse(null));
  }

  public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter(
      RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter,
      IDRefine<RetailStoreCityServiceCenter> idRefine) {
    retailStoreCityServiceCenter.select(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY);
    retailStoreCityServiceCenter.unlimited();
    return addSearchCriteria(
        createRetailStoreCityServiceCenterCriteria(retailStoreCityServiceCenter, idRefine));
  }

  public RetailStoreProvinceCenterRequest hasRetailStoreCityServiceCenter(
      RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreCityServiceCenter,
            RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreCityServiceCenterCriteria(
      RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter,
      IDRefine<RetailStoreCityServiceCenter> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreCityServiceCenter,
        ID_PROPERTY,
        idRefine,
        RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest selectRetailStoreCityServiceCenterList(
      RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
    selectChild(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, retailStoreCityServiceCenter);
    return this;
  }

  public RetailStoreProvinceCenterRequest selectRetailStoreCityServiceCenterList() {
    return selectRetailStoreCityServiceCenterList(
        RetailStoreCityServiceCenterRequest.newInstance().selectAll());
  }

  public RetailStoreProvinceCenterRequest unselectRetailStoreCityServiceCenterList() {
    unselectChild(
        RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, RetailStoreCityServiceCenter.class);
    return this;
  }

  public RetailStoreProvinceCenterRequest aggregateProvinceCenterDepartmentList(
      ProvinceCenterDepartmentRequest provinceCenterDepartment) {
    aggregateChild(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, provinceCenterDepartment);
    return this;
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterDepartment() {
    return countProvinceCenterDepartment("provinceCenterDepartmentCount");
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterDepartment(String retName) {
    return countProvinceCenterDepartment(retName, ProvinceCenterDepartmentRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterDepartment(
      ProvinceCenterDepartmentRequest provinceCenterDepartment) {
    return countProvinceCenterDepartment("provinceCenterDepartmentCount", provinceCenterDepartment);
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterDepartment(
      String retName, ProvinceCenterDepartmentRequest provinceCenterDepartment) {
    provinceCenterDepartment.count();
    return statsFromProvinceCenterDepartment(retName, provinceCenterDepartment);
  }

  public RetailStoreProvinceCenterRequest statsFromProvinceCenterDepartment(
      String retName, ProvinceCenterDepartmentRequest provinceCenterDepartment) {
    return addDynamicProperty(
        retName, provinceCenterDepartment, ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest aggregateProvinceCenterEmployeeList(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    aggregateChild(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, provinceCenterEmployee);
    return this;
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterEmployee() {
    return countProvinceCenterEmployee("provinceCenterEmployeeCount");
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterEmployee(String retName) {
    return countProvinceCenterEmployee(retName, ProvinceCenterEmployeeRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterEmployee(
      ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    return countProvinceCenterEmployee("provinceCenterEmployeeCount", provinceCenterEmployee);
  }

  public RetailStoreProvinceCenterRequest countProvinceCenterEmployee(
      String retName, ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    provinceCenterEmployee.count();
    return statsFromProvinceCenterEmployee(retName, provinceCenterEmployee);
  }

  public RetailStoreProvinceCenterRequest statsFromProvinceCenterEmployee(
      String retName, ProvinceCenterEmployeeRequest provinceCenterEmployee) {
    return addDynamicProperty(
        retName, provinceCenterEmployee, ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest aggregateRetailStoreCityServiceCenterList(
      RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
    aggregateChild(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, retailStoreCityServiceCenter);
    return this;
  }

  public RetailStoreProvinceCenterRequest countRetailStoreCityServiceCenter() {
    return countRetailStoreCityServiceCenter("retailStoreCityServiceCenterCount");
  }

  public RetailStoreProvinceCenterRequest countRetailStoreCityServiceCenter(String retName) {
    return countRetailStoreCityServiceCenter(
        retName, RetailStoreCityServiceCenterRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest countRetailStoreCityServiceCenter(
      RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
    return countRetailStoreCityServiceCenter(
        "retailStoreCityServiceCenterCount", retailStoreCityServiceCenter);
  }

  public RetailStoreProvinceCenterRequest countRetailStoreCityServiceCenter(
      String retName, RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
    retailStoreCityServiceCenter.count();
    return statsFromRetailStoreCityServiceCenter(retName, retailStoreCityServiceCenter);
  }

  public RetailStoreProvinceCenterRequest statsFromRetailStoreCityServiceCenter(
      String retName, RetailStoreCityServiceCenterRequest retailStoreCityServiceCenter) {
    return addDynamicProperty(
        retName, retailStoreCityServiceCenter, RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY);
  }

  public RetailStoreProvinceCenterRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreProvinceCenterRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreProvinceCenterRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreProvinceCenterRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
