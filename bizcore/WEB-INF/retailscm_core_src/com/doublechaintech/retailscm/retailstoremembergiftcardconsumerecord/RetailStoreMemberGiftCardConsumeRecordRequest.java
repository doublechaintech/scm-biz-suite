package com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord.*;

public class RetailStoreMemberGiftCardConsumeRecordRequest extends BaseRequest<RetailStoreMemberGiftCardConsumeRecord> {
    public static RetailStoreMemberGiftCardConsumeRecordRequest newInstance() {
        return new RetailStoreMemberGiftCardConsumeRecordRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreMemberGiftCardConsumeRecord";
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest selectAll() {return this.selectId().selectOccureTime().selectOwner().selectBizOrder().selectNumber().selectAmount().selectVersion();
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest selectSelf() {return this.selectId().selectOccureTime().selectNumber().selectAmount().selectVersion();
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreMemberGiftCardConsumeRecordRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreMemberGiftCardConsumeRecordRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreMemberGiftCardConsumeRecordRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardConsumeRecordRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardConsumeRecordRequest filterByOccureTime(Date occureTime) {
          
          if (occureTime == null) {
              return this;
          }
          
          return filterByOccureTime(QueryOperator.EQUAL, occureTime);
      }
    

      public RetailStoreMemberGiftCardConsumeRecordRequest filterByOccureTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getOccureTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardConsumeRecordRequest selectOccureTime(){
          return select(OCCURE_TIME_PROPERTY);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest unselectOccureTime(){
          return unselect(OCCURE_TIME_PROPERTY);
      }

      public SearchCriteria getOccureTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(OCCURE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest orderByOccureTime(boolean asc){
          addOrderBy(OCCURE_TIME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardConsumeRecordRequest filterByNumber(String number) {
          
          if (number == null) {
              return this;
          }
          
          return filterByNumber(QueryOperator.EQUAL, number);
      }
    

      public RetailStoreMemberGiftCardConsumeRecordRequest filterByNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardConsumeRecordRequest selectNumber(){
          return select(NUMBER_PROPERTY);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest unselectNumber(){
          return unselect(NUMBER_PROPERTY);
      }

      public SearchCriteria getNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest orderByNumber(boolean asc){
          addOrderBy(NUMBER_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardConsumeRecordRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public RetailStoreMemberGiftCardConsumeRecordRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardConsumeRecordRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardConsumeRecordRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreMemberGiftCardConsumeRecordRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardConsumeRecordRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardConsumeRecordRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreMemberGiftCardConsumeRecordRequest filterByOwner(RetailStoreMemberGiftCardRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreMemberGiftCard::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest filterByOwner(RetailStoreMemberGiftCardRequest owner, IDRefine<RetailStoreMemberGiftCard> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreMemberGiftCardRequest owner, IDRefine<RetailStoreMemberGiftCard> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreMemberGiftCardConsumeRecordRequest selectOwner(){
        return selectOwner(RetailStoreMemberGiftCardRequest.newInstance().selectSelf());
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest selectOwner(RetailStoreMemberGiftCardRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public RetailStoreMemberGiftCardConsumeRecordRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  

    
    public RetailStoreMemberGiftCardConsumeRecordRequest filterByBizOrder(ConsumerOrderRequest bizOrder){
        return filterByBizOrder(bizOrder, bizOrderList -> bizOrderList.stream().map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest filterByBizOrder(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return addSearchCriteria(createBizOrderCriteria(bizOrder, idRefine));
    }

    public SearchCriteria createBizOrderCriteria(ConsumerOrderRequest bizOrder, IDRefine<ConsumerOrder> idRefine) {
        return new RefinedIdInCriteria(bizOrder, BIZ_ORDER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreMemberGiftCardConsumeRecordRequest selectBizOrder(){
        return selectBizOrder(ConsumerOrderRequest.newInstance().selectSelf());
    }

    public RetailStoreMemberGiftCardConsumeRecordRequest selectBizOrder(ConsumerOrderRequest bizOrder){
        selectParent(BIZ_ORDER_PROPERTY, bizOrder);
        return this;
    }
    

    public RetailStoreMemberGiftCardConsumeRecordRequest unselectBizOrder(){
        unselectParent(BIZ_ORDER_PROPERTY);
        return this;
    }

  


  

   public RetailStoreMemberGiftCardConsumeRecordRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

