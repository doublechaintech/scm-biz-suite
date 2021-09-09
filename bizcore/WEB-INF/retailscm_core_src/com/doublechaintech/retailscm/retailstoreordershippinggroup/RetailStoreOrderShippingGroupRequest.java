package com.doublechaintech.retailscm.retailstoreordershippinggroup;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup.*;

public class RetailStoreOrderShippingGroupRequest extends BaseRequest<RetailStoreOrderShippingGroup> {
    public static RetailStoreOrderShippingGroupRequest newInstance() {
        return new RetailStoreOrderShippingGroupRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreOrderShippingGroup";
    }

    public RetailStoreOrderShippingGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreOrderShippingGroupRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreOrderShippingGroupRequest selectAll() {return this.selectId().selectName().selectBizOrder().selectAmount().selectVersion();
    }

    public RetailStoreOrderShippingGroupRequest selectSelf() {return this.selectId().selectName().selectAmount().selectVersion();
    }

    public RetailStoreOrderShippingGroupRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreOrderShippingGroupRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreOrderShippingGroupRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreOrderShippingGroupRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreOrderShippingGroupRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderShippingGroupRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreOrderShippingGroupRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderShippingGroupRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderShippingGroupRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreOrderShippingGroupRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderShippingGroupRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreOrderShippingGroupRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderShippingGroupRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderShippingGroupRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public RetailStoreOrderShippingGroupRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderShippingGroupRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public RetailStoreOrderShippingGroupRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderShippingGroupRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderShippingGroupRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreOrderShippingGroupRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderShippingGroupRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreOrderShippingGroupRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderShippingGroupRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreOrderShippingGroupRequest filterByBizOrder(RetailStoreOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderShippingGroupRequest filterByBizOrder(RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreOrderShippingGroupRequest selectBizOrder(){
        return selectBizOrder(RetailStoreOrderRequest.newInstance().selectSelf());
    }

    public RetailStoreOrderShippingGroupRequest selectBizOrder(RetailStoreOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public RetailStoreOrderShippingGroupRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public RetailStoreOrderShippingGroupRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

