
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}professionInterviewManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}professionInterviewManager/loadProfessionInterview/${targetObjectId}/${parametersExpr}/`,
  })
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}professionInterviewManager/addEmployee/professionInterviewId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/jobApplicationId/hrInterviewId/offerApprovalId/offerAcceptanceId/employeeBoardingId/terminationId/tokensExpr/`
  const professionInterviewId = targetObjectId
  const requestParameters = { ...parameters, professionInterviewId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}professionInterviewManager/updateEmployeeProperties/professionInterviewId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const professionInterviewId = targetObjectId
  const requestParameters = { ...parameters, professionInterviewId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}professionInterviewManager/removeEmployeeList/professionInterviewId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, professionInterviewId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}professionInterviewService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}professionInterviewService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}professionInterviewService/process/`,
    data,
  })
}

const ProfessionInterviewService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList, listFunctions, saveRequest, processRequest}
export default ProfessionInterviewService

