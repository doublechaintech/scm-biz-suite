package com.doublechaintech.retailscm.accountingdocumenttype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType.*;

public class AccountingDocumentTypeRequest extends BaseRequest<AccountingDocumentType> {
    public static AccountingDocumentTypeRequest newInstance() {
        return new AccountingDocumentTypeRequest().selectId();
    }

    public String getInternalType() {
        return "AccountingDocumentType";
    }

    public AccountingDocumentTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public AccountingDocumentTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public AccountingDocumentTypeRequest selectAll() {return this.selectId().selectName().selectDescription().selectAccountingPeriod().selectVersion();
    }

    public AccountingDocumentTypeRequest selectSelf() {return this.selectId().selectName().selectDescription().selectVersion();
    }

    public AccountingDocumentTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public AccountingDocumentTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static AccountingDocumentTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public AccountingDocumentTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public AccountingDocumentTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public AccountingDocumentTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentTypeRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public AccountingDocumentTypeRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentTypeRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public AccountingDocumentTypeRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentTypeRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentTypeRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public AccountingDocumentTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentTypeRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public AccountingDocumentTypeRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentTypeRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public AccountingDocumentTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public AccountingDocumentTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public AccountingDocumentTypeRequest filterByAccountingPeriod(AccountSetRequest accountingPeriod){
        return filterByAccountingPeriod(accountingPeriod, accountingPeriodList -> accountingPeriodList.stream().map(AccountSet::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentTypeRequest filterByAccountingPeriod(AccountSetRequest accountingPeriod, IDRefine<AccountSet> idRefine) {
        return addSearchCriteria(createAccountingPeriodCriteria(accountingPeriod, idRefine));
    }

    public SearchCriteria createAccountingPeriodCriteria(AccountSetRequest accountingPeriod, IDRefine<AccountSet> idRefine) {
        return new RefinedIdInCriteria(accountingPeriod, ACCOUNTING_PERIOD_PROPERTY, idRefine);
    }
    

    
    public AccountingDocumentTypeRequest selectAccountingPeriod(){
        return selectAccountingPeriod(AccountSetRequest.newInstance().selectSelf());
    }

    public AccountingDocumentTypeRequest selectAccountingPeriod(AccountSetRequest accountingPeriod){
        selectParent(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
        return this;
    }
    

    public AccountingDocumentTypeRequest unselectAccountingPeriod(){
        unselectParent(ACCOUNTING_PERIOD_PROPERTY);
        return this;
    }

  


  

    public AccountingDocumentTypeRequest hasAccountingDocument() {
      return hasAccountingDocument(AccountingDocumentRequest.newInstance());
    }

    public AccountingDocumentTypeRequest hasAccountingDocument(AccountingDocumentRequest accountingDocument) {
        return hasAccountingDocument(accountingDocument, accountingDocumentList -> accountingDocumentList.stream().map(AccountingDocument::getDocumentType).map(AccountingDocumentType::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentTypeRequest hasAccountingDocument(AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine) {
        accountingDocument.select(AccountingDocument.DOCUMENT_TYPE_PROPERTY);
        return addSearchCriteria(createAccountingDocumentCriteria(accountingDocument, idRefine));
    }

    public SearchCriteria createAccountingDocumentCriteria(AccountingDocumentRequest accountingDocument, IDRefine<AccountingDocument> idRefine){
       return new RefinedIdInCriteria(accountingDocument, ID_PROPERTY, idRefine);
    }

    public AccountingDocumentTypeRequest selectAccountingDocumentList(AccountingDocumentRequest accountingDocument) {
        selectChild(AccountingDocument.DOCUMENT_TYPE_PROPERTY, accountingDocument);
        return this;
    }

    public AccountingDocumentTypeRequest selectAccountingDocumentList() {
        return selectAccountingDocumentList(AccountingDocumentRequest.newInstance().selectAll());
    }

    public AccountingDocumentTypeRequest unselectAccountingDocumentList(){
        unselectChild(AccountingDocument.DOCUMENT_TYPE_PROPERTY, AccountingDocument.class);
        return this;
    }
  

   public AccountingDocumentTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

