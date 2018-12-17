
package com.doublechaintech.retailscm.formfieldmessage;

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

public class FormFieldMessageJDBCTemplateDAO extends RetailscmNamingServiceDAO implements FormFieldMessageDAO{
 
 	
 	private  GenericFormDAO  genericFormDAO;
 	public void setGenericFormDAO(GenericFormDAO genericFormDAO){
	 	this.genericFormDAO = genericFormDAO;
 	}
 	public GenericFormDAO getGenericFormDAO(){
	 	return this.genericFormDAO;
 	}


			
		

	
	/*
	protected FormFieldMessage load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFormFieldMessage(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FormFieldMessage load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFormFieldMessage(FormFieldMessageTable.withId(id), options);
	}
	
	
	
	public FormFieldMessage save(FormFieldMessage formFieldMessage,Map<String,Object> options){
		
		String methodName="save(FormFieldMessage formFieldMessage,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(formFieldMessage, methodName, "formFieldMessage");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFormFieldMessage(formFieldMessage,options);
	}
	public FormFieldMessage clone(String formFieldMessageId, Map<String,Object> options) throws Exception{
	
		return clone(FormFieldMessageTable.withId(formFieldMessageId),options);
	}
	
	protected FormFieldMessage clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String formFieldMessageId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FormFieldMessage newFormFieldMessage = loadInternalFormFieldMessage(accessKey, options);
		newFormFieldMessage.setVersion(0);
		
		

		
		saveInternalFormFieldMessage(newFormFieldMessage,options);
		
		return newFormFieldMessage;
	}
	
	
	
	

	protected void throwIfHasException(String formFieldMessageId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FormFieldMessageVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FormFieldMessageNotFoundException(
					"The " + this.getTableName() + "(" + formFieldMessageId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String formFieldMessageId, int version) throws Exception{
	
		String methodName="delete(String formFieldMessageId, int version)";
		assertMethodArgumentNotNull(formFieldMessageId, methodName, "formFieldMessageId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{formFieldMessageId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(formFieldMessageId,version);
		}
		
	
	}
	
	
	
	
	

	public FormFieldMessage disconnectFromAll(String formFieldMessageId, int version) throws Exception{
	
		
		FormFieldMessage formFieldMessage = loadInternalFormFieldMessage(FormFieldMessageTable.withId(formFieldMessageId), emptyOptions());
		formFieldMessage.clearFromAll();
		this.saveFormFieldMessage(formFieldMessage);
		return formFieldMessage;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FormFieldMessageTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "form_field_message";
	}
	@Override
	protected String getBeanName() {
		
		return "formFieldMessage";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FormFieldMessageTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractFormEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FormFieldMessageTokens.FORM);
 	}

 	protected boolean isSaveFormEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FormFieldMessageTokens.FORM);
 	}
 	

 	
 
		

	

	protected FormFieldMessageMapper getFormFieldMessageMapper(){
		return new FormFieldMessageMapper();
	}

	
	
	protected FormFieldMessage extractFormFieldMessage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FormFieldMessage formFieldMessage = loadSingleObject(accessKey, getFormFieldMessageMapper());
			return formFieldMessage;
		}catch(EmptyResultDataAccessException e){
			throw new FormFieldMessageNotFoundException("FormFieldMessage("+accessKey+") is not found!");
		}

	}

	
	

	protected FormFieldMessage loadInternalFormFieldMessage(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FormFieldMessage formFieldMessage = extractFormFieldMessage(accessKey, loadOptions);
 	
 		if(isExtractFormEnabled(loadOptions)){
	 		extractForm(formFieldMessage, loadOptions);
 		}
 
		
		return formFieldMessage;
		
	}



	
	
	 

 	protected FormFieldMessage extractForm(FormFieldMessage formFieldMessage, Map<String,Object> options) throws Exception{

		if(formFieldMessage.getForm() == null){
			return formFieldMessage;
		}
		String formId = formFieldMessage.getForm().getId();
		if( formId == null){
			return formFieldMessage;
		}
		GenericForm form = getGenericFormDAO().load(formId,options);
		if(form != null){
			formFieldMessage.setForm(form);
		}
		
 		
 		return formFieldMessage;
 	}
 		
 
		
		
  	
 	public SmartList<FormFieldMessage> findFormFieldMessageByForm(String genericFormId,Map<String,Object> options){
 	
  		SmartList<FormFieldMessage> resultList = queryWith(FormFieldMessageTable.COLUMN_FORM, genericFormId, options, getFormFieldMessageMapper());
		analyzeFormFieldMessageByForm(resultList, genericFormId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FormFieldMessage> findFormFieldMessageByForm(String genericFormId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FormFieldMessage> resultList =  queryWithRange(FormFieldMessageTable.COLUMN_FORM, genericFormId, options, getFormFieldMessageMapper(), start, count);
 		analyzeFormFieldMessageByForm(resultList, genericFormId, options);
 		return resultList;
 		
 	}
 	public void analyzeFormFieldMessageByForm(SmartList<FormFieldMessage> resultList, String genericFormId, Map<String,Object> options){
	

 	
 		
 	}
 	@Override
 	public int countFormFieldMessageByForm(String genericFormId,Map<String,Object> options){

 		return countWith(FormFieldMessageTable.COLUMN_FORM, genericFormId, options);
 	}
 	@Override
	public Map<String, Integer> countFormFieldMessageByFormIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FormFieldMessageTable.COLUMN_FORM, ids, options);
	}
 	
 	
		
		
		

	

	protected FormFieldMessage saveFormFieldMessage(FormFieldMessage  formFieldMessage){
		
		if(!formFieldMessage.isChanged()){
			return formFieldMessage;
		}
		
		
		String SQL=this.getSaveFormFieldMessageSQL(formFieldMessage);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFormFieldMessageParameters(formFieldMessage);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		formFieldMessage.incVersion();
		return formFieldMessage;
	
	}
	public SmartList<FormFieldMessage> saveFormFieldMessageList(SmartList<FormFieldMessage> formFieldMessageList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFormFieldMessageList(formFieldMessageList);
		
		batchFormFieldMessageCreate((List<FormFieldMessage>)lists[CREATE_LIST_INDEX]);
		
		batchFormFieldMessageUpdate((List<FormFieldMessage>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FormFieldMessage formFieldMessage:formFieldMessageList){
			if(formFieldMessage.isChanged()){
				formFieldMessage.incVersion();
			}
			
		
		}
		
		
		return formFieldMessageList;
	}

	public SmartList<FormFieldMessage> removeFormFieldMessageList(SmartList<FormFieldMessage> formFieldMessageList,Map<String,Object> options){
		
		
		super.removeList(formFieldMessageList, options);
		
		return formFieldMessageList;
		
		
	}
	
	protected List<Object[]> prepareFormFieldMessageBatchCreateArgs(List<FormFieldMessage> formFieldMessageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormFieldMessage formFieldMessage:formFieldMessageList ){
			Object [] parameters = prepareFormFieldMessageCreateParameters(formFieldMessage);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFormFieldMessageBatchUpdateArgs(List<FormFieldMessage> formFieldMessageList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormFieldMessage formFieldMessage:formFieldMessageList ){
			if(!formFieldMessage.isChanged()){
				continue;
			}
			Object [] parameters = prepareFormFieldMessageUpdateParameters(formFieldMessage);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFormFieldMessageCreate(List<FormFieldMessage> formFieldMessageList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFormFieldMessageBatchCreateArgs(formFieldMessageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFormFieldMessageUpdate(List<FormFieldMessage> formFieldMessageList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFormFieldMessageBatchUpdateArgs(formFieldMessageList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFormFieldMessageList(List<FormFieldMessage> formFieldMessageList){
		
		List<FormFieldMessage> formFieldMessageCreateList=new ArrayList<FormFieldMessage>();
		List<FormFieldMessage> formFieldMessageUpdateList=new ArrayList<FormFieldMessage>();
		
		for(FormFieldMessage formFieldMessage: formFieldMessageList){
			if(isUpdateRequest(formFieldMessage)){
				formFieldMessageUpdateList.add( formFieldMessage);
				continue;
			}
			formFieldMessageCreateList.add(formFieldMessage);
		}
		
		return new Object[]{formFieldMessageCreateList,formFieldMessageUpdateList};
	}
	
	protected boolean isUpdateRequest(FormFieldMessage formFieldMessage){
 		return formFieldMessage.getVersion() > 0;
 	}
 	protected String getSaveFormFieldMessageSQL(FormFieldMessage formFieldMessage){
 		if(isUpdateRequest(formFieldMessage)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFormFieldMessageParameters(FormFieldMessage formFieldMessage){
 		if(isUpdateRequest(formFieldMessage) ){
 			return prepareFormFieldMessageUpdateParameters(formFieldMessage);
 		}
 		return prepareFormFieldMessageCreateParameters(formFieldMessage);
 	}
 	protected Object[] prepareFormFieldMessageUpdateParameters(FormFieldMessage formFieldMessage){
 		Object[] parameters = new Object[7];
 
 		parameters[0] = formFieldMessage.getTitle();
 		parameters[1] = formFieldMessage.getParameterName(); 	
 		if(formFieldMessage.getForm() != null){
 			parameters[2] = formFieldMessage.getForm().getId();
 		}
 
 		parameters[3] = formFieldMessage.getLevel();		
 		parameters[4] = formFieldMessage.nextVersion();
 		parameters[5] = formFieldMessage.getId();
 		parameters[6] = formFieldMessage.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFormFieldMessageCreateParameters(FormFieldMessage formFieldMessage){
		Object[] parameters = new Object[5];
		String newFormFieldMessageId=getNextId();
		formFieldMessage.setId(newFormFieldMessageId);
		parameters[0] =  formFieldMessage.getId();
 
 		parameters[1] = formFieldMessage.getTitle();
 		parameters[2] = formFieldMessage.getParameterName(); 	
 		if(formFieldMessage.getForm() != null){
 			parameters[3] = formFieldMessage.getForm().getId();
 		
 		}
 		
 		parameters[4] = formFieldMessage.getLevel();		
 				
 		return parameters;
 	}
 	
	protected FormFieldMessage saveInternalFormFieldMessage(FormFieldMessage formFieldMessage, Map<String,Object> options){
		
		saveFormFieldMessage(formFieldMessage);
 	
 		if(isSaveFormEnabled(options)){
	 		saveForm(formFieldMessage, options);
 		}
 
		
		return formFieldMessage;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected FormFieldMessage saveForm(FormFieldMessage formFieldMessage, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(formFieldMessage.getForm() == null){
 			return formFieldMessage;//do nothing when it is null
 		}
 		
 		getGenericFormDAO().save(formFieldMessage.getForm(),options);
 		return formFieldMessage;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public FormFieldMessage present(FormFieldMessage formFieldMessage,Map<String, Object> options){
	

		return formFieldMessage;
	
	}
		

	

	protected String getTableName(){
		return FormFieldMessageTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FormFieldMessage> formFieldMessageList) {		
		this.enhanceListInternal(formFieldMessageList, this.getFormFieldMessageMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FormFieldMessage> formFieldMessageList = ownerEntity.collectRefsWithType(FormFieldMessage.INTERNAL_TYPE);
		this.enhanceList(formFieldMessageList);
		
	}
	
	@Override
	public SmartList<FormFieldMessage> findFormFieldMessageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFormFieldMessageMapper());

	}
	@Override
	public int countFormFieldMessageWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFormFieldMessageWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FormFieldMessage> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFormFieldMessageMapper());
	}
}


