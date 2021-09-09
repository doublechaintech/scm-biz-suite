package com.doublechaintech.retailscm.skilltype;

import com.doublechaintech.retailscm.search.*;

import com.doublechaintech.retailscm.employeeskill.EmployeeSkill;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenter;
import com.doublechaintech.retailscm.employeeskill.EmployeeSkillRequest;
import com.doublechaintech.retailscm.retailstorecountrycenter.RetailStoreCountryCenterRequest;
import java.util.stream.Collectors;
import static com.doublechaintech.retailscm.skilltype.SkillType.*;

public class SkillTypeRequest extends BaseRequest<SkillType> {
    public static SkillTypeRequest newInstance() {
        return new SkillTypeRequest().selectId();
    }

    public String getInternalType() {
        return "SkillType";
    }

    public SkillTypeRequest addSearchCriteria(SearchCriteria pSearchCriteria) {
        doAddSearchCriteria(pSearchCriteria);
        return this;
    }

    public SkillTypeRequest select(String... names) {
        super.select(names);
        return this;
    }

    public SkillTypeRequest selectAll() {return this.selectId().selectCode().selectCompany().selectDescription().selectVersion();
    }

    public SkillTypeRequest selectSelf() {return this.selectId().selectCode().selectDescription().selectVersion();
    }

    public SkillTypeRequest unselect(String... names) {
      super.unselect(names);
      return this;
    }

    public SkillTypeRequest where(String property, QueryOperator pQueryOperator, Object... pValue){
      return addSearchCriteria(new SimplePropertyCriteria(property, pQueryOperator, pValue));
    }

   
     public static SkillTypeRequest withId(String id) {
          return newInstance().filterById(id).selectAll();
     }
   

    
      public SkillTypeRequest filterById(String id) {
          
          if (id == null) {
              return this;
          }
          
          return filterById(QueryOperator.EQUAL, id);
      }
    

      public SkillTypeRequest filterById(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getIdSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkillTypeRequest selectId(){
          return select(ID_PROPERTY);
      }

      public SkillTypeRequest unselectId(){
          return unselect(ID_PROPERTY);
      }

      public SearchCriteria getIdSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(ID_PROPERTY, pQueryOperator, parameters);
      }

      public SkillTypeRequest orderById(boolean asc){
          addOrderBy(ID_PROPERTY, asc);
          return this;
      }
   
      public SkillTypeRequest filterByCode(String code) {
          
          if (code == null) {
              return this;
          }
          
          return filterByCode(QueryOperator.EQUAL, code);
      }
    

      public SkillTypeRequest filterByCode(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getCodeSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkillTypeRequest selectCode(){
          return select(CODE_PROPERTY);
      }

      public SkillTypeRequest unselectCode(){
          return unselect(CODE_PROPERTY);
      }

      public SearchCriteria getCodeSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(CODE_PROPERTY, pQueryOperator, parameters);
      }

      public SkillTypeRequest orderByCode(boolean asc){
          addOrderBy(CODE_PROPERTY, asc);
          return this;
      }
   
      public SkillTypeRequest filterByDescription(String description) {
          
          if (description == null) {
              return this;
          }
          
          return filterByDescription(QueryOperator.EQUAL, description);
      }
    

      public SkillTypeRequest filterByDescription(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getDescriptionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkillTypeRequest selectDescription(){
          return select(DESCRIPTION_PROPERTY);
      }

      public SkillTypeRequest unselectDescription(){
          return unselect(DESCRIPTION_PROPERTY);
      }

      public SearchCriteria getDescriptionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(DESCRIPTION_PROPERTY, pQueryOperator, parameters);
      }

      public SkillTypeRequest orderByDescription(boolean asc){
          addOrderBy(DESCRIPTION_PROPERTY, asc);
          return this;
      }
   
      public SkillTypeRequest filterByVersion(int version) {
          
          return filterByVersion(QueryOperator.EQUAL, version);
      }
    

      public SkillTypeRequest filterByVersion(QueryOperator pQueryOperator, Object... parameters) {
          SearchCriteria searchCriteria = getVersionSearchCriteria(pQueryOperator, parameters);
          return addSearchCriteria(searchCriteria);
      }


      public SkillTypeRequest selectVersion(){
          return select(VERSION_PROPERTY);
      }

      public SkillTypeRequest unselectVersion(){
          return unselect(VERSION_PROPERTY);
      }

      public SearchCriteria getVersionSearchCriteria(QueryOperator pQueryOperator, Object[] parameters) {
          return new SimplePropertyCriteria(VERSION_PROPERTY, pQueryOperator, parameters);
      }

      public SkillTypeRequest orderByVersion(boolean asc){
          addOrderBy(VERSION_PROPERTY, asc);
          return this;
      }
   


  

    
    public SkillTypeRequest filterByCompany(RetailStoreCountryCenterRequest company){
        return filterByCompany(company, companyList -> companyList.stream().map(RetailStoreCountryCenter::getId).collect(Collectors.toSet()));
    }

    public SkillTypeRequest filterByCompany(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return addSearchCriteria(createCompanyCriteria(company, idRefine));
    }

    public SearchCriteria createCompanyCriteria(RetailStoreCountryCenterRequest company, IDRefine<RetailStoreCountryCenter> idRefine) {
        return new RefinedIdInCriteria(company, COMPANY_PROPERTY, idRefine);
    }
    

    
    public SkillTypeRequest selectCompany(){
        return selectCompany(RetailStoreCountryCenterRequest.newInstance().selectSelf());
    }

    public SkillTypeRequest selectCompany(RetailStoreCountryCenterRequest company){
        selectParent(COMPANY_PROPERTY, company);
        return this;
    }
    

    public SkillTypeRequest unselectCompany(){
        unselectParent(COMPANY_PROPERTY);
        return this;
    }

  


  

    public SkillTypeRequest hasEmployeeSkill() {
      return hasEmployeeSkill(EmployeeSkillRequest.newInstance());
    }

    public SkillTypeRequest hasEmployeeSkill(EmployeeSkillRequest employeeSkill) {
        return hasEmployeeSkill(employeeSkill, employeeSkillList -> employeeSkillList.stream().map(EmployeeSkill::getSkillType).map(SkillType::getId).collect(Collectors.toSet()));
    }

    public SkillTypeRequest hasEmployeeSkill(EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine) {
        employeeSkill.select(EmployeeSkill.SKILL_TYPE_PROPERTY);
        return addSearchCriteria(createEmployeeSkillCriteria(employeeSkill, idRefine));
    }

    public SearchCriteria createEmployeeSkillCriteria(EmployeeSkillRequest employeeSkill, IDRefine<EmployeeSkill> idRefine){
       return new RefinedIdInCriteria(employeeSkill, ID_PROPERTY, idRefine);
    }

    public SkillTypeRequest selectEmployeeSkillList(EmployeeSkillRequest employeeSkill) {
        selectChild(EmployeeSkill.SKILL_TYPE_PROPERTY, employeeSkill);
        return this;
    }

    public SkillTypeRequest selectEmployeeSkillList() {
        return selectEmployeeSkillList(EmployeeSkillRequest.newInstance().selectAll());
    }

    public SkillTypeRequest unselectEmployeeSkillList(){
        unselectChild(EmployeeSkill.SKILL_TYPE_PROPERTY, EmployeeSkill.class);
        return this;
    }
  

   public SkillTypeRequest limit(int start, int size){
       setOffset(start);
       setSize(size);
       return this;
   }
}

