
package com.doublechaintech.retailscm.stockcountissuetrack;
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

import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;

import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCountDAO;


public interface StockCountIssueTrackDAO extends BaseDAO{

	public SmartList<StockCountIssueTrack> loadAll();
	public Stream<StockCountIssueTrack> loadAllAsStream();
	public StockCountIssueTrack load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<StockCountIssueTrack> stockCountIssueTrackList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public StockCountIssueTrack present(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options) throws Exception;
	public StockCountIssueTrack clone(String id, Map<String,Object> options) throws Exception;

	

	public StockCountIssueTrack save(StockCountIssueTrack stockCountIssueTrack,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> saveStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> removeStockCountIssueTrackList(SmartList<StockCountIssueTrack> stockCountIssueTrackList,Map<String,Object> options);
	public SmartList<StockCountIssueTrack> findStockCountIssueTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countStockCountIssueTrackWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countStockCountIssueTrackWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String stockCountIssueTrackId, int version) throws Exception;
	public StockCountIssueTrack disconnectFromAll(String stockCountIssueTrackId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<StockCountIssueTrack> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<StockCountIssueTrack> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateStockCountIssueTrack executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, Map<String,Object> options);
 	public int countStockCountIssueTrackByStockCount(String goodsShelfStockCountId, Map<String,Object> options);
 	public Map<String, Integer> countStockCountIssueTrackByStockCountIds(String[] ids, Map<String,Object> options);
 	public SmartList<StockCountIssueTrack> findStockCountIssueTrackByStockCount(String goodsShelfStockCountId, int start, int count, Map<String,Object> options);
 	public void analyzeStockCountIssueTrackByStockCount(SmartList<StockCountIssueTrack> resultList, String goodsShelfStockCountId, Map<String,Object> options);


 

	List<StockCountIssueTrack> search(StockCountIssueTrackRequest pRequest);
}


