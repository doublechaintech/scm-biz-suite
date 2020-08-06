
package com.doublechaintech.retailscm.employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mTitle              ;
	protected		LevelThreeDepartment	mDepartment         ;
	protected		String              	mFamilyName         ;
	protected		String              	mGivenName          ;
	protected		String              	mEmail              ;
	protected		String              	mCity               ;
	protected		String              	mAddress            ;
	protected		String              	mCellPhone          ;
	protected		OccupationType      	mOccupation         ;
	protected		ResponsibilityType  	mResponsibleFor     ;
	protected		SalaryGrade         	mCurrentSalaryGrade ;
	protected		String              	mSalaryAccount      ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
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
		return employee;
	}
	public 	static Employee refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );
		setDepartment( null );
		setOccupation( null );
		setResponsibleFor( null );
		setCurrentSalaryGrade( null );

		this.changed = true;
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
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Employee updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	public Employee updateCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
		this.changed = true;
		return this;
	}
	public void mergeCompany(RetailStoreCountryCenter company){
		if(company != null) { setCompany(company);}
	}
	
	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
	}
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public Employee updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setDepartment(LevelThreeDepartment department){
		this.mDepartment = department;;
	}
	public LevelThreeDepartment getDepartment(){
		return this.mDepartment;
	}
	public Employee updateDepartment(LevelThreeDepartment department){
		this.mDepartment = department;;
		this.changed = true;
		return this;
	}
	public void mergeDepartment(LevelThreeDepartment department){
		if(department != null) { setDepartment(department);}
	}
	
	
	public void clearDepartment(){
		setDepartment ( null );
		this.changed = true;
	}
	
	public void setFamilyName(String familyName){
		this.mFamilyName = trimString(familyName);;
	}
	public String getFamilyName(){
		return this.mFamilyName;
	}
	public Employee updateFamilyName(String familyName){
		this.mFamilyName = trimString(familyName);;
		this.changed = true;
		return this;
	}
	public void mergeFamilyName(String familyName){
		if(familyName != null) { setFamilyName(familyName);}
	}
	
	
	public void setGivenName(String givenName){
		this.mGivenName = trimString(givenName);;
	}
	public String getGivenName(){
		return this.mGivenName;
	}
	public Employee updateGivenName(String givenName){
		this.mGivenName = trimString(givenName);;
		this.changed = true;
		return this;
	}
	public void mergeGivenName(String givenName){
		if(givenName != null) { setGivenName(givenName);}
	}
	
	
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	public Employee updateEmail(String email){
		this.mEmail = trimString(email);;
		this.changed = true;
		return this;
	}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}
	
	
	public void setCity(String city){
		this.mCity = trimString(city);;
	}
	public String getCity(){
		return this.mCity;
	}
	public Employee updateCity(String city){
		this.mCity = trimString(city);;
		this.changed = true;
		return this;
	}
	public void mergeCity(String city){
		if(city != null) { setCity(city);}
	}
	
	
	public void setAddress(String address){
		this.mAddress = trimString(address);;
	}
	public String getAddress(){
		return this.mAddress;
	}
	public Employee updateAddress(String address){
		this.mAddress = trimString(address);;
		this.changed = true;
		return this;
	}
	public void mergeAddress(String address){
		if(address != null) { setAddress(address);}
	}
	
	
	public void setCellPhone(String cellPhone){
		this.mCellPhone = trimString(cellPhone);;
	}
	public String getCellPhone(){
		return this.mCellPhone;
	}
	public Employee updateCellPhone(String cellPhone){
		this.mCellPhone = trimString(cellPhone);;
		this.changed = true;
		return this;
	}
	public void mergeCellPhone(String cellPhone){
		if(cellPhone != null) { setCellPhone(cellPhone);}
	}
	
	
	
	public String getMaskedCellPhone(){
		String mobilePhoneNumber = getCellPhone();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setOccupation(OccupationType occupation){
		this.mOccupation = occupation;;
	}
	public OccupationType getOccupation(){
		return this.mOccupation;
	}
	public Employee updateOccupation(OccupationType occupation){
		this.mOccupation = occupation;;
		this.changed = true;
		return this;
	}
	public void mergeOccupation(OccupationType occupation){
		if(occupation != null) { setOccupation(occupation);}
	}
	
	
	public void clearOccupation(){
		setOccupation ( null );
		this.changed = true;
	}
	
	public void setResponsibleFor(ResponsibilityType responsibleFor){
		this.mResponsibleFor = responsibleFor;;
	}
	public ResponsibilityType getResponsibleFor(){
		return this.mResponsibleFor;
	}
	public Employee updateResponsibleFor(ResponsibilityType responsibleFor){
		this.mResponsibleFor = responsibleFor;;
		this.changed = true;
		return this;
	}
	public void mergeResponsibleFor(ResponsibilityType responsibleFor){
		if(responsibleFor != null) { setResponsibleFor(responsibleFor);}
	}
	
	
	public void clearResponsibleFor(){
		setResponsibleFor ( null );
		this.changed = true;
	}
	
	public void setCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
		this.mCurrentSalaryGrade = currentSalaryGrade;;
	}
	public SalaryGrade getCurrentSalaryGrade(){
		return this.mCurrentSalaryGrade;
	}
	public Employee updateCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
		this.mCurrentSalaryGrade = currentSalaryGrade;;
		this.changed = true;
		return this;
	}
	public void mergeCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
		if(currentSalaryGrade != null) { setCurrentSalaryGrade(currentSalaryGrade);}
	}
	
	
	public void clearCurrentSalaryGrade(){
		setCurrentSalaryGrade ( null );
		this.changed = true;
	}
	
	public void setSalaryAccount(String salaryAccount){
		this.mSalaryAccount = trimString(salaryAccount);;
	}
	public String getSalaryAccount(){
		return this.mSalaryAccount;
	}
	public Employee updateSalaryAccount(String salaryAccount){
		this.mSalaryAccount = trimString(salaryAccount);;
		this.changed = true;
		return this;
	}
	public void mergeSalaryAccount(String salaryAccount){
		if(salaryAccount != null) { setSalaryAccount(salaryAccount);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Employee updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Employee updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
	public  void setEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setEmployee(this);
		}

		this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
		this.mEmployeeCompanyTrainingList.setListInternalName (EMPLOYEE_COMPANY_TRAINING_LIST );
		
	}
	
	public  void addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		employeeCompanyTraining.setEmployee(this);
		getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
	}
	public  void addEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setEmployee(this);
		}
		getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
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
	public  void setEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setEmployee(this);
		}

		this.mEmployeeSkillList = employeeSkillList;
		this.mEmployeeSkillList.setListInternalName (EMPLOYEE_SKILL_LIST );
		
	}
	
	public  void addEmployeeSkill(EmployeeSkill employeeSkill){
		employeeSkill.setEmployee(this);
		getEmployeeSkillList().add(employeeSkill);
	}
	public  void addEmployeeSkillList(SmartList<EmployeeSkill> employeeSkillList){
		for( EmployeeSkill employeeSkill:employeeSkillList){
			employeeSkill.setEmployee(this);
		}
		getEmployeeSkillList().addAll(employeeSkillList);
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
	public  void setEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList){
		for( EmployeePerformance employeePerformance:employeePerformanceList){
			employeePerformance.setEmployee(this);
		}

		this.mEmployeePerformanceList = employeePerformanceList;
		this.mEmployeePerformanceList.setListInternalName (EMPLOYEE_PERFORMANCE_LIST );
		
	}
	
	public  void addEmployeePerformance(EmployeePerformance employeePerformance){
		employeePerformance.setEmployee(this);
		getEmployeePerformanceList().add(employeePerformance);
	}
	public  void addEmployeePerformanceList(SmartList<EmployeePerformance> employeePerformanceList){
		for( EmployeePerformance employeePerformance:employeePerformanceList){
			employeePerformance.setEmployee(this);
		}
		getEmployeePerformanceList().addAll(employeePerformanceList);
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
	public  void setEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList){
		for( EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			employeeWorkExperience.setEmployee(this);
		}

		this.mEmployeeWorkExperienceList = employeeWorkExperienceList;
		this.mEmployeeWorkExperienceList.setListInternalName (EMPLOYEE_WORK_EXPERIENCE_LIST );
		
	}
	
	public  void addEmployeeWorkExperience(EmployeeWorkExperience employeeWorkExperience){
		employeeWorkExperience.setEmployee(this);
		getEmployeeWorkExperienceList().add(employeeWorkExperience);
	}
	public  void addEmployeeWorkExperienceList(SmartList<EmployeeWorkExperience> employeeWorkExperienceList){
		for( EmployeeWorkExperience employeeWorkExperience:employeeWorkExperienceList){
			employeeWorkExperience.setEmployee(this);
		}
		getEmployeeWorkExperienceList().addAll(employeeWorkExperienceList);
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
	public  void setEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setWho(this);
		}

		this.mEmployeeLeaveList = employeeLeaveList;
		this.mEmployeeLeaveList.setListInternalName (EMPLOYEE_LEAVE_LIST );
		
	}
	
	public  void addEmployeeLeave(EmployeeLeave employeeLeave){
		employeeLeave.setWho(this);
		getEmployeeLeaveList().add(employeeLeave);
	}
	public  void addEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setWho(this);
		}
		getEmployeeLeaveList().addAll(employeeLeaveList);
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
	public  void setEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setEmployee(this);
		}

		this.mEmployeeInterviewList = employeeInterviewList;
		this.mEmployeeInterviewList.setListInternalName (EMPLOYEE_INTERVIEW_LIST );
		
	}
	
	public  void addEmployeeInterview(EmployeeInterview employeeInterview){
		employeeInterview.setEmployee(this);
		getEmployeeInterviewList().add(employeeInterview);
	}
	public  void addEmployeeInterviewList(SmartList<EmployeeInterview> employeeInterviewList){
		for( EmployeeInterview employeeInterview:employeeInterviewList){
			employeeInterview.setEmployee(this);
		}
		getEmployeeInterviewList().addAll(employeeInterviewList);
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
	public  void setEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList){
		for( EmployeeAttendance employeeAttendance:employeeAttendanceList){
			employeeAttendance.setEmployee(this);
		}

		this.mEmployeeAttendanceList = employeeAttendanceList;
		this.mEmployeeAttendanceList.setListInternalName (EMPLOYEE_ATTENDANCE_LIST );
		
	}
	
	public  void addEmployeeAttendance(EmployeeAttendance employeeAttendance){
		employeeAttendance.setEmployee(this);
		getEmployeeAttendanceList().add(employeeAttendance);
	}
	public  void addEmployeeAttendanceList(SmartList<EmployeeAttendance> employeeAttendanceList){
		for( EmployeeAttendance employeeAttendance:employeeAttendanceList){
			employeeAttendance.setEmployee(this);
		}
		getEmployeeAttendanceList().addAll(employeeAttendanceList);
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
	public  void setEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList){
		for( EmployeeQualifier employeeQualifier:employeeQualifierList){
			employeeQualifier.setEmployee(this);
		}

		this.mEmployeeQualifierList = employeeQualifierList;
		this.mEmployeeQualifierList.setListInternalName (EMPLOYEE_QUALIFIER_LIST );
		
	}
	
	public  void addEmployeeQualifier(EmployeeQualifier employeeQualifier){
		employeeQualifier.setEmployee(this);
		getEmployeeQualifierList().add(employeeQualifier);
	}
	public  void addEmployeeQualifierList(SmartList<EmployeeQualifier> employeeQualifierList){
		for( EmployeeQualifier employeeQualifier:employeeQualifierList){
			employeeQualifier.setEmployee(this);
		}
		getEmployeeQualifierList().addAll(employeeQualifierList);
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
	public  void setEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList){
		for( EmployeeEducation employeeEducation:employeeEducationList){
			employeeEducation.setEmployee(this);
		}

		this.mEmployeeEducationList = employeeEducationList;
		this.mEmployeeEducationList.setListInternalName (EMPLOYEE_EDUCATION_LIST );
		
	}
	
	public  void addEmployeeEducation(EmployeeEducation employeeEducation){
		employeeEducation.setEmployee(this);
		getEmployeeEducationList().add(employeeEducation);
	}
	public  void addEmployeeEducationList(SmartList<EmployeeEducation> employeeEducationList){
		for( EmployeeEducation employeeEducation:employeeEducationList){
			employeeEducation.setEmployee(this);
		}
		getEmployeeEducationList().addAll(employeeEducationList);
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
	public  void setEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList){
		for( EmployeeAward employeeAward:employeeAwardList){
			employeeAward.setEmployee(this);
		}

		this.mEmployeeAwardList = employeeAwardList;
		this.mEmployeeAwardList.setListInternalName (EMPLOYEE_AWARD_LIST );
		
	}
	
	public  void addEmployeeAward(EmployeeAward employeeAward){
		employeeAward.setEmployee(this);
		getEmployeeAwardList().add(employeeAward);
	}
	public  void addEmployeeAwardList(SmartList<EmployeeAward> employeeAwardList){
		for( EmployeeAward employeeAward:employeeAwardList){
			employeeAward.setEmployee(this);
		}
		getEmployeeAwardList().addAll(employeeAwardList);
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
	public  void setEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setEmployee(this);
		}

		this.mEmployeeSalarySheetList = employeeSalarySheetList;
		this.mEmployeeSalarySheetList.setListInternalName (EMPLOYEE_SALARY_SHEET_LIST );
		
	}
	
	public  void addEmployeeSalarySheet(EmployeeSalarySheet employeeSalarySheet){
		employeeSalarySheet.setEmployee(this);
		getEmployeeSalarySheetList().add(employeeSalarySheet);
	}
	public  void addEmployeeSalarySheetList(SmartList<EmployeeSalarySheet> employeeSalarySheetList){
		for( EmployeeSalarySheet employeeSalarySheet:employeeSalarySheetList){
			employeeSalarySheet.setEmployee(this);
		}
		getEmployeeSalarySheetList().addAll(employeeSalarySheetList);
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
	public  void setPayingOffList(SmartList<PayingOff> payingOffList){
		for( PayingOff payingOff:payingOffList){
			payingOff.setPaidFor(this);
		}

		this.mPayingOffList = payingOffList;
		this.mPayingOffList.setListInternalName (PAYING_OFF_LIST );
		
	}
	
	public  void addPayingOff(PayingOff payingOff){
		payingOff.setPaidFor(this);
		getPayingOffList().add(payingOff);
	}
	public  void addPayingOffList(SmartList<PayingOff> payingOffList){
		for( PayingOff payingOff:payingOffList){
			payingOff.setPaidFor(this);
		}
		getPayingOffList().addAll(payingOffList);
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

