
package com.doublechaintech.retailscm.eventattendance;

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
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;

@JsonSerialize(using = EventAttendanceSerializer.class)
public class EventAttendance extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String POTENTIAL_CUSTOMER_PROPERTY    = "potentialCustomer" ;
	public static final String CITY_EVENT_PROPERTY            = "cityEvent"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EventAttendance";
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
	protected		PotentialCustomer   	mPotentialCustomer  ;
	protected		CityEvent           	mCityEvent          ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	EventAttendance(){
		// lazy load for all the properties
	}
	public 	static EventAttendance withId(String id){
		EventAttendance eventAttendance = new EventAttendance();
		eventAttendance.setId(id);
		eventAttendance.setVersion(Integer.MAX_VALUE);
		return eventAttendance;
	}
	public 	static EventAttendance refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPotentialCustomer( null );
		setCityEvent( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
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
		if(POTENTIAL_CUSTOMER_PROPERTY.equals(property)){
			return getPotentialCustomer();
		}
		if(CITY_EVENT_PROPERTY.equals(property)){
			return getCityEvent();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
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
	public EventAttendance updateId(String id){
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
	public EventAttendance updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){
		this.mPotentialCustomer = potentialCustomer;;
	}
	public PotentialCustomer getPotentialCustomer(){
		return this.mPotentialCustomer;
	}
	public EventAttendance updatePotentialCustomer(PotentialCustomer potentialCustomer){
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
	
	public void setCityEvent(CityEvent cityEvent){
		this.mCityEvent = cityEvent;;
	}
	public CityEvent getCityEvent(){
		return this.mCityEvent;
	}
	public EventAttendance updateCityEvent(CityEvent cityEvent){
		this.mCityEvent = cityEvent;;
		this.changed = true;
		return this;
	}
	public void mergeCityEvent(CityEvent cityEvent){
		if(cityEvent != null) { setCityEvent(cityEvent);}
	}
	
	
	public void clearCityEvent(){
		setCityEvent ( null );
		this.changed = true;
	}
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public EventAttendance updateDescription(String description){
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
	public EventAttendance updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getPotentialCustomer(), internalType);
		addToEntityList(this, entityList, getCityEvent(), internalType);

		
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
		appendKeyValuePair(result, POTENTIAL_CUSTOMER_PROPERTY, getPotentialCustomer());
		appendKeyValuePair(result, CITY_EVENT_PROPERTY, getCityEvent());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EventAttendance){
		
		
			EventAttendance dest =(EventAttendance)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setPotentialCustomer(getPotentialCustomer());
			dest.setCityEvent(getCityEvent());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EventAttendance){
		
			
			EventAttendance dest =(EventAttendance)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergePotentialCustomer(getPotentialCustomer());
			dest.mergeCityEvent(getCityEvent());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof EventAttendance){
		
			
			EventAttendance dest =(EventAttendance)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getPotentialCustomer(), getCityEvent(), getDescription(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EventAttendance{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		if(getPotentialCustomer() != null ){
 			stringBuilder.append("\tpotentialCustomer='PotentialCustomer("+getPotentialCustomer().getId()+")';");
 		}
		if(getCityEvent() != null ){
 			stringBuilder.append("\tcityEvent='CityEvent("+getCityEvent().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

