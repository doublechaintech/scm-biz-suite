
package com.doublechaintech.retailscm.transporttasktrack;
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

import com.doublechaintech.retailscm.transporttask.TransportTask;

import com.doublechaintech.retailscm.transporttask.TransportTaskDAO;


public interface TransportTaskTrackDAO extends BaseDAO{

	public SmartList<TransportTaskTrack> loadAll();
	public Stream<TransportTaskTrack> loadAllAsStream();
	public TransportTaskTrack load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TransportTaskTrack> transportTaskTrackList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public TransportTaskTrack present(TransportTaskTrack transportTaskTrack,Map<String,Object> options) throws Exception;
	public TransportTaskTrack clone(String id, Map<String,Object> options) throws Exception;

	

	public TransportTaskTrack save(TransportTaskTrack transportTaskTrack,Map<String,Object> options);
	public SmartList<TransportTaskTrack> saveTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options);
	public SmartList<TransportTaskTrack> removeTransportTaskTrackList(SmartList<TransportTaskTrack> transportTaskTrackList,Map<String,Object> options);
	public SmartList<TransportTaskTrack> findTransportTaskTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTransportTaskTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTransportTaskTrackWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String transportTaskTrackId, int version) throws Exception;
	public TransportTaskTrack disconnectFromAll(String transportTaskTrackId, int version) throws Exception;
	public int deleteAll() throws Exception;

	
	

	public SmartList<TransportTaskTrack> queryList(String sql, Object ... parmeters);
	public Stream<TransportTaskTrack> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parmeters);
	public CandidateTransportTaskTrack executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId, Map<String,Object> options);
 	public int countTransportTaskTrackByMovement(String transportTaskId, Map<String,Object> options);
 	public Map<String, Integer> countTransportTaskTrackByMovementIds(String[] ids, Map<String,Object> options);
 	public SmartList<TransportTaskTrack> findTransportTaskTrackByMovement(String transportTaskId, int start, int count, Map<String,Object> options);
 	public void analyzeTransportTaskTrackByMovement(SmartList<TransportTaskTrack> resultList, String transportTaskId, Map<String,Object> options);


 
}


