
package com.doublechaintech.retailscm.retailstore;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;

public class RetailStoreMapper extends BaseRowMapper<RetailStore>{
	
	protected RetailStore internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		RetailStore retailStore = getRetailStore();		
		 		
 		setId(retailStore, rs, rowNumber); 		
 		setName(retailStore, rs, rowNumber); 		
 		setTelephone(retailStore, rs, rowNumber); 		
 		setOwner(retailStore, rs, rowNumber); 		
 		setRetailStoreCountryCenter(retailStore, rs, rowNumber); 		
 		setCityServiceCenter(retailStore, rs, rowNumber); 		
 		setCreation(retailStore, rs, rowNumber); 		
 		setInvestmentInvitation(retailStore, rs, rowNumber); 		
 		setFranchising(retailStore, rs, rowNumber); 		
 		setDecoration(retailStore, rs, rowNumber); 		
 		setOpening(retailStore, rs, rowNumber); 		
 		setClosing(retailStore, rs, rowNumber); 		
 		setFounded(retailStore, rs, rowNumber); 		
 		setLatitude(retailStore, rs, rowNumber); 		
 		setLongitude(retailStore, rs, rowNumber); 		
 		setDescription(retailStore, rs, rowNumber); 		
 		setLastUpdateTime(retailStore, rs, rowNumber); 		
 		setVersion(retailStore, rs, rowNumber);

		return retailStore;
	}
	
	protected RetailStore getRetailStore(){
		return new RetailStore();
	}		
		
	protected void setId(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(RetailStoreTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setId(id);
	}
		
	protected void setName(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(RetailStoreTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setName(name);
	}
		
	protected void setTelephone(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String telephone = rs.getString(RetailStoreTable.COLUMN_TELEPHONE);
		
		if(telephone == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setTelephone(telephone);
	}
		
	protected void setOwner(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String owner = rs.getString(RetailStoreTable.COLUMN_OWNER);
		
		if(owner == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setOwner(owner);
	}
		 		
 	protected void setRetailStoreCountryCenter(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCountryCenterId = rs.getString(RetailStoreTable.COLUMN_RETAIL_STORE_COUNTRY_CENTER);
 		if( retailStoreCountryCenterId == null){
 			return;
 		}
 		if( retailStoreCountryCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCountryCenter retailStoreCountryCenter = retailStore.getRetailStoreCountryCenter();
 		if( retailStoreCountryCenter != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 			
 			return;
 		}
 		retailStore.setRetailStoreCountryCenter(createEmptyRetailStoreCountryCenter(retailStoreCountryCenterId));
 	}
 	 		
 	protected void setCityServiceCenter(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCityServiceCenterId = rs.getString(RetailStoreTable.COLUMN_CITY_SERVICE_CENTER);
 		if( retailStoreCityServiceCenterId == null){
 			return;
 		}
 		if( retailStoreCityServiceCenterId.isEmpty()){
 			return;
 		}
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = retailStore.getCityServiceCenter();
 		if( retailStoreCityServiceCenter != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);
 			
 			return;
 		}
 		retailStore.setCityServiceCenter(createEmptyCityServiceCenter(retailStoreCityServiceCenterId));
 	}
 	 		
 	protected void setCreation(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreCreationId = rs.getString(RetailStoreTable.COLUMN_CREATION);
 		if( retailStoreCreationId == null){
 			return;
 		}
 		if( retailStoreCreationId.isEmpty()){
 			return;
 		}
 		RetailStoreCreation retailStoreCreation = retailStore.getCreation();
 		if( retailStoreCreation != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreCreation.setId(retailStoreCreationId);
 			
 			return;
 		}
 		retailStore.setCreation(createEmptyCreation(retailStoreCreationId));
 	}
 	 		
 	protected void setInvestmentInvitation(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreInvestmentInvitationId = rs.getString(RetailStoreTable.COLUMN_INVESTMENT_INVITATION);
 		if( retailStoreInvestmentInvitationId == null){
 			return;
 		}
 		if( retailStoreInvestmentInvitationId.isEmpty()){
 			return;
 		}
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = retailStore.getInvestmentInvitation();
 		if( retailStoreInvestmentInvitation != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreInvestmentInvitation.setId(retailStoreInvestmentInvitationId);
 			
 			return;
 		}
 		retailStore.setInvestmentInvitation(createEmptyInvestmentInvitation(retailStoreInvestmentInvitationId));
 	}
 	 		
 	protected void setFranchising(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreFranchisingId = rs.getString(RetailStoreTable.COLUMN_FRANCHISING);
 		if( retailStoreFranchisingId == null){
 			return;
 		}
 		if( retailStoreFranchisingId.isEmpty()){
 			return;
 		}
 		RetailStoreFranchising retailStoreFranchising = retailStore.getFranchising();
 		if( retailStoreFranchising != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreFranchising.setId(retailStoreFranchisingId);
 			
 			return;
 		}
 		retailStore.setFranchising(createEmptyFranchising(retailStoreFranchisingId));
 	}
 	 		
 	protected void setDecoration(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreDecorationId = rs.getString(RetailStoreTable.COLUMN_DECORATION);
 		if( retailStoreDecorationId == null){
 			return;
 		}
 		if( retailStoreDecorationId.isEmpty()){
 			return;
 		}
 		RetailStoreDecoration retailStoreDecoration = retailStore.getDecoration();
 		if( retailStoreDecoration != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreDecoration.setId(retailStoreDecorationId);
 			
 			return;
 		}
 		retailStore.setDecoration(createEmptyDecoration(retailStoreDecorationId));
 	}
 	 		
 	protected void setOpening(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreOpeningId = rs.getString(RetailStoreTable.COLUMN_OPENING);
 		if( retailStoreOpeningId == null){
 			return;
 		}
 		if( retailStoreOpeningId.isEmpty()){
 			return;
 		}
 		RetailStoreOpening retailStoreOpening = retailStore.getOpening();
 		if( retailStoreOpening != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreOpening.setId(retailStoreOpeningId);
 			
 			return;
 		}
 		retailStore.setOpening(createEmptyOpening(retailStoreOpeningId));
 	}
 	 		
 	protected void setClosing(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
 		String retailStoreClosingId = rs.getString(RetailStoreTable.COLUMN_CLOSING);
 		if( retailStoreClosingId == null){
 			return;
 		}
 		if( retailStoreClosingId.isEmpty()){
 			return;
 		}
 		RetailStoreClosing retailStoreClosing = retailStore.getClosing();
 		if( retailStoreClosing != null ){
 			//if the root object 'retailStore' already have the property, just set the id for it;
 			retailStoreClosing.setId(retailStoreClosingId);
 			
 			return;
 		}
 		retailStore.setClosing(createEmptyClosing(retailStoreClosingId));
 	}
 	
	protected void setFounded(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date founded = rs.getDate(RetailStoreTable.COLUMN_FOUNDED);
		
		if(founded == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setFounded(founded);
	}
		
	protected void setLatitude(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal latitude = rs.getBigDecimal(RetailStoreTable.COLUMN_LATITUDE);
		
		if(latitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setLatitude(latitude);
	}
		
	protected void setLongitude(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		BigDecimal longitude = rs.getBigDecimal(RetailStoreTable.COLUMN_LONGITUDE);
		
		if(longitude == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setLongitude(longitude);
	}
		
	protected void setDescription(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String description = rs.getString(RetailStoreTable.COLUMN_DESCRIPTION);
		
		if(description == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setDescription(description);
	}
		
	protected void setLastUpdateTime(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Date lastUpdateTime = rs.getTimestamp(RetailStoreTable.COLUMN_LAST_UPDATE_TIME);
		
		if(lastUpdateTime == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setLastUpdateTime(convertToDateTime(lastUpdateTime));
	}
		
	protected void setVersion(RetailStore retailStore, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(RetailStoreTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		retailStore.setVersion(version);
	}
		
		

 	protected RetailStoreCountryCenter  createEmptyRetailStoreCountryCenter(String retailStoreCountryCenterId){
 		RetailStoreCountryCenter retailStoreCountryCenter = new RetailStoreCountryCenter();
 		retailStoreCountryCenter.setId(retailStoreCountryCenterId);
 		retailStoreCountryCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCountryCenter;
 	}
 	
 	protected RetailStoreCityServiceCenter  createEmptyCityServiceCenter(String retailStoreCityServiceCenterId){
 		RetailStoreCityServiceCenter retailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
 		retailStoreCityServiceCenter.setId(retailStoreCityServiceCenterId);
 		retailStoreCityServiceCenter.setVersion(Integer.MAX_VALUE);
 		return retailStoreCityServiceCenter;
 	}
 	
 	protected RetailStoreCreation  createEmptyCreation(String retailStoreCreationId){
 		RetailStoreCreation retailStoreCreation = new RetailStoreCreation();
 		retailStoreCreation.setId(retailStoreCreationId);
 		retailStoreCreation.setVersion(Integer.MAX_VALUE);
 		return retailStoreCreation;
 	}
 	
 	protected RetailStoreInvestmentInvitation  createEmptyInvestmentInvitation(String retailStoreInvestmentInvitationId){
 		RetailStoreInvestmentInvitation retailStoreInvestmentInvitation = new RetailStoreInvestmentInvitation();
 		retailStoreInvestmentInvitation.setId(retailStoreInvestmentInvitationId);
 		retailStoreInvestmentInvitation.setVersion(Integer.MAX_VALUE);
 		return retailStoreInvestmentInvitation;
 	}
 	
 	protected RetailStoreFranchising  createEmptyFranchising(String retailStoreFranchisingId){
 		RetailStoreFranchising retailStoreFranchising = new RetailStoreFranchising();
 		retailStoreFranchising.setId(retailStoreFranchisingId);
 		retailStoreFranchising.setVersion(Integer.MAX_VALUE);
 		return retailStoreFranchising;
 	}
 	
 	protected RetailStoreDecoration  createEmptyDecoration(String retailStoreDecorationId){
 		RetailStoreDecoration retailStoreDecoration = new RetailStoreDecoration();
 		retailStoreDecoration.setId(retailStoreDecorationId);
 		retailStoreDecoration.setVersion(Integer.MAX_VALUE);
 		return retailStoreDecoration;
 	}
 	
 	protected RetailStoreOpening  createEmptyOpening(String retailStoreOpeningId){
 		RetailStoreOpening retailStoreOpening = new RetailStoreOpening();
 		retailStoreOpening.setId(retailStoreOpeningId);
 		retailStoreOpening.setVersion(Integer.MAX_VALUE);
 		return retailStoreOpening;
 	}
 	
 	protected RetailStoreClosing  createEmptyClosing(String retailStoreClosingId){
 		RetailStoreClosing retailStoreClosing = new RetailStoreClosing();
 		retailStoreClosing.setId(retailStoreClosingId);
 		retailStoreClosing.setVersion(Integer.MAX_VALUE);
 		return retailStoreClosing;
 	}
 	
}


