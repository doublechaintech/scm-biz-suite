
package com.doublechaintech.retailscm.provincecenterdepartment;

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
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;

@JsonSerialize(using = ProvinceCenterDepartmentSerializer.class)
public class ProvinceCenterDepartment extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String PROVINCE_CENTER_PROPERTY       = "provinceCenter"    ;
	public static final String MANAGER_PROPERTY               = "manager"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PROVINCE_CENTER_EMPLOYEE_LIST            = "provinceCenterEmployeeList";

	public static final String INTERNAL_TYPE="ProvinceCenterDepartment";
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
	protected		String              	mName               ;
	protected		Date                	mFounded            ;
	protected		RetailStoreProvinceCenter	mProvinceCenter     ;
	protected		String              	mManager            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ProvinceCenterEmployee>	mProvinceCenterEmployeeList;

	
		
	public 	ProvinceCenterDepartment(){
		// lazy load for all the properties
	}
	public 	static ProvinceCenterDepartment withId(String id){
		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		provinceCenterDepartment.setId(id);
		provinceCenterDepartment.setVersion(Integer.MAX_VALUE);
		return provinceCenterDepartment;
	}
	public 	static ProvinceCenterDepartment refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProvinceCenter( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
		}
		if(MANAGER_PROPERTY.equals(property)){
			changeManagerProperty(newValueExpr);
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
			
			
			
	protected void changeManagerProperty(String newValueExpr){
	
		String oldValue = getManager();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateManager(newValue);
		this.onChangeProperty(MANAGER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(PROVINCE_CENTER_PROPERTY.equals(property)){
			return getProvinceCenter();
		}
		if(MANAGER_PROPERTY.equals(property)){
			return getManager();
		}
		if(PROVINCE_CENTER_EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getProvinceCenterEmployeeList().stream().map(item->item).collect(Collectors.toList());
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
	public ProvinceCenterDepartment updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public ProvinceCenterDepartment updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public ProvinceCenterDepartment updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setProvinceCenter(RetailStoreProvinceCenter provinceCenter){
		this.mProvinceCenter = provinceCenter;;
	}
	public RetailStoreProvinceCenter getProvinceCenter(){
		return this.mProvinceCenter;
	}
	public ProvinceCenterDepartment updateProvinceCenter(RetailStoreProvinceCenter provinceCenter){
		this.mProvinceCenter = provinceCenter;;
		this.changed = true;
		return this;
	}
	public void mergeProvinceCenter(RetailStoreProvinceCenter provinceCenter){
		if(provinceCenter != null) { setProvinceCenter(provinceCenter);}
	}
	
	
	public void clearProvinceCenter(){
		setProvinceCenter ( null );
		this.changed = true;
	}
	
	public void setManager(String manager){
		this.mManager = trimString(manager);;
	}
	public String getManager(){
		return this.mManager;
	}
	public ProvinceCenterDepartment updateManager(String manager){
		this.mManager = trimString(manager);;
		this.changed = true;
		return this;
	}
	public void mergeManager(String manager){
		if(manager != null) { setManager(manager);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ProvinceCenterDepartment updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ProvinceCenterEmployee> getProvinceCenterEmployeeList(){
		if(this.mProvinceCenterEmployeeList == null){
			this.mProvinceCenterEmployeeList = new SmartList<ProvinceCenterEmployee>();
			this.mProvinceCenterEmployeeList.setListInternalName (PROVINCE_CENTER_EMPLOYEE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mProvinceCenterEmployeeList;	
	}
	public  void setProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setDepartment(this);
		}

		this.mProvinceCenterEmployeeList = provinceCenterEmployeeList;
		this.mProvinceCenterEmployeeList.setListInternalName (PROVINCE_CENTER_EMPLOYEE_LIST );
		
	}
	
	public  void addProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		provinceCenterEmployee.setDepartment(this);
		getProvinceCenterEmployeeList().add(provinceCenterEmployee);
	}
	public  void addProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setDepartment(this);
		}
		getProvinceCenterEmployeeList().addAll(provinceCenterEmployeeList);
	}
	public  void mergeProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		if(provinceCenterEmployeeList==null){
			return;
		}
		if(provinceCenterEmployeeList.isEmpty()){
			return;
		}
		addProvinceCenterEmployeeList( provinceCenterEmployeeList );
		
	}
	public  ProvinceCenterEmployee removeProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployeeIndex){
		
		int index = getProvinceCenterEmployeeList().indexOf(provinceCenterEmployeeIndex);
        if(index < 0){
        	String message = "ProvinceCenterEmployee("+provinceCenterEmployeeIndex.getId()+") with version='"+provinceCenterEmployeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ProvinceCenterEmployee provinceCenterEmployee = getProvinceCenterEmployeeList().get(index);        
        // provinceCenterEmployee.clearDepartment(); //disconnect with Department
        provinceCenterEmployee.clearFromAll(); //disconnect with Department
		
		boolean result = getProvinceCenterEmployeeList().planToRemove(provinceCenterEmployee);
        if(!result){
        	String message = "ProvinceCenterEmployee("+provinceCenterEmployeeIndex.getId()+") with version='"+provinceCenterEmployeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return provinceCenterEmployee;
        
	
	}
	//断舍离
	public  void breakWithProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		
		if(provinceCenterEmployee == null){
			return;
		}
		provinceCenterEmployee.setDepartment(null);
		//getProvinceCenterEmployeeList().remove();
	
	}
	
	public  boolean hasProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
	
		return getProvinceCenterEmployeeList().contains(provinceCenterEmployee);
  
	}
	
	public void copyProvinceCenterEmployeeFrom(ProvinceCenterEmployee provinceCenterEmployee) {

		ProvinceCenterEmployee provinceCenterEmployeeInList = findTheProvinceCenterEmployee(provinceCenterEmployee);
		ProvinceCenterEmployee newProvinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployeeInList.copyTo(newProvinceCenterEmployee);
		newProvinceCenterEmployee.setVersion(0);//will trigger copy
		getProvinceCenterEmployeeList().add(newProvinceCenterEmployee);
		addItemToFlexiableObject(COPIED_CHILD, newProvinceCenterEmployee);
	}
	
	public  ProvinceCenterEmployee findTheProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		
		int index =  getProvinceCenterEmployeeList().indexOf(provinceCenterEmployee);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ProvinceCenterEmployee("+provinceCenterEmployee.getId()+") with version='"+provinceCenterEmployee.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getProvinceCenterEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpProvinceCenterEmployeeList(){
		getProvinceCenterEmployeeList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProvinceCenter(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProvinceCenterEmployeeList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getProvinceCenterEmployeeList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, PROVINCE_CENTER_PROPERTY, getProvinceCenter());
		appendKeyValuePair(result, MANAGER_PROPERTY, getManager());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PROVINCE_CENTER_EMPLOYEE_LIST, getProvinceCenterEmployeeList());
		if(!getProvinceCenterEmployeeList().isEmpty()){
			appendKeyValuePair(result, "provinceCenterEmployeeCount", getProvinceCenterEmployeeList().getTotalCount());
			appendKeyValuePair(result, "provinceCenterEmployeeCurrentPageNumber", getProvinceCenterEmployeeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProvinceCenterDepartment){
		
		
			ProvinceCenterDepartment dest =(ProvinceCenterDepartment)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setFounded(getFounded());
			dest.setProvinceCenter(getProvinceCenter());
			dest.setManager(getManager());
			dest.setVersion(getVersion());
			dest.setProvinceCenterEmployeeList(getProvinceCenterEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProvinceCenterDepartment){
		
			
			ProvinceCenterDepartment dest =(ProvinceCenterDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeProvinceCenter(getProvinceCenter());
			dest.mergeManager(getManager());
			dest.mergeVersion(getVersion());
			dest.mergeProvinceCenterEmployeeList(getProvinceCenterEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProvinceCenterDepartment){
		
			
			ProvinceCenterDepartment dest =(ProvinceCenterDepartment)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeManager(getManager());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFounded(), getProvinceCenter(), getManager(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ProvinceCenterDepartment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getProvinceCenter() != null ){
 			stringBuilder.append("\tprovinceCenter='RetailStoreProvinceCenter("+getProvinceCenter().getId()+")';");
 		}
		stringBuilder.append("\tmanager='"+getManager()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

