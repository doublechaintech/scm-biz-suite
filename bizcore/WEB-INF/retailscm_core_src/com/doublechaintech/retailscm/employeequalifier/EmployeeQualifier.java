
package com.doublechaintech.retailscm.employeequalifier;

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









@JsonSerialize(using = EmployeeQualifierSerializer.class)
public class EmployeeQualifier extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String QUALIFIED_TIME_PROPERTY        = "qualifiedTime"     ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String LEVEL_PROPERTY                 = "level"             ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeQualifier";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getType();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		Date                	mQualifiedTime      ;
	protected		String              	mType               ;
	protected		String              	mLevel              ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EmployeeQualifier(){
		// lazy load for all the properties
	}
	public 	static EmployeeQualifier withId(String id){
		EmployeeQualifier employeeQualifier = new EmployeeQualifier();
		employeeQualifier.setId(id);
		employeeQualifier.setVersion(Integer.MAX_VALUE);
		return employeeQualifier;
	}
	public 	static EmployeeQualifier refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(QUALIFIED_TIME_PROPERTY.equals(property)){
			changeQualifiedTimeProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}
		if(LEVEL_PROPERTY.equals(property)){
			changeLevelProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeQualifiedTimeProperty(String newValueExpr){
	
		Date oldValue = getQualifiedTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateQualifiedTime(newValue);
		this.onChangeProperty(QUALIFIED_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeTypeProperty(String newValueExpr){
	
		String oldValue = getType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateType(newValue);
		this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLevelProperty(String newValueExpr){
	
		String oldValue = getLevel();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLevel(newValue);
		this.onChangeProperty(LEVEL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeRemarkProperty(String newValueExpr){
	
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(EMPLOYEE_PROPERTY.equals(property)){
			return getEmployee();
		}
		if(QUALIFIED_TIME_PROPERTY.equals(property)){
			return getQualifiedTime();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(LEVEL_PROPERTY.equals(property)){
			return getLevel();
		}
		if(REMARK_PROPERTY.equals(property)){
			return getRemark();
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
	public EmployeeQualifier updateId(String id){
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
	public EmployeeQualifier updateEmployee(Employee employee){
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
	
	public void setQualifiedTime(Date qualifiedTime){
		this.mQualifiedTime = qualifiedTime;;
	}
	public Date getQualifiedTime(){
		return this.mQualifiedTime;
	}
	public EmployeeQualifier updateQualifiedTime(Date qualifiedTime){
		this.mQualifiedTime = qualifiedTime;;
		this.changed = true;
		return this;
	}
	public void mergeQualifiedTime(Date qualifiedTime){
		setQualifiedTime(qualifiedTime);
	}
	
	
	public void setType(String type){
		this.mType = trimString(type);;
	}
	public String getType(){
		return this.mType;
	}
	public EmployeeQualifier updateType(String type){
		this.mType = trimString(type);;
		this.changed = true;
		return this;
	}
	public void mergeType(String type){
		if(type != null) { setType(type);}
	}
	
	
	public void setLevel(String level){
		this.mLevel = trimString(level);;
	}
	public String getLevel(){
		return this.mLevel;
	}
	public EmployeeQualifier updateLevel(String level){
		this.mLevel = trimString(level);;
		this.changed = true;
		return this;
	}
	public void mergeLevel(String level){
		if(level != null) { setLevel(level);}
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public EmployeeQualifier updateRemark(String remark){
		this.mRemark = trimString(remark);;
		this.changed = true;
		return this;
	}
	public void mergeRemark(String remark){
		if(remark != null) { setRemark(remark);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public EmployeeQualifier updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEmployee(), internalType);

		
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
		appendKeyValuePair(result, QUALIFIED_TIME_PROPERTY, getQualifiedTime());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, LEVEL_PROPERTY, getLevel());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeQualifier){
		
		
			EmployeeQualifier dest =(EmployeeQualifier)baseDest;
		
			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setQualifiedTime(getQualifiedTime());
			dest.setType(getType());
			dest.setLevel(getLevel());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeQualifier){
		
			
			EmployeeQualifier dest =(EmployeeQualifier)baseDest;
		
			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeQualifiedTime(getQualifiedTime());
			dest.mergeType(getType());
			dest.mergeLevel(getLevel());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeQualifier){
		
			
			EmployeeQualifier dest =(EmployeeQualifier)baseDest;
		
			dest.mergeId(getId());
			dest.mergeQualifiedTime(getQualifiedTime());
			dest.mergeType(getType());
			dest.mergeLevel(getLevel());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getQualifiedTime(), getType(), getLevel(), getRemark(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeQualifier{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tqualifiedTime='"+getQualifiedTime()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\tlevel='"+getLevel()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

