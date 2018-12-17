
package com.doublechaintech.retailscm.companytraining;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

@JsonSerialize(using = CompanyTrainingSerializer.class)
public class CompanyTraining extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String INSTRUCTOR_PROPERTY            = "instructor"        ;
	public static final String TRAINING_COURSE_TYPE_PROPERTY  = "trainingCourseType";
	public static final String TIME_START_PROPERTY            = "timeStart"         ;
	public static final String DURATION_HOURS_PROPERTY        = "durationHours"     ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_COMPANY_TRAINING_LIST           = "employeeCompanyTrainingList";

	public static final String INTERNAL_TYPE="CompanyTraining";
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
	protected		String              	mTitle              ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		Instructor          	mInstructor         ;
	protected		TrainingCourseType  	mTrainingCourseType ;
	protected		Date                	mTimeStart          ;
	protected		int                 	mDurationHours      ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeCompanyTraining>	mEmployeeCompanyTrainingList;
	
		
	public 	CompanyTraining(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );
		setInstructor( null );
		setTrainingCourseType( null );

		this.changed = true;
	}
	
	public 	CompanyTraining(String title, RetailStoreCountryCenter company, Instructor instructor, TrainingCourseType trainingCourseType, Date timeStart, int durationHours, DateTime lastUpdateTime)
	{
		setTitle(title);
		setCompany(company);
		setInstructor(instructor);
		setTrainingCourseType(trainingCourseType);
		setTimeStart(timeStart);
		setDurationHours(durationHours);
		setLastUpdateTime(lastUpdateTime);

		this.mEmployeeCompanyTrainingList = new SmartList<EmployeeCompanyTraining>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(TIME_START_PROPERTY.equals(property)){
			changeTimeStartProperty(newValueExpr);
		}
		if(DURATION_HOURS_PROPERTY.equals(property)){
			changeDurationHoursProperty(newValueExpr);
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
			
			
			
	protected void changeTimeStartProperty(String newValueExpr){
		Date oldValue = getTimeStart();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTimeStart(newValue);
		this.onChangeProperty(TIME_START_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDurationHoursProperty(String newValueExpr){
		int oldValue = getDurationHours();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDurationHours(newValue);
		this.onChangeProperty(DURATION_HOURS_PROPERTY, oldValue, newValue);
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public CompanyTraining updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public CompanyTraining updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	public CompanyTraining updateCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
		this.changed = true;
		return this;
	}
	
	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
	}
	
	public void setInstructor(Instructor instructor){
		this.mInstructor = instructor;;
	}
	public Instructor getInstructor(){
		return this.mInstructor;
	}
	public CompanyTraining updateInstructor(Instructor instructor){
		this.mInstructor = instructor;;
		this.changed = true;
		return this;
	}
	
	
	public void clearInstructor(){
		setInstructor ( null );
		this.changed = true;
	}
	
	public void setTrainingCourseType(TrainingCourseType trainingCourseType){
		this.mTrainingCourseType = trainingCourseType;;
	}
	public TrainingCourseType getTrainingCourseType(){
		return this.mTrainingCourseType;
	}
	public CompanyTraining updateTrainingCourseType(TrainingCourseType trainingCourseType){
		this.mTrainingCourseType = trainingCourseType;;
		this.changed = true;
		return this;
	}
	
	
	public void clearTrainingCourseType(){
		setTrainingCourseType ( null );
		this.changed = true;
	}
	
	public void setTimeStart(Date timeStart){
		this.mTimeStart = timeStart;;
	}
	public Date getTimeStart(){
		return this.mTimeStart;
	}
	public CompanyTraining updateTimeStart(Date timeStart){
		this.mTimeStart = timeStart;;
		this.changed = true;
		return this;
	}
	
	
	public void setDurationHours(int durationHours){
		this.mDurationHours = durationHours;;
	}
	public int getDurationHours(){
		return this.mDurationHours;
	}
	public CompanyTraining updateDurationHours(int durationHours){
		this.mDurationHours = durationHours;;
		this.changed = true;
		return this;
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public CompanyTraining updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public CompanyTraining updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
			employeeCompanyTraining.setTraining(this);
		}

		this.mEmployeeCompanyTrainingList = employeeCompanyTrainingList;
		this.mEmployeeCompanyTrainingList.setListInternalName (EMPLOYEE_COMPANY_TRAINING_LIST );
		
	}
	
	public  void addEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTraining){
		employeeCompanyTraining.setTraining(this);
		getEmployeeCompanyTrainingList().add(employeeCompanyTraining);
	}
	public  void addEmployeeCompanyTrainingList(SmartList<EmployeeCompanyTraining> employeeCompanyTrainingList){
		for( EmployeeCompanyTraining employeeCompanyTraining:employeeCompanyTrainingList){
			employeeCompanyTraining.setTraining(this);
		}
		getEmployeeCompanyTrainingList().addAll(employeeCompanyTrainingList);
	}
	
	public  EmployeeCompanyTraining removeEmployeeCompanyTraining(EmployeeCompanyTraining employeeCompanyTrainingIndex){
		
		int index = getEmployeeCompanyTrainingList().indexOf(employeeCompanyTrainingIndex);
        if(index < 0){
        	String message = "EmployeeCompanyTraining("+employeeCompanyTrainingIndex.getId()+") with version='"+employeeCompanyTrainingIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeCompanyTraining employeeCompanyTraining = getEmployeeCompanyTrainingList().get(index);        
        // employeeCompanyTraining.clearTraining(); //disconnect with Training
        employeeCompanyTraining.clearFromAll(); //disconnect with Training
		
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
		employeeCompanyTraining.setTraining(null);
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);
		addToEntityList(this, entityList, getInstructor(), internalType);
		addToEntityList(this, entityList, getTrainingCourseType(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeCompanyTrainingList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeCompanyTrainingList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, INSTRUCTOR_PROPERTY, getInstructor());
		appendKeyValuePair(result, TRAINING_COURSE_TYPE_PROPERTY, getTrainingCourseType());
		appendKeyValuePair(result, TIME_START_PROPERTY, getTimeStart());
		appendKeyValuePair(result, DURATION_HOURS_PROPERTY, getDurationHours());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_COMPANY_TRAINING_LIST, getEmployeeCompanyTrainingList());
		if(!getEmployeeCompanyTrainingList().isEmpty()){
			appendKeyValuePair(result, "employeeCompanyTrainingCount", getEmployeeCompanyTrainingList().getTotalCount());
			appendKeyValuePair(result, "employeeCompanyTrainingCurrentPageNumber", getEmployeeCompanyTrainingList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CompanyTraining){
		
		
			CompanyTraining dest =(CompanyTraining)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setCompany(getCompany());
			dest.setInstructor(getInstructor());
			dest.setTrainingCourseType(getTrainingCourseType());
			dest.setTimeStart(getTimeStart());
			dest.setDurationHours(getDurationHours());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setEmployeeCompanyTrainingList(getEmployeeCompanyTrainingList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("CompanyTraining{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		if(getInstructor() != null ){
 			stringBuilder.append("\tinstructor='Instructor("+getInstructor().getId()+")';");
 		}
		if(getTrainingCourseType() != null ){
 			stringBuilder.append("\ttrainingCourseType='TrainingCourseType("+getTrainingCourseType().getId()+")';");
 		}
		stringBuilder.append("\ttimeStart='"+getTimeStart()+"';");
		stringBuilder.append("\tdurationHours='"+getDurationHours()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseDurationHours(int incDurationHours){
		updateDurationHours(this.mDurationHours +  incDurationHours);
	}
	public void decreaseDurationHours(int decDurationHours){
		updateDurationHours(this.mDurationHours - decDurationHours);
	}
	

}

