
package com.doublechaintech.retailscm.termination;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;

public class TerminationMapper extends BaseRowMapper<Termination>{
	
	protected Termination internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Termination termination = getTermination();		
		 		
 		setId(termination, rs, rowNumber); 		
 		setReason(termination, rs, rowNumber); 		
 		setType(termination, rs, rowNumber); 		
 		setComment(termination, rs, rowNumber); 		
 		setVersion(termination, rs, rowNumber);

		return termination;
	}
	
	protected Termination getTermination(){
		return new Termination();
	}		
		
	protected void setId(Termination termination, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(TerminationTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		termination.setId(id);
	}
		 		
 	protected void setReason(Termination termination, ResultSet rs, int rowNumber) throws SQLException{
 		String terminationReasonId = rs.getString(TerminationTable.COLUMN_REASON);
 		if( terminationReasonId == null){
 			return;
 		}
 		if( terminationReasonId.isEmpty()){
 			return;
 		}
 		TerminationReason terminationReason = termination.getReason();
 		if( terminationReason != null ){
 			//if the root object 'termination' already have the property, just set the id for it;
 			terminationReason.setId(terminationReasonId);
 			
 			return;
 		}
 		termination.setReason(createEmptyReason(terminationReasonId));
 	}
 	 		
 	protected void setType(Termination termination, ResultSet rs, int rowNumber) throws SQLException{
 		String terminationTypeId = rs.getString(TerminationTable.COLUMN_TYPE);
 		if( terminationTypeId == null){
 			return;
 		}
 		if( terminationTypeId.isEmpty()){
 			return;
 		}
 		TerminationType terminationType = termination.getType();
 		if( terminationType != null ){
 			//if the root object 'termination' already have the property, just set the id for it;
 			terminationType.setId(terminationTypeId);
 			
 			return;
 		}
 		termination.setType(createEmptyType(terminationTypeId));
 	}
 	
	protected void setComment(Termination termination, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String comment = rs.getString(TerminationTable.COLUMN_COMMENT);
		
		if(comment == null){
			//do nothing when nothing found in database
			return;
		}
		
		termination.setComment(comment);
	}
		
	protected void setVersion(Termination termination, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(TerminationTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		termination.setVersion(version);
	}
		
		

 	protected TerminationReason  createEmptyReason(String terminationReasonId){
 		TerminationReason terminationReason = new TerminationReason();
 		terminationReason.setId(terminationReasonId);
 		terminationReason.setVersion(Integer.MAX_VALUE);
 		return terminationReason;
 	}
 	
 	protected TerminationType  createEmptyType(String terminationTypeId){
 		TerminationType terminationType = new TerminationType();
 		terminationType.setId(terminationTypeId);
 		terminationType.setVersion(Integer.MAX_VALUE);
 		return terminationType;
 	}
 	
}


