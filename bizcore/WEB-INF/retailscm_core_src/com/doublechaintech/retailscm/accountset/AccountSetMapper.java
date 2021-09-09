
package com.doublechaintech.retailscm.accountset;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;

public class AccountSetMapper extends BaseRowMapper<AccountSet>{

	protected AccountSet internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountSet accountSet = getAccountSet();
		
 		setId(accountSet, rs, rowNumber);
 		setName(accountSet, rs, rowNumber);
 		setYearSet(accountSet, rs, rowNumber);
 		setEffectiveDate(accountSet, rs, rowNumber);
 		setAccountingSystem(accountSet, rs, rowNumber);
 		setDomesticCurrencyCode(accountSet, rs, rowNumber);
 		setDomesticCurrencyName(accountSet, rs, rowNumber);
 		setOpeningBank(accountSet, rs, rowNumber);
 		setAccountNumber(accountSet, rs, rowNumber);
 		setCountryCenter(accountSet, rs, rowNumber);
 		setRetailStore(accountSet, rs, rowNumber);
 		setGoodsSupplier(accountSet, rs, rowNumber);
 		setLastUpdateTime(accountSet, rs, rowNumber);
 		setVersion(accountSet, rs, rowNumber);

    
		return accountSet;
	}

	protected AccountSet getAccountSet(){
	  AccountSet entity = new AccountSet();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(AccountSetTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(AccountSetTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setYearSet(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String yearSet = rs.getString(AccountSetTable.COLUMN_YEAR_SET);
		
		if(yearSet == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setYearSet(yearSet);
		}catch (SQLException e){

    }
	}
		
	protected void setEffectiveDate(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date effectiveDate = rs.getDate(AccountSetTable.COLUMN_EFFECTIVE_DATE);
		
		if(effectiveDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setEffectiveDate(effectiveDate);
		}catch (SQLException e){

    }
	}
		
	protected void setAccountingSystem(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String accountingSystem = rs.getString(AccountSetTable.COLUMN_ACCOUNTING_SYSTEM);
		
		if(accountingSystem == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setAccountingSystem(accountingSystem);
		}catch (SQLException e){

    }
	}
		
	protected void setDomesticCurrencyCode(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String domesticCurrencyCode = rs.getString(AccountSetTable.COLUMN_DOMESTIC_CURRENCY_CODE);
		
		if(domesticCurrencyCode == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setDomesticCurrencyCode(domesticCurrencyCode);
		}catch (SQLException e){

    }
	}
		
	protected void setDomesticCurrencyName(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String domesticCurrencyName = rs.getString(AccountSetTable.COLUMN_DOMESTIC_CURRENCY_NAME);
		
		if(domesticCurrencyName == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setDomesticCurrencyName(domesticCurrencyName);
		}catch (SQLException e){

    }
	}
		
	protected void setOpeningBank(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String openingBank = rs.getString(AccountSetTable.COLUMN_OPENING_BANK);
		
		if(openingBank == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setOpeningBank(openingBank);
		}catch (SQLException e){

    }
	}
		
	protected void setAccountNumber(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String accountNumber = rs.getString(AccountSetTable.COLUMN_ACCOUNT_NUMBER);
		
		if(accountNumber == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setAccountNumber(accountNumber);
		}catch (SQLException e){

    }
	}
		
 	protected void setCountryCenter(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId;
 		try{
 		  retailStoreCountryCenterId = rs.getString(AccountSetTable.COLUMN_COUNTRY_CENTER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = accountSet.getCountryCenter();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'accountSet' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);

 			return;
 		}
 		accountSet.setCountryCenter(createEmptyCountryCenter(retailStoreCountryCenterId));
 	}
 	
 	protected void setRetailStore(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreId;
 		try{
 		  retailStoreId = rs.getString(AccountSetTable.COLUMN_RETAIL_STORE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( retailStoreId == null){
 			return;
 		}
 		if( retailStoreId.isEmpty()){
 			return;
 		}
 		RetailStore retailStore = accountSet.getRetailStore();
 		if( retailStore != null ){
 			//if the root object 'accountSet' already have the property, just set the id for it;
 			retailStore.setId(retailStoreId);

 			return;
 		}
 		accountSet.setRetailStore(createEmptyRetailStore(retailStoreId));
 	}
 	
 	protected void setGoodsSupplier(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
 		String goodsSupplierId;
 		try{
 		  goodsSupplierId = rs.getString(AccountSetTable.COLUMN_GOODS_SUPPLIER);
 		}catch(SQLException e){
 		  return;
 		}
 		if( goodsSupplierId == null){
 			return;
 		}
 		if( goodsSupplierId.isEmpty()){
 			return;
 		}
 		GoodsSupplier goodsSupplier = accountSet.getGoodsSupplier();
 		if( goodsSupplier != null ){
 			//if the root object 'accountSet' already have the property, just set the id for it;
 			goodsSupplier.setId(goodsSupplierId);

 			return;
 		}
 		accountSet.setGoodsSupplier(createEmptyGoodsSupplier(goodsSupplierId));
 	}
 	
	protected void setLastUpdateTime(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(AccountSetTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setLastUpdateTime(convertToDateTime(lastUpdateTime));
		}catch (SQLException e){

    }
	}
		
	protected void setVersion(AccountSet accountSet, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(AccountSetTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountSet.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected RetailStoreCountryCenter  createEmptyCountryCenter(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected RetailStore  createEmptyRetailStore(String retailStoreId){
 		RetailStore retailStore = new RetailStore();
 		retailStore.setId(retailStoreId);
 		retailStore.setVersion(Integer.MAX_VALUE);
 		return retailStore;
 	}
 	
 	protected GoodsSupplier  createEmptyGoodsSupplier(String goodsSupplierId){
 		GoodsSupplier goodsSupplier = new GoodsSupplier();
 		goodsSupplier.setId(goodsSupplierId);
 		goodsSupplier.setVersion(Integer.MAX_VALUE);
 		return goodsSupplier;
 	}
 	
}


