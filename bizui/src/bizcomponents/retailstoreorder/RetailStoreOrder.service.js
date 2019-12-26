
import { get,put,postForm,PREFIX,joinParameters,joinPostParameters } from '../../axios/tools'

const view = (targetObjectId) => {
  return get({
    url: `${PREFIX}retailStoreOrderManager/view/${targetObjectId}/`,
  })
}



const load = (targetObjectId, parameters) => {
  const parametersExpr = joinParameters(parameters)
  return get({
    url: `${PREFIX}retailStoreOrderManager/loadRetailStoreOrder/${targetObjectId}/${parametersExpr}/`,
  })
}



const requestCandidateBuyer = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateBuyer/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherBuyer = (id, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherBuyer/id/anotherBuyerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}



const requestCandidateSeller = (ownerClass, id, filterKey, pageNo) => {
 
  const url = `${PREFIX}retailStoreOrderManager/requestCandidateSeller/ownerClass/id/filterKey/pageNo/`
  const requestParameters = {id, ownerClass,filterKey, pageNo}
  return postForm({url,requestParameters})
}	

const transferToAnotherSeller = (id, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/transferToAnotherSeller/id/anotherSellerId/`
  const requestParameters = {id, ...parameters}
  return postForm({url,requestParameters})
}







const addRetailStoreOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addRetailStoreOrderLineItem/retailStoreOrderId/skuId/skuName/amount/quantity/unitOfMeasurement/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrderLineItem = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateRetailStoreOrderLineItemProperties/retailStoreOrderId/id/skuId/skuName/amount/quantity/unitOfMeasurement/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderLineItemList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeRetailStoreOrderLineItemList/retailStoreOrderId/retailStoreOrderLineItemIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addRetailStoreOrderShippingGroup/retailStoreOrderId/name/amount/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrderShippingGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateRetailStoreOrderShippingGroupProperties/retailStoreOrderId/id/name/amount/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderShippingGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeRetailStoreOrderShippingGroupList/retailStoreOrderId/retailStoreOrderShippingGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addRetailStoreOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addRetailStoreOrderPaymentGroup/retailStoreOrderId/name/cardNumber/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateRetailStoreOrderPaymentGroup = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateRetailStoreOrderPaymentGroupProperties/retailStoreOrderId/id/name/cardNumber/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeRetailStoreOrderPaymentGroupList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeRetailStoreOrderPaymentGroupList/retailStoreOrderId/retailStoreOrderPaymentGroupIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



const addGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/addGoods/retailStoreOrderId/name/rfid/uom/maxPackage/expireTime/skuId/receivingSpaceId/goodsAllocationId/smartPalletId/shippingSpaceId/transportTaskId/retailStoreId/bizOrderId/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const updateGoods = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/updateGoodsProperties/retailStoreOrderId/id/name/rfid/uom/maxPackage/expireTime/tokensExpr/`
  const retailStoreOrderId = targetObjectId
  const requestParameters = { ...parameters, retailStoreOrderId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}

const removeGoodsList = (targetObjectId, parameters) => {
  const url = `${PREFIX}retailStoreOrderManager/removeGoodsList/retailStoreOrderId/goodsIds/tokensExpr/`
  const requestParameters = { ...parameters, retailStoreOrderId: targetObjectId, tokensExpr: 'none' }
  return postForm({ url,requestParameters})
}



// Filter this out when no functions

const  listFunctions = () => {
  return get({
    url: `${PREFIX}retailStoreOrderService/listFunctions/`,
  })
}


const  saveRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderService/save/`,
    data,
  })
}


const  processRequest = (data) => {

  return put({
    url: `${PREFIX}retailStoreOrderService/process/`,
    data,
  })
}

const RetailStoreOrderService = { view,
  load,
  addRetailStoreOrderLineItem,
  addRetailStoreOrderShippingGroup,
  addRetailStoreOrderPaymentGroup,
  addGoods,
  updateRetailStoreOrderLineItem,
  updateRetailStoreOrderShippingGroup,
  updateRetailStoreOrderPaymentGroup,
  updateGoods,
  removeRetailStoreOrderLineItemList,
  removeRetailStoreOrderShippingGroupList,
  removeRetailStoreOrderPaymentGroupList,
  removeGoodsList,
  requestCandidateBuyer,
  requestCandidateSeller,
  transferToAnotherBuyer,
  transferToAnotherSeller, listFunctions, saveRequest, processRequest}
export default RetailStoreOrderService

