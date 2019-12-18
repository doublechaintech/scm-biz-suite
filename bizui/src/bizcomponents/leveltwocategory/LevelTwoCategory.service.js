
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}levelTwoCategoryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}levelTwoCategoryManager/loadLevelTwoCategory/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelTwoCategoryManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  const url = `${PREFIX}levelTwoCategoryManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLevelThreeCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelTwoCategoryManager/addLevelThreeCategory/levelTwoCategoryId/name/tokensExpr/`
  const levelTwoCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelTwoCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLevelThreeCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelTwoCategoryManager/updateLevelThreeCategoryProperties/levelTwoCategoryId/id/name/tokensExpr/`
  const levelTwoCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelTwoCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLevelThreeCategoryList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelTwoCategoryManager/removeLevelThreeCategoryList/levelTwoCategoryId/levelThreeCategoryIds/tokensExpr/`
  const requestParameters = { ...parameters, levelTwoCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}levelTwoCategoryService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}levelTwoCategoryService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}levelTwoCategoryService/process/`,
    data,
  })
}

const LevelTwoCategoryService = { view,
  load,
  addLevelThreeCategory,
  updateLevelThreeCategory,
  removeLevelThreeCategoryList,
  requestCandidateParentCategory,
  transferToAnotherParentCategory, listFunctions, saveRequest, processRequest}
export default LevelTwoCategoryService

