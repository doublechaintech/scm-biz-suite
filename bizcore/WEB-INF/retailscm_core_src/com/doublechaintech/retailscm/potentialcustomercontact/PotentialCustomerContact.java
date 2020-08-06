
package com.doublechaintech.retailscm.potentialcustomercontact;

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
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;









@JsonSerialize(using = PotentialCustomerContactSerializer.class)
public class PotentialCustomerContact extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String CONTACT_DATE_PROPERTY          = "contactDate"       ;
	public static final String CONTACT_METHOD_PROPERTY        = "contactMethod"     ;
	public static final String POTENTIAL_CUSTOMER_PROPERTY    = "potentialCustomer" ;
	public static final String CITY_PARTNER_PROPERTY          = "cityPartner"       ;
	public static final String CONTACT_TO_PROPERTY            = "contactTo"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="PotentialCustomerContact";
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
	protected		Date                	mContactDate        ;
	protected		String              	mContactMethod      ;
	protected		PotentialCustomer   	mPotentialCustomer  ;
	protected		CityPartner         	mCityPartner        ;
	protected		PotentialCustomerContactPerson	mContactTo          ;
	protected		String              	mDescription        ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	PotentialCustomerContact(){
		// lazy load for all the properties
	}
	public 	static PotentialCustomerContact withId(String id){
		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		potentialCustomerContact.setId(id);
		potentialCustomerContact.setVersion(Integer.MAX_VALUE);
		return potentialCustomerContact;
	}
	public 	static PotentialCustomerContact refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPotentialCustomer( null );
		setCityPartner( null );
		setContactTo( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(CONTACT_DATE_PROPERTY.equals(property)){
			changeContactDateProperty(newValueExpr);
		}
		if(CONTACT_METHOD_PROPERTY.equals(property)){
			changeContactMethodProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeContactDateProperty(String newValueExpr){
	
		Date oldValue = getContactDate();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactDate(newValue);
		this.onChangeProperty(CONTACT_DATE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeContactMethodProperty(String newValueExpr){
	
		String oldValue = getContactMethod();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactMethod(newValue);
		this.onChangeProperty(CONTACT_METHOD_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(CONTACT_DATE_PROPERTY.equals(property)){
			return getContactDate();
		}
		if(CONTACT_METHOD_PROPERTY.equals(property)){
			return getContactMethod();
		}
		if(POTENTIAL_CUSTOMER_PROPERTY.equals(property)){
			return getPotentialCustomer();
		}
		if(CITY_PARTNER_PROPERTY.equals(property)){
			return getCityPartner();
		}
		if(CONTACT_TO_PROPERTY.equals(property)){
			return getContactTo();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
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
	public PotentialCustomerContact updateId(String id){
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
	public PotentialCustomerContact updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setContactDate(Date contactDate){
		this.mContactDate = contactDate;;
	}
	public Date getContactDate(){
		return this.mContactDate;
	}
	public PotentialCustomerContact updateContactDate(Date contactDate){
		this.mContactDate = contactDate;;
		this.changed = true;
		return this;
	}
	public void mergeContactDate(Date contactDate){
		setContactDate(contactDate);
	}
	
	
	public void setContactMethod(String contactMethod){
		this.mContactMethod = trimString(contactMethod);;
	}
	public String getContactMethod(){
		return this.mContactMethod;
	}
	public PotentialCustomerContact updateContactMethod(String contactMethod){
		this.mContactMethod = trimString(contactMethod);;
		this.changed = true;
		return this;
	}
	public void mergeContactMethod(String contactMethod){
		if(contactMethod != null) { setContactMethod(contactMethod);}
	}
	
	
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){
		this.mPotentialCustomer = potentialCustomer;;
	}
	public PotentialCustomer getPotentialCustomer(){
		return this.mPotentialCustomer;
	}
	public PotentialCustomerContact updatePotentialCustomer(PotentialCustomer potentialCustomer){
		this.mPotentialCustomer = potentialCustomer;;
		this.changed = true;
		return this;
	}
	public void mergePotentialCustomer(PotentialCustomer potentialCustomer){
		if(potentialCustomer != null) { setPotentialCustomer(potentialCustomer);}
	}
	
	
	public void clearPotentialCustomer(){
		setPotentialCustomer ( null );
		this.changed = true;
	}
	
	public void setCityPartner(CityPartner cityPartner){
		this.mCityPartner = cityPartner;;
	}
	public CityPartner getCityPartner(){
		return this.mCityPartner;
	}
	public PotentialCustomerContact updateCityPartner(CityPartner cityPartner){
		this.mCityPartner = cityPartner;;
		this.changed = true;
		return this;
	}
	public void mergeCityPartner(CityPartner cityPartner){
		if(cityPartner != null) { setCityPartner(cityPartner);}
	}
	
	
	public void clearCityPartner(){
		setCityPartner ( null );
		this.changed = true;
	}
	
	public void setContactTo(PotentialCustomerContactPerson contactTo){
		this.mContactTo = contactTo;;
	}
	public PotentialCustomerContactPerson getContactTo(){
		return this.mContactTo;
	}
	public PotentialCustomerContact updateContactTo(PotentialCustomerContactPerson contactTo){
		this.mContactTo = contactTo;;
		this.changed = true;
		return this;
	}
	public void mergeContactTo(PotentialCustomerContactPerson contactTo){
		if(contactTo != null) { setContactTo(contactTo);}
	}
	
	
	public void clearContactTo(){
		setContactTo ( null );
		this.changed = true;
	}
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public PotentialCustomerContact updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public PotentialCustomerContact updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PotentialCustomerContact updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPotentialCustomer(), internalType);
		addToEntityList(this, entityList, getCityPartner(), internalType);
		addToEntityList(this, entityList, getContactTo(), internalType);

		
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
		appendKeyValuePair(result, CONTACT_DATE_PROPERTY, getContactDate());
		appendKeyValuePair(result, CONTACT_METHOD_PROPERTY, getContactMethod());
		appendKeyValuePair(result, POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomer());
		appendKeyValuePair(result, CITY_PARTNER_PROPERTY, getCityPartner());
		appendKeyValuePair(result, CONTACT_TO_PROPERTY, getContactTo());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PotentialCustomerContact){
		
		
			PotentialCustomerContact dest =(PotentialCustomerContact)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setContactDate(getContactDate());
			dest.setContactMethod(getContactMethod());
			dest.setPotentialCustomer(getPotentialCustomer());
			dest.setCityPartner(getCityPartner());
			dest.setContactTo(getContactTo());
			dest.setDescription(getDescription());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PotentialCustomerContact){
		
			
			PotentialCustomerContact dest =(PotentialCustomerContact)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeContactDate(getContactDate());
			dest.mergeContactMethod(getContactMethod());
			dest.mergePotentialCustomer(getPotentialCustomer());
			dest.mergeCityPartner(getCityPartner());
			dest.mergeContactTo(getContactTo());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PotentialCustomerContact){
		
			
			PotentialCustomerContact dest =(PotentialCustomerContact)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeContactDate(getContactDate());
			dest.mergeContactMethod(getContactMethod());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getContactDate(), getContactMethod(), getPotentialCustomer(), getCityPartner(), getContactTo(), getDescription(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PotentialCustomerContact{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tcontactDate='"+getContactDate()+"';");
		stringBuilder.append("\tcontactMethod='"+getContactMethod()+"';");
		if(getPotentialCustomer() != null ){
 			stringBuilder.append("\tpotentialCustomer='PotentialCustomer("+getPotentialCustomer().getId()+")';");
 		}
		if(getCityPartner() != null ){
 			stringBuilder.append("\tcityPartner='CityPartner("+getCityPartner().getId()+")';");
 		}
		if(getContactTo() != null ){
 			stringBuilder.append("\tcontactTo='PotentialCustomerContactPerson("+getContactTo().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

