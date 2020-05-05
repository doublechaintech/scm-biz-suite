
package com.doublechaintech.retailscm.employeeattendance;

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
import com.doublechaintech.retailscm.employee.Employee;

@JsonSerialize(using = EmployeeAttendanceSerializer.class)
public class EmployeeAttendance extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String ENTER_TIME_PROPERTY            = "enterTime"         ;
	public static final String LEAVE_TIME_PROPERTY            = "leaveTime"         ;
	public static final String DURATION_HOURS_PROPERTY        = "durationHours"     ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeAttendance";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getRemark();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		Employee            	mEmployee           ;
	protected		Date                	mEnterTime          ;
	protected		Date                	mLeaveTime          ;
	protected		int                 	mDurationHours      ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EmployeeAttendance(){
		// lazy load for all the properties
	}
	public 	static EmployeeAttendance withId(String id){
		EmployeeAttendance employeeAttendance = new EmployeeAttendance();
		employeeAttendance.setId(id);
		employeeAttendance.setVersion(Integer.MAX_VALUE);
		return employeeAttendance;
	}
	public 	static EmployeeAttendance refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(ENTER_TIME_PROPERTY.equals(property)){
			changeEnterTimeProperty(newValueExpr);
		}
		if(LEAVE_TIME_PROPERTY.equals(property)){
			changeLeaveTimeProperty(newValueExpr);
		}
		if(DURATION_HOURS_PROPERTY.equals(property)){
			changeDurationHoursProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeEnterTimeProperty(String newValueExpr){
	
		Date oldValue = getEnterTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEnterTime(newValue);
		this.onChangeProperty(ENTER_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLeaveTimeProperty(String newValueExpr){
	
		Date oldValue = getLeaveTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLeaveTime(newValue);
		this.onChangeProperty(LEAVE_TIME_PROPERTY, oldValue, newValue);
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
		if(ENTER_TIME_PROPERTY.equals(property)){
			return getEnterTime();
		}
		if(LEAVE_TIME_PROPERTY.equals(property)){
			return getLeaveTime();
		}
		if(DURATION_HOURS_PROPERTY.equals(property)){
			return getDurationHours();
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
	public EmployeeAttendance updateId(String id){
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
	public EmployeeAttendance updateEmployee(Employee employee){
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
	
	public void setEnterTime(Date enterTime){
		this.mEnterTime = enterTime;;
	}
	public Date getEnterTime(){
		return this.mEnterTime;
	}
	public EmployeeAttendance updateEnterTime(Date enterTime){
		this.mEnterTime = enterTime;;
		this.changed = true;
		return this;
	}
	public void mergeEnterTime(Date enterTime){
		setEnterTime(enterTime);
	}
	
	
	public void setLeaveTime(Date leaveTime){
		this.mLeaveTime = leaveTime;;
	}
	public Date getLeaveTime(){
		return this.mLeaveTime;
	}
	public EmployeeAttendance updateLeaveTime(Date leaveTime){
		this.mLeaveTime = leaveTime;;
		this.changed = true;
		return this;
	}
	public void mergeLeaveTime(Date leaveTime){
		setLeaveTime(leaveTime);
	}
	
	
	public void setDurationHours(int durationHours){
		this.mDurationHours = durationHours;;
	}
	public int getDurationHours(){
		return this.mDurationHours;
	}
	public EmployeeAttendance updateDurationHours(int durationHours){
		this.mDurationHours = durationHours;;
		this.changed = true;
		return this;
	}
	public void mergeDurationHours(int durationHours){
		setDurationHours(durationHours);
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public EmployeeAttendance updateRemark(String remark){
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
	public EmployeeAttendance updateVersion(int version){
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
		appendKeyValuePair(result, ENTER_TIME_PROPERTY, getEnterTime());
		appendKeyValuePair(result, LEAVE_TIME_PROPERTY, getLeaveTime());
		appendKeyValuePair(result, DURATION_HOURS_PROPERTY, getDurationHours());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeAttendance){
		
		
			EmployeeAttendance dest =(EmployeeAttendance)baseDest;
		
			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setEnterTime(getEnterTime());
			dest.setLeaveTime(getLeaveTime());
			dest.setDurationHours(getDurationHours());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeAttendance){
		
			
			EmployeeAttendance dest =(EmployeeAttendance)baseDest;
		
			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeEnterTime(getEnterTime());
			dest.mergeLeaveTime(getLeaveTime());
			dest.mergeDurationHours(getDurationHours());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeAttendance){
		
			
			EmployeeAttendance dest =(EmployeeAttendance)baseDest;
		
			dest.mergeId(getId());
			dest.mergeEnterTime(getEnterTime());
			dest.mergeLeaveTime(getLeaveTime());
			dest.mergeDurationHours(getDurationHours());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getEnterTime(), getLeaveTime(), getDurationHours(), getRemark(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeAttendance{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tenterTime='"+getEnterTime()+"';");
		stringBuilder.append("\tleaveTime='"+getLeaveTime()+"';");
		stringBuilder.append("\tdurationHours='"+getDurationHours()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
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

