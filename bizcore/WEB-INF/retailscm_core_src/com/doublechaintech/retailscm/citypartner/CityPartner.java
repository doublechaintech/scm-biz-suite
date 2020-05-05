
package com.doublechaintech.retailscm.citypartner;

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
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

@JsonSerialize(using = CityPartnerSerializer.class)
public class CityPartner extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String CITY_SERVICE_CENTER_PROPERTY   = "cityServiceCenter" ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String POTENTIAL_CUSTOMER_LIST                  = "potentialCustomerList";
	public static final String POTENTIAL_CUSTOMER_CONTACT_LIST          = "potentialCustomerContactList";

	public static final String INTERNAL_TYPE="CityPartner";
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
	protected		RetailStoreCityServiceCenter	mCityServiceCenter  ;
	protected		String              	mDescription        ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<PotentialCustomer>	mPotentialCustomerList;
	protected		SmartList<PotentialCustomerContact>	mPotentialCustomerContactList;

	
		
	public 	CityPartner(){
		// lazy load for all the properties
	}
	public 	static CityPartner withId(String id){
		CityPartner cityPartner = new CityPartner();
		cityPartner.setId(id);
		cityPartner.setVersion(Integer.MAX_VALUE);
		return cityPartner;
	}
	public 	static CityPartner refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCityServiceCenter( null );

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
		if(MOBILE_PROPERTY.equals(property)){
			return getMobile();
		}
		if(CITY_SERVICE_CENTER_PROPERTY.equals(property)){
			return getCityServiceCenter();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(POTENTIAL_CUSTOMER_LIST.equals(property)){
			List<BaseEntity> list = getPotentialCustomerList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(POTENTIAL_CUSTOMER_CONTACT_LIST.equals(property)){
			List<BaseEntity> list = getPotentialCustomerContactList().stream().map(item->item).collect(Collectors.toList());
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
	public CityPartner updateId(String id){
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
	public CityPartner updateName(String name){
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
	public CityPartner updateMobile(String mobile){
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
	
		
	public void setCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		this.mCityServiceCenter = cityServiceCenter;;
	}
	public RetailStoreCityServiceCenter getCityServiceCenter(){
		return this.mCityServiceCenter;
	}
	public CityPartner updateCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		this.mCityServiceCenter = cityServiceCenter;;
		this.changed = true;
		return this;
	}
	public void mergeCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
		if(cityServiceCenter != null) { setCityServiceCenter(cityServiceCenter);}
	}
	
	
	public void clearCityServiceCenter(){
		setCityServiceCenter ( null );
		this.changed = true;
	}
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public CityPartner updateDescription(String description){
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
	public CityPartner updateLastUpdateTime(DateTime lastUpdateTime){
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
	public CityPartner updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<PotentialCustomer> getPotentialCustomerList(){
		if(this.mPotentialCustomerList == null){
			this.mPotentialCustomerList = new SmartList<PotentialCustomer>();
			this.mPotentialCustomerList.setListInternalName (POTENTIAL_CUSTOMER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPotentialCustomerList;	
	}
	public  void setPotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList){
		for( PotentialCustomer potentialCustomer:potentialCustomerList){
			potentialCustomer.setCityPartner(this);
		}

		this.mPotentialCustomerList = potentialCustomerList;
		this.mPotentialCustomerList.setListInternalName (POTENTIAL_CUSTOMER_LIST );
		
	}
	
	public  void addPotentialCustomer(PotentialCustomer potentialCustomer){
		potentialCustomer.setCityPartner(this);
		getPotentialCustomerList().add(potentialCustomer);
	}
	public  void addPotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList){
		for( PotentialCustomer potentialCustomer:potentialCustomerList){
			potentialCustomer.setCityPartner(this);
		}
		getPotentialCustomerList().addAll(potentialCustomerList);
	}
	public  void mergePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList){
		if(potentialCustomerList==null){
			return;
		}
		if(potentialCustomerList.isEmpty()){
			return;
		}
		addPotentialCustomerList( potentialCustomerList );
		
	}
	public  PotentialCustomer removePotentialCustomer(PotentialCustomer potentialCustomerIndex){
		
		int index = getPotentialCustomerList().indexOf(potentialCustomerIndex);
        if(index < 0){
        	String message = "PotentialCustomer("+potentialCustomerIndex.getId()+") with version='"+potentialCustomerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PotentialCustomer potentialCustomer = getPotentialCustomerList().get(index);        
        // potentialCustomer.clearCityPartner(); //disconnect with CityPartner
        potentialCustomer.clearFromAll(); //disconnect with CityPartner
		
		boolean result = getPotentialCustomerList().planToRemove(potentialCustomer);
        if(!result){
        	String message = "PotentialCustomer("+potentialCustomerIndex.getId()+") with version='"+potentialCustomerIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return potentialCustomer;
        
	
	}
	//断舍离
	public  void breakWithPotentialCustomer(PotentialCustomer potentialCustomer){
		
		if(potentialCustomer == null){
			return;
		}
		potentialCustomer.setCityPartner(null);
		//getPotentialCustomerList().remove();
	
	}
	
	public  boolean hasPotentialCustomer(PotentialCustomer potentialCustomer){
	
		return getPotentialCustomerList().contains(potentialCustomer);
  
	}
	
	public void copyPotentialCustomerFrom(PotentialCustomer potentialCustomer) {

		PotentialCustomer potentialCustomerInList = findThePotentialCustomer(potentialCustomer);
		PotentialCustomer newPotentialCustomer = new PotentialCustomer();
		potentialCustomerInList.copyTo(newPotentialCustomer);
		newPotentialCustomer.setVersion(0);//will trigger copy
		getPotentialCustomerList().add(newPotentialCustomer);
		addItemToFlexiableObject(COPIED_CHILD, newPotentialCustomer);
	}
	
	public  PotentialCustomer findThePotentialCustomer(PotentialCustomer potentialCustomer){
		
		int index =  getPotentialCustomerList().indexOf(potentialCustomer);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PotentialCustomer("+potentialCustomer.getId()+") with version='"+potentialCustomer.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPotentialCustomerList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPotentialCustomerList(){
		getPotentialCustomerList().clear();
	}
	
	
	


	public  SmartList<PotentialCustomerContact> getPotentialCustomerContactList(){
		if(this.mPotentialCustomerContactList == null){
			this.mPotentialCustomerContactList = new SmartList<PotentialCustomerContact>();
			this.mPotentialCustomerContactList.setListInternalName (POTENTIAL_CUSTOMER_CONTACT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mPotentialCustomerContactList;	
	}
	public  void setPotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setCityPartner(this);
		}

		this.mPotentialCustomerContactList = potentialCustomerContactList;
		this.mPotentialCustomerContactList.setListInternalName (POTENTIAL_CUSTOMER_CONTACT_LIST );
		
	}
	
	public  void addPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		potentialCustomerContact.setCityPartner(this);
		getPotentialCustomerContactList().add(potentialCustomerContact);
	}
	public  void addPotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setCityPartner(this);
		}
		getPotentialCustomerContactList().addAll(potentialCustomerContactList);
	}
	public  void mergePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		if(potentialCustomerContactList==null){
			return;
		}
		if(potentialCustomerContactList.isEmpty()){
			return;
		}
		addPotentialCustomerContactList( potentialCustomerContactList );
		
	}
	public  PotentialCustomerContact removePotentialCustomerContact(PotentialCustomerContact potentialCustomerContactIndex){
		
		int index = getPotentialCustomerContactList().indexOf(potentialCustomerContactIndex);
        if(index < 0){
        	String message = "PotentialCustomerContact("+potentialCustomerContactIndex.getId()+") with version='"+potentialCustomerContactIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        PotentialCustomerContact potentialCustomerContact = getPotentialCustomerContactList().get(index);        
        // potentialCustomerContact.clearCityPartner(); //disconnect with CityPartner
        potentialCustomerContact.clearFromAll(); //disconnect with CityPartner
		
		boolean result = getPotentialCustomerContactList().planToRemove(potentialCustomerContact);
        if(!result){
        	String message = "PotentialCustomerContact("+potentialCustomerContactIndex.getId()+") with version='"+potentialCustomerContactIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return potentialCustomerContact;
        
	
	}
	//断舍离
	public  void breakWithPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		
		if(potentialCustomerContact == null){
			return;
		}
		potentialCustomerContact.setCityPartner(null);
		//getPotentialCustomerContactList().remove();
	
	}
	
	public  boolean hasPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
	
		return getPotentialCustomerContactList().contains(potentialCustomerContact);
  
	}
	
	public void copyPotentialCustomerContactFrom(PotentialCustomerContact potentialCustomerContact) {

		PotentialCustomerContact potentialCustomerContactInList = findThePotentialCustomerContact(potentialCustomerContact);
		PotentialCustomerContact newPotentialCustomerContact = new PotentialCustomerContact();
		potentialCustomerContactInList.copyTo(newPotentialCustomerContact);
		newPotentialCustomerContact.setVersion(0);//will trigger copy
		getPotentialCustomerContactList().add(newPotentialCustomerContact);
		addItemToFlexiableObject(COPIED_CHILD, newPotentialCustomerContact);
	}
	
	public  PotentialCustomerContact findThePotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		
		int index =  getPotentialCustomerContactList().indexOf(potentialCustomerContact);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "PotentialCustomerContact("+potentialCustomerContact.getId()+") with version='"+potentialCustomerContact.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getPotentialCustomerContactList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpPotentialCustomerContactList(){
		getPotentialCustomerContactList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCityServiceCenter(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getPotentialCustomerList(), internalType);
		collectFromList(this, entityList, getPotentialCustomerContactList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getPotentialCustomerList());
		listOfList.add( getPotentialCustomerContactList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, CITY_SERVICE_CENTER_PROPERTY, getCityServiceCenter());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, POTENTIAL_CUSTOMER_LIST, getPotentialCustomerList());
		if(!getPotentialCustomerList().isEmpty()){
			appendKeyValuePair(result, "potentialCustomerCount", getPotentialCustomerList().getTotalCount());
			appendKeyValuePair(result, "potentialCustomerCurrentPageNumber", getPotentialCustomerList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, POTENTIAL_CUSTOMER_CONTACT_LIST, getPotentialCustomerContactList());
		if(!getPotentialCustomerContactList().isEmpty()){
			appendKeyValuePair(result, "potentialCustomerContactCount", getPotentialCustomerContactList().getTotalCount());
			appendKeyValuePair(result, "potentialCustomerContactCurrentPageNumber", getPotentialCustomerContactList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityPartner){
		
		
			CityPartner dest =(CityPartner)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMobile(getMobile());
			dest.setCityServiceCenter(getCityServiceCenter());
			dest.setDescription(getDescription());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setPotentialCustomerList(getPotentialCustomerList());
			dest.setPotentialCustomerContactList(getPotentialCustomerContactList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityPartner){
		
			
			CityPartner dest =(CityPartner)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeCityServiceCenter(getCityServiceCenter());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergePotentialCustomerList(getPotentialCustomerList());
			dest.mergePotentialCustomerContactList(getPotentialCustomerContactList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityPartner){
		
			
			CityPartner dest =(CityPartner)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getMobile(), getCityServiceCenter(), getDescription(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("CityPartner{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		if(getCityServiceCenter() != null ){
 			stringBuilder.append("\tcityServiceCenter='RetailStoreCityServiceCenter("+getCityServiceCenter().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

