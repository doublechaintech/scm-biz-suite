
package com.doublechaintech.retailscm.originalvoucher;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;

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
 	
}


