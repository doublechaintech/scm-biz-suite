
package com.doublechaintech.retailscm.secuser;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.wechatminiappidentify.WechatMiniappIdentify;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.wechatworkappidentify.WechatWorkappIdentify;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.keypairidentify.KeypairIdentify;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

import com.doublechaintech.retailscm.wechatminiappidentify.WechatMiniappIdentifyDAO;
import com.doublechaintech.retailscm.userdomain.UserDomainDAO;
import com.doublechaintech.retailscm.userapp.UserAppDAO;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryDAO;
import com.doublechaintech.retailscm.keypairidentify.KeypairIdentifyDAO;
import com.doublechaintech.retailscm.wechatworkappidentify.WechatWorkappIdentifyDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class SecUserJDBCTemplateDAO extends RetailscmBaseDAOImpl implements SecUserDAO{

	protected UserDomainDAO userDomainDAO;
	public void setUserDomainDAO(UserDomainDAO userDomainDAO){
 	
 		if(userDomainDAO == null){
 			throw new IllegalStateException("Do not try to set userDomainDAO to null.");
 		}
	 	this.userDomainDAO = userDomainDAO;
 	}
 	public UserDomainDAO getUserDomainDAO(){
 		if(this.userDomainDAO == null){
 			throw new IllegalStateException("The userDomainDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userDomainDAO;
 	}	

	protected UserAppDAO userAppDAO;
	public void setUserAppDAO(UserAppDAO userAppDAO){
 	
 		if(userAppDAO == null){
 			throw new IllegalStateException("Do not try to set userAppDAO to null.");
 		}
	 	this.userAppDAO = userAppDAO;
 	}
 	public UserAppDAO getUserAppDAO(){
 		if(this.userAppDAO == null){
 			throw new IllegalStateException("The userAppDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.userAppDAO;
 	}	

	protected LoginHistoryDAO loginHistoryDAO;
	public void setLoginHistoryDAO(LoginHistoryDAO loginHistoryDAO){
 	
 		if(loginHistoryDAO == null){
 			throw new IllegalStateException("Do not try to set loginHistoryDAO to null.");
 		}
	 	this.loginHistoryDAO = loginHistoryDAO;
 	}
 	public LoginHistoryDAO getLoginHistoryDAO(){
 		if(this.loginHistoryDAO == null){
 			throw new IllegalStateException("The loginHistoryDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.loginHistoryDAO;
 	}	

	protected WechatWorkappIdentifyDAO wechatWorkappIdentifyDAO;
	public void setWechatWorkappIdentifyDAO(WechatWorkappIdentifyDAO wechatWorkappIdentifyDAO){
 	
 		if(wechatWorkappIdentifyDAO == null){
 			throw new IllegalStateException("Do not try to set wechatWorkappIdentifyDAO to null.");
 		}
	 	this.wechatWorkappIdentifyDAO = wechatWorkappIdentifyDAO;
 	}
 	public WechatWorkappIdentifyDAO getWechatWorkappIdentifyDAO(){
 		if(this.wechatWorkappIdentifyDAO == null){
 			throw new IllegalStateException("The wechatWorkappIdentifyDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.wechatWorkappIdentifyDAO;
 	}	

	protected WechatMiniappIdentifyDAO wechatMiniappIdentifyDAO;
	public void setWechatMiniappIdentifyDAO(WechatMiniappIdentifyDAO wechatMiniappIdentifyDAO){
 	
 		if(wechatMiniappIdentifyDAO == null){
 			throw new IllegalStateException("Do not try to set wechatMiniappIdentifyDAO to null.");
 		}
	 	this.wechatMiniappIdentifyDAO = wechatMiniappIdentifyDAO;
 	}
 	public WechatMiniappIdentifyDAO getWechatMiniappIdentifyDAO(){
 		if(this.wechatMiniappIdentifyDAO == null){
 			throw new IllegalStateException("The wechatMiniappIdentifyDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.wechatMiniappIdentifyDAO;
 	}	

	protected KeypairIdentifyDAO keypairIdentifyDAO;
	public void setKeypairIdentifyDAO(KeypairIdentifyDAO keypairIdentifyDAO){
 	
 		if(keypairIdentifyDAO == null){
 			throw new IllegalStateException("Do not try to set keypairIdentifyDAO to null.");
 		}
	 	this.keypairIdentifyDAO = keypairIdentifyDAO;
 	}
 	public KeypairIdentifyDAO getKeypairIdentifyDAO(){
 		if(this.keypairIdentifyDAO == null){
 			throw new IllegalStateException("The keypairIdentifyDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.keypairIdentifyDAO;
 	}	

	
	/*
	protected SecUser load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(accessKey, options);
	}
	*/
	
	public SmartList<SecUser> loadAll() {
	    return this.loadAll(getSecUserMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public SecUser load(String id,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withId(id), options);
	}
	
	
	
	public SecUser loadByLogin(String login,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withLogin( login), options);
	}
	
	
	public SecUser loadByEmail(String email,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withEmail( email), options);
	}
	
	
	public SecUser loadByMobile(String mobile,Map<String,Object> options) throws Exception{
		return loadInternalSecUser(SecUserTable.withMobile( mobile), options);
	}
	
	
	public SecUser save(SecUser secUser,Map<String,Object> options){
		
		String methodName="save(SecUser secUser,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(secUser, methodName, "secUser");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalSecUser(secUser,options);
	}
	public SecUser clone(String secUserId, Map<String,Object> options) throws Exception{
	
		return clone(SecUserTable.withId(secUserId),options);
	}
	
	protected SecUser clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String secUserId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		SecUser newSecUser = loadInternalSecUser(accessKey, options);
		newSecUser.setVersion(0);
		
		
 		
 		if(isSaveUserAppListEnabled(options)){
 			for(UserApp item: newSecUser.getUserAppList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveLoginHistoryListEnabled(options)){
 			for(LoginHistory item: newSecUser.getLoginHistoryList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveWechatWorkappIdentifyListEnabled(options)){
 			for(WechatWorkappIdentify item: newSecUser.getWechatWorkappIdentifyList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveWechatMiniappIdentifyListEnabled(options)){
 			for(WechatMiniappIdentify item: newSecUser.getWechatMiniappIdentifyList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveKeypairIdentifyListEnabled(options)){
 			for(KeypairIdentify item: newSecUser.getKeypairIdentifyList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalSecUser(newSecUser,options);
		
		return newSecUser;
	}
	
	
	
	public SecUser cloneByLogin(String login,Map<String,Object> options) throws Exception{
		return clone(SecUserTable.withLogin( login), options);
	}
	
	
	public SecUser cloneByEmail(String email,Map<String,Object> options) throws Exception{
		return clone(SecUserTable.withEmail( email), options);
	}
	
	
	public SecUser cloneByMobile(String mobile,Map<String,Object> options) throws Exception{
		return clone(SecUserTable.withMobile( mobile), options);
	}
	
	
	

	protected void throwIfHasException(String secUserId,int version,int count) throws Exception{
		if (count == 1) {
			throw new SecUserVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new SecUserNotFoundException(
					"The " + this.getTableName() + "(" + secUserId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String secUserId, int version) throws Exception{
	
		String methodName="delete(String secUserId, int version)";
		assertMethodArgumentNotNull(secUserId, methodName, "secUserId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{secUserId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(secUserId,version);
		}
		
	
	}
	
	
	
	
	

	public SecUser disconnectFromAll(String secUserId, int version) throws Exception{
	
		
		SecUser secUser = loadInternalSecUser(SecUserTable.withId(secUserId), emptyOptions());
		secUser.clearFromAll();
		this.saveSecUser(secUser);
		return secUser;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return SecUserTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "sec_user";
	}
	@Override
	protected String getBeanName() {
		
		return "secUser";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return SecUserTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractDomainEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, SecUserTokens.DOMAIN);
 	}

 	protected boolean isSaveDomainEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, SecUserTokens.DOMAIN);
 	}
 	

 	
 
		
	
	protected boolean isExtractUserAppListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SecUserTokens.USER_APP_LIST);
 	}
 	protected boolean isAnalyzeUserAppListEnabled(Map<String,Object> options){		 		
 		return SecUserTokens.of(options).analyzeUserAppListEnabled();
 	}
	
	protected boolean isSaveUserAppListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.USER_APP_LIST);
		
 	}
 	
		
	
	protected boolean isExtractLoginHistoryListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SecUserTokens.LOGIN_HISTORY_LIST);
 	}
 	protected boolean isAnalyzeLoginHistoryListEnabled(Map<String,Object> options){		 		
 		return SecUserTokens.of(options).analyzeLoginHistoryListEnabled();
 	}
	
	protected boolean isSaveLoginHistoryListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.LOGIN_HISTORY_LIST);
		
 	}
 	
		
	
	protected boolean isExtractWechatWorkappIdentifyListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SecUserTokens.WECHAT_WORKAPP_IDENTIFY_LIST);
 	}
 	protected boolean isAnalyzeWechatWorkappIdentifyListEnabled(Map<String,Object> options){		 		
 		return SecUserTokens.of(options).analyzeWechatWorkappIdentifyListEnabled();
 	}
	
	protected boolean isSaveWechatWorkappIdentifyListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.WECHAT_WORKAPP_IDENTIFY_LIST);
		
 	}
 	
		
	
	protected boolean isExtractWechatMiniappIdentifyListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SecUserTokens.WECHAT_MINIAPP_IDENTIFY_LIST);
 	}
 	protected boolean isAnalyzeWechatMiniappIdentifyListEnabled(Map<String,Object> options){		 		
 		return SecUserTokens.of(options).analyzeWechatMiniappIdentifyListEnabled();
 	}
	
	protected boolean isSaveWechatMiniappIdentifyListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.WECHAT_MINIAPP_IDENTIFY_LIST);
		
 	}
 	
		
	
	protected boolean isExtractKeypairIdentifyListEnabled(Map<String,Object> options){		
 		return checkOptions(options,SecUserTokens.KEYPAIR_IDENTIFY_LIST);
 	}
 	protected boolean isAnalyzeKeypairIdentifyListEnabled(Map<String,Object> options){		 		
 		return SecUserTokens.of(options).analyzeKeypairIdentifyListEnabled();
 	}
	
	protected boolean isSaveKeypairIdentifyListEnabled(Map<String,Object> options){
		return checkOptions(options, SecUserTokens.KEYPAIR_IDENTIFY_LIST);
		
 	}
 	
		

	

	protected SecUserMapper getSecUserMapper(){
		return new SecUserMapper();
	}

	
	
	protected SecUser extractSecUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			SecUser secUser = loadSingleObject(accessKey, getSecUserMapper());
			return secUser;
		}catch(EmptyResultDataAccessException e){
			throw new SecUserNotFoundException("SecUser("+accessKey+") is not found!");
		}

	}

	
	

	protected SecUser loadInternalSecUser(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		SecUser secUser = extractSecUser(accessKey, loadOptions);
 	
 		if(isExtractDomainEnabled(loadOptions)){
	 		extractDomain(secUser, loadOptions);
 		}
 
		
		if(isExtractUserAppListEnabled(loadOptions)){
	 		extractUserAppList(secUser, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeUserAppListEnabled(loadOptions)){
	 		analyzeUserAppList(secUser, loadOptions);
 		}
 		
		
		if(isExtractLoginHistoryListEnabled(loadOptions)){
	 		extractLoginHistoryList(secUser, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeLoginHistoryListEnabled(loadOptions)){
	 		analyzeLoginHistoryList(secUser, loadOptions);
 		}
 		
		
		if(isExtractWechatWorkappIdentifyListEnabled(loadOptions)){
	 		extractWechatWorkappIdentifyList(secUser, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeWechatWorkappIdentifyListEnabled(loadOptions)){
	 		analyzeWechatWorkappIdentifyList(secUser, loadOptions);
 		}
 		
		
		if(isExtractWechatMiniappIdentifyListEnabled(loadOptions)){
	 		extractWechatMiniappIdentifyList(secUser, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeWechatMiniappIdentifyListEnabled(loadOptions)){
	 		analyzeWechatMiniappIdentifyList(secUser, loadOptions);
 		}
 		
		
		if(isExtractKeypairIdentifyListEnabled(loadOptions)){
	 		extractKeypairIdentifyList(secUser, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeKeypairIdentifyListEnabled(loadOptions)){
	 		analyzeKeypairIdentifyList(secUser, loadOptions);
 		}
 		
		
		return secUser;
		
	}

	 

 	protected SecUser extractDomain(SecUser secUser, Map<String,Object> options) throws Exception{

		if(secUser.getDomain() == null){
			return secUser;
		}
		String domainId = secUser.getDomain().getId();
		if( domainId == null){
			return secUser;
		}
		UserDomain domain = getUserDomainDAO().load(domainId,options);
		if(domain != null){
			secUser.setDomain(domain);
		}
		
 		
 		return secUser;
 	}
 		
 
		
	protected void enhanceUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SecUser extractUserAppList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<UserApp> userAppList = getUserAppDAO().findUserAppBySecUser(secUser.getId(),options);
		if(userAppList != null){
			enhanceUserAppList(userAppList,options);
			secUser.setUserAppList(userAppList);
		}
		
		return secUser;
	
	}	
	
	protected SecUser analyzeUserAppList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<UserApp> userAppList = secUser.getUserAppList();
		if(userAppList != null){
			getUserAppDAO().analyzeUserAppBySecUser(userAppList, secUser.getId(), options);
			
		}
		
		return secUser;
	
	}	
	
		
	protected void enhanceLoginHistoryList(SmartList<LoginHistory> loginHistoryList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SecUser extractLoginHistoryList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<LoginHistory> loginHistoryList = getLoginHistoryDAO().findLoginHistoryBySecUser(secUser.getId(),options);
		if(loginHistoryList != null){
			enhanceLoginHistoryList(loginHistoryList,options);
			secUser.setLoginHistoryList(loginHistoryList);
		}
		
		return secUser;
	
	}	
	
	protected SecUser analyzeLoginHistoryList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();
		if(loginHistoryList != null){
			getLoginHistoryDAO().analyzeLoginHistoryBySecUser(loginHistoryList, secUser.getId(), options);
			
		}
		
		return secUser;
	
	}	
	
		
	protected void enhanceWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SecUser extractWechatWorkappIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = getWechatWorkappIdentifyDAO().findWechatWorkappIdentifyBySecUser(secUser.getId(),options);
		if(wechatWorkappIdentifyList != null){
			enhanceWechatWorkappIdentifyList(wechatWorkappIdentifyList,options);
			secUser.setWechatWorkappIdentifyList(wechatWorkappIdentifyList);
		}
		
		return secUser;
	
	}	
	
	protected SecUser analyzeWechatWorkappIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = secUser.getWechatWorkappIdentifyList();
		if(wechatWorkappIdentifyList != null){
			getWechatWorkappIdentifyDAO().analyzeWechatWorkappIdentifyBySecUser(wechatWorkappIdentifyList, secUser.getId(), options);
			
		}
		
		return secUser;
	
	}	
	
		
	protected void enhanceWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SecUser extractWechatMiniappIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = getWechatMiniappIdentifyDAO().findWechatMiniappIdentifyBySecUser(secUser.getId(),options);
		if(wechatMiniappIdentifyList != null){
			enhanceWechatMiniappIdentifyList(wechatMiniappIdentifyList,options);
			secUser.setWechatMiniappIdentifyList(wechatMiniappIdentifyList);
		}
		
		return secUser;
	
	}	
	
	protected SecUser analyzeWechatMiniappIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = secUser.getWechatMiniappIdentifyList();
		if(wechatMiniappIdentifyList != null){
			getWechatMiniappIdentifyDAO().analyzeWechatMiniappIdentifyBySecUser(wechatMiniappIdentifyList, secUser.getId(), options);
			
		}
		
		return secUser;
	
	}	
	
		
	protected void enhanceKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected SecUser extractKeypairIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<KeypairIdentify> keypairIdentifyList = getKeypairIdentifyDAO().findKeypairIdentifyBySecUser(secUser.getId(),options);
		if(keypairIdentifyList != null){
			enhanceKeypairIdentifyList(keypairIdentifyList,options);
			secUser.setKeypairIdentifyList(keypairIdentifyList);
		}
		
		return secUser;
	
	}	
	
	protected SecUser analyzeKeypairIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		if(secUser == null){
			return null;
		}
		if(secUser.getId() == null){
			return secUser;
		}

		
		
		SmartList<KeypairIdentify> keypairIdentifyList = secUser.getKeypairIdentifyList();
		if(keypairIdentifyList != null){
			getKeypairIdentifyDAO().analyzeKeypairIdentifyBySecUser(keypairIdentifyList, secUser.getId(), options);
			
		}
		
		return secUser;
	
	}	
	
		
		
  	
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId,Map<String,Object> options){
 	
  		SmartList<SecUser> resultList = queryWith(SecUserTable.COLUMN_DOMAIN, userDomainId, options, getSecUserMapper());
		// analyzeSecUserByDomain(resultList, userDomainId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, int start, int count,Map<String,Object> options){
 		
 		SmartList<SecUser> resultList =  queryWithRange(SecUserTable.COLUMN_DOMAIN, userDomainId, options, getSecUserMapper(), start, count);
 		//analyzeSecUserByDomain(resultList, userDomainId, options);
 		return resultList;
 		
 	}
 	public void analyzeSecUserByDomain(SmartList<SecUser> resultList, String userDomainId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(SecUser.DOMAIN_PROPERTY, userDomainId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem verificationCodeExpireStatsItem = new StatsItem();
		//SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY
		verificationCodeExpireStatsItem.setDisplayName("SEC的用户");
		verificationCodeExpireStatsItem.setInternalName(formatKeyForDateLine(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY));
		verificationCodeExpireStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(SecUser.VERIFICATION_CODE_EXPIRE_PROPERTY),filterKey,emptyOptions));
		info.addItem(verificationCodeExpireStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countSecUserByDomain(String userDomainId,Map<String,Object> options){

 		return countWith(SecUserTable.COLUMN_DOMAIN, userDomainId, options);
 	}
 	@Override
	public Map<String, Integer> countSecUserByDomainIds(String[] ids, Map<String, Object> options) {
		return countWithIds(SecUserTable.COLUMN_DOMAIN, ids, options);
	}
 	
 	
		
		
		

	

	protected SecUser saveSecUser(SecUser  secUser){
		
		if(!secUser.isChanged()){
			return secUser;
		}
		
		
		String SQL=this.getSaveSecUserSQL(secUser);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveSecUserParameters(secUser);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		secUser.incVersion();
		return secUser;
	
	}
	public SmartList<SecUser> saveSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitSecUserList(secUserList);
		
		batchSecUserCreate((List<SecUser>)lists[CREATE_LIST_INDEX]);
		
		batchSecUserUpdate((List<SecUser>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(SecUser secUser:secUserList){
			if(secUser.isChanged()){
				secUser.incVersion();
			}
			
		
		}
		
		
		return secUserList;
	}

	public SmartList<SecUser> removeSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options){
		
		
		super.removeList(secUserList, options);
		
		return secUserList;
		
		
	}
	
	protected List<Object[]> prepareSecUserBatchCreateArgs(List<SecUser> secUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUser secUser:secUserList ){
			Object [] parameters = prepareSecUserCreateParameters(secUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareSecUserBatchUpdateArgs(List<SecUser> secUserList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(SecUser secUser:secUserList ){
			if(!secUser.isChanged()){
				continue;
			}
			Object [] parameters = prepareSecUserUpdateParameters(secUser);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchSecUserCreate(List<SecUser> secUserList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareSecUserBatchCreateArgs(secUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchSecUserUpdate(List<SecUser> secUserList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareSecUserBatchUpdateArgs(secUserList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitSecUserList(List<SecUser> secUserList){
		
		List<SecUser> secUserCreateList=new ArrayList<SecUser>();
		List<SecUser> secUserUpdateList=new ArrayList<SecUser>();
		
		for(SecUser secUser: secUserList){
			if(isUpdateRequest(secUser)){
				secUserUpdateList.add( secUser);
				continue;
			}
			secUserCreateList.add(secUser);
		}
		
		return new Object[]{secUserCreateList,secUserUpdateList};
	}
	
	protected boolean isUpdateRequest(SecUser secUser){
 		return secUser.getVersion() > 0;
 	}
 	protected String getSaveSecUserSQL(SecUser secUser){
 		if(isUpdateRequest(secUser)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveSecUserParameters(SecUser secUser){
 		if(isUpdateRequest(secUser) ){
 			return prepareSecUserUpdateParameters(secUser);
 		}
 		return prepareSecUserCreateParameters(secUser);
 	}
 	protected Object[] prepareSecUserUpdateParameters(SecUser secUser){
 		Object[] parameters = new Object[14];
 
 		
 		parameters[0] = secUser.getLogin();
 		
 		
 		parameters[1] = secUser.getMobile();
 		
 		
 		parameters[2] = secUser.getEmail();
 		
 		
 		parameters[3] = secUser.getPwd();
 		
 		
 		parameters[4] = secUser.getWeixinOpenid();
 		
 		
 		parameters[5] = secUser.getWeixinAppid();
 		
 		
 		parameters[6] = secUser.getAccessToken();
 		
 		
 		parameters[7] = secUser.getVerificationCode();
 		
 		
 		parameters[8] = secUser.getVerificationCodeExpire();
 		
 		
 		parameters[9] = secUser.getLastLoginTime();
 		 	
 		if(secUser.getDomain() != null){
 			parameters[10] = secUser.getDomain().getId();
 		}
 		
 		parameters[11] = secUser.nextVersion();
 		parameters[12] = secUser.getId();
 		parameters[13] = secUser.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareSecUserCreateParameters(SecUser secUser){
		Object[] parameters = new Object[12];
		String newSecUserId=getNextId();
		secUser.setId(newSecUserId);
		parameters[0] =  secUser.getId();
 
 		
 		parameters[1] = secUser.getLogin();
 		
 		
 		parameters[2] = secUser.getMobile();
 		
 		
 		parameters[3] = secUser.getEmail();
 		
 		
 		parameters[4] = secUser.getPwd();
 		
 		
 		parameters[5] = secUser.getWeixinOpenid();
 		
 		
 		parameters[6] = secUser.getWeixinAppid();
 		
 		
 		parameters[7] = secUser.getAccessToken();
 		
 		
 		parameters[8] = secUser.getVerificationCode();
 		
 		
 		parameters[9] = secUser.getVerificationCodeExpire();
 		
 		
 		parameters[10] = secUser.getLastLoginTime();
 		 	
 		if(secUser.getDomain() != null){
 			parameters[11] = secUser.getDomain().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected SecUser saveInternalSecUser(SecUser secUser, Map<String,Object> options){
		
		saveSecUser(secUser);
 	
 		if(isSaveDomainEnabled(options)){
	 		saveDomain(secUser, options);
 		}
 
		
		if(isSaveUserAppListEnabled(options)){
	 		saveUserAppList(secUser, options);
	 		//removeUserAppList(secUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveLoginHistoryListEnabled(options)){
	 		saveLoginHistoryList(secUser, options);
	 		//removeLoginHistoryList(secUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveWechatWorkappIdentifyListEnabled(options)){
	 		saveWechatWorkappIdentifyList(secUser, options);
	 		//removeWechatWorkappIdentifyList(secUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveWechatMiniappIdentifyListEnabled(options)){
	 		saveWechatMiniappIdentifyList(secUser, options);
	 		//removeWechatMiniappIdentifyList(secUser, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveKeypairIdentifyListEnabled(options)){
	 		saveKeypairIdentifyList(secUser, options);
	 		//removeKeypairIdentifyList(secUser, options);
	 		//Not delete the record
	 		
 		}		
		
		return secUser;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected SecUser saveDomain(SecUser secUser, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(secUser.getDomain() == null){
 			return secUser;//do nothing when it is null
 		}
 		
 		getUserDomainDAO().save(secUser.getDomain(),options);
 		return secUser;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public SecUser planToRemoveUserAppList(SecUser secUser, String userAppIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.ID_PROPERTY, userAppIds);
		
		SmartList<UserApp> externalUserAppList = getUserAppDAO().
				findUserAppWithKey(key, options);
		if(externalUserAppList == null){
			return secUser;
		}
		if(externalUserAppList.isEmpty()){
			return secUser;
		}
		
		for(UserApp userAppItem: externalUserAppList){

			userAppItem.clearFromAll();
		}
		
		
		SmartList<UserApp> userAppList = secUser.getUserAppList();		
		userAppList.addAllToRemoveList(externalUserAppList);
		return secUser;	
	
	}


	//disconnect SecUser with object_id in UserApp
	public SecUser planToRemoveUserAppListWithObjectId(SecUser secUser, String objectIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUser.getId());
		key.put(UserApp.OBJECT_ID_PROPERTY, objectIdId);
		
		SmartList<UserApp> externalUserAppList = getUserAppDAO().
				findUserAppWithKey(key, options);
		if(externalUserAppList == null){
			return secUser;
		}
		if(externalUserAppList.isEmpty()){
			return secUser;
		}
		
		for(UserApp userAppItem: externalUserAppList){
			userAppItem.clearObjectId();
			userAppItem.clearSecUser();
			
		}
		
		
		SmartList<UserApp> userAppList = secUser.getUserAppList();		
		userAppList.addAllToRemoveList(externalUserAppList);
		return secUser;
	}
	
	public int countUserAppListWithObjectId(String secUserId, String objectIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, secUserId);
		key.put(UserApp.OBJECT_ID_PROPERTY, objectIdId);
		
		int count = getUserAppDAO().countUserAppWithKey(key, options);
		return count;
	}
	
	public SecUser planToRemoveLoginHistoryList(SecUser secUser, String loginHistoryIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LoginHistory.SEC_USER_PROPERTY, secUser.getId());
		key.put(LoginHistory.ID_PROPERTY, loginHistoryIds);
		
		SmartList<LoginHistory> externalLoginHistoryList = getLoginHistoryDAO().
				findLoginHistoryWithKey(key, options);
		if(externalLoginHistoryList == null){
			return secUser;
		}
		if(externalLoginHistoryList.isEmpty()){
			return secUser;
		}
		
		for(LoginHistory loginHistoryItem: externalLoginHistoryList){

			loginHistoryItem.clearFromAll();
		}
		
		
		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();		
		loginHistoryList.addAllToRemoveList(externalLoginHistoryList);
		return secUser;	
	
	}


	public SecUser planToRemoveWechatWorkappIdentifyList(SecUser secUser, String wechatWorkappIdentifyIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatWorkappIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(WechatWorkappIdentify.ID_PROPERTY, wechatWorkappIdentifyIds);
		
		SmartList<WechatWorkappIdentify> externalWechatWorkappIdentifyList = getWechatWorkappIdentifyDAO().
				findWechatWorkappIdentifyWithKey(key, options);
		if(externalWechatWorkappIdentifyList == null){
			return secUser;
		}
		if(externalWechatWorkappIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(WechatWorkappIdentify wechatWorkappIdentifyItem: externalWechatWorkappIdentifyList){

			wechatWorkappIdentifyItem.clearFromAll();
		}
		
		
		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = secUser.getWechatWorkappIdentifyList();		
		wechatWorkappIdentifyList.addAllToRemoveList(externalWechatWorkappIdentifyList);
		return secUser;	
	
	}


	//disconnect SecUser with corp_id in WechatWorkappIdentify
	public SecUser planToRemoveWechatWorkappIdentifyListWithCorpId(SecUser secUser, String corpIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatWorkappIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(WechatWorkappIdentify.CORP_ID_PROPERTY, corpIdId);
		
		SmartList<WechatWorkappIdentify> externalWechatWorkappIdentifyList = getWechatWorkappIdentifyDAO().
				findWechatWorkappIdentifyWithKey(key, options);
		if(externalWechatWorkappIdentifyList == null){
			return secUser;
		}
		if(externalWechatWorkappIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(WechatWorkappIdentify wechatWorkappIdentifyItem: externalWechatWorkappIdentifyList){
			wechatWorkappIdentifyItem.clearCorpId();
			wechatWorkappIdentifyItem.clearSecUser();
			
		}
		
		
		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = secUser.getWechatWorkappIdentifyList();		
		wechatWorkappIdentifyList.addAllToRemoveList(externalWechatWorkappIdentifyList);
		return secUser;
	}
	
	public int countWechatWorkappIdentifyListWithCorpId(String secUserId, String corpIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatWorkappIdentify.SEC_USER_PROPERTY, secUserId);
		key.put(WechatWorkappIdentify.CORP_ID_PROPERTY, corpIdId);
		
		int count = getWechatWorkappIdentifyDAO().countWechatWorkappIdentifyWithKey(key, options);
		return count;
	}
	
	//disconnect SecUser with user_id in WechatWorkappIdentify
	public SecUser planToRemoveWechatWorkappIdentifyListWithUserId(SecUser secUser, String userIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatWorkappIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(WechatWorkappIdentify.USER_ID_PROPERTY, userIdId);
		
		SmartList<WechatWorkappIdentify> externalWechatWorkappIdentifyList = getWechatWorkappIdentifyDAO().
				findWechatWorkappIdentifyWithKey(key, options);
		if(externalWechatWorkappIdentifyList == null){
			return secUser;
		}
		if(externalWechatWorkappIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(WechatWorkappIdentify wechatWorkappIdentifyItem: externalWechatWorkappIdentifyList){
			wechatWorkappIdentifyItem.clearUserId();
			wechatWorkappIdentifyItem.clearSecUser();
			
		}
		
		
		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = secUser.getWechatWorkappIdentifyList();		
		wechatWorkappIdentifyList.addAllToRemoveList(externalWechatWorkappIdentifyList);
		return secUser;
	}
	
	public int countWechatWorkappIdentifyListWithUserId(String secUserId, String userIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatWorkappIdentify.SEC_USER_PROPERTY, secUserId);
		key.put(WechatWorkappIdentify.USER_ID_PROPERTY, userIdId);
		
		int count = getWechatWorkappIdentifyDAO().countWechatWorkappIdentifyWithKey(key, options);
		return count;
	}
	
	public SecUser planToRemoveWechatMiniappIdentifyList(SecUser secUser, String wechatMiniappIdentifyIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatMiniappIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(WechatMiniappIdentify.ID_PROPERTY, wechatMiniappIdentifyIds);
		
		SmartList<WechatMiniappIdentify> externalWechatMiniappIdentifyList = getWechatMiniappIdentifyDAO().
				findWechatMiniappIdentifyWithKey(key, options);
		if(externalWechatMiniappIdentifyList == null){
			return secUser;
		}
		if(externalWechatMiniappIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(WechatMiniappIdentify wechatMiniappIdentifyItem: externalWechatMiniappIdentifyList){

			wechatMiniappIdentifyItem.clearFromAll();
		}
		
		
		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = secUser.getWechatMiniappIdentifyList();		
		wechatMiniappIdentifyList.addAllToRemoveList(externalWechatMiniappIdentifyList);
		return secUser;	
	
	}


	//disconnect SecUser with open_id in WechatMiniappIdentify
	public SecUser planToRemoveWechatMiniappIdentifyListWithOpenId(SecUser secUser, String openIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatMiniappIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(WechatMiniappIdentify.OPEN_ID_PROPERTY, openIdId);
		
		SmartList<WechatMiniappIdentify> externalWechatMiniappIdentifyList = getWechatMiniappIdentifyDAO().
				findWechatMiniappIdentifyWithKey(key, options);
		if(externalWechatMiniappIdentifyList == null){
			return secUser;
		}
		if(externalWechatMiniappIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(WechatMiniappIdentify wechatMiniappIdentifyItem: externalWechatMiniappIdentifyList){
			wechatMiniappIdentifyItem.clearOpenId();
			wechatMiniappIdentifyItem.clearSecUser();
			
		}
		
		
		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = secUser.getWechatMiniappIdentifyList();		
		wechatMiniappIdentifyList.addAllToRemoveList(externalWechatMiniappIdentifyList);
		return secUser;
	}
	
	public int countWechatMiniappIdentifyListWithOpenId(String secUserId, String openIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatMiniappIdentify.SEC_USER_PROPERTY, secUserId);
		key.put(WechatMiniappIdentify.OPEN_ID_PROPERTY, openIdId);
		
		int count = getWechatMiniappIdentifyDAO().countWechatMiniappIdentifyWithKey(key, options);
		return count;
	}
	
	//disconnect SecUser with app_id in WechatMiniappIdentify
	public SecUser planToRemoveWechatMiniappIdentifyListWithAppId(SecUser secUser, String appIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatMiniappIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(WechatMiniappIdentify.APP_ID_PROPERTY, appIdId);
		
		SmartList<WechatMiniappIdentify> externalWechatMiniappIdentifyList = getWechatMiniappIdentifyDAO().
				findWechatMiniappIdentifyWithKey(key, options);
		if(externalWechatMiniappIdentifyList == null){
			return secUser;
		}
		if(externalWechatMiniappIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(WechatMiniappIdentify wechatMiniappIdentifyItem: externalWechatMiniappIdentifyList){
			wechatMiniappIdentifyItem.clearAppId();
			wechatMiniappIdentifyItem.clearSecUser();
			
		}
		
		
		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = secUser.getWechatMiniappIdentifyList();		
		wechatMiniappIdentifyList.addAllToRemoveList(externalWechatMiniappIdentifyList);
		return secUser;
	}
	
	public int countWechatMiniappIdentifyListWithAppId(String secUserId, String appIdId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatMiniappIdentify.SEC_USER_PROPERTY, secUserId);
		key.put(WechatMiniappIdentify.APP_ID_PROPERTY, appIdId);
		
		int count = getWechatMiniappIdentifyDAO().countWechatMiniappIdentifyWithKey(key, options);
		return count;
	}
	
	public SecUser planToRemoveKeypairIdentifyList(SecUser secUser, String keypairIdentifyIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(KeypairIdentify.ID_PROPERTY, keypairIdentifyIds);
		
		SmartList<KeypairIdentify> externalKeypairIdentifyList = getKeypairIdentifyDAO().
				findKeypairIdentifyWithKey(key, options);
		if(externalKeypairIdentifyList == null){
			return secUser;
		}
		if(externalKeypairIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(KeypairIdentify keypairIdentifyItem: externalKeypairIdentifyList){

			keypairIdentifyItem.clearFromAll();
		}
		
		
		SmartList<KeypairIdentify> keypairIdentifyList = secUser.getKeypairIdentifyList();		
		keypairIdentifyList.addAllToRemoveList(externalKeypairIdentifyList);
		return secUser;	
	
	}


	//disconnect SecUser with key_type in KeypairIdentify
	public SecUser planToRemoveKeypairIdentifyListWithKeyType(SecUser secUser, String keyTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentify.SEC_USER_PROPERTY, secUser.getId());
		key.put(KeypairIdentify.KEY_TYPE_PROPERTY, keyTypeId);
		
		SmartList<KeypairIdentify> externalKeypairIdentifyList = getKeypairIdentifyDAO().
				findKeypairIdentifyWithKey(key, options);
		if(externalKeypairIdentifyList == null){
			return secUser;
		}
		if(externalKeypairIdentifyList.isEmpty()){
			return secUser;
		}
		
		for(KeypairIdentify keypairIdentifyItem: externalKeypairIdentifyList){
			keypairIdentifyItem.clearKeyType();
			keypairIdentifyItem.clearSecUser();
			
		}
		
		
		SmartList<KeypairIdentify> keypairIdentifyList = secUser.getKeypairIdentifyList();		
		keypairIdentifyList.addAllToRemoveList(externalKeypairIdentifyList);
		return secUser;
	}
	
	public int countKeypairIdentifyListWithKeyType(String secUserId, String keyTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentify.SEC_USER_PROPERTY, secUserId);
		key.put(KeypairIdentify.KEY_TYPE_PROPERTY, keyTypeId);
		
		int count = getKeypairIdentifyDAO().countKeypairIdentifyWithKey(key, options);
		return count;
	}
	

		
	protected SecUser saveUserAppList(SecUser secUser, Map<String,Object> options){
		
		
		
		
		SmartList<UserApp> userAppList = secUser.getUserAppList();
		if(userAppList == null){
			//null list means nothing
			return secUser;
		}
		SmartList<UserApp> mergedUpdateUserAppList = new SmartList<UserApp>();
		
		
		mergedUpdateUserAppList.addAll(userAppList); 
		if(userAppList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateUserAppList.addAll(userAppList.getToRemoveList());
			userAppList.removeAll(userAppList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getUserAppDAO().saveUserAppList(mergedUpdateUserAppList,options);
		
		if(userAppList.getToRemoveList() != null){
			userAppList.removeAll(userAppList.getToRemoveList());
		}
		
		
		return secUser;
	
	}
	
	protected SecUser removeUserAppList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<UserApp> userAppList = secUser.getUserAppList();
		if(userAppList == null){
			return secUser;
		}	
	
		SmartList<UserApp> toRemoveUserAppList = userAppList.getToRemoveList();
		
		if(toRemoveUserAppList == null){
			return secUser;
		}
		if(toRemoveUserAppList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getUserAppDAO().removeUserAppList(toRemoveUserAppList,options);
		
		return secUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected SecUser saveLoginHistoryList(SecUser secUser, Map<String,Object> options){
		
		
		
		
		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();
		if(loginHistoryList == null){
			//null list means nothing
			return secUser;
		}
		SmartList<LoginHistory> mergedUpdateLoginHistoryList = new SmartList<LoginHistory>();
		
		
		mergedUpdateLoginHistoryList.addAll(loginHistoryList); 
		if(loginHistoryList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateLoginHistoryList.addAll(loginHistoryList.getToRemoveList());
			loginHistoryList.removeAll(loginHistoryList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getLoginHistoryDAO().saveLoginHistoryList(mergedUpdateLoginHistoryList,options);
		
		if(loginHistoryList.getToRemoveList() != null){
			loginHistoryList.removeAll(loginHistoryList.getToRemoveList());
		}
		
		
		return secUser;
	
	}
	
	protected SecUser removeLoginHistoryList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();
		if(loginHistoryList == null){
			return secUser;
		}	
	
		SmartList<LoginHistory> toRemoveLoginHistoryList = loginHistoryList.getToRemoveList();
		
		if(toRemoveLoginHistoryList == null){
			return secUser;
		}
		if(toRemoveLoginHistoryList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getLoginHistoryDAO().removeLoginHistoryList(toRemoveLoginHistoryList,options);
		
		return secUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected SecUser saveWechatWorkappIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		
		
		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = secUser.getWechatWorkappIdentifyList();
		if(wechatWorkappIdentifyList == null){
			//null list means nothing
			return secUser;
		}
		SmartList<WechatWorkappIdentify> mergedUpdateWechatWorkappIdentifyList = new SmartList<WechatWorkappIdentify>();
		
		
		mergedUpdateWechatWorkappIdentifyList.addAll(wechatWorkappIdentifyList); 
		if(wechatWorkappIdentifyList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateWechatWorkappIdentifyList.addAll(wechatWorkappIdentifyList.getToRemoveList());
			wechatWorkappIdentifyList.removeAll(wechatWorkappIdentifyList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getWechatWorkappIdentifyDAO().saveWechatWorkappIdentifyList(mergedUpdateWechatWorkappIdentifyList,options);
		
		if(wechatWorkappIdentifyList.getToRemoveList() != null){
			wechatWorkappIdentifyList.removeAll(wechatWorkappIdentifyList.getToRemoveList());
		}
		
		
		return secUser;
	
	}
	
	protected SecUser removeWechatWorkappIdentifyList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = secUser.getWechatWorkappIdentifyList();
		if(wechatWorkappIdentifyList == null){
			return secUser;
		}	
	
		SmartList<WechatWorkappIdentify> toRemoveWechatWorkappIdentifyList = wechatWorkappIdentifyList.getToRemoveList();
		
		if(toRemoveWechatWorkappIdentifyList == null){
			return secUser;
		}
		if(toRemoveWechatWorkappIdentifyList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getWechatWorkappIdentifyDAO().removeWechatWorkappIdentifyList(toRemoveWechatWorkappIdentifyList,options);
		
		return secUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected SecUser saveWechatMiniappIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		
		
		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = secUser.getWechatMiniappIdentifyList();
		if(wechatMiniappIdentifyList == null){
			//null list means nothing
			return secUser;
		}
		SmartList<WechatMiniappIdentify> mergedUpdateWechatMiniappIdentifyList = new SmartList<WechatMiniappIdentify>();
		
		
		mergedUpdateWechatMiniappIdentifyList.addAll(wechatMiniappIdentifyList); 
		if(wechatMiniappIdentifyList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateWechatMiniappIdentifyList.addAll(wechatMiniappIdentifyList.getToRemoveList());
			wechatMiniappIdentifyList.removeAll(wechatMiniappIdentifyList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getWechatMiniappIdentifyDAO().saveWechatMiniappIdentifyList(mergedUpdateWechatMiniappIdentifyList,options);
		
		if(wechatMiniappIdentifyList.getToRemoveList() != null){
			wechatMiniappIdentifyList.removeAll(wechatMiniappIdentifyList.getToRemoveList());
		}
		
		
		return secUser;
	
	}
	
	protected SecUser removeWechatMiniappIdentifyList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = secUser.getWechatMiniappIdentifyList();
		if(wechatMiniappIdentifyList == null){
			return secUser;
		}	
	
		SmartList<WechatMiniappIdentify> toRemoveWechatMiniappIdentifyList = wechatMiniappIdentifyList.getToRemoveList();
		
		if(toRemoveWechatMiniappIdentifyList == null){
			return secUser;
		}
		if(toRemoveWechatMiniappIdentifyList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getWechatMiniappIdentifyDAO().removeWechatMiniappIdentifyList(toRemoveWechatMiniappIdentifyList,options);
		
		return secUser;
	
	}
	
	

 	
 	
	
	
	
		
	protected SecUser saveKeypairIdentifyList(SecUser secUser, Map<String,Object> options){
		
		
		
		
		SmartList<KeypairIdentify> keypairIdentifyList = secUser.getKeypairIdentifyList();
		if(keypairIdentifyList == null){
			//null list means nothing
			return secUser;
		}
		SmartList<KeypairIdentify> mergedUpdateKeypairIdentifyList = new SmartList<KeypairIdentify>();
		
		
		mergedUpdateKeypairIdentifyList.addAll(keypairIdentifyList); 
		if(keypairIdentifyList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateKeypairIdentifyList.addAll(keypairIdentifyList.getToRemoveList());
			keypairIdentifyList.removeAll(keypairIdentifyList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getKeypairIdentifyDAO().saveKeypairIdentifyList(mergedUpdateKeypairIdentifyList,options);
		
		if(keypairIdentifyList.getToRemoveList() != null){
			keypairIdentifyList.removeAll(keypairIdentifyList.getToRemoveList());
		}
		
		
		return secUser;
	
	}
	
	protected SecUser removeKeypairIdentifyList(SecUser secUser, Map<String,Object> options){
	
	
		SmartList<KeypairIdentify> keypairIdentifyList = secUser.getKeypairIdentifyList();
		if(keypairIdentifyList == null){
			return secUser;
		}	
	
		SmartList<KeypairIdentify> toRemoveKeypairIdentifyList = keypairIdentifyList.getToRemoveList();
		
		if(toRemoveKeypairIdentifyList == null){
			return secUser;
		}
		if(toRemoveKeypairIdentifyList.isEmpty()){
			return secUser;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getKeypairIdentifyDAO().removeKeypairIdentifyList(toRemoveKeypairIdentifyList,options);
		
		return secUser;
	
	}
	
	

 	
 	
	
	
	
		

	public SecUser present(SecUser secUser,Map<String, Object> options){
	
		presentUserAppList(secUser,options);
		presentLoginHistoryList(secUser,options);
		presentWechatWorkappIdentifyList(secUser,options);
		presentWechatMiniappIdentifyList(secUser,options);
		presentKeypairIdentifyList(secUser,options);

		return secUser;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected SecUser presentUserAppList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<UserApp> userAppList = secUser.getUserAppList();		
				SmartList<UserApp> newList= presentSubList(secUser.getId(),
				userAppList,
				options,
				getUserAppDAO()::countUserAppBySecUser,
				getUserAppDAO()::findUserAppBySecUser
				);

		
		secUser.setUserAppList(newList);
		

		return secUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SecUser presentLoginHistoryList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<LoginHistory> loginHistoryList = secUser.getLoginHistoryList();		
				SmartList<LoginHistory> newList= presentSubList(secUser.getId(),
				loginHistoryList,
				options,
				getLoginHistoryDAO()::countLoginHistoryBySecUser,
				getLoginHistoryDAO()::findLoginHistoryBySecUser
				);

		
		secUser.setLoginHistoryList(newList);
		

		return secUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SecUser presentWechatWorkappIdentifyList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList = secUser.getWechatWorkappIdentifyList();		
				SmartList<WechatWorkappIdentify> newList= presentSubList(secUser.getId(),
				wechatWorkappIdentifyList,
				options,
				getWechatWorkappIdentifyDAO()::countWechatWorkappIdentifyBySecUser,
				getWechatWorkappIdentifyDAO()::findWechatWorkappIdentifyBySecUser
				);

		
		secUser.setWechatWorkappIdentifyList(newList);
		

		return secUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SecUser presentWechatMiniappIdentifyList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList = secUser.getWechatMiniappIdentifyList();		
				SmartList<WechatMiniappIdentify> newList= presentSubList(secUser.getId(),
				wechatMiniappIdentifyList,
				options,
				getWechatMiniappIdentifyDAO()::countWechatMiniappIdentifyBySecUser,
				getWechatMiniappIdentifyDAO()::findWechatMiniappIdentifyBySecUser
				);

		
		secUser.setWechatMiniappIdentifyList(newList);
		

		return secUser;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected SecUser presentKeypairIdentifyList(
			SecUser secUser,
			Map<String, Object> options) {

		SmartList<KeypairIdentify> keypairIdentifyList = secUser.getKeypairIdentifyList();		
				SmartList<KeypairIdentify> newList= presentSubList(secUser.getId(),
				keypairIdentifyList,
				options,
				getKeypairIdentifyDAO()::countKeypairIdentifyBySecUser,
				getKeypairIdentifyDAO()::findKeypairIdentifyBySecUser
				);

		
		secUser.setKeypairIdentifyList(newList);
		

		return secUser;
	}			
		

	
    public SmartList<SecUser> requestCandidateSecUserForUserApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserTable.COLUMN_LOGIN, SecUserTable.COLUMN_DOMAIN, filterKey, pageNo, pageSize, getSecUserMapper());
    }
		
    public SmartList<SecUser> requestCandidateSecUserForLoginHistory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserTable.COLUMN_LOGIN, SecUserTable.COLUMN_DOMAIN, filterKey, pageNo, pageSize, getSecUserMapper());
    }
		
    public SmartList<SecUser> requestCandidateSecUserForWechatWorkappIdentify(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserTable.COLUMN_LOGIN, SecUserTable.COLUMN_DOMAIN, filterKey, pageNo, pageSize, getSecUserMapper());
    }
		
    public SmartList<SecUser> requestCandidateSecUserForWechatMiniappIdentify(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserTable.COLUMN_LOGIN, SecUserTable.COLUMN_DOMAIN, filterKey, pageNo, pageSize, getSecUserMapper());
    }
		
    public SmartList<SecUser> requestCandidateSecUserForKeypairIdentify(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(SecUserTable.COLUMN_LOGIN, SecUserTable.COLUMN_DOMAIN, filterKey, pageNo, pageSize, getSecUserMapper());
    }
		

	protected String getTableName(){
		return SecUserTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<SecUser> secUserList) {		
		this.enhanceListInternal(secUserList, this.getSecUserMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:UserApp的secUser的UserAppList
	public SmartList<UserApp> loadOurUserAppList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(UserApp.SEC_USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<UserApp> loadedObjs = userContext.getDAOGroup().getUserAppDAO().findUserAppWithKey(key, options);
		Map<String, List<UserApp>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getSecUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<UserApp> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<UserApp> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setUserAppList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:LoginHistory的secUser的LoginHistoryList
	public SmartList<LoginHistory> loadOurLoginHistoryList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(LoginHistory.SEC_USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<LoginHistory> loadedObjs = userContext.getDAOGroup().getLoginHistoryDAO().findLoginHistoryWithKey(key, options);
		Map<String, List<LoginHistory>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getSecUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<LoginHistory> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<LoginHistory> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setLoginHistoryList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:WechatWorkappIdentify的secUser的WechatWorkappIdentifyList
	public SmartList<WechatWorkappIdentify> loadOurWechatWorkappIdentifyList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatWorkappIdentify.SEC_USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<WechatWorkappIdentify> loadedObjs = userContext.getDAOGroup().getWechatWorkappIdentifyDAO().findWechatWorkappIdentifyWithKey(key, options);
		Map<String, List<WechatWorkappIdentify>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getSecUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<WechatWorkappIdentify> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<WechatWorkappIdentify> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setWechatWorkappIdentifyList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:WechatMiniappIdentify的secUser的WechatMiniappIdentifyList
	public SmartList<WechatMiniappIdentify> loadOurWechatMiniappIdentifyList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(WechatMiniappIdentify.SEC_USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<WechatMiniappIdentify> loadedObjs = userContext.getDAOGroup().getWechatMiniappIdentifyDAO().findWechatMiniappIdentifyWithKey(key, options);
		Map<String, List<WechatMiniappIdentify>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getSecUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<WechatMiniappIdentify> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<WechatMiniappIdentify> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setWechatMiniappIdentifyList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:KeypairIdentify的secUser的KeypairIdentifyList
	public SmartList<KeypairIdentify> loadOurKeypairIdentifyList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(KeypairIdentify.SEC_USER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<KeypairIdentify> loadedObjs = userContext.getDAOGroup().getKeypairIdentifyDAO().findKeypairIdentifyWithKey(key, options);
		Map<String, List<KeypairIdentify>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getSecUser().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<KeypairIdentify> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<KeypairIdentify> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setKeypairIdentifyList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<SecUser> secUserList = ownerEntity.collectRefsWithType(SecUser.INTERNAL_TYPE);
		this.enhanceList(secUserList);
		
	}
	
	@Override
	public SmartList<SecUser> findSecUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getSecUserMapper());

	}
	@Override
	public int countSecUserWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countSecUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<SecUser> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getSecUserMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateSecUser executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateSecUser result = new CandidateSecUser();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}
	
	

}


