
package com.doublechaintech.retailscm.instructor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class InstructorMapper extends BaseRowMapper<Instructor>{
	
	protected Instructor internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Instructor instructor = getInstructor();		
		 		
 		setId(instructor, rs, rowNumber); 		
 		setTitle(instructor, rs, rowNumber); 		
 		setFamilyName(instructor, rs, rowNumber); 		
 		setGivenName(instructor, rs, rowNumber); 		
 		setCellPhone(instructor, rs, rowNumber); 		
 		setEmail(instructor, rs, rowNumber); 		
 		setCompany(instructor, rs, rowNumber); 		
 		setIntroduction(instructor, rs, rowNumber); 		
 		setLastUpdateTime(instructor, rs, rowNumber); 		
 		setVersion(instructor, rs, rowNumber);

		return instructor;
	}
	
	protected Instructor getInstructor(){
		return new Instructor();
	}		
		
	protected void setId(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(InstructorTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setId(id);
	}
		
	protected void setTitle(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(InstructorTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setTitle(title);
	}
		
	protected void setFamilyName(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String familyName = rs.getString(InstructorTable.COLUMN_FAMILY_NAME);
		
		if(familyName == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setFamilyName(familyName);
	}
		
	protected void setGivenName(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String givenName = rs.getString(InstructorTable.COLUMN_GIVEN_NAME);
		
		if(givenName == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setGivenName(givenName);
	}
		
	protected void setCellPhone(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String cellPhone = rs.getString(InstructorTable.COLUMN_CELL_PHONE);
		
		if(cellPhone == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setCellPhone(cellPhone);
	}
		
	protected void setEmail(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String email = rs.getString(InstructorTable.COLUMN_EMAIL);
		
		if(email == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setEmail(email);
	}
		 		
 	protected void setCompany(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(InstructorTable.COLUMN_COMPANY);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = instructor.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'instructor' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		instructor.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setIntroduction(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String introduction = rs.getString(InstructorTable.COLUMN_INTRODUCTION);
		
		if(introduction == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setIntroduction(introduction);
	}
		
	protected void setLastUpdateTime(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(InstructorTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(InstructorTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


