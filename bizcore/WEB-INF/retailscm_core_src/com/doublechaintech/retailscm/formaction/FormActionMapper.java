
package com.doublechaintech.retailscm.formaction;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.genericform.GenericForm;

public class FormActionMapper extends BaseRowMapper<FormAction>{
	
	protected FormAction internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FormAction formAction = getFormAction();		
		 		
 		setId(formAction, rs, rowNumber); 		
 		setLabel(formAction, rs, rowNumber); 		
 		setLocaleKey(formAction, rs, rowNumber); 		
 		setActionKey(formAction, rs, rowNumber); 		
 		setLevel(formAction, rs, rowNumber); 		
 		setUrl(formAction, rs, rowNumber); 		
 		setForm(formAction, rs, rowNumber); 		
 		setVersion(formAction, rs, rowNumber);

		return formAction;
	}
	
	protected FormAction getFormAction(){
		return new FormAction();
	}		
		
	protected void setId(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(FormActionTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		formAction.setId(id);
	}
		
	protected void setLabel(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String label = rs.getString(FormActionTable.COLUMN_LABEL);
		if(label == null){
			//do nothing when nothing found in database
			return;
		}
		
		formAction.setLabel(label);
	}
		
	protected void setLocaleKey(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String localeKey = rs.getString(FormActionTable.COLUMN_LOCALE_KEY);
		if(localeKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		formAction.setLocaleKey(localeKey);
	}
		
	protected void setActionKey(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String actionKey = rs.getString(FormActionTable.COLUMN_ACTION_KEY);
		if(actionKey == null){
			//do nothing when nothing found in database
			return;
		}
		
		formAction.setActionKey(actionKey);
	}
		
	protected void setLevel(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String level = rs.getString(FormActionTable.COLUMN_LEVEL);
		if(level == null){
			//do nothing when nothing found in database
			return;
		}
		
		formAction.setLevel(level);
	}
		
	protected void setUrl(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String url = rs.getString(FormActionTable.COLUMN_URL);
		if(url == null){
			//do nothing when nothing found in database
			return;
		}
		
		formAction.setUrl(url);
	}
		 		
 	protected void setForm(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
 		String genericFormId = rs.getString(FormActionTable.COLUMN_FORM);
 		if( genericFormId == null){
 			return;
 		}
 		if( genericFormId.isEmpty()){
 			return;
 		}
 		GenericForm genericForm = formAction.getForm();
 		if( genericForm != null ){
 			//if the root object 'formAction' already have the property, just set the id for it;
 			genericForm.setId(genericFormId);
 			
 			return;
 		}
 		formAction.setForm(createEmptyForm(genericFormId));
 	}
 	
	protected void setVersion(FormAction formAction, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(FormActionTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		formAction.setVersion(version);
	}
		
		

 	protected GenericForm  createEmptyForm(String genericFormId){
 		GenericForm genericForm = new GenericForm();
 		genericForm.setId(genericFormId);
 		genericForm.setVersion(Integer.MAX_VALUE);
 		return genericForm;
 	}
 	
}










