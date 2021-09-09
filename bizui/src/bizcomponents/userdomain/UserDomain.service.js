
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userDomainManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}userDomainManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userDomainManager/loadUserDomain/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}userDomainManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 






const addUserAllowList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/addUserAllowList/userDomainId/userIdentity/userSpecialFunctions/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserAllowList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/updateUserAllowListProperties/userDomainId/id/userIdentity/userSpecialFunctions/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserAllowListList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/removeUserAllowListList/userDomainId/userAllowListIds/tokensExpr/`
  const requestParameters = { ...parameters, userDomainId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSecUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/addSecUser/userDomainId/login/mobile/email/pwd/weixinOpenid/weixinAppid/accessToken/verificationCode/verificationCodeExpire/lastLoginTime/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSecUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/updateSecUserProperties/userDomainId/id/login/mobile/email/pwd/weixinOpenid/weixinAppid/accessToken/verificationCode/verificationCodeExpire/lastLoginTime/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSecUserList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/removeSecUserList/userDomainId/secUserIds/tokensExpr/`
  const requestParameters = { ...parameters, userDomainId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPublicKeyType = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/addPublicKeyType/userDomainId/keyAlg/signAlg/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePublicKeyType = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/updatePublicKeyTypeProperties/userDomainId/id/keyAlg/signAlg/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePublicKeyTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/removePublicKeyTypeList/userDomainId/publicKeyTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, userDomainId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}userDomainService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}userDomainService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}userDomainService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}userDomainService/process/`,
    data,
  })
}

const UserDomainService = { view,
  load,
  analyze,
  addUserAllowList,
  addSecUser,
  addPublicKeyType,
  updateUserAllowList,
  updateSecUser,
  updatePublicKeyType,
  removeUserAllowListList,
  removeSecUserList,
  removePublicKeyTypeList, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default UserDomainService

