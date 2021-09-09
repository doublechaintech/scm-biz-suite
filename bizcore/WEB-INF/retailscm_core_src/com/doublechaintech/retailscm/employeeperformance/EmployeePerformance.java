
package com.doublechaintech.retailscm.employeeperformance;

import java.util.*;
import java.util.stream.Collectors;
import java.math.BigDecimal;
import com.terapico.caf.*;
import com.doublechaintech.retailscm.search.*;
import com.doublechaintech.retailscm.*;
import com.doublechaintech.retailscm.utils.*;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.terapico.caf.baseelement.MemberMetaInfo;
import com.doublechaintech.retailscm.employee.Employee;









@JsonSerialize(using = EmployeePerformanceSerializer.class)
public class EmployeePerformance extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String PERFORMANCE_COMMENT_PROPERTY   = "performanceComment";
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeePerformance";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EMPLOYEE_PROPERTY, "employee", "员工")
        .withType("employee", Employee.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(PERFORMANCE_COMMENT_PROPERTY, "performance_comment", "绩效评价")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,EMPLOYEE_PROPERTY ,PERFORMANCE_COMMENT_PROPERTY ,VERSION_PROPERTY};
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

    return parents;
  }

  public EmployeePerformance want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeePerformance wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getPerformanceComment();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		Employee            	employee            ;
	protected		String              	performanceComment  ;
	protected		int                 	version             ;

	



	public 	EmployeePerformance(){
		// lazy load for all the properties
	}
	public 	static EmployeePerformance withId(String id){
		EmployeePerformance employeePerformance = new EmployeePerformance();
		employeePerformance.setId(id);
		employeePerformance.setVersion(Integer.MAX_VALUE);
		employeePerformance.setChecked(true);
		return employeePerformance;
	}
	public 	static EmployeePerformance refById(String id){
		return withId(id);
	}

  public EmployeePerformance limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public EmployeePerformance limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static EmployeePerformance searchExample(){
    EmployeePerformance employeePerformance = new EmployeePerformance();
    		employeePerformance.setVersion(UNSET_INT);

    return employeePerformance;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			changePerformanceCommentProperty(newValueExpr);
		}

      
	}
    
    
	protected void changePerformanceCommentProperty(String newValueExpr){
	
		String oldValue = getPerformanceComment();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updatePerformanceComment(newValue);
		this.onChangeProperty(PERFORMANCE_COMMENT_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(EMPLOYEE_PROPERTY.equals(property)){
			return getEmployee();
		}
		if(PERFORMANCE_COMMENT_PROPERTY.equals(property)){
			return getPerformanceComment();
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
	public EmployeePerformance updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public EmployeePerformance orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public EmployeePerformance ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public EmployeePerformance addIdCriteria(QueryOperator operator, Object... parameters){
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
	public EmployeePerformance updateEmployee(Employee employee){Employee oldEmployee = this.employee;Employee newEmployee = employee;if(!shouldReplaceBy(newEmployee, oldEmployee)){return this;}this.employee = newEmployee;addPropertyChange(EMPLOYEE_PROPERTY, oldEmployee, newEmployee);this.changed = true;setChecked(false);return this;}
	public EmployeePerformance orderByEmployee(boolean asc){
doAddOrderBy(EMPLOYEE_PROPERTY, asc);
return this;
}
	public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
}
	public EmployeePerformance ignoreEmployeeCriteria(){super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
return this;
}
	public EmployeePerformance addEmployeeCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setPerformanceComment(String performanceComment){String oldPerformanceComment = this.performanceComment;String newPerformanceComment = trimString(performanceComment);this.performanceComment = newPerformanceComment;}
	public String performanceComment(){
doLoad();
return getPerformanceComment();
}
	public String getPerformanceComment(){
		return this.performanceComment;
	}
	public EmployeePerformance updatePerformanceComment(String performanceComment){String oldPerformanceComment = this.performanceComment;String newPerformanceComment = trimString(performanceComment);if(!shouldReplaceBy(newPerformanceComment, oldPerformanceComment)){return this;}this.performanceComment = newPerformanceComment;addPropertyChange(PERFORMANCE_COMMENT_PROPERTY, oldPerformanceComment, newPerformanceComment);this.changed = true;setChecked(false);return this;}
	public EmployeePerformance orderByPerformanceComment(boolean asc){
doAddOrderBy(PERFORMANCE_COMMENT_PROPERTY, asc);
return this;
}
	public SearchCriteria createPerformanceCommentCriteria(QueryOperator operator, Object... parameters){
return createCriteria(PERFORMANCE_COMMENT_PROPERTY, operator, parameters);
}
	public EmployeePerformance ignorePerformanceCommentCriteria(){super.ignoreSearchProperty(PERFORMANCE_COMMENT_PROPERTY);
return this;
}
	public EmployeePerformance addPerformanceCommentCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createPerformanceCommentCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergePerformanceComment(String performanceComment){
		if(performanceComment != null) { setPerformanceComment(performanceComment);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public EmployeePerformance updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public EmployeePerformance orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public EmployeePerformance ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public EmployeePerformance addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEmployee(), internalType);


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
		appendKeyValuePair(result, PERFORMANCE_COMMENT_PROPERTY, getPerformanceComment());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeePerformance){


			EmployeePerformance dest =(EmployeePerformance)baseDest;

			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setPerformanceComment(getPerformanceComment());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeePerformance){


			EmployeePerformance dest =(EmployeePerformance)baseDest;

			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergePerformanceComment(getPerformanceComment());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeePerformance){


			EmployeePerformance dest =(EmployeePerformance)baseDest;

			dest.mergeId(getId());
			dest.mergePerformanceComment(getPerformanceComment());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getPerformanceComment(), getVersion()};
	}


	public static EmployeePerformance createWith(RetailscmUserContext userContext, ThrowingFunction<EmployeePerformance,EmployeePerformance,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<EmployeePerformance> customCreator = mapper.findCustomCreator(EmployeePerformance.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    EmployeePerformance result = new EmployeePerformance();
    result.setEmployee(mapper.tryToGet(EmployeePerformance.class, EMPLOYEE_PROPERTY, Employee.class,
        0, true, result.getEmployee(), params));
    result.setPerformanceComment(mapper.tryToGet(EmployeePerformance.class, PERFORMANCE_COMMENT_PROPERTY, String.class,
        0, true, result.getPerformanceComment(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixEmployeePerformance(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      EmployeePerformanceTokens tokens = mapper.findParamByClass(params, EmployeePerformanceTokens.class);
      if (tokens == null) {
        tokens = EmployeePerformanceTokens.start();
      }
      result = userContext.getManagerGroup().getEmployeePerformanceManager().internalSaveEmployeePerformance(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeePerformance{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tperformanceComment='"+getPerformanceComment()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

