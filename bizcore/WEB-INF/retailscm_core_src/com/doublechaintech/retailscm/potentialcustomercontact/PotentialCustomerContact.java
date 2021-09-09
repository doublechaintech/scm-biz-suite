
package com.doublechaintech.retailscm.potentialcustomercontact;

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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CONTACT_DATE_PROPERTY, "contact_date", "接触日期")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CONTACT_METHOD_PROPERTY, "contact_method", "接触法")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(POTENTIAL_CUSTOMER_PROPERTY, "potential_customer", "潜在的客户")
        .withType("potential_customer", PotentialCustomer.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CITY_PARTNER_PROPERTY, "city_partner", "城市合伙人")
        .withType("city_partner", CityPartner.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CONTACT_TO_PROPERTY, "potential_customer_contact_person", "接触")
        .withType("potential_customer_contact_person", PotentialCustomerContactPerson.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,CONTACT_DATE_PROPERTY ,CONTACT_METHOD_PROPERTY ,POTENTIAL_CUSTOMER_PROPERTY ,CITY_PARTNER_PROPERTY ,CONTACT_TO_PROPERTY ,DESCRIPTION_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
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
parents.put(CITY_PARTNER_PROPERTY, CityPartner.class);
parents.put(CONTACT_TO_PROPERTY, PotentialCustomerContactPerson.class);

    return parents;
  }

  public PotentialCustomerContact want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public PotentialCustomerContact wants(Class<? extends BaseEntity>... classes) {
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
	protected		Date                	contactDate         ;
	protected		String              	contactMethod       ;
	protected		PotentialCustomer   	potentialCustomer   ;
	protected		CityPartner         	cityPartner         ;
	protected		PotentialCustomerContactPerson	contactTo           ;
	protected		String              	description         ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	



	public 	PotentialCustomerContact(){
		// lazy load for all the properties
	}
	public 	static PotentialCustomerContact withId(String id){
		PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
		potentialCustomerContact.setId(id);
		potentialCustomerContact.setVersion(Integer.MAX_VALUE);
		potentialCustomerContact.setChecked(true);
		return potentialCustomerContact;
	}
	public 	static PotentialCustomerContact refById(String id){
		return withId(id);
	}

  public PotentialCustomerContact limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public PotentialCustomerContact limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static PotentialCustomerContact searchExample(){
    PotentialCustomerContact potentialCustomerContact = new PotentialCustomerContact();
    		potentialCustomerContact.setVersion(UNSET_INT);

    return potentialCustomerContact;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPotentialCustomer( null );
		setCityPartner( null );
		setContactTo( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public PotentialCustomerContact updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public PotentialCustomerContact addIdCriteria(QueryOperator operator, Object... parameters){
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
	public PotentialCustomerContact updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public PotentialCustomerContact addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setContactDate(Date contactDate){Date oldContactDate = this.contactDate;Date newContactDate = contactDate;this.contactDate = newContactDate;}
	public Date contactDate(){
doLoad();
return getContactDate();
}
	public Date getContactDate(){
		return this.contactDate;
	}
	public PotentialCustomerContact updateContactDate(Date contactDate){Date oldContactDate = this.contactDate;Date newContactDate = contactDate;if(!shouldReplaceBy(newContactDate, oldContactDate)){return this;}this.contactDate = newContactDate;addPropertyChange(CONTACT_DATE_PROPERTY, oldContactDate, newContactDate);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByContactDate(boolean asc){
doAddOrderBy(CONTACT_DATE_PROPERTY, asc);
return this;
}
	public SearchCriteria createContactDateCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONTACT_DATE_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreContactDateCriteria(){super.ignoreSearchProperty(CONTACT_DATE_PROPERTY);
return this;
}
	public PotentialCustomerContact addContactDateCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createContactDateCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeContactDate(Date contactDate){
		setContactDate(contactDate);
	}

	
	public void setContactMethod(String contactMethod){String oldContactMethod = this.contactMethod;String newContactMethod = trimString(contactMethod);this.contactMethod = newContactMethod;}
	public String contactMethod(){
doLoad();
return getContactMethod();
}
	public String getContactMethod(){
		return this.contactMethod;
	}
	public PotentialCustomerContact updateContactMethod(String contactMethod){String oldContactMethod = this.contactMethod;String newContactMethod = trimString(contactMethod);if(!shouldReplaceBy(newContactMethod, oldContactMethod)){return this;}this.contactMethod = newContactMethod;addPropertyChange(CONTACT_METHOD_PROPERTY, oldContactMethod, newContactMethod);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByContactMethod(boolean asc){
doAddOrderBy(CONTACT_METHOD_PROPERTY, asc);
return this;
}
	public SearchCriteria createContactMethodCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONTACT_METHOD_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreContactMethodCriteria(){super.ignoreSearchProperty(CONTACT_METHOD_PROPERTY);
return this;
}
	public PotentialCustomerContact addContactMethodCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createContactMethodCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeContactMethod(String contactMethod){
		if(contactMethod != null) { setContactMethod(contactMethod);}
	}

	
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){PotentialCustomer oldPotentialCustomer = this.potentialCustomer;PotentialCustomer newPotentialCustomer = potentialCustomer;this.potentialCustomer = newPotentialCustomer;}
	public PotentialCustomer potentialCustomer(){
doLoad();
return getPotentialCustomer();
}
	public PotentialCustomer getPotentialCustomer(){
		return this.potentialCustomer;
	}
	public PotentialCustomerContact updatePotentialCustomer(PotentialCustomer potentialCustomer){PotentialCustomer oldPotentialCustomer = this.potentialCustomer;PotentialCustomer newPotentialCustomer = potentialCustomer;if(!shouldReplaceBy(newPotentialCustomer, oldPotentialCustomer)){return this;}this.potentialCustomer = newPotentialCustomer;addPropertyChange(POTENTIAL_CUSTOMER_PROPERTY, oldPotentialCustomer, newPotentialCustomer);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByPotentialCustomer(boolean asc){
doAddOrderBy(POTENTIAL_CUSTOMER_PROPERTY, asc);
return this;
}
	public SearchCriteria createPotentialCustomerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(POTENTIAL_CUSTOMER_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignorePotentialCustomerCriteria(){super.ignoreSearchProperty(POTENTIAL_CUSTOMER_PROPERTY);
return this;
}
	public PotentialCustomerContact addPotentialCustomerCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setCityPartner(CityPartner cityPartner){CityPartner oldCityPartner = this.cityPartner;CityPartner newCityPartner = cityPartner;this.cityPartner = newCityPartner;}
	public CityPartner cityPartner(){
doLoad();
return getCityPartner();
}
	public CityPartner getCityPartner(){
		return this.cityPartner;
	}
	public PotentialCustomerContact updateCityPartner(CityPartner cityPartner){CityPartner oldCityPartner = this.cityPartner;CityPartner newCityPartner = cityPartner;if(!shouldReplaceBy(newCityPartner, oldCityPartner)){return this;}this.cityPartner = newCityPartner;addPropertyChange(CITY_PARTNER_PROPERTY, oldCityPartner, newCityPartner);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByCityPartner(boolean asc){
doAddOrderBy(CITY_PARTNER_PROPERTY, asc);
return this;
}
	public SearchCriteria createCityPartnerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CITY_PARTNER_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreCityPartnerCriteria(){super.ignoreSearchProperty(CITY_PARTNER_PROPERTY);
return this;
}
	public PotentialCustomerContact addCityPartnerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCityPartnerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCityPartner(CityPartner cityPartner){
		if(cityPartner != null) { setCityPartner(cityPartner);}
	}

	
	public void clearCityPartner(){
		setCityPartner ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setContactTo(PotentialCustomerContactPerson contactTo){PotentialCustomerContactPerson oldContactTo = this.contactTo;PotentialCustomerContactPerson newContactTo = contactTo;this.contactTo = newContactTo;}
	public PotentialCustomerContactPerson contactTo(){
doLoad();
return getContactTo();
}
	public PotentialCustomerContactPerson getContactTo(){
		return this.contactTo;
	}
	public PotentialCustomerContact updateContactTo(PotentialCustomerContactPerson contactTo){PotentialCustomerContactPerson oldContactTo = this.contactTo;PotentialCustomerContactPerson newContactTo = contactTo;if(!shouldReplaceBy(newContactTo, oldContactTo)){return this;}this.contactTo = newContactTo;addPropertyChange(CONTACT_TO_PROPERTY, oldContactTo, newContactTo);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByContactTo(boolean asc){
doAddOrderBy(CONTACT_TO_PROPERTY, asc);
return this;
}
	public SearchCriteria createContactToCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONTACT_TO_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreContactToCriteria(){super.ignoreSearchProperty(CONTACT_TO_PROPERTY);
return this;
}
	public PotentialCustomerContact addContactToCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createContactToCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeContactTo(PotentialCustomerContactPerson contactTo){
		if(contactTo != null) { setContactTo(contactTo);}
	}

	
	public void clearContactTo(){
		setContactTo ( null );
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
	public PotentialCustomerContact updateDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);if(!shouldReplaceBy(newDescription, oldDescription)){return this;}this.description = newDescription;addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByDescription(boolean asc){
doAddOrderBy(DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreDescriptionCriteria(){super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
return this;
}
	public PotentialCustomerContact addDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public PotentialCustomerContact updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public PotentialCustomerContact addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public PotentialCustomerContact updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContact orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public PotentialCustomerContact ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public PotentialCustomerContact addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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


	public static PotentialCustomerContact createWith(RetailscmUserContext userContext, ThrowingFunction<PotentialCustomerContact,PotentialCustomerContact,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<PotentialCustomerContact> customCreator = mapper.findCustomCreator(PotentialCustomerContact.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    PotentialCustomerContact result = new PotentialCustomerContact();
    result.setName(mapper.tryToGet(PotentialCustomerContact.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setContactDate(mapper.tryToGet(PotentialCustomerContact.class, CONTACT_DATE_PROPERTY, Date.class,
        0, true, result.getContactDate(), params));
    result.setContactMethod(mapper.tryToGet(PotentialCustomerContact.class, CONTACT_METHOD_PROPERTY, String.class,
        1, false, result.getContactMethod(), params));
    result.setPotentialCustomer(mapper.tryToGet(PotentialCustomerContact.class, POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomer.class,
        0, true, result.getPotentialCustomer(), params));
    result.setCityPartner(mapper.tryToGet(PotentialCustomerContact.class, CITY_PARTNER_PROPERTY, CityPartner.class,
        0, true, result.getCityPartner(), params));
    result.setContactTo(mapper.tryToGet(PotentialCustomerContact.class, CONTACT_TO_PROPERTY, PotentialCustomerContactPerson.class,
        0, true, result.getContactTo(), params));
    result.setDescription(mapper.tryToGet(PotentialCustomerContact.class, DESCRIPTION_PROPERTY, String.class,
        2, false, result.getDescription(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixPotentialCustomerContact(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      PotentialCustomerContactTokens tokens = mapper.findParamByClass(params, PotentialCustomerContactTokens.class);
      if (tokens == null) {
        tokens = PotentialCustomerContactTokens.start();
      }
      result = userContext.getManagerGroup().getPotentialCustomerContactManager().internalSavePotentialCustomerContact(userContext, result, tokens.done());
      
    }
    return result;
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

