
package com.doublechaintech.retailscm.skilltype;
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
import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillDAO;


public interface SkillTypeDAO extends BaseDAO{

	public SmartList<SkillType> loadAll();
	public Stream<SkillType> loadAllAsStream();
	public SkillType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SkillType> skillTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public SkillType present(SkillType skillType,Map<String,Object> options) throws Exception;
	public SkillType clone(String id, Map<String,Object> options) throws Exception;

	

	public SkillType save(SkillType skillType,Map<String,Object> options);
	public SmartList<SkillType> saveSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options);
	public SmartList<SkillType> removeSkillTypeList(SmartList<SkillType> skillTypeList,Map<String,Object> options);
	public SmartList<SkillType> findSkillTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSkillTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSkillTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String skillTypeId, int version) throws Exception;
	public SkillType disconnectFromAll(String skillTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EmployeeSkillDAO getEmployeeSkillDAO();
		
	
 	public SmartList<SkillType> requestCandidateSkillTypeForEmployeeSkill(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SkillType planToRemoveEmployeeSkillList(SkillType skillType, String employeeSkillIds[], Map<String,Object> options)throws Exception;


	//disconnect SkillType with employee in EmployeeSkill
	public SkillType planToRemoveEmployeeSkillListWithEmployee(SkillType skillType, String employeeId, Map<String,Object> options)throws Exception;
	public int countEmployeeSkillListWithEmployee(String skillTypeId, String employeeId, Map<String,Object> options)throws Exception;
	

	public SmartList<SkillType> queryList(String sql, Object ... parmeters);
	public Stream<SkillType> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateSkillType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countSkillTypeByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countSkillTypeByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<SkillType> findSkillTypeByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeSkillTypeByCompany(SmartList<SkillType> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:EmployeeSkill的skillType的EmployeeSkillList
	public SmartList<EmployeeSkill> loadOurEmployeeSkillList(RetailscmUserContext userContext, List<SkillType> us, Map<String,Object> options) throws Exception;
	
}


