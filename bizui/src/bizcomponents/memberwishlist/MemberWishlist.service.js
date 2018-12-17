import { get,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'


const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}memberWishlistManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}memberWishlistManager/loadMemberWishlist/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}memberWishlistManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  //const parametersExpr = joinParameters(parameters)
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


const MemberWishlistService = { view,
  load,
  addMemberWishlistProduct,
  updateMemberWishlistProduct,
  removeMemberWishlistProductList,
  requestCandidateOwner,
  transferToAnotherOwner }
export default MemberWishlistService

