package com.doublechaintech.retailscm.retailstorecountrycenter;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.catalog.Catalog;
import com.doublechaintech.retailscm.companytraining.CompanyTraining;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.instructor.Instructor;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartment;
import com.doublechaintech.retailscm.occupationtype.OccupationType;
import com.doublechaintech.retailscm.publicholiday.PublicHoliday;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityType;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.salarygrade.SalaryGrade;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.terminationreason.TerminationReason;
import com.doublechaintech.retailscm.terminationtype.TerminationType;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseType;
import com.doublechaintech.retailscm.transportfleet.TransportFleet;
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import com.doublechaintech.retailscm.catalog.CatalogRequest;
import com.doublechaintech.retailscm.companytraining.CompanyTrainingRequest;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.instructor.InstructorRequest;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest;
import com.doublechaintech.retailscm.leavetype.LeaveTypeRequest;
import com.doublechaintech.retailscm.levelonedepartment.LevelOneDepartmentRequest;
import com.doublechaintech.retailscm.occupationtype.OccupationTypeRequest;
import com.doublechaintech.retailscm.publicholiday.PublicHolidayRequest;
import com.doublechaintech.retailscm.responsibilitytype.ResponsibilityTypeRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenterRequest;
import com.doublechaintech.retailscm.salarygrade.SalaryGradeRequest;
import com.doublechaintech.retailscm.skilltype.SkillTypeRequest;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import com.doublechaintech.retailscm.terminationreason.TerminationReasonRequest;
import com.doublechaintech.retailscm.terminationtype.TerminationTypeRequest;
import com.doublechaintech.retailscm.trainingcoursetype.TrainingCourseTypeRequest;
import com.doublechaintech.retailscm.transportfleet.TransportFleetRequest;
import com.doublechaintech.retailscm.warehouse.WarehouseRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter.*;

public class RetailStoreCountryCenterRequest extends BaseRequest<RetailStoreCountryCenter> {
    public static RetailStoreCountryCenterRequest newInstance() {
        return new RetailStoreCountryCenterRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreCountryCenter";
    }

    public RetailStoreCountryCenterRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreCountryCenterRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreCountryCenterRequest selectAll() {return this.selectId().selectName().selectServiceNumber().selectFounded().selectWebSite().selectAddress().selectOperatedBy().selectLegalRepresentative().selectDescription().selectVersion();
    }

    public RetailStoreCountryCenterRequest selectSelf() {return this.selectId().selectName().selectServiceNumber().selectFounded().selectWebSite().selectAddress().selectOperatedBy().selectLegalRepresentative().selectDescription().selectVersion();
    }

    public RetailStoreCountryCenterRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreCountryCenterRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreCountryCenterRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreCountryCenterRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreCountryCenterRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreCountryCenterRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByServiceNumber(String serviceNumber) {
          
          if (serviceNumber == null) {
              return this;
          }
          
          return filterByServiceNumber(QueryOperator.EQUAL, serviceNumber);
      }
    

      public RetailStoreCountryCenterRequest filterByServiceNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getServiceNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectServiceNumber(){
          return select(SERVICE_NUMBER_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectServiceNumber(){
          return unselect(SERVICE_NUMBER_PROPERTY);
      }

      public SearchCriteria getServiceNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SERVICE_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByServiceNumber(boolean asc){
          addOrderBy(SERVICE_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public RetailStoreCountryCenterRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByWebSite(String webSite) {
          
          if (webSite == null) {
              return this;
          }
          
          return filterByWebSite(QueryOperator.EQUAL, webSite);
      }
    

      public RetailStoreCountryCenterRequest filterByWebSite(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getWebSiteSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectWebSite(){
          return select(WEB_SITE_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectWebSite(){
          return unselect(WEB_SITE_PROPERTY);
      }

      public SearchCriteria getWebSiteSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(WEB_SITE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByWebSite(boolean asc){
          addOrderBy(WEB_SITE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByAddress(String address) {
          
          if (address == null) {
              return this;
          }
          
          return filterByAddress(QueryOperator.EQUAL, address);
      }
    

      public RetailStoreCountryCenterRequest filterByAddress(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAddressSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectAddress(){
          return select(ADDRESS_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectAddress(){
          return unselect(ADDRESS_PROPERTY);
      }

      public SearchCriteria getAddressSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ADDRESS_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByAddress(boolean asc){
          addOrderBy(ADDRESS_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByOperatedBy(String operatedBy) {
          
          if (operatedBy == null) {
              return this;
          }
          
          return filterByOperatedBy(QueryOperator.EQUAL, operatedBy);
      }
    

      public RetailStoreCountryCenterRequest filterByOperatedBy(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getOperatedBySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectOperatedBy(){
          return select(OPERATED_BY_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectOperatedBy(){
          return unselect(OPERATED_BY_PROPERTY);
      }

      public SearchCriteria getOperatedBySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(OPERATED_BY_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByOperatedBy(boolean asc){
          addOrderBy(OPERATED_BY_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByLegalRepresentative(String legalRepresentative) {
          
          if (legalRepresentative == null) {
              return this;
          }
          
          return filterByLegalRepresentative(QueryOperator.EQUAL, legalRepresentative);
      }
    

      public RetailStoreCountryCenterRequest filterByLegalRepresentative(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLegalRepresentativeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectLegalRepresentative(){
          return select(LEGAL_REPRESENTATIVE_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectLegalRepresentative(){
          return unselect(LEGAL_REPRESENTATIVE_PROPERTY);
      }

      public SearchCriteria getLegalRepresentativeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LEGAL_REPRESENTATIVE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByLegalRepresentative(boolean asc){
          addOrderBy(LEGAL_REPRESENTATIVE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public RetailStoreCountryCenterRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreCountryCenterRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreCountryCenterRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreCountryCenterRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreCountryCenterRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreCountryCenterRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  


  

    public RetailStoreCountryCenterRequest hasCatalog() {
      return hasCatalog(CatalogRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasCatalog(CatalogRequest catalog) {
        return hasCatalog(catalog, catalogList -> catalogList.stream().map(Catalog::getOwner).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasCatalog(CatalogRequest catalog, IDRefine<Catalog> idRefine) {
        catalog.select(Catalog.OWNER_PROPERTY);
        return addSearchCriteria(createCatalogCriteria(catalog, idRefine));
    }

    public SearchCriteria createCatalogCriteria(CatalogRequest catalog, IDRefine<Catalog> idRefine){
       return new RefinedIdInCriteria(catalog, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectCatalogList(CatalogRequest catalog) {
        selectChild(Catalog.OWNER_PROPERTY, catalog);
        return this;
    }

    public RetailStoreCountryCenterRequest selectCatalogList() {
        return selectCatalogList(CatalogRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectCatalogList(){
        unselectChild(Catalog.OWNER_PROPERTY, Catalog.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter() {
      return hasRetailStoreProvinceCenter(RetailStoreProvinceCenterRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter(RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
        return hasRetailStoreProvinceCenter(retailStoreProvinceCenter, retailStoreProvinceCenterList -> retailStoreProvinceCenterList.stream().map(RetailStoreProvinceCenter::getCountry).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasRetailStoreProvinceCenter(RetailStoreProvinceCenterRequest retailStoreProvinceCenter, IDRefine<RetailStoreProvinceCenter> idRefine) {
        retailStoreProvinceCenter.select(RetailStoreProvinceCenter.COUNTRY_PROPERTY);
        return addSearchCriteria(createRetailStoreProvinceCenterCriteria(retailStoreProvinceCenter, idRefine));
    }

    public SearchCriteria createRetailStoreProvinceCenterCriteria(RetailStoreProvinceCenterRequest retailStoreProvinceCenter, IDRefine<RetailStoreProvinceCenter> idRefine){
       return new RefinedIdInCriteria(retailStoreProvinceCenter, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectRetailStoreProvinceCenterList(RetailStoreProvinceCenterRequest retailStoreProvinceCenter) {
        selectChild(RetailStoreProvinceCenter.COUNTRY_PROPERTY, retailStoreProvinceCenter);
        return this;
    }

    public RetailStoreCountryCenterRequest selectRetailStoreProvinceCenterList() {
        return selectRetailStoreProvinceCenterList(RetailStoreProvinceCenterRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectRetailStoreProvinceCenterList(){
        unselectChild(RetailStoreProvinceCenter.COUNTRY_PROPERTY, RetailStoreProvinceCenter.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasRetailStore() {
      return hasRetailStore(RetailStoreRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasRetailStore(RetailStoreRequest retailStore) {
        return hasRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getRetailStoreCountryCenter).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        retailStore.select(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine){
       return new RefinedIdInCriteria(retailStore, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectRetailStoreList(RetailStoreRequest retailStore) {
        selectChild(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStore);
        return this;
    }

    public RetailStoreCountryCenterRequest selectRetailStoreList() {
        return selectRetailStoreList(RetailStoreRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectRetailStoreList(){
        unselectChild(RetailStore.RETAIL_STORE_COUNTRY_CENTER_PROPERTY, RetailStore.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasRetailStoreMember() {
      return hasRetailStoreMember(RetailStoreMemberRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasRetailStoreMember(RetailStoreMemberRequest retailStoreMember) {
        return hasRetailStoreMember(retailStoreMember, retailStoreMemberList -> retailStoreMemberList.stream().map(RetailStoreMember::getOwner).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasRetailStoreMember(RetailStoreMemberRequest retailStoreMember, IDRefine<RetailStoreMember> idRefine) {
        retailStoreMember.select(RetailStoreMember.OWNER_PROPERTY);
        return addSearchCriteria(createRetailStoreMemberCriteria(retailStoreMember, idRefine));
    }

    public SearchCriteria createRetailStoreMemberCriteria(RetailStoreMemberRequest retailStoreMember, IDRefine<RetailStoreMember> idRefine){
       return new RefinedIdInCriteria(retailStoreMember, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectRetailStoreMemberList(RetailStoreMemberRequest retailStoreMember) {
        selectChild(RetailStoreMember.OWNER_PROPERTY, retailStoreMember);
        return this;
    }

    public RetailStoreCountryCenterRequest selectRetailStoreMemberList() {
        return selectRetailStoreMemberList(RetailStoreMemberRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectRetailStoreMemberList(){
        unselectChild(RetailStoreMember.OWNER_PROPERTY, RetailStoreMember.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasGoodsSupplier() {
      return hasGoodsSupplier(GoodsSupplierRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasGoodsSupplier(GoodsSupplierRequest goodsSupplier) {
        return hasGoodsSupplier(goodsSupplier, goodsSupplierList -> goodsSupplierList.stream().map(GoodsSupplier::getBelongTo).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasGoodsSupplier(GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine) {
        goodsSupplier.select(GoodsSupplier.BELONG_TO_PROPERTY);
        return addSearchCriteria(createGoodsSupplierCriteria(goodsSupplier, idRefine));
    }

    public SearchCriteria createGoodsSupplierCriteria(GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine){
       return new RefinedIdInCriteria(goodsSupplier, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectGoodsSupplierList(GoodsSupplierRequest goodsSupplier) {
        selectChild(GoodsSupplier.BELONG_TO_PROPERTY, goodsSupplier);
        return this;
    }

    public RetailStoreCountryCenterRequest selectGoodsSupplierList() {
        return selectGoodsSupplierList(GoodsSupplierRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectGoodsSupplierList(){
        unselectChild(GoodsSupplier.BELONG_TO_PROPERTY, GoodsSupplier.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasSupplyOrder() {
      return hasSupplyOrder(SupplyOrderRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasSupplyOrder(SupplyOrderRequest supplyOrder) {
        return hasSupplyOrder(supplyOrder, supplyOrderList -> supplyOrderList.stream().map(SupplyOrder::getBuyer).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasSupplyOrder(SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine) {
        supplyOrder.select(SupplyOrder.BUYER_PROPERTY);
        return addSearchCriteria(createSupplyOrderCriteria(supplyOrder, idRefine));
    }

    public SearchCriteria createSupplyOrderCriteria(SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine){
       return new RefinedIdInCriteria(supplyOrder, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectSupplyOrderList(SupplyOrderRequest supplyOrder) {
        selectChild(SupplyOrder.BUYER_PROPERTY, supplyOrder);
        return this;
    }

    public RetailStoreCountryCenterRequest selectSupplyOrderList() {
        return selectSupplyOrderList(SupplyOrderRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectSupplyOrderList(){
        unselectChild(SupplyOrder.BUYER_PROPERTY, SupplyOrder.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasRetailStoreOrder() {
      return hasRetailStoreOrder(RetailStoreOrderRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
        return hasRetailStoreOrder(retailStoreOrder, retailStoreOrderList -> retailStoreOrderList.stream().map(RetailStoreOrder::getSeller).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
        retailStoreOrder.select(RetailStoreOrder.SELLER_PROPERTY);
        return addSearchCriteria(createRetailStoreOrderCriteria(retailStoreOrder, idRefine));
    }

    public SearchCriteria createRetailStoreOrderCriteria(RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine){
       return new RefinedIdInCriteria(retailStoreOrder, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectRetailStoreOrderList(RetailStoreOrderRequest retailStoreOrder) {
        selectChild(RetailStoreOrder.SELLER_PROPERTY, retailStoreOrder);
        return this;
    }

    public RetailStoreCountryCenterRequest selectRetailStoreOrderList() {
        return selectRetailStoreOrderList(RetailStoreOrderRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectRetailStoreOrderList(){
        unselectChild(RetailStoreOrder.SELLER_PROPERTY, RetailStoreOrder.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasWarehouse() {
      return hasWarehouse(WarehouseRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasWarehouse(WarehouseRequest warehouse) {
        return hasWarehouse(warehouse, warehouseList -> warehouseList.stream().map(Warehouse::getOwner).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasWarehouse(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine) {
        warehouse.select(Warehouse.OWNER_PROPERTY);
        return addSearchCriteria(createWarehouseCriteria(warehouse, idRefine));
    }

    public SearchCriteria createWarehouseCriteria(WarehouseRequest warehouse, IDRefine<Warehouse> idRefine){
       return new RefinedIdInCriteria(warehouse, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectWarehouseList(WarehouseRequest warehouse) {
        selectChild(Warehouse.OWNER_PROPERTY, warehouse);
        return this;
    }

    public RetailStoreCountryCenterRequest selectWarehouseList() {
        return selectWarehouseList(WarehouseRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectWarehouseList(){
        unselectChild(Warehouse.OWNER_PROPERTY, Warehouse.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasTransportFleet() {
      return hasTransportFleet(TransportFleetRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasTransportFleet(TransportFleetRequest transportFleet) {
        return hasTransportFleet(transportFleet, transportFleetList -> transportFleetList.stream().map(TransportFleet::getOwner).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasTransportFleet(TransportFleetRequest transportFleet, IDRefine<TransportFleet> idRefine) {
        transportFleet.select(TransportFleet.OWNER_PROPERTY);
        return addSearchCriteria(createTransportFleetCriteria(transportFleet, idRefine));
    }

    public SearchCriteria createTransportFleetCriteria(TransportFleetRequest transportFleet, IDRefine<TransportFleet> idRefine){
       return new RefinedIdInCriteria(transportFleet, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectTransportFleetList(TransportFleetRequest transportFleet) {
        selectChild(TransportFleet.OWNER_PROPERTY, transportFleet);
        return this;
    }

    public RetailStoreCountryCenterRequest selectTransportFleetList() {
        return selectTransportFleetList(TransportFleetRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectTransportFleetList(){
        unselectChild(TransportFleet.OWNER_PROPERTY, TransportFleet.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasAccountSet() {
      return hasAccountSet(AccountSetRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasAccountSet(AccountSetRequest accountSet) {
        return hasAccountSet(accountSet, accountSetList -> accountSetList.stream().map(AccountSet::getCountryCenter).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasAccountSet(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
        accountSet.select(AccountSet.COUNTRY_CENTER_PROPERTY);
        return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
    }

    public SearchCriteria createAccountSetCriteria(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine){
       return new RefinedIdInCriteria(accountSet, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectAccountSetList(AccountSetRequest accountSet) {
        selectChild(AccountSet.COUNTRY_CENTER_PROPERTY, accountSet);
        return this;
    }

    public RetailStoreCountryCenterRequest selectAccountSetList() {
        return selectAccountSetList(AccountSetRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectAccountSetList(){
        unselectChild(AccountSet.COUNTRY_CENTER_PROPERTY, AccountSet.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasLevelOneDepartment() {
      return hasLevelOneDepartment(LevelOneDepartmentRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasLevelOneDepartment(LevelOneDepartmentRequest levelOneDepartment) {
        return hasLevelOneDepartment(levelOneDepartment, levelOneDepartmentList -> levelOneDepartmentList.stream().map(LevelOneDepartment::getBelongsTo).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasLevelOneDepartment(LevelOneDepartmentRequest levelOneDepartment, IDRefine<LevelOneDepartment> idRefine) {
        levelOneDepartment.select(LevelOneDepartment.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createLevelOneDepartmentCriteria(levelOneDepartment, idRefine));
    }

    public SearchCriteria createLevelOneDepartmentCriteria(LevelOneDepartmentRequest levelOneDepartment, IDRefine<LevelOneDepartment> idRefine){
       return new RefinedIdInCriteria(levelOneDepartment, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectLevelOneDepartmentList(LevelOneDepartmentRequest levelOneDepartment) {
        selectChild(LevelOneDepartment.BELONGS_TO_PROPERTY, levelOneDepartment);
        return this;
    }

    public RetailStoreCountryCenterRequest selectLevelOneDepartmentList() {
        return selectLevelOneDepartmentList(LevelOneDepartmentRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectLevelOneDepartmentList(){
        unselectChild(LevelOneDepartment.BELONGS_TO_PROPERTY, LevelOneDepartment.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasSkillType() {
      return hasSkillType(SkillTypeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasSkillType(SkillTypeRequest skillType) {
        return hasSkillType(skillType, skillTypeList -> skillTypeList.stream().map(SkillType::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasSkillType(SkillTypeRequest skillType, IDRefine<SkillType> idRefine) {
        skillType.select(SkillType.COMPANY_PROPERTY);
        return addSearchCriteria(createSkillTypeCriteria(skillType, idRefine));
    }

    public SearchCriteria createSkillTypeCriteria(SkillTypeRequest skillType, IDRefine<SkillType> idRefine){
       return new RefinedIdInCriteria(skillType, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectSkillTypeList(SkillTypeRequest skillType) {
        selectChild(SkillType.COMPANY_PROPERTY, skillType);
        return this;
    }

    public RetailStoreCountryCenterRequest selectSkillTypeList() {
        return selectSkillTypeList(SkillTypeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectSkillTypeList(){
        unselectChild(SkillType.COMPANY_PROPERTY, SkillType.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasResponsibilityType() {
      return hasResponsibilityType(ResponsibilityTypeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasResponsibilityType(ResponsibilityTypeRequest responsibilityType) {
        return hasResponsibilityType(responsibilityType, responsibilityTypeList -> responsibilityTypeList.stream().map(ResponsibilityType::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasResponsibilityType(ResponsibilityTypeRequest responsibilityType, IDRefine<ResponsibilityType> idRefine) {
        responsibilityType.select(ResponsibilityType.COMPANY_PROPERTY);
        return addSearchCriteria(createResponsibilityTypeCriteria(responsibilityType, idRefine));
    }

    public SearchCriteria createResponsibilityTypeCriteria(ResponsibilityTypeRequest responsibilityType, IDRefine<ResponsibilityType> idRefine){
       return new RefinedIdInCriteria(responsibilityType, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectResponsibilityTypeList(ResponsibilityTypeRequest responsibilityType) {
        selectChild(ResponsibilityType.COMPANY_PROPERTY, responsibilityType);
        return this;
    }

    public RetailStoreCountryCenterRequest selectResponsibilityTypeList() {
        return selectResponsibilityTypeList(ResponsibilityTypeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectResponsibilityTypeList(){
        unselectChild(ResponsibilityType.COMPANY_PROPERTY, ResponsibilityType.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasTerminationReason() {
      return hasTerminationReason(TerminationReasonRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasTerminationReason(TerminationReasonRequest terminationReason) {
        return hasTerminationReason(terminationReason, terminationReasonList -> terminationReasonList.stream().map(TerminationReason::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasTerminationReason(TerminationReasonRequest terminationReason, IDRefine<TerminationReason> idRefine) {
        terminationReason.select(TerminationReason.COMPANY_PROPERTY);
        return addSearchCriteria(createTerminationReasonCriteria(terminationReason, idRefine));
    }

    public SearchCriteria createTerminationReasonCriteria(TerminationReasonRequest terminationReason, IDRefine<TerminationReason> idRefine){
       return new RefinedIdInCriteria(terminationReason, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectTerminationReasonList(TerminationReasonRequest terminationReason) {
        selectChild(TerminationReason.COMPANY_PROPERTY, terminationReason);
        return this;
    }

    public RetailStoreCountryCenterRequest selectTerminationReasonList() {
        return selectTerminationReasonList(TerminationReasonRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectTerminationReasonList(){
        unselectChild(TerminationReason.COMPANY_PROPERTY, TerminationReason.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasTerminationType() {
      return hasTerminationType(TerminationTypeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasTerminationType(TerminationTypeRequest terminationType) {
        return hasTerminationType(terminationType, terminationTypeList -> terminationTypeList.stream().map(TerminationType::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasTerminationType(TerminationTypeRequest terminationType, IDRefine<TerminationType> idRefine) {
        terminationType.select(TerminationType.COMPANY_PROPERTY);
        return addSearchCriteria(createTerminationTypeCriteria(terminationType, idRefine));
    }

    public SearchCriteria createTerminationTypeCriteria(TerminationTypeRequest terminationType, IDRefine<TerminationType> idRefine){
       return new RefinedIdInCriteria(terminationType, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectTerminationTypeList(TerminationTypeRequest terminationType) {
        selectChild(TerminationType.COMPANY_PROPERTY, terminationType);
        return this;
    }

    public RetailStoreCountryCenterRequest selectTerminationTypeList() {
        return selectTerminationTypeList(TerminationTypeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectTerminationTypeList(){
        unselectChild(TerminationType.COMPANY_PROPERTY, TerminationType.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasOccupationType() {
      return hasOccupationType(OccupationTypeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasOccupationType(OccupationTypeRequest occupationType) {
        return hasOccupationType(occupationType, occupationTypeList -> occupationTypeList.stream().map(OccupationType::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasOccupationType(OccupationTypeRequest occupationType, IDRefine<OccupationType> idRefine) {
        occupationType.select(OccupationType.COMPANY_PROPERTY);
        return addSearchCriteria(createOccupationTypeCriteria(occupationType, idRefine));
    }

    public SearchCriteria createOccupationTypeCriteria(OccupationTypeRequest occupationType, IDRefine<OccupationType> idRefine){
       return new RefinedIdInCriteria(occupationType, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectOccupationTypeList(OccupationTypeRequest occupationType) {
        selectChild(OccupationType.COMPANY_PROPERTY, occupationType);
        return this;
    }

    public RetailStoreCountryCenterRequest selectOccupationTypeList() {
        return selectOccupationTypeList(OccupationTypeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectOccupationTypeList(){
        unselectChild(OccupationType.COMPANY_PROPERTY, OccupationType.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasLeaveType() {
      return hasLeaveType(LeaveTypeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasLeaveType(LeaveTypeRequest leaveType) {
        return hasLeaveType(leaveType, leaveTypeList -> leaveTypeList.stream().map(LeaveType::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasLeaveType(LeaveTypeRequest leaveType, IDRefine<LeaveType> idRefine) {
        leaveType.select(LeaveType.COMPANY_PROPERTY);
        return addSearchCriteria(createLeaveTypeCriteria(leaveType, idRefine));
    }

    public SearchCriteria createLeaveTypeCriteria(LeaveTypeRequest leaveType, IDRefine<LeaveType> idRefine){
       return new RefinedIdInCriteria(leaveType, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectLeaveTypeList(LeaveTypeRequest leaveType) {
        selectChild(LeaveType.COMPANY_PROPERTY, leaveType);
        return this;
    }

    public RetailStoreCountryCenterRequest selectLeaveTypeList() {
        return selectLeaveTypeList(LeaveTypeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectLeaveTypeList(){
        unselectChild(LeaveType.COMPANY_PROPERTY, LeaveType.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasSalaryGrade() {
      return hasSalaryGrade(SalaryGradeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasSalaryGrade(SalaryGradeRequest salaryGrade) {
        return hasSalaryGrade(salaryGrade, salaryGradeList -> salaryGradeList.stream().map(SalaryGrade::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasSalaryGrade(SalaryGradeRequest salaryGrade, IDRefine<SalaryGrade> idRefine) {
        salaryGrade.select(SalaryGrade.COMPANY_PROPERTY);
        return addSearchCriteria(createSalaryGradeCriteria(salaryGrade, idRefine));
    }

    public SearchCriteria createSalaryGradeCriteria(SalaryGradeRequest salaryGrade, IDRefine<SalaryGrade> idRefine){
       return new RefinedIdInCriteria(salaryGrade, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectSalaryGradeList(SalaryGradeRequest salaryGrade) {
        selectChild(SalaryGrade.COMPANY_PROPERTY, salaryGrade);
        return this;
    }

    public RetailStoreCountryCenterRequest selectSalaryGradeList() {
        return selectSalaryGradeList(SalaryGradeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectSalaryGradeList(){
        unselectChild(SalaryGrade.COMPANY_PROPERTY, SalaryGrade.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasInterviewType() {
      return hasInterviewType(InterviewTypeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasInterviewType(InterviewTypeRequest interviewType) {
        return hasInterviewType(interviewType, interviewTypeList -> interviewTypeList.stream().map(InterviewType::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasInterviewType(InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine) {
        interviewType.select(InterviewType.COMPANY_PROPERTY);
        return addSearchCriteria(createInterviewTypeCriteria(interviewType, idRefine));
    }

    public SearchCriteria createInterviewTypeCriteria(InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine){
       return new RefinedIdInCriteria(interviewType, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectInterviewTypeList(InterviewTypeRequest interviewType) {
        selectChild(InterviewType.COMPANY_PROPERTY, interviewType);
        return this;
    }

    public RetailStoreCountryCenterRequest selectInterviewTypeList() {
        return selectInterviewTypeList(InterviewTypeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectInterviewTypeList(){
        unselectChild(InterviewType.COMPANY_PROPERTY, InterviewType.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasTrainingCourseType() {
      return hasTrainingCourseType(TrainingCourseTypeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasTrainingCourseType(TrainingCourseTypeRequest trainingCourseType) {
        return hasTrainingCourseType(trainingCourseType, trainingCourseTypeList -> trainingCourseTypeList.stream().map(TrainingCourseType::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasTrainingCourseType(TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine) {
        trainingCourseType.select(TrainingCourseType.COMPANY_PROPERTY);
        return addSearchCriteria(createTrainingCourseTypeCriteria(trainingCourseType, idRefine));
    }

    public SearchCriteria createTrainingCourseTypeCriteria(TrainingCourseTypeRequest trainingCourseType, IDRefine<TrainingCourseType> idRefine){
       return new RefinedIdInCriteria(trainingCourseType, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectTrainingCourseTypeList(TrainingCourseTypeRequest trainingCourseType) {
        selectChild(TrainingCourseType.COMPANY_PROPERTY, trainingCourseType);
        return this;
    }

    public RetailStoreCountryCenterRequest selectTrainingCourseTypeList() {
        return selectTrainingCourseTypeList(TrainingCourseTypeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectTrainingCourseTypeList(){
        unselectChild(TrainingCourseType.COMPANY_PROPERTY, TrainingCourseType.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasPublicHoliday() {
      return hasPublicHoliday(PublicHolidayRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasPublicHoliday(PublicHolidayRequest publicHoliday) {
        return hasPublicHoliday(publicHoliday, publicHolidayList -> publicHolidayList.stream().map(PublicHoliday::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasPublicHoliday(PublicHolidayRequest publicHoliday, IDRefine<PublicHoliday> idRefine) {
        publicHoliday.select(PublicHoliday.COMPANY_PROPERTY);
        return addSearchCriteria(createPublicHolidayCriteria(publicHoliday, idRefine));
    }

    public SearchCriteria createPublicHolidayCriteria(PublicHolidayRequest publicHoliday, IDRefine<PublicHoliday> idRefine){
       return new RefinedIdInCriteria(publicHoliday, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectPublicHolidayList(PublicHolidayRequest publicHoliday) {
        selectChild(PublicHoliday.COMPANY_PROPERTY, publicHoliday);
        return this;
    }

    public RetailStoreCountryCenterRequest selectPublicHolidayList() {
        return selectPublicHolidayList(PublicHolidayRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectPublicHolidayList(){
        unselectChild(PublicHoliday.COMPANY_PROPERTY, PublicHoliday.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasEmployee() {
      return hasEmployee(EmployeeRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasEmployee(EmployeeRequest employee) {
        return hasEmployee(employee, employeeList -> employeeList.stream().map(Employee::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        employee.select(Employee.COMPANY_PROPERTY);
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine){
       return new RefinedIdInCriteria(employee, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectEmployeeList(EmployeeRequest employee) {
        selectChild(Employee.COMPANY_PROPERTY, employee);
        return this;
    }

    public RetailStoreCountryCenterRequest selectEmployeeList() {
        return selectEmployeeList(EmployeeRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectEmployeeList(){
        unselectChild(Employee.COMPANY_PROPERTY, Employee.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasInstructor() {
      return hasInstructor(InstructorRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasInstructor(InstructorRequest instructor) {
        return hasInstructor(instructor, instructorList -> instructorList.stream().map(Instructor::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasInstructor(InstructorRequest instructor, IDRefine<Instructor> idRefine) {
        instructor.select(Instructor.COMPANY_PROPERTY);
        return addSearchCriteria(createInstructorCriteria(instructor, idRefine));
    }

    public SearchCriteria createInstructorCriteria(InstructorRequest instructor, IDRefine<Instructor> idRefine){
       return new RefinedIdInCriteria(instructor, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectInstructorList(InstructorRequest instructor) {
        selectChild(Instructor.COMPANY_PROPERTY, instructor);
        return this;
    }

    public RetailStoreCountryCenterRequest selectInstructorList() {
        return selectInstructorList(InstructorRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectInstructorList(){
        unselectChild(Instructor.COMPANY_PROPERTY, Instructor.class);
        return this;
    }
  

    public RetailStoreCountryCenterRequest hasCompanyTraining() {
      return hasCompanyTraining(CompanyTrainingRequest.newInstance());
    }

    public RetailStoreCountryCenterRequest hasCompanyTraining(CompanyTrainingRequest companyTraining) {
        return hasCompanyTraining(companyTraining, companyTrainingList -> companyTrainingList.stream().map(CompanyTraining::getCompany).map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreCountryCenterRequest hasCompanyTraining(CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine) {
        companyTraining.select(CompanyTraining.COMPANY_PROPERTY);
        return addSearchCriteria(createCompanyTrainingCriteria(companyTraining, idRefine));
    }

    public SearchCriteria createCompanyTrainingCriteria(CompanyTrainingRequest companyTraining, IDRefine<CompanyTraining> idRefine){
       return new RefinedIdInCriteria(companyTraining, ID_PROPERTY, idRefine);
    }

    public RetailStoreCountryCenterRequest selectCompanyTrainingList(CompanyTrainingRequest companyTraining) {
        selectChild(CompanyTraining.COMPANY_PROPERTY, companyTraining);
        return this;
    }

    public RetailStoreCountryCenterRequest selectCompanyTrainingList() {
        return selectCompanyTrainingList(CompanyTrainingRequest.newInstance().selectAll());
    }

    public RetailStoreCountryCenterRequest unselectCompanyTrainingList(){
        unselectChild(CompanyTraining.COMPANY_PROPERTY, CompanyTraining.class);
        return this;
    }
  

   public RetailStoreCountryCenterRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

