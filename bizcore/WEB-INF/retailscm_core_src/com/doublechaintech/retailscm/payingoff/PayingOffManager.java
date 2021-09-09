
package com.doublechaintech.retailscm.payingoff;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
import java.util.List;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.RetailscmUserContext;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.BaseManager;
import com.doublechaintech.retailscm.SmartList;




public interface PayingOffManager extends BaseManager{

		

  List<PayingOff> searchPayingOffList(RetailscmUserContext ctx, PayingOffRequest pRequest);
  PayingOff searchPayingOff(RetailscmUserContext ctx, PayingOffRequest pRequest);
	public PayingOff createPayingOff(RetailscmUserContext userContext, String who,String paidForId,Date paidTime,BigDecimal amount) throws Exception;
	public PayingOff updatePayingOff(RetailscmUserContext userContext,String payingOffId, int payingOffVersion, String property, String newValueExpr,String [] tokensExpr) throws Exception;
	public PayingOff loadPayingOff(RetailscmUserContext userContext, String payingOffId, String [] tokensExpr) throws Exception;
	public void sendAllItems(RetailscmUserContext ctx) throws Exception ;
	public PayingOff internalSavePayingOff(RetailscmUserContext userContext, PayingOff payingOff) throws Exception;
	public PayingOff internalSavePayingOff(RetailscmUserContext userContext, PayingOff payingOff,Map<String,Object>option) throws Exception;

	public PayingOff transferToAnotherPaidFor(RetailscmUserContext userContext, String payingOffId, String anotherPaidForId)  throws Exception;
 

	public void delete(RetailscmUserContext userContext, String payingOffId, int version) throws Exception;
	public int deleteAll(RetailscmUserContext userContext, String secureCode ) throws Exception;
	public void onNewInstanceCreated(RetailscmUserContext userContext, PayingOff newCreated)throws Exception;
	public default void onUpdated(RetailscmUserContext userContext, PayingOff updated, Object actor, String methodName) throws Exception {};


	/*======================================================DATA MAINTENANCE===========================================================*/


	//public  EmployeeSalarySheetManager getEmployeeSalarySheetManager(RetailscmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance ,String [] tokensExpr)  throws Exception;

	public  PayingOff addEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeId, String currentSalaryGradeId, BigDecimal baseSalary, BigDecimal bonus, BigDecimal reward, BigDecimal personalTax, BigDecimal socialSecurity, BigDecimal housingFound, BigDecimal jobInsurance , String [] tokensExpr)  throws Exception;
	public  PayingOff removeEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion,String [] tokensExpr)  throws Exception;
	public  PayingOff updateEmployeeSalarySheet(RetailscmUserContext userContext, String payingOffId, String employeeSalarySheetId, int employeeSalarySheetVersion, String property, String newValueExpr,String [] tokensExpr)  throws Exception;

	/*

	*/


	public Object listByPaidFor(RetailscmUserContext userContext,String paidForId) throws Exception;
	public Object listPageByPaidFor(RetailscmUserContext userContext,String paidForId, int start, int count) throws Exception;
  




}


