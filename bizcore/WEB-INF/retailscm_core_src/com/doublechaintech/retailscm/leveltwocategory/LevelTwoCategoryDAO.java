
package com.doublechaintech.retailscm.leveltwocategory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.levelthreecategory.LevelThreeCategoryDAO;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryDAO;


public interface LevelTwoCategoryDAO{

	
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

	public LevelThreeCategoryDAO getLevelThreeCategoryDAO();
		
	
 	public SmartList<LevelTwoCategory> requestCandidateLevelTwoCategoryForLevelThreeCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelTwoCategory planToRemoveLevelThreeCategoryList(LevelTwoCategory levelTwoCategory, String levelThreeCategoryIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<LevelTwoCategory> queryList(String sql, Object ... parmeters);
 
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public int countLevelTwoCategoryByParentCategory(String levelOneCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countLevelTwoCategoryByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelTwoCategory> findLevelTwoCategoryByParentCategory(String levelOneCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelTwoCategoryByParentCategory(SmartList<LevelTwoCategory> resultList, String levelOneCategoryId, Map<String,Object> options);

 
 }


