
package com.doublechaintech.retailscm.pagetype;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.PageDAO;
import com.doublechaintech.retailscm.mobileapp.MobileAppDAO;


public interface PageTypeDAO extends BaseDAO{

	public SmartList<PageType> loadAll();
	public PageType load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<PageType> pageTypeList);
	public void collectAndEnhance(BaseEntity ownerEntity);
	
	public void alias(List<BaseEntity> entityList);
	
	
	
	
	public PageType loadByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public PageType present(PageType pageType,Map<String,Object> options) throws Exception;
	public PageType clone(String id, Map<String,Object> options) throws Exception;
	
	
	
	public PageType cloneByCode(String code,Map<String,Object> options) throws Exception;
	
	
	public PageType save(PageType pageType,Map<String,Object> options);
	public SmartList<PageType> savePageTypeList(SmartList<PageType> pageTypeList,Map<String,Object> options);
	public SmartList<PageType> removePageTypeList(SmartList<PageType> pageTypeList,Map<String,Object> options);
	public SmartList<PageType> findPageTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countPageTypeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countPageTypeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String pageTypeId, int version) throws Exception;
	public PageType disconnectFromAll(String pageTypeId, int version) throws Exception;
	public int deleteAll() throws Exception;

	public PageDAO getPageDAO();
		
	
 	public SmartList<PageType> requestCandidatePageTypeForPage(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception;
		
	
	public PageType planToRemovePageList(PageType pageType, String pageIds[], Map<String,Object> options)throws Exception;


	//disconnect PageType with mobile_app in Page
	public PageType planToRemovePageListWithMobileApp(PageType pageType, String mobileAppId, Map<String,Object> options)throws Exception;
	public int countPageListWithMobileApp(String pageTypeId, String mobileAppId, Map<String,Object> options)throws Exception;
	
	
	public SmartList<PageType> queryList(String sql, Object ... parmeters);
	public int count(String sql, Object ... parmeters);
	public CandidatePageType executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;
 
 	public SmartList<PageType> findPageTypeByMobileApp(String mobileAppId, Map<String,Object> options);
 	public int countPageTypeByMobileApp(String mobileAppId, Map<String,Object> options);
 	public Map<String, Integer> countPageTypeByMobileAppIds(String[] ids, Map<String,Object> options);
 	public SmartList<PageType> findPageTypeByMobileApp(String mobileAppId, int start, int count, Map<String,Object> options);
 	public void analyzePageTypeByMobileApp(SmartList<PageType> resultList, String mobileAppId, Map<String,Object> options);

 
 
	// 需要一个加载引用我的对象的enhance方法:Page的pageType的PageList
	public SmartList<Page> loadOurPageList(RetailscmUserContext userContext, List<PageType> us, Map<String,Object> options) throws Exception;
	
}


