
package com.doublechaintech.retailscm.responsibilitytype;

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
import com.doublechaintech.retailscm.employee.Employee;









@JsonSerialize(using = ResponsibilityTypeSerializer.class)
public class ResponsibilityType extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String CODE_PROPERTY                  = "code"              ;
	public static final String COMPANY_PROPERTY               = "company"           ;
	public static final String BASE_DESCRIPTION_PROPERTY      = "baseDescription"   ;
	public static final String DETAIL_DESCRIPTION_PROPERTY    = "detailDescription" ;
	public static final String VERSION_PROPERTY               = "version"           ;

	public static final String EMPLOYEE_LIST                            = "employeeList"      ;

	public static final String INTERNAL_TYPE="ResponsibilityType";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(CODE_PROPERTY, "code", "代码")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(COMPANY_PROPERTY, "retail_store_country_center", "公司")
        .withType("retail_store_country_center", RetailStoreCountryCenter.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(BASE_DESCRIPTION_PROPERTY, "base_description", "基本描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DETAIL_DESCRIPTION_PROPERTY, "detail_description", "详细描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));

  memberMetaInfoList.add(MemberMetaInfo.referBy(EMPLOYEE_LIST, "responsibleFor", "员工列表")
        .withType("employee", Employee.class));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,CODE_PROPERTY ,COMPANY_PROPERTY ,BASE_DESCRIPTION_PROPERTY ,DETAIL_DESCRIPTION_PROPERTY ,VERSION_PROPERTY};
  }

  public Map<String, String> getReferProperties(){
    Map<String, String> refers = new HashMap<>();
    	
    	    refers.put(EMPLOYEE_LIST, "responsibleFor");
    	
    return refers;
  }

  public Map<String, Class> getReferTypes() {
    Map<String, Class> refers = new HashMap<>();
        	
        	    refers.put(EMPLOYEE_LIST, Employee.class);
        	
    return refers;
  }

  public Map<String, Class<? extends BaseEntity>> getParentProperties(){
    Map<String, Class<? extends BaseEntity>> parents = new HashMap<>();
    parents.put(COMPANY_PROPERTY, RetailStoreCountryCenter.class);

    return parents;
  }

  public ResponsibilityType want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public ResponsibilityType wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getCode();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		String              	code                ;
	protected		RetailStoreCountryCenter	company             ;
	protected		String              	baseDescription     ;
	protected		String              	detailDescription   ;
	protected		int                 	version             ;

	
	protected		SmartList<Employee> 	mEmployeeList       ;



	public 	ResponsibilityType(){
		// lazy load for all the properties
	}
	public 	static ResponsibilityType withId(String id){
		ResponsibilityType responsibilityType = new ResponsibilityType();
		responsibilityType.setId(id);
		responsibilityType.setVersion(Integer.MAX_VALUE);
		responsibilityType.setChecked(true);
		return responsibilityType;
	}
	public 	static ResponsibilityType refById(String id){
		return withId(id);
	}

  public ResponsibilityType limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public ResponsibilityType limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static ResponsibilityType searchExample(){
    ResponsibilityType responsibilityType = new ResponsibilityType();
    		responsibilityType.setVersion(UNSET_INT);

    return responsibilityType;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setCompany( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(CODE_PROPERTY.equals(property)){
			changeCodeProperty(newValueExpr);
		}
		if(BASE_DESCRIPTION_PROPERTY.equals(property)){
			changeBaseDescriptionProperty(newValueExpr);
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			changeDetailDescriptionProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCodeProperty(String newValueExpr){
	
		String oldValue = getCode();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCode(newValue);
		this.onChangeProperty(CODE_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeBaseDescriptionProperty(String newValueExpr){
	
		String oldValue = getBaseDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateBaseDescription(newValue);
		this.onChangeProperty(BASE_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeDetailDescriptionProperty(String newValueExpr){
	
		String oldValue = getDetailDescription();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateDetailDescription(newValue);
		this.onChangeProperty(DETAIL_DESCRIPTION_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(CODE_PROPERTY.equals(property)){
			return getCode();
		}
		if(COMPANY_PROPERTY.equals(property)){
			return getCompany();
		}
		if(BASE_DESCRIPTION_PROPERTY.equals(property)){
			return getBaseDescription();
		}
		if(DETAIL_DESCRIPTION_PROPERTY.equals(property)){
			return getDetailDescription();
		}
		if(EMPLOYEE_LIST.equals(property)){
			List<BaseEntity> list = getEmployeeList().stream().map(item->item).collect(Collectors.toList());
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
	public ResponsibilityType updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public ResponsibilityType orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public ResponsibilityType ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public ResponsibilityType addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setCode(String code){String oldCode = this.code;String newCode = trimString(code);this.code = newCode;}
	public String code(){
doLoad();
return getCode();
}
	public String getCode(){
		return this.code;
	}
	public ResponsibilityType updateCode(String code){String oldCode = this.code;String newCode = trimString(code);if(!shouldReplaceBy(newCode, oldCode)){return this;}this.code = newCode;addPropertyChange(CODE_PROPERTY, oldCode, newCode);this.changed = true;setChecked(false);return this;}
	public ResponsibilityType orderByCode(boolean asc){
doAddOrderBy(CODE_PROPERTY, asc);
return this;
}
	public SearchCriteria createCodeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(CODE_PROPERTY, operator, parameters);
}
	public ResponsibilityType ignoreCodeCriteria(){super.ignoreSearchProperty(CODE_PROPERTY);
return this;
}
	public ResponsibilityType addCodeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCodeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCode(String code){
		if(code != null) { setCode(code);}
	}

	
	public void setCompany(RetailStoreCountryCenter company){RetailStoreCountryCenter oldCompany = this.company;RetailStoreCountryCenter newCompany = company;this.company = newCompany;}
	public RetailStoreCountryCenter company(){
doLoad();
return getCompany();
}
	public RetailStoreCountryCenter getCompany(){
		return this.company;
	}
	public ResponsibilityType updateCompany(RetailStoreCountryCenter company){RetailStoreCountryCenter oldCompany = this.company;RetailStoreCountryCenter newCompany = company;if(!shouldReplaceBy(newCompany, oldCompany)){return this;}this.company = newCompany;addPropertyChange(COMPANY_PROPERTY, oldCompany, newCompany);this.changed = true;setChecked(false);return this;}
	public ResponsibilityType orderByCompany(boolean asc){
doAddOrderBy(COMPANY_PROPERTY, asc);
return this;
}
	public SearchCriteria createCompanyCriteria(QueryOperator operator, Object... parameters){
return createCriteria(COMPANY_PROPERTY, operator, parameters);
}
	public ResponsibilityType ignoreCompanyCriteria(){super.ignoreSearchProperty(COMPANY_PROPERTY);
return this;
}
	public ResponsibilityType addCompanyCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCompanyCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCompany(RetailStoreCountryCenter company){
		if(company != null) { setCompany(company);}
	}

	
	public void clearCompany(){
		setCompany ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setBaseDescription(String baseDescription){String oldBaseDescription = this.baseDescription;String newBaseDescription = trimString(baseDescription);this.baseDescription = newBaseDescription;}
	public String baseDescription(){
doLoad();
return getBaseDescription();
}
	public String getBaseDescription(){
		return this.baseDescription;
	}
	public ResponsibilityType updateBaseDescription(String baseDescription){String oldBaseDescription = this.baseDescription;String newBaseDescription = trimString(baseDescription);if(!shouldReplaceBy(newBaseDescription, oldBaseDescription)){return this;}this.baseDescription = newBaseDescription;addPropertyChange(BASE_DESCRIPTION_PROPERTY, oldBaseDescription, newBaseDescription);this.changed = true;setChecked(false);return this;}
	public ResponsibilityType orderByBaseDescription(boolean asc){
doAddOrderBy(BASE_DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createBaseDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(BASE_DESCRIPTION_PROPERTY, operator, parameters);
}
	public ResponsibilityType ignoreBaseDescriptionCriteria(){super.ignoreSearchProperty(BASE_DESCRIPTION_PROPERTY);
return this;
}
	public ResponsibilityType addBaseDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createBaseDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeBaseDescription(String baseDescription){
		if(baseDescription != null) { setBaseDescription(baseDescription);}
	}

	
	public void setDetailDescription(String detailDescription){String oldDetailDescription = this.detailDescription;String newDetailDescription = trimString(detailDescription);this.detailDescription = newDetailDescription;}
	public String detailDescription(){
doLoad();
return getDetailDescription();
}
	public String getDetailDescription(){
		return this.detailDescription;
	}
	public ResponsibilityType updateDetailDescription(String detailDescription){String oldDetailDescription = this.detailDescription;String newDetailDescription = trimString(detailDescription);if(!shouldReplaceBy(newDetailDescription, oldDetailDescription)){return this;}this.detailDescription = newDetailDescription;addPropertyChange(DETAIL_DESCRIPTION_PROPERTY, oldDetailDescription, newDetailDescription);this.changed = true;setChecked(false);return this;}
	public ResponsibilityType orderByDetailDescription(boolean asc){
doAddOrderBy(DETAIL_DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDetailDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DETAIL_DESCRIPTION_PROPERTY, operator, parameters);
}
	public ResponsibilityType ignoreDetailDescriptionCriteria(){super.ignoreSearchProperty(DETAIL_DESCRIPTION_PROPERTY);
return this;
}
	public ResponsibilityType addDetailDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDetailDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDetailDescription(String detailDescription){
		if(detailDescription != null) { setDetailDescription(detailDescription);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public ResponsibilityType updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public ResponsibilityType orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public ResponsibilityType ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public ResponsibilityType addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public  SmartList<Employee> getEmployeeList(){
		if(this.mEmployeeList == null){
			this.mEmployeeList = new SmartList<Employee>();
			this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );
			//有名字，便于做权限控制
		}

		return this.mEmployeeList;
	}

  public  SmartList<Employee> employeeList(){
    
    doLoadChild(EMPLOYEE_LIST);
    
    return getEmployeeList();
  }


	public  void setEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setResponsibleFor(this);
		}

		this.mEmployeeList = employeeList;
		this.mEmployeeList.setListInternalName (EMPLOYEE_LIST );

	}

	public  ResponsibilityType addEmployee(Employee employee){
		employee.setResponsibleFor(this);
		getEmployeeList().add(employee);
		return this;
	}
	public  ResponsibilityType addEmployeeList(SmartList<Employee> employeeList){
		for( Employee employee:employeeList){
			employee.setResponsibleFor(this);
		}
		getEmployeeList().addAll(employeeList);
		return this;
	}
	public  void mergeEmployeeList(SmartList<Employee> employeeList){
		if(employeeList==null){
			return;
		}
		if(employeeList.isEmpty()){
			return;
		}
		addEmployeeList( employeeList );

	}
	public  Employee removeEmployee(Employee employeeIndex){

		int index = getEmployeeList().indexOf(employeeIndex);
        if(index < 0){
        	String message = "Employee("+employeeIndex.getId()+") with version='"+employeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        Employee employee = getEmployeeList().get(index);
        // employee.clearResponsibleFor(); //disconnect with ResponsibleFor
        employee.clearFromAll(); //disconnect with ResponsibleFor

		boolean result = getEmployeeList().planToRemove(employee);
        if(!result){
        	String message = "Employee("+employeeIndex.getId()+") with version='"+employeeIndex.getVersion()+"' NOT found!";
            throw new IllegalStateException(message);
        }
        return employee;


	}
	//断舍离
	public  void breakWithEmployee(Employee employee){

		if(employee == null){
			return;
		}
		employee.setResponsibleFor(null);
		//getEmployeeList().remove();

	}

	public  boolean hasEmployee(Employee employee){

		return getEmployeeList().contains(employee);

	}

	public void copyEmployeeFrom(Employee employee) {

		Employee employeeInList = findTheEmployee(employee);
		Employee newEmployee = new Employee();
		employeeInList.copyTo(newEmployee);
		newEmployee.setVersion(0);//will trigger copy
		getEmployeeList().add(newEmployee);
		addItemToFlexiableObject(COPIED_CHILD, newEmployee);
	}

	public  Employee findTheEmployee(Employee employee){

		int index =  getEmployeeList().indexOf(employee);
		//The input parameter must have the same id and version number.
		if(index < 0){
 			String message = "Employee("+employee.getId()+") with version='"+employee.getVersion()+"' NOT found!";
			throw new IllegalStateException(message);
		}

		return  getEmployeeList().get(index);
		//Performance issue when using LinkedList, but it is almost an ArrayList for sure!
	}

	public  void cleanUpEmployeeList(){
		getEmployeeList().clear();
	}





	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getCompany(), internalType);


	}

	public List<BaseEntity>  collectRefercencesFromLists(String internalType){

		List<BaseEntity> entityList = new ArrayList<BaseEntity>();
		collectFromList(this, entityList, getEmployeeList(), internalType);

		return entityList;
	}

	public  List<SmartList<?>> getAllRelatedLists() {
		List<SmartList<?>> listOfList = new ArrayList<SmartList<?>>();

		listOfList.add( getEmployeeList());


		return listOfList;
	}


	public List<KeyValuePair> keyValuePairOf(){
		List<KeyValuePair> result =  super.keyValuePairOf();

		appendKeyValuePair(result, ID_PROPERTY, getId());
		appendKeyValuePair(result, CODE_PROPERTY, getCode());
		appendKeyValuePair(result, COMPANY_PROPERTY, getCompany());
		appendKeyValuePair(result, BASE_DESCRIPTION_PROPERTY, getBaseDescription());
		appendKeyValuePair(result, DETAIL_DESCRIPTION_PROPERTY, getDetailDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());
		appendKeyValuePair(result, EMPLOYEE_LIST, getEmployeeList());
		if(!getEmployeeList().isEmpty()){
			appendKeyValuePair(result, "employeeCount", getEmployeeList().getTotalCount());
			appendKeyValuePair(result, "employeeCurrentPageNumber", getEmployeeList().getCurrentPageNumber());
		}

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof ResponsibilityType){


			ResponsibilityType dest =(ResponsibilityType)baseDest;

			dest.setId(getId());
			dest.setCode(getCode());
			dest.setCompany(getCompany());
			dest.setBaseDescription(getBaseDescription());
			dest.setDetailDescription(getDetailDescription());
			dest.setVersion(getVersion());
			dest.setEmployeeList(getEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof ResponsibilityType){


			ResponsibilityType dest =(ResponsibilityType)baseDest;

			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeCompany(getCompany());
			dest.mergeBaseDescription(getBaseDescription());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());
			dest.mergeEmployeeList(getEmployeeList());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof ResponsibilityType){


			ResponsibilityType dest =(ResponsibilityType)baseDest;

			dest.mergeId(getId());
			dest.mergeCode(getCode());
			dest.mergeBaseDescription(getBaseDescription());
			dest.mergeDetailDescription(getDetailDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getCode(), getCompany(), getBaseDescription(), getDetailDescription(), getVersion()};
	}


	public static ResponsibilityType createWith(RetailscmUserContext userContext, ThrowingFunction<ResponsibilityType,ResponsibilityType,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<ResponsibilityType> customCreator = mapper.findCustomCreator(ResponsibilityType.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    ResponsibilityType result = new ResponsibilityType();
    result.setCode(mapper.tryToGet(ResponsibilityType.class, CODE_PROPERTY, String.class,
        0, false, result.getCode(), params));
    result.setCompany(mapper.tryToGet(ResponsibilityType.class, COMPANY_PROPERTY, RetailStoreCountryCenter.class,
        0, true, result.getCompany(), params));
    result.setBaseDescription(mapper.tryToGet(ResponsibilityType.class, BASE_DESCRIPTION_PROPERTY, String.class,
        1, false, result.getBaseDescription(), params));
    result.setDetailDescription(mapper.tryToGet(ResponsibilityType.class, DETAIL_DESCRIPTION_PROPERTY, String.class,
        2, false, result.getDetailDescription(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixResponsibilityType(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      ResponsibilityTypeTokens tokens = mapper.findParamByClass(params, ResponsibilityTypeTokens.class);
      if (tokens == null) {
        tokens = ResponsibilityTypeTokens.start();
      }
      result = userContext.getManagerGroup().getResponsibilityTypeManager().internalSaveResponsibilityType(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("ResponsibilityType{");
		stringBuilder.append("\tid='"+getId()+"';");
		stringBuilder.append("\tcode='"+getCode()+"';");
		if(getCompany() != null ){
 			stringBuilder.append("\tcompany='RetailStoreCountryCenter("+getCompany().getId()+")';");
 		}
		stringBuilder.append("\tbaseDescription='"+getBaseDescription()+"';");
		stringBuilder.append("\tdetailDescription='"+getDetailDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

