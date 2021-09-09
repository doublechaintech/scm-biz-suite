package com.doublechaintech.retailscm.employeeleave;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.leavetype.LeaveType;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.leavetype.LeaveTypeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeleave.EmployeeLeave.*;

public class EmployeeLeaveRequest extends BaseRequest<EmployeeLeave> {
    public static EmployeeLeaveRequest newInstance() {
        return new EmployeeLeaveRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeLeave";
    }

    public EmployeeLeaveRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeLeaveRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeLeaveRequest selectAll() {return this.selectId().selectWho().selectType().selectLeaveDurationHour().selectRemark().selectVersion();
    }

    public EmployeeLeaveRequest selectSelf() {return this.selectId().selectLeaveDurationHour().selectRemark().selectVersion();
    }

    public EmployeeLeaveRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeLeaveRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeLeaveRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeLeaveRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeLeaveRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeLeaveRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeLeaveRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeLeaveRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeLeaveRequest filterByLeaveDurationHour(int leaveDurationHour) {
          
          return filterByLeaveDurationHour(QueryOperator.EQUAL, leaveDurationHour);
      }
    

      public EmployeeLeaveRequest filterByLeaveDurationHour(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLeaveDurationHourSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeLeaveRequest selectLeaveDurationHour(){
          return select(LEAVE_DURATION_HOUR_PROPERTY);
      }

      public EmployeeLeaveRequest unselectLeaveDurationHour(){
          return unselect(LEAVE_DURATION_HOUR_PROPERTY);
      }

      public SearchCriteria getLeaveDurationHourSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LEAVE_DURATION_HOUR_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeLeaveRequest orderByLeaveDurationHour(boolean asc){
          addOrderBy(LEAVE_DURATION_HOUR_PROPERTY, asc);
          return this;
      }
   
      public EmployeeLeaveRequest filterByRemark(String remark) {
          
          if (remark == null) {
              return this;
          }
          
          return filterByRemark(QueryOperator.EQUAL, remark);
      }
    

      public EmployeeLeaveRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeLeaveRequest selectRemark(){
          return select(REMARK_PROPERTY);
      }

      public EmployeeLeaveRequest unselectRemark(){
          return unselect(REMARK_PROPERTY);
      }

      public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeLeaveRequest orderByRemark(boolean asc){
          addOrderBy(REMARK_PROPERTY, asc);
          return this;
      }
   
      public EmployeeLeaveRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeLeaveRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeLeaveRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeLeaveRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeLeaveRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeLeaveRequest filterByWho(EmployeeRequest who){
        return filterByWho(who, whoList -> whoList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeLeaveRequest filterByWho(EmployeeRequest who, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createWhoCriteria(who, idRefine));
    }

    public SearchCriteria createWhoCriteria(EmployeeRequest who, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(who, WHO_PROPERTY, idRefine);
    }
    

    
    public EmployeeLeaveRequest selectWho(){
        return selectWho(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeLeaveRequest selectWho(EmployeeRequest who){
        selectParent(WHO_PROPERTY, who);
        return this;
    }
    

    public EmployeeLeaveRequest unselectWho(){
        unselectParent(WHO_PROPERTY);
        return this;
    }

  

    
    public EmployeeLeaveRequest filterByType(LeaveTypeRequest type){
        return filterByType(type, typeList -> typeList.stream().map(LeaveType::getId).collect(Collectors.toSet()));
    }

    public EmployeeLeaveRequest filterByType(LeaveTypeRequest type, IDRefine<LeaveType> idRefine) {
        return addSearchCriteria(createTypeCriteria(type, idRefine));
    }

    public SearchCriteria createTypeCriteria(LeaveTypeRequest type, IDRefine<LeaveType> idRefine) {
        return new RefinedIdInCriteria(type, TYPE_PROPERTY, idRefine);
    }
    

    
    public EmployeeLeaveRequest selectType(){
        return selectType(LeaveTypeRequest.newInstance().selectSelf());
    }

    public EmployeeLeaveRequest selectType(LeaveTypeRequest type){
        selectParent(TYPE_PROPERTY, type);
        return this;
    }
    

    public EmployeeLeaveRequest unselectType(){
        unselectParent(TYPE_PROPERTY);
        return this;
    }

  


  

   public EmployeeLeaveRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

