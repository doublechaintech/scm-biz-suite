package com.doublechaintech.retailscm.retailstoremembergiftcard;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMemberRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecordRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard.*;

public class RetailStoreMemberGiftCardRequest extends BaseRequest<RetailStoreMemberGiftCard> {
    public static RetailStoreMemberGiftCardRequest newInstance() {
        return new RetailStoreMemberGiftCardRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreMemberGiftCard";
    }

    public RetailStoreMemberGiftCardRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreMemberGiftCardRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreMemberGiftCardRequest selectAll() {return this.selectId().selectName().selectOwner().selectNumber().selectRemain().selectVersion();
    }

    public RetailStoreMemberGiftCardRequest selectSelf() {return this.selectId().selectName().selectNumber().selectRemain().selectVersion();
    }

    public RetailStoreMemberGiftCardRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreMemberGiftCardRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreMemberGiftCardRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreMemberGiftCardRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreMemberGiftCardRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreMemberGiftCardRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreMemberGiftCardRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreMemberGiftCardRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardRequest filterByNumber(String number) {
          
          if (number == null) {
              return this;
          }
          
          return filterByNumber(QueryOperator.EQUAL, number);
      }
    

      public RetailStoreMemberGiftCardRequest filterByNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardRequest selectNumber(){
          return select(NUMBER_PROPERTY);
      }

      public RetailStoreMemberGiftCardRequest unselectNumber(){
          return unselect(NUMBER_PROPERTY);
      }

      public SearchCriteria getNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardRequest orderByNumber(boolean asc){
          addOrderBy(NUMBER_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardRequest filterByRemain(BigDecimal remain) {
          
          if (remain == null) {
              return this;
          }
          
          return filterByRemain(QueryOperator.EQUAL, remain);
      }
    

      public RetailStoreMemberGiftCardRequest filterByRemain(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemainSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardRequest selectRemain(){
          return select(REMAIN_PROPERTY);
      }

      public RetailStoreMemberGiftCardRequest unselectRemain(){
          return unselect(REMAIN_PROPERTY);
      }

      public SearchCriteria getRemainSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMAIN_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardRequest orderByRemain(boolean asc){
          addOrderBy(REMAIN_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberGiftCardRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreMemberGiftCardRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberGiftCardRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreMemberGiftCardRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberGiftCardRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreMemberGiftCardRequest filterByOwner(RetailStoreMemberRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberGiftCardRequest filterByOwner(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreMemberRequest owner, IDRefine<RetailStoreMember> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreMemberGiftCardRequest selectOwner(){
        return selectOwner(RetailStoreMemberRequest.newInstance().selectSelf());
    }

    public RetailStoreMemberGiftCardRequest selectOwner(RetailStoreMemberRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public RetailStoreMemberGiftCardRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

    public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord() {
      return hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecordRequest.newInstance());
    }

    public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
        return hasRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord, retailStoreMemberGiftCardConsumeRecordList -> retailStoreMemberGiftCardConsumeRecordList.stream().map(RetailStoreMemberGiftCardConsumeRecord::getOwner).map(RetailStoreMemberGiftCard::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberGiftCardRequest hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord, IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine) {
        retailStoreMemberGiftCardConsumeRecord.select(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY);
        return addSearchCriteria(createRetailStoreMemberGiftCardConsumeRecordCriteria(retailStoreMemberGiftCardConsumeRecord, idRefine));
    }

    public SearchCriteria createRetailStoreMemberGiftCardConsumeRecordCriteria(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord, IDRefine<RetailStoreMemberGiftCardConsumeRecord> idRefine){
       return new RefinedIdInCriteria(retailStoreMemberGiftCardConsumeRecord, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberGiftCardRequest selectRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCardConsumeRecordRequest retailStoreMemberGiftCardConsumeRecord) {
        selectChild(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, retailStoreMemberGiftCardConsumeRecord);
        return this;
    }

    public RetailStoreMemberGiftCardRequest selectRetailStoreMemberGiftCardConsumeRecordList() {
        return selectRetailStoreMemberGiftCardConsumeRecordList(RetailStoreMemberGiftCardConsumeRecordRequest.newInstance().selectAll());
    }

    public RetailStoreMemberGiftCardRequest unselectRetailStoreMemberGiftCardConsumeRecordList(){
        unselectChild(RetailStoreMemberGiftCardConsumeRecord.OWNER_PROPERTY, RetailStoreMemberGiftCardConsumeRecord.class);
        return this;
    }
  

   public RetailStoreMemberGiftCardRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

