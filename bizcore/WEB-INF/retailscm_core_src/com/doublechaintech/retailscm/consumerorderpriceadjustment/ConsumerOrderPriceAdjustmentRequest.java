package com.doublechaintech.retailscm.consumerorderpriceadjustment;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment.*;

public class ConsumerOrderPriceAdjustmentRequest extends BaseRequest<ConsumerOrderPriceAdjustment> {
    public static ConsumerOrderPriceAdjustmentRequest newInstance() {
        return new ConsumerOrderPriceAdjustmentRequest().selectId();
    }

    public String getInternalType() {
        return "ConsumerOrderPriceAdjustment";
    }

    public ConsumerOrderPriceAdjustmentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ConsumerOrderPriceAdjustmentRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ConsumerOrderPriceAdjustmentRequest selectAll() {return this.selectId().selectName().selectBizOrder().selectAmount().selectProvider().selectVersion();
    }

    public ConsumerOrderPriceAdjustmentRequest selectSelf() {return this.selectId().selectName().selectAmount().selectProvider().selectVersion();
    }

    public ConsumerOrderPriceAdjustmentRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ConsumerOrderPriceAdjustmentRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ConsumerOrderPriceAdjustmentRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ConsumerOrderPriceAdjustmentRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ConsumerOrderPriceAdjustmentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPriceAdjustmentRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ConsumerOrderPriceAdjustmentRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPriceAdjustmentRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderPriceAdjustmentRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public ConsumerOrderPriceAdjustmentRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPriceAdjustmentRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public ConsumerOrderPriceAdjustmentRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPriceAdjustmentRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderPriceAdjustmentRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public ConsumerOrderPriceAdjustmentRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPriceAdjustmentRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public ConsumerOrderPriceAdjustmentRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPriceAdjustmentRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderPriceAdjustmentRequest filterByProvider(String provider) {
          
          if (provider == null) {
              return this;
          }
          
          return filterByProvider(QueryOperator.EQUAL, provider);
      }
    

      public ConsumerOrderPriceAdjustmentRequest filterByProvider(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getProviderSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPriceAdjustmentRequest selectProvider(){
          return select(PROVIDER_PROPERTY);
      }

      public ConsumerOrderPriceAdjustmentRequest unselectProvider(){
          return unselect(PROVIDER_PROPERTY);
      }

      public SearchCriteria getProviderSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PROVIDER_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPriceAdjustmentRequest orderByProvider(boolean asc){
          addOrderBy(PROVIDER_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderPriceAdjustmentRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ConsumerOrderPriceAdjustmentRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderPriceAdjustmentRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ConsumerOrderPriceAdjustmentRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderPriceAdjustmentRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ConsumerOrderPriceAdjustmentRequest filterByBizOrder(ConsumerOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderPriceAdjustmentRequest filterByBizOrder(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public ConsumerOrderPriceAdjustmentRequest selectBizOrder(){
        return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
    }

    public ConsumerOrderPriceAdjustmentRequest selectBizOrder(ConsumerOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public ConsumerOrderPriceAdjustmentRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public ConsumerOrderPriceAdjustmentRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

