
package com.doublechaintech.retailscm.levelthreecategory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategoryDAO;
import com.doublechaintech.retailscm.product.ProductDAO;


public interface LevelThreeCategoryDAO{

	
	public LevelThreeCategory load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<LevelThreeCategory> levelThreeCategoryList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public LevelThreeCategory present(LevelThreeCategory levelThreeCategory,Map<String,Object> options) throws Exception;
	public LevelThreeCategory clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public LevelThreeCategory save(LevelThreeCategory levelThreeCategory,Map<String,Object> options);
	public SmartList<LevelThreeCategory> saveLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options);
	public SmartList<LevelThreeCategory> removeLevelThreeCategoryList(SmartList<LevelThreeCategory> levelThreeCategoryList,Map<String,Object> options);
	public SmartList<LevelThreeCategory> findLevelThreeCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countLevelThreeCategoryWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countLevelThreeCategoryWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String levelThreeCategoryId, int version) throws Exception;
	public LevelThreeCategory disconnectFromAll(String levelThreeCategoryId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public ProductDAO getProductDAO();
		
	
 	public SmartList<LevelThreeCategory> requestCandidateLevelThreeCategoryForProduct(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public LevelThreeCategory planToRemoveProductList(LevelThreeCategory levelThreeCategory, String productIds[], Map<String,Object> options)throws Exception;


	
	public SmartList<LevelThreeCategory> queryList(String sql, Object ... parmeters);
 
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public int countLevelThreeCategoryByParentCategory(String levelTwoCategoryId, Map<String,Object> options);
 	public Map<String, Integer> countLevelThreeCategoryByParentCategoryIds(String[] ids, Map<String,Object> options);
 	public SmartList<LevelThreeCategory> findLevelThreeCategoryByParentCategory(String levelTwoCategoryId, int start, int count, Map<String,Object> options);
 	public void analyzeLevelThreeCategoryByParentCategory(SmartList<LevelThreeCategory> resultList, String levelTwoCategoryId, Map<String,Object> options);

 
 }


