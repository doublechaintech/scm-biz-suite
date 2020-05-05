
package com.doublechaintech.retailscm.retailstoreorder;

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
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.retailstoreordershippinggroup.RetailStoreOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoreorderpaymentgroup.RetailStoreOrderPaymentGroup;
import com.doublechaintech.retailscm.retailstoreorderlineitem.RetailStoreOrderLineItem;

@JsonSerialize(using = RetailStoreOrderSerializer.class)
public class RetailStoreOrder extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BUYER_PROPERTY                 = "buyer"             ;
	public static final String SELLER_PROPERTY                = "seller"            ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String TOTAL_AMOUNT_PROPERTY          = "totalAmount"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String RETAIL_STORE_ORDER_LINE_ITEM_LIST        = "retailStoreOrderLineItemList";
	public static final String RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST   = "retailStoreOrderShippingGroupList";
	public static final String RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST    = "retailStoreOrderPaymentGroupList";
	public static final String GOODS_LIST                               = "goodsList"         ;

	public static final String INTERNAL_TYPE="RetailStoreOrder";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		RetailStore         	mBuyer              ;
	protected		RetailStoreCountryCenter	mSeller             ;
	protected		String              	mTitle              ;
	protected		BigDecimal          	mTotalAmount        ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<RetailStoreOrderLineItem>	mRetailStoreOrderLineItemList;
	protected		SmartList<RetailStoreOrderShippingGroup>	mRetailStoreOrderShippingGroupList;
	protected		SmartList<RetailStoreOrderPaymentGroup>	mRetailStoreOrderPaymentGroupList;
	protected		SmartList<Goods>    	mGoodsList          ;

	
		
	public 	RetailStoreOrder(){
		// lazy load for all the properties
	}
	public 	static RetailStoreOrder withId(String id){
		RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
		retailStoreOrder.setId(id);
		retailStoreOrder.setVersion(Integer.MAX_VALUE);
		return retailStoreOrder;
	}
	public 	static RetailStoreOrder refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBuyer( null );
		setSeller( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
		}
		if(TOTAL_AMOUNT_PROPERTY.equals(property)){
			changeTotalAmountProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeTitleProperty(String newValueExpr){
	
		String oldValue = getTitle();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTitle(newValue);
		this.onChangeProperty(TITLE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeTotalAmountProperty(String newValueExpr){
	
		BigDecimal oldValue = getTotalAmount();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTotalAmount(newValue);
		this.onChangeProperty(TOTAL_AMOUNT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLastUpdateTimeProperty(String newValueExpr){
	
		DateTime oldValue = getLastUpdateTime();
		DateTime newValue = parseTimestamp(newValueExpr);
		if(equalsTimestamp(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLastUpdateTime(newValue);
		this.onChangeProperty(LAST_UPDATE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(BUYER_PROPERTY.equals(property)){
			return getBuyer();
		}
		if(SELLER_PROPERTY.equals(property)){
			return getSeller();
		}
		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(TOTAL_AMOUNT_PROPERTY.equals(property)){
			return getTotalAmount();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(RETAIL_STORE_ORDER_LINE_ITEM_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreOrderLineItemList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreOrderShippingGroupList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreOrderPaymentGroupList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(GOODS_LIST.equals(property)){
			List<BaseEntity> list = getGoodsList().stream().map(item->item).collect(Collectors.toList());
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
	public RetailStoreOrder updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setBuyer(RetailStore buyer){
		this.mBuyer = buyer;;
	}
	public RetailStore getBuyer(){
		return this.mBuyer;
	}
	public RetailStoreOrder updateBuyer(RetailStore buyer){
		this.mBuyer = buyer;;
		this.changed = true;
		return this;
	}
	public void mergeBuyer(RetailStore buyer){
		if(buyer != null) { setBuyer(buyer);}
	}
	
	
	public void clearBuyer(){
		setBuyer ( null );
		this.changed = true;
	}
	
	public void setSeller(RetailStoreCountryCenter seller){
		this.mSeller = seller;;
	}
	public RetailStoreCountryCenter getSeller(){
		return this.mSeller;
	}
	public RetailStoreOrder updateSeller(RetailStoreCountryCenter seller){
		this.mSeller = seller;;
		this.changed = true;
		return this;
	}
	public void mergeSeller(RetailStoreCountryCenter seller){
		if(seller != null) { setSeller(seller);}
	}
	
	
	public void clearSeller(){
		setSeller ( null );
		this.changed = true;
	}
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public RetailStoreOrder updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}
	
	
	public void setTotalAmount(BigDecimal totalAmount){
		this.mTotalAmount = totalAmount;;
	}
	public BigDecimal getTotalAmount(){
		return this.mTotalAmount;
	}
	public RetailStoreOrder updateTotalAmount(BigDecimal totalAmount){
		this.mTotalAmount = totalAmount;;
		this.changed = true;
		return this;
	}
	public void mergeTotalAmount(BigDecimal totalAmount){
		setTotalAmount(totalAmount);
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public RetailStoreOrder updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public RetailStoreOrder updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<RetailStoreOrderLineItem> getRetailStoreOrderLineItemList(){
		if(this.mRetailStoreOrderLineItemList == null){
			this.mRetailStoreOrderLineItemList = new SmartList<RetailStoreOrderLineItem>();
			this.mRetailStoreOrderLineItemList.setListInternalName (RETAIL_STORE_ORDER_LINE_ITEM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreOrderLineItemList;	
	}
	public  void setRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		for( RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			retailStoreOrderLineItem.setBizOrder(this);
		}

		this.mRetailStoreOrderLineItemList = retailStoreOrderLineItemList;
		this.mRetailStoreOrderLineItemList.setListInternalName (RETAIL_STORE_ORDER_LINE_ITEM_LIST );
		
	}
	
	public  void addRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
		retailStoreOrderLineItem.setBizOrder(this);
		getRetailStoreOrderLineItemList().add(retailStoreOrderLineItem);
	}
	public  void addRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		for( RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			retailStoreOrderLineItem.setBizOrder(this);
		}
		getRetailStoreOrderLineItemList().addAll(retailStoreOrderLineItemList);
	}
	public  void mergeRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		if(retailStoreOrderLineItemList==null){
			return;
		}
		if(retailStoreOrderLineItemList.isEmpty()){
			return;
		}
		addRetailStoreOrderLineItemList( retailStoreOrderLineItemList );
		
	}
	public  RetailStoreOrderLineItem removeRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItemIndex){
		
		int index = getRetailStoreOrderLineItemList().indexOf(retailStoreOrderLineItemIndex);
        if(index < 0){
        	String message = "RetailStoreOrderLineItem("+retailStoreOrderLineItemIndex.getId()+") with version='"+retailStoreOrderLineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreOrderLineItem retailStoreOrderLineItem = getRetailStoreOrderLineItemList().get(index);        
        // retailStoreOrderLineItem.clearBizOrder(); //disconnect with BizOrder
        retailStoreOrderLineItem.clearFromAll(); //disconnect with BizOrder
		
		boolean result = getRetailStoreOrderLineItemList().planToRemove(retailStoreOrderLineItem);
        if(!result){
        	String message = "RetailStoreOrderLineItem("+retailStoreOrderLineItemIndex.getId()+") with version='"+retailStoreOrderLineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreOrderLineItem;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
		
		if(retailStoreOrderLineItem == null){
			return;
		}
		retailStoreOrderLineItem.setBizOrder(null);
		//getRetailStoreOrderLineItemList().remove();
	
	}
	
	public  boolean hasRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
	
		return getRetailStoreOrderLineItemList().contains(retailStoreOrderLineItem);
  
	}
	
	public void copyRetailStoreOrderLineItemFrom(RetailStoreOrderLineItem retailStoreOrderLineItem) {

		RetailStoreOrderLineItem retailStoreOrderLineItemInList = findTheRetailStoreOrderLineItem(retailStoreOrderLineItem);
		RetailStoreOrderLineItem newRetailStoreOrderLineItem = new RetailStoreOrderLineItem();
		retailStoreOrderLineItemInList.copyTo(newRetailStoreOrderLineItem);
		newRetailStoreOrderLineItem.setVersion(0);//will trigger copy
		getRetailStoreOrderLineItemList().add(newRetailStoreOrderLineItem);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreOrderLineItem);
	}
	
	public  RetailStoreOrderLineItem findTheRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
		
		int index =  getRetailStoreOrderLineItemList().indexOf(retailStoreOrderLineItem);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreOrderLineItem("+retailStoreOrderLineItem.getId()+") with version='"+retailStoreOrderLineItem.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreOrderLineItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderLineItemList(){
		getRetailStoreOrderLineItemList().clear();
	}
	
	
	


	public  SmartList<RetailStoreOrderShippingGroup> getRetailStoreOrderShippingGroupList(){
		if(this.mRetailStoreOrderShippingGroupList == null){
			this.mRetailStoreOrderShippingGroupList = new SmartList<RetailStoreOrderShippingGroup>();
			this.mRetailStoreOrderShippingGroupList.setListInternalName (RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreOrderShippingGroupList;	
	}
	public  void setRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		for( RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList){
			retailStoreOrderShippingGroup.setBizOrder(this);
		}

		this.mRetailStoreOrderShippingGroupList = retailStoreOrderShippingGroupList;
		this.mRetailStoreOrderShippingGroupList.setListInternalName (RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST );
		
	}
	
	public  void addRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
		retailStoreOrderShippingGroup.setBizOrder(this);
		getRetailStoreOrderShippingGroupList().add(retailStoreOrderShippingGroup);
	}
	public  void addRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		for( RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList){
			retailStoreOrderShippingGroup.setBizOrder(this);
		}
		getRetailStoreOrderShippingGroupList().addAll(retailStoreOrderShippingGroupList);
	}
	public  void mergeRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		if(retailStoreOrderShippingGroupList==null){
			return;
		}
		if(retailStoreOrderShippingGroupList.isEmpty()){
			return;
		}
		addRetailStoreOrderShippingGroupList( retailStoreOrderShippingGroupList );
		
	}
	public  RetailStoreOrderShippingGroup removeRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroupIndex){
		
		int index = getRetailStoreOrderShippingGroupList().indexOf(retailStoreOrderShippingGroupIndex);
        if(index < 0){
        	String message = "RetailStoreOrderShippingGroup("+retailStoreOrderShippingGroupIndex.getId()+") with version='"+retailStoreOrderShippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreOrderShippingGroup retailStoreOrderShippingGroup = getRetailStoreOrderShippingGroupList().get(index);        
        // retailStoreOrderShippingGroup.clearBizOrder(); //disconnect with BizOrder
        retailStoreOrderShippingGroup.clearFromAll(); //disconnect with BizOrder
		
		boolean result = getRetailStoreOrderShippingGroupList().planToRemove(retailStoreOrderShippingGroup);
        if(!result){
        	String message = "RetailStoreOrderShippingGroup("+retailStoreOrderShippingGroupIndex.getId()+") with version='"+retailStoreOrderShippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreOrderShippingGroup;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
		
		if(retailStoreOrderShippingGroup == null){
			return;
		}
		retailStoreOrderShippingGroup.setBizOrder(null);
		//getRetailStoreOrderShippingGroupList().remove();
	
	}
	
	public  boolean hasRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
	
		return getRetailStoreOrderShippingGroupList().contains(retailStoreOrderShippingGroup);
  
	}
	
	public void copyRetailStoreOrderShippingGroupFrom(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup) {

		RetailStoreOrderShippingGroup retailStoreOrderShippingGroupInList = findTheRetailStoreOrderShippingGroup(retailStoreOrderShippingGroup);
		RetailStoreOrderShippingGroup newRetailStoreOrderShippingGroup = new RetailStoreOrderShippingGroup();
		retailStoreOrderShippingGroupInList.copyTo(newRetailStoreOrderShippingGroup);
		newRetailStoreOrderShippingGroup.setVersion(0);//will trigger copy
		getRetailStoreOrderShippingGroupList().add(newRetailStoreOrderShippingGroup);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreOrderShippingGroup);
	}
	
	public  RetailStoreOrderShippingGroup findTheRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
		
		int index =  getRetailStoreOrderShippingGroupList().indexOf(retailStoreOrderShippingGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreOrderShippingGroup("+retailStoreOrderShippingGroup.getId()+") with version='"+retailStoreOrderShippingGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreOrderShippingGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderShippingGroupList(){
		getRetailStoreOrderShippingGroupList().clear();
	}
	
	
	


	public  SmartList<RetailStoreOrderPaymentGroup> getRetailStoreOrderPaymentGroupList(){
		if(this.mRetailStoreOrderPaymentGroupList == null){
			this.mRetailStoreOrderPaymentGroupList = new SmartList<RetailStoreOrderPaymentGroup>();
			this.mRetailStoreOrderPaymentGroupList.setListInternalName (RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mRetailStoreOrderPaymentGroupList;	
	}
	public  void setRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		for( RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			retailStoreOrderPaymentGroup.setBizOrder(this);
		}

		this.mRetailStoreOrderPaymentGroupList = retailStoreOrderPaymentGroupList;
		this.mRetailStoreOrderPaymentGroupList.setListInternalName (RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST );
		
	}
	
	public  void addRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		retailStoreOrderPaymentGroup.setBizOrder(this);
		getRetailStoreOrderPaymentGroupList().add(retailStoreOrderPaymentGroup);
	}
	public  void addRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		for( RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			retailStoreOrderPaymentGroup.setBizOrder(this);
		}
		getRetailStoreOrderPaymentGroupList().addAll(retailStoreOrderPaymentGroupList);
	}
	public  void mergeRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		if(retailStoreOrderPaymentGroupList==null){
			return;
		}
		if(retailStoreOrderPaymentGroupList.isEmpty()){
			return;
		}
		addRetailStoreOrderPaymentGroupList( retailStoreOrderPaymentGroupList );
		
	}
	public  RetailStoreOrderPaymentGroup removeRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroupIndex){
		
		int index = getRetailStoreOrderPaymentGroupList().indexOf(retailStoreOrderPaymentGroupIndex);
        if(index < 0){
        	String message = "RetailStoreOrderPaymentGroup("+retailStoreOrderPaymentGroupIndex.getId()+") with version='"+retailStoreOrderPaymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup = getRetailStoreOrderPaymentGroupList().get(index);        
        // retailStoreOrderPaymentGroup.clearBizOrder(); //disconnect with BizOrder
        retailStoreOrderPaymentGroup.clearFromAll(); //disconnect with BizOrder
		
		boolean result = getRetailStoreOrderPaymentGroupList().planToRemove(retailStoreOrderPaymentGroup);
        if(!result){
        	String message = "RetailStoreOrderPaymentGroup("+retailStoreOrderPaymentGroupIndex.getId()+") with version='"+retailStoreOrderPaymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreOrderPaymentGroup;
        
	
	}
	//断舍离
	public  void breakWithRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		
		if(retailStoreOrderPaymentGroup == null){
			return;
		}
		retailStoreOrderPaymentGroup.setBizOrder(null);
		//getRetailStoreOrderPaymentGroupList().remove();
	
	}
	
	public  boolean hasRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
	
		return getRetailStoreOrderPaymentGroupList().contains(retailStoreOrderPaymentGroup);
  
	}
	
	public void copyRetailStoreOrderPaymentGroupFrom(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup) {

		RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroupInList = findTheRetailStoreOrderPaymentGroup(retailStoreOrderPaymentGroup);
		RetailStoreOrderPaymentGroup newRetailStoreOrderPaymentGroup = new RetailStoreOrderPaymentGroup();
		retailStoreOrderPaymentGroupInList.copyTo(newRetailStoreOrderPaymentGroup);
		newRetailStoreOrderPaymentGroup.setVersion(0);//will trigger copy
		getRetailStoreOrderPaymentGroupList().add(newRetailStoreOrderPaymentGroup);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreOrderPaymentGroup);
	}
	
	public  RetailStoreOrderPaymentGroup findTheRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		
		int index =  getRetailStoreOrderPaymentGroupList().indexOf(retailStoreOrderPaymentGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreOrderPaymentGroup("+retailStoreOrderPaymentGroup.getId()+") with version='"+retailStoreOrderPaymentGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getRetailStoreOrderPaymentGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpRetailStoreOrderPaymentGroupList(){
		getRetailStoreOrderPaymentGroupList().clear();
	}
	
	
	


	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
			this.mGoodsList.setListInternalName (GOODS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStoreOrder(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setRetailStoreOrder(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStoreOrder(this);
		}
		getGoodsList().addAll(goodsList);
	}
	public  void mergeGoodsList(SmartList<Goods> goodsList){
		if(goodsList==null){
			return;
		}
		if(goodsList.isEmpty()){
			return;
		}
		addGoodsList( goodsList );
		
	}
	public  Goods removeGoods(Goods goodsIndex){
		
		int index = getGoodsList().indexOf(goodsIndex);
        if(index < 0){
        	String message = "Goods("+goodsIndex.getId()+") with version='"+goodsIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Goods goods = getGoodsList().get(index);        
        // goods.clearRetailStoreOrder(); //disconnect with RetailStoreOrder
        goods.clearFromAll(); //disconnect with RetailStoreOrder
		
		boolean result = getGoodsList().planToRemove(goods);
        if(!result){
        	String message = "Goods("+goodsIndex.getId()+") with version='"+goodsIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return goods;
        
	
	}
	//断舍离
	public  void breakWithGoods(Goods goods){
		
		if(goods == null){
			return;
		}
		goods.setRetailStoreOrder(null);
		//getGoodsList().remove();
	
	}
	
	public  boolean hasGoods(Goods goods){
	
		return getGoodsList().contains(goods);
  
	}
	
	public void copyGoodsFrom(Goods goods) {

		Goods goodsInList = findTheGoods(goods);
		Goods newGoods = new Goods();
		goodsInList.copyTo(newGoods);
		newGoods.setVersion(0);//will trigger copy
		getGoodsList().add(newGoods);
		addItemToFlexiableObject(COPIED_CHILD, newGoods);
	}
	
	public  Goods findTheGoods(Goods goods){
		
		int index =  getGoodsList().indexOf(goods);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Goods("+goods.getId()+") with version='"+goods.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGoodsList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsList(){
		getGoodsList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBuyer(), internalType);
		addToEntityList(this, entityList, getSeller(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getRetailStoreOrderLineItemList(), internalType);
		collectFromList(this, entityList, getRetailStoreOrderShippingGroupList(), internalType);
		collectFromList(this, entityList, getRetailStoreOrderPaymentGroupList(), internalType);
		collectFromList(this, entityList, getGoodsList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getRetailStoreOrderLineItemList());
		listOfList.add( getRetailStoreOrderShippingGroupList());
		listOfList.add( getRetailStoreOrderPaymentGroupList());
		listOfList.add( getGoodsList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, BUYER_PROPERTY, getBuyer());
		appendKeyValuePair(result, SELLER_PROPERTY, getSeller());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, TOTAL_AMOUNT_PROPERTY, getTotalAmount());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, RETAIL_STORE_ORDER_LINE_ITEM_LIST, getRetailStoreOrderLineItemList());
		if(!getRetailStoreOrderLineItemList().isEmpty()){
			appendKeyValuePair(result, "retailStoreOrderLineItemCount", getRetailStoreOrderLineItemList().getTotalCount());
			appendKeyValuePair(result, "retailStoreOrderLineItemCurrentPageNumber", getRetailStoreOrderLineItemList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST, getRetailStoreOrderShippingGroupList());
		if(!getRetailStoreOrderShippingGroupList().isEmpty()){
			appendKeyValuePair(result, "retailStoreOrderShippingGroupCount", getRetailStoreOrderShippingGroupList().getTotalCount());
			appendKeyValuePair(result, "retailStoreOrderShippingGroupCurrentPageNumber", getRetailStoreOrderShippingGroupList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST, getRetailStoreOrderPaymentGroupList());
		if(!getRetailStoreOrderPaymentGroupList().isEmpty()){
			appendKeyValuePair(result, "retailStoreOrderPaymentGroupCount", getRetailStoreOrderPaymentGroupList().getTotalCount());
			appendKeyValuePair(result, "retailStoreOrderPaymentGroupCurrentPageNumber", getRetailStoreOrderPaymentGroupList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, GOODS_LIST, getGoodsList());
		if(!getGoodsList().isEmpty()){
			appendKeyValuePair(result, "goodsCount", getGoodsList().getTotalCount());
			appendKeyValuePair(result, "goodsCurrentPageNumber", getGoodsList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreOrder){
		
		
			RetailStoreOrder dest =(RetailStoreOrder)baseDest;
		
			dest.setId(getId());
			dest.setBuyer(getBuyer());
			dest.setSeller(getSeller());
			dest.setTitle(getTitle());
			dest.setTotalAmount(getTotalAmount());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setRetailStoreOrderLineItemList(getRetailStoreOrderLineItemList());
			dest.setRetailStoreOrderShippingGroupList(getRetailStoreOrderShippingGroupList());
			dest.setRetailStoreOrderPaymentGroupList(getRetailStoreOrderPaymentGroupList());
			dest.setGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreOrder){
		
			
			RetailStoreOrder dest =(RetailStoreOrder)baseDest;
		
			dest.mergeId(getId());
			dest.mergeBuyer(getBuyer());
			dest.mergeSeller(getSeller());
			dest.mergeTitle(getTitle());
			dest.mergeTotalAmount(getTotalAmount());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeRetailStoreOrderLineItemList(getRetailStoreOrderLineItemList());
			dest.mergeRetailStoreOrderShippingGroupList(getRetailStoreOrderShippingGroupList());
			dest.mergeRetailStoreOrderPaymentGroupList(getRetailStoreOrderPaymentGroupList());
			dest.mergeGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof RetailStoreOrder){
		
			
			RetailStoreOrder dest =(RetailStoreOrder)baseDest;
		
			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeTotalAmount(getTotalAmount());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getBuyer(), getSeller(), getTitle(), getTotalAmount(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreOrder{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBuyer() != null ){
 			stringBuilder.append("\tbuyer='RetailStore("+getBuyer().getId()+")';");
 		}
		if(getSeller() != null ){
 			stringBuilder.append("\tseller='RetailStoreCountryCenter("+getSeller().getId()+")';");
 		}
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		stringBuilder.append("\ttotalAmount='"+getTotalAmount()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

