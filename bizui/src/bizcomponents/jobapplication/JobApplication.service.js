import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}jobApplicationManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}jobApplicationManager/loadJobApplication/${targetObjectId}/${parametersExpr}/`,
  })
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}jobApplicationManager/addEmployee/jobApplicationId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/tokensExpr/`
  const jobApplicationId = targetObjectId
  const requestParameters = { ...parameters, jobApplicationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}jobApplicationManager/updateEmployeeProperties/jobApplicationId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const jobApplicationId = targetObjectId
  const requestParameters = { ...parameters, jobApplicationId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}jobApplicationManager/removeEmployeeList/jobApplicationId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, jobApplicationId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const JobApplicationService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList }
export default JobApplicationService

