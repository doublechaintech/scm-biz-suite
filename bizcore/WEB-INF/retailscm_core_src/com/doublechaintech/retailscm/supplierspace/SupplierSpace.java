
package com.doublechaintech.retailscm.supplierspace;

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
import com.doublechaintech.retailscm.warehouse.Warehouse;
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;









@JsonSerialize(using = SupplierSpaceSerializer.class)
public class SupplierSpace extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String TOTAL_AREA_PROPERTY            = "totalArea"         ;
	public static final String WAREHOUSE_PROPERTY             = "warehouse"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_SHELF_LIST                         = "goodsShelfList"    ;

	public static final String INTERNAL_TYPE="SupplierSpace";
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
	protected		Warehouse           	mWarehouse          ;
	protected		BigDecimal          	mLatitude           ;
	protected		BigDecimal          	mLongitude          ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<GoodsShelf>	mGoodsShelfList     ;

	
		
	public 	SupplierSpace(){
		// lazy load for all the properties
	}
	public 	static SupplierSpace withId(String id){
		SupplierSpace supplierSpace = new SupplierSpace();
		supplierSpace.setId(id);
		supplierSpace.setVersion(Integer.MAX_VALUE);
		return supplierSpace;
	}
	public 	static SupplierSpace refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setWarehouse( null );

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
		if(WAREHOUSE_PROPERTY.equals(property)){
			return getWarehouse();
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
		if(GOODS_SHELF_LIST.equals(property)){
			List<BaseEntity> list = getGoodsShelfList().stream().map(item->item).collect(Collectors.toList());
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
	public SupplierSpace updateId(String id){
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
	public SupplierSpace updateLocation(String location){
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
	public SupplierSpace updateContactNumber(String contactNumber){
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
	public SupplierSpace updateTotalArea(String totalArea){
		this.mTotalArea = trimString(totalArea);;
		this.changed = true;
		return this;
	}
	public void mergeTotalArea(String totalArea){
		if(totalArea != null) { setTotalArea(totalArea);}
	}
	
	
	public void setWarehouse(Warehouse warehouse){
		this.mWarehouse = warehouse;;
	}
	public Warehouse getWarehouse(){
		return this.mWarehouse;
	}
	public SupplierSpace updateWarehouse(Warehouse warehouse){
		this.mWarehouse = warehouse;;
		this.changed = true;
		return this;
	}
	public void mergeWarehouse(Warehouse warehouse){
		if(warehouse != null) { setWarehouse(warehouse);}
	}
	
	
	public void clearWarehouse(){
		setWarehouse ( null );
		this.changed = true;
	}
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public SupplierSpace updateLatitude(BigDecimal latitude){
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
	public SupplierSpace updateLongitude(BigDecimal longitude){
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
	public SupplierSpace updateLastUpdateTime(DateTime lastUpdateTime){
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
	public SupplierSpace updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<GoodsShelf> getGoodsShelfList(){
		if(this.mGoodsShelfList == null){
			this.mGoodsShelfList = new SmartList<GoodsShelf>();
			this.mGoodsShelfList.setListInternalName (GOODS_SHELF_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsShelfList;	
	}
	public  void setGoodsShelfList(SmartList<GoodsShelf> goodsShelfList){
		for( GoodsShelf goodsShelf:goodsShelfList){
			goodsShelf.setSupplierSpace(this);
		}

		this.mGoodsShelfList = goodsShelfList;
		this.mGoodsShelfList.setListInternalName (GOODS_SHELF_LIST );
		
	}
	
	public  void addGoodsShelf(GoodsShelf goodsShelf){
		goodsShelf.setSupplierSpace(this);
		getGoodsShelfList().add(goodsShelf);
	}
	public  void addGoodsShelfList(SmartList<GoodsShelf> goodsShelfList){
		for( GoodsShelf goodsShelf:goodsShelfList){
			goodsShelf.setSupplierSpace(this);
		}
		getGoodsShelfList().addAll(goodsShelfList);
	}
	public  void mergeGoodsShelfList(SmartList<GoodsShelf> goodsShelfList){
		if(goodsShelfList==null){
			return;
		}
		if(goodsShelfList.isEmpty()){
			return;
		}
		addGoodsShelfList( goodsShelfList );
		
	}
	public  GoodsShelf removeGoodsShelf(GoodsShelf goodsShelfIndex){
		
		int index = getGoodsShelfList().indexOf(goodsShelfIndex);
        if(index < 0){
        	String message = "GoodsShelf("+goodsShelfIndex.getId()+") with version='"+goodsShelfIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        GoodsShelf goodsShelf = getGoodsShelfList().get(index);        
        // goodsShelf.clearSupplierSpace(); //disconnect with SupplierSpace
        goodsShelf.clearFromAll(); //disconnect with SupplierSpace
		
		boolean result = getGoodsShelfList().planToRemove(goodsShelf);
        if(!result){
        	String message = "GoodsShelf("+goodsShelfIndex.getId()+") with version='"+goodsShelfIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return goodsShelf;
        
	
	}
	//断舍离
	public  void breakWithGoodsShelf(GoodsShelf goodsShelf){
		
		if(goodsShelf == null){
			return;
		}
		goodsShelf.setSupplierSpace(null);
		//getGoodsShelfList().remove();
	
	}
	
	public  boolean hasGoodsShelf(GoodsShelf goodsShelf){
	
		return getGoodsShelfList().contains(goodsShelf);
  
	}
	
	public void copyGoodsShelfFrom(GoodsShelf goodsShelf) {

		GoodsShelf goodsShelfInList = findTheGoodsShelf(goodsShelf);
		GoodsShelf newGoodsShelf = new GoodsShelf();
		goodsShelfInList.copyTo(newGoodsShelf);
		newGoodsShelf.setVersion(0);//will trigger copy
		getGoodsShelfList().add(newGoodsShelf);
		addItemToFlexiableObject(COPIED_CHILD, newGoodsShelf);
	}
	
	public  GoodsShelf findTheGoodsShelf(GoodsShelf goodsShelf){
		
		int index =  getGoodsShelfList().indexOf(goodsShelf);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "GoodsShelf("+goodsShelf.getId()+") with version='"+goodsShelf.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}
		
		return  getGoodsShelfList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}
	
	public  void cleanUpGoodsShelfList(){
		getGoodsShelfList().clear();
	}
	
	
	


	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getWarehouse(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getGoodsShelfList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getGoodsShelfList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getContactNumber());
		appendKeyValuePair(result, TOTAL_AREA_PROPERTY, getTotalArea());
		appendKeyValuePair(result, WAREHOUSE_PROPERTY, getWarehouse());
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, GOODS_SHELF_LIST, getGoodsShelfList());
		if(!getGoodsShelfList().isEmpty()){
			appendKeyValuePair(result, "goodsShelfCount", getGoodsShelfList().getTotalCount());
			appendKeyValuePair(result, "goodsShelfCurrentPageNumber", getGoodsShelfList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplierSpace){
		
		
			SupplierSpace dest =(SupplierSpace)baseDest;
		
			dest.setId(getId());
			dest.setLocation(getLocation());
			dest.setContactNumber(getContactNumber());
			dest.setTotalArea(getTotalArea());
			dest.setWarehouse(getWarehouse());
			dest.setLatitude(getLatitude());
			dest.setLongitude(getLongitude());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setGoodsShelfList(getGoodsShelfList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplierSpace){
		
			
			SupplierSpace dest =(SupplierSpace)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeTotalArea(getTotalArea());
			dest.mergeWarehouse(getWarehouse());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeGoodsShelfList(getGoodsShelfList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SupplierSpace){
		
			
			SupplierSpace dest =(SupplierSpace)baseDest;
		
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
		return new Object[]{getId(), getLocation(), getContactNumber(), getTotalArea(), getWarehouse(), getLatitude(), getLongitude(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SupplierSpace{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tcontactNumber='"+getContactNumber()+"';");
		stringBuilder.append("\ttotalArea='"+getTotalArea()+"';");
		if(getWarehouse() != null ){
 			stringBuilder.append("\twarehouse='Warehouse("+getWarehouse().getId()+")';");
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

