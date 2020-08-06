
package com.doublechaintech.retailscm.scoring;
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

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTraining;

import com.doublechaintech.retailscm.employeecompanytraining.EmployeeCompanyTrainingDAO;


public interface ScoringDAO extends BaseDAO{

	public SmartList<Scoring> loadAll();
	public Stream<Scoring> loadAllAsStream();
	public Scoring load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Scoring> scoringList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Scoring present(Scoring scoring,Map<String,Object> options) throws Exception;
	public Scoring clone(String id, Map<String,Object> options) throws Exception;

	

	public Scoring save(Scoring scoring,Map<String,Object> options);
	public SmartList<Scoring> saveScoringList(SmartList<Scoring> scoringList,Map<String,Object> options);
	public SmartList<Scoring> removeScoringList(SmartList<Scoring> scoringList,Map<String,Object> options);
	public SmartList<Scoring> findScoringWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countScoringWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countScoringWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String scoringId, int version) throws Exception;
	public Scoring disconnectFromAll(String scoringId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeCompanyTrainingDAO getEmployeeCompanyTrainingDAO();
		
	
 	public SmartList<Scoring> requestCandidateScoringForEmployeeCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Scoring planToRemoveEmployeeCompanyTrainingList(Scoring scoring, String employeeCompanyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect Scoring with employee in EmployeeCompanyTraining
	public Scoring planToRemoveEmployeeCompanyTrainingListWithEmployee(Scoring scoring, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithEmployee(String scoringId, String employeeId, Map<String,Object> options)throws Exception;
	
	//disconnect Scoring with training in EmployeeCompanyTraining
	public Scoring planToRemoveEmployeeCompanyTrainingListWithTraining(Scoring scoring, String trainingId, Map<String,Object> options)throws Exception;
	public int countEmployeeCompanyTrainingListWithTraining(String scoringId, String trainingId, Map<String,Object> options)throws Exception;
	

	public SmartList<Scoring> queryList(String sql, Object ... parmeters);
	public Stream<Scoring> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateScoring executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:EmployeeCompanyTraining的scoring的EmployeeCompanyTrainingList
	public SmartList<EmployeeCompanyTraining> loadOurEmployeeCompanyTrainingList(RetailscmUserContext userContext, List<Scoring> us, Map<String,Object> options) throws Exception;
	
}


