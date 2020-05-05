
package com.doublechaintech.retailscm.wechatminiappidentify;

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

@JsonSerialize(using = WechatMiniappIdentifySerializer.class)
public class WechatMiniappIdentify extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String OPEN_ID_PROPERTY               = "openId"            ;
	public static final String APP_ID_PROPERTY                = "appId"             ;
	public static final String SEC_USER_PROPERTY              = "secUser"           ;
	public static final String CREATE_TIME_PROPERTY           = "createTime"        ;
	public static final String LAST_LOGIN_TIME_PROPERTY       = "lastLoginTime"     ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="WechatMiniappIdentify";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getOpenId();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mOpenId             ;
	protected		String              	mAppId              ;
	protected		SecUser             	mSecUser            ;
	protected		DateTime            	mCreateTime         ;
	protected		DateTime            	mLastLoginTime      ;
	protected		int                 	mVersion            ;
	
	

	
		
	public 	WechatMiniappIdentify(){
		// lazy load for all the properties
	}
	public 	static WechatMiniappIdentify withId(String id){
		WechatMiniappIdentify wechatMiniappIdentify = new WechatMiniappIdentify();
		wechatMiniappIdentify.setId(id);
		wechatMiniappIdentify.setVersion(Integer.MAX_VALUE);
		return wechatMiniappIdentify;
	}
	public 	static WechatMiniappIdentify refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSecUser( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(OPEN_ID_PROPERTY.equals(property)){
			changeOpenIdProperty(newValueExpr);
		}
		if(APP_ID_PROPERTY.equals(property)){
			changeAppIdProperty(newValueExpr);
		}
		if(CREATE_TIME_PROPERTY.equals(property)){
			changeCreateTimeProperty(newValueExpr);
		}
		if(LAST_LOGIN_TIME_PROPERTY.equals(property)){
			changeLastLoginTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeOpenIdProperty(String newValueExpr){
	
		String oldValue = getOpenId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateOpenId(newValue);
		this.onChangeProperty(OPEN_ID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAppIdProperty(String newValueExpr){
	
		String oldValue = getAppId();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAppId(newValue);
		this.onChangeProperty(APP_ID_PROPERTY, oldValue, newValue);
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
     	
		if(OPEN_ID_PROPERTY.equals(property)){
			return getOpenId();
		}
		if(APP_ID_PROPERTY.equals(property)){
			return getAppId();
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
	public WechatMiniappIdentify updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setOpenId(String openId){
		this.mOpenId = trimString(openId);;
	}
	public String getOpenId(){
		return this.mOpenId;
	}
	public WechatMiniappIdentify updateOpenId(String openId){
		this.mOpenId = trimString(openId);;
		this.changed = true;
		return this;
	}
	public void mergeOpenId(String openId){
		if(openId != null) { setOpenId(openId);}
	}
	
	
	public void clearOpenId(){
		setOpenId ( null );
		this.changed = true;
	}
	
	public void setAppId(String appId){
		this.mAppId = trimString(appId);;
	}
	public String getAppId(){
		return this.mAppId;
	}
	public WechatMiniappIdentify updateAppId(String appId){
		this.mAppId = trimString(appId);;
		this.changed = true;
		return this;
	}
	public void mergeAppId(String appId){
		if(appId != null) { setAppId(appId);}
	}
	
	
	public void clearAppId(){
		setAppId ( null );
		this.changed = true;
	}
	
	public void setSecUser(SecUser secUser){
		this.mSecUser = secUser;;
	}
	public SecUser getSecUser(){
		return this.mSecUser;
	}
	public WechatMiniappIdentify updateSecUser(SecUser secUser){
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
	public WechatMiniappIdentify updateCreateTime(DateTime createTime){
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
	public WechatMiniappIdentify updateLastLoginTime(DateTime lastLoginTime){
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
	public WechatMiniappIdentify updateVersion(int version){
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
		appendKeyValuePair(result, OPEN_ID_PROPERTY, getOpenId());
		appendKeyValuePair(result, APP_ID_PROPERTY, getAppId());
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
		
		
		if(baseDest instanceof WechatMiniappIdentify){
		
		
			WechatMiniappIdentify dest =(WechatMiniappIdentify)baseDest;
		
			dest.setId(getId());
			dest.setOpenId(getOpenId());
			dest.setAppId(getAppId());
			dest.setSecUser(getSecUser());
			dest.setCreateTime(getCreateTime());
			dest.setLastLoginTime(getLastLoginTime());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatMiniappIdentify){
		
			
			WechatMiniappIdentify dest =(WechatMiniappIdentify)baseDest;
		
			dest.mergeId(getId());
			dest.mergeOpenId(getOpenId());
			dest.mergeAppId(getAppId());
			dest.mergeSecUser(getSecUser());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeLastLoginTime(getLastLoginTime());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof WechatMiniappIdentify){
		
			
			WechatMiniappIdentify dest =(WechatMiniappIdentify)baseDest;
		
			dest.mergeId(getId());
			dest.mergeOpenId(getOpenId());
			dest.mergeAppId(getAppId());
			dest.mergeCreateTime(getCreateTime());
			dest.mergeLastLoginTime(getLastLoginTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getOpenId(), getAppId(), getSecUser(), getCreateTime(), getLastLoginTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("WechatMiniappIdentify{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\topenId='"+getOpenId()+"';");
		stringBuilder.append("\tappId='"+getAppId()+"';");
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

