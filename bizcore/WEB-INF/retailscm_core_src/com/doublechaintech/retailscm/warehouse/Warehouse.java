
package com.doublechaintech.retailscm.warehouse;

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
	
	public String getDisplayName(){
	
		String displayName = getLocation();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mLocation           ;
	protected		String              	mContactNumber      ;
	protected		String              	mTotalArea          ;
	protected		RetailStoreCountryCenter	mOwner              ;
	protected		BigDecimal          	mLatitude           ;
	protected		BigDecimal          	mLongitude          ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
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
		return warehouse;
	}
	public 	static Warehouse refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setOwner( null );

		this.changed = true;
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
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public Warehouse updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}
	
	
	public void setLocation(String location){
		this.mLocation = trimString(location);;
	}
	public String getLocation(){
		return this.mLocation;
	}
	public Warehouse updateLocation(String location){
		this.mLocation = trimString(location);;
		this.changed = true;
		return this;
	}
	public void mergeLocation(String location){
		if(location != null) { setLocation(location);}
	}
	
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	public Warehouse updateContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
		this.changed = true;
		return this;
	}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}
	
	
	public void setTotalArea(String totalArea){
		this.mTotalArea = trimString(totalArea);;
	}
	public String getTotalArea(){
		return this.mTotalArea;
	}
	public Warehouse updateTotalArea(String totalArea){
		this.mTotalArea = trimString(totalArea);;
		this.changed = true;
		return this;
	}
	public void mergeTotalArea(String totalArea){
		if(totalArea != null) { setTotalArea(totalArea);}
	}
	
	
	public void setOwner(RetailStoreCountryCenter owner){
		this.mOwner = owner;;
	}
	public RetailStoreCountryCenter getOwner(){
		return this.mOwner;
	}
	public Warehouse updateOwner(RetailStoreCountryCenter owner){
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
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public Warehouse updateLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
		this.changed = true;
		return this;
	}
	public void mergeLatitude(BigDecimal latitude){
		setLatitude(latitude);
	}
	
	
	public void setLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
	}
	public BigDecimal getLongitude(){
		return this.mLongitude;
	}
	public Warehouse updateLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
		this.changed = true;
		return this;
	}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public Warehouse updateLastUpdateTime(DateTime lastUpdateTime){
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
	public Warehouse updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
	public  void setStorageSpaceList(SmartList<StorageSpace> storageSpaceList){
		for( StorageSpace storageSpace:storageSpaceList){
			storageSpace.setWarehouse(this);
		}

		this.mStorageSpaceList = storageSpaceList;
		this.mStorageSpaceList.setListInternalName (STORAGE_SPACE_LIST );
		
	}
	
	public  void addStorageSpace(StorageSpace storageSpace){
		storageSpace.setWarehouse(this);
		getStorageSpaceList().add(storageSpace);
	}
	public  void addStorageSpaceList(SmartList<StorageSpace> storageSpaceList){
		for( StorageSpace storageSpace:storageSpaceList){
			storageSpace.setWarehouse(this);
		}
		getStorageSpaceList().addAll(storageSpaceList);
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
	public  void setSmartPalletList(SmartList<SmartPallet> smartPalletList){
		for( SmartPallet smartPallet:smartPalletList){
			smartPallet.setWarehouse(this);
		}

		this.mSmartPalletList = smartPalletList;
		this.mSmartPalletList.setListInternalName (SMART_PALLET_LIST );
		
	}
	
	public  void addSmartPallet(SmartPallet smartPallet){
		smartPallet.setWarehouse(this);
		getSmartPalletList().add(smartPallet);
	}
	public  void addSmartPalletList(SmartList<SmartPallet> smartPalletList){
		for( SmartPallet smartPallet:smartPalletList){
			smartPallet.setWarehouse(this);
		}
		getSmartPalletList().addAll(smartPalletList);
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
	public  void setSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList){
		for( SupplierSpace supplierSpace:supplierSpaceList){
			supplierSpace.setWarehouse(this);
		}

		this.mSupplierSpaceList = supplierSpaceList;
		this.mSupplierSpaceList.setListInternalName (SUPPLIER_SPACE_LIST );
		
	}
	
	public  void addSupplierSpace(SupplierSpace supplierSpace){
		supplierSpace.setWarehouse(this);
		getSupplierSpaceList().add(supplierSpace);
	}
	public  void addSupplierSpaceList(SmartList<SupplierSpace> supplierSpaceList){
		for( SupplierSpace supplierSpace:supplierSpaceList){
			supplierSpace.setWarehouse(this);
		}
		getSupplierSpaceList().addAll(supplierSpaceList);
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
	public  void setReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList){
		for( ReceivingSpace receivingSpace:receivingSpaceList){
			receivingSpace.setWarehouse(this);
		}

		this.mReceivingSpaceList = receivingSpaceList;
		this.mReceivingSpaceList.setListInternalName (RECEIVING_SPACE_LIST );
		
	}
	
	public  void addReceivingSpace(ReceivingSpace receivingSpace){
		receivingSpace.setWarehouse(this);
		getReceivingSpaceList().add(receivingSpace);
	}
	public  void addReceivingSpaceList(SmartList<ReceivingSpace> receivingSpaceList){
		for( ReceivingSpace receivingSpace:receivingSpaceList){
			receivingSpace.setWarehouse(this);
		}
		getReceivingSpaceList().addAll(receivingSpaceList);
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
	public  void setShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList){
		for( ShippingSpace shippingSpace:shippingSpaceList){
			shippingSpace.setWarehouse(this);
		}

		this.mShippingSpaceList = shippingSpaceList;
		this.mShippingSpaceList.setListInternalName (SHIPPING_SPACE_LIST );
		
	}
	
	public  void addShippingSpace(ShippingSpace shippingSpace){
		shippingSpace.setWarehouse(this);
		getShippingSpaceList().add(shippingSpace);
	}
	public  void addShippingSpaceList(SmartList<ShippingSpace> shippingSpaceList){
		for( ShippingSpace shippingSpace:shippingSpaceList){
			shippingSpace.setWarehouse(this);
		}
		getShippingSpaceList().addAll(shippingSpaceList);
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
	public  void setDamageSpaceList(SmartList<DamageSpace> damageSpaceList){
		for( DamageSpace damageSpace:damageSpaceList){
			damageSpace.setWarehouse(this);
		}

		this.mDamageSpaceList = damageSpaceList;
		this.mDamageSpaceList.setListInternalName (DAMAGE_SPACE_LIST );
		
	}
	
	public  void addDamageSpace(DamageSpace damageSpace){
		damageSpace.setWarehouse(this);
		getDamageSpaceList().add(damageSpace);
	}
	public  void addDamageSpaceList(SmartList<DamageSpace> damageSpaceList){
		for( DamageSpace damageSpace:damageSpaceList){
			damageSpace.setWarehouse(this);
		}
		getDamageSpaceList().addAll(damageSpaceList);
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
	public  void setWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList){
		for( WarehouseAsset warehouseAsset:warehouseAssetList){
			warehouseAsset.setOwner(this);
		}

		this.mWarehouseAssetList = warehouseAssetList;
		this.mWarehouseAssetList.setListInternalName (WAREHOUSE_ASSET_LIST );
		
	}
	
	public  void addWarehouseAsset(WarehouseAsset warehouseAsset){
		warehouseAsset.setOwner(this);
		getWarehouseAssetList().add(warehouseAsset);
	}
	public  void addWarehouseAssetList(SmartList<WarehouseAsset> warehouseAssetList){
		for( WarehouseAsset warehouseAsset:warehouseAssetList){
			warehouseAsset.setOwner(this);
		}
		getWarehouseAssetList().addAll(warehouseAssetList);
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

