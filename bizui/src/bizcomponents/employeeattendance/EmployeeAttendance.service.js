
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeAttendanceManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeAttendanceManager/loadEmployeeAttendance/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateEmployee = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeAttendanceManager/requestCandidateEmployee/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEmployee = (id, parameters) => {
  const url = `${PREFIX}employeeAttendanceManager/transferToAnotherEmployee/id/anotherEmployeeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}employeeAttendanceService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}employeeAttendanceService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}employeeAttendanceService/process/`,
    data,
  })
}

const EmployeeAttendanceService = { view,
  load,
  requestCandidateEmployee,
  transferToAnotherEmployee, listFunctions, saveRequest, processRequest}
export default EmployeeAttendanceService

