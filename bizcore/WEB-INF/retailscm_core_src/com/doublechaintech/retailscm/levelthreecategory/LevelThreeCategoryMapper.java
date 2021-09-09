
package com.doublechaintech.retailscm.levelthreecategory;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.leveltwocategory.LevelTwoCategory;

public class LevelThreeCategoryMapper extends BaseRowMapper<LevelThreeCategory>{

	protected LevelThreeCategory internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LevelThreeCategory levelThreeCategory = getLevelThreeCategory();
		
 		setId(levelThreeCategory, rs, rowNumber);
 		setParentCategory(levelThreeCategory, rs, rowNumber);
 		setName(levelThreeCategory, rs, rowNumber);
 		setVersion(levelThreeCategory, rs, rowNumber);

    
		return levelThreeCategory;
	}

	protected LevelThreeCategory getLevelThreeCategory(){
	  LevelThreeCategory entity = new LevelThreeCategory();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LevelThreeCategoryTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeCategory.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setParentCategory(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
 		String levelTwoCategoryId;
 		try{
 		  levelTwoCategoryId = rs.getString(LevelThreeCategoryTable.COLUMN_PARENT_CATEGORY);
 		}catch(SQLException e){
 		  return;
 		}
 		if( levelTwoCategoryId == null){
 			return;
 		}
 		if( levelTwoCategoryId.isEmpty()){
 			return;
 		}
 		LevelTwoCategory levelTwoCategory = levelThreeCategory.getParentCategory();
 		if( levelTwoCategory != null ){
 			//if the root object 'levelThreeCategory' already have the property, just set the id for it;
 			levelTwoCategory.setId(levelTwoCategoryId);

 			return;
 		}
 		levelThreeCategory.setParentCategory(createEmptyParentCategory(levelTwoCategoryId));
 	}
 	
	protected void setName(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(LevelThreeCategoryTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeCategory.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(LevelThreeCategory levelThreeCategory, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LevelThreeCategoryTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelThreeCategory.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected LevelTwoCategory  createEmptyParentCategory(String levelTwoCategoryId){
 		LevelTwoCategory levelTwoCategory = new LevelTwoCategory();
 		levelTwoCategory.setId(levelTwoCategoryId);
 		levelTwoCategory.setVersion(Integer.MAX_VALUE);
 		return levelTwoCategory;
 	}
 	
}


