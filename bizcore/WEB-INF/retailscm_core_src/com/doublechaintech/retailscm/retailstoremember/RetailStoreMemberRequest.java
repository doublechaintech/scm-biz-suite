package com.doublechaintech.retailscm.retailstoremember;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrderRequest;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPointRequest;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemptionRequest;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlistRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddressRequest;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCouponRequest;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCardRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.retailstoremember.RetailStoreMember.*;

public class RetailStoreMemberRequest extends BaseRequest<RetailStoreMember> {
    public static RetailStoreMemberRequest newInstance() {
        return new RetailStoreMemberRequest().selectId();
    }

    public String getInternalType() {
        return "RetailStoreMember";
    }

    public RetailStoreMemberRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public RetailStoreMemberRequest select(String... names) {
        super.select(names);
        return this;
    }

    public RetailStoreMemberRequest selectAll() {return this.selectId().selectName().selectMobilePhone().selectOwner().selectVersion();
    }

    public RetailStoreMemberRequest selectSelf() {return this.selectId().selectName().selectMobilePhone().selectVersion();
    }

    public RetailStoreMemberRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public RetailStoreMemberRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static RetailStoreMemberRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public RetailStoreMemberRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public RetailStoreMemberRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberRequest selectId(){
          return select(ID_PROPERTY);
      }

      public RetailStoreMemberRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberRequest filterByName(String name) {
          
          if (name == null) {
              return this;
          }
          
          return filterByName(QueryOperator.EQUAL, name);
      }
    

      public RetailStoreMemberRequest filterByName(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getNameSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberRequest selectName(){
          return select(NAME_PROPERTY);
      }

      public RetailStoreMemberRequest unselectName(){
          return unselect(NAME_PROPERTY);
      }

      public SearchCriteria getNameSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(NAME_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberRequest orderByName(boolean asc){
          addOrderBy(NAME_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberRequest filterByMobilePhone(String mobilePhone) {
          
          if (mobilePhone == null) {
              return this;
          }
          
          return filterByMobilePhone(QueryOperator.EQUAL, mobilePhone);
      }
    

      public RetailStoreMemberRequest filterByMobilePhone(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getMobilePhoneSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberRequest selectMobilePhone(){
          return select(MOBILE_PHONE_PROPERTY);
      }

      public RetailStoreMemberRequest unselectMobilePhone(){
          return unselect(MOBILE_PHONE_PROPERTY);
      }

      public SearchCriteria getMobilePhoneSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(MOBILE_PHONE_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberRequest orderByMobilePhone(boolean asc){
          addOrderBy(MOBILE_PHONE_PROPERTY, asc);
          return this;
      }
   
      public RetailStoreMemberRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public RetailStoreMemberRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public RetailStoreMemberRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public RetailStoreMemberRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public RetailStoreMemberRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public RetailStoreMemberRequest filterByOwner(RetailStoreCountryCenterRequest owner){
        return filterByOwner(owner, ownerList -> ownerList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest filterByOwner(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createOwnerCriteria(owner, idRefine));
    }

    public SearchCriteria createOwnerCriteria(RetailStoreCountryCenterRequest owner, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(owner, OWNER_PROPERTY, idRefine);
    }
    

    
    public RetailStoreMemberRequest selectOwner(){
        return selectOwner(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public RetailStoreMemberRequest selectOwner(RetailStoreCountryCenterRequest owner){
        selectParent(OWNER_PROPERTY, owner);
        return this;
    }
    

    public RetailStoreMemberRequest unselectOwner(){
        unselectParent(OWNER_PROPERTY);
        return this;
    }

  


  

    public RetailStoreMemberRequest hasConsumerOrder() {
      return hasConsumerOrder(ConsumerOrderRequest.newInstance());
    }

    public RetailStoreMemberRequest hasConsumerOrder(ConsumerOrderRequest consumerOrder) {
        return hasConsumerOrder(consumerOrder, consumerOrderList -> consumerOrderList.stream().map(ConsumerOrder::getConsumer).map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest hasConsumerOrder(ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine) {
        consumerOrder.select(ConsumerOrder.CONSUMER_PROPERTY);
        return addSearchCriteria(createConsumerOrderCriteria(consumerOrder, idRefine));
    }

    public SearchCriteria createConsumerOrderCriteria(ConsumerOrderRequest consumerOrder, IDRefine<ConsumerOrder> idRefine){
       return new RefinedIdInCriteria(consumerOrder, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberRequest selectConsumerOrderList(ConsumerOrderRequest consumerOrder) {
        selectChild(ConsumerOrder.CONSUMER_PROPERTY, consumerOrder);
        return this;
    }

    public RetailStoreMemberRequest selectConsumerOrderList() {
        return selectConsumerOrderList(ConsumerOrderRequest.newInstance().selectAll());
    }

    public RetailStoreMemberRequest unselectConsumerOrderList(){
        unselectChild(ConsumerOrder.CONSUMER_PROPERTY, ConsumerOrder.class);
        return this;
    }
  

    public RetailStoreMemberRequest hasRetailStoreMemberCoupon() {
      return hasRetailStoreMemberCoupon(RetailStoreMemberCouponRequest.newInstance());
    }

    public RetailStoreMemberRequest hasRetailStoreMemberCoupon(RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
        return hasRetailStoreMemberCoupon(retailStoreMemberCoupon, retailStoreMemberCouponList -> retailStoreMemberCouponList.stream().map(RetailStoreMemberCoupon::getOwner).map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest hasRetailStoreMemberCoupon(RetailStoreMemberCouponRequest retailStoreMemberCoupon, IDRefine<RetailStoreMemberCoupon> idRefine) {
        retailStoreMemberCoupon.select(RetailStoreMemberCoupon.OWNER_PROPERTY);
        return addSearchCriteria(createRetailStoreMemberCouponCriteria(retailStoreMemberCoupon, idRefine));
    }

    public SearchCriteria createRetailStoreMemberCouponCriteria(RetailStoreMemberCouponRequest retailStoreMemberCoupon, IDRefine<RetailStoreMemberCoupon> idRefine){
       return new RefinedIdInCriteria(retailStoreMemberCoupon, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberRequest selectRetailStoreMemberCouponList(RetailStoreMemberCouponRequest retailStoreMemberCoupon) {
        selectChild(RetailStoreMemberCoupon.OWNER_PROPERTY, retailStoreMemberCoupon);
        return this;
    }

    public RetailStoreMemberRequest selectRetailStoreMemberCouponList() {
        return selectRetailStoreMemberCouponList(RetailStoreMemberCouponRequest.newInstance().selectAll());
    }

    public RetailStoreMemberRequest unselectRetailStoreMemberCouponList(){
        unselectChild(RetailStoreMemberCoupon.OWNER_PROPERTY, RetailStoreMemberCoupon.class);
        return this;
    }
  

    public RetailStoreMemberRequest hasMemberWishlist() {
      return hasMemberWishlist(MemberWishlistRequest.newInstance());
    }

    public RetailStoreMemberRequest hasMemberWishlist(MemberWishlistRequest memberWishlist) {
        return hasMemberWishlist(memberWishlist, memberWishlistList -> memberWishlistList.stream().map(MemberWishlist::getOwner).map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest hasMemberWishlist(MemberWishlistRequest memberWishlist, IDRefine<MemberWishlist> idRefine) {
        memberWishlist.select(MemberWishlist.OWNER_PROPERTY);
        return addSearchCriteria(createMemberWishlistCriteria(memberWishlist, idRefine));
    }

    public SearchCriteria createMemberWishlistCriteria(MemberWishlistRequest memberWishlist, IDRefine<MemberWishlist> idRefine){
       return new RefinedIdInCriteria(memberWishlist, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberRequest selectMemberWishlistList(MemberWishlistRequest memberWishlist) {
        selectChild(MemberWishlist.OWNER_PROPERTY, memberWishlist);
        return this;
    }

    public RetailStoreMemberRequest selectMemberWishlistList() {
        return selectMemberWishlistList(MemberWishlistRequest.newInstance().selectAll());
    }

    public RetailStoreMemberRequest unselectMemberWishlistList(){
        unselectChild(MemberWishlist.OWNER_PROPERTY, MemberWishlist.class);
        return this;
    }
  

    public RetailStoreMemberRequest hasMemberRewardPoint() {
      return hasMemberRewardPoint(MemberRewardPointRequest.newInstance());
    }

    public RetailStoreMemberRequest hasMemberRewardPoint(MemberRewardPointRequest memberRewardPoint) {
        return hasMemberRewardPoint(memberRewardPoint, memberRewardPointList -> memberRewardPointList.stream().map(MemberRewardPoint::getOwner).map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest hasMemberRewardPoint(MemberRewardPointRequest memberRewardPoint, IDRefine<MemberRewardPoint> idRefine) {
        memberRewardPoint.select(MemberRewardPoint.OWNER_PROPERTY);
        return addSearchCriteria(createMemberRewardPointCriteria(memberRewardPoint, idRefine));
    }

    public SearchCriteria createMemberRewardPointCriteria(MemberRewardPointRequest memberRewardPoint, IDRefine<MemberRewardPoint> idRefine){
       return new RefinedIdInCriteria(memberRewardPoint, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberRequest selectMemberRewardPointList(MemberRewardPointRequest memberRewardPoint) {
        selectChild(MemberRewardPoint.OWNER_PROPERTY, memberRewardPoint);
        return this;
    }

    public RetailStoreMemberRequest selectMemberRewardPointList() {
        return selectMemberRewardPointList(MemberRewardPointRequest.newInstance().selectAll());
    }

    public RetailStoreMemberRequest unselectMemberRewardPointList(){
        unselectChild(MemberRewardPoint.OWNER_PROPERTY, MemberRewardPoint.class);
        return this;
    }
  

    public RetailStoreMemberRequest hasMemberRewardPointRedemption() {
      return hasMemberRewardPointRedemption(MemberRewardPointRedemptionRequest.newInstance());
    }

    public RetailStoreMemberRequest hasMemberRewardPointRedemption(MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
        return hasMemberRewardPointRedemption(memberRewardPointRedemption, memberRewardPointRedemptionList -> memberRewardPointRedemptionList.stream().map(MemberRewardPointRedemption::getOwner).map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest hasMemberRewardPointRedemption(MemberRewardPointRedemptionRequest memberRewardPointRedemption, IDRefine<MemberRewardPointRedemption> idRefine) {
        memberRewardPointRedemption.select(MemberRewardPointRedemption.OWNER_PROPERTY);
        return addSearchCriteria(createMemberRewardPointRedemptionCriteria(memberRewardPointRedemption, idRefine));
    }

    public SearchCriteria createMemberRewardPointRedemptionCriteria(MemberRewardPointRedemptionRequest memberRewardPointRedemption, IDRefine<MemberRewardPointRedemption> idRefine){
       return new RefinedIdInCriteria(memberRewardPointRedemption, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberRequest selectMemberRewardPointRedemptionList(MemberRewardPointRedemptionRequest memberRewardPointRedemption) {
        selectChild(MemberRewardPointRedemption.OWNER_PROPERTY, memberRewardPointRedemption);
        return this;
    }

    public RetailStoreMemberRequest selectMemberRewardPointRedemptionList() {
        return selectMemberRewardPointRedemptionList(MemberRewardPointRedemptionRequest.newInstance().selectAll());
    }

    public RetailStoreMemberRequest unselectMemberRewardPointRedemptionList(){
        unselectChild(MemberRewardPointRedemption.OWNER_PROPERTY, MemberRewardPointRedemption.class);
        return this;
    }
  

    public RetailStoreMemberRequest hasRetailStoreMemberAddress() {
      return hasRetailStoreMemberAddress(RetailStoreMemberAddressRequest.newInstance());
    }

    public RetailStoreMemberRequest hasRetailStoreMemberAddress(RetailStoreMemberAddressRequest retailStoreMemberAddress) {
        return hasRetailStoreMemberAddress(retailStoreMemberAddress, retailStoreMemberAddressList -> retailStoreMemberAddressList.stream().map(RetailStoreMemberAddress::getOwner).map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest hasRetailStoreMemberAddress(RetailStoreMemberAddressRequest retailStoreMemberAddress, IDRefine<RetailStoreMemberAddress> idRefine) {
        retailStoreMemberAddress.select(RetailStoreMemberAddress.OWNER_PROPERTY);
        return addSearchCriteria(createRetailStoreMemberAddressCriteria(retailStoreMemberAddress, idRefine));
    }

    public SearchCriteria createRetailStoreMemberAddressCriteria(RetailStoreMemberAddressRequest retailStoreMemberAddress, IDRefine<RetailStoreMemberAddress> idRefine){
       return new RefinedIdInCriteria(retailStoreMemberAddress, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberRequest selectRetailStoreMemberAddressList(RetailStoreMemberAddressRequest retailStoreMemberAddress) {
        selectChild(RetailStoreMemberAddress.OWNER_PROPERTY, retailStoreMemberAddress);
        return this;
    }

    public RetailStoreMemberRequest selectRetailStoreMemberAddressList() {
        return selectRetailStoreMemberAddressList(RetailStoreMemberAddressRequest.newInstance().selectAll());
    }

    public RetailStoreMemberRequest unselectRetailStoreMemberAddressList(){
        unselectChild(RetailStoreMemberAddress.OWNER_PROPERTY, RetailStoreMemberAddress.class);
        return this;
    }
  

    public RetailStoreMemberRequest hasRetailStoreMemberGiftCard() {
      return hasRetailStoreMemberGiftCard(RetailStoreMemberGiftCardRequest.newInstance());
    }

    public RetailStoreMemberRequest hasRetailStoreMemberGiftCard(RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
        return hasRetailStoreMemberGiftCard(retailStoreMemberGiftCard, retailStoreMemberGiftCardList -> retailStoreMemberGiftCardList.stream().map(RetailStoreMemberGiftCard::getOwner).map(RetailStoreMember::getId).collect(Collectors.toSet()));
    }

    public RetailStoreMemberRequest hasRetailStoreMemberGiftCard(RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard, IDRefine<RetailStoreMemberGiftCard> idRefine) {
        retailStoreMemberGiftCard.select(RetailStoreMemberGiftCard.OWNER_PROPERTY);
        return addSearchCriteria(createRetailStoreMemberGiftCardCriteria(retailStoreMemberGiftCard, idRefine));
    }

    public SearchCriteria createRetailStoreMemberGiftCardCriteria(RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard, IDRefine<RetailStoreMemberGiftCard> idRefine){
       return new RefinedIdInCriteria(retailStoreMemberGiftCard, ID_PROPERTY, idRefine);
    }

    public RetailStoreMemberRequest selectRetailStoreMemberGiftCardList(RetailStoreMemberGiftCardRequest retailStoreMemberGiftCard) {
        selectChild(RetailStoreMemberGiftCard.OWNER_PROPERTY, retailStoreMemberGiftCard);
        return this;
    }

    public RetailStoreMemberRequest selectRetailStoreMemberGiftCardList() {
        return selectRetailStoreMemberGiftCardList(RetailStoreMemberGiftCardRequest.newInstance().selectAll());
    }

    public RetailStoreMemberRequest unselectRetailStoreMemberGiftCardList(){
        unselectChild(RetailStoreMemberGiftCard.OWNER_PROPERTY, RetailStoreMemberGiftCard.class);
        return this;
    }
  

   public RetailStoreMemberRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

