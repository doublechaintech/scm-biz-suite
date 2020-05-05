
package com.doublechaintech.retailscm.retailstoreprovincecenter;

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


import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartmentDAO;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class RetailStoreProvinceCenterJDBCTemplateDAO extends RetailscmBaseDAOImpl implements RetailStoreProvinceCenterDAO{

	protected RetailStoreCountryCenterDAO retailStoreCountryCenterDAO;
	public void setRetailStoreCountryCenterDAO(RetailStoreCountryCenterDAO retailStoreCountryCenterDAO){
 	
 		if(retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCountryCenterDAO to null.");
 		}
	 	this.retailStoreCountryCenterDAO = retailStoreCountryCenterDAO;
 	}
 	public RetailStoreCountryCenterDAO getRetailStoreCountryCenterDAO(){
 		if(this.retailStoreCountryCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCountryCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCountryCenterDAO;
 	}	

	protected ProvinceCenterDepartmentDAO provinceCenterDepartmentDAO;
	public void setProvinceCenterDepartmentDAO(ProvinceCenterDepartmentDAO provinceCenterDepartmentDAO){
 	
 		if(provinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterDepartmentDAO to null.");
 		}
	 	this.provinceCenterDepartmentDAO = provinceCenterDepartmentDAO;
 	}
 	public ProvinceCenterDepartmentDAO getProvinceCenterDepartmentDAO(){
 		if(this.provinceCenterDepartmentDAO == null){
 			throw new IllegalStateException("The provinceCenterDepartmentDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterDepartmentDAO;
 	}	

	protected ProvinceCenterEmployeeDAO provinceCenterEmployeeDAO;
	public void setProvinceCenterEmployeeDAO(ProvinceCenterEmployeeDAO provinceCenterEmployeeDAO){
 	
 		if(provinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("Do not try to set provinceCenterEmployeeDAO to null.");
 		}
	 	this.provinceCenterEmployeeDAO = provinceCenterEmployeeDAO;
 	}
 	public ProvinceCenterEmployeeDAO getProvinceCenterEmployeeDAO(){
 		if(this.provinceCenterEmployeeDAO == null){
 			throw new IllegalStateException("The provinceCenterEmployeeDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.provinceCenterEmployeeDAO;
 	}	

	protected RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO;
	public void setRetailStoreCityServiceCenterDAO(RetailStoreCityServiceCenterDAO retailStoreCityServiceCenterDAO){
 	
 		if(retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreCityServiceCenterDAO to null.");
 		}
	 	this.retailStoreCityServiceCenterDAO = retailStoreCityServiceCenterDAO;
 	}
 	public RetailStoreCityServiceCenterDAO getRetailStoreCityServiceCenterDAO(){
 		if(this.retailStoreCityServiceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreCityServiceCenterDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.retailStoreCityServiceCenterDAO;
 	}	

	
	/*
	protected RetailStoreProvinceCenter load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreProvinceCenter(accessKey, options);
	}
	*/
	
	public SmartList<RetailStoreProvinceCenter> loadAll() {
	    return this.loadAll(getRetailStoreProvinceCenterMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public RetailStoreProvinceCenter load(String id,Map<String,Object> options) throws Exception{
		return loadInternalRetailStoreProvinceCenter(RetailStoreProvinceCenterTable.withId(id), options);
	}
	
	
	
	public RetailStoreProvinceCenter save(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options){
		
		String methodName="save(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(retailStoreProvinceCenter, methodName, "retailStoreProvinceCenter");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalRetailStoreProvinceCenter(retailStoreProvinceCenter,options);
	}
	public RetailStoreProvinceCenter clone(String retailStoreProvinceCenterId, Map<String,Object> options) throws Exception{
	
		return clone(RetailStoreProvinceCenterTable.withId(retailStoreProvinceCenterId),options);
	}
	
	protected RetailStoreProvinceCenter clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String retailStoreProvinceCenterId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		RetailStoreProvinceCenter newRetailStoreProvinceCenter = loadInternalRetailStoreProvinceCenter(accessKey, options);
		newRetailStoreProvinceCenter.setVersion(0);
		
		
 		
 		if(isSaveProvinceCenterDepartmentListEnabled(options)){
 			for(ProvinceCenterDepartment item: newRetailStoreProvinceCenter.getProvinceCenterDepartmentList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveProvinceCenterEmployeeListEnabled(options)){
 			for(ProvinceCenterEmployee item: newRetailStoreProvinceCenter.getProvinceCenterEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveRetailStoreCityServiceCenterListEnabled(options)){
 			for(RetailStoreCityServiceCenter item: newRetailStoreProvinceCenter.getRetailStoreCityServiceCenterList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalRetailStoreProvinceCenter(newRetailStoreProvinceCenter,options);
		
		return newRetailStoreProvinceCenter;
	}
	
	
	
	

	protected void throwIfHasException(String retailStoreProvinceCenterId,int version,int count) throws Exception{
		if (count == 1) {
			throw new RetailStoreProvinceCenterVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new RetailStoreProvinceCenterNotFoundException(
					"The " + this.getTableName() + "(" + retailStoreProvinceCenterId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String retailStoreProvinceCenterId, int version) throws Exception{
	
		String methodName="delete(String retailStoreProvinceCenterId, int version)";
		assertMethodArgumentNotNull(retailStoreProvinceCenterId, methodName, "retailStoreProvinceCenterId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{retailStoreProvinceCenterId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(retailStoreProvinceCenterId,version);
		}
		
	
	}
	
	
	
	
	

	public RetailStoreProvinceCenter disconnectFromAll(String retailStoreProvinceCenterId, int version) throws Exception{
	
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = loadInternalRetailStoreProvinceCenter(RetailStoreProvinceCenterTable.withId(retailStoreProvinceCenterId), emptyOptions());
		retailStoreProvinceCenter.clearFromAll();
		this.saveRetailStoreProvinceCenter(retailStoreProvinceCenter);
		return retailStoreProvinceCenter;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return RetailStoreProvinceCenterTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "retail_store_province_center";
	}
	@Override
	protected String getBeanName() {
		
		return "retailStoreProvinceCenter";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return RetailStoreProvinceCenterTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCountryEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, RetailStoreProvinceCenterTokens.COUNTRY);
 	}

 	protected boolean isSaveCountryEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, RetailStoreProvinceCenterTokens.COUNTRY);
 	}
 	

 	
 
		
	
	protected boolean isExtractProvinceCenterDepartmentListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreProvinceCenterTokens.PROVINCE_CENTER_DEPARTMENT_LIST);
 	}
 	protected boolean isAnalyzeProvinceCenterDepartmentListEnabled(Map<String,Object> options){		 		
 		return RetailStoreProvinceCenterTokens.of(options).analyzeProvinceCenterDepartmentListEnabled();
 	}
	
	protected boolean isSaveProvinceCenterDepartmentListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreProvinceCenterTokens.PROVINCE_CENTER_DEPARTMENT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractProvinceCenterEmployeeListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreProvinceCenterTokens.PROVINCE_CENTER_EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeProvinceCenterEmployeeListEnabled(Map<String,Object> options){		 		
 		return RetailStoreProvinceCenterTokens.of(options).analyzeProvinceCenterEmployeeListEnabled();
 	}
	
	protected boolean isSaveProvinceCenterEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreProvinceCenterTokens.PROVINCE_CENTER_EMPLOYEE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractRetailStoreCityServiceCenterListEnabled(Map<String,Object> options){		
 		return checkOptions(options,RetailStoreProvinceCenterTokens.RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
 	}
 	protected boolean isAnalyzeRetailStoreCityServiceCenterListEnabled(Map<String,Object> options){		 		
 		return RetailStoreProvinceCenterTokens.of(options).analyzeRetailStoreCityServiceCenterListEnabled();
 	}
	
	protected boolean isSaveRetailStoreCityServiceCenterListEnabled(Map<String,Object> options){
		return checkOptions(options, RetailStoreProvinceCenterTokens.RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
		
 	}
 	
		

	

	protected RetailStoreProvinceCenterMapper getRetailStoreProvinceCenterMapper(){
		return new RetailStoreProvinceCenterMapper();
	}

	
	
	protected RetailStoreProvinceCenter extractRetailStoreProvinceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			RetailStoreProvinceCenter retailStoreProvinceCenter = loadSingleObject(accessKey, getRetailStoreProvinceCenterMapper());
			return retailStoreProvinceCenter;
		}catch(EmptyResultDataAccessException e){
			throw new RetailStoreProvinceCenterNotFoundException("RetailStoreProvinceCenter("+accessKey+") is not found!");
		}

	}

	
	

	protected RetailStoreProvinceCenter loadInternalRetailStoreProvinceCenter(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		RetailStoreProvinceCenter retailStoreProvinceCenter = extractRetailStoreProvinceCenter(accessKey, loadOptions);
 	
 		if(isExtractCountryEnabled(loadOptions)){
	 		extractCountry(retailStoreProvinceCenter, loadOptions);
 		}
 
		
		if(isExtractProvinceCenterDepartmentListEnabled(loadOptions)){
	 		extractProvinceCenterDepartmentList(retailStoreProvinceCenter, loadOptions);
 		}	
 		
 		
		
		if(isExtractProvinceCenterEmployeeListEnabled(loadOptions)){
	 		extractProvinceCenterEmployeeList(retailStoreProvinceCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeProvinceCenterEmployeeListEnabled(loadOptions)){
	 		analyzeProvinceCenterEmployeeList(retailStoreProvinceCenter, loadOptions);
 		}
 		
		
		if(isExtractRetailStoreCityServiceCenterListEnabled(loadOptions)){
	 		extractRetailStoreCityServiceCenterList(retailStoreProvinceCenter, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeRetailStoreCityServiceCenterListEnabled(loadOptions)){
	 		analyzeRetailStoreCityServiceCenterList(retailStoreProvinceCenter, loadOptions);
 		}
 		
		
		return retailStoreProvinceCenter;
		
	}

	 

 	protected RetailStoreProvinceCenter extractCountry(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options) throws Exception{

		if(retailStoreProvinceCenter.getCountry() == null){
			return retailStoreProvinceCenter;
		}
		String countryId = retailStoreProvinceCenter.getCountry().getId();
		if( countryId == null){
			return retailStoreProvinceCenter;
		}
		RetailStoreCountryCenter country = getRetailStoreCountryCenterDAO().load(countryId,options);
		if(country != null){
			retailStoreProvinceCenter.setCountry(country);
		}
		
 		
 		return retailStoreProvinceCenter;
 	}
 		
 
		
	protected void enhanceProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreProvinceCenter extractProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		if(retailStoreProvinceCenter == null){
			return null;
		}
		if(retailStoreProvinceCenter.getId() == null){
			return retailStoreProvinceCenter;
		}

		
		
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = getProvinceCenterDepartmentDAO().findProvinceCenterDepartmentByProvinceCenter(retailStoreProvinceCenter.getId(),options);
		if(provinceCenterDepartmentList != null){
			enhanceProvinceCenterDepartmentList(provinceCenterDepartmentList,options);
			retailStoreProvinceCenter.setProvinceCenterDepartmentList(provinceCenterDepartmentList);
		}
		
		return retailStoreProvinceCenter;
	
	}	
	
	protected RetailStoreProvinceCenter analyzeProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		if(retailStoreProvinceCenter == null){
			return null;
		}
		if(retailStoreProvinceCenter.getId() == null){
			return retailStoreProvinceCenter;
		}

		
		
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();
		if(provinceCenterDepartmentList != null){
			getProvinceCenterDepartmentDAO().analyzeProvinceCenterDepartmentByProvinceCenter(provinceCenterDepartmentList, retailStoreProvinceCenter.getId(), options);
			
		}
		
		return retailStoreProvinceCenter;
	
	}	
	
		
	protected void enhanceProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreProvinceCenter extractProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		if(retailStoreProvinceCenter == null){
			return null;
		}
		if(retailStoreProvinceCenter.getId() == null){
			return retailStoreProvinceCenter;
		}

		
		
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeByProvinceCenter(retailStoreProvinceCenter.getId(),options);
		if(provinceCenterEmployeeList != null){
			enhanceProvinceCenterEmployeeList(provinceCenterEmployeeList,options);
			retailStoreProvinceCenter.setProvinceCenterEmployeeList(provinceCenterEmployeeList);
		}
		
		return retailStoreProvinceCenter;
	
	}	
	
	protected RetailStoreProvinceCenter analyzeProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		if(retailStoreProvinceCenter == null){
			return null;
		}
		if(retailStoreProvinceCenter.getId() == null){
			return retailStoreProvinceCenter;
		}

		
		
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList != null){
			getProvinceCenterEmployeeDAO().analyzeProvinceCenterEmployeeByProvinceCenter(provinceCenterEmployeeList, retailStoreProvinceCenter.getId(), options);
			
		}
		
		return retailStoreProvinceCenter;
	
	}	
	
		
	protected void enhanceRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected RetailStoreProvinceCenter extractRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		if(retailStoreProvinceCenter == null){
			return null;
		}
		if(retailStoreProvinceCenter.getId() == null){
			return retailStoreProvinceCenter;
		}

		
		
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = getRetailStoreCityServiceCenterDAO().findRetailStoreCityServiceCenterByBelongsTo(retailStoreProvinceCenter.getId(),options);
		if(retailStoreCityServiceCenterList != null){
			enhanceRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList,options);
			retailStoreProvinceCenter.setRetailStoreCityServiceCenterList(retailStoreCityServiceCenterList);
		}
		
		return retailStoreProvinceCenter;
	
	}	
	
	protected RetailStoreProvinceCenter analyzeRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		if(retailStoreProvinceCenter == null){
			return null;
		}
		if(retailStoreProvinceCenter.getId() == null){
			return retailStoreProvinceCenter;
		}

		
		
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();
		if(retailStoreCityServiceCenterList != null){
			getRetailStoreCityServiceCenterDAO().analyzeRetailStoreCityServiceCenterByBelongsTo(retailStoreCityServiceCenterList, retailStoreProvinceCenter.getId(), options);
			
		}
		
		return retailStoreProvinceCenter;
	
	}	
	
		
		
  	
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId,Map<String,Object> options){
 	
  		SmartList<RetailStoreProvinceCenter> resultList = queryWith(RetailStoreProvinceCenterTable.COLUMN_COUNTRY, retailStoreCountryCenterId, options, getRetailStoreProvinceCenterMapper());
		// analyzeRetailStoreProvinceCenterByCountry(resultList, retailStoreCountryCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<RetailStoreProvinceCenter> resultList =  queryWithRange(RetailStoreProvinceCenterTable.COLUMN_COUNTRY, retailStoreCountryCenterId, options, getRetailStoreProvinceCenterMapper(), start, count);
 		//analyzeRetailStoreProvinceCenterByCountry(resultList, retailStoreCountryCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeRetailStoreProvinceCenterByCountry(SmartList<RetailStoreProvinceCenter> resultList, String retailStoreCountryCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(RetailStoreProvinceCenter.COUNTRY_PROPERTY, retailStoreCountryCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("双链小超省中心");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(RetailStoreProvinceCenter.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countRetailStoreProvinceCenterByCountry(String retailStoreCountryCenterId,Map<String,Object> options){

 		return countWith(RetailStoreProvinceCenterTable.COLUMN_COUNTRY, retailStoreCountryCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countRetailStoreProvinceCenterByCountryIds(String[] ids, Map<String, Object> options) {
		return countWithIds(RetailStoreProvinceCenterTable.COLUMN_COUNTRY, ids, options);
	}
 	
 	
		
		
		

	

	protected RetailStoreProvinceCenter saveRetailStoreProvinceCenter(RetailStoreProvinceCenter  retailStoreProvinceCenter){
		
		if(!retailStoreProvinceCenter.isChanged()){
			return retailStoreProvinceCenter;
		}
		
		
		String SQL=this.getSaveRetailStoreProvinceCenterSQL(retailStoreProvinceCenter);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveRetailStoreProvinceCenterParameters(retailStoreProvinceCenter);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		retailStoreProvinceCenter.incVersion();
		return retailStoreProvinceCenter;
	
	}
	public SmartList<RetailStoreProvinceCenter> saveRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitRetailStoreProvinceCenterList(retailStoreProvinceCenterList);
		
		batchRetailStoreProvinceCenterCreate((List<RetailStoreProvinceCenter>)lists[CREATE_LIST_INDEX]);
		
		batchRetailStoreProvinceCenterUpdate((List<RetailStoreProvinceCenter>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList){
			if(retailStoreProvinceCenter.isChanged()){
				retailStoreProvinceCenter.incVersion();
			}
			
		
		}
		
		
		return retailStoreProvinceCenterList;
	}

	public SmartList<RetailStoreProvinceCenter> removeRetailStoreProvinceCenterList(SmartList<RetailStoreProvinceCenter> retailStoreProvinceCenterList,Map<String,Object> options){
		
		
		super.removeList(retailStoreProvinceCenterList, options);
		
		return retailStoreProvinceCenterList;
		
		
	}
	
	protected List<Object[]> prepareRetailStoreProvinceCenterBatchCreateArgs(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList ){
			Object [] parameters = prepareRetailStoreProvinceCenterCreateParameters(retailStoreProvinceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareRetailStoreProvinceCenterBatchUpdateArgs(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(RetailStoreProvinceCenter retailStoreProvinceCenter:retailStoreProvinceCenterList ){
			if(!retailStoreProvinceCenter.isChanged()){
				continue;
			}
			Object [] parameters = prepareRetailStoreProvinceCenterUpdateParameters(retailStoreProvinceCenter);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchRetailStoreProvinceCenterCreate(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareRetailStoreProvinceCenterBatchCreateArgs(retailStoreProvinceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchRetailStoreProvinceCenterUpdate(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareRetailStoreProvinceCenterBatchUpdateArgs(retailStoreProvinceCenterList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitRetailStoreProvinceCenterList(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList){
		
		List<RetailStoreProvinceCenter> retailStoreProvinceCenterCreateList=new ArrayList<RetailStoreProvinceCenter>();
		List<RetailStoreProvinceCenter> retailStoreProvinceCenterUpdateList=new ArrayList<RetailStoreProvinceCenter>();
		
		for(RetailStoreProvinceCenter retailStoreProvinceCenter: retailStoreProvinceCenterList){
			if(isUpdateRequest(retailStoreProvinceCenter)){
				retailStoreProvinceCenterUpdateList.add( retailStoreProvinceCenter);
				continue;
			}
			retailStoreProvinceCenterCreateList.add(retailStoreProvinceCenter);
		}
		
		return new Object[]{retailStoreProvinceCenterCreateList,retailStoreProvinceCenterUpdateList};
	}
	
	protected boolean isUpdateRequest(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		return retailStoreProvinceCenter.getVersion() > 0;
 	}
 	protected String getSaveRetailStoreProvinceCenterSQL(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		if(isUpdateRequest(retailStoreProvinceCenter)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveRetailStoreProvinceCenterParameters(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		if(isUpdateRequest(retailStoreProvinceCenter) ){
 			return prepareRetailStoreProvinceCenterUpdateParameters(retailStoreProvinceCenter);
 		}
 		return prepareRetailStoreProvinceCenterCreateParameters(retailStoreProvinceCenter);
 	}
 	protected Object[] prepareRetailStoreProvinceCenterUpdateParameters(RetailStoreProvinceCenter retailStoreProvinceCenter){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = retailStoreProvinceCenter.getName();
 		
 		
 		parameters[1] = retailStoreProvinceCenter.getFounded();
 		 	
 		if(retailStoreProvinceCenter.getCountry() != null){
 			parameters[2] = retailStoreProvinceCenter.getCountry().getId();
 		}
 
 		
 		parameters[3] = retailStoreProvinceCenter.getLastUpdateTime();
 				
 		parameters[4] = retailStoreProvinceCenter.nextVersion();
 		parameters[5] = retailStoreProvinceCenter.getId();
 		parameters[6] = retailStoreProvinceCenter.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareRetailStoreProvinceCenterCreateParameters(RetailStoreProvinceCenter retailStoreProvinceCenter){
		Object[] parameters = new Object[5];
		String newRetailStoreProvinceCenterId=getNextId();
		retailStoreProvinceCenter.setId(newRetailStoreProvinceCenterId);
		parameters[0] =  retailStoreProvinceCenter.getId();
 
 		
 		parameters[1] = retailStoreProvinceCenter.getName();
 		
 		
 		parameters[2] = retailStoreProvinceCenter.getFounded();
 		 	
 		if(retailStoreProvinceCenter.getCountry() != null){
 			parameters[3] = retailStoreProvinceCenter.getCountry().getId();
 		
 		}
 		
 		
 		parameters[4] = retailStoreProvinceCenter.getLastUpdateTime();
 				
 				
 		return parameters;
 	}
 	
	protected RetailStoreProvinceCenter saveInternalRetailStoreProvinceCenter(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		saveRetailStoreProvinceCenter(retailStoreProvinceCenter);
 	
 		if(isSaveCountryEnabled(options)){
	 		saveCountry(retailStoreProvinceCenter, options);
 		}
 
		
		if(isSaveProvinceCenterDepartmentListEnabled(options)){
	 		saveProvinceCenterDepartmentList(retailStoreProvinceCenter, options);
	 		//removeProvinceCenterDepartmentList(retailStoreProvinceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveProvinceCenterEmployeeListEnabled(options)){
	 		saveProvinceCenterEmployeeList(retailStoreProvinceCenter, options);
	 		//removeProvinceCenterEmployeeList(retailStoreProvinceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveRetailStoreCityServiceCenterListEnabled(options)){
	 		saveRetailStoreCityServiceCenterList(retailStoreProvinceCenter, options);
	 		//removeRetailStoreCityServiceCenterList(retailStoreProvinceCenter, options);
	 		//Not delete the record
	 		
 		}		
		
		return retailStoreProvinceCenter;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected RetailStoreProvinceCenter saveCountry(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(retailStoreProvinceCenter.getCountry() == null){
 			return retailStoreProvinceCenter;//do nothing when it is null
 		}
 		
 		getRetailStoreCountryCenterDAO().save(retailStoreProvinceCenter.getCountry(),options);
 		return retailStoreProvinceCenter;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public RetailStoreProvinceCenter planToRemoveProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, String provinceCenterDepartmentIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, retailStoreProvinceCenter.getId());
		key.put(ProvinceCenterDepartment.ID_PROPERTY, provinceCenterDepartmentIds);
		
		SmartList<ProvinceCenterDepartment> externalProvinceCenterDepartmentList = getProvinceCenterDepartmentDAO().
				findProvinceCenterDepartmentWithKey(key, options);
		if(externalProvinceCenterDepartmentList == null){
			return retailStoreProvinceCenter;
		}
		if(externalProvinceCenterDepartmentList.isEmpty()){
			return retailStoreProvinceCenter;
		}
		
		for(ProvinceCenterDepartment provinceCenterDepartmentItem: externalProvinceCenterDepartmentList){

			provinceCenterDepartmentItem.clearFromAll();
		}
		
		
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();		
		provinceCenterDepartmentList.addAllToRemoveList(externalProvinceCenterDepartmentList);
		return retailStoreProvinceCenter;	
	
	}


	public RetailStoreProvinceCenter planToRemoveProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, String provinceCenterEmployeeIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, retailStoreProvinceCenter.getId());
		key.put(ProvinceCenterEmployee.ID_PROPERTY, provinceCenterEmployeeIds);
		
		SmartList<ProvinceCenterEmployee> externalProvinceCenterEmployeeList = getProvinceCenterEmployeeDAO().
				findProvinceCenterEmployeeWithKey(key, options);
		if(externalProvinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;
		}
		if(externalProvinceCenterEmployeeList.isEmpty()){
			return retailStoreProvinceCenter;
		}
		
		for(ProvinceCenterEmployee provinceCenterEmployeeItem: externalProvinceCenterEmployeeList){

			provinceCenterEmployeeItem.clearFromAll();
		}
		
		
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();		
		provinceCenterEmployeeList.addAllToRemoveList(externalProvinceCenterEmployeeList);
		return retailStoreProvinceCenter;	
	
	}


	//disconnect RetailStoreProvinceCenter with department in ProvinceCenterEmployee
	public RetailStoreProvinceCenter planToRemoveProvinceCenterEmployeeListWithDepartment(RetailStoreProvinceCenter retailStoreProvinceCenter, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, retailStoreProvinceCenter.getId());
		key.put(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, departmentId);
		
		SmartList<ProvinceCenterEmployee> externalProvinceCenterEmployeeList = getProvinceCenterEmployeeDAO().
				findProvinceCenterEmployeeWithKey(key, options);
		if(externalProvinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;
		}
		if(externalProvinceCenterEmployeeList.isEmpty()){
			return retailStoreProvinceCenter;
		}
		
		for(ProvinceCenterEmployee provinceCenterEmployeeItem: externalProvinceCenterEmployeeList){
			provinceCenterEmployeeItem.clearDepartment();
			provinceCenterEmployeeItem.clearProvinceCenter();
			
		}
		
		
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();		
		provinceCenterEmployeeList.addAllToRemoveList(externalProvinceCenterEmployeeList);
		return retailStoreProvinceCenter;
	}
	
	public int countProvinceCenterEmployeeListWithDepartment(String retailStoreProvinceCenterId, String departmentId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, retailStoreProvinceCenterId);
		key.put(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, departmentId);
		
		int count = getProvinceCenterEmployeeDAO().countProvinceCenterEmployeeWithKey(key, options);
		return count;
	}
	
	public RetailStoreProvinceCenter planToRemoveRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, String retailStoreCityServiceCenterIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, retailStoreProvinceCenter.getId());
		key.put(RetailStoreCityServiceCenter.ID_PROPERTY, retailStoreCityServiceCenterIds);
		
		SmartList<RetailStoreCityServiceCenter> externalRetailStoreCityServiceCenterList = getRetailStoreCityServiceCenterDAO().
				findRetailStoreCityServiceCenterWithKey(key, options);
		if(externalRetailStoreCityServiceCenterList == null){
			return retailStoreProvinceCenter;
		}
		if(externalRetailStoreCityServiceCenterList.isEmpty()){
			return retailStoreProvinceCenter;
		}
		
		for(RetailStoreCityServiceCenter retailStoreCityServiceCenterItem: externalRetailStoreCityServiceCenterList){

			retailStoreCityServiceCenterItem.clearFromAll();
		}
		
		
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();		
		retailStoreCityServiceCenterList.addAllToRemoveList(externalRetailStoreCityServiceCenterList);
		return retailStoreProvinceCenter;	
	
	}



		
	protected RetailStoreProvinceCenter saveProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();
		if(provinceCenterDepartmentList == null){
			//null list means nothing
			return retailStoreProvinceCenter;
		}
		SmartList<ProvinceCenterDepartment> mergedUpdateProvinceCenterDepartmentList = new SmartList<ProvinceCenterDepartment>();
		
		
		mergedUpdateProvinceCenterDepartmentList.addAll(provinceCenterDepartmentList); 
		if(provinceCenterDepartmentList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProvinceCenterDepartmentList.addAll(provinceCenterDepartmentList.getToRemoveList());
			provinceCenterDepartmentList.removeAll(provinceCenterDepartmentList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProvinceCenterDepartmentDAO().saveProvinceCenterDepartmentList(mergedUpdateProvinceCenterDepartmentList,options);
		
		if(provinceCenterDepartmentList.getToRemoveList() != null){
			provinceCenterDepartmentList.removeAll(provinceCenterDepartmentList.getToRemoveList());
		}
		
		
		return retailStoreProvinceCenter;
	
	}
	
	protected RetailStoreProvinceCenter removeProvinceCenterDepartmentList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
	
	
		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();
		if(provinceCenterDepartmentList == null){
			return retailStoreProvinceCenter;
		}	
	
		SmartList<ProvinceCenterDepartment> toRemoveProvinceCenterDepartmentList = provinceCenterDepartmentList.getToRemoveList();
		
		if(toRemoveProvinceCenterDepartmentList == null){
			return retailStoreProvinceCenter;
		}
		if(toRemoveProvinceCenterDepartmentList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProvinceCenterDepartmentDAO().removeProvinceCenterDepartmentList(toRemoveProvinceCenterDepartmentList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStoreProvinceCenter saveProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			//null list means nothing
			return retailStoreProvinceCenter;
		}
		SmartList<ProvinceCenterEmployee> mergedUpdateProvinceCenterEmployeeList = new SmartList<ProvinceCenterEmployee>();
		
		
		mergedUpdateProvinceCenterEmployeeList.addAll(provinceCenterEmployeeList); 
		if(provinceCenterEmployeeList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateProvinceCenterEmployeeList.addAll(provinceCenterEmployeeList.getToRemoveList());
			provinceCenterEmployeeList.removeAll(provinceCenterEmployeeList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getProvinceCenterEmployeeDAO().saveProvinceCenterEmployeeList(mergedUpdateProvinceCenterEmployeeList,options);
		
		if(provinceCenterEmployeeList.getToRemoveList() != null){
			provinceCenterEmployeeList.removeAll(provinceCenterEmployeeList.getToRemoveList());
		}
		
		
		return retailStoreProvinceCenter;
	
	}
	
	protected RetailStoreProvinceCenter removeProvinceCenterEmployeeList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
	
	
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;
		}	
	
		SmartList<ProvinceCenterEmployee> toRemoveProvinceCenterEmployeeList = provinceCenterEmployeeList.getToRemoveList();
		
		if(toRemoveProvinceCenterEmployeeList == null){
			return retailStoreProvinceCenter;
		}
		if(toRemoveProvinceCenterEmployeeList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getProvinceCenterEmployeeDAO().removeProvinceCenterEmployeeList(toRemoveProvinceCenterEmployeeList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	

 	
 	
	
	
	
		
	protected RetailStoreProvinceCenter saveRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
		
		
		
		
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();
		if(retailStoreCityServiceCenterList == null){
			//null list means nothing
			return retailStoreProvinceCenter;
		}
		SmartList<RetailStoreCityServiceCenter> mergedUpdateRetailStoreCityServiceCenterList = new SmartList<RetailStoreCityServiceCenter>();
		
		
		mergedUpdateRetailStoreCityServiceCenterList.addAll(retailStoreCityServiceCenterList); 
		if(retailStoreCityServiceCenterList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateRetailStoreCityServiceCenterList.addAll(retailStoreCityServiceCenterList.getToRemoveList());
			retailStoreCityServiceCenterList.removeAll(retailStoreCityServiceCenterList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getRetailStoreCityServiceCenterDAO().saveRetailStoreCityServiceCenterList(mergedUpdateRetailStoreCityServiceCenterList,options);
		
		if(retailStoreCityServiceCenterList.getToRemoveList() != null){
			retailStoreCityServiceCenterList.removeAll(retailStoreCityServiceCenterList.getToRemoveList());
		}
		
		
		return retailStoreProvinceCenter;
	
	}
	
	protected RetailStoreProvinceCenter removeRetailStoreCityServiceCenterList(RetailStoreProvinceCenter retailStoreProvinceCenter, Map<String,Object> options){
	
	
		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();
		if(retailStoreCityServiceCenterList == null){
			return retailStoreProvinceCenter;
		}	
	
		SmartList<RetailStoreCityServiceCenter> toRemoveRetailStoreCityServiceCenterList = retailStoreCityServiceCenterList.getToRemoveList();
		
		if(toRemoveRetailStoreCityServiceCenterList == null){
			return retailStoreProvinceCenter;
		}
		if(toRemoveRetailStoreCityServiceCenterList.isEmpty()){
			return retailStoreProvinceCenter;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getRetailStoreCityServiceCenterDAO().removeRetailStoreCityServiceCenterList(toRemoveRetailStoreCityServiceCenterList,options);
		
		return retailStoreProvinceCenter;
	
	}
	
	

 	
 	
	
	
	
		

	public RetailStoreProvinceCenter present(RetailStoreProvinceCenter retailStoreProvinceCenter,Map<String, Object> options){
	
		presentProvinceCenterDepartmentList(retailStoreProvinceCenter,options);
		presentProvinceCenterEmployeeList(retailStoreProvinceCenter,options);
		presentRetailStoreCityServiceCenterList(retailStoreProvinceCenter,options);

		return retailStoreProvinceCenter;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreProvinceCenter presentProvinceCenterDepartmentList(
			RetailStoreProvinceCenter retailStoreProvinceCenter,
			Map<String, Object> options) {

		SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList = retailStoreProvinceCenter.getProvinceCenterDepartmentList();		
				SmartList<ProvinceCenterDepartment> newList= presentSubList(retailStoreProvinceCenter.getId(),
				provinceCenterDepartmentList,
				options,
				getProvinceCenterDepartmentDAO()::countProvinceCenterDepartmentByProvinceCenter,
				getProvinceCenterDepartmentDAO()::findProvinceCenterDepartmentByProvinceCenter
				);

		
		retailStoreProvinceCenter.setProvinceCenterDepartmentList(newList);
		

		return retailStoreProvinceCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreProvinceCenter presentProvinceCenterEmployeeList(
			RetailStoreProvinceCenter retailStoreProvinceCenter,
			Map<String, Object> options) {

		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = retailStoreProvinceCenter.getProvinceCenterEmployeeList();		
				SmartList<ProvinceCenterEmployee> newList= presentSubList(retailStoreProvinceCenter.getId(),
				provinceCenterEmployeeList,
				options,
				getProvinceCenterEmployeeDAO()::countProvinceCenterEmployeeByProvinceCenter,
				getProvinceCenterEmployeeDAO()::findProvinceCenterEmployeeByProvinceCenter
				);

		
		retailStoreProvinceCenter.setProvinceCenterEmployeeList(newList);
		

		return retailStoreProvinceCenter;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected RetailStoreProvinceCenter presentRetailStoreCityServiceCenterList(
			RetailStoreProvinceCenter retailStoreProvinceCenter,
			Map<String, Object> options) {

		SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList = retailStoreProvinceCenter.getRetailStoreCityServiceCenterList();		
				SmartList<RetailStoreCityServiceCenter> newList= presentSubList(retailStoreProvinceCenter.getId(),
				retailStoreCityServiceCenterList,
				options,
				getRetailStoreCityServiceCenterDAO()::countRetailStoreCityServiceCenterByBelongsTo,
				getRetailStoreCityServiceCenterDAO()::findRetailStoreCityServiceCenterByBelongsTo
				);

		
		retailStoreProvinceCenter.setRetailStoreCityServiceCenterList(newList);
		

		return retailStoreProvinceCenter;
	}			
		

	
    public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForProvinceCenterDepartment(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreProvinceCenterTable.COLUMN_NAME, RetailStoreProvinceCenterTable.COLUMN_COUNTRY, filterKey, pageNo, pageSize, getRetailStoreProvinceCenterMapper());
    }
		
    public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForProvinceCenterEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreProvinceCenterTable.COLUMN_NAME, RetailStoreProvinceCenterTable.COLUMN_COUNTRY, filterKey, pageNo, pageSize, getRetailStoreProvinceCenterMapper());
    }
		
    public SmartList<RetailStoreProvinceCenter> requestCandidateRetailStoreProvinceCenterForRetailStoreCityServiceCenter(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(RetailStoreProvinceCenterTable.COLUMN_NAME, RetailStoreProvinceCenterTable.COLUMN_COUNTRY, filterKey, pageNo, pageSize, getRetailStoreProvinceCenterMapper());
    }
		

	protected String getTableName(){
		return RetailStoreProvinceCenterTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<RetailStoreProvinceCenter> retailStoreProvinceCenterList) {		
		this.enhanceListInternal(retailStoreProvinceCenterList, this.getRetailStoreProvinceCenterMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterDepartment的provinceCenter的ProvinceCenterDepartmentList
	public SmartList<ProvinceCenterDepartment> loadOurProvinceCenterDepartmentList(RetailscmUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterDepartment.PROVINCE_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ProvinceCenterDepartment> loadedObjs = userContext.getDAOGroup().getProvinceCenterDepartmentDAO().findProvinceCenterDepartmentWithKey(key, options);
		Map<String, List<ProvinceCenterDepartment>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getProvinceCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ProvinceCenterDepartment> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ProvinceCenterDepartment> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setProvinceCenterDepartmentList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterEmployee的provinceCenter的ProvinceCenterEmployeeList
	public SmartList<ProvinceCenterEmployee> loadOurProvinceCenterEmployeeList(RetailscmUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ProvinceCenterEmployee> loadedObjs = userContext.getDAOGroup().getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeWithKey(key, options);
		Map<String, List<ProvinceCenterEmployee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getProvinceCenter().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<ProvinceCenterEmployee> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<ProvinceCenterEmployee> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setProvinceCenterEmployeeList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:RetailStoreCityServiceCenter的belongsTo的RetailStoreCityServiceCenterList
	public SmartList<RetailStoreCityServiceCenter> loadOurRetailStoreCityServiceCenterList(RetailscmUserContext userContext, List<RetailStoreProvinceCenter> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(RetailStoreCityServiceCenter.BELONGS_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<RetailStoreCityServiceCenter> loadedObjs = userContext.getDAOGroup().getRetailStoreCityServiceCenterDAO().findRetailStoreCityServiceCenterWithKey(key, options);
		Map<String, List<RetailStoreCityServiceCenter>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getBelongsTo().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<RetailStoreCityServiceCenter> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<RetailStoreCityServiceCenter> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setRetailStoreCityServiceCenterList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<RetailStoreProvinceCenter> retailStoreProvinceCenterList = ownerEntity.collectRefsWithType(RetailStoreProvinceCenter.INTERNAL_TYPE);
		this.enhanceList(retailStoreProvinceCenterList);
		
	}
	
	@Override
	public SmartList<RetailStoreProvinceCenter> findRetailStoreProvinceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getRetailStoreProvinceCenterMapper());

	}
	@Override
	public int countRetailStoreProvinceCenterWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countRetailStoreProvinceCenterWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<RetailStoreProvinceCenter> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getRetailStoreProvinceCenterMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateRetailStoreProvinceCenter executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateRetailStoreProvinceCenter result = new CandidateRetailStoreProvinceCenter();
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
	
	

}


