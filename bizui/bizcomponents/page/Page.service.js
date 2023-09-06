
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}pageManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}pageManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}pageManager/loadPage/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}pageManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
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
  const url = `${PREFIX}pageManager/addSlide/pageId/name/displayOrder/imageUrl/videoUrl/linkToUrl/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSlide = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/updateSlideProperties/pageId/id/name/displayOrder/imageUrl/videoUrl/linkToUrl/tokensExpr/`
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
  const url = `${PREFIX}pageManager/addUiAction/pageId/code/icon/title/displayOrder/brief/imageUrl/linkToUrl/extraData/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateUiAction = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/updateUiActionProperties/pageId/id/code/icon/title/displayOrder/brief/imageUrl/linkToUrl/extraData/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeUiActionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/removeUiActionList/pageId/uiActionIds/tokensExpr/`
  const requestParameters = { ...parameters, pageId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addSection = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/addSection/pageId/title/brief/icon/displayOrder/viewGroup/linkToUrl/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateSection = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/updateSectionProperties/pageId/id/title/brief/icon/displayOrder/viewGroup/linkToUrl/tokensExpr/`
  const pageId = targetObjectId
  const requestParameters = { ...parameters, pageId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeSectionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageManager/removeSectionList/pageId/sectionIds/tokensExpr/`
  const requestParameters = { ...parameters, pageId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}pageService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}pageService/init/`,
    data,
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
  analyze,
  addSlide,
  addUiAction,
  addSection,
  updateSlide,
  updateUiAction,
  updateSection,
  removeSlideList,
  removeUiActionList,
  removeSectionList,
  requestCandidatePageType,
  requestCandidateMobileApp,
  transferToAnotherPageType,
  transferToAnotherMobileApp, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default PageService

