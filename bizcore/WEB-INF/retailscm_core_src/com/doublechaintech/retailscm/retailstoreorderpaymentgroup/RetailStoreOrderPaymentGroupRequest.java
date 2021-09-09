package com.doublechaintech.retailscm.retailstoreorderpaymentgroup;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup.*;

public class RetailStoreOrderPaymentGroupRequest extends BaseRequest<RetailStoreOrderPaymentGroup> {
    public static RetailStoreOrderPaymentGroupRequest newInstance() {
        return new RetailStoreOrderPaymentGroupRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreOrderPaymentGroup";
    }

    public RetailStoreOrderPaymentGroupRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreOrderPaymentGroupRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreOrderPaymentGroupRequest selectAll() {return this.selectId().selectName().selectBizOrder().selectCardNumber().selectVersion();
    }

    public RetailStoreOrderPaymentGroupRequest selectSelf() {return this.selectId().selectName().selectCardNumber().selectVersion();
    }

    public RetailStoreOrderPaymentGroupRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreOrderPaymentGroupRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreOrderPaymentGroupRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreOrderPaymentGroupRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreOrderPaymentGroupRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderPaymentGroupRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreOrderPaymentGroupRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderPaymentGroupRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderPaymentGroupRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreOrderPaymentGroupRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderPaymentGroupRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreOrderPaymentGroupRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderPaymentGroupRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderPaymentGroupRequest filterByCardNumber(String cardNumber) {
          
          if (cardNumber == null) {
              return this;
          }
          
          return filterByCardNumber(QueryOperator.EQUAL, cardNumber);
      }
    

      public RetailStoreOrderPaymentGroupRequest filterByCardNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCardNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderPaymentGroupRequest selectCardNumber(){
          return select(CARD_NUMBER_PROPERTY);
      }

      public RetailStoreOrderPaymentGroupRequest unselectCardNumber(){
          return unselect(CARD_NUMBER_PROPERTY);
      }

      public SearchCriteria getCardNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CARD_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderPaymentGroupRequest orderByCardNumber(boolean asc){
          addOrderBy(CARD_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreOrderPaymentGroupRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreOrderPaymentGroupRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreOrderPaymentGroupRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreOrderPaymentGroupRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreOrderPaymentGroupRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreOrderPaymentGroupRequest filterByBizOrder(RetailStoreOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(RetailStoreOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreOrderPaymentGroupRequest filterByBizOrder(RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(RetailStoreOrderRequest bizOrder, IDRefine<RetailStoreOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreOrderPaymentGroupRequest selectBizOrder(){
        return selectBizOrder(RetailStoreOrderRequest.newInstance().selectSelf());
    }

    public RetailStoreOrderPaymentGroupRequest selectBizOrder(RetailStoreOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public RetailStoreOrderPaymentGroupRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public RetailStoreOrderPaymentGroupRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

