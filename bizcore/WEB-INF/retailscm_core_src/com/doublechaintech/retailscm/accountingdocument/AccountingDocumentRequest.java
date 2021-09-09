package com.doublechaintech.retailscm.accountingdocument;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLine;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucher;
import com.doublechaintech.retailscm.accountingdocumentline.AccountingDocumentLineRequest;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest;
import com.doublechaintech.retailscm.originalvoucher.OriginalVoucherRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountingdocument.AccountingDocument.*;

public class AccountingDocumentRequest extends BaseRequest<AccountingDocument> {
    public static AccountingDocumentRequest newInstance() {
        return new AccountingDocumentRequest().selectId();
    }

    public String getInternalType() {
        return "AccountingDocument";
    }

    public AccountingDocumentRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public AccountingDocumentRequest select(String... names) {
        super.select(names);
        return this;
    }

    public AccountingDocumentRequest selectAll() {return this.selectId().selectName().selectAccountingDocumentDate().selectAccountingPeriod().selectDocumentType().selectVersion();
    }

    public AccountingDocumentRequest selectSelf() {return this.selectId().selectName().selectAccountingDocumentDate().selectVersion();
    }

    public AccountingDocumentRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public AccountingDocumentRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static AccountingDocumentRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public AccountingDocumentRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public AccountingDocumentRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentRequest selectId(){
          return select(ID_PROPERTY);
      }

      public AccountingDocumentRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public AccountingDocumentRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public AccountingDocumentRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentRequest filterByAccountingDocumentDate(Date accountingDocumentDate) {
          
          if (accountingDocumentDate == null) {
              return this;
          }
          
          return filterByAccountingDocumentDate(QueryOperator.EQUAL, accountingDocumentDate);
      }
    

      public AccountingDocumentRequest filterByAccountingDocumentDate(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccountingDocumentDateSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentRequest selectAccountingDocumentDate(){
          return select(ACCOUNTING_DOCUMENT_DATE_PROPERTY);
      }

      public AccountingDocumentRequest unselectAccountingDocumentDate(){
          return unselect(ACCOUNTING_DOCUMENT_DATE_PROPERTY);
      }

      public SearchCriteria getAccountingDocumentDateSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCOUNTING_DOCUMENT_DATE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentRequest orderByAccountingDocumentDate(boolean asc){
          addOrderBy(ACCOUNTING_DOCUMENT_DATE_PROPERTY, asc);
          return this;
      }
   
      public AccountingDocumentRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public AccountingDocumentRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountingDocumentRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public AccountingDocumentRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public AccountingDocumentRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public AccountingDocumentRequest filterByAccountingPeriod(AccountingPeriodRequest accountingPeriod){
        return filterByAccountingPeriod(accountingPeriod, accountingPeriodList -> accountingPeriodList.stream().map(AccountingPeriod::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentRequest filterByAccountingPeriod(AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine) {
        return addSearchCriteria(createAccountingPeriodCriteria(accountingPeriod, idRefine));
    }

    public SearchCriteria createAccountingPeriodCriteria(AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine) {
        return new RefinedIdInCriteria(accountingPeriod, ACCOUNTING_PERIOD_PROPERTY, idRefine);
    }
    

    
    public AccountingDocumentRequest selectAccountingPeriod(){
        return selectAccountingPeriod(AccountingPeriodRequest.newInstance().selectSelf());
    }

    public AccountingDocumentRequest selectAccountingPeriod(AccountingPeriodRequest accountingPeriod){
        selectParent(ACCOUNTING_PERIOD_PROPERTY, accountingPeriod);
        return this;
    }
    

    public AccountingDocumentRequest unselectAccountingPeriod(){
        unselectParent(ACCOUNTING_PERIOD_PROPERTY);
        return this;
    }

  

    
    public AccountingDocumentRequest filterByDocumentType(AccountingDocumentTypeRequest documentType){
        return filterByDocumentType(documentType, documentTypeList -> documentTypeList.stream().map(AccountingDocumentType::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentRequest filterByDocumentType(AccountingDocumentTypeRequest documentType, IDRefine<AccountingDocumentType> idRefine) {
        return addSearchCriteria(createDocumentTypeCriteria(documentType, idRefine));
    }

    public SearchCriteria createDocumentTypeCriteria(AccountingDocumentTypeRequest documentType, IDRefine<AccountingDocumentType> idRefine) {
        return new RefinedIdInCriteria(documentType, DOCUMENT_TYPE_PROPERTY, idRefine);
    }
    

    
    public AccountingDocumentRequest selectDocumentType(){
        return selectDocumentType(AccountingDocumentTypeRequest.newInstance().selectSelf());
    }

    public AccountingDocumentRequest selectDocumentType(AccountingDocumentTypeRequest documentType){
        selectParent(DOCUMENT_TYPE_PROPERTY, documentType);
        return this;
    }
    

    public AccountingDocumentRequest unselectDocumentType(){
        unselectParent(DOCUMENT_TYPE_PROPERTY);
        return this;
    }

  


  

    public AccountingDocumentRequest hasOriginalVoucher() {
      return hasOriginalVoucher(OriginalVoucherRequest.newInstance());
    }

    public AccountingDocumentRequest hasOriginalVoucher(OriginalVoucherRequest originalVoucher) {
        return hasOriginalVoucher(originalVoucher, originalVoucherList -> originalVoucherList.stream().map(OriginalVoucher::getBelongsTo).map(AccountingDocument::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentRequest hasOriginalVoucher(OriginalVoucherRequest originalVoucher, IDRefine<OriginalVoucher> idRefine) {
        originalVoucher.select(OriginalVoucher.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createOriginalVoucherCriteria(originalVoucher, idRefine));
    }

    public SearchCriteria createOriginalVoucherCriteria(OriginalVoucherRequest originalVoucher, IDRefine<OriginalVoucher> idRefine){
       return new RefinedIdInCriteria(originalVoucher, ID_PROPERTY, idRefine);
    }

    public AccountingDocumentRequest selectOriginalVoucherList(OriginalVoucherRequest originalVoucher) {
        selectChild(OriginalVoucher.BELONGS_TO_PROPERTY, originalVoucher);
        return this;
    }

    public AccountingDocumentRequest selectOriginalVoucherList() {
        return selectOriginalVoucherList(OriginalVoucherRequest.newInstance().selectAll());
    }

    public AccountingDocumentRequest unselectOriginalVoucherList(){
        unselectChild(OriginalVoucher.BELONGS_TO_PROPERTY, OriginalVoucher.class);
        return this;
    }
  

    public AccountingDocumentRequest hasAccountingDocumentLine() {
      return hasAccountingDocumentLine(AccountingDocumentLineRequest.newInstance());
    }

    public AccountingDocumentRequest hasAccountingDocumentLine(AccountingDocumentLineRequest accountingDocumentLine) {
        return hasAccountingDocumentLine(accountingDocumentLine, accountingDocumentLineList -> accountingDocumentLineList.stream().map(AccountingDocumentLine::getBelongsTo).map(AccountingDocument::getId).collect(Collectors.toSet()));
    }

    public AccountingDocumentRequest hasAccountingDocumentLine(AccountingDocumentLineRequest accountingDocumentLine, IDRefine<AccountingDocumentLine> idRefine) {
        accountingDocumentLine.select(AccountingDocumentLine.BELONGS_TO_PROPERTY);
        return addSearchCriteria(createAccountingDocumentLineCriteria(accountingDocumentLine, idRefine));
    }

    public SearchCriteria createAccountingDocumentLineCriteria(AccountingDocumentLineRequest accountingDocumentLine, IDRefine<AccountingDocumentLine> idRefine){
       return new RefinedIdInCriteria(accountingDocumentLine, ID_PROPERTY, idRefine);
    }

    public AccountingDocumentRequest selectAccountingDocumentLineList(AccountingDocumentLineRequest accountingDocumentLine) {
        selectChild(AccountingDocumentLine.BELONGS_TO_PROPERTY, accountingDocumentLine);
        return this;
    }

    public AccountingDocumentRequest selectAccountingDocumentLineList() {
        return selectAccountingDocumentLineList(AccountingDocumentLineRequest.newInstance().selectAll());
    }

    public AccountingDocumentRequest unselectAccountingDocumentLineList(){
        unselectChild(AccountingDocumentLine.BELONGS_TO_PROPERTY, AccountingDocumentLine.class);
        return this;
    }
  

   public AccountingDocumentRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

