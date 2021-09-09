
package com.doublechaintech.retailscm.levelthreedepartment;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.leveltwodepartment.LevelTwoDepartment;

public class LevelThreeDepartmentMapper extends BaseRowMapper<LevelThreeDepartment>{

	protected LevelThreeDepartment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LevelThreeDepartment levelThreeDepartment = getLevelThreeDepartment();
		
 		setId(levelThreeDepartment, rs, rowNumber);
 		setBelongsTo(levelThreeDepartment, rs, rowNumber);
 		setName(levelThreeDepartment, rs, rowNumber);
 		setDescription(levelThreeDepartment, rs, rowNumber);
 		setFounded(levelThreeDepartment, rs, rowNumber);
 		setVersion(levelThreeDepartment, rs, rowNumber);

    
		return levelThreeDepartment;
	}

	protected LevelThreeDepartment getLevelThreeDepartment(){
	  LevelThreeDepartment entity = new LevelThreeDepartment();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(LevelThreeDepartment levelThreeDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LevelThreeDepartmentTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeDepartment.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setBelongsTo(LevelThreeDepartment levelThreeDepartment, ResultSet rs, int rowNumber) throws SQLException{
 		String levelTwoDepartmentId;
 		try{
 		  levelTwoDepartmentId = rs.getString(LevelThreeDepartmentTable.COLUMN_BELONGS_TO);
 		}catch(SQLException e){
 		  return;
 		}
 		if( levelTwoDepartmentId == null){
 			return;
 		}
 		if( levelTwoDepartmentId.isEmpty()){
 			return;
 		}
 		LevelTwoDepartment levelTwoDepartment = levelThreeDepartment.getBelongsTo();
 		if( levelTwoDepartment != null ){
 			//if the root object 'levelThreeDepartment' already have the property, just set the id for it;
 			levelTwoDepartment.setId(levelTwoDepartmentId);

 			return;
 		}
 		levelThreeDepartment.setBelongsTo(createEmptyBelongsTo(levelTwoDepartmentId));
 	}
 	
	protected void setName(LevelThreeDepartment levelThreeDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(LevelThreeDepartmentTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeDepartment.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setDescription(LevelThreeDepartment levelThreeDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(LevelThreeDepartmentTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeDepartment.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setFounded(LevelThreeDepartment levelThreeDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(LevelThreeDepartmentTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeDepartment.setFounded(founded);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(LevelThreeDepartment levelThreeDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LevelThreeDepartmentTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeDepartment.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected LevelTwoDepartment  createEmptyBelongsTo(String levelTwoDepartmentId){
 		LevelTwoDepartment levelTwoDepartment = new LevelTwoDepartment();
 		levelTwoDepartment.setId(levelTwoDepartmentId);
 		levelTwoDepartment.setVersion(Integer.MAX_VALUE);
 		return levelTwoDepartment;
 	}
 	
}


