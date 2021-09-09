
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}provinceCenterEmployeeManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}provinceCenterEmployeeManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}provinceCenterEmployeeManager/loadProvinceCenterEmployee/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}provinceCenterEmployeeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateDepartment = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}provinceCenterEmployeeManager/requestCandidateDepartment/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDepartment = (id, parameters) => {
  const url = `${PREFIX}provinceCenterEmployeeManager/transferToAnotherDepartment/id/anotherDepartmentId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateProvinceCenter = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}provinceCenterEmployeeManager/requestCandidateProvinceCenter/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherProvinceCenter = (id, parameters) => {
  const url = `${PREFIX}provinceCenterEmployeeManager/transferToAnotherProvinceCenter/id/anotherProvinceCenterId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}provinceCenterEmployeeService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}provinceCenterEmployeeService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}provinceCenterEmployeeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}provinceCenterEmployeeService/process/`,
    data,
  })
}

const ProvinceCenterEmployeeService = { view,
  load,
  analyze,
  requestCandidateDepartment,
  requestCandidateProvinceCenter,
  transferToAnotherDepartment,
  transferToAnotherProvinceCenter, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default ProvinceCenterEmployeeService

