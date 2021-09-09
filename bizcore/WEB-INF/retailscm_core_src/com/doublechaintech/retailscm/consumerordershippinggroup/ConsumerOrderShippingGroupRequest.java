package com.doublechaintech.retailscm.consumerordershippinggroup;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup.*;

public class ConsumerOrderShippingGroupRequest extends BaseRequest<ConsumerOrderShippingGroup> {
    public static ConsumerOrderShippingGroupRequest newInstance() {
        return new ConsumerOrderShippingGroupRequest().selectId();
    }

    public String getInternalType() {
        return "ConsumerOrderShippingGroup";
    }

    public ConsumerOrderShippingGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ConsumerOrderShippingGroupRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ConsumerOrderShippingGroupRequest selectAll() {return this.selectId().selectName().selectBizOrder().selectAmount().selectVersion();
    }

    public ConsumerOrderShippingGroupRequest selectSelf() {return this.selectId().selectName().selectAmount().selectVersion();
    }

    public ConsumerOrderShippingGroupRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ConsumerOrderShippingGroupRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ConsumerOrderShippingGroupRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ConsumerOrderShippingGroupRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ConsumerOrderShippingGroupRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderShippingGroupRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ConsumerOrderShippingGroupRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderShippingGroupRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderShippingGroupRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public ConsumerOrderShippingGroupRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderShippingGroupRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public ConsumerOrderShippingGroupRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderShippingGroupRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderShippingGroupRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public ConsumerOrderShippingGroupRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderShippingGroupRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public ConsumerOrderShippingGroupRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderShippingGroupRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderShippingGroupRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ConsumerOrderShippingGroupRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderShippingGroupRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ConsumerOrderShippingGroupRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderShippingGroupRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ConsumerOrderShippingGroupRequest filterByBizOrder(ConsumerOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderShippingGroupRequest filterByBizOrder(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public ConsumerOrderShippingGroupRequest selectBizOrder(){
        return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
    }

    public ConsumerOrderShippingGroupRequest selectBizOrder(ConsumerOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public ConsumerOrderShippingGroupRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public ConsumerOrderShippingGroupRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

