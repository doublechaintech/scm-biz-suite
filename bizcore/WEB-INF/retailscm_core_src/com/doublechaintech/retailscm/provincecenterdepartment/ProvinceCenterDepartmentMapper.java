
package com.doublechaintech.retailscm.provincecenterdepartment;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;

public class ProvinceCenterDepartmentMapper extends BaseRowMapper<ProvinceCenterDepartment>{
	
	protected ProvinceCenterDepartment internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		ProvinceCenterDepartment provinceCenterDepartment = getProvinceCenterDepartment();		
		 		
 		setId(provinceCenterDepartment, rs, rowNumber); 		
 		setName(provinceCenterDepartment, rs, rowNumber); 		
 		setFounded(provinceCenterDepartment, rs, rowNumber); 		
 		setProvinceCenter(provinceCenterDepartment, rs, rowNumber); 		
 		setManager(provinceCenterDepartment, rs, rowNumber); 		
 		setVersion(provinceCenterDepartment, rs, rowNumber);

		return provinceCenterDepartment;
	}
	
	protected ProvinceCenterDepartment getProvinceCenterDepartment(){
		return new ProvinceCenterDepartment();
	}		
		
	protected void setId(ProvinceCenterDepartment provinceCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(ProvinceCenterDepartmentTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		provinceCenterDepartment.setId(id);
	}
		
	protected void setName(ProvinceCenterDepartment provinceCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(ProvinceCenterDepartmentTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		provinceCenterDepartment.setName(name);
	}
		
	protected void setFounded(ProvinceCenterDepartment provinceCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(ProvinceCenterDepartmentTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		provinceCenterDepartment.setFounded(founded);
	}
		 		
 	protected void setProvinceCenter(ProvinceCenterDepartment provinceCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreProvinceCenterId = rs.getString(ProvinceCenterDepartmentTable.COLUMN_PROVINCE_CENTER);
 		if( retailStoreProvinceCenterId == null){
 			return;
 		}
 		if( retailStoreProvinceCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreProvinceCenter retailStoreProvinceCenter = provinceCenterDepartment.getProvinceCenter();
 		if( retailStoreProvinceCenter != null ){
 			//if the root object 'provinceCenterDepartment' already have the property, just set the id for it;
 			retailStoreProvinceCenter.setId(retailStoreProvinceCenterId);
 			
 			return;
 		}
 		provinceCenterDepartment.setProvinceCenter(createEmptyProvinceCenter(retailStoreProvinceCenterId));
 	}
 	
	protected void setManager(ProvinceCenterDepartment provinceCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String manager = rs.getString(ProvinceCenterDepartmentTable.COLUMN_MANAGER);
		
		if(manager == null){
			//do nothing when nothing found in database
			return;
		}
		
		provinceCenterDepartment.setManager(manager);
	}
		
	protected void setVersion(ProvinceCenterDepartment provinceCenterDepartment, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(ProvinceCenterDepartmentTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		provinceCenterDepartment.setVersion(version);
	}
		
		

 	protected RetailStoreProvinceCenter  createEmptyProvinceCenter(String retailStoreProvinceCenterId){
 		RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
 		retailStoreProvinceCenter.setId(retailStoreProvinceCenterId);
 		retailStoreProvinceCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreProvinceCenter;
 	}
 	
}


