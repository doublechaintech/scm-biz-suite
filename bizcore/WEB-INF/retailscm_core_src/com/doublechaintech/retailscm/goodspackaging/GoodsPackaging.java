
package com.doublechaintech.retailscm.goodspackaging;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.KeyValuePair;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.doublechaintech.retailscm.goods.Goods;

@JsonSerialize(using = GoodsPackagingSerializer.class)
public class GoodsPackaging extends BaseEntity implements  java.io.Serializable{

	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String PACKAGE_NAME_PROPERTY          = "packageName"       ;
	public static final String RFID_PROPERTY                  = "rfid"              ;
	public static final String PACKAGE_TIME_PROPERTY          = "packageTime"       ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;

	public static final String INTERNAL_TYPE="GoodsPackaging";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}
	
	public String getDisplayName(){
	
		String displayName = getPackageName();
		if(displayName!=null){
			return displayName;
		}
		
		return super.getDisplayName();
		
	}

	private static final long serialVersionUID = 1L;
	

	protected		String              	mId                 ;
	protected		String              	mPackageName        ;
	protected		String              	mRfid               ;
	protected		Date                	mPackageTime        ;
	protected		String              	mDescription        ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;
	
		
	public 	GoodsPackaging(){
		//lazy load for all the properties
	}
	//disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){

		this.changed = true;
	}
	
	public 	GoodsPackaging(String packageName, String rfid, Date packageTime, String description)
	{
		setPackageName(packageName);
		setRfid(rfid);
		setPackageTime(packageTime);
		setDescription(description);

		this.mGoodsList = new SmartList<Goods>();	
	}
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PACKAGE_NAME_PROPERTY.equals(property)){
			changePackageNameProperty(newValueExpr);
		}
		if(RFID_PROPERTY.equals(property)){
			changeRfidProperty(newValueExpr);
		}
		if(PACKAGE_TIME_PROPERTY.equals(property)){
			changePackageTimeProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePackageNameProperty(String newValueExpr){
		String oldValue = getPackageName();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePackageName(newValue);
		this.onChangeProperty(PACKAGE_NAME_PROPERTY, oldValue, newValue);
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
			
			
			
	protected void changePackageTimeProperty(String newValueExpr){
		Date oldValue = getPackageTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePackageTime(newValue);
		this.onChangeProperty(PACKAGE_TIME_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			
	protected void changeDescriptionProperty(String newValueExpr){
		String oldValue = getDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDescription(newValue);
		this.onChangeProperty(DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
  
	}
			
			
			


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public GoodsPackaging updateId(String id){
		this.mId = trimString(id);;
		this.changed = true;
		return this;
	}
	
	
	public void setPackageName(String packageName){
		this.mPackageName = trimString(packageName);;
	}
	public String getPackageName(){
		return this.mPackageName;
	}
	public GoodsPackaging updatePackageName(String packageName){
		this.mPackageName = trimString(packageName);;
		this.changed = true;
		return this;
	}
	
	
	public void setRfid(String rfid){
		this.mRfid = trimString(rfid);;
	}
	public String getRfid(){
		return this.mRfid;
	}
	public GoodsPackaging updateRfid(String rfid){
		this.mRfid = trimString(rfid);;
		this.changed = true;
		return this;
	}
	
	
	public void setPackageTime(Date packageTime){
		this.mPackageTime = packageTime;;
	}
	public Date getPackageTime(){
		return this.mPackageTime;
	}
	public GoodsPackaging updatePackageTime(Date packageTime){
		this.mPackageTime = packageTime;;
		this.changed = true;
		return this;
	}
	
	
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public GoodsPackaging updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public GoodsPackaging updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
		return this;
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
			goods.setPackaging(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setPackaging(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setPackaging(this);
		}
		getGoodsList().addAll(goodsList);
	}
	
	public  Goods removeGoods(Goods goodsIndex){
		
		int index = getGoodsList().indexOf(goodsIndex);
        if(index < 0){
        	String message = "Goods("+goodsIndex.getId()+") with version='"+goodsIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Goods goods = getGoodsList().get(index);        
        // goods.clearPackaging(); //disconnect with Packaging
        goods.clearFromAll(); //disconnect with Packaging
		
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
		goods.setPackaging(null);
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
		appendKeyValuePair(result, PACKAGE_NAME_PROPERTY, getPackageName());
		appendKeyValuePair(result, RFID_PROPERTY, getRfid());
		appendKeyValuePair(result, PACKAGE_TIME_PROPERTY, getPackageTime());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, GOODS_LIST, getGoodsList());
		if(!getGoodsList().isEmpty()){
			appendKeyValuePair(result, "goodsCount", getGoodsList().getTotalCount());
			appendKeyValuePair(result, "goodsCurrentPageNumber", getGoodsList().getCurrentPageNumber());
		}

		
		return result;
	}
	
	
	public BaseEntity copyTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof GoodsPackaging){
		
		
			GoodsPackaging dest =(GoodsPackaging)baseDest;
		
			dest.setId(getId());
			dest.setPackageName(getPackageName());
			dest.setRfid(getRfid());
			dest.setPackageTime(getPackageTime());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());
			dest.setGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GoodsPackaging{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tpackageName='"+getPackageName()+"';");
		stringBuilder.append("\trfid='"+getRfid()+"';");
		stringBuilder.append("\tpackageTime='"+getPackageTime()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

