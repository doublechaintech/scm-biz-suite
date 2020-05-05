
package com.doublechaintech.retailscm.goodssupplier;

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
	protected		String              	mSupplyProduct      ;
	protected		RetailStoreCountryCenter	mBelongTo           ;
	protected		String              	mContactNumber      ;
	protected		String              	mDescription        ;
	protected		DateTime            	mLastUpdateTime     ;
	protected		int                 	mVersion            ;
	
	
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
		return goodsSupplier;
	}
	public 	static GoodsSupplier refById(String id){
		return withId(id);
	}
	
	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setBelongTo( null );

		this.changed = true;
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
    
    


	
	
	
	public void setId(String id){
		this.mId = trimString(id);;
	}
	public String getId(){
		return this.mId;
	}
	public GoodsSupplier updateId(String id){
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
	public GoodsSupplier updateName(String name){
		this.mName = trimString(name);;
		this.changed = true;
		return this;
	}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}
	
	
	public void setSupplyProduct(String supplyProduct){
		this.mSupplyProduct = trimString(supplyProduct);;
	}
	public String getSupplyProduct(){
		return this.mSupplyProduct;
	}
	public GoodsSupplier updateSupplyProduct(String supplyProduct){
		this.mSupplyProduct = trimString(supplyProduct);;
		this.changed = true;
		return this;
	}
	public void mergeSupplyProduct(String supplyProduct){
		if(supplyProduct != null) { setSupplyProduct(supplyProduct);}
	}
	
	
	public void setBelongTo(RetailStoreCountryCenter belongTo){
		this.mBelongTo = belongTo;;
	}
	public RetailStoreCountryCenter getBelongTo(){
		return this.mBelongTo;
	}
	public GoodsSupplier updateBelongTo(RetailStoreCountryCenter belongTo){
		this.mBelongTo = belongTo;;
		this.changed = true;
		return this;
	}
	public void mergeBelongTo(RetailStoreCountryCenter belongTo){
		if(belongTo != null) { setBelongTo(belongTo);}
	}
	
	
	public void clearBelongTo(){
		setBelongTo ( null );
		this.changed = true;
	}
	
	public void setContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
	}
	public String getContactNumber(){
		return this.mContactNumber;
	}
	public GoodsSupplier updateContactNumber(String contactNumber){
		this.mContactNumber = trimString(contactNumber);;
		this.changed = true;
		return this;
	}
	public void mergeContactNumber(String contactNumber){
		if(contactNumber != null) { setContactNumber(contactNumber);}
	}
	
	
	
	public String getMaskedContactNumber(){
		String mobilePhoneNumber = getContactNumber();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}
	
		
	public void setDescription(String description){
		this.mDescription = trimString(description);;
	}
	public String getDescription(){
		return this.mDescription;
	}
	public GoodsSupplier updateDescription(String description){
		this.mDescription = trimString(description);;
		this.changed = true;
		return this;
	}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}
	
	
	public void setLastUpdateTime(DateTime lastUpdateTime){
		this.mLastUpdateTime = lastUpdateTime;;
	}
	public DateTime getLastUpdateTime(){
		return this.mLastUpdateTime;
	}
	public GoodsSupplier updateLastUpdateTime(DateTime lastUpdateTime){
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
	public GoodsSupplier updateVersion(int version){
		this.mVersion = version;;
		this.changed = true;
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
	public  void setSupplierProductList(SmartList<SupplierProduct> supplierProductList){
		for( SupplierProduct supplierProduct:supplierProductList){
			supplierProduct.setSupplier(this);
		}

		this.mSupplierProductList = supplierProductList;
		this.mSupplierProductList.setListInternalName (SUPPLIER_PRODUCT_LIST );
		
	}
	
	public  void addSupplierProduct(SupplierProduct supplierProduct){
		supplierProduct.setSupplier(this);
		getSupplierProductList().add(supplierProduct);
	}
	public  void addSupplierProductList(SmartList<SupplierProduct> supplierProductList){
		for( SupplierProduct supplierProduct:supplierProductList){
			supplierProduct.setSupplier(this);
		}
		getSupplierProductList().addAll(supplierProductList);
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
	public  void setSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setSeller(this);
		}

		this.mSupplyOrderList = supplyOrderList;
		this.mSupplyOrderList.setListInternalName (SUPPLY_ORDER_LIST );
		
	}
	
	public  void addSupplyOrder(SupplyOrder supplyOrder){
		supplyOrder.setSeller(this);
		getSupplyOrderList().add(supplyOrder);
	}
	public  void addSupplyOrderList(SmartList<SupplyOrder> supplyOrderList){
		for( SupplyOrder supplyOrder:supplyOrderList){
			supplyOrder.setSeller(this);
		}
		getSupplyOrderList().addAll(supplyOrderList);
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
	public  void setAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setGoodsSupplier(this);
		}

		this.mAccountSetList = accountSetList;
		this.mAccountSetList.setListInternalName (ACCOUNT_SET_LIST );
		
	}
	
	public  void addAccountSet(AccountSet accountSet){
		accountSet.setGoodsSupplier(this);
		getAccountSetList().add(accountSet);
	}
	public  void addAccountSetList(SmartList<AccountSet> accountSetList){
		for( AccountSet accountSet:accountSetList){
			accountSet.setGoodsSupplier(this);
		}
		getAccountSetList().addAll(accountSetList);
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

