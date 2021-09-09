
package com.doublechaintech.retailscm.supplyorder;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BUYER_PROPERTY, "retail_store_country_center", "买方")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SELLER_PROPERTY, "goods_supplier", "卖方")
        .withType("goods_supplier", GoodsSupplier.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TOTAL_AMOUNT_PROPERTY, "total_amount", "总金额")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SUPPLY_ORDER_LINE_ITEM_LIST, "bizOrder", "供应订单行项目列表")
        .withType("supply_order_line_item", SupplyOrderLineItem.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SUPPLY_ORDER_SHIPPING_GROUP_LIST, "bizOrder", "供货订单发货组列表")
        .withType("supply_order_shipping_group", SupplyOrderShippingGroup.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SUPPLY_ORDER_PAYMENT_GROUP_LIST, "bizOrder", "供货订单付款组列表")
        .withType("supply_order_payment_group", SupplyOrderPaymentGroup.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(GOODS_LIST, "bizOrder", "商品列表")
        .withType("goods", Goods.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,BUYER_PROPERTY ,SELLER_PROPERTY ,TITLE_PROPERTY ,TOTAL_AMOUNT_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(SUPPLY_ORDER_LINE_ITEM_LIST, "bizOrder");
    	
    	    refers.put(SUPPLY_ORDER_SHIPPING_GROUP_LIST, "bizOrder");
    	
    	    refers.put(SUPPLY_ORDER_PAYMENT_GROUP_LIST, "bizOrder");
    	
    	    refers.put(GOODS_LIST, "bizOrder");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(SUPPLY_ORDER_LINE_ITEM_LIST, SupplyOrderLineItem.class);
        	
        	    refers.put(SUPPLY_ORDER_SHIPPING_GROUP_LIST, SupplyOrderShippingGroup.class);
        	
        	    refers.put(SUPPLY_ORDER_PAYMENT_GROUP_LIST, SupplyOrderPaymentGroup.class);
        	
        	    refers.put(GOODS_LIST, Goods.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BUYER_PROPERTY, RetailStoreCountryCenter.class);
parents.put(SELLER_PROPERTY, GoodsSupplier.class);

    return parents;
  }

  public SupplyOrder want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SupplyOrder wants(Class<? extends BaseEntity>... classes) {
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
	protected		RetailStoreCountryCenter	buyer               ;
	protected		GoodsSupplier       	seller              ;
	protected		String              	title               ;
	protected		BigDecimal          	totalAmount         ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
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
		supplyOrder.setChecked(true);
		return supplyOrder;
	}
	public 	static SupplyOrder refById(String id){
		return withId(id);
	}

  public SupplyOrder limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public SupplyOrder limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static SupplyOrder searchExample(){
    SupplyOrder supplyOrder = new SupplyOrder();
    		supplyOrder.setVersion(UNSET_INT);

    return supplyOrder;
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public SupplyOrder updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public SupplyOrder orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public SupplyOrder ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public SupplyOrder addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setBuyer(RetailStoreCountryCenter buyer){RetailStoreCountryCenter oldBuyer = this.buyer;RetailStoreCountryCenter newBuyer = buyer;this.buyer = newBuyer;}
	public RetailStoreCountryCenter buyer(){
doLoad();
return getBuyer();
}
	public RetailStoreCountryCenter getBuyer(){
		return this.buyer;
	}
	public SupplyOrder updateBuyer(RetailStoreCountryCenter buyer){RetailStoreCountryCenter oldBuyer = this.buyer;RetailStoreCountryCenter newBuyer = buyer;if(!shouldReplaceBy(newBuyer, oldBuyer)){return this;}this.buyer = newBuyer;addPropertyChange(BUYER_PROPERTY, oldBuyer, newBuyer);this.changed = true;setChecked(false);return this;}
	public SupplyOrder orderByBuyer(boolean asc){
doAddOrderBy(BUYER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBuyerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BUYER_PROPERTY, operator, parameters);
}
	public SupplyOrder ignoreBuyerCriteria(){super.ignoreSearchProperty(BUYER_PROPERTY);
return this;
}
	public SupplyOrder addBuyerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBuyerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBuyer(RetailStoreCountryCenter buyer){
		if(buyer != null) { setBuyer(buyer);}
	}

	
	public void clearBuyer(){
		setBuyer ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setSeller(GoodsSupplier seller){GoodsSupplier oldSeller = this.seller;GoodsSupplier newSeller = seller;this.seller = newSeller;}
	public GoodsSupplier seller(){
doLoad();
return getSeller();
}
	public GoodsSupplier getSeller(){
		return this.seller;
	}
	public SupplyOrder updateSeller(GoodsSupplier seller){GoodsSupplier oldSeller = this.seller;GoodsSupplier newSeller = seller;if(!shouldReplaceBy(newSeller, oldSeller)){return this;}this.seller = newSeller;addPropertyChange(SELLER_PROPERTY, oldSeller, newSeller);this.changed = true;setChecked(false);return this;}
	public SupplyOrder orderBySeller(boolean asc){
doAddOrderBy(SELLER_PROPERTY, asc);
return this;
}
	public SearchCriteria createSellerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SELLER_PROPERTY, operator, parameters);
}
	public SupplyOrder ignoreSellerCriteria(){super.ignoreSearchProperty(SELLER_PROPERTY);
return this;
}
	public SupplyOrder addSellerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSellerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSeller(GoodsSupplier seller){
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
	public SupplyOrder updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public SupplyOrder orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public SupplyOrder ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public SupplyOrder addTitleCriteria(QueryOperator operator, Object... parameters){
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
	public SupplyOrder updateTotalAmount(BigDecimal totalAmount){BigDecimal oldTotalAmount = this.totalAmount;BigDecimal newTotalAmount = totalAmount;if(!shouldReplaceBy(newTotalAmount, oldTotalAmount)){return this;}this.totalAmount = newTotalAmount;addPropertyChange(TOTAL_AMOUNT_PROPERTY, oldTotalAmount, newTotalAmount);this.changed = true;setChecked(false);return this;}
	public SupplyOrder orderByTotalAmount(boolean asc){
doAddOrderBy(TOTAL_AMOUNT_PROPERTY, asc);
return this;
}
	public SearchCriteria createTotalAmountCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TOTAL_AMOUNT_PROPERTY, operator, parameters);
}
	public SupplyOrder ignoreTotalAmountCriteria(){super.ignoreSearchProperty(TOTAL_AMOUNT_PROPERTY);
return this;
}
	public SupplyOrder addTotalAmountCriteria(QueryOperator operator, Object... parameters){
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
	public SupplyOrder updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public SupplyOrder orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public SupplyOrder ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public SupplyOrder addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
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
	public SupplyOrder updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public SupplyOrder orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public SupplyOrder ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public SupplyOrder addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<SupplyOrderLineItem> supplyOrderLineItemList(){
    
    doLoadChild(SUPPLY_ORDER_LINE_ITEM_LIST);
    
    return getSupplyOrderLineItemList();
  }


	public  void setSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList){
		for( SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList){
			supplyOrderLineItem.setBizOrder(this);
		}

		this.mSupplyOrderLineItemList = supplyOrderLineItemList;
		this.mSupplyOrderLineItemList.setListInternalName (SUPPLY_ORDER_LINE_ITEM_LIST );

	}

	public  SupplyOrder addSupplyOrderLineItem(SupplyOrderLineItem supplyOrderLineItem){
		supplyOrderLineItem.setBizOrder(this);
		getSupplyOrderLineItemList().add(supplyOrderLineItem);
		return this;
	}
	public  SupplyOrder addSupplyOrderLineItemList(SmartList<SupplyOrderLineItem> supplyOrderLineItemList){
		for( SupplyOrderLineItem supplyOrderLineItem:supplyOrderLineItemList){
			supplyOrderLineItem.setBizOrder(this);
		}
		getSupplyOrderLineItemList().addAll(supplyOrderLineItemList);
		return this;
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

  public  SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList(){
    
    doLoadChild(SUPPLY_ORDER_SHIPPING_GROUP_LIST);
    
    return getSupplyOrderShippingGroupList();
  }


	public  void setSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		for( SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			supplyOrderShippingGroup.setBizOrder(this);
		}

		this.mSupplyOrderShippingGroupList = supplyOrderShippingGroupList;
		this.mSupplyOrderShippingGroupList.setListInternalName (SUPPLY_ORDER_SHIPPING_GROUP_LIST );

	}

	public  SupplyOrder addSupplyOrderShippingGroup(SupplyOrderShippingGroup supplyOrderShippingGroup){
		supplyOrderShippingGroup.setBizOrder(this);
		getSupplyOrderShippingGroupList().add(supplyOrderShippingGroup);
		return this;
	}
	public  SupplyOrder addSupplyOrderShippingGroupList(SmartList<SupplyOrderShippingGroup> supplyOrderShippingGroupList){
		for( SupplyOrderShippingGroup supplyOrderShippingGroup:supplyOrderShippingGroupList){
			supplyOrderShippingGroup.setBizOrder(this);
		}
		getSupplyOrderShippingGroupList().addAll(supplyOrderShippingGroupList);
		return this;
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

  public  SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList(){
    
    doLoadChild(SUPPLY_ORDER_PAYMENT_GROUP_LIST);
    
    return getSupplyOrderPaymentGroupList();
  }


	public  void setSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		for( SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			supplyOrderPaymentGroup.setBizOrder(this);
		}

		this.mSupplyOrderPaymentGroupList = supplyOrderPaymentGroupList;
		this.mSupplyOrderPaymentGroupList.setListInternalName (SUPPLY_ORDER_PAYMENT_GROUP_LIST );

	}

	public  SupplyOrder addSupplyOrderPaymentGroup(SupplyOrderPaymentGroup supplyOrderPaymentGroup){
		supplyOrderPaymentGroup.setBizOrder(this);
		getSupplyOrderPaymentGroupList().add(supplyOrderPaymentGroup);
		return this;
	}
	public  SupplyOrder addSupplyOrderPaymentGroupList(SmartList<SupplyOrderPaymentGroup> supplyOrderPaymentGroupList){
		for( SupplyOrderPaymentGroup supplyOrderPaymentGroup:supplyOrderPaymentGroupList){
			supplyOrderPaymentGroup.setBizOrder(this);
		}
		getSupplyOrderPaymentGroupList().addAll(supplyOrderPaymentGroupList);
		return this;
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

  public  SmartList<Goods> goodsList(){
    
    doLoadChild(GOODS_LIST);
    
    return getGoodsList();
  }


	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setBizOrder(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );

	}

	public  SupplyOrder addGoods(Goods goods){
		goods.setBizOrder(this);
		getGoodsList().add(goods);
		return this;
	}
	public  SupplyOrder addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setBizOrder(this);
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


	public static SupplyOrder createWith(RetailscmUserContext userContext, ThrowingFunction<SupplyOrder,SupplyOrder,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<SupplyOrder> customCreator = mapper.findCustomCreator(SupplyOrder.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    SupplyOrder result = new SupplyOrder();
    result.setBuyer(mapper.tryToGet(SupplyOrder.class, BUYER_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getBuyer(), params));
    result.setSeller(mapper.tryToGet(SupplyOrder.class, SELLER_PROPERTY, GoodsSupplier.class,
        0, true, result.getSeller(), params));
    result.setTitle(mapper.tryToGet(SupplyOrder.class, TITLE_PROPERTY, String.class,
        0, true, result.getTitle(), params));
    result.setTotalAmount(mapper.tryToGet(SupplyOrder.class, TOTAL_AMOUNT_PROPERTY, BigDecimal.class,
        0, true, result.getTotalAmount(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixSupplyOrder(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      SupplyOrderTokens tokens = mapper.findParamByClass(params, SupplyOrderTokens.class);
      if (tokens == null) {
        tokens = SupplyOrderTokens.start();
      }
      result = userContext.getManagerGroup().getSupplyOrderManager().internalSaveSupplyOrder(userContext, result, tokens.done());
      
    }
    return result;
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

