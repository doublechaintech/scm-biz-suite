package com.doublechaintech.retailscm.retailstorecountrycenter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.util.Date;

import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import com.doublechaintech.retailscm.catalog.CatalogRequest;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.instructor.InstructorRequest;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest;
import com.doublechaintech.retailscm.leavetype.LeaveTypeRequest;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest;
import com.doublechaintech.retailscm.publicholiday.PublicHolidayRequest;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest;
import com.doublechaintech.retailscm.skilltype.SkillTypeRequest;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter.*;

public class RetailStoreCountryCenterRequest extends BaseRequest<RetailStoreCountryCenter> {
  public static RetailStoreCountryCenterRequest newInstance() {
    return new RetailStoreCountryCenterRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public RetailStoreCountryCenterRequest resultByClass(
      Class<? extends RetailStoreCountryCenter> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public RetailStoreCountryCenterRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public RetailStoreCountryCenterRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "RetailStoreCountryCenter";
  }

  public RetailStoreCountryCenterRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public RetailStoreCountryCenterRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public RetailStoreCountryCenterRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public RetailStoreCountryCenterRequest select(String... names) {
    super.select(names);
    return this;
  }

  public RetailStoreCountryCenterRequest selectAll() {
    return this.selectId()
        .selectName()
        .selectServiceNumber()
        .selectFounded()
        .selectWebSite()
        .selectAddress()
        .selectOperatedBy()
        .selectLegalRepresentative()
        .selectDescription()
        .selectVersion();
  }

  public RetailStoreCountryCenterRequest selectAny() {
    return selectAll()
        .selectCatalogList(Q.catalog().selectSelf())
        .selectRetailStoreProvinceCenterList(Q.retailStoreProvinceCenter().selectSelf())
        .selectRetailStoreList(Q.retailStore().selectSelf())
        .selectRetailStoreMemberList(Q.retailStoreMember().selectSelf())
        .selectGoodsSupplierList(Q.goodsSupplier().selectSelf())
        .selectSupplyOrderList(Q.supplyOrder().selectSelf())
        .selectRetailStoreOrderList(Q.retailStoreOrder().selectSelf())
        .selectWarehouseList(Q.warehouse().selectSelf())
        .selectTransportFleetList(Q.transportFleet().selectSelf())
        .selectAccountSetList(Q.accountSet().selectSelf())
        .selectLevelOneDepartmentList(Q.levelOneDepartment().selectSelf())
        .selectSkillTypeList(Q.skillType().selectSelf())
        .selectResponsibilityTypeList(Q.responsibilityType().selectSelf())
        .selectTerminationReasonList(Q.terminationReason().selectSelf())
        .selectTerminationTypeList(Q.terminationType().selectSelf())
        .selectOccupationTypeList(Q.occupationType().selectSelf())
        .selectLeaveTypeList(Q.leaveType().selectSelf())
        .selectSalaryGradeList(Q.salaryGrade().selectSelf())
        .selectInterviewTypeList(Q.interviewType().selectSelf())
        .selectTrainingCourseTypeList(Q.trainingCourseType().selectSelf())
        .selectPublicHolidayList(Q.publicHoliday().selectSelf())
        .selectEmployeeList(Q.employee().selectSelf())
        .selectInstructorList(Q.instructor().selectSelf())
        .selectCompanyTrainingList(Q.companyTraining().selectSelf());
  }

  public RetailStoreCountryCenterRequest selectSelf() {
    select(ID_PROPERTY);
    select(NAME_PROPERTY);
    select(SERVICE_NUMBER_PROPERTY);
    select(FOUNDED_PROPERTY);
    select(WEB_SITE_PROPERTY);
    select(ADDRESS_PROPERTY);
    select(OPERATED_BY_PROPERTY);
    select(LEGAL_REPRESENTATIVE_PROPERTY);
    select(DESCRIPTION_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public RetailStoreCountryCenterRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public RetailStoreCountryCenterRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {FOUNDED_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    NAME_PROPERTY,
    SERVICE_NUMBER_PROPERTY,
    FOUNDED_PROPERTY,
    WEB_SITE_PROPERTY,
    ADDRESS_PROPERTY,
    OPERATED_BY_PROPERTY,
    LEGAL_REPRESENTATIVE_PROPERTY,
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

  public RetailStoreCountryCenterRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public RetailStoreCountryCenterRequest comment(String comment) {
    return this;
  }

  public RetailStoreCountryCenterRequest enhance() {
    return this;
  }

  public RetailStoreCountryCenterRequest overrideClass(
      Class<? extends RetailStoreCountryCenter> clazz) {
    return this;
  }

  public RetailStoreCountryCenterRequest aggregate(
      String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public RetailStoreCountryCenterRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public RetailStoreCountryCenterRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public RetailStoreCountryCenterRequest groupBy(
      String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public RetailStoreCountryCenterRequest count() {
    return countId("count");
  }

  public static RetailStoreCountryCenterRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public RetailStoreCountryCenterRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public RetailStoreCountryCenterRequest filterById(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectId() {
    return select(ID_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countId() {
    return countId("countId");
  }

  public RetailStoreCountryCenterRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxId() {
    return maxId("maxId");
  }

  public RetailStoreCountryCenterRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minId() {
    return minId("minId");
  }

  public RetailStoreCountryCenterRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByName(String name) {

    if (name == null) {
      return this;
    }

    return filterByName(QueryOperator.EQUAL, name);
  }

  public RetailStoreCountryCenterRequest whereNameIsNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereNameIsNotNull() {
    return where(NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByName(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectName() {
    return select(NAME_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectName() {
    return unselect(NAME_PROPERTY);
  }

  public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByName(boolean asc) {
    addOrderBy(NAME_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByNameAscending() {
    addOrderBy(NAME_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByNameDescending() {
    addOrderBy(NAME_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByNameAscendingUsingGBK() {
    addOrderBy("convert(name using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByNameDescendingUsingGBK() {
    addOrderBy("convert(name using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countName() {
    return countName("countName");
  }

  public RetailStoreCountryCenterRequest countName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, NAME_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxName() {
    return maxName("maxName");
  }

  public RetailStoreCountryCenterRequest maxName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, NAME_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minName() {
    return minName("minName");
  }

  public RetailStoreCountryCenterRequest minName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, NAME_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByName() {
    return groupByName(NAME_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByName(String ret) {
    return groupBy(ret, NAME_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByName(SqlFunction func) {
    return groupByName(NAME_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByName(String ret, SqlFunction func) {
    super.groupBy(ret, func, NAME_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByServiceNumber(String serviceNumber) {

    if (serviceNumber == null) {
      return this;
    }

    return filterByServiceNumber(QueryOperator.EQUAL, serviceNumber);
  }

  public RetailStoreCountryCenterRequest whereServiceNumberIsNull() {
    return where(SERVICE_NUMBER_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereServiceNumberIsNotNull() {
    return where(SERVICE_NUMBER_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByServiceNumber(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getServiceNumberSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectServiceNumber() {
    return select(SERVICE_NUMBER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectServiceNumber() {
    return unselect(SERVICE_NUMBER_PROPERTY);
  }

  public SearchCriteria getServiceNumberSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SERVICE_NUMBER_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByServiceNumber(boolean asc) {
    addOrderBy(SERVICE_NUMBER_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByServiceNumberAscending() {
    addOrderBy(SERVICE_NUMBER_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByServiceNumberDescending() {
    addOrderBy(SERVICE_NUMBER_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByServiceNumberAscendingUsingGBK() {
    addOrderBy("convert(serviceNumber using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByServiceNumberDescendingUsingGBK() {
    addOrderBy("convert(serviceNumber using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countServiceNumber() {
    return countServiceNumber("countServiceNumber");
  }

  public RetailStoreCountryCenterRequest countServiceNumber(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SERVICE_NUMBER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxServiceNumber() {
    return maxServiceNumber("maxServiceNumber");
  }

  public RetailStoreCountryCenterRequest maxServiceNumber(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SERVICE_NUMBER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minServiceNumber() {
    return minServiceNumber("minServiceNumber");
  }

  public RetailStoreCountryCenterRequest minServiceNumber(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SERVICE_NUMBER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByServiceNumber() {
    return groupByServiceNumber(SERVICE_NUMBER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByServiceNumber(String ret) {
    return groupBy(ret, SERVICE_NUMBER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByServiceNumber(SqlFunction func) {
    return groupByServiceNumber(SERVICE_NUMBER_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByServiceNumber(String ret, SqlFunction func) {
    super.groupBy(ret, func, SERVICE_NUMBER_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByFounded(Date founded) {

    if (founded == null) {
      return this;
    }

    return filterByFounded(QueryOperator.EQUAL, founded);
  }

  public RetailStoreCountryCenterRequest whereFoundedIsNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereFoundedIsNotNull() {
    return where(FOUNDED_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest whereFoundedBetween(Date foundedStart, Date foundedEnd) {
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

  public RetailStoreCountryCenterRequest whereFoundedBefore(Date founded) {

    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedBefore, the parameter founded is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.LESS_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest whereFoundedAfter(Date founded) {
    if (ObjectUtil.isEmpty(founded)) {
      throw new IllegalArgumentException(
          "Method whereFoundedAfter, the parameter founded is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getFoundedSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {founded});
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest filterByFounded(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectFounded() {
    return select(FOUNDED_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectFounded() {
    return unselect(FOUNDED_PROPERTY);
  }

  public SearchCriteria getFoundedSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByFounded(boolean asc) {
    addOrderBy(FOUNDED_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByFoundedAscending() {
    addOrderBy(FOUNDED_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByFoundedDescending() {
    addOrderBy(FOUNDED_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest countFounded() {
    return countFounded("countFounded");
  }

  public RetailStoreCountryCenterRequest countFounded(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FOUNDED_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxFounded() {
    return maxFounded("maxFounded");
  }

  public RetailStoreCountryCenterRequest maxFounded(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FOUNDED_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minFounded() {
    return minFounded("minFounded");
  }

  public RetailStoreCountryCenterRequest minFounded(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FOUNDED_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByFounded() {
    return groupByFounded(FOUNDED_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByFounded(String ret) {
    return groupBy(ret, FOUNDED_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByFounded(SqlFunction func) {
    return groupByFounded(FOUNDED_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByFounded(String ret, SqlFunction func) {
    super.groupBy(ret, func, FOUNDED_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByWebSite(String webSite) {

    if (webSite == null) {
      return this;
    }

    return filterByWebSite(QueryOperator.EQUAL, webSite);
  }

  public RetailStoreCountryCenterRequest whereWebSiteIsNull() {
    return where(WEB_SITE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereWebSiteIsNotNull() {
    return where(WEB_SITE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByWebSite(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getWebSiteSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectWebSite() {
    return select(WEB_SITE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectWebSite() {
    return unselect(WEB_SITE_PROPERTY);
  }

  public SearchCriteria getWebSiteSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(WEB_SITE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByWebSite(boolean asc) {
    addOrderBy(WEB_SITE_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByWebSiteAscending() {
    addOrderBy(WEB_SITE_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByWebSiteDescending() {
    addOrderBy(WEB_SITE_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByWebSiteAscendingUsingGBK() {
    addOrderBy("convert(webSite using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByWebSiteDescendingUsingGBK() {
    addOrderBy("convert(webSite using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countWebSite() {
    return countWebSite("countWebSite");
  }

  public RetailStoreCountryCenterRequest countWebSite(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, WEB_SITE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxWebSite() {
    return maxWebSite("maxWebSite");
  }

  public RetailStoreCountryCenterRequest maxWebSite(String aggName) {
    return aggregate(aggName, AggFunc.MAX, WEB_SITE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minWebSite() {
    return minWebSite("minWebSite");
  }

  public RetailStoreCountryCenterRequest minWebSite(String aggName) {
    return aggregate(aggName, AggFunc.MIN, WEB_SITE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByWebSite() {
    return groupByWebSite(WEB_SITE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByWebSite(String ret) {
    return groupBy(ret, WEB_SITE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByWebSite(SqlFunction func) {
    return groupByWebSite(WEB_SITE_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByWebSite(String ret, SqlFunction func) {
    super.groupBy(ret, func, WEB_SITE_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByAddress(String address) {

    if (address == null) {
      return this;
    }

    return filterByAddress(QueryOperator.EQUAL, address);
  }

  public RetailStoreCountryCenterRequest whereAddressIsNull() {
    return where(ADDRESS_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereAddressIsNotNull() {
    return where(ADDRESS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByAddress(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getAddressSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectAddress() {
    return select(ADDRESS_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectAddress() {
    return unselect(ADDRESS_PROPERTY);
  }

  public SearchCriteria getAddressSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ADDRESS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByAddress(boolean asc) {
    addOrderBy(ADDRESS_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByAddressAscending() {
    addOrderBy(ADDRESS_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByAddressDescending() {
    addOrderBy(ADDRESS_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByAddressAscendingUsingGBK() {
    addOrderBy("convert(address using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByAddressDescendingUsingGBK() {
    addOrderBy("convert(address using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countAddress() {
    return countAddress("countAddress");
  }

  public RetailStoreCountryCenterRequest countAddress(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ADDRESS_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxAddress() {
    return maxAddress("maxAddress");
  }

  public RetailStoreCountryCenterRequest maxAddress(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ADDRESS_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minAddress() {
    return minAddress("minAddress");
  }

  public RetailStoreCountryCenterRequest minAddress(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ADDRESS_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByAddress() {
    return groupByAddress(ADDRESS_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByAddress(String ret) {
    return groupBy(ret, ADDRESS_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByAddress(SqlFunction func) {
    return groupByAddress(ADDRESS_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByAddress(String ret, SqlFunction func) {
    super.groupBy(ret, func, ADDRESS_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByOperatedBy(String operatedBy) {

    if (operatedBy == null) {
      return this;
    }

    return filterByOperatedBy(QueryOperator.EQUAL, operatedBy);
  }

  public RetailStoreCountryCenterRequest whereOperatedByIsNull() {
    return where(OPERATED_BY_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereOperatedByIsNotNull() {
    return where(OPERATED_BY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByOperatedBy(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getOperatedBySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectOperatedBy() {
    return select(OPERATED_BY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectOperatedBy() {
    return unselect(OPERATED_BY_PROPERTY);
  }

  public SearchCriteria getOperatedBySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(OPERATED_BY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByOperatedBy(boolean asc) {
    addOrderBy(OPERATED_BY_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByOperatedByAscending() {
    addOrderBy(OPERATED_BY_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByOperatedByDescending() {
    addOrderBy(OPERATED_BY_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByOperatedByAscendingUsingGBK() {
    addOrderBy("convert(operatedBy using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByOperatedByDescendingUsingGBK() {
    addOrderBy("convert(operatedBy using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countOperatedBy() {
    return countOperatedBy("countOperatedBy");
  }

  public RetailStoreCountryCenterRequest countOperatedBy(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, OPERATED_BY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxOperatedBy() {
    return maxOperatedBy("maxOperatedBy");
  }

  public RetailStoreCountryCenterRequest maxOperatedBy(String aggName) {
    return aggregate(aggName, AggFunc.MAX, OPERATED_BY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minOperatedBy() {
    return minOperatedBy("minOperatedBy");
  }

  public RetailStoreCountryCenterRequest minOperatedBy(String aggName) {
    return aggregate(aggName, AggFunc.MIN, OPERATED_BY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByOperatedBy() {
    return groupByOperatedBy(OPERATED_BY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByOperatedBy(String ret) {
    return groupBy(ret, OPERATED_BY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByOperatedBy(SqlFunction func) {
    return groupByOperatedBy(OPERATED_BY_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByOperatedBy(String ret, SqlFunction func) {
    super.groupBy(ret, func, OPERATED_BY_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByLegalRepresentative(String legalRepresentative) {

    if (legalRepresentative == null) {
      return this;
    }

    return filterByLegalRepresentative(QueryOperator.EQUAL, legalRepresentative);
  }

  public RetailStoreCountryCenterRequest whereLegalRepresentativeIsNull() {
    return where(LEGAL_REPRESENTATIVE_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereLegalRepresentativeIsNotNull() {
    return where(LEGAL_REPRESENTATIVE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByLegalRepresentative(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria =
        getLegalRepresentativeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectLegalRepresentative() {
    return select(LEGAL_REPRESENTATIVE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectLegalRepresentative() {
    return unselect(LEGAL_REPRESENTATIVE_PROPERTY);
  }

  public SearchCriteria getLegalRepresentativeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LEGAL_REPRESENTATIVE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByLegalRepresentative(boolean asc) {
    addOrderBy(LEGAL_REPRESENTATIVE_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByLegalRepresentativeAscending() {
    addOrderBy(LEGAL_REPRESENTATIVE_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByLegalRepresentativeDescending() {
    addOrderBy(LEGAL_REPRESENTATIVE_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByLegalRepresentativeAscendingUsingGBK() {
    addOrderBy("convert(legalRepresentative using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByLegalRepresentativeDescendingUsingGBK() {
    addOrderBy("convert(legalRepresentative using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countLegalRepresentative() {
    return countLegalRepresentative("countLegalRepresentative");
  }

  public RetailStoreCountryCenterRequest countLegalRepresentative(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LEGAL_REPRESENTATIVE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxLegalRepresentative() {
    return maxLegalRepresentative("maxLegalRepresentative");
  }

  public RetailStoreCountryCenterRequest maxLegalRepresentative(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LEGAL_REPRESENTATIVE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minLegalRepresentative() {
    return minLegalRepresentative("minLegalRepresentative");
  }

  public RetailStoreCountryCenterRequest minLegalRepresentative(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LEGAL_REPRESENTATIVE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByLegalRepresentative() {
    return groupByLegalRepresentative(LEGAL_REPRESENTATIVE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByLegalRepresentative(String ret) {
    return groupBy(ret, LEGAL_REPRESENTATIVE_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByLegalRepresentative(SqlFunction func) {
    return groupByLegalRepresentative(LEGAL_REPRESENTATIVE_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByLegalRepresentative(String ret, SqlFunction func) {
    super.groupBy(ret, func, LEGAL_REPRESENTATIVE_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByDescription(String description) {

    if (description == null) {
      return this;
    }

    return filterByDescription(QueryOperator.EQUAL, description);
  }

  public RetailStoreCountryCenterRequest whereDescriptionIsNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereDescriptionIsNotNull() {
    return where(DESCRIPTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByDescription(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectDescription() {
    return select(DESCRIPTION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectDescription() {
    return unselect(DESCRIPTION_PROPERTY);
  }

  public SearchCriteria getDescriptionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByDescription(boolean asc) {
    addOrderBy(DESCRIPTION_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByDescriptionAscending() {
    addOrderBy(DESCRIPTION_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByDescriptionDescending() {
    addOrderBy(DESCRIPTION_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByDescriptionAscendingUsingGBK() {
    addOrderBy("convert(description using gbk)", true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByDescriptionDescendingUsingGBK() {
    addOrderBy("convert(description using gbk)", false);
    return this;
  }

  public RetailStoreCountryCenterRequest countDescription() {
    return countDescription("countDescription");
  }

  public RetailStoreCountryCenterRequest countDescription(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, DESCRIPTION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxDescription() {
    return maxDescription("maxDescription");
  }

  public RetailStoreCountryCenterRequest maxDescription(String aggName) {
    return aggregate(aggName, AggFunc.MAX, DESCRIPTION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minDescription() {
    return minDescription("minDescription");
  }

  public RetailStoreCountryCenterRequest minDescription(String aggName) {
    return aggregate(aggName, AggFunc.MIN, DESCRIPTION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByDescription() {
    return groupByDescription(DESCRIPTION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByDescription(String ret) {
    return groupBy(ret, DESCRIPTION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByDescription(SqlFunction func) {
    return groupByDescription(DESCRIPTION_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByDescription(String ret, SqlFunction func) {
    super.groupBy(ret, func, DESCRIPTION_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public RetailStoreCountryCenterRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public RetailStoreCountryCenterRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public RetailStoreCountryCenterRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public RetailStoreCountryCenterRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public RetailStoreCountryCenterRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public RetailStoreCountryCenterRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public RetailStoreCountryCenterRequest countVersion() {
    return countVersion("countVersion");
  }

  public RetailStoreCountryCenterRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public RetailStoreCountryCenterRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest minVersion() {
    return minVersion("minVersion");
  }

  public RetailStoreCountryCenterRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public RetailStoreCountryCenterRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public RetailStoreCountryCenterRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public RetailStoreCountryCenterRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest hasCatalog() {
    return hasCatalog(CatalogRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasCatalog(Catalog... catalog) {
    if (isEmptyParam(catalog)) {
      throw new IllegalArgumentException("hasCatalog(Catalog... catalog)参数不能为空!");
    }
    return hasCatalog(
        Q.catalog()
            .select(Catalog.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) catalog));
  }

  public RetailStoreCountryCenterRequest hasCatalog(String... catalog) {
    return hasCatalog(Q.catalog().select(Catalog.OWNER_PROPERTY).filterById(catalog));
  }

  public RetailStoreCountryCenterRequest hasCatalog(CatalogRequest catalog) {
    return hasCatalog(
        catalog,
        $catalog ->
            java.util.Optional.of($catalog)
                .map(Catalog::getOwner)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasCatalog(
      CatalogRequest catalog, IDRefine<Catalog> idRefine) {
    catalog.select(Catalog.OWNER_PROPERTY);
    catalog.unlimited();
    return addSearchCriteria(createCatalogCriteria(catalog, idRefine));
  }

  public RetailStoreCountryCenterRequest hasCatalog(
      CatalogRequest catalog, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(catalog, Catalog.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createCatalogCriteria(CatalogRequest catalog, IDRefine<Catalog> idRefine) {
    return new RefinedIdInCriteria(catalog, ID_PROPERTY, idRefine, Catalog.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectCatalogList(CatalogRequest catalog) {
    selectChild(Catalog.OWNER_PROPERTY, catalog);
    return this;
  }

  public RetailStoreCountryCenterRequest selectCatalogList() {
    return selectCatalogList(CatalogRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectCatalogList() {
    unselectChild(Catalog.OWNER_PROPERTY, Catalog.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter() {
    return hasRetailStoreProvinceCenter(RetailStoreProvinceCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter(
      RetailStoreProvinceCenter... retailStoreProvinceCenter) {
    if (isEmptyParam(retailStoreProvinceCenter)) {
      throw new IllegalArgumentException(
          "hasRetailStoreProvinceCenter(RetailStoreProvinceCenter... retailStoreProvinceCenter)参数不能为空!");
    }
    return hasRetailStoreProvinceCenter(
        Q.retailStoreProvinceCenter()
            .select(RetailStoreProvinceCenter.COUNTRY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreProvinceCenter));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter(
      String... retailStoreProvinceCenter) {
    return hasRetailStoreProvinceCenter(
        Q.retailStoreProvinceCenter()
            .select(RetailStoreProvinceCenter.COUNTRY_PROPERTY)
            .filterById(retailStoreProvinceCenter));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter(
      RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
    return hasRetailStoreProvinceCenter(
        retailStoreProvinceCenter,
        $retailStoreProvinceCenter ->
            java.util.Optional.of($retailStoreProvinceCenter)
                .map(RetailStoreProvinceCenter::getCountry)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter(
      RetailStoreProvinceCenterRequest retailStoreProvinceCenter,
      IDRefine<RetailStoreProvinceCenter> idRefine) {
    retailStoreProvinceCenter.select(RetailStoreProvinceCenter.COUNTRY_PROPERTY);
    retailStoreProvinceCenter.unlimited();
    return addSearchCriteria(
        createRetailStoreProvinceCenterCriteria(retailStoreProvinceCenter, idRefine));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter(
      RetailStoreProvinceCenterRequest retailStoreProvinceCenter,
      QueryOperator queryOperator,
      Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreProvinceCenter,
            RetailStoreProvinceCenter.COUNTRY_PROPERTY,
            queryOperator,
            value));
  }

  public SearchCriteria createRetailStoreProvinceCenterCriteria(
      RetailStoreProvinceCenterRequest retailStoreProvinceCenter,
      IDRefine<RetailStoreProvinceCenter> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreProvinceCenter,
        ID_PROPERTY,
        idRefine,
        RetailStoreProvinceCenter.COUNTRY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectRetailStoreProvinceCenterList(
      RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
    selectChild(RetailStoreProvinceCenter.COUNTRY_PROPERTY, retailStoreProvinceCenter);
    return this;
  }

  public RetailStoreCountryCenterRequest selectRetailStoreProvinceCenterList() {
    return selectRetailStoreProvinceCenterList(
        RetailStoreProvinceCenterRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectRetailStoreProvinceCenterList() {
    unselectChild(RetailStoreProvinceCenter.COUNTRY_PROPERTY, RetailStoreProvinceCenter.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasRetailStore() {
    return hasRetailStore(RetailStoreRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasRetailStore(RetailStore... retailStore) {
    if (isEmptyParam(retailStore)) {
      throw new IllegalArgumentException("hasRetailStore(RetailStore... retailStore)参数不能为空!");
    }
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStore));
  }

  public RetailStoreCountryCenterRequest hasRetailStore(String... retailStore) {
    return hasRetailStore(
        Q.retailStore()
            .select(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY)
            .filterById(retailStore));
  }

  public RetailStoreCountryCenterRequest hasRetailStore(RetailStoreRequest retailStore) {
    return hasRetailStore(
        retailStore,
        $retailStore ->
            java.util.Optional.of($retailStore)
                .map(RetailStore::getRetailStoreCountryCenter)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasRetailStore(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    retailStore.select(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
    retailStore.unlimited();
    return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
  }

  public RetailStoreCountryCenterRequest hasRetailStore(
      RetailStoreRequest retailStore, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStore, RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreCriteria(
      RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
    return new RefinedIdInCriteria(
        retailStore, ID_PROPERTY, idRefine, RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectRetailStoreList(RetailStoreRequest retailStore) {
    selectChild(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreCountryCenterRequest selectRetailStoreList() {
    return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectRetailStoreList() {
    unselectChild(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, RetailStore.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasRetailStoreMember() {
    return hasRetailStoreMember(RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasRetailStoreMember(
      RetailStoreMember... retailStoreMember) {
    if (isEmptyParam(retailStoreMember)) {
      throw new IllegalArgumentException(
          "hasRetailStoreMember(RetailStoreMember... retailStoreMember)参数不能为空!");
    }
    return hasRetailStoreMember(
        Q.retailStoreMember()
            .select(RetailStoreMember.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreMember));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreMember(String... retailStoreMember) {
    return hasRetailStoreMember(
        Q.retailStoreMember()
            .select(RetailStoreMember.OWNER_PROPERTY)
            .filterById(retailStoreMember));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreMember(
      RetailStoreMemberRequest retailStoreMember) {
    return hasRetailStoreMember(
        retailStoreMember,
        $retailStoreMember ->
            java.util.Optional.of($retailStoreMember)
                .map(RetailStoreMember::getOwner)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreMember(
      RetailStoreMemberRequest retailStoreMember, IDRefine<RetailStoreMember> idRefine) {
    retailStoreMember.select(RetailStoreMember.OWNER_PROPERTY);
    retailStoreMember.unlimited();
    return addSearchCriteria(createRetailStoreMemberCriteria(retailStoreMember, idRefine));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreMember(
      RetailStoreMemberRequest retailStoreMember, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreMember, RetailStoreMember.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreMemberCriteria(
      RetailStoreMemberRequest retailStoreMember, IDRefine<RetailStoreMember> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreMember, ID_PROPERTY, idRefine, RetailStoreMember.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectRetailStoreMemberList(
      RetailStoreMemberRequest retailStoreMember) {
    selectChild(RetailStoreMember.OWNER_PROPERTY, retailStoreMember);
    return this;
  }

  public RetailStoreCountryCenterRequest selectRetailStoreMemberList() {
    return selectRetailStoreMemberList(RetailStoreMemberRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectRetailStoreMemberList() {
    unselectChild(RetailStoreMember.OWNER_PROPERTY, RetailStoreMember.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasGoodsSupplier() {
    return hasGoodsSupplier(GoodsSupplierRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasGoodsSupplier(GoodsSupplier... goodsSupplier) {
    if (isEmptyParam(goodsSupplier)) {
      throw new IllegalArgumentException("hasGoodsSupplier(GoodsSupplier... goodsSupplier)参数不能为空!");
    }
    return hasGoodsSupplier(
        Q.goodsSupplier()
            .select(GoodsSupplier.BELONG_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) goodsSupplier));
  }

  public RetailStoreCountryCenterRequest hasGoodsSupplier(String... goodsSupplier) {
    return hasGoodsSupplier(
        Q.goodsSupplier().select(GoodsSupplier.BELONG_TO_PROPERTY).filterById(goodsSupplier));
  }

  public RetailStoreCountryCenterRequest hasGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
    return hasGoodsSupplier(
        goodsSupplier,
        $goodsSupplier ->
            java.util.Optional.of($goodsSupplier)
                .map(GoodsSupplier::getBelongTo)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasGoodsSupplier(
      GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine) {
    goodsSupplier.select(GoodsSupplier.BELONG_TO_PROPERTY);
    goodsSupplier.unlimited();
    return addSearchCriteria(createGoodsSupplierCriteria(goodsSupplier, idRefine));
  }

  public RetailStoreCountryCenterRequest hasGoodsSupplier(
      GoodsSupplierRequest goodsSupplier, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            goodsSupplier, GoodsSupplier.BELONG_TO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createGoodsSupplierCriteria(
      GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine) {
    return new RefinedIdInCriteria(
        goodsSupplier, ID_PROPERTY, idRefine, GoodsSupplier.BELONG_TO_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectGoodsSupplierList(
      GoodsSupplierRequest goodsSupplier) {
    selectChild(GoodsSupplier.BELONG_TO_PROPERTY, goodsSupplier);
    return this;
  }

  public RetailStoreCountryCenterRequest selectGoodsSupplierList() {
    return selectGoodsSupplierList(GoodsSupplierRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectGoodsSupplierList() {
    unselectChild(GoodsSupplier.BELONG_TO_PROPERTY, GoodsSupplier.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasSupplyOrder() {
    return hasSupplyOrder(SupplyOrderRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasSupplyOrder(SupplyOrder... supplyOrder) {
    if (isEmptyParam(supplyOrder)) {
      throw new IllegalArgumentException("hasSupplyOrder(SupplyOrder... supplyOrder)参数不能为空!");
    }
    return hasSupplyOrder(
        Q.supplyOrder()
            .select(SupplyOrder.BUYER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) supplyOrder));
  }

  public RetailStoreCountryCenterRequest hasSupplyOrder(String... supplyOrder) {
    return hasSupplyOrder(
        Q.supplyOrder().select(SupplyOrder.BUYER_PROPERTY).filterById(supplyOrder));
  }

  public RetailStoreCountryCenterRequest hasSupplyOrder(SupplyOrderRequest supplyOrder) {
    return hasSupplyOrder(
        supplyOrder,
        $supplyOrder ->
            java.util.Optional.of($supplyOrder)
                .map(SupplyOrder::getBuyer)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasSupplyOrder(
      SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine) {
    supplyOrder.select(SupplyOrder.BUYER_PROPERTY);
    supplyOrder.unlimited();
    return addSearchCriteria(createSupplyOrderCriteria(supplyOrder, idRefine));
  }

  public RetailStoreCountryCenterRequest hasSupplyOrder(
      SupplyOrderRequest supplyOrder, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(supplyOrder, SupplyOrder.BUYER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSupplyOrderCriteria(
      SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine) {
    return new RefinedIdInCriteria(supplyOrder, ID_PROPERTY, idRefine, SupplyOrder.BUYER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectSupplyOrderList(SupplyOrderRequest supplyOrder) {
    selectChild(SupplyOrder.BUYER_PROPERTY, supplyOrder);
    return this;
  }

  public RetailStoreCountryCenterRequest selectSupplyOrderList() {
    return selectSupplyOrderList(SupplyOrderRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectSupplyOrderList() {
    unselectChild(SupplyOrder.BUYER_PROPERTY, SupplyOrder.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasRetailStoreOrder() {
    return hasRetailStoreOrder(RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasRetailStoreOrder(RetailStoreOrder... retailStoreOrder) {
    if (isEmptyParam(retailStoreOrder)) {
      throw new IllegalArgumentException(
          "hasRetailStoreOrder(RetailStoreOrder... retailStoreOrder)参数不能为空!");
    }
    return hasRetailStoreOrder(
        Q.retailStoreOrder()
            .select(RetailStoreOrder.SELLER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) retailStoreOrder));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreOrder(String... retailStoreOrder) {
    return hasRetailStoreOrder(
        Q.retailStoreOrder().select(RetailStoreOrder.SELLER_PROPERTY).filterById(retailStoreOrder));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreOrder(
      RetailStoreOrderRequest retailStoreOrder) {
    return hasRetailStoreOrder(
        retailStoreOrder,
        $retailStoreOrder ->
            java.util.Optional.of($retailStoreOrder)
                .map(RetailStoreOrder::getSeller)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreOrder(
      RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
    retailStoreOrder.select(RetailStoreOrder.SELLER_PROPERTY);
    retailStoreOrder.unlimited();
    return addSearchCriteria(createRetailStoreOrderCriteria(retailStoreOrder, idRefine));
  }

  public RetailStoreCountryCenterRequest hasRetailStoreOrder(
      RetailStoreOrderRequest retailStoreOrder, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            retailStoreOrder, RetailStoreOrder.SELLER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createRetailStoreOrderCriteria(
      RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
    return new RefinedIdInCriteria(
        retailStoreOrder, ID_PROPERTY, idRefine, RetailStoreOrder.SELLER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectRetailStoreOrderList(
      RetailStoreOrderRequest retailStoreOrder) {
    selectChild(RetailStoreOrder.SELLER_PROPERTY, retailStoreOrder);
    return this;
  }

  public RetailStoreCountryCenterRequest selectRetailStoreOrderList() {
    return selectRetailStoreOrderList(RetailStoreOrderRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectRetailStoreOrderList() {
    unselectChild(RetailStoreOrder.SELLER_PROPERTY, RetailStoreOrder.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasWarehouse() {
    return hasWarehouse(WarehouseRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasWarehouse(Warehouse... warehouse) {
    if (isEmptyParam(warehouse)) {
      throw new IllegalArgumentException("hasWarehouse(Warehouse... warehouse)参数不能为空!");
    }
    return hasWarehouse(
        Q.warehouse()
            .select(Warehouse.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) warehouse));
  }

  public RetailStoreCountryCenterRequest hasWarehouse(String... warehouse) {
    return hasWarehouse(Q.warehouse().select(Warehouse.OWNER_PROPERTY).filterById(warehouse));
  }

  public RetailStoreCountryCenterRequest hasWarehouse(WarehouseRequest warehouse) {
    return hasWarehouse(
        warehouse,
        $warehouse ->
            java.util.Optional.of($warehouse)
                .map(Warehouse::getOwner)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasWarehouse(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    warehouse.select(Warehouse.OWNER_PROPERTY);
    warehouse.unlimited();
    return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
  }

  public RetailStoreCountryCenterRequest hasWarehouse(
      WarehouseRequest warehouse, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(warehouse, Warehouse.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createWarehouseCriteria(
      WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
    return new RefinedIdInCriteria(warehouse, ID_PROPERTY, idRefine, Warehouse.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectWarehouseList(WarehouseRequest warehouse) {
    selectChild(Warehouse.OWNER_PROPERTY, warehouse);
    return this;
  }

  public RetailStoreCountryCenterRequest selectWarehouseList() {
    return selectWarehouseList(WarehouseRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectWarehouseList() {
    unselectChild(Warehouse.OWNER_PROPERTY, Warehouse.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasTransportFleet() {
    return hasTransportFleet(TransportFleetRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasTransportFleet(TransportFleet... transportFleet) {
    if (isEmptyParam(transportFleet)) {
      throw new IllegalArgumentException(
          "hasTransportFleet(TransportFleet... transportFleet)参数不能为空!");
    }
    return hasTransportFleet(
        Q.transportFleet()
            .select(TransportFleet.OWNER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) transportFleet));
  }

  public RetailStoreCountryCenterRequest hasTransportFleet(String... transportFleet) {
    return hasTransportFleet(
        Q.transportFleet().select(TransportFleet.OWNER_PROPERTY).filterById(transportFleet));
  }

  public RetailStoreCountryCenterRequest hasTransportFleet(TransportFleetRequest transportFleet) {
    return hasTransportFleet(
        transportFleet,
        $transportFleet ->
            java.util.Optional.of($transportFleet)
                .map(TransportFleet::getOwner)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasTransportFleet(
      TransportFleetRequest transportFleet, IDRefine<TransportFleet> idRefine) {
    transportFleet.select(TransportFleet.OWNER_PROPERTY);
    transportFleet.unlimited();
    return addSearchCriteria(createTransportFleetCriteria(transportFleet, idRefine));
  }

  public RetailStoreCountryCenterRequest hasTransportFleet(
      TransportFleetRequest transportFleet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            transportFleet, TransportFleet.OWNER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTransportFleetCriteria(
      TransportFleetRequest transportFleet, IDRefine<TransportFleet> idRefine) {
    return new RefinedIdInCriteria(
        transportFleet, ID_PROPERTY, idRefine, TransportFleet.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectTransportFleetList(
      TransportFleetRequest transportFleet) {
    selectChild(TransportFleet.OWNER_PROPERTY, transportFleet);
    return this;
  }

  public RetailStoreCountryCenterRequest selectTransportFleetList() {
    return selectTransportFleetList(TransportFleetRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectTransportFleetList() {
    unselectChild(TransportFleet.OWNER_PROPERTY, TransportFleet.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasAccountSet() {
    return hasAccountSet(AccountSetRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasAccountSet(AccountSet... accountSet) {
    if (isEmptyParam(accountSet)) {
      throw new IllegalArgumentException("hasAccountSet(AccountSet... accountSet)参数不能为空!");
    }
    return hasAccountSet(
        Q.accountSet()
            .select(AccountSet.COUNTRY_CENTER_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) accountSet));
  }

  public RetailStoreCountryCenterRequest hasAccountSet(String... accountSet) {
    return hasAccountSet(
        Q.accountSet().select(AccountSet.COUNTRY_CENTER_PROPERTY).filterById(accountSet));
  }

  public RetailStoreCountryCenterRequest hasAccountSet(AccountSetRequest accountSet) {
    return hasAccountSet(
        accountSet,
        $accountSet ->
            java.util.Optional.of($accountSet)
                .map(AccountSet::getCountryCenter)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasAccountSet(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    accountSet.select(AccountSet.COUNTRY_CENTER_PROPERTY);
    accountSet.unlimited();
    return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
  }

  public RetailStoreCountryCenterRequest hasAccountSet(
      AccountSetRequest accountSet, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            accountSet, AccountSet.COUNTRY_CENTER_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createAccountSetCriteria(
      AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
    return new RefinedIdInCriteria(
        accountSet, ID_PROPERTY, idRefine, AccountSet.COUNTRY_CENTER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectAccountSetList(AccountSetRequest accountSet) {
    selectChild(AccountSet.COUNTRY_CENTER_PROPERTY, accountSet);
    return this;
  }

  public RetailStoreCountryCenterRequest selectAccountSetList() {
    return selectAccountSetList(AccountSetRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectAccountSetList() {
    unselectChild(AccountSet.COUNTRY_CENTER_PROPERTY, AccountSet.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasLevelOneDepartment() {
    return hasLevelOneDepartment(LevelOneDepartmentRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasLevelOneDepartment(
      LevelOneDepartment... levelOneDepartment) {
    if (isEmptyParam(levelOneDepartment)) {
      throw new IllegalArgumentException(
          "hasLevelOneDepartment(LevelOneDepartment... levelOneDepartment)参数不能为空!");
    }
    return hasLevelOneDepartment(
        Q.levelOneDepartment()
            .select(LevelOneDepartment.BELONGS_TO_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) levelOneDepartment));
  }

  public RetailStoreCountryCenterRequest hasLevelOneDepartment(String... levelOneDepartment) {
    return hasLevelOneDepartment(
        Q.levelOneDepartment()
            .select(LevelOneDepartment.BELONGS_TO_PROPERTY)
            .filterById(levelOneDepartment));
  }

  public RetailStoreCountryCenterRequest hasLevelOneDepartment(
      LevelOneDepartmentRequest levelOneDepartment) {
    return hasLevelOneDepartment(
        levelOneDepartment,
        $levelOneDepartment ->
            java.util.Optional.of($levelOneDepartment)
                .map(LevelOneDepartment::getBelongsTo)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasLevelOneDepartment(
      LevelOneDepartmentRequest levelOneDepartment, IDRefine<LevelOneDepartment> idRefine) {
    levelOneDepartment.select(LevelOneDepartment.BELONGS_TO_PROPERTY);
    levelOneDepartment.unlimited();
    return addSearchCriteria(createLevelOneDepartmentCriteria(levelOneDepartment, idRefine));
  }

  public RetailStoreCountryCenterRequest hasLevelOneDepartment(
      LevelOneDepartmentRequest levelOneDepartment, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            levelOneDepartment, LevelOneDepartment.BELONGS_TO_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLevelOneDepartmentCriteria(
      LevelOneDepartmentRequest levelOneDepartment, IDRefine<LevelOneDepartment> idRefine) {
    return new RefinedIdInCriteria(
        levelOneDepartment, ID_PROPERTY, idRefine, LevelOneDepartment.BELONGS_TO_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectLevelOneDepartmentList(
      LevelOneDepartmentRequest levelOneDepartment) {
    selectChild(LevelOneDepartment.BELONGS_TO_PROPERTY, levelOneDepartment);
    return this;
  }

  public RetailStoreCountryCenterRequest selectLevelOneDepartmentList() {
    return selectLevelOneDepartmentList(LevelOneDepartmentRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectLevelOneDepartmentList() {
    unselectChild(LevelOneDepartment.BELONGS_TO_PROPERTY, LevelOneDepartment.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasSkillType() {
    return hasSkillType(SkillTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasSkillType(SkillType... skillType) {
    if (isEmptyParam(skillType)) {
      throw new IllegalArgumentException("hasSkillType(SkillType... skillType)参数不能为空!");
    }
    return hasSkillType(
        Q.skillType()
            .select(SkillType.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) skillType));
  }

  public RetailStoreCountryCenterRequest hasSkillType(String... skillType) {
    return hasSkillType(Q.skillType().select(SkillType.COMPANY_PROPERTY).filterById(skillType));
  }

  public RetailStoreCountryCenterRequest hasSkillType(SkillTypeRequest skillType) {
    return hasSkillType(
        skillType,
        $skillType ->
            java.util.Optional.of($skillType)
                .map(SkillType::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasSkillType(
      SkillTypeRequest skillType, IDRefine<SkillType> idRefine) {
    skillType.select(SkillType.COMPANY_PROPERTY);
    skillType.unlimited();
    return addSearchCriteria(createSkillTypeCriteria(skillType, idRefine));
  }

  public RetailStoreCountryCenterRequest hasSkillType(
      SkillTypeRequest skillType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(skillType, SkillType.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSkillTypeCriteria(
      SkillTypeRequest skillType, IDRefine<SkillType> idRefine) {
    return new RefinedIdInCriteria(skillType, ID_PROPERTY, idRefine, SkillType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectSkillTypeList(SkillTypeRequest skillType) {
    selectChild(SkillType.COMPANY_PROPERTY, skillType);
    return this;
  }

  public RetailStoreCountryCenterRequest selectSkillTypeList() {
    return selectSkillTypeList(SkillTypeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectSkillTypeList() {
    unselectChild(SkillType.COMPANY_PROPERTY, SkillType.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasResponsibilityType() {
    return hasResponsibilityType(ResponsibilityTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasResponsibilityType(
      ResponsibilityType... responsibilityType) {
    if (isEmptyParam(responsibilityType)) {
      throw new IllegalArgumentException(
          "hasResponsibilityType(ResponsibilityType... responsibilityType)参数不能为空!");
    }
    return hasResponsibilityType(
        Q.responsibilityType()
            .select(ResponsibilityType.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) responsibilityType));
  }

  public RetailStoreCountryCenterRequest hasResponsibilityType(String... responsibilityType) {
    return hasResponsibilityType(
        Q.responsibilityType()
            .select(ResponsibilityType.COMPANY_PROPERTY)
            .filterById(responsibilityType));
  }

  public RetailStoreCountryCenterRequest hasResponsibilityType(
      ResponsibilityTypeRequest responsibilityType) {
    return hasResponsibilityType(
        responsibilityType,
        $responsibilityType ->
            java.util.Optional.of($responsibilityType)
                .map(ResponsibilityType::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasResponsibilityType(
      ResponsibilityTypeRequest responsibilityType, IDRefine<ResponsibilityType> idRefine) {
    responsibilityType.select(ResponsibilityType.COMPANY_PROPERTY);
    responsibilityType.unlimited();
    return addSearchCriteria(createResponsibilityTypeCriteria(responsibilityType, idRefine));
  }

  public RetailStoreCountryCenterRequest hasResponsibilityType(
      ResponsibilityTypeRequest responsibilityType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            responsibilityType, ResponsibilityType.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createResponsibilityTypeCriteria(
      ResponsibilityTypeRequest responsibilityType, IDRefine<ResponsibilityType> idRefine) {
    return new RefinedIdInCriteria(
        responsibilityType, ID_PROPERTY, idRefine, ResponsibilityType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectResponsibilityTypeList(
      ResponsibilityTypeRequest responsibilityType) {
    selectChild(ResponsibilityType.COMPANY_PROPERTY, responsibilityType);
    return this;
  }

  public RetailStoreCountryCenterRequest selectResponsibilityTypeList() {
    return selectResponsibilityTypeList(ResponsibilityTypeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectResponsibilityTypeList() {
    unselectChild(ResponsibilityType.COMPANY_PROPERTY, ResponsibilityType.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasTerminationReason() {
    return hasTerminationReason(TerminationReasonRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasTerminationReason(
      TerminationReason... terminationReason) {
    if (isEmptyParam(terminationReason)) {
      throw new IllegalArgumentException(
          "hasTerminationReason(TerminationReason... terminationReason)参数不能为空!");
    }
    return hasTerminationReason(
        Q.terminationReason()
            .select(TerminationReason.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) terminationReason));
  }

  public RetailStoreCountryCenterRequest hasTerminationReason(String... terminationReason) {
    return hasTerminationReason(
        Q.terminationReason()
            .select(TerminationReason.COMPANY_PROPERTY)
            .filterById(terminationReason));
  }

  public RetailStoreCountryCenterRequest hasTerminationReason(
      TerminationReasonRequest terminationReason) {
    return hasTerminationReason(
        terminationReason,
        $terminationReason ->
            java.util.Optional.of($terminationReason)
                .map(TerminationReason::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasTerminationReason(
      TerminationReasonRequest terminationReason, IDRefine<TerminationReason> idRefine) {
    terminationReason.select(TerminationReason.COMPANY_PROPERTY);
    terminationReason.unlimited();
    return addSearchCriteria(createTerminationReasonCriteria(terminationReason, idRefine));
  }

  public RetailStoreCountryCenterRequest hasTerminationReason(
      TerminationReasonRequest terminationReason, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            terminationReason, TerminationReason.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTerminationReasonCriteria(
      TerminationReasonRequest terminationReason, IDRefine<TerminationReason> idRefine) {
    return new RefinedIdInCriteria(
        terminationReason, ID_PROPERTY, idRefine, TerminationReason.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectTerminationReasonList(
      TerminationReasonRequest terminationReason) {
    selectChild(TerminationReason.COMPANY_PROPERTY, terminationReason);
    return this;
  }

  public RetailStoreCountryCenterRequest selectTerminationReasonList() {
    return selectTerminationReasonList(TerminationReasonRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectTerminationReasonList() {
    unselectChild(TerminationReason.COMPANY_PROPERTY, TerminationReason.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasTerminationType() {
    return hasTerminationType(TerminationTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasTerminationType(TerminationType... terminationType) {
    if (isEmptyParam(terminationType)) {
      throw new IllegalArgumentException(
          "hasTerminationType(TerminationType... terminationType)参数不能为空!");
    }
    return hasTerminationType(
        Q.terminationType()
            .select(TerminationType.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) terminationType));
  }

  public RetailStoreCountryCenterRequest hasTerminationType(String... terminationType) {
    return hasTerminationType(
        Q.terminationType().select(TerminationType.COMPANY_PROPERTY).filterById(terminationType));
  }

  public RetailStoreCountryCenterRequest hasTerminationType(
      TerminationTypeRequest terminationType) {
    return hasTerminationType(
        terminationType,
        $terminationType ->
            java.util.Optional.of($terminationType)
                .map(TerminationType::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasTerminationType(
      TerminationTypeRequest terminationType, IDRefine<TerminationType> idRefine) {
    terminationType.select(TerminationType.COMPANY_PROPERTY);
    terminationType.unlimited();
    return addSearchCriteria(createTerminationTypeCriteria(terminationType, idRefine));
  }

  public RetailStoreCountryCenterRequest hasTerminationType(
      TerminationTypeRequest terminationType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            terminationType, TerminationType.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTerminationTypeCriteria(
      TerminationTypeRequest terminationType, IDRefine<TerminationType> idRefine) {
    return new RefinedIdInCriteria(
        terminationType, ID_PROPERTY, idRefine, TerminationType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectTerminationTypeList(
      TerminationTypeRequest terminationType) {
    selectChild(TerminationType.COMPANY_PROPERTY, terminationType);
    return this;
  }

  public RetailStoreCountryCenterRequest selectTerminationTypeList() {
    return selectTerminationTypeList(TerminationTypeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectTerminationTypeList() {
    unselectChild(TerminationType.COMPANY_PROPERTY, TerminationType.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasOccupationType() {
    return hasOccupationType(OccupationTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasOccupationType(OccupationType... occupationType) {
    if (isEmptyParam(occupationType)) {
      throw new IllegalArgumentException(
          "hasOccupationType(OccupationType... occupationType)参数不能为空!");
    }
    return hasOccupationType(
        Q.occupationType()
            .select(OccupationType.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) occupationType));
  }

  public RetailStoreCountryCenterRequest hasOccupationType(String... occupationType) {
    return hasOccupationType(
        Q.occupationType().select(OccupationType.COMPANY_PROPERTY).filterById(occupationType));
  }

  public RetailStoreCountryCenterRequest hasOccupationType(OccupationTypeRequest occupationType) {
    return hasOccupationType(
        occupationType,
        $occupationType ->
            java.util.Optional.of($occupationType)
                .map(OccupationType::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasOccupationType(
      OccupationTypeRequest occupationType, IDRefine<OccupationType> idRefine) {
    occupationType.select(OccupationType.COMPANY_PROPERTY);
    occupationType.unlimited();
    return addSearchCriteria(createOccupationTypeCriteria(occupationType, idRefine));
  }

  public RetailStoreCountryCenterRequest hasOccupationType(
      OccupationTypeRequest occupationType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            occupationType, OccupationType.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createOccupationTypeCriteria(
      OccupationTypeRequest occupationType, IDRefine<OccupationType> idRefine) {
    return new RefinedIdInCriteria(
        occupationType, ID_PROPERTY, idRefine, OccupationType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectOccupationTypeList(
      OccupationTypeRequest occupationType) {
    selectChild(OccupationType.COMPANY_PROPERTY, occupationType);
    return this;
  }

  public RetailStoreCountryCenterRequest selectOccupationTypeList() {
    return selectOccupationTypeList(OccupationTypeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectOccupationTypeList() {
    unselectChild(OccupationType.COMPANY_PROPERTY, OccupationType.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasLeaveType() {
    return hasLeaveType(LeaveTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasLeaveType(LeaveType... leaveType) {
    if (isEmptyParam(leaveType)) {
      throw new IllegalArgumentException("hasLeaveType(LeaveType... leaveType)参数不能为空!");
    }
    return hasLeaveType(
        Q.leaveType()
            .select(LeaveType.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) leaveType));
  }

  public RetailStoreCountryCenterRequest hasLeaveType(String... leaveType) {
    return hasLeaveType(Q.leaveType().select(LeaveType.COMPANY_PROPERTY).filterById(leaveType));
  }

  public RetailStoreCountryCenterRequest hasLeaveType(LeaveTypeRequest leaveType) {
    return hasLeaveType(
        leaveType,
        $leaveType ->
            java.util.Optional.of($leaveType)
                .map(LeaveType::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasLeaveType(
      LeaveTypeRequest leaveType, IDRefine<LeaveType> idRefine) {
    leaveType.select(LeaveType.COMPANY_PROPERTY);
    leaveType.unlimited();
    return addSearchCriteria(createLeaveTypeCriteria(leaveType, idRefine));
  }

  public RetailStoreCountryCenterRequest hasLeaveType(
      LeaveTypeRequest leaveType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(leaveType, LeaveType.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createLeaveTypeCriteria(
      LeaveTypeRequest leaveType, IDRefine<LeaveType> idRefine) {
    return new RefinedIdInCriteria(leaveType, ID_PROPERTY, idRefine, LeaveType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectLeaveTypeList(LeaveTypeRequest leaveType) {
    selectChild(LeaveType.COMPANY_PROPERTY, leaveType);
    return this;
  }

  public RetailStoreCountryCenterRequest selectLeaveTypeList() {
    return selectLeaveTypeList(LeaveTypeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectLeaveTypeList() {
    unselectChild(LeaveType.COMPANY_PROPERTY, LeaveType.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasSalaryGrade() {
    return hasSalaryGrade(SalaryGradeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasSalaryGrade(SalaryGrade... salaryGrade) {
    if (isEmptyParam(salaryGrade)) {
      throw new IllegalArgumentException("hasSalaryGrade(SalaryGrade... salaryGrade)参数不能为空!");
    }
    return hasSalaryGrade(
        Q.salaryGrade()
            .select(SalaryGrade.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) salaryGrade));
  }

  public RetailStoreCountryCenterRequest hasSalaryGrade(String... salaryGrade) {
    return hasSalaryGrade(
        Q.salaryGrade().select(SalaryGrade.COMPANY_PROPERTY).filterById(salaryGrade));
  }

  public RetailStoreCountryCenterRequest hasSalaryGrade(SalaryGradeRequest salaryGrade) {
    return hasSalaryGrade(
        salaryGrade,
        $salaryGrade ->
            java.util.Optional.of($salaryGrade)
                .map(SalaryGrade::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasSalaryGrade(
      SalaryGradeRequest salaryGrade, IDRefine<SalaryGrade> idRefine) {
    salaryGrade.select(SalaryGrade.COMPANY_PROPERTY);
    salaryGrade.unlimited();
    return addSearchCriteria(createSalaryGradeCriteria(salaryGrade, idRefine));
  }

  public RetailStoreCountryCenterRequest hasSalaryGrade(
      SalaryGradeRequest salaryGrade, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(salaryGrade, SalaryGrade.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createSalaryGradeCriteria(
      SalaryGradeRequest salaryGrade, IDRefine<SalaryGrade> idRefine) {
    return new RefinedIdInCriteria(
        salaryGrade, ID_PROPERTY, idRefine, SalaryGrade.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectSalaryGradeList(SalaryGradeRequest salaryGrade) {
    selectChild(SalaryGrade.COMPANY_PROPERTY, salaryGrade);
    return this;
  }

  public RetailStoreCountryCenterRequest selectSalaryGradeList() {
    return selectSalaryGradeList(SalaryGradeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectSalaryGradeList() {
    unselectChild(SalaryGrade.COMPANY_PROPERTY, SalaryGrade.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasInterviewType() {
    return hasInterviewType(InterviewTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasInterviewType(InterviewType... interviewType) {
    if (isEmptyParam(interviewType)) {
      throw new IllegalArgumentException("hasInterviewType(InterviewType... interviewType)参数不能为空!");
    }
    return hasInterviewType(
        Q.interviewType()
            .select(InterviewType.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) interviewType));
  }

  public RetailStoreCountryCenterRequest hasInterviewType(String... interviewType) {
    return hasInterviewType(
        Q.interviewType().select(InterviewType.COMPANY_PROPERTY).filterById(interviewType));
  }

  public RetailStoreCountryCenterRequest hasInterviewType(InterviewTypeRequest interviewType) {
    return hasInterviewType(
        interviewType,
        $interviewType ->
            java.util.Optional.of($interviewType)
                .map(InterviewType::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasInterviewType(
      InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine) {
    interviewType.select(InterviewType.COMPANY_PROPERTY);
    interviewType.unlimited();
    return addSearchCriteria(createInterviewTypeCriteria(interviewType, idRefine));
  }

  public RetailStoreCountryCenterRequest hasInterviewType(
      InterviewTypeRequest interviewType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            interviewType, InterviewType.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createInterviewTypeCriteria(
      InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine) {
    return new RefinedIdInCriteria(
        interviewType, ID_PROPERTY, idRefine, InterviewType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectInterviewTypeList(
      InterviewTypeRequest interviewType) {
    selectChild(InterviewType.COMPANY_PROPERTY, interviewType);
    return this;
  }

  public RetailStoreCountryCenterRequest selectInterviewTypeList() {
    return selectInterviewTypeList(InterviewTypeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectInterviewTypeList() {
    unselectChild(InterviewType.COMPANY_PROPERTY, InterviewType.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasTrainingCourseType() {
    return hasTrainingCourseType(TrainingCourseTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasTrainingCourseType(
      TrainingCourseType... trainingCourseType) {
    if (isEmptyParam(trainingCourseType)) {
      throw new IllegalArgumentException(
          "hasTrainingCourseType(TrainingCourseType... trainingCourseType)参数不能为空!");
    }
    return hasTrainingCourseType(
        Q.trainingCourseType()
            .select(TrainingCourseType.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) trainingCourseType));
  }

  public RetailStoreCountryCenterRequest hasTrainingCourseType(String... trainingCourseType) {
    return hasTrainingCourseType(
        Q.trainingCourseType()
            .select(TrainingCourseType.COMPANY_PROPERTY)
            .filterById(trainingCourseType));
  }

  public RetailStoreCountryCenterRequest hasTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType) {
    return hasTrainingCourseType(
        trainingCourseType,
        $trainingCourseType ->
            java.util.Optional.of($trainingCourseType)
                .map(TrainingCourseType::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine) {
    trainingCourseType.select(TrainingCourseType.COMPANY_PROPERTY);
    trainingCourseType.unlimited();
    return addSearchCriteria(createTrainingCourseTypeCriteria(trainingCourseType, idRefine));
  }

  public RetailStoreCountryCenterRequest hasTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            trainingCourseType, TrainingCourseType.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createTrainingCourseTypeCriteria(
      TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine) {
    return new RefinedIdInCriteria(
        trainingCourseType, ID_PROPERTY, idRefine, TrainingCourseType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectTrainingCourseTypeList(
      TrainingCourseTypeRequest trainingCourseType) {
    selectChild(TrainingCourseType.COMPANY_PROPERTY, trainingCourseType);
    return this;
  }

  public RetailStoreCountryCenterRequest selectTrainingCourseTypeList() {
    return selectTrainingCourseTypeList(TrainingCourseTypeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectTrainingCourseTypeList() {
    unselectChild(TrainingCourseType.COMPANY_PROPERTY, TrainingCourseType.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasPublicHoliday() {
    return hasPublicHoliday(PublicHolidayRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasPublicHoliday(PublicHoliday... publicHoliday) {
    if (isEmptyParam(publicHoliday)) {
      throw new IllegalArgumentException("hasPublicHoliday(PublicHoliday... publicHoliday)参数不能为空!");
    }
    return hasPublicHoliday(
        Q.publicHoliday()
            .select(PublicHoliday.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) publicHoliday));
  }

  public RetailStoreCountryCenterRequest hasPublicHoliday(String... publicHoliday) {
    return hasPublicHoliday(
        Q.publicHoliday().select(PublicHoliday.COMPANY_PROPERTY).filterById(publicHoliday));
  }

  public RetailStoreCountryCenterRequest hasPublicHoliday(PublicHolidayRequest publicHoliday) {
    return hasPublicHoliday(
        publicHoliday,
        $publicHoliday ->
            java.util.Optional.of($publicHoliday)
                .map(PublicHoliday::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasPublicHoliday(
      PublicHolidayRequest publicHoliday, IDRefine<PublicHoliday> idRefine) {
    publicHoliday.select(PublicHoliday.COMPANY_PROPERTY);
    publicHoliday.unlimited();
    return addSearchCriteria(createPublicHolidayCriteria(publicHoliday, idRefine));
  }

  public RetailStoreCountryCenterRequest hasPublicHoliday(
      PublicHolidayRequest publicHoliday, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            publicHoliday, PublicHoliday.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createPublicHolidayCriteria(
      PublicHolidayRequest publicHoliday, IDRefine<PublicHoliday> idRefine) {
    return new RefinedIdInCriteria(
        publicHoliday, ID_PROPERTY, idRefine, PublicHoliday.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectPublicHolidayList(
      PublicHolidayRequest publicHoliday) {
    selectChild(PublicHoliday.COMPANY_PROPERTY, publicHoliday);
    return this;
  }

  public RetailStoreCountryCenterRequest selectPublicHolidayList() {
    return selectPublicHolidayList(PublicHolidayRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectPublicHolidayList() {
    unselectChild(PublicHoliday.COMPANY_PROPERTY, PublicHoliday.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasEmployee() {
    return hasEmployee(EmployeeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("hasEmployee(Employee... employee)参数不能为空!");
    }
    return hasEmployee(
        Q.employee()
            .select(Employee.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) employee));
  }

  public RetailStoreCountryCenterRequest hasEmployee(String... employee) {
    return hasEmployee(Q.employee().select(Employee.COMPANY_PROPERTY).filterById(employee));
  }

  public RetailStoreCountryCenterRequest hasEmployee(EmployeeRequest employee) {
    return hasEmployee(
        employee,
        $employee ->
            java.util.Optional.of($employee)
                .map(Employee::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.select(Employee.COMPANY_PROPERTY);
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public RetailStoreCountryCenterRequest hasEmployee(
      EmployeeRequest employee, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(employee, Employee.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine, Employee.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectEmployeeList(EmployeeRequest employee) {
    selectChild(Employee.COMPANY_PROPERTY, employee);
    return this;
  }

  public RetailStoreCountryCenterRequest selectEmployeeList() {
    return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectEmployeeList() {
    unselectChild(Employee.COMPANY_PROPERTY, Employee.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasInstructor() {
    return hasInstructor(InstructorRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasInstructor(Instructor... instructor) {
    if (isEmptyParam(instructor)) {
      throw new IllegalArgumentException("hasInstructor(Instructor... instructor)参数不能为空!");
    }
    return hasInstructor(
        Q.instructor()
            .select(Instructor.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) instructor));
  }

  public RetailStoreCountryCenterRequest hasInstructor(String... instructor) {
    return hasInstructor(Q.instructor().select(Instructor.COMPANY_PROPERTY).filterById(instructor));
  }

  public RetailStoreCountryCenterRequest hasInstructor(InstructorRequest instructor) {
    return hasInstructor(
        instructor,
        $instructor ->
            java.util.Optional.of($instructor)
                .map(Instructor::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasInstructor(
      InstructorRequest instructor, IDRefine<Instructor> idRefine) {
    instructor.select(Instructor.COMPANY_PROPERTY);
    instructor.unlimited();
    return addSearchCriteria(createInstructorCriteria(instructor, idRefine));
  }

  public RetailStoreCountryCenterRequest hasInstructor(
      InstructorRequest instructor, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(instructor, Instructor.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createInstructorCriteria(
      InstructorRequest instructor, IDRefine<Instructor> idRefine) {
    return new RefinedIdInCriteria(instructor, ID_PROPERTY, idRefine, Instructor.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectInstructorList(InstructorRequest instructor) {
    selectChild(Instructor.COMPANY_PROPERTY, instructor);
    return this;
  }

  public RetailStoreCountryCenterRequest selectInstructorList() {
    return selectInstructorList(InstructorRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectInstructorList() {
    unselectChild(Instructor.COMPANY_PROPERTY, Instructor.class);
    return this;
  }

  public RetailStoreCountryCenterRequest hasCompanyTraining() {
    return hasCompanyTraining(CompanyTrainingRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest hasCompanyTraining(CompanyTraining... companyTraining) {
    if (isEmptyParam(companyTraining)) {
      throw new IllegalArgumentException(
          "hasCompanyTraining(CompanyTraining... companyTraining)参数不能为空!");
    }
    return hasCompanyTraining(
        Q.companyTraining()
            .select(CompanyTraining.COMPANY_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) companyTraining));
  }

  public RetailStoreCountryCenterRequest hasCompanyTraining(String... companyTraining) {
    return hasCompanyTraining(
        Q.companyTraining().select(CompanyTraining.COMPANY_PROPERTY).filterById(companyTraining));
  }

  public RetailStoreCountryCenterRequest hasCompanyTraining(
      CompanyTrainingRequest companyTraining) {
    return hasCompanyTraining(
        companyTraining,
        $companyTraining ->
            java.util.Optional.of($companyTraining)
                .map(CompanyTraining::getCompany)
                .map(RetailStoreCountryCenter::getId)
                .orElse(null));
  }

  public RetailStoreCountryCenterRequest hasCompanyTraining(
      CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
    companyTraining.select(CompanyTraining.COMPANY_PROPERTY);
    companyTraining.unlimited();
    return addSearchCriteria(createCompanyTrainingCriteria(companyTraining, idRefine));
  }

  public RetailStoreCountryCenterRequest hasCompanyTraining(
      CompanyTrainingRequest companyTraining, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            companyTraining, CompanyTraining.COMPANY_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createCompanyTrainingCriteria(
      CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
    return new RefinedIdInCriteria(
        companyTraining, ID_PROPERTY, idRefine, CompanyTraining.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest selectCompanyTrainingList(
      CompanyTrainingRequest companyTraining) {
    selectChild(CompanyTraining.COMPANY_PROPERTY, companyTraining);
    return this;
  }

  public RetailStoreCountryCenterRequest selectCompanyTrainingList() {
    return selectCompanyTrainingList(CompanyTrainingRequest.newInstance().selectAll());
  }

  public RetailStoreCountryCenterRequest unselectCompanyTrainingList() {
    unselectChild(CompanyTraining.COMPANY_PROPERTY, CompanyTraining.class);
    return this;
  }

  public RetailStoreCountryCenterRequest aggregateCatalogList(CatalogRequest catalog) {
    aggregateChild(Catalog.OWNER_PROPERTY, catalog);
    return this;
  }

  public RetailStoreCountryCenterRequest countCatalog() {
    return countCatalog("catalogCount");
  }

  public RetailStoreCountryCenterRequest countCatalog(String retName) {
    return countCatalog(retName, CatalogRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countCatalog(CatalogRequest catalog) {
    return countCatalog("catalogCount", catalog);
  }

  public RetailStoreCountryCenterRequest countCatalog(String retName, CatalogRequest catalog) {
    catalog.count();
    return statsFromCatalog(retName, catalog);
  }

  public RetailStoreCountryCenterRequest statsFromCatalog(String retName, CatalogRequest catalog) {
    return addDynamicProperty(retName, catalog, Catalog.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateRetailStoreProvinceCenterList(
      RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
    aggregateChild(RetailStoreProvinceCenter.COUNTRY_PROPERTY, retailStoreProvinceCenter);
    return this;
  }

  public RetailStoreCountryCenterRequest countRetailStoreProvinceCenter() {
    return countRetailStoreProvinceCenter("retailStoreProvinceCenterCount");
  }

  public RetailStoreCountryCenterRequest countRetailStoreProvinceCenter(String retName) {
    return countRetailStoreProvinceCenter(retName, RetailStoreProvinceCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countRetailStoreProvinceCenter(
      RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
    return countRetailStoreProvinceCenter(
        "retailStoreProvinceCenterCount", retailStoreProvinceCenter);
  }

  public RetailStoreCountryCenterRequest countRetailStoreProvinceCenter(
      String retName, RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
    retailStoreProvinceCenter.count();
    return statsFromRetailStoreProvinceCenter(retName, retailStoreProvinceCenter);
  }

  public RetailStoreCountryCenterRequest statsFromRetailStoreProvinceCenter(
      String retName, RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
    return addDynamicProperty(
        retName, retailStoreProvinceCenter, RetailStoreProvinceCenter.COUNTRY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateRetailStoreList(RetailStoreRequest retailStore) {
    aggregateChild(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStore);
    return this;
  }

  public RetailStoreCountryCenterRequest countRetailStore() {
    return countRetailStore("retailStoreCount");
  }

  public RetailStoreCountryCenterRequest countRetailStore(String retName) {
    return countRetailStore(retName, RetailStoreRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countRetailStore(RetailStoreRequest retailStore) {
    return countRetailStore("retailStoreCount", retailStore);
  }

  public RetailStoreCountryCenterRequest countRetailStore(
      String retName, RetailStoreRequest retailStore) {
    retailStore.count();
    return statsFromRetailStore(retName, retailStore);
  }

  public RetailStoreCountryCenterRequest statsFromRetailStore(
      String retName, RetailStoreRequest retailStore) {
    return addDynamicProperty(
        retName, retailStore, RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateRetailStoreMemberList(
      RetailStoreMemberRequest retailStoreMember) {
    aggregateChild(RetailStoreMember.OWNER_PROPERTY, retailStoreMember);
    return this;
  }

  public RetailStoreCountryCenterRequest countRetailStoreMember() {
    return countRetailStoreMember("retailStoreMemberCount");
  }

  public RetailStoreCountryCenterRequest countRetailStoreMember(String retName) {
    return countRetailStoreMember(retName, RetailStoreMemberRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countRetailStoreMember(
      RetailStoreMemberRequest retailStoreMember) {
    return countRetailStoreMember("retailStoreMemberCount", retailStoreMember);
  }

  public RetailStoreCountryCenterRequest countRetailStoreMember(
      String retName, RetailStoreMemberRequest retailStoreMember) {
    retailStoreMember.count();
    return statsFromRetailStoreMember(retName, retailStoreMember);
  }

  public RetailStoreCountryCenterRequest statsFromRetailStoreMember(
      String retName, RetailStoreMemberRequest retailStoreMember) {
    return addDynamicProperty(retName, retailStoreMember, RetailStoreMember.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateGoodsSupplierList(
      GoodsSupplierRequest goodsSupplier) {
    aggregateChild(GoodsSupplier.BELONG_TO_PROPERTY, goodsSupplier);
    return this;
  }

  public RetailStoreCountryCenterRequest countGoodsSupplier() {
    return countGoodsSupplier("goodsSupplierCount");
  }

  public RetailStoreCountryCenterRequest countGoodsSupplier(String retName) {
    return countGoodsSupplier(retName, GoodsSupplierRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
    return countGoodsSupplier("goodsSupplierCount", goodsSupplier);
  }

  public RetailStoreCountryCenterRequest countGoodsSupplier(
      String retName, GoodsSupplierRequest goodsSupplier) {
    goodsSupplier.count();
    return statsFromGoodsSupplier(retName, goodsSupplier);
  }

  public RetailStoreCountryCenterRequest statsFromGoodsSupplier(
      String retName, GoodsSupplierRequest goodsSupplier) {
    return addDynamicProperty(retName, goodsSupplier, GoodsSupplier.BELONG_TO_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateSupplyOrderList(SupplyOrderRequest supplyOrder) {
    aggregateChild(SupplyOrder.BUYER_PROPERTY, supplyOrder);
    return this;
  }

  public RetailStoreCountryCenterRequest countSupplyOrder() {
    return countSupplyOrder("supplyOrderCount");
  }

  public RetailStoreCountryCenterRequest countSupplyOrder(String retName) {
    return countSupplyOrder(retName, SupplyOrderRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countSupplyOrder(SupplyOrderRequest supplyOrder) {
    return countSupplyOrder("supplyOrderCount", supplyOrder);
  }

  public RetailStoreCountryCenterRequest countSupplyOrder(
      String retName, SupplyOrderRequest supplyOrder) {
    supplyOrder.count();
    return statsFromSupplyOrder(retName, supplyOrder);
  }

  public RetailStoreCountryCenterRequest statsFromSupplyOrder(
      String retName, SupplyOrderRequest supplyOrder) {
    return addDynamicProperty(retName, supplyOrder, SupplyOrder.BUYER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateRetailStoreOrderList(
      RetailStoreOrderRequest retailStoreOrder) {
    aggregateChild(RetailStoreOrder.SELLER_PROPERTY, retailStoreOrder);
    return this;
  }

  public RetailStoreCountryCenterRequest countRetailStoreOrder() {
    return countRetailStoreOrder("retailStoreOrderCount");
  }

  public RetailStoreCountryCenterRequest countRetailStoreOrder(String retName) {
    return countRetailStoreOrder(retName, RetailStoreOrderRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countRetailStoreOrder(
      RetailStoreOrderRequest retailStoreOrder) {
    return countRetailStoreOrder("retailStoreOrderCount", retailStoreOrder);
  }

  public RetailStoreCountryCenterRequest countRetailStoreOrder(
      String retName, RetailStoreOrderRequest retailStoreOrder) {
    retailStoreOrder.count();
    return statsFromRetailStoreOrder(retName, retailStoreOrder);
  }

  public RetailStoreCountryCenterRequest statsFromRetailStoreOrder(
      String retName, RetailStoreOrderRequest retailStoreOrder) {
    return addDynamicProperty(retName, retailStoreOrder, RetailStoreOrder.SELLER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateWarehouseList(WarehouseRequest warehouse) {
    aggregateChild(Warehouse.OWNER_PROPERTY, warehouse);
    return this;
  }

  public RetailStoreCountryCenterRequest countWarehouse() {
    return countWarehouse("warehouseCount");
  }

  public RetailStoreCountryCenterRequest countWarehouse(String retName) {
    return countWarehouse(retName, WarehouseRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countWarehouse(WarehouseRequest warehouse) {
    return countWarehouse("warehouseCount", warehouse);
  }

  public RetailStoreCountryCenterRequest countWarehouse(
      String retName, WarehouseRequest warehouse) {
    warehouse.count();
    return statsFromWarehouse(retName, warehouse);
  }

  public RetailStoreCountryCenterRequest statsFromWarehouse(
      String retName, WarehouseRequest warehouse) {
    return addDynamicProperty(retName, warehouse, Warehouse.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateTransportFleetList(
      TransportFleetRequest transportFleet) {
    aggregateChild(TransportFleet.OWNER_PROPERTY, transportFleet);
    return this;
  }

  public RetailStoreCountryCenterRequest countTransportFleet() {
    return countTransportFleet("transportFleetCount");
  }

  public RetailStoreCountryCenterRequest countTransportFleet(String retName) {
    return countTransportFleet(retName, TransportFleetRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countTransportFleet(TransportFleetRequest transportFleet) {
    return countTransportFleet("transportFleetCount", transportFleet);
  }

  public RetailStoreCountryCenterRequest countTransportFleet(
      String retName, TransportFleetRequest transportFleet) {
    transportFleet.count();
    return statsFromTransportFleet(retName, transportFleet);
  }

  public RetailStoreCountryCenterRequest statsFromTransportFleet(
      String retName, TransportFleetRequest transportFleet) {
    return addDynamicProperty(retName, transportFleet, TransportFleet.OWNER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateAccountSetList(AccountSetRequest accountSet) {
    aggregateChild(AccountSet.COUNTRY_CENTER_PROPERTY, accountSet);
    return this;
  }

  public RetailStoreCountryCenterRequest countAccountSet() {
    return countAccountSet("accountSetCount");
  }

  public RetailStoreCountryCenterRequest countAccountSet(String retName) {
    return countAccountSet(retName, AccountSetRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countAccountSet(AccountSetRequest accountSet) {
    return countAccountSet("accountSetCount", accountSet);
  }

  public RetailStoreCountryCenterRequest countAccountSet(
      String retName, AccountSetRequest accountSet) {
    accountSet.count();
    return statsFromAccountSet(retName, accountSet);
  }

  public RetailStoreCountryCenterRequest statsFromAccountSet(
      String retName, AccountSetRequest accountSet) {
    return addDynamicProperty(retName, accountSet, AccountSet.COUNTRY_CENTER_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateLevelOneDepartmentList(
      LevelOneDepartmentRequest levelOneDepartment) {
    aggregateChild(LevelOneDepartment.BELONGS_TO_PROPERTY, levelOneDepartment);
    return this;
  }

  public RetailStoreCountryCenterRequest countLevelOneDepartment() {
    return countLevelOneDepartment("levelOneDepartmentCount");
  }

  public RetailStoreCountryCenterRequest countLevelOneDepartment(String retName) {
    return countLevelOneDepartment(retName, LevelOneDepartmentRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countLevelOneDepartment(
      LevelOneDepartmentRequest levelOneDepartment) {
    return countLevelOneDepartment("levelOneDepartmentCount", levelOneDepartment);
  }

  public RetailStoreCountryCenterRequest countLevelOneDepartment(
      String retName, LevelOneDepartmentRequest levelOneDepartment) {
    levelOneDepartment.count();
    return statsFromLevelOneDepartment(retName, levelOneDepartment);
  }

  public RetailStoreCountryCenterRequest statsFromLevelOneDepartment(
      String retName, LevelOneDepartmentRequest levelOneDepartment) {
    return addDynamicProperty(retName, levelOneDepartment, LevelOneDepartment.BELONGS_TO_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateSkillTypeList(SkillTypeRequest skillType) {
    aggregateChild(SkillType.COMPANY_PROPERTY, skillType);
    return this;
  }

  public RetailStoreCountryCenterRequest countSkillType() {
    return countSkillType("skillTypeCount");
  }

  public RetailStoreCountryCenterRequest countSkillType(String retName) {
    return countSkillType(retName, SkillTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countSkillType(SkillTypeRequest skillType) {
    return countSkillType("skillTypeCount", skillType);
  }

  public RetailStoreCountryCenterRequest countSkillType(
      String retName, SkillTypeRequest skillType) {
    skillType.count();
    return statsFromSkillType(retName, skillType);
  }

  public RetailStoreCountryCenterRequest statsFromSkillType(
      String retName, SkillTypeRequest skillType) {
    return addDynamicProperty(retName, skillType, SkillType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateResponsibilityTypeList(
      ResponsibilityTypeRequest responsibilityType) {
    aggregateChild(ResponsibilityType.COMPANY_PROPERTY, responsibilityType);
    return this;
  }

  public RetailStoreCountryCenterRequest countResponsibilityType() {
    return countResponsibilityType("responsibilityTypeCount");
  }

  public RetailStoreCountryCenterRequest countResponsibilityType(String retName) {
    return countResponsibilityType(retName, ResponsibilityTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countResponsibilityType(
      ResponsibilityTypeRequest responsibilityType) {
    return countResponsibilityType("responsibilityTypeCount", responsibilityType);
  }

  public RetailStoreCountryCenterRequest countResponsibilityType(
      String retName, ResponsibilityTypeRequest responsibilityType) {
    responsibilityType.count();
    return statsFromResponsibilityType(retName, responsibilityType);
  }

  public RetailStoreCountryCenterRequest statsFromResponsibilityType(
      String retName, ResponsibilityTypeRequest responsibilityType) {
    return addDynamicProperty(retName, responsibilityType, ResponsibilityType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateTerminationReasonList(
      TerminationReasonRequest terminationReason) {
    aggregateChild(TerminationReason.COMPANY_PROPERTY, terminationReason);
    return this;
  }

  public RetailStoreCountryCenterRequest countTerminationReason() {
    return countTerminationReason("terminationReasonCount");
  }

  public RetailStoreCountryCenterRequest countTerminationReason(String retName) {
    return countTerminationReason(retName, TerminationReasonRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countTerminationReason(
      TerminationReasonRequest terminationReason) {
    return countTerminationReason("terminationReasonCount", terminationReason);
  }

  public RetailStoreCountryCenterRequest countTerminationReason(
      String retName, TerminationReasonRequest terminationReason) {
    terminationReason.count();
    return statsFromTerminationReason(retName, terminationReason);
  }

  public RetailStoreCountryCenterRequest statsFromTerminationReason(
      String retName, TerminationReasonRequest terminationReason) {
    return addDynamicProperty(retName, terminationReason, TerminationReason.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateTerminationTypeList(
      TerminationTypeRequest terminationType) {
    aggregateChild(TerminationType.COMPANY_PROPERTY, terminationType);
    return this;
  }

  public RetailStoreCountryCenterRequest countTerminationType() {
    return countTerminationType("terminationTypeCount");
  }

  public RetailStoreCountryCenterRequest countTerminationType(String retName) {
    return countTerminationType(retName, TerminationTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countTerminationType(
      TerminationTypeRequest terminationType) {
    return countTerminationType("terminationTypeCount", terminationType);
  }

  public RetailStoreCountryCenterRequest countTerminationType(
      String retName, TerminationTypeRequest terminationType) {
    terminationType.count();
    return statsFromTerminationType(retName, terminationType);
  }

  public RetailStoreCountryCenterRequest statsFromTerminationType(
      String retName, TerminationTypeRequest terminationType) {
    return addDynamicProperty(retName, terminationType, TerminationType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateOccupationTypeList(
      OccupationTypeRequest occupationType) {
    aggregateChild(OccupationType.COMPANY_PROPERTY, occupationType);
    return this;
  }

  public RetailStoreCountryCenterRequest countOccupationType() {
    return countOccupationType("occupationTypeCount");
  }

  public RetailStoreCountryCenterRequest countOccupationType(String retName) {
    return countOccupationType(retName, OccupationTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countOccupationType(OccupationTypeRequest occupationType) {
    return countOccupationType("occupationTypeCount", occupationType);
  }

  public RetailStoreCountryCenterRequest countOccupationType(
      String retName, OccupationTypeRequest occupationType) {
    occupationType.count();
    return statsFromOccupationType(retName, occupationType);
  }

  public RetailStoreCountryCenterRequest statsFromOccupationType(
      String retName, OccupationTypeRequest occupationType) {
    return addDynamicProperty(retName, occupationType, OccupationType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateLeaveTypeList(LeaveTypeRequest leaveType) {
    aggregateChild(LeaveType.COMPANY_PROPERTY, leaveType);
    return this;
  }

  public RetailStoreCountryCenterRequest countLeaveType() {
    return countLeaveType("leaveTypeCount");
  }

  public RetailStoreCountryCenterRequest countLeaveType(String retName) {
    return countLeaveType(retName, LeaveTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countLeaveType(LeaveTypeRequest leaveType) {
    return countLeaveType("leaveTypeCount", leaveType);
  }

  public RetailStoreCountryCenterRequest countLeaveType(
      String retName, LeaveTypeRequest leaveType) {
    leaveType.count();
    return statsFromLeaveType(retName, leaveType);
  }

  public RetailStoreCountryCenterRequest statsFromLeaveType(
      String retName, LeaveTypeRequest leaveType) {
    return addDynamicProperty(retName, leaveType, LeaveType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateSalaryGradeList(SalaryGradeRequest salaryGrade) {
    aggregateChild(SalaryGrade.COMPANY_PROPERTY, salaryGrade);
    return this;
  }

  public RetailStoreCountryCenterRequest countSalaryGrade() {
    return countSalaryGrade("salaryGradeCount");
  }

  public RetailStoreCountryCenterRequest countSalaryGrade(String retName) {
    return countSalaryGrade(retName, SalaryGradeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countSalaryGrade(SalaryGradeRequest salaryGrade) {
    return countSalaryGrade("salaryGradeCount", salaryGrade);
  }

  public RetailStoreCountryCenterRequest countSalaryGrade(
      String retName, SalaryGradeRequest salaryGrade) {
    salaryGrade.count();
    return statsFromSalaryGrade(retName, salaryGrade);
  }

  public RetailStoreCountryCenterRequest statsFromSalaryGrade(
      String retName, SalaryGradeRequest salaryGrade) {
    return addDynamicProperty(retName, salaryGrade, SalaryGrade.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateInterviewTypeList(
      InterviewTypeRequest interviewType) {
    aggregateChild(InterviewType.COMPANY_PROPERTY, interviewType);
    return this;
  }

  public RetailStoreCountryCenterRequest countInterviewType() {
    return countInterviewType("interviewTypeCount");
  }

  public RetailStoreCountryCenterRequest countInterviewType(String retName) {
    return countInterviewType(retName, InterviewTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countInterviewType(InterviewTypeRequest interviewType) {
    return countInterviewType("interviewTypeCount", interviewType);
  }

  public RetailStoreCountryCenterRequest countInterviewType(
      String retName, InterviewTypeRequest interviewType) {
    interviewType.count();
    return statsFromInterviewType(retName, interviewType);
  }

  public RetailStoreCountryCenterRequest statsFromInterviewType(
      String retName, InterviewTypeRequest interviewType) {
    return addDynamicProperty(retName, interviewType, InterviewType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateTrainingCourseTypeList(
      TrainingCourseTypeRequest trainingCourseType) {
    aggregateChild(TrainingCourseType.COMPANY_PROPERTY, trainingCourseType);
    return this;
  }

  public RetailStoreCountryCenterRequest countTrainingCourseType() {
    return countTrainingCourseType("trainingCourseTypeCount");
  }

  public RetailStoreCountryCenterRequest countTrainingCourseType(String retName) {
    return countTrainingCourseType(retName, TrainingCourseTypeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countTrainingCourseType(
      TrainingCourseTypeRequest trainingCourseType) {
    return countTrainingCourseType("trainingCourseTypeCount", trainingCourseType);
  }

  public RetailStoreCountryCenterRequest countTrainingCourseType(
      String retName, TrainingCourseTypeRequest trainingCourseType) {
    trainingCourseType.count();
    return statsFromTrainingCourseType(retName, trainingCourseType);
  }

  public RetailStoreCountryCenterRequest statsFromTrainingCourseType(
      String retName, TrainingCourseTypeRequest trainingCourseType) {
    return addDynamicProperty(retName, trainingCourseType, TrainingCourseType.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregatePublicHolidayList(
      PublicHolidayRequest publicHoliday) {
    aggregateChild(PublicHoliday.COMPANY_PROPERTY, publicHoliday);
    return this;
  }

  public RetailStoreCountryCenterRequest countPublicHoliday() {
    return countPublicHoliday("publicHolidayCount");
  }

  public RetailStoreCountryCenterRequest countPublicHoliday(String retName) {
    return countPublicHoliday(retName, PublicHolidayRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countPublicHoliday(PublicHolidayRequest publicHoliday) {
    return countPublicHoliday("publicHolidayCount", publicHoliday);
  }

  public RetailStoreCountryCenterRequest countPublicHoliday(
      String retName, PublicHolidayRequest publicHoliday) {
    publicHoliday.count();
    return statsFromPublicHoliday(retName, publicHoliday);
  }

  public RetailStoreCountryCenterRequest statsFromPublicHoliday(
      String retName, PublicHolidayRequest publicHoliday) {
    return addDynamicProperty(retName, publicHoliday, PublicHoliday.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateEmployeeList(EmployeeRequest employee) {
    aggregateChild(Employee.COMPANY_PROPERTY, employee);
    return this;
  }

  public RetailStoreCountryCenterRequest countEmployee() {
    return countEmployee("employeeCount");
  }

  public RetailStoreCountryCenterRequest countEmployee(String retName) {
    return countEmployee(retName, EmployeeRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countEmployee(EmployeeRequest employee) {
    return countEmployee("employeeCount", employee);
  }

  public RetailStoreCountryCenterRequest countEmployee(String retName, EmployeeRequest employee) {
    employee.count();
    return statsFromEmployee(retName, employee);
  }

  public RetailStoreCountryCenterRequest statsFromEmployee(
      String retName, EmployeeRequest employee) {
    return addDynamicProperty(retName, employee, Employee.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateInstructorList(InstructorRequest instructor) {
    aggregateChild(Instructor.COMPANY_PROPERTY, instructor);
    return this;
  }

  public RetailStoreCountryCenterRequest countInstructor() {
    return countInstructor("instructorCount");
  }

  public RetailStoreCountryCenterRequest countInstructor(String retName) {
    return countInstructor(retName, InstructorRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countInstructor(InstructorRequest instructor) {
    return countInstructor("instructorCount", instructor);
  }

  public RetailStoreCountryCenterRequest countInstructor(
      String retName, InstructorRequest instructor) {
    instructor.count();
    return statsFromInstructor(retName, instructor);
  }

  public RetailStoreCountryCenterRequest statsFromInstructor(
      String retName, InstructorRequest instructor) {
    return addDynamicProperty(retName, instructor, Instructor.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest aggregateCompanyTrainingList(
      CompanyTrainingRequest companyTraining) {
    aggregateChild(CompanyTraining.COMPANY_PROPERTY, companyTraining);
    return this;
  }

  public RetailStoreCountryCenterRequest countCompanyTraining() {
    return countCompanyTraining("companyTrainingCount");
  }

  public RetailStoreCountryCenterRequest countCompanyTraining(String retName) {
    return countCompanyTraining(retName, CompanyTrainingRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest countCompanyTraining(
      CompanyTrainingRequest companyTraining) {
    return countCompanyTraining("companyTrainingCount", companyTraining);
  }

  public RetailStoreCountryCenterRequest countCompanyTraining(
      String retName, CompanyTrainingRequest companyTraining) {
    companyTraining.count();
    return statsFromCompanyTraining(retName, companyTraining);
  }

  public RetailStoreCountryCenterRequest statsFromCompanyTraining(
      String retName, CompanyTrainingRequest companyTraining) {
    return addDynamicProperty(retName, companyTraining, CompanyTraining.COMPANY_PROPERTY);
  }

  public RetailStoreCountryCenterRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public RetailStoreCountryCenterRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public RetailStoreCountryCenterRequest unlimited() {
    super.unlimited();
    return this;
  }

  public RetailStoreCountryCenterRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
