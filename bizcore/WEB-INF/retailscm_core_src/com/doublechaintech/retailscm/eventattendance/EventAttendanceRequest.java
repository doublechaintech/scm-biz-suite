package com.doublechaintech.retailscm.eventattendance;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEventRequest;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.eventattendance.EventAttendance.*;

public class EventAttendanceRequest extends BaseRequest<EventAttendance> {
  public static EventAttendanceRequest newInstance() {
    return new EventAttendanceRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EventAttendanceRequest resultByClass(Class<? extends EventAttendance> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EventAttendanceRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EventAttendanceRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EventAttendance";
  }

  public EventAttendanceRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EventAttendanceRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EventAttendanceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EventAttendanceRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EventAttendanceRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectPotentialCustomer()
        .selectCityEvent()
        .selectDescription()
        .selectVersion();
  }

  public EventAttendanceRequest selectAny() {
    return selectAll();
  }

  public EventAttendanceRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(POTENTIAL_CUSTOMER_PROPERTY);
    select(CITY_EVENT_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EventAttendanceRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EventAttendanceRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    POTENTIAL_CUSTOMER_PROPERTY,
    CITY_EVENT_PROPERTY,
    DESCRIPTION_PROPERTY,
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

  public EventAttendanceRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EventAttendanceRequest comment(String comment) {
    return this;
  }

  public EventAttendanceRequest enhance() {
    return this;
  }

  public EventAttendanceRequest overrideClass(Class<? extends EventAttendance> clazz) {
    return this;
  }

  public EventAttendanceRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EventAttendanceRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EventAttendanceRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EventAttendanceRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EventAttendanceRequest count() {
    return countId("count");
  }

  public static EventAttendanceRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EventAttendanceRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EventAttendanceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EventAttendanceRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EventAttendanceRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EventAttendanceRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EventAttendanceRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EventAttendanceRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EventAttendanceRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EventAttendanceRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EventAttendanceRequest countId() {
    return countId("countId");
  }

  public EventAttendanceRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EventAttendanceRequest maxId() {
    return maxId("maxId");
  }

  public EventAttendanceRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EventAttendanceRequest minId() {
    return minId("minId");
  }

  public EventAttendanceRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EventAttendanceRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EventAttendanceRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EventAttendanceRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EventAttendanceRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EventAttendanceRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public EventAttendanceRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public EventAttendanceRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EventAttendanceRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EventAttendanceRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public EventAttendanceRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EventAttendanceRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public EventAttendanceRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public EventAttendanceRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public EventAttendanceRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public EventAttendanceRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public EventAttendanceRequest countName() {
    return countName("countName");
  }

  public EventAttendanceRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public EventAttendanceRequest maxName() {
    return maxName("maxName");
  }

  public EventAttendanceRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public EventAttendanceRequest minName() {
    return minName("minName");
  }

  public EventAttendanceRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public EventAttendanceRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public EventAttendanceRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public EventAttendanceRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public EventAttendanceRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public EventAttendanceRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public EventAttendanceRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EventAttendanceRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EventAttendanceRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EventAttendanceRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public EventAttendanceRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EventAttendanceRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public EventAttendanceRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public EventAttendanceRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public EventAttendanceRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public EventAttendanceRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public EventAttendanceRequest countDescription() {
    return countDescription("countDescription");
  }

  public EventAttendanceRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public EventAttendanceRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public EventAttendanceRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public EventAttendanceRequest minDescription() {
    return minDescription("minDescription");
  }

  public EventAttendanceRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public EventAttendanceRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public EventAttendanceRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public EventAttendanceRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public EventAttendanceRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public EventAttendanceRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EventAttendanceRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EventAttendanceRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EventAttendanceRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EventAttendanceRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EventAttendanceRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EventAttendanceRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EventAttendanceRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EventAttendanceRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EventAttendanceRequest countVersion() {
    return countVersion("countVersion");
  }

  public EventAttendanceRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EventAttendanceRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EventAttendanceRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EventAttendanceRequest minVersion() {
    return minVersion("minVersion");
  }

  public EventAttendanceRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EventAttendanceRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EventAttendanceRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EventAttendanceRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EventAttendanceRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EventAttendanceRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EventAttendanceRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EventAttendanceRequest filterByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    return filterByPotentialCustomer(potentialCustomer, PotentialCustomer::getId);
  }

  public EventAttendanceRequest filterByPotentialCustomer(PotentialCustomer... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "filterByPotentialCustomer(PotentialCustomer... potentialCustomer)参数不能为空!");
    }
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IN, (Object[]) potentialCustomer);
  }

  public EventAttendanceRequest selectPotentialCustomerId() {
    select(POTENTIAL_CUSTOMER_PROPERTY);
    return this;
  }

  public PotentialCustomerRequest upToPotentialCustomer() {
    return upToPotentialCustomer(PotentialCustomerRequest.newInstance());
  }

  public PotentialCustomerRequest upToPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    potentialCustomer.aggregateChild(POTENTIAL_CUSTOMER_PROPERTY, this);
    this.groupByPotentialCustomer(potentialCustomer);
    return potentialCustomer;
  }

  public PotentialCustomerRequest endAtPotentialCustomer(String retName) {
    return endAtPotentialCustomer(retName, PotentialCustomerRequest.newInstance());
  }

  public PotentialCustomerRequest endAtPotentialCustomer(
      String retName, PotentialCustomerRequest potentialCustomer) {
    potentialCustomer.addDynamicProperty(retName, this, POTENTIAL_CUSTOMER_PROPERTY);
    return potentialCustomer;
  }

  public EventAttendanceRequest filterByPotentialCustomer(String... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "filterByPotentialCustomer(String... potentialCustomer)参数不能为空!");
    }
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IN, (Object[]) potentialCustomer);
  }

  public EventAttendanceRequest filterByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    potentialCustomer.unlimited();
    return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
  }

  public SearchCriteria createPotentialCustomerCriteria(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    return new RefinedIdInCriteria(
        potentialCustomer, POTENTIAL_CUSTOMER_PROPERTY, idRefine, PotentialCustomer.ID_PROPERTY);
  }

  public EventAttendanceRequest selectPotentialCustomer() {
    return selectPotentialCustomer(PotentialCustomerRequest.newInstance().selectSelf());
  }

  public EventAttendanceRequest selectPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    selectParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public EventAttendanceRequest unselectPotentialCustomer() {
    unselectParent(POTENTIAL_CUSTOMER_PROPERTY);
    return this;
  }

  public EventAttendanceRequest groupByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    groupBy(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public EventAttendanceRequest aggregatePotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    aggregateParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public EventAttendanceRequest countPotentialCustomer() {
    return countPotentialCustomer("countPotentialCustomer");
  }

  public EventAttendanceRequest countPotentialCustomer(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, POTENTIAL_CUSTOMER_PROPERTY);
  }

  public EventAttendanceRequest groupByPotentialCustomer() {
    return groupByPotentialCustomer(POTENTIAL_CUSTOMER_PROPERTY);
  }

  public EventAttendanceRequest groupByPotentialCustomer(String ret) {
    return groupBy(ret, POTENTIAL_CUSTOMER_PROPERTY);
  }

  public EventAttendanceRequest wherePotentialCustomerIsNull() {
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IS_NULL);
  }

  public EventAttendanceRequest wherePotentialCustomerIsNotNull() {
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EventAttendanceRequest filterByCityEvent(CityEventRequest cityEvent) {
    return filterByCityEvent(cityEvent, CityEvent::getId);
  }

  public EventAttendanceRequest filterByCityEvent(CityEvent... cityEvent) {
    if (isEmptyParam(cityEvent)) {
      throw new IllegalArgumentException("filterByCityEvent(CityEvent... cityEvent)参数不能为空!");
    }
    return where(CITY_EVENT_PROPERTY, QueryOperator.IN, (Object[]) cityEvent);
  }

  public EventAttendanceRequest selectCityEventId() {
    select(CITY_EVENT_PROPERTY);
    return this;
  }

  public CityEventRequest upToCityEvent() {
    return upToCityEvent(CityEventRequest.newInstance());
  }

  public CityEventRequest upToCityEvent(CityEventRequest cityEvent) {
    cityEvent.aggregateChild(CITY_EVENT_PROPERTY, this);
    this.groupByCityEvent(cityEvent);
    return cityEvent;
  }

  public CityEventRequest endAtCityEvent(String retName) {
    return endAtCityEvent(retName, CityEventRequest.newInstance());
  }

  public CityEventRequest endAtCityEvent(String retName, CityEventRequest cityEvent) {
    cityEvent.addDynamicProperty(retName, this, CITY_EVENT_PROPERTY);
    return cityEvent;
  }

  public EventAttendanceRequest filterByCityEvent(String... cityEvent) {
    if (isEmptyParam(cityEvent)) {
      throw new IllegalArgumentException("filterByCityEvent(String... cityEvent)参数不能为空!");
    }
    return where(CITY_EVENT_PROPERTY, QueryOperator.IN, (Object[]) cityEvent);
  }

  public EventAttendanceRequest filterByCityEvent(
      CityEventRequest cityEvent, IDRefine<CityEvent> idRefine) {
    cityEvent.unlimited();
    return addSearchCriteria(createCityEventCriteria(cityEvent, idRefine));
  }

  public SearchCriteria createCityEventCriteria(
      CityEventRequest cityEvent, IDRefine<CityEvent> idRefine) {
    return new RefinedIdInCriteria(cityEvent, CITY_EVENT_PROPERTY, idRefine, CityEvent.ID_PROPERTY);
  }

  public EventAttendanceRequest selectCityEvent() {
    return selectCityEvent(CityEventRequest.newInstance().selectSelf());
  }

  public EventAttendanceRequest selectCityEvent(CityEventRequest cityEvent) {
    selectParent(CITY_EVENT_PROPERTY, cityEvent);
    return this;
  }

  public EventAttendanceRequest unselectCityEvent() {
    unselectParent(CITY_EVENT_PROPERTY);
    return this;
  }

  public EventAttendanceRequest groupByCityEvent(CityEventRequest cityEvent) {
    groupBy(CITY_EVENT_PROPERTY, cityEvent);
    return this;
  }

  public EventAttendanceRequest aggregateCityEvent(CityEventRequest cityEvent) {
    aggregateParent(CITY_EVENT_PROPERTY, cityEvent);
    return this;
  }

  public EventAttendanceRequest countCityEvent() {
    return countCityEvent("countCityEvent");
  }

  public EventAttendanceRequest countCityEvent(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_EVENT_PROPERTY);
  }

  public EventAttendanceRequest groupByCityEvent() {
    return groupByCityEvent(CITY_EVENT_PROPERTY);
  }

  public EventAttendanceRequest groupByCityEvent(String ret) {
    return groupBy(ret, CITY_EVENT_PROPERTY);
  }

  public EventAttendanceRequest whereCityEventIsNull() {
    return where(CITY_EVENT_PROPERTY, QueryOperator.IS_NULL);
  }

  public EventAttendanceRequest whereCityEventIsNotNull() {
    return where(CITY_EVENT_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EventAttendanceRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EventAttendanceRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EventAttendanceRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EventAttendanceRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
