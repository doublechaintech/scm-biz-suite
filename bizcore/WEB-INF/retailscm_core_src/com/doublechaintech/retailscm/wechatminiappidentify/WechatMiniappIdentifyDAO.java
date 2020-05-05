
package com.doublechaintech.retailscm.wechatminiappidentify;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.secuser.SecUser;

import com.doublechaintech.retailscm.secuser.SecUserDAO;


public interface WechatMiniappIdentifyDAO extends BaseDAO{

	public SmartList<WechatMiniappIdentify> loadAll();
	public WechatMiniappIdentify load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<WechatMiniappIdentify> wechatMiniappIdentifyList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public WechatMiniappIdentify present(WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object> options) throws Exception;
	public WechatMiniappIdentify clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public WechatMiniappIdentify save(WechatMiniappIdentify wechatMiniappIdentify,Map<String,Object> options);
	public SmartList<WechatMiniappIdentify> saveWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList,Map<String,Object> options);
	public SmartList<WechatMiniappIdentify> removeWechatMiniappIdentifyList(SmartList<WechatMiniappIdentify> wechatMiniappIdentifyList,Map<String,Object> options);
	public SmartList<WechatMiniappIdentify> findWechatMiniappIdentifyWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWechatMiniappIdentifyWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWechatMiniappIdentifyWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String wechatMiniappIdentifyId, int version) throws Exception;
	public WechatMiniappIdentify disconnectFromAll(String wechatMiniappIdentifyId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<WechatMiniappIdentify> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateWechatMiniappIdentify executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<WechatMiniappIdentify> findWechatMiniappIdentifyBySecUser(String secUserId, Map<String,Object> options);
 	public int countWechatMiniappIdentifyBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countWechatMiniappIdentifyBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<WechatMiniappIdentify> findWechatMiniappIdentifyBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeWechatMiniappIdentifyBySecUser(SmartList<WechatMiniappIdentify> resultList, String secUserId, Map<String,Object> options);

 
 
}


