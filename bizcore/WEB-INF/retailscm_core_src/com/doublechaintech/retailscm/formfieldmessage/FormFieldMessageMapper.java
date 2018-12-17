
package com.doublechaintech.retailscm.formfieldmessage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.genericform.GenericForm;

public class FormFieldMessageMapper extends BaseRowMapper<FormFieldMessage>{
	
	protected FormFieldMessage internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FormFieldMessage formFieldMessage = getFormFieldMessage();		
		 		
 		setId(formFieldMessage, rs, rowNumber); 		
 		setTitle(formFieldMessage, rs, rowNumber); 		
 		setParameterName(formFieldMessage, rs, rowNumber); 		
 		setForm(formFieldMessage, rs, rowNumber); 		
 		setLevel(formFieldMessage, rs, rowNumber); 		
 		setVersion(formFieldMessage, rs, rowNumber);

		return formFieldMessage;
	}
	
	protected FormFieldMessage getFormFieldMessage(){
		return new FormFieldMessage();
	}		
		
	protected void setId(FormFieldMessage formFieldMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(FormFieldMessageTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		formFieldMessage.setId(id);
	}
		
	protected void setTitle(FormFieldMessage formFieldMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(FormFieldMessageTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		formFieldMessage.setTitle(title);
	}
		
	protected void setParameterName(FormFieldMessage formFieldMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String parameterName = rs.getString(FormFieldMessageTable.COLUMN_PARAMETER_NAME);
		if(parameterName == null){
			//do nothing when nothing found in database
			return;
		}
		
		formFieldMessage.setParameterName(parameterName);
	}
		 		
 	protected void setForm(FormFieldMessage formFieldMessage, ResultSet rs, int rowNumber) throws SQLException{
 		String genericFormId = rs.getString(FormFieldMessageTable.COLUMN_FORM);
 		if( genericFormId == null){
 			return;
 		}
 		if( genericFormId.isEmpty()){
 			return;
 		}
 		GenericForm genericForm = formFieldMessage.getForm();
 		if( genericForm != null ){
 			//if the root object 'formFieldMessage' already have the property, just set the id for it;
 			genericForm.setId(genericFormId);
 			
 			return;
 		}
 		formFieldMessage.setForm(createEmptyForm(genericFormId));
 	}
 	
	protected void setLevel(FormFieldMessage formFieldMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String level = rs.getString(FormFieldMessageTable.COLUMN_LEVEL);
		if(level == null){
			//do nothing when nothing found in database
			return;
		}
		
		formFieldMessage.setLevel(level);
	}
		
	protected void setVersion(FormFieldMessage formFieldMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(FormFieldMessageTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		formFieldMessage.setVersion(version);
	}
		
		

 	protected GenericForm  createEmptyForm(String genericFormId){
 		GenericForm genericForm = new GenericForm();
 		genericForm.setId(genericFormId);
 		genericForm.setVersion(Integer.MAX_VALUE);
 		return genericForm;
 	}
 	
}


