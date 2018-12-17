
package com.doublechaintech.retailscm.genericform;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class GenericFormMapper extends BaseRowMapper<GenericForm>{
	
	protected GenericForm internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GenericForm genericForm = getGenericForm();		
		 		
 		setId(genericForm, rs, rowNumber); 		
 		setTitle(genericForm, rs, rowNumber); 		
 		setDescription(genericForm, rs, rowNumber); 		
 		setVersion(genericForm, rs, rowNumber);

		return genericForm;
	}
	
	protected GenericForm getGenericForm(){
		return new GenericForm();
	}		
		
	protected void setId(GenericForm genericForm, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(GenericFormTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		genericForm.setId(id);
	}
		
	protected void setTitle(GenericForm genericForm, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(GenericFormTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		genericForm.setTitle(title);
	}
		
	protected void setDescription(GenericForm genericForm, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String description = rs.getString(GenericFormTable.COLUMN_DESCRIPTION);
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		genericForm.setDescription(description);
	}
		
	protected void setVersion(GenericForm genericForm, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(GenericFormTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		genericForm.setVersion(version);
	}
		
		

}


