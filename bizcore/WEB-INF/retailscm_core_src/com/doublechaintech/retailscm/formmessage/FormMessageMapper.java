
package com.doublechaintech.retailscm.formmessage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.genericform.GenericForm;

public class FormMessageMapper extends BaseRowMapper<FormMessage>{
	
	protected FormMessage internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		FormMessage formMessage = getFormMessage();		
		 		
 		setId(formMessage, rs, rowNumber); 		
 		setTitle(formMessage, rs, rowNumber); 		
 		setForm(formMessage, rs, rowNumber); 		
 		setLevel(formMessage, rs, rowNumber); 		
 		setVersion(formMessage, rs, rowNumber);

		return formMessage;
	}
	
	protected FormMessage getFormMessage(){
		return new FormMessage();
	}		
		
	protected void setId(FormMessage formMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(FormMessageTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		formMessage.setId(id);
	}
		
	protected void setTitle(FormMessage formMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(FormMessageTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		formMessage.setTitle(title);
	}
		 		
 	protected void setForm(FormMessage formMessage, ResultSet rs, int rowNumber) throws SQLException{
 		String genericFormId = rs.getString(FormMessageTable.COLUMN_FORM);
 		if( genericFormId == null){
 			return;
 		}
 		if( genericFormId.isEmpty()){
 			return;
 		}
 		GenericForm genericForm = formMessage.getForm();
 		if( genericForm != null ){
 			//if the root object 'formMessage' already have the property, just set the id for it;
 			genericForm.setId(genericFormId);
 			
 			return;
 		}
 		formMessage.setForm(createEmptyForm(genericFormId));
 	}
 	
	protected void setLevel(FormMessage formMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String level = rs.getString(FormMessageTable.COLUMN_LEVEL);
		if(level == null){
			//do nothing when nothing found in database
			return;
		}
		
		formMessage.setLevel(level);
	}
		
	protected void setVersion(FormMessage formMessage, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(FormMessageTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		formMessage.setVersion(version);
	}
		
		

 	protected GenericForm  createEmptyForm(String genericFormId){
 		GenericForm genericForm = new GenericForm();
 		genericForm.setId(genericFormId);
 		genericForm.setVersion(Integer.MAX_VALUE);
 		return genericForm;
 	}
 	
}


