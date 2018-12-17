
package com.doublechaintech.retailscm.secuserblocking;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;

public class SecUserBlockingMapper extends BaseRowMapper<SecUserBlocking>{
	
	protected SecUserBlocking internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SecUserBlocking secUserBlocking = getSecUserBlocking();		
		 		
 		setId(secUserBlocking, rs, rowNumber); 		
 		setWho(secUserBlocking, rs, rowNumber); 		
 		setBlockTime(secUserBlocking, rs, rowNumber); 		
 		setComments(secUserBlocking, rs, rowNumber); 		
 		setVersion(secUserBlocking, rs, rowNumber);

		return secUserBlocking;
	}
	
	protected SecUserBlocking getSecUserBlocking(){
		return new SecUserBlocking();
	}		
		
	protected void setId(SecUserBlocking secUserBlocking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(SecUserBlockingTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUserBlocking.setId(id);
	}
		
	protected void setWho(SecUserBlocking secUserBlocking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String who = rs.getString(SecUserBlockingTable.COLUMN_WHO);
		if(who == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUserBlocking.setWho(who);
	}
		
	protected void setBlockTime(SecUserBlocking secUserBlocking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date blockTime = rs.getTimestamp(SecUserBlockingTable.COLUMN_BLOCK_TIME);
		if(blockTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUserBlocking.setBlockTime(convertToDateTime(blockTime));
	}
		
	protected void setComments(SecUserBlocking secUserBlocking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String comments = rs.getString(SecUserBlockingTable.COLUMN_COMMENTS);
		if(comments == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUserBlocking.setComments(comments);
	}
		
	protected void setVersion(SecUserBlocking secUserBlocking, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(SecUserBlockingTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		secUserBlocking.setVersion(version);
	}
		
		

}


