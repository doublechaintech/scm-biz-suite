
package com.doublechaintech.retailscm.employeeperformance;

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









@JsonSerialize(using = EmployeePerformanceSerializer.class)
public class EmployeePerformance extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String PERFORMANCE_COMMENT_PROPERTY   = "performanceComment";
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeePerformance";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getPerformanceComment();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		String              	mPerformanceComment ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EmployeePerformance(){
		// lazy load for all the properties
	}
	public 	static EmployeePerformance withId(String id){
		EmployeePerformance employeePerformance = new EmployeePerformance();
		employeePerformance.setId(id);
		employeePerformance.setVersion(Integer.MAX_VALUE);
		return employeePerformance;
	}
	public 	static EmployeePerformance refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			changePerformanceCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePerformanceCommentProperty(String newValueExpr){
	
		String oldValue = getPerformanceComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePerformanceComment(newValue);
		this.onChangeProperty(PERFORMANCE_COMMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(EMPLOYEE_PROPERTY.equals(property)){
			return getEmployee();
		}
		if(PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			return getPerformanceComment();
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
	public EmployeePerformance updateId(String id){
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
	public EmployeePerformance updateEmployee(Employee employee){
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
	
	public void setPerformanceComment(String performanceComment){
		this.mPerformanceComment = trimString(performanceComment);;
	}
	public String getPerformanceComment(){
		return this.mPerformanceComment;
	}
	public EmployeePerformance updatePerformanceComment(String performanceComment){
		this.mPerformanceComment = trimString(performanceComment);;
		this.changed = true;
		return this;
	}
	public void mergePerformanceComment(String performanceComment){
		if(performanceComment != null) { setPerformanceComment(performanceComment);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public EmployeePerformance updateVersion(int version){
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
		appendKeyValuePair(result, PERFORMANCE_COMMENT_PROPERTY, getPerformanceComment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeePerformance){
		
		
			EmployeePerformance dest =(EmployeePerformance)baseDest;
		
			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setPerformanceComment(getPerformanceComment());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeePerformance){
		
			
			EmployeePerformance dest =(EmployeePerformance)baseDest;
		
			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergePerformanceComment(getPerformanceComment());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeePerformance){
		
			
			EmployeePerformance dest =(EmployeePerformance)baseDest;
		
			dest.mergeId(getId());
			dest.mergePerformanceComment(getPerformanceComment());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getPerformanceComment(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeePerformance{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tperformanceComment='"+getPerformanceComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

