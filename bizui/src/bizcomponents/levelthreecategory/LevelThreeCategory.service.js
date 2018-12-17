import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}levelThreeCategoryManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}levelThreeCategoryManager/loadLevelThreeCategory/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelThreeCategoryManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
  const url = `${PREFIX}levelThreeCategoryManager/transferToAnotherParentCategory/id/anotherParentCategoryId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelThreeCategoryManager/addProduct/levelThreeCategoryId/name/origin/remark/brand/picture/tokensExpr/`
  const levelThreeCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelThreeCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelThreeCategoryManager/updateProductProperties/levelThreeCategoryId/id/name/origin/remark/brand/picture/tokensExpr/`
  const levelThreeCategoryId = targetObjectId
  const requestParameters = { ...parameters, levelThreeCategoryId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}levelThreeCategoryManager/removeProductList/levelThreeCategoryId/productIds/tokensExpr/`
  const requestParameters = { ...parameters, levelThreeCategoryId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}


const LevelThreeCategoryService = { view,
  load,
  addProduct,
  updateProduct,
  removeProductList,
  requestCandidateParentCategory,
  transferToAnotherParentCategory }
export default LevelThreeCategoryService

