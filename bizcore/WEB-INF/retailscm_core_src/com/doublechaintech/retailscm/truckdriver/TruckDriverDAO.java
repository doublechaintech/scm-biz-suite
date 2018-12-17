
package com.doublechaintech.retailscm.truckdriver;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.transportfleet.TransportFleetDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;


public interface TruckDriverDAO{

	
	public TruckDriver load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TruckDriver> truckDriverList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public TruckDriver present(TruckDriver truckDriver,Map<String,Object> options) throws Exception;
	public TruckDriver clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public TruckDriver save(TruckDriver truckDriver,Map<String,Object> options);
	public SmartList<TruckDriver> saveTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options);
	public SmartList<TruckDriver> removeTruckDriverList(SmartList<TruckDriver> truckDriverList,Map<String,Object> options);
	public SmartList<TruckDriver> findTruckDriverWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTruckDriverWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTruckDriverWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String truckDriverId, int version) throws Exception;
	public TruckDriver disconnectFromAll(String truckDriverId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<TruckDriver> requestCandidateTruckDriverForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TruckDriver planToRemoveTransportTaskList(TruckDriver truckDriver, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect TruckDriver with end in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithEnd(TruckDriver truckDriver, String endId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithEnd(String truckDriverId, String endId, Map<String,Object> options)throws Exception;
	
	//disconnect TruckDriver with truck in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithTruck(TruckDriver truckDriver, String truckId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithTruck(String truckDriverId, String truckId, Map<String,Object> options)throws Exception;
	
	//disconnect TruckDriver with belongs_to in TransportTask
	public TruckDriver planToRemoveTransportTaskListWithBelongsTo(TruckDriver truckDriver, String belongsToId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithBelongsTo(String truckDriverId, String belongsToId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<TruckDriver> queryList(String sql, Object ... parmeters);
 
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public int countTruckDriverByBelongsTo(String transportFleetId, Map<String,Object> options);
 	public Map<String, Integer> countTruckDriverByBelongsToIds(String[] ids, Map<String,Object> options);
 	public SmartList<TruckDriver> findTruckDriverByBelongsTo(String transportFleetId, int start, int count, Map<String,Object> options);
 	public void analyzeTruckDriverByBelongsTo(SmartList<TruckDriver> resultList, String transportFleetId, Map<String,Object> options);

 
 }


