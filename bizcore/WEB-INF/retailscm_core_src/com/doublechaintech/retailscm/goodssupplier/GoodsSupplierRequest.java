package com.doublechaintech.retailscm.goodssupplier;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.supplierproduct.SupplierProductRequest;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.goodssupplier.GoodsSupplier.*;

public class GoodsSupplierRequest extends BaseRequest<GoodsSupplier> {
    public static GoodsSupplierRequest newInstance() {
        return new GoodsSupplierRequest().selectId();
    }

    public String getInternalType() {
        return "GoodsSupplier";
    }

    public GoodsSupplierRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public GoodsSupplierRequest select(String... names) {
        super.select(names);
        return this;
    }

    public GoodsSupplierRequest selectAll() {return this.selectId().selectName().selectSupplyProduct().selectBelongTo().selectContactNumber().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public GoodsSupplierRequest selectSelf() {return this.selectId().selectName().selectSupplyProduct().selectContactNumber().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public GoodsSupplierRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public GoodsSupplierRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static GoodsSupplierRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public GoodsSupplierRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public GoodsSupplierRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsSupplierRequest selectId(){
          return select(ID_PROPERTY);
      }

      public GoodsSupplierRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsSupplierRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public GoodsSupplierRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public GoodsSupplierRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsSupplierRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public GoodsSupplierRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsSupplierRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public GoodsSupplierRequest filterBySupplyProduct(String supplyProduct) {
          
          if (supplyProduct == null) {
              return this;
          }
          
          return filterBySupplyProduct(QueryOperator.EQUAL, supplyProduct);
      }
    

      public GoodsSupplierRequest filterBySupplyProduct(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSupplyProductSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsSupplierRequest selectSupplyProduct(){
          return select(SUPPLY_PRODUCT_PROPERTY);
      }

      public GoodsSupplierRequest unselectSupplyProduct(){
          return unselect(SUPPLY_PRODUCT_PROPERTY);
      }

      public SearchCriteria getSupplyProductSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SUPPLY_PRODUCT_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsSupplierRequest orderBySupplyProduct(boolean asc){
          addOrderBy(SUPPLY_PRODUCT_PROPERTY, asc);
          return this;
      }
   
      public GoodsSupplierRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public GoodsSupplierRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsSupplierRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public GoodsSupplierRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsSupplierRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public GoodsSupplierRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public GoodsSupplierRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsSupplierRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public GoodsSupplierRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsSupplierRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public GoodsSupplierRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public GoodsSupplierRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsSupplierRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public GoodsSupplierRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsSupplierRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public GoodsSupplierRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public GoodsSupplierRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public GoodsSupplierRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public GoodsSupplierRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public GoodsSupplierRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public GoodsSupplierRequest filterByBelongTo(RetailStoreCountryCenterRequest belongTo){
        return filterByBelongTo(belongTo, belongToList -> belongToList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public GoodsSupplierRequest filterByBelongTo(RetailStoreCountryCenterRequest belongTo, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createBelongToCriteria(belongTo, idRefine));
    }

    public SearchCriteria createBelongToCriteria(RetailStoreCountryCenterRequest belongTo, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(belongTo, BELONG_TO_PROPERTY, idRefine);
    }
    

    
    public GoodsSupplierRequest selectBelongTo(){
        return selectBelongTo(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public GoodsSupplierRequest selectBelongTo(RetailStoreCountryCenterRequest belongTo){
        selectParent(BELONG_TO_PROPERTY, belongTo);
        return this;
    }
    

    public GoodsSupplierRequest unselectBelongTo(){
        unselectParent(BELONG_TO_PROPERTY);
        return this;
    }

  


  

    public GoodsSupplierRequest hasSupplierProduct() {
      return hasSupplierProduct(SupplierProductRequest.newInstance());
    }

    public GoodsSupplierRequest hasSupplierProduct(SupplierProductRequest supplierProduct) {
        return hasSupplierProduct(supplierProduct, supplierProductList -> supplierProductList.stream().map(SupplierProduct::getSupplier).map(GoodsSupplier::getId).collect(Collectors.toSet()));
    }

    public GoodsSupplierRequest hasSupplierProduct(SupplierProductRequest supplierProduct, IDRefine<SupplierProduct> idRefine) {
        supplierProduct.select(SupplierProduct.SUPPLIER_PROPERTY);
        return addSearchCriteria(createSupplierProductCriteria(supplierProduct, idRefine));
    }

    public SearchCriteria createSupplierProductCriteria(SupplierProductRequest supplierProduct, IDRefine<SupplierProduct> idRefine){
       return new RefinedIdInCriteria(supplierProduct, ID_PROPERTY, idRefine);
    }

    public GoodsSupplierRequest selectSupplierProductList(SupplierProductRequest supplierProduct) {
        selectChild(SupplierProduct.SUPPLIER_PROPERTY, supplierProduct);
        return this;
    }

    public GoodsSupplierRequest selectSupplierProductList() {
        return selectSupplierProductList(SupplierProductRequest.newInstance().selectAll());
    }

    public GoodsSupplierRequest unselectSupplierProductList(){
        unselectChild(SupplierProduct.SUPPLIER_PROPERTY, SupplierProduct.class);
        return this;
    }
  

    public GoodsSupplierRequest hasSupplyOrder() {
      return hasSupplyOrder(SupplyOrderRequest.newInstance());
    }

    public GoodsSupplierRequest hasSupplyOrder(SupplyOrderRequest supplyOrder) {
        return hasSupplyOrder(supplyOrder, supplyOrderList -> supplyOrderList.stream().map(SupplyOrder::getSeller).map(GoodsSupplier::getId).collect(Collectors.toSet()));
    }

    public GoodsSupplierRequest hasSupplyOrder(SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine) {
        supplyOrder.select(SupplyOrder.SELLER_PROPERTY);
        return addSearchCriteria(createSupplyOrderCriteria(supplyOrder, idRefine));
    }

    public SearchCriteria createSupplyOrderCriteria(SupplyOrderRequest supplyOrder, IDRefine<SupplyOrder> idRefine){
       return new RefinedIdInCriteria(supplyOrder, ID_PROPERTY, idRefine);
    }

    public GoodsSupplierRequest selectSupplyOrderList(SupplyOrderRequest supplyOrder) {
        selectChild(SupplyOrder.SELLER_PROPERTY, supplyOrder);
        return this;
    }

    public GoodsSupplierRequest selectSupplyOrderList() {
        return selectSupplyOrderList(SupplyOrderRequest.newInstance().selectAll());
    }

    public GoodsSupplierRequest unselectSupplyOrderList(){
        unselectChild(SupplyOrder.SELLER_PROPERTY, SupplyOrder.class);
        return this;
    }
  

    public GoodsSupplierRequest hasAccountSet() {
      return hasAccountSet(AccountSetRequest.newInstance());
    }

    public GoodsSupplierRequest hasAccountSet(AccountSetRequest accountSet) {
        return hasAccountSet(accountSet, accountSetList -> accountSetList.stream().map(AccountSet::getGoodsSupplier).map(GoodsSupplier::getId).collect(Collectors.toSet()));
    }

    public GoodsSupplierRequest hasAccountSet(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
        accountSet.select(AccountSet.GOODS_SUPPLIER_PROPERTY);
        return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
    }

    public SearchCriteria createAccountSetCriteria(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine){
       return new RefinedIdInCriteria(accountSet, ID_PROPERTY, idRefine);
    }

    public GoodsSupplierRequest selectAccountSetList(AccountSetRequest accountSet) {
        selectChild(AccountSet.GOODS_SUPPLIER_PROPERTY, accountSet);
        return this;
    }

    public GoodsSupplierRequest selectAccountSetList() {
        return selectAccountSetList(AccountSetRequest.newInstance().selectAll());
    }

    public GoodsSupplierRequest unselectAccountSetList(){
        unselectChild(AccountSet.GOODS_SUPPLIER_PROPERTY, AccountSet.class);
        return this;
    }
  

   public GoodsSupplierRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

