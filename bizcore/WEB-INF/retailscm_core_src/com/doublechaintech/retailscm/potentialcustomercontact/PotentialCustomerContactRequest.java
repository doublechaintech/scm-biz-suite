package com.doublechaintech.retailscm.potentialcustomercontact;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;

import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;
import com.doublechaintech.retailscm.citypartner.CityPartnerRequest;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact.*;

public class PotentialCustomerContactRequest extends BaseRequest<PotentialCustomerContact> {
  public static PotentialCustomerContactRequest newInstance() {
    return new PotentialCustomerContactRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PotentialCustomerContactRequest resultByClass(
      Class<? extends PotentialCustomerContact> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PotentialCustomerContactRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PotentialCustomerContactRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "PotentialCustomerContact";
  }

  public PotentialCustomerContactRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PotentialCustomerContactRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PotentialCustomerContactRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PotentialCustomerContactRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PotentialCustomerContactRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectContactDate()
        .selectContactMethod()
        .selectPotentialCustomer()
        .selectCityPartner()
        .selectContactTo()
        .selectDescription()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public PotentialCustomerContactRequest selectAny() {
    return selectAll();
  }

  public PotentialCustomerContactRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(CONTACT_DATE_PROPERTY);
    select(CONTACT_METHOD_PROPERTY);
    select(POTENTIAL_CUSTOMER_PROPERTY);
    select(CITY_PARTNER_PROPERTY);
    select(CONTACT_TO_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PotentialCustomerContactRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PotentialCustomerContactRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {
    CONTACT_DATE_PROPERTY, LAST_UPDATE_TIME_PROPERTY
  };
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    CONTACT_DATE_PROPERTY,
    CONTACT_METHOD_PROPERTY,
    POTENTIAL_CUSTOMER_PROPERTY,
    CITY_PARTNER_PROPERTY,
    CONTACT_TO_PROPERTY,
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

  public PotentialCustomerContactRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PotentialCustomerContactRequest comment(String comment) {
    return this;
  }

  public PotentialCustomerContactRequest enhance() {
    return this;
  }

  public PotentialCustomerContactRequest overrideClass(
      Class<? extends PotentialCustomerContact> clazz) {
    return this;
  }

  public PotentialCustomerContactRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PotentialCustomerContactRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PotentialCustomerContactRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PotentialCustomerContactRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PotentialCustomerContactRequest count() {
    return countId("count");
  }

  public static PotentialCustomerContactRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public PotentialCustomerContactRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PotentialCustomerContactRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PotentialCustomerContactRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PotentialCustomerContactRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PotentialCustomerContactRequest countId() {
    return countId("countId");
  }

  public PotentialCustomerContactRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PotentialCustomerContactRequest maxId() {
    return maxId("maxId");
  }

  public PotentialCustomerContactRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PotentialCustomerContactRequest minId() {
    return minId("minId");
  }

  public PotentialCustomerContactRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PotentialCustomerContactRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PotentialCustomerContactRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PotentialCustomerContactRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PotentialCustomerContactRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public PotentialCustomerContactRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public PotentialCustomerContactRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public PotentialCustomerContactRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public PotentialCustomerContactRequest countName() {
    return countName("countName");
  }

  public PotentialCustomerContactRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public PotentialCustomerContactRequest maxName() {
    return maxName("maxName");
  }

  public PotentialCustomerContactRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public PotentialCustomerContactRequest minName() {
    return minName("minName");
  }

  public PotentialCustomerContactRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public PotentialCustomerContactRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest filterByContactDate(Date contactDate) {

    if (contactDate == null) {
      return this;
    }

    return filterByContactDate(QueryOperator.EQUAL, contactDate);
  }

  public PotentialCustomerContactRequest whereContactDateIsNull() {
    return where(CONTACT_DATE_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereContactDateIsNotNull() {
    return where(CONTACT_DATE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest whereContactDateBetween(
      Date contactDateStart, Date contactDateEnd) {
    if (ObjectUtil.isEmpty(contactDateStart)) {
      throw new IllegalArgumentException(
          "Method whereContactDateBetween, the parameter contactDateStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(contactDateEnd)) {
      throw new IllegalArgumentException(
          "Method whereContactDateBetween, the parameter contactDateEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getContactDateSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {contactDateStart, contactDateEnd});
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest whereContactDateBefore(Date contactDate) {

    if (ObjectUtil.isEmpty(contactDate)) {
      throw new IllegalArgumentException(
          "Method whereContactDateBefore, the parameter contactDate is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getContactDateSearchCriteria(QueryOperator.LESS_THAN, new Object[] {contactDate});
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest whereContactDateAfter(Date contactDate) {
    if (ObjectUtil.isEmpty(contactDate)) {
      throw new IllegalArgumentException(
          "Method whereContactDateAfter, the parameter contactDate is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getContactDateSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {contactDate});
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest filterByContactDate(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactDateSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest selectContactDate() {
    return select(CONTACT_DATE_PROPERTY);
  }

  public PotentialCustomerContactRequest unselectContactDate() {
    return unselect(CONTACT_DATE_PROPERTY);
  }

  public SearchCriteria getContactDateSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_DATE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactRequest orderByContactDate(boolean asc) {
    addOrderBy(CONTACT_DATE_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactRequest orderByContactDateAscending() {
    addOrderBy(CONTACT_DATE_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactRequest orderByContactDateDescending() {
    addOrderBy(CONTACT_DATE_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactRequest countContactDate() {
    return countContactDate("countContactDate");
  }

  public PotentialCustomerContactRequest countContactDate(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_DATE_PROPERTY);
  }

  public PotentialCustomerContactRequest maxContactDate() {
    return maxContactDate("maxContactDate");
  }

  public PotentialCustomerContactRequest maxContactDate(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_DATE_PROPERTY);
  }

  public PotentialCustomerContactRequest minContactDate() {
    return minContactDate("minContactDate");
  }

  public PotentialCustomerContactRequest minContactDate(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_DATE_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactDate() {
    return groupByContactDate(CONTACT_DATE_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactDate(String ret) {
    return groupBy(ret, CONTACT_DATE_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactDate(SqlFunction func) {
    return groupByContactDate(CONTACT_DATE_PROPERTY, func);
  }

  public PotentialCustomerContactRequest groupByContactDate(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_DATE_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest filterByContactMethod(String contactMethod) {

    if (contactMethod == null) {
      return this;
    }

    return filterByContactMethod(QueryOperator.EQUAL, contactMethod);
  }

  public PotentialCustomerContactRequest whereContactMethodIsNull() {
    return where(CONTACT_METHOD_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereContactMethodIsNotNull() {
    return where(CONTACT_METHOD_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest filterByContactMethod(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getContactMethodSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest selectContactMethod() {
    return select(CONTACT_METHOD_PROPERTY);
  }

  public PotentialCustomerContactRequest unselectContactMethod() {
    return unselect(CONTACT_METHOD_PROPERTY);
  }

  public SearchCriteria getContactMethodSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CONTACT_METHOD_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactRequest orderByContactMethod(boolean asc) {
    addOrderBy(CONTACT_METHOD_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactRequest orderByContactMethodAscending() {
    addOrderBy(CONTACT_METHOD_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactRequest orderByContactMethodDescending() {
    addOrderBy(CONTACT_METHOD_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactRequest orderByContactMethodAscendingUsingGBK() {
    addOrderBy("convert(contactMethod using gbk)", true);
    return this;
  }

  public PotentialCustomerContactRequest orderByContactMethodDescendingUsingGBK() {
    addOrderBy("convert(contactMethod using gbk)", false);
    return this;
  }

  public PotentialCustomerContactRequest countContactMethod() {
    return countContactMethod("countContactMethod");
  }

  public PotentialCustomerContactRequest countContactMethod(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_METHOD_PROPERTY);
  }

  public PotentialCustomerContactRequest maxContactMethod() {
    return maxContactMethod("maxContactMethod");
  }

  public PotentialCustomerContactRequest maxContactMethod(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CONTACT_METHOD_PROPERTY);
  }

  public PotentialCustomerContactRequest minContactMethod() {
    return minContactMethod("minContactMethod");
  }

  public PotentialCustomerContactRequest minContactMethod(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CONTACT_METHOD_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactMethod() {
    return groupByContactMethod(CONTACT_METHOD_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactMethod(String ret) {
    return groupBy(ret, CONTACT_METHOD_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactMethod(SqlFunction func) {
    return groupByContactMethod(CONTACT_METHOD_PROPERTY, func);
  }

  public PotentialCustomerContactRequest groupByContactMethod(String ret, SqlFunction func) {
    super.groupBy(ret, func, CONTACT_METHOD_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public PotentialCustomerContactRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public PotentialCustomerContactRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public PotentialCustomerContactRequest countDescription() {
    return countDescription("countDescription");
  }

  public PotentialCustomerContactRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public PotentialCustomerContactRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactRequest minDescription() {
    return minDescription("minDescription");
  }

  public PotentialCustomerContactRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public PotentialCustomerContactRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public PotentialCustomerContactRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest whereLastUpdateTimeBetween(
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

  public PotentialCustomerContactRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerContactRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public PotentialCustomerContactRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerContactRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public PotentialCustomerContactRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerContactRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public PotentialCustomerContactRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public PotentialCustomerContactRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PotentialCustomerContactRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PotentialCustomerContactRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactRequest countVersion() {
    return countVersion("countVersion");
  }

  public PotentialCustomerContactRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PotentialCustomerContactRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PotentialCustomerContactRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PotentialCustomerContactRequest minVersion() {
    return minVersion("minVersion");
  }

  public PotentialCustomerContactRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PotentialCustomerContactRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PotentialCustomerContactRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PotentialCustomerContactRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest filterByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    return filterByPotentialCustomer(potentialCustomer, PotentialCustomer::getId);
  }

  public PotentialCustomerContactRequest filterByPotentialCustomer(
      PotentialCustomer... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "filterByPotentialCustomer(PotentialCustomer... potentialCustomer)参数不能为空!");
    }
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IN, (Object[]) potentialCustomer);
  }

  public PotentialCustomerContactRequest selectPotentialCustomerId() {
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

  public PotentialCustomerContactRequest filterByPotentialCustomer(String... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "filterByPotentialCustomer(String... potentialCustomer)参数不能为空!");
    }
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IN, (Object[]) potentialCustomer);
  }

  public PotentialCustomerContactRequest filterByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    potentialCustomer.unlimited();
    return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
  }

  public SearchCriteria createPotentialCustomerCriteria(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    return new RefinedIdInCriteria(
        potentialCustomer, POTENTIAL_CUSTOMER_PROPERTY, idRefine, PotentialCustomer.ID_PROPERTY);
  }

  public PotentialCustomerContactRequest selectPotentialCustomer() {
    return selectPotentialCustomer(PotentialCustomerRequest.newInstance().selectSelf());
  }

  public PotentialCustomerContactRequest selectPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    selectParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public PotentialCustomerContactRequest unselectPotentialCustomer() {
    unselectParent(POTENTIAL_CUSTOMER_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest groupByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    groupBy(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public PotentialCustomerContactRequest aggregatePotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    aggregateParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public PotentialCustomerContactRequest countPotentialCustomer() {
    return countPotentialCustomer("countPotentialCustomer");
  }

  public PotentialCustomerContactRequest countPotentialCustomer(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByPotentialCustomer() {
    return groupByPotentialCustomer(POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByPotentialCustomer(String ret) {
    return groupBy(ret, POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerContactRequest wherePotentialCustomerIsNull() {
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest wherePotentialCustomerIsNotNull() {
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest filterByCityPartner(CityPartnerRequest cityPartner) {
    return filterByCityPartner(cityPartner, CityPartner::getId);
  }

  public PotentialCustomerContactRequest filterByCityPartner(CityPartner... cityPartner) {
    if (isEmptyParam(cityPartner)) {
      throw new IllegalArgumentException("filterByCityPartner(CityPartner... cityPartner)参数不能为空!");
    }
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IN, (Object[]) cityPartner);
  }

  public PotentialCustomerContactRequest selectCityPartnerId() {
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

  public PotentialCustomerContactRequest filterByCityPartner(String... cityPartner) {
    if (isEmptyParam(cityPartner)) {
      throw new IllegalArgumentException("filterByCityPartner(String... cityPartner)参数不能为空!");
    }
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IN, (Object[]) cityPartner);
  }

  public PotentialCustomerContactRequest filterByCityPartner(
      CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
    cityPartner.unlimited();
    return addSearchCriteria(createCityPartnerCriteria(cityPartner, idRefine));
  }

  public SearchCriteria createCityPartnerCriteria(
      CityPartnerRequest cityPartner, IDRefine<CityPartner> idRefine) {
    return new RefinedIdInCriteria(
        cityPartner, CITY_PARTNER_PROPERTY, idRefine, CityPartner.ID_PROPERTY);
  }

  public PotentialCustomerContactRequest selectCityPartner() {
    return selectCityPartner(CityPartnerRequest.newInstance().selectSelf());
  }

  public PotentialCustomerContactRequest selectCityPartner(CityPartnerRequest cityPartner) {
    selectParent(CITY_PARTNER_PROPERTY, cityPartner);
    return this;
  }

  public PotentialCustomerContactRequest unselectCityPartner() {
    unselectParent(CITY_PARTNER_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest groupByCityPartner(CityPartnerRequest cityPartner) {
    groupBy(CITY_PARTNER_PROPERTY, cityPartner);
    return this;
  }

  public PotentialCustomerContactRequest aggregateCityPartner(CityPartnerRequest cityPartner) {
    aggregateParent(CITY_PARTNER_PROPERTY, cityPartner);
    return this;
  }

  public PotentialCustomerContactRequest countCityPartner() {
    return countCityPartner("countCityPartner");
  }

  public PotentialCustomerContactRequest countCityPartner(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CITY_PARTNER_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByCityPartner() {
    return groupByCityPartner(CITY_PARTNER_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByCityPartner(String ret) {
    return groupBy(ret, CITY_PARTNER_PROPERTY);
  }

  public PotentialCustomerContactRequest whereCityPartnerIsNull() {
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereCityPartnerIsNotNull() {
    return where(CITY_PARTNER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest filterByContactTo(
      PotentialCustomerContactPersonRequest contactTo) {
    return filterByContactTo(contactTo, PotentialCustomerContactPerson::getId);
  }

  public PotentialCustomerContactRequest filterByContactTo(
      PotentialCustomerContactPerson... contactTo) {
    if (isEmptyParam(contactTo)) {
      throw new IllegalArgumentException(
          "filterByContactTo(PotentialCustomerContactPerson... contactTo)参数不能为空!");
    }
    return where(CONTACT_TO_PROPERTY, QueryOperator.IN, (Object[]) contactTo);
  }

  public PotentialCustomerContactRequest selectContactToId() {
    select(CONTACT_TO_PROPERTY);
    return this;
  }

  public PotentialCustomerContactPersonRequest upToContactTo() {
    return upToContactTo(PotentialCustomerContactPersonRequest.newInstance());
  }

  public PotentialCustomerContactPersonRequest upToContactTo(
      PotentialCustomerContactPersonRequest contactTo) {
    contactTo.aggregateChild(CONTACT_TO_PROPERTY, this);
    this.groupByContactTo(contactTo);
    return contactTo;
  }

  public PotentialCustomerContactPersonRequest endAtContactTo(String retName) {
    return endAtContactTo(retName, PotentialCustomerContactPersonRequest.newInstance());
  }

  public PotentialCustomerContactPersonRequest endAtContactTo(
      String retName, PotentialCustomerContactPersonRequest contactTo) {
    contactTo.addDynamicProperty(retName, this, CONTACT_TO_PROPERTY);
    return contactTo;
  }

  public PotentialCustomerContactRequest filterByContactTo(String... contactTo) {
    if (isEmptyParam(contactTo)) {
      throw new IllegalArgumentException("filterByContactTo(String... contactTo)参数不能为空!");
    }
    return where(CONTACT_TO_PROPERTY, QueryOperator.IN, (Object[]) contactTo);
  }

  public PotentialCustomerContactRequest filterByContactTo(
      PotentialCustomerContactPersonRequest contactTo,
      IDRefine<PotentialCustomerContactPerson> idRefine) {
    contactTo.unlimited();
    return addSearchCriteria(createContactToCriteria(contactTo, idRefine));
  }

  public SearchCriteria createContactToCriteria(
      PotentialCustomerContactPersonRequest contactTo,
      IDRefine<PotentialCustomerContactPerson> idRefine) {
    return new RefinedIdInCriteria(
        contactTo, CONTACT_TO_PROPERTY, idRefine, PotentialCustomerContactPerson.ID_PROPERTY);
  }

  public PotentialCustomerContactRequest selectContactTo() {
    return selectContactTo(PotentialCustomerContactPersonRequest.newInstance().selectSelf());
  }

  public PotentialCustomerContactRequest selectContactTo(
      PotentialCustomerContactPersonRequest contactTo) {
    selectParent(CONTACT_TO_PROPERTY, contactTo);
    return this;
  }

  public PotentialCustomerContactRequest unselectContactTo() {
    unselectParent(CONTACT_TO_PROPERTY);
    return this;
  }

  public PotentialCustomerContactRequest groupByContactTo(
      PotentialCustomerContactPersonRequest contactTo) {
    groupBy(CONTACT_TO_PROPERTY, contactTo);
    return this;
  }

  public PotentialCustomerContactRequest aggregateContactTo(
      PotentialCustomerContactPersonRequest contactTo) {
    aggregateParent(CONTACT_TO_PROPERTY, contactTo);
    return this;
  }

  public PotentialCustomerContactRequest countContactTo() {
    return countContactTo("countContactTo");
  }

  public PotentialCustomerContactRequest countContactTo(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CONTACT_TO_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactTo() {
    return groupByContactTo(CONTACT_TO_PROPERTY);
  }

  public PotentialCustomerContactRequest groupByContactTo(String ret) {
    return groupBy(ret, CONTACT_TO_PROPERTY);
  }

  public PotentialCustomerContactRequest whereContactToIsNull() {
    return where(CONTACT_TO_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactRequest whereContactToIsNotNull() {
    return where(CONTACT_TO_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PotentialCustomerContactRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PotentialCustomerContactRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PotentialCustomerContactRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
