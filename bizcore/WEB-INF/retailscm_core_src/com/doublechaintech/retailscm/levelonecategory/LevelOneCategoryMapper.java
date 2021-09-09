
package com.doublechaintech.retailscm.levelonecategory;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.catalog.Catalog;

public class LevelOneCategoryMapper extends BaseRowMapper<LevelOneCategory>{

	protected LevelOneCategory internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		LevelOneCategory levelOneCategory = getLevelOneCategory();
		
 		setId(levelOneCategory, rs, rowNumber);
 		setCatalog(levelOneCategory, rs, rowNumber);
 		setName(levelOneCategory, rs, rowNumber);
 		setVersion(levelOneCategory, rs, rowNumber);

    
		return levelOneCategory;
	}

	protected LevelOneCategory getLevelOneCategory(){
	  LevelOneCategory entity = new LevelOneCategory();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(LevelOneCategory levelOneCategory, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(LevelOneCategoryTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelOneCategory.setId(id);
		}catch (SQLException e){

    }
	}
		
 	protected void setCatalog(LevelOneCategory levelOneCategory, ResultSet rs, int rowNumber) throws SQLException{
 		String catalogId;
 		try{
 		  catalogId = rs.getString(LevelOneCategoryTable.COLUMN_CATALOG);
 		}catch(SQLException e){
 		  return;
 		}
 		if( catalogId == null){
 			return;
 		}
 		if( catalogId.isEmpty()){
 			return;
 		}
 		Catalog catalog = levelOneCategory.getCatalog();
 		if( catalog != null ){
 			//if the root object 'levelOneCategory' already have the property, just set the id for it;
 			catalog.setId(catalogId);

 			return;
 		}
 		levelOneCategory.setCatalog(createEmptyCatalog(catalogId));
 	}
 	
	protected void setName(LevelOneCategory levelOneCategory, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(LevelOneCategoryTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelOneCategory.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(LevelOneCategory levelOneCategory, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(LevelOneCategoryTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		levelOneCategory.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected Catalog  createEmptyCatalog(String catalogId){
 		Catalog catalog = new Catalog();
 		catalog.setId(catalogId);
 		catalog.setVersion(Integer.MAX_VALUE);
 		return catalog;
 	}
 	
}


