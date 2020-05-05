
package com.doublechaintech.retailscm.goodsshelf;

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
import com.doublechaintech.retailscm.supplierspace.SupplierSpace;
import com.doublechaintech.retailscm.damagespace.DamageSpace;
import com.doublechaintech.retailscm.goodsallocation.GoodsAllocation;
import com.doublechaintech.retailscm.goodsshelfstockcount.GoodsShelfStockCount;
import com.doublechaintech.retailscm.storagespace.StorageSpace;

@JsonSerialize(using = GoodsShelfSerializer.class)
public class GoodsShelf extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String STORAGE_SPACE_PROPERTY         = "storageSpace"      ;
	public static final String SUPPLIER_SPACE_PROPERTY        = "supplierSpace"     ;
	public static final String DAMAGE_SPACE_PROPERTY          = "damageSpace"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_SHELF_STOCK_COUNT_LIST             = "goodsShelfStockCountList";
	public static final String GOODS_ALLOCATION_LIST                    = "goodsAllocationList";

	public static final String INTERNAL_TYPE="GoodsShelf";
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
	protected		StorageSpace        	mStorageSpace       ;
	protected		SupplierSpace       	mSupplierSpace      ;
	protected		DamageSpace         	mDamageSpace        ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GoodsShelfStockCount>	mGoodsShelfStockCountList;
	protected		SmartList<GoodsAllocation>	mGoodsAllocationList;

	
		
	public 	GoodsShelf(){
		// lazy load for all the properties
	}
	public 	static GoodsShelf withId(String id){
		GoodsShelf goodsShelf = new GoodsShelf();
		goodsShelf.setId(id);
		goodsShelf.setVersion(Integer.MAX_VALUE);
		return goodsShelf;
	}
	public 	static GoodsShelf refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setStorageSpace( null );
		setSupplierSpace( null );
		setDamageSpace( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
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
		if(STORAGE_SPACE_PROPERTY.equals(property)){
			return getStorageSpace();
		}
		if(SUPPLIER_SPACE_PROPERTY.equals(property)){
			return getSupplierSpace();
		}
		if(DAMAGE_SPACE_PROPERTY.equals(property)){
			return getDamageSpace();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(GOODS_SHELF_STOCK_COUNT_LIST.equals(property)){
			List<BaseEntity> list = getGoodsShelfStockCountList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(GOODS_ALLOCATION_LIST.equals(property)){
			List<BaseEntity> list = getGoodsAllocationList().stream().map(item->item).collect(Collectors.toList());
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
	public GoodsShelf updateId(String id){
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
	public GoodsShelf updateLocation(String location){
		this.mLocation = trimString(location);;
		this.changed = true;
		return this;
	}
	public void mergeLocation(String location){
		if(location != null) { setLocation(location);}
	}
	
	
	public void setStorageSpace(StorageSpace storageSpace){
		this.mStorageSpace = storageSpace;;
	}
	public StorageSpace getStorageSpace(){
		return this.mStorageSpace;
	}
	public GoodsShelf updateStorageSpace(StorageSpace storageSpace){
		this.mStorageSpace = storageSpace;;
		this.changed = true;
		return this;
	}
	public void mergeStorageSpace(StorageSpace storageSpace){
		if(storageSpace != null) { setStorageSpace(storageSpace);}
	}
	
	
	public void clearStorageSpace(){
		setStorageSpace ( null );
		this.changed = true;
	}
	
	public void setSupplierSpace(SupplierSpace supplierSpace){
		this.mSupplierSpace = supplierSpace;;
	}
	public SupplierSpace getSupplierSpace(){
		return this.mSupplierSpace;
	}
	public GoodsShelf updateSupplierSpace(SupplierSpace supplierSpace){
		this.mSupplierSpace = supplierSpace;;
		this.changed = true;
		return this;
	}
	public void mergeSupplierSpace(SupplierSpace supplierSpace){
		if(supplierSpace != null) { setSupplierSpace(supplierSpace);}
	}
	
	
	public void clearSupplierSpace(){
		setSupplierSpace ( null );
		this.changed = true;
	}
	
	public void setDamageSpace(DamageSpace damageSpace){
		this.mDamageSpace = damageSpace;;
	}
	public DamageSpace getDamageSpace(){
		return this.mDamageSpace;
	}
	public GoodsShelf updateDamageSpace(DamageSpace damageSpace){
		this.mDamageSpace = damageSpace;;
		this.changed = true;
		return this;
	}
	public void mergeDamageSpace(DamageSpace damageSpace){
		if(damageSpace != null) { setDamageSpace(damageSpace);}
	}
	
	
	public void clearDamageSpace(){
		setDamageSpace ( null );
		this.changed = true;
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public GoodsShelf updateLastUpdateTime(DateTime lastUpdateTime){
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
	public GoodsShelf updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<GoodsShelfStockCount> getGoodsShelfStockCountList(){
		if(this.mGoodsShelfStockCountList == null){
			this.mGoodsShelfStockCountList = new SmartList<GoodsShelfStockCount>();
			this.mGoodsShelfStockCountList.setListInternalName (GOODS_SHELF_STOCK_COUNT_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsShelfStockCountList;	
	}
	public  void setGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList){
		for( GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList){
			goodsShelfStockCount.setShelf(this);
		}

		this.mGoodsShelfStockCountList = goodsShelfStockCountList;
		this.mGoodsShelfStockCountList.setListInternalName (GOODS_SHELF_STOCK_COUNT_LIST );
		
	}
	
	public  void addGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount){
		goodsShelfStockCount.setShelf(this);
		getGoodsShelfStockCountList().add(goodsShelfStockCount);
	}
	public  void addGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList){
		for( GoodsShelfStockCount goodsShelfStockCount:goodsShelfStockCountList){
			goodsShelfStockCount.setShelf(this);
		}
		getGoodsShelfStockCountList().addAll(goodsShelfStockCountList);
	}
	public  void mergeGoodsShelfStockCountList(SmartList<GoodsShelfStockCount> goodsShelfStockCountList){
		if(goodsShelfStockCountList==null){
			return;
		}
		if(goodsShelfStockCountList.isEmpty()){
			return;
		}
		addGoodsShelfStockCountList( goodsShelfStockCountList );
		
	}
	public  GoodsShelfStockCount removeGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCountIndex){
		
		int index = getGoodsShelfStockCountList().indexOf(goodsShelfStockCountIndex);
        if(index < 0){
        	String message = "GoodsShelfStockCount("+goodsShelfStockCountIndex.getId()+") with version='"+goodsShelfStockCountIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        GoodsShelfStockCount goodsShelfStockCount = getGoodsShelfStockCountList().get(index);        
        // goodsShelfStockCount.clearShelf(); //disconnect with Shelf
        goodsShelfStockCount.clearFromAll(); //disconnect with Shelf
		
		boolean result = getGoodsShelfStockCountList().planToRemove(goodsShelfStockCount);
        if(!result){
        	String message = "GoodsShelfStockCount("+goodsShelfStockCountIndex.getId()+") with version='"+goodsShelfStockCountIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return goodsShelfStockCount;
        
	
	}
	//断舍离
	public  void breakWithGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount){
		
		if(goodsShelfStockCount == null){
			return;
		}
		goodsShelfStockCount.setShelf(null);
		//getGoodsShelfStockCountList().remove();
	
	}
	
	public  boolean hasGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount){
	
		return getGoodsShelfStockCountList().contains(goodsShelfStockCount);
  
	}
	
	public void copyGoodsShelfStockCountFrom(GoodsShelfStockCount goodsShelfStockCount) {

		GoodsShelfStockCount goodsShelfStockCountInList = findTheGoodsShelfStockCount(goodsShelfStockCount);
		GoodsShelfStockCount newGoodsShelfStockCount = new GoodsShelfStockCount();
		goodsShelfStockCountInList.copyTo(newGoodsShelfStockCount);
		newGoodsShelfStockCount.setVersion(0);//will trigger copy
		getGoodsShelfStockCountList().add(newGoodsShelfStockCount);
		addItemToFlexiableObject(COPIED_CHILD, newGoodsShelfStockCount);
	}
	
	public  GoodsShelfStockCount findTheGoodsShelfStockCount(GoodsShelfStockCount goodsShelfStockCount){
		
		int index =  getGoodsShelfStockCountList().indexOf(goodsShelfStockCount);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "GoodsShelfStockCount("+goodsShelfStockCount.getId()+") with version='"+goodsShelfStockCount.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGoodsShelfStockCountList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsShelfStockCountList(){
		getGoodsShelfStockCountList().clear();
	}
	
	
	


	public  SmartList<GoodsAllocation> getGoodsAllocationList(){
		if(this.mGoodsAllocationList == null){
			this.mGoodsAllocationList = new SmartList<GoodsAllocation>();
			this.mGoodsAllocationList.setListInternalName (GOODS_ALLOCATION_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsAllocationList;	
	}
	public  void setGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList){
		for( GoodsAllocation goodsAllocation:goodsAllocationList){
			goodsAllocation.setGoodsShelf(this);
		}

		this.mGoodsAllocationList = goodsAllocationList;
		this.mGoodsAllocationList.setListInternalName (GOODS_ALLOCATION_LIST );
		
	}
	
	public  void addGoodsAllocation(GoodsAllocation goodsAllocation){
		goodsAllocation.setGoodsShelf(this);
		getGoodsAllocationList().add(goodsAllocation);
	}
	public  void addGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList){
		for( GoodsAllocation goodsAllocation:goodsAllocationList){
			goodsAllocation.setGoodsShelf(this);
		}
		getGoodsAllocationList().addAll(goodsAllocationList);
	}
	public  void mergeGoodsAllocationList(SmartList<GoodsAllocation> goodsAllocationList){
		if(goodsAllocationList==null){
			return;
		}
		if(goodsAllocationList.isEmpty()){
			return;
		}
		addGoodsAllocationList( goodsAllocationList );
		
	}
	public  GoodsAllocation removeGoodsAllocation(GoodsAllocation goodsAllocationIndex){
		
		int index = getGoodsAllocationList().indexOf(goodsAllocationIndex);
        if(index < 0){
        	String message = "GoodsAllocation("+goodsAllocationIndex.getId()+") with version='"+goodsAllocationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        GoodsAllocation goodsAllocation = getGoodsAllocationList().get(index);        
        // goodsAllocation.clearGoodsShelf(); //disconnect with GoodsShelf
        goodsAllocation.clearFromAll(); //disconnect with GoodsShelf
		
		boolean result = getGoodsAllocationList().planToRemove(goodsAllocation);
        if(!result){
        	String message = "GoodsAllocation("+goodsAllocationIndex.getId()+") with version='"+goodsAllocationIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return goodsAllocation;
        
	
	}
	//断舍离
	public  void breakWithGoodsAllocation(GoodsAllocation goodsAllocation){
		
		if(goodsAllocation == null){
			return;
		}
		goodsAllocation.setGoodsShelf(null);
		//getGoodsAllocationList().remove();
	
	}
	
	public  boolean hasGoodsAllocation(GoodsAllocation goodsAllocation){
	
		return getGoodsAllocationList().contains(goodsAllocation);
  
	}
	
	public void copyGoodsAllocationFrom(GoodsAllocation goodsAllocation) {

		GoodsAllocation goodsAllocationInList = findTheGoodsAllocation(goodsAllocation);
		GoodsAllocation newGoodsAllocation = new GoodsAllocation();
		goodsAllocationInList.copyTo(newGoodsAllocation);
		newGoodsAllocation.setVersion(0);//will trigger copy
		getGoodsAllocationList().add(newGoodsAllocation);
		addItemToFlexiableObject(COPIED_CHILD, newGoodsAllocation);
	}
	
	public  GoodsAllocation findTheGoodsAllocation(GoodsAllocation goodsAllocation){
		
		int index =  getGoodsAllocationList().indexOf(goodsAllocation);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "GoodsAllocation("+goodsAllocation.getId()+") with version='"+goodsAllocation.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGoodsAllocationList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsAllocationList(){
		getGoodsAllocationList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getStorageSpace(), internalType);
		addToEntityList(this, entityList, getSupplierSpace(), internalType);
		addToEntityList(this, entityList, getDamageSpace(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getGoodsShelfStockCountList(), internalType);
		collectFromList(this, entityList, getGoodsAllocationList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getGoodsShelfStockCountList());
		listOfList.add( getGoodsAllocationList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, STORAGE_SPACE_PROPERTY, getStorageSpace());
		appendKeyValuePair(result, SUPPLIER_SPACE_PROPERTY, getSupplierSpace());
		appendKeyValuePair(result, DAMAGE_SPACE_PROPERTY, getDamageSpace());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, GOODS_SHELF_STOCK_COUNT_LIST, getGoodsShelfStockCountList());
		if(!getGoodsShelfStockCountList().isEmpty()){
			appendKeyValuePair(result, "goodsShelfStockCountCount", getGoodsShelfStockCountList().getTotalCount());
			appendKeyValuePair(result, "goodsShelfStockCountCurrentPageNumber", getGoodsShelfStockCountList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, GOODS_ALLOCATION_LIST, getGoodsAllocationList());
		if(!getGoodsAllocationList().isEmpty()){
			appendKeyValuePair(result, "goodsAllocationCount", getGoodsAllocationList().getTotalCount());
			appendKeyValuePair(result, "goodsAllocationCurrentPageNumber", getGoodsAllocationList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsShelf){
		
		
			GoodsShelf dest =(GoodsShelf)baseDest;
		
			dest.setId(getId());
			dest.setLocation(getLocation());
			dest.setStorageSpace(getStorageSpace());
			dest.setSupplierSpace(getSupplierSpace());
			dest.setDamageSpace(getDamageSpace());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setGoodsShelfStockCountList(getGoodsShelfStockCountList());
			dest.setGoodsAllocationList(getGoodsAllocationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsShelf){
		
			
			GoodsShelf dest =(GoodsShelf)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeStorageSpace(getStorageSpace());
			dest.mergeSupplierSpace(getSupplierSpace());
			dest.mergeDamageSpace(getDamageSpace());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeGoodsShelfStockCountList(getGoodsShelfStockCountList());
			dest.mergeGoodsAllocationList(getGoodsAllocationList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsShelf){
		
			
			GoodsShelf dest =(GoodsShelf)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getLocation(), getStorageSpace(), getSupplierSpace(), getDamageSpace(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GoodsShelf{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		if(getStorageSpace() != null ){
 			stringBuilder.append("\tstorageSpace='StorageSpace("+getStorageSpace().getId()+")';");
 		}
		if(getSupplierSpace() != null ){
 			stringBuilder.append("\tsupplierSpace='SupplierSpace("+getSupplierSpace().getId()+")';");
 		}
		if(getDamageSpace() != null ){
 			stringBuilder.append("\tdamageSpace='DamageSpace("+getDamageSpace().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

