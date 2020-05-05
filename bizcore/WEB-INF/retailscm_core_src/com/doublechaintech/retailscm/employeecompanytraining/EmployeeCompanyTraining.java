
package com.doublechaintech.retailscm.employeecompanytraining;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.scoring.Scoring;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

@JsonSerialize(using = EmployeeCompanyTrainingSerializer.class)
public class EmployeeCompanyTraining extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String TRAINING_PROPERTY              = "training"          ;
	public static final String SCORING_PROPERTY               = "scoring"           ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeCompanyTraining";
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
	protected		CompanyTraining     	mTraining           ;
	protected		Scoring             	mScoring            ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EmployeeCompanyTraining(){
		// lazy load for all the properties
	}
	public 	static EmployeeCompanyTraining withId(String id){
		EmployeeCompanyTraining employeeCompanyTraining = new EmployeeCompanyTraining();
		employeeCompanyTraining.setId(id);
		employeeCompanyTraining.setVersion(Integer.MAX_VALUE);
		return employeeCompanyTraining;
	}
	public 	static EmployeeCompanyTraining refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );
		setTraining( null );
		setScoring( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	

      
	}
    
    


	
	public Object propertyOf(String property) {
     	
		if(EMPLOYEE_PROPERTY.equals(property)){
			return getEmployee();
		}
		if(TRAINING_PROPERTY.equals(property)){
			return getTraining();
		}
		if(SCORING_PROPERTY.equals(property)){
			return getScoring();
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
	public EmployeeCompanyTraining updateId(String id){
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
	public EmployeeCompanyTraining updateEmployee(Employee employee){
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
	
	public void setTraining(CompanyTraining training){
		this.mTraining = training;;
	}
	public CompanyTraining getTraining(){
		return this.mTraining;
	}
	public EmployeeCompanyTraining updateTraining(CompanyTraining training){
		this.mTraining = training;;
		this.changed = true;
		return this;
	}
	public void mergeTraining(CompanyTraining training){
		if(training != null) { setTraining(training);}
	}
	
	
	public void clearTraining(){
		setTraining ( null );
		this.changed = true;
	}
	
	public void setScoring(Scoring scoring){
		this.mScoring = scoring;;
	}
	public Scoring getScoring(){
		return this.mScoring;
	}
	public EmployeeCompanyTraining updateScoring(Scoring scoring){
		this.mScoring = scoring;;
		this.changed = true;
		return this;
	}
	public void mergeScoring(Scoring scoring){
		if(scoring != null) { setScoring(scoring);}
	}
	
	
	public void clearScoring(){
		setScoring ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public EmployeeCompanyTraining updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEmployee(), internalType);
		addToEntityList(this, entityList, getTraining(), internalType);
		addToEntityList(this, entityList, getScoring(), internalType);

		
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
		appendKeyValuePair(result, TRAINING_PROPERTY, getTraining());
		appendKeyValuePair(result, SCORING_PROPERTY, getScoring());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeCompanyTraining){
		
		
			EmployeeCompanyTraining dest =(EmployeeCompanyTraining)baseDest;
		
			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setTraining(getTraining());
			dest.setScoring(getScoring());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeCompanyTraining){
		
			
			EmployeeCompanyTraining dest =(EmployeeCompanyTraining)baseDest;
		
			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeTraining(getTraining());
			dest.mergeScoring(getScoring());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeCompanyTraining){
		
			
			EmployeeCompanyTraining dest =(EmployeeCompanyTraining)baseDest;
		
			dest.mergeId(getId());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getTraining(), getScoring(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeCompanyTraining{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		if(getTraining() != null ){
 			stringBuilder.append("\ttraining='CompanyTraining("+getTraining().getId()+")';");
 		}
		if(getScoring() != null ){
 			stringBuilder.append("\tscoring='Scoring("+getScoring().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

