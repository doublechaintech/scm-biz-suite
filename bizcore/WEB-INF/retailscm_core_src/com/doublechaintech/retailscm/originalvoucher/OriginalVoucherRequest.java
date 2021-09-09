package com.doublechaintech.retailscm.originalvoucher;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.accountingdocument.AccountingDocument;
import com.doublechaintech.retailscm.accountingdocument.AccountingDocumentRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.originalvoucher.OriginalVoucher.*;

public class OriginalVoucherRequest extends BaseRequest<OriginalVoucher> {
    public static OriginalVoucherRequest newInstance() {
        return new OriginalVoucherRequest().selectId();
    }

    public String getInternalType() {
        return "OriginalVoucher";
    }

    public OriginalVoucherRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public OriginalVoucherRequest select(String... names) {
        super.select(names);
        return this;
    }

    public OriginalVoucherRequest selectAll() {return this.selectId().selectTitle().selectMadeBy().selectReceivedBy().selectVoucherType().selectVoucherImage().selectBelongsTo().selectVersion();
    }

    public OriginalVoucherRequest selectSelf() {return this.selectId().selectTitle().selectMadeBy().selectReceivedBy().selectVoucherType().selectVoucherImage().selectVersion();
    }

    public OriginalVoucherRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public OriginalVoucherRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static OriginalVoucherRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public OriginalVoucherRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public OriginalVoucherRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OriginalVoucherRequest selectId(){
          return select(ID_PROPERTY);
      }

      public OriginalVoucherRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public OriginalVoucherRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public OriginalVoucherRequest filterByTitle(String title) {
          
          if (title == null) {
              return this;
          }
          
          return filterByTitle(QueryOperator.EQUAL, title);
      }
    

      public OriginalVoucherRequest filterByTitle(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTitleSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OriginalVoucherRequest selectTitle(){
          return select(TITLE_PROPERTY);
      }

      public OriginalVoucherRequest unselectTitle(){
          return unselect(TITLE_PROPERTY);
      }

      public SearchCriteria getTitleSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TITLE_PROPERTY, pQueryOperator, parameters);
      }

      public OriginalVoucherRequest orderByTitle(boolean asc){
          addOrderBy(TITLE_PROPERTY, asc);
          return this;
      }
   
      public OriginalVoucherRequest filterByMadeBy(String madeBy) {
          
          if (madeBy == null) {
              return this;
          }
          
          return filterByMadeBy(QueryOperator.EQUAL, madeBy);
      }
    

      public OriginalVoucherRequest filterByMadeBy(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMadeBySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OriginalVoucherRequest selectMadeBy(){
          return select(MADE_BY_PROPERTY);
      }

      public OriginalVoucherRequest unselectMadeBy(){
          return unselect(MADE_BY_PROPERTY);
      }

      public SearchCriteria getMadeBySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MADE_BY_PROPERTY, pQueryOperator, parameters);
      }

      public OriginalVoucherRequest orderByMadeBy(boolean asc){
          addOrderBy(MADE_BY_PROPERTY, asc);
          return this;
      }
   
      public OriginalVoucherRequest filterByReceivedBy(String receivedBy) {
          
          if (receivedBy == null) {
              return this;
          }
          
          return filterByReceivedBy(QueryOperator.EQUAL, receivedBy);
      }
    

      public OriginalVoucherRequest filterByReceivedBy(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getReceivedBySearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OriginalVoucherRequest selectReceivedBy(){
          return select(RECEIVED_BY_PROPERTY);
      }

      public OriginalVoucherRequest unselectReceivedBy(){
          return unselect(RECEIVED_BY_PROPERTY);
      }

      public SearchCriteria getReceivedBySearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(RECEIVED_BY_PROPERTY, pQueryOperator, parameters);
      }

      public OriginalVoucherRequest orderByReceivedBy(boolean asc){
          addOrderBy(RECEIVED_BY_PROPERTY, asc);
          return this;
      }
   
      public OriginalVoucherRequest filterByVoucherType(String voucherType) {
          
          if (voucherType == null) {
              return this;
          }
          
          return filterByVoucherType(QueryOperator.EQUAL, voucherType);
      }
    

      public OriginalVoucherRequest filterByVoucherType(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVoucherTypeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OriginalVoucherRequest selectVoucherType(){
          return select(VOUCHER_TYPE_PROPERTY);
      }

      public OriginalVoucherRequest unselectVoucherType(){
          return unselect(VOUCHER_TYPE_PROPERTY);
      }

      public SearchCriteria getVoucherTypeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VOUCHER_TYPE_PROPERTY, pQueryOperator, parameters);
      }

      public OriginalVoucherRequest orderByVoucherType(boolean asc){
          addOrderBy(VOUCHER_TYPE_PROPERTY, asc);
          return this;
      }
   
      public OriginalVoucherRequest filterByVoucherImage(String voucherImage) {
          
          if (voucherImage == null) {
              return this;
          }
          
          return filterByVoucherImage(QueryOperator.EQUAL, voucherImage);
      }
    

      public OriginalVoucherRequest filterByVoucherImage(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVoucherImageSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OriginalVoucherRequest selectVoucherImage(){
          return select(VOUCHER_IMAGE_PROPERTY);
      }

      public OriginalVoucherRequest unselectVoucherImage(){
          return unselect(VOUCHER_IMAGE_PROPERTY);
      }

      public SearchCriteria getVoucherImageSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VOUCHER_IMAGE_PROPERTY, pQueryOperator, parameters);
      }

      public OriginalVoucherRequest orderByVoucherImage(boolean asc){
          addOrderBy(VOUCHER_IMAGE_PROPERTY, asc);
          return this;
      }
   
      public OriginalVoucherRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public OriginalVoucherRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public OriginalVoucherRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public OriginalVoucherRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public OriginalVoucherRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public OriginalVoucherRequest filterByBelongsTo(AccountingDocumentRequest belongsTo){
        return filterByBelongsTo(belongsTo, belongsToList -> belongsToList.stream().map(AccountingDocument::getId).collect(Collectors.toSet()));
    }

    public OriginalVoucherRequest filterByBelongsTo(AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
        return addSearchCriteria(createBelongsToCriteria(belongsTo, idRefine));
    }

    public SearchCriteria createBelongsToCriteria(AccountingDocumentRequest belongsTo, IDRefine<AccountingDocument> idRefine) {
        return new RefinedIdInCriteria(belongsTo, BELONGS_TO_PROPERTY, idRefine);
    }
    

    
    public OriginalVoucherRequest selectBelongsTo(){
        return selectBelongsTo(AccountingDocumentRequest.newInstance().selectSelf());
    }

    public OriginalVoucherRequest selectBelongsTo(AccountingDocumentRequest belongsTo){
        selectParent(BELONGS_TO_PROPERTY, belongsTo);
        return this;
    }
    

    public OriginalVoucherRequest unselectBelongsTo(){
        unselectParent(BELONGS_TO_PROPERTY);
        return this;
    }

  


  

   public OriginalVoucherRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

