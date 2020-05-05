
package com.doublechaintech.retailscm.secuser;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
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


public interface SecUserDAO extends BaseDAO{

	public SmartList<SecUser> loadAll();
	public SecUser load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SecUser> secUserList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SecUser loadByLogin(String login,Map<String,Object> options) throws Exception;
	
	
	public SecUser loadByEmail(String email,Map<String,Object> options) throws Exception;
	
	
	public SecUser loadByMobile(String mobile,Map<String,Object> options) throws Exception;
	
	
	public SecUser present(SecUser secUser,Map<String,Object> options) throws Exception;
	public SecUser clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SecUser cloneByLogin(String login,Map<String,Object> options) throws Exception;
	
	
	public SecUser cloneByEmail(String email,Map<String,Object> options) throws Exception;
	
	
	public SecUser cloneByMobile(String mobile,Map<String,Object> options) throws Exception;
	
	
	public SecUser save(SecUser secUser,Map<String,Object> options);
	public SmartList<SecUser> saveSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	public SmartList<SecUser> removeSecUserList(SmartList<SecUser> secUserList,Map<String,Object> options);
	public SmartList<SecUser> findSecUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSecUserWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSecUserWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String secUserId, int version) throws Exception;
	public SecUser disconnectFromAll(String secUserId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserAppDAO getUserAppDAO();
		
	public LoginHistoryDAO getLoginHistoryDAO();
		
	public WechatWorkappIdentifyDAO getWechatWorkappIdentifyDAO();
		
	public WechatMiniappIdentifyDAO getWechatMiniappIdentifyDAO();
		
	public KeypairIdentifyDAO getKeypairIdentifyDAO();
		
	
 	public SmartList<SecUser> requestCandidateSecUserForUserApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForLoginHistory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForWechatWorkappIdentify(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForWechatMiniappIdentify(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForKeypairIdentify(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SecUser planToRemoveUserAppList(SecUser secUser, String userAppIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with object_id in UserApp
	public SecUser planToRemoveUserAppListWithObjectId(SecUser secUser, String objectIdId, Map<String,Object> options)throws Exception;
	public int countUserAppListWithObjectId(String secUserId, String objectIdId, Map<String,Object> options)throws Exception;
	
	public SecUser planToRemoveLoginHistoryList(SecUser secUser, String loginHistoryIds[], Map<String,Object> options)throws Exception;


	public SecUser planToRemoveWechatWorkappIdentifyList(SecUser secUser, String wechatWorkappIdentifyIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with corp_id in WechatWorkappIdentify
	public SecUser planToRemoveWechatWorkappIdentifyListWithCorpId(SecUser secUser, String corpIdId, Map<String,Object> options)throws Exception;
	public int countWechatWorkappIdentifyListWithCorpId(String secUserId, String corpIdId, Map<String,Object> options)throws Exception;
	
	//disconnect SecUser with user_id in WechatWorkappIdentify
	public SecUser planToRemoveWechatWorkappIdentifyListWithUserId(SecUser secUser, String userIdId, Map<String,Object> options)throws Exception;
	public int countWechatWorkappIdentifyListWithUserId(String secUserId, String userIdId, Map<String,Object> options)throws Exception;
	
	public SecUser planToRemoveWechatMiniappIdentifyList(SecUser secUser, String wechatMiniappIdentifyIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with open_id in WechatMiniappIdentify
	public SecUser planToRemoveWechatMiniappIdentifyListWithOpenId(SecUser secUser, String openIdId, Map<String,Object> options)throws Exception;
	public int countWechatMiniappIdentifyListWithOpenId(String secUserId, String openIdId, Map<String,Object> options)throws Exception;
	
	//disconnect SecUser with app_id in WechatMiniappIdentify
	public SecUser planToRemoveWechatMiniappIdentifyListWithAppId(SecUser secUser, String appIdId, Map<String,Object> options)throws Exception;
	public int countWechatMiniappIdentifyListWithAppId(String secUserId, String appIdId, Map<String,Object> options)throws Exception;
	
	public SecUser planToRemoveKeypairIdentifyList(SecUser secUser, String keypairIdentifyIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with key_type in KeypairIdentify
	public SecUser planToRemoveKeypairIdentifyListWithKeyType(SecUser secUser, String keyTypeId, Map<String,Object> options)throws Exception;
	public int countKeypairIdentifyListWithKeyType(String secUserId, String keyTypeId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SecUser> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateSecUser executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public int countSecUserByDomain(String userDomainId, Map<String,Object> options);
 	public Map<String, Integer> countSecUserByDomainIds(String[] ids, Map<String,Object> options);
 	public SmartList<SecUser> findSecUserByDomain(String userDomainId, int start, int count, Map<String,Object> options);
 	public void analyzeSecUserByDomain(SmartList<SecUser> resultList, String userDomainId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:UserApp的secUser的UserAppList
	public SmartList<UserApp> loadOurUserAppList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:LoginHistory的secUser的LoginHistoryList
	public SmartList<LoginHistory> loadOurLoginHistoryList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WechatWorkappIdentify的secUser的WechatWorkappIdentifyList
	public SmartList<WechatWorkappIdentify> loadOurWechatWorkappIdentifyList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WechatMiniappIdentify的secUser的WechatMiniappIdentifyList
	public SmartList<WechatMiniappIdentify> loadOurWechatMiniappIdentifyList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:KeypairIdentify的secUser的KeypairIdentifyList
	public SmartList<KeypairIdentify> loadOurKeypairIdentifyList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
}


