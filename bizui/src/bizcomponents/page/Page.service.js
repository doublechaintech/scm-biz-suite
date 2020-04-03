
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}pageManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}pageManager/loadPage/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePageType = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}pageManager/requestCandidatePageType/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPageType = (id, parameters) => {
  const url = `${PREFIX}pageManager/transferToAnotherPageType/id/anotherPageTypeId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateMobileApp = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}pageManager/requestCandidateMobileApp/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherMobileApp = (id, parameters) => {
  const url = `${PREFIX}pageManager/transferToAnotherMobileApp/id/anotherMobileAppId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addSlide = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/addSlide/pageId/displayOrder/name/imageUrl/videoUrl/linkToUrl/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSlide = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/updateSlideProperties/pageId/id/displayOrder/name/imageUrl/videoUrl/linkToUrl/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSlideList = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/removeSlideList/pageId/slideIds/tokensExpr/`
  const requestParameters = { ...parameters, pageId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addUiAction = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/addUiAction/pageId/code/icon/title/brief/imageUrl/linkToUrl/extraData/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUiAction = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/updateUiActionProperties/pageId/id/code/icon/title/brief/imageUrl/linkToUrl/extraData/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUiActionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/removeUiActionList/pageId/uiActionIds/tokensExpr/`
  const requestParameters = { ...parameters, pageId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}pageService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}pageService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}pageService/process/`,
    data,
  })
}

const PageService = { view,
  load,
  addSlide,
  addUiAction,
  updateSlide,
  updateUiAction,
  removeSlideList,
  removeUiActionList,
  requestCandidatePageType,
  requestCandidateMobileApp,
  transferToAnotherPageType,
  transferToAnotherMobileApp, listFunctions, saveRequest, processRequest}
export default PageService

