
package com.doublechaintech.retailscm.view;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;

public interface ViewManager extends BaseManager{

		

	public View createView(RetailscmUserContext userContext, String who,String assessment,Date interviewTime) throws Exception;
	public View updateView(RetailscmUserContext userContext,String viewId, int viewVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public View loadView(RetailscmUserContext userContext, String viewId, String [] tokensExpr) throws Exception;
	public View internalSaveView(RetailscmUserContext userContext, View view) throws Exception;
	public View internalSaveView(RetailscmUserContext userContext, View view,Map<String,Object>option) throws Exception;



	public void delete(RetailscmUserContext userContext, String viewId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, View newCreated)throws Exception;

	/*======================================================DATA MAINTENANCE===========================================================*/




}


