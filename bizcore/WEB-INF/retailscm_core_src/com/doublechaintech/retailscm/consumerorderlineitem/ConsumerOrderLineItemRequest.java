package com.doublechaintech.retailscm.consumerorderlineitem;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem.*;

public class ConsumerOrderLineItemRequest extends BaseRequest<ConsumerOrderLineItem> {
    public static ConsumerOrderLineItemRequest newInstance() {
        return new ConsumerOrderLineItemRequest().selectId();
    }

    public String getInternalType() {
        return "ConsumerOrderLineItem";
    }

    public ConsumerOrderLineItemRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ConsumerOrderLineItemRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ConsumerOrderLineItemRequest selectAll() {return this.selectId().selectBizOrder().selectSkuId().selectSkuName().selectPrice().selectQuantity().selectAmount().selectLastUpdateTime().selectVersion();
    }

    public ConsumerOrderLineItemRequest selectSelf() {return this.selectId().selectSkuId().selectSkuName().selectPrice().selectQuantity().selectAmount().selectLastUpdateTime().selectVersion();
    }

    public ConsumerOrderLineItemRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ConsumerOrderLineItemRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ConsumerOrderLineItemRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ConsumerOrderLineItemRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ConsumerOrderLineItemRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderLineItemRequest filterBySkuId(String skuId) {
          
          if (skuId == null) {
              return this;
          }
          
          return filterBySkuId(QueryOperator.EQUAL, skuId);
      }
    

      public ConsumerOrderLineItemRequest filterBySkuId(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSkuIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectSkuId(){
          return select(SKU_ID_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectSkuId(){
          return unselect(SKU_ID_PROPERTY);
      }

      public SearchCriteria getSkuIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SKU_ID_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderBySkuId(boolean asc){
          addOrderBy(SKU_ID_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderLineItemRequest filterBySkuName(String skuName) {
          
          if (skuName == null) {
              return this;
          }
          
          return filterBySkuName(QueryOperator.EQUAL, skuName);
      }
    

      public ConsumerOrderLineItemRequest filterBySkuName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getSkuNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectSkuName(){
          return select(SKU_NAME_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectSkuName(){
          return unselect(SKU_NAME_PROPERTY);
      }

      public SearchCriteria getSkuNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(SKU_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderBySkuName(boolean asc){
          addOrderBy(SKU_NAME_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderLineItemRequest filterByPrice(BigDecimal price) {
          
          if (price == null) {
              return this;
          }
          
          return filterByPrice(QueryOperator.EQUAL, price);
      }
    

      public ConsumerOrderLineItemRequest filterByPrice(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPriceSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectPrice(){
          return select(PRICE_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectPrice(){
          return unselect(PRICE_PROPERTY);
      }

      public SearchCriteria getPriceSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PRICE_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderByPrice(boolean asc){
          addOrderBy(PRICE_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderLineItemRequest filterByQuantity(BigDecimal quantity) {
          
          if (quantity == null) {
              return this;
          }
          
          return filterByQuantity(QueryOperator.EQUAL, quantity);
      }
    

      public ConsumerOrderLineItemRequest filterByQuantity(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getQuantitySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectQuantity(){
          return select(QUANTITY_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectQuantity(){
          return unselect(QUANTITY_PROPERTY);
      }

      public SearchCriteria getQuantitySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(QUANTITY_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderByQuantity(boolean asc){
          addOrderBy(QUANTITY_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderLineItemRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public ConsumerOrderLineItemRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderLineItemRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public ConsumerOrderLineItemRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderLineItemRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ConsumerOrderLineItemRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderLineItemRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ConsumerOrderLineItemRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderLineItemRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ConsumerOrderLineItemRequest filterByBizOrder(ConsumerOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderLineItemRequest filterByBizOrder(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public ConsumerOrderLineItemRequest selectBizOrder(){
        return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
    }

    public ConsumerOrderLineItemRequest selectBizOrder(ConsumerOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public ConsumerOrderLineItemRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public ConsumerOrderLineItemRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

