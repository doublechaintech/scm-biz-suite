
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}memberWishlistManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}memberWishlistManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}memberWishlistManager/loadMemberWishlist/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}memberWishlistManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}memberWishlistManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  const url = `${PREFIX}memberWishlistManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addMemberWishlistProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}memberWishlistManager/addMemberWishlistProduct/memberWishlistId/name/tokensExpr/`
  const memberWishlistId = targetObjectId
  const requestParameters = { ...parameters, memberWishlistId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMemberWishlistProduct = (targetObjectId, parameters) => {
  const url = `${PREFIX}memberWishlistManager/updateMemberWishlistProductProperties/memberWishlistId/id/name/tokensExpr/`
  const memberWishlistId = targetObjectId
  const requestParameters = { ...parameters, memberWishlistId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMemberWishlistProductList = (targetObjectId, parameters) => {
  const url = `${PREFIX}memberWishlistManager/removeMemberWishlistProductList/memberWishlistId/memberWishlistProductIds/tokensExpr/`
  const requestParameters = { ...parameters, memberWishlistId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}memberWishlistService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}memberWishlistService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}memberWishlistService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}memberWishlistService/process/`,
    data,
  })
}

const MemberWishlistService = { view,
  load,
  analyze,
  addMemberWishlistProduct,
  updateMemberWishlistProduct,
  removeMemberWishlistProductList,
  requestCandidateOwner,
  transferToAnotherOwner, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default MemberWishlistService

