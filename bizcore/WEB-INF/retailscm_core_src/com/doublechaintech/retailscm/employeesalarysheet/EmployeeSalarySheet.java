package com.doublechaintech.retailscm.employeesalarysheet;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;

@JsonSerialize(using = EmployeeSalarySheetSerializer.class)
public class EmployeeSalarySheet extends BaseEntity implements java.io.Serializable {

  public void transferAllRelationshipsTo(EmployeeSalarySheet target) {
    if (target == null) {
      return;
    }
  }

  public static final String ID_PROPERTY = "id";
  public static final String EMPLOYEE_PROPERTY = "employee";
  public static final String CURRENT_SALARY_GRADE_PROPERTY = "currentSalaryGrade";
  public static final String BASE_SALARY_PROPERTY = "baseSalary";
  public static final String BONUS_PROPERTY = "bonus";
  public static final String REWARD_PROPERTY = "reward";
  public static final String PERSONAL_TAX_PROPERTY = "personalTax";
  public static final String SOCIAL_SECURITY_PROPERTY = "socialSecurity";
  public static final String HOUSING_FOUND_PROPERTY = "housingFound";
  public static final String JOB_INSURANCE_PROPERTY = "jobInsurance";
  public static final String PAYING_OFF_PROPERTY = "payingOff";
  public static final String VERSION_PROPERTY = "version";

  public static final String INTERNAL_TYPE = "EmployeeSalarySheet";

  public String getInternalType() {
    return INTERNAL_TYPE;
  }

  protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();

  static {
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID").withType("id", String.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(EMPLOYEE_PROPERTY, "employee", "员工")
            .withType("employee", Employee.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(CURRENT_SALARY_GRADE_PROPERTY, "salary_grade", "目前工资等级")
            .withType("salary_grade", SalaryGrade.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BASE_SALARY_PROPERTY, "base_salary", "基本工资")
            .withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(BONUS_PROPERTY, "bonus", "奖金").withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(REWARD_PROPERTY, "reward", "奖励").withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PERSONAL_TAX_PROPERTY, "personal_tax", "个人所得税")
            .withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(SOCIAL_SECURITY_PROPERTY, "social_security", "社会保险")
            .withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(HOUSING_FOUND_PROPERTY, "housing_found", "住房公积金")
            .withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(JOB_INSURANCE_PROPERTY, "job_insurance", "失业保险")
            .withType("money", "BigDecimal"));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(PAYING_OFF_PROPERTY, "paying_off", "工资支付")
            .withType("paying_off", PayingOff.class));
    memberMetaInfoList.add(
        MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本").withType("version", "int"));
  }

  public List<MemberMetaInfo> getMemberMetaInfoList() {
    return memberMetaInfoList;
  }

  public String[] getPropertyNames() {
    return new String[] {
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
  }

  public Map<String, String> getReferProperties() {
    Map<String, String> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();

    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties() {
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(EMPLOYEE_PROPERTY, Employee.class);
    parents.put(CURRENT_SALARY_GRADE_PROPERTY, SalaryGrade.class);
    parents.put(PAYING_OFF_PROPERTY, PayingOff.class);

    return parents;
  }
  /*
  public EmployeeSalarySheet want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeSalarySheet wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }*/

  public String getDisplayName() {

    String displayName = getId();
    if (displayName != null) {
      return displayName;
    }

    return super.getDisplayName();
  }

  private static final long serialVersionUID = 1L;

  protected String id;
  protected Employee employee;
  protected SalaryGrade currentSalaryGrade;
  protected BigDecimal baseSalary;
  protected BigDecimal bonus;
  protected BigDecimal reward;
  protected BigDecimal personalTax;
  protected BigDecimal socialSecurity;
  protected BigDecimal housingFound;
  protected BigDecimal jobInsurance;
  protected PayingOff payingOff;
  protected int version;

  public EmployeeSalarySheet() {
    // lazy load for all the properties
  }

  public static EmployeeSalarySheet withId(String id) {
    EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
    employeeSalarySheet.setId(id);
    employeeSalarySheet.setVersion(Integer.MAX_VALUE);
    employeeSalarySheet.setChecked(true);
    return employeeSalarySheet;
  }

  public static EmployeeSalarySheet refById(String id) {
    return withId(id);
  }

  public EmployeeSalarySheet limit(int count) {
    doAddLimit(0, count);
    return this;
  }

  public EmployeeSalarySheet limit(int start, int count) {
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeSalarySheet searchExample() {
    EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
    employeeSalarySheet.setVersion(UNSET_INT);

    return employeeSalarySheet;
  }

  // disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
  /*
  public 	void clearFromAll(){
  	setEmployee( null );
  	setCurrentSalaryGrade( null );
  	setPayingOff( null );

  	this.changed = true;
  	setChecked(false);
  }  */

  // Support for changing the property

  public void changeProperty(String property, String newValueExpr) {

    if (BASE_SALARY_PROPERTY.equals(property)) {
      changeBaseSalaryProperty(newValueExpr);
    }
    if (BONUS_PROPERTY.equals(property)) {
      changeBonusProperty(newValueExpr);
    }
    if (REWARD_PROPERTY.equals(property)) {
      changeRewardProperty(newValueExpr);
    }
    if (PERSONAL_TAX_PROPERTY.equals(property)) {
      changePersonalTaxProperty(newValueExpr);
    }
    if (SOCIAL_SECURITY_PROPERTY.equals(property)) {
      changeSocialSecurityProperty(newValueExpr);
    }
    if (HOUSING_FOUND_PROPERTY.equals(property)) {
      changeHousingFoundProperty(newValueExpr);
    }
    if (JOB_INSURANCE_PROPERTY.equals(property)) {
      changeJobInsuranceProperty(newValueExpr);
    }
  }

  protected void changeBaseSalaryProperty(String newValueExpr) {

    BigDecimal oldValue = getBaseSalary();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateBaseSalary(newValue);
    this.onChangeProperty(BASE_SALARY_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeBonusProperty(String newValueExpr) {

    BigDecimal oldValue = getBonus();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateBonus(newValue);
    this.onChangeProperty(BONUS_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeRewardProperty(String newValueExpr) {

    BigDecimal oldValue = getReward();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateReward(newValue);
    this.onChangeProperty(REWARD_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changePersonalTaxProperty(String newValueExpr) {

    BigDecimal oldValue = getPersonalTax();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updatePersonalTax(newValue);
    this.onChangeProperty(PERSONAL_TAX_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeSocialSecurityProperty(String newValueExpr) {

    BigDecimal oldValue = getSocialSecurity();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateSocialSecurity(newValue);
    this.onChangeProperty(SOCIAL_SECURITY_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeHousingFoundProperty(String newValueExpr) {

    BigDecimal oldValue = getHousingFound();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateHousingFound(newValue);
    this.onChangeProperty(HOUSING_FOUND_PROPERTY, oldValue, newValue);
    return;
  }

  protected void changeJobInsuranceProperty(String newValueExpr) {

    BigDecimal oldValue = getJobInsurance();
    BigDecimal newValue = parseBigDecimal(newValueExpr);
    if (equalsBigDecimal(oldValue, newValue)) {
      return; // they can be both null, or exact the same object, this is much faster than equals
              // function
    }
    // they are surely different each other
    updateJobInsurance(newValue);
    this.onChangeProperty(JOB_INSURANCE_PROPERTY, oldValue, newValue);
    return;
  }

  public Object propertyOf(String property) {

    if (EMPLOYEE_PROPERTY.equals(property)) {
      return getEmployee();
    }
    if (CURRENT_SALARY_GRADE_PROPERTY.equals(property)) {
      return getCurrentSalaryGrade();
    }
    if (BASE_SALARY_PROPERTY.equals(property)) {
      return getBaseSalary();
    }
    if (BONUS_PROPERTY.equals(property)) {
      return getBonus();
    }
    if (REWARD_PROPERTY.equals(property)) {
      return getReward();
    }
    if (PERSONAL_TAX_PROPERTY.equals(property)) {
      return getPersonalTax();
    }
    if (SOCIAL_SECURITY_PROPERTY.equals(property)) {
      return getSocialSecurity();
    }
    if (HOUSING_FOUND_PROPERTY.equals(property)) {
      return getHousingFound();
    }
    if (JOB_INSURANCE_PROPERTY.equals(property)) {
      return getJobInsurance();
    }
    if (PAYING_OFF_PROPERTY.equals(property)) {
      return getPayingOff();
    }

    // other property not include here
    return super.propertyOf(property);
  }

  public void setId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    this.id = newId;
  }

  public String id() {
    doLoad();
    return getId();
  }

  public String getId() {
    return this.id;
  }

  public EmployeeSalarySheet updateId(String id) {
    String oldId = this.id;
    String newId = trimString(id);
    if (!shouldReplaceBy(newId, oldId)) {
      return this;
    }
    this.id = newId;
    if (cn.hutool.core.util.ObjectUtil.equals(newId, oldId)) {
      return this;
    }
    addPropertyChange(ID_PROPERTY, oldId, newId);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderById(boolean asc) {
    doAddOrderBy(ID_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(ID_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreIdCriteria() {
    super.ignoreSearchProperty(ID_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addIdCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createIdCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeId(String id) {
    if (id != null) {
      updateId(id);
    }
  }

  public void setEmployee(Employee employee) {
    Employee oldEmployee = this.employee;
    Employee newEmployee = employee;
    this.employee = newEmployee;
  }

  public Employee employee() {
    doLoad();
    return getEmployee();
  }

  public Employee getEmployee() {
    return this.employee;
  }

  public EmployeeSalarySheet updateEmployee(Employee employee) {
    Employee oldEmployee = this.employee;
    Employee newEmployee = employee;
    if (!shouldReplaceBy(newEmployee, oldEmployee)) {
      return this;
    }
    this.employee = newEmployee;
    if (cn.hutool.core.util.ObjectUtil.equals(newEmployee, oldEmployee)) {
      return this;
    }
    addPropertyChange(EMPLOYEE_PROPERTY, oldEmployee, newEmployee);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByEmployee(boolean asc) {
    doAddOrderBy(EMPLOYEE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreEmployeeCriteria() {
    super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addEmployeeCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createEmployeeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeEmployee(Employee employee) {
    if (employee != null) {
      updateEmployee(employee);
    }
  }

  public EmployeeSalarySheet updateEmployeeByReferenceId(String employeeId) {
    updateEmployee(Employee.refById(employeeId));
    return this;
  }

  public void clearEmployee() {
    setEmployee(null);
    this.changed = true;
    setChecked(false);
  }

  public void setCurrentSalaryGrade(SalaryGrade currentSalaryGrade) {
    SalaryGrade oldCurrentSalaryGrade = this.currentSalaryGrade;
    SalaryGrade newCurrentSalaryGrade = currentSalaryGrade;
    this.currentSalaryGrade = newCurrentSalaryGrade;
  }

  public SalaryGrade currentSalaryGrade() {
    doLoad();
    return getCurrentSalaryGrade();
  }

  public SalaryGrade getCurrentSalaryGrade() {
    return this.currentSalaryGrade;
  }

  public EmployeeSalarySheet updateCurrentSalaryGrade(SalaryGrade currentSalaryGrade) {
    SalaryGrade oldCurrentSalaryGrade = this.currentSalaryGrade;
    SalaryGrade newCurrentSalaryGrade = currentSalaryGrade;
    if (!shouldReplaceBy(newCurrentSalaryGrade, oldCurrentSalaryGrade)) {
      return this;
    }
    this.currentSalaryGrade = newCurrentSalaryGrade;
    if (cn.hutool.core.util.ObjectUtil.equals(newCurrentSalaryGrade, oldCurrentSalaryGrade)) {
      return this;
    }
    addPropertyChange(CURRENT_SALARY_GRADE_PROPERTY, oldCurrentSalaryGrade, newCurrentSalaryGrade);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByCurrentSalaryGrade(boolean asc) {
    doAddOrderBy(CURRENT_SALARY_GRADE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createCurrentSalaryGradeCriteria(
      QueryOperator operator, Object... parameters) {
    return createCriteria(CURRENT_SALARY_GRADE_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreCurrentSalaryGradeCriteria() {
    super.ignoreSearchProperty(CURRENT_SALARY_GRADE_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addCurrentSalaryGradeCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createCurrentSalaryGradeCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeCurrentSalaryGrade(SalaryGrade currentSalaryGrade) {
    if (currentSalaryGrade != null) {
      updateCurrentSalaryGrade(currentSalaryGrade);
    }
  }

  public EmployeeSalarySheet updateCurrentSalaryGradeByReferenceId(String currentSalaryGradeId) {
    updateCurrentSalaryGrade(SalaryGrade.refById(currentSalaryGradeId));
    return this;
  }

  public void clearCurrentSalaryGrade() {
    setCurrentSalaryGrade(null);
    this.changed = true;
    setChecked(false);
  }

  public void setBaseSalary(BigDecimal baseSalary) {
    BigDecimal oldBaseSalary = this.baseSalary;
    BigDecimal newBaseSalary = baseSalary;
    this.baseSalary = newBaseSalary;
  }

  public BigDecimal baseSalary() {
    doLoad();
    return getBaseSalary();
  }

  public BigDecimal getBaseSalary() {
    return this.baseSalary;
  }

  public EmployeeSalarySheet updateBaseSalary(BigDecimal baseSalary) {
    BigDecimal oldBaseSalary = this.baseSalary;
    BigDecimal newBaseSalary = baseSalary;
    if (!shouldReplaceBy(newBaseSalary, oldBaseSalary)) {
      return this;
    }
    this.baseSalary = newBaseSalary;
    if (cn.hutool.core.util.ObjectUtil.equals(newBaseSalary, oldBaseSalary)) {
      return this;
    }
    addPropertyChange(BASE_SALARY_PROPERTY, oldBaseSalary, newBaseSalary);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByBaseSalary(boolean asc) {
    doAddOrderBy(BASE_SALARY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBaseSalaryCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BASE_SALARY_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreBaseSalaryCriteria() {
    super.ignoreSearchProperty(BASE_SALARY_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addBaseSalaryCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBaseSalaryCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBaseSalary(BigDecimal baseSalary) {
    updateBaseSalary(baseSalary);
  }

  public void setBonus(BigDecimal bonus) {
    BigDecimal oldBonus = this.bonus;
    BigDecimal newBonus = bonus;
    this.bonus = newBonus;
  }

  public BigDecimal bonus() {
    doLoad();
    return getBonus();
  }

  public BigDecimal getBonus() {
    return this.bonus;
  }

  public EmployeeSalarySheet updateBonus(BigDecimal bonus) {
    BigDecimal oldBonus = this.bonus;
    BigDecimal newBonus = bonus;
    if (!shouldReplaceBy(newBonus, oldBonus)) {
      return this;
    }
    this.bonus = newBonus;
    if (cn.hutool.core.util.ObjectUtil.equals(newBonus, oldBonus)) {
      return this;
    }
    addPropertyChange(BONUS_PROPERTY, oldBonus, newBonus);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByBonus(boolean asc) {
    doAddOrderBy(BONUS_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createBonusCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(BONUS_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreBonusCriteria() {
    super.ignoreSearchProperty(BONUS_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addBonusCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createBonusCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeBonus(BigDecimal bonus) {
    updateBonus(bonus);
  }

  public void setReward(BigDecimal reward) {
    BigDecimal oldReward = this.reward;
    BigDecimal newReward = reward;
    this.reward = newReward;
  }

  public BigDecimal reward() {
    doLoad();
    return getReward();
  }

  public BigDecimal getReward() {
    return this.reward;
  }

  public EmployeeSalarySheet updateReward(BigDecimal reward) {
    BigDecimal oldReward = this.reward;
    BigDecimal newReward = reward;
    if (!shouldReplaceBy(newReward, oldReward)) {
      return this;
    }
    this.reward = newReward;
    if (cn.hutool.core.util.ObjectUtil.equals(newReward, oldReward)) {
      return this;
    }
    addPropertyChange(REWARD_PROPERTY, oldReward, newReward);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByReward(boolean asc) {
    doAddOrderBy(REWARD_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createRewardCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(REWARD_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreRewardCriteria() {
    super.ignoreSearchProperty(REWARD_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addRewardCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createRewardCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeReward(BigDecimal reward) {
    updateReward(reward);
  }

  public void setPersonalTax(BigDecimal personalTax) {
    BigDecimal oldPersonalTax = this.personalTax;
    BigDecimal newPersonalTax = personalTax;
    this.personalTax = newPersonalTax;
  }

  public BigDecimal personalTax() {
    doLoad();
    return getPersonalTax();
  }

  public BigDecimal getPersonalTax() {
    return this.personalTax;
  }

  public EmployeeSalarySheet updatePersonalTax(BigDecimal personalTax) {
    BigDecimal oldPersonalTax = this.personalTax;
    BigDecimal newPersonalTax = personalTax;
    if (!shouldReplaceBy(newPersonalTax, oldPersonalTax)) {
      return this;
    }
    this.personalTax = newPersonalTax;
    if (cn.hutool.core.util.ObjectUtil.equals(newPersonalTax, oldPersonalTax)) {
      return this;
    }
    addPropertyChange(PERSONAL_TAX_PROPERTY, oldPersonalTax, newPersonalTax);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByPersonalTax(boolean asc) {
    doAddOrderBy(PERSONAL_TAX_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPersonalTaxCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PERSONAL_TAX_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignorePersonalTaxCriteria() {
    super.ignoreSearchProperty(PERSONAL_TAX_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addPersonalTaxCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPersonalTaxCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePersonalTax(BigDecimal personalTax) {
    updatePersonalTax(personalTax);
  }

  public void setSocialSecurity(BigDecimal socialSecurity) {
    BigDecimal oldSocialSecurity = this.socialSecurity;
    BigDecimal newSocialSecurity = socialSecurity;
    this.socialSecurity = newSocialSecurity;
  }

  public BigDecimal socialSecurity() {
    doLoad();
    return getSocialSecurity();
  }

  public BigDecimal getSocialSecurity() {
    return this.socialSecurity;
  }

  public EmployeeSalarySheet updateSocialSecurity(BigDecimal socialSecurity) {
    BigDecimal oldSocialSecurity = this.socialSecurity;
    BigDecimal newSocialSecurity = socialSecurity;
    if (!shouldReplaceBy(newSocialSecurity, oldSocialSecurity)) {
      return this;
    }
    this.socialSecurity = newSocialSecurity;
    if (cn.hutool.core.util.ObjectUtil.equals(newSocialSecurity, oldSocialSecurity)) {
      return this;
    }
    addPropertyChange(SOCIAL_SECURITY_PROPERTY, oldSocialSecurity, newSocialSecurity);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderBySocialSecurity(boolean asc) {
    doAddOrderBy(SOCIAL_SECURITY_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createSocialSecurityCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(SOCIAL_SECURITY_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreSocialSecurityCriteria() {
    super.ignoreSearchProperty(SOCIAL_SECURITY_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addSocialSecurityCriteria(
      QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createSocialSecurityCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeSocialSecurity(BigDecimal socialSecurity) {
    updateSocialSecurity(socialSecurity);
  }

  public void setHousingFound(BigDecimal housingFound) {
    BigDecimal oldHousingFound = this.housingFound;
    BigDecimal newHousingFound = housingFound;
    this.housingFound = newHousingFound;
  }

  public BigDecimal housingFound() {
    doLoad();
    return getHousingFound();
  }

  public BigDecimal getHousingFound() {
    return this.housingFound;
  }

  public EmployeeSalarySheet updateHousingFound(BigDecimal housingFound) {
    BigDecimal oldHousingFound = this.housingFound;
    BigDecimal newHousingFound = housingFound;
    if (!shouldReplaceBy(newHousingFound, oldHousingFound)) {
      return this;
    }
    this.housingFound = newHousingFound;
    if (cn.hutool.core.util.ObjectUtil.equals(newHousingFound, oldHousingFound)) {
      return this;
    }
    addPropertyChange(HOUSING_FOUND_PROPERTY, oldHousingFound, newHousingFound);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByHousingFound(boolean asc) {
    doAddOrderBy(HOUSING_FOUND_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createHousingFoundCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(HOUSING_FOUND_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreHousingFoundCriteria() {
    super.ignoreSearchProperty(HOUSING_FOUND_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addHousingFoundCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createHousingFoundCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeHousingFound(BigDecimal housingFound) {
    updateHousingFound(housingFound);
  }

  public void setJobInsurance(BigDecimal jobInsurance) {
    BigDecimal oldJobInsurance = this.jobInsurance;
    BigDecimal newJobInsurance = jobInsurance;
    this.jobInsurance = newJobInsurance;
  }

  public BigDecimal jobInsurance() {
    doLoad();
    return getJobInsurance();
  }

  public BigDecimal getJobInsurance() {
    return this.jobInsurance;
  }

  public EmployeeSalarySheet updateJobInsurance(BigDecimal jobInsurance) {
    BigDecimal oldJobInsurance = this.jobInsurance;
    BigDecimal newJobInsurance = jobInsurance;
    if (!shouldReplaceBy(newJobInsurance, oldJobInsurance)) {
      return this;
    }
    this.jobInsurance = newJobInsurance;
    if (cn.hutool.core.util.ObjectUtil.equals(newJobInsurance, oldJobInsurance)) {
      return this;
    }
    addPropertyChange(JOB_INSURANCE_PROPERTY, oldJobInsurance, newJobInsurance);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByJobInsurance(boolean asc) {
    doAddOrderBy(JOB_INSURANCE_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createJobInsuranceCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(JOB_INSURANCE_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreJobInsuranceCriteria() {
    super.ignoreSearchProperty(JOB_INSURANCE_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addJobInsuranceCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createJobInsuranceCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeJobInsurance(BigDecimal jobInsurance) {
    updateJobInsurance(jobInsurance);
  }

  public void setPayingOff(PayingOff payingOff) {
    PayingOff oldPayingOff = this.payingOff;
    PayingOff newPayingOff = payingOff;
    this.payingOff = newPayingOff;
  }

  public PayingOff payingOff() {
    doLoad();
    return getPayingOff();
  }

  public PayingOff getPayingOff() {
    return this.payingOff;
  }

  public EmployeeSalarySheet updatePayingOff(PayingOff payingOff) {
    PayingOff oldPayingOff = this.payingOff;
    PayingOff newPayingOff = payingOff;
    if (!shouldReplaceBy(newPayingOff, oldPayingOff)) {
      return this;
    }
    this.payingOff = newPayingOff;
    if (cn.hutool.core.util.ObjectUtil.equals(newPayingOff, oldPayingOff)) {
      return this;
    }
    addPropertyChange(PAYING_OFF_PROPERTY, oldPayingOff, newPayingOff);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByPayingOff(boolean asc) {
    doAddOrderBy(PAYING_OFF_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createPayingOffCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(PAYING_OFF_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignorePayingOffCriteria() {
    super.ignoreSearchProperty(PAYING_OFF_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addPayingOffCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createPayingOffCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergePayingOff(PayingOff payingOff) {
    if (payingOff != null) {
      updatePayingOff(payingOff);
    }
  }

  public EmployeeSalarySheet updatePayingOffByReferenceId(String payingOffId) {
    updatePayingOff(PayingOff.refById(payingOffId));
    return this;
  }

  public void clearPayingOff() {
    setPayingOff(null);
    this.changed = true;
    setChecked(false);
  }

  public void setVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    this.version = newVersion;
  }

  public int version() {
    doLoad();
    return getVersion();
  }

  public int getVersion() {
    return this.version;
  }

  public EmployeeSalarySheet updateVersion(int version) {
    int oldVersion = this.version;
    int newVersion = version;
    if (!shouldReplaceBy(newVersion, oldVersion)) {
      return this;
    }
    this.version = newVersion;
    if (cn.hutool.core.util.ObjectUtil.equals(newVersion, oldVersion)) {
      return this;
    }
    addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);
    this.changed = true;
    setChecked(false);
    return this;
  }

  public EmployeeSalarySheet orderByVersion(boolean asc) {
    doAddOrderBy(VERSION_PROPERTY, asc);
    return this;
  }

  public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters) {
    return createCriteria(VERSION_PROPERTY, operator, parameters);
  }

  public EmployeeSalarySheet ignoreVersionCriteria() {
    super.ignoreSearchProperty(VERSION_PROPERTY);
    return this;
  }

  public EmployeeSalarySheet addVersionCriteria(QueryOperator operator, Object... parameters) {
    SearchCriteria criteria = createVersionCriteria(operator, parameters);
    doAddCriteria(criteria);
    return this;
  }

  public void mergeVersion(int version) {
    if (version >= 0) {
      updateVersion(version);
    }
  }

  public void collectReferences(
      BaseEntity owner, List<BaseEntity> entityList, String internalType) {

    addToEntityList(this, entityList, getEmployee(), internalType);
    addToEntityList(this, entityList, getCurrentSalaryGrade(), internalType);
    addToEntityList(this, entityList, getPayingOff(), internalType);
  }

  public List<BaseEntity> collectReferencesFromLists(String internalType) {

    List<BaseEntity> entityList = new ArrayList<BaseEntity>();

    return entityList;
  }

  public List<SmartList<?>> getAllRelatedLists() {
    List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

    return listOfList;
  }

  public List<KeyValuePair> keyValuePairOf() {
    List<KeyValuePair> result = super.keyValuePairOf();

    appendKeyValuePair(result, ID_PROPERTY, getId());
    appendKeyValuePair(result, EMPLOYEE_PROPERTY, getEmployee());
    appendKeyValuePair(result, CURRENT_SALARY_GRADE_PROPERTY, getCurrentSalaryGrade());
    appendKeyValuePair(result, BASE_SALARY_PROPERTY, getBaseSalary());
    appendKeyValuePair(result, BONUS_PROPERTY, getBonus());
    appendKeyValuePair(result, REWARD_PROPERTY, getReward());
    appendKeyValuePair(result, PERSONAL_TAX_PROPERTY, getPersonalTax());
    appendKeyValuePair(result, SOCIAL_SECURITY_PROPERTY, getSocialSecurity());
    appendKeyValuePair(result, HOUSING_FOUND_PROPERTY, getHousingFound());
    appendKeyValuePair(result, JOB_INSURANCE_PROPERTY, getJobInsurance());
    appendKeyValuePair(result, PAYING_OFF_PROPERTY, getPayingOff());
    appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

    if (this.valueByKey("valuesOfGroupBy") != null) {
      appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
    }
    return result;
  }

  public BaseEntity copyTo(BaseEntity baseDest) {

    super.copyTo(baseDest);
    if (baseDest instanceof EmployeeSalarySheet) {

      EmployeeSalarySheet dest = (EmployeeSalarySheet) baseDest;

      dest.setId(getId());
      dest.setEmployee(getEmployee());
      dest.setCurrentSalaryGrade(getCurrentSalaryGrade());
      dest.setBaseSalary(getBaseSalary());
      dest.setBonus(getBonus());
      dest.setReward(getReward());
      dest.setPersonalTax(getPersonalTax());
      dest.setSocialSecurity(getSocialSecurity());
      dest.setHousingFound(getHousingFound());
      dest.setJobInsurance(getJobInsurance());
      dest.setPayingOff(getPayingOff());
      dest.setVersion(getVersion());
    }

    return baseDest;
  }

  public BaseEntity mergeDataFrom(BaseEntity sourceEntity) {

    if (sourceEntity instanceof EmployeeSalarySheet) {

      EmployeeSalarySheet source = (EmployeeSalarySheet) sourceEntity;

      mergeId(source.getId());
      mergeEmployee(source.getEmployee());
      mergeCurrentSalaryGrade(source.getCurrentSalaryGrade());
      mergeBaseSalary(source.getBaseSalary());
      mergeBonus(source.getBonus());
      mergeReward(source.getReward());
      mergePersonalTax(source.getPersonalTax());
      mergeSocialSecurity(source.getSocialSecurity());
      mergeHousingFound(source.getHousingFound());
      mergeJobInsurance(source.getJobInsurance());
      mergePayingOff(source.getPayingOff());
      mergeVersion(source.getVersion());
    }

    return this;
  }

  public BaseEntity mergePrimitiveDataFrom(BaseEntity sourceEntity) {

    // super.mergePrimitiveDataFrom(sourceEntity);
    if (sourceEntity instanceof EmployeeSalarySheet) {

      EmployeeSalarySheet source = (EmployeeSalarySheet) sourceEntity;

      mergeId(source.getId());
      mergeBaseSalary(source.getBaseSalary());
      mergeBonus(source.getBonus());
      mergeReward(source.getReward());
      mergePersonalTax(source.getPersonalTax());
      mergeSocialSecurity(source.getSocialSecurity());
      mergeHousingFound(source.getHousingFound());
      mergeJobInsurance(source.getJobInsurance());
      mergeVersion(source.getVersion());
    }
    return this;
  }

  public Object[] toFlatArray() {
    return new Object[] {
      getId(),
      getEmployee(),
      getCurrentSalaryGrade(),
      getBaseSalary(),
      getBonus(),
      getReward(),
      getPersonalTax(),
      getSocialSecurity(),
      getHousingFound(),
      getJobInsurance(),
      getPayingOff(),
      getVersion()
    };
  }

  public boolean checkIfEligibleForDelete(Object ctx) {
    String id = getId();
    if (cn.hutool.core.util.ObjectUtil.isEmpty(id)) {
      throw new ErrorMessageException("缺少参数id");
    }
    EmployeeSalarySheet checkEmployeeSalarySheet =
        Q.employeeSalarySheetWithIdField().filterById(id).execute(ctx);

    return checkEmployeeSalarySheet != null
        && !checkEmployeeSalarySheet.getAllRelatedLists().stream()
            .flatMap(subList -> subList.stream())
            .findFirst()
            .isPresent();
  }

  public EmployeeSalarySheet save(com.doublechaintech.retailscm.RetailscmUserContext ctx) {
    try {
      com.doublechaintech.retailscm.RetailscmBaseUtils.saveGraph(ctx, this);
    } catch (Exception pE) {
      cn.hutool.core.exceptions.ExceptionUtil.wrapAndThrow(pE);
    }
    return this;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder(128);

    stringBuilder.append("EmployeeSalarySheet{");
    stringBuilder.append("\tid='" + getId() + "';");
    if (getEmployee() != null) {
      stringBuilder.append("\temployee='Employee(" + getEmployee().getId() + ")';");
    }
    if (getCurrentSalaryGrade() != null) {
      stringBuilder.append(
          "\tcurrentSalaryGrade='SalaryGrade(" + getCurrentSalaryGrade().getId() + ")';");
    }
    stringBuilder.append("\tbaseSalary='" + getBaseSalary() + "';");
    stringBuilder.append("\tbonus='" + getBonus() + "';");
    stringBuilder.append("\treward='" + getReward() + "';");
    stringBuilder.append("\tpersonalTax='" + getPersonalTax() + "';");
    stringBuilder.append("\tsocialSecurity='" + getSocialSecurity() + "';");
    stringBuilder.append("\thousingFound='" + getHousingFound() + "';");
    stringBuilder.append("\tjobInsurance='" + getJobInsurance() + "';");
    if (getPayingOff() != null) {
      stringBuilder.append("\tpayingOff='PayingOff(" + getPayingOff().getId() + ")';");
    }
    stringBuilder.append("\tversion='" + getVersion() + "';");
    stringBuilder.append("}");

    return stringBuilder.toString();
  }

  // provide number calculation function

}
