package com.doublechaintech.retailscm.warehouse;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.storagespace.StorageSpace;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.damagespace.DamageSpaceRequest;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceRequest;
import com.doublechaintech.retailscm.smartpallet.SmartPalletRequest;
import com.doublechaintech.retailscm.storagespace.StorageSpaceRequest;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceRequest;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.warehouse.Warehouse.*;

public class WarehouseRequest extends BaseRequest<Warehouse> {
    public static WarehouseRequest newInstance() {
        return new WarehouseRequest().selectId();
    }

    public String getInternalType() {
        return "Warehouse";
    }

    public WarehouseRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public WarehouseRequest select(String... names) {
        super.select(names);
        return this;
    }

    public WarehouseRequest selectAll() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectOwner().selectLatitude().selectLongitude().selectContract().selectLastUpdateTime().selectVersion();
    }

    public WarehouseRequest selectSelf() {return this.selectId().selectLocation().selectContactNumber().selectTotalArea().selectLatitude().selectLongitude().selectContract().selectLastUpdateTime().selectVersion();
    }

    public WarehouseRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public WarehouseRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static WarehouseRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public WarehouseRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public WarehouseRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectId(){
          return select(ID_PROPERTY);
      }

      public WarehouseRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByLocation(String location) {
          
          if (location == null) {
              return this;
          }
          
          return filterByLocation(QueryOperator.EQUAL, location);
      }
    

      public WarehouseRequest filterByLocation(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLocationSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectLocation(){
          return select(LOCATION_PROPERTY);
      }

      public WarehouseRequest unselectLocation(){
          return unselect(LOCATION_PROPERTY);
      }

      public SearchCriteria getLocationSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LOCATION_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByLocation(boolean asc){
          addOrderBy(LOCATION_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByContactNumber(String contactNumber) {
          
          if (contactNumber == null) {
              return this;
          }
          
          return filterByContactNumber(QueryOperator.EQUAL, contactNumber);
      }
    

      public WarehouseRequest filterByContactNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContactNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectContactNumber(){
          return select(CONTACT_NUMBER_PROPERTY);
      }

      public WarehouseRequest unselectContactNumber(){
          return unselect(CONTACT_NUMBER_PROPERTY);
      }

      public SearchCriteria getContactNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTACT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByContactNumber(boolean asc){
          addOrderBy(CONTACT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByTotalArea(String totalArea) {
          
          if (totalArea == null) {
              return this;
          }
          
          return filterByTotalArea(QueryOperator.EQUAL, totalArea);
      }
    

      public WarehouseRequest filterByTotalArea(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTotalAreaSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectTotalArea(){
          return select(TOTAL_AREA_PROPERTY);
      }

      public WarehouseRequest unselectTotalArea(){
          return unselect(TOTAL_AREA_PROPERTY);
      }

      public SearchCriteria getTotalAreaSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TOTAL_AREA_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByTotalArea(boolean asc){
          addOrderBy(TOTAL_AREA_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public WarehouseRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public WarehouseRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public WarehouseRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public WarehouseRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByContract(String contract) {
          
          if (contract == null) {
              return this;
          }
          
          return filterByContract(QueryOperator.EQUAL, contract);
      }
    

      public WarehouseRequest filterByContract(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getContractSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectContract(){
          return select(CONTRACT_PROPERTY);
      }

      public WarehouseRequest unselectContract(){
          return unselect(CONTRACT_PROPERTY);
      }

      public SearchCriteria getContractSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CONTRACT_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByContract(boolean asc){
          addOrderBy(CONTRACT_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public WarehouseRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public WarehouseRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public WarehouseRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public WarehouseRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public WarehouseRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public WarehouseRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public WarehouseRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public WarehouseRequest filterByOwner(RetailStoreCountryCenterRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest filterByOwner(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public WarehouseRequest selectOwner(){
        return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public WarehouseRequest selectOwner(RetailStoreCountryCenterRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public WarehouseRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

    public WarehouseRequest hasStorageSpace() {
      return hasStorageSpace(StorageSpaceRequest.newInstance());
    }

    public WarehouseRequest hasStorageSpace(StorageSpaceRequest storageSpace) {
        return hasStorageSpace(storageSpace, storageSpaceList -> storageSpaceList.stream().map(StorageSpace::getWarehouse).map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest hasStorageSpace(StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine) {
        storageSpace.select(StorageSpace.WAREHOUSE_PROPERTY);
        return addSearchCriteria(createStorageSpaceCriteria(storageSpace, idRefine));
    }

    public SearchCriteria createStorageSpaceCriteria(StorageSpaceRequest storageSpace, IDRefine<StorageSpace> idRefine){
       return new RefinedIdInCriteria(storageSpace, ID_PROPERTY, idRefine);
    }

    public WarehouseRequest selectStorageSpaceList(StorageSpaceRequest storageSpace) {
        selectChild(StorageSpace.WAREHOUSE_PROPERTY, storageSpace);
        return this;
    }

    public WarehouseRequest selectStorageSpaceList() {
        return selectStorageSpaceList(StorageSpaceRequest.newInstance().selectAll());
    }

    public WarehouseRequest unselectStorageSpaceList(){
        unselectChild(StorageSpace.WAREHOUSE_PROPERTY, StorageSpace.class);
        return this;
    }
  

    public WarehouseRequest hasSmartPallet() {
      return hasSmartPallet(SmartPalletRequest.newInstance());
    }

    public WarehouseRequest hasSmartPallet(SmartPalletRequest smartPallet) {
        return hasSmartPallet(smartPallet, smartPalletList -> smartPalletList.stream().map(SmartPallet::getWarehouse).map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest hasSmartPallet(SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine) {
        smartPallet.select(SmartPallet.WAREHOUSE_PROPERTY);
        return addSearchCriteria(createSmartPalletCriteria(smartPallet, idRefine));
    }

    public SearchCriteria createSmartPalletCriteria(SmartPalletRequest smartPallet, IDRefine<SmartPallet> idRefine){
       return new RefinedIdInCriteria(smartPallet, ID_PROPERTY, idRefine);
    }

    public WarehouseRequest selectSmartPalletList(SmartPalletRequest smartPallet) {
        selectChild(SmartPallet.WAREHOUSE_PROPERTY, smartPallet);
        return this;
    }

    public WarehouseRequest selectSmartPalletList() {
        return selectSmartPalletList(SmartPalletRequest.newInstance().selectAll());
    }

    public WarehouseRequest unselectSmartPalletList(){
        unselectChild(SmartPallet.WAREHOUSE_PROPERTY, SmartPallet.class);
        return this;
    }
  

    public WarehouseRequest hasSupplierSpace() {
      return hasSupplierSpace(SupplierSpaceRequest.newInstance());
    }

    public WarehouseRequest hasSupplierSpace(SupplierSpaceRequest supplierSpace) {
        return hasSupplierSpace(supplierSpace, supplierSpaceList -> supplierSpaceList.stream().map(SupplierSpace::getWarehouse).map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest hasSupplierSpace(SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine) {
        supplierSpace.select(SupplierSpace.WAREHOUSE_PROPERTY);
        return addSearchCriteria(createSupplierSpaceCriteria(supplierSpace, idRefine));
    }

    public SearchCriteria createSupplierSpaceCriteria(SupplierSpaceRequest supplierSpace, IDRefine<SupplierSpace> idRefine){
       return new RefinedIdInCriteria(supplierSpace, ID_PROPERTY, idRefine);
    }

    public WarehouseRequest selectSupplierSpaceList(SupplierSpaceRequest supplierSpace) {
        selectChild(SupplierSpace.WAREHOUSE_PROPERTY, supplierSpace);
        return this;
    }

    public WarehouseRequest selectSupplierSpaceList() {
        return selectSupplierSpaceList(SupplierSpaceRequest.newInstance().selectAll());
    }

    public WarehouseRequest unselectSupplierSpaceList(){
        unselectChild(SupplierSpace.WAREHOUSE_PROPERTY, SupplierSpace.class);
        return this;
    }
  

    public WarehouseRequest hasReceivingSpace() {
      return hasReceivingSpace(ReceivingSpaceRequest.newInstance());
    }

    public WarehouseRequest hasReceivingSpace(ReceivingSpaceRequest receivingSpace) {
        return hasReceivingSpace(receivingSpace, receivingSpaceList -> receivingSpaceList.stream().map(ReceivingSpace::getWarehouse).map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest hasReceivingSpace(ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine) {
        receivingSpace.select(ReceivingSpace.WAREHOUSE_PROPERTY);
        return addSearchCriteria(createReceivingSpaceCriteria(receivingSpace, idRefine));
    }

    public SearchCriteria createReceivingSpaceCriteria(ReceivingSpaceRequest receivingSpace, IDRefine<ReceivingSpace> idRefine){
       return new RefinedIdInCriteria(receivingSpace, ID_PROPERTY, idRefine);
    }

    public WarehouseRequest selectReceivingSpaceList(ReceivingSpaceRequest receivingSpace) {
        selectChild(ReceivingSpace.WAREHOUSE_PROPERTY, receivingSpace);
        return this;
    }

    public WarehouseRequest selectReceivingSpaceList() {
        return selectReceivingSpaceList(ReceivingSpaceRequest.newInstance().selectAll());
    }

    public WarehouseRequest unselectReceivingSpaceList(){
        unselectChild(ReceivingSpace.WAREHOUSE_PROPERTY, ReceivingSpace.class);
        return this;
    }
  

    public WarehouseRequest hasShippingSpace() {
      return hasShippingSpace(ShippingSpaceRequest.newInstance());
    }

    public WarehouseRequest hasShippingSpace(ShippingSpaceRequest shippingSpace) {
        return hasShippingSpace(shippingSpace, shippingSpaceList -> shippingSpaceList.stream().map(ShippingSpace::getWarehouse).map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest hasShippingSpace(ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine) {
        shippingSpace.select(ShippingSpace.WAREHOUSE_PROPERTY);
        return addSearchCriteria(createShippingSpaceCriteria(shippingSpace, idRefine));
    }

    public SearchCriteria createShippingSpaceCriteria(ShippingSpaceRequest shippingSpace, IDRefine<ShippingSpace> idRefine){
       return new RefinedIdInCriteria(shippingSpace, ID_PROPERTY, idRefine);
    }

    public WarehouseRequest selectShippingSpaceList(ShippingSpaceRequest shippingSpace) {
        selectChild(ShippingSpace.WAREHOUSE_PROPERTY, shippingSpace);
        return this;
    }

    public WarehouseRequest selectShippingSpaceList() {
        return selectShippingSpaceList(ShippingSpaceRequest.newInstance().selectAll());
    }

    public WarehouseRequest unselectShippingSpaceList(){
        unselectChild(ShippingSpace.WAREHOUSE_PROPERTY, ShippingSpace.class);
        return this;
    }
  

    public WarehouseRequest hasDamageSpace() {
      return hasDamageSpace(DamageSpaceRequest.newInstance());
    }

    public WarehouseRequest hasDamageSpace(DamageSpaceRequest damageSpace) {
        return hasDamageSpace(damageSpace, damageSpaceList -> damageSpaceList.stream().map(DamageSpace::getWarehouse).map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest hasDamageSpace(DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine) {
        damageSpace.select(DamageSpace.WAREHOUSE_PROPERTY);
        return addSearchCriteria(createDamageSpaceCriteria(damageSpace, idRefine));
    }

    public SearchCriteria createDamageSpaceCriteria(DamageSpaceRequest damageSpace, IDRefine<DamageSpace> idRefine){
       return new RefinedIdInCriteria(damageSpace, ID_PROPERTY, idRefine);
    }

    public WarehouseRequest selectDamageSpaceList(DamageSpaceRequest damageSpace) {
        selectChild(DamageSpace.WAREHOUSE_PROPERTY, damageSpace);
        return this;
    }

    public WarehouseRequest selectDamageSpaceList() {
        return selectDamageSpaceList(DamageSpaceRequest.newInstance().selectAll());
    }

    public WarehouseRequest unselectDamageSpaceList(){
        unselectChild(DamageSpace.WAREHOUSE_PROPERTY, DamageSpace.class);
        return this;
    }
  

    public WarehouseRequest hasWarehouseAsset() {
      return hasWarehouseAsset(WarehouseAssetRequest.newInstance());
    }

    public WarehouseRequest hasWarehouseAsset(WarehouseAssetRequest warehouseAsset) {
        return hasWarehouseAsset(warehouseAsset, warehouseAssetList -> warehouseAssetList.stream().map(WarehouseAsset::getOwner).map(Warehouse::getId).collect(Collectors.toSet()));
    }

    public WarehouseRequest hasWarehouseAsset(WarehouseAssetRequest warehouseAsset, IDRefine<WarehouseAsset> idRefine) {
        warehouseAsset.select(WarehouseAsset.OWNER_PROPERTY);
        return addSearchCriteria(createWarehouseAssetCriteria(warehouseAsset, idRefine));
    }

    public SearchCriteria createWarehouseAssetCriteria(WarehouseAssetRequest warehouseAsset, IDRefine<WarehouseAsset> idRefine){
       return new RefinedIdInCriteria(warehouseAsset, ID_PROPERTY, idRefine);
    }

    public WarehouseRequest selectWarehouseAssetList(WarehouseAssetRequest warehouseAsset) {
        selectChild(WarehouseAsset.OWNER_PROPERTY, warehouseAsset);
        return this;
    }

    public WarehouseRequest selectWarehouseAssetList() {
        return selectWarehouseAssetList(WarehouseAssetRequest.newInstance().selectAll());
    }

    public WarehouseRequest unselectWarehouseAssetList(){
        unselectChild(WarehouseAsset.OWNER_PROPERTY, WarehouseAsset.class);
        return this;
    }
  

   public WarehouseRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

