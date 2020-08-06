
package com.doublechaintech.retailscm.wechatworkappidentity;
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

import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.SecUserDAO;


public interface WechatWorkappIdentityDAO extends BaseDAO{

	public SmartList<WechatWorkappIdentity> loadAll();
	public Stream<WechatWorkappIdentity> loadAllAsStream();
	public WechatWorkappIdentity load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<WechatWorkappIdentity> wechatWorkappIdentityList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public WechatWorkappIdentity present(WechatWorkappIdentity wechatWorkappIdentity,Map<String,Object> options) throws Exception;
	public WechatWorkappIdentity clone(String id, Map<String,Object> options) throws Exception;

	

	public WechatWorkappIdentity save(WechatWorkappIdentity wechatWorkappIdentity,Map<String,Object> options);
	public SmartList<WechatWorkappIdentity> saveWechatWorkappIdentityList(SmartList<WechatWorkappIdentity> wechatWorkappIdentityList,Map<String,Object> options);
	public SmartList<WechatWorkappIdentity> removeWechatWorkappIdentityList(SmartList<WechatWorkappIdentity> wechatWorkappIdentityList,Map<String,Object> options);
	public SmartList<WechatWorkappIdentity> findWechatWorkappIdentityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWechatWorkappIdentityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWechatWorkappIdentityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String wechatWorkappIdentityId, int version) throws Exception;
	public WechatWorkappIdentity disconnectFromAll(String wechatWorkappIdentityId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	

	public SmartList<WechatWorkappIdentity> queryList(String sql, Object ... parmeters);
	public Stream<WechatWorkappIdentity> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateWechatWorkappIdentity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<WechatWorkappIdentity> findWechatWorkappIdentityBySecUser(String secUserId, Map<String,Object> options);
 	public int countWechatWorkappIdentityBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countWechatWorkappIdentityBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<WechatWorkappIdentity> findWechatWorkappIdentityBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeWechatWorkappIdentityBySecUser(SmartList<WechatWorkappIdentity> resultList, String secUserId, Map<String,Object> options);


 
}


