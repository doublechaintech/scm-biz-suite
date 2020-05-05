
package com.doublechaintech.retailscm.provincecenteremployee;

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
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

@JsonSerialize(using = ProvinceCenterEmployeeSerializer.class)
public class ProvinceCenterEmployee extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String PROVINCE_CENTER_PROPERTY       = "provinceCenter"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ProvinceCenterEmployee";
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
	protected		String              	mMobile             ;
	protected		String              	mEmail              ;
	protected		Date                	mFounded            ;
	protected		ProvinceCenterDepartment	mDepartment         ;
	protected		RetailStoreProvinceCenter	mProvinceCenter     ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	ProvinceCenterEmployee(){
		// lazy load for all the properties
	}
	public 	static ProvinceCenterEmployee withId(String id){
		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(Integer.MAX_VALUE);
		return provinceCenterEmployee;
	}
	public 	static ProvinceCenterEmployee refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDepartment( null );
		setProvinceCenter( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
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
			
			
			
	protected void changeMobileProperty(String newValueExpr){
	
		String oldValue = getMobile();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMobile(newValue);
		this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
	
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEmail(newValue);
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
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
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(MOBILE_PROPERTY.equals(property)){
			return getMobile();
		}
		if(EMAIL_PROPERTY.equals(property)){
			return getEmail();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(DEPARTMENT_PROPERTY.equals(property)){
			return getDepartment();
		}
		if(PROVINCE_CENTER_PROPERTY.equals(property)){
			return getProvinceCenter();
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
	public ProvinceCenterEmployee updateId(String id){
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
	public ProvinceCenterEmployee updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setMobile(String mobile){
		this.mMobile = trimString(mobile);;
	}
	public String getMobile(){
		return this.mMobile;
	}
	public ProvinceCenterEmployee updateMobile(String mobile){
		this.mMobile = trimString(mobile);;
		this.changed = true;
		return this;
	}
	public void mergeMobile(String mobile){
		if(mobile != null) { setMobile(mobile);}
	}
	
	
	
	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	public ProvinceCenterEmployee updateEmail(String email){
		this.mEmail = trimString(email);;
		this.changed = true;
		return this;
	}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}
	
	
	public void setFounded(Date founded){
		this.mFounded = founded;;
	}
	public Date getFounded(){
		return this.mFounded;
	}
	public ProvinceCenterEmployee updateFounded(Date founded){
		this.mFounded = founded;;
		this.changed = true;
		return this;
	}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}
	
	
	public void setDepartment(ProvinceCenterDepartment department){
		this.mDepartment = department;;
	}
	public ProvinceCenterDepartment getDepartment(){
		return this.mDepartment;
	}
	public ProvinceCenterEmployee updateDepartment(ProvinceCenterDepartment department){
		this.mDepartment = department;;
		this.changed = true;
		return this;
	}
	public void mergeDepartment(ProvinceCenterDepartment department){
		if(department != null) { setDepartment(department);}
	}
	
	
	public void clearDepartment(){
		setDepartment ( null );
		this.changed = true;
	}
	
	public void setProvinceCenter(RetailStoreProvinceCenter provinceCenter){
		this.mProvinceCenter = provinceCenter;;
	}
	public RetailStoreProvinceCenter getProvinceCenter(){
		return this.mProvinceCenter;
	}
	public ProvinceCenterEmployee updateProvinceCenter(RetailStoreProvinceCenter provinceCenter){
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
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ProvinceCenterEmployee updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDepartment(), internalType);
		addToEntityList(this, entityList, getProvinceCenter(), internalType);

		
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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, DEPARTMENT_PROPERTY, getDepartment());
		appendKeyValuePair(result, PROVINCE_CENTER_PROPERTY, getProvinceCenter());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProvinceCenterEmployee){
		
		
			ProvinceCenterEmployee dest =(ProvinceCenterEmployee)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMobile(getMobile());
			dest.setEmail(getEmail());
			dest.setFounded(getFounded());
			dest.setDepartment(getDepartment());
			dest.setProvinceCenter(getProvinceCenter());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProvinceCenterEmployee){
		
			
			ProvinceCenterEmployee dest =(ProvinceCenterEmployee)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergeFounded(getFounded());
			dest.mergeDepartment(getDepartment());
			dest.mergeProvinceCenter(getProvinceCenter());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ProvinceCenterEmployee){
		
			
			ProvinceCenterEmployee dest =(ProvinceCenterEmployee)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getMobile(), getEmail(), getFounded(), getDepartment(), getProvinceCenter(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ProvinceCenterEmployee{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='ProvinceCenterDepartment("+getDepartment().getId()+")';");
 		}
		if(getProvinceCenter() != null ){
 			stringBuilder.append("\tprovinceCenter='RetailStoreProvinceCenter("+getProvinceCenter().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

