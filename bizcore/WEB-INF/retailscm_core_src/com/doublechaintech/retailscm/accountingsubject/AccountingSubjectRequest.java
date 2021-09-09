package com.doublechaintech.retailscm.accountingsubject;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingsubject.AccountingSubject.*;

public class AccountingSubjectRequest extends BaseRequest<AccountingSubject> {
    public static AccountingSubjectRequest newInstance() {
        return new AccountingSubjectRequest().selectId();
    }

    public String getInternalType() {
        return "AccountingSubject";
    }

    public AccountingSubjectRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public AccountingSubjectRequest select(String... names) {
        super.select(names);
        return this;
    }

    public AccountingSubjectRequest selectAll() {return this.selectId().selectAccountingSubjectCode().selectAccountingSubjectName().selectAccountingSubjectClassCode().selectAccountingSubjectClassName().selectAccountSet().selectVersion();
    }

    public AccountingSubjectRequest selectSelf() {return this.selectId().selectAccountingSubjectCode().selectAccountingSubjectName().selectAccountingSubjectClassCode().selectAccountingSubjectClassName().selectVersion();
    }

    public AccountingSubjectRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public AccountingSubjectRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static AccountingSubjectRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public AccountingSubjectRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public AccountingSubjectRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingSubjectRequest selectId(){
          return select(ID_PROPERTY);
      }

      public AccountingSubjectRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingSubjectRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public AccountingSubjectRequest filterByAccountingSubjectCode(String accountingSubjectCode) {
          
          if (accountingSubjectCode == null) {
              return this;
          }
          
          return filterByAccountingSubjectCode(QueryOperator.EQUAL, accountingSubjectCode);
      }
    

      public AccountingSubjectRequest filterByAccountingSubjectCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccountingSubjectCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingSubjectRequest selectAccountingSubjectCode(){
          return select(ACCOUNTING_SUBJECT_CODE_PROPERTY);
      }

      public AccountingSubjectRequest unselectAccountingSubjectCode(){
          return unselect(ACCOUNTING_SUBJECT_CODE_PROPERTY);
      }

      public SearchCriteria getAccountingSubjectCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCOUNTING_SUBJECT_CODE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingSubjectRequest orderByAccountingSubjectCode(boolean asc){
          addOrderBy(ACCOUNTING_SUBJECT_CODE_PROPERTY, asc);
          return this;
      }
   
      public AccountingSubjectRequest filterByAccountingSubjectName(String accountingSubjectName) {
          
          if (accountingSubjectName == null) {
              return this;
          }
          
          return filterByAccountingSubjectName(QueryOperator.EQUAL, accountingSubjectName);
      }
    

      public AccountingSubjectRequest filterByAccountingSubjectName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccountingSubjectNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingSubjectRequest selectAccountingSubjectName(){
          return select(ACCOUNTING_SUBJECT_NAME_PROPERTY);
      }

      public AccountingSubjectRequest unselectAccountingSubjectName(){
          return unselect(ACCOUNTING_SUBJECT_NAME_PROPERTY);
      }

      public SearchCriteria getAccountingSubjectNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCOUNTING_SUBJECT_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingSubjectRequest orderByAccountingSubjectName(boolean asc){
          addOrderBy(ACCOUNTING_SUBJECT_NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountingSubjectRequest filterByAccountingSubjectClassCode(int accountingSubjectClassCode) {
          
          return filterByAccountingSubjectClassCode(QueryOperator.EQUAL, accountingSubjectClassCode);
      }
    

      public AccountingSubjectRequest filterByAccountingSubjectClassCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccountingSubjectClassCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingSubjectRequest selectAccountingSubjectClassCode(){
          return select(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
      }

      public AccountingSubjectRequest unselectAccountingSubjectClassCode(){
          return unselect(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY);
      }

      public SearchCriteria getAccountingSubjectClassCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingSubjectRequest orderByAccountingSubjectClassCode(boolean asc){
          addOrderBy(ACCOUNTING_SUBJECT_CLASS_CODE_PROPERTY, asc);
          return this;
      }
   
      public AccountingSubjectRequest filterByAccountingSubjectClassName(String accountingSubjectClassName) {
          
          if (accountingSubjectClassName == null) {
              return this;
          }
          
          return filterByAccountingSubjectClassName(QueryOperator.EQUAL, accountingSubjectClassName);
      }
    

      public AccountingSubjectRequest filterByAccountingSubjectClassName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccountingSubjectClassNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingSubjectRequest selectAccountingSubjectClassName(){
          return select(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
      }

      public AccountingSubjectRequest unselectAccountingSubjectClassName(){
          return unselect(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY);
      }

      public SearchCriteria getAccountingSubjectClassNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingSubjectRequest orderByAccountingSubjectClassName(boolean asc){
          addOrderBy(ACCOUNTING_SUBJECT_CLASS_NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountingSubjectRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public AccountingSubjectRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingSubjectRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public AccountingSubjectRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingSubjectRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public AccountingSubjectRequest filterByAccountSet(AccountSetRequest accountSet){
        return filterByAccountSet(accountSet, accountSetList -> accountSetList.stream().map(AccountSet::getId).collect(Collectors.toSet()));
    }

    public AccountingSubjectRequest filterByAccountSet(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
        return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
    }

    public SearchCriteria createAccountSetCriteria(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
        return new RefinedIdInCriteria(accountSet, ACCOUNT_SET_PROPERTY, idRefine);
    }
    

    
    public AccountingSubjectRequest selectAccountSet(){
        return selectAccountSet(AccountSetRequest.newInstance().selectSelf());
    }

    public AccountingSubjectRequest selectAccountSet(AccountSetRequest accountSet){
        selectParent(ACCOUNT_SET_PROPERTY, accountSet);
        return this;
    }
    

    public AccountingSubjectRequest unselectAccountSet(){
        unselectParent(ACCOUNT_SET_PROPERTY);
        return this;
    }

  


  

    public AccountingSubjectRequest hasAccountingDocumentLine() {
      return hasAccountingDocumentLine(AccountingDocumentLineRequest.newInstance());
    }

    public AccountingSubjectRequest hasAccountingDocumentLine(AccountingDocumentLineRequest accountingDocumentLine) {
        return hasAccountingDocumentLine(accountingDocumentLine, accountingDocumentLineList -> accountingDocumentLineList.stream().map(AccountingDocumentLine::getAccountingSubject).map(AccountingSubject::getId).collect(Collectors.toSet()));
    }

    public AccountingSubjectRequest hasAccountingDocumentLine(AccountingDocumentLineRequest accountingDocumentLine, IDRefine<AccountingDocumentLine> idRefine) {
        accountingDocumentLine.select(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY);
        return addSearchCriteria(createAccountingDocumentLineCriteria(accountingDocumentLine, idRefine));
    }

    public SearchCriteria createAccountingDocumentLineCriteria(AccountingDocumentLineRequest accountingDocumentLine, IDRefine<AccountingDocumentLine> idRefine){
       return new RefinedIdInCriteria(accountingDocumentLine, ID_PROPERTY, idRefine);
    }

    public AccountingSubjectRequest selectAccountingDocumentLineList(AccountingDocumentLineRequest accountingDocumentLine) {
        selectChild(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, accountingDocumentLine);
        return this;
    }

    public AccountingSubjectRequest selectAccountingDocumentLineList() {
        return selectAccountingDocumentLineList(AccountingDocumentLineRequest.newInstance().selectAll());
    }

    public AccountingSubjectRequest unselectAccountingDocumentLineList(){
        unselectChild(AccountingDocumentLine.ACCOUNTING_SUBJECT_PROPERTY, AccountingDocumentLine.class);
        return this;
    }
  

   public AccountingSubjectRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

