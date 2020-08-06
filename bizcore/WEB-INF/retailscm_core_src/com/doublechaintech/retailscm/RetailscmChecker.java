
package com.doublechaintech.retailscm;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import com.terapico.caf.DateTime;
import com.terapico.caf.Images;
public class RetailscmChecker extends BaseChecker{

	
	public RetailscmChecker() {
		this.messageList = new ArrayList<Message>();
	}
	

	public static final String  ID_OF_RETAIL_STORE_COUNTRY_CENTER ="retail_store_country_center.id";
	public RetailscmChecker checkIdOfRetailStoreCountryCenter(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_COUNTRY_CENTER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CATALOG ="catalog.name";
	public RetailscmChecker checkNameOfCatalog(String name)
	{		
	 	checkStringLengthRange(name,10, 201,NAME_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  OWNER_OF_CATALOG ="catalog.owner";
	public RetailscmChecker checkOwnerIdOfCatalog(String ownerId)
	{		
	 	checkIdOfCatalog(ownerId ); 		
		
		return this;
	}	

	public static final String  SUB_COUNT_OF_CATALOG ="catalog.sub_count";
	public RetailscmChecker checkSubCountOfCatalog(int subCount)
	{		
	 	checkIntegerRange(subCount,0, 10,SUB_COUNT_OF_CATALOG ); 		
		
		return this;
	}	

	public static final String  AMOUNT_OF_CATALOG ="catalog.amount";
	public RetailscmChecker checkAmountOfCatalog(BigDecimal amount)
	{		
	 	checkMoneyAmount(amount,0.00, 10.11,AMOUNT_OF_CATALOG ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_ONE_CATEGORY ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_TWO_CATEGORY ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_THREE_CATEGORY ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_PRODUCT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SKU ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_PROVINCE_CENTER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_PROVINCE_CENTER_DEPARTMENT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_PROVINCE_CENTER_EMPLOYEE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_CITY_SERVICE_CENTER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_PARTNER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT_PERSON ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_POTENTIAL_CUSTOMER_CONTACT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_CITY_EVENT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EVENT_ATTENDANCE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE ); 		
		
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
	 	checkStringLengthRange(telephone,4, 48,TELEPHONE_OF_RETAIL_STORE ); 		
		
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

	public static final String  CREATION_OF_RETAIL_STORE ="retail_store.creation";
	public RetailscmChecker checkCreationIdOfRetailStore(String creationId)
	{		
	 	checkIdOfRetailStore(creationId ); 		
		
		return this;
	}	

	public static final String  INVESTMENT_INVITATION_OF_RETAIL_STORE ="retail_store.investment_invitation";
	public RetailscmChecker checkInvestmentInvitationIdOfRetailStore(String investmentInvitationId)
	{		
	 	checkIdOfRetailStore(investmentInvitationId ); 		
		
		return this;
	}	

	public static final String  FRANCHISING_OF_RETAIL_STORE ="retail_store.franchising";
	public RetailscmChecker checkFranchisingIdOfRetailStore(String franchisingId)
	{		
	 	checkIdOfRetailStore(franchisingId ); 		
		
		return this;
	}	

	public static final String  DECORATION_OF_RETAIL_STORE ="retail_store.decoration";
	public RetailscmChecker checkDecorationIdOfRetailStore(String decorationId)
	{		
	 	checkIdOfRetailStore(decorationId ); 		
		
		return this;
	}	

	public static final String  OPENING_OF_RETAIL_STORE ="retail_store.opening";
	public RetailscmChecker checkOpeningIdOfRetailStore(String openingId)
	{		
	 	checkIdOfRetailStore(openingId ); 		
		
		return this;
	}	

	public static final String  CLOSING_OF_RETAIL_STORE ="retail_store.closing";
	public RetailscmChecker checkClosingIdOfRetailStore(String closingId)
	{		
	 	checkIdOfRetailStore(closingId ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_CREATION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_INVESTMENT_INVITATION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_FRANCHISING ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_DECORATION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_OPENING ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_CLOSING ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER ); 		
		
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

	public static final String  ID_OF_CONSUMER_ORDER_LINE_ITEM ="consumer_order_line_item.id";
	public RetailscmChecker checkIdOfConsumerOrderLineItem(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_LINE_ITEM ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_SHIPPING_GROUP ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_PAYMENT_GROUP ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_CONSUMER_ORDER_PRICE_ADJUSTMENT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_COUPON ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_WISHLIST ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_REWARD_POINT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_REWARD_POINT_REDEMPTION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_MEMBER_WISHLIST_PRODUCT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_ADDRESS ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_MEMBER_GIFT_CARD_CONSUME_RECORD ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_SUPPLIER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLIER_PRODUCT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_PRODUCT_SUPPLY_DURATION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER ); 		
		
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

	public static final String  ID_OF_SUPPLY_ORDER_LINE_ITEM ="supply_order_line_item.id";
	public RetailscmChecker checkIdOfSupplyOrderLineItem(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_LINE_ITEM ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_SHIPPING_GROUP ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLY_ORDER_PAYMENT_GROUP ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER ); 		
		
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

	public static final String  ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ="retail_store_order_line_item.id";
	public RetailscmChecker checkIdOfRetailStoreOrderLineItem(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_LINE_ITEM ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_SHIPPING_GROUP ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RETAIL_STORE_ORDER_PAYMENT_GROUP ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_WAREHOUSE ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_WAREHOUSE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_STORAGE_SPACE ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_STORAGE_SPACE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SMART_PALLET ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_SMART_PALLET ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_SHELF ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_SHELF_STOCK_COUNT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_STOCK_COUNT_ISSUE_TRACK ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_ALLOCATION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS ); 		
		
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

	public static final String  ID_OF_GOODS_MOVEMENT ="goods_movement.id";
	public RetailscmChecker checkIdOfGoodsMovement(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_GOODS_MOVEMENT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SUPPLIER_SPACE ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_SUPPLIER_SPACE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RECEIVING_SPACE ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_RECEIVING_SPACE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SHIPPING_SPACE ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_SHIPPING_SPACE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_DAMAGE_SPACE ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_DAMAGE_SPACE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_WAREHOUSE_ASSET ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_FLEET ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_TRANSPORT_FLEET ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_TRUCK ); 		
		
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
	 	checkStringLengthRange(contactNumber,4, 48,CONTACT_NUMBER_OF_TRANSPORT_TRUCK ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TRUCK_DRIVER ); 		
		
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
	 	checkStringLengthRange(driverLicenseNumber,4, 52,DRIVER_LICENSE_NUMBER_OF_TRUCK_DRIVER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_TASK ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TRANSPORT_TASK_TRACK ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNT_SET ); 		
		
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
	 	checkStringLengthRange(accountNumber,5, 68,ACCOUNT_NUMBER_OF_ACCOUNT_SET ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_SUBJECT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_PERIOD ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT ); 		
		
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

	public static final String  ID_OF_ORIGINAL_VOUCHER ="original_voucher.id";
	public RetailscmChecker checkIdOfOriginalVoucher(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ORIGINAL_VOUCHER ); 		
		
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

	public static final String  ID_OF_ACCOUNTING_DOCUMENT_LINE ="accounting_document_line.id";
	public RetailscmChecker checkIdOfAccountingDocumentLine(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_ACCOUNTING_DOCUMENT_LINE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_ONE_DEPARTMENT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_TWO_DEPARTMENT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_LEVEL_THREE_DEPARTMENT ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SKILL_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_RESPONSIBILITY_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TERMINATION_REASON ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TERMINATION_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_OCCUPATION_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_LEAVE_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SALARY_GRADE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_INTERVIEW_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TRAINING_COURSE_TYPE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_PUBLIC_HOLIDAY ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_TERMINATION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_VIEW ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE ); 		
		
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

	public static final String  ID_OF_INSTRUCTOR ="instructor.id";
	public RetailscmChecker checkIdOfInstructor(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_INSTRUCTOR ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_COMPANY_TRAINING ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_SCORING ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_COMPANY_TRAINING ); 		
		
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

	public static final String  SCORING_OF_EMPLOYEE_COMPANY_TRAINING ="employee_company_training.scoring";
	public RetailscmChecker checkScoringIdOfEmployeeCompanyTraining(String scoringId)
	{		
	 	checkIdOfEmployeeCompanyTraining(scoringId ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_SKILL ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_PERFORMANCE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_WORK_EXPERIENCE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_LEAVE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_INTERVIEW ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_ATTENDANCE ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_QUALIFIER ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_EDUCATION ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_AWARD ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_EMPLOYEE_SALARY_SHEET ); 		
		
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

	public static final String  PAYING_OFF_OF_EMPLOYEE_SALARY_SHEET ="employee_salary_sheet.paying_off";
	public RetailscmChecker checkPayingOffIdOfEmployeeSalarySheet(String payingOffId)
	{		
	 	checkIdOfEmployeeSalarySheet(payingOffId ); 		
		
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
	 	checkStringLengthRange(id,2, 64,ID_OF_PAYING_OFF ); 		
		
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

	public static final String  ID_OF_MOBILE_APP ="mobile_app.id";
	public RetailscmChecker checkIdOfMobileApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  NAME_OF_MOBILE_APP ="mobile_app.name";
	public RetailscmChecker checkNameOfMobileApp(String name)
	{		
	 	checkStringLengthRange(name,2, 20,NAME_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_MOBILE_APP ="mobile_app.version";
	public RetailscmChecker checkVersionOfMobileApp(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_MOBILE_APP ); 		
		
		return this;
	}	

	public static final String  ID_OF_PAGE ="page.id";
	public RetailscmChecker checkIdOfPage(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  PAGE_TITLE_OF_PAGE ="page.page_title";
	public RetailscmChecker checkPageTitleOfPage(String pageTitle)
	{		
	 	checkStringLengthRange(pageTitle,1, 10,PAGE_TITLE_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_PAGE ="page.link_to_url";
	public RetailscmChecker checkLinkToUrlOfPage(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,0, 512,LINK_TO_URL_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  PAGE_TYPE_OF_PAGE ="page.page_type";
	public RetailscmChecker checkPageTypeIdOfPage(String pageTypeId)
	{		
	 	checkIdOfPage(pageTypeId ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_PAGE ="page.display_order";
	public RetailscmChecker checkDisplayOrderOfPage(int displayOrder)
	{		
	 	checkIntegerRange(displayOrder,0, 10000,DISPLAY_ORDER_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  MOBILE_APP_OF_PAGE ="page.mobile_app";
	public RetailscmChecker checkMobileAppIdOfPage(String mobileAppId)
	{		
	 	checkIdOfPage(mobileAppId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PAGE ="page.version";
	public RetailscmChecker checkVersionOfPage(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAGE ); 		
		
		return this;
	}	

	public static final String  ID_OF_PAGE_TYPE ="page_type.id";
	public RetailscmChecker checkIdOfPageType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PAGE_TYPE ="page_type.name";
	public RetailscmChecker checkNameOfPageType(String name)
	{		
	 	checkStringLengthRange(name,1, 40,NAME_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PAGE_TYPE ="page_type.code";
	public RetailscmChecker checkCodeOfPageType(String code)
	{		
	 	checkStringLengthRange(code,1, 40,CODE_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  MOBILE_APP_OF_PAGE_TYPE ="page_type.mobile_app";
	public RetailscmChecker checkMobileAppIdOfPageType(String mobileAppId)
	{		
	 	checkIdOfPageType(mobileAppId ); 		
		
		return this;
	}	

	public static final String  FOOTER_TAB_OF_PAGE_TYPE ="page_type.footer_tab";
	public RetailscmChecker checkFooterTabOfPageType(boolean footerTab)
	{		
	 	checkBooleanRange(footerTab,0, true|false,FOOTER_TAB_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PAGE_TYPE ="page_type.version";
	public RetailscmChecker checkVersionOfPageType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PAGE_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_SLIDE ="slide.id";
	public RetailscmChecker checkIdOfSlide(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_SLIDE ="slide.name";
	public RetailscmChecker checkNameOfSlide(String name)
	{		
	 	checkStringLengthRange(name,0, 40,NAME_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_SLIDE ="slide.display_order";
	public RetailscmChecker checkDisplayOrderOfSlide(int displayOrder)
	{		
	 	checkIntegerRange(displayOrder,0, 10000,DISPLAY_ORDER_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  IMAGE_URL_OF_SLIDE ="slide.image_url";
	public RetailscmChecker checkImageUrlOfSlide(String imageUrl)
	{		
	 	checkImage(imageUrl,0, 512,IMAGE_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  VIDEO_URL_OF_SLIDE ="slide.video_url";
	public RetailscmChecker checkVideoUrlOfSlide(String videoUrl)
	{		
	 	checkImage(videoUrl,0, 512,VIDEO_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_SLIDE ="slide.link_to_url";
	public RetailscmChecker checkLinkToUrlOfSlide(String linkToUrl)
	{
		if(linkToUrl == null) {
			return this;
		}
		
	 	checkStringLengthRange(linkToUrl,0, 512,LINK_TO_URL_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_SLIDE ="slide.page";
	public RetailscmChecker checkPageIdOfSlide(String pageId)
	{		
	 	checkIdOfSlide(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SLIDE ="slide.version";
	public RetailscmChecker checkVersionOfSlide(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SLIDE ); 		
		
		return this;
	}	

	public static final String  ID_OF_UI_ACTION ="ui_action.id";
	public RetailscmChecker checkIdOfUiAction(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  CODE_OF_UI_ACTION ="ui_action.code";
	public RetailscmChecker checkCodeOfUiAction(String code)
	{		
	 	checkStringLengthRange(code,1, 40,CODE_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  ICON_OF_UI_ACTION ="ui_action.icon";
	public RetailscmChecker checkIconOfUiAction(String icon)
	{		
	 	checkStringLengthRange(icon,1, 512,ICON_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_UI_ACTION ="ui_action.title";
	public RetailscmChecker checkTitleOfUiAction(String title)
	{		
	 	checkStringLengthRange(title,1, 40,TITLE_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_UI_ACTION ="ui_action.display_order";
	public RetailscmChecker checkDisplayOrderOfUiAction(int displayOrder)
	{		
	 	checkIntegerRange(displayOrder,0, 10000,DISPLAY_ORDER_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  BRIEF_OF_UI_ACTION ="ui_action.brief";
	public RetailscmChecker checkBriefOfUiAction(String brief)
	{		
	 	checkStringLengthRange(brief,0, 200,BRIEF_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  IMAGE_URL_OF_UI_ACTION ="ui_action.image_url";
	public RetailscmChecker checkImageUrlOfUiAction(String imageUrl)
	{		
	 	checkImage(imageUrl,0, 512,IMAGE_URL_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_UI_ACTION ="ui_action.link_to_url";
	public RetailscmChecker checkLinkToUrlOfUiAction(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,0, 512,LINK_TO_URL_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  EXTRA_DATA_OF_UI_ACTION ="ui_action.extra_data";
	public RetailscmChecker checkExtraDataOfUiAction(String extraData)
	{		
	 	checkLongtext(extraData,0, 1048576,EXTRA_DATA_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_UI_ACTION ="ui_action.page";
	public RetailscmChecker checkPageIdOfUiAction(String pageId)
	{		
	 	checkIdOfUiAction(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_UI_ACTION ="ui_action.version";
	public RetailscmChecker checkVersionOfUiAction(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_UI_ACTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_SECTION ="section.id";
	public RetailscmChecker checkIdOfSection(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  TITLE_OF_SECTION ="section.title";
	public RetailscmChecker checkTitleOfSection(String title)
	{		
	 	checkStringLengthRange(title,1, 40,TITLE_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  BRIEF_OF_SECTION ="section.brief";
	public RetailscmChecker checkBriefOfSection(String brief)
	{		
	 	checkStringLengthRange(brief,0, 200,BRIEF_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  ICON_OF_SECTION ="section.icon";
	public RetailscmChecker checkIconOfSection(String icon)
	{		
	 	checkImage(icon,0, 512,ICON_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  DISPLAY_ORDER_OF_SECTION ="section.display_order";
	public RetailscmChecker checkDisplayOrderOfSection(int displayOrder)
	{		
	 	checkIntegerRange(displayOrder,0, 10000,DISPLAY_ORDER_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  VIEW_GROUP_OF_SECTION ="section.view_group";
	public RetailscmChecker checkViewGroupOfSection(String viewGroup)
	{		
	 	checkStringLengthRange(viewGroup,0, 40,VIEW_GROUP_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  LINK_TO_URL_OF_SECTION ="section.link_to_url";
	public RetailscmChecker checkLinkToUrlOfSection(String linkToUrl)
	{		
	 	checkStringLengthRange(linkToUrl,0, 512,LINK_TO_URL_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  PAGE_OF_SECTION ="section.page";
	public RetailscmChecker checkPageIdOfSection(String pageId)
	{		
	 	checkIdOfSection(pageId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_SECTION ="section.version";
	public RetailscmChecker checkVersionOfSection(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_SECTION ); 		
		
		return this;
	}	

	public static final String  ID_OF_USER_DOMAIN ="user_domain.id";
	public RetailscmChecker checkIdOfUserDomain(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_DOMAIN ); 		
		
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

	public static final String  ID_OF_USER_ALLOW_LIST ="user_allow_list.id";
	public RetailscmChecker checkIdOfUserAllowList(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_ALLOW_LIST ); 		
		
		return this;
	}	

	public static final String  USER_IDENTITY_OF_USER_ALLOW_LIST ="user_allow_list.user_identity";
	public RetailscmChecker checkUserIdentityOfUserAllowList(String userIdentity)
	{		
	 	checkStringLengthRange(userIdentity,1, 40,USER_IDENTITY_OF_USER_ALLOW_LIST ); 		
		
		return this;
	}	

	public static final String  USER_SPECIAL_FUNCTIONS_OF_USER_ALLOW_LIST ="user_allow_list.user_special_functions";
	public RetailscmChecker checkUserSpecialFunctionsOfUserAllowList(String userSpecialFunctions)
	{		
	 	checkStringLengthRange(userSpecialFunctions,1, 200,USER_SPECIAL_FUNCTIONS_OF_USER_ALLOW_LIST ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_USER_ALLOW_LIST ="user_allow_list.domain";
	public RetailscmChecker checkDomainIdOfUserAllowList(String domainId)
	{		
	 	checkIdOfUserAllowList(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_USER_ALLOW_LIST ="user_allow_list.version";
	public RetailscmChecker checkVersionOfUserAllowList(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_USER_ALLOW_LIST ); 		
		
		return this;
	}	

	public static final String  ID_OF_SEC_USER ="sec_user.id";
	public RetailscmChecker checkIdOfSecUser(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  LOGIN_OF_SEC_USER ="sec_user.login";
	public RetailscmChecker checkLoginOfSecUser(String login)
	{		
	 	checkStringLengthRange(login,0, 256,LOGIN_OF_SEC_USER ); 		
		
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
	 	checkEmail(email,0, 256,EMAIL_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  PWD_OF_SEC_USER ="sec_user.pwd";
	public RetailscmChecker checkPwdOfSecUser(String pwd)
	{		
	 	checkPassword(pwd,3, 28,PWD_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_OPENID_OF_SEC_USER ="sec_user.weixin_openid";
	public RetailscmChecker checkWeixinOpenidOfSecUser(String weixinOpenid)
	{		
	 	checkStringLengthRange(weixinOpenid,0, 128,WEIXIN_OPENID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  WEIXIN_APPID_OF_SEC_USER ="sec_user.weixin_appid";
	public RetailscmChecker checkWeixinAppidOfSecUser(String weixinAppid)
	{		
	 	checkStringLengthRange(weixinAppid,0, 128,WEIXIN_APPID_OF_SEC_USER ); 		
		
		return this;
	}	

	public static final String  ACCESS_TOKEN_OF_SEC_USER ="sec_user.access_token";
	public RetailscmChecker checkAccessTokenOfSecUser(String accessToken)
	{		
	 	checkStringLengthRange(accessToken,0, 128,ACCESS_TOKEN_OF_SEC_USER ); 		
		
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
		if(lastLoginTime == null) {
			return this;
		}
		
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

	public static final String  ID_OF_USER_APP ="user_app.id";
	public RetailscmChecker checkIdOfUserApp(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_USER_APP ); 		
		
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
	 	checkStringLengthRange(objectType,1, 100,OBJECT_TYPE_OF_USER_APP ); 		
		
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

	public static final String  ID_OF_QUICK_LINK ="quick_link.id";
	public RetailscmChecker checkIdOfQuickLink(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  NAME_OF_QUICK_LINK ="quick_link.name";
	public RetailscmChecker checkNameOfQuickLink(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ICON_OF_QUICK_LINK ="quick_link.icon";
	public RetailscmChecker checkIconOfQuickLink(String icon)
	{		
	 	checkStringLengthRange(icon,1, 200,ICON_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  IMAGE_PATH_OF_QUICK_LINK ="quick_link.image_path";
	public RetailscmChecker checkImagePathOfQuickLink(String imagePath)
	{		
	 	checkImage(imagePath,0, 512,IMAGE_PATH_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  LINK_TARGET_OF_QUICK_LINK ="quick_link.link_target";
	public RetailscmChecker checkLinkTargetOfQuickLink(String linkTarget)
	{		
	 	checkStringLengthRange(linkTarget,1, 200,LINK_TARGET_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  APP_OF_QUICK_LINK ="quick_link.app";
	public RetailscmChecker checkAppIdOfQuickLink(String appId)
	{		
	 	checkIdOfQuickLink(appId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_QUICK_LINK ="quick_link.version";
	public RetailscmChecker checkVersionOfQuickLink(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_QUICK_LINK ); 		
		
		return this;
	}	

	public static final String  ID_OF_LIST_ACCESS ="list_access.id";
	public RetailscmChecker checkIdOfListAccess(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  NAME_OF_LIST_ACCESS ="list_access.name";
	public RetailscmChecker checkNameOfListAccess(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_LIST_ACCESS ); 		
		
		return this;
	}	

	public static final String  INTERNAL_NAME_OF_LIST_ACCESS ="list_access.internal_name";
	public RetailscmChecker checkInternalNameOfListAccess(String internalName)
	{		
	 	checkStringLengthRange(internalName,1, 200,INTERNAL_NAME_OF_LIST_ACCESS ); 		
		
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

	public static final String  ID_OF_LOGIN_HISTORY ="login_history.id";
	public RetailscmChecker checkIdOfLoginHistory(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_LOGIN_HISTORY ); 		
		
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

	public static final String  ID_OF_CANDIDATE_CONTAINER ="candidate_container.id";
	public RetailscmChecker checkIdOfCandidateContainer(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_CONTAINER ="candidate_container.name";
	public RetailscmChecker checkNameOfCandidateContainer(String name)
	{		
	 	checkStringLengthRange(name,2, 28,NAME_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_CONTAINER ="candidate_container.version";
	public RetailscmChecker checkVersionOfCandidateContainer(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_CONTAINER ); 		
		
		return this;
	}	

	public static final String  ID_OF_CANDIDATE_ELEMENT ="candidate_element.id";
	public RetailscmChecker checkIdOfCandidateElement(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  NAME_OF_CANDIDATE_ELEMENT ="candidate_element.name";
	public RetailscmChecker checkNameOfCandidateElement(String name)
	{		
	 	checkStringLengthRange(name,1, 200,NAME_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  TYPE_OF_CANDIDATE_ELEMENT ="candidate_element.type";
	public RetailscmChecker checkTypeOfCandidateElement(String type)
	{		
	 	checkStringLengthRange(type,1, 200,TYPE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  IMAGE_OF_CANDIDATE_ELEMENT ="candidate_element.image";
	public RetailscmChecker checkImageOfCandidateElement(String image)
	{		
	 	checkImage(image,0, 512,IMAGE_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  CONTAINER_OF_CANDIDATE_ELEMENT ="candidate_element.container";
	public RetailscmChecker checkContainerIdOfCandidateElement(String containerId)
	{		
	 	checkIdOfCandidateElement(containerId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_CANDIDATE_ELEMENT ="candidate_element.version";
	public RetailscmChecker checkVersionOfCandidateElement(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_CANDIDATE_ELEMENT ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_WORKAPP_IDENTITY ="wechat_workapp_identity.id";
	public RetailscmChecker checkIdOfWechatWorkappIdentity(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_WORKAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  CORP_ID_OF_WECHAT_WORKAPP_IDENTITY ="wechat_workapp_identity.corp_id";
	public RetailscmChecker checkCorpIdOfWechatWorkappIdentity(String corpId)
	{		
	 	checkStringLengthRange(corpId,0, 100,CORP_ID_OF_WECHAT_WORKAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  USER_ID_OF_WECHAT_WORKAPP_IDENTITY ="wechat_workapp_identity.user_id";
	public RetailscmChecker checkUserIdOfWechatWorkappIdentity(String userId)
	{		
	 	checkStringLengthRange(userId,1, 100,USER_ID_OF_WECHAT_WORKAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_WORKAPP_IDENTITY ="wechat_workapp_identity.sec_user";
	public RetailscmChecker checkSecUserIdOfWechatWorkappIdentity(String secUserId)
	{		
	 	checkIdOfWechatWorkappIdentity(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTITY ="wechat_workapp_identity.last_login_time";
	public RetailscmChecker checkLastLoginTimeOfWechatWorkappIdentity(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_WORKAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_WORKAPP_IDENTITY ="wechat_workapp_identity.version";
	public RetailscmChecker checkVersionOfWechatWorkappIdentity(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_WORKAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  ID_OF_WECHAT_MINIAPP_IDENTITY ="wechat_miniapp_identity.id";
	public RetailscmChecker checkIdOfWechatMiniappIdentity(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_WECHAT_MINIAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  OPEN_ID_OF_WECHAT_MINIAPP_IDENTITY ="wechat_miniapp_identity.open_id";
	public RetailscmChecker checkOpenIdOfWechatMiniappIdentity(String openId)
	{		
	 	checkStringLengthRange(openId,5, 128,OPEN_ID_OF_WECHAT_MINIAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  APP_ID_OF_WECHAT_MINIAPP_IDENTITY ="wechat_miniapp_identity.app_id";
	public RetailscmChecker checkAppIdOfWechatMiniappIdentity(String appId)
	{		
	 	checkStringLengthRange(appId,5, 128,APP_ID_OF_WECHAT_MINIAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_WECHAT_MINIAPP_IDENTITY ="wechat_miniapp_identity.sec_user";
	public RetailscmChecker checkSecUserIdOfWechatMiniappIdentity(String secUserId)
	{		
	 	checkIdOfWechatMiniappIdentity(secUserId ); 		
		
		return this;
	}	

	public static final String  LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTITY ="wechat_miniapp_identity.last_login_time";
	public RetailscmChecker checkLastLoginTimeOfWechatMiniappIdentity(DateTime lastLoginTime)
	{
		if(lastLoginTime == null) {
			return this;
		}
		
	 	checkDateTime(lastLoginTime,parseTimestamp("1900-01-01T00:00:00"), parseTimestamp("2100-01-01T00:00:00"),LAST_LOGIN_TIME_OF_WECHAT_MINIAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_WECHAT_MINIAPP_IDENTITY ="wechat_miniapp_identity.version";
	public RetailscmChecker checkVersionOfWechatMiniappIdentity(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_WECHAT_MINIAPP_IDENTITY ); 		
		
		return this;
	}	

	public static final String  ID_OF_KEYPAIR_IDENTITY ="keypair_identity.id";
	public RetailscmChecker checkIdOfKeypairIdentity(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_KEYPAIR_IDENTITY ); 		
		
		return this;
	}	

	public static final String  PUBLIC_KEY_OF_KEYPAIR_IDENTITY ="keypair_identity.public_key";
	public RetailscmChecker checkPublicKeyOfKeypairIdentity(String publicKey)
	{		
	 	checkLongtext(publicKey,0, 1048576,PUBLIC_KEY_OF_KEYPAIR_IDENTITY ); 		
		
		return this;
	}	

	public static final String  KEY_TYPE_OF_KEYPAIR_IDENTITY ="keypair_identity.key_type";
	public RetailscmChecker checkKeyTypeIdOfKeypairIdentity(String keyTypeId)
	{		
	 	checkIdOfKeypairIdentity(keyTypeId ); 		
		
		return this;
	}	

	public static final String  SEC_USER_OF_KEYPAIR_IDENTITY ="keypair_identity.sec_user";
	public RetailscmChecker checkSecUserIdOfKeypairIdentity(String secUserId)
	{		
	 	checkIdOfKeypairIdentity(secUserId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_KEYPAIR_IDENTITY ="keypair_identity.version";
	public RetailscmChecker checkVersionOfKeypairIdentity(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_KEYPAIR_IDENTITY ); 		
		
		return this;
	}	

	public static final String  ID_OF_PUBLIC_KEY_TYPE ="public_key_type.id";
	public RetailscmChecker checkIdOfPublicKeyType(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  NAME_OF_PUBLIC_KEY_TYPE ="public_key_type.name";
	public RetailscmChecker checkNameOfPublicKeyType(String name)
	{		
	 	checkStringLengthRange(name,1, 12,NAME_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  CODE_OF_PUBLIC_KEY_TYPE ="public_key_type.code";
	public RetailscmChecker checkCodeOfPublicKeyType(String code)
	{		
	 	checkStringLengthRange(code,1, 12,CODE_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  DOMAIN_OF_PUBLIC_KEY_TYPE ="public_key_type.domain";
	public RetailscmChecker checkDomainIdOfPublicKeyType(String domainId)
	{		
	 	checkIdOfPublicKeyType(domainId ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_PUBLIC_KEY_TYPE ="public_key_type.version";
	public RetailscmChecker checkVersionOfPublicKeyType(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_PUBLIC_KEY_TYPE ); 		
		
		return this;
	}	

	public static final String  ID_OF_TREE_NODE ="tree_node.id";
	public RetailscmChecker checkIdOfTreeNode(String id)
	{		
	 	checkStringLengthRange(id,2, 64,ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_ID_OF_TREE_NODE ="tree_node.node_id";
	public RetailscmChecker checkNodeIdOfTreeNode(String nodeId)
	{		
	 	checkStringLengthRange(nodeId,3, 40,NODE_ID_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  NODE_TYPE_OF_TREE_NODE ="tree_node.node_type";
	public RetailscmChecker checkNodeTypeOfTreeNode(String nodeType)
	{		
	 	checkStringLengthRange(nodeType,3, 32,NODE_TYPE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  LEFT_VALUE_OF_TREE_NODE ="tree_node.left_value";
	public RetailscmChecker checkLeftValueOfTreeNode(int leftValue)
	{		
	 	checkIntegerRange(leftValue,1, 10000000,LEFT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  RIGHT_VALUE_OF_TREE_NODE ="tree_node.right_value";
	public RetailscmChecker checkRightValueOfTreeNode(int rightValue)
	{		
	 	checkIntegerRange(rightValue,2, 10000000,RIGHT_VALUE_OF_TREE_NODE ); 		
		
		return this;
	}	

	public static final String  VERSION_OF_TREE_NODE ="tree_node.version";
	public RetailscmChecker checkVersionOfTreeNode(int version)
	{		
	 	checkIntegerRange(version,0, Integer.MAX_VALUE,VERSION_OF_TREE_NODE ); 		
		
		return this;
	}	
}



















