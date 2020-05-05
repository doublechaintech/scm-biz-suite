
package com.doublechaintech.retailscm.keypairidentify;
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
import com.doublechaintech.retailscm.publickeytype.PublicKeyType;

import com.doublechaintech.retailscm.secuser.SecUserDAO;
import com.doublechaintech.retailscm.publickeytype.PublicKeyTypeDAO;


public interface KeypairIdentifyDAO extends BaseDAO{

	public SmartList<KeypairIdentify> loadAll();
	public KeypairIdentify load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<KeypairIdentify> keypairIdentifyList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public KeypairIdentify present(KeypairIdentify keypairIdentify,Map<String,Object> options) throws Exception;
	public KeypairIdentify clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public KeypairIdentify save(KeypairIdentify keypairIdentify,Map<String,Object> options);
	public SmartList<KeypairIdentify> saveKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList,Map<String,Object> options);
	public SmartList<KeypairIdentify> removeKeypairIdentifyList(SmartList<KeypairIdentify> keypairIdentifyList,Map<String,Object> options);
	public SmartList<KeypairIdentify> findKeypairIdentifyWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countKeypairIdentifyWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countKeypairIdentifyWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String keypairIdentifyId, int version) throws Exception;
	public KeypairIdentify disconnectFromAll(String keypairIdentifyId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<KeypairIdentify> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateKeypairIdentify executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<KeypairIdentify> findKeypairIdentifyByKeyType(String publicKeyTypeId, Map<String,Object> options);
 	public int countKeypairIdentifyByKeyType(String publicKeyTypeId, Map<String,Object> options);
 	public Map<String, Integer> countKeypairIdentifyByKeyTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<KeypairIdentify> findKeypairIdentifyByKeyType(String publicKeyTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeKeypairIdentifyByKeyType(SmartList<KeypairIdentify> resultList, String publicKeyTypeId, Map<String,Object> options);

 
  
 	public SmartList<KeypairIdentify> findKeypairIdentifyBySecUser(String secUserId, Map<String,Object> options);
 	public int countKeypairIdentifyBySecUser(String secUserId, Map<String,Object> options);
 	public Map<String, Integer> countKeypairIdentifyBySecUserIds(String[] ids, Map<String,Object> options);
 	public SmartList<KeypairIdentify> findKeypairIdentifyBySecUser(String secUserId, int start, int count, Map<String,Object> options);
 	public void analyzeKeypairIdentifyBySecUser(SmartList<KeypairIdentify> resultList, String secUserId, Map<String,Object> options);

 
 
}


