
package com.doublechaintech.retailscm.provincecenteremployee;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;









@JsonSerialize(using = ProvinceCenterEmployeeSerializer.class)
public class ProvinceCenterEmployee extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String MOBILE_PROPERTY                = "mobile"            ;
	public static final String EMAIL_PROPERTY                 = "email"             ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String DEPARTMENT_PROPERTY            = "department"        ;
	public static final String PROVINCE_CENTER_PROPERTY       = "provinceCenter"    ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="ProvinceCenterEmployee";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(MOBILE_PROPERTY, "mobile", "手机")
        .withType("string_china_mobile_phone", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EMAIL_PROPERTY, "email", "电子邮件")
        .withType("string_email", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FOUNDED_PROPERTY, "founded", "成立")
        .withType("date_past", "Date"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DEPARTMENT_PROPERTY, "province_center_department", "部门")
        .withType("province_center_department", ProvinceCenterDepartment.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PROVINCE_CENTER_PROPERTY, "retail_store_province_center", "省中心")
        .withType("retail_store_province_center", RetailStoreProvinceCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,MOBILE_PROPERTY ,EMAIL_PROPERTY ,FOUNDED_PROPERTY ,DEPARTMENT_PROPERTY ,PROVINCE_CENTER_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(DEPARTMENT_PROPERTY, ProvinceCenterDepartment.class);
parents.put(PROVINCE_CENTER_PROPERTY, RetailStoreProvinceCenter.class);

    return parents;
  }

  public ProvinceCenterEmployee want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ProvinceCenterEmployee wants(Class<? extends BaseEntity>... classes) {
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
	protected		String              	mobile              ;
	protected		String              	email               ;
	protected		Date                	founded             ;
	protected		ProvinceCenterDepartment	department          ;
	protected		RetailStoreProvinceCenter	provinceCenter      ;
	protected		int                 	version             ;

	



	public 	ProvinceCenterEmployee(){
		// lazy load for all the properties
	}
	public 	static ProvinceCenterEmployee withId(String id){
		ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployee.setId(id);
		provinceCenterEmployee.setVersion(Integer.MAX_VALUE);
		provinceCenterEmployee.setChecked(true);
		return provinceCenterEmployee;
	}
	public 	static ProvinceCenterEmployee refById(String id){
		return withId(id);
	}

  public ProvinceCenterEmployee limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public ProvinceCenterEmployee limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static ProvinceCenterEmployee searchExample(){
    ProvinceCenterEmployee provinceCenterEmployee = new ProvinceCenterEmployee();
    		provinceCenterEmployee.setVersion(UNSET_INT);

    return provinceCenterEmployee;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setDepartment( null );
		setProvinceCenter( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(MOBILE_PROPERTY.equals(property)){
			changeMobileProperty(newValueExpr);
		}
		if(EMAIL_PROPERTY.equals(property)){
			changeEmailProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
			
			
			
	protected void changeMobileProperty(String newValueExpr){
	
		String oldValue = getMobile();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateMobile(newValue);
		this.onChangeProperty(MOBILE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeEmailProperty(String newValueExpr){
	
		String oldValue = getEmail();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateEmail(newValue);
		this.onChangeProperty(EMAIL_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeFoundedProperty(String newValueExpr){
	
		Date oldValue = getFounded();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateFounded(newValue);
		this.onChangeProperty(FOUNDED_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(MOBILE_PROPERTY.equals(property)){
			return getMobile();
		}
		if(EMAIL_PROPERTY.equals(property)){
			return getEmail();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(DEPARTMENT_PROPERTY.equals(property)){
			return getDepartment();
		}
		if(PROVINCE_CENTER_PROPERTY.equals(property)){
			return getProvinceCenter();
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
	public ProvinceCenterEmployee updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addIdCriteria(QueryOperator operator, Object... parameters){
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
	public ProvinceCenterEmployee updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setMobile(String mobile){String oldMobile = this.mobile;String newMobile = trimString(mobile);this.mobile = newMobile;}
	public String mobile(){
doLoad();
return getMobile();
}
	public String getMobile(){
		return this.mobile;
	}
	public ProvinceCenterEmployee updateMobile(String mobile){String oldMobile = this.mobile;String newMobile = trimString(mobile);if(!shouldReplaceBy(newMobile, oldMobile)){return this;}this.mobile = newMobile;addPropertyChange(MOBILE_PROPERTY, oldMobile, newMobile);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderByMobile(boolean asc){
doAddOrderBy(MOBILE_PROPERTY, asc);
return this;
}
	public SearchCriteria createMobileCriteria(QueryOperator operator, Object... parameters){
return createCriteria(MOBILE_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreMobileCriteria(){super.ignoreSearchProperty(MOBILE_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addMobileCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createMobileCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeMobile(String mobile){
		if(mobile != null) { setMobile(mobile);}
	}

	

	public String getMaskedMobile(){
		String mobilePhoneNumber = getMobile();
		return maskChinaMobileNumber(mobilePhoneNumber);
	}

		
	public void setEmail(String email){String oldEmail = this.email;String newEmail = trimString(email);this.email = newEmail;}
	public String email(){
doLoad();
return getEmail();
}
	public String getEmail(){
		return this.email;
	}
	public ProvinceCenterEmployee updateEmail(String email){String oldEmail = this.email;String newEmail = trimString(email);if(!shouldReplaceBy(newEmail, oldEmail)){return this;}this.email = newEmail;addPropertyChange(EMAIL_PROPERTY, oldEmail, newEmail);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderByEmail(boolean asc){
doAddOrderBy(EMAIL_PROPERTY, asc);
return this;
}
	public SearchCriteria createEmailCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EMAIL_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreEmailCriteria(){super.ignoreSearchProperty(EMAIL_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addEmailCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createEmailCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeEmail(String email){
		if(email != null) { setEmail(email);}
	}

	
	public void setFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;this.founded = newFounded;}
	public Date founded(){
doLoad();
return getFounded();
}
	public Date getFounded(){
		return this.founded;
	}
	public ProvinceCenterEmployee updateFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;if(!shouldReplaceBy(newFounded, oldFounded)){return this;}this.founded = newFounded;addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderByFounded(boolean asc){
doAddOrderBy(FOUNDED_PROPERTY, asc);
return this;
}
	public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FOUNDED_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreFoundedCriteria(){super.ignoreSearchProperty(FOUNDED_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addFoundedCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFoundedCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}

	
	public void setDepartment(ProvinceCenterDepartment department){ProvinceCenterDepartment oldDepartment = this.department;ProvinceCenterDepartment newDepartment = department;this.department = newDepartment;}
	public ProvinceCenterDepartment department(){
doLoad();
return getDepartment();
}
	public ProvinceCenterDepartment getDepartment(){
		return this.department;
	}
	public ProvinceCenterEmployee updateDepartment(ProvinceCenterDepartment department){ProvinceCenterDepartment oldDepartment = this.department;ProvinceCenterDepartment newDepartment = department;if(!shouldReplaceBy(newDepartment, oldDepartment)){return this;}this.department = newDepartment;addPropertyChange(DEPARTMENT_PROPERTY, oldDepartment, newDepartment);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderByDepartment(boolean asc){
doAddOrderBy(DEPARTMENT_PROPERTY, asc);
return this;
}
	public SearchCriteria createDepartmentCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DEPARTMENT_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreDepartmentCriteria(){super.ignoreSearchProperty(DEPARTMENT_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addDepartmentCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDepartmentCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDepartment(ProvinceCenterDepartment department){
		if(department != null) { setDepartment(department);}
	}

	
	public void clearDepartment(){
		setDepartment ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setProvinceCenter(RetailStoreProvinceCenter provinceCenter){RetailStoreProvinceCenter oldProvinceCenter = this.provinceCenter;RetailStoreProvinceCenter newProvinceCenter = provinceCenter;this.provinceCenter = newProvinceCenter;}
	public RetailStoreProvinceCenter provinceCenter(){
doLoad();
return getProvinceCenter();
}
	public RetailStoreProvinceCenter getProvinceCenter(){
		return this.provinceCenter;
	}
	public ProvinceCenterEmployee updateProvinceCenter(RetailStoreProvinceCenter provinceCenter){RetailStoreProvinceCenter oldProvinceCenter = this.provinceCenter;RetailStoreProvinceCenter newProvinceCenter = provinceCenter;if(!shouldReplaceBy(newProvinceCenter, oldProvinceCenter)){return this;}this.provinceCenter = newProvinceCenter;addPropertyChange(PROVINCE_CENTER_PROPERTY, oldProvinceCenter, newProvinceCenter);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderByProvinceCenter(boolean asc){
doAddOrderBy(PROVINCE_CENTER_PROPERTY, asc);
return this;
}
	public SearchCriteria createProvinceCenterCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PROVINCE_CENTER_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreProvinceCenterCriteria(){super.ignoreSearchProperty(PROVINCE_CENTER_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addProvinceCenterCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createProvinceCenterCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeProvinceCenter(RetailStoreProvinceCenter provinceCenter){
		if(provinceCenter != null) { setProvinceCenter(provinceCenter);}
	}

	
	public void clearProvinceCenter(){
		setProvinceCenter ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public ProvinceCenterEmployee updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterEmployee orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public ProvinceCenterEmployee ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public ProvinceCenterEmployee addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getDepartment(), internalType);
		addToEntityList(this, entityList, getProvinceCenter(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();



		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, MOBILE_PROPERTY, getMaskedMobile());
		appendKeyValuePair(result, EMAIL_PROPERTY, getEmail());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, DEPARTMENT_PROPERTY, getDepartment());
		appendKeyValuePair(result, PROVINCE_CENTER_PROPERTY, getProvinceCenter());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof ProvinceCenterEmployee){


			ProvinceCenterEmployee dest =(ProvinceCenterEmployee)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setMobile(getMobile());
			dest.setEmail(getEmail());
			dest.setFounded(getFounded());
			dest.setDepartment(getDepartment());
			dest.setProvinceCenter(getProvinceCenter());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof ProvinceCenterEmployee){


			ProvinceCenterEmployee dest =(ProvinceCenterEmployee)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergeFounded(getFounded());
			dest.mergeDepartment(getDepartment());
			dest.mergeProvinceCenter(getProvinceCenter());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof ProvinceCenterEmployee){


			ProvinceCenterEmployee dest =(ProvinceCenterEmployee)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeMobile(getMobile());
			dest.mergeEmail(getEmail());
			dest.mergeFounded(getFounded());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getMobile(), getEmail(), getFounded(), getDepartment(), getProvinceCenter(), getVersion()};
	}


	public static ProvinceCenterEmployee createWith(RetailscmUserContext userContext, ThrowingFunction<ProvinceCenterEmployee,ProvinceCenterEmployee,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<ProvinceCenterEmployee> customCreator = mapper.findCustomCreator(ProvinceCenterEmployee.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    ProvinceCenterEmployee result = new ProvinceCenterEmployee();
    result.setName(mapper.tryToGet(ProvinceCenterEmployee.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setMobile(mapper.tryToGet(ProvinceCenterEmployee.class, MOBILE_PROPERTY, String.class,
        1, false, result.getMobile(), params));
    result.setEmail(mapper.tryToGet(ProvinceCenterEmployee.class, EMAIL_PROPERTY, String.class,
        2, false, result.getEmail(), params));
    result.setFounded(mapper.tryToGet(ProvinceCenterEmployee.class, FOUNDED_PROPERTY, Date.class,
        0, true, result.getFounded(), params));
    result.setDepartment(mapper.tryToGet(ProvinceCenterEmployee.class, DEPARTMENT_PROPERTY, ProvinceCenterDepartment.class,
        0, true, result.getDepartment(), params));
    result.setProvinceCenter(mapper.tryToGet(ProvinceCenterEmployee.class, PROVINCE_CENTER_PROPERTY, RetailStoreProvinceCenter.class,
        0, true, result.getProvinceCenter(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixProvinceCenterEmployee(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ProvinceCenterEmployeeTokens tokens = mapper.findParamByClass(params, ProvinceCenterEmployeeTokens.class);
      if (tokens == null) {
        tokens = ProvinceCenterEmployeeTokens.start();
      }
      result = userContext.getManagerGroup().getProvinceCenterEmployeeManager().internalSaveProvinceCenterEmployee(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ProvinceCenterEmployee{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tmobile='"+getMobile()+"';");
		stringBuilder.append("\temail='"+getEmail()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getDepartment() != null ){
 			stringBuilder.append("\tdepartment='ProvinceCenterDepartment("+getDepartment().getId()+")';");
 		}
		if(getProvinceCenter() != null ){
 			stringBuilder.append("\tprovinceCenter='RetailStoreProvinceCenter("+getProvinceCenter().getId()+")';");
 		}
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

