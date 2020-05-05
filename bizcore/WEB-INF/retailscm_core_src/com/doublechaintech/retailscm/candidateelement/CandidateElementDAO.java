
package com.doublechaintech.retailscm.candidateelement;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;

import com.doublechaintech.retailscm.candidatecontainer.CandidateContainerDAO;


public interface CandidateElementDAO extends BaseDAO{

	public SmartList<CandidateElement> loadAll();
	public CandidateElement load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CandidateElement> candidateElementList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CandidateElement present(CandidateElement candidateElement,Map<String,Object> options) throws Exception;
	public CandidateElement clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CandidateElement save(CandidateElement candidateElement,Map<String,Object> options);
	public SmartList<CandidateElement> saveCandidateElementList(SmartList<CandidateElement> candidateElementList,Map<String,Object> options);
	public SmartList<CandidateElement> removeCandidateElementList(SmartList<CandidateElement> candidateElementList,Map<String,Object> options);
	public SmartList<CandidateElement> findCandidateElementWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCandidateElementWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCandidateElementWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String candidateElementId, int version) throws Exception;
	public CandidateElement disconnectFromAll(String candidateElementId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<CandidateElement> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateCandidateElement executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<CandidateElement> findCandidateElementByContainer(String candidateContainerId, Map<String,Object> options);
 	public int countCandidateElementByContainer(String candidateContainerId, Map<String,Object> options);
 	public Map<String, Integer> countCandidateElementByContainerIds(String[] ids, Map<String,Object> options);
 	public SmartList<CandidateElement> findCandidateElementByContainer(String candidateContainerId, int start, int count, Map<String,Object> options);
 	public void analyzeCandidateElementByContainer(SmartList<CandidateElement> resultList, String candidateContainerId, Map<String,Object> options);

 
 
}


