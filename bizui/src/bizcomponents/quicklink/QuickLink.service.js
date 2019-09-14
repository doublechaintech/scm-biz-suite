import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}quickLinkManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}quickLinkManager/loadQuickLink/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateApp = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}quickLinkManager/requestCandidateApp/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherApp = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}quickLinkManager/transferToAnotherApp/id/anotherAppId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






const QuickLinkService = { view,
  load,
  requestCandidateApp,
  transferToAnotherApp }
export default QuickLinkService

