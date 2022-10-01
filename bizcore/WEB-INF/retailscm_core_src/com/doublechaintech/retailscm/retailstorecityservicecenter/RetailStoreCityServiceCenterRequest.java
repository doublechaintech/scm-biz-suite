package com.doublechaintech.retailscm.retailstorecityservicecenter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;

import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.cityevent.CityEventRequest;
import com.doublechaintech.retailscm.citypartner.CityPartnerRequest;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter.*;

public class RetailStoreCityServiceCenterRequest extends BaseRequest<RetailStoreCityServiceCenter> {
  public static RetailStoreCityServiceCenterRequest newInstance() {
    return new RetailStoreCityServiceCenterRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreCityServiceCenterRequest resultByClass(
      Class<? extends RetailStoreCityServiceCenter> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreCityServiceCenterRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreCityServiceCenterRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreCityServiceCenter";
  }

  public RetailStoreCityServiceCenterRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreCityServiceCenterRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreCityServiceCenterRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreCityServiceCenterRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreCityServiceCenterRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectFounded()
        .selectBelongsTo()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public RetailStoreCityServiceCenterRequest selectAny() {
    return selectAll()
        .selectCityPartnerList(Q.cityPartner().selectSelf())
        .selectPotentialCustomerList(Q.potentialCustomer().selectSelf())
        .selectCityEventList(Q.cityEvent().selectSelf())
        .selectRetailStoreList(Q.retailStore().selectSelf());
  }

  public RetailStoreCityServiceCenterRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(BELONGS_TO_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreCityServiceCenterRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreCityServiceCenterRequest where(
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
    BELONGS_TO_PROPERTY,
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

  public RetailStoreCityServiceCenterRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreCityServiceCenterRequest comment(String comment) {
    return this;
  }

  public RetailStoreCityServiceCenterRequest enhance() {
    return this;
  }

  public RetailStoreCityServiceCenterRequest overrideClass(
      Class<? extends RetailStoreCityServiceCenter> clazz) {
    return this;
  }

  public RetailStoreCityServiceCenterRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreCityServiceCenterRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreCityServiceCenterRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreCityServiceCenterRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreCityServiceCenterRequest count() {
    return countId("count");
  }

  public static RetailStoreCityServiceCenterRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreCityServiceCenterRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreCityServiceCenterRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCityServiceCenterRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countId() {
    return countId("countId");
  }

  public RetailStoreCityServiceCenterRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreCityServiceCenterRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest minId() {
    return minId("minId");
  }

  public RetailStoreCityServiceCenterRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreCityServiceCenterRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreCityServiceCenterRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCityServiceCenterRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCityServiceCenterRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCityServiceCenterRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countName() {
    return countName("countName");
  }

  public RetailStoreCityServiceCenterRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreCityServiceCenterRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest minName() {
    return minName("minName");
  }

  public RetailStoreCityServiceCenterRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreCityServiceCenterRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public RetailStoreCityServiceCenterRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCityServiceCenterRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCityServiceCenterRequest whereFoundedBetween(
      Date foundedStart, Date foundedEnd) {
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

  public RetailStoreCityServiceCenterRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCityServiceCenterRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countFounded() {
    return countFounded("countFounded");
  }

  public RetailStoreCityServiceCenterRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public RetailStoreCityServiceCenterRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest minFounded() {
    return minFounded("minFounded");
  }

  public RetailStoreCityServiceCenterRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public RetailStoreCityServiceCenterRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public RetailStoreCityServiceCenterRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCityServiceCenterRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCityServiceCenterRequest whereLastUpdateTimeBetween(
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

  public RetailStoreCityServiceCenterRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCityServiceCenterRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public RetailStoreCityServiceCenterRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public RetailStoreCityServiceCenterRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public RetailStoreCityServiceCenterRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public RetailStoreCityServiceCenterRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreCityServiceCenterRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCityServiceCenterRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCityServiceCenterRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCityServiceCenterRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCityServiceCenterRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreCityServiceCenterRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreCityServiceCenterRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreCityServiceCenterRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreCityServiceCenterRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreCityServiceCenterRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreCityServiceCenterRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest filterByBelongsTo(
      RetailStoreProvinceCenterRequest belongsTo) {
    return filterByBelongsTo(belongsTo, RetailStoreProvinceCenter::getId);
  }

  public RetailStoreCityServiceCenterRequest filterByBelongsTo(
      RetailStoreProvinceCenter... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException(
          "filterByBelongsTo(RetailStoreProvinceCenter... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public RetailStoreCityServiceCenterRequest selectBelongsToId() {
    select(BELONGS_TO_PROPERTY);
    return this;
  }

  public RetailStoreProvinceCenterRequest upToBelongsTo() {
    return upToBelongsTo(RetailStoreProvinceCenterRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest upToBelongsTo(
      RetailStoreProvinceCenterRequest belongsTo) {
    belongsTo.aggregateChild(BELONGS_TO_PROPERTY, this);
    this.groupByBelongsTo(belongsTo);
    return belongsTo;
  }

  public RetailStoreProvinceCenterRequest endAtBelongsTo(String retName) {
    return endAtBelongsTo(retName, RetailStoreProvinceCenterRequest.newInstance());
  }

  public RetailStoreProvinceCenterRequest endAtBelongsTo(
      String retName, RetailStoreProvinceCenterRequest belongsTo) {
    belongsTo.addDynamicProperty(retName, this, BELONGS_TO_PROPERTY);
    return belongsTo;
  }

  public RetailStoreCityServiceCenterRequest filterByBelongsTo(String... belongsTo) {
    if (isEmptyParam(belongsTo)) {
      throw new IllegalArgumentException("filterByBelongsTo(String... belongsTo)参数不能为空!");
    }
    return where(BELONGS_TO_PROPERTY, QueryOperator.IN, (Object[]) belongsTo);
  }

  public RetailStoreCityServiceCenterRequest filterByBelongsTo(
      RetailStoreProvinceCenterRequest belongsTo, IDRefine<RetailStoreProvinceCenter> idRefine) {
    belongsTo.unlimited();
    return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
  }

  public SearchCriteria createBelongsToCriteria(
      RetailStoreProvinceCenterRequest belongsTo, IDRefine<RetailStoreProvinceCenter> idRefine) {
    return new RefinedIdInCriteria(
        belongsTo, BELONGS_TO_PROPERTY, idRefine, RetailStoreProvinceCenter.ID_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest selectBelongsTo() {
    return selectBelongsTo(RetailStoreProvinceCenterRequest.newInstance().selectSelf());
  }

  public RetailStoreCityServiceCenterRequest selectBelongsTo(
      RetailStoreProvinceCenterRequest belongsTo) {
    selectParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public RetailStoreCityServiceCenterRequest unselectBelongsTo() {
    unselectParent(BELONGS_TO_PROPERTY);
    return this;
  }

  public RetailStoreCityServiceCenterRequest groupByBelongsTo(
      RetailStoreProvinceCenterRequest belongsTo) {
    groupBy(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public RetailStoreCityServiceCenterRequest aggregateBelongsTo(
      RetailStoreProvinceCenterRequest belongsTo) {
    aggregateParent(BELONGS_TO_PROPERTY, belongsTo);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countBelongsTo() {
    return countBelongsTo("countBelongsTo");
  }

  public RetailStoreCityServiceCenterRequest countBelongsTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BELONGS_TO_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByBelongsTo() {
    return groupByBelongsTo(BELONGS_TO_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest groupByBelongsTo(String ret) {
    return groupBy(ret, BELONGS_TO_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest whereBelongsToIsNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCityServiceCenterRequest whereBelongsToIsNotNull() {
    return where(BELONGS_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCityServiceCenterRequest hasCityPartner() {
    return hasCityPartner(CityPartnerRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest hasCityPartner(CityPartner... cityPartner) {
    if (isEmptyParam(cityPartner)) {
      throw new IllegalArgumentException("hasCityPartner(CityPartner... cityPartner)参数不能为空!");
    }
    return hasCityPartner(
        Q.cityPartner()
            .select(CityPartner.CITY_SERVICE_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) cityPartner));
  }

  public RetailStoreCityServiceCenterRequest hasCityPartner(String... cityPartner) {
    return hasCityPartner(
        Q.cityPartner().select(CityPartner.CITY_SERVICE_CENTER_PROPERTY).filterById(cityPartner));
  }

  public RetailStoreCityServiceCenterRequest hasCityPartner(CityPartnerRequest cityPartner) {
    return hasCityPartner(
        cityPartner,
        $cityPartner ->
            java.util.Optional.of($cityPartner)
                .map(CityPartner::getCityServiceCenter)
                .map(RetailStoreCityServiceCenter::getId)
                .orElse(null));
  }

  public RetailStoreCityServiceCenterRequest hasCityPartner(
      CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
    cityPartner.select(CityPartner.CITY_SERVICE_CENTER_PROPERTY);
    cityPartner.unlimited();
    return addSearchCriteria(createCityPartnerCriteria(cityPartner, idRefine));
  }

  public RetailStoreCityServiceCenterRequest hasCityPartner(
      CityPartnerRequest cityPartner, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            cityPartner, CityPartner.CITY_SERVICE_CENTER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createCityPartnerCriteria(
      CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
    return new RefinedIdInCriteria(
        cityPartner, ID_PROPERTY, idRefine, CityPartner.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest selectCityPartnerList(CityPartnerRequest cityPartner) {
    selectChild(CityPartner.CITY_SERVICE_CENTER_PROPERTY, cityPartner);
    return this;
  }

  public RetailStoreCityServiceCenterRequest selectCityPartnerList() {
    return selectCityPartnerList(CityPartnerRequest.newInstance().selectAll());
  }

  public RetailStoreCityServiceCenterRequest unselectCityPartnerList() {
    unselectChild(CityPartner.CITY_SERVICE_CENTER_PROPERTY, CityPartner.class);
    return this;
  }

  public RetailStoreCityServiceCenterRequest hasPotentialCustomer() {
    return hasPotentialCustomer(PotentialCustomerRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest hasPotentialCustomer(
      PotentialCustomer... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "hasPotentialCustomer(PotentialCustomer... potentialCustomer)参数不能为空!");
    }
    return hasPotentialCustomer(
        Q.potentialCustomer()
            .select(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) potentialCustomer));
  }

  public RetailStoreCityServiceCenterRequest hasPotentialCustomer(String... potentialCustomer) {
    return hasPotentialCustomer(
        Q.potentialCustomer()
            .select(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY)
            .filterById(potentialCustomer));
  }

  public RetailStoreCityServiceCenterRequest hasPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    return hasPotentialCustomer(
        potentialCustomer,
        $potentialCustomer ->
            java.util.Optional.of($potentialCustomer)
                .map(PotentialCustomer::getCityServiceCenter)
                .map(RetailStoreCityServiceCenter::getId)
                .orElse(null));
  }

  public RetailStoreCityServiceCenterRequest hasPotentialCustomer(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    potentialCustomer.select(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY);
    potentialCustomer.unlimited();
    return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
  }

  public RetailStoreCityServiceCenterRequest hasPotentialCustomer(
      PotentialCustomerRequest potentialCustomer, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            potentialCustomer,
            PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createPotentialCustomerCriteria(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    return new RefinedIdInCriteria(
        potentialCustomer, ID_PROPERTY, idRefine, PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest selectPotentialCustomerList(
      PotentialCustomerRequest potentialCustomer) {
    selectChild(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, potentialCustomer);
    return this;
  }

  public RetailStoreCityServiceCenterRequest selectPotentialCustomerList() {
    return selectPotentialCustomerList(PotentialCustomerRequest.newInstance().selectAll());
  }

  public RetailStoreCityServiceCenterRequest unselectPotentialCustomerList() {
    unselectChild(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, PotentialCustomer.class);
    return this;
  }

  public RetailStoreCityServiceCenterRequest hasCityEvent() {
    return hasCityEvent(CityEventRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest hasCityEvent(CityEvent... cityEvent) {
    if (isEmptyParam(cityEvent)) {
      throw new IllegalArgumentException("hasCityEvent(CityEvent... cityEvent)参数不能为空!");
    }
    return hasCityEvent(
        Q.cityEvent()
            .select(CityEvent.CITY_SERVICE_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) cityEvent));
  }

  public RetailStoreCityServiceCenterRequest hasCityEvent(String... cityEvent) {
    return hasCityEvent(
        Q.cityEvent().select(CityEvent.CITY_SERVICE_CENTER_PROPERTY).filterById(cityEvent));
  }

  public RetailStoreCityServiceCenterRequest hasCityEvent(CityEventRequest cityEvent) {
    return hasCityEvent(
        cityEvent,
        $cityEvent ->
            java.util.Optional.of($cityEvent)
                .map(CityEvent::getCityServiceCenter)
                .map(RetailStoreCityServiceCenter::getId)
                .orElse(null));
  }

  public RetailStoreCityServiceCenterRequest hasCityEvent(
      CityEventRequest cityEvent, IDRefine<CityEvent> idRefine) {
    cityEvent.select(CityEvent.CITY_SERVICE_CENTER_PROPERTY);
    cityEvent.unlimited();
    return addSearchCriteria(createCityEventCriteria(cityEvent, idRefine));
  }

  public RetailStoreCityServiceCenterRequest hasCityEvent(
      CityEventRequest cityEvent, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            cityEvent, CityEvent.CITY_SERVICE_CENTER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createCityEventCriteria(
      CityEventRequest cityEvent, IDRefine<CityEvent> idRefine) {
    return new RefinedIdInCriteria(
        cityEvent, ID_PROPERTY, idRefine, CityEvent.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest selectCityEventList(CityEventRequest cityEvent) {
    selectChild(CityEvent.CITY_SERVICE_CENTER_PROPERTY, cityEvent);
    return this;
  }

  public RetailStoreCityServiceCenterRequest selectCityEventList() {
    return selectCityEventList(CityEventRequest.newInstance().selectAll());
  }

  public RetailStoreCityServiceCenterRequest unselectCityEventList() {
    unselectChild(CityEvent.CITY_SERVICE_CENTER_PROPERTY, CityEvent.class);
    return this;
  }

  public RetailStoreCityServiceCenterRequest hasRetailStore() {
    return hasRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest hasRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("hasRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.CITY_SERVICE_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStore));
  }

  public RetailStoreCityServiceCenterRequest hasRetailStore(String... retailStore) {
    return hasRetailStore(
        Q.retailStore().select(RetailStore.CITY_SERVICE_CENTER_PROPERTY).filterById(retailStore));
  }

  public RetailStoreCityServiceCenterRequest hasRetailStore(RetailStoreRequest retailStore) {
    return hasRetailStore(
        retailStore,
        $retailStore ->
            java.util.Optional.of($retailStore)
                .map(RetailStore::getCityServiceCenter)
                .map(RetailStoreCityServiceCenter::getId)
                .orElse(null));
  }

  public RetailStoreCityServiceCenterRequest hasRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.select(RetailStore.CITY_SERVICE_CENTER_PROPERTY);
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public RetailStoreCityServiceCenterRequest hasRetailStore(
      RetailStoreRequest retailStore, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStore, RetailStore.CITY_SERVICE_CENTER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, ID_PROPERTY, idRefine, RetailStore.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest selectRetailStoreList(RetailStoreRequest retailStore) {
    selectChild(RetailStore.CITY_SERVICE_CENTER_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreCityServiceCenterRequest selectRetailStoreList() {
    return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
  }

  public RetailStoreCityServiceCenterRequest unselectRetailStoreList() {
    unselectChild(RetailStore.CITY_SERVICE_CENTER_PROPERTY, RetailStore.class);
    return this;
  }

  public RetailStoreCityServiceCenterRequest aggregateCityPartnerList(
      CityPartnerRequest cityPartner) {
    aggregateChild(CityPartner.CITY_SERVICE_CENTER_PROPERTY, cityPartner);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countCityPartner() {
    return countCityPartner("cityPartnerCount");
  }

  public RetailStoreCityServiceCenterRequest countCityPartner(String retName) {
    return countCityPartner(retName, CityPartnerRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest countCityPartner(CityPartnerRequest cityPartner) {
    return countCityPartner("cityPartnerCount", cityPartner);
  }

  public RetailStoreCityServiceCenterRequest countCityPartner(
      String retName, CityPartnerRequest cityPartner) {
    cityPartner.count();
    return statsFromCityPartner(retName, cityPartner);
  }

  public RetailStoreCityServiceCenterRequest statsFromCityPartner(
      String retName, CityPartnerRequest cityPartner) {
    return addDynamicProperty(retName, cityPartner, CityPartner.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest aggregatePotentialCustomerList(
      PotentialCustomerRequest potentialCustomer) {
    aggregateChild(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, potentialCustomer);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countPotentialCustomer() {
    return countPotentialCustomer("potentialCustomerCount");
  }

  public RetailStoreCityServiceCenterRequest countPotentialCustomer(String retName) {
    return countPotentialCustomer(retName, PotentialCustomerRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest countPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    return countPotentialCustomer("potentialCustomerCount", potentialCustomer);
  }

  public RetailStoreCityServiceCenterRequest countPotentialCustomer(
      String retName, PotentialCustomerRequest potentialCustomer) {
    potentialCustomer.count();
    return statsFromPotentialCustomer(retName, potentialCustomer);
  }

  public RetailStoreCityServiceCenterRequest statsFromPotentialCustomer(
      String retName, PotentialCustomerRequest potentialCustomer) {
    return addDynamicProperty(
        retName, potentialCustomer, PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest aggregateCityEventList(CityEventRequest cityEvent) {
    aggregateChild(CityEvent.CITY_SERVICE_CENTER_PROPERTY, cityEvent);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countCityEvent() {
    return countCityEvent("cityEventCount");
  }

  public RetailStoreCityServiceCenterRequest countCityEvent(String retName) {
    return countCityEvent(retName, CityEventRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest countCityEvent(CityEventRequest cityEvent) {
    return countCityEvent("cityEventCount", cityEvent);
  }

  public RetailStoreCityServiceCenterRequest countCityEvent(
      String retName, CityEventRequest cityEvent) {
    cityEvent.count();
    return statsFromCityEvent(retName, cityEvent);
  }

  public RetailStoreCityServiceCenterRequest statsFromCityEvent(
      String retName, CityEventRequest cityEvent) {
    return addDynamicProperty(retName, cityEvent, CityEvent.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest aggregateRetailStoreList(
      RetailStoreRequest retailStore) {
    aggregateChild(RetailStore.CITY_SERVICE_CENTER_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreCityServiceCenterRequest countRetailStore() {
    return countRetailStore("retailStoreCount");
  }

  public RetailStoreCityServiceCenterRequest countRetailStore(String retName) {
    return countRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreCityServiceCenterRequest countRetailStore(RetailStoreRequest retailStore) {
    return countRetailStore("retailStoreCount", retailStore);
  }

  public RetailStoreCityServiceCenterRequest countRetailStore(
      String retName, RetailStoreRequest retailStore) {
    retailStore.count();
    return statsFromRetailStore(retName, retailStore);
  }

  public RetailStoreCityServiceCenterRequest statsFromRetailStore(
      String retName, RetailStoreRequest retailStore) {
    return addDynamicProperty(retName, retailStore, RetailStore.CITY_SERVICE_CENTER_PROPERTY);
  }

  public RetailStoreCityServiceCenterRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreCityServiceCenterRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreCityServiceCenterRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreCityServiceCenterRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
