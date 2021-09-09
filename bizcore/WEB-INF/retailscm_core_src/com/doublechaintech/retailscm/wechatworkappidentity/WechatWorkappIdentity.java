
package com.doublechaintech.retailscm.wechatworkappidentity;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.secuser.SecUser;









@JsonSerialize(using = WechatWorkappIdentitySerializer.class)
public class WechatWorkappIdentity extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CORP_ID_PROPERTY               = "corpId"            ;
	public static final String USER_ID_PROPERTY               = "userId"            ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String LAST_LOGIN_TIME_PROPERTY       = "lastLoginTime"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="WechatWorkappIdentity";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CORP_ID_PROPERTY, "corp_id", "公司")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(USER_ID_PROPERTY, "user_id", "用户")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SEC_USER_PROPERTY, "sec_user", "系统用户")
        .withType("sec_user", SecUser.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CREATE_TIME_PROPERTY, "create_time", "创建时间")
        .withType("date_time_create", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_LOGIN_TIME_PROPERTY, "last_login_time", "最后登录时间")
        .withType("date_time", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,CORP_ID_PROPERTY ,USER_ID_PROPERTY ,SEC_USER_PROPERTY ,CREATE_TIME_PROPERTY ,LAST_LOGIN_TIME_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(SEC_USER_PROPERTY, SecUser.class);

    return parents;
  }

  public WechatWorkappIdentity want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public WechatWorkappIdentity wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getCorpId();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	corpId              ;
	protected		String              	userId              ;
	protected		SecUser             	secUser             ;
	protected		DateTime            	createTime          ;
	protected		DateTime            	lastLoginTime       ;
	protected		int                 	version             ;

	



	public 	WechatWorkappIdentity(){
		// lazy load for all the properties
	}
	public 	static WechatWorkappIdentity withId(String id){
		WechatWorkappIdentity wechatWorkappIdentity = new WechatWorkappIdentity();
		wechatWorkappIdentity.setId(id);
		wechatWorkappIdentity.setVersion(Integer.MAX_VALUE);
		wechatWorkappIdentity.setChecked(true);
		return wechatWorkappIdentity;
	}
	public 	static WechatWorkappIdentity refById(String id){
		return withId(id);
	}

  public WechatWorkappIdentity limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public WechatWorkappIdentity limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static WechatWorkappIdentity searchExample(){
    WechatWorkappIdentity wechatWorkappIdentity = new WechatWorkappIdentity();
    		wechatWorkappIdentity.setVersion(UNSET_INT);

    return wechatWorkappIdentity;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSecUser( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(CORP_ID_PROPERTY.equals(property)){
			changeCorpIdProperty(newValueExpr);
		}
		if(USER_ID_PROPERTY.equals(property)){
			changeUserIdProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(LAST_LOGIN_TIME_PROPERTY.equals(property)){
			changeLastLoginTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCorpIdProperty(String newValueExpr){
	
		String oldValue = getCorpId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCorpId(newValue);
		this.onChangeProperty(CORP_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeUserIdProperty(String newValueExpr){
	
		String oldValue = getUserId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUserId(newValue);
		this.onChangeProperty(USER_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeCreateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getCreateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCreateTime(newValue);
		this.onChangeProperty(CREATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLastLoginTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastLoginTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastLoginTime(newValue);
		this.onChangeProperty(LAST_LOGIN_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(CORP_ID_PROPERTY.equals(property)){
			return getCorpId();
		}
		if(USER_ID_PROPERTY.equals(property)){
			return getUserId();
		}
		if(SEC_USER_PROPERTY.equals(property)){
			return getSecUser();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
		}
		if(LAST_LOGIN_TIME_PROPERTY.equals(property)){
			return getLastLoginTime();
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
	public WechatWorkappIdentity updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public WechatWorkappIdentity orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public WechatWorkappIdentity ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public WechatWorkappIdentity addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setCorpId(String corpId){String oldCorpId = this.corpId;String newCorpId = trimString(corpId);this.corpId = newCorpId;}
	public String corpId(){
doLoad();
return getCorpId();
}
	public String getCorpId(){
		return this.corpId;
	}
	public WechatWorkappIdentity updateCorpId(String corpId){String oldCorpId = this.corpId;String newCorpId = trimString(corpId);if(!shouldReplaceBy(newCorpId, oldCorpId)){return this;}this.corpId = newCorpId;addPropertyChange(CORP_ID_PROPERTY, oldCorpId, newCorpId);this.changed = true;setChecked(false);return this;}
	public WechatWorkappIdentity orderByCorpId(boolean asc){
doAddOrderBy(CORP_ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createCorpIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CORP_ID_PROPERTY, operator, parameters);
}
	public WechatWorkappIdentity ignoreCorpIdCriteria(){super.ignoreSearchProperty(CORP_ID_PROPERTY);
return this;
}
	public WechatWorkappIdentity addCorpIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCorpIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCorpId(String corpId){
		if(corpId != null) { setCorpId(corpId);}
	}

	
	public void setUserId(String userId){String oldUserId = this.userId;String newUserId = trimString(userId);this.userId = newUserId;}
	public String userId(){
doLoad();
return getUserId();
}
	public String getUserId(){
		return this.userId;
	}
	public WechatWorkappIdentity updateUserId(String userId){String oldUserId = this.userId;String newUserId = trimString(userId);if(!shouldReplaceBy(newUserId, oldUserId)){return this;}this.userId = newUserId;addPropertyChange(USER_ID_PROPERTY, oldUserId, newUserId);this.changed = true;setChecked(false);return this;}
	public WechatWorkappIdentity orderByUserId(boolean asc){
doAddOrderBy(USER_ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createUserIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(USER_ID_PROPERTY, operator, parameters);
}
	public WechatWorkappIdentity ignoreUserIdCriteria(){super.ignoreSearchProperty(USER_ID_PROPERTY);
return this;
}
	public WechatWorkappIdentity addUserIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createUserIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeUserId(String userId){
		if(userId != null) { setUserId(userId);}
	}

	
	public void setSecUser(SecUser secUser){SecUser oldSecUser = this.secUser;SecUser newSecUser = secUser;this.secUser = newSecUser;}
	public SecUser secUser(){
doLoad();
return getSecUser();
}
	public SecUser getSecUser(){
		return this.secUser;
	}
	public WechatWorkappIdentity updateSecUser(SecUser secUser){SecUser oldSecUser = this.secUser;SecUser newSecUser = secUser;if(!shouldReplaceBy(newSecUser, oldSecUser)){return this;}this.secUser = newSecUser;addPropertyChange(SEC_USER_PROPERTY, oldSecUser, newSecUser);this.changed = true;setChecked(false);return this;}
	public WechatWorkappIdentity orderBySecUser(boolean asc){
doAddOrderBy(SEC_USER_PROPERTY, asc);
return this;
}
	public SearchCriteria createSecUserCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SEC_USER_PROPERTY, operator, parameters);
}
	public WechatWorkappIdentity ignoreSecUserCriteria(){super.ignoreSearchProperty(SEC_USER_PROPERTY);
return this;
}
	public WechatWorkappIdentity addSecUserCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSecUserCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSecUser(SecUser secUser){
		if(secUser != null) { setSecUser(secUser);}
	}

	
	public void clearSecUser(){
		setSecUser ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setCreateTime(DateTime createTime){DateTime oldCreateTime = this.createTime;DateTime newCreateTime = createTime;this.createTime = newCreateTime;}
	public DateTime createTime(){
doLoad();
return getCreateTime();
}
	public DateTime getCreateTime(){
		return this.createTime;
	}
	public WechatWorkappIdentity updateCreateTime(DateTime createTime){DateTime oldCreateTime = this.createTime;DateTime newCreateTime = createTime;if(!shouldReplaceBy(newCreateTime, oldCreateTime)){return this;}this.createTime = newCreateTime;addPropertyChange(CREATE_TIME_PROPERTY, oldCreateTime, newCreateTime);this.changed = true;setChecked(false);return this;}
	public WechatWorkappIdentity orderByCreateTime(boolean asc){
doAddOrderBy(CREATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createCreateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CREATE_TIME_PROPERTY, operator, parameters);
}
	public WechatWorkappIdentity ignoreCreateTimeCriteria(){super.ignoreSearchProperty(CREATE_TIME_PROPERTY);
return this;
}
	public WechatWorkappIdentity addCreateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCreateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}

	
	public void setLastLoginTime(DateTime lastLoginTime){DateTime oldLastLoginTime = this.lastLoginTime;DateTime newLastLoginTime = lastLoginTime;this.lastLoginTime = newLastLoginTime;}
	public DateTime lastLoginTime(){
doLoad();
return getLastLoginTime();
}
	public DateTime getLastLoginTime(){
		return this.lastLoginTime;
	}
	public WechatWorkappIdentity updateLastLoginTime(DateTime lastLoginTime){DateTime oldLastLoginTime = this.lastLoginTime;DateTime newLastLoginTime = lastLoginTime;if(!shouldReplaceBy(newLastLoginTime, oldLastLoginTime)){return this;}this.lastLoginTime = newLastLoginTime;addPropertyChange(LAST_LOGIN_TIME_PROPERTY, oldLastLoginTime, newLastLoginTime);this.changed = true;setChecked(false);return this;}
	public WechatWorkappIdentity orderByLastLoginTime(boolean asc){
doAddOrderBy(LAST_LOGIN_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastLoginTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_LOGIN_TIME_PROPERTY, operator, parameters);
}
	public WechatWorkappIdentity ignoreLastLoginTimeCriteria(){super.ignoreSearchProperty(LAST_LOGIN_TIME_PROPERTY);
return this;
}
	public WechatWorkappIdentity addLastLoginTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLastLoginTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLastLoginTime(DateTime lastLoginTime){
		setLastLoginTime(lastLoginTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public WechatWorkappIdentity updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public WechatWorkappIdentity orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public WechatWorkappIdentity ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public WechatWorkappIdentity addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getSecUser(), internalType);


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
		appendKeyValuePair(result, CORP_ID_PROPERTY, getCorpId());
		appendKeyValuePair(result, USER_ID_PROPERTY, getUserId());
		appendKeyValuePair(result, SEC_USER_PROPERTY, getSecUser());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, LAST_LOGIN_TIME_PROPERTY, getLastLoginTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof WechatWorkappIdentity){


			WechatWorkappIdentity dest =(WechatWorkappIdentity)baseDest;

			dest.setId(getId());
			dest.setCorpId(getCorpId());
			dest.setUserId(getUserId());
			dest.setSecUser(getSecUser());
			dest.setCreateTime(getCreateTime());
			dest.setLastLoginTime(getLastLoginTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof WechatWorkappIdentity){


			WechatWorkappIdentity dest =(WechatWorkappIdentity)baseDest;

			dest.mergeId(getId());
			dest.mergeCorpId(getCorpId());
			dest.mergeUserId(getUserId());
			dest.mergeSecUser(getSecUser());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeLastLoginTime(getLastLoginTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof WechatWorkappIdentity){


			WechatWorkappIdentity dest =(WechatWorkappIdentity)baseDest;

			dest.mergeId(getId());
			dest.mergeCorpId(getCorpId());
			dest.mergeUserId(getUserId());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeLastLoginTime(getLastLoginTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCorpId(), getUserId(), getSecUser(), getCreateTime(), getLastLoginTime(), getVersion()};
	}


	public static WechatWorkappIdentity createWith(RetailscmUserContext userContext, ThrowingFunction<WechatWorkappIdentity,WechatWorkappIdentity,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<WechatWorkappIdentity> customCreator = mapper.findCustomCreator(WechatWorkappIdentity.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    WechatWorkappIdentity result = new WechatWorkappIdentity();
    result.setCorpId(mapper.tryToGet(WechatWorkappIdentity.class, CORP_ID_PROPERTY, String.class,
        0, false, result.getCorpId(), params));
    result.setUserId(mapper.tryToGet(WechatWorkappIdentity.class, USER_ID_PROPERTY, String.class,
        1, false, result.getUserId(), params));
    result.setSecUser(mapper.tryToGet(WechatWorkappIdentity.class, SEC_USER_PROPERTY, SecUser.class,
        0, true, result.getSecUser(), params));
     result.setCreateTime(userContext.now());
    result.setLastLoginTime(mapper.tryToGet(WechatWorkappIdentity.class, LAST_LOGIN_TIME_PROPERTY, DateTime.class,
        0, true, result.getLastLoginTime(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixWechatWorkappIdentity(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      WechatWorkappIdentityTokens tokens = mapper.findParamByClass(params, WechatWorkappIdentityTokens.class);
      if (tokens == null) {
        tokens = WechatWorkappIdentityTokens.start();
      }
      result = userContext.getManagerGroup().getWechatWorkappIdentityManager().internalSaveWechatWorkappIdentity(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("WechatWorkappIdentity{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcorpId='"+getCorpId()+"';");
		stringBuilder.append("\tuserId='"+getUserId()+"';");
		if(getSecUser() != null ){
 			stringBuilder.append("\tsecUser='SecUser("+getSecUser().getId()+")';");
 		}
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tlastLoginTime='"+getLastLoginTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

