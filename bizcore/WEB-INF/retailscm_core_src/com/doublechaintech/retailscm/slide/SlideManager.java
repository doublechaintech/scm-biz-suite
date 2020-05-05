
package com.doublechaintech.retailscm.slide;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface SlideManager extends BaseManager{

		

	public Slide createSlide(RetailscmUserContext userContext, String name,int displayOrder,String imageUrl,String videoUrl,String linkToUrl,String pageId) throws Exception;
	public Slide updateSlide(RetailscmUserContext userContext,String slideId, int slideVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public Slide loadSlide(RetailscmUserContext userContext, String slideId, String [] tokensExpr) throws Exception;
	public Slide internalSaveSlide(RetailscmUserContext userContext, Slide slide) throws Exception;
	public Slide internalSaveSlide(RetailscmUserContext userContext, Slide slide,Map<String,Object>option) throws Exception;

	public Slide transferToAnotherPage(RetailscmUserContext userContext, String slideId, String anotherPageId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String slideId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, Slide newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/



	public Object listByPage(RetailscmUserContext userContext,String pageId) throws Exception;
	public Object listPageByPage(RetailscmUserContext userContext,String pageId, int start, int count) throws Exception;
  

}


