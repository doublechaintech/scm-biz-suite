
package com.doublechaintech.retailscm.employeecompanytraining;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
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
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeCompanyTraining";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getCurrentStatus();
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
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	
		
	public 	EmployeeCompanyTraining(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );
		setTraining( null );
		setScoring( null );

		this.changed = true;
	}
	
	public 	EmployeeCompanyTraining(Employee employee, CompanyTraining training, String currentStatus)
	{
		setEmployee(employee);
		setTraining(training);
		setCurrentStatus(currentStatus);
	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	

      
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
	
	
	public void clearScoring(){
		setScoring ( null );
		this.changed = true;
	}
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	public EmployeeCompanyTraining updateCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
		this.changed = true;
		return this;
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
		appendKeyValuePair(result, CURRENT_STATUS_PROPERTY, getCurrentStatus());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeCompanyTraining){
		
		
			EmployeeCompanyTraining dest =(EmployeeCompanyTraining)baseDest;
		
			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setTraining(getTraining());
			dest.setScoring(getScoring());
			dest.setCurrentStatus(getCurrentStatus());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
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
		stringBuilder.append("\tcurrentStatus='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

