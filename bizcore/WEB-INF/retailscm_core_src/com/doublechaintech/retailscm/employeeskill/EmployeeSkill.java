
package com.doublechaintech.retailscm.employeeskill;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.skilltype.SkillType;
import com.doublechaintech.retailscm.employee.Employee;









@JsonSerialize(using = EmployeeSkillSerializer.class)
public class EmployeeSkill extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String SKILL_TYPE_PROPERTY            = "skillType"         ;
	public static final String DESCRIPTION_PROPERTY           = "description"       ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeSkill";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EMPLOYEE_PROPERTY, "employee", "员工")
        .withType("employee", Employee.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(SKILL_TYPE_PROPERTY, "skill_type", "技能类型")
        .withType("skill_type", SkillType.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(DESCRIPTION_PROPERTY, "description", "描述")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,EMPLOYEE_PROPERTY ,SKILL_TYPE_PROPERTY ,DESCRIPTION_PROPERTY ,VERSION_PROPERTY};
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
    parents.put(EMPLOYEE_PROPERTY, Employee.class);
parents.put(SKILL_TYPE_PROPERTY, SkillType.class);

    return parents;
  }

  public EmployeeSkill want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeSkill wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getDescription();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		Employee            	employee            ;
	protected		SkillType           	skillType           ;
	protected		String              	description         ;
	protected		int                 	version             ;

	



	public 	EmployeeSkill(){
		// lazy load for all the properties
	}
	public 	static EmployeeSkill withId(String id){
		EmployeeSkill employeeSkill = new EmployeeSkill();
		employeeSkill.setId(id);
		employeeSkill.setVersion(Integer.MAX_VALUE);
		employeeSkill.setChecked(true);
		return employeeSkill;
	}
	public 	static EmployeeSkill refById(String id){
		return withId(id);
	}

  public EmployeeSkill limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public EmployeeSkill limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeSkill searchExample(){
    EmployeeSkill employeeSkill = new EmployeeSkill();
    		employeeSkill.setVersion(UNSET_INT);

    return employeeSkill;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );
		setSkillType( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(DESCRIPTION_PROPERTY.equals(property)){
			changeDescriptionProperty(newValueExpr);
		}

      
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
			
			
			


	
	public Object propertyOf(String property) {

		if(EMPLOYEE_PROPERTY.equals(property)){
			return getEmployee();
		}
		if(SKILL_TYPE_PROPERTY.equals(property)){
			return getSkillType();
		}
		if(DESCRIPTION_PROPERTY.equals(property)){
			return getDescription();
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
	public EmployeeSkill updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public EmployeeSkill orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public EmployeeSkill ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public EmployeeSkill addIdCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createIdCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeId(String id){
		if(id != null) { setId(id);}
	}

	
	public void setEmployee(Employee employee){Employee oldEmployee = this.employee;Employee newEmployee = employee;this.employee = newEmployee;}
	public Employee employee(){
doLoad();
return getEmployee();
}
	public Employee getEmployee(){
		return this.employee;
	}
	public EmployeeSkill updateEmployee(Employee employee){Employee oldEmployee = this.employee;Employee newEmployee = employee;if(!shouldReplaceBy(newEmployee, oldEmployee)){return this;}this.employee = newEmployee;addPropertyChange(EMPLOYEE_PROPERTY, oldEmployee, newEmployee);this.changed = true;setChecked(false);return this;}
	public EmployeeSkill orderByEmployee(boolean asc){
doAddOrderBy(EMPLOYEE_PROPERTY, asc);
return this;
}
	public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
}
	public EmployeeSkill ignoreEmployeeCriteria(){super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
return this;
}
	public EmployeeSkill addEmployeeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createEmployeeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeEmployee(Employee employee){
		if(employee != null) { setEmployee(employee);}
	}

	
	public void clearEmployee(){
		setEmployee ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setSkillType(SkillType skillType){SkillType oldSkillType = this.skillType;SkillType newSkillType = skillType;this.skillType = newSkillType;}
	public SkillType skillType(){
doLoad();
return getSkillType();
}
	public SkillType getSkillType(){
		return this.skillType;
	}
	public EmployeeSkill updateSkillType(SkillType skillType){SkillType oldSkillType = this.skillType;SkillType newSkillType = skillType;if(!shouldReplaceBy(newSkillType, oldSkillType)){return this;}this.skillType = newSkillType;addPropertyChange(SKILL_TYPE_PROPERTY, oldSkillType, newSkillType);this.changed = true;setChecked(false);return this;}
	public EmployeeSkill orderBySkillType(boolean asc){
doAddOrderBy(SKILL_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createSkillTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(SKILL_TYPE_PROPERTY, operator, parameters);
}
	public EmployeeSkill ignoreSkillTypeCriteria(){super.ignoreSearchProperty(SKILL_TYPE_PROPERTY);
return this;
}
	public EmployeeSkill addSkillTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createSkillTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeSkillType(SkillType skillType){
		if(skillType != null) { setSkillType(skillType);}
	}

	
	public void clearSkillType(){
		setSkillType ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);this.description = newDescription;}
	public String description(){
doLoad();
return getDescription();
}
	public String getDescription(){
		return this.description;
	}
	public EmployeeSkill updateDescription(String description){String oldDescription = this.description;String newDescription = trimString(description);if(!shouldReplaceBy(newDescription, oldDescription)){return this;}this.description = newDescription;addPropertyChange(DESCRIPTION_PROPERTY, oldDescription, newDescription);this.changed = true;setChecked(false);return this;}
	public EmployeeSkill orderByDescription(boolean asc){
doAddOrderBy(DESCRIPTION_PROPERTY, asc);
return this;
}
	public SearchCriteria createDescriptionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(DESCRIPTION_PROPERTY, operator, parameters);
}
	public EmployeeSkill ignoreDescriptionCriteria(){super.ignoreSearchProperty(DESCRIPTION_PROPERTY);
return this;
}
	public EmployeeSkill addDescriptionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createDescriptionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeDescription(String description){
		if(description != null) { setDescription(description);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public EmployeeSkill updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public EmployeeSkill orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public EmployeeSkill ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public EmployeeSkill addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEmployee(), internalType);
		addToEntityList(this, entityList, getSkillType(), internalType);


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
		appendKeyValuePair(result, EMPLOYEE_PROPERTY, getEmployee());
		appendKeyValuePair(result, SKILL_TYPE_PROPERTY, getSkillType());
		appendKeyValuePair(result, DESCRIPTION_PROPERTY, getDescription());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeSkill){


			EmployeeSkill dest =(EmployeeSkill)baseDest;

			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setSkillType(getSkillType());
			dest.setDescription(getDescription());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeSkill){


			EmployeeSkill dest =(EmployeeSkill)baseDest;

			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeSkillType(getSkillType());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeSkill){


			EmployeeSkill dest =(EmployeeSkill)baseDest;

			dest.mergeId(getId());
			dest.mergeDescription(getDescription());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getSkillType(), getDescription(), getVersion()};
	}


	public static EmployeeSkill createWith(RetailscmUserContext userContext, ThrowingFunction<EmployeeSkill,EmployeeSkill,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<EmployeeSkill> customCreator = mapper.findCustomCreator(EmployeeSkill.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    EmployeeSkill result = new EmployeeSkill();
    result.setEmployee(mapper.tryToGet(EmployeeSkill.class, EMPLOYEE_PROPERTY, Employee.class,
        0, true, result.getEmployee(), params));
    result.setSkillType(mapper.tryToGet(EmployeeSkill.class, SKILL_TYPE_PROPERTY, SkillType.class,
        0, true, result.getSkillType(), params));
    result.setDescription(mapper.tryToGet(EmployeeSkill.class, DESCRIPTION_PROPERTY, String.class,
        0, true, result.getDescription(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixEmployeeSkill(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      EmployeeSkillTokens tokens = mapper.findParamByClass(params, EmployeeSkillTokens.class);
      if (tokens == null) {
        tokens = EmployeeSkillTokens.start();
      }
      result = userContext.getManagerGroup().getEmployeeSkillManager().internalSaveEmployeeSkill(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeSkill{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		if(getSkillType() != null ){
 			stringBuilder.append("\tskillType='SkillType("+getSkillType().getId()+")';");
 		}
		stringBuilder.append("\tdescription='"+getDescription()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

