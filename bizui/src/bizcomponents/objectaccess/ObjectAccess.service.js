
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}objectAccessManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}objectAccessManager/loadObjectAccess/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateApp = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}objectAccessManager/requestCandidateApp/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherApp = (id, parameters) => {
  const url = `${PREFIX}objectAccessManager/transferToAnotherApp/id/anotherAppId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}objectAccessService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}objectAccessService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}objectAccessService/process/`,
    data,
  })
}

const ObjectAccessService = { view,
  load,
  requestCandidateApp,
  transferToAnotherApp, listFunctions, saveRequest, processRequest}
export default ObjectAccessService

