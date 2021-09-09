
package com.doublechaintech.retailscm.publicholiday;
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

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;


public interface PublicHolidayDAO extends BaseDAO{

	public SmartList<PublicHoliday> loadAll();
	public Stream<PublicHoliday> loadAllAsStream();
	public PublicHoliday load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PublicHoliday> publicHolidayList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public PublicHoliday present(PublicHoliday publicHoliday,Map<String,Object> options) throws Exception;
	public PublicHoliday clone(String id, Map<String,Object> options) throws Exception;

	

	public PublicHoliday save(PublicHoliday publicHoliday,Map<String,Object> options);
	public SmartList<PublicHoliday> savePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options);
	public SmartList<PublicHoliday> removePublicHolidayList(SmartList<PublicHoliday> publicHolidayList,Map<String,Object> options);
	public SmartList<PublicHoliday> findPublicHolidayWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPublicHolidayWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPublicHolidayWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String publicHolidayId, int version) throws Exception;
	public PublicHoliday disconnectFromAll(String publicHolidayId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<PublicHoliday> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<PublicHoliday> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidatePublicHoliday executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public int countPublicHolidayByCompany(String retailStoreCountryCenterId, Map<String,Object> options);
 	public Map<String, Integer> countPublicHolidayByCompanyIds(String[] ids, Map<String,Object> options);
 	public SmartList<PublicHoliday> findPublicHolidayByCompany(String retailStoreCountryCenterId, int start, int count, Map<String,Object> options);
 	public void analyzePublicHolidayByCompany(SmartList<PublicHoliday> resultList, String retailStoreCountryCenterId, Map<String,Object> options);


 

	List<PublicHoliday> search(PublicHolidayRequest pRequest);
}


