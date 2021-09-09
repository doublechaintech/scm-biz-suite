package com.doublechaintech.retailscm.payingoff;

import com.doublechaintech.retailscm.search.*;
import java.math.BigDecimal;
import java.util.Date;
import com.doublechaintech.retailscm.employee.Employee;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheet;
import com.doublechaintech.retailscm.employee.EmployeeRequest;
import com.doublechaintech.retailscm.employeesalarysheet.EmployeeSalarySheetRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.payingoff.PayingOff.*;

public class PayingOffRequest extends BaseRequest<PayingOff> {
    public static PayingOffRequest newInstance() {
        return new PayingOffRequest().selectId();
    }

    public String getInternalType() {
        return "PayingOff";
    }

    public PayingOffRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public PayingOffRequest select(String... names) {
        super.select(names);
        return this;
    }

    public PayingOffRequest selectAll() {return this.selectId().selectWho().selectPaidFor().selectPaidTime().selectAmount().selectVersion();
    }

    public PayingOffRequest selectSelf() {return this.selectId().selectWho().selectPaidTime().selectAmount().selectVersion();
    }

    public PayingOffRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public PayingOffRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static PayingOffRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public PayingOffRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public PayingOffRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PayingOffRequest selectId(){
          return select(ID_PROPERTY);
      }

      public PayingOffRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public PayingOffRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public PayingOffRequest filterByWho(String who) {
          
          if (who == null) {
              return this;
          }
          
          return filterByWho(QueryOperator.EQUAL, who);
      }
    

      public PayingOffRequest filterByWho(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getWhoSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PayingOffRequest selectWho(){
          return select(WHO_PROPERTY);
      }

      public PayingOffRequest unselectWho(){
          return unselect(WHO_PROPERTY);
      }

      public SearchCriteria getWhoSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(WHO_PROPERTY, pQueryOperator, parameters);
      }

      public PayingOffRequest orderByWho(boolean asc){
          addOrderBy(WHO_PROPERTY, asc);
          return this;
      }
   
      public PayingOffRequest filterByPaidTime(Date paidTime) {
          
          if (paidTime == null) {
              return this;
          }
          
          return filterByPaidTime(QueryOperator.EQUAL, paidTime);
      }
    

      public PayingOffRequest filterByPaidTime(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getPaidTimeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PayingOffRequest selectPaidTime(){
          return select(PAID_TIME_PROPERTY);
      }

      public PayingOffRequest unselectPaidTime(){
          return unselect(PAID_TIME_PROPERTY);
      }

      public SearchCriteria getPaidTimeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(PAID_TIME_PROPERTY, pQueryOperator, parameters);
      }

      public PayingOffRequest orderByPaidTime(boolean asc){
          addOrderBy(PAID_TIME_PROPERTY, asc);
          return this;
      }
   
      public PayingOffRequest filterByAmount(BigDecimal amount) {
          
          if (amount == null) {
              return this;
          }
          
          return filterByAmount(QueryOperator.EQUAL, amount);
      }
    

      public PayingOffRequest filterByAmount(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getAmountSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PayingOffRequest selectAmount(){
          return select(AMOUNT_PROPERTY);
      }

      public PayingOffRequest unselectAmount(){
          return unselect(AMOUNT_PROPERTY);
      }

      public SearchCriteria getAmountSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(AMOUNT_PROPERTY, pQueryOperator, parameters);
      }

      public PayingOffRequest orderByAmount(boolean asc){
          addOrderBy(AMOUNT_PROPERTY, asc);
          return this;
      }
   
      public PayingOffRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public PayingOffRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public PayingOffRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public PayingOffRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public PayingOffRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public PayingOffRequest filterByPaidFor(EmployeeRequest paidFor){
        return filterByPaidFor(paidFor, paidForList -> paidForList.stream().map(Employee::getId).collect(Collectors.toSet()));
    }

    public PayingOffRequest filterByPaidFor(EmployeeRequest paidFor, IDRefine<Employee> idRefine) {
        return addSearchCriteria(createPaidForCriteria(paidFor, idRefine));
    }

    public SearchCriteria createPaidForCriteria(EmployeeRequest paidFor, IDRefine<Employee> idRefine) {
        return new RefinedIdInCriteria(paidFor, PAID_FOR_PROPERTY, idRefine);
    }
    

    
    public PayingOffRequest selectPaidFor(){
        return selectPaidFor(EmployeeRequest.newInstance().selectSelf());
    }

    public PayingOffRequest selectPaidFor(EmployeeRequest paidFor){
        selectParent(PAID_FOR_PROPERTY, paidFor);
        return this;
    }
    

    public PayingOffRequest unselectPaidFor(){
        unselectParent(PAID_FOR_PROPERTY);
        return this;
    }

  


  

    public PayingOffRequest hasEmployeeSalarySheet() {
      return hasEmployeeSalarySheet(EmployeeSalarySheetRequest.newInstance());
    }

    public PayingOffRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet) {
        return hasEmployeeSalarySheet(employeeSalarySheet, employeeSalarySheetList -> employeeSalarySheetList.stream().map(EmployeeSalarySheet::getPayingOff).map(PayingOff::getId).collect(Collectors.toSet()));
    }

    public PayingOffRequest hasEmployeeSalarySheet(EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine) {
        employeeSalarySheet.select(EmployeeSalarySheet.PAYING_OFF_PROPERTY);
        return addSearchCriteria(createEmployeeSalarySheetCriteria(employeeSalarySheet, idRefine));
    }

    public SearchCriteria createEmployeeSalarySheetCriteria(EmployeeSalarySheetRequest employeeSalarySheet, IDRefine<EmployeeSalarySheet> idRefine){
       return new RefinedIdInCriteria(employeeSalarySheet, ID_PROPERTY, idRefine);
    }

    public PayingOffRequest selectEmployeeSalarySheetList(EmployeeSalarySheetRequest employeeSalarySheet) {
        selectChild(EmployeeSalarySheet.PAYING_OFF_PROPERTY, employeeSalarySheet);
        return this;
    }

    public PayingOffRequest selectEmployeeSalarySheetList() {
        return selectEmployeeSalarySheetList(EmployeeSalarySheetRequest.newInstance().selectAll());
    }

    public PayingOffRequest unselectEmployeeSalarySheetList(){
        unselectChild(EmployeeSalarySheet.PAYING_OFF_PROPERTY, EmployeeSalarySheet.class);
        return this;
    }
  

   public PayingOffRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

