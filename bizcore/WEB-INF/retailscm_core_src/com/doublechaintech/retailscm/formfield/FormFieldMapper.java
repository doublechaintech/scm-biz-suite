
package com.doublechaintech.retailscm.formfield;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.genericform.GenericForm;

public class FormFieldMapper extends BaseRowMapper<FormField>{
	
	protected FormField internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FormField formField = getFormField();		
		 		
 		setId(formField, rs, rowNumber); 		
 		setLabel(formField, rs, rowNumber); 		
 		setLocaleKey(formField, rs, rowNumber); 		
 		setParameterName(formField, rs, rowNumber); 		
 		setType(formField, rs, rowNumber); 		
 		setForm(formField, rs, rowNumber); 		
 		setPlaceholder(formField, rs, rowNumber); 		
 		setDefaultValue(formField, rs, rowNumber); 		
 		setDescription(formField, rs, rowNumber); 		
 		setFieldGroup(formField, rs, rowNumber); 		
 		setMinimumValue(formField, rs, rowNumber); 		
 		setMaximumValue(formField, rs, rowNumber); 		
 		setRequired(formField, rs, rowNumber); 		
 		setDisabled(formField, rs, rowNumber); 		
 		setCustomRendering(formField, rs, rowNumber); 		
 		setCandidateValues(formField, rs, rowNumber); 		
 		setSuggestValues(formField, rs, rowNumber); 		
 		setVersion(formField, rs, rowNumber);

		return formField;
	}
	
	protected FormField getFormField(){
		return new FormField();
	}		
		
	protected void setId(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(FormFieldTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setId(id);
	}
		
	protected void setLabel(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String label = rs.getString(FormFieldTable.COLUMN_LABEL);
		if(label == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setLabel(label);
	}
		
	protected void setLocaleKey(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String localeKey = rs.getString(FormFieldTable.COLUMN_LOCALE_KEY);
		if(localeKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setLocaleKey(localeKey);
	}
		
	protected void setParameterName(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String parameterName = rs.getString(FormFieldTable.COLUMN_PARAMETER_NAME);
		if(parameterName == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setParameterName(parameterName);
	}
		
	protected void setType(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String type = rs.getString(FormFieldTable.COLUMN_TYPE);
		if(type == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setType(type);
	}
		 		
 	protected void setForm(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
 		String genericFormId = rs.getString(FormFieldTable.COLUMN_FORM);
 		if( genericFormId == null){
 			return;
 		}
 		if( genericFormId.isEmpty()){
 			return;
 		}
 		GenericForm genericForm = formField.getForm();
 		if( genericForm != null ){
 			//if the root object 'formField' already have the property, just set the id for it;
 			genericForm.setId(genericFormId);
 			
 			return;
 		}
 		formField.setForm(createEmptyForm(genericFormId));
 	}
 	
	protected void setPlaceholder(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String placeholder = rs.getString(FormFieldTable.COLUMN_PLACEHOLDER);
		if(placeholder == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setPlaceholder(placeholder);
	}
		
	protected void setDefaultValue(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String defaultValue = rs.getString(FormFieldTable.COLUMN_DEFAULT_VALUE);
		if(defaultValue == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setDefaultValue(defaultValue);
	}
		
	protected void setDescription(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String description = rs.getString(FormFieldTable.COLUMN_DESCRIPTION);
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setDescription(description);
	}
		
	protected void setFieldGroup(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String fieldGroup = rs.getString(FormFieldTable.COLUMN_FIELD_GROUP);
		if(fieldGroup == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setFieldGroup(fieldGroup);
	}
		
	protected void setMinimumValue(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String minimumValue = rs.getString(FormFieldTable.COLUMN_MINIMUM_VALUE);
		if(minimumValue == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setMinimumValue(minimumValue);
	}
		
	protected void setMaximumValue(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String maximumValue = rs.getString(FormFieldTable.COLUMN_MAXIMUM_VALUE);
		if(maximumValue == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setMaximumValue(maximumValue);
	}
		
	protected void setRequired(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Boolean required = rs.getBoolean(FormFieldTable.COLUMN_REQUIRED);
		if(required == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setRequired(required);
	}
		
	protected void setDisabled(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Boolean disabled = rs.getBoolean(FormFieldTable.COLUMN_DISABLED);
		if(disabled == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setDisabled(disabled);
	}
		
	protected void setCustomRendering(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Boolean customRendering = rs.getBoolean(FormFieldTable.COLUMN_CUSTOM_RENDERING);
		if(customRendering == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setCustomRendering(customRendering);
	}
		
	protected void setCandidateValues(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String candidateValues = rs.getString(FormFieldTable.COLUMN_CANDIDATE_VALUES);
		if(candidateValues == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setCandidateValues(candidateValues);
	}
		
	protected void setSuggestValues(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String suggestValues = rs.getString(FormFieldTable.COLUMN_SUGGEST_VALUES);
		if(suggestValues == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setSuggestValues(suggestValues);
	}
		
	protected void setVersion(FormField formField, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(FormFieldTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		formField.setVersion(version);
	}
		
		

 	protected GenericForm  createEmptyForm(String genericFormId){
 		GenericForm genericForm = new GenericForm();
 		genericForm.setId(genericFormId);
 		genericForm.setVersion(Integer.MAX_VALUE);
 		return genericForm;
 	}
 	
}


