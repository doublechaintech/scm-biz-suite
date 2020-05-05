
package com.doublechaintech.retailscm.termination;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

import com.doublechaintech.retailscm.terminationtype.TerminationTypeDAO;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonDAO;


public interface TerminationDAO extends BaseDAO{

	public SmartList<Termination> loadAll();
	public Termination load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Termination> terminationList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public Termination present(Termination termination,Map<String,Object> options) throws Exception;
	public Termination clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public Termination save(Termination termination,Map<String,Object> options);
	public SmartList<Termination> saveTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	public SmartList<Termination> removeTerminationList(SmartList<Termination> terminationList,Map<String,Object> options);
	public SmartList<Termination> findTerminationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTerminationWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTerminationWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String terminationId, int version) throws Exception;
	public Termination disconnectFromAll(String terminationId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	
	
	public SmartList<Termination> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateTermination executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public int countTerminationByReason(String terminationReasonId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationByReasonIds(String[] ids, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByReason(String terminationReasonId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationByReason(SmartList<Termination> resultList, String terminationReasonId, Map<String,Object> options);

 
  
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public int countTerminationByType(String terminationTypeId, Map<String,Object> options);
 	public Map<String, Integer> countTerminationByTypeIds(String[] ids, Map<String,Object> options);
 	public SmartList<Termination> findTerminationByType(String terminationTypeId, int start, int count, Map<String,Object> options);
 	public void analyzeTerminationByType(SmartList<Termination> resultList, String terminationTypeId, Map<String,Object> options);

 
 
}


