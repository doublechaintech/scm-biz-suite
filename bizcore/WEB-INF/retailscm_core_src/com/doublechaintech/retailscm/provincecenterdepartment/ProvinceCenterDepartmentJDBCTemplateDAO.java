
package com.doublechaintech.retailscm.provincecenterdepartment;

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


import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;

import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterDAO;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployeeDAO;



import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowCallbackHandler;
import java.util.stream.Stream;

public class ProvinceCenterDepartmentJDBCTemplateDAO extends RetailscmBaseDAOImpl implements ProvinceCenterDepartmentDAO{

	protected RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO;
	public void setRetailStoreProvinceCenterDAO(RetailStoreProvinceCenterDAO retailStoreProvinceCenterDAO){

 		if(retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("Do not try to set retailStoreProvinceCenterDAO to null.");
 		}
	 	this.retailStoreProvinceCenterDAO = retailStoreProvinceCenterDAO;
 	}
 	public RetailStoreProvinceCenterDAO getRetailStoreProvinceCenterDAO(){
 		if(this.retailStoreProvinceCenterDAO == null){
 			throw new IllegalStateException("The retailStoreProvinceCenterDAO is not configured yet, please config it some where.");
 		}

	 	return this.retailStoreProvinceCenterDAO;
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



	/*
	protected ProvinceCenterDepartment load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterDepartment(accessKey, options);
	}
	*/

	public SmartList<ProvinceCenterDepartment> loadAll() {
	    return this.loadAll(getProvinceCenterDepartmentMapper());
	}

  public Stream<ProvinceCenterDepartment> loadAllAsStream() {
      return this.loadAllAsStream(getProvinceCenterDepartmentMapper());
  }


	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}

	public ProvinceCenterDepartment load(String id,Map<String,Object> options) throws Exception{
		return loadInternalProvinceCenterDepartment(ProvinceCenterDepartmentTable.withId(id), options);
	}

	

	public ProvinceCenterDepartment save(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options){

		String methodName="save(ProvinceCenterDepartment provinceCenterDepartment,Map<String,Object> options)";

		assertMethodArgumentNotNull(provinceCenterDepartment, methodName, "provinceCenterDepartment");
		assertMethodArgumentNotNull(options, methodName, "options");

		return saveInternalProvinceCenterDepartment(provinceCenterDepartment,options);
	}
	public ProvinceCenterDepartment clone(String provinceCenterDepartmentId, Map<String,Object> options) throws Exception{

		return clone(ProvinceCenterDepartmentTable.withId(provinceCenterDepartmentId),options);
	}

	protected ProvinceCenterDepartment clone(AccessKey accessKey, Map<String,Object> options) throws Exception{

		String methodName="clone(String provinceCenterDepartmentId,Map<String,Object> options)";

		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");

		ProvinceCenterDepartment newProvinceCenterDepartment = loadInternalProvinceCenterDepartment(accessKey, options);
		newProvinceCenterDepartment.setVersion(0);
		
		

 		if(isSaveProvinceCenterEmployeeListEnabled(options)){
 			for(ProvinceCenterEmployee item: newProvinceCenterDepartment.getProvinceCenterEmployeeList()){
 				item.setVersion(0);
 			}
 		}
		


		saveInternalProvinceCenterDepartment(newProvinceCenterDepartment,options);

		return newProvinceCenterDepartment;
	}

	



	protected void throwIfHasException(String provinceCenterDepartmentId,int version,int count) throws Exception{
		if (count == 1) {
			throw new ProvinceCenterDepartmentVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new ProvinceCenterDepartmentNotFoundException(
					"The " + this.getTableName() + "(" + provinceCenterDepartmentId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}


	public void delete(String provinceCenterDepartmentId, int version) throws Exception{

		String methodName="delete(String provinceCenterDepartmentId, int version)";
		assertMethodArgumentNotNull(provinceCenterDepartmentId, methodName, "provinceCenterDepartmentId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");


		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{provinceCenterDepartmentId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(provinceCenterDepartmentId,version);
		}


	}






	public ProvinceCenterDepartment disconnectFromAll(String provinceCenterDepartmentId, int version) throws Exception{


		ProvinceCenterDepartment provinceCenterDepartment = loadInternalProvinceCenterDepartment(ProvinceCenterDepartmentTable.withId(provinceCenterDepartmentId), emptyOptions());
		provinceCenterDepartment.clearFromAll();
		this.saveProvinceCenterDepartment(provinceCenterDepartment);
		return provinceCenterDepartment;


	}

	@Override
	protected String[] getNormalColumnNames() {

		return ProvinceCenterDepartmentTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {

		return "province_center_department";
	}
	@Override
	protected String getBeanName() {

		return "provinceCenterDepartment";
	}

	



	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){

 		return ProvinceCenterDepartmentTokens.checkOptions(options, optionToCheck);

	}



 	protected boolean isExtractProvinceCenterEnabled(Map<String,Object> options){

	 	return checkOptions(options, ProvinceCenterDepartmentTokens.PROVINCECENTER);
 	}

 	protected boolean isSaveProvinceCenterEnabled(Map<String,Object> options){

 		return checkOptions(options, ProvinceCenterDepartmentTokens.PROVINCECENTER);
 	}



 
		

	protected boolean isExtractProvinceCenterEmployeeListEnabled(Map<String,Object> options){
 		return checkOptions(options,ProvinceCenterDepartmentTokens.PROVINCE_CENTER_EMPLOYEE_LIST);
 	}
 	protected boolean isAnalyzeProvinceCenterEmployeeListEnabled(Map<String,Object> options){
 		return ProvinceCenterDepartmentTokens.of(options).analyzeProvinceCenterEmployeeListEnabled();
 	}

	protected boolean isSaveProvinceCenterEmployeeListEnabled(Map<String,Object> options){
		return checkOptions(options, ProvinceCenterDepartmentTokens.PROVINCE_CENTER_EMPLOYEE_LIST);

 	}

		

	

	protected ProvinceCenterDepartmentMapper getProvinceCenterDepartmentMapper(){
		return new ProvinceCenterDepartmentMapper();
	}



	protected ProvinceCenterDepartment extractProvinceCenterDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			ProvinceCenterDepartment provinceCenterDepartment = loadSingleObject(accessKey, getProvinceCenterDepartmentMapper());
			return provinceCenterDepartment;
		}catch(EmptyResultDataAccessException e){
			throw new ProvinceCenterDepartmentNotFoundException("ProvinceCenterDepartment("+accessKey+") is not found!");
		}

	}




	protected ProvinceCenterDepartment loadInternalProvinceCenterDepartment(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{

		ProvinceCenterDepartment provinceCenterDepartment = extractProvinceCenterDepartment(accessKey, loadOptions);

 		if(isExtractProvinceCenterEnabled(loadOptions)){
	 		extractProvinceCenter(provinceCenterDepartment, loadOptions);
 		}
 
		
		if(isExtractProvinceCenterEmployeeListEnabled(loadOptions)){
	 		extractProvinceCenterEmployeeList(provinceCenterDepartment, loadOptions);
 		}

 		
 		if(isAnalyzeProvinceCenterEmployeeListEnabled(loadOptions)){
	 		analyzeProvinceCenterEmployeeList(provinceCenterDepartment, loadOptions);
 		}
 		
		
		return provinceCenterDepartment;

	}

	

 	protected ProvinceCenterDepartment extractProvinceCenter(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options) throws Exception{
  

		if(provinceCenterDepartment.getProvinceCenter() == null){
			return provinceCenterDepartment;
		}
		String provinceCenterId = provinceCenterDepartment.getProvinceCenter().getId();
		if( provinceCenterId == null){
			return provinceCenterDepartment;
		}
		RetailStoreProvinceCenter provinceCenter = getRetailStoreProvinceCenterDAO().load(provinceCenterId,options);
		if(provinceCenter != null){
			provinceCenterDepartment.setProvinceCenter(provinceCenter);
		}


 		return provinceCenterDepartment;
 	}

 
		
	protected void enhanceProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}

	protected ProvinceCenterDepartment extractProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
    

		if(provinceCenterDepartment == null){
			return null;
		}
		if(provinceCenterDepartment.getId() == null){
			return provinceCenterDepartment;
		}



		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeByDepartment(provinceCenterDepartment.getId(),options);
		if(provinceCenterEmployeeList != null){
			enhanceProvinceCenterEmployeeList(provinceCenterEmployeeList,options);
			provinceCenterDepartment.setProvinceCenterEmployeeList(provinceCenterEmployeeList);
		}

		return provinceCenterDepartment;
  
	}

	protected ProvinceCenterDepartment analyzeProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
     
		if(provinceCenterDepartment == null){
			return null;
		}
		if(provinceCenterDepartment.getId() == null){
			return provinceCenterDepartment;
		}



		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList != null){
			getProvinceCenterEmployeeDAO().analyzeProvinceCenterEmployeeByDepartment(provinceCenterEmployeeList, provinceCenterDepartment.getId(), options);

		}

		return provinceCenterDepartment;
    
	}

		

 
 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){

  		SmartList<ProvinceCenterDepartment> resultList = queryWith(ProvinceCenterDepartmentTable.COLUMN_PROVINCE_CENTER, retailStoreProvinceCenterId, options, getProvinceCenterDepartmentMapper());
		// analyzeProvinceCenterDepartmentByProvinceCenter(resultList, retailStoreProvinceCenterId, options);
		return resultList;
 	}
 	

 	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId, int start, int count,Map<String,Object> options){

 		SmartList<ProvinceCenterDepartment> resultList =  queryWithRange(ProvinceCenterDepartmentTable.COLUMN_PROVINCE_CENTER, retailStoreProvinceCenterId, options, getProvinceCenterDepartmentMapper(), start, count);
 		//analyzeProvinceCenterDepartmentByProvinceCenter(resultList, retailStoreProvinceCenterId, options);
 		return resultList;

 	}
 	public void analyzeProvinceCenterDepartmentByProvinceCenter(SmartList<ProvinceCenterDepartment> resultList, String retailStoreProvinceCenterId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}



 	}
 	@Override
 	public int countProvinceCenterDepartmentByProvinceCenter(String retailStoreProvinceCenterId,Map<String,Object> options){

 		return countWith(ProvinceCenterDepartmentTable.COLUMN_PROVINCE_CENTER, retailStoreProvinceCenterId, options);
 	}
 	@Override
	public Map<String, Integer> countProvinceCenterDepartmentByProvinceCenterIds(String[] ids, Map<String, Object> options) {
		return countWithIds(ProvinceCenterDepartmentTable.COLUMN_PROVINCE_CENTER, ids, options);
	}

 




	

	protected ProvinceCenterDepartment saveProvinceCenterDepartment(ProvinceCenterDepartment  provinceCenterDepartment){
    

		
		if(!provinceCenterDepartment.isChanged()){
			return provinceCenterDepartment;
		}
		

    Beans.dbUtil().cacheCleanUp(provinceCenterDepartment);
		String SQL=this.getSaveProvinceCenterDepartmentSQL(provinceCenterDepartment);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveProvinceCenterDepartmentParameters(provinceCenterDepartment);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}

		provinceCenterDepartment.incVersion();
		provinceCenterDepartment.afterSave();
		return provinceCenterDepartment;

	}
	public SmartList<ProvinceCenterDepartment> saveProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitProvinceCenterDepartmentList(provinceCenterDepartmentList);

		batchProvinceCenterDepartmentCreate((List<ProvinceCenterDepartment>)lists[CREATE_LIST_INDEX]);

		batchProvinceCenterDepartmentUpdate((List<ProvinceCenterDepartment>)lists[UPDATE_LIST_INDEX]);


		//update version after the list successfully saved to database;
		for(ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList){
			if(provinceCenterDepartment.isChanged()){
				provinceCenterDepartment.incVersion();
				provinceCenterDepartment.afterSave();
			}


		}


		return provinceCenterDepartmentList;
	}

	public SmartList<ProvinceCenterDepartment> removeProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList,Map<String,Object> options){


		super.removeList(provinceCenterDepartmentList, options);

		return provinceCenterDepartmentList;


	}

	protected List<Object[]> prepareProvinceCenterDepartmentBatchCreateArgs(List<ProvinceCenterDepartment> provinceCenterDepartmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList ){
			Object [] parameters = prepareProvinceCenterDepartmentCreateParameters(provinceCenterDepartment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected List<Object[]> prepareProvinceCenterDepartmentBatchUpdateArgs(List<ProvinceCenterDepartment> provinceCenterDepartmentList){

		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList ){
			if(!provinceCenterDepartment.isChanged()){
				continue;
			}
			Object [] parameters = prepareProvinceCenterDepartmentUpdateParameters(provinceCenterDepartment);
			parametersList.add(parameters);

		}
		return parametersList;

	}
	protected void batchProvinceCenterDepartmentCreate(List<ProvinceCenterDepartment> provinceCenterDepartmentList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareProvinceCenterDepartmentBatchCreateArgs(provinceCenterDepartmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);

	}


	protected void batchProvinceCenterDepartmentUpdate(List<ProvinceCenterDepartment> provinceCenterDepartmentList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareProvinceCenterDepartmentBatchUpdateArgs(provinceCenterDepartmentList);

		int affectedNumbers[] = batchUpdate(SQL, args);



	}



	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;

	protected Object[] splitProvinceCenterDepartmentList(List<ProvinceCenterDepartment> provinceCenterDepartmentList){

		List<ProvinceCenterDepartment> provinceCenterDepartmentCreateList=new ArrayList<ProvinceCenterDepartment>();
		List<ProvinceCenterDepartment> provinceCenterDepartmentUpdateList=new ArrayList<ProvinceCenterDepartment>();

		for(ProvinceCenterDepartment provinceCenterDepartment: provinceCenterDepartmentList){
			if(isUpdateRequest(provinceCenterDepartment)){
				provinceCenterDepartmentUpdateList.add( provinceCenterDepartment);
				continue;
			}
			provinceCenterDepartmentCreateList.add(provinceCenterDepartment);
		}

		return new Object[]{provinceCenterDepartmentCreateList,provinceCenterDepartmentUpdateList};
	}

	protected boolean isUpdateRequest(ProvinceCenterDepartment provinceCenterDepartment){
 		return provinceCenterDepartment.getVersion() > 0;
 	}
 	protected String getSaveProvinceCenterDepartmentSQL(ProvinceCenterDepartment provinceCenterDepartment){
 		if(isUpdateRequest(provinceCenterDepartment)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}

 	protected Object[] getSaveProvinceCenterDepartmentParameters(ProvinceCenterDepartment provinceCenterDepartment){
 		if(isUpdateRequest(provinceCenterDepartment) ){
 			return prepareProvinceCenterDepartmentUpdateParameters(provinceCenterDepartment);
 		}
 		return prepareProvinceCenterDepartmentCreateParameters(provinceCenterDepartment);
 	}
 	protected Object[] prepareProvinceCenterDepartmentUpdateParameters(ProvinceCenterDepartment provinceCenterDepartment){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = provinceCenterDepartment.getName();
 		
 		parameters[1] = provinceCenterDepartment.getFounded();
 		
 		if(provinceCenterDepartment.getProvinceCenter() != null){
 			parameters[2] = provinceCenterDepartment.getProvinceCenter().getId();
 		}
    
 		parameters[3] = provinceCenterDepartment.getManager();
 		
 		parameters[4] = provinceCenterDepartment.nextVersion();
 		parameters[5] = provinceCenterDepartment.getId();
 		parameters[6] = provinceCenterDepartment.getVersion();

 		return parameters;
 	}
 	protected Object[] prepareProvinceCenterDepartmentCreateParameters(ProvinceCenterDepartment provinceCenterDepartment){
		Object[] parameters = new Object[5];
        if(provinceCenterDepartment.getId() == null){
          String newProvinceCenterDepartmentId=getNextId();
          provinceCenterDepartment.setId(newProvinceCenterDepartmentId);
        }
		parameters[0] =  provinceCenterDepartment.getId();
 
 		parameters[1] = provinceCenterDepartment.getName();
 		
 		parameters[2] = provinceCenterDepartment.getFounded();
 		
 		if(provinceCenterDepartment.getProvinceCenter() != null){
 			parameters[3] = provinceCenterDepartment.getProvinceCenter().getId();
 		}
 		
 		parameters[4] = provinceCenterDepartment.getManager();
 		

 		return parameters;
 	}

	protected ProvinceCenterDepartment saveInternalProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){

 		if(isSaveProvinceCenterEnabled(options)){
	 		saveProvinceCenter(provinceCenterDepartment, options);
 		}
 
   saveProvinceCenterDepartment(provinceCenterDepartment);
		
		if(isSaveProvinceCenterEmployeeListEnabled(options)){
	 		saveProvinceCenterEmployeeList(provinceCenterDepartment, options);
	 		//removeProvinceCenterEmployeeList(provinceCenterDepartment, options);
	 		//Not delete the record

 		}
		
		return provinceCenterDepartment;

	}



	//======================================================================================
	

 	protected ProvinceCenterDepartment saveProvinceCenter(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
 	
 		//Call inject DAO to execute this method
 		if(provinceCenterDepartment.getProvinceCenter() == null){
 			return provinceCenterDepartment;//do nothing when it is null
 		}

 		getRetailStoreProvinceCenterDAO().save(provinceCenterDepartment.getProvinceCenter(),options);
 		return provinceCenterDepartment;

 	}
 

	
	public ProvinceCenterDepartment planToRemoveProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, String provinceCenterEmployeeIds[], Map<String,Object> options)throws Exception{

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, provinceCenterDepartment.getId());
		key.put(ProvinceCenterEmployee.ID_PROPERTY, provinceCenterEmployeeIds);

		SmartList<ProvinceCenterEmployee> externalProvinceCenterEmployeeList = getProvinceCenterEmployeeDAO().
				findProvinceCenterEmployeeWithKey(key, options);
		if(externalProvinceCenterEmployeeList == null){
			return provinceCenterDepartment;
		}
		if(externalProvinceCenterEmployeeList.isEmpty()){
			return provinceCenterDepartment;
		}

		for(ProvinceCenterEmployee provinceCenterEmployeeItem: externalProvinceCenterEmployeeList){

			provinceCenterEmployeeItem.clearFromAll();
		}


		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		provinceCenterEmployeeList.addAllToRemoveList(externalProvinceCenterEmployeeList);
		return provinceCenterDepartment;

	}


	//disconnect ProvinceCenterDepartment with province_center in ProvinceCenterEmployee
	public ProvinceCenterDepartment planToRemoveProvinceCenterEmployeeListWithProvinceCenter(ProvinceCenterDepartment provinceCenterDepartment, String provinceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, provinceCenterDepartment.getId());
		key.put(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, provinceCenterId);

		SmartList<ProvinceCenterEmployee> externalProvinceCenterEmployeeList = getProvinceCenterEmployeeDAO().
				findProvinceCenterEmployeeWithKey(key, options);
		if(externalProvinceCenterEmployeeList == null){
			return provinceCenterDepartment;
		}
		if(externalProvinceCenterEmployeeList.isEmpty()){
			return provinceCenterDepartment;
		}

		for(ProvinceCenterEmployee provinceCenterEmployeeItem: externalProvinceCenterEmployeeList){
			provinceCenterEmployeeItem.clearProvinceCenter();
			provinceCenterEmployeeItem.clearDepartment();

		}


		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		provinceCenterEmployeeList.addAllToRemoveList(externalProvinceCenterEmployeeList);
		return provinceCenterDepartment;
	}

	public int countProvinceCenterEmployeeListWithProvinceCenter(String provinceCenterDepartmentId, String provinceCenterId, Map<String,Object> options)throws Exception{
				//SmartList<ThreadLike> toRemoveThreadLikeList = threadLikeList.getToRemoveList();
		//the list will not be null here, empty, maybe
		//getThreadLikeDAO().removeThreadLikeList(toRemoveThreadLikeList,options);

		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, provinceCenterDepartmentId);
		key.put(ProvinceCenterEmployee.PROVINCE_CENTER_PROPERTY, provinceCenterId);

		int count = getProvinceCenterEmployeeDAO().countProvinceCenterEmployeeWithKey(key, options);
		return count;
	}
	

		
	protected ProvinceCenterDepartment saveProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){
    



		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			//null list means nothing
			return provinceCenterDepartment;
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


		return provinceCenterDepartment;

	}

	protected ProvinceCenterDepartment removeProvinceCenterEmployeeList(ProvinceCenterDepartment provinceCenterDepartment, Map<String,Object> options){


		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
		if(provinceCenterEmployeeList == null){
			return provinceCenterDepartment;
		}

		SmartList<ProvinceCenterEmployee> toRemoveProvinceCenterEmployeeList = provinceCenterEmployeeList.getToRemoveList();

		if(toRemoveProvinceCenterEmployeeList == null){
			return provinceCenterDepartment;
		}
		if(toRemoveProvinceCenterEmployeeList.isEmpty()){
			return provinceCenterDepartment;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list

		getProvinceCenterEmployeeDAO().removeProvinceCenterEmployeeList(toRemoveProvinceCenterEmployeeList,options);

		return provinceCenterDepartment;

	}








		

	public ProvinceCenterDepartment present(ProvinceCenterDepartment provinceCenterDepartment,Map<String, Object> options){

		presentProvinceCenterEmployeeList(provinceCenterDepartment,options);

		return provinceCenterDepartment;

	}
		
	//Using java8 feature to reduce the code significantly
 	protected ProvinceCenterDepartment presentProvinceCenterEmployeeList(
			ProvinceCenterDepartment provinceCenterDepartment,
			Map<String, Object> options) {
    
		SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList = provinceCenterDepartment.getProvinceCenterEmployeeList();
				SmartList<ProvinceCenterEmployee> newList= presentSubList(provinceCenterDepartment.getId(),
				provinceCenterEmployeeList,
				options,
				getProvinceCenterEmployeeDAO()::countProvinceCenterEmployeeByDepartment,
				getProvinceCenterEmployeeDAO()::findProvinceCenterEmployeeByDepartment
				);


		provinceCenterDepartment.setProvinceCenterEmployeeList(newList);


		return provinceCenterDepartment;
	}
		

	
    public SmartList<ProvinceCenterDepartment> requestCandidateProvinceCenterDepartmentForProvinceCenterEmployee(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(ProvinceCenterDepartmentTable.COLUMN_NAME, ProvinceCenterDepartmentTable.COLUMN_PROVINCE_CENTER, filterKey, pageNo, pageSize, getProvinceCenterDepartmentMapper());
    }
		

	protected String getTableName(){
		return ProvinceCenterDepartmentTable.TABLE_NAME;
	}



	public void enhanceList(List<ProvinceCenterDepartment> provinceCenterDepartmentList) {
		this.enhanceListInternal(provinceCenterDepartmentList, this.getProvinceCenterDepartmentMapper());
	}

	
	// 需要一个加载引用我的对象的enhance方法:ProvinceCenterEmployee的department的ProvinceCenterEmployeeList
	public SmartList<ProvinceCenterEmployee> loadOurProvinceCenterEmployeeList(RetailscmUserContext userContext, List<ProvinceCenterDepartment> us, Map<String,Object> options) throws Exception{
		
		if (us == null || us.isEmpty()){
			return new SmartList<>();
		}
		Set<String> ids = us.stream().map(it->it.getId()).collect(Collectors.toSet());
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(ProvinceCenterEmployee.DEPARTMENT_PROPERTY, ids.toArray(new String[ids.size()]));
		SmartList<ProvinceCenterEmployee> loadedObjs = userContext.getDAOGroup().getProvinceCenterEmployeeDAO().findProvinceCenterEmployeeWithKey(key, options);
		Map<String, List<ProvinceCenterEmployee>> loadedMap = loadedObjs.stream().collect(Collectors.groupingBy(it->it.getDepartment().getId()));
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
	

	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<ProvinceCenterDepartment> provinceCenterDepartmentList = ownerEntity.collectRefsWithType(ProvinceCenterDepartment.INTERNAL_TYPE);
		this.enhanceList(provinceCenterDepartmentList);

	}

	@Override
	public SmartList<ProvinceCenterDepartment> findProvinceCenterDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return queryWith(key, options, getProvinceCenterDepartmentMapper());

	}
	@Override
	public int countProvinceCenterDepartmentWithKey(MultipleAccessKey key,
			Map<String, Object> options) {

  		return countWith(key, options);

	}
	public Map<String, Integer> countProvinceCenterDepartmentWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {

  		return countWithGroup(groupKey, filterKey, options);

	}

	@Override
	public SmartList<ProvinceCenterDepartment> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getProvinceCenterDepartmentMapper());
	}

  @Override
  public List<String> queryIdList(String sql, Object... parameters) {
    return this.getJdbcTemplate().queryForList(sql, parameters, String.class);
  }
  @Override
  public Stream<ProvinceCenterDepartment> queryStream(String sql, Object... parameters) {
    return this.queryForStream(sql, parameters, this.getProvinceCenterDepartmentMapper());
  }

	@Override
	public int count(String sql, Object... parameters) {
	    return queryInt(sql, parameters);
	}
	@Override
	public CandidateProvinceCenterDepartment executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception {

		CandidateProvinceCenterDepartment result = new CandidateProvinceCenterDepartment();
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

	

  @Override
  public List<ProvinceCenterDepartment> search(ProvinceCenterDepartmentRequest pRequest) {
    return searchInternal(pRequest);
  }

  @Override
  protected ProvinceCenterDepartmentMapper mapper() {
    return getProvinceCenterDepartmentMapper();
  }
}


