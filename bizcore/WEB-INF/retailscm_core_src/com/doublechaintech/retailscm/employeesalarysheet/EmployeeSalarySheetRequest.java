package com.doublechaintech.retailscm.employeesalarysheet;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import cn.hutool.core.util.ObjectUtil;
import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.payingoff.PayingOffRequest;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest;

import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet.*;

public class EmployeeSalarySheetRequest extends BaseRequest<EmployeeSalarySheet> {
  public static EmployeeSalarySheetRequest newInstance() {
    return new EmployeeSalarySheetRequest()
        .filterByVersion(QueryOperator.GREATER_THAN, 0)
        .selectId()
        .selectVersion();
  }

  public EmployeeSalarySheetRequest resultByClass(Class<? extends EmployeeSalarySheet> clazz) {
    overrideResultByClass(clazz);
    return this;
  }

  public EmployeeSalarySheetRequest includeDarknessRows() {
    removeAllVersionCriteria();
    return this;
  }

  public EmployeeSalarySheetRequest onlyDarknessRows() {
    return filterByVersion(QueryOperator.LESS_THAN, 0);
  }

  public String getInternalType() {
    return "EmployeeSalarySheet";
  }

  public EmployeeSalarySheetRequest findWithJson(JsonNode jsonExpr) {
    this.mergeClauses(jsonExpr);
    return this;
  }

  public EmployeeSalarySheetRequest addDynamicProperty(
      String propertyName, BaseRequest request, String parentPropertyName) {
    getDynamicAttributes()
        .add(new DynamicAttributeRequest(propertyName, request, parentPropertyName));
    return this;
  }

  public EmployeeSalarySheetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
    doAddSearchCriteria(pSearchCriteria);
    return this;
  }

  public EmployeeSalarySheetRequest select(String... names) {
    super.select(names);
    return this;
  }

  public EmployeeSalarySheetRequest selectAll() {
    return this.selectId()
        .selectEmployee()
        .selectCurrentSalaryGrade()
        .selectBaseSalary()
        .selectBonus()
        .selectReward()
        .selectPersonalTax()
        .selectSocialSecurity()
        .selectHousingFound()
        .selectJobInsurance()
        .selectPayingOff()
        .selectVersion();
  }

  public EmployeeSalarySheetRequest selectAny() {
    return selectAll();
  }

  public EmployeeSalarySheetRequest selectSelf() {
    select(ID_PROPERTY);
    select(EMPLOYEE_PROPERTY);
    select(CURRENT_SALARY_GRADE_PROPERTY);
    select(BASE_SALARY_PROPERTY);
    select(BONUS_PROPERTY);
    select(REWARD_PROPERTY);
    select(PERSONAL_TAX_PROPERTY);
    select(SOCIAL_SECURITY_PROPERTY);
    select(HOUSING_FOUND_PROPERTY);
    select(JOB_INSURANCE_PROPERTY);
    select(PAYING_OFF_PROPERTY);
    select(VERSION_PROPERTY);

    return this;
  }

  public EmployeeSalarySheetRequest unselect(String... names) {
    super.unselect(names);
    return this;
  }

  public EmployeeSalarySheetRequest where(
      String property, QueryOperator pQueryOperator, Object... pValue) {
    if (pQueryOperator.isNoOperator()) {
      return this;
    }
    return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
  }

  protected static final String[] DATE_OR_TIME_FIELDS = {};
  protected static final String[] ALL_SELF_FIELDS = {
    ID_PROPERTY,
    EMPLOYEE_PROPERTY,
    CURRENT_SALARY_GRADE_PROPERTY,
    BASE_SALARY_PROPERTY,
    BONUS_PROPERTY,
    REWARD_PROPERTY,
    PERSONAL_TAX_PROPERTY,
    SOCIAL_SECURITY_PROPERTY,
    HOUSING_FOUND_PROPERTY,
    JOB_INSURANCE_PROPERTY,
    PAYING_OFF_PROPERTY,
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

  public EmployeeSalarySheetRequest where(JsonNode jsonNode) {
    this.addJsonFilter(jsonNode);
    return this;
  }

  public EmployeeSalarySheetRequest comment(String comment) {
    return this;
  }

  public EmployeeSalarySheetRequest enhance() {
    return this;
  }

  public EmployeeSalarySheetRequest overrideClass(Class<? extends EmployeeSalarySheet> clazz) {
    return this;
  }

  public EmployeeSalarySheetRequest aggregate(String aggName, AggFunc fuc, String... properties) {
    super.aggregate(aggName, fuc, properties);
    return this;
  }

  public EmployeeSalarySheetRequest groupBy(String retName, String propertyName) {
    super.groupBy(retName, SqlFunction.SELF, propertyName);
    return this;
  }

  public EmployeeSalarySheetRequest groupBy(String propertyName) {
    super.groupBy(propertyName);
    return this;
  }

  public EmployeeSalarySheetRequest groupBy(String ret, SqlFunction fun, String... properties) {
    super.groupBy(ret, fun, properties);
    return this;
  }

  public EmployeeSalarySheetRequest count() {
    return countId("count");
  }

  public static EmployeeSalarySheetRequest withId(String... id) {
    return newInstance().filterById(id).selectAll();
  }

  public EmployeeSalarySheetRequest filterById(String... id) {
    if (isEmptyParam(id)) {
      throw new IllegalArgumentException("filterById(String... id)参数不能为空!");
    }
    return filterById(QueryOperator.IN, (Object[]) id);
  }

  public EmployeeSalarySheetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectId() {
    return select(ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectId() {
    return unselect(ID_PROPERTY);
  }

  public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderById(boolean asc) {
    addOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByIdAscending() {
    addOrderBy(ID_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByIdDescending() {
    addOrderBy(ID_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest orderByIdAscendingUsingGBK() {
    addOrderBy("convert(id using gbk)", true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByIdDescendingUsingGBK() {
    addOrderBy("convert(id using gbk)", false);
    return this;
  }

  public EmployeeSalarySheetRequest countId() {
    return countId("countId");
  }

  public EmployeeSalarySheetRequest countId(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxId() {
    return maxId("maxId");
  }

  public EmployeeSalarySheetRequest maxId(String aggName) {
    return aggregate(aggName, AggFunc.MAX, ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest minId() {
    return minId("minId");
  }

  public EmployeeSalarySheetRequest minId(String aggName) {
    return aggregate(aggName, AggFunc.MIN, ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupById() {
    return groupById(ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupById(String ret) {
    return groupBy(ret, ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupById(SqlFunction func) {
    return groupById(ID_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupById(String ret, SqlFunction func) {
    super.groupBy(ret, func, ID_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByBaseSalary(BigDecimal baseSalary) {

    if (baseSalary == null) {
      return this;
    }

    return filterByBaseSalary(QueryOperator.EQUAL, baseSalary);
  }

  public EmployeeSalarySheetRequest whereBaseSalaryIsNull() {
    return where(BASE_SALARY_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereBaseSalaryIsNotNull() {
    return where(BASE_SALARY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest whereBaseSalaryBetween(
      BigDecimal baseSalaryStart, BigDecimal baseSalaryEnd) {
    if (ObjectUtil.isEmpty(baseSalaryStart)) {
      throw new IllegalArgumentException(
          "Method whereBaseSalaryBetween, the parameter baseSalaryStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(baseSalaryEnd)) {
      throw new IllegalArgumentException(
          "Method whereBaseSalaryBetween, the parameter baseSalaryEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBaseSalarySearchCriteria(
            QueryOperator.BETWEEN, new Object[] {baseSalaryStart, baseSalaryEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereBaseSalaryLessThan(BigDecimal baseSalary) {
    if (ObjectUtil.isEmpty(baseSalary)) {
      throw new IllegalArgumentException(
          "Method whereBaseSalaryLessThan, the parameter baseSalary is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBaseSalarySearchCriteria(QueryOperator.LESS_THAN, new Object[] {baseSalary});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereBaseSalaryGreaterThan(BigDecimal baseSalary) {
    if (ObjectUtil.isEmpty(baseSalary)) {
      throw new IllegalArgumentException(
          "Method whereBaseSalaryGreaterThan, the parameter baseSalary is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBaseSalarySearchCriteria(QueryOperator.GREATER_THAN, new Object[] {baseSalary});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest filterByBaseSalary(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBaseSalarySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectBaseSalary() {
    return select(BASE_SALARY_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectBaseSalary() {
    return unselect(BASE_SALARY_PROPERTY);
  }

  public SearchCriteria getBaseSalarySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BASE_SALARY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderByBaseSalary(boolean asc) {
    addOrderBy(BASE_SALARY_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByBaseSalaryAscending() {
    addOrderBy(BASE_SALARY_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByBaseSalaryDescending() {
    addOrderBy(BASE_SALARY_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countBaseSalary() {
    return countBaseSalary("countBaseSalary");
  }

  public EmployeeSalarySheetRequest countBaseSalary(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BASE_SALARY_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxBaseSalary() {
    return maxBaseSalary("maxBaseSalary");
  }

  public EmployeeSalarySheetRequest maxBaseSalary(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BASE_SALARY_PROPERTY);
  }

  public EmployeeSalarySheetRequest minBaseSalary() {
    return minBaseSalary("minBaseSalary");
  }

  public EmployeeSalarySheetRequest minBaseSalary(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BASE_SALARY_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumBaseSalary() {
    return sumBaseSalary("sumBaseSalary");
  }

  public EmployeeSalarySheetRequest sumBaseSalary(String aggName) {
    return aggregate(aggName, AggFunc.SUM, BASE_SALARY_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByBaseSalary() {
    return groupByBaseSalary(BASE_SALARY_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByBaseSalary(String ret) {
    return groupBy(ret, BASE_SALARY_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByBaseSalary(SqlFunction func) {
    return groupByBaseSalary(BASE_SALARY_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupByBaseSalary(String ret, SqlFunction func) {
    super.groupBy(ret, func, BASE_SALARY_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByBonus(BigDecimal bonus) {

    if (bonus == null) {
      return this;
    }

    return filterByBonus(QueryOperator.EQUAL, bonus);
  }

  public EmployeeSalarySheetRequest whereBonusIsNull() {
    return where(BONUS_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereBonusIsNotNull() {
    return where(BONUS_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest whereBonusBetween(BigDecimal bonusStart, BigDecimal bonusEnd) {
    if (ObjectUtil.isEmpty(bonusStart)) {
      throw new IllegalArgumentException(
          "Method whereBonusBetween, the parameter bonusStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(bonusEnd)) {
      throw new IllegalArgumentException(
          "Method whereBonusBetween, the parameter bonusEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBonusSearchCriteria(QueryOperator.BETWEEN, new Object[] {bonusStart, bonusEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereBonusLessThan(BigDecimal bonus) {
    if (ObjectUtil.isEmpty(bonus)) {
      throw new IllegalArgumentException(
          "Method whereBonusLessThan, the parameter bonus is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBonusSearchCriteria(QueryOperator.LESS_THAN, new Object[] {bonus});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereBonusGreaterThan(BigDecimal bonus) {
    if (ObjectUtil.isEmpty(bonus)) {
      throw new IllegalArgumentException(
          "Method whereBonusGreaterThan, the parameter bonus is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getBonusSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {bonus});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest filterByBonus(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getBonusSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectBonus() {
    return select(BONUS_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectBonus() {
    return unselect(BONUS_PROPERTY);
  }

  public SearchCriteria getBonusSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(BONUS_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderByBonus(boolean asc) {
    addOrderBy(BONUS_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByBonusAscending() {
    addOrderBy(BONUS_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByBonusDescending() {
    addOrderBy(BONUS_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countBonus() {
    return countBonus("countBonus");
  }

  public EmployeeSalarySheetRequest countBonus(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, BONUS_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxBonus() {
    return maxBonus("maxBonus");
  }

  public EmployeeSalarySheetRequest maxBonus(String aggName) {
    return aggregate(aggName, AggFunc.MAX, BONUS_PROPERTY);
  }

  public EmployeeSalarySheetRequest minBonus() {
    return minBonus("minBonus");
  }

  public EmployeeSalarySheetRequest minBonus(String aggName) {
    return aggregate(aggName, AggFunc.MIN, BONUS_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumBonus() {
    return sumBonus("sumBonus");
  }

  public EmployeeSalarySheetRequest sumBonus(String aggName) {
    return aggregate(aggName, AggFunc.SUM, BONUS_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByBonus() {
    return groupByBonus(BONUS_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByBonus(String ret) {
    return groupBy(ret, BONUS_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByBonus(SqlFunction func) {
    return groupByBonus(BONUS_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupByBonus(String ret, SqlFunction func) {
    super.groupBy(ret, func, BONUS_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByReward(BigDecimal reward) {

    if (reward == null) {
      return this;
    }

    return filterByReward(QueryOperator.EQUAL, reward);
  }

  public EmployeeSalarySheetRequest whereRewardIsNull() {
    return where(REWARD_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereRewardIsNotNull() {
    return where(REWARD_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest whereRewardBetween(
      BigDecimal rewardStart, BigDecimal rewardEnd) {
    if (ObjectUtil.isEmpty(rewardStart)) {
      throw new IllegalArgumentException(
          "Method whereRewardBetween, the parameter rewardStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(rewardEnd)) {
      throw new IllegalArgumentException(
          "Method whereRewardBetween, the parameter rewardEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRewardSearchCriteria(QueryOperator.BETWEEN, new Object[] {rewardStart, rewardEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereRewardLessThan(BigDecimal reward) {
    if (ObjectUtil.isEmpty(reward)) {
      throw new IllegalArgumentException(
          "Method whereRewardLessThan, the parameter reward is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRewardSearchCriteria(QueryOperator.LESS_THAN, new Object[] {reward});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereRewardGreaterThan(BigDecimal reward) {
    if (ObjectUtil.isEmpty(reward)) {
      throw new IllegalArgumentException(
          "Method whereRewardGreaterThan, the parameter reward is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getRewardSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {reward});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest filterByReward(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getRewardSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectReward() {
    return select(REWARD_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectReward() {
    return unselect(REWARD_PROPERTY);
  }

  public SearchCriteria getRewardSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(REWARD_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderByReward(boolean asc) {
    addOrderBy(REWARD_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByRewardAscending() {
    addOrderBy(REWARD_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByRewardDescending() {
    addOrderBy(REWARD_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countReward() {
    return countReward("countReward");
  }

  public EmployeeSalarySheetRequest countReward(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, REWARD_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxReward() {
    return maxReward("maxReward");
  }

  public EmployeeSalarySheetRequest maxReward(String aggName) {
    return aggregate(aggName, AggFunc.MAX, REWARD_PROPERTY);
  }

  public EmployeeSalarySheetRequest minReward() {
    return minReward("minReward");
  }

  public EmployeeSalarySheetRequest minReward(String aggName) {
    return aggregate(aggName, AggFunc.MIN, REWARD_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumReward() {
    return sumReward("sumReward");
  }

  public EmployeeSalarySheetRequest sumReward(String aggName) {
    return aggregate(aggName, AggFunc.SUM, REWARD_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByReward() {
    return groupByReward(REWARD_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByReward(String ret) {
    return groupBy(ret, REWARD_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByReward(SqlFunction func) {
    return groupByReward(REWARD_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupByReward(String ret, SqlFunction func) {
    super.groupBy(ret, func, REWARD_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByPersonalTax(BigDecimal personalTax) {

    if (personalTax == null) {
      return this;
    }

    return filterByPersonalTax(QueryOperator.EQUAL, personalTax);
  }

  public EmployeeSalarySheetRequest wherePersonalTaxIsNull() {
    return where(PERSONAL_TAX_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest wherePersonalTaxIsNotNull() {
    return where(PERSONAL_TAX_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest wherePersonalTaxBetween(
      BigDecimal personalTaxStart, BigDecimal personalTaxEnd) {
    if (ObjectUtil.isEmpty(personalTaxStart)) {
      throw new IllegalArgumentException(
          "Method wherePersonalTaxBetween, the parameter personalTaxStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(personalTaxEnd)) {
      throw new IllegalArgumentException(
          "Method wherePersonalTaxBetween, the parameter personalTaxEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPersonalTaxSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {personalTaxStart, personalTaxEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest wherePersonalTaxLessThan(BigDecimal personalTax) {
    if (ObjectUtil.isEmpty(personalTax)) {
      throw new IllegalArgumentException(
          "Method wherePersonalTaxLessThan, the parameter personalTax is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPersonalTaxSearchCriteria(QueryOperator.LESS_THAN, new Object[] {personalTax});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest wherePersonalTaxGreaterThan(BigDecimal personalTax) {
    if (ObjectUtil.isEmpty(personalTax)) {
      throw new IllegalArgumentException(
          "Method wherePersonalTaxGreaterThan, the parameter personalTax is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getPersonalTaxSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {personalTax});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest filterByPersonalTax(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getPersonalTaxSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectPersonalTax() {
    return select(PERSONAL_TAX_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectPersonalTax() {
    return unselect(PERSONAL_TAX_PROPERTY);
  }

  public SearchCriteria getPersonalTaxSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(PERSONAL_TAX_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderByPersonalTax(boolean asc) {
    addOrderBy(PERSONAL_TAX_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByPersonalTaxAscending() {
    addOrderBy(PERSONAL_TAX_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByPersonalTaxDescending() {
    addOrderBy(PERSONAL_TAX_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countPersonalTax() {
    return countPersonalTax("countPersonalTax");
  }

  public EmployeeSalarySheetRequest countPersonalTax(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PERSONAL_TAX_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxPersonalTax() {
    return maxPersonalTax("maxPersonalTax");
  }

  public EmployeeSalarySheetRequest maxPersonalTax(String aggName) {
    return aggregate(aggName, AggFunc.MAX, PERSONAL_TAX_PROPERTY);
  }

  public EmployeeSalarySheetRequest minPersonalTax() {
    return minPersonalTax("minPersonalTax");
  }

  public EmployeeSalarySheetRequest minPersonalTax(String aggName) {
    return aggregate(aggName, AggFunc.MIN, PERSONAL_TAX_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumPersonalTax() {
    return sumPersonalTax("sumPersonalTax");
  }

  public EmployeeSalarySheetRequest sumPersonalTax(String aggName) {
    return aggregate(aggName, AggFunc.SUM, PERSONAL_TAX_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByPersonalTax() {
    return groupByPersonalTax(PERSONAL_TAX_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByPersonalTax(String ret) {
    return groupBy(ret, PERSONAL_TAX_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByPersonalTax(SqlFunction func) {
    return groupByPersonalTax(PERSONAL_TAX_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupByPersonalTax(String ret, SqlFunction func) {
    super.groupBy(ret, func, PERSONAL_TAX_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterBySocialSecurity(BigDecimal socialSecurity) {

    if (socialSecurity == null) {
      return this;
    }

    return filterBySocialSecurity(QueryOperator.EQUAL, socialSecurity);
  }

  public EmployeeSalarySheetRequest whereSocialSecurityIsNull() {
    return where(SOCIAL_SECURITY_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereSocialSecurityIsNotNull() {
    return where(SOCIAL_SECURITY_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest whereSocialSecurityBetween(
      BigDecimal socialSecurityStart, BigDecimal socialSecurityEnd) {
    if (ObjectUtil.isEmpty(socialSecurityStart)) {
      throw new IllegalArgumentException(
          "Method whereSocialSecurityBetween, the parameter socialSecurityStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(socialSecurityEnd)) {
      throw new IllegalArgumentException(
          "Method whereSocialSecurityBetween, the parameter socialSecurityEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getSocialSecuritySearchCriteria(
            QueryOperator.BETWEEN, new Object[] {socialSecurityStart, socialSecurityEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereSocialSecurityLessThan(BigDecimal socialSecurity) {
    if (ObjectUtil.isEmpty(socialSecurity)) {
      throw new IllegalArgumentException(
          "Method whereSocialSecurityLessThan, the parameter socialSecurity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getSocialSecuritySearchCriteria(QueryOperator.LESS_THAN, new Object[] {socialSecurity});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereSocialSecurityGreaterThan(BigDecimal socialSecurity) {
    if (ObjectUtil.isEmpty(socialSecurity)) {
      throw new IllegalArgumentException(
          "Method whereSocialSecurityGreaterThan, the parameter socialSecurity is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getSocialSecuritySearchCriteria(QueryOperator.GREATER_THAN, new Object[] {socialSecurity});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest filterBySocialSecurity(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getSocialSecuritySearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectSocialSecurity() {
    return select(SOCIAL_SECURITY_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectSocialSecurity() {
    return unselect(SOCIAL_SECURITY_PROPERTY);
  }

  public SearchCriteria getSocialSecuritySearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(SOCIAL_SECURITY_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderBySocialSecurity(boolean asc) {
    addOrderBy(SOCIAL_SECURITY_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderBySocialSecurityAscending() {
    addOrderBy(SOCIAL_SECURITY_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderBySocialSecurityDescending() {
    addOrderBy(SOCIAL_SECURITY_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countSocialSecurity() {
    return countSocialSecurity("countSocialSecurity");
  }

  public EmployeeSalarySheetRequest countSocialSecurity(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, SOCIAL_SECURITY_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxSocialSecurity() {
    return maxSocialSecurity("maxSocialSecurity");
  }

  public EmployeeSalarySheetRequest maxSocialSecurity(String aggName) {
    return aggregate(aggName, AggFunc.MAX, SOCIAL_SECURITY_PROPERTY);
  }

  public EmployeeSalarySheetRequest minSocialSecurity() {
    return minSocialSecurity("minSocialSecurity");
  }

  public EmployeeSalarySheetRequest minSocialSecurity(String aggName) {
    return aggregate(aggName, AggFunc.MIN, SOCIAL_SECURITY_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumSocialSecurity() {
    return sumSocialSecurity("sumSocialSecurity");
  }

  public EmployeeSalarySheetRequest sumSocialSecurity(String aggName) {
    return aggregate(aggName, AggFunc.SUM, SOCIAL_SECURITY_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupBySocialSecurity() {
    return groupBySocialSecurity(SOCIAL_SECURITY_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupBySocialSecurity(String ret) {
    return groupBy(ret, SOCIAL_SECURITY_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupBySocialSecurity(SqlFunction func) {
    return groupBySocialSecurity(SOCIAL_SECURITY_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupBySocialSecurity(String ret, SqlFunction func) {
    super.groupBy(ret, func, SOCIAL_SECURITY_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByHousingFound(BigDecimal housingFound) {

    if (housingFound == null) {
      return this;
    }

    return filterByHousingFound(QueryOperator.EQUAL, housingFound);
  }

  public EmployeeSalarySheetRequest whereHousingFoundIsNull() {
    return where(HOUSING_FOUND_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereHousingFoundIsNotNull() {
    return where(HOUSING_FOUND_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest whereHousingFoundBetween(
      BigDecimal housingFoundStart, BigDecimal housingFoundEnd) {
    if (ObjectUtil.isEmpty(housingFoundStart)) {
      throw new IllegalArgumentException(
          "Method whereHousingFoundBetween, the parameter housingFoundStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(housingFoundEnd)) {
      throw new IllegalArgumentException(
          "Method whereHousingFoundBetween, the parameter housingFoundEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getHousingFoundSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {housingFoundStart, housingFoundEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereHousingFoundLessThan(BigDecimal housingFound) {
    if (ObjectUtil.isEmpty(housingFound)) {
      throw new IllegalArgumentException(
          "Method whereHousingFoundLessThan, the parameter housingFound is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getHousingFoundSearchCriteria(QueryOperator.LESS_THAN, new Object[] {housingFound});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereHousingFoundGreaterThan(BigDecimal housingFound) {
    if (ObjectUtil.isEmpty(housingFound)) {
      throw new IllegalArgumentException(
          "Method whereHousingFoundGreaterThan, the parameter housingFound is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getHousingFoundSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {housingFound});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest filterByHousingFound(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getHousingFoundSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectHousingFound() {
    return select(HOUSING_FOUND_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectHousingFound() {
    return unselect(HOUSING_FOUND_PROPERTY);
  }

  public SearchCriteria getHousingFoundSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(HOUSING_FOUND_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderByHousingFound(boolean asc) {
    addOrderBy(HOUSING_FOUND_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByHousingFoundAscending() {
    addOrderBy(HOUSING_FOUND_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByHousingFoundDescending() {
    addOrderBy(HOUSING_FOUND_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countHousingFound() {
    return countHousingFound("countHousingFound");
  }

  public EmployeeSalarySheetRequest countHousingFound(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, HOUSING_FOUND_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxHousingFound() {
    return maxHousingFound("maxHousingFound");
  }

  public EmployeeSalarySheetRequest maxHousingFound(String aggName) {
    return aggregate(aggName, AggFunc.MAX, HOUSING_FOUND_PROPERTY);
  }

  public EmployeeSalarySheetRequest minHousingFound() {
    return minHousingFound("minHousingFound");
  }

  public EmployeeSalarySheetRequest minHousingFound(String aggName) {
    return aggregate(aggName, AggFunc.MIN, HOUSING_FOUND_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumHousingFound() {
    return sumHousingFound("sumHousingFound");
  }

  public EmployeeSalarySheetRequest sumHousingFound(String aggName) {
    return aggregate(aggName, AggFunc.SUM, HOUSING_FOUND_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByHousingFound() {
    return groupByHousingFound(HOUSING_FOUND_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByHousingFound(String ret) {
    return groupBy(ret, HOUSING_FOUND_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByHousingFound(SqlFunction func) {
    return groupByHousingFound(HOUSING_FOUND_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupByHousingFound(String ret, SqlFunction func) {
    super.groupBy(ret, func, HOUSING_FOUND_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByJobInsurance(BigDecimal jobInsurance) {

    if (jobInsurance == null) {
      return this;
    }

    return filterByJobInsurance(QueryOperator.EQUAL, jobInsurance);
  }

  public EmployeeSalarySheetRequest whereJobInsuranceIsNull() {
    return where(JOB_INSURANCE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereJobInsuranceIsNotNull() {
    return where(JOB_INSURANCE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest whereJobInsuranceBetween(
      BigDecimal jobInsuranceStart, BigDecimal jobInsuranceEnd) {
    if (ObjectUtil.isEmpty(jobInsuranceStart)) {
      throw new IllegalArgumentException(
          "Method whereJobInsuranceBetween, the parameter jobInsuranceStart is not allowed  to be null.");
    }
    if (ObjectUtil.isEmpty(jobInsuranceEnd)) {
      throw new IllegalArgumentException(
          "Method whereJobInsuranceBetween, the parameter jobInsuranceEnd is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getJobInsuranceSearchCriteria(
            QueryOperator.BETWEEN, new Object[] {jobInsuranceStart, jobInsuranceEnd});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereJobInsuranceLessThan(BigDecimal jobInsurance) {
    if (ObjectUtil.isEmpty(jobInsurance)) {
      throw new IllegalArgumentException(
          "Method whereJobInsuranceLessThan, the parameter jobInsurance is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getJobInsuranceSearchCriteria(QueryOperator.LESS_THAN, new Object[] {jobInsurance});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest whereJobInsuranceGreaterThan(BigDecimal jobInsurance) {
    if (ObjectUtil.isEmpty(jobInsurance)) {
      throw new IllegalArgumentException(
          "Method whereJobInsuranceGreaterThan, the parameter jobInsurance is not allowed  to be null.");
    }
    SearchCriteria searchCriteria =
        getJobInsuranceSearchCriteria(QueryOperator.GREATER_THAN, new Object[] {jobInsurance});
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest filterByJobInsurance(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getJobInsuranceSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectJobInsurance() {
    return select(JOB_INSURANCE_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectJobInsurance() {
    return unselect(JOB_INSURANCE_PROPERTY);
  }

  public SearchCriteria getJobInsuranceSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(JOB_INSURANCE_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderByJobInsurance(boolean asc) {
    addOrderBy(JOB_INSURANCE_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByJobInsuranceAscending() {
    addOrderBy(JOB_INSURANCE_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByJobInsuranceDescending() {
    addOrderBy(JOB_INSURANCE_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countJobInsurance() {
    return countJobInsurance("countJobInsurance");
  }

  public EmployeeSalarySheetRequest countJobInsurance(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, JOB_INSURANCE_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxJobInsurance() {
    return maxJobInsurance("maxJobInsurance");
  }

  public EmployeeSalarySheetRequest maxJobInsurance(String aggName) {
    return aggregate(aggName, AggFunc.MAX, JOB_INSURANCE_PROPERTY);
  }

  public EmployeeSalarySheetRequest minJobInsurance() {
    return minJobInsurance("minJobInsurance");
  }

  public EmployeeSalarySheetRequest minJobInsurance(String aggName) {
    return aggregate(aggName, AggFunc.MIN, JOB_INSURANCE_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumJobInsurance() {
    return sumJobInsurance("sumJobInsurance");
  }

  public EmployeeSalarySheetRequest sumJobInsurance(String aggName) {
    return aggregate(aggName, AggFunc.SUM, JOB_INSURANCE_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByJobInsurance() {
    return groupByJobInsurance(JOB_INSURANCE_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByJobInsurance(String ret) {
    return groupBy(ret, JOB_INSURANCE_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByJobInsurance(SqlFunction func) {
    return groupByJobInsurance(JOB_INSURANCE_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupByJobInsurance(String ret, SqlFunction func) {
    super.groupBy(ret, func, JOB_INSURANCE_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByVersion(int version) {

    return filterByVersion(QueryOperator.EQUAL, version);
  }

  public EmployeeSalarySheetRequest whereVersionIsNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereVersionIsNotNull() {
    return where(VERSION_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest filterByVersion(
      QueryOperator pQueryOperator, Object... parameters) {
    SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
    return addSearchCriteria(searchCriteria);
  }

  public EmployeeSalarySheetRequest selectVersion() {
    return select(VERSION_PROPERTY);
  }

  public EmployeeSalarySheetRequest unselectVersion() {
    return unselect(VERSION_PROPERTY);
  }

  public SearchCriteria getVersionSearchCriteria(
      QueryOperator pQueryOperator, Object[] parameters) {
    return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
  }

  @Deprecated
  public EmployeeSalarySheetRequest orderByVersion(boolean asc) {
    addOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public EmployeeSalarySheetRequest orderByVersionAscending() {
    addOrderBy(VERSION_PROPERTY, true);
    return this;
  }

  public EmployeeSalarySheetRequest orderByVersionDescending() {
    addOrderBy(VERSION_PROPERTY, false);
    return this;
  }

  public EmployeeSalarySheetRequest countVersion() {
    return countVersion("countVersion");
  }

  public EmployeeSalarySheetRequest countVersion(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, VERSION_PROPERTY);
  }

  public EmployeeSalarySheetRequest maxVersion() {
    return maxVersion("maxVersion");
  }

  public EmployeeSalarySheetRequest maxVersion(String aggName) {
    return aggregate(aggName, AggFunc.MAX, VERSION_PROPERTY);
  }

  public EmployeeSalarySheetRequest minVersion() {
    return minVersion("minVersion");
  }

  public EmployeeSalarySheetRequest minVersion(String aggName) {
    return aggregate(aggName, AggFunc.MIN, VERSION_PROPERTY);
  }

  public EmployeeSalarySheetRequest sumVersion() {
    return sumVersion("sumVersion");
  }

  public EmployeeSalarySheetRequest sumVersion(String aggName) {
    return aggregate(aggName, AggFunc.SUM, VERSION_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByVersion() {
    return groupByVersion(VERSION_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByVersion(String ret) {
    return groupBy(ret, VERSION_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByVersion(SqlFunction func) {
    return groupByVersion(VERSION_PROPERTY, func);
  }

  public EmployeeSalarySheetRequest groupByVersion(String ret, SqlFunction func) {
    super.groupBy(ret, func, VERSION_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest filterByEmployee(EmployeeRequest employee) {
    return filterByEmployee(employee, Employee::getId);
  }

  public EmployeeSalarySheetRequest filterByEmployee(Employee... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(Employee... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeSalarySheetRequest selectEmployeeId() {
    select(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeRequest upToEmployee() {
    return upToEmployee(EmployeeRequest.newInstance());
  }

  public EmployeeRequest upToEmployee(EmployeeRequest employee) {
    employee.aggregateChild(EMPLOYEE_PROPERTY, this);
    this.groupByEmployee(employee);
    return employee;
  }

  public EmployeeRequest endAtEmployee(String retName) {
    return endAtEmployee(retName, EmployeeRequest.newInstance());
  }

  public EmployeeRequest endAtEmployee(String retName, EmployeeRequest employee) {
    employee.addDynamicProperty(retName, this, EMPLOYEE_PROPERTY);
    return employee;
  }

  public EmployeeSalarySheetRequest filterByEmployee(String... employee) {
    if (isEmptyParam(employee)) {
      throw new IllegalArgumentException("filterByEmployee(String... employee)参数不能为空!");
    }
    return where(EMPLOYEE_PROPERTY, QueryOperator.IN, (Object[]) employee);
  }

  public EmployeeSalarySheetRequest filterByEmployee(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    employee.unlimited();
    return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
  }

  public SearchCriteria createEmployeeCriteria(
      EmployeeRequest employee, IDRefine<Employee> idRefine) {
    return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine, Employee.ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest selectEmployee() {
    return selectEmployee(EmployeeRequest.newInstance().selectSelf());
  }

  public EmployeeSalarySheetRequest selectEmployee(EmployeeRequest employee) {
    selectParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeSalarySheetRequest unselectEmployee() {
    unselectParent(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest groupByEmployee(EmployeeRequest employee) {
    groupBy(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeSalarySheetRequest aggregateEmployee(EmployeeRequest employee) {
    aggregateParent(EMPLOYEE_PROPERTY, employee);
    return this;
  }

  public EmployeeSalarySheetRequest countEmployee() {
    return countEmployee("countEmployee");
  }

  public EmployeeSalarySheetRequest countEmployee(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, EMPLOYEE_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByEmployee() {
    return groupByEmployee(EMPLOYEE_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByEmployee(String ret) {
    return groupBy(ret, EMPLOYEE_PROPERTY);
  }

  public EmployeeSalarySheetRequest whereEmployeeIsNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereEmployeeIsNotNull() {
    return where(EMPLOYEE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest filterByCurrentSalaryGrade(
      SalaryGradeRequest currentSalaryGrade) {
    return filterByCurrentSalaryGrade(currentSalaryGrade, SalaryGrade::getId);
  }

  public EmployeeSalarySheetRequest filterByCurrentSalaryGrade(SalaryGrade... currentSalaryGrade) {
    if (isEmptyParam(currentSalaryGrade)) {
      throw new IllegalArgumentException(
          "filterByCurrentSalaryGrade(SalaryGrade... currentSalaryGrade)参数不能为空!");
    }
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IN, (Object[]) currentSalaryGrade);
  }

  public EmployeeSalarySheetRequest selectCurrentSalaryGradeId() {
    select(CURRENT_SALARY_GRADE_PROPERTY);
    return this;
  }

  public SalaryGradeRequest upToCurrentSalaryGrade() {
    return upToCurrentSalaryGrade(SalaryGradeRequest.newInstance());
  }

  public SalaryGradeRequest upToCurrentSalaryGrade(SalaryGradeRequest currentSalaryGrade) {
    currentSalaryGrade.aggregateChild(CURRENT_SALARY_GRADE_PROPERTY, this);
    this.groupByCurrentSalaryGrade(currentSalaryGrade);
    return currentSalaryGrade;
  }

  public SalaryGradeRequest endAtCurrentSalaryGrade(String retName) {
    return endAtCurrentSalaryGrade(retName, SalaryGradeRequest.newInstance());
  }

  public SalaryGradeRequest endAtCurrentSalaryGrade(
      String retName, SalaryGradeRequest currentSalaryGrade) {
    currentSalaryGrade.addDynamicProperty(retName, this, CURRENT_SALARY_GRADE_PROPERTY);
    return currentSalaryGrade;
  }

  public EmployeeSalarySheetRequest filterByCurrentSalaryGrade(String... currentSalaryGrade) {
    if (isEmptyParam(currentSalaryGrade)) {
      throw new IllegalArgumentException(
          "filterByCurrentSalaryGrade(String... currentSalaryGrade)参数不能为空!");
    }
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IN, (Object[]) currentSalaryGrade);
  }

  public EmployeeSalarySheetRequest filterByCurrentSalaryGrade(
      SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
    currentSalaryGrade.unlimited();
    return addSearchCriteria(createCurrentSalaryGradeCriteria(currentSalaryGrade, idRefine));
  }

  public SearchCriteria createCurrentSalaryGradeCriteria(
      SalaryGradeRequest currentSalaryGrade, IDRefine<SalaryGrade> idRefine) {
    return new RefinedIdInCriteria(
        currentSalaryGrade, CURRENT_SALARY_GRADE_PROPERTY, idRefine, SalaryGrade.ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest selectCurrentSalaryGrade() {
    return selectCurrentSalaryGrade(SalaryGradeRequest.newInstance().selectSelf());
  }

  public EmployeeSalarySheetRequest selectCurrentSalaryGrade(
      SalaryGradeRequest currentSalaryGrade) {
    selectParent(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
    return this;
  }

  public EmployeeSalarySheetRequest unselectCurrentSalaryGrade() {
    unselectParent(CURRENT_SALARY_GRADE_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest groupByCurrentSalaryGrade(
      SalaryGradeRequest currentSalaryGrade) {
    groupBy(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
    return this;
  }

  public EmployeeSalarySheetRequest aggregateCurrentSalaryGrade(
      SalaryGradeRequest currentSalaryGrade) {
    aggregateParent(CURRENT_SALARY_GRADE_PROPERTY, currentSalaryGrade);
    return this;
  }

  public EmployeeSalarySheetRequest countCurrentSalaryGrade() {
    return countCurrentSalaryGrade("countCurrentSalaryGrade");
  }

  public EmployeeSalarySheetRequest countCurrentSalaryGrade(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, CURRENT_SALARY_GRADE_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByCurrentSalaryGrade() {
    return groupByCurrentSalaryGrade(CURRENT_SALARY_GRADE_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByCurrentSalaryGrade(String ret) {
    return groupBy(ret, CURRENT_SALARY_GRADE_PROPERTY);
  }

  public EmployeeSalarySheetRequest whereCurrentSalaryGradeIsNull() {
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest whereCurrentSalaryGradeIsNotNull() {
    return where(CURRENT_SALARY_GRADE_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest filterByPayingOff(PayingOffRequest payingOff) {
    return filterByPayingOff(payingOff, PayingOff::getId);
  }

  public EmployeeSalarySheetRequest filterByPayingOff(PayingOff... payingOff) {
    if (isEmptyParam(payingOff)) {
      throw new IllegalArgumentException("filterByPayingOff(PayingOff... payingOff)参数不能为空!");
    }
    return where(PAYING_OFF_PROPERTY, QueryOperator.IN, (Object[]) payingOff);
  }

  public EmployeeSalarySheetRequest selectPayingOffId() {
    select(PAYING_OFF_PROPERTY);
    return this;
  }

  public PayingOffRequest upToPayingOff() {
    return upToPayingOff(PayingOffRequest.newInstance());
  }

  public PayingOffRequest upToPayingOff(PayingOffRequest payingOff) {
    payingOff.aggregateChild(PAYING_OFF_PROPERTY, this);
    this.groupByPayingOff(payingOff);
    return payingOff;
  }

  public PayingOffRequest endAtPayingOff(String retName) {
    return endAtPayingOff(retName, PayingOffRequest.newInstance());
  }

  public PayingOffRequest endAtPayingOff(String retName, PayingOffRequest payingOff) {
    payingOff.addDynamicProperty(retName, this, PAYING_OFF_PROPERTY);
    return payingOff;
  }

  public EmployeeSalarySheetRequest filterByPayingOff(String... payingOff) {
    if (isEmptyParam(payingOff)) {
      throw new IllegalArgumentException("filterByPayingOff(String... payingOff)参数不能为空!");
    }
    return where(PAYING_OFF_PROPERTY, QueryOperator.IN, (Object[]) payingOff);
  }

  public EmployeeSalarySheetRequest filterByPayingOff(
      PayingOffRequest payingOff, IDRefine<PayingOff> idRefine) {
    payingOff.unlimited();
    return addSearchCriteria(createPayingOffCriteria(payingOff, idRefine));
  }

  public SearchCriteria createPayingOffCriteria(
      PayingOffRequest payingOff, IDRefine<PayingOff> idRefine) {
    return new RefinedIdInCriteria(payingOff, PAYING_OFF_PROPERTY, idRefine, PayingOff.ID_PROPERTY);
  }

  public EmployeeSalarySheetRequest selectPayingOff() {
    return selectPayingOff(PayingOffRequest.newInstance().selectSelf());
  }

  public EmployeeSalarySheetRequest selectPayingOff(PayingOffRequest payingOff) {
    selectParent(PAYING_OFF_PROPERTY, payingOff);
    return this;
  }

  public EmployeeSalarySheetRequest unselectPayingOff() {
    unselectParent(PAYING_OFF_PROPERTY);
    return this;
  }

  public EmployeeSalarySheetRequest groupByPayingOff(PayingOffRequest payingOff) {
    groupBy(PAYING_OFF_PROPERTY, payingOff);
    return this;
  }

  public EmployeeSalarySheetRequest aggregatePayingOff(PayingOffRequest payingOff) {
    aggregateParent(PAYING_OFF_PROPERTY, payingOff);
    return this;
  }

  public EmployeeSalarySheetRequest countPayingOff() {
    return countPayingOff("countPayingOff");
  }

  public EmployeeSalarySheetRequest countPayingOff(String aggName) {
    return aggregate(aggName, AggFunc.COUNT, PAYING_OFF_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByPayingOff() {
    return groupByPayingOff(PAYING_OFF_PROPERTY);
  }

  public EmployeeSalarySheetRequest groupByPayingOff(String ret) {
    return groupBy(ret, PAYING_OFF_PROPERTY);
  }

  public EmployeeSalarySheetRequest wherePayingOffIsNull() {
    return where(PAYING_OFF_PROPERTY, QueryOperator.IS_NULL);
  }

  public EmployeeSalarySheetRequest wherePayingOffIsNotNull() {
    return where(PAYING_OFF_PROPERTY, QueryOperator.IS_NOT_NULL);
  }

  public EmployeeSalarySheetRequest limit(int start, int size) {
    setOffset(start);
    setSize(size);
    return this;
  }

  public EmployeeSalarySheetRequest statsOnly() {
    limit(0, 0);
    return this;
  }

  public EmployeeSalarySheetRequest unlimited() {
    super.unlimited();
    return this;
  }

  public EmployeeSalarySheetRequest limit(JsonNode jsonNode) {
    super.addJsonLimiter(jsonNode);
    return this;
  }
}
