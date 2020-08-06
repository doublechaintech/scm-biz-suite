
package com.doublechaintech.retailscm.potentialcustomer;

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


import com.doublechaintech.retailscm.eventattendance.EventAttendance;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.eventattendance.EventAttendanceDAO;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;
import com.doublechaintech.retailscm.citypartner.CityPartnerDAO;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class PotentialCustomerJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PotentialCustomerDAO{

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

	protected CityPartnerDAO cityPartnerDAO;
	public void setCityPartnerDAO(CityPartnerDAO cityPartnerDAO){
 	
 		if(cityPartnerDAO == null){
 			throw new IllegalStateException("Do not try to set cityPartnerDAO to null.");
 		}
	 	this.cityPartnerDAO = cityPartnerDAO;
 	}
 	public CityPartnerDAO getCityPartnerDAO(){
 		if(this.cityPartnerDAO == null){
 			throw new IllegalStateException("The cityPartnerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.cityPartnerDAO;
 	}	

	protected PotentialCustomerContactPersonDAO potentialCustomerContactPersonDAO;
	public void setPotentialCustomerContactPersonDAO(PotentialCustomerContactPersonDAO potentialCustomerContactPersonDAO){
 	
 		if(potentialCustomerContactPersonDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerContactPersonDAO to null.");
 		}
	 	this.potentialCustomerContactPersonDAO = potentialCustomerContactPersonDAO;
 	}
 	public PotentialCustomerContactPersonDAO getPotentialCustomerContactPersonDAO(){
 		if(this.potentialCustomerContactPersonDAO == null){
 			throw new IllegalStateException("The potentialCustomerContactPersonDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerContactPersonDAO;
 	}	

	protected PotentialCustomerContactDAO potentialCustomerContactDAO;
	public void setPotentialCustomerContactDAO(PotentialCustomerContactDAO potentialCustomerContactDAO){
 	
 		if(potentialCustomerContactDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerContactDAO to null.");
 		}
	 	this.potentialCustomerContactDAO = potentialCustomerContactDAO;
 	}
 	public PotentialCustomerContactDAO getPotentialCustomerContactDAO(){
 		if(this.potentialCustomerContactDAO == null){
 			throw new IllegalStateException("The potentialCustomerContactDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerContactDAO;
 	}	

	protected EventAttendanceDAO eventAttendanceDAO;
	public void setEventAttendanceDAO(EventAttendanceDAO eventAttendanceDAO){
 	
 		if(eventAttendanceDAO == null){
 			throw new IllegalStateException("Do not try to set eventAttendanceDAO to null.");
 		}
	 	this.eventAttendanceDAO = eventAttendanceDAO;
 	}
 	public EventAttendanceDAO getEventAttendanceDAO(){
 		if(this.eventAttendanceDAO == null){
 			throw new IllegalStateException("The eventAttendanceDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.eventAttendanceDAO;
 	}	


	/*
	protected PotentialCustomer load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomer(accessKey, options);
	}
	*/

	public SmartList<PotentialCustomer> loadAll() {
	    return this.loadAll(getPotentialCustomerMapper());
	}

  public Stream<PotentialCustomer> loadAllAsStream() {
      return this.loadAllAsStream(getPotentialCustomerMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public PotentialCustomer load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomer(PotentialCustomerTable.withId(id), options);
	}

	

	public PotentialCustomer save(PotentialCustomer potentialCustomer,Map<String,Object> options){

		String methodName="save(PotentialCustomer potentialCustomer,Map<String,Object> options)";

		assertMethodArgumentNotNull(potentialCustomer, methodName, "potentialCustomer");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalPotentialCustomer(potentialCustomer,options);
	}
	public PotentialCustomer clone(String potentialCustomerId, Map<String,Object> options) throws Exception{

		return clone(PotentialCustomerTable.withId(potentialCustomerId),options);
	}

	protected PotentialCustomer clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String potentialCustomerId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		PotentialCustomer newPotentialCustomer = loadInternalPotentialCustomer(accessKey, options);
		newPotentialCustomer.setVersion(0);
		
		
 		
 		if(isSavePotentialCustomerContactPersonListEnabled(options)){
 			for(PotentialCustomerContactPerson item: newPotentialCustomer.getPotentialCustomerContactPersonList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePotentialCustomerContactListEnabled(options)){
 			for(PotentialCustomerContact item: newPotentialCustomer.getPotentialCustomerContactList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveEventAttendanceListEnabled(options)){
 			for(EventAttendance item: newPotentialCustomer.getEventAttendanceList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalPotentialCustomer(newPotentialCustomer,options);

		return newPotentialCustomer;
	}

	



	protected void throwIfHasException(String potentialCustomerId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PotentialCustomerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PotentialCustomerNotFoundException(
					"The " + this.getTableName() + "(" + potentialCustomerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String potentialCustomerId, int version) throws Exception{

		String methodName="delete(String potentialCustomerId, int version)";
		assertMethodArgumentNotNull(potentialCustomerId, methodName, "potentialCustomerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{potentialCustomerId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(potentialCustomerId,version);
		}


	}






	public PotentialCustomer disconnectFromAll(String potentialCustomerId, int version) throws Exception{


		PotentialCustomer potentialCustomer = loadInternalPotentialCustomer(PotentialCustomerTable.withId(potentialCustomerId), emptyOptions());
		potentialCustomer.clearFromAll();
		this.savePotentialCustomer(potentialCustomer);
		return potentialCustomer;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return PotentialCustomerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "potential_customer";
	}
	@Override
	protected String getBeanName() {

		return "potentialCustomer";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PotentialCustomerTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerTokens.CITYSERVICECENTER);
 	}

 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerTokens.CITYSERVICECENTER);
 	}
 	

 	
  

 	protected boolean isExtractCityPartnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerTokens.CITYPARTNER);
 	}

 	protected boolean isSaveCityPartnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerTokens.CITYPARTNER);
 	}
 	

 	
 
		
	
	protected boolean isExtractPotentialCustomerContactPersonListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
 	}
 	protected boolean isAnalyzePotentialCustomerContactPersonListEnabled(Map<String,Object> options){		 		
 		return PotentialCustomerTokens.of(options).analyzePotentialCustomerContactPersonListEnabled();
 	}
	
	protected boolean isSavePotentialCustomerContactPersonListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_PERSON_LIST);
		
 	}
 	
		
	
	protected boolean isExtractPotentialCustomerContactListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
 	}
 	protected boolean isAnalyzePotentialCustomerContactListEnabled(Map<String,Object> options){		 		
 		return PotentialCustomerTokens.of(options).analyzePotentialCustomerContactListEnabled();
 	}
	
	protected boolean isSavePotentialCustomerContactListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}
 	
		
	
	protected boolean isExtractEventAttendanceListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PotentialCustomerTokens.EVENT_ATTENDANCE_LIST);
 	}
 	protected boolean isAnalyzeEventAttendanceListEnabled(Map<String,Object> options){		 		
 		return PotentialCustomerTokens.of(options).analyzeEventAttendanceListEnabled();
 	}
	
	protected boolean isSaveEventAttendanceListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerTokens.EVENT_ATTENDANCE_LIST);
		
 	}
 	
		

	

	protected PotentialCustomerMapper getPotentialCustomerMapper(){
		return new PotentialCustomerMapper();
	}

	
	
	protected PotentialCustomer extractPotentialCustomer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PotentialCustomer potentialCustomer = loadSingleObject(accessKey, getPotentialCustomerMapper());
			return potentialCustomer;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerNotFoundException("PotentialCustomer("+accessKey+") is not found!");
		}

	}

	
	

	protected PotentialCustomer loadInternalPotentialCustomer(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PotentialCustomer potentialCustomer = extractPotentialCustomer(accessKey, loadOptions);
 	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(potentialCustomer, loadOptions);
 		}
  	
 		if(isExtractCityPartnerEnabled(loadOptions)){
	 		extractCityPartner(potentialCustomer, loadOptions);
 		}
 
		
		if(isExtractPotentialCustomerContactPersonListEnabled(loadOptions)){
	 		extractPotentialCustomerContactPersonList(potentialCustomer, loadOptions);
 		}	
 		
 		
 		if(isAnalyzePotentialCustomerContactPersonListEnabled(loadOptions)){
	 		analyzePotentialCustomerContactPersonList(potentialCustomer, loadOptions);
 		}
 		
		
		if(isExtractPotentialCustomerContactListEnabled(loadOptions)){
	 		extractPotentialCustomerContactList(potentialCustomer, loadOptions);
 		}	
 		
 		
 		if(isAnalyzePotentialCustomerContactListEnabled(loadOptions)){
	 		analyzePotentialCustomerContactList(potentialCustomer, loadOptions);
 		}
 		
		
		if(isExtractEventAttendanceListEnabled(loadOptions)){
	 		extractEventAttendanceList(potentialCustomer, loadOptions);
 		}	
 		
 		
 		if(isAnalyzeEventAttendanceListEnabled(loadOptions)){
	 		analyzeEventAttendanceList(potentialCustomer, loadOptions);
 		}
 		
		
		return potentialCustomer;
		
	}

	 

 	protected PotentialCustomer extractCityServiceCenter(PotentialCustomer potentialCustomer, Map<String,Object> options) throws Exception{

		if(potentialCustomer.getCityServiceCenter() == null){
			return potentialCustomer;
		}
		String cityServiceCenterId = potentialCustomer.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return potentialCustomer;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			potentialCustomer.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return potentialCustomer;
 	}
 		
  

 	protected PotentialCustomer extractCityPartner(PotentialCustomer potentialCustomer, Map<String,Object> options) throws Exception{

		if(potentialCustomer.getCityPartner() == null){
			return potentialCustomer;
		}
		String cityPartnerId = potentialCustomer.getCityPartner().getId();
		if( cityPartnerId == null){
			return potentialCustomer;
		}
		CityPartner cityPartner = getCityPartnerDAO().load(cityPartnerId,options);
		if(cityPartner != null){
			potentialCustomer.setCityPartner(cityPartner);
		}
		
 		
 		return potentialCustomer;
 	}
 		
 
		
	protected void enhancePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected PotentialCustomer extractPotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		
		if(potentialCustomer == null){
			return null;
		}
		if(potentialCustomer.getId() == null){
			return potentialCustomer;
		}

		
		
		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = getPotentialCustomerContactPersonDAO().findPotentialCustomerContactPersonByPotentialCustomer(potentialCustomer.getId(),options);
		if(potentialCustomerContactPersonList != null){
			enhancePotentialCustomerContactPersonList(potentialCustomerContactPersonList,options);
			potentialCustomer.setPotentialCustomerContactPersonList(potentialCustomerContactPersonList);
		}
		
		return potentialCustomer;
	
	}	
	
	protected PotentialCustomer analyzePotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		
		if(potentialCustomer == null){
			return null;
		}
		if(potentialCustomer.getId() == null){
			return potentialCustomer;
		}

		
		
		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();
		if(potentialCustomerContactPersonList != null){
			getPotentialCustomerContactPersonDAO().analyzePotentialCustomerContactPersonByPotentialCustomer(potentialCustomerContactPersonList, potentialCustomer.getId(), options);
			
		}
		
		return potentialCustomer;
	
	}	
	
		
	protected void enhancePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected PotentialCustomer extractPotentialCustomerContactList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		
		if(potentialCustomer == null){
			return null;
		}
		if(potentialCustomer.getId() == null){
			return potentialCustomer;
		}

		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = getPotentialCustomerContactDAO().findPotentialCustomerContactByPotentialCustomer(potentialCustomer.getId(),options);
		if(potentialCustomerContactList != null){
			enhancePotentialCustomerContactList(potentialCustomerContactList,options);
			potentialCustomer.setPotentialCustomerContactList(potentialCustomerContactList);
		}
		
		return potentialCustomer;
	
	}	
	
	protected PotentialCustomer analyzePotentialCustomerContactList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		
		if(potentialCustomer == null){
			return null;
		}
		if(potentialCustomer.getId() == null){
			return potentialCustomer;
		}

		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		if(potentialCustomerContactList != null){
			getPotentialCustomerContactDAO().analyzePotentialCustomerContactByPotentialCustomer(potentialCustomerContactList, potentialCustomer.getId(), options);
			
		}
		
		return potentialCustomer;
	
	}	
	
		
	protected void enhanceEventAttendanceList(SmartList<EventAttendance> eventAttendanceList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected PotentialCustomer extractEventAttendanceList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		
		if(potentialCustomer == null){
			return null;
		}
		if(potentialCustomer.getId() == null){
			return potentialCustomer;
		}

		
		
		SmartList<EventAttendance> eventAttendanceList = getEventAttendanceDAO().findEventAttendanceByPotentialCustomer(potentialCustomer.getId(),options);
		if(eventAttendanceList != null){
			enhanceEventAttendanceList(eventAttendanceList,options);
			potentialCustomer.setEventAttendanceList(eventAttendanceList);
		}
		
		return potentialCustomer;
	
	}	
	
	protected PotentialCustomer analyzeEventAttendanceList(PotentialCustomer potentialCustomer, Map<String,Object> options){
		
		
		if(potentialCustomer == null){
			return null;
		}
		if(potentialCustomer.getId() == null){
			return potentialCustomer;
		}

		
		
		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		if(eventAttendanceList != null){
			getEventAttendanceDAO().analyzeEventAttendanceByPotentialCustomer(eventAttendanceList, potentialCustomer.getId(), options);
			
		}
		
		return potentialCustomer;
	
	}	
	
		
		
  	
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
  		SmartList<PotentialCustomer> resultList = queryWith(PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getPotentialCustomerMapper());
		// analyzePotentialCustomerByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PotentialCustomer> resultList =  queryWithRange(PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getPotentialCustomerMapper(), start, count);
 		//analyzePotentialCustomerByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzePotentialCustomerByCityServiceCenter(SmartList<PotentialCustomer> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//PotentialCustomer.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("潜在的客户");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countPotentialCustomerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){

 		return countWith(PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countPotentialCustomerByCityServiceCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER, ids, options);
	}
 	
  	
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId,Map<String,Object> options){
 	
  		SmartList<PotentialCustomer> resultList = queryWith(PotentialCustomerTable.COLUMN_CITY_PARTNER, cityPartnerId, options, getPotentialCustomerMapper());
		// analyzePotentialCustomerByCityPartner(resultList, cityPartnerId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PotentialCustomer> findPotentialCustomerByCityPartner(String cityPartnerId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PotentialCustomer> resultList =  queryWithRange(PotentialCustomerTable.COLUMN_CITY_PARTNER, cityPartnerId, options, getPotentialCustomerMapper(), start, count);
 		//analyzePotentialCustomerByCityPartner(resultList, cityPartnerId, options);
 		return resultList;
 		
 	}
 	public void analyzePotentialCustomerByCityPartner(SmartList<PotentialCustomer> resultList, String cityPartnerId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartnerId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//PotentialCustomer.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("潜在的客户");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(PotentialCustomer.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countPotentialCustomerByCityPartner(String cityPartnerId,Map<String,Object> options){

 		return countWith(PotentialCustomerTable.COLUMN_CITY_PARTNER, cityPartnerId, options);
 	}
 	@Override
	public Map<String, Integer> countPotentialCustomerByCityPartnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PotentialCustomerTable.COLUMN_CITY_PARTNER, ids, options);
	}
 	
 	
		
		
		

	

	protected PotentialCustomer savePotentialCustomer(PotentialCustomer  potentialCustomer){
		
		if(!potentialCustomer.isChanged()){
			return potentialCustomer;
		}
		

		String SQL=this.getSavePotentialCustomerSQL(potentialCustomer);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePotentialCustomerParameters(potentialCustomer);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		potentialCustomer.incVersion();
		return potentialCustomer;

	}
	public SmartList<PotentialCustomer> savePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPotentialCustomerList(potentialCustomerList);

		batchPotentialCustomerCreate((List<PotentialCustomer>)lists[CREATE_LIST_INDEX]);

		batchPotentialCustomerUpdate((List<PotentialCustomer>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(PotentialCustomer potentialCustomer:potentialCustomerList){
			if(potentialCustomer.isChanged()){
				potentialCustomer.incVersion();
			}


		}


		return potentialCustomerList;
	}

	public SmartList<PotentialCustomer> removePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options){


		super.removeList(potentialCustomerList, options);

		return potentialCustomerList;


	}

	protected List<Object[]> preparePotentialCustomerBatchCreateArgs(List<PotentialCustomer> potentialCustomerList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomer potentialCustomer:potentialCustomerList ){
			Object [] parameters = preparePotentialCustomerCreateParameters(potentialCustomer);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> preparePotentialCustomerBatchUpdateArgs(List<PotentialCustomer> potentialCustomerList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomer potentialCustomer:potentialCustomerList ){
			if(!potentialCustomer.isChanged()){
				continue;
			}
			Object [] parameters = preparePotentialCustomerUpdateParameters(potentialCustomer);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchPotentialCustomerCreate(List<PotentialCustomer> potentialCustomerList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePotentialCustomerBatchCreateArgs(potentialCustomerList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchPotentialCustomerUpdate(List<PotentialCustomer> potentialCustomerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePotentialCustomerBatchUpdateArgs(potentialCustomerList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitPotentialCustomerList(List<PotentialCustomer> potentialCustomerList){

		List<PotentialCustomer> potentialCustomerCreateList=new ArrayList<PotentialCustomer>();
		List<PotentialCustomer> potentialCustomerUpdateList=new ArrayList<PotentialCustomer>();

		for(PotentialCustomer potentialCustomer: potentialCustomerList){
			if(isUpdateRequest(potentialCustomer)){
				potentialCustomerUpdateList.add( potentialCustomer);
				continue;
			}
			potentialCustomerCreateList.add(potentialCustomer);
		}

		return new Object[]{potentialCustomerCreateList,potentialCustomerUpdateList};
	}

	protected boolean isUpdateRequest(PotentialCustomer potentialCustomer){
 		return potentialCustomer.getVersion() > 0;
 	}
 	protected String getSavePotentialCustomerSQL(PotentialCustomer potentialCustomer){
 		if(isUpdateRequest(potentialCustomer)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSavePotentialCustomerParameters(PotentialCustomer potentialCustomer){
 		if(isUpdateRequest(potentialCustomer) ){
 			return preparePotentialCustomerUpdateParameters(potentialCustomer);
 		}
 		return preparePotentialCustomerCreateParameters(potentialCustomer);
 	}
 	protected Object[] preparePotentialCustomerUpdateParameters(PotentialCustomer potentialCustomer){
 		Object[] parameters = new Object[9];
 
 		
 		parameters[0] = potentialCustomer.getName();
 		
 		
 		parameters[1] = potentialCustomer.getMobile();
 		
 		if(potentialCustomer.getCityServiceCenter() != null){
 			parameters[2] = potentialCustomer.getCityServiceCenter().getId();
 		}
 
 		if(potentialCustomer.getCityPartner() != null){
 			parameters[3] = potentialCustomer.getCityPartner().getId();
 		}
 
 		
 		parameters[4] = potentialCustomer.getDescription();
 		
 		
 		parameters[5] = potentialCustomer.getLastUpdateTime();
 		
 		parameters[6] = potentialCustomer.nextVersion();
 		parameters[7] = potentialCustomer.getId();
 		parameters[8] = potentialCustomer.getVersion();

 		return parameters;
 	}
 	protected Object[] preparePotentialCustomerCreateParameters(PotentialCustomer potentialCustomer){
		Object[] parameters = new Object[7];
        if(potentialCustomer.getId() == null){
          String newPotentialCustomerId=getNextId();
          potentialCustomer.setId(newPotentialCustomerId);
        }
		parameters[0] =  potentialCustomer.getId();
 
 		
 		parameters[1] = potentialCustomer.getName();
 		
 		
 		parameters[2] = potentialCustomer.getMobile();
 		
 		if(potentialCustomer.getCityServiceCenter() != null){
 			parameters[3] = potentialCustomer.getCityServiceCenter().getId();

 		}
 		
 		if(potentialCustomer.getCityPartner() != null){
 			parameters[4] = potentialCustomer.getCityPartner().getId();

 		}
 		
 		
 		parameters[5] = potentialCustomer.getDescription();
 		
 		
 		parameters[6] = potentialCustomer.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected PotentialCustomer saveInternalPotentialCustomer(PotentialCustomer potentialCustomer, Map<String,Object> options){

		savePotentialCustomer(potentialCustomer);

 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(potentialCustomer, options);
 		}
 
 		if(isSaveCityPartnerEnabled(options)){
	 		saveCityPartner(potentialCustomer, options);
 		}
 
		
		if(isSavePotentialCustomerContactPersonListEnabled(options)){
	 		savePotentialCustomerContactPersonList(potentialCustomer, options);
	 		//removePotentialCustomerContactPersonList(potentialCustomer, options);
	 		//Not delete the record

 		}
		
		if(isSavePotentialCustomerContactListEnabled(options)){
	 		savePotentialCustomerContactList(potentialCustomer, options);
	 		//removePotentialCustomerContactList(potentialCustomer, options);
	 		//Not delete the record

 		}
		
		if(isSaveEventAttendanceListEnabled(options)){
	 		saveEventAttendanceList(potentialCustomer, options);
	 		//removeEventAttendanceList(potentialCustomer, options);
	 		//Not delete the record

 		}
		
		return potentialCustomer;

	}



	//======================================================================================
	

 	protected PotentialCustomer saveCityServiceCenter(PotentialCustomer potentialCustomer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomer.getCityServiceCenter() == null){
 			return potentialCustomer;//do nothing when it is null
 		}

 		getRetailStoreCityServiceCenterDAO().save(potentialCustomer.getCityServiceCenter(),options);
 		return potentialCustomer;

 	}





 

 	protected PotentialCustomer saveCityPartner(PotentialCustomer potentialCustomer, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomer.getCityPartner() == null){
 			return potentialCustomer;//do nothing when it is null
 		}

 		getCityPartnerDAO().save(potentialCustomer.getCityPartner(),options);
 		return potentialCustomer;

 	}





 

	
	public PotentialCustomer planToRemovePotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, String potentialCustomerContactPersonIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer.getId());
		key.put(PotentialCustomerContactPerson.ID_PROPERTY, potentialCustomerContactPersonIds);

		SmartList<PotentialCustomerContactPerson> externalPotentialCustomerContactPersonList = getPotentialCustomerContactPersonDAO().
				findPotentialCustomerContactPersonWithKey(key, options);
		if(externalPotentialCustomerContactPersonList == null){
			return potentialCustomer;
		}
		if(externalPotentialCustomerContactPersonList.isEmpty()){
			return potentialCustomer;
		}

		for(PotentialCustomerContactPerson potentialCustomerContactPersonItem: externalPotentialCustomerContactPersonList){

			potentialCustomerContactPersonItem.clearFromAll();
		}


		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();
		potentialCustomerContactPersonList.addAllToRemoveList(externalPotentialCustomerContactPersonList);
		return potentialCustomer;

	}


	public PotentialCustomer planToRemovePotentialCustomerContactList(PotentialCustomer potentialCustomer, String potentialCustomerContactIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer.getId());
		key.put(PotentialCustomerContact.ID_PROPERTY, potentialCustomerContactIds);

		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return potentialCustomer;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return potentialCustomer;
		}

		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){

			potentialCustomerContactItem.clearFromAll();
		}


		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return potentialCustomer;

	}


	//disconnect PotentialCustomer with city_partner in PotentialCustomerContact
	public PotentialCustomer planToRemovePotentialCustomerContactListWithCityPartner(PotentialCustomer potentialCustomer, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer.getId());
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartnerId);

		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return potentialCustomer;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return potentialCustomer;
		}

		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){
			potentialCustomerContactItem.clearCityPartner();
			potentialCustomerContactItem.clearPotentialCustomer();

		}


		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return potentialCustomer;
	}

	public int countPotentialCustomerContactListWithCityPartner(String potentialCustomerId, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartnerId);

		int count = getPotentialCustomerContactDAO().countPotentialCustomerContactWithKey(key, options);
		return count;
	}
	
	//disconnect PotentialCustomer with contact_to in PotentialCustomerContact
	public PotentialCustomer planToRemovePotentialCustomerContactListWithContactTo(PotentialCustomer potentialCustomer, String contactToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer.getId());
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, contactToId);

		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return potentialCustomer;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return potentialCustomer;
		}

		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){
			potentialCustomerContactItem.clearContactTo();
			potentialCustomerContactItem.clearPotentialCustomer();

		}


		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return potentialCustomer;
	}

	public int countPotentialCustomerContactListWithContactTo(String potentialCustomerId, String contactToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, contactToId);

		int count = getPotentialCustomerContactDAO().countPotentialCustomerContactWithKey(key, options);
		return count;
	}
	
	public PotentialCustomer planToRemoveEventAttendanceList(PotentialCustomer potentialCustomer, String eventAttendanceIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer.getId());
		key.put(EventAttendance.ID_PROPERTY, eventAttendanceIds);

		SmartList<EventAttendance> externalEventAttendanceList = getEventAttendanceDAO().
				findEventAttendanceWithKey(key, options);
		if(externalEventAttendanceList == null){
			return potentialCustomer;
		}
		if(externalEventAttendanceList.isEmpty()){
			return potentialCustomer;
		}

		for(EventAttendance eventAttendanceItem: externalEventAttendanceList){

			eventAttendanceItem.clearFromAll();
		}


		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		eventAttendanceList.addAllToRemoveList(externalEventAttendanceList);
		return potentialCustomer;

	}


	//disconnect PotentialCustomer with city_event in EventAttendance
	public PotentialCustomer planToRemoveEventAttendanceListWithCityEvent(PotentialCustomer potentialCustomer, String cityEventId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomer.getId());
		key.put(EventAttendance.CITY_EVENT_PROPERTY, cityEventId);

		SmartList<EventAttendance> externalEventAttendanceList = getEventAttendanceDAO().
				findEventAttendanceWithKey(key, options);
		if(externalEventAttendanceList == null){
			return potentialCustomer;
		}
		if(externalEventAttendanceList.isEmpty()){
			return potentialCustomer;
		}

		for(EventAttendance eventAttendanceItem: externalEventAttendanceList){
			eventAttendanceItem.clearCityEvent();
			eventAttendanceItem.clearPotentialCustomer();

		}


		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		eventAttendanceList.addAllToRemoveList(externalEventAttendanceList);
		return potentialCustomer;
	}

	public int countEventAttendanceListWithCityEvent(String potentialCustomerId, String cityEventId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
		key.put(EventAttendance.CITY_EVENT_PROPERTY, cityEventId);

		int count = getEventAttendanceDAO().countEventAttendanceWithKey(key, options);
		return count;
	}
	

		
	protected PotentialCustomer savePotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, Map<String,Object> options){




		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();
		if(potentialCustomerContactPersonList == null){
			//null list means nothing
			return potentialCustomer;
		}
		SmartList<PotentialCustomerContactPerson> mergedUpdatePotentialCustomerContactPersonList = new SmartList<PotentialCustomerContactPerson>();


		mergedUpdatePotentialCustomerContactPersonList.addAll(potentialCustomerContactPersonList);
		if(potentialCustomerContactPersonList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePotentialCustomerContactPersonList.addAll(potentialCustomerContactPersonList.getToRemoveList());
			potentialCustomerContactPersonList.removeAll(potentialCustomerContactPersonList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getPotentialCustomerContactPersonDAO().savePotentialCustomerContactPersonList(mergedUpdatePotentialCustomerContactPersonList,options);

		if(potentialCustomerContactPersonList.getToRemoveList() != null){
			potentialCustomerContactPersonList.removeAll(potentialCustomerContactPersonList.getToRemoveList());
		}


		return potentialCustomer;

	}

	protected PotentialCustomer removePotentialCustomerContactPersonList(PotentialCustomer potentialCustomer, Map<String,Object> options){


		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();
		if(potentialCustomerContactPersonList == null){
			return potentialCustomer;
		}

		SmartList<PotentialCustomerContactPerson> toRemovePotentialCustomerContactPersonList = potentialCustomerContactPersonList.getToRemoveList();

		if(toRemovePotentialCustomerContactPersonList == null){
			return potentialCustomer;
		}
		if(toRemovePotentialCustomerContactPersonList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getPotentialCustomerContactPersonDAO().removePotentialCustomerContactPersonList(toRemovePotentialCustomerContactPersonList,options);

		return potentialCustomer;

	}








		
	protected PotentialCustomer savePotentialCustomerContactList(PotentialCustomer potentialCustomer, Map<String,Object> options){




		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			//null list means nothing
			return potentialCustomer;
		}
		SmartList<PotentialCustomerContact> mergedUpdatePotentialCustomerContactList = new SmartList<PotentialCustomerContact>();


		mergedUpdatePotentialCustomerContactList.addAll(potentialCustomerContactList);
		if(potentialCustomerContactList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdatePotentialCustomerContactList.addAll(potentialCustomerContactList.getToRemoveList());
			potentialCustomerContactList.removeAll(potentialCustomerContactList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getPotentialCustomerContactDAO().savePotentialCustomerContactList(mergedUpdatePotentialCustomerContactList,options);

		if(potentialCustomerContactList.getToRemoveList() != null){
			potentialCustomerContactList.removeAll(potentialCustomerContactList.getToRemoveList());
		}


		return potentialCustomer;

	}

	protected PotentialCustomer removePotentialCustomerContactList(PotentialCustomer potentialCustomer, Map<String,Object> options){


		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return potentialCustomer;
		}

		SmartList<PotentialCustomerContact> toRemovePotentialCustomerContactList = potentialCustomerContactList.getToRemoveList();

		if(toRemovePotentialCustomerContactList == null){
			return potentialCustomer;
		}
		if(toRemovePotentialCustomerContactList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getPotentialCustomerContactDAO().removePotentialCustomerContactList(toRemovePotentialCustomerContactList,options);

		return potentialCustomer;

	}








		
	protected PotentialCustomer saveEventAttendanceList(PotentialCustomer potentialCustomer, Map<String,Object> options){




		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		if(eventAttendanceList == null){
			//null list means nothing
			return potentialCustomer;
		}
		SmartList<EventAttendance> mergedUpdateEventAttendanceList = new SmartList<EventAttendance>();


		mergedUpdateEventAttendanceList.addAll(eventAttendanceList);
		if(eventAttendanceList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateEventAttendanceList.addAll(eventAttendanceList.getToRemoveList());
			eventAttendanceList.removeAll(eventAttendanceList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance

		getEventAttendanceDAO().saveEventAttendanceList(mergedUpdateEventAttendanceList,options);

		if(eventAttendanceList.getToRemoveList() != null){
			eventAttendanceList.removeAll(eventAttendanceList.getToRemoveList());
		}


		return potentialCustomer;

	}

	protected PotentialCustomer removeEventAttendanceList(PotentialCustomer potentialCustomer, Map<String,Object> options){


		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();
		if(eventAttendanceList == null){
			return potentialCustomer;
		}

		SmartList<EventAttendance> toRemoveEventAttendanceList = eventAttendanceList.getToRemoveList();

		if(toRemoveEventAttendanceList == null){
			return potentialCustomer;
		}
		if(toRemoveEventAttendanceList.isEmpty()){
			return potentialCustomer;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getEventAttendanceDAO().removeEventAttendanceList(toRemoveEventAttendanceList,options);

		return potentialCustomer;

	}








		

	public PotentialCustomer present(PotentialCustomer potentialCustomer,Map<String, Object> options){
	
		presentPotentialCustomerContactPersonList(potentialCustomer,options);
		presentPotentialCustomerContactList(potentialCustomer,options);
		presentEventAttendanceList(potentialCustomer,options);

		return potentialCustomer;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected PotentialCustomer presentPotentialCustomerContactPersonList(
			PotentialCustomer potentialCustomer,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList = potentialCustomer.getPotentialCustomerContactPersonList();		
				SmartList<PotentialCustomerContactPerson> newList= presentSubList(potentialCustomer.getId(),
				potentialCustomerContactPersonList,
				options,
				getPotentialCustomerContactPersonDAO()::countPotentialCustomerContactPersonByPotentialCustomer,
				getPotentialCustomerContactPersonDAO()::findPotentialCustomerContactPersonByPotentialCustomer
				);

		
		potentialCustomer.setPotentialCustomerContactPersonList(newList);
		

		return potentialCustomer;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected PotentialCustomer presentPotentialCustomerContactList(
			PotentialCustomer potentialCustomer,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomer.getPotentialCustomerContactList();		
				SmartList<PotentialCustomerContact> newList= presentSubList(potentialCustomer.getId(),
				potentialCustomerContactList,
				options,
				getPotentialCustomerContactDAO()::countPotentialCustomerContactByPotentialCustomer,
				getPotentialCustomerContactDAO()::findPotentialCustomerContactByPotentialCustomer
				);

		
		potentialCustomer.setPotentialCustomerContactList(newList);
		

		return potentialCustomer;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected PotentialCustomer presentEventAttendanceList(
			PotentialCustomer potentialCustomer,
			Map<String, Object> options) {

		SmartList<EventAttendance> eventAttendanceList = potentialCustomer.getEventAttendanceList();		
				SmartList<EventAttendance> newList= presentSubList(potentialCustomer.getId(),
				eventAttendanceList,
				options,
				getEventAttendanceDAO()::countEventAttendanceByPotentialCustomer,
				getEventAttendanceDAO()::findEventAttendanceByPotentialCustomer
				);

		
		potentialCustomer.setEventAttendanceList(newList);
		

		return potentialCustomer;
	}			
		

	
    public SmartList<PotentialCustomer> requestCandidatePotentialCustomerForPotentialCustomerContactPerson(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PotentialCustomerTable.COLUMN_NAME, PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER, filterKey, pageNo, pageSize, getPotentialCustomerMapper());
    }
		
    public SmartList<PotentialCustomer> requestCandidatePotentialCustomerForPotentialCustomerContact(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PotentialCustomerTable.COLUMN_NAME, PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER, filterKey, pageNo, pageSize, getPotentialCustomerMapper());
    }
		
    public SmartList<PotentialCustomer> requestCandidatePotentialCustomerForEventAttendance(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PotentialCustomerTable.COLUMN_NAME, PotentialCustomerTable.COLUMN_CITY_SERVICE_CENTER, filterKey, pageNo, pageSize, getPotentialCustomerMapper());
    }
		

	protected String getTableName(){
		return PotentialCustomerTable.TABLE_NAME;
	}



	public void enhanceList(List<PotentialCustomer> potentialCustomerList) {
		this.enhanceListInternal(potentialCustomerList, this.getPotentialCustomerMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContactPerson的potentialCustomer的PotentialCustomerContactPersonList
	public SmartList<PotentialCustomerContactPerson> loadOurPotentialCustomerContactPersonList(RetailscmUserContext userContext, List<PotentialCustomer> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContactPerson.POTENTIAL_CUSTOMER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PotentialCustomerContactPerson> loadedObjs = userContext.getDAOGroup().getPotentialCustomerContactPersonDAO().findPotentialCustomerContactPersonWithKey(key, options);
		Map<String, List<PotentialCustomerContactPerson>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPotentialCustomer().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<PotentialCustomerContactPerson> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<PotentialCustomerContactPerson> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPotentialCustomerContactPersonList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContact的potentialCustomer的PotentialCustomerContactList
	public SmartList<PotentialCustomerContact> loadOurPotentialCustomerContactList(RetailscmUserContext userContext, List<PotentialCustomer> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PotentialCustomerContact> loadedObjs = userContext.getDAOGroup().getPotentialCustomerContactDAO().findPotentialCustomerContactWithKey(key, options);
		Map<String, List<PotentialCustomerContact>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPotentialCustomer().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<PotentialCustomerContact> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<PotentialCustomerContact> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPotentialCustomerContactList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:EventAttendance的potentialCustomer的EventAttendanceList
	public SmartList<EventAttendance> loadOurEventAttendanceList(RetailscmUserContext userContext, List<PotentialCustomer> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(EventAttendance.POTENTIAL_CUSTOMER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<EventAttendance> loadedObjs = userContext.getDAOGroup().getEventAttendanceDAO().findEventAttendanceWithKey(key, options);
		Map<String, List<EventAttendance>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getPotentialCustomer().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<EventAttendance> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<EventAttendance> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setEventAttendanceList(loadedSmartList);
		});
		return loadedObjs;
	}
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<PotentialCustomer> potentialCustomerList = ownerEntity.collectRefsWithType(PotentialCustomer.INTERNAL_TYPE);
		this.enhanceList(potentialCustomerList);

	}

	@Override
	public SmartList<PotentialCustomer> findPotentialCustomerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getPotentialCustomerMapper());

	}
	@Override
	public int countPotentialCustomerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countPotentialCustomerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<PotentialCustomer> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPotentialCustomerMapper());
	}

  @Override
  public Stream<PotentialCustomer> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getPotentialCustomerMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidatePotentialCustomer executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidatePotentialCustomer result = new CandidatePotentialCustomer();
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


