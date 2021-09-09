package com.doublechaintech.retailscm.accountingperiod;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingperiod.AccountingPeriod.*;

public class AccountingPeriodRequest extends BaseRequest<AccountingPeriod> {
    public static AccountingPeriodRequest newInstance() {
        return new AccountingPeriodRequest().selectId();
    }

    public String getInternalType() {
        return "AccountingPeriod";
    }

    public AccountingPeriodRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public AccountingPeriodRequest select(String... names) {
        super.select(names);
        return this;
    }

    public AccountingPeriodRequest selectAll() {return this.selectId().selectName().selectStartDate().selectEndDate().selectAccountSet().selectVersion();
    }

    public AccountingPeriodRequest selectSelf() {return this.selectId().selectName().selectStartDate().selectEndDate().selectVersion();
    }

    public AccountingPeriodRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public AccountingPeriodRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static AccountingPeriodRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public AccountingPeriodRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public AccountingPeriodRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingPeriodRequest selectId(){
          return select(ID_PROPERTY);
      }

      public AccountingPeriodRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingPeriodRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public AccountingPeriodRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public AccountingPeriodRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingPeriodRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public AccountingPeriodRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingPeriodRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountingPeriodRequest filterByStartDate(Date startDate) {
          
          if (startDate == null) {
              return this;
          }
          
          return filterByStartDate(QueryOperator.EQUAL, startDate);
      }
    

      public AccountingPeriodRequest filterByStartDate(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getStartDateSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingPeriodRequest selectStartDate(){
          return select(START_DATE_PROPERTY);
      }

      public AccountingPeriodRequest unselectStartDate(){
          return unselect(START_DATE_PROPERTY);
      }

      public SearchCriteria getStartDateSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(START_DATE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingPeriodRequest orderByStartDate(boolean asc){
          addOrderBy(START_DATE_PROPERTY, asc);
          return this;
      }
   
      public AccountingPeriodRequest filterByEndDate(Date endDate) {
          
          if (endDate == null) {
              return this;
          }
          
          return filterByEndDate(QueryOperator.EQUAL, endDate);
      }
    

      public AccountingPeriodRequest filterByEndDate(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEndDateSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingPeriodRequest selectEndDate(){
          return select(END_DATE_PROPERTY);
      }

      public AccountingPeriodRequest unselectEndDate(){
          return unselect(END_DATE_PROPERTY);
      }

      public SearchCriteria getEndDateSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(END_DATE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingPeriodRequest orderByEndDate(boolean asc){
          addOrderBy(END_DATE_PROPERTY, asc);
          return this;
      }
   
      public AccountingPeriodRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public AccountingPeriodRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingPeriodRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public AccountingPeriodRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingPeriodRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public AccountingPeriodRequest filterByAccountSet(AccountSetRequest accountSet){
        return filterByAccountSet(accountSet, accountSetList -> accountSetList.stream().map(AccountSet::getId).collect(Collectors.toSet()));
    }

    public AccountingPeriodRequest filterByAccountSet(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
        return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
    }

    public SearchCriteria createAccountSetCriteria(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
        return new RefinedIdInCriteria(accountSet, ACCOUNT_SET_PROPERTY, idRefine);
    }
    

    
    public AccountingPeriodRequest selectAccountSet(){
        return selectAccountSet(AccountSetRequest.newInstance().selectSelf());
    }

    public AccountingPeriodRequest selectAccountSet(AccountSetRequest accountSet){
        selectParent(ACCOUNT_SET_PROPERTY, accountSet);
        return this;
    }
    

    public AccountingPeriodRequest unselectAccountSet(){
        unselectParent(ACCOUNT_SET_PROPERTY);
        return this;
    }

  


  

    public AccountingPeriodRequest hasAccountingDocument() {
      return hasAccountingDocument(AccountingDocumentRequest.newInstance());
    }

    public AccountingPeriodRequest hasAccountingDocument(AccountingDocumentRequest accountingDocument) {
        return hasAccountingDocument(accountingDocument, accountingDocumentList -> accountingDocumentList.stream().map(AccountingDocument::getAccountingPeriod).map(AccountingPeriod::getId).collect(Collectors.toSet()));
    }

    public AccountingPeriodRequest hasAccountingDocument(AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine) {
        accountingDocument.select(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY);
        return addSearchCriteria(createAccountingDocumentCriteria(accountingDocument, idRefine));
    }

    public SearchCriteria createAccountingDocumentCriteria(AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine){
       return new RefinedIdInCriteria(accountingDocument, ID_PROPERTY, idRefine);
    }

    public AccountingPeriodRequest selectAccountingDocumentList(AccountingDocumentRequest accountingDocument) {
        selectChild(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, accountingDocument);
        return this;
    }

    public AccountingPeriodRequest selectAccountingDocumentList() {
        return selectAccountingDocumentList(AccountingDocumentRequest.newInstance().selectAll());
    }

    public AccountingPeriodRequest unselectAccountingDocumentList(){
        unselectChild(AccountingDocument.ACCOUNTING_PERIOD_PROPERTY, AccountingDocument.class);
        return this;
    }
  

   public AccountingPeriodRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

