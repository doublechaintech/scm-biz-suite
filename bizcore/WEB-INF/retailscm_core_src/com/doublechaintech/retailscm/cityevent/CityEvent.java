
package com.doublechaintech.retailscm.cityevent;

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
import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;









@JsonSerialize(using = CityEventSerializer.class)
public class CityEvent extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String CITY_SERVICE_CENTER_PROPERTY   = "cityServiceCenter" ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EVENT_ATTENDANCE_LIST                    = "eventAttendanceList";

	public static final String INTERNAL_TYPE="CityEvent";
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
	
	
	protected		SmartList<EventAttendance>	mEventAttendanceList;

	
		
	public 	CityEvent(){
		// lazy load for all the properties
	}
	public 	static CityEvent withId(String id){
		CityEvent cityEvent = new CityEvent();
		cityEvent.setId(id);
		cityEvent.setVersion(Integer.MAX_VALUE);
		return cityEvent;
	}
	public 	static CityEvent refById(String id){
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
		if(EVENT_ATTENDANCE_LIST.equals(property)){
			List<BaseEntity> list = getEventAttendanceList().stream().map(item->item).collect(Collectors.toList());
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
	public CityEvent updateId(String id){
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
	public CityEvent updateName(String name){
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
	public CityEvent updateMobile(String mobile){
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
	public CityEvent updateCityServiceCenter(RetailStoreCityServiceCenter cityServiceCenter){
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
	public CityEvent updateDescription(String description){
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
	public CityEvent updateLastUpdateTime(DateTime lastUpdateTime){
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
	public CityEvent updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<EventAttendance> getEventAttendanceList(){
		if(this.mEventAttendanceList == null){
			this.mEventAttendanceList = new SmartList<EventAttendance>();
			this.mEventAttendanceList.setListInternalName (EVENT_ATTENDANCE_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mEventAttendanceList;	
	}
	public  void setEventAttendanceList(SmartList<EventAttendance> eventAttendanceList){
		for( EventAttendance eventAttendance:eventAttendanceList){
			eventAttendance.setCityEvent(this);
		}

		this.mEventAttendanceList = eventAttendanceList;
		this.mEventAttendanceList.setListInternalName (EVENT_ATTENDANCE_LIST );
		
	}
	
	public  void addEventAttendance(EventAttendance eventAttendance){
		eventAttendance.setCityEvent(this);
		getEventAttendanceList().add(eventAttendance);
	}
	public  void addEventAttendanceList(SmartList<EventAttendance> eventAttendanceList){
		for( EventAttendance eventAttendance:eventAttendanceList){
			eventAttendance.setCityEvent(this);
		}
		getEventAttendanceList().addAll(eventAttendanceList);
	}
	public  void mergeEventAttendanceList(SmartList<EventAttendance> eventAttendanceList){
		if(eventAttendanceList==null){
			return;
		}
		if(eventAttendanceList.isEmpty()){
			return;
		}
		addEventAttendanceList( eventAttendanceList );
		
	}
	public  EventAttendance removeEventAttendance(EventAttendance eventAttendanceIndex){
		
		int index = getEventAttendanceList().indexOf(eventAttendanceIndex);
        if(index < 0){
        	String message = "EventAttendance("+eventAttendanceIndex.getId()+") with version='"+eventAttendanceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        EventAttendance eventAttendance = getEventAttendanceList().get(index);        
        // eventAttendance.clearCityEvent(); //disconnect with CityEvent
        eventAttendance.clearFromAll(); //disconnect with CityEvent
		
		boolean result = getEventAttendanceList().planToRemove(eventAttendance);
        if(!result){
        	String message = "EventAttendance("+eventAttendanceIndex.getId()+") with version='"+eventAttendanceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return eventAttendance;
        
	
	}
	//断舍离
	public  void breakWithEventAttendance(EventAttendance eventAttendance){
		
		if(eventAttendance == null){
			return;
		}
		eventAttendance.setCityEvent(null);
		//getEventAttendanceList().remove();
	
	}
	
	public  boolean hasEventAttendance(EventAttendance eventAttendance){
	
		return getEventAttendanceList().contains(eventAttendance);
  
	}
	
	public void copyEventAttendanceFrom(EventAttendance eventAttendance) {

		EventAttendance eventAttendanceInList = findTheEventAttendance(eventAttendance);
		EventAttendance newEventAttendance = new EventAttendance();
		eventAttendanceInList.copyTo(newEventAttendance);
		newEventAttendance.setVersion(0);//will trigger copy
		getEventAttendanceList().add(newEventAttendance);
		addItemToFlexiableObject(COPIED_CHILD, newEventAttendance);
	}
	
	public  EventAttendance findTheEventAttendance(EventAttendance eventAttendance){
		
		int index =  getEventAttendanceList().indexOf(eventAttendance);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "EventAttendance("+eventAttendance.getId()+") with version='"+eventAttendance.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getEventAttendanceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpEventAttendanceList(){
		getEventAttendanceList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCityServiceCenter(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEventAttendanceList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getEventAttendanceList());
			

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
		appendKeyValuePair(result, EVENT_ATTENDANCE_LIST, getEventAttendanceList());
		if(!getEventAttendanceList().isEmpty()){
			appendKeyValuePair(result, "eventAttendanceCount", getEventAttendanceList().getTotalCount());
			appendKeyValuePair(result, "eventAttendanceCurrentPageNumber", getEventAttendanceList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityEvent){
		
		
			CityEvent dest =(CityEvent)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMobile(getMobile());
			dest.setCityServiceCenter(getCityServiceCenter());
			dest.setDescription(getDescription());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setEventAttendanceList(getEventAttendanceList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityEvent){
		
			
			CityEvent dest =(CityEvent)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeCityServiceCenter(getCityServiceCenter());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeEventAttendanceList(getEventAttendanceList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof CityEvent){
		
			
			CityEvent dest =(CityEvent)baseDest;
		
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

		stringBuilder.append("CityEvent{");
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

