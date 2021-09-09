package com.doublechaintech.retailscm.accountset;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.util.Date;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentType;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriod;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubject;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.accountingdocumenttype.AccountingDocumentTypeRequest;
import com.doublechaintech.retailscm.accountingperiod.AccountingPeriodRequest;
import com.doublechaintech.retailscm.accountingsubject.AccountingSubjectRequest;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplierRequest;
import com.doublechaintech.retailscm.retailstore.RetailStoreRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.accountset.AccountSet.*;

public class AccountSetRequest extends BaseRequest<AccountSet> {
    public static AccountSetRequest newInstance() {
        return new AccountSetRequest().selectId();
    }

    public String getInternalType() {
        return "AccountSet";
    }

    public AccountSetRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public AccountSetRequest select(String... names) {
        super.select(names);
        return this;
    }

    public AccountSetRequest selectAll() {return this.selectId().selectName().selectYearSet().selectEffectiveDate().selectAccountingSystem().selectDomesticCurrencyCode().selectDomesticCurrencyName().selectOpeningBank().selectAccountNumber().selectCountryCenter().selectRetailStore().selectGoodsSupplier().selectLastUpdateTime().selectVersion();
    }

    public AccountSetRequest selectSelf() {return this.selectId().selectName().selectYearSet().selectEffectiveDate().selectAccountingSystem().selectDomesticCurrencyCode().selectDomesticCurrencyName().selectOpeningBank().selectAccountNumber().selectLastUpdateTime().selectVersion();
    }

    public AccountSetRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public AccountSetRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static AccountSetRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public AccountSetRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public AccountSetRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectId(){
          return select(ID_PROPERTY);
      }

      public AccountSetRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public AccountSetRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public AccountSetRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByYearSet(String yearSet) {
          
          if (yearSet == null) {
              return this;
          }
          
          return filterByYearSet(QueryOperator.EQUAL, yearSet);
      }
    

      public AccountSetRequest filterByYearSet(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getYearSetSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectYearSet(){
          return select(YEAR_SET_PROPERTY);
      }

      public AccountSetRequest unselectYearSet(){
          return unselect(YEAR_SET_PROPERTY);
      }

      public SearchCriteria getYearSetSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(YEAR_SET_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByYearSet(boolean asc){
          addOrderBy(YEAR_SET_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByEffectiveDate(Date effectiveDate) {
          
          if (effectiveDate == null) {
              return this;
          }
          
          return filterByEffectiveDate(QueryOperator.EQUAL, effectiveDate);
      }
    

      public AccountSetRequest filterByEffectiveDate(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEffectiveDateSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectEffectiveDate(){
          return select(EFFECTIVE_DATE_PROPERTY);
      }

      public AccountSetRequest unselectEffectiveDate(){
          return unselect(EFFECTIVE_DATE_PROPERTY);
      }

      public SearchCriteria getEffectiveDateSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(EFFECTIVE_DATE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByEffectiveDate(boolean asc){
          addOrderBy(EFFECTIVE_DATE_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByAccountingSystem(String accountingSystem) {
          
          if (accountingSystem == null) {
              return this;
          }
          
          return filterByAccountingSystem(QueryOperator.EQUAL, accountingSystem);
      }
    

      public AccountSetRequest filterByAccountingSystem(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccountingSystemSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectAccountingSystem(){
          return select(ACCOUNTING_SYSTEM_PROPERTY);
      }

      public AccountSetRequest unselectAccountingSystem(){
          return unselect(ACCOUNTING_SYSTEM_PROPERTY);
      }

      public SearchCriteria getAccountingSystemSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCOUNTING_SYSTEM_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByAccountingSystem(boolean asc){
          addOrderBy(ACCOUNTING_SYSTEM_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByDomesticCurrencyCode(String domesticCurrencyCode) {
          
          if (domesticCurrencyCode == null) {
              return this;
          }
          
          return filterByDomesticCurrencyCode(QueryOperator.EQUAL, domesticCurrencyCode);
      }
    

      public AccountSetRequest filterByDomesticCurrencyCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDomesticCurrencyCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectDomesticCurrencyCode(){
          return select(DOMESTIC_CURRENCY_CODE_PROPERTY);
      }

      public AccountSetRequest unselectDomesticCurrencyCode(){
          return unselect(DOMESTIC_CURRENCY_CODE_PROPERTY);
      }

      public SearchCriteria getDomesticCurrencyCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DOMESTIC_CURRENCY_CODE_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByDomesticCurrencyCode(boolean asc){
          addOrderBy(DOMESTIC_CURRENCY_CODE_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByDomesticCurrencyName(String domesticCurrencyName) {
          
          if (domesticCurrencyName == null) {
              return this;
          }
          
          return filterByDomesticCurrencyName(QueryOperator.EQUAL, domesticCurrencyName);
      }
    

      public AccountSetRequest filterByDomesticCurrencyName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDomesticCurrencyNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectDomesticCurrencyName(){
          return select(DOMESTIC_CURRENCY_NAME_PROPERTY);
      }

      public AccountSetRequest unselectDomesticCurrencyName(){
          return unselect(DOMESTIC_CURRENCY_NAME_PROPERTY);
      }

      public SearchCriteria getDomesticCurrencyNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DOMESTIC_CURRENCY_NAME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByDomesticCurrencyName(boolean asc){
          addOrderBy(DOMESTIC_CURRENCY_NAME_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByOpeningBank(String openingBank) {
          
          if (openingBank == null) {
              return this;
          }
          
          return filterByOpeningBank(QueryOperator.EQUAL, openingBank);
      }
    

      public AccountSetRequest filterByOpeningBank(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getOpeningBankSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectOpeningBank(){
          return select(OPENING_BANK_PROPERTY);
      }

      public AccountSetRequest unselectOpeningBank(){
          return unselect(OPENING_BANK_PROPERTY);
      }

      public SearchCriteria getOpeningBankSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(OPENING_BANK_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByOpeningBank(boolean asc){
          addOrderBy(OPENING_BANK_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByAccountNumber(String accountNumber) {
          
          if (accountNumber == null) {
              return this;
          }
          
          return filterByAccountNumber(QueryOperator.EQUAL, accountNumber);
      }
    

      public AccountSetRequest filterByAccountNumber(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAccountNumberSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectAccountNumber(){
          return select(ACCOUNT_NUMBER_PROPERTY);
      }

      public AccountSetRequest unselectAccountNumber(){
          return unselect(ACCOUNT_NUMBER_PROPERTY);
      }

      public SearchCriteria getAccountNumberSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ACCOUNT_NUMBER_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByAccountNumber(boolean asc){
          addOrderBy(ACCOUNT_NUMBER_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public AccountSetRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public AccountSetRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public AccountSetRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public AccountSetRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public AccountSetRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public AccountSetRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public AccountSetRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public AccountSetRequest filterByCountryCenter(RetailStoreCountryCenterRequest countryCenter){
        return filterByCountryCenter(countryCenter, countryCenterList -> countryCenterList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public AccountSetRequest filterByCountryCenter(RetailStoreCountryCenterRequest countryCenter, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCountryCenterCriteria(countryCenter, idRefine));
    }

    public SearchCriteria createCountryCenterCriteria(RetailStoreCountryCenterRequest countryCenter, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(countryCenter, COUNTRY_CENTER_PROPERTY, idRefine);
    }
    

    
    public AccountSetRequest selectCountryCenter(){
        return selectCountryCenter(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public AccountSetRequest selectCountryCenter(RetailStoreCountryCenterRequest countryCenter){
        selectParent(COUNTRY_CENTER_PROPERTY, countryCenter);
        return this;
    }
    

    public AccountSetRequest unselectCountryCenter(){
        unselectParent(COUNTRY_CENTER_PROPERTY);
        return this;
    }

  

    
    public AccountSetRequest filterByRetailStore(RetailStoreRequest retailStore){
        return filterByRetailStore(retailStore, retailStoreList -> retailStoreList.stream().map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public AccountSetRequest filterByRetailStore(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        return addSearchCriteria(createRetailStoreCriteria(retailStore, idRefine));
    }

    public SearchCriteria createRetailStoreCriteria(RetailStoreRequest retailStore, IDRefine<RetailStore> idRefine) {
        return new RefinedIdInCriteria(retailStore, RETAIL_STORE_PROPERTY, idRefine);
    }
    

    
    public AccountSetRequest selectRetailStore(){
        return selectRetailStore(RetailStoreRequest.newInstance().selectSelf());
    }

    public AccountSetRequest selectRetailStore(RetailStoreRequest retailStore){
        selectParent(RETAIL_STORE_PROPERTY, retailStore);
        return this;
    }
    

    public AccountSetRequest unselectRetailStore(){
        unselectParent(RETAIL_STORE_PROPERTY);
        return this;
    }

  

    
    public AccountSetRequest filterByGoodsSupplier(GoodsSupplierRequest goodsSupplier){
        return filterByGoodsSupplier(goodsSupplier, goodsSupplierList -> goodsSupplierList.stream().map(GoodsSupplier::getId).collect(Collectors.toSet()));
    }

    public AccountSetRequest filterByGoodsSupplier(GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine) {
        return addSearchCriteria(createGoodsSupplierCriteria(goodsSupplier, idRefine));
    }

    public SearchCriteria createGoodsSupplierCriteria(GoodsSupplierRequest goodsSupplier, IDRefine<GoodsSupplier> idRefine) {
        return new RefinedIdInCriteria(goodsSupplier, GOODS_SUPPLIER_PROPERTY, idRefine);
    }
    

    
    public AccountSetRequest selectGoodsSupplier(){
        return selectGoodsSupplier(GoodsSupplierRequest.newInstance().selectSelf());
    }

    public AccountSetRequest selectGoodsSupplier(GoodsSupplierRequest goodsSupplier){
        selectParent(GOODS_SUPPLIER_PROPERTY, goodsSupplier);
        return this;
    }
    

    public AccountSetRequest unselectGoodsSupplier(){
        unselectParent(GOODS_SUPPLIER_PROPERTY);
        return this;
    }

  


  

    public AccountSetRequest hasAccountingSubject() {
      return hasAccountingSubject(AccountingSubjectRequest.newInstance());
    }

    public AccountSetRequest hasAccountingSubject(AccountingSubjectRequest accountingSubject) {
        return hasAccountingSubject(accountingSubject, accountingSubjectList -> accountingSubjectList.stream().map(AccountingSubject::getAccountSet).map(AccountSet::getId).collect(Collectors.toSet()));
    }

    public AccountSetRequest hasAccountingSubject(AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine) {
        accountingSubject.select(AccountingSubject.ACCOUNT_SET_PROPERTY);
        return addSearchCriteria(createAccountingSubjectCriteria(accountingSubject, idRefine));
    }

    public SearchCriteria createAccountingSubjectCriteria(AccountingSubjectRequest accountingSubject, IDRefine<AccountingSubject> idRefine){
       return new RefinedIdInCriteria(accountingSubject, ID_PROPERTY, idRefine);
    }

    public AccountSetRequest selectAccountingSubjectList(AccountingSubjectRequest accountingSubject) {
        selectChild(AccountingSubject.ACCOUNT_SET_PROPERTY, accountingSubject);
        return this;
    }

    public AccountSetRequest selectAccountingSubjectList() {
        return selectAccountingSubjectList(AccountingSubjectRequest.newInstance().selectAll());
    }

    public AccountSetRequest unselectAccountingSubjectList(){
        unselectChild(AccountingSubject.ACCOUNT_SET_PROPERTY, AccountingSubject.class);
        return this;
    }
  

    public AccountSetRequest hasAccountingPeriod() {
      return hasAccountingPeriod(AccountingPeriodRequest.newInstance());
    }

    public AccountSetRequest hasAccountingPeriod(AccountingPeriodRequest accountingPeriod) {
        return hasAccountingPeriod(accountingPeriod, accountingPeriodList -> accountingPeriodList.stream().map(AccountingPeriod::getAccountSet).map(AccountSet::getId).collect(Collectors.toSet()));
    }

    public AccountSetRequest hasAccountingPeriod(AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine) {
        accountingPeriod.select(AccountingPeriod.ACCOUNT_SET_PROPERTY);
        return addSearchCriteria(createAccountingPeriodCriteria(accountingPeriod, idRefine));
    }

    public SearchCriteria createAccountingPeriodCriteria(AccountingPeriodRequest accountingPeriod, IDRefine<AccountingPeriod> idRefine){
       return new RefinedIdInCriteria(accountingPeriod, ID_PROPERTY, idRefine);
    }

    public AccountSetRequest selectAccountingPeriodList(AccountingPeriodRequest accountingPeriod) {
        selectChild(AccountingPeriod.ACCOUNT_SET_PROPERTY, accountingPeriod);
        return this;
    }

    public AccountSetRequest selectAccountingPeriodList() {
        return selectAccountingPeriodList(AccountingPeriodRequest.newInstance().selectAll());
    }

    public AccountSetRequest unselectAccountingPeriodList(){
        unselectChild(AccountingPeriod.ACCOUNT_SET_PROPERTY, AccountingPeriod.class);
        return this;
    }
  

    public AccountSetRequest hasAccountingDocumentType() {
      return hasAccountingDocumentType(AccountingDocumentTypeRequest.newInstance());
    }

    public AccountSetRequest hasAccountingDocumentType(AccountingDocumentTypeRequest accountingDocumentType) {
        return hasAccountingDocumentType(accountingDocumentType, accountingDocumentTypeList -> accountingDocumentTypeList.stream().map(AccountingDocumentType::getAccountingPeriod).map(AccountSet::getId).collect(Collectors.toSet()));
    }

    public AccountSetRequest hasAccountingDocumentType(AccountingDocumentTypeRequest accountingDocumentType, IDRefine<AccountingDocumentType> idRefine) {
        accountingDocumentType.select(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY);
        return addSearchCriteria(createAccountingDocumentTypeCriteria(accountingDocumentType, idRefine));
    }

    public SearchCriteria createAccountingDocumentTypeCriteria(AccountingDocumentTypeRequest accountingDocumentType, IDRefine<AccountingDocumentType> idRefine){
       return new RefinedIdInCriteria(accountingDocumentType, ID_PROPERTY, idRefine);
    }

    public AccountSetRequest selectAccountingDocumentTypeList(AccountingDocumentTypeRequest accountingDocumentType) {
        selectChild(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, accountingDocumentType);
        return this;
    }

    public AccountSetRequest selectAccountingDocumentTypeList() {
        return selectAccountingDocumentTypeList(AccountingDocumentTypeRequest.newInstance().selectAll());
    }

    public AccountSetRequest unselectAccountingDocumentTypeList(){
        unselectChild(AccountingDocumentType.ACCOUNTING_PERIOD_PROPERTY, AccountingDocumentType.class);
        return this;
    }
  

   public AccountSetRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

