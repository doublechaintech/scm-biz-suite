<<<<<<< HEAD
import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

=======

import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

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
<<<<<<< HEAD
  //const parametersExpr = joinParameters(parameters)
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  const url = `${PREFIX}candidateElementManager/transferToAnotherContainer/id/anotherContainerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






<<<<<<< HEAD
const CandidateElementService = { view,
  load,
  requestCandidateContainer,
  transferToAnotherContainer }
=======

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default CandidateElementService










