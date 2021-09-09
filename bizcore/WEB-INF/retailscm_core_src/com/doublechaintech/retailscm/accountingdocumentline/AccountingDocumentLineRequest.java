package com.doublechaintech.retailscm.accountingdocumentline;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine.*;

public class AccountingDocumentLineRequest extends BaseRequest<AccountingDocumentLine> {
    public static AccountingDocumentLineRequest newInstance() {
        return new AccountingDocumentLineRequest().selectId();
    }

    public String getInternalType() {
        return "AccountingDocumentLine";
    }

    public AccountingDocumentLineRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public AccountingDocumentLineRequest select(String... names) {
        super.select(names);
        return this;
    }

    public AccountingDocumentLineRequest selectAll() {return this.selectId().selectName().selectCode().selectDirect().selectAmount().selectBelongsTo().selectAccountingSubject().selectVersion();
    }

    public AccountingDocumentLineRequest selectSelf() {return this.selectId().selectName().selectCode().selectDirect().selectAmount().selectVersion();
    }

    public AccountingDocumentLineRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public AccountingDocumentLineRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static AccountingDocumentLineRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public AccountingDocumentLineRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public AccountingDocumentLineRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentLineRequest selectId(){
          return select(ID_PROPERTY);
      }

      public AccountingDocumentLineRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentLineRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentLineRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public AccountingDocumentLineRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentLineRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public AccountingDocumentLineRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentLineRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentLineRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public AccountingDocumentLineRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentLineRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public AccountingDocumentLineRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentLineRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentLineRequest filterByDirect(String direct) {
          
          if (direct == null) {
              return this;
          }
          
          return filterByDirect(QueryOperator.EQUAL, direct);
      }
    

      public AccountingDocumentLineRequest filterByDirect(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDirectSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentLineRequest selectDirect(){
          return select(DIRECT_PROPERTY);
      }

      public AccountingDocumentLineRequest unselectDirect(){
          return unselect(DIRECT_PROPERTY);
      }

      public SearchCriteria getDirectSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DIRECT_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentLineRequest orderByDirect(boolean asc){
          addOrderBy(DIRECT_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentLineRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public AccountingDocumentLineRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentLineRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public AccountingDocumentLineRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentLineRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentLineRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public AccountingDocumentLineRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentLineRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public AccountingDocumentLineRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentLineRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public AccountingDocumentLineRequest filterByBelongsTo(AccountingDocumentRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(AccountingDocument::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentLineRequest filterByBelongsTo(AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public AccountingDocumentLineRequest selectBelongsTo(){
        return selectBelongsTo(AccountingDocumentRequest.newInstance().selectSelf());
    }

    public AccountingDocumentLineRequest selectBelongsTo(AccountingDocumentRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public AccountingDocumentLineRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  

    
    public AccountingDocumentLineRequest filterByAccountingSubject(AccountingSubjectRequest accountingSubject){
        return filterByAccountingSubject(accountingSubject, accountingSubjectList -> accountingSubjectList.stream().map(AccountingSubject::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentLineRequest filterByAccountingSubject(AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine) {
        return addSearchCriteria(createAccountingSubjectCriteria(accountingSubject, idRefine));
    }

    public SearchCriteria createAccountingSubjectCriteria(AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine) {
        return new RefinedIdInCriteria(accountingSubject, ACCOUNTING_SUBJECT_PROPERTY, idRefine);
    }
    

    
    public AccountingDocumentLineRequest selectAccountingSubject(){
        return selectAccountingSubject(AccountingSubjectRequest.newInstance().selectSelf());
    }

    public AccountingDocumentLineRequest selectAccountingSubject(AccountingSubjectRequest accountingSubject){
        selectParent(ACCOUNTING_SUBJECT_PROPERTY, accountingSubject);
        return this;
    }
    

    public AccountingDocumentLineRequest unselectAccountingSubject(){
        unselectParent(ACCOUNTING_SUBJECT_PROPERTY);
        return this;
    }

  


  

   public AccountingDocumentLineRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

