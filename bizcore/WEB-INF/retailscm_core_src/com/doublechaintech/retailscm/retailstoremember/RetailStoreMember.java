
package com.doublechaintech.retailscm.retailstoremember;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.memberrewardpoint.MemberRewardPoint;
import com.doublechaintech.retailscm.memberrewardpointredemption.MemberRewardPointRedemption;
import com.doublechaintech.retailscm.retailstoremembercoupon.RetailStoreMemberCoupon;
import com.doublechaintech.retailscm.memberwishlist.MemberWishlist;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.consumerorder.ConsumerOrder;
import com.doublechaintech.retailscm.retailstorememberaddress.RetailStoreMemberAddress;
import com.doublechaintech.retailscm.retailstoremembergiftcard.RetailStoreMemberGiftCard;

@JsonSerialize(using = RetailStoreMemberSerializer.class)
public class RetailStoreMember extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PHONE_PROPERTY          = "mobilePhone"       ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LIST                      = "consumerOrderList" ;
	public static final String RETAIL_STORE_MEMBER_COUPON_LIST          = "retailStoreMemberCouponList";
	public static final String MEMBER_WISHLIST_LIST                     = "memberWishlistList";
	public static final String MEMBER_REWARD_POINT_LIST                 = "memberRewardPointList";
	public static final String MEMBER_REWARD_POINT_REDEMPTION_LIST      = "memberRewardPointRedemptionList";
	public static final String RETAIL_STORE_MEMBER_ADDRESS_LIST         = "retailStoreMemberAddressList";
	public static final String RETAIL_STORE_MEMBER_GIFT_CARD_LIST       = "retailStoreMemberGiftCardList";

	public static final String INTERNAL_TYPE="RetailStoreMember";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mName               ;
	protected		String              	mMobilePhone        ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrder>	mConsumerOrderList  ;
	protected		SmartList<RetailStoreMemberCoupon>	mRetailStoreMemberCouponList;
	protected		SmartList<MemberWishlist>	mMemberWishlistList ;
	protected		SmartList<MemberRewardPoint>	mMemberRewardPointList;
	protected		SmartList<MemberRewardPointRedemption>	mMemberRewardPointRedemptionList;
	protected		SmartList<RetailStoreMemberAddress>	mRetailStoreMemberAddressList;
	protected		SmartList<RetailStoreMemberGiftCard>	mRetailStoreMemberGiftCardList;

	
		
	public 	RetailStoreMember(){
		// lazy load for all the properties
	}
	public 	static RetailStoreMember withId(String id){
		RetailStoreMember retailStoreMember = new RetailStoreMember();
		retailStoreMember.setId(id);
		retailStoreMember.setVersion(Integer.MAX_VALUE);
		return retailStoreMember;
	}
	public 	static RetailStoreMember refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PHONE_PROPERTY.equals(property)){
			changeMobilePhoneProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeNameProperty(String newValueExpr){
	
		String oldValue = getName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateName(newValue);
		this.onChangeProperty(NAME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeMobilePhoneProperty(String newValueExpr){
	
		String oldValue = getMobilePhone();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMobilePhone(newValue);
		this.onChangeProperty(MOBILE_PHONE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(MOBILE_PHONE_PROPERTY.equals(property)){
			return getMobilePhone();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(CONSUMER_ORDER_LIST.equals(property)){
			List<BaseEntity> list = getConsumerOrderList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_MEMBER_COUPON_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreMemberCouponList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(MEMBER_WISHLIST_LIST.equals(property)){
			List<BaseEntity> list = getMemberWishlistList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(MEMBER_REWARD_POINT_LIST.equals(property)){
			List<BaseEntity> list = getMemberRewardPointList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(MEMBER_REWARD_POINT_REDEMPTION_LIST.equals(property)){
			List<BaseEntity> list = getMemberRewardPointRedemptionList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_MEMBER_ADDRESS_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreMemberAddressList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_MEMBER_GIFT_CARD_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreMemberGiftCardList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}

    		//other property not include here
		return super.propertyOf(property);
	}
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public RetailStoreMember updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setName(String name){
		this.mName = trimString(name);;
	}
	public String getName(){
		return this.mName;
	}
	public RetailStoreMember updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setMobilePhone(String mobilePhone){
		this.mMobilePhone = trimString(mobilePhone);;
	}
	public String getMobilePhone(){
		return this.mMobilePhone;
	}
	public RetailStoreMember updateMobilePhone(String mobilePhone){
		this.mMobilePhone = trimString(mobilePhone);;
		this.changed = true;
		return this;
	}
	public void mergeMobilePhone(String mobilePhone){
		if(mobilePhone != null) { setMobilePhone(mobilePhone);}
	}
	
	
	
	public String getMaskedMobilePhone(){
		String mobilePhoneNumber = getMobilePhone();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	public RetailStoreMember updateOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
		this.changed = true;
		return this;
	}
	public void mergeOwner(RetailStoreCountryCenter owner){
		if(owner != null) { setOwner(owner);}
	}
	
	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreMember updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<ConsumerOrder> getConsumerOrderList(){
		if(this.mConsumerOrderList == null){
			this.mConsumerOrderList = new SmartList<ConsumerOrder>();
			this.mConsumerOrderList.setListInternalName (CONSUMER_ORDER_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mConsumerOrderList;	
	}
	public  void setConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setConsumer(this);
		}

		this.mConsumerOrderList = consumerOrderList;
		this.mConsumerOrderList.setListInternalName (CONSUMER_ORDER_LIST );
		
	}
	
	public  void addConsumerOrder(ConsumerOrder consumerOrder){
		consumerOrder.setConsumer(this);
		getConsumerOrderList().add(consumerOrder);
	}
	public  void addConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		for( ConsumerOrder consumerOrder:consumerOrderList){
			consumerOrder.setConsumer(this);
		}
		getConsumerOrderList().addAll(consumerOrderList);
	}
	public  void mergeConsumerOrderList(SmartList<ConsumerOrder> consumerOrderList){
		if(consumerOrderList==null){
			return;
		}
		if(consumerOrderList.isEmpty()){
			return;
		}
		addConsumerOrderList( consumerOrderList );
		
	}
	public  ConsumerOrder removeConsumerOrder(ConsumerOrder consumerOrderIndex){
		
		int index = getConsumerOrderList().indexOf(consumerOrderIndex);
        if(index < 0){
        	String message = "ConsumerOrder("+consumerOrderIndex.getId()+") with version='"+consumerOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ConsumerOrder consumerOrder = getConsumerOrderList().get(index);        
        // consumerOrder.clearConsumer(); //disconnect with Consumer
        consumerOrder.clearFromAll(); //disconnect with Consumer
		
		boolean result = getConsumerOrderList().planToRemove(consumerOrder);
        if(!result){
        	String message = "ConsumerOrder("+consumerOrderIndex.getId()+") with version='"+consumerOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return consumerOrder;
        
	
	}
	//断舍离
	public  void breakWithConsumerOrder(ConsumerOrder consumerOrder){
		
		if(consumerOrder == null){
			return;
		}
		consumerOrder.setConsumer(null);
		//getConsumerOrderList().remove();
	
	}
	
	public  boolean hasConsumerOrder(ConsumerOrder consumerOrder){
	
		return getConsumerOrderList().contains(consumerOrder);
  
	}
	
	public void copyConsumerOrderFrom(ConsumerOrder consumerOrder) {

		ConsumerOrder consumerOrderInList = findTheConsumerOrder(consumerOrder);
		ConsumerOrder newConsumerOrder = new ConsumerOrder();
		consumerOrderInList.copyTo(newConsumerOrder);
		newConsumerOrder.setVersion(0);//will trigger copy
		getConsumerOrderList().add(newConsumerOrder);
		addItemToFlexiableObject(COPIED_CHILD, newConsumerOrder);
	}
	
	public  ConsumerOrder findTheConsumerOrder(ConsumerOrder consumerOrder){
		
		int index =  getConsumerOrderList().indexOf(consumerOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ConsumerOrder("+consumerOrder.getId()+") with version='"+consumerOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getConsumerOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpConsumerOrderList(){
		getConsumerOrderList().clear();
	}
	
	
	


	public  SmartList<RetailStoreMemberCoupon> getRetailStoreMemberCouponList(){
		if(this.mRetailStoreMemberCouponList == null){
			this.mRetailStoreMemberCouponList = new SmartList<RetailStoreMemberCoupon>();
			this.mRetailStoreMemberCouponList.setListInternalName (RETAIL_STORE_MEMBER_COUPON_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreMemberCouponList;	
	}
	public  void setRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		for( RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList){
			retailStoreMemberCoupon.setOwner(this);
		}

		this.mRetailStoreMemberCouponList = retailStoreMemberCouponList;
		this.mRetailStoreMemberCouponList.setListInternalName (RETAIL_STORE_MEMBER_COUPON_LIST );
		
	}
	
	public  void addRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon){
		retailStoreMemberCoupon.setOwner(this);
		getRetailStoreMemberCouponList().add(retailStoreMemberCoupon);
	}
	public  void addRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		for( RetailStoreMemberCoupon retailStoreMemberCoupon:retailStoreMemberCouponList){
			retailStoreMemberCoupon.setOwner(this);
		}
		getRetailStoreMemberCouponList().addAll(retailStoreMemberCouponList);
	}
	public  void mergeRetailStoreMemberCouponList(SmartList<RetailStoreMemberCoupon> retailStoreMemberCouponList){
		if(retailStoreMemberCouponList==null){
			return;
		}
		if(retailStoreMemberCouponList.isEmpty()){
			return;
		}
		addRetailStoreMemberCouponList( retailStoreMemberCouponList );
		
	}
	public  RetailStoreMemberCoupon removeRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCouponIndex){
		
		int index = getRetailStoreMemberCouponList().indexOf(retailStoreMemberCouponIndex);
        if(index < 0){
        	String message = "RetailStoreMemberCoupon("+retailStoreMemberCouponIndex.getId()+") with version='"+retailStoreMemberCouponIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreMemberCoupon retailStoreMemberCoupon = getRetailStoreMemberCouponList().get(index);        
        // retailStoreMemberCoupon.clearOwner(); //disconnect with Owner
        retailStoreMemberCoupon.clearFromAll(); //disconnect with Owner
		
		boolean result = getRetailStoreMemberCouponList().planToRemove(retailStoreMemberCoupon);
        if(!result){
        	String message = "RetailStoreMemberCoupon("+retailStoreMemberCouponIndex.getId()+") with version='"+retailStoreMemberCouponIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreMemberCoupon;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon){
		
		if(retailStoreMemberCoupon == null){
			return;
		}
		retailStoreMemberCoupon.setOwner(null);
		//getRetailStoreMemberCouponList().remove();
	
	}
	
	public  boolean hasRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon){
	
		return getRetailStoreMemberCouponList().contains(retailStoreMemberCoupon);
  
	}
	
	public void copyRetailStoreMemberCouponFrom(RetailStoreMemberCoupon retailStoreMemberCoupon) {

		RetailStoreMemberCoupon retailStoreMemberCouponInList = findTheRetailStoreMemberCoupon(retailStoreMemberCoupon);
		RetailStoreMemberCoupon newRetailStoreMemberCoupon = new RetailStoreMemberCoupon();
		retailStoreMemberCouponInList.copyTo(newRetailStoreMemberCoupon);
		newRetailStoreMemberCoupon.setVersion(0);//will trigger copy
		getRetailStoreMemberCouponList().add(newRetailStoreMemberCoupon);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMemberCoupon);
	}
	
	public  RetailStoreMemberCoupon findTheRetailStoreMemberCoupon(RetailStoreMemberCoupon retailStoreMemberCoupon){
		
		int index =  getRetailStoreMemberCouponList().indexOf(retailStoreMemberCoupon);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreMemberCoupon("+retailStoreMemberCoupon.getId()+") with version='"+retailStoreMemberCoupon.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreMemberCouponList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberCouponList(){
		getRetailStoreMemberCouponList().clear();
	}
	
	
	


	public  SmartList<MemberWishlist> getMemberWishlistList(){
		if(this.mMemberWishlistList == null){
			this.mMemberWishlistList = new SmartList<MemberWishlist>();
			this.mMemberWishlistList.setListInternalName (MEMBER_WISHLIST_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mMemberWishlistList;	
	}
	public  void setMemberWishlistList(SmartList<MemberWishlist> memberWishlistList){
		for( MemberWishlist memberWishlist:memberWishlistList){
			memberWishlist.setOwner(this);
		}

		this.mMemberWishlistList = memberWishlistList;
		this.mMemberWishlistList.setListInternalName (MEMBER_WISHLIST_LIST );
		
	}
	
	public  void addMemberWishlist(MemberWishlist memberWishlist){
		memberWishlist.setOwner(this);
		getMemberWishlistList().add(memberWishlist);
	}
	public  void addMemberWishlistList(SmartList<MemberWishlist> memberWishlistList){
		for( MemberWishlist memberWishlist:memberWishlistList){
			memberWishlist.setOwner(this);
		}
		getMemberWishlistList().addAll(memberWishlistList);
	}
	public  void mergeMemberWishlistList(SmartList<MemberWishlist> memberWishlistList){
		if(memberWishlistList==null){
			return;
		}
		if(memberWishlistList.isEmpty()){
			return;
		}
		addMemberWishlistList( memberWishlistList );
		
	}
	public  MemberWishlist removeMemberWishlist(MemberWishlist memberWishlistIndex){
		
		int index = getMemberWishlistList().indexOf(memberWishlistIndex);
        if(index < 0){
        	String message = "MemberWishlist("+memberWishlistIndex.getId()+") with version='"+memberWishlistIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        MemberWishlist memberWishlist = getMemberWishlistList().get(index);        
        // memberWishlist.clearOwner(); //disconnect with Owner
        memberWishlist.clearFromAll(); //disconnect with Owner
		
		boolean result = getMemberWishlistList().planToRemove(memberWishlist);
        if(!result){
        	String message = "MemberWishlist("+memberWishlistIndex.getId()+") with version='"+memberWishlistIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return memberWishlist;
        
	
	}
	//断舍离
	public  void breakWithMemberWishlist(MemberWishlist memberWishlist){
		
		if(memberWishlist == null){
			return;
		}
		memberWishlist.setOwner(null);
		//getMemberWishlistList().remove();
	
	}
	
	public  boolean hasMemberWishlist(MemberWishlist memberWishlist){
	
		return getMemberWishlistList().contains(memberWishlist);
  
	}
	
	public void copyMemberWishlistFrom(MemberWishlist memberWishlist) {

		MemberWishlist memberWishlistInList = findTheMemberWishlist(memberWishlist);
		MemberWishlist newMemberWishlist = new MemberWishlist();
		memberWishlistInList.copyTo(newMemberWishlist);
		newMemberWishlist.setVersion(0);//will trigger copy
		getMemberWishlistList().add(newMemberWishlist);
		addItemToFlexiableObject(COPIED_CHILD, newMemberWishlist);
	}
	
	public  MemberWishlist findTheMemberWishlist(MemberWishlist memberWishlist){
		
		int index =  getMemberWishlistList().indexOf(memberWishlist);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "MemberWishlist("+memberWishlist.getId()+") with version='"+memberWishlist.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getMemberWishlistList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberWishlistList(){
		getMemberWishlistList().clear();
	}
	
	
	


	public  SmartList<MemberRewardPoint> getMemberRewardPointList(){
		if(this.mMemberRewardPointList == null){
			this.mMemberRewardPointList = new SmartList<MemberRewardPoint>();
			this.mMemberRewardPointList.setListInternalName (MEMBER_REWARD_POINT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mMemberRewardPointList;	
	}
	public  void setMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList){
		for( MemberRewardPoint memberRewardPoint:memberRewardPointList){
			memberRewardPoint.setOwner(this);
		}

		this.mMemberRewardPointList = memberRewardPointList;
		this.mMemberRewardPointList.setListInternalName (MEMBER_REWARD_POINT_LIST );
		
	}
	
	public  void addMemberRewardPoint(MemberRewardPoint memberRewardPoint){
		memberRewardPoint.setOwner(this);
		getMemberRewardPointList().add(memberRewardPoint);
	}
	public  void addMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList){
		for( MemberRewardPoint memberRewardPoint:memberRewardPointList){
			memberRewardPoint.setOwner(this);
		}
		getMemberRewardPointList().addAll(memberRewardPointList);
	}
	public  void mergeMemberRewardPointList(SmartList<MemberRewardPoint> memberRewardPointList){
		if(memberRewardPointList==null){
			return;
		}
		if(memberRewardPointList.isEmpty()){
			return;
		}
		addMemberRewardPointList( memberRewardPointList );
		
	}
	public  MemberRewardPoint removeMemberRewardPoint(MemberRewardPoint memberRewardPointIndex){
		
		int index = getMemberRewardPointList().indexOf(memberRewardPointIndex);
        if(index < 0){
        	String message = "MemberRewardPoint("+memberRewardPointIndex.getId()+") with version='"+memberRewardPointIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        MemberRewardPoint memberRewardPoint = getMemberRewardPointList().get(index);        
        // memberRewardPoint.clearOwner(); //disconnect with Owner
        memberRewardPoint.clearFromAll(); //disconnect with Owner
		
		boolean result = getMemberRewardPointList().planToRemove(memberRewardPoint);
        if(!result){
        	String message = "MemberRewardPoint("+memberRewardPointIndex.getId()+") with version='"+memberRewardPointIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return memberRewardPoint;
        
	
	}
	//断舍离
	public  void breakWithMemberRewardPoint(MemberRewardPoint memberRewardPoint){
		
		if(memberRewardPoint == null){
			return;
		}
		memberRewardPoint.setOwner(null);
		//getMemberRewardPointList().remove();
	
	}
	
	public  boolean hasMemberRewardPoint(MemberRewardPoint memberRewardPoint){
	
		return getMemberRewardPointList().contains(memberRewardPoint);
  
	}
	
	public void copyMemberRewardPointFrom(MemberRewardPoint memberRewardPoint) {

		MemberRewardPoint memberRewardPointInList = findTheMemberRewardPoint(memberRewardPoint);
		MemberRewardPoint newMemberRewardPoint = new MemberRewardPoint();
		memberRewardPointInList.copyTo(newMemberRewardPoint);
		newMemberRewardPoint.setVersion(0);//will trigger copy
		getMemberRewardPointList().add(newMemberRewardPoint);
		addItemToFlexiableObject(COPIED_CHILD, newMemberRewardPoint);
	}
	
	public  MemberRewardPoint findTheMemberRewardPoint(MemberRewardPoint memberRewardPoint){
		
		int index =  getMemberRewardPointList().indexOf(memberRewardPoint);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "MemberRewardPoint("+memberRewardPoint.getId()+") with version='"+memberRewardPoint.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getMemberRewardPointList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberRewardPointList(){
		getMemberRewardPointList().clear();
	}
	
	
	


	public  SmartList<MemberRewardPointRedemption> getMemberRewardPointRedemptionList(){
		if(this.mMemberRewardPointRedemptionList == null){
			this.mMemberRewardPointRedemptionList = new SmartList<MemberRewardPointRedemption>();
			this.mMemberRewardPointRedemptionList.setListInternalName (MEMBER_REWARD_POINT_REDEMPTION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mMemberRewardPointRedemptionList;	
	}
	public  void setMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		for( MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList){
			memberRewardPointRedemption.setOwner(this);
		}

		this.mMemberRewardPointRedemptionList = memberRewardPointRedemptionList;
		this.mMemberRewardPointRedemptionList.setListInternalName (MEMBER_REWARD_POINT_REDEMPTION_LIST );
		
	}
	
	public  void addMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption){
		memberRewardPointRedemption.setOwner(this);
		getMemberRewardPointRedemptionList().add(memberRewardPointRedemption);
	}
	public  void addMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		for( MemberRewardPointRedemption memberRewardPointRedemption:memberRewardPointRedemptionList){
			memberRewardPointRedemption.setOwner(this);
		}
		getMemberRewardPointRedemptionList().addAll(memberRewardPointRedemptionList);
	}
	public  void mergeMemberRewardPointRedemptionList(SmartList<MemberRewardPointRedemption> memberRewardPointRedemptionList){
		if(memberRewardPointRedemptionList==null){
			return;
		}
		if(memberRewardPointRedemptionList.isEmpty()){
			return;
		}
		addMemberRewardPointRedemptionList( memberRewardPointRedemptionList );
		
	}
	public  MemberRewardPointRedemption removeMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemptionIndex){
		
		int index = getMemberRewardPointRedemptionList().indexOf(memberRewardPointRedemptionIndex);
        if(index < 0){
        	String message = "MemberRewardPointRedemption("+memberRewardPointRedemptionIndex.getId()+") with version='"+memberRewardPointRedemptionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        MemberRewardPointRedemption memberRewardPointRedemption = getMemberRewardPointRedemptionList().get(index);        
        // memberRewardPointRedemption.clearOwner(); //disconnect with Owner
        memberRewardPointRedemption.clearFromAll(); //disconnect with Owner
		
		boolean result = getMemberRewardPointRedemptionList().planToRemove(memberRewardPointRedemption);
        if(!result){
        	String message = "MemberRewardPointRedemption("+memberRewardPointRedemptionIndex.getId()+") with version='"+memberRewardPointRedemptionIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return memberRewardPointRedemption;
        
	
	}
	//断舍离
	public  void breakWithMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption){
		
		if(memberRewardPointRedemption == null){
			return;
		}
		memberRewardPointRedemption.setOwner(null);
		//getMemberRewardPointRedemptionList().remove();
	
	}
	
	public  boolean hasMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption){
	
		return getMemberRewardPointRedemptionList().contains(memberRewardPointRedemption);
  
	}
	
	public void copyMemberRewardPointRedemptionFrom(MemberRewardPointRedemption memberRewardPointRedemption) {

		MemberRewardPointRedemption memberRewardPointRedemptionInList = findTheMemberRewardPointRedemption(memberRewardPointRedemption);
		MemberRewardPointRedemption newMemberRewardPointRedemption = new MemberRewardPointRedemption();
		memberRewardPointRedemptionInList.copyTo(newMemberRewardPointRedemption);
		newMemberRewardPointRedemption.setVersion(0);//will trigger copy
		getMemberRewardPointRedemptionList().add(newMemberRewardPointRedemption);
		addItemToFlexiableObject(COPIED_CHILD, newMemberRewardPointRedemption);
	}
	
	public  MemberRewardPointRedemption findTheMemberRewardPointRedemption(MemberRewardPointRedemption memberRewardPointRedemption){
		
		int index =  getMemberRewardPointRedemptionList().indexOf(memberRewardPointRedemption);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "MemberRewardPointRedemption("+memberRewardPointRedemption.getId()+") with version='"+memberRewardPointRedemption.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getMemberRewardPointRedemptionList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpMemberRewardPointRedemptionList(){
		getMemberRewardPointRedemptionList().clear();
	}
	
	
	


	public  SmartList<RetailStoreMemberAddress> getRetailStoreMemberAddressList(){
		if(this.mRetailStoreMemberAddressList == null){
			this.mRetailStoreMemberAddressList = new SmartList<RetailStoreMemberAddress>();
			this.mRetailStoreMemberAddressList.setListInternalName (RETAIL_STORE_MEMBER_ADDRESS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreMemberAddressList;	
	}
	public  void setRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList){
		for( RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList){
			retailStoreMemberAddress.setOwner(this);
		}

		this.mRetailStoreMemberAddressList = retailStoreMemberAddressList;
		this.mRetailStoreMemberAddressList.setListInternalName (RETAIL_STORE_MEMBER_ADDRESS_LIST );
		
	}
	
	public  void addRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress){
		retailStoreMemberAddress.setOwner(this);
		getRetailStoreMemberAddressList().add(retailStoreMemberAddress);
	}
	public  void addRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList){
		for( RetailStoreMemberAddress retailStoreMemberAddress:retailStoreMemberAddressList){
			retailStoreMemberAddress.setOwner(this);
		}
		getRetailStoreMemberAddressList().addAll(retailStoreMemberAddressList);
	}
	public  void mergeRetailStoreMemberAddressList(SmartList<RetailStoreMemberAddress> retailStoreMemberAddressList){
		if(retailStoreMemberAddressList==null){
			return;
		}
		if(retailStoreMemberAddressList.isEmpty()){
			return;
		}
		addRetailStoreMemberAddressList( retailStoreMemberAddressList );
		
	}
	public  RetailStoreMemberAddress removeRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddressIndex){
		
		int index = getRetailStoreMemberAddressList().indexOf(retailStoreMemberAddressIndex);
        if(index < 0){
        	String message = "RetailStoreMemberAddress("+retailStoreMemberAddressIndex.getId()+") with version='"+retailStoreMemberAddressIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreMemberAddress retailStoreMemberAddress = getRetailStoreMemberAddressList().get(index);        
        // retailStoreMemberAddress.clearOwner(); //disconnect with Owner
        retailStoreMemberAddress.clearFromAll(); //disconnect with Owner
		
		boolean result = getRetailStoreMemberAddressList().planToRemove(retailStoreMemberAddress);
        if(!result){
        	String message = "RetailStoreMemberAddress("+retailStoreMemberAddressIndex.getId()+") with version='"+retailStoreMemberAddressIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreMemberAddress;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress){
		
		if(retailStoreMemberAddress == null){
			return;
		}
		retailStoreMemberAddress.setOwner(null);
		//getRetailStoreMemberAddressList().remove();
	
	}
	
	public  boolean hasRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress){
	
		return getRetailStoreMemberAddressList().contains(retailStoreMemberAddress);
  
	}
	
	public void copyRetailStoreMemberAddressFrom(RetailStoreMemberAddress retailStoreMemberAddress) {

		RetailStoreMemberAddress retailStoreMemberAddressInList = findTheRetailStoreMemberAddress(retailStoreMemberAddress);
		RetailStoreMemberAddress newRetailStoreMemberAddress = new RetailStoreMemberAddress();
		retailStoreMemberAddressInList.copyTo(newRetailStoreMemberAddress);
		newRetailStoreMemberAddress.setVersion(0);//will trigger copy
		getRetailStoreMemberAddressList().add(newRetailStoreMemberAddress);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMemberAddress);
	}
	
	public  RetailStoreMemberAddress findTheRetailStoreMemberAddress(RetailStoreMemberAddress retailStoreMemberAddress){
		
		int index =  getRetailStoreMemberAddressList().indexOf(retailStoreMemberAddress);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreMemberAddress("+retailStoreMemberAddress.getId()+") with version='"+retailStoreMemberAddress.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreMemberAddressList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberAddressList(){
		getRetailStoreMemberAddressList().clear();
	}
	
	
	


	public  SmartList<RetailStoreMemberGiftCard> getRetailStoreMemberGiftCardList(){
		if(this.mRetailStoreMemberGiftCardList == null){
			this.mRetailStoreMemberGiftCardList = new SmartList<RetailStoreMemberGiftCard>();
			this.mRetailStoreMemberGiftCardList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreMemberGiftCardList;	
	}
	public  void setRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		for( RetailStoreMemberGiftCard retailStoreMemberGiftCard:retailStoreMemberGiftCardList){
			retailStoreMemberGiftCard.setOwner(this);
		}

		this.mRetailStoreMemberGiftCardList = retailStoreMemberGiftCardList;
		this.mRetailStoreMemberGiftCardList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_LIST );
		
	}
	
	public  void addRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
		retailStoreMemberGiftCard.setOwner(this);
		getRetailStoreMemberGiftCardList().add(retailStoreMemberGiftCard);
	}
	public  void addRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		for( RetailStoreMemberGiftCard retailStoreMemberGiftCard:retailStoreMemberGiftCardList){
			retailStoreMemberGiftCard.setOwner(this);
		}
		getRetailStoreMemberGiftCardList().addAll(retailStoreMemberGiftCardList);
	}
	public  void mergeRetailStoreMemberGiftCardList(SmartList<RetailStoreMemberGiftCard> retailStoreMemberGiftCardList){
		if(retailStoreMemberGiftCardList==null){
			return;
		}
		if(retailStoreMemberGiftCardList.isEmpty()){
			return;
		}
		addRetailStoreMemberGiftCardList( retailStoreMemberGiftCardList );
		
	}
	public  RetailStoreMemberGiftCard removeRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCardIndex){
		
		int index = getRetailStoreMemberGiftCardList().indexOf(retailStoreMemberGiftCardIndex);
        if(index < 0){
        	String message = "RetailStoreMemberGiftCard("+retailStoreMemberGiftCardIndex.getId()+") with version='"+retailStoreMemberGiftCardIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreMemberGiftCard retailStoreMemberGiftCard = getRetailStoreMemberGiftCardList().get(index);        
        // retailStoreMemberGiftCard.clearOwner(); //disconnect with Owner
        retailStoreMemberGiftCard.clearFromAll(); //disconnect with Owner
		
		boolean result = getRetailStoreMemberGiftCardList().planToRemove(retailStoreMemberGiftCard);
        if(!result){
        	String message = "RetailStoreMemberGiftCard("+retailStoreMemberGiftCardIndex.getId()+") with version='"+retailStoreMemberGiftCardIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreMemberGiftCard;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
		
		if(retailStoreMemberGiftCard == null){
			return;
		}
		retailStoreMemberGiftCard.setOwner(null);
		//getRetailStoreMemberGiftCardList().remove();
	
	}
	
	public  boolean hasRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
	
		return getRetailStoreMemberGiftCardList().contains(retailStoreMemberGiftCard);
  
	}
	
	public void copyRetailStoreMemberGiftCardFrom(RetailStoreMemberGiftCard retailStoreMemberGiftCard) {

		RetailStoreMemberGiftCard retailStoreMemberGiftCardInList = findTheRetailStoreMemberGiftCard(retailStoreMemberGiftCard);
		RetailStoreMemberGiftCard newRetailStoreMemberGiftCard = new RetailStoreMemberGiftCard();
		retailStoreMemberGiftCardInList.copyTo(newRetailStoreMemberGiftCard);
		newRetailStoreMemberGiftCard.setVersion(0);//will trigger copy
		getRetailStoreMemberGiftCardList().add(newRetailStoreMemberGiftCard);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMemberGiftCard);
	}
	
	public  RetailStoreMemberGiftCard findTheRetailStoreMemberGiftCard(RetailStoreMemberGiftCard retailStoreMemberGiftCard){
		
		int index =  getRetailStoreMemberGiftCardList().indexOf(retailStoreMemberGiftCard);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreMemberGiftCard("+retailStoreMemberGiftCard.getId()+") with version='"+retailStoreMemberGiftCard.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreMemberGiftCardList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreMemberGiftCardList(){
		getRetailStoreMemberGiftCardList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getConsumerOrderList(), internalType);
		collectFromList(this, entityList, getRetailStoreMemberCouponList(), internalType);
		collectFromList(this, entityList, getMemberWishlistList(), internalType);
		collectFromList(this, entityList, getMemberRewardPointList(), internalType);
		collectFromList(this, entityList, getMemberRewardPointRedemptionList(), internalType);
		collectFromList(this, entityList, getRetailStoreMemberAddressList(), internalType);
		collectFromList(this, entityList, getRetailStoreMemberGiftCardList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getConsumerOrderList());
		listOfList.add( getRetailStoreMemberCouponList());
		listOfList.add( getMemberWishlistList());
		listOfList.add( getMemberRewardPointList());
		listOfList.add( getMemberRewardPointRedemptionList());
		listOfList.add( getRetailStoreMemberAddressList());
		listOfList.add( getRetailStoreMemberGiftCardList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MOBILE_PHONE_PROPERTY, getMaskedMobilePhone());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CONSUMER_ORDER_LIST, getConsumerOrderList());
		if(!getConsumerOrderList().isEmpty()){
			appendKeyValuePair(result, "consumerOrderCount", getConsumerOrderList().getTotalCount());
			appendKeyValuePair(result, "consumerOrderCurrentPageNumber", getConsumerOrderList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_MEMBER_COUPON_LIST, getRetailStoreMemberCouponList());
		if(!getRetailStoreMemberCouponList().isEmpty()){
			appendKeyValuePair(result, "retailStoreMemberCouponCount", getRetailStoreMemberCouponList().getTotalCount());
			appendKeyValuePair(result, "retailStoreMemberCouponCurrentPageNumber", getRetailStoreMemberCouponList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, MEMBER_WISHLIST_LIST, getMemberWishlistList());
		if(!getMemberWishlistList().isEmpty()){
			appendKeyValuePair(result, "memberWishlistCount", getMemberWishlistList().getTotalCount());
			appendKeyValuePair(result, "memberWishlistCurrentPageNumber", getMemberWishlistList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, MEMBER_REWARD_POINT_LIST, getMemberRewardPointList());
		if(!getMemberRewardPointList().isEmpty()){
			appendKeyValuePair(result, "memberRewardPointCount", getMemberRewardPointList().getTotalCount());
			appendKeyValuePair(result, "memberRewardPointCurrentPageNumber", getMemberRewardPointList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, MEMBER_REWARD_POINT_REDEMPTION_LIST, getMemberRewardPointRedemptionList());
		if(!getMemberRewardPointRedemptionList().isEmpty()){
			appendKeyValuePair(result, "memberRewardPointRedemptionCount", getMemberRewardPointRedemptionList().getTotalCount());
			appendKeyValuePair(result, "memberRewardPointRedemptionCurrentPageNumber", getMemberRewardPointRedemptionList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_MEMBER_ADDRESS_LIST, getRetailStoreMemberAddressList());
		if(!getRetailStoreMemberAddressList().isEmpty()){
			appendKeyValuePair(result, "retailStoreMemberAddressCount", getRetailStoreMemberAddressList().getTotalCount());
			appendKeyValuePair(result, "retailStoreMemberAddressCurrentPageNumber", getRetailStoreMemberAddressList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_MEMBER_GIFT_CARD_LIST, getRetailStoreMemberGiftCardList());
		if(!getRetailStoreMemberGiftCardList().isEmpty()){
			appendKeyValuePair(result, "retailStoreMemberGiftCardCount", getRetailStoreMemberGiftCardList().getTotalCount());
			appendKeyValuePair(result, "retailStoreMemberGiftCardCurrentPageNumber", getRetailStoreMemberGiftCardList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMember){
		
		
			RetailStoreMember dest =(RetailStoreMember)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setMobilePhone(getMobilePhone());
			dest.setOwner(getOwner());
			dest.setVersion(getVersion());
			dest.setConsumerOrderList(getConsumerOrderList());
			dest.setRetailStoreMemberCouponList(getRetailStoreMemberCouponList());
			dest.setMemberWishlistList(getMemberWishlistList());
			dest.setMemberRewardPointList(getMemberRewardPointList());
			dest.setMemberRewardPointRedemptionList(getMemberRewardPointRedemptionList());
			dest.setRetailStoreMemberAddressList(getRetailStoreMemberAddressList());
			dest.setRetailStoreMemberGiftCardList(getRetailStoreMemberGiftCardList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMember){
		
			
			RetailStoreMember dest =(RetailStoreMember)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobilePhone(getMobilePhone());
			dest.mergeOwner(getOwner());
			dest.mergeVersion(getVersion());
			dest.mergeConsumerOrderList(getConsumerOrderList());
			dest.mergeRetailStoreMemberCouponList(getRetailStoreMemberCouponList());
			dest.mergeMemberWishlistList(getMemberWishlistList());
			dest.mergeMemberRewardPointList(getMemberRewardPointList());
			dest.mergeMemberRewardPointRedemptionList(getMemberRewardPointRedemptionList());
			dest.mergeRetailStoreMemberAddressList(getRetailStoreMemberAddressList());
			dest.mergeRetailStoreMemberGiftCardList(getRetailStoreMemberGiftCardList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreMember){
		
			
			RetailStoreMember dest =(RetailStoreMember)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobilePhone(getMobilePhone());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getMobilePhone(), getOwner(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreMember{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobilePhone='"+getMobilePhone()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreCountryCenter("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

