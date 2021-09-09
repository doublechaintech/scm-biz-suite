
package com.doublechaintech.retailscm.goodssupplier;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.supplyorder.SupplyOrder;
import com.doublechaintech.retailscm.supplierproduct.SupplierProduct;
import com.doublechaintech.retailscm.accountset.AccountSet;









@JsonSerialize(using = GoodsSupplierSerializer.class)
public class GoodsSupplier extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String SUPPLY_PRODUCT_PROPERTY        = "supplyProduct"     ;
	public static final String BELONG_TO_PROPERTY             = "belongTo"          ;
	public static final String CONTACT_NUMBER_PROPERTY        = "contactNumber"     ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String SUPPLIER_PRODUCT_LIST                    = "supplierProductList";
	public static final String SUPPLY_ORDER_LIST                        = "supplyOrderList"   ;
	public static final String ACCOUNT_SET_LIST                         = "accountSetList"    ;

	public static final String INTERNAL_TYPE="GoodsSupplier";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SUPPLY_PRODUCT_PROPERTY, "supply_product", "供应产品")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BELONG_TO_PROPERTY, "retail_store_country_center", "属于")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CONTACT_NUMBER_PROPERTY, "contact_number", "联系电话")
        .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SUPPLIER_PRODUCT_LIST, "supplier", "供应商产品列表")
        .withType("supplier_product", SupplierProduct.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(SUPPLY_ORDER_LIST, "seller", "供应订单列表")
        .withType("supply_order", SupplyOrder.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(ACCOUNT_SET_LIST, "goodsSupplier", "帐户设置列表")
        .withType("account_set", AccountSet.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,SUPPLY_PRODUCT_PROPERTY ,BELONG_TO_PROPERTY ,CONTACT_NUMBER_PROPERTY ,DESCRIPTION_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(SUPPLIER_PRODUCT_LIST, "supplier");
    	
    	    refers.put(SUPPLY_ORDER_LIST, "seller");
    	
    	    refers.put(ACCOUNT_SET_LIST, "goodsSupplier");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(SUPPLIER_PRODUCT_LIST, SupplierProduct.class);
        	
        	    refers.put(SUPPLY_ORDER_LIST, SupplyOrder.class);
        	
        	    refers.put(ACCOUNT_SET_LIST, AccountSet.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(BELONG_TO_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public GoodsSupplier want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public GoodsSupplier wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	supplyProduct       ;
	protected		RetailStoreCountryCenter	belongTo            ;
	protected		String              	contactNumber       ;
	protected		String              	description         ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<SupplierProduct>	mSupplierProductList;
	protected		SmartList<SupplyOrder>	mSupplyOrderList    ;
	protected		SmartList<AccountSet>	mAccountSetList     ;



	public 	GoodsSupplier(){
		// lazy load for all the properties
	}
	public 	static GoodsSupplier withId(String id){
		GoodsSupplier goodsSupplier = new GoodsSupplier();
		goodsSupplier.setId(id);
		goodsSupplier.setVersion(Integer.MAX_VALUE);
		goodsSupplier.setChecked(true);
		return goodsSupplier;
	}
	public 	static GoodsSupplier refById(String id){
		return withId(id);
	}

  public GoodsSupplier limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public GoodsSupplier limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static GoodsSupplier searchExample(){
    GoodsSupplier goodsSupplier = new GoodsSupplier();
    		goodsSupplier.setVersion(UNSET_INT);

    return goodsSupplier;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongTo( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(SUPPLY_PRODUCT_PROPERTY.equals(property)){
			changeSupplyProductProperty(newValueExpr);
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			changeContactNumberProperty(newValueExpr);
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			changeLastUpdateTimeProperty(newValueExpr);
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
			
			
			
	protected void changeSupplyProductProperty(String newValueExpr){
	
		String oldValue = getSupplyProduct();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateSupplyProduct(newValue);
		this.onChangeProperty(SUPPLY_PRODUCT_PROPERTY, oldValue, newValue);
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

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(SUPPLY_PRODUCT_PROPERTY.equals(property)){
			return getSupplyProduct();
		}
		if(BELONG_TO_PROPERTY.equals(property)){
			return getBelongTo();
		}
		if(CONTACT_NUMBER_PROPERTY.equals(property)){
			return getContactNumber();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(SUPPLIER_PRODUCT_LIST.equals(property)){
			List<BaseEntity> list = getSupplierProductList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(SUPPLY_ORDER_LIST.equals(property)){
			List<BaseEntity> list = getSupplyOrderList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(ACCOUNT_SET_LIST.equals(property)){
			List<BaseEntity> list = getAccountSetList().stream().map(item->item).collect(Collectors.toList());
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
	public GoodsSupplier updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public GoodsSupplier addIdCriteria(QueryOperator operator, Object... parameters){
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
	public GoodsSupplier updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public GoodsSupplier addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setSupplyProduct(String supplyProduct){String oldSupplyProduct = this.supplyProduct;String newSupplyProduct = trimString(supplyProduct);this.supplyProduct = newSupplyProduct;}
	public String supplyProduct(){
doLoad();
return getSupplyProduct();
}
	public String getSupplyProduct(){
		return this.supplyProduct;
	}
	public GoodsSupplier updateSupplyProduct(String supplyProduct){String oldSupplyProduct = this.supplyProduct;String newSupplyProduct = trimString(supplyProduct);if(!shouldReplaceBy(newSupplyProduct, oldSupplyProduct)){return this;}this.supplyProduct = newSupplyProduct;addPropertyChange(SUPPLY_PRODUCT_PROPERTY, oldSupplyProduct, newSupplyProduct);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderBySupplyProduct(boolean asc){
doAddOrderBy(SUPPLY_PRODUCT_PROPERTY, asc);
return this;
}
	public SearchCriteria createSupplyProductCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SUPPLY_PRODUCT_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreSupplyProductCriteria(){super.ignoreSearchProperty(SUPPLY_PRODUCT_PROPERTY);
return this;
}
	public GoodsSupplier addSupplyProductCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSupplyProductCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSupplyProduct(String supplyProduct){
		if(supplyProduct != null) { setSupplyProduct(supplyProduct);}
	}

	
	public void setBelongTo(RetailStoreCountryCenter belongTo){RetailStoreCountryCenter oldBelongTo = this.belongTo;RetailStoreCountryCenter newBelongTo = belongTo;this.belongTo = newBelongTo;}
	public RetailStoreCountryCenter belongTo(){
doLoad();
return getBelongTo();
}
	public RetailStoreCountryCenter getBelongTo(){
		return this.belongTo;
	}
	public GoodsSupplier updateBelongTo(RetailStoreCountryCenter belongTo){RetailStoreCountryCenter oldBelongTo = this.belongTo;RetailStoreCountryCenter newBelongTo = belongTo;if(!shouldReplaceBy(newBelongTo, oldBelongTo)){return this;}this.belongTo = newBelongTo;addPropertyChange(BELONG_TO_PROPERTY, oldBelongTo, newBelongTo);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderByBelongTo(boolean asc){
doAddOrderBy(BELONG_TO_PROPERTY, asc);
return this;
}
	public SearchCriteria createBelongToCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BELONG_TO_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreBelongToCriteria(){super.ignoreSearchProperty(BELONG_TO_PROPERTY);
return this;
}
	public GoodsSupplier addBelongToCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBelongToCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBelongTo(RetailStoreCountryCenter belongTo){
		if(belongTo != null) { setBelongTo(belongTo);}
	}

	
	public void clearBelongTo(){
		setBelongTo ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setContactNumber(String contactNumber){String oldContactNumber = this.contactNumber;String newContactNumber = trimString(contactNumber);this.contactNumber = newContactNumber;}
	public String contactNumber(){
doLoad();
return getContactNumber();
}
	public String getContactNumber(){
		return this.contactNumber;
	}
	public GoodsSupplier updateContactNumber(String contactNumber){String oldContactNumber = this.contactNumber;String newContactNumber = trimString(contactNumber);if(!shouldReplaceBy(newContactNumber, oldContactNumber)){return this;}this.contactNumber = newContactNumber;addPropertyChange(CONTACT_NUMBER_PROPERTY, oldContactNumber, newContactNumber);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderByContactNumber(boolean asc){
doAddOrderBy(CONTACT_NUMBER_PROPERTY, asc);
return this;
}
	public SearchCriteria createContactNumberCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CONTACT_NUMBER_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreContactNumberCriteria(){super.ignoreSearchProperty(CONTACT_NUMBER_PROPERTY);
return this;
}
	public GoodsSupplier addContactNumberCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createContactNumberCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}

	

	public String getMaskedContactNumber(){
		String mobilePhoneNumber = getContactNumber();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}

		
	public void setDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);this.description = newDescription;}
	public String description(){
doLoad();
return getDescription();
}
	public String getDescription(){
		return this.description;
	}
	public GoodsSupplier updateDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);if(!shouldReplaceBy(newDescription, oldDescription)){return this;}this.description = newDescription;addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderByDescription(boolean asc){
doAddOrderBy(DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreDescriptionCriteria(){super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
return this;
}
	public GoodsSupplier addDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}

	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public GoodsSupplier updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public GoodsSupplier addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
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
	public GoodsSupplier updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public GoodsSupplier orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public GoodsSupplier ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public GoodsSupplier addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<SupplierProduct> getSupplierProductList(){
		if(this.mSupplierProductList == null){
			this.mSupplierProductList = new SmartList<SupplierProduct>();
			this.mSupplierProductList.setListInternalName (SUPPLIER_PRODUCT_LIST );
			//有名字，便于做权限控制
		}

		return this.mSupplierProductList;
	}

  public  SmartList<SupplierProduct> supplierProductList(){
    
    doLoadChild(SUPPLIER_PRODUCT_LIST);
    
    return getSupplierProductList();
  }


	public  void setSupplierProductList(SmartList<SupplierProduct> supplierProductList){
		for( SupplierProduct supplierProduct:supplierProductList){
			supplierProduct.setSupplier(this);
		}

		this.mSupplierProductList = supplierProductList;
		this.mSupplierProductList.setListInternalName (SUPPLIER_PRODUCT_LIST );

	}

	public  GoodsSupplier addSupplierProduct(SupplierProduct supplierProduct){
		supplierProduct.setSupplier(this);
		getSupplierProductList().add(supplierProduct);
		return this;
	}
	public  GoodsSupplier addSupplierProductList(SmartList<SupplierProduct> supplierProductList){
		for( SupplierProduct supplierProduct:supplierProductList){
			supplierProduct.setSupplier(this);
		}
		getSupplierProductList().addAll(supplierProductList);
		return this;
	}
	public  void mergeSupplierProductList(SmartList<SupplierProduct> supplierProductList){
		if(supplierProductList==null){
			return;
		}
		if(supplierProductList.isEmpty()){
			return;
		}
		addSupplierProductList( supplierProductList );

	}
	public  SupplierProduct removeSupplierProduct(SupplierProduct supplierProductIndex){

		int index = getSupplierProductList().indexOf(supplierProductIndex);
        if(index < 0){
        	String message = "SupplierProduct("+supplierProductIndex.getId()+") with version='"+supplierProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplierProduct supplierProduct = getSupplierProductList().get(index);
        // supplierProduct.clearSupplier(); //disconnect with Supplier
        supplierProduct.clearFromAll(); //disconnect with Supplier

		boolean result = getSupplierProductList().planToRemove(supplierProduct);
        if(!result){
        	String message = "SupplierProduct("+supplierProductIndex.getId()+") with version='"+supplierProductIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplierProduct;


	}
	//断舍离
	public  void breakWithSupplierProduct(SupplierProduct supplierProduct){

		if(supplierProduct == null){
			return;
		}
		supplierProduct.setSupplier(null);
		//getSupplierProductList().remove();

	}

	public  boolean hasSupplierProduct(SupplierProduct supplierProduct){

		return getSupplierProductList().contains(supplierProduct);

	}

	public void copySupplierProductFrom(SupplierProduct supplierProduct) {

		SupplierProduct supplierProductInList = findTheSupplierProduct(supplierProduct);
		SupplierProduct newSupplierProduct = new SupplierProduct();
		supplierProductInList.copyTo(newSupplierProduct);
		newSupplierProduct.setVersion(0);//will trigger copy
		getSupplierProductList().add(newSupplierProduct);
		addItemToFlexiableObject(COPIED_CHILD, newSupplierProduct);
	}

	public  SupplierProduct findTheSupplierProduct(SupplierProduct supplierProduct){

		int index =  getSupplierProductList().indexOf(supplierProduct);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplierProduct("+supplierProduct.getId()+") with version='"+supplierProduct.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getSupplierProductList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpSupplierProductList(){
		getSupplierProductList().clear();
	}





	public  SmartList<SupplyOrder> getSupplyOrderList(){
		if(this.mSupplyOrderList == null){
			this.mSupplyOrderList = new SmartList<SupplyOrder>();
			this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
			//有名字，便于做权限控制
		}

		return this.mSupplyOrderList;
	}

  public  SmartList<SupplyOrder> supplyOrderList(){
    
    doLoadChild(SUPPLY_ORDER_LIST);
    
    return getSupplyOrderList();
  }


	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setSeller(this);
		}

		this.mSupplyOrderList = supplyOrderList;
		this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );

	}

	public  GoodsSupplier addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setSeller(this);
		getSupplyOrderList().add(supplyOrder);
		return this;
	}
	public  GoodsSupplier addSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setSeller(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
		return this;
	}
	public  void mergeSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		if(supplyOrderList==null){
			return;
		}
		if(supplyOrderList.isEmpty()){
			return;
		}
		addSupplyOrderList( supplyOrderList );

	}
	public  SupplyOrder removeSupplyOrder(SupplyOrder supplyOrderIndex){

		int index = getSupplyOrderList().indexOf(supplyOrderIndex);
        if(index < 0){
        	String message = "SupplyOrder("+supplyOrderIndex.getId()+") with version='"+supplyOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        SupplyOrder supplyOrder = getSupplyOrderList().get(index);
        // supplyOrder.clearSeller(); //disconnect with Seller
        supplyOrder.clearFromAll(); //disconnect with Seller

		boolean result = getSupplyOrderList().planToRemove(supplyOrder);
        if(!result){
        	String message = "SupplyOrder("+supplyOrderIndex.getId()+") with version='"+supplyOrderIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return supplyOrder;


	}
	//断舍离
	public  void breakWithSupplyOrder(SupplyOrder supplyOrder){

		if(supplyOrder == null){
			return;
		}
		supplyOrder.setSeller(null);
		//getSupplyOrderList().remove();

	}

	public  boolean hasSupplyOrder(SupplyOrder supplyOrder){

		return getSupplyOrderList().contains(supplyOrder);

	}

	public void copySupplyOrderFrom(SupplyOrder supplyOrder) {

		SupplyOrder supplyOrderInList = findTheSupplyOrder(supplyOrder);
		SupplyOrder newSupplyOrder = new SupplyOrder();
		supplyOrderInList.copyTo(newSupplyOrder);
		newSupplyOrder.setVersion(0);//will trigger copy
		getSupplyOrderList().add(newSupplyOrder);
		addItemToFlexiableObject(COPIED_CHILD, newSupplyOrder);
	}

	public  SupplyOrder findTheSupplyOrder(SupplyOrder supplyOrder){

		int index =  getSupplyOrderList().indexOf(supplyOrder);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "SupplyOrder("+supplyOrder.getId()+") with version='"+supplyOrder.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getSupplyOrderList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpSupplyOrderList(){
		getSupplyOrderList().clear();
	}





	public  SmartList<AccountSet> getAccountSetList(){
		if(this.mAccountSetList == null){
			this.mAccountSetList = new SmartList<AccountSet>();
			this.mAccountSetList.setListInternalName (ACCOUNT_SET_LIST );
			//有名字，便于做权限控制
		}

		return this.mAccountSetList;
	}

  public  SmartList<AccountSet> accountSetList(){
    
    doLoadChild(ACCOUNT_SET_LIST);
    
    return getAccountSetList();
  }


	public  void setAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setGoodsSupplier(this);
		}

		this.mAccountSetList = accountSetList;
		this.mAccountSetList.setListInternalName (ACCOUNT_SET_LIST );

	}

	public  GoodsSupplier addAccountSet(AccountSet accountSet){
		accountSet.setGoodsSupplier(this);
		getAccountSetList().add(accountSet);
		return this;
	}
	public  GoodsSupplier addAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setGoodsSupplier(this);
		}
		getAccountSetList().addAll(accountSetList);
		return this;
	}
	public  void mergeAccountSetList(SmartList<AccountSet> accountSetList){
		if(accountSetList==null){
			return;
		}
		if(accountSetList.isEmpty()){
			return;
		}
		addAccountSetList( accountSetList );

	}
	public  AccountSet removeAccountSet(AccountSet accountSetIndex){

		int index = getAccountSetList().indexOf(accountSetIndex);
        if(index < 0){
        	String message = "AccountSet("+accountSetIndex.getId()+") with version='"+accountSetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        AccountSet accountSet = getAccountSetList().get(index);
        // accountSet.clearGoodsSupplier(); //disconnect with GoodsSupplier
        accountSet.clearFromAll(); //disconnect with GoodsSupplier

		boolean result = getAccountSetList().planToRemove(accountSet);
        if(!result){
        	String message = "AccountSet("+accountSetIndex.getId()+") with version='"+accountSetIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return accountSet;


	}
	//断舍离
	public  void breakWithAccountSet(AccountSet accountSet){

		if(accountSet == null){
			return;
		}
		accountSet.setGoodsSupplier(null);
		//getAccountSetList().remove();

	}

	public  boolean hasAccountSet(AccountSet accountSet){

		return getAccountSetList().contains(accountSet);

	}

	public void copyAccountSetFrom(AccountSet accountSet) {

		AccountSet accountSetInList = findTheAccountSet(accountSet);
		AccountSet newAccountSet = new AccountSet();
		accountSetInList.copyTo(newAccountSet);
		newAccountSet.setVersion(0);//will trigger copy
		getAccountSetList().add(newAccountSet);
		addItemToFlexiableObject(COPIED_CHILD, newAccountSet);
	}

	public  AccountSet findTheAccountSet(AccountSet accountSet){

		int index =  getAccountSetList().indexOf(accountSet);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "AccountSet("+accountSet.getId()+") with version='"+accountSet.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getAccountSetList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpAccountSetList(){
		getAccountSetList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getBelongTo(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getSupplierProductList(), internalType);
		collectFromList(this, entityList, getSupplyOrderList(), internalType);
		collectFromList(this, entityList, getAccountSetList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getSupplierProductList());
		listOfList.add( getSupplyOrderList());
		listOfList.add( getAccountSetList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, SUPPLY_PRODUCT_PROPERTY, getSupplyProduct());
		appendKeyValuePair(result, BELONG_TO_PROPERTY, getBelongTo());
		appendKeyValuePair(result, CONTACT_NUMBER_PROPERTY, getMaskedContactNumber());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, SUPPLIER_PRODUCT_LIST, getSupplierProductList());
		if(!getSupplierProductList().isEmpty()){
			appendKeyValuePair(result, "supplierProductCount", getSupplierProductList().getTotalCount());
			appendKeyValuePair(result, "supplierProductCurrentPageNumber", getSupplierProductList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, SUPPLY_ORDER_LIST, getSupplyOrderList());
		if(!getSupplyOrderList().isEmpty()){
			appendKeyValuePair(result, "supplyOrderCount", getSupplyOrderList().getTotalCount());
			appendKeyValuePair(result, "supplyOrderCurrentPageNumber", getSupplyOrderList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, ACCOUNT_SET_LIST, getAccountSetList());
		if(!getAccountSetList().isEmpty()){
			appendKeyValuePair(result, "accountSetCount", getAccountSetList().getTotalCount());
			appendKeyValuePair(result, "accountSetCurrentPageNumber", getAccountSetList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof GoodsSupplier){


			GoodsSupplier dest =(GoodsSupplier)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setSupplyProduct(getSupplyProduct());
			dest.setBelongTo(getBelongTo());
			dest.setContactNumber(getContactNumber());
			dest.setDescription(getDescription());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setSupplierProductList(getSupplierProductList());
			dest.setSupplyOrderList(getSupplyOrderList());
			dest.setAccountSetList(getAccountSetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof GoodsSupplier){


			GoodsSupplier dest =(GoodsSupplier)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeSupplyProduct(getSupplyProduct());
			dest.mergeBelongTo(getBelongTo());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeSupplierProductList(getSupplierProductList());
			dest.mergeSupplyOrderList(getSupplyOrderList());
			dest.mergeAccountSetList(getAccountSetList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof GoodsSupplier){


			GoodsSupplier dest =(GoodsSupplier)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeSupplyProduct(getSupplyProduct());
			dest.mergeContactNumber(getContactNumber());
			dest.mergeDescription(getDescription());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getSupplyProduct(), getBelongTo(), getContactNumber(), getDescription(), getLastUpdateTime(), getVersion()};
	}


	public static GoodsSupplier createWith(RetailscmUserContext userContext, ThrowingFunction<GoodsSupplier,GoodsSupplier,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<GoodsSupplier> customCreator = mapper.findCustomCreator(GoodsSupplier.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    GoodsSupplier result = new GoodsSupplier();
    result.setName(mapper.tryToGet(GoodsSupplier.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setSupplyProduct(mapper.tryToGet(GoodsSupplier.class, SUPPLY_PRODUCT_PROPERTY, String.class,
        1, false, result.getSupplyProduct(), params));
    result.setBelongTo(mapper.tryToGet(GoodsSupplier.class, BELONG_TO_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getBelongTo(), params));
    result.setContactNumber(mapper.tryToGet(GoodsSupplier.class, CONTACT_NUMBER_PROPERTY, String.class,
        2, false, result.getContactNumber(), params));
    result.setDescription(mapper.tryToGet(GoodsSupplier.class, DESCRIPTION_PROPERTY, String.class,
        3, false, result.getDescription(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixGoodsSupplier(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      GoodsSupplierTokens tokens = mapper.findParamByClass(params, GoodsSupplierTokens.class);
      if (tokens == null) {
        tokens = GoodsSupplierTokens.start();
      }
      result = userContext.getManagerGroup().getGoodsSupplierManager().internalSaveGoodsSupplier(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("GoodsSupplier{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tsupplyProduct='"+getSupplyProduct()+"';");
		if(getBelongTo() != null ){
 			stringBuilder.append("\tbelongTo='RetailStoreCountryCenter("+getBelongTo().getId()+")';");
 		}
		stringBuilder.append("\tcontactNumber='"+getContactNumber()+"';");
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

