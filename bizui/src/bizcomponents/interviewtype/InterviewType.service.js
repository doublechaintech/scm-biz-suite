
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}interviewTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}interviewTypeManager/loadInterviewType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}interviewTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}interviewTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}interviewTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addEmployeeInterview = (targetObjectId, parameters) => {
  const url = `${PREFIX}interviewTypeManager/addEmployeeInterview/interviewTypeId/employeeId/remark/tokensExpr/`
  const interviewTypeId = targetObjectId
  const requestParameters = { ...parameters, interviewTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateEmployeeInterview = (targetObjectId, parameters) => {
  const url = `${PREFIX}interviewTypeManager/updateEmployeeInterviewProperties/interviewTypeId/id/remark/tokensExpr/`
  const interviewTypeId = targetObjectId
  const requestParameters = { ...parameters, interviewTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeEmployeeInterviewList = (targetObjectId, parameters) => {
  const url = `${PREFIX}interviewTypeManager/removeEmployeeInterviewList/interviewTypeId/employeeInterviewIds/tokensExpr/`
  const requestParameters = { ...parameters, interviewTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}interviewTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}interviewTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}interviewTypeService/process/`,
    data,
  })
}

const InterviewTypeService = { view,
  load,
  addEmployeeInterview,
  updateEmployeeInterview,
  removeEmployeeInterviewList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest, processRequest, queryCandidates}
export default InterviewTypeService

