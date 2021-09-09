
package com.doublechaintech.retailscm.leveltwocategory;
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

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategory;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryDAO;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryDAO;


public interface LevelTwoCategoryDAO extends BaseDAO{

	public SmartList<LevelTwoCategory> loadAll();
	public Stream<LevelTwoCategory> loadAllAsStream();
	public LevelTwoCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelTwoCategory> levelTwoCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public LevelTwoCategory present(LevelTwoCategory levelTwoCategory,Map<String,Object> options) throws Exception;
	public LevelTwoCategory clone(String id, Map<String,Object> options) throws Exception;

	

	public LevelTwoCategory save(LevelTwoCategory levelTwoCategory,Map<String,Object> options);
	public SmartList<LevelTwoCategory> saveLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options);
	public SmartList<LevelTwoCategory> removeLevelTwoCategoryList(SmartList<LevelTwoCategory> levelTwoCategoryList,Map<String,Object> options);
	public SmartList<LevelTwoCategory> findLevelTwoCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelTwoCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelTwoCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelTwoCategoryId, int version) throws Exception;
	public LevelTwoCategory disconnectFromAll(String levelTwoCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public LevelThreeCategoryDAO getLevelThreeCategoryDAO();
		
	
 	public SmartList<LevelTwoCategory> requestCandidateLevelTwoCategoryForLevelThreeCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelTwoCategory planToRemoveLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, String levelThreeCategoryIds[], Map<String,Object> options)throws Exception;



	public SmartList<LevelTwoCategory> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<LevelTwoCategory> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateLevelTwoCategory executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public int countLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countLevelTwoCategoryByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelTwoCategoryByParentCategory(SmartList<LevelTwoCategory> resultList, String levelOneCategoryId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:LevelThreeCategory的parentCategory的LevelThreeCategoryList
	public SmartList<LevelThreeCategory> loadOurLevelThreeCategoryList(RetailscmUserContext userContext, List<LevelTwoCategory> us, Map<String,Object> options) throws Exception;
	

	List<LevelTwoCategory> search(LevelTwoCategoryRequest pRequest);
}


