
package com.doublechaintech.retailscm.provincecenterdepartment;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.retailstoreprovincecenter.RetailStoreProvinceCenter;
import com.doublechaintech.retailscm.provincecenteremployee.ProvinceCenterEmployee;









@JsonSerialize(using = ProvinceCenterDepartmentSerializer.class)
public class ProvinceCenterDepartment extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String NAME_PROPERTY                  = "name"              ;
	public static final String FOUNDED_PROPERTY               = "founded"           ;
	public static final String PROVINCE_CENTER_PROPERTY       = "provinceCenter"    ;
	public static final String MANAGER_PROPERTY               = "manager"           ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String PROVINCE_CENTER_EMPLOYEE_LIST            = "provinceCenterEmployeeList";

	public static final String INTERNAL_TYPE="ProvinceCenterDepartment";
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
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PROVINCE_CENTER_PROPERTY, "retail_store_province_center", "省中心")
        .withType("retail_store_province_center", RetailStoreProvinceCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(MANAGER_PROPERTY, "manager", "经理")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(PROVINCE_CENTER_EMPLOYEE_LIST, "department", "省中心员工名单")
        .withType("province_center_employee", ProvinceCenterEmployee.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,NAME_PROPERTY ,FOUNDED_PROPERTY ,PROVINCE_CENTER_PROPERTY ,MANAGER_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(PROVINCE_CENTER_EMPLOYEE_LIST, "department");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(PROVINCE_CENTER_EMPLOYEE_LIST, ProvinceCenterEmployee.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(PROVINCE_CENTER_PROPERTY, RetailStoreProvinceCenter.class);

    return parents;
  }

  public ProvinceCenterDepartment want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ProvinceCenterDepartment wants(Class<? extends BaseEntity>... classes) {
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
	protected		RetailStoreProvinceCenter	provinceCenter      ;
	protected		String              	manager             ;
	protected		int                 	version             ;

	
	protected		SmartList<ProvinceCenterEmployee>	mProvinceCenterEmployeeList;



	public 	ProvinceCenterDepartment(){
		// lazy load for all the properties
	}
	public 	static ProvinceCenterDepartment withId(String id){
		ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
		provinceCenterDepartment.setId(id);
		provinceCenterDepartment.setVersion(Integer.MAX_VALUE);
		provinceCenterDepartment.setChecked(true);
		return provinceCenterDepartment;
	}
	public 	static ProvinceCenterDepartment refById(String id){
		return withId(id);
	}

  public ProvinceCenterDepartment limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public ProvinceCenterDepartment limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static ProvinceCenterDepartment searchExample(){
    ProvinceCenterDepartment provinceCenterDepartment = new ProvinceCenterDepartment();
    		provinceCenterDepartment.setVersion(UNSET_INT);

    return provinceCenterDepartment;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setProvinceCenter( null );

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
		if(MANAGER_PROPERTY.equals(property)){
			changeManagerProperty(newValueExpr);
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
			
			
			
	protected void changeManagerProperty(String newValueExpr){
	
		String oldValue = getManager();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateManager(newValue);
		this.onChangeProperty(MANAGER_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(NAME_PROPERTY.equals(property)){
			return getName();
		}
		if(FOUNDED_PROPERTY.equals(property)){
			return getFounded();
		}
		if(PROVINCE_CENTER_PROPERTY.equals(property)){
			return getProvinceCenter();
		}
		if(MANAGER_PROPERTY.equals(property)){
			return getManager();
		}
		if(PROVINCE_CENTER_EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getProvinceCenterEmployeeList().stream().map(item->item).collect(Collectors.toList());
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
	public ProvinceCenterDepartment updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterDepartment orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public ProvinceCenterDepartment ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public ProvinceCenterDepartment addIdCriteria(QueryOperator operator, Object... parameters){
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
	public ProvinceCenterDepartment updateName(String name){String oldName = this.name;String newName = trimString(name);if(!shouldReplaceBy(newName, oldName)){return this;}this.name = newName;addPropertyChange(NAME_PROPERTY, oldName, newName);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterDepartment orderByName(boolean asc){
doAddOrderBy(NAME_PROPERTY, asc);
return this;
}
	public SearchCriteria createNameCriteria(QueryOperator operator, Object... parameters){
return createCriteria(NAME_PROPERTY, operator, parameters);
}
	public ProvinceCenterDepartment ignoreNameCriteria(){super.ignoreSearchProperty(NAME_PROPERTY);
return this;
}
	public ProvinceCenterDepartment addNameCriteria(QueryOperator operator, Object... parameters){
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
	public ProvinceCenterDepartment updateFounded(Date founded){Date oldFounded = this.founded;Date newFounded = founded;if(!shouldReplaceBy(newFounded, oldFounded)){return this;}this.founded = newFounded;addPropertyChange(FOUNDED_PROPERTY, oldFounded, newFounded);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterDepartment orderByFounded(boolean asc){
doAddOrderBy(FOUNDED_PROPERTY, asc);
return this;
}
	public SearchCriteria createFoundedCriteria(QueryOperator operator, Object... parameters){
return createCriteria(FOUNDED_PROPERTY, operator, parameters);
}
	public ProvinceCenterDepartment ignoreFoundedCriteria(){super.ignoreSearchProperty(FOUNDED_PROPERTY);
return this;
}
	public ProvinceCenterDepartment addFoundedCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createFoundedCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeFounded(Date founded){
		setFounded(founded);
	}

	
	public void setProvinceCenter(RetailStoreProvinceCenter provinceCenter){RetailStoreProvinceCenter oldProvinceCenter = this.provinceCenter;RetailStoreProvinceCenter newProvinceCenter = provinceCenter;this.provinceCenter = newProvinceCenter;}
	public RetailStoreProvinceCenter provinceCenter(){
doLoad();
return getProvinceCenter();
}
	public RetailStoreProvinceCenter getProvinceCenter(){
		return this.provinceCenter;
	}
	public ProvinceCenterDepartment updateProvinceCenter(RetailStoreProvinceCenter provinceCenter){RetailStoreProvinceCenter oldProvinceCenter = this.provinceCenter;RetailStoreProvinceCenter newProvinceCenter = provinceCenter;if(!shouldReplaceBy(newProvinceCenter, oldProvinceCenter)){return this;}this.provinceCenter = newProvinceCenter;addPropertyChange(PROVINCE_CENTER_PROPERTY, oldProvinceCenter, newProvinceCenter);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterDepartment orderByProvinceCenter(boolean asc){
doAddOrderBy(PROVINCE_CENTER_PROPERTY, asc);
return this;
}
	public SearchCriteria createProvinceCenterCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PROVINCE_CENTER_PROPERTY, operator, parameters);
}
	public ProvinceCenterDepartment ignoreProvinceCenterCriteria(){super.ignoreSearchProperty(PROVINCE_CENTER_PROPERTY);
return this;
}
	public ProvinceCenterDepartment addProvinceCenterCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setManager(String manager){String oldManager = this.manager;String newManager = trimString(manager);this.manager = newManager;}
	public String manager(){
doLoad();
return getManager();
}
	public String getManager(){
		return this.manager;
	}
	public ProvinceCenterDepartment updateManager(String manager){String oldManager = this.manager;String newManager = trimString(manager);if(!shouldReplaceBy(newManager, oldManager)){return this;}this.manager = newManager;addPropertyChange(MANAGER_PROPERTY, oldManager, newManager);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterDepartment orderByManager(boolean asc){
doAddOrderBy(MANAGER_PROPERTY, asc);
return this;
}
	public SearchCriteria createManagerCriteria(QueryOperator operator, Object... parameters){
return createCriteria(MANAGER_PROPERTY, operator, parameters);
}
	public ProvinceCenterDepartment ignoreManagerCriteria(){super.ignoreSearchProperty(MANAGER_PROPERTY);
return this;
}
	public ProvinceCenterDepartment addManagerCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createManagerCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeManager(String manager){
		if(manager != null) { setManager(manager);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public ProvinceCenterDepartment updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public ProvinceCenterDepartment orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public ProvinceCenterDepartment ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public ProvinceCenterDepartment addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
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
			provinceCenterEmployee.setDepartment(this);
		}

		this.mProvinceCenterEmployeeList = provinceCenterEmployeeList;
		this.mProvinceCenterEmployeeList.setListInternalName (PROVINCE_CENTER_EMPLOYEE_LIST );

	}

	public  ProvinceCenterDepartment addProvinceCenterEmployee(ProvinceCenterEmployee provinceCenterEmployee){
		provinceCenterEmployee.setDepartment(this);
		getProvinceCenterEmployeeList().add(provinceCenterEmployee);
		return this;
	}
	public  ProvinceCenterDepartment addProvinceCenterEmployeeList(SmartList<ProvinceCenterEmployee> provinceCenterEmployeeList){
		for( ProvinceCenterEmployee provinceCenterEmployee:provinceCenterEmployeeList){
			provinceCenterEmployee.setDepartment(this);
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
        // provinceCenterEmployee.clearDepartment(); //disconnect with Department
        provinceCenterEmployee.clearFromAll(); //disconnect with Department

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
		provinceCenterEmployee.setDepartment(null);
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





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getProvinceCenter(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getProvinceCenterEmployeeList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getProvinceCenterEmployeeList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, NAME_PROPERTY, getName());
		appendKeyValuePair(result, FOUNDED_PROPERTY, getFounded());
		appendKeyValuePair(result, PROVINCE_CENTER_PROPERTY, getProvinceCenter());
		appendKeyValuePair(result, MANAGER_PROPERTY, getManager());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, PROVINCE_CENTER_EMPLOYEE_LIST, getProvinceCenterEmployeeList());
		if(!getProvinceCenterEmployeeList().isEmpty()){
			appendKeyValuePair(result, "provinceCenterEmployeeCount", getProvinceCenterEmployeeList().getTotalCount());
			appendKeyValuePair(result, "provinceCenterEmployeeCurrentPageNumber", getProvinceCenterEmployeeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof ProvinceCenterDepartment){


			ProvinceCenterDepartment dest =(ProvinceCenterDepartment)baseDest;

			dest.setId(getId());
			dest.setName(getName());
			dest.setFounded(getFounded());
			dest.setProvinceCenter(getProvinceCenter());
			dest.setManager(getManager());
			dest.setVersion(getVersion());
			dest.setProvinceCenterEmployeeList(getProvinceCenterEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof ProvinceCenterDepartment){


			ProvinceCenterDepartment dest =(ProvinceCenterDepartment)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeProvinceCenter(getProvinceCenter());
			dest.mergeManager(getManager());
			dest.mergeVersion(getVersion());
			dest.mergeProvinceCenterEmployeeList(getProvinceCenterEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof ProvinceCenterDepartment){


			ProvinceCenterDepartment dest =(ProvinceCenterDepartment)baseDest;

			dest.mergeId(getId());
			dest.mergeName(getName());
			dest.mergeFounded(getFounded());
			dest.mergeManager(getManager());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getName(), getFounded(), getProvinceCenter(), getManager(), getVersion()};
	}


	public static ProvinceCenterDepartment createWith(RetailscmUserContext userContext, ThrowingFunction<ProvinceCenterDepartment,ProvinceCenterDepartment,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<ProvinceCenterDepartment> customCreator = mapper.findCustomCreator(ProvinceCenterDepartment.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    ProvinceCenterDepartment result = new ProvinceCenterDepartment();
    result.setName(mapper.tryToGet(ProvinceCenterDepartment.class, NAME_PROPERTY, String.class,
        0, false, result.getName(), params));
    result.setFounded(mapper.tryToGet(ProvinceCenterDepartment.class, FOUNDED_PROPERTY, Date.class,
        0, true, result.getFounded(), params));
    result.setProvinceCenter(mapper.tryToGet(ProvinceCenterDepartment.class, PROVINCE_CENTER_PROPERTY, RetailStoreProvinceCenter.class,
        0, true, result.getProvinceCenter(), params));
    result.setManager(mapper.tryToGet(ProvinceCenterDepartment.class, MANAGER_PROPERTY, String.class,
        1, false, result.getManager(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixProvinceCenterDepartment(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ProvinceCenterDepartmentTokens tokens = mapper.findParamByClass(params, ProvinceCenterDepartmentTokens.class);
      if (tokens == null) {
        tokens = ProvinceCenterDepartmentTokens.start();
      }
      result = userContext.getManagerGroup().getProvinceCenterDepartmentManager().internalSaveProvinceCenterDepartment(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ProvinceCenterDepartment{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tname='"+getName()+"';");
		stringBuilder.append("\tfounded='"+getFounded()+"';");
		if(getProvinceCenter() != null ){
 			stringBuilder.append("\tprovinceCenter='RetailStoreProvinceCenter("+getProvinceCenter().getId()+")';");
 		}
		stringBuilder.append("\tmanager='"+getManager()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

