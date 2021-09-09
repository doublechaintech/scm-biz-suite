
package com.doublechaintech.retailscm.consumerorder;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;









@JsonSerialize(using = ConsumerOrderSerializer.class)
public class ConsumerOrder extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String CONSUMER_PROPERTY              = "consumer"          ;
	public static final String STORE_PROPERTY                 = "store"             ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String CONSUMER_ORDER_LINE_ITEM_LIST            = "consumerOrderLineItemList";
	public static final String CONSUMER_ORDER_SHIPPING_GROUP_LIST       = "consumerOrderShippingGroupList";
	public static final String CONSUMER_ORDER_PAYMENT_GROUP_LIST        = "consumerOrderPaymentGroupList";
	public static final String CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST     = "consumerOrderPriceAdjustmentList";
	public static final String RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST = "retailStoreMemberGiftCardConsumeRecordList";

	public static final String INTERNAL_TYPE="ConsumerOrder";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TITLE_PROPERTY, "title", "头衔")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CONSUMER_PROPERTY, "retail_store_member", "消费者")
        .withType("retail_store_member", RetailStoreMember.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(STORE_PROPERTY, "retail_store", "商场")
        .withType("retail_store", RetailStore.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(CONSUMER_ORDER_LINE_ITEM_LIST, "bizOrder", "消费者订单行项目列表")
        .withType("consumer_order_line_item", ConsumerOrderLineItem.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(CONSUMER_ORDER_SHIPPING_GROUP_LIST, "bizOrder", "消费者订单发货组列表")
        .withType("consumer_order_shipping_group", ConsumerOrderShippingGroup.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(CONSUMER_ORDER_PAYMENT_GROUP_LIST, "bizOrder", "消费者订单支付组列表")
        .withType("consumer_order_payment_group", ConsumerOrderPaymentGroup.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST, "bizOrder", "消费者订单价格调整表")
        .withType("consumer_order_price_adjustment", ConsumerOrderPriceAdjustment.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, "bizOrder", "零售会员礼品卡消费记录列表")
        .withType("retail_store_member_gift_card_consume_record", RetailStoreMemberGiftCardConsumeRecord.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,TITLE_PROPERTY ,CONSUMER_PROPERTY ,STORE_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(CONSUMER_ORDER_LINE_ITEM_LIST, "bizOrder");
    	
    	    refers.put(CONSUMER_ORDER_SHIPPING_GROUP_LIST, "bizOrder");
    	
    	    refers.put(CONSUMER_ORDER_PAYMENT_GROUP_LIST, "bizOrder");
    	
    	    refers.put(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST, "bizOrder");
    	
    	    refers.put(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, "bizOrder");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(CONSUMER_ORDER_LINE_ITEM_LIST, ConsumerOrderLineItem.class);
        	
        	    refers.put(CONSUMER_ORDER_SHIPPING_GROUP_LIST, ConsumerOrderShippingGroup.class);
        	
        	    refers.put(CONSUMER_ORDER_PAYMENT_GROUP_LIST, ConsumerOrderPaymentGroup.class);
        	
        	    refers.put(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST, ConsumerOrderPriceAdjustment.class);
        	
        	    refers.put(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, RetailStoreMemberGiftCardConsumeRecord.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(CONSUMER_PROPERTY, RetailStoreMember.class);
parents.put(STORE_PROPERTY, RetailStore.class);

    return parents;
  }

  public ConsumerOrder want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ConsumerOrder wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	title               ;
	protected		RetailStoreMember   	consumer            ;
	protected		RetailStore         	store               ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<ConsumerOrderLineItem>	mConsumerOrderLineItemList;
	protected		SmartList<ConsumerOrderShippingGroup>	mConsumerOrderShippingGroupList;
	protected		SmartList<ConsumerOrderPaymentGroup>	mConsumerOrderPaymentGroupList;
	protected		SmartList<ConsumerOrderPriceAdjustment>	mConsumerOrderPriceAdjustmentList;
	protected		SmartList<RetailStoreMemberGiftCardConsumeRecord>	mRetailStoreMemberGiftCardConsumeRecordList;



	public 	ConsumerOrder(){
		// lazy load for all the properties
	}
	public 	static ConsumerOrder withId(String id){
		ConsumerOrder consumerOrder = new ConsumerOrder();
		consumerOrder.setId(id);
		consumerOrder.setVersion(Integer.MAX_VALUE);
		consumerOrder.setChecked(true);
		return consumerOrder;
	}
	public 	static ConsumerOrder refById(String id){
		return withId(id);
	}

  public ConsumerOrder limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public ConsumerOrder limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static ConsumerOrder searchExample(){
    ConsumerOrder consumerOrder = new ConsumerOrder();
    		consumerOrder.setVersion(UNSET_INT);

    return consumerOrder;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setConsumer( null );
		setStore( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(TITLE_PROPERTY.equals(property)){
			changeTitleProperty(newValueExpr);
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

		if(TITLE_PROPERTY.equals(property)){
			return getTitle();
		}
		if(CONSUMER_PROPERTY.equals(property)){
			return getConsumer();
		}
		if(STORE_PROPERTY.equals(property)){
			return getStore();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(CONSUMER_ORDER_LINE_ITEM_LIST.equals(property)){
			List<BaseEntity> list = getConsumerOrderLineItemList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CONSUMER_ORDER_SHIPPING_GROUP_LIST.equals(property)){
			List<BaseEntity> list = getConsumerOrderShippingGroupList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CONSUMER_ORDER_PAYMENT_GROUP_LIST.equals(property)){
			List<BaseEntity> list = getConsumerOrderPaymentGroupList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST.equals(property)){
			List<BaseEntity> list = getConsumerOrderPriceAdjustmentList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreMemberGiftCardConsumeRecordList().stream().map(item->item).collect(Collectors.toList());
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
	public ConsumerOrder updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public ConsumerOrder orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public ConsumerOrder ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public ConsumerOrder addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);this.title = newTitle;}
	public String title(){
doLoad();
return getTitle();
}
	public String getTitle(){
		return this.title;
	}
	public ConsumerOrder updateTitle(String title){String oldTitle = this.title;String newTitle = trimString(title);if(!shouldReplaceBy(newTitle, oldTitle)){return this;}this.title = newTitle;addPropertyChange(TITLE_PROPERTY, oldTitle, newTitle);this.changed = true;setChecked(false);return this;}
	public ConsumerOrder orderByTitle(boolean asc){
doAddOrderBy(TITLE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTitleCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TITLE_PROPERTY, operator, parameters);
}
	public ConsumerOrder ignoreTitleCriteria(){super.ignoreSearchProperty(TITLE_PROPERTY);
return this;
}
	public ConsumerOrder addTitleCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTitleCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTitle(String title){
		if(title != null) { setTitle(title);}
	}

	
	public void setConsumer(RetailStoreMember consumer){RetailStoreMember oldConsumer = this.consumer;RetailStoreMember newConsumer = consumer;this.consumer = newConsumer;}
	public RetailStoreMember consumer(){
doLoad();
return getConsumer();
}
	public RetailStoreMember getConsumer(){
		return this.consumer;
	}
	public ConsumerOrder updateConsumer(RetailStoreMember consumer){RetailStoreMember oldConsumer = this.consumer;RetailStoreMember newConsumer = consumer;if(!shouldReplaceBy(newConsumer, oldConsumer)){return this;}this.consumer = newConsumer;addPropertyChange(CONSUMER_PROPERTY, oldConsumer, newConsumer);this.changed = true;setChecked(false);return this;}
	public ConsumerOrder orderByConsumer(boolean asc){
doAddOrderBy(CONSUMER_PROPERTY, asc);
return this;
}
	public SearchCriteria createConsumerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONSUMER_PROPERTY, operator, parameters);
}
	public ConsumerOrder ignoreConsumerCriteria(){super.ignoreSearchProperty(CONSUMER_PROPERTY);
return this;
}
	public ConsumerOrder addConsumerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createConsumerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeConsumer(RetailStoreMember consumer){
		if(consumer != null) { setConsumer(consumer);}
	}

	
	public void clearConsumer(){
		setConsumer ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setStore(RetailStore store){RetailStore oldStore = this.store;RetailStore newStore = store;this.store = newStore;}
	public RetailStore store(){
doLoad();
return getStore();
}
	public RetailStore getStore(){
		return this.store;
	}
	public ConsumerOrder updateStore(RetailStore store){RetailStore oldStore = this.store;RetailStore newStore = store;if(!shouldReplaceBy(newStore, oldStore)){return this;}this.store = newStore;addPropertyChange(STORE_PROPERTY, oldStore, newStore);this.changed = true;setChecked(false);return this;}
	public ConsumerOrder orderByStore(boolean asc){
doAddOrderBy(STORE_PROPERTY, asc);
return this;
}
	public SearchCriteria createStoreCriteria(QueryOperator operator, Object... parameters){
return createCriteria(STORE_PROPERTY, operator, parameters);
}
	public ConsumerOrder ignoreStoreCriteria(){super.ignoreSearchProperty(STORE_PROPERTY);
return this;
}
	public ConsumerOrder addStoreCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createStoreCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeStore(RetailStore store){
		if(store != null) { setStore(store);}
	}

	
	public void clearStore(){
		setStore ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public ConsumerOrder updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public ConsumerOrder orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public ConsumerOrder ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public ConsumerOrder addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
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
	public ConsumerOrder updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public ConsumerOrder orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public ConsumerOrder ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public ConsumerOrder addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<ConsumerOrderLineItem> getConsumerOrderLineItemList(){
		if(this.mConsumerOrderLineItemList == null){
			this.mConsumerOrderLineItemList = new SmartList<ConsumerOrderLineItem>();
			this.mConsumerOrderLineItemList.setListInternalName (CONSUMER_ORDER_LINE_ITEM_LIST );
			//有名字，便于做权限控制
		}

		return this.mConsumerOrderLineItemList;
	}

  public  SmartList<ConsumerOrderLineItem> consumerOrderLineItemList(){
    
    doLoadChild(CONSUMER_ORDER_LINE_ITEM_LIST);
    
    return getConsumerOrderLineItemList();
  }


	public  void setConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList){
		for( ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList){
			consumerOrderLineItem.setBizOrder(this);
		}

		this.mConsumerOrderLineItemList = consumerOrderLineItemList;
		this.mConsumerOrderLineItemList.setListInternalName (CONSUMER_ORDER_LINE_ITEM_LIST );

	}

	public  ConsumerOrder addConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){
		consumerOrderLineItem.setBizOrder(this);
		getConsumerOrderLineItemList().add(consumerOrderLineItem);
		return this;
	}
	public  ConsumerOrder addConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList){
		for( ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList){
			consumerOrderLineItem.setBizOrder(this);
		}
		getConsumerOrderLineItemList().addAll(consumerOrderLineItemList);
		return this;
	}
	public  void mergeConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList){
		if(consumerOrderLineItemList==null){
			return;
		}
		if(consumerOrderLineItemList.isEmpty()){
			return;
		}
		addConsumerOrderLineItemList( consumerOrderLineItemList );

	}
	public  ConsumerOrderLineItem removeConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItemIndex){

		int index = getConsumerOrderLineItemList().indexOf(consumerOrderLineItemIndex);
        if(index < 0){
        	String message = "ConsumerOrderLineItem("+consumerOrderLineItemIndex.getId()+") with version='"+consumerOrderLineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ConsumerOrderLineItem consumerOrderLineItem = getConsumerOrderLineItemList().get(index);
        // consumerOrderLineItem.clearBizOrder(); //disconnect with BizOrder
        consumerOrderLineItem.clearFromAll(); //disconnect with BizOrder

		boolean result = getConsumerOrderLineItemList().planToRemove(consumerOrderLineItem);
        if(!result){
        	String message = "ConsumerOrderLineItem("+consumerOrderLineItemIndex.getId()+") with version='"+consumerOrderLineItemIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return consumerOrderLineItem;


	}
	//断舍离
	public  void breakWithConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){

		if(consumerOrderLineItem == null){
			return;
		}
		consumerOrderLineItem.setBizOrder(null);
		//getConsumerOrderLineItemList().remove();

	}

	public  boolean hasConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){

		return getConsumerOrderLineItemList().contains(consumerOrderLineItem);

	}

	public void copyConsumerOrderLineItemFrom(ConsumerOrderLineItem consumerOrderLineItem) {

		ConsumerOrderLineItem consumerOrderLineItemInList = findTheConsumerOrderLineItem(consumerOrderLineItem);
		ConsumerOrderLineItem newConsumerOrderLineItem = new ConsumerOrderLineItem();
		consumerOrderLineItemInList.copyTo(newConsumerOrderLineItem);
		newConsumerOrderLineItem.setVersion(0);//will trigger copy
		getConsumerOrderLineItemList().add(newConsumerOrderLineItem);
		addItemToFlexiableObject(COPIED_CHILD, newConsumerOrderLineItem);
	}

	public  ConsumerOrderLineItem findTheConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){

		int index =  getConsumerOrderLineItemList().indexOf(consumerOrderLineItem);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ConsumerOrderLineItem("+consumerOrderLineItem.getId()+") with version='"+consumerOrderLineItem.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getConsumerOrderLineItemList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpConsumerOrderLineItemList(){
		getConsumerOrderLineItemList().clear();
	}





	public  SmartList<ConsumerOrderShippingGroup> getConsumerOrderShippingGroupList(){
		if(this.mConsumerOrderShippingGroupList == null){
			this.mConsumerOrderShippingGroupList = new SmartList<ConsumerOrderShippingGroup>();
			this.mConsumerOrderShippingGroupList.setListInternalName (CONSUMER_ORDER_SHIPPING_GROUP_LIST );
			//有名字，便于做权限控制
		}

		return this.mConsumerOrderShippingGroupList;
	}

  public  SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList(){
    
    doLoadChild(CONSUMER_ORDER_SHIPPING_GROUP_LIST);
    
    return getConsumerOrderShippingGroupList();
  }


	public  void setConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		for( ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			consumerOrderShippingGroup.setBizOrder(this);
		}

		this.mConsumerOrderShippingGroupList = consumerOrderShippingGroupList;
		this.mConsumerOrderShippingGroupList.setListInternalName (CONSUMER_ORDER_SHIPPING_GROUP_LIST );

	}

	public  ConsumerOrder addConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){
		consumerOrderShippingGroup.setBizOrder(this);
		getConsumerOrderShippingGroupList().add(consumerOrderShippingGroup);
		return this;
	}
	public  ConsumerOrder addConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		for( ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			consumerOrderShippingGroup.setBizOrder(this);
		}
		getConsumerOrderShippingGroupList().addAll(consumerOrderShippingGroupList);
		return this;
	}
	public  void mergeConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		if(consumerOrderShippingGroupList==null){
			return;
		}
		if(consumerOrderShippingGroupList.isEmpty()){
			return;
		}
		addConsumerOrderShippingGroupList( consumerOrderShippingGroupList );

	}
	public  ConsumerOrderShippingGroup removeConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroupIndex){

		int index = getConsumerOrderShippingGroupList().indexOf(consumerOrderShippingGroupIndex);
        if(index < 0){
        	String message = "ConsumerOrderShippingGroup("+consumerOrderShippingGroupIndex.getId()+") with version='"+consumerOrderShippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ConsumerOrderShippingGroup consumerOrderShippingGroup = getConsumerOrderShippingGroupList().get(index);
        // consumerOrderShippingGroup.clearBizOrder(); //disconnect with BizOrder
        consumerOrderShippingGroup.clearFromAll(); //disconnect with BizOrder

		boolean result = getConsumerOrderShippingGroupList().planToRemove(consumerOrderShippingGroup);
        if(!result){
        	String message = "ConsumerOrderShippingGroup("+consumerOrderShippingGroupIndex.getId()+") with version='"+consumerOrderShippingGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return consumerOrderShippingGroup;


	}
	//断舍离
	public  void breakWithConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){

		if(consumerOrderShippingGroup == null){
			return;
		}
		consumerOrderShippingGroup.setBizOrder(null);
		//getConsumerOrderShippingGroupList().remove();

	}

	public  boolean hasConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){

		return getConsumerOrderShippingGroupList().contains(consumerOrderShippingGroup);

	}

	public void copyConsumerOrderShippingGroupFrom(ConsumerOrderShippingGroup consumerOrderShippingGroup) {

		ConsumerOrderShippingGroup consumerOrderShippingGroupInList = findTheConsumerOrderShippingGroup(consumerOrderShippingGroup);
		ConsumerOrderShippingGroup newConsumerOrderShippingGroup = new ConsumerOrderShippingGroup();
		consumerOrderShippingGroupInList.copyTo(newConsumerOrderShippingGroup);
		newConsumerOrderShippingGroup.setVersion(0);//will trigger copy
		getConsumerOrderShippingGroupList().add(newConsumerOrderShippingGroup);
		addItemToFlexiableObject(COPIED_CHILD, newConsumerOrderShippingGroup);
	}

	public  ConsumerOrderShippingGroup findTheConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){

		int index =  getConsumerOrderShippingGroupList().indexOf(consumerOrderShippingGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ConsumerOrderShippingGroup("+consumerOrderShippingGroup.getId()+") with version='"+consumerOrderShippingGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getConsumerOrderShippingGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpConsumerOrderShippingGroupList(){
		getConsumerOrderShippingGroupList().clear();
	}





	public  SmartList<ConsumerOrderPaymentGroup> getConsumerOrderPaymentGroupList(){
		if(this.mConsumerOrderPaymentGroupList == null){
			this.mConsumerOrderPaymentGroupList = new SmartList<ConsumerOrderPaymentGroup>();
			this.mConsumerOrderPaymentGroupList.setListInternalName (CONSUMER_ORDER_PAYMENT_GROUP_LIST );
			//有名字，便于做权限控制
		}

		return this.mConsumerOrderPaymentGroupList;
	}

  public  SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList(){
    
    doLoadChild(CONSUMER_ORDER_PAYMENT_GROUP_LIST);
    
    return getConsumerOrderPaymentGroupList();
  }


	public  void setConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		for( ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList){
			consumerOrderPaymentGroup.setBizOrder(this);
		}

		this.mConsumerOrderPaymentGroupList = consumerOrderPaymentGroupList;
		this.mConsumerOrderPaymentGroupList.setListInternalName (CONSUMER_ORDER_PAYMENT_GROUP_LIST );

	}

	public  ConsumerOrder addConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
		consumerOrderPaymentGroup.setBizOrder(this);
		getConsumerOrderPaymentGroupList().add(consumerOrderPaymentGroup);
		return this;
	}
	public  ConsumerOrder addConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		for( ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList){
			consumerOrderPaymentGroup.setBizOrder(this);
		}
		getConsumerOrderPaymentGroupList().addAll(consumerOrderPaymentGroupList);
		return this;
	}
	public  void mergeConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		if(consumerOrderPaymentGroupList==null){
			return;
		}
		if(consumerOrderPaymentGroupList.isEmpty()){
			return;
		}
		addConsumerOrderPaymentGroupList( consumerOrderPaymentGroupList );

	}
	public  ConsumerOrderPaymentGroup removeConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroupIndex){

		int index = getConsumerOrderPaymentGroupList().indexOf(consumerOrderPaymentGroupIndex);
        if(index < 0){
        	String message = "ConsumerOrderPaymentGroup("+consumerOrderPaymentGroupIndex.getId()+") with version='"+consumerOrderPaymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ConsumerOrderPaymentGroup consumerOrderPaymentGroup = getConsumerOrderPaymentGroupList().get(index);
        // consumerOrderPaymentGroup.clearBizOrder(); //disconnect with BizOrder
        consumerOrderPaymentGroup.clearFromAll(); //disconnect with BizOrder

		boolean result = getConsumerOrderPaymentGroupList().planToRemove(consumerOrderPaymentGroup);
        if(!result){
        	String message = "ConsumerOrderPaymentGroup("+consumerOrderPaymentGroupIndex.getId()+") with version='"+consumerOrderPaymentGroupIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return consumerOrderPaymentGroup;


	}
	//断舍离
	public  void breakWithConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){

		if(consumerOrderPaymentGroup == null){
			return;
		}
		consumerOrderPaymentGroup.setBizOrder(null);
		//getConsumerOrderPaymentGroupList().remove();

	}

	public  boolean hasConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){

		return getConsumerOrderPaymentGroupList().contains(consumerOrderPaymentGroup);

	}

	public void copyConsumerOrderPaymentGroupFrom(ConsumerOrderPaymentGroup consumerOrderPaymentGroup) {

		ConsumerOrderPaymentGroup consumerOrderPaymentGroupInList = findTheConsumerOrderPaymentGroup(consumerOrderPaymentGroup);
		ConsumerOrderPaymentGroup newConsumerOrderPaymentGroup = new ConsumerOrderPaymentGroup();
		consumerOrderPaymentGroupInList.copyTo(newConsumerOrderPaymentGroup);
		newConsumerOrderPaymentGroup.setVersion(0);//will trigger copy
		getConsumerOrderPaymentGroupList().add(newConsumerOrderPaymentGroup);
		addItemToFlexiableObject(COPIED_CHILD, newConsumerOrderPaymentGroup);
	}

	public  ConsumerOrderPaymentGroup findTheConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){

		int index =  getConsumerOrderPaymentGroupList().indexOf(consumerOrderPaymentGroup);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ConsumerOrderPaymentGroup("+consumerOrderPaymentGroup.getId()+") with version='"+consumerOrderPaymentGroup.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getConsumerOrderPaymentGroupList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpConsumerOrderPaymentGroupList(){
		getConsumerOrderPaymentGroupList().clear();
	}





	public  SmartList<ConsumerOrderPriceAdjustment> getConsumerOrderPriceAdjustmentList(){
		if(this.mConsumerOrderPriceAdjustmentList == null){
			this.mConsumerOrderPriceAdjustmentList = new SmartList<ConsumerOrderPriceAdjustment>();
			this.mConsumerOrderPriceAdjustmentList.setListInternalName (CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST );
			//有名字，便于做权限控制
		}

		return this.mConsumerOrderPriceAdjustmentList;
	}

  public  SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList(){
    
    doLoadChild(CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST);
    
    return getConsumerOrderPriceAdjustmentList();
  }


	public  void setConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		for( ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			consumerOrderPriceAdjustment.setBizOrder(this);
		}

		this.mConsumerOrderPriceAdjustmentList = consumerOrderPriceAdjustmentList;
		this.mConsumerOrderPriceAdjustmentList.setListInternalName (CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST );

	}

	public  ConsumerOrder addConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
		consumerOrderPriceAdjustment.setBizOrder(this);
		getConsumerOrderPriceAdjustmentList().add(consumerOrderPriceAdjustment);
		return this;
	}
	public  ConsumerOrder addConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		for( ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			consumerOrderPriceAdjustment.setBizOrder(this);
		}
		getConsumerOrderPriceAdjustmentList().addAll(consumerOrderPriceAdjustmentList);
		return this;
	}
	public  void mergeConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		if(consumerOrderPriceAdjustmentList==null){
			return;
		}
		if(consumerOrderPriceAdjustmentList.isEmpty()){
			return;
		}
		addConsumerOrderPriceAdjustmentList( consumerOrderPriceAdjustmentList );

	}
	public  ConsumerOrderPriceAdjustment removeConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustmentIndex){

		int index = getConsumerOrderPriceAdjustmentList().indexOf(consumerOrderPriceAdjustmentIndex);
        if(index < 0){
        	String message = "ConsumerOrderPriceAdjustment("+consumerOrderPriceAdjustmentIndex.getId()+") with version='"+consumerOrderPriceAdjustmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment = getConsumerOrderPriceAdjustmentList().get(index);
        // consumerOrderPriceAdjustment.clearBizOrder(); //disconnect with BizOrder
        consumerOrderPriceAdjustment.clearFromAll(); //disconnect with BizOrder

		boolean result = getConsumerOrderPriceAdjustmentList().planToRemove(consumerOrderPriceAdjustment);
        if(!result){
        	String message = "ConsumerOrderPriceAdjustment("+consumerOrderPriceAdjustmentIndex.getId()+") with version='"+consumerOrderPriceAdjustmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return consumerOrderPriceAdjustment;


	}
	//断舍离
	public  void breakWithConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){

		if(consumerOrderPriceAdjustment == null){
			return;
		}
		consumerOrderPriceAdjustment.setBizOrder(null);
		//getConsumerOrderPriceAdjustmentList().remove();

	}

	public  boolean hasConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){

		return getConsumerOrderPriceAdjustmentList().contains(consumerOrderPriceAdjustment);

	}

	public void copyConsumerOrderPriceAdjustmentFrom(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment) {

		ConsumerOrderPriceAdjustment consumerOrderPriceAdjustmentInList = findTheConsumerOrderPriceAdjustment(consumerOrderPriceAdjustment);
		ConsumerOrderPriceAdjustment newConsumerOrderPriceAdjustment = new ConsumerOrderPriceAdjustment();
		consumerOrderPriceAdjustmentInList.copyTo(newConsumerOrderPriceAdjustment);
		newConsumerOrderPriceAdjustment.setVersion(0);//will trigger copy
		getConsumerOrderPriceAdjustmentList().add(newConsumerOrderPriceAdjustment);
		addItemToFlexiableObject(COPIED_CHILD, newConsumerOrderPriceAdjustment);
	}

	public  ConsumerOrderPriceAdjustment findTheConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){

		int index =  getConsumerOrderPriceAdjustmentList().indexOf(consumerOrderPriceAdjustment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ConsumerOrderPriceAdjustment("+consumerOrderPriceAdjustment.getId()+") with version='"+consumerOrderPriceAdjustment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getConsumerOrderPriceAdjustmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpConsumerOrderPriceAdjustmentList(){
		getConsumerOrderPriceAdjustmentList().clear();
	}





	public  SmartList<RetailStoreMemberGiftCardConsumeRecord> getRetailStoreMemberGiftCardConsumeRecordList(){
		if(this.mRetailStoreMemberGiftCardConsumeRecordList == null){
			this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();
			this.mRetailStoreMemberGiftCardConsumeRecordList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST );
			//有名字，便于做权限控制
		}

		return this.mRetailStoreMemberGiftCardConsumeRecordList;
	}

  public  SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList(){
    
    doLoadChild(RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST);
    
    return getRetailStoreMemberGiftCardConsumeRecordList();
  }


	public  void setRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		}

		this.mRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList;
		this.mRetailStoreMemberGiftCardConsumeRecordList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST );

	}

	public  ConsumerOrder addRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		getRetailStoreMemberGiftCardConsumeRecordList().add(retailStoreMemberGiftCardConsumeRecord);
		return this;
	}
	public  ConsumerOrder addRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		}
		getRetailStoreMemberGiftCardConsumeRecordList().addAll(retailStoreMemberGiftCardConsumeRecordList);
		return this;
	}
	public  void mergeRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		if(retailStoreMemberGiftCardConsumeRecordList==null){
			return;
		}
		if(retailStoreMemberGiftCardConsumeRecordList.isEmpty()){
			return;
		}
		addRetailStoreMemberGiftCardConsumeRecordList( retailStoreMemberGiftCardConsumeRecordList );

	}
	public  RetailStoreMemberGiftCardConsumeRecord removeRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordIndex){

		int index = getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecordIndex);
        if(index < 0){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecordIndex.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord = getRetailStoreMemberGiftCardConsumeRecordList().get(index);
        // retailStoreMemberGiftCardConsumeRecord.clearBizOrder(); //disconnect with BizOrder
        retailStoreMemberGiftCardConsumeRecord.clearFromAll(); //disconnect with BizOrder

		boolean result = getRetailStoreMemberGiftCardConsumeRecordList().planToRemove(retailStoreMemberGiftCardConsumeRecord);
        if(!result){
        	String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecordIndex.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecordIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreMemberGiftCardConsumeRecord;


	}
	//断舍离
	public  void breakWithRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){

		if(retailStoreMemberGiftCardConsumeRecord == null){
			return;
		}
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(null);
		//getRetailStoreMemberGiftCardConsumeRecordList().remove();

	}

	public  boolean hasRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){

		return getRetailStoreMemberGiftCardConsumeRecordList().contains(retailStoreMemberGiftCardConsumeRecord);

	}

	public void copyRetailStoreMemberGiftCardConsumeRecordFrom(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord) {

		RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecordInList = findTheRetailStoreMemberGiftCardConsumeRecord(retailStoreMemberGiftCardConsumeRecord);
		RetailStoreMemberGiftCardConsumeRecord newRetailStoreMemberGiftCardConsumeRecord = new RetailStoreMemberGiftCardConsumeRecord();
		retailStoreMemberGiftCardConsumeRecordInList.copyTo(newRetailStoreMemberGiftCardConsumeRecord);
		newRetailStoreMemberGiftCardConsumeRecord.setVersion(0);//will trigger copy
		getRetailStoreMemberGiftCardConsumeRecordList().add(newRetailStoreMemberGiftCardConsumeRecord);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreMemberGiftCardConsumeRecord);
	}

	public  RetailStoreMemberGiftCardConsumeRecord findTheRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){

		int index =  getRetailStoreMemberGiftCardConsumeRecordList().indexOf(retailStoreMemberGiftCardConsumeRecord);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreMemberGiftCardConsumeRecord("+retailStoreMemberGiftCardConsumeRecord.getId()+") with version='"+retailStoreMemberGiftCardConsumeRecord.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getRetailStoreMemberGiftCardConsumeRecordList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpRetailStoreMemberGiftCardConsumeRecordList(){
		getRetailStoreMemberGiftCardConsumeRecordList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getConsumer(), internalType);
		addToEntityList(this, entityList, getStore(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getConsumerOrderLineItemList(), internalType);
		collectFromList(this, entityList, getConsumerOrderShippingGroupList(), internalType);
		collectFromList(this, entityList, getConsumerOrderPaymentGroupList(), internalType);
		collectFromList(this, entityList, getConsumerOrderPriceAdjustmentList(), internalType);
		collectFromList(this, entityList, getRetailStoreMemberGiftCardConsumeRecordList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getConsumerOrderLineItemList());
		listOfList.add( getConsumerOrderShippingGroupList());
		listOfList.add( getConsumerOrderPaymentGroupList());
		listOfList.add( getConsumerOrderPriceAdjustmentList());
		listOfList.add( getRetailStoreMemberGiftCardConsumeRecordList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, TITLE_PROPERTY, getTitle());
		appendKeyValuePair(result, CONSUMER_PROPERTY, getConsumer());
		appendKeyValuePair(result, STORE_PROPERTY, getStore());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, CONSUMER_ORDER_LINE_ITEM_LIST, getConsumerOrderLineItemList());
		if(!getConsumerOrderLineItemList().isEmpty()){
			appendKeyValuePair(result, "consumerOrderLineItemCount", getConsumerOrderLineItemList().getTotalCount());
			appendKeyValuePair(result, "consumerOrderLineItemCurrentPageNumber", getConsumerOrderLineItemList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CONSUMER_ORDER_SHIPPING_GROUP_LIST, getConsumerOrderShippingGroupList());
		if(!getConsumerOrderShippingGroupList().isEmpty()){
			appendKeyValuePair(result, "consumerOrderShippingGroupCount", getConsumerOrderShippingGroupList().getTotalCount());
			appendKeyValuePair(result, "consumerOrderShippingGroupCurrentPageNumber", getConsumerOrderShippingGroupList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CONSUMER_ORDER_PAYMENT_GROUP_LIST, getConsumerOrderPaymentGroupList());
		if(!getConsumerOrderPaymentGroupList().isEmpty()){
			appendKeyValuePair(result, "consumerOrderPaymentGroupCount", getConsumerOrderPaymentGroupList().getTotalCount());
			appendKeyValuePair(result, "consumerOrderPaymentGroupCurrentPageNumber", getConsumerOrderPaymentGroupList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST, getConsumerOrderPriceAdjustmentList());
		if(!getConsumerOrderPriceAdjustmentList().isEmpty()){
			appendKeyValuePair(result, "consumerOrderPriceAdjustmentCount", getConsumerOrderPriceAdjustmentList().getTotalCount());
			appendKeyValuePair(result, "consumerOrderPriceAdjustmentCurrentPageNumber", getConsumerOrderPriceAdjustmentList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST, getRetailStoreMemberGiftCardConsumeRecordList());
		if(!getRetailStoreMemberGiftCardConsumeRecordList().isEmpty()){
			appendKeyValuePair(result, "retailStoreMemberGiftCardConsumeRecordCount", getRetailStoreMemberGiftCardConsumeRecordList().getTotalCount());
			appendKeyValuePair(result, "retailStoreMemberGiftCardConsumeRecordCurrentPageNumber", getRetailStoreMemberGiftCardConsumeRecordList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof ConsumerOrder){


			ConsumerOrder dest =(ConsumerOrder)baseDest;

			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setConsumer(getConsumer());
			dest.setStore(getStore());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setConsumerOrderLineItemList(getConsumerOrderLineItemList());
			dest.setConsumerOrderShippingGroupList(getConsumerOrderShippingGroupList());
			dest.setConsumerOrderPaymentGroupList(getConsumerOrderPaymentGroupList());
			dest.setConsumerOrderPriceAdjustmentList(getConsumerOrderPriceAdjustmentList());
			dest.setRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof ConsumerOrder){


			ConsumerOrder dest =(ConsumerOrder)baseDest;

			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeConsumer(getConsumer());
			dest.mergeStore(getStore());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeConsumerOrderLineItemList(getConsumerOrderLineItemList());
			dest.mergeConsumerOrderShippingGroupList(getConsumerOrderShippingGroupList());
			dest.mergeConsumerOrderPaymentGroupList(getConsumerOrderPaymentGroupList());
			dest.mergeConsumerOrderPriceAdjustmentList(getConsumerOrderPriceAdjustmentList());
			dest.mergeRetailStoreMemberGiftCardConsumeRecordList(getRetailStoreMemberGiftCardConsumeRecordList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof ConsumerOrder){


			ConsumerOrder dest =(ConsumerOrder)baseDest;

			dest.mergeId(getId());
			dest.mergeTitle(getTitle());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getTitle(), getConsumer(), getStore(), getLastUpdateTime(), getVersion()};
	}


	public static ConsumerOrder createWith(RetailscmUserContext userContext, ThrowingFunction<ConsumerOrder,ConsumerOrder,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<ConsumerOrder> customCreator = mapper.findCustomCreator(ConsumerOrder.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    ConsumerOrder result = new ConsumerOrder();
    result.setTitle(mapper.tryToGet(ConsumerOrder.class, TITLE_PROPERTY, String.class,
        0, true, result.getTitle(), params));
    result.setConsumer(mapper.tryToGet(ConsumerOrder.class, CONSUMER_PROPERTY, RetailStoreMember.class,
        0, true, result.getConsumer(), params));
    result.setStore(mapper.tryToGet(ConsumerOrder.class, STORE_PROPERTY, RetailStore.class,
        0, true, result.getStore(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixConsumerOrder(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ConsumerOrderTokens tokens = mapper.findParamByClass(params, ConsumerOrderTokens.class);
      if (tokens == null) {
        tokens = ConsumerOrderTokens.start();
      }
      result = userContext.getManagerGroup().getConsumerOrderManager().internalSaveConsumerOrder(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ConsumerOrder{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getConsumer() != null ){
 			stringBuilder.append("\tconsumer='RetailStoreMember("+getConsumer().getId()+")';");
 		}
		if(getStore() != null ){
 			stringBuilder.append("\tstore='RetailStore("+getStore().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

