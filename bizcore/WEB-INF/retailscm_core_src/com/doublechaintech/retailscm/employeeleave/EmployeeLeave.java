
package com.doublechaintech.retailscm.employeeleave;

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
import com.doublechaintech.retailscm.leavetype.LeaveType;









@JsonSerialize(using = EmployeeLeaveSerializer.class)
public class EmployeeLeave extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String WHO_PROPERTY                   = "who"               ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String LEAVE_DURATION_HOUR_PROPERTY   = "leaveDurationHour" ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeLeave";
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
	protected		Employee            	mWho                ;
	protected		LeaveType           	mType               ;
	protected		int                 	mLeaveDurationHour  ;
	protected		String              	mRemark             ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EmployeeLeave(){
		// lazy load for all the properties
	}
	public 	static EmployeeLeave withId(String id){
		EmployeeLeave employeeLeave = new EmployeeLeave();
		employeeLeave.setId(id);
		employeeLeave.setVersion(Integer.MAX_VALUE);
		return employeeLeave;
	}
	public 	static EmployeeLeave refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setWho( null );
		setType( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			changeLeaveDurationHourProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLeaveDurationHourProperty(String newValueExpr){
	
		int oldValue = getLeaveDurationHour();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLeaveDurationHour(newValue);
		this.onChangeProperty(LEAVE_DURATION_HOUR_PROPERTY, oldValue, newValue);
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
     	
		if(WHO_PROPERTY.equals(property)){
			return getWho();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
		}
		if(LEAVE_DURATION_HOUR_PROPERTY.equals(property)){
			return getLeaveDurationHour();
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
	public EmployeeLeave updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setWho(Employee who){
		this.mWho = who;;
	}
	public Employee getWho(){
		return this.mWho;
	}
	public EmployeeLeave updateWho(Employee who){
		this.mWho = who;;
		this.changed = true;
		return this;
	}
	public void mergeWho(Employee who){
		if(who != null) { setWho(who);}
	}
	
	
	public void clearWho(){
		setWho ( null );
		this.changed = true;
	}
	
	public void setType(LeaveType type){
		this.mType = type;;
	}
	public LeaveType getType(){
		return this.mType;
	}
	public EmployeeLeave updateType(LeaveType type){
		this.mType = type;;
		this.changed = true;
		return this;
	}
	public void mergeType(LeaveType type){
		if(type != null) { setType(type);}
	}
	
	
	public void clearType(){
		setType ( null );
		this.changed = true;
	}
	
	public void setLeaveDurationHour(int leaveDurationHour){
		this.mLeaveDurationHour = leaveDurationHour;;
	}
	public int getLeaveDurationHour(){
		return this.mLeaveDurationHour;
	}
	public EmployeeLeave updateLeaveDurationHour(int leaveDurationHour){
		this.mLeaveDurationHour = leaveDurationHour;;
		this.changed = true;
		return this;
	}
	public void mergeLeaveDurationHour(int leaveDurationHour){
		setLeaveDurationHour(leaveDurationHour);
	}
	
	
	public void setRemark(String remark){
		this.mRemark = trimString(remark);;
	}
	public String getRemark(){
		return this.mRemark;
	}
	public EmployeeLeave updateRemark(String remark){
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
	public EmployeeLeave updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getWho(), internalType);
		addToEntityList(this, entityList, getType(), internalType);

		
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
		appendKeyValuePair(result, WHO_PROPERTY, getWho());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, LEAVE_DURATION_HOUR_PROPERTY, getLeaveDurationHour());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeLeave){
		
		
			EmployeeLeave dest =(EmployeeLeave)baseDest;
		
			dest.setId(getId());
			dest.setWho(getWho());
			dest.setType(getType());
			dest.setLeaveDurationHour(getLeaveDurationHour());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeLeave){
		
			
			EmployeeLeave dest =(EmployeeLeave)baseDest;
		
			dest.mergeId(getId());
			dest.mergeWho(getWho());
			dest.mergeType(getType());
			dest.mergeLeaveDurationHour(getLeaveDurationHour());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EmployeeLeave){
		
			
			EmployeeLeave dest =(EmployeeLeave)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLeaveDurationHour(getLeaveDurationHour());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getWho(), getType(), getLeaveDurationHour(), getRemark(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeLeave{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getWho() != null ){
 			stringBuilder.append("\twho='Employee("+getWho().getId()+")';");
 		}
		if(getType() != null ){
 			stringBuilder.append("\ttype='LeaveType("+getType().getId()+")';");
 		}
		stringBuilder.append("\tleaveDurationHour='"+getLeaveDurationHour()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseLeaveDurationHour(int incLeaveDurationHour){
		updateLeaveDurationHour(this.mLeaveDurationHour +  incLeaveDurationHour);
	}
	public void decreaseLeaveDurationHour(int decLeaveDurationHour){
		updateLeaveDurationHour(this.mLeaveDurationHour - decLeaveDurationHour);
	}
	

}

