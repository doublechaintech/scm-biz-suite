import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeSalarySheetManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeSalarySheetManager/loadEmployeeSalarySheet/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateEmployee = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSalarySheetManager/requestCandidateEmployee/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEmployee = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeSalarySheetManager/transferToAnotherEmployee/id/anotherEmployeeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateCurrentSalaryGrade = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSalarySheetManager/requestCandidateCurrentSalaryGrade/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCurrentSalaryGrade = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeSalarySheetManager/transferToAnotherCurrentSalaryGrade/id/anotherCurrentSalaryGradeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidatePayingOff = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeSalarySheetManager/requestCandidatePayingOff/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPayingOff = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}employeeSalarySheetManager/transferToAnotherPayingOff/id/anotherPayingOffId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const EmployeeSalarySheetService = { view,
  load,
  requestCandidateEmployee,
  requestCandidateCurrentSalaryGrade,
  requestCandidatePayingOff,
  transferToAnotherEmployee,
  transferToAnotherCurrentSalaryGrade,
  transferToAnotherPayingOff }
export default EmployeeSalarySheetService

