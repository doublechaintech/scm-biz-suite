
package com.doublechaintech.retailscm.storagespace;
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

import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;


public interface StorageSpaceDAO extends BaseDAO{

	public SmartList<StorageSpace> loadAll();
	public Stream<StorageSpace> loadAllAsStream();
	public StorageSpace load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<StorageSpace> storageSpaceList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public StorageSpace present(StorageSpace storageSpace,Map<String,Object> options) throws Exception;
	public StorageSpace clone(String id, Map<String,Object> options) throws Exception;

	

	public StorageSpace save(StorageSpace storageSpace,Map<String,Object> options);
	public SmartList<StorageSpace> saveStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options);
	public SmartList<StorageSpace> removeStorageSpaceList(SmartList<StorageSpace> storageSpaceList,Map<String,Object> options);
	public SmartList<StorageSpace> findStorageSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countStorageSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countStorageSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String storageSpaceId, int version) throws Exception;
	public StorageSpace disconnectFromAll(String storageSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public GoodsShelfDAO getGoodsShelfDAO();
		
	
 	public SmartList<StorageSpace> requestCandidateStorageSpaceForGoodsShelf(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public StorageSpace planToRemoveGoodsShelfList(StorageSpace storageSpace, String goodsShelfIds[], Map<String,Object> options)throws Exception;


	//disconnect StorageSpace with supplier_space in GoodsShelf
	public StorageSpace planToRemoveGoodsShelfListWithSupplierSpace(StorageSpace storageSpace, String supplierSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithSupplierSpace(String storageSpaceId, String supplierSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect StorageSpace with damage_space in GoodsShelf
	public StorageSpace planToRemoveGoodsShelfListWithDamageSpace(StorageSpace storageSpace, String damageSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithDamageSpace(String storageSpaceId, String damageSpaceId, Map<String,Object> options)throws Exception;
	

	public SmartList<StorageSpace> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<StorageSpace> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateStorageSpace executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countStorageSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countStorageSpaceByWarehouseIds(String[] ids, Map<String,Object> options);
 	public SmartList<StorageSpace> findStorageSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeStorageSpaceByWarehouse(SmartList<StorageSpace> resultList, String warehouseId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:GoodsShelf的storageSpace的GoodsShelfList
	public SmartList<GoodsShelf> loadOurGoodsShelfList(RetailscmUserContext userContext, List<StorageSpace> us, Map<String,Object> options) throws Exception;
	

	List<StorageSpace> search(StorageSpaceRequest pRequest);
}


