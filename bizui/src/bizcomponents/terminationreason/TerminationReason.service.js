
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}terminationReasonManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}terminationReasonManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}terminationReasonManager/loadTerminationReason/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}terminationReasonManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}terminationReasonManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}terminationReasonManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationReasonManager/addTermination/terminationReasonId/typeId/comment/tokensExpr/`
  const terminationReasonId = targetObjectId
  const requestParameters = { ...parameters, terminationReasonId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationReasonManager/updateTerminationProperties/terminationReasonId/id/comment/tokensExpr/`
  const terminationReasonId = targetObjectId
  const requestParameters = { ...parameters, terminationReasonId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTerminationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationReasonManager/removeTerminationList/terminationReasonId/terminationIds/tokensExpr/`
  const requestParameters = { ...parameters, terminationReasonId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}terminationReasonService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}terminationReasonService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}terminationReasonService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}terminationReasonService/process/`,
    data,
  })
}

const TerminationReasonService = { view,
  load,
  analyze,
  addTermination,
  updateTermination,
  removeTerminationList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default TerminationReasonService

