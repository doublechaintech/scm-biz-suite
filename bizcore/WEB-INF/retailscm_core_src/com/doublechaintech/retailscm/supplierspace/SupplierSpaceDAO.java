
package com.doublechaintech.retailscm.supplierspace;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.warehouse.WarehouseDAO;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelfDAO;


public interface SupplierSpaceDAO{

	
	public SupplierSpace load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<SupplierSpace> supplierSpaceList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public SupplierSpace present(SupplierSpace supplierSpace,Map<String,Object> options) throws Exception;
	public SupplierSpace clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public SupplierSpace save(SupplierSpace supplierSpace,Map<String,Object> options);
	public SmartList<SupplierSpace> saveSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options);
	public SmartList<SupplierSpace> removeSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList,Map<String,Object> options);
	public SmartList<SupplierSpace> findSupplierSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSupplierSpaceWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSupplierSpaceWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String supplierSpaceId, int version) throws Exception;
	public SupplierSpace disconnectFromAll(String supplierSpaceId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public GoodsShelfDAO getGoodsShelfDAO();
		
	
 	public SmartList<SupplierSpace> requestCandidateSupplierSpaceForGoodsShelf(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public SupplierSpace planToRemoveGoodsShelfList(SupplierSpace supplierSpace, String goodsShelfIds[], Map<String,Object> options)throws Exception;


	//disconnect SupplierSpace with storage_space in GoodsShelf
	public SupplierSpace planToRemoveGoodsShelfListWithStorageSpace(SupplierSpace supplierSpace, String storageSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithStorageSpace(String supplierSpaceId, String storageSpaceId, Map<String,Object> options)throws Exception;
	
	//disconnect SupplierSpace with damage_space in GoodsShelf
	public SupplierSpace planToRemoveGoodsShelfListWithDamageSpace(SupplierSpace supplierSpace, String damageSpaceId, Map<String,Object> options)throws Exception;
	public int countGoodsShelfListWithDamageSpace(String supplierSpaceId, String damageSpaceId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<SupplierSpace> queryList(String sql, Object ... parmeters);
 
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public int countSupplierSpaceByWarehouse(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countSupplierSpaceByWarehouseIds(String[] ids, Map<String,Object> options);
 	public SmartList<SupplierSpace> findSupplierSpaceByWarehouse(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeSupplierSpaceByWarehouse(SmartList<SupplierSpace> resultList, String warehouseId, Map<String,Object> options);

 
 }


