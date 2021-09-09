
package com.doublechaintech.retailscm.retailstoreorder;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BUYER_PROPERTY, "retail_store", "买方")
        .withType("retail_store", RetailStore.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SELLER_PROPERTY, "retail_store_country_center", "卖方")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TOTAL_AMOUNT_PROPERTY, "total_amount", "总金额")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(RETAIL_STORE_ORDER_LINE_ITEM_LIST, "bizOrder", "零售门店订单行项目列表")
        .withType("retail_store_order_line_item", RetailStoreOrderLineItem.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST, "bizOrder", "零售门店订单发货组列表")
        .withType("retail_store_order_shipping_group", RetailStoreOrderShippingGroup.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST, "bizOrder", "零售门店订单支付组列表")
        .withType("retail_store_order_payment_group", RetailStoreOrderPaymentGroup.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(GOODS_LIST, "retailStoreOrder", "商品列表")
        .withType("goods", Goods.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,BUYER_PROPERTY ,SELLER_PROPERTY ,TITLE_PROPERTY ,TOTAL_AMOUNT_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(RETAIL_STORE_ORDER_LINE_ITEM_LIST, "bizOrder");
    	
    	    refers.put(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST, "bizOrder");
    	
    	    refers.put(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST, "bizOrder");
    	
    	    refers.put(GOODS_LIST, "retailStoreOrder");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(RETAIL_STORE_ORDER_LINE_ITEM_LIST, RetailStoreOrderLineItem.class);
        	
        	    refers.put(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST, RetailStoreOrderShippingGroup.class);
        	
        	    refers.put(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST, RetailStoreOrderPaymentGroup.class);
        	
        	    refers.put(GOODS_LIST, Goods.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BUYER_PROPERTY, RetailStore.class);
parents.put(SELLER_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public RetailStoreOrder want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreOrder wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		RetailStore         	buyer               ;
	protected		RetailStoreCountryCenter	seller              ;
	protected		String              	title               ;
	protected		BigDecimal          	totalAmount         ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
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
		retailStoreOrder.setChecked(true);
		return retailStoreOrder;
	}
	public 	static RetailStoreOrder refById(String id){
		return withId(id);
	}

  public RetailStoreOrder limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreOrder limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreOrder searchExample(){
    RetailStoreOrder retailStoreOrder = new RetailStoreOrder();
    		retailStoreOrder.setVersion(UNSET_INT);

    return retailStoreOrder;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBuyer( null );
		setSeller( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public RetailStoreOrder updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrder orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public RetailStoreOrder ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public RetailStoreOrder addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setBuyer(RetailStore buyer){RetailStore oldBuyer = this.buyer;RetailStore newBuyer = buyer;this.buyer = newBuyer;}
	public RetailStore buyer(){
doLoad();
return getBuyer();
}
	public RetailStore getBuyer(){
		return this.buyer;
	}
	public RetailStoreOrder updateBuyer(RetailStore buyer){RetailStore oldBuyer = this.buyer;RetailStore newBuyer = buyer;if(!shouldReplaceBy(newBuyer, oldBuyer)){return this;}this.buyer = newBuyer;addPropertyChange(BUYER_PROPERTY, oldBuyer, newBuyer);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrder orderByBuyer(boolean asc){
doAddOrderBy(BUYER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBuyerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BUYER_PROPERTY, operator, parameters);
}
	public RetailStoreOrder ignoreBuyerCriteria(){super.ignoreSearchProperty(BUYER_PROPERTY);
return this;
}
	public RetailStoreOrder addBuyerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBuyerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBuyer(RetailStore buyer){
		if(buyer != null) { setBuyer(buyer);}
	}

	
	public void clearBuyer(){
		setBuyer ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setSeller(RetailStoreCountryCenter seller){RetailStoreCountryCenter oldSeller = this.seller;RetailStoreCountryCenter newSeller = seller;this.seller = newSeller;}
	public RetailStoreCountryCenter seller(){
doLoad();
return getSeller();
}
	public RetailStoreCountryCenter getSeller(){
		return this.seller;
	}
	public RetailStoreOrder updateSeller(RetailStoreCountryCenter seller){RetailStoreCountryCenter oldSeller = this.seller;RetailStoreCountryCenter newSeller = seller;if(!shouldReplaceBy(newSeller, oldSeller)){return this;}this.seller = newSeller;addPropertyChange(SELLER_PROPERTY, oldSeller, newSeller);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrder orderBySeller(boolean asc){
doAddOrderBy(SELLER_PROPERTY, asc);
return this;
}
	public SearchCriteria createSellerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SELLER_PROPERTY, operator, parameters);
}
	public RetailStoreOrder ignoreSellerCriteria(){super.ignoreSearchProperty(SELLER_PROPERTY);
return this;
}
	public RetailStoreOrder addSellerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSellerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSeller(RetailStoreCountryCenter seller){
		if(seller != null) { setSeller(seller);}
	}

	
	public void clearSeller(){
		setSeller ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);this.title = newTitle;}
	public String title(){
doLoad();
return getTitle();
}
	public String getTitle(){
		return this.title;
	}
	public RetailStoreOrder updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrder orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public RetailStoreOrder ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public RetailStoreOrder addTitleCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTitleCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}

	
	public void setTotalAmount(BigDecimal totalAmount){BigDecimal oldTotalAmount = this.totalAmount;BigDecimal newTotalAmount = totalAmount;this.totalAmount = newTotalAmount;}
	public BigDecimal totalAmount(){
doLoad();
return getTotalAmount();
}
	public BigDecimal getTotalAmount(){
		return this.totalAmount;
	}
	public RetailStoreOrder updateTotalAmount(BigDecimal totalAmount){BigDecimal oldTotalAmount = this.totalAmount;BigDecimal newTotalAmount = totalAmount;if(!shouldReplaceBy(newTotalAmount, oldTotalAmount)){return this;}this.totalAmount = newTotalAmount;addPropertyChange(TOTAL_AMOUNT_PROPERTY, oldTotalAmount, newTotalAmount);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrder orderByTotalAmount(boolean asc){
doAddOrderBy(TOTAL_AMOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createTotalAmountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TOTAL_AMOUNT_PROPERTY, operator, parameters);
}
	public RetailStoreOrder ignoreTotalAmountCriteria(){super.ignoreSearchProperty(TOTAL_AMOUNT_PROPERTY);
return this;
}
	public RetailStoreOrder addTotalAmountCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTotalAmountCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTotalAmount(BigDecimal totalAmount){
		setTotalAmount(totalAmount);
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public RetailStoreOrder updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrder orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public RetailStoreOrder ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public RetailStoreOrder addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLastUpdateTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLastUpdateTime(DateTime lastUpdateTime){
		setLastUpdateTime(lastUpdateTime);
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public RetailStoreOrder updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public RetailStoreOrder orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public RetailStoreOrder ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public RetailStoreOrder addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList(){
    
    doLoadChild(RETAIL_STORE_ORDER_LINE_ITEM_LIST);
    
    return getRetailStoreOrderLineItemList();
  }


	public  void setRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		for( RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			retailStoreOrderLineItem.setBizOrder(this);
		}

		this.mRetailStoreOrderLineItemList = retailStoreOrderLineItemList;
		this.mRetailStoreOrderLineItemList.setListInternalName (RETAIL_STORE_ORDER_LINE_ITEM_LIST );

	}

	public  RetailStoreOrder addRetailStoreOrderLineItem(RetailStoreOrderLineItem retailStoreOrderLineItem){
		retailStoreOrderLineItem.setBizOrder(this);
		getRetailStoreOrderLineItemList().add(retailStoreOrderLineItem);
		return this;
	}
	public  RetailStoreOrder addRetailStoreOrderLineItemList(SmartList<RetailStoreOrderLineItem> retailStoreOrderLineItemList){
		for( RetailStoreOrderLineItem retailStoreOrderLineItem:retailStoreOrderLineItemList){
			retailStoreOrderLineItem.setBizOrder(this);
		}
		getRetailStoreOrderLineItemList().addAll(retailStoreOrderLineItemList);
		return this;
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

  public  SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList(){
    
    doLoadChild(RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST);
    
    return getRetailStoreOrderShippingGroupList();
  }


	public  void setRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		for( RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList){
			retailStoreOrderShippingGroup.setBizOrder(this);
		}

		this.mRetailStoreOrderShippingGroupList = retailStoreOrderShippingGroupList;
		this.mRetailStoreOrderShippingGroupList.setListInternalName (RETAIL_STORE_ORDER_SHIPPING_GROUP_LIST );

	}

	public  RetailStoreOrder addRetailStoreOrderShippingGroup(RetailStoreOrderShippingGroup retailStoreOrderShippingGroup){
		retailStoreOrderShippingGroup.setBizOrder(this);
		getRetailStoreOrderShippingGroupList().add(retailStoreOrderShippingGroup);
		return this;
	}
	public  RetailStoreOrder addRetailStoreOrderShippingGroupList(SmartList<RetailStoreOrderShippingGroup> retailStoreOrderShippingGroupList){
		for( RetailStoreOrderShippingGroup retailStoreOrderShippingGroup:retailStoreOrderShippingGroupList){
			retailStoreOrderShippingGroup.setBizOrder(this);
		}
		getRetailStoreOrderShippingGroupList().addAll(retailStoreOrderShippingGroupList);
		return this;
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

  public  SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList(){
    
    doLoadChild(RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST);
    
    return getRetailStoreOrderPaymentGroupList();
  }


	public  void setRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		for( RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			retailStoreOrderPaymentGroup.setBizOrder(this);
		}

		this.mRetailStoreOrderPaymentGroupList = retailStoreOrderPaymentGroupList;
		this.mRetailStoreOrderPaymentGroupList.setListInternalName (RETAIL_STORE_ORDER_PAYMENT_GROUP_LIST );

	}

	public  RetailStoreOrder addRetailStoreOrderPaymentGroup(RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup){
		retailStoreOrderPaymentGroup.setBizOrder(this);
		getRetailStoreOrderPaymentGroupList().add(retailStoreOrderPaymentGroup);
		return this;
	}
	public  RetailStoreOrder addRetailStoreOrderPaymentGroupList(SmartList<RetailStoreOrderPaymentGroup> retailStoreOrderPaymentGroupList){
		for( RetailStoreOrderPaymentGroup retailStoreOrderPaymentGroup:retailStoreOrderPaymentGroupList){
			retailStoreOrderPaymentGroup.setBizOrder(this);
		}
		getRetailStoreOrderPaymentGroupList().addAll(retailStoreOrderPaymentGroupList);
		return this;
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

  public  SmartList<Goods> goodsList(){
    
    doLoadChild(GOODS_LIST);
    
    return getGoodsList();
  }


	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStoreOrder(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );

	}

	public  RetailStoreOrder addGoods(Goods goods){
		goods.setRetailStoreOrder(this);
		getGoodsList().add(goods);
		return this;
	}
	public  RetailStoreOrder addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setRetailStoreOrder(this);
		}
		getGoodsList().addAll(goodsList);
		return this;
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


	public static RetailStoreOrder createWith(RetailscmUserContext userContext, ThrowingFunction<RetailStoreOrder,RetailStoreOrder,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<RetailStoreOrder> customCreator = mapper.findCustomCreator(RetailStoreOrder.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    RetailStoreOrder result = new RetailStoreOrder();
    result.setBuyer(mapper.tryToGet(RetailStoreOrder.class, BUYER_PROPERTY, RetailStore.class,
        0, true, result.getBuyer(), params));
    result.setSeller(mapper.tryToGet(RetailStoreOrder.class, SELLER_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getSeller(), params));
    result.setTitle(mapper.tryToGet(RetailStoreOrder.class, TITLE_PROPERTY, String.class,
        0, true, result.getTitle(), params));
    result.setTotalAmount(mapper.tryToGet(RetailStoreOrder.class, TOTAL_AMOUNT_PROPERTY, BigDecimal.class,
        0, true, result.getTotalAmount(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixRetailStoreOrder(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      RetailStoreOrderTokens tokens = mapper.findParamByClass(params, RetailStoreOrderTokens.class);
      if (tokens == null) {
        tokens = RetailStoreOrderTokens.start();
      }
      result = userContext.getManagerGroup().getRetailStoreOrderManager().internalSaveRetailStoreOrder(userContext, result, tokens.done());
      
    }
    return result;
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

