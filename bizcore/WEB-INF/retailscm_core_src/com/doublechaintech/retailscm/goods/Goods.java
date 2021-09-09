
package com.doublechaintech.retailscm.goods;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(RFID_PROPERTY, "rfid", "RFID")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(UOM_PROPERTY, "uom", "计量单位")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(MAX_PACKAGE_PROPERTY, "max_package", "最大包装")
        .withType("int", "int"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EXPIRE_TIME_PROPERTY, "expire_time", "到期时间")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SKU_PROPERTY, "sku", "SKU")
        .withType("sku", Sku.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(RECEIVING_SPACE_PROPERTY, "receiving_space", "收货区")
        .withType("receiving_space", ReceivingSpace.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(GOODS_ALLOCATION_PROPERTY, "goods_allocation", "货位")
        .withType("goods_allocation", GoodsAllocation.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SMART_PALLET_PROPERTY, "smart_pallet", "智能托盘")
        .withType("smart_pallet", SmartPallet.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SHIPPING_SPACE_PROPERTY, "shipping_space", "发货区")
        .withType("shipping_space", ShippingSpace.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TRANSPORT_TASK_PROPERTY, "transport_task", "运输任务")
        .withType("transport_task", TransportTask.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(RETAIL_STORE_PROPERTY, "retail_store", "双链小超")
        .withType("retail_store", RetailStore.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BIZ_ORDER_PROPERTY, "supply_order", "订单")
        .withType("supply_order", SupplyOrder.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(RETAIL_STORE_ORDER_PROPERTY, "retail_store_order", "生超的订单")
        .withType("retail_store_order", RetailStoreOrder.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(GOODS_MOVEMENT_LIST, "goods", "运动商品列表")
        .withType("goods_movement", GoodsMovement.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,RFID_PROPERTY ,UOM_PROPERTY ,MAX_PACKAGE_PROPERTY ,EXPIRE_TIME_PROPERTY ,SKU_PROPERTY ,RECEIVING_SPACE_PROPERTY ,GOODS_ALLOCATION_PROPERTY ,SMART_PALLET_PROPERTY ,SHIPPING_SPACE_PROPERTY ,TRANSPORT_TASK_PROPERTY ,RETAIL_STORE_PROPERTY ,BIZ_ORDER_PROPERTY ,RETAIL_STORE_ORDER_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(GOODS_MOVEMENT_LIST, "goods");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(GOODS_MOVEMENT_LIST, GoodsMovement.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(SKU_PROPERTY, Sku.class);
parents.put(RECEIVING_SPACE_PROPERTY, ReceivingSpace.class);
parents.put(GOODS_ALLOCATION_PROPERTY, GoodsAllocation.class);
parents.put(SMART_PALLET_PROPERTY, SmartPallet.class);
parents.put(SHIPPING_SPACE_PROPERTY, ShippingSpace.class);
parents.put(TRANSPORT_TASK_PROPERTY, TransportTask.class);
parents.put(RETAIL_STORE_PROPERTY, RetailStore.class);
parents.put(BIZ_ORDER_PROPERTY, SupplyOrder.class);
parents.put(RETAIL_STORE_ORDER_PROPERTY, RetailStoreOrder.class);

    return parents;
  }

  public Goods want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Goods wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getName();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	name                ;
	protected		String              	rfid                ;
	protected		String              	uom                 ;
	protected		int                 	maxPackage          ;
	protected		Date                	expireTime          ;
	protected		Sku                 	sku                 ;
	protected		ReceivingSpace      	receivingSpace      ;
	protected		GoodsAllocation     	goodsAllocation     ;
	protected		SmartPallet         	smartPallet         ;
	protected		ShippingSpace       	shippingSpace       ;
	protected		TransportTask       	transportTask       ;
	protected		RetailStore         	retailStore         ;
	protected		SupplyOrder         	bizOrder            ;
	protected		RetailStoreOrder    	retailStoreOrder    ;
	protected		int                 	version             ;

	
	protected		SmartList<GoodsMovement>	mGoodsMovementList  ;



	public 	Goods(){
		// lazy load for all the properties
	}
	public 	static Goods withId(String id){
		Goods goods = new Goods();
		goods.setId(id);
		goods.setVersion(Integer.MAX_VALUE);
		goods.setChecked(true);
		return goods;
	}
	public 	static Goods refById(String id){
		return withId(id);
	}

  public Goods limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Goods limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Goods searchExample(){
    Goods goods = new Goods();
    		goods.setMaxPackage(UNSET_INT);
		goods.setVersion(UNSET_INT);

    return goods;
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
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public Goods updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Goods orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Goods ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Goods addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setName(String name){String oldName = this.name;String newName = trimString(name);this.name = newName;}
	public String name(){
doLoad();
return getName();
}
	public String getName(){
		return this.name;
	}
	public Goods updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public Goods orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public Goods ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public Goods addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setRfid(String rfid){String oldRfid = this.rfid;String newRfid = trimString(rfid);this.rfid = newRfid;}
	public String rfid(){
doLoad();
return getRfid();
}
	public String getRfid(){
		return this.rfid;
	}
	public Goods updateRfid(String rfid){String oldRfid = this.rfid;String newRfid = trimString(rfid);if(!shouldReplaceBy(newRfid, oldRfid)){return this;}this.rfid = newRfid;addPropertyChange(RFID_PROPERTY, oldRfid, newRfid);this.changed = true;setChecked(false);return this;}
	public Goods orderByRfid(boolean asc){
doAddOrderBy(RFID_PROPERTY, asc);
return this;
}
	public SearchCriteria createRfidCriteria(QueryOperator operator, Object... parameters){
return createCriteria(RFID_PROPERTY, operator, parameters);
}
	public Goods ignoreRfidCriteria(){super.ignoreSearchProperty(RFID_PROPERTY);
return this;
}
	public Goods addRfidCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRfidCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRfid(String rfid){
		if(rfid != null) { setRfid(rfid);}
	}

	
	public void setUom(String uom){String oldUom = this.uom;String newUom = trimString(uom);this.uom = newUom;}
	public String uom(){
doLoad();
return getUom();
}
	public String getUom(){
		return this.uom;
	}
	public Goods updateUom(String uom){String oldUom = this.uom;String newUom = trimString(uom);if(!shouldReplaceBy(newUom, oldUom)){return this;}this.uom = newUom;addPropertyChange(UOM_PROPERTY, oldUom, newUom);this.changed = true;setChecked(false);return this;}
	public Goods orderByUom(boolean asc){
doAddOrderBy(UOM_PROPERTY, asc);
return this;
}
	public SearchCriteria createUomCriteria(QueryOperator operator, Object... parameters){
return createCriteria(UOM_PROPERTY, operator, parameters);
}
	public Goods ignoreUomCriteria(){super.ignoreSearchProperty(UOM_PROPERTY);
return this;
}
	public Goods addUomCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createUomCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeUom(String uom){
		if(uom != null) { setUom(uom);}
	}

	
	public void setMaxPackage(int maxPackage){int oldMaxPackage = this.maxPackage;int newMaxPackage = maxPackage;this.maxPackage = newMaxPackage;}
	public int maxPackage(){
doLoad();
return getMaxPackage();
}
	public int getMaxPackage(){
		return this.maxPackage;
	}
	public Goods updateMaxPackage(int maxPackage){int oldMaxPackage = this.maxPackage;int newMaxPackage = maxPackage;if(!shouldReplaceBy(newMaxPackage, oldMaxPackage)){return this;}this.maxPackage = newMaxPackage;addPropertyChange(MAX_PACKAGE_PROPERTY, oldMaxPackage, newMaxPackage);this.changed = true;setChecked(false);return this;}
	public Goods orderByMaxPackage(boolean asc){
doAddOrderBy(MAX_PACKAGE_PROPERTY, asc);
return this;
}
	public SearchCriteria createMaxPackageCriteria(QueryOperator operator, Object... parameters){
return createCriteria(MAX_PACKAGE_PROPERTY, operator, parameters);
}
	public Goods ignoreMaxPackageCriteria(){super.ignoreSearchProperty(MAX_PACKAGE_PROPERTY);
return this;
}
	public Goods addMaxPackageCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createMaxPackageCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeMaxPackage(int maxPackage){
		setMaxPackage(maxPackage);
	}

	
	public void setExpireTime(Date expireTime){Date oldExpireTime = this.expireTime;Date newExpireTime = expireTime;this.expireTime = newExpireTime;}
	public Date expireTime(){
doLoad();
return getExpireTime();
}
	public Date getExpireTime(){
		return this.expireTime;
	}
	public Goods updateExpireTime(Date expireTime){Date oldExpireTime = this.expireTime;Date newExpireTime = expireTime;if(!shouldReplaceBy(newExpireTime, oldExpireTime)){return this;}this.expireTime = newExpireTime;addPropertyChange(EXPIRE_TIME_PROPERTY, oldExpireTime, newExpireTime);this.changed = true;setChecked(false);return this;}
	public Goods orderByExpireTime(boolean asc){
doAddOrderBy(EXPIRE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createExpireTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EXPIRE_TIME_PROPERTY, operator, parameters);
}
	public Goods ignoreExpireTimeCriteria(){super.ignoreSearchProperty(EXPIRE_TIME_PROPERTY);
return this;
}
	public Goods addExpireTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createExpireTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeExpireTime(Date expireTime){
		setExpireTime(expireTime);
	}

	
	public void setSku(Sku sku){Sku oldSku = this.sku;Sku newSku = sku;this.sku = newSku;}
	public Sku sku(){
doLoad();
return getSku();
}
	public Sku getSku(){
		return this.sku;
	}
	public Goods updateSku(Sku sku){Sku oldSku = this.sku;Sku newSku = sku;if(!shouldReplaceBy(newSku, oldSku)){return this;}this.sku = newSku;addPropertyChange(SKU_PROPERTY, oldSku, newSku);this.changed = true;setChecked(false);return this;}
	public Goods orderBySku(boolean asc){
doAddOrderBy(SKU_PROPERTY, asc);
return this;
}
	public SearchCriteria createSkuCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SKU_PROPERTY, operator, parameters);
}
	public Goods ignoreSkuCriteria(){super.ignoreSearchProperty(SKU_PROPERTY);
return this;
}
	public Goods addSkuCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSkuCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSku(Sku sku){
		if(sku != null) { setSku(sku);}
	}

	
	public void clearSku(){
		setSku ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setReceivingSpace(ReceivingSpace receivingSpace){ReceivingSpace oldReceivingSpace = this.receivingSpace;ReceivingSpace newReceivingSpace = receivingSpace;this.receivingSpace = newReceivingSpace;}
	public ReceivingSpace receivingSpace(){
doLoad();
return getReceivingSpace();
}
	public ReceivingSpace getReceivingSpace(){
		return this.receivingSpace;
	}
	public Goods updateReceivingSpace(ReceivingSpace receivingSpace){ReceivingSpace oldReceivingSpace = this.receivingSpace;ReceivingSpace newReceivingSpace = receivingSpace;if(!shouldReplaceBy(newReceivingSpace, oldReceivingSpace)){return this;}this.receivingSpace = newReceivingSpace;addPropertyChange(RECEIVING_SPACE_PROPERTY, oldReceivingSpace, newReceivingSpace);this.changed = true;setChecked(false);return this;}
	public Goods orderByReceivingSpace(boolean asc){
doAddOrderBy(RECEIVING_SPACE_PROPERTY, asc);
return this;
}
	public SearchCriteria createReceivingSpaceCriteria(QueryOperator operator, Object... parameters){
return createCriteria(RECEIVING_SPACE_PROPERTY, operator, parameters);
}
	public Goods ignoreReceivingSpaceCriteria(){super.ignoreSearchProperty(RECEIVING_SPACE_PROPERTY);
return this;
}
	public Goods addReceivingSpaceCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createReceivingSpaceCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeReceivingSpace(ReceivingSpace receivingSpace){
		if(receivingSpace != null) { setReceivingSpace(receivingSpace);}
	}

	
	public void clearReceivingSpace(){
		setReceivingSpace ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setGoodsAllocation(GoodsAllocation goodsAllocation){GoodsAllocation oldGoodsAllocation = this.goodsAllocation;GoodsAllocation newGoodsAllocation = goodsAllocation;this.goodsAllocation = newGoodsAllocation;}
	public GoodsAllocation goodsAllocation(){
doLoad();
return getGoodsAllocation();
}
	public GoodsAllocation getGoodsAllocation(){
		return this.goodsAllocation;
	}
	public Goods updateGoodsAllocation(GoodsAllocation goodsAllocation){GoodsAllocation oldGoodsAllocation = this.goodsAllocation;GoodsAllocation newGoodsAllocation = goodsAllocation;if(!shouldReplaceBy(newGoodsAllocation, oldGoodsAllocation)){return this;}this.goodsAllocation = newGoodsAllocation;addPropertyChange(GOODS_ALLOCATION_PROPERTY, oldGoodsAllocation, newGoodsAllocation);this.changed = true;setChecked(false);return this;}
	public Goods orderByGoodsAllocation(boolean asc){
doAddOrderBy(GOODS_ALLOCATION_PROPERTY, asc);
return this;
}
	public SearchCriteria createGoodsAllocationCriteria(QueryOperator operator, Object... parameters){
return createCriteria(GOODS_ALLOCATION_PROPERTY, operator, parameters);
}
	public Goods ignoreGoodsAllocationCriteria(){super.ignoreSearchProperty(GOODS_ALLOCATION_PROPERTY);
return this;
}
	public Goods addGoodsAllocationCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createGoodsAllocationCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeGoodsAllocation(GoodsAllocation goodsAllocation){
		if(goodsAllocation != null) { setGoodsAllocation(goodsAllocation);}
	}

	
	public void clearGoodsAllocation(){
		setGoodsAllocation ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setSmartPallet(SmartPallet smartPallet){SmartPallet oldSmartPallet = this.smartPallet;SmartPallet newSmartPallet = smartPallet;this.smartPallet = newSmartPallet;}
	public SmartPallet smartPallet(){
doLoad();
return getSmartPallet();
}
	public SmartPallet getSmartPallet(){
		return this.smartPallet;
	}
	public Goods updateSmartPallet(SmartPallet smartPallet){SmartPallet oldSmartPallet = this.smartPallet;SmartPallet newSmartPallet = smartPallet;if(!shouldReplaceBy(newSmartPallet, oldSmartPallet)){return this;}this.smartPallet = newSmartPallet;addPropertyChange(SMART_PALLET_PROPERTY, oldSmartPallet, newSmartPallet);this.changed = true;setChecked(false);return this;}
	public Goods orderBySmartPallet(boolean asc){
doAddOrderBy(SMART_PALLET_PROPERTY, asc);
return this;
}
	public SearchCriteria createSmartPalletCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SMART_PALLET_PROPERTY, operator, parameters);
}
	public Goods ignoreSmartPalletCriteria(){super.ignoreSearchProperty(SMART_PALLET_PROPERTY);
return this;
}
	public Goods addSmartPalletCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSmartPalletCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSmartPallet(SmartPallet smartPallet){
		if(smartPallet != null) { setSmartPallet(smartPallet);}
	}

	
	public void clearSmartPallet(){
		setSmartPallet ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setShippingSpace(ShippingSpace shippingSpace){ShippingSpace oldShippingSpace = this.shippingSpace;ShippingSpace newShippingSpace = shippingSpace;this.shippingSpace = newShippingSpace;}
	public ShippingSpace shippingSpace(){
doLoad();
return getShippingSpace();
}
	public ShippingSpace getShippingSpace(){
		return this.shippingSpace;
	}
	public Goods updateShippingSpace(ShippingSpace shippingSpace){ShippingSpace oldShippingSpace = this.shippingSpace;ShippingSpace newShippingSpace = shippingSpace;if(!shouldReplaceBy(newShippingSpace, oldShippingSpace)){return this;}this.shippingSpace = newShippingSpace;addPropertyChange(SHIPPING_SPACE_PROPERTY, oldShippingSpace, newShippingSpace);this.changed = true;setChecked(false);return this;}
	public Goods orderByShippingSpace(boolean asc){
doAddOrderBy(SHIPPING_SPACE_PROPERTY, asc);
return this;
}
	public SearchCriteria createShippingSpaceCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SHIPPING_SPACE_PROPERTY, operator, parameters);
}
	public Goods ignoreShippingSpaceCriteria(){super.ignoreSearchProperty(SHIPPING_SPACE_PROPERTY);
return this;
}
	public Goods addShippingSpaceCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createShippingSpaceCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeShippingSpace(ShippingSpace shippingSpace){
		if(shippingSpace != null) { setShippingSpace(shippingSpace);}
	}

	
	public void clearShippingSpace(){
		setShippingSpace ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setTransportTask(TransportTask transportTask){TransportTask oldTransportTask = this.transportTask;TransportTask newTransportTask = transportTask;this.transportTask = newTransportTask;}
	public TransportTask transportTask(){
doLoad();
return getTransportTask();
}
	public TransportTask getTransportTask(){
		return this.transportTask;
	}
	public Goods updateTransportTask(TransportTask transportTask){TransportTask oldTransportTask = this.transportTask;TransportTask newTransportTask = transportTask;if(!shouldReplaceBy(newTransportTask, oldTransportTask)){return this;}this.transportTask = newTransportTask;addPropertyChange(TRANSPORT_TASK_PROPERTY, oldTransportTask, newTransportTask);this.changed = true;setChecked(false);return this;}
	public Goods orderByTransportTask(boolean asc){
doAddOrderBy(TRANSPORT_TASK_PROPERTY, asc);
return this;
}
	public SearchCriteria createTransportTaskCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TRANSPORT_TASK_PROPERTY, operator, parameters);
}
	public Goods ignoreTransportTaskCriteria(){super.ignoreSearchProperty(TRANSPORT_TASK_PROPERTY);
return this;
}
	public Goods addTransportTaskCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTransportTaskCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTransportTask(TransportTask transportTask){
		if(transportTask != null) { setTransportTask(transportTask);}
	}

	
	public void clearTransportTask(){
		setTransportTask ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setRetailStore(RetailStore retailStore){RetailStore oldRetailStore = this.retailStore;RetailStore newRetailStore = retailStore;this.retailStore = newRetailStore;}
	public RetailStore retailStore(){
doLoad();
return getRetailStore();
}
	public RetailStore getRetailStore(){
		return this.retailStore;
	}
	public Goods updateRetailStore(RetailStore retailStore){RetailStore oldRetailStore = this.retailStore;RetailStore newRetailStore = retailStore;if(!shouldReplaceBy(newRetailStore, oldRetailStore)){return this;}this.retailStore = newRetailStore;addPropertyChange(RETAIL_STORE_PROPERTY, oldRetailStore, newRetailStore);this.changed = true;setChecked(false);return this;}
	public Goods orderByRetailStore(boolean asc){
doAddOrderBy(RETAIL_STORE_PROPERTY, asc);
return this;
}
	public SearchCriteria createRetailStoreCriteria(QueryOperator operator, Object... parameters){
return createCriteria(RETAIL_STORE_PROPERTY, operator, parameters);
}
	public Goods ignoreRetailStoreCriteria(){super.ignoreSearchProperty(RETAIL_STORE_PROPERTY);
return this;
}
	public Goods addRetailStoreCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRetailStoreCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRetailStore(RetailStore retailStore){
		if(retailStore != null) { setRetailStore(retailStore);}
	}

	
	public void clearRetailStore(){
		setRetailStore ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setBizOrder(SupplyOrder bizOrder){SupplyOrder oldBizOrder = this.bizOrder;SupplyOrder newBizOrder = bizOrder;this.bizOrder = newBizOrder;}
	public SupplyOrder bizOrder(){
doLoad();
return getBizOrder();
}
	public SupplyOrder getBizOrder(){
		return this.bizOrder;
	}
	public Goods updateBizOrder(SupplyOrder bizOrder){SupplyOrder oldBizOrder = this.bizOrder;SupplyOrder newBizOrder = bizOrder;if(!shouldReplaceBy(newBizOrder, oldBizOrder)){return this;}this.bizOrder = newBizOrder;addPropertyChange(BIZ_ORDER_PROPERTY, oldBizOrder, newBizOrder);this.changed = true;setChecked(false);return this;}
	public Goods orderByBizOrder(boolean asc){
doAddOrderBy(BIZ_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createBizOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BIZ_ORDER_PROPERTY, operator, parameters);
}
	public Goods ignoreBizOrderCriteria(){super.ignoreSearchProperty(BIZ_ORDER_PROPERTY);
return this;
}
	public Goods addBizOrderCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBizOrderCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBizOrder(SupplyOrder bizOrder){
		if(bizOrder != null) { setBizOrder(bizOrder);}
	}

	
	public void clearBizOrder(){
		setBizOrder ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setRetailStoreOrder(RetailStoreOrder retailStoreOrder){RetailStoreOrder oldRetailStoreOrder = this.retailStoreOrder;RetailStoreOrder newRetailStoreOrder = retailStoreOrder;this.retailStoreOrder = newRetailStoreOrder;}
	public RetailStoreOrder retailStoreOrder(){
doLoad();
return getRetailStoreOrder();
}
	public RetailStoreOrder getRetailStoreOrder(){
		return this.retailStoreOrder;
	}
	public Goods updateRetailStoreOrder(RetailStoreOrder retailStoreOrder){RetailStoreOrder oldRetailStoreOrder = this.retailStoreOrder;RetailStoreOrder newRetailStoreOrder = retailStoreOrder;if(!shouldReplaceBy(newRetailStoreOrder, oldRetailStoreOrder)){return this;}this.retailStoreOrder = newRetailStoreOrder;addPropertyChange(RETAIL_STORE_ORDER_PROPERTY, oldRetailStoreOrder, newRetailStoreOrder);this.changed = true;setChecked(false);return this;}
	public Goods orderByRetailStoreOrder(boolean asc){
doAddOrderBy(RETAIL_STORE_ORDER_PROPERTY, asc);
return this;
}
	public SearchCriteria createRetailStoreOrderCriteria(QueryOperator operator, Object... parameters){
return createCriteria(RETAIL_STORE_ORDER_PROPERTY, operator, parameters);
}
	public Goods ignoreRetailStoreOrderCriteria(){super.ignoreSearchProperty(RETAIL_STORE_ORDER_PROPERTY);
return this;
}
	public Goods addRetailStoreOrderCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRetailStoreOrderCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRetailStoreOrder(RetailStoreOrder retailStoreOrder){
		if(retailStoreOrder != null) { setRetailStoreOrder(retailStoreOrder);}
	}

	
	public void clearRetailStoreOrder(){
		setRetailStoreOrder ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public Goods updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Goods orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Goods ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Goods addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<GoodsMovement> goodsMovementList(){
    
    doLoadChild(GOODS_MOVEMENT_LIST);
    
    return getGoodsMovementList();
  }


	public  void setGoodsMovementList(SmartList<GoodsMovement> goodsMovementList){
		for( GoodsMovement goodsMovement:goodsMovementList){
			goodsMovement.setGoods(this);
		}

		this.mGoodsMovementList = goodsMovementList;
		this.mGoodsMovementList.setListInternalName (GOODS_MOVEMENT_LIST );

	}

	public  Goods addGoodsMovement(GoodsMovement goodsMovement){
		goodsMovement.setGoods(this);
		getGoodsMovementList().add(goodsMovement);
		return this;
	}
	public  Goods addGoodsMovementList(SmartList<GoodsMovement> goodsMovementList){
		for( GoodsMovement goodsMovement:goodsMovementList){
			goodsMovement.setGoods(this);
		}
		getGoodsMovementList().addAll(goodsMovementList);
		return this;
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


	public static Goods createWith(RetailscmUserContext userContext, ThrowingFunction<Goods,Goods,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<Goods> customCreator = mapper.findCustomCreator(Goods.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    Goods result = new Goods();
    result.setName(mapper.tryToGet(Goods.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setRfid(mapper.tryToGet(Goods.class, RFID_PROPERTY, String.class,
        1, false, result.getRfid(), params));
    result.setUom(mapper.tryToGet(Goods.class, UOM_PROPERTY, String.class,
        2, false, result.getUom(), params));
    result.setMaxPackage(mapper.tryToGet(Goods.class, MAX_PACKAGE_PROPERTY, int.class,
        0, true, result.getMaxPackage(), params));
    result.setExpireTime(mapper.tryToGet(Goods.class, EXPIRE_TIME_PROPERTY, Date.class,
        0, true, result.getExpireTime(), params));
    result.setSku(mapper.tryToGet(Goods.class, SKU_PROPERTY, Sku.class,
        0, true, result.getSku(), params));
    result.setReceivingSpace(mapper.tryToGet(Goods.class, RECEIVING_SPACE_PROPERTY, ReceivingSpace.class,
        0, true, result.getReceivingSpace(), params));
    result.setGoodsAllocation(mapper.tryToGet(Goods.class, GOODS_ALLOCATION_PROPERTY, GoodsAllocation.class,
        0, true, result.getGoodsAllocation(), params));
    result.setSmartPallet(mapper.tryToGet(Goods.class, SMART_PALLET_PROPERTY, SmartPallet.class,
        0, true, result.getSmartPallet(), params));
    result.setShippingSpace(mapper.tryToGet(Goods.class, SHIPPING_SPACE_PROPERTY, ShippingSpace.class,
        0, true, result.getShippingSpace(), params));
    result.setTransportTask(mapper.tryToGet(Goods.class, TRANSPORT_TASK_PROPERTY, TransportTask.class,
        0, true, result.getTransportTask(), params));
    result.setRetailStore(mapper.tryToGet(Goods.class, RETAIL_STORE_PROPERTY, RetailStore.class,
        0, true, result.getRetailStore(), params));
    result.setBizOrder(mapper.tryToGet(Goods.class, BIZ_ORDER_PROPERTY, SupplyOrder.class,
        0, true, result.getBizOrder(), params));
    result.setRetailStoreOrder(mapper.tryToGet(Goods.class, RETAIL_STORE_ORDER_PROPERTY, RetailStoreOrder.class,
        0, true, result.getRetailStoreOrder(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixGoods(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      GoodsTokens tokens = mapper.findParamByClass(params, GoodsTokens.class);
      if (tokens == null) {
        tokens = GoodsTokens.start();
      }
      result = userContext.getManagerGroup().getGoodsManager().internalSaveGoods(userContext, result, tokens.done());
      
    }
    return result;
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
		updateMaxPackage(this.maxPackage +  incMaxPackage);
	}
	public void decreaseMaxPackage(int decMaxPackage){
		updateMaxPackage(this.maxPackage - decMaxPackage);
	}
	

}

