package com.doublechaintech.retailscm.employeeinterview;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.interviewtype.InterviewType;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.interviewtype.InterviewTypeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeinterview.EmployeeInterview.*;

public class EmployeeInterviewRequest extends BaseRequest<EmployeeInterview> {
    public static EmployeeInterviewRequest newInstance() {
        return new EmployeeInterviewRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeInterview";
    }

    public EmployeeInterviewRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeInterviewRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeInterviewRequest selectAll() {return this.selectId().selectEmployee().selectInterviewType().selectRemark().selectVersion();
    }

    public EmployeeInterviewRequest selectSelf() {return this.selectId().selectRemark().selectVersion();
    }

    public EmployeeInterviewRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeInterviewRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeInterviewRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeInterviewRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeInterviewRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeInterviewRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeInterviewRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeInterviewRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeInterviewRequest filterByRemark(String remark) {
          
          if (remark == null) {
              return this;
          }
          
          return filterByRemark(QueryOperator.EQUAL, remark);
      }
    

      public EmployeeInterviewRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeInterviewRequest selectRemark(){
          return select(REMARK_PROPERTY);
      }

      public EmployeeInterviewRequest unselectRemark(){
          return unselect(REMARK_PROPERTY);
      }

      public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeInterviewRequest orderByRemark(boolean asc){
          addOrderBy(REMARK_PROPERTY, asc);
          return this;
      }
   
      public EmployeeInterviewRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeInterviewRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeInterviewRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeInterviewRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeInterviewRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeInterviewRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeInterviewRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeInterviewRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeInterviewRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeInterviewRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  

    
    public EmployeeInterviewRequest filterByInterviewType(InterviewTypeRequest interviewType){
        return filterByInterviewType(interviewType, interviewTypeList -> interviewTypeList.stream().map(InterviewType::getId).collect(Collectors.toSet()));
    }

    public EmployeeInterviewRequest filterByInterviewType(InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine) {
        return addSearchCriteria(createInterviewTypeCriteria(interviewType, idRefine));
    }

    public SearchCriteria createInterviewTypeCriteria(InterviewTypeRequest interviewType, IDRefine<InterviewType> idRefine) {
        return new RefinedIdInCriteria(interviewType, INTERVIEW_TYPE_PROPERTY, idRefine);
    }
    

    
    public EmployeeInterviewRequest selectInterviewType(){
        return selectInterviewType(InterviewTypeRequest.newInstance().selectSelf());
    }

    public EmployeeInterviewRequest selectInterviewType(InterviewTypeRequest interviewType){
        selectParent(INTERVIEW_TYPE_PROPERTY, interviewType);
        return this;
    }
    

    public EmployeeInterviewRequest unselectInterviewType(){
        unselectParent(INTERVIEW_TYPE_PROPERTY);
        return this;
    }

  


  

   public EmployeeInterviewRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

