
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

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


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}levelThreeCategoryManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateParentCategory = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}levelThreeCategoryManager/requestCandidateParentCategory/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherParentCategory = (id, parameters) => {
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



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}levelThreeCategoryService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}levelThreeCategoryService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}levelThreeCategoryService/process/`,
    data,
  })
}

const LevelThreeCategoryService = { view,
  load,
  addProduct,
  updateProduct,
  removeProductList,
  requestCandidateParentCategory,
  transferToAnotherParentCategory, listFunctions, saveRequest, processRequest, queryCandidates}
export default LevelThreeCategoryService

