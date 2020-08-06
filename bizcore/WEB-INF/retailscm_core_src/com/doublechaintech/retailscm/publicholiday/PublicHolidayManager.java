
package com.doublechaintech.retailscm.publicholiday;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface PublicHolidayManager extends BaseManager{

		

	public PublicHoliday createPublicHoliday(RetailscmUserContext userContext, String code,String companyId,String name,String description) throws Exception;
	public PublicHoliday updatePublicHoliday(RetailscmUserContext userContext,String publicHolidayId, int publicHolidayVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PublicHoliday loadPublicHoliday(RetailscmUserContext userContext, String publicHolidayId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public PublicHoliday internalSavePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday) throws Exception;
	public PublicHoliday internalSavePublicHoliday(RetailscmUserContext userContext, PublicHoliday publicHoliday,Map<String,Object>option) throws Exception;

	public PublicHoliday transferToAnotherCompany(RetailscmUserContext userContext, String publicHolidayId, String anotherCompanyId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String publicHolidayId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, PublicHoliday newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByCompany(RetailscmUserContext userContext,String companyId) throws Exception;
	public Object listPageByCompany(RetailscmUserContext userContext,String companyId, int start, int count) throws Exception;
  

}


