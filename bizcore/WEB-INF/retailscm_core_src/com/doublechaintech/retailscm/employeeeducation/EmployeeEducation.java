
package com.doublechaintech.retailscm.employeeeducation;

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









@JsonSerialize(using = EmployeeEducationSerializer.class)
public class EmployeeEducation extends BaseEntity implements  java.io.Serializable{







	public static final String ID_PROPERTY                    = "id"                ;
	public static final String EMPLOYEE_PROPERTY              = "employee"          ;
	public static final String COMPLETE_TIME_PROPERTY         = "completeTime"      ;
	public static final String TYPE_PROPERTY                  = "type"              ;
	public static final String REMARK_PROPERTY                = "remark"            ;
	public static final String VERSION_PROPERTY               = "version"           ;


	public static final String INTERNAL_TYPE="EmployeeEducation";
	public String getInternalType(){
		return INTERNAL_TYPE;
	}


	protected static List<MemberMetaInfo> memberMetaInfoList = new ArrayList<>();
  static{
    memberMetaInfoList.add(MemberMetaInfo.defineBy(ID_PROPERTY, "id", "ID")
        .withType("id", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(EMPLOYEE_PROPERTY, "employee", "员工")
        .withType("employee", Employee.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(COMPLETE_TIME_PROPERTY, "complete_time", "完成时间")
        .withType("date", Date.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(TYPE_PROPERTY, "type", "类型")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(REMARK_PROPERTY, "remark", "备注")
        .withType("string", String.class));
    memberMetaInfoList.add(MemberMetaInfo.defineBy(VERSION_PROPERTY, "version", "版本")
        .withType("version", "int"));


  }

	public List<MemberMetaInfo> getMemberMetaInfoList(){return memberMetaInfoList;}


  public String[] getPropertyNames(){
    return new String[]{ID_PROPERTY ,EMPLOYEE_PROPERTY ,COMPLETE_TIME_PROPERTY ,TYPE_PROPERTY ,REMARK_PROPERTY ,VERSION_PROPERTY};
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

  public EmployeeEducation want(Class<? extends BaseEntity>... classes) {
      doWant(classes);
      return this;
    }

  public EmployeeEducation wants(Class<? extends BaseEntity>... classes) {
    doWants(classes);
    return this;
  }

	public String getDisplayName(){

		String displayName = getType();
		if(displayName!=null){
			return displayName;
		}

		return super.getDisplayName();

	}

	private static final long serialVersionUID = 1L;


	protected		String              	id                  ;
	protected		Employee            	employee            ;
	protected		Date                	completeTime        ;
	protected		String              	type                ;
	protected		String              	remark              ;
	protected		int                 	version             ;

	



	public 	EmployeeEducation(){
		// lazy load for all the properties
	}
	public 	static EmployeeEducation withId(String id){
		EmployeeEducation employeeEducation = new EmployeeEducation();
		employeeEducation.setId(id);
		employeeEducation.setVersion(Integer.MAX_VALUE);
		employeeEducation.setChecked(true);
		return employeeEducation;
	}
	public 	static EmployeeEducation refById(String id){
		return withId(id);
	}

  public EmployeeEducation limit(int count){
    doAddLimit(0, count);
    return this;
  }

  public EmployeeEducation limit(int start, int count){
    doAddLimit(start, count);
    return this;
  }

  public static EmployeeEducation searchExample(){
    EmployeeEducation employeeEducation = new EmployeeEducation();
    		employeeEducation.setVersion(UNSET_INT);

    return employeeEducation;
  }

	// disconnect from all, 中文就是一了百了，跟所有一切尘世断绝往来藏身于茫茫数据海洋
	public 	void clearFromAll(){
		setEmployee( null );

		this.changed = true;
		setChecked(false);
	}
	

	//Support for changing the property
	
	public void changeProperty(String property, String newValueExpr) {
     	
		if(COMPLETE_TIME_PROPERTY.equals(property)){
			changeCompleteTimeProperty(newValueExpr);
		}
		if(TYPE_PROPERTY.equals(property)){
			changeTypeProperty(newValueExpr);
		}
		if(REMARK_PROPERTY.equals(property)){
			changeRemarkProperty(newValueExpr);
		}

      
	}
    
    
	protected void changeCompleteTimeProperty(String newValueExpr){
	
		Date oldValue = getCompleteTime();
		Date newValue = parseDate(newValueExpr);
		if(equalsDate(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateCompleteTime(newValue);
		this.onChangeProperty(COMPLETE_TIME_PROPERTY, oldValue, newValue);
		return;
   
	}
			
			
			
	protected void changeTypeProperty(String newValueExpr){
	
		String oldValue = getType();
		String newValue = parseString(newValueExpr);
		if(equalsString(oldValue , newValue)){
			return;//they can be both null, or exact the same object, this is much faster than equals function
		}
		//they are surely different each other
		updateType(newValue);
		this.onChangeProperty(TYPE_PROPERTY, oldValue, newValue);
		return;
   
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
		if(COMPLETE_TIME_PROPERTY.equals(property)){
			return getCompleteTime();
		}
		if(TYPE_PROPERTY.equals(property)){
			return getType();
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
	public EmployeeEducation updateId(String id){String oldId = this.id;String newId = trimString(id);if(!shouldReplaceBy(newId, oldId)){return this;}this.id = newId;addPropertyChange(ID_PROPERTY, oldId, newId);this.changed = true;setChecked(false);return this;}
	public EmployeeEducation orderById(boolean asc){
doAddOrderBy(ID_PROPERTY, asc);
return this;
}
	public SearchCriteria createIdCriteria(QueryOperator operator, Object... parameters){
return createCriteria(ID_PROPERTY, operator, parameters);
}
	public EmployeeEducation ignoreIdCriteria(){super.ignoreSearchProperty(ID_PROPERTY);
return this;
}
	public EmployeeEducation addIdCriteria(QueryOperator operator, Object... parameters){
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
	public EmployeeEducation updateEmployee(Employee employee){Employee oldEmployee = this.employee;Employee newEmployee = employee;if(!shouldReplaceBy(newEmployee, oldEmployee)){return this;}this.employee = newEmployee;addPropertyChange(EMPLOYEE_PROPERTY, oldEmployee, newEmployee);this.changed = true;setChecked(false);return this;}
	public EmployeeEducation orderByEmployee(boolean asc){
doAddOrderBy(EMPLOYEE_PROPERTY, asc);
return this;
}
	public SearchCriteria createEmployeeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(EMPLOYEE_PROPERTY, operator, parameters);
}
	public EmployeeEducation ignoreEmployeeCriteria(){super.ignoreSearchProperty(EMPLOYEE_PROPERTY);
return this;
}
	public EmployeeEducation addEmployeeCriteria(QueryOperator operator, Object... parameters){
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
	
	public void setCompleteTime(Date completeTime){Date oldCompleteTime = this.completeTime;Date newCompleteTime = completeTime;this.completeTime = newCompleteTime;}
	public Date completeTime(){
doLoad();
return getCompleteTime();
}
	public Date getCompleteTime(){
		return this.completeTime;
	}
	public EmployeeEducation updateCompleteTime(Date completeTime){Date oldCompleteTime = this.completeTime;Date newCompleteTime = completeTime;if(!shouldReplaceBy(newCompleteTime, oldCompleteTime)){return this;}this.completeTime = newCompleteTime;addPropertyChange(COMPLETE_TIME_PROPERTY, oldCompleteTime, newCompleteTime);this.changed = true;setChecked(false);return this;}
	public EmployeeEducation orderByCompleteTime(boolean asc){
doAddOrderBy(COMPLETE_TIME_PROPERTY, asc);
return this;
}
	public SearchCriteria createCompleteTimeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(COMPLETE_TIME_PROPERTY, operator, parameters);
}
	public EmployeeEducation ignoreCompleteTimeCriteria(){super.ignoreSearchProperty(COMPLETE_TIME_PROPERTY);
return this;
}
	public EmployeeEducation addCompleteTimeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createCompleteTimeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeCompleteTime(Date completeTime){
		setCompleteTime(completeTime);
	}

	
	public void setType(String type){String oldType = this.type;String newType = trimString(type);this.type = newType;}
	public String type(){
doLoad();
return getType();
}
	public String getType(){
		return this.type;
	}
	public EmployeeEducation updateType(String type){String oldType = this.type;String newType = trimString(type);if(!shouldReplaceBy(newType, oldType)){return this;}this.type = newType;addPropertyChange(TYPE_PROPERTY, oldType, newType);this.changed = true;setChecked(false);return this;}
	public EmployeeEducation orderByType(boolean asc){
doAddOrderBy(TYPE_PROPERTY, asc);
return this;
}
	public SearchCriteria createTypeCriteria(QueryOperator operator, Object... parameters){
return createCriteria(TYPE_PROPERTY, operator, parameters);
}
	public EmployeeEducation ignoreTypeCriteria(){super.ignoreSearchProperty(TYPE_PROPERTY);
return this;
}
	public EmployeeEducation addTypeCriteria(QueryOperator operator, Object... parameters){
SearchCriteria criteria = createTypeCriteria(operator, parameters);
doAddCriteria(criteria);
return this;
}
	public void mergeType(String type){
		if(type != null) { setType(type);}
	}

	
	public void setRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);this.remark = newRemark;}
	public String remark(){
doLoad();
return getRemark();
}
	public String getRemark(){
		return this.remark;
	}
	public EmployeeEducation updateRemark(String remark){String oldRemark = this.remark;String newRemark = trimString(remark);if(!shouldReplaceBy(newRemark, oldRemark)){return this;}this.remark = newRemark;addPropertyChange(REMARK_PROPERTY, oldRemark, newRemark);this.changed = true;setChecked(false);return this;}
	public EmployeeEducation orderByRemark(boolean asc){
doAddOrderBy(REMARK_PROPERTY, asc);
return this;
}
	public SearchCriteria createRemarkCriteria(QueryOperator operator, Object... parameters){
return createCriteria(REMARK_PROPERTY, operator, parameters);
}
	public EmployeeEducation ignoreRemarkCriteria(){super.ignoreSearchProperty(REMARK_PROPERTY);
return this;
}
	public EmployeeEducation addRemarkCriteria(QueryOperator operator, Object... parameters){
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
	public EmployeeEducation updateVersion(int version){int oldVersion = this.version;int newVersion = version;if(!shouldReplaceBy(newVersion, oldVersion)){return this;}this.version = newVersion;addPropertyChange(VERSION_PROPERTY, oldVersion, newVersion);this.changed = true;setChecked(false);return this;}
	public EmployeeEducation orderByVersion(boolean asc){
doAddOrderBy(VERSION_PROPERTY, asc);
return this;
}
	public SearchCriteria createVersionCriteria(QueryOperator operator, Object... parameters){
return createCriteria(VERSION_PROPERTY, operator, parameters);
}
	public EmployeeEducation ignoreVersionCriteria(){super.ignoreSearchProperty(VERSION_PROPERTY);
return this;
}
	public EmployeeEducation addVersionCriteria(QueryOperator operator, Object... parameters){
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
		appendKeyValuePair(result, COMPLETE_TIME_PROPERTY, getCompleteTime());
		appendKeyValuePair(result, TYPE_PROPERTY, getType());
		appendKeyValuePair(result, REMARK_PROPERTY, getRemark());
		appendKeyValuePair(result, VERSION_PROPERTY, getVersion());

		if (this.valueByKey("valuesOfGroupBy") != null) {
			appendKeyValuePair(result, "valuesOfGroupBy", this.valueByKey("valuesOfGroupBy"));
		}
		return result;
	}


	public BaseEntity copyTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeEducation){


			EmployeeEducation dest =(EmployeeEducation)baseDest;

			dest.setId(getId());
			dest.setEmployee(getEmployee());
			dest.setCompleteTime(getCompleteTime());
			dest.setType(getType());
			dest.setRemark(getRemark());
			dest.setVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}
	public BaseEntity mergeDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeEducation){


			EmployeeEducation dest =(EmployeeEducation)baseDest;

			dest.mergeId(getId());
			dest.mergeEmployee(getEmployee());
			dest.mergeCompleteTime(getCompleteTime());
			dest.mergeType(getType());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		super.copyTo(baseDest);
		return baseDest;
	}

	public BaseEntity mergePrimitiveDataTo(BaseEntity baseDest){


		if(baseDest instanceof EmployeeEducation){


			EmployeeEducation dest =(EmployeeEducation)baseDest;

			dest.mergeId(getId());
			dest.mergeCompleteTime(getCompleteTime());
			dest.mergeType(getType());
			dest.mergeRemark(getRemark());
			dest.mergeVersion(getVersion());

		}
		return baseDest;
	}
	public Object[] toFlatArray(){
		return new Object[]{getId(), getEmployee(), getCompleteTime(), getType(), getRemark(), getVersion()};
	}


	public static EmployeeEducation createWith(RetailscmUserContext userContext, ThrowingFunction<EmployeeEducation,EmployeeEducation,Exception> postHandler, Object ... inputs) throws Exception {

    List<Object> params = inputs == null ? new ArrayList<>() : Arrays.asList(inputs);
    CustomRetailscmPropertyMapper mapper = CustomRetailscmPropertyMapper.of(userContext);
    CreationScene scene = mapper.findParamByClass(params, CreationScene.class);
    RetailscmBeanCreator<EmployeeEducation> customCreator = mapper.findCustomCreator(EmployeeEducation.class, scene);
    if (customCreator != null){
      return customCreator.create(userContext, scene, postHandler, params);
    }

    EmployeeEducation result = new EmployeeEducation();
    result.setEmployee(mapper.tryToGet(EmployeeEducation.class, EMPLOYEE_PROPERTY, Employee.class,
        0, true, result.getEmployee(), params));
    result.setCompleteTime(mapper.tryToGet(EmployeeEducation.class, COMPLETE_TIME_PROPERTY, Date.class,
        0, true, result.getCompleteTime(), params));
    result.setType(mapper.tryToGet(EmployeeEducation.class, TYPE_PROPERTY, String.class,
        0, false, result.getType(), params));
    result.setRemark(mapper.tryToGet(EmployeeEducation.class, REMARK_PROPERTY, String.class,
        1, false, result.getRemark(), params));

    if (postHandler != null) {
      result = postHandler.apply(result);
    }
    if (result != null){
      userContext.getChecker().checkAndFixEmployeeEducation(result);
      userContext.getChecker().throwExceptionIfHasErrors(IllegalArgumentException.class);

      
      EmployeeEducationTokens tokens = mapper.findParamByClass(params, EmployeeEducationTokens.class);
      if (tokens == null) {
        tokens = EmployeeEducationTokens.start();
      }
      result = userContext.getManagerGroup().getEmployeeEducationManager().internalSaveEmployeeEducation(userContext, result, tokens.done());
      
    }
    return result;
  }

	public String toString(){
		StringBuilder stringBuilder=new StringBuilder(128);

		stringBuilder.append("EmployeeEducation{");
		stringBuilder.append("\tid='"+getId()+"';");
		if(getEmployee() != null ){
 			stringBuilder.append("\temployee='Employee("+getEmployee().getId()+")';");
 		}
		stringBuilder.append("\tcompleteTime='"+getCompleteTime()+"';");
		stringBuilder.append("\ttype='"+getType()+"';");
		stringBuilder.append("\tremark='"+getRemark()+"';");
		stringBuilder.append("\tversion='"+getVersion()+"';");
		stringBuilder.append("}");

		return stringBuilder.toString();
	}

	//provide number calculation function
	

}

