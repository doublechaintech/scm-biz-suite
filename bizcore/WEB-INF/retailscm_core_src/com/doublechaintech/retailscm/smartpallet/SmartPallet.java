
package com.doublechaintech.retailscm.smartpallet;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
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
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LATITUDE_PROPERTY, "latitude", "纬度")
        .withType("double", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LONGITUDE_PROPERTY, "longitude", "经度")
        .withType("double", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(WAREHOUSE_PROPERTY, "warehouse", "仓库")
        .withType("warehouse", Warehouse.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(GOODS_LIST, "smartPallet", "商品列表")
        .withType("goods", Goods.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,LOCATION_PROPERTY ,CONTACT_NUMBER_PROPERTY ,TOTAL_AREA_PROPERTY ,LATITUDE_PROPERTY ,LONGITUDE_PROPERTY ,WAREHOUSE_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(GOODS_LIST, "smartPallet");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(GOODS_LIST, Goods.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(WAREHOUSE_PROPERTY, Warehouse.class);

    return parents;
  }

  public SmartPallet want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public SmartPallet wants(Class<? extends BaseEntity>... classes) {
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
	protected		BigDecimal          	latitude            ;
	protected		BigDecimal          	longitude           ;
	protected		Warehouse           	warehouse           ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<Goods>    	mGoodsList          ;



	public 	SmartPallet(){
		// lazy load for all the properties
	}
	public 	static SmartPallet withId(String id){
		SmartPallet smartPallet = new SmartPallet();
		smartPallet.setId(id);
		smartPallet.setVersion(Integer.MAX_VALUE);
		smartPallet.setChecked(true);
		return smartPallet;
	}
	public 	static SmartPallet refById(String id){
		return withId(id);
	}

  public SmartPallet limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public SmartPallet limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static SmartPallet searchExample(){
    SmartPallet smartPallet = new SmartPallet();
    		smartPallet.setVersion(UNSET_INT);

    return smartPallet;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setWarehouse( null );

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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public SmartPallet updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public SmartPallet addIdCriteria(QueryOperator operator, Object... parameters){
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
	public SmartPallet updateLocation(String location){String oldLocation = this.location;String newLocation = trimString(location);if(!shouldReplaceBy(newLocation, oldLocation)){return this;}this.location = newLocation;addPropertyChange(LOCATION_PROPERTY, oldLocation, newLocation);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByLocation(boolean asc){
doAddOrderBy(LOCATION_PROPERTY, asc);
return this;
}
	public SearchCriteria createLocationCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LOCATION_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreLocationCriteria(){super.ignoreSearchProperty(LOCATION_PROPERTY);
return this;
}
	public SmartPallet addLocationCriteria(QueryOperator operator, Object... parameters){
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
	public SmartPallet updateContactNumber(String contactNumber){String oldContactNumber = this.contactNumber;String newContactNumber = trimString(contactNumber);if(!shouldReplaceBy(newContactNumber, oldContactNumber)){return this;}this.contactNumber = newContactNumber;addPropertyChange(CONTACT_NUMBER_PROPERTY, oldContactNumber, newContactNumber);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByContactNumber(boolean asc){
doAddOrderBy(CONTACT_NUMBER_PROPERTY, asc);
return this;
}
	public SearchCriteria createContactNumberCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONTACT_NUMBER_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreContactNumberCriteria(){super.ignoreSearchProperty(CONTACT_NUMBER_PROPERTY);
return this;
}
	public SmartPallet addContactNumberCriteria(QueryOperator operator, Object... parameters){
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
	public SmartPallet updateTotalArea(String totalArea){String oldTotalArea = this.totalArea;String newTotalArea = trimString(totalArea);if(!shouldReplaceBy(newTotalArea, oldTotalArea)){return this;}this.totalArea = newTotalArea;addPropertyChange(TOTAL_AREA_PROPERTY, oldTotalArea, newTotalArea);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByTotalArea(boolean asc){
doAddOrderBy(TOTAL_AREA_PROPERTY, asc);
return this;
}
	public SearchCriteria createTotalAreaCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TOTAL_AREA_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreTotalAreaCriteria(){super.ignoreSearchProperty(TOTAL_AREA_PROPERTY);
return this;
}
	public SmartPallet addTotalAreaCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTotalAreaCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeTotalArea(String totalArea){
		if(totalArea != null) { setTotalArea(totalArea);}
	}

	
	public void setLatitude(BigDecimal latitude){BigDecimal oldLatitude = this.latitude;BigDecimal newLatitude = latitude;this.latitude = newLatitude;}
	public BigDecimal latitude(){
doLoad();
return getLatitude();
}
	public BigDecimal getLatitude(){
		return this.latitude;
	}
	public SmartPallet updateLatitude(BigDecimal latitude){BigDecimal oldLatitude = this.latitude;BigDecimal newLatitude = latitude;if(!shouldReplaceBy(newLatitude, oldLatitude)){return this;}this.latitude = newLatitude;addPropertyChange(LATITUDE_PROPERTY, oldLatitude, newLatitude);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByLatitude(boolean asc){
doAddOrderBy(LATITUDE_PROPERTY, asc);
return this;
}
	public SearchCriteria createLatitudeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LATITUDE_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreLatitudeCriteria(){super.ignoreSearchProperty(LATITUDE_PROPERTY);
return this;
}
	public SmartPallet addLatitudeCriteria(QueryOperator operator, Object... parameters){
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
	public SmartPallet updateLongitude(BigDecimal longitude){BigDecimal oldLongitude = this.longitude;BigDecimal newLongitude = longitude;if(!shouldReplaceBy(newLongitude, oldLongitude)){return this;}this.longitude = newLongitude;addPropertyChange(LONGITUDE_PROPERTY, oldLongitude, newLongitude);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByLongitude(boolean asc){
doAddOrderBy(LONGITUDE_PROPERTY, asc);
return this;
}
	public SearchCriteria createLongitudeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LONGITUDE_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreLongitudeCriteria(){super.ignoreSearchProperty(LONGITUDE_PROPERTY);
return this;
}
	public SmartPallet addLongitudeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createLongitudeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}

	
	public void setWarehouse(Warehouse warehouse){Warehouse oldWarehouse = this.warehouse;Warehouse newWarehouse = warehouse;this.warehouse = newWarehouse;}
	public Warehouse warehouse(){
doLoad();
return getWarehouse();
}
	public Warehouse getWarehouse(){
		return this.warehouse;
	}
	public SmartPallet updateWarehouse(Warehouse warehouse){Warehouse oldWarehouse = this.warehouse;Warehouse newWarehouse = warehouse;if(!shouldReplaceBy(newWarehouse, oldWarehouse)){return this;}this.warehouse = newWarehouse;addPropertyChange(WAREHOUSE_PROPERTY, oldWarehouse, newWarehouse);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByWarehouse(boolean asc){
doAddOrderBy(WAREHOUSE_PROPERTY, asc);
return this;
}
	public SearchCriteria createWarehouseCriteria(QueryOperator operator, Object... parameters){
return createCriteria(WAREHOUSE_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreWarehouseCriteria(){super.ignoreSearchProperty(WAREHOUSE_PROPERTY);
return this;
}
	public SmartPallet addWarehouseCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createWarehouseCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeWarehouse(Warehouse warehouse){
		if(warehouse != null) { setWarehouse(warehouse);}
	}

	
	public void clearWarehouse(){
		setWarehouse ( null );
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
	public SmartPallet updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public SmartPallet addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
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
	public SmartPallet updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public SmartPallet orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public SmartPallet ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public SmartPallet addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
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

  public  SmartList<Goods> goodsList(){
    
    doLoadChild(GOODS_LIST);
    
    return getGoodsList();
  }


	public  void setGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSmartPallet(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );

	}

	public  SmartPallet addGoods(Goods goods){
		goods.setSmartPallet(this);
		getGoodsList().add(goods);
		return this;
	}
	public  SmartPallet addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSmartPallet(this);
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


	public static SmartPallet createWith(RetailscmUserContext userContext, ThrowingFunction<SmartPallet,SmartPallet,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<SmartPallet> customCreator = mapper.findCustomCreator(SmartPallet.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    SmartPallet result = new SmartPallet();
    result.setLocation(mapper.tryToGet(SmartPallet.class, LOCATION_PROPERTY, String.class,
        0, false, result.getLocation(), params));
    result.setContactNumber(mapper.tryToGet(SmartPallet.class, CONTACT_NUMBER_PROPERTY, String.class,
        1, false, result.getContactNumber(), params));
    result.setTotalArea(mapper.tryToGet(SmartPallet.class, TOTAL_AREA_PROPERTY, String.class,
        2, false, result.getTotalArea(), params));
    result.setLatitude(mapper.tryToGet(SmartPallet.class, LATITUDE_PROPERTY, BigDecimal.class,
        0, false, result.getLatitude(), params));
    result.setLongitude(mapper.tryToGet(SmartPallet.class, LONGITUDE_PROPERTY, BigDecimal.class,
        1, false, result.getLongitude(), params));
    result.setWarehouse(mapper.tryToGet(SmartPallet.class, WAREHOUSE_PROPERTY, Warehouse.class,
        0, true, result.getWarehouse(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixSmartPallet(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      SmartPalletTokens tokens = mapper.findParamByClass(params, SmartPalletTokens.class);
      if (tokens == null) {
        tokens = SmartPalletTokens.start();
      }
      result = userContext.getManagerGroup().getSmartPalletManager().internalSaveSmartPallet(userContext, result, tokens.done());
      
    }
    return result;
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

