
package com.doublechaintech.retailscm.companytraining;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;

public class CompanyTrainingMapper extends BaseRowMapper<CompanyTraining>{

	protected CompanyTraining internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		CompanyTraining companyTraining = getCompanyTraining();
		
 		setId(companyTraining, rs, rowNumber);
 		setTitle(companyTraining, rs, rowNumber);
 		setCompany(companyTraining, rs, rowNumber);
 		setInstructor(companyTraining, rs, rowNumber);
 		setTrainingCourseType(companyTraining, rs, rowNumber);
 		setTimeStart(companyTraining, rs, rowNumber);
 		setDurationHours(companyTraining, rs, rowNumber);
 		setLastUpdateTime(companyTraining, rs, rowNumber);
 		setVersion(companyTraining, rs, rowNumber);

    
		return companyTraining;
	}

	protected CompanyTraining getCompanyTraining(){
	  CompanyTraining entity = new CompanyTraining();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(CompanyTrainingTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		companyTraining.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setTitle(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String title = rs.getString(CompanyTrainingTable.COLUMN_TITLE);
		
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		companyTraining.setTitle(title);
		}catch (SQLException e){

    }
	}
		
 	protected void setCompany(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(CompanyTrainingTable.COLUMN_COMPANY);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = companyTraining.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'companyTraining' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		companyTraining.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
 	protected void setInstructor(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
 		String instructorId;
 		try{
 		  instructorId = rs.getString(CompanyTrainingTable.COLUMN_INSTRUCTOR);
 		}catch(SQLException e){
 		  return;
 		}
 		if( instructorId == null){
 			return;
 		}
 		if( instructorId.isEmpty()){
 			return;
 		}
 		Instructor instructor = companyTraining.getInstructor();
 		if( instructor != null ){
 			//if the root object 'companyTraining' already have the property, just set the id for it;
 			instructor.setId(instructorId);

 			return;
 		}
 		companyTraining.setInstructor(createEmptyInstructor(instructorId));
 	}
 	
 	protected void setTrainingCourseType(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
 		String trainingCourseTypeId;
 		try{
 		  trainingCourseTypeId = rs.getString(CompanyTrainingTable.COLUMN_TRAINING_COURSE_TYPE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( trainingCourseTypeId == null){
 			return;
 		}
 		if( trainingCourseTypeId.isEmpty()){
 			return;
 		}
 		TrainingCourseType trainingCourseType = companyTraining.getTrainingCourseType();
 		if( trainingCourseType != null ){
 			//if the root object 'companyTraining' already have the property, just set the id for it;
 			trainingCourseType.setId(trainingCourseTypeId);

 			return;
 		}
 		companyTraining.setTrainingCourseType(createEmptyTrainingCourseType(trainingCourseTypeId));
 	}
 	
	protected void setTimeStart(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date timeStart = rs.getDate(CompanyTrainingTable.COLUMN_TIME_START);
		
		if(timeStart == null){
			//do nothing when nothing found in database
			return;
		}
		
		companyTraining.setTimeStart(timeStart);
		}catch (SQLException e){

    }
	}
		
	protected void setDurationHours(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer durationHours = rs.getInt(CompanyTrainingTable.COLUMN_DURATION_HOURS);
		
		if(durationHours == null){
			//do nothing when nothing found in database
			return;
		}
		
		companyTraining.setDurationHours(durationHours);
		}catch (SQLException e){

    }
	}
		
	protected void setLastUpdateTime(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(CompanyTrainingTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		companyTraining.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(CompanyTraining companyTraining, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(CompanyTrainingTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		companyTraining.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected Instructor  createEmptyInstructor(String instructorId){
 		Instructor instructor = new Instructor();
 		instructor.setId(instructorId);
 		instructor.setVersion(Integer.MAX_VALUE);
 		return instructor;
 	}
 	
 	protected TrainingCourseType  createEmptyTrainingCourseType(String trainingCourseTypeId){
 		TrainingCourseType trainingCourseType = new TrainingCourseType();
 		trainingCourseType.setId(trainingCourseTypeId);
 		trainingCourseType.setVersion(Integer.MAX_VALUE);
 		return trainingCourseType;
 	}
 	
}


