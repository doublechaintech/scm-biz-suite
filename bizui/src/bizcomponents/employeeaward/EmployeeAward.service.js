
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeAwardManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeAwardManager/loadEmployeeAward/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateEmployee = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeAwardManager/requestCandidateEmployee/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherEmployee = (id, parameters) => {
  const url = `${PREFIX}employeeAwardManager/transferToAnotherEmployee/id/anotherEmployeeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}employeeAwardService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}employeeAwardService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}employeeAwardService/process/`,
    data,
  })
}

const EmployeeAwardService = { view,
  load,
  requestCandidateEmployee,
  transferToAnotherEmployee, listFunctions, saveRequest, processRequest}
export default EmployeeAwardService

