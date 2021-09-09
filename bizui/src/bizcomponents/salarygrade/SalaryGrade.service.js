
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}salaryGradeManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}salaryGradeManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}salaryGradeManager/loadSalaryGrade/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}salaryGradeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}salaryGradeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}salaryGradeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}salaryGradeManager/addEmployee/salaryGradeId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/salaryAccount/tokensExpr/`
  const salaryGradeId = targetObjectId
  const requestParameters = { ...parameters, salaryGradeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}salaryGradeManager/updateEmployeeProperties/salaryGradeId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const salaryGradeId = targetObjectId
  const requestParameters = { ...parameters, salaryGradeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}salaryGradeManager/removeEmployeeList/salaryGradeId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, salaryGradeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addEmployeeSalarySheet = (targetObjectId, parameters) => {
  const url = `${PREFIX}salaryGradeManager/addEmployeeSalarySheet/salaryGradeId/employeeId/baseSalary/bonus/reward/personalTax/socialSecurity/housingFound/jobInsurance/payingOffId/tokensExpr/`
  const salaryGradeId = targetObjectId
  const requestParameters = { ...parameters, salaryGradeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeSalarySheet = (targetObjectId, parameters) => {
  const url = `${PREFIX}salaryGradeManager/updateEmployeeSalarySheetProperties/salaryGradeId/id/baseSalary/bonus/reward/personalTax/socialSecurity/housingFound/jobInsurance/tokensExpr/`
  const salaryGradeId = targetObjectId
  const requestParameters = { ...parameters, salaryGradeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeSalarySheetList = (targetObjectId, parameters) => {
  const url = `${PREFIX}salaryGradeManager/removeEmployeeSalarySheetList/salaryGradeId/employeeSalarySheetIds/tokensExpr/`
  const requestParameters = { ...parameters, salaryGradeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}salaryGradeService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}salaryGradeService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}salaryGradeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}salaryGradeService/process/`,
    data,
  })
}

const SalaryGradeService = { view,
  load,
  analyze,
  addEmployee,
  addEmployeeSalarySheet,
  updateEmployee,
  updateEmployeeSalarySheet,
  removeEmployeeList,
  removeEmployeeSalarySheetList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default SalaryGradeService

