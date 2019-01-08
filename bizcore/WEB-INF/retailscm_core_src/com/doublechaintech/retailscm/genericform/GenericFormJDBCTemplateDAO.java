
package com.doublechaintech.retailscm.genericform;

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


import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;
import com.doublechaintech.retailscm.formfield.FormField;

import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessageDAO;
import com.doublechaintech.retailscm.formaction.FormActionDAO;
import com.doublechaintech.retailscm.formfield.FormFieldDAO;
import com.doublechaintech.retailscm.formmessage.FormMessageDAO;



import org.springframework.dao.EmptyResultDataAccessException;

public class GenericFormJDBCTemplateDAO extends RetailscmNamingServiceDAO implements GenericFormDAO{


			
		
	
  	private  FormMessageDAO  formMessageDAO;
 	public void setFormMessageDAO(FormMessageDAO pFormMessageDAO){
 	
 		if(pFormMessageDAO == null){
 			throw new IllegalStateException("Do not try to set formMessageDAO to null.");
 		}
	 	this.formMessageDAO = pFormMessageDAO;
 	}
 	public FormMessageDAO getFormMessageDAO(){
 		if(this.formMessageDAO == null){
 			throw new IllegalStateException("The formMessageDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.formMessageDAO;
 	}	
 	
			
		
	
  	private  FormFieldMessageDAO  formFieldMessageDAO;
 	public void setFormFieldMessageDAO(FormFieldMessageDAO pFormFieldMessageDAO){
 	
 		if(pFormFieldMessageDAO == null){
 			throw new IllegalStateException("Do not try to set formFieldMessageDAO to null.");
 		}
	 	this.formFieldMessageDAO = pFormFieldMessageDAO;
 	}
 	public FormFieldMessageDAO getFormFieldMessageDAO(){
 		if(this.formFieldMessageDAO == null){
 			throw new IllegalStateException("The formFieldMessageDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.formFieldMessageDAO;
 	}	
 	
			
		
	
  	private  FormFieldDAO  formFieldDAO;
 	public void setFormFieldDAO(FormFieldDAO pFormFieldDAO){
 	
 		if(pFormFieldDAO == null){
 			throw new IllegalStateException("Do not try to set formFieldDAO to null.");
 		}
	 	this.formFieldDAO = pFormFieldDAO;
 	}
 	public FormFieldDAO getFormFieldDAO(){
 		if(this.formFieldDAO == null){
 			throw new IllegalStateException("The formFieldDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.formFieldDAO;
 	}	
 	
			
		
	
  	private  FormActionDAO  formActionDAO;
 	public void setFormActionDAO(FormActionDAO pFormActionDAO){
 	
 		if(pFormActionDAO == null){
 			throw new IllegalStateException("Do not try to set formActionDAO to null.");
 		}
	 	this.formActionDAO = pFormActionDAO;
 	}
 	public FormActionDAO getFormActionDAO(){
 		if(this.formActionDAO == null){
 			throw new IllegalStateException("The formActionDAO is not configured yet, please config it some where.");
 		}
 		
	 	return this.formActionDAO;
 	}	
 	
			
		

	
	/*
	protected GenericForm load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalGenericForm(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public GenericForm load(String id,Map<String,Object> options) throws Exception{
		return loadInternalGenericForm(GenericFormTable.withId(id), options);
	}
	
	
	
	public GenericForm save(GenericForm genericForm,Map<String,Object> options){
		
		String methodName="save(GenericForm genericForm,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(genericForm, methodName, "genericForm");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalGenericForm(genericForm,options);
	}
	public GenericForm clone(String genericFormId, Map<String,Object> options) throws Exception{
	
		return clone(GenericFormTable.withId(genericFormId),options);
	}
	
	protected GenericForm clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String genericFormId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		GenericForm newGenericForm = loadInternalGenericForm(accessKey, options);
		newGenericForm.setVersion(0);
		
		
 		
 		if(isSaveFormMessageListEnabled(options)){
 			for(FormMessage item: newGenericForm.getFormMessageList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveFormFieldMessageListEnabled(options)){
 			for(FormFieldMessage item: newGenericForm.getFormFieldMessageList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveFormFieldListEnabled(options)){
 			for(FormField item: newGenericForm.getFormFieldList()){
 				item.setVersion(0);
 			}
 		}
		
 		
 		if(isSaveFormActionListEnabled(options)){
 			for(FormAction item: newGenericForm.getFormActionList()){
 				item.setVersion(0);
 			}
 		}
		

		
		saveInternalGenericForm(newGenericForm,options);
		
		return newGenericForm;
	}
	
	
	
	

	protected void throwIfHasException(String genericFormId,int version,int count) throws Exception{
		if (count == 1) {
			throw new GenericFormVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new GenericFormNotFoundException(
					"The " + this.getTableName() + "(" + genericFormId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String genericFormId, int version) throws Exception{
	
		String methodName="delete(String genericFormId, int version)";
		assertMethodArgumentNotNull(genericFormId, methodName, "genericFormId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{genericFormId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(genericFormId,version);
		}
		
	
	}
	
	
	
	
	

	public GenericForm disconnectFromAll(String genericFormId, int version) throws Exception{
	
		
		GenericForm genericForm = loadInternalGenericForm(GenericFormTable.withId(genericFormId), emptyOptions());
		genericForm.clearFromAll();
		this.saveGenericForm(genericForm);
		return genericForm;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return GenericFormTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "generic_form";
	}
	@Override
	protected String getBeanName() {
		
		return "genericForm";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return GenericFormTokens.checkOptions(options, optionToCheck);
	
	}


		
	
	protected boolean isExtractFormMessageListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_MESSAGE_LIST);
 	}
 	protected boolean isAnalyzeFormMessageListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_MESSAGE_LIST+".analyze");
 	}

	protected boolean isSaveFormMessageListEnabled(Map<String,Object> options){
		return checkOptions(options, GenericFormTokens.FORM_MESSAGE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractFormFieldMessageListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_FIELD_MESSAGE_LIST);
 	}
 	protected boolean isAnalyzeFormFieldMessageListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_FIELD_MESSAGE_LIST+".analyze");
 	}

	protected boolean isSaveFormFieldMessageListEnabled(Map<String,Object> options){
		return checkOptions(options, GenericFormTokens.FORM_FIELD_MESSAGE_LIST);
		
 	}
 	
		
	
	protected boolean isExtractFormFieldListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_FIELD_LIST);
 	}
 	protected boolean isAnalyzeFormFieldListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_FIELD_LIST+".analyze");
 	}

	protected boolean isSaveFormFieldListEnabled(Map<String,Object> options){
		return checkOptions(options, GenericFormTokens.FORM_FIELD_LIST);
		
 	}
 	
		
	
	protected boolean isExtractFormActionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_ACTION_LIST);
 	}
 	protected boolean isAnalyzeFormActionListEnabled(Map<String,Object> options){		
 		return checkOptions(options,GenericFormTokens.FORM_ACTION_LIST+".analyze");
 	}

	protected boolean isSaveFormActionListEnabled(Map<String,Object> options){
		return checkOptions(options, GenericFormTokens.FORM_ACTION_LIST);
		
 	}
 	
		

	

	protected GenericFormMapper getGenericFormMapper(){
		return new GenericFormMapper();
	}

	
	
	protected GenericForm extractGenericForm(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			GenericForm genericForm = loadSingleObject(accessKey, getGenericFormMapper());
			return genericForm;
		}catch(EmptyResultDataAccessException e){
			throw new GenericFormNotFoundException("GenericForm("+accessKey+") is not found!");
		}

	}

	
	

	protected GenericForm loadInternalGenericForm(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		GenericForm genericForm = extractGenericForm(accessKey, loadOptions);

		
		if(isExtractFormMessageListEnabled(loadOptions)){
	 		extractFormMessageList(genericForm, loadOptions);
 		}	
 		if(isAnalyzeFormMessageListEnabled(loadOptions)){
	 		// analyzeFormMessageList(genericForm, loadOptions);
 		}
 		
		
		if(isExtractFormFieldMessageListEnabled(loadOptions)){
	 		extractFormFieldMessageList(genericForm, loadOptions);
 		}	
 		if(isAnalyzeFormFieldMessageListEnabled(loadOptions)){
	 		// analyzeFormFieldMessageList(genericForm, loadOptions);
 		}
 		
		
		if(isExtractFormFieldListEnabled(loadOptions)){
	 		extractFormFieldList(genericForm, loadOptions);
 		}	
 		if(isAnalyzeFormFieldListEnabled(loadOptions)){
	 		// analyzeFormFieldList(genericForm, loadOptions);
 		}
 		
		
		if(isExtractFormActionListEnabled(loadOptions)){
	 		extractFormActionList(genericForm, loadOptions);
 		}	
 		if(isAnalyzeFormActionListEnabled(loadOptions)){
	 		// analyzeFormActionList(genericForm, loadOptions);
 		}
 		
		
		return genericForm;
		
	}

	
		
	protected void enhanceFormMessageList(SmartList<FormMessage> formMessageList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected GenericForm extractFormMessageList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormMessage> formMessageList = getFormMessageDAO().findFormMessageByForm(genericForm.getId(),options);
		if(formMessageList != null){
			enhanceFormMessageList(formMessageList,options);
			genericForm.setFormMessageList(formMessageList);
		}
		
		return genericForm;
	
	}	
	
	protected GenericForm analyzeFormMessageList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormMessage> formMessageList = genericForm.getFormMessageList();
		if(formMessageList != null){
			getFormMessageDAO().analyzeFormMessageByForm(formMessageList, genericForm.getId(), options);
			
		}
		
		return genericForm;
	
	}	
	
		
	protected void enhanceFormFieldMessageList(SmartList<FormFieldMessage> formFieldMessageList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected GenericForm extractFormFieldMessageList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormFieldMessage> formFieldMessageList = getFormFieldMessageDAO().findFormFieldMessageByForm(genericForm.getId(),options);
		if(formFieldMessageList != null){
			enhanceFormFieldMessageList(formFieldMessageList,options);
			genericForm.setFormFieldMessageList(formFieldMessageList);
		}
		
		return genericForm;
	
	}	
	
	protected GenericForm analyzeFormFieldMessageList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormFieldMessage> formFieldMessageList = genericForm.getFormFieldMessageList();
		if(formFieldMessageList != null){
			getFormFieldMessageDAO().analyzeFormFieldMessageByForm(formFieldMessageList, genericForm.getId(), options);
			
		}
		
		return genericForm;
	
	}	
	
		
	protected void enhanceFormFieldList(SmartList<FormField> formFieldList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected GenericForm extractFormFieldList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormField> formFieldList = getFormFieldDAO().findFormFieldByForm(genericForm.getId(),options);
		if(formFieldList != null){
			enhanceFormFieldList(formFieldList,options);
			genericForm.setFormFieldList(formFieldList);
		}
		
		return genericForm;
	
	}	
	
	protected GenericForm analyzeFormFieldList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormField> formFieldList = genericForm.getFormFieldList();
		if(formFieldList != null){
			getFormFieldDAO().analyzeFormFieldByForm(formFieldList, genericForm.getId(), options);
			
		}
		
		return genericForm;
	
	}	
	
		
	protected void enhanceFormActionList(SmartList<FormAction> formActionList,Map<String,Object> options){
		//extract multiple list from difference sources
		//Trying to use a single SQL to extract all data from database and do the work in java side, java is easier to scale to N ndoes;
	}
	
	protected GenericForm extractFormActionList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormAction> formActionList = getFormActionDAO().findFormActionByForm(genericForm.getId(),options);
		if(formActionList != null){
			enhanceFormActionList(formActionList,options);
			genericForm.setFormActionList(formActionList);
		}
		
		return genericForm;
	
	}	
	
	protected GenericForm analyzeFormActionList(GenericForm genericForm, Map<String,Object> options){
		
		
		if(genericForm == null){
			return null;
		}
		if(genericForm.getId() == null){
			return genericForm;
		}

		
		
		SmartList<FormAction> formActionList = genericForm.getFormActionList();
		if(formActionList != null){
			getFormActionDAO().analyzeFormActionByForm(formActionList, genericForm.getId(), options);
			
		}
		
		return genericForm;
	
	}	
	
		
		
 	
		
		
		

	

	protected GenericForm saveGenericForm(GenericForm  genericForm){
		
		if(!genericForm.isChanged()){
			return genericForm;
		}
		
		
		String SQL=this.getSaveGenericFormSQL(genericForm);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveGenericFormParameters(genericForm);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		genericForm.incVersion();
		return genericForm;
	
	}
	public SmartList<GenericForm> saveGenericFormList(SmartList<GenericForm> genericFormList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitGenericFormList(genericFormList);
		
		batchGenericFormCreate((List<GenericForm>)lists[CREATE_LIST_INDEX]);
		
		batchGenericFormUpdate((List<GenericForm>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(GenericForm genericForm:genericFormList){
			if(genericForm.isChanged()){
				genericForm.incVersion();
			}
			
		
		}
		
		
		return genericFormList;
	}

	public SmartList<GenericForm> removeGenericFormList(SmartList<GenericForm> genericFormList,Map<String,Object> options){
		
		
		super.removeList(genericFormList, options);
		
		return genericFormList;
		
		
	}
	
	protected List<Object[]> prepareGenericFormBatchCreateArgs(List<GenericForm> genericFormList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GenericForm genericForm:genericFormList ){
			Object [] parameters = prepareGenericFormCreateParameters(genericForm);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareGenericFormBatchUpdateArgs(List<GenericForm> genericFormList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(GenericForm genericForm:genericFormList ){
			if(!genericForm.isChanged()){
				continue;
			}
			Object [] parameters = prepareGenericFormUpdateParameters(genericForm);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchGenericFormCreate(List<GenericForm> genericFormList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareGenericFormBatchCreateArgs(genericFormList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchGenericFormUpdate(List<GenericForm> genericFormList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareGenericFormBatchUpdateArgs(genericFormList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitGenericFormList(List<GenericForm> genericFormList){
		
		List<GenericForm> genericFormCreateList=new ArrayList<GenericForm>();
		List<GenericForm> genericFormUpdateList=new ArrayList<GenericForm>();
		
		for(GenericForm genericForm: genericFormList){
			if(isUpdateRequest(genericForm)){
				genericFormUpdateList.add( genericForm);
				continue;
			}
			genericFormCreateList.add(genericForm);
		}
		
		return new Object[]{genericFormCreateList,genericFormUpdateList};
	}
	
	protected boolean isUpdateRequest(GenericForm genericForm){
 		return genericForm.getVersion() > 0;
 	}
 	protected String getSaveGenericFormSQL(GenericForm genericForm){
 		if(isUpdateRequest(genericForm)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveGenericFormParameters(GenericForm genericForm){
 		if(isUpdateRequest(genericForm) ){
 			return prepareGenericFormUpdateParameters(genericForm);
 		}
 		return prepareGenericFormCreateParameters(genericForm);
 	}
 	protected Object[] prepareGenericFormUpdateParameters(GenericForm genericForm){
 		Object[] parameters = new Object[5];
 
 		parameters[0] = genericForm.getTitle();
 		parameters[1] = genericForm.getDescription();		
 		parameters[2] = genericForm.nextVersion();
 		parameters[3] = genericForm.getId();
 		parameters[4] = genericForm.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareGenericFormCreateParameters(GenericForm genericForm){
		Object[] parameters = new Object[3];
		String newGenericFormId=getNextId();
		genericForm.setId(newGenericFormId);
		parameters[0] =  genericForm.getId();
 
 		parameters[1] = genericForm.getTitle();
 		parameters[2] = genericForm.getDescription();		
 				
 		return parameters;
 	}
 	
	protected GenericForm saveInternalGenericForm(GenericForm genericForm, Map<String,Object> options){
		
		saveGenericForm(genericForm);

		
		if(isSaveFormMessageListEnabled(options)){
	 		saveFormMessageList(genericForm, options);
	 		//removeFormMessageList(genericForm, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveFormFieldMessageListEnabled(options)){
	 		saveFormFieldMessageList(genericForm, options);
	 		//removeFormFieldMessageList(genericForm, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveFormFieldListEnabled(options)){
	 		saveFormFieldList(genericForm, options);
	 		//removeFormFieldList(genericForm, options);
	 		//Not delete the record
	 		
 		}		
		
		if(isSaveFormActionListEnabled(options)){
	 		saveFormActionList(genericForm, options);
	 		//removeFormActionList(genericForm, options);
	 		//Not delete the record
	 		
 		}		
		
		return genericForm;
		
	}
	
	
	
	//======================================================================================
	

	
	public GenericForm planToRemoveFormMessageList(GenericForm genericForm, String formMessageIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FormMessage.FORM_PROPERTY, genericForm.getId());
		key.put(FormMessage.ID_PROPERTY, formMessageIds);
		
		SmartList<FormMessage> externalFormMessageList = getFormMessageDAO().
				findFormMessageWithKey(key, options);
		if(externalFormMessageList == null){
			return genericForm;
		}
		if(externalFormMessageList.isEmpty()){
			return genericForm;
		}
		
		for(FormMessage formMessage: externalFormMessageList){

			formMessage.clearFromAll();
		}
		
		
		SmartList<FormMessage> formMessageList = genericForm.getFormMessageList();		
		formMessageList.addAllToRemoveList(externalFormMessageList);
		return genericForm;	
	
	}


	public GenericForm planToRemoveFormFieldMessageList(GenericForm genericForm, String formFieldMessageIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FormFieldMessage.FORM_PROPERTY, genericForm.getId());
		key.put(FormFieldMessage.ID_PROPERTY, formFieldMessageIds);
		
		SmartList<FormFieldMessage> externalFormFieldMessageList = getFormFieldMessageDAO().
				findFormFieldMessageWithKey(key, options);
		if(externalFormFieldMessageList == null){
			return genericForm;
		}
		if(externalFormFieldMessageList.isEmpty()){
			return genericForm;
		}
		
		for(FormFieldMessage formFieldMessage: externalFormFieldMessageList){

			formFieldMessage.clearFromAll();
		}
		
		
		SmartList<FormFieldMessage> formFieldMessageList = genericForm.getFormFieldMessageList();		
		formFieldMessageList.addAllToRemoveList(externalFormFieldMessageList);
		return genericForm;	
	
	}


	public GenericForm planToRemoveFormFieldList(GenericForm genericForm, String formFieldIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FormField.FORM_PROPERTY, genericForm.getId());
		key.put(FormField.ID_PROPERTY, formFieldIds);
		
		SmartList<FormField> externalFormFieldList = getFormFieldDAO().
				findFormFieldWithKey(key, options);
		if(externalFormFieldList == null){
			return genericForm;
		}
		if(externalFormFieldList.isEmpty()){
			return genericForm;
		}
		
		for(FormField formField: externalFormFieldList){

			formField.clearFromAll();
		}
		
		
		SmartList<FormField> formFieldList = genericForm.getFormFieldList();		
		formFieldList.addAllToRemoveList(externalFormFieldList);
		return genericForm;	
	
	}


	public GenericForm planToRemoveFormActionList(GenericForm genericForm, String formActionIds[], Map<String,Object> options)throws Exception{
	
		MultipleAccessKey key = new MultipleAccessKey();
		key.put(FormAction.FORM_PROPERTY, genericForm.getId());
		key.put(FormAction.ID_PROPERTY, formActionIds);
		
		SmartList<FormAction> externalFormActionList = getFormActionDAO().
				findFormActionWithKey(key, options);
		if(externalFormActionList == null){
			return genericForm;
		}
		if(externalFormActionList.isEmpty()){
			return genericForm;
		}
		
		for(FormAction formAction: externalFormActionList){

			formAction.clearFromAll();
		}
		
		
		SmartList<FormAction> formActionList = genericForm.getFormActionList();		
		formActionList.addAllToRemoveList(externalFormActionList);
		return genericForm;	
	
	}



		
	protected GenericForm saveFormMessageList(GenericForm genericForm, Map<String,Object> options){
		
		
		
		
		SmartList<FormMessage> formMessageList = genericForm.getFormMessageList();
		if(formMessageList == null){
			//null list means nothing
			return genericForm;
		}
		SmartList<FormMessage> mergedUpdateFormMessageList = new SmartList<FormMessage>();
		
		
		mergedUpdateFormMessageList.addAll(formMessageList); 
		if(formMessageList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateFormMessageList.addAll(formMessageList.getToRemoveList());
			formMessageList.removeAll(formMessageList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getFormMessageDAO().saveFormMessageList(mergedUpdateFormMessageList,options);
		
		if(formMessageList.getToRemoveList() != null){
			formMessageList.removeAll(formMessageList.getToRemoveList());
		}
		
		
		return genericForm;
	
	}
	
	protected GenericForm removeFormMessageList(GenericForm genericForm, Map<String,Object> options){
	
	
		SmartList<FormMessage> formMessageList = genericForm.getFormMessageList();
		if(formMessageList == null){
			return genericForm;
		}	
	
		SmartList<FormMessage> toRemoveFormMessageList = formMessageList.getToRemoveList();
		
		if(toRemoveFormMessageList == null){
			return genericForm;
		}
		if(toRemoveFormMessageList.isEmpty()){
			return genericForm;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFormMessageDAO().removeFormMessageList(toRemoveFormMessageList,options);
		
		return genericForm;
	
	}
	
	

 	
 	
	
	
	
		
	protected GenericForm saveFormFieldMessageList(GenericForm genericForm, Map<String,Object> options){
		
		
		
		
		SmartList<FormFieldMessage> formFieldMessageList = genericForm.getFormFieldMessageList();
		if(formFieldMessageList == null){
			//null list means nothing
			return genericForm;
		}
		SmartList<FormFieldMessage> mergedUpdateFormFieldMessageList = new SmartList<FormFieldMessage>();
		
		
		mergedUpdateFormFieldMessageList.addAll(formFieldMessageList); 
		if(formFieldMessageList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateFormFieldMessageList.addAll(formFieldMessageList.getToRemoveList());
			formFieldMessageList.removeAll(formFieldMessageList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getFormFieldMessageDAO().saveFormFieldMessageList(mergedUpdateFormFieldMessageList,options);
		
		if(formFieldMessageList.getToRemoveList() != null){
			formFieldMessageList.removeAll(formFieldMessageList.getToRemoveList());
		}
		
		
		return genericForm;
	
	}
	
	protected GenericForm removeFormFieldMessageList(GenericForm genericForm, Map<String,Object> options){
	
	
		SmartList<FormFieldMessage> formFieldMessageList = genericForm.getFormFieldMessageList();
		if(formFieldMessageList == null){
			return genericForm;
		}	
	
		SmartList<FormFieldMessage> toRemoveFormFieldMessageList = formFieldMessageList.getToRemoveList();
		
		if(toRemoveFormFieldMessageList == null){
			return genericForm;
		}
		if(toRemoveFormFieldMessageList.isEmpty()){
			return genericForm;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFormFieldMessageDAO().removeFormFieldMessageList(toRemoveFormFieldMessageList,options);
		
		return genericForm;
	
	}
	
	

 	
 	
	
	
	
		
	protected GenericForm saveFormFieldList(GenericForm genericForm, Map<String,Object> options){
		
		
		
		
		SmartList<FormField> formFieldList = genericForm.getFormFieldList();
		if(formFieldList == null){
			//null list means nothing
			return genericForm;
		}
		SmartList<FormField> mergedUpdateFormFieldList = new SmartList<FormField>();
		
		
		mergedUpdateFormFieldList.addAll(formFieldList); 
		if(formFieldList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateFormFieldList.addAll(formFieldList.getToRemoveList());
			formFieldList.removeAll(formFieldList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getFormFieldDAO().saveFormFieldList(mergedUpdateFormFieldList,options);
		
		if(formFieldList.getToRemoveList() != null){
			formFieldList.removeAll(formFieldList.getToRemoveList());
		}
		
		
		return genericForm;
	
	}
	
	protected GenericForm removeFormFieldList(GenericForm genericForm, Map<String,Object> options){
	
	
		SmartList<FormField> formFieldList = genericForm.getFormFieldList();
		if(formFieldList == null){
			return genericForm;
		}	
	
		SmartList<FormField> toRemoveFormFieldList = formFieldList.getToRemoveList();
		
		if(toRemoveFormFieldList == null){
			return genericForm;
		}
		if(toRemoveFormFieldList.isEmpty()){
			return genericForm;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFormFieldDAO().removeFormFieldList(toRemoveFormFieldList,options);
		
		return genericForm;
	
	}
	
	

 	
 	
	
	
	
		
	protected GenericForm saveFormActionList(GenericForm genericForm, Map<String,Object> options){
		
		
		
		
		SmartList<FormAction> formActionList = genericForm.getFormActionList();
		if(formActionList == null){
			//null list means nothing
			return genericForm;
		}
		SmartList<FormAction> mergedUpdateFormActionList = new SmartList<FormAction>();
		
		
		mergedUpdateFormActionList.addAll(formActionList); 
		if(formActionList.getToRemoveList() != null){
			//ensures the toRemoveList is not null
			mergedUpdateFormActionList.addAll(formActionList.getToRemoveList());
			formActionList.removeAll(formActionList.getToRemoveList());
			//OK for now, need fix later
		}

		//adding new size can improve performance
	
		getFormActionDAO().saveFormActionList(mergedUpdateFormActionList,options);
		
		if(formActionList.getToRemoveList() != null){
			formActionList.removeAll(formActionList.getToRemoveList());
		}
		
		
		return genericForm;
	
	}
	
	protected GenericForm removeFormActionList(GenericForm genericForm, Map<String,Object> options){
	
	
		SmartList<FormAction> formActionList = genericForm.getFormActionList();
		if(formActionList == null){
			return genericForm;
		}	
	
		SmartList<FormAction> toRemoveFormActionList = formActionList.getToRemoveList();
		
		if(toRemoveFormActionList == null){
			return genericForm;
		}
		if(toRemoveFormActionList.isEmpty()){
			return genericForm;// Does this mean delete all from the parent object?
		}
		//Call DAO to remove the list
		
		getFormActionDAO().removeFormActionList(toRemoveFormActionList,options);
		
		return genericForm;
	
	}
	
	

 	
 	
	
	
	
		

	public GenericForm present(GenericForm genericForm,Map<String, Object> options){
	
		presentFormMessageList(genericForm,options);
		presentFormFieldMessageList(genericForm,options);
		presentFormFieldList(genericForm,options);
		presentFormActionList(genericForm,options);

		return genericForm;
	
	}
		
	//Using java8 feature to reduce the code significantly
 	protected GenericForm presentFormMessageList(
			GenericForm genericForm,
			Map<String, Object> options) {

		SmartList<FormMessage> formMessageList = genericForm.getFormMessageList();		
				SmartList<FormMessage> newList= presentSubList(genericForm.getId(),
				formMessageList,
				options,
				getFormMessageDAO()::countFormMessageByForm,
				getFormMessageDAO()::findFormMessageByForm
				);

		
		genericForm.setFormMessageList(newList);
		

		return genericForm;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected GenericForm presentFormFieldMessageList(
			GenericForm genericForm,
			Map<String, Object> options) {

		SmartList<FormFieldMessage> formFieldMessageList = genericForm.getFormFieldMessageList();		
				SmartList<FormFieldMessage> newList= presentSubList(genericForm.getId(),
				formFieldMessageList,
				options,
				getFormFieldMessageDAO()::countFormFieldMessageByForm,
				getFormFieldMessageDAO()::findFormFieldMessageByForm
				);

		
		genericForm.setFormFieldMessageList(newList);
		

		return genericForm;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected GenericForm presentFormFieldList(
			GenericForm genericForm,
			Map<String, Object> options) {

		SmartList<FormField> formFieldList = genericForm.getFormFieldList();		
				SmartList<FormField> newList= presentSubList(genericForm.getId(),
				formFieldList,
				options,
				getFormFieldDAO()::countFormFieldByForm,
				getFormFieldDAO()::findFormFieldByForm
				);

		
		genericForm.setFormFieldList(newList);
		

		return genericForm;
	}			
		
	//Using java8 feature to reduce the code significantly
 	protected GenericForm presentFormActionList(
			GenericForm genericForm,
			Map<String, Object> options) {

		SmartList<FormAction> formActionList = genericForm.getFormActionList();		
				SmartList<FormAction> newList= presentSubList(genericForm.getId(),
				formActionList,
				options,
				getFormActionDAO()::countFormActionByForm,
				getFormActionDAO()::findFormActionByForm
				);

		
		genericForm.setFormActionList(newList);
		

		return genericForm;
	}			
		

	
    public SmartList<GenericForm> requestCandidateGenericFormForFormMessage(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GenericFormTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getGenericFormMapper());
    }
		
    public SmartList<GenericForm> requestCandidateGenericFormForFormFieldMessage(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GenericFormTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getGenericFormMapper());
    }
		
    public SmartList<GenericForm> requestCandidateGenericFormForFormField(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GenericFormTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getGenericFormMapper());
    }
		
    public SmartList<GenericForm> requestCandidateGenericFormForFormAction(RetailscmUserContext userContext, String ownerClass, String id, String filterKey, int pageNo, int pageSize) throws Exception {
        // NOTE: by default, ignore owner info, just return all by filter key.
		// You need override this method if you have different candidate-logic
		return findAllCandidateByFilter(GenericFormTable.COLUMN_TITLE, filterKey, pageNo, pageSize, getGenericFormMapper());
    }
		

	protected String getTableName(){
		return GenericFormTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<GenericForm> genericFormList) {		
		this.enhanceListInternal(genericFormList, this.getGenericFormMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<GenericForm> genericFormList = ownerEntity.collectRefsWithType(GenericForm.INTERNAL_TYPE);
		this.enhanceList(genericFormList);
		
	}
	
	@Override
	public SmartList<GenericForm> findGenericFormWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getGenericFormMapper());

	}
	@Override
	public int countGenericFormWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countGenericFormWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<GenericForm> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getGenericFormMapper());
	}
}


