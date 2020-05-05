
package com.doublechaintech.retailscm.retailstoreopening;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class RetailStoreOpeningMapper extends BaseRowMapper<RetailStoreOpening>{
	
	protected RetailStoreOpening internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreOpening retailStoreOpening = getRetailStoreOpening();		
		 		
 		setId(retailStoreOpening, rs, rowNumber); 		
 		setComment(retailStoreOpening, rs, rowNumber); 		
 		setVersion(retailStoreOpening, rs, rowNumber);

		return retailStoreOpening;
	}
	
	protected RetailStoreOpening getRetailStoreOpening(){
		return new RetailStoreOpening();
	}		
		
	protected void setId(RetailStoreOpening retailStoreOpening, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreOpeningTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOpening.setId(id);
	}
		
	protected void setComment(RetailStoreOpening retailStoreOpening, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String comment = rs.getString(RetailStoreOpeningTable.COLUMN_COMMENT);
		
		if(comment == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOpening.setComment(comment);
	}
		
	protected void setVersion(RetailStoreOpening retailStoreOpening, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreOpeningTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreOpening.setVersion(version);
	}
		
		

}


