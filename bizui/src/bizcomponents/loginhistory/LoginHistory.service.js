import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}loginHistoryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}loginHistoryManager/loadLoginHistory/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateSecUser = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}loginHistoryManager/requestCandidateSecUser/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSecUser = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}loginHistoryManager/transferToAnotherSecUser/id/anotherSecUserId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const LoginHistoryService = { view,
  load,
  requestCandidateSecUser,
  transferToAnotherSecUser }
export default LoginHistoryService

