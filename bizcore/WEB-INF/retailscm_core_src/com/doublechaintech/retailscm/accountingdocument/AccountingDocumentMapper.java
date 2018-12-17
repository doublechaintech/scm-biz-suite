
package com.doublechaintech.retailscm.accountingdocument;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.accountingdocumentposting.AccountingDocumentPosting;
import com.doublechaintech.retailscm.accountingdocumentcreation.AccountingDocumentCreation;
import com.doublechaintech.retailscm.accountingdocumentauditing.AccountingDocumentAuditing;
import com.doublechaintech.retailscm.accountingdocumentconfirmation.AccountingDocumentConfirmation;
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
 		setCreation(accountingDocument, rs, rowNumber); 		
 		setConfirmation(accountingDocument, rs, rowNumber); 		
 		setAuditing(accountingDocument, rs, rowNumber); 		
 		setPosting(accountingDocument, rs, rowNumber); 		
 		setCurrentStatus(accountingDocument, rs, rowNumber); 		
 		setVersion(accountingDocument, rs, rowNumber);

		return accountingDocument;
	}
	
	protected AccountingDocument getAccountingDocument(){
		return new AccountingDocument();
	}		
		
	protected void setId(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(AccountingDocumentTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setId(id);
	}
		
	protected void setName(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String name = rs.getString(AccountingDocumentTable.COLUMN_NAME);
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setName(name);
	}
		
	protected void setAccountingDocumentDate(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Date accountingDocumentDate = rs.getDate(AccountingDocumentTable.COLUMN_ACCOUNTING_DOCUMENT_DATE);
		if(accountingDocumentDate == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setAccountingDocumentDate(accountingDocumentDate);
	}
		 		
 	protected void setAccountingPeriod(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingPeriodId = rs.getString(AccountingDocumentTable.COLUMN_ACCOUNTING_PERIOD);
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
 		String accountingDocumentTypeId = rs.getString(AccountingDocumentTable.COLUMN_DOCUMENT_TYPE);
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
 	 		
 	protected void setCreation(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingDocumentCreationId = rs.getString(AccountingDocumentTable.COLUMN_CREATION);
 		if( accountingDocumentCreationId == null){
 			return;
 		}
 		if( accountingDocumentCreationId.isEmpty()){
 			return;
 		}
 		AccountingDocumentCreation accountingDocumentCreation = accountingDocument.getCreation();
 		if( accountingDocumentCreation != null ){
 			//if the root object 'accountingDocument' already have the property, just set the id for it;
 			accountingDocumentCreation.setId(accountingDocumentCreationId);
 			
 			return;
 		}
 		accountingDocument.setCreation(createEmptyCreation(accountingDocumentCreationId));
 	}
 	 		
 	protected void setConfirmation(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingDocumentConfirmationId = rs.getString(AccountingDocumentTable.COLUMN_CONFIRMATION);
 		if( accountingDocumentConfirmationId == null){
 			return;
 		}
 		if( accountingDocumentConfirmationId.isEmpty()){
 			return;
 		}
 		AccountingDocumentConfirmation accountingDocumentConfirmation = accountingDocument.getConfirmation();
 		if( accountingDocumentConfirmation != null ){
 			//if the root object 'accountingDocument' already have the property, just set the id for it;
 			accountingDocumentConfirmation.setId(accountingDocumentConfirmationId);
 			
 			return;
 		}
 		accountingDocument.setConfirmation(createEmptyConfirmation(accountingDocumentConfirmationId));
 	}
 	 		
 	protected void setAuditing(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingDocumentAuditingId = rs.getString(AccountingDocumentTable.COLUMN_AUDITING);
 		if( accountingDocumentAuditingId == null){
 			return;
 		}
 		if( accountingDocumentAuditingId.isEmpty()){
 			return;
 		}
 		AccountingDocumentAuditing accountingDocumentAuditing = accountingDocument.getAuditing();
 		if( accountingDocumentAuditing != null ){
 			//if the root object 'accountingDocument' already have the property, just set the id for it;
 			accountingDocumentAuditing.setId(accountingDocumentAuditingId);
 			
 			return;
 		}
 		accountingDocument.setAuditing(createEmptyAuditing(accountingDocumentAuditingId));
 	}
 	 		
 	protected void setPosting(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingDocumentPostingId = rs.getString(AccountingDocumentTable.COLUMN_POSTING);
 		if( accountingDocumentPostingId == null){
 			return;
 		}
 		if( accountingDocumentPostingId.isEmpty()){
 			return;
 		}
 		AccountingDocumentPosting accountingDocumentPosting = accountingDocument.getPosting();
 		if( accountingDocumentPosting != null ){
 			//if the root object 'accountingDocument' already have the property, just set the id for it;
 			accountingDocumentPosting.setId(accountingDocumentPostingId);
 			
 			return;
 		}
 		accountingDocument.setPosting(createEmptyPosting(accountingDocumentPostingId));
 	}
 	
	protected void setCurrentStatus(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(AccountingDocumentTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(AccountingDocument accountingDocument, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(AccountingDocumentTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		accountingDocument.setVersion(version);
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
 	
 	protected AccountingDocumentCreation  createEmptyCreation(String accountingDocumentCreationId){
 		AccountingDocumentCreation accountingDocumentCreation = new AccountingDocumentCreation();
 		accountingDocumentCreation.setId(accountingDocumentCreationId);
 		accountingDocumentCreation.setVersion(Integer.MAX_VALUE);
 		return accountingDocumentCreation;
 	}
 	
 	protected AccountingDocumentConfirmation  createEmptyConfirmation(String accountingDocumentConfirmationId){
 		AccountingDocumentConfirmation accountingDocumentConfirmation = new AccountingDocumentConfirmation();
 		accountingDocumentConfirmation.setId(accountingDocumentConfirmationId);
 		accountingDocumentConfirmation.setVersion(Integer.MAX_VALUE);
 		return accountingDocumentConfirmation;
 	}
 	
 	protected AccountingDocumentAuditing  createEmptyAuditing(String accountingDocumentAuditingId){
 		AccountingDocumentAuditing accountingDocumentAuditing = new AccountingDocumentAuditing();
 		accountingDocumentAuditing.setId(accountingDocumentAuditingId);
 		accountingDocumentAuditing.setVersion(Integer.MAX_VALUE);
 		return accountingDocumentAuditing;
 	}
 	
 	protected AccountingDocumentPosting  createEmptyPosting(String accountingDocumentPostingId){
 		AccountingDocumentPosting accountingDocumentPosting = new AccountingDocumentPosting();
 		accountingDocumentPosting.setId(accountingDocumentPostingId);
 		accountingDocumentPosting.setVersion(Integer.MAX_VALUE);
 		return accountingDocumentPosting;
 	}
 	
}


