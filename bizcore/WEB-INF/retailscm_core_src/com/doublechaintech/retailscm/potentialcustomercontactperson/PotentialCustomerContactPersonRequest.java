package com.doublechaintech.retailscm.potentialcustomercontactperson;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerRequest;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson.*;

public class PotentialCustomerContactPersonRequest
    extends BaseRequest<PotentialCustomerContactPerson> {
  public static PotentialCustomerContactPersonRequest newInstance() {
    return new PotentialCustomerContactPersonRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public PotentialCustomerContactPersonRequest resultByClass(
      Class<? extends PotentialCustomerContactPerson> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public PotentialCustomerContactPersonRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public PotentialCustomerContactPersonRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "PotentialCustomerContactPerson";
  }

  public PotentialCustomerContactPersonRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public PotentialCustomerContactPersonRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public PotentialCustomerContactPersonRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public PotentialCustomerContactPersonRequest select(String... names) {
    super.select(names);
    return this;
  }

  public PotentialCustomerContactPersonRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectMobile()
        .selectPotentialCustomer()
        .selectDescription()
        .selectVersion();
  }

  public PotentialCustomerContactPersonRequest selectAny() {
    return selectAll()
        .selectPotentialCustomerContactList(Q.potentialCustomerContact().selectSelf());
  }

  public PotentialCustomerContactPersonRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(MOBILE_PROPERTY);
    select(POTENTIAL_CUSTOMER_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public PotentialCustomerContactPersonRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public PotentialCustomerContactPersonRequest where(
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
    MOBILE_PROPERTY,
    POTENTIAL_CUSTOMER_PROPERTY,
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

  public PotentialCustomerContactPersonRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public PotentialCustomerContactPersonRequest comment(String comment) {
    return this;
  }

  public PotentialCustomerContactPersonRequest enhance() {
    return this;
  }

  public PotentialCustomerContactPersonRequest overrideClass(
      Class<? extends PotentialCustomerContactPerson> clazz) {
    return this;
  }

  public PotentialCustomerContactPersonRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public PotentialCustomerContactPersonRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public PotentialCustomerContactPersonRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public PotentialCustomerContactPersonRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public PotentialCustomerContactPersonRequest count() {
    return countId("count");
  }

  public static PotentialCustomerContactPersonRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public PotentialCustomerContactPersonRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public PotentialCustomerContactPersonRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactPersonRequest selectId() {
    return select(ID_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactPersonRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public PotentialCustomerContactPersonRequest countId() {
    return countId("countId");
  }

  public PotentialCustomerContactPersonRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest maxId() {
    return maxId("maxId");
  }

  public PotentialCustomerContactPersonRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest minId() {
    return minId("minId");
  }

  public PotentialCustomerContactPersonRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public PotentialCustomerContactPersonRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public PotentialCustomerContactPersonRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public PotentialCustomerContactPersonRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactPersonRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactPersonRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactPersonRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactPersonRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public PotentialCustomerContactPersonRequest countName() {
    return countName("countName");
  }

  public PotentialCustomerContactPersonRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest maxName() {
    return maxName("maxName");
  }

  public PotentialCustomerContactPersonRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest minName() {
    return minName("minName");
  }

  public PotentialCustomerContactPersonRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public PotentialCustomerContactPersonRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public PotentialCustomerContactPersonRequest filterByMobile(String mobile) {

    if (mobile == null) {
      return this;
    }

    return filterByMobile(QueryOperator.EQUAL, mobile);
  }

  public PotentialCustomerContactPersonRequest whereMobileIsNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactPersonRequest whereMobileIsNotNull() {
    return where(MOBILE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactPersonRequest filterByMobile(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getMobileSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactPersonRequest selectMobile() {
    return select(MOBILE_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest unselectMobile() {
    return unselect(MOBILE_PROPERTY);
  }

  public SearchCriteria getMobileSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(MOBILE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactPersonRequest orderByMobile(boolean asc) {
    addOrderBy(MOBILE_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByMobileAscending() {
    addOrderBy(MOBILE_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByMobileDescending() {
    addOrderBy(MOBILE_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByMobileAscendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByMobileDescendingUsingGBK() {
    addOrderBy("convert(mobile using gbk)", false);
    return this;
  }

  public PotentialCustomerContactPersonRequest countMobile() {
    return countMobile("countMobile");
  }

  public PotentialCustomerContactPersonRequest countMobile(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, MOBILE_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest maxMobile() {
    return maxMobile("maxMobile");
  }

  public PotentialCustomerContactPersonRequest maxMobile(String aggName) {
    return aggregate(aggName, AggFunc.MAX, MOBILE_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest minMobile() {
    return minMobile("minMobile");
  }

  public PotentialCustomerContactPersonRequest minMobile(String aggName) {
    return aggregate(aggName, AggFunc.MIN, MOBILE_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByMobile() {
    return groupByMobile(MOBILE_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByMobile(String ret) {
    return groupBy(ret, MOBILE_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByMobile(SqlFunction func) {
    return groupByMobile(MOBILE_PROPERTY, func);
  }

  public PotentialCustomerContactPersonRequest groupByMobile(String ret, SqlFunction func) {
    super.groupBy(ret, func, MOBILE_PROPERTY);
    return this;
  }

  public PotentialCustomerContactPersonRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public PotentialCustomerContactPersonRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactPersonRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactPersonRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactPersonRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactPersonRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public PotentialCustomerContactPersonRequest countDescription() {
    return countDescription("countDescription");
  }

  public PotentialCustomerContactPersonRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public PotentialCustomerContactPersonRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest minDescription() {
    return minDescription("minDescription");
  }

  public PotentialCustomerContactPersonRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public PotentialCustomerContactPersonRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public PotentialCustomerContactPersonRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public PotentialCustomerContactPersonRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactPersonRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactPersonRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public PotentialCustomerContactPersonRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public PotentialCustomerContactPersonRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public PotentialCustomerContactPersonRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public PotentialCustomerContactPersonRequest countVersion() {
    return countVersion("countVersion");
  }

  public PotentialCustomerContactPersonRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public PotentialCustomerContactPersonRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest minVersion() {
    return minVersion("minVersion");
  }

  public PotentialCustomerContactPersonRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public PotentialCustomerContactPersonRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public PotentialCustomerContactPersonRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public PotentialCustomerContactPersonRequest filterByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    return filterByPotentialCustomer(potentialCustomer, PotentialCustomer::getId);
  }

  public PotentialCustomerContactPersonRequest filterByPotentialCustomer(
      PotentialCustomer... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "filterByPotentialCustomer(PotentialCustomer... potentialCustomer)参数不能为空!");
    }
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IN, (Object[]) potentialCustomer);
  }

  public PotentialCustomerContactPersonRequest selectPotentialCustomerId() {
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

  public PotentialCustomerContactPersonRequest filterByPotentialCustomer(
      String... potentialCustomer) {
    if (isEmptyParam(potentialCustomer)) {
      throw new IllegalArgumentException(
          "filterByPotentialCustomer(String... potentialCustomer)参数不能为空!");
    }
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IN, (Object[]) potentialCustomer);
  }

  public PotentialCustomerContactPersonRequest filterByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    potentialCustomer.unlimited();
    return addSearchCriteria(createPotentialCustomerCriteria(potentialCustomer, idRefine));
  }

  public SearchCriteria createPotentialCustomerCriteria(
      PotentialCustomerRequest potentialCustomer, IDRefine<PotentialCustomer> idRefine) {
    return new RefinedIdInCriteria(
        potentialCustomer, POTENTIAL_CUSTOMER_PROPERTY, idRefine, PotentialCustomer.ID_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest selectPotentialCustomer() {
    return selectPotentialCustomer(PotentialCustomerRequest.newInstance().selectSelf());
  }

  public PotentialCustomerContactPersonRequest selectPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    selectParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public PotentialCustomerContactPersonRequest unselectPotentialCustomer() {
    unselectParent(POTENTIAL_CUSTOMER_PROPERTY);
    return this;
  }

  public PotentialCustomerContactPersonRequest groupByPotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    groupBy(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public PotentialCustomerContactPersonRequest aggregatePotentialCustomer(
      PotentialCustomerRequest potentialCustomer) {
    aggregateParent(POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer);
    return this;
  }

  public PotentialCustomerContactPersonRequest countPotentialCustomer() {
    return countPotentialCustomer("countPotentialCustomer");
  }

  public PotentialCustomerContactPersonRequest countPotentialCustomer(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByPotentialCustomer() {
    return groupByPotentialCustomer(POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest groupByPotentialCustomer(String ret) {
    return groupBy(ret, POTENTIAL_CUSTOMER_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest wherePotentialCustomerIsNull() {
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IS_NULL);
  }

  public PotentialCustomerContactPersonRequest wherePotentialCustomerIsNotNull() {
    return where(POTENTIAL_CUSTOMER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public PotentialCustomerContactPersonRequest hasPotentialCustomerContact() {
    return hasPotentialCustomerContact(PotentialCustomerContactRequest.newInstance());
  }

  public PotentialCustomerContactPersonRequest hasPotentialCustomerContact(
      PotentialCustomerContact... potentialCustomerContact) {
    if (isEmptyParam(potentialCustomerContact)) {
      throw new IllegalArgumentException(
          "hasPotentialCustomerContact(PotentialCustomerContact... potentialCustomerContact)参数不能为空!");
    }
    return hasPotentialCustomerContact(
        Q.potentialCustomerContact()
            .select(PotentialCustomerContact.CONTACT_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) potentialCustomerContact));
  }

  public PotentialCustomerContactPersonRequest hasPotentialCustomerContact(
      String... potentialCustomerContact) {
    return hasPotentialCustomerContact(
        Q.potentialCustomerContact()
            .select(PotentialCustomerContact.CONTACT_TO_PROPERTY)
            .filterById(potentialCustomerContact));
  }

  public PotentialCustomerContactPersonRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact) {
    return hasPotentialCustomerContact(
        potentialCustomerContact,
        $potentialCustomerContact ->
            java.util.Optional.of($potentialCustomerContact)
                .map(PotentialCustomerContact::getContactTo)
                .map(PotentialCustomerContactPerson::getId)
                .orElse(null));
  }

  public PotentialCustomerContactPersonRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact,
      IDRefine<PotentialCustomerContact> idRefine) {
    potentialCustomerContact.select(PotentialCustomerContact.CONTACT_TO_PROPERTY);
    potentialCustomerContact.unlimited();
    return addSearchCriteria(
        createPotentialCustomerContactCriteria(potentialCustomerContact, idRefine));
  }

  public PotentialCustomerContactPersonRequest hasPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            potentialCustomerContact,
            PotentialCustomerContact.CONTACT_TO_PROPERTY,
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
        PotentialCustomerContact.CONTACT_TO_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest selectPotentialCustomerContactList(
      PotentialCustomerContactRequest potentialCustomerContact) {
    selectChild(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContact);
    return this;
  }

  public PotentialCustomerContactPersonRequest selectPotentialCustomerContactList() {
    return selectPotentialCustomerContactList(
        PotentialCustomerContactRequest.newInstance().selectAll());
  }

  public PotentialCustomerContactPersonRequest unselectPotentialCustomerContactList() {
    unselectChild(PotentialCustomerContact.CONTACT_TO_PROPERTY, PotentialCustomerContact.class);
    return this;
  }

  public PotentialCustomerContactPersonRequest aggregatePotentialCustomerContactList(
      PotentialCustomerContactRequest potentialCustomerContact) {
    aggregateChild(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContact);
    return this;
  }

  public PotentialCustomerContactPersonRequest countPotentialCustomerContact() {
    return countPotentialCustomerContact("potentialCustomerContactCount");
  }

  public PotentialCustomerContactPersonRequest countPotentialCustomerContact(String retName) {
    return countPotentialCustomerContact(retName, PotentialCustomerContactRequest.newInstance());
  }

  public PotentialCustomerContactPersonRequest countPotentialCustomerContact(
      PotentialCustomerContactRequest potentialCustomerContact) {
    return countPotentialCustomerContact("potentialCustomerContactCount", potentialCustomerContact);
  }

  public PotentialCustomerContactPersonRequest countPotentialCustomerContact(
      String retName, PotentialCustomerContactRequest potentialCustomerContact) {
    potentialCustomerContact.count();
    return statsFromPotentialCustomerContact(retName, potentialCustomerContact);
  }

  public PotentialCustomerContactPersonRequest statsFromPotentialCustomerContact(
      String retName, PotentialCustomerContactRequest potentialCustomerContact) {
    return addDynamicProperty(
        retName, potentialCustomerContact, PotentialCustomerContact.CONTACT_TO_PROPERTY);
  }

  public PotentialCustomerContactPersonRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public PotentialCustomerContactPersonRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public PotentialCustomerContactPersonRequest unlimited() {
    super.unlimited();
    return this;
  }

  public PotentialCustomerContactPersonRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
