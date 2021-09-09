
package com.doublechaintech.retailscm.instructor;
import com.doublechaintech.retailscm.Beans;
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
	  Instructor entity = new Instructor();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(InstructorTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setTitle(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(InstructorTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setTitle(title);
		}catch (SQLException e){

    }
	}
		
	protected void setFamilyName(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String familyName = rs.getString(InstructorTable.COLUMN_FAMILY_NAME);
		
		if(familyName == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setFamilyName(familyName);
		}catch (SQLException e){

    }
	}
		
	protected void setGivenName(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String givenName = rs.getString(InstructorTable.COLUMN_GIVEN_NAME);
		
		if(givenName == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setGivenName(givenName);
		}catch (SQLException e){

    }
	}
		
	protected void setCellPhone(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String cellPhone = rs.getString(InstructorTable.COLUMN_CELL_PHONE);
		
		if(cellPhone == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setCellPhone(cellPhone);
		}catch (SQLException e){

    }
	}
		
	protected void setEmail(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String email = rs.getString(InstructorTable.COLUMN_EMAIL);
		
		if(email == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setEmail(email);
		}catch (SQLException e){

    }
	}
		
 	protected void setCompany(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(InstructorTable.COLUMN_COMPANY);
 		}catch(SQLException e){
 		  return;
 		}
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
    try{
		//there will be issue when the type is double/int/long
		
		String introduction = rs.getString(InstructorTable.COLUMN_INTRODUCTION);
		
		if(introduction == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setIntroduction(introduction);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(InstructorTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(Instructor instructor, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(InstructorTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		instructor.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


