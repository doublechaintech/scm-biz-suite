package com.doublechaintech.retailscm;
import java.text.MessageFormat;
import java.util.Date;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class RetailscmCheckerManager extends BaseManagerImpl {
	/*
	
	
	public static final String  ID_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.id";
	protected void checkIdOfRetailStoreCountryCenter(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.name";
	protected void checkNameOfRetailStoreCountryCenter(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,5, 44,NAME_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.service_number";
	protected void checkServiceNumberOfRetailStoreCountryCenter(RetailscmUserContext userContext, String serviceNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(serviceNumber,3, 36,SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.founded";
	protected void checkFoundedOfRetailStoreCountryCenter(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.web_site";
	protected void checkWebSiteOfRetailStoreCountryCenter(RetailscmUserContext userContext, String webSite, List<Message> messageList)
	{
		
	 	checkUrl(webSite,16, 128,WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.address";
	protected void checkAddressOfRetailStoreCountryCenter(RetailscmUserContext userContext, String address, List<Message> messageList)
	{
		
	 	checkStringLengthRange(address,4, 56,ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.operated_by";
	protected void checkOperatedByOfRetailStoreCountryCenter(RetailscmUserContext userContext, String operatedBy, List<Message> messageList)
	{
		
	 	checkStringLengthRange(operatedBy,2, 16,OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.legal_representative";
	protected void checkLegalRepresentativeOfRetailStoreCountryCenter(RetailscmUserContext userContext, String legalRepresentative, List<Message> messageList)
	{
		
	 	checkStringLengthRange(legalRepresentative,1, 12,LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.description";
	protected void checkDescriptionOfRetailStoreCountryCenter(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.version";
	protected void checkVersionOfRetailStoreCountryCenter(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_COUNTRY_CENTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CATALOG ="catalog.id";
	protected void checkIdOfCatalog(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CATALOG ="catalog.name";
	protected void checkNameOfCatalog(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_CATALOG ="catalog.owner";
	protected void checkOwnerIdOfCatalog(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfCatalog(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CATALOG ="catalog.version";
	protected void checkVersionOfCatalog(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	protected void checkIdOfLevelOneCategory(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	protected void checkCatalogIdOfLevelOneCategory(RetailscmUserContext userContext, String catalogId, List<Message> messageList)
	{
		
	 	checkIdOfLevelOneCategory(userContext,catalogId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.name";
	protected void checkNameOfLevelOneCategory(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	protected void checkVersionOfLevelOneCategory(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	protected void checkIdOfLevelTwoCategory(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	protected void checkParentCategoryIdOfLevelTwoCategory(RetailscmUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelTwoCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.name";
	protected void checkNameOfLevelTwoCategory(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	protected void checkVersionOfLevelTwoCategory(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_THREE_CATEGORY ="level_three_category.id";
	protected void checkIdOfLevelThreeCategory(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_THREE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY ="level_three_category.parent_category";
	protected void checkParentCategoryIdOfLevelThreeCategory(RetailscmUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfLevelThreeCategory(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_THREE_CATEGORY ="level_three_category.name";
	protected void checkNameOfLevelThreeCategory(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_LEVEL_THREE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_THREE_CATEGORY ="level_three_category.version";
	protected void checkVersionOfLevelThreeCategory(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_THREE_CATEGORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRODUCT ="product.id";
	protected void checkIdOfProduct(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PRODUCT ="product.name";
	protected void checkNameOfProduct(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	protected void checkParentCategoryIdOfProduct(RetailscmUserContext userContext, String parentCategoryId, List<Message> messageList)
	{
		
	 	checkIdOfProduct(userContext,parentCategoryId, messageList); 		
		
	}	 			
	
	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	protected void checkOriginOfProduct(RetailscmUserContext userContext, String origin, List<Message> messageList)
	{
		
	 	checkStringLengthRange(origin,1, 8,ORIGIN_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_PRODUCT ="product.remark";
	protected void checkRemarkOfProduct(RetailscmUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,6, 88,REMARK_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  BRAND_OF_PRODUCT ="product.brand";
	protected void checkBrandOfProduct(RetailscmUserContext userContext, String brand, List<Message> messageList)
	{
		
	 	checkStringLengthRange(brand,6, 92,BRAND_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PICTURE_OF_PRODUCT ="product.picture";
	protected void checkPictureOfProduct(RetailscmUserContext userContext, String picture, List<Message> messageList)
	{
		
	 	checkImage(picture,0, 512,PICTURE_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRODUCT ="product.version";
	protected void checkVersionOfProduct(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SKU ="sku.id";
	protected void checkIdOfSku(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SKU ="sku.name";
	protected void checkNameOfSku(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  SIZE_OF_SKU ="sku.size";
	protected void checkSizeOfSku(RetailscmUserContext userContext, String size, List<Message> messageList)
	{
		
	 	checkStringLengthRange(size,0, 4,SIZE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_SKU ="sku.product";
	protected void checkProductIdOfSku(RetailscmUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfSku(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  BARCODE_OF_SKU ="sku.barcode";
	protected void checkBarcodeOfSku(RetailscmUserContext userContext, String barcode, List<Message> messageList)
	{
		
	 	checkStringLengthRange(barcode,4, 52,BARCODE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  PACKAGE_TYPE_OF_SKU ="sku.package_type";
	protected void checkPackageTypeOfSku(RetailscmUserContext userContext, String packageType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(packageType,2, 16,PACKAGE_TYPE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  NET_CONTENT_OF_SKU ="sku.net_content";
	protected void checkNetContentOfSku(RetailscmUserContext userContext, String netContent, List<Message> messageList)
	{
		
	 	checkStringLengthRange(netContent,6, 92,NET_CONTENT_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  PRICE_OF_SKU ="sku.price";
	protected void checkPriceOfSku(RetailscmUserContext userContext, BigDecimal price, List<Message> messageList)
	{
		
	 	checkMoneyAmount(price,0.00, 1323.33,PRICE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  PICTURE_OF_SKU ="sku.picture";
	protected void checkPictureOfSku(RetailscmUserContext userContext, String picture, List<Message> messageList)
	{
		
	 	checkImage(picture,0, 512,PICTURE_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SKU ="sku.version";
	protected void checkVersionOfSku(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKU, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.id";
	protected void checkIdOfRetailStoreProvinceCenter(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_PROVINCE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.name";
	protected void checkNameOfRetailStoreProvinceCenter(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,5, 44,NAME_OF_RETAIL_STORE_PROVINCE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.founded";
	protected void checkFoundedOfRetailStoreProvinceCenter(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  COUNTRY_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.country";
	protected void checkCountryIdOfRetailStoreProvinceCenter(RetailscmUserContext userContext, String countryId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreProvinceCenter(userContext,countryId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.version";
	protected void checkVersionOfRetailStoreProvinceCenter(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_PROVINCE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.id";
	protected void checkIdOfProvinceCenterDepartment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROVINCE_CENTER_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.name";
	protected void checkNameOfProvinceCenterDepartment(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_PROVINCE_CENTER_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.founded";
	protected void checkFoundedOfProvinceCenterDepartment(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  PROVINCE_CENTER_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.province_center";
	protected void checkProvinceCenterIdOfProvinceCenterDepartment(RetailscmUserContext userContext, String provinceCenterId, List<Message> messageList)
	{
		
	 	checkIdOfProvinceCenterDepartment(userContext,provinceCenterId, messageList); 		
		
	}	 			
	
	public static final String  MANAGER_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.manager";
	protected void checkManagerOfProvinceCenterDepartment(RetailscmUserContext userContext, String manager, List<Message> messageList)
	{
		
	 	checkStringLengthRange(manager,1, 12,MANAGER_OF_PROVINCE_CENTER_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.version";
	protected void checkVersionOfProvinceCenterDepartment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROVINCE_CENTER_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.id";
	protected void checkIdOfProvinceCenterEmployee(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROVINCE_CENTER_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.name";
	protected void checkNameOfProvinceCenterEmployee(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PROVINCE_CENTER_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.mobile";
	protected void checkMobileOfProvinceCenterEmployee(RetailscmUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_PROVINCE_CENTER_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.email";
	protected void checkEmailOfProvinceCenterEmployee(RetailscmUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkEmail(email,9, 80,EMAIL_OF_PROVINCE_CENTER_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.founded";
	protected void checkFoundedOfProvinceCenterEmployee(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  DEPARTMENT_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.department";
	protected void checkDepartmentIdOfProvinceCenterEmployee(RetailscmUserContext userContext, String departmentId, List<Message> messageList)
	{
		
	 	checkIdOfProvinceCenterEmployee(userContext,departmentId, messageList); 		
		
	}	 			
	
	public static final String  PROVINCE_CENTER_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.province_center";
	protected void checkProvinceCenterIdOfProvinceCenterEmployee(RetailscmUserContext userContext, String provinceCenterId, List<Message> messageList)
	{
		
	 	checkIdOfProvinceCenterEmployee(userContext,provinceCenterId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.version";
	protected void checkVersionOfProvinceCenterEmployee(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROVINCE_CENTER_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.id";
	protected void checkIdOfRetailStoreCityServiceCenter(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.name";
	protected void checkNameOfRetailStoreCityServiceCenter(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,4, 36,NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.founded";
	protected void checkFoundedOfRetailStoreCityServiceCenter(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.belongs_to";
	protected void checkBelongsToIdOfRetailStoreCityServiceCenter(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreCityServiceCenter(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.version";
	protected void checkVersionOfRetailStoreCityServiceCenter(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CITY_PARTNER ="city_partner.id";
	protected void checkIdOfCityPartner(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CITY_PARTNER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CITY_PARTNER ="city_partner.name";
	protected void checkNameOfCityPartner(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_CITY_PARTNER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_CITY_PARTNER ="city_partner.mobile";
	protected void checkMobileOfCityPartner(RetailscmUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_PARTNER, messageList); 		
		
	}	 			
	
	public static final String  CITY_SERVICE_CENTER_OF_CITY_PARTNER ="city_partner.city_service_center";
	protected void checkCityServiceCenterIdOfCityPartner(RetailscmUserContext userContext, String cityServiceCenterId, List<Message> messageList)
	{
		
	 	checkIdOfCityPartner(userContext,cityServiceCenterId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_CITY_PARTNER ="city_partner.description";
	protected void checkDescriptionOfCityPartner(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_CITY_PARTNER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CITY_PARTNER ="city_partner.version";
	protected void checkVersionOfCityPartner(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_PARTNER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_POTENTIAL_CUSTOMER ="potential_customer.id";
	protected void checkIdOfPotentialCustomer(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_POTENTIAL_CUSTOMER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_POTENTIAL_CUSTOMER ="potential_customer.name";
	protected void checkNameOfPotentialCustomer(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER ="potential_customer.mobile";
	protected void checkMobileOfPotentialCustomer(RetailscmUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER, messageList); 		
		
	}	 			
	
	public static final String  CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_service_center";
	protected void checkCityServiceCenterIdOfPotentialCustomer(RetailscmUserContext userContext, String cityServiceCenterId, List<Message> messageList)
	{
		
	 	checkIdOfPotentialCustomer(userContext,cityServiceCenterId, messageList); 		
		
	}	 			
	
	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_partner";
	protected void checkCityPartnerIdOfPotentialCustomer(RetailscmUserContext userContext, String cityPartnerId, List<Message> messageList)
	{
		
	 	checkIdOfPotentialCustomer(userContext,cityPartnerId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER ="potential_customer.description";
	protected void checkDescriptionOfPotentialCustomer(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_POTENTIAL_CUSTOMER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_POTENTIAL_CUSTOMER ="potential_customer.version";
	protected void checkVersionOfPotentialCustomer(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.id";
	protected void checkIdOfPotentialCustomerContactPerson(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.name";
	protected void checkNameOfPotentialCustomerContactPerson(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.mobile";
	protected void checkMobileOfPotentialCustomerContactPerson(RetailscmUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON, messageList); 		
		
	}	 			
	
	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.potential_customer";
	protected void checkPotentialCustomerIdOfPotentialCustomerContactPerson(RetailscmUserContext userContext, String potentialCustomerId, List<Message> messageList)
	{
		
	 	checkIdOfPotentialCustomerContactPerson(userContext,potentialCustomerId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.description";
	protected void checkDescriptionOfPotentialCustomerContactPerson(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,7, 96,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.version";
	protected void checkVersionOfPotentialCustomerContactPerson(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.id";
	protected void checkIdOfPotentialCustomerContact(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.name";
	protected void checkNameOfPotentialCustomerContact(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_POTENTIAL_CUSTOMER_CONTACT, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_date";
	protected void checkContactDateOfPotentialCustomerContact(RetailscmUserContext userContext, Date contactDate, List<Message> messageList)
	{
		
	 	checkDateRange(contactDate,parseDate("1900-01-01"), parseDate("2016-09-09"),CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_method";
	protected void checkContactMethodOfPotentialCustomerContact(RetailscmUserContext userContext, String contactMethod, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactMethod,1, 16,CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT, messageList); 		
		
	}	 			
	
	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.potential_customer";
	protected void checkPotentialCustomerIdOfPotentialCustomerContact(RetailscmUserContext userContext, String potentialCustomerId, List<Message> messageList)
	{
		
	 	checkIdOfPotentialCustomerContact(userContext,potentialCustomerId, messageList); 		
		
	}	 			
	
	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.city_partner";
	protected void checkCityPartnerIdOfPotentialCustomerContact(RetailscmUserContext userContext, String cityPartnerId, List<Message> messageList)
	{
		
	 	checkIdOfPotentialCustomerContact(userContext,cityPartnerId, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_to";
	protected void checkContactToIdOfPotentialCustomerContact(RetailscmUserContext userContext, String contactToId, List<Message> messageList)
	{
		
	 	checkIdOfPotentialCustomerContact(userContext,contactToId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.description";
	protected void checkDescriptionOfPotentialCustomerContact(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 24,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.version";
	protected void checkVersionOfPotentialCustomerContact(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CITY_EVENT ="city_event.id";
	protected void checkIdOfCityEvent(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CITY_EVENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CITY_EVENT ="city_event.name";
	protected void checkNameOfCityEvent(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CITY_EVENT, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_CITY_EVENT ="city_event.mobile";
	protected void checkMobileOfCityEvent(RetailscmUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_EVENT, messageList); 		
		
	}	 			
	
	public static final String  CITY_SERVICE_CENTER_OF_CITY_EVENT ="city_event.city_service_center";
	protected void checkCityServiceCenterIdOfCityEvent(RetailscmUserContext userContext, String cityServiceCenterId, List<Message> messageList)
	{
		
	 	checkIdOfCityEvent(userContext,cityServiceCenterId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_CITY_EVENT ="city_event.description";
	protected void checkDescriptionOfCityEvent(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_CITY_EVENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CITY_EVENT ="city_event.version";
	protected void checkVersionOfCityEvent(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_EVENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EVENT_ATTENDANCE ="event_attendance.id";
	protected void checkIdOfEventAttendance(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EVENT_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_EVENT_ATTENDANCE ="event_attendance.name";
	protected void checkNameOfEventAttendance(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 36,NAME_OF_EVENT_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE ="event_attendance.potential_customer";
	protected void checkPotentialCustomerIdOfEventAttendance(RetailscmUserContext userContext, String potentialCustomerId, List<Message> messageList)
	{
		
	 	checkIdOfEventAttendance(userContext,potentialCustomerId, messageList); 		
		
	}	 			
	
	public static final String  CITY_EVENT_OF_EVENT_ATTENDANCE ="event_attendance.city_event";
	protected void checkCityEventIdOfEventAttendance(RetailscmUserContext userContext, String cityEventId, List<Message> messageList)
	{
		
	 	checkIdOfEventAttendance(userContext,cityEventId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_EVENT_ATTENDANCE ="event_attendance.description";
	protected void checkDescriptionOfEventAttendance(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,3, 36,DESCRIPTION_OF_EVENT_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EVENT_ATTENDANCE ="event_attendance.version";
	protected void checkVersionOfEventAttendance(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EVENT_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE ="retail_store.id";
	protected void checkIdOfRetailStore(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE ="retail_store.name";
	protected void checkNameOfRetailStore(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 24,NAME_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  TELEPHONE_OF_RETAIL_STORE ="retail_store.telephone";
	protected void checkTelephoneOfRetailStore(RetailscmUserContext userContext, String telephone, List<Message> messageList)
	{
		
	 	checkStringLengthRange(telephone,3, 44,TELEPHONE_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_RETAIL_STORE ="retail_store.owner";
	protected void checkOwnerOfRetailStore(RetailscmUserContext userContext, String owner, List<Message> messageList)
	{
		
	 	checkStringLengthRange(owner,1, 8,OWNER_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  RETAIL_STORE_COUNTRY_CENTER_OF_RETAIL_STORE ="retail_store.retail_store_country_center";
	protected void checkRetailStoreCountryCenterIdOfRetailStore(RetailscmUserContext userContext, String retailStoreCountryCenterId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStore(userContext,retailStoreCountryCenterId, messageList); 		
		
	}	 			
	
	public static final String  CITY_SERVICE_CENTER_OF_RETAIL_STORE ="retail_store.city_service_center";
	protected void checkCityServiceCenterIdOfRetailStore(RetailscmUserContext userContext, String cityServiceCenterId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStore(userContext,cityServiceCenterId, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_RETAIL_STORE ="retail_store.founded";
	protected void checkFoundedOfRetailStore(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_RETAIL_STORE ="retail_store.latitude";
	protected void checkLatitudeOfRetailStore(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_RETAIL_STORE ="retail_store.longitude";
	protected void checkLongitudeOfRetailStore(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_RETAIL_STORE ="retail_store.description";
	protected void checkDescriptionOfRetailStore(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,6, 84,DESCRIPTION_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE ="retail_store.version";
	protected void checkVersionOfRetailStore(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_CREATION ="retail_store_creation.id";
	protected void checkIdOfRetailStoreCreation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_CREATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_RETAIL_STORE_CREATION ="retail_store_creation.comment";
	protected void checkCommentOfRetailStoreCreation(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,2, 20,COMMENT_OF_RETAIL_STORE_CREATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_CREATION ="retail_store_creation.version";
	protected void checkVersionOfRetailStoreCreation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CREATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.id";
	protected void checkIdOfRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_INVESTMENT_INVITATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.comment";
	protected void checkCommentOfRetailStoreInvestmentInvitation(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,2, 24,COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.version";
	protected void checkVersionOfRetailStoreInvestmentInvitation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.id";
	protected void checkIdOfRetailStoreFranchising(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_FRANCHISING, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.comment";
	protected void checkCommentOfRetailStoreFranchising(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,2, 16,COMMENT_OF_RETAIL_STORE_FRANCHISING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.version";
	protected void checkVersionOfRetailStoreFranchising(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_FRANCHISING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.id";
	protected void checkIdOfRetailStoreDecoration(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_DECORATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.comment";
	protected void checkCommentOfRetailStoreDecoration(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_DECORATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.version";
	protected void checkVersionOfRetailStoreDecoration(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_DECORATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_OPENING ="retail_store_opening.id";
	protected void checkIdOfRetailStoreOpening(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_OPENING, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_RETAIL_STORE_OPENING ="retail_store_opening.comment";
	protected void checkCommentOfRetailStoreOpening(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_OPENING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_OPENING ="retail_store_opening.version";
	protected void checkVersionOfRetailStoreOpening(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_OPENING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_CLOSING ="retail_store_closing.id";
	protected void checkIdOfRetailStoreClosing(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_CLOSING, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_RETAIL_STORE_CLOSING ="retail_store_closing.comment";
	protected void checkCommentOfRetailStoreClosing(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_CLOSING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_CLOSING ="retail_store_closing.version";
	protected void checkVersionOfRetailStoreClosing(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CLOSING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_MEMBER ="retail_store_member.id";
	protected void checkIdOfRetailStoreMember(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_MEMBER ="retail_store_member.name";
	protected void checkNameOfRetailStoreMember(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER ="retail_store_member.mobile_phone";
	protected void checkMobilePhoneOfRetailStoreMember(RetailscmUserContext userContext, String mobilePhone, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobilePhone,5, 44,MOBILE_PHONE_OF_RETAIL_STORE_MEMBER, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_RETAIL_STORE_MEMBER ="retail_store_member.owner";
	protected void checkOwnerIdOfRetailStoreMember(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreMember(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER ="retail_store_member.version";
	protected void checkVersionOfRetailStoreMember(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER ="consumer_order.id";
	protected void checkIdOfConsumerOrder(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_CONSUMER_ORDER ="consumer_order.title";
	protected void checkTitleOfConsumerOrder(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_CONSUMER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  CONSUMER_OF_CONSUMER_ORDER ="consumer_order.consumer";
	protected void checkConsumerIdOfConsumerOrder(RetailscmUserContext userContext, String consumerId, List<Message> messageList)
	{
		
	 	checkIdOfConsumerOrder(userContext,consumerId, messageList); 		
		
	}	 			
	
	public static final String  STORE_OF_CONSUMER_ORDER ="consumer_order.store";
	protected void checkStoreIdOfConsumerOrder(RetailscmUserContext userContext, String storeId, List<Message> messageList)
	{
		
	 	checkIdOfConsumerOrder(userContext,storeId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER ="consumer_order.version";
	protected void checkVersionOfConsumerOrder(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.id";
	protected void checkIdOfConsumerOrderConfirmation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.who";
	protected void checkWhoOfConsumerOrderConfirmation(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.confirm_time";
	protected void checkConfirmTimeOfConsumerOrderConfirmation(RetailscmUserContext userContext, Date confirmTime, List<Message> messageList)
	{
		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.version";
	protected void checkVersionOfConsumerOrderConfirmation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.id";
	protected void checkIdOfConsumerOrderApproval(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.who";
	protected void checkWhoOfConsumerOrderApproval(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.approve_time";
	protected void checkApproveTimeOfConsumerOrderApproval(RetailscmUserContext userContext, Date approveTime, List<Message> messageList)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.version";
	protected void checkVersionOfConsumerOrderApproval(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.id";
	protected void checkIdOfConsumerOrderProcessing(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.who";
	protected void checkWhoOfConsumerOrderProcessing(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.process_time";
	protected void checkProcessTimeOfConsumerOrderProcessing(RetailscmUserContext userContext, Date processTime, List<Message> messageList)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.version";
	protected void checkVersionOfConsumerOrderProcessing(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.id";
	protected void checkIdOfConsumerOrderShipment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.who";
	protected void checkWhoOfConsumerOrderShipment(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.ship_time";
	protected void checkShipTimeOfConsumerOrderShipment(RetailscmUserContext userContext, Date shipTime, List<Message> messageList)
	{
		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.version";
	protected void checkVersionOfConsumerOrderShipment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.id";
	protected void checkIdOfConsumerOrderDelivery(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.who";
	protected void checkWhoOfConsumerOrderDelivery(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.delivery_time";
	protected void checkDeliveryTimeOfConsumerOrderDelivery(RetailscmUserContext userContext, Date deliveryTime, List<Message> messageList)
	{
		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.version";
	protected void checkVersionOfConsumerOrderDelivery(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.id";
	protected void checkIdOfConsumerOrderLineItem(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.biz_order";
	protected void checkBizOrderIdOfConsumerOrderLineItem(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfConsumerOrderLineItem(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_id";
	protected void checkSkuIdOfConsumerOrderLineItem(RetailscmUserContext userContext, String skuId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_name";
	protected void checkSkuNameOfConsumerOrderLineItem(RetailscmUserContext userContext, String skuName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(skuName,2, 16,SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  PRICE_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.price";
	protected void checkPriceOfConsumerOrderLineItem(RetailscmUserContext userContext, BigDecimal price, List<Message> messageList)
	{
		
	 	checkMoneyAmount(price,0.00, 5.97,PRICE_OF_CONSUMER_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.quantity";
	protected void checkQuantityOfConsumerOrderLineItem(RetailscmUserContext userContext, BigDecimal quantity, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(quantity,0, 1000.00,QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.amount";
	protected void checkAmountOfConsumerOrderLineItem(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 9999.99,AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.version";
	protected void checkVersionOfConsumerOrderLineItem(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.id";
	protected void checkIdOfConsumerOrderShippingGroup(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.name";
	protected void checkNameOfConsumerOrderShippingGroup(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.biz_order";
	protected void checkBizOrderIdOfConsumerOrderShippingGroup(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfConsumerOrderShippingGroup(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.amount";
	protected void checkAmountOfConsumerOrderShippingGroup(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 599.99,AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.version";
	protected void checkVersionOfConsumerOrderShippingGroup(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.id";
	protected void checkIdOfConsumerOrderPaymentGroup(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.name";
	protected void checkNameOfConsumerOrderPaymentGroup(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 16,NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.biz_order";
	protected void checkBizOrderIdOfConsumerOrderPaymentGroup(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfConsumerOrderPaymentGroup(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.card_number";
	protected void checkCardNumberOfConsumerOrderPaymentGroup(RetailscmUserContext userContext, String cardNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.version";
	protected void checkVersionOfConsumerOrderPaymentGroup(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.id";
	protected void checkIdOfConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.name";
	protected void checkNameOfConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.biz_order";
	protected void checkBizOrderIdOfConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfConsumerOrderPriceAdjustment(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.amount";
	protected void checkAmountOfConsumerOrderPriceAdjustment(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 599.99,AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.provider";
	protected void checkProviderOfConsumerOrderPriceAdjustment(RetailscmUserContext userContext, String provider, List<Message> messageList)
	{
		
	 	checkStringLengthRange(provider,1, 16,PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.version";
	protected void checkVersionOfConsumerOrderPriceAdjustment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.id";
	protected void checkIdOfRetailStoreMemberCoupon(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_COUPON, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.name";
	protected void checkNameOfRetailStoreMemberCoupon(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER_COUPON, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.owner";
	protected void checkOwnerIdOfRetailStoreMemberCoupon(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreMemberCoupon(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.number";
	protected void checkNumberOfRetailStoreMemberCoupon(RetailscmUserContext userContext, String number, List<Message> messageList)
	{
		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_COUPON, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.version";
	protected void checkVersionOfRetailStoreMemberCoupon(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_COUPON, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MEMBER_WISHLIST ="member_wishlist.id";
	protected void checkIdOfMemberWishlist(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_WISHLIST, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MEMBER_WISHLIST ="member_wishlist.name";
	protected void checkNameOfMemberWishlist(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 24,NAME_OF_MEMBER_WISHLIST, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_MEMBER_WISHLIST ="member_wishlist.owner";
	protected void checkOwnerIdOfMemberWishlist(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfMemberWishlist(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MEMBER_WISHLIST ="member_wishlist.version";
	protected void checkVersionOfMemberWishlist(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_WISHLIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MEMBER_REWARD_POINT ="member_reward_point.id";
	protected void checkIdOfMemberRewardPoint(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_REWARD_POINT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MEMBER_REWARD_POINT ="member_reward_point.name";
	protected void checkNameOfMemberRewardPoint(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_MEMBER_REWARD_POINT, messageList); 		
		
	}	 			
	
	public static final String  POINT_OF_MEMBER_REWARD_POINT ="member_reward_point.point";
	protected void checkPointOfMemberRewardPoint(RetailscmUserContext userContext, int point, List<Message> messageList)
	{
		
	 	checkIntegerRange(point,0, 20,POINT_OF_MEMBER_REWARD_POINT, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_MEMBER_REWARD_POINT ="member_reward_point.owner";
	protected void checkOwnerIdOfMemberRewardPoint(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfMemberRewardPoint(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MEMBER_REWARD_POINT ="member_reward_point.version";
	protected void checkVersionOfMemberRewardPoint(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_REWARD_POINT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.id";
	protected void checkIdOfMemberRewardPointRedemption(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_REWARD_POINT_REDEMPTION, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.name";
	protected void checkNameOfMemberRewardPointRedemption(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_MEMBER_REWARD_POINT_REDEMPTION, messageList); 		
		
	}	 			
	
	public static final String  POINT_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.point";
	protected void checkPointOfMemberRewardPointRedemption(RetailscmUserContext userContext, int point, List<Message> messageList)
	{
		
	 	checkIntegerRange(point,0, 20,POINT_OF_MEMBER_REWARD_POINT_REDEMPTION, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.owner";
	protected void checkOwnerIdOfMemberRewardPointRedemption(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfMemberRewardPointRedemption(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.version";
	protected void checkVersionOfMemberRewardPointRedemption(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.id";
	protected void checkIdOfMemberWishlistProduct(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_WISHLIST_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.name";
	protected void checkNameOfMemberWishlistProduct(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_MEMBER_WISHLIST_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.owner";
	protected void checkOwnerIdOfMemberWishlistProduct(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfMemberWishlistProduct(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.version";
	protected void checkVersionOfMemberWishlistProduct(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_WISHLIST_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.id";
	protected void checkIdOfRetailStoreMemberAddress(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.name";
	protected void checkNameOfRetailStoreMemberAddress(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 24,NAME_OF_RETAIL_STORE_MEMBER_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.owner";
	protected void checkOwnerIdOfRetailStoreMemberAddress(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreMemberAddress(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.mobile_phone";
	protected void checkMobilePhoneOfRetailStoreMemberAddress(RetailscmUserContext userContext, String mobilePhone, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobilePhone,5, 44,MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.address";
	protected void checkAddressOfRetailStoreMemberAddress(RetailscmUserContext userContext, String address, List<Message> messageList)
	{
		
	 	checkStringLengthRange(address,4, 56,ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.version";
	protected void checkVersionOfRetailStoreMemberAddress(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.id";
	protected void checkIdOfRetailStoreMemberGiftCard(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.name";
	protected void checkNameOfRetailStoreMemberGiftCard(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.owner";
	protected void checkOwnerIdOfRetailStoreMemberGiftCard(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreMemberGiftCard(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.number";
	protected void checkNumberOfRetailStoreMemberGiftCard(RetailscmUserContext userContext, String number, List<Message> messageList)
	{
		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD, messageList); 		
		
	}	 			
	
	public static final String  REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.remain";
	protected void checkRemainOfRetailStoreMemberGiftCard(RetailscmUserContext userContext, BigDecimal remain, List<Message> messageList)
	{
		
	 	checkMoneyAmount(remain,0.00, 213.99,REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.version";
	protected void checkVersionOfRetailStoreMemberGiftCard(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.id";
	protected void checkIdOfRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD, messageList); 		
		
	}	 			
	
	public static final String  OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.occure_time";
	protected void checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, Date occureTime, List<Message> messageList)
	{
		
	 	checkDatePast(occureTime,parseDate("1900-01-01"), new Date(),OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.owner";
	protected void checkOwnerIdOfRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.biz_order";
	protected void checkBizOrderIdOfRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreMemberGiftCardConsumeRecord(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.number";
	protected void checkNumberOfRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, String number, List<Message> messageList)
	{
		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.amount";
	protected void checkAmountOfRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 20.99,AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.version";
	protected void checkVersionOfRetailStoreMemberGiftCardConsumeRecord(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GOODS_SUPPLIER ="goods_supplier.id";
	protected void checkIdOfGoodsSupplier(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_SUPPLIER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_GOODS_SUPPLIER ="goods_supplier.name";
	protected void checkNameOfGoodsSupplier(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_GOODS_SUPPLIER, messageList); 		
		
	}	 			
	
	public static final String  SUPPLY_PRODUCT_OF_GOODS_SUPPLIER ="goods_supplier.supply_product";
	protected void checkSupplyProductOfGoodsSupplier(RetailscmUserContext userContext, String supplyProduct, List<Message> messageList)
	{
		
	 	checkStringLengthRange(supplyProduct,1, 16,SUPPLY_PRODUCT_OF_GOODS_SUPPLIER, messageList); 		
		
	}	 			
	
	public static final String  BELONG_TO_OF_GOODS_SUPPLIER ="goods_supplier.belong_to";
	protected void checkBelongToIdOfGoodsSupplier(RetailscmUserContext userContext, String belongToId, List<Message> messageList)
	{
		
	 	checkIdOfGoodsSupplier(userContext,belongToId, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_GOODS_SUPPLIER ="goods_supplier.contact_number";
	protected void checkContactNumberOfGoodsSupplier(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(contactNumber,5, 44,CONTACT_NUMBER_OF_GOODS_SUPPLIER, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GOODS_SUPPLIER ="goods_supplier.description";
	protected void checkDescriptionOfGoodsSupplier(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_GOODS_SUPPLIER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GOODS_SUPPLIER ="goods_supplier.version";
	protected void checkVersionOfGoodsSupplier(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SUPPLIER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLIER_PRODUCT ="supplier_product.id";
	protected void checkIdOfSupplierProduct(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLIER_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_NAME_OF_SUPPLIER_PRODUCT ="supplier_product.product_name";
	protected void checkProductNameOfSupplierProduct(RetailscmUserContext userContext, String productName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(productName,2, 16,PRODUCT_NAME_OF_SUPPLIER_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT ="supplier_product.product_description";
	protected void checkProductDescriptionOfSupplierProduct(RetailscmUserContext userContext, String productDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(productDescription,4, 52,PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_UNIT_OF_SUPPLIER_PRODUCT ="supplier_product.product_unit";
	protected void checkProductUnitOfSupplierProduct(RetailscmUserContext userContext, String productUnit, List<Message> messageList)
	{
		
	 	checkStringLengthRange(productUnit,0, 8,PRODUCT_UNIT_OF_SUPPLIER_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  SUPPLIER_OF_SUPPLIER_PRODUCT ="supplier_product.supplier";
	protected void checkSupplierIdOfSupplierProduct(RetailscmUserContext userContext, String supplierId, List<Message> messageList)
	{
		
	 	checkIdOfSupplierProduct(userContext,supplierId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLIER_PRODUCT ="supplier_product.version";
	protected void checkVersionOfSupplierProduct(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLIER_PRODUCT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.id";
	protected void checkIdOfProductSupplyDuration(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT_SUPPLY_DURATION, messageList); 		
		
	}	 			
	
	public static final String  QUANTITY_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.quantity";
	protected void checkQuantityOfProductSupplyDuration(RetailscmUserContext userContext, int quantity, List<Message> messageList)
	{
		
	 	checkIntegerRange(quantity,0, 500,QUANTITY_OF_PRODUCT_SUPPLY_DURATION, messageList); 		
		
	}	 			
	
	public static final String  DURATION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.duration";
	protected void checkDurationOfProductSupplyDuration(RetailscmUserContext userContext, String duration, List<Message> messageList)
	{
		
	 	checkStringLengthRange(duration,1, 8,DURATION_OF_PRODUCT_SUPPLY_DURATION, messageList); 		
		
	}	 			
	
	public static final String  PRICE_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.price";
	protected void checkPriceOfProductSupplyDuration(RetailscmUserContext userContext, BigDecimal price, List<Message> messageList)
	{
		
	 	checkMoneyAmount(price,0.00, 9999.99,PRICE_OF_PRODUCT_SUPPLY_DURATION, messageList); 		
		
	}	 			
	
	public static final String  PRODUCT_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.product";
	protected void checkProductIdOfProductSupplyDuration(RetailscmUserContext userContext, String productId, List<Message> messageList)
	{
		
	 	checkIdOfProductSupplyDuration(userContext,productId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.version";
	protected void checkVersionOfProductSupplyDuration(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT_SUPPLY_DURATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER ="supply_order.id";
	protected void checkIdOfSupplyOrder(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER, messageList); 		
		
	}	 			
	
	public static final String  BUYER_OF_SUPPLY_ORDER ="supply_order.buyer";
	protected void checkBuyerIdOfSupplyOrder(RetailscmUserContext userContext, String buyerId, List<Message> messageList)
	{
		
	 	checkIdOfSupplyOrder(userContext,buyerId, messageList); 		
		
	}	 			
	
	public static final String  SELLER_OF_SUPPLY_ORDER ="supply_order.seller";
	protected void checkSellerIdOfSupplyOrder(RetailscmUserContext userContext, String sellerId, List<Message> messageList)
	{
		
	 	checkIdOfSupplyOrder(userContext,sellerId, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_SUPPLY_ORDER ="supply_order.title";
	protected void checkTitleOfSupplyOrder(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,3, 40,TITLE_OF_SUPPLY_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AMOUNT_OF_SUPPLY_ORDER ="supply_order.total_amount";
	protected void checkTotalAmountOfSupplyOrder(RetailscmUserContext userContext, BigDecimal totalAmount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 3000000000.88,TOTAL_AMOUNT_OF_SUPPLY_ORDER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER ="supply_order.version";
	protected void checkVersionOfSupplyOrder(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.id";
	protected void checkIdOfSupplyOrderConfirmation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.who";
	protected void checkWhoOfSupplyOrderConfirmation(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.confirm_time";
	protected void checkConfirmTimeOfSupplyOrderConfirmation(RetailscmUserContext userContext, Date confirmTime, List<Message> messageList)
	{
		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.version";
	protected void checkVersionOfSupplyOrderConfirmation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.id";
	protected void checkIdOfSupplyOrderApproval(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.who";
	protected void checkWhoOfSupplyOrderApproval(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.approve_time";
	protected void checkApproveTimeOfSupplyOrderApproval(RetailscmUserContext userContext, Date approveTime, List<Message> messageList)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.version";
	protected void checkVersionOfSupplyOrderApproval(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.id";
	protected void checkIdOfSupplyOrderProcessing(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.who";
	protected void checkWhoOfSupplyOrderProcessing(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.process_time";
	protected void checkProcessTimeOfSupplyOrderProcessing(RetailscmUserContext userContext, Date processTime, List<Message> messageList)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.version";
	protected void checkVersionOfSupplyOrderProcessing(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.id";
	protected void checkIdOfSupplyOrderPicking(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.who";
	protected void checkWhoOfSupplyOrderPicking(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.process_time";
	protected void checkProcessTimeOfSupplyOrderPicking(RetailscmUserContext userContext, Date processTime, List<Message> messageList)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_SUPPLY_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.version";
	protected void checkVersionOfSupplyOrderPicking(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.id";
	protected void checkIdOfSupplyOrderShipment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.who";
	protected void checkWhoOfSupplyOrderShipment(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.ship_time";
	protected void checkShipTimeOfSupplyOrderShipment(RetailscmUserContext userContext, Date shipTime, List<Message> messageList)
	{
		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.version";
	protected void checkVersionOfSupplyOrderShipment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.id";
	protected void checkIdOfSupplyOrderDelivery(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.who";
	protected void checkWhoOfSupplyOrderDelivery(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.delivery_time";
	protected void checkDeliveryTimeOfSupplyOrderDelivery(RetailscmUserContext userContext, Date deliveryTime, List<Message> messageList)
	{
		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.version";
	protected void checkVersionOfSupplyOrderDelivery(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.id";
	protected void checkIdOfSupplyOrderLineItem(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.biz_order";
	protected void checkBizOrderIdOfSupplyOrderLineItem(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfSupplyOrderLineItem(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_id";
	protected void checkSkuIdOfSupplyOrderLineItem(RetailscmUserContext userContext, String skuId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_name";
	protected void checkSkuNameOfSupplyOrderLineItem(RetailscmUserContext userContext, String skuName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(skuName,2, 16,SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.amount";
	protected void checkAmountOfSupplyOrderLineItem(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 5.97,AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.quantity";
	protected void checkQuantityOfSupplyOrderLineItem(RetailscmUserContext userContext, int quantity, List<Message> messageList)
	{
		
	 	checkIntegerRange(quantity,0, 10000,QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.unit_of_measurement";
	protected void checkUnitOfMeasurementOfSupplyOrderLineItem(RetailscmUserContext userContext, String unitOfMeasurement, List<Message> messageList)
	{
		
	 	checkStringLengthRange(unitOfMeasurement,0, 8,UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.version";
	protected void checkVersionOfSupplyOrderLineItem(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.id";
	protected void checkIdOfSupplyOrderShippingGroup(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.name";
	protected void checkNameOfSupplyOrderShippingGroup(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.biz_order";
	protected void checkBizOrderIdOfSupplyOrderShippingGroup(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfSupplyOrderShippingGroup(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.amount";
	protected void checkAmountOfSupplyOrderShippingGroup(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 5.99,AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.version";
	protected void checkVersionOfSupplyOrderShippingGroup(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.id";
	protected void checkIdOfSupplyOrderPaymentGroup(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.name";
	protected void checkNameOfSupplyOrderPaymentGroup(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.biz_order";
	protected void checkBizOrderIdOfSupplyOrderPaymentGroup(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfSupplyOrderPaymentGroup(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.card_number";
	protected void checkCardNumberOfSupplyOrderPaymentGroup(RetailscmUserContext userContext, String cardNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.version";
	protected void checkVersionOfSupplyOrderPaymentGroup(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER ="retail_store_order.id";
	protected void checkIdOfRetailStoreOrder(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER, messageList); 		
		
	}	 			
	
	public static final String  BUYER_OF_RETAIL_STORE_ORDER ="retail_store_order.buyer";
	protected void checkBuyerIdOfRetailStoreOrder(RetailscmUserContext userContext, String buyerId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreOrder(userContext,buyerId, messageList); 		
		
	}	 			
	
	public static final String  SELLER_OF_RETAIL_STORE_ORDER ="retail_store_order.seller";
	protected void checkSellerIdOfRetailStoreOrder(RetailscmUserContext userContext, String sellerId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreOrder(userContext,sellerId, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_RETAIL_STORE_ORDER ="retail_store_order.title";
	protected void checkTitleOfRetailStoreOrder(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,4, 56,TITLE_OF_RETAIL_STORE_ORDER, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER ="retail_store_order.total_amount";
	protected void checkTotalAmountOfRetailStoreOrder(RetailscmUserContext userContext, BigDecimal totalAmount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 3000000000.88,TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER ="retail_store_order.version";
	protected void checkVersionOfRetailStoreOrder(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.id";
	protected void checkIdOfRetailStoreOrderConfirmation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.who";
	protected void checkWhoOfRetailStoreOrderConfirmation(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.confirm_time";
	protected void checkConfirmTimeOfRetailStoreOrderConfirmation(RetailscmUserContext userContext, Date confirmTime, List<Message> messageList)
	{
		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.version";
	protected void checkVersionOfRetailStoreOrderConfirmation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.id";
	protected void checkIdOfRetailStoreOrderApproval(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.who";
	protected void checkWhoOfRetailStoreOrderApproval(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.approve_time";
	protected void checkApproveTimeOfRetailStoreOrderApproval(RetailscmUserContext userContext, Date approveTime, List<Message> messageList)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.version";
	protected void checkVersionOfRetailStoreOrderApproval(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.id";
	protected void checkIdOfRetailStoreOrderProcessing(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.who";
	protected void checkWhoOfRetailStoreOrderProcessing(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.process_time";
	protected void checkProcessTimeOfRetailStoreOrderProcessing(RetailscmUserContext userContext, Date processTime, List<Message> messageList)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.version";
	protected void checkVersionOfRetailStoreOrderProcessing(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PROCESSING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.id";
	protected void checkIdOfRetailStoreOrderPicking(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.who";
	protected void checkWhoOfRetailStoreOrderPicking(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.process_time";
	protected void checkProcessTimeOfRetailStoreOrderPicking(RetailscmUserContext userContext, Date processTime, List<Message> messageList)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.version";
	protected void checkVersionOfRetailStoreOrderPicking(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PICKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.id";
	protected void checkIdOfRetailStoreOrderShipment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.who";
	protected void checkWhoOfRetailStoreOrderShipment(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.ship_time";
	protected void checkShipTimeOfRetailStoreOrderShipment(RetailscmUserContext userContext, Date shipTime, List<Message> messageList)
	{
		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.version";
	protected void checkVersionOfRetailStoreOrderShipment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.id";
	protected void checkIdOfRetailStoreOrderDelivery(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.who";
	protected void checkWhoOfRetailStoreOrderDelivery(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.delivery_time";
	protected void checkDeliveryTimeOfRetailStoreOrderDelivery(RetailscmUserContext userContext, Date deliveryTime, List<Message> messageList)
	{
		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.version";
	protected void checkVersionOfRetailStoreOrderDelivery(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_DELIVERY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.id";
	protected void checkIdOfRetailStoreOrderLineItem(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.biz_order";
	protected void checkBizOrderIdOfRetailStoreOrderLineItem(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreOrderLineItem(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_id";
	protected void checkSkuIdOfRetailStoreOrderLineItem(RetailscmUserContext userContext, String skuId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_name";
	protected void checkSkuNameOfRetailStoreOrderLineItem(RetailscmUserContext userContext, String skuName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(skuName,2, 16,SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.amount";
	protected void checkAmountOfRetailStoreOrderLineItem(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 3.97,AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.quantity";
	protected void checkQuantityOfRetailStoreOrderLineItem(RetailscmUserContext userContext, int quantity, List<Message> messageList)
	{
		
	 	checkIntegerRange(quantity,0, 10000,QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.unit_of_measurement";
	protected void checkUnitOfMeasurementOfRetailStoreOrderLineItem(RetailscmUserContext userContext, String unitOfMeasurement, List<Message> messageList)
	{
		
	 	checkStringLengthRange(unitOfMeasurement,0, 8,UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.version";
	protected void checkVersionOfRetailStoreOrderLineItem(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.id";
	protected void checkIdOfRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.name";
	protected void checkNameOfRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.biz_order";
	protected void checkBizOrderIdOfRetailStoreOrderShippingGroup(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreOrderShippingGroup(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.amount";
	protected void checkAmountOfRetailStoreOrderShippingGroup(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 5.99,AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.version";
	protected void checkVersionOfRetailStoreOrderShippingGroup(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.id";
	protected void checkIdOfRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.name";
	protected void checkNameOfRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.biz_order";
	protected void checkBizOrderIdOfRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfRetailStoreOrderPaymentGroup(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.card_number";
	protected void checkCardNumberOfRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, String cardNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.version";
	protected void checkVersionOfRetailStoreOrderPaymentGroup(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_WAREHOUSE ="warehouse.id";
	protected void checkIdOfWarehouse(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_WAREHOUSE, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_WAREHOUSE ="warehouse.location";
	protected void checkLocationOfWarehouse(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,3, 44,LOCATION_OF_WAREHOUSE, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_WAREHOUSE ="warehouse.contact_number";
	protected void checkContactNumberOfWarehouse(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_WAREHOUSE, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AREA_OF_WAREHOUSE ="warehouse.total_area";
	protected void checkTotalAreaOfWarehouse(RetailscmUserContext userContext, String totalArea, List<Message> messageList)
	{
		
	 	checkStringLengthRange(totalArea,3, 36,TOTAL_AREA_OF_WAREHOUSE, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_WAREHOUSE ="warehouse.owner";
	protected void checkOwnerIdOfWarehouse(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfWarehouse(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_WAREHOUSE ="warehouse.latitude";
	protected void checkLatitudeOfWarehouse(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_WAREHOUSE, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_WAREHOUSE ="warehouse.longitude";
	protected void checkLongitudeOfWarehouse(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_WAREHOUSE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_WAREHOUSE ="warehouse.version";
	protected void checkVersionOfWarehouse(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WAREHOUSE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_STORAGE_SPACE ="storage_space.id";
	protected void checkIdOfStorageSpace(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_STORAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_STORAGE_SPACE ="storage_space.location";
	protected void checkLocationOfStorageSpace(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 56,LOCATION_OF_STORAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_STORAGE_SPACE ="storage_space.contact_number";
	protected void checkContactNumberOfStorageSpace(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_STORAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AREA_OF_STORAGE_SPACE ="storage_space.total_area";
	protected void checkTotalAreaOfStorageSpace(RetailscmUserContext userContext, String totalArea, List<Message> messageList)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_STORAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  WAREHOUSE_OF_STORAGE_SPACE ="storage_space.warehouse";
	protected void checkWarehouseIdOfStorageSpace(RetailscmUserContext userContext, String warehouseId, List<Message> messageList)
	{
		
	 	checkIdOfStorageSpace(userContext,warehouseId, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_STORAGE_SPACE ="storage_space.latitude";
	protected void checkLatitudeOfStorageSpace(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_STORAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_STORAGE_SPACE ="storage_space.longitude";
	protected void checkLongitudeOfStorageSpace(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_STORAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_STORAGE_SPACE ="storage_space.version";
	protected void checkVersionOfStorageSpace(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_STORAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SMART_PALLET ="smart_pallet.id";
	protected void checkIdOfSmartPallet(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SMART_PALLET, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_SMART_PALLET ="smart_pallet.location";
	protected void checkLocationOfSmartPallet(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,7, 104,LOCATION_OF_SMART_PALLET, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_SMART_PALLET ="smart_pallet.contact_number";
	protected void checkContactNumberOfSmartPallet(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SMART_PALLET, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AREA_OF_SMART_PALLET ="smart_pallet.total_area";
	protected void checkTotalAreaOfSmartPallet(RetailscmUserContext userContext, String totalArea, List<Message> messageList)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SMART_PALLET, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_SMART_PALLET ="smart_pallet.latitude";
	protected void checkLatitudeOfSmartPallet(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SMART_PALLET, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_SMART_PALLET ="smart_pallet.longitude";
	protected void checkLongitudeOfSmartPallet(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SMART_PALLET, messageList); 		
		
	}	 			
	
	public static final String  WAREHOUSE_OF_SMART_PALLET ="smart_pallet.warehouse";
	protected void checkWarehouseIdOfSmartPallet(RetailscmUserContext userContext, String warehouseId, List<Message> messageList)
	{
		
	 	checkIdOfSmartPallet(userContext,warehouseId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SMART_PALLET ="smart_pallet.version";
	protected void checkVersionOfSmartPallet(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SMART_PALLET, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GOODS_SHELF ="goods_shelf.id";
	protected void checkIdOfGoodsShelf(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_SHELF, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_GOODS_SHELF ="goods_shelf.location";
	protected void checkLocationOfGoodsShelf(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,5, 64,LOCATION_OF_GOODS_SHELF, messageList); 		
		
	}	 			
	
	public static final String  STORAGE_SPACE_OF_GOODS_SHELF ="goods_shelf.storage_space";
	protected void checkStorageSpaceIdOfGoodsShelf(RetailscmUserContext userContext, String storageSpaceId, List<Message> messageList)
	{
		
	 	checkIdOfGoodsShelf(userContext,storageSpaceId, messageList); 		
		
	}	 			
	
	public static final String  SUPPLIER_SPACE_OF_GOODS_SHELF ="goods_shelf.supplier_space";
	protected void checkSupplierSpaceIdOfGoodsShelf(RetailscmUserContext userContext, String supplierSpaceId, List<Message> messageList)
	{
		
	 	checkIdOfGoodsShelf(userContext,supplierSpaceId, messageList); 		
		
	}	 			
	
	public static final String  DAMAGE_SPACE_OF_GOODS_SHELF ="goods_shelf.damage_space";
	protected void checkDamageSpaceIdOfGoodsShelf(RetailscmUserContext userContext, String damageSpaceId, List<Message> messageList)
	{
		
	 	checkIdOfGoodsShelf(userContext,damageSpaceId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GOODS_SHELF ="goods_shelf.version";
	protected void checkVersionOfGoodsShelf(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SHELF, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.id";
	protected void checkIdOfGoodsShelfStockCount(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_SHELF_STOCK_COUNT, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.title";
	protected void checkTitleOfGoodsShelfStockCount(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_GOODS_SHELF_STOCK_COUNT, messageList); 		
		
	}	 			
	
	public static final String  COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.count_time";
	protected void checkCountTimeOfGoodsShelfStockCount(RetailscmUserContext userContext, Date countTime, List<Message> messageList)
	{
		
	 	checkDateRange(countTime,parseDate("1900-01-01"), parseDate("2017-04-01"),COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT, messageList); 		
		
	}	 			
	
	public static final String  SUMMARY_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.summary";
	protected void checkSummaryOfGoodsShelfStockCount(RetailscmUserContext userContext, String summary, List<Message> messageList)
	{
		
	 	checkStringLengthRange(summary,5, 72,SUMMARY_OF_GOODS_SHELF_STOCK_COUNT, messageList); 		
		
	}	 			
	
	public static final String  SHELF_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.shelf";
	protected void checkShelfIdOfGoodsShelfStockCount(RetailscmUserContext userContext, String shelfId, List<Message> messageList)
	{
		
	 	checkIdOfGoodsShelfStockCount(userContext,shelfId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.version";
	protected void checkVersionOfGoodsShelfStockCount(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SHELF_STOCK_COUNT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.id";
	protected void checkIdOfStockCountIssueTrack(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_STOCK_COUNT_ISSUE_TRACK, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.title";
	protected void checkTitleOfStockCountIssueTrack(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_STOCK_COUNT_ISSUE_TRACK, messageList); 		
		
	}	 			
	
	public static final String  COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.count_time";
	protected void checkCountTimeOfStockCountIssueTrack(RetailscmUserContext userContext, Date countTime, List<Message> messageList)
	{
		
	 	checkDateRange(countTime,parseDate("1900-01-01"), parseDate("2017-04-01"),COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK, messageList); 		
		
	}	 			
	
	public static final String  SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.summary";
	protected void checkSummaryOfStockCountIssueTrack(RetailscmUserContext userContext, String summary, List<Message> messageList)
	{
		
	 	checkStringLengthRange(summary,3, 40,SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK, messageList); 		
		
	}	 			
	
	public static final String  STOCK_COUNT_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.stock_count";
	protected void checkStockCountIdOfStockCountIssueTrack(RetailscmUserContext userContext, String stockCountId, List<Message> messageList)
	{
		
	 	checkIdOfStockCountIssueTrack(userContext,stockCountId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.version";
	protected void checkVersionOfStockCountIssueTrack(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_STOCK_COUNT_ISSUE_TRACK, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GOODS_ALLOCATION ="goods_allocation.id";
	protected void checkIdOfGoodsAllocation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_ALLOCATION, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_GOODS_ALLOCATION ="goods_allocation.location";
	protected void checkLocationOfGoodsAllocation(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,6, 84,LOCATION_OF_GOODS_ALLOCATION, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_GOODS_ALLOCATION ="goods_allocation.latitude";
	protected void checkLatitudeOfGoodsAllocation(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_GOODS_ALLOCATION, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_GOODS_ALLOCATION ="goods_allocation.longitude";
	protected void checkLongitudeOfGoodsAllocation(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_GOODS_ALLOCATION, messageList); 		
		
	}	 			
	
	public static final String  GOODS_SHELF_OF_GOODS_ALLOCATION ="goods_allocation.goods_shelf";
	protected void checkGoodsShelfIdOfGoodsAllocation(RetailscmUserContext userContext, String goodsShelfId, List<Message> messageList)
	{
		
	 	checkIdOfGoodsAllocation(userContext,goodsShelfId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GOODS_ALLOCATION ="goods_allocation.version";
	protected void checkVersionOfGoodsAllocation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_ALLOCATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GOODS ="goods.id";
	protected void checkIdOfGoods(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_GOODS ="goods.name";
	protected void checkNameOfGoods(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_GOODS, messageList); 		
		
	}	 			
	
	public static final String  RFID_OF_GOODS ="goods.rfid";
	protected void checkRfidOfGoods(RetailscmUserContext userContext, String rfid, List<Message> messageList)
	{
		
	 	checkStringLengthRange(rfid,2, 28,RFID_OF_GOODS, messageList); 		
		
	}	 			
	
	public static final String  UOM_OF_GOODS ="goods.uom";
	protected void checkUomOfGoods(RetailscmUserContext userContext, String uom, List<Message> messageList)
	{
		
	 	checkStringLengthRange(uom,0, 4,UOM_OF_GOODS, messageList); 		
		
	}	 			
	
	public static final String  MAX_PACKAGE_OF_GOODS ="goods.max_package";
	protected void checkMaxPackageOfGoods(RetailscmUserContext userContext, int maxPackage, List<Message> messageList)
	{
		
	 	checkIntegerRange(maxPackage,0, 10,MAX_PACKAGE_OF_GOODS, messageList); 		
		
	}	 			
	
	public static final String  EXPIRE_TIME_OF_GOODS ="goods.expire_time";
	protected void checkExpireTimeOfGoods(RetailscmUserContext userContext, Date expireTime, List<Message> messageList)
	{
		
	 	checkDateRange(expireTime,parseDate("1900-01-01"), parseDate("2019-09-09"),EXPIRE_TIME_OF_GOODS, messageList); 		
		
	}	 			
	
	public static final String  SKU_OF_GOODS ="goods.sku";
	protected void checkSkuIdOfGoods(RetailscmUserContext userContext, String skuId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,skuId, messageList); 		
		
	}	 			
	
	public static final String  RECEIVING_SPACE_OF_GOODS ="goods.receiving_space";
	protected void checkReceivingSpaceIdOfGoods(RetailscmUserContext userContext, String receivingSpaceId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,receivingSpaceId, messageList); 		
		
	}	 			
	
	public static final String  GOODS_ALLOCATION_OF_GOODS ="goods.goods_allocation";
	protected void checkGoodsAllocationIdOfGoods(RetailscmUserContext userContext, String goodsAllocationId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,goodsAllocationId, messageList); 		
		
	}	 			
	
	public static final String  SMART_PALLET_OF_GOODS ="goods.smart_pallet";
	protected void checkSmartPalletIdOfGoods(RetailscmUserContext userContext, String smartPalletId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,smartPalletId, messageList); 		
		
	}	 			
	
	public static final String  SHIPPING_SPACE_OF_GOODS ="goods.shipping_space";
	protected void checkShippingSpaceIdOfGoods(RetailscmUserContext userContext, String shippingSpaceId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,shippingSpaceId, messageList); 		
		
	}	 			
	
	public static final String  TRANSPORT_TASK_OF_GOODS ="goods.transport_task";
	protected void checkTransportTaskIdOfGoods(RetailscmUserContext userContext, String transportTaskId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,transportTaskId, messageList); 		
		
	}	 			
	
	public static final String  RETAIL_STORE_OF_GOODS ="goods.retail_store";
	protected void checkRetailStoreIdOfGoods(RetailscmUserContext userContext, String retailStoreId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,retailStoreId, messageList); 		
		
	}	 			
	
	public static final String  BIZ_ORDER_OF_GOODS ="goods.biz_order";
	protected void checkBizOrderIdOfGoods(RetailscmUserContext userContext, String bizOrderId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,bizOrderId, messageList); 		
		
	}	 			
	
	public static final String  RETAIL_STORE_ORDER_OF_GOODS ="goods.retail_store_order";
	protected void checkRetailStoreOrderIdOfGoods(RetailscmUserContext userContext, String retailStoreOrderId, List<Message> messageList)
	{
		
	 	checkIdOfGoods(userContext,retailStoreOrderId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GOODS ="goods.version";
	protected void checkVersionOfGoods(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GOODS_PACKAGING ="goods_packaging.id";
	protected void checkIdOfGoodsPackaging(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_PACKAGING, messageList); 		
		
	}	 			
	
	public static final String  PACKAGE_NAME_OF_GOODS_PACKAGING ="goods_packaging.package_name";
	protected void checkPackageNameOfGoodsPackaging(RetailscmUserContext userContext, String packageName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(packageName,1, 12,PACKAGE_NAME_OF_GOODS_PACKAGING, messageList); 		
		
	}	 			
	
	public static final String  RFID_OF_GOODS_PACKAGING ="goods_packaging.rfid";
	protected void checkRfidOfGoodsPackaging(RetailscmUserContext userContext, String rfid, List<Message> messageList)
	{
		
	 	checkStringLengthRange(rfid,2, 28,RFID_OF_GOODS_PACKAGING, messageList); 		
		
	}	 			
	
	public static final String  PACKAGE_TIME_OF_GOODS_PACKAGING ="goods_packaging.package_time";
	protected void checkPackageTimeOfGoodsPackaging(RetailscmUserContext userContext, Date packageTime, List<Message> messageList)
	{
		
	 	checkDateRange(packageTime,parseDate("1900-01-01"), parseDate("2017-09-09"),PACKAGE_TIME_OF_GOODS_PACKAGING, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GOODS_PACKAGING ="goods_packaging.description";
	protected void checkDescriptionOfGoodsPackaging(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,3, 36,DESCRIPTION_OF_GOODS_PACKAGING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GOODS_PACKAGING ="goods_packaging.version";
	protected void checkVersionOfGoodsPackaging(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_PACKAGING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GOODS_MOVEMENT ="goods_movement.id";
	protected void checkIdOfGoodsMovement(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  MOVE_TIME_OF_GOODS_MOVEMENT ="goods_movement.move_time";
	protected void checkMoveTimeOfGoodsMovement(RetailscmUserContext userContext, DateTime moveTime, List<Message> messageList)
	{
		
	 	checkDateTime(moveTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2017-08-09T09:09:09"),MOVE_TIME_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  FACILITY_OF_GOODS_MOVEMENT ="goods_movement.facility";
	protected void checkFacilityOfGoodsMovement(RetailscmUserContext userContext, String facility, List<Message> messageList)
	{
		
	 	checkStringLengthRange(facility,1, 16,FACILITY_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  FACILITY_ID_OF_GOODS_MOVEMENT ="goods_movement.facility_id";
	protected void checkFacilityIdOfGoodsMovement(RetailscmUserContext userContext, String facilityId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(facilityId,1, 16,FACILITY_ID_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_GOODS_MOVEMENT ="goods_movement.from_ip";
	protected void checkFromIpOfGoodsMovement(RetailscmUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,4, 48,FROM_IP_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  USER_AGENT_OF_GOODS_MOVEMENT ="goods_movement.user_agent";
	protected void checkUserAgentOfGoodsMovement(RetailscmUserContext userContext, String userAgent, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userAgent,28, 444,USER_AGENT_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  SESSION_ID_OF_GOODS_MOVEMENT ="goods_movement.session_id";
	protected void checkSessionIdOfGoodsMovement(RetailscmUserContext userContext, String sessionId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(sessionId,6, 80,SESSION_ID_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_GOODS_MOVEMENT ="goods_movement.latitude";
	protected void checkLatitudeOfGoodsMovement(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_GOODS_MOVEMENT ="goods_movement.longitude";
	protected void checkLongitudeOfGoodsMovement(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  GOODS_OF_GOODS_MOVEMENT ="goods_movement.goods";
	protected void checkGoodsIdOfGoodsMovement(RetailscmUserContext userContext, String goodsId, List<Message> messageList)
	{
		
	 	checkIdOfGoodsMovement(userContext,goodsId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GOODS_MOVEMENT ="goods_movement.version";
	protected void checkVersionOfGoodsMovement(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_MOVEMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SUPPLIER_SPACE ="supplier_space.id";
	protected void checkIdOfSupplierSpace(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLIER_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_SUPPLIER_SPACE ="supplier_space.location";
	protected void checkLocationOfSupplierSpace(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,5, 76,LOCATION_OF_SUPPLIER_SPACE, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_SUPPLIER_SPACE ="supplier_space.contact_number";
	protected void checkContactNumberOfSupplierSpace(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SUPPLIER_SPACE, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AREA_OF_SUPPLIER_SPACE ="supplier_space.total_area";
	protected void checkTotalAreaOfSupplierSpace(RetailscmUserContext userContext, String totalArea, List<Message> messageList)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SUPPLIER_SPACE, messageList); 		
		
	}	 			
	
	public static final String  WAREHOUSE_OF_SUPPLIER_SPACE ="supplier_space.warehouse";
	protected void checkWarehouseIdOfSupplierSpace(RetailscmUserContext userContext, String warehouseId, List<Message> messageList)
	{
		
	 	checkIdOfSupplierSpace(userContext,warehouseId, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_SUPPLIER_SPACE ="supplier_space.latitude";
	protected void checkLatitudeOfSupplierSpace(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SUPPLIER_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_SUPPLIER_SPACE ="supplier_space.longitude";
	protected void checkLongitudeOfSupplierSpace(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SUPPLIER_SPACE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SUPPLIER_SPACE ="supplier_space.version";
	protected void checkVersionOfSupplierSpace(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLIER_SPACE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RECEIVING_SPACE ="receiving_space.id";
	protected void checkIdOfReceivingSpace(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_RECEIVING_SPACE ="receiving_space.location";
	protected void checkLocationOfReceivingSpace(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,5, 64,LOCATION_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_RECEIVING_SPACE ="receiving_space.contact_number";
	protected void checkContactNumberOfReceivingSpace(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_RECEIVING_SPACE ="receiving_space.description";
	protected void checkDescriptionOfReceivingSpace(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AREA_OF_RECEIVING_SPACE ="receiving_space.total_area";
	protected void checkTotalAreaOfReceivingSpace(RetailscmUserContext userContext, String totalArea, List<Message> messageList)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  WAREHOUSE_OF_RECEIVING_SPACE ="receiving_space.warehouse";
	protected void checkWarehouseIdOfReceivingSpace(RetailscmUserContext userContext, String warehouseId, List<Message> messageList)
	{
		
	 	checkIdOfReceivingSpace(userContext,warehouseId, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_RECEIVING_SPACE ="receiving_space.latitude";
	protected void checkLatitudeOfReceivingSpace(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_RECEIVING_SPACE ="receiving_space.longitude";
	protected void checkLongitudeOfReceivingSpace(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RECEIVING_SPACE ="receiving_space.version";
	protected void checkVersionOfReceivingSpace(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RECEIVING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SHIPPING_SPACE ="shipping_space.id";
	protected void checkIdOfShippingSpace(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_SHIPPING_SPACE ="shipping_space.location";
	protected void checkLocationOfShippingSpace(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 56,LOCATION_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_SHIPPING_SPACE ="shipping_space.contact_number";
	protected void checkContactNumberOfShippingSpace(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AREA_OF_SHIPPING_SPACE ="shipping_space.total_area";
	protected void checkTotalAreaOfShippingSpace(RetailscmUserContext userContext, String totalArea, List<Message> messageList)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  WAREHOUSE_OF_SHIPPING_SPACE ="shipping_space.warehouse";
	protected void checkWarehouseIdOfShippingSpace(RetailscmUserContext userContext, String warehouseId, List<Message> messageList)
	{
		
	 	checkIdOfShippingSpace(userContext,warehouseId, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_SHIPPING_SPACE ="shipping_space.latitude";
	protected void checkLatitudeOfShippingSpace(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_SHIPPING_SPACE ="shipping_space.longitude";
	protected void checkLongitudeOfShippingSpace(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_SHIPPING_SPACE ="shipping_space.description";
	protected void checkDescriptionOfShippingSpace(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SHIPPING_SPACE ="shipping_space.version";
	protected void checkVersionOfShippingSpace(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_SPACE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_DAMAGE_SPACE ="damage_space.id";
	protected void checkIdOfDamageSpace(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_DAMAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_DAMAGE_SPACE ="damage_space.location";
	protected void checkLocationOfDamageSpace(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,6, 80,LOCATION_OF_DAMAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_DAMAGE_SPACE ="damage_space.contact_number";
	protected void checkContactNumberOfDamageSpace(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_DAMAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  TOTAL_AREA_OF_DAMAGE_SPACE ="damage_space.total_area";
	protected void checkTotalAreaOfDamageSpace(RetailscmUserContext userContext, String totalArea, List<Message> messageList)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_DAMAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_DAMAGE_SPACE ="damage_space.latitude";
	protected void checkLatitudeOfDamageSpace(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_DAMAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_DAMAGE_SPACE ="damage_space.longitude";
	protected void checkLongitudeOfDamageSpace(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_DAMAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  WAREHOUSE_OF_DAMAGE_SPACE ="damage_space.warehouse";
	protected void checkWarehouseIdOfDamageSpace(RetailscmUserContext userContext, String warehouseId, List<Message> messageList)
	{
		
	 	checkIdOfDamageSpace(userContext,warehouseId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_DAMAGE_SPACE ="damage_space.version";
	protected void checkVersionOfDamageSpace(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DAMAGE_SPACE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_WAREHOUSE_ASSET ="warehouse_asset.id";
	protected void checkIdOfWarehouseAsset(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_WAREHOUSE_ASSET, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_WAREHOUSE_ASSET ="warehouse_asset.name";
	protected void checkNameOfWarehouseAsset(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_WAREHOUSE_ASSET, messageList); 		
		
	}	 			
	
	public static final String  POSITION_OF_WAREHOUSE_ASSET ="warehouse_asset.position";
	protected void checkPositionOfWarehouseAsset(RetailscmUserContext userContext, String position, List<Message> messageList)
	{
		
	 	checkStringLengthRange(position,3, 40,POSITION_OF_WAREHOUSE_ASSET, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_WAREHOUSE_ASSET ="warehouse_asset.owner";
	protected void checkOwnerIdOfWarehouseAsset(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfWarehouseAsset(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_WAREHOUSE_ASSET ="warehouse_asset.version";
	protected void checkVersionOfWarehouseAsset(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WAREHOUSE_ASSET, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_FLEET ="transport_fleet.id";
	protected void checkIdOfTransportFleet(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_FLEET, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_FLEET ="transport_fleet.name";
	protected void checkNameOfTransportFleet(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_TRANSPORT_FLEET, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_TRANSPORT_FLEET ="transport_fleet.contact_number";
	protected void checkContactNumberOfTransportFleet(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_TRANSPORT_FLEET, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_TRANSPORT_FLEET ="transport_fleet.owner";
	protected void checkOwnerIdOfTransportFleet(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfTransportFleet(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_FLEET ="transport_fleet.version";
	protected void checkVersionOfTransportFleet(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_FLEET, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_TRUCK ="transport_truck.id";
	protected void checkIdOfTransportTruck(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_TRUCK ="transport_truck.name";
	protected void checkNameOfTransportTruck(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  PLATE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.plate_number";
	protected void checkPlateNumberOfTransportTruck(RetailscmUserContext userContext, String plateNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(plateNumber,2, 16,PLATE_NUMBER_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.contact_number";
	protected void checkContactNumberOfTransportTruck(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.vehicle_license_number";
	protected void checkVehicleLicenseNumberOfTransportTruck(RetailscmUserContext userContext, String vehicleLicenseNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(vehicleLicenseNumber,2, 24,VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  ENGINE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.engine_number";
	protected void checkEngineNumberOfTransportTruck(RetailscmUserContext userContext, String engineNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(engineNumber,2, 28,ENGINE_NUMBER_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_TRANSPORT_TRUCK ="transport_truck.make_date";
	protected void checkMakeDateOfTransportTruck(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2010-09-09"),MAKE_DATE_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  MILEAGE_OF_TRANSPORT_TRUCK ="transport_truck.mileage";
	protected void checkMileageOfTransportTruck(RetailscmUserContext userContext, String mileage, List<Message> messageList)
	{
		
	 	checkStringLengthRange(mileage,2, 24,MILEAGE_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  BODY_COLOR_OF_TRANSPORT_TRUCK ="transport_truck.body_color";
	protected void checkBodyColorOfTransportTruck(RetailscmUserContext userContext, String bodyColor, List<Message> messageList)
	{
		
	 	checkStringLengthRange(bodyColor,1, 8,BODY_COLOR_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  OWNER_OF_TRANSPORT_TRUCK ="transport_truck.owner";
	protected void checkOwnerIdOfTransportTruck(RetailscmUserContext userContext, String ownerId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTruck(userContext,ownerId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_TRUCK ="transport_truck.version";
	protected void checkVersionOfTransportTruck(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TRUCK, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRUCK_DRIVER ="truck_driver.id";
	protected void checkIdOfTruckDriver(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRUCK_DRIVER, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRUCK_DRIVER ="truck_driver.name";
	protected void checkNameOfTruckDriver(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_TRUCK_DRIVER, messageList); 		
		
	}	 			
	
	public static final String  DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER ="truck_driver.driver_license_number";
	protected void checkDriverLicenseNumberOfTruckDriver(RetailscmUserContext userContext, String driverLicenseNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(driverLicenseNumber,3, 44,DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER, messageList); 		
		
	}	 			
	
	public static final String  CONTACT_NUMBER_OF_TRUCK_DRIVER ="truck_driver.contact_number";
	protected void checkContactNumberOfTruckDriver(RetailscmUserContext userContext, String contactNumber, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(contactNumber,5, 44,CONTACT_NUMBER_OF_TRUCK_DRIVER, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_TRUCK_DRIVER ="truck_driver.belongs_to";
	protected void checkBelongsToIdOfTruckDriver(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfTruckDriver(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRUCK_DRIVER ="truck_driver.version";
	protected void checkVersionOfTruckDriver(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRUCK_DRIVER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_TASK ="transport_task.id";
	protected void checkIdOfTransportTask(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRANSPORT_TASK ="transport_task.name";
	protected void checkNameOfTransportTask(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  START_OF_TRANSPORT_TASK ="transport_task.start";
	protected void checkStartOfTransportTask(RetailscmUserContext userContext, String start, List<Message> messageList)
	{
		
	 	checkStringLengthRange(start,2, 20,START_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  BEGIN_TIME_OF_TRANSPORT_TASK ="transport_task.begin_time";
	protected void checkBeginTimeOfTransportTask(RetailscmUserContext userContext, Date beginTime, List<Message> messageList)
	{
		
	 	checkDatePast(beginTime,parseDate("1900-01-01"), new Date(),BEGIN_TIME_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  END_OF_TRANSPORT_TASK ="transport_task.end";
	protected void checkEndIdOfTransportTask(RetailscmUserContext userContext, String endId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,endId, messageList); 		
		
	}	 			
	
	public static final String  DRIVER_OF_TRANSPORT_TASK ="transport_task.driver";
	protected void checkDriverIdOfTransportTask(RetailscmUserContext userContext, String driverId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,driverId, messageList); 		
		
	}	 			
	
	public static final String  TRUCK_OF_TRANSPORT_TASK ="transport_task.truck";
	protected void checkTruckIdOfTransportTask(RetailscmUserContext userContext, String truckId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,truckId, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_TRANSPORT_TASK ="transport_task.belongs_to";
	protected void checkBelongsToIdOfTransportTask(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTask(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_TRANSPORT_TASK ="transport_task.latitude";
	protected void checkLatitudeOfTransportTask(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_TRANSPORT_TASK ="transport_task.longitude";
	protected void checkLongitudeOfTransportTask(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_TASK ="transport_task.version";
	protected void checkVersionOfTransportTask(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRANSPORT_TASK_TRACK ="transport_task_track.id";
	protected void checkIdOfTransportTaskTrack(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  TRACK_TIME_OF_TRANSPORT_TASK_TRACK ="transport_task_track.track_time";
	protected void checkTrackTimeOfTransportTaskTrack(RetailscmUserContext userContext, Date trackTime, List<Message> messageList)
	{
		
	 	checkDatePast(trackTime,parseDate("1900-01-01"), new Date(),TRACK_TIME_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  LATITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.latitude";
	protected void checkLatitudeOfTransportTaskTrack(RetailscmUserContext userContext, BigDecimal latitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  LONGITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.longitude";
	protected void checkLongitudeOfTransportTaskTrack(RetailscmUserContext userContext, BigDecimal longitude, List<Message> messageList)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  MOVEMENT_OF_TRANSPORT_TASK_TRACK ="transport_task_track.movement";
	protected void checkMovementIdOfTransportTaskTrack(RetailscmUserContext userContext, String movementId, List<Message> messageList)
	{
		
	 	checkIdOfTransportTaskTrack(userContext,movementId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRANSPORT_TASK_TRACK ="transport_task_track.version";
	protected void checkVersionOfTransportTaskTrack(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK_TRACK, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNT_SET ="account_set.id";
	protected void checkIdOfAccountSet(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_ACCOUNT_SET ="account_set.name";
	protected void checkNameOfAccountSet(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 24,NAME_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  YEAR_SET_OF_ACCOUNT_SET ="account_set.year_set";
	protected void checkYearSetOfAccountSet(RetailscmUserContext userContext, String yearSet, List<Message> messageList)
	{
		
	 	checkStringLengthRange(yearSet,2, 20,YEAR_SET_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  EFFECTIVE_DATE_OF_ACCOUNT_SET ="account_set.effective_date";
	protected void checkEffectiveDateOfAccountSet(RetailscmUserContext userContext, Date effectiveDate, List<Message> messageList)
	{
		
	 	checkDateRange(effectiveDate,parseDate("1900-01-01"), parseDate("2017-05-28"),EFFECTIVE_DATE_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_SYSTEM_OF_ACCOUNT_SET ="account_set.accounting_system";
	protected void checkAccountingSystemOfAccountSet(RetailscmUserContext userContext, String accountingSystem, List<Message> messageList)
	{
		
	 	checkStringLengthRange(accountingSystem,3, 28,ACCOUNTING_SYSTEM_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET ="account_set.domestic_currency_code";
	protected void checkDomesticCurrencyCodeOfAccountSet(RetailscmUserContext userContext, String domesticCurrencyCode, List<Message> messageList)
	{
		
	 	checkStringLengthRange(domesticCurrencyCode,1, 12,DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET ="account_set.domestic_currency_name";
	protected void checkDomesticCurrencyNameOfAccountSet(RetailscmUserContext userContext, String domesticCurrencyName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(domesticCurrencyName,1, 12,DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  OPENING_BANK_OF_ACCOUNT_SET ="account_set.opening_bank";
	protected void checkOpeningBankOfAccountSet(RetailscmUserContext userContext, String openingBank, List<Message> messageList)
	{
		
	 	checkStringLengthRange(openingBank,2, 16,OPENING_BANK_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNT_NUMBER_OF_ACCOUNT_SET ="account_set.account_number";
	protected void checkAccountNumberOfAccountSet(RetailscmUserContext userContext, String accountNumber, List<Message> messageList)
	{
		
	 	checkStringLengthRange(accountNumber,4, 56,ACCOUNT_NUMBER_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  COUNTRY_CENTER_OF_ACCOUNT_SET ="account_set.country_center";
	protected void checkCountryCenterIdOfAccountSet(RetailscmUserContext userContext, String countryCenterId, List<Message> messageList)
	{
		
	 	checkIdOfAccountSet(userContext,countryCenterId, messageList); 		
		
	}	 			
	
	public static final String  RETAIL_STORE_OF_ACCOUNT_SET ="account_set.retail_store";
	protected void checkRetailStoreIdOfAccountSet(RetailscmUserContext userContext, String retailStoreId, List<Message> messageList)
	{
		
	 	checkIdOfAccountSet(userContext,retailStoreId, messageList); 		
		
	}	 			
	
	public static final String  GOODS_SUPPLIER_OF_ACCOUNT_SET ="account_set.goods_supplier";
	protected void checkGoodsSupplierIdOfAccountSet(RetailscmUserContext userContext, String goodsSupplierId, List<Message> messageList)
	{
		
	 	checkIdOfAccountSet(userContext,goodsSupplierId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNT_SET ="account_set.version";
	protected void checkVersionOfAccountSet(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNT_SET, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_SUBJECT ="accounting_subject.id";
	protected void checkIdOfAccountingSubject(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_SUBJECT, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_code";
	protected void checkAccountingSubjectCodeOfAccountingSubject(RetailscmUserContext userContext, String accountingSubjectCode, List<Message> messageList)
	{
		
	 	checkStringLengthRange(accountingSubjectCode,2, 24,ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_name";
	protected void checkAccountingSubjectNameOfAccountingSubject(RetailscmUserContext userContext, String accountingSubjectName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(accountingSubjectName,2, 16,ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_code";
	protected void checkAccountingSubjectClassCodeOfAccountingSubject(RetailscmUserContext userContext, int accountingSubjectClassCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(accountingSubjectClassCode,0, 6,ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_name";
	protected void checkAccountingSubjectClassNameOfAccountingSubject(RetailscmUserContext userContext, String accountingSubjectClassName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(accountingSubjectClassName,1, 24,ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNT_SET_OF_ACCOUNTING_SUBJECT ="accounting_subject.account_set";
	protected void checkAccountSetIdOfAccountingSubject(RetailscmUserContext userContext, String accountSetId, List<Message> messageList)
	{
		
	 	checkIdOfAccountingSubject(userContext,accountSetId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_SUBJECT ="accounting_subject.version";
	protected void checkVersionOfAccountingSubject(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_SUBJECT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_PERIOD ="accounting_period.id";
	protected void checkIdOfAccountingPeriod(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_ACCOUNTING_PERIOD ="accounting_period.name";
	protected void checkNameOfAccountingPeriod(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 32,NAME_OF_ACCOUNTING_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  START_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.start_date";
	protected void checkStartDateOfAccountingPeriod(RetailscmUserContext userContext, Date startDate, List<Message> messageList)
	{
		
	 	checkDateRange(startDate,parseDate("1900-01-01"), parseDate("2017-01-09"),START_DATE_OF_ACCOUNTING_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  END_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.end_date";
	protected void checkEndDateOfAccountingPeriod(RetailscmUserContext userContext, Date endDate, List<Message> messageList)
	{
		
	 	checkDateRange(endDate,parseDate("1900-01-01"), parseDate("2017-01-09"),END_DATE_OF_ACCOUNTING_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNT_SET_OF_ACCOUNTING_PERIOD ="accounting_period.account_set";
	protected void checkAccountSetIdOfAccountingPeriod(RetailscmUserContext userContext, String accountSetId, List<Message> messageList)
	{
		
	 	checkIdOfAccountingPeriod(userContext,accountSetId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_PERIOD ="accounting_period.version";
	protected void checkVersionOfAccountingPeriod(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_PERIOD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.id";
	protected void checkIdOfAccountingDocumentType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_TYPE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.name";
	protected void checkNameOfAccountingDocumentType(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT_TYPE, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.description";
	protected void checkDescriptionOfAccountingDocumentType(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,18, 280,DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.accounting_period";
	protected void checkAccountingPeriodIdOfAccountingDocumentType(RetailscmUserContext userContext, String accountingPeriodId, List<Message> messageList)
	{
		
	 	checkIdOfAccountingDocumentType(userContext,accountingPeriodId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.version";
	protected void checkVersionOfAccountingDocumentType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_DOCUMENT ="accounting_document.id";
	protected void checkIdOfAccountingDocument(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_ACCOUNTING_DOCUMENT ="accounting_document.name";
	protected void checkNameOfAccountingDocument(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT ="accounting_document.accounting_document_date";
	protected void checkAccountingDocumentDateOfAccountingDocument(RetailscmUserContext userContext, Date accountingDocumentDate, List<Message> messageList)
	{
		
	 	checkDateRange(accountingDocumentDate,parseDate("1900-01-01"), parseDate("2018-09-09"),ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT ="accounting_document.accounting_period";
	protected void checkAccountingPeriodIdOfAccountingDocument(RetailscmUserContext userContext, String accountingPeriodId, List<Message> messageList)
	{
		
	 	checkIdOfAccountingDocument(userContext,accountingPeriodId, messageList); 		
		
	}	 			
	
	public static final String  DOCUMENT_TYPE_OF_ACCOUNTING_DOCUMENT ="accounting_document.document_type";
	protected void checkDocumentTypeIdOfAccountingDocument(RetailscmUserContext userContext, String documentTypeId, List<Message> messageList)
	{
		
	 	checkIdOfAccountingDocument(userContext,documentTypeId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT ="accounting_document.version";
	protected void checkVersionOfAccountingDocument(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.id";
	protected void checkIdOfAccountingDocumentCreation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_CREATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.who";
	protected void checkWhoOfAccountingDocumentCreation(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_CREATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.comments";
	protected void checkCommentsOfAccountingDocumentCreation(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.make_date";
	protected void checkMakeDateOfAccountingDocumentCreation(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.version";
	protected void checkVersionOfAccountingDocumentCreation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_CREATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.id";
	protected void checkIdOfAccountingDocumentConfirmation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.who";
	protected void checkWhoOfAccountingDocumentConfirmation(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.comments";
	protected void checkCommentsOfAccountingDocumentConfirmation(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.make_date";
	protected void checkMakeDateOfAccountingDocumentConfirmation(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.version";
	protected void checkVersionOfAccountingDocumentConfirmation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.id";
	protected void checkIdOfAccountingDocumentAuditing(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.who";
	protected void checkWhoOfAccountingDocumentAuditing(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.comments";
	protected void checkCommentsOfAccountingDocumentAuditing(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.make_date";
	protected void checkMakeDateOfAccountingDocumentAuditing(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.version";
	protected void checkVersionOfAccountingDocumentAuditing(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.id";
	protected void checkIdOfAccountingDocumentPosting(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_POSTING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.who";
	protected void checkWhoOfAccountingDocumentPosting(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_POSTING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.comments";
	protected void checkCommentsOfAccountingDocumentPosting(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.make_date";
	protected void checkMakeDateOfAccountingDocumentPosting(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.version";
	protected void checkVersionOfAccountingDocumentPosting(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_POSTING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ORIGINAL_VOUCHER ="original_voucher.id";
	protected void checkIdOfOriginalVoucher(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_ORIGINAL_VOUCHER ="original_voucher.title";
	protected void checkTitleOfOriginalVoucher(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 28,TITLE_OF_ORIGINAL_VOUCHER, messageList); 		
		
	}	 			
	
	public static final String  MADE_BY_OF_ORIGINAL_VOUCHER ="original_voucher.made_by";
	protected void checkMadeByOfOriginalVoucher(RetailscmUserContext userContext, String madeBy, List<Message> messageList)
	{
		
	 	checkStringLengthRange(madeBy,1, 12,MADE_BY_OF_ORIGINAL_VOUCHER, messageList); 		
		
	}	 			
	
	public static final String  RECEIVED_BY_OF_ORIGINAL_VOUCHER ="original_voucher.received_by";
	protected void checkReceivedByOfOriginalVoucher(RetailscmUserContext userContext, String receivedBy, List<Message> messageList)
	{
		
	 	checkStringLengthRange(receivedBy,1, 12,RECEIVED_BY_OF_ORIGINAL_VOUCHER, messageList); 		
		
	}	 			
	
	public static final String  VOUCHER_TYPE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_type";
	protected void checkVoucherTypeOfOriginalVoucher(RetailscmUserContext userContext, String voucherType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(voucherType,1, 16,VOUCHER_TYPE_OF_ORIGINAL_VOUCHER, messageList); 		
		
	}	 			
	
	public static final String  VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_image";
	protected void checkVoucherImageOfOriginalVoucher(RetailscmUserContext userContext, String voucherImage, List<Message> messageList)
	{
		
	 	checkImage(voucherImage,0, 512,VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_ORIGINAL_VOUCHER ="original_voucher.belongs_to";
	protected void checkBelongsToIdOfOriginalVoucher(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfOriginalVoucher(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ORIGINAL_VOUCHER ="original_voucher.version";
	protected void checkVersionOfOriginalVoucher(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.id";
	protected void checkIdOfOriginalVoucherCreation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER_CREATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.who";
	protected void checkWhoOfOriginalVoucherCreation(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_CREATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.comments";
	protected void checkCommentsOfOriginalVoucherCreation(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ORIGINAL_VOUCHER_CREATION, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.make_date";
	protected void checkMakeDateOfOriginalVoucherCreation(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.version";
	protected void checkVersionOfOriginalVoucherCreation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_CREATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.id";
	protected void checkIdOfOriginalVoucherConfirmation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.who";
	protected void checkWhoOfOriginalVoucherConfirmation(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.comments";
	protected void checkCommentsOfOriginalVoucherConfirmation(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.make_date";
	protected void checkMakeDateOfOriginalVoucherConfirmation(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.version";
	protected void checkVersionOfOriginalVoucherConfirmation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.id";
	protected void checkIdOfOriginalVoucherAuditing(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.who";
	protected void checkWhoOfOriginalVoucherAuditing(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.comments";
	protected void checkCommentsOfOriginalVoucherAuditing(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.make_date";
	protected void checkMakeDateOfOriginalVoucherAuditing(RetailscmUserContext userContext, Date makeDate, List<Message> messageList)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.version";
	protected void checkVersionOfOriginalVoucherAuditing(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_AUDITING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.id";
	protected void checkIdOfAccountingDocumentLine(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_LINE, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.name";
	protected void checkNameOfAccountingDocumentLine(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT_LINE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.code";
	protected void checkCodeOfAccountingDocumentLine(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_ACCOUNTING_DOCUMENT_LINE, messageList); 		
		
	}	 			
	
	public static final String  DIRECT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.direct";
	protected void checkDirectOfAccountingDocumentLine(RetailscmUserContext userContext, String direct, List<Message> messageList)
	{
		
	 	checkStringLengthRange(direct,0, 4,DIRECT_OF_ACCOUNTING_DOCUMENT_LINE, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.amount";
	protected void checkAmountOfAccountingDocumentLine(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 989127.99,AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.belongs_to";
	protected void checkBelongsToIdOfAccountingDocumentLine(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfAccountingDocumentLine(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  ACCOUNTING_SUBJECT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.accounting_subject";
	protected void checkAccountingSubjectIdOfAccountingDocumentLine(RetailscmUserContext userContext, String accountingSubjectId, List<Message> messageList)
	{
		
	 	checkIdOfAccountingDocumentLine(userContext,accountingSubjectId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.version";
	protected void checkVersionOfAccountingDocumentLine(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_LINE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.id";
	protected void checkIdOfLevelOneDepartment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.belongs_to";
	protected void checkBelongsToIdOfLevelOneDepartment(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfLevelOneDepartment(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.name";
	protected void checkNameOfLevelOneDepartment(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_LEVEL_ONE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.description";
	protected void checkDescriptionOfLevelOneDepartment(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  MANAGER_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.manager";
	protected void checkManagerOfLevelOneDepartment(RetailscmUserContext userContext, String manager, List<Message> messageList)
	{
		
	 	checkStringLengthRange(manager,1, 12,MANAGER_OF_LEVEL_ONE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.founded";
	protected void checkFoundedOfLevelOneDepartment(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_ONE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.version";
	protected void checkVersionOfLevelOneDepartment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.id";
	protected void checkIdOfLevelTwoDepartment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.belongs_to";
	protected void checkBelongsToIdOfLevelTwoDepartment(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfLevelTwoDepartment(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.name";
	protected void checkNameOfLevelTwoDepartment(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_LEVEL_TWO_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.description";
	protected void checkDescriptionOfLevelTwoDepartment(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.founded";
	protected void checkFoundedOfLevelTwoDepartment(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_TWO_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.version";
	protected void checkVersionOfLevelTwoDepartment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.id";
	protected void checkIdOfLevelThreeDepartment(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_THREE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  BELONGS_TO_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.belongs_to";
	protected void checkBelongsToIdOfLevelThreeDepartment(RetailscmUserContext userContext, String belongsToId, List<Message> messageList)
	{
		
	 	checkIdOfLevelThreeDepartment(userContext,belongsToId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.name";
	protected void checkNameOfLevelThreeDepartment(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,5, 52,NAME_OF_LEVEL_THREE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.description";
	protected void checkDescriptionOfLevelThreeDepartment(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  FOUNDED_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.founded";
	protected void checkFoundedOfLevelThreeDepartment(RetailscmUserContext userContext, Date founded, List<Message> messageList)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_THREE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.version";
	protected void checkVersionOfLevelThreeDepartment(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_THREE_DEPARTMENT, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SKILL_TYPE ="skill_type.id";
	protected void checkIdOfSkillType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SKILL_TYPE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_SKILL_TYPE ="skill_type.code";
	protected void checkCodeOfSkillType(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 20,CODE_OF_SKILL_TYPE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_SKILL_TYPE ="skill_type.company";
	protected void checkCompanyIdOfSkillType(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfSkillType(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_SKILL_TYPE ="skill_type.description";
	protected void checkDescriptionOfSkillType(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,1, 24,DESCRIPTION_OF_SKILL_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SKILL_TYPE ="skill_type.version";
	protected void checkVersionOfSkillType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKILL_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_RESPONSIBILITY_TYPE ="responsibility_type.id";
	protected void checkIdOfResponsibilityType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RESPONSIBILITY_TYPE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_RESPONSIBILITY_TYPE ="responsibility_type.code";
	protected void checkCodeOfResponsibilityType(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 20,CODE_OF_RESPONSIBILITY_TYPE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_RESPONSIBILITY_TYPE ="responsibility_type.company";
	protected void checkCompanyIdOfResponsibilityType(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfResponsibilityType(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.base_description";
	protected void checkBaseDescriptionOfResponsibilityType(RetailscmUserContext userContext, String baseDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(baseDescription,2, 16,BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE, messageList); 		
		
	}	 			
	
	public static final String  DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.detail_description";
	protected void checkDetailDescriptionOfResponsibilityType(RetailscmUserContext userContext, String detailDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(detailDescription,8, 116,DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_RESPONSIBILITY_TYPE ="responsibility_type.version";
	protected void checkVersionOfResponsibilityType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RESPONSIBILITY_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TERMINATION_REASON ="termination_reason.id";
	protected void checkIdOfTerminationReason(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TERMINATION_REASON, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_TERMINATION_REASON ="termination_reason.code";
	protected void checkCodeOfTerminationReason(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 28,CODE_OF_TERMINATION_REASON, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_TERMINATION_REASON ="termination_reason.company";
	protected void checkCompanyIdOfTerminationReason(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfTerminationReason(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_TERMINATION_REASON ="termination_reason.description";
	protected void checkDescriptionOfTerminationReason(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 36,DESCRIPTION_OF_TERMINATION_REASON, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TERMINATION_REASON ="termination_reason.version";
	protected void checkVersionOfTerminationReason(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION_REASON, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TERMINATION_TYPE ="termination_type.id";
	protected void checkIdOfTerminationType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TERMINATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_TERMINATION_TYPE ="termination_type.code";
	protected void checkCodeOfTerminationType(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 28,CODE_OF_TERMINATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_TERMINATION_TYPE ="termination_type.company";
	protected void checkCompanyIdOfTerminationType(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfTerminationType(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  BASE_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.base_description";
	protected void checkBaseDescriptionOfTerminationType(RetailscmUserContext userContext, String baseDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(baseDescription,1, 16,BASE_DESCRIPTION_OF_TERMINATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  DETAIL_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.detail_description";
	protected void checkDetailDescriptionOfTerminationType(RetailscmUserContext userContext, String detailDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(detailDescription,16, 248,DETAIL_DESCRIPTION_OF_TERMINATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TERMINATION_TYPE ="termination_type.version";
	protected void checkVersionOfTerminationType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OCCUPATION_TYPE ="occupation_type.id";
	protected void checkIdOfOccupationType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OCCUPATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_OCCUPATION_TYPE ="occupation_type.code";
	protected void checkCodeOfOccupationType(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_OCCUPATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_OCCUPATION_TYPE ="occupation_type.company";
	protected void checkCompanyIdOfOccupationType(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfOccupationType(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.description";
	protected void checkDescriptionOfOccupationType(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,1, 28,DESCRIPTION_OF_OCCUPATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.detail_description";
	protected void checkDetailDescriptionOfOccupationType(RetailscmUserContext userContext, String detailDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OCCUPATION_TYPE ="occupation_type.version";
	protected void checkVersionOfOccupationType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OCCUPATION_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LEAVE_TYPE ="leave_type.id";
	protected void checkIdOfLeaveType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEAVE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_LEAVE_TYPE ="leave_type.code";
	protected void checkCodeOfLeaveType(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_LEAVE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_LEAVE_TYPE ="leave_type.company";
	protected void checkCompanyIdOfLeaveType(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfLeaveType(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LEAVE_TYPE ="leave_type.description";
	protected void checkDescriptionOfLeaveType(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,1, 16,DESCRIPTION_OF_LEAVE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  DETAIL_DESCRIPTION_OF_LEAVE_TYPE ="leave_type.detail_description";
	protected void checkDetailDescriptionOfLeaveType(RetailscmUserContext userContext, String detailDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_LEAVE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LEAVE_TYPE ="leave_type.version";
	protected void checkVersionOfLeaveType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEAVE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SALARY_GRADE ="salary_grade.id";
	protected void checkIdOfSalaryGrade(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SALARY_GRADE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_SALARY_GRADE ="salary_grade.code";
	protected void checkCodeOfSalaryGrade(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_SALARY_GRADE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_SALARY_GRADE ="salary_grade.company";
	protected void checkCompanyIdOfSalaryGrade(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfSalaryGrade(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_SALARY_GRADE ="salary_grade.name";
	protected void checkNameOfSalaryGrade(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_SALARY_GRADE, messageList); 		
		
	}	 			
	
	public static final String  DETAIL_DESCRIPTION_OF_SALARY_GRADE ="salary_grade.detail_description";
	protected void checkDetailDescriptionOfSalaryGrade(RetailscmUserContext userContext, String detailDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_SALARY_GRADE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SALARY_GRADE ="salary_grade.version";
	protected void checkVersionOfSalaryGrade(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SALARY_GRADE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_INTERVIEW_TYPE ="interview_type.id";
	protected void checkIdOfInterviewType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_INTERVIEW_TYPE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_INTERVIEW_TYPE ="interview_type.code";
	protected void checkCodeOfInterviewType(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,3, 32,CODE_OF_INTERVIEW_TYPE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_INTERVIEW_TYPE ="interview_type.company";
	protected void checkCompanyIdOfInterviewType(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfInterviewType(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.description";
	protected void checkDescriptionOfInterviewType(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 24,DESCRIPTION_OF_INTERVIEW_TYPE, messageList); 		
		
	}	 			
	
	public static final String  DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.detail_description";
	protected void checkDetailDescriptionOfInterviewType(RetailscmUserContext userContext, String detailDescription, List<Message> messageList)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_INTERVIEW_TYPE ="interview_type.version";
	protected void checkVersionOfInterviewType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_INTERVIEW_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TRAINING_COURSE_TYPE ="training_course_type.id";
	protected void checkIdOfTrainingCourseType(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRAINING_COURSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_TRAINING_COURSE_TYPE ="training_course_type.code";
	protected void checkCodeOfTrainingCourseType(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 16,CODE_OF_TRAINING_COURSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_TRAINING_COURSE_TYPE ="training_course_type.company";
	protected void checkCompanyIdOfTrainingCourseType(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfTrainingCourseType(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_TRAINING_COURSE_TYPE ="training_course_type.name";
	protected void checkNameOfTrainingCourseType(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 16,NAME_OF_TRAINING_COURSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_TRAINING_COURSE_TYPE ="training_course_type.description";
	protected void checkDescriptionOfTrainingCourseType(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_TRAINING_COURSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TRAINING_COURSE_TYPE ="training_course_type.version";
	protected void checkVersionOfTrainingCourseType(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRAINING_COURSE_TYPE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PUBLIC_HOLIDAY ="public_holiday.id";
	protected void checkIdOfPublicHoliday(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PUBLIC_HOLIDAY, messageList); 		
		
	}	 			
	
	public static final String  CODE_OF_PUBLIC_HOLIDAY ="public_holiday.code";
	protected void checkCodeOfPublicHoliday(RetailscmUserContext userContext, String code, List<Message> messageList)
	{
		
	 	checkStringLengthRange(code,2, 16,CODE_OF_PUBLIC_HOLIDAY, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_PUBLIC_HOLIDAY ="public_holiday.company";
	protected void checkCompanyIdOfPublicHoliday(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfPublicHoliday(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_PUBLIC_HOLIDAY ="public_holiday.name";
	protected void checkNameOfPublicHoliday(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PUBLIC_HOLIDAY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_PUBLIC_HOLIDAY ="public_holiday.description";
	protected void checkDescriptionOfPublicHoliday(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,3, 40,DESCRIPTION_OF_PUBLIC_HOLIDAY, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PUBLIC_HOLIDAY ="public_holiday.version";
	protected void checkVersionOfPublicHoliday(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PUBLIC_HOLIDAY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_TERMINATION ="termination.id";
	protected void checkIdOfTermination(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TERMINATION, messageList); 		
		
	}	 			
	
	public static final String  REASON_OF_TERMINATION ="termination.reason";
	protected void checkReasonIdOfTermination(RetailscmUserContext userContext, String reasonId, List<Message> messageList)
	{
		
	 	checkIdOfTermination(userContext,reasonId, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_TERMINATION ="termination.type";
	protected void checkTypeIdOfTermination(RetailscmUserContext userContext, String typeId, List<Message> messageList)
	{
		
	 	checkIdOfTermination(userContext,typeId, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_TERMINATION ="termination.comment";
	protected void checkCommentOfTermination(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,2, 16,COMMENT_OF_TERMINATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_TERMINATION ="termination.version";
	protected void checkVersionOfTermination(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_VIEW ="view.id";
	protected void checkIdOfView(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_VIEW, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_VIEW ="view.who";
	protected void checkWhoOfView(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_VIEW, messageList); 		
		
	}	 			
	
	public static final String  ASSESSMENT_OF_VIEW ="view.assessment";
	protected void checkAssessmentOfView(RetailscmUserContext userContext, String assessment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(assessment,3, 40,ASSESSMENT_OF_VIEW, messageList); 		
		
	}	 			
	
	public static final String  INTERVIEW_TIME_OF_VIEW ="view.interview_time";
	protected void checkInterviewTimeOfView(RetailscmUserContext userContext, Date interviewTime, List<Message> messageList)
	{
		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2017-03-03"),INTERVIEW_TIME_OF_VIEW, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_VIEW ="view.version";
	protected void checkVersionOfView(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_VIEW, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE ="employee.id";
	protected void checkIdOfEmployee(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_EMPLOYEE ="employee.company";
	protected void checkCompanyIdOfEmployee(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfEmployee(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_EMPLOYEE ="employee.title";
	protected void checkTitleOfEmployee(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 12,TITLE_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  DEPARTMENT_OF_EMPLOYEE ="employee.department";
	protected void checkDepartmentIdOfEmployee(RetailscmUserContext userContext, String departmentId, List<Message> messageList)
	{
		
	 	checkIdOfEmployee(userContext,departmentId, messageList); 		
		
	}	 			
	
	public static final String  FAMILY_NAME_OF_EMPLOYEE ="employee.family_name";
	protected void checkFamilyNameOfEmployee(RetailscmUserContext userContext, String familyName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(familyName,0, 4,FAMILY_NAME_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  GIVEN_NAME_OF_EMPLOYEE ="employee.given_name";
	protected void checkGivenNameOfEmployee(RetailscmUserContext userContext, String givenName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(givenName,1, 8,GIVEN_NAME_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_EMPLOYEE ="employee.email";
	protected void checkEmailOfEmployee(RetailscmUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkEmail(email,6, 52,EMAIL_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  CITY_OF_EMPLOYEE ="employee.city";
	protected void checkCityOfEmployee(RetailscmUserContext userContext, String city, List<Message> messageList)
	{
		
	 	checkStringLengthRange(city,1, 8,CITY_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  ADDRESS_OF_EMPLOYEE ="employee.address";
	protected void checkAddressOfEmployee(RetailscmUserContext userContext, String address, List<Message> messageList)
	{
		
	 	checkStringLengthRange(address,2, 28,ADDRESS_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  CELL_PHONE_OF_EMPLOYEE ="employee.cell_phone";
	protected void checkCellPhoneOfEmployee(RetailscmUserContext userContext, String cellPhone, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(cellPhone,5, 44,CELL_PHONE_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  OCCUPATION_OF_EMPLOYEE ="employee.occupation";
	protected void checkOccupationIdOfEmployee(RetailscmUserContext userContext, String occupationId, List<Message> messageList)
	{
		
	 	checkIdOfEmployee(userContext,occupationId, messageList); 		
		
	}	 			
	
	public static final String  RESPONSIBLE_FOR_OF_EMPLOYEE ="employee.responsible_for";
	protected void checkResponsibleForIdOfEmployee(RetailscmUserContext userContext, String responsibleForId, List<Message> messageList)
	{
		
	 	checkIdOfEmployee(userContext,responsibleForId, messageList); 		
		
	}	 			
	
	public static final String  CURRENT_SALARY_GRADE_OF_EMPLOYEE ="employee.current_salary_grade";
	protected void checkCurrentSalaryGradeIdOfEmployee(RetailscmUserContext userContext, String currentSalaryGradeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployee(userContext,currentSalaryGradeId, messageList); 		
		
	}	 			
	
	public static final String  SALARY_ACCOUNT_OF_EMPLOYEE ="employee.salary_account";
	protected void checkSalaryAccountOfEmployee(RetailscmUserContext userContext, String salaryAccount, List<Message> messageList)
	{
		
	 	checkStringLengthRange(salaryAccount,4, 60,SALARY_ACCOUNT_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE ="employee.version";
	protected void checkVersionOfEmployee(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_JOB_APPLICATION ="job_application.id";
	protected void checkIdOfJobApplication(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_JOB_APPLICATION, messageList); 		
		
	}	 			
	
	public static final String  APPLICATION_TIME_OF_JOB_APPLICATION ="job_application.application_time";
	protected void checkApplicationTimeOfJobApplication(RetailscmUserContext userContext, Date applicationTime, List<Message> messageList)
	{
		
	 	checkDateRange(applicationTime,parseDate("1900-01-01"), parseDate("2018-03-04"),APPLICATION_TIME_OF_JOB_APPLICATION, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_JOB_APPLICATION ="job_application.who";
	protected void checkWhoOfJobApplication(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 20,WHO_OF_JOB_APPLICATION, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_JOB_APPLICATION ="job_application.comments";
	protected void checkCommentsOfJobApplication(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,8, 124,COMMENTS_OF_JOB_APPLICATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_JOB_APPLICATION ="job_application.version";
	protected void checkVersionOfJobApplication(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_JOB_APPLICATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PROFESSION_INTERVIEW ="profession_interview.id";
	protected void checkIdOfProfessionInterview(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFESSION_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_PROFESSION_INTERVIEW ="profession_interview.who";
	protected void checkWhoOfProfessionInterview(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_PROFESSION_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  INTERVIEW_TIME_OF_PROFESSION_INTERVIEW ="profession_interview.interview_time";
	protected void checkInterviewTimeOfProfessionInterview(RetailscmUserContext userContext, Date interviewTime, List<Message> messageList)
	{
		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2018-03-04"),INTERVIEW_TIME_OF_PROFESSION_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_PROFESSION_INTERVIEW ="profession_interview.comments";
	protected void checkCommentsOfProfessionInterview(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_PROFESSION_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PROFESSION_INTERVIEW ="profession_interview.version";
	protected void checkVersionOfProfessionInterview(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFESSION_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_HR_INTERVIEW ="hr_interview.id";
	protected void checkIdOfHrInterview(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_HR_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_HR_INTERVIEW ="hr_interview.who";
	protected void checkWhoOfHrInterview(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 20,WHO_OF_HR_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  INTERVIEW_TIME_OF_HR_INTERVIEW ="hr_interview.interview_time";
	protected void checkInterviewTimeOfHrInterview(RetailscmUserContext userContext, Date interviewTime, List<Message> messageList)
	{
		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2018-03-04"),INTERVIEW_TIME_OF_HR_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_HR_INTERVIEW ="hr_interview.comments";
	protected void checkCommentsOfHrInterview(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,4, 52,COMMENTS_OF_HR_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_HR_INTERVIEW ="hr_interview.version";
	protected void checkVersionOfHrInterview(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_HR_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OFFER_APPROVAL ="offer_approval.id";
	protected void checkIdOfOfferApproval(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OFFER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_OFFER_APPROVAL ="offer_approval.who";
	protected void checkWhoOfOfferApproval(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_OFFER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  APPROVE_TIME_OF_OFFER_APPROVAL ="offer_approval.approve_time";
	protected void checkApproveTimeOfOfferApproval(RetailscmUserContext userContext, Date approveTime, List<Message> messageList)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-03-04"),APPROVE_TIME_OF_OFFER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_OFFER_APPROVAL ="offer_approval.comments";
	protected void checkCommentsOfOfferApproval(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,3, 40,COMMENTS_OF_OFFER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OFFER_APPROVAL ="offer_approval.version";
	protected void checkVersionOfOfferApproval(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OFFER_APPROVAL, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OFFER_ACCEPTANCE ="offer_acceptance.id";
	protected void checkIdOfOfferAcceptance(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OFFER_ACCEPTANCE, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_OFFER_ACCEPTANCE ="offer_acceptance.who";
	protected void checkWhoOfOfferAcceptance(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_OFFER_ACCEPTANCE, messageList); 		
		
	}	 			
	
	public static final String  ACCEPT_TIME_OF_OFFER_ACCEPTANCE ="offer_acceptance.accept_time";
	protected void checkAcceptTimeOfOfferAcceptance(RetailscmUserContext userContext, Date acceptTime, List<Message> messageList)
	{
		
	 	checkDateRange(acceptTime,parseDate("1900-01-01"), parseDate("2018-03-04"),ACCEPT_TIME_OF_OFFER_ACCEPTANCE, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_OFFER_ACCEPTANCE ="offer_acceptance.comments";
	protected void checkCommentsOfOfferAcceptance(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,3, 40,COMMENTS_OF_OFFER_ACCEPTANCE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OFFER_ACCEPTANCE ="offer_acceptance.version";
	protected void checkVersionOfOfferAcceptance(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OFFER_ACCEPTANCE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_BOARDING ="employee_boarding.id";
	protected void checkIdOfEmployeeBoarding(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_BOARDING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_EMPLOYEE_BOARDING ="employee_boarding.who";
	protected void checkWhoOfEmployeeBoarding(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,2, 20,WHO_OF_EMPLOYEE_BOARDING, messageList); 		
		
	}	 			
	
	public static final String  EMPLOY_TIME_OF_EMPLOYEE_BOARDING ="employee_boarding.employ_time";
	protected void checkEmployTimeOfEmployeeBoarding(RetailscmUserContext userContext, Date employTime, List<Message> messageList)
	{
		
	 	checkDateRange(employTime,parseDate("1900-01-01"), parseDate("2018-03-04"),EMPLOY_TIME_OF_EMPLOYEE_BOARDING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_EMPLOYEE_BOARDING ="employee_boarding.comments";
	protected void checkCommentsOfEmployeeBoarding(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,3, 44,COMMENTS_OF_EMPLOYEE_BOARDING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_BOARDING ="employee_boarding.version";
	protected void checkVersionOfEmployeeBoarding(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_BOARDING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_INSTRUCTOR ="instructor.id";
	protected void checkIdOfInstructor(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_INSTRUCTOR ="instructor.title";
	protected void checkTitleOfInstructor(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  FAMILY_NAME_OF_INSTRUCTOR ="instructor.family_name";
	protected void checkFamilyNameOfInstructor(RetailscmUserContext userContext, String familyName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(familyName,0, 4,FAMILY_NAME_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  GIVEN_NAME_OF_INSTRUCTOR ="instructor.given_name";
	protected void checkGivenNameOfInstructor(RetailscmUserContext userContext, String givenName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(givenName,1, 8,GIVEN_NAME_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  CELL_PHONE_OF_INSTRUCTOR ="instructor.cell_phone";
	protected void checkCellPhoneOfInstructor(RetailscmUserContext userContext, String cellPhone, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(cellPhone,5, 44,CELL_PHONE_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_INSTRUCTOR ="instructor.email";
	protected void checkEmailOfInstructor(RetailscmUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkEmail(email,10, 80,EMAIL_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_INSTRUCTOR ="instructor.company";
	protected void checkCompanyIdOfInstructor(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfInstructor(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  INTRODUCTION_OF_INSTRUCTOR ="instructor.introduction";
	protected void checkIntroductionOfInstructor(RetailscmUserContext userContext, String introduction, List<Message> messageList)
	{
		
	 	checkStringLengthRange(introduction,4, 60,INTRODUCTION_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_INSTRUCTOR ="instructor.version";
	protected void checkVersionOfInstructor(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_INSTRUCTOR, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_COMPANY_TRAINING ="company_training.id";
	protected void checkIdOfCompanyTraining(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_COMPANY_TRAINING, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_COMPANY_TRAINING ="company_training.title";
	protected void checkTitleOfCompanyTraining(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_COMPANY_TRAINING, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_COMPANY_TRAINING ="company_training.company";
	protected void checkCompanyIdOfCompanyTraining(RetailscmUserContext userContext, String companyId, List<Message> messageList)
	{
		
	 	checkIdOfCompanyTraining(userContext,companyId, messageList); 		
		
	}	 			
	
	public static final String  INSTRUCTOR_OF_COMPANY_TRAINING ="company_training.instructor";
	protected void checkInstructorIdOfCompanyTraining(RetailscmUserContext userContext, String instructorId, List<Message> messageList)
	{
		
	 	checkIdOfCompanyTraining(userContext,instructorId, messageList); 		
		
	}	 			
	
	public static final String  TRAINING_COURSE_TYPE_OF_COMPANY_TRAINING ="company_training.training_course_type";
	protected void checkTrainingCourseTypeIdOfCompanyTraining(RetailscmUserContext userContext, String trainingCourseTypeId, List<Message> messageList)
	{
		
	 	checkIdOfCompanyTraining(userContext,trainingCourseTypeId, messageList); 		
		
	}	 			
	
	public static final String  TIME_START_OF_COMPANY_TRAINING ="company_training.time_start";
	protected void checkTimeStartOfCompanyTraining(RetailscmUserContext userContext, Date timeStart, List<Message> messageList)
	{
		
	 	checkDatePast(timeStart,parseDate("1900-01-01"), new Date(),TIME_START_OF_COMPANY_TRAINING, messageList); 		
		
	}	 			
	
	public static final String  DURATION_HOURS_OF_COMPANY_TRAINING ="company_training.duration_hours";
	protected void checkDurationHoursOfCompanyTraining(RetailscmUserContext userContext, int durationHours, List<Message> messageList)
	{
		
	 	checkIntegerRange(durationHours,0, 3,DURATION_HOURS_OF_COMPANY_TRAINING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_COMPANY_TRAINING ="company_training.version";
	protected void checkVersionOfCompanyTraining(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_COMPANY_TRAINING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SCORING ="scoring.id";
	protected void checkIdOfScoring(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SCORING, messageList); 		
		
	}	 			
	
	public static final String  SCORED_BY_OF_SCORING ="scoring.scored_by";
	protected void checkScoredByOfScoring(RetailscmUserContext userContext, String scoredBy, List<Message> messageList)
	{
		
	 	checkStringLengthRange(scoredBy,1, 12,SCORED_BY_OF_SCORING, messageList); 		
		
	}	 			
	
	public static final String  SCORE_OF_SCORING ="scoring.score";
	protected void checkScoreOfScoring(RetailscmUserContext userContext, int score, List<Message> messageList)
	{
		
	 	checkIntegerRange(score,0, 100,SCORE_OF_SCORING, messageList); 		
		
	}	 			
	
	public static final String  COMMENT_OF_SCORING ="scoring.comment";
	protected void checkCommentOfScoring(RetailscmUserContext userContext, String comment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comment,3, 36,COMMENT_OF_SCORING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SCORING ="scoring.version";
	protected void checkVersionOfScoring(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SCORING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.id";
	protected void checkIdOfEmployeeCompanyTraining(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_COMPANY_TRAINING, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.employee";
	protected void checkEmployeeIdOfEmployeeCompanyTraining(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeCompanyTraining(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  TRAINING_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.training";
	protected void checkTrainingIdOfEmployeeCompanyTraining(RetailscmUserContext userContext, String trainingId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeCompanyTraining(userContext,trainingId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.version";
	protected void checkVersionOfEmployeeCompanyTraining(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_COMPANY_TRAINING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_SKILL ="employee_skill.id";
	protected void checkIdOfEmployeeSkill(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_SKILL, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_SKILL ="employee_skill.employee";
	protected void checkEmployeeIdOfEmployeeSkill(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeSkill(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  SKILL_TYPE_OF_EMPLOYEE_SKILL ="employee_skill.skill_type";
	protected void checkSkillTypeIdOfEmployeeSkill(RetailscmUserContext userContext, String skillTypeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeSkill(userContext,skillTypeId, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_EMPLOYEE_SKILL ="employee_skill.description";
	protected void checkDescriptionOfEmployeeSkill(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 28,DESCRIPTION_OF_EMPLOYEE_SKILL, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_SKILL ="employee_skill.version";
	protected void checkVersionOfEmployeeSkill(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_SKILL, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_PERFORMANCE ="employee_performance.id";
	protected void checkIdOfEmployeePerformance(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_PERFORMANCE, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_PERFORMANCE ="employee_performance.employee";
	protected void checkEmployeeIdOfEmployeePerformance(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeePerformance(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE ="employee_performance.performance_comment";
	protected void checkPerformanceCommentOfEmployeePerformance(RetailscmUserContext userContext, String performanceComment, List<Message> messageList)
	{
		
	 	checkStringLengthRange(performanceComment,2, 28,PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_PERFORMANCE ="employee_performance.version";
	protected void checkVersionOfEmployeePerformance(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_PERFORMANCE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.id";
	protected void checkIdOfEmployeeWorkExperience(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_WORK_EXPERIENCE, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.employee";
	protected void checkEmployeeIdOfEmployeeWorkExperience(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeWorkExperience(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  START_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.start";
	protected void checkStartOfEmployeeWorkExperience(RetailscmUserContext userContext, Date start, List<Message> messageList)
	{
		
	 	checkDateRange(start,parseDate("1900-01-01"), parseDate("2008-01-10"),START_OF_EMPLOYEE_WORK_EXPERIENCE, messageList); 		
		
	}	 			
	
	public static final String  END_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.end";
	protected void checkEndOfEmployeeWorkExperience(RetailscmUserContext userContext, Date end, List<Message> messageList)
	{
		
	 	checkDateRange(end,parseDate("1900-01-01"), parseDate("2018-01-10"),END_OF_EMPLOYEE_WORK_EXPERIENCE, messageList); 		
		
	}	 			
	
	public static final String  COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.company";
	protected void checkCompanyOfEmployeeWorkExperience(RetailscmUserContext userContext, String company, List<Message> messageList)
	{
		
	 	checkStringLengthRange(company,3, 32,COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.description";
	protected void checkDescriptionOfEmployeeWorkExperience(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,6, 84,DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.version";
	protected void checkVersionOfEmployeeWorkExperience(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_WORK_EXPERIENCE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_LEAVE ="employee_leave.id";
	protected void checkIdOfEmployeeLeave(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_LEAVE, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_EMPLOYEE_LEAVE ="employee_leave.who";
	protected void checkWhoIdOfEmployeeLeave(RetailscmUserContext userContext, String whoId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeLeave(userContext,whoId, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_EMPLOYEE_LEAVE ="employee_leave.type";
	protected void checkTypeIdOfEmployeeLeave(RetailscmUserContext userContext, String typeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeLeave(userContext,typeId, messageList); 		
		
	}	 			
	
	public static final String  LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE ="employee_leave.leave_duration_hour";
	protected void checkLeaveDurationHourOfEmployeeLeave(RetailscmUserContext userContext, int leaveDurationHour, List<Message> messageList)
	{
		
	 	checkIntegerRange(leaveDurationHour,0, 8,LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EMPLOYEE_LEAVE ="employee_leave.remark";
	protected void checkRemarkOfEmployeeLeave(RetailscmUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,3, 44,REMARK_OF_EMPLOYEE_LEAVE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_LEAVE ="employee_leave.version";
	protected void checkVersionOfEmployeeLeave(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_LEAVE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_INTERVIEW ="employee_interview.id";
	protected void checkIdOfEmployeeInterview(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_INTERVIEW ="employee_interview.employee";
	protected void checkEmployeeIdOfEmployeeInterview(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeInterview(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  INTERVIEW_TYPE_OF_EMPLOYEE_INTERVIEW ="employee_interview.interview_type";
	protected void checkInterviewTypeIdOfEmployeeInterview(RetailscmUserContext userContext, String interviewTypeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeInterview(userContext,interviewTypeId, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EMPLOYEE_INTERVIEW ="employee_interview.remark";
	protected void checkRemarkOfEmployeeInterview(RetailscmUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,3, 40,REMARK_OF_EMPLOYEE_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_INTERVIEW ="employee_interview.version";
	protected void checkVersionOfEmployeeInterview(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_INTERVIEW, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.id";
	protected void checkIdOfEmployeeAttendance(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.employee";
	protected void checkEmployeeIdOfEmployeeAttendance(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeAttendance(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  ENTER_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.enter_time";
	protected void checkEnterTimeOfEmployeeAttendance(RetailscmUserContext userContext, Date enterTime, List<Message> messageList)
	{
		
	 	checkDateRange(enterTime,parseDate("1900-01-01"), parseDate("2017-01-01"),ENTER_TIME_OF_EMPLOYEE_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.leave_time";
	protected void checkLeaveTimeOfEmployeeAttendance(RetailscmUserContext userContext, Date leaveTime, List<Message> messageList)
	{
		
	 	checkDateRange(leaveTime,parseDate("1900-01-01"), parseDate("2017-03-01"),LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.duration_hours";
	protected void checkDurationHoursOfEmployeeAttendance(RetailscmUserContext userContext, int durationHours, List<Message> messageList)
	{
		
	 	checkIntegerRange(durationHours,0, 8,DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.remark";
	protected void checkRemarkOfEmployeeAttendance(RetailscmUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,2, 28,REMARK_OF_EMPLOYEE_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.version";
	protected void checkVersionOfEmployeeAttendance(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_ATTENDANCE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.id";
	protected void checkIdOfEmployeeQualifier(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_QUALIFIER, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.employee";
	protected void checkEmployeeIdOfEmployeeQualifier(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeQualifier(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.qualified_time";
	protected void checkQualifiedTimeOfEmployeeQualifier(RetailscmUserContext userContext, Date qualifiedTime, List<Message> messageList)
	{
		
	 	checkDateRange(qualifiedTime,parseDate("1900-01-01"), parseDate("2017-01-01"),QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.type";
	protected void checkTypeOfEmployeeQualifier(RetailscmUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 20,TYPE_OF_EMPLOYEE_QUALIFIER, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.level";
	protected void checkLevelOfEmployeeQualifier(RetailscmUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,1, 8,LEVEL_OF_EMPLOYEE_QUALIFIER, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.remark";
	protected void checkRemarkOfEmployeeQualifier(RetailscmUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_QUALIFIER, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.version";
	protected void checkVersionOfEmployeeQualifier(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_QUALIFIER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_EDUCATION ="employee_education.id";
	protected void checkIdOfEmployeeEducation(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_EDUCATION, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_EDUCATION ="employee_education.employee";
	protected void checkEmployeeIdOfEmployeeEducation(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeEducation(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  COMPLETE_TIME_OF_EMPLOYEE_EDUCATION ="employee_education.complete_time";
	protected void checkCompleteTimeOfEmployeeEducation(RetailscmUserContext userContext, Date completeTime, List<Message> messageList)
	{
		
	 	checkDateRange(completeTime,parseDate("1900-01-01"), parseDate("2017-01-01"),COMPLETE_TIME_OF_EMPLOYEE_EDUCATION, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_EMPLOYEE_EDUCATION ="employee_education.type";
	protected void checkTypeOfEmployeeEducation(RetailscmUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 16,TYPE_OF_EMPLOYEE_EDUCATION, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EMPLOYEE_EDUCATION ="employee_education.remark";
	protected void checkRemarkOfEmployeeEducation(RetailscmUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_EDUCATION, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_EDUCATION ="employee_education.version";
	protected void checkVersionOfEmployeeEducation(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_EDUCATION, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_AWARD ="employee_award.id";
	protected void checkIdOfEmployeeAward(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_AWARD, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_AWARD ="employee_award.employee";
	protected void checkEmployeeIdOfEmployeeAward(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeAward(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  COMPLETE_TIME_OF_EMPLOYEE_AWARD ="employee_award.complete_time";
	protected void checkCompleteTimeOfEmployeeAward(RetailscmUserContext userContext, Date completeTime, List<Message> messageList)
	{
		
	 	checkDateRange(completeTime,parseDate("1900-01-01"), parseDate("2017-01-01"),COMPLETE_TIME_OF_EMPLOYEE_AWARD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_EMPLOYEE_AWARD ="employee_award.type";
	protected void checkTypeOfEmployeeAward(RetailscmUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,2, 20,TYPE_OF_EMPLOYEE_AWARD, messageList); 		
		
	}	 			
	
	public static final String  REMARK_OF_EMPLOYEE_AWARD ="employee_award.remark";
	protected void checkRemarkOfEmployeeAward(RetailscmUserContext userContext, String remark, List<Message> messageList)
	{
		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_AWARD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_AWARD ="employee_award.version";
	protected void checkVersionOfEmployeeAward(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_AWARD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.id";
	protected void checkIdOfEmployeeSalarySheet(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  EMPLOYEE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.employee";
	protected void checkEmployeeIdOfEmployeeSalarySheet(RetailscmUserContext userContext, String employeeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeSalarySheet(userContext,employeeId, messageList); 		
		
	}	 			
	
	public static final String  CURRENT_SALARY_GRADE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.current_salary_grade";
	protected void checkCurrentSalaryGradeIdOfEmployeeSalarySheet(RetailscmUserContext userContext, String currentSalaryGradeId, List<Message> messageList)
	{
		
	 	checkIdOfEmployeeSalarySheet(userContext,currentSalaryGradeId, messageList); 		
		
	}	 			
	
	public static final String  BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.base_salary";
	protected void checkBaseSalaryOfEmployeeSalarySheet(RetailscmUserContext userContext, BigDecimal baseSalary, List<Message> messageList)
	{
		
	 	checkMoneyAmount(baseSalary,0.00, 3000.10,BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  BONUS_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.bonus";
	protected void checkBonusOfEmployeeSalarySheet(RetailscmUserContext userContext, BigDecimal bonus, List<Message> messageList)
	{
		
	 	checkMoneyAmount(bonus,0.00, 1000.10,BONUS_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  REWARD_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.reward";
	protected void checkRewardOfEmployeeSalarySheet(RetailscmUserContext userContext, BigDecimal reward, List<Message> messageList)
	{
		
	 	checkMoneyAmount(reward,0.00, 1000.10,REWARD_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.personal_tax";
	protected void checkPersonalTaxOfEmployeeSalarySheet(RetailscmUserContext userContext, BigDecimal personalTax, List<Message> messageList)
	{
		
	 	checkMoneyAmount(personalTax,0.00, 792.88,PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.social_security";
	protected void checkSocialSecurityOfEmployeeSalarySheet(RetailscmUserContext userContext, BigDecimal socialSecurity, List<Message> messageList)
	{
		
	 	checkMoneyAmount(socialSecurity,0.00, 1100.22,SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.housing_found";
	protected void checkHousingFoundOfEmployeeSalarySheet(RetailscmUserContext userContext, BigDecimal housingFound, List<Message> messageList)
	{
		
	 	checkMoneyAmount(housingFound,0.00, 1222.99,HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.job_insurance";
	protected void checkJobInsuranceOfEmployeeSalarySheet(RetailscmUserContext userContext, BigDecimal jobInsurance, List<Message> messageList)
	{
		
	 	checkMoneyAmount(jobInsurance,0.00, 8.88,JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.version";
	protected void checkVersionOfEmployeeSalarySheet(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_SALARY_SHEET, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_PAYING_OFF ="paying_off.id";
	protected void checkIdOfPayingOff(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYING_OFF, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_PAYING_OFF ="paying_off.who";
	protected void checkWhoOfPayingOff(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,1, 8,WHO_OF_PAYING_OFF, messageList); 		
		
	}	 			
	
	public static final String  PAID_FOR_OF_PAYING_OFF ="paying_off.paid_for";
	protected void checkPaidForIdOfPayingOff(RetailscmUserContext userContext, String paidForId, List<Message> messageList)
	{
		
	 	checkIdOfPayingOff(userContext,paidForId, messageList); 		
		
	}	 			
	
	public static final String  PAID_TIME_OF_PAYING_OFF ="paying_off.paid_time";
	protected void checkPaidTimeOfPayingOff(RetailscmUserContext userContext, Date paidTime, List<Message> messageList)
	{
		
	 	checkDateRange(paidTime,parseDate("1900-01-01"), parseDate("2018-01-19"),PAID_TIME_OF_PAYING_OFF, messageList); 		
		
	}	 			
	
	public static final String  AMOUNT_OF_PAYING_OFF ="paying_off.amount";
	protected void checkAmountOfPayingOff(RetailscmUserContext userContext, BigDecimal amount, List<Message> messageList)
	{
		
	 	checkMoneyAmount(amount,0.00, 5223.88,AMOUNT_OF_PAYING_OFF, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_PAYING_OFF ="paying_off.version";
	protected void checkVersionOfPayingOff(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYING_OFF, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	protected void checkIdOfUserDomain(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	protected void checkNameOfUserDomain(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	protected void checkVersionOfUserDomain(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	protected void checkIdOfUserWhiteList(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	protected void checkUserIdentityOfUserWhiteList(RetailscmUserContext userContext, String userIdentity, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	protected void checkUserSpecialFunctionsOfUserWhiteList(RetailscmUserContext userContext, String userSpecialFunctions, List<Message> messageList)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	protected void checkDomainIdOfUserWhiteList(RetailscmUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfUserWhiteList(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	protected void checkVersionOfUserWhiteList(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER ="sec_user.id";
	protected void checkIdOfSecUser(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	protected void checkLoginOfSecUser(RetailscmUserContext userContext, String login, List<Message> messageList)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	protected void checkMobileOfSecUser(RetailscmUserContext userContext, String mobile, List<Message> messageList)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	protected void checkEmailOfSecUser(RetailscmUserContext userContext, String email, List<Message> messageList)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	protected void checkPwdOfSecUser(RetailscmUserContext userContext, String pwd, List<Message> messageList)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	protected void checkVerificationCodeOfSecUser(RetailscmUserContext userContext, int verificationCode, List<Message> messageList)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	protected void checkVerificationCodeExpireOfSecUser(RetailscmUserContext userContext, DateTime verificationCodeExpire, List<Message> messageList)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	protected void checkLastLoginTimeOfSecUser(RetailscmUserContext userContext, DateTime lastLoginTime, List<Message> messageList)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	protected void checkDomainIdOfSecUser(RetailscmUserContext userContext, String domainId, List<Message> messageList)
	{
		
	 	checkIdOfSecUser(userContext,domainId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	protected void checkVersionOfSecUser(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	protected void checkIdOfSecUserBlocking(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	protected void checkWhoOfSecUserBlocking(RetailscmUserContext userContext, String who, List<Message> messageList)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	protected void checkCommentsOfSecUserBlocking(RetailscmUserContext userContext, String comments, List<Message> messageList)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	protected void checkVersionOfSecUserBlocking(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_USER_APP ="user_app.id";
	protected void checkIdOfUserApp(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_USER_APP ="user_app.title";
	protected void checkTitleOfUserApp(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	protected void checkSecUserIdOfUserApp(RetailscmUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfUserApp(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	protected void checkAppIconOfUserApp(RetailscmUserContext userContext, String appIcon, List<Message> messageList)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	protected void checkFullAccessOfUserApp(RetailscmUserContext userContext, boolean fullAccess, List<Message> messageList)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	protected void checkPermissionOfUserApp(RetailscmUserContext userContext, String permission, List<Message> messageList)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	protected void checkObjectTypeOfUserApp(RetailscmUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	protected void checkObjectIdOfUserApp(RetailscmUserContext userContext, String objectId, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	protected void checkLocationOfUserApp(RetailscmUserContext userContext, String location, List<Message> messageList)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_USER_APP ="user_app.version";
	protected void checkVersionOfUserApp(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	protected void checkIdOfListAccess(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	protected void checkNameOfListAccess(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	protected void checkInternalNameOfListAccess(RetailscmUserContext userContext, String internalName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	protected void checkReadPermissionOfListAccess(RetailscmUserContext userContext, boolean readPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	protected void checkCreatePermissionOfListAccess(RetailscmUserContext userContext, boolean createPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	protected void checkDeletePermissionOfListAccess(RetailscmUserContext userContext, boolean deletePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	protected void checkUpdatePermissionOfListAccess(RetailscmUserContext userContext, boolean updatePermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	protected void checkExecutionPermissionOfListAccess(RetailscmUserContext userContext, boolean executionPermission, List<Message> messageList)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	protected void checkAppIdOfListAccess(RetailscmUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfListAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	protected void checkVersionOfListAccess(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	protected void checkIdOfObjectAccess(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	protected void checkNameOfObjectAccess(RetailscmUserContext userContext, String name, List<Message> messageList)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	protected void checkObjectTypeOfObjectAccess(RetailscmUserContext userContext, String objectType, List<Message> messageList)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	protected void checkList1OfObjectAccess(RetailscmUserContext userContext, String list1, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	protected void checkList2OfObjectAccess(RetailscmUserContext userContext, String list2, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	protected void checkList3OfObjectAccess(RetailscmUserContext userContext, String list3, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	protected void checkList4OfObjectAccess(RetailscmUserContext userContext, String list4, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	protected void checkList5OfObjectAccess(RetailscmUserContext userContext, String list5, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	protected void checkList6OfObjectAccess(RetailscmUserContext userContext, String list6, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	protected void checkList7OfObjectAccess(RetailscmUserContext userContext, String list7, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	protected void checkList8OfObjectAccess(RetailscmUserContext userContext, String list8, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	protected void checkList9OfObjectAccess(RetailscmUserContext userContext, String list9, List<Message> messageList)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	protected void checkAppIdOfObjectAccess(RetailscmUserContext userContext, String appId, List<Message> messageList)
	{
		
	 	checkIdOfObjectAccess(userContext,appId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	protected void checkVersionOfObjectAccess(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	protected void checkIdOfLoginHistory(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	protected void checkFromIpOfLoginHistory(RetailscmUserContext userContext, String fromIp, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	protected void checkDescriptionOfLoginHistory(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	protected void checkSecUserIdOfLoginHistory(RetailscmUserContext userContext, String secUserId, List<Message> messageList)
	{
		
	 	checkIdOfLoginHistory(userContext,secUserId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	protected void checkVersionOfLoginHistory(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	protected void checkIdOfGenericForm(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	protected void checkTitleOfGenericForm(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	protected void checkDescriptionOfGenericForm(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	protected void checkVersionOfGenericForm(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	protected void checkIdOfFormMessage(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	protected void checkTitleOfFormMessage(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	protected void checkFormIdOfFormMessage(RetailscmUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	protected void checkLevelOfFormMessage(RetailscmUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	protected void checkVersionOfFormMessage(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	protected void checkIdOfFormFieldMessage(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	protected void checkTitleOfFormFieldMessage(RetailscmUserContext userContext, String title, List<Message> messageList)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	protected void checkParameterNameOfFormFieldMessage(RetailscmUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	protected void checkFormIdOfFormFieldMessage(RetailscmUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormFieldMessage(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	protected void checkLevelOfFormFieldMessage(RetailscmUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	protected void checkVersionOfFormFieldMessage(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	protected void checkIdOfFormField(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	protected void checkLabelOfFormField(RetailscmUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	protected void checkLocaleKeyOfFormField(RetailscmUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	protected void checkParameterNameOfFormField(RetailscmUserContext userContext, String parameterName, List<Message> messageList)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	protected void checkTypeOfFormField(RetailscmUserContext userContext, String type, List<Message> messageList)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	protected void checkFormIdOfFormField(RetailscmUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormField(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	protected void checkPlaceholderOfFormField(RetailscmUserContext userContext, String placeholder, List<Message> messageList)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	protected void checkDefaultValueOfFormField(RetailscmUserContext userContext, String defaultValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	protected void checkDescriptionOfFormField(RetailscmUserContext userContext, String description, List<Message> messageList)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	protected void checkFieldGroupOfFormField(RetailscmUserContext userContext, String fieldGroup, List<Message> messageList)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	protected void checkMinimumValueOfFormField(RetailscmUserContext userContext, String minimumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	protected void checkMaximumValueOfFormField(RetailscmUserContext userContext, String maximumValue, List<Message> messageList)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	protected void checkRequiredOfFormField(RetailscmUserContext userContext, boolean required, List<Message> messageList)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	protected void checkDisabledOfFormField(RetailscmUserContext userContext, boolean disabled, List<Message> messageList)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	protected void checkCustomRenderingOfFormField(RetailscmUserContext userContext, boolean customRendering, List<Message> messageList)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	protected void checkCandidateValuesOfFormField(RetailscmUserContext userContext, String candidateValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	protected void checkSuggestValuesOfFormField(RetailscmUserContext userContext, String suggestValues, List<Message> messageList)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	protected void checkVersionOfFormField(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD, messageList); 		
		
	}	 			
	
	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	protected void checkIdOfFormAction(RetailscmUserContext userContext, String id, List<Message> messageList)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	protected void checkLabelOfFormAction(RetailscmUserContext userContext, String label, List<Message> messageList)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	protected void checkLocaleKeyOfFormAction(RetailscmUserContext userContext, String localeKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	protected void checkActionKeyOfFormAction(RetailscmUserContext userContext, String actionKey, List<Message> messageList)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	protected void checkLevelOfFormAction(RetailscmUserContext userContext, String level, List<Message> messageList)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	protected void checkUrlOfFormAction(RetailscmUserContext userContext, String url, List<Message> messageList)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION, messageList); 		
		
	}	 			
	
	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	protected void checkFormIdOfFormAction(RetailscmUserContext userContext, String formId, List<Message> messageList)
	{
		
	 	checkIdOfFormAction(userContext,formId, messageList); 		
		
	}	 			
	
	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	protected void checkVersionOfFormAction(RetailscmUserContext userContext, int version, List<Message> messageList)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION, messageList); 		
		
	}	 			public Object checkAccess(BaseUserContext baseUserContext,String methodName, Object[] parameters) throws IllegalAccessException{
		if (!(baseUserContext instanceof RetailscmUserContext)){
			super.checkAccess(baseUserContext, methodName, parameters);
			return accessOK();
		}
		RetailscmUserContext userContext = (RetailscmUserContext) baseUserContext;
		if (userContext.getCustomCheckManager() != null && this != userContext.getCustomCheckManager()){
			userContext.getCustomCheckManager().checkAccess(userContext, methodName, parameters);
			return accessOK();
		}
		return super.checkAccess(userContext, methodName, parameters);
	}
	
	protected void throwExceptionIfHasErrors(RetailscmUserContext userContext, List<Message> messageList, Class<? extends RetailscmException> exceptionClazz) throws Exception{
		//translate messages;
		if(messageList.isEmpty()){
			return;
		}
		
		
		for(Message message: messageList){
			String subject = message.getSubject();
			String template = userContext.getLocaleKey(subject);
			if(template==null){
				//not found, it is fine to use hard coded value
				userContext.log("Check Result "+message.getBody());
				continue;
			}
			MessageFormat mf = new MessageFormat(template);
			
			String labelKey = message.getFirstParam();
			String newLabel = userContext.getLocaleKey(labelKey);
			message.setFirstParam(newLabel);
			String newBody = mf.format(message.getParameters());
			message.setBody(newBody);
			userContext.log("Check Result "+message.getBody());
			
		}
		
		
		Class [] classes = {List.class};
		throw  exceptionClazz.getDeclaredConstructor(classes).newInstance(messageList);

	}
	*/

	protected void checkGender(String gender, int i, int j,String targetFieldName, List<Message> messageList) {
		
		
	}
	
	//for stub only
	protected void checkDateNow(Date likeTime, int i, Object now,
			String targetFieldName, RetailscmException exception) {
		
		
	}


	protected Object now() {

		return null;
	}
	
	protected boolean isValidIdentifier(String value){
		return hasVisualChar(value);
		
	}
	
	protected boolean hasVisualChar(String value){
		if(value==null){
			return false;
		}
		if(value.isEmpty()){
			return false;
		}
		if(value.trim().isEmpty()){
			return false;
		}
		return true;
		
	}
	protected void checkBigDecimalRange(BigDecimal projectArea, double i, double j, String projectAreaOfProject,
			List<Message> messageList) {
		
	}
    
}











