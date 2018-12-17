
package com.doublechaintech.retailscm.userapp;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.listaccess.ListAccessDAO;
import com.doublechaintech.retailscm.objectaccess.ObjectAccessDAO;


public interface UserAppDAO{

	
	public UserApp load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserApp> userAppList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserApp present(UserApp userApp,Map<String,Object> options) throws Exception;
	public UserApp clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserApp save(UserApp userApp,Map<String,Object> options);
	public SmartList<UserApp> saveUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	public SmartList<UserApp> removeUserAppList(SmartList<UserApp> userAppList,Map<String,Object> options);
	public SmartList<UserApp> findUserAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserAppWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userAppId, int version) throws Exception;
	public UserApp disconnectFromAll(String userAppId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ListAccessDAO getListAccessDAO();
		
	public ObjectAccessDAO getObjectAccessDAO();
		
	
 	public SmartList<UserApp> requestCandidateUserAppForListAccess(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserApp> requestCandidateUserAppForObjectAccess(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public UserApp planToRemoveListAccessList(UserApp userApp, String listAccessIds[], Map<String,Object> options)throws Exception;


	public UserApp planToRemoveObjectAccessList(UserApp userApp, String objectAccessIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<UserApp> queryList(String sql, Object ... parmeters);
 
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public int countUserAppBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countUserAppBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<UserApp> findUserAppBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeUserAppBySecUser(SmartList<UserApp> resultList, String secUserId, Map<String,Object> options);

 
 }


