
package com.doublechaintech.retailscm.leavetype;

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
import com.doublechaintech.retailscm.employeeleave.EmployeeLeave;

@JsonSerialize(using = LeaveTypeSerializer.class)
public class LeaveType extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LEAVE_LIST                      = "employeeLeaveList" ;

	public static final String INTERNAL_TYPE="LeaveType";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getCode();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCode               ;
	protected		RetailStoreCountryCenter	mCompany            ;
	protected		String              	mDescription        ;
	protected		String              	mDetailDescription  ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<EmployeeLeave>	mEmployeeLeaveList  ;
	
		
	public 	LeaveType(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );

		this.changed = true;
	}
	
	public 	LeaveType(String code, RetailStoreCountryCenter company, String description, String detailDescription)
	{
		setCode(code);
		setCompany(company);
		setDescription(description);
		setDetailDescription(detailDescription);

		this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			changeDetailDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCodeProperty(String newValueExpr){
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeDetailDescriptionProperty(String newValueExpr){
		String oldValue = getDetailDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDetailDescription(newValue);
		this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public LeaveType updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setCode(String code){
		this.mCode = trimString(code);;
	}
	public String getCode(){
		return this.mCode;
	}
	public LeaveType updateCode(String code){
		this.mCode = trimString(code);;
		this.changed = true;
		return this;
	}
	
	
	public void setCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
	}
	public RetailStoreCountryCenter getCompany(){
		return this.mCompany;
	}
	public LeaveType updateCompany(RetailStoreCountryCenter company){
		this.mCompany = company;;
		this.changed = true;
		return this;
	}
	
	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
	}
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public LeaveType updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	
	
	public void setDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
	}
	public String getDetailDescription(){
		return this.mDetailDescription;
	}
	public LeaveType updateDetailDescription(String detailDescription){
		this.mDetailDescription = trimString(detailDescription);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public LeaveType updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<EmployeeLeave> getEmployeeLeaveList(){
		if(this.mEmployeeLeaveList == null){
			this.mEmployeeLeaveList = new SmartList<EmployeeLeave>();
			this.mEmployeeLeaveList.setListInternalName (EMPLOYEE_LEAVE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEmployeeLeaveList;	
	}
	public  void setEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setType(this);
		}

		this.mEmployeeLeaveList = employeeLeaveList;
		this.mEmployeeLeaveList.setListInternalName (EMPLOYEE_LEAVE_LIST );
		
	}
	
	public  void addEmployeeLeave(EmployeeLeave employeeLeave){
		employeeLeave.setType(this);
		getEmployeeLeaveList().add(employeeLeave);
	}
	public  void addEmployeeLeaveList(SmartList<EmployeeLeave> employeeLeaveList){
		for( EmployeeLeave employeeLeave:employeeLeaveList){
			employeeLeave.setType(this);
		}
		getEmployeeLeaveList().addAll(employeeLeaveList);
	}
	
	public  EmployeeLeave removeEmployeeLeave(EmployeeLeave employeeLeaveIndex){
		
		int index = getEmployeeLeaveList().indexOf(employeeLeaveIndex);
        if(index < 0){
        	String message = "EmployeeLeave("+employeeLeaveIndex.getId()+") with version='"+employeeLeaveIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EmployeeLeave employeeLeave = getEmployeeLeaveList().get(index);        
        // employeeLeave.clearType(); //disconnect with Type
        employeeLeave.clearFromAll(); //disconnect with Type
		
		boolean result = getEmployeeLeaveList().planToRemove(employeeLeave);
        if(!result){
        	String message = "EmployeeLeave("+employeeLeaveIndex.getId()+") with version='"+employeeLeaveIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employeeLeave;
        
	
	}
	//断舍离
	public  void breakWithEmployeeLeave(EmployeeLeave employeeLeave){
		
		if(employeeLeave == null){
			return;
		}
		employeeLeave.setType(null);
		//getEmployeeLeaveList().remove();
	
	}
	
	public  boolean hasEmployeeLeave(EmployeeLeave employeeLeave){
	
		return getEmployeeLeaveList().contains(employeeLeave);
  
	}
	
	public void copyEmployeeLeaveFrom(EmployeeLeave employeeLeave) {

		EmployeeLeave employeeLeaveInList = findTheEmployeeLeave(employeeLeave);
		EmployeeLeave newEmployeeLeave = new EmployeeLeave();
		employeeLeaveInList.copyTo(newEmployeeLeave);
		newEmployeeLeave.setVersion(0);//will trigger copy
		getEmployeeLeaveList().add(newEmployeeLeave);
		addItemToFlexiableObject(COPIED_CHILD, newEmployeeLeave);
	}
	
	public  EmployeeLeave findTheEmployeeLeave(EmployeeLeave employeeLeave){
		
		int index =  getEmployeeLeaveList().indexOf(employeeLeave);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EmployeeLeave("+employeeLeave.getId()+") with version='"+employeeLeave.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEmployeeLeaveList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEmployeeLeaveList(){
		getEmployeeLeaveList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeLeaveList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEmployeeLeaveList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_LEAVE_LIST, getEmployeeLeaveList());
		if(!getEmployeeLeaveList().isEmpty()){
			appendKeyValuePair(result, "employeeLeaveCount", getEmployeeLeaveList().getTotalCount());
			appendKeyValuePair(result, "employeeLeaveCurrentPageNumber", getEmployeeLeaveList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof LeaveType){
		
		
			LeaveType dest =(LeaveType)baseDest;
		
			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setDescription(getDescription());
			dest.setDetailDescription(getDetailDescription());
			dest.setVersion(getVersion());
			dest.setEmployeeLeaveList(getEmployeeLeaveList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("LeaveType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tdetailDescription='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

