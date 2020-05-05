
package com.doublechaintech.retailscm.wechatworkappidentify;

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
import com.doublechaintech.retailscm.secuser.SecUser;

@JsonSerialize(using = WechatWorkappIdentifySerializer.class)
public class WechatWorkappIdentify extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CORP_ID_PROPERTY               = "corpId"            ;
	public static final String USER_ID_PROPERTY               = "userId"            ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String LAST_LOGIN_TIME_PROPERTY       = "lastLoginTime"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="WechatWorkappIdentify";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getCorpId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mCorpId             ;
	protected		String              	mUserId             ;
	protected		SecUser             	mSecUser            ;
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mLastLoginTime      ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	WechatWorkappIdentify(){
		// lazy load for all the properties
	}
	public 	static WechatWorkappIdentify withId(String id){
		WechatWorkappIdentify wechatWorkappIdentify = new WechatWorkappIdentify();
		wechatWorkappIdentify.setId(id);
		wechatWorkappIdentify.setVersion(Integer.MAX_VALUE);
		return wechatWorkappIdentify;
	}
	public 	static WechatWorkappIdentify refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSecUser( null );

		this.changed = true;
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
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public WechatWorkappIdentify updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setCorpId(String corpId){
		this.mCorpId = trimString(corpId);;
	}
	public String getCorpId(){
		return this.mCorpId;
	}
	public WechatWorkappIdentify updateCorpId(String corpId){
		this.mCorpId = trimString(corpId);;
		this.changed = true;
		return this;
	}
	public void mergeCorpId(String corpId){
		if(corpId != null) { setCorpId(corpId);}
	}
	
	
	public void clearCorpId(){
		setCorpId ( null );
		this.changed = true;
	}
	
	public void setUserId(String userId){
		this.mUserId = trimString(userId);;
	}
	public String getUserId(){
		return this.mUserId;
	}
	public WechatWorkappIdentify updateUserId(String userId){
		this.mUserId = trimString(userId);;
		this.changed = true;
		return this;
	}
	public void mergeUserId(String userId){
		if(userId != null) { setUserId(userId);}
	}
	
	
	public void clearUserId(){
		setUserId ( null );
		this.changed = true;
	}
	
	public void setSecUser(SecUser secUser){
		this.mSecUser = secUser;;
	}
	public SecUser getSecUser(){
		return this.mSecUser;
	}
	public WechatWorkappIdentify updateSecUser(SecUser secUser){
		this.mSecUser = secUser;;
		this.changed = true;
		return this;
	}
	public void mergeSecUser(SecUser secUser){
		if(secUser != null) { setSecUser(secUser);}
	}
	
	
	public void clearSecUser(){
		setSecUser ( null );
		this.changed = true;
	}
	
	public void setCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
	}
	public DateTime getCreateTime(){
		return this.mCreateTime;
	}
	public WechatWorkappIdentify updateCreateTime(DateTime createTime){
		this.mCreateTime = createTime;;
		this.changed = true;
		return this;
	}
	public void mergeCreateTime(DateTime createTime){
		setCreateTime(createTime);
	}
	
	
	public void setLastLoginTime(DateTime lastLoginTime){
		this.mLastLoginTime = lastLoginTime;;
	}
	public DateTime getLastLoginTime(){
		return this.mLastLoginTime;
	}
	public WechatWorkappIdentify updateLastLoginTime(DateTime lastLoginTime){
		this.mLastLoginTime = lastLoginTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastLoginTime(DateTime lastLoginTime){
		setLastLoginTime(lastLoginTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public WechatWorkappIdentify updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
		
		
		if(baseDest instanceof WechatWorkappIdentify){
		
		
			WechatWorkappIdentify dest =(WechatWorkappIdentify)baseDest;
		
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
		
		
		if(baseDest instanceof WechatWorkappIdentify){
		
			
			WechatWorkappIdentify dest =(WechatWorkappIdentify)baseDest;
		
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
		
		
		if(baseDest instanceof WechatWorkappIdentify){
		
			
			WechatWorkappIdentify dest =(WechatWorkappIdentify)baseDest;
		
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
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("WechatWorkappIdentify{");
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

