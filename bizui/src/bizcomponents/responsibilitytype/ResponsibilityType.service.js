
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}responsibilityTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}responsibilityTypeManager/loadResponsibilityType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}responsibilityTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}responsibilityTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}responsibilityTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}responsibilityTypeManager/addEmployee/responsibilityTypeId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/currentSalaryGradeId/salaryAccount/tokensExpr/`
  const responsibilityTypeId = targetObjectId
  const requestParameters = { ...parameters, responsibilityTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}responsibilityTypeManager/updateEmployeeProperties/responsibilityTypeId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const responsibilityTypeId = targetObjectId
  const requestParameters = { ...parameters, responsibilityTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}responsibilityTypeManager/removeEmployeeList/responsibilityTypeId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, responsibilityTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}responsibilityTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}responsibilityTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}responsibilityTypeService/process/`,
    data,
  })
}

const ResponsibilityTypeService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest, processRequest, queryCandidates}
export default ResponsibilityTypeService

