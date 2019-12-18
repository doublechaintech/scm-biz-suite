
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}offerAcceptanceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}offerAcceptanceManager/loadOfferAcceptance/${targetObjectId}/${parametersExpr}/`,
  })
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}offerAcceptanceManager/addEmployee/offerAcceptanceId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/jobApplicationId/professionInterviewId/hrInterviewId/offerApprovalId/employeeBoardingId/terminationId/tokensExpr/`
  const offerAcceptanceId = targetObjectId
  const requestParameters = { ...parameters, offerAcceptanceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}offerAcceptanceManager/updateEmployeeProperties/offerAcceptanceId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const offerAcceptanceId = targetObjectId
  const requestParameters = { ...parameters, offerAcceptanceId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}offerAcceptanceManager/removeEmployeeList/offerAcceptanceId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, offerAcceptanceId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}offerAcceptanceService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}offerAcceptanceService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}offerAcceptanceService/process/`,
    data,
  })
}

const OfferAcceptanceService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList, listFunctions, saveRequest, processRequest}
export default OfferAcceptanceService

