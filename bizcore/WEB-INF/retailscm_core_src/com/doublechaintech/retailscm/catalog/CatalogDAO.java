
package com.doublechaintech.retailscm.catalog;
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
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

import com.doublechaintech.retailscm.levelonecategory.LevelOneCategoryDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface CatalogDAO extends BaseDAO{

	public SmartList<Catalog> loadAll();
	public Stream<Catalog> loadAllAsStream();
	public Catalog load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Catalog> catalogList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Catalog present(Catalog catalog,Map<String,Object> options) throws Exception;
	public Catalog clone(String id, Map<String,Object> options) throws Exception;

	

	public Catalog save(Catalog catalog,Map<String,Object> options);
	public SmartList<Catalog> saveCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> removeCatalogList(SmartList<Catalog> catalogList,Map<String,Object> options);
	public SmartList<Catalog> findCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCatalogWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCatalogWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String catalogId, int version) throws Exception;
	public Catalog disconnectFromAll(String catalogId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public LevelOneCategoryDAO getLevelOneCategoryDAO();
		
	
 	public SmartList<Catalog> requestCandidateCatalogForLevelOneCategory(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Catalog planToRemoveLevelOneCategoryList(Catalog catalog, String levelOneCategoryIds[], Map<String,Object> options)throws Exception;



	public SmartList<Catalog> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<Catalog> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateCatalog executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countCatalogByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countCatalogByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<Catalog> findCatalogByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeCatalogByOwner(SmartList<Catalog> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:LevelOneCategory的catalog的LevelOneCategoryList
	public SmartList<LevelOneCategory> loadOurLevelOneCategoryList(RetailscmUserContext userContext, List<Catalog> us, Map<String,Object> options) throws Exception;
	

	List<Catalog> search(CatalogRequest pRequest);
}


