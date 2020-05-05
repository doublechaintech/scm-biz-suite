
package com.doublechaintech.retailscm.levelthreedepartment;

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
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;
import com.doublechaintech.retailscm.employee.Employee;

@JsonSerialize(using = LevelThreeDepartmentSerializer.class)
public class LevelThreeDepartment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BELONGS_TO_PROPERTY            = "belongsTo"         ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;

	public static final String INTERNAL_TYPE="LevelThreeDepartment";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		LevelTwoDepartment  	mBelongsTo          ;
	protected		String              	mName               ;
	protected		String              	mDescription        ;
	protected		Date                	mFounded            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Employee> 	mEmployeeList       ;

	
		
	public 	LevelThreeDepartment(){
		// lazy load for all the properties
	}
	public 	static LevelThreeDepartment withId(String id){
		LevelThreeDepartment levelThreeDepartment = new LevelThreeDepartment();
		levelThreeDepartment.setId(id);
		levelThreeDepartment.setVersion(Integer.MAX_VALUE);
		return levelThreeDepartment;
	}
	public 	static LevelThreeDepartment refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongsTo( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
	
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
	
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFounded(newValue);
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(BELONGS_TO_PROPERTY.equals(property)){
			return getBelongsTo();
		}
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeList().stream().map(item->item).collect(Collectors.toList());
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
	public LevelThreeDepartment updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setBelongsTo(LevelTwoDepartment belongsTo){
		this.mBelongsTo = belongsTo;;
	}
	public LevelTwoDepartment getBelongsTo(){
		return this.mBelongsTo;
	}
	public LevelThreeDepartment updateBelongsTo(LevelTwoDepartment belongsTo){
		this.mBelongsTo = belongsTo;;
		this.changed = true;
		return this;
	}
	public void mergeBelongsTo(LevelTwoDepartment belongsTo){
		if(belongsTo != null) { setBelongsTo(belongsTo);}
	}
	
	
	public void clearBelongsTo(){
		setBelongsTo ( null );
		this.changed = true;
	}
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public LevelThreeDepartment updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public LevelThreeDepartment updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public LevelThreeDepartment updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LevelThreeDepartment updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			employee.setDepartment(this);
		}

		this.mEmployeeList = employeeList;
		this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
		
	}
	
	public  void addEmployee(Employee employee){
		employee.setDepartment(this);
		getEmployeeList().add(employee);
	}
	public  void addEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setDepartment(this);
		}
		getEmployeeList().addAll(employeeList);
	}
	public  void mergeEmployeeList(SmartList<Employee> employeeList){
		if(employeeList==null){
			return;
		}
		if(employeeList.isEmpty()){
			return;
		}
		addEmployeeList( employeeList );
		
	}
	public  Employee removeEmployee(Employee employeeIndex){
		
		int index = getEmployeeList().indexOf(employeeIndex);
        if(index < 0){
        	String message = "Employee("+employeeIndex.getId()+") with version='"+employeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Employee employee = getEmployeeList().get(index);        
        // employee.clearDepartment(); //disconnect with Department
        employee.clearFromAll(); //disconnect with Department
		
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
		employee.setDepartment(null);
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

		addToEntityList(this, entityList, getBelongsTo(), internalType);

		
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
		appendKeyValuePair(result, BELONGS_TO_PROPERTY, getBelongsTo());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
		if(!getEmployeeList().isEmpty()){
			appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
			appendKeyValuePair(result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelThreeDepartment){
		
		
			LevelThreeDepartment dest =(LevelThreeDepartment)baseDest;
		
			dest.setId(getId());
			dest.setBelongsTo(getBelongsTo());
			dest.setName(getName());
			dest.setDescription(getDescription());
			dest.setFounded(getFounded());
			dest.setVersion(getVersion());
			dest.setEmployeeList(getEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelThreeDepartment){
		
			
			LevelThreeDepartment dest =(LevelThreeDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeBelongsTo(getBelongsTo());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeList(getEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LevelThreeDepartment){
		
			
			LevelThreeDepartment dest =(LevelThreeDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getBelongsTo(), getName(), getDescription(), getFounded(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LevelThreeDepartment{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBelongsTo() != null ){
 			stringBuilder.append("\tbelongsTo='LevelTwoDepartment("+getBelongsTo().getId()+")';");
 		}
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

