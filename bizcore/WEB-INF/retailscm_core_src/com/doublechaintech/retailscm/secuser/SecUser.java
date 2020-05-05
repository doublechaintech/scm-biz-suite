
package com.doublechaintech.retailscm.secuser;

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
import com.doublechaintech.retailscm.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.keypairidentify.KeypairIdentify;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

@JsonSerialize(using = SecUserSerializer.class)
public class SecUser extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOGIN_PROPERTY                 = "login"             ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String PWD_PROPERTY                   = "pwd"               ;
	public static final String WEIXIN_OPENID_PROPERTY         = "weixinOpenid"      ;
	public static final String WEIXIN_APPID_PROPERTY          = "weixinAppid"       ;
	public static final String ACCESS_TOKEN_PROPERTY          = "accessToken"       ;
	public static final String VERIFICATION_CODE_PROPERTY     = "verificationCode"  ;
	public static final String VERIFICATION_CODE_EXPIRE_PROPERTY = "verificationCodeExpire";
	public static final String LAST_LOGIN_TIME_PROPERTY       = "lastLoginTime"     ;
	public static final String DOMAIN_PROPERTY                = "domain"            ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_APP_LIST                            = "userAppList"       ;
	public static final String LOGIN_HISTORY_LIST                       = "loginHistoryList"  ;
	public static final String WECHAT_WORKAPP_IDENTIFY_LIST             = "wechatWorkappIdentifyList";
	public static final String WECHAT_MINIAPP_IDENTIFY_LIST             = "wechatMiniappIdentifyList";
	public static final String KEYPAIR_IDENTIFY_LIST                    = "keypairIdentifyList";

	public static final String INTERNAL_TYPE="SecUser";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getLogin();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLogin              ;
	protected		String              	mMobile             ;
	protected		String              	mEmail              ;
	protected		String              	mPwd                ;
	protected		String              	mWeixinOpenid       ;
	protected		String              	mWeixinAppid        ;
	protected		String              	mAccessToken        ;
	protected		int                 	mVerificationCode   ;
	protected		DateTime            	mVerificationCodeExpire;
	protected		DateTime            	mLastLoginTime      ;
	protected		UserDomain          	mDomain             ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<UserApp>  	mUserAppList        ;
	protected		SmartList<LoginHistory>	mLoginHistoryList   ;
	protected		SmartList<WechatWorkappIdentify>	mWechatWorkappIdentifyList;
	protected		SmartList<WechatMiniappIdentify>	mWechatMiniappIdentifyList;
	protected		SmartList<KeypairIdentify>	mKeypairIdentifyList;

	
		
	public 	SecUser(){
		// lazy load for all the properties
	}
	public 	static SecUser withId(String id){
		SecUser secUser = new SecUser();
		secUser.setId(id);
		secUser.setVersion(Integer.MAX_VALUE);
		return secUser;
	}
	public 	static SecUser refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDomain( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LOGIN_PROPERTY.equals(property)){
			changeLoginProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(PWD_PROPERTY.equals(property)){
			changePwdProperty(newValueExpr);
		}
		if(WEIXIN_OPENID_PROPERTY.equals(property)){
			changeWeixinOpenidProperty(newValueExpr);
		}
		if(WEIXIN_APPID_PROPERTY.equals(property)){
			changeWeixinAppidProperty(newValueExpr);
		}
		if(ACCESS_TOKEN_PROPERTY.equals(property)){
			changeAccessTokenProperty(newValueExpr);
		}
		if(VERIFICATION_CODE_PROPERTY.equals(property)){
			changeVerificationCodeProperty(newValueExpr);
		}
		if(VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)){
			changeVerificationCodeExpireProperty(newValueExpr);
		}
		if(LAST_LOGIN_TIME_PROPERTY.equals(property)){
			changeLastLoginTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLoginProperty(String newValueExpr){
	
		String oldValue = getLogin();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLogin(newValue);
		this.onChangeProperty(LOGIN_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changeEmailProperty(String newValueExpr){
	
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEmail(newValue);
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changePwdProperty(String newValueExpr){
	
		String oldValue = getPwd();
		String newValue = parseString(hashStringWithSHA256(newValueExpr));
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePwd(newValueExpr);
		this.onChangeProperty(PWD_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeWeixinOpenidProperty(String newValueExpr){
	
		String oldValue = getWeixinOpenid();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWeixinOpenid(newValue);
		this.onChangeProperty(WEIXIN_OPENID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeWeixinAppidProperty(String newValueExpr){
	
		String oldValue = getWeixinAppid();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateWeixinAppid(newValue);
		this.onChangeProperty(WEIXIN_APPID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeAccessTokenProperty(String newValueExpr){
	
		String oldValue = getAccessToken();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateAccessToken(newValue);
		this.onChangeProperty(ACCESS_TOKEN_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeVerificationCodeProperty(String newValueExpr){
	
		int oldValue = getVerificationCode();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateVerificationCode(newValue);
		this.onChangeProperty(VERIFICATION_CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeVerificationCodeExpireProperty(String newValueExpr){
	
		DateTime oldValue = getVerificationCodeExpire();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateVerificationCodeExpire(newValue);
		this.onChangeProperty(VERIFICATION_CODE_EXPIRE_PROPERTY, oldValue, newValue);
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
     	
		if(LOGIN_PROPERTY.equals(property)){
			return getLogin();
		}
		if(MOBILE_PROPERTY.equals(property)){
			return getMobile();
		}
		if(EMAIL_PROPERTY.equals(property)){
			return getEmail();
		}
		if(PWD_PROPERTY.equals(property)){
			return getPwd();
		}
		if(WEIXIN_OPENID_PROPERTY.equals(property)){
			return getWeixinOpenid();
		}
		if(WEIXIN_APPID_PROPERTY.equals(property)){
			return getWeixinAppid();
		}
		if(ACCESS_TOKEN_PROPERTY.equals(property)){
			return getAccessToken();
		}
		if(VERIFICATION_CODE_PROPERTY.equals(property)){
			return getVerificationCode();
		}
		if(VERIFICATION_CODE_EXPIRE_PROPERTY.equals(property)){
			return getVerificationCodeExpire();
		}
		if(LAST_LOGIN_TIME_PROPERTY.equals(property)){
			return getLastLoginTime();
		}
		if(DOMAIN_PROPERTY.equals(property)){
			return getDomain();
		}
		if(USER_APP_LIST.equals(property)){
			List<BaseEntity> list = getUserAppList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(LOGIN_HISTORY_LIST.equals(property)){
			List<BaseEntity> list = getLoginHistoryList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(WECHAT_WORKAPP_IDENTIFY_LIST.equals(property)){
			List<BaseEntity> list = getWechatWorkappIdentifyList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(WECHAT_MINIAPP_IDENTIFY_LIST.equals(property)){
			List<BaseEntity> list = getWechatMiniappIdentifyList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(KEYPAIR_IDENTIFY_LIST.equals(property)){
			List<BaseEntity> list = getKeypairIdentifyList().stream().map(item->item).collect(Collectors.toList());
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
	public SecUser updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setLogin(String login){
		this.mLogin = trimString(login);;
	}
	public String getLogin(){
		return this.mLogin;
	}
	public SecUser updateLogin(String login){
		this.mLogin = trimString(login);;
		this.changed = true;
		return this;
	}
	public void mergeLogin(String login){
		if(login != null) { setLogin(login);}
	}
	
	
	public void setMobile(String mobile){
		this.mMobile = trimString(mobile);;
	}
	public String getMobile(){
		return this.mMobile;
	}
	public SecUser updateMobile(String mobile){
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
	
		
	public void setEmail(String email){
		this.mEmail = trimString(email);;
	}
	public String getEmail(){
		return this.mEmail;
	}
	public SecUser updateEmail(String email){
		this.mEmail = trimString(email);;
		this.changed = true;
		return this;
	}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}
	
	
	public void setPwd(String pwd){
		this.mPwd = trimString(pwd);;
	}
	public String getPwd(){
		return this.mPwd;
	}
	public SecUser updatePwd(String pwd){
		this.mPwd = hashStringWithSHA256(trimString(pwd));;
		this.changed = true;
		return this;
	}
	public void mergePwd(String pwd){
		if(pwd != null) { setPwd(pwd);}
	}
	
	
	public void setClearTextOfPwd(String clearTextOfPwd){
	
		String hashedPwd = hashStringWithSHA256(clearTextOfPwd);
		setPwd(hashedPwd);
		
	}
	public String getMaskedPwd(){
	
		return "**********";
		
	}
	
		
	public void setWeixinOpenid(String weixinOpenid){
		this.mWeixinOpenid = trimString(weixinOpenid);;
	}
	public String getWeixinOpenid(){
		return this.mWeixinOpenid;
	}
	public SecUser updateWeixinOpenid(String weixinOpenid){
		this.mWeixinOpenid = trimString(weixinOpenid);;
		this.changed = true;
		return this;
	}
	public void mergeWeixinOpenid(String weixinOpenid){
		if(weixinOpenid != null) { setWeixinOpenid(weixinOpenid);}
	}
	
	
	public void setWeixinAppid(String weixinAppid){
		this.mWeixinAppid = trimString(weixinAppid);;
	}
	public String getWeixinAppid(){
		return this.mWeixinAppid;
	}
	public SecUser updateWeixinAppid(String weixinAppid){
		this.mWeixinAppid = trimString(weixinAppid);;
		this.changed = true;
		return this;
	}
	public void mergeWeixinAppid(String weixinAppid){
		if(weixinAppid != null) { setWeixinAppid(weixinAppid);}
	}
	
	
	public void setAccessToken(String accessToken){
		this.mAccessToken = trimString(accessToken);;
	}
	public String getAccessToken(){
		return this.mAccessToken;
	}
	public SecUser updateAccessToken(String accessToken){
		this.mAccessToken = trimString(accessToken);;
		this.changed = true;
		return this;
	}
	public void mergeAccessToken(String accessToken){
		if(accessToken != null) { setAccessToken(accessToken);}
	}
	
	
	public void setVerificationCode(int verificationCode){
		this.mVerificationCode = verificationCode;;
	}
	public int getVerificationCode(){
		return this.mVerificationCode;
	}
	public SecUser updateVerificationCode(int verificationCode){
		this.mVerificationCode = verificationCode;;
		this.changed = true;
		return this;
	}
	public void mergeVerificationCode(int verificationCode){
		setVerificationCode(verificationCode);
	}
	
	
	public void setVerificationCodeExpire(DateTime verificationCodeExpire){
		this.mVerificationCodeExpire = verificationCodeExpire;;
	}
	public DateTime getVerificationCodeExpire(){
		return this.mVerificationCodeExpire;
	}
	public SecUser updateVerificationCodeExpire(DateTime verificationCodeExpire){
		this.mVerificationCodeExpire = verificationCodeExpire;;
		this.changed = true;
		return this;
	}
	public void mergeVerificationCodeExpire(DateTime verificationCodeExpire){
		setVerificationCodeExpire(verificationCodeExpire);
	}
	
	
	public void setLastLoginTime(DateTime lastLoginTime){
		this.mLastLoginTime = lastLoginTime;;
	}
	public DateTime getLastLoginTime(){
		return this.mLastLoginTime;
	}
	public SecUser updateLastLoginTime(DateTime lastLoginTime){
		this.mLastLoginTime = lastLoginTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastLoginTime(DateTime lastLoginTime){
		setLastLoginTime(lastLoginTime);
	}
	
	
	public void setDomain(UserDomain domain){
		this.mDomain = domain;;
	}
	public UserDomain getDomain(){
		return this.mDomain;
	}
	public SecUser updateDomain(UserDomain domain){
		this.mDomain = domain;;
		this.changed = true;
		return this;
	}
	public void mergeDomain(UserDomain domain){
		if(domain != null) { setDomain(domain);}
	}
	
	
	public void clearDomain(){
		setDomain ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public SecUser updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<UserApp> getUserAppList(){
		if(this.mUserAppList == null){
			this.mUserAppList = new SmartList<UserApp>();
			this.mUserAppList.setListInternalName (USER_APP_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mUserAppList;	
	}
	public  void setUserAppList(SmartList<UserApp> userAppList){
		for( UserApp userApp:userAppList){
			userApp.setSecUser(this);
		}

		this.mUserAppList = userAppList;
		this.mUserAppList.setListInternalName (USER_APP_LIST );
		
	}
	
	public  void addUserApp(UserApp userApp){
		userApp.setSecUser(this);
		getUserAppList().add(userApp);
	}
	public  void addUserAppList(SmartList<UserApp> userAppList){
		for( UserApp userApp:userAppList){
			userApp.setSecUser(this);
		}
		getUserAppList().addAll(userAppList);
	}
	public  void mergeUserAppList(SmartList<UserApp> userAppList){
		if(userAppList==null){
			return;
		}
		if(userAppList.isEmpty()){
			return;
		}
		addUserAppList( userAppList );
		
	}
	public  UserApp removeUserApp(UserApp userAppIndex){
		
		int index = getUserAppList().indexOf(userAppIndex);
        if(index < 0){
        	String message = "UserApp("+userAppIndex.getId()+") with version='"+userAppIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        UserApp userApp = getUserAppList().get(index);        
        // userApp.clearSecUser(); //disconnect with SecUser
        userApp.clearFromAll(); //disconnect with SecUser
		
		boolean result = getUserAppList().planToRemove(userApp);
        if(!result){
        	String message = "UserApp("+userAppIndex.getId()+") with version='"+userAppIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return userApp;
        
	
	}
	//断舍离
	public  void breakWithUserApp(UserApp userApp){
		
		if(userApp == null){
			return;
		}
		userApp.setSecUser(null);
		//getUserAppList().remove();
	
	}
	
	public  boolean hasUserApp(UserApp userApp){
	
		return getUserAppList().contains(userApp);
  
	}
	
	public void copyUserAppFrom(UserApp userApp) {

		UserApp userAppInList = findTheUserApp(userApp);
		UserApp newUserApp = new UserApp();
		userAppInList.copyTo(newUserApp);
		newUserApp.setVersion(0);//will trigger copy
		getUserAppList().add(newUserApp);
		addItemToFlexiableObject(COPIED_CHILD, newUserApp);
	}
	
	public  UserApp findTheUserApp(UserApp userApp){
		
		int index =  getUserAppList().indexOf(userApp);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "UserApp("+userApp.getId()+") with version='"+userApp.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getUserAppList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpUserAppList(){
		getUserAppList().clear();
	}
	
	
	


	public  SmartList<LoginHistory> getLoginHistoryList(){
		if(this.mLoginHistoryList == null){
			this.mLoginHistoryList = new SmartList<LoginHistory>();
			this.mLoginHistoryList.setListInternalName (LOGIN_HISTORY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mLoginHistoryList;	
	}
	public  void setLoginHistoryList(SmartList<LoginHistory> loginHistoryList){
		for( LoginHistory loginHistory:loginHistoryList){
			loginHistory.setSecUser(this);
		}

		this.mLoginHistoryList = loginHistoryList;
		this.mLoginHistoryList.setListInternalName (LOGIN_HISTORY_LIST );
		
	}
	
	public  void addLoginHistory(LoginHistory loginHistory){
		loginHistory.setSecUser(this);
		getLoginHistoryList().add(loginHistory);
	}
	public  void addLoginHistoryList(SmartList<LoginHistory> loginHistoryList){
		for( LoginHistory loginHistory:loginHistoryList){
			loginHistory.setSecUser(this);
		}
		getLoginHistoryList().addAll(loginHistoryList);
	}
	public  void mergeLoginHistoryList(SmartList<LoginHistory> loginHistoryList){
		if(loginHistoryList==null){
			return;
		}
		if(loginHistoryList.isEmpty()){
			return;
		}
		addLoginHistoryList( loginHistoryList );
		
	}
	public  LoginHistory removeLoginHistory(LoginHistory loginHistoryIndex){
		
		int index = getLoginHistoryList().indexOf(loginHistoryIndex);
        if(index < 0){
        	String message = "LoginHistory("+loginHistoryIndex.getId()+") with version='"+loginHistoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        LoginHistory loginHistory = getLoginHistoryList().get(index);        
        // loginHistory.clearSecUser(); //disconnect with SecUser
        loginHistory.clearFromAll(); //disconnect with SecUser
		
		boolean result = getLoginHistoryList().planToRemove(loginHistory);
        if(!result){
        	String message = "LoginHistory("+loginHistoryIndex.getId()+") with version='"+loginHistoryIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return loginHistory;
        
	
	}
	//断舍离
	public  void breakWithLoginHistory(LoginHistory loginHistory){
		
		if(loginHistory == null){
			return;
		}
		loginHistory.setSecUser(null);
		//getLoginHistoryList().remove();
	
	}
	
	public  boolean hasLoginHistory(LoginHistory loginHistory){
	
		return getLoginHistoryList().contains(loginHistory);
  
	}
	
	public void copyLoginHistoryFrom(LoginHistory loginHistory) {

		LoginHistory loginHistoryInList = findTheLoginHistory(loginHistory);
		LoginHistory newLoginHistory = new LoginHistory();
		loginHistoryInList.copyTo(newLoginHistory);
		newLoginHistory.setVersion(0);//will trigger copy
		getLoginHistoryList().add(newLoginHistory);
		addItemToFlexiableObject(COPIED_CHILD, newLoginHistory);
	}
	
	public  LoginHistory findTheLoginHistory(LoginHistory loginHistory){
		
		int index =  getLoginHistoryList().indexOf(loginHistory);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "LoginHistory("+loginHistory.getId()+") with version='"+loginHistory.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getLoginHistoryList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpLoginHistoryList(){
		getLoginHistoryList().clear();
	}
	
	
	


	public  SmartList<WechatWorkappIdentify> getWechatWorkappIdentifyList(){
		if(this.mWechatWorkappIdentifyList == null){
			this.mWechatWorkappIdentifyList = new SmartList<WechatWorkappIdentify>();
			this.mWechatWorkappIdentifyList.setListInternalName (WECHAT_WORKAPP_IDENTIFY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mWechatWorkappIdentifyList;	
	}
	public  void setWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList){
		for( WechatWorkappIdentify wechatWorkappIdentify:wechatWorkappIdentifyList){
			wechatWorkappIdentify.setSecUser(this);
		}

		this.mWechatWorkappIdentifyList = wechatWorkappIdentifyList;
		this.mWechatWorkappIdentifyList.setListInternalName (WECHAT_WORKAPP_IDENTIFY_LIST );
		
	}
	
	public  void addWechatWorkappIdentify(WechatWorkappIdentify wechatWorkappIdentify){
		wechatWorkappIdentify.setSecUser(this);
		getWechatWorkappIdentifyList().add(wechatWorkappIdentify);
	}
	public  void addWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList){
		for( WechatWorkappIdentify wechatWorkappIdentify:wechatWorkappIdentifyList){
			wechatWorkappIdentify.setSecUser(this);
		}
		getWechatWorkappIdentifyList().addAll(wechatWorkappIdentifyList);
	}
	public  void mergeWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList){
		if(wechatWorkappIdentifyList==null){
			return;
		}
		if(wechatWorkappIdentifyList.isEmpty()){
			return;
		}
		addWechatWorkappIdentifyList( wechatWorkappIdentifyList );
		
	}
	public  WechatWorkappIdentify removeWechatWorkappIdentify(WechatWorkappIdentify wechatWorkappIdentifyIndex){
		
		int index = getWechatWorkappIdentifyList().indexOf(wechatWorkappIdentifyIndex);
        if(index < 0){
        	String message = "WechatWorkappIdentify("+wechatWorkappIdentifyIndex.getId()+") with version='"+wechatWorkappIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        WechatWorkappIdentify wechatWorkappIdentify = getWechatWorkappIdentifyList().get(index);        
        // wechatWorkappIdentify.clearSecUser(); //disconnect with SecUser
        wechatWorkappIdentify.clearFromAll(); //disconnect with SecUser
		
		boolean result = getWechatWorkappIdentifyList().planToRemove(wechatWorkappIdentify);
        if(!result){
        	String message = "WechatWorkappIdentify("+wechatWorkappIdentifyIndex.getId()+") with version='"+wechatWorkappIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return wechatWorkappIdentify;
        
	
	}
	//断舍离
	public  void breakWithWechatWorkappIdentify(WechatWorkappIdentify wechatWorkappIdentify){
		
		if(wechatWorkappIdentify == null){
			return;
		}
		wechatWorkappIdentify.setSecUser(null);
		//getWechatWorkappIdentifyList().remove();
	
	}
	
	public  boolean hasWechatWorkappIdentify(WechatWorkappIdentify wechatWorkappIdentify){
	
		return getWechatWorkappIdentifyList().contains(wechatWorkappIdentify);
  
	}
	
	public void copyWechatWorkappIdentifyFrom(WechatWorkappIdentify wechatWorkappIdentify) {

		WechatWorkappIdentify wechatWorkappIdentifyInList = findTheWechatWorkappIdentify(wechatWorkappIdentify);
		WechatWorkappIdentify newWechatWorkappIdentify = new WechatWorkappIdentify();
		wechatWorkappIdentifyInList.copyTo(newWechatWorkappIdentify);
		newWechatWorkappIdentify.setVersion(0);//will trigger copy
		getWechatWorkappIdentifyList().add(newWechatWorkappIdentify);
		addItemToFlexiableObject(COPIED_CHILD, newWechatWorkappIdentify);
	}
	
	public  WechatWorkappIdentify findTheWechatWorkappIdentify(WechatWorkappIdentify wechatWorkappIdentify){
		
		int index =  getWechatWorkappIdentifyList().indexOf(wechatWorkappIdentify);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "WechatWorkappIdentify("+wechatWorkappIdentify.getId()+") with version='"+wechatWorkappIdentify.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getWechatWorkappIdentifyList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpWechatWorkappIdentifyList(){
		getWechatWorkappIdentifyList().clear();
	}
	
	
	


	public  SmartList<WechatMiniappIdentify> getWechatMiniappIdentifyList(){
		if(this.mWechatMiniappIdentifyList == null){
			this.mWechatMiniappIdentifyList = new SmartList<WechatMiniappIdentify>();
			this.mWechatMiniappIdentifyList.setListInternalName (WECHAT_MINIAPP_IDENTIFY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mWechatMiniappIdentifyList;	
	}
	public  void setWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList){
		for( WechatMiniappIdentify wechatMiniappIdentify:wechatMiniappIdentifyList){
			wechatMiniappIdentify.setSecUser(this);
		}

		this.mWechatMiniappIdentifyList = wechatMiniappIdentifyList;
		this.mWechatMiniappIdentifyList.setListInternalName (WECHAT_MINIAPP_IDENTIFY_LIST );
		
	}
	
	public  void addWechatMiniappIdentify(WechatMiniappIdentify wechatMiniappIdentify){
		wechatMiniappIdentify.setSecUser(this);
		getWechatMiniappIdentifyList().add(wechatMiniappIdentify);
	}
	public  void addWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList){
		for( WechatMiniappIdentify wechatMiniappIdentify:wechatMiniappIdentifyList){
			wechatMiniappIdentify.setSecUser(this);
		}
		getWechatMiniappIdentifyList().addAll(wechatMiniappIdentifyList);
	}
	public  void mergeWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList){
		if(wechatMiniappIdentifyList==null){
			return;
		}
		if(wechatMiniappIdentifyList.isEmpty()){
			return;
		}
		addWechatMiniappIdentifyList( wechatMiniappIdentifyList );
		
	}
	public  WechatMiniappIdentify removeWechatMiniappIdentify(WechatMiniappIdentify wechatMiniappIdentifyIndex){
		
		int index = getWechatMiniappIdentifyList().indexOf(wechatMiniappIdentifyIndex);
        if(index < 0){
        	String message = "WechatMiniappIdentify("+wechatMiniappIdentifyIndex.getId()+") with version='"+wechatMiniappIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        WechatMiniappIdentify wechatMiniappIdentify = getWechatMiniappIdentifyList().get(index);        
        // wechatMiniappIdentify.clearSecUser(); //disconnect with SecUser
        wechatMiniappIdentify.clearFromAll(); //disconnect with SecUser
		
		boolean result = getWechatMiniappIdentifyList().planToRemove(wechatMiniappIdentify);
        if(!result){
        	String message = "WechatMiniappIdentify("+wechatMiniappIdentifyIndex.getId()+") with version='"+wechatMiniappIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return wechatMiniappIdentify;
        
	
	}
	//断舍离
	public  void breakWithWechatMiniappIdentify(WechatMiniappIdentify wechatMiniappIdentify){
		
		if(wechatMiniappIdentify == null){
			return;
		}
		wechatMiniappIdentify.setSecUser(null);
		//getWechatMiniappIdentifyList().remove();
	
	}
	
	public  boolean hasWechatMiniappIdentify(WechatMiniappIdentify wechatMiniappIdentify){
	
		return getWechatMiniappIdentifyList().contains(wechatMiniappIdentify);
  
	}
	
	public void copyWechatMiniappIdentifyFrom(WechatMiniappIdentify wechatMiniappIdentify) {

		WechatMiniappIdentify wechatMiniappIdentifyInList = findTheWechatMiniappIdentify(wechatMiniappIdentify);
		WechatMiniappIdentify newWechatMiniappIdentify = new WechatMiniappIdentify();
		wechatMiniappIdentifyInList.copyTo(newWechatMiniappIdentify);
		newWechatMiniappIdentify.setVersion(0);//will trigger copy
		getWechatMiniappIdentifyList().add(newWechatMiniappIdentify);
		addItemToFlexiableObject(COPIED_CHILD, newWechatMiniappIdentify);
	}
	
	public  WechatMiniappIdentify findTheWechatMiniappIdentify(WechatMiniappIdentify wechatMiniappIdentify){
		
		int index =  getWechatMiniappIdentifyList().indexOf(wechatMiniappIdentify);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "WechatMiniappIdentify("+wechatMiniappIdentify.getId()+") with version='"+wechatMiniappIdentify.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getWechatMiniappIdentifyList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpWechatMiniappIdentifyList(){
		getWechatMiniappIdentifyList().clear();
	}
	
	
	


	public  SmartList<KeypairIdentify> getKeypairIdentifyList(){
		if(this.mKeypairIdentifyList == null){
			this.mKeypairIdentifyList = new SmartList<KeypairIdentify>();
			this.mKeypairIdentifyList.setListInternalName (KEYPAIR_IDENTIFY_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mKeypairIdentifyList;	
	}
	public  void setKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList){
		for( KeypairIdentify keypairIdentify:keypairIdentifyList){
			keypairIdentify.setSecUser(this);
		}

		this.mKeypairIdentifyList = keypairIdentifyList;
		this.mKeypairIdentifyList.setListInternalName (KEYPAIR_IDENTIFY_LIST );
		
	}
	
	public  void addKeypairIdentify(KeypairIdentify keypairIdentify){
		keypairIdentify.setSecUser(this);
		getKeypairIdentifyList().add(keypairIdentify);
	}
	public  void addKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList){
		for( KeypairIdentify keypairIdentify:keypairIdentifyList){
			keypairIdentify.setSecUser(this);
		}
		getKeypairIdentifyList().addAll(keypairIdentifyList);
	}
	public  void mergeKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList){
		if(keypairIdentifyList==null){
			return;
		}
		if(keypairIdentifyList.isEmpty()){
			return;
		}
		addKeypairIdentifyList( keypairIdentifyList );
		
	}
	public  KeypairIdentify removeKeypairIdentify(KeypairIdentify keypairIdentifyIndex){
		
		int index = getKeypairIdentifyList().indexOf(keypairIdentifyIndex);
        if(index < 0){
        	String message = "KeypairIdentify("+keypairIdentifyIndex.getId()+") with version='"+keypairIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        KeypairIdentify keypairIdentify = getKeypairIdentifyList().get(index);        
        // keypairIdentify.clearSecUser(); //disconnect with SecUser
        keypairIdentify.clearFromAll(); //disconnect with SecUser
		
		boolean result = getKeypairIdentifyList().planToRemove(keypairIdentify);
        if(!result){
        	String message = "KeypairIdentify("+keypairIdentifyIndex.getId()+") with version='"+keypairIdentifyIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return keypairIdentify;
        
	
	}
	//断舍离
	public  void breakWithKeypairIdentify(KeypairIdentify keypairIdentify){
		
		if(keypairIdentify == null){
			return;
		}
		keypairIdentify.setSecUser(null);
		//getKeypairIdentifyList().remove();
	
	}
	
	public  boolean hasKeypairIdentify(KeypairIdentify keypairIdentify){
	
		return getKeypairIdentifyList().contains(keypairIdentify);
  
	}
	
	public void copyKeypairIdentifyFrom(KeypairIdentify keypairIdentify) {

		KeypairIdentify keypairIdentifyInList = findTheKeypairIdentify(keypairIdentify);
		KeypairIdentify newKeypairIdentify = new KeypairIdentify();
		keypairIdentifyInList.copyTo(newKeypairIdentify);
		newKeypairIdentify.setVersion(0);//will trigger copy
		getKeypairIdentifyList().add(newKeypairIdentify);
		addItemToFlexiableObject(COPIED_CHILD, newKeypairIdentify);
	}
	
	public  KeypairIdentify findTheKeypairIdentify(KeypairIdentify keypairIdentify){
		
		int index =  getKeypairIdentifyList().indexOf(keypairIdentify);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "KeypairIdentify("+keypairIdentify.getId()+") with version='"+keypairIdentify.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getKeypairIdentifyList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpKeypairIdentifyList(){
		getKeypairIdentifyList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDomain(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserAppList(), internalType);
		collectFromList(this, entityList, getLoginHistoryList(), internalType);
		collectFromList(this, entityList, getWechatWorkappIdentifyList(), internalType);
		collectFromList(this, entityList, getWechatMiniappIdentifyList(), internalType);
		collectFromList(this, entityList, getKeypairIdentifyList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserAppList());
		listOfList.add( getLoginHistoryList());
		listOfList.add( getWechatWorkappIdentifyList());
		listOfList.add( getWechatMiniappIdentifyList());
		listOfList.add( getKeypairIdentifyList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, LOGIN_PROPERTY, getLogin());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
		appendKeyValuePair(result, PWD_PROPERTY, getMaskedPwd());
		appendKeyValuePair(result, WEIXIN_OPENID_PROPERTY, getWeixinOpenid());
		appendKeyValuePair(result, WEIXIN_APPID_PROPERTY, getWeixinAppid());
		appendKeyValuePair(result, ACCESS_TOKEN_PROPERTY, getAccessToken());
		appendKeyValuePair(result, VERIFICATION_CODE_PROPERTY, getVerificationCode());
		appendKeyValuePair(result, VERIFICATION_CODE_EXPIRE_PROPERTY, getVerificationCodeExpire());
		appendKeyValuePair(result, LAST_LOGIN_TIME_PROPERTY, getLastLoginTime());
		appendKeyValuePair(result, DOMAIN_PROPERTY, getDomain());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, USER_APP_LIST, getUserAppList());
		if(!getUserAppList().isEmpty()){
			appendKeyValuePair(result, "userAppCount", getUserAppList().getTotalCount());
			appendKeyValuePair(result, "userAppCurrentPageNumber", getUserAppList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, LOGIN_HISTORY_LIST, getLoginHistoryList());
		if(!getLoginHistoryList().isEmpty()){
			appendKeyValuePair(result, "loginHistoryCount", getLoginHistoryList().getTotalCount());
			appendKeyValuePair(result, "loginHistoryCurrentPageNumber", getLoginHistoryList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, WECHAT_WORKAPP_IDENTIFY_LIST, getWechatWorkappIdentifyList());
		if(!getWechatWorkappIdentifyList().isEmpty()){
			appendKeyValuePair(result, "wechatWorkappIdentifyCount", getWechatWorkappIdentifyList().getTotalCount());
			appendKeyValuePair(result, "wechatWorkappIdentifyCurrentPageNumber", getWechatWorkappIdentifyList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, WECHAT_MINIAPP_IDENTIFY_LIST, getWechatMiniappIdentifyList());
		if(!getWechatMiniappIdentifyList().isEmpty()){
			appendKeyValuePair(result, "wechatMiniappIdentifyCount", getWechatMiniappIdentifyList().getTotalCount());
			appendKeyValuePair(result, "wechatMiniappIdentifyCurrentPageNumber", getWechatMiniappIdentifyList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, KEYPAIR_IDENTIFY_LIST, getKeypairIdentifyList());
		if(!getKeypairIdentifyList().isEmpty()){
			appendKeyValuePair(result, "keypairIdentifyCount", getKeypairIdentifyList().getTotalCount());
			appendKeyValuePair(result, "keypairIdentifyCurrentPageNumber", getKeypairIdentifyList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SecUser){
		
		
			SecUser dest =(SecUser)baseDest;
		
			dest.setId(getId());
			dest.setLogin(getLogin());
			dest.setMobile(getMobile());
			dest.setEmail(getEmail());
			dest.setPwd(getPwd());
			dest.setWeixinOpenid(getWeixinOpenid());
			dest.setWeixinAppid(getWeixinAppid());
			dest.setAccessToken(getAccessToken());
			dest.setVerificationCode(getVerificationCode());
			dest.setVerificationCodeExpire(getVerificationCodeExpire());
			dest.setLastLoginTime(getLastLoginTime());
			dest.setDomain(getDomain());
			dest.setVersion(getVersion());
			dest.setUserAppList(getUserAppList());
			dest.setLoginHistoryList(getLoginHistoryList());
			dest.setWechatWorkappIdentifyList(getWechatWorkappIdentifyList());
			dest.setWechatMiniappIdentifyList(getWechatMiniappIdentifyList());
			dest.setKeypairIdentifyList(getKeypairIdentifyList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SecUser){
		
			
			SecUser dest =(SecUser)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLogin(getLogin());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergePwd(getPwd());
			dest.mergeWeixinOpenid(getWeixinOpenid());
			dest.mergeWeixinAppid(getWeixinAppid());
			dest.mergeAccessToken(getAccessToken());
			dest.mergeVerificationCode(getVerificationCode());
			dest.mergeVerificationCodeExpire(getVerificationCodeExpire());
			dest.mergeLastLoginTime(getLastLoginTime());
			dest.mergeDomain(getDomain());
			dest.mergeVersion(getVersion());
			dest.mergeUserAppList(getUserAppList());
			dest.mergeLoginHistoryList(getLoginHistoryList());
			dest.mergeWechatWorkappIdentifyList(getWechatWorkappIdentifyList());
			dest.mergeWechatMiniappIdentifyList(getWechatMiniappIdentifyList());
			dest.mergeKeypairIdentifyList(getKeypairIdentifyList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SecUser){
		
			
			SecUser dest =(SecUser)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLogin(getLogin());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergePwd(getPwd());
			dest.mergeWeixinOpenid(getWeixinOpenid());
			dest.mergeWeixinAppid(getWeixinAppid());
			dest.mergeAccessToken(getAccessToken());
			dest.mergeVerificationCode(getVerificationCode());
			dest.mergeVerificationCodeExpire(getVerificationCodeExpire());
			dest.mergeLastLoginTime(getLastLoginTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getLogin(), getMobile(), getEmail(), getPwd(), getWeixinOpenid(), getWeixinAppid(), getAccessToken(), getVerificationCode(), getVerificationCodeExpire(), getLastLoginTime(), getDomain(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SecUser{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlogin='"+getLogin()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tpwd='"+getPwd()+"';");
		stringBuilder.append("\tweixinOpenid='"+getWeixinOpenid()+"';");
		stringBuilder.append("\tweixinAppid='"+getWeixinAppid()+"';");
		stringBuilder.append("\taccessToken='"+getAccessToken()+"';");
		stringBuilder.append("\tverificationCode='"+getVerificationCode()+"';");
		stringBuilder.append("\tverificationCodeExpire='"+getVerificationCodeExpire()+"';");
		stringBuilder.append("\tlastLoginTime='"+getLastLoginTime()+"';");
		if(getDomain() != null ){
 			stringBuilder.append("\tdomain='UserDomain("+getDomain().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseVerificationCode(int incVerificationCode){
		updateVerificationCode(this.mVerificationCode +  incVerificationCode);
	}
	public void decreaseVerificationCode(int decVerificationCode){
		updateVerificationCode(this.mVerificationCode - decVerificationCode);
	}
	

}

