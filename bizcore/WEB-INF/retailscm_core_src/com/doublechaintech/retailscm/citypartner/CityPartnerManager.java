package com.doublechaintech.retailscm.citypartner;

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

public interface CityPartnerManager extends BaseManager {

  List<CityPartner> searchCityPartnerList(RetailscmUserContext ctx, CityPartnerRequest pRequest);

  CityPartner searchCityPartner(RetailscmUserContext ctx, CityPartnerRequest pRequest);

  public CityPartner createCityPartner(
      RetailscmUserContext userContext,
      String name,
      String mobile,
      String cityServiceCenterId,
      String description)
      throws Exception;

  public CityPartner updateCityPartner(
      RetailscmUserContext userContext,
      String cityPartnerId,
      int cityPartnerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  public CityPartner loadCityPartner(
      RetailscmUserContext userContext, String cityPartnerId, String[] tokensExpr) throws Exception;

  public void sendAllItems(RetailscmUserContext ctx) throws Exception;

  public CityPartner internalSaveCityPartner(
      RetailscmUserContext userContext, CityPartner cityPartner) throws Exception;

  public CityPartner internalSaveCityPartner(
      RetailscmUserContext userContext, CityPartner cityPartner, Map<String, Object> option)
      throws Exception;

  public CityPartner transferToAnotherCityServiceCenter(
      RetailscmUserContext userContext, String cityPartnerId, String anotherCityServiceCenterId)
      throws Exception;

  public void onNewInstanceCreated(RetailscmUserContext userContext, CityPartner newCreated)
      throws Exception;

  public default void onUpdated(
      RetailscmUserContext userContext, CityPartner updated, Object actor, String methodName)
      throws Exception {};

  /*======================================================DATA MAINTENANCE===========================================================*/

  // public  PotentialCustomerManager getPotentialCustomerManager(RetailscmUserContext userContext,
  // String cityPartnerId, String name, String mobile, String cityServiceCenterId, String
  // description ,String [] tokensExpr)  throws Exception;

  public CityPartner addPotentialCustomer(
      RetailscmUserContext userContext,
      String cityPartnerId,
      String name,
      String mobile,
      String cityServiceCenterId,
      String description,
      String[] tokensExpr)
      throws Exception;

  public CityPartner removePotentialCustomer(
      RetailscmUserContext userContext,
      String cityPartnerId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String[] tokensExpr)
      throws Exception;

  public CityPartner updatePotentialCustomer(
      RetailscmUserContext userContext,
      String cityPartnerId,
      String potentialCustomerId,
      int potentialCustomerVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  // public  PotentialCustomerContactManager getPotentialCustomerContactManager(RetailscmUserContext
  // userContext, String cityPartnerId, String name, Date contactDate, String contactMethod, String
  // potentialCustomerId, String contactToId, String description ,String [] tokensExpr)  throws
  // Exception;

  public CityPartner addPotentialCustomerContact(
      RetailscmUserContext userContext,
      String cityPartnerId,
      String name,
      Date contactDate,
      String contactMethod,
      String potentialCustomerId,
      String contactToId,
      String description,
      String[] tokensExpr)
      throws Exception;

  public CityPartner removePotentialCustomerContact(
      RetailscmUserContext userContext,
      String cityPartnerId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String[] tokensExpr)
      throws Exception;

  public CityPartner updatePotentialCustomerContact(
      RetailscmUserContext userContext,
      String cityPartnerId,
      String potentialCustomerContactId,
      int potentialCustomerContactVersion,
      String property,
      String newValueExpr,
      String[] tokensExpr)
      throws Exception;

  /*

  */

  public Object listByCityServiceCenter(
      RetailscmUserContext userContext, String cityServiceCenterId) throws Exception;

  public Object listPageByCityServiceCenter(
      RetailscmUserContext userContext, String cityServiceCenterId, int start, int count)
      throws Exception;
}
