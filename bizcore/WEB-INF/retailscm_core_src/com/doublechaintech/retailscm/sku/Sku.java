
package com.doublechaintech.retailscm.sku;

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
import com.doublechaintech.retailscm.product.Product;









@JsonSerialize(using = SkuSerializer.class)
public class Sku extends BaseEntity implements  java.io.Serializable{

	




	
	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SIZE_PROPERTY                  = "size"              ;
	public static final String PRODUCT_PROPERTY               = "product"           ;
	public static final String BARCODE_PROPERTY               = "barcode"           ;
	public static final String PACKAGE_TYPE_PROPERTY          = "packageType"       ;
	public static final String NET_CONTENT_PROPERTY           = "netContent"        ;
	public static final String PRICE_PROPERTY                 = "price"             ;
	public static final String PICTURE_PROPERTY               = "picture"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String GOODS_LIST                               = "goodsList"         ;

	public static final String INTERNAL_TYPE="Sku";
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
	protected		String              	mSize               ;
	protected		Product             	mProduct            ;
	protected		String              	mBarcode            ;
	protected		String              	mPackageType        ;
	protected		String              	mNetContent         ;
	protected		BigDecimal          	mPrice              ;
	protected		String              	mPicture            ;
	protected		int                 	mVersion            ;
	
	
	protected		SmartList<Goods>    	mGoodsList          ;

	
		
	public 	Sku(){
		// lazy load for all the properties
	}
	public 	static Sku withId(String id){
		Sku sku = new Sku();
		sku.setId(id);
		sku.setVersion(Integer.MAX_VALUE);
		return sku;
	}
	public 	static Sku refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProduct( null );

		this.changed = true;
	}
	
	
	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SIZE_PROPERTY.equals(property)){
			changeSizeProperty(newValueExpr);
		}
		if(BARCODE_PROPERTY.equals(property)){
			changeBarcodeProperty(newValueExpr);
		}
		if(PACKAGE_TYPE_PROPERTY.equals(property)){
			changePackageTypeProperty(newValueExpr);
		}
		if(NET_CONTENT_PROPERTY.equals(property)){
			changeNetContentProperty(newValueExpr);
		}
		if(PRICE_PROPERTY.equals(property)){
			changePriceProperty(newValueExpr);
		}
		if(PICTURE_PROPERTY.equals(property)){
			changePictureProperty(newValueExpr);
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
			
			
			
	protected void changeSizeProperty(String newValueExpr){
	
		String oldValue = getSize();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSize(newValue);
		this.onChangeProperty(SIZE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeBarcodeProperty(String newValueExpr){
	
		String oldValue = getBarcode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBarcode(newValue);
		this.onChangeProperty(BARCODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changePackageTypeProperty(String newValueExpr){
	
		String oldValue = getPackageType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePackageType(newValue);
		this.onChangeProperty(PACKAGE_TYPE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeNetContentProperty(String newValueExpr){
	
		String oldValue = getNetContent();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateNetContent(newValue);
		this.onChangeProperty(NET_CONTENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changePriceProperty(String newValueExpr){
	
		BigDecimal oldValue = getPrice();
		BigDecimal newValue = parseBigDecimal(newValueExpr);
		if(equalsBigDecimal(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePrice(newValue);
		this.onChangeProperty(PRICE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changePictureProperty(String newValueExpr){
	
		String oldValue = getPicture();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePicture(newValue);
		this.onChangeProperty(PICTURE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {
     	
		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(SIZE_PROPERTY.equals(property)){
			return getSize();
		}
		if(PRODUCT_PROPERTY.equals(property)){
			return getProduct();
		}
		if(BARCODE_PROPERTY.equals(property)){
			return getBarcode();
		}
		if(PACKAGE_TYPE_PROPERTY.equals(property)){
			return getPackageType();
		}
		if(NET_CONTENT_PROPERTY.equals(property)){
			return getNetContent();
		}
		if(PRICE_PROPERTY.equals(property)){
			return getPrice();
		}
		if(PICTURE_PROPERTY.equals(property)){
			return getPicture();
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
	public Sku updateId(String id){
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
	public Sku updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setSize(String size){
		this.mSize = trimString(size);;
	}
	public String getSize(){
		return this.mSize;
	}
	public Sku updateSize(String size){
		this.mSize = trimString(size);;
		this.changed = true;
		return this;
	}
	public void mergeSize(String size){
		if(size != null) { setSize(size);}
	}
	
	
	public void setProduct(Product product){
		this.mProduct = product;;
	}
	public Product getProduct(){
		return this.mProduct;
	}
	public Sku updateProduct(Product product){
		this.mProduct = product;;
		this.changed = true;
		return this;
	}
	public void mergeProduct(Product product){
		if(product != null) { setProduct(product);}
	}
	
	
	public void clearProduct(){
		setProduct ( null );
		this.changed = true;
	}
	
	public void setBarcode(String barcode){
		this.mBarcode = trimString(barcode);;
	}
	public String getBarcode(){
		return this.mBarcode;
	}
	public Sku updateBarcode(String barcode){
		this.mBarcode = trimString(barcode);;
		this.changed = true;
		return this;
	}
	public void mergeBarcode(String barcode){
		if(barcode != null) { setBarcode(barcode);}
	}
	
	
	public void setPackageType(String packageType){
		this.mPackageType = trimString(packageType);;
	}
	public String getPackageType(){
		return this.mPackageType;
	}
	public Sku updatePackageType(String packageType){
		this.mPackageType = trimString(packageType);;
		this.changed = true;
		return this;
	}
	public void mergePackageType(String packageType){
		if(packageType != null) { setPackageType(packageType);}
	}
	
	
	public void setNetContent(String netContent){
		this.mNetContent = trimString(netContent);;
	}
	public String getNetContent(){
		return this.mNetContent;
	}
	public Sku updateNetContent(String netContent){
		this.mNetContent = trimString(netContent);;
		this.changed = true;
		return this;
	}
	public void mergeNetContent(String netContent){
		if(netContent != null) { setNetContent(netContent);}
	}
	
	
	public void setPrice(BigDecimal price){
		this.mPrice = price;;
	}
	public BigDecimal getPrice(){
		return this.mPrice;
	}
	public Sku updatePrice(BigDecimal price){
		this.mPrice = price;;
		this.changed = true;
		return this;
	}
	public void mergePrice(BigDecimal price){
		setPrice(price);
	}
	
	
	public void setPicture(String picture){
		this.mPicture = trimString(encodeUrl(picture));;
	}
	public String getPicture(){
		return this.mPicture;
	}
	public Sku updatePicture(String picture){
		this.mPicture = trimString(encodeUrl(picture));;
		this.changed = true;
		return this;
	}
	public void mergePicture(String picture){
		if(picture != null) { setPicture(picture);}
	}
	
	
	public void setVersion(int version){
		this.mVersion = version;;
	}
	public int getVersion(){
		return this.mVersion;
	}
	public Sku updateVersion(int version){
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
			goods.setSku(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );
		
	}
	
	public  void addGoods(Goods goods){
		goods.setSku(this);
		getGoodsList().add(goods);
	}
	public  void addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSku(this);
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
        // goods.clearSku(); //disconnect with Sku
        goods.clearFromAll(); //disconnect with Sku
		
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
		goods.setSku(null);
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

		addToEntityList(this, entityList, getProduct(), internalType);

		
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
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, SIZE_PROPERTY, getSize());
		appendKeyValuePair(result, PRODUCT_PROPERTY, getProduct());
		appendKeyValuePair(result, BARCODE_PROPERTY, getBarcode());
		appendKeyValuePair(result, PACKAGE_TYPE_PROPERTY, getPackageType());
		appendKeyValuePair(result, NET_CONTENT_PROPERTY, getNetContent());
		appendKeyValuePair(result, PRICE_PROPERTY, getPrice());
		appendKeyValuePair(result, PICTURE_PROPERTY, getPicture());
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
		
		
		if(baseDest instanceof Sku){
		
		
			Sku dest =(Sku)baseDest;
		
			dest.setId(getId());
			dest.setName(getName());
			dest.setSize(getSize());
			dest.setProduct(getProduct());
			dest.setBarcode(getBarcode());
			dest.setPackageType(getPackageType());
			dest.setNetContent(getNetContent());
			dest.setPrice(getPrice());
			dest.setPicture(getPicture());
			dest.setVersion(getVersion());
			dest.setGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Sku){
		
			
			Sku dest =(Sku)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeSize(getSize());
			dest.mergeProduct(getProduct());
			dest.mergeBarcode(getBarcode());
			dest.mergePackageType(getPackageType());
			dest.mergeNetContent(getNetContent());
			dest.mergePrice(getPrice());
			dest.mergePicture(getPicture());
			dest.mergeVersion(getVersion());
			dest.mergeGoodsList(getGoodsList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	
	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){
		
		
		if(baseDest instanceof Sku){
		
			
			Sku dest =(Sku)baseDest;
		
			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeSize(getSize());
			dest.mergeBarcode(getBarcode());
			dest.mergePackageType(getPackageType());
			dest.mergeNetContent(getNetContent());
			dest.mergePrice(getPrice());
			dest.mergePicture(getPicture());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getSize(), getProduct(), getBarcode(), getPackageType(), getNetContent(), getPrice(), getPicture(), getVersion()};
	}
	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("Sku{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tsize='"+getSize()+"';");
		if(getProduct() != null ){
 			stringBuilder.append("\tproduct='Product("+getProduct().getId()+")';");
 		}
		stringBuilder.append("\tbarcode='"+getBarcode()+"';");
		stringBuilder.append("\tpackageType='"+getPackageType()+"';");
		stringBuilder.append("\tnetContent='"+getNetContent()+"';");
		stringBuilder.append("\tprice='"+getPrice()+"';");
		stringBuilder.append("\tpicture='"+getPicture()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}
	
	//provide number calculation function
	

}

