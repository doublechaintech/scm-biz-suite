import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}occupationTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}occupationTypeManager/loadOccupationType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}occupationTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}occupationTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}occupationTypeManager/addEmployee/occupationTypeId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/responsibleForId/currentSalaryGradeId/salaryAccount/tokensExpr/`
  const occupationTypeId = targetObjectId
  const requestParameters = { ...parameters, occupationTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}occupationTypeManager/updateEmployeeProperties/occupationTypeId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const occupationTypeId = targetObjectId
  const requestParameters = { ...parameters, occupationTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}occupationTypeManager/removeEmployeeList/occupationTypeId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, occupationTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const OccupationTypeService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList,
  requestCandidateCompany,
  transferToAnotherCompany }
export default OccupationTypeService

