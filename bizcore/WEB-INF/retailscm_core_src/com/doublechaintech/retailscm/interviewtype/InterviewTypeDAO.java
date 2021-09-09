
package com.doublechaintech.retailscm.interviewtype;
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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterview;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employeeinterview.EmployeeInterviewDAO;


public interface InterviewTypeDAO extends BaseDAO{

	public SmartList<InterviewType> loadAll();
	public Stream<InterviewType> loadAllAsStream();
	public InterviewType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<InterviewType> interviewTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public InterviewType present(InterviewType interviewType,Map<String,Object> options) throws Exception;
	public InterviewType clone(String id, Map<String,Object> options) throws Exception;

	

	public InterviewType save(InterviewType interviewType,Map<String,Object> options);
	public SmartList<InterviewType> saveInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options);
	public SmartList<InterviewType> removeInterviewTypeList(SmartList<InterviewType> interviewTypeList,Map<String,Object> options);
	public SmartList<InterviewType> findInterviewTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countInterviewTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countInterviewTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String interviewTypeId, int version) throws Exception;
	public InterviewType disconnectFromAll(String interviewTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public EmployeeInterviewDAO getEmployeeInterviewDAO();
		
	
 	public SmartList<InterviewType> requestCandidateInterviewTypeForEmployeeInterview(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public InterviewType planToRemoveEmployeeInterviewList(InterviewType interviewType, String employeeInterviewIds[], Map<String,Object> options)throws Exception;


	//disconnect InterviewType with employee in EmployeeInterview
	public InterviewType planToRemoveEmployeeInterviewListWithEmployee(InterviewType interviewType, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeInterviewListWithEmployee(String interviewTypeId, String employeeId, Map<String,Object> options)throws Exception;
	

	public SmartList<InterviewType> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<InterviewType> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateInterviewType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countInterviewTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countInterviewTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<InterviewType> findInterviewTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeInterviewTypeByCompany(SmartList<InterviewType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:EmployeeInterview的interviewType的EmployeeInterviewList
	public SmartList<EmployeeInterview> loadOurEmployeeInterviewList(RetailscmUserContext userContext, List<InterviewType> us, Map<String,Object> options) throws Exception;
	

	List<InterviewType> search(InterviewTypeRequest pRequest);
}


