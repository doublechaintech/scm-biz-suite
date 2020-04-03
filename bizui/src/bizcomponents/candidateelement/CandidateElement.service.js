
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}candidateElementManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}candidateElementManager/loadCandidateElement/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateContainer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}candidateElementManager/requestCandidateContainer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherContainer = (id, parameters) => {
  const url = `${PREFIX}candidateElementManager/transferToAnotherContainer/id/anotherContainerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}candidateElementService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}candidateElementService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}candidateElementService/process/`,
    data,
  })
}

const CandidateElementService = { view,
  load,
  requestCandidateContainer,
  transferToAnotherContainer, listFunctions, saveRequest, processRequest}
export default CandidateElementService

