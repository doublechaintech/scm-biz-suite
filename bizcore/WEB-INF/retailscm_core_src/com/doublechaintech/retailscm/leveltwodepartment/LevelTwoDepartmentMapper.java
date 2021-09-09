
package com.doublechaintech.retailscm.leveltwodepartment;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;

public class LevelTwoDepartmentMapper extends BaseRowMapper<LevelTwoDepartment>{

	protected LevelTwoDepartment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LevelTwoDepartment levelTwoDepartment = getLevelTwoDepartment();
		
 		setId(levelTwoDepartment, rs, rowNumber);
 		setBelongsTo(levelTwoDepartment, rs, rowNumber);
 		setName(levelTwoDepartment, rs, rowNumber);
 		setDescription(levelTwoDepartment, rs, rowNumber);
 		setFounded(levelTwoDepartment, rs, rowNumber);
 		setVersion(levelTwoDepartment, rs, rowNumber);

    
		return levelTwoDepartment;
	}

	protected LevelTwoDepartment getLevelTwoDepartment(){
	  LevelTwoDepartment entity = new LevelTwoDepartment();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(LevelTwoDepartment levelTwoDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LevelTwoDepartmentTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoDepartment.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setBelongsTo(LevelTwoDepartment levelTwoDepartment, ResultSet rs, int rowNumber) throws SQLException{
 		String levelOneDepartmentId;
 		try{
 		  levelOneDepartmentId = rs.getString(LevelTwoDepartmentTable.COLUMN_BELONGS_TO);
 		}catch(SQLException e){
 		  return;
 		}
 		if( levelOneDepartmentId == null){
 			return;
 		}
 		if( levelOneDepartmentId.isEmpty()){
 			return;
 		}
 		LevelOneDepartment levelOneDepartment = levelTwoDepartment.getBelongsTo();
 		if( levelOneDepartment != null ){
 			//if the root object 'levelTwoDepartment' already have the property, just set the id for it;
 			levelOneDepartment.setId(levelOneDepartmentId);

 			return;
 		}
 		levelTwoDepartment.setBelongsTo(createEmptyBelongsTo(levelOneDepartmentId));
 	}
 	
	protected void setName(LevelTwoDepartment levelTwoDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(LevelTwoDepartmentTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoDepartment.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setDescription(LevelTwoDepartment levelTwoDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(LevelTwoDepartmentTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoDepartment.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setFounded(LevelTwoDepartment levelTwoDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(LevelTwoDepartmentTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoDepartment.setFounded(founded);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(LevelTwoDepartment levelTwoDepartment, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LevelTwoDepartmentTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoDepartment.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected LevelOneDepartment  createEmptyBelongsTo(String levelOneDepartmentId){
 		LevelOneDepartment levelOneDepartment = new LevelOneDepartment();
 		levelOneDepartment.setId(levelOneDepartmentId);
 		levelOneDepartment.setVersion(Integer.MAX_VALUE);
 		return levelOneDepartment;
 	}
 	
}


