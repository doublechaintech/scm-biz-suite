import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}candidateContainerManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}candidateContainerManager/loadCandidateContainer/${targetObjectId}/${parametersExpr}/`,
  })
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


const CandidateContainerService = { view,
  load,
  addCandidateElement,
  updateCandidateElement,
  removeCandidateElementList }
export default CandidateContainerService

