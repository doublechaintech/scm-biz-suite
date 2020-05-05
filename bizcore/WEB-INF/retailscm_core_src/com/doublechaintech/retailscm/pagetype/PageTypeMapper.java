
package com.doublechaintech.retailscm.pagetype;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.mobileapp.MobileApp;

public class PageTypeMapper extends BaseRowMapper<PageType>{
	
	protected PageType internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		PageType pageType = getPageType();		
		 		
 		setId(pageType, rs, rowNumber); 		
 		setName(pageType, rs, rowNumber); 		
 		setCode(pageType, rs, rowNumber); 		
 		setMobileApp(pageType, rs, rowNumber); 		
 		setFooterTab(pageType, rs, rowNumber); 		
 		setVersion(pageType, rs, rowNumber);

		return pageType;
	}
	
	protected PageType getPageType(){
		return new PageType();
	}		
		
	protected void setId(PageType pageType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PageTypeTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		pageType.setId(id);
	}
		
	protected void setName(PageType pageType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String name = rs.getString(PageTypeTable.COLUMN_NAME);
		
		if(name == null){
			//do nothing when nothing found in database
			return;
		}
		
		pageType.setName(name);
	}
		
	protected void setCode(PageType pageType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String code = rs.getString(PageTypeTable.COLUMN_CODE);
		
		if(code == null){
			//do nothing when nothing found in database
			return;
		}
		
		pageType.setCode(code);
	}
		 		
 	protected void setMobileApp(PageType pageType, ResultSet rs, int rowNumber) throws SQLException{
 		String mobileAppId = rs.getString(PageTypeTable.COLUMN_MOBILE_APP);
 		if( mobileAppId == null){
 			return;
 		}
 		if( mobileAppId.isEmpty()){
 			return;
 		}
 		MobileApp mobileApp = pageType.getMobileApp();
 		if( mobileApp != null ){
 			//if the root object 'pageType' already have the property, just set the id for it;
 			mobileApp.setId(mobileAppId);
 			
 			return;
 		}
 		pageType.setMobileApp(createEmptyMobileApp(mobileAppId));
 	}
 	
	protected void setFooterTab(PageType pageType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Boolean footerTab = rs.getBoolean(PageTypeTable.COLUMN_FOOTER_TAB);
		
		if(footerTab == null){
			//do nothing when nothing found in database
			return;
		}
		
		pageType.setFooterTab(footerTab);
	}
		
	protected void setVersion(PageType pageType, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PageTypeTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		pageType.setVersion(version);
	}
		
		

 	protected MobileApp  createEmptyMobileApp(String mobileAppId){
 		MobileApp mobileApp = new MobileApp();
 		mobileApp.setId(mobileAppId);
 		mobileApp.setVersion(Integer.MAX_VALUE);
 		return mobileApp;
 	}
 	
}


