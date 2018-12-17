package com.doublechaintech.retailscm;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import com.terapico.uccaf.BaseUserContext;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
public class RetailscmChecker extends BaseChecker{
	
	
	protected RetailscmUserContext userContext;
	public RetailscmUserContext getUserContext() {
		return userContext;
	}
	public void setUserContext(RetailscmUserContext userContext) {
		this.userContext = userContext;
	}
	
	public RetailscmChecker() {
		this.messageList = new ArrayList<Message>();
	}

	

	public static final String  ID_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.id";
	public RetailscmChecker checkIdOfRetailStoreCountryCenter(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.name";
	public RetailscmChecker checkNameOfRetailStoreCountryCenter(String name)
	{
		
	 	checkStringLengthRange(name,5, 44,NAME_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.service_number";
	public RetailscmChecker checkServiceNumberOfRetailStoreCountryCenter(String serviceNumber)
	{
		
	 	checkStringLengthRange(serviceNumber,3, 36,SERVICE_NUMBER_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.founded";
	public RetailscmChecker checkFoundedOfRetailStoreCountryCenter(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.web_site";
	public RetailscmChecker checkWebSiteOfRetailStoreCountryCenter(String webSite)
	{
		
	 	checkUrl(webSite,16, 128,WEB_SITE_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.address";
	public RetailscmChecker checkAddressOfRetailStoreCountryCenter(String address)
	{
		
	 	checkStringLengthRange(address,4, 56,ADDRESS_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.operated_by";
	public RetailscmChecker checkOperatedByOfRetailStoreCountryCenter(String operatedBy)
	{
		
	 	checkStringLengthRange(operatedBy,2, 16,OPERATED_BY_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.legal_representative";
	public RetailscmChecker checkLegalRepresentativeOfRetailStoreCountryCenter(String legalRepresentative)
	{
		
	 	checkStringLengthRange(legalRepresentative,1, 12,LEGAL_REPRESENTATIVE_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.description";
	public RetailscmChecker checkDescriptionOfRetailStoreCountryCenter(String description)
	{
		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.version";
	public RetailscmChecker checkVersionOfRetailStoreCountryCenter(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CATALOG ="catalog.id";
	public RetailscmChecker checkIdOfCatalog(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CATALOG ="catalog.name";
	public RetailscmChecker checkNameOfCatalog(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_CATALOG ="catalog.owner";
	public RetailscmChecker checkOwnerIdOfCatalog(String ownerId)
	{
		
	 	checkIdOfCatalog(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CATALOG ="catalog.version";
	public RetailscmChecker checkVersionOfCatalog(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CATALOG ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_ONE_CATEGORY ="level_one_category.id";
	public RetailscmChecker checkIdOfLevelOneCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  CATALOG_OF_LEVEL_ONE_CATEGORY ="level_one_category.catalog";
	public RetailscmChecker checkCatalogIdOfLevelOneCategory(String catalogId)
	{
		
	 	checkIdOfLevelOneCategory(catalogId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_ONE_CATEGORY ="level_one_category.name";
	public RetailscmChecker checkNameOfLevelOneCategory(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_ONE_CATEGORY ="level_one_category.version";
	public RetailscmChecker checkVersionOfLevelOneCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_TWO_CATEGORY ="level_two_category.id";
	public RetailscmChecker checkIdOfLevelTwoCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_LEVEL_TWO_CATEGORY ="level_two_category.parent_category";
	public RetailscmChecker checkParentCategoryIdOfLevelTwoCategory(String parentCategoryId)
	{
		
	 	checkIdOfLevelTwoCategory(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_TWO_CATEGORY ="level_two_category.name";
	public RetailscmChecker checkNameOfLevelTwoCategory(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_TWO_CATEGORY ="level_two_category.version";
	public RetailscmChecker checkVersionOfLevelTwoCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_THREE_CATEGORY ="level_three_category.id";
	public RetailscmChecker checkIdOfLevelThreeCategory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_LEVEL_THREE_CATEGORY ="level_three_category.parent_category";
	public RetailscmChecker checkParentCategoryIdOfLevelThreeCategory(String parentCategoryId)
	{
		
	 	checkIdOfLevelThreeCategory(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_THREE_CATEGORY ="level_three_category.name";
	public RetailscmChecker checkNameOfLevelThreeCategory(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_THREE_CATEGORY ="level_three_category.version";
	public RetailscmChecker checkVersionOfLevelThreeCategory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_THREE_CATEGORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PRODUCT ="product.id";
	public RetailscmChecker checkIdOfProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PRODUCT ="product.name";
	public RetailscmChecker checkNameOfProduct(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PARENT_CATEGORY_OF_PRODUCT ="product.parent_category";
	public RetailscmChecker checkParentCategoryIdOfProduct(String parentCategoryId)
	{
		
	 	checkIdOfProduct(parentCategoryId ); 		
		
		return this;
	}	 			

	public static final String  ORIGIN_OF_PRODUCT ="product.origin";
	public RetailscmChecker checkOriginOfProduct(String origin)
	{
		
	 	checkStringLengthRange(origin,1, 8,ORIGIN_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_PRODUCT ="product.remark";
	public RetailscmChecker checkRemarkOfProduct(String remark)
	{
		
	 	checkStringLengthRange(remark,6, 88,REMARK_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  BRAND_OF_PRODUCT ="product.brand";
	public RetailscmChecker checkBrandOfProduct(String brand)
	{
		
	 	checkStringLengthRange(brand,6, 92,BRAND_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PICTURE_OF_PRODUCT ="product.picture";
	public RetailscmChecker checkPictureOfProduct(String picture)
	{
		
	 	checkImage(picture,0, 512,PICTURE_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PRODUCT ="product.version";
	public RetailscmChecker checkVersionOfProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SKU ="sku.id";
	public RetailscmChecker checkIdOfSku(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SKU ="sku.name";
	public RetailscmChecker checkNameOfSku(String name)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  SIZE_OF_SKU ="sku.size";
	public RetailscmChecker checkSizeOfSku(String size)
	{
		
	 	checkStringLengthRange(size,0, 4,SIZE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_OF_SKU ="sku.product";
	public RetailscmChecker checkProductIdOfSku(String productId)
	{
		
	 	checkIdOfSku(productId ); 		
		
		return this;
	}	 			

	public static final String  BARCODE_OF_SKU ="sku.barcode";
	public RetailscmChecker checkBarcodeOfSku(String barcode)
	{
		
	 	checkStringLengthRange(barcode,4, 52,BARCODE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  PACKAGE_TYPE_OF_SKU ="sku.package_type";
	public RetailscmChecker checkPackageTypeOfSku(String packageType)
	{
		
	 	checkStringLengthRange(packageType,2, 16,PACKAGE_TYPE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  NET_CONTENT_OF_SKU ="sku.net_content";
	public RetailscmChecker checkNetContentOfSku(String netContent)
	{
		
	 	checkStringLengthRange(netContent,6, 92,NET_CONTENT_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  PRICE_OF_SKU ="sku.price";
	public RetailscmChecker checkPriceOfSku(BigDecimal price)
	{
		
	 	checkMoneyAmount(price,0.00, 1323.33,PRICE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  PICTURE_OF_SKU ="sku.picture";
	public RetailscmChecker checkPictureOfSku(String picture)
	{
		
	 	checkImage(picture,0, 512,PICTURE_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SKU ="sku.version";
	public RetailscmChecker checkVersionOfSku(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKU ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.id";
	public RetailscmChecker checkIdOfRetailStoreProvinceCenter(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.name";
	public RetailscmChecker checkNameOfRetailStoreProvinceCenter(String name)
	{
		
	 	checkStringLengthRange(name,5, 44,NAME_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.founded";
	public RetailscmChecker checkFoundedOfRetailStoreProvinceCenter(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  COUNTRY_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.country";
	public RetailscmChecker checkCountryIdOfRetailStoreProvinceCenter(String countryId)
	{
		
	 	checkIdOfRetailStoreProvinceCenter(countryId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_PROVINCE_CENTER ="retail_store_province_center.version";
	public RetailscmChecker checkVersionOfRetailStoreProvinceCenter(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.id";
	public RetailscmChecker checkIdOfProvinceCenterDepartment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.name";
	public RetailscmChecker checkNameOfProvinceCenterDepartment(String name)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.founded";
	public RetailscmChecker checkFoundedOfProvinceCenterDepartment(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  PROVINCE_CENTER_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.province_center";
	public RetailscmChecker checkProvinceCenterIdOfProvinceCenterDepartment(String provinceCenterId)
	{
		
	 	checkIdOfProvinceCenterDepartment(provinceCenterId ); 		
		
		return this;
	}	 			

	public static final String  MANAGER_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.manager";
	public RetailscmChecker checkManagerOfProvinceCenterDepartment(String manager)
	{
		
	 	checkStringLengthRange(manager,1, 12,MANAGER_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PROVINCE_CENTER_DEPARTMENT ="province_center_department.version";
	public RetailscmChecker checkVersionOfProvinceCenterDepartment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.id";
	public RetailscmChecker checkIdOfProvinceCenterEmployee(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.name";
	public RetailscmChecker checkNameOfProvinceCenterEmployee(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.mobile";
	public RetailscmChecker checkMobileOfProvinceCenterEmployee(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.email";
	public RetailscmChecker checkEmailOfProvinceCenterEmployee(String email)
	{
		
	 	checkEmail(email,9, 80,EMAIL_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.founded";
	public RetailscmChecker checkFoundedOfProvinceCenterEmployee(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  DEPARTMENT_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.department";
	public RetailscmChecker checkDepartmentIdOfProvinceCenterEmployee(String departmentId)
	{
		
	 	checkIdOfProvinceCenterEmployee(departmentId ); 		
		
		return this;
	}	 			

	public static final String  PROVINCE_CENTER_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.province_center";
	public RetailscmChecker checkProvinceCenterIdOfProvinceCenterEmployee(String provinceCenterId)
	{
		
	 	checkIdOfProvinceCenterEmployee(provinceCenterId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PROVINCE_CENTER_EMPLOYEE ="province_center_employee.version";
	public RetailscmChecker checkVersionOfProvinceCenterEmployee(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.id";
	public RetailscmChecker checkIdOfRetailStoreCityServiceCenter(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.name";
	public RetailscmChecker checkNameOfRetailStoreCityServiceCenter(String name)
	{
		
	 	checkStringLengthRange(name,4, 36,NAME_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.founded";
	public RetailscmChecker checkFoundedOfRetailStoreCityServiceCenter(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.belongs_to";
	public RetailscmChecker checkBelongsToIdOfRetailStoreCityServiceCenter(String belongsToId)
	{
		
	 	checkIdOfRetailStoreCityServiceCenter(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER ="retail_store_city_service_center.version";
	public RetailscmChecker checkVersionOfRetailStoreCityServiceCenter(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CITY_PARTNER ="city_partner.id";
	public RetailscmChecker checkIdOfCityPartner(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CITY_PARTNER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CITY_PARTNER ="city_partner.name";
	public RetailscmChecker checkNameOfCityPartner(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_CITY_PARTNER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_CITY_PARTNER ="city_partner.mobile";
	public RetailscmChecker checkMobileOfCityPartner(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_PARTNER ); 		
		
		return this;
	}	 			

	public static final String  CITY_SERVICE_CENTER_OF_CITY_PARTNER ="city_partner.city_service_center";
	public RetailscmChecker checkCityServiceCenterIdOfCityPartner(String cityServiceCenterId)
	{
		
	 	checkIdOfCityPartner(cityServiceCenterId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_CITY_PARTNER ="city_partner.description";
	public RetailscmChecker checkDescriptionOfCityPartner(String description)
	{
		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_CITY_PARTNER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CITY_PARTNER ="city_partner.version";
	public RetailscmChecker checkVersionOfCityPartner(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_PARTNER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_POTENTIAL_CUSTOMER ="potential_customer.id";
	public RetailscmChecker checkIdOfPotentialCustomer(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_POTENTIAL_CUSTOMER ="potential_customer.name";
	public RetailscmChecker checkNameOfPotentialCustomer(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER ="potential_customer.mobile";
	public RetailscmChecker checkMobileOfPotentialCustomer(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	 			

	public static final String  CITY_SERVICE_CENTER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_service_center";
	public RetailscmChecker checkCityServiceCenterIdOfPotentialCustomer(String cityServiceCenterId)
	{
		
	 	checkIdOfPotentialCustomer(cityServiceCenterId ); 		
		
		return this;
	}	 			

	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER ="potential_customer.city_partner";
	public RetailscmChecker checkCityPartnerIdOfPotentialCustomer(String cityPartnerId)
	{
		
	 	checkIdOfPotentialCustomer(cityPartnerId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER ="potential_customer.description";
	public RetailscmChecker checkDescriptionOfPotentialCustomer(String description)
	{
		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER ="potential_customer.version";
	public RetailscmChecker checkVersionOfPotentialCustomer(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.id";
	public RetailscmChecker checkIdOfPotentialCustomerContactPerson(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.name";
	public RetailscmChecker checkNameOfPotentialCustomerContactPerson(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.mobile";
	public RetailscmChecker checkMobileOfPotentialCustomerContactPerson(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	 			

	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.potential_customer";
	public RetailscmChecker checkPotentialCustomerIdOfPotentialCustomerContactPerson(String potentialCustomerId)
	{
		
	 	checkIdOfPotentialCustomerContactPerson(potentialCustomerId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.description";
	public RetailscmChecker checkDescriptionOfPotentialCustomerContactPerson(String description)
	{
		
	 	checkStringLengthRange(description,7, 96,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ="potential_customer_contact_person.version";
	public RetailscmChecker checkVersionOfPotentialCustomerContactPerson(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.id";
	public RetailscmChecker checkIdOfPotentialCustomerContact(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.name";
	public RetailscmChecker checkNameOfPotentialCustomerContact(String name)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_date";
	public RetailscmChecker checkContactDateOfPotentialCustomerContact(Date contactDate)
	{
		
	 	checkDateRange(contactDate,parseDate("1900-01-01"), parseDate("2016-09-09"),CONTACT_DATE_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_method";
	public RetailscmChecker checkContactMethodOfPotentialCustomerContact(String contactMethod)
	{
		
	 	checkStringLengthRange(contactMethod,1, 16,CONTACT_METHOD_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	 			

	public static final String  POTENTIAL_CUSTOMER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.potential_customer";
	public RetailscmChecker checkPotentialCustomerIdOfPotentialCustomerContact(String potentialCustomerId)
	{
		
	 	checkIdOfPotentialCustomerContact(potentialCustomerId ); 		
		
		return this;
	}	 			

	public static final String  CITY_PARTNER_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.city_partner";
	public RetailscmChecker checkCityPartnerIdOfPotentialCustomerContact(String cityPartnerId)
	{
		
	 	checkIdOfPotentialCustomerContact(cityPartnerId ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_TO_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.contact_to";
	public RetailscmChecker checkContactToIdOfPotentialCustomerContact(String contactToId)
	{
		
	 	checkIdOfPotentialCustomerContact(contactToId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.description";
	public RetailscmChecker checkDescriptionOfPotentialCustomerContact(String description)
	{
		
	 	checkStringLengthRange(description,2, 24,DESCRIPTION_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ="potential_customer_contact.version";
	public RetailscmChecker checkVersionOfPotentialCustomerContact(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CITY_EVENT ="city_event.id";
	public RetailscmChecker checkIdOfCityEvent(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CITY_EVENT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CITY_EVENT ="city_event.name";
	public RetailscmChecker checkNameOfCityEvent(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CITY_EVENT ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_CITY_EVENT ="city_event.mobile";
	public RetailscmChecker checkMobileOfCityEvent(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,5, 44,MOBILE_OF_CITY_EVENT ); 		
		
		return this;
	}	 			

	public static final String  CITY_SERVICE_CENTER_OF_CITY_EVENT ="city_event.city_service_center";
	public RetailscmChecker checkCityServiceCenterIdOfCityEvent(String cityServiceCenterId)
	{
		
	 	checkIdOfCityEvent(cityServiceCenterId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_CITY_EVENT ="city_event.description";
	public RetailscmChecker checkDescriptionOfCityEvent(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_CITY_EVENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CITY_EVENT ="city_event.version";
	public RetailscmChecker checkVersionOfCityEvent(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CITY_EVENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EVENT_ATTENDANCE ="event_attendance.id";
	public RetailscmChecker checkIdOfEventAttendance(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_EVENT_ATTENDANCE ="event_attendance.name";
	public RetailscmChecker checkNameOfEventAttendance(String name)
	{
		
	 	checkStringLengthRange(name,3, 36,NAME_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  POTENTIAL_CUSTOMER_OF_EVENT_ATTENDANCE ="event_attendance.potential_customer";
	public RetailscmChecker checkPotentialCustomerIdOfEventAttendance(String potentialCustomerId)
	{
		
	 	checkIdOfEventAttendance(potentialCustomerId ); 		
		
		return this;
	}	 			

	public static final String  CITY_EVENT_OF_EVENT_ATTENDANCE ="event_attendance.city_event";
	public RetailscmChecker checkCityEventIdOfEventAttendance(String cityEventId)
	{
		
	 	checkIdOfEventAttendance(cityEventId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_EVENT_ATTENDANCE ="event_attendance.description";
	public RetailscmChecker checkDescriptionOfEventAttendance(String description)
	{
		
	 	checkStringLengthRange(description,3, 36,DESCRIPTION_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EVENT_ATTENDANCE ="event_attendance.version";
	public RetailscmChecker checkVersionOfEventAttendance(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EVENT_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE ="retail_store.id";
	public RetailscmChecker checkIdOfRetailStore(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE ="retail_store.name";
	public RetailscmChecker checkNameOfRetailStore(String name)
	{
		
	 	checkStringLengthRange(name,3, 24,NAME_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  TELEPHONE_OF_RETAIL_STORE ="retail_store.telephone";
	public RetailscmChecker checkTelephoneOfRetailStore(String telephone)
	{
		
	 	checkStringLengthRange(telephone,3, 44,TELEPHONE_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_RETAIL_STORE ="retail_store.owner";
	public RetailscmChecker checkOwnerOfRetailStore(String owner)
	{
		
	 	checkStringLengthRange(owner,1, 8,OWNER_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  RETAIL_STORE_COUNTRY_CENTER_OF_RETAIL_STORE ="retail_store.retail_store_country_center";
	public RetailscmChecker checkRetailStoreCountryCenterIdOfRetailStore(String retailStoreCountryCenterId)
	{
		
	 	checkIdOfRetailStore(retailStoreCountryCenterId ); 		
		
		return this;
	}	 			

	public static final String  CITY_SERVICE_CENTER_OF_RETAIL_STORE ="retail_store.city_service_center";
	public RetailscmChecker checkCityServiceCenterIdOfRetailStore(String cityServiceCenterId)
	{
		
	 	checkIdOfRetailStore(cityServiceCenterId ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_RETAIL_STORE ="retail_store.founded";
	public RetailscmChecker checkFoundedOfRetailStore(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_RETAIL_STORE ="retail_store.latitude";
	public RetailscmChecker checkLatitudeOfRetailStore(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_RETAIL_STORE ="retail_store.longitude";
	public RetailscmChecker checkLongitudeOfRetailStore(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_RETAIL_STORE ="retail_store.description";
	public RetailscmChecker checkDescriptionOfRetailStore(String description)
	{
		
	 	checkStringLengthRange(description,6, 84,DESCRIPTION_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE ="retail_store.version";
	public RetailscmChecker checkVersionOfRetailStore(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_CREATION ="retail_store_creation.id";
	public RetailscmChecker checkIdOfRetailStoreCreation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_CREATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_RETAIL_STORE_CREATION ="retail_store_creation.comment";
	public RetailscmChecker checkCommentOfRetailStoreCreation(String comment)
	{
		
	 	checkStringLengthRange(comment,2, 20,COMMENT_OF_RETAIL_STORE_CREATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_CREATION ="retail_store_creation.version";
	public RetailscmChecker checkVersionOfRetailStoreCreation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CREATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.id";
	public RetailscmChecker checkIdOfRetailStoreInvestmentInvitation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_INVESTMENT_INVITATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.comment";
	public RetailscmChecker checkCommentOfRetailStoreInvestmentInvitation(String comment)
	{
		
	 	checkStringLengthRange(comment,2, 24,COMMENT_OF_RETAIL_STORE_INVESTMENT_INVITATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION ="retail_store_investment_invitation.version";
	public RetailscmChecker checkVersionOfRetailStoreInvestmentInvitation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_INVESTMENT_INVITATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.id";
	public RetailscmChecker checkIdOfRetailStoreFranchising(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_FRANCHISING ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.comment";
	public RetailscmChecker checkCommentOfRetailStoreFranchising(String comment)
	{
		
	 	checkStringLengthRange(comment,2, 16,COMMENT_OF_RETAIL_STORE_FRANCHISING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_FRANCHISING ="retail_store_franchising.version";
	public RetailscmChecker checkVersionOfRetailStoreFranchising(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_FRANCHISING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.id";
	public RetailscmChecker checkIdOfRetailStoreDecoration(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_DECORATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.comment";
	public RetailscmChecker checkCommentOfRetailStoreDecoration(String comment)
	{
		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_DECORATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_DECORATION ="retail_store_decoration.version";
	public RetailscmChecker checkVersionOfRetailStoreDecoration(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_DECORATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_OPENING ="retail_store_opening.id";
	public RetailscmChecker checkIdOfRetailStoreOpening(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_OPENING ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_RETAIL_STORE_OPENING ="retail_store_opening.comment";
	public RetailscmChecker checkCommentOfRetailStoreOpening(String comment)
	{
		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_OPENING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_OPENING ="retail_store_opening.version";
	public RetailscmChecker checkVersionOfRetailStoreOpening(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_OPENING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_CLOSING ="retail_store_closing.id";
	public RetailscmChecker checkIdOfRetailStoreClosing(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_CLOSING ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_RETAIL_STORE_CLOSING ="retail_store_closing.comment";
	public RetailscmChecker checkCommentOfRetailStoreClosing(String comment)
	{
		
	 	checkStringLengthRange(comment,1, 8,COMMENT_OF_RETAIL_STORE_CLOSING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_CLOSING ="retail_store_closing.version";
	public RetailscmChecker checkVersionOfRetailStoreClosing(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_CLOSING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_MEMBER ="retail_store_member.id";
	public RetailscmChecker checkIdOfRetailStoreMember(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_MEMBER ="retail_store_member.name";
	public RetailscmChecker checkNameOfRetailStoreMember(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER ="retail_store_member.mobile_phone";
	public RetailscmChecker checkMobilePhoneOfRetailStoreMember(String mobilePhone)
	{
		
	 	checkChinaMobilePhone(mobilePhone,5, 44,MOBILE_PHONE_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER ="retail_store_member.owner";
	public RetailscmChecker checkOwnerIdOfRetailStoreMember(String ownerId)
	{
		
	 	checkIdOfRetailStoreMember(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER ="retail_store_member.version";
	public RetailscmChecker checkVersionOfRetailStoreMember(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER ="consumer_order.id";
	public RetailscmChecker checkIdOfConsumerOrder(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_CONSUMER_ORDER ="consumer_order.title";
	public RetailscmChecker checkTitleOfConsumerOrder(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_CONSUMER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  CONSUMER_OF_CONSUMER_ORDER ="consumer_order.consumer";
	public RetailscmChecker checkConsumerIdOfConsumerOrder(String consumerId)
	{
		
	 	checkIdOfConsumerOrder(consumerId ); 		
		
		return this;
	}	 			

	public static final String  STORE_OF_CONSUMER_ORDER ="consumer_order.store";
	public RetailscmChecker checkStoreIdOfConsumerOrder(String storeId)
	{
		
	 	checkIdOfConsumerOrder(storeId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER ="consumer_order.version";
	public RetailscmChecker checkVersionOfConsumerOrder(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.id";
	public RetailscmChecker checkIdOfConsumerOrderConfirmation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.who";
	public RetailscmChecker checkWhoOfConsumerOrderConfirmation(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.confirm_time";
	public RetailscmChecker checkConfirmTimeOfConsumerOrderConfirmation(Date confirmTime)
	{
		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_CONFIRMATION ="consumer_order_confirmation.version";
	public RetailscmChecker checkVersionOfConsumerOrderConfirmation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.id";
	public RetailscmChecker checkIdOfConsumerOrderApproval(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.who";
	public RetailscmChecker checkWhoOfConsumerOrderApproval(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.approve_time";
	public RetailscmChecker checkApproveTimeOfConsumerOrderApproval(Date approveTime)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_APPROVAL ="consumer_order_approval.version";
	public RetailscmChecker checkVersionOfConsumerOrderApproval(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.id";
	public RetailscmChecker checkIdOfConsumerOrderProcessing(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.who";
	public RetailscmChecker checkWhoOfConsumerOrderProcessing(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.process_time";
	public RetailscmChecker checkProcessTimeOfConsumerOrderProcessing(Date processTime)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_PROCESSING ="consumer_order_processing.version";
	public RetailscmChecker checkVersionOfConsumerOrderProcessing(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.id";
	public RetailscmChecker checkIdOfConsumerOrderShipment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.who";
	public RetailscmChecker checkWhoOfConsumerOrderShipment(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.ship_time";
	public RetailscmChecker checkShipTimeOfConsumerOrderShipment(Date shipTime)
	{
		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPMENT ="consumer_order_shipment.version";
	public RetailscmChecker checkVersionOfConsumerOrderShipment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.id";
	public RetailscmChecker checkIdOfConsumerOrderDelivery(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.who";
	public RetailscmChecker checkWhoOfConsumerOrderDelivery(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.delivery_time";
	public RetailscmChecker checkDeliveryTimeOfConsumerOrderDelivery(Date deliveryTime)
	{
		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_DELIVERY ="consumer_order_delivery.version";
	public RetailscmChecker checkVersionOfConsumerOrderDelivery(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.id";
	public RetailscmChecker checkIdOfConsumerOrderLineItem(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.biz_order";
	public RetailscmChecker checkBizOrderIdOfConsumerOrderLineItem(String bizOrderId)
	{
		
	 	checkIdOfConsumerOrderLineItem(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_id";
	public RetailscmChecker checkSkuIdOfConsumerOrderLineItem(String skuId)
	{
		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.sku_name";
	public RetailscmChecker checkSkuNameOfConsumerOrderLineItem(String skuName)
	{
		
	 	checkStringLengthRange(skuName,2, 16,SKU_NAME_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  PRICE_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.price";
	public RetailscmChecker checkPriceOfConsumerOrderLineItem(BigDecimal price)
	{
		
	 	checkMoneyAmount(price,0.00, 5.97,PRICE_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.quantity";
	public RetailscmChecker checkQuantityOfConsumerOrderLineItem(BigDecimal quantity)
	{
		
	 	checkBigDecimalRange(quantity,0, 1000.00,QUANTITY_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.amount";
	public RetailscmChecker checkAmountOfConsumerOrderLineItem(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 9999.99,AMOUNT_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.version";
	public RetailscmChecker checkVersionOfConsumerOrderLineItem(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.id";
	public RetailscmChecker checkIdOfConsumerOrderShippingGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.name";
	public RetailscmChecker checkNameOfConsumerOrderShippingGroup(String name)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.biz_order";
	public RetailscmChecker checkBizOrderIdOfConsumerOrderShippingGroup(String bizOrderId)
	{
		
	 	checkIdOfConsumerOrderShippingGroup(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.amount";
	public RetailscmChecker checkAmountOfConsumerOrderShippingGroup(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 599.99,AMOUNT_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP ="consumer_order_shipping_group.version";
	public RetailscmChecker checkVersionOfConsumerOrderShippingGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.id";
	public RetailscmChecker checkIdOfConsumerOrderPaymentGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.name";
	public RetailscmChecker checkNameOfConsumerOrderPaymentGroup(String name)
	{
		
	 	checkStringLengthRange(name,1, 16,NAME_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.biz_order";
	public RetailscmChecker checkBizOrderIdOfConsumerOrderPaymentGroup(String bizOrderId)
	{
		
	 	checkIdOfConsumerOrderPaymentGroup(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.card_number";
	public RetailscmChecker checkCardNumberOfConsumerOrderPaymentGroup(String cardNumber)
	{
		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP ="consumer_order_payment_group.version";
	public RetailscmChecker checkVersionOfConsumerOrderPaymentGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.id";
	public RetailscmChecker checkIdOfConsumerOrderPriceAdjustment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.name";
	public RetailscmChecker checkNameOfConsumerOrderPriceAdjustment(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.biz_order";
	public RetailscmChecker checkBizOrderIdOfConsumerOrderPriceAdjustment(String bizOrderId)
	{
		
	 	checkIdOfConsumerOrderPriceAdjustment(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.amount";
	public RetailscmChecker checkAmountOfConsumerOrderPriceAdjustment(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 599.99,AMOUNT_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.provider";
	public RetailscmChecker checkProviderOfConsumerOrderPriceAdjustment(String provider)
	{
		
	 	checkStringLengthRange(provider,1, 16,PROVIDER_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ="consumer_order_price_adjustment.version";
	public RetailscmChecker checkVersionOfConsumerOrderPriceAdjustment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.id";
	public RetailscmChecker checkIdOfRetailStoreMemberCoupon(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.name";
	public RetailscmChecker checkNameOfRetailStoreMemberCoupon(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.owner";
	public RetailscmChecker checkOwnerIdOfRetailStoreMemberCoupon(String ownerId)
	{
		
	 	checkIdOfRetailStoreMemberCoupon(ownerId ); 		
		
		return this;
	}	 			

	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.number";
	public RetailscmChecker checkNumberOfRetailStoreMemberCoupon(String number)
	{
		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_COUPON ="retail_store_member_coupon.version";
	public RetailscmChecker checkVersionOfRetailStoreMemberCoupon(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MEMBER_WISHLIST ="member_wishlist.id";
	public RetailscmChecker checkIdOfMemberWishlist(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_WISHLIST ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MEMBER_WISHLIST ="member_wishlist.name";
	public RetailscmChecker checkNameOfMemberWishlist(String name)
	{
		
	 	checkStringLengthRange(name,3, 24,NAME_OF_MEMBER_WISHLIST ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_MEMBER_WISHLIST ="member_wishlist.owner";
	public RetailscmChecker checkOwnerIdOfMemberWishlist(String ownerId)
	{
		
	 	checkIdOfMemberWishlist(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MEMBER_WISHLIST ="member_wishlist.version";
	public RetailscmChecker checkVersionOfMemberWishlist(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_WISHLIST ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MEMBER_REWARD_POINT ="member_reward_point.id";
	public RetailscmChecker checkIdOfMemberRewardPoint(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MEMBER_REWARD_POINT ="member_reward_point.name";
	public RetailscmChecker checkNameOfMemberRewardPoint(String name)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	 			

	public static final String  POINT_OF_MEMBER_REWARD_POINT ="member_reward_point.point";
	public RetailscmChecker checkPointOfMemberRewardPoint(int point)
	{
		
	 	checkIntegerRange(point,0, 20,POINT_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_MEMBER_REWARD_POINT ="member_reward_point.owner";
	public RetailscmChecker checkOwnerIdOfMemberRewardPoint(String ownerId)
	{
		
	 	checkIdOfMemberRewardPoint(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MEMBER_REWARD_POINT ="member_reward_point.version";
	public RetailscmChecker checkVersionOfMemberRewardPoint(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_REWARD_POINT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.id";
	public RetailscmChecker checkIdOfMemberRewardPointRedemption(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.name";
	public RetailscmChecker checkNameOfMemberRewardPointRedemption(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	 			

	public static final String  POINT_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.point";
	public RetailscmChecker checkPointOfMemberRewardPointRedemption(int point)
	{
		
	 	checkIntegerRange(point,0, 20,POINT_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.owner";
	public RetailscmChecker checkOwnerIdOfMemberRewardPointRedemption(String ownerId)
	{
		
	 	checkIdOfMemberRewardPointRedemption(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION ="member_reward_point_redemption.version";
	public RetailscmChecker checkVersionOfMemberRewardPointRedemption(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.id";
	public RetailscmChecker checkIdOfMemberWishlistProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_MEMBER_WISHLIST_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.name";
	public RetailscmChecker checkNameOfMemberWishlistProduct(String name)
	{
		
	 	checkStringLengthRange(name,2, 20,NAME_OF_MEMBER_WISHLIST_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.owner";
	public RetailscmChecker checkOwnerIdOfMemberWishlistProduct(String ownerId)
	{
		
	 	checkIdOfMemberWishlistProduct(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_MEMBER_WISHLIST_PRODUCT ="member_wishlist_product.version";
	public RetailscmChecker checkVersionOfMemberWishlistProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MEMBER_WISHLIST_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.id";
	public RetailscmChecker checkIdOfRetailStoreMemberAddress(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.name";
	public RetailscmChecker checkNameOfRetailStoreMemberAddress(String name)
	{
		
	 	checkStringLengthRange(name,1, 24,NAME_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.owner";
	public RetailscmChecker checkOwnerIdOfRetailStoreMemberAddress(String ownerId)
	{
		
	 	checkIdOfRetailStoreMemberAddress(ownerId ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.mobile_phone";
	public RetailscmChecker checkMobilePhoneOfRetailStoreMemberAddress(String mobilePhone)
	{
		
	 	checkChinaMobilePhone(mobilePhone,5, 44,MOBILE_PHONE_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.address";
	public RetailscmChecker checkAddressOfRetailStoreMemberAddress(String address)
	{
		
	 	checkStringLengthRange(address,4, 56,ADDRESS_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS ="retail_store_member_address.version";
	public RetailscmChecker checkVersionOfRetailStoreMemberAddress(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.id";
	public RetailscmChecker checkIdOfRetailStoreMemberGiftCard(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.name";
	public RetailscmChecker checkNameOfRetailStoreMemberGiftCard(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.owner";
	public RetailscmChecker checkOwnerIdOfRetailStoreMemberGiftCard(String ownerId)
	{
		
	 	checkIdOfRetailStoreMemberGiftCard(ownerId ); 		
		
		return this;
	}	 			

	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.number";
	public RetailscmChecker checkNumberOfRetailStoreMemberGiftCard(String number)
	{
		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	 			

	public static final String  REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.remain";
	public RetailscmChecker checkRemainOfRetailStoreMemberGiftCard(BigDecimal remain)
	{
		
	 	checkMoneyAmount(remain,0.00, 213.99,REMAIN_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD ="retail_store_member_gift_card.version";
	public RetailscmChecker checkVersionOfRetailStoreMemberGiftCard(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.id";
	public RetailscmChecker checkIdOfRetailStoreMemberGiftCardConsumeRecord(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	 			

	public static final String  OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.occure_time";
	public RetailscmChecker checkOccureTimeOfRetailStoreMemberGiftCardConsumeRecord(Date occureTime)
	{
		
	 	checkDatePast(occureTime,parseDate("1900-01-01"), new Date(),OCCURE_TIME_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.owner";
	public RetailscmChecker checkOwnerIdOfRetailStoreMemberGiftCardConsumeRecord(String ownerId)
	{
		
	 	checkIdOfRetailStoreMemberGiftCardConsumeRecord(ownerId ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.biz_order";
	public RetailscmChecker checkBizOrderIdOfRetailStoreMemberGiftCardConsumeRecord(String bizOrderId)
	{
		
	 	checkIdOfRetailStoreMemberGiftCardConsumeRecord(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.number";
	public RetailscmChecker checkNumberOfRetailStoreMemberGiftCardConsumeRecord(String number)
	{
		
	 	checkStringLengthRange(number,2, 28,NUMBER_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.amount";
	public RetailscmChecker checkAmountOfRetailStoreMemberGiftCardConsumeRecord(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 20.99,AMOUNT_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ="retail_store_member_gift_card_consume_record.version";
	public RetailscmChecker checkVersionOfRetailStoreMemberGiftCardConsumeRecord(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GOODS_SUPPLIER ="goods_supplier.id";
	public RetailscmChecker checkIdOfGoodsSupplier(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_GOODS_SUPPLIER ="goods_supplier.name";
	public RetailscmChecker checkNameOfGoodsSupplier(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	 			

	public static final String  SUPPLY_PRODUCT_OF_GOODS_SUPPLIER ="goods_supplier.supply_product";
	public RetailscmChecker checkSupplyProductOfGoodsSupplier(String supplyProduct)
	{
		
	 	checkStringLengthRange(supplyProduct,1, 16,SUPPLY_PRODUCT_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	 			

	public static final String  BELONG_TO_OF_GOODS_SUPPLIER ="goods_supplier.belong_to";
	public RetailscmChecker checkBelongToIdOfGoodsSupplier(String belongToId)
	{
		
	 	checkIdOfGoodsSupplier(belongToId ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_GOODS_SUPPLIER ="goods_supplier.contact_number";
	public RetailscmChecker checkContactNumberOfGoodsSupplier(String contactNumber)
	{
		
	 	checkChinaMobilePhone(contactNumber,5, 44,CONTACT_NUMBER_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GOODS_SUPPLIER ="goods_supplier.description";
	public RetailscmChecker checkDescriptionOfGoodsSupplier(String description)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GOODS_SUPPLIER ="goods_supplier.version";
	public RetailscmChecker checkVersionOfGoodsSupplier(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SUPPLIER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLIER_PRODUCT ="supplier_product.id";
	public RetailscmChecker checkIdOfSupplierProduct(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_NAME_OF_SUPPLIER_PRODUCT ="supplier_product.product_name";
	public RetailscmChecker checkProductNameOfSupplierProduct(String productName)
	{
		
	 	checkStringLengthRange(productName,2, 16,PRODUCT_NAME_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT ="supplier_product.product_description";
	public RetailscmChecker checkProductDescriptionOfSupplierProduct(String productDescription)
	{
		
	 	checkStringLengthRange(productDescription,4, 52,PRODUCT_DESCRIPTION_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_UNIT_OF_SUPPLIER_PRODUCT ="supplier_product.product_unit";
	public RetailscmChecker checkProductUnitOfSupplierProduct(String productUnit)
	{
		
	 	checkStringLengthRange(productUnit,0, 8,PRODUCT_UNIT_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  SUPPLIER_OF_SUPPLIER_PRODUCT ="supplier_product.supplier";
	public RetailscmChecker checkSupplierIdOfSupplierProduct(String supplierId)
	{
		
	 	checkIdOfSupplierProduct(supplierId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLIER_PRODUCT ="supplier_product.version";
	public RetailscmChecker checkVersionOfSupplierProduct(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLIER_PRODUCT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.id";
	public RetailscmChecker checkIdOfProductSupplyDuration(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	 			

	public static final String  QUANTITY_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.quantity";
	public RetailscmChecker checkQuantityOfProductSupplyDuration(int quantity)
	{
		
	 	checkIntegerRange(quantity,0, 500,QUANTITY_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	 			

	public static final String  DURATION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.duration";
	public RetailscmChecker checkDurationOfProductSupplyDuration(String duration)
	{
		
	 	checkStringLengthRange(duration,1, 8,DURATION_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	 			

	public static final String  PRICE_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.price";
	public RetailscmChecker checkPriceOfProductSupplyDuration(BigDecimal price)
	{
		
	 	checkMoneyAmount(price,0.00, 9999.99,PRICE_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	 			

	public static final String  PRODUCT_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.product";
	public RetailscmChecker checkProductIdOfProductSupplyDuration(String productId)
	{
		
	 	checkIdOfProductSupplyDuration(productId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PRODUCT_SUPPLY_DURATION ="product_supply_duration.version";
	public RetailscmChecker checkVersionOfProductSupplyDuration(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PRODUCT_SUPPLY_DURATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER ="supply_order.id";
	public RetailscmChecker checkIdOfSupplyOrder(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	 			

	public static final String  BUYER_OF_SUPPLY_ORDER ="supply_order.buyer";
	public RetailscmChecker checkBuyerIdOfSupplyOrder(String buyerId)
	{
		
	 	checkIdOfSupplyOrder(buyerId ); 		
		
		return this;
	}	 			

	public static final String  SELLER_OF_SUPPLY_ORDER ="supply_order.seller";
	public RetailscmChecker checkSellerIdOfSupplyOrder(String sellerId)
	{
		
	 	checkIdOfSupplyOrder(sellerId ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_SUPPLY_ORDER ="supply_order.title";
	public RetailscmChecker checkTitleOfSupplyOrder(String title)
	{
		
	 	checkStringLengthRange(title,3, 40,TITLE_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AMOUNT_OF_SUPPLY_ORDER ="supply_order.total_amount";
	public RetailscmChecker checkTotalAmountOfSupplyOrder(BigDecimal totalAmount)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 3000000000.88,TOTAL_AMOUNT_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER ="supply_order.version";
	public RetailscmChecker checkVersionOfSupplyOrder(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.id";
	public RetailscmChecker checkIdOfSupplyOrderConfirmation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.who";
	public RetailscmChecker checkWhoOfSupplyOrderConfirmation(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.confirm_time";
	public RetailscmChecker checkConfirmTimeOfSupplyOrderConfirmation(Date confirmTime)
	{
		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_CONFIRMATION ="supply_order_confirmation.version";
	public RetailscmChecker checkVersionOfSupplyOrderConfirmation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.id";
	public RetailscmChecker checkIdOfSupplyOrderApproval(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.who";
	public RetailscmChecker checkWhoOfSupplyOrderApproval(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.approve_time";
	public RetailscmChecker checkApproveTimeOfSupplyOrderApproval(Date approveTime)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_APPROVAL ="supply_order_approval.version";
	public RetailscmChecker checkVersionOfSupplyOrderApproval(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.id";
	public RetailscmChecker checkIdOfSupplyOrderProcessing(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.who";
	public RetailscmChecker checkWhoOfSupplyOrderProcessing(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.process_time";
	public RetailscmChecker checkProcessTimeOfSupplyOrderProcessing(Date processTime)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_PROCESSING ="supply_order_processing.version";
	public RetailscmChecker checkVersionOfSupplyOrderProcessing(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.id";
	public RetailscmChecker checkIdOfSupplyOrderPicking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.who";
	public RetailscmChecker checkWhoOfSupplyOrderPicking(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  PROCESS_TIME_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.process_time";
	public RetailscmChecker checkProcessTimeOfSupplyOrderPicking(Date processTime)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_PICKING ="supply_order_picking.version";
	public RetailscmChecker checkVersionOfSupplyOrderPicking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.id";
	public RetailscmChecker checkIdOfSupplyOrderShipment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.who";
	public RetailscmChecker checkWhoOfSupplyOrderShipment(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.ship_time";
	public RetailscmChecker checkShipTimeOfSupplyOrderShipment(Date shipTime)
	{
		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPMENT ="supply_order_shipment.version";
	public RetailscmChecker checkVersionOfSupplyOrderShipment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.id";
	public RetailscmChecker checkIdOfSupplyOrderDelivery(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.who";
	public RetailscmChecker checkWhoOfSupplyOrderDelivery(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.delivery_time";
	public RetailscmChecker checkDeliveryTimeOfSupplyOrderDelivery(Date deliveryTime)
	{
		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_DELIVERY ="supply_order_delivery.version";
	public RetailscmChecker checkVersionOfSupplyOrderDelivery(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.id";
	public RetailscmChecker checkIdOfSupplyOrderLineItem(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.biz_order";
	public RetailscmChecker checkBizOrderIdOfSupplyOrderLineItem(String bizOrderId)
	{
		
	 	checkIdOfSupplyOrderLineItem(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_id";
	public RetailscmChecker checkSkuIdOfSupplyOrderLineItem(String skuId)
	{
		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.sku_name";
	public RetailscmChecker checkSkuNameOfSupplyOrderLineItem(String skuName)
	{
		
	 	checkStringLengthRange(skuName,2, 16,SKU_NAME_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.amount";
	public RetailscmChecker checkAmountOfSupplyOrderLineItem(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 5.97,AMOUNT_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.quantity";
	public RetailscmChecker checkQuantityOfSupplyOrderLineItem(int quantity)
	{
		
	 	checkIntegerRange(quantity,0, 10000,QUANTITY_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.unit_of_measurement";
	public RetailscmChecker checkUnitOfMeasurementOfSupplyOrderLineItem(String unitOfMeasurement)
	{
		
	 	checkStringLengthRange(unitOfMeasurement,0, 8,UNIT_OF_MEASUREMENT_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.version";
	public RetailscmChecker checkVersionOfSupplyOrderLineItem(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.id";
	public RetailscmChecker checkIdOfSupplyOrderShippingGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.name";
	public RetailscmChecker checkNameOfSupplyOrderShippingGroup(String name)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.biz_order";
	public RetailscmChecker checkBizOrderIdOfSupplyOrderShippingGroup(String bizOrderId)
	{
		
	 	checkIdOfSupplyOrderShippingGroup(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.amount";
	public RetailscmChecker checkAmountOfSupplyOrderShippingGroup(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 5.99,AMOUNT_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP ="supply_order_shipping_group.version";
	public RetailscmChecker checkVersionOfSupplyOrderShippingGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.id";
	public RetailscmChecker checkIdOfSupplyOrderPaymentGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.name";
	public RetailscmChecker checkNameOfSupplyOrderPaymentGroup(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.biz_order";
	public RetailscmChecker checkBizOrderIdOfSupplyOrderPaymentGroup(String bizOrderId)
	{
		
	 	checkIdOfSupplyOrderPaymentGroup(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.card_number";
	public RetailscmChecker checkCardNumberOfSupplyOrderPaymentGroup(String cardNumber)
	{
		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP ="supply_order_payment_group.version";
	public RetailscmChecker checkVersionOfSupplyOrderPaymentGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER ="retail_store_order.id";
	public RetailscmChecker checkIdOfRetailStoreOrder(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	 			

	public static final String  BUYER_OF_RETAIL_STORE_ORDER ="retail_store_order.buyer";
	public RetailscmChecker checkBuyerIdOfRetailStoreOrder(String buyerId)
	{
		
	 	checkIdOfRetailStoreOrder(buyerId ); 		
		
		return this;
	}	 			

	public static final String  SELLER_OF_RETAIL_STORE_ORDER ="retail_store_order.seller";
	public RetailscmChecker checkSellerIdOfRetailStoreOrder(String sellerId)
	{
		
	 	checkIdOfRetailStoreOrder(sellerId ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_RETAIL_STORE_ORDER ="retail_store_order.title";
	public RetailscmChecker checkTitleOfRetailStoreOrder(String title)
	{
		
	 	checkStringLengthRange(title,4, 56,TITLE_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER ="retail_store_order.total_amount";
	public RetailscmChecker checkTotalAmountOfRetailStoreOrder(BigDecimal totalAmount)
	{
		
	 	checkMoneyAmount(totalAmount,0.00, 3000000000.88,TOTAL_AMOUNT_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER ="retail_store_order.version";
	public RetailscmChecker checkVersionOfRetailStoreOrder(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.id";
	public RetailscmChecker checkIdOfRetailStoreOrderConfirmation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.who";
	public RetailscmChecker checkWhoOfRetailStoreOrderConfirmation(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.confirm_time";
	public RetailscmChecker checkConfirmTimeOfRetailStoreOrderConfirmation(Date confirmTime)
	{
		
	 	checkDateRange(confirmTime,parseDate("1900-01-01"), parseDate("2018-07-09"),CONFIRM_TIME_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION ="retail_store_order_confirmation.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderConfirmation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.id";
	public RetailscmChecker checkIdOfRetailStoreOrderApproval(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.who";
	public RetailscmChecker checkWhoOfRetailStoreOrderApproval(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.approve_time";
	public RetailscmChecker checkApproveTimeOfRetailStoreOrderApproval(Date approveTime)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-07-09"),APPROVE_TIME_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_APPROVAL ="retail_store_order_approval.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderApproval(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.id";
	public RetailscmChecker checkIdOfRetailStoreOrderProcessing(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.who";
	public RetailscmChecker checkWhoOfRetailStoreOrderProcessing(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.process_time";
	public RetailscmChecker checkProcessTimeOfRetailStoreOrderProcessing(Date processTime)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PROCESSING ="retail_store_order_processing.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderProcessing(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PROCESSING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.id";
	public RetailscmChecker checkIdOfRetailStoreOrderPicking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.who";
	public RetailscmChecker checkWhoOfRetailStoreOrderPicking(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.process_time";
	public RetailscmChecker checkProcessTimeOfRetailStoreOrderPicking(Date processTime)
	{
		
	 	checkDateRange(processTime,parseDate("1900-01-01"), parseDate("2018-07-09"),PROCESS_TIME_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PICKING ="retail_store_order_picking.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderPicking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PICKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.id";
	public RetailscmChecker checkIdOfRetailStoreOrderShipment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.who";
	public RetailscmChecker checkWhoOfRetailStoreOrderShipment(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.ship_time";
	public RetailscmChecker checkShipTimeOfRetailStoreOrderShipment(Date shipTime)
	{
		
	 	checkDateRange(shipTime,parseDate("1900-01-01"), parseDate("2018-07-09"),SHIP_TIME_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT ="retail_store_order_shipment.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderShipment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_SHIPMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.id";
	public RetailscmChecker checkIdOfRetailStoreOrderDelivery(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.who";
	public RetailscmChecker checkWhoOfRetailStoreOrderDelivery(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.delivery_time";
	public RetailscmChecker checkDeliveryTimeOfRetailStoreOrderDelivery(Date deliveryTime)
	{
		
	 	checkDateRange(deliveryTime,parseDate("1900-01-01"), parseDate("2018-07-09"),DELIVERY_TIME_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_DELIVERY ="retail_store_order_delivery.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderDelivery(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_DELIVERY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.id";
	public RetailscmChecker checkIdOfRetailStoreOrderLineItem(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.biz_order";
	public RetailscmChecker checkBizOrderIdOfRetailStoreOrderLineItem(String bizOrderId)
	{
		
	 	checkIdOfRetailStoreOrderLineItem(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_id";
	public RetailscmChecker checkSkuIdOfRetailStoreOrderLineItem(String skuId)
	{
		
	 	checkStringLengthRange(skuId,1, 12,SKU_ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.sku_name";
	public RetailscmChecker checkSkuNameOfRetailStoreOrderLineItem(String skuName)
	{
		
	 	checkStringLengthRange(skuName,2, 16,SKU_NAME_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.amount";
	public RetailscmChecker checkAmountOfRetailStoreOrderLineItem(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 3.97,AMOUNT_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.quantity";
	public RetailscmChecker checkQuantityOfRetailStoreOrderLineItem(int quantity)
	{
		
	 	checkIntegerRange(quantity,0, 10000,QUANTITY_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.unit_of_measurement";
	public RetailscmChecker checkUnitOfMeasurementOfRetailStoreOrderLineItem(String unitOfMeasurement)
	{
		
	 	checkStringLengthRange(unitOfMeasurement,0, 8,UNIT_OF_MEASUREMENT_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderLineItem(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.id";
	public RetailscmChecker checkIdOfRetailStoreOrderShippingGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.name";
	public RetailscmChecker checkNameOfRetailStoreOrderShippingGroup(String name)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.biz_order";
	public RetailscmChecker checkBizOrderIdOfRetailStoreOrderShippingGroup(String bizOrderId)
	{
		
	 	checkIdOfRetailStoreOrderShippingGroup(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.amount";
	public RetailscmChecker checkAmountOfRetailStoreOrderShippingGroup(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 5.99,AMOUNT_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ="retail_store_order_shipping_group.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderShippingGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.id";
	public RetailscmChecker checkIdOfRetailStoreOrderPaymentGroup(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.name";
	public RetailscmChecker checkNameOfRetailStoreOrderPaymentGroup(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.biz_order";
	public RetailscmChecker checkBizOrderIdOfRetailStoreOrderPaymentGroup(String bizOrderId)
	{
		
	 	checkIdOfRetailStoreOrderPaymentGroup(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.card_number";
	public RetailscmChecker checkCardNumberOfRetailStoreOrderPaymentGroup(String cardNumber)
	{
		
	 	checkStringLengthRange(cardNumber,5, 68,CARD_NUMBER_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ="retail_store_order_payment_group.version";
	public RetailscmChecker checkVersionOfRetailStoreOrderPaymentGroup(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_WAREHOUSE ="warehouse.id";
	public RetailscmChecker checkIdOfWarehouse(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_WAREHOUSE ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_WAREHOUSE ="warehouse.location";
	public RetailscmChecker checkLocationOfWarehouse(String location)
	{
		
	 	checkStringLengthRange(location,3, 44,LOCATION_OF_WAREHOUSE ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_WAREHOUSE ="warehouse.contact_number";
	public RetailscmChecker checkContactNumberOfWarehouse(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_WAREHOUSE ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AREA_OF_WAREHOUSE ="warehouse.total_area";
	public RetailscmChecker checkTotalAreaOfWarehouse(String totalArea)
	{
		
	 	checkStringLengthRange(totalArea,3, 36,TOTAL_AREA_OF_WAREHOUSE ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_WAREHOUSE ="warehouse.owner";
	public RetailscmChecker checkOwnerIdOfWarehouse(String ownerId)
	{
		
	 	checkIdOfWarehouse(ownerId ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_WAREHOUSE ="warehouse.latitude";
	public RetailscmChecker checkLatitudeOfWarehouse(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_WAREHOUSE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_WAREHOUSE ="warehouse.longitude";
	public RetailscmChecker checkLongitudeOfWarehouse(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_WAREHOUSE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_WAREHOUSE ="warehouse.version";
	public RetailscmChecker checkVersionOfWarehouse(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WAREHOUSE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_STORAGE_SPACE ="storage_space.id";
	public RetailscmChecker checkIdOfStorageSpace(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_STORAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_STORAGE_SPACE ="storage_space.location";
	public RetailscmChecker checkLocationOfStorageSpace(String location)
	{
		
	 	checkStringLengthRange(location,4, 56,LOCATION_OF_STORAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_STORAGE_SPACE ="storage_space.contact_number";
	public RetailscmChecker checkContactNumberOfStorageSpace(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_STORAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AREA_OF_STORAGE_SPACE ="storage_space.total_area";
	public RetailscmChecker checkTotalAreaOfStorageSpace(String totalArea)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_STORAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  WAREHOUSE_OF_STORAGE_SPACE ="storage_space.warehouse";
	public RetailscmChecker checkWarehouseIdOfStorageSpace(String warehouseId)
	{
		
	 	checkIdOfStorageSpace(warehouseId ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_STORAGE_SPACE ="storage_space.latitude";
	public RetailscmChecker checkLatitudeOfStorageSpace(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_STORAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_STORAGE_SPACE ="storage_space.longitude";
	public RetailscmChecker checkLongitudeOfStorageSpace(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_STORAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_STORAGE_SPACE ="storage_space.version";
	public RetailscmChecker checkVersionOfStorageSpace(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_STORAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SMART_PALLET ="smart_pallet.id";
	public RetailscmChecker checkIdOfSmartPallet(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SMART_PALLET ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_SMART_PALLET ="smart_pallet.location";
	public RetailscmChecker checkLocationOfSmartPallet(String location)
	{
		
	 	checkStringLengthRange(location,7, 104,LOCATION_OF_SMART_PALLET ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_SMART_PALLET ="smart_pallet.contact_number";
	public RetailscmChecker checkContactNumberOfSmartPallet(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SMART_PALLET ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AREA_OF_SMART_PALLET ="smart_pallet.total_area";
	public RetailscmChecker checkTotalAreaOfSmartPallet(String totalArea)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SMART_PALLET ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_SMART_PALLET ="smart_pallet.latitude";
	public RetailscmChecker checkLatitudeOfSmartPallet(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SMART_PALLET ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_SMART_PALLET ="smart_pallet.longitude";
	public RetailscmChecker checkLongitudeOfSmartPallet(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SMART_PALLET ); 		
		
		return this;
	}	 			

	public static final String  WAREHOUSE_OF_SMART_PALLET ="smart_pallet.warehouse";
	public RetailscmChecker checkWarehouseIdOfSmartPallet(String warehouseId)
	{
		
	 	checkIdOfSmartPallet(warehouseId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SMART_PALLET ="smart_pallet.version";
	public RetailscmChecker checkVersionOfSmartPallet(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SMART_PALLET ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GOODS_SHELF ="goods_shelf.id";
	public RetailscmChecker checkIdOfGoodsShelf(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_SHELF ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_GOODS_SHELF ="goods_shelf.location";
	public RetailscmChecker checkLocationOfGoodsShelf(String location)
	{
		
	 	checkStringLengthRange(location,5, 64,LOCATION_OF_GOODS_SHELF ); 		
		
		return this;
	}	 			

	public static final String  STORAGE_SPACE_OF_GOODS_SHELF ="goods_shelf.storage_space";
	public RetailscmChecker checkStorageSpaceIdOfGoodsShelf(String storageSpaceId)
	{
		
	 	checkIdOfGoodsShelf(storageSpaceId ); 		
		
		return this;
	}	 			

	public static final String  SUPPLIER_SPACE_OF_GOODS_SHELF ="goods_shelf.supplier_space";
	public RetailscmChecker checkSupplierSpaceIdOfGoodsShelf(String supplierSpaceId)
	{
		
	 	checkIdOfGoodsShelf(supplierSpaceId ); 		
		
		return this;
	}	 			

	public static final String  DAMAGE_SPACE_OF_GOODS_SHELF ="goods_shelf.damage_space";
	public RetailscmChecker checkDamageSpaceIdOfGoodsShelf(String damageSpaceId)
	{
		
	 	checkIdOfGoodsShelf(damageSpaceId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GOODS_SHELF ="goods_shelf.version";
	public RetailscmChecker checkVersionOfGoodsShelf(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SHELF ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.id";
	public RetailscmChecker checkIdOfGoodsShelfStockCount(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.title";
	public RetailscmChecker checkTitleOfGoodsShelfStockCount(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	 			

	public static final String  COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.count_time";
	public RetailscmChecker checkCountTimeOfGoodsShelfStockCount(Date countTime)
	{
		
	 	checkDateRange(countTime,parseDate("1900-01-01"), parseDate("2017-04-01"),COUNT_TIME_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	 			

	public static final String  SUMMARY_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.summary";
	public RetailscmChecker checkSummaryOfGoodsShelfStockCount(String summary)
	{
		
	 	checkStringLengthRange(summary,5, 72,SUMMARY_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	 			

	public static final String  SHELF_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.shelf";
	public RetailscmChecker checkShelfIdOfGoodsShelfStockCount(String shelfId)
	{
		
	 	checkIdOfGoodsShelfStockCount(shelfId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GOODS_SHELF_STOCK_COUNT ="goods_shelf_stock_count.version";
	public RetailscmChecker checkVersionOfGoodsShelfStockCount(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.id";
	public RetailscmChecker checkIdOfStockCountIssueTrack(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.title";
	public RetailscmChecker checkTitleOfStockCountIssueTrack(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	 			

	public static final String  COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.count_time";
	public RetailscmChecker checkCountTimeOfStockCountIssueTrack(Date countTime)
	{
		
	 	checkDateRange(countTime,parseDate("1900-01-01"), parseDate("2017-04-01"),COUNT_TIME_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	 			

	public static final String  SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.summary";
	public RetailscmChecker checkSummaryOfStockCountIssueTrack(String summary)
	{
		
	 	checkStringLengthRange(summary,3, 40,SUMMARY_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	 			

	public static final String  STOCK_COUNT_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.stock_count";
	public RetailscmChecker checkStockCountIdOfStockCountIssueTrack(String stockCountId)
	{
		
	 	checkIdOfStockCountIssueTrack(stockCountId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_STOCK_COUNT_ISSUE_TRACK ="stock_count_issue_track.version";
	public RetailscmChecker checkVersionOfStockCountIssueTrack(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GOODS_ALLOCATION ="goods_allocation.id";
	public RetailscmChecker checkIdOfGoodsAllocation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_GOODS_ALLOCATION ="goods_allocation.location";
	public RetailscmChecker checkLocationOfGoodsAllocation(String location)
	{
		
	 	checkStringLengthRange(location,6, 84,LOCATION_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_GOODS_ALLOCATION ="goods_allocation.latitude";
	public RetailscmChecker checkLatitudeOfGoodsAllocation(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_GOODS_ALLOCATION ="goods_allocation.longitude";
	public RetailscmChecker checkLongitudeOfGoodsAllocation(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	 			

	public static final String  GOODS_SHELF_OF_GOODS_ALLOCATION ="goods_allocation.goods_shelf";
	public RetailscmChecker checkGoodsShelfIdOfGoodsAllocation(String goodsShelfId)
	{
		
	 	checkIdOfGoodsAllocation(goodsShelfId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GOODS_ALLOCATION ="goods_allocation.version";
	public RetailscmChecker checkVersionOfGoodsAllocation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_ALLOCATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GOODS ="goods.id";
	public RetailscmChecker checkIdOfGoods(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_GOODS ="goods.name";
	public RetailscmChecker checkNameOfGoods(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_GOODS ); 		
		
		return this;
	}	 			

	public static final String  RFID_OF_GOODS ="goods.rfid";
	public RetailscmChecker checkRfidOfGoods(String rfid)
	{
		
	 	checkStringLengthRange(rfid,2, 28,RFID_OF_GOODS ); 		
		
		return this;
	}	 			

	public static final String  UOM_OF_GOODS ="goods.uom";
	public RetailscmChecker checkUomOfGoods(String uom)
	{
		
	 	checkStringLengthRange(uom,0, 4,UOM_OF_GOODS ); 		
		
		return this;
	}	 			

	public static final String  MAX_PACKAGE_OF_GOODS ="goods.max_package";
	public RetailscmChecker checkMaxPackageOfGoods(int maxPackage)
	{
		
	 	checkIntegerRange(maxPackage,0, 10,MAX_PACKAGE_OF_GOODS ); 		
		
		return this;
	}	 			

	public static final String  EXPIRE_TIME_OF_GOODS ="goods.expire_time";
	public RetailscmChecker checkExpireTimeOfGoods(Date expireTime)
	{
		
	 	checkDateRange(expireTime,parseDate("1900-01-01"), parseDate("2019-09-09"),EXPIRE_TIME_OF_GOODS ); 		
		
		return this;
	}	 			

	public static final String  SKU_OF_GOODS ="goods.sku";
	public RetailscmChecker checkSkuIdOfGoods(String skuId)
	{
		
	 	checkIdOfGoods(skuId ); 		
		
		return this;
	}	 			

	public static final String  RECEIVING_SPACE_OF_GOODS ="goods.receiving_space";
	public RetailscmChecker checkReceivingSpaceIdOfGoods(String receivingSpaceId)
	{
		
	 	checkIdOfGoods(receivingSpaceId ); 		
		
		return this;
	}	 			

	public static final String  GOODS_ALLOCATION_OF_GOODS ="goods.goods_allocation";
	public RetailscmChecker checkGoodsAllocationIdOfGoods(String goodsAllocationId)
	{
		
	 	checkIdOfGoods(goodsAllocationId ); 		
		
		return this;
	}	 			

	public static final String  SMART_PALLET_OF_GOODS ="goods.smart_pallet";
	public RetailscmChecker checkSmartPalletIdOfGoods(String smartPalletId)
	{
		
	 	checkIdOfGoods(smartPalletId ); 		
		
		return this;
	}	 			

	public static final String  SHIPPING_SPACE_OF_GOODS ="goods.shipping_space";
	public RetailscmChecker checkShippingSpaceIdOfGoods(String shippingSpaceId)
	{
		
	 	checkIdOfGoods(shippingSpaceId ); 		
		
		return this;
	}	 			

	public static final String  TRANSPORT_TASK_OF_GOODS ="goods.transport_task";
	public RetailscmChecker checkTransportTaskIdOfGoods(String transportTaskId)
	{
		
	 	checkIdOfGoods(transportTaskId ); 		
		
		return this;
	}	 			

	public static final String  RETAIL_STORE_OF_GOODS ="goods.retail_store";
	public RetailscmChecker checkRetailStoreIdOfGoods(String retailStoreId)
	{
		
	 	checkIdOfGoods(retailStoreId ); 		
		
		return this;
	}	 			

	public static final String  BIZ_ORDER_OF_GOODS ="goods.biz_order";
	public RetailscmChecker checkBizOrderIdOfGoods(String bizOrderId)
	{
		
	 	checkIdOfGoods(bizOrderId ); 		
		
		return this;
	}	 			

	public static final String  RETAIL_STORE_ORDER_OF_GOODS ="goods.retail_store_order";
	public RetailscmChecker checkRetailStoreOrderIdOfGoods(String retailStoreOrderId)
	{
		
	 	checkIdOfGoods(retailStoreOrderId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GOODS ="goods.version";
	public RetailscmChecker checkVersionOfGoods(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GOODS_PACKAGING ="goods_packaging.id";
	public RetailscmChecker checkIdOfGoodsPackaging(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	 			

	public static final String  PACKAGE_NAME_OF_GOODS_PACKAGING ="goods_packaging.package_name";
	public RetailscmChecker checkPackageNameOfGoodsPackaging(String packageName)
	{
		
	 	checkStringLengthRange(packageName,1, 12,PACKAGE_NAME_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	 			

	public static final String  RFID_OF_GOODS_PACKAGING ="goods_packaging.rfid";
	public RetailscmChecker checkRfidOfGoodsPackaging(String rfid)
	{
		
	 	checkStringLengthRange(rfid,2, 28,RFID_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	 			

	public static final String  PACKAGE_TIME_OF_GOODS_PACKAGING ="goods_packaging.package_time";
	public RetailscmChecker checkPackageTimeOfGoodsPackaging(Date packageTime)
	{
		
	 	checkDateRange(packageTime,parseDate("1900-01-01"), parseDate("2017-09-09"),PACKAGE_TIME_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GOODS_PACKAGING ="goods_packaging.description";
	public RetailscmChecker checkDescriptionOfGoodsPackaging(String description)
	{
		
	 	checkStringLengthRange(description,3, 36,DESCRIPTION_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GOODS_PACKAGING ="goods_packaging.version";
	public RetailscmChecker checkVersionOfGoodsPackaging(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_PACKAGING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GOODS_MOVEMENT ="goods_movement.id";
	public RetailscmChecker checkIdOfGoodsMovement(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  MOVE_TIME_OF_GOODS_MOVEMENT ="goods_movement.move_time";
	public RetailscmChecker checkMoveTimeOfGoodsMovement(DateTime moveTime)
	{
		
	 	checkDateTime(moveTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2017-08-09T09:09:09"),MOVE_TIME_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  FACILITY_OF_GOODS_MOVEMENT ="goods_movement.facility";
	public RetailscmChecker checkFacilityOfGoodsMovement(String facility)
	{
		
	 	checkStringLengthRange(facility,1, 16,FACILITY_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  FACILITY_ID_OF_GOODS_MOVEMENT ="goods_movement.facility_id";
	public RetailscmChecker checkFacilityIdOfGoodsMovement(String facilityId)
	{
		
	 	checkStringLengthRange(facilityId,1, 16,FACILITY_ID_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  FROM_IP_OF_GOODS_MOVEMENT ="goods_movement.from_ip";
	public RetailscmChecker checkFromIpOfGoodsMovement(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,4, 48,FROM_IP_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  USER_AGENT_OF_GOODS_MOVEMENT ="goods_movement.user_agent";
	public RetailscmChecker checkUserAgentOfGoodsMovement(String userAgent)
	{
		
	 	checkStringLengthRange(userAgent,28, 444,USER_AGENT_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  SESSION_ID_OF_GOODS_MOVEMENT ="goods_movement.session_id";
	public RetailscmChecker checkSessionIdOfGoodsMovement(String sessionId)
	{
		
	 	checkStringLengthRange(sessionId,6, 80,SESSION_ID_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_GOODS_MOVEMENT ="goods_movement.latitude";
	public RetailscmChecker checkLatitudeOfGoodsMovement(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_GOODS_MOVEMENT ="goods_movement.longitude";
	public RetailscmChecker checkLongitudeOfGoodsMovement(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  GOODS_OF_GOODS_MOVEMENT ="goods_movement.goods";
	public RetailscmChecker checkGoodsIdOfGoodsMovement(String goodsId)
	{
		
	 	checkIdOfGoodsMovement(goodsId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GOODS_MOVEMENT ="goods_movement.version";
	public RetailscmChecker checkVersionOfGoodsMovement(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GOODS_MOVEMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SUPPLIER_SPACE ="supplier_space.id";
	public RetailscmChecker checkIdOfSupplierSpace(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_SUPPLIER_SPACE ="supplier_space.location";
	public RetailscmChecker checkLocationOfSupplierSpace(String location)
	{
		
	 	checkStringLengthRange(location,5, 76,LOCATION_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_SUPPLIER_SPACE ="supplier_space.contact_number";
	public RetailscmChecker checkContactNumberOfSupplierSpace(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AREA_OF_SUPPLIER_SPACE ="supplier_space.total_area";
	public RetailscmChecker checkTotalAreaOfSupplierSpace(String totalArea)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	 			

	public static final String  WAREHOUSE_OF_SUPPLIER_SPACE ="supplier_space.warehouse";
	public RetailscmChecker checkWarehouseIdOfSupplierSpace(String warehouseId)
	{
		
	 	checkIdOfSupplierSpace(warehouseId ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_SUPPLIER_SPACE ="supplier_space.latitude";
	public RetailscmChecker checkLatitudeOfSupplierSpace(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_SUPPLIER_SPACE ="supplier_space.longitude";
	public RetailscmChecker checkLongitudeOfSupplierSpace(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SUPPLIER_SPACE ="supplier_space.version";
	public RetailscmChecker checkVersionOfSupplierSpace(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SUPPLIER_SPACE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RECEIVING_SPACE ="receiving_space.id";
	public RetailscmChecker checkIdOfReceivingSpace(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_RECEIVING_SPACE ="receiving_space.location";
	public RetailscmChecker checkLocationOfReceivingSpace(String location)
	{
		
	 	checkStringLengthRange(location,5, 64,LOCATION_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_RECEIVING_SPACE ="receiving_space.contact_number";
	public RetailscmChecker checkContactNumberOfReceivingSpace(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_RECEIVING_SPACE ="receiving_space.description";
	public RetailscmChecker checkDescriptionOfReceivingSpace(String description)
	{
		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AREA_OF_RECEIVING_SPACE ="receiving_space.total_area";
	public RetailscmChecker checkTotalAreaOfReceivingSpace(String totalArea)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  WAREHOUSE_OF_RECEIVING_SPACE ="receiving_space.warehouse";
	public RetailscmChecker checkWarehouseIdOfReceivingSpace(String warehouseId)
	{
		
	 	checkIdOfReceivingSpace(warehouseId ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_RECEIVING_SPACE ="receiving_space.latitude";
	public RetailscmChecker checkLatitudeOfReceivingSpace(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_RECEIVING_SPACE ="receiving_space.longitude";
	public RetailscmChecker checkLongitudeOfReceivingSpace(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RECEIVING_SPACE ="receiving_space.version";
	public RetailscmChecker checkVersionOfReceivingSpace(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RECEIVING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SHIPPING_SPACE ="shipping_space.id";
	public RetailscmChecker checkIdOfShippingSpace(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_SHIPPING_SPACE ="shipping_space.location";
	public RetailscmChecker checkLocationOfShippingSpace(String location)
	{
		
	 	checkStringLengthRange(location,4, 56,LOCATION_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_SHIPPING_SPACE ="shipping_space.contact_number";
	public RetailscmChecker checkContactNumberOfShippingSpace(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AREA_OF_SHIPPING_SPACE ="shipping_space.total_area";
	public RetailscmChecker checkTotalAreaOfShippingSpace(String totalArea)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  WAREHOUSE_OF_SHIPPING_SPACE ="shipping_space.warehouse";
	public RetailscmChecker checkWarehouseIdOfShippingSpace(String warehouseId)
	{
		
	 	checkIdOfShippingSpace(warehouseId ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_SHIPPING_SPACE ="shipping_space.latitude";
	public RetailscmChecker checkLatitudeOfShippingSpace(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_SHIPPING_SPACE ="shipping_space.longitude";
	public RetailscmChecker checkLongitudeOfShippingSpace(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_SHIPPING_SPACE ="shipping_space.description";
	public RetailscmChecker checkDescriptionOfShippingSpace(String description)
	{
		
	 	checkStringLengthRange(description,4, 52,DESCRIPTION_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SHIPPING_SPACE ="shipping_space.version";
	public RetailscmChecker checkVersionOfShippingSpace(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SHIPPING_SPACE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_DAMAGE_SPACE ="damage_space.id";
	public RetailscmChecker checkIdOfDamageSpace(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_DAMAGE_SPACE ="damage_space.location";
	public RetailscmChecker checkLocationOfDamageSpace(String location)
	{
		
	 	checkStringLengthRange(location,6, 80,LOCATION_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_DAMAGE_SPACE ="damage_space.contact_number";
	public RetailscmChecker checkContactNumberOfDamageSpace(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  TOTAL_AREA_OF_DAMAGE_SPACE ="damage_space.total_area";
	public RetailscmChecker checkTotalAreaOfDamageSpace(String totalArea)
	{
		
	 	checkStringLengthRange(totalArea,2, 28,TOTAL_AREA_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_DAMAGE_SPACE ="damage_space.latitude";
	public RetailscmChecker checkLatitudeOfDamageSpace(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_DAMAGE_SPACE ="damage_space.longitude";
	public RetailscmChecker checkLongitudeOfDamageSpace(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  WAREHOUSE_OF_DAMAGE_SPACE ="damage_space.warehouse";
	public RetailscmChecker checkWarehouseIdOfDamageSpace(String warehouseId)
	{
		
	 	checkIdOfDamageSpace(warehouseId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_DAMAGE_SPACE ="damage_space.version";
	public RetailscmChecker checkVersionOfDamageSpace(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_DAMAGE_SPACE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_WAREHOUSE_ASSET ="warehouse_asset.id";
	public RetailscmChecker checkIdOfWarehouseAsset(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_WAREHOUSE_ASSET ="warehouse_asset.name";
	public RetailscmChecker checkNameOfWarehouseAsset(String name)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	 			

	public static final String  POSITION_OF_WAREHOUSE_ASSET ="warehouse_asset.position";
	public RetailscmChecker checkPositionOfWarehouseAsset(String position)
	{
		
	 	checkStringLengthRange(position,3, 40,POSITION_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_WAREHOUSE_ASSET ="warehouse_asset.owner";
	public RetailscmChecker checkOwnerIdOfWarehouseAsset(String ownerId)
	{
		
	 	checkIdOfWarehouseAsset(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_WAREHOUSE_ASSET ="warehouse_asset.version";
	public RetailscmChecker checkVersionOfWarehouseAsset(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WAREHOUSE_ASSET ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_FLEET ="transport_fleet.id";
	public RetailscmChecker checkIdOfTransportFleet(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_FLEET ="transport_fleet.name";
	public RetailscmChecker checkNameOfTransportFleet(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_TRANSPORT_FLEET ="transport_fleet.contact_number";
	public RetailscmChecker checkContactNumberOfTransportFleet(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_TRANSPORT_FLEET ="transport_fleet.owner";
	public RetailscmChecker checkOwnerIdOfTransportFleet(String ownerId)
	{
		
	 	checkIdOfTransportFleet(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_FLEET ="transport_fleet.version";
	public RetailscmChecker checkVersionOfTransportFleet(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_FLEET ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_TRUCK ="transport_truck.id";
	public RetailscmChecker checkIdOfTransportTruck(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_TRUCK ="transport_truck.name";
	public RetailscmChecker checkNameOfTransportTruck(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  PLATE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.plate_number";
	public RetailscmChecker checkPlateNumberOfTransportTruck(String plateNumber)
	{
		
	 	checkStringLengthRange(plateNumber,2, 16,PLATE_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.contact_number";
	public RetailscmChecker checkContactNumberOfTransportTruck(String contactNumber)
	{
		
	 	checkStringLengthRange(contactNumber,3, 44,CONTACT_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.vehicle_license_number";
	public RetailscmChecker checkVehicleLicenseNumberOfTransportTruck(String vehicleLicenseNumber)
	{
		
	 	checkStringLengthRange(vehicleLicenseNumber,2, 24,VEHICLE_LICENSE_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  ENGINE_NUMBER_OF_TRANSPORT_TRUCK ="transport_truck.engine_number";
	public RetailscmChecker checkEngineNumberOfTransportTruck(String engineNumber)
	{
		
	 	checkStringLengthRange(engineNumber,2, 28,ENGINE_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_TRANSPORT_TRUCK ="transport_truck.make_date";
	public RetailscmChecker checkMakeDateOfTransportTruck(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2010-09-09"),MAKE_DATE_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  MILEAGE_OF_TRANSPORT_TRUCK ="transport_truck.mileage";
	public RetailscmChecker checkMileageOfTransportTruck(String mileage)
	{
		
	 	checkStringLengthRange(mileage,2, 24,MILEAGE_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  BODY_COLOR_OF_TRANSPORT_TRUCK ="transport_truck.body_color";
	public RetailscmChecker checkBodyColorOfTransportTruck(String bodyColor)
	{
		
	 	checkStringLengthRange(bodyColor,1, 8,BODY_COLOR_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  OWNER_OF_TRANSPORT_TRUCK ="transport_truck.owner";
	public RetailscmChecker checkOwnerIdOfTransportTruck(String ownerId)
	{
		
	 	checkIdOfTransportTruck(ownerId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_TRUCK ="transport_truck.version";
	public RetailscmChecker checkVersionOfTransportTruck(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TRUCK ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRUCK_DRIVER ="truck_driver.id";
	public RetailscmChecker checkIdOfTruckDriver(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRUCK_DRIVER ="truck_driver.name";
	public RetailscmChecker checkNameOfTruckDriver(String name)
	{
		
	 	checkStringLengthRange(name,2, 24,NAME_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	 			

	public static final String  DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER ="truck_driver.driver_license_number";
	public RetailscmChecker checkDriverLicenseNumberOfTruckDriver(String driverLicenseNumber)
	{
		
	 	checkStringLengthRange(driverLicenseNumber,3, 44,DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	 			

	public static final String  CONTACT_NUMBER_OF_TRUCK_DRIVER ="truck_driver.contact_number";
	public RetailscmChecker checkContactNumberOfTruckDriver(String contactNumber)
	{
		
	 	checkChinaMobilePhone(contactNumber,5, 44,CONTACT_NUMBER_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_TRUCK_DRIVER ="truck_driver.belongs_to";
	public RetailscmChecker checkBelongsToIdOfTruckDriver(String belongsToId)
	{
		
	 	checkIdOfTruckDriver(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRUCK_DRIVER ="truck_driver.version";
	public RetailscmChecker checkVersionOfTruckDriver(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRUCK_DRIVER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_TASK ="transport_task.id";
	public RetailscmChecker checkIdOfTransportTask(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRANSPORT_TASK ="transport_task.name";
	public RetailscmChecker checkNameOfTransportTask(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  START_OF_TRANSPORT_TASK ="transport_task.start";
	public RetailscmChecker checkStartOfTransportTask(String start)
	{
		
	 	checkStringLengthRange(start,2, 20,START_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  BEGIN_TIME_OF_TRANSPORT_TASK ="transport_task.begin_time";
	public RetailscmChecker checkBeginTimeOfTransportTask(Date beginTime)
	{
		
	 	checkDatePast(beginTime,parseDate("1900-01-01"), new Date(),BEGIN_TIME_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  END_OF_TRANSPORT_TASK ="transport_task.end";
	public RetailscmChecker checkEndIdOfTransportTask(String endId)
	{
		
	 	checkIdOfTransportTask(endId ); 		
		
		return this;
	}	 			

	public static final String  DRIVER_OF_TRANSPORT_TASK ="transport_task.driver";
	public RetailscmChecker checkDriverIdOfTransportTask(String driverId)
	{
		
	 	checkIdOfTransportTask(driverId ); 		
		
		return this;
	}	 			

	public static final String  TRUCK_OF_TRANSPORT_TASK ="transport_task.truck";
	public RetailscmChecker checkTruckIdOfTransportTask(String truckId)
	{
		
	 	checkIdOfTransportTask(truckId ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_TRANSPORT_TASK ="transport_task.belongs_to";
	public RetailscmChecker checkBelongsToIdOfTransportTask(String belongsToId)
	{
		
	 	checkIdOfTransportTask(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_TRANSPORT_TASK ="transport_task.latitude";
	public RetailscmChecker checkLatitudeOfTransportTask(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_TRANSPORT_TASK ="transport_task.longitude";
	public RetailscmChecker checkLongitudeOfTransportTask(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_TASK ="transport_task.version";
	public RetailscmChecker checkVersionOfTransportTask(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRANSPORT_TASK_TRACK ="transport_task_track.id";
	public RetailscmChecker checkIdOfTransportTaskTrack(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  TRACK_TIME_OF_TRANSPORT_TASK_TRACK ="transport_task_track.track_time";
	public RetailscmChecker checkTrackTimeOfTransportTaskTrack(Date trackTime)
	{
		
	 	checkDatePast(trackTime,parseDate("1900-01-01"), new Date(),TRACK_TIME_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  LATITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.latitude";
	public RetailscmChecker checkLatitudeOfTransportTaskTrack(BigDecimal latitude)
	{
		
	 	checkBigDecimalRange(latitude,-90.0, 90.0,LATITUDE_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  LONGITUDE_OF_TRANSPORT_TASK_TRACK ="transport_task_track.longitude";
	public RetailscmChecker checkLongitudeOfTransportTaskTrack(BigDecimal longitude)
	{
		
	 	checkBigDecimalRange(longitude,-180.0, 180.0,LONGITUDE_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  MOVEMENT_OF_TRANSPORT_TASK_TRACK ="transport_task_track.movement";
	public RetailscmChecker checkMovementIdOfTransportTaskTrack(String movementId)
	{
		
	 	checkIdOfTransportTaskTrack(movementId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRANSPORT_TASK_TRACK ="transport_task_track.version";
	public RetailscmChecker checkVersionOfTransportTaskTrack(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRANSPORT_TASK_TRACK ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNT_SET ="account_set.id";
	public RetailscmChecker checkIdOfAccountSet(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_ACCOUNT_SET ="account_set.name";
	public RetailscmChecker checkNameOfAccountSet(String name)
	{
		
	 	checkStringLengthRange(name,3, 24,NAME_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  YEAR_SET_OF_ACCOUNT_SET ="account_set.year_set";
	public RetailscmChecker checkYearSetOfAccountSet(String yearSet)
	{
		
	 	checkStringLengthRange(yearSet,2, 20,YEAR_SET_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  EFFECTIVE_DATE_OF_ACCOUNT_SET ="account_set.effective_date";
	public RetailscmChecker checkEffectiveDateOfAccountSet(Date effectiveDate)
	{
		
	 	checkDateRange(effectiveDate,parseDate("1900-01-01"), parseDate("2017-05-28"),EFFECTIVE_DATE_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_SYSTEM_OF_ACCOUNT_SET ="account_set.accounting_system";
	public RetailscmChecker checkAccountingSystemOfAccountSet(String accountingSystem)
	{
		
	 	checkStringLengthRange(accountingSystem,3, 28,ACCOUNTING_SYSTEM_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET ="account_set.domestic_currency_code";
	public RetailscmChecker checkDomesticCurrencyCodeOfAccountSet(String domesticCurrencyCode)
	{
		
	 	checkStringLengthRange(domesticCurrencyCode,1, 12,DOMESTIC_CURRENCY_CODE_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET ="account_set.domestic_currency_name";
	public RetailscmChecker checkDomesticCurrencyNameOfAccountSet(String domesticCurrencyName)
	{
		
	 	checkStringLengthRange(domesticCurrencyName,1, 12,DOMESTIC_CURRENCY_NAME_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  OPENING_BANK_OF_ACCOUNT_SET ="account_set.opening_bank";
	public RetailscmChecker checkOpeningBankOfAccountSet(String openingBank)
	{
		
	 	checkStringLengthRange(openingBank,2, 16,OPENING_BANK_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNT_NUMBER_OF_ACCOUNT_SET ="account_set.account_number";
	public RetailscmChecker checkAccountNumberOfAccountSet(String accountNumber)
	{
		
	 	checkStringLengthRange(accountNumber,4, 56,ACCOUNT_NUMBER_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  COUNTRY_CENTER_OF_ACCOUNT_SET ="account_set.country_center";
	public RetailscmChecker checkCountryCenterIdOfAccountSet(String countryCenterId)
	{
		
	 	checkIdOfAccountSet(countryCenterId ); 		
		
		return this;
	}	 			

	public static final String  RETAIL_STORE_OF_ACCOUNT_SET ="account_set.retail_store";
	public RetailscmChecker checkRetailStoreIdOfAccountSet(String retailStoreId)
	{
		
	 	checkIdOfAccountSet(retailStoreId ); 		
		
		return this;
	}	 			

	public static final String  GOODS_SUPPLIER_OF_ACCOUNT_SET ="account_set.goods_supplier";
	public RetailscmChecker checkGoodsSupplierIdOfAccountSet(String goodsSupplierId)
	{
		
	 	checkIdOfAccountSet(goodsSupplierId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNT_SET ="account_set.version";
	public RetailscmChecker checkVersionOfAccountSet(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNT_SET ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_SUBJECT ="accounting_subject.id";
	public RetailscmChecker checkIdOfAccountingSubject(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_code";
	public RetailscmChecker checkAccountingSubjectCodeOfAccountingSubject(String accountingSubjectCode)
	{
		
	 	checkStringLengthRange(accountingSubjectCode,2, 24,ACCOUNTING_SUBJECT_CODE_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_name";
	public RetailscmChecker checkAccountingSubjectNameOfAccountingSubject(String accountingSubjectName)
	{
		
	 	checkStringLengthRange(accountingSubjectName,2, 16,ACCOUNTING_SUBJECT_NAME_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_code";
	public RetailscmChecker checkAccountingSubjectClassCodeOfAccountingSubject(int accountingSubjectClassCode)
	{
		
	 	checkIntegerRange(accountingSubjectClassCode,0, 6,ACCOUNTING_SUBJECT_CLASS_CODE_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT ="accounting_subject.accounting_subject_class_name";
	public RetailscmChecker checkAccountingSubjectClassNameOfAccountingSubject(String accountingSubjectClassName)
	{
		
	 	checkStringLengthRange(accountingSubjectClassName,1, 24,ACCOUNTING_SUBJECT_CLASS_NAME_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNT_SET_OF_ACCOUNTING_SUBJECT ="accounting_subject.account_set";
	public RetailscmChecker checkAccountSetIdOfAccountingSubject(String accountSetId)
	{
		
	 	checkIdOfAccountingSubject(accountSetId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_SUBJECT ="accounting_subject.version";
	public RetailscmChecker checkVersionOfAccountingSubject(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_SUBJECT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_PERIOD ="accounting_period.id";
	public RetailscmChecker checkIdOfAccountingPeriod(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_ACCOUNTING_PERIOD ="accounting_period.name";
	public RetailscmChecker checkNameOfAccountingPeriod(String name)
	{
		
	 	checkStringLengthRange(name,3, 32,NAME_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	 			

	public static final String  START_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.start_date";
	public RetailscmChecker checkStartDateOfAccountingPeriod(Date startDate)
	{
		
	 	checkDateRange(startDate,parseDate("1900-01-01"), parseDate("2017-01-09"),START_DATE_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	 			

	public static final String  END_DATE_OF_ACCOUNTING_PERIOD ="accounting_period.end_date";
	public RetailscmChecker checkEndDateOfAccountingPeriod(Date endDate)
	{
		
	 	checkDateRange(endDate,parseDate("1900-01-01"), parseDate("2017-01-09"),END_DATE_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNT_SET_OF_ACCOUNTING_PERIOD ="accounting_period.account_set";
	public RetailscmChecker checkAccountSetIdOfAccountingPeriod(String accountSetId)
	{
		
	 	checkIdOfAccountingPeriod(accountSetId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_PERIOD ="accounting_period.version";
	public RetailscmChecker checkVersionOfAccountingPeriod(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_PERIOD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.id";
	public RetailscmChecker checkIdOfAccountingDocumentType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.name";
	public RetailscmChecker checkNameOfAccountingDocumentType(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.description";
	public RetailscmChecker checkDescriptionOfAccountingDocumentType(String description)
	{
		
	 	checkStringLengthRange(description,18, 280,DESCRIPTION_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.accounting_period";
	public RetailscmChecker checkAccountingPeriodIdOfAccountingDocumentType(String accountingPeriodId)
	{
		
	 	checkIdOfAccountingDocumentType(accountingPeriodId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_TYPE ="accounting_document_type.version";
	public RetailscmChecker checkVersionOfAccountingDocumentType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_DOCUMENT ="accounting_document.id";
	public RetailscmChecker checkIdOfAccountingDocument(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_ACCOUNTING_DOCUMENT ="accounting_document.name";
	public RetailscmChecker checkNameOfAccountingDocument(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT ="accounting_document.accounting_document_date";
	public RetailscmChecker checkAccountingDocumentDateOfAccountingDocument(Date accountingDocumentDate)
	{
		
	 	checkDateRange(accountingDocumentDate,parseDate("1900-01-01"), parseDate("2018-09-09"),ACCOUNTING_DOCUMENT_DATE_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_PERIOD_OF_ACCOUNTING_DOCUMENT ="accounting_document.accounting_period";
	public RetailscmChecker checkAccountingPeriodIdOfAccountingDocument(String accountingPeriodId)
	{
		
	 	checkIdOfAccountingDocument(accountingPeriodId ); 		
		
		return this;
	}	 			

	public static final String  DOCUMENT_TYPE_OF_ACCOUNTING_DOCUMENT ="accounting_document.document_type";
	public RetailscmChecker checkDocumentTypeIdOfAccountingDocument(String documentTypeId)
	{
		
	 	checkIdOfAccountingDocument(documentTypeId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT ="accounting_document.version";
	public RetailscmChecker checkVersionOfAccountingDocument(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.id";
	public RetailscmChecker checkIdOfAccountingDocumentCreation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.who";
	public RetailscmChecker checkWhoOfAccountingDocumentCreation(String who)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.comments";
	public RetailscmChecker checkCommentsOfAccountingDocumentCreation(String comments)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.make_date";
	public RetailscmChecker checkMakeDateOfAccountingDocumentCreation(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CREATION ="accounting_document_creation.version";
	public RetailscmChecker checkVersionOfAccountingDocumentCreation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_CREATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.id";
	public RetailscmChecker checkIdOfAccountingDocumentConfirmation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.who";
	public RetailscmChecker checkWhoOfAccountingDocumentConfirmation(String who)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.comments";
	public RetailscmChecker checkCommentsOfAccountingDocumentConfirmation(String comments)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.make_date";
	public RetailscmChecker checkMakeDateOfAccountingDocumentConfirmation(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ="accounting_document_confirmation.version";
	public RetailscmChecker checkVersionOfAccountingDocumentConfirmation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.id";
	public RetailscmChecker checkIdOfAccountingDocumentAuditing(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.who";
	public RetailscmChecker checkWhoOfAccountingDocumentAuditing(String who)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.comments";
	public RetailscmChecker checkCommentsOfAccountingDocumentAuditing(String comments)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.make_date";
	public RetailscmChecker checkMakeDateOfAccountingDocumentAuditing(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING ="accounting_document_auditing.version";
	public RetailscmChecker checkVersionOfAccountingDocumentAuditing(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.id";
	public RetailscmChecker checkIdOfAccountingDocumentPosting(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.who";
	public RetailscmChecker checkWhoOfAccountingDocumentPosting(String who)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.comments";
	public RetailscmChecker checkCommentsOfAccountingDocumentPosting(String comments)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.make_date";
	public RetailscmChecker checkMakeDateOfAccountingDocumentPosting(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_POSTING ="accounting_document_posting.version";
	public RetailscmChecker checkVersionOfAccountingDocumentPosting(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_POSTING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ORIGINAL_VOUCHER ="original_voucher.id";
	public RetailscmChecker checkIdOfOriginalVoucher(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_ORIGINAL_VOUCHER ="original_voucher.title";
	public RetailscmChecker checkTitleOfOriginalVoucher(String title)
	{
		
	 	checkStringLengthRange(title,2, 28,TITLE_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	 			

	public static final String  MADE_BY_OF_ORIGINAL_VOUCHER ="original_voucher.made_by";
	public RetailscmChecker checkMadeByOfOriginalVoucher(String madeBy)
	{
		
	 	checkStringLengthRange(madeBy,1, 12,MADE_BY_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	 			

	public static final String  RECEIVED_BY_OF_ORIGINAL_VOUCHER ="original_voucher.received_by";
	public RetailscmChecker checkReceivedByOfOriginalVoucher(String receivedBy)
	{
		
	 	checkStringLengthRange(receivedBy,1, 12,RECEIVED_BY_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	 			

	public static final String  VOUCHER_TYPE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_type";
	public RetailscmChecker checkVoucherTypeOfOriginalVoucher(String voucherType)
	{
		
	 	checkStringLengthRange(voucherType,1, 16,VOUCHER_TYPE_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	 			

	public static final String  VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER ="original_voucher.voucher_image";
	public RetailscmChecker checkVoucherImageOfOriginalVoucher(String voucherImage)
	{
		
	 	checkImage(voucherImage,0, 512,VOUCHER_IMAGE_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_ORIGINAL_VOUCHER ="original_voucher.belongs_to";
	public RetailscmChecker checkBelongsToIdOfOriginalVoucher(String belongsToId)
	{
		
	 	checkIdOfOriginalVoucher(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ORIGINAL_VOUCHER ="original_voucher.version";
	public RetailscmChecker checkVersionOfOriginalVoucher(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.id";
	public RetailscmChecker checkIdOfOriginalVoucherCreation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.who";
	public RetailscmChecker checkWhoOfOriginalVoucherCreation(String who)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.comments";
	public RetailscmChecker checkCommentsOfOriginalVoucherCreation(String comments)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.make_date";
	public RetailscmChecker checkMakeDateOfOriginalVoucherCreation(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CREATION ="original_voucher_creation.version";
	public RetailscmChecker checkVersionOfOriginalVoucherCreation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_CREATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.id";
	public RetailscmChecker checkIdOfOriginalVoucherConfirmation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.who";
	public RetailscmChecker checkWhoOfOriginalVoucherConfirmation(String who)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.comments";
	public RetailscmChecker checkCommentsOfOriginalVoucherConfirmation(String comments)
	{
		
	 	checkStringLengthRange(comments,2, 16,COMMENTS_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.make_date";
	public RetailscmChecker checkMakeDateOfOriginalVoucherConfirmation(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION ="original_voucher_confirmation.version";
	public RetailscmChecker checkVersionOfOriginalVoucherConfirmation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_CONFIRMATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.id";
	public RetailscmChecker checkIdOfOriginalVoucherAuditing(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.who";
	public RetailscmChecker checkWhoOfOriginalVoucherAuditing(String who)
	{
		
	 	checkStringLengthRange(who,2, 16,WHO_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.comments";
	public RetailscmChecker checkCommentsOfOriginalVoucherAuditing(String comments)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.make_date";
	public RetailscmChecker checkMakeDateOfOriginalVoucherAuditing(Date makeDate)
	{
		
	 	checkDateRange(makeDate,parseDate("1900-01-01"), parseDate("2017-09-09"),MAKE_DATE_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ORIGINAL_VOUCHER_AUDITING ="original_voucher_auditing.version";
	public RetailscmChecker checkVersionOfOriginalVoucherAuditing(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ORIGINAL_VOUCHER_AUDITING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.id";
	public RetailscmChecker checkIdOfAccountingDocumentLine(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.name";
	public RetailscmChecker checkNameOfAccountingDocumentLine(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.code";
	public RetailscmChecker checkCodeOfAccountingDocumentLine(String code)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	 			

	public static final String  DIRECT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.direct";
	public RetailscmChecker checkDirectOfAccountingDocumentLine(String direct)
	{
		
	 	checkStringLengthRange(direct,0, 4,DIRECT_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.amount";
	public RetailscmChecker checkAmountOfAccountingDocumentLine(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 989127.99,AMOUNT_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.belongs_to";
	public RetailscmChecker checkBelongsToIdOfAccountingDocumentLine(String belongsToId)
	{
		
	 	checkIdOfAccountingDocumentLine(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  ACCOUNTING_SUBJECT_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.accounting_subject";
	public RetailscmChecker checkAccountingSubjectIdOfAccountingDocumentLine(String accountingSubjectId)
	{
		
	 	checkIdOfAccountingDocumentLine(accountingSubjectId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.version";
	public RetailscmChecker checkVersionOfAccountingDocumentLine(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.id";
	public RetailscmChecker checkIdOfLevelOneDepartment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.belongs_to";
	public RetailscmChecker checkBelongsToIdOfLevelOneDepartment(String belongsToId)
	{
		
	 	checkIdOfLevelOneDepartment(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.name";
	public RetailscmChecker checkNameOfLevelOneDepartment(String name)
	{
		
	 	checkStringLengthRange(name,1, 20,NAME_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.description";
	public RetailscmChecker checkDescriptionOfLevelOneDepartment(String description)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  MANAGER_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.manager";
	public RetailscmChecker checkManagerOfLevelOneDepartment(String manager)
	{
		
	 	checkStringLengthRange(manager,1, 12,MANAGER_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.founded";
	public RetailscmChecker checkFoundedOfLevelOneDepartment(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_ONE_DEPARTMENT ="level_one_department.version";
	public RetailscmChecker checkVersionOfLevelOneDepartment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_ONE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.id";
	public RetailscmChecker checkIdOfLevelTwoDepartment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.belongs_to";
	public RetailscmChecker checkBelongsToIdOfLevelTwoDepartment(String belongsToId)
	{
		
	 	checkIdOfLevelTwoDepartment(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.name";
	public RetailscmChecker checkNameOfLevelTwoDepartment(String name)
	{
		
	 	checkStringLengthRange(name,3, 40,NAME_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.description";
	public RetailscmChecker checkDescriptionOfLevelTwoDepartment(String description)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.founded";
	public RetailscmChecker checkFoundedOfLevelTwoDepartment(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_TWO_DEPARTMENT ="level_two_department.version";
	public RetailscmChecker checkVersionOfLevelTwoDepartment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_TWO_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.id";
	public RetailscmChecker checkIdOfLevelThreeDepartment(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  BELONGS_TO_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.belongs_to";
	public RetailscmChecker checkBelongsToIdOfLevelThreeDepartment(String belongsToId)
	{
		
	 	checkIdOfLevelThreeDepartment(belongsToId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.name";
	public RetailscmChecker checkNameOfLevelThreeDepartment(String name)
	{
		
	 	checkStringLengthRange(name,5, 52,NAME_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.description";
	public RetailscmChecker checkDescriptionOfLevelThreeDepartment(String description)
	{
		
	 	checkStringLengthRange(description,5, 72,DESCRIPTION_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  FOUNDED_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.founded";
	public RetailscmChecker checkFoundedOfLevelThreeDepartment(Date founded)
	{
		
	 	checkDatePast(founded,parseDate("1900-01-01"), new Date(),FOUNDED_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEVEL_THREE_DEPARTMENT ="level_three_department.version";
	public RetailscmChecker checkVersionOfLevelThreeDepartment(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEVEL_THREE_DEPARTMENT ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SKILL_TYPE ="skill_type.id";
	public RetailscmChecker checkIdOfSkillType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SKILL_TYPE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_SKILL_TYPE ="skill_type.code";
	public RetailscmChecker checkCodeOfSkillType(String code)
	{
		
	 	checkStringLengthRange(code,2, 20,CODE_OF_SKILL_TYPE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_SKILL_TYPE ="skill_type.company";
	public RetailscmChecker checkCompanyIdOfSkillType(String companyId)
	{
		
	 	checkIdOfSkillType(companyId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_SKILL_TYPE ="skill_type.description";
	public RetailscmChecker checkDescriptionOfSkillType(String description)
	{
		
	 	checkStringLengthRange(description,1, 24,DESCRIPTION_OF_SKILL_TYPE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SKILL_TYPE ="skill_type.version";
	public RetailscmChecker checkVersionOfSkillType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SKILL_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_RESPONSIBILITY_TYPE ="responsibility_type.id";
	public RetailscmChecker checkIdOfResponsibilityType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_RESPONSIBILITY_TYPE ="responsibility_type.code";
	public RetailscmChecker checkCodeOfResponsibilityType(String code)
	{
		
	 	checkStringLengthRange(code,2, 20,CODE_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_RESPONSIBILITY_TYPE ="responsibility_type.company";
	public RetailscmChecker checkCompanyIdOfResponsibilityType(String companyId)
	{
		
	 	checkIdOfResponsibilityType(companyId ); 		
		
		return this;
	}	 			

	public static final String  BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.base_description";
	public RetailscmChecker checkBaseDescriptionOfResponsibilityType(String baseDescription)
	{
		
	 	checkStringLengthRange(baseDescription,2, 16,BASE_DESCRIPTION_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	 			

	public static final String  DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE ="responsibility_type.detail_description";
	public RetailscmChecker checkDetailDescriptionOfResponsibilityType(String detailDescription)
	{
		
	 	checkStringLengthRange(detailDescription,8, 116,DETAIL_DESCRIPTION_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_RESPONSIBILITY_TYPE ="responsibility_type.version";
	public RetailscmChecker checkVersionOfResponsibilityType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_RESPONSIBILITY_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TERMINATION_REASON ="termination_reason.id";
	public RetailscmChecker checkIdOfTerminationReason(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TERMINATION_REASON ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_TERMINATION_REASON ="termination_reason.code";
	public RetailscmChecker checkCodeOfTerminationReason(String code)
	{
		
	 	checkStringLengthRange(code,2, 28,CODE_OF_TERMINATION_REASON ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_TERMINATION_REASON ="termination_reason.company";
	public RetailscmChecker checkCompanyIdOfTerminationReason(String companyId)
	{
		
	 	checkIdOfTerminationReason(companyId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_TERMINATION_REASON ="termination_reason.description";
	public RetailscmChecker checkDescriptionOfTerminationReason(String description)
	{
		
	 	checkStringLengthRange(description,2, 36,DESCRIPTION_OF_TERMINATION_REASON ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TERMINATION_REASON ="termination_reason.version";
	public RetailscmChecker checkVersionOfTerminationReason(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION_REASON ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TERMINATION_TYPE ="termination_type.id";
	public RetailscmChecker checkIdOfTerminationType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_TERMINATION_TYPE ="termination_type.code";
	public RetailscmChecker checkCodeOfTerminationType(String code)
	{
		
	 	checkStringLengthRange(code,2, 28,CODE_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_TERMINATION_TYPE ="termination_type.company";
	public RetailscmChecker checkCompanyIdOfTerminationType(String companyId)
	{
		
	 	checkIdOfTerminationType(companyId ); 		
		
		return this;
	}	 			

	public static final String  BASE_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.base_description";
	public RetailscmChecker checkBaseDescriptionOfTerminationType(String baseDescription)
	{
		
	 	checkStringLengthRange(baseDescription,1, 16,BASE_DESCRIPTION_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  DETAIL_DESCRIPTION_OF_TERMINATION_TYPE ="termination_type.detail_description";
	public RetailscmChecker checkDetailDescriptionOfTerminationType(String detailDescription)
	{
		
	 	checkStringLengthRange(detailDescription,16, 248,DETAIL_DESCRIPTION_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TERMINATION_TYPE ="termination_type.version";
	public RetailscmChecker checkVersionOfTerminationType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OCCUPATION_TYPE ="occupation_type.id";
	public RetailscmChecker checkIdOfOccupationType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_OCCUPATION_TYPE ="occupation_type.code";
	public RetailscmChecker checkCodeOfOccupationType(String code)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_OCCUPATION_TYPE ="occupation_type.company";
	public RetailscmChecker checkCompanyIdOfOccupationType(String companyId)
	{
		
	 	checkIdOfOccupationType(companyId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.description";
	public RetailscmChecker checkDescriptionOfOccupationType(String description)
	{
		
	 	checkStringLengthRange(description,1, 28,DESCRIPTION_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE ="occupation_type.detail_description";
	public RetailscmChecker checkDetailDescriptionOfOccupationType(String detailDescription)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OCCUPATION_TYPE ="occupation_type.version";
	public RetailscmChecker checkVersionOfOccupationType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OCCUPATION_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LEAVE_TYPE ="leave_type.id";
	public RetailscmChecker checkIdOfLeaveType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LEAVE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_LEAVE_TYPE ="leave_type.code";
	public RetailscmChecker checkCodeOfLeaveType(String code)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_LEAVE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_LEAVE_TYPE ="leave_type.company";
	public RetailscmChecker checkCompanyIdOfLeaveType(String companyId)
	{
		
	 	checkIdOfLeaveType(companyId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LEAVE_TYPE ="leave_type.description";
	public RetailscmChecker checkDescriptionOfLeaveType(String description)
	{
		
	 	checkStringLengthRange(description,1, 16,DESCRIPTION_OF_LEAVE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  DETAIL_DESCRIPTION_OF_LEAVE_TYPE ="leave_type.detail_description";
	public RetailscmChecker checkDetailDescriptionOfLeaveType(String detailDescription)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_LEAVE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LEAVE_TYPE ="leave_type.version";
	public RetailscmChecker checkVersionOfLeaveType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LEAVE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SALARY_GRADE ="salary_grade.id";
	public RetailscmChecker checkIdOfSalaryGrade(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SALARY_GRADE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_SALARY_GRADE ="salary_grade.code";
	public RetailscmChecker checkCodeOfSalaryGrade(String code)
	{
		
	 	checkStringLengthRange(code,2, 24,CODE_OF_SALARY_GRADE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_SALARY_GRADE ="salary_grade.company";
	public RetailscmChecker checkCompanyIdOfSalaryGrade(String companyId)
	{
		
	 	checkIdOfSalaryGrade(companyId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_SALARY_GRADE ="salary_grade.name";
	public RetailscmChecker checkNameOfSalaryGrade(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_SALARY_GRADE ); 		
		
		return this;
	}	 			

	public static final String  DETAIL_DESCRIPTION_OF_SALARY_GRADE ="salary_grade.detail_description";
	public RetailscmChecker checkDetailDescriptionOfSalaryGrade(String detailDescription)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_SALARY_GRADE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SALARY_GRADE ="salary_grade.version";
	public RetailscmChecker checkVersionOfSalaryGrade(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SALARY_GRADE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_INTERVIEW_TYPE ="interview_type.id";
	public RetailscmChecker checkIdOfInterviewType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_INTERVIEW_TYPE ="interview_type.code";
	public RetailscmChecker checkCodeOfInterviewType(String code)
	{
		
	 	checkStringLengthRange(code,3, 32,CODE_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_INTERVIEW_TYPE ="interview_type.company";
	public RetailscmChecker checkCompanyIdOfInterviewType(String companyId)
	{
		
	 	checkIdOfInterviewType(companyId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.description";
	public RetailscmChecker checkDescriptionOfInterviewType(String description)
	{
		
	 	checkStringLengthRange(description,2, 24,DESCRIPTION_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	 			

	public static final String  DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE ="interview_type.detail_description";
	public RetailscmChecker checkDetailDescriptionOfInterviewType(String detailDescription)
	{
		
	 	checkStringLengthRange(detailDescription,16, 244,DETAIL_DESCRIPTION_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_INTERVIEW_TYPE ="interview_type.version";
	public RetailscmChecker checkVersionOfInterviewType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_INTERVIEW_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TRAINING_COURSE_TYPE ="training_course_type.id";
	public RetailscmChecker checkIdOfTrainingCourseType(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_TRAINING_COURSE_TYPE ="training_course_type.code";
	public RetailscmChecker checkCodeOfTrainingCourseType(String code)
	{
		
	 	checkStringLengthRange(code,2, 16,CODE_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_TRAINING_COURSE_TYPE ="training_course_type.company";
	public RetailscmChecker checkCompanyIdOfTrainingCourseType(String companyId)
	{
		
	 	checkIdOfTrainingCourseType(companyId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_TRAINING_COURSE_TYPE ="training_course_type.name";
	public RetailscmChecker checkNameOfTrainingCourseType(String name)
	{
		
	 	checkStringLengthRange(name,1, 16,NAME_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_TRAINING_COURSE_TYPE ="training_course_type.description";
	public RetailscmChecker checkDescriptionOfTrainingCourseType(String description)
	{
		
	 	checkStringLengthRange(description,5, 64,DESCRIPTION_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TRAINING_COURSE_TYPE ="training_course_type.version";
	public RetailscmChecker checkVersionOfTrainingCourseType(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TRAINING_COURSE_TYPE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PUBLIC_HOLIDAY ="public_holiday.id";
	public RetailscmChecker checkIdOfPublicHoliday(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	 			

	public static final String  CODE_OF_PUBLIC_HOLIDAY ="public_holiday.code";
	public RetailscmChecker checkCodeOfPublicHoliday(String code)
	{
		
	 	checkStringLengthRange(code,2, 16,CODE_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_PUBLIC_HOLIDAY ="public_holiday.company";
	public RetailscmChecker checkCompanyIdOfPublicHoliday(String companyId)
	{
		
	 	checkIdOfPublicHoliday(companyId ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_PUBLIC_HOLIDAY ="public_holiday.name";
	public RetailscmChecker checkNameOfPublicHoliday(String name)
	{
		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_PUBLIC_HOLIDAY ="public_holiday.description";
	public RetailscmChecker checkDescriptionOfPublicHoliday(String description)
	{
		
	 	checkStringLengthRange(description,3, 40,DESCRIPTION_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PUBLIC_HOLIDAY ="public_holiday.version";
	public RetailscmChecker checkVersionOfPublicHoliday(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PUBLIC_HOLIDAY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_TERMINATION ="termination.id";
	public RetailscmChecker checkIdOfTermination(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_TERMINATION ); 		
		
		return this;
	}	 			

	public static final String  REASON_OF_TERMINATION ="termination.reason";
	public RetailscmChecker checkReasonIdOfTermination(String reasonId)
	{
		
	 	checkIdOfTermination(reasonId ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_TERMINATION ="termination.type";
	public RetailscmChecker checkTypeIdOfTermination(String typeId)
	{
		
	 	checkIdOfTermination(typeId ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_TERMINATION ="termination.comment";
	public RetailscmChecker checkCommentOfTermination(String comment)
	{
		
	 	checkStringLengthRange(comment,2, 16,COMMENT_OF_TERMINATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_TERMINATION ="termination.version";
	public RetailscmChecker checkVersionOfTermination(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TERMINATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_VIEW ="view.id";
	public RetailscmChecker checkIdOfView(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_VIEW ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_VIEW ="view.who";
	public RetailscmChecker checkWhoOfView(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_VIEW ); 		
		
		return this;
	}	 			

	public static final String  ASSESSMENT_OF_VIEW ="view.assessment";
	public RetailscmChecker checkAssessmentOfView(String assessment)
	{
		
	 	checkStringLengthRange(assessment,3, 40,ASSESSMENT_OF_VIEW ); 		
		
		return this;
	}	 			

	public static final String  INTERVIEW_TIME_OF_VIEW ="view.interview_time";
	public RetailscmChecker checkInterviewTimeOfView(Date interviewTime)
	{
		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2017-03-03"),INTERVIEW_TIME_OF_VIEW ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_VIEW ="view.version";
	public RetailscmChecker checkVersionOfView(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_VIEW ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE ="employee.id";
	public RetailscmChecker checkIdOfEmployee(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_EMPLOYEE ="employee.company";
	public RetailscmChecker checkCompanyIdOfEmployee(String companyId)
	{
		
	 	checkIdOfEmployee(companyId ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_EMPLOYEE ="employee.title";
	public RetailscmChecker checkTitleOfEmployee(String title)
	{
		
	 	checkStringLengthRange(title,1, 12,TITLE_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  DEPARTMENT_OF_EMPLOYEE ="employee.department";
	public RetailscmChecker checkDepartmentIdOfEmployee(String departmentId)
	{
		
	 	checkIdOfEmployee(departmentId ); 		
		
		return this;
	}	 			

	public static final String  FAMILY_NAME_OF_EMPLOYEE ="employee.family_name";
	public RetailscmChecker checkFamilyNameOfEmployee(String familyName)
	{
		
	 	checkStringLengthRange(familyName,0, 4,FAMILY_NAME_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  GIVEN_NAME_OF_EMPLOYEE ="employee.given_name";
	public RetailscmChecker checkGivenNameOfEmployee(String givenName)
	{
		
	 	checkStringLengthRange(givenName,1, 8,GIVEN_NAME_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_EMPLOYEE ="employee.email";
	public RetailscmChecker checkEmailOfEmployee(String email)
	{
		
	 	checkEmail(email,6, 52,EMAIL_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  CITY_OF_EMPLOYEE ="employee.city";
	public RetailscmChecker checkCityOfEmployee(String city)
	{
		
	 	checkStringLengthRange(city,1, 8,CITY_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  ADDRESS_OF_EMPLOYEE ="employee.address";
	public RetailscmChecker checkAddressOfEmployee(String address)
	{
		
	 	checkStringLengthRange(address,2, 28,ADDRESS_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  CELL_PHONE_OF_EMPLOYEE ="employee.cell_phone";
	public RetailscmChecker checkCellPhoneOfEmployee(String cellPhone)
	{
		
	 	checkChinaMobilePhone(cellPhone,5, 44,CELL_PHONE_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  OCCUPATION_OF_EMPLOYEE ="employee.occupation";
	public RetailscmChecker checkOccupationIdOfEmployee(String occupationId)
	{
		
	 	checkIdOfEmployee(occupationId ); 		
		
		return this;
	}	 			

	public static final String  RESPONSIBLE_FOR_OF_EMPLOYEE ="employee.responsible_for";
	public RetailscmChecker checkResponsibleForIdOfEmployee(String responsibleForId)
	{
		
	 	checkIdOfEmployee(responsibleForId ); 		
		
		return this;
	}	 			

	public static final String  CURRENT_SALARY_GRADE_OF_EMPLOYEE ="employee.current_salary_grade";
	public RetailscmChecker checkCurrentSalaryGradeIdOfEmployee(String currentSalaryGradeId)
	{
		
	 	checkIdOfEmployee(currentSalaryGradeId ); 		
		
		return this;
	}	 			

	public static final String  SALARY_ACCOUNT_OF_EMPLOYEE ="employee.salary_account";
	public RetailscmChecker checkSalaryAccountOfEmployee(String salaryAccount)
	{
		
	 	checkStringLengthRange(salaryAccount,4, 60,SALARY_ACCOUNT_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE ="employee.version";
	public RetailscmChecker checkVersionOfEmployee(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_JOB_APPLICATION ="job_application.id";
	public RetailscmChecker checkIdOfJobApplication(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_JOB_APPLICATION ); 		
		
		return this;
	}	 			

	public static final String  APPLICATION_TIME_OF_JOB_APPLICATION ="job_application.application_time";
	public RetailscmChecker checkApplicationTimeOfJobApplication(Date applicationTime)
	{
		
	 	checkDateRange(applicationTime,parseDate("1900-01-01"), parseDate("2018-03-04"),APPLICATION_TIME_OF_JOB_APPLICATION ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_JOB_APPLICATION ="job_application.who";
	public RetailscmChecker checkWhoOfJobApplication(String who)
	{
		
	 	checkStringLengthRange(who,2, 20,WHO_OF_JOB_APPLICATION ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_JOB_APPLICATION ="job_application.comments";
	public RetailscmChecker checkCommentsOfJobApplication(String comments)
	{
		
	 	checkStringLengthRange(comments,8, 124,COMMENTS_OF_JOB_APPLICATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_JOB_APPLICATION ="job_application.version";
	public RetailscmChecker checkVersionOfJobApplication(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_JOB_APPLICATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PROFESSION_INTERVIEW ="profession_interview.id";
	public RetailscmChecker checkIdOfProfessionInterview(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_PROFESSION_INTERVIEW ="profession_interview.who";
	public RetailscmChecker checkWhoOfProfessionInterview(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  INTERVIEW_TIME_OF_PROFESSION_INTERVIEW ="profession_interview.interview_time";
	public RetailscmChecker checkInterviewTimeOfProfessionInterview(Date interviewTime)
	{
		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2018-03-04"),INTERVIEW_TIME_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_PROFESSION_INTERVIEW ="profession_interview.comments";
	public RetailscmChecker checkCommentsOfProfessionInterview(String comments)
	{
		
	 	checkStringLengthRange(comments,4, 60,COMMENTS_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PROFESSION_INTERVIEW ="profession_interview.version";
	public RetailscmChecker checkVersionOfProfessionInterview(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PROFESSION_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_HR_INTERVIEW ="hr_interview.id";
	public RetailscmChecker checkIdOfHrInterview(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_HR_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_HR_INTERVIEW ="hr_interview.who";
	public RetailscmChecker checkWhoOfHrInterview(String who)
	{
		
	 	checkStringLengthRange(who,2, 20,WHO_OF_HR_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  INTERVIEW_TIME_OF_HR_INTERVIEW ="hr_interview.interview_time";
	public RetailscmChecker checkInterviewTimeOfHrInterview(Date interviewTime)
	{
		
	 	checkDateRange(interviewTime,parseDate("1900-01-01"), parseDate("2018-03-04"),INTERVIEW_TIME_OF_HR_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_HR_INTERVIEW ="hr_interview.comments";
	public RetailscmChecker checkCommentsOfHrInterview(String comments)
	{
		
	 	checkStringLengthRange(comments,4, 52,COMMENTS_OF_HR_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_HR_INTERVIEW ="hr_interview.version";
	public RetailscmChecker checkVersionOfHrInterview(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_HR_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OFFER_APPROVAL ="offer_approval.id";
	public RetailscmChecker checkIdOfOfferApproval(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_OFFER_APPROVAL ="offer_approval.who";
	public RetailscmChecker checkWhoOfOfferApproval(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  APPROVE_TIME_OF_OFFER_APPROVAL ="offer_approval.approve_time";
	public RetailscmChecker checkApproveTimeOfOfferApproval(Date approveTime)
	{
		
	 	checkDateRange(approveTime,parseDate("1900-01-01"), parseDate("2018-03-04"),APPROVE_TIME_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_OFFER_APPROVAL ="offer_approval.comments";
	public RetailscmChecker checkCommentsOfOfferApproval(String comments)
	{
		
	 	checkStringLengthRange(comments,3, 40,COMMENTS_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OFFER_APPROVAL ="offer_approval.version";
	public RetailscmChecker checkVersionOfOfferApproval(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OFFER_APPROVAL ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OFFER_ACCEPTANCE ="offer_acceptance.id";
	public RetailscmChecker checkIdOfOfferAcceptance(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_OFFER_ACCEPTANCE ="offer_acceptance.who";
	public RetailscmChecker checkWhoOfOfferAcceptance(String who)
	{
		
	 	checkStringLengthRange(who,1, 12,WHO_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	 			

	public static final String  ACCEPT_TIME_OF_OFFER_ACCEPTANCE ="offer_acceptance.accept_time";
	public RetailscmChecker checkAcceptTimeOfOfferAcceptance(Date acceptTime)
	{
		
	 	checkDateRange(acceptTime,parseDate("1900-01-01"), parseDate("2018-03-04"),ACCEPT_TIME_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_OFFER_ACCEPTANCE ="offer_acceptance.comments";
	public RetailscmChecker checkCommentsOfOfferAcceptance(String comments)
	{
		
	 	checkStringLengthRange(comments,3, 40,COMMENTS_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OFFER_ACCEPTANCE ="offer_acceptance.version";
	public RetailscmChecker checkVersionOfOfferAcceptance(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OFFER_ACCEPTANCE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_BOARDING ="employee_boarding.id";
	public RetailscmChecker checkIdOfEmployeeBoarding(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_EMPLOYEE_BOARDING ="employee_boarding.who";
	public RetailscmChecker checkWhoOfEmployeeBoarding(String who)
	{
		
	 	checkStringLengthRange(who,2, 20,WHO_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	 			

	public static final String  EMPLOY_TIME_OF_EMPLOYEE_BOARDING ="employee_boarding.employ_time";
	public RetailscmChecker checkEmployTimeOfEmployeeBoarding(Date employTime)
	{
		
	 	checkDateRange(employTime,parseDate("1900-01-01"), parseDate("2018-03-04"),EMPLOY_TIME_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_EMPLOYEE_BOARDING ="employee_boarding.comments";
	public RetailscmChecker checkCommentsOfEmployeeBoarding(String comments)
	{
		
	 	checkStringLengthRange(comments,3, 44,COMMENTS_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_BOARDING ="employee_boarding.version";
	public RetailscmChecker checkVersionOfEmployeeBoarding(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_BOARDING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_INSTRUCTOR ="instructor.id";
	public RetailscmChecker checkIdOfInstructor(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_INSTRUCTOR ="instructor.title";
	public RetailscmChecker checkTitleOfInstructor(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  FAMILY_NAME_OF_INSTRUCTOR ="instructor.family_name";
	public RetailscmChecker checkFamilyNameOfInstructor(String familyName)
	{
		
	 	checkStringLengthRange(familyName,0, 4,FAMILY_NAME_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  GIVEN_NAME_OF_INSTRUCTOR ="instructor.given_name";
	public RetailscmChecker checkGivenNameOfInstructor(String givenName)
	{
		
	 	checkStringLengthRange(givenName,1, 8,GIVEN_NAME_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  CELL_PHONE_OF_INSTRUCTOR ="instructor.cell_phone";
	public RetailscmChecker checkCellPhoneOfInstructor(String cellPhone)
	{
		
	 	checkChinaMobilePhone(cellPhone,5, 44,CELL_PHONE_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_INSTRUCTOR ="instructor.email";
	public RetailscmChecker checkEmailOfInstructor(String email)
	{
		
	 	checkEmail(email,10, 80,EMAIL_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_INSTRUCTOR ="instructor.company";
	public RetailscmChecker checkCompanyIdOfInstructor(String companyId)
	{
		
	 	checkIdOfInstructor(companyId ); 		
		
		return this;
	}	 			

	public static final String  INTRODUCTION_OF_INSTRUCTOR ="instructor.introduction";
	public RetailscmChecker checkIntroductionOfInstructor(String introduction)
	{
		
	 	checkStringLengthRange(introduction,4, 60,INTRODUCTION_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_INSTRUCTOR ="instructor.version";
	public RetailscmChecker checkVersionOfInstructor(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_INSTRUCTOR ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_COMPANY_TRAINING ="company_training.id";
	public RetailscmChecker checkIdOfCompanyTraining(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_COMPANY_TRAINING ="company_training.title";
	public RetailscmChecker checkTitleOfCompanyTraining(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_COMPANY_TRAINING ="company_training.company";
	public RetailscmChecker checkCompanyIdOfCompanyTraining(String companyId)
	{
		
	 	checkIdOfCompanyTraining(companyId ); 		
		
		return this;
	}	 			

	public static final String  INSTRUCTOR_OF_COMPANY_TRAINING ="company_training.instructor";
	public RetailscmChecker checkInstructorIdOfCompanyTraining(String instructorId)
	{
		
	 	checkIdOfCompanyTraining(instructorId ); 		
		
		return this;
	}	 			

	public static final String  TRAINING_COURSE_TYPE_OF_COMPANY_TRAINING ="company_training.training_course_type";
	public RetailscmChecker checkTrainingCourseTypeIdOfCompanyTraining(String trainingCourseTypeId)
	{
		
	 	checkIdOfCompanyTraining(trainingCourseTypeId ); 		
		
		return this;
	}	 			

	public static final String  TIME_START_OF_COMPANY_TRAINING ="company_training.time_start";
	public RetailscmChecker checkTimeStartOfCompanyTraining(Date timeStart)
	{
		
	 	checkDatePast(timeStart,parseDate("1900-01-01"), new Date(),TIME_START_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	 			

	public static final String  DURATION_HOURS_OF_COMPANY_TRAINING ="company_training.duration_hours";
	public RetailscmChecker checkDurationHoursOfCompanyTraining(int durationHours)
	{
		
	 	checkIntegerRange(durationHours,0, 3,DURATION_HOURS_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_COMPANY_TRAINING ="company_training.version";
	public RetailscmChecker checkVersionOfCompanyTraining(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_COMPANY_TRAINING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SCORING ="scoring.id";
	public RetailscmChecker checkIdOfScoring(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SCORING ); 		
		
		return this;
	}	 			

	public static final String  SCORED_BY_OF_SCORING ="scoring.scored_by";
	public RetailscmChecker checkScoredByOfScoring(String scoredBy)
	{
		
	 	checkStringLengthRange(scoredBy,1, 12,SCORED_BY_OF_SCORING ); 		
		
		return this;
	}	 			

	public static final String  SCORE_OF_SCORING ="scoring.score";
	public RetailscmChecker checkScoreOfScoring(int score)
	{
		
	 	checkIntegerRange(score,0, 100,SCORE_OF_SCORING ); 		
		
		return this;
	}	 			

	public static final String  COMMENT_OF_SCORING ="scoring.comment";
	public RetailscmChecker checkCommentOfScoring(String comment)
	{
		
	 	checkStringLengthRange(comment,3, 36,COMMENT_OF_SCORING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SCORING ="scoring.version";
	public RetailscmChecker checkVersionOfScoring(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SCORING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.id";
	public RetailscmChecker checkIdOfEmployeeCompanyTraining(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_COMPANY_TRAINING ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeCompanyTraining(String employeeId)
	{
		
	 	checkIdOfEmployeeCompanyTraining(employeeId ); 		
		
		return this;
	}	 			

	public static final String  TRAINING_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.training";
	public RetailscmChecker checkTrainingIdOfEmployeeCompanyTraining(String trainingId)
	{
		
	 	checkIdOfEmployeeCompanyTraining(trainingId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.version";
	public RetailscmChecker checkVersionOfEmployeeCompanyTraining(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_COMPANY_TRAINING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_SKILL ="employee_skill.id";
	public RetailscmChecker checkIdOfEmployeeSkill(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_SKILL ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_SKILL ="employee_skill.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeSkill(String employeeId)
	{
		
	 	checkIdOfEmployeeSkill(employeeId ); 		
		
		return this;
	}	 			

	public static final String  SKILL_TYPE_OF_EMPLOYEE_SKILL ="employee_skill.skill_type";
	public RetailscmChecker checkSkillTypeIdOfEmployeeSkill(String skillTypeId)
	{
		
	 	checkIdOfEmployeeSkill(skillTypeId ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_EMPLOYEE_SKILL ="employee_skill.description";
	public RetailscmChecker checkDescriptionOfEmployeeSkill(String description)
	{
		
	 	checkStringLengthRange(description,2, 28,DESCRIPTION_OF_EMPLOYEE_SKILL ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_SKILL ="employee_skill.version";
	public RetailscmChecker checkVersionOfEmployeeSkill(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_SKILL ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_PERFORMANCE ="employee_performance.id";
	public RetailscmChecker checkIdOfEmployeePerformance(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_PERFORMANCE ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_PERFORMANCE ="employee_performance.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeePerformance(String employeeId)
	{
		
	 	checkIdOfEmployeePerformance(employeeId ); 		
		
		return this;
	}	 			

	public static final String  PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE ="employee_performance.performance_comment";
	public RetailscmChecker checkPerformanceCommentOfEmployeePerformance(String performanceComment)
	{
		
	 	checkStringLengthRange(performanceComment,2, 28,PERFORMANCE_COMMENT_OF_EMPLOYEE_PERFORMANCE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_PERFORMANCE ="employee_performance.version";
	public RetailscmChecker checkVersionOfEmployeePerformance(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_PERFORMANCE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.id";
	public RetailscmChecker checkIdOfEmployeeWorkExperience(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeWorkExperience(String employeeId)
	{
		
	 	checkIdOfEmployeeWorkExperience(employeeId ); 		
		
		return this;
	}	 			

	public static final String  START_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.start";
	public RetailscmChecker checkStartOfEmployeeWorkExperience(Date start)
	{
		
	 	checkDateRange(start,parseDate("1900-01-01"), parseDate("2008-01-10"),START_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	 			

	public static final String  END_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.end";
	public RetailscmChecker checkEndOfEmployeeWorkExperience(Date end)
	{
		
	 	checkDateRange(end,parseDate("1900-01-01"), parseDate("2018-01-10"),END_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	 			

	public static final String  COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.company";
	public RetailscmChecker checkCompanyOfEmployeeWorkExperience(String company)
	{
		
	 	checkStringLengthRange(company,3, 32,COMPANY_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.description";
	public RetailscmChecker checkDescriptionOfEmployeeWorkExperience(String description)
	{
		
	 	checkStringLengthRange(description,6, 84,DESCRIPTION_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_WORK_EXPERIENCE ="employee_work_experience.version";
	public RetailscmChecker checkVersionOfEmployeeWorkExperience(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_LEAVE ="employee_leave.id";
	public RetailscmChecker checkIdOfEmployeeLeave(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_EMPLOYEE_LEAVE ="employee_leave.who";
	public RetailscmChecker checkWhoIdOfEmployeeLeave(String whoId)
	{
		
	 	checkIdOfEmployeeLeave(whoId ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_EMPLOYEE_LEAVE ="employee_leave.type";
	public RetailscmChecker checkTypeIdOfEmployeeLeave(String typeId)
	{
		
	 	checkIdOfEmployeeLeave(typeId ); 		
		
		return this;
	}	 			

	public static final String  LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE ="employee_leave.leave_duration_hour";
	public RetailscmChecker checkLeaveDurationHourOfEmployeeLeave(int leaveDurationHour)
	{
		
	 	checkIntegerRange(leaveDurationHour,0, 8,LEAVE_DURATION_HOUR_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_EMPLOYEE_LEAVE ="employee_leave.remark";
	public RetailscmChecker checkRemarkOfEmployeeLeave(String remark)
	{
		
	 	checkStringLengthRange(remark,3, 44,REMARK_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_LEAVE ="employee_leave.version";
	public RetailscmChecker checkVersionOfEmployeeLeave(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_LEAVE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_INTERVIEW ="employee_interview.id";
	public RetailscmChecker checkIdOfEmployeeInterview(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_INTERVIEW ="employee_interview.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeInterview(String employeeId)
	{
		
	 	checkIdOfEmployeeInterview(employeeId ); 		
		
		return this;
	}	 			

	public static final String  INTERVIEW_TYPE_OF_EMPLOYEE_INTERVIEW ="employee_interview.interview_type";
	public RetailscmChecker checkInterviewTypeIdOfEmployeeInterview(String interviewTypeId)
	{
		
	 	checkIdOfEmployeeInterview(interviewTypeId ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_EMPLOYEE_INTERVIEW ="employee_interview.remark";
	public RetailscmChecker checkRemarkOfEmployeeInterview(String remark)
	{
		
	 	checkStringLengthRange(remark,3, 40,REMARK_OF_EMPLOYEE_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_INTERVIEW ="employee_interview.version";
	public RetailscmChecker checkVersionOfEmployeeInterview(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_INTERVIEW ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.id";
	public RetailscmChecker checkIdOfEmployeeAttendance(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeAttendance(String employeeId)
	{
		
	 	checkIdOfEmployeeAttendance(employeeId ); 		
		
		return this;
	}	 			

	public static final String  ENTER_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.enter_time";
	public RetailscmChecker checkEnterTimeOfEmployeeAttendance(Date enterTime)
	{
		
	 	checkDateRange(enterTime,parseDate("1900-01-01"), parseDate("2017-01-01"),ENTER_TIME_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.leave_time";
	public RetailscmChecker checkLeaveTimeOfEmployeeAttendance(Date leaveTime)
	{
		
	 	checkDateRange(leaveTime,parseDate("1900-01-01"), parseDate("2017-03-01"),LEAVE_TIME_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.duration_hours";
	public RetailscmChecker checkDurationHoursOfEmployeeAttendance(int durationHours)
	{
		
	 	checkIntegerRange(durationHours,0, 8,DURATION_HOURS_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.remark";
	public RetailscmChecker checkRemarkOfEmployeeAttendance(String remark)
	{
		
	 	checkStringLengthRange(remark,2, 28,REMARK_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_ATTENDANCE ="employee_attendance.version";
	public RetailscmChecker checkVersionOfEmployeeAttendance(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_ATTENDANCE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.id";
	public RetailscmChecker checkIdOfEmployeeQualifier(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeQualifier(String employeeId)
	{
		
	 	checkIdOfEmployeeQualifier(employeeId ); 		
		
		return this;
	}	 			

	public static final String  QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.qualified_time";
	public RetailscmChecker checkQualifiedTimeOfEmployeeQualifier(Date qualifiedTime)
	{
		
	 	checkDateRange(qualifiedTime,parseDate("1900-01-01"), parseDate("2017-01-01"),QUALIFIED_TIME_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.type";
	public RetailscmChecker checkTypeOfEmployeeQualifier(String type)
	{
		
	 	checkStringLengthRange(type,1, 20,TYPE_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.level";
	public RetailscmChecker checkLevelOfEmployeeQualifier(String level)
	{
		
	 	checkStringLengthRange(level,1, 8,LEVEL_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.remark";
	public RetailscmChecker checkRemarkOfEmployeeQualifier(String remark)
	{
		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_QUALIFIER ="employee_qualifier.version";
	public RetailscmChecker checkVersionOfEmployeeQualifier(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_QUALIFIER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_EDUCATION ="employee_education.id";
	public RetailscmChecker checkIdOfEmployeeEducation(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_EDUCATION ="employee_education.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeEducation(String employeeId)
	{
		
	 	checkIdOfEmployeeEducation(employeeId ); 		
		
		return this;
	}	 			

	public static final String  COMPLETE_TIME_OF_EMPLOYEE_EDUCATION ="employee_education.complete_time";
	public RetailscmChecker checkCompleteTimeOfEmployeeEducation(Date completeTime)
	{
		
	 	checkDateRange(completeTime,parseDate("1900-01-01"), parseDate("2017-01-01"),COMPLETE_TIME_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_EMPLOYEE_EDUCATION ="employee_education.type";
	public RetailscmChecker checkTypeOfEmployeeEducation(String type)
	{
		
	 	checkStringLengthRange(type,1, 16,TYPE_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_EMPLOYEE_EDUCATION ="employee_education.remark";
	public RetailscmChecker checkRemarkOfEmployeeEducation(String remark)
	{
		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_EDUCATION ="employee_education.version";
	public RetailscmChecker checkVersionOfEmployeeEducation(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_EDUCATION ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_AWARD ="employee_award.id";
	public RetailscmChecker checkIdOfEmployeeAward(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_AWARD ="employee_award.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeAward(String employeeId)
	{
		
	 	checkIdOfEmployeeAward(employeeId ); 		
		
		return this;
	}	 			

	public static final String  COMPLETE_TIME_OF_EMPLOYEE_AWARD ="employee_award.complete_time";
	public RetailscmChecker checkCompleteTimeOfEmployeeAward(Date completeTime)
	{
		
	 	checkDateRange(completeTime,parseDate("1900-01-01"), parseDate("2017-01-01"),COMPLETE_TIME_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_EMPLOYEE_AWARD ="employee_award.type";
	public RetailscmChecker checkTypeOfEmployeeAward(String type)
	{
		
	 	checkStringLengthRange(type,2, 20,TYPE_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	 			

	public static final String  REMARK_OF_EMPLOYEE_AWARD ="employee_award.remark";
	public RetailscmChecker checkRemarkOfEmployeeAward(String remark)
	{
		
	 	checkStringLengthRange(remark,3, 36,REMARK_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_AWARD ="employee_award.version";
	public RetailscmChecker checkVersionOfEmployeeAward(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_AWARD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.id";
	public RetailscmChecker checkIdOfEmployeeSalarySheet(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  EMPLOYEE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.employee";
	public RetailscmChecker checkEmployeeIdOfEmployeeSalarySheet(String employeeId)
	{
		
	 	checkIdOfEmployeeSalarySheet(employeeId ); 		
		
		return this;
	}	 			

	public static final String  CURRENT_SALARY_GRADE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.current_salary_grade";
	public RetailscmChecker checkCurrentSalaryGradeIdOfEmployeeSalarySheet(String currentSalaryGradeId)
	{
		
	 	checkIdOfEmployeeSalarySheet(currentSalaryGradeId ); 		
		
		return this;
	}	 			

	public static final String  BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.base_salary";
	public RetailscmChecker checkBaseSalaryOfEmployeeSalarySheet(BigDecimal baseSalary)
	{
		
	 	checkMoneyAmount(baseSalary,0.00, 3000.10,BASE_SALARY_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  BONUS_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.bonus";
	public RetailscmChecker checkBonusOfEmployeeSalarySheet(BigDecimal bonus)
	{
		
	 	checkMoneyAmount(bonus,0.00, 1000.10,BONUS_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  REWARD_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.reward";
	public RetailscmChecker checkRewardOfEmployeeSalarySheet(BigDecimal reward)
	{
		
	 	checkMoneyAmount(reward,0.00, 1000.10,REWARD_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.personal_tax";
	public RetailscmChecker checkPersonalTaxOfEmployeeSalarySheet(BigDecimal personalTax)
	{
		
	 	checkMoneyAmount(personalTax,0.00, 792.88,PERSONAL_TAX_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.social_security";
	public RetailscmChecker checkSocialSecurityOfEmployeeSalarySheet(BigDecimal socialSecurity)
	{
		
	 	checkMoneyAmount(socialSecurity,0.00, 1100.22,SOCIAL_SECURITY_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.housing_found";
	public RetailscmChecker checkHousingFoundOfEmployeeSalarySheet(BigDecimal housingFound)
	{
		
	 	checkMoneyAmount(housingFound,0.00, 1222.99,HOUSING_FOUND_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.job_insurance";
	public RetailscmChecker checkJobInsuranceOfEmployeeSalarySheet(BigDecimal jobInsurance)
	{
		
	 	checkMoneyAmount(jobInsurance,0.00, 8.88,JOB_INSURANCE_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.version";
	public RetailscmChecker checkVersionOfEmployeeSalarySheet(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_EMPLOYEE_SALARY_SHEET ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_PAYING_OFF ="paying_off.id";
	public RetailscmChecker checkIdOfPayingOff(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_PAYING_OFF ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_PAYING_OFF ="paying_off.who";
	public RetailscmChecker checkWhoOfPayingOff(String who)
	{
		
	 	checkStringLengthRange(who,1, 8,WHO_OF_PAYING_OFF ); 		
		
		return this;
	}	 			

	public static final String  PAID_FOR_OF_PAYING_OFF ="paying_off.paid_for";
	public RetailscmChecker checkPaidForIdOfPayingOff(String paidForId)
	{
		
	 	checkIdOfPayingOff(paidForId ); 		
		
		return this;
	}	 			

	public static final String  PAID_TIME_OF_PAYING_OFF ="paying_off.paid_time";
	public RetailscmChecker checkPaidTimeOfPayingOff(Date paidTime)
	{
		
	 	checkDateRange(paidTime,parseDate("1900-01-01"), parseDate("2018-01-19"),PAID_TIME_OF_PAYING_OFF ); 		
		
		return this;
	}	 			

	public static final String  AMOUNT_OF_PAYING_OFF ="paying_off.amount";
	public RetailscmChecker checkAmountOfPayingOff(BigDecimal amount)
	{
		
	 	checkMoneyAmount(amount,0.00, 5223.88,AMOUNT_OF_PAYING_OFF ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_PAYING_OFF ="paying_off.version";
	public RetailscmChecker checkVersionOfPayingOff(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAYING_OFF ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public RetailscmChecker checkIdOfUserDomain(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_USER_DOMAIN ="user_domain.name";
	public RetailscmChecker checkNameOfUserDomain(String name)
	{
		
	 	checkStringLengthRange(name,2, 16,NAME_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_DOMAIN ="user_domain.version";
	public RetailscmChecker checkVersionOfUserDomain(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_DOMAIN ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_WHITE_LIST ="user_white_list.id";
	public RetailscmChecker checkIdOfUserWhiteList(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_IDENTITY_OF_USER_WHITE_LIST ="user_white_list.user_identity";
	public RetailscmChecker checkUserIdentityOfUserWhiteList(String userIdentity)
	{
		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ="user_white_list.user_special_functions";
	public RetailscmChecker checkUserSpecialFunctionsOfUserWhiteList(String userSpecialFunctions)
	{
		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_USER_WHITE_LIST ="user_white_list.domain";
	public RetailscmChecker checkDomainIdOfUserWhiteList(String domainId)
	{
		
	 	checkIdOfUserWhiteList(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_WHITE_LIST ="user_white_list.version";
	public RetailscmChecker checkVersionOfUserWhiteList(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_WHITE_LIST ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public RetailscmChecker checkIdOfSecUser(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public RetailscmChecker checkLoginOfSecUser(String login)
	{
		
	 	checkStringLengthRange(login,2, 20,LOGIN_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  MOBILE_OF_SEC_USER ="sec_user.mobile";
	public RetailscmChecker checkMobileOfSecUser(String mobile)
	{
		
	 	checkChinaMobilePhone(mobile,0, 11,MOBILE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  EMAIL_OF_SEC_USER ="sec_user.email";
	public RetailscmChecker checkEmailOfSecUser(String email)
	{
		
	 	checkStringLengthRange(email,0, 76,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public RetailscmChecker checkPwdOfSecUser(String pwd)
	{
		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_OF_SEC_USER ="sec_user.verification_code";
	public RetailscmChecker checkVerificationCodeOfSecUser(int verificationCode)
	{
		
	 	checkIntegerRange(verificationCode,0, 9999999,VERIFICATION_CODE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  VERIFICATION_CODE_EXPIRE_OF_SEC_USER ="sec_user.verification_code_expire";
	public RetailscmChecker checkVerificationCodeExpireOfSecUser(DateTime verificationCodeExpire)
	{
		
	 	checkDateTime(verificationCodeExpire,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),VERIFICATION_CODE_EXPIRE_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  LAST_LOGIN_TIME_OF_SEC_USER ="sec_user.last_login_time";
	public RetailscmChecker checkLastLoginTimeOfSecUser(DateTime lastLoginTime)
	{
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2099-12-31T09:09:09"),LAST_LOGIN_TIME_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  DOMAIN_OF_SEC_USER ="sec_user.domain";
	public RetailscmChecker checkDomainIdOfSecUser(String domainId)
	{
		
	 	checkIdOfSecUser(domainId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER ="sec_user.version";
	public RetailscmChecker checkVersionOfSecUser(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_SEC_USER_BLOCKING ="sec_user_blocking.id";
	public RetailscmChecker checkIdOfSecUserBlocking(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  WHO_OF_SEC_USER_BLOCKING ="sec_user_blocking.who";
	public RetailscmChecker checkWhoOfSecUserBlocking(String who)
	{
		
	 	checkStringLengthRange(who,4, 52,WHO_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  COMMENTS_OF_SEC_USER_BLOCKING ="sec_user_blocking.comments";
	public RetailscmChecker checkCommentsOfSecUserBlocking(String comments)
	{
		
	 	checkStringLengthRange(comments,7, 96,COMMENTS_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_SEC_USER_BLOCKING ="sec_user_blocking.version";
	public RetailscmChecker checkVersionOfSecUserBlocking(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SEC_USER_BLOCKING ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_USER_APP ="user_app.id";
	public RetailscmChecker checkIdOfUserApp(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_USER_APP ="user_app.title";
	public RetailscmChecker checkTitleOfUserApp(String title)
	{
		
	 	checkStringLengthRange(title,1, 300,TITLE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_USER_APP ="user_app.sec_user";
	public RetailscmChecker checkSecUserIdOfUserApp(String secUserId)
	{
		
	 	checkIdOfUserApp(secUserId ); 		
		
		return this;
	}	 			

	public static final String  APP_ICON_OF_USER_APP ="user_app.app_icon";
	public RetailscmChecker checkAppIconOfUserApp(String appIcon)
	{
		
	 	checkStringLengthRange(appIcon,2, 36,APP_ICON_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  FULL_ACCESS_OF_USER_APP ="user_app.full_access";
	public RetailscmChecker checkFullAccessOfUserApp(boolean fullAccess)
	{
		
	 	checkBooleanRange(fullAccess,0, true,FULL_ACCESS_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  PERMISSION_OF_USER_APP ="user_app.permission";
	public RetailscmChecker checkPermissionOfUserApp(String permission)
	{
		
	 	checkStringLengthRange(permission,2, 16,PERMISSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_USER_APP ="user_app.object_type";
	public RetailscmChecker checkObjectTypeOfUserApp(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 108,OBJECT_TYPE_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_ID_OF_USER_APP ="user_app.object_id";
	public RetailscmChecker checkObjectIdOfUserApp(String objectId)
	{
		
	 	checkStringLengthRange(objectId,4, 40,OBJECT_ID_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  LOCATION_OF_USER_APP ="user_app.location";
	public RetailscmChecker checkLocationOfUserApp(String location)
	{
		
	 	checkStringLengthRange(location,4, 48,LOCATION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_USER_APP ="user_app.version";
	public RetailscmChecker checkVersionOfUserApp(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_APP ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public RetailscmChecker checkIdOfListAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public RetailscmChecker checkNameOfListAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public RetailscmChecker checkInternalNameOfListAccess(String internalName)
	{
		
	 	checkStringLengthRange(internalName,2, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  READ_PERMISSION_OF_LIST_ACCESS ="list_access.read_permission";
	public RetailscmChecker checkReadPermissionOfListAccess(boolean readPermission)
	{
		
	 	checkBooleanRange(readPermission,0, true,READ_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  CREATE_PERMISSION_OF_LIST_ACCESS ="list_access.create_permission";
	public RetailscmChecker checkCreatePermissionOfListAccess(boolean createPermission)
	{
		
	 	checkBooleanRange(createPermission,0, true,CREATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  DELETE_PERMISSION_OF_LIST_ACCESS ="list_access.delete_permission";
	public RetailscmChecker checkDeletePermissionOfListAccess(boolean deletePermission)
	{
		
	 	checkBooleanRange(deletePermission,0, true,DELETE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  UPDATE_PERMISSION_OF_LIST_ACCESS ="list_access.update_permission";
	public RetailscmChecker checkUpdatePermissionOfListAccess(boolean updatePermission)
	{
		
	 	checkBooleanRange(updatePermission,0, true,UPDATE_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  EXECUTION_PERMISSION_OF_LIST_ACCESS ="list_access.execution_permission";
	public RetailscmChecker checkExecutionPermissionOfListAccess(boolean executionPermission)
	{
		
	 	checkBooleanRange(executionPermission,0, true,EXECUTION_PERMISSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_LIST_ACCESS ="list_access.app";
	public RetailscmChecker checkAppIdOfListAccess(String appId)
	{
		
	 	checkIdOfListAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LIST_ACCESS ="list_access.version";
	public RetailscmChecker checkVersionOfListAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LIST_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_OBJECT_ACCESS ="object_access.id";
	public RetailscmChecker checkIdOfObjectAccess(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  NAME_OF_OBJECT_ACCESS ="object_access.name";
	public RetailscmChecker checkNameOfObjectAccess(String name)
	{
		
	 	checkStringLengthRange(name,2, 28,NAME_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  OBJECT_TYPE_OF_OBJECT_ACCESS ="object_access.object_type";
	public RetailscmChecker checkObjectTypeOfObjectAccess(String objectType)
	{
		
	 	checkStringLengthRange(objectType,5, 112,OBJECT_TYPE_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST1_OF_OBJECT_ACCESS ="object_access.list1";
	public RetailscmChecker checkList1OfObjectAccess(String list1)
	{
		
	 	checkStringLengthRange(list1,5, 80,LIST1_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST2_OF_OBJECT_ACCESS ="object_access.list2";
	public RetailscmChecker checkList2OfObjectAccess(String list2)
	{
		
	 	checkStringLengthRange(list2,5, 80,LIST2_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST3_OF_OBJECT_ACCESS ="object_access.list3";
	public RetailscmChecker checkList3OfObjectAccess(String list3)
	{
		
	 	checkStringLengthRange(list3,5, 80,LIST3_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST4_OF_OBJECT_ACCESS ="object_access.list4";
	public RetailscmChecker checkList4OfObjectAccess(String list4)
	{
		
	 	checkStringLengthRange(list4,5, 80,LIST4_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST5_OF_OBJECT_ACCESS ="object_access.list5";
	public RetailscmChecker checkList5OfObjectAccess(String list5)
	{
		
	 	checkStringLengthRange(list5,5, 80,LIST5_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST6_OF_OBJECT_ACCESS ="object_access.list6";
	public RetailscmChecker checkList6OfObjectAccess(String list6)
	{
		
	 	checkStringLengthRange(list6,5, 80,LIST6_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST7_OF_OBJECT_ACCESS ="object_access.list7";
	public RetailscmChecker checkList7OfObjectAccess(String list7)
	{
		
	 	checkStringLengthRange(list7,5, 80,LIST7_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST8_OF_OBJECT_ACCESS ="object_access.list8";
	public RetailscmChecker checkList8OfObjectAccess(String list8)
	{
		
	 	checkStringLengthRange(list8,5, 80,LIST8_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  LIST9_OF_OBJECT_ACCESS ="object_access.list9";
	public RetailscmChecker checkList9OfObjectAccess(String list9)
	{
		
	 	checkStringLengthRange(list9,5, 80,LIST9_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  APP_OF_OBJECT_ACCESS ="object_access.app";
	public RetailscmChecker checkAppIdOfObjectAccess(String appId)
	{
		
	 	checkIdOfObjectAccess(appId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_OBJECT_ACCESS ="object_access.version";
	public RetailscmChecker checkVersionOfObjectAccess(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_OBJECT_ACCESS ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public RetailscmChecker checkIdOfLoginHistory(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  FROM_IP_OF_LOGIN_HISTORY ="login_history.from_ip";
	public RetailscmChecker checkFromIpOfLoginHistory(String fromIp)
	{
		
	 	checkStringLengthRange(fromIp,5, 44,FROM_IP_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_LOGIN_HISTORY ="login_history.description";
	public RetailscmChecker checkDescriptionOfLoginHistory(String description)
	{
		
	 	checkStringLengthRange(description,2, 16,DESCRIPTION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  SEC_USER_OF_LOGIN_HISTORY ="login_history.sec_user";
	public RetailscmChecker checkSecUserIdOfLoginHistory(String secUserId)
	{
		
	 	checkIdOfLoginHistory(secUserId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_LOGIN_HISTORY ="login_history.version";
	public RetailscmChecker checkVersionOfLoginHistory(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_LOGIN_HISTORY ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_GENERIC_FORM ="generic_form.id";
	public RetailscmChecker checkIdOfGenericForm(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_GENERIC_FORM ="generic_form.title";
	public RetailscmChecker checkTitleOfGenericForm(String title)
	{
		
	 	checkStringLengthRange(title,2, 20,TITLE_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_GENERIC_FORM ="generic_form.description";
	public RetailscmChecker checkDescriptionOfGenericForm(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_GENERIC_FORM ="generic_form.version";
	public RetailscmChecker checkVersionOfGenericForm(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_GENERIC_FORM ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_MESSAGE ="form_message.id";
	public RetailscmChecker checkIdOfFormMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_MESSAGE ="form_message.title";
	public RetailscmChecker checkTitleOfFormMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 24,TITLE_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_MESSAGE ="form_message.form";
	public RetailscmChecker checkFormIdOfFormMessage(String formId)
	{
		
	 	checkIdOfFormMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_MESSAGE ="form_message.level";
	public RetailscmChecker checkLevelOfFormMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_MESSAGE ="form_message.version";
	public RetailscmChecker checkVersionOfFormMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD_MESSAGE ="form_field_message.id";
	public RetailscmChecker checkIdOfFormFieldMessage(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  TITLE_OF_FORM_FIELD_MESSAGE ="form_field_message.title";
	public RetailscmChecker checkTitleOfFormFieldMessage(String title)
	{
		
	 	checkStringLengthRange(title,2, 16,TITLE_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ="form_field_message.parameter_name";
	public RetailscmChecker checkParameterNameOfFormFieldMessage(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD_MESSAGE ="form_field_message.form";
	public RetailscmChecker checkFormIdOfFormFieldMessage(String formId)
	{
		
	 	checkIdOfFormFieldMessage(formId ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_FIELD_MESSAGE ="form_field_message.level";
	public RetailscmChecker checkLevelOfFormFieldMessage(String level)
	{
		
	 	checkStringLengthRange(level,2, 28,LEVEL_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD_MESSAGE ="form_field_message.version";
	public RetailscmChecker checkVersionOfFormFieldMessage(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD_MESSAGE ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_FIELD ="form_field.id";
	public RetailscmChecker checkIdOfFormField(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_FIELD ="form_field.label";
	public RetailscmChecker checkLabelOfFormField(String label)
	{
		
	 	checkStringLengthRange(label,1, 12,LABEL_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_FIELD ="form_field.locale_key";
	public RetailscmChecker checkLocaleKeyOfFormField(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,1, 44,LOCALE_KEY_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  PARAMETER_NAME_OF_FORM_FIELD ="form_field.parameter_name";
	public RetailscmChecker checkParameterNameOfFormField(String parameterName)
	{
		
	 	checkStringLengthRange(parameterName,2, 16,PARAMETER_NAME_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  TYPE_OF_FORM_FIELD ="form_field.type";
	public RetailscmChecker checkTypeOfFormField(String type)
	{
		
	 	checkStringLengthRange(type,1, 36,TYPE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_FIELD ="form_field.form";
	public RetailscmChecker checkFormIdOfFormField(String formId)
	{
		
	 	checkIdOfFormField(formId ); 		
		
		return this;
	}	 			

	public static final String  PLACEHOLDER_OF_FORM_FIELD ="form_field.placeholder";
	public RetailscmChecker checkPlaceholderOfFormField(String placeholder)
	{
		
	 	checkStringLengthRange(placeholder,4, 48,PLACEHOLDER_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DEFAULT_VALUE_OF_FORM_FIELD ="form_field.default_value";
	public RetailscmChecker checkDefaultValueOfFormField(String defaultValue)
	{
		
	 	checkStringLengthRange(defaultValue,1, 12,DEFAULT_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DESCRIPTION_OF_FORM_FIELD ="form_field.description";
	public RetailscmChecker checkDescriptionOfFormField(String description)
	{
		
	 	checkStringLengthRange(description,4, 48,DESCRIPTION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  FIELD_GROUP_OF_FORM_FIELD ="form_field.field_group";
	public RetailscmChecker checkFieldGroupOfFormField(String fieldGroup)
	{
		
	 	checkStringLengthRange(fieldGroup,2, 16,FIELD_GROUP_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MINIMUM_VALUE_OF_FORM_FIELD ="form_field.minimum_value";
	public RetailscmChecker checkMinimumValueOfFormField(String minimumValue)
	{
		
	 	checkStringLengthRange(minimumValue,4, 60,MINIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  MAXIMUM_VALUE_OF_FORM_FIELD ="form_field.maximum_value";
	public RetailscmChecker checkMaximumValueOfFormField(String maximumValue)
	{
		
	 	checkStringLengthRange(maximumValue,5, 72,MAXIMUM_VALUE_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  REQUIRED_OF_FORM_FIELD ="form_field.required";
	public RetailscmChecker checkRequiredOfFormField(boolean required)
	{
		
	 	checkBooleanRange(required,0, true|false,REQUIRED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  DISABLED_OF_FORM_FIELD ="form_field.disabled";
	public RetailscmChecker checkDisabledOfFormField(boolean disabled)
	{
		
	 	checkBooleanRange(disabled,0, true|false,DISABLED_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CUSTOM_RENDERING_OF_FORM_FIELD ="form_field.custom_rendering";
	public RetailscmChecker checkCustomRenderingOfFormField(boolean customRendering)
	{
		
	 	checkBooleanRange(customRendering,0, false,CUSTOM_RENDERING_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  CANDIDATE_VALUES_OF_FORM_FIELD ="form_field.candidate_values";
	public RetailscmChecker checkCandidateValuesOfFormField(String candidateValues)
	{
		
	 	checkStringLengthRange(candidateValues,0, 12,CANDIDATE_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  SUGGEST_VALUES_OF_FORM_FIELD ="form_field.suggest_values";
	public RetailscmChecker checkSuggestValuesOfFormField(String suggestValues)
	{
		
	 	checkStringLengthRange(suggestValues,0, 12,SUGGEST_VALUES_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_FIELD ="form_field.version";
	public RetailscmChecker checkVersionOfFormField(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_FIELD ); 		
		
		return this;
	}	 			

	public static final String  ID_OF_FORM_ACTION ="form_action.id";
	public RetailscmChecker checkIdOfFormAction(String id)
	{
		
	 	checkStringLengthRange(id,5, 64,ID_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LABEL_OF_FORM_ACTION ="form_action.label";
	public RetailscmChecker checkLabelOfFormAction(String label)
	{
		
	 	checkStringLengthRange(label,1, 8,LABEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LOCALE_KEY_OF_FORM_ACTION ="form_action.locale_key";
	public RetailscmChecker checkLocaleKeyOfFormAction(String localeKey)
	{
		
	 	checkStringLengthRange(localeKey,2, 16,LOCALE_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  ACTION_KEY_OF_FORM_ACTION ="form_action.action_key";
	public RetailscmChecker checkActionKeyOfFormAction(String actionKey)
	{
		
	 	checkStringLengthRange(actionKey,2, 24,ACTION_KEY_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  LEVEL_OF_FORM_ACTION ="form_action.level";
	public RetailscmChecker checkLevelOfFormAction(String level)
	{
		
	 	checkStringLengthRange(level,3, 28,LEVEL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  URL_OF_FORM_ACTION ="form_action.url";
	public RetailscmChecker checkUrlOfFormAction(String url)
	{
		
	 	checkStringLengthRange(url,11, 168,URL_OF_FORM_ACTION ); 		
		
		return this;
	}	 			

	public static final String  FORM_OF_FORM_ACTION ="form_action.form";
	public RetailscmChecker checkFormIdOfFormAction(String formId)
	{
		
	 	checkIdOfFormAction(formId ); 		
		
		return this;
	}	 			

	public static final String  VERSION_OF_FORM_ACTION ="form_action.version";
	public RetailscmChecker checkVersionOfFormAction(int version)
	{
		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_FORM_ACTION ); 		
		
		return this;
	}	 			
	public void throwExceptionIfHasErrors(Class<? extends Exception> exceptionClazz) throws Exception {
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

    
}












