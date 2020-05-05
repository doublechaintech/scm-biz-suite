
package com.doublechaintech.retailscm.candidateelement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.candidatecontainer.CandidateContainer;

public class CandidateElementMapper extends BaseRowMapper<CandidateElement>{
	
	protected CandidateElement internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CandidateElement candidateElement = getCandidateElement();		
		 		
 		setId(candidateElement, rs, rowNumber); 		
 		setName(candidateElement, rs, rowNumber); 		
 		setType(candidateElement, rs, rowNumber); 		
 		setImage(candidateElement, rs, rowNumber); 		
 		setContainer(candidateElement, rs, rowNumber); 		
 		setVersion(candidateElement, rs, rowNumber);

		return candidateElement;
	}
	
	protected CandidateElement getCandidateElement(){
		return new CandidateElement();
	}		
		
	protected void setId(CandidateElement candidateElement, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CandidateElementTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		candidateElement.setId(id);
	}
		
	protected void setName(CandidateElement candidateElement, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(CandidateElementTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		candidateElement.setName(name);
	}
		
	protected void setType(CandidateElement candidateElement, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String type = rs.getString(CandidateElementTable.COLUMN_TYPE);
		
		if(type == null){
			//do nothing when nothing found in database
			return;
		}
		
		candidateElement.setType(type);
	}
		
	protected void setImage(CandidateElement candidateElement, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String image = rs.getString(CandidateElementTable.COLUMN_IMAGE);
		
		if(image == null){
			//do nothing when nothing found in database
			return;
		}
		
		candidateElement.setImage(image);
	}
		 		
 	protected void setContainer(CandidateElement candidateElement, ResultSet rs, int rowNumber) throws SQLException{
 		String candidateContainerId = rs.getString(CandidateElementTable.COLUMN_CONTAINER);
 		if( candidateContainerId == null){
 			return;
 		}
 		if( candidateContainerId.isEmpty()){
 			return;
 		}
 		CandidateContainer candidateContainer = candidateElement.getContainer();
 		if( candidateContainer != null ){
 			//if the root object 'candidateElement' already have the property, just set the id for it;
 			candidateContainer.setId(candidateContainerId);
 			
 			return;
 		}
 		candidateElement.setContainer(createEmptyContainer(candidateContainerId));
 	}
 	
	protected void setVersion(CandidateElement candidateElement, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CandidateElementTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		candidateElement.setVersion(version);
	}
		
		

 	protected CandidateContainer  createEmptyContainer(String candidateContainerId){
 		CandidateContainer candidateContainer = new CandidateContainer();
 		candidateContainer.setId(candidateContainerId);
 		candidateContainer.setVersion(Integer.MAX_VALUE);
 		return candidateContainer;
 	}
 	
}


