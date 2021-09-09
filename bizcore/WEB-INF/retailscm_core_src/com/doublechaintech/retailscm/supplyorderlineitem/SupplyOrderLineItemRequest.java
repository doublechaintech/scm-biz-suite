package com.doublechaintech.retailscm.supplyorderlineitem;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplyorder.SupplyOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem.*;

public class SupplyOrderLineItemRequest extends BaseRequest<SupplyOrderLineItem> {
    public static SupplyOrderLineItemRequest newInstance() {
        return new SupplyOrderLineItemRequest().selectId();
    }

    public String getInternalType() {
        return "SupplyOrderLineItem";
    }

    public SupplyOrderLineItemRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SupplyOrderLineItemRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SupplyOrderLineItemRequest selectAll() {return this.selectId().selectBizOrder().selectSkuId().selectSkuName().selectAmount().selectQuantity().selectUnitOfMeasurement().selectVersion();
    }

    public SupplyOrderLineItemRequest selectSelf() {return this.selectId().selectSkuId().selectSkuName().selectAmount().selectQuantity().selectUnitOfMeasurement().selectVersion();
    }

    public SupplyOrderLineItemRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SupplyOrderLineItemRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SupplyOrderLineItemRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SupplyOrderLineItemRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SupplyOrderLineItemRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderLineItemRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SupplyOrderLineItemRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderLineItemRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderLineItemRequest filterBySkuId(String skuId) {
          
          if (skuId == null) {
              return this;
          }
          
          return filterBySkuId(QueryOperator.EQUAL, skuId);
      }
    

      public SupplyOrderLineItemRequest filterBySkuId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSkuIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderLineItemRequest selectSkuId(){
          return select(SKU_ID_PROPERTY);
      }

      public SupplyOrderLineItemRequest unselectSkuId(){
          return unselect(SKU_ID_PROPERTY);
      }

      public SearchCriteria getSkuIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SKU_ID_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderLineItemRequest orderBySkuId(boolean asc){
          addOrderBy(SKU_ID_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderLineItemRequest filterBySkuName(String skuName) {
          
          if (skuName == null) {
              return this;
          }
          
          return filterBySkuName(QueryOperator.EQUAL, skuName);
      }
    

      public SupplyOrderLineItemRequest filterBySkuName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSkuNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderLineItemRequest selectSkuName(){
          return select(SKU_NAME_PROPERTY);
      }

      public SupplyOrderLineItemRequest unselectSkuName(){
          return unselect(SKU_NAME_PROPERTY);
      }

      public SearchCriteria getSkuNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SKU_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderLineItemRequest orderBySkuName(boolean asc){
          addOrderBy(SKU_NAME_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderLineItemRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public SupplyOrderLineItemRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderLineItemRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public SupplyOrderLineItemRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderLineItemRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderLineItemRequest filterByQuantity(int quantity) {
          
          return filterByQuantity(QueryOperator.EQUAL, quantity);
      }
    

      public SupplyOrderLineItemRequest filterByQuantity(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderLineItemRequest selectQuantity(){
          return select(QUANTITY_PROPERTY);
      }

      public SupplyOrderLineItemRequest unselectQuantity(){
          return unselect(QUANTITY_PROPERTY);
      }

      public SearchCriteria getQuantitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderLineItemRequest orderByQuantity(boolean asc){
          addOrderBy(QUANTITY_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderLineItemRequest filterByUnitOfMeasurement(String unitOfMeasurement) {
          
          if (unitOfMeasurement == null) {
              return this;
          }
          
          return filterByUnitOfMeasurement(QueryOperator.EQUAL, unitOfMeasurement);
      }
    

      public SupplyOrderLineItemRequest filterByUnitOfMeasurement(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getUnitOfMeasurementSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderLineItemRequest selectUnitOfMeasurement(){
          return select(UNIT_OF_MEASUREMENT_PROPERTY);
      }

      public SupplyOrderLineItemRequest unselectUnitOfMeasurement(){
          return unselect(UNIT_OF_MEASUREMENT_PROPERTY);
      }

      public SearchCriteria getUnitOfMeasurementSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(UNIT_OF_MEASUREMENT_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderLineItemRequest orderByUnitOfMeasurement(boolean asc){
          addOrderBy(UNIT_OF_MEASUREMENT_PROPERTY, asc);
          return this;
      }
   
      public SupplyOrderLineItemRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SupplyOrderLineItemRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SupplyOrderLineItemRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SupplyOrderLineItemRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SupplyOrderLineItemRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SupplyOrderLineItemRequest filterByBizOrder(SupplyOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(SupplyOrder::getId).collect(Collectors.toSet()));
    }

    public SupplyOrderLineItemRequest filterByBizOrder(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(SupplyOrderRequest bizOrder, IDRefine<SupplyOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public SupplyOrderLineItemRequest selectBizOrder(){
        return selectBizOrder(SupplyOrderRequest.newInstance().selectSelf());
    }

    public SupplyOrderLineItemRequest selectBizOrder(SupplyOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public SupplyOrderLineItemRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public SupplyOrderLineItemRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

