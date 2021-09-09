
package com.doublechaintech.retailscm.userallowlist;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.userdomain.UserDomain;









@JsonSerialize(using = UserAllowListSerializer.class)
public class UserAllowList extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String USER_IDENTITY_PROPERTY         = "userIdentity"      ;
	public static final String USER_SPECIAL_FUNCTIONS_PROPERTY = "userSpecialFunctions";
	public static final String DOMAIN_PROPERTY                = "domain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="UserAllowList";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(USER_IDENTITY_PROPERTY, "user_identity", "用户标识")
        .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(USER_SPECIAL_FUNCTIONS_PROPERTY, "user_special_functions", "用户特权")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DOMAIN_PROPERTY, "user_domain", "域")
        .withType("user_domain", UserDomain.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,USER_IDENTITY_PROPERTY ,USER_SPECIAL_FUNCTIONS_PROPERTY ,DOMAIN_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(DOMAIN_PROPERTY, UserDomain.class);

    return parents;
  }

  public UserAllowList want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public UserAllowList wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getMaskedUserIdentity();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	userIdentity        ;
	protected		String              	userSpecialFunctions;
	protected		UserDomain          	domain              ;
	protected		int                 	version             ;

	



	public 	UserAllowList(){
		// lazy load for all the properties
	}
	public 	static UserAllowList withId(String id){
		UserAllowList userAllowList = new UserAllowList();
		userAllowList.setId(id);
		userAllowList.setVersion(Integer.MAX_VALUE);
		userAllowList.setChecked(true);
		return userAllowList;
	}
	public 	static UserAllowList refById(String id){
		return withId(id);
	}

  public UserAllowList limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public UserAllowList limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static UserAllowList searchExample(){
    UserAllowList userAllowList = new UserAllowList();
    		userAllowList.setVersion(UNSET_INT);

    return userAllowList;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDomain( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(USER_IDENTITY_PROPERTY.equals(property)){
			changeUserIdentityProperty(newValueExpr);
		}
		if(USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
			changeUserSpecialFunctionsProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeUserIdentityProperty(String newValueExpr){
	
		String oldValue = getUserIdentity();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserIdentity(newValue);
		this.onChangeProperty(USER_IDENTITY_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeUserSpecialFunctionsProperty(String newValueExpr){
	
		String oldValue = getUserSpecialFunctions();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserSpecialFunctions(newValue);
		this.onChangeProperty(USER_SPECIAL_FUNCTIONS_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(USER_IDENTITY_PROPERTY.equals(property)){
			return getUserIdentity();
		}
		if(USER_SPECIAL_FUNCTIONS_PROPERTY.equals(property)){
			return getUserSpecialFunctions();
		}
		if(DOMAIN_PROPERTY.equals(property)){
			return getDomain();
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
	public UserAllowList updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public UserAllowList orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public UserAllowList ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public UserAllowList addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setUserIdentity(String userIdentity){String oldUserIdentity = this.userIdentity;String newUserIdentity = trimString(userIdentity);this.userIdentity = newUserIdentity;}
	public String userIdentity(){
doLoad();
return getUserIdentity();
}
	public String getUserIdentity(){
		return this.userIdentity;
	}
	public UserAllowList updateUserIdentity(String userIdentity){String oldUserIdentity = this.userIdentity;String newUserIdentity = trimString(userIdentity);if(!shouldReplaceBy(newUserIdentity, oldUserIdentity)){return this;}this.userIdentity = newUserIdentity;addPropertyChange(USER_IDENTITY_PROPERTY, oldUserIdentity, newUserIdentity);this.changed = true;setChecked(false);return this;}
	public UserAllowList orderByUserIdentity(boolean asc){
doAddOrderBy(USER_IDENTITY_PROPERTY, asc);
return this;
}
	public SearchCriteria createUserIdentityCriteria(QueryOperator operator, Object... parameters){
return createCriteria(USER_IDENTITY_PROPERTY, operator, parameters);
}
	public UserAllowList ignoreUserIdentityCriteria(){super.ignoreSearchProperty(USER_IDENTITY_PROPERTY);
return this;
}
	public UserAllowList addUserIdentityCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createUserIdentityCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeUserIdentity(String userIdentity){
		if(userIdentity != null) { setUserIdentity(userIdentity);}
	}

	

	public String getMaskedUserIdentity(){
		String mobilePhoneNumber = getUserIdentity();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}

		
	public void setUserSpecialFunctions(String userSpecialFunctions){String oldUserSpecialFunctions = this.userSpecialFunctions;String newUserSpecialFunctions = trimString(userSpecialFunctions);this.userSpecialFunctions = newUserSpecialFunctions;}
	public String userSpecialFunctions(){
doLoad();
return getUserSpecialFunctions();
}
	public String getUserSpecialFunctions(){
		return this.userSpecialFunctions;
	}
	public UserAllowList updateUserSpecialFunctions(String userSpecialFunctions){String oldUserSpecialFunctions = this.userSpecialFunctions;String newUserSpecialFunctions = trimString(userSpecialFunctions);if(!shouldReplaceBy(newUserSpecialFunctions, oldUserSpecialFunctions)){return this;}this.userSpecialFunctions = newUserSpecialFunctions;addPropertyChange(USER_SPECIAL_FUNCTIONS_PROPERTY, oldUserSpecialFunctions, newUserSpecialFunctions);this.changed = true;setChecked(false);return this;}
	public UserAllowList orderByUserSpecialFunctions(boolean asc){
doAddOrderBy(USER_SPECIAL_FUNCTIONS_PROPERTY, asc);
return this;
}
	public SearchCriteria createUserSpecialFunctionsCriteria(QueryOperator operator, Object... parameters){
return createCriteria(USER_SPECIAL_FUNCTIONS_PROPERTY, operator, parameters);
}
	public UserAllowList ignoreUserSpecialFunctionsCriteria(){super.ignoreSearchProperty(USER_SPECIAL_FUNCTIONS_PROPERTY);
return this;
}
	public UserAllowList addUserSpecialFunctionsCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createUserSpecialFunctionsCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeUserSpecialFunctions(String userSpecialFunctions){
		if(userSpecialFunctions != null) { setUserSpecialFunctions(userSpecialFunctions);}
	}

	
	public void setDomain(UserDomain domain){UserDomain oldDomain = this.domain;UserDomain newDomain = domain;this.domain = newDomain;}
	public UserDomain domain(){
doLoad();
return getDomain();
}
	public UserDomain getDomain(){
		return this.domain;
	}
	public UserAllowList updateDomain(UserDomain domain){UserDomain oldDomain = this.domain;UserDomain newDomain = domain;if(!shouldReplaceBy(newDomain, oldDomain)){return this;}this.domain = newDomain;addPropertyChange(DOMAIN_PROPERTY, oldDomain, newDomain);this.changed = true;setChecked(false);return this;}
	public UserAllowList orderByDomain(boolean asc){
doAddOrderBy(DOMAIN_PROPERTY, asc);
return this;
}
	public SearchCriteria createDomainCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DOMAIN_PROPERTY, operator, parameters);
}
	public UserAllowList ignoreDomainCriteria(){super.ignoreSearchProperty(DOMAIN_PROPERTY);
return this;
}
	public UserAllowList addDomainCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDomainCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDomain(UserDomain domain){
		if(domain != null) { setDomain(domain);}
	}

	
	public void clearDomain(){
		setDomain ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public UserAllowList updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public UserAllowList orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public UserAllowList ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public UserAllowList addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDomain(), internalType);


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
		appendKeyValuePair(result, USER_IDENTITY_PROPERTY, getMaskedUserIdentity());
		appendKeyValuePair(result, USER_SPECIAL_FUNCTIONS_PROPERTY, getUserSpecialFunctions());
		appendKeyValuePair(result, DOMAIN_PROPERTY, getDomain());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof UserAllowList){


			UserAllowList dest =(UserAllowList)baseDest;

			dest.setId(getId());
			dest.setUserIdentity(getUserIdentity());
			dest.setUserSpecialFunctions(getUserSpecialFunctions());
			dest.setDomain(getDomain());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof UserAllowList){


			UserAllowList dest =(UserAllowList)baseDest;

			dest.mergeId(getId());
			dest.mergeUserIdentity(getUserIdentity());
			dest.mergeUserSpecialFunctions(getUserSpecialFunctions());
			dest.mergeDomain(getDomain());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof UserAllowList){


			UserAllowList dest =(UserAllowList)baseDest;

			dest.mergeId(getId());
			dest.mergeUserIdentity(getUserIdentity());
			dest.mergeUserSpecialFunctions(getUserSpecialFunctions());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getUserIdentity(), getUserSpecialFunctions(), getDomain(), getVersion()};
	}


	public static UserAllowList createWith(RetailscmUserContext userContext, ThrowingFunction<UserAllowList,UserAllowList,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<UserAllowList> customCreator = mapper.findCustomCreator(UserAllowList.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    UserAllowList result = new UserAllowList();
    result.setUserIdentity(mapper.tryToGet(UserAllowList.class, USER_IDENTITY_PROPERTY, String.class,
        0, false, result.getUserIdentity(), params));
    result.setUserSpecialFunctions(mapper.tryToGet(UserAllowList.class, USER_SPECIAL_FUNCTIONS_PROPERTY, String.class,
        1, false, result.getUserSpecialFunctions(), params));
    result.setDomain(mapper.tryToGet(UserAllowList.class, DOMAIN_PROPERTY, UserDomain.class,
        0, true, result.getDomain(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixUserAllowList(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      UserAllowListTokens tokens = mapper.findParamByClass(params, UserAllowListTokens.class);
      if (tokens == null) {
        tokens = UserAllowListTokens.start();
      }
      result = userContext.getManagerGroup().getUserAllowListManager().internalSaveUserAllowList(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("UserAllowList{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tuserIdentity='"+getUserIdentity()+"';");
		stringBuilder.append("\tuserSpecialFunctions='"+getUserSpecialFunctions()+"';");
		if(getDomain() != null ){
 			stringBuilder.append("\tdomain='UserDomain("+getDomain().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

