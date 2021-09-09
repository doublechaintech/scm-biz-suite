
package com.doublechaintech.retailscm.employee;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.levelthreedepartment.LevelThreeDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance;
import com.doublechaintech.retailscm.employeequalifier.EmployeeQualifier;
import com.doublechaintech.retailscm.employeeperformance.EmployeePerformance;
import com.doublechaintech.retailscm.employeeeducation.EmployeeEducation;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.employeeworkexperience.EmployeeWorkExperience;
import com.doublechaintech.retailscm.employeeaward.EmployeeAward;









@JsonSerialize(using = EmployeeSerializer.class)
public class Employee extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String FAMILY_NAME_PROPERTY           = "familyName"        ;
	public static final String GIVEN_NAME_PROPERTY            = "givenName"         ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String CITY_PROPERTY                  = "city"              ;
	public static final String ADDRESS_PROPERTY               = "address"           ;
	public static final String CELL_PHONE_PROPERTY            = "cellPhone"         ;
	public static final String OCCUPATION_PROPERTY            = "occupation"        ;
	public static final String RESPONSIBLE_FOR_PROPERTY       = "responsibleFor"    ;
	public static final String CURRENT_SALARY_GRADE_PROPERTY  = "currentSalaryGrade";
	public static final String SALARY_ACCOUNT_PROPERTY        = "salaryAccount"     ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_COMPANY_TRAINING_LIST           = "employeeCompanyTrainingList";
	public static final String EMPLOYEE_SKILL_LIST                      = "employeeSkillList" ;
	public static final String EMPLOYEE_PERFORMANCE_LIST                = "employeePerformanceList";
	public static final String EMPLOYEE_WORK_EXPERIENCE_LIST            = "employeeWorkExperienceList";
	public static final String EMPLOYEE_LEAVE_LIST                      = "employeeLeaveList" ;
	public static final String EMPLOYEE_INTERVIEW_LIST                  = "employeeInterviewList";
	public static final String EMPLOYEE_ATTENDANCE_LIST                 = "employeeAttendanceList";
	public static final String EMPLOYEE_QUALIFIER_LIST                  = "employeeQualifierList";
	public static final String EMPLOYEE_EDUCATION_LIST                  = "employeeEducationList";
	public static final String EMPLOYEE_AWARD_LIST                      = "employeeAwardList" ;
	public static final String EMPLOYEE_SALARY_SHEET_LIST               = "employeeSalarySheetList";
	public static final String PAYING_OFF_LIST                          = "payingOffList"     ;

	public static final String INTERNAL_TYPE="Employee";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(COMPANY_PROPERTY, "retail_store_country_center", "公司")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DEPARTMENT_PROPERTY, "level_three_department", "部门")
        .withType("level_three_department", LevelThreeDepartment.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FAMILY_NAME_PROPERTY, "family_name", "姓")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(GIVEN_NAME_PROPERTY, "given_name", "名")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EMAIL_PROPERTY, "email", "电子邮件")
        .withType("string_email", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CITY_PROPERTY, "city", "城市")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ADDRESS_PROPERTY, "address", "地址")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CELL_PHONE_PROPERTY, "cell_phone", "手机")
        .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OCCUPATION_PROPERTY, "occupation_type", "职业")
        .withType("occupation_type", OccupationType.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(RESPONSIBLE_FOR_PROPERTY, "responsibility_type", "负责")
        .withType("responsibility_type", ResponsibilityType.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CURRENT_SALARY_GRADE_PROPERTY, "salary_grade", "目前工资等级")
        .withType("salary_grade", SalaryGrade.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SALARY_ACCOUNT_PROPERTY, "salary_account", "工资账户")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_COMPANY_TRAINING_LIST, "employee", "员工公司培训名单")
        .withType("employee_company_training", EmployeeCompanyTraining.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_SKILL_LIST, "employee", "员工技能列表")
        .withType("employee_skill", EmployeeSkill.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_PERFORMANCE_LIST, "employee", "员工绩效表")
        .withType("employee_performance", EmployeePerformance.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_WORK_EXPERIENCE_LIST, "employee", "员工工作经历")
        .withType("employee_work_experience", EmployeeWorkExperience.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_LEAVE_LIST, "who", "员工离开列表")
        .withType("employee_leave", EmployeeLeave.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_INTERVIEW_LIST, "employee", "员工面试名单")
        .withType("employee_interview", EmployeeInterview.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_ATTENDANCE_LIST, "employee", "员工出勤表")
        .withType("employee_attendance", EmployeeAttendance.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_QUALIFIER_LIST, "employee", "员工限定符列表")
        .withType("employee_qualifier", EmployeeQualifier.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_EDUCATION_LIST, "employee", "教育员工列表")
        .withType("employee_education", EmployeeEducation.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_AWARD_LIST, "employee", "员工奖名单")
        .withType("employee_award", EmployeeAward.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_SALARY_SHEET_LIST, "employee", "员工工资表")
        .withType("employee_salary_sheet", EmployeeSalarySheet.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(PAYING_OFF_LIST, "paidFor", "偿还列表")
        .withType("paying_off", PayingOff.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,COMPANY_PROPERTY ,TITLE_PROPERTY ,DEPARTMENT_PROPERTY ,FAMILY_NAME_PROPERTY ,GIVEN_NAME_PROPERTY ,EMAIL_PROPERTY ,CITY_PROPERTY ,ADDRESS_PROPERTY ,CELL_PHONE_PROPERTY ,OCCUPATION_PROPERTY ,RESPONSIBLE_FOR_PROPERTY ,CURRENT_SALARY_GRADE_PROPERTY ,SALARY_ACCOUNT_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(EMPLOYEE_COMPANY_TRAINING_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_SKILL_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_PERFORMANCE_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_WORK_EXPERIENCE_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_LEAVE_LIST, "who");
    	
    	    refers.put(EMPLOYEE_INTERVIEW_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_ATTENDANCE_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_QUALIFIER_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_EDUCATION_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_AWARD_LIST, "employee");
    	
    	    refers.put(EMPLOYEE_SALARY_SHEET_LIST, "employee");
    	
    	    refers.put(PAYING_OFF_LIST, "paidFor");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(EMPLOYEE_COMPANY_TRAINING_LIST, EmployeeCompanyTraining.class);
        	
        	    refers.put(EMPLOYEE_SKILL_LIST, EmployeeSkill.class);
        	
        	    refers.put(EMPLOYEE_PERFORMANCE_LIST, EmployeePerformance.class);
        	
        	    refers.put(EMPLOYEE_WORK_EXPERIENCE_LIST, EmployeeWorkExperience.class);
        	
        	    refers.put(EMPLOYEE_LEAVE_LIST, EmployeeLeave.class);
        	
        	    refers.put(EMPLOYEE_INTERVIEW_LIST, EmployeeInterview.class);
        	
        	    refers.put(EMPLOYEE_ATTENDANCE_LIST, EmployeeAttendance.class);
        	
        	    refers.put(EMPLOYEE_QUALIFIER_LIST, EmployeeQualifier.class);
        	
        	    refers.put(EMPLOYEE_EDUCATION_LIST, EmployeeEducation.class);
        	
        	    refers.put(EMPLOYEE_AWARD_LIST, EmployeeAward.class);
        	
        	    refers.put(EMPLOYEE_SALARY_SHEET_LIST, EmployeeSalarySheet.class);
        	
        	    refers.put(PAYING_OFF_LIST, PayingOff.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);
parents.put(DEPARTMENT_PROPERTY, LevelThreeDepartment.class);
parents.put(OCCUPATION_PROPERTY, OccupationType.class);
parents.put(RESPONSIBLE_FOR_PROPERTY, ResponsibilityType.class);
parents.put(CURRENT_SALARY_GRADE_PROPERTY, SalaryGrade.class);

    return parents;
  }

  public Employee want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Employee wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		RetailStoreCountryCenter	company             ;
	protected		String              	title               ;
	protected		LevelThreeDepartment	department          ;
	protected		String              	familyName          ;
	protected		String              	givenName           ;
	protected		String              	email               ;
	protected		String              	city                ;
	protected		String              	address             ;
	protected		String              	cellPhone           ;
	protected		OccupationType      	occupation          ;
	protected		ResponsibilityType  	responsibleFor      ;
	protected		SalaryGrade         	currentSalaryGrade  ;
	protected		String              	salaryAccount       ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<EmployeeCompanyTraining>	mEmployeeCompanyTrainingList;
	protected		SmartList<EmployeeSkill>	mEmployeeSkillList  ;
	protected		SmartList<EmployeePerformance>	mEmployeePerformanceList;
	protected		SmartList<EmployeeWorkExperience>	mEmployeeWorkExperienceList;
	protected		SmartList<EmployeeLeave>	mEmployeeLeaveList  ;
	protected		SmartList<EmployeeInterview>	mEmployeeInterviewList;
	protected		SmartList<EmployeeAttendance>	mEmployeeAttendanceList;
	protected		SmartList<EmployeeQualifier>	mEmployeeQualifierList;
	protected		SmartList<EmployeeEducation>	mEmployeeEducationList;
	protected		SmartList<EmployeeAward>	mEmployeeAwardList  ;
	protected		SmartList<EmployeeSalarySheet>	mEmployeeSalarySheetList;
	protected		SmartList<PayingOff>	mPayingOffList      ;



	public 	Employee(){
		// lazy load for all the properties
	}
	public 	static Employee withId(String id){
		Employee employee = new Employee();
		employee.setId(id);
		employee.setVersion(Integer.MAX_VALUE);
		employee.setChecked(true);
		return employee;
	}
	public 	static Employee refById(String id){
		return withId(id);
	}

  public Employee limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Employee limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Employee searchExample(){
    Employee employee = new Employee();
    		employee.setVersion(UNSET_INT);

    return employee;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );
		setDepartment( null );
		setOccupation( null );
		setResponsibleFor( null );
		setCurrentSalaryGrade( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(FAMILY_NAME_PROPERTY.equals(property)){
			changeFamilyNameProperty(newValueExpr);
		}
		if(GIVEN_NAME_PROPERTY.equals(property)){
			changeGivenNameProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(CITY_PROPERTY.equals(property)){
			changeCityProperty(newValueExpr);
		}
		if(ADDRESS_PROPERTY.equals(property)){
			changeAddressProperty(newValueExpr);
		}
		if(CELL_PHONE_PROPERTY.equals(property)){
			changeCellPhoneProperty(newValueExpr);
		}
		if(SALARY_ACCOUNT_PROPERTY.equals(property)){
			changeSalaryAccountProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
	
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFamilyNameProperty(String newValueExpr){
	
		String oldValue = getFamilyName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFamilyName(newValue);
		this.onChangeProperty(FAMILY_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeGivenNameProperty(String newValueExpr){
	
		String oldValue = getGivenName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateGivenName(newValue);
		this.onChangeProperty(GIVEN_NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
	
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEmail(newValue);
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCityProperty(String newValueExpr){
	
		String oldValue = getCity();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCity(newValue);
		this.onChangeProperty(CITY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAddressProperty(String newValueExpr){
	
		String oldValue = getAddress();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAddress(newValue);
		this.onChangeProperty(ADDRESS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCellPhoneProperty(String newValueExpr){
	
		String oldValue = getCellPhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCellPhone(newValue);
		this.onChangeProperty(CELL_PHONE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeSalaryAccountProperty(String newValueExpr){
	
		String oldValue = getSalaryAccount();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSalaryAccount(newValue);
		this.onChangeProperty(SALARY_ACCOUNT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(COMPANY_PROPERTY.equals(property)){
			return getCompany();
		}
		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(DEPARTMENT_PROPERTY.equals(property)){
			return getDepartment();
		}
		if(FAMILY_NAME_PROPERTY.equals(property)){
			return getFamilyName();
		}
		if(GIVEN_NAME_PROPERTY.equals(property)){
			return getGivenName();
		}
		if(EMAIL_PROPERTY.equals(property)){
			return getEmail();
		}
		if(CITY_PROPERTY.equals(property)){
			return getCity();
		}
		if(ADDRESS_PROPERTY.equals(property)){
			return getAddress();
		}
		if(CELL_PHONE_PROPERTY.equals(property)){
			return getCellPhone();
		}
		if(OCCUPATION_PROPERTY.equals(property)){
			return getOccupation();
		}
		if(RESPONSIBLE_FOR_PROPERTY.equals(property)){
			return getResponsibleFor();
		}
		if(CURRENT_SALARY_GRADE_PROPERTY.equals(property)){
			return getCurrentSalaryGrade();
		}
		if(SALARY_ACCOUNT_PROPERTY.equals(property)){
			return getSalaryAccount();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(EMPLOYEE_COMPANY_TRAINING_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeCompanyTrainingList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_SKILL_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeSkillList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_PERFORMANCE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeePerformanceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_WORK_EXPERIENCE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeWorkExperienceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_LEAVE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeLeaveList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_INTERVIEW_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeInterviewList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_ATTENDANCE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeAttendanceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_QUALIFIER_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeQualifierList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_EDUCATION_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeEducationList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_AWARD_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeAwardList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(EMPLOYEE_SALARY_SHEET_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeSalarySheetList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(PAYING_OFF_LIST.equals(property)){
			List<BaseEntity> list = getPayingOffList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public Employee updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Employee orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Employee ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Employee addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setCompany(RetailStoreCountryCenter company){RetailStoreCountryCenter oldCompany = this.company;RetailStoreCountryCenter newCompany = company;this.company = newCompany;}
	public RetailStoreCountryCenter company(){
doLoad();
return getCompany();
}
	public RetailStoreCountryCenter getCompany(){
		return this.company;
	}
	public Employee updateCompany(RetailStoreCountryCenter company){RetailStoreCountryCenter oldCompany = this.company;RetailStoreCountryCenter newCompany = company;if(!shouldReplaceBy(newCompany, oldCompany)){return this;}this.company = newCompany;addPropertyChange(COMPANY_PROPERTY, oldCompany, newCompany);this.changed = true;setChecked(false);return this;}
	public Employee orderByCompany(boolean asc){
doAddOrderBy(COMPANY_PROPERTY, asc);
return this;
}
	public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters){
return createCriteria(COMPANY_PROPERTY, operator, parameters);
}
	public Employee ignoreCompanyCriteria(){super.ignoreSearchProperty(COMPANY_PROPERTY);
return this;
}
	public Employee addCompanyCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCompanyCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCompany(RetailStoreCountryCenter company){
		if(company != null) { setCompany(company);}
	}

	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);this.title = newTitle;}
	public String title(){
doLoad();
return getTitle();
}
	public String getTitle(){
		return this.title;
	}
	public Employee updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public Employee orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public Employee ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public Employee addTitleCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTitleCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}

	
	public void setDepartment(LevelThreeDepartment department){LevelThreeDepartment oldDepartment = this.department;LevelThreeDepartment newDepartment = department;this.department = newDepartment;}
	public LevelThreeDepartment department(){
doLoad();
return getDepartment();
}
	public LevelThreeDepartment getDepartment(){
		return this.department;
	}
	public Employee updateDepartment(LevelThreeDepartment department){LevelThreeDepartment oldDepartment = this.department;LevelThreeDepartment newDepartment = department;if(!shouldReplaceBy(newDepartment, oldDepartment)){return this;}this.department = newDepartment;addPropertyChange(DEPARTMENT_PROPERTY, oldDepartment, newDepartment);this.changed = true;setChecked(false);return this;}
	public Employee orderByDepartment(boolean asc){
doAddOrderBy(DEPARTMENT_PROPERTY, asc);
return this;
}
	public SearchCriteria createDepartmentCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DEPARTMENT_PROPERTY, operator, parameters);
}
	public Employee ignoreDepartmentCriteria(){super.ignoreSearchProperty(DEPARTMENT_PROPERTY);
return this;
}
	public Employee addDepartmentCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDepartmentCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDepartment(LevelThreeDepartment department){
		if(department != null) { setDepartment(department);}
	}

	
	public void clearDepartment(){
		setDepartment ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setFamilyName(String familyName){String oldFamilyName = this.familyName;String newFamilyName = trimString(familyName);this.familyName = newFamilyName;}
	public String familyName(){
doLoad();
return getFamilyName();
}
	public String getFamilyName(){
		return this.familyName;
	}
	public Employee updateFamilyName(String familyName){String oldFamilyName = this.familyName;String newFamilyName = trimString(familyName);if(!shouldReplaceBy(newFamilyName, oldFamilyName)){return this;}this.familyName = newFamilyName;addPropertyChange(FAMILY_NAME_PROPERTY, oldFamilyName, newFamilyName);this.changed = true;setChecked(false);return this;}
	public Employee orderByFamilyName(boolean asc){
doAddOrderBy(FAMILY_NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createFamilyNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FAMILY_NAME_PROPERTY, operator, parameters);
}
	public Employee ignoreFamilyNameCriteria(){super.ignoreSearchProperty(FAMILY_NAME_PROPERTY);
return this;
}
	public Employee addFamilyNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFamilyNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFamilyName(String familyName){
		if(familyName != null) { setFamilyName(familyName);}
	}

	
	public void setGivenName(String givenName){String oldGivenName = this.givenName;String newGivenName = trimString(givenName);this.givenName = newGivenName;}
	public String givenName(){
doLoad();
return getGivenName();
}
	public String getGivenName(){
		return this.givenName;
	}
	public Employee updateGivenName(String givenName){String oldGivenName = this.givenName;String newGivenName = trimString(givenName);if(!shouldReplaceBy(newGivenName, oldGivenName)){return this;}this.givenName = newGivenName;addPropertyChange(GIVEN_NAME_PROPERTY, oldGivenName, newGivenName);this.changed = true;setChecked(false);return this;}
	public Employee orderByGivenName(boolean asc){
doAddOrderBy(GIVEN_NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createGivenNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(GIVEN_NAME_PROPERTY, operator, parameters);
}
	public Employee ignoreGivenNameCriteria(){super.ignoreSearchProperty(GIVEN_NAME_PROPERTY);
return this;
}
	public Employee addGivenNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createGivenNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeGivenName(String givenName){
		if(givenName != null) { setGivenName(givenName);}
	}

	
	public void setEmail(String email){String oldEmail = this.email;String newEmail = trimString(email);this.email = newEmail;}
	public String email(){
doLoad();
return getEmail();
}
	public String getEmail(){
		return this.email;
	}
	public Employee updateEmail(String email){String oldEmail = this.email;String newEmail = trimString(email);if(!shouldReplaceBy(newEmail, oldEmail)){return this;}this.email = newEmail;addPropertyChange(EMAIL_PROPERTY, oldEmail, newEmail);this.changed = true;setChecked(false);return this;}
	public Employee orderByEmail(boolean asc){
doAddOrderBy(EMAIL_PROPERTY, asc);
return this;
}
	public SearchCriteria createEmailCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EMAIL_PROPERTY, operator, parameters);
}
	public Employee ignoreEmailCriteria(){super.ignoreSearchProperty(EMAIL_PROPERTY);
return this;
}
	public Employee addEmailCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createEmailCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}

	
	public void setCity(String city){String oldCity = this.city;String newCity = trimString(city);this.city = newCity;}
	public String city(){
doLoad();
return getCity();
}
	public String getCity(){
		return this.city;
	}
	public Employee updateCity(String city){String oldCity = this.city;String newCity = trimString(city);if(!shouldReplaceBy(newCity, oldCity)){return this;}this.city = newCity;addPropertyChange(CITY_PROPERTY, oldCity, newCity);this.changed = true;setChecked(false);return this;}
	public Employee orderByCity(boolean asc){
doAddOrderBy(CITY_PROPERTY, asc);
return this;
}
	public SearchCriteria createCityCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CITY_PROPERTY, operator, parameters);
}
	public Employee ignoreCityCriteria(){super.ignoreSearchProperty(CITY_PROPERTY);
return this;
}
	public Employee addCityCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCityCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCity(String city){
		if(city != null) { setCity(city);}
	}

	
	public void setAddress(String address){String oldAddress = this.address;String newAddress = trimString(address);this.address = newAddress;}
	public String address(){
doLoad();
return getAddress();
}
	public String getAddress(){
		return this.address;
	}
	public Employee updateAddress(String address){String oldAddress = this.address;String newAddress = trimString(address);if(!shouldReplaceBy(newAddress, oldAddress)){return this;}this.address = newAddress;addPropertyChange(ADDRESS_PROPERTY, oldAddress, newAddress);this.changed = true;setChecked(false);return this;}
	public Employee orderByAddress(boolean asc){
doAddOrderBy(ADDRESS_PROPERTY, asc);
return this;
}
	public SearchCriteria createAddressCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ADDRESS_PROPERTY, operator, parameters);
}
	public Employee ignoreAddressCriteria(){super.ignoreSearchProperty(ADDRESS_PROPERTY);
return this;
}
	public Employee addAddressCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createAddressCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeAddress(String address){
		if(address != null) { setAddress(address);}
	}

	
	public void setCellPhone(String cellPhone){String oldCellPhone = this.cellPhone;String newCellPhone = trimString(cellPhone);this.cellPhone = newCellPhone;}
	public String cellPhone(){
doLoad();
return getCellPhone();
}
	public String getCellPhone(){
		return this.cellPhone;
	}
	public Employee updateCellPhone(String cellPhone){String oldCellPhone = this.cellPhone;String newCellPhone = trimString(cellPhone);if(!shouldReplaceBy(newCellPhone, oldCellPhone)){return this;}this.cellPhone = newCellPhone;addPropertyChange(CELL_PHONE_PROPERTY, oldCellPhone, newCellPhone);this.changed = true;setChecked(false);return this;}
	public Employee orderByCellPhone(boolean asc){
doAddOrderBy(CELL_PHONE_PROPERTY, asc);
return this;
}
	public SearchCriteria createCellPhoneCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CELL_PHONE_PROPERTY, operator, parameters);
}
	public Employee ignoreCellPhoneCriteria(){super.ignoreSearchProperty(CELL_PHONE_PROPERTY);
return this;
}
	public Employee addCellPhoneCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCellPhoneCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCellPhone(String cellPhone){
		if(cellPhone != null) { setCellPhone(cellPhone);}
	}

	

	public String getMaskedCellPhone(){
		String mobilePhoneNumber = getCellPhone();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}

		
	public void setOccupation(OccupationType occupation){OccupationType oldOccupation = this.occupation;OccupationType newOccupation = occupation;this.occupation = newOccupation;}
	public OccupationType occupation(){
doLoad();
return getOccupation();
}
	public OccupationType getOccupation(){
		return this.occupation;
	}
	public Employee updateOccupation(OccupationType occupation){OccupationType oldOccupation = this.occupation;OccupationType newOccupation = occupation;if(!shouldReplaceBy(newOccupation, oldOccupation)){return this;}this.occupation = newOccupation;addPropertyChange(OCCUPATION_PROPERTY, oldOccupation, newOccupation);this.changed = true;setChecked(false);return this;}
	public Employee orderByOccupation(boolean asc){
doAddOrderBy(OCCUPATION_PROPERTY, asc);
return this;
}
	public SearchCriteria createOccupationCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OCCUPATION_PROPERTY, operator, parameters);
}
	public Employee ignoreOccupationCriteria(){super.ignoreSearchProperty(OCCUPATION_PROPERTY);
return this;
}
	public Employee addOccupationCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOccupationCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOccupation(OccupationType occupation){
		if(occupation != null) { setOccupation(occupation);}
	}

	
	public void clearOccupation(){
		setOccupation ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setResponsibleFor(ResponsibilityType responsibleFor){ResponsibilityType oldResponsibleFor = this.responsibleFor;ResponsibilityType newResponsibleFor = responsibleFor;this.responsibleFor = newResponsibleFor;}
	public ResponsibilityType responsibleFor(){
doLoad();
return getResponsibleFor();
}
	public ResponsibilityType getResponsibleFor(){
		return this.responsibleFor;
	}
	public Employee updateResponsibleFor(ResponsibilityType responsibleFor){ResponsibilityType oldResponsibleFor = this.responsibleFor;ResponsibilityType newResponsibleFor = responsibleFor;if(!shouldReplaceBy(newResponsibleFor, oldResponsibleFor)){return this;}this.responsibleFor = newResponsibleFor;addPropertyChange(RESPONSIBLE_FOR_PROPERTY, oldResponsibleFor, newResponsibleFor);this.changed = true;setChecked(false);return this;}
	public Employee orderByResponsibleFor(boolean asc){
doAddOrderBy(RESPONSIBLE_FOR_PROPERTY, asc);
return this;
}
	public SearchCriteria createResponsibleForCriteria(QueryOperator operator, Object... parameters){
return createCriteria(RESPONSIBLE_FOR_PROPERTY, operator, parameters);
}
	public Employee ignoreResponsibleForCriteria(){super.ignoreSearchProperty(RESPONSIBLE_FOR_PROPERTY);
return this;
}
	public Employee addResponsibleForCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createResponsibleForCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeResponsibleFor(ResponsibilityType responsibleFor){
		if(responsibleFor != null) { setResponsibleFor(responsibleFor);}
	}

	
	public void clearResponsibleFor(){
		setResponsibleFor ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setCurrentSalaryGrade(SalaryGrade currentSalaryGrade){SalaryGrade oldCurrentSalaryGrade = this.currentSalaryGrade;SalaryGrade newCurrentSalaryGrade = currentSalaryGrade;this.currentSalaryGrade = newCurrentSalaryGrade;}
	public SalaryGrade currentSalaryGrade(){
doLoad();
return getCurrentSalaryGrade();
}
	public SalaryGrade getCurrentSalaryGrade(){
		return this.currentSalaryGrade;
	}
	public Employee updateCurrentSalaryGrade(SalaryGrade currentSalaryGrade){SalaryGrade oldCurrentSalaryGrade = this.currentSalaryGrade;SalaryGrade newCurrentSalaryGrade = currentSalaryGrade;if(!shouldReplaceBy(newCurrentSalaryGrade, oldCurrentSalaryGrade)){return this;}this.currentSalaryGrade = newCurrentSalaryGrade;addPropertyChange(CURRENT_SALARY_GRADE_PROPERTY, oldCurrentSalaryGrade, newCurrentSalaryGrade);this.changed = true;setChecked(false);return this;}
	public Employee orderByCurrentSalaryGrade(boolean asc){
doAddOrderBy(CURRENT_SALARY_GRADE_PROPERTY, asc);
return this;
}
	public SearchCriteria createCurrentSalaryGradeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CURRENT_SALARY_GRADE_PROPERTY, operator, parameters);
}
	public Employee ignoreCurrentSalaryGradeCriteria(){super.ignoreSearchProperty(CURRENT_SALARY_GRADE_PROPERTY);
return this;
}
	public Employee addCurrentSalaryGradeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCurrentSalaryGradeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
		if(currentSalaryGrade != null) { setCurrentSalaryGrade(currentSalaryGrade);}
	}

	
	public void clearCurrentSalaryGrade(){
		setCurrentSalaryGrade ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setSalaryAccount(String salaryAccount){String oldSalaryAccount = this.salaryAccount;String newSalaryAccount = trimString(salaryAccount);this.salaryAccount = newSalaryAccount;}
	public String salaryAccount(){
doLoad();
return getSalaryAccount();
}
	public String getSalaryAccount(){
		return this.salaryAccount;
	}
	public Employee updateSalaryAccount(String salaryAccount){String oldSalaryAccount = this.salaryAccount;String newSalaryAccount = trimString(salaryAccount);if(!shouldReplaceBy(newSalaryAccount, oldSalaryAccount)){return this;}this.salaryAccount = newSalaryAccount;addPropertyChange(SALARY_ACCOUNT_PROPERTY, oldSalaryAccount, newSalaryAccount);this.changed = true;setChecked(false);return this;}
	public Employee orderBySalaryAccount(boolean asc){
doAddOrderBy(SALARY_ACCOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createSalaryAccountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SALARY_ACCOUNT_PROPERTY, operator, parameters);
}
	public Employee ignoreSalaryAccountCriteria(){super.ignoreSearchProperty(SALARY_ACCOUNT_PROPERTY);
return this;
}
	public Employee addSalaryAccountCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSalaryAccountCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSalaryAccount(String salaryAccount){
		if(salaryAccount != null) { setSalaryAccount(salaryAccount);}
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public Employee updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public Employee orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public Employee ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public Employee addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public Employee updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Employee orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Employee ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Employee addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<EmployeeCompanyTraining> getEmployeeCompanyTrainingList(){
		if(this.mEmployeeCompanyTrainingList == null){
			this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();
			this.mEmployeeCompanyTrainingList.setListInternalName (EMPLOYEE_COMPANY_TRAINING_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeCompanyTrainingList;
	}

  public  SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList(){
    
    doLoadChild(EMPLOYEE_COMPANY_TRAINING_LIST);
    
    return getEmployeeCompanyTrainingList();
  }


	public  void setEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setEmployee(this);
		}

		this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
		this.mEmployeeCompanyTrainingList.setListInternalName (EMPLOYEE_COMPANY_TRAINING_LIST );

	}

	public  Employee addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		employeeCompanyTraining.setEmployee(this);
		getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
		return this;
	}
	public  Employee addEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setEmployee(this);
		}
		getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
		return this;
	}
	public  void mergeEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		if(employeeCompanyTrainingList==null){
			return;
		}
		if(employeeCompanyTrainingList.isEmpty()){
			return;
		}
		addEmployeeCompanyTrainingList( employeeCompanyTrainingList );

	}
	public  EmployeeCompanyTraining removeEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTrainingIndex){

		int index = getEmployeeCompanyTrainingList().indexOf(employeeCompanyTrainingIndex);
        if(index < 0){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTrainingIndex.getId()+") with version='"+employeeCompanyTrainingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeCompanyTraining employeeCompanyTraining = getEmployeeCompanyTrainingList().get(index);
        // employeeCompanyTraining.clearEmployee(); //disconnect with Employee
        employeeCompanyTraining.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeCompanyTrainingList().planToRemove(employeeCompanyTraining);
        if(!result){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTrainingIndex.getId()+") with version='"+employeeCompanyTrainingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeCompanyTraining;


	}
	//断舍离
	public  void breakWithEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){

		if(employeeCompanyTraining == null){
			return;
		}
		employeeCompanyTraining.setEmployee(null);
		//getEmployeeCompanyTrainingList().remove();

	}

	public  boolean hasEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){

		return getEmployeeCompanyTrainingList().contains(employeeCompanyTraining);

	}

	public void copyEmployeeCompanyTrainingFrom(EmployeeCompanyTraining employeeCompanyTraining) {

		EmployeeCompanyTraining employeeCompanyTrainingInList = findTheEmployeeCompanyTraining(employeeCompanyTraining);
		EmployeeCompanyTraining newEmployeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTrainingInList.copyTo(newEmployeeCompanyTraining);
		newEmployeeCompanyTraining.setVersion(0);//will trigger copy
		getEmployeeCompanyTrainingList().add(newEmployeeCompanyTraining);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeCompanyTraining);
	}

	public  EmployeeCompanyTraining findTheEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){

		int index =  getEmployeeCompanyTrainingList().indexOf(employeeCompanyTraining);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeCompanyTraining("+employeeCompanyTraining.getId()+") with version='"+employeeCompanyTraining.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeCompanyTrainingList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeCompanyTrainingList(){
		getEmployeeCompanyTrainingList().clear();
	}





	public  SmartList<EmployeeSkill> getEmployeeSkillList(){
		if(this.mEmployeeSkillList == null){
			this.mEmployeeSkillList = new SmartList<EmployeeSkill>();
			this.mEmployeeSkillList.setListInternalName (EMPLOYEE_SKILL_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeSkillList;
	}

  public  SmartList<EmployeeSkill> employeeSkillList(){
    
    doLoadChild(EMPLOYEE_SKILL_LIST);
    
    return getEmployeeSkillList();
  }


	public  void setEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setEmployee(this);
		}

		this.mEmployeeSkillList = employeeSkillList;
		this.mEmployeeSkillList.setListInternalName (EMPLOYEE_SKILL_LIST );

	}

	public  Employee addEmployeeSkill(EmployeeSkill employeeSkill){
		employeeSkill.setEmployee(this);
		getEmployeeSkillList().add(employeeSkill);
		return this;
	}
	public  Employee addEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setEmployee(this);
		}
		getEmployeeSkillList().addAll(employeeSkillList);
		return this;
	}
	public  void mergeEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		if(employeeSkillList==null){
			return;
		}
		if(employeeSkillList.isEmpty()){
			return;
		}
		addEmployeeSkillList( employeeSkillList );

	}
	public  EmployeeSkill removeEmployeeSkill(EmployeeSkill employeeSkillIndex){

		int index = getEmployeeSkillList().indexOf(employeeSkillIndex);
        if(index < 0){
        	String message = "EmployeeSkill("+employeeSkillIndex.getId()+") with version='"+employeeSkillIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeSkill employeeSkill = getEmployeeSkillList().get(index);
        // employeeSkill.clearEmployee(); //disconnect with Employee
        employeeSkill.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeSkillList().planToRemove(employeeSkill);
        if(!result){
        	String message = "EmployeeSkill("+employeeSkillIndex.getId()+") with version='"+employeeSkillIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeSkill;


	}
	//断舍离
	public  void breakWithEmployeeSkill(EmployeeSkill employeeSkill){

		if(employeeSkill == null){
			return;
		}
		employeeSkill.setEmployee(null);
		//getEmployeeSkillList().remove();

	}

	public  boolean hasEmployeeSkill(EmployeeSkill employeeSkill){

		return getEmployeeSkillList().contains(employeeSkill);

	}

	public void copyEmployeeSkillFrom(EmployeeSkill employeeSkill) {

		EmployeeSkill employeeSkillInList = findTheEmployeeSkill(employeeSkill);
		EmployeeSkill newEmployeeSkill = new EmployeeSkill();
		employeeSkillInList.copyTo(newEmployeeSkill);
		newEmployeeSkill.setVersion(0);//will trigger copy
		getEmployeeSkillList().add(newEmployeeSkill);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeSkill);
	}

	public  EmployeeSkill findTheEmployeeSkill(EmployeeSkill employeeSkill){

		int index =  getEmployeeSkillList().indexOf(employeeSkill);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeSkill("+employeeSkill.getId()+") with version='"+employeeSkill.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeSkillList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeSkillList(){
		getEmployeeSkillList().clear();
	}





	public  SmartList<EmployeePerformance> getEmployeePerformanceList(){
		if(this.mEmployeePerformanceList == null){
			this.mEmployeePerformanceList = new SmartList<EmployeePerformance>();
			this.mEmployeePerformanceList.setListInternalName (EMPLOYEE_PERFORMANCE_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeePerformanceList;
	}

  public  SmartList<EmployeePerformance> employeePerformanceList(){
    
    doLoadChild(EMPLOYEE_PERFORMANCE_LIST);
    
    return getEmployeePerformanceList();
  }


	public  void setEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList){
		for( EmployeePerformance employeePerformance:employeePerformanceList){
			employeePerformance.setEmployee(this);
		}

		this.mEmployeePerformanceList = employeePerformanceList;
		this.mEmployeePerformanceList.setListInternalName (EMPLOYEE_PERFORMANCE_LIST );

	}

	public  Employee addEmployeePerformance(EmployeePerformance employeePerformance){
		employeePerformance.setEmployee(this);
		getEmployeePerformanceList().add(employeePerformance);
		return this;
	}
	public  Employee addEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList){
		for( EmployeePerformance employeePerformance:employeePerformanceList){
			employeePerformance.setEmployee(this);
		}
		getEmployeePerformanceList().addAll(employeePerformanceList);
		return this;
	}
	public  void mergeEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList){
		if(employeePerformanceList==null){
			return;
		}
		if(employeePerformanceList.isEmpty()){
			return;
		}
		addEmployeePerformanceList( employeePerformanceList );

	}
	public  EmployeePerformance removeEmployeePerformance(EmployeePerformance employeePerformanceIndex){

		int index = getEmployeePerformanceList().indexOf(employeePerformanceIndex);
        if(index < 0){
        	String message = "EmployeePerformance("+employeePerformanceIndex.getId()+") with version='"+employeePerformanceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeePerformance employeePerformance = getEmployeePerformanceList().get(index);
        // employeePerformance.clearEmployee(); //disconnect with Employee
        employeePerformance.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeePerformanceList().planToRemove(employeePerformance);
        if(!result){
        	String message = "EmployeePerformance("+employeePerformanceIndex.getId()+") with version='"+employeePerformanceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeePerformance;


	}
	//断舍离
	public  void breakWithEmployeePerformance(EmployeePerformance employeePerformance){

		if(employeePerformance == null){
			return;
		}
		employeePerformance.setEmployee(null);
		//getEmployeePerformanceList().remove();

	}

	public  boolean hasEmployeePerformance(EmployeePerformance employeePerformance){

		return getEmployeePerformanceList().contains(employeePerformance);

	}

	public void copyEmployeePerformanceFrom(EmployeePerformance employeePerformance) {

		EmployeePerformance employeePerformanceInList = findTheEmployeePerformance(employeePerformance);
		EmployeePerformance newEmployeePerformance = new EmployeePerformance();
		employeePerformanceInList.copyTo(newEmployeePerformance);
		newEmployeePerformance.setVersion(0);//will trigger copy
		getEmployeePerformanceList().add(newEmployeePerformance);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeePerformance);
	}

	public  EmployeePerformance findTheEmployeePerformance(EmployeePerformance employeePerformance){

		int index =  getEmployeePerformanceList().indexOf(employeePerformance);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeePerformance("+employeePerformance.getId()+") with version='"+employeePerformance.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeePerformanceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeePerformanceList(){
		getEmployeePerformanceList().clear();
	}





	public  SmartList<EmployeeWorkExperience> getEmployeeWorkExperienceList(){
		if(this.mEmployeeWorkExperienceList == null){
			this.mEmployeeWorkExperienceList = new SmartList<EmployeeWorkExperience>();
			this.mEmployeeWorkExperienceList.setListInternalName (EMPLOYEE_WORK_EXPERIENCE_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeWorkExperienceList;
	}

  public  SmartList<EmployeeWorkExperience> employeeWorkExperienceList(){
    
    doLoadChild(EMPLOYEE_WORK_EXPERIENCE_LIST);
    
    return getEmployeeWorkExperienceList();
  }


	public  void setEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList){
		for( EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			employeeWorkExperience.setEmployee(this);
		}

		this.mEmployeeWorkExperienceList = employeeWorkExperienceList;
		this.mEmployeeWorkExperienceList.setListInternalName (EMPLOYEE_WORK_EXPERIENCE_LIST );

	}

	public  Employee addEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){
		employeeWorkExperience.setEmployee(this);
		getEmployeeWorkExperienceList().add(employeeWorkExperience);
		return this;
	}
	public  Employee addEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList){
		for( EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			employeeWorkExperience.setEmployee(this);
		}
		getEmployeeWorkExperienceList().addAll(employeeWorkExperienceList);
		return this;
	}
	public  void mergeEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList){
		if(employeeWorkExperienceList==null){
			return;
		}
		if(employeeWorkExperienceList.isEmpty()){
			return;
		}
		addEmployeeWorkExperienceList( employeeWorkExperienceList );

	}
	public  EmployeeWorkExperience removeEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperienceIndex){

		int index = getEmployeeWorkExperienceList().indexOf(employeeWorkExperienceIndex);
        if(index < 0){
        	String message = "EmployeeWorkExperience("+employeeWorkExperienceIndex.getId()+") with version='"+employeeWorkExperienceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeWorkExperience employeeWorkExperience = getEmployeeWorkExperienceList().get(index);
        // employeeWorkExperience.clearEmployee(); //disconnect with Employee
        employeeWorkExperience.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeWorkExperienceList().planToRemove(employeeWorkExperience);
        if(!result){
        	String message = "EmployeeWorkExperience("+employeeWorkExperienceIndex.getId()+") with version='"+employeeWorkExperienceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeWorkExperience;


	}
	//断舍离
	public  void breakWithEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){

		if(employeeWorkExperience == null){
			return;
		}
		employeeWorkExperience.setEmployee(null);
		//getEmployeeWorkExperienceList().remove();

	}

	public  boolean hasEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){

		return getEmployeeWorkExperienceList().contains(employeeWorkExperience);

	}

	public void copyEmployeeWorkExperienceFrom(EmployeeWorkExperience employeeWorkExperience) {

		EmployeeWorkExperience employeeWorkExperienceInList = findTheEmployeeWorkExperience(employeeWorkExperience);
		EmployeeWorkExperience newEmployeeWorkExperience = new EmployeeWorkExperience();
		employeeWorkExperienceInList.copyTo(newEmployeeWorkExperience);
		newEmployeeWorkExperience.setVersion(0);//will trigger copy
		getEmployeeWorkExperienceList().add(newEmployeeWorkExperience);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeWorkExperience);
	}

	public  EmployeeWorkExperience findTheEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){

		int index =  getEmployeeWorkExperienceList().indexOf(employeeWorkExperience);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeWorkExperience("+employeeWorkExperience.getId()+") with version='"+employeeWorkExperience.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeWorkExperienceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeWorkExperienceList(){
		getEmployeeWorkExperienceList().clear();
	}





	public  SmartList<EmployeeLeave> getEmployeeLeaveList(){
		if(this.mEmployeeLeaveList == null){
			this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();
			this.mEmployeeLeaveList.setListInternalName (EMPLOYEE_LEAVE_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeLeaveList;
	}

  public  SmartList<EmployeeLeave> employeeLeaveList(){
    
    doLoadChild(EMPLOYEE_LEAVE_LIST);
    
    return getEmployeeLeaveList();
  }


	public  void setEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setWho(this);
		}

		this.mEmployeeLeaveList = employeeLeaveList;
		this.mEmployeeLeaveList.setListInternalName (EMPLOYEE_LEAVE_LIST );

	}

	public  Employee addEmployeeLeave(EmployeeLeave employeeLeave){
		employeeLeave.setWho(this);
		getEmployeeLeaveList().add(employeeLeave);
		return this;
	}
	public  Employee addEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setWho(this);
		}
		getEmployeeLeaveList().addAll(employeeLeaveList);
		return this;
	}
	public  void mergeEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		if(employeeLeaveList==null){
			return;
		}
		if(employeeLeaveList.isEmpty()){
			return;
		}
		addEmployeeLeaveList( employeeLeaveList );

	}
	public  EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeaveIndex){

		int index = getEmployeeLeaveList().indexOf(employeeLeaveIndex);
        if(index < 0){
        	String message = "EmployeeLeave("+employeeLeaveIndex.getId()+") with version='"+employeeLeaveIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeLeave employeeLeave = getEmployeeLeaveList().get(index);
        // employeeLeave.clearWho(); //disconnect with Who
        employeeLeave.clearFromAll(); //disconnect with Who

		boolean result = getEmployeeLeaveList().planToRemove(employeeLeave);
        if(!result){
        	String message = "EmployeeLeave("+employeeLeaveIndex.getId()+") with version='"+employeeLeaveIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeLeave;


	}
	//断舍离
	public  void breakWithEmployeeLeave(EmployeeLeave employeeLeave){

		if(employeeLeave == null){
			return;
		}
		employeeLeave.setWho(null);
		//getEmployeeLeaveList().remove();

	}

	public  boolean hasEmployeeLeave(EmployeeLeave employeeLeave){

		return getEmployeeLeaveList().contains(employeeLeave);

	}

	public void copyEmployeeLeaveFrom(EmployeeLeave employeeLeave) {

		EmployeeLeave employeeLeaveInList = findTheEmployeeLeave(employeeLeave);
		EmployeeLeave newEmployeeLeave = new EmployeeLeave();
		employeeLeaveInList.copyTo(newEmployeeLeave);
		newEmployeeLeave.setVersion(0);//will trigger copy
		getEmployeeLeaveList().add(newEmployeeLeave);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeLeave);
	}

	public  EmployeeLeave findTheEmployeeLeave(EmployeeLeave employeeLeave){

		int index =  getEmployeeLeaveList().indexOf(employeeLeave);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeLeave("+employeeLeave.getId()+") with version='"+employeeLeave.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeLeaveList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeLeaveList(){
		getEmployeeLeaveList().clear();
	}





	public  SmartList<EmployeeInterview> getEmployeeInterviewList(){
		if(this.mEmployeeInterviewList == null){
			this.mEmployeeInterviewList = new SmartList<EmployeeInterview>();
			this.mEmployeeInterviewList.setListInternalName (EMPLOYEE_INTERVIEW_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeInterviewList;
	}

  public  SmartList<EmployeeInterview> employeeInterviewList(){
    
    doLoadChild(EMPLOYEE_INTERVIEW_LIST);
    
    return getEmployeeInterviewList();
  }


	public  void setEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setEmployee(this);
		}

		this.mEmployeeInterviewList = employeeInterviewList;
		this.mEmployeeInterviewList.setListInternalName (EMPLOYEE_INTERVIEW_LIST );

	}

	public  Employee addEmployeeInterview(EmployeeInterview employeeInterview){
		employeeInterview.setEmployee(this);
		getEmployeeInterviewList().add(employeeInterview);
		return this;
	}
	public  Employee addEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setEmployee(this);
		}
		getEmployeeInterviewList().addAll(employeeInterviewList);
		return this;
	}
	public  void mergeEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		if(employeeInterviewList==null){
			return;
		}
		if(employeeInterviewList.isEmpty()){
			return;
		}
		addEmployeeInterviewList( employeeInterviewList );

	}
	public  EmployeeInterview removeEmployeeInterview(EmployeeInterview employeeInterviewIndex){

		int index = getEmployeeInterviewList().indexOf(employeeInterviewIndex);
        if(index < 0){
        	String message = "EmployeeInterview("+employeeInterviewIndex.getId()+") with version='"+employeeInterviewIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeInterview employeeInterview = getEmployeeInterviewList().get(index);
        // employeeInterview.clearEmployee(); //disconnect with Employee
        employeeInterview.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeInterviewList().planToRemove(employeeInterview);
        if(!result){
        	String message = "EmployeeInterview("+employeeInterviewIndex.getId()+") with version='"+employeeInterviewIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeInterview;


	}
	//断舍离
	public  void breakWithEmployeeInterview(EmployeeInterview employeeInterview){

		if(employeeInterview == null){
			return;
		}
		employeeInterview.setEmployee(null);
		//getEmployeeInterviewList().remove();

	}

	public  boolean hasEmployeeInterview(EmployeeInterview employeeInterview){

		return getEmployeeInterviewList().contains(employeeInterview);

	}

	public void copyEmployeeInterviewFrom(EmployeeInterview employeeInterview) {

		EmployeeInterview employeeInterviewInList = findTheEmployeeInterview(employeeInterview);
		EmployeeInterview newEmployeeInterview = new EmployeeInterview();
		employeeInterviewInList.copyTo(newEmployeeInterview);
		newEmployeeInterview.setVersion(0);//will trigger copy
		getEmployeeInterviewList().add(newEmployeeInterview);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeInterview);
	}

	public  EmployeeInterview findTheEmployeeInterview(EmployeeInterview employeeInterview){

		int index =  getEmployeeInterviewList().indexOf(employeeInterview);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeInterview("+employeeInterview.getId()+") with version='"+employeeInterview.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeInterviewList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeInterviewList(){
		getEmployeeInterviewList().clear();
	}





	public  SmartList<EmployeeAttendance> getEmployeeAttendanceList(){
		if(this.mEmployeeAttendanceList == null){
			this.mEmployeeAttendanceList = new SmartList<EmployeeAttendance>();
			this.mEmployeeAttendanceList.setListInternalName (EMPLOYEE_ATTENDANCE_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeAttendanceList;
	}

  public  SmartList<EmployeeAttendance> employeeAttendanceList(){
    
    doLoadChild(EMPLOYEE_ATTENDANCE_LIST);
    
    return getEmployeeAttendanceList();
  }


	public  void setEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList){
		for( EmployeeAttendance employeeAttendance:employeeAttendanceList){
			employeeAttendance.setEmployee(this);
		}

		this.mEmployeeAttendanceList = employeeAttendanceList;
		this.mEmployeeAttendanceList.setListInternalName (EMPLOYEE_ATTENDANCE_LIST );

	}

	public  Employee addEmployeeAttendance(EmployeeAttendance employeeAttendance){
		employeeAttendance.setEmployee(this);
		getEmployeeAttendanceList().add(employeeAttendance);
		return this;
	}
	public  Employee addEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList){
		for( EmployeeAttendance employeeAttendance:employeeAttendanceList){
			employeeAttendance.setEmployee(this);
		}
		getEmployeeAttendanceList().addAll(employeeAttendanceList);
		return this;
	}
	public  void mergeEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList){
		if(employeeAttendanceList==null){
			return;
		}
		if(employeeAttendanceList.isEmpty()){
			return;
		}
		addEmployeeAttendanceList( employeeAttendanceList );

	}
	public  EmployeeAttendance removeEmployeeAttendance(EmployeeAttendance employeeAttendanceIndex){

		int index = getEmployeeAttendanceList().indexOf(employeeAttendanceIndex);
        if(index < 0){
        	String message = "EmployeeAttendance("+employeeAttendanceIndex.getId()+") with version='"+employeeAttendanceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeAttendance employeeAttendance = getEmployeeAttendanceList().get(index);
        // employeeAttendance.clearEmployee(); //disconnect with Employee
        employeeAttendance.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeAttendanceList().planToRemove(employeeAttendance);
        if(!result){
        	String message = "EmployeeAttendance("+employeeAttendanceIndex.getId()+") with version='"+employeeAttendanceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeAttendance;


	}
	//断舍离
	public  void breakWithEmployeeAttendance(EmployeeAttendance employeeAttendance){

		if(employeeAttendance == null){
			return;
		}
		employeeAttendance.setEmployee(null);
		//getEmployeeAttendanceList().remove();

	}

	public  boolean hasEmployeeAttendance(EmployeeAttendance employeeAttendance){

		return getEmployeeAttendanceList().contains(employeeAttendance);

	}

	public void copyEmployeeAttendanceFrom(EmployeeAttendance employeeAttendance) {

		EmployeeAttendance employeeAttendanceInList = findTheEmployeeAttendance(employeeAttendance);
		EmployeeAttendance newEmployeeAttendance = new EmployeeAttendance();
		employeeAttendanceInList.copyTo(newEmployeeAttendance);
		newEmployeeAttendance.setVersion(0);//will trigger copy
		getEmployeeAttendanceList().add(newEmployeeAttendance);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeAttendance);
	}

	public  EmployeeAttendance findTheEmployeeAttendance(EmployeeAttendance employeeAttendance){

		int index =  getEmployeeAttendanceList().indexOf(employeeAttendance);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeAttendance("+employeeAttendance.getId()+") with version='"+employeeAttendance.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeAttendanceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeAttendanceList(){
		getEmployeeAttendanceList().clear();
	}





	public  SmartList<EmployeeQualifier> getEmployeeQualifierList(){
		if(this.mEmployeeQualifierList == null){
			this.mEmployeeQualifierList = new SmartList<EmployeeQualifier>();
			this.mEmployeeQualifierList.setListInternalName (EMPLOYEE_QUALIFIER_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeQualifierList;
	}

  public  SmartList<EmployeeQualifier> employeeQualifierList(){
    
    doLoadChild(EMPLOYEE_QUALIFIER_LIST);
    
    return getEmployeeQualifierList();
  }


	public  void setEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList){
		for( EmployeeQualifier employeeQualifier:employeeQualifierList){
			employeeQualifier.setEmployee(this);
		}

		this.mEmployeeQualifierList = employeeQualifierList;
		this.mEmployeeQualifierList.setListInternalName (EMPLOYEE_QUALIFIER_LIST );

	}

	public  Employee addEmployeeQualifier(EmployeeQualifier employeeQualifier){
		employeeQualifier.setEmployee(this);
		getEmployeeQualifierList().add(employeeQualifier);
		return this;
	}
	public  Employee addEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList){
		for( EmployeeQualifier employeeQualifier:employeeQualifierList){
			employeeQualifier.setEmployee(this);
		}
		getEmployeeQualifierList().addAll(employeeQualifierList);
		return this;
	}
	public  void mergeEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList){
		if(employeeQualifierList==null){
			return;
		}
		if(employeeQualifierList.isEmpty()){
			return;
		}
		addEmployeeQualifierList( employeeQualifierList );

	}
	public  EmployeeQualifier removeEmployeeQualifier(EmployeeQualifier employeeQualifierIndex){

		int index = getEmployeeQualifierList().indexOf(employeeQualifierIndex);
        if(index < 0){
        	String message = "EmployeeQualifier("+employeeQualifierIndex.getId()+") with version='"+employeeQualifierIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeQualifier employeeQualifier = getEmployeeQualifierList().get(index);
        // employeeQualifier.clearEmployee(); //disconnect with Employee
        employeeQualifier.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeQualifierList().planToRemove(employeeQualifier);
        if(!result){
        	String message = "EmployeeQualifier("+employeeQualifierIndex.getId()+") with version='"+employeeQualifierIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeQualifier;


	}
	//断舍离
	public  void breakWithEmployeeQualifier(EmployeeQualifier employeeQualifier){

		if(employeeQualifier == null){
			return;
		}
		employeeQualifier.setEmployee(null);
		//getEmployeeQualifierList().remove();

	}

	public  boolean hasEmployeeQualifier(EmployeeQualifier employeeQualifier){

		return getEmployeeQualifierList().contains(employeeQualifier);

	}

	public void copyEmployeeQualifierFrom(EmployeeQualifier employeeQualifier) {

		EmployeeQualifier employeeQualifierInList = findTheEmployeeQualifier(employeeQualifier);
		EmployeeQualifier newEmployeeQualifier = new EmployeeQualifier();
		employeeQualifierInList.copyTo(newEmployeeQualifier);
		newEmployeeQualifier.setVersion(0);//will trigger copy
		getEmployeeQualifierList().add(newEmployeeQualifier);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeQualifier);
	}

	public  EmployeeQualifier findTheEmployeeQualifier(EmployeeQualifier employeeQualifier){

		int index =  getEmployeeQualifierList().indexOf(employeeQualifier);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeQualifier("+employeeQualifier.getId()+") with version='"+employeeQualifier.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeQualifierList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeQualifierList(){
		getEmployeeQualifierList().clear();
	}





	public  SmartList<EmployeeEducation> getEmployeeEducationList(){
		if(this.mEmployeeEducationList == null){
			this.mEmployeeEducationList = new SmartList<EmployeeEducation>();
			this.mEmployeeEducationList.setListInternalName (EMPLOYEE_EDUCATION_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeEducationList;
	}

  public  SmartList<EmployeeEducation> employeeEducationList(){
    
    doLoadChild(EMPLOYEE_EDUCATION_LIST);
    
    return getEmployeeEducationList();
  }


	public  void setEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList){
		for( EmployeeEducation employeeEducation:employeeEducationList){
			employeeEducation.setEmployee(this);
		}

		this.mEmployeeEducationList = employeeEducationList;
		this.mEmployeeEducationList.setListInternalName (EMPLOYEE_EDUCATION_LIST );

	}

	public  Employee addEmployeeEducation(EmployeeEducation employeeEducation){
		employeeEducation.setEmployee(this);
		getEmployeeEducationList().add(employeeEducation);
		return this;
	}
	public  Employee addEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList){
		for( EmployeeEducation employeeEducation:employeeEducationList){
			employeeEducation.setEmployee(this);
		}
		getEmployeeEducationList().addAll(employeeEducationList);
		return this;
	}
	public  void mergeEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList){
		if(employeeEducationList==null){
			return;
		}
		if(employeeEducationList.isEmpty()){
			return;
		}
		addEmployeeEducationList( employeeEducationList );

	}
	public  EmployeeEducation removeEmployeeEducation(EmployeeEducation employeeEducationIndex){

		int index = getEmployeeEducationList().indexOf(employeeEducationIndex);
        if(index < 0){
        	String message = "EmployeeEducation("+employeeEducationIndex.getId()+") with version='"+employeeEducationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeEducation employeeEducation = getEmployeeEducationList().get(index);
        // employeeEducation.clearEmployee(); //disconnect with Employee
        employeeEducation.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeEducationList().planToRemove(employeeEducation);
        if(!result){
        	String message = "EmployeeEducation("+employeeEducationIndex.getId()+") with version='"+employeeEducationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeEducation;


	}
	//断舍离
	public  void breakWithEmployeeEducation(EmployeeEducation employeeEducation){

		if(employeeEducation == null){
			return;
		}
		employeeEducation.setEmployee(null);
		//getEmployeeEducationList().remove();

	}

	public  boolean hasEmployeeEducation(EmployeeEducation employeeEducation){

		return getEmployeeEducationList().contains(employeeEducation);

	}

	public void copyEmployeeEducationFrom(EmployeeEducation employeeEducation) {

		EmployeeEducation employeeEducationInList = findTheEmployeeEducation(employeeEducation);
		EmployeeEducation newEmployeeEducation = new EmployeeEducation();
		employeeEducationInList.copyTo(newEmployeeEducation);
		newEmployeeEducation.setVersion(0);//will trigger copy
		getEmployeeEducationList().add(newEmployeeEducation);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeEducation);
	}

	public  EmployeeEducation findTheEmployeeEducation(EmployeeEducation employeeEducation){

		int index =  getEmployeeEducationList().indexOf(employeeEducation);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeEducation("+employeeEducation.getId()+") with version='"+employeeEducation.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeEducationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeEducationList(){
		getEmployeeEducationList().clear();
	}





	public  SmartList<EmployeeAward> getEmployeeAwardList(){
		if(this.mEmployeeAwardList == null){
			this.mEmployeeAwardList = new SmartList<EmployeeAward>();
			this.mEmployeeAwardList.setListInternalName (EMPLOYEE_AWARD_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeAwardList;
	}

  public  SmartList<EmployeeAward> employeeAwardList(){
    
    doLoadChild(EMPLOYEE_AWARD_LIST);
    
    return getEmployeeAwardList();
  }


	public  void setEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList){
		for( EmployeeAward employeeAward:employeeAwardList){
			employeeAward.setEmployee(this);
		}

		this.mEmployeeAwardList = employeeAwardList;
		this.mEmployeeAwardList.setListInternalName (EMPLOYEE_AWARD_LIST );

	}

	public  Employee addEmployeeAward(EmployeeAward employeeAward){
		employeeAward.setEmployee(this);
		getEmployeeAwardList().add(employeeAward);
		return this;
	}
	public  Employee addEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList){
		for( EmployeeAward employeeAward:employeeAwardList){
			employeeAward.setEmployee(this);
		}
		getEmployeeAwardList().addAll(employeeAwardList);
		return this;
	}
	public  void mergeEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList){
		if(employeeAwardList==null){
			return;
		}
		if(employeeAwardList.isEmpty()){
			return;
		}
		addEmployeeAwardList( employeeAwardList );

	}
	public  EmployeeAward removeEmployeeAward(EmployeeAward employeeAwardIndex){

		int index = getEmployeeAwardList().indexOf(employeeAwardIndex);
        if(index < 0){
        	String message = "EmployeeAward("+employeeAwardIndex.getId()+") with version='"+employeeAwardIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeAward employeeAward = getEmployeeAwardList().get(index);
        // employeeAward.clearEmployee(); //disconnect with Employee
        employeeAward.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeAwardList().planToRemove(employeeAward);
        if(!result){
        	String message = "EmployeeAward("+employeeAwardIndex.getId()+") with version='"+employeeAwardIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeAward;


	}
	//断舍离
	public  void breakWithEmployeeAward(EmployeeAward employeeAward){

		if(employeeAward == null){
			return;
		}
		employeeAward.setEmployee(null);
		//getEmployeeAwardList().remove();

	}

	public  boolean hasEmployeeAward(EmployeeAward employeeAward){

		return getEmployeeAwardList().contains(employeeAward);

	}

	public void copyEmployeeAwardFrom(EmployeeAward employeeAward) {

		EmployeeAward employeeAwardInList = findTheEmployeeAward(employeeAward);
		EmployeeAward newEmployeeAward = new EmployeeAward();
		employeeAwardInList.copyTo(newEmployeeAward);
		newEmployeeAward.setVersion(0);//will trigger copy
		getEmployeeAwardList().add(newEmployeeAward);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeAward);
	}

	public  EmployeeAward findTheEmployeeAward(EmployeeAward employeeAward){

		int index =  getEmployeeAwardList().indexOf(employeeAward);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeAward("+employeeAward.getId()+") with version='"+employeeAward.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeAwardList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeAwardList(){
		getEmployeeAwardList().clear();
	}





	public  SmartList<EmployeeSalarySheet> getEmployeeSalarySheetList(){
		if(this.mEmployeeSalarySheetList == null){
			this.mEmployeeSalarySheetList = new SmartList<EmployeeSalarySheet>();
			this.mEmployeeSalarySheetList.setListInternalName (EMPLOYEE_SALARY_SHEET_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeSalarySheetList;
	}

  public  SmartList<EmployeeSalarySheet> employeeSalarySheetList(){
    
    doLoadChild(EMPLOYEE_SALARY_SHEET_LIST);
    
    return getEmployeeSalarySheetList();
  }


	public  void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setEmployee(this);
		}

		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		this.mEmployeeSalarySheetList.setListInternalName (EMPLOYEE_SALARY_SHEET_LIST );

	}

	public  Employee addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setEmployee(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
		return this;
	}
	public  Employee addEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setEmployee(this);
		}
		getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
		return this;
	}
	public  void mergeEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		if(employeeSalarySheetList==null){
			return;
		}
		if(employeeSalarySheetList.isEmpty()){
			return;
		}
		addEmployeeSalarySheetList( employeeSalarySheetList );

	}
	public  EmployeeSalarySheet removeEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheetIndex){

		int index = getEmployeeSalarySheetList().indexOf(employeeSalarySheetIndex);
        if(index < 0){
        	String message = "EmployeeSalarySheet("+employeeSalarySheetIndex.getId()+") with version='"+employeeSalarySheetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeSalarySheet employeeSalarySheet = getEmployeeSalarySheetList().get(index);
        // employeeSalarySheet.clearEmployee(); //disconnect with Employee
        employeeSalarySheet.clearFromAll(); //disconnect with Employee

		boolean result = getEmployeeSalarySheetList().planToRemove(employeeSalarySheet);
        if(!result){
        	String message = "EmployeeSalarySheet("+employeeSalarySheetIndex.getId()+") with version='"+employeeSalarySheetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeSalarySheet;


	}
	//断舍离
	public  void breakWithEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){

		if(employeeSalarySheet == null){
			return;
		}
		employeeSalarySheet.setEmployee(null);
		//getEmployeeSalarySheetList().remove();

	}

	public  boolean hasEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){

		return getEmployeeSalarySheetList().contains(employeeSalarySheet);

	}

	public void copyEmployeeSalarySheetFrom(EmployeeSalarySheet employeeSalarySheet) {

		EmployeeSalarySheet employeeSalarySheetInList = findTheEmployeeSalarySheet(employeeSalarySheet);
		EmployeeSalarySheet newEmployeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheetInList.copyTo(newEmployeeSalarySheet);
		newEmployeeSalarySheet.setVersion(0);//will trigger copy
		getEmployeeSalarySheetList().add(newEmployeeSalarySheet);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeSalarySheet);
	}

	public  EmployeeSalarySheet findTheEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){

		int index =  getEmployeeSalarySheetList().indexOf(employeeSalarySheet);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeSalarySheet("+employeeSalarySheet.getId()+") with version='"+employeeSalarySheet.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeSalarySheetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeSalarySheetList(){
		getEmployeeSalarySheetList().clear();
	}





	public  SmartList<PayingOff> getPayingOffList(){
		if(this.mPayingOffList == null){
			this.mPayingOffList = new SmartList<PayingOff>();
			this.mPayingOffList.setListInternalName (PAYING_OFF_LIST );
			//有名字，便于做权限控制
		}

		return this.mPayingOffList;
	}

  public  SmartList<PayingOff> payingOffList(){
    
    doLoadChild(PAYING_OFF_LIST);
    
    return getPayingOffList();
  }


	public  void setPayingOffList(SmartList<PayingOff> payingOffList){
		for( PayingOff payingOff:payingOffList){
			payingOff.setPaidFor(this);
		}

		this.mPayingOffList = payingOffList;
		this.mPayingOffList.setListInternalName (PAYING_OFF_LIST );

	}

	public  Employee addPayingOff(PayingOff payingOff){
		payingOff.setPaidFor(this);
		getPayingOffList().add(payingOff);
		return this;
	}
	public  Employee addPayingOffList(SmartList<PayingOff> payingOffList){
		for( PayingOff payingOff:payingOffList){
			payingOff.setPaidFor(this);
		}
		getPayingOffList().addAll(payingOffList);
		return this;
	}
	public  void mergePayingOffList(SmartList<PayingOff> payingOffList){
		if(payingOffList==null){
			return;
		}
		if(payingOffList.isEmpty()){
			return;
		}
		addPayingOffList( payingOffList );

	}
	public  PayingOff removePayingOff(PayingOff payingOffIndex){

		int index = getPayingOffList().indexOf(payingOffIndex);
        if(index < 0){
        	String message = "PayingOff("+payingOffIndex.getId()+") with version='"+payingOffIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PayingOff payingOff = getPayingOffList().get(index);
        // payingOff.clearPaidFor(); //disconnect with PaidFor
        payingOff.clearFromAll(); //disconnect with PaidFor

		boolean result = getPayingOffList().planToRemove(payingOff);
        if(!result){
        	String message = "PayingOff("+payingOffIndex.getId()+") with version='"+payingOffIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return payingOff;


	}
	//断舍离
	public  void breakWithPayingOff(PayingOff payingOff){

		if(payingOff == null){
			return;
		}
		payingOff.setPaidFor(null);
		//getPayingOffList().remove();

	}

	public  boolean hasPayingOff(PayingOff payingOff){

		return getPayingOffList().contains(payingOff);

	}

	public void copyPayingOffFrom(PayingOff payingOff) {

		PayingOff payingOffInList = findThePayingOff(payingOff);
		PayingOff newPayingOff = new PayingOff();
		payingOffInList.copyTo(newPayingOff);
		newPayingOff.setVersion(0);//will trigger copy
		getPayingOffList().add(newPayingOff);
		addItemToFlexiableObject(COPIED_CHILD, newPayingOff);
	}

	public  PayingOff findThePayingOff(PayingOff payingOff){

		int index =  getPayingOffList().indexOf(payingOff);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PayingOff("+payingOff.getId()+") with version='"+payingOff.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getPayingOffList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpPayingOffList(){
		getPayingOffList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);
		addToEntityList(this, entityList, getDepartment(), internalType);
		addToEntityList(this, entityList, getOccupation(), internalType);
		addToEntityList(this, entityList, getResponsibleFor(), internalType);
		addToEntityList(this, entityList, getCurrentSalaryGrade(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeCompanyTrainingList(), internalType);
		collectFromList(this, entityList, getEmployeeSkillList(), internalType);
		collectFromList(this, entityList, getEmployeePerformanceList(), internalType);
		collectFromList(this, entityList, getEmployeeWorkExperienceList(), internalType);
		collectFromList(this, entityList, getEmployeeLeaveList(), internalType);
		collectFromList(this, entityList, getEmployeeInterviewList(), internalType);
		collectFromList(this, entityList, getEmployeeAttendanceList(), internalType);
		collectFromList(this, entityList, getEmployeeQualifierList(), internalType);
		collectFromList(this, entityList, getEmployeeEducationList(), internalType);
		collectFromList(this, entityList, getEmployeeAwardList(), internalType);
		collectFromList(this, entityList, getEmployeeSalarySheetList(), internalType);
		collectFromList(this, entityList, getPayingOffList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getEmployeeCompanyTrainingList());
		listOfList.add( getEmployeeSkillList());
		listOfList.add( getEmployeePerformanceList());
		listOfList.add( getEmployeeWorkExperienceList());
		listOfList.add( getEmployeeLeaveList());
		listOfList.add( getEmployeeInterviewList());
		listOfList.add( getEmployeeAttendanceList());
		listOfList.add( getEmployeeQualifierList());
		listOfList.add( getEmployeeEducationList());
		listOfList.add( getEmployeeAwardList());
		listOfList.add( getEmployeeSalarySheetList());
		listOfList.add( getPayingOffList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, DEPARTMENT_PROPERTY, getDepartment());
		appendKeyValuePair(result, FAMILY_NAME_PROPERTY, getFamilyName());
		appendKeyValuePair(result, GIVEN_NAME_PROPERTY, getGivenName());
		appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
		appendKeyValuePair(result, CITY_PROPERTY, getCity());
		appendKeyValuePair(result, ADDRESS_PROPERTY, getAddress());
		appendKeyValuePair(result, CELL_PHONE_PROPERTY, getMaskedCellPhone());
		appendKeyValuePair(result, OCCUPATION_PROPERTY, getOccupation());
		appendKeyValuePair(result, RESPONSIBLE_FOR_PROPERTY, getResponsibleFor());
		appendKeyValuePair(result, CURRENT_SALARY_GRADE_PROPERTY, getCurrentSalaryGrade());
		appendKeyValuePair(result, SALARY_ACCOUNT_PROPERTY, getSalaryAccount());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingList());
		if(!getEmployeeCompanyTrainingList().isEmpty()){
			appendKeyValuePair(result, "employeeCompanyTrainingCount", getEmployeeCompanyTrainingList().getTotalCount());
			appendKeyValuePair(result, "employeeCompanyTrainingCurrentPageNumber", getEmployeeCompanyTrainingList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_SKILL_LIST, getEmployeeSkillList());
		if(!getEmployeeSkillList().isEmpty()){
			appendKeyValuePair(result, "employeeSkillCount", getEmployeeSkillList().getTotalCount());
			appendKeyValuePair(result, "employeeSkillCurrentPageNumber", getEmployeeSkillList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_PERFORMANCE_LIST, getEmployeePerformanceList());
		if(!getEmployeePerformanceList().isEmpty()){
			appendKeyValuePair(result, "employeePerformanceCount", getEmployeePerformanceList().getTotalCount());
			appendKeyValuePair(result, "employeePerformanceCurrentPageNumber", getEmployeePerformanceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_WORK_EXPERIENCE_LIST, getEmployeeWorkExperienceList());
		if(!getEmployeeWorkExperienceList().isEmpty()){
			appendKeyValuePair(result, "employeeWorkExperienceCount", getEmployeeWorkExperienceList().getTotalCount());
			appendKeyValuePair(result, "employeeWorkExperienceCurrentPageNumber", getEmployeeWorkExperienceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_LEAVE_LIST, getEmployeeLeaveList());
		if(!getEmployeeLeaveList().isEmpty()){
			appendKeyValuePair(result, "employeeLeaveCount", getEmployeeLeaveList().getTotalCount());
			appendKeyValuePair(result, "employeeLeaveCurrentPageNumber", getEmployeeLeaveList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_INTERVIEW_LIST, getEmployeeInterviewList());
		if(!getEmployeeInterviewList().isEmpty()){
			appendKeyValuePair(result, "employeeInterviewCount", getEmployeeInterviewList().getTotalCount());
			appendKeyValuePair(result, "employeeInterviewCurrentPageNumber", getEmployeeInterviewList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_ATTENDANCE_LIST, getEmployeeAttendanceList());
		if(!getEmployeeAttendanceList().isEmpty()){
			appendKeyValuePair(result, "employeeAttendanceCount", getEmployeeAttendanceList().getTotalCount());
			appendKeyValuePair(result, "employeeAttendanceCurrentPageNumber", getEmployeeAttendanceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_QUALIFIER_LIST, getEmployeeQualifierList());
		if(!getEmployeeQualifierList().isEmpty()){
			appendKeyValuePair(result, "employeeQualifierCount", getEmployeeQualifierList().getTotalCount());
			appendKeyValuePair(result, "employeeQualifierCurrentPageNumber", getEmployeeQualifierList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_EDUCATION_LIST, getEmployeeEducationList());
		if(!getEmployeeEducationList().isEmpty()){
			appendKeyValuePair(result, "employeeEducationCount", getEmployeeEducationList().getTotalCount());
			appendKeyValuePair(result, "employeeEducationCurrentPageNumber", getEmployeeEducationList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_AWARD_LIST, getEmployeeAwardList());
		if(!getEmployeeAwardList().isEmpty()){
			appendKeyValuePair(result, "employeeAwardCount", getEmployeeAwardList().getTotalCount());
			appendKeyValuePair(result, "employeeAwardCurrentPageNumber", getEmployeeAwardList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, EMPLOYEE_SALARY_SHEET_LIST, getEmployeeSalarySheetList());
		if(!getEmployeeSalarySheetList().isEmpty()){
			appendKeyValuePair(result, "employeeSalarySheetCount", getEmployeeSalarySheetList().getTotalCount());
			appendKeyValuePair(result, "employeeSalarySheetCurrentPageNumber", getEmployeeSalarySheetList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PAYING_OFF_LIST, getPayingOffList());
		if(!getPayingOffList().isEmpty()){
			appendKeyValuePair(result, "payingOffCount", getPayingOffList().getTotalCount());
			appendKeyValuePair(result, "payingOffCurrentPageNumber", getPayingOffList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof Employee){


			Employee dest =(Employee)baseDest;

			dest.setId(getId());
			dest.setCompany(getCompany());
			dest.setTitle(getTitle());
			dest.setDepartment(getDepartment());
			dest.setFamilyName(getFamilyName());
			dest.setGivenName(getGivenName());
			dest.setEmail(getEmail());
			dest.setCity(getCity());
			dest.setAddress(getAddress());
			dest.setCellPhone(getCellPhone());
			dest.setOccupation(getOccupation());
			dest.setResponsibleFor(getResponsibleFor());
			dest.setCurrentSalaryGrade(getCurrentSalaryGrade());
			dest.setSalaryAccount(getSalaryAccount());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());
			dest.setEmployeeSkillList(getEmployeeSkillList());
			dest.setEmployeePerformanceList(getEmployeePerformanceList());
			dest.setEmployeeWorkExperienceList(getEmployeeWorkExperienceList());
			dest.setEmployeeLeaveList(getEmployeeLeaveList());
			dest.setEmployeeInterviewList(getEmployeeInterviewList());
			dest.setEmployeeAttendanceList(getEmployeeAttendanceList());
			dest.setEmployeeQualifierList(getEmployeeQualifierList());
			dest.setEmployeeEducationList(getEmployeeEducationList());
			dest.setEmployeeAwardList(getEmployeeAwardList());
			dest.setEmployeeSalarySheetList(getEmployeeSalarySheetList());
			dest.setPayingOffList(getPayingOffList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof Employee){


			Employee dest =(Employee)baseDest;

			dest.mergeId(getId());
			dest.mergeCompany(getCompany());
			dest.mergeTitle(getTitle());
			dest.mergeDepartment(getDepartment());
			dest.mergeFamilyName(getFamilyName());
			dest.mergeGivenName(getGivenName());
			dest.mergeEmail(getEmail());
			dest.mergeCity(getCity());
			dest.mergeAddress(getAddress());
			dest.mergeCellPhone(getCellPhone());
			dest.mergeOccupation(getOccupation());
			dest.mergeResponsibleFor(getResponsibleFor());
			dest.mergeCurrentSalaryGrade(getCurrentSalaryGrade());
			dest.mergeSalaryAccount(getSalaryAccount());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());
			dest.mergeEmployeeSkillList(getEmployeeSkillList());
			dest.mergeEmployeePerformanceList(getEmployeePerformanceList());
			dest.mergeEmployeeWorkExperienceList(getEmployeeWorkExperienceList());
			dest.mergeEmployeeLeaveList(getEmployeeLeaveList());
			dest.mergeEmployeeInterviewList(getEmployeeInterviewList());
			dest.mergeEmployeeAttendanceList(getEmployeeAttendanceList());
			dest.mergeEmployeeQualifierList(getEmployeeQualifierList());
			dest.mergeEmployeeEducationList(getEmployeeEducationList());
			dest.mergeEmployeeAwardList(getEmployeeAwardList());
			dest.mergeEmployeeSalarySheetList(getEmployeeSalarySheetList());
			dest.mergePayingOffList(getPayingOffList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof Employee){


			Employee dest =(Employee)baseDest;

			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeFamilyName(getFamilyName());
			dest.mergeGivenName(getGivenName());
			dest.mergeEmail(getEmail());
			dest.mergeCity(getCity());
			dest.mergeAddress(getAddress());
			dest.mergeCellPhone(getCellPhone());
			dest.mergeSalaryAccount(getSalaryAccount());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCompany(), getTitle(), getDepartment(), getFamilyName(), getGivenName(), getEmail(), getCity(), getAddress(), getCellPhone(), getOccupation(), getResponsibleFor(), getCurrentSalaryGrade(), getSalaryAccount(), getLastUpdateTime(), getVersion()};
	}


	public static Employee createWith(RetailscmUserContext userContext, ThrowingFunction<Employee,Employee,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<Employee> customCreator = mapper.findCustomCreator(Employee.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    Employee result = new Employee();
    result.setCompany(mapper.tryToGet(Employee.class, COMPANY_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getCompany(), params));
    result.setTitle(mapper.tryToGet(Employee.class, TITLE_PROPERTY, String.class,
        0, false, result.getTitle(), params));
    result.setDepartment(mapper.tryToGet(Employee.class, DEPARTMENT_PROPERTY, LevelThreeDepartment.class,
        0, true, result.getDepartment(), params));
    result.setFamilyName(mapper.tryToGet(Employee.class, FAMILY_NAME_PROPERTY, String.class,
        1, false, result.getFamilyName(), params));
    result.setGivenName(mapper.tryToGet(Employee.class, GIVEN_NAME_PROPERTY, String.class,
        2, false, result.getGivenName(), params));
    result.setEmail(mapper.tryToGet(Employee.class, EMAIL_PROPERTY, String.class,
        3, false, result.getEmail(), params));
    result.setCity(mapper.tryToGet(Employee.class, CITY_PROPERTY, String.class,
        4, false, result.getCity(), params));
    result.setAddress(mapper.tryToGet(Employee.class, ADDRESS_PROPERTY, String.class,
        5, false, result.getAddress(), params));
    result.setCellPhone(mapper.tryToGet(Employee.class, CELL_PHONE_PROPERTY, String.class,
        6, false, result.getCellPhone(), params));
    result.setOccupation(mapper.tryToGet(Employee.class, OCCUPATION_PROPERTY, OccupationType.class,
        0, true, result.getOccupation(), params));
    result.setResponsibleFor(mapper.tryToGet(Employee.class, RESPONSIBLE_FOR_PROPERTY, ResponsibilityType.class,
        0, true, result.getResponsibleFor(), params));
    result.setCurrentSalaryGrade(mapper.tryToGet(Employee.class, CURRENT_SALARY_GRADE_PROPERTY, SalaryGrade.class,
        0, true, result.getCurrentSalaryGrade(), params));
    result.setSalaryAccount(mapper.tryToGet(Employee.class, SALARY_ACCOUNT_PROPERTY, String.class,
        7, false, result.getSalaryAccount(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixEmployee(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      EmployeeTokens tokens = mapper.findParamByClass(params, EmployeeTokens.class);
      if (tokens == null) {
        tokens = EmployeeTokens.start();
      }
      result = userContext.getManagerGroup().getEmployeeManager().internalSaveEmployee(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Employee{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='LevelThreeDepartment("+getDepartment().getId()+")';");
 		}
		stringBuilder.append("\tfamilyName='"+getFamilyName()+"';");
		stringBuilder.append("\tgivenName='"+getGivenName()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tcity='"+getCity()+"';");
		stringBuilder.append("\taddress='"+getAddress()+"';");
		stringBuilder.append("\tcellPhone='"+getCellPhone()+"';");
		if(getOccupation() != null ){
 			stringBuilder.append("\toccupation='OccupationType("+getOccupation().getId()+")';");
 		}
		if(getResponsibleFor() != null ){
 			stringBuilder.append("\tresponsibleFor='ResponsibilityType("+getResponsibleFor().getId()+")';");
 		}
		if(getCurrentSalaryGrade() != null ){
 			stringBuilder.append("\tcurrentSalaryGrade='SalaryGrade("+getCurrentSalaryGrade().getId()+")';");
 		}
		stringBuilder.append("\tsalaryAccount='"+getSalaryAccount()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

