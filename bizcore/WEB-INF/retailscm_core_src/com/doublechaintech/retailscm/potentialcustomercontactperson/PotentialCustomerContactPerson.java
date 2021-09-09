
package com.doublechaintech.retailscm.potentialcustomercontactperson;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(MOBILE_PROPERTY, "mobile", "手机")
        .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(POTENTIAL_CUSTOMER_PROPERTY, "potential_customer", "潜在的客户")
        .withType("potential_customer", PotentialCustomer.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(POTENTIAL_CUSTOMER_CONTACT_LIST, "contactTo", "潜在客户联络名单")
        .withType("potential_customer_contact", PotentialCustomerContact.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,MOBILE_PROPERTY ,POTENTIAL_CUSTOMER_PROPERTY ,DESCRIPTION_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(POTENTIAL_CUSTOMER_CONTACT_LIST, "contactTo");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(POTENTIAL_CUSTOMER_CONTACT_LIST, PotentialCustomerContact.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomer.class);

    return parents;
  }

  public PotentialCustomerContactPerson want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public PotentialCustomerContactPerson wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	mobile              ;
	protected		PotentialCustomer   	potentialCustomer   ;
	protected		String              	description         ;
	protected		int                 	version             ;

	
	protected		SmartList<PotentialCustomerContact>	mPotentialCustomerContactList;



	public 	PotentialCustomerContactPerson(){
		// lazy load for all the properties
	}
	public 	static PotentialCustomerContactPerson withId(String id){
		PotentialCustomerContactPerson potentialCustomerContactPerson = new PotentialCustomerContactPerson();
		potentialCustomerContactPerson.setId(id);
		potentialCustomerContactPerson.setVersion(Integer.MAX_VALUE);
		potentialCustomerContactPerson.setChecked(true);
		return potentialCustomerContactPerson;
	}
	public 	static PotentialCustomerContactPerson refById(String id){
		return withId(id);
	}

  public PotentialCustomerContactPerson limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public PotentialCustomerContactPerson limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static PotentialCustomerContactPerson searchExample(){
    PotentialCustomerContactPerson potentialCustomerContactPerson = new PotentialCustomerContactPerson();
    		potentialCustomerContactPerson.setVersion(UNSET_INT);

    return potentialCustomerContactPerson;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setPotentialCustomer( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public PotentialCustomerContactPerson updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContactPerson orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public PotentialCustomerContactPerson ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public PotentialCustomerContactPerson addIdCriteria(QueryOperator operator, Object... parameters){
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
	public PotentialCustomerContactPerson updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContactPerson orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public PotentialCustomerContactPerson ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public PotentialCustomerContactPerson addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setMobile(String mobile){String oldMobile = this.mobile;String newMobile = trimString(mobile);this.mobile = newMobile;}
	public String mobile(){
doLoad();
return getMobile();
}
	public String getMobile(){
		return this.mobile;
	}
	public PotentialCustomerContactPerson updateMobile(String mobile){String oldMobile = this.mobile;String newMobile = trimString(mobile);if(!shouldReplaceBy(newMobile, oldMobile)){return this;}this.mobile = newMobile;addPropertyChange(MOBILE_PROPERTY, oldMobile, newMobile);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContactPerson orderByMobile(boolean asc){
doAddOrderBy(MOBILE_PROPERTY, asc);
return this;
}
	public SearchCriteria createMobileCriteria(QueryOperator operator, Object... parameters){
return createCriteria(MOBILE_PROPERTY, operator, parameters);
}
	public PotentialCustomerContactPerson ignoreMobileCriteria(){super.ignoreSearchProperty(MOBILE_PROPERTY);
return this;
}
	public PotentialCustomerContactPerson addMobileCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createMobileCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeMobile(String mobile){
		if(mobile != null) { setMobile(mobile);}
	}

	

	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}

		
	public void setPotentialCustomer(PotentialCustomer potentialCustomer){PotentialCustomer oldPotentialCustomer = this.potentialCustomer;PotentialCustomer newPotentialCustomer = potentialCustomer;this.potentialCustomer = newPotentialCustomer;}
	public PotentialCustomer potentialCustomer(){
doLoad();
return getPotentialCustomer();
}
	public PotentialCustomer getPotentialCustomer(){
		return this.potentialCustomer;
	}
	public PotentialCustomerContactPerson updatePotentialCustomer(PotentialCustomer potentialCustomer){PotentialCustomer oldPotentialCustomer = this.potentialCustomer;PotentialCustomer newPotentialCustomer = potentialCustomer;if(!shouldReplaceBy(newPotentialCustomer, oldPotentialCustomer)){return this;}this.potentialCustomer = newPotentialCustomer;addPropertyChange(POTENTIAL_CUSTOMER_PROPERTY, oldPotentialCustomer, newPotentialCustomer);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContactPerson orderByPotentialCustomer(boolean asc){
doAddOrderBy(POTENTIAL_CUSTOMER_PROPERTY, asc);
return this;
}
	public SearchCriteria createPotentialCustomerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(POTENTIAL_CUSTOMER_PROPERTY, operator, parameters);
}
	public PotentialCustomerContactPerson ignorePotentialCustomerCriteria(){super.ignoreSearchProperty(POTENTIAL_CUSTOMER_PROPERTY);
return this;
}
	public PotentialCustomerContactPerson addPotentialCustomerCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);this.description = newDescription;}
	public String description(){
doLoad();
return getDescription();
}
	public String getDescription(){
		return this.description;
	}
	public PotentialCustomerContactPerson updateDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);if(!shouldReplaceBy(newDescription, oldDescription)){return this;}this.description = newDescription;addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContactPerson orderByDescription(boolean asc){
doAddOrderBy(DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
}
	public PotentialCustomerContactPerson ignoreDescriptionCriteria(){super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
return this;
}
	public PotentialCustomerContactPerson addDescriptionCriteria(QueryOperator operator, Object... parameters){
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
	public PotentialCustomerContactPerson updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public PotentialCustomerContactPerson orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public PotentialCustomerContactPerson ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public PotentialCustomerContactPerson addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<PotentialCustomerContact> potentialCustomerContactList(){
    
    doLoadChild(POTENTIAL_CUSTOMER_CONTACT_LIST);
    
    return getPotentialCustomerContactList();
  }


	public  void setPotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setContactTo(this);
		}

		this.mPotentialCustomerContactList = potentialCustomerContactList;
		this.mPotentialCustomerContactList.setListInternalName (POTENTIAL_CUSTOMER_CONTACT_LIST );

	}

	public  PotentialCustomerContactPerson addPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact){
		potentialCustomerContact.setContactTo(this);
		getPotentialCustomerContactList().add(potentialCustomerContact);
		return this;
	}
	public  PotentialCustomerContactPerson addPotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList){
		for( PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			potentialCustomerContact.setContactTo(this);
		}
		getPotentialCustomerContactList().addAll(potentialCustomerContactList);
		return this;
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


	public static PotentialCustomerContactPerson createWith(RetailscmUserContext userContext, ThrowingFunction<PotentialCustomerContactPerson,PotentialCustomerContactPerson,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<PotentialCustomerContactPerson> customCreator = mapper.findCustomCreator(PotentialCustomerContactPerson.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    PotentialCustomerContactPerson result = new PotentialCustomerContactPerson();
    result.setName(mapper.tryToGet(PotentialCustomerContactPerson.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setMobile(mapper.tryToGet(PotentialCustomerContactPerson.class, MOBILE_PROPERTY, String.class,
        1, false, result.getMobile(), params));
    result.setPotentialCustomer(mapper.tryToGet(PotentialCustomerContactPerson.class, POTENTIAL_CUSTOMER_PROPERTY, PotentialCustomer.class,
        0, true, result.getPotentialCustomer(), params));
    result.setDescription(mapper.tryToGet(PotentialCustomerContactPerson.class, DESCRIPTION_PROPERTY, String.class,
        2, false, result.getDescription(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixPotentialCustomerContactPerson(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      PotentialCustomerContactPersonTokens tokens = mapper.findParamByClass(params, PotentialCustomerContactPersonTokens.class);
      if (tokens == null) {
        tokens = PotentialCustomerContactPersonTokens.start();
      }
      result = userContext.getManagerGroup().getPotentialCustomerContactPersonManager().internalSavePotentialCustomerContactPerson(userContext, result, tokens.done());
      
    }
    return result;
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

