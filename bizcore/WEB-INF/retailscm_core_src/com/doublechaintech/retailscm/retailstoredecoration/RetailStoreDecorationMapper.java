
package com.doublechaintech.retailscm.retailstoredecoration;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreDecorationMapper extends BaseRowMapper<RetailStoreDecoration>{

	protected RetailStoreDecoration internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreDecoration retailStoreDecoration = getRetailStoreDecoration();
		
 		setId(retailStoreDecoration, rs, rowNumber);
 		setComment(retailStoreDecoration, rs, rowNumber);
 		setVersion(retailStoreDecoration, rs, rowNumber);

    
		return retailStoreDecoration;
	}

	protected RetailStoreDecoration getRetailStoreDecoration(){
	  RetailStoreDecoration entity = new RetailStoreDecoration();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(RetailStoreDecoration retailStoreDecoration, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreDecorationTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreDecoration.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setComment(RetailStoreDecoration retailStoreDecoration, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String comment = rs.getString(RetailStoreDecorationTable.COLUMN_COMMENT);
		
		if(comment == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreDecoration.setComment(comment);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(RetailStoreDecoration retailStoreDecoration, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreDecorationTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreDecoration.setVersion(version);
		}catch (SQLException e){

    }
	}
		


}


