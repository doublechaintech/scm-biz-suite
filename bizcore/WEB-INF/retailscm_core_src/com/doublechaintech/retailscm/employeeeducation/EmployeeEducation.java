
package com.doublechaintech.retailscm.employeeeducation;

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









@JsonSerialize(using = EmployeeEducationSerializer.class)
public class EmployeeEducation extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String COMPLETE_TIME_PROPERTY         = "completeTime"      ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeEducation";
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
	protected		Date                	mCompleteTime       ;
	protected		String              	mType               ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EmployeeEducation(){
		// lazy load for all the properties
	}
	public 	static EmployeeEducation withId(String id){
		EmployeeEducation employeeEducation = new EmployeeEducation();
		employeeEducation.setId(id);
		employeeEducation.setVersion(Integer.MAX_VALUE);
		return employeeEducation;
	}
	public 	static EmployeeEducation refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(COMPLETE_TIME_PROPERTY.equals(property)){
			changeCompleteTimeProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCompleteTimeProperty(String newValueExpr){
	
		Date oldValue = getCompleteTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCompleteTime(newValue);
		this.onChangeProperty(COMPLETE_TIME_PROPERTY, oldValue, newValue);
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
		if(COMPLETE_TIME_PROPERTY.equals(property)){
			return getCompleteTime();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
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
	public EmployeeEducation updateId(String id){
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
	public EmployeeEducation updateEmployee(Employee employee){
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
	
	public void setCompleteTime(Date completeTime){
		this.mCompleteTime = completeTime;;
	}
	public Date getCompleteTime(){
		return this.mCompleteTime;
	}
	public EmployeeEducation updateCompleteTime(Date completeTime){
		this.mCompleteTime = completeTime;;
		this.changed = true;
		return this;
	}
	public void mergeCompleteTime(Date completeTime){
		setCompleteTime(completeTime);
	}
	
	
	public void setType(String type){
		this.mType = trimString(type);;
	}
	public String getType(){
		return this.mType;
	}
	public EmployeeEducation updateType(String type){
		this.mType = trimString(type);;
		this.changed = true;
		return this;
	}
	public void mergeType(String type){
		if(type != null) { setType(type);}
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public EmployeeEducation updateRemark(String remark){
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
	public EmployeeEducation updateVersion(int version){
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
		appendKeyValuePair(result, COMPLETE_TIME_PROPERTY, getCompleteTime());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeEducation){
		
		
			EmployeeEducation dest =(EmployeeEducation)baseDest;
		
			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setCompleteTime(getCompleteTime());
			dest.setType(getType());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeEducation){
		
			
			EmployeeEducation dest =(EmployeeEducation)baseDest;
		
			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeCompleteTime(getCompleteTime());
			dest.mergeType(getType());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeEducation){
		
			
			EmployeeEducation dest =(EmployeeEducation)baseDest;
		
			dest.mergeId(getId());
			dest.mergeCompleteTime(getCompleteTime());
			dest.mergeType(getType());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getCompleteTime(), getType(), getRemark(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeEducation{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tcompleteTime='"+getCompleteTime()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

