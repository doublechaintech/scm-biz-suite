
package com.doublechaintech.retailscm.goodsshelf;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

public class GoodsShelfMapper extends BaseRowMapper<GoodsShelf>{
	
	protected GoodsShelf internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		GoodsShelf goodsShelf = getGoodsShelf();		
		 		
 		setId(goodsShelf, rs, rowNumber); 		
 		setLocation(goodsShelf, rs, rowNumber); 		
 		setStorageSpace(goodsShelf, rs, rowNumber); 		
 		setSupplierSpace(goodsShelf, rs, rowNumber); 		
 		setDamageSpace(goodsShelf, rs, rowNumber); 		
 		setLastUpdateTime(goodsShelf, rs, rowNumber); 		
 		setVersion(goodsShelf, rs, rowNumber);

		return goodsShelf;
	}
	
	protected GoodsShelf getGoodsShelf(){
		return new GoodsShelf();
	}		
		
	protected void setId(GoodsShelf goodsShelf, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(GoodsShelfTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelf.setId(id);
	}
		
	protected void setLocation(GoodsShelf goodsShelf, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String location = rs.getString(GoodsShelfTable.COLUMN_LOCATION);
		
		if(location == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelf.setLocation(location);
	}
		 		
 	protected void setStorageSpace(GoodsShelf goodsShelf, ResultSet rs, int rowNumber) throws SQLException{
 		String storageSpaceId = rs.getString(GoodsShelfTable.COLUMN_STORAGE_SPACE);
 		if( storageSpaceId == null){
 			return;
 		}
 		if( storageSpaceId.isEmpty()){
 			return;
 		}
 		StorageSpace storageSpace = goodsShelf.getStorageSpace();
 		if( storageSpace != null ){
 			//if the root object 'goodsShelf' already have the property, just set the id for it;
 			storageSpace.setId(storageSpaceId);
 			
 			return;
 		}
 		goodsShelf.setStorageSpace(createEmptyStorageSpace(storageSpaceId));
 	}
 	 		
 	protected void setSupplierSpace(GoodsShelf goodsShelf, ResultSet rs, int rowNumber) throws SQLException{
 		String supplierSpaceId = rs.getString(GoodsShelfTable.COLUMN_SUPPLIER_SPACE);
 		if( supplierSpaceId == null){
 			return;
 		}
 		if( supplierSpaceId.isEmpty()){
 			return;
 		}
 		SupplierSpace supplierSpace = goodsShelf.getSupplierSpace();
 		if( supplierSpace != null ){
 			//if the root object 'goodsShelf' already have the property, just set the id for it;
 			supplierSpace.setId(supplierSpaceId);
 			
 			return;
 		}
 		goodsShelf.setSupplierSpace(createEmptySupplierSpace(supplierSpaceId));
 	}
 	 		
 	protected void setDamageSpace(GoodsShelf goodsShelf, ResultSet rs, int rowNumber) throws SQLException{
 		String damageSpaceId = rs.getString(GoodsShelfTable.COLUMN_DAMAGE_SPACE);
 		if( damageSpaceId == null){
 			return;
 		}
 		if( damageSpaceId.isEmpty()){
 			return;
 		}
 		DamageSpace damageSpace = goodsShelf.getDamageSpace();
 		if( damageSpace != null ){
 			//if the root object 'goodsShelf' already have the property, just set the id for it;
 			damageSpace.setId(damageSpaceId);
 			
 			return;
 		}
 		goodsShelf.setDamageSpace(createEmptyDamageSpace(damageSpaceId));
 	}
 	
	protected void setLastUpdateTime(GoodsShelf goodsShelf, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(GoodsShelfTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelf.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(GoodsShelf goodsShelf, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(GoodsShelfTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		goodsShelf.setVersion(version);
	}
		
		

 	protected StorageSpace  createEmptyStorageSpace(String storageSpaceId){
 		StorageSpace storageSpace = new StorageSpace();
 		storageSpace.setId(storageSpaceId);
 		storageSpace.setVersion(Integer.MAX_VALUE);
 		return storageSpace;
 	}
 	
 	protected SupplierSpace  createEmptySupplierSpace(String supplierSpaceId){
 		SupplierSpace supplierSpace = new SupplierSpace();
 		supplierSpace.setId(supplierSpaceId);
 		supplierSpace.setVersion(Integer.MAX_VALUE);
 		return supplierSpace;
 	}
 	
 	protected DamageSpace  createEmptyDamageSpace(String damageSpaceId){
 		DamageSpace damageSpace = new DamageSpace();
 		damageSpace.setId(damageSpaceId);
 		damageSpace.setVersion(Integer.MAX_VALUE);
 		return damageSpace;
 	}
 	
}


