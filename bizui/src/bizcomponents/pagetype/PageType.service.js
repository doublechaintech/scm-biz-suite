
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}pageTypeManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}pageTypeManager/loadPageType/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateMobileApp = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}pageTypeManager/requestCandidateMobileApp/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherMobileApp = (id, parameters) => {
  const url = `${PREFIX}pageTypeManager/transferToAnotherMobileApp/id/anotherMobileAppId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addPage = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageTypeManager/addPage/pageTypeId/pageTitle/linkToUrl/mobileAppId/tokensExpr/`
  const pageTypeId = targetObjectId
  const requestParameters = { ...parameters, pageTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updatePage = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageTypeManager/updatePageProperties/pageTypeId/id/pageTitle/linkToUrl/tokensExpr/`
  const pageTypeId = targetObjectId
  const requestParameters = { ...parameters, pageTypeId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removePageList = (targetObjectId, parameters) => {
  const url = `${PREFIX}pageTypeManager/removePageList/pageTypeId/pageIds/tokensExpr/`
  const requestParameters = { ...parameters, pageTypeId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}pageTypeService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}pageTypeService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}pageTypeService/process/`,
    data,
  })
}

const PageTypeService = { view,
  load,
  addPage,
  updatePage,
  removePageList,
  requestCandidateMobileApp,
  transferToAnotherMobileApp, listFunctions, saveRequest, processRequest}
export default PageTypeService

