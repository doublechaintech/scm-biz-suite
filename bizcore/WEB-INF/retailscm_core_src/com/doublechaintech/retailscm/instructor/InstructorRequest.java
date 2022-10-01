package com.doublechaintech.retailscm.instructor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;

import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.instructor.Instructor.*;

public class InstructorRequest extends BaseRequest<Instructor> {
  public static InstructorRequest newInstance() {
    return new InstructorRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public InstructorRequest resultByClass(Class<? extends Instructor> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public InstructorRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public InstructorRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "Instructor";
  }

  public InstructorRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public InstructorRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public InstructorRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public InstructorRequest select(String... names) {
    super.select(names);
    return this;
  }

  public InstructorRequest selectAll() {
    return this.selectId()
        .selectTitle()
        .selectFamilyName()
        .selectGivenName()
        .selectCellPhone()
        .selectEmail()
        .selectCompany()
        .selectIntroduction()
        .selectLastUpdateTime()
        .selectVersion();
  }

  public InstructorRequest selectAny() {
    return selectAll().selectCompanyTrainingList(Q.companyTraining().selectSelf());
  }

  public InstructorRequest selectSelf() {
    select(ID_PROPERTY);
    select(TITLE_PROPERTY);
    select(FAMILY_NAME_PROPERTY);
    select(GIVEN_NAME_PROPERTY);
    select(CELL_PHONE_PROPERTY);
    select(EMAIL_PROPERTY);
    select(COMPANY_PROPERTY);
    select(INTRODUCTION_PROPERTY);
    select(LAST_UPDATE_TIME_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public InstructorRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public InstructorRequest where(String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {LAST_UPDATE_TIME_PROPERTY};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    TITLE_PROPERTY,
    FAMILY_NAME_PROPERTY,
    GIVEN_NAME_PROPERTY,
    CELL_PHONE_PROPERTY,
    EMAIL_PROPERTY,
    COMPANY_PROPERTY,
    INTRODUCTION_PROPERTY,
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

  public InstructorRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public InstructorRequest comment(String comment) {
    return this;
  }

  public InstructorRequest enhance() {
    return this;
  }

  public InstructorRequest overrideClass(Class<? extends Instructor> clazz) {
    return this;
  }

  public InstructorRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public InstructorRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public InstructorRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public InstructorRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public InstructorRequest count() {
    return countId("count");
  }

  public static InstructorRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public InstructorRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public InstructorRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectId() {
    return select(ID_PROPERTY);
  }

  public InstructorRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public InstructorRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public InstructorRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public InstructorRequest countId() {
    return countId("countId");
  }

  public InstructorRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public InstructorRequest maxId() {
    return maxId("maxId");
  }

  public InstructorRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public InstructorRequest minId() {
    return minId("minId");
  }

  public InstructorRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public InstructorRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public InstructorRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public InstructorRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public InstructorRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public InstructorRequest filterByTitle(String title) {

    if (title == null) {
      return this;
    }

    return filterByTitle(QueryOperator.EQUAL, title);
  }

  public InstructorRequest whereTitleIsNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereTitleIsNotNull() {
    return where(TITLE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectTitle() {
    return select(TITLE_PROPERTY);
  }

  public InstructorRequest unselectTitle() {
    return unselect(TITLE_PROPERTY);
  }

  public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByTitle(boolean asc) {
    addOrderBy(TITLE_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByTitleAscending() {
    addOrderBy(TITLE_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByTitleDescending() {
    addOrderBy(TITLE_PROPERTY, false);
    return this;
  }

  public InstructorRequest orderByTitleAscendingUsingGBK() {
    addOrderBy("convert(title using gbk)", true);
    return this;
  }

  public InstructorRequest orderByTitleDescendingUsingGBK() {
    addOrderBy("convert(title using gbk)", false);
    return this;
  }

  public InstructorRequest countTitle() {
    return countTitle("countTitle");
  }

  public InstructorRequest countTitle(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, TITLE_PROPERTY);
  }

  public InstructorRequest maxTitle() {
    return maxTitle("maxTitle");
  }

  public InstructorRequest maxTitle(String aggName) {
    return aggregate(aggName, AggFunc.MAX, TITLE_PROPERTY);
  }

  public InstructorRequest minTitle() {
    return minTitle("minTitle");
  }

  public InstructorRequest minTitle(String aggName) {
    return aggregate(aggName, AggFunc.MIN, TITLE_PROPERTY);
  }

  public InstructorRequest groupByTitle() {
    return groupByTitle(TITLE_PROPERTY);
  }

  public InstructorRequest groupByTitle(String ret) {
    return groupBy(ret, TITLE_PROPERTY);
  }

  public InstructorRequest groupByTitle(SqlFunction func) {
    return groupByTitle(TITLE_PROPERTY, func);
  }

  public InstructorRequest groupByTitle(String ret, SqlFunction func) {
    super.groupBy(ret, func, TITLE_PROPERTY);
    return this;
  }

  public InstructorRequest filterByFamilyName(String familyName) {

    if (familyName == null) {
      return this;
    }

    return filterByFamilyName(QueryOperator.EQUAL, familyName);
  }

  public InstructorRequest whereFamilyNameIsNull() {
    return where(FAMILY_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereFamilyNameIsNotNull() {
    return where(FAMILY_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest filterByFamilyName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getFamilyNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectFamilyName() {
    return select(FAMILY_NAME_PROPERTY);
  }

  public InstructorRequest unselectFamilyName() {
    return unselect(FAMILY_NAME_PROPERTY);
  }

  public SearchCriteria getFamilyNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(FAMILY_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByFamilyName(boolean asc) {
    addOrderBy(FAMILY_NAME_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByFamilyNameAscending() {
    addOrderBy(FAMILY_NAME_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByFamilyNameDescending() {
    addOrderBy(FAMILY_NAME_PROPERTY, false);
    return this;
  }

  public InstructorRequest orderByFamilyNameAscendingUsingGBK() {
    addOrderBy("convert(familyName using gbk)", true);
    return this;
  }

  public InstructorRequest orderByFamilyNameDescendingUsingGBK() {
    addOrderBy("convert(familyName using gbk)", false);
    return this;
  }

  public InstructorRequest countFamilyName() {
    return countFamilyName("countFamilyName");
  }

  public InstructorRequest countFamilyName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, FAMILY_NAME_PROPERTY);
  }

  public InstructorRequest maxFamilyName() {
    return maxFamilyName("maxFamilyName");
  }

  public InstructorRequest maxFamilyName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, FAMILY_NAME_PROPERTY);
  }

  public InstructorRequest minFamilyName() {
    return minFamilyName("minFamilyName");
  }

  public InstructorRequest minFamilyName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, FAMILY_NAME_PROPERTY);
  }

  public InstructorRequest groupByFamilyName() {
    return groupByFamilyName(FAMILY_NAME_PROPERTY);
  }

  public InstructorRequest groupByFamilyName(String ret) {
    return groupBy(ret, FAMILY_NAME_PROPERTY);
  }

  public InstructorRequest groupByFamilyName(SqlFunction func) {
    return groupByFamilyName(FAMILY_NAME_PROPERTY, func);
  }

  public InstructorRequest groupByFamilyName(String ret, SqlFunction func) {
    super.groupBy(ret, func, FAMILY_NAME_PROPERTY);
    return this;
  }

  public InstructorRequest filterByGivenName(String givenName) {

    if (givenName == null) {
      return this;
    }

    return filterByGivenName(QueryOperator.EQUAL, givenName);
  }

  public InstructorRequest whereGivenNameIsNull() {
    return where(GIVEN_NAME_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereGivenNameIsNotNull() {
    return where(GIVEN_NAME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest filterByGivenName(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getGivenNameSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectGivenName() {
    return select(GIVEN_NAME_PROPERTY);
  }

  public InstructorRequest unselectGivenName() {
    return unselect(GIVEN_NAME_PROPERTY);
  }

  public SearchCriteria getGivenNameSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(GIVEN_NAME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByGivenName(boolean asc) {
    addOrderBy(GIVEN_NAME_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByGivenNameAscending() {
    addOrderBy(GIVEN_NAME_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByGivenNameDescending() {
    addOrderBy(GIVEN_NAME_PROPERTY, false);
    return this;
  }

  public InstructorRequest orderByGivenNameAscendingUsingGBK() {
    addOrderBy("convert(givenName using gbk)", true);
    return this;
  }

  public InstructorRequest orderByGivenNameDescendingUsingGBK() {
    addOrderBy("convert(givenName using gbk)", false);
    return this;
  }

  public InstructorRequest countGivenName() {
    return countGivenName("countGivenName");
  }

  public InstructorRequest countGivenName(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, GIVEN_NAME_PROPERTY);
  }

  public InstructorRequest maxGivenName() {
    return maxGivenName("maxGivenName");
  }

  public InstructorRequest maxGivenName(String aggName) {
    return aggregate(aggName, AggFunc.MAX, GIVEN_NAME_PROPERTY);
  }

  public InstructorRequest minGivenName() {
    return minGivenName("minGivenName");
  }

  public InstructorRequest minGivenName(String aggName) {
    return aggregate(aggName, AggFunc.MIN, GIVEN_NAME_PROPERTY);
  }

  public InstructorRequest groupByGivenName() {
    return groupByGivenName(GIVEN_NAME_PROPERTY);
  }

  public InstructorRequest groupByGivenName(String ret) {
    return groupBy(ret, GIVEN_NAME_PROPERTY);
  }

  public InstructorRequest groupByGivenName(SqlFunction func) {
    return groupByGivenName(GIVEN_NAME_PROPERTY, func);
  }

  public InstructorRequest groupByGivenName(String ret, SqlFunction func) {
    super.groupBy(ret, func, GIVEN_NAME_PROPERTY);
    return this;
  }

  public InstructorRequest filterByCellPhone(String cellPhone) {

    if (cellPhone == null) {
      return this;
    }

    return filterByCellPhone(QueryOperator.EQUAL, cellPhone);
  }

  public InstructorRequest whereCellPhoneIsNull() {
    return where(CELL_PHONE_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereCellPhoneIsNotNull() {
    return where(CELL_PHONE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest filterByCellPhone(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getCellPhoneSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectCellPhone() {
    return select(CELL_PHONE_PROPERTY);
  }

  public InstructorRequest unselectCellPhone() {
    return unselect(CELL_PHONE_PROPERTY);
  }

  public SearchCriteria getCellPhoneSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(CELL_PHONE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByCellPhone(boolean asc) {
    addOrderBy(CELL_PHONE_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByCellPhoneAscending() {
    addOrderBy(CELL_PHONE_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByCellPhoneDescending() {
    addOrderBy(CELL_PHONE_PROPERTY, false);
    return this;
  }

  public InstructorRequest orderByCellPhoneAscendingUsingGBK() {
    addOrderBy("convert(cellPhone using gbk)", true);
    return this;
  }

  public InstructorRequest orderByCellPhoneDescendingUsingGBK() {
    addOrderBy("convert(cellPhone using gbk)", false);
    return this;
  }

  public InstructorRequest countCellPhone() {
    return countCellPhone("countCellPhone");
  }

  public InstructorRequest countCellPhone(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CELL_PHONE_PROPERTY);
  }

  public InstructorRequest maxCellPhone() {
    return maxCellPhone("maxCellPhone");
  }

  public InstructorRequest maxCellPhone(String aggName) {
    return aggregate(aggName, AggFunc.MAX, CELL_PHONE_PROPERTY);
  }

  public InstructorRequest minCellPhone() {
    return minCellPhone("minCellPhone");
  }

  public InstructorRequest minCellPhone(String aggName) {
    return aggregate(aggName, AggFunc.MIN, CELL_PHONE_PROPERTY);
  }

  public InstructorRequest groupByCellPhone() {
    return groupByCellPhone(CELL_PHONE_PROPERTY);
  }

  public InstructorRequest groupByCellPhone(String ret) {
    return groupBy(ret, CELL_PHONE_PROPERTY);
  }

  public InstructorRequest groupByCellPhone(SqlFunction func) {
    return groupByCellPhone(CELL_PHONE_PROPERTY, func);
  }

  public InstructorRequest groupByCellPhone(String ret, SqlFunction func) {
    super.groupBy(ret, func, CELL_PHONE_PROPERTY);
    return this;
  }

  public InstructorRequest filterByEmail(String email) {

    if (email == null) {
      return this;
    }

    return filterByEmail(QueryOperator.EQUAL, email);
  }

  public InstructorRequest whereEmailIsNull() {
    return where(EMAIL_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereEmailIsNotNull() {
    return where(EMAIL_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest filterByEmail(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getEmailSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectEmail() {
    return select(EMAIL_PROPERTY);
  }

  public InstructorRequest unselectEmail() {
    return unselect(EMAIL_PROPERTY);
  }

  public SearchCriteria getEmailSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(EMAIL_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByEmail(boolean asc) {
    addOrderBy(EMAIL_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByEmailAscending() {
    addOrderBy(EMAIL_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByEmailDescending() {
    addOrderBy(EMAIL_PROPERTY, false);
    return this;
  }

  public InstructorRequest orderByEmailAscendingUsingGBK() {
    addOrderBy("convert(email using gbk)", true);
    return this;
  }

  public InstructorRequest orderByEmailDescendingUsingGBK() {
    addOrderBy("convert(email using gbk)", false);
    return this;
  }

  public InstructorRequest countEmail() {
    return countEmail("countEmail");
  }

  public InstructorRequest countEmail(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMAIL_PROPERTY);
  }

  public InstructorRequest maxEmail() {
    return maxEmail("maxEmail");
  }

  public InstructorRequest maxEmail(String aggName) {
    return aggregate(aggName, AggFunc.MAX, EMAIL_PROPERTY);
  }

  public InstructorRequest minEmail() {
    return minEmail("minEmail");
  }

  public InstructorRequest minEmail(String aggName) {
    return aggregate(aggName, AggFunc.MIN, EMAIL_PROPERTY);
  }

  public InstructorRequest groupByEmail() {
    return groupByEmail(EMAIL_PROPERTY);
  }

  public InstructorRequest groupByEmail(String ret) {
    return groupBy(ret, EMAIL_PROPERTY);
  }

  public InstructorRequest groupByEmail(SqlFunction func) {
    return groupByEmail(EMAIL_PROPERTY, func);
  }

  public InstructorRequest groupByEmail(String ret, SqlFunction func) {
    super.groupBy(ret, func, EMAIL_PROPERTY);
    return this;
  }

  public InstructorRequest filterByIntroduction(String introduction) {

    if (introduction == null) {
      return this;
    }

    return filterByIntroduction(QueryOperator.EQUAL, introduction);
  }

  public InstructorRequest whereIntroductionIsNull() {
    return where(INTRODUCTION_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereIntroductionIsNotNull() {
    return where(INTRODUCTION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest filterByIntroduction(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIntroductionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectIntroduction() {
    return select(INTRODUCTION_PROPERTY);
  }

  public InstructorRequest unselectIntroduction() {
    return unselect(INTRODUCTION_PROPERTY);
  }

  public SearchCriteria getIntroductionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(INTRODUCTION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByIntroduction(boolean asc) {
    addOrderBy(INTRODUCTION_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByIntroductionAscending() {
    addOrderBy(INTRODUCTION_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByIntroductionDescending() {
    addOrderBy(INTRODUCTION_PROPERTY, false);
    return this;
  }

  public InstructorRequest orderByIntroductionAscendingUsingGBK() {
    addOrderBy("convert(introduction using gbk)", true);
    return this;
  }

  public InstructorRequest orderByIntroductionDescendingUsingGBK() {
    addOrderBy("convert(introduction using gbk)", false);
    return this;
  }

  public InstructorRequest countIntroduction() {
    return countIntroduction("countIntroduction");
  }

  public InstructorRequest countIntroduction(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, INTRODUCTION_PROPERTY);
  }

  public InstructorRequest maxIntroduction() {
    return maxIntroduction("maxIntroduction");
  }

  public InstructorRequest maxIntroduction(String aggName) {
    return aggregate(aggName, AggFunc.MAX, INTRODUCTION_PROPERTY);
  }

  public InstructorRequest minIntroduction() {
    return minIntroduction("minIntroduction");
  }

  public InstructorRequest minIntroduction(String aggName) {
    return aggregate(aggName, AggFunc.MIN, INTRODUCTION_PROPERTY);
  }

  public InstructorRequest groupByIntroduction() {
    return groupByIntroduction(INTRODUCTION_PROPERTY);
  }

  public InstructorRequest groupByIntroduction(String ret) {
    return groupBy(ret, INTRODUCTION_PROPERTY);
  }

  public InstructorRequest groupByIntroduction(SqlFunction func) {
    return groupByIntroduction(INTRODUCTION_PROPERTY, func);
  }

  public InstructorRequest groupByIntroduction(String ret, SqlFunction func) {
    super.groupBy(ret, func, INTRODUCTION_PROPERTY);
    return this;
  }

  public InstructorRequest filterByLastUpdateTime(DateTime lastUpdateTime) {

    if (lastUpdateTime == null) {
      return this;
    }

    return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
  }

  public InstructorRequest whereLastUpdateTimeIsNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereLastUpdateTimeIsNotNull() {
    return where(LAST_UPDATE_TIME_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest whereLastUpdateTimeBetween(
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

  public InstructorRequest whereLastUpdateTimeBefore(Date lastUpdateTime) {

    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeBefore, the parameter lastUpdateTime is not allowed  to be null.");
    }

    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.LESS_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest whereLastUpdateTimeAfter(DateTime lastUpdateTime) {
    if (ObjectUtil.isEmpty(lastUpdateTime)) {
      throw new IllegalArgumentException(
          "Method whereLastUpdateTimeAfter, the parameter lastUpdateTime is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getLastUpdateTimeSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {lastUpdateTime});
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest filterByLastUpdateTime(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectLastUpdateTime() {
    return select(LAST_UPDATE_TIME_PROPERTY);
  }

  public InstructorRequest unselectLastUpdateTime() {
    return unselect(LAST_UPDATE_TIME_PROPERTY);
  }

  public SearchCriteria getLastUpdateTimeSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByLastUpdateTime(boolean asc) {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByLastUpdateTimeAscending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByLastUpdateTimeDescending() {
    addOrderBy(LAST_UPDATE_TIME_PROPERTY, false);
    return this;
  }

  public InstructorRequest countLastUpdateTime() {
    return countLastUpdateTime("countLastUpdateTime");
  }

  public InstructorRequest countLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, LAST_UPDATE_TIME_PROPERTY);
  }

  public InstructorRequest maxLastUpdateTime() {
    return maxLastUpdateTime("maxLastUpdateTime");
  }

  public InstructorRequest maxLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MAX, LAST_UPDATE_TIME_PROPERTY);
  }

  public InstructorRequest minLastUpdateTime() {
    return minLastUpdateTime("minLastUpdateTime");
  }

  public InstructorRequest minLastUpdateTime(String aggName) {
    return aggregate(aggName, AggFunc.MIN, LAST_UPDATE_TIME_PROPERTY);
  }

  public InstructorRequest groupByLastUpdateTime() {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY);
  }

  public InstructorRequest groupByLastUpdateTime(String ret) {
    return groupBy(ret, LAST_UPDATE_TIME_PROPERTY);
  }

  public InstructorRequest groupByLastUpdateTime(SqlFunction func) {
    return groupByLastUpdateTime(LAST_UPDATE_TIME_PROPERTY, func);
  }

  public InstructorRequest groupByLastUpdateTime(String ret, SqlFunction func) {
    super.groupBy(ret, func, LAST_UPDATE_TIME_PROPERTY);
    return this;
  }

  public InstructorRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public InstructorRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public InstructorRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public InstructorRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public InstructorRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public InstructorRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public InstructorRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public InstructorRequest countVersion() {
    return countVersion("countVersion");
  }

  public InstructorRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public InstructorRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public InstructorRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public InstructorRequest minVersion() {
    return minVersion("minVersion");
  }

  public InstructorRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public InstructorRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public InstructorRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public InstructorRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public InstructorRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public InstructorRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public InstructorRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public InstructorRequest filterByCompany(RetailStoreCountryCenterRequest company) {
    return filterByCompany(company, RetailStoreCountryCenter::getId);
  }

  public InstructorRequest filterByCompany(RetailStoreCountryCenter... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException(
          "filterByCompany(RetailStoreCountryCenter... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public InstructorRequest selectCompanyId() {
    select(COMPANY_PROPERTY);
    return this;
  }

  public RetailStoreCountryCenterRequest upToCompany() {
    return upToCompany(RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest upToCompany(RetailStoreCountryCenterRequest company) {
    company.aggregateChild(COMPANY_PROPERTY, this);
    this.groupByCompany(company);
    return company;
  }

  public RetailStoreCountryCenterRequest endAtCompany(String retName) {
    return endAtCompany(retName, RetailStoreCountryCenterRequest.newInstance());
  }

  public RetailStoreCountryCenterRequest endAtCompany(
      String retName, RetailStoreCountryCenterRequest company) {
    company.addDynamicProperty(retName, this, COMPANY_PROPERTY);
    return company;
  }

  public InstructorRequest filterByCompany(String... company) {
    if (isEmptyParam(company)) {
      throw new IllegalArgumentException("filterByCompany(String... company)参数不能为空!");
    }
    return where(COMPANY_PROPERTY, QueryOperator.IN, (Object[]) company);
  }

  public InstructorRequest filterByCompany(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    company.unlimited();
    return addSearchCriteria(createCompanyCriteria(company, idRefine));
  }

  public SearchCriteria createCompanyCriteria(
      RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
    return new RefinedIdInCriteria(
        company, COMPANY_PROPERTY, idRefine, RetailStoreCountryCenter.ID_PROPERTY);
  }

  public InstructorRequest selectCompany() {
    return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
  }

  public InstructorRequest selectCompany(RetailStoreCountryCenterRequest company) {
    selectParent(COMPANY_PROPERTY, company);
    return this;
  }

  public InstructorRequest unselectCompany() {
    unselectParent(COMPANY_PROPERTY);
    return this;
  }

  public InstructorRequest groupByCompany(RetailStoreCountryCenterRequest company) {
    groupBy(COMPANY_PROPERTY, company);
    return this;
  }

  public InstructorRequest aggregateCompany(RetailStoreCountryCenterRequest company) {
    aggregateParent(COMPANY_PROPERTY, company);
    return this;
  }

  public InstructorRequest countCompany() {
    return countCompany("countCompany");
  }

  public InstructorRequest countCompany(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, COMPANY_PROPERTY);
  }

  public InstructorRequest groupByCompany() {
    return groupByCompany(COMPANY_PROPERTY);
  }

  public InstructorRequest groupByCompany(String ret) {
    return groupBy(ret, COMPANY_PROPERTY);
  }

  public InstructorRequest whereCompanyIsNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NULL);
  }

  public InstructorRequest whereCompanyIsNotNull() {
    return where(COMPANY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public InstructorRequest hasCompanyTraining() {
    return hasCompanyTraining(CompanyTrainingRequest.newInstance());
  }

  public InstructorRequest hasCompanyTraining(CompanyTraining... companyTraining) {
    if (isEmptyParam(companyTraining)) {
      throw new IllegalArgumentException(
          "hasCompanyTraining(CompanyTraining... companyTraining)参数不能为空!");
    }
    return hasCompanyTraining(
        Q.companyTraining()
            .select(CompanyTraining.INSTRUCTOR_PROPERTY)
            .filterById(QueryOperator.IN, (Object[]) companyTraining));
  }

  public InstructorRequest hasCompanyTraining(String... companyTraining) {
    return hasCompanyTraining(
        Q.companyTraining()
            .select(CompanyTraining.INSTRUCTOR_PROPERTY)
            .filterById(companyTraining));
  }

  public InstructorRequest hasCompanyTraining(CompanyTrainingRequest companyTraining) {
    return hasCompanyTraining(
        companyTraining,
        $companyTraining ->
            java.util.Optional.of($companyTraining)
                .map(CompanyTraining::getInstructor)
                .map(Instructor::getId)
                .orElse(null));
  }

  public InstructorRequest hasCompanyTraining(
      CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
    companyTraining.select(CompanyTraining.INSTRUCTOR_PROPERTY);
    companyTraining.unlimited();
    return addSearchCriteria(createCompanyTrainingCriteria(companyTraining, idRefine));
  }

  public InstructorRequest hasCompanyTraining(
      CompanyTrainingRequest companyTraining, QueryOperator queryOperator, Object value) {
    return addSearchCriteria(
        new AggregationCriteria(
            companyTraining, CompanyTraining.INSTRUCTOR_PROPERTY, queryOperator, value));
  }

  public SearchCriteria createCompanyTrainingCriteria(
      CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
    return new RefinedIdInCriteria(
        companyTraining, ID_PROPERTY, idRefine, CompanyTraining.INSTRUCTOR_PROPERTY);
  }

  public InstructorRequest selectCompanyTrainingList(CompanyTrainingRequest companyTraining) {
    selectChild(CompanyTraining.INSTRUCTOR_PROPERTY, companyTraining);
    return this;
  }

  public InstructorRequest selectCompanyTrainingList() {
    return selectCompanyTrainingList(CompanyTrainingRequest.newInstance().selectAll());
  }

  public InstructorRequest unselectCompanyTrainingList() {
    unselectChild(CompanyTraining.INSTRUCTOR_PROPERTY, CompanyTraining.class);
    return this;
  }

  public InstructorRequest aggregateCompanyTrainingList(CompanyTrainingRequest companyTraining) {
    aggregateChild(CompanyTraining.INSTRUCTOR_PROPERTY, companyTraining);
    return this;
  }

  public InstructorRequest countCompanyTraining() {
    return countCompanyTraining("companyTrainingCount");
  }

  public InstructorRequest countCompanyTraining(String retName) {
    return countCompanyTraining(retName, CompanyTrainingRequest.newInstance());
  }

  public InstructorRequest countCompanyTraining(CompanyTrainingRequest companyTraining) {
    return countCompanyTraining("companyTrainingCount", companyTraining);
  }

  public InstructorRequest countCompanyTraining(
      String retName, CompanyTrainingRequest companyTraining) {
    companyTraining.count();
    return statsFromCompanyTraining(retName, companyTraining);
  }

  public InstructorRequest statsFromCompanyTraining(
      String retName, CompanyTrainingRequest companyTraining) {
    return addDynamicProperty(retName, companyTraining, CompanyTraining.INSTRUCTOR_PROPERTY);
  }

  public InstructorRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public InstructorRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public InstructorRequest unlimited() {
    super.unlimited();
    return this;
  }

  public InstructorRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
