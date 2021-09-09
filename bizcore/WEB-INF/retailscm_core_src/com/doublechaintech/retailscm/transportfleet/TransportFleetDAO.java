
package com.doublechaintech.retailscm.transportfleet;
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
import com.doublechaintech.retailscm.transporttruck.TransportTruck;
import com.doublechaintech.retailscm.truckdriver.TruckDriver;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transporttruck.TransportTruckDAO;
import com.doublechaintech.retailscm.truckdriver.TruckDriverDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface TransportFleetDAO extends BaseDAO{

	public SmartList<TransportFleet> loadAll();
	public Stream<TransportFleet> loadAllAsStream();
	public TransportFleet load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportFleet> transportFleetList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public TransportFleet present(TransportFleet transportFleet,Map<String,Object> options) throws Exception;
	public TransportFleet clone(String id, Map<String,Object> options) throws Exception;

	

	public TransportFleet save(TransportFleet transportFleet,Map<String,Object> options);
	public SmartList<TransportFleet> saveTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options);
	public SmartList<TransportFleet> removeTransportFleetList(SmartList<TransportFleet> transportFleetList,Map<String,Object> options);
	public SmartList<TransportFleet> findTransportFleetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportFleetWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportFleetWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportFleetId, int version) throws Exception;
	public TransportFleet disconnectFromAll(String transportFleetId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public TransportTruckDAO getTransportTruckDAO();
		
	public TruckDriverDAO getTruckDriverDAO();
		
	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<TransportFleet> requestCandidateTransportFleetForTransportTruck(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<TransportFleet> requestCandidateTransportFleetForTruckDriver(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<TransportFleet> requestCandidateTransportFleetForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TransportFleet planToRemoveTransportTruckList(TransportFleet transportFleet, String transportTruckIds[], Map<String,Object> options)throws Exception;


	public TransportFleet planToRemoveTruckDriverList(TransportFleet transportFleet, String truckDriverIds[], Map<String,Object> options)throws Exception;


	public TransportFleet planToRemoveTransportTaskList(TransportFleet transportFleet, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect TransportFleet with end in TransportTask
	public TransportFleet planToRemoveTransportTaskListWithEnd(TransportFleet transportFleet, String endId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithEnd(String transportFleetId, String endId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportFleet with driver in TransportTask
	public TransportFleet planToRemoveTransportTaskListWithDriver(TransportFleet transportFleet, String driverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithDriver(String transportFleetId, String driverId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportFleet with truck in TransportTask
	public TransportFleet planToRemoveTransportTaskListWithTruck(TransportFleet transportFleet, String truckId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithTruck(String transportFleetId, String truckId, Map<String,Object> options)throws Exception;
	

	public SmartList<TransportFleet> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<TransportFleet> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateTransportFleet executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countTransportFleetByOwner(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countTransportFleetByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportFleet> findTransportFleetByOwner(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportFleetByOwner(SmartList<TransportFleet> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:TransportTruck的owner的TransportTruckList
	public SmartList<TransportTruck> loadOurTransportTruckList(RetailscmUserContext userContext, List<TransportFleet> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TruckDriver的belongsTo的TruckDriverList
	public SmartList<TruckDriver> loadOurTruckDriverList(RetailscmUserContext userContext, List<TransportFleet> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:TransportTask的belongsTo的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(RetailscmUserContext userContext, List<TransportFleet> us, Map<String,Object> options) throws Exception;
	

	List<TransportFleet> search(TransportFleetRequest pRequest);
}


