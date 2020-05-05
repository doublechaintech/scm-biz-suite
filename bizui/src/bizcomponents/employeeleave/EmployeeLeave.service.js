
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}employeeLeaveManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}employeeLeaveManager/loadEmployeeLeave/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}employeeLeaveManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateWho = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeLeaveManager/requestCandidateWho/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherWho = (id, parameters) => {
  const url = `${PREFIX}employeeLeaveManager/transferToAnotherWho/id/anotherWhoId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}employeeLeaveManager/requestCandidateType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherType = (id, parameters) => {
  const url = `${PREFIX}employeeLeaveManager/transferToAnotherType/id/anotherTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}employeeLeaveService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}employeeLeaveService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}employeeLeaveService/process/`,
    data,
  })
}

const EmployeeLeaveService = { view,
  load,
  requestCandidateWho,
  requestCandidateType,
  transferToAnotherWho,
  transferToAnotherType, listFunctions, saveRequest, processRequest, queryCandidates}
export default EmployeeLeaveService

