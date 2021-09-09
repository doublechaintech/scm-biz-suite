package com.doublechaintech.retailscm.retailstore;

import com.doublechaintech.retailscm.search.*;
import com.terapico.caf.DateTime;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.accountset.AccountSet;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosing;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreation;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecoration;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchising;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitation;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpening;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.accountset.AccountSetRequest;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import com.doublechaintech.retailscm.goods.GoodsRequest;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenterRequest;
import com.doublechaintech.retailscm.retailstoreclosing.RetailStoreClosingRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.retailstorecreation.RetailStoreCreationRequest;
import com.doublechaintech.retailscm.retailstoredecoration.RetailStoreDecorationRequest;
import com.doublechaintech.retailscm.retailstorefranchising.RetailStoreFranchisingRequest;
import com.doublechaintech.retailscm.retailstoreinvestmentinvitation.RetailStoreInvestmentInvitationRequest;
import com.doublechaintech.retailscm.retailstoreopening.RetailStoreOpeningRequest;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrderRequest;
import com.doublechaintech.retailscm.transporttask.TransportTaskRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstore.RetailStore.*;

public class RetailStoreRequest extends BaseRequest<RetailStore> {
    public static RetailStoreRequest newInstance() {
        return new RetailStoreRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStore";
    }

    public RetailStoreRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreRequest selectAll() {return this.selectId().selectName().selectTelephone().selectOwner().selectRetailStoreCountryCenter().selectCityServiceCenter().selectCreation().selectInvestmentInvitation().selectFranchising().selectDecoration().selectOpening().selectClosing().selectFounded().selectLatitude().selectLongitude().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreRequest selectSelf() {return this.selectId().selectName().selectTelephone().selectOwner().selectFounded().selectLatitude().selectLongitude().selectDescription().selectLastUpdateTime().selectVersion();
    }

    public RetailStoreRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByTelephone(String telephone) {
          
          if (telephone == null) {
              return this;
          }
          
          return filterByTelephone(QueryOperator.EQUAL, telephone);
      }
    

      public RetailStoreRequest filterByTelephone(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getTelephoneSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectTelephone(){
          return select(TELEPHONE_PROPERTY);
      }

      public RetailStoreRequest unselectTelephone(){
          return unselect(TELEPHONE_PROPERTY);
      }

      public SearchCriteria getTelephoneSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(TELEPHONE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByTelephone(boolean asc){
          addOrderBy(TELEPHONE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByOwner(String owner) {
          
          if (owner == null) {
              return this;
          }
          
          return filterByOwner(QueryOperator.EQUAL, owner);
      }
    

      public RetailStoreRequest filterByOwner(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getOwnerSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectOwner(){
          return select(OWNER_PROPERTY);
      }

      public RetailStoreRequest unselectOwner(){
          return unselect(OWNER_PROPERTY);
      }

      public SearchCriteria getOwnerSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(OWNER_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByOwner(boolean asc){
          addOrderBy(OWNER_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByFounded(Date founded) {
          
          if (founded == null) {
              return this;
          }
          
          return filterByFounded(QueryOperator.EQUAL, founded);
      }
    

      public RetailStoreRequest filterByFounded(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getFoundedSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectFounded(){
          return select(FOUNDED_PROPERTY);
      }

      public RetailStoreRequest unselectFounded(){
          return unselect(FOUNDED_PROPERTY);
      }

      public SearchCriteria getFoundedSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(FOUNDED_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByFounded(boolean asc){
          addOrderBy(FOUNDED_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByLatitude(BigDecimal latitude) {
          
          if (latitude == null) {
              return this;
          }
          
          return filterByLatitude(QueryOperator.EQUAL, latitude);
      }
    

      public RetailStoreRequest filterByLatitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLatitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectLatitude(){
          return select(LATITUDE_PROPERTY);
      }

      public RetailStoreRequest unselectLatitude(){
          return unselect(LATITUDE_PROPERTY);
      }

      public SearchCriteria getLatitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LATITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByLatitude(boolean asc){
          addOrderBy(LATITUDE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByLongitude(BigDecimal longitude) {
          
          if (longitude == null) {
              return this;
          }
          
          return filterByLongitude(QueryOperator.EQUAL, longitude);
      }
    

      public RetailStoreRequest filterByLongitude(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLongitudeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectLongitude(){
          return select(LONGITUDE_PROPERTY);
      }

      public RetailStoreRequest unselectLongitude(){
          return unselect(LONGITUDE_PROPERTY);
      }

      public SearchCriteria getLongitudeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LONGITUDE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByLongitude(boolean asc){
          addOrderBy(LONGITUDE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public RetailStoreRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public RetailStoreRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByLastUpdateTime(DateTime lastUpdateTime) {
          
          if (lastUpdateTime == null) {
              return this;
          }
          
          return filterByLastUpdateTime(QueryOperator.EQUAL, lastUpdateTime);
      }
    

      public RetailStoreRequest filterByLastUpdateTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLastUpdateTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectLastUpdateTime(){
          return select(LAST_UPDATE_TIME_PROPERTY);
      }

      public RetailStoreRequest unselectLastUpdateTime(){
          return unselect(LAST_UPDATE_TIME_PROPERTY);
      }

      public SearchCriteria getLastUpdateTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LAST_UPDATE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByLastUpdateTime(boolean asc){
          addOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreRequest filterByRetailStoreCountryCenter(RetailStoreCountryCenterRequest retailStoreCountryCenter){
        return filterByRetailStoreCountryCenter(retailStoreCountryCenter, retailStoreCountryCenterList -> retailStoreCountryCenterList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByRetailStoreCountryCenter(RetailStoreCountryCenterRequest retailStoreCountryCenter, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createRetailStoreCountryCenterCriteria(retailStoreCountryCenter, idRefine));
    }

    public SearchCriteria createRetailStoreCountryCenterCriteria(RetailStoreCountryCenterRequest retailStoreCountryCenter, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(retailStoreCountryCenter, RETAIL_STORE_COUNTRY_CENTER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectRetailStoreCountryCenter(){
        return selectRetailStoreCountryCenter(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectRetailStoreCountryCenter(RetailStoreCountryCenterRequest retailStoreCountryCenter){
        selectParent(RETAIL_STORE_COUNTRY_CENTER_PROPERTY, retailStoreCountryCenter);
        return this;
    }
    

    public RetailStoreRequest unselectRetailStoreCountryCenter(){
        unselectParent(RETAIL_STORE_COUNTRY_CENTER_PROPERTY);
        return this;
    }

  

    
    public RetailStoreRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        return filterByCityServiceCenter(cityServiceCenter, cityServiceCenterList -> cityServiceCenterList.stream().map(RetailStoreCityServiceCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return addSearchCriteria(createCityServiceCenterCriteria(cityServiceCenter, idRefine));
    }

    public SearchCriteria createCityServiceCenterCriteria(RetailStoreCityServiceCenterRequest cityServiceCenter, IDRefine<RetailStoreCityServiceCenter> idRefine) {
        return new RefinedIdInCriteria(cityServiceCenter, CITY_SERVICE_CENTER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectCityServiceCenter(){
        return selectCityServiceCenter(RetailStoreCityServiceCenterRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectCityServiceCenter(RetailStoreCityServiceCenterRequest cityServiceCenter){
        selectParent(CITY_SERVICE_CENTER_PROPERTY, cityServiceCenter);
        return this;
    }
    

    public RetailStoreRequest unselectCityServiceCenter(){
        unselectParent(CITY_SERVICE_CENTER_PROPERTY);
        return this;
    }

  

    
    public RetailStoreRequest filterByCreation(RetailStoreCreationRequest creation){
        return filterByCreation(creation, creationList -> creationList.stream().map(RetailStoreCreation::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByCreation(RetailStoreCreationRequest creation, IDRefine<RetailStoreCreation> idRefine) {
        return addSearchCriteria(createCreationCriteria(creation, idRefine));
    }

    public SearchCriteria createCreationCriteria(RetailStoreCreationRequest creation, IDRefine<RetailStoreCreation> idRefine) {
        return new RefinedIdInCriteria(creation, CREATION_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectCreation(){
        return selectCreation(RetailStoreCreationRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectCreation(RetailStoreCreationRequest creation){
        selectParent(CREATION_PROPERTY, creation);
        return this;
    }
    

    public RetailStoreRequest unselectCreation(){
        unselectParent(CREATION_PROPERTY);
        return this;
    }

  

    
    public RetailStoreRequest filterByInvestmentInvitation(RetailStoreInvestmentInvitationRequest investmentInvitation){
        return filterByInvestmentInvitation(investmentInvitation, investmentInvitationList -> investmentInvitationList.stream().map(RetailStoreInvestmentInvitation::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByInvestmentInvitation(RetailStoreInvestmentInvitationRequest investmentInvitation, IDRefine<RetailStoreInvestmentInvitation> idRefine) {
        return addSearchCriteria(createInvestmentInvitationCriteria(investmentInvitation, idRefine));
    }

    public SearchCriteria createInvestmentInvitationCriteria(RetailStoreInvestmentInvitationRequest investmentInvitation, IDRefine<RetailStoreInvestmentInvitation> idRefine) {
        return new RefinedIdInCriteria(investmentInvitation, INVESTMENT_INVITATION_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectInvestmentInvitation(){
        return selectInvestmentInvitation(RetailStoreInvestmentInvitationRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectInvestmentInvitation(RetailStoreInvestmentInvitationRequest investmentInvitation){
        selectParent(INVESTMENT_INVITATION_PROPERTY, investmentInvitation);
        return this;
    }
    

    public RetailStoreRequest unselectInvestmentInvitation(){
        unselectParent(INVESTMENT_INVITATION_PROPERTY);
        return this;
    }

  

    
    public RetailStoreRequest filterByFranchising(RetailStoreFranchisingRequest franchising){
        return filterByFranchising(franchising, franchisingList -> franchisingList.stream().map(RetailStoreFranchising::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByFranchising(RetailStoreFranchisingRequest franchising, IDRefine<RetailStoreFranchising> idRefine) {
        return addSearchCriteria(createFranchisingCriteria(franchising, idRefine));
    }

    public SearchCriteria createFranchisingCriteria(RetailStoreFranchisingRequest franchising, IDRefine<RetailStoreFranchising> idRefine) {
        return new RefinedIdInCriteria(franchising, FRANCHISING_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectFranchising(){
        return selectFranchising(RetailStoreFranchisingRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectFranchising(RetailStoreFranchisingRequest franchising){
        selectParent(FRANCHISING_PROPERTY, franchising);
        return this;
    }
    

    public RetailStoreRequest unselectFranchising(){
        unselectParent(FRANCHISING_PROPERTY);
        return this;
    }

  

    
    public RetailStoreRequest filterByDecoration(RetailStoreDecorationRequest decoration){
        return filterByDecoration(decoration, decorationList -> decorationList.stream().map(RetailStoreDecoration::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByDecoration(RetailStoreDecorationRequest decoration, IDRefine<RetailStoreDecoration> idRefine) {
        return addSearchCriteria(createDecorationCriteria(decoration, idRefine));
    }

    public SearchCriteria createDecorationCriteria(RetailStoreDecorationRequest decoration, IDRefine<RetailStoreDecoration> idRefine) {
        return new RefinedIdInCriteria(decoration, DECORATION_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectDecoration(){
        return selectDecoration(RetailStoreDecorationRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectDecoration(RetailStoreDecorationRequest decoration){
        selectParent(DECORATION_PROPERTY, decoration);
        return this;
    }
    

    public RetailStoreRequest unselectDecoration(){
        unselectParent(DECORATION_PROPERTY);
        return this;
    }

  

    
    public RetailStoreRequest filterByOpening(RetailStoreOpeningRequest opening){
        return filterByOpening(opening, openingList -> openingList.stream().map(RetailStoreOpening::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByOpening(RetailStoreOpeningRequest opening, IDRefine<RetailStoreOpening> idRefine) {
        return addSearchCriteria(createOpeningCriteria(opening, idRefine));
    }

    public SearchCriteria createOpeningCriteria(RetailStoreOpeningRequest opening, IDRefine<RetailStoreOpening> idRefine) {
        return new RefinedIdInCriteria(opening, OPENING_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectOpening(){
        return selectOpening(RetailStoreOpeningRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectOpening(RetailStoreOpeningRequest opening){
        selectParent(OPENING_PROPERTY, opening);
        return this;
    }
    

    public RetailStoreRequest unselectOpening(){
        unselectParent(OPENING_PROPERTY);
        return this;
    }

  

    
    public RetailStoreRequest filterByClosing(RetailStoreClosingRequest closing){
        return filterByClosing(closing, closingList -> closingList.stream().map(RetailStoreClosing::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest filterByClosing(RetailStoreClosingRequest closing, IDRefine<RetailStoreClosing> idRefine) {
        return addSearchCriteria(createClosingCriteria(closing, idRefine));
    }

    public SearchCriteria createClosingCriteria(RetailStoreClosingRequest closing, IDRefine<RetailStoreClosing> idRefine) {
        return new RefinedIdInCriteria(closing, CLOSING_PROPERTY, idRefine);
    }
    

    
    public RetailStoreRequest selectClosing(){
        return selectClosing(RetailStoreClosingRequest.newInstance().selectSelf());
    }

    public RetailStoreRequest selectClosing(RetailStoreClosingRequest closing){
        selectParent(CLOSING_PROPERTY, closing);
        return this;
    }
    

    public RetailStoreRequest unselectClosing(){
        unselectParent(CLOSING_PROPERTY);
        return this;
    }

  


  

    public RetailStoreRequest hasConsumerOrder() {
      return hasConsumerOrder(ConsumerOrderRequest.newInstance());
    }

    public RetailStoreRequest hasConsumerOrder(ConsumerOrderRequest consumerOrder) {
        return hasConsumerOrder(consumerOrder, consumerOrderList -> consumerOrderList.stream().map(ConsumerOrder::getStore).map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest hasConsumerOrder(ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine) {
        consumerOrder.select(ConsumerOrder.STORE_PROPERTY);
        return addSearchCriteria(createConsumerOrderCriteria(consumerOrder, idRefine));
    }

    public SearchCriteria createConsumerOrderCriteria(ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine){
       return new RefinedIdInCriteria(consumerOrder, ID_PROPERTY, idRefine);
    }

    public RetailStoreRequest selectConsumerOrderList(ConsumerOrderRequest consumerOrder) {
        selectChild(ConsumerOrder.STORE_PROPERTY, consumerOrder);
        return this;
    }

    public RetailStoreRequest selectConsumerOrderList() {
        return selectConsumerOrderList(ConsumerOrderRequest.newInstance().selectAll());
    }

    public RetailStoreRequest unselectConsumerOrderList(){
        unselectChild(ConsumerOrder.STORE_PROPERTY, ConsumerOrder.class);
        return this;
    }
  

    public RetailStoreRequest hasRetailStoreOrder() {
      return hasRetailStoreOrder(RetailStoreOrderRequest.newInstance());
    }

    public RetailStoreRequest hasRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder) {
        return hasRetailStoreOrder(retailStoreOrder, retailStoreOrderList -> retailStoreOrderList.stream().map(RetailStoreOrder::getBuyer).map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest hasRetailStoreOrder(RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine) {
        retailStoreOrder.select(RetailStoreOrder.BUYER_PROPERTY);
        return addSearchCriteria(createRetailStoreOrderCriteria(retailStoreOrder, idRefine));
    }

    public SearchCriteria createRetailStoreOrderCriteria(RetailStoreOrderRequest retailStoreOrder, IDRefine<RetailStoreOrder> idRefine){
       return new RefinedIdInCriteria(retailStoreOrder, ID_PROPERTY, idRefine);
    }

    public RetailStoreRequest selectRetailStoreOrderList(RetailStoreOrderRequest retailStoreOrder) {
        selectChild(RetailStoreOrder.BUYER_PROPERTY, retailStoreOrder);
        return this;
    }

    public RetailStoreRequest selectRetailStoreOrderList() {
        return selectRetailStoreOrderList(RetailStoreOrderRequest.newInstance().selectAll());
    }

    public RetailStoreRequest unselectRetailStoreOrderList(){
        unselectChild(RetailStoreOrder.BUYER_PROPERTY, RetailStoreOrder.class);
        return this;
    }
  

    public RetailStoreRequest hasGoods() {
      return hasGoods(GoodsRequest.newInstance());
    }

    public RetailStoreRequest hasGoods(GoodsRequest goods) {
        return hasGoods(goods, goodsList -> goodsList.stream().map(Goods::getRetailStore).map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest hasGoods(GoodsRequest goods, IDRefine<Goods> idRefine) {
        goods.select(Goods.RETAIL_STORE_PROPERTY);
        return addSearchCriteria(createGoodsCriteria(goods, idRefine));
    }

    public SearchCriteria createGoodsCriteria(GoodsRequest goods, IDRefine<Goods> idRefine){
       return new RefinedIdInCriteria(goods, ID_PROPERTY, idRefine);
    }

    public RetailStoreRequest selectGoodsList(GoodsRequest goods) {
        selectChild(Goods.RETAIL_STORE_PROPERTY, goods);
        return this;
    }

    public RetailStoreRequest selectGoodsList() {
        return selectGoodsList(GoodsRequest.newInstance().selectAll());
    }

    public RetailStoreRequest unselectGoodsList(){
        unselectChild(Goods.RETAIL_STORE_PROPERTY, Goods.class);
        return this;
    }
  

    public RetailStoreRequest hasTransportTask() {
      return hasTransportTask(TransportTaskRequest.newInstance());
    }

    public RetailStoreRequest hasTransportTask(TransportTaskRequest transportTask) {
        return hasTransportTask(transportTask, transportTaskList -> transportTaskList.stream().map(TransportTask::getEnd).map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest hasTransportTask(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine) {
        transportTask.select(TransportTask.END_PROPERTY);
        return addSearchCriteria(createTransportTaskCriteria(transportTask, idRefine));
    }

    public SearchCriteria createTransportTaskCriteria(TransportTaskRequest transportTask, IDRefine<TransportTask> idRefine){
       return new RefinedIdInCriteria(transportTask, ID_PROPERTY, idRefine);
    }

    public RetailStoreRequest selectTransportTaskList(TransportTaskRequest transportTask) {
        selectChild(TransportTask.END_PROPERTY, transportTask);
        return this;
    }

    public RetailStoreRequest selectTransportTaskList() {
        return selectTransportTaskList(TransportTaskRequest.newInstance().selectAll());
    }

    public RetailStoreRequest unselectTransportTaskList(){
        unselectChild(TransportTask.END_PROPERTY, TransportTask.class);
        return this;
    }
  

    public RetailStoreRequest hasAccountSet() {
      return hasAccountSet(AccountSetRequest.newInstance());
    }

    public RetailStoreRequest hasAccountSet(AccountSetRequest accountSet) {
        return hasAccountSet(accountSet, accountSetList -> accountSetList.stream().map(AccountSet::getRetailStore).map(RetailStore::getId).collect(Collectors.toSet()));
    }

    public RetailStoreRequest hasAccountSet(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine) {
        accountSet.select(AccountSet.RETAIL_STORE_PROPERTY);
        return addSearchCriteria(createAccountSetCriteria(accountSet, idRefine));
    }

    public SearchCriteria createAccountSetCriteria(AccountSetRequest accountSet, IDRefine<AccountSet> idRefine){
       return new RefinedIdInCriteria(accountSet, ID_PROPERTY, idRefine);
    }

    public RetailStoreRequest selectAccountSetList(AccountSetRequest accountSet) {
        selectChild(AccountSet.RETAIL_STORE_PROPERTY, accountSet);
        return this;
    }

    public RetailStoreRequest selectAccountSetList() {
        return selectAccountSetList(AccountSetRequest.newInstance().selectAll());
    }

    public RetailStoreRequest unselectAccountSetList(){
        unselectChild(AccountSet.RETAIL_STORE_PROPERTY, AccountSet.class);
        return this;
    }
  

   public RetailStoreRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

