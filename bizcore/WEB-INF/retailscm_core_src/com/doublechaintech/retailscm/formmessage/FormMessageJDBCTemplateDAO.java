
package com.doublechaintech.retailscm.formmessage;

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


import com.doublechaintech.retailscm.genericform.GenericForm;

import com.doublechaintech.retailscm.genericform.GenericFormDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class FormMessageJDBCTemplateDAO extends RetailscmNamingServiceDAO implements FormMessageDAO{
 
 	
 	private  GenericFormDAO  genericFormDAO;
 	public void setGenericFormDAO(GenericFormDAO genericFormDAO){
	 	this.genericFormDAO = genericFormDAO;
 	}
 	public GenericFormDAO getGenericFormDAO(){
	 	return this.genericFormDAO;
 	}


			
		

	
	/*
	protected FormMessage load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFormMessage(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FormMessage load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFormMessage(FormMessageTable.withId(id), options);
	}
	
	
	
	public FormMessage save(FormMessage formMessage,Map<String,Object> options){
		
		String methodName="save(FormMessage formMessage,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(formMessage, methodName, "formMessage");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFormMessage(formMessage,options);
	}
	public FormMessage clone(String formMessageId, Map<String,Object> options) throws Exception{
	
		return clone(FormMessageTable.withId(formMessageId),options);
	}
	
	protected FormMessage clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String formMessageId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FormMessage newFormMessage = loadInternalFormMessage(accessKey, options);
		newFormMessage.setVersion(0);
		
		

		
		saveInternalFormMessage(newFormMessage,options);
		
		return newFormMessage;
	}
	
	
	
	

	protected void throwIfHasException(String formMessageId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FormMessageVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FormMessageNotFoundException(
					"The " + this.getTableName() + "(" + formMessageId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String formMessageId, int version) throws Exception{
	
		String methodName="delete(String formMessageId, int version)";
		assertMethodArgumentNotNull(formMessageId, methodName, "formMessageId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{formMessageId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(formMessageId,version);
		}
		
	
	}
	
	
	
	
	

	public FormMessage disconnectFromAll(String formMessageId, int version) throws Exception{
	
		
		FormMessage formMessage = loadInternalFormMessage(FormMessageTable.withId(formMessageId), emptyOptions());
		formMessage.clearFromAll();
		this.saveFormMessage(formMessage);
		return formMessage;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FormMessageTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "form_message";
	}
	@Override
	protected String getBeanName() {
		
		return "formMessage";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FormMessageTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractFormEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FormMessageTokens.FORM);
 	}

 	protected boolean isSaveFormEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FormMessageTokens.FORM);
 	}
 	

 	
 
		

	

	protected FormMessageMapper getFormMessageMapper(){
		return new FormMessageMapper();
	}

	
	
	protected FormMessage extractFormMessage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FormMessage formMessage = loadSingleObject(accessKey, getFormMessageMapper());
			return formMessage;
		}catch(EmptyResultDataAccessException e){
			throw new FormMessageNotFoundException("FormMessage("+accessKey+") is not found!");
		}

	}

	
	

	protected FormMessage loadInternalFormMessage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FormMessage formMessage = extractFormMessage(accessKey, loadOptions);
 	
 		if(isExtractFormEnabled(loadOptions)){
	 		extractForm(formMessage, loadOptions);
 		}
 
		
		return formMessage;
		
	}

	 

 	protected FormMessage extractForm(FormMessage formMessage, Map<String,Object> options) throws Exception{

		if(formMessage.getForm() == null){
			return formMessage;
		}
		String formId = formMessage.getForm().getId();
		if( formId == null){
			return formMessage;
		}
		GenericForm form = getGenericFormDAO().load(formId,options);
		if(form != null){
			formMessage.setForm(form);
		}
		
 		
 		return formMessage;
 	}
 		
 
		
		
  	
 	public SmartList<FormMessage> findFormMessageByForm(String genericFormId,Map<String,Object> options){
 	
  		SmartList<FormMessage> resultList = queryWith(FormMessageTable.COLUMN_FORM, genericFormId, options, getFormMessageMapper());
		// analyzeFormMessageByForm(resultList, genericFormId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FormMessage> findFormMessageByForm(String genericFormId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FormMessage> resultList =  queryWithRange(FormMessageTable.COLUMN_FORM, genericFormId, options, getFormMessageMapper(), start, count);
 		//analyzeFormMessageByForm(resultList, genericFormId, options);
 		return resultList;
 		
 	}
 	public void analyzeFormMessageByForm(SmartList<FormMessage> resultList, String genericFormId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countFormMessageByForm(String genericFormId,Map<String,Object> options){

 		return countWith(FormMessageTable.COLUMN_FORM, genericFormId, options);
 	}
 	@Override
	public Map<String, Integer> countFormMessageByFormIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FormMessageTable.COLUMN_FORM, ids, options);
	}
 	
 	
		
		
		

	

	protected FormMessage saveFormMessage(FormMessage  formMessage){
		
		if(!formMessage.isChanged()){
			return formMessage;
		}
		
		
		String SQL=this.getSaveFormMessageSQL(formMessage);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFormMessageParameters(formMessage);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		formMessage.incVersion();
		return formMessage;
	
	}
	public SmartList<FormMessage> saveFormMessageList(SmartList<FormMessage> formMessageList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFormMessageList(formMessageList);
		
		batchFormMessageCreate((List<FormMessage>)lists[CREATE_LIST_INDEX]);
		
		batchFormMessageUpdate((List<FormMessage>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FormMessage formMessage:formMessageList){
			if(formMessage.isChanged()){
				formMessage.incVersion();
			}
			
		
		}
		
		
		return formMessageList;
	}

	public SmartList<FormMessage> removeFormMessageList(SmartList<FormMessage> formMessageList,Map<String,Object> options){
		
		
		super.removeList(formMessageList, options);
		
		return formMessageList;
		
		
	}
	
	protected List<Object[]> prepareFormMessageBatchCreateArgs(List<FormMessage> formMessageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormMessage formMessage:formMessageList ){
			Object [] parameters = prepareFormMessageCreateParameters(formMessage);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFormMessageBatchUpdateArgs(List<FormMessage> formMessageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormMessage formMessage:formMessageList ){
			if(!formMessage.isChanged()){
				continue;
			}
			Object [] parameters = prepareFormMessageUpdateParameters(formMessage);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFormMessageCreate(List<FormMessage> formMessageList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFormMessageBatchCreateArgs(formMessageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFormMessageUpdate(List<FormMessage> formMessageList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFormMessageBatchUpdateArgs(formMessageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFormMessageList(List<FormMessage> formMessageList){
		
		List<FormMessage> formMessageCreateList=new ArrayList<FormMessage>();
		List<FormMessage> formMessageUpdateList=new ArrayList<FormMessage>();
		
		for(FormMessage formMessage: formMessageList){
			if(isUpdateRequest(formMessage)){
				formMessageUpdateList.add( formMessage);
				continue;
			}
			formMessageCreateList.add(formMessage);
		}
		
		return new Object[]{formMessageCreateList,formMessageUpdateList};
	}
	
	protected boolean isUpdateRequest(FormMessage formMessage){
 		return formMessage.getVersion() > 0;
 	}
 	protected String getSaveFormMessageSQL(FormMessage formMessage){
 		if(isUpdateRequest(formMessage)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFormMessageParameters(FormMessage formMessage){
 		if(isUpdateRequest(formMessage) ){
 			return prepareFormMessageUpdateParameters(formMessage);
 		}
 		return prepareFormMessageCreateParameters(formMessage);
 	}
 	protected Object[] prepareFormMessageUpdateParameters(FormMessage formMessage){
 		Object[] parameters = new Object[6];
 
 		parameters[0] = formMessage.getTitle(); 	
 		if(formMessage.getForm() != null){
 			parameters[1] = formMessage.getForm().getId();
 		}
 
 		parameters[2] = formMessage.getLevel();		
 		parameters[3] = formMessage.nextVersion();
 		parameters[4] = formMessage.getId();
 		parameters[5] = formMessage.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFormMessageCreateParameters(FormMessage formMessage){
		Object[] parameters = new Object[4];
		String newFormMessageId=getNextId();
		formMessage.setId(newFormMessageId);
		parameters[0] =  formMessage.getId();
 
 		parameters[1] = formMessage.getTitle(); 	
 		if(formMessage.getForm() != null){
 			parameters[2] = formMessage.getForm().getId();
 		
 		}
 		
 		parameters[3] = formMessage.getLevel();		
 				
 		return parameters;
 	}
 	
	protected FormMessage saveInternalFormMessage(FormMessage formMessage, Map<String,Object> options){
		
		saveFormMessage(formMessage);
 	
 		if(isSaveFormEnabled(options)){
	 		saveForm(formMessage, options);
 		}
 
		
		return formMessage;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected FormMessage saveForm(FormMessage formMessage, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(formMessage.getForm() == null){
 			return formMessage;//do nothing when it is null
 		}
 		
 		getGenericFormDAO().save(formMessage.getForm(),options);
 		return formMessage;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public FormMessage present(FormMessage formMessage,Map<String, Object> options){
	

		return formMessage;
	
	}
		

	

	protected String getTableName(){
		return FormMessageTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FormMessage> formMessageList) {		
		this.enhanceListInternal(formMessageList, this.getFormMessageMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FormMessage> formMessageList = ownerEntity.collectRefsWithType(FormMessage.INTERNAL_TYPE);
		this.enhanceList(formMessageList);
		
	}
	
	@Override
	public SmartList<FormMessage> findFormMessageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFormMessageMapper());

	}
	@Override
	public int countFormMessageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFormMessageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FormMessage> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFormMessageMapper());
	}
}


