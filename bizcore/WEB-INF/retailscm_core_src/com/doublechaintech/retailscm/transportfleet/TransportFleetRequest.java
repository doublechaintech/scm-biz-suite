package com.doublechaintech.retailscm.transportfleet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;
import com.doublechaintech.retailscm.transporttruck.TransportTruckRequest;
import com.doublechaintech.retailscm.truckdriver.TruckDriverRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.transportfleet.TransportFleet.*;

public class TransportFleetRequest extends BaseRequest<TransportFleet> {
  public static TransportFleetRequest newInstance() {
    return new TransportFleetRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public TransportFleetRequest resultByClass(Class<? extends TransportFleet> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public TransportFleetRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public TransportFleetRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "TransportFleet";
  }

  public TransportFleetRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public TransportFleetRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public TransportFleetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public TransportFleetRequest select(String... names) {
    super.select(names);
    return this;
  }

  public TransportFleetRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectContactNumber()
        .selectOwner()
        .selectContract()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public TransportFleetRequest selectAny() {
    return selectAll()
        .selectTransportTruckList(Q.transportTruck().selectSelf())
        .selectTruckDriverList(Q.truckDriver().selectSelf())
        .selectTransportTaskList(Q.transportTask().selectSelf());
  }

  public TransportFleetRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(CONTACT_NUMBER_PROPERTY);
    select(OWNER_PROPERTY);
    select(CONTRACT_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public TransportFleetRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public TransportFleetRequest where(
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
    CONTACT_NUMBER_PROPERTY,
    OWNER_PROPERTY,
    CONTRACT_PROPERTY,
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

  public TransportFleetRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public TransportFleetRequest comment(String comment) {
    return this;
  }

  public TransportFleetRequest enhance() {
    return this;
  }

  public TransportFleetRequest overrideClass(Class<? extends TransportFleet> clazz) {
    return this;
  }

  public TransportFleetRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public TransportFleetRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public TransportFleetRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public TransportFleetRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public TransportFleetRequest count() {
    return countId("count");
  }

  public static TransportFleetRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public TransportFleetRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public TransportFleetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest selectId() {
    return select(ID_PROPERTY);
  }

  public TransportFleetRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportFleetRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public TransportFleetRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public TransportFleetRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public TransportFleetRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public TransportFleetRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public TransportFleetRequest countId() {
    return countId("countId");
  }

  public TransportFleetRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public TransportFleetRequest maxId() {
    return maxId("maxId");
  }

  public TransportFleetRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public TransportFleetRequest minId() {
    return minId("minId");
  }

  public TransportFleetRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public TransportFleetRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public TransportFleetRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public TransportFleetRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public TransportFleetRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public TransportFleetRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public TransportFleetRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportFleetRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportFleetRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public TransportFleetRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportFleetRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public TransportFleetRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public TransportFleetRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public TransportFleetRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public TransportFleetRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public TransportFleetRequest countName() {
    return countName("countName");
  }

  public TransportFleetRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public TransportFleetRequest maxName() {
    return maxName("maxName");
  }

  public TransportFleetRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public TransportFleetRequest minName() {
    return minName("minName");
  }

  public TransportFleetRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public TransportFleetRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public TransportFleetRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public TransportFleetRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public TransportFleetRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public TransportFleetRequest filterByContactNumber(String contactNumber) {

    if (contactNumber == null) {
      return this;
    }

    return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
  }

  public TransportFleetRequest whereContactNumberIsNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportFleetRequest whereContactNumberIsNotNull() {
    return where(CONTACT_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportFleetRequest filterByContactNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest selectContactNumber() {
    return select(CONTACT_NUMBER_PROPERTY);
  }

  public TransportFleetRequest unselectContactNumber() {
    return unselect(CONTACT_NUMBER_PROPERTY);
  }

  public SearchCriteria getContactNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportFleetRequest orderByContactNumber(boolean asc) {
    addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
    return this;
  }

  public TransportFleetRequest orderByContactNumberAscending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, true);
    return this;
  }

  public TransportFleetRequest orderByContactNumberDescending() {
    addOrderBy(CONTACT_NUMBER_PROPERTY, false);
    return this;
  }

  public TransportFleetRequest orderByContactNumberAscendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", true);
    return this;
  }

  public TransportFleetRequest orderByContactNumberDescendingUsingGBK() {
    addOrderBy("convert(contactNumber using gbk)", false);
    return this;
  }

  public TransportFleetRequest countContactNumber() {
    return countContactNumber("countContactNumber");
  }

  public TransportFleetRequest countContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_NUMBER_PROPERTY);
  }

  public TransportFleetRequest maxContactNumber() {
    return maxContactNumber("maxContactNumber");
  }

  public TransportFleetRequest maxContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_NUMBER_PROPERTY);
  }

  public TransportFleetRequest minContactNumber() {
    return minContactNumber("minContactNumber");
  }

  public TransportFleetRequest minContactNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_NUMBER_PROPERTY);
  }

  public TransportFleetRequest groupByContactNumber() {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY);
  }

  public TransportFleetRequest groupByContactNumber(String ret) {
    return groupBy(ret, CONTACT_NUMBER_PROPERTY);
  }

  public TransportFleetRequest groupByContactNumber(SqlFunction func) {
    return groupByContactNumber(CONTACT_NUMBER_PROPERTY, func);
  }

  public TransportFleetRequest groupByContactNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_NUMBER_PROPERTY);
    return this;
  }

  public TransportFleetRequest filterByContract(String contract) {

    if (contract == null) {
      return this;
    }

    return filterByContract(QueryOperator.EQUAL, contract);
  }

  public TransportFleetRequest whereContractIsNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportFleetRequest whereContractIsNotNull() {
    return where(CONTRACT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportFleetRequest filterByContract(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest selectContract() {
    return select(CONTRACT_PROPERTY);
  }

  public TransportFleetRequest unselectContract() {
    return unselect(CONTRACT_PROPERTY);
  }

  public SearchCriteria getContractSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportFleetRequest orderByContract(boolean asc) {
    addOrderBy(CONTRACT_PROPERTY, asc);
    return this;
  }

  public TransportFleetRequest orderByContractAscending() {
    addOrderBy(CONTRACT_PROPERTY, true);
    return this;
  }

  public TransportFleetRequest orderByContractDescending() {
    addOrderBy(CONTRACT_PROPERTY, false);
    return this;
  }

  public TransportFleetRequest orderByContractAscendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", true);
    return this;
  }

  public TransportFleetRequest orderByContractDescendingUsingGBK() {
    addOrderBy("convert(contract using gbk)", false);
    return this;
  }

  public TransportFleetRequest countContract() {
    return countContract("countContract");
  }

  public TransportFleetRequest countContract(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTRACT_PROPERTY);
  }

  public TransportFleetRequest maxContract() {
    return maxContract("maxContract");
  }

  public TransportFleetRequest maxContract(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTRACT_PROPERTY);
  }

  public TransportFleetRequest minContract() {
    return minContract("minContract");
  }

  public TransportFleetRequest minContract(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTRACT_PROPERTY);
  }

  public TransportFleetRequest groupByContract() {
    return groupByContract(CONTRACT_PROPERTY);
  }

  public TransportFleetRequest groupByContract(String ret) {
    return groupBy(ret, CONTRACT_PROPERTY);
  }

  public TransportFleetRequest groupByContract(SqlFunction func) {
    return groupByContract(CONTRACT_PROPERTY, func);
  }

  public TransportFleetRequest groupByContract(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTRACT_PROPERTY);
    return this;
  }

  public TransportFleetRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public TransportFleetRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportFleetRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportFleetRequest whereLastUpdateTimeBetween(
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

  public TransportFleetRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public TransportFleetRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportFleetRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public TransportFleetRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public TransportFleetRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public TransportFleetRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public TransportFleetRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public TransportFleetRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public TransportFleetRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public TransportFleetRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public TransportFleetRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public TransportFleetRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public TransportFleetRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public TransportFleetRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public TransportFleetRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public TransportFleetRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public TransportFleetRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportFleetRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportFleetRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public TransportFleetRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public TransportFleetRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public TransportFleetRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public TransportFleetRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public TransportFleetRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public TransportFleetRequest countVersion() {
    return countVersion("countVersion");
  }

  public TransportFleetRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public TransportFleetRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public TransportFleetRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public TransportFleetRequest minVersion() {
    return minVersion("minVersion");
  }

  public TransportFleetRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public TransportFleetRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public TransportFleetRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public TransportFleetRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public TransportFleetRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public TransportFleetRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public TransportFleetRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public TransportFleetRequest filterByOwner(RetailStoreCountryCenterRequest owner) {
    return filterByOwner(owner, RetailStoreCountryCenter::getId);
  }

  public TransportFleetRequest filterByOwner(RetailStoreCountryCenter... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(RetailStoreCountryCenter... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public TransportFleetRequest selectOwnerId() {
    select(OWNER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToOwner() {
    return upToOwner(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToOwner(RetailStoreCountryCenterRequest owner) {
    owner.aggregateChild(OWNER_PROPERTY, this);
    this.groupByOwner(owner);
    return owner;
  }

  public RetailStoreCountryCenterRequest endAtOwner(String retName) {
    return endAtOwner(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtOwner(
      String retName, RetailStoreCountryCenterRequest owner) {
    owner.addDynamicProperty(retName, this, OWNER_PROPERTY);
    return owner;
  }

  public TransportFleetRequest filterByOwner(String... owner) {
    if (isEmptyParam(owner)) {
      throw new IllegalArgumentException("filterByOwner(String... owner)参数不能为空!");
    }
    return where(OWNER_PROPERTY, QueryOperator.IN, (Object[]) owner);
  }

  public TransportFleetRequest filterByOwner(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    owner.unlimited();
    return addSearchCriteria(createOwnerCriteria(owner, idRefine));
  }

  public SearchCriteria createOwnerCriteria(
      RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        owner, OWNER_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public TransportFleetRequest selectOwner() {
    return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public TransportFleetRequest selectOwner(RetailStoreCountryCenterRequest owner) {
    selectParent(OWNER_PROPERTY, owner);
    return this;
  }

  public TransportFleetRequest unselectOwner() {
    unselectParent(OWNER_PROPERTY);
    return this;
  }

  public TransportFleetRequest groupByOwner(RetailStoreCountryCenterRequest owner) {
    groupBy(OWNER_PROPERTY, owner);
    return this;
  }

  public TransportFleetRequest aggregateOwner(RetailStoreCountryCenterRequest owner) {
    aggregateParent(OWNER_PROPERTY, owner);
    return this;
  }

  public TransportFleetRequest countOwner() {
    return countOwner("countOwner");
  }

  public TransportFleetRequest countOwner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OWNER_PROPERTY);
  }

  public TransportFleetRequest groupByOwner() {
    return groupByOwner(OWNER_PROPERTY);
  }

  public TransportFleetRequest groupByOwner(String ret) {
    return groupBy(ret, OWNER_PROPERTY);
  }

  public TransportFleetRequest whereOwnerIsNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public TransportFleetRequest whereOwnerIsNotNull() {
    return where(OWNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public TransportFleetRequest hasTransportTruck() {
    return hasTransportTruck(TransportTruckRequest.newInstance());
  }

  public TransportFleetRequest hasTransportTruck(TransportTruck... transportTruck) {
    if (isEmptyParam(transportTruck)) {
      throw new IllegalArgumentException(
          "hasTransportTruck(TransportTruck... transportTruck)参数不能为空!");
    }
    return hasTransportTruck(
        Q.transportTruck()
            .select(TransportTruck.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) transportTruck));
  }

  public TransportFleetRequest hasTransportTruck(String... transportTruck) {
    return hasTransportTruck(
        Q.transportTruck().select(TransportTruck.OWNER_PROPERTY).filterById(transportTruck));
  }

  public TransportFleetRequest hasTransportTruck(TransportTruckRequest transportTruck) {
    return hasTransportTruck(
        transportTruck,
        $transportTruck ->
            java.util.Optional.of($transportTruck)
                .map(TransportTruck::getOwner)
                .map(TransportFleet::getId)
                .orElse(null));
  }

  public TransportFleetRequest hasTransportTruck(
      TransportTruckRequest transportTruck, IDRefine<TransportTruck> idRefine) {
    transportTruck.select(TransportTruck.OWNER_PROPERTY);
    transportTruck.unlimited();
    return addSearchCriteria(createTransportTruckCriteria(transportTruck, idRefine));
  }

  public TransportFleetRequest hasTransportTruck(
      TransportTruckRequest transportTruck, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            transportTruck, TransportTruck.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTransportTruckCriteria(
      TransportTruckRequest transportTruck, IDRefine<TransportTruck> idRefine) {
    return new RefinedIdInCriteria(
        transportTruck, ID_PROPERTY, idRefine, TransportTruck.OWNER_PROPERTY);
  }

  public TransportFleetRequest selectTransportTruckList(TransportTruckRequest transportTruck) {
    selectChild(TransportTruck.OWNER_PROPERTY, transportTruck);
    return this;
  }

  public TransportFleetRequest selectTransportTruckList() {
    return selectTransportTruckList(TransportTruckRequest.newInstance().selectAll());
  }

  public TransportFleetRequest unselectTransportTruckList() {
    unselectChild(TransportTruck.OWNER_PROPERTY, TransportTruck.class);
    return this;
  }

  public TransportFleetRequest hasTruckDriver() {
    return hasTruckDriver(TruckDriverRequest.newInstance());
  }

  public TransportFleetRequest hasTruckDriver(TruckDriver... truckDriver) {
    if (isEmptyParam(truckDriver)) {
      throw new IllegalArgumentException("hasTruckDriver(TruckDriver... truckDriver)参数不能为空!");
    }
    return hasTruckDriver(
        Q.truckDriver()
            .select(TruckDriver.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) truckDriver));
  }

  public TransportFleetRequest hasTruckDriver(String... truckDriver) {
    return hasTruckDriver(
        Q.truckDriver().select(TruckDriver.BELONGS_TO_PROPERTY).filterById(truckDriver));
  }

  public TransportFleetRequest hasTruckDriver(TruckDriverRequest truckDriver) {
    return hasTruckDriver(
        truckDriver,
        $truckDriver ->
            java.util.Optional.of($truckDriver)
                .map(TruckDriver::getBelongsTo)
                .map(TransportFleet::getId)
                .orElse(null));
  }

  public TransportFleetRequest hasTruckDriver(
      TruckDriverRequest truckDriver, IDRefine<TruckDriver> idRefine) {
    truckDriver.select(TruckDriver.BELONGS_TO_PROPERTY);
    truckDriver.unlimited();
    return addSearchCriteria(createTruckDriverCriteria(truckDriver, idRefine));
  }

  public TransportFleetRequest hasTruckDriver(
      TruckDriverRequest truckDriver, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            truckDriver, TruckDriver.BELONGS_TO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTruckDriverCriteria(
      TruckDriverRequest truckDriver, IDRefine<TruckDriver> idRefine) {
    return new RefinedIdInCriteria(
        truckDriver, ID_PROPERTY, idRefine, TruckDriver.BELONGS_TO_PROPERTY);
  }

  public TransportFleetRequest selectTruckDriverList(TruckDriverRequest truckDriver) {
    selectChild(TruckDriver.BELONGS_TO_PROPERTY, truckDriver);
    return this;
  }

  public TransportFleetRequest selectTruckDriverList() {
    return selectTruckDriverList(TruckDriverRequest.newInstance().selectAll());
  }

  public TransportFleetRequest unselectTruckDriverList() {
    unselectChild(TruckDriver.BELONGS_TO_PROPERTY, TruckDriver.class);
    return this;
  }

  public TransportFleetRequest hasTransportTask() {
    return hasTransportTask(TransportTaskRequest.newInstance());
  }

  public TransportFleetRequest hasTransportTask(TransportTask... transportTask) {
    if (isEmptyParam(transportTask)) {
      throw new IllegalArgumentException("hasTransportTask(TransportTask... transportTask)参数不能为空!");
    }
    return hasTransportTask(
        Q.transportTask()
            .select(TransportTask.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) transportTask));
  }

  public TransportFleetRequest hasTransportTask(String... transportTask) {
    return hasTransportTask(
        Q.transportTask().select(TransportTask.BELONGS_TO_PROPERTY).filterById(transportTask));
  }

  public TransportFleetRequest hasTransportTask(TransportTaskRequest transportTask) {
    return hasTransportTask(
        transportTask,
        $transportTask ->
            java.util.Optional.of($transportTask)
                .map(TransportTask::getBelongsTo)
                .map(TransportFleet::getId)
                .orElse(null));
  }

  public TransportFleetRequest hasTransportTask(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    transportTask.select(TransportTask.BELONGS_TO_PROPERTY);
    transportTask.unlimited();
    return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
  }

  public TransportFleetRequest hasTransportTask(
      TransportTaskRequest transportTask, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            transportTask, TransportTask.BELONGS_TO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTransportTaskCriteria(
      TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
    return new RefinedIdInCriteria(
        transportTask, ID_PROPERTY, idRefine, TransportTask.BELONGS_TO_PROPERTY);
  }

  public TransportFleetRequest selectTransportTaskList(TransportTaskRequest transportTask) {
    selectChild(TransportTask.BELONGS_TO_PROPERTY, transportTask);
    return this;
  }

  public TransportFleetRequest selectTransportTaskList() {
    return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
  }

  public TransportFleetRequest unselectTransportTaskList() {
    unselectChild(TransportTask.BELONGS_TO_PROPERTY, TransportTask.class);
    return this;
  }

  public TransportFleetRequest aggregateTransportTruckList(TransportTruckRequest transportTruck) {
    aggregateChild(TransportTruck.OWNER_PROPERTY, transportTruck);
    return this;
  }

  public TransportFleetRequest countTransportTruck() {
    return countTransportTruck("transportTruckCount");
  }

  public TransportFleetRequest countTransportTruck(String retName) {
    return countTransportTruck(retName, TransportTruckRequest.newInstance());
  }

  public TransportFleetRequest countTransportTruck(TransportTruckRequest transportTruck) {
    return countTransportTruck("transportTruckCount", transportTruck);
  }

  public TransportFleetRequest countTransportTruck(
      String retName, TransportTruckRequest transportTruck) {
    transportTruck.count();
    return statsFromTransportTruck(retName, transportTruck);
  }

  public TransportFleetRequest statsFromTransportTruck(
      String retName, TransportTruckRequest transportTruck) {
    return addDynamicProperty(retName, transportTruck, TransportTruck.OWNER_PROPERTY);
  }

  public TransportFleetRequest aggregateTruckDriverList(TruckDriverRequest truckDriver) {
    aggregateChild(TruckDriver.BELONGS_TO_PROPERTY, truckDriver);
    return this;
  }

  public TransportFleetRequest countTruckDriver() {
    return countTruckDriver("truckDriverCount");
  }

  public TransportFleetRequest countTruckDriver(String retName) {
    return countTruckDriver(retName, TruckDriverRequest.newInstance());
  }

  public TransportFleetRequest countTruckDriver(TruckDriverRequest truckDriver) {
    return countTruckDriver("truckDriverCount", truckDriver);
  }

  public TransportFleetRequest countTruckDriver(String retName, TruckDriverRequest truckDriver) {
    truckDriver.count();
    return statsFromTruckDriver(retName, truckDriver);
  }

  public TransportFleetRequest statsFromTruckDriver(
      String retName, TruckDriverRequest truckDriver) {
    return addDynamicProperty(retName, truckDriver, TruckDriver.BELONGS_TO_PROPERTY);
  }

  public TransportFleetRequest aggregateTransportTaskList(TransportTaskRequest transportTask) {
    aggregateChild(TransportTask.BELONGS_TO_PROPERTY, transportTask);
    return this;
  }

  public TransportFleetRequest countTransportTask() {
    return countTransportTask("transportTaskCount");
  }

  public TransportFleetRequest countTransportTask(String retName) {
    return countTransportTask(retName, TransportTaskRequest.newInstance());
  }

  public TransportFleetRequest countTransportTask(TransportTaskRequest transportTask) {
    return countTransportTask("transportTaskCount", transportTask);
  }

  public TransportFleetRequest countTransportTask(
      String retName, TransportTaskRequest transportTask) {
    transportTask.count();
    return statsFromTransportTask(retName, transportTask);
  }

  public TransportFleetRequest statsFromTransportTask(
      String retName, TransportTaskRequest transportTask) {
    return addDynamicProperty(retName, transportTask, TransportTask.BELONGS_TO_PROPERTY);
  }

  public TransportFleetRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public TransportFleetRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public TransportFleetRequest unlimited() {
    super.unlimited();
    return this;
  }

  public TransportFleetRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
