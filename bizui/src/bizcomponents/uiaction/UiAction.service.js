
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}uiActionManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}uiActionManager/loadUiAction/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePage = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}uiActionManager/requestCandidatePage/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPage = (id, parameters) => {
  const url = `${PREFIX}uiActionManager/transferToAnotherPage/id/anotherPageId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}uiActionService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}uiActionService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}uiActionService/process/`,
    data,
  })
}

const UiActionService = { view,
  load,
  requestCandidatePage,
  transferToAnotherPage, listFunctions, saveRequest, processRequest}
export default UiActionService

