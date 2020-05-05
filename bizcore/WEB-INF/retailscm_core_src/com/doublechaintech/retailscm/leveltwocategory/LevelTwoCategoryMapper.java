
package com.doublechaintech.retailscm.leveltwocategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.levelonecategory.LevelOneCategory;

public class LevelTwoCategoryMapper extends BaseRowMapper<LevelTwoCategory>{
	
	protected LevelTwoCategory internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LevelTwoCategory levelTwoCategory = getLevelTwoCategory();		
		 		
 		setId(levelTwoCategory, rs, rowNumber); 		
 		setParentCategory(levelTwoCategory, rs, rowNumber); 		
 		setName(levelTwoCategory, rs, rowNumber); 		
 		setVersion(levelTwoCategory, rs, rowNumber);

		return levelTwoCategory;
	}
	
	protected LevelTwoCategory getLevelTwoCategory(){
		return new LevelTwoCategory();
	}		
		
	protected void setId(LevelTwoCategory levelTwoCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LevelTwoCategoryTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoCategory.setId(id);
	}
		 		
 	protected void setParentCategory(LevelTwoCategory levelTwoCategory, ResultSet rs, int rowNumber) throws SQLException{
 		String levelOneCategoryId = rs.getString(LevelTwoCategoryTable.COLUMN_PARENT_CATEGORY);
 		if( levelOneCategoryId == null){
 			return;
 		}
 		if( levelOneCategoryId.isEmpty()){
 			return;
 		}
 		LevelOneCategory levelOneCategory = levelTwoCategory.getParentCategory();
 		if( levelOneCategory != null ){
 			//if the root object 'levelTwoCategory' already have the property, just set the id for it;
 			levelOneCategory.setId(levelOneCategoryId);
 			
 			return;
 		}
 		levelTwoCategory.setParentCategory(createEmptyParentCategory(levelOneCategoryId));
 	}
 	
	protected void setName(LevelTwoCategory levelTwoCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(LevelTwoCategoryTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoCategory.setName(name);
	}
		
	protected void setVersion(LevelTwoCategory levelTwoCategory, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LevelTwoCategoryTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelTwoCategory.setVersion(version);
	}
		
		

 	protected LevelOneCategory  createEmptyParentCategory(String levelOneCategoryId){
 		LevelOneCategory levelOneCategory = new LevelOneCategory();
 		levelOneCategory.setId(levelOneCategoryId);
 		levelOneCategory.setVersion(Integer.MAX_VALUE);
 		return levelOneCategory;
 	}
 	
}


