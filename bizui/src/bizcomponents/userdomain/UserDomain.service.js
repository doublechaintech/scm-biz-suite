import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}userDomainManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}userDomainManager/loadUserDomain/${targetObjectId}/${parametersExpr}/`,
  })
}







const addUserWhiteList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/addUserWhiteList/userDomainId/userIdentity/userSpecialFunctions/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUserWhiteList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/updateUserWhiteListProperties/userDomainId/id/userIdentity/userSpecialFunctions/tokensExpr/`
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUserWhiteListList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/removeUserWhiteListList/userDomainId/userWhiteListIds/tokensExpr/`
  const requestParameters = { ...parameters, userDomainId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSecUser = (targetObjectId, parameters) => {
<<<<<<< HEAD
  const url = `${PREFIX}userDomainManager/addSecUser/userDomainId/login/mobile/email/pwd/verificationCode/verificationCodeExpire/lastLoginTime/tokensExpr/`
=======
  const url = `${PREFIX}userDomainManager/addSecUser/userDomainId/login/mobile/email/pwd/weixinOpenid/weixinAppid/accessToken/verificationCode/verificationCodeExpire/lastLoginTime/tokensExpr/`
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSecUser = (targetObjectId, parameters) => {
<<<<<<< HEAD
  const url = `${PREFIX}userDomainManager/updateSecUserProperties/userDomainId/id/login/mobile/email/pwd/verificationCode/verificationCodeExpire/lastLoginTime/tokensExpr/`
=======
  const url = `${PREFIX}userDomainManager/updateSecUserProperties/userDomainId/id/login/mobile/email/pwd/weixinOpenid/weixinAppid/accessToken/verificationCode/verificationCodeExpire/lastLoginTime/tokensExpr/`
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  const userDomainId = targetObjectId
  const requestParameters = { ...parameters, userDomainId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSecUserList = (targetObjectId, parameters) => {
  const url = `${PREFIX}userDomainManager/removeSecUserList/userDomainId/secUserIds/tokensExpr/`
  const requestParameters = { ...parameters, userDomainId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const UserDomainService = { view,
  load,
  addUserWhiteList,
  addSecUser,
  updateUserWhiteList,
  updateSecUser,
  removeUserWhiteListList,
  removeSecUserList }
export default UserDomainService

