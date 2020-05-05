
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}levelOneCategoryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}levelOneCategoryManager/loadLevelOneCategory/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}levelOneCategoryManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateCatalog = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelOneCategoryManager/requestCandidateCatalog/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherCatalog = (id, parameters) => {
  const url = `${PREFIX}levelOneCategoryManager/transferToAnotherCatalog/id/anotherCatalogId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLevelTwoCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelOneCategoryManager/addLevelTwoCategory/levelOneCategoryId/name/tokensExpr/`
  const levelOneCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelOneCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLevelTwoCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelOneCategoryManager/updateLevelTwoCategoryProperties/levelOneCategoryId/id/name/tokensExpr/`
  const levelOneCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelOneCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLevelTwoCategoryList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelOneCategoryManager/removeLevelTwoCategoryList/levelOneCategoryId/levelTwoCategoryIds/tokensExpr/`
  const requestParameters = { ...parameters, levelOneCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}levelOneCategoryService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}levelOneCategoryService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}levelOneCategoryService/process/`,
    data,
  })
}

const LevelOneCategoryService = { view,
  load,
  addLevelTwoCategory,
  updateLevelTwoCategory,
  removeLevelTwoCategoryList,
  requestCandidateCatalog,
  transferToAnotherCatalog, listFunctions, saveRequest, processRequest, queryCandidates}
export default LevelOneCategoryService

