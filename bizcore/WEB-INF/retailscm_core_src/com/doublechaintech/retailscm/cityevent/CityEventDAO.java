
package com.doublechaintech.retailscm.cityevent;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceDAO;


public interface CityEventDAO extends BaseDAO{

	public SmartList<CityEvent> loadAll();
	public CityEvent load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<CityEvent> cityEventList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public CityEvent present(CityEvent cityEvent,Map<String,Object> options) throws Exception;
	public CityEvent clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public CityEvent save(CityEvent cityEvent,Map<String,Object> options);
	public SmartList<CityEvent> saveCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options);
	public SmartList<CityEvent> removeCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options);
	public SmartList<CityEvent> findCityEventWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countCityEventWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countCityEventWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String cityEventId, int version) throws Exception;
	public CityEvent disconnectFromAll(String cityEventId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public EventAttendanceDAO getEventAttendanceDAO();
		
	
 	public SmartList<CityEvent> requestCandidateCityEventForEventAttendance(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public CityEvent planToRemoveEventAttendanceList(CityEvent cityEvent, String eventAttendanceIds[], Map<String,Object> options)throws Exception;


	//disconnect CityEvent with potential_customer in EventAttendance
	public CityEvent planToRemoveEventAttendanceListWithPotentialCustomer(CityEvent cityEvent, String potentialCustomerId, Map<String,Object> options)throws Exception;
	public int countEventAttendanceListWithPotentialCustomer(String cityEventId, String potentialCustomerId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<CityEvent> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidateCityEvent executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public int countCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, Map<String,Object> options);
 	public Map<String, Integer> countCityEventByCityServiceCenterIds(String[] ids, Map<String,Object> options);
 	public SmartList<CityEvent> findCityEventByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count, Map<String,Object> options);
 	public void analyzeCityEventByCityServiceCenter(SmartList<CityEvent> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:EventAttendance的cityEvent的EventAttendanceList
	public SmartList<EventAttendance> loadOurEventAttendanceList(RetailscmUserContext userContext, List<CityEvent> us, Map<String,Object> options) throws Exception;
	
}


