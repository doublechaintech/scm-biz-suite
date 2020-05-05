
package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

public class RetailStoreMemberGiftCardConsumeRecordMapper extends BaseRowMapper<RetailStoreMemberGiftCardConsumeRecord>{
	
	protected RetailStoreMemberGiftCardConsumeRecord internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = getRetailStoreMemberGiftCardConsumeRecord();		
		 		
 		setId(retailStoreMemberGiftCardConsumeRecord, rs, rowNumber); 		
 		setOccureTime(retailStoreMemberGiftCardConsumeRecord, rs, rowNumber); 		
 		setOwner(retailStoreMemberGiftCardConsumeRecord, rs, rowNumber); 		
 		setBizOrder(retailStoreMemberGiftCardConsumeRecord, rs, rowNumber); 		
 		setNumber(retailStoreMemberGiftCardConsumeRecord, rs, rowNumber); 		
 		setAmount(retailStoreMemberGiftCardConsumeRecord, rs, rowNumber); 		
 		setVersion(retailStoreMemberGiftCardConsumeRecord, rs, rowNumber);

		return retailStoreMemberGiftCardConsumeRecord;
	}
	
	protected RetailStoreMemberGiftCardConsumeRecord getRetailStoreMemberGiftCardConsumeRecord(){
		return new RetailStoreMemberGiftCardConsumeRecord();
	}		
		
	protected void setId(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberGiftCardConsumeRecord.setId(id);
	}
		
	protected void setOccureTime(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date occureTime = rs.getDate(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_OCCURE_TIME);
		
		if(occureTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberGiftCardConsumeRecord.setOccureTime(occureTime);
	}
		 		
 	protected void setOwner(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreMemberGiftCardId = rs.getString(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_OWNER);
 		if( retailStoreMemberGiftCardId == null){
 			return;
 		}
 		if( retailStoreMemberGiftCardId.isEmpty()){
 			return;
 		}
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = retailStoreMemberGiftCardConsumeRecord.getOwner();
 		if( retailStoreMemberGiftCard != null ){
 			//if the root object 'retailStoreMemberGiftCardConsumeRecord' already have the property, just set the id for it;
 			retailStoreMemberGiftCard.setId(retailStoreMemberGiftCardId);
 			
 			return;
 		}
 		retailStoreMemberGiftCardConsumeRecord.setOwner(createEmptyOwner(retailStoreMemberGiftCardId));
 	}
 	 		
 	protected void setBizOrder(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, ResultSet rs, int rowNumber) throws SQLException{
 		String consumerOrderId = rs.getString(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_BIZ_ORDER);
 		if( consumerOrderId == null){
 			return;
 		}
 		if( consumerOrderId.isEmpty()){
 			return;
 		}
 		ConsumerOrder consumerOrder = retailStoreMemberGiftCardConsumeRecord.getBizOrder();
 		if( consumerOrder != null ){
 			//if the root object 'retailStoreMemberGiftCardConsumeRecord' already have the property, just set the id for it;
 			consumerOrder.setId(consumerOrderId);
 			
 			return;
 		}
 		retailStoreMemberGiftCardConsumeRecord.setBizOrder(createEmptyBizOrder(consumerOrderId));
 	}
 	
	protected void setNumber(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String number = rs.getString(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_NUMBER);
		
		if(number == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberGiftCardConsumeRecord.setNumber(number);
	}
		
	protected void setAmount(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal amount = rs.getBigDecimal(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_AMOUNT);
		
		if(amount == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberGiftCardConsumeRecord.setAmount(amount);
	}
		
	protected void setVersion(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreMemberGiftCardConsumeRecordTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStoreMemberGiftCardConsumeRecord.setVersion(version);
	}
		
		

 	protected RetailStoreMemberGiftCard  createEmptyOwner(String retailStoreMemberGiftCardId){
 		RetailStoreMemberGiftCard retailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
 		retailStoreMemberGiftCard.setId(retailStoreMemberGiftCardId);
 		retailStoreMemberGiftCard.setVersion(Integer.MAX_VALUE);
 		return retailStoreMemberGiftCard;
 	}
 	
 	protected ConsumerOrder  createEmptyBizOrder(String consumerOrderId){
 		ConsumerOrder consumerOrder = new ConsumerOrder();
 		consumerOrder.setId(consumerOrderId);
 		consumerOrder.setVersion(Integer.MAX_VALUE);
 		return consumerOrder;
 	}
 	
}


