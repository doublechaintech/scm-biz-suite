package com.doublechaintech.retailscm.consumerorder;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItemRequest;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroupRequest;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustmentRequest;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroupRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.consumerorder.ConsumerOrder.*;

public class ConsumerOrderRequest extends BaseRequest<ConsumerOrder> {
    public static ConsumerOrderRequest newInstance() {
        return new ConsumerOrderRequest().selectId();
    }

    public String getInternalType() {
        return "ConsumerOrder";
    }

    public ConsumerOrderRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public ConsumerOrderRequest select(String... names) {
        super.select(names);
        return this;
    }

    public ConsumerOrderRequest selectAll() {return this.selectId().selectTitle().selectConsumer().selectStore().selectLastUpdateTime().selectVersion();
    }

    public ConsumerOrderRequest selectSelf() {return this.selectId().selectTitle().selectLastUpdateTime().selectVersion();
    }

    public ConsumerOrderRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public ConsumerOrderRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static ConsumerOrderRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public ConsumerOrderRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public ConsumerOrderRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderRequest selectId(){
          return select(ID_PROPERTY);
      }

      public ConsumerOrderRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public ConsumerOrderRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public ConsumerOrderRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public ConsumerOrderRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public ConsumerOrderRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public ConsumerOrderRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public ConsumerOrderRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public ConsumerOrderRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public ConsumerOrderRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public ConsumerOrderRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public ConsumerOrderRequest filterByConsumer(RetailStoreMemberRequest consumer){
        return filterByConsumer(consumer, consumerList -> consumerList.stream().map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderRequest filterByConsumer(RetailStoreMemberRequest consumer, IDRefine<RetailStoreMember> idRefine) {
        return addSearchCriteria(createConsumerCriteria(consumer, idRefine));
    }

    public SearchCriteria createConsumerCriteria(RetailStoreMemberRequest consumer, IDRefine<RetailStoreMember> idRefine) {
        return new RefinedIdInCriteria(consumer, CONSUMER_PROPERTY, idRefine);
    }
    

    
    public ConsumerOrderRequest selectConsumer(){
        return selectConsumer(RetailStoreMemberRequest.newInstance().selectSelf());
    }

    public ConsumerOrderRequest selectConsumer(RetailStoreMemberRequest consumer){
        selectParent(CONSUMER_PROPERTY, consumer);
        return this;
    }
    

    public ConsumerOrderRequest unselectConsumer(){
        unselectParent(CONSUMER_PROPERTY);
        return this;
    }

  

    
    public ConsumerOrderRequest filterByStore(RetailStoreRequest store){
        return filterByStore(store, storeList -> storeList.stream().map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderRequest filterByStore(RetailStoreRequest store, IDRefine<RetailStore> idRefine) {
        return addSearchCriteria(createStoreCriteria(store, idRefine));
    }

    public SearchCriteria createStoreCriteria(RetailStoreRequest store, IDRefine<RetailStore> idRefine) {
        return new RefinedIdInCriteria(store, STORE_PROPERTY, idRefine);
    }
    

    
    public ConsumerOrderRequest selectStore(){
        return selectStore(RetailStoreRequest.newInstance().selectSelf());
    }

    public ConsumerOrderRequest selectStore(RetailStoreRequest store){
        selectParent(STORE_PROPERTY, store);
        return this;
    }
    

    public ConsumerOrderRequest unselectStore(){
        unselectParent(STORE_PROPERTY);
        return this;
    }

  


  

    public ConsumerOrderRequest hasConsumerOrderLineItem() {
      return hasConsumerOrderLineItem(ConsumerOrderLineItemRequest.newInstance());
    }

    public ConsumerOrderRequest hasConsumerOrderLineItem(ConsumerOrderLineItemRequest consumerOrderLineItem) {
        return hasConsumerOrderLineItem(consumerOrderLineItem, consumerOrderLineItemList -> consumerOrderLineItemList.stream().map(ConsumerOrderLineItem::getBizOrder).map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderRequest hasConsumerOrderLineItem(ConsumerOrderLineItemRequest consumerOrderLineItem, IDRefine<ConsumerOrderLineItem> idRefine) {
        consumerOrderLineItem.select(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createConsumerOrderLineItemCriteria(consumerOrderLineItem, idRefine));
    }

    public SearchCriteria createConsumerOrderLineItemCriteria(ConsumerOrderLineItemRequest consumerOrderLineItem, IDRefine<ConsumerOrderLineItem> idRefine){
       return new RefinedIdInCriteria(consumerOrderLineItem, ID_PROPERTY, idRefine);
    }

    public ConsumerOrderRequest selectConsumerOrderLineItemList(ConsumerOrderLineItemRequest consumerOrderLineItem) {
        selectChild(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, consumerOrderLineItem);
        return this;
    }

    public ConsumerOrderRequest selectConsumerOrderLineItemList() {
        return selectConsumerOrderLineItemList(ConsumerOrderLineItemRequest.newInstance().selectAll());
    }

    public ConsumerOrderRequest unselectConsumerOrderLineItemList(){
        unselectChild(ConsumerOrderLineItem.BIZ_ORDER_PROPERTY, ConsumerOrderLineItem.class);
        return this;
    }
  

    public ConsumerOrderRequest hasConsumerOrderShippingGroup() {
      return hasConsumerOrderShippingGroup(ConsumerOrderShippingGroupRequest.newInstance());
    }

    public ConsumerOrderRequest hasConsumerOrderShippingGroup(ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
        return hasConsumerOrderShippingGroup(consumerOrderShippingGroup, consumerOrderShippingGroupList -> consumerOrderShippingGroupList.stream().map(ConsumerOrderShippingGroup::getBizOrder).map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderRequest hasConsumerOrderShippingGroup(ConsumerOrderShippingGroupRequest consumerOrderShippingGroup, IDRefine<ConsumerOrderShippingGroup> idRefine) {
        consumerOrderShippingGroup.select(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createConsumerOrderShippingGroupCriteria(consumerOrderShippingGroup, idRefine));
    }

    public SearchCriteria createConsumerOrderShippingGroupCriteria(ConsumerOrderShippingGroupRequest consumerOrderShippingGroup, IDRefine<ConsumerOrderShippingGroup> idRefine){
       return new RefinedIdInCriteria(consumerOrderShippingGroup, ID_PROPERTY, idRefine);
    }

    public ConsumerOrderRequest selectConsumerOrderShippingGroupList(ConsumerOrderShippingGroupRequest consumerOrderShippingGroup) {
        selectChild(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, consumerOrderShippingGroup);
        return this;
    }

    public ConsumerOrderRequest selectConsumerOrderShippingGroupList() {
        return selectConsumerOrderShippingGroupList(ConsumerOrderShippingGroupRequest.newInstance().selectAll());
    }

    public ConsumerOrderRequest unselectConsumerOrderShippingGroupList(){
        unselectChild(ConsumerOrderShippingGroup.BIZ_ORDER_PROPERTY, ConsumerOrderShippingGroup.class);
        return this;
    }
  

    public ConsumerOrderRequest hasConsumerOrderPaymentGroup() {
      return hasConsumerOrderPaymentGroup(ConsumerOrderPaymentGroupRequest.newInstance());
    }

    public ConsumerOrderRequest hasConsumerOrderPaymentGroup(ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
        return hasConsumerOrderPaymentGroup(consumerOrderPaymentGroup, consumerOrderPaymentGroupList -> consumerOrderPaymentGroupList.stream().map(ConsumerOrderPaymentGroup::getBizOrder).map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderRequest hasConsumerOrderPaymentGroup(ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup, IDRefine<ConsumerOrderPaymentGroup> idRefine) {
        consumerOrderPaymentGroup.select(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createConsumerOrderPaymentGroupCriteria(consumerOrderPaymentGroup, idRefine));
    }

    public SearchCriteria createConsumerOrderPaymentGroupCriteria(ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup, IDRefine<ConsumerOrderPaymentGroup> idRefine){
       return new RefinedIdInCriteria(consumerOrderPaymentGroup, ID_PROPERTY, idRefine);
    }

    public ConsumerOrderRequest selectConsumerOrderPaymentGroupList(ConsumerOrderPaymentGroupRequest consumerOrderPaymentGroup) {
        selectChild(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, consumerOrderPaymentGroup);
        return this;
    }

    public ConsumerOrderRequest selectConsumerOrderPaymentGroupList() {
        return selectConsumerOrderPaymentGroupList(ConsumerOrderPaymentGroupRequest.newInstance().selectAll());
    }

    public ConsumerOrderRequest unselectConsumerOrderPaymentGroupList(){
        unselectChild(ConsumerOrderPaymentGroup.BIZ_ORDER_PROPERTY, ConsumerOrderPaymentGroup.class);
        return this;
    }
  

    public ConsumerOrderRequest hasConsumerOrderPriceAdjustment() {
      return hasConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustmentRequest.newInstance());
    }

    public ConsumerOrderRequest hasConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
        return hasConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment, consumerOrderPriceAdjustmentList -> consumerOrderPriceAdjustmentList.stream().map(ConsumerOrderPriceAdjustment::getBizOrder).map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderRequest hasConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment, IDRefine<ConsumerOrderPriceAdjustment> idRefine) {
        consumerOrderPriceAdjustment.select(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createConsumerOrderPriceAdjustmentCriteria(consumerOrderPriceAdjustment, idRefine));
    }

    public SearchCriteria createConsumerOrderPriceAdjustmentCriteria(ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment, IDRefine<ConsumerOrderPriceAdjustment> idRefine){
       return new RefinedIdInCriteria(consumerOrderPriceAdjustment, ID_PROPERTY, idRefine);
    }

    public ConsumerOrderRequest selectConsumerOrderPriceAdjustmentList(ConsumerOrderPriceAdjustmentRequest consumerOrderPriceAdjustment) {
        selectChild(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, consumerOrderPriceAdjustment);
        return this;
    }

    public ConsumerOrderRequest selectConsumerOrderPriceAdjustmentList() {
        return selectConsumerOrderPriceAdjustmentList(ConsumerOrderPriceAdjustmentRequest.newInstance().selectAll());
    }

    public ConsumerOrderRequest unselectConsumerOrderPriceAdjustmentList(){
        unselectChild(ConsumerOrderPriceAdjustment.BIZ_ORDER_PROPERTY, ConsumerOrderPriceAdjustment.class);
        return this;
    }
  

    public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord() {
      return hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecordRequest.newInstance());
    }

    public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
        return hasRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord, retailStoreMemberGiftCardConsumeRecordList -> retailStoreMemberGiftCardConsumeRecordList.stream().map(RetailStoreMemberGiftCardConsumeRecord::getBizOrder).map(ConsumerOrder::getId).collect(Collectors.toSet()));
    }

    public ConsumerOrderRequest hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord, IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine) {
        retailStoreMemberGiftCardConsumeRecord.select(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY);
        return addSearchCriteria(createRetailStoreMemberGiftCardConsumeRecordCriteria(retailStoreMemberGiftCardConsumeRecord, idRefine));
    }

    public SearchCriteria createRetailStoreMemberGiftCardConsumeRecordCriteria(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord, IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine){
       return new RefinedIdInCriteria(retailStoreMemberGiftCardConsumeRecord, ID_PROPERTY, idRefine);
    }

    public ConsumerOrderRequest selectRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
        selectChild(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, retailStoreMemberGiftCardConsumeRecord);
        return this;
    }

    public ConsumerOrderRequest selectRetailStoreMemberGiftCardConsumeRecordList() {
        return selectRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCardConsumeRecordRequest.newInstance().selectAll());
    }

    public ConsumerOrderRequest unselectRetailStoreMemberGiftCardConsumeRecordList(){
        unselectChild(RetailStoreMemberGiftCardConsumeRecord.BIZ_ORDER_PROPERTY, RetailStoreMemberGiftCardConsumeRecord.class);
        return this;
    }
  

   public ConsumerOrderRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

