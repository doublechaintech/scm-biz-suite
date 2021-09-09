
package com.doublechaintech.retailscm.retailstoreprovincecenter;

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
import com.doublechaintech.retailscm.provincecenterdepartment.ProvinceCenterDepartment;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;
import com.doublechaintech.retailscm.retailstorecityservicecenter.RetailStoreCityServiceCenter;









@JsonSerialize(using = RetailStoreProvinceCenterSerializer.class)
public class RetailStoreProvinceCenter extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String COUNTRY_PROPERTY               = "country"           ;
	public static final String LAST_UPDATE_TIME_PROPERTY      = "lastUpdateTime"    ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PROVINCE_CENTER_DEPARTMENT_LIST          = "provinceCenterDepartmentList";
	public static final String PROVINCE_CENTER_EMPLOYEE_LIST            = "provinceCenterEmployeeList";
	public static final String RETAIL_STORE_CITY_SERVICE_CENTER_LIST    = "retailStoreCityServiceCenterList";

	public static final String INTERNAL_TYPE="RetailStoreProvinceCenter";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(NAME_PROPERTY, "name", "名称")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(FOUNDED_PROPERTY, "founded", "成立")
        .withType("date_past", "Date"));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(COUNTRY_PROPERTY, "retail_store_country_center", "国")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(LAST_UPDATE_TIME_PROPERTY, "last_update_time", "更新于")
        .withType("date_time_update", DateTime.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(PROVINCE_CENTER_DEPARTMENT_LIST, "provinceCenter", "省中心部门名单")
        .withType("province_center_department", ProvinceCenterDepartment.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(PROVINCE_CENTER_EMPLOYEE_LIST, "provinceCenter", "省中心员工名单")
        .withType("province_center_employee", ProvinceCenterEmployee.class));

  memberMetaInfoList.add(MemberMetaInfo.referBy(RETAIL_STORE_CITY_SERVICE_CENTER_LIST, "belongsTo", "零售门店城市服务中心名单")
        .withType("retail_store_city_service_center", RetailStoreCityServiceCenter.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,FOUNDED_PROPERTY ,COUNTRY_PROPERTY ,LAST_UPDATE_TIME_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(PROVINCE_CENTER_DEPARTMENT_LIST, "provinceCenter");
    	
    	    refers.put(PROVINCE_CENTER_EMPLOYEE_LIST, "provinceCenter");
    	
    	    refers.put(RETAIL_STORE_CITY_SERVICE_CENTER_LIST, "belongsTo");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(PROVINCE_CENTER_DEPARTMENT_LIST, ProvinceCenterDepartment.class);
        	
        	    refers.put(PROVINCE_CENTER_EMPLOYEE_LIST, ProvinceCenterEmployee.class);
        	
        	    refers.put(RETAIL_STORE_CITY_SERVICE_CENTER_LIST, RetailStoreCityServiceCenter.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COUNTRY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public RetailStoreProvinceCenter want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public RetailStoreProvinceCenter wants(Class<? extends BaseEntity>... classes) {
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
	protected		Date                	founded             ;
	protected		RetailStoreCountryCenter	country             ;
	protected		DateTime            	lastUpdateTime      ;
	protected		int                 	version             ;

	
	protected		SmartList<ProvinceCenterDepartment>	mProvinceCenterDepartmentList;
	protected		SmartList<ProvinceCenterEmployee>	mProvinceCenterEmployeeList;
	protected		SmartList<RetailStoreCityServiceCenter>	mRetailStoreCityServiceCenterList;



	public 	RetailStoreProvinceCenter(){
		// lazy load for all the properties
	}
	public 	static RetailStoreProvinceCenter withId(String id){
		RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
		retailStoreProvinceCenter.setId(id);
		retailStoreProvinceCenter.setVersion(Integer.MAX_VALUE);
		retailStoreProvinceCenter.setChecked(true);
		return retailStoreProvinceCenter;
	}
	public 	static RetailStoreProvinceCenter refById(String id){
		return withId(id);
	}

  public RetailStoreProvinceCenter limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public RetailStoreProvinceCenter limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static RetailStoreProvinceCenter searchExample(){
    RetailStoreProvinceCenter retailStoreProvinceCenter = new RetailStoreProvinceCenter();
    		retailStoreProvinceCenter.setVersion(UNSET_INT);

    return retailStoreProvinceCenter;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCountry( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(NAME_PROPERTY.equals(property)){
			changeNameProperty(newValueExpr);
		}
		if(FOUNDED_PROPERTY.equals(property)){
			changeFoundedProperty(newValueExpr);
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
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(COUNTRY_PROPERTY.equals(property)){
			return getCountry();
		}
		if(LAST_UPDATE_TIME_PROPERTY.equals(property)){
			return getLastUpdateTime();
		}
		if(PROVINCE_CENTER_DEPARTMENT_LIST.equals(property)){
			List<BaseEntity> list = getProvinceCenterDepartmentList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(PROVINCE_CENTER_EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getProvinceCenterEmployeeList().stream().map(item->item).collect(Collectors.toList());
			return list;
		}
		if(RETAIL_STORE_CITY_SERVICE_CENTER_LIST.equals(property)){
			List<BaseEntity> list = getRetailStoreCityServiceCenterList().stream().map(item->item).collect(Collectors.toList());
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
	public RetailStoreProvinceCenter updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public RetailStoreProvinceCenter orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public RetailStoreProvinceCenter ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public RetailStoreProvinceCenter addIdCriteria(QueryOperator operator, Object... parameters){
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
	public RetailStoreProvinceCenter updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public RetailStoreProvinceCenter orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public RetailStoreProvinceCenter ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public RetailStoreProvinceCenter addNameCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createNameCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeName(String name){
		if(name != null) { setName(name);}
	}

	
	public void setFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;this.founded = newFounded;}
	public Date founded(){
doLoad();
return getFounded();
}
	public Date getFounded(){
		return this.founded;
	}
	public RetailStoreProvinceCenter updateFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;if(!shouldReplaceBy(newFounded, oldFounded)){return this;}this.founded = newFounded;addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);this.changed = true;setChecked(false);return this;}
	public RetailStoreProvinceCenter orderByFounded(boolean asc){
doAddOrderBy(FOUNDED_PROPERTY, asc);
return this;
}
	public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FOUNDED_PROPERTY, operator, parameters);
}
	public RetailStoreProvinceCenter ignoreFoundedCriteria(){super.ignoreSearchProperty(FOUNDED_PROPERTY);
return this;
}
	public RetailStoreProvinceCenter addFoundedCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFoundedCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}

	
	public void setCountry(RetailStoreCountryCenter country){RetailStoreCountryCenter oldCountry = this.country;RetailStoreCountryCenter newCountry = country;this.country = newCountry;}
	public RetailStoreCountryCenter country(){
doLoad();
return getCountry();
}
	public RetailStoreCountryCenter getCountry(){
		return this.country;
	}
	public RetailStoreProvinceCenter updateCountry(RetailStoreCountryCenter country){RetailStoreCountryCenter oldCountry = this.country;RetailStoreCountryCenter newCountry = country;if(!shouldReplaceBy(newCountry, oldCountry)){return this;}this.country = newCountry;addPropertyChange(COUNTRY_PROPERTY, oldCountry, newCountry);this.changed = true;setChecked(false);return this;}
	public RetailStoreProvinceCenter orderByCountry(boolean asc){
doAddOrderBy(COUNTRY_PROPERTY, asc);
return this;
}
	public SearchCriteria createCountryCriteria(QueryOperator operator, Object... parameters){
return createCriteria(COUNTRY_PROPERTY, operator, parameters);
}
	public RetailStoreProvinceCenter ignoreCountryCriteria(){super.ignoreSearchProperty(COUNTRY_PROPERTY);
return this;
}
	public RetailStoreProvinceCenter addCountryCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCountryCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCountry(RetailStoreCountryCenter country){
		if(country != null) { setCountry(country);}
	}

	
	public void clearCountry(){
		setCountry ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;this.lastUpdateTime = newLastUpdateTime;}
	public DateTime lastUpdateTime(){
doLoad();
return getLastUpdateTime();
}
	public DateTime getLastUpdateTime(){
		return this.lastUpdateTime;
	}
	public RetailStoreProvinceCenter updateLastUpdateTime(DateTime lastUpdateTime){DateTime oldLastUpdateTime = this.lastUpdateTime;DateTime newLastUpdateTime = lastUpdateTime;if(!shouldReplaceBy(newLastUpdateTime, oldLastUpdateTime)){return this;}this.lastUpdateTime = newLastUpdateTime;addPropertyChange(LAST_UPDATE_TIME_PROPERTY, oldLastUpdateTime, newLastUpdateTime);this.changed = true;setChecked(false);return this;}
	public RetailStoreProvinceCenter orderByLastUpdateTime(boolean asc){
doAddOrderBy(LAST_UPDATE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(LAST_UPDATE_TIME_PROPERTY, operator, parameters);
}
	public RetailStoreProvinceCenter ignoreLastUpdateTimeCriteria(){super.ignoreSearchProperty(LAST_UPDATE_TIME_PROPERTY);
return this;
}
	public RetailStoreProvinceCenter addLastUpdateTimeCriteria(QueryOperator operator, Object... parameters){
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
	public RetailStoreProvinceCenter updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public RetailStoreProvinceCenter orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public RetailStoreProvinceCenter ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public RetailStoreProvinceCenter addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<ProvinceCenterDepartment> getProvinceCenterDepartmentList(){
		if(this.mProvinceCenterDepartmentList == null){
			this.mProvinceCenterDepartmentList = new SmartList<ProvinceCenterDepartment>();
			this.mProvinceCenterDepartmentList.setListInternalName (PROVINCE_CENTER_DEPARTMENT_LIST );
			//有名字，便于做权限控制
		}

		return this.mProvinceCenterDepartmentList;
	}

  public  SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList(){
    
    doLoadChild(PROVINCE_CENTER_DEPARTMENT_LIST);
    
    return getProvinceCenterDepartmentList();
  }


	public  void setProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList){
		for( ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList){
			provinceCenterDepartment.setProvinceCenter(this);
		}

		this.mProvinceCenterDepartmentList = provinceCenterDepartmentList;
		this.mProvinceCenterDepartmentList.setListInternalName (PROVINCE_CENTER_DEPARTMENT_LIST );

	}

	public  RetailStoreProvinceCenter addProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment){
		provinceCenterDepartment.setProvinceCenter(this);
		getProvinceCenterDepartmentList().add(provinceCenterDepartment);
		return this;
	}
	public  RetailStoreProvinceCenter addProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList){
		for( ProvinceCenterDepartment provinceCenterDepartment:provinceCenterDepartmentList){
			provinceCenterDepartment.setProvinceCenter(this);
		}
		getProvinceCenterDepartmentList().addAll(provinceCenterDepartmentList);
		return this;
	}
	public  void mergeProvinceCenterDepartmentList(SmartList<ProvinceCenterDepartment> provinceCenterDepartmentList){
		if(provinceCenterDepartmentList==null){
			return;
		}
		if(provinceCenterDepartmentList.isEmpty()){
			return;
		}
		addProvinceCenterDepartmentList( provinceCenterDepartmentList );

	}
	public  ProvinceCenterDepartment removeProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartmentIndex){

		int index = getProvinceCenterDepartmentList().indexOf(provinceCenterDepartmentIndex);
        if(index < 0){
        	String message = "ProvinceCenterDepartment("+provinceCenterDepartmentIndex.getId()+") with version='"+provinceCenterDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ProvinceCenterDepartment provinceCenterDepartment = getProvinceCenterDepartmentList().get(index);
        // provinceCenterDepartment.clearProvinceCenter(); //disconnect with ProvinceCenter
        provinceCenterDepartment.clearFromAll(); //disconnect with ProvinceCenter

		boolean result = getProvinceCenterDepartmentList().planToRemove(provinceCenterDepartment);
        if(!result){
        	String message = "ProvinceCenterDepartment("+provinceCenterDepartmentIndex.getId()+") with version='"+provinceCenterDepartmentIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return provinceCenterDepartment;


	}
	//断舍离
	public  void breakWithProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment){

		if(provinceCenterDepartment == null){
			return;
		}
		provinceCenterDepartment.setProvinceCenter(null);
		//getProvinceCenterDepartmentList().remove();

	}

	public  boolean hasProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment){

		return getProvinceCenterDepartmentList().contains(provinceCenterDepartment);

	}

	public void copyProvinceCenterDepartmentFrom(ProvinceCenterDepartment provinceCenterDepartment) {

		ProvinceCenterDepartment provinceCenterDepartmentInList = findTheProvinceCenterDepartment(provinceCenterDepartment);
		ProvinceCenterDepartment newProvinceCenterDepartment = new ProvinceCenterDepartment();
		provinceCenterDepartmentInList.copyTo(newProvinceCenterDepartment);
		newProvinceCenterDepartment.setVersion(0);//will trigger copy
		getProvinceCenterDepartmentList().add(newProvinceCenterDepartment);
		addItemToFlexiableObject(COPIED_CHILD, newProvinceCenterDepartment);
	}

	public  ProvinceCenterDepartment findTheProvinceCenterDepartment(ProvinceCenterDepartment provinceCenterDepartment){

		int index =  getProvinceCenterDepartmentList().indexOf(provinceCenterDepartment);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ProvinceCenterDepartment("+provinceCenterDepartment.getId()+") with version='"+provinceCenterDepartment.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getProvinceCenterDepartmentList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpProvinceCenterDepartmentList(){
		getProvinceCenterDepartmentList().clear();
	}





	public  SmartList<ProvinceCenterEmployee> getProvinceCenterEmployeeList(){
		if(this.mProvinceCenterEmployeeList == null){
			this.mProvinceCenterEmployeeList = new SmartList<ProvinceCenterEmployee>();
			this.mProvinceCenterEmployeeList.setListInternalName (PROVINCE_CENTER_EMPLOYEE_LIST );
			//有名字，便于做权限控制
		}

		return this.mProvinceCenterEmployeeList;
	}

  public  SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList(){
    
    doLoadChild(PROVINCE_CENTER_EMPLOYEE_LIST);
    
    return getProvinceCenterEmployeeList();
  }


	public  void setProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setProvinceCenter(this);
		}

		this.mProvinceCenterEmployeeList = provinceCenterEmployeeList;
		this.mProvinceCenterEmployeeList.setListInternalName (PROVINCE_CENTER_EMPLOYEE_LIST );

	}

	public  RetailStoreProvinceCenter addProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		provinceCenterEmployee.setProvinceCenter(this);
		getProvinceCenterEmployeeList().add(provinceCenterEmployee);
		return this;
	}
	public  RetailStoreProvinceCenter addProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setProvinceCenter(this);
		}
		getProvinceCenterEmployeeList().addAll(provinceCenterEmployeeList);
		return this;
	}
	public  void mergeProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		if(provinceCenterEmployeeList==null){
			return;
		}
		if(provinceCenterEmployeeList.isEmpty()){
			return;
		}
		addProvinceCenterEmployeeList( provinceCenterEmployeeList );

	}
	public  ProvinceCenterEmployee removeProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployeeIndex){

		int index = getProvinceCenterEmployeeList().indexOf(provinceCenterEmployeeIndex);
        if(index < 0){
        	String message = "ProvinceCenterEmployee("+provinceCenterEmployeeIndex.getId()+") with version='"+provinceCenterEmployeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        ProvinceCenterEmployee provinceCenterEmployee = getProvinceCenterEmployeeList().get(index);
        // provinceCenterEmployee.clearProvinceCenter(); //disconnect with ProvinceCenter
        provinceCenterEmployee.clearFromAll(); //disconnect with ProvinceCenter

		boolean result = getProvinceCenterEmployeeList().planToRemove(provinceCenterEmployee);
        if(!result){
        	String message = "ProvinceCenterEmployee("+provinceCenterEmployeeIndex.getId()+") with version='"+provinceCenterEmployeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return provinceCenterEmployee;


	}
	//断舍离
	public  void breakWithProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){

		if(provinceCenterEmployee == null){
			return;
		}
		provinceCenterEmployee.setProvinceCenter(null);
		//getProvinceCenterEmployeeList().remove();

	}

	public  boolean hasProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){

		return getProvinceCenterEmployeeList().contains(provinceCenterEmployee);

	}

	public void copyProvinceCenterEmployeeFrom(ProvinceCenterEmployee provinceCenterEmployee) {

		ProvinceCenterEmployee provinceCenterEmployeeInList = findTheProvinceCenterEmployee(provinceCenterEmployee);
		ProvinceCenterEmployee newProvinceCenterEmployee = new ProvinceCenterEmployee();
		provinceCenterEmployeeInList.copyTo(newProvinceCenterEmployee);
		newProvinceCenterEmployee.setVersion(0);//will trigger copy
		getProvinceCenterEmployeeList().add(newProvinceCenterEmployee);
		addItemToFlexiableObject(COPIED_CHILD, newProvinceCenterEmployee);
	}

	public  ProvinceCenterEmployee findTheProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){

		int index =  getProvinceCenterEmployeeList().indexOf(provinceCenterEmployee);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "ProvinceCenterEmployee("+provinceCenterEmployee.getId()+") with version='"+provinceCenterEmployee.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getProvinceCenterEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpProvinceCenterEmployeeList(){
		getProvinceCenterEmployeeList().clear();
	}





	public  SmartList<RetailStoreCityServiceCenter> getRetailStoreCityServiceCenterList(){
		if(this.mRetailStoreCityServiceCenterList == null){
			this.mRetailStoreCityServiceCenterList = new SmartList<RetailStoreCityServiceCenter>();
			this.mRetailStoreCityServiceCenterList.setListInternalName (RETAIL_STORE_CITY_SERVICE_CENTER_LIST );
			//有名字，便于做权限控制
		}

		return this.mRetailStoreCityServiceCenterList;
	}

  public  SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList(){
    
    doLoadChild(RETAIL_STORE_CITY_SERVICE_CENTER_LIST);
    
    return getRetailStoreCityServiceCenterList();
  }


	public  void setRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		for( RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList){
			retailStoreCityServiceCenter.setBelongsTo(this);
		}

		this.mRetailStoreCityServiceCenterList = retailStoreCityServiceCenterList;
		this.mRetailStoreCityServiceCenterList.setListInternalName (RETAIL_STORE_CITY_SERVICE_CENTER_LIST );

	}

	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter){
		retailStoreCityServiceCenter.setBelongsTo(this);
		getRetailStoreCityServiceCenterList().add(retailStoreCityServiceCenter);
		return this;
	}
	public  RetailStoreProvinceCenter addRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		for( RetailStoreCityServiceCenter retailStoreCityServiceCenter:retailStoreCityServiceCenterList){
			retailStoreCityServiceCenter.setBelongsTo(this);
		}
		getRetailStoreCityServiceCenterList().addAll(retailStoreCityServiceCenterList);
		return this;
	}
	public  void mergeRetailStoreCityServiceCenterList(SmartList<RetailStoreCityServiceCenter> retailStoreCityServiceCenterList){
		if(retailStoreCityServiceCenterList==null){
			return;
		}
		if(retailStoreCityServiceCenterList.isEmpty()){
			return;
		}
		addRetailStoreCityServiceCenterList( retailStoreCityServiceCenterList );

	}
	public  RetailStoreCityServiceCenter removeRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenterIndex){

		int index = getRetailStoreCityServiceCenterList().indexOf(retailStoreCityServiceCenterIndex);
        if(index < 0){
        	String message = "RetailStoreCityServiceCenter("+retailStoreCityServiceCenterIndex.getId()+") with version='"+retailStoreCityServiceCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        RetailStoreCityServiceCenter retailStoreCityServiceCenter = getRetailStoreCityServiceCenterList().get(index);
        // retailStoreCityServiceCenter.clearBelongsTo(); //disconnect with BelongsTo
        retailStoreCityServiceCenter.clearFromAll(); //disconnect with BelongsTo

		boolean result = getRetailStoreCityServiceCenterList().planToRemove(retailStoreCityServiceCenter);
        if(!result){
        	String message = "RetailStoreCityServiceCenter("+retailStoreCityServiceCenterIndex.getId()+") with version='"+retailStoreCityServiceCenterIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return retailStoreCityServiceCenter;


	}
	//断舍离
	public  void breakWithRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter){

		if(retailStoreCityServiceCenter == null){
			return;
		}
		retailStoreCityServiceCenter.setBelongsTo(null);
		//getRetailStoreCityServiceCenterList().remove();

	}

	public  boolean hasRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter){

		return getRetailStoreCityServiceCenterList().contains(retailStoreCityServiceCenter);

	}

	public void copyRetailStoreCityServiceCenterFrom(RetailStoreCityServiceCenter retailStoreCityServiceCenter) {

		RetailStoreCityServiceCenter retailStoreCityServiceCenterInList = findTheRetailStoreCityServiceCenter(retailStoreCityServiceCenter);
		RetailStoreCityServiceCenter newRetailStoreCityServiceCenter = new RetailStoreCityServiceCenter();
		retailStoreCityServiceCenterInList.copyTo(newRetailStoreCityServiceCenter);
		newRetailStoreCityServiceCenter.setVersion(0);//will trigger copy
		getRetailStoreCityServiceCenterList().add(newRetailStoreCityServiceCenter);
		addItemToFlexiableObject(COPIED_CHILD, newRetailStoreCityServiceCenter);
	}

	public  RetailStoreCityServiceCenter findTheRetailStoreCityServiceCenter(RetailStoreCityServiceCenter retailStoreCityServiceCenter){

		int index =  getRetailStoreCityServiceCenterList().indexOf(retailStoreCityServiceCenter);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "RetailStoreCityServiceCenter("+retailStoreCityServiceCenter.getId()+") with version='"+retailStoreCityServiceCenter.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getRetailStoreCityServiceCenterList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpRetailStoreCityServiceCenterList(){
		getRetailStoreCityServiceCenterList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCountry(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProvinceCenterDepartmentList(), internalType);
		collectFromList(this, entityList, getProvinceCenterEmployeeList(), internalType);
		collectFromList(this, entityList, getRetailStoreCityServiceCenterList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getProvinceCenterDepartmentList());
		listOfList.add( getProvinceCenterEmployeeList());
		listOfList.add( getRetailStoreCityServiceCenterList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, COUNTRY_PROPERTY, getCountry());
		appendKeyValuePair(result, LAST_UPDATE_TIME_PROPERTY, getLastUpdateTime());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PROVINCE_CENTER_DEPARTMENT_LIST, getProvinceCenterDepartmentList());
		if(!getProvinceCenterDepartmentList().isEmpty()){
			appendKeyValuePair(result, "provinceCenterDepartmentCount", getProvinceCenterDepartmentList().getTotalCount());
			appendKeyValuePair(result, "provinceCenterDepartmentCurrentPageNumber", getProvinceCenterDepartmentList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, PROVINCE_CENTER_EMPLOYEE_LIST, getProvinceCenterEmployeeList());
		if(!getProvinceCenterEmployeeList().isEmpty()){
			appendKeyValuePair(result, "provinceCenterEmployeeCount", getProvinceCenterEmployeeList().getTotalCount());
			appendKeyValuePair(result, "provinceCenterEmployeeCurrentPageNumber", getProvinceCenterEmployeeList().getCurrentPageNumber());
		}
		appendKeyValuePair(result, RETAIL_STORE_CITY_SERVICE_CENTER_LIST, getRetailStoreCityServiceCenterList());
		if(!getRetailStoreCityServiceCenterList().isEmpty()){
			appendKeyValuePair(result, "retailStoreCityServiceCenterCount", getRetailStoreCityServiceCenterList().getTotalCount());
			appendKeyValuePair(result, "retailStoreCityServiceCenterCurrentPageNumber", getRetailStoreCityServiceCenterList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreProvinceCenter){


			RetailStoreProvinceCenter dest =(RetailStoreProvinceCenter)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setFounded(getFounded());
			dest.setCountry(getCountry());
			dest.setLastUpdateTime(getLastUpdateTime());
			dest.setVersion(getVersion());
			dest.setProvinceCenterDepartmentList(getProvinceCenterDepartmentList());
			dest.setProvinceCenterEmployeeList(getProvinceCenterEmployeeList());
			dest.setRetailStoreCityServiceCenterList(getRetailStoreCityServiceCenterList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreProvinceCenter){


			RetailStoreProvinceCenter dest =(RetailStoreProvinceCenter)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeCountry(getCountry());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());
			dest.mergeProvinceCenterDepartmentList(getProvinceCenterDepartmentList());
			dest.mergeProvinceCenterEmployeeList(getProvinceCenterEmployeeList());
			dest.mergeRetailStoreCityServiceCenterList(getRetailStoreCityServiceCenterList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof RetailStoreProvinceCenter){


			RetailStoreProvinceCenter dest =(RetailStoreProvinceCenter)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeLastUpdateTime(getLastUpdateTime());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFounded(), getCountry(), getLastUpdateTime(), getVersion()};
	}


	public static RetailStoreProvinceCenter createWith(RetailscmUserContext userContext, ThrowingFunction<RetailStoreProvinceCenter,RetailStoreProvinceCenter,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<RetailStoreProvinceCenter> customCreator = mapper.findCustomCreator(RetailStoreProvinceCenter.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    RetailStoreProvinceCenter result = new RetailStoreProvinceCenter();
    result.setName(mapper.tryToGet(RetailStoreProvinceCenter.class, NAME_PROPERTY, String.class,
        0, true, result.getName(), params));
    result.setFounded(mapper.tryToGet(RetailStoreProvinceCenter.class, FOUNDED_PROPERTY, Date.class,
        0, true, result.getFounded(), params));
    result.setCountry(mapper.tryToGet(RetailStoreProvinceCenter.class, COUNTRY_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getCountry(), params));
     result.setLastUpdateTime(userContext.now());

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixRetailStoreProvinceCenter(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      RetailStoreProvinceCenterTokens tokens = mapper.findParamByClass(params, RetailStoreProvinceCenterTokens.class);
      if (tokens == null) {
        tokens = RetailStoreProvinceCenterTokens.start();
      }
      result = userContext.getManagerGroup().getRetailStoreProvinceCenterManager().internalSaveRetailStoreProvinceCenter(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("RetailStoreProvinceCenter{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getCountry() != null ){
 			stringBuilder.append("\tcountry='RetailStoreCountryCenter("+getCountry().getId()+")';");
 		}
		stringBuilder.append("\tlastUpdateTime='"+getLastUpdateTime()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

