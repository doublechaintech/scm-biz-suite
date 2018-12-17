
package com.doublechaintech.retailscm.jobapplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.employee.Employee;

@JsonSerialize(using = JobApplicationSerializer.class)
public class JobApplication extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String APPLICATION_TIME_PROPERTY      = "applicationTime"   ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String COMMENTS_PROPERTY              = "comments"          ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;

	public static final String INTERNAL_TYPE="JobApplication";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getWho();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Date                	mApplicationTime    ;
	protected		String              	mWho                ;
	protected		String              	mComments           ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;
	
		
	public 	JobApplication(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	JobApplication(Date applicationTime, String who, String comments)
	{
		setApplicationTime(applicationTime);
		setWho(who);
		setComments(comments);

		this.mEmployeeList = new SmartList<Employee>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(APPLICATION_TIME_PROPERTY.equals(property)){
			changeApplicationTimeProperty(newValueExpr);
		}
		if(WHO_PROPERTY.equals(property)){
			changeWhoProperty(newValueExpr);
		}
		if(COMMENTS_PROPERTY.equals(property)){
			changeCommentsProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeApplicationTimeProperty(String newValueExpr){
		Date oldValue = getApplicationTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateApplicationTime(newValue);
		this.onChangeProperty(APPLICATION_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeWhoProperty(String newValueExpr){
		String oldValue = getWho();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWho(newValue);
		this.onChangeProperty(WHO_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeCommentsProperty(String newValueExpr){
		String oldValue = getComments();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComments(newValue);
		this.onChangeProperty(COMMENTS_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public JobApplication updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setApplicationTime(Date applicationTime){
		this.mApplicationTime = applicationTime;;
	}
	public Date getApplicationTime(){
		return this.mApplicationTime;
	}
	public JobApplication updateApplicationTime(Date applicationTime){
		this.mApplicationTime = applicationTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setWho(String who){
		this.mWho = trimString(who);;
	}
	public String getWho(){
		return this.mWho;
	}
	public JobApplication updateWho(String who){
		this.mWho = trimString(who);;
		this.changed = true;
		return this;
	}
	
	
	public void setComments(String comments){
		this.mComments = trimString(comments);;
	}
	public String getComments(){
		return this.mComments;
	}
	public JobApplication updateComments(String comments){
		this.mComments = trimString(comments);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public JobApplication updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<Employee> getEmployeeList(){
		if(this.mEmployeeList == null){
			this.mEmployeeList = new SmartList<Employee>();
			this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEmployeeList;	
	}
	public  void setEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setJobApplication(this);
		}

		this.mEmployeeList = employeeList;
		this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setJobApplication(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setJobApplication(this);
		}
		getEmployeeList().addAll(employeeList);
	}
	
	public  Employee removeEmployee(Employee employeeIndex){
		
		int index = getEmployeeList().indexOf(employeeIndex);
        if(index < 0){
        	String message = "Employee("+employeeIndex.getId()+") with version='"+employeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Employee employee = getEmployeeList().get(index);        
        // employee.clearJobApplication(); //disconnect with JobApplication
        employee.clearFromAll(); //disconnect with JobApplication
		
		boolean result = getEmployeeList().planToRemove(employee);
        if(!result){
        	String message = "Employee("+employeeIndex.getId()+") with version='"+employeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employee;
        
	
	}
	//断舍离
	public  void breakWithEmployee(Employee employee){
		
		if(employee == null){
			return;
		}
		employee.setJobApplication(null);
		//getEmployeeList().remove();
	
	}
	
	public  boolean hasEmployee(Employee employee){
	
		return getEmployeeList().contains(employee);
  
	}
	
	public void copyEmployeeFrom(Employee employee) {

		Employee employeeInList = findTheEmployee(employee);
		Employee newEmployee = new Employee();
		employeeInList.copyTo(newEmployee);
		newEmployee.setVersion(0);//will trigger copy
		getEmployeeList().add(newEmployee);
		addItemToFlexiableObject(COPIED_CHILD, newEmployee);
	}
	
	public  Employee findTheEmployee(Employee employee){
		
		int index =  getEmployeeList().indexOf(employee);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Employee("+employee.getId()+") with version='"+employee.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeList(){
		getEmployeeList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){


		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, APPLICATION_TIME_PROPERTY, getApplicationTime());
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, COMMENTS_PROPERTY, getComments());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
		if(!getEmployeeList().isEmpty()){
			appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
			appendKeyValuePair(result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof JobApplication){
		
		
			JobApplication dest =(JobApplication)baseDest;
		
			dest.setId(getId());
			dest.setApplicationTime(getApplicationTime());
			dest.setWho(getWho());
			dest.setComments(getComments());
			dest.setVersion(getVersion());
			dest.setEmployeeList(getEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("JobApplication{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tapplicationTime='"+getApplicationTime()+"';");
		stringBuilder.append("\twho='"+getWho()+"';");
		stringBuilder.append("\tcomments='"+getComments()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

