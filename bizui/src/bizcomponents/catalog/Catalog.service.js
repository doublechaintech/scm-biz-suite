import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}catalogManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}catalogManager/loadCatalog/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}catalogManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}catalogManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addLevelOneCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/addLevelOneCategory/catalogId/name/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateLevelOneCategory = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/updateLevelOneCategoryProperties/catalogId/id/name/tokensExpr/`
  const catalogId = targetObjectId
  const requestParameters = { ...parameters, catalogId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeLevelOneCategoryList = (targetObjectId, parameters) => {
  const url = `${PREFIX}catalogManager/removeLevelOneCategoryList/catalogId/levelOneCategoryIds/tokensExpr/`
  const requestParameters = { ...parameters, catalogId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const CatalogService = { view,
  load,
  addLevelOneCategory,
  updateLevelOneCategory,
  removeLevelOneCategoryList,
  requestCandidateOwner,
  transferToAnotherOwner }
export default CatalogService

