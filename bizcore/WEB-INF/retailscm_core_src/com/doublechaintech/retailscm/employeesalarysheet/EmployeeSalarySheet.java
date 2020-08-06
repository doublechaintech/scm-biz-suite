
package com.doublechaintech.retailscm.employeesalarysheet;

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
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.payingoff.PayingOff;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;









@JsonSerialize(using = EmployeeSalarySheetSerializer.class)
public class EmployeeSalarySheet extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String CURRENT_SALARY_GRADE_PROPERTY  = "currentSalaryGrade";
	public static final String BASE_SALARY_PROPERTY           = "baseSalary"        ;
	public static final String BONUS_PROPERTY                 = "bonus"             ;
	public static final String REWARD_PROPERTY                = "reward"            ;
	public static final String PERSONAL_TAX_PROPERTY          = "personalTax"       ;
	public static final String SOCIAL_SECURITY_PROPERTY       = "socialSecurity"    ;
	public static final String HOUSING_FOUND_PROPERTY         = "housingFound"      ;
	public static final String JOB_INSURANCE_PROPERTY         = "jobInsurance"      ;
	public static final String PAYING_OFF_PROPERTY            = "payingOff"         ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeSalarySheet";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		SalaryGrade         	mCurrentSalaryGrade ;
	protected		BigDecimal          	mBaseSalary         ;
	protected		BigDecimal          	mBonus              ;
	protected		BigDecimal          	mReward             ;
	protected		BigDecimal          	mPersonalTax        ;
	protected		BigDecimal          	mSocialSecurity     ;
	protected		BigDecimal          	mHousingFound       ;
	protected		BigDecimal          	mJobInsurance       ;
	protected		PayingOff           	mPayingOff          ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EmployeeSalarySheet(){
		// lazy load for all the properties
	}
	public 	static EmployeeSalarySheet withId(String id){
		EmployeeSalarySheet employeeSalarySheet = new EmployeeSalarySheet();
		employeeSalarySheet.setId(id);
		employeeSalarySheet.setVersion(Integer.MAX_VALUE);
		return employeeSalarySheet;
	}
	public 	static EmployeeSalarySheet refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );
		setCurrentSalaryGrade( null );
		setPayingOff( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(BASE_SALARY_PROPERTY.equals(property)){
			changeBaseSalaryProperty(newValueExpr);
		}
		if(BONUS_PROPERTY.equals(property)){
			changeBonusProperty(newValueExpr);
		}
		if(REWARD_PROPERTY.equals(property)){
			changeRewardProperty(newValueExpr);
		}
		if(PERSONAL_TAX_PROPERTY.equals(property)){
			changePersonalTaxProperty(newValueExpr);
		}
		if(SOCIAL_SECURITY_PROPERTY.equals(property)){
			changeSocialSecurityProperty(newValueExpr);
		}
		if(HOUSING_FOUND_PROPERTY.equals(property)){
			changeHousingFoundProperty(newValueExpr);
		}
		if(JOB_INSURANCE_PROPERTY.equals(property)){
			changeJobInsuranceProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeBaseSalaryProperty(String newValueExpr){
	
		BigDecimal oldValue = getBaseSalary();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBaseSalary(newValue);
		this.onChangeProperty(BASE_SALARY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeBonusProperty(String newValueExpr){
	
		BigDecimal oldValue = getBonus();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBonus(newValue);
		this.onChangeProperty(BONUS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeRewardProperty(String newValueExpr){
	
		BigDecimal oldValue = getReward();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateReward(newValue);
		this.onChangeProperty(REWARD_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changePersonalTaxProperty(String newValueExpr){
	
		BigDecimal oldValue = getPersonalTax();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePersonalTax(newValue);
		this.onChangeProperty(PERSONAL_TAX_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeSocialSecurityProperty(String newValueExpr){
	
		BigDecimal oldValue = getSocialSecurity();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSocialSecurity(newValue);
		this.onChangeProperty(SOCIAL_SECURITY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeHousingFoundProperty(String newValueExpr){
	
		BigDecimal oldValue = getHousingFound();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateHousingFound(newValue);
		this.onChangeProperty(HOUSING_FOUND_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeJobInsuranceProperty(String newValueExpr){
	
		BigDecimal oldValue = getJobInsurance();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateJobInsurance(newValue);
		this.onChangeProperty(JOB_INSURANCE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(EMPLOYEE_PROPERTY.equals(property)){
			return getEmployee();
		}
		if(CURRENT_SALARY_GRADE_PROPERTY.equals(property)){
			return getCurrentSalaryGrade();
		}
		if(BASE_SALARY_PROPERTY.equals(property)){
			return getBaseSalary();
		}
		if(BONUS_PROPERTY.equals(property)){
			return getBonus();
		}
		if(REWARD_PROPERTY.equals(property)){
			return getReward();
		}
		if(PERSONAL_TAX_PROPERTY.equals(property)){
			return getPersonalTax();
		}
		if(SOCIAL_SECURITY_PROPERTY.equals(property)){
			return getSocialSecurity();
		}
		if(HOUSING_FOUND_PROPERTY.equals(property)){
			return getHousingFound();
		}
		if(JOB_INSURANCE_PROPERTY.equals(property)){
			return getJobInsurance();
		}
		if(PAYING_OFF_PROPERTY.equals(property)){
			return getPayingOff();
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
	public EmployeeSalarySheet updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setEmployee(Employee employee){
		this.mEmployee = employee;;
	}
	public Employee getEmployee(){
		return this.mEmployee;
	}
	public EmployeeSalarySheet updateEmployee(Employee employee){
		this.mEmployee = employee;;
		this.changed = true;
		return this;
	}
	public void mergeEmployee(Employee employee){
		if(employee != null) { setEmployee(employee);}
	}
	
	
	public void clearEmployee(){
		setEmployee ( null );
		this.changed = true;
	}
	
	public void setCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
		this.mCurrentSalaryGrade = currentSalaryGrade;;
	}
	public SalaryGrade getCurrentSalaryGrade(){
		return this.mCurrentSalaryGrade;
	}
	public EmployeeSalarySheet updateCurrentSalaryGrade(SalaryGrade currentSalaryGrade){
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
	
	public void setBaseSalary(BigDecimal baseSalary){
		this.mBaseSalary = baseSalary;;
	}
	public BigDecimal getBaseSalary(){
		return this.mBaseSalary;
	}
	public EmployeeSalarySheet updateBaseSalary(BigDecimal baseSalary){
		this.mBaseSalary = baseSalary;;
		this.changed = true;
		return this;
	}
	public void mergeBaseSalary(BigDecimal baseSalary){
		setBaseSalary(baseSalary);
	}
	
	
	public void setBonus(BigDecimal bonus){
		this.mBonus = bonus;;
	}
	public BigDecimal getBonus(){
		return this.mBonus;
	}
	public EmployeeSalarySheet updateBonus(BigDecimal bonus){
		this.mBonus = bonus;;
		this.changed = true;
		return this;
	}
	public void mergeBonus(BigDecimal bonus){
		setBonus(bonus);
	}
	
	
	public void setReward(BigDecimal reward){
		this.mReward = reward;;
	}
	public BigDecimal getReward(){
		return this.mReward;
	}
	public EmployeeSalarySheet updateReward(BigDecimal reward){
		this.mReward = reward;;
		this.changed = true;
		return this;
	}
	public void mergeReward(BigDecimal reward){
		setReward(reward);
	}
	
	
	public void setPersonalTax(BigDecimal personalTax){
		this.mPersonalTax = personalTax;;
	}
	public BigDecimal getPersonalTax(){
		return this.mPersonalTax;
	}
	public EmployeeSalarySheet updatePersonalTax(BigDecimal personalTax){
		this.mPersonalTax = personalTax;;
		this.changed = true;
		return this;
	}
	public void mergePersonalTax(BigDecimal personalTax){
		setPersonalTax(personalTax);
	}
	
	
	public void setSocialSecurity(BigDecimal socialSecurity){
		this.mSocialSecurity = socialSecurity;;
	}
	public BigDecimal getSocialSecurity(){
		return this.mSocialSecurity;
	}
	public EmployeeSalarySheet updateSocialSecurity(BigDecimal socialSecurity){
		this.mSocialSecurity = socialSecurity;;
		this.changed = true;
		return this;
	}
	public void mergeSocialSecurity(BigDecimal socialSecurity){
		setSocialSecurity(socialSecurity);
	}
	
	
	public void setHousingFound(BigDecimal housingFound){
		this.mHousingFound = housingFound;;
	}
	public BigDecimal getHousingFound(){
		return this.mHousingFound;
	}
	public EmployeeSalarySheet updateHousingFound(BigDecimal housingFound){
		this.mHousingFound = housingFound;;
		this.changed = true;
		return this;
	}
	public void mergeHousingFound(BigDecimal housingFound){
		setHousingFound(housingFound);
	}
	
	
	public void setJobInsurance(BigDecimal jobInsurance){
		this.mJobInsurance = jobInsurance;;
	}
	public BigDecimal getJobInsurance(){
		return this.mJobInsurance;
	}
	public EmployeeSalarySheet updateJobInsurance(BigDecimal jobInsurance){
		this.mJobInsurance = jobInsurance;;
		this.changed = true;
		return this;
	}
	public void mergeJobInsurance(BigDecimal jobInsurance){
		setJobInsurance(jobInsurance);
	}
	
	
	public void setPayingOff(PayingOff payingOff){
		this.mPayingOff = payingOff;;
	}
	public PayingOff getPayingOff(){
		return this.mPayingOff;
	}
	public EmployeeSalarySheet updatePayingOff(PayingOff payingOff){
		this.mPayingOff = payingOff;;
		this.changed = true;
		return this;
	}
	public void mergePayingOff(PayingOff payingOff){
		if(payingOff != null) { setPayingOff(payingOff);}
	}
	
	
	public void clearPayingOff(){
		setPayingOff ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public EmployeeSalarySheet updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEmployee(), internalType);
		addToEntityList(this, entityList, getCurrentSalaryGrade(), internalType);
		addToEntityList(this, entityList, getPayingOff(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

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
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeSalarySheet){
		
		
			EmployeeSalarySheet dest =(EmployeeSalarySheet)baseDest;
		
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
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeSalarySheet){
		
			
			EmployeeSalarySheet dest =(EmployeeSalarySheet)baseDest;
		
			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeCurrentSalaryGrade(getCurrentSalaryGrade());
			dest.mergeBaseSalary(getBaseSalary());
			dest.mergeBonus(getBonus());
			dest.mergeReward(getReward());
			dest.mergePersonalTax(getPersonalTax());
			dest.mergeSocialSecurity(getSocialSecurity());
			dest.mergeHousingFound(getHousingFound());
			dest.mergeJobInsurance(getJobInsurance());
			dest.mergePayingOff(getPayingOff());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeSalarySheet){
		
			
			EmployeeSalarySheet dest =(EmployeeSalarySheet)baseDest;
		
			dest.mergeId(getId());
			dest.mergeBaseSalary(getBaseSalary());
			dest.mergeBonus(getBonus());
			dest.mergeReward(getReward());
			dest.mergePersonalTax(getPersonalTax());
			dest.mergeSocialSecurity(getSocialSecurity());
			dest.mergeHousingFound(getHousingFound());
			dest.mergeJobInsurance(getJobInsurance());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getCurrentSalaryGrade(), getBaseSalary(), getBonus(), getReward(), getPersonalTax(), getSocialSecurity(), getHousingFound(), getJobInsurance(), getPayingOff(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeSalarySheet{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		if(getCurrentSalaryGrade() != null ){
 			stringBuilder.append("\tcurrentSalaryGrade='SalaryGrade("+getCurrentSalaryGrade().getId()+")';");
 		}
		stringBuilder.append("\tbaseSalary='"+getBaseSalary()+"';");
		stringBuilder.append("\tbonus='"+getBonus()+"';");
		stringBuilder.append("\treward='"+getReward()+"';");
		stringBuilder.append("\tpersonalTax='"+getPersonalTax()+"';");
		stringBuilder.append("\tsocialSecurity='"+getSocialSecurity()+"';");
		stringBuilder.append("\thousingFound='"+getHousingFound()+"';");
		stringBuilder.append("\tjobInsurance='"+getJobInsurance()+"';");
		if(getPayingOff() != null ){
 			stringBuilder.append("\tpayingOff='PayingOff("+getPayingOff().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

