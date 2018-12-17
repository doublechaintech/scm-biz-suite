
package com.doublechaintech.retailscm.termination;

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
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

@JsonSerialize(using = TerminationSerializer.class)
public class Termination extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String REASON_PROPERTY                = "reason"            ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String COMMENT_PROPERTY               = "comment"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;

	public static final String INTERNAL_TYPE="Termination";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getComment();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		TerminationReason   	mReason             ;
	protected		TerminationType     	mType               ;
	protected		String              	mComment            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;
	
		
	public 	Termination(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setReason( null );
		setType( null );

		this.changed = true;
	}
	
	public 	Termination(TerminationReason reason, TerminationType type, String comment)
	{
		setReason(reason);
		setType(type);
		setComment(comment);

		this.mEmployeeList = new SmartList<Employee>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(COMMENT_PROPERTY.equals(property)){
			changeCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCommentProperty(String newValueExpr){
		String oldValue = getComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateComment(newValue);
		this.onChangeProperty(COMMENT_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Termination updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setReason(TerminationReason reason){
		this.mReason = reason;;
	}
	public TerminationReason getReason(){
		return this.mReason;
	}
	public Termination updateReason(TerminationReason reason){
		this.mReason = reason;;
		this.changed = true;
		return this;
	}
	
	
	public void clearReason(){
		setReason ( null );
		this.changed = true;
	}
	
	public void setType(TerminationType type){
		this.mType = type;;
	}
	public TerminationType getType(){
		return this.mType;
	}
	public Termination updateType(TerminationType type){
		this.mType = type;;
		this.changed = true;
		return this;
	}
	
	
	public void clearType(){
		setType ( null );
		this.changed = true;
	}
	
	public void setComment(String comment){
		this.mComment = trimString(comment);;
	}
	public String getComment(){
		return this.mComment;
	}
	public Termination updateComment(String comment){
		this.mComment = trimString(comment);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Termination updateVersion(int version){
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
			employee.setTermination(this);
		}

		this.mEmployeeList = employeeList;
		this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setTermination(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setTermination(this);
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
        // employee.clearTermination(); //disconnect with Termination
        employee.clearFromAll(); //disconnect with Termination
		
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
		employee.setTermination(null);
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

		addToEntityList(this, entityList, getReason(), internalType);
		addToEntityList(this, entityList, getType(), internalType);

		
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
		appendKeyValuePair(result, REASON_PROPERTY, getReason());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, COMMENT_PROPERTY, getComment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
		if(!getEmployeeList().isEmpty()){
			appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
			appendKeyValuePair(result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Termination){
		
		
			Termination dest =(Termination)baseDest;
		
			dest.setId(getId());
			dest.setReason(getReason());
			dest.setType(getType());
			dest.setComment(getComment());
			dest.setVersion(getVersion());
			dest.setEmployeeList(getEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Termination{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getReason() != null ){
 			stringBuilder.append("\treason='TerminationReason("+getReason().getId()+")';");
 		}
		if(getType() != null ){
 			stringBuilder.append("\ttype='TerminationType("+getType().getId()+")';");
 		}
		stringBuilder.append("\tcomment='"+getComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

