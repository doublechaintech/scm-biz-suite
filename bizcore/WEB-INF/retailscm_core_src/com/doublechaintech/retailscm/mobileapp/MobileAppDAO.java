
package com.doublechaintech.retailscm.mobileapp;
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

import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.PageDAO;
import com.doublechaintech.retailscm.pagetype.PageTypeDAO;


public interface MobileAppDAO extends BaseDAO{

	public SmartList<MobileApp> loadAll();
	public Stream<MobileApp> loadAllAsStream();
	public MobileApp load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<MobileApp> mobileAppList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public MobileApp present(MobileApp mobileApp,Map<String,Object> options) throws Exception;
	public MobileApp clone(String id, Map<String,Object> options) throws Exception;

	

	public MobileApp save(MobileApp mobileApp,Map<String,Object> options);
	public SmartList<MobileApp> saveMobileAppList(SmartList<MobileApp> mobileAppList,Map<String,Object> options);
	public SmartList<MobileApp> removeMobileAppList(SmartList<MobileApp> mobileAppList,Map<String,Object> options);
	public SmartList<MobileApp> findMobileAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countMobileAppWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countMobileAppWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String mobileAppId, int version) throws Exception;
	public MobileApp disconnectFromAll(String mobileAppId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	public PageDAO getPageDAO();
		
	public PageTypeDAO getPageTypeDAO();
		
	
 	public SmartList<MobileApp> requestCandidateMobileAppForPage(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
 	public SmartList<MobileApp> requestCandidateMobileAppForPageType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public MobileApp planToRemovePageList(MobileApp mobileApp, String pageIds[], Map<String,Object> options)throws Exception;


	//disconnect MobileApp with page_type in Page
	public MobileApp planToRemovePageListWithPageType(MobileApp mobileApp, String pageTypeId, Map<String,Object> options)throws Exception;
	public int countPageListWithPageType(String mobileAppId, String pageTypeId, Map<String,Object> options)throws Exception;
	
	public MobileApp planToRemovePageTypeList(MobileApp mobileApp, String pageTypeIds[], Map<String,Object> options)throws Exception;



	public SmartList<MobileApp> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<MobileApp> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateMobileApp executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;

	// 需要一个加载引用我的对象的enhance方法:Page的mobileApp的PageList
	public SmartList<Page> loadOurPageList(RetailscmUserContext userContext, List<MobileApp> us, Map<String,Object> options) throws Exception;
	
	// 需要一个加载引用我的对象的enhance方法:PageType的mobileApp的PageTypeList
	public SmartList<PageType> loadOurPageTypeList(RetailscmUserContext userContext, List<MobileApp> us, Map<String,Object> options) throws Exception;
	

	List<MobileApp> search(MobileAppRequest pRequest);
}


