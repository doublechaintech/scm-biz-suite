
package com.doublechaintech.retailscm.potentialcustomercontactperson;

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

import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;


public class PotentialCustomerContactPersonJDBCTemplateDAO extends RetailscmBaseDAOImpl implements PotentialCustomerContactPersonDAO{

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
	protected PotentialCustomerContactPerson load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContactPerson(accessKey, options);
	}
	*/
	
	public SmartList<PotentialCustomerContactPerson> loadAll() {
	    return this.loadAll(getPotentialCustomerContactPersonMapper());
	}
	
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public PotentialCustomerContactPerson load(String id,Map<String,Object> options) throws Exception{
		return loadInternalPotentialCustomerContactPerson(PotentialCustomerContactPersonTable.withId(id), options);
	}
	
	
	
	public PotentialCustomerContactPerson save(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options){
		
		String methodName="save(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(potentialCustomerContactPerson, methodName, "potentialCustomerContactPerson");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalPotentialCustomerContactPerson(potentialCustomerContactPerson,options);
	}
	public PotentialCustomerContactPerson clone(String potentialCustomerContactPersonId, Map<String,Object> options) throws Exception{
	
		return clone(PotentialCustomerContactPersonTable.withId(potentialCustomerContactPersonId),options);
	}
	
	protected PotentialCustomerContactPerson clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String potentialCustomerContactPersonId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		PotentialCustomerContactPerson newPotentialCustomerContactPerson = loadInternalPotentialCustomerContactPerson(accessKey, options);
		newPotentialCustomerContactPerson.setVersion(0);
		
		
 		
 		if(isSavePotentialCustomerContactListEnabled(options)){
 			for(PotentialCustomerContact item: newPotentialCustomerContactPerson.getPotentialCustomerContactList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalPotentialCustomerContactPerson(newPotentialCustomerContactPerson,options);
		
		return newPotentialCustomerContactPerson;
	}
	
	
	
	

	protected void throwIfHasException(String potentialCustomerContactPersonId,int version,int count) throws Exception{
		if (count == 1) {
			throw new PotentialCustomerContactPersonVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new PotentialCustomerContactPersonNotFoundException(
					"The " + this.getTableName() + "(" + potentialCustomerContactPersonId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String potentialCustomerContactPersonId, int version) throws Exception{
	
		String methodName="delete(String potentialCustomerContactPersonId, int version)";
		assertMethodArgumentNotNull(potentialCustomerContactPersonId, methodName, "potentialCustomerContactPersonId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{potentialCustomerContactPersonId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(potentialCustomerContactPersonId,version);
		}
		
	
	}
	
	
	
	
	

	public PotentialCustomerContactPerson disconnectFromAll(String potentialCustomerContactPersonId, int version) throws Exception{
	
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = loadInternalPotentialCustomerContactPerson(PotentialCustomerContactPersonTable.withId(potentialCustomerContactPersonId), emptyOptions());
		potentialCustomerContactPerson.clearFromAll();
		this.savePotentialCustomerContactPerson(potentialCustomerContactPerson);
		return potentialCustomerContactPerson;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return PotentialCustomerContactPersonTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "potential_customer_contact_person";
	}
	@Override
	protected String getBeanName() {
		
		return "potentialCustomerContactPerson";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return PotentialCustomerContactPersonTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractPotentialCustomerEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, PotentialCustomerContactPersonTokens.POTENTIALCUSTOMER);
 	}

 	protected boolean isSavePotentialCustomerEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, PotentialCustomerContactPersonTokens.POTENTIALCUSTOMER);
 	}
 	

 	
 
		
	
	protected boolean isExtractPotentialCustomerContactListEnabled(Map<String,Object> options){		
 		return checkOptions(options,PotentialCustomerContactPersonTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
 	}
 	protected boolean isAnalyzePotentialCustomerContactListEnabled(Map<String,Object> options){		 		
 		return PotentialCustomerContactPersonTokens.of(options).analyzePotentialCustomerContactListEnabled();
 	}
	
	protected boolean isSavePotentialCustomerContactListEnabled(Map<String,Object> options){
		return checkOptions(options, PotentialCustomerContactPersonTokens.POTENTIAL_CUSTOMER_CONTACT_LIST);
		
 	}
 	
		

	

	protected PotentialCustomerContactPersonMapper getPotentialCustomerContactPersonMapper(){
		return new PotentialCustomerContactPersonMapper();
	}

	
	
	protected PotentialCustomerContactPerson extractPotentialCustomerContactPerson(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			PotentialCustomerContactPerson potentialCustomerContactPerson = loadSingleObject(accessKey, getPotentialCustomerContactPersonMapper());
			return potentialCustomerContactPerson;
		}catch(EmptyResultDataAccessException e){
			throw new PotentialCustomerContactPersonNotFoundException("PotentialCustomerContactPerson("+accessKey+") is not found!");
		}

	}

	
	

	protected PotentialCustomerContactPerson loadInternalPotentialCustomerContactPerson(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		PotentialCustomerContactPerson potentialCustomerContactPerson = extractPotentialCustomerContactPerson(accessKey, loadOptions);
 	
 		if(isExtractPotentialCustomerEnabled(loadOptions)){
	 		extractPotentialCustomer(potentialCustomerContactPerson, loadOptions);
 		}
 
		
		if(isExtractPotentialCustomerContactListEnabled(loadOptions)){
	 		extractPotentialCustomerContactList(potentialCustomerContactPerson, loadOptions);
 		}	
 		
 		
 		if(isAnalyzePotentialCustomerContactListEnabled(loadOptions)){
	 		analyzePotentialCustomerContactList(potentialCustomerContactPerson, loadOptions);
 		}
 		
		
		return potentialCustomerContactPerson;
		
	}

	 

 	protected PotentialCustomerContactPerson extractPotentialCustomer(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options) throws Exception{

		if(potentialCustomerContactPerson.getPotentialCustomer() == null){
			return potentialCustomerContactPerson;
		}
		String potentialCustomerId = potentialCustomerContactPerson.getPotentialCustomer().getId();
		if( potentialCustomerId == null){
			return potentialCustomerContactPerson;
		}
		PotentialCustomer potentialCustomer = getPotentialCustomerDAO().load(potentialCustomerId,options);
		if(potentialCustomer != null){
			potentialCustomerContactPerson.setPotentialCustomer(potentialCustomer);
		}
		
 		
 		return potentialCustomerContactPerson;
 	}
 		
 
		
	protected void enhancePotentialCustomerContactList(SmartList<PotentialCustomerContact> potentialCustomerContactList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected PotentialCustomerContactPerson extractPotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
		
		
		if(potentialCustomerContactPerson == null){
			return null;
		}
		if(potentialCustomerContactPerson.getId() == null){
			return potentialCustomerContactPerson;
		}

		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = getPotentialCustomerContactDAO().findPotentialCustomerContactByContactTo(potentialCustomerContactPerson.getId(),options);
		if(potentialCustomerContactList != null){
			enhancePotentialCustomerContactList(potentialCustomerContactList,options);
			potentialCustomerContactPerson.setPotentialCustomerContactList(potentialCustomerContactList);
		}
		
		return potentialCustomerContactPerson;
	
	}	
	
	protected PotentialCustomerContactPerson analyzePotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
		
		
		if(potentialCustomerContactPerson == null){
			return null;
		}
		if(potentialCustomerContactPerson.getId() == null){
			return potentialCustomerContactPerson;
		}

		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();
		if(potentialCustomerContactList != null){
			getPotentialCustomerContactDAO().analyzePotentialCustomerContactByContactTo(potentialCustomerContactList, potentialCustomerContactPerson.getId(), options);
			
		}
		
		return potentialCustomerContactPerson;
	
	}	
	
		
		
  	
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){
 	
  		SmartList<PotentialCustomerContactPerson> resultList = queryWith(PotentialCustomerContactPersonTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options, getPotentialCustomerContactPersonMapper());
		// analyzePotentialCustomerContactPersonByPotentialCustomer(resultList, potentialCustomerId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId, int start, int count,Map<String,Object> options){
 		
 		SmartList<PotentialCustomerContactPerson> resultList =  queryWithRange(PotentialCustomerContactPersonTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options, getPotentialCustomerContactPersonMapper(), start, count);
 		//analyzePotentialCustomerContactPersonByPotentialCustomer(resultList, potentialCustomerId, options);
 		return resultList;
 		
 	}
 	public void analyzePotentialCustomerContactPersonByPotentialCustomer(SmartList<PotentialCustomerContactPerson> resultList, String potentialCustomerId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countPotentialCustomerContactPersonByPotentialCustomer(String potentialCustomerId,Map<String,Object> options){

 		return countWith(PotentialCustomerContactPersonTable.COLUMN_POTENTIAL_CUSTOMER, potentialCustomerId, options);
 	}
 	@Override
	public Map<String, Integer> countPotentialCustomerContactPersonByPotentialCustomerIds(String[] ids, Map<String, Object> options) {
		return countWithIds(PotentialCustomerContactPersonTable.COLUMN_POTENTIAL_CUSTOMER, ids, options);
	}
 	
 	
		
		
		

	

	protected PotentialCustomerContactPerson savePotentialCustomerContactPerson(PotentialCustomerContactPerson  potentialCustomerContactPerson){
		
		if(!potentialCustomerContactPerson.isChanged()){
			return potentialCustomerContactPerson;
		}
		
		
		String SQL=this.getSavePotentialCustomerContactPersonSQL(potentialCustomerContactPerson);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSavePotentialCustomerContactPersonParameters(potentialCustomerContactPerson);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		potentialCustomerContactPerson.incVersion();
		return potentialCustomerContactPerson;
	
	}
	public SmartList<PotentialCustomerContactPerson> savePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitPotentialCustomerContactPersonList(potentialCustomerContactPersonList);
		
		batchPotentialCustomerContactPersonCreate((List<PotentialCustomerContactPerson>)lists[CREATE_LIST_INDEX]);
		
		batchPotentialCustomerContactPersonUpdate((List<PotentialCustomerContactPerson>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList){
			if(potentialCustomerContactPerson.isChanged()){
				potentialCustomerContactPerson.incVersion();
			}
			
		
		}
		
		
		return potentialCustomerContactPersonList;
	}

	public SmartList<PotentialCustomerContactPerson> removePotentialCustomerContactPersonList(SmartList<PotentialCustomerContactPerson> potentialCustomerContactPersonList,Map<String,Object> options){
		
		
		super.removeList(potentialCustomerContactPersonList, options);
		
		return potentialCustomerContactPersonList;
		
		
	}
	
	protected List<Object[]> preparePotentialCustomerContactPersonBatchCreateArgs(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList ){
			Object [] parameters = preparePotentialCustomerContactPersonCreateParameters(potentialCustomerContactPerson);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> preparePotentialCustomerContactPersonBatchUpdateArgs(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(PotentialCustomerContactPerson potentialCustomerContactPerson:potentialCustomerContactPersonList ){
			if(!potentialCustomerContactPerson.isChanged()){
				continue;
			}
			Object [] parameters = preparePotentialCustomerContactPersonUpdateParameters(potentialCustomerContactPerson);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchPotentialCustomerContactPersonCreate(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		String SQL=getCreateSQL();
		List<Object[]> args=preparePotentialCustomerContactPersonBatchCreateArgs(potentialCustomerContactPersonList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchPotentialCustomerContactPersonUpdate(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		String SQL=getUpdateSQL();
		List<Object[]> args=preparePotentialCustomerContactPersonBatchUpdateArgs(potentialCustomerContactPersonList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitPotentialCustomerContactPersonList(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList){
		
		List<PotentialCustomerContactPerson> potentialCustomerContactPersonCreateList=new ArrayList<PotentialCustomerContactPerson>();
		List<PotentialCustomerContactPerson> potentialCustomerContactPersonUpdateList=new ArrayList<PotentialCustomerContactPerson>();
		
		for(PotentialCustomerContactPerson potentialCustomerContactPerson: potentialCustomerContactPersonList){
			if(isUpdateRequest(potentialCustomerContactPerson)){
				potentialCustomerContactPersonUpdateList.add( potentialCustomerContactPerson);
				continue;
			}
			potentialCustomerContactPersonCreateList.add(potentialCustomerContactPerson);
		}
		
		return new Object[]{potentialCustomerContactPersonCreateList,potentialCustomerContactPersonUpdateList};
	}
	
	protected boolean isUpdateRequest(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		return potentialCustomerContactPerson.getVersion() > 0;
 	}
 	protected String getSavePotentialCustomerContactPersonSQL(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		if(isUpdateRequest(potentialCustomerContactPerson)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSavePotentialCustomerContactPersonParameters(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		if(isUpdateRequest(potentialCustomerContactPerson) ){
 			return preparePotentialCustomerContactPersonUpdateParameters(potentialCustomerContactPerson);
 		}
 		return preparePotentialCustomerContactPersonCreateParameters(potentialCustomerContactPerson);
 	}
 	protected Object[] preparePotentialCustomerContactPersonUpdateParameters(PotentialCustomerContactPerson potentialCustomerContactPerson){
 		Object[] parameters = new Object[7];
 
 		
 		parameters[0] = potentialCustomerContactPerson.getName();
 		
 		
 		parameters[1] = potentialCustomerContactPerson.getMobile();
 		 	
 		if(potentialCustomerContactPerson.getPotentialCustomer() != null){
 			parameters[2] = potentialCustomerContactPerson.getPotentialCustomer().getId();
 		}
 
 		
 		parameters[3] = potentialCustomerContactPerson.getDescription();
 				
 		parameters[4] = potentialCustomerContactPerson.nextVersion();
 		parameters[5] = potentialCustomerContactPerson.getId();
 		parameters[6] = potentialCustomerContactPerson.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] preparePotentialCustomerContactPersonCreateParameters(PotentialCustomerContactPerson potentialCustomerContactPerson){
		Object[] parameters = new Object[5];
		String newPotentialCustomerContactPersonId=getNextId();
		potentialCustomerContactPerson.setId(newPotentialCustomerContactPersonId);
		parameters[0] =  potentialCustomerContactPerson.getId();
 
 		
 		parameters[1] = potentialCustomerContactPerson.getName();
 		
 		
 		parameters[2] = potentialCustomerContactPerson.getMobile();
 		 	
 		if(potentialCustomerContactPerson.getPotentialCustomer() != null){
 			parameters[3] = potentialCustomerContactPerson.getPotentialCustomer().getId();
 		
 		}
 		
 		
 		parameters[4] = potentialCustomerContactPerson.getDescription();
 				
 				
 		return parameters;
 	}
 	
	protected PotentialCustomerContactPerson saveInternalPotentialCustomerContactPerson(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
		
		savePotentialCustomerContactPerson(potentialCustomerContactPerson);
 	
 		if(isSavePotentialCustomerEnabled(options)){
	 		savePotentialCustomer(potentialCustomerContactPerson, options);
 		}
 
		
		if(isSavePotentialCustomerContactListEnabled(options)){
	 		savePotentialCustomerContactList(potentialCustomerContactPerson, options);
	 		//removePotentialCustomerContactList(potentialCustomerContactPerson, options);
	 		//Not delete the record
	 		
 		}		
		
		return potentialCustomerContactPerson;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected PotentialCustomerContactPerson savePotentialCustomer(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(potentialCustomerContactPerson.getPotentialCustomer() == null){
 			return potentialCustomerContactPerson;//do nothing when it is null
 		}
 		
 		getPotentialCustomerDAO().save(potentialCustomerContactPerson.getPotentialCustomer(),options);
 		return potentialCustomerContactPerson;
 		
 	}
 	
 	
 	
 	 
	
 

	
	public PotentialCustomerContactPerson planToRemovePotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, String potentialCustomerContactIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContactPerson.getId());
		key.put(PotentialCustomerContact.ID_PROPERTY, potentialCustomerContactIds);
		
		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return potentialCustomerContactPerson;
		}
		
		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){

			potentialCustomerContactItem.clearFromAll();
		}
		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();		
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return potentialCustomerContactPerson;	
	
	}


	//disconnect PotentialCustomerContactPerson with potential_customer in PotentialCustomerContact
	public PotentialCustomerContactPerson planToRemovePotentialCustomerContactListWithPotentialCustomer(PotentialCustomerContactPerson potentialCustomerContactPerson, String potentialCustomerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContactPerson.getId());
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
		
		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return potentialCustomerContactPerson;
		}
		
		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){
			potentialCustomerContactItem.clearPotentialCustomer();
			potentialCustomerContactItem.clearContactTo();
			
		}
		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();		
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return potentialCustomerContactPerson;
	}
	
	public int countPotentialCustomerContactListWithPotentialCustomer(String potentialCustomerContactPersonId, String potentialCustomerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContactPersonId);
		key.put(PotentialCustomerContact.POTENTIAL_CUSTOMER_PROPERTY, potentialCustomerId);
		
		int count = getPotentialCustomerContactDAO().countPotentialCustomerContactWithKey(key, options);
		return count;
	}
	
	//disconnect PotentialCustomerContactPerson with city_partner in PotentialCustomerContact
	public PotentialCustomerContactPerson planToRemovePotentialCustomerContactListWithCityPartner(PotentialCustomerContactPerson potentialCustomerContactPerson, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);
		
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContactPerson.getId());
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartnerId);
		
		SmartList<PotentialCustomerContact> externalPotentialCustomerContactList = getPotentialCustomerContactDAO().
				findPotentialCustomerContactWithKey(key, options);
		if(externalPotentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}
		if(externalPotentialCustomerContactList.isEmpty()){
			return potentialCustomerContactPerson;
		}
		
		for(PotentialCustomerContact potentialCustomerContactItem: externalPotentialCustomerContactList){
			potentialCustomerContactItem.clearCityPartner();
			potentialCustomerContactItem.clearContactTo();
			
		}
		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();		
		potentialCustomerContactList.addAllToRemoveList(externalPotentialCustomerContactList);
		return potentialCustomerContactPerson;
	}
	
	public int countPotentialCustomerContactListWithCityPartner(String potentialCustomerContactPersonId, String cityPartnerId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, potentialCustomerContactPersonId);
		key.put(PotentialCustomerContact.CITY_PARTNER_PROPERTY, cityPartnerId);
		
		int count = getPotentialCustomerContactDAO().countPotentialCustomerContactWithKey(key, options);
		return count;
	}
	

		
	protected PotentialCustomerContactPerson savePotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
		
		
		
		
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			//null list means nothing
			return potentialCustomerContactPerson;
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
		
		
		return potentialCustomerContactPerson;
	
	}
	
	protected PotentialCustomerContactPerson removePotentialCustomerContactList(PotentialCustomerContactPerson potentialCustomerContactPerson, Map<String,Object> options){
	
	
		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();
		if(potentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}	
	
		SmartList<PotentialCustomerContact> toRemovePotentialCustomerContactList = potentialCustomerContactList.getToRemoveList();
		
		if(toRemovePotentialCustomerContactList == null){
			return potentialCustomerContactPerson;
		}
		if(toRemovePotentialCustomerContactList.isEmpty()){
			return potentialCustomerContactPerson;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getPotentialCustomerContactDAO().removePotentialCustomerContactList(toRemovePotentialCustomerContactList,options);
		
		return potentialCustomerContactPerson;
	
	}
	
	

 	
 	
	
	
	
		

	public PotentialCustomerContactPerson present(PotentialCustomerContactPerson potentialCustomerContactPerson,Map<String, Object> options){
	
		presentPotentialCustomerContactList(potentialCustomerContactPerson,options);

		return potentialCustomerContactPerson;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected PotentialCustomerContactPerson presentPotentialCustomerContactList(
			PotentialCustomerContactPerson potentialCustomerContactPerson,
			Map<String, Object> options) {

		SmartList<PotentialCustomerContact> potentialCustomerContactList = potentialCustomerContactPerson.getPotentialCustomerContactList();		
				SmartList<PotentialCustomerContact> newList= presentSubList(potentialCustomerContactPerson.getId(),
				potentialCustomerContactList,
				options,
				getPotentialCustomerContactDAO()::countPotentialCustomerContactByContactTo,
				getPotentialCustomerContactDAO()::findPotentialCustomerContactByContactTo
				);

		
		potentialCustomerContactPerson.setPotentialCustomerContactList(newList);
		

		return potentialCustomerContactPerson;
	}			
		

	
    public SmartList<PotentialCustomerContactPerson> requestCandidatePotentialCustomerContactPersonForPotentialCustomerContact(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(PotentialCustomerContactPersonTable.COLUMN_NAME, PotentialCustomerContactPersonTable.COLUMN_POTENTIAL_CUSTOMER, filterKey, pageNo, pageSize, getPotentialCustomerContactPersonMapper());
    }
		

	protected String getTableName(){
		return PotentialCustomerContactPersonTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<PotentialCustomerContactPerson> potentialCustomerContactPersonList) {		
		this.enhanceListInternal(potentialCustomerContactPersonList, this.getPotentialCustomerContactPersonMapper());
	}
	
	
	// 需要一个加载引用我的对象的enhance方法:PotentialCustomerContact的contactTo的PotentialCustomerContactList
	public SmartList<PotentialCustomerContact> loadOurPotentialCustomerContactList(RetailscmUserContext userContext, List<PotentialCustomerContactPerson> us, Map<String,Object> options) throws Exception{
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(PotentialCustomerContact.CONTACT_TO_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<PotentialCustomerContact> loadedObjs = userContext.getDAOGroup().getPotentialCustomerContactDAO().findPotentialCustomerContactWithKey(key, options);
		Map<String, List<PotentialCustomerContact>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getContactTo().getId()));
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
		List<PotentialCustomerContactPerson> potentialCustomerContactPersonList = ownerEntity.collectRefsWithType(PotentialCustomerContactPerson.INTERNAL_TYPE);
		this.enhanceList(potentialCustomerContactPersonList);
		
	}
	
	@Override
	public SmartList<PotentialCustomerContactPerson> findPotentialCustomerContactPersonWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getPotentialCustomerContactPersonMapper());

	}
	@Override
	public int countPotentialCustomerContactPersonWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countPotentialCustomerContactPersonWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<PotentialCustomerContactPerson> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getPotentialCustomerContactPersonMapper());
	}
	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidatePotentialCustomerContactPerson executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidatePotentialCustomerContactPerson result = new CandidatePotentialCustomerContactPerson();
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


