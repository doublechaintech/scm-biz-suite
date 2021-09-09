
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}leaveTypeManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}leaveTypeManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}leaveTypeManager/loadLeaveType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}leaveTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}leaveTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}leaveTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployeeLeave = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveTypeManager/addEmployeeLeave/leaveTypeId/whoId/leaveDurationHour/remark/tokensExpr/`
  const leaveTypeId = targetObjectId
  const requestParameters = { ...parameters, leaveTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeLeave = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveTypeManager/updateEmployeeLeaveProperties/leaveTypeId/id/leaveDurationHour/remark/tokensExpr/`
  const leaveTypeId = targetObjectId
  const requestParameters = { ...parameters, leaveTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeLeaveList = (targetObjectId, parameters) => {
  const url = `${PREFIX}leaveTypeManager/removeEmployeeLeaveList/leaveTypeId/employeeLeaveIds/tokensExpr/`
  const requestParameters = { ...parameters, leaveTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}leaveTypeService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}leaveTypeService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}leaveTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}leaveTypeService/process/`,
    data,
  })
}

const LeaveTypeService = { view,
  load,
  analyze,
  addEmployeeLeave,
  updateEmployeeLeave,
  removeEmployeeLeaveList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default LeaveTypeService

