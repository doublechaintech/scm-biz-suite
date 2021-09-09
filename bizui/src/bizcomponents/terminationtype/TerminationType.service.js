
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}terminationTypeManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}terminationTypeManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}terminationTypeManager/loadTerminationType/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}terminationTypeManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCompany = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}terminationTypeManager/requestCandidateCompany/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCompany = (id, parameters) => {
  const url = `${PREFIX}terminationTypeManager/transferToAnotherCompany/id/anotherCompanyId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationTypeManager/addTermination/terminationTypeId/reasonId/comment/tokensExpr/`
  const terminationTypeId = targetObjectId
  const requestParameters = { ...parameters, terminationTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateTermination = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationTypeManager/updateTerminationProperties/terminationTypeId/id/comment/tokensExpr/`
  const terminationTypeId = targetObjectId
  const requestParameters = { ...parameters, terminationTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeTerminationList = (targetObjectId, parameters) => {
  const url = `${PREFIX}terminationTypeManager/removeTerminationList/terminationTypeId/terminationIds/tokensExpr/`
  const requestParameters = { ...parameters, terminationTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}terminationTypeService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}terminationTypeService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}terminationTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}terminationTypeService/process/`,
    data,
  })
}

const TerminationTypeService = { view,
  load,
  analyze,
  addTermination,
  updateTermination,
  removeTerminationList,
  requestCandidateCompany,
  transferToAnotherCompany, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default TerminationTypeService

