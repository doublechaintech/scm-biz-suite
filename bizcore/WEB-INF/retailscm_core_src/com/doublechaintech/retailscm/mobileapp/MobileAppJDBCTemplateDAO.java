
package com.doublechaintech.retailscm.mobileapp;

import com.doublechaintech.retailscm.Beans;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;

import com.terapico.caf.baseelement.CandidateQuery;
import com.terapico.utils.TextUtil;

import com.doublechaintech.retailscm.RetailscmBaseDAOImpl;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.pagetype.PageType;
import com.doublechaintech.retailscm.page.Page;

import com.doublechaintech.retailscm.page.PageDAO;
import com.doublechaintech.retailscm.pagetype.PageTypeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class MobileAppJDBCTemplateDAO extends RetailscmBaseDAOImpl implements MobileAppDAO{

	protected PageDAO pageDAO;
	public void setPageDAO(PageDAO pageDAO){

 		if(pageDAO == null){
 			throw new IllegalStateException("Do not try to set pageDAO to null.");
 		}
	 	this.pageDAO = pageDAO;
 	}
 	public PageDAO getPageDAO(){
 		if(this.pageDAO == null){
 			throw new IllegalStateException("The pageDAO is not configured yet, please config it some where.");
 		}

	 	return this.pageDAO;
 	}

	protected PageTypeDAO pageTypeDAO;
	public void setPageTypeDAO(PageTypeDAO pageTypeDAO){

 		if(pageTypeDAO == null){
 			throw new IllegalStateException("Do not try to set pageTypeDAO to null.");
 		}
	 	this.pageTypeDAO = pageTypeDAO;
 	}
 	public PageTypeDAO getPageTypeDAO(){
 		if(this.pageTypeDAO == null){
 			throw new IllegalStateException("The pageTypeDAO is not configured yet, please config it some where.");
 		}

	 	return this.pageTypeDAO;
 	}



	/*
	protected MobileApp load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalMobileApp(accessKey, options);
	}
	*/

	public SmartList<MobileApp> loadAll() {
	    return this.loadAll(getMobileAppMapper());
	}

  public Stream<MobileApp> loadAllAsStream() {
      return this.loadAllAsStream(getMobileAppMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public MobileApp load(String id,Map<String,Object> options) throws Exception{
		return loadInternalMobileApp(MobileAppTable.withId(id), options);
	}

	

	public MobileApp save(MobileApp mobileApp,Map<String,Object> options){

		String methodName="save(MobileApp mobileApp,Map<String,Object> options)";

		assertMethodArgumentNotNull(mobileApp, methodName, "mobileApp");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalMobileApp(mobileApp,options);
	}
	public MobileApp clone(String mobileAppId, Map<String,Object> options) throws Exception{

		return clone(MobileAppTable.withId(mobileAppId),options);
	}

	protected MobileApp clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String mobileAppId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		MobileApp newMobileApp = loadInternalMobileApp(accessKey, options);
		newMobileApp.setVersion(0);
		
		

 		if(isSavePageListEnabled(options)){
 			for(Page item: newMobileApp.getPageList()){
 				item.setVersion(0);
 			}
 		}
		

 		if(isSavePageTypeListEnabled(options)){
 			for(PageType item: newMobileApp.getPageTypeList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalMobileApp(newMobileApp,options);

		return newMobileApp;
	}

	



	protected void throwIfHasException(String mobileAppId,int version,int count) throws Exception{
		if (count == 1) {
			throw new MobileAppVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new MobileAppNotFoundException(
					"The " + this.getTableName() + "(" + mobileAppId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String mobileAppId, int version) throws Exception{

		String methodName="delete(String mobileAppId, int version)";
		assertMethodArgumentNotNull(mobileAppId, methodName, "mobileAppId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{mobileAppId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(mobileAppId,version);
		}


	}






	public MobileApp disconnectFromAll(String mobileAppId, int version) throws Exception{


		MobileApp mobileApp = loadInternalMobileApp(MobileAppTable.withId(mobileAppId), emptyOptions());
		mobileApp.clearFromAll();
		this.saveMobileApp(mobileApp);
		return mobileApp;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return MobileAppTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "mobile_app";
	}
	@Override
	protected String getBeanName() {

		return "mobileApp";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return MobileAppTokens.checkOptions(options, optionToCheck);

	}


		

	protected boolean isExtractPageListEnabled(Map<String,Object> options){
 		return checkOptions(options,MobileAppTokens.PAGE_LIST);
 	}
 	protected boolean isAnalyzePageListEnabled(Map<String,Object> options){
 		return MobileAppTokens.of(options).analyzePageListEnabled();
 	}

	protected boolean isSavePageListEnabled(Map<String,Object> options){
		return checkOptions(options, MobileAppTokens.PAGE_LIST);

 	}

		

	protected boolean isExtractPageTypeListEnabled(Map<String,Object> options){
 		return checkOptions(options,MobileAppTokens.PAGE_TYPE_LIST);
 	}
 	protected boolean isAnalyzePageTypeListEnabled(Map<String,Object> options){
 		return MobileAppTokens.of(options).analyzePageTypeListEnabled();
 	}

	protected boolean isSavePageTypeListEnabled(Map<String,Object> options){
		return checkOptions(options, MobileAppTokens.PAGE_TYPE_LIST);

 	}

		

	

	protected MobileAppMapper getMobileAppMapper(){
		return new MobileAppMapper();
	}



	protected MobileApp extractMobileApp(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			MobileApp mobileApp = loadSingleObject(accessKey, getMobileAppMapper());
			return mobileApp;
		}catch(EmptyResultDataAccessException e){
			throw new MobileAppNotFoundException("MobileApp("+accessKey+") is not found!");
		}

	}




	protected MobileApp loadInternalMobileApp(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		MobileApp mobileApp = extractMobileApp(accessKey, loadOptions);

		
		if(isExtractPageListEnabled(loadOptions)){
	 		extractPageList(mobileApp, loadOptions);
 		}

 		
 		if(isAnalyzePageListEnabled(loadOptions)){
	 		analyzePageList(mobileApp, loadOptions);
 		}
 		
		
		if(isExtractPageTypeListEnabled(loadOptions)){
	 		extractPageTypeList(mobileApp, loadOptions);
 		}

 		
		
		return mobileApp;

	}

	
		
	protected void enhancePageList(SmartList<Page> pageList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected MobileApp extractPageList(MobileApp mobileApp, Map<String,Object> options){
    

		if(mobileApp == null){
			return null;
		}
		if(mobileApp.getId() == null){
			return mobileApp;
		}



		SmartList<Page> pageList = getPageDAO().findPageByMobileApp(mobileApp.getId(),options);
		if(pageList != null){
			enhancePageList(pageList,options);
			mobileApp.setPageList(pageList);
		}

		return mobileApp;
  
	}

	protected MobileApp analyzePageList(MobileApp mobileApp, Map<String,Object> options){
     
		if(mobileApp == null){
			return null;
		}
		if(mobileApp.getId() == null){
			return mobileApp;
		}



		SmartList<Page> pageList = mobileApp.getPageList();
		if(pageList != null){
			getPageDAO().analyzePageByMobileApp(pageList, mobileApp.getId(), options);

		}

		return mobileApp;
    
	}

		
	protected void enhancePageTypeList(SmartList<PageType> pageTypeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected MobileApp extractPageTypeList(MobileApp mobileApp, Map<String,Object> options){
    

		if(mobileApp == null){
			return null;
		}
		if(mobileApp.getId() == null){
			return mobileApp;
		}



		SmartList<PageType> pageTypeList = getPageTypeDAO().findPageTypeByMobileApp(mobileApp.getId(),options);
		if(pageTypeList != null){
			enhancePageTypeList(pageTypeList,options);
			mobileApp.setPageTypeList(pageTypeList);
		}

		return mobileApp;
  
	}

	protected MobileApp analyzePageTypeList(MobileApp mobileApp, Map<String,Object> options){
     
		if(mobileApp == null){
			return null;
		}
		if(mobileApp.getId() == null){
			return mobileApp;
		}



		SmartList<PageType> pageTypeList = mobileApp.getPageTypeList();
		if(pageTypeList != null){
			getPageTypeDAO().analyzePageTypeByMobileApp(pageTypeList, mobileApp.getId(), options);

		}

		return mobileApp;
    
	}

		

 




	

	protected MobileApp saveMobileApp(MobileApp  mobileApp){
    

		
		if(!mobileApp.isChanged()){
			return mobileApp;
		}
		

    Beans.dbUtil().cacheCleanUp(mobileApp);
		String SQL=this.getSaveMobileAppSQL(mobileApp);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveMobileAppParameters(mobileApp);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		mobileApp.incVersion();
		mobileApp.afterSave();
		return mobileApp;

	}
	public SmartList<MobileApp> saveMobileAppList(SmartList<MobileApp> mobileAppList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitMobileAppList(mobileAppList);

		batchMobileAppCreate((List<MobileApp>)lists[CREATE_LIST_INDEX]);

		batchMobileAppUpdate((List<MobileApp>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(MobileApp mobileApp:mobileAppList){
			if(mobileApp.isChanged()){
				mobileApp.incVersion();
				mobileApp.afterSave();
			}


		}


		return mobileAppList;
	}

	public SmartList<MobileApp> removeMobileAppList(SmartList<MobileApp> mobileAppList,Map<String,Object> options){


		super.removeList(mobileAppList, options);

		return mobileAppList;


	}

	protected List<Object[]> prepareMobileAppBatchCreateArgs(List<MobileApp> mobileAppList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MobileApp mobileApp:mobileAppList ){
			Object [] parameters = prepareMobileAppCreateParameters(mobileApp);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareMobileAppBatchUpdateArgs(List<MobileApp> mobileAppList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(MobileApp mobileApp:mobileAppList ){
			if(!mobileApp.isChanged()){
				continue;
			}
			Object [] parameters = prepareMobileAppUpdateParameters(mobileApp);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchMobileAppCreate(List<MobileApp> mobileAppList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareMobileAppBatchCreateArgs(mobileAppList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchMobileAppUpdate(List<MobileApp> mobileAppList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareMobileAppBatchUpdateArgs(mobileAppList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitMobileAppList(List<MobileApp> mobileAppList){

		List<MobileApp> mobileAppCreateList=new ArrayList<MobileApp>();
		List<MobileApp> mobileAppUpdateList=new ArrayList<MobileApp>();

		for(MobileApp mobileApp: mobileAppList){
			if(isUpdateRequest(mobileApp)){
				mobileAppUpdateList.add( mobileApp);
				continue;
			}
			mobileAppCreateList.add(mobileApp);
		}

		return new Object[]{mobileAppCreateList,mobileAppUpdateList};
	}

	protected boolean isUpdateRequest(MobileApp mobileApp){
 		return mobileApp.getVersion() > 0;
 	}
 	protected String getSaveMobileAppSQL(MobileApp mobileApp){
 		if(isUpdateRequest(mobileApp)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveMobileAppParameters(MobileApp mobileApp){
 		if(isUpdateRequest(mobileApp) ){
 			return prepareMobileAppUpdateParameters(mobileApp);
 		}
 		return prepareMobileAppCreateParameters(mobileApp);
 	}
 	protected Object[] prepareMobileAppUpdateParameters(MobileApp mobileApp){
 		Object[] parameters = new Object[4];
 
 		parameters[0] = mobileApp.getName();
 		
 		parameters[1] = mobileApp.nextVersion();
 		parameters[2] = mobileApp.getId();
 		parameters[3] = mobileApp.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareMobileAppCreateParameters(MobileApp mobileApp){
		Object[] parameters = new Object[2];
        if(mobileApp.getId() == null){
          String newMobileAppId=getNextId();
          mobileApp.setId(newMobileAppId);
        }
		parameters[0] =  mobileApp.getId();
 
 		parameters[1] = mobileApp.getName();
 		

 		return parameters;
 	}

	protected MobileApp saveInternalMobileApp(MobileApp mobileApp, Map<String,Object> options){

   saveMobileApp(mobileApp);
		
		if(isSavePageListEnabled(options)){
	 		savePageList(mobileApp, options);
	 		//removePageList(mobileApp, options);
	 		//Not delete the record

 		}
		
		if(isSavePageTypeListEnabled(options)){
	 		savePageTypeList(mobileApp, options);
	 		//removePageTypeList(mobileApp, options);
	 		//Not delete the record

 		}
		
		return mobileApp;

	}



	//======================================================================================
	

	
	public MobileApp planToRemovePageList(MobileApp mobileApp, String pageIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Page.MOBILE_APP_PROPERTY, mobileApp.getId());
		key.put(Page.ID_PROPERTY, pageIds);

		SmartList<Page> externalPageList = getPageDAO().
				findPageWithKey(key, options);
		if(externalPageList == null){
			return mobileApp;
		}
		if(externalPageList.isEmpty()){
			return mobileApp;
		}

		for(Page pageItem: externalPageList){

			pageItem.clearFromAll();
		}


		SmartList<Page> pageList = mobileApp.getPageList();
		pageList.addAllToRemoveList(externalPageList);
		return mobileApp;

	}


	//disconnect MobileApp with page_type in Page
	public MobileApp planToRemovePageListWithPageType(MobileApp mobileApp, String pageTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Page.MOBILE_APP_PROPERTY, mobileApp.getId());
		key.put(Page.PAGE_TYPE_PROPERTY, pageTypeId);

		SmartList<Page> externalPageList = getPageDAO().
				findPageWithKey(key, options);
		if(externalPageList == null){
			return mobileApp;
		}
		if(externalPageList.isEmpty()){
			return mobileApp;
		}

		for(Page pageItem: externalPageList){
			pageItem.clearPageType();
			pageItem.clearMobileApp();

		}


		SmartList<Page> pageList = mobileApp.getPageList();
		pageList.addAllToRemoveList(externalPageList);
		return mobileApp;
	}

	public int countPageListWithPageType(String mobileAppId, String pageTypeId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Page.MOBILE_APP_PROPERTY, mobileAppId);
		key.put(Page.PAGE_TYPE_PROPERTY, pageTypeId);

		int count = getPageDAO().countPageWithKey(key, options);
		return count;
	}
	
	public MobileApp planToRemovePageTypeList(MobileApp mobileApp, String pageTypeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PageType.MOBILE_APP_PROPERTY, mobileApp.getId());
		key.put(PageType.ID_PROPERTY, pageTypeIds);

		SmartList<PageType> externalPageTypeList = getPageTypeDAO().
				findPageTypeWithKey(key, options);
		if(externalPageTypeList == null){
			return mobileApp;
		}
		if(externalPageTypeList.isEmpty()){
			return mobileApp;
		}

		for(PageType pageTypeItem: externalPageTypeList){

			pageTypeItem.clearFromAll();
		}


		SmartList<PageType> pageTypeList = mobileApp.getPageTypeList();
		pageTypeList.addAllToRemoveList(externalPageTypeList);
		return mobileApp;

	}



		
	protected MobileApp savePageList(MobileApp mobileApp, Map<String,Object> options){
    



		SmartList<Page> pageList = mobileApp.getPageList();
		if(pageList == null){
			//null list means nothing
			return mobileApp;
		}
		SmartList<Page> mergedUpdatePageList = new SmartList<Page>();


		mergedUpdatePageList.addAll(pageList);
		if(pageList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePageList.addAll(pageList.getToRemoveList());
			pageList.removeAll(pageList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getPageDAO().savePageList(mergedUpdatePageList,options);

		if(pageList.getToRemoveList() != null){
			pageList.removeAll(pageList.getToRemoveList());
		}


		return mobileApp;

	}

	protected MobileApp removePageList(MobileApp mobileApp, Map<String,Object> options){


		SmartList<Page> pageList = mobileApp.getPageList();
		if(pageList == null){
			return mobileApp;
		}

		SmartList<Page> toRemovePageList = pageList.getToRemoveList();

		if(toRemovePageList == null){
			return mobileApp;
		}
		if(toRemovePageList.isEmpty()){
			return mobileApp;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getPageDAO().removePageList(toRemovePageList,options);

		return mobileApp;

	}








		
	protected MobileApp savePageTypeList(MobileApp mobileApp, Map<String,Object> options){
    



		SmartList<PageType> pageTypeList = mobileApp.getPageTypeList();
		if(pageTypeList == null){
			//null list means nothing
			return mobileApp;
		}
		SmartList<PageType> mergedUpdatePageTypeList = new SmartList<PageType>();


		mergedUpdatePageTypeList.addAll(pageTypeList);
		if(pageTypeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePageTypeList.addAll(pageTypeList.getToRemoveList());
			pageTypeList.removeAll(pageTypeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getPageTypeDAO().savePageTypeList(mergedUpdatePageTypeList,options);

		if(pageTypeList.getToRemoveList() != null){
			pageTypeList.removeAll(pageTypeList.getToRemoveList());
		}


		return mobileApp;

	}

	protected MobileApp removePageTypeList(MobileApp mobileApp, Map<String,Object> options){


		SmartList<PageType> pageTypeList = mobileApp.getPageTypeList();
		if(pageTypeList == null){
			return mobileApp;
		}

		SmartList<PageType> toRemovePageTypeList = pageTypeList.getToRemoveList();

		if(toRemovePageTypeList == null){
			return mobileApp;
		}
		if(toRemovePageTypeList.isEmpty()){
			return mobileApp;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getPageTypeDAO().removePageTypeList(toRemovePageTypeList,options);

		return mobileApp;

	}








		

	public MobileApp present(MobileApp mobileApp,Map<String, Object> options){

		presentPageList(mobileApp,options);
		presentPageTypeList(mobileApp,options);

		return mobileApp;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected MobileApp presentPageList(
			MobileApp mobileApp,
			Map<String, Object> options) {
    
		SmartList<Page> pageList = mobileApp.getPageList();
				SmartList<Page> newList= presentSubList(mobileApp.getId(),
				pageList,
				options,
				getPageDAO()::countPageByMobileApp,
				getPageDAO()::findPageByMobileApp
				);


		mobileApp.setPageList(newList);


		return mobileApp;
	}
		
	//Using java8 feature to reduce the code significantly
 	protected MobileApp presentPageTypeList(
			MobileApp mobileApp,
			Map<String, Object> options) {
    
		SmartList<PageType> pageTypeList = mobileApp.getPageTypeList();
				SmartList<PageType> newList= presentSubList(mobileApp.getId(),
				pageTypeList,
				options,
				getPageTypeDAO()::countPageTypeByMobileApp,
				getPageTypeDAO()::findPageTypeByMobileApp
				);


		mobileApp.setPageTypeList(newList);


		return mobileApp;
	}
		

	
    public SmartList<MobileApp> requestCandidateMobileAppForPage(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MobileAppTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getMobileAppMapper());
    }
		
    public SmartList<MobileApp> requestCandidateMobileAppForPageType(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(MobileAppTable.COLUMN_NAME, null, filterKey, pageNo, pageSize, getMobileAppMapper());
    }
		

	protected String getTableName(){
		return MobileAppTable.TABLE_NAME;
	}



	public void enhanceList(List<MobileApp> mobileAppList) {
		this.enhanceListInternal(mobileAppList, this.getMobileAppMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:Page的mobileApp的PageList
	public SmartList<Page> loadOurPageList(RetailscmUserContext userContext, List<MobileApp> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(Page.MOBILE_APP_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<Page> loadedObjs = userContext.getDAOGroup().getPageDAO().findPageWithKey(key, options);
		Map<String, List<Page>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getMobileApp().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<Page> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<Page> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPageList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:PageType的mobileApp的PageTypeList
	public SmartList<PageType> loadOurPageTypeList(RetailscmUserContext userContext, List<MobileApp> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PageType.MOBILE_APP_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PageType> loadedObjs = userContext.getDAOGroup().getPageTypeDAO().findPageTypeWithKey(key, options);
		Map<String, List<PageType>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getMobileApp().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<PageType> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<PageType> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPageTypeList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<MobileApp> mobileAppList = ownerEntity.collectRefsWithType(MobileApp.INTERNAL_TYPE);
		this.enhanceList(mobileAppList);

	}

	@Override
	public SmartList<MobileApp> findMobileAppWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getMobileAppMapper());

	}
	@Override
	public int countMobileAppWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countMobileAppWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<MobileApp> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getMobileAppMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<MobileApp> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getMobileAppMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateMobileApp executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateMobileApp result = new CandidateMobileApp();
		int pageNo = Math.max(1, query.getPageNo());
		result.setOwnerClass(TextUtil.toCamelCase(query.getOwnerType()));
		result.setOwnerId(query.getOwnerId());
		result.setFilterKey(query.getFilterKey());
		result.setPageNo(pageNo);
		result.setValueFieldName("id");
		result.setDisplayFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase("displayName")));
		result.setGroupByFieldName(TextUtil.uncapFirstChar(TextUtil.toCamelCase(query.getGroupBy())));

		SmartList candidateList = queryList(sql, parmeters);
		this.alias(candidateList);
		result.setCandidates(candidateList);
		int offSet = (pageNo - 1 ) * query.getPageSize();
		if (candidateList.size() > query.getPageSize()) {
			result.setTotalPage(pageNo+1);
		}else {
			result.setTotalPage(pageNo);
		}
		return result;
	}

	
    
	public Map<String, Integer> countBySql(String sql, Object[] params) {
		if (params == null || params.length == 0) {
			return new HashMap<>();
		}
		List<Map<String, Object>> result = this.getJdbcTemplate().queryForList(sql, params);
		if (result == null || result.isEmpty()) {
			return new HashMap<>();
		}
		Map<String, Integer> cntMap = new HashMap<>();
		for (Map<String, Object> data : result) {
			String key = String.valueOf(data.get("id"));
			Number value = (Number) data.get("count");
			cntMap.put(key, value.intValue());
		}
		this.logSQLAndParameters("countBySql", sql, params, cntMap.size() + " Counts");
		return cntMap;
	}

	public Integer singleCountBySql(String sql, Object[] params) {
		Integer cnt = this.getJdbcTemplate().queryForObject(sql, params, Integer.class);
		logSQLAndParameters("singleCountBySql", sql, params, cnt + "");
		return cnt;
	}

	public BigDecimal summaryBySql(String sql, Object[] params) {
		BigDecimal cnt = this.getJdbcTemplate().queryForObject(sql, params, BigDecimal.class);
		logSQLAndParameters("summaryBySql", sql, params, cnt + "");
		return cnt == null ? BigDecimal.ZERO : cnt;
	}

	public <T> List<T> queryForList(String sql, Object[] params, Class<T> claxx) {
		List<T> result = this.getJdbcTemplate().queryForList(sql, params, claxx);
		logSQLAndParameters("queryForList", sql, params, result.size() + " items");
		return result;
	}

	public Map<String, Object> queryForMap(String sql, Object[] params) throws DataAccessException {
		Map<String, Object> result = null;
		try {
			result = this.getJdbcTemplate().queryForMap(sql, params);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public <T> T queryForObject(String sql, Object[] params, Class<T> claxx) throws DataAccessException {
		T result = null;
		try {
			result = this.getJdbcTemplate().queryForObject(sql, params, claxx);
		} catch (org.springframework.dao.EmptyResultDataAccessException e) {
			// 空结果，返回null
		}
		logSQLAndParameters("queryForObject", sql, params, result == null ? "not found" : String.valueOf(result));
		return result;
	}

	public List<Map<String, Object>> queryAsMapList(String sql, Object[] params) {
		List<Map<String, Object>> result = getJdbcTemplate().queryForList(sql, params);
		logSQLAndParameters("queryAsMapList", sql, params, result.size() + " items");
		return result;
	}

	public synchronized int updateBySql(String sql, Object[] params) {
		int result = getJdbcTemplate().update(sql, params);
		logSQLAndParameters("updateBySql", sql, params, result + " items");
		return result;
	}

	public void execSqlWithRowCallback(String sql, Object[] args, RowCallbackHandler callback) {
		getJdbcTemplate().query(sql, args, callback);
	}

	public void executeSql(String sql) {
		logSQLAndParameters("executeSql", sql, new Object[] {}, "");
		getJdbcTemplate().execute(sql);
	}


  @Override
  public List<MobileApp> search(MobileAppRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected MobileAppMapper mapper() {
    return getMobileAppMapper();
  }
}


