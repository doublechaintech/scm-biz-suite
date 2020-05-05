
package com.doublechaintech.retailscm.wechatworkappidentify;
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


public interface WechatWorkappIdentifyDAO extends BaseDAO{

	public SmartList<WechatWorkappIdentify> loadAll();
	public WechatWorkappIdentify load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<WechatWorkappIdentify> wechatWorkappIdentifyList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public WechatWorkappIdentify present(WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object> options) throws Exception;
	public WechatWorkappIdentify clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public WechatWorkappIdentify save(WechatWorkappIdentify wechatWorkappIdentify,Map<String,Object> options);
	public SmartList<WechatWorkappIdentify> saveWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList,Map<String,Object> options);
	public SmartList<WechatWorkappIdentify> removeWechatWorkappIdentifyList(SmartList<WechatWorkappIdentify> wechatWorkappIdentifyList,Map<String,Object> options);
	public SmartList<WechatWorkappIdentify> findWechatWorkappIdentifyWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWechatWorkappIdentifyWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWechatWorkappIdentifyWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String wechatWorkappIdentifyId, int version) throws Exception;
	public WechatWorkappIdentify disconnectFromAll(String wechatWorkappIdentifyId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<WechatWorkappIdentify> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateWechatWorkappIdentify executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<WechatWorkappIdentify> findWechatWorkappIdentifyBySecUser(String secUserId, Map<String,Object> options);
 	public int countWechatWorkappIdentifyBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countWechatWorkappIdentifyBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<WechatWorkappIdentify> findWechatWorkappIdentifyBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeWechatWorkappIdentifyBySecUser(SmartList<WechatWorkappIdentify> resultList, String secUserId, Map<String,Object> options);

 
 
}


