
package com.doublechaintech.retailscm.secuser;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.secuserblocking.SecUserBlocking;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

@JsonSerialize(using = SecUserSerializer.class)
public class SecUser extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOGIN_PROPERTY                 = "login"             ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String PWD_PROPERTY                   = "pwd"               ;
	public static final String VERIFICATION_CODE_PROPERTY     = "verificationCode"  ;
	public static final String VERIFICATION_CODE_EXPIRE_PROPERTY = "verificationCodeExpire";
	public static final String LAST_LOGIN_TIME_PROPERTY       = "lastLoginTime"     ;
	public static final String DOMAIN_PROPERTY                = "domain"            ;
	public static final String BLOCKING_PROPERTY              = "blocking"          ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String USER_APP_LIST                            = "userAppList"       ;
	public static final String LOGIN_HISTORY_LIST                       = "loginHistoryList"  ;

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
	protected		int                 	mVerificationCode   ;
	protected		DateTime            	mVerificationCodeExpire;
	protected		DateTime            	mLastLoginTime      ;
	protected		UserDomain          	mDomain             ;
	protected		SecUserBlocking     	mBlocking           ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<UserApp>  	mUserAppList        ;
	protected		SmartList<LoginHistory>	mLoginHistoryList   ;
	
		
	public 	SecUser(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDomain( null );
		setBlocking( null );

		this.changed = true;
	}
	
	public 	SecUser(String login, String mobile, String email, String pwd, int verificationCode, DateTime verificationCodeExpire, DateTime lastLoginTime, UserDomain domain, String currentStatus)
	{
		setLogin(login);
		setMobile(mobile);
		setEmail(email);
		setPwd(pwd);
		setVerificationCode(verificationCode);
		setVerificationCodeExpire(verificationCodeExpire);
		setLastLoginTime(lastLoginTime);
		setDomain(domain);
		setCurrentStatus(currentStatus);

		this.mUserAppList = new SmartList<UserApp>();
		this.mLoginHistoryList = new SmartList<LoginHistory>();	
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
	
	
	public void setClearTextOfPwd(String clearTextOfPwd){
	
		String hashedPwd = hashStringWithSHA256(clearTextOfPwd);
		setPwd(hashedPwd);
		
	}
	public String getMaskedPwd(){
	
		return "**********";
		
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
	
	
	public void clearDomain(){
		setDomain ( null );
		this.changed = true;
	}
	
	public void setBlocking(SecUserBlocking blocking){
		this.mBlocking = blocking;;
	}
	public SecUserBlocking getBlocking(){
		return this.mBlocking;
	}
	public SecUser updateBlocking(SecUserBlocking blocking){
		this.mBlocking = blocking;;
		this.changed = true;
		return this;
	}
	
	
	public void clearBlocking(){
		setBlocking ( null );
		this.changed = true;
	}
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	public SecUser updateCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
		this.changed = true;
		return this;
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
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDomain(), internalType);
		addToEntityList(this, entityList, getBlocking(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getUserAppList(), internalType);
		collectFromList(this, entityList, getLoginHistoryList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getUserAppList());
		listOfList.add( getLoginHistoryList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, LOGIN_PROPERTY, getLogin());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
		appendKeyValuePair(result, PWD_PROPERTY, getMaskedPwd());
		appendKeyValuePair(result, VERIFICATION_CODE_PROPERTY, getVerificationCode());
		appendKeyValuePair(result, VERIFICATION_CODE_EXPIRE_PROPERTY, getVerificationCodeExpire());
		appendKeyValuePair(result, LAST_LOGIN_TIME_PROPERTY, getLastLoginTime());
		appendKeyValuePair(result, DOMAIN_PROPERTY, getDomain());
		appendKeyValuePair(result, BLOCKING_PROPERTY, getBlocking());
		appendKeyValuePair(result, CURRENT_STATUS_PROPERTY, getCurrentStatus());
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
			dest.setVerificationCode(getVerificationCode());
			dest.setVerificationCodeExpire(getVerificationCodeExpire());
			dest.setLastLoginTime(getLastLoginTime());
			dest.setDomain(getDomain());
			dest.setBlocking(getBlocking());
			dest.setCurrentStatus(getCurrentStatus());
			dest.setVersion(getVersion());
			dest.setUserAppList(getUserAppList());
			dest.setLoginHistoryList(getLoginHistoryList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SecUser{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlogin='"+getLogin()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tpwd='"+getPwd()+"';");
		stringBuilder.append("\tverificationCode='"+getVerificationCode()+"';");
		stringBuilder.append("\tverificationCodeExpire='"+getVerificationCodeExpire()+"';");
		stringBuilder.append("\tlastLoginTime='"+getLastLoginTime()+"';");
		if(getDomain() != null ){
 			stringBuilder.append("\tdomain='UserDomain("+getDomain().getId()+")';");
 		}
		if(getBlocking() != null ){
 			stringBuilder.append("\tblocking='SecUserBlocking("+getBlocking().getId()+")';");
 		}
		stringBuilder.append("\tcurrentStatus='"+getCurrentStatus()+"';");
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

