package com.doublechaintech.retailscm.retailstoreorderlineitem;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem.*;

public class RetailStoreOrderLineItemRequest extends BaseRequest<RetailStoreOrderLineItem> {
    public static RetailStoreOrderLineItemRequest newInstance() {
        return new RetailStoreOrderLineItemRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreOrderLineItem";
    }

    public RetailStoreOrderLineItemRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreOrderLineItemRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreOrderLineItemRequest selectAll() {return this.selectId().selectBizOrder().selectSkuId().selectSkuName().selectAmount().selectQuantity().selectUnitOfMeasurement().selectVersion();
    }

    public RetailStoreOrderLineItemRequest selectSelf() {return this.selectId().selectSkuId().selectSkuName().selectAmount().selectQuantity().selectUnitOfMeasurement().selectVersion();
    }

    public RetailStoreOrderLineItemRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreOrderLineItemRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreOrderLineItemRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreOrderLineItemRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreOrderLineItemRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderLineItemRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreOrderLineItemRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderLineItemRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderLineItemRequest filterBySkuId(String skuId) {
          
          if (skuId == null) {
              return this;
          }
          
          return filterBySkuId(QueryOperator.EQUAL, skuId);
      }
    

      public RetailStoreOrderLineItemRequest filterBySkuId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSkuIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderLineItemRequest selectSkuId(){
          return select(SKU_ID_PROPERTY);
      }

      public RetailStoreOrderLineItemRequest unselectSkuId(){
          return unselect(SKU_ID_PROPERTY);
      }

      public SearchCriteria getSkuIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SKU_ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderLineItemRequest orderBySkuId(boolean asc){
          addOrderBy(SKU_ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderLineItemRequest filterBySkuName(String skuName) {
          
          if (skuName == null) {
              return this;
          }
          
          return filterBySkuName(QueryOperator.EQUAL, skuName);
      }
    

      public RetailStoreOrderLineItemRequest filterBySkuName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSkuNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderLineItemRequest selectSkuName(){
          return select(SKU_NAME_PROPERTY);
      }

      public RetailStoreOrderLineItemRequest unselectSkuName(){
          return unselect(SKU_NAME_PROPERTY);
      }

      public SearchCriteria getSkuNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SKU_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderLineItemRequest orderBySkuName(boolean asc){
          addOrderBy(SKU_NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderLineItemRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public RetailStoreOrderLineItemRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderLineItemRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public RetailStoreOrderLineItemRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderLineItemRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderLineItemRequest filterByQuantity(int quantity) {
          
          return filterByQuantity(QueryOperator.EQUAL, quantity);
      }
    

      public RetailStoreOrderLineItemRequest filterByQuantity(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderLineItemRequest selectQuantity(){
          return select(QUANTITY_PROPERTY);
      }

      public RetailStoreOrderLineItemRequest unselectQuantity(){
          return unselect(QUANTITY_PROPERTY);
      }

      public SearchCriteria getQuantitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderLineItemRequest orderByQuantity(boolean asc){
          addOrderBy(QUANTITY_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderLineItemRequest filterByUnitOfMeasurement(String unitOfMeasurement) {
          
          if (unitOfMeasurement == null) {
              return this;
          }
          
          return filterByUnitOfMeasurement(QueryOperator.EQUAL, unitOfMeasurement);
      }
    

      public RetailStoreOrderLineItemRequest filterByUnitOfMeasurement(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUnitOfMeasurementSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderLineItemRequest selectUnitOfMeasurement(){
          return select(UNIT_OF_MEASUREMENT_PROPERTY);
      }

      public RetailStoreOrderLineItemRequest unselectUnitOfMeasurement(){
          return unselect(UNIT_OF_MEASUREMENT_PROPERTY);
      }

      public SearchCriteria getUnitOfMeasurementSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(UNIT_OF_MEASUREMENT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderLineItemRequest orderByUnitOfMeasurement(boolean asc){
          addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderLineItemRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreOrderLineItemRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderLineItemRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreOrderLineItemRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderLineItemRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreOrderLineItemRequest filterByBizOrder(RetailStoreOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderLineItemRequest filterByBizOrder(RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreOrderLineItemRequest selectBizOrder(){
        return selectBizOrder(RetailStoreOrderRequest.newInstance().selectSelf());
    }

    public RetailStoreOrderLineItemRequest selectBizOrder(RetailStoreOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public RetailStoreOrderLineItemRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public RetailStoreOrderLineItemRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

