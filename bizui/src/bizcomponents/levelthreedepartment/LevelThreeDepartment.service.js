
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}levelThreeDepartmentManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}levelThreeDepartmentManager/loadLevelThreeDepartment/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBelongsTo = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelThreeDepartmentManager/requestCandidateBelongsTo/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBelongsTo = (id, parameters) => {
  const url = `${PREFIX}levelThreeDepartmentManager/transferToAnotherBelongsTo/id/anotherBelongsToId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelThreeDepartmentManager/addEmployee/levelThreeDepartmentId/companyId/title/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/tokensExpr/`
  const levelThreeDepartmentId = targetObjectId
  const requestParameters = { ...parameters, levelThreeDepartmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelThreeDepartmentManager/updateEmployeeProperties/levelThreeDepartmentId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const levelThreeDepartmentId = targetObjectId
  const requestParameters = { ...parameters, levelThreeDepartmentId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelThreeDepartmentManager/removeEmployeeList/levelThreeDepartmentId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, levelThreeDepartmentId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}levelThreeDepartmentService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}levelThreeDepartmentService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}levelThreeDepartmentService/process/`,
    data,
  })
}

const LevelThreeDepartmentService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList,
  requestCandidateBelongsTo,
  transferToAnotherBelongsTo, listFunctions, saveRequest, processRequest}
export default LevelThreeDepartmentService

