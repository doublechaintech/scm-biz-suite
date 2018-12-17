
package com.doublechaintech.retailscm.consumerorder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.supplyorderapproval.SupplyOrderApproval;
import com.doublechaintech.retailscm.consumerordershippinggroup.ConsumerOrderShippingGroup;
import com.doublechaintech.retailscm.retailstoremember.RetailStoreMember;
import com.doublechaintech.retailscm.supplyorderdelivery.SupplyOrderDelivery;
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.consumerorderpriceadjustment.ConsumerOrderPriceAdjustment;
import com.doublechaintech.retailscm.consumerorderpaymentgroup.ConsumerOrderPaymentGroup;
import com.doublechaintech.retailscm.consumerorderlineitem.ConsumerOrderLineItem;
import com.doublechaintech.retailscm.retailstoremembergiftcardconsumerecord.RetailStoreMemberGiftCardConsumeRecord;
import com.doublechaintech.retailscm.supplyorderprocessing.SupplyOrderProcessing;
import com.doublechaintech.retailscm.supplyorderconfirmation.SupplyOrderConfirmation;
import com.doublechaintech.retailscm.supplyordershipment.SupplyOrderShipment;

@JsonSerialize(using = ConsumerOrderSerializer.class)
public class ConsumerOrder extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String TITLE_PROPERTY                 = "title"             ;
	public static final String CONSUMER_PROPERTY              = "consumer"          ;
	public static final String CONFIRMATION_PROPERTY          = "confirmation"      ;
	public static final String APPROVAL_PROPERTY              = "approval"          ;
	public static final String PROCESSING_PROPERTY            = "processing"        ;
	public static final String SHIPMENT_PROPERTY              = "shipment"          ;
	public static final String DELIVERY_PROPERTY              = "delivery"          ;
	public static final String STORE_PROPERTY                 = "store"             ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String CURRENT_STATUS_PROPERTY        = "currentStatus"     ;
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
	
	public String getDisplayName(){
	
		String displayName = getTitle();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mTitle              ;
	protected		RetailStoreMember   	mConsumer           ;
	protected		SupplyOrderConfirmation	mConfirmation       ;
	protected		SupplyOrderApproval 	mApproval           ;
	protected		SupplyOrderProcessing	mProcessing         ;
	protected		SupplyOrderShipment 	mShipment           ;
	protected		SupplyOrderDelivery 	mDelivery           ;
	protected		RetailStore         	mStore              ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		String              	mCurrentStatus      ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<ConsumerOrderLineItem>	mConsumerOrderLineItemList;
	protected		SmartList<ConsumerOrderShippingGroup>	mConsumerOrderShippingGroupList;
	protected		SmartList<ConsumerOrderPaymentGroup>	mConsumerOrderPaymentGroupList;
	protected		SmartList<ConsumerOrderPriceAdjustment>	mConsumerOrderPriceAdjustmentList;
	protected		SmartList<RetailStoreMemberGiftCardConsumeRecord>	mRetailStoreMemberGiftCardConsumeRecordList;
	
		
	public 	ConsumerOrder(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setConsumer( null );
		setConfirmation( null );
		setApproval( null );
		setProcessing( null );
		setShipment( null );
		setDelivery( null );
		setStore( null );

		this.changed = true;
	}
	
	public 	ConsumerOrder(String title, RetailStoreMember consumer, RetailStore store, DateTime lastUpdateTime, String currentStatus)
	{
		setTitle(title);
		setConsumer(consumer);
		setStore(store);
		setLastUpdateTime(lastUpdateTime);
		setCurrentStatus(currentStatus);

		this.mConsumerOrderLineItemList = new SmartList<ConsumerOrderLineItem>();
		this.mConsumerOrderShippingGroupList = new SmartList<ConsumerOrderShippingGroup>();
		this.mConsumerOrderPaymentGroupList = new SmartList<ConsumerOrderPaymentGroup>();
		this.mConsumerOrderPriceAdjustmentList = new SmartList<ConsumerOrderPriceAdjustment>();
		this.mRetailStoreMemberGiftCardConsumeRecordList = new SmartList<RetailStoreMemberGiftCardConsumeRecord>();	
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
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public ConsumerOrder updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setTitle(String title){
		this.mTitle = trimString(title);;
	}
	public String getTitle(){
		return this.mTitle;
	}
	public ConsumerOrder updateTitle(String title){
		this.mTitle = trimString(title);;
		this.changed = true;
		return this;
	}
	
	
	public void setConsumer(RetailStoreMember consumer){
		this.mConsumer = consumer;;
	}
	public RetailStoreMember getConsumer(){
		return this.mConsumer;
	}
	public ConsumerOrder updateConsumer(RetailStoreMember consumer){
		this.mConsumer = consumer;;
		this.changed = true;
		return this;
	}
	
	
	public void clearConsumer(){
		setConsumer ( null );
		this.changed = true;
	}
	
	public void setConfirmation(SupplyOrderConfirmation confirmation){
		this.mConfirmation = confirmation;;
	}
	public SupplyOrderConfirmation getConfirmation(){
		return this.mConfirmation;
	}
	public ConsumerOrder updateConfirmation(SupplyOrderConfirmation confirmation){
		this.mConfirmation = confirmation;;
		this.changed = true;
		return this;
	}
	
	
	public void clearConfirmation(){
		setConfirmation ( null );
		this.changed = true;
	}
	
	public void setApproval(SupplyOrderApproval approval){
		this.mApproval = approval;;
	}
	public SupplyOrderApproval getApproval(){
		return this.mApproval;
	}
	public ConsumerOrder updateApproval(SupplyOrderApproval approval){
		this.mApproval = approval;;
		this.changed = true;
		return this;
	}
	
	
	public void clearApproval(){
		setApproval ( null );
		this.changed = true;
	}
	
	public void setProcessing(SupplyOrderProcessing processing){
		this.mProcessing = processing;;
	}
	public SupplyOrderProcessing getProcessing(){
		return this.mProcessing;
	}
	public ConsumerOrder updateProcessing(SupplyOrderProcessing processing){
		this.mProcessing = processing;;
		this.changed = true;
		return this;
	}
	
	
	public void clearProcessing(){
		setProcessing ( null );
		this.changed = true;
	}
	
	public void setShipment(SupplyOrderShipment shipment){
		this.mShipment = shipment;;
	}
	public SupplyOrderShipment getShipment(){
		return this.mShipment;
	}
	public ConsumerOrder updateShipment(SupplyOrderShipment shipment){
		this.mShipment = shipment;;
		this.changed = true;
		return this;
	}
	
	
	public void clearShipment(){
		setShipment ( null );
		this.changed = true;
	}
	
	public void setDelivery(SupplyOrderDelivery delivery){
		this.mDelivery = delivery;;
	}
	public SupplyOrderDelivery getDelivery(){
		return this.mDelivery;
	}
	public ConsumerOrder updateDelivery(SupplyOrderDelivery delivery){
		this.mDelivery = delivery;;
		this.changed = true;
		return this;
	}
	
	
	public void clearDelivery(){
		setDelivery ( null );
		this.changed = true;
	}
	
	public void setStore(RetailStore store){
		this.mStore = store;;
	}
	public RetailStore getStore(){
		return this.mStore;
	}
	public ConsumerOrder updateStore(RetailStore store){
		this.mStore = store;;
		this.changed = true;
		return this;
	}
	
	
	public void clearStore(){
		setStore ( null );
		this.changed = true;
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public ConsumerOrder updateLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
	}
	public String getCurrentStatus(){
		return this.mCurrentStatus;
	}
	public ConsumerOrder updateCurrentStatus(String currentStatus){
		this.mCurrentStatus = trimString(currentStatus);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public ConsumerOrder updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	
	

	public  SmartList<ConsumerOrderLineItem> getConsumerOrderLineItemList(){
		if(this.mConsumerOrderLineItemList == null){
			this.mConsumerOrderLineItemList = new SmartList<ConsumerOrderLineItem>();
			this.mConsumerOrderLineItemList.setListInternalName (CONSUMER_ORDER_LINE_ITEM_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mConsumerOrderLineItemList;	
	}
	public  void setConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList){
		for( ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList){
			consumerOrderLineItem.setBizOrder(this);
		}

		this.mConsumerOrderLineItemList = consumerOrderLineItemList;
		this.mConsumerOrderLineItemList.setListInternalName (CONSUMER_ORDER_LINE_ITEM_LIST );
		
	}
	
	public  void addConsumerOrderLineItem(ConsumerOrderLineItem consumerOrderLineItem){
		consumerOrderLineItem.setBizOrder(this);
		getConsumerOrderLineItemList().add(consumerOrderLineItem);
	}
	public  void addConsumerOrderLineItemList(SmartList<ConsumerOrderLineItem> consumerOrderLineItemList){
		for( ConsumerOrderLineItem consumerOrderLineItem:consumerOrderLineItemList){
			consumerOrderLineItem.setBizOrder(this);
		}
		getConsumerOrderLineItemList().addAll(consumerOrderLineItemList);
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
	public  void setConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		for( ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			consumerOrderShippingGroup.setBizOrder(this);
		}

		this.mConsumerOrderShippingGroupList = consumerOrderShippingGroupList;
		this.mConsumerOrderShippingGroupList.setListInternalName (CONSUMER_ORDER_SHIPPING_GROUP_LIST );
		
	}
	
	public  void addConsumerOrderShippingGroup(ConsumerOrderShippingGroup consumerOrderShippingGroup){
		consumerOrderShippingGroup.setBizOrder(this);
		getConsumerOrderShippingGroupList().add(consumerOrderShippingGroup);
	}
	public  void addConsumerOrderShippingGroupList(SmartList<ConsumerOrderShippingGroup> consumerOrderShippingGroupList){
		for( ConsumerOrderShippingGroup consumerOrderShippingGroup:consumerOrderShippingGroupList){
			consumerOrderShippingGroup.setBizOrder(this);
		}
		getConsumerOrderShippingGroupList().addAll(consumerOrderShippingGroupList);
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
	public  void setConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		for( ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList){
			consumerOrderPaymentGroup.setBizOrder(this);
		}

		this.mConsumerOrderPaymentGroupList = consumerOrderPaymentGroupList;
		this.mConsumerOrderPaymentGroupList.setListInternalName (CONSUMER_ORDER_PAYMENT_GROUP_LIST );
		
	}
	
	public  void addConsumerOrderPaymentGroup(ConsumerOrderPaymentGroup consumerOrderPaymentGroup){
		consumerOrderPaymentGroup.setBizOrder(this);
		getConsumerOrderPaymentGroupList().add(consumerOrderPaymentGroup);
	}
	public  void addConsumerOrderPaymentGroupList(SmartList<ConsumerOrderPaymentGroup> consumerOrderPaymentGroupList){
		for( ConsumerOrderPaymentGroup consumerOrderPaymentGroup:consumerOrderPaymentGroupList){
			consumerOrderPaymentGroup.setBizOrder(this);
		}
		getConsumerOrderPaymentGroupList().addAll(consumerOrderPaymentGroupList);
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
	public  void setConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		for( ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			consumerOrderPriceAdjustment.setBizOrder(this);
		}

		this.mConsumerOrderPriceAdjustmentList = consumerOrderPriceAdjustmentList;
		this.mConsumerOrderPriceAdjustmentList.setListInternalName (CONSUMER_ORDER_PRICE_ADJUSTMENT_LIST );
		
	}
	
	public  void addConsumerOrderPriceAdjustment(ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment){
		consumerOrderPriceAdjustment.setBizOrder(this);
		getConsumerOrderPriceAdjustmentList().add(consumerOrderPriceAdjustment);
	}
	public  void addConsumerOrderPriceAdjustmentList(SmartList<ConsumerOrderPriceAdjustment> consumerOrderPriceAdjustmentList){
		for( ConsumerOrderPriceAdjustment consumerOrderPriceAdjustment:consumerOrderPriceAdjustmentList){
			consumerOrderPriceAdjustment.setBizOrder(this);
		}
		getConsumerOrderPriceAdjustmentList().addAll(consumerOrderPriceAdjustmentList);
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
	public  void setRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		}

		this.mRetailStoreMemberGiftCardConsumeRecordList = retailStoreMemberGiftCardConsumeRecordList;
		this.mRetailStoreMemberGiftCardConsumeRecordList.setListInternalName (RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD_LIST );
		
	}
	
	public  void addRetailStoreMemberGiftCardConsumeRecord(RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord){
		retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		getRetailStoreMemberGiftCardConsumeRecordList().add(retailStoreMemberGiftCardConsumeRecord);
	}
	public  void addRetailStoreMemberGiftCardConsumeRecordList(SmartList<RetailStoreMemberGiftCardConsumeRecord> retailStoreMemberGiftCardConsumeRecordList){
		for( RetailStoreMemberGiftCardConsumeRecord retailStoreMemberGiftCardConsumeRecord:retailStoreMemberGiftCardConsumeRecordList){
			retailStoreMemberGiftCardConsumeRecord.setBizOrder(this);
		}
		getRetailStoreMemberGiftCardConsumeRecordList().addAll(retailStoreMemberGiftCardConsumeRecordList);
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
		addToEntityList(this, entityList, getConfirmation(), internalType);
		addToEntityList(this, entityList, getApproval(), internalType);
		addToEntityList(this, entityList, getProcessing(), internalType);
		addToEntityList(this, entityList, getShipment(), internalType);
		addToEntityList(this, entityList, getDelivery(), internalType);
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
		appendKeyValuePair(result, CONFIRMATION_PROPERTY, getConfirmation());
		appendKeyValuePair(result, APPROVAL_PROPERTY, getApproval());
		appendKeyValuePair(result, PROCESSING_PROPERTY, getProcessing());
		appendKeyValuePair(result, SHIPMENT_PROPERTY, getShipment());
		appendKeyValuePair(result, DELIVERY_PROPERTY, getDelivery());
		appendKeyValuePair(result, STORE_PROPERTY, getStore());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, CURRENT_STATUS_PROPERTY, getCurrentStatus());
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

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof ConsumerOrder){
		
		
			ConsumerOrder dest =(ConsumerOrder)baseDest;
		
			dest.setId(getId());
			dest.setTitle(getTitle());
			dest.setConsumer(getConsumer());
			dest.setConfirmation(getConfirmation());
			dest.setApproval(getApproval());
			dest.setProcessing(getProcessing());
			dest.setShipment(getShipment());
			dest.setDelivery(getDelivery());
			dest.setStore(getStore());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setCurrentStatus(getCurrentStatus());
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
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ConsumerOrder{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\ttitle='"+getTitle()+"';");
		if(getConsumer() != null ){
 			stringBuilder.append("\tconsumer='RetailStoreMember("+getConsumer().getId()+")';");
 		}
		if(getConfirmation() != null ){
 			stringBuilder.append("\tconfirmation='SupplyOrderConfirmation("+getConfirmation().getId()+")';");
 		}
		if(getApproval() != null ){
 			stringBuilder.append("\tapproval='SupplyOrderApproval("+getApproval().getId()+")';");
 		}
		if(getProcessing() != null ){
 			stringBuilder.append("\tprocessing='SupplyOrderProcessing("+getProcessing().getId()+")';");
 		}
		if(getShipment() != null ){
 			stringBuilder.append("\tshipment='SupplyOrderShipment("+getShipment().getId()+")';");
 		}
		if(getDelivery() != null ){
 			stringBuilder.append("\tdelivery='SupplyOrderDelivery("+getDelivery().getId()+")';");
 		}
		if(getStore() != null ){
 			stringBuilder.append("\tstore='RetailStore("+getStore().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tcurrentStatus='"+getCurrentStatus()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

