import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeBoardingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeBoardingManager/loadEmployeeBoarding/${targetObjectId}/${parametersExpr}/`,
  })
}







const addEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeBoardingManager/addEmployee/employeeBoardingId/companyId/title/departmentId/familyName/givenName/email/city/address/cellPhone/occupationId/responsibleForId/currentSalaryGradeId/salaryAccount/tokensExpr/`
  const employeeBoardingId = targetObjectId
  const requestParameters = { ...parameters, employeeBoardingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployee = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeBoardingManager/updateEmployeeProperties/employeeBoardingId/id/title/familyName/givenName/email/city/address/cellPhone/salaryAccount/tokensExpr/`
  const employeeBoardingId = targetObjectId
  const requestParameters = { ...parameters, employeeBoardingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}employeeBoardingManager/removeEmployeeList/employeeBoardingId/employeeIds/tokensExpr/`
  const requestParameters = { ...parameters, employeeBoardingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const EmployeeBoardingService = { view,
  load,
  addEmployee,
  updateEmployee,
  removeEmployeeList }
export default EmployeeBoardingService

