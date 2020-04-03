
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}slideManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}slideManager/loadSlide/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidatePage = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}slideManager/requestCandidatePage/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherPage = (id, parameters) => {
  const url = `${PREFIX}slideManager/transferToAnotherPage/id/anotherPageId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}slideService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}slideService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}slideService/process/`,
    data,
  })
}

const SlideService = { view,
  load,
  requestCandidatePage,
  transferToAnotherPage, listFunctions, saveRequest, processRequest}
export default SlideService

