
package com.doublechaintech.retailscm.skilltype;
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
		return new SkillType();
	}		
		
	protected void setId(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(SkillTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setId(id);
	}
		
	protected void setCode(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(SkillTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setCode(code);
	}
		 		
 	protected void setCompany(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(SkillTypeTable.COLUMN_COMPANY);
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
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(SkillTypeTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setDescription(description);
	}
		
	protected void setVersion(SkillType skillType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(SkillTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		skillType.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyCompany(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
}


