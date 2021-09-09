
package com.doublechaintech.retailscm.warehouse;
import com.doublechaintech.retailscm.CommonTokens;
import java.util.Map;
import java.util.Objects;

import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterTokens;
import com.doublechaintech.retailscm.storagespace.StorageSpaceTokens;
import com.doublechaintech.retailscm.smartpallet.SmartPalletTokens;
import com.doublechaintech.retailscm.supplierspace.SupplierSpaceTokens;
import com.doublechaintech.retailscm.receivingspace.ReceivingSpaceTokens;
import com.doublechaintech.retailscm.shippingspace.ShippingSpaceTokens;
import com.doublechaintech.retailscm.damagespace.DamageSpaceTokens;
import com.doublechaintech.retailscm.warehouseasset.WarehouseAssetTokens;





public class WarehouseTokens extends CommonTokens{

	static final String ALL="__all__"; //do not assign this to common users.
	static final String SELF="__self__";
	static final String OWNER_OBJECT_NAME="warehouse";

	public static boolean checkOptions(Map<String,Object> options, String optionToCheck){

		if(options==null){
 			return false; //completely no option here
 		}
 		if(options.containsKey(ALL)){
 			//danger, debug only, might load the entire database!, really terrible
 			return true;
 		}
		String ownerKey = getOwnerObjectKey();
		Object ownerObject =(String) options.get(ownerKey);
		if(ownerObject ==  null){
			return false;
		}
		if(!ownerObject.equals(OWNER_OBJECT_NAME)){ //is the owner?
			return false;
		}

 		if(options.containsKey(optionToCheck)){
 			//options.remove(optionToCheck);
 			//consume the key, can not use any more to extract the data with the same token.
 			return true;
 		}

 		return false;

	}
	protected WarehouseTokens(){
		//ensure not initialized outside the class
	}
	public  static  WarehouseTokens of(Map<String,Object> options){
		//ensure not initialized outside the class
		WarehouseTokens tokens = new WarehouseTokens(options);
		return tokens;

	}
	protected WarehouseTokens(Map<String,Object> options){
		this.options = options;
	}

	public WarehouseTokens merge(String [] tokens){
		this.parseTokens(tokens);
		return this;
	}

	public static WarehouseTokens mergeAll(String [] tokens){

		return allTokens().merge(tokens);
	}

	protected WarehouseTokens setOwnerObject(String objectName){
		ensureOptions();
		addSimpleOptions(getOwnerObjectKey(), objectName);
		return this;
	}




	public static WarehouseTokens start(){
		return new WarehouseTokens().setOwnerObject(OWNER_OBJECT_NAME);
	}

	public WarehouseTokens withTokenFromListName(String listName){
		addSimpleOptions(listName);
		return this;
	}

  public static WarehouseTokens loadGroupTokens(String... groupNames){
    WarehouseTokens tokens = start();
    if (groupNames == null || groupNames.length == 0){
      return allTokens();
    }
    addToken(tokens, OWNER, groupNames, new String[]{"default"});

  
     addToken(tokens, STORAGE_SPACE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SMART_PALLET_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SUPPLIER_SPACE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, RECEIVING_SPACE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, SHIPPING_SPACE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, DAMAGE_SPACE_LIST, groupNames, new String[]{"default"});
    
     addToken(tokens, WAREHOUSE_ASSET_LIST, groupNames, new String[]{"default"});
    
    return tokens;
  }

  private static void addToken(WarehouseTokens pTokens, String pTokenName, String[] pGroupNames, String[] fieldGroups) {
    if (pGroupNames == null || fieldGroups == null){
      return;
    }

    for (String groupName: pGroupNames){
      for(String g: fieldGroups){
        if( Objects.equals(groupName, g)){
          pTokens.addSimpleOptions(pTokenName);
          break;
        }
      }
    }
  }

	public static WarehouseTokens filterWithTokenViewGroups(String []viewGroups){

		return start()
			.withOwner()
			.withStorageSpaceListIfViewGroupInclude(viewGroups)
			.withSmartPalletListIfViewGroupInclude(viewGroups)
			.withSupplierSpaceListIfViewGroupInclude(viewGroups)
			.withReceivingSpaceListIfViewGroupInclude(viewGroups)
			.withShippingSpaceListIfViewGroupInclude(viewGroups)
			.withDamageSpaceListIfViewGroupInclude(viewGroups)
			.withWarehouseAssetListIfViewGroupInclude(viewGroups);

	}

	public static WarehouseTokens allTokens(){

		return start()
			.withOwner()
			.withStorageSpaceList()
			.withSmartPalletList()
			.withSupplierSpaceList()
			.withReceivingSpaceList()
			.withShippingSpaceList()
			.withDamageSpaceList()
			.withWarehouseAssetList();

	}
	public static WarehouseTokens withoutListsTokens(){

		return start()
			.withOwner();

	}

	public static Map <String,Object> all(){
		return allTokens().done();
	}
	public static Map <String,Object> withoutLists(){
		return withoutListsTokens().done();
	}
	public static Map <String,Object> empty(){
		return start().done();
	}

	public WarehouseTokens analyzeAllLists(){
		addSimpleOptions(ALL_LISTS_ANALYZE);
		return this;
	}

	protected static final String OWNER = "owner";
	public String getOwner(){
		return OWNER;
	}
	//
	public WarehouseTokens withOwner(){
		addSimpleOptions(OWNER);
		return this;
	}

	public RetailStoreCountryCenterTokens withOwnerTokens(){
		//addSimpleOptions(OWNER);
		return RetailStoreCountryCenterTokens.start();
	}

	
	protected static final String STORAGE_SPACE_LIST = "storageSpaceList";
	public String getStorageSpaceList(){
		return STORAGE_SPACE_LIST;
	}



	public WarehouseTokens withStorageSpaceListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(STORAGE_SPACE_LIST);
		}
		return this;
	}


	public WarehouseTokens withStorageSpaceList(){
		addSimpleOptions(STORAGE_SPACE_LIST);
		return this;
	}

	public StorageSpaceTokens withStorageSpaceListTokens(){
		//addSimpleOptions(STORAGE_SPACE_LIST);
		return StorageSpaceTokens.start();
	}

	public WarehouseTokens analyzeStorageSpaceList(){
		addSimpleOptions(STORAGE_SPACE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeStorageSpaceListEnabled(){

		if(checkOptions(this.options(), STORAGE_SPACE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WarehouseTokens extractMoreFromStorageSpaceList(String idsSeperatedWithComma){
		addSimpleOptions(STORAGE_SPACE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int storageSpaceListSortCounter = 0;
	public WarehouseTokens sortStorageSpaceListWith(String field, String descOrAsc){
		addSortMoreOptions(STORAGE_SPACE_LIST,storageSpaceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int storageSpaceListSearchCounter = 0;
	public WarehouseTokens searchStorageSpaceListWith(String field, String verb, String value){

		withStorageSpaceList();
		addSearchMoreOptions(STORAGE_SPACE_LIST,storageSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens searchAllTextOfStorageSpaceList(String verb, String value){
		String field = "id|location|contactNumber|totalArea";
		addSearchMoreOptions(STORAGE_SPACE_LIST,storageSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens rowsPerPageOfStorageSpaceList(int rowsPerPage){
		addSimpleOptions(STORAGE_SPACE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WarehouseTokens currentPageNumberOfStorageSpaceList(int currentPageNumber){
		addSimpleOptions(STORAGE_SPACE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WarehouseTokens retainColumnsOfStorageSpaceList(String[] columns){
		addSimpleOptions(STORAGE_SPACE_LIST+"RetainColumns",columns);
		return this;
	}
	public WarehouseTokens excludeColumnsOfStorageSpaceList(String[] columns){
		addSimpleOptions(STORAGE_SPACE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SMART_PALLET_LIST = "smartPalletList";
	public String getSmartPalletList(){
		return SMART_PALLET_LIST;
	}



	public WarehouseTokens withSmartPalletListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SMART_PALLET_LIST);
		}
		return this;
	}


	public WarehouseTokens withSmartPalletList(){
		addSimpleOptions(SMART_PALLET_LIST);
		return this;
	}

	public SmartPalletTokens withSmartPalletListTokens(){
		//addSimpleOptions(SMART_PALLET_LIST);
		return SmartPalletTokens.start();
	}

	public WarehouseTokens analyzeSmartPalletList(){
		addSimpleOptions(SMART_PALLET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSmartPalletListEnabled(){

		if(checkOptions(this.options(), SMART_PALLET_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WarehouseTokens extractMoreFromSmartPalletList(String idsSeperatedWithComma){
		addSimpleOptions(SMART_PALLET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int smartPalletListSortCounter = 0;
	public WarehouseTokens sortSmartPalletListWith(String field, String descOrAsc){
		addSortMoreOptions(SMART_PALLET_LIST,smartPalletListSortCounter++, field, descOrAsc);
		return this;
	}
	private int smartPalletListSearchCounter = 0;
	public WarehouseTokens searchSmartPalletListWith(String field, String verb, String value){

		withSmartPalletList();
		addSearchMoreOptions(SMART_PALLET_LIST,smartPalletListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens searchAllTextOfSmartPalletList(String verb, String value){
		String field = "id|location|contactNumber|totalArea";
		addSearchMoreOptions(SMART_PALLET_LIST,smartPalletListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens rowsPerPageOfSmartPalletList(int rowsPerPage){
		addSimpleOptions(SMART_PALLET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WarehouseTokens currentPageNumberOfSmartPalletList(int currentPageNumber){
		addSimpleOptions(SMART_PALLET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WarehouseTokens retainColumnsOfSmartPalletList(String[] columns){
		addSimpleOptions(SMART_PALLET_LIST+"RetainColumns",columns);
		return this;
	}
	public WarehouseTokens excludeColumnsOfSmartPalletList(String[] columns){
		addSimpleOptions(SMART_PALLET_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SUPPLIER_SPACE_LIST = "supplierSpaceList";
	public String getSupplierSpaceList(){
		return SUPPLIER_SPACE_LIST;
	}



	public WarehouseTokens withSupplierSpaceListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SUPPLIER_SPACE_LIST);
		}
		return this;
	}


	public WarehouseTokens withSupplierSpaceList(){
		addSimpleOptions(SUPPLIER_SPACE_LIST);
		return this;
	}

	public SupplierSpaceTokens withSupplierSpaceListTokens(){
		//addSimpleOptions(SUPPLIER_SPACE_LIST);
		return SupplierSpaceTokens.start();
	}

	public WarehouseTokens analyzeSupplierSpaceList(){
		addSimpleOptions(SUPPLIER_SPACE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeSupplierSpaceListEnabled(){

		if(checkOptions(this.options(), SUPPLIER_SPACE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WarehouseTokens extractMoreFromSupplierSpaceList(String idsSeperatedWithComma){
		addSimpleOptions(SUPPLIER_SPACE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int supplierSpaceListSortCounter = 0;
	public WarehouseTokens sortSupplierSpaceListWith(String field, String descOrAsc){
		addSortMoreOptions(SUPPLIER_SPACE_LIST,supplierSpaceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int supplierSpaceListSearchCounter = 0;
	public WarehouseTokens searchSupplierSpaceListWith(String field, String verb, String value){

		withSupplierSpaceList();
		addSearchMoreOptions(SUPPLIER_SPACE_LIST,supplierSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens searchAllTextOfSupplierSpaceList(String verb, String value){
		String field = "id|location|contactNumber|totalArea";
		addSearchMoreOptions(SUPPLIER_SPACE_LIST,supplierSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens rowsPerPageOfSupplierSpaceList(int rowsPerPage){
		addSimpleOptions(SUPPLIER_SPACE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WarehouseTokens currentPageNumberOfSupplierSpaceList(int currentPageNumber){
		addSimpleOptions(SUPPLIER_SPACE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WarehouseTokens retainColumnsOfSupplierSpaceList(String[] columns){
		addSimpleOptions(SUPPLIER_SPACE_LIST+"RetainColumns",columns);
		return this;
	}
	public WarehouseTokens excludeColumnsOfSupplierSpaceList(String[] columns){
		addSimpleOptions(SUPPLIER_SPACE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String RECEIVING_SPACE_LIST = "receivingSpaceList";
	public String getReceivingSpaceList(){
		return RECEIVING_SPACE_LIST;
	}



	public WarehouseTokens withReceivingSpaceListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(RECEIVING_SPACE_LIST);
		}
		return this;
	}


	public WarehouseTokens withReceivingSpaceList(){
		addSimpleOptions(RECEIVING_SPACE_LIST);
		return this;
	}

	public ReceivingSpaceTokens withReceivingSpaceListTokens(){
		//addSimpleOptions(RECEIVING_SPACE_LIST);
		return ReceivingSpaceTokens.start();
	}

	public WarehouseTokens analyzeReceivingSpaceList(){
		addSimpleOptions(RECEIVING_SPACE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeReceivingSpaceListEnabled(){

		if(checkOptions(this.options(), RECEIVING_SPACE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WarehouseTokens extractMoreFromReceivingSpaceList(String idsSeperatedWithComma){
		addSimpleOptions(RECEIVING_SPACE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int receivingSpaceListSortCounter = 0;
	public WarehouseTokens sortReceivingSpaceListWith(String field, String descOrAsc){
		addSortMoreOptions(RECEIVING_SPACE_LIST,receivingSpaceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int receivingSpaceListSearchCounter = 0;
	public WarehouseTokens searchReceivingSpaceListWith(String field, String verb, String value){

		withReceivingSpaceList();
		addSearchMoreOptions(RECEIVING_SPACE_LIST,receivingSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens searchAllTextOfReceivingSpaceList(String verb, String value){
		String field = "id|location|contactNumber|description|totalArea";
		addSearchMoreOptions(RECEIVING_SPACE_LIST,receivingSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens rowsPerPageOfReceivingSpaceList(int rowsPerPage){
		addSimpleOptions(RECEIVING_SPACE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WarehouseTokens currentPageNumberOfReceivingSpaceList(int currentPageNumber){
		addSimpleOptions(RECEIVING_SPACE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WarehouseTokens retainColumnsOfReceivingSpaceList(String[] columns){
		addSimpleOptions(RECEIVING_SPACE_LIST+"RetainColumns",columns);
		return this;
	}
	public WarehouseTokens excludeColumnsOfReceivingSpaceList(String[] columns){
		addSimpleOptions(RECEIVING_SPACE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String SHIPPING_SPACE_LIST = "shippingSpaceList";
	public String getShippingSpaceList(){
		return SHIPPING_SPACE_LIST;
	}



	public WarehouseTokens withShippingSpaceListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(SHIPPING_SPACE_LIST);
		}
		return this;
	}


	public WarehouseTokens withShippingSpaceList(){
		addSimpleOptions(SHIPPING_SPACE_LIST);
		return this;
	}

	public ShippingSpaceTokens withShippingSpaceListTokens(){
		//addSimpleOptions(SHIPPING_SPACE_LIST);
		return ShippingSpaceTokens.start();
	}

	public WarehouseTokens analyzeShippingSpaceList(){
		addSimpleOptions(SHIPPING_SPACE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeShippingSpaceListEnabled(){

		if(checkOptions(this.options(), SHIPPING_SPACE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WarehouseTokens extractMoreFromShippingSpaceList(String idsSeperatedWithComma){
		addSimpleOptions(SHIPPING_SPACE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int shippingSpaceListSortCounter = 0;
	public WarehouseTokens sortShippingSpaceListWith(String field, String descOrAsc){
		addSortMoreOptions(SHIPPING_SPACE_LIST,shippingSpaceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int shippingSpaceListSearchCounter = 0;
	public WarehouseTokens searchShippingSpaceListWith(String field, String verb, String value){

		withShippingSpaceList();
		addSearchMoreOptions(SHIPPING_SPACE_LIST,shippingSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens searchAllTextOfShippingSpaceList(String verb, String value){
		String field = "id|location|contactNumber|totalArea|description";
		addSearchMoreOptions(SHIPPING_SPACE_LIST,shippingSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens rowsPerPageOfShippingSpaceList(int rowsPerPage){
		addSimpleOptions(SHIPPING_SPACE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WarehouseTokens currentPageNumberOfShippingSpaceList(int currentPageNumber){
		addSimpleOptions(SHIPPING_SPACE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WarehouseTokens retainColumnsOfShippingSpaceList(String[] columns){
		addSimpleOptions(SHIPPING_SPACE_LIST+"RetainColumns",columns);
		return this;
	}
	public WarehouseTokens excludeColumnsOfShippingSpaceList(String[] columns){
		addSimpleOptions(SHIPPING_SPACE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String DAMAGE_SPACE_LIST = "damageSpaceList";
	public String getDamageSpaceList(){
		return DAMAGE_SPACE_LIST;
	}



	public WarehouseTokens withDamageSpaceListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(DAMAGE_SPACE_LIST);
		}
		return this;
	}


	public WarehouseTokens withDamageSpaceList(){
		addSimpleOptions(DAMAGE_SPACE_LIST);
		return this;
	}

	public DamageSpaceTokens withDamageSpaceListTokens(){
		//addSimpleOptions(DAMAGE_SPACE_LIST);
		return DamageSpaceTokens.start();
	}

	public WarehouseTokens analyzeDamageSpaceList(){
		addSimpleOptions(DAMAGE_SPACE_LIST+".anaylze");
		return this;
	}
	public boolean analyzeDamageSpaceListEnabled(){

		if(checkOptions(this.options(), DAMAGE_SPACE_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WarehouseTokens extractMoreFromDamageSpaceList(String idsSeperatedWithComma){
		addSimpleOptions(DAMAGE_SPACE_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int damageSpaceListSortCounter = 0;
	public WarehouseTokens sortDamageSpaceListWith(String field, String descOrAsc){
		addSortMoreOptions(DAMAGE_SPACE_LIST,damageSpaceListSortCounter++, field, descOrAsc);
		return this;
	}
	private int damageSpaceListSearchCounter = 0;
	public WarehouseTokens searchDamageSpaceListWith(String field, String verb, String value){

		withDamageSpaceList();
		addSearchMoreOptions(DAMAGE_SPACE_LIST,damageSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens searchAllTextOfDamageSpaceList(String verb, String value){
		String field = "id|location|contactNumber|totalArea";
		addSearchMoreOptions(DAMAGE_SPACE_LIST,damageSpaceListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens rowsPerPageOfDamageSpaceList(int rowsPerPage){
		addSimpleOptions(DAMAGE_SPACE_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WarehouseTokens currentPageNumberOfDamageSpaceList(int currentPageNumber){
		addSimpleOptions(DAMAGE_SPACE_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WarehouseTokens retainColumnsOfDamageSpaceList(String[] columns){
		addSimpleOptions(DAMAGE_SPACE_LIST+"RetainColumns",columns);
		return this;
	}
	public WarehouseTokens excludeColumnsOfDamageSpaceList(String[] columns){
		addSimpleOptions(DAMAGE_SPACE_LIST+"ExcludeColumns",columns);
		return this;
	}


		
	protected static final String WAREHOUSE_ASSET_LIST = "warehouseAssetList";
	public String getWarehouseAssetList(){
		return WAREHOUSE_ASSET_LIST;
	}



	public WarehouseTokens withWarehouseAssetListIfViewGroupInclude(String [] viewGroups){

		if(isViewGroupOneOf("__no_group",viewGroups)){
			addSimpleOptions(WAREHOUSE_ASSET_LIST);
		}
		return this;
	}


	public WarehouseTokens withWarehouseAssetList(){
		addSimpleOptions(WAREHOUSE_ASSET_LIST);
		return this;
	}

	public WarehouseAssetTokens withWarehouseAssetListTokens(){
		//addSimpleOptions(WAREHOUSE_ASSET_LIST);
		return WarehouseAssetTokens.start();
	}

	public WarehouseTokens analyzeWarehouseAssetList(){
		addSimpleOptions(WAREHOUSE_ASSET_LIST+".anaylze");
		return this;
	}
	public boolean analyzeWarehouseAssetListEnabled(){

		if(checkOptions(this.options(), WAREHOUSE_ASSET_LIST+".anaylze")){
			return true; //most of the case, should call here
		}
		//if not true, then query for global setting
		return checkOptions(this.options(), ALL_LISTS_ANALYZE);
	}
	public WarehouseTokens extractMoreFromWarehouseAssetList(String idsSeperatedWithComma){
		addSimpleOptions(WAREHOUSE_ASSET_LIST+".extractIds", idsSeperatedWithComma);
		return this;
	}

	private int warehouseAssetListSortCounter = 0;
	public WarehouseTokens sortWarehouseAssetListWith(String field, String descOrAsc){
		addSortMoreOptions(WAREHOUSE_ASSET_LIST,warehouseAssetListSortCounter++, field, descOrAsc);
		return this;
	}
	private int warehouseAssetListSearchCounter = 0;
	public WarehouseTokens searchWarehouseAssetListWith(String field, String verb, String value){

		withWarehouseAssetList();
		addSearchMoreOptions(WAREHOUSE_ASSET_LIST,warehouseAssetListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens searchAllTextOfWarehouseAssetList(String verb, String value){
		String field = "id|name|position";
		addSearchMoreOptions(WAREHOUSE_ASSET_LIST,warehouseAssetListSearchCounter++, field, verb, value);
		return this;
	}



	public WarehouseTokens rowsPerPageOfWarehouseAssetList(int rowsPerPage){
		addSimpleOptions(WAREHOUSE_ASSET_LIST+"RowsPerPage",rowsPerPage);
		return this;
	}
	public WarehouseTokens currentPageNumberOfWarehouseAssetList(int currentPageNumber){
		addSimpleOptions(WAREHOUSE_ASSET_LIST+"CurrentPage",currentPageNumber);
		return this;
	}
	public WarehouseTokens retainColumnsOfWarehouseAssetList(String[] columns){
		addSimpleOptions(WAREHOUSE_ASSET_LIST+"RetainColumns",columns);
		return this;
	}
	public WarehouseTokens excludeColumnsOfWarehouseAssetList(String[] columns){
		addSimpleOptions(WAREHOUSE_ASSET_LIST+"ExcludeColumns",columns);
		return this;
	}


		

	public  WarehouseTokens searchEntireObjectText(String verb, String value){
	
		searchAllTextOfStorageSpaceList(verb, value);
		searchAllTextOfSmartPalletList(verb, value);
		searchAllTextOfSupplierSpaceList(verb, value);
		searchAllTextOfReceivingSpaceList(verb, value);
		searchAllTextOfShippingSpaceList(verb, value);
		searchAllTextOfDamageSpaceList(verb, value);
		searchAllTextOfWarehouseAssetList(verb, value);
		return this;
	}
}

