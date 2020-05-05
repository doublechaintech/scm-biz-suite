
package com.doublechaintech.retailscm.trainingcoursetype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;

import com.doublechaintech.retailscm.companytraining.CompanyTrainingDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface TrainingCourseTypeDAO extends BaseDAO{

	public SmartList<TrainingCourseType> loadAll();
	public TrainingCourseType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TrainingCourseType> trainingCourseTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TrainingCourseType present(TrainingCourseType trainingCourseType,Map<String,Object> options) throws Exception;
	public TrainingCourseType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TrainingCourseType save(TrainingCourseType trainingCourseType,Map<String,Object> options);
	public SmartList<TrainingCourseType> saveTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options);
	public SmartList<TrainingCourseType> removeTrainingCourseTypeList(SmartList<TrainingCourseType> trainingCourseTypeList,Map<String,Object> options);
	public SmartList<TrainingCourseType> findTrainingCourseTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTrainingCourseTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTrainingCourseTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String trainingCourseTypeId, int version) throws Exception;
	public TrainingCourseType disconnectFromAll(String trainingCourseTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public CompanyTrainingDAO getCompanyTrainingDAO();
		
	
 	public SmartList<TrainingCourseType> requestCandidateTrainingCourseTypeForCompanyTraining(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TrainingCourseType planToRemoveCompanyTrainingList(TrainingCourseType trainingCourseType, String companyTrainingIds[], Map<String,Object> options)throws Exception;


	//disconnect TrainingCourseType with company in CompanyTraining
	public TrainingCourseType planToRemoveCompanyTrainingListWithCompany(TrainingCourseType trainingCourseType, String companyId, Map<String,Object> options)throws Exception;
	public int countCompanyTrainingListWithCompany(String trainingCourseTypeId, String companyId, Map<String,Object> options)throws Exception;
	
	//disconnect TrainingCourseType with instructor in CompanyTraining
	public TrainingCourseType planToRemoveCompanyTrainingListWithInstructor(TrainingCourseType trainingCourseType, String instructorId, Map<String,Object> options)throws Exception;
	public int countCompanyTrainingListWithInstructor(String trainingCourseTypeId, String instructorId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TrainingCourseType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateTrainingCourseType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTrainingCourseTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countTrainingCourseTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<TrainingCourseType> findTrainingCourseTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeTrainingCourseTypeByCompany(SmartList<TrainingCourseType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:CompanyTraining的trainingCourseType的CompanyTrainingList
	public SmartList<CompanyTraining> loadOurCompanyTrainingList(RetailscmUserContext userContext, List<TrainingCourseType> us, Map<String,Object> options) throws Exception;
	
}


