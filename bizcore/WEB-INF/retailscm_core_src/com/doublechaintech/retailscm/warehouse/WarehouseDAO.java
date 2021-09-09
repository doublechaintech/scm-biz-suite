
package com.doublechaintech.retailscm.warehouse;
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

import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

import com.doublechaintech.retailscm.damagespace.DamageSpaceDAO;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetDAO;
import com.doublechaintech.retailscm.smartpallet.SmartPalletDAO;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceDAO;
import com.doublechaintech.retailscm.storagespace.StorageSpaceDAO;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceDAO;


public interface WarehouseDAO extends BaseDAO{

	public SmartList<Warehouse> loadAll();
	public Stream<Warehouse> loadAllAsStream();
	public Warehouse load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Warehouse> warehouseList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Warehouse present(Warehouse warehouse,Map<String,Object> options) throws Exception;
	public Warehouse clone(String id, Map<String,Object> options) throws Exception;

	

	public Warehouse save(Warehouse warehouse,Map<String,Object> options);
	public SmartList<Warehouse> saveWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options);
	public SmartList<Warehouse> removeWarehouseList(SmartList<Warehouse> warehouseList,Map<String,Object> options);
	public SmartList<Warehouse> findWarehouseWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWarehouseWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWarehouseWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String warehouseId, int version) throws Exception;
	public Warehouse disconnectFromAll(String warehouseId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public StorageSpaceDAO getStorageSpaceDAO();
		
	public SmartPalletDAO getSmartPalletDAO();
		
	public SupplierSpaceDAO getSupplierSpaceDAO();
		
	public ReceivingSpaceDAO getReceivingSpaceDAO();
		
	public ShippingSpaceDAO getShippingSpaceDAO();
		
	public DamageSpaceDAO getDamageSpaceDAO();
		
	public WarehouseAssetDAO getWarehouseAssetDAO();
		
	
 	public SmartList<Warehouse> requestCandidateWarehouseForStorageSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForSmartPallet(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForSupplierSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForReceivingSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForShippingSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForDamageSpace(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<Warehouse> requestCandidateWarehouseForWarehouseAsset(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public Warehouse planToRemoveStorageSpaceList(Warehouse warehouse, String storageSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveSmartPalletList(Warehouse warehouse, String smartPalletIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveSupplierSpaceList(Warehouse warehouse, String supplierSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveReceivingSpaceList(Warehouse warehouse, String receivingSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveShippingSpaceList(Warehouse warehouse, String shippingSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveDamageSpaceList(Warehouse warehouse, String damageSpaceIds[], Map<String,Object> options)throws Exception;


	public Warehouse planToRemoveWarehouseAssetList(Warehouse warehouse, String warehouseAssetIds[], Map<String,Object> options)throws Exception;



	public SmartList<Warehouse> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<Warehouse> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateWarehouse executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countWarehouseByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countWarehouseByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<Warehouse> findWarehouseByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeWarehouseByOwner(SmartList<Warehouse> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:StorageSpace的warehouse的StorageSpaceList
	public SmartList<StorageSpace> loadOurStorageSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SmartPallet的warehouse的SmartPalletList
	public SmartList<SmartPallet> loadOurSmartPalletList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:SupplierSpace的warehouse的SupplierSpaceList
	public SmartList<SupplierSpace> loadOurSupplierSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ReceivingSpace的warehouse的ReceivingSpaceList
	public SmartList<ReceivingSpace> loadOurReceivingSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:ShippingSpace的warehouse的ShippingSpaceList
	public SmartList<ShippingSpace> loadOurShippingSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:DamageSpace的warehouse的DamageSpaceList
	public SmartList<DamageSpace> loadOurDamageSpaceList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:WarehouseAsset的owner的WarehouseAssetList
	public SmartList<WarehouseAsset> loadOurWarehouseAssetList(RetailscmUserContext userContext, List<Warehouse> us, Map<String,Object> options) throws Exception;
	

	List<Warehouse> search(WarehouseRequest pRequest);
}


