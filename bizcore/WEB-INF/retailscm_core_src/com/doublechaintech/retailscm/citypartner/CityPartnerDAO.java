package com.doublechaintech.retailscm.citypartner;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;

import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContact;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomer;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;

import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterDAO;
import com.doublechaintech.retailscm.potentialcustomer.PotentialCustomerDAO;
import com.doublechaintech.retailscm.potentialcustomercontact.PotentialCustomerContactDAO;

public interface CityPartnerDAO extends BaseDAO {

  public SmartList<CityPartner> loadAll();

  public Stream<CityPartner> loadAllAsStream();

  public CityPartner load(String id, Map<String, Object> options) throws Exception;

  public void enhanceList(List<CityPartner> cityPartnerList);

  public void collectAndEnhance(BaseEntity ownerEntity);

  public void alias(List<BaseEntity> entityList);

  public CityPartner present(CityPartner cityPartner, Map<String, Object> options) throws Exception;

  public CityPartner clone(String id, Map<String, Object> options) throws Exception;

  public CityPartner save(CityPartner cityPartner, Map<String, Object> options);

  public SmartList<CityPartner> saveCityPartnerList(
      SmartList<CityPartner> cityPartnerList, Map<String, Object> options);

  public SmartList<CityPartner> removeCityPartnerList(
      SmartList<CityPartner> cityPartnerList, Map<String, Object> options);

  public SmartList<CityPartner> findCityPartnerWithKey(
      MultipleAccessKey key, Map<String, Object> options);

  public int countCityPartnerWithKey(MultipleAccessKey key, Map<String, Object> options);

  public Map<String, Integer> countCityPartnerWithGroupKey(
      String groupKey, MultipleAccessKey filterKey, Map<String, Object> options);

  public CityPartner disconnectFromAll(String cityPartnerId, int version) throws Exception;

  public void resetNextId();

  public PotentialCustomerDAO getPotentialCustomerDAO();

  public PotentialCustomerContactDAO getPotentialCustomerContactDAO();

  public SmartList<CityPartner> requestCandidateCityPartnerForPotentialCustomer(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public SmartList<CityPartner> requestCandidateCityPartnerForPotentialCustomerContact(
      RetailscmUserContext userContext,
      String ownerClass,
      String id,
      String filterKey,
      int pageNo,
      int pageSize)
      throws Exception;

  public CityPartner planToRemovePotentialCustomerList(
      CityPartner cityPartner, String potentialCustomerIds[], Map<String, Object> options)
      throws Exception;

  // disconnect CityPartner with city_service_center in PotentialCustomer
  public CityPartner planToRemovePotentialCustomerListWithCityServiceCenter(
      CityPartner cityPartner, String cityServiceCenterId, Map<String, Object> options)
      throws Exception;

  public int countPotentialCustomerListWithCityServiceCenter(
      String cityPartnerId, String cityServiceCenterId, Map<String, Object> options)
      throws Exception;

  public CityPartner planToRemovePotentialCustomerContactList(
      CityPartner cityPartner, String potentialCustomerContactIds[], Map<String, Object> options)
      throws Exception;

  // disconnect CityPartner with potential_customer in PotentialCustomerContact
  public CityPartner planToRemovePotentialCustomerContactListWithPotentialCustomer(
      CityPartner cityPartner, String potentialCustomerId, Map<String, Object> options)
      throws Exception;

  public int countPotentialCustomerContactListWithPotentialCustomer(
      String cityPartnerId, String potentialCustomerId, Map<String, Object> options)
      throws Exception;

  // disconnect CityPartner with contact_to in PotentialCustomerContact
  public CityPartner planToRemovePotentialCustomerContactListWithContactTo(
      CityPartner cityPartner, String contactToId, Map<String, Object> options) throws Exception;

  public int countPotentialCustomerContactListWithContactTo(
      String cityPartnerId, String contactToId, Map<String, Object> options) throws Exception;

  public SmartList<CityPartner> queryList(String sql, Object... parameters);

  public List<String> queryIdList(String sql, Object... parameters);

  public Stream<CityPartner> queryStream(String sql, Object... parameters);

  public int count(String sql, Object... parameters);

  public CandidateCityPartner executeCandidatesQuery(
      CandidateQuery query, String sql, Object... parmeters) throws Exception;

  public SmartList<CityPartner> findCityPartnerByCityServiceCenter(
      String retailStoreCityServiceCenterId, Map<String, Object> options);

  public int countCityPartnerByCityServiceCenter(
      String retailStoreCityServiceCenterId, Map<String, Object> options);

  public Map<String, Integer> countCityPartnerByCityServiceCenterIds(
      String[] ids, Map<String, Object> options);

  public SmartList<CityPartner> findCityPartnerByCityServiceCenter(
      String retailStoreCityServiceCenterId, int start, int count, Map<String, Object> options);

  public void analyzeCityPartnerByCityServiceCenter(
      SmartList<CityPartner> resultList,
      String retailStoreCityServiceCenterId,
      Map<String, Object> options);

  List<CityPartner> search(CityPartnerRequest pRequest);
}
