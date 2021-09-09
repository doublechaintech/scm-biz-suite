
package com.doublechaintech.retailscm.secuser;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentity;
import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentity;
import com.doublechaintech.retailscm.userapp.UserApp;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentity;
import com.doublechaintech.retailscm.userdomain.UserDomain;
import com.doublechaintech.retailscm.loginhistory.LoginHistory;

import com.doublechaintech.retailscm.wechatworkappidentity.WechatWorkappIdentityDAO;
import com.doublechaintech.retailscm.wechatminiappidentity.WechatMiniappIdentityDAO;
import com.doublechaintech.retailscm.userdomain.UserDomainDAO;
import com.doublechaintech.retailscm.userapp.UserAppDAO;
import com.doublechaintech.retailscm.loginhistory.LoginHistoryDAO;
import com.doublechaintech.retailscm.keypairidentity.KeyPairIdentityDAO;


public interface SecUserDAO extends BaseDAO{

	public SmartList<SecUser> loadAll();
	public Stream<SecUser> loadAllAsStream();
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
	public void resetNextId();

	public UserAppDAO getUserAppDAO();
		
	public LoginHistoryDAO getLoginHistoryDAO();
		
	public WechatWorkappIdentityDAO getWechatWorkappIdentityDAO();
		
	public WechatMiniappIdentityDAO getWechatMiniappIdentityDAO();
		
	public KeyPairIdentityDAO getKeyPairIdentityDAO();
		
	
 	public SmartList<SecUser> requestCandidateSecUserForUserApp(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForLoginHistory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForWechatWorkappIdentity(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForWechatMiniappIdentity(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<SecUser> requestCandidateSecUserForKeyPairIdentity(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SecUser planToRemoveUserAppList(SecUser secUser, String userAppIds[], Map<String,Object> options)throws Exception;


	public SecUser planToRemoveLoginHistoryList(SecUser secUser, String loginHistoryIds[], Map<String,Object> options)throws Exception;


	public SecUser planToRemoveWechatWorkappIdentityList(SecUser secUser, String wechatWorkappIdentityIds[], Map<String,Object> options)throws Exception;


	public SecUser planToRemoveWechatMiniappIdentityList(SecUser secUser, String wechatMiniappIdentityIds[], Map<String,Object> options)throws Exception;


	public SecUser planToRemoveKeyPairIdentityList(SecUser secUser, String keyPairIdentityIds[], Map<String,Object> options)throws Exception;


	//disconnect SecUser with key_type in KeyPairIdentity
	public SecUser planToRemoveKeyPairIdentityListWithKeyType(SecUser secUser, String keyTypeId, Map<String,Object> options)throws Exception;
	public int countKeyPairIdentityListWithKeyType(String secUserId, String keyTypeId, Map<String,Object> options)throws Exception;
	

	public SmartList<SecUser> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<SecUser> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
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
	
	// 需要一个加载引用我的对象的enhance方法:WechatWorkappIdentity的secUser的WechatWorkappIdentityList
	public SmartList<WechatWorkappIdentity> loadOurWechatWorkappIdentityList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WechatMiniappIdentity的secUser的WechatMiniappIdentityList
	public SmartList<WechatMiniappIdentity> loadOurWechatMiniappIdentityList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:KeyPairIdentity的secUser的KeyPairIdentityList
	public SmartList<KeyPairIdentity> loadOurKeyPairIdentityList(RetailscmUserContext userContext, List<SecUser> us, Map<String,Object> options) throws Exception;
	

	List<SecUser> search(SecUserRequest pRequest);
}


