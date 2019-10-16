import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


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
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}candidateElementManager/transferToAnotherContainer/id/anotherContainerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const CandidateElementService = { view,
  load,
  requestCandidateContainer,
  transferToAnotherContainer }
export default CandidateElementService










