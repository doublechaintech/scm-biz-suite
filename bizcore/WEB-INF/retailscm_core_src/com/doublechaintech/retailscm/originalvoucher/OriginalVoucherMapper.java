
package com.doublechaintech.retailscm.originalvoucher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.originalvouchercreation.OriginalVoucherCreation;
import com.doublechaintech.retailscm.originalvoucherauditing.OriginalVoucherAuditing;
import com.doublechaintech.retailscm.originalvoucherconfirmation.OriginalVoucherConfirmation;

public class OriginalVoucherMapper extends BaseRowMapper<OriginalVoucher>{
	
	protected OriginalVoucher internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		OriginalVoucher originalVoucher = getOriginalVoucher();		
		 		
 		setId(originalVoucher, rs, rowNumber); 		
 		setTitle(originalVoucher, rs, rowNumber); 		
 		setMadeBy(originalVoucher, rs, rowNumber); 		
 		setReceivedBy(originalVoucher, rs, rowNumber); 		
 		setVoucherType(originalVoucher, rs, rowNumber); 		
 		setVoucherImage(originalVoucher, rs, rowNumber); 		
 		setBelongsTo(originalVoucher, rs, rowNumber); 		
 		setCreation(originalVoucher, rs, rowNumber); 		
 		setConfirmation(originalVoucher, rs, rowNumber); 		
 		setAuditing(originalVoucher, rs, rowNumber); 		
 		setCurrentStatus(originalVoucher, rs, rowNumber); 		
 		setVersion(originalVoucher, rs, rowNumber);

		return originalVoucher;
	}
	
	protected OriginalVoucher getOriginalVoucher(){
		return new OriginalVoucher();
	}		
		
	protected void setId(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String id = rs.getString(OriginalVoucherTable.COLUMN_ID);
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setId(id);
	}
		
	protected void setTitle(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String title = rs.getString(OriginalVoucherTable.COLUMN_TITLE);
		if(title == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setTitle(title);
	}
		
	protected void setMadeBy(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String madeBy = rs.getString(OriginalVoucherTable.COLUMN_MADE_BY);
		if(madeBy == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setMadeBy(madeBy);
	}
		
	protected void setReceivedBy(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String receivedBy = rs.getString(OriginalVoucherTable.COLUMN_RECEIVED_BY);
		if(receivedBy == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setReceivedBy(receivedBy);
	}
		
	protected void setVoucherType(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String voucherType = rs.getString(OriginalVoucherTable.COLUMN_VOUCHER_TYPE);
		if(voucherType == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setVoucherType(voucherType);
	}
		
	protected void setVoucherImage(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String voucherImage = rs.getString(OriginalVoucherTable.COLUMN_VOUCHER_IMAGE);
		if(voucherImage == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setVoucherImage(voucherImage);
	}
		 		
 	protected void setBelongsTo(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
 		String accountingDocumentId = rs.getString(OriginalVoucherTable.COLUMN_BELONGS_TO);
 		if( accountingDocumentId == null){
 			return;
 		}
 		if( accountingDocumentId.isEmpty()){
 			return;
 		}
 		AccountingDocument accountingDocument = originalVoucher.getBelongsTo();
 		if( accountingDocument != null ){
 			//if the root object 'originalVoucher' already have the property, just set the id for it;
 			accountingDocument.setId(accountingDocumentId);
 			
 			return;
 		}
 		originalVoucher.setBelongsTo(createEmptyBelongsTo(accountingDocumentId));
 	}
 	 		
 	protected void setCreation(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
 		String originalVoucherCreationId = rs.getString(OriginalVoucherTable.COLUMN_CREATION);
 		if( originalVoucherCreationId == null){
 			return;
 		}
 		if( originalVoucherCreationId.isEmpty()){
 			return;
 		}
 		OriginalVoucherCreation originalVoucherCreation = originalVoucher.getCreation();
 		if( originalVoucherCreation != null ){
 			//if the root object 'originalVoucher' already have the property, just set the id for it;
 			originalVoucherCreation.setId(originalVoucherCreationId);
 			
 			return;
 		}
 		originalVoucher.setCreation(createEmptyCreation(originalVoucherCreationId));
 	}
 	 		
 	protected void setConfirmation(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
 		String originalVoucherConfirmationId = rs.getString(OriginalVoucherTable.COLUMN_CONFIRMATION);
 		if( originalVoucherConfirmationId == null){
 			return;
 		}
 		if( originalVoucherConfirmationId.isEmpty()){
 			return;
 		}
 		OriginalVoucherConfirmation originalVoucherConfirmation = originalVoucher.getConfirmation();
 		if( originalVoucherConfirmation != null ){
 			//if the root object 'originalVoucher' already have the property, just set the id for it;
 			originalVoucherConfirmation.setId(originalVoucherConfirmationId);
 			
 			return;
 		}
 		originalVoucher.setConfirmation(createEmptyConfirmation(originalVoucherConfirmationId));
 	}
 	 		
 	protected void setAuditing(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
 		String originalVoucherAuditingId = rs.getString(OriginalVoucherTable.COLUMN_AUDITING);
 		if( originalVoucherAuditingId == null){
 			return;
 		}
 		if( originalVoucherAuditingId.isEmpty()){
 			return;
 		}
 		OriginalVoucherAuditing originalVoucherAuditing = originalVoucher.getAuditing();
 		if( originalVoucherAuditing != null ){
 			//if the root object 'originalVoucher' already have the property, just set the id for it;
 			originalVoucherAuditing.setId(originalVoucherAuditingId);
 			
 			return;
 		}
 		originalVoucher.setAuditing(createEmptyAuditing(originalVoucherAuditingId));
 	}
 	
	protected void setCurrentStatus(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		String currentStatus = rs.getString(OriginalVoucherTable.COLUMN_CURRENT_STATUS);
		if(currentStatus == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setCurrentStatus(currentStatus);
	}
		
	protected void setVersion(OriginalVoucher originalVoucher, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		Integer version = rs.getInt(OriginalVoucherTable.COLUMN_VERSION);
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		originalVoucher.setVersion(version);
	}
		
		

 	protected AccountingDocument  createEmptyBelongsTo(String accountingDocumentId){
 		AccountingDocument accountingDocument = new AccountingDocument();
 		accountingDocument.setId(accountingDocumentId);
 		accountingDocument.setVersion(Integer.MAX_VALUE);
 		return accountingDocument;
 	}
 	
 	protected OriginalVoucherCreation  createEmptyCreation(String originalVoucherCreationId){
 		OriginalVoucherCreation originalVoucherCreation = new OriginalVoucherCreation();
 		originalVoucherCreation.setId(originalVoucherCreationId);
 		originalVoucherCreation.setVersion(Integer.MAX_VALUE);
 		return originalVoucherCreation;
 	}
 	
 	protected OriginalVoucherConfirmation  createEmptyConfirmation(String originalVoucherConfirmationId){
 		OriginalVoucherConfirmation originalVoucherConfirmation = new OriginalVoucherConfirmation();
 		originalVoucherConfirmation.setId(originalVoucherConfirmationId);
 		originalVoucherConfirmation.setVersion(Integer.MAX_VALUE);
 		return originalVoucherConfirmation;
 	}
 	
 	protected OriginalVoucherAuditing  createEmptyAuditing(String originalVoucherAuditingId){
 		OriginalVoucherAuditing originalVoucherAuditing = new OriginalVoucherAuditing();
 		originalVoucherAuditing.setId(originalVoucherAuditingId);
 		originalVoucherAuditing.setVersion(Integer.MAX_VALUE);
 		return originalVoucherAuditing;
 	}
 	
}


