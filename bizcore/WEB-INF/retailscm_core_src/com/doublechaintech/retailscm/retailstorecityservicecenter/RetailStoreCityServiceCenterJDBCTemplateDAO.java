
package com.doublechaintech.retailscm.retailstorecityservicecenter;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.RetailscmNamingServiceDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.AccessKey;
import com.doublechaintech.retailscm.DateKey;
import com.doublechaintech.retailscm.StatsInfo;
import com.doublechaintech.retailscm.StatsItem;

import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;


import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.cityevent.CityEvent;
import com.doublechaintech.retailscm.citypartner.CityPartner;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.doublechaintech.retailscm.cityevent.CityEventDAO;
import com.doublechaintech.retailscm.citypartner.CityPartnerDAO;
import com.doublechaintech.retailscm.retailstore.RetailStoreDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class RetailStoreCityServiceCenterJDBCTemplateDAO extends RetailscmNamingServiceDAO implements RetailStoreCityServiceCenterDAO{
 
 	
 	private  RetailStoreProvinceCenterDAO  retailStoreProvinceCenterDAO;
 	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
	 	return this.retailStoreProvinceCenterDAO;
 	}


			
		
	
  	private  CityPartnerDAO  cityPartnerDAO;
 	public void setCityPartnerDAO(CityPartnerDAO pCityPartnerDAO){
 	
 		if(pCityPartnerDAO == null){
 			throw new IllegalStateException("Do not try to set cityPartnerDAO to null.");
 		}
	 	this.cityPartnerDAO = pCityPartnerDAO;
 	}
 	public CityPartnerDAO getCityPartnerDAO(){
 		if(this.cityPartnerDAO == null){
 			throw new IllegalStateException("The cityPartnerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityPartnerDAO;
 	}	
 	
			
		
	
  	private  PotentialCustomerDAO  potentialCustomerDAO;
 	public void setPotentialCustomerDAO(PotentialCustomerDAO pPotentialCustomerDAO){
 	
 		if(pPotentialCustomerDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerDAO to null.");
 		}
	 	this.potentialCustomerDAO = pPotentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
 		if(this.potentialCustomerDAO == null){
 			throw new IllegalStateException("The potentialCustomerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerDAO;
 	}	
 	
			
		
	
  	private  CityEventDAO  cityEventDAO;
 	public void setCityEventDAO(CityEventDAO pCityEventDAO){
 	
 		if(pCityEventDAO == null){
 			throw new IllegalStateException("Do not try to set cityEventDAO to null.");
 		}
	 	this.cityEventDAO = pCityEventDAO;
 	}
 	public CityEventDAO getCityEventDAO(){
 		if(this.cityEventDAO == null){
 			throw new IllegalStateException("The cityEventDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityEventDAO;
 	}	
 	
			
		
	
  	private  RetailStoreDAO  retailStoreDAO;
 	public void setRetailStoreDAO(RetailStoreDAO pRetailStoreDAO){
 	
 		if(pRetailStoreDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreDAO to null.");
 		}
	 	this.retailStoreDAO = pRetailStoreDAO;
 	}
 	public RetailStoreDAO getRetailStoreDAO(){
 		if(this.retailStoreDAO == null){
 			throw new IllegalStateException("The retailStoreDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreDAO;
 	}	
 	
			
		

	
	/*
	protected RetailStoreCityServiceCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCityServiceCenter(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreCityServiceCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreCityServiceCenter(RetailStoreCityServiceCenterTable.withId(id), options);
	}
	
	
	
	public RetailStoreCityServiceCenter save(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options){
		
		String methodName="save(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreCityServiceCenter, methodName, "retailStoreCityServiceCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreCityServiceCenter(retailStoreCityServiceCenter,options);
	}
	public RetailStoreCityServiceCenter clone(String retailStoreCityServiceCenterId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreCityServiceCenterTable.withId(retailStoreCityServiceCenterId),options);
	}
	
	protected RetailStoreCityServiceCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreCityServiceCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreCityServiceCenter newRetailStoreCityServiceCenter = loadInternalRetailStoreCityServiceCenter(accessKey, options);
		newRetailStoreCityServiceCenter.setVersion(0);
		
		
 		
 		if(isSaveCityPartnerListEnabled(options)){
 			for(CityPartner item: newRetailStoreCityServiceCenter.getCityPartnerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePotentialCustomerListEnabled(options)){
 			for(PotentialCustomer item: newRetailStoreCityServiceCenter.getPotentialCustomerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveCityEventListEnabled(options)){
 			for(CityEvent item: newRetailStoreCityServiceCenter.getCityEventList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreListEnabled(options)){
 			for(RetailStore item: newRetailStoreCityServiceCenter.getRetailStoreList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreCityServiceCenter(newRetailStoreCityServiceCenter,options);
		
		return newRetailStoreCityServiceCenter;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreCityServiceCenterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreCityServiceCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreCityServiceCenterNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreCityServiceCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreCityServiceCenterId, int version) throws Exception{
	
		String methodName="delete(String retailStoreCityServiceCenterId, int version)";
		assertMethodArgumentNotNull(retailStoreCityServiceCenterId, methodName, "retailStoreCityServiceCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreCityServiceCenterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreCityServiceCenterId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreCityServiceCenter disconnectFromAll(String retailStoreCityServiceCenterId, int version) throws Exception{
	
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadInternalRetailStoreCityServiceCenter(RetailStoreCityServiceCenterTable.withId(retailStoreCityServiceCenterId), emptyOptions());
		retailStoreCityServiceCenter.clearFromAll();
		this.saveRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
		return retailStoreCityServiceCenter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreCityServiceCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_city_service_center";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreCityServiceCenter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreCityServiceCenterTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractBelongsToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreCityServiceCenterTokens.BELONGSTO);
 	}

 	protected boolean isSaveBelongsToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreCityServiceCenterTokens.BELONGSTO);
 	}
 	

 	
 
		
	
	protected boolean isExtractCityPartnerListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.CITY_PARTNER_LIST);
		
 	}

	protected boolean isSaveCityPartnerListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.CITY_PARTNER_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractPotentialCustomerListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}

	protected boolean isSavePotentialCustomerListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractCityEventListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.CITY_EVENT_LIST);
		
 	}

	protected boolean isSaveCityEventListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.CITY_EVENT_LIST);
		
 	}
 	
 	
			
		
	
	protected boolean isExtractRetailStoreListEnabled(Map<String,Object> options){
		
 		return checkOptions(options,RetailStoreCityServiceCenterTokens.RETAIL_STORE_LIST);
		
 	}

	protected boolean isSaveRetailStoreListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreCityServiceCenterTokens.RETAIL_STORE_LIST);
		
 	}
 	
 	
			
		

	

	protected RetailStoreCityServiceCenterMapper getRetailStoreCityServiceCenterMapper(){
		return new RetailStoreCityServiceCenterMapper();
	}

	
	
	protected RetailStoreCityServiceCenter extractRetailStoreCityServiceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreCityServiceCenter retailStoreCityServiceCenter = loadSingleObject(accessKey, getRetailStoreCityServiceCenterMapper());
			return retailStoreCityServiceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreCityServiceCenterNotFoundException("RetailStoreCityServiceCenter("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreCityServiceCenter loadInternalRetailStoreCityServiceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreCityServiceCenter retailStoreCityServiceCenter = extractRetailStoreCityServiceCenter(accessKey, loadOptions);
 	
 		if(isExtractBelongsToEnabled(loadOptions)){
	 		extractBelongsTo(retailStoreCityServiceCenter, loadOptions);
 		}
 
		
		if(isExtractCityPartnerListEnabled(loadOptions)){
	 		extractCityPartnerList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		if(isExtractPotentialCustomerListEnabled(loadOptions)){
	 		extractPotentialCustomerList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		if(isExtractCityEventListEnabled(loadOptions)){
	 		extractCityEventList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		if(isExtractRetailStoreListEnabled(loadOptions)){
	 		extractRetailStoreList(retailStoreCityServiceCenter, loadOptions);
 		}		
		
		return retailStoreCityServiceCenter;
		
	}



	
	
	 

 	protected RetailStoreCityServiceCenter extractBelongsTo(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options) throws Exception{

		if(retailStoreCityServiceCenter.getBelongsTo() == null){
			return retailStoreCityServiceCenter;
		}
		String belongsToId = retailStoreCityServiceCenter.getBelongsTo().getId();
		if( belongsToId == null){
			return retailStoreCityServiceCenter;
		}
		RetailStoreProvinceCenter belongsTo = getRetailStoreProvinceCenterDAO().load(belongsToId,options);
		if(belongsTo != null){
			retailStoreCityServiceCenter.setBelongsTo(belongsTo);
		}
		
 		
 		return retailStoreCityServiceCenter;
 	}
 		
 
		
	protected void enhanceCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreCityServiceCenter extractCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		if(retailStoreCityServiceCenter == null){
			return null;
		}
		if(retailStoreCityServiceCenter.getId() == null){
			return retailStoreCityServiceCenter;
		}

		
		
		SmartList<CityPartner> cityPartnerList = getCityPartnerDAO().findCityPartnerByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(cityPartnerList != null){
			enhanceCityPartnerList(cityPartnerList,options);
			retailStoreCityServiceCenter.setCityPartnerList(cityPartnerList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
	protected void enhancePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreCityServiceCenter extractPotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		if(retailStoreCityServiceCenter == null){
			return null;
		}
		if(retailStoreCityServiceCenter.getId() == null){
			return retailStoreCityServiceCenter;
		}

		
		
		SmartList<PotentialCustomer> potentialCustomerList = getPotentialCustomerDAO().findPotentialCustomerByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(potentialCustomerList != null){
			enhancePotentialCustomerList(potentialCustomerList,options);
			retailStoreCityServiceCenter.setPotentialCustomerList(potentialCustomerList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
	protected void enhanceCityEventList(SmartList<CityEvent> cityEventList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreCityServiceCenter extractCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		if(retailStoreCityServiceCenter == null){
			return null;
		}
		if(retailStoreCityServiceCenter.getId() == null){
			return retailStoreCityServiceCenter;
		}

		
		
		SmartList<CityEvent> cityEventList = getCityEventDAO().findCityEventByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(cityEventList != null){
			enhanceCityEventList(cityEventList,options);
			retailStoreCityServiceCenter.setCityEventList(cityEventList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
	protected void enhanceRetailStoreList(SmartList<RetailStore> retailStoreList,Map<String,Object> options){
		
		//extract multiple list from difference 
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
		
		
		
	}
	protected RetailStoreCityServiceCenter extractRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		if(retailStoreCityServiceCenter == null){
			return null;
		}
		if(retailStoreCityServiceCenter.getId() == null){
			return retailStoreCityServiceCenter;
		}

		
		
		SmartList<RetailStore> retailStoreList = getRetailStoreDAO().findRetailStoreByCityServiceCenter(retailStoreCityServiceCenter.getId(),options);
		if(retailStoreList != null){
			enhanceRetailStoreList(retailStoreList,options);
			retailStoreCityServiceCenter.setRetailStoreList(retailStoreList);
		}
		
		return retailStoreCityServiceCenter;
	
	}	
		
		
  	
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId,Map<String,Object> options){
 	
  		SmartList<RetailStoreCityServiceCenter> resultList = queryWith(RetailStoreCityServiceCenterTable.COLUMN_BELONGS_TO, retailStoreProvinceCenterId, options, getRetailStoreCityServiceCenterMapper());
		analyzeRetailStoreCityServiceCenterByBelongsTo(resultList, retailStoreProvinceCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreCityServiceCenter> resultList =  queryWithRange(RetailStoreCityServiceCenterTable.COLUMN_BELONGS_TO, retailStoreProvinceCenterId, options, getRetailStoreCityServiceCenterMapper(), start, count);
 		analyzeRetailStoreCityServiceCenterByBelongsTo(resultList, retailStoreProvinceCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreCityServiceCenterByBelongsTo(SmartList<RetailStoreCityServiceCenter> resultList, String retailStoreProvinceCenterId, Map<String,Object> options){
	
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, retailStoreProvinceCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超城市服务中心");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStoreCityServiceCenter.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreCityServiceCenterByBelongsTo(String retailStoreProvinceCenterId,Map<String,Object> options){

 		return countWith(RetailStoreCityServiceCenterTable.COLUMN_BELONGS_TO, retailStoreProvinceCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreCityServiceCenterByBelongsToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreCityServiceCenterTable.COLUMN_BELONGS_TO, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStoreCityServiceCenter saveRetailStoreCityServiceCenter(RetailStoreCityServiceCenter  retailStoreCityServiceCenter){
		
		if(!retailStoreCityServiceCenter.isChanged()){
			return retailStoreCityServiceCenter;
		}
		
		
		String SQL=this.getSaveRetailStoreCityServiceCenterSQL(retailStoreCityServiceCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreCityServiceCenterParameters(retailStoreCityServiceCenter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreCityServiceCenter.incVersion();
		return retailStoreCityServiceCenter;
	
	}
	public SmartList<RetailStoreCityServiceCenter> saveRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList);
		
		batchRetailStoreCityServiceCenterCreate((List<RetailStoreCityServiceCenter>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreCityServiceCenterUpdate((List<RetailStoreCityServiceCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList){
			if(retailStoreCityServiceCenter.isChanged()){
				retailStoreCityServiceCenter.incVersion();
			}
			
		
		}
		
		
		return retailStoreCityServiceCenterList;
	}

	public SmartList<RetailStoreCityServiceCenter> removeRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options){
		
		
		super.removeList(retailStoreCityServiceCenterList, options);
		
		return retailStoreCityServiceCenterList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreCityServiceCenterBatchCreateArgs(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList ){
			Object [] parameters = prepareRetailStoreCityServiceCenterCreateParameters(retailStoreCityServiceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreCityServiceCenterBatchUpdateArgs(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList ){
			if(!retailStoreCityServiceCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreCityServiceCenterUpdateParameters(retailStoreCityServiceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreCityServiceCenterCreate(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreCityServiceCenterBatchCreateArgs(retailStoreCityServiceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreCityServiceCenterUpdate(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreCityServiceCenterBatchUpdateArgs(retailStoreCityServiceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreCityServiceCenterList(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		
		List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterCreateList=new ArrayList<RetailStoreCityServiceCenter>();
		List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterUpdateList=new ArrayList<RetailStoreCityServiceCenter>();
		
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenter: retailStoreCityServiceCenterList){
			if(isUpdateRequest(retailStoreCityServiceCenter)){
				retailStoreCityServiceCenterUpdateList.add( retailStoreCityServiceCenter);
				continue;
			}
			retailStoreCityServiceCenterCreateList.add(retailStoreCityServiceCenter);
		}
		
		return new Object[]{retailStoreCityServiceCenterCreateList,retailStoreCityServiceCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		return retailStoreCityServiceCenter.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreCityServiceCenterSQL(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		if(isUpdateRequest(retailStoreCityServiceCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreCityServiceCenterParameters(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		if(isUpdateRequest(retailStoreCityServiceCenter) ){
 			return prepareRetailStoreCityServiceCenterUpdateParameters(retailStoreCityServiceCenter);
 		}
 		return prepareRetailStoreCityServiceCenterCreateParameters(retailStoreCityServiceCenter);
 	}
 	protected Object[] prepareRetailStoreCityServiceCenterUpdateParameters(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = retailStoreCityServiceCenter.getName();
 		parameters[1] = retailStoreCityServiceCenter.getFounded(); 	
 		if(retailStoreCityServiceCenter.getBelongsTo() != null){
 			parameters[2] = retailStoreCityServiceCenter.getBelongsTo().getId();
 		}
 
 		parameters[3] = retailStoreCityServiceCenter.getLastUpdateTime();		
 		parameters[4] = retailStoreCityServiceCenter.nextVersion();
 		parameters[5] = retailStoreCityServiceCenter.getId();
 		parameters[6] = retailStoreCityServiceCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreCityServiceCenterCreateParameters(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
		Object[] parameters = new Object[5];
		String newRetailStoreCityServiceCenterId=getNextId();
		retailStoreCityServiceCenter.setId(newRetailStoreCityServiceCenterId);
		parameters[0] =  retailStoreCityServiceCenter.getId();
 
 		parameters[1] = retailStoreCityServiceCenter.getName();
 		parameters[2] = retailStoreCityServiceCenter.getFounded(); 	
 		if(retailStoreCityServiceCenter.getBelongsTo() != null){
 			parameters[3] = retailStoreCityServiceCenter.getBelongsTo().getId();
 		
 		}
 		
 		parameters[4] = retailStoreCityServiceCenter.getLastUpdateTime();		
 				
 		return parameters;
 	}
 	
	protected RetailStoreCityServiceCenter saveInternalRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		saveRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
 	
 		if(isSaveBelongsToEnabled(options)){
	 		saveBelongsTo(retailStoreCityServiceCenter, options);
 		}
 
		
		if(isSaveCityPartnerListEnabled(options)){
	 		saveCityPartnerList(retailStoreCityServiceCenter, options);
	 		//removeCityPartnerList(retailStoreCityServiceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSavePotentialCustomerListEnabled(options)){
	 		savePotentialCustomerList(retailStoreCityServiceCenter, options);
	 		//removePotentialCustomerList(retailStoreCityServiceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveCityEventListEnabled(options)){
	 		saveCityEventList(retailStoreCityServiceCenter, options);
	 		//removeCityEventList(retailStoreCityServiceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRetailStoreListEnabled(options)){
	 		saveRetailStoreList(retailStoreCityServiceCenter, options);
	 		//removeRetailStoreList(retailStoreCityServiceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreCityServiceCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreCityServiceCenter saveBelongsTo(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreCityServiceCenter.getBelongsTo() == null){
 			return retailStoreCityServiceCenter;//do nothing when it is null
 		}
 		
 		getRetailStoreProvinceCenterDAO().save(retailStoreCityServiceCenter.getBelongsTo(),options);
 		return retailStoreCityServiceCenter;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public RetailStoreCityServiceCenter planToRemoveCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String cityPartnerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityPartner.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenter.getId());
		key.put(CityPartner.ID_PROPERTY, cityPartnerIds);
		
		SmartList<CityPartner> externalCityPartnerList = getCityPartnerDAO().
				findCityPartnerWithKey(key, options);
		if(externalCityPartnerList == null){
			return retailStoreCityServiceCenter;
		}
		if(externalCityPartnerList.isEmpty()){
			return retailStoreCityServiceCenter;
		}
		
		for(CityPartner cityPartner: externalCityPartnerList){

			cityPartner.clearFromAll();
		}
		
		
		SmartList<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();		
		cityPartnerList.addAllToRemoveList(externalCityPartnerList);
		return retailStoreCityServiceCenter;	
	
	}


	public RetailStoreCityServiceCenter planToRemovePotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String potentialCustomerIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenter.getId());
		key.put(PotentialCustomer.ID_PROPERTY, potentialCustomerIds);
		
		SmartList<PotentialCustomer> externalPotentialCustomerList = getPotentialCustomerDAO().
				findPotentialCustomerWithKey(key, options);
		if(externalPotentialCustomerList == null){
			return retailStoreCityServiceCenter;
		}
		if(externalPotentialCustomerList.isEmpty()){
			return retailStoreCityServiceCenter;
		}
		
		for(PotentialCustomer potentialCustomer: externalPotentialCustomerList){

			potentialCustomer.clearFromAll();
		}
		
		
		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();		
		potentialCustomerList.addAllToRemoveList(externalPotentialCustomerList);
		return retailStoreCityServiceCenter;	
	
	}


	//disconnect RetailStoreCityServiceCenter with city_partner in PotentialCustomer
	public RetailStoreCityServiceCenter planToRemovePotentialCustomerListWithCityPartner(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenter.getId());
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartnerId);
		
		SmartList<PotentialCustomer> externalPotentialCustomerList = getPotentialCustomerDAO().
				findPotentialCustomerWithKey(key, options);
		if(externalPotentialCustomerList == null){
			return retailStoreCityServiceCenter;
		}
		if(externalPotentialCustomerList.isEmpty()){
			return retailStoreCityServiceCenter;
		}
		
		for(PotentialCustomer potentialCustomer: externalPotentialCustomerList){
			potentialCustomer.clearCityPartner();
			potentialCustomer.clearCityServiceCenter();
			
		}
		
		
		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();		
		potentialCustomerList.addAllToRemoveList(externalPotentialCustomerList);
		return retailStoreCityServiceCenter;
	}
	
	public int countPotentialCustomerListWithCityPartner(String retailStoreCityServiceCenterId, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenterId);
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartnerId);
		
		int count = getPotentialCustomerDAO().countPotentialCustomerWithKey(key, options);
		return count;
	}
	
	public RetailStoreCityServiceCenter planToRemoveCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String cityEventIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(CityEvent.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenter.getId());
		key.put(CityEvent.ID_PROPERTY, cityEventIds);
		
		SmartList<CityEvent> externalCityEventList = getCityEventDAO().
				findCityEventWithKey(key, options);
		if(externalCityEventList == null){
			return retailStoreCityServiceCenter;
		}
		if(externalCityEventList.isEmpty()){
			return retailStoreCityServiceCenter;
		}
		
		for(CityEvent cityEvent: externalCityEventList){

			cityEvent.clearFromAll();
		}
		
		
		SmartList<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();		
		cityEventList.addAllToRemoveList(externalCityEventList);
		return retailStoreCityServiceCenter;	
	
	}


	public RetailStoreCityServiceCenter planToRemoveRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String retailStoreIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenter.getId());
		key.put(RetailStore.ID_PROPERTY, retailStoreIds);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCityServiceCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCityServiceCenter;
		}
		
		for(RetailStore retailStore: externalRetailStoreList){

			retailStore.clearFromAll();
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCityServiceCenter;	
	
	}


	//disconnect RetailStoreCityServiceCenter with retail_store_country_center in RetailStore
	public RetailStoreCityServiceCenter planToRemoveRetailStoreListWithRetailStoreCountryCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenter.getId());
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		SmartList<RetailStore> externalRetailStoreList = getRetailStoreDAO().
				findRetailStoreWithKey(key, options);
		if(externalRetailStoreList == null){
			return retailStoreCityServiceCenter;
		}
		if(externalRetailStoreList.isEmpty()){
			return retailStoreCityServiceCenter;
		}
		
		for(RetailStore retailStore: externalRetailStoreList){
			retailStore.clearRetailStoreCountryCenter();
			retailStore.clearCityServiceCenter();
			
		}
		
		
		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();		
		retailStoreList.addAllToRemoveList(externalRetailStoreList);
		return retailStoreCityServiceCenter;
	}
	
	public int countRetailStoreListWithRetailStoreCountryCenter(String retailStoreCityServiceCenterId, String retailStoreCountryCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStore.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenterId);
		key.put(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenterId);
		
		int count = getRetailStoreDAO().countRetailStoreWithKey(key, options);
		return count;
	}
	

		
	protected RetailStoreCityServiceCenter saveCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();
		if(cityPartnerList == null){
			//null list means nothing
			return retailStoreCityServiceCenter;
		}
		SmartList<CityPartner> mergedUpdateCityPartnerList = new SmartList<CityPartner>();
		
		
		mergedUpdateCityPartnerList.addAll(cityPartnerList); 
		if(cityPartnerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCityPartnerList.addAll(cityPartnerList.getToRemoveList());
			cityPartnerList.removeAll(cityPartnerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCityPartnerDAO().saveCityPartnerList(mergedUpdateCityPartnerList,options);
		
		if(cityPartnerList.getToRemoveList() != null){
			cityPartnerList.removeAll(cityPartnerList.getToRemoveList());
		}
		
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removeCityPartnerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();
		if(cityPartnerList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<CityPartner> toRemoveCityPartnerList = cityPartnerList.getToRemoveList();
		
		if(toRemoveCityPartnerList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemoveCityPartnerList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityPartnerDAO().removeCityPartnerList(toRemoveCityPartnerList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStoreCityServiceCenter savePotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();
		if(potentialCustomerList == null){
			//null list means nothing
			return retailStoreCityServiceCenter;
		}
		SmartList<PotentialCustomer> mergedUpdatePotentialCustomerList = new SmartList<PotentialCustomer>();
		
		
		mergedUpdatePotentialCustomerList.addAll(potentialCustomerList); 
		if(potentialCustomerList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePotentialCustomerList.addAll(potentialCustomerList.getToRemoveList());
			potentialCustomerList.removeAll(potentialCustomerList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getPotentialCustomerDAO().savePotentialCustomerList(mergedUpdatePotentialCustomerList,options);
		
		if(potentialCustomerList.getToRemoveList() != null){
			potentialCustomerList.removeAll(potentialCustomerList.getToRemoveList());
		}
		
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removePotentialCustomerList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();
		if(potentialCustomerList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<PotentialCustomer> toRemovePotentialCustomerList = potentialCustomerList.getToRemoveList();
		
		if(toRemovePotentialCustomerList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemovePotentialCustomerList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerDAO().removePotentialCustomerList(toRemovePotentialCustomerList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStoreCityServiceCenter saveCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();
		if(cityEventList == null){
			//null list means nothing
			return retailStoreCityServiceCenter;
		}
		SmartList<CityEvent> mergedUpdateCityEventList = new SmartList<CityEvent>();
		
		
		mergedUpdateCityEventList.addAll(cityEventList); 
		if(cityEventList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateCityEventList.addAll(cityEventList.getToRemoveList());
			cityEventList.removeAll(cityEventList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getCityEventDAO().saveCityEventList(mergedUpdateCityEventList,options);
		
		if(cityEventList.getToRemoveList() != null){
			cityEventList.removeAll(cityEventList.getToRemoveList());
		}
		
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removeCityEventList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();
		if(cityEventList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<CityEvent> toRemoveCityEventList = cityEventList.getToRemoveList();
		
		if(toRemoveCityEventList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemoveCityEventList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getCityEventDAO().removeCityEventList(toRemoveCityEventList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStoreCityServiceCenter saveRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();
		if(retailStoreList == null){
			//null list means nothing
			return retailStoreCityServiceCenter;
		}
		SmartList<RetailStore> mergedUpdateRetailStoreList = new SmartList<RetailStore>();
		
		
		mergedUpdateRetailStoreList.addAll(retailStoreList); 
		if(retailStoreList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreList.addAll(retailStoreList.getToRemoveList());
			retailStoreList.removeAll(retailStoreList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRetailStoreDAO().saveRetailStoreList(mergedUpdateRetailStoreList,options);
		
		if(retailStoreList.getToRemoveList() != null){
			retailStoreList.removeAll(retailStoreList.getToRemoveList());
		}
		
		
		return retailStoreCityServiceCenter;
	
	}
	
	protected RetailStoreCityServiceCenter removeRetailStoreList(RetailStoreCityServiceCenter retailStoreCityServiceCenter, Map<String,Object> options){
	
	
		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();
		if(retailStoreList == null){
			return retailStoreCityServiceCenter;
		}	
	
		SmartList<RetailStore> toRemoveRetailStoreList = retailStoreList.getToRemoveList();
		
		if(toRemoveRetailStoreList == null){
			return retailStoreCityServiceCenter;
		}
		if(toRemoveRetailStoreList.isEmpty()){
			return retailStoreCityServiceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreDAO().removeRetailStoreList(toRemoveRetailStoreList,options);
		
		return retailStoreCityServiceCenter;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreCityServiceCenter present(RetailStoreCityServiceCenter retailStoreCityServiceCenter,Map<String, Object> options){
	
		presentCityPartnerList(retailStoreCityServiceCenter,options);
		presentPotentialCustomerList(retailStoreCityServiceCenter,options);
		presentCityEventList(retailStoreCityServiceCenter,options);
		presentRetailStoreList(retailStoreCityServiceCenter,options);

		return retailStoreCityServiceCenter;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCityServiceCenter presentCityPartnerList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<CityPartner> cityPartnerList = retailStoreCityServiceCenter.getCityPartnerList();		
				SmartList<CityPartner> newList= presentSubList(retailStoreCityServiceCenter.getId(),
				cityPartnerList,
				options,
				getCityPartnerDAO()::countCityPartnerByCityServiceCenter,
				getCityPartnerDAO()::findCityPartnerByCityServiceCenter
				);

		
		retailStoreCityServiceCenter.setCityPartnerList(newList);
		

		return retailStoreCityServiceCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCityServiceCenter presentPotentialCustomerList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<PotentialCustomer> potentialCustomerList = retailStoreCityServiceCenter.getPotentialCustomerList();		
				SmartList<PotentialCustomer> newList= presentSubList(retailStoreCityServiceCenter.getId(),
				potentialCustomerList,
				options,
				getPotentialCustomerDAO()::countPotentialCustomerByCityServiceCenter,
				getPotentialCustomerDAO()::findPotentialCustomerByCityServiceCenter
				);

		
		retailStoreCityServiceCenter.setPotentialCustomerList(newList);
		

		return retailStoreCityServiceCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCityServiceCenter presentCityEventList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<CityEvent> cityEventList = retailStoreCityServiceCenter.getCityEventList();		
				SmartList<CityEvent> newList= presentSubList(retailStoreCityServiceCenter.getId(),
				cityEventList,
				options,
				getCityEventDAO()::countCityEventByCityServiceCenter,
				getCityEventDAO()::findCityEventByCityServiceCenter
				);

		
		retailStoreCityServiceCenter.setCityEventList(newList);
		

		return retailStoreCityServiceCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreCityServiceCenter presentRetailStoreList(
			RetailStoreCityServiceCenter retailStoreCityServiceCenter,
			Map<String, Object> options) {

		SmartList<RetailStore> retailStoreList = retailStoreCityServiceCenter.getRetailStoreList();		
				SmartList<RetailStore> newList= presentSubList(retailStoreCityServiceCenter.getId(),
				retailStoreList,
				options,
				getRetailStoreDAO()::countRetailStoreByCityServiceCenter,
				getRetailStoreDAO()::findRetailStoreByCityServiceCenter
				);

		
		retailStoreCityServiceCenter.setRetailStoreList(newList);
		

		return retailStoreCityServiceCenter;
	}			
		

	
    public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForCityPartner(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCityServiceCenterTable.COLUMN_NAME, filterKey, pageNo, pageSize, getRetailStoreCityServiceCenterMapper());
    }
		
    public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForPotentialCustomer(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCityServiceCenterTable.COLUMN_NAME, filterKey, pageNo, pageSize, getRetailStoreCityServiceCenterMapper());
    }
		
    public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForCityEvent(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCityServiceCenterTable.COLUMN_NAME, filterKey, pageNo, pageSize, getRetailStoreCityServiceCenterMapper());
    }
		
    public SmartList<RetailStoreCityServiceCenter> requestCandidateRetailStoreCityServiceCenterForRetailStore(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreCityServiceCenterTable.COLUMN_NAME, filterKey, pageNo, pageSize, getRetailStoreCityServiceCenterMapper());
    }
		

	protected String getTableName(){
		return RetailStoreCityServiceCenterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList) {		
		this.enhanceListInternal(retailStoreCityServiceCenterList, this.getRetailStoreCityServiceCenterMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = ownerEntity.collectRefsWithType(RetailStoreCityServiceCenter.INTERNAL_TYPE);
		this.enhanceList(retailStoreCityServiceCenterList);
		
	}
	
	@Override
	public SmartList<RetailStoreCityServiceCenter> findRetailStoreCityServiceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreCityServiceCenterMapper());

	}
	@Override
	public int countRetailStoreCityServiceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreCityServiceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreCityServiceCenter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreCityServiceCenterMapper());
	}
}


