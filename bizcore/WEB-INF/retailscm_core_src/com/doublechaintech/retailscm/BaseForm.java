package com.doublechaintech.retailscm;

import com.doublechaintech.retailscm.genericform.GenericForm;
import com.doublechaintech.retailscm.formfield.FormField;
import com.doublechaintech.retailscm.formaction.FormAction;
import com.doublechaintech.retailscm.formmessage.FormMessage;
import com.doublechaintech.retailscm.formfieldmessage.FormFieldMessage;




public class BaseForm extends GenericForm{

	public FormField getFieldByParamterName(String parameterName){
        
        for(FormField field: this.getFormFieldList()){
            if(parameterName.equals(field.getParameterName())){
                return field;
            }
            
        }
        return null;
    }
	public BaseForm hideByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setType("hidden");
				break;
			}
			
		}
		return this;
	}
	public BaseForm disableByParamterName(String parameterName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setDisabled(true);
				break;
			}
			
		}
		return this;
	}
	public BaseForm setAllGroupNameTo(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			field.setFieldGroup(groupName);
		}
		return this;
		
	}
	
	public BaseForm disableByGroup(String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(groupName.equals(field.getFieldGroup())){
				field.setDisabled(true);
				continue;
			}
			
		}
		return this;
		
	}
	
	public BaseForm setGroupNameByParamterName(String parameterName, String groupName){
		
		for(FormField field: this.getFormFieldList()){
			if(parameterName.equals(field.getParameterName())){
				field.setFieldGroup(groupName);
				break;
			}
			
		}
		return this;
		
	}


	protected FormField idFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_country_center.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_country_center.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField serviceNumberFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("服务号码");
		field.setLocaleKey("retail_store_country_center.service_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写服务号码");
		return field;
	}

	protected FormField foundedFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("retail_store_country_center.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField webSiteFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("网站");
		field.setLocaleKey("retail_store_country_center.web_site");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("url");
		field.setRequired(true);
		field.setPlaceholder("请填写网站");
		return field;
	}

	protected FormField addressFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("地址");
		field.setLocaleKey("retail_store_country_center.address");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写地址");
		return field;
	}

	protected FormField operatedByFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("由");
		field.setLocaleKey("retail_store_country_center.operated_by");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写由");
		return field;
	}

	protected FormField legalRepresentativeFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("法定代表人");
		field.setLocaleKey("retail_store_country_center.legal_representative");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写法定代表人");
		return field;
	}

	protected FormField descriptionFromRetailStoreCountryCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("retail_store_country_center.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("catalog.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("catalog.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField ownerIdFromCatalog(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("catalog.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromLevelOneCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("level_one_category.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField catalogIdFromLevelOneCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("目录");
		field.setLocaleKey("level_one_category.catalog");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Catalog");
		field.setRequired(true);
		field.setPlaceholder("请填写目录");
		return field;
	}

	protected FormField nameFromLevelOneCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("level_one_category.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField idFromLevelTwoCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("level_two_category.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField parentCategoryIdFromLevelTwoCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("父类");
		field.setLocaleKey("level_two_category.parent_category");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelOneCategory");
		field.setRequired(true);
		field.setPlaceholder("请填写父类");
		return field;
	}

	protected FormField nameFromLevelTwoCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("level_two_category.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField idFromLevelThreeCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("level_three_category.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField parentCategoryIdFromLevelThreeCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("父类");
		field.setLocaleKey("level_three_category.parent_category");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelTwoCategory");
		field.setRequired(true);
		field.setPlaceholder("请填写父类");
		return field;
	}

	protected FormField nameFromLevelThreeCategory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("level_three_category.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField idFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("product.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("product.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField parentCategoryIdFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("父类");
		field.setLocaleKey("product.parent_category");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelThreeCategory");
		field.setRequired(true);
		field.setPlaceholder("请填写父类");
		return field;
	}

	protected FormField originFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产地");
		field.setLocaleKey("product.origin");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产地");
		return field;
	}

	protected FormField remarkFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("备注");
		field.setLocaleKey("product.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写备注");
		return field;
	}

	protected FormField brandFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("品牌");
		field.setLocaleKey("product.brand");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写品牌");
		return field;
	}

	protected FormField pictureFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("图片");
		field.setLocaleKey("product.picture");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写图片");
		return field;
	}

	protected FormField lastUpdateTimeFromProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("product.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("sku.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("sku.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField sizeFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("大小");
		field.setLocaleKey("sku.size");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写大小");
		return field;
	}

	protected FormField productIdFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品");
		field.setLocaleKey("sku.product");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Product");
		field.setRequired(true);
		field.setPlaceholder("请填写产品");
		return field;
	}

	protected FormField barcodeFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("条码");
		field.setLocaleKey("sku.barcode");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写条码");
		return field;
	}

	protected FormField packageTypeFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("包装类型");
		field.setLocaleKey("sku.package_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写包装类型");
		return field;
	}

	protected FormField netContentFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("净含量");
		field.setLocaleKey("sku.net_content");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写净含量");
		return field;
	}

	protected FormField priceFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("价格");
		field.setLocaleKey("sku.price");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写价格");
		return field;
	}

	protected FormField pictureFromSku(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("图片");
		field.setLocaleKey("sku.picture");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写图片");
		return field;
	}

	protected FormField idFromRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_province_center.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_province_center.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField foundedFromRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("retail_store_province_center.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField countryIdFromRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("国");
		field.setLocaleKey("retail_store_province_center.country");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写国");
		return field;
	}

	protected FormField lastUpdateTimeFromRetailStoreProvinceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("retail_store_province_center.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromProvinceCenterDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("province_center_department.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromProvinceCenterDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("province_center_department.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField foundedFromProvinceCenterDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("province_center_department.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField provinceCenterIdFromProvinceCenterDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("省中心");
		field.setLocaleKey("province_center_department.province_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreProvinceCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写省中心");
		return field;
	}

	protected FormField managerFromProvinceCenterDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("经理");
		field.setLocaleKey("province_center_department.manager");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写经理");
		return field;
	}

	protected FormField idFromProvinceCenterEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("province_center_employee.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromProvinceCenterEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("province_center_employee.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField mobileFromProvinceCenterEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("province_center_employee.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField emailFromProvinceCenterEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("电子邮件");
		field.setLocaleKey("province_center_employee.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写电子邮件");
		return field;
	}

	protected FormField foundedFromProvinceCenterEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("province_center_employee.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField departmentIdFromProvinceCenterEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("部门");
		field.setLocaleKey("province_center_employee.department");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ProvinceCenterDepartment");
		field.setRequired(true);
		field.setPlaceholder("请填写部门");
		return field;
	}

	protected FormField provinceCenterIdFromProvinceCenterEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("省中心");
		field.setLocaleKey("province_center_employee.province_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreProvinceCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写省中心");
		return field;
	}

	protected FormField idFromRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_city_service_center.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_city_service_center.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField foundedFromRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("retail_store_city_service_center.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField belongsToIdFromRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("retail_store_city_service_center.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreProvinceCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField lastUpdateTimeFromRetailStoreCityServiceCenter(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("retail_store_city_service_center.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromCityPartner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("city_partner.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromCityPartner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("city_partner.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField mobileFromCityPartner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("city_partner.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField cityServiceCenterIdFromCityPartner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市服务中心");
		field.setLocaleKey("city_partner.city_service_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCityServiceCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写城市服务中心");
		return field;
	}

	protected FormField descriptionFromCityPartner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("city_partner.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField lastUpdateTimeFromCityPartner(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("city_partner.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromPotentialCustomer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("potential_customer.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromPotentialCustomer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("potential_customer.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField mobileFromPotentialCustomer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("potential_customer.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField cityServiceCenterIdFromPotentialCustomer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市服务中心");
		field.setLocaleKey("potential_customer.city_service_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCityServiceCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写城市服务中心");
		return field;
	}

	protected FormField cityPartnerIdFromPotentialCustomer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市合伙人");
		field.setLocaleKey("potential_customer.city_partner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("CityPartner");
		field.setRequired(true);
		field.setPlaceholder("请填写城市合伙人");
		return field;
	}

	protected FormField descriptionFromPotentialCustomer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("potential_customer.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField lastUpdateTimeFromPotentialCustomer(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("potential_customer.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("potential_customer_contact_person.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("potential_customer_contact_person.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField mobileFromPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("potential_customer_contact_person.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField potentialCustomerIdFromPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("潜在的客户");
		field.setLocaleKey("potential_customer_contact_person.potential_customer");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("PotentialCustomer");
		field.setRequired(true);
		field.setPlaceholder("请填写潜在的客户");
		return field;
	}

	protected FormField descriptionFromPotentialCustomerContactPerson(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("potential_customer_contact_person.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("potential_customer_contact.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("potential_customer_contact.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField contactDateFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("接触日期");
		field.setLocaleKey("potential_customer_contact.contact_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写接触日期");
		return field;
	}

	protected FormField contactMethodFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("接触法");
		field.setLocaleKey("potential_customer_contact.contact_method");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写接触法");
		return field;
	}

	protected FormField potentialCustomerIdFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("潜在的客户");
		field.setLocaleKey("potential_customer_contact.potential_customer");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("PotentialCustomer");
		field.setRequired(true);
		field.setPlaceholder("请填写潜在的客户");
		return field;
	}

	protected FormField cityPartnerIdFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市合伙人");
		field.setLocaleKey("potential_customer_contact.city_partner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("CityPartner");
		field.setRequired(true);
		field.setPlaceholder("请填写城市合伙人");
		return field;
	}

	protected FormField contactToIdFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("接触");
		field.setLocaleKey("potential_customer_contact.contact_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("PotentialCustomerContactPerson");
		field.setRequired(true);
		field.setPlaceholder("请填写接触");
		return field;
	}

	protected FormField descriptionFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("potential_customer_contact.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField lastUpdateTimeFromPotentialCustomerContact(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("potential_customer_contact.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromCityEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("city_event.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromCityEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("city_event.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField mobileFromCityEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("city_event.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField cityServiceCenterIdFromCityEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市服务中心");
		field.setLocaleKey("city_event.city_service_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCityServiceCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写城市服务中心");
		return field;
	}

	protected FormField descriptionFromCityEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("city_event.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField lastUpdateTimeFromCityEvent(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("city_event.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromEventAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("event_attendance.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromEventAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("event_attendance.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField potentialCustomerIdFromEventAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("潜在的客户");
		field.setLocaleKey("event_attendance.potential_customer");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("PotentialCustomer");
		field.setRequired(true);
		field.setPlaceholder("请填写潜在的客户");
		return field;
	}

	protected FormField cityEventIdFromEventAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市活动");
		field.setLocaleKey("event_attendance.city_event");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("CityEvent");
		field.setRequired(true);
		field.setPlaceholder("请填写城市活动");
		return field;
	}

	protected FormField descriptionFromEventAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("event_attendance.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField telephoneFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("电话");
		field.setLocaleKey("retail_store.telephone");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写电话");
		return field;
	}

	protected FormField ownerFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("retail_store.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField retailStoreCountryCenterIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("双链小超全国运营中心");
		field.setLocaleKey("retail_store.retail_store_country_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写双链小超全国运营中心");
		return field;
	}

	protected FormField cityServiceCenterIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市服务中心");
		field.setLocaleKey("retail_store.city_service_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCityServiceCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写城市服务中心");
		return field;
	}

	protected FormField creationIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建");
		field.setLocaleKey("retail_store.creation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCreation");
		field.setRequired(true);
		field.setPlaceholder("请填写创建");
		return field;
	}

	protected FormField investmentInvitationIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("招商");
		field.setLocaleKey("retail_store.investment_invitation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreInvestmentInvitation");
		field.setRequired(true);
		field.setPlaceholder("请填写招商");
		return field;
	}

	protected FormField franchisingIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("加盟");
		field.setLocaleKey("retail_store.franchising");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreFranchising");
		field.setRequired(true);
		field.setPlaceholder("请填写加盟");
		return field;
	}

	protected FormField decorationIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("装修");
		field.setLocaleKey("retail_store.decoration");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreDecoration");
		field.setRequired(true);
		field.setPlaceholder("请填写装修");
		return field;
	}

	protected FormField openingIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("开业");
		field.setLocaleKey("retail_store.opening");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOpening");
		field.setRequired(true);
		field.setPlaceholder("请填写开业");
		return field;
	}

	protected FormField closingIdFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("关闭");
		field.setLocaleKey("retail_store.closing");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreClosing");
		field.setRequired(true);
		field.setPlaceholder("请填写关闭");
		return field;
	}

	protected FormField foundedFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("retail_store.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField latitudeFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("retail_store.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("retail_store.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField descriptionFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("retail_store.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField lastUpdateTimeFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("retail_store.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField currentStatusFromRetailStore(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("retail_store.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromRetailStoreCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_creation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField commentFromRetailStoreCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("retail_store_creation.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromRetailStoreInvestmentInvitation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_investment_invitation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField commentFromRetailStoreInvestmentInvitation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("retail_store_investment_invitation.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromRetailStoreFranchising(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_franchising.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField commentFromRetailStoreFranchising(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("retail_store_franchising.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromRetailStoreDecoration(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_decoration.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField commentFromRetailStoreDecoration(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("retail_store_decoration.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromRetailStoreOpening(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_opening.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField commentFromRetailStoreOpening(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("retail_store_opening.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromRetailStoreClosing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_closing.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField commentFromRetailStoreClosing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("retail_store_closing.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromRetailStoreMember(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_member.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreMember(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_member.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField mobilePhoneFromRetailStoreMember(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("移动电话");
		field.setLocaleKey("retail_store_member.mobile_phone");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写移动电话");
		return field;
	}

	protected FormField ownerIdFromRetailStoreMember(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("retail_store_member.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("consumer_order.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField consumerIdFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("消费者");
		field.setLocaleKey("consumer_order.consumer");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMember");
		field.setRequired(true);
		field.setPlaceholder("请填写消费者");
		return field;
	}

	protected FormField confirmationIdFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认");
		field.setLocaleKey("consumer_order.confirmation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderConfirmation");
		field.setRequired(true);
		field.setPlaceholder("请填写确认");
		return field;
	}

	protected FormField approvalIdFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("验收");
		field.setLocaleKey("consumer_order.approval");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderApproval");
		field.setRequired(true);
		field.setPlaceholder("请填写验收");
		return field;
	}

	protected FormField processingIdFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("处理");
		field.setLocaleKey("consumer_order.processing");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderProcessing");
		field.setRequired(true);
		field.setPlaceholder("请填写处理");
		return field;
	}

	protected FormField shipmentIdFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("装运");
		field.setLocaleKey("consumer_order.shipment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderShipment");
		field.setRequired(true);
		field.setPlaceholder("请填写装运");
		return field;
	}

	protected FormField deliveryIdFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("送货");
		field.setLocaleKey("consumer_order.delivery");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderDelivery");
		field.setRequired(true);
		field.setPlaceholder("请填写送货");
		return field;
	}

	protected FormField storeIdFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("商场");
		field.setLocaleKey("consumer_order.store");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStore");
		field.setRequired(true);
		field.setPlaceholder("请填写商场");
		return field;
	}

	protected FormField lastUpdateTimeFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("consumer_order.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField currentStatusFromConsumerOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("consumer_order.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromConsumerOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_confirmation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromConsumerOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("consumer_order_confirmation.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField confirmTimeFromConsumerOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认时间");
		field.setLocaleKey("consumer_order_confirmation.confirm_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写确认时间");
		return field;
	}

	protected FormField idFromConsumerOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_approval.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromConsumerOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("consumer_order_approval.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField approveTimeFromConsumerOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("批准时间");
		field.setLocaleKey("consumer_order_approval.approve_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写批准时间");
		return field;
	}

	protected FormField idFromConsumerOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_processing.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromConsumerOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("consumer_order_processing.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField processTimeFromConsumerOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("过程的时间");
		field.setLocaleKey("consumer_order_processing.process_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写过程的时间");
		return field;
	}

	protected FormField idFromConsumerOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_shipment.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromConsumerOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("consumer_order_shipment.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField shipTimeFromConsumerOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("船的时间");
		field.setLocaleKey("consumer_order_shipment.ship_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写船的时间");
		return field;
	}

	protected FormField idFromConsumerOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_delivery.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromConsumerOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("consumer_order_delivery.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField deliveryTimeFromConsumerOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("交货时间");
		field.setLocaleKey("consumer_order_delivery.delivery_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写交货时间");
		return field;
	}

	protected FormField idFromConsumerOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_line_item.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField bizOrderIdFromConsumerOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("consumer_order_line_item.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ConsumerOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField skuIdFromConsumerOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品ID");
		field.setLocaleKey("consumer_order_line_item.sku_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品ID");
		return field;
	}

	protected FormField skuNameFromConsumerOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品名称");
		field.setLocaleKey("consumer_order_line_item.sku_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品名称");
		return field;
	}

	protected FormField priceFromConsumerOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("价格");
		field.setLocaleKey("consumer_order_line_item.price");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写价格");
		return field;
	}

	protected FormField quantityFromConsumerOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("数量");
		field.setLocaleKey("consumer_order_line_item.quantity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写数量");
		return field;
	}

	protected FormField amountFromConsumerOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("consumer_order_line_item.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField idFromConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_shipping_group.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("consumer_order_shipping_group.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField bizOrderIdFromConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("consumer_order_shipping_group.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ConsumerOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField amountFromConsumerOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("consumer_order_shipping_group.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField idFromConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_payment_group.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("consumer_order_payment_group.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField bizOrderIdFromConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("consumer_order_payment_group.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ConsumerOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField cardNumberFromConsumerOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("卡号码");
		field.setLocaleKey("consumer_order_payment_group.card_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写卡号码");
		return field;
	}

	protected FormField idFromConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("consumer_order_price_adjustment.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("consumer_order_price_adjustment.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField bizOrderIdFromConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("consumer_order_price_adjustment.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ConsumerOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField amountFromConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("consumer_order_price_adjustment.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField providerFromConsumerOrderPriceAdjustment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("供应商");
		field.setLocaleKey("consumer_order_price_adjustment.provider");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写供应商");
		return field;
	}

	protected FormField idFromRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_member_coupon.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_member_coupon.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField ownerIdFromRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("retail_store_member_coupon.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMember");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField numberFromRetailStoreMemberCoupon(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("数");
		field.setLocaleKey("retail_store_member_coupon.number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写数");
		return field;
	}

	protected FormField idFromMemberWishlist(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("member_wishlist.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromMemberWishlist(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("member_wishlist.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField ownerIdFromMemberWishlist(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("member_wishlist.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMember");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromMemberRewardPoint(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("member_reward_point.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromMemberRewardPoint(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("member_reward_point.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField pointFromMemberRewardPoint(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("点");
		field.setLocaleKey("member_reward_point.point");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写点");
		return field;
	}

	protected FormField ownerIdFromMemberRewardPoint(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("member_reward_point.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMember");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("member_reward_point_redemption.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("member_reward_point_redemption.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField pointFromMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("点");
		field.setLocaleKey("member_reward_point_redemption.point");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写点");
		return field;
	}

	protected FormField ownerIdFromMemberRewardPointRedemption(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("member_reward_point_redemption.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMember");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromMemberWishlistProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("member_wishlist_product.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromMemberWishlistProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("member_wishlist_product.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField ownerIdFromMemberWishlistProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("member_wishlist_product.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("MemberWishlist");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_member_address.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_member_address.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField ownerIdFromRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("retail_store_member_address.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMember");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField mobilePhoneFromRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("移动电话");
		field.setLocaleKey("retail_store_member_address.mobile_phone");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写移动电话");
		return field;
	}

	protected FormField addressFromRetailStoreMemberAddress(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("地址");
		field.setLocaleKey("retail_store_member_address.address");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写地址");
		return field;
	}

	protected FormField idFromRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_member_gift_card.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_member_gift_card.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField ownerIdFromRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("retail_store_member_gift_card.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMember");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField numberFromRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("数");
		field.setLocaleKey("retail_store_member_gift_card.number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写数");
		return field;
	}

	protected FormField remainFromRetailStoreMemberGiftCard(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("保持");
		field.setLocaleKey("retail_store_member_gift_card.remain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写保持");
		return field;
	}

	protected FormField idFromRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_member_gift_card_consume_record.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField occureTimeFromRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("发生时间");
		field.setLocaleKey("retail_store_member_gift_card_consume_record.occure_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写发生时间");
		return field;
	}

	protected FormField ownerIdFromRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("retail_store_member_gift_card_consume_record.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreMemberGiftCard");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField bizOrderIdFromRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("retail_store_member_gift_card_consume_record.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ConsumerOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField numberFromRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("数");
		field.setLocaleKey("retail_store_member_gift_card_consume_record.number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写数");
		return field;
	}

	protected FormField amountFromRetailStoreMemberGiftCardConsumeRecord(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("retail_store_member_gift_card_consume_record.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField idFromGoodsSupplier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("goods_supplier.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromGoodsSupplier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("goods_supplier.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField supplyProductFromGoodsSupplier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("供应产品");
		field.setLocaleKey("goods_supplier.supply_product");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写供应产品");
		return field;
	}

	protected FormField belongToIdFromGoodsSupplier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("goods_supplier.belong_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField contactNumberFromGoodsSupplier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("goods_supplier.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField descriptionFromGoodsSupplier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("goods_supplier.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField lastUpdateTimeFromGoodsSupplier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("goods_supplier.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromSupplierProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supplier_product.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField productNameFromSupplierProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("品名");
		field.setLocaleKey("supplier_product.product_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写品名");
		return field;
	}

	protected FormField productDescriptionFromSupplierProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品描述");
		field.setLocaleKey("supplier_product.product_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品描述");
		return field;
	}

	protected FormField productUnitFromSupplierProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品单元");
		field.setLocaleKey("supplier_product.product_unit");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品单元");
		return field;
	}

	protected FormField supplierIdFromSupplierProduct(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("供应商");
		field.setLocaleKey("supplier_product.supplier");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsSupplier");
		field.setRequired(true);
		field.setPlaceholder("请填写供应商");
		return field;
	}

	protected FormField idFromProductSupplyDuration(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("product_supply_duration.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField quantityFromProductSupplyDuration(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("数量");
		field.setLocaleKey("product_supply_duration.quantity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写数量");
		return field;
	}

	protected FormField durationFromProductSupplyDuration(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("持续时间");
		field.setLocaleKey("product_supply_duration.duration");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写持续时间");
		return field;
	}

	protected FormField priceFromProductSupplyDuration(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("价格");
		field.setLocaleKey("product_supply_duration.price");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写价格");
		return field;
	}

	protected FormField productIdFromProductSupplyDuration(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品");
		field.setLocaleKey("product_supply_duration.product");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplierProduct");
		field.setRequired(true);
		field.setPlaceholder("请填写产品");
		return field;
	}

	protected FormField idFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField buyerIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("买方");
		field.setLocaleKey("supply_order.buyer");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写买方");
		return field;
	}

	protected FormField sellerIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("卖方");
		field.setLocaleKey("supply_order.seller");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsSupplier");
		field.setRequired(true);
		field.setPlaceholder("请填写卖方");
		return field;
	}

	protected FormField titleFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("supply_order.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField totalAmountFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总金额");
		field.setLocaleKey("supply_order.total_amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写总金额");
		return field;
	}

	protected FormField confirmationIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认");
		field.setLocaleKey("supply_order.confirmation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderConfirmation");
		field.setRequired(true);
		field.setPlaceholder("请填写确认");
		return field;
	}

	protected FormField approvalIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("验收");
		field.setLocaleKey("supply_order.approval");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderApproval");
		field.setRequired(true);
		field.setPlaceholder("请填写验收");
		return field;
	}

	protected FormField processingIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("处理");
		field.setLocaleKey("supply_order.processing");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderProcessing");
		field.setRequired(true);
		field.setPlaceholder("请填写处理");
		return field;
	}

	protected FormField pickingIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("捡货");
		field.setLocaleKey("supply_order.picking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderPicking");
		field.setRequired(true);
		field.setPlaceholder("请填写捡货");
		return field;
	}

	protected FormField shipmentIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("装运");
		field.setLocaleKey("supply_order.shipment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderShipment");
		field.setRequired(true);
		field.setPlaceholder("请填写装运");
		return field;
	}

	protected FormField deliveryIdFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("送货");
		field.setLocaleKey("supply_order.delivery");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrderDelivery");
		field.setRequired(true);
		field.setPlaceholder("请填写送货");
		return field;
	}

	protected FormField lastUpdateTimeFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("supply_order.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField currentStatusFromSupplyOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("supply_order.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_confirmation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("supply_order_confirmation.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField confirmTimeFromSupplyOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认时间");
		field.setLocaleKey("supply_order_confirmation.confirm_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写确认时间");
		return field;
	}

	protected FormField idFromSupplyOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_approval.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromSupplyOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("supply_order_approval.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField approveTimeFromSupplyOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("批准时间");
		field.setLocaleKey("supply_order_approval.approve_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写批准时间");
		return field;
	}

	protected FormField idFromSupplyOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_processing.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromSupplyOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("supply_order_processing.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField processTimeFromSupplyOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("过程的时间");
		field.setLocaleKey("supply_order_processing.process_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写过程的时间");
		return field;
	}

	protected FormField idFromSupplyOrderPicking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_picking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromSupplyOrderPicking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("supply_order_picking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField processTimeFromSupplyOrderPicking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("过程的时间");
		field.setLocaleKey("supply_order_picking.process_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写过程的时间");
		return field;
	}

	protected FormField idFromSupplyOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_shipment.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromSupplyOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("supply_order_shipment.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField shipTimeFromSupplyOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("船的时间");
		field.setLocaleKey("supply_order_shipment.ship_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写船的时间");
		return field;
	}

	protected FormField idFromSupplyOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_delivery.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromSupplyOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("supply_order_delivery.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField deliveryTimeFromSupplyOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("交货时间");
		field.setLocaleKey("supply_order_delivery.delivery_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写交货时间");
		return field;
	}

	protected FormField idFromSupplyOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_line_item.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField bizOrderIdFromSupplyOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("supply_order_line_item.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField skuIdFromSupplyOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品ID");
		field.setLocaleKey("supply_order_line_item.sku_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品ID");
		return field;
	}

	protected FormField skuNameFromSupplyOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品名称");
		field.setLocaleKey("supply_order_line_item.sku_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品名称");
		return field;
	}

	protected FormField amountFromSupplyOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("supply_order_line_item.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField quantityFromSupplyOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("数量");
		field.setLocaleKey("supply_order_line_item.quantity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写数量");
		return field;
	}

	protected FormField unitOfMeasurementFromSupplyOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("测量单位");
		field.setLocaleKey("supply_order_line_item.unit_of_measurement");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写测量单位");
		return field;
	}

	protected FormField idFromSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_shipping_group.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("supply_order_shipping_group.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField bizOrderIdFromSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("supply_order_shipping_group.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField amountFromSupplyOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("supply_order_shipping_group.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField idFromSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supply_order_payment_group.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("supply_order_payment_group.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField bizOrderIdFromSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("supply_order_payment_group.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField cardNumberFromSupplyOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("卡号码");
		field.setLocaleKey("supply_order_payment_group.card_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写卡号码");
		return field;
	}

	protected FormField idFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField buyerIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("买方");
		field.setLocaleKey("retail_store_order.buyer");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStore");
		field.setRequired(true);
		field.setPlaceholder("请填写买方");
		return field;
	}

	protected FormField sellerIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("卖方");
		field.setLocaleKey("retail_store_order.seller");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写卖方");
		return field;
	}

	protected FormField titleFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("retail_store_order.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField totalAmountFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总金额");
		field.setLocaleKey("retail_store_order.total_amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写总金额");
		return field;
	}

	protected FormField confirmationIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认");
		field.setLocaleKey("retail_store_order.confirmation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrderConfirmation");
		field.setRequired(true);
		field.setPlaceholder("请填写确认");
		return field;
	}

	protected FormField approvalIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("验收");
		field.setLocaleKey("retail_store_order.approval");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrderApproval");
		field.setRequired(true);
		field.setPlaceholder("请填写验收");
		return field;
	}

	protected FormField processingIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("处理");
		field.setLocaleKey("retail_store_order.processing");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrderProcessing");
		field.setRequired(true);
		field.setPlaceholder("请填写处理");
		return field;
	}

	protected FormField pickingIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("捡货");
		field.setLocaleKey("retail_store_order.picking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrderPicking");
		field.setRequired(true);
		field.setPlaceholder("请填写捡货");
		return field;
	}

	protected FormField shipmentIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("装运");
		field.setLocaleKey("retail_store_order.shipment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrderShipment");
		field.setRequired(true);
		field.setPlaceholder("请填写装运");
		return field;
	}

	protected FormField deliveryIdFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("送货");
		field.setLocaleKey("retail_store_order.delivery");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrderDelivery");
		field.setRequired(true);
		field.setPlaceholder("请填写送货");
		return field;
	}

	protected FormField lastUpdateTimeFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("retail_store_order.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField currentStatusFromRetailStoreOrder(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("retail_store_order.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromRetailStoreOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_confirmation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromRetailStoreOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("retail_store_order_confirmation.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField confirmTimeFromRetailStoreOrderConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认时间");
		field.setLocaleKey("retail_store_order_confirmation.confirm_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写确认时间");
		return field;
	}

	protected FormField idFromRetailStoreOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_approval.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromRetailStoreOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("retail_store_order_approval.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField approveTimeFromRetailStoreOrderApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("批准时间");
		field.setLocaleKey("retail_store_order_approval.approve_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写批准时间");
		return field;
	}

	protected FormField idFromRetailStoreOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_processing.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromRetailStoreOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("retail_store_order_processing.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField processTimeFromRetailStoreOrderProcessing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("过程的时间");
		field.setLocaleKey("retail_store_order_processing.process_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写过程的时间");
		return field;
	}

	protected FormField idFromRetailStoreOrderPicking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_picking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromRetailStoreOrderPicking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("retail_store_order_picking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField processTimeFromRetailStoreOrderPicking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("过程的时间");
		field.setLocaleKey("retail_store_order_picking.process_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写过程的时间");
		return field;
	}

	protected FormField idFromRetailStoreOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_shipment.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromRetailStoreOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("retail_store_order_shipment.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField shipTimeFromRetailStoreOrderShipment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("船的时间");
		field.setLocaleKey("retail_store_order_shipment.ship_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写船的时间");
		return field;
	}

	protected FormField idFromRetailStoreOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_delivery.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromRetailStoreOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("retail_store_order_delivery.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField deliveryTimeFromRetailStoreOrderDelivery(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("交货时间");
		field.setLocaleKey("retail_store_order_delivery.delivery_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写交货时间");
		return field;
	}

	protected FormField idFromRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_line_item.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField bizOrderIdFromRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("retail_store_order_line_item.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField skuIdFromRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品ID");
		field.setLocaleKey("retail_store_order_line_item.sku_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品ID");
		return field;
	}

	protected FormField skuNameFromRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品名称");
		field.setLocaleKey("retail_store_order_line_item.sku_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写产品名称");
		return field;
	}

	protected FormField amountFromRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("retail_store_order_line_item.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField quantityFromRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("数量");
		field.setLocaleKey("retail_store_order_line_item.quantity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写数量");
		return field;
	}

	protected FormField unitOfMeasurementFromRetailStoreOrderLineItem(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("测量单位");
		field.setLocaleKey("retail_store_order_line_item.unit_of_measurement");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写测量单位");
		return field;
	}

	protected FormField idFromRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_shipping_group.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_order_shipping_group.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField bizOrderIdFromRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("retail_store_order_shipping_group.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField amountFromRetailStoreOrderShippingGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("retail_store_order_shipping_group.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField idFromRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("retail_store_order_payment_group.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("retail_store_order_payment_group.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField bizOrderIdFromRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("retail_store_order_payment_group.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField cardNumberFromRetailStoreOrderPaymentGroup(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("卡号码");
		field.setLocaleKey("retail_store_order_payment_group.card_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写卡号码");
		return field;
	}

	protected FormField idFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("warehouse.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("warehouse.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField contactNumberFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("warehouse.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField totalAreaFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总面积");
		field.setLocaleKey("warehouse.total_area");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写总面积");
		return field;
	}

	protected FormField ownerIdFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("warehouse.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField latitudeFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("warehouse.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("warehouse.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField lastUpdateTimeFromWarehouse(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("warehouse.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromStorageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("storage_space.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromStorageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("storage_space.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField contactNumberFromStorageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("storage_space.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField totalAreaFromStorageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总面积");
		field.setLocaleKey("storage_space.total_area");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写总面积");
		return field;
	}

	protected FormField warehouseIdFromStorageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("仓库");
		field.setLocaleKey("storage_space.warehouse");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Warehouse");
		field.setRequired(true);
		field.setPlaceholder("请填写仓库");
		return field;
	}

	protected FormField latitudeFromStorageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("storage_space.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromStorageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("storage_space.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField idFromSmartPallet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("smart_pallet.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromSmartPallet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("smart_pallet.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField contactNumberFromSmartPallet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("smart_pallet.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField totalAreaFromSmartPallet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总面积");
		field.setLocaleKey("smart_pallet.total_area");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写总面积");
		return field;
	}

	protected FormField latitudeFromSmartPallet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("smart_pallet.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromSmartPallet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("smart_pallet.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField warehouseIdFromSmartPallet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("仓库");
		field.setLocaleKey("smart_pallet.warehouse");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Warehouse");
		field.setRequired(true);
		field.setPlaceholder("请填写仓库");
		return field;
	}

	protected FormField idFromGoodsShelf(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("goods_shelf.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromGoodsShelf(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("goods_shelf.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField storageSpaceIdFromGoodsShelf(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("存货区");
		field.setLocaleKey("goods_shelf.storage_space");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("StorageSpace");
		field.setRequired(true);
		field.setPlaceholder("请填写存货区");
		return field;
	}

	protected FormField supplierSpaceIdFromGoodsShelf(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("供应商的空间");
		field.setLocaleKey("goods_shelf.supplier_space");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplierSpace");
		field.setRequired(true);
		field.setPlaceholder("请填写供应商的空间");
		return field;
	}

	protected FormField damageSpaceIdFromGoodsShelf(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("残次货物存放区");
		field.setLocaleKey("goods_shelf.damage_space");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("DamageSpace");
		field.setRequired(true);
		field.setPlaceholder("请填写残次货物存放区");
		return field;
	}

	protected FormField idFromGoodsShelfStockCount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("goods_shelf_stock_count.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromGoodsShelfStockCount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("goods_shelf_stock_count.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField countTimeFromGoodsShelfStockCount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("计数时间");
		field.setLocaleKey("goods_shelf_stock_count.count_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写计数时间");
		return field;
	}

	protected FormField summaryFromGoodsShelfStockCount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("概览");
		field.setLocaleKey("goods_shelf_stock_count.summary");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写概览");
		return field;
	}

	protected FormField shelfIdFromGoodsShelfStockCount(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("架");
		field.setLocaleKey("goods_shelf_stock_count.shelf");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsShelf");
		field.setRequired(true);
		field.setPlaceholder("请填写架");
		return field;
	}

	protected FormField idFromStockCountIssueTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("stock_count_issue_track.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromStockCountIssueTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("stock_count_issue_track.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField countTimeFromStockCountIssueTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("计数时间");
		field.setLocaleKey("stock_count_issue_track.count_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写计数时间");
		return field;
	}

	protected FormField summaryFromStockCountIssueTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("概览");
		field.setLocaleKey("stock_count_issue_track.summary");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写概览");
		return field;
	}

	protected FormField stockCountIdFromStockCountIssueTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("盘点");
		field.setLocaleKey("stock_count_issue_track.stock_count");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsShelfStockCount");
		field.setRequired(true);
		field.setPlaceholder("请填写盘点");
		return field;
	}

	protected FormField idFromGoodsAllocation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("goods_allocation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromGoodsAllocation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("goods_allocation.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField latitudeFromGoodsAllocation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("goods_allocation.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromGoodsAllocation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("goods_allocation.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField goodsShelfIdFromGoodsAllocation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("货架");
		field.setLocaleKey("goods_allocation.goods_shelf");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsShelf");
		field.setRequired(true);
		field.setPlaceholder("请填写货架");
		return field;
	}

	protected FormField idFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("goods.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("goods.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField rfidFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("RFID");
		field.setLocaleKey("goods.rfid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写RFID");
		return field;
	}

	protected FormField uomFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("计量单位");
		field.setLocaleKey("goods.uom");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写计量单位");
		return field;
	}

	protected FormField maxPackageFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("最大包装");
		field.setLocaleKey("goods.max_package");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写最大包装");
		return field;
	}

	protected FormField expireTimeFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("到期时间");
		field.setLocaleKey("goods.expire_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写到期时间");
		return field;
	}

	protected FormField skuIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("SKU");
		field.setLocaleKey("goods.sku");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Sku");
		field.setRequired(true);
		field.setPlaceholder("请填写SKU");
		return field;
	}

	protected FormField receivingSpaceIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("收货区");
		field.setLocaleKey("goods.receiving_space");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ReceivingSpace");
		field.setRequired(true);
		field.setPlaceholder("请填写收货区");
		return field;
	}

	protected FormField goodsAllocationIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("货位");
		field.setLocaleKey("goods.goods_allocation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsAllocation");
		field.setRequired(true);
		field.setPlaceholder("请填写货位");
		return field;
	}

	protected FormField smartPalletIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("智能托盘");
		field.setLocaleKey("goods.smart_pallet");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SmartPallet");
		field.setRequired(true);
		field.setPlaceholder("请填写智能托盘");
		return field;
	}

	protected FormField shippingSpaceIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("发货区");
		field.setLocaleKey("goods.shipping_space");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ShippingSpace");
		field.setRequired(true);
		field.setPlaceholder("请填写发货区");
		return field;
	}

	protected FormField transportTaskIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("运输任务");
		field.setLocaleKey("goods.transport_task");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TransportTask");
		field.setRequired(true);
		field.setPlaceholder("请填写运输任务");
		return field;
	}

	protected FormField retailStoreIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("双链小超");
		field.setLocaleKey("goods.retail_store");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStore");
		field.setRequired(true);
		field.setPlaceholder("请填写双链小超");
		return field;
	}

	protected FormField bizOrderIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("订单");
		field.setLocaleKey("goods.biz_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SupplyOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写订单");
		return field;
	}

	protected FormField retailStoreOrderIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("生超的订单");
		field.setLocaleKey("goods.retail_store_order");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreOrder");
		field.setRequired(true);
		field.setPlaceholder("请填写生超的订单");
		return field;
	}

	protected FormField packagingIdFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("包装");
		field.setLocaleKey("goods.packaging");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsPackaging");
		field.setRequired(true);
		field.setPlaceholder("请填写包装");
		return field;
	}

	protected FormField currentStatusFromGoods(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("goods.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromGoodsPackaging(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("goods_packaging.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField packageNameFromGoodsPackaging(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("包的名字");
		field.setLocaleKey("goods_packaging.package_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写包的名字");
		return field;
	}

	protected FormField rfidFromGoodsPackaging(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("RFID");
		field.setLocaleKey("goods_packaging.rfid");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写RFID");
		return field;
	}

	protected FormField packageTimeFromGoodsPackaging(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("包的时间");
		field.setLocaleKey("goods_packaging.package_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写包的时间");
		return field;
	}

	protected FormField descriptionFromGoodsPackaging(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("goods_packaging.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("goods_movement.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField moveTimeFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("移动时间");
		field.setLocaleKey("goods_movement.move_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写移动时间");
		return field;
	}

	protected FormField facilityFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("设施");
		field.setLocaleKey("goods_movement.facility");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写设施");
		return field;
	}

	protected FormField facilityIdFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("设备ID");
		field.setLocaleKey("goods_movement.facility_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写设备ID");
		return field;
	}

	protected FormField fromIpFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("从IP");
		field.setLocaleKey("goods_movement.from_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写从IP");
		return field;
	}

	protected FormField userAgentFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("用户代理");
		field.setLocaleKey("goods_movement.user_agent");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写用户代理");
		return field;
	}

	protected FormField sessionIdFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会话ID");
		field.setLocaleKey("goods_movement.session_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写会话ID");
		return field;
	}

	protected FormField latitudeFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("goods_movement.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("goods_movement.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField goodsIdFromGoodsMovement(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("货物");
		field.setLocaleKey("goods_movement.goods");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Goods");
		field.setRequired(true);
		field.setPlaceholder("请填写货物");
		return field;
	}

	protected FormField idFromSupplierSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("supplier_space.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromSupplierSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("supplier_space.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField contactNumberFromSupplierSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("supplier_space.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField totalAreaFromSupplierSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总面积");
		field.setLocaleKey("supplier_space.total_area");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写总面积");
		return field;
	}

	protected FormField warehouseIdFromSupplierSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("仓库");
		field.setLocaleKey("supplier_space.warehouse");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Warehouse");
		field.setRequired(true);
		field.setPlaceholder("请填写仓库");
		return field;
	}

	protected FormField latitudeFromSupplierSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("supplier_space.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromSupplierSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("supplier_space.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField idFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("receiving_space.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("receiving_space.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField contactNumberFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("receiving_space.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField descriptionFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("receiving_space.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField totalAreaFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总面积");
		field.setLocaleKey("receiving_space.total_area");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写总面积");
		return field;
	}

	protected FormField warehouseIdFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("仓库");
		field.setLocaleKey("receiving_space.warehouse");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Warehouse");
		field.setRequired(true);
		field.setPlaceholder("请填写仓库");
		return field;
	}

	protected FormField latitudeFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("receiving_space.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromReceivingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("receiving_space.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField idFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("shipping_space.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("shipping_space.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField contactNumberFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("shipping_space.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField totalAreaFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总面积");
		field.setLocaleKey("shipping_space.total_area");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写总面积");
		return field;
	}

	protected FormField warehouseIdFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("仓库");
		field.setLocaleKey("shipping_space.warehouse");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Warehouse");
		field.setRequired(true);
		field.setPlaceholder("请填写仓库");
		return field;
	}

	protected FormField latitudeFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("shipping_space.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("shipping_space.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField descriptionFromShippingSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("shipping_space.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromDamageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("damage_space.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField locationFromDamageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("damage_space.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField contactNumberFromDamageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("damage_space.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField totalAreaFromDamageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("总面积");
		field.setLocaleKey("damage_space.total_area");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写总面积");
		return field;
	}

	protected FormField latitudeFromDamageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("damage_space.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromDamageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("damage_space.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField warehouseIdFromDamageSpace(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("仓库");
		field.setLocaleKey("damage_space.warehouse");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Warehouse");
		field.setRequired(true);
		field.setPlaceholder("请填写仓库");
		return field;
	}

	protected FormField idFromWarehouseAsset(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("warehouse_asset.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromWarehouseAsset(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("warehouse_asset.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField positionFromWarehouseAsset(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Position");
		field.setLocaleKey("warehouse_asset.position");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Position");
		return field;
	}

	protected FormField ownerIdFromWarehouseAsset(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("warehouse_asset.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Warehouse");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromTransportFleet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("transport_fleet.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromTransportFleet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("transport_fleet.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField contactNumberFromTransportFleet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("transport_fleet.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField ownerIdFromTransportFleet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("transport_fleet.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField lastUpdateTimeFromTransportFleet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("transport_fleet.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("transport_truck.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("transport_truck.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField plateNumberFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("车牌号码");
		field.setLocaleKey("transport_truck.plate_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写车牌号码");
		return field;
	}

	protected FormField contactNumberFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("transport_truck.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField vehicleLicenseNumberFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("汽车牌照号码");
		field.setLocaleKey("transport_truck.vehicle_license_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写汽车牌照号码");
		return field;
	}

	protected FormField engineNumberFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("发动机号");
		field.setLocaleKey("transport_truck.engine_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写发动机号");
		return field;
	}

	protected FormField makeDateFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("transport_truck.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField mileageFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("里程");
		field.setLocaleKey("transport_truck.mileage");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写里程");
		return field;
	}

	protected FormField bodyColorFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("车身颜色");
		field.setLocaleKey("transport_truck.body_color");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写车身颜色");
		return field;
	}

	protected FormField ownerIdFromTransportTruck(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("业主");
		field.setLocaleKey("transport_truck.owner");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TransportFleet");
		field.setRequired(true);
		field.setPlaceholder("请填写业主");
		return field;
	}

	protected FormField idFromTruckDriver(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("truck_driver.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromTruckDriver(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("truck_driver.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField driverLicenseNumberFromTruckDriver(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("驾驶执照号码");
		field.setLocaleKey("truck_driver.driver_license_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写驾驶执照号码");
		return field;
	}

	protected FormField contactNumberFromTruckDriver(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("联系电话");
		field.setLocaleKey("truck_driver.contact_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写联系电话");
		return field;
	}

	protected FormField belongsToIdFromTruckDriver(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("truck_driver.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TransportFleet");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField idFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("transport_task.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("transport_task.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField startFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("开始");
		field.setLocaleKey("transport_task.start");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写开始");
		return field;
	}

	protected FormField beginTimeFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("开始时间");
		field.setLocaleKey("transport_task.begin_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写开始时间");
		return field;
	}

	protected FormField endIdFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("结束");
		field.setLocaleKey("transport_task.end");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStore");
		field.setRequired(true);
		field.setPlaceholder("请填写结束");
		return field;
	}

	protected FormField driverIdFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("司机");
		field.setLocaleKey("transport_task.driver");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TruckDriver");
		field.setRequired(true);
		field.setPlaceholder("请填写司机");
		return field;
	}

	protected FormField truckIdFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("卡车");
		field.setLocaleKey("transport_task.truck");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TransportTruck");
		field.setRequired(true);
		field.setPlaceholder("请填写卡车");
		return field;
	}

	protected FormField belongsToIdFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("transport_task.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TransportFleet");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField latitudeFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("transport_task.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromTransportTask(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("transport_task.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField idFromTransportTaskTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("transport_task_track.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField trackTimeFromTransportTaskTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("跟踪时间");
		field.setLocaleKey("transport_task_track.track_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写跟踪时间");
		return field;
	}

	protected FormField latitudeFromTransportTaskTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("纬度");
		field.setLocaleKey("transport_task_track.latitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写纬度");
		return field;
	}

	protected FormField longitudeFromTransportTaskTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Longitude");
		field.setLocaleKey("transport_task_track.longitude");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写Longitude");
		return field;
	}

	protected FormField movementIdFromTransportTaskTrack(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("运动");
		field.setLocaleKey("transport_task_track.movement");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TransportTask");
		field.setRequired(true);
		field.setPlaceholder("请填写运动");
		return field;
	}

	protected FormField idFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("account_set.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("account_set.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField yearSetFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("年组");
		field.setLocaleKey("account_set.year_set");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写年组");
		return field;
	}

	protected FormField effectiveDateFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Effective Date");
		field.setLocaleKey("account_set.effective_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写Effective Date");
		return field;
	}

	protected FormField accountingSystemFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计制度");
		field.setLocaleKey("account_set.accounting_system");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写会计制度");
		return field;
	}

	protected FormField domesticCurrencyCodeFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("本币代码");
		field.setLocaleKey("account_set.domestic_currency_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写本币代码");
		return field;
	}

	protected FormField domesticCurrencyNameFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("本币名称");
		field.setLocaleKey("account_set.domestic_currency_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写本币名称");
		return field;
	}

	protected FormField openingBankFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("开户银行");
		field.setLocaleKey("account_set.opening_bank");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写开户银行");
		return field;
	}

	protected FormField accountNumberFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("帐户号码");
		field.setLocaleKey("account_set.account_number");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写帐户号码");
		return field;
	}

	protected FormField countryCenterIdFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("全国运营中心");
		field.setLocaleKey("account_set.country_center");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写全国运营中心");
		return field;
	}

	protected FormField retailStoreIdFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("双链小超");
		field.setLocaleKey("account_set.retail_store");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStore");
		field.setRequired(true);
		field.setPlaceholder("请填写双链小超");
		return field;
	}

	protected FormField goodsSupplierIdFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("产品供应商");
		field.setLocaleKey("account_set.goods_supplier");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GoodsSupplier");
		field.setRequired(true);
		field.setPlaceholder("请填写产品供应商");
		return field;
	}

	protected FormField lastUpdateTimeFromAccountSet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("account_set.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromAccountingSubject(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_subject.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField accountingSubjectCodeFromAccountingSubject(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计科目代码");
		field.setLocaleKey("accounting_subject.accounting_subject_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写会计科目代码");
		return field;
	}

	protected FormField accountingSubjectNameFromAccountingSubject(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计科目名称");
		field.setLocaleKey("accounting_subject.accounting_subject_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写会计科目名称");
		return field;
	}

	protected FormField accountingSubjectClassCodeFromAccountingSubject(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计科目类别代码");
		field.setLocaleKey("accounting_subject.accounting_subject_class_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写会计科目类别代码");
		return field;
	}

	protected FormField accountingSubjectClassNameFromAccountingSubject(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计科目类别名称");
		field.setLocaleKey("accounting_subject.accounting_subject_class_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写会计科目类别名称");
		return field;
	}

	protected FormField accountSetIdFromAccountingSubject(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("账套");
		field.setLocaleKey("accounting_subject.account_set");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountSet");
		field.setRequired(true);
		field.setPlaceholder("请填写账套");
		return field;
	}

	protected FormField idFromAccountingPeriod(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_period.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromAccountingPeriod(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("accounting_period.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField startDateFromAccountingPeriod(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("开始日期");
		field.setLocaleKey("accounting_period.start_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写开始日期");
		return field;
	}

	protected FormField endDateFromAccountingPeriod(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("结束日期");
		field.setLocaleKey("accounting_period.end_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写结束日期");
		return field;
	}

	protected FormField accountSetIdFromAccountingPeriod(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("账套");
		field.setLocaleKey("accounting_period.account_set");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountSet");
		field.setRequired(true);
		field.setPlaceholder("请填写账套");
		return field;
	}

	protected FormField idFromAccountingDocumentType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_document_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromAccountingDocumentType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("accounting_document_type.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField descriptionFromAccountingDocumentType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("accounting_document_type.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField accountingPeriodIdFromAccountingDocumentType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计期间");
		field.setLocaleKey("accounting_document_type.accounting_period");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountSet");
		field.setRequired(true);
		field.setPlaceholder("请填写会计期间");
		return field;
	}

	protected FormField idFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_document.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("accounting_document.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField accountingDocumentDateFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计凭证日期");
		field.setLocaleKey("accounting_document.accounting_document_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写会计凭证日期");
		return field;
	}

	protected FormField accountingPeriodIdFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计期间");
		field.setLocaleKey("accounting_document.accounting_period");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingPeriod");
		field.setRequired(true);
		field.setPlaceholder("请填写会计期间");
		return field;
	}

	protected FormField documentTypeIdFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("文档类型");
		field.setLocaleKey("accounting_document.document_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingDocumentType");
		field.setRequired(true);
		field.setPlaceholder("请填写文档类型");
		return field;
	}

	protected FormField creationIdFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建");
		field.setLocaleKey("accounting_document.creation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingDocumentCreation");
		field.setRequired(true);
		field.setPlaceholder("请填写创建");
		return field;
	}

	protected FormField confirmationIdFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认");
		field.setLocaleKey("accounting_document.confirmation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingDocumentConfirmation");
		field.setRequired(true);
		field.setPlaceholder("请填写确认");
		return field;
	}

	protected FormField auditingIdFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("审计");
		field.setLocaleKey("accounting_document.auditing");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingDocumentAuditing");
		field.setRequired(true);
		field.setPlaceholder("请填写审计");
		return field;
	}

	protected FormField postingIdFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("过账");
		field.setLocaleKey("accounting_document.posting");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingDocumentPosting");
		field.setRequired(true);
		field.setPlaceholder("请填写过账");
		return field;
	}

	protected FormField currentStatusFromAccountingDocument(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("accounting_document.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromAccountingDocumentCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_document_creation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromAccountingDocumentCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("accounting_document_creation.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromAccountingDocumentCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("accounting_document_creation.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField makeDateFromAccountingDocumentCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("accounting_document_creation.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField idFromAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_document_confirmation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("accounting_document_confirmation.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("accounting_document_confirmation.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField makeDateFromAccountingDocumentConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("accounting_document_confirmation.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField idFromAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_document_auditing.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("accounting_document_auditing.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("accounting_document_auditing.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField makeDateFromAccountingDocumentAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("accounting_document_auditing.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField idFromAccountingDocumentPosting(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_document_posting.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromAccountingDocumentPosting(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("accounting_document_posting.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromAccountingDocumentPosting(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("accounting_document_posting.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField makeDateFromAccountingDocumentPosting(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("accounting_document_posting.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField idFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("original_voucher.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("original_voucher.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField madeByFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("由");
		field.setLocaleKey("original_voucher.made_by");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写由");
		return field;
	}

	protected FormField receivedByFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("受");
		field.setLocaleKey("original_voucher.received_by");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写受");
		return field;
	}

	protected FormField voucherTypeFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("凭证类型");
		field.setLocaleKey("original_voucher.voucher_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写凭证类型");
		return field;
	}

	protected FormField voucherImageFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("凭证图像");
		field.setLocaleKey("original_voucher.voucher_image");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("image");
		field.setRequired(true);
		field.setPlaceholder("请填写凭证图像");
		return field;
	}

	protected FormField belongsToIdFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("original_voucher.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingDocument");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField creationIdFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("创建");
		field.setLocaleKey("original_voucher.creation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("OriginalVoucherCreation");
		field.setRequired(true);
		field.setPlaceholder("请填写创建");
		return field;
	}

	protected FormField confirmationIdFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("确认");
		field.setLocaleKey("original_voucher.confirmation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("OriginalVoucherConfirmation");
		field.setRequired(true);
		field.setPlaceholder("请填写确认");
		return field;
	}

	protected FormField auditingIdFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("审计");
		field.setLocaleKey("original_voucher.auditing");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("OriginalVoucherAuditing");
		field.setRequired(true);
		field.setPlaceholder("请填写审计");
		return field;
	}

	protected FormField currentStatusFromOriginalVoucher(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("original_voucher.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromOriginalVoucherCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("original_voucher_creation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromOriginalVoucherCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("original_voucher_creation.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromOriginalVoucherCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("original_voucher_creation.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField makeDateFromOriginalVoucherCreation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("original_voucher_creation.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField idFromOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("original_voucher_confirmation.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("original_voucher_confirmation.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("original_voucher_confirmation.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField makeDateFromOriginalVoucherConfirmation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("original_voucher_confirmation.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField idFromOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("original_voucher_auditing.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("original_voucher_auditing.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("original_voucher_auditing.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField makeDateFromOriginalVoucherAuditing(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("制造日期");
		field.setLocaleKey("original_voucher_auditing.make_date");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写制造日期");
		return field;
	}

	protected FormField idFromAccountingDocumentLine(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("accounting_document_line.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromAccountingDocumentLine(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("accounting_document_line.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField codeFromAccountingDocumentLine(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("accounting_document_line.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField directFromAccountingDocumentLine(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("直接");
		field.setLocaleKey("accounting_document_line.direct");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写直接");
		return field;
	}

	protected FormField amountFromAccountingDocumentLine(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("accounting_document_line.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField belongsToIdFromAccountingDocumentLine(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("accounting_document_line.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingDocument");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField accountingSubjectIdFromAccountingDocumentLine(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("会计科目");
		field.setLocaleKey("accounting_document_line.accounting_subject");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("AccountingSubject");
		field.setRequired(true);
		field.setPlaceholder("请填写会计科目");
		return field;
	}

	protected FormField idFromLevelOneDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("level_one_department.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField belongsToIdFromLevelOneDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("level_one_department.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField nameFromLevelOneDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("level_one_department.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField descriptionFromLevelOneDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("level_one_department.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField managerFromLevelOneDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("经理");
		field.setLocaleKey("level_one_department.manager");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写经理");
		return field;
	}

	protected FormField foundedFromLevelOneDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("level_one_department.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField idFromLevelTwoDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("level_two_department.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField belongsToIdFromLevelTwoDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("level_two_department.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelOneDepartment");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField nameFromLevelTwoDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("level_two_department.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField descriptionFromLevelTwoDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("level_two_department.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField foundedFromLevelTwoDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("level_two_department.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField idFromLevelThreeDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("level_three_department.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField belongsToIdFromLevelThreeDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("属于");
		field.setLocaleKey("level_three_department.belongs_to");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelTwoDepartment");
		field.setRequired(true);
		field.setPlaceholder("请填写属于");
		return field;
	}

	protected FormField nameFromLevelThreeDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("level_three_department.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField descriptionFromLevelThreeDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("level_three_department.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField foundedFromLevelThreeDepartment(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("成立");
		field.setLocaleKey("level_three_department.founded");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写成立");
		return field;
	}

	protected FormField idFromSkillType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("skill_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromSkillType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("skill_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromSkillType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("skill_type.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField descriptionFromSkillType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("skill_type.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromResponsibilityType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("responsibility_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromResponsibilityType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("responsibility_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromResponsibilityType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("responsibility_type.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField baseDescriptionFromResponsibilityType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("基本描述");
		field.setLocaleKey("responsibility_type.base_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写基本描述");
		return field;
	}

	protected FormField detailDescriptionFromResponsibilityType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("详细描述");
		field.setLocaleKey("responsibility_type.detail_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写详细描述");
		return field;
	}

	protected FormField idFromTerminationReason(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("termination_reason.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromTerminationReason(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("termination_reason.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromTerminationReason(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("termination_reason.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField descriptionFromTerminationReason(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("termination_reason.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromTerminationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("termination_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromTerminationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("termination_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromTerminationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("termination_type.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField baseDescriptionFromTerminationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("基本描述");
		field.setLocaleKey("termination_type.base_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写基本描述");
		return field;
	}

	protected FormField detailDescriptionFromTerminationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("详细描述");
		field.setLocaleKey("termination_type.detail_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写详细描述");
		return field;
	}

	protected FormField idFromOccupationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("occupation_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromOccupationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("occupation_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromOccupationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("occupation_type.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField descriptionFromOccupationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("occupation_type.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField detailDescriptionFromOccupationType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("详细描述");
		field.setLocaleKey("occupation_type.detail_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写详细描述");
		return field;
	}

	protected FormField idFromLeaveType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("leave_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromLeaveType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("leave_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromLeaveType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("leave_type.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField descriptionFromLeaveType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("leave_type.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField detailDescriptionFromLeaveType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("详细描述");
		field.setLocaleKey("leave_type.detail_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写详细描述");
		return field;
	}

	protected FormField idFromSalaryGrade(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("salary_grade.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromSalaryGrade(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("salary_grade.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromSalaryGrade(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("salary_grade.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField nameFromSalaryGrade(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("salary_grade.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField detailDescriptionFromSalaryGrade(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("详细描述");
		field.setLocaleKey("salary_grade.detail_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写详细描述");
		return field;
	}

	protected FormField idFromInterviewType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("interview_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromInterviewType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("interview_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromInterviewType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("interview_type.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField descriptionFromInterviewType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("interview_type.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField detailDescriptionFromInterviewType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("详细描述");
		field.setLocaleKey("interview_type.detail_description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写详细描述");
		return field;
	}

	protected FormField idFromTrainingCourseType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("training_course_type.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromTrainingCourseType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("training_course_type.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromTrainingCourseType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("training_course_type.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField nameFromTrainingCourseType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("training_course_type.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField descriptionFromTrainingCourseType(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("training_course_type.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromPublicHoliday(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("public_holiday.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField codeFromPublicHoliday(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("代码");
		field.setLocaleKey("public_holiday.code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写代码");
		return field;
	}

	protected FormField companyIdFromPublicHoliday(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("public_holiday.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField nameFromPublicHoliday(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("public_holiday.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField descriptionFromPublicHoliday(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("public_holiday.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromTermination(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("termination.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField reasonIdFromTermination(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("原因");
		field.setLocaleKey("termination.reason");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TerminationReason");
		field.setRequired(true);
		field.setPlaceholder("请填写原因");
		return field;
	}

	protected FormField typeIdFromTermination(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("termination.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TerminationType");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField commentFromTermination(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("termination.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromView(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("view.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromView(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("view.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField assessmentFromView(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评估");
		field.setLocaleKey("view.assessment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评估");
		return field;
	}

	protected FormField interviewTimeFromView(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("面试时间");
		field.setLocaleKey("view.interview_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写面试时间");
		return field;
	}

	protected FormField idFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField companyIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("employee.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField titleFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("employee.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField departmentIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("部门");
		field.setLocaleKey("employee.department");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LevelThreeDepartment");
		field.setRequired(true);
		field.setPlaceholder("请填写部门");
		return field;
	}

	protected FormField familyNameFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("姓");
		field.setLocaleKey("employee.family_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写姓");
		return field;
	}

	protected FormField givenNameFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名");
		field.setLocaleKey("employee.given_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名");
		return field;
	}

	protected FormField emailFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("电子邮件");
		field.setLocaleKey("employee.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写电子邮件");
		return field;
	}

	protected FormField cityFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("城市");
		field.setLocaleKey("employee.city");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写城市");
		return field;
	}

	protected FormField addressFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("地址");
		field.setLocaleKey("employee.address");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写地址");
		return field;
	}

	protected FormField cellPhoneFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("employee.cell_phone");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField occupationIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("职业");
		field.setLocaleKey("employee.occupation");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("OccupationType");
		field.setRequired(true);
		field.setPlaceholder("请填写职业");
		return field;
	}

	protected FormField responsibleForIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("负责");
		field.setLocaleKey("employee.responsible_for");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ResponsibilityType");
		field.setRequired(true);
		field.setPlaceholder("请填写负责");
		return field;
	}

	protected FormField currentSalaryGradeIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("目前工资等级");
		field.setLocaleKey("employee.current_salary_grade");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SalaryGrade");
		field.setRequired(true);
		field.setPlaceholder("请填写目前工资等级");
		return field;
	}

	protected FormField salaryAccountFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("工资账户");
		field.setLocaleKey("employee.salary_account");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写工资账户");
		return field;
	}

	protected FormField jobApplicationIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("工作申请");
		field.setLocaleKey("employee.job_application");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("JobApplication");
		field.setRequired(true);
		field.setPlaceholder("请填写工作申请");
		return field;
	}

	protected FormField professionInterviewIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("专业面试");
		field.setLocaleKey("employee.profession_interview");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("ProfessionInterview");
		field.setRequired(true);
		field.setPlaceholder("请填写专业面试");
		return field;
	}

	protected FormField hrInterviewIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("人力资源部面试");
		field.setLocaleKey("employee.hr_interview");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("HrInterview");
		field.setRequired(true);
		field.setPlaceholder("请填写人力资源部面试");
		return field;
	}

	protected FormField offerApprovalIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("审批工作要约");
		field.setLocaleKey("employee.offer_approval");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("OfferApproval");
		field.setRequired(true);
		field.setPlaceholder("请填写审批工作要约");
		return field;
	}

	protected FormField offerAcceptanceIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("接受工作要约");
		field.setLocaleKey("employee.offer_acceptance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("OfferAcceptance");
		field.setRequired(true);
		field.setPlaceholder("请填写接受工作要约");
		return field;
	}

	protected FormField employeeBoardingIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工入职");
		field.setLocaleKey("employee.employee_boarding");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("EmployeeBoarding");
		field.setRequired(true);
		field.setPlaceholder("请填写员工入职");
		return field;
	}

	protected FormField terminationIdFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("雇佣终止");
		field.setLocaleKey("employee.termination");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Termination");
		field.setRequired(true);
		field.setPlaceholder("请填写雇佣终止");
		return field;
	}

	protected FormField lastUpdateTimeFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("employee.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField currentStatusFromEmployee(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("employee.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromJobApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("job_application.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField applicationTimeFromJobApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("申请时间");
		field.setLocaleKey("job_application.application_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写申请时间");
		return field;
	}

	protected FormField whoFromJobApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("job_application.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField commentsFromJobApplication(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("job_application.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromProfessionInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("profession_interview.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromProfessionInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("profession_interview.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField interviewTimeFromProfessionInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("面试时间");
		field.setLocaleKey("profession_interview.interview_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写面试时间");
		return field;
	}

	protected FormField commentsFromProfessionInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("profession_interview.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromHrInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("hr_interview.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromHrInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("hr_interview.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField interviewTimeFromHrInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("面试时间");
		field.setLocaleKey("hr_interview.interview_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写面试时间");
		return field;
	}

	protected FormField commentsFromHrInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("hr_interview.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromOfferApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("offer_approval.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromOfferApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("offer_approval.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField approveTimeFromOfferApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("批准时间");
		field.setLocaleKey("offer_approval.approve_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写批准时间");
		return field;
	}

	protected FormField commentsFromOfferApproval(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("offer_approval.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromOfferAcceptance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("offer_acceptance.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromOfferAcceptance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("offer_acceptance.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField acceptTimeFromOfferAcceptance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("接受时间");
		field.setLocaleKey("offer_acceptance.accept_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写接受时间");
		return field;
	}

	protected FormField commentsFromOfferAcceptance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("offer_acceptance.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromEmployeeBoarding(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_boarding.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromEmployeeBoarding(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("employee_boarding.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField employTimeFromEmployeeBoarding(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("使用时间");
		field.setLocaleKey("employee_boarding.employ_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写使用时间");
		return field;
	}

	protected FormField commentsFromEmployeeBoarding(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("employee_boarding.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("instructor.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("instructor.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField familyNameFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("姓");
		field.setLocaleKey("instructor.family_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写姓");
		return field;
	}

	protected FormField givenNameFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名");
		field.setLocaleKey("instructor.given_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名");
		return field;
	}

	protected FormField cellPhoneFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("instructor.cell_phone");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField emailFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("电子邮件");
		field.setLocaleKey("instructor.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写电子邮件");
		return field;
	}

	protected FormField companyIdFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("instructor.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField introductionFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("介绍");
		field.setLocaleKey("instructor.introduction");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写介绍");
		return field;
	}

	protected FormField lastUpdateTimeFromInstructor(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("instructor.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("company_training.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("company_training.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField companyIdFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("company_training.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("RetailStoreCountryCenter");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField instructorIdFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("讲师");
		field.setLocaleKey("company_training.instructor");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Instructor");
		field.setRequired(true);
		field.setPlaceholder("请填写讲师");
		return field;
	}

	protected FormField trainingCourseTypeIdFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("培训课程类型");
		field.setLocaleKey("company_training.training_course_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("TrainingCourseType");
		field.setRequired(true);
		field.setPlaceholder("请填写培训课程类型");
		return field;
	}

	protected FormField timeStartFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("时间开始");
		field.setLocaleKey("company_training.time_start");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写时间开始");
		return field;
	}

	protected FormField durationHoursFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("持续时间");
		field.setLocaleKey("company_training.duration_hours");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写持续时间");
		return field;
	}

	protected FormField lastUpdateTimeFromCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Last Update Time");
		field.setLocaleKey("company_training.last_update_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写Last Update Time");
		return field;
	}

	protected FormField idFromScoring(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("scoring.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField scoredByFromScoring(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("由谁打分");
		field.setLocaleKey("scoring.scored_by");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写由谁打分");
		return field;
	}

	protected FormField scoreFromScoring(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("分数");
		field.setLocaleKey("scoring.score");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写分数");
		return field;
	}

	protected FormField commentFromScoring(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("scoring.comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_company_training.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_company_training.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField trainingIdFromEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("训练");
		field.setLocaleKey("employee_company_training.training");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("CompanyTraining");
		field.setRequired(true);
		field.setPlaceholder("请填写训练");
		return field;
	}

	protected FormField scoringIdFromEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评分");
		field.setLocaleKey("employee_company_training.scoring");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Scoring");
		field.setRequired(true);
		field.setPlaceholder("请填写评分");
		return field;
	}

	protected FormField currentStatusFromEmployeeCompanyTraining(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("employee_company_training.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromEmployeeSkill(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_skill.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeSkill(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_skill.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField skillTypeIdFromEmployeeSkill(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("技能类型");
		field.setLocaleKey("employee_skill.skill_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SkillType");
		field.setRequired(true);
		field.setPlaceholder("请填写技能类型");
		return field;
	}

	protected FormField descriptionFromEmployeeSkill(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("employee_skill.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromEmployeePerformance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_performance.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeePerformance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_performance.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField performanceCommentFromEmployeePerformance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("绩效评价");
		field.setLocaleKey("employee_performance.performance_comment");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写绩效评价");
		return field;
	}

	protected FormField idFromEmployeeWorkExperience(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_work_experience.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeWorkExperience(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_work_experience.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField startFromEmployeeWorkExperience(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("开始");
		field.setLocaleKey("employee_work_experience.start");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写开始");
		return field;
	}

	protected FormField endFromEmployeeWorkExperience(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("结束");
		field.setLocaleKey("employee_work_experience.end");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写结束");
		return field;
	}

	protected FormField companyFromEmployeeWorkExperience(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("公司");
		field.setLocaleKey("employee_work_experience.company");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写公司");
		return field;
	}

	protected FormField descriptionFromEmployeeWorkExperience(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("employee_work_experience.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromEmployeeLeave(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_leave.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoIdFromEmployeeLeave(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("employee_leave.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField typeIdFromEmployeeLeave(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("employee_leave.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("LeaveType");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField leaveDurationHourFromEmployeeLeave(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("请假时长");
		field.setLocaleKey("employee_leave.leave_duration_hour");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写请假时长");
		return field;
	}

	protected FormField remarkFromEmployeeLeave(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("备注");
		field.setLocaleKey("employee_leave.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写备注");
		return field;
	}

	protected FormField idFromEmployeeInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_interview.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_interview.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField interviewTypeIdFromEmployeeInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("面试类型");
		field.setLocaleKey("employee_interview.interview_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("InterviewType");
		field.setRequired(true);
		field.setPlaceholder("请填写面试类型");
		return field;
	}

	protected FormField remarkFromEmployeeInterview(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("备注");
		field.setLocaleKey("employee_interview.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写备注");
		return field;
	}

	protected FormField idFromEmployeeAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_attendance.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_attendance.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField enterTimeFromEmployeeAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("进入时间");
		field.setLocaleKey("employee_attendance.enter_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写进入时间");
		return field;
	}

	protected FormField leaveTimeFromEmployeeAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("离开的时候");
		field.setLocaleKey("employee_attendance.leave_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写离开的时候");
		return field;
	}

	protected FormField durationHoursFromEmployeeAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("持续时间");
		field.setLocaleKey("employee_attendance.duration_hours");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写持续时间");
		return field;
	}

	protected FormField remarkFromEmployeeAttendance(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("备注");
		field.setLocaleKey("employee_attendance.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写备注");
		return field;
	}

	protected FormField idFromEmployeeQualifier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_qualifier.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeQualifier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_qualifier.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField qualifiedTimeFromEmployeeQualifier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("合格的时间");
		field.setLocaleKey("employee_qualifier.qualified_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写合格的时间");
		return field;
	}

	protected FormField typeFromEmployeeQualifier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("employee_qualifier.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField levelFromEmployeeQualifier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("水平");
		field.setLocaleKey("employee_qualifier.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写水平");
		return field;
	}

	protected FormField remarkFromEmployeeQualifier(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("备注");
		field.setLocaleKey("employee_qualifier.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写备注");
		return field;
	}

	protected FormField idFromEmployeeEducation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_education.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeEducation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_education.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField completeTimeFromEmployeeEducation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("完成时间");
		field.setLocaleKey("employee_education.complete_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写完成时间");
		return field;
	}

	protected FormField typeFromEmployeeEducation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("employee_education.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField remarkFromEmployeeEducation(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("备注");
		field.setLocaleKey("employee_education.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写备注");
		return field;
	}

	protected FormField idFromEmployeeAward(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_award.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeAward(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_award.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField completeTimeFromEmployeeAward(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("完成时间");
		field.setLocaleKey("employee_award.complete_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写完成时间");
		return field;
	}

	protected FormField typeFromEmployeeAward(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("employee_award.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField remarkFromEmployeeAward(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("备注");
		field.setLocaleKey("employee_award.remark");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写备注");
		return field;
	}

	protected FormField idFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("employee_salary_sheet.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField employeeIdFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("员工");
		field.setLocaleKey("employee_salary_sheet.employee");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写员工");
		return field;
	}

	protected FormField currentSalaryGradeIdFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("目前工资等级");
		field.setLocaleKey("employee_salary_sheet.current_salary_grade");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SalaryGrade");
		field.setRequired(true);
		field.setPlaceholder("请填写目前工资等级");
		return field;
	}

	protected FormField baseSalaryFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("基本工资");
		field.setLocaleKey("employee_salary_sheet.base_salary");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写基本工资");
		return field;
	}

	protected FormField bonusFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("奖金");
		field.setLocaleKey("employee_salary_sheet.bonus");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写奖金");
		return field;
	}

	protected FormField rewardFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("奖励");
		field.setLocaleKey("employee_salary_sheet.reward");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写奖励");
		return field;
	}

	protected FormField personalTaxFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("个人所得税");
		field.setLocaleKey("employee_salary_sheet.personal_tax");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写个人所得税");
		return field;
	}

	protected FormField socialSecurityFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("社会保险");
		field.setLocaleKey("employee_salary_sheet.social_security");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写社会保险");
		return field;
	}

	protected FormField housingFoundFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("住房公积金");
		field.setLocaleKey("employee_salary_sheet.housing_found");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写住房公积金");
		return field;
	}

	protected FormField jobInsuranceFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("失业保险");
		field.setLocaleKey("employee_salary_sheet.job_insurance");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写失业保险");
		return field;
	}

	protected FormField payingOffIdFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("工资支付");
		field.setLocaleKey("employee_salary_sheet.paying_off");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("PayingOff");
		field.setRequired(true);
		field.setPlaceholder("请填写工资支付");
		return field;
	}

	protected FormField currentStatusFromEmployeeSalarySheet(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("employee_salary_sheet.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromPayingOff(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("paying_off.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromPayingOff(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("paying_off.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField paidForIdFromPayingOff(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("支付");
		field.setLocaleKey("paying_off.paid_for");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("Employee");
		field.setRequired(true);
		field.setPlaceholder("请填写支付");
		return field;
	}

	protected FormField paidTimeFromPayingOff(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("支付时间");
		field.setLocaleKey("paying_off.paid_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date");
		field.setRequired(true);
		field.setPlaceholder("请填写支付时间");
		return field;
	}

	protected FormField amountFromPayingOff(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("金额");
		field.setLocaleKey("paying_off.amount");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("money");
		field.setRequired(true);
		field.setPlaceholder("请填写金额");
		return field;
	}

	protected FormField idFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("user_domain.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromUserDomain(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("user_domain.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField idFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("user_white_list.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField userIdentityFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Identity");
		field.setLocaleKey("user_white_list.user_identity");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Identity");
		return field;
	}

	protected FormField userSpecialFunctionsFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("User Special Functions");
		field.setLocaleKey("user_white_list.user_special_functions");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写User Special Functions");
		return field;
	}

	protected FormField domainIdFromUserWhiteList(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("域");
		field.setLocaleKey("user_white_list.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写域");
		return field;
	}

	protected FormField idFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("sec_user.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField loginFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("登录");
		field.setLocaleKey("sec_user.login");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写登录");
		return field;
	}

	protected FormField mobileFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("手机");
		field.setLocaleKey("sec_user.mobile");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("mobile");
		field.setRequired(true);
		field.setPlaceholder("请填写手机");
		return field;
	}

	protected FormField emailFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("电子邮件");
		field.setLocaleKey("sec_user.email");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写电子邮件");
		return field;
	}

	protected FormField pwdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("PWD");
		field.setLocaleKey("sec_user.pwd");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("password");
		field.setRequired(true);
		field.setPlaceholder("请填写PWD");
		return field;
	}

	protected FormField verificationCodeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("验证码");
		field.setLocaleKey("sec_user.verification_code");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("number");
		field.setRequired(true);
		field.setPlaceholder("请填写验证码");
		return field;
	}

	protected FormField verificationCodeExpireFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("验证码过期");
		field.setLocaleKey("sec_user.verification_code_expire");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写验证码过期");
		return field;
	}

	protected FormField lastLoginTimeFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("最后登录时间");
		field.setLocaleKey("sec_user.last_login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写最后登录时间");
		return field;
	}

	protected FormField domainIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("域");
		field.setLocaleKey("sec_user.domain");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserDomain");
		field.setRequired(true);
		field.setPlaceholder("请填写域");
		return field;
	}

	protected FormField blockingIdFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("屏蔽");
		field.setLocaleKey("sec_user.blocking");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUserBlocking");
		field.setRequired(true);
		field.setPlaceholder("请填写屏蔽");
		return field;
	}

	protected FormField currentStatusFromSecUser(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("当前状态");
		field.setLocaleKey("sec_user.current_status");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写当前状态");
		return field;
	}

	protected FormField idFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("sec_user_blocking.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField whoFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("谁");
		field.setLocaleKey("sec_user_blocking.who");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写谁");
		return field;
	}

	protected FormField blockTimeFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("块时间");
		field.setLocaleKey("sec_user_blocking.block_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写块时间");
		return field;
	}

	protected FormField commentsFromSecUserBlocking(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("评论");
		field.setLocaleKey("sec_user_blocking.comments");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写评论");
		return field;
	}

	protected FormField idFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("user_app.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("user_app.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField secUserIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("SEC的用户");
		field.setLocaleKey("user_app.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写SEC的用户");
		return field;
	}

	protected FormField appIconFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序图标");
		field.setLocaleKey("user_app.app_icon");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序图标");
		return field;
	}

	protected FormField fullAccessFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("完全访问");
		field.setLocaleKey("user_app.full_access");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写完全访问");
		return field;
	}

	protected FormField permissionFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("许可");
		field.setLocaleKey("user_app.permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写许可");
		return field;
	}

	protected FormField objectTypeFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("对象类型");
		field.setLocaleKey("user_app.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写对象类型");
		return field;
	}

	protected FormField objectIdFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("对象ID");
		field.setLocaleKey("user_app.object_id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写对象ID");
		return field;
	}

	protected FormField locationFromUserApp(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("位置");
		field.setLocaleKey("user_app.location");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写位置");
		return field;
	}

	protected FormField idFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("list_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("list_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField internalNameFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Internal Name");
		field.setLocaleKey("list_access.internal_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Internal Name");
		return field;
	}

	protected FormField readPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Read Permission");
		field.setLocaleKey("list_access.read_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Read Permission");
		return field;
	}

	protected FormField createPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Create Permission");
		field.setLocaleKey("list_access.create_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Create Permission");
		return field;
	}

	protected FormField deletePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Delete Permission");
		field.setLocaleKey("list_access.delete_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Delete Permission");
		return field;
	}

	protected FormField updatePermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Update Permission");
		field.setLocaleKey("list_access.update_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Update Permission");
		return field;
	}

	protected FormField executionPermissionFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Execution Permission");
		field.setLocaleKey("list_access.execution_permission");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Execution Permission");
		return field;
	}

	protected FormField appIdFromListAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序");
		field.setLocaleKey("list_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序");
		return field;
	}

	protected FormField idFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("object_access.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField nameFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("名称");
		field.setLocaleKey("object_access.name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写名称");
		return field;
	}

	protected FormField objectTypeFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("对象类型");
		field.setLocaleKey("object_access.object_type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写对象类型");
		return field;
	}

	protected FormField list1FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("表");
		field.setLocaleKey("object_access.list1");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写表");
		return field;
	}

	protected FormField list2FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("清单");
		field.setLocaleKey("object_access.list2");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写清单");
		return field;
	}

	protected FormField list3FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("目录3");
		field.setLocaleKey("object_access.list3");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写目录3");
		return field;
	}

	protected FormField list4FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("清单");
		field.setLocaleKey("object_access.list4");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写清单");
		return field;
	}

	protected FormField list5FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("列表6");
		field.setLocaleKey("object_access.list5");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写列表6");
		return field;
	}

	protected FormField list6FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("list6");
		field.setLocaleKey("object_access.list6");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写list6");
		return field;
	}

	protected FormField list7FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("list7");
		field.setLocaleKey("object_access.list7");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写list7");
		return field;
	}

	protected FormField list8FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("list8");
		field.setLocaleKey("object_access.list8");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写list8");
		return field;
	}

	protected FormField list9FromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("list9");
		field.setLocaleKey("object_access.list9");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写list9");
		return field;
	}

	protected FormField appIdFromObjectAccess(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("应用程序");
		field.setLocaleKey("object_access.app");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("UserApp");
		field.setRequired(true);
		field.setPlaceholder("请填写应用程序");
		return field;
	}

	protected FormField idFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("login_history.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField loginTimeFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("登录时间");
		field.setLocaleKey("login_history.login_time");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("date_time");
		field.setRequired(true);
		field.setPlaceholder("请填写登录时间");
		return field;
	}

	protected FormField fromIpFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("从IP");
		field.setLocaleKey("login_history.from_ip");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写从IP");
		return field;
	}

	protected FormField descriptionFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("login_history.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField secUserIdFromLoginHistory(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("SEC的用户");
		field.setLocaleKey("login_history.sec_user");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("SecUser");
		field.setRequired(true);
		field.setPlaceholder("请填写SEC的用户");
		return field;
	}

	protected FormField idFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("generic_form.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("generic_form.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField descriptionFromGenericForm(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("generic_form.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField idFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("form_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("form_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField formIdFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

	protected FormField levelFromFormMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("水平");
		field.setLocaleKey("form_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写水平");
		return field;
	}

	protected FormField idFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("form_field_message.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField titleFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("头衔");
		field.setLocaleKey("form_field_message.title");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写头衔");
		return field;
	}

	protected FormField parameterNameFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("参数名称");
		field.setLocaleKey("form_field_message.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写参数名称");
		return field;
	}

	protected FormField formIdFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_field_message.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

	protected FormField levelFromFormFieldMessage(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("水平");
		field.setLocaleKey("form_field_message.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写水平");
		return field;
	}

	protected FormField idFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("form_field.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField labelFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标签");
		field.setLocaleKey("form_field.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标签");
		return field;
	}

	protected FormField localeKeyFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("语言环境的关键");
		field.setLocaleKey("form_field.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写语言环境的关键");
		return field;
	}

	protected FormField parameterNameFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("参数名称");
		field.setLocaleKey("form_field.parameter_name");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写参数名称");
		return field;
	}

	protected FormField typeFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("类型");
		field.setLocaleKey("form_field.type");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写类型");
		return field;
	}

	protected FormField formIdFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_field.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

	protected FormField placeholderFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("占位符");
		field.setLocaleKey("form_field.placeholder");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写占位符");
		return field;
	}

	protected FormField defaultValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("默认值");
		field.setLocaleKey("form_field.default_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写默认值");
		return field;
	}

	protected FormField descriptionFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("描述");
		field.setLocaleKey("form_field.description");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写描述");
		return field;
	}

	protected FormField fieldGroupFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("字段组");
		field.setLocaleKey("form_field.field_group");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写字段组");
		return field;
	}

	protected FormField minimumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Minimum Value");
		field.setLocaleKey("form_field.minimum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Minimum Value");
		return field;
	}

	protected FormField maximumValueFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Maximum Value");
		field.setLocaleKey("form_field.maximum_value");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Maximum Value");
		return field;
	}

	protected FormField requiredFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("要求");
		field.setLocaleKey("form_field.required");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写要求");
		return field;
	}

	protected FormField disabledFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Disabled");
		field.setLocaleKey("form_field.disabled");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写Disabled");
		return field;
	}

	protected FormField customRenderingFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("自定义渲染");
		field.setLocaleKey("form_field.custom_rendering");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("switch");
		field.setRequired(true);
		field.setPlaceholder("请填写自定义渲染");
		return field;
	}

	protected FormField candidateValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("候选人的价值观");
		field.setLocaleKey("form_field.candidate_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写候选人的价值观");
		return field;
	}

	protected FormField suggestValuesFromFormField(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("建议值");
		field.setLocaleKey("form_field.suggest_values");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写建议值");
		return field;
	}

	protected FormField idFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("序号");
		field.setLocaleKey("form_action.id");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写序号");
		return field;
	}

	protected FormField labelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("标签");
		field.setLocaleKey("form_action.label");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写标签");
		return field;
	}

	protected FormField localeKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("语言环境的关键");
		field.setLocaleKey("form_action.locale_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写语言环境的关键");
		return field;
	}

	protected FormField actionKeyFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("Action Key");
		field.setLocaleKey("form_action.action_key");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写Action Key");
		return field;
	}

	protected FormField levelFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("水平");
		field.setLocaleKey("form_action.level");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写水平");
		return field;
	}

	protected FormField urlFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("url");
		field.setLocaleKey("form_action.url");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("text");
		field.setRequired(true);
		field.setPlaceholder("请填写url");
		return field;
	}

	protected FormField formIdFromFormAction(String parameterName, String initValue){
		FormField field = new FormField();
		field.setLabel("形式");
		field.setLocaleKey("form_action.form");
		field.setParameterName(parameterName);
		field.setDefaultValue(initValue);
		field.setFieldGroup("基本信息");
		field.setType("GenericForm");
		field.setRequired(true);
		field.setPlaceholder("请填写形式");
		return field;
	}

}









