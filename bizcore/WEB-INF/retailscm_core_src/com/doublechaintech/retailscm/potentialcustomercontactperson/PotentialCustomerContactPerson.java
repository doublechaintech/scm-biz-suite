
package com.doublechaintech.retailscm.potentialcustomercontactperson;

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

@JsonSerialize(using = PotentialCustomerContactPersonSerializer.class)
public class PotentialCustomerContactPerson extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String POTENTIAL_CUSTOMER_PROPERTY    = "potentialCustomer" ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String POTENTIAL_CUSTOMER_CONTACT_LIST          = "potentialCustomerContactList";

	public static final String INTERNAL_TYPE="PotentialCustomerContactPerson";
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
	protected		PotentialCustomer   	mPotentialCustomer  ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<PotentialCustomerContact>	mPotentialCustomerContactList;

	
		
	public 	PotentialCustomerContactPerson(){
		// lazy load for all the properties
	}
	public 	static PotentialCustomerContactPerson withId(String id){
		PotentialCustomerContactPerson potentialCustomerContactPerson = new PotentialCustomerContactPerson();
		potentialCustomerContactPerson.setId(id);
		potentialCustomerContactPerson.setVersion(Integer.MAX_VALUE);
		return potentialCustomerContactPerson;
	}
	public 	static PotentialCustomerContactPerson refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPotentialCustomer( null );

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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(MOBILE_PROPERTY.equals(property)){
			return getMobile();
		}
		if(POTENTIAL_CUSTOMER_PROPERTY.equals(property)){
			return getPotentialCustomer();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
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
	public PotentialCustomerContactPerson updateId(String id){
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
	public PotentialCustomerContactPerson updateName(String name){
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
	public PotentialCustomerContactPerson updateMobile(String mobile){
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
	
		
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){
		this.mPotentialCustomer = potentialCustomer;;
	}
	public PotentialCustomer getPotentialCustomer(){
		return this.mPotentialCustomer;
	}
	public PotentialCustomerContactPerson updatePotentialCustomer(PotentialCustomer potentialCustomer){
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
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public PotentialCustomerContactPerson updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public PotentialCustomerContactPerson updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
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
			potentialCustomerContact.setContactTo(this);
		}

		this.mPotentialCustomerContactList = potentialCustomerContactList;
		this.mPotentialCustomerContactList.setListInternalName (POTENTIAL_CUSTOMER_CONTACT_LIST );
		
	}
	
	public  void addPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		potentialCustomerContact.setContactTo(this);
		getPotentialCustomerContactList().add(potentialCustomerContact);
	}
	public  void addPotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setContactTo(this);
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
        // potentialCustomerContact.clearContactTo(); //disconnect with ContactTo
        potentialCustomerContact.clearFromAll(); //disconnect with ContactTo
		
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
		potentialCustomerContact.setContactTo(null);
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

		addToEntityList(this, entityList, getPotentialCustomer(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getPotentialCustomerContactList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getPotentialCustomerContactList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomer());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof PotentialCustomerContactPerson){
		
		
			PotentialCustomerContactPerson dest =(PotentialCustomerContactPerson)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMobile(getMobile());
			dest.setPotentialCustomer(getPotentialCustomer());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setPotentialCustomerContactList(getPotentialCustomerContactList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PotentialCustomerContactPerson){
		
			
			PotentialCustomerContactPerson dest =(PotentialCustomerContactPerson)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergePotentialCustomer(getPotentialCustomer());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());
			dest.mergePotentialCustomerContactList(getPotentialCustomerContactList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof PotentialCustomerContactPerson){
		
			
			PotentialCustomerContactPerson dest =(PotentialCustomerContactPerson)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getMobile(), getPotentialCustomer(), getDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("PotentialCustomerContactPerson{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		if(getPotentialCustomer() != null ){
 			stringBuilder.append("\tpotentialCustomer='PotentialCustomer("+getPotentialCustomer().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

