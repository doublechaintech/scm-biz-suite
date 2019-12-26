
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}offerApprovalManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}offerApprovalManager/loadOfferApproval/${targetObjectId}/${parametersExpr}/`,
  })
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}offerApprovalManager/addEmployee/offerApprovalId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/jobApplicationId/professionInterviewId/hrInterviewId/offerAcceptanceId/employeeBoardingId/terminationId/tokensExpr/`
  const offerApprovalId = targetObjectId
  const requestParameters = { ...parameters, offerApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}offerApprovalManager/updateEmployeeProperties/offerApprovalId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const offerApprovalId = targetObjectId
  const requestParameters = { ...parameters, offerApprovalId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}offerApprovalManager/removeEmployeeList/offerApprovalId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, offerApprovalId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}offerApprovalService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}offerApprovalService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}offerApprovalService/process/`,
    data,
  })
}

const OfferApprovalService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList, listFunctions, saveRequest, processRequest}
export default OfferApprovalService

