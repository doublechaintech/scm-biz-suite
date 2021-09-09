
package com.doublechaintech.retailscm.warehouse;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAsset;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpace;
import com.doublechaintech.retailscm.smartpallet.SmartPallet;
import com.doublechaintech.retailscm.shippingspace.ShippingSpace;
import com.doublechaintech.retailscm.storagespace.StorageSpace;









@JsonSerialize(using = WarehouseSerializer.class)
public class Warehouse extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String TOTAL_AREA_PROPERTY            = "totalArea"         ;
	public static final String OWNER_PROPERTY                 = "owner"             ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String STORAGE_SPACE_LIST                       = "storageSpaceList"  ;
	public static final String SMART_PALLET_LIST                        = "smartPalletList"   ;
	public static final String SUPPLIER_SPACE_LIST                      = "supplierSpaceList" ;
	public static final String RECEIVING_SPACE_LIST                     = "receivingSpaceList";
	public static final String SHIPPING_SPACE_LIST                      = "shippingSpaceList" ;
	public static final String DAMAGE_SPACE_LIST                        = "damageSpaceList"   ;
	public static final String WAREHOUSE_ASSET_LIST                     = "warehouseAssetList";

	public static final String INTERNAL_TYPE="Warehouse";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LOCATION_PROPERTY, "location", "位置")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CONTACT_NUMBER_PROPERTY, "contact_number", "联系电话")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TOTAL_AREA_PROPERTY, "total_area", "总面积")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(OWNER_PROPERTY, "retail_store_country_center", "业主")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
        .withType("double", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
        .withType("double", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(STORAGE_SPACE_LIST, "warehouse", "存储空间列表")
        .withType("storage_space", StorageSpace.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SMART_PALLET_LIST, "warehouse", "智能托盘清单")
        .withType("smart_pallet", SmartPallet.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SUPPLIER_SPACE_LIST, "warehouse", "供应商空间列表")
        .withType("supplier_space", SupplierSpace.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(RECEIVING_SPACE_LIST, "warehouse", "接收空间列表")
        .withType("receiving_space", ReceivingSpace.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SHIPPING_SPACE_LIST, "warehouse", "舱位列表")
        .withType("shipping_space", ShippingSpace.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(DAMAGE_SPACE_LIST, "warehouse", "破坏空间列表")
        .withType("damage_space", DamageSpace.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(WAREHOUSE_ASSET_LIST, "owner", "仓库资产列表")
        .withType("warehouse_asset", WarehouseAsset.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,LOCATION_PROPERTY ,CONTACT_NUMBER_PROPERTY ,TOTAL_AREA_PROPERTY ,OWNER_PROPERTY ,LATITUDE_PROPERTY ,LONGITUDE_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(STORAGE_SPACE_LIST, "warehouse");
    	
    	    refers.put(SMART_PALLET_LIST, "warehouse");
    	
    	    refers.put(SUPPLIER_SPACE_LIST, "warehouse");
    	
    	    refers.put(RECEIVING_SPACE_LIST, "warehouse");
    	
    	    refers.put(SHIPPING_SPACE_LIST, "warehouse");
    	
    	    refers.put(DAMAGE_SPACE_LIST, "warehouse");
    	
    	    refers.put(WAREHOUSE_ASSET_LIST, "owner");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(STORAGE_SPACE_LIST, StorageSpace.class);
        	
        	    refers.put(SMART_PALLET_LIST, SmartPallet.class);
        	
        	    refers.put(SUPPLIER_SPACE_LIST, SupplierSpace.class);
        	
        	    refers.put(RECEIVING_SPACE_LIST, ReceivingSpace.class);
        	
        	    refers.put(SHIPPING_SPACE_LIST, ShippingSpace.class);
        	
        	    refers.put(DAMAGE_SPACE_LIST, DamageSpace.class);
        	
        	    refers.put(WAREHOUSE_ASSET_LIST, WarehouseAsset.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(OWNER_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public Warehouse want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Warehouse wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getLocation();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	location            ;
	protected		String              	contactNumber       ;
	protected		String              	totalArea           ;
	protected		RetailStoreCountryCenter	owner               ;
	protected		BigDecimal          	latitude            ;
	protected		BigDecimal          	longitude           ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<StorageSpace>	mStorageSpaceList   ;
	protected		SmartList<SmartPallet>	mSmartPalletList    ;
	protected		SmartList<SupplierSpace>	mSupplierSpaceList  ;
	protected		SmartList<ReceivingSpace>	mReceivingSpaceList ;
	protected		SmartList<ShippingSpace>	mShippingSpaceList  ;
	protected		SmartList<DamageSpace>	mDamageSpaceList    ;
	protected		SmartList<WarehouseAsset>	mWarehouseAssetList ;



	public 	Warehouse(){
		// lazy load for all the properties
	}
	public 	static Warehouse withId(String id){
		Warehouse warehouse = new Warehouse();
		warehouse.setId(id);
		warehouse.setVersion(Integer.MAX_VALUE);
		warehouse.setChecked(true);
		return warehouse;
	}
	public 	static Warehouse refById(String id){
		return withId(id);
	}

  public Warehouse limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Warehouse limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Warehouse searchExample(){
    Warehouse warehouse = new Warehouse();
    		warehouse.setVersion(UNSET_INT);

    return warehouse;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(TOTAL_AREA_PROPERTY.equals(property)){
			changeTotalAreaProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeLocationProperty(String newValueExpr){
	
		String oldValue = getLocation();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLocation(newValue);
		this.onChangeProperty(LOCATION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeContactNumberProperty(String newValueExpr){
	
		String oldValue = getContactNumber();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateContactNumber(newValue);
		this.onChangeProperty(CONTACT_NUMBER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeTotalAreaProperty(String newValueExpr){
	
		String oldValue = getTotalArea();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateTotalArea(newValue);
		this.onChangeProperty(TOTAL_AREA_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLatitudeProperty(String newValueExpr){
	
		BigDecimal oldValue = getLatitude();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLatitude(newValue);
		this.onChangeProperty(LATITUDE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeLongitudeProperty(String newValueExpr){
	
		BigDecimal oldValue = getLongitude();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateLongitude(newValue);
		this.onChangeProperty(LONGITUDE_PROPERTY, oldValue, newValue);
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

		if(LOCATION_PROPERTY.equals(property)){
			return getLocation();
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			return getContactNumber();
		}
		if(TOTAL_AREA_PROPERTY.equals(property)){
			return getTotalArea();
		}
		if(OWNER_PROPERTY.equals(property)){
			return getOwner();
		}
		if(LATITUDE_PROPERTY.equals(property)){
			return getLatitude();
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			return getLongitude();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(STORAGE_SPACE_LIST.equals(property)){
			List<BaseEntity> list = getStorageSpaceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SMART_PALLET_LIST.equals(property)){
			List<BaseEntity> list = getSmartPalletList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SUPPLIER_SPACE_LIST.equals(property)){
			List<BaseEntity> list = getSupplierSpaceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RECEIVING_SPACE_LIST.equals(property)){
			List<BaseEntity> list = getReceivingSpaceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SHIPPING_SPACE_LIST.equals(property)){
			List<BaseEntity> list = getShippingSpaceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(DAMAGE_SPACE_LIST.equals(property)){
			List<BaseEntity> list = getDamageSpaceList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(WAREHOUSE_ASSET_LIST.equals(property)){
			List<BaseEntity> list = getWarehouseAssetList().stream().map(item->item).collect(Collectors.toList());
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
	public Warehouse updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Warehouse orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Warehouse ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Warehouse addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setLocation(String location){String oldLocation = this.location;String newLocation = trimString(location);this.location = newLocation;}
	public String location(){
doLoad();
return getLocation();
}
	public String getLocation(){
		return this.location;
	}
	public Warehouse updateLocation(String location){String oldLocation = this.location;String newLocation = trimString(location);if(!shouldReplaceBy(newLocation, oldLocation)){return this;}this.location = newLocation;addPropertyChange(LOCATION_PROPERTY, oldLocation, newLocation);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByLocation(boolean asc){
doAddOrderBy(LOCATION_PROPERTY, asc);
return this;
}
	public SearchCriteria createLocationCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LOCATION_PROPERTY, operator, parameters);
}
	public Warehouse ignoreLocationCriteria(){super.ignoreSearchProperty(LOCATION_PROPERTY);
return this;
}
	public Warehouse addLocationCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLocationCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLocation(String location){
		if(location != null) { setLocation(location);}
	}

	
	public void setContactNumber(String contactNumber){String oldContactNumber = this.contactNumber;String newContactNumber = trimString(contactNumber);this.contactNumber = newContactNumber;}
	public String contactNumber(){
doLoad();
return getContactNumber();
}
	public String getContactNumber(){
		return this.contactNumber;
	}
	public Warehouse updateContactNumber(String contactNumber){String oldContactNumber = this.contactNumber;String newContactNumber = trimString(contactNumber);if(!shouldReplaceBy(newContactNumber, oldContactNumber)){return this;}this.contactNumber = newContactNumber;addPropertyChange(CONTACT_NUMBER_PROPERTY, oldContactNumber, newContactNumber);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByContactNumber(boolean asc){
doAddOrderBy(CONTACT_NUMBER_PROPERTY, asc);
return this;
}
	public SearchCriteria createContactNumberCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONTACT_NUMBER_PROPERTY, operator, parameters);
}
	public Warehouse ignoreContactNumberCriteria(){super.ignoreSearchProperty(CONTACT_NUMBER_PROPERTY);
return this;
}
	public Warehouse addContactNumberCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createContactNumberCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}

	
	public void setTotalArea(String totalArea){String oldTotalArea = this.totalArea;String newTotalArea = trimString(totalArea);this.totalArea = newTotalArea;}
	public String totalArea(){
doLoad();
return getTotalArea();
}
	public String getTotalArea(){
		return this.totalArea;
	}
	public Warehouse updateTotalArea(String totalArea){String oldTotalArea = this.totalArea;String newTotalArea = trimString(totalArea);if(!shouldReplaceBy(newTotalArea, oldTotalArea)){return this;}this.totalArea = newTotalArea;addPropertyChange(TOTAL_AREA_PROPERTY, oldTotalArea, newTotalArea);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByTotalArea(boolean asc){
doAddOrderBy(TOTAL_AREA_PROPERTY, asc);
return this;
}
	public SearchCriteria createTotalAreaCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TOTAL_AREA_PROPERTY, operator, parameters);
}
	public Warehouse ignoreTotalAreaCriteria(){super.ignoreSearchProperty(TOTAL_AREA_PROPERTY);
return this;
}
	public Warehouse addTotalAreaCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTotalAreaCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTotalArea(String totalArea){
		if(totalArea != null) { setTotalArea(totalArea);}
	}

	
	public void setOwner(RetailStoreCountryCenter owner){RetailStoreCountryCenter oldOwner = this.owner;RetailStoreCountryCenter newOwner = owner;this.owner = newOwner;}
	public RetailStoreCountryCenter owner(){
doLoad();
return getOwner();
}
	public RetailStoreCountryCenter getOwner(){
		return this.owner;
	}
	public Warehouse updateOwner(RetailStoreCountryCenter owner){RetailStoreCountryCenter oldOwner = this.owner;RetailStoreCountryCenter newOwner = owner;if(!shouldReplaceBy(newOwner, oldOwner)){return this;}this.owner = newOwner;addPropertyChange(OWNER_PROPERTY, oldOwner, newOwner);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByOwner(boolean asc){
doAddOrderBy(OWNER_PROPERTY, asc);
return this;
}
	public SearchCriteria createOwnerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(OWNER_PROPERTY, operator, parameters);
}
	public Warehouse ignoreOwnerCriteria(){super.ignoreSearchProperty(OWNER_PROPERTY);
return this;
}
	public Warehouse addOwnerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createOwnerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeOwner(RetailStoreCountryCenter owner){
		if(owner != null) { setOwner(owner);}
	}

	
	public void clearOwner(){
		setOwner ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setLatitude(BigDecimal latitude){BigDecimal oldLatitude = this.latitude;BigDecimal newLatitude = latitude;this.latitude = newLatitude;}
	public BigDecimal latitude(){
doLoad();
return getLatitude();
}
	public BigDecimal getLatitude(){
		return this.latitude;
	}
	public Warehouse updateLatitude(BigDecimal latitude){BigDecimal oldLatitude = this.latitude;BigDecimal newLatitude = latitude;if(!shouldReplaceBy(newLatitude, oldLatitude)){return this;}this.latitude = newLatitude;addPropertyChange(LATITUDE_PROPERTY, oldLatitude, newLatitude);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByLatitude(boolean asc){
doAddOrderBy(LATITUDE_PROPERTY, asc);
return this;
}
	public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LATITUDE_PROPERTY, operator, parameters);
}
	public Warehouse ignoreLatitudeCriteria(){super.ignoreSearchProperty(LATITUDE_PROPERTY);
return this;
}
	public Warehouse addLatitudeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLatitudeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLatitude(BigDecimal latitude){
		setLatitude(latitude);
	}

	
	public void setLongitude(BigDecimal longitude){BigDecimal oldLongitude = this.longitude;BigDecimal newLongitude = longitude;this.longitude = newLongitude;}
	public BigDecimal longitude(){
doLoad();
return getLongitude();
}
	public BigDecimal getLongitude(){
		return this.longitude;
	}
	public Warehouse updateLongitude(BigDecimal longitude){BigDecimal oldLongitude = this.longitude;BigDecimal newLongitude = longitude;if(!shouldReplaceBy(newLongitude, oldLongitude)){return this;}this.longitude = newLongitude;addPropertyChange(LONGITUDE_PROPERTY, oldLongitude, newLongitude);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByLongitude(boolean asc){
doAddOrderBy(LONGITUDE_PROPERTY, asc);
return this;
}
	public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
}
	public Warehouse ignoreLongitudeCriteria(){super.ignoreSearchProperty(LONGITUDE_PROPERTY);
return this;
}
	public Warehouse addLongitudeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public Warehouse updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public Warehouse ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public Warehouse addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
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
	public Warehouse updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Warehouse orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Warehouse ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Warehouse addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<StorageSpace> getStorageSpaceList(){
		if(this.mStorageSpaceList == null){
			this.mStorageSpaceList = new SmartList<StorageSpace>();
			this.mStorageSpaceList.setListInternalName (STORAGE_SPACE_LIST );
			//有名字，便于做权限控制
		}

		return this.mStorageSpaceList;
	}

  public  SmartList<StorageSpace> storageSpaceList(){
    
    doLoadChild(STORAGE_SPACE_LIST);
    
    return getStorageSpaceList();
  }


	public  void setStorageSpaceList(SmartList<StorageSpace> storageSpaceList){
		for( StorageSpace storageSpace:storageSpaceList){
			storageSpace.setWarehouse(this);
		}

		this.mStorageSpaceList = storageSpaceList;
		this.mStorageSpaceList.setListInternalName (STORAGE_SPACE_LIST );

	}

	public  Warehouse addStorageSpace(StorageSpace storageSpace){
		storageSpace.setWarehouse(this);
		getStorageSpaceList().add(storageSpace);
		return this;
	}
	public  Warehouse addStorageSpaceList(SmartList<StorageSpace> storageSpaceList){
		for( StorageSpace storageSpace:storageSpaceList){
			storageSpace.setWarehouse(this);
		}
		getStorageSpaceList().addAll(storageSpaceList);
		return this;
	}
	public  void mergeStorageSpaceList(SmartList<StorageSpace> storageSpaceList){
		if(storageSpaceList==null){
			return;
		}
		if(storageSpaceList.isEmpty()){
			return;
		}
		addStorageSpaceList( storageSpaceList );

	}
	public  StorageSpace removeStorageSpace(StorageSpace storageSpaceIndex){

		int index = getStorageSpaceList().indexOf(storageSpaceIndex);
        if(index < 0){
        	String message = "StorageSpace("+storageSpaceIndex.getId()+") with version='"+storageSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        StorageSpace storageSpace = getStorageSpaceList().get(index);
        // storageSpace.clearWarehouse(); //disconnect with Warehouse
        storageSpace.clearFromAll(); //disconnect with Warehouse

		boolean result = getStorageSpaceList().planToRemove(storageSpace);
        if(!result){
        	String message = "StorageSpace("+storageSpaceIndex.getId()+") with version='"+storageSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return storageSpace;


	}
	//断舍离
	public  void breakWithStorageSpace(StorageSpace storageSpace){

		if(storageSpace == null){
			return;
		}
		storageSpace.setWarehouse(null);
		//getStorageSpaceList().remove();

	}

	public  boolean hasStorageSpace(StorageSpace storageSpace){

		return getStorageSpaceList().contains(storageSpace);

	}

	public void copyStorageSpaceFrom(StorageSpace storageSpace) {

		StorageSpace storageSpaceInList = findTheStorageSpace(storageSpace);
		StorageSpace newStorageSpace = new StorageSpace();
		storageSpaceInList.copyTo(newStorageSpace);
		newStorageSpace.setVersion(0);//will trigger copy
		getStorageSpaceList().add(newStorageSpace);
		addItemToFlexiableObject(COPIED_CHILD, newStorageSpace);
	}

	public  StorageSpace findTheStorageSpace(StorageSpace storageSpace){

		int index =  getStorageSpaceList().indexOf(storageSpace);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "StorageSpace("+storageSpace.getId()+") with version='"+storageSpace.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getStorageSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpStorageSpaceList(){
		getStorageSpaceList().clear();
	}





	public  SmartList<SmartPallet> getSmartPalletList(){
		if(this.mSmartPalletList == null){
			this.mSmartPalletList = new SmartList<SmartPallet>();
			this.mSmartPalletList.setListInternalName (SMART_PALLET_LIST );
			//有名字，便于做权限控制
		}

		return this.mSmartPalletList;
	}

  public  SmartList<SmartPallet> smartPalletList(){
    
    doLoadChild(SMART_PALLET_LIST);
    
    return getSmartPalletList();
  }


	public  void setSmartPalletList(SmartList<SmartPallet> smartPalletList){
		for( SmartPallet smartPallet:smartPalletList){
			smartPallet.setWarehouse(this);
		}

		this.mSmartPalletList = smartPalletList;
		this.mSmartPalletList.setListInternalName (SMART_PALLET_LIST );

	}

	public  Warehouse addSmartPallet(SmartPallet smartPallet){
		smartPallet.setWarehouse(this);
		getSmartPalletList().add(smartPallet);
		return this;
	}
	public  Warehouse addSmartPalletList(SmartList<SmartPallet> smartPalletList){
		for( SmartPallet smartPallet:smartPalletList){
			smartPallet.setWarehouse(this);
		}
		getSmartPalletList().addAll(smartPalletList);
		return this;
	}
	public  void mergeSmartPalletList(SmartList<SmartPallet> smartPalletList){
		if(smartPalletList==null){
			return;
		}
		if(smartPalletList.isEmpty()){
			return;
		}
		addSmartPalletList( smartPalletList );

	}
	public  SmartPallet removeSmartPallet(SmartPallet smartPalletIndex){

		int index = getSmartPalletList().indexOf(smartPalletIndex);
        if(index < 0){
        	String message = "SmartPallet("+smartPalletIndex.getId()+") with version='"+smartPalletIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SmartPallet smartPallet = getSmartPalletList().get(index);
        // smartPallet.clearWarehouse(); //disconnect with Warehouse
        smartPallet.clearFromAll(); //disconnect with Warehouse

		boolean result = getSmartPalletList().planToRemove(smartPallet);
        if(!result){
        	String message = "SmartPallet("+smartPalletIndex.getId()+") with version='"+smartPalletIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return smartPallet;


	}
	//断舍离
	public  void breakWithSmartPallet(SmartPallet smartPallet){

		if(smartPallet == null){
			return;
		}
		smartPallet.setWarehouse(null);
		//getSmartPalletList().remove();

	}

	public  boolean hasSmartPallet(SmartPallet smartPallet){

		return getSmartPalletList().contains(smartPallet);

	}

	public void copySmartPalletFrom(SmartPallet smartPallet) {

		SmartPallet smartPalletInList = findTheSmartPallet(smartPallet);
		SmartPallet newSmartPallet = new SmartPallet();
		smartPalletInList.copyTo(newSmartPallet);
		newSmartPallet.setVersion(0);//will trigger copy
		getSmartPalletList().add(newSmartPallet);
		addItemToFlexiableObject(COPIED_CHILD, newSmartPallet);
	}

	public  SmartPallet findTheSmartPallet(SmartPallet smartPallet){

		int index =  getSmartPalletList().indexOf(smartPallet);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SmartPallet("+smartPallet.getId()+") with version='"+smartPallet.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getSmartPalletList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpSmartPalletList(){
		getSmartPalletList().clear();
	}





	public  SmartList<SupplierSpace> getSupplierSpaceList(){
		if(this.mSupplierSpaceList == null){
			this.mSupplierSpaceList = new SmartList<SupplierSpace>();
			this.mSupplierSpaceList.setListInternalName (SUPPLIER_SPACE_LIST );
			//有名字，便于做权限控制
		}

		return this.mSupplierSpaceList;
	}

  public  SmartList<SupplierSpace> supplierSpaceList(){
    
    doLoadChild(SUPPLIER_SPACE_LIST);
    
    return getSupplierSpaceList();
  }


	public  void setSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList){
		for( SupplierSpace supplierSpace:supplierSpaceList){
			supplierSpace.setWarehouse(this);
		}

		this.mSupplierSpaceList = supplierSpaceList;
		this.mSupplierSpaceList.setListInternalName (SUPPLIER_SPACE_LIST );

	}

	public  Warehouse addSupplierSpace(SupplierSpace supplierSpace){
		supplierSpace.setWarehouse(this);
		getSupplierSpaceList().add(supplierSpace);
		return this;
	}
	public  Warehouse addSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList){
		for( SupplierSpace supplierSpace:supplierSpaceList){
			supplierSpace.setWarehouse(this);
		}
		getSupplierSpaceList().addAll(supplierSpaceList);
		return this;
	}
	public  void mergeSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList){
		if(supplierSpaceList==null){
			return;
		}
		if(supplierSpaceList.isEmpty()){
			return;
		}
		addSupplierSpaceList( supplierSpaceList );

	}
	public  SupplierSpace removeSupplierSpace(SupplierSpace supplierSpaceIndex){

		int index = getSupplierSpaceList().indexOf(supplierSpaceIndex);
        if(index < 0){
        	String message = "SupplierSpace("+supplierSpaceIndex.getId()+") with version='"+supplierSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplierSpace supplierSpace = getSupplierSpaceList().get(index);
        // supplierSpace.clearWarehouse(); //disconnect with Warehouse
        supplierSpace.clearFromAll(); //disconnect with Warehouse

		boolean result = getSupplierSpaceList().planToRemove(supplierSpace);
        if(!result){
        	String message = "SupplierSpace("+supplierSpaceIndex.getId()+") with version='"+supplierSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplierSpace;


	}
	//断舍离
	public  void breakWithSupplierSpace(SupplierSpace supplierSpace){

		if(supplierSpace == null){
			return;
		}
		supplierSpace.setWarehouse(null);
		//getSupplierSpaceList().remove();

	}

	public  boolean hasSupplierSpace(SupplierSpace supplierSpace){

		return getSupplierSpaceList().contains(supplierSpace);

	}

	public void copySupplierSpaceFrom(SupplierSpace supplierSpace) {

		SupplierSpace supplierSpaceInList = findTheSupplierSpace(supplierSpace);
		SupplierSpace newSupplierSpace = new SupplierSpace();
		supplierSpaceInList.copyTo(newSupplierSpace);
		newSupplierSpace.setVersion(0);//will trigger copy
		getSupplierSpaceList().add(newSupplierSpace);
		addItemToFlexiableObject(COPIED_CHILD, newSupplierSpace);
	}

	public  SupplierSpace findTheSupplierSpace(SupplierSpace supplierSpace){

		int index =  getSupplierSpaceList().indexOf(supplierSpace);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplierSpace("+supplierSpace.getId()+") with version='"+supplierSpace.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getSupplierSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpSupplierSpaceList(){
		getSupplierSpaceList().clear();
	}





	public  SmartList<ReceivingSpace> getReceivingSpaceList(){
		if(this.mReceivingSpaceList == null){
			this.mReceivingSpaceList = new SmartList<ReceivingSpace>();
			this.mReceivingSpaceList.setListInternalName (RECEIVING_SPACE_LIST );
			//有名字，便于做权限控制
		}

		return this.mReceivingSpaceList;
	}

  public  SmartList<ReceivingSpace> receivingSpaceList(){
    
    doLoadChild(RECEIVING_SPACE_LIST);
    
    return getReceivingSpaceList();
  }


	public  void setReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList){
		for( ReceivingSpace receivingSpace:receivingSpaceList){
			receivingSpace.setWarehouse(this);
		}

		this.mReceivingSpaceList = receivingSpaceList;
		this.mReceivingSpaceList.setListInternalName (RECEIVING_SPACE_LIST );

	}

	public  Warehouse addReceivingSpace(ReceivingSpace receivingSpace){
		receivingSpace.setWarehouse(this);
		getReceivingSpaceList().add(receivingSpace);
		return this;
	}
	public  Warehouse addReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList){
		for( ReceivingSpace receivingSpace:receivingSpaceList){
			receivingSpace.setWarehouse(this);
		}
		getReceivingSpaceList().addAll(receivingSpaceList);
		return this;
	}
	public  void mergeReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList){
		if(receivingSpaceList==null){
			return;
		}
		if(receivingSpaceList.isEmpty()){
			return;
		}
		addReceivingSpaceList( receivingSpaceList );

	}
	public  ReceivingSpace removeReceivingSpace(ReceivingSpace receivingSpaceIndex){

		int index = getReceivingSpaceList().indexOf(receivingSpaceIndex);
        if(index < 0){
        	String message = "ReceivingSpace("+receivingSpaceIndex.getId()+") with version='"+receivingSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ReceivingSpace receivingSpace = getReceivingSpaceList().get(index);
        // receivingSpace.clearWarehouse(); //disconnect with Warehouse
        receivingSpace.clearFromAll(); //disconnect with Warehouse

		boolean result = getReceivingSpaceList().planToRemove(receivingSpace);
        if(!result){
        	String message = "ReceivingSpace("+receivingSpaceIndex.getId()+") with version='"+receivingSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return receivingSpace;


	}
	//断舍离
	public  void breakWithReceivingSpace(ReceivingSpace receivingSpace){

		if(receivingSpace == null){
			return;
		}
		receivingSpace.setWarehouse(null);
		//getReceivingSpaceList().remove();

	}

	public  boolean hasReceivingSpace(ReceivingSpace receivingSpace){

		return getReceivingSpaceList().contains(receivingSpace);

	}

	public void copyReceivingSpaceFrom(ReceivingSpace receivingSpace) {

		ReceivingSpace receivingSpaceInList = findTheReceivingSpace(receivingSpace);
		ReceivingSpace newReceivingSpace = new ReceivingSpace();
		receivingSpaceInList.copyTo(newReceivingSpace);
		newReceivingSpace.setVersion(0);//will trigger copy
		getReceivingSpaceList().add(newReceivingSpace);
		addItemToFlexiableObject(COPIED_CHILD, newReceivingSpace);
	}

	public  ReceivingSpace findTheReceivingSpace(ReceivingSpace receivingSpace){

		int index =  getReceivingSpaceList().indexOf(receivingSpace);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ReceivingSpace("+receivingSpace.getId()+") with version='"+receivingSpace.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getReceivingSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpReceivingSpaceList(){
		getReceivingSpaceList().clear();
	}





	public  SmartList<ShippingSpace> getShippingSpaceList(){
		if(this.mShippingSpaceList == null){
			this.mShippingSpaceList = new SmartList<ShippingSpace>();
			this.mShippingSpaceList.setListInternalName (SHIPPING_SPACE_LIST );
			//有名字，便于做权限控制
		}

		return this.mShippingSpaceList;
	}

  public  SmartList<ShippingSpace> shippingSpaceList(){
    
    doLoadChild(SHIPPING_SPACE_LIST);
    
    return getShippingSpaceList();
  }


	public  void setShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList){
		for( ShippingSpace shippingSpace:shippingSpaceList){
			shippingSpace.setWarehouse(this);
		}

		this.mShippingSpaceList = shippingSpaceList;
		this.mShippingSpaceList.setListInternalName (SHIPPING_SPACE_LIST );

	}

	public  Warehouse addShippingSpace(ShippingSpace shippingSpace){
		shippingSpace.setWarehouse(this);
		getShippingSpaceList().add(shippingSpace);
		return this;
	}
	public  Warehouse addShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList){
		for( ShippingSpace shippingSpace:shippingSpaceList){
			shippingSpace.setWarehouse(this);
		}
		getShippingSpaceList().addAll(shippingSpaceList);
		return this;
	}
	public  void mergeShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList){
		if(shippingSpaceList==null){
			return;
		}
		if(shippingSpaceList.isEmpty()){
			return;
		}
		addShippingSpaceList( shippingSpaceList );

	}
	public  ShippingSpace removeShippingSpace(ShippingSpace shippingSpaceIndex){

		int index = getShippingSpaceList().indexOf(shippingSpaceIndex);
        if(index < 0){
        	String message = "ShippingSpace("+shippingSpaceIndex.getId()+") with version='"+shippingSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ShippingSpace shippingSpace = getShippingSpaceList().get(index);
        // shippingSpace.clearWarehouse(); //disconnect with Warehouse
        shippingSpace.clearFromAll(); //disconnect with Warehouse

		boolean result = getShippingSpaceList().planToRemove(shippingSpace);
        if(!result){
        	String message = "ShippingSpace("+shippingSpaceIndex.getId()+") with version='"+shippingSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return shippingSpace;


	}
	//断舍离
	public  void breakWithShippingSpace(ShippingSpace shippingSpace){

		if(shippingSpace == null){
			return;
		}
		shippingSpace.setWarehouse(null);
		//getShippingSpaceList().remove();

	}

	public  boolean hasShippingSpace(ShippingSpace shippingSpace){

		return getShippingSpaceList().contains(shippingSpace);

	}

	public void copyShippingSpaceFrom(ShippingSpace shippingSpace) {

		ShippingSpace shippingSpaceInList = findTheShippingSpace(shippingSpace);
		ShippingSpace newShippingSpace = new ShippingSpace();
		shippingSpaceInList.copyTo(newShippingSpace);
		newShippingSpace.setVersion(0);//will trigger copy
		getShippingSpaceList().add(newShippingSpace);
		addItemToFlexiableObject(COPIED_CHILD, newShippingSpace);
	}

	public  ShippingSpace findTheShippingSpace(ShippingSpace shippingSpace){

		int index =  getShippingSpaceList().indexOf(shippingSpace);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ShippingSpace("+shippingSpace.getId()+") with version='"+shippingSpace.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getShippingSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpShippingSpaceList(){
		getShippingSpaceList().clear();
	}





	public  SmartList<DamageSpace> getDamageSpaceList(){
		if(this.mDamageSpaceList == null){
			this.mDamageSpaceList = new SmartList<DamageSpace>();
			this.mDamageSpaceList.setListInternalName (DAMAGE_SPACE_LIST );
			//有名字，便于做权限控制
		}

		return this.mDamageSpaceList;
	}

  public  SmartList<DamageSpace> damageSpaceList(){
    
    doLoadChild(DAMAGE_SPACE_LIST);
    
    return getDamageSpaceList();
  }


	public  void setDamageSpaceList(SmartList<DamageSpace> damageSpaceList){
		for( DamageSpace damageSpace:damageSpaceList){
			damageSpace.setWarehouse(this);
		}

		this.mDamageSpaceList = damageSpaceList;
		this.mDamageSpaceList.setListInternalName (DAMAGE_SPACE_LIST );

	}

	public  Warehouse addDamageSpace(DamageSpace damageSpace){
		damageSpace.setWarehouse(this);
		getDamageSpaceList().add(damageSpace);
		return this;
	}
	public  Warehouse addDamageSpaceList(SmartList<DamageSpace> damageSpaceList){
		for( DamageSpace damageSpace:damageSpaceList){
			damageSpace.setWarehouse(this);
		}
		getDamageSpaceList().addAll(damageSpaceList);
		return this;
	}
	public  void mergeDamageSpaceList(SmartList<DamageSpace> damageSpaceList){
		if(damageSpaceList==null){
			return;
		}
		if(damageSpaceList.isEmpty()){
			return;
		}
		addDamageSpaceList( damageSpaceList );

	}
	public  DamageSpace removeDamageSpace(DamageSpace damageSpaceIndex){

		int index = getDamageSpaceList().indexOf(damageSpaceIndex);
        if(index < 0){
        	String message = "DamageSpace("+damageSpaceIndex.getId()+") with version='"+damageSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        DamageSpace damageSpace = getDamageSpaceList().get(index);
        // damageSpace.clearWarehouse(); //disconnect with Warehouse
        damageSpace.clearFromAll(); //disconnect with Warehouse

		boolean result = getDamageSpaceList().planToRemove(damageSpace);
        if(!result){
        	String message = "DamageSpace("+damageSpaceIndex.getId()+") with version='"+damageSpaceIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return damageSpace;


	}
	//断舍离
	public  void breakWithDamageSpace(DamageSpace damageSpace){

		if(damageSpace == null){
			return;
		}
		damageSpace.setWarehouse(null);
		//getDamageSpaceList().remove();

	}

	public  boolean hasDamageSpace(DamageSpace damageSpace){

		return getDamageSpaceList().contains(damageSpace);

	}

	public void copyDamageSpaceFrom(DamageSpace damageSpace) {

		DamageSpace damageSpaceInList = findTheDamageSpace(damageSpace);
		DamageSpace newDamageSpace = new DamageSpace();
		damageSpaceInList.copyTo(newDamageSpace);
		newDamageSpace.setVersion(0);//will trigger copy
		getDamageSpaceList().add(newDamageSpace);
		addItemToFlexiableObject(COPIED_CHILD, newDamageSpace);
	}

	public  DamageSpace findTheDamageSpace(DamageSpace damageSpace){

		int index =  getDamageSpaceList().indexOf(damageSpace);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "DamageSpace("+damageSpace.getId()+") with version='"+damageSpace.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getDamageSpaceList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpDamageSpaceList(){
		getDamageSpaceList().clear();
	}





	public  SmartList<WarehouseAsset> getWarehouseAssetList(){
		if(this.mWarehouseAssetList == null){
			this.mWarehouseAssetList = new SmartList<WarehouseAsset>();
			this.mWarehouseAssetList.setListInternalName (WAREHOUSE_ASSET_LIST );
			//有名字，便于做权限控制
		}

		return this.mWarehouseAssetList;
	}

  public  SmartList<WarehouseAsset> warehouseAssetList(){
    
    doLoadChild(WAREHOUSE_ASSET_LIST);
    
    return getWarehouseAssetList();
  }


	public  void setWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList){
		for( WarehouseAsset warehouseAsset:warehouseAssetList){
			warehouseAsset.setOwner(this);
		}

		this.mWarehouseAssetList = warehouseAssetList;
		this.mWarehouseAssetList.setListInternalName (WAREHOUSE_ASSET_LIST );

	}

	public  Warehouse addWarehouseAsset(WarehouseAsset warehouseAsset){
		warehouseAsset.setOwner(this);
		getWarehouseAssetList().add(warehouseAsset);
		return this;
	}
	public  Warehouse addWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList){
		for( WarehouseAsset warehouseAsset:warehouseAssetList){
			warehouseAsset.setOwner(this);
		}
		getWarehouseAssetList().addAll(warehouseAssetList);
		return this;
	}
	public  void mergeWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList){
		if(warehouseAssetList==null){
			return;
		}
		if(warehouseAssetList.isEmpty()){
			return;
		}
		addWarehouseAssetList( warehouseAssetList );

	}
	public  WarehouseAsset removeWarehouseAsset(WarehouseAsset warehouseAssetIndex){

		int index = getWarehouseAssetList().indexOf(warehouseAssetIndex);
        if(index < 0){
        	String message = "WarehouseAsset("+warehouseAssetIndex.getId()+") with version='"+warehouseAssetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        WarehouseAsset warehouseAsset = getWarehouseAssetList().get(index);
        // warehouseAsset.clearOwner(); //disconnect with Owner
        warehouseAsset.clearFromAll(); //disconnect with Owner

		boolean result = getWarehouseAssetList().planToRemove(warehouseAsset);
        if(!result){
        	String message = "WarehouseAsset("+warehouseAssetIndex.getId()+") with version='"+warehouseAssetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return warehouseAsset;


	}
	//断舍离
	public  void breakWithWarehouseAsset(WarehouseAsset warehouseAsset){

		if(warehouseAsset == null){
			return;
		}
		warehouseAsset.setOwner(null);
		//getWarehouseAssetList().remove();

	}

	public  boolean hasWarehouseAsset(WarehouseAsset warehouseAsset){

		return getWarehouseAssetList().contains(warehouseAsset);

	}

	public void copyWarehouseAssetFrom(WarehouseAsset warehouseAsset) {

		WarehouseAsset warehouseAssetInList = findTheWarehouseAsset(warehouseAsset);
		WarehouseAsset newWarehouseAsset = new WarehouseAsset();
		warehouseAssetInList.copyTo(newWarehouseAsset);
		newWarehouseAsset.setVersion(0);//will trigger copy
		getWarehouseAssetList().add(newWarehouseAsset);
		addItemToFlexiableObject(COPIED_CHILD, newWarehouseAsset);
	}

	public  WarehouseAsset findTheWarehouseAsset(WarehouseAsset warehouseAsset){

		int index =  getWarehouseAssetList().indexOf(warehouseAsset);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "WarehouseAsset("+warehouseAsset.getId()+") with version='"+warehouseAsset.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getWarehouseAssetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpWarehouseAssetList(){
		getWarehouseAssetList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getOwner(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getStorageSpaceList(), internalType);
		collectFromList(this, entityList, getSmartPalletList(), internalType);
		collectFromList(this, entityList, getSupplierSpaceList(), internalType);
		collectFromList(this, entityList, getReceivingSpaceList(), internalType);
		collectFromList(this, entityList, getShippingSpaceList(), internalType);
		collectFromList(this, entityList, getDamageSpaceList(), internalType);
		collectFromList(this, entityList, getWarehouseAssetList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getStorageSpaceList());
		listOfList.add( getSmartPalletList());
		listOfList.add( getSupplierSpaceList());
		listOfList.add( getReceivingSpaceList());
		listOfList.add( getShippingSpaceList());
		listOfList.add( getDamageSpaceList());
		listOfList.add( getWarehouseAssetList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getContactNumber());
		appendKeyValuePair(result, TOTAL_AREA_PROPERTY, getTotalArea());
		appendKeyValuePair(result, OWNER_PROPERTY, getOwner());
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, STORAGE_SPACE_LIST, getStorageSpaceList());
		if(!getStorageSpaceList().isEmpty()){
			appendKeyValuePair(result, "storageSpaceCount", getStorageSpaceList().getTotalCount());
			appendKeyValuePair(result, "storageSpaceCurrentPageNumber", getStorageSpaceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SMART_PALLET_LIST, getSmartPalletList());
		if(!getSmartPalletList().isEmpty()){
			appendKeyValuePair(result, "smartPalletCount", getSmartPalletList().getTotalCount());
			appendKeyValuePair(result, "smartPalletCurrentPageNumber", getSmartPalletList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SUPPLIER_SPACE_LIST, getSupplierSpaceList());
		if(!getSupplierSpaceList().isEmpty()){
			appendKeyValuePair(result, "supplierSpaceCount", getSupplierSpaceList().getTotalCount());
			appendKeyValuePair(result, "supplierSpaceCurrentPageNumber", getSupplierSpaceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RECEIVING_SPACE_LIST, getReceivingSpaceList());
		if(!getReceivingSpaceList().isEmpty()){
			appendKeyValuePair(result, "receivingSpaceCount", getReceivingSpaceList().getTotalCount());
			appendKeyValuePair(result, "receivingSpaceCurrentPageNumber", getReceivingSpaceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SHIPPING_SPACE_LIST, getShippingSpaceList());
		if(!getShippingSpaceList().isEmpty()){
			appendKeyValuePair(result, "shippingSpaceCount", getShippingSpaceList().getTotalCount());
			appendKeyValuePair(result, "shippingSpaceCurrentPageNumber", getShippingSpaceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, DAMAGE_SPACE_LIST, getDamageSpaceList());
		if(!getDamageSpaceList().isEmpty()){
			appendKeyValuePair(result, "damageSpaceCount", getDamageSpaceList().getTotalCount());
			appendKeyValuePair(result, "damageSpaceCurrentPageNumber", getDamageSpaceList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, WAREHOUSE_ASSET_LIST, getWarehouseAssetList());
		if(!getWarehouseAssetList().isEmpty()){
			appendKeyValuePair(result, "warehouseAssetCount", getWarehouseAssetList().getTotalCount());
			appendKeyValuePair(result, "warehouseAssetCurrentPageNumber", getWarehouseAssetList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof Warehouse){


			Warehouse dest =(Warehouse)baseDest;

			dest.setId(getId());
			dest.setLocation(getLocation());
			dest.setContactNumber(getContactNumber());
			dest.setTotalArea(getTotalArea());
			dest.setOwner(getOwner());
			dest.setLatitude(getLatitude());
			dest.setLongitude(getLongitude());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setStorageSpaceList(getStorageSpaceList());
			dest.setSmartPalletList(getSmartPalletList());
			dest.setSupplierSpaceList(getSupplierSpaceList());
			dest.setReceivingSpaceList(getReceivingSpaceList());
			dest.setShippingSpaceList(getShippingSpaceList());
			dest.setDamageSpaceList(getDamageSpaceList());
			dest.setWarehouseAssetList(getWarehouseAssetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof Warehouse){


			Warehouse dest =(Warehouse)baseDest;

			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeTotalArea(getTotalArea());
			dest.mergeOwner(getOwner());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeStorageSpaceList(getStorageSpaceList());
			dest.mergeSmartPalletList(getSmartPalletList());
			dest.mergeSupplierSpaceList(getSupplierSpaceList());
			dest.mergeReceivingSpaceList(getReceivingSpaceList());
			dest.mergeShippingSpaceList(getShippingSpaceList());
			dest.mergeDamageSpaceList(getDamageSpaceList());
			dest.mergeWarehouseAssetList(getWarehouseAssetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof Warehouse){


			Warehouse dest =(Warehouse)baseDest;

			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeTotalArea(getTotalArea());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getLocation(), getContactNumber(), getTotalArea(), getOwner(), getLatitude(), getLongitude(), getLastUpdateTime(), getVersion()};
	}


	public static Warehouse createWith(RetailscmUserContext userContext, ThrowingFunction<Warehouse,Warehouse,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<Warehouse> customCreator = mapper.findCustomCreator(Warehouse.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    Warehouse result = new Warehouse();
    result.setLocation(mapper.tryToGet(Warehouse.class, LOCATION_PROPERTY, String.class,
        0, false, result.getLocation(), params));
    result.setContactNumber(mapper.tryToGet(Warehouse.class, CONTACT_NUMBER_PROPERTY, String.class,
        1, false, result.getContactNumber(), params));
    result.setTotalArea(mapper.tryToGet(Warehouse.class, TOTAL_AREA_PROPERTY, String.class,
        2, false, result.getTotalArea(), params));
    result.setOwner(mapper.tryToGet(Warehouse.class, OWNER_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getOwner(), params));
    result.setLatitude(mapper.tryToGet(Warehouse.class, LATITUDE_PROPERTY, BigDecimal.class,
        0, false, result.getLatitude(), params));
    result.setLongitude(mapper.tryToGet(Warehouse.class, LONGITUDE_PROPERTY, BigDecimal.class,
        1, false, result.getLongitude(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixWarehouse(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      WarehouseTokens tokens = mapper.findParamByClass(params, WarehouseTokens.class);
      if (tokens == null) {
        tokens = WarehouseTokens.start();
      }
      result = userContext.getManagerGroup().getWarehouseManager().internalSaveWarehouse(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Warehouse{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tcontactNumber='"+getContactNumber()+"';");
		stringBuilder.append("\ttotalArea='"+getTotalArea()+"';");
		if(getOwner() != null ){
 			stringBuilder.append("\towner='RetailStoreCountryCenter("+getOwner().getId()+")';");
 		}
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

