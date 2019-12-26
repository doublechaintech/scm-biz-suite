<<<<<<< HEAD
import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

=======

import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

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
<<<<<<< HEAD
  //const parametersExpr = joinParameters(parameters)
=======
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  const url = `${PREFIX}quickLinkManager/transferToAnotherApp/id/anotherAppId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}






<<<<<<< HEAD
const QuickLinkService = { view,
  load,
  requestCandidateApp,
  transferToAnotherApp }
=======

// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}quickLinkService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}quickLinkService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}quickLinkService/process/`,
    data,
  })
}

const QuickLinkService = { view,
  load,
  requestCandidateApp,
  transferToAnotherApp, listFunctions, saveRequest, processRequest}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default QuickLinkService

