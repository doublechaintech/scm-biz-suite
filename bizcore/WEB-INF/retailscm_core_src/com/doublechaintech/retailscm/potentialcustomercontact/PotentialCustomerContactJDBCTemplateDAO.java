
package com.doublechaintech.retailscm.potentialcustomercontact;

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


import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.citypartner.CityPartner;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPerson;

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.citypartner.CityPartnerDAO;
import com.doublechaintech.retailscm.potentialcustomercontactperson.PotentialCustomerContactPersonDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class PotentialCustomerContactJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PotentialCustomerContactDAO{

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


	/*
	protected PotentialCustomerContact load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContact(accessKey, options);
	}
	*/

	public SmartList<PotentialCustomerContact> loadAll() {
	    return this.loadAll(getPotentialCustomerContactMapper());
	}

  public Stream<PotentialCustomerContact> loadAllAsStream() {
      return this.loadAllAsStream(getPotentialCustomerContactMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public PotentialCustomerContact load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContact(PotentialCustomerContactTable.withId(id), options);
	}

	

	public PotentialCustomerContact save(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options){

		String methodName="save(PotentialCustomerContact potentialCustomerContact,Map<String,Object> options)";

		assertMethodArgumentNotNull(potentialCustomerContact, methodName, "potentialCustomerContact");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalPotentialCustomerContact(potentialCustomerContact,options);
	}
	public PotentialCustomerContact clone(String potentialCustomerContactId, Map<String,Object> options) throws Exception{

		return clone(PotentialCustomerContactTable.withId(potentialCustomerContactId),options);
	}

	protected PotentialCustomerContact clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String potentialCustomerContactId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		PotentialCustomerContact newPotentialCustomerContact = loadInternalPotentialCustomerContact(accessKey, options);
		newPotentialCustomerContact.setVersion(0);
		
		


		saveInternalPotentialCustomerContact(newPotentialCustomerContact,options);

		return newPotentialCustomerContact;
	}

	



	protected void throwIfHasException(String potentialCustomerContactId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PotentialCustomerContactVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PotentialCustomerContactNotFoundException(
					"The " + this.getTableName() + "(" + potentialCustomerContactId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String potentialCustomerContactId, int version) throws Exception{

		String methodName="delete(String potentialCustomerContactId, int version)";
		assertMethodArgumentNotNull(potentialCustomerContactId, methodName, "potentialCustomerContactId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{potentialCustomerContactId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(potentialCustomerContactId,version);
		}


	}






	public PotentialCustomerContact disconnectFromAll(String potentialCustomerContactId, int version) throws Exception{


		PotentialCustomerContact potentialCustomerContact = loadInternalPotentialCustomerContact(PotentialCustomerContactTable.withId(potentialCustomerContactId), emptyOptions());
		potentialCustomerContact.clearFromAll();
		this.savePotentialCustomerContact(potentialCustomerContact);
		return potentialCustomerContact;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return PotentialCustomerContactTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "potential_customer_contact";
	}
	@Override
	protected String getBeanName() {

		return "potentialCustomerContact";
	}

	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PotentialCustomerContactTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPotentialCustomerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactTokens.POTENTIALCUSTOMER);
 	}

 	protected boolean isSavePotentialCustomerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactTokens.POTENTIALCUSTOMER);
 	}
 	

 	
  

 	protected boolean isExtractCityPartnerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactTokens.CITYPARTNER);
 	}

 	protected boolean isSaveCityPartnerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactTokens.CITYPARTNER);
 	}
 	

 	
  

 	protected boolean isExtractContactToEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactTokens.CONTACTTO);
 	}

 	protected boolean isSaveContactToEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactTokens.CONTACTTO);
 	}
 	

 	
 
		

	

	protected PotentialCustomerContactMapper getPotentialCustomerContactMapper(){
		return new PotentialCustomerContactMapper();
	}

	
	
	protected PotentialCustomerContact extractPotentialCustomerContact(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PotentialCustomerContact potentialCustomerContact = loadSingleObject(accessKey, getPotentialCustomerContactMapper());
			return potentialCustomerContact;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerContactNotFoundException("PotentialCustomerContact("+accessKey+") is not found!");
		}

	}

	
	

	protected PotentialCustomerContact loadInternalPotentialCustomerContact(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PotentialCustomerContact potentialCustomerContact = extractPotentialCustomerContact(accessKey, loadOptions);
 	
 		if(isExtractPotentialCustomerEnabled(loadOptions)){
	 		extractPotentialCustomer(potentialCustomerContact, loadOptions);
 		}
  	
 		if(isExtractCityPartnerEnabled(loadOptions)){
	 		extractCityPartner(potentialCustomerContact, loadOptions);
 		}
  	
 		if(isExtractContactToEnabled(loadOptions)){
	 		extractContactTo(potentialCustomerContact, loadOptions);
 		}
 
		
		return potentialCustomerContact;
		
	}

	 

 	protected PotentialCustomerContact extractPotentialCustomer(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options) throws Exception{

		if(potentialCustomerContact.getPotentialCustomer() == null){
			return potentialCustomerContact;
		}
		String potentialCustomerId = potentialCustomerContact.getPotentialCustomer().getId();
		if( potentialCustomerId == null){
			return potentialCustomerContact;
		}
		PotentialCustomer potentialCustomer = getPotentialCustomerDAO().load(potentialCustomerId,options);
		if(potentialCustomer != null){
			potentialCustomerContact.setPotentialCustomer(potentialCustomer);
		}
		
 		
 		return potentialCustomerContact;
 	}
 		
  

 	protected PotentialCustomerContact extractCityPartner(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options) throws Exception{

		if(potentialCustomerContact.getCityPartner() == null){
			return potentialCustomerContact;
		}
		String cityPartnerId = potentialCustomerContact.getCityPartner().getId();
		if( cityPartnerId == null){
			return potentialCustomerContact;
		}
		CityPartner cityPartner = getCityPartnerDAO().load(cityPartnerId,options);
		if(cityPartner != null){
			potentialCustomerContact.setCityPartner(cityPartner);
		}
		
 		
 		return potentialCustomerContact;
 	}
 		
  

 	protected PotentialCustomerContact extractContactTo(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options) throws Exception{

		if(potentialCustomerContact.getContactTo() == null){
			return potentialCustomerContact;
		}
		String contactToId = potentialCustomerContact.getContactTo().getId();
		if( contactToId == null){
			return potentialCustomerContact;
		}
		PotentialCustomerContactPerson contactTo = getPotentialCustomerContactPersonDAO().load(contactToId,options);
		if(contactTo != null){
			potentialCustomerContact.setContactTo(contactTo);
		}
		
 		
 		return potentialCustomerContact;
 	}
 		
 
		
		
  	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
 	
  		SmartList<PotentialCustomerContact> resultList = queryWith(PotentialCustomerContactTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options, getPotentialCustomerContactMapper());
		// analyzePotentialCustomerContactByPotentialCustomer(resultList, potentialCustomerId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByPotentialCustomer(String potentialCustomerId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PotentialCustomerContact> resultList =  queryWithRange(PotentialCustomerContactTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options, getPotentialCustomerContactMapper(), start, count);
 		//analyzePotentialCustomerContactByPotentialCustomer(resultList, potentialCustomerId, options);
 		return resultList;
 		
 	}
 	public void analyzePotentialCustomerContactByPotentialCustomer(SmartList<PotentialCustomerContact> resultList, String potentialCustomerId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("潜在客户联系");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countPotentialCustomerContactByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){

 		return countWith(PotentialCustomerContactTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options);
 	}
 	@Override
	public Map<String, Integer> countPotentialCustomerContactByPotentialCustomerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PotentialCustomerContactTable.COLUMN_POTENTIAL_CUSTOMER, ids, options);
	}
 	
  	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId,Map<String,Object> options){
 	
  		SmartList<PotentialCustomerContact> resultList = queryWith(PotentialCustomerContactTable.COLUMN_CITY_PARTNER, cityPartnerId, options, getPotentialCustomerContactMapper());
		// analyzePotentialCustomerContactByCityPartner(resultList, cityPartnerId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByCityPartner(String cityPartnerId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PotentialCustomerContact> resultList =  queryWithRange(PotentialCustomerContactTable.COLUMN_CITY_PARTNER, cityPartnerId, options, getPotentialCustomerContactMapper(), start, count);
 		//analyzePotentialCustomerContactByCityPartner(resultList, cityPartnerId, options);
 		return resultList;
 		
 	}
 	public void analyzePotentialCustomerContactByCityPartner(SmartList<PotentialCustomerContact> resultList, String cityPartnerId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartnerId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("潜在客户联系");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countPotentialCustomerContactByCityPartner(String cityPartnerId,Map<String,Object> options){

 		return countWith(PotentialCustomerContactTable.COLUMN_CITY_PARTNER, cityPartnerId, options);
 	}
 	@Override
	public Map<String, Integer> countPotentialCustomerContactByCityPartnerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PotentialCustomerContactTable.COLUMN_CITY_PARTNER, ids, options);
	}
 	
  	
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId,Map<String,Object> options){
 	
  		SmartList<PotentialCustomerContact> resultList = queryWith(PotentialCustomerContactTable.COLUMN_CONTACT_TO, potentialCustomerContactPersonId, options, getPotentialCustomerContactMapper());
		// analyzePotentialCustomerContactByContactTo(resultList, potentialCustomerContactPersonId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PotentialCustomerContact> findPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PotentialCustomerContact> resultList =  queryWithRange(PotentialCustomerContactTable.COLUMN_CONTACT_TO, potentialCustomerContactPersonId, options, getPotentialCustomerContactMapper(), start, count);
 		//analyzePotentialCustomerContactByContactTo(resultList, potentialCustomerContactPersonId, options);
 		return resultList;
 		
 	}
 	public void analyzePotentialCustomerContactByContactTo(SmartList<PotentialCustomerContact> resultList, String potentialCustomerContactPersonId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}
		
 		MultipleAccessKey filterKey = new MultipleAccessKey();
 		filterKey.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContactPersonId);
 		Map<String,Object> emptyOptions = new HashMap<String,Object>();
 		
 		StatsInfo info = new StatsInfo();
 		
 
		StatsItem lastUpdateTimeStatsItem = new StatsItem();
		//PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY
		lastUpdateTimeStatsItem.setDisplayName("潜在客户联系");
		lastUpdateTimeStatsItem.setInternalName(formatKeyForDateLine(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY));
		lastUpdateTimeStatsItem.setResult(statsWithGroup(DateKey.class,wrapWithDate(PotentialCustomerContact.LAST_UPDATE_TIME_PROPERTY),filterKey,emptyOptions));
		info.addItem(lastUpdateTimeStatsItem);
 				
 		resultList.setStatsInfo(info);

 	
 		
 	}
 	@Override
 	public int countPotentialCustomerContactByContactTo(String potentialCustomerContactPersonId,Map<String,Object> options){

 		return countWith(PotentialCustomerContactTable.COLUMN_CONTACT_TO, potentialCustomerContactPersonId, options);
 	}
 	@Override
	public Map<String, Integer> countPotentialCustomerContactByContactToIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PotentialCustomerContactTable.COLUMN_CONTACT_TO, ids, options);
	}
 	
 	
		
		
		

	

	protected PotentialCustomerContact savePotentialCustomerContact(PotentialCustomerContact  potentialCustomerContact){
		
		if(!potentialCustomerContact.isChanged()){
			return potentialCustomerContact;
		}
		

		String SQL=this.getSavePotentialCustomerContactSQL(potentialCustomerContact);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePotentialCustomerContactParameters(potentialCustomerContact);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		potentialCustomerContact.incVersion();
		return potentialCustomerContact;

	}
	public SmartList<PotentialCustomerContact> savePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPotentialCustomerContactList(potentialCustomerContactList);

		batchPotentialCustomerContactCreate((List<PotentialCustomerContact>)lists[CREATE_LIST_INDEX]);

		batchPotentialCustomerContactUpdate((List<PotentialCustomerContact>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList){
			if(potentialCustomerContact.isChanged()){
				potentialCustomerContact.incVersion();
			}


		}


		return potentialCustomerContactList;
	}

	public SmartList<PotentialCustomerContact> removePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options){


		super.removeList(potentialCustomerContactList, options);

		return potentialCustomerContactList;


	}

	protected List<Object[]> preparePotentialCustomerContactBatchCreateArgs(List<PotentialCustomerContact> potentialCustomerContactList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList ){
			Object [] parameters = preparePotentialCustomerContactCreateParameters(potentialCustomerContact);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> preparePotentialCustomerContactBatchUpdateArgs(List<PotentialCustomerContact> potentialCustomerContactList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContact potentialCustomerContact:potentialCustomerContactList ){
			if(!potentialCustomerContact.isChanged()){
				continue;
			}
			Object [] parameters = preparePotentialCustomerContactUpdateParameters(potentialCustomerContact);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchPotentialCustomerContactCreate(List<PotentialCustomerContact> potentialCustomerContactList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePotentialCustomerContactBatchCreateArgs(potentialCustomerContactList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchPotentialCustomerContactUpdate(List<PotentialCustomerContact> potentialCustomerContactList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePotentialCustomerContactBatchUpdateArgs(potentialCustomerContactList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitPotentialCustomerContactList(List<PotentialCustomerContact> potentialCustomerContactList){

		List<PotentialCustomerContact> potentialCustomerContactCreateList=new ArrayList<PotentialCustomerContact>();
		List<PotentialCustomerContact> potentialCustomerContactUpdateList=new ArrayList<PotentialCustomerContact>();

		for(PotentialCustomerContact potentialCustomerContact: potentialCustomerContactList){
			if(isUpdateRequest(potentialCustomerContact)){
				potentialCustomerContactUpdateList.add( potentialCustomerContact);
				continue;
			}
			potentialCustomerContactCreateList.add(potentialCustomerContact);
		}

		return new Object[]{potentialCustomerContactCreateList,potentialCustomerContactUpdateList};
	}

	protected boolean isUpdateRequest(PotentialCustomerContact potentialCustomerContact){
 		return potentialCustomerContact.getVersion() > 0;
 	}
 	protected String getSavePotentialCustomerContactSQL(PotentialCustomerContact potentialCustomerContact){
 		if(isUpdateRequest(potentialCustomerContact)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSavePotentialCustomerContactParameters(PotentialCustomerContact potentialCustomerContact){
 		if(isUpdateRequest(potentialCustomerContact) ){
 			return preparePotentialCustomerContactUpdateParameters(potentialCustomerContact);
 		}
 		return preparePotentialCustomerContactCreateParameters(potentialCustomerContact);
 	}
 	protected Object[] preparePotentialCustomerContactUpdateParameters(PotentialCustomerContact potentialCustomerContact){
 		Object[] parameters = new Object[11];
 
 		
 		parameters[0] = potentialCustomerContact.getName();
 		
 		
 		parameters[1] = potentialCustomerContact.getContactDate();
 		
 		
 		parameters[2] = potentialCustomerContact.getContactMethod();
 		
 		if(potentialCustomerContact.getPotentialCustomer() != null){
 			parameters[3] = potentialCustomerContact.getPotentialCustomer().getId();
 		}
 
 		if(potentialCustomerContact.getCityPartner() != null){
 			parameters[4] = potentialCustomerContact.getCityPartner().getId();
 		}
 
 		if(potentialCustomerContact.getContactTo() != null){
 			parameters[5] = potentialCustomerContact.getContactTo().getId();
 		}
 
 		
 		parameters[6] = potentialCustomerContact.getDescription();
 		
 		
 		parameters[7] = potentialCustomerContact.getLastUpdateTime();
 		
 		parameters[8] = potentialCustomerContact.nextVersion();
 		parameters[9] = potentialCustomerContact.getId();
 		parameters[10] = potentialCustomerContact.getVersion();

 		return parameters;
 	}
 	protected Object[] preparePotentialCustomerContactCreateParameters(PotentialCustomerContact potentialCustomerContact){
		Object[] parameters = new Object[9];
        if(potentialCustomerContact.getId() == null){
          String newPotentialCustomerContactId=getNextId();
          potentialCustomerContact.setId(newPotentialCustomerContactId);
        }
		parameters[0] =  potentialCustomerContact.getId();
 
 		
 		parameters[1] = potentialCustomerContact.getName();
 		
 		
 		parameters[2] = potentialCustomerContact.getContactDate();
 		
 		
 		parameters[3] = potentialCustomerContact.getContactMethod();
 		
 		if(potentialCustomerContact.getPotentialCustomer() != null){
 			parameters[4] = potentialCustomerContact.getPotentialCustomer().getId();

 		}
 		
 		if(potentialCustomerContact.getCityPartner() != null){
 			parameters[5] = potentialCustomerContact.getCityPartner().getId();

 		}
 		
 		if(potentialCustomerContact.getContactTo() != null){
 			parameters[6] = potentialCustomerContact.getContactTo().getId();

 		}
 		
 		
 		parameters[7] = potentialCustomerContact.getDescription();
 		
 		
 		parameters[8] = potentialCustomerContact.getLastUpdateTime();
 		

 		return parameters;
 	}

	protected PotentialCustomerContact saveInternalPotentialCustomerContact(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){

		savePotentialCustomerContact(potentialCustomerContact);

 		if(isSavePotentialCustomerEnabled(options)){
	 		savePotentialCustomer(potentialCustomerContact, options);
 		}
 
 		if(isSaveCityPartnerEnabled(options)){
	 		saveCityPartner(potentialCustomerContact, options);
 		}
 
 		if(isSaveContactToEnabled(options)){
	 		saveContactTo(potentialCustomerContact, options);
 		}
 
		
		return potentialCustomerContact;

	}



	//======================================================================================
	

 	protected PotentialCustomerContact savePotentialCustomer(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContact.getPotentialCustomer() == null){
 			return potentialCustomerContact;//do nothing when it is null
 		}

 		getPotentialCustomerDAO().save(potentialCustomerContact.getPotentialCustomer(),options);
 		return potentialCustomerContact;

 	}





 

 	protected PotentialCustomerContact saveCityPartner(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContact.getCityPartner() == null){
 			return potentialCustomerContact;//do nothing when it is null
 		}

 		getCityPartnerDAO().save(potentialCustomerContact.getCityPartner(),options);
 		return potentialCustomerContact;

 	}





 

 	protected PotentialCustomerContact saveContactTo(PotentialCustomerContact potentialCustomerContact, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContact.getContactTo() == null){
 			return potentialCustomerContact;//do nothing when it is null
 		}

 		getPotentialCustomerContactPersonDAO().save(potentialCustomerContact.getContactTo(),options);
 		return potentialCustomerContact;

 	}





 

	

		

	public PotentialCustomerContact present(PotentialCustomerContact potentialCustomerContact,Map<String, Object> options){
	

		return potentialCustomerContact;
	
	}
		

	

	protected String getTableName(){
		return PotentialCustomerContactTable.TABLE_NAME;
	}



	public void enhanceList(List<PotentialCustomerContact> potentialCustomerContactList) {
		this.enhanceListInternal(potentialCustomerContactList, this.getPotentialCustomerContactMapper());
	}

	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<PotentialCustomerContact> potentialCustomerContactList = ownerEntity.collectRefsWithType(PotentialCustomerContact.INTERNAL_TYPE);
		this.enhanceList(potentialCustomerContactList);

	}

	@Override
	public SmartList<PotentialCustomerContact> findPotentialCustomerContactWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getPotentialCustomerContactMapper());

	}
	@Override
	public int countPotentialCustomerContactWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countPotentialCustomerContactWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<PotentialCustomerContact> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPotentialCustomerContactMapper());
	}

  @Override
  public Stream<PotentialCustomerContact> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getPotentialCustomerContactMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidatePotentialCustomerContact executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidatePotentialCustomerContact result = new CandidatePotentialCustomerContact();
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


