
package com.doublechaintech.retailscm.goodsallocation;

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
import com.doublechaintech.retailscm.goodsshelf.GoodsShelf;









@JsonSerialize(using = GoodsAllocationSerializer.class)
public class GoodsAllocation extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String LOCATION_PROPERTY              = "location"          ;
	public static final String LATITUDE_PROPERTY              = "latitude"          ;
	public static final String LONGITUDE_PROPERTY             = "longitude"         ;
	public static final String GOODS_SHELF_PROPERTY           = "goodsShelf"        ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;

	public static final String INTERNAL_TYPE="GoodsAllocation";
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
	protected		BigDecimal          	mLatitude           ;
	protected		BigDecimal          	mLongitude          ;
	protected		GoodsShelf          	mGoodsShelf         ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;

	
		
	public 	GoodsAllocation(){
		// lazy load for all the properties
	}
	public 	static GoodsAllocation withId(String id){
		GoodsAllocation goodsAllocation = new GoodsAllocation();
		goodsAllocation.setId(id);
		goodsAllocation.setVersion(Integer.MAX_VALUE);
		return goodsAllocation;
	}
	public 	static GoodsAllocation refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setGoodsShelf( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			changeLocationProperty(newValueExpr);
		}
		if(LATITUDE_PROPERTY.equals(property)){
			changeLatitudeProperty(newValueExpr);
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			changeLongitudeProperty(newValueExpr);
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
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(LOCATION_PROPERTY.equals(property)){
			return getLocation();
		}
		if(LATITUDE_PROPERTY.equals(property)){
			return getLatitude();
		}
		if(LONGITUDE_PROPERTY.equals(property)){
			return getLongitude();
		}
		if(GOODS_SHELF_PROPERTY.equals(property)){
			return getGoodsShelf();
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
	public GoodsAllocation updateId(String id){
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
	public GoodsAllocation updateLocation(String location){
		this.mLocation = trimString(location);;
		this.changed = true;
		return this;
	}
	public void mergeLocation(String location){
		if(location != null) { setLocation(location);}
	}
	
	
	public void setLatitude(BigDecimal latitude){
		this.mLatitude = latitude;;
	}
	public BigDecimal getLatitude(){
		return this.mLatitude;
	}
	public GoodsAllocation updateLatitude(BigDecimal latitude){
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
	public GoodsAllocation updateLongitude(BigDecimal longitude){
		this.mLongitude = longitude;;
		this.changed = true;
		return this;
	}
	public void mergeLongitude(BigDecimal longitude){
		setLongitude(longitude);
	}
	
	
	public void setGoodsShelf(GoodsShelf goodsShelf){
		this.mGoodsShelf = goodsShelf;;
	}
	public GoodsShelf getGoodsShelf(){
		return this.mGoodsShelf;
	}
	public GoodsAllocation updateGoodsShelf(GoodsShelf goodsShelf){
		this.mGoodsShelf = goodsShelf;;
		this.changed = true;
		return this;
	}
	public void mergeGoodsShelf(GoodsShelf goodsShelf){
		if(goodsShelf != null) { setGoodsShelf(goodsShelf);}
	}
	
	
	public void clearGoodsShelf(){
		setGoodsShelf ( null );
		this.changed = true;
	}
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public GoodsAllocation updateVersion(int version){
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
			goods.setGoodsAllocation(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setGoodsAllocation(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setGoodsAllocation(this);
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
        // goods.clearGoodsAllocation(); //disconnect with GoodsAllocation
        goods.clearFromAll(); //disconnect with GoodsAllocation
		
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
		goods.setGoodsAllocation(null);
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

		addToEntityList(this, entityList, getGoodsShelf(), internalType);

		
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
		appendKeyValuePair(result, LATITUDE_PROPERTY, getLatitude());
		appendKeyValuePair(result, LONGITUDE_PROPERTY, getLongitude());
		appendKeyValuePair(result, GOODS_SHELF_PROPERTY, getGoodsShelf());
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
		
		
		if(baseDest instanceof GoodsAllocation){
		
		
			GoodsAllocation dest =(GoodsAllocation)baseDest;
		
			dest.setId(getId());
			dest.setLocation(getLocation());
			dest.setLatitude(getLatitude());
			dest.setLongitude(getLongitude());
			dest.setGoodsShelf(getGoodsShelf());
			dest.setVersion(getVersion());
			dest.setGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsAllocation){
		
			
			GoodsAllocation dest =(GoodsAllocation)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeGoodsShelf(getGoodsShelf());
			dest.mergeVersion(getVersion());
			dest.mergeGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsAllocation){
		
			
			GoodsAllocation dest =(GoodsAllocation)baseDest;
		
			dest.mergeId(getId());
			dest.mergeLocation(getLocation());
			dest.mergeLatitude(getLatitude());
			dest.mergeLongitude(getLongitude());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getLocation(), getLatitude(), getLongitude(), getGoodsShelf(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GoodsAllocation{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tlocation='"+getLocation()+"';");
		stringBuilder.append("\tlatitude='"+getLatitude()+"';");
		stringBuilder.append("\tlongitude='"+getLongitude()+"';");
		if(getGoodsShelf() != null ){
 			stringBuilder.append("\tgoodsShelf='GoodsShelf("+getGoodsShelf().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

