
package com.doublechaintech.retailscm.supplyorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.supplyorderpaymentgroup.SupplyOrderPaymentGroup;
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.supplyorderlineitem.SupplyOrderLineItem;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.goodssupplier.GoodsSupplier;
import com.doublechaintech.retailscm.supplyordershippinggroup.SupplyOrderShippingGroup;









@JsonSerialize(using = SupplyOrderSerializer.class)
public class SupplyOrder extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String BUYER_PROPERTY                 = "buyer"             ;
	public static final String SELLER_PROPERTY                = "seller"            ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String TOTAL_AMOUNT_PROPERTY          = "totalAmount"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SUPPLY_ORDER_LINE_ITEM_LIST              = "supplyOrderLineItemList";
	public static final String SUPPLY_ORDER_SHIPPING_GROUP_LIST         = "supplyOrderShippingGroupList";
	public static final String SUPPLY_ORDER_PAYMENT_GROUP_LIST          = "supplyOrderPaymentGroupList";
	public static final String GOODS_LIST                               = "goodsList"         ;

	public static final String INTERNAL_TYPE="SupplyOrder";
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
	protected		RetailStoreCountryCenter	mBuyer              ;
	protected		GoodsSupplier       	mSeller             ;
	protected		String              	mTitle              ;
	protected		BigDecimal          	mTotalAmount        ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<SupplyOrderLineItem>	mSupplyOrderLineItemList;
	protected		SmartList<SupplyOrderShippingGroup>	mSupplyOrderShippingGroupList;
	protected		SmartList<SupplyOrderPaymentGroup>	mSupplyOrderPaymentGroupList;
	protected		SmartList<Goods>    	mGoodsList          ;

	
		
	public 	SupplyOrder(){
		// lazy load for all the properties
	}
	public 	static SupplyOrder withId(String id){
		SupplyOrder supplyOrder = new SupplyOrder();
		supplyOrder.setId(id);
		supplyOrder.setVersion(Integer.MAX_VALUE);
		return supplyOrder;
	}
	public 	static SupplyOrder refById(String id){
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
		if(SUPPLY_ORDER_LINE_ITEM_LIST.equals(property)){
			List<BaseEntity> list = getSupplyOrderLineItemList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SUPPLY_ORDER_SHIPPING_GROUP_LIST.equals(property)){
			List<BaseEntity> list = getSupplyOrderShippingGroupList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SUPPLY_ORDER_PAYMENT_GROUP_LIST.equals(property)){
			List<BaseEntity> list = getSupplyOrderPaymentGroupList().stream().map(item->item).collect(Collectors.toList());
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
	public SupplyOrder updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setBuyer(RetailStoreCountryCenter buyer){
		this.mBuyer = buyer;;
	}
	public RetailStoreCountryCenter getBuyer(){
		return this.mBuyer;
	}
	public SupplyOrder updateBuyer(RetailStoreCountryCenter buyer){
		this.mBuyer = buyer;;
		this.changed = true;
		return this;
	}
	public void mergeBuyer(RetailStoreCountryCenter buyer){
		if(buyer != null) { setBuyer(buyer);}
	}
	
	
	public void clearBuyer(){
		setBuyer ( null );
		this.changed = true;
	}
	
	public void setSeller(GoodsSupplier seller){
		this.mSeller = seller;;
	}
	public GoodsSupplier getSeller(){
		return this.mSeller;
	}
	public SupplyOrder updateSeller(GoodsSupplier seller){
		this.mSeller = seller;;
		this.changed = true;
		return this;
	}
	public void mergeSeller(GoodsSupplier seller){
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
	public SupplyOrder updateTitle(String title){
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
	public SupplyOrder updateTotalAmount(BigDecimal totalAmount){
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
	public SupplyOrder updateLastUpdateTime(DateTime lastUpdateTime){
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
	public SupplyOrder updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<SupplyOrderLineItem> getSupplyOrderLineItemList(){
		if(this.mSupplyOrderLineItemList == null){
			this.mSupplyOrderLineItemList = new SmartList<SupplyOrderLineItem>();
			this.mSupplyOrderLineItemList.setListInternalName (SUPPLY_ORDER_LINE_ITEM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSupplyOrderLineItemList;	
	}
	public  void setSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList){
		for( SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList){
			supplyOrderLineItem.setBizOrder(this);
		}

		this.mSupplyOrderLineItemList = supplyOrderLineItemList;
		this.mSupplyOrderLineItemList.setListInternalName (SUPPLY_ORDER_LINE_ITEM_LIST );
		
	}
	
	public  void addSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
		supplyOrderLineItem.setBizOrder(this);
		getSupplyOrderLineItemList().add(supplyOrderLineItem);
	}
	public  void addSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList){
		for( SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList){
			supplyOrderLineItem.setBizOrder(this);
		}
		getSupplyOrderLineItemList().addAll(supplyOrderLineItemList);
	}
	public  void mergeSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList){
		if(supplyOrderLineItemList==null){
			return;
		}
		if(supplyOrderLineItemList.isEmpty()){
			return;
		}
		addSupplyOrderLineItemList( supplyOrderLineItemList );
		
	}
	public  SupplyOrderLineItem removeSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItemIndex){
		
		int index = getSupplyOrderLineItemList().indexOf(supplyOrderLineItemIndex);
        if(index < 0){
        	String message = "SupplyOrderLineItem("+supplyOrderLineItemIndex.getId()+") with version='"+supplyOrderLineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplyOrderLineItem supplyOrderLineItem = getSupplyOrderLineItemList().get(index);        
        // supplyOrderLineItem.clearBizOrder(); //disconnect with BizOrder
        supplyOrderLineItem.clearFromAll(); //disconnect with BizOrder
		
		boolean result = getSupplyOrderLineItemList().planToRemove(supplyOrderLineItem);
        if(!result){
        	String message = "SupplyOrderLineItem("+supplyOrderLineItemIndex.getId()+") with version='"+supplyOrderLineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplyOrderLineItem;
        
	
	}
	//断舍离
	public  void breakWithSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
		
		if(supplyOrderLineItem == null){
			return;
		}
		supplyOrderLineItem.setBizOrder(null);
		//getSupplyOrderLineItemList().remove();
	
	}
	
	public  boolean hasSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
	
		return getSupplyOrderLineItemList().contains(supplyOrderLineItem);
  
	}
	
	public void copySupplyOrderLineItemFrom(SupplyOrderLineItem supplyOrderLineItem) {

		SupplyOrderLineItem supplyOrderLineItemInList = findTheSupplyOrderLineItem(supplyOrderLineItem);
		SupplyOrderLineItem newSupplyOrderLineItem = new SupplyOrderLineItem();
		supplyOrderLineItemInList.copyTo(newSupplyOrderLineItem);
		newSupplyOrderLineItem.setVersion(0);//will trigger copy
		getSupplyOrderLineItemList().add(newSupplyOrderLineItem);
		addItemToFlexiableObject(COPIED_CHILD, newSupplyOrderLineItem);
	}
	
	public  SupplyOrderLineItem findTheSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
		
		int index =  getSupplyOrderLineItemList().indexOf(supplyOrderLineItem);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplyOrderLineItem("+supplyOrderLineItem.getId()+") with version='"+supplyOrderLineItem.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSupplyOrderLineItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderLineItemList(){
		getSupplyOrderLineItemList().clear();
	}
	
	
	


	public  SmartList<SupplyOrderShippingGroup> getSupplyOrderShippingGroupList(){
		if(this.mSupplyOrderShippingGroupList == null){
			this.mSupplyOrderShippingGroupList = new SmartList<SupplyOrderShippingGroup>();
			this.mSupplyOrderShippingGroupList.setListInternalName (SUPPLY_ORDER_SHIPPING_GROUP_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSupplyOrderShippingGroupList;	
	}
	public  void setSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		for( SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			supplyOrderShippingGroup.setBizOrder(this);
		}

		this.mSupplyOrderShippingGroupList = supplyOrderShippingGroupList;
		this.mSupplyOrderShippingGroupList.setListInternalName (SUPPLY_ORDER_SHIPPING_GROUP_LIST );
		
	}
	
	public  void addSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
		supplyOrderShippingGroup.setBizOrder(this);
		getSupplyOrderShippingGroupList().add(supplyOrderShippingGroup);
	}
	public  void addSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		for( SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			supplyOrderShippingGroup.setBizOrder(this);
		}
		getSupplyOrderShippingGroupList().addAll(supplyOrderShippingGroupList);
	}
	public  void mergeSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		if(supplyOrderShippingGroupList==null){
			return;
		}
		if(supplyOrderShippingGroupList.isEmpty()){
			return;
		}
		addSupplyOrderShippingGroupList( supplyOrderShippingGroupList );
		
	}
	public  SupplyOrderShippingGroup removeSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroupIndex){
		
		int index = getSupplyOrderShippingGroupList().indexOf(supplyOrderShippingGroupIndex);
        if(index < 0){
        	String message = "SupplyOrderShippingGroup("+supplyOrderShippingGroupIndex.getId()+") with version='"+supplyOrderShippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplyOrderShippingGroup supplyOrderShippingGroup = getSupplyOrderShippingGroupList().get(index);        
        // supplyOrderShippingGroup.clearBizOrder(); //disconnect with BizOrder
        supplyOrderShippingGroup.clearFromAll(); //disconnect with BizOrder
		
		boolean result = getSupplyOrderShippingGroupList().planToRemove(supplyOrderShippingGroup);
        if(!result){
        	String message = "SupplyOrderShippingGroup("+supplyOrderShippingGroupIndex.getId()+") with version='"+supplyOrderShippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplyOrderShippingGroup;
        
	
	}
	//断舍离
	public  void breakWithSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
		
		if(supplyOrderShippingGroup == null){
			return;
		}
		supplyOrderShippingGroup.setBizOrder(null);
		//getSupplyOrderShippingGroupList().remove();
	
	}
	
	public  boolean hasSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
	
		return getSupplyOrderShippingGroupList().contains(supplyOrderShippingGroup);
  
	}
	
	public void copySupplyOrderShippingGroupFrom(SupplyOrderShippingGroup supplyOrderShippingGroup) {

		SupplyOrderShippingGroup supplyOrderShippingGroupInList = findTheSupplyOrderShippingGroup(supplyOrderShippingGroup);
		SupplyOrderShippingGroup newSupplyOrderShippingGroup = new SupplyOrderShippingGroup();
		supplyOrderShippingGroupInList.copyTo(newSupplyOrderShippingGroup);
		newSupplyOrderShippingGroup.setVersion(0);//will trigger copy
		getSupplyOrderShippingGroupList().add(newSupplyOrderShippingGroup);
		addItemToFlexiableObject(COPIED_CHILD, newSupplyOrderShippingGroup);
	}
	
	public  SupplyOrderShippingGroup findTheSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
		
		int index =  getSupplyOrderShippingGroupList().indexOf(supplyOrderShippingGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplyOrderShippingGroup("+supplyOrderShippingGroup.getId()+") with version='"+supplyOrderShippingGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSupplyOrderShippingGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderShippingGroupList(){
		getSupplyOrderShippingGroupList().clear();
	}
	
	
	


	public  SmartList<SupplyOrderPaymentGroup> getSupplyOrderPaymentGroupList(){
		if(this.mSupplyOrderPaymentGroupList == null){
			this.mSupplyOrderPaymentGroupList = new SmartList<SupplyOrderPaymentGroup>();
			this.mSupplyOrderPaymentGroupList.setListInternalName (SUPPLY_ORDER_PAYMENT_GROUP_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mSupplyOrderPaymentGroupList;	
	}
	public  void setSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		for( SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			supplyOrderPaymentGroup.setBizOrder(this);
		}

		this.mSupplyOrderPaymentGroupList = supplyOrderPaymentGroupList;
		this.mSupplyOrderPaymentGroupList.setListInternalName (SUPPLY_ORDER_PAYMENT_GROUP_LIST );
		
	}
	
	public  void addSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		supplyOrderPaymentGroup.setBizOrder(this);
		getSupplyOrderPaymentGroupList().add(supplyOrderPaymentGroup);
	}
	public  void addSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		for( SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			supplyOrderPaymentGroup.setBizOrder(this);
		}
		getSupplyOrderPaymentGroupList().addAll(supplyOrderPaymentGroupList);
	}
	public  void mergeSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		if(supplyOrderPaymentGroupList==null){
			return;
		}
		if(supplyOrderPaymentGroupList.isEmpty()){
			return;
		}
		addSupplyOrderPaymentGroupList( supplyOrderPaymentGroupList );
		
	}
	public  SupplyOrderPaymentGroup removeSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroupIndex){
		
		int index = getSupplyOrderPaymentGroupList().indexOf(supplyOrderPaymentGroupIndex);
        if(index < 0){
        	String message = "SupplyOrderPaymentGroup("+supplyOrderPaymentGroupIndex.getId()+") with version='"+supplyOrderPaymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplyOrderPaymentGroup supplyOrderPaymentGroup = getSupplyOrderPaymentGroupList().get(index);        
        // supplyOrderPaymentGroup.clearBizOrder(); //disconnect with BizOrder
        supplyOrderPaymentGroup.clearFromAll(); //disconnect with BizOrder
		
		boolean result = getSupplyOrderPaymentGroupList().planToRemove(supplyOrderPaymentGroup);
        if(!result){
        	String message = "SupplyOrderPaymentGroup("+supplyOrderPaymentGroupIndex.getId()+") with version='"+supplyOrderPaymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplyOrderPaymentGroup;
        
	
	}
	//断舍离
	public  void breakWithSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		
		if(supplyOrderPaymentGroup == null){
			return;
		}
		supplyOrderPaymentGroup.setBizOrder(null);
		//getSupplyOrderPaymentGroupList().remove();
	
	}
	
	public  boolean hasSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
	
		return getSupplyOrderPaymentGroupList().contains(supplyOrderPaymentGroup);
  
	}
	
	public void copySupplyOrderPaymentGroupFrom(SupplyOrderPaymentGroup supplyOrderPaymentGroup) {

		SupplyOrderPaymentGroup supplyOrderPaymentGroupInList = findTheSupplyOrderPaymentGroup(supplyOrderPaymentGroup);
		SupplyOrderPaymentGroup newSupplyOrderPaymentGroup = new SupplyOrderPaymentGroup();
		supplyOrderPaymentGroupInList.copyTo(newSupplyOrderPaymentGroup);
		newSupplyOrderPaymentGroup.setVersion(0);//will trigger copy
		getSupplyOrderPaymentGroupList().add(newSupplyOrderPaymentGroup);
		addItemToFlexiableObject(COPIED_CHILD, newSupplyOrderPaymentGroup);
	}
	
	public  SupplyOrderPaymentGroup findTheSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		
		int index =  getSupplyOrderPaymentGroupList().indexOf(supplyOrderPaymentGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplyOrderPaymentGroup("+supplyOrderPaymentGroup.getId()+") with version='"+supplyOrderPaymentGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getSupplyOrderPaymentGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpSupplyOrderPaymentGroupList(){
		getSupplyOrderPaymentGroupList().clear();
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
			goods.setBizOrder(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setBizOrder(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setBizOrder(this);
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
        // goods.clearBizOrder(); //disconnect with BizOrder
        goods.clearFromAll(); //disconnect with BizOrder
		
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
		goods.setBizOrder(null);
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
		collectFromList(this, entityList, getSupplyOrderLineItemList(), internalType);
		collectFromList(this, entityList, getSupplyOrderShippingGroupList(), internalType);
		collectFromList(this, entityList, getSupplyOrderPaymentGroupList(), internalType);
		collectFromList(this, entityList, getGoodsList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getSupplyOrderLineItemList());
		listOfList.add( getSupplyOrderShippingGroupList());
		listOfList.add( getSupplyOrderPaymentGroupList());
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
		appendKeyValuePair(result, SUPPLY_ORDER_LINE_ITEM_LIST, getSupplyOrderLineItemList());
		if(!getSupplyOrderLineItemList().isEmpty()){
			appendKeyValuePair(result, "supplyOrderLineItemCount", getSupplyOrderLineItemList().getTotalCount());
			appendKeyValuePair(result, "supplyOrderLineItemCurrentPageNumber", getSupplyOrderLineItemList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SUPPLY_ORDER_SHIPPING_GROUP_LIST, getSupplyOrderShippingGroupList());
		if(!getSupplyOrderShippingGroupList().isEmpty()){
			appendKeyValuePair(result, "supplyOrderShippingGroupCount", getSupplyOrderShippingGroupList().getTotalCount());
			appendKeyValuePair(result, "supplyOrderShippingGroupCurrentPageNumber", getSupplyOrderShippingGroupList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SUPPLY_ORDER_PAYMENT_GROUP_LIST, getSupplyOrderPaymentGroupList());
		if(!getSupplyOrderPaymentGroupList().isEmpty()){
			appendKeyValuePair(result, "supplyOrderPaymentGroupCount", getSupplyOrderPaymentGroupList().getTotalCount());
			appendKeyValuePair(result, "supplyOrderPaymentGroupCurrentPageNumber", getSupplyOrderPaymentGroupList().getCurrentPageNumber());
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
		
		
		if(baseDest instanceof SupplyOrder){
		
		
			SupplyOrder dest =(SupplyOrder)baseDest;
		
			dest.setId(getId());
			dest.setBuyer(getBuyer());
			dest.setSeller(getSeller());
			dest.setTitle(getTitle());
			dest.setTotalAmount(getTotalAmount());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setSupplyOrderLineItemList(getSupplyOrderLineItemList());
			dest.setSupplyOrderShippingGroupList(getSupplyOrderShippingGroupList());
			dest.setSupplyOrderPaymentGroupList(getSupplyOrderPaymentGroupList());
			dest.setGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplyOrder){
		
			
			SupplyOrder dest =(SupplyOrder)baseDest;
		
			dest.mergeId(getId());
			dest.mergeBuyer(getBuyer());
			dest.mergeSeller(getSeller());
			dest.mergeTitle(getTitle());
			dest.mergeTotalAmount(getTotalAmount());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeSupplyOrderLineItemList(getSupplyOrderLineItemList());
			dest.mergeSupplyOrderShippingGroupList(getSupplyOrderShippingGroupList());
			dest.mergeSupplyOrderPaymentGroupList(getSupplyOrderPaymentGroupList());
			dest.mergeGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplyOrder){
		
			
			SupplyOrder dest =(SupplyOrder)baseDest;
		
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

		stringBuilder.append("SupplyOrder{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getBuyer() != null ){
 			stringBuilder.append("\tbuyer='RetailStoreCountryCenter("+getBuyer().getId()+")';");
 		}
		if(getSeller() != null ){
 			stringBuilder.append("\tseller='GoodsSupplier("+getSeller().getId()+")';");
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

