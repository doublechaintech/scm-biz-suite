
package com.doublechaintech.retailscm.formaction;

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

public class FormActionJDBCTemplateDAO extends RetailscmNamingServiceDAO implements FormActionDAO{
 
 	
 	private  GenericFormDAO  genericFormDAO;
 	public void setGenericFormDAO(GenericFormDAO genericFormDAO){
	 	this.genericFormDAO = genericFormDAO;
 	}
 	public GenericFormDAO getGenericFormDAO(){
	 	return this.genericFormDAO;
 	}


			
		

	
	/*
	protected FormAction load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFormAction(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FormAction load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFormAction(FormActionTable.withId(id), options);
	}
	
	
	
	public FormAction save(FormAction formAction,Map<String,Object> options){
		
		String methodName="save(FormAction formAction,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(formAction, methodName, "formAction");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFormAction(formAction,options);
	}
	public FormAction clone(String formActionId, Map<String,Object> options) throws Exception{
	
		return clone(FormActionTable.withId(formActionId),options);
	}
	
	protected FormAction clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String formActionId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FormAction newFormAction = loadInternalFormAction(accessKey, options);
		newFormAction.setVersion(0);
		
		

		
		saveInternalFormAction(newFormAction,options);
		
		return newFormAction;
	}
	
	
	
	

	protected void throwIfHasException(String formActionId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FormActionVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FormActionNotFoundException(
					"The " + this.getTableName() + "(" + formActionId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String formActionId, int version) throws Exception{
	
		String methodName="delete(String formActionId, int version)";
		assertMethodArgumentNotNull(formActionId, methodName, "formActionId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{formActionId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(formActionId,version);
		}
		
	
	}
	
	
	
	
	

	public FormAction disconnectFromAll(String formActionId, int version) throws Exception{
	
		
		FormAction formAction = loadInternalFormAction(FormActionTable.withId(formActionId), emptyOptions());
		formAction.clearFromAll();
		this.saveFormAction(formAction);
		return formAction;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FormActionTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "form_action";
	}
	@Override
	protected String getBeanName() {
		
		return "formAction";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FormActionTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractFormEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FormActionTokens.FORM);
 	}

 	protected boolean isSaveFormEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FormActionTokens.FORM);
 	}
 	

 	
 
		

	

	protected FormActionMapper getFormActionMapper(){
		return new FormActionMapper();
	}

	
	
	protected FormAction extractFormAction(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FormAction formAction = loadSingleObject(accessKey, getFormActionMapper());
			return formAction;
		}catch(EmptyResultDataAccessException e){
			throw new FormActionNotFoundException("FormAction("+accessKey+") is not found!");
		}

	}

	
	

	protected FormAction loadInternalFormAction(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FormAction formAction = extractFormAction(accessKey, loadOptions);
 	
 		if(isExtractFormEnabled(loadOptions)){
	 		extractForm(formAction, loadOptions);
 		}
 
		
		return formAction;
		
	}



	
	
	 

 	protected FormAction extractForm(FormAction formAction, Map<String,Object> options) throws Exception{

		if(formAction.getForm() == null){
			return formAction;
		}
		String formId = formAction.getForm().getId();
		if( formId == null){
			return formAction;
		}
		GenericForm form = getGenericFormDAO().load(formId,options);
		if(form != null){
			formAction.setForm(form);
		}
		
 		
 		return formAction;
 	}
 		
 
		
		
  	
 	public SmartList<FormAction> findFormActionByForm(String genericFormId,Map<String,Object> options){
 	
  		SmartList<FormAction> resultList = queryWith(FormActionTable.COLUMN_FORM, genericFormId, options, getFormActionMapper());
		analyzeFormActionByForm(resultList, genericFormId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FormAction> findFormActionByForm(String genericFormId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FormAction> resultList =  queryWithRange(FormActionTable.COLUMN_FORM, genericFormId, options, getFormActionMapper(), start, count);
 		analyzeFormActionByForm(resultList, genericFormId, options);
 		return resultList;
 		
 	}
 	public void analyzeFormActionByForm(SmartList<FormAction> resultList, String genericFormId, Map<String,Object> options){
	

 	
 		
 	}
 	@Override
 	public int countFormActionByForm(String genericFormId,Map<String,Object> options){

 		return countWith(FormActionTable.COLUMN_FORM, genericFormId, options);
 	}
 	@Override
	public Map<String, Integer> countFormActionByFormIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FormActionTable.COLUMN_FORM, ids, options);
	}
 	
 	
		
		
		

	

	protected FormAction saveFormAction(FormAction  formAction){
		
		if(!formAction.isChanged()){
			return formAction;
		}
		
		
		String SQL=this.getSaveFormActionSQL(formAction);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFormActionParameters(formAction);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		formAction.incVersion();
		return formAction;
	
	}
	public SmartList<FormAction> saveFormActionList(SmartList<FormAction> formActionList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFormActionList(formActionList);
		
		batchFormActionCreate((List<FormAction>)lists[CREATE_LIST_INDEX]);
		
		batchFormActionUpdate((List<FormAction>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FormAction formAction:formActionList){
			if(formAction.isChanged()){
				formAction.incVersion();
			}
			
		
		}
		
		
		return formActionList;
	}

	public SmartList<FormAction> removeFormActionList(SmartList<FormAction> formActionList,Map<String,Object> options){
		
		
		super.removeList(formActionList, options);
		
		return formActionList;
		
		
	}
	
	protected List<Object[]> prepareFormActionBatchCreateArgs(List<FormAction> formActionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormAction formAction:formActionList ){
			Object [] parameters = prepareFormActionCreateParameters(formAction);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFormActionBatchUpdateArgs(List<FormAction> formActionList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormAction formAction:formActionList ){
			if(!formAction.isChanged()){
				continue;
			}
			Object [] parameters = prepareFormActionUpdateParameters(formAction);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFormActionCreate(List<FormAction> formActionList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFormActionBatchCreateArgs(formActionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFormActionUpdate(List<FormAction> formActionList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFormActionBatchUpdateArgs(formActionList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFormActionList(List<FormAction> formActionList){
		
		List<FormAction> formActionCreateList=new ArrayList<FormAction>();
		List<FormAction> formActionUpdateList=new ArrayList<FormAction>();
		
		for(FormAction formAction: formActionList){
			if(isUpdateRequest(formAction)){
				formActionUpdateList.add( formAction);
				continue;
			}
			formActionCreateList.add(formAction);
		}
		
		return new Object[]{formActionCreateList,formActionUpdateList};
	}
	
	protected boolean isUpdateRequest(FormAction formAction){
 		return formAction.getVersion() > 0;
 	}
 	protected String getSaveFormActionSQL(FormAction formAction){
 		if(isUpdateRequest(formAction)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFormActionParameters(FormAction formAction){
 		if(isUpdateRequest(formAction) ){
 			return prepareFormActionUpdateParameters(formAction);
 		}
 		return prepareFormActionCreateParameters(formAction);
 	}
 	protected Object[] prepareFormActionUpdateParameters(FormAction formAction){
 		Object[] parameters = new Object[9];
 
 		parameters[0] = formAction.getLabel();
 		parameters[1] = formAction.getLocaleKey();
 		parameters[2] = formAction.getActionKey();
 		parameters[3] = formAction.getLevel();
 		parameters[4] = formAction.getUrl(); 	
 		if(formAction.getForm() != null){
 			parameters[5] = formAction.getForm().getId();
 		}
 		
 		parameters[6] = formAction.nextVersion();
 		parameters[7] = formAction.getId();
 		parameters[8] = formAction.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFormActionCreateParameters(FormAction formAction){
		Object[] parameters = new Object[7];
		String newFormActionId=getNextId();
		formAction.setId(newFormActionId);
		parameters[0] =  formAction.getId();
 
 		parameters[1] = formAction.getLabel();
 		parameters[2] = formAction.getLocaleKey();
 		parameters[3] = formAction.getActionKey();
 		parameters[4] = formAction.getLevel();
 		parameters[5] = formAction.getUrl(); 	
 		if(formAction.getForm() != null){
 			parameters[6] = formAction.getForm().getId();
 		
 		}
 				
 				
 		return parameters;
 	}
 	
	protected FormAction saveInternalFormAction(FormAction formAction, Map<String,Object> options){
		
		saveFormAction(formAction);
 	
 		if(isSaveFormEnabled(options)){
	 		saveForm(formAction, options);
 		}
 
		
		return formAction;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected FormAction saveForm(FormAction formAction, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(formAction.getForm() == null){
 			return formAction;//do nothing when it is null
 		}
 		
 		getGenericFormDAO().save(formAction.getForm(),options);
 		return formAction;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public FormAction present(FormAction formAction,Map<String, Object> options){
	

		return formAction;
	
	}
		

	

	protected String getTableName(){
		return FormActionTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FormAction> formActionList) {		
		this.enhanceListInternal(formActionList, this.getFormActionMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FormAction> formActionList = ownerEntity.collectRefsWithType(FormAction.INTERNAL_TYPE);
		this.enhanceList(formActionList);
		
	}
	
	@Override
	public SmartList<FormAction> findFormActionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFormActionMapper());

	}
	@Override
	public int countFormActionWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFormActionWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FormAction> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFormActionMapper());
	}
}














