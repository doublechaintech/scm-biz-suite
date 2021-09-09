
package com.doublechaintech.retailscm.employeeinterview;

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
import com.doublechaintech.retailscm.interviewtype.InterviewType;









@JsonSerialize(using = EmployeeInterviewSerializer.class)
public class EmployeeInterview extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String INTERVIEW_TYPE_PROPERTY        = "interviewType"     ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeInterview";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EMPLOYEE_PROPERTY, "employee", "员工")
        .withType("employee", Employee.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(INTERVIEW_TYPE_PROPERTY, "interview_type", "面试类型")
        .withType("interview_type", InterviewType.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(REMARK_PROPERTY, "remark", "备注")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,EMPLOYEE_PROPERTY ,INTERVIEW_TYPE_PROPERTY ,REMARK_PROPERTY ,VERSION_PROPERTY};
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
parents.put(INTERVIEW_TYPE_PROPERTY, InterviewType.class);

    return parents;
  }

  public EmployeeInterview want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeInterview wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getRemark();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		Employee            	employee            ;
	protected		InterviewType       	interviewType       ;
	protected		String              	remark              ;
	protected		int                 	version             ;

	



	public 	EmployeeInterview(){
		// lazy load for all the properties
	}
	public 	static EmployeeInterview withId(String id){
		EmployeeInterview employeeInterview = new EmployeeInterview();
		employeeInterview.setId(id);
		employeeInterview.setVersion(Integer.MAX_VALUE);
		employeeInterview.setChecked(true);
		return employeeInterview;
	}
	public 	static EmployeeInterview refById(String id){
		return withId(id);
	}

  public EmployeeInterview limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public EmployeeInterview limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeInterview searchExample(){
    EmployeeInterview employeeInterview = new EmployeeInterview();
    		employeeInterview.setVersion(UNSET_INT);

    return employeeInterview;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );
		setInterviewType( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeRemarkProperty(String newValueExpr){
	
		String oldValue = getRemark();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateRemark(newValue);
		this.onChangeProperty(REMARK_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			


	
	public Object propertyOf(String property) {

		if(EMPLOYEE_PROPERTY.equals(property)){
			return getEmployee();
		}
		if(INTERVIEW_TYPE_PROPERTY.equals(property)){
			return getInterviewType();
		}
		if(REMARK_PROPERTY.equals(property)){
			return getRemark();
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
	public EmployeeInterview updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public EmployeeInterview orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public EmployeeInterview ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public EmployeeInterview addIdCriteria(QueryOperator operator, Object... parameters){
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
	public EmployeeInterview updateEmployee(Employee employee){Employee oldEmployee = this.employee;Employee newEmployee = employee;if(!shouldReplaceBy(newEmployee, oldEmployee)){return this;}this.employee = newEmployee;addPropertyChange(EMPLOYEE_PROPERTY, oldEmployee, newEmployee);this.changed = true;setChecked(false);return this;}
	public EmployeeInterview orderByEmployee(boolean asc){
doAddOrderBy(EMPLOYEE_PROPERTY, asc);
return this;
}
	public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
}
	public EmployeeInterview ignoreEmployeeCriteria(){super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
return this;
}
	public EmployeeInterview addEmployeeCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setInterviewType(InterviewType interviewType){InterviewType oldInterviewType = this.interviewType;InterviewType newInterviewType = interviewType;this.interviewType = newInterviewType;}
	public InterviewType interviewType(){
doLoad();
return getInterviewType();
}
	public InterviewType getInterviewType(){
		return this.interviewType;
	}
	public EmployeeInterview updateInterviewType(InterviewType interviewType){InterviewType oldInterviewType = this.interviewType;InterviewType newInterviewType = interviewType;if(!shouldReplaceBy(newInterviewType, oldInterviewType)){return this;}this.interviewType = newInterviewType;addPropertyChange(INTERVIEW_TYPE_PROPERTY, oldInterviewType, newInterviewType);this.changed = true;setChecked(false);return this;}
	public EmployeeInterview orderByInterviewType(boolean asc){
doAddOrderBy(INTERVIEW_TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createInterviewTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(INTERVIEW_TYPE_PROPERTY, operator, parameters);
}
	public EmployeeInterview ignoreInterviewTypeCriteria(){super.ignoreSearchProperty(INTERVIEW_TYPE_PROPERTY);
return this;
}
	public EmployeeInterview addInterviewTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createInterviewTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeInterviewType(InterviewType interviewType){
		if(interviewType != null) { setInterviewType(interviewType);}
	}

	
	public void clearInterviewType(){
		setInterviewType ( null );
		this.changed = true;
		setChecked(false);
	}
	
	public void setRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);this.remark = newRemark;}
	public String remark(){
doLoad();
return getRemark();
}
	public String getRemark(){
		return this.remark;
	}
	public EmployeeInterview updateRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);if(!shouldReplaceBy(newRemark, oldRemark)){return this;}this.remark = newRemark;addPropertyChange(REMARK_PROPERTY, oldRemark, newRemark);this.changed = true;setChecked(false);return this;}
	public EmployeeInterview orderByRemark(boolean asc){
doAddOrderBy(REMARK_PROPERTY, asc);
return this;
}
	public SearchCriteria createRemarkCriteria(QueryOperator operator, Object... parameters){
return createCriteria(REMARK_PROPERTY, operator, parameters);
}
	public EmployeeInterview ignoreRemarkCriteria(){super.ignoreSearchProperty(REMARK_PROPERTY);
return this;
}
	public EmployeeInterview addRemarkCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createRemarkCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeRemark(String remark){
		if(remark != null) { setRemark(remark);}
	}

	
	public void setVersion(int version){int oldVersion = this.version;int newVersion = version;this.version = newVersion;}
	public int version(){
doLoad();
return getVersion();
}
	public int getVersion(){
		return this.version;
	}
	public EmployeeInterview updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public EmployeeInterview orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public EmployeeInterview ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public EmployeeInterview addVersionCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createVersionCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeVersion(int version){
		setVersion(version);
	}

	

	public void collectRefercences(BaseEntity owner, List<BaseEntity> entityList, String internalType){

		addToEntityList(this, entityList, getEmployee(), internalType);
		addToEntityList(this, entityList, getInterviewType(), internalType);


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
		appendKeyValuePair(result, INTERVIEW_TYPE_PROPERTY, getInterviewType());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeInterview){


			EmployeeInterview dest =(EmployeeInterview)baseDest;

			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setInterviewType(getInterviewType());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeInterview){


			EmployeeInterview dest =(EmployeeInterview)baseDest;

			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeInterviewType(getInterviewType());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeInterview){


			EmployeeInterview dest =(EmployeeInterview)baseDest;

			dest.mergeId(getId());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getInterviewType(), getRemark(), getVersion()};
	}


	public static EmployeeInterview createWith(RetailscmUserContext userContext, ThrowingFunction<EmployeeInterview,EmployeeInterview,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<EmployeeInterview> customCreator = mapper.findCustomCreator(EmployeeInterview.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    EmployeeInterview result = new EmployeeInterview();
    result.setEmployee(mapper.tryToGet(EmployeeInterview.class, EMPLOYEE_PROPERTY, Employee.class,
        0, true, result.getEmployee(), params));
    result.setInterviewType(mapper.tryToGet(EmployeeInterview.class, INTERVIEW_TYPE_PROPERTY, InterviewType.class,
        0, true, result.getInterviewType(), params));
    result.setRemark(mapper.tryToGet(EmployeeInterview.class, REMARK_PROPERTY, String.class,
        0, true, result.getRemark(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixEmployeeInterview(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      EmployeeInterviewTokens tokens = mapper.findParamByClass(params, EmployeeInterviewTokens.class);
      if (tokens == null) {
        tokens = EmployeeInterviewTokens.start();
      }
      result = userContext.getManagerGroup().getEmployeeInterviewManager().internalSaveEmployeeInterview(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeInterview{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		if(getInterviewType() != null ){
 			stringBuilder.append("\tinterviewType='InterviewType("+getInterviewType().getId()+")';");
 		}
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

