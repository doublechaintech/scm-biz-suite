
package com.doublechaintech.retailscm.formfield;

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

public class FormFieldJDBCTemplateDAO extends RetailscmNamingServiceDAO implements FormFieldDAO{
 
 	
 	private  GenericFormDAO  genericFormDAO;
 	public void setGenericFormDAO(GenericFormDAO genericFormDAO){
	 	this.genericFormDAO = genericFormDAO;
 	}
 	public GenericFormDAO getGenericFormDAO(){
	 	return this.genericFormDAO;
 	}


			
		

	
	/*
	protected FormField load(AccessKey accessKey,Map<String,Object> options) throws Exception{
		return loadInternalFormField(accessKey, options);
	}
	*/
	
	protected String getIdFormat()
	{
		return getShortName(this.getName())+"%06d";
	}
	
	public FormField load(String id,Map<String,Object> options) throws Exception{
		return loadInternalFormField(FormFieldTable.withId(id), options);
	}
	
	
	
	public FormField save(FormField formField,Map<String,Object> options){
		
		String methodName="save(FormField formField,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(formField, methodName, "formField");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		return saveInternalFormField(formField,options);
	}
	public FormField clone(String formFieldId, Map<String,Object> options) throws Exception{
	
		return clone(FormFieldTable.withId(formFieldId),options);
	}
	
	protected FormField clone(AccessKey accessKey, Map<String,Object> options) throws Exception{
	
		String methodName="clone(String formFieldId,Map<String,Object> options)";
		
		assertMethodArgumentNotNull(accessKey, methodName, "accessKey");
		assertMethodArgumentNotNull(options, methodName, "options");
		
		FormField newFormField = loadInternalFormField(accessKey, options);
		newFormField.setVersion(0);
		
		

		
		saveInternalFormField(newFormField,options);
		
		return newFormField;
	}
	
	
	
	

	protected void throwIfHasException(String formFieldId,int version,int count) throws Exception{
		if (count == 1) {
			throw new FormFieldVersionChangedException(
					"The object version has been changed, please reload to delete");
		}
		if (count < 1) {
			throw new FormFieldNotFoundException(
					"The " + this.getTableName() + "(" + formFieldId + ") has already been deleted.");
		}
		if (count > 1) {
			throw new IllegalStateException(
					"The table '" + this.getTableName() + "' PRIMARY KEY constraint has been damaged, please fix it.");
		}
	}
	
	
	public void delete(String formFieldId, int version) throws Exception{
	
		String methodName="delete(String formFieldId, int version)";
		assertMethodArgumentNotNull(formFieldId, methodName, "formFieldId");
		assertMethodIntArgumentGreaterThan(version,0, methodName, "options");
		
	
		String SQL=this.getDeleteSQL();
		Object [] parameters=new Object[]{formFieldId,version};
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber == 1){
			return ; //Delete successfully
		}
		if(affectedNumber == 0){
			handleDeleteOneError(formFieldId,version);
		}
		
	
	}
	
	
	
	
	

	public FormField disconnectFromAll(String formFieldId, int version) throws Exception{
	
		
		FormField formField = loadInternalFormField(FormFieldTable.withId(formFieldId), emptyOptions());
		formField.clearFromAll();
		this.saveFormField(formField);
		return formField;
		
	
	}
	
	@Override
	protected String[] getNormalColumnNames() {

		return FormFieldTable.NORMAL_CLOUMNS;
	}
	@Override
	protected String getName() {
		
		return "form_field";
	}
	@Override
	protected String getBeanName() {
		
		return "formField";
	}
	
	
	
	
	
	protected boolean checkOptions(Map<String,Object> options, String optionToCheck){
	
 		return FormFieldTokens.checkOptions(options, optionToCheck);
	
	}

 

 	protected boolean isExtractFormEnabled(Map<String,Object> options){
 		
	 	return checkOptions(options, FormFieldTokens.FORM);
 	}

 	protected boolean isSaveFormEnabled(Map<String,Object> options){
	 	
 		return checkOptions(options, FormFieldTokens.FORM);
 	}
 	

 	
 
		

	

	protected FormFieldMapper getFormFieldMapper(){
		return new FormFieldMapper();
	}

	
	
	protected FormField extractFormField(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		try{
			FormField formField = loadSingleObject(accessKey, getFormFieldMapper());
			return formField;
		}catch(EmptyResultDataAccessException e){
			throw new FormFieldNotFoundException("FormField("+accessKey+") is not found!");
		}

	}

	
	

	protected FormField loadInternalFormField(AccessKey accessKey, Map<String,Object> loadOptions) throws Exception{
		
		FormField formField = extractFormField(accessKey, loadOptions);
 	
 		if(isExtractFormEnabled(loadOptions)){
	 		extractForm(formField, loadOptions);
 		}
 
		
		return formField;
		
	}

	 

 	protected FormField extractForm(FormField formField, Map<String,Object> options) throws Exception{

		if(formField.getForm() == null){
			return formField;
		}
		String formId = formField.getForm().getId();
		if( formId == null){
			return formField;
		}
		GenericForm form = getGenericFormDAO().load(formId,options);
		if(form != null){
			formField.setForm(form);
		}
		
 		
 		return formField;
 	}
 		
 
		
		
  	
 	public SmartList<FormField> findFormFieldByForm(String genericFormId,Map<String,Object> options){
 	
  		SmartList<FormField> resultList = queryWith(FormFieldTable.COLUMN_FORM, genericFormId, options, getFormFieldMapper());
		// analyzeFormFieldByForm(resultList, genericFormId, options);
		return resultList;
 	}
 	 
 
 	public SmartList<FormField> findFormFieldByForm(String genericFormId, int start, int count,Map<String,Object> options){
 		
 		SmartList<FormField> resultList =  queryWithRange(FormFieldTable.COLUMN_FORM, genericFormId, options, getFormFieldMapper(), start, count);
 		//analyzeFormFieldByForm(resultList, genericFormId, options);
 		return resultList;
 		
 	}
 	public void analyzeFormFieldByForm(SmartList<FormField> resultList, String genericFormId, Map<String,Object> options){
		if(resultList==null){
			return;//do nothing when the list is null.
		}

 	
 		
 	}
 	@Override
 	public int countFormFieldByForm(String genericFormId,Map<String,Object> options){

 		return countWith(FormFieldTable.COLUMN_FORM, genericFormId, options);
 	}
 	@Override
	public Map<String, Integer> countFormFieldByFormIds(String[] ids, Map<String, Object> options) {
		return countWithIds(FormFieldTable.COLUMN_FORM, ids, options);
	}
 	
 	
		
		
		

	

	protected FormField saveFormField(FormField  formField){
		
		if(!formField.isChanged()){
			return formField;
		}
		
		
		String SQL=this.getSaveFormFieldSQL(formField);
		//FIXME: how about when an item has been updated more than MAX_INT?
		Object [] parameters = getSaveFormFieldParameters(formField);
		int affectedNumber = singleUpdate(SQL,parameters);
		if(affectedNumber != 1){
			throw new IllegalStateException("The save operation should return value = 1, while the value = "
				+ affectedNumber +"If the value = 0, that mean the target record has been updated by someone else!");
		}
		
		formField.incVersion();
		return formField;
	
	}
	public SmartList<FormField> saveFormFieldList(SmartList<FormField> formFieldList,Map<String,Object> options){
		//assuming here are big amount objects to be updated.
		//First step is split into two groups, one group for update and another group for create
		Object [] lists=splitFormFieldList(formFieldList);
		
		batchFormFieldCreate((List<FormField>)lists[CREATE_LIST_INDEX]);
		
		batchFormFieldUpdate((List<FormField>)lists[UPDATE_LIST_INDEX]);
		
		
		//update version after the list successfully saved to database;
		for(FormField formField:formFieldList){
			if(formField.isChanged()){
				formField.incVersion();
			}
			
		
		}
		
		
		return formFieldList;
	}

	public SmartList<FormField> removeFormFieldList(SmartList<FormField> formFieldList,Map<String,Object> options){
		
		
		super.removeList(formFieldList, options);
		
		return formFieldList;
		
		
	}
	
	protected List<Object[]> prepareFormFieldBatchCreateArgs(List<FormField> formFieldList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormField formField:formFieldList ){
			Object [] parameters = prepareFormFieldCreateParameters(formField);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected List<Object[]> prepareFormFieldBatchUpdateArgs(List<FormField> formFieldList){
		
		List<Object[]> parametersList=new ArrayList<Object[]>();
		for(FormField formField:formFieldList ){
			if(!formField.isChanged()){
				continue;
			}
			Object [] parameters = prepareFormFieldUpdateParameters(formField);
			parametersList.add(parameters);
		
		}
		return parametersList;
		
	}
	protected void batchFormFieldCreate(List<FormField> formFieldList){
		String SQL=getCreateSQL();
		List<Object[]> args=prepareFormFieldBatchCreateArgs(formFieldList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
	}
	
	
	protected void batchFormFieldUpdate(List<FormField> formFieldList){
		String SQL=getUpdateSQL();
		List<Object[]> args=prepareFormFieldBatchUpdateArgs(formFieldList);
		
		int affectedNumbers[] = batchUpdate(SQL, args);
		
		
		
	}
	
	
	
	static final int CREATE_LIST_INDEX=0;
	static final int UPDATE_LIST_INDEX=1;
	
	protected Object[] splitFormFieldList(List<FormField> formFieldList){
		
		List<FormField> formFieldCreateList=new ArrayList<FormField>();
		List<FormField> formFieldUpdateList=new ArrayList<FormField>();
		
		for(FormField formField: formFieldList){
			if(isUpdateRequest(formField)){
				formFieldUpdateList.add( formField);
				continue;
			}
			formFieldCreateList.add(formField);
		}
		
		return new Object[]{formFieldCreateList,formFieldUpdateList};
	}
	
	protected boolean isUpdateRequest(FormField formField){
 		return formField.getVersion() > 0;
 	}
 	protected String getSaveFormFieldSQL(FormField formField){
 		if(isUpdateRequest(formField)){
 			return getUpdateSQL();
 		}
 		return getCreateSQL();
 	}
 	
 	protected Object[] getSaveFormFieldParameters(FormField formField){
 		if(isUpdateRequest(formField) ){
 			return prepareFormFieldUpdateParameters(formField);
 		}
 		return prepareFormFieldCreateParameters(formField);
 	}
 	protected Object[] prepareFormFieldUpdateParameters(FormField formField){
 		Object[] parameters = new Object[19];
 
 		parameters[0] = formField.getLabel();
 		parameters[1] = formField.getLocaleKey();
 		parameters[2] = formField.getParameterName();
 		parameters[3] = formField.getType(); 	
 		if(formField.getForm() != null){
 			parameters[4] = formField.getForm().getId();
 		}
 
 		parameters[5] = formField.getPlaceholder();
 		parameters[6] = formField.getDefaultValue();
 		parameters[7] = formField.getDescription();
 		parameters[8] = formField.getFieldGroup();
 		parameters[9] = formField.getMinimumValue();
 		parameters[10] = formField.getMaximumValue();
 		parameters[11] = formField.getRequired();
 		parameters[12] = formField.getDisabled();
 		parameters[13] = formField.getCustomRendering();
 		parameters[14] = formField.getCandidateValues();
 		parameters[15] = formField.getSuggestValues();		
 		parameters[16] = formField.nextVersion();
 		parameters[17] = formField.getId();
 		parameters[18] = formField.getVersion();
 				
 		return parameters;
 	}
 	protected Object[] prepareFormFieldCreateParameters(FormField formField){
		Object[] parameters = new Object[17];
		String newFormFieldId=getNextId();
		formField.setId(newFormFieldId);
		parameters[0] =  formField.getId();
 
 		parameters[1] = formField.getLabel();
 		parameters[2] = formField.getLocaleKey();
 		parameters[3] = formField.getParameterName();
 		parameters[4] = formField.getType(); 	
 		if(formField.getForm() != null){
 			parameters[5] = formField.getForm().getId();
 		
 		}
 		
 		parameters[6] = formField.getPlaceholder();
 		parameters[7] = formField.getDefaultValue();
 		parameters[8] = formField.getDescription();
 		parameters[9] = formField.getFieldGroup();
 		parameters[10] = formField.getMinimumValue();
 		parameters[11] = formField.getMaximumValue();
 		parameters[12] = formField.getRequired();
 		parameters[13] = formField.getDisabled();
 		parameters[14] = formField.getCustomRendering();
 		parameters[15] = formField.getCandidateValues();
 		parameters[16] = formField.getSuggestValues();		
 				
 		return parameters;
 	}
 	
	protected FormField saveInternalFormField(FormField formField, Map<String,Object> options){
		
		saveFormField(formField);
 	
 		if(isSaveFormEnabled(options)){
	 		saveForm(formField, options);
 		}
 
		
		return formField;
		
	}
	
	
	
	//======================================================================================
	 
 
 	protected FormField saveForm(FormField formField, Map<String,Object> options){
 		//Call inject DAO to execute this method
 		if(formField.getForm() == null){
 			return formField;//do nothing when it is null
 		}
 		
 		getGenericFormDAO().save(formField.getForm(),options);
 		return formField;
 		
 	}
 	
 	
 	
 	 
	
 

	

		

	public FormField present(FormField formField,Map<String, Object> options){
	

		return formField;
	
	}
		

	

	protected String getTableName(){
		return FormFieldTable.TABLE_NAME;
	}
	
	
	
	public void enhanceList(List<FormField> formFieldList) {		
		this.enhanceListInternal(formFieldList, this.getFormFieldMapper());
	}
	@Override
	public void collectAndEnhance(BaseEntity ownerEntity) {
		List<FormField> formFieldList = ownerEntity.collectRefsWithType(FormField.INTERNAL_TYPE);
		this.enhanceList(formFieldList);
		
	}
	
	@Override
	public SmartList<FormField> findFormFieldWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return queryWith(key, options, getFormFieldMapper());

	}
	@Override
	public int countFormFieldWithKey(MultipleAccessKey key,
			Map<String, Object> options) {
		
  		return countWith(key, options);

	}
	public Map<String, Integer> countFormFieldWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options) {
			
  		return countWithGroup(groupKey, filterKey, options);

	}
	
	@Override
	public SmartList<FormField> queryList(String sql, Object... parameters) {
	    return this.queryForList(sql, parameters, this.getFormFieldMapper());
	}
}


