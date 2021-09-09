
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}candidateContainerManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}candidateContainerManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}candidateContainerManager/loadCandidateContainer/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}candidateContainerManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addCandidateElement = (targetObjectId, parameters) => {
  const url = `${PREFIX}candidateContainerManager/addCandidateElement/candidateContainerId/name/type/image/tokensExpr/`
  const candidateContainerId = targetObjectId
  const requestParameters = { ...parameters, candidateContainerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateCandidateElement = (targetObjectId, parameters) => {
  const url = `${PREFIX}candidateContainerManager/updateCandidateElementProperties/candidateContainerId/id/name/type/image/tokensExpr/`
  const candidateContainerId = targetObjectId
  const requestParameters = { ...parameters, candidateContainerId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeCandidateElementList = (targetObjectId, parameters) => {
  const url = `${PREFIX}candidateContainerManager/removeCandidateElementList/candidateContainerId/candidateElementIds/tokensExpr/`
  const requestParameters = { ...parameters, candidateContainerId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}candidateContainerService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}candidateContainerService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}candidateContainerService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}candidateContainerService/process/`,
    data,
  })
}

const CandidateContainerService = { view,
  load,
  analyze,
  addCandidateElement,
  updateCandidateElement,
  removeCandidateElementList, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default CandidateContainerService

