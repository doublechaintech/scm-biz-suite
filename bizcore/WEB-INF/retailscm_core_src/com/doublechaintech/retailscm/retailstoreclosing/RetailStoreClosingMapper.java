
package com.doublechaintech.retailscm.retailstoreclosing;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreClosingMapper extends BaseRowMapper<RetailStoreClosing>{

	protected RetailStoreClosing internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreClosing retailStoreClosing = getRetailStoreClosing();
		
 		setId(retailStoreClosing, rs, rowNumber);
 		setComment(retailStoreClosing, rs, rowNumber);
 		setVersion(retailStoreClosing, rs, rowNumber);

    
		return retailStoreClosing;
	}

	protected RetailStoreClosing getRetailStoreClosing(){
	  RetailStoreClosing entity = new RetailStoreClosing();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(RetailStoreClosing retailStoreClosing, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreClosingTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreClosing.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setComment(RetailStoreClosing retailStoreClosing, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String comment = rs.getString(RetailStoreClosingTable.COLUMN_COMMENT);
		
		if(comment == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreClosing.setComment(comment);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(RetailStoreClosing retailStoreClosing, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreClosingTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreClosing.setVersion(version);
		}catch (SQLException e){

    }
	}
		


}


