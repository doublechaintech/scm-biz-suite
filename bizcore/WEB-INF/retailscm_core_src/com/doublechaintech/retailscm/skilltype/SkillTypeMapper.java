
package com.doublechaintech.retailscm.skilltype;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;

public class SkillTypeMapper extends BaseRowMapper<SkillType>{

	protected SkillType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		SkillType skillType = getSkillType();
		
 		setId(skillType, rs, rowNumber);
 		setCode(skillType, rs, rowNumber);
 		setCompany(skillType, rs, rowNumber);
 		setDescription(skillType, rs, rowNumber);
 		setVersion(skillType, rs, rowNumber);

    
		return skillType;
	}

	protected SkillType getSkillType(){
	  SkillType entity = new SkillType();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SkillTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setCode(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(SkillTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setCode(code);
		}catch (SQLException e){

    }
	}
		
 	protected void setCompany(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(SkillTypeTable.COLUMN_COMPANY);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = skillType.getCompany();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'skillType' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		skillType.setCompany(createEmptyCompany(retailStoreCountryCenterId));
 	}
 	
	protected void setDescription(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(SkillTypeTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setDescription(description);
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SkillTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setVersion(version);
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


