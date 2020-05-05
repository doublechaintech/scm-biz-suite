
package com.doublechaintech.retailscm.accountingdocumenttype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.accountset.AccountSet;

public class AccountingDocumentTypeMapper extends BaseRowMapper<AccountingDocumentType>{
	
	protected AccountingDocumentType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingDocumentType accountingDocumentType = getAccountingDocumentType();		
		 		
 		setId(accountingDocumentType, rs, rowNumber); 		
 		setName(accountingDocumentType, rs, rowNumber); 		
 		setDescription(accountingDocumentType, rs, rowNumber); 		
 		setAccountingPeriod(accountingDocumentType, rs, rowNumber); 		
 		setVersion(accountingDocumentType, rs, rowNumber);

		return accountingDocumentType;
	}
	
	protected AccountingDocumentType getAccountingDocumentType(){
		return new AccountingDocumentType();
	}		
		
	protected void setId(AccountingDocumentType accountingDocumentType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(AccountingDocumentTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentType.setId(id);
	}
		
	protected void setName(AccountingDocumentType accountingDocumentType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(AccountingDocumentTypeTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentType.setName(name);
	}
		
	protected void setDescription(AccountingDocumentType accountingDocumentType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(AccountingDocumentTypeTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentType.setDescription(description);
	}
		 		
 	protected void setAccountingPeriod(AccountingDocumentType accountingDocumentType, ResultSet rs, int rowNumber) throws SQLException{
 		String accountSetId = rs.getString(AccountingDocumentTypeTable.COLUMN_ACCOUNTING_PERIOD);
 		if( accountSetId == null){
 			return;
 		}
 		if( accountSetId.isEmpty()){
 			return;
 		}
 		AccountSet accountSet = accountingDocumentType.getAccountingPeriod();
 		if( accountSet != null ){
 			//if the root object 'accountingDocumentType' already have the property, just set the id for it;
 			accountSet.setId(accountSetId);
 			
 			return;
 		}
 		accountingDocumentType.setAccountingPeriod(createEmptyAccountingPeriod(accountSetId));
 	}
 	
	protected void setVersion(AccountingDocumentType accountingDocumentType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(AccountingDocumentTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocumentType.setVersion(version);
	}
		
		

 	protected AccountSet  createEmptyAccountingPeriod(String accountSetId){
 		AccountSet accountSet = new AccountSet();
 		accountSet.setId(accountSetId);
 		accountSet.setVersion(Integer.MAX_VALUE);
 		return accountSet;
 	}
 	
}


