
package com.doublechaintech.retailscm.levelonedepartment;
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
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;

import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartmentDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface LevelOneDepartmentDAO extends BaseDAO{

	public SmartList<LevelOneDepartment> loadAll();
	public Stream<LevelOneDepartment> loadAllAsStream();
	public LevelOneDepartment load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelOneDepartment> levelOneDepartmentList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public LevelOneDepartment present(LevelOneDepartment levelOneDepartment,Map<String,Object> options) throws Exception;
	public LevelOneDepartment clone(String id, Map<String,Object> options) throws Exception;

	

	public LevelOneDepartment save(LevelOneDepartment levelOneDepartment,Map<String,Object> options);
	public SmartList<LevelOneDepartment> saveLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options);
	public SmartList<LevelOneDepartment> removeLevelOneDepartmentList(SmartList<LevelOneDepartment> levelOneDepartmentList,Map<String,Object> options);
	public SmartList<LevelOneDepartment> findLevelOneDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelOneDepartmentWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelOneDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelOneDepartmentId, int version) throws Exception;
	public LevelOneDepartment disconnectFromAll(String levelOneDepartmentId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public LevelTwoDepartmentDAO getLevelTwoDepartmentDAO();
		
	
 	public SmartList<LevelOneDepartment> requestCandidateLevelOneDepartmentForLevelTwoDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelOneDepartment planToRemoveLevelTwoDepartmentList(LevelOneDepartment levelOneDepartment, String levelTwoDepartmentIds[], Map<String,Object> options)throws Exception;



	public SmartList<LevelOneDepartment> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<LevelOneDepartment> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateLevelOneDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countLevelOneDepartmentByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelOneDepartment> findLevelOneDepartmentByBelongsTo(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelOneDepartmentByBelongsTo(SmartList<LevelOneDepartment> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:LevelTwoDepartment的belongsTo的LevelTwoDepartmentList
	public SmartList<LevelTwoDepartment> loadOurLevelTwoDepartmentList(RetailscmUserContext userContext, List<LevelOneDepartment> us, Map<String,Object> options) throws Exception;
	

	List<LevelOneDepartment> search(LevelOneDepartmentRequest pRequest);
}


