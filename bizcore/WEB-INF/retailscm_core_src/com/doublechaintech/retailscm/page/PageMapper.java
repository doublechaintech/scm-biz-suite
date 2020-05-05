
package com.doublechaintech.retailscm.page;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.BaseRowMapper;
import com.doublechaintech.retailscm.mobileapp.MobileApp;
import com.doublechaintech.retailscm.pagetype.PageType;

public class PageMapper extends BaseRowMapper<Page>{
	
	protected Page internalMapRow(ResultSet rs, int rowNumber) throws SQLException{
		Page page = getPage();		
		 		
 		setId(page, rs, rowNumber); 		
 		setPageTitle(page, rs, rowNumber); 		
 		setLinkToUrl(page, rs, rowNumber); 		
 		setPageType(page, rs, rowNumber); 		
 		setDisplayOrder(page, rs, rowNumber); 		
 		setMobileApp(page, rs, rowNumber); 		
 		setVersion(page, rs, rowNumber);

		return page;
	}
	
	protected Page getPage(){
		return new Page();
	}		
		
	protected void setId(Page page, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String id = rs.getString(PageTable.COLUMN_ID);
		
		if(id == null){
			//do nothing when nothing found in database
			return;
		}
		
		page.setId(id);
	}
		
	protected void setPageTitle(Page page, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String pageTitle = rs.getString(PageTable.COLUMN_PAGE_TITLE);
		
		if(pageTitle == null){
			//do nothing when nothing found in database
			return;
		}
		
		page.setPageTitle(pageTitle);
	}
		
	protected void setLinkToUrl(Page page, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		String linkToUrl = rs.getString(PageTable.COLUMN_LINK_TO_URL);
		
		if(linkToUrl == null){
			//do nothing when nothing found in database
			return;
		}
		
		page.setLinkToUrl(linkToUrl);
	}
		 		
 	protected void setPageType(Page page, ResultSet rs, int rowNumber) throws SQLException{
 		String pageTypeId = rs.getString(PageTable.COLUMN_PAGE_TYPE);
 		if( pageTypeId == null){
 			return;
 		}
 		if( pageTypeId.isEmpty()){
 			return;
 		}
 		PageType pageType = page.getPageType();
 		if( pageType != null ){
 			//if the root object 'page' already have the property, just set the id for it;
 			pageType.setId(pageTypeId);
 			
 			return;
 		}
 		page.setPageType(createEmptyPageType(pageTypeId));
 	}
 	
	protected void setDisplayOrder(Page page, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer displayOrder = rs.getInt(PageTable.COLUMN_DISPLAY_ORDER);
		
		if(displayOrder == null){
			//do nothing when nothing found in database
			return;
		}
		
		page.setDisplayOrder(displayOrder);
	}
		 		
 	protected void setMobileApp(Page page, ResultSet rs, int rowNumber) throws SQLException{
 		String mobileAppId = rs.getString(PageTable.COLUMN_MOBILE_APP);
 		if( mobileAppId == null){
 			return;
 		}
 		if( mobileAppId.isEmpty()){
 			return;
 		}
 		MobileApp mobileApp = page.getMobileApp();
 		if( mobileApp != null ){
 			//if the root object 'page' already have the property, just set the id for it;
 			mobileApp.setId(mobileAppId);
 			
 			return;
 		}
 		page.setMobileApp(createEmptyMobileApp(mobileAppId));
 	}
 	
	protected void setVersion(Page page, ResultSet rs, int rowNumber) throws SQLException{
	
		//there will be issue when the type is double/int/long
		
		Integer version = rs.getInt(PageTable.COLUMN_VERSION);
		
		if(version == null){
			//do nothing when nothing found in database
			return;
		}
		
		page.setVersion(version);
	}
		
		

 	protected PageType  createEmptyPageType(String pageTypeId){
 		PageType pageType = new PageType();
 		pageType.setId(pageTypeId);
 		pageType.setVersion(Integer.MAX_VALUE);
 		return pageType;
 	}
 	
 	protected MobileApp  createEmptyMobileApp(String mobileAppId){
 		MobileApp mobileApp = new MobileApp();
 		mobileApp.setId(mobileAppId);
 		mobileApp.setVersion(Integer.MAX_VALUE);
 		return mobileApp;
 	}
 	
}


