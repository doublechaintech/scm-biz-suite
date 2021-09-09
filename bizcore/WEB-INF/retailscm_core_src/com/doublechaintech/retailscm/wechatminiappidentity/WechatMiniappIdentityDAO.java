
package com.doublechaintech.retailscm.wechatminiappidentity;
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


public interface WechatMiniappIdentityDAO extends BaseDAO{

	public SmartList<WechatMiniappIdentity> loadAll();
	public Stream<WechatMiniappIdentity> loadAllAsStream();
	public WechatMiniappIdentity load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<WechatMiniappIdentity> wechatMiniappIdentityList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public WechatMiniappIdentity present(WechatMiniappIdentity wechatMiniappIdentity,Map<String,Object> options) throws Exception;
	public WechatMiniappIdentity clone(String id, Map<String,Object> options) throws Exception;

	

	public WechatMiniappIdentity save(WechatMiniappIdentity wechatMiniappIdentity,Map<String,Object> options);
	public SmartList<WechatMiniappIdentity> saveWechatMiniappIdentityList(SmartList<WechatMiniappIdentity> wechatMiniappIdentityList,Map<String,Object> options);
	public SmartList<WechatMiniappIdentity> removeWechatMiniappIdentityList(SmartList<WechatMiniappIdentity> wechatMiniappIdentityList,Map<String,Object> options);
	public SmartList<WechatMiniappIdentity> findWechatMiniappIdentityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWechatMiniappIdentityWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWechatMiniappIdentityWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String wechatMiniappIdentityId, int version) throws Exception;
	public WechatMiniappIdentity disconnectFromAll(String wechatMiniappIdentityId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<WechatMiniappIdentity> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<WechatMiniappIdentity> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateWechatMiniappIdentity executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<WechatMiniappIdentity> findWechatMiniappIdentityBySecUser(String secUserId, Map<String,Object> options);
 	public int countWechatMiniappIdentityBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countWechatMiniappIdentityBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<WechatMiniappIdentity> findWechatMiniappIdentityBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeWechatMiniappIdentityBySecUser(SmartList<WechatMiniappIdentity> resultList, String secUserId, Map<String,Object> options);


 

	List<WechatMiniappIdentity> search(WechatMiniappIdentityRequest pRequest);
}


