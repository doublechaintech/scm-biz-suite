
package com.doublechaintech.retailscm.transporttruck;
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

import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transportfleet.TransportFleetDAO;
import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;


public interface TransportTruckDAO extends BaseDAO{

	public SmartList<TransportTruck> loadAll();
	public Stream<TransportTruck> loadAllAsStream();
	public TransportTruck load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportTruck> transportTruckList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public TransportTruck present(TransportTruck transportTruck,Map<String,Object> options) throws Exception;
	public TransportTruck clone(String id, Map<String,Object> options) throws Exception;

	

	public TransportTruck save(TransportTruck transportTruck,Map<String,Object> options);
	public SmartList<TransportTruck> saveTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options);
	public SmartList<TransportTruck> removeTransportTruckList(SmartList<TransportTruck> transportTruckList,Map<String,Object> options);
	public SmartList<TransportTruck> findTransportTruckWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportTruckWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportTruckWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportTruckId, int version) throws Exception;
	public TransportTruck disconnectFromAll(String transportTruckId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public TransportTaskDAO getTransportTaskDAO();
		
	
 	public SmartList<TransportTruck> requestCandidateTransportTruckForTransportTask(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public TransportTruck planToRemoveTransportTaskList(TransportTruck transportTruck, String transportTaskIds[], Map<String,Object> options)throws Exception;


	//disconnect TransportTruck with end in TransportTask
	public TransportTruck planToRemoveTransportTaskListWithEnd(TransportTruck transportTruck, String endId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithEnd(String transportTruckId, String endId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportTruck with driver in TransportTask
	public TransportTruck planToRemoveTransportTaskListWithDriver(TransportTruck transportTruck, String driverId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithDriver(String transportTruckId, String driverId, Map<String,Object> options)throws Exception;
	
	//disconnect TransportTruck with belongs_to in TransportTask
	public TransportTruck planToRemoveTransportTaskListWithBelongsTo(TransportTruck transportTruck, String belongsToId, Map<String,Object> options)throws Exception;
	public int countTransportTaskListWithBelongsTo(String transportTruckId, String belongsToId, Map<String,Object> options)throws Exception;
	

	public SmartList<TransportTruck> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<TransportTruck> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateTransportTruck executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId, Map<String,Object> options);
 	public int countTransportTruckByOwner(String transportFleetId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTruckByOwnerIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTruck> findTransportTruckByOwner(String transportFleetId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTruckByOwner(SmartList<TransportTruck> resultList, String transportFleetId, Map<String,Object> options);


 
	// 需要一个加载引用我的对象的enhance方法:TransportTask的truck的TransportTaskList
	public SmartList<TransportTask> loadOurTransportTaskList(RetailscmUserContext userContext, List<TransportTruck> us, Map<String,Object> options) throws Exception;
	

	List<TransportTruck> search(TransportTruckRequest pRequest);
}


