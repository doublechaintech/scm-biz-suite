
package com.doublechaintech.retailscm.retailstorecreation;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreCreationMapper extends BaseRowMapper<RetailStoreCreation>{

	protected RetailStoreCreation internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreCreation retailStoreCreation = getRetailStoreCreation();
		
 		setId(retailStoreCreation, rs, rowNumber);
 		setComment(retailStoreCreation, rs, rowNumber);
 		setVersion(retailStoreCreation, rs, rowNumber);

    
		return retailStoreCreation;
	}

	protected RetailStoreCreation getRetailStoreCreation(){
	  RetailStoreCreation entity = new RetailStoreCreation();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(RetailStoreCreation retailStoreCreation, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreCreationTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCreation.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setComment(RetailStoreCreation retailStoreCreation, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String comment = rs.getString(RetailStoreCreationTable.COLUMN_COMMENT);
		
		if(comment == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCreation.setComment(comment);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(RetailStoreCreation retailStoreCreation, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreCreationTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreCreation.setVersion(version);
		}catch (SQLException e){

    }
	}
		


}


