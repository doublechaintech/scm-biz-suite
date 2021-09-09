
package com.doublechaintech.retailscm.eventattendance;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(POTENTIAL_CUSTOMER_PROPERTY, "potential_customer", "潜在的客户")
        .withType("potential_customer", PotentialCustomer.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CITY_EVENT_PROPERTY, "city_event", "城市活动")
        .withType("city_event", CityEvent.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,POTENTIAL_CUSTOMER_PROPERTY ,CITY_EVENT_PROPERTY ,DESCRIPTION_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomer.class);
parents.put(CITY_EVENT_PROPERTY, CityEvent.class);

    return parents;
  }

  public EventAttendance want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EventAttendance wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	name                ;
	protected		PotentialCustomer   	potentialCustomer   ;
	protected		CityEvent           	cityEvent           ;
	protected		String              	description         ;
	protected		int                 	version             ;

	



	public 	EventAttendance(){
		// lazy load for all the properties
	}
	public 	static EventAttendance withId(String id){
		EventAttendance eventAttendance = new EventAttendance();
		eventAttendance.setId(id);
		eventAttendance.setVersion(Integer.MAX_VALUE);
		eventAttendance.setChecked(true);
		return eventAttendance;
	}
	public 	static EventAttendance refById(String id){
		return withId(id);
	}

  public EventAttendance limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public EventAttendance limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static EventAttendance searchExample(){
    EventAttendance eventAttendance = new EventAttendance();
    		eventAttendance.setVersion(UNSET_INT);

    return eventAttendance;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPotentialCustomer( null );
		setCityEvent( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public EventAttendance updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public EventAttendance orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public EventAttendance ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public EventAttendance addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public EventAttendance updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public EventAttendance orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public EventAttendance ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public EventAttendance addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){PotentialCustomer oldPotentialCustomer = this.potentialCustomer;PotentialCustomer newPotentialCustomer = potentialCustomer;this.potentialCustomer = newPotentialCustomer;}
	public PotentialCustomer potentialCustomer(){
doLoad();
return getPotentialCustomer();
}
	public PotentialCustomer getPotentialCustomer(){
		return this.potentialCustomer;
	}
	public EventAttendance updatePotentialCustomer(PotentialCustomer potentialCustomer){PotentialCustomer oldPotentialCustomer = this.potentialCustomer;PotentialCustomer newPotentialCustomer = potentialCustomer;if(!shouldReplaceBy(newPotentialCustomer, oldPotentialCustomer)){return this;}this.potentialCustomer = newPotentialCustomer;addPropertyChange(POTENTIAL_CUSTOMER_PROPERTY, oldPotentialCustomer, newPotentialCustomer);this.changed = true;setChecked(false);return this;}
	public EventAttendance orderByPotentialCustomer(boolean asc){
doAddOrderBy(POTENTIAL_CUSTOMER_PROPERTY, asc);
return this;
}
	public SearchCriteria createPotentialCustomerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(POTENTIAL_CUSTOMER_PROPERTY, operator, parameters);
}
	public EventAttendance ignorePotentialCustomerCriteria(){super.ignoreSearchProperty(POTENTIAL_CUSTOMER_PROPERTY);
return this;
}
	public EventAttendance addPotentialCustomerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPotentialCustomerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePotentialCustomer(PotentialCustomer potentialCustomer){
		if(potentialCustomer != null) { setPotentialCustomer(potentialCustomer);}
	}

	
	public void clearPotentialCustomer(){
		setPotentialCustomer ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setCityEvent(CityEvent cityEvent){CityEvent oldCityEvent = this.cityEvent;CityEvent newCityEvent = cityEvent;this.cityEvent = newCityEvent;}
	public CityEvent cityEvent(){
doLoad();
return getCityEvent();
}
	public CityEvent getCityEvent(){
		return this.cityEvent;
	}
	public EventAttendance updateCityEvent(CityEvent cityEvent){CityEvent oldCityEvent = this.cityEvent;CityEvent newCityEvent = cityEvent;if(!shouldReplaceBy(newCityEvent, oldCityEvent)){return this;}this.cityEvent = newCityEvent;addPropertyChange(CITY_EVENT_PROPERTY, oldCityEvent, newCityEvent);this.changed = true;setChecked(false);return this;}
	public EventAttendance orderByCityEvent(boolean asc){
doAddOrderBy(CITY_EVENT_PROPERTY, asc);
return this;
}
	public SearchCriteria createCityEventCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CITY_EVENT_PROPERTY, operator, parameters);
}
	public EventAttendance ignoreCityEventCriteria(){super.ignoreSearchProperty(CITY_EVENT_PROPERTY);
return this;
}
	public EventAttendance addCityEventCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCityEventCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCityEvent(CityEvent cityEvent){
		if(cityEvent != null) { setCityEvent(cityEvent);}
	}

	
	public void clearCityEvent(){
		setCityEvent ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);this.description = newDescription;}
	public String description(){
doLoad();
return getDescription();
}
	public String getDescription(){
		return this.description;
	}
	public EventAttendance updateDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);if(!shouldReplaceBy(newDescription, oldDescription)){return this;}this.description = newDescription;addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);this.changed = true;setChecked(false);return this;}
	public EventAttendance orderByDescription(boolean asc){
doAddOrderBy(DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
}
	public EventAttendance ignoreDescriptionCriteria(){super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
return this;
}
	public EventAttendance addDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public EventAttendance updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public EventAttendance orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public EventAttendance ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public EventAttendance addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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


	public static EventAttendance createWith(RetailscmUserContext userContext, ThrowingFunction<EventAttendance,EventAttendance,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<EventAttendance> customCreator = mapper.findCustomCreator(EventAttendance.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    EventAttendance result = new EventAttendance();
    result.setName(mapper.tryToGet(EventAttendance.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setPotentialCustomer(mapper.tryToGet(EventAttendance.class, POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomer.class,
        0, true, result.getPotentialCustomer(), params));
    result.setCityEvent(mapper.tryToGet(EventAttendance.class, CITY_EVENT_PROPERTY, CityEvent.class,
        0, true, result.getCityEvent(), params));
    result.setDescription(mapper.tryToGet(EventAttendance.class, DESCRIPTION_PROPERTY, String.class,
        1, false, result.getDescription(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixEventAttendance(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      EventAttendanceTokens tokens = mapper.findParamByClass(params, EventAttendanceTokens.class);
      if (tokens == null) {
        tokens = EventAttendanceTokens.start();
      }
      result = userContext.getManagerGroup().getEventAttendanceManager().internalSaveEventAttendance(userContext, result, tokens.done());
      
    }
    return result;
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

