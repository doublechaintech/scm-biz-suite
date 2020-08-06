
package com.doublechaintech.retailscm.goods;

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
import com.doublechaintech.retailscm.retailstore.RetailStore;
import com.doublechaintech.retailscm.goodsmovement.GoodsMovement;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.sku.Sku;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.transporttask.TransportTask;
import com.doublechaintech.retailscm.retailstoreorder.RetailStoreOrder;









@JsonSerialize(using = GoodsSerializer.class)
public class Goods extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String RFID_PROPERTY                  = "rfid"              ;
	public static final String UOM_PROPERTY                   = "uom"               ;
	public static final String MAX_PACKAGE_PROPERTY           = "maxPackage"        ;
	public static final String EXPIRE_TIME_PROPERTY           = "expireTime"        ;
	public static final String SKU_PROPERTY                   = "sku"               ;
	public static final String RECEIVING_SPACE_PROPERTY       = "receivingSpace"    ;
	public static final String GOODS_ALLOCATION_PROPERTY      = "goodsAllocation"   ;
	public static final String SMART_PALLET_PROPERTY          = "smartPallet"       ;
	public static final String SHIPPING_SPACE_PROPERTY        = "shippingSpace"     ;
	public static final String TRANSPORT_TASK_PROPERTY        = "transportTask"     ;
	public static final String RETAIL_STORE_PROPERTY          = "retailStore"       ;
	public static final String BIZ_ORDER_PROPERTY             = "bizOrder"          ;
	public static final String RETAIL_STORE_ORDER_PROPERTY    = "retailStoreOrder"  ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_MOVEMENT_LIST                      = "goodsMovementList" ;

	public static final String INTERNAL_TYPE="Goods";
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
	protected		String              	mRfid               ;
	protected		String              	mUom                ;
	protected		int                 	mMaxPackage         ;
	protected		Date                	mExpireTime         ;
	protected		Sku                 	mSku                ;
	protected		ReceivingSpace      	mReceivingSpace     ;
	protected		GoodsAllocation     	mGoodsAllocation    ;
	protected		SmartPallet         	mSmartPallet        ;
	protected		ShippingSpace       	mShippingSpace      ;
	protected		TransportTask       	mTransportTask      ;
	protected		RetailStore         	mRetailStore        ;
	protected		SupplyOrder         	mBizOrder           ;
	protected		RetailStoreOrder    	mRetailStoreOrder   ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GoodsMovement>	mGoodsMovementList  ;

	
		
	public 	Goods(){
		// lazy load for all the properties
	}
	public 	static Goods withId(String id){
		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(Integer.MAX_VALUE);
		return goods;
	}
	public 	static Goods refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setSku( null );
		setReceivingSpace( null );
		setGoodsAllocation( null );
		setSmartPallet( null );
		setShippingSpace( null );
		setTransportTask( null );
		setRetailStore( null );
		setBizOrder( null );
		setRetailStoreOrder( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(RFID_PROPERTY.equals(property)){
			changeRfidProperty(newValueExpr);
		}
		if(UOM_PROPERTY.equals(property)){
			changeUomProperty(newValueExpr);
		}
		if(MAX_PACKAGE_PROPERTY.equals(property)){
			changeMaxPackageProperty(newValueExpr);
		}
		if(EXPIRE_TIME_PROPERTY.equals(property)){
			changeExpireTimeProperty(newValueExpr);
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
			
			
			
	protected void changeRfidProperty(String newValueExpr){
	
		String oldValue = getRfid();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRfid(newValue);
		this.onChangeProperty(RFID_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeUomProperty(String newValueExpr){
	
		String oldValue = getUom();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateUom(newValue);
		this.onChangeProperty(UOM_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeMaxPackageProperty(String newValueExpr){
	
		int oldValue = getMaxPackage();
		int newValue = parseInt(newValueExpr);
		if(equalsInt(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMaxPackage(newValue);
		this.onChangeProperty(MAX_PACKAGE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeExpireTimeProperty(String newValueExpr){
	
		Date oldValue = getExpireTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateExpireTime(newValue);
		this.onChangeProperty(EXPIRE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(RFID_PROPERTY.equals(property)){
			return getRfid();
		}
		if(UOM_PROPERTY.equals(property)){
			return getUom();
		}
		if(MAX_PACKAGE_PROPERTY.equals(property)){
			return getMaxPackage();
		}
		if(EXPIRE_TIME_PROPERTY.equals(property)){
			return getExpireTime();
		}
		if(SKU_PROPERTY.equals(property)){
			return getSku();
		}
		if(RECEIVING_SPACE_PROPERTY.equals(property)){
			return getReceivingSpace();
		}
		if(GOODS_ALLOCATION_PROPERTY.equals(property)){
			return getGoodsAllocation();
		}
		if(SMART_PALLET_PROPERTY.equals(property)){
			return getSmartPallet();
		}
		if(SHIPPING_SPACE_PROPERTY.equals(property)){
			return getShippingSpace();
		}
		if(TRANSPORT_TASK_PROPERTY.equals(property)){
			return getTransportTask();
		}
		if(RETAIL_STORE_PROPERTY.equals(property)){
			return getRetailStore();
		}
		if(BIZ_ORDER_PROPERTY.equals(property)){
			return getBizOrder();
		}
		if(RETAIL_STORE_ORDER_PROPERTY.equals(property)){
			return getRetailStoreOrder();
		}
		if(GOODS_MOVEMENT_LIST.equals(property)){
			List<BaseEntity> list = getGoodsMovementList().stream().map(item->item).collect(Collectors.toList());
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
	public Goods updateId(String id){
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
	public Goods updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setRfid(String rfid){
		this.mRfid = trimString(rfid);;
	}
	public String getRfid(){
		return this.mRfid;
	}
	public Goods updateRfid(String rfid){
		this.mRfid = trimString(rfid);;
		this.changed = true;
		return this;
	}
	public void mergeRfid(String rfid){
		if(rfid != null) { setRfid(rfid);}
	}
	
	
	public void setUom(String uom){
		this.mUom = trimString(uom);;
	}
	public String getUom(){
		return this.mUom;
	}
	public Goods updateUom(String uom){
		this.mUom = trimString(uom);;
		this.changed = true;
		return this;
	}
	public void mergeUom(String uom){
		if(uom != null) { setUom(uom);}
	}
	
	
	public void setMaxPackage(int maxPackage){
		this.mMaxPackage = maxPackage;;
	}
	public int getMaxPackage(){
		return this.mMaxPackage;
	}
	public Goods updateMaxPackage(int maxPackage){
		this.mMaxPackage = maxPackage;;
		this.changed = true;
		return this;
	}
	public void mergeMaxPackage(int maxPackage){
		setMaxPackage(maxPackage);
	}
	
	
	public void setExpireTime(Date expireTime){
		this.mExpireTime = expireTime;;
	}
	public Date getExpireTime(){
		return this.mExpireTime;
	}
	public Goods updateExpireTime(Date expireTime){
		this.mExpireTime = expireTime;;
		this.changed = true;
		return this;
	}
	public void mergeExpireTime(Date expireTime){
		setExpireTime(expireTime);
	}
	
	
	public void setSku(Sku sku){
		this.mSku = sku;;
	}
	public Sku getSku(){
		return this.mSku;
	}
	public Goods updateSku(Sku sku){
		this.mSku = sku;;
		this.changed = true;
		return this;
	}
	public void mergeSku(Sku sku){
		if(sku != null) { setSku(sku);}
	}
	
	
	public void clearSku(){
		setSku ( null );
		this.changed = true;
	}
	
	public void setReceivingSpace(ReceivingSpace receivingSpace){
		this.mReceivingSpace = receivingSpace;;
	}
	public ReceivingSpace getReceivingSpace(){
		return this.mReceivingSpace;
	}
	public Goods updateReceivingSpace(ReceivingSpace receivingSpace){
		this.mReceivingSpace = receivingSpace;;
		this.changed = true;
		return this;
	}
	public void mergeReceivingSpace(ReceivingSpace receivingSpace){
		if(receivingSpace != null) { setReceivingSpace(receivingSpace);}
	}
	
	
	public void clearReceivingSpace(){
		setReceivingSpace ( null );
		this.changed = true;
	}
	
	public void setGoodsAllocation(GoodsAllocation goodsAllocation){
		this.mGoodsAllocation = goodsAllocation;;
	}
	public GoodsAllocation getGoodsAllocation(){
		return this.mGoodsAllocation;
	}
	public Goods updateGoodsAllocation(GoodsAllocation goodsAllocation){
		this.mGoodsAllocation = goodsAllocation;;
		this.changed = true;
		return this;
	}
	public void mergeGoodsAllocation(GoodsAllocation goodsAllocation){
		if(goodsAllocation != null) { setGoodsAllocation(goodsAllocation);}
	}
	
	
	public void clearGoodsAllocation(){
		setGoodsAllocation ( null );
		this.changed = true;
	}
	
	public void setSmartPallet(SmartPallet smartPallet){
		this.mSmartPallet = smartPallet;;
	}
	public SmartPallet getSmartPallet(){
		return this.mSmartPallet;
	}
	public Goods updateSmartPallet(SmartPallet smartPallet){
		this.mSmartPallet = smartPallet;;
		this.changed = true;
		return this;
	}
	public void mergeSmartPallet(SmartPallet smartPallet){
		if(smartPallet != null) { setSmartPallet(smartPallet);}
	}
	
	
	public void clearSmartPallet(){
		setSmartPallet ( null );
		this.changed = true;
	}
	
	public void setShippingSpace(ShippingSpace shippingSpace){
		this.mShippingSpace = shippingSpace;;
	}
	public ShippingSpace getShippingSpace(){
		return this.mShippingSpace;
	}
	public Goods updateShippingSpace(ShippingSpace shippingSpace){
		this.mShippingSpace = shippingSpace;;
		this.changed = true;
		return this;
	}
	public void mergeShippingSpace(ShippingSpace shippingSpace){
		if(shippingSpace != null) { setShippingSpace(shippingSpace);}
	}
	
	
	public void clearShippingSpace(){
		setShippingSpace ( null );
		this.changed = true;
	}
	
	public void setTransportTask(TransportTask transportTask){
		this.mTransportTask = transportTask;;
	}
	public TransportTask getTransportTask(){
		return this.mTransportTask;
	}
	public Goods updateTransportTask(TransportTask transportTask){
		this.mTransportTask = transportTask;;
		this.changed = true;
		return this;
	}
	public void mergeTransportTask(TransportTask transportTask){
		if(transportTask != null) { setTransportTask(transportTask);}
	}
	
	
	public void clearTransportTask(){
		setTransportTask ( null );
		this.changed = true;
	}
	
	public void setRetailStore(RetailStore retailStore){
		this.mRetailStore = retailStore;;
	}
	public RetailStore getRetailStore(){
		return this.mRetailStore;
	}
	public Goods updateRetailStore(RetailStore retailStore){
		this.mRetailStore = retailStore;;
		this.changed = true;
		return this;
	}
	public void mergeRetailStore(RetailStore retailStore){
		if(retailStore != null) { setRetailStore(retailStore);}
	}
	
	
	public void clearRetailStore(){
		setRetailStore ( null );
		this.changed = true;
	}
	
	public void setBizOrder(SupplyOrder bizOrder){
		this.mBizOrder = bizOrder;;
	}
	public SupplyOrder getBizOrder(){
		return this.mBizOrder;
	}
	public Goods updateBizOrder(SupplyOrder bizOrder){
		this.mBizOrder = bizOrder;;
		this.changed = true;
		return this;
	}
	public void mergeBizOrder(SupplyOrder bizOrder){
		if(bizOrder != null) { setBizOrder(bizOrder);}
	}
	
	
	public void clearBizOrder(){
		setBizOrder ( null );
		this.changed = true;
	}
	
	public void setRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		this.mRetailStoreOrder = retailStoreOrder;;
	}
	public RetailStoreOrder getRetailStoreOrder(){
		return this.mRetailStoreOrder;
	}
	public Goods updateRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		this.mRetailStoreOrder = retailStoreOrder;;
		this.changed = true;
		return this;
	}
	public void mergeRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		if(retailStoreOrder != null) { setRetailStoreOrder(retailStoreOrder);}
	}
	
	
	public void clearRetailStoreOrder(){
		setRetailStoreOrder ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Goods updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<GoodsMovement> getGoodsMovementList(){
		if(this.mGoodsMovementList == null){
			this.mGoodsMovementList = new SmartList<GoodsMovement>();
			this.mGoodsMovementList.setListInternalName (GOODS_MOVEMENT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsMovementList;	
	}
	public  void setGoodsMovementList(SmartList<GoodsMovement> goodsMovementList){
		for( GoodsMovement goodsMovement:goodsMovementList){
			goodsMovement.setGoods(this);
		}

		this.mGoodsMovementList = goodsMovementList;
		this.mGoodsMovementList.setListInternalName (GOODS_MOVEMENT_LIST );
		
	}
	
	public  void addGoodsMovement(GoodsMovement goodsMovement){
		goodsMovement.setGoods(this);
		getGoodsMovementList().add(goodsMovement);
	}
	public  void addGoodsMovementList(SmartList<GoodsMovement> goodsMovementList){
		for( GoodsMovement goodsMovement:goodsMovementList){
			goodsMovement.setGoods(this);
		}
		getGoodsMovementList().addAll(goodsMovementList);
	}
	public  void mergeGoodsMovementList(SmartList<GoodsMovement> goodsMovementList){
		if(goodsMovementList==null){
			return;
		}
		if(goodsMovementList.isEmpty()){
			return;
		}
		addGoodsMovementList( goodsMovementList );
		
	}
	public  GoodsMovement removeGoodsMovement(GoodsMovement goodsMovementIndex){
		
		int index = getGoodsMovementList().indexOf(goodsMovementIndex);
        if(index < 0){
        	String message = "GoodsMovement("+goodsMovementIndex.getId()+") with version='"+goodsMovementIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        GoodsMovement goodsMovement = getGoodsMovementList().get(index);        
        // goodsMovement.clearGoods(); //disconnect with Goods
        goodsMovement.clearFromAll(); //disconnect with Goods
		
		boolean result = getGoodsMovementList().planToRemove(goodsMovement);
        if(!result){
        	String message = "GoodsMovement("+goodsMovementIndex.getId()+") with version='"+goodsMovementIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return goodsMovement;
        
	
	}
	//断舍离
	public  void breakWithGoodsMovement(GoodsMovement goodsMovement){
		
		if(goodsMovement == null){
			return;
		}
		goodsMovement.setGoods(null);
		//getGoodsMovementList().remove();
	
	}
	
	public  boolean hasGoodsMovement(GoodsMovement goodsMovement){
	
		return getGoodsMovementList().contains(goodsMovement);
  
	}
	
	public void copyGoodsMovementFrom(GoodsMovement goodsMovement) {

		GoodsMovement goodsMovementInList = findTheGoodsMovement(goodsMovement);
		GoodsMovement newGoodsMovement = new GoodsMovement();
		goodsMovementInList.copyTo(newGoodsMovement);
		newGoodsMovement.setVersion(0);//will trigger copy
		getGoodsMovementList().add(newGoodsMovement);
		addItemToFlexiableObject(COPIED_CHILD, newGoodsMovement);
	}
	
	public  GoodsMovement findTheGoodsMovement(GoodsMovement goodsMovement){
		
		int index =  getGoodsMovementList().indexOf(goodsMovement);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "GoodsMovement("+goodsMovement.getId()+") with version='"+goodsMovement.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGoodsMovementList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsMovementList(){
		getGoodsMovementList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getSku(), internalType);
		addToEntityList(this, entityList, getReceivingSpace(), internalType);
		addToEntityList(this, entityList, getGoodsAllocation(), internalType);
		addToEntityList(this, entityList, getSmartPallet(), internalType);
		addToEntityList(this, entityList, getShippingSpace(), internalType);
		addToEntityList(this, entityList, getTransportTask(), internalType);
		addToEntityList(this, entityList, getRetailStore(), internalType);
		addToEntityList(this, entityList, getBizOrder(), internalType);
		addToEntityList(this, entityList, getRetailStoreOrder(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getGoodsMovementList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getGoodsMovementList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, RFID_PROPERTY, getRfid());
		appendKeyValuePair(result, UOM_PROPERTY, getUom());
		appendKeyValuePair(result, MAX_PACKAGE_PROPERTY, getMaxPackage());
		appendKeyValuePair(result, EXPIRE_TIME_PROPERTY, getExpireTime());
		appendKeyValuePair(result, SKU_PROPERTY, getSku());
		appendKeyValuePair(result, RECEIVING_SPACE_PROPERTY, getReceivingSpace());
		appendKeyValuePair(result, GOODS_ALLOCATION_PROPERTY, getGoodsAllocation());
		appendKeyValuePair(result, SMART_PALLET_PROPERTY, getSmartPallet());
		appendKeyValuePair(result, SHIPPING_SPACE_PROPERTY, getShippingSpace());
		appendKeyValuePair(result, TRANSPORT_TASK_PROPERTY, getTransportTask());
		appendKeyValuePair(result, RETAIL_STORE_PROPERTY, getRetailStore());
		appendKeyValuePair(result, BIZ_ORDER_PROPERTY, getBizOrder());
		appendKeyValuePair(result, RETAIL_STORE_ORDER_PROPERTY, getRetailStoreOrder());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, GOODS_MOVEMENT_LIST, getGoodsMovementList());
		if(!getGoodsMovementList().isEmpty()){
			appendKeyValuePair(result, "goodsMovementCount", getGoodsMovementList().getTotalCount());
			appendKeyValuePair(result, "goodsMovementCurrentPageNumber", getGoodsMovementList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Goods){
		
		
			Goods dest =(Goods)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setRfid(getRfid());
			dest.setUom(getUom());
			dest.setMaxPackage(getMaxPackage());
			dest.setExpireTime(getExpireTime());
			dest.setSku(getSku());
			dest.setReceivingSpace(getReceivingSpace());
			dest.setGoodsAllocation(getGoodsAllocation());
			dest.setSmartPallet(getSmartPallet());
			dest.setShippingSpace(getShippingSpace());
			dest.setTransportTask(getTransportTask());
			dest.setRetailStore(getRetailStore());
			dest.setBizOrder(getBizOrder());
			dest.setRetailStoreOrder(getRetailStoreOrder());
			dest.setVersion(getVersion());
			dest.setGoodsMovementList(getGoodsMovementList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Goods){
		
			
			Goods dest =(Goods)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeRfid(getRfid());
			dest.mergeUom(getUom());
			dest.mergeMaxPackage(getMaxPackage());
			dest.mergeExpireTime(getExpireTime());
			dest.mergeSku(getSku());
			dest.mergeReceivingSpace(getReceivingSpace());
			dest.mergeGoodsAllocation(getGoodsAllocation());
			dest.mergeSmartPallet(getSmartPallet());
			dest.mergeShippingSpace(getShippingSpace());
			dest.mergeTransportTask(getTransportTask());
			dest.mergeRetailStore(getRetailStore());
			dest.mergeBizOrder(getBizOrder());
			dest.mergeRetailStoreOrder(getRetailStoreOrder());
			dest.mergeVersion(getVersion());
			dest.mergeGoodsMovementList(getGoodsMovementList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Goods){
		
			
			Goods dest =(Goods)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeRfid(getRfid());
			dest.mergeUom(getUom());
			dest.mergeMaxPackage(getMaxPackage());
			dest.mergeExpireTime(getExpireTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getRfid(), getUom(), getMaxPackage(), getExpireTime(), getSku(), getReceivingSpace(), getGoodsAllocation(), getSmartPallet(), getShippingSpace(), getTransportTask(), getRetailStore(), getBizOrder(), getRetailStoreOrder(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Goods{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\trfid='"+getRfid()+"';");
		stringBuilder.append("\tuom='"+getUom()+"';");
		stringBuilder.append("\tmaxPackage='"+getMaxPackage()+"';");
		stringBuilder.append("\texpireTime='"+getExpireTime()+"';");
		if(getSku() != null ){
 			stringBuilder.append("\tsku='Sku("+getSku().getId()+")';");
 		}
		if(getReceivingSpace() != null ){
 			stringBuilder.append("\treceivingSpace='ReceivingSpace("+getReceivingSpace().getId()+")';");
 		}
		if(getGoodsAllocation() != null ){
 			stringBuilder.append("\tgoodsAllocation='GoodsAllocation("+getGoodsAllocation().getId()+")';");
 		}
		if(getSmartPallet() != null ){
 			stringBuilder.append("\tsmartPallet='SmartPallet("+getSmartPallet().getId()+")';");
 		}
		if(getShippingSpace() != null ){
 			stringBuilder.append("\tshippingSpace='ShippingSpace("+getShippingSpace().getId()+")';");
 		}
		if(getTransportTask() != null ){
 			stringBuilder.append("\ttransportTask='TransportTask("+getTransportTask().getId()+")';");
 		}
		if(getRetailStore() != null ){
 			stringBuilder.append("\tretailStore='RetailStore("+getRetailStore().getId()+")';");
 		}
		if(getBizOrder() != null ){
 			stringBuilder.append("\tbizOrder='SupplyOrder("+getBizOrder().getId()+")';");
 		}
		if(getRetailStoreOrder() != null ){
 			stringBuilder.append("\tretailStoreOrder='RetailStoreOrder("+getRetailStoreOrder().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	
	public void increaseMaxPackage(int incMaxPackage){
		updateMaxPackage(this.mMaxPackage +  incMaxPackage);
	}
	public void decreaseMaxPackage(int decMaxPackage){
		updateMaxPackage(this.mMaxPackage - decMaxPackage);
	}
	

}

