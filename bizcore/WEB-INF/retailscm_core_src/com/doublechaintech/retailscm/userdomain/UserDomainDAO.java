
package com.doublechaintech.retailscm.userdomain;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.userwhitelist.UserWhiteListDAO;


public interface UserDomainDAO{

	
	public UserDomain load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<UserDomain> userDomainList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public UserDomain present(UserDomain userDomain,Map<String,Object> options) throws Exception;
	public UserDomain clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public UserDomain save(UserDomain userDomain,Map<String,Object> options);
	public SmartList<UserDomain> saveUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options);
	public SmartList<UserDomain> removeUserDomainList(SmartList<UserDomain> userDomainList,Map<String,Object> options);
	public SmartList<UserDomain> findUserDomainWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countUserDomainWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countUserDomainWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String userDomainId, int version) throws Exception;
	public UserDomain disconnectFromAll(String userDomainId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public UserWhiteListDAO getUserWhiteListDAO();
		
	public SecUserDAO getSecUserDAO();
		
	
 	public SmartList<UserDomain> requestCandidateUserDomainForUserWhiteList(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<UserDomain> requestCandidateUserDomainForSecUser(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public UserDomain planToRemoveUserWhiteListList(UserDomain userDomain, String userWhiteListIds[], Map<String,Object> options)throws Exception;


	public UserDomain planToRemoveSecUserList(UserDomain userDomain, String secUserIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<UserDomain> queryList(String sql, Object ... parmeters);
}


