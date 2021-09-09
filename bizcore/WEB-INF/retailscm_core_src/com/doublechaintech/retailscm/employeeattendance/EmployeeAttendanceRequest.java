package com.doublechaintech.retailscm.employeeattendance;

import com.doublechaintech.retailscm.search.*;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.employeeattendance.EmployeeAttendance.*;

public class EmployeeAttendanceRequest extends BaseRequest<EmployeeAttendance> {
    public static EmployeeAttendanceRequest newInstance() {
        return new EmployeeAttendanceRequest().selectId();
    }

    public String getInternalType() {
        return "EmployeeAttendance";
    }

    public EmployeeAttendanceRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public EmployeeAttendanceRequest select(String... names) {
        super.select(names);
        return this;
    }

    public EmployeeAttendanceRequest selectAll() {return this.selectId().selectEmployee().selectEnterTime().selectLeaveTime().selectDurationHours().selectRemark().selectVersion();
    }

    public EmployeeAttendanceRequest selectSelf() {return this.selectId().selectEnterTime().selectLeaveTime().selectDurationHours().selectRemark().selectVersion();
    }

    public EmployeeAttendanceRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public EmployeeAttendanceRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static EmployeeAttendanceRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public EmployeeAttendanceRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public EmployeeAttendanceRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAttendanceRequest selectId(){
          return select(ID_PROPERTY);
      }

      public EmployeeAttendanceRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAttendanceRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAttendanceRequest filterByEnterTime(Date enterTime) {
          
          if (enterTime == null) {
              return this;
          }
          
          return filterByEnterTime(QueryOperator.EQUAL, enterTime);
      }
    

      public EmployeeAttendanceRequest filterByEnterTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getEnterTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAttendanceRequest selectEnterTime(){
          return select(ENTER_TIME_PROPERTY);
      }

      public EmployeeAttendanceRequest unselectEnterTime(){
          return unselect(ENTER_TIME_PROPERTY);
      }

      public SearchCriteria getEnterTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ENTER_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAttendanceRequest orderByEnterTime(boolean asc){
          addOrderBy(ENTER_TIME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAttendanceRequest filterByLeaveTime(Date leaveTime) {
          
          if (leaveTime == null) {
              return this;
          }
          
          return filterByLeaveTime(QueryOperator.EQUAL, leaveTime);
      }
    

      public EmployeeAttendanceRequest filterByLeaveTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getLeaveTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAttendanceRequest selectLeaveTime(){
          return select(LEAVE_TIME_PROPERTY);
      }

      public EmployeeAttendanceRequest unselectLeaveTime(){
          return unselect(LEAVE_TIME_PROPERTY);
      }

      public SearchCriteria getLeaveTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(LEAVE_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAttendanceRequest orderByLeaveTime(boolean asc){
          addOrderBy(LEAVE_TIME_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAttendanceRequest filterByDurationHours(int durationHours) {
          
          return filterByDurationHours(QueryOperator.EQUAL, durationHours);
      }
    

      public EmployeeAttendanceRequest filterByDurationHours(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDurationHoursSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAttendanceRequest selectDurationHours(){
          return select(DURATION_HOURS_PROPERTY);
      }

      public EmployeeAttendanceRequest unselectDurationHours(){
          return unselect(DURATION_HOURS_PROPERTY);
      }

      public SearchCriteria getDurationHoursSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DURATION_HOURS_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAttendanceRequest orderByDurationHours(boolean asc){
          addOrderBy(DURATION_HOURS_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAttendanceRequest filterByRemark(String remark) {
          
          if (remark == null) {
              return this;
          }
          
          return filterByRemark(QueryOperator.EQUAL, remark);
      }
    

      public EmployeeAttendanceRequest filterByRemark(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getRemarkSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAttendanceRequest selectRemark(){
          return select(REMARK_PROPERTY);
      }

      public EmployeeAttendanceRequest unselectRemark(){
          return unselect(REMARK_PROPERTY);
      }

      public SearchCriteria getRemarkSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(REMARK_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAttendanceRequest orderByRemark(boolean asc){
          addOrderBy(REMARK_PROPERTY, asc);
          return this;
      }
   
      public EmployeeAttendanceRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public EmployeeAttendanceRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public EmployeeAttendanceRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public EmployeeAttendanceRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public EmployeeAttendanceRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public EmployeeAttendanceRequest filterByEmployee(EmployeeRequest employee){
        return filterByEmployee(employee, employeeList -> employeeList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public EmployeeAttendanceRequest filterByEmployee(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createEmployeeCriteria(employee, idRefine));
    }

    public SearchCriteria createEmployeeCriteria(EmployeeRequest employee, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(employee, EMPLOYEE_PROPERTY, idRefine);
    }
    

    
    public EmployeeAttendanceRequest selectEmployee(){
        return selectEmployee(EmployeeRequest.newInstance().selectSelf());
    }

    public EmployeeAttendanceRequest selectEmployee(EmployeeRequest employee){
        selectParent(EMPLOYEE_PROPERTY, employee);
        return this;
    }
    

    public EmployeeAttendanceRequest unselectEmployee(){
        unselectParent(EMPLOYEE_PROPERTY);
        return this;
    }

  


  

   public EmployeeAttendanceRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

