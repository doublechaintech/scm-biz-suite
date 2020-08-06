
package com.doublechaintech.retailscm.warehouseasset;
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

import com.doublechaintech.retailscm.warehouse.WarehouseDAO;


public interface WarehouseAssetDAO extends BaseDAO{

	public SmartList<WarehouseAsset> loadAll();
	public Stream<WarehouseAsset> loadAllAsStream();
	public WarehouseAsset load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<WarehouseAsset> warehouseAssetList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public WarehouseAsset present(WarehouseAsset warehouseAsset,Map<String,Object> options) throws Exception;
	public WarehouseAsset clone(String id, Map<String,Object> options) throws Exception;

	

	public WarehouseAsset save(WarehouseAsset warehouseAsset,Map<String,Object> options);
	public SmartList<WarehouseAsset> saveWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList,Map<String,Object> options);
	public SmartList<WarehouseAsset> removeWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList,Map<String,Object> options);
	public SmartList<WarehouseAsset> findWarehouseAssetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countWarehouseAssetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countWarehouseAssetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String warehouseAssetId, int version) throws Exception;
	public WarehouseAsset disconnectFromAll(String warehouseAssetId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	

	public SmartList<WarehouseAsset> queryList(String sql, Object ... parmeters);
	public Stream<WarehouseAsset> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateWarehouseAsset executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<WarehouseAsset> findWarehouseAssetByOwner(String warehouseId, Map<String,Object> options);
 	public int countWarehouseAssetByOwner(String warehouseId, Map<String,Object> options);
 	public Map<String, Integer> countWarehouseAssetByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<WarehouseAsset> findWarehouseAssetByOwner(String warehouseId, int start, int count, Map<String,Object> options);
 	public void analyzeWarehouseAssetByOwner(SmartList<WarehouseAsset> resultList, String warehouseId, Map<String,Object> options);


 
}


