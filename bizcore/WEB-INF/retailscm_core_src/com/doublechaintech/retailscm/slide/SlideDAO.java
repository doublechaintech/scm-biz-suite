
package com.doublechaintech.retailscm.slide;
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

import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.PageDAO;


public interface SlideDAO extends BaseDAO{

	public SmartList<Slide> loadAll();
	public Stream<Slide> loadAllAsStream();
	public Slide load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<Slide> slideList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public Slide present(Slide slide,Map<String,Object> options) throws Exception;
	public Slide clone(String id, Map<String,Object> options) throws Exception;

	

	public Slide save(Slide slide,Map<String,Object> options);
	public SmartList<Slide> saveSlideList(SmartList<Slide> slideList,Map<String,Object> options);
	public SmartList<Slide> removeSlideList(SmartList<Slide> slideList,Map<String,Object> options);
	public SmartList<Slide> findSlideWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countSlideWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countSlideWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String slideId, int version) throws Exception;
	public Slide disconnectFromAll(String slideId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<Slide> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<Slide> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateSlide executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<Slide> findSlideByPage(String pageId, Map<String,Object> options);
 	public int countSlideByPage(String pageId, Map<String,Object> options);
 	public Map<String, Integer> countSlideByPageIds(String[] ids, Map<String,Object> options);
 	public SmartList<Slide> findSlideByPage(String pageId, int start, int count, Map<String,Object> options);
 	public void analyzeSlideByPage(SmartList<Slide> resultList, String pageId, Map<String,Object> options);


 

	List<Slide> search(SlideRequest pRequest);
}


