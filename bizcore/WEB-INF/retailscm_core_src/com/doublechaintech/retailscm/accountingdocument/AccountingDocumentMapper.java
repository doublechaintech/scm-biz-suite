
package com.doublechaintech.retailscm.accountingdocument;
import com.doublechaintech.retailscm.Beans;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;

public class AccountingDocumentMapper extends BaseRowMapper<AccountingDocument>{

	protected AccountingDocument internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		AccountingDocument accountingDocument = getAccountingDocument();
		
 		setId(accountingDocument, rs, rowNumber);
 		setName(accountingDocument, rs, rowNumber);
 		setAccountingDocumentDate(accountingDocument, rs, rowNumber);
 		setAccountingPeriod(accountingDocument, rs, rowNumber);
 		setDocumentType(accountingDocument, rs, rowNumber);
 		setVersion(accountingDocument, rs, rowNumber);

    
		return accountingDocument;
	}

	protected AccountingDocument getAccountingDocument(){
	  AccountingDocument entity = new AccountingDocument();
	  Beans.dbUtil().markEnhanced(entity);
		return entity;
	}
		
	protected void setId(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(AccountingDocumentTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setId(id);
		}catch (SQLException e){

    }
	}
		
	protected void setName(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(AccountingDocumentTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setName(name);
		}catch (SQLException e){

    }
	}
		
	protected void setAccountingDocumentDate(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Date accountingDocumentDate = rs.getDate(AccountingDocumentTable.COLUMN_ACCOUNTING_DOCUMENT_DATE);
		
		if(accountingDocumentDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);
		}catch (SQLException e){

    }
	}
		
 	protected void setAccountingPeriod(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingPeriodId;
 		try{
 		  accountingPeriodId = rs.getString(AccountingDocumentTable.COLUMN_ACCOUNTING_PERIOD);
 		}catch(SQLException e){
 		  return;
 		}
 		if( accountingPeriodId == null){
 			return;
 		}
 		if( accountingPeriodId.isEmpty()){
 			return;
 		}
 		AccountingPeriod accountingPeriod = accountingDocument.getAccountingPeriod();
 		if( accountingPeriod != null ){
 			//if the root object 'accountingDocument' already have the property, just set the id for it;
 			accountingPeriod.setId(accountingPeriodId);

 			return;
 		}
 		accountingDocument.setAccountingPeriod(createEmptyAccountingPeriod(accountingPeriodId));
 	}
 	
 	protected void setDocumentType(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingDocumentTypeId;
 		try{
 		  accountingDocumentTypeId = rs.getString(AccountingDocumentTable.COLUMN_DOCUMENT_TYPE);
 		}catch(SQLException e){
 		  return;
 		}
 		if( accountingDocumentTypeId == null){
 			return;
 		}
 		if( accountingDocumentTypeId.isEmpty()){
 			return;
 		}
 		AccountingDocumentType accountingDocumentType = accountingDocument.getDocumentType();
 		if( accountingDocumentType != null ){
 			//if the root object 'accountingDocument' already have the property, just set the id for it;
 			accountingDocumentType.setId(accountingDocumentTypeId);

 			return;
 		}
 		accountingDocument.setDocumentType(createEmptyDocumentType(accountingDocumentTypeId));
 	}
 	
	protected void setVersion(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
    try{
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(AccountingDocumentTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setVersion(version);
		}catch (SQLException e){

    }
	}
		


 	protected AccountingPeriod  createEmptyAccountingPeriod(String accountingPeriodId){
 		AccountingPeriod accountingPeriod = new AccountingPeriod();
 		accountingPeriod.setId(accountingPeriodId);
 		accountingPeriod.setVersion(Integer.MAX_VALUE);
 		return accountingPeriod;
 	}
 	
 	protected AccountingDocumentType  createEmptyDocumentType(String accountingDocumentTypeId){
 		AccountingDocumentType accountingDocumentType = new AccountingDocumentType();
 		accountingDocumentType.setId(accountingDocumentTypeId);
 		accountingDocumentType.setVersion(Integer.MAX_VALUE);
 		return accountingDocumentType;
 	}
 	
}


