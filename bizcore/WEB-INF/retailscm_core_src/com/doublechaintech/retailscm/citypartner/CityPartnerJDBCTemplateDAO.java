
package com.doublechaintech.retailscm.citypartner;

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


import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class CityPartnerJDBCTemplateDAO extends RetailscmBaseDAOImpl implements CityPartnerDAO{

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

	protected PotentialCustomerDAO potentialCustomerDAO;
	public void setPotentialCustomerDAO(PotentialCustomerDAO potentialCustomerDAO){
 	
 		if(potentialCustomerDAO == null){
 			throw new IllegalStateException("Do not try to set potentialCustomerDAO to null.");
 		}
	 	this.potentialCustomerDAO = potentialCustomerDAO;
 	}
 	public PotentialCustomerDAO getPotentialCustomerDAO(){
 		if(this.potentialCustomerDAO == null){
 			throw new IllegalStateException("The potentialCustomerDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.potentialCustomerDAO;
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


	/*
	protected CityPartner load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalCityPartner(accessKey, options);
	}
	*/

	public SmartList<CityPartner> loadAll() {
	    return this.loadAll(getCityPartnerMapper());
	}

  public Stream<CityPartner> loadAllAsStream() {
      return this.loadAllAsStream(getCityPartnerMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public CityPartner load(String id,Map<String,Object> options) throws Exception{
		return loadInternalCityPartner(CityPartnerTable.withId(id), options);
	}

	

	public CityPartner save(CityPartner cityPartner,Map<String,Object> options){

		String methodName="save(CityPartner cityPartner,Map<String,Object> options)";

		assertMethodArgumentNotNull(cityPartner, methodName, "cityPartner");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalCityPartner(cityPartner,options);
	}
	public CityPartner clone(String cityPartnerId, Map<String,Object> options) throws Exception{

		return clone(CityPartnerTable.withId(cityPartnerId),options);
	}

	protected CityPartner clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String cityPartnerId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		CityPartner newCityPartner = loadInternalCityPartner(accessKey, options);
		newCityPartner.setVersion(0);
		
		
 		
 		if(isSavePotentialCustomerListEnabled(options)){
 			for(PotentialCustomer item: newCityPartner.getPotentialCustomerList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSavePotentialCustomerContactListEnabled(options)){
 			for(PotentialCustomerContact item: newCityPartner.getPotentialCustomerContactList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalCityPartner(newCityPartner,options);

		return newCityPartner;
	}

	



	protected void throwIfHasException(String cityPartnerId,int version,int count) throws Exception{
		if (count == 1) {
			throw new CityPartnerVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new CityPartnerNotFoundException(
					"The " + this.getTableName() + "(" + cityPartnerId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String cityPartnerId, int version) throws Exception{

		String methodName="delete(String cityPartnerId, int version)";
		assertMethodArgumentNotNull(cityPartnerId, methodName, "cityPartnerId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{cityPartnerId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(cityPartnerId,version);
		}


	}






	public CityPartner disconnectFromAll(String cityPartnerId, int version) throws Exception{


		CityPartner cityPartner = loadInternalCityPartner(CityPartnerTable.withId(cityPartnerId), emptyOptions());
		cityPartner.clearFromAll();
		this.saveCityPartner(cityPartner);
		return cityPartner;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return CityPartnerTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "city_partner";
	}
	@Override
	protected String getBeanName() {

		return "cityPartner";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return CityPartnerTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractCityServiceCenterEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, CityPartnerTokens.CITYSERVICECENTER);
 	}

 	protected boolean isSaveCityServiceCenterEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, CityPartnerTokens.CITYSERVICECENTER);
 	}
 	

 	
 
		
	
	protected boolean isExtractPotentialCustomerListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CityPartnerTokens.POTENTIAL_CUSTOMER_LIST);
 	}
 	protected boolean isAnalyzePotentialCustomerListEnabled(Map<String,Object> options){		 		
 		return CityPartnerTokens.of(options).analyzePotentialCustomerListEnabled();
 	}
	
	protected boolean isSavePotentialCustomerListEnabled(Map<String,Object> options){
		return checkOptions(options, CityPartnerTokens.POTENTIAL_CUSTOMER_LIST);
		
 	}
 	
		
	
	protected boolean isExtractPotentialCustomerContactListEnabled(Map<String,Object> options){		
 		return checkOptions(options,CityPartnerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
 	}
 	protected boolean isAnalyzePotentialCustomerContactListEnabled(Map<String,Object> options){		 		
 		return CityPartnerTokens.of(options).analyzePotentialCustomerContactListEnabled();
 	}
	
	protected boolean isSavePotentialCustomerContactListEnabled(Map<String,Object> options){
		return checkOptions(options, CityPartnerTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}
 	
		

	

	protected CityPartnerMapper getCityPartnerMapper(){
		return new CityPartnerMapper();
	}

	
	
	protected CityPartner extractCityPartner(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			CityPartner cityPartner = loadSingleObject(accessKey, getCityPartnerMapper());
			return cityPartner;
		}catch(EmptyResultDataAccessException e){
			throw new CityPartnerNotFoundException("CityPartner("+accessKey+") is not found!");
		}

	}

	
	

	protected CityPartner loadInternalCityPartner(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		CityPartner cityPartner = extractCityPartner(accessKey, loadOptions);
 	
 		if(isExtractCityServiceCenterEnabled(loadOptions)){
	 		extractCityServiceCenter(cityPartner, loadOptions);
 		}
 
		
		if(isExtractPotentialCustomerListEnabled(loadOptions)){
	 		extractPotentialCustomerList(cityPartner, loadOptions);
 		}	
 		
 		
 		if(isAnalyzePotentialCustomerListEnabled(loadOptions)){
	 		analyzePotentialCustomerList(cityPartner, loadOptions);
 		}
 		
		
		if(isExtractPotentialCustomerContactListEnabled(loadOptions)){
	 		extractPotentialCustomerContactList(cityPartner, loadOptions);
 		}	
 		
 		
 		if(isAnalyzePotentialCustomerContactListEnabled(loadOptions)){
	 		analyzePotentialCustomerContactList(cityPartner, loadOptions);
 		}
 		
		
		return cityPartner;
		
	}

	 

 	protected CityPartner extractCityServiceCenter(CityPartner cityPartner, Map<String,Object> options) throws Exception{

		if(cityPartner.getCityServiceCenter() == null){
			return cityPartner;
		}
		String cityServiceCenterId = cityPartner.getCityServiceCenter().getId();
		if( cityServiceCenterId == null){
			return cityPartner;
		}
		RetailStoreCityServiceCenter cityServiceCenter = getRetailStoreCityServiceCenterDAO().load(cityServiceCenterId,options);
		if(cityServiceCenter != null){
			cityPartner.setCityServiceCenter(cityServiceCenter);
		}
		
 		
 		return cityPartner;
 	}
 		
 
		
	protected void enhancePotentialCustomerList(SmartList<PotentialCustomer> potentialCustomerList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected CityPartner extractPotentialCustomerList(CityPartner cityPartner, Map<String,Object> options){
		
		
		if(cityPartner == null){
			return null;
		}
		if(cityPartner.getId() == null){
			return cityPartner;
		}

		
		
		SmartList<PotentialCustomer> potentialCustomerList = getPotentialCustomerDAO().findPotentialCustomerByCityPartner(cityPartner.getId(),options);
		if(potentialCustomerList != null){
			enhancePotentialCustomerList(potentialCustomerList,options);
			cityPartner.setPotentialCustomerList(potentialCustomerList);
		}
		
		return cityPartner;
	
	}	
	
	protected CityPartner analyzePotentialCustomerList(CityPartner cityPartner, Map<String,Object> options){
		
		
		if(cityPartner == null){
			return null;
		}
		if(cityPartner.getId() == null){
			return cityPartner;
		}

		
		
		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		if(potentialCustomerList != null){
			getPotentialCustomerDAO().analyzePotentialCustomerByCityPartner(potentialCustomerList, cityPartner.getId(), options);
			
		}
		
		return cityPartner;
	
	}	
	
		
	protected void enhancePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected CityPartner extractPotentialCustomerContactList(CityPartner cityPartner, Map<String,Object> options){
		
		
		if(cityPartner == null){
			return null;
		}
		if(cityPartner.getId() == null){
			return cityPartner;
		}

		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = getPotentialCustomerContactDAO().findPotentialCustomerContactByCityPartner(cityPartner.getId(),options);
		if(potentialCustomerContactList != null){
			enhancePotentialCustomerContactList(potentialCustomerContactList,options);
			cityPartner.setPotentialCustomerContactList(potentialCustomerContactList);
		}
		
		return cityPartner;
	
	}	
	
	protected CityPartner analyzePotentialCustomerContactList(CityPartner cityPartner, Map<String,Object> options){
		
		
		if(cityPartner == null){
			return null;
		}
		if(cityPartner.getId() == null){
			return cityPartner;
		}

		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		if(potentialCustomerContactList != null){
			getPotentialCustomerContactDAO().analyzePotentialCustomerContactByCityPartner(potentialCustomerContactList, cityPartner.getId(), options);
			
		}
		
		return cityPartner;
	
	}	
	
		
		
  	
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){
 	
  		SmartList<CityPartner> resultList = queryWith(CityPartnerTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getCityPartnerMapper());
		// analyzeCityPartnerByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<CityPartner> findCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId, int start, int count,Map<String,Object> options){
 		
 		SmartList<CityPartner> resultList =  queryWithRange(CityPartnerTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options, getCityPartnerMapper(), start, count);
 		//analyzeCityPartnerByCityServiceCenter(resultList, retailStoreCityServiceCenterId, options);
 		return resultList;
 		
 	}
 	public void analyzeCityPartnerByCityServiceCenter(SmartList<CityPartner> resultList, String retailStoreCityServiceCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(CityPartner.CITY_SERVICE_CENTER_PROPERTY, retailStoreCityServiceCenterId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//CityPartner.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("城市合伙人");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(CityPartner.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(CityPartner.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countCityPartnerByCityServiceCenter(String retailStoreCityServiceCenterId,Map<String,Object> options){

 		return countWith(CityPartnerTable.COLUMN_CITY_SERVICE_CENTER, retailStoreCityServiceCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countCityPartnerByCityServiceCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(CityPartnerTable.COLUMN_CITY_SERVICE_CENTER, ids, options);
	}
 	
 	
		
		
		

	

	protected CityPartner saveCityPartner(CityPartner  cityPartner){
		
		if(!cityPartner.isChanged()){
			return cityPartner;
		}
		

		String SQL=this.getSaveCityPartnerSQL(cityPartner);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveCityPartnerParameters(cityPartner);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		cityPartner.incVersion();
		return cityPartner;

	}
	public SmartList<CityPartner> saveCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitCityPartnerList(cityPartnerList);

		batchCityPartnerCreate((List<CityPartner>)lists[CREATE_LIST_INDEX]);

		batchCityPartnerUpdate((List<CityPartner>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(CityPartner cityPartner:cityPartnerList){
			if(cityPartner.isChanged()){
				cityPartner.incVersion();
			}


		}


		return cityPartnerList;
	}

	public SmartList<CityPartner> removeCityPartnerList(SmartList<CityPartner> cityPartnerList,Map<String,Object> options){


		super.removeList(cityPartnerList, options);

		return cityPartnerList;


	}

	protected List<Object[]> prepareCityPartnerBatchCreateArgs(List<CityPartner> cityPartnerList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityPartner cityPartner:cityPartnerList ){
			Object [] parameters = prepareCityPartnerCreateParameters(cityPartner);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareCityPartnerBatchUpdateArgs(List<CityPartner> cityPartnerList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(CityPartner cityPartner:cityPartnerList ){
			if(!cityPartner.isChanged()){
				continue;
			}
			Object [] parameters = prepareCityPartnerUpdateParameters(cityPartner);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchCityPartnerCreate(List<CityPartner> cityPartnerList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareCityPartnerBatchCreateArgs(cityPartnerList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchCityPartnerUpdate(List<CityPartner> cityPartnerList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareCityPartnerBatchUpdateArgs(cityPartnerList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitCityPartnerList(List<CityPartner> cityPartnerList){

		List<CityPartner> cityPartnerCreateList=new ArrayList<CityPartner>();
		List<CityPartner> cityPartnerUpdateList=new ArrayList<CityPartner>();

		for(CityPartner cityPartner: cityPartnerList){
			if(isUpdateRequest(cityPartner)){
				cityPartnerUpdateList.add( cityPartner);
				continue;
			}
			cityPartnerCreateList.add(cityPartner);
		}

		return new Object[]{cityPartnerCreateList,cityPartnerUpdateList};
	}

	protected boolean isUpdateRequest(CityPartner cityPartner){
 		return cityPartner.getVersion() > 0;
 	}
 	protected String getSaveCityPartnerSQL(CityPartner cityPartner){
 		if(isUpdateRequest(cityPartner)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveCityPartnerParameters(CityPartner cityPartner){
 		if(isUpdateRequest(cityPartner) ){
 			return prepareCityPartnerUpdateParameters(cityPartner);
 		}
 		return prepareCityPartnerCreateParameters(cityPartner);
 	}
 	protected Object[] prepareCityPartnerUpdateParameters(CityPartner cityPartner){
 		Object[] parameters = new Object[8];
 
 		
 		parameters[0] = cityPartner.getName();
 		
 		
 		parameters[1] = cityPartner.getMobile();
 		
 		if(cityPartner.getCityServiceCenter() != null){
 			parameters[2] = cityPartner.getCityServiceCenter().getId();
 		}
 
 		
 		parameters[3] = cityPartner.getDescription();
 		
 		
 		parameters[4] = cityPartner.getLastUpdateTime();
 		
 		parameters[5] = cityPartner.nextVersion();
 		parameters[6] = cityPartner.getId();
 		parameters[7] = cityPartner.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareCityPartnerCreateParameters(CityPartner cityPartner){
		Object[] parameters = new Object[6];
        if(cityPartner.getId() == null){
          String newCityPartnerId=getNextId();
          cityPartner.setId(newCityPartnerId);
        }
		parameters[0] =  cityPartner.getId();
 
 		
 		parameters[1] = cityPartner.getName();
 		
 		
 		parameters[2] = cityPartner.getMobile();
 		
 		if(cityPartner.getCityServiceCenter() != null){
 			parameters[3] = cityPartner.getCityServiceCenter().getId();

 		}
 		
 		
 		parameters[4] = cityPartner.getDescription();
 		
 		
 		parameters[5] = cityPartner.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected CityPartner saveInternalCityPartner(CityPartner cityPartner, Map<String,Object> options){

		saveCityPartner(cityPartner);

 		if(isSaveCityServiceCenterEnabled(options)){
	 		saveCityServiceCenter(cityPartner, options);
 		}
 
		
		if(isSavePotentialCustomerListEnabled(options)){
	 		savePotentialCustomerList(cityPartner, options);
	 		//removePotentialCustomerList(cityPartner, options);
	 		//Not delete the record

 		}
		
		if(isSavePotentialCustomerContactListEnabled(options)){
	 		savePotentialCustomerContactList(cityPartner, options);
	 		//removePotentialCustomerContactList(cityPartner, options);
	 		//Not delete the record

 		}
		
		return cityPartner;

	}



	//======================================================================================
	

 	protected CityPartner saveCityServiceCenter(CityPartner cityPartner, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(cityPartner.getCityServiceCenter() == null){
 			return cityPartner;//do nothing when it is null
 		}

 		getRetailStoreCityServiceCenterDAO().save(cityPartner.getCityServiceCenter(),options);
 		return cityPartner;

 	}





 

	
	public CityPartner planToRemovePotentialCustomerList(CityPartner cityPartner, String potentialCustomerIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartner.getId());
		key.put(PotentialCustomer.ID_PROPERTY, potentialCustomerIds);

		SmartList<PotentialCustomer> externalPotentialCustomerList = getPotentialCustomerDAO().
				findPotentialCustomerWithKey(key, options);
		if(externalPotentialCustomerList == null){
			return cityPartner;
		}
		if(externalPotentialCustomerList.isEmpty()){
			return cityPartner;
		}

		for(PotentialCustomer potentialCustomerItem: externalPotentialCustomerList){

			potentialCustomerItem.clearFromAll();
		}


		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		potentialCustomerList.addAllToRemoveList(externalPotentialCustomerList);
		return cityPartner;

	}


	//disconnect CityPartner with city_service_center in PotentialCustomer
	public CityPartner planToRemovePotentialCustomerListWithCityServiceCenter(CityPartner cityPartner, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartner.getId());
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

		SmartList<PotentialCustomer> externalPotentialCustomerList = getPotentialCustomerDAO().
				findPotentialCustomerWithKey(key, options);
		if(externalPotentialCustomerList == null){
			return cityPartner;
		}
		if(externalPotentialCustomerList.isEmpty()){
			return cityPartner;
		}

		for(PotentialCustomer potentialCustomerItem: externalPotentialCustomerList){
			potentialCustomerItem.clearCityServiceCenter();
			potentialCustomerItem.clearCityPartner();

		}


		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		potentialCustomerList.addAllToRemoveList(externalPotentialCustomerList);
		return cityPartner;
	}

	public int countPotentialCustomerListWithCityServiceCenter(String cityPartnerId, String cityServiceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, cityPartnerId);
		key.put(PotentialCustomer.CITY_SERVICE_CENTER_PROPERTY, cityServiceCenterId);

		int count = getPotentialCustomerDAO().countPotentialCustomerWithKey(key, options);
		return count;
	}
	
	public CityPartner planToRemovePotentialCustomerContactList(CityPartner cityPartner, String potentialCustomerContactIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartner.getId());
		key.put(PotentialCustomerContact.ID_PROPERTY, potentialCustomerContactIds);

		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return cityPartner;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return cityPartner;
		}

		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){

			potentialCustomerContactItem.clearFromAll();
		}


		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return cityPartner;

	}


	//disconnect CityPartner with potential_customer in PotentialCustomerContact
	public CityPartner planToRemovePotentialCustomerContactListWithPotentialCustomer(CityPartner cityPartner, String potentialCustomerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartner.getId());
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);

		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return cityPartner;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return cityPartner;
		}

		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){
			potentialCustomerContactItem.clearPotentialCustomer();
			potentialCustomerContactItem.clearCityPartner();

		}


		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return cityPartner;
	}

	public int countPotentialCustomerContactListWithPotentialCustomer(String cityPartnerId, String potentialCustomerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartnerId);
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);

		int count = getPotentialCustomerContactDAO().countPotentialCustomerContactWithKey(key, options);
		return count;
	}
	
	//disconnect CityPartner with contact_to in PotentialCustomerContact
	public CityPartner planToRemovePotentialCustomerContactListWithContactTo(CityPartner cityPartner, String contactToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartner.getId());
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, contactToId);

		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return cityPartner;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return cityPartner;
		}

		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){
			potentialCustomerContactItem.clearContactTo();
			potentialCustomerContactItem.clearCityPartner();

		}


		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return cityPartner;
	}

	public int countPotentialCustomerContactListWithContactTo(String cityPartnerId, String contactToId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartnerId);
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, contactToId);

		int count = getPotentialCustomerContactDAO().countPotentialCustomerContactWithKey(key, options);
		return count;
	}
	

		
	protected CityPartner savePotentialCustomerList(CityPartner cityPartner, Map<String,Object> options){




		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		if(potentialCustomerList == null){
			//null list means nothing
			return cityPartner;
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


		return cityPartner;

	}

	protected CityPartner removePotentialCustomerList(CityPartner cityPartner, Map<String,Object> options){


		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();
		if(potentialCustomerList == null){
			return cityPartner;
		}

		SmartList<PotentialCustomer> toRemovePotentialCustomerList = potentialCustomerList.getToRemoveList();

		if(toRemovePotentialCustomerList == null){
			return cityPartner;
		}
		if(toRemovePotentialCustomerList.isEmpty()){
			return cityPartner;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getPotentialCustomerDAO().removePotentialCustomerList(toRemovePotentialCustomerList,options);

		return cityPartner;

	}








		
	protected CityPartner savePotentialCustomerContactList(CityPartner cityPartner, Map<String,Object> options){




		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			//null list means nothing
			return cityPartner;
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


		return cityPartner;

	}

	protected CityPartner removePotentialCustomerContactList(CityPartner cityPartner, Map<String,Object> options){


		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return cityPartner;
		}

		SmartList<PotentialCustomerContact> toRemovePotentialCustomerContactList = potentialCustomerContactList.getToRemoveList();

		if(toRemovePotentialCustomerContactList == null){
			return cityPartner;
		}
		if(toRemovePotentialCustomerContactList.isEmpty()){
			return cityPartner;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getPotentialCustomerContactDAO().removePotentialCustomerContactList(toRemovePotentialCustomerContactList,options);

		return cityPartner;

	}








		

	public CityPartner present(CityPartner cityPartner,Map<String, Object> options){
	
		presentPotentialCustomerList(cityPartner,options);
		presentPotentialCustomerContactList(cityPartner,options);

		return cityPartner;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected CityPartner presentPotentialCustomerList(
			CityPartner cityPartner,
			Map<String, Object> options) {

		SmartList<PotentialCustomer> potentialCustomerList = cityPartner.getPotentialCustomerList();		
				SmartList<PotentialCustomer> newList= presentSubList(cityPartner.getId(),
				potentialCustomerList,
				options,
				getPotentialCustomerDAO()::countPotentialCustomerByCityPartner,
				getPotentialCustomerDAO()::findPotentialCustomerByCityPartner
				);

		
		cityPartner.setPotentialCustomerList(newList);
		

		return cityPartner;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected CityPartner presentPotentialCustomerContactList(
			CityPartner cityPartner,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContact> potentialCustomerContactList = cityPartner.getPotentialCustomerContactList();		
				SmartList<PotentialCustomerContact> newList= presentSubList(cityPartner.getId(),
				potentialCustomerContactList,
				options,
				getPotentialCustomerContactDAO()::countPotentialCustomerContactByCityPartner,
				getPotentialCustomerContactDAO()::findPotentialCustomerContactByCityPartner
				);

		
		cityPartner.setPotentialCustomerContactList(newList);
		

		return cityPartner;
	}			
		

	
    public SmartList<CityPartner> requestCandidateCityPartnerForPotentialCustomer(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CityPartnerTable.COLUMN_NAME, CityPartnerTable.COLUMN_CITY_SERVICE_CENTER, filterKey, pageNo, pageSize, getCityPartnerMapper());
    }
		
    public SmartList<CityPartner> requestCandidateCityPartnerForPotentialCustomerContact(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(CityPartnerTable.COLUMN_NAME, CityPartnerTable.COLUMN_CITY_SERVICE_CENTER, filterKey, pageNo, pageSize, getCityPartnerMapper());
    }
		

	protected String getTableName(){
		return CityPartnerTable.TABLE_NAME;
	}



	public void enhanceList(List<CityPartner> cityPartnerList) {
		this.enhanceListInternal(cityPartnerList, this.getCityPartnerMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomer的cityPartner的PotentialCustomerList
	public SmartList<PotentialCustomer> loadOurPotentialCustomerList(RetailscmUserContext userContext, List<CityPartner> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomer.CITY_PARTNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PotentialCustomer> loadedObjs = userContext.getDAOGroup().getPotentialCustomerDAO().findPotentialCustomerWithKey(key, options);
		Map<String, List<PotentialCustomer>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCityPartner().getId()));
		us.forEach(it->{
			String id = it.getId();
			List<PotentialCustomer> loadedList = loadedMap.get(id);
			if (loadedList == null || loadedList.isEmpty()) {
				return;
			}
			SmartList<PotentialCustomer> loadedSmartList = new SmartList<>();
			loadedSmartList.addAll(loadedList);
			it.setPotentialCustomerList(loadedSmartList);
		});
		return loadedObjs;
	}
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContact的cityPartner的PotentialCustomerContactList
	public SmartList<PotentialCustomerContact> loadOurPotentialCustomerContactList(RetailscmUserContext userContext, List<CityPartner> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PotentialCustomerContact> loadedObjs = userContext.getDAOGroup().getPotentialCustomerContactDAO().findPotentialCustomerContactWithKey(key, options);
		Map<String, List<PotentialCustomerContact>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getCityPartner().getId()));
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
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<CityPartner> cityPartnerList = ownerEntity.collectRefsWithType(CityPartner.INTERNAL_TYPE);
		this.enhanceList(cityPartnerList);

	}

	@Override
	public SmartList<CityPartner> findCityPartnerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getCityPartnerMapper());

	}
	@Override
	public int countCityPartnerWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countCityPartnerWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<CityPartner> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getCityPartnerMapper());
	}

  @Override
  public Stream<CityPartner> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getCityPartnerMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateCityPartner executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateCityPartner result = new CandidateCityPartner();
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


