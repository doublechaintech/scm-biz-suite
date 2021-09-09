
package com.doublechaintech.retailscm.sku;

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


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SIZE_PROPERTY, "size", "大小")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PRODUCT_PROPERTY, "product", "产品")
        .withType("product", Product.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BARCODE_PROPERTY, "barcode", "条码")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PACKAGE_TYPE_PROPERTY, "package_type", "包装类型")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NET_CONTENT_PROPERTY, "net_content", "净含量")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PRICE_PROPERTY, "price", "价格")
        .withType("money", "BigDecimal"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PICTURE_PROPERTY, "picture", "图片")
        .withType("string_image", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(GOODS_LIST, "sku", "商品列表")
        .withType("goods", Goods.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,SIZE_PROPERTY ,PRODUCT_PROPERTY ,BARCODE_PROPERTY ,PACKAGE_TYPE_PROPERTY ,NET_CONTENT_PROPERTY ,PRICE_PROPERTY ,PICTURE_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(GOODS_LIST, "sku");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(GOODS_LIST, Goods.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PRODUCT_PROPERTY, Product.class);

    return parents;
  }

  public Sku want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public Sku wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	size                ;
	protected		Product             	product             ;
	protected		String              	barcode             ;
	protected		String              	packageType         ;
	protected		String              	netContent          ;
	protected		BigDecimal          	price               ;
	protected		String              	picture             ;
	protected		int                 	version             ;

	
	protected		SmartList<Goods>    	mGoodsList          ;



	public 	Sku(){
		// lazy load for all the properties
	}
	public 	static Sku withId(String id){
		Sku sku = new Sku();
		sku.setId(id);
		sku.setVersion(Integer.MAX_VALUE);
		sku.setChecked(true);
		return sku;
	}
	public 	static Sku refById(String id){
		return withId(id);
	}

  public Sku limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public Sku limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static Sku searchExample(){
    Sku sku = new Sku();
    		sku.setVersion(UNSET_INT);

    return sku;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProduct( null );

		this.changed = true;
		setChecked(false);
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

 




	
	public void setId(String id){String oldId = this.id;String newId = trimString(id);this.id = newId;}
	public String id(){
doLoad();
return getId();
}
	public String getId(){
		return this.id;
	}
	public Sku updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public Sku orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public Sku ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public Sku addIdCriteria(QueryOperator operator, Object... parameters){
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
	public Sku updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public Sku orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public Sku ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public Sku addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setSize(String size){String oldSize = this.size;String newSize = trimString(size);this.size = newSize;}
	public String size(){
doLoad();
return getSize();
}
	public String getSize(){
		return this.size;
	}
	public Sku updateSize(String size){String oldSize = this.size;String newSize = trimString(size);if(!shouldReplaceBy(newSize, oldSize)){return this;}this.size = newSize;addPropertyChange(SIZE_PROPERTY, oldSize, newSize);this.changed = true;setChecked(false);return this;}
	public Sku orderBySize(boolean asc){
doAddOrderBy(SIZE_PROPERTY, asc);
return this;
}
	public SearchCriteria createSizeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SIZE_PROPERTY, operator, parameters);
}
	public Sku ignoreSizeCriteria(){super.ignoreSearchProperty(SIZE_PROPERTY);
return this;
}
	public Sku addSizeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSizeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSize(String size){
		if(size != null) { setSize(size);}
	}

	
	public void setProduct(Product product){Product oldProduct = this.product;Product newProduct = product;this.product = newProduct;}
	public Product product(){
doLoad();
return getProduct();
}
	public Product getProduct(){
		return this.product;
	}
	public Sku updateProduct(Product product){Product oldProduct = this.product;Product newProduct = product;if(!shouldReplaceBy(newProduct, oldProduct)){return this;}this.product = newProduct;addPropertyChange(PRODUCT_PROPERTY, oldProduct, newProduct);this.changed = true;setChecked(false);return this;}
	public Sku orderByProduct(boolean asc){
doAddOrderBy(PRODUCT_PROPERTY, asc);
return this;
}
	public SearchCriteria createProductCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PRODUCT_PROPERTY, operator, parameters);
}
	public Sku ignoreProductCriteria(){super.ignoreSearchProperty(PRODUCT_PROPERTY);
return this;
}
	public Sku addProductCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createProductCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeProduct(Product product){
		if(product != null) { setProduct(product);}
	}

	
	public void clearProduct(){
		setProduct ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setBarcode(String barcode){String oldBarcode = this.barcode;String newBarcode = trimString(barcode);this.barcode = newBarcode;}
	public String barcode(){
doLoad();
return getBarcode();
}
	public String getBarcode(){
		return this.barcode;
	}
	public Sku updateBarcode(String barcode){String oldBarcode = this.barcode;String newBarcode = trimString(barcode);if(!shouldReplaceBy(newBarcode, oldBarcode)){return this;}this.barcode = newBarcode;addPropertyChange(BARCODE_PROPERTY, oldBarcode, newBarcode);this.changed = true;setChecked(false);return this;}
	public Sku orderByBarcode(boolean asc){
doAddOrderBy(BARCODE_PROPERTY, asc);
return this;
}
	public SearchCriteria createBarcodeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BARCODE_PROPERTY, operator, parameters);
}
	public Sku ignoreBarcodeCriteria(){super.ignoreSearchProperty(BARCODE_PROPERTY);
return this;
}
	public Sku addBarcodeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBarcodeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBarcode(String barcode){
		if(barcode != null) { setBarcode(barcode);}
	}

	
	public void setPackageType(String packageType){String oldPackageType = this.packageType;String newPackageType = trimString(packageType);this.packageType = newPackageType;}
	public String packageType(){
doLoad();
return getPackageType();
}
	public String getPackageType(){
		return this.packageType;
	}
	public Sku updatePackageType(String packageType){String oldPackageType = this.packageType;String newPackageType = trimString(packageType);if(!shouldReplaceBy(newPackageType, oldPackageType)){return this;}this.packageType = newPackageType;addPropertyChange(PACKAGE_TYPE_PROPERTY, oldPackageType, newPackageType);this.changed = true;setChecked(false);return this;}
	public Sku orderByPackageType(boolean asc){
doAddOrderBy(PACKAGE_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createPackageTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PACKAGE_TYPE_PROPERTY, operator, parameters);
}
	public Sku ignorePackageTypeCriteria(){super.ignoreSearchProperty(PACKAGE_TYPE_PROPERTY);
return this;
}
	public Sku addPackageTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPackageTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePackageType(String packageType){
		if(packageType != null) { setPackageType(packageType);}
	}

	
	public void setNetContent(String netContent){String oldNetContent = this.netContent;String newNetContent = trimString(netContent);this.netContent = newNetContent;}
	public String netContent(){
doLoad();
return getNetContent();
}
	public String getNetContent(){
		return this.netContent;
	}
	public Sku updateNetContent(String netContent){String oldNetContent = this.netContent;String newNetContent = trimString(netContent);if(!shouldReplaceBy(newNetContent, oldNetContent)){return this;}this.netContent = newNetContent;addPropertyChange(NET_CONTENT_PROPERTY, oldNetContent, newNetContent);this.changed = true;setChecked(false);return this;}
	public Sku orderByNetContent(boolean asc){
doAddOrderBy(NET_CONTENT_PROPERTY, asc);
return this;
}
	public SearchCriteria createNetContentCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NET_CONTENT_PROPERTY, operator, parameters);
}
	public Sku ignoreNetContentCriteria(){super.ignoreSearchProperty(NET_CONTENT_PROPERTY);
return this;
}
	public Sku addNetContentCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNetContentCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeNetContent(String netContent){
		if(netContent != null) { setNetContent(netContent);}
	}

	
	public void setPrice(BigDecimal price){BigDecimal oldPrice = this.price;BigDecimal newPrice = price;this.price = newPrice;}
	public BigDecimal price(){
doLoad();
return getPrice();
}
	public BigDecimal getPrice(){
		return this.price;
	}
	public Sku updatePrice(BigDecimal price){BigDecimal oldPrice = this.price;BigDecimal newPrice = price;if(!shouldReplaceBy(newPrice, oldPrice)){return this;}this.price = newPrice;addPropertyChange(PRICE_PROPERTY, oldPrice, newPrice);this.changed = true;setChecked(false);return this;}
	public Sku orderByPrice(boolean asc){
doAddOrderBy(PRICE_PROPERTY, asc);
return this;
}
	public SearchCriteria createPriceCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PRICE_PROPERTY, operator, parameters);
}
	public Sku ignorePriceCriteria(){super.ignoreSearchProperty(PRICE_PROPERTY);
return this;
}
	public Sku addPriceCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPriceCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePrice(BigDecimal price){
		setPrice(price);
	}

	
	public void setPicture(String picture){String oldPicture = this.picture;String newPicture = trimString(encodeUrl(picture));;this.picture = newPicture;}
	public String picture(){
doLoad();
return getPicture();
}
	public String getPicture(){
		return this.picture;
	}
	public Sku updatePicture(String picture){String oldPicture = this.picture;String newPicture = trimString(encodeUrl(picture));;if(!shouldReplaceBy(newPicture, oldPicture)){return this;}this.picture = newPicture;addPropertyChange(PICTURE_PROPERTY, oldPicture, newPicture);this.changed = true;setChecked(false);return this;}
	public Sku orderByPicture(boolean asc){
doAddOrderBy(PICTURE_PROPERTY, asc);
return this;
}
	public SearchCriteria createPictureCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PICTURE_PROPERTY, operator, parameters);
}
	public Sku ignorePictureCriteria(){super.ignoreSearchProperty(PICTURE_PROPERTY);
return this;
}
	public Sku addPictureCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPictureCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePicture(String picture){
		if(picture != null) { setPicture(picture);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public Sku updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public Sku orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public Sku ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public Sku addVersionCriteria(QueryOperator operator, Object... parameters){
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
			goods.setSku(this);
		}

		this.mGoodsList = goodsList;
		this.mGoodsList.setListInternalName (GOODS_LIST );

	}

	public  Sku addGoods(Goods goods){
		goods.setSku(this);
		getGoodsList().add(goods);
		return this;
	}
	public  Sku addGoodsList(SmartList<Goods> goodsList){
		for( Goods goods:goodsList){
			goods.setSku(this);
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


	public static Sku createWith(RetailscmUserContext userContext, ThrowingFunction<Sku,Sku,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<Sku> customCreator = mapper.findCustomCreator(Sku.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    Sku result = new Sku();
    result.setName(mapper.tryToGet(Sku.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setSize(mapper.tryToGet(Sku.class, SIZE_PROPERTY, String.class,
        1, false, result.getSize(), params));
    result.setProduct(mapper.tryToGet(Sku.class, PRODUCT_PROPERTY, Product.class,
        0, true, result.getProduct(), params));
    result.setBarcode(mapper.tryToGet(Sku.class, BARCODE_PROPERTY, String.class,
        2, false, result.getBarcode(), params));
    result.setPackageType(mapper.tryToGet(Sku.class, PACKAGE_TYPE_PROPERTY, String.class,
        3, false, result.getPackageType(), params));
    result.setNetContent(mapper.tryToGet(Sku.class, NET_CONTENT_PROPERTY, String.class,
        4, false, result.getNetContent(), params));
    result.setPrice(mapper.tryToGet(Sku.class, PRICE_PROPERTY, BigDecimal.class,
        0, true, result.getPrice(), params));
    result.setPicture(mapper.tryToGet(Sku.class, PICTURE_PROPERTY, String.class,
        5, false, result.getPicture(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixSku(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      SkuTokens tokens = mapper.findParamByClass(params, SkuTokens.class);
      if (tokens == null) {
        tokens = SkuTokens.start();
      }
      result = userContext.getManagerGroup().getSkuManager().internalSaveSku(userContext, result, tokens.done());
      
    }
    return result;
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

