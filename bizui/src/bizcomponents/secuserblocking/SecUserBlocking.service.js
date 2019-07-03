import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}secUserBlockingManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}secUserBlockingManager/loadSecUserBlocking/${targetObjectId}/${parametersExpr}/`,
  })
}







const addSecUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserBlockingManager/addSecUser/secUserBlockingId/login/mobile/email/pwd/weixinOpenid/weixinAppid/accessToken/verificationCode/verificationCodeExpire/lastLoginTime/domainId/tokensExpr/`
  const secUserBlockingId = targetObjectId
  const requestParameters = { ...parameters, secUserBlockingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSecUser = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserBlockingManager/updateSecUserProperties/secUserBlockingId/id/login/mobile/email/pwd/weixinOpenid/weixinAppid/accessToken/verificationCode/verificationCodeExpire/lastLoginTime/tokensExpr/`
  const secUserBlockingId = targetObjectId
  const requestParameters = { ...parameters, secUserBlockingId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSecUserList = (targetObjectId, parameters) => {
  const url = `${PREFIX}secUserBlockingManager/removeSecUserList/secUserBlockingId/secUserIds/tokensExpr/`
  const requestParameters = { ...parameters, secUserBlockingId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const SecUserBlockingService = { view,
  load,
  addSecUser,
  updateSecUser,
  removeSecUserList }
export default SecUserBlockingService

