
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreMemberManager/view/${targetObjectId}/`,
  })
}
const analyze = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreMemberManager/analyze/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreMemberManager/loadRetailStoreMember/${targetObjectId}/${parametersExpr}/`,
  })
}


const queryCandidates = ({scenarioCode,ownerType,ownerId,listType,groupBy,filterKey,targetType}) => {
  
  const url = `${PREFIX}retailStoreMemberManager/queryCandidates/`
  const data = JSON.stringify({scenarioCode,ownerType,ownerId,listType,groupBy,targetType,filterKey})
  console.log("requestParameters",data)
  return put({url,data})
} 


const requestCandidateOwner = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreMemberManager/requestCandidateOwner/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherOwner = (id, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/transferToAnotherOwner/id/anotherOwnerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/addConsumerOrder/retailStoreMemberId/title/storeId/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateConsumerOrder = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/updateConsumerOrderProperties/retailStoreMemberId/id/title/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeConsumerOrderList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/removeConsumerOrderList/retailStoreMemberId/consumerOrderIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreMemberCoupon = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/addRetailStoreMemberCoupon/retailStoreMemberId/name/number/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreMemberCoupon = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/updateRetailStoreMemberCouponProperties/retailStoreMemberId/id/name/number/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreMemberCouponList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/removeRetailStoreMemberCouponList/retailStoreMemberId/retailStoreMemberCouponIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addMemberWishlist = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/addMemberWishlist/retailStoreMemberId/name/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMemberWishlist = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/updateMemberWishlistProperties/retailStoreMemberId/id/name/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMemberWishlistList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/removeMemberWishlistList/retailStoreMemberId/memberWishlistIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addMemberRewardPoint = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/addMemberRewardPoint/retailStoreMemberId/name/point/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMemberRewardPoint = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/updateMemberRewardPointProperties/retailStoreMemberId/id/name/point/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMemberRewardPointList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/removeMemberRewardPointList/retailStoreMemberId/memberRewardPointIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addMemberRewardPointRedemption = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/addMemberRewardPointRedemption/retailStoreMemberId/name/point/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateMemberRewardPointRedemption = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/updateMemberRewardPointRedemptionProperties/retailStoreMemberId/id/name/point/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeMemberRewardPointRedemptionList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/removeMemberRewardPointRedemptionList/retailStoreMemberId/memberRewardPointRedemptionIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreMemberAddress = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/addRetailStoreMemberAddress/retailStoreMemberId/name/mobilePhone/address/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreMemberAddress = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/updateRetailStoreMemberAddressProperties/retailStoreMemberId/id/name/mobilePhone/address/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreMemberAddressList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/removeRetailStoreMemberAddressList/retailStoreMemberId/retailStoreMemberAddressIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreMemberGiftCard = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/addRetailStoreMemberGiftCard/retailStoreMemberId/name/number/remain/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreMemberGiftCard = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/updateRetailStoreMemberGiftCardProperties/retailStoreMemberId/id/name/number/remain/tokensExpr/`
  const retailStoreMemberId = targetObjectId
  const requestParameters = { ...parameters, retailStoreMemberId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreMemberGiftCardList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreMemberManager/removeRetailStoreMemberGiftCardList/retailStoreMemberId/retailStoreMemberGiftCardIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreMemberId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreMemberService/listFunctions/`,
  })
}


const  initRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberService/init/`,
    data,
  })
}

const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreMemberService/process/`,
    data,
  })
}

const RetailStoreMemberService = { view,
  load,
  analyze,
  addConsumerOrder,
  addRetailStoreMemberCoupon,
  addMemberWishlist,
  addMemberRewardPoint,
  addMemberRewardPointRedemption,
  addRetailStoreMemberAddress,
  addRetailStoreMemberGiftCard,
  updateConsumerOrder,
  updateRetailStoreMemberCoupon,
  updateMemberWishlist,
  updateMemberRewardPoint,
  updateMemberRewardPointRedemption,
  updateRetailStoreMemberAddress,
  updateRetailStoreMemberGiftCard,
  removeConsumerOrderList,
  removeRetailStoreMemberCouponList,
  removeMemberWishlistList,
  removeMemberRewardPointList,
  removeMemberRewardPointRedemptionList,
  removeRetailStoreMemberAddressList,
  removeRetailStoreMemberGiftCardList,
  requestCandidateOwner,
  transferToAnotherOwner, listFunctions, saveRequest,initRequest, processRequest, queryCandidates}
export default RetailStoreMemberService

