
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}secUserManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}secUserManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}secUserManager/loadSecUser/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}secUserManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
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







const addUserApp = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/addUserApp/secUserId/title/appIcon/fullAccess/permission/appType/appId/ctxType/ctxId/location/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserApp = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/updateUserAppProperties/secUserId/id/title/appIcon/fullAccess/permission/appType/appId/ctxType/ctxId/location/tokensExpr/`
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



const addWechatWorkappIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/addWechatWorkappIdentity/secUserId/corpId/userId/lastLoginTime/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateWechatWorkappIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/updateWechatWorkappIdentityProperties/secUserId/id/corpId/userId/lastLoginTime/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeWechatWorkappIdentityList = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/removeWechatWorkappIdentityList/secUserId/wechatWorkappIdentityIds/tokensExpr/`
  const requestParameters = { ...parameters, secUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addWechatMiniappIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/addWechatMiniappIdentity/secUserId/openId/appId/unionId/lastLoginTime/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateWechatMiniappIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/updateWechatMiniappIdentityProperties/secUserId/id/openId/appId/unionId/lastLoginTime/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeWechatMiniappIdentityList = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/removeWechatMiniappIdentityList/secUserId/wechatMiniappIdentityIds/tokensExpr/`
  const requestParameters = { ...parameters, secUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addKeyPairIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/addKeyPairIdentity/secUserId/publicKey/keyTypeId/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateKeyPairIdentity = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/updateKeyPairIdentityProperties/secUserId/id/publicKey/tokensExpr/`
  const secUserId = targetObjectId
  const requestParameters = { ...parameters, secUserId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeKeyPairIdentityList = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserManager/removeKeyPairIdentityList/secUserId/keyPairIdentityIds/tokensExpr/`
  const requestParameters = { ...parameters, secUserId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}secUserService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}secUserService/init/`,
    data,
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
  analyze,
  addUserApp,
  addLoginHistory,
  addWechatWorkappIdentity,
  addWechatMiniappIdentity,
  addKeyPairIdentity,
  updateUserApp,
  updateLoginHistory,
  updateWechatWorkappIdentity,
  updateWechatMiniappIdentity,
  updateKeyPairIdentity,
  removeUserAppList,
  removeLoginHistoryList,
  removeWechatWorkappIdentityList,
  removeWechatMiniappIdentityList,
  removeKeyPairIdentityList,
  requestCandidateDomain,
  transferToAnotherDomain, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default SecUserService

