
package com.doublechaintech.retailscm.keypairidentity;

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
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;









@JsonSerialize(using = KeyPairIdentitySerializer.class)
public class KeyPairIdentity extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PUBLIC_KEY_PROPERTY            = "publicKey"         ;
	public static final String KEY_TYPE_PROPERTY              = "keyType"           ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="KeyPairIdentity";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PUBLIC_KEY_PROPERTY, "public_key", "公钥")
        .withType("text", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(KEY_TYPE_PROPERTY, "public_key_type", "秘钥类型")
        .withType("public_key_type", PublicKeyType.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SEC_USER_PROPERTY, "sec_user", "系统用户")
        .withType("sec_user", SecUser.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CREATE_TIME_PROPERTY, "create_time", "创建时间")
        .withType("date_time_create", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,PUBLIC_KEY_PROPERTY ,KEY_TYPE_PROPERTY ,SEC_USER_PROPERTY ,CREATE_TIME_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(KEY_TYPE_PROPERTY, PublicKeyType.class);
parents.put(SEC_USER_PROPERTY, SecUser.class);

    return parents;
  }

  public KeyPairIdentity want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public KeyPairIdentity wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getPublicKey();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	publicKey           ;
	protected		PublicKeyType       	keyType             ;
	protected		SecUser             	secUser             ;
	protected		DateTime            	createTime          ;
	protected		int                 	version             ;

	



	public 	KeyPairIdentity(){
		// lazy load for all the properties
	}
	public 	static KeyPairIdentity withId(String id){
		KeyPairIdentity keyPairIdentity = new KeyPairIdentity();
		keyPairIdentity.setId(id);
		keyPairIdentity.setVersion(Integer.MAX_VALUE);
		keyPairIdentity.setChecked(true);
		return keyPairIdentity;
	}
	public 	static KeyPairIdentity refById(String id){
		return withId(id);
	}

  public KeyPairIdentity limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public KeyPairIdentity limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static KeyPairIdentity searchExample(){
    KeyPairIdentity keyPairIdentity = new KeyPairIdentity();
    		keyPairIdentity.setVersion(UNSET_INT);

    return keyPairIdentity;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setKeyType( null );
		setSecUser( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PUBLIC_KEY_PROPERTY.equals(property)){
			changePublicKeyProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePublicKeyProperty(String newValueExpr){
	
		String oldValue = getPublicKey();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePublicKey(newValue);
		this.onChangeProperty(PUBLIC_KEY_PROPERTY, oldValue, newValue);
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
			
			
			


	
	public Object propertyOf(String property) {

		if(PUBLIC_KEY_PROPERTY.equals(property)){
			return getPublicKey();
		}
		if(KEY_TYPE_PROPERTY.equals(property)){
			return getKeyType();
		}
		if(SEC_USER_PROPERTY.equals(property)){
			return getSecUser();
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			return getCreateTime();
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
	public KeyPairIdentity updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public KeyPairIdentity orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public KeyPairIdentity ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public KeyPairIdentity addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setPublicKey(String publicKey){String oldPublicKey = this.publicKey;String newPublicKey = publicKey;this.publicKey = newPublicKey;}
	public String publicKey(){
doLoad();
return getPublicKey();
}
	public String getPublicKey(){
		return this.publicKey;
	}
	public KeyPairIdentity updatePublicKey(String publicKey){String oldPublicKey = this.publicKey;String newPublicKey = publicKey;if(!shouldReplaceBy(newPublicKey, oldPublicKey)){return this;}this.publicKey = newPublicKey;addPropertyChange(PUBLIC_KEY_PROPERTY, oldPublicKey, newPublicKey);this.changed = true;setChecked(false);return this;}
	public KeyPairIdentity orderByPublicKey(boolean asc){
doAddOrderBy(PUBLIC_KEY_PROPERTY, asc);
return this;
}
	public SearchCriteria createPublicKeyCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PUBLIC_KEY_PROPERTY, operator, parameters);
}
	public KeyPairIdentity ignorePublicKeyCriteria(){super.ignoreSearchProperty(PUBLIC_KEY_PROPERTY);
return this;
}
	public KeyPairIdentity addPublicKeyCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPublicKeyCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePublicKey(String publicKey){
		if(publicKey != null) { setPublicKey(publicKey);}
	}

	
	public void setKeyType(PublicKeyType keyType){PublicKeyType oldKeyType = this.keyType;PublicKeyType newKeyType = keyType;this.keyType = newKeyType;}
	public PublicKeyType keyType(){
doLoad();
return getKeyType();
}
	public PublicKeyType getKeyType(){
		return this.keyType;
	}
	public KeyPairIdentity updateKeyType(PublicKeyType keyType){PublicKeyType oldKeyType = this.keyType;PublicKeyType newKeyType = keyType;if(!shouldReplaceBy(newKeyType, oldKeyType)){return this;}this.keyType = newKeyType;addPropertyChange(KEY_TYPE_PROPERTY, oldKeyType, newKeyType);this.changed = true;setChecked(false);return this;}
	public KeyPairIdentity orderByKeyType(boolean asc){
doAddOrderBy(KEY_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createKeyTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(KEY_TYPE_PROPERTY, operator, parameters);
}
	public KeyPairIdentity ignoreKeyTypeCriteria(){super.ignoreSearchProperty(KEY_TYPE_PROPERTY);
return this;
}
	public KeyPairIdentity addKeyTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createKeyTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeKeyType(PublicKeyType keyType){
		if(keyType != null) { setKeyType(keyType);}
	}

	
	public void clearKeyType(){
		setKeyType ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setSecUser(SecUser secUser){SecUser oldSecUser = this.secUser;SecUser newSecUser = secUser;this.secUser = newSecUser;}
	public SecUser secUser(){
doLoad();
return getSecUser();
}
	public SecUser getSecUser(){
		return this.secUser;
	}
	public KeyPairIdentity updateSecUser(SecUser secUser){SecUser oldSecUser = this.secUser;SecUser newSecUser = secUser;if(!shouldReplaceBy(newSecUser, oldSecUser)){return this;}this.secUser = newSecUser;addPropertyChange(SEC_USER_PROPERTY, oldSecUser, newSecUser);this.changed = true;setChecked(false);return this;}
	public KeyPairIdentity orderBySecUser(boolean asc){
doAddOrderBy(SEC_USER_PROPERTY, asc);
return this;
}
	public SearchCriteria createSecUserCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SEC_USER_PROPERTY, operator, parameters);
}
	public KeyPairIdentity ignoreSecUserCriteria(){super.ignoreSearchProperty(SEC_USER_PROPERTY);
return this;
}
	public KeyPairIdentity addSecUserCriteria(QueryOperator operator, Object... parameters){
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
	public KeyPairIdentity updateCreateTime(DateTime createTime){DateTime oldCreateTime = this.createTime;DateTime newCreateTime = createTime;if(!shouldReplaceBy(newCreateTime, oldCreateTime)){return this;}this.createTime = newCreateTime;addPropertyChange(CREATE_TIME_PROPERTY, oldCreateTime, newCreateTime);this.changed = true;setChecked(false);return this;}
	public KeyPairIdentity orderByCreateTime(boolean asc){
doAddOrderBy(CREATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createCreateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CREATE_TIME_PROPERTY, operator, parameters);
}
	public KeyPairIdentity ignoreCreateTimeCriteria(){super.ignoreSearchProperty(CREATE_TIME_PROPERTY);
return this;
}
	public KeyPairIdentity addCreateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCreateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public KeyPairIdentity updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public KeyPairIdentity orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public KeyPairIdentity ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public KeyPairIdentity addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getKeyType(), internalType);
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
		appendKeyValuePair(result, PUBLIC_KEY_PROPERTY, getPublicKey());
		appendKeyValuePair(result, KEY_TYPE_PROPERTY, getKeyType());
		appendKeyValuePair(result, SEC_USER_PROPERTY, getSecUser());
		appendKeyValuePair(result, CREATE_TIME_PROPERTY, getCreateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof KeyPairIdentity){


			KeyPairIdentity dest =(KeyPairIdentity)baseDest;

			dest.setId(getId());
			dest.setPublicKey(getPublicKey());
			dest.setKeyType(getKeyType());
			dest.setSecUser(getSecUser());
			dest.setCreateTime(getCreateTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof KeyPairIdentity){


			KeyPairIdentity dest =(KeyPairIdentity)baseDest;

			dest.mergeId(getId());
			dest.mergePublicKey(getPublicKey());
			dest.mergeKeyType(getKeyType());
			dest.mergeSecUser(getSecUser());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof KeyPairIdentity){


			KeyPairIdentity dest =(KeyPairIdentity)baseDest;

			dest.mergeId(getId());
			dest.mergePublicKey(getPublicKey());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getPublicKey(), getKeyType(), getSecUser(), getCreateTime(), getVersion()};
	}


	public static KeyPairIdentity createWith(RetailscmUserContext userContext, ThrowingFunction<KeyPairIdentity,KeyPairIdentity,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<KeyPairIdentity> customCreator = mapper.findCustomCreator(KeyPairIdentity.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    KeyPairIdentity result = new KeyPairIdentity();
    result.setPublicKey(mapper.tryToGet(KeyPairIdentity.class, PUBLIC_KEY_PROPERTY, String.class,
        0, true, result.getPublicKey(), params));
    result.setKeyType(mapper.tryToGet(KeyPairIdentity.class, KEY_TYPE_PROPERTY, PublicKeyType.class,
        0, true, result.getKeyType(), params));
    result.setSecUser(mapper.tryToGet(KeyPairIdentity.class, SEC_USER_PROPERTY, SecUser.class,
        0, true, result.getSecUser(), params));
     result.setCreateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixKeyPairIdentity(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      KeyPairIdentityTokens tokens = mapper.findParamByClass(params, KeyPairIdentityTokens.class);
      if (tokens == null) {
        tokens = KeyPairIdentityTokens.start();
      }
      result = userContext.getManagerGroup().getKeyPairIdentityManager().internalSaveKeyPairIdentity(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("KeyPairIdentity{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tpublicKey='"+getPublicKey()+"';");
		if(getKeyType() != null ){
 			stringBuilder.append("\tkeyType='PublicKeyType("+getKeyType().getId()+")';");
 		}
		if(getSecUser() != null ){
 			stringBuilder.append("\tsecUser='SecUser("+getSecUser().getId()+")';");
 		}
		stringBuilder.append("\tcreateTime='"+getCreateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

