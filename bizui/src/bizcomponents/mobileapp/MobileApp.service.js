
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}mobileAppManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}mobileAppManager/loadMobileApp/${targetObjectId}/${parametersExpr}/`,
  })
}







const addPage = (targetObjectId, parameters) => {
  const url = `${PREFIX}mobileAppManager/addPage/mobileAppId/pageTitle/linkToUrl/pageTypeId/tokensExpr/`
  const mobileAppId = targetObjectId
  const requestParameters = { ...parameters, mobileAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePage = (targetObjectId, parameters) => {
  const url = `${PREFIX}mobileAppManager/updatePageProperties/mobileAppId/id/pageTitle/linkToUrl/tokensExpr/`
  const mobileAppId = targetObjectId
  const requestParameters = { ...parameters, mobileAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}mobileAppManager/removePageList/mobileAppId/pageIds/tokensExpr/`
  const requestParameters = { ...parameters, mobileAppId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addPageType = (targetObjectId, parameters) => {
  const url = `${PREFIX}mobileAppManager/addPageType/mobileAppId/name/code/footerTab/tokensExpr/`
  const mobileAppId = targetObjectId
  const requestParameters = { ...parameters, mobileAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePageType = (targetObjectId, parameters) => {
  const url = `${PREFIX}mobileAppManager/updatePageTypeProperties/mobileAppId/id/name/code/footerTab/tokensExpr/`
  const mobileAppId = targetObjectId
  const requestParameters = { ...parameters, mobileAppId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePageTypeList = (targetObjectId, parameters) => {
  const url = `${PREFIX}mobileAppManager/removePageTypeList/mobileAppId/pageTypeIds/tokensExpr/`
  const requestParameters = { ...parameters, mobileAppId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}mobileAppService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}mobileAppService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}mobileAppService/process/`,
    data,
  })
}

const MobileAppService = { view,
  load,
  addPage,
  addPageType,
  updatePage,
  updatePageType,
  removePageList,
  removePageTypeList, listFunctions, saveRequest, processRequest}
export default MobileAppService

