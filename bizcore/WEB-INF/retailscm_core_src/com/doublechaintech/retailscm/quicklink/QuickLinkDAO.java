
package com.doublechaintech.retailscm.quicklink;
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

import com.doublechaintech.retailscm.userapp.UserApp;

import com.doublechaintech.retailscm.userapp.UserAppDAO;


public interface QuickLinkDAO extends BaseDAO{

	public SmartList<QuickLink> loadAll();
	public Stream<QuickLink> loadAllAsStream();
	public QuickLink load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<QuickLink> quickLinkList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public QuickLink present(QuickLink quickLink,Map<String,Object> options) throws Exception;
	public QuickLink clone(String id, Map<String,Object> options) throws Exception;

	

	public QuickLink save(QuickLink quickLink,Map<String,Object> options);
	public SmartList<QuickLink> saveQuickLinkList(SmartList<QuickLink> quickLinkList,Map<String,Object> options);
	public SmartList<QuickLink> removeQuickLinkList(SmartList<QuickLink> quickLinkList,Map<String,Object> options);
	public SmartList<QuickLink> findQuickLinkWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countQuickLinkWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countQuickLinkWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String quickLinkId, int version) throws Exception;
	public QuickLink disconnectFromAll(String quickLinkId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<QuickLink> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<QuickLink> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateQuickLink executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<QuickLink> findQuickLinkByApp(String userAppId, Map<String,Object> options);
 	public int countQuickLinkByApp(String userAppId, Map<String,Object> options);
 	public Map<String, Integer> countQuickLinkByAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<QuickLink> findQuickLinkByApp(String userAppId, int start, int count, Map<String,Object> options);
 	public void analyzeQuickLinkByApp(SmartList<QuickLink> resultList, String userAppId, Map<String,Object> options);


 

	List<QuickLink> search(QuickLinkRequest pRequest);
}


