
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}secUserManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}secUserManager/loadSecUser/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateDomain = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}secUserManager/requestCandidateDomain/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherDomain = (id, parameters) => {
  const url = `${PREFIX}secUserManager/transferToAnotherDomain/id/anotherDomainId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateBlocking = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}secUserManager/requestCandidateBlocking/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBlocking = (id, parameters) => {
  const url = `${PREFIX}secUserManager/transferToAnotherBlocking/id/anotherBlockingId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addUserApp = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/addUserApp/secUserId/title/appIcon/fullAccess/permission/objectType/objectId/location/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserApp = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/updateUserAppProperties/secUserId/id/title/appIcon/fullAccess/permission/objectType/objectId/location/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAppList = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/removeUserAppList/secUserId/userAppIds/tokensExpr/`
  const requestParameters = { ...parameters, secUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addLoginHistory = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/addLoginHistory/secUserId/fromIp/description/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLoginHistory = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/updateLoginHistoryProperties/secUserId/id/fromIp/description/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLoginHistoryList = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/removeLoginHistoryList/secUserId/loginHistoryIds/tokensExpr/`
  const requestParameters = { ...parameters, secUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}secUserService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}secUserService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}secUserService/process/`,
    data,
  })
}

const SecUserService = { view,
  load,
  addUserApp,
  addLoginHistory,
  updateUserApp,
  updateLoginHistory,
  removeUserAppList,
  removeLoginHistoryList,
  requestCandidateDomain,
  requestCandidateBlocking,
  transferToAnotherDomain,
  transferToAnotherBlocking, listFunctions, saveRequest, processRequest}
export default SecUserService

