
package com.doublechaintech.retailscm.smartpallet;

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
import com.doublechaintech.retailscm.goods.Goods;
import com.doublechaintech.retailscm.warehouse.Warehouse;









@JsonSerialize(using = SmartPalletSerializer.class)
public class SmartPallet extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String TOTAL_AREA_PROPERTY            = "totalArea"         ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String WAREHOUSE_PROPERTY             = "warehouse"         ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;

	public static final String INTERNAL_TYPE="SmartPallet";
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
	protected		BigDecimal          	mLatitude           ;
	protected		BigDecimal          	mLongitude          ;
	protected		Warehouse           	mWarehouse          ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;

	
		
	public 	SmartPallet(){
		// lazy load for all the properties
	}
	public 	static SmartPallet withId(String id){
		SmartPallet smartPallet = new SmartPallet();
		smartPallet.setId(id);
		smartPallet.setVersion(Integer.MAX_VALUE);
		return smartPallet;
	}
	public 	static SmartPallet refById(String id){
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
		if(LATITUDE_PROPERTY.equals(property)){
			return getLatitude();
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			return getLongitude();
		}
		if(WAREHOUSE_PROPERTY.equals(property)){
			return getWarehouse();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(GOODS_LIST.equals(property)){
			List<BaseEntity> list = getGoodsList().stream().map(item->item).collect(Collectors.toList());
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
	public SmartPallet updateId(String id){
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
	public SmartPallet updateLocation(String location){
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
	public SmartPallet updateContactNumber(String contactNumber){
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
	public SmartPallet updateTotalArea(String totalArea){
		this.mTotalArea = trimString(totalArea);;
		this.changed = true;
		return this;
	}
	public void mergeTotalArea(String totalArea){
		if(totalArea != null) { setTotalArea(totalArea);}
	}
	
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public SmartPallet updateLatitude(BigDecimal latitude){
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
	public SmartPallet updateLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
		this.changed = true;
		return this;
	}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}
	
	
	public void setWarehouse(Warehouse warehouse){
		this.mWarehouse = warehouse;;
	}
	public Warehouse getWarehouse(){
		return this.mWarehouse;
	}
	public SmartPallet updateWarehouse(Warehouse warehouse){
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
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public SmartPallet updateLastUpdateTime(DateTime lastUpdateTime){
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
	public SmartPallet updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
	}
	public void mergeVersion(int version){
		setVersion(version);
	}
	
	

	public  SmartList<Goods> getGoodsList(){
		if(this.mGoodsList == null){
			this.mGoodsList = new SmartList<Goods>();
			this.mGoodsList.setListInternalName (GOODS_LIST );
			//有名字，便于做权限控制
		}
		
		return this.mGoodsList;	
	}
	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSmartPallet(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setSmartPallet(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSmartPallet(this);
		}
		getGoodsList().addAll(goodsList);
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
        // goods.clearSmartPallet(); //disconnect with SmartPallet
        goods.clearFromAll(); //disconnect with SmartPallet
		
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
		goods.setSmartPallet(null);
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

		addToEntityList(this, entityList, getWarehouse(), internalType);

		
	}
	
	public List<BaseEntity>  collectRefercencesFromLists(String internalType){
		
		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getGoodsList(), internalType);

		return entityList;
	}
	
	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();
		
		listOfList.add( getGoodsList());
			

		return listOfList;
	}

	
	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, LOCATION_PROPERTY, getLocation());
		appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getContactNumber());
		appendKeyValuePair(result, TOTAL_AREA_PROPERTY, getTotalArea());
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, WAREHOUSE_PROPERTY, getWarehouse());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
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
		
		
		if(baseDest instanceof SmartPallet){
		
		
			SmartPallet dest =(SmartPallet)baseDest;
		
			dest.setId(getId());
			dest.setLocation(getLocation());
			dest.setContactNumber(getContactNumber());
			dest.setTotalArea(getTotalArea());
			dest.setLatitude(getLatitude());
			dest.setLongitude(getLongitude());
			dest.setWarehouse(getWarehouse());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SmartPallet){
		
			
			SmartPallet dest =(SmartPallet)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeTotalArea(getTotalArea());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeWarehouse(getWarehouse());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof SmartPallet){
		
			
			SmartPallet dest =(SmartPallet)baseDest;
		
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
		return new Object[]{getId(), getLocation(), getContactNumber(), getTotalArea(), getLatitude(), getLongitude(), getWarehouse(), getLastUpdateTime(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("SmartPallet{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tcontactNumber='"+getContactNumber()+"';");
		stringBuilder.append("\ttotalArea='"+getTotalArea()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		if(getWarehouse() != null ){
 			stringBuilder.append("\twarehouse='Warehouse("+getWarehouse().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

